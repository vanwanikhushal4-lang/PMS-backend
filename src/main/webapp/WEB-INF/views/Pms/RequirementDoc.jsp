<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Requirement Documents</title>
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
								<div class="col-md-12">
									<br> <br>
									<div class="card card-secondary">
										<div class="card-header">Requirement Documents</div>
										<div class="card-body">
											<div class="row">
												<div class="col-md-4">
													<label for="">PO Number:</label><br> <select
														id="poNumber" class="form-control" data-toggle="tooltip"
														name="poNumber" onchange="getProductSuite()">
														<option value="">--Please Select--</option>
														<!-- Add more options as needed -->
													</select>
												</div>
												<div class="col-md-4">
													<label for="producSuiteNames">Product Suite:</label><br>
													<input id="producSuiteNames" class="form-control"
														data-toggle="tooltip" name="producSuiteNames" type="text"
														readonly>
													<!-- 														<option value="">--Please Select--</option> -->
													<!-- 														Add more options as needed -->
													<!-- 													</select> -->
												</div>
												<div class="col-md-4">
													<label for="Securitytool">Security Tool</label><br> <input
														id="Securitytool" class="form-control"
														data-toggle="tooltip" name="Securitytool" type="text"
														readonly>
													<!-- 														<option value="">--Please Select--</option> -->
													<!-- 														Add more options as needed -->
													<!-- 													</select> -->
												</div>
											</div>

											<!-- Add two more dropdowns on the next line -->
											<div class="row">
												<div class="col-md-4">
													<label for="ProdManager">Product Manager:</label><br>
													<input id="ProdManager" class="form-control"
														data-toggle="tooltip" name="ProdManager" readonly>
													<!-- 														<option value="">--Please Select--</option> -->
													<!-- 														Add more options as needed -->
													<!-- 													</select> -->
												</div>
<!-- 												<div class="col-md-4"> -->
<!-- 													<label for="functionName">Function Name:</label><br> <select -->
<!-- 														id="functionName" class="form-control" -->
<!-- 														data-toggle="tooltip" name="functionName" -->
<!-- 														onchange="getNameDetails()"> -->
<!-- 														<option value="">--Please Select--</option> -->
<!-- 														Add more options as needed -->
<!-- 													</select> -->
<!-- 												</div> -->
												<div class="col-md-4">
													<label for="noteType">Note:</label><br>
													<textarea id="noteType" class="form-control col-md-12"
														style="height: 35px;" data-toggle="tooltip"
														name="noteType"></textarea>
												</div>
												
												<div class="col-md-4">
													<label for="uploadRDFile">Upload RD File:</label><br> <input
														type="file" id="uploadRDFile" name="uploadRDFile"
														class="form-control" style="height: 36px">
												</div>
												
											</div>

											<div class="row">
											
											<div class="col-md-4">
													<label for="scopeofWork">Upload Scope of Work File:</label><br> <input
														type="file" id="scopeofWork" name="scopeofWork"
														class="form-control" style="height: 36px">
											</div>
											
											<div class="col-md-4">
													<label for="RFPFile">Upload RFP File:</label><br> <input
														type="file" id="RFPFile" name="RFPFile"
														class="form-control" style="height: 36px">
											</div>
											
											<div class="col-md-4">
													<label for="RFPFile">Upload Other File:</label><br> <input
														type="file" id="otherFile" name="otherFile"
														class="form-control" style="height: 36px">
											</div>
											</div>
											
											<div class = "row">
												<div class="col-md-4" id="maskedPOUploadDiv">
													<label style="margin-left: 2px">Download Masked PO File :
														<div>
															<span class="col-md-6"
																style="color: green; width: 645px; display: inline-block;"
																id="maskedPOfile"></span>
														</div>
													</label>
													<button class="button1 button4" id="filnameMaskedPO"
														onclick="maskedPOStandard()">Download</button>
												</div>
												<input type="hidden" id="filnameMaskedPO"
													name="filnameMaskedPO">
											
											</div>
											<br> <br>



											<div class="row">
												<div class="col-md-12">
													<center>
														<button type="button" class="btn btn-primary m-t-10"
															id="submitDoc" name="submitCategType"
															onclick="saveAllData()">Submit <span class="spinner-border"
												style="width: 1rem; height: 1rem;" id="spin"></button>
														<button type="button" class="btn btn-primary m-t-10"
															id="resetType" name="resetCategType" value="Reset">Reset</button>
													</center>
												</div>
											</div>
											<br>
										</div>
									</div>
								</div>
								<div class="col-md-2"></div>
							</div>



							<div class="card card-secondary" id="registrationform"
								style="display: none;">
								<div class="card-header">
									Requirement Documents For <span id="fName"></span>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-md-4"></div>
										<div class="col-md-4"
											style="margin-left: 62px; font-size: 15px; color: red;">
											<strong>Requirement Documents</strong>
										</div>
										<div class="col-md-4"></div>
									</div>


									<div class="container">
										<div class="row"
											style="display: flex; justify-content: center;">
											<div class="col-md-2">
												<label for="designation">Designation:</label> <select
													id="designation" class="form-control" data-toggle="tooltip"
													name="designation" onchange="getUserName()">
													<option value="">--Please Select--</option>
												</select>
											</div>

											<div class="col-md-2">
												<label for="username">User Name:</label> <select
													id="username" class="form-control" data-toggle="tooltip"
													name="username" onchange="getUserId()">
													<option value="">--Please Select--</option>
												</select>
											</div>

											<div class="col-md-2">
												<label for="userid">User ID:</label> <input type="text"
													id="userid" tabindex="3" class="form-control"
													data-toggle="tooltip" name="userid" readonly>
											</div>

											<div class="col-md-2">
												<label for="description">Description:</label>
												<textarea id="description" style="height: 30px" tabindex="3"
													class="form-control" name="description"
													placeholder="Enter Description"></textarea>

											</div>

											<div class="col-md-2">
												<button type="button" tabindex="3" style="margin-top: 24px;"
													class="btn btn-sm btn-primary" onclick="addRow()">Add
													Row</button>
											</div>
										</div>
										<br>

										<div class="row ml-5">
											<div class="col-md-1"></div>
											<div class="col-md-9">
												<table class="col-md-12" id="data-table">

													<tbody>

													</tbody>
												</table>
											</div>
											<div class="col-md-1"></div>
										</div>

										<!-- 										<div class="container"> -->
										<!-- 											<div class="row" Style="margin-left: 58px;"> -->
										<!-- 												<div class="col-md-2"> -->
										<!-- 													<label for="uploadRDFile">Upload File </label> <input -->
										<!-- 														type="file" id="uploadRDFile" name="uploadRDFile" -->
										<!-- 														class="form-control" style="height: 36px; width: 271px;"> -->
										<!-- 													</select> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</div> -->

										<br>
										<div>
											<center>

												<button type="button" class="btn btn-primary m-t-10"
													tabindex="4" id="submit-btn" name="submit"
													onclick="submitData()">
													Submit&nbsp;<span class="spinner-border"
												style="width: 1rem; height: 1rem;" id="spin1">
												</button>

												<button type="button" tabindex="5"
													class="btn btn-secondary m-t-10" id="resetbtn" name="reset">Reset</button>

											</center>
										</div>
									</div>
								</div>
							</div>
						</form>

					</div>
				</div>


				<!-- 				<div class="row" id="rowid"> -->
				<!-- 					<div class="col-md-2"></div> -->
				<!-- 					<div class="col-md-12"> -->
				<!-- 						<div class="card card-secondary" -->
				<!-- 							style="margin-left: 15px; margin-right: 15px"> -->
				<!-- 							<div class="card-header">RD Details</div> -->
				<!-- 							<div class="card-body"> -->
				<!-- 								<div id="eeeew"> -->

				<!-- 									<table class="table table1 table-striped" id="rdDetails"> -->
				<!-- 										<thead> -->
				<!-- 											<tr> -->
				<!-- 												<th>Sr No</th> -->
				<!-- 												<th>RD_ ID</th> -->
				<!-- 												<th>PO Number</th> -->
				<!-- 												<th>Product Suite</th> -->
				<!-- 												<th>Security Tool</th> -->
				<!-- 												<th>product Manager</th> -->
				<!-- 												<th>Function Name</th> -->
				<!-- 												<th>Note</th> -->
				<!-- 												<th>Upload file</th> -->
				<!-- 												<th>Masked PO</th> -->
				<!-- 											</tr> -->
				<!-- 										</thead> -->
				<!-- 										<tbody> -->

				<!-- 										</tbody> -->

				<!-- 									</table> -->
				<!-- 								</div> -->

				<!-- 							</div> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 					<div class="col-md-2"></div> -->
				<!-- 				</div> -->
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
		src="<%=request.getContextPath()%>/static/custom/requirementDoc.js"></script>
</body>

</html>
