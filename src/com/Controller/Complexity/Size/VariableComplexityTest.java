package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class VariableComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new VariableComplexity("   if(a+b==\"hello\"&&d-c==2){");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("a, b, d, c", complexity.getKeywords());
		assertEquals(4, complexity.getScore());
	}

}
