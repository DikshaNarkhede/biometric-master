package edu.cornell.cals.biomat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.dao.Formula;

@Repository
public interface FormulaRepository extends JpaRepository<Formula, Long> {

	
	@Query(value="SELECT bf FROM BioFormula bf where bf.addedBy = :userId")
    List<BioFormula> getBioFormulaByUserId(@Param("userId") String userId);
	
	@Query(value="SELECT bf FROM BioFormula bf where bf.name like %:name%")
    List<BioFormula> getBioFormulaByName(@Param("name") String name);
}
