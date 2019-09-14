package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class ArithmeticComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new ArithmeticComplexity("   *a=5*5;");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("*", complexity.keywordsToString());
		assertEquals(1, complexity.getScore());
	}

}
