<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Add Ticket Owner</title>
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
							<div class="card-header">Add Ticket Owner</div>
							<div class="card-body">
								<div class="row">
									<div style="margin-top: 15px;" class="col-md-4">
										<label for="firstname">Company Name</label>
										<div id="fname1"></div>
										<select id="company" tabindex="2" class="form-control"
											data-toogle="tooltip" name="company">
											<option value="">--Please Select--</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-4">
										<label for="lastname">Branch Name</label>
										<div id="lname1"></div>
										<select id="branch" tabindex="2" class="form-control"
											data-toogle="tooltip" name="branch">
											<option value="">--Please Select--</option>
										</select>

									</div>

									<div style="margin-top: 15px;" class="col-md-4">
										<label for="lastname">Category Name</label>
										<div id="lname1"></div>
										<select id="category" tabindex="2" class="form-control"
											data-toogle="tooltip" name="category">
											<option value="">--Please Select--</option>
										</select>

									</div>

								</div>
								<div class="row">

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="user">Ticket Owner Name</label><label id="user1"></label>
										<input type="text" id="ticowner" tabindex="2"
											class="form-control" name="ticowner" data-toogle="tooltip"
											placeholder="Enter Ticket Owner Name">

									</div>
									<div style="margin-top: 15px;" class="col-md-3">
										<label for="pass">Escalator-1 Name</label>&nbsp;&nbsp;&nbsp;<label
											id="label"></label> <input type="hidden" id="length">
										<input type="text" id="esc1" tabindex="2" class="form-control"
											minlength="8" maxlength="15" name="esc1"
											onfocusout="checkPassstrength();" data-toogle="tooltip"
											placeholder="Enter Escalation-1 Name">

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="pass">Escalator-2 Name </label>&nbsp;&nbsp;&nbsp;<label
											id="label"></label> <input type="hidden" id="length">
										<input type="text" id="esc2" tabindex="2" class="form-control"
											minlength="8" maxlength="15" name="esc2"
											onfocusout="checkPassstrength();" data-toogle="tooltip"
											placeholder="Enter Escalation-2 Name">

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="pass">Escalator-3 Name </label>&nbsp;&nbsp;&nbsp;<label
											id="label"></label> <input type="hidden" id="length">
										<input type="text" id="esc3" tabindex="2" class="form-control"
											minlength="8" maxlength="15" name="esc3"
											onfocusout="checkPassstrength();" data-toogle="tooltip"
											placeholder="Enter Escalation-3 Name">

									</div>



								</div>

								<div class="row">
									<div style="margin-top: 15px;" class="col-md-3">
										<label for="firstname">Email-ID</label>
										<div id="fname1"></div>
										<input type="text" id="towneremail" tabindex="2"
											class="form-control" name="towneremail" data-toogle="tooltip"
											placeholder="Enter Email-ID">

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Email-ID</label>
										<div id="lname1"></div>
										<input type="text" id="e1email" tabindex="2"
											class="form-control" name="e2email" data-toogle="tooltip"
											placeholder="Enter Email-ID">

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Email-ID</label>
										<div id="lname1"></div>
										<input type="text" id="e2email" tabindex="2"
											class="form-control" name="e3email" data-toogle="tooltip"
											placeholder="Enter Email-ID">

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Email-ID</label>
										<div id="lname1"></div>
										<input type="text" id="e3email" tabindex="2"
											class="form-control" name="e3email" data-toogle="tooltip"
											placeholder="Enter Email-ID">

									</div>


								</div>


								<div class="row">
									<div style="margin-top: 15px;" class="col-md-3">
										<label for="firstname">Mobile Number</label>
										<div id="fname1"></div>
										<input type="text" id="townermob" tabindex="2"
											class="form-control" name="townermob" data-toogle="tooltip"
											placeholder="Enter Mobile Number">

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Mobile Number</label>
										<div id="lname1"></div>
										<input type="text" id="e1mob" tabindex="2"
											class="form-control" name="e1mob" data-toogle="tooltip"
											placeholder="Enter Mobile Number">

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Mobile Number</label>
										<div id="lname1"></div>
										<input type="text" id="e2mob" tabindex="2"
											class="form-control" name="e2mob" data-toogle="tooltip"
											placeholder="Enter Mobile Number">

									</div>

									<div style="margin-top: 15px;" class="col-md-3">
										<label for="lastname">Mobile Number</label>
										<div id="lname1"></div>
										<input type="text" id="e3mob" tabindex="2"
											class="form-control" name="e3mob" data-toogle="tooltip"
											placeholder="Enter Mobile Number">

									</div>


								</div>




								<div class="row">

									<div style="margin-top: 15px;" class="col-md-12">
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
				</div>

				<div class="card card-secondary"
					style="margin-left: 15px; margin-right: 15px">
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
										<th>Ticket Owner Name</th>
										<th>Ticket Owner Email</th>
										<th>Ticket Owner Mobile</th>
										<th>Escalator-1 Name</th>
										<th>Escalator-1 Email</th>
										<th>Escalator-1 Mobile</th>
										<th>Escalator-2 Name</th>
										<th>Escalator-2 Email</th>
										<th>Escalator-2 Mobile</th>
										<th>Escalator-3 Name</th>
										<th>Escalator-3 Email</th>
										<th>Escalator-3 Mobile</th>


									</tr>
								</thead>
								<tbody>

								</tbody>

							</table>
						</div>
					</div>
				</div>
			</section>

		</div>

		<div class="row">


			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modeledituser" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Update User</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px">
								<span aria-hidden="true">&times;</span>
							</button>


						</div>
						<div class="modal-body">
							<!--<form action="">-->

							<div class="row">
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="firstnameupdate1">First Name</label> <input
										type="text" id="fnameupdate" tabindex="13"
										class="form-control" name="fnameupdate" data-toogle="tooltip"
										placeholder="Enter First name">

								</div>

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="lastnameupdate1">Last Name</label> <input
										type="text" id="lnameupdate" tabindex="14"
										class="form-control" name="lnameupdate" data-toogle="tooltip"
										placeholder="Enter Last name">

								</div>
							</div>
							<div class="row">

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="userupdate1">User Name</label><label
										id="userupdate1"></label> <input type="text" id="userupdate"
										class="form-control" name="userupdate" data-toogle="tooltip"
										placeholder="Enter User Name" readonly>

								</div>
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="passupdate1">Password</label>&nbsp;&nbsp;&nbsp;<label
										id="labelupdate"></label> <input type="hidden"
										id="lengthupdate"> <input type="password"
										id="passupdate" tabindex="15" class="form-control"
										minlength="8" maxlength="15" name="passupdate"
										onfocusout="checkPassstrengthupdate();" data-toogle="tooltip"
										placeholder="Enter Password"> <span id="noteupdate"
										style="display: none; font-size: 12px" class="text-danger">Password
										length must be Min 8 characters & Max 15 characters. and must
										contain at least one small & one capital alphabet & one
										special character and numeric digit.</span>
								</div>
							</div>
							<div class="row">
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="Cpassupdate">Confirm Password</label> <input
										type="hidden" id="passnotmatchupdate"> <input
										type="password" id="Cpassupdate" tabindex="16" maxlength="15"
										class="form-control" name="Cpassupdate" data-toogle="tooltip"
										onfocusout="checkPassupdate();"
										placeholder="Enter Confirm Password"> <span
										id="note1update" style="display: none;"></span>
								</div>
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="companynameupdate1">Company Name</label> <select
										id="cnameupdate" class="form-control" tabindex="17"
										data-toogle="tooltip" name="cnameupdate"
										onchange="getSiteDetailsupdate(this.value)">

									</select>
								</div>
							</div>
							<div class="row">
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="sitenameupdate1">Site Name</label> <select
										id="snameupdate" class="form-control" tabindex="18"
										data-toogle="tooltip" name="snameupdate">
										<option value="">--Please Select--</option>

									</select>
								</div>
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="departmentnameupdate1">Department Name</label>
									<!--                                            <input type="text" id="dnameupdate" tabindex="19"  maxlength="15" class="form-control" name="dnameupdate" data-toogle="tooltip" placeholder="Enter Department Name">-->
									<select id="dnameupdate" class="form-control" tabindex="19"
										data-toogle="tooltip" name="dnameupdate"
										onchange="getDeptDetailsupdate(this.value)">
										<option value="">--Please Select--</option>

									</select>

								</div>
							</div>
							<div class="row">
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="mailupdate1">Email-ID</label>
									<div id="emailupdate"></div>
									<input type="text" id="mailupdate" tabindex="20"
										class="form-control" name="mailupdate" data-toogle="tooltip"
										placeholder="Enter Email-ID">

								</div>

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="cnoupdate1">Contact Number</label>
									<div id="phnnnoupdate"></div>
									<input type="number" id="cnoupdate" tabindex="21"
										class="form-control" name="cnoupdate" data-toogle="tooltip"
										placeholder="Enter Contact Number">

								</div>

							</div>
							<div class="row">
								<input type="hidden" id="sr_no">
								<div style="margin-top: 15px;" class="col-md-12">
									<center>

										<button type="submit" class="btn btn-primary m-t-10"
											tabindex="22" id="updateuser-btn" name="update">Update</button>


									</center>
								</div>
							</div>


						</div>

						<div class="col-md-2"></div>
					</div>

					<!--</form>-->



				</div>

			</div>

			<!-- /.modal-content -->
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


	<script
		src="<%=request.getContextPath()%>/static/custom/addticketowner.js"></script>
</body>

</html>


