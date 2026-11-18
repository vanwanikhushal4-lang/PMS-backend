<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Ticket Tracking</title>
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
<!-- Select2 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">
<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderEngg.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">

			<section class="content-header">
				<div id="searchID">
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-9">
							<br> <br>
							<div class="card card-secondary">
								<div class="card-header">Ticket Tracking</div>
								<div class="card-body">
									<div class="row">

<!-- 										<div class="col-md-3"></div> -->

										<div class="col-md-6">
											<label>Time Period:</label> <select class="form-control" onchange="javascript:getlastDataEngg(this.value)"
												name="selectmonthOfGroupTicket"
												id="selectmonthOfGroupTicket">
												<option value="lastmonthFinal">Last Month</option>
												<option value="lastthreemonth">Last Three Months</option>
												<option value="lastsixmonth">Last Six Months</option>
												<option value="all">All Tickets</option>
											</select>											
										</div>

										<div class="col-md-6">
											<label for="ticketid1"> Select Ticket ID :</label>
											<div id="ticketid1">
												<select id="ticketid" tabindex="1"
													class="form-control select2" data-toogle="tooltip"
													name="ticketid">
													<!--                                                                 <option value="-1">--Please Select ID--</option>                                                                 -->
												</select>
											</div>
										</div>
<!-- 										<div class="col-md-3"></div> -->

									</div>
									<br>
									<div class="row">

										<br>
										<div class=col-md-12>
											<center>
												<input type="submit" tabindex="2"
													class="btn btn-primary m-t-10" id="submit-btn"
													name="submit" value="Submit"> <input type="reset"
													tabindex="3" class="btn btn-primary m-t-10" id="resetbtn"
													name="reset" value="Reset">
											</center>
										</div>

									</div>

								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>

				</div>



				<div id="searchResult" style="display: none">
					<div class="row">

						<div class="col-md-1"></div>
						<div class="col-md-10">

							<div class="card card-secondary">
								<div class="card-header">Ticket Tracking</div>
								<div class="card-body">

									<div class="row">
										<div class="col-md-12 text-center">
											<h2>
												Tracking Details Of <span id="T_ID"></span>
											</h2>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-12">
											<div class="col-md-1"></div>
											<div class="col-md-6">
												<span id="Label1"
													style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">Ticket
													Details :</span>
											</div>
										</div>
									</div>

									<div class="row pl-5">
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">
												Problem Ticket ID : <span id="T_ID1"></span>
											</span>
										</div>
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Raised
												By : <span id="T_REQUESTER"></span>
											</span>
										</div>
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Raised
												on : <span id="T_DATE"></span>
											</span>
										</div>
									</div>

									<div class="row pl-5">
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Ticket
												Status : <span id="STATUS"></span>
											</span>
										</div>
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Priority
												: <span id="PRIORITY"></span>
											</span>
										</div>
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Site
												: <span id="T_BRANCH"></span>
											</span>
										</div>
									</div>

									<div class="row pl-5">
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Department
												: <span id="DEPARTMENT"></span>
											</span>
										</div>
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Sub-Department
												: <span id="SUB_DEPARTMENT"></span>
											</span>
										</div>
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Location
												: <span id="LOCATION"></span>
											</span>
										</div>
									</div>

									<div class="row pl-5">
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Category
												: <span id="T_CATEGORY"></span>
											</span>
										</div>
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Sub-Category
												1 : <span id="T_SUBCAT1"></span>
											</span>
										</div>
										<div class="col-md-4">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Sub-Category
												2 : <span id="T_SUBCAT2"></span>
											</span>
										</div>
									</div>

									<div class="row pl-5">
										<div class="col-md-12">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Subject
												: <span id="T_SUBJECT"></span>
											</span>
										</div>
									</div>
									<div class="row pl-5">
										<div class="col-md-12">
											<span id="Label1"
												style="font-family: Calibri; font-size: 14px; font-weight: bold">Description
												: <span id="T_DESC"></span>
											</span>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-12">
											<div class="col-md-1"></div>
											<div class="col-md-6">
												<span id="Label1"
													style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">Ticket
													Tracking Details</span>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-12">
											<div class="col-md-1"></div>
											<div class="col-md-11">
												<div class="card-body" id="MSG1234"></div>
												
												
											</div>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-12 text-center">
											<input type="reset" tabindex="4"
												class="btn btn-primary m-t-10" id="reload-btn"
												name="reload-btn" value="Back">
										</div>
									</div>
									<br>

								</div>
							</div>
						</div>
						<div class="col-md-1"></div>
					</div>
				</div>


				<!-- <div id="searchResult">
					<div class="row">

						<div class="col-md-1"></div>
						<div class="col-md-9">

							<div class="card card-secondary">
								<div class="card-header">Ticket Tracking</div>
								<div class="card-body">

									<div class="row">
										<div class="col-md-12 text-center">
											<h2>
												Tracking of Ticket ID - <span id="T_ID"></span>
											</h2>
										</div>
										
									</div>
									<br>
									<div class="row">
										<div class="col-12">
											<div class="col-md-1"></div>
											<div class="col-md-6">
												<span id="Label1"
													style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">Ticket
													Details :</span>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-12">
											<div class="col-md-1"></div>
											<div class="col-md-6">
												<span id="Label1"
													style="font-family: Calibri; font-size: 14px; font-weight: bold">
													Ticket ID : <span id="T_ID1"></span>
												</span><br> <span id="Label1"
													style="font-family: Calibri; font-size: 14px; font-weight: bold">Raised
													By : <span id="T_REQUESTER"></span>
												</span><br> <span id="Label1"
													style="font-family: Calibri; font-size: 14px; font-weight: bold">Raised
													on : <span id="T_DATE"></span>
												</span><br> <span id="Label1"
													style="font-family: Calibri; font-size: 14px; font-weight: bold">Ticket
													Status : <span id="STATUS"></span>
												</span><br> <span id="Label1"
													style="font-family: Calibri; font-size: 14px; font-weight: bold">Priority
													: <span id="PRIORITY"></span>
												</span><br> <span id="Label1"
													style="font-family: Calibri; font-size: 14px; font-weight: bold">Site
													: <span id="T_BRANCH"></span>
												</span><br> <span id="Label1"
													style="font-family: Calibri; font-size: 14px; font-weight: bold">Category
													: <span id="T_CATEGORY"></span>
												</span><br> <span id="Label1"
													style="font-family: Calibri; font-size: 14px; font-weight: bold">Sub-Category
													: <span id="T_SUBCAT"></span>
												</span><br> <span id="Label1"
													style="font-family: Calibri; font-size: 14px; font-weight: bold">Subject
													: <span id="T_SUBJECT"></span>
												</span><br> <span id="Label1"
													style="font-family: Calibri; font-size: 14px; font-weight: bold">Description
													: <span id="T_DESC"></span>
												</span><br>
											</div>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-12">
											<div class="col-md-1"></div>
											<div class="col-md-6">
												<span id="Label1"
													style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">Ticket
													Tracking Details</span>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-12">
											<div class="col-md-1"></div>
											<div class="col-md-11">
												<span id="MSG1234"></span><br>

											</div>
										</div>
									</div>
									<br>
									<div class="row">
										<div class="col-12">
											<center>
												<input type="reset" tabindex="4"
													class="btn btn-primary m-t-10" id="reload-btn"
													name="reload-btn" value="Back">
											</center>
										</div>
									</div>
									<br>

								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>
				</div> -->
			</section>
		</div>


		<!-- /.modal-dialog -->
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
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

	<!-- Select 2 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>

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
		src="<%=request.getContextPath()%>/static/custom/engtickettracking.js"></script>

</body>

</html>


