<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Upload Compliance</title>
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
	href="https://cdn.datatables.net/2.1.8/css/dataTables.dataTables.css">
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">


<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

#data-table tbody tr {
	margin-bottom: 10px; /* Adjust the value as required */
}

label {
	margin-top: .5rem !important;
	margin-bottom: 0rem !important;
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
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>
			<section class="content-header">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">

						<div class="row">
							<div class="col-md-2"></div>
							<div class="col-md-12">
								<br> <br>
								<div class="card card-secondary">
									<!-- 									<div class="card-header">Upload Compliance</div> -->

									<div class="card-header">
										Upload Compliance <a
											href="<%=request.getContextPath()%>/PMS/DownloadComplianceSheet"
											style="color: white" title='Download'> <i
											class="fas fa-download float-right"></i><span
											class="float-right">Download&nbsp;</span>
										</a>
									</div>
									<div class="card-body">
										<div class="row">

<!-- 											<div class="col-md-4" style="margin-top: 5px;"> -->
<!-- 												<label>Customer Name :</label> -->
<!-- 												<div class="form-group col-md-12" id="companyDiv" -->
<!-- 													style="padding: 0;"> -->
<!-- 													<select class="form-control select2" id="customerName" -->
<!-- 														style="width: 100%;"> -->
<!-- 														Add options here if needed -->
<!-- 													</select> -->
<!-- 												</div> -->
<!-- 											</div> -->

											<div class="col-md-4" style="margin-top: 5px;">
												<label for="rtype">Product Suit :</label> <select
													id="productsuitdetails" class="form-control" tabindex="8"
													data-toogle="tooltip" name="productsuitdetails"
													onchange="getSecTools()">

												</select>
											</div>




											<div class="col-md-4" style="margin-top: 5px;">
												<label for="rtype">Security Tools :</label> <select
													id=securitysolutiondetails class="form-control"
													tabindex="8" data-toogle="tooltip"
													name="securitysolutiondetails">
													<option value="">-- Please Select Product Tool --</option>
												</select>
											</div>
											
											<div class="col-md-4" id="reopenReasonDiv">
												<label for="">Enter Description :</label>
												<textarea id="Description" tabindex="1" class="form-control"
													name="Description" data-toggle="tooltip"
													placeholder="Enter Description" style="height: 60px;"></textarea>
											</div>


										</div>

										<div class="row">


<!-- 											<div class="col-md-4" style="margin-top: 5px;"> -->
<!-- 												<label for="">Ref No. :</label> <input id=refNO -->
<!-- 													class="form-control" tabindex="8" data-toogle="tooltip" -->
<!-- 													name="refNO" placeholder="RFP No./ Contact No."> -->
<!-- 											</div> -->

<!-- 											<div class="col-md-4" style="margin-top: 5px;"> -->
<!-- 												<label for="salesManager">Sales Manager:</label><br> <select -->
<!-- 													id="salesManager" class="form-control" -->
<!-- 													data-toggle="tooltip" name="salesManager"> -->
<!-- 													<option value="">--Please Select--</option> -->

<!-- 												</select> -->
<!-- 											</div> -->


											



											<div class="col-md-4" >
												<label for="">Upload Compliance Sheet :</label><br>

												<form id="bulkuploaduserform" name="bulkuploaduserform"
													method="post" enctype="multipart/form-data">
													<input type="file" id="bulkUserData" name="bulkUserData"
														class="form-control" style="height: 36px; width: 100%;">


												</form>


											</div>






										</div>


										<br> <br>



										<div class="row">
											<div class="col-md-12">
												<center>
													<button type="button" class="btn btn-primary m-t-10"
														id="submitDoc" name="submitCategType"
														onclick="saveAllData()">
														Submit &nbsp; <span class="spinner-border"
															style="width: 1rem; height: 1rem; display: none;"
															id="spin1">
													</button>
													<button type="button" class="btn btn-primary m-t-10"
														id="resetType" name="resetCategType" value="Reset"
														onclick="resetAll()">Reset</button>
												</center>
											</div>
										</div>
										<br>
									</div>
								</div>
							</div>
							<div class="col-md-2"></div>
						</div>
					</div>
				</div>




				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="card card-secondary">
							<div class="card-header">Submitted Details</div>
							<div class="card-body">
								<!--<input type="submit" class="btn btn-primary m-t-10" id="Run_Rule-btn" name="submit" value="Run Rule">-->
								<div id="eeeew">

									<table class="table table1 table-striped" id="datatype"
										style="width: 100%;">
										<thead>
											<tr>
												<th>Sr No</th>
												<th>Edit</th>
												<th>Delete</th>
<!-- 												<th>Customer Name</th> -->
												<th>Product Suite</th>
												<th>Product Tool</th>
<!-- 												<th>Ref No.</th> -->
												<th>Description</th>
												<th>Product Manager</th>
												<th>Functional Head</th>
												<th>AM / DM</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody>

										</tbody>

									</table>
								</div>

							</div>
						</div>
					</div>
					<div class="col-md-2"></div>
				</div>












			</section>

			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modelcategory1" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog">
					<div class="modal-content" style="width: 150%; height: 200%;">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Update Record</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>



						</div>
						<div class="modal-body">
							<!--<form action="">-->
							<div class="row">
								<div class="col-md-1"></div>					

								<div class="col-md-5" style="margin-top: 5px;">
									<label for="rtype">Product Suit :</label> <input
										id="productsuitdetailsUpdate" class="form-control"
										tabindex="8" data-toogle="tooltip"
										name="productsuitdetailsUpdate" readonly>

								</div>
								
								<div class="col-md-5" style="margin-top: 5px;">
									<label for="">Security Tools :</label> <input
										id=securitysolutiondetailsUpdate class="form-control"
										tabindex="8" data-toogle="tooltip"
										name="securitysolutiondetailsUpdate" readonly>
								</div>
								
								<div class="col-md-1"></div>
							</div>

							<div class="row">
								<div class="col-md-1"></div>
								

								<div class="col-md-5" style="margin-top: 5px;">
									<label for="">Product Manager:</label><br> <input
										id="ImplementerNameUpdate" class="form-control"
										data-toggle="tooltip" name="ImplementerNameUpdate" readonly>
								</div>
								
								
								<div class="col-md-5" style="margin-top: 5px;">

									<label for="">Submitted Date:</label>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i
												class="far fa-calendar-alt"></i>
											</span>
										</div>
										<input type="text" readonly class="form-control pull-right"
											autocomplete="off" name="toDateUpdates" id="toDateUpdates"
											placeholder="Please Select Date" dateformat="dd.MM.yyyy">
									</div>
									<div class="col-md-1"></div>
								</div>
								
								<div class="col-md-1"></div>


							</div>


							<div class="row">
								<div class="col-md-1"></div>


							<div class="col-md-5" style="margin-top: 5px;">
									<label for="">Status:</label><br> <input id="statusText"
										class="form-control form-control-sm" data-toggle="tooltip"
										name="statusText" readonly>

								</div>
								
									<div class="col-md-5" style="margin-top: 5px;">
									<label for="">Project Status :</label><br> <select
										id="statusUpdate" class="form-control form-control-sm"
										data-toggle="tooltip" name="statusUpdate">
										<option value="">-- Please Select --</option>
										<option value="Closed">Closed</option>
										<option value="Open">Open</option>
										<option value="Avoided">Avoided</option>
										<option value="Scrapped">Scrapped</option>
									</select>

								</div>
								
							</div>



							<div class="row">
								<div class="col-md-1"></div>

								<div class="col-md-5">

									<label style="margin-left: 2px">Uploaded RFP File :<br>
										<span class="col-md-4"
										style="color: green; width: 880px; display: inline-block;"
										id="rfpFile"></span>
									</label>
									<button class="button1 button4" id="downloadfpFile"
										onclick="downloadRFPfile()">Download</button>

									<input type="hidden" id="rfpFileStandard"
										name="rfpFileStandard">
								</div>


							
							</div>

						</div>

						<input type="hidden" id="sr_no1" name="sr_no1" value="" /> <br>

						<div class="row">
							<div class="col-md-12">
								<center>
									<input type="submit" class="btn btn-primary m-t-10"
										id="update_client" name="update_client" " value="Update"
										onclick="updateClientMaster()">

								</center>
								<br> <br> <br>
							</div>
						</div>

					</div>



				</div>

				<div class="col-md-2"></div>
			</div>
		</div>
	</div>

	</div>
	</div>




	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>


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

	<%-- 	<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script> --%>

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



	<script src="https://cdn.datatables.net/2.1.8/js/dataTables.js"></script>

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
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/custom/RFPupload.js"></script>

	<script>
		$('#toDate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});

		$('#toDateUpdate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});
	</script>
</body>

</html>
