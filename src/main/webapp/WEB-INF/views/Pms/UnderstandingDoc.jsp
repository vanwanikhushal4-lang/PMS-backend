<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Understanding Documents</title>
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





<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Include Bootstrap JS and CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

<!-- Include Bootstrap-select JS and CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/css/bootstrap-select.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/js/bootstrap-select.min.js"></script>






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
						<form id="form" name="form" method="post"
							enctype="multipart/form-data">
							<div class="row">
								<div class="col-md-2"></div>
								<div class="col-md-8">
									<br> <br>
									<div class="card card-secondary">
										<div class="card-header">Understanding Documents</div>
										<div class="card-body">
											<div class="row">
												<div class="col-md-1"></div>
												<div class="col-md-10">


													<div
														class="form-inline d-flex text-align justify-content-center">
														<div class="form-group">
															<label class="control-label" for="funcNamess">Select
																RD :</label>&nbsp;&nbsp;&nbsp;
														</div>
														<select id="rdNumber" name="rdNumber" class=""
															data-live-search="true" data-live-search-style="contains"
															title="Please Select RD" onchange="resetRD()"></select>
														<div style="margin-top: 30px;"
															class="col-md-12 text-center">
															<button type="button" class="btn btn-primary m-t-10"
																id="Selectrd" name="Selectrd">Submit</button>
															<button type="button" class="btn btn-secondary m-t-10"
																id="resetrd" name="resetrd" value="Reset"
																onclick="resetRDNum()">Reset</button>
														</div>
													</div>
													

												</div>
												<div class="col-md-1"></div>
											</div>
										</div>



										<br>
									</div>
								</div>

								<div class="col-md-2"></div>
							</div>

							<div class="row">

								<!-- 								<div class="col-md-2"></div> -->
								<div class="col-md-12">
									<br> <br>
									<div class="card card-secondary" id="RD">
										<div class="card-header">Understanding Documents</div>
										<div class="card-body">
											<div id="UD">
												<div class="card card-secondary">
													<div class="col-md-4"
														style="margin-left: 318px; font-size: 15px; color: red;">
														<strong>Requirement Document Details</strong>
													</div>
													<div class="card-body">
														<div class="row">
															<div class="col-md-4">
																<label for="">PO Number:</label><br> <input
																	id="documentType2" class="form-control"
																	data-toggle="tooltip" name="documentType" readonly>

															</div>
															<div class="col-md-4">
																<label for="documentType3">Product Suite:</label><br>
																<input id="documentType3" class="form-control"
																	data-toggle="tooltip" name="documentType3" readonly>
															</div>
															<div class="col-md-4">
																<label for="documentType1">Security Tool</label><br>
																<input id="documentType1" class="form-control"
																	data-toggle="tooltip" name="documentType1" readonly>

															</div>
														</div>

														<!-- Add two more dropdowns on the next line -->
														<div class="row">
															<div class="col-md-4">
																<label for="documentType4">Product Manager:</label><br>
																<input id="documentType4" class="form-control"
																	data-toggle="tooltip" name="documentType4" readonly>

															</div>
															<div class="col-md-4" style="Display: none;">
																<label for="documentType5">Function Name:</label><br>
																<input id="documentType5" class="form-control"
																	data-toggle="tooltip" name="documentType" readonly>
															</div>

															<div class="col-md-4">
																<label for="noteType">Note:</label><br>
																<textarea id="noteType" class="form-control"
																	style="height: 35px;" data-toggle="tooltip"
																	name="noteType" readonly class="col-md-4"></textarea>
															</div>

														</div>

														<!-- Add Note Type dropdown, Choose File input, and Function Name input -->
														<div class="row">



															<!-- 															<div class="col-md-4"> -->
															<!-- 																<label for="fileInput">Download RD File:</label><br> -->

															<!-- 																<button type="button" onclick="downloadFile()">Download</button> -->
															<!-- 															</div> -->

															<div style="margin-top: 15px;" class="col-md-4"
																id="rdUploadDiv">
																<label style="margin-left: 2px"> RD File :<br>
																	<span class="col-md-4"
																	style="color: green; width: 645px; display: inline-block;"
																	id="rduploadfile"></span>
																</label>
																<button class="button1 button4" id="downHiderdfile"
																	onclick="downFileStandard()">Download</button>
															</div>
															<input type="hidden" id="filenameStandard"
																name="filenameStandard">



															<div style="margin-top: 15px;" class="col-md-4"
																id="maskedUploadDiv">
																<label style="margin-left: 2px">Masked POFile :<br>
																	<span class="col-md-4"
																	style="color: green; width: 645px; display: inline-block;"
																	id="maskeduploadfile"></span>
																</label>
																<button class="button1 button4" id="downHidemaskedfile"
																	onclick="maskedStandard()">Download</button>
															</div>
															<input type="hidden" id="masekdfileStandard"
																name="masekdfileStandard">


															<!-- Scope of Work File -->
															<div style="margin-top: 15px;" class="col-md-4"
																id="scopeUploadDiv">
																<label style="margin-left: 2px">Scope of Work
																	File :<br> <span class="col-md-4"
																	style="color: green; width: 645px; display: inline-block;"
																	id="scopeuploadfile"></span>
																</label>
																<button class="button1 button4" id="downHidescopefile"
																	onclick="scopefileDownload()">Download</button>
															</div>


														</div>

														<div class="row">

															<div style="margin-top: 15px;" class="col-md-4"
																id="RFPUploadDiv">
																<label style="margin-left: 2px">RFP File :<br>
																	<span class="col-md-4"
																	style="color: green; width: 645px; display: inline-block;"
																	id="RFPuploadfile"></span>
																</label>
																<button class="button1 button4" id="downHideRFPfile"
																	onclick="RFPfileDownload()">Download</button>
															</div>


															<div style="margin-top: 15px;" class="col-md-4"
																id="otherUploadDiv">
																<label style="margin-left: 2px">Other File :<br>
																	<span class="col-md-4"
																	style="color: green; width: 645px; display: inline-block;"
																	id="otheruploadfile"></span>
																</label>
																<button class="button1 button4" id="downHideotherfile"
																	onclick="otherfileDownload()">Download</button>
															</div>


														</div>



														<br>
													</div>
												</div>
											</div>

											<div class="row">
												<div class="col-md-4">
													<label for="">Project Description</label><br>
													<textarea id="projectDesc" class="form-control" rows="4"
														name="projectDesc" style="height: 31px;" class="col-md-4"
														placeholder="Enter Project Description"></textarea>
												</div>


												<div class="col-md-4">
													<label for="">Project Objectives</label><br>
													<textarea id="projectObj" class="form-control" rows="4"
														name="projectObj" style="height: 31px;" class="col-md-4"
														placeholder="Enter Project Objectives"></textarea>
												</div>

												<div class="col-md-4">
													<label for="">Project Scope</label><br>
													<textarea id="projectScope" class="form-control" rows="4"
														name="projectScope" style="height: 31px;" class="col-md-4"
														placeholder="Enter Project Scope"></textarea>
												</div>

											</div>


											<div class="row">
												<div class="col-md-4">
													<label for="">Functional Requirements</label><br>
													<textarea id="funcReq" class="form-control" rows="4"
														name="funcReq" style="height: 31px;" class="col-md-4"
														placeholder="Enter Functional Requirements"></textarea>
												</div>


												<div class="col-md-4">
													<label for="">Non-Functional Requirements</label><br>
													<textarea id="nonFuncReq" class="form-control" rows="4"
														name="nonFuncReq" style="height: 31px;" class="col-md-4"
														placeholder="Enter Non-Functional Requirements"></textarea>
												</div>

												<div class="col-md-4">
													<label for="">Technical Requirements</label><br>
													<textarea id="techReq" class="form-control" rows="4"
														name="techReq" style="height: 31px;" class="col-md-4"
														placeholder="Enter Technical Requirement"></textarea>
												</div>

											</div>

											<div class="row">
												<div class="col-md-4">
													<label for="fromDate">Project Start Date:</label>

													<div class="input-group">
														<div class="input-group-prepend">
															<span class="input-group-text"> <i
																class="far fa-calendar-alt"></i>
															</span>
														</div>
														<input type="text" readonly
															class="form-control pull-right" autocomplete="off"
															name="fromDate" id="startDate"
															placeholder="Select Start Date" dateformat="dd-MMM-yyyy">
													</div>
												</div>

												<div class="col-md-4">
													<label for="toDate">Project End Date:</label>
													<div class="input-group">
														<div class="input-group-prepend">
															<span class="input-group-text"> <i
																class="far fa-calendar-alt"></i>
															</span>
														</div>
														<input type="text" readonly
															class="form-control pull-right" autocomplete="off"
															name="toDate" id="endDate" placeholder="Select End Date"
															dateformat="dd-MMM-yyyy">
													</div>
												</div>
											</div>




											<div class="row">
												<!-- 												<div class="col-md-1"></div> -->

												<div class="col-md-4">
													<label for="">Team Leader:</label><br> <select
														id="Teamlead" class="form-control" data-toogle="tooltip"
														name="Teamlead" onchange="getTeamlead()">
														<!-- 														<option value="">--Please Select--</option> -->

													</select>
												</div>
												<!-- 												<div class="col-md-1"></div> -->


												<div class="col-md-4">
													<label for="">Developers :</label><br> <select
														id="Dev" class="form-control" data-toogle="tooltip"
														name="Dev">
														<option value="">--Please Select--</option>
														
													</select>
												</div>
												<div class="col-md-4">
													<label for="">Note:</label><br>
													<textarea id="not" class="form-control" rows="4" name="not"
														style="height: 31px;" class="col-md-4"></textarea>
												</div>

											</div>

											<div class="row">
												<div class="col-md-4">
													<label for="fileInput">Upload UD:</label><br> <input
														type="file" id="fileInput" name="fileInput"
														class="form-control" style="height: 36px">
												</div>
												
												
												<div class="col-md-4">
													<label for="fileInput">Upload Other File:</label><br> <input
														type="file" id="otherFile" name="otherFile"
														class="form-control" style="height: 36px">
												</div>
												
												
												
												<!-- 												<div class="col-md-4"> -->
												<!-- 													<label for="fileInput">Masked PO:</label><br> <input -->
												<!-- 														type="file" id="fileInput" name="fileInput" -->
												<!-- 														class="form-control" accept=".pdf, .doc, .docx" -->
												<!-- 														style="height: 36px"> -->
												<!-- 												</div> -->
											</div>
											<br> <br> <br>










											<div class="row">
												<div style="margin-top: 15px;" class="col-md-12 text-center">
													<button type="button" class="btn btn-primary m-t-10"
														id="submitDoc" name="submitCategType"
														onclick="submitData()">
														Submit&nbsp;<span class="spinner-border"
															style="width: 1rem; height: 1rem;" id="spin">
													</button>
													<button type="button" class="btn btn-secondary m-t-10"
														id="resetbtn1" name="resetCategType" value="Reset">Reset</button>
												</div>
											</div>
										</div>
										<br>
									</div>
								</div>
								<div class="col-md-2"></div>
							</div>


							<!-- 							new -->
							<div class="col-md-2"></div>
					</div>
				</div>
		</div>
		<br>
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


	<!-- 	<script -->
	<!-- 		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->

	<!-- Include Bootstrap JS and CSS -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/js/bootstrap-select.min.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select-filter/0.8.1/bootstrap-select-filter.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/UnderstandingDoc.js"></script>

	<script type="text/javascript">
		$('#startDate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#endDate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});
	</script>


</body>

</html>
