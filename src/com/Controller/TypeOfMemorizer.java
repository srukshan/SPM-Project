package com.Controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.Model.Line;

public class TypeOfMemorizer {
	private ArrayList<Line> file;
	private HashMap<String, Integer> typeOfFinal;
	private String[] checkKeywords = new String[] {"if", "while", "do", "switch"};
	private String[] operators = new String[] {"||", "&&", "|", "&", "(", ")"};

	public TypeOfMemorizer(ArrayList<Line> file) {
		this.file = file;
		this.typeOfFinal = new HashMap<String, Integer>();
	}
	
	public void checkFile() {
		CommentController commentController = new CommentController(file);
		commentController.RemoveComments();
		
		String tempLine;
		
		for(String item: checkKeywords) {
			int conditionsCounter = 1;
			int lineIndex;
			int counter = 0;
			boolean end = false;
			
			for(Line line: file) {
				tempLine = line.removeDoubleQuotedString();				
				
				for(int i = 0; i < tempLine.length() - item.length(); ++i) {
						
					if(tempLine.substring(i, i + item.length()).equals(item)) {
						if(item.equals("if")) {
							
						}
						String restLine = tempLine.substring(i + item.length()).trim();
						
						for(String op: operators) {
							for(int j = 0; j < restLine.length() -op.length(); ++j) {
								if(restLine.substring(j, j + op.length()).equals(op)) {
									if(restLine.charAt(j) == '(') counter++;
									if(restLine.charAt(j) == ')') counter--;
									
									if(restLine.charAt(j) == '|') {
										
									}
								}									
							}
						}
					}
					
					
				}
				
				
			}
		}
	}
}
