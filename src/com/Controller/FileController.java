package com.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import com.Controller.Complexity.SizeComplexity;
import com.Controller.Complexity.TypeOfComplexity;
import com.Model.CodeFile;
import com.Model.Line;

public class FileController {
	private static ArrayList<String> fileNameList;
	private static ArrayList<CodeFile> fileList;

	private static CodeFile ReadFile(String filePath) {
		CodeFile codeFile = new CodeFile(filePath);

		try {
			Line line;
			int counter = 1;
			
			for(String item: Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8)) {
				line = new Line(counter, item);
				
				codeFile.addLines(line);
				counter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CommentController commentController = new CommentController(codeFile.getLines());
		commentController.RemoveComments();
		
		return codeFile;
	}
	
	private static ArrayList<String> GetAllCodeFileNames(String dir) throws IOException{
		ArrayList<String> codeFileList = new ArrayList<>();
		
		File fileDir = new File(dir);
		
		if(fileDir != null) {
			for(File item: fileDir.listFiles()) {
				if(item.getCanonicalPath().toLowerCase().endsWith(".java") ||
						item.getCanonicalPath().toLowerCase().endsWith(".cpp"))
					codeFileList.add(item.getCanonicalPath());
				if(item.isDirectory())
					codeFileList.addAll(GetAllCodeFileNames(item.getCanonicalPath()));
			}
		}
		
		return codeFileList;
	}

	public static ArrayList<String> GetFileNameList() {
		return fileNameList;
	}

	public static void SetFileNameList(String dir) {
		ArrayList<String> tempNameList = new ArrayList<>();
		
		try {
			tempNameList = GetAllCodeFileNames(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileController.fileNameList = tempNameList;
	}

	public static ArrayList<CodeFile> GetFileList() {
		return fileList;
	}
	
	public static Iterator<CodeFile> GetFileListIterator() {
		return fileList.iterator();
	}
	
	public static void SetFileList() {
		ArrayList<CodeFile> tempList = new ArrayList<>();
		
		for(String item: fileNameList) {
			tempList.add(ReadFile(item));
		}
		
		FileController.fileList = tempList;
	}
	
	public static void startAnalyzing() {
		Memorizer memorizer;
		for(CodeFile item: fileList) {
			//memorizer = new Memorizer(item.getLines());
			//memorizer.checkFile();
			
			for(Line line: item.getLines()) {
				//line.setRecursion(memorizer.GetRecursionComplexity(line));
				//line.setNesting(memorizer.GetNestingComplexity(line));
				
				line.setSizeComplexity(new SizeComplexity(line.getLineContent()).GetComplexity());
				//line.setTypeOfComplexity(new TypeOfComplexity(line.getLineContent()).GetComplexity());
			}
		}
	}

}
