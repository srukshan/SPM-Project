package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class KeywordComplexity extends AbstractComplexityFinder {
	
	public KeywordComplexity(String line) {
		super(line);
		wordList = new String[] { "import", "void", "double", "int", "float", "String", "println", "cout",
				"if", "for", "while", "switch", "case", "\n", "endl" };
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		
		return complexity;
	}
	
}
