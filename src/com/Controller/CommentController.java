package com.Controller;

import java.util.ArrayList;

import com.Model.CodeFile;
import com.Model.Line;

public class CommentController {
	private CodeFile file;
	
	public CommentController(CodeFile file) {
		this.file = file;
	}
	
	public void RemoveComments() {
		boolean cmt = false;
		ArrayList<Line> oldContent = file.getLines();
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
		file.setLines(newContent);
	}
	
	public CodeFile GetCodeFile() {
		return file;
	}
}
