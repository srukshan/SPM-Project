package com.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class CodeFile {
	private String fileName;
	private String filePath;
	private ArrayList<Line> lines;
	private ArrayList<CodeFile> inheritedClasses;
	private ArrayList<CodeFile> implementedInterfaces;
	
	public CodeFile(String filePath) {
		this.filePath = filePath;
		
		File tempFile = new File(filePath);
		this.fileName = tempFile.getName();
		this.lines = new ArrayList<>();
	}
	
	public Iterator<Line> getLinesIterator() {
		return lines.iterator();
	}
	
	public ArrayList<Line> getLines(){
		return lines;
	}
	
	public void setLines(ArrayList<Line> lines) {
		this.lines.addAll(lines);
	}
	
	public void addLines(Line line) {
		this.lines.add(line);
	}
	
	public String getFileName() {
		return fileName;
	}

	public String getFilePath() {
		return filePath;
	}	
}
