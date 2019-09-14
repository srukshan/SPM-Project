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
			
			for(int i = 0; i < line.length() - operator.length() + 1; i++) {
				
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
		
		/*
		 * if(wordArray != null && matcher.find()) {
		 * 
		 * for(int i = 0; i < wordArray.length; ++i) { String word =
		 * wordArray[i].trim();
		 * 
		 * if((word.equals("&") || word.equals("*")) && isVariable(wordArray[i +
		 * 1].trim())) { if(i == 0) { complexity.addKeyword(word);
		 * complexity.addScore(1); } else { if(isDataType(wordArray[i - 1].trim()) &&
		 * word.equals("&")) { complexity.addKeyword(word); complexity.addScore(1); }
		 * if(!isDataType(wordArray[i - 1].trim())) { complexity.addKeyword(word);
		 * complexity.addScore(1); } }
		 * 
		 * }
		 * 
		 * else if(word.endsWith("&") && word.charAt(word.length() - 2) != '&' &&
		 * isVariable(wordArray[i + 1].trim())) { complexity.addKeyword("&");
		 * complexity.addScore(1); }
		 * 
		 * else if(word.charAt(0) == '&' && (word.charAt(1) != '&') &&
		 * isVariable(word.substring(1))) { complexity.addKeyword("&");
		 * complexity.addScore(1); }
		 * 
		 * else if(word.charAt(0) == '*' && word.charAt(1) != '*' &&
		 * isVariable(word.substring(1))) { if(i == 0) { complexity.addKeyword("*");
		 * complexity.addScore(1); } if(i != 0 && !isDataType(wordArray[i - 1].trim())
		 * && !isVariable(wordArray[i - 1].trim())) { complexity.addKeyword("*");
		 * complexity.addScore(1); } } } }
		 */
		
		
		return complexity;
	}
}
