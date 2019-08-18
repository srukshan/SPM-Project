package com.Controller.Complexity.Size;

import com.Interface.AbstractOperatorComplexityFinder;

public class LogicalComplexity extends AbstractOperatorComplexityFinder {
	private String[] operators;
	
	public LogicalComplexity(String line) {
		super(line);
		operators = new String[] { "&&", "||", "!" };
	}
	
	public LogicalComplexity(String line, String[] operators) {
		super(line);
		this.operators = operators;
	}

}
