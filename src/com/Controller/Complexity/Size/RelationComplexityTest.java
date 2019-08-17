package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.AbstractOperatorComplexityFinder;
import com.Model.Complexity;

public class RelationComplexityTest {

	@Test
	public void testGetComplexity() {
		AbstractOperatorComplexityFinder complexityFinder = new RelationComplexity("   if(a+b==4&&d-c==2){");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("==, ==", complexity.getKeywords());
		assertEquals(2, complexity.getScore());
	}

}
