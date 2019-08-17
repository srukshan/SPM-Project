package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class BitwiseComplexity extends AbstractComplexityFinder {
	String[] operators;
	public BitwiseComplexity(String line) {
		super(line);
		operators = new String[] { "|", "^", "~", "<<", ">>", "<<<", ">>>" };
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		for (String operator : operators) {
			for(int i = 0; i < line.length()-operator.length(); i++) {
				String beforeOperator = i-operator.length()>=0?
						line.substring(i-operator.length(),i):"";
				String atOperator = line.substring(i, i+operator.length());
				if(!beforeOperator.equals(operator)&&atOperator.equals(operator)) {
					complexity.addKeyword(operator);
					complexity.increaseScore(1);
				}
			}
		}
		return complexity;
	}
}
