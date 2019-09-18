package com.Controller.Complexity.Size;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class ArithmeticComplexity extends AbstractComplexityFinder {
	
	public ArithmeticComplexity(String line) {
		super(line);
		wordList = new String[] { "+", "-", "*", "/", "%", "++", "--" };
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		Pattern numberPattern = Pattern.compile("[0-9.]*$");
		String tempLine = removeDoubleQuotedString();
		
		for (String operator : wordList) {
			
			for(int i = 0; i < tempLine.length() - operator.length(); i++) {
				
				if(tempLine.substring(i, i + operator.length()).equals(operator)) {					
					if((i == 0 || tempLine.charAt(i - 1) != '=') && tempLine.charAt(i + operator.length()) != '=') {
						String firstPart = tempLine.substring(0, i);
						String secondPart = tempLine.substring(i + operator.length(), tempLine.length());
						
						ArrayList<String> firstPartList = new ArrayList<>();
						ArrayList<String> secondPartList = new ArrayList<>();
						
						Collections.addAll(firstPartList, firstPart.split(" "));
						Collections.addAll(secondPartList, secondPart.split(" "));
						
						firstPart = firstPartList.get(firstPartList.size() - 1);
						secondPart = secondPartList.get(0);
						
						if((isVariable(firstPart) || numberPattern.matcher(firstPart).find()) &&
								(isVariable(secondPart) || numberPattern.matcher(secondPart).find()) &&
								!firstPart.isBlank()) {
							complexity.addKeyword(operator);
							complexity.addScore(1);
						}
					}
				}
			}
		}
		
		return complexity;
	}

}