<%@page import="com.Controller.Complexity.TypeOfComplexity"%>
<%@page import="com.Model.Complexity"%>
<%@page import="com.Controller.Complexity.SizeComplexity"%>
<%@page import="com.sun.org.apache.xpath.internal.compiler.Keywords"%>
<%@page import="com.Controller.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="java.nio.file.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.Model.CodeFile"%>
<%@page import="com.Model.Line"%>

<%
	
	FileController.startAnalyzing();

%>

<!DOCTYPE html>
<html>
	<head>
	
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
	<meta charset="ISO-8859-1">
	
	<title>Complexity</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<br> <br>
		</div>
		
		<div class="row mb-5">
			<div class="col-md-12">
				<h5>You have successfully analyzed your project Directory</h5>
				<hr>
				<br>
				
				<div class="accordion" id="accordionExample">
				
<%
				for(int i = 0; i < FileController.GetFileList().size(); ++i) {
					
					if(i == 0) {
%>
					<div class="card">
						<div class="card-header" id="headingOne">
							<h2 class="mb-0">
								<button class="btn btn-link" type="button"
									data-toggle="collapse" data-target="#collapseOne"
									aria-expanded="true" aria-controls="collapseOne">
									<%= FileController.GetFileList().get(i).getFileName() %></button>
							</h2>
						</div>

						<div id="collapseOne" class="collapse show"
							aria-labelledby="headingOne" data-parent="#accordionExample">
							<div class="card-body">
							
							<table border=1 width=100%>
								<tr>
									<td>Line</td>
									<td>Program Statement</td>
									<td>Tokens identified</td>
									<td>CS</td>
									<td>Ctc</td>
									<td>Cnc</td>
									<td>Ci</td>
									<td>TW</td>
									<td>Cps</td>
									<td>Cr</td>
								</tr>
								
<%										
								for(Line line: FileController.GetFileList().get(i).getLines()) {
%>
							
								<tr>
									<td> <%= line.getLineIndex() %> </td>
									<td> <%= line.getLineContent() %> </td>
									<td> <%= line.getSizeComplexity().keywordsToString() %> </td>
									<td> <%= line.getSizeComplexity().getScore() %> </td>
									<td> <%= line.getTypeOfComplexity().getScore() %> </td>
									<td> <%= line.getBracket()?"-":line.getNesting().getScore() %> </td>
									<td> <%= line.getBracket()?"-":line.getInheritance().getScore() %> </td>
									<td> <%= line.getBracket()?"-":line.getRecursion().getScore() %> </td>
									
								</tr>
								
<% 
								}
%>
							</table>
							</div>
						</div>
					</div>
<%
						
					} else {

%>
						<div class="card">
							<div class="card-header" id="<%= "heading"+ i%>">
								<h2 class="mb-0">
									<button class="btn btn-link collapsed" type="button"
										data-toggle="collapse" data-target="<%= "#collapse"+ i%>"
										aria-expanded="false" aria-controls="<%= "collapse"+ i%>">
										<%= FileController.GetFileList().get(i).getFileName() %></button>
								</h2>
							</div>

							<div id="<%= "collapse"+ i%>" class="collapse"
								aria-labelledby="<%= "heading"+ i%>" data-parent="#accordionExample">
								<div class="card-body">
								
								<table border=1 width=100%>
									<tr>
										<td>Line</td>
										<td>Program Statement</td>
										<td>Tokens identified</td>
										<td>CS</td>
										<td>Ctc</td>
										<td>Cnc</td>
										<td>Ci</td>
										<td>TW</td>
										<td>Cps</td>
										<td>Cr</td>
									</tr>
									
<%										
									for(Line line: FileController.GetFileList().get(i).getLines()) {
%>
								
									<tr>
										<td> <%= line.getLineIndex() %> </td>
										<td> <%= line.getLineContent() %> </td>
										<td> <%= line.getSizeComplexity().keywordsToString() %> </td>
										
										<td> <%= line.getSizeComplexity().getScore() %> </td>
										<td> <%= line.getTypeOfComplexity().getScore() %> </td>
										<td> <%= line.getBracket()?"-":line.getNesting().getScore() %> </td>
										<td> <%= line.getBracket()?"-":line.getInheritance().getScore() %> </td>
										<td> <%= line.getBracket()?"-":line.getRecursion().getScore() %> </td>
									</tr>
									
<% 
									}
%>
								</table>
								</div>
							</div>
						</div>
<%
					}					
				}
%>

				</div>
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