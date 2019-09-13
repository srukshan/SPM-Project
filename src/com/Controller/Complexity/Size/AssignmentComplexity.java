package com.Controller.Complexity.Size;

public class AssignmentComplexity extends BitwiseComplexity {
	
	public AssignmentComplexity(String line) {
		super(line);
		operators = new String[] { "+=", "-=", "*=", "=", "/=", ">>>=", "|=", "&=", "<<=", ">>=", "%=",
				"^=" };
	}

}
