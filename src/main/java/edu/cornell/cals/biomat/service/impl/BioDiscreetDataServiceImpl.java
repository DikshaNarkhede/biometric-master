package edu.cornell.cals.biomat.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioDiscreetData;
import edu.cornell.cals.biomat.repository.BioDiscreetDataRepository;
import edu.cornell.cals.biomat.service.BioDiscreetDataService;

@Service
public class BioDiscreetDataServiceImpl implements BioDiscreetDataService{
	@Autowired
	BioDiscreetDataRepository bioDiscreetDataRepository;

	@Override
	public List<BioDiscreetData> getAllBioDiscreetData() {
		List<BioDiscreetData> bdd = bioDiscreetDataRepository.getAllBioDiscreetData();
		return bdd;
	}

	@Override
	public BioDiscreetData getBioDiscreetData(Long id) {
		BioDiscreetData bdd = bioDiscreetDataRepository.getBioDiscreetDataById(id);
		return bdd;
	}
}
