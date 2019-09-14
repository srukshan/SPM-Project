package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class VariableComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new VariableComplexity("   if(a+b==\"hello\"&&d-c==2){ int cars = 5;");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("a, b, d, c, cars", complexity.keywordsToString());
		assertEquals(5, complexity.getScore());
	}

}
