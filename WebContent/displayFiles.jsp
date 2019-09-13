<%@page import="com.Controller.FileController"%>
<%@page import="java.util.ArrayList"%>
 
<%
	String file_Dir = request.getParameter("fileDir");

	FileController.SetFileNameList(file_Dir);
%>

<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Complexity Results</title>
</head>
<body>


<% 
	
	try {
		
		System.out.println(String.valueOf(FileController.GetFileNameList().size()));
		
		for(String item: FileController.GetFileNameList()) { 
		
%>
			<p> <%= item %> </p>
<%
		}
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	System.out.println("This:- "+ FileController.GetFileNameList().get(0));
	
	FileController.SetFileList();
	
	

%>

</body>
</html>
