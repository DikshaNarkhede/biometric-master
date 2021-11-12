package edu.cornell.cals.biomat.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cornell.cals.biomat.dao.BioMaterial;
import edu.cornell.cals.biomat.dao.BioVariable;
@Repository
public interface BioVariableRepository extends JpaRepository<BioVariable, Integer> {
	
	@Query(value="SELECT bv FROM BioVariable bv where bv.name like :nm")
    List<BioVariable> getVariable(@Param("nm") String nm);
	
	@Query(value="SELECT count(bv) FROM BioVariable bv where bv.name like :nm")
    Integer getBioVariableCount(@Param("nm") String nm);
	
	@Query(value="SELECT bv FROM BioVariable bv where bv.name like :nm")
	Page<BioVariable> getBioVariableWithPagination(Pageable pageable,@Param("nm") String nm);


	@Query(value="SELECT bv FROM BioVariable bv where bv.name = :nm")
    BioVariable getVariableByName(@Param("nm") String nm);
	
	@Query(value="SELECT bv FROM BioVariable bv where bv.symbol = :symbol")
    BioVariable getVariableBySymbol(@Param("symbol") String symbbol);

	@Query(value="SELECT bv FROM BioVariable bv where bv.symbol in (:symbolList)")
    List<BioVariable> getVariableBySymbolList(@Param("symbolList") List symbbolList);

	@Query(value="SELECT bv FROM BioVariable bv where bv.id = :id")
    BioVariable getVariableById(@Param("id") Integer id);
}
