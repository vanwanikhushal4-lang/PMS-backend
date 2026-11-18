<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Engineer Report</title>

<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!--  Scripts Start -->
<!-- Font Awesome -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
<!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- summernote -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
  <link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.css" type="text/css"/>

<!-- Scripts End -->

<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

.multiselect-clear-filter:after {
	content: "\f057";
	font-family: 'Font Awesome\ 5 Free';
}

.table-condensed .prev:after {
	content: "\f060";
	font-family: 'Font Awesome\ 5 Free';
}

.table-condensed .next:after {
	content: "\f061";
	font-family: 'Font Awesome\ 5 Free';
}

label {
	margin-left: 0px;
}

.input-group-addon {
	padding: 6px 12px;
	font-size: 14px;
	font-weight: 900;
	text-align: center;
	border: 1px solid #ccc;
}

.input-group-addon:after {
	content: "\f002";
	font-family: 'Font Awesome\ 5 Free';
}

.btn-secondary {
	color: #6c757d !important;
	background-color: white !important;
	border-color: #6c757d !important;
	box-shadow: none !important;
}

.datetimepicker {
	z-index: 1071 !important;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderTP.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<section class="content-header">
				<div class="row" id="form1">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<br> <br>
						<div class="card card-secondary">
							<div class="card-header">Engineer Report</div>
							<div class="card-body">
								<div class="row">
									<div class="col-md-6">
										<label>From Date:</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i
													class="far fa-calendar-alt"></i>
												</span>
											</div>
											<input type="text" id="FromDate" tabindex="1"
												class="form-control" name="fromdate"
												placeholder="Please Select From Date" readonly>
										</div>
									</div>
									<div class="col-md-6">
										<label>To Date:</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i
													class="far fa-calendar-alt"></i>
												</span>
											</div>
											<input type="text" id="ToDate" tabindex="2"
												class="form-control" name="todate"
												placeholder="Please Select To Date" readonly>
										</div>
									</div>
								</div>
								<br>

								<div class="row">
									<div style="margin-top: 15px;" class="col-md-12">
										<center>
											<input type="submit" class="btn btn-primary m-t-10"
												id="submit-btn" name="submit" value="Submit"> <input
												type="reset" class="btn btn-primary m-t-10" id="resetbtn"
												name="reset" value="Reset">
										</center>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-3"></div>
				</div>

				<div style="padding-left: 15px; padding-right: 15px">
					<div class="card card-secondary" id="dataSet1"
						style="display: none;">
						<div class="card-header">
							Engineer Report
							<button class="btn-xs btn-secondary float-right" id="backbtn"
								name="backbtn"
								onclick="window.location.href = '<%=request.getContextPath()%>/Engg/MyReport'">
								<i class="fas fa-backward"></i><span> Back</span>
							</button>
						</div>

						<div class="card-body">
							<div class="row" id="preLoader">
								<div class="col-md-12 text-center font-weight-bold h6">
									Loading <i class="fas fa-sync fa-spin"></i>
								</div>
							</div>
							<div id="eeeew">
								<div class="row">
									<div class="col-md-3">
										<b> From Date:</b> <span id="fromD"></span>
									</div>
									<div class="col-md-3">
										<b> To Date:</b> <span id="toD"></span>
									</div>
									<div class="col-md-6">
										<b>Generated Report Date:</b> <span id="GenD"></span>
									</div>
								</div>
								<br>
								<table class="table table1 table-striped d-done"
									id="Listing_Enggwise">
									<thead>
										<tr>
											<th>Sr No</th>
											<th>Ticket ID</th>
											<th>Raise By</th>
											<th>Raise By Full Name</th>
											<th>Raise By Company</th>
											<th>Raise Date Time</th>
											<th>Status</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Category</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Subject</th>
											<th>Assign To</th>
											<th>Resolve By</th>
											<th>Resolve By Full Name</th>
											<th>Resolve By Company</th>
											<th>Engineer Activity Date Time</th>
											<th>Engineer Name</th>
											<th>Engineer Company</th>
											<th>Engineer Group</th>
											<th>Resolved By User Name</th>
											<th>Resolved By Engineer Name</th>
											<th>Resolved By Engineer Company</th>
											<th>Resolved By Date & time</th>
											<th>Close Date</th>
										</tr>
									</thead>
									<tbody>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>

		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>
	
<!-- 	Scripts start -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>

<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/moment/moment.min.js"></script>
<script 
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<!-- DataTables -->

<script
	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/resources1/Listing/jszip.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/resources1/Listing/vfs_fonts.js"></script>
<script
	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script
	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<script 
        src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.min.js"></script>
<!-- 	Scripts end -->
	
	<script src="<%=request.getContextPath()%>/static/custom/MyReport.js"></script>

</body>

</html>