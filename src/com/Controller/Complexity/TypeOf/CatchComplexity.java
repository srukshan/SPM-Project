package com.Controller.Complexity.TypeOf;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class CatchComplexity extends AbstractComplexityFinder{

	public CatchComplexity(String line) {
		super(line);
		this.wordList = new String[] {"catch", "for", "switch"};
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		String[] checkLine = getLineWords();
		
		for(String item: wordList) {

			for(String key: checkLine) {
				if(key.equals(item)) {
					if(key.equals("catch")) {
						complexity.addKeyword(key);
						complexity.addScore(1);
					} else {
						complexity.addKeyword(key);
						complexity.addScore(2);
					}
				}
			}
		}
		
		return complexity;
	}

}
