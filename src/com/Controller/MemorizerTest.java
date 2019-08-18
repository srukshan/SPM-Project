package com.Controller;

import static org.junit.Assert.*;

import org.junit.Test;

import com.Controller.Complexity.Size.KeywordComplexity;
import com.Interface.ComplexityFinder;
import com.Model.Complexity;

public class MemorizerTest {

	@Test
	public void testGetNestingComplexity() {
		Memorizer memorizer = new Memorizer();
		memorizer.Memorize("for(int i=0; i < 5; i++){");
		assertEquals("for", memorizer.GetNestingComplexity().getKeywords());
		assertEquals(1, memorizer.GetNestingComplexity().getScore());
		memorizer.Memorize("}");
		assertEquals("", memorizer.GetNestingComplexity().getKeywords());
		assertEquals(0, memorizer.GetNestingComplexity().getScore());
	}

	@Test
	public void testGetInheritanceComplexity() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRecursionComplexity() {
		fail("Not yet implemented"); // TODO
	}

}
