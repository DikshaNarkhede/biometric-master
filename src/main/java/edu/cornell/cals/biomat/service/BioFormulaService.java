package edu.cornell.cals.biomat.service;

import java.util.List;
import java.util.Map;

import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.model.BioMaterialCompositionModel;
import edu.cornell.cals.biomat.model.formula.BioFormulaForm;

public interface BioFormulaService {
	BioFormula getBioMaterialFormula(Long id);
	List<BioFormula> getBioFormulaByVariableId(Integer variableId);
	BioFormula updateBioMaterialFormula(BioFormulaForm bioFormulaForm,String userId);
	Map<String,List<Double>> getCalculatedDataPoints(Long formulaId, List<BioMaterialCompositionModel> bioMaterialNutrientModelList,Integer dependentVariableId, Integer minRange, Integer maxRange);
	String flattenFormula(String formula);
	boolean isValidFormula(String formula, String formulaName, Map<String,String> errors);
	boolean isValidFormulaWhileEdit(String formulaName, Map<String,String> errors);
	List<BioFormula> getBioFormulaByNameOrDesc(String search);
	List<BioFormula> getBioFormulaByName(String q);
}
