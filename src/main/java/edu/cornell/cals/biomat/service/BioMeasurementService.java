package edu.cornell.cals.biomat.service;

import java.util.Map;

import org.springframework.data.domain.Pageable;

public interface BioMeasurementService {
	
	//List<BioMeasurement> addBioMaterial(Long materialId,  String citation, String doi, List<MeasurementPair> mpList, String userId);
	Map<String,Object>  getBioMeasurementsByContributor(Pageable pageable, String userName);

}
