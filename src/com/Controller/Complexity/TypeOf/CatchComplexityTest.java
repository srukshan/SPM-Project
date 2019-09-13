package com.Controller.Complexity.TypeOf;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class CatchComplexityTest {

	@Test
	public void test() {
		ComplexityFinder complexityFinder = new CatchComplexity("catch(Exception ex) {");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("catch", complexity.keywordsToString());
		assertEquals(1, complexity.getScore());
	}

}
