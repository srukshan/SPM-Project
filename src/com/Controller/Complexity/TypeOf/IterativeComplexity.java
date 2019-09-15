package com.Controller.Complexity.TypeOf;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class IterativeComplexity extends AbstractComplexityFinder{
	String[] operators;

	public IterativeComplexity(String line) {
		super(line);
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		return complexity;
	}

}
