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
		removeDoubleQuotedString();
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		Pattern numberPattern = Pattern.compile("[0-9.]*$");
		
		for (String operator : wordList) {
			
			for(int i = 0; i < line.length() - operator.length() + 1; i++) {
				
				if(line.substring(i, i + operator.length()).equals(operator)) {					
					if((i == 0 || line.charAt(i - 1) != '=') && line.charAt(i + operator.length()) != '=') {
						String firstPart = line.substring(0, i);
						String secondPart = line.substring(i + operator.length(), line.length());
						
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