package edu.cornell.cals.biomat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cornell.cals.biomat.dao.BioMaterialComposition;
import edu.cornell.cals.biomat.dao.BioMaterialCompositionId;

@Repository
public interface BioMaterialCompositionRepository extends JpaRepository<BioMaterialComposition, BioMaterialCompositionId> {
	
	
	List<BioMaterialComposition> findByIdMaterialId(Long materialId);
	
	
}
