package com.Controller.Complexity.Size;

import com.Interface.AbstractOperatorComplexityFinder;

public class ManipulatorComplexity extends AbstractOperatorComplexityFinder {
	
	public ManipulatorComplexity(String line) {
		super(line);
		operators = new String[] { "endl", "\\n", "\\r", "\\t" };
	}

}
