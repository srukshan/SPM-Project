package com.Interface;

public abstract class AbstractComplexityFinder implements ComplexityFinder {
	protected String line;
	
	public AbstractComplexityFinder(String line) {
		this.line = line;
	}

}
