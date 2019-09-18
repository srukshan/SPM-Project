package com.Controller.Complexity.TypeOf;

import java.util.ArrayList;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;
import com.Model.Line;

public class IfConditionComplexity {
	private ArrayList<Line> file;

	public IfConditionComplexity(ArrayList<Line> file) {
		this.file = file;
	}

	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		return complexity;
		
	}	
}
