<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<section id="login-form" class="login-inner-form">
		<h1>Check Code Quality</h1>
		<form class="form-vertical" action="FileRead.jsp">

			<div class="control-group-merged">
				<div class="control-group">
					<input type="text" placeholder="Insert File path" name="fileName"
						id="fileName" class="big required">
				</div>
			</div>
			<br />

			<div class="control-group"></div>
			<div class="form-actions">
				<input type="hidden" name="action" id="action" value="fileRead">
				<button type="submit" class="btn btn-success btn-block btn-large">Submit</button>
			</div>

		</form>
	</section>
</body>
</html>