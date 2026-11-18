<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Customization Task</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->

<!-- <link rel="stylesheet" -->
<!-- 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" -->
<!-- 	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" -->
<!-- 	crossorigin="anonymous" referrerpolicy="no-referrer" /> -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/fas-all.min.css">

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
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css"> --%>

<!-- new datatable -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/2.1.8/css/dataTables.dataTables.min.css">


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
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">

<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

body {
	font-size: 85% !important;
}

.button1 {
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	padding: 5px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 14px;
	font-weight: bold;
	margin: 2px 2px;
	cursor: pointer;
}

.button4 {
	background-color: #e7e7e7;
	color: black;
}

/*  #productdata th, #productdata td { */
/*         min-width: 80px;  /* Set a minimum width for the columns */
* /
	/*         text-overflow: ellipsis;  /* Adds ellipsis if content overflows */
	 * /
	/*         white-space: nowrap;  /* Prevent content from wrapping */ *
	/
	/*         overflow: hidden;  /* Hide overflow content */ * /
	/*     } */
	/*     /* Optional: Make the headers narrower by default */ * /
	/*     #productdata th { */
	/*         max-width: 200px;  /* Set a maximum width to avoid headers from expanding too much */
	 * /
	/*     } */
	/* Position the button container at the top-right corner */ 
.dt-buttons {
	top: 10px; /* Distance from the top */
	left: 90%; /* Distance from the right */
	z-index: 1000; /* Ensure the button is above other elements */
}

/* Style the Excel button itself */
.dt-button {
	background-color: #007bff; /* Blue background */
	color: white; /* White text color */
	border: none; /* Remove border */
	border-radius: 5px; /* Rounded corners */
	font-size: 14px; /* Set font size */
	font-weight: bold;
	cursor: pointer; /* Change cursor to pointer on hover */
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Add shadow effect */
	transition: background-color 0.3s, transform 0.2s;
	/* Smooth transitions */
}

/* Hover effect for the button */
.dt-button:hover {
	background-color: #0056b3; /* Darker blue on hover */
	transform: scale(1.05); /* Slightly enlarge button on hover */
}

/* Focus effect for the button (when clicked or selected) */
.dt-button:focus {
	outline: none; /* Remove the default focus outline */
	box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
	/* Add a blue glow when focused */
}

/* Position the button container at the top-right corner */
.dt-buttons {
	top: 10px; /* Distance from the top */
	left: 90%; /* Distance from the right */
	z-index: 1000; /* Ensure the button is above other elements */
}

/* Style the Excel button itself */
.dt-button {
	background-color: #007bff; /* Blue background */
	color: white; /* White text color */
	border: none; /* Remove border */
	border-radius: 5px; /* Rounded corners */
	font-size: 14px; /* Set font size */
	font-weight: bold;
	cursor: pointer; /* Change cursor to pointer on hover */
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Add shadow effect */
	transition: background-color 0.3s, transform 0.2s;
	/* Smooth transitions */
}

/* Hover effect for the button */
.dt-button:hover {
	background-color: #0056b3; /* Darker blue on hover */
	transform: scale(1.05); /* Slightly enlarge button on hover */
}

/* Focus effect for the button (when clicked or selected) */
.dt-button:focus {
	outline: none; /* Remove the default focus outline */
	box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
	/* Add a blue glow when focused */
}
</style>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<%
	HttpSession htt = request.getSession(true);
	 String role = (String) htt.getAttribute("role");
%>

	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<input type="hidden" id="role" name="role" value="<%=role%>">
		<input type="hidden" id="sr_no1" name="sr_no1" /> <input
			type="hidden" id="customerName" name="customerName" /> <input
			type="hidden" id="moduleName" name="moduleName" /> <input
			type="hidden" id="descriptions" name="descriptions" />
		<!-- 		<input type="hidden" id="expectedOut" name="expectedOut" /> -->


		<div class="content-wrapper">
			<section class="content-header"></section>
			<div style="padding-left: 15px; padding-right: 15px">
				<div class="card card-secondary border-secondary">
					<div class="card-header">Assign RFP Task</div>
					<div class="card-body">

						<div id="assignTableMgr"
							style="width: 100%; overflow-x: auto;  display: none; overflow-y: auto; height: 450px;">
							<table class="table" id="RFPTaskTableMgr">
								<thead>
									<tr>
										<th>Sr No</th>
										<!-- <th>Customer Name</th> -->
										<th>Product_Suit - Tool</th>
										<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Description&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
										<th>Reported By</th>
										<th>Reported Date</th>
										<th>Select AM/DM/Team Leader</th>
										<th>Download File</th>
									</tr>
								</thead>
								<tbody>
									<!-- Add some rows here to see the scrolling effect -->
								</tbody>
							</table>
							<span
								style="width: 5rem; height: 5rem; margin-left: 49%; display: none;"
								id="spin12"> <i class="fa fa-spinner fa-spin"
								style="font-size: 33px"></i>
							</span>
						</div>



						<div id="assignTableTL"
							style="width: 100%; overflow-x: auto; display: none; overflow-y: auto; height: 450px;">

							<table class="table" id="RFPTaskTableTL">
								<thead>
									<tr>

										<th>Sr No</th>
										<!-- 												<th>Customer Name</th> -->
										<th>Product_Suit - Tool</th>
										<th>Module Name</th>
										<th>Sub_Module 1</th>
										<th>Sub_Module 2</th>
										<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RFP_Points&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
										<th>Assigned_By</th>
										<th>Assigned_Date</th>
										<th>Assign To</th>
										<th>Target Date</th>
										<th>Add</th>

									</tr>
								</thead>
								<tbody>

								</tbody>
							</table>
							<span
								style="width: 5rem; height: 5rem; margin-left: 49%; display: none;"
								id="spin12"><i class="fa fa-spinner fa-spin"
								style="font-size: 33px"></i></span>
						</div>





						<div style="margin-top: 25px;" class="col-md-12">
							<center>

								<button type="submit" tabindex="8"
									class="btn btn-primary m-t-10" id="sub" name="submit"
									data-style="expand-left" onclick="reassignTask()"
									style="display: none;">
									Assign Task &nbsp;<span class="spinner-border"
										style="width: 1rem; height: 1rem; display: none;" id="spin2"></span>
								</button>
								<!-- 								<button type="reset" tabindex="8" -->
								<!-- 									class="btn btn-secondary m-t-10" id="Reset" name="Reset" -->
								<!-- 									onclick="ResetData();">Reset</button> -->
							</center>
						</div>

					</div>
				</div>
			</div>

			<br>

			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-12">
					<div class="card card-secondary"
						style="margin-left: 15px; margin-right: 15px">
						<div class="card-header">Task Assigned by Me</div>
						<div class="card-body">
							<div id="ManagerTable" style="display: none;">

								<table class="table table1 table-striped" id="productdata">
									<thead>
										<tr>
											<th>Sr No</th>
											<th>Edit</th>
											<th>Status</th>
											<!-- 												<th>Customer_Name</th> -->
											<th>Product_Suit - Tool</th>
											<th>Module Name</th>
											<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RFP_Points&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
											<th>Submitted_By</th>
											<th>Submitted Date</th>
											<th>Manager_Name</th>
											<th>Team_Leader</th>
											<th>Developer</th>
											<th>Tester</th>
											<th>Status Update_Date</th>
											<!-- 												<th>Test_Failures Count</th> -->
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
							</div>


							<div id="TLTable" style="display: none;">

								<table class="table table1 table-striped" id="productdataTL">
									<thead>
										<tr>
											<th>Sr No</th>
											<th>Edit</th>
											<th>Status</th>
											<!-- 												<th>Customer_Name</th> -->
											<th>Product_Suit - Tool</th>
											<th>Module Name</th>
											<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RFP_Points&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
											<th>Manager Name</th>
											<th>Target_Date</th>
											<th>Functional Head</th>
											<th>Team_Leader</th>
											<th>Developer</th>
											<th>Tester</th>
											<th>Status Update_Date</th>
											<!-- 												<th>Test_Failures Count</th> -->
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
							</div>

						</div>
					</div>
				</div>
				<div class="col-md-1"></div>
			</div>





			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modelcategory1" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog" style="margin-top: 3%; margin-left: 20%;">
					<div class="modal-content" style="width: 200%; height: 200%;">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Assign Task</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>



						</div>

						<div class="modal-body">
						
						<label style="color: #ff4d4d;">Note : The original task will be replaced after splitting the task. If you want to keep the original task, leave the first row as it is.</label><br>

							<button type="button" class="btn btn-primary"
								onclick="addRowData()">Add Row</button>
							<br>
							<table class="table table1 table-striped" id="rowTable">
								<thead>
									<tr>
										<!-- 												<th>Sr No</th> -->
										<th>Product Suite - Tool</th>
										<th>Module Name</th>

										<th>RFP Points</th>
										<!-- 												<th>Expected Output</th> -->

										<th>Assign To</th>
										<th>Planned Date</th>
										<th>Delete</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td style="width: 20%;"><input
											class="form-control form-control-sm" type="text"
											placeholder="Customer Name" id="CustomerName"
											name="CustomerName" readonly></td>

										<td style="width: 15%;"><input
											class="form-control form-control-sm" type="text"
											placeholder="Module Name" id="ModuleName" name="ModuleName"></td>

										<td style="width: 40%;"><input
											class="form-control form-control-sm" type="text"
											placeholder="Description" id="Description" name="Description"></td>

										<!-- 														<td><input class="form-control form-control-sm" -->
										<!-- 															type="text" placeholder="Expected Output" -->
										<!-- 															id="ExOutput" name="ExOutput"></td> -->

										<td style="width: 20%;"><select id="Developers"
											class="form-control form-control-sm" data-toggle="tooltip"
											name="Developers">
										</select></td>

										<td style="width: 10%;">
											<div class="input-group" id="addRowDate">
												<input type="date" class="form-control pull-right"
													autocomplete="off" name="PlannedDate" id="PlannedDate"
													placeholder="Select Date" dateformat="dd-MM-yyyy">
											</div>
										</td>

										<td>
											<!-- 															<button onclick="deleteRow(this)" --> <!-- 																style="background: none; border: none; cursor: pointer;"> -->
											<!-- 																<i class="fa-solid fa-trash-can fa-lg" -->
											<!-- 																	style="color: #fd4444; margin-left: 12px;"></i> -->
											<!-- 															</button> -->
										</td>

									</tr>
								</tbody>

							</table>

						</div>



						<div class="row">
							<div class="col-md-12">
								<center>
									<!-- 									<input type="submit" class="btn btn-primary m-t-10" -->
									<!-- 										id="update_client" name="update_client" -->
									<!-- 										" value="Submit" onclick="saveCustomTask()"> -->

									<button type="submit" tabindex="8"
										class="btn btn-primary m-t-10" id="submitRow" name="submit"
										data-style="expand-left" onclick="saveCustomTask()">
										Submit&nbsp;<span class="spinner-border"
											style="width: 1rem; height: 1rem; display: none;" id="spin22"></span>
									</button>

								</center>
								<br> <br> <br>
							</div>
						</div>
					</div>

					<div class="col-md-2"></div>
				</div>
				<br>
			</div>



			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modelcategory2" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog">
					<div class="modal-content" style="width: 150%; height: 200%;">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title">Update Task</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>



						</div>
						<div class="modal-body">
							<!--<form action="">-->
							<div class="row">
								<div class="col-md-1"></div>
								<!-- 								<div class="col-md-5" style="margin-top: 10px;"> -->
								<!-- 									<label>Customer Name :</label> -->
								<!-- 									<div class="form-group col-md-12" id="companyDiv2" -->
								<!-- 										style="padding: 0;"> -->
								<!-- 										<input class="form-control select2" id="customerNameUpdate2" -->
								<!-- 											style="width: 100%;" readonly> -->
								<!-- 										Add options here if needed -->

								<!-- 									</div> -->
								<!-- 								</div> -->

								<div class="col-md-5" style="margin-top: 10px;">
									<label for="">Security Tools :</label> <input
										id="securityToolUpdate2" class="form-control" tabindex="8"
										data-toogle="tooltip" name="securitysolutiondetailsUpdate"
										readonly>
								</div>
								
								<div class="col-md-5" style="margin-top: 10px;">
									<label for="rtype">RFP Points :</label>
									<textarea id="descripIssue" class="form-control" tabindex="8"
										data-toogle="tooltip" name="descripIssue" readonly></textarea>

								</div>


								<div class="col-md-1"></div>
							</div>

							<div class="row">
								<div class="col-md-1"></div>
								
								<div class="col-md-5" id="developerUpdate2Div"
									style="margin-top: 10px; display: none;">
									<label for="">Assign To :</label><br> <select
										id="developerUpdate2" class="form-control"
										data-toggle="tooltip" name="developerUpdate2">
										<option value="">--Please Select--</option>
									</select>
								</div>
								
								<div class="col-md-5" id="testerName2Div"
									style="margin-top: 10px; display: none;">
									<label for="">Tester Name:</label><br> <select
										id="testerName2" class="form-control form-control-sm"
										data-toggle="tooltip" name="testerName2">
										<option value="">-- Please Select --</option>
									</select>
								</div>
								
								
								<div class="col-md-5" id="viewDeveloperDiv"
									style="margin-top: 10px; display: none;">
									<label for="">Assign To :</label><br> <input
										id="viewDeveloper" class="form-control"
										data-toggle="tooltip" name="viewDeveloper" readonly>
								</div>
								
								<div class="col-md-5" id="viewTesterDiv"
									style="margin-top: 10px; display: none;">
									<label for="">Tester :</label><br> <input
										id="viewTester" class="form-control"
										data-toggle="tooltip" name="viewTester" readonly>
								</div>
								
								


								<div class="col-md-1"></div>


							</div>

							<div class="row">
								<div class="col-md-1"></div>
								
								<div class="col-md-5" style="margin-top: 10px;">
									<label for="">Status :</label> <input id="StatusRO"
										class="form-control" data-toggle="tooltip" name="StatusRO" readonly>
<!-- 										<option value="Assigned" style="display: none;" id="assignedT">Assigned</option> -->
<!-- 										<option value="Developed" style="display: none;" -->
<!-- 											id="developedT">Developed</option> -->
<!-- 										<option value="Tested" style="display: none;" id="testedT">Tested</option> -->
<!-- 										<option value="Ready to Deliver" style="display: none;" id="readyT">Ready to Deliver</option> -->
<!-- 										<option value="Close">Close</option> -->
<!-- 									</select> -->
								</div>

				
								<div class="col-md-5" style="margin-top: 10px;">

									<label for="">Target Date:</label>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i
												class="far fa-calendar-alt"></i>
											</span>
										</div>
										<input type="text" readonly class="form-control pull-right"
											autocomplete="off" name="plannedDate2" id="plannedDate2"
											placeholder="Please Select Date" dateformat="dd-MM-yyyy"> <i class="fas fa-sync" style="margin: 8px;" onclick="refreshDate()"></i>
									</div>
									<div class="col-md-1"></div>
								</div>



							</div>


						</div>

						<input type="hidden" id="sr_no2" name="sr_no2" value="" /> <br>

						<div class="row">
							<div class="col-md-12">
								<center>
									<input type="submit" class="btn btn-primary m-t-10"
										id="update_task" name="update_client" " value="Update"
										onclick="updateTask()">

								</center>
								<br> <br> <br>
							</div>
						</div>

					</div>
				</div>
				<div class="col-md-2"></div>
			</div>



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

	<!-- Select 2 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>

	<!-- Sweetalert 2 -->
	<script
		src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>

	<!-- DataTables -->
	<%-- 	<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script> --%>
	<%-- 	<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script> --%>
	<%-- 	<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script> --%>

	<!-- new datatable -->
	<script src="https://cdn.datatables.net/2.1.8/js/dataTables.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>

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
		src="<%=request.getContextPath()%>/static/adminlte/bower_components/moment/moment.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/custom/assignRFPTask.js"></script>


	<script>
		$('#enddatedd').datepicker({
			autoclose : true,
			format : 'dd.mm.yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});

		$('#plannedDate2').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});
	</script>
</body>
</html>