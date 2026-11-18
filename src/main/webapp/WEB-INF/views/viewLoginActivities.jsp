<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Login Report</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/adminlte/bower_components/bootstrap/dist/css/bootstrap.min.css"> --%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
	
		
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/fas-all.min.css">
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
<%--  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css"> --%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">

<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">

 <link rel="stylesheet" href="<%=request.getContextPath()%>/static/adminlte/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css">

 <link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
 --%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

body {
	font-size: 85% !important;
}
</style>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<section class="content-header"></section>



			<div class="container">
				<!-- Container to center the card -->
				<div class="row justify-content-center">
					<!-- Row to center the card -->
					<div class="col-md-8">
						<!-- Medium width for the card -->
						<div class="card card-secondary border-secondary"
							id="trackinghideid">
							<div class="card-header">Select Fields</div>
							<div class="card-body">
								<div class="row">
									<div class="col-md-6" id="SelectActiveDiv">
										<label for="">Type :</label> <select id="selectType2"
											tabindex="9" class="form-control" data-toogle="tooltip"
											name="selectType2" onchange="TrackType()">
											<option value="">---Please Select---</option>
<!-- 											<option value="With Date">With Date</option> -->
											<option value="Active">Active</option>
											<option value="In-Active">In-Active</option>
										</select>
									</div>

									<div class="col-md-6">
										<label for="">Role :</label> <select id="selecttype"
											tabindex="9" class="form-control" data-toogle="tooltip"
											name="selecttype">
											<option value="">---Please Select---</option>
<!-- 											<option value="Sales_Initiator','Sales_Manager">Sales</option> -->
<!-- 											<option value="Implementor" id="Manager">Manager</option> -->
											<option value="Developer">Developer</option>
											<option value="Tester">Tester</option>
<!-- 											<option value="Support">Support</option> -->
											<option value="All">All</option>
										</select>
									</div>
								</div>



								<div class="row" id="DatesDiv"
									style="display: none; margin-top: 15px;">

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

										<!-- 											<label> Time Period :</label> <select class="form-control" -->
										<!-- 												onchange="javascript:getlastData(this.value)" -->
										<!-- 												name="selectmonthOfGroupTicket" -->
										<!-- 												id="selectmonthOfGroupTicket"> -->
										<!-- 												<option value="lastday">Last 24 Hour</option> -->
										<!-- 												<option value="lastweek">Last Week</option>												 -->
										<!-- 												<option value="lastmonthFinal">Last Month</option> -->
										<!-- 												<option value="lastthreemonth">Last Three Months</option> -->
										<!-- 												<option value="lastsixmonth">Last Six Months</option> -->
										<!-- <!-- 												<option value="all">All Tickets</option> -->

										<!-- 											</select> -->
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

								<br> <br>
								<div class="row">

									<div class="col-md-12 text-center">

										<button type="button" tabindex="8"
											class="btn btn-primary m-t-10" id="submit-btn"
											name="submit-btn" data-style="expand-left">
											Submit&nbsp;<span class="spinner-border"
												style="width: 1rem; height: 1rem; display: none;"
												id="spin11"> 
											</span>
										</button>

										<input type="reset" tabindex="3"
											class="btn btn-primary m-t-10" id="resetbtn" name="reset"
											value="Reset">
									</div>

								</div>

							</div>
						</div>
					</div>

					<div class="col-md-12">
						<!-- Add your table and spinner here -->
						<div class="card card-secondary border-secondary" id="dataCard" style="display:none;">
							<div class="card-header">Login Report</div>
							<div class="card-body">

								<table class="table table1 table-striped" id="ActivityTable" style="width:100%;">
									<thead>
										<tr>
											<th>Name</th>
											<th>Role Type</th>
											<th>Last Login Date</th>
											<th>In-active Days</th>                                        
<!-- 											<th>Activity</th> -->

										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<span
									style="width: 5rem; height: 5rem; margin-left: 480px; display: none;"
									id="spin12"><i class="fa fa-spinner fa-spin"
									style="font-size: 33px"></i></span>

							</div>
						</div>
					</div>



				</div>
			</div>


			<br>
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
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
	<%--  <script src="<%=request.getContextPath()%>/static/resources/js/jquery.min.js"></script>
 
 
 
 <script src="<%=request.getContextPath()%>/static/resources/js/jquery-ui.min.js"></script>
 <script src="<%=request.getContextPath()%>/static/resources/Bootstrap/bootstrap.js"></script>
    
  <script src="<%=request.getContextPath()%>/static/resources/Bootstrap/bootstrap.min.js"></script> --%>
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

	<!--<script src="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>-->
	<!-- Tempusdominus Bootstrap 4 -->
	<%-- <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>

<script src="<%=request.getContextPath()%>/static/AdminLTE_3/dist/js/demo.js"></script> --%>

	<!-- Sweetalert 2 -->
	<script
		src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>


	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/dataTables.buttons.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.bootstrap.min.js"></script>
		
	

<!-- 	<script -->
<%-- 		src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script> --%>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/jszip.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.html5.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.print.min.js"></script>
	<%--      <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
 <script src="<%=request.getContextPath()%>/static/js/bootstrap-datepicker.min.js"></script>  
 <script src="<%=request.getContextPath()%>/static/custom/addcompany.js"></script> 
<script src="<%=request.getContextPath()%>/static/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>  --%>

	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
		
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/viewLoginActivities.js"></script>

	<script type="text/javascript">
		$('#fromDate').datepicker({
			autoclose : true,
			format : 'dd.mm.yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});

		$('#toDate').datepicker({
			autoclose : true,
			format : 'dd.mm.yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});
		
	</script>
</body>
</html>