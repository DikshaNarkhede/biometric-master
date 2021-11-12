package edu.cornell.cals.biomat.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import edu.cornell.cals.biomat.dao.BioObservedPoint;

public interface BioObservedPointService{
	List<BioObservedPoint> getBioObservedPoints(@Param("xVariableId") int xVariableId,@Param("yVariableId") int yVariableId,@Param("materialId") long materialId);
	
	Map<String,List<Double>> getBioObservedPointsMap(@Param("xVariableId") int xVariableId,@Param("yVariableId") int yVariableId,@Param("materialId") long materialId);
}
