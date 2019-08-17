<%
	String action = request.getParameter("action");
	String fileName = request.getParameter("fileName");
	pageContext.setAttribute("action", action);
	pageContext.setAttribute("fileName", fileName);
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complexity Results</title>
</head>
<body>
	<% 
	if(action!=null && action.contentEquals("fileRead")){ %>
		<jsp:include page="includes/displayComplexity.jsp">
	        <jsp:param name="fileName" value="${fileName}"/>
	    </jsp:include>
	<% }else{ %>
		<div class="centerall title">
			This content is Unavailable
		</div>
	<% } %>
</body>
</html>