package com.Controller.Complexity.Size;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class RefAndDerefComplexity extends AbstractComplexityFinder{
	
	public RefAndDerefComplexity(String line) {
		super(line);
		removeDoubleQuotedString();
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		ArrayList<String> temp = new ArrayList<>();
		
		Pattern pattern = Pattern.compile("[&*]");
		Matcher matcher = pattern.matcher(line);
		
		for(String item: this.line.split(" ")) {
			if(!item.isBlank()) temp.add(item);
		}
		
		String[] wordArray = temp.toArray(new String[temp.size()]);
		
		if(wordArray != null && matcher.find()) {
			
			for(int i = 0; i < wordArray.length; ++i) {
				String word = wordArray[i].trim();
				
				System.out.println(isDataType(word) +"  "+ word);
				
				if((word.equals("&") || word.equals("*")) 
						&& isVariable(wordArray[i + 1].trim())) 
				{					
					if(i == 0) {
						complexity.addKeyword(word);
						complexity.addScore(1);
					}
					else {
						if(isDataType(wordArray[i - 1].trim()) && word.equals("&")) {
							complexity.addKeyword(word);
							complexity.addScore(1);
						} 
						if(!isDataType(wordArray[i - 1].trim())) {
							complexity.addKeyword(word);
							complexity.addScore(1);
						}
					}
					
				}
				
				else if(word.endsWith("&") && isVariable(wordArray[i + 1].trim())) {
					complexity.addKeyword("&");
					complexity.addScore(1);
				}
				
				else if(word.charAt(0) == '&' && isVariable(word.substring(1))) {
					complexity.addKeyword("&");
					complexity.addScore(1);
				}
				
				else if(word.charAt(0) == '*' && isVariable(word.substring(1))) {
					if(i == 0) {
						complexity.addKeyword("*");
						complexity.addScore(1);
					}
					if(i != 0 && !isDataType(wordArray[i - 1].trim()) && !isVariable(wordArray[i - 1].trim())) {
						complexity.addKeyword("*");
						complexity.addScore(1);
					}
				}
			}
		}
		
		
		return complexity;
	}
}
