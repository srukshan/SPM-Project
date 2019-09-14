 package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class LogicalComplexity extends AbstractComplexityFinder {
	
	public LogicalComplexity(String line) {
		super(line);
		wordList = new String[] { "&&", "||", "!" };
		removeDoubleQuotedString();
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		for (String operator : wordList) {
			
			for(int i = 0; i < line.length() - operator.length() + 1; i++) {
				
				if(line.substring(i, i + operator.length()).equals(operator)) {
					if(operator.equals("!") && (i == 0 || line.charAt(i - 1) != '=') && line.charAt(i + 1) != '=') {
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
