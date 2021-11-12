package edu.cornell.cals.biomat.service;

import java.util.List;

import edu.cornell.cals.biomat.dao.BioFormulaRange;

public interface BioFormulaRangeService {
	List<BioFormulaRange> getBioFormulaRangeByFormulaId(Long formulaId);

}
