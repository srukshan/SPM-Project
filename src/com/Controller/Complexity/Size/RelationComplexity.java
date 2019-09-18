package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class RelationComplexity extends AbstractComplexityFinder {
	
	public RelationComplexity(String line) {
		super(line);
		wordList = new String[] { "==", "!=", ">", "<", ">=", "<=" };
		removeDoubleQuotedString();
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		for (String operator : wordList) {
			
			for(int i = 0; i < line.length() - operator.length(); i++) {
				
				if(line.substring(i, i + operator.length()).equals(operator)) {
					if(operator.equals(">") || operator.equals("<")) {
						if(i == 0) {
							if(line.charAt(i + 1) != '=' && line.charAt(i + 1) != '<' && line.charAt(i + 1) != '>') {
								complexity.addKeyword(operator);
								complexity.addScore(1);
							}
						}
						else if(i >= 1) {
							if(line.charAt(i - 1) != '=' && line.charAt(i - 1) != '>' && line.charAt(i - 1) != '<' &&
								line.charAt(i + 1) != '=' && line.charAt(i + 1) != '<' && line.charAt(i + 1) != '>') 
							{
								complexity.addKeyword(operator);
								complexity.addScore(1);
							}
						}
					}
					if(!operator.equals(">") && !operator.equals("<")) {
						complexity.addKeyword(operator);
						complexity.addScore(1);
					}					
				}
			}
		}
		
		return complexity;
	}

}
