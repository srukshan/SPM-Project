package com.Controller.Complexity.TypeOf;

import com.Controller.Complexity.Size.BitwiseComplexity;
import com.Controller.Complexity.Size.LogicalComplexity;
import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class IterativeComplexity extends AbstractComplexityFinder{
	String[] operators;

	public IterativeComplexity(String line) {
		super(line);
		operators = new String[] {"for", "while", "do"};
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		for (String operator : operators) {
			for(int i = 0; i < line.length()-operator.length(); i++) {
				if(line.substring(i, i+operator.length()).equals(operator)) {
					complexity.addKeyword(operator);
					complexity.increaseScore(2);
				}
			}
		}
		
		int start = -1;
		int end = -1;
		
		for(int i = 0; i < line.length(); ++i) {
			if(line.charAt(i) == '(' )
				start = i;
			else if(line.charAt(i) == ')')
				end = i;
		}
		
		if(start != -1 && end != -1 && complexity.getScore() > 0) {
			String conditionText = line.substring(start, end);
			
			LogicalComplexity logicalComplexity = new LogicalComplexity(conditionText, new String[] {"&&", "||"});
			BitwiseComplexity bitwiseComplexity = new BitwiseComplexity(conditionText, new String[] {"&", "|"});
			
			complexity.addKeyword(logicalComplexity.GetComplexity().getKeywords());
			complexity.addKeyword(bitwiseComplexity.GetComplexity().getKeywords());
			complexity.increaseScore(logicalComplexity.GetComplexity().getScore());
			complexity.increaseScore(bitwiseComplexity.GetComplexity().getScore());
			
		}
		return complexity;
	}

}
