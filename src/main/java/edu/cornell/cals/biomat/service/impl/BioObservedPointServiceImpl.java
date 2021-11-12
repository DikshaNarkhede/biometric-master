package edu.cornell.cals.biomat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.cals.biomat.dao.BioObservedPoint;
import edu.cornell.cals.biomat.repository.BioObservedPointRepository;
import edu.cornell.cals.biomat.service.BioObservedPointService;
@Service
public class BioObservedPointServiceImpl implements BioObservedPointService{
	@Autowired
	BioObservedPointRepository bioObservedPointRepository;
	
	@Override
	public List<BioObservedPoint> getBioObservedPoints(int xVariableId, int yVariableId, long materialId) {
		return bioObservedPointRepository.getBioObservedPoints(xVariableId, yVariableId, materialId);
	}

	
	public Map<String,List<Double>> getBioObservedPointsMap(int xVariableId,int yVariableId,long materialId){
		List<BioObservedPoint> list = getBioObservedPoints(xVariableId,yVariableId,materialId);
		List<Double> observedPointsX = new ArrayList();
		List<Double> observedPointsY = new ArrayList();
		for(BioObservedPoint bop : list) {
			observedPointsX.add(bop.getxObservedValue());
			observedPointsY.add(bop.getyObservedValue());
		}
		
		Map<String,List<Double>> map = new HashMap();
		map.put("OBSERVED_POINTS_X", observedPointsX);
		map.put("OBSERVED_POINTS_Y", observedPointsY);
		return map;
	}

}
