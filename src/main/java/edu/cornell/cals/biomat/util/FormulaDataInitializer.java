package edu.cornell.cals.biomat.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.dao.BioFormulaMaterial;
import edu.cornell.cals.biomat.dao.BioMaterial;
import edu.cornell.cals.biomat.dao.Formula;
import edu.cornell.cals.biomat.repository.BioFormulaMaterialRepository;
import edu.cornell.cals.biomat.repository.BioFormulaRepository;
import edu.cornell.cals.biomat.repository.BioMaterialRepository;
import edu.cornell.cals.biomat.repository.FormulaRepository;


@Service
public class FormulaDataInitializer {
	@Autowired
	FormulaRepository formulaRepository;
	
	@Autowired
	BioFormulaRepository bioFormulaRepository;
	
	@Autowired
	BioFormulaMaterialRepository bioFormulaMaterilRepository;
	@Autowired
	BioMaterialRepository bioMaterialRepository;
	
	Logger logger = LoggerFactory.getLogger(FormulaDataInitializer.class);

	public  void populateFormula() {
		logger.info("Start");
		List<Formula> formulaList = formulaRepository.findAll();
		Long id= 1000l;
		formulaList.forEach(formula ->{
			BioFormula bioFormula = new BioFormula();
			
			bioFormula.setName(formula.getName());
			bioFormula.setFormula(this.removeVariableMarkups(formula.getFormulaText()));
			
			
			bioFormula.setVariableId(Integer.parseInt(formula.getFormulaVariable()+""));
			//bioFormula.setDependentVariableId(Integer.parseInt(formula.getDependentVariable()+""));
			
			
			bioFormula.setCitation(formula.getCitations());
			bioFormula.setDoi(formula.getDoi());
			
			bioFormula.setFormulaDesc(formula.getDescription());
			bioFormula.setUpdatedBy("system");
			
			
			
			bioFormula.setIsApproved("0");
			bioFormula.setAddedBy("system");
			bioFormula.setApprovedBy("system");
			
			logger.info("bioFormula {} ",bioFormula);
			bioFormula = bioFormulaRepository.save(bioFormula);
			
			
			
			List<Long> materialIdList = getMaterialIdList(formula.getValidMaterials());
			Long formualId = bioFormula.getId();
			materialIdList.forEach(materialId->{
				try {
					BioMaterial bm  = bioMaterialRepository.getOne(materialId);
					if(bm.getId() != null && bm.getId() == materialId) {
						BioFormulaMaterial BFM = new BioFormulaMaterial();
						BFM.setFormulaId(formualId);
						BFM.setMaterialId(materialId);
						BFM.setUpdatedBy("system");
						BFM.setAddedBy("system");
						BFM.setApprovedBy("system");
						BFM.setIsApproved("0");
						bioFormulaMaterilRepository.save(BFM);
					}
				}
				catch(Exception ex) {
					
				}
			});
			
			logger.info("After Updating bioFormula {} ",bioFormula);
			
			
		});
		
	}
	
	//;;4044;4650;4669;4701;
	public List<Long> getMaterialIdList(String validMaterials){
		 List<Long> tokens = new ArrayList<Long>();
		 StringTokenizer tokenizer = new StringTokenizer(validMaterials, ";");
		    while (tokenizer.hasMoreElements()) {
		        String token = tokenizer.nextToken();
		        try {
		        	long materialId = Long.parseLong(token);
		        	tokens.add(materialId);
		        }
		        catch(Exception ex) {
		        	
		        }
		    }
		    return tokens;	
	}
	
	public String removeVariableMarkups(String formula) {
		formula = formula.replace("#","");
		formula = formula.replace("~","");
		return formula;
		
	}
	
}
