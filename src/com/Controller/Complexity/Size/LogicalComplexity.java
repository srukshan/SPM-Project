 package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class LogicalComplexity extends AbstractComplexityFinder {
	
	public LogicalComplexity(String line) {
		super(line);
		wordList = new String[] { "&&", "||", "!" };
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		String tempLine = removeDoubleQuotedString();
		
		for (String operator : wordList) {
			
			for(int i = 0; i < tempLine.length() - operator.length(); i++) {
				
				if(tempLine.substring(i, i + operator.length()).equals(operator)) {
					if(operator.equals("!") && (i == 0 || tempLine.charAt(i - 1) != '=') && tempLine.charAt(i + 1) != '=') {
						complexity.addKeyword(operator);
						complexity.addScore(1);
					}
					if(!operator.equals("!")) {
						complexity.addKeyword(operator);
						complexity.addScore(1);
					}
				}
			}
		}
		return complexity;
	}

}
