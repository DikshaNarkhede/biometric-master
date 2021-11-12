package edu.cornell.cals.biomat.util;

import org.junit.Test;

public class BalancedParenthesisCheckTest {

	@Test
	public void testBalancedParenthesisCheck() {
		String valid01 = "10 * 12 + (6 - 9)"; 
		String valid02 = "(10 * 12) + (6 - 9)";
		String valid03 = "(((10 * 12) + (6 - 9)))";
		String valid04 = "(1 / ((1 / 273.15) - ((8.314  / (333.64 * 18)) * log((((#H2O~/100) - #xb~) / 18) / ((((#H2O~/100) - #xb~) / 18) + ((((#Protein~ + #Carbs~ + #FIBTG~) / 100) / 50000) + (((#GLUS~ / 100) + (#FRUS~ / 100) + (#GALS~ / 100)) / 180.16) + (((#SUCS~ / 100) + (#LACS~ / 100) + (#MALS~ / 100)) / 342.29) + (((#K_pot~ + #Sodium~ + #MG~ + #P~ + #CA~ + #Cl~) / pow(10,5)) / 32.13) + ((((#Nitrate~ / 1000) / 100) + ((#CitAcid~ / 1000) / 100) + ((#MalAcid~ / 1000) / 100) + ((#LacAcid~ / 1000) / 100) + ((#OxAcid~ / 1000) / 100) + ((#VITC~ / 1000) / 100)) / 90.03))))))) - 273";
		String valid05 = "((1 - #a_w~) * (1 + (20.21 - 1) * #a_w~))";
		assert(BalancedParenthesisCheck.valid(valid01));
		assert(BalancedParenthesisCheck.valid(valid02));
		assert(BalancedParenthesisCheck.valid(valid03));
		assert(BalancedParenthesisCheck.valid(valid04));
		assert(BalancedParenthesisCheck.valid(valid05));

		String inValid01 = "10 * 12 + (6 - 9))"; 
		String inValid02 = "(10 * 12) + (6 - 9()";
		String inValid03 = "(((10 * 12) +( (6 - 9)))";
		
		
		assert(!BalancedParenthesisCheck.valid(inValid01));
		assert(!BalancedParenthesisCheck.valid(inValid02));
		assert(!BalancedParenthesisCheck.valid(inValid03));

		
	}
	
}
