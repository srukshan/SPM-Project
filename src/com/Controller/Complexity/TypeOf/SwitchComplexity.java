package com.Controller.Complexity.TypeOf;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class SwitchComplexity extends AbstractComplexityFinder{
	private String[] operators;

	public SwitchComplexity(String line) {
		super(line);
		operators = new String[] {"case"};
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		boolean hasCase = false;
		
		for (String operator : operators) {
			for(int i = 0; i < line.length()-operator.length(); i++) {
				if(line.substring(i, i+operator.length()).equals(operator)) {
					hasCase = true;
				}
			}
			
			if(hasCase) {
				for(int j = 0; j < line.length(); j++) {
					if(line.charAt(j) == ':') {
						complexity.addKeyword("switch");
						complexity.addScore(1);
					}
				}
			}
		}
		return complexity;
	}

}
