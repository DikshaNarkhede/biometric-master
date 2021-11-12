package edu.cornell.cals.biomat.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cornell.cals.biomat.dao.BioGrouping;

@Repository
public interface BioMaterialGroupingRepository extends JpaRepository<BioGrouping, Long> {
	
	@Query(value = "SELECT * FROM bio_groups bg INNER JOIN bio_material bm WHERE FIND_IN_SET(bm.id , bg.materials_in_group) > 0 "
		       + "and bm.short_desc like %:groupName% group by bg.id", nativeQuery = true)		
	public List<BioGrouping> searchBioGroupNameByBioMaterial(@Param("groupName") String groupName);
	
	@Query(value="SELECT bg FROM BioGrouping bg where bg.groupName LIKE :groupName")
	List<BioGrouping> getGroupedNameByName(@Param("groupName") String groupName);
	
	@Query(value = "SELECT bg FROM BioGrouping bg WHERE bg.id=:id")
	public BioGrouping findByGroupNameUsingGroupId(@Param("id") Long id);
	
	@Query(value = "SELECT bg FROM BioGrouping bg WHERE bg.groupName=:groupName")
	public BioGrouping findByMaterialIsExistOrNot(@Param("groupName") String groupName);
	
	@Query(value="SELECT DISTINCT bg.groupName FROM BioGrouping bg WHERE bg.groupName LIKE :groupName")
	String getGroupName(@Param("groupName") String groupName);
	
	@Query(value="SELECT bg FROM BioGrouping bg where bg.groupName like :groupName")
    List<BioGrouping> getAllBioGrouping(@Param("groupName") String groupName);

	@Transactional
	@Modifying
	@Query(value = "UPDATE bio_groups SET materials_in_group =:materialIn, updated_by=:userName, updated_at=:updatedDate WHERE group_name=:groupName", nativeQuery = true)
	void editBioGroupingUsingGroupNameAndListOfMaterial(@Param("groupName") String groupName, @Param("materialIn") String materialIn, @Param("userName") String userName, @Param("updatedDate") String updatedDate);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE bio_groups SET materials_in_group =:materialIn WHERE group_name=:groupName", nativeQuery = true)
	void deleteBioGroupingMaterialUsingGroupName(@Param("groupName") String groupName, @Param("materialIn") String materialIn);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE bio_groups, bio_formula_material FROM bio_groups INNER JOIN bio_formula_material WHERE bio_formula_material.group_id = bio_groups.id and bio_groups.id =:groupId", nativeQuery = true)
	void deleteBioGroupUsingId(@Param("groupId") Long groupId);
}
