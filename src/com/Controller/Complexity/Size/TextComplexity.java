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
		int start = -1;
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i)=='"') {
				if(start==-1)
					start=i;
				else {
					complexity.addKeyword(line.substring(start, i+1));
					complexity.addScore(1);
					start=-1;
				}
				
			}
		}
		
		return complexity;
	}

}
