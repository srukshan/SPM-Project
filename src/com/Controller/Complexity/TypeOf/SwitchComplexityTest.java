package com.Controller.Complexity.TypeOf;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class SwitchComplexityTest {

	@Test
	public void test() {
		ComplexityFinder complexityFinder = new SwitchComplexity("case 2 : System.out.println(\"Yes\")");
		Complexity complexity = complexityFinder.GetComplexity();
		assertEquals("switch", complexity.keywordsToString());
		assertEquals(1, complexity.getScore());
	}

}
