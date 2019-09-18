package com.Interface;

import java.util.ArrayList;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Model.GlobleVariables;

public abstract class AbstractComplexityFinder implements ComplexityFinder {
	protected String line;
	protected String[] wordList;
	
	public AbstractComplexityFinder(String line) {
		this.line = line.trim();
		this.wordList = new String[] {};
	}
	
	public void removeDoubleQuotedString() {
		String temp = "";
		int startQuote = -1;
		int beginSub = 0;
		
		for(int i = 0; i < line.length(); ++i) {
			if(i == 0) {
				if(line.charAt(i) == '"') {
					if(startQuote == -1) {
						startQuote = i;
						
						temp += line.substring(beginSub, startQuote + 1);
						
					} else {
						beginSub = i;
						startQuote = -1;
						
					}
				}
			} else {
				if(line.charAt(i) == '"' && line.charAt(i - 1) != '\\') {
					if(startQuote == -1) {
						startQuote = i;
						
						temp += line.substring(beginSub, startQuote + 1);
						
					} else {
						beginSub = i;
						startQuote = -1;
						
					}
				}
			}
			
			if(i == line.length() - 1) {
				temp += line.substring(beginSub, line.length());
			}
		}
		
		this.line = temp;
	}
	
	public boolean isVariable(String text) {
		Pattern pattern = Pattern.compile("[a-zA-Z$_][a-zA-Z$_0-9]*");
		Matcher matcher = pattern.matcher(text);		
		String results = text;
		boolean variable = false;
		
		if(matcher.find()) {
			results = matcher.group();
			variable = true;
		}	
		
		for(String item: GlobleVariables.keywordList) {
			if(results.equals(item)) variable = false;
		}
		
		return variable;
	}
	
	public boolean isNumber(String text) {
		Pattern pattern = Pattern.compile("[0-9.]*$");
		Matcher matcher = pattern.matcher(text);		
		
		return matcher.find();
	}
	
	public boolean isDataType(String text) {
		Pattern pattern = Pattern.compile("[a-zA-Z$_][a-zA-Z$_0-9]*");
		Matcher matcher = pattern.matcher(text);
		String results = text;
		
		if(matcher.find())
			results = matcher.group();
		
		boolean dataType = false;
		
		for(String item: GlobleVariables.dataTypeList) {
			if(results.equals(item)) dataType = true;
		}
		
		return dataType;
	}
	
	public String[] getLineWords() {
		return Pattern.compile("[a-zA-Z$_][a-zA-Z$_0-9]*")
				.matcher(line)
				.results()
				.map(MatchResult::group)
				.toArray(String[]::new);
	}
	
	public String[] splitLine() {
		ArrayList<String> temp = new ArrayList<>();
		
		for(String item: line.split(" ")) {
			if(!item.isBlank()) temp.add(item);
		}
		
		return temp.toArray(new String[temp.size()]);
	}
	
	public String[] splitLine(String text) {
		ArrayList<String> temp = new ArrayList<>();
		
		for(String item: text.split(" ")) {
			if(!item.isBlank()) temp.add(item);
		}
		
		return temp.toArray(new String[temp.size()]);
	}

}
