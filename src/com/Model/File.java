package com.Model;

import java.util.ArrayList;
import java.util.Iterator;

public class File {
	private String fileName;
	private ArrayList<String> lines;
	
	public File(String filename) {
		this.fileName = filename;
	}
	
	public Iterator<String> GetLineIterator() {
		return lines.iterator();
	}
	
	public ArrayList<String> GetLines(){
		return lines;
	}
	
	public void SetLines(ArrayList<String> lines) {
		this.lines = lines;
	}
	
	public String GetFileName() {
		return fileName;
	}
}
