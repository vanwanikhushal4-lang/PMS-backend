
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Export Purchase Order Data</title>
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

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">
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

.datetimepicker {
	z-index: 1071 !important;
}

.button1 {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 10px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	font-weight: bold;
	margin: 4px 2px;
	cursor: pointer;
}

.button4 {
	background-color: #e7e7e7;
	color: black;
} /* Gray */
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">








			<section class="content-header">
				<div id="searchID">
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<br> <br>
							<div class="card card-secondary" id="trackinghideid">
								<div class="card-header">Export Data</div>
								<div class="card-body">
									<div class="row">

										<!--                                           <div class="col-md-3"></div> -->

										<div class="col-md-6">
											<label for="fromDate">From Date:</label>

											<!-- 											 <input class="form-control form-control-sm" type="date" -->
											<!-- 												id="fromDate" name="fromDate" required> -->

											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="far fa-calendar-alt"></i>
													</span>
												</div>
												<input type="text" readonly class="form-control pull-right"
													autocomplete="off" name="fromDate" id="fromDate"
													placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
											</div>


										</div>

										<div class="col-md-6">

											<label for="toDate">To Date:</label>

											<!-- 											<input class="form-control form-control-sm" type="date" -->
											<!-- 												id="toDate" name="toDate" required> -->

											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="far fa-calendar-alt"></i>
													</span>
												</div>
												<input type="text" readonly class="form-control pull-right"
													autocomplete="off" name="toDate" id="toDate"
													placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
											</div>

										</div>
									</div>
									<br>

									<div class="col-md-6">

										<label for="export-type">Export type:</label> <select
											id="exportdata" class="form-control">
											<option value="">--- Please Select ---</option>
											<option value="Purchase_Order">Purchase Order</option>
											<option value="Proposal">Proposal</option>
											<option value="AMC">AMC</option>
										</select>
									</div>
									<br>









									<div class="row">

										<div class="col-md-12 text-center">
											<button class="btn btn-primary" type="submit" tabindex="3"
												id="submit-btn">
												<span>Export<i
													style="display: none; margin-left: 10px;" id="spinner1"
													class="fa fa-spinner fa-spin"></i></span>
											</button>

											<input type="reset" tabindex="3"
												class="btn btn-primary m-t-10" id="resetbtn" name="reset"
												value="Reset">
										</div>

									</div>

								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>

				</div>
			</section>
			<br> <br> <br>












<!-- 			<div class="row"> -->
<!-- 				<div class="col-md-1"></div> -->
<!-- 				<div class="col-md-10"> -->

<!-- 					<center> -->
<!-- 						<br> <br> <br> <br> <br> <br> <label -->
<!-- 							for="export-type">Export type:</label> <select id="exportdata"> -->
<!-- 							<option value="PurchaseOrder">Purchase Order</option> -->
<!-- 							<option value="VELOXPROPOSAL">Proposal</option> -->
<!-- 							<option value="amc">AMC</option> -->
<!-- 						</select> -->
<!-- 						<button class="btn btn-primary" type="submit" tabindex="3" -->
<!-- 							id="submit-btn"> -->
<!-- 							<span>Export<i style="display: none; margin-left: 10px;" -->
<!-- 								id="spinner1" class="fa fa-spinner fa-spin"></i></span> -->
<!-- 						</button> -->
<!-- 					</center> -->
<!-- 					<input type="hidden" id="filnameMaskedPO" name="filnameMaskedPO"> -->
<!-- 				</div> -->
<!-- 				<div class="col-md-1"></div> -->

<!-- 			</div> -->
		</div>



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
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/adminlte/bower_components/moment/moment.js"></script>

	<script
		src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
		type="text/javascript"></script>



	<script
		src="<%=request.getContextPath()%>/static/custom/ExportAllPO.js"></script>
	<script>
		$('#fromDate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#toDate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});
	</script>




</body>

</html>


