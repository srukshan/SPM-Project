
<%
	response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
	//response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	int timeout = session.getMaxInactiveInterval();
	response.setHeader("Refresh", timeout + "; URL = index.jsp");
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
	session.invalidate();

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println("Basepath>>>>>>>>>>>>>>>>>>>>>>>>" + basePath);

	String errCode = "" + request.getParameter("err");
	String message = "" + request.getParameter("msg");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Stylesheet -->
<link rel="shortcut icon" href="assets/images/favicon.ico"
	type="image/x-icon">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
	media="screen">

<!-- Uniform Stylesheet -->
<link rel="stylesheet" href="plugins/uniform/css/uniform.default.css"
	media="screen">

<!-- Plugin Stylsheets first to ease overrides -->

<!-- End Plugin Stylesheets -->

<!-- Main Layout Stylesheet -->
<link rel="stylesheet" href="assets/css/fonts/icomoon/style.css"
	media="screen">
<link rel="stylesheet" href="assets/css/login.css" media="screen">
<link rel="stylesheet" href="plugins/zocial/zocial.css" media="screen">

<title>SoftlogicLife - Login</title>
</head>
<body>
	<div id="login-wrap">

		<div id="login-buttons">
			<div class="row-fluid">
				<div class="span12 widget">
					<img border="0" src="assets/images/softlogic_life.jpg"
						alt="Nestle Logo"
						style="height: 55px; position: relative; bottom: 5px;">
				</div>
			</div>
		</div>

		<div id="login-inner" class="login-inset">

			<div id="login-circle">
				<section id="login-form" class="login-inner-form">
					<h1>Check Code Quality</h1>
					<form class="form-vertical" action="FileRead.jsp">


						<div class="control-group-merged">
							<div class="control-group">
								<input type="text" placeholder="Insert File path"
									name="fileName" id="fileName"
									class="big required">
							</div>
						</div>
						<br/>
						
						<div class="control-group"></div>
						<div class="form-actions">
							<input type="hidden" name="action" id="action" value="fileRead">
							<button type="submit" class="btn btn-success btn-block btn-large">Login</button>
						</div>

					</form>
				</section>
			</div>

		</div>

	</div>
	<div id="login-ui" style="text-align: center; margin-top: 200px;">
		<div class="footer-right">
			<a><img src="assets/images/mobios_logo_index1.png" alt=""
				style="width: 100px; height: 26px;"></a>
		</div>
		<div class="footer-right">
			<p>Copyright 2019. All Rights Reserved.</p>
		</div>
	</div>
	<!-- Core Scripts -->
	<script src="assets/js/libs/jquery-1.8.3.min.js"></script>
	<script src="assets/js/libs/jquery.placeholder.min.js"></script>

	<!-- Login Script -->
	<script src="assets/js/login.js"></script>

	<!-- Validation -->
	<script src="plugins/validate/jquery.validate.min.js"></script>

	<!-- Uniform Script -->
	<script src="plugins/uniform/jquery.uniform.min.js"></script>

</body>

</html>
