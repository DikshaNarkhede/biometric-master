package edu.cornell.cals.biomat.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.dao.BioFormulaMaterial;
import edu.cornell.cals.biomat.dao.BioMaterial;

@Repository
public interface BioFormulaMaterialRepository extends JpaRepository<BioFormulaMaterial, Long> {
	
	@Query(value="SELECT bfm FROM BioFormulaMaterial bfm where bfm.materialId = 0 OR bfm.materialId = :materialId")
    List<BioFormulaMaterial> getBioFormulaMaterialByMaterialId(@Param("materialId") Long materialId);
	
	@Query(value="SELECT bfm FROM BioFormulaMaterial bfm where bfm.formulaId = :formulaId")
	List<BioFormulaMaterial> getBioMaterialByFormulaId(@Param("formulaId") Long formulaId);

	@Transactional
	@Modifying
	@Query(value="Delete FROM BioFormulaMaterial bfm where bfm.formulaId = :formulaId and bfm.materialId = :materialId")
	void deleteBioFormulaMaterialByMaterialIdAndFormulaId(@Param("materialId") Long materialId, @Param("formulaId") Long formulaId);
	
	@Transactional
	@Modifying
	@Query(value="Delete FROM BioFormulaMaterial bfm where bfm.formulaId = :formulaId and bfm.groupId = :groupId")
	void deleteBioFormulaMaterialByGroupIdAndFormulaId(@Param("groupId") Long groupId, @Param("formulaId") Long formulaId);

	
	@Query(value="SELECT bfm FROM BioFormulaMaterial bfm where bfm.formulaId = :formulaId")
	List<BioFormulaMaterial> getBioGroupByFormulaId(@Param("formulaId") Long formulaId);
	
	@Query(value="SELECT bfm FROM BioFormulaMaterial bfm where bfm.materialId IN (:commaSeperatdMaterialId) AND bfm.formulaId= :formulaId")
	List<BioFormulaMaterial> getAllMaterialIdBasedOnFormulaId(@Param("commaSeperatdMaterialId") List<Long> commaSeperatdMaterialId, @Param("formulaId") Long formulaId);
	
	@Query(value="SELECT bfm FROM BioFormulaMaterial bfm where bfm.materialId=:materialId AND bfm.formulaId= :formulaId")
	BioFormulaMaterial checkMaterialIsAlreadyPresentOrNot(@Param("materialId") Long materialId, @Param("formulaId") Long formulaId);
}
