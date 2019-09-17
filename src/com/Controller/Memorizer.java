package com.Controller;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.Controller.Complexity.Size.CustomComplexity;
import com.Controller.Complexity.Size.VariableComplexity;
import com.Interface.ComplexityFinder;
import com.Model.Block;
import com.Model.Complexity;
import com.Model.Line;

public class Memorizer {
	private ArrayList<Line> file;
	private Block nestingLevel;
	private ArrayList<String> inheritanceLevel;
	private Block recursions;
	
	public Memorizer(ArrayList<Line> arrayList) {
		this.file = arrayList;
		nestingLevel = new Block(0, "");
		inheritanceLevel = new ArrayList<String>();
		recursions = new Block(0, file.size(), "");
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
		ArrayList<Line> lines = new ArrayList<Line>(file);
		int rstart = -1;
		String rname = "";
		boolean isRecursive = false;
		
		for (int i = 0; i < lines.size(); i++) {
			Line current = removeBackSlashed(removeQuotes(lines.get(i)));
			if(isMultiBracketed(current)) {
				// TODO: 
			}
			else if(isBlockStart(current)) {
				
				Line prev = i==0?null:removeQuotes(lines.get(i-1));
				
				ComplexityFinder complexity = new CustomComplexity(current.getLineContent(), new String[] {"if", "for", "while", "switch", "else", "class", "interface"});
				
				ArrayList<String> type = complexity.GetComplexity().getKeywords();
				 
				 if(type.size()!=0) {
					 nestingLevel.startChild(new Block(current.getLineIndex(),type.get(0)));
					 continue;
				 }
				 if(Pattern.compile("[a-zA-Z]+ [_a-zA-Z$]+[(]").matcher(current.getLineContent()).find()){
					 complexity = new VariableComplexity(current.getLineContent());
					 nestingLevel.startChild(new Block(current.getLineIndex(), "method"));
					 rstart = current.getLineIndex();
					 rname = complexity.GetComplexity().getKeywords().get(0);
					 continue;
				 }
				 
				 complexity = new CustomComplexity(prev.getLineContent(), new String[] {"if", "for", "while", "switch", "else", "class", "interface"});
					
				 type = complexity.GetComplexity().getKeywords();
				 
				 if(type.size()!=0) {
					 nestingLevel.startChild(new Block(current.getLineIndex(),type.get(0)));
					 continue;
				 }
				 
				 if(prev.getLineContent().matches("[a-zA-Z]+ [_a-zA-Z$]+[(]")){
					 complexity = new VariableComplexity(prev.getLineContent());
					 nestingLevel.startChild(new Block(current.getLineIndex(), "method"));
					 rstart = current.getLineIndex();
					 rname = complexity.GetComplexity().getKeywords().get(0);
					 continue;
				 }
				 
			}else if(isBlockEnd(current)) {
				Block block = nestingLevel.endBlock(current.getLineIndex());
				if(block.getStart()==rstart) {
					if(isRecursive) {
						recursions.addChild(new Block(rstart, current.getLineIndex()));
						isRecursive = false;
					}
					rstart=-1;
				}
			}
			String crtln = current.getLineContent();
			if(rstart!=-1 && Pattern.compile("[^.a-zA-Z]+"+rname+"[(]").matcher(crtln).find()) {
				isRecursive = true;
			}
		}
		nestingLevel.endBlock(lines.size());
		recursions.endBlock(lines.size());
		System.out.println("Nesting : " + nestingLevel);
		System.out.println("Recursion : " + recursions);
	}
	
	private boolean isMultiBracketed(Line current) {
		boolean hasBracket = false;
		for(char c : current.getLineContent().toCharArray()) {
			if(c=='{' || c=='}') {
				if(hasBracket)
					return true;
				else
					hasBracket = true;
			}
		}
		return false;
	}

	private Line removeBackSlashed(Line line) {
		String str = line.getLineContent().replaceAll("\\\\[^ ]", "");
		line.setLineContent(str);
		return line;
	}

	private boolean isNesting(Block block) {
		for(String type: new String[] {"if", "for", "while", "switch", "else"}) {
			if(block.getType().equals(type)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isBlockStart(Line current) {
		return current.getLineContent().contains("{");
	}
	
	private boolean isBlockEnd(Line current) {
		return current.getLineContent().contains("}");
	}

//	public void Memorize(String line) {
//		memorizeNesting(line);
//		memorizeInheritance(line);
//	}
//	
//	private void memorizeInheritance(String line) {
//		CustomComplexity keywordComplexity = new CustomComplexity(line, new String[] {"class", "extends", "implements"});
//		
//		if(keywordComplexity.GetComplexity().getKeywords().size()==1) {
//			inheritanceLevel.add(keywordComplexity.GetComplexity().keywordsToString());
//		}
//		
//		ArrayList<String> keywords = keywordComplexity.GetComplexity().getKeywords();
//		
//		int start = -1, end = -1, counter = 0;
//		
//		for(int i = 0; i < line.length(); ++i) {
//			if(line.charAt(i) == '{') {
//				counter++;
//				if(start == -1)
//					start = 1;
//			}
//			if(line.charAt(i) == '}') {
//				counter--;
//				if(counter == 0)
//					end = 1;
//			}
//			
//			if(end == 1 && start == 1) {
//				
//			}
//			
//		}
//	}
//
//	private void memorizeNesting(String line) {
//		KeywordComplexity complexity = new KeywordComplexity(line, new String[] {"if", "for", "while", "switch", "else"});
//		
//		if(complexity.GetComplexity().getKeywordList().size()==1) {
//			nestingLevel.add(complexity.GetComplexity().keywordsToString());
//		}
//		
//		complexity = new KeywordComplexity(line, new String[] {"}"});
//		
//		Complexity com = complexity.GetComplexity();
//		
//		for(int i=0; i<com.getKeywordList().size(); i++) {
//			if(nestingLevel.size()!=0)
//				nestingLevel.remove(nestingLevel.size()-1);
//		}
//	}

	public Complexity GetNestingComplexity(Line line) {
		Complexity complexity = new Complexity();
		
		for(Block block : nestingLevel.getLevels(new ArrayList<Block>(), line)) {
			if(isNesting(block)) {
				complexity.addKeyword(block.getType());
				complexity.addScore(1);
			}
		}
		
		return complexity;
	}
	
	public Complexity GetInheritanceComplexity() {
		return new Complexity(inheritanceLevel.size(),inheritanceLevel);
	}
	
	public Complexity GetRecursionComplexity(Line line) {
		Complexity complexity = new Complexity();
		
		System.out.println(recursions.toString());
		
		if(recursions.getLevels(new ArrayList<Block>(), line).size()>1) {
			complexity.addScore(1);
		}
		
		return complexity;
	}
}
