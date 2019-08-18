package com.Controller;

import java.util.ArrayList;

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
		
	}

	private void memorizeNesting(String line) {
		
	}

	public void checkNextRecusion(ArrayList<String> lines, int line) {
		
	}

	public Complexity GetNestingComplexity() {
		Complexity complexity = new Complexity();
		
		return complexity;
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
