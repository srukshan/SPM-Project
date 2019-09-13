package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Interface.AbstractOperatorComplexityFinder;
import com.Model.Complexity;

public class ArithmeticComplexity extends AbstractComplexityFinder {
	
	public ArithmeticComplexity(String line) {
		super(line);
		wordList = new String[] { "+", "-", "*", "/", "%", "++", "--" };
	}

	@Override
	public Complexity GetComplexity() {
		// TODO Auto-generated method stub
		return null;
	}

}