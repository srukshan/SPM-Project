package com.Controller.Complexity.Size;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class LowKeywordComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new LowKeywordComplexity("		ComplexityFinder complexityFinder = new LowKeywordComplexity(\"new world\");");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("new", complexity.keywordsToString());
		assertEquals(1, complexity.getScore());
	}

}
