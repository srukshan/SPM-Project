package com.Controller.Complexity;

import com.Controller.Complexity.TypeOf.CatchComplexity;
import com.Controller.Complexity.TypeOf.IfConditionComplexity;
import com.Controller.Complexity.TypeOf.IterativeComplexity;
import com.Controller.Complexity.TypeOf.SwitchComplexity;
import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class TypeOfComplexity extends AbstractComplexityFinder {

	public TypeOfComplexity(String line) {
		super(line);
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();

		//complexity.merge(new IfConditionComplexity(line).GetComplexity());
		//complexity.merge(new IterativeComplexity(line).GetComplexity());
		complexity.merge(new CatchComplexity(line).GetComplexity());
		//complexity.merge(new SwitchComplexity(line).GetComplexity());
		
		return complexity;
	}
}
