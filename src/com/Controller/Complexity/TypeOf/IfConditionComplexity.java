package com.Controller.Complexity.TypeOf;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class IfConditionComplexity extends AbstractComplexityFinder{

	public IfConditionComplexity(String line) {
		super(line);
	}

	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		return complexity;
		
	}	
}
