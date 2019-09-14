package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class CustomComplexity extends AbstractComplexityFinder {
	
	public CustomComplexity(String line, String[] wordList) {
		super(line);
		this.wordList = wordList;
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		
		return complexity;
	}
	
}
