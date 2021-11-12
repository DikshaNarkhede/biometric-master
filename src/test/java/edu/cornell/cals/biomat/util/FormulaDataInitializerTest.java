package edu.cornell.cals.biomat.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/*
 * Do not run this test, This test actually inserts data into dio_formual table.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FormulaDataInitializerTest {
	@Autowired
	FormulaDataInitializer formulaDataInitializer;
	//@Test
	public void populateFormula() {
		
		//formulaDataInitializer.populateFormula();
		
	}
	
}
