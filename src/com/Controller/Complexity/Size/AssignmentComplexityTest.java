package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class AssignmentComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new AssignmentComplexity("   n=20;n+=5;");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("=, +=", complexity.getKeywords());
		assertEquals(2, complexity.getScore());
	}

}
