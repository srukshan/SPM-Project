package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class KeywordComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new KeywordComplexity("   public static void main(String[] Args)");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("void, String", complexity.keywordsToString());
		assertEquals(2, complexity.getScore());
	}

}
