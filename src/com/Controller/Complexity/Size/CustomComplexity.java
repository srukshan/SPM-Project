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
		
		for (String word : wordList) {
			for(int i = 0; i < line.length()-word.length()+1; i++) {
				if(line.substring(i, i+word.length()).equals(word)) {
					complexity.addKeyword(word);
					complexity.addScore(1);
				}
			}
		}
		return complexity;
	}
	
}
