<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Add Escalation Matrix</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

.swal2-container {
	z-index: 1070 !important;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">

			<section class="content-header">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<br>
						<br>
						<div class="card card-secondary">
							<div class="card-header">Add Escalation Matrix</div>
							<div class="card-body">
								<div class="row">
									<div style="margin-top: 15px;" class="col-md-4">
										<label for="firstname">Company Name</label>
										<div id="fname1"></div>
										<select id="company" tabindex="2" class="form-control"
											data-toogle="tooltip" name="company"
											onchange="getBranch(this.value)">
											<option value="">--Please Select--</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-4">
										<label for="lastname">Branch Name</label>
										<div id="lname1"></div>
										<select id="branch" tabindex="2" class="form-control"
											data-toogle="tooltip" name="branch" onchange="getCategory()">
											<option value="">--Please Select--</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-4">
										<label for="lastname">Category Name</label>
										<div id="lname1"></div>
										<select id="category" tabindex="2" class="form-control"
											data-toogle="tooltip" name="category"
											onchange="catonchange()">
											<option value="">--Please Select--</option>
										</select>

									</div>

								</div>


								<div class="row">
									<div style="margin-top: 15px;" class="col-md-4">
										<label for="firstname">Priority</label>
										<div id="fname1"></div>
										<select id="priority" tabindex="2" class="form-control"
											data-toogle="tooltip" name="priority">
											<option value="">--Please Select--</option>
											<option value="High">High</option>
											<option value="Medium">Medium</option>
											<option value="Low">Low</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-4">
										<label for="lastname">Mail</label>
										<div id="lname1"></div>
										<select id="mail" tabindex="2" class="form-control"
											data-toogle="tooltip" name="mail">
											<option value="">--Please Select--</option>
											<option value="YES">Yes</option>
											<option value="NO">No</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-4">
										<label for="lastname">SMS</label>
										<div id="lname1"></div>
										<select id="sms" tabindex="2" class="form-control"
											data-toogle="tooltip" name="sms">
											<option value="">--Please Select--</option>
											<option value="YES">Yes</option>
											<option value="NO">No</option>
										</select>

									</div>

								</div>


								<div class="row">

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="user">Ticket Owner Name</label><label id="user1"></label>
										<select id="ticowner" tabindex="2" class="form-control"
											data-toogle="tooltip" name="ticowner" onchange="own1()">
											<option value="">--Please Select--</option>
										</select>

									</div>
									<div style="margin-top: 15px;" class="col-md-3">
										<label for="pass">Escalator-1 Name</label>&nbsp;&nbsp;&nbsp;<label
											id="label"></label> <input type="hidden" id="length">
										<select id="esc1" tabindex="2" class="form-control"
											data-toogle="tooltip" name="esc1" onchange="esc11()">
											<option value="">--Please Select--</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="pass">Escalator-2 Name </label>&nbsp;&nbsp;&nbsp;<label
											id="label"></label> <input type="hidden" id="length">
										<select id="esc2" tabindex="2" class="form-control"
											data-toogle="tooltip" name="esc2" onchange="esc22()">
											<option value="">--Please Select--</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="pass">Escalator-3 Name </label>&nbsp;&nbsp;&nbsp;<label
											id="label"></label> <input type="hidden" id="length">
										<select id="esc3" tabindex="2" class="form-control"
											data-toogle="tooltip" name="esc3" onchange="esc33()">
											<option value="">--Please Select--</option>
										</select>

									</div>



								</div>

								<div class="row">
									<div style="margin-top: 15px;" class="col-md-3">
										<label for="firstname">Email-ID</label>
										<div id="fname1"></div>
										<input type="text" id="towneremail" tabindex="1"
											class="form-control" name="towneremail" data-toogle="tooltip"
											placeholder=" Email-ID" disabled>

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Email-ID</label>
										<div id="lname1"></div>
										<input type="text" id="e1email" tabindex="2"
											class="form-control" name="e2email" data-toogle="tooltip"
											placeholder=" Email-ID" disabled>

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Email-ID</label>
										<div id="lname1"></div>
										<input type="text" id="e2email" tabindex="2"
											class="form-control" name="e3email" data-toogle="tooltip"
											placeholder=" Email-ID" disabled>

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Email-ID</label>
										<div id="lname1"></div>
										<input type="text" id="e3email" tabindex="2"
											class="form-control" name="e3email" data-toogle="tooltip"
											placeholder=" Email-ID" disabled>

									</div>


								</div>


								<div class="row">
									<div style="margin-top: 15px;" class="col-md-3">
										<label for="firstname">Mobile Number</label>
										<div id="fname1"></div>
										<input type="text" id="townermob" tabindex="1"
											class="form-control" name="townermob" data-toogle="tooltip"
											placeholder=" Mobile Number" disabled>

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Mobile Number</label>
										<div id="lname1"></div>
										<input type="text" id="e1mob" tabindex="2"
											class="form-control" name="e1mob" data-toogle="tooltip"
											placeholder=" Mobile Number" disabled>

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Mobile Number</label>
										<div id="lname1"></div>
										<input type="text" id="e2mob" tabindex="2"
											class="form-control" name="e2mob" data-toogle="tooltip"
											placeholder=" Mobile Number" disabled>

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Mobile Number</label>
										<div id="lname1"></div>
										<input type="text" id="e3mob" tabindex="2"
											class="form-control" name="e3mob" data-toogle="tooltip"
											placeholder=" Mobile Number" disabled>

									</div>


								</div>

								<div class="row">
									<div style="margin-top: 15px;" class="col-md-1">
										<label for="firstname">Time</label>
										<div id="wrongt0">
											<input type="text" id="t0" tabindex="1" class="form-control"
												name="t0" data-toogle="tooltip" placeholder="Enter Time">
										</div>
									</div>

									<div style="margin-top: 15px;" class="col-md-2">
										<label for="firstname">&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<div id="fname1"></div>
										<select id="tt0" tabindex="2" class="form-control"
											data-toogle="tooltip" name="tt0">
											<option value="">--Please Select--</option>
											<option value="Days">Day</option>
											<option value="Hours">Hour</option>
											<option value="Minute">Min</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-1">
										<label for="firstname">Time</label>
										<div id="wrongt1">
											<input type="text" id="t1" tabindex="1" class="form-control"
												name="t1" data-toogle="tooltip" placeholder="Enter Time">
										</div>
									</div>

									<div style="margin-top: 15px;" class="col-md-2">
										<label for="firstname">&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<div id="fname1"></div>
										<select id="tt1" tabindex="2" class="form-control"
											data-toogle="tooltip" name="tt1">
											<option value="">--Please Select--</option>
											<option value="Days">Day</option>
											<option value="Hours">Hour</option>
											<option value="Minute">Min</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-1">
										<label for="firstname">Time</label>
										<div id="wrongt2">
											<input type="text" id="t2" tabindex="1" class="form-control"
												name="t2" data-toogle="tooltip" placeholder="Enter Time">
										</div>
									</div>

									<div style="margin-top: 15px;" class="col-md-2">
										<label for="firstname">&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<div id="fname1"></div>
										<select id="tt2" tabindex="2" class="form-control"
											data-toogle="tooltip" name="tt2">
											<option value="">--Please Select--</option>
											<option value="Days">Day</option>
											<option value="Hours">Hour</option>
											<option value="Minute">Min</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-1">
										<label for="firstname">Time</label>
										<div id="wrongt3">
											<input type="text" id="t3" tabindex="1" class="form-control"
												name="t3" data-toogle="tooltip" placeholder="Enter Time">
										</div>
									</div>

									<div style="margin-top: 15px;" class="col-md-2">
										<label for="firstname">&nbsp;&nbsp;&nbsp;&nbsp;</label>
										<div id="fname1"></div>
										<select id="tt3" tabindex="2" class="form-control"
											data-toogle="tooltip" name="tt3">
											<option value="">--Please Select--</option>
											<option value="Days">Day</option>
											<option value="Hours">Hour</option>
											<option value="Minute">Min</option>
										</select>

									</div>


								</div>
								<br>
								<div class="row">

									<div class="col-md-12">
										<center>

											<button type="submit" class="btn btn-primary m-t-10"
												tabindex="11" id="submit-btn" name="submit-btn">Submit
											</button>

											<button type="button" tabindex="12"
												class="btn btn-primary m-t-10" id="resetbtn" name="resetbtn">Reset</button>

										</center>

									</div>
								</div>
							</div>


						</div>
					</div>
					<div class="col-md-1"></div>
				</div>

				<div class="row">
					<div class="col-md-12"
						style="padding-left: 15px; padding-right: 15px;">
						<div class="card card-secondary">
							<div class="card-header">Ticket Owner Details</div>
							<div class="card-body">
								<div id="eeeew">

									<table class="table table1 table-striped" id="datatype">
										<thead>
											<tr>
												<th>SR NO</th>
												<th>Company Name</th>
												<th>Branch Name</th>
												<th>Category Name</th>
												<th>Priority</th>
												<th>Email Send</th>
												<th>SMS Send</th>
												<th>Ticket Owner Name</th>
												<th>Ticket Owner Email</th>
												<th>Ticket Owner Mobile</th>
												<th>Time</th>
												<th>Time Format</th>
												<th>Escalator-1 Name</th>
												<th>Escalator-1 Email</th>
												<th>Escalator-1 Mobile</th>
												<th>Time</th>
												<th>Time Format</th>
												<th>Escalator-2 Name</th>
												<th>Escalator-2 Email</th>
												<th>Escalator-2 Mobile</th>
												<th>Time</th>
												<th>Time Format</th>
												<th>Escalator-3 Name</th>
												<th>Escalator-3 Email</th>
												<th>Escalator-3 Mobile</th>
												<th>Time</th>
												<th>Time Format</th>


											</tr>
										</thead>
										<tbody>

										</tbody>

									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
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
	<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script> --%>

	<%--   <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script> --%>
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


	<script src="<%=request.getContextPath()%>/static/custom/escMatrix.js"></script>
</body>

</html>


