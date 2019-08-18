package com.Controller;

import java.util.ArrayList;

import com.Controller.Complexity.Size.KeywordComplexity;
import com.Model.Complexity;

public class Memorizer {
	private ArrayList<String> nestingLevel;
	private ArrayList<String> inheritanceLevel;
	private boolean isRecursion;
	
	public Memorizer() {
		nestingLevel = new ArrayList<String>();
		inheritanceLevel = new ArrayList<String>();
		isRecursion = false;
	}
	
	public void Memorize(String line) {
		memorizeNesting(line);
		memorizeInheritance(line);
	}
	
	private void memorizeInheritance(String line) {
		KeywordComplexity keywordComplexity = new KeywordComplexity(line, new String[] {"class", "extends", "implements"});
		
		ArrayList<String> keywords = keywordComplexity.GetComplexity().getKeywordList();
		
		int start, end, counter = -1;
		
		for(int i = 0; i < line.length(); ++i) {
			
		}
	}

	private void memorizeNesting(String line) {
		KeywordComplexity complexity = new KeywordComplexity(line, new String[] {"if", "for", "while", "switch", "else"});
		
		if(complexity.GetComplexity().getKeywordList().size()==1) {
			nestingLevel.add(complexity.GetComplexity().getKeywords());
		}
		
		complexity = new KeywordComplexity(line, new String[] {"}"});
		
		Complexity com = complexity.GetComplexity();
		
		for(int i=0; i<com.getKeywordList().size(); i++) {
			if(nestingLevel.size()!=0)
				nestingLevel.remove(nestingLevel.size()-1);
		}
	}

	public void checkNextRecusion(ArrayList<String> lines, int line) {
		
	}

	public Complexity GetNestingComplexity() {
		return new Complexity(nestingLevel.size(),nestingLevel);
	}
	
	public Complexity GetInheritanceComplexity() {
		Complexity complexity = new Complexity();
		
		return complexity;
	}
	
	public Complexity GetRecursionComplexity() {
		Complexity complexity = new Complexity();
		
		return complexity;
	}
}
