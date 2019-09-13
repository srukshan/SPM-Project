package com.Controller.Complexity.TypeOf;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class IterativeComplexityTest {

	@Test
	public void test() {
		ComplexityFinder complexityFinder = new IterativeComplexity("   do(a+b==\"hello\"&&d-c==2);");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("do, &&", complexity.keywordsToString());
		assertEquals(3, complexity.getScore());
	}

}
