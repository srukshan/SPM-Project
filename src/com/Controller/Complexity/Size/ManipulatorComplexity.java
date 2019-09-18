package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class ManipulatorComplexity extends AbstractComplexityFinder {
	
	public ManipulatorComplexity(String line) {
		super(line);
		wordList = new String[] { "endl", "\\n", "\\r", "\\t" };
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		String tempLine = removeDoubleQuotedString();
		
		for (String operator : wordList) {
			
			for(int i = 0; i < tempLine.length() - operator.length(); i++) {
				
				if(tempLine.substring(i, i + operator.length()).equals(operator)) {
					complexity.addKeyword(operator);
					complexity.addScore(1);					
				}
			}
		}
		
		return complexity;
	}

}
