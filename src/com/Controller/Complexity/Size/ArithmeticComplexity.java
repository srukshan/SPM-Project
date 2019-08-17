package com.Controller.Complexity.Size;

import com.Interface.AbstractOperatorComplexityFinder;

public class ArithmeticComplexity extends AbstractOperatorComplexityFinder {
	
	public ArithmeticComplexity(String line) {
		super(line);
		operators = new String[] { "+", "-", "*", "/", "%", "++", "--" };
	}

}
