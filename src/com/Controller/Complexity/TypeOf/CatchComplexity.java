package com.Controller.Complexity.TypeOf;

import com.Interface.AbstractOperatorComplexityFinder;

public class CatchComplexity extends AbstractOperatorComplexityFinder{

	public CatchComplexity(String line) {
		super(line);
		operators = new String[] {"catch"};
	}

}
