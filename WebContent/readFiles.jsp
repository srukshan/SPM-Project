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
	<meta charset="ISO-8859-1">
	<title>Complexity Results</title>
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