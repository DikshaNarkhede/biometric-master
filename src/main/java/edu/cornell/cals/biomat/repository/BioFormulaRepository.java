package edu.cornell.cals.biomat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cornell.cals.biomat.dao.BioFormula;

@Repository
public interface BioFormulaRepository extends JpaRepository<BioFormula, Long> {

	
	@Query(value="SELECT bf FROM BioFormula bf where bf.addedBy = :userId")
    List<BioFormula> getBioFormulaByUserId(@Param("userId") String userId);
	
	@Query(value="SELECT bf FROM BioFormula bf where bf.variableId = :variableId")
    List<BioFormula> getBioFormulaByVaribleId(@Param("variableId") Integer variableId);

	@Query(value="SELECT bf FROM BioFormula bf where bf.name = :name")
    BioFormula getBioFormulaByName(@Param("name") String name);

	@Query(value="SELECT bf FROM BioFormula bf where bf.name like :search OR bf.formulaDesc like :search")
    List<BioFormula> getBioFormulaByNameOrDesc(@Param("search") String search);

}
