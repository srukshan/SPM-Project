package com.Controller.Complexity.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class VariableComplexity extends AbstractComplexityFinder {

	ArrayList<String> keywords = new ArrayList<String>(Arrays.asList(new String[] {
			"abstract"
			, "continue"
			, "for"
			, "new"
			, "switch" 
			, "assert"
			, "default"
			, "goto"
			, "package"
			, "synchronized" 
			, "boolean"
			, "do"
			, "if"
			, "private"
			, "this" 
			, "break"
			, "double"
			, "implements"
			, "protected"
			, "throw"
			, "byte"
			, "else"
			, "import"
			, "public"
			, "throws" 
			, "case"
			, "enum"
			, "instanceof"
			, "return"
			, "transient"
			, "catch"
			, "extends"
			, "int"
			, "short"
			, "try"
			, "char"
			, "final"
			, "interface"
			, "static"
			, "void"
			, "class"
			, "finally"
			, "long"
			, "strictfp"
			, "volatile"
			, "const"
			, "float"
			, "native"
			, "super"
			, "while"
	}));

	public VariableComplexity(String line) {
		super(line);
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();
		int start = -1;
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i)=='"') {
				if(start==-1)
					start=i;
				else {
					line = line.replace(line.substring(start, i+1),"");
					start=-1;
				}
			}
		}
		ArrayList<String> variables = new ArrayList<String>(Arrays.asList(Pattern.compile("[a-zA-Z$_][a-zA-Z$_0-9]*")
				.matcher(line)
				.results()
				.map(MatchResult::group)
				.toArray(String[]::new))
			);
		
		variables.removeIf(var -> keywords.contains(var));
		
		variables.forEach(var -> {
			complexity.addKeyword(var);
			complexity.increaseScore(1);
		});
		
		return complexity;
	}

}
