package edu.cornell.cals.biomat.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.cornell.cals.biomat.service.BioMeasurementService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BioMeasurementServiceImplTest {
		Logger logger = LoggerFactory.getLogger(BioMeasurementServiceImplTest.class);
		@Autowired
		BioMeasurementService bioMeasurementService;
		
		@Test
		public void getBioMaterial() {
			/*
			List<BioMeasurement> list =bioMeasurementService.getBioMeasurementsByContributor("kvrayudu@gmail.com");
			assertThat(list.size()>0);
			logger.info(list.get(0).toString());
			*/
			
		}
}
