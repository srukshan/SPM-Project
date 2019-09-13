package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.AbstractOperatorComplexityFinder;
import com.Model.Complexity;

public class LogicalComplexityTest {

	@Test
	public void testGetComplexity() {
		AbstractOperatorComplexityFinder complexityFinder = new LogicalComplexity("   if(a+b==4&&d-c==2){");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("&&", complexity.keywordsToString());
		assertEquals(1, complexity.getScore());
	}

}
