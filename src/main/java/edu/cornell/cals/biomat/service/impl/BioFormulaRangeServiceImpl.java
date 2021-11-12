package edu.cornell.cals.biomat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioFormulaRange;
import edu.cornell.cals.biomat.repository.BioFormulaRangeRepository;
import edu.cornell.cals.biomat.service.BioFormulaRangeService;


@Service
public class BioFormulaRangeServiceImpl implements BioFormulaRangeService{

	@Autowired
	BioFormulaRangeRepository bioFormulaRangeRepository;

	@Override
	public List<BioFormulaRange> getBioFormulaRangeByFormulaId(Long formulaId) {
		return bioFormulaRangeRepository.getBioFormulaRangeByFormulaId(formulaId);
	}

}
