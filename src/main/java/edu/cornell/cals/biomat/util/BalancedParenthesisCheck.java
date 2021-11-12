package edu.cornell.cals.biomat.util;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BalancedParenthesisCheck {
	static Logger logger = LoggerFactory.getLogger(BalancedParenthesisCheck.class);
	
	public static boolean valid(String experession) {
		logger.info("Start {} " + experession);
		
		boolean valid = true;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<experession.length();i++) {
			Character ch =  experession.charAt(i);
			if(ch == '(') { 
				stack.push('(');
			}
			else if (ch == ')') {
				if(stack.empty() ) {
					valid = false;
					break;
				}
				else {
					stack.pop();
				}
			}
			else
				continue;
		}
		logger.info("Return  {} " + (valid && stack.isEmpty()));
		return valid && stack.isEmpty();
	}
	
	
	
			
	
}
