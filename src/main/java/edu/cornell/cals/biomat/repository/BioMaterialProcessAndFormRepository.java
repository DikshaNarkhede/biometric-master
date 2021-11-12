package edu.cornell.cals.biomat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import edu.cornell.cals.biomat.dao.BioProcessForm;

@Repository
public interface BioMaterialProcessAndFormRepository extends JpaRepository<BioProcessForm, Integer> {
	
	@Query(value = "SELECT DISTINCT pf.process FROM bio_material bmat INNER JOIN bio_material_process_form pf WHERE LOCATE(pf.process, bmat.long_desc) > 0 and bmat.long_desc LIKE :processes", nativeQuery = true)
	List<String> getBioMaterialInContainsProcessAvailableOrNot(@Param("processes") String processes);
  
	@Query(value = "SELECT DISTINCT pf.form FROM bio_material bmat INNER JOIN bio_material_process_form pf WHERE LOCATE(pf.form, bmat.long_desc) > 0 and bmat.long_desc LIKE :form", nativeQuery = true)
	List<String> getBioMaterialContainingForm(@Param("form") String form);
}

