package com.Controller.Complexity.Size;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class RelationComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new RelationComplexity("   if(a+b==4>>d-c==2){ hel +=hello");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("==, ==", complexity.keywordsToString());
		assertEquals(2, complexity.getScore());
	}

}
