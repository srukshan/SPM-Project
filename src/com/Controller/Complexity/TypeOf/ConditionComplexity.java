package com.Controller.Complexity.TypeOf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class ConditionComplexity extends AbstractComplexityFinder{
	String[] operators;

	public ConditionComplexity(String line) {
		super(line);
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		
		String[] kList = getLineWords();
		
		for(String item: kList) {
			
			if(item.equals("if")) {
				String regex = "[a-zA-Z$_0-9]+([&]{1,2}|[|]{1,2})[a-zA-Z$_0-9]+";
				Matcher match = Pattern.compile(regex).matcher(removeDoubleQuotedString());
				
				while(match.find()) {
					complexity.addScore(1);
				}
				complexity.addScore(1);
			}
			
			if(item.equals("while")) {
				String regex = "[a-zA-Z$_0-9]+([&]{1,2}|[|]{1,2})[a-zA-Z$_0-9]+";
				Matcher match = Pattern.compile(regex).matcher(removeDoubleQuotedString());
				
				while(match.find()) {
					complexity.addScore(2);
				}
				complexity.addScore(2);
			}
		}
		
		
		return complexity;
	}

}
