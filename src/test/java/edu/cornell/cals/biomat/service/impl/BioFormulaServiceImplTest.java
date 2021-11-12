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

import edu.cornell.cals.biomat.dao.BioFormula;
import edu.cornell.cals.biomat.service.BioFormulaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BioFormulaServiceImplTest {
		Logger logger = LoggerFactory.getLogger(BioFormulaServiceImplTest.class);
		@Autowired
		BioFormulaService bioFormulaService;

		
		@Test
		public void getBioFormula() {
			Long id = 1l;
			BioFormula bf =bioFormulaService.getBioMaterialFormula(id);
			logger.info("Fetched {} ", bf);
			assertThat( bf.getId()).isEqualTo(id);
		}
		
		
		@Test
		public void getBioFormulaByVariableId() {
			Integer id = 6;
			List<BioFormula> bf =bioFormulaService.getBioFormulaByVariableId(id);
			StringBuffer sb = new StringBuffer();
			bf.forEach(f->sb.append(f.toString()));
			logger.info("Fetched {} {} ", bf.size(), sb.toString());
			assertThat(bf.size()>0);
		}

		@Test
		public void flattenFormula() {
			String flatFormula = bioFormulaService.flattenFormula("K_WATER + K_PROCNT +  K_ICE  + K_FIBTG +  K_FAT + K_CARB  + K_ASH + K_A");
			flatFormula = flatFormula.replaceAll(" ", "");
			logger.info("Formula: " + flatFormula);
			String expectedFlatFormula = 
				"(0.57109 + (1.762 * pow(10,-3) * T) - (6.7036 * pow(10,-6) * pow(T,2)))+" 	+
				"(0.17881- (1.1958* pow(10,-3) * T) - (2.7178 * pow(10,-6) * pow(T,2)))+" 		+
				"(2.21960  - (6.2489 * pow(10,-3) * T) +(1.0154 * pow(10,-4) * pow(T,2)))+" 	+
				"(0.18331- (1.2497* pow(10,-3) * T) - (3.1683* pow(10,-6) * pow(T,2)))+" 		+ 	
				"(0.18071- (2.7604* pow(10,-3) * T) - (1.7749* pow(10,-7) * pow(T,2)))+"		+
				"(0.20141- (1.3874* pow(10,-3) * T) - (4.3312* pow(10,-6) * pow(T,2)))+"		+
				"(0.32961- (1.4011 * pow(10,-3) * T) - (2.9069 * pow(10,-6) * pow(T,2)))+"		+
				"(0.025)";
			expectedFlatFormula = expectedFlatFormula.replaceAll(" ", "");
			logger.info("expectedFlatFormula: " + expectedFlatFormula);
			logger.info(""+flatFormula.equals(expectedFlatFormula));
			assert(flatFormula.equals(expectedFlatFormula)==true);
			
			flatFormula = bioFormulaService.flattenFormula("K_WATER + K_PROCNT");
			flatFormula = flatFormula.replaceAll(" ", "");
			logger.info("Formula: " + flatFormula);
			expectedFlatFormula = 
					"(0.57109 + (1.762 * pow(10,-3) * T) - (6.7036 * pow(10,-6) * pow(T,2)))+" 	+
					"(0.17881- (1.1958* pow(10,-3) * T) - (2.7178 * pow(10,-6) * pow(T,2)))";
			
			expectedFlatFormula = expectedFlatFormula.replaceAll(" ", "");
			logger.info("expectedFlatFormula: " + expectedFlatFormula);
			logger.info(""+flatFormula.equals(expectedFlatFormula));
			assert(flatFormula.equals(expectedFlatFormula)==true);
			/*
			flatFormula = bioFormulaService.flattenFormula("Z");
			flatFormula = flatFormula.replaceAll(" ", "");
			logger.info("Formula: " + flatFormula);
			expectedFlatFormula = "(((1)+2)+2)";
			expectedFlatFormula = expectedFlatFormula.replaceAll(" ", "");
			logger.info("expectedFlatFormula: " + expectedFlatFormula);
			logger.info(""+flatFormula.equals(expectedFlatFormula));
			assert(flatFormula.equals(expectedFlatFormula)==true);
		*/
		}
}
