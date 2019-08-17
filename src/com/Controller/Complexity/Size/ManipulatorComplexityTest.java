package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class ManipulatorComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new ManipulatorComplexity("   if(a+b==4&&d-c==2){\n");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("\\n", complexity.getKeywords());
		assertEquals(1, complexity.getScore());
	}

}
