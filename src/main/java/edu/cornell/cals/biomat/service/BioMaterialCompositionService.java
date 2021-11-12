package edu.cornell.cals.biomat.service;

import java.util.List;

import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.dao.BioMaterialComposition;
import edu.cornell.cals.biomat.model.BioMaterialCompositionModel;

public interface BioMaterialCompositionService {
	List<BioMaterialComposition> getComposition(Long materialId);
	List<BioMaterialCompositionModel> getBioMaterialCompositionForFormula(Long meatrialId, BioFormula formula);
}
