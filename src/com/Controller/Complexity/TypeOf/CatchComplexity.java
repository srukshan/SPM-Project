package com.Controller.Complexity.TypeOf;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class CatchComplexity extends AbstractComplexityFinder{

	public CatchComplexity(String line) {
		super(line);
		this.wordList = new String[] {"catch", "if", "while", "do", "for"};
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		String[] checkLine = getLineWords();
		
		for(String item: wordList) {

			for(String key: checkLine) {
				
				if(item.equals("if") || item.equals("catch")) {
					complexity.addKeyword(item);
					complexity.addScore(1);
				} else {
					complexity.addKeyword(item);
					complexity.addScore(2);
				}
			}
		}
		
		return complexity;
	}

}
