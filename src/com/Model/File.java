package com.Model;

import java.util.Iterator;

public class File {
	private String fileName;
	private Iterator<String> lines;
	
	public File(String filename) {
		this.fileName = filename;
	}
	
	public Iterator<String> GetLineIterator() {
		return lines;
	}
	
	public void SetLines(Iterator<String> lines) {
		this.lines = lines;
	}
	
	public String GetFileName() {
		return fileName;
	}
}
