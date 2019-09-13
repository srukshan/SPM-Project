package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class TextComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new TextComplexity("   if(a+b==\"hello\"&&d-c==2){");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("\"hello\"", complexity.keywordsToString());
		assertEquals(1, complexity.getScore());
	}

}
