package edu.cornell.cals.biomat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioComposition;
import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.dao.BioMaterialComposition;
import edu.cornell.cals.biomat.dao.BioVariable;
import edu.cornell.cals.biomat.model.BioMaterialCompositionModel;
import edu.cornell.cals.biomat.repository.BioCompositionRepository;
import edu.cornell.cals.biomat.repository.BioMaterialCompositionRepository;
import edu.cornell.cals.biomat.repository.BioVariableRepository;
import edu.cornell.cals.biomat.service.BioCompositionService;
import edu.cornell.cals.biomat.service.BioFormulaService;
import edu.cornell.cals.biomat.service.BioMaterialCompositionService;
import edu.cornell.cals.biomat.util.ExpressionEvaluator;

@Service
public class BioMaterialCompositionServiceImpl implements BioMaterialCompositionService{
	@Autowired
	BioMaterialCompositionRepository bioMaterialCompositionRepository;
	
	@Autowired
	BioFormulaService bioFormulaService;
	
	@Autowired
	BioVariableRepository bioVariableRepository;
	
	@Autowired
	BioCompositionService bioCompositionService; 

	@Autowired
	BioCompositionRepository bioCompositionRepository; 

	@Override
	public List<BioMaterialComposition> getComposition(Long materialId) {
		List<BioMaterialComposition>  list =  bioMaterialCompositionRepository.findByIdMaterialId(materialId);
		return list;
	}

	@Override
	public List<BioMaterialCompositionModel> getBioMaterialCompositionForFormula(Long materialId, BioFormula formula) {
		
		// get composition for the Material
		List<BioMaterialComposition>  bioMaterialCompositionList =  bioMaterialCompositionRepository.findByIdMaterialId(materialId);
		
		List<String> variablesList =  ExpressionEvaluator.getVariableList(bioFormulaService.flattenFormula(formula.getFormula()));
		
		List<BioMaterialCompositionModel>bioMaterialNutrientModelList = new ArrayList<BioMaterialCompositionModel>();

		// List Compositions
		List<String> compositionList =  bioCompositionService.getExistingTagNames(variablesList);
		//List of variables
		variablesList =  bioCompositionService.getNonExistingTagNames(variablesList);
		
		// Add the composition data for for every composition in the formula.
		for(String compositionTagName : compositionList) {
			BioMaterialComposition bmc = getBioMaterialComposition(bioMaterialCompositionList, compositionTagName);
			if(bmc==null) {
				// Some compositions may not be present in the material but formula requires it
				// in that case put 0.0 value for that composition
				//this would allow users to enter the composition value
				// Example Compositions AIR and ICE. These composition are not defined in USDA
				// but some formulas require them
				BioMaterialCompositionModel bmnm = new BioMaterialCompositionModel ();
				BioComposition bc = bioCompositionRepository.getBioCompositionByTagName(compositionTagName);
				bmnm.setBioMaterialId(materialId);
				bmnm.setBioNutrientId((long)bc.getId());
				bmnm.setNutrientName(bc.getNutrientDesc());
				bmnm.setNutrientValue(0.0);
				bmnm.setNutrientUnit(bc.getUom()); 
				bmnm.setNutrientSymbol(compositionTagName);
				bioMaterialNutrientModelList.add(bmnm);
			}
			else {
				// Composition is present in the material
				BioMaterialCompositionModel bmnm = new BioMaterialCompositionModel ();
				bmnm.setBioMaterialId(bmc.getBioMaterial().getId());
				bmnm.setBioNutrientId((long)bmc.getBioComposition().getId());
				bmnm.setNutrientName(bmc.getBioComposition().getNutrientDesc());
				bmnm.setNutrientValue(bmc.getNutrientValue());
				bmnm.setNutrientUnit(bmc.getBioComposition().getUom());
				bmnm.setNutrientSymbol(bmc.getBioComposition().getTagName());
				bioMaterialNutrientModelList.add(bmnm);
			}
		}
		

		variablesList
		.stream()
		.forEach( variableInFormula ->{
			BioVariable bv = bioVariableRepository.getVariableBySymbol(variableInFormula);
			BioMaterialCompositionModel bmnm = new BioMaterialCompositionModel ();
			bmnm.setBioMaterialId(materialId);
			bmnm.setBioNutrientId(bv.getId().longValue());
			bmnm.setNutrientName(variableInFormula);
			bmnm.setNutrientValue(0.0);
			bmnm.setNutrientUnit(bv.getUom());
			bmnm.setNutrientSymbol(variableInFormula);
			bioMaterialNutrientModelList.add(bmnm);
		});
		return bioMaterialNutrientModelList;
		
		
	}
	
	
	protected BioMaterialComposition getBioMaterialComposition(List<BioMaterialComposition> bmcList, String tagName) {
		for(BioMaterialComposition bmc : bmcList) {
			if(bmc.getBioComposition().getTagName().equals(tagName)) {
				return bmc;
			}
		}
		return null;
	}

	
	

}
