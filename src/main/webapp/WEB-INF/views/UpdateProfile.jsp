<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Update Profile</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--         <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"> -->
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->

<!--   <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap/dist/css/bootstrap.min.css">-->
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
<!-- Datatables -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
<!-- <script src="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css"></script>-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<!-- bootstrap datepicker -->
<!--  <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">-->
<!-- Sweetalert 2 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">

<!-- summernote -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
<!-- Select2 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">

<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

label {
	margin-top: .5rem !important;
	margin-bottom: 0rem !important;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
	    <% 
       HttpSession htt = request.getSession(true);
            String uname = (String) htt.getAttribute("username");
            System.out.println("usernamemeeem" + uname);
            String utype = (String) htt.getAttribute("role");
         
            
            %>
           
           <%   if(utype.equals("User")||utype.equals("IT-Head")){  %>
            
              <jsp:include page="/WEB-INF/views/dashboardheaderUser.jsp"></jsp:include>
       <% }  else if(utype.equals("Engineer")) {%>
                 <jsp:include page="/WEB-INF/views/dashboardheaderEngg.jsp"></jsp:include>	
         
       <%}  else if(utype.equals("Ticket Co-ordinator")){%>
       	<jsp:include page="/WEB-INF/views/dashboardheaderTP.jsp"></jsp:include>
       <% }%>
            
              <jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>
<%--       		<jsp:include page="/WEB-INF/views/dashboardheaderTP.jsp"></jsp:include> --%>
	<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<section class="content-header">

				<form id="addhardwareform" name="addhardwareform">
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<br> <br>
							<div class="card card-secondary">
								<div class="card-header">Update Profile</div>
								<div class="card-body">
									<div class="row">
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="firstname">First Name</label>
											<div id="fname1"></div>
											<input type="text"  id="fname" 
												class="form-control" name="fname" readonly="readonly" 
												>

										</div>

										<div style="margin-top: 15px;" class="col-md-6">
											<label for="lastname">Last Name</label>
											<div id="lname1"></div>
											<input type="text" id="lname" 
												class="form-control" name="lname" readonly="readonly" 
												>

										</div>
									</div>
									<div class="row">

										<div style="margin-top: 15px;" class="col-md-6">
											<label for="user1">User Name</label> <input type="text"
												id="username" tabindex="3" class="form-control" name="username"
												data-toogle="tooltip" placeholder="Enter User Name"  readonly="readonly" 
												autocomplete="false">

										</div>
									
										
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="designation">Designation</label> <input
												id="designation" class="form-control" tabindex="8"
												data-toogle="tooltip" name="designation" readonly="readonly">
												
											
										</div>

									</div>
									<div class="row">
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="companyname">Company</label> <input id="cname"
												class="form-control" tabindex="6" data-toogle="tooltip"
												name="cname" onchange="getLocation()"  readonly="readonly" >
											
										</div>
											<div style="margin-top: 15px;" class="col-md-6">
											<label for="location">Location</label> <select id="location"
												class="form-control" tabindex="7" data-toogle="tooltip"
												name="location" onchange="getSiteDetails()">
												<option value="">-- Please Select --</option>

											</select>
											</div>
									</div>
									
									<div class="row">
									<div style="margin-top: 15px;" class="col-md-6">
											<label for="sitename">Branch</label> <select id="sname"
												class="form-control" tabindex="7" data-toogle="tooltip"
												name="sname" onchange="getDeptDetails()">
												<option value="">-- Please Select --</option>

											</select>
										</div>
							
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="departmentname">Department</label>

											<!--                                                <input type="text" id="dname" tabindex="8"  maxlength="15" class="form-control" name="dname" data-toogle="tooltip" placeholder="Enter Department Name">-->
											<select id="dname" class="form-control" tabindex="8"
												data-toogle="tooltip" name="dname"
												onchange="getsubdepartment()">
												<option value="">-- Please Select --</option>

											</select>


										</div>
										
									</div>


									<div class="row">
									<div style="margin-top: 15px;" class="col-md-6">
											<label for="subDepartment">Sub-Department</label> <select
												id="subDepartment" class="form-control" tabindex="11"
												data-toogle="tooltip" name="subDepartment">
												<option value="">-- Please Select --</option>
											</select>

										</div>
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="mail">Email-ID</label>
											<div id="email"></div>
											<input type="text" id="mail" tabindex="9"
												class="form-control" name="mail" data-toogle="tooltip"
												placeholder="Enter Email-ID" readonly="readonly">
										</div>


										
									</div>
									<div class="row">
									<div style="margin-top: 15px;" class="col-md-6">
											<label for="cno">Contact Number</label>
											<div id="phnnno"></div>
											<input pattern="/^-?\d+\.?\d*$/" onKeyPress="if(this.value.length==10) return false;"
											 type="text" id="cno" tabindex="10"
												class="form-control" name="cno" data-toogle="tooltip"
												placeholder="Enter Contact Number" oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>
										</div>
									<div class="row">

										<div style="margin-top: 15px;" class="col-md-12">
											<center>
											
												<button type="button" class="btn btn-primary m-t-10"
													tabindex="14" id="submit-btn" name="submit">Submit
												</button>

<!-- 												<button type="button" tabindex="15" -->
<!-- 													class="btn btn-primary m-t-10" id="resetbtn" name="reset">Reset</button> -->

											</center>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</form>

			</section>
		
		</div>

		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

	</div>
	<!-- ./wrapper -->
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script
		src="<%=request.getContextPath()%>/static//AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery/dist/jquery.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery-ui/jquery-ui.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script>
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
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script> -->
	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<!--bootstrap datepicker-->
	<!--<script src="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>-->
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

	<!-- Sweetalert 2 -->
	<script
		src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>

	<!-- DataTables -->
	<!--    <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net/js/jquery.dataTables.js"></script>
     <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net-bs/js/dataTables.bootstrap.js"></script>
     <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>-->

	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>


	<!--<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>-->
	<!--<script src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>-->
	<!--<script src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>-->
	<!--<script src="../../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>-->

	<!--<script src="<%=request.getContextPath()%>/resources/Listing/dataTables.bootstrap.min.js"></script>-->
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/dataTables.buttons.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/jszip.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/vfs_fonts.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.html5.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.print.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.colVis.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/UpdateProfile.js"></script>

</body>

</html>


