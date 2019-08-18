package com.Controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.Model.File;

public class FileController {

	public static File readFileInList(String fileName) {

		File file = new File(fileName);

		try {
			file.SetLines(new ArrayList<String>(Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8)));
		} catch (IOException e) {
			// do something
			e.printStackTrace();
		}
		return file;
	}

}
