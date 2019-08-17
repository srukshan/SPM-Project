package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;
import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class BitwiseComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new BitwiseComplexity("   if(a<<b==4&&d|c==2){");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("|, <<", complexity.getKeywords());
		assertEquals(2, complexity.getScore());
	}

}
