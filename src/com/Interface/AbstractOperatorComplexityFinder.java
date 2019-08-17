package com.Interface;

import com.Model.Complexity;

public abstract class AbstractOperatorComplexityFinder extends AbstractComplexityFinder {

	protected String[] operators;
	
	public AbstractOperatorComplexityFinder(String line) {
		super(line);
		operators = new String[] {};
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		for (String operator : operators) {
			for(int i = 0; i < line.length()-operator.length(); i++) {
				if(line.substring(i, i+operator.length()).equals(operator)) {
					complexity.addKeyword(operator);
					complexity.increaseScore(1);
				}
			}
		}
		return complexity;
	}

}
