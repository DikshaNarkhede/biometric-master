package edu.cornell.cals.biomat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cornell.cals.biomat.dao.BioObservedPoint;
import edu.cornell.cals.biomat.dao.BioVariable;

@Repository
public interface BioObservedPointRepository extends JpaRepository<BioObservedPoint, Integer> {
	@Query(value="SELECT bop FROM BioObservedPoint bop where bop.xVariableId= :xVariableId and bop.yVariableId= :yVariableId and bop.materialId= :materialId")
    List<BioObservedPoint> getBioObservedPoints(@Param("xVariableId") int xVariableId,@Param("yVariableId") int yVariableId,@Param("materialId") long materialId);
}
