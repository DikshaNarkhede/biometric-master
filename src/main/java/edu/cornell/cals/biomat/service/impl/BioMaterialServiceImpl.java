package edu.cornell.cals.biomat.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioMaterial;
import edu.cornell.cals.biomat.repository.BioMaterialRepository;
import edu.cornell.cals.biomat.service.BioMaterialService;

@Service
public class BioMaterialServiceImpl implements BioMaterialService{

	@Autowired
	BioMaterialRepository bioMaterialRepository;
	
	@Override
	public BioMaterial getBioMaterial(Long id) {
		BioMaterial bm = bioMaterialRepository.getOne(id);
		return bm;
	}
	
	@Override
	public List<BioMaterial> getBioMaterial(String shortDesc) {
		return bioMaterialRepository.getBioMaterial("%"+shortDesc+"%");
	}

	@Override
	public BioMaterial getBioMaterialByUsdaId(Long usdaId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String,Object> getBioMaterial(Pageable pageable, String shortDesc) {
		Map<String,Object> map = new HashMap<String,Object>();
		int count = bioMaterialRepository.getBioMaterialCount("%"+shortDesc+"%");
		Page<BioMaterial>  bioMaterialPage  = bioMaterialRepository.getBioMaterialWithPagination(pageable,"%"+shortDesc+"%");	
		map.put("count",count);
		map.put("bioMaterialPage",bioMaterialPage);
		return map;
	}

	@Override
	public BioMaterial updateBioMaterial(BioMaterial bioMaterial, String userId) {
		bioMaterial.setUpdatedBy(userId);
		BioMaterial bm =bioMaterialRepository.save(bioMaterial);
		return bm;
	}

	
	@Override
    public List<BioMaterial> getBioMaterialWithFormula(String shortDesc){
		//List<BioMaterial> bioMaterialsWithFormula = bioMaterialRepository.getBioMaterialWithFormula("%"+shortDesc+"%");
		//return bioMaterialsWithFormula ;
		List<BioMaterial> bioMaterialsWithFormula = bioMaterialRepository.getBioMaterial("%"+shortDesc+"%");
		// Filter All Material with Id 0 
		return bioMaterialsWithFormula.stream().filter(bm->bm.getId()!=0).collect(Collectors.toList());
	}

}
