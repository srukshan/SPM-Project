package com.Controller;

import java.util.ArrayList;

import com.Controller.Complexity.Size.CustomComplexity;
import com.Controller.Complexity.Size.KeywordComplexity;
import com.Interface.ComplexityFinder;
import com.Model.Block;
import com.Model.CodeFile;
import com.Model.Complexity;
import com.Model.Line;

public class Memorizer {
	private CodeFile file;
	private Block nestingLevel;
	private ArrayList<String> inheritanceLevel;
	private Block recursions;
	
	public Memorizer(CodeFile file) {
		this.file = file;
		nestingLevel = new Block(0, file.getLines().size(), "");
		inheritanceLevel = new ArrayList<String>();
		recursions = new Block(0, file.getLines().size(), "");
	}
	
	private void removeComments() {
		CommentController commentController = new CommentController(file);
		commentController.RemoveComments();
		file = commentController.GetCodeFile();
	}
	
	public Line removeQuotes(Line lineObj) {
		String line = lineObj.getLineContent();
		StringBuffer temp = new StringBuffer();
		int startQuote = -1;
		int beginSub = 0;
		
		for(int i = 0; i < line.length(); ++i) {
			if(line.charAt(i) == '"' && line.charAt(i - 1) != '\\') {
				if(startQuote == -1) {
					startQuote = i;
					
					temp.append(line.substring(beginSub, startQuote + 1));
					
				} else {
					beginSub = i;
					startQuote = -1;
					
				}
			}
			if(i == line.length() - 1) {
				temp.append(line.substring(beginSub, line.length()));
			}
		}
		
		lineObj.setLineContent(temp.toString());
		
		return lineObj;
	}
	
	public void checkFile() {
		removeComments();
		ArrayList<Line> lines = file.getLines();
		
		for (int i = 0; i < lines.size(); i++) {
			Line current = removeQuotes(lines.get(i));
			
			if(isBlockStart(current)) {
				Line prev = i==0?null:removeQuotes(lines.get(i-1));
				
				ComplexityFinder complexity = new CustomComplexity(current.getLineContent(), new String[] {"if", "for", "while", "switch", "else", "class", "interface"});
				
				complexity.GetComplexity().getKeywords();
			}
		}
	}
	
	private boolean isBlockStart(Line current) {
		return current.getLineContent().contains("{");
	}

	public void Memorize(String line) {
		memorizeNesting(line);
		memorizeInheritance(line);
	}
	
	private void memorizeInheritance(String line) {
		KeywordComplexity keywordComplexity = new KeywordComplexity(line, new String[] {"class", "extends", "implements"});
		
		if(keywordComplexity.GetComplexity().getKeywordList().size()==1) {
			inheritanceLevel.add(keywordComplexity.GetComplexity().keywordsToString());
		}
		
		ArrayList<String> keywords = keywordComplexity.GetComplexity().getKeywordList();
		
		int start = -1, end = -1, counter = 0;
		
		for(int i = 0; i < line.length(); ++i) {
			if(line.charAt(i) == '{') {
				counter++;
				if(start == -1)
					start = 1;
			}
			if(line.charAt(i) == '}') {
				counter--;
				if(counter == 0)
					end = 1;
			}
			
			if(end == 1 && start == 1) {
				
			}
			
		}
	}

	private void memorizeNesting(String line) {
		KeywordComplexity complexity = new KeywordComplexity(line, new String[] {"if", "for", "while", "switch", "else"});
		
		if(complexity.GetComplexity().getKeywordList().size()==1) {
			nestingLevel.add(complexity.GetComplexity().keywordsToString());
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
		return new Complexity(inheritanceLevel.size(),inheritanceLevel);
	}
	
	public Complexity GetRecursionComplexity() {
		Complexity complexity = new Complexity();
		
		return complexity;
	}
}
