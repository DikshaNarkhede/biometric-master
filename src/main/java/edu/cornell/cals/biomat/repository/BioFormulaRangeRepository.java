package edu.cornell.cals.biomat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cornell.cals.biomat.dao.BioFormulaRange;

@Repository
public interface BioFormulaRangeRepository extends JpaRepository<BioFormulaRange, Long> {
		
		@Query(value="SELECT bfr FROM BioFormulaRange bfr where bfr.formulaId = :formulaId")
	    List<BioFormulaRange> getBioFormulaRangeByFormulaId(@Param("formulaId") Long formulaId);

		@Query(value="DELETE FROM BioFormulaRange bfr where bfr.formulaId = :formulaId")
	    List<BioFormulaRange> deleteByFormulaId(@Param("formulaId") Long formulaId);
		
}
	