<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style>
.footer {
	height: 80px;
	position: absolute;
	bottom: 0;
}

html {
	position: relative;
	min-height: 100%;
}

body {
	margin-bottom: 60px;
}
</style>
</head>
<body style="overflow-x: hidden;">
	<!-- Footer -->
	<br>
	<br>
	<br>
	<footer class="footer"
		style="background-color: white; box-shadow: 1px 1px 1px 5px rgba(0, 0, 0, .05); width: 100%;">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-6">
					<div class="footer_logo_right pull-right"
						style="margin-top: 15px; margin-right: 30%; margin-left: 100px; postition: fixed; bottom: 0px;">
						<div class="pull-left">
							<img
								src="<%=request.getContextPath()%>/static/resources/img/veloxlogo.png"
								alt="" height="50px" width="170px">
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<div class="footer_logo_right pull-right" style="margin-top: 15px;">
						<i class="fa fa-copyright"></i> Copyright 2012-2019 <a
							href="http://www.velox.co.in" target="_blank">Velox Solutions
							Pvt. Ltd.</a> <br>
						<div class="pull-left">Ver 18.0.11.12</div>
					</div>
				</div>

			</div>
		</div>
	</footer>

	<!--    <footer class="footer">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12">
                    <i class="fa fa-copyright"></i> Copyright 2012-2018 <a href="http://www.velox.co.in" target="_blank">Velox Solutions Pvt. Ltd.</a> 
                    
                </div>
            </div>
        </div>
    </footer>-->
	<!-- End Footer -->
</body>
</html>