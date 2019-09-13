package com.Model;

import com.Controller.Complexity.SizeComplexity;
import com.Controller.Complexity.TypeOfComplexity;

public class Line {
	private int lineIndex;
	private String lineContent;
	private SizeComplexity sizeComplexity;
	private TypeOfComplexity typeOfComplexity;
	
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
	
	
}
