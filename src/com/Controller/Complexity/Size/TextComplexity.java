package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class TextComplexity extends AbstractComplexityFinder {

	public TextComplexity(String line) {
		super(line);
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		String tempLine = removeDoubleQuotedString();
		
		int start = -1;
		
		for(int i = 0; i < tempLine.length(); i++) {
			if(tempLine.charAt(i) == '"') {
				if(start==-1)
					start=i;
				else {
					complexity.addKeyword(tempLine.substring(start, i+1));
					complexity.addScore(1);
					start=-1;
				}
				
			}
		}
		
		return complexity;
	}

}
