package edu.cornell.cals.biomat.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import edu.cornell.cals.biomat.dao.BioVariable;


@RunWith(SpringRunner.class)
@SpringBootTest




public class BioMaterialRestControllerTest {
	Logger logger = LoggerFactory.getLogger(BioMaterialRestControllerTest.class);
	
	@Autowired
	BioMaterialRestController bioMaterialRestController;
	@Test
	public void getVariablesForBioMaterial() throws Exception{
		ResponseEntity<String> s = bioMaterialRestController.getVariablesForBiMaterial("5000");
	}
	@Test
	public void getVariables() throws Exception{
		ResponseEntity<String>   re = bioMaterialRestController.searchBioVariables("th");
		System.out.println(re);;
	}
	
	
	@Test
	public void getBioFormula() throws Exception{
		ResponseEntity<String>   re = bioMaterialRestController.getBioFormula("5000","7", "1");
		System.out.println(re);;
	}

}
