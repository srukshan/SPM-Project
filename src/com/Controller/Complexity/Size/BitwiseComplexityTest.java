package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;
import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class BitwiseComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new BitwiseComplexity("				if(item.getCanonicalPath().toLowerCase().endsWith(\".java\") ||");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("", complexity.keywordsToString());
		assertEquals(0, complexity.getScore());
	}

}
