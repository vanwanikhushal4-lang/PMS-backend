<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin Dashboard</title>
<%--  <link rel="icon" href="<%=request.getContextPath()%>/resources/dist/img/favicon.ico"> --%>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->
<!-- Tempusdominus Bbootstrap 4 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<!--<link rel="stylesheet" href="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jqvmap.min.css">-->
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/dist/css/adminlte.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->



<style>
/* #container { */
/* 	height: 400px; */
/* } */

/* .highcharts-figure, .highcharts-data-table table { */
/* 	min-width: 310px; */
/* 	max-width: 800px; */
/* 	margin: 1em auto; */
/* } */

/* .highcharts-data-table table { */
/* 	font-family: Verdana, sans-serif; */
/* 	border-collapse: collapse; */
/* 	border: 1px solid #ebebeb; */
/* 	margin: 10px auto; */
/* 	text-align: center; */
/* 	width: 100%; */
/* 	max-width: 500px; */
/* } */

/* .highcharts-data-table caption { */
/* 	padding: 1em 0; */
/* 	font-size: 1.2em; */
/* 	color: #555; */
/* } */

/* .highcharts-data-table th { */
/* 	font-weight: 600; */
/* 	padding: 0.5em; */
/* } */

/* .highcharts-data-table td, .highcharts-data-table th, */
/* 	.highcharts-data-table caption { */
/* 	padding: 0.5em; */
/* } */

/* .highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) */
/* 	{ */
/* 	background: #f8f8f8; */
/* } */

/* .highcharts-data-table tr:hover { */
/* 	background: #f1f7ff; */
/* } */


#container {
    height: 400px;
}

.highcharts-figure,
.highcharts-data-table table {
    min-width: 310px;
    max-width: 800px;
    margin: 1em auto;
}

.highcharts-data-table table {
    font-family: Verdana, sans-serif;
    border-collapse: collapse;
    border: 1px solid #ebebeb;
    margin: 10px auto;
    text-align: center;
    width: 100%;
    max-width: 500px;
}

.highcharts-data-table caption {
    padding: 1em 0;
    font-size: 1.2em;
    color: #555;
}

.highcharts-data-table th {
    font-weight: 600;
    padding: 0.5em;
}

.highcharts-data-table td,
.highcharts-data-table th,
.highcharts-data-table caption {
    padding: 0.5em;
}

.highcharts-data-table thead tr,
.highcharts-data-table tr:nth-child(even) {
    background: #f8f8f8;
}

.highcharts-data-table tr:hover {
    background: #f1f7ff;
}


</style>

  <script>
        <%
            String role = (String) session.getAttribute("role");
            System.out.println("roleee" + role);
        %>
    </script>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<input type="hidden" id="role" name="role" value="<%=role%>">
	<div class="wrapper">

		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		
		

		<div class="content-wrapper">

			<!-- 			                         <div class="row"> -->
			<!--                               <div class="col-sm-11"> -->
			<!--                          <center> -->

			<!--                                     <div style="color: black;font-family: calibri;font-size: medium;text-align:justify;border-radius:15px;margin-left:70px"> -->
			<!--                                         <br> -->

			<%--                                         <img src="<%=request.getContextPath()%>/resources/img/ban2.png" /> --%>

			<!--                                         <h1 style="color:maroon;margin-left:300px;">&nbsp;&nbsp;&nbsp;Core HelpDesk</h1> -->
			<!--                                         <div align="left"> -->
			<!--                                             <p >&nbsp;&nbsp;&nbsp;<p align="justify"> -->
			<!--                                                 IT Service Management and Service Desk implementation is a promising potential which draws a -->
			<!--                                                 framework of service delivery, although as a way of capturing comparative -->
			<!--                                                 advantages in the face of the growing service delivery methods, the failure percentage of -->
			<!--                                                 ITSM and Service Desk implementation is still relatively high which causes increasing concerns -->
			<!--                                                 for many corporations. The aim of this paper is to extend the line of knowledge about outcomes of -->
			<!--                                                 ITSM and Service Desk Implementation, proposing a conceptual framework for successful -->
			<!--                                                 ITSM and Service Desk implementation, phases of implementation cycle, -->
			<!--                                                 and different success factors.</p> -->
			<!--                                         </div><br> -->
			<!--                                         <ul> -->
			<!--                                             <li>&nbsp;&nbsp;&nbsp;Configuration Management - physical and logical information of the IT infrastructure and the IT services </li> -->
			<!--                                             <li>&nbsp;&nbsp;&nbsp;Change Management - standard methods and procedures for effective managing of all changes</li> -->
			<!--                                             <li>&nbsp;&nbsp;&nbsp;Release Management - testing, verification, and release of changes to the IT environment </li> -->
			<!--                                             <li>&nbsp;&nbsp;&nbsp;Incident Management - the day-to-day process that restores normal acceptable service with a minimal impact on business</li> -->
			<!--                                             <li>&nbsp;&nbsp;&nbsp;Problem Management - the diagnosis of the root causes of incidents in an effort to proactively eliminate and manage them </li> -->
			<!--                                             <li>&nbsp;&nbsp;&nbsp;Service Desk (Function) - this provides a central point of contact between users and Information Technology </li> -->
			<!--                                         </ul><br><br> -->
			<!--                                          <article class="stats_overview"> -->
			<!--                                              <img src=""> -->
			<!--                                          </article>   -->
			<!--                                     </div> -->
			<!--                                     <br> -->


			<!--                                 </center> -->
			<!--                     </div> -->

			<!--                     </div> -->




			<div class="row" style="margin:10px;">
			
			<div class="col-md-6" id="PMSpieChart">
			<div class="card card-secondary ">
			<div class="card-header" > Pie Chart for PMS</div>
			<div class="card-body " >
			
					<figure class="highcharts-figure">
						<div id="container"><span
								style="width: 5rem; height: 5rem; margin-left: 230px; display: none;"
								id="spin1"><i class="fa fa-spinner fa-spin"
								style="font-size: 33px"></i></span></div>
						 
					</figure>
				</div>
			</div>
			</div>
			
			
			
			<div class="col-md-6">
			<div class="card card-secondary">
			<div class="card-header" > Bar Chart for SCM</div>
			<div class="card-body " >
					<figure class="highcharts-figure">
						<div id="bar_container"><span
								style="width: 5rem; height: 5rem; margin-left: 230px; display: none;"
								id="spin2"><i class="fa fa-spinner fa-spin"
								style="font-size: 33px"></i></span></div>
					</figure>
				</div>
			</div>
			</div>	
				
				
			</div>






		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark"></aside>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/sparklines/sparkline.js"></script>
	<!-- JQVMap -->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jquery.vmap.min.js"></script>-->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>-->
	<!-- jQuery Knob Chart -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/moment/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/adminlte.js"></script>-->
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/pages/dashboard.js"></script>-->
	<!-- AdminLTE for demo purposes -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/dist/js/demo.js"></script>

<%-- 	<script src="<%=request.getContextPath()%>/static/resources1/js/highcharts.js"></script> --%>
<%-- 	<script src="<%=request.getContextPath()%>/static/resources1/js/highcharts-3d.js"></script> --%>
	
	<script src="https://code.highcharts.com/highcharts.js"></script>	
	<script src="https://code.highcharts.com/highcharts-3d.js"></script>
	
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	<script src="https://code.highcharts.com/modules/accessibility.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/HomeDashboard.js"></script>
</body>

</html>
