package com.Controller.Complexity.Size;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class RelationComplexity extends AbstractComplexityFinder {
	
	public RelationComplexity(String line) {
		super(line);
		wordList = new String[] { "==", "!=", ">", "<", ">=", "<=" };
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		String tempLine = removeDoubleQuotedString();
		
		for (String operator : wordList) {
			
			for(int i = 0; i < tempLine.length() - operator.length(); i++) {
				
				if(tempLine.substring(i, i + operator.length()).equals(operator)) {
					if(operator.equals(">") || operator.equals("<")) {
						if(i == 0) {
							if(tempLine.charAt(i + 1) != '=' && tempLine.charAt(i + 1) != '<' && tempLine.charAt(i + 1) != '>') {
								complexity.addKeyword(operator);
								complexity.addScore(1);
							}
						}
						else if(i >= 1) {
							if(tempLine.charAt(i - 1) != '=' && tempLine.charAt(i - 1) != '>' && tempLine.charAt(i - 1) != '<' &&
									tempLine.charAt(i + 1) != '=' && tempLine.charAt(i + 1) != '<' && tempLine.charAt(i + 1) != '>') 
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
