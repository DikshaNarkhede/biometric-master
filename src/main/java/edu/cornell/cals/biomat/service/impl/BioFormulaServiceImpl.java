package edu.cornell.cals.biomat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.controller.BioMaterialRestController;
import edu.cornell.cals.biomat.dao.BioComposition;
import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.dao.BioVariable;
import edu.cornell.cals.biomat.model.BioMaterialCompositionModel;
import edu.cornell.cals.biomat.model.formula.BioFormulaForm;
import edu.cornell.cals.biomat.repository.BioCompositionRepository;
import edu.cornell.cals.biomat.repository.BioFormulaRepository;
import edu.cornell.cals.biomat.repository.BioObservedPointRepository;
import edu.cornell.cals.biomat.repository.FormulaRepository;
import edu.cornell.cals.biomat.service.BioCompositionService;
import edu.cornell.cals.biomat.service.BioFormulaService;
import edu.cornell.cals.biomat.service.BioVariableService;
import edu.cornell.cals.biomat.util.BalancedParenthesisCheck;
import edu.cornell.cals.biomat.util.ExpressionEvaluator;

@Service
public class BioFormulaServiceImpl implements BioFormulaService{
	
	Logger logger = LoggerFactory.getLogger(BioMaterialRestController.class);
	public static String DATA_POINTS_X = "dataPointsX";
	public static String DATA_POINTS_Y = "dataPointsY";
	@Autowired
	BioFormulaRepository bioFormulaRepository;
	@Autowired
	BioFormulaService bioFormulaService;

	@Autowired
	BioVariableService bioVariableService;
	
	@Autowired
	BioCompositionRepository bioCompositionRepository;
	
	@Autowired
	BioCompositionService bioCompositionService;
	
	@Autowired
	FormulaRepository formulaRepository;
	
	@Autowired
	BioObservedPointRepository bioObservedPointRepository;
	
	@Query(value="SELECT bf FROM BioFormula bf where bf.name like :search OR bf.formulaDesc like :search")
    public List<BioFormula> getBioFormulaByNameOrDesc(String search){
		return bioFormulaRepository.getBioFormulaByNameOrDesc("%"+search +"%");
	}

	/**
	 * A formula is a valid entry if
	 * 1.	Left and Right Parenthesis Match
	 * 2.	Mathematical functions and operators used with in the formula such as *,/,log, exp  etc are defined in  <https://www.objecthunter.net/exp4j/#Introduction>
	 * 3.	Variables used in the formula are defined in the bio_variable (column-  Symbol)
	 * 4.	Variables used in the formula are defined in composition
	 * 5.	If the formula contains another formula, the inner formula must be defined in bio_formula table (name column)
	 * 
	 *  
	 *  
	 * @param formula
	 * @param errors
	 * @return
	 */
	
	public boolean isValidFormula(String formulaName, String formula, Map<String,String> errors) {
		logger.info("Start {},{}",formulaName, formula);
		boolean isValid =true;
		if(!BalancedParenthesisCheck.valid(formula)) {
			logger.info("Formula is invalid. Mismatched Braces");
			errors.put("formula", "There is an error in formula. Does braces match?");
			isValid=false;
		}
		BioFormula bioFormula = bioFormulaRepository.getBioFormulaByName(formulaName);
		
		if(bioFormula != null) {
			logger.info("Formula is invalid. Name Already Taken");
			errors.put("name", "The Formula Name is already taken. Please use another name.");
			isValid=false;
		}
		List<String> variables  = new ArrayList();
		try {
			variables = ExpressionEvaluator.getVariableList(formula);
		}
		catch(Exception ex) {
			logger.info("Formula is invalid. Expression is invalid");
			errors.put("formula", "Formula Expression is invalid. " + ex.getMessage());
			isValid=false;
		}
		List<String> nonVariables = bioVariableService.getNonExistingVariables(variables);  //remove all defined variables
		if(nonVariables.size()>0) {
			nonVariables = getNonExitingFormula(nonVariables); // remove all formula's
		}
		
		if(nonVariables.size()>0) {
			nonVariables = bioCompositionService.getNonExistingTagNames(nonVariables);//remove all composition 
		}
		
		if(nonVariables.size()>0) {
			StringBuffer SB=new StringBuffer();
			nonVariables.forEach(s->{
				SB.append(s+" ");	
			});
			errors.put("formula", "Formula Contains following Undefined variables, formula or bio-material composition : "  + SB.toString());
			isValid=false;
		}
		//if()
		logger.info("Returning {}", isValid);
		return isValid;
	}
	
	public boolean isValidFormulaWhileEdit(String formula, Map<String,String> errors) {
		logger.info("Start {},{}",formula);
		boolean isValid =true;
		if(!BalancedParenthesisCheck.valid(formula)) {
			logger.info("Formula is invalid. Mismatched Braces");
			errors.put("formula", "There is an error in formula. Does braces match?");
			isValid=false;
		}
		List<String> variables  = new ArrayList();
		try {
			variables = ExpressionEvaluator.getVariableList(formula);
		}
		catch(Exception ex) {
			logger.info("Formula is invalid. Expression is invalid");
			errors.put("formula", "Formula Expression is invalid. " + ex.getMessage());
			isValid=false;
		}
		List<String> nonVariables = bioVariableService.getNonExistingVariables(variables);  //remove all defined variables
		if(nonVariables.size()>0) {
			nonVariables = getNonExitingFormula(nonVariables); // remove all formula's
		}
		
		if(nonVariables.size()>0) {
			nonVariables = bioCompositionService.getNonExistingTagNames(nonVariables);//remove all composition 
		}
		
		if(nonVariables.size()>0) {
			StringBuffer SB=new StringBuffer();
			nonVariables.forEach(s->{
				SB.append(s+" ");	
			});
			errors.put("formula", "Formula Contains following Undefined variables, formula or bio-material composition : "  + SB.toString());
			isValid=false;
		}
		//if()
		logger.info("Returning {}", isValid);
		return isValid;
	}
	
	@Override
	public List<BioFormula> getBioFormulaByName(String name) {
		return formulaRepository.getBioFormulaByName(name);
	}
	
	public List<String> getNonExitingFormula(List<String> variableList){
		List<String> nonExistingVariables = new ArrayList();
		variableList.forEach(variable -> {
			BioFormula BF = bioFormulaRepository.getBioFormulaByName(variable);			
			if(BF==null) nonExistingVariables.add(variable);
		});
		
		return nonExistingVariables;
	}
	
	/**
	 * If formula contains another formula, this method will flatten
	 * @param formula
	 * @return
	 */
	public String flattenFormula(String formula) {
		List<String> variablesInFormula = ExpressionEvaluator.getVariableList(formula);
		List<BioFormula> formulaList = getFormulas(variablesInFormula );

		while(!formulaList.isEmpty()) {
			for(BioFormula bf :  formulaList) {
				formula = formula.replaceAll(bf.getName(), "(" + bf.getFormula() + ")");
			}
			variablesInFormula = ExpressionEvaluator.getVariableList(formula);
			formulaList = getFormulas(variablesInFormula );
		}
		return formula;
	}

	
	protected List<BioFormula> getFormulas(List<String> variablesInFormula ){
		List<BioFormula> formulaList = new ArrayList();
		BioFormula bf =null;
		for(String variable : variablesInFormula) {
		if(isStringUpperCase(variable)) {
			bf= bioFormulaRepository.getBioFormulaByName(variable);
			if(bf!=null)		
				formulaList.add(bf);
		}
		}
		return formulaList;
	}

	private static boolean isStringUpperCase(String str){ 
        //convert String to char array
		str = str.replaceAll("[^a-zA-Z]", "");
        char[] charArray = str.toCharArray();
        for(int i=0; i < charArray.length; i++){ 
            //if any character is not in upper case, return false
            if( !Character.isUpperCase( charArray[i] ))
                return false;
        }
        return true;
    }
	
	public Map<String,List<Double>> getCalculatedDataPoints(Long formulaId, 
			List<BioMaterialCompositionModel> bioMaterialCompositionModelList,
			Integer dependentVariableId,
			Integer minRange, Integer maxRange){
		logger.info("getCalculatedDataPoints");
		
		List<Double> dataPointsY = new ArrayList<Double>();
		List<Double> dataPointsX = new ArrayList<Double>();
		
		BioFormula bf =  getBioMaterialFormula(formulaId);
		String dependentVariable = "";
		try {
			BioVariable dv = bioVariableService.getBioVariable(dependentVariableId.intValue());
			dependentVariable = dv.getSymbol();
		}
		catch(EntityNotFoundException | NullPointerException ex) {
			BioComposition bc  = bioCompositionRepository.getOne(dependentVariableId);
			dependentVariable = bc.getTagName();
		}
		
		String formula = bioFormulaService.flattenFormula(bf.getFormula());
		logger.info("flattened Formula: {}" ,formula );
		
		Map<String,Double> valueMap = new HashMap<String,Double>();
		List<Map<String,Double>>  valueMapList = new ArrayList<Map<String,Double>>();
		
		if(bioMaterialCompositionModelList!=null) {
			for (BioMaterialCompositionModel model : bioMaterialCompositionModelList) {
				if(model.getNutrientSymbol().equals(dependentVariable)) 	continue;
				valueMap.put(model.getNutrientSymbol(),Double.parseDouble(model.getUserValue()));
			}
		}
		
		
		int increment = (maxRange - minRange)/10;
		for(int i=0;i<=10;i++) {
			Double datapointX = (double) (minRange + (i*increment));
			valueMap.put(dependentVariable, datapointX);
			double dataPointY = ExpressionEvaluator.eval(formula,valueMap);
			dataPointsX.add(datapointX);
			dataPointsY.add(dataPointY);
		}	
		
		
		Map<String,List<Double>> resultMap = new HashMap<String,List<Double>>();
		resultMap.put(DATA_POINTS_X, dataPointsX);
		resultMap.put(DATA_POINTS_Y , dataPointsY);

		
		
		return resultMap;
	}
	
	protected String substituteVariables(String formula, List<BioMaterialCompositionModel> bioMaterialCompositionModelList) {
		for (BioMaterialCompositionModel model : bioMaterialCompositionModelList) {
			formula = formula.replaceAll(model.getNutrientSymbol(),model.getUserValue());
		}
		return null;
	}
	
	
	@Override
	public BioFormula getBioMaterialFormula(Long id) {
		return bioFormulaRepository.getOne(id);	
	}

	@Override
	public BioFormula updateBioMaterialFormula(BioFormulaForm bioFormulaForm, String userId) {
		BioFormula bioFormula = new BioFormula();
		bioFormula.setId(bioFormulaForm.getId());
		bioFormula.setName(bioFormulaForm.getName().toUpperCase());
		bioFormula.setFormula(bioFormulaForm.getFormula());
		bioFormula.setVariableId(bioFormulaForm.getVariableId());
		bioFormula.setCitation(bioFormulaForm.getCitation());
		bioFormula.setDoi(bioFormulaForm.getDoi());
		bioFormula.setFormulaDesc(bioFormulaForm.getFormulaDesc());
		bioFormula.setIsApproved("0");
		bioFormula.setUpdatedBy(userId);
		bioFormula.setAddedBy(userId);
		BioFormula bf =bioFormulaRepository.save(bioFormula);
		return bf;
	}

	@Override
	public List<BioFormula> getBioFormulaByVariableId(Integer variableId) {
		return bioFormulaRepository.getBioFormulaByVaribleId(variableId);
	}
	
	
}
