package com.Controller.Complexity.Size;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class RefAndDerefComplexityTest {

	@Test
	public void testGetComplexity() {
		ComplexityFinder complexityFinder = new RefAndDerefComplexity("	if(hel == 1 && t ==2) char *ptr_toarray=&num[0];");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("&", complexity.keywordsToString());
		assertEquals(1, complexity.getScore());
	}

}
