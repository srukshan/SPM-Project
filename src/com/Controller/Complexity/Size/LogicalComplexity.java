package com.Controller.Complexity.Size;

import com.Interface.AbstractOperatorComplexityFinder;

public class LogicalComplexity extends AbstractOperatorComplexityFinder {
	
	public LogicalComplexity(String line) {
		super(line);
		operators = new String[] { "&&", "||", "!" };
	}

}
