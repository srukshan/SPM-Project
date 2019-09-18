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
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		Pattern numberPattern = Pattern.compile("[0-9.]*$");
		String tempLine = removeDoubleQuotedString();
		
		for (String operator : wordList) {
			
			for(int i = 0; i < tempLine.length() - operator.length(); i++) {
				
				if(tempLine.substring(i, i + operator.length()).equals(operator)) {
					if(i == 0) {
						if(tempLine.charAt(i + 1) != '=' && tempLine.charAt(i + 1) != '*' && tempLine.charAt(i + 1) != '&') {
							complexity.addKeyword(operator);
							complexity.addScore(1);
						}
					}
					else if(i >= 1) {
						if(operator.equals("*")) {
							if(tempLine.charAt(i - 1) != '=' && tempLine.charAt(i - 1) != '*' &&
									tempLine.charAt(i + 1) != '=' && tempLine.charAt(i + 1) != '*') 
							{
								ArrayList<String> temp = new ArrayList<>(Arrays.asList(splitLine(tempLine.substring(0, i))));
								
								String lastToOperator = temp.get(temp.size() - 1);
								
								Matcher matcher = numberPattern.matcher(lastToOperator);
								
								if(!isDataType(lastToOperator) && !isVariable(lastToOperator) && !matcher.find()) {
									complexity.addKeyword(operator);
									complexity.addScore(1);
								}
							}
						}
						else {
							if(tempLine.charAt(i - 1) != '&' &&	tempLine.charAt(i + 1) != '&') 
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
