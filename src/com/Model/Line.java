package com.Model;

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
	
	public void hasBracket() {
		bracket = true;
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

	public void setSizeComplexity(Complexity sizeComplexity) {
		this.sizeComplexity = sizeComplexity;
	}

	public Complexity getTypeOfComplexity() {
		return typeOfComplexity;
	}

	public void setTypeOfComplexity(Complexity typeOfComplexity) {
		this.typeOfComplexity = typeOfComplexity;
	}
	
	public String removeDoubleQuotedString() {
		String temp = "";
		int startQuote = -1;
		int beginSub = 0;
		
		for(int i = 0; i < lineContent.length(); ++i) {
			if(i == 0) {
				if(lineContent.charAt(i) == '"') {
					if(startQuote == -1) {
						startQuote = i;
						
						temp += lineContent.substring(beginSub, startQuote + 1);
						
					} else {
						beginSub = i;
						startQuote = -1;
						
					}
				}
			} else {
				if(lineContent.charAt(i) == '"' && lineContent.charAt(i - 1) != '\\') {
					if(startQuote == -1) {
						startQuote = i;
						
						temp += lineContent.substring(beginSub, startQuote + 1);
						
					} else {
						beginSub = i;
						startQuote = -1;
						
					}
				}
			}
			
			if(i == lineContent.length() - 1) {
				temp += lineContent.substring(beginSub, lineContent.length());
			}
		}
		
		return temp;
	}

	public Complexity getInheritance() {
		return inheritance;
	}

	public void setInheritance(Complexity inheritance) {
		this.inheritance = inheritance;
	}

	public boolean getBracket() {
		return bracket;
	}
}
