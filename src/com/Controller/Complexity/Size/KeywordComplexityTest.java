package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class KeywordComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new KeywordComplexity("   if(a+b==4&&d-c==2){");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("if", complexity.getKeywords());
		assertEquals(1, complexity.getScore());
	}

}
