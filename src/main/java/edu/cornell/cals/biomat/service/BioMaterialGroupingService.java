package edu.cornell.cals.biomat.service;

import java.util.List;
import java.util.Map;

import edu.cornell.cals.biomat.dao.BioGrouping;
import edu.cornell.cals.biomat.dao.BioMaterial;

public interface BioMaterialGroupingService {
	List<BioMaterial> getBioMaterial(String desc);
	List<BioGrouping> getGroupedNameByName(String groupName);
	BioGrouping updateBioMaterialGrouping(BioGrouping bioGrouping);
	List<BioGrouping> searchBioGroupNameByBioMaterial(String groupName);
    BioGrouping getPreExstingGroupName(Long id);
    BioGrouping getMaterialIsExistOrNot(String groupName);
    List<BioMaterial> getBioMaterialNameByNameAndProcessAndForm(String bioMaterialName, String process, String form);
    List<BioMaterial> getBioMaterialNameByName(String bioMaterialName);
    List<BioMaterial> getMaterialNameById(List<Long> commaSeperatedId);
	Map<List<String>, List<String>> getBioMaterialBasedOnProcess(String process);
	String getGroupDistinctName(String groupName);
    List<BioGrouping> getAllBioGroupingBasedOnTheSearch(String groupName);
    BioGrouping getGroupNameAndIdBasedOnId(Long groupId);
    boolean editGroupUsingGroupId(String groupName, String commasMaterial, String userName, String updatedDate);
    boolean deleteBioGroupingMaterialUsingGroupName(String groupName, String nullMaterial);
    public boolean removeGroupUsingId(Long groupId);
}
