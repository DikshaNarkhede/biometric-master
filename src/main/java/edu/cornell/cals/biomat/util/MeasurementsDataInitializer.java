package edu.cornell.cals.biomat.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.repository.BioMaterialRepository;
import edu.cornell.cals.biomat.repository.BioVariableRepository;



@Service
public class MeasurementsDataInitializer {
	
	@Autowired
	BioVariableRepository bioVariableRepository;
	
	Logger logger = LoggerFactory.getLogger(MeasurementsDataInitializer.class);
/*
	public  void populate() {
		logger.info("Start");
		List<Measurements> measurmentsList = measurementsRepository.findAll();
		//Measurements measurmentsList = measurementsRepository.findById(633045);
		logger.info("Fetched Data");
		
		measurmentsList.forEach(measurement ->{
			BioMeasurement bioMeasurement = new BioMeasurement();
			
			
			bioMeasurement.setMaterialId((long)measurement.getMaterialId());
			bioMeasurement.setVariableId(measurement.getVariableId());
			bioMeasurement.setGroupId(-1);
			bioMeasurement.setMeasuredValue(measurement.getValue());
			bioMeasurement.setErrorValue(measurement.getError());
			
			bioMeasurement.setCitation(measurement.getCitations());
			bioMeasurement.setDoi(measurement.getdOI());
			//bioMeasurement.setIsApproved(""+measurement.getIsApproved());
			try {
				BioMaterial bm  = bioMaterialRepository.getOne((long)measurement.getMaterialId());
				long id= bm.getId();
				String desc= bm.getShortDesc();
				BioVariable bv  = bioVariableRepository.getOne(measurement.getVariableId());
				if(bm.getId() != null && bm.getId() == (long)measurement.getMaterialId() && bv!=null && bv.getId()!=null) {
					bioMeasurementRepository.save(bioMeasurement);
					logger.info("Saving " + bioMeasurement.getMaterialId());
				}
				else {
					logger.info("NOT Saving " + bioMeasurement.getMaterialId());
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}
	*/
}
