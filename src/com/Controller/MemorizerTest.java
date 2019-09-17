package com.Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.Model.Line;

@TestInstance(Lifecycle.PER_CLASS)
public class MemorizerTest {
	Memorizer memorizer;
	
	@BeforeAll
	public void preTesting() {
		Line[] lines = new Line[] {
				new Line(0, "import java.util.ArrayList;"),
				new Line(1, "public class MemorizerTest {"),
				new Line(2, "	Memorizer memorizer;// {Hi"),
				new Line(3, "	public void preTesting() {"),
				new Line(4, "		for(String item: Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8)) {"),
				new Line(5, "       	return preTesting();"),
				new Line(6, "   	}"),
				new Line(7, "   }"),
				new Line(8, "}"),
		};
		memorizer = new Memorizer(new ArrayList<Line>(Arrays.asList(lines)));
		memorizer.checkFile();
	}

	@Test
	public void testGetNestingComplexity() {

		assertEquals(1,memorizer.GetNestingComplexity(new Line(5, "       	return preTesting();")).getScore());
	}

	@Test
	public void testGetInheritanceComplexity() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRecursionComplexity() {
		assertEquals(0,memorizer.GetRecursionComplexity(new Line(2, "       	return preTesting();")).getScore());
		assertEquals(1,memorizer.GetRecursionComplexity(new Line(5, "       	return preTesting();")).getScore());
	}

}
