package com.Controller.Complexity.Size;

import com.Interface.AbstractOperatorComplexityFinder;

public class RelationComplexity extends AbstractOperatorComplexityFinder {
	
	public RelationComplexity(String line) {
		super(line);
		operators = new String[] { "==", "!=", ">", "<", ">=", "<=" };
	}

}
