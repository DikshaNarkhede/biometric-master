package edu.cornell.cals.biomat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioVariable;
import edu.cornell.cals.biomat.repository.BioVariableRepository;
import edu.cornell.cals.biomat.service.BioVariableService;

@Service
public class BioVariableServiceImpl implements BioVariableService{
	@Autowired
	BioVariableRepository bioVariableRepository;

	@Override
	public BioVariable getBioVariableBySymbol(String symbol) {
		BioVariable bv =bioVariableRepository.getVariableBySymbol(symbol);
		return bv;
	}
	
	@Override
	public BioVariable getBioVariable(Integer id) {
		BioVariable bv = bioVariableRepository.getVariableById(id);
		return bv;
	}

	@Override
	public List<BioVariable> getBioVariable(String name) {
		List<BioVariable> bvList = bioVariableRepository.getVariable("%"+name+"%");
		return bvList;
	}

	@Override
	public BioVariable updateBioVariable(BioVariable bioVariable, String userId) {
		bioVariable.setAddedBy(userId);
		bioVariable.setUpdatedBy(userId);
		BioVariable bv =bioVariableRepository.save(bioVariable);
		return bv;
	}

	
	@Override
	public Map<String,Object> getBioVariable(Pageable pageable, String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		int count = bioVariableRepository.getBioVariableCount("%"+name+"%");
		Page<BioVariable>  bioVariablePage  = bioVariableRepository.getBioVariableWithPagination(pageable,"%"+name+"%");	
		map.put("count",count);
		map.put("bioVariablePage",bioVariablePage);
		return map;
	}

	public List<String> getNonExistingVariables(List<String> variableList){
		List<String> nonExistingVariables = new ArrayList();
		variableList.forEach(variable -> {
				BioVariable bv  =bioVariableRepository.getVariableBySymbol(variable);
				if(bv==null) nonExistingVariables.add(variable);
		});
		
		return nonExistingVariables;
	}
}
