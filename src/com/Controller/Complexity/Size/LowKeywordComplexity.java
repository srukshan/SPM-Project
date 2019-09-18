package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class LowKeywordComplexity extends AbstractComplexityFinder{
	
	public LowKeywordComplexity(String line) {
		super(line);
		this.wordList = new String[] {"new", "delete", "throw", "throws"};
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		String[] checkLine = getLineWords();
		
		for(String item: wordList) {

			for(String key: checkLine) {
				
				if(item.equals(key)) {
					complexity.addKeyword(item);
					complexity.addScore(1);
				}
			}
		}
		
		return complexity;
	}

}
