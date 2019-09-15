package com.Controller;

import java.util.ArrayList;

import com.Model.CodeFile;
import com.Model.Line;

public class CommentController {
	private ArrayList<Line> file;
	
	public CommentController(ArrayList<Line> file) {
		this.file = file;
	}
	
	public void RemoveComments() {
		boolean cmt = false;
		ArrayList<Line> oldContent = new ArrayList<Line>(file);
		ArrayList<Line> newContent = new ArrayList<Line>();
		
		for(Line line: oldContent) {
			char[] oldLine = line.getLineContent().toCharArray();
			StringBuilder newLine = new StringBuilder();
			
			for(int i = 0; i < oldLine.length-1; i++) {
				if(cmt) {
					if(oldLine[i] == '*' && oldLine[i+1] == '/') {
						cmt = false;
						i++;
					}
					continue;
				}else {
					if(oldLine[i] == '/' && oldLine[i+1] == '/') {
						break;
					}
					if(oldLine[i] == '/' && oldLine[i+1] == '*') {
						cmt = true;
						continue;
					}
					newLine.append(oldLine[i]);
				}
			}
			if(!cmt) {
				newLine.append(oldLine[oldLine.length-1]);
			}
			if(newLine.length()!=0) {
				line.setLineContent(newLine.toString());
				newContent.add(line);
			}
		}
		file = newContent;
	}
	
	public ArrayList<Line> GetCodeFile() {
		return file;
	}
}
