package com.Controller.Complexity.Size;

import com.Interface.AbstractOperatorComplexityFinder;

public class MiscellaneousComplexity extends AbstractOperatorComplexityFinder {
	
	public MiscellaneousComplexity(String line) {
		super(line);
		operators = new String[] { ",", "->", ".", "::" };
	}

}
