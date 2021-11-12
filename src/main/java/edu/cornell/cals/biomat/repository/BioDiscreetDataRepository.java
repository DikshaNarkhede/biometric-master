package edu.cornell.cals.biomat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cornell.cals.biomat.dao.BioDiscreetData;
import edu.cornell.cals.biomat.dao.BioFormulaRange;
import edu.cornell.cals.biomat.dao.BioVariable;


@Repository
public interface BioDiscreetDataRepository extends JpaRepository<BioDiscreetData, Integer> {
	@Query(value="SELECT bm FROM BioDiscreetData bm")
	List<BioDiscreetData> getAllBioDiscreetData();
	
	@Query(value="SELECT bd FROM BioDiscreetData bd where bd.id=:id")
	BioDiscreetData getBioDiscreetDataById(Long id);
	
}
