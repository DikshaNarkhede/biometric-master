package edu.cornell.cals.biomat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioComposition;
import edu.cornell.cals.biomat.repository.BioCompositionRepository;
import edu.cornell.cals.biomat.service.BioCompositionService;

@Service
public class BioCompositionServiceImpl implements BioCompositionService {

	@Autowired
	BioCompositionRepository bioCompositionRepository; 
	@Override
	public BioComposition getBioCompositionByTagName(String tagName) {
		return bioCompositionRepository.getBioCompositionByTagName(tagName);
	}
	@Override
	public List<String> getNonExistingTagNames(List<String> tagNameList) {
		List<String> nonExistingTagNames = new ArrayList();
		
		tagNameList.forEach(tagName -> {
			BioComposition bc  =bioCompositionRepository.getBioCompositionByTagName(tagName);
			if(bc==null) nonExistingTagNames.add(tagName);
		});

		
		return nonExistingTagNames;
	}

	@Override
	public List<String> getExistingTagNames(List<String> tagNameList) {
		List<String> existingTagNames = new ArrayList();
		
		tagNameList.forEach(tagName -> {
			BioComposition bc  =bioCompositionRepository.getBioCompositionByTagName(tagName);
			if(bc!=null) existingTagNames.add(tagName);
		});

		
		return existingTagNames;
	}

}
