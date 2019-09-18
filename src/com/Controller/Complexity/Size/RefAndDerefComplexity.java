package com.Controller.Complexity.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class RefAndDerefComplexity extends AbstractComplexityFinder{
	
	public RefAndDerefComplexity(String line) {
		super(line);
		wordList = new String[] {"&", "*"}; 
		removeDoubleQuotedString();
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		Pattern numberPattern = Pattern.compile("[0-9.]*$");
		
		
		for (String operator : wordList) {
			
			for(int i = 0; i < line.length() - operator.length(); i++) {
				
				if(line.substring(i, i + operator.length()).equals(operator)) {
					if(i == 0) {
						if(line.charAt(i + 1) != '=' && line.charAt(i + 1) != '*' && line.charAt(i + 1) != '&') {
							complexity.addKeyword(operator);
							complexity.addScore(1);
						}
					}
					else if(i >= 1) {
						if(operator.equals("*")) {
							if(line.charAt(i - 1) != '=' && line.charAt(i - 1) != '*' &&
									line.charAt(i + 1) != '=' && line.charAt(i + 1) != '*') 
							{
								ArrayList<String> temp = new ArrayList<>(Arrays.asList(splitLine(line.substring(0, i))));
								
								String lastToOperator = temp.get(temp.size() - 1);
								
								Matcher matcher = numberPattern.matcher(lastToOperator);
								
								if(!isDataType(lastToOperator) && !isVariable(lastToOperator) && !matcher.find()) {
									complexity.addKeyword(operator);
									complexity.addScore(1);
								}
							}
						}
						else {
							if(line.charAt(i - 1) != '&' &&	line.charAt(i + 1) != '&') 
							{
								complexity.addKeyword(operator);
								complexity.addScore(1);
							}
						}
					}
					
				}
			}
		}		
		
		return complexity;
	}
}
