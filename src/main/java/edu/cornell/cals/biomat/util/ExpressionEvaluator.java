package edu.cornell.cals.biomat.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.tokenizer.UnknownFunctionOrVariableException;

public class ExpressionEvaluator {
	static Logger logger = LoggerFactory.getLogger(ExpressionEvaluator.class);
	
	public static final String KEY_VARIABLE = "variable";
	public static final String KEY_POS 		= "position";
	
	
	public static Double eval(String expression, Map<String,Double> valueMap) {
		logger.info("Start eval {} {}" +expression, valueMap);
		Expression exp = new ExpressionBuilder(expression).variables(valueMap.keySet()).build();
		exp.setVariables(valueMap);
		logger.info("Returning  {} " +exp.evaluate());
		return exp.evaluate();
	}

	public static List<Double> eval(String expression, List<Map<String,Double>>  valueMapList) {
		logger.info("Start eval {} {}" +expression, valueMapList);
		List<Double> eavaluatedValues = new ArrayList<Double> ();
		
		valueMapList.forEach(valueMap->{
			eavaluatedValues.add(eval(expression,valueMap));
		});
		
		return eavaluatedValues;
	}
	
	/*
	 * Bastardizing ExpressionEvaluator to get what we want....
	 * 
	 * If Expression Evaluator throws exception, it means that there exis one variable.
	 * in the Catch Block we fetch the variable and add it to the list.
	 * If the Expression is evaluated to something, the value of D will not be null. 
	 */
	public static List<Map<String,Object>> getVariables(String expression) {
		logger.info("Start getVariables {} " +expression);
		Map<String,Double> map = new HashMap<String,Double>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();  
		
		Double d = null;
		while(true) {
			try {
				d = ExpressionEvaluator.eval(expression, map);
			}
			catch(UnknownFunctionOrVariableException ex) {
				Map<String,Object> variableMap =  new HashMap<String,Object>();
				map.put(ex.getToken(), 1.0); // substitute 1.0 for the current token. just to move forward
				variableMap.put(KEY_VARIABLE,ex.getToken());
				variableMap.put(KEY_POS,ex.getPosition());
				list.add(variableMap);
			}
			if(d!=null) break;
		}
		logger.info("returning list of variables {} " +list);
		return list;
	}
	
	
	public static List<String> getVariableList(String expression) {
		logger.info("Start getVariableList {} " +expression);
		List<String> list = new ArrayList<String>();
		List<Map<String,Object>> listMap = getVariables(expression);
		listMap.stream().forEach(map -> list.add(map.get(KEY_VARIABLE).toString()));
		return list;
	}
}
