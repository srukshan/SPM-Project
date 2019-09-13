package com.Controller.Complexity.TypeOf;

import com.Controller.Complexity.Size.BitwiseComplexity;
import com.Controller.Complexity.Size.LogicalComplexity;
import com.Interface.AbstractOperatorComplexityFinder;
import com.Model.Complexity;

public class IfConditionComplexity extends AbstractOperatorComplexityFinder{

	public IfConditionComplexity(String line) {
		super(line);
		operators = new String[] {"if"};
	}

	public Complexity GetComplexity() {
		Complexity complexitySuper = super.GetComplexity();
		Complexity complexity = new Complexity();
		
		int start = -1;
		int end = -1;
		
		for(int i = 0; i < line.length(); ++i) {
			if(line.charAt(i) == '(' )
				start = i;
			else if(line.charAt(i) == ')')
				end = i;
		}
		
		if(start != -1 && end != -1 && complexitySuper.getScore() > 0) {
			String conditionText = line.substring(start, end);
			
			LogicalComplexity logicalComplexity = new LogicalComplexity(conditionText, new String[] {"&&", "||"});
			BitwiseComplexity bitwiseComplexity = new BitwiseComplexity(conditionText, new String[] {"&", "|"});
			
			complexity.addKeyword(logicalComplexity.GetComplexity().keywordsToString());
			complexity.addKeyword(bitwiseComplexity.GetComplexity().keywordsToString());
			complexity.addKeyword(complexitySuper.keywordsToString());
			complexity.addScore(logicalComplexity.GetComplexity().getScore());
			complexity.addScore(bitwiseComplexity.GetComplexity().getScore());
			complexity.addScore(complexitySuper.getScore());
			
		}
		
		return complexity;
		
	}
	
	
}
