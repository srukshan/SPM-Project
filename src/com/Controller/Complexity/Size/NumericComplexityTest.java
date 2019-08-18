package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class NumericComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new NumericComplexity("   if(a+b==4&&d-c==2.26){");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("4, 2.26", complexity.getKeywords());
		assertEquals(2, complexity.getScore());
	}

}
