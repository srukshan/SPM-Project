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
	
	<script>
		function nextMove() {
			window.location.href = "includes/displayComplexity.jsp";
		}
	</script>
</head>
<body>

	<div class="container">
		<div class="row">
			<br> <br>
		</div>
		<div class="row"></div>
		<div class="row">
			<div class="col-md-12">
				<h5>You have following files to be analyzed in the project</h5>
				<hr>
				<br>
				
				<div class="col-md-12">
					<ul class="list-group">
<%		
						for(String item: FileController.GetFileNameList()) { 
		
%>
							<li class="list-group-item"><%= item %></li>
<%
						}

						FileController.SetFileList();
%>
					</ul>

				</div>
				<br>
				<button type="button" class="btn btn-success float-right mb-4" onClick="nextMove();">Start</button>

			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

</body>
</html>
