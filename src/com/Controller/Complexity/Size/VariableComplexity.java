package com.Controller.Complexity.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;
import com.Model.GlobleVariables;

public class VariableComplexity extends AbstractComplexityFinder {

	ArrayList<String> keywords = new ArrayList<String>(Arrays.asList(GlobleVariables.keywordList));

	public VariableComplexity(String line) {
		super(line);
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		String tempLine = removeDoubleQuotedString();
		
		int start = -1;
		
		for(int i = 0; i < tempLine.length(); i++) {
			if(tempLine.charAt(i)=='"') {
				if(start==-1)
					start=i;
				else {
					tempLine = tempLine.replace(tempLine.substring(start, i+1),"");
					start=-1;
				}
			}
		}
		
		ArrayList<String> variables = new ArrayList<String>(Arrays.asList(Pattern.compile("[a-zA-Z$_][a-zA-Z$_0-9]*")
				.matcher(tempLine)
				.results()
				.map(MatchResult::group)
				.toArray(String[]::new))
			);
		
		variables.removeIf(var -> keywords.contains(var));
		
		variables.forEach(var -> {
			complexity.addKeyword(var);
			complexity.addScore(1);
		});
		
		return complexity;
	}

}
