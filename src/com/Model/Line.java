package com.Model;

import com.Controller.Complexity.SizeComplexity;
import com.Controller.Complexity.TypeOfComplexity;

public class Line {
	private int lineIndex;
	private String lineContent;
	private Complexity sizeComplexity = new Complexity();
	private Complexity typeOfComplexity = new Complexity();
	private Complexity recursion = new Complexity();
	private Complexity nesting = new Complexity();
	private Complexity inheritance = new Complexity();
	private boolean bracket = false;
	
	public Line(int lineIndex, String lineContent) {
		this.lineIndex = lineIndex;
		this.lineContent = lineContent;
	}
	
	public int getLineIndex() {
		return lineIndex;
	}
	
	public void setLineIndex(int lineIndex) {
		this.lineIndex = lineIndex;
	}
	
	public String getLineContent() {
		return lineContent;
	}
	
	public void setLineContent(String lineContent) {
		this.lineContent = lineContent;
	}

	public Complexity getRecursion() {
		return recursion;
	}

	public void setRecursion(Complexity recursion) {
		this.recursion = recursion;
	}

	public Complexity getNesting() {
		return nesting;
	}

	public void setNesting(Complexity nesting) {
		this.nesting = nesting;
	}

	public Complexity getSizeComplexity() {
		return sizeComplexity;
	}
	
	public Complexity getInheritance() {
		return inheritance;
	}

	public void setSizeComplexity(Complexity sizeComplexity) {
		this.sizeComplexity = sizeComplexity;
	}

	public Complexity getTypeOfComplexity() {
		return typeOfComplexity;
	}

	public void setTypeOfComplexity(Complexity typeOfComplexity) {
		this.typeOfComplexity = typeOfComplexity;
	}

	public void setInheritance(Complexity complexity) {
		inheritance = complexity;
	}

	public void hasBrackets() {
		bracket = true;
	}
	
	public boolean getBracket() {
		return bracket;
	}
}
