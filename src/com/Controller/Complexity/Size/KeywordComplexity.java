package com.Controller.Complexity.Size;

import com.Interface.AbstractOperatorComplexityFinder;

public class KeywordComplexity extends AbstractOperatorComplexityFinder {
	

	
	public KeywordComplexity(String line) {
		super(line);
		operators = new String[] { "import", "void", "double", "int", "float", "String", "println", "cout",
				"if", "for", "while", "switch", "case", "\n", "endl" };
	}
	
	public KeywordComplexity(String line, String[] operators) {
		super(line);
		this.operators = operators;
	}
}
