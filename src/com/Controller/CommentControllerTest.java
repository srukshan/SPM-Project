package com.Controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.Model.Line;

@TestInstance(Lifecycle.PER_CLASS)
class CommentControllerTest {
	
	CommentController controller;
	
	@BeforeAll
	void preTest() {
		ArrayList<Line> lines = new ArrayList<Line>(Arrays.asList(new Line[] {
				new Line(0, "import dsfsdff;"),
				new Line(1, "//import dsfsdff;"),
				new Line(2, "iort dsfsdff;")
				
		}));
		controller = new CommentController(lines);
		controller.RemoveComments();
		controller.GetCodeFile();
	}

	@Test
	void test() {
		fail();
	}

}
