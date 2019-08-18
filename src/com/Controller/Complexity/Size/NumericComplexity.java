package com.Controller.Complexity.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class NumericComplexity extends AbstractComplexityFinder {
	
	public NumericComplexity(String line) {
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
					line = line.replace(line.substring(start, i+1),"");
					start=-1;
				}
			}
		}
		ArrayList<String> numbers = new ArrayList<String>(Arrays.asList(Pattern.compile("\\b\\d+(?:\\.\\d+)?\\b")
				.matcher(line)
				.results()
				.map(MatchResult::group)
				.toArray(String[]::new))
			);
		
		numbers.forEach(num -> {
			complexity.addKeyword(num);
			complexity.increaseScore(1);
		});
		
		return complexity;
	}

}
