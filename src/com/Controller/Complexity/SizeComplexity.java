package com.Controller.Complexity;

import com.Controller.Complexity.Size.ArithmeticComplexity;
import com.Controller.Complexity.Size.AssignmentComplexity;
import com.Controller.Complexity.Size.BitwiseComplexity;
import com.Controller.Complexity.Size.KeywordComplexity;
import com.Controller.Complexity.Size.LogicalComplexity;
import com.Controller.Complexity.Size.LowKeywordComplexity;
import com.Controller.Complexity.Size.ManipulatorComplexity;
import com.Controller.Complexity.Size.MiscellaneousComplexity;
import com.Controller.Complexity.Size.NumericComplexity;
import com.Controller.Complexity.Size.RefAndDerefComplexity;
import com.Controller.Complexity.Size.RelationComplexity;
import com.Controller.Complexity.Size.TextComplexity;
import com.Controller.Complexity.Size.VariableComplexity;
import com.Interface.AbstractComplexityFinder;
import com.Model.Complexity;

public class SizeComplexity extends AbstractComplexityFinder {

	public SizeComplexity(String line) {
		super(line);
	}

	@Override
	public Complexity GetComplexity() {
		Complexity complexity = new Complexity();

		complexity.merge(new ArithmeticComplexity(line).GetComplexity());
		complexity.merge(new AssignmentComplexity(line).GetComplexity());
		complexity.merge(new BitwiseComplexity(line).GetComplexity());
		complexity.merge(new KeywordComplexity(line).GetComplexity());
		complexity.merge(new LogicalComplexity(line).GetComplexity());
		complexity.merge(new LowKeywordComplexity(line).GetComplexity());
		complexity.merge(new ManipulatorComplexity(line).GetComplexity());
		complexity.merge(new MiscellaneousComplexity(line).GetComplexity());
		complexity.merge(new NumericComplexity(line).GetComplexity());
		//complexity.merge(new RefAndDerefComplexity(line).GetComplexity());
		complexity.merge(new RelationComplexity(line).GetComplexity());
		complexity.merge(new TextComplexity(line).GetComplexity());
		complexity.merge(new VariableComplexity(line).GetComplexity());
		
		return complexity;
	}
}
