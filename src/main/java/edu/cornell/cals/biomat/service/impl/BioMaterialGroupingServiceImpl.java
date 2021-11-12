package edu.cornell.cals.biomat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioGrouping;
import edu.cornell.cals.biomat.dao.BioMaterial;
import edu.cornell.cals.biomat.repository.BioMaterialGroupingRepository;
import edu.cornell.cals.biomat.repository.BioMaterialProcessAndFormRepository;
import edu.cornell.cals.biomat.repository.BioMaterialRepository;
import edu.cornell.cals.biomat.service.BioMaterialGroupingService;

@Service
public class BioMaterialGroupingServiceImpl implements BioMaterialGroupingService{

	@Autowired
	private BioMaterialRepository bioMaterialRepository;
	
	@Autowired
	private BioMaterialGroupingRepository bioMaterialGroupingRepository;
	
	@Autowired
	private BioMaterialProcessAndFormRepository bioMaterialProcessAndFormRepository;
	
	@Override
	public List<BioMaterial> getBioMaterial(String shortDesc) {
		return bioMaterialRepository.getBioMaterial(shortDesc+"%");
	}

	@Override
	public List<BioGrouping> getGroupedNameByName(String groupName) {
		List<BioGrouping> bioGrouping = bioMaterialGroupingRepository.getGroupedNameByName(groupName);
		return bioGrouping;
	}
	
	@Override
	public BioGrouping updateBioMaterialGrouping(BioGrouping bioGrouping) {
		BioGrouping bm =bioMaterialGroupingRepository.save(bioGrouping);
		return bm;
	}
	
	public List<BioGrouping> searchBioGroupNameByBioMaterial(String groupName) {
		List<BioGrouping> listOfGroups = bioMaterialGroupingRepository.searchBioGroupNameByBioMaterial(groupName);
		return listOfGroups;
	}
	
	@Override
	public BioGrouping getPreExstingGroupName(Long id) {
		BioGrouping bioGrouping = bioMaterialGroupingRepository.findByGroupNameUsingGroupId(id);
		return bioGrouping;
	}
	
	@Override
	public BioGrouping getMaterialIsExistOrNot(String groupName) {
		BioGrouping grouping = bioMaterialGroupingRepository.findByMaterialIsExistOrNot(groupName);
		return grouping;
	}
	
	@Override
	public List<BioMaterial> getBioMaterialNameByNameAndProcessAndForm(String bioMaterialName, String process, String form) {
		List<BioMaterial> bioMaterial = null;
		if(bioMaterialName != "" && process == "" && form == "") {
			bioMaterial = bioMaterialRepository.getBioMaterialNameByNameAndProcessAndFormNull(bioMaterialName+"%", process, form);
		}
		else if(bioMaterialName != "" && process != "" && form == "")
		{
			bioMaterial = bioMaterialRepository.getBioMaterialNameByNameAndProcessAndForm(bioMaterialName+"%", "%"+", "+process+","+"%", form);
			if(bioMaterial.isEmpty()) {
				bioMaterial = bioMaterialRepository.getBioMaterialNameByNameAndProcessAndForm(bioMaterialName+"%", "%"+", "+process+"%", form);
			}
		}
		else if(bioMaterialName != "" && process == "" && form != "")
		{
			bioMaterial = bioMaterialRepository.getBioMaterialNameByNameAndProcessAndForm(bioMaterialName+"%", process, "%"+", "+form+","+"%");
			if(bioMaterial.isEmpty()) {
				bioMaterial = bioMaterialRepository.getBioMaterialNameByNameAndProcessAndForm(bioMaterialName+"%", process, "%"+", "+form+"%");
			}
		}
		else if(bioMaterialName != "" && process != "" && form != "")
		{
			bioMaterial = bioMaterialRepository.getBioMaterialNameByNameAndProcessAndFormNotNull(bioMaterialName+"%", "%"+", "+process+"%", "%"+", "+form+","+"%");
			if(bioMaterial.isEmpty()) {
				bioMaterial = bioMaterialRepository.getBioMaterialNameByNameAndProcessAndFormNotNull(bioMaterialName+"%", "%"+", "+process+"%", "%"+", "+form+"%");
			}
		}
		return bioMaterial;
	}
	
	@Override
	public List<BioMaterial> getMaterialNameById(List<Long> commaSeperatedId) {
		List<BioMaterial> biomaterial = bioMaterialRepository.passCommaSeperatedId(commaSeperatedId);
		return biomaterial;
	}

	@Override
	public Map<List<String>, List<String>> getBioMaterialBasedOnProcess(String process) {
		List<String> listOfForm = null;
		List<String> processToUpperCase = new ArrayList<String>();	
		List<String> formToUpperCase = new ArrayList<String>();
		Map<List<String>, List<String>> map = new HashMap<>();	
		List<String> listOfLongDesc = bioMaterialProcessAndFormRepository.getBioMaterialInContainsProcessAvailableOrNot(process+"%");
		listOfLongDesc.remove("");
		if(listOfLongDesc!=null) {
			listOfForm = bioMaterialProcessAndFormRepository.getBioMaterialContainingForm(process+"%");
			listOfForm.forEach(form->{
				formToUpperCase.add(form.toUpperCase());
			});
		}
		listOfLongDesc.forEach(processes->{
			processToUpperCase.add(processes.toUpperCase());
		});
		map.put(processToUpperCase, formToUpperCase);
		return map;
	}

	@Override
	public List<BioMaterial> getBioMaterialNameByName(String bioMaterialName) {
		List<BioMaterial> biomaterial = bioMaterialRepository.getBioMaterialNameByName(bioMaterialName+"%");
		return biomaterial;
	}

	@Override
	public String getGroupDistinctName(String groupName) {
		String groupNames = bioMaterialGroupingRepository.getGroupName(groupName);
		return groupNames;
	}

	@Override
	public List<BioGrouping> getAllBioGroupingBasedOnTheSearch(String groupName) {
		List<BioGrouping> listOfGroup = bioMaterialGroupingRepository.getAllBioGrouping("%"+groupName+"%");
		return listOfGroup;
	}

	@Override
	public BioGrouping getGroupNameAndIdBasedOnId(Long groupId) {
		BioGrouping bg = bioMaterialGroupingRepository.getOne(groupId);
		return bg;
	}
	
	@Override
	public boolean editGroupUsingGroupId(String groupName, String commasMaterial, String userName, String updatedDate) {
		bioMaterialGroupingRepository.editBioGroupingUsingGroupNameAndListOfMaterial(groupName, commasMaterial, userName, updatedDate);
		return true;
	}
	
	@Override
	public boolean deleteBioGroupingMaterialUsingGroupName(String groupName, String nullMaterial) {
		bioMaterialGroupingRepository.deleteBioGroupingMaterialUsingGroupName(groupName, nullMaterial);
		return true;
	}
	
	@Override
	public boolean removeGroupUsingId(Long groupId) {
		bioMaterialGroupingRepository.deleteBioGroupUsingId(groupId);
		if(bioMaterialGroupingRepository.existsById(groupId)) {
			bioMaterialGroupingRepository.deleteById(groupId);
			return true;
		}
		return true;
	}
}
