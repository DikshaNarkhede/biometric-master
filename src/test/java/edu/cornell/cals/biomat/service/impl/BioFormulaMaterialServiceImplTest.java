package edu.cornell.cals.biomat.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.dao.BioFormulaMaterial;
import edu.cornell.cals.biomat.dao.BioVariable;
import edu.cornell.cals.biomat.service.BioFormulaMaterialService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BioFormulaMaterialServiceImplTest {

	Logger logger = LoggerFactory.getLogger(BioFormulaMaterialServiceImplTest.class);
	@Autowired
	BioFormulaMaterialService bioFormulaMaterialService;

	
	@Test
	public void getBioFormulaMaterial() {
		Long id = 1l;
		BioFormulaMaterial bfm =bioFormulaMaterialService.getBioFormulaMaterial(id);
		logger.info("Fetched {} ", bfm);
		assertThat(bfm.getId()).isEqualTo(id);
	}
	
	
	@Test
	public void getBioFormulaByVariableId() {
		logger.info("Start");
		List<BioFormulaMaterial> bfmList =bioFormulaMaterialService.getBioFormulaMaterialByMaterialId(5000l);
		logger.info("Fetched {}", bfmList.size());
		Assert.isTrue(bfmList.size()==3, "Should have fetched 3 bioFormulaMaterials");
		
		List<BioVariable> bvList =  bioFormulaMaterialService.getBioVariables(bfmList);
		//bvList.forEach(System.out::println);
		bvList.forEach(bv->logger.info("{}",bv));

		Assert.isTrue(bvList.size()==2,"Variable list size is not Correct");
		
	}

	@Test
	public void getBioVariables() {
		logger.info("Start");
		List<BioVariable> bvList =  bioFormulaMaterialService.getBioVariables(5000l);
		//bvList.forEach(System.out::println);
		bvList.forEach(bv->logger.info("{}",bv));

		Assert.isTrue(bvList.size()==2,"Variable list size is not Correct");
	}

	


	@Test
	public void getBioFormula() {
		logger.info("Start");
		List<BioFormula> bfList =  bioFormulaMaterialService.getBioFormula(5000l,7,1);
		bfList.forEach(bv->logger.info("{}",bv));
		Assert.isTrue(bfList.size()==2,"BioFormula Size is not Correct");
		

	}

	
}
