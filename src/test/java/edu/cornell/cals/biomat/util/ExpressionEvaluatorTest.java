package edu.cornell.cals.biomat.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.cornell.cals.biomat.dao.BioMaterialComposition;
import edu.cornell.cals.biomat.dao.BioVariable;
import edu.cornell.cals.biomat.repository.BioMaterialCompositionRepository;
import edu.cornell.cals.biomat.repository.BioVariableRepository;
@RunWith(SpringRunner.class)
@SpringBootTest

public class ExpressionEvaluatorTest {
	@Autowired
	BioVariableRepository bioVariableRepository;
	@Autowired
	BioMaterialCompositionRepository bioMaterialCompositionRepository;
	@Test
	public void testEval() {
		Map<String,Double> map = new HashMap<String,Double>();
		
		
		map.put("T", 2.0);
		map.put("f", 2.0);
		Double d = ExpressionEvaluator.eval(".4+.00081 * pow( T,2) + .0001*f", map);
		double manualCalc = .4+.00081 * Math.pow( 2.0,2) + .0001*2.0;
		assert(d==manualCalc);

		map = new HashMap<String,Double>();
		map.put("T", 2.0);
		d = ExpressionEvaluator.eval("3^3", map);
		assert(d == Math.pow(3,3));
		
		map = new HashMap<String,Double>();
		map.put("T", 2.0);
		d = ExpressionEvaluator.eval("exp(3)", map);
		//System.out.println(d);
		///System.out.println(Math.pow( 2.718281828,3));;
		//assert(d == Math.pow( 2.718281828,3));

		
		map = new HashMap<String,Double>();
		map.put("T", 2.0);
		d = ExpressionEvaluator.eval("pow( T,2)", map);
		assert(d==4.0);
		

		map = new HashMap<String,Double>();
		map.put("T", 3.0);
		d = ExpressionEvaluator.eval("pow( T,2)", map);
		assert(d==9.0);
		

		map = new HashMap<String,Double>();
		map.put("T", 3.0);
		d = ExpressionEvaluator.eval("pow( T,2) + pow(T1,3)", map);
		assert(d==36.0D);

		map = new HashMap<String,Double>();
		map.put("D_T1", 1.0);
		map.put("T1_k", 2.0);
		map.put("Tk", 3.0);
		map.put("z_T1", 4.0);
		
		d = ExpressionEvaluator.eval("D_T1*10^((T1_k-Tk)/z_T1)", map);
		
		

		
		
		String complexExp = "(1 / ((1 / 273.15) - ((8.314  / (333.64 * 18)) * log((((H2O/100) - xb) / 18) / ((((H2O/100) - xb) / 18) + ((((Protein + Carbs + FIBTG) / 100) / 50000) + (((GLUS / 100) + (FRUS / 100) + (GALS / 100)) / 180.16) + (((SUCS / 100) + (LACS / 100) + (MALS / 100)) / 342.29) + (((K_pot + Sodium + MG + P + CA + Cl) / pow(10,5)) / 32.13) + ((((Nitrate / 1000) / 100) + ((CitAcid / 1000) / 100) + ((MalAcid / 1000) / 100) + ((LacAcid / 1000) / 100) + ((OxAcid / 1000) / 100) + ((VITC / 1000) / 100)) / 90.03))))))) - 273";

		map = new HashMap<String,Double>();
		map.put("H2O", 1.0);
		map.put("xb", 1.0);
		map.put("Protein", 1.0);
		map.put("Carbs", 1.0);
		map.put("FIBTG", 1.0);
		map.put("GLUS", 1.0);
		map.put("FRUS", 1.0);
		map.put("GALS", 1.0);
		map.put("SUCS", 1.0);
		map.put("LACS", 1.0);
		map.put("MALS", 1.0);
		
		map.put("K_pot", 1.0);
		map.put("Sodium", 1.0);
		map.put("MG", 1.0);
		map.put("P", 1.0);
		map.put("CA", 1.0);
		map.put("Cl", 1.0);
		
		map.put("Nitrate", 1.0);
		map.put("CitAcid", 1.0);
		map.put("MalAcid", 1.0);
		map.put("LacAcid", 1.0);
		map.put("OxAcid", 1.0);
		map.put("VITC", 1.0);
		
		d = ExpressionEvaluator.eval(complexExp, map);
		
		manualCalc =(1 / ((1 / 273.15) - ((8.314  / (333.64 * 18)) * Math.log((((1.0/100) - 1.0) / 18) / ((((1.0/100) - 1.0) / 18) + ((((1.0 + 1.0 + 1.0) / 100) / 50000) + (((1.0 / 100) + (1.0 / 100) + (1.0 / 100)) / 180.16) + (((1.0 / 100) + (1.0 / 100) + (1.0 / 100)) / 342.29) + (((1.0 + 1.0 + 1.0 + 1.0 + 1.0 + 1.0) / Math.pow(10,5)) / 32.13) + ((((1.0/ 1000) / 100) + ((1.0/ 1000) / 100) + ((1.0/ 1000) / 100) + ((1.0/ 1000) / 100) + ((1.0 / 1000) / 100) + ((1.0/ 1000) / 100)) / 90.03))))))) - 273;
		assert(d==manualCalc);

	}
	

	
	
		  
	@Test
	public void testGetVariables() {
		List<Map<String,Object>> list = ExpressionEvaluator.getVariables(".4+.00081 * pow(T,2) + .0001*f");
		assert(list.get(0).get(ExpressionEvaluator.KEY_VARIABLE).equals("T"));
		assert(list.get(1).get(ExpressionEvaluator.KEY_VARIABLE).equals("f"));
		assert(list.size()==2);
		
		String complexExp = "(1 / ((1 / 273.15) - ((8.314  / (333.64 * 18)) * log((((H2O/100) - xb) / 18) / ((((H2O/100) - xb) / 18) + ((((Protein + Carbs + FIBTG) / 100) / 50000) + (((GLUS / 100) + (FRUS / 100) + (GALS / 100)) / 180.16) + (((SUCS / 100) + (LACS / 100) + (MALS / 100)) / 342.29) + (((K_pot + Sodium + MG + P + CA + Cl) / pow(10,5)) / 32.13) + ((((Nitrate / 1000) / 100) + ((CitAcid / 1000) / 100) + ((MalAcid / 1000) / 100) + ((LacAcid / 1000) / 100) + ((OxAcid / 1000) / 100) + ((VITC / 1000) / 100)) / 90.03))))))) - 273";
		list= ExpressionEvaluator.getVariables(complexExp);

		assert(list.get(0).get(ExpressionEvaluator.KEY_VARIABLE).equals("H2O"));
		assert(list.get(1).get(ExpressionEvaluator.KEY_VARIABLE).equals("xb"));
		assert(list.get(2).get(ExpressionEvaluator.KEY_VARIABLE).equals("Protein"));
		assert(list.get(3).get(ExpressionEvaluator.KEY_VARIABLE).equals("Carbs"));
		assert(list.get(4).get(ExpressionEvaluator.KEY_VARIABLE).equals("FIBTG"));
		
		assert(list.get(5).get(ExpressionEvaluator.KEY_VARIABLE).equals("GLUS"));
		assert(list.get(6).get(ExpressionEvaluator.KEY_VARIABLE).equals("FRUS"));
		assert(list.get(7).get(ExpressionEvaluator.KEY_VARIABLE).equals("GALS"));
		assert(list.get(8).get(ExpressionEvaluator.KEY_VARIABLE).equals("SUCS"));
		assert(list.get(9).get(ExpressionEvaluator.KEY_VARIABLE).equals("LACS"));
		
		assert(list.get(10).get(ExpressionEvaluator.KEY_VARIABLE).equals("MALS"));
		assert(list.get(11).get(ExpressionEvaluator.KEY_VARIABLE).equals("K_pot"));
		assert(list.get(12).get(ExpressionEvaluator.KEY_VARIABLE).equals("Sodium"));
		assert(list.get(13).get(ExpressionEvaluator.KEY_VARIABLE).equals("MG"));
		assert(list.get(14).get(ExpressionEvaluator.KEY_VARIABLE).equals("P"));
		
		assert(list.get(15).get(ExpressionEvaluator.KEY_VARIABLE).equals("CA"));
		assert(list.get(16).get(ExpressionEvaluator.KEY_VARIABLE).equals("Cl"));
		assert(list.get(17).get(ExpressionEvaluator.KEY_VARIABLE).equals("Nitrate"));
		assert(list.get(18).get(ExpressionEvaluator.KEY_VARIABLE).equals("CitAcid"));
		assert(list.get(19).get(ExpressionEvaluator.KEY_VARIABLE).equals("MalAcid"));
		
		assert(list.get(20).get(ExpressionEvaluator.KEY_VARIABLE).equals("LacAcid"));
		assert(list.get(21).get(ExpressionEvaluator.KEY_VARIABLE).equals("OxAcid"));
		assert(list.get(22).get(ExpressionEvaluator.KEY_VARIABLE).equals("VITC"));

		assert(list.size()==23);
		
		list = ExpressionEvaluator.getVariables("(5.12  * pow(10,-6)) * exp((2215.65 / Tk))");
		assert(list.get(0).get(ExpressionEvaluator.KEY_VARIABLE).equals("Tk"));
		assert(list.size()==1);

	}


	//0. check balanced parenthesis
	//1. Get variables in the formuls
	//2. validate if all the variable are in the database
	@Test
	public void validateFormula() {
		String formula = "((Protein + Carbs + FIBTG) / 100) / 50000 + (((GLUS / 100) + (FRUS / 100) + (GALS / 100)) / 180.16) + (((SUCS / 100) + (LACS / 100) + (MALS / 100)) / 342.29) + (((K_pot + Sodium + MG + P + CA + Cl) / pow(10,5)) / 39.00)  + ((((Nitrate / 1000) / 100) + ((CitAcid / 1000) / 100) + ((MalAcid / 1000) / 100) + ((LacAcid / 1000) / 100) + ((OxAcid / 1000) / 100) + ((VITC / 1000) / 100)) / 163.10)";
		assert(BalancedParenthesisCheck.valid(formula));
		
		List<Map<String,Object>> list = ExpressionEvaluator.getVariables(formula);
		list.forEach(map->{
			
			BioVariable bv = bioVariableRepository.getVariableBySymbol((String)map.get("variable"));
			if(bv!=null && bv.getId()>0)
				System.out.println("Present "+ map.get("variable"));	
			else
				System.out.println("NOT Present "+ map.get("variable"));
		});
		
		list.forEach(map->{
				System.out.print(map.get("variable") +",");	
		});
		list.forEach(map->{
			
			BioVariable bv = bioVariableRepository.getVariableBySymbol((String)map.get("variable"));
			System.out.print(bv.getId() + ",");
		});
		

		List <BioMaterialComposition> bmnList = bioMaterialCompositionRepository.findByIdMaterialId(9004l);
		System.out.println("\nSIZE" + bmnList.size());
		assert(list.size()>0);
		
		
		
	}
	
}
