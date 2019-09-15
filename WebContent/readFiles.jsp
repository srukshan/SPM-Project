<%
	String action = request.getParameter("action");
	String fileDir = request.getParameter("fileDir").trim();
	
	pageContext.setAttribute("action", action);
	pageContext.setAttribute("fileDir", fileDir);
%>

<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<title>Complexity Finder</title>
	
</head>
<body>

	<% 	
		if(action !=null && action.contentEquals("readFile")){ 
	%>
		<jsp:include page="displayFiles.jsp">
	        <jsp:param name="fileDir" value="${fileDir}"/>
	    </jsp:include>
	<% } else { %>
		<div class="centerall title">
			This content is Unavailable
		</div>
	<% } %>
</body>
</html>