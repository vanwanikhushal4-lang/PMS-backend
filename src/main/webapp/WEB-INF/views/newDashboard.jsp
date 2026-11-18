<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/fas-all.min.css">

<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/adminlte/bower_components/bootstrap/dist/css/bootstrap.min.css"> --%>
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
<%--  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css"> --%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">

<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">

 <link rel="stylesheet" href="<%=request.getContextPath()%>/static/adminlte/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css">

 <link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
 --%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css"
	type="text/css" />

<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

body {
	font-size: 85% !important;
}

.highcharts-figure, .highcharts-data-table table {
	min-width: 310px;
	max-width: 800px;
	margin: 1em auto;
}

#containerDiv {
	height: 400px;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #ebebeb;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}

.highcharts-data-table caption {
	padding: 1em 0;
	font-size: 1.2em;
	color: #555;
}

.highcharts-data-table th {
	font-weight: 600;
	padding: 0.5em;
}

.highcharts-data-table td, .highcharts-data-table th,
	.highcharts-data-table caption {
	padding: 0.5em;
}

.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even)
	{
	background: #f8f8f8;
}

.highcharts-data-table tr:hover {
	background: #f1f7ff;
}

.highcharts-description {
	margin: 0.3rem 10px;
}



/* pie chart */
#containerDiv {
    height: 400px;
}

.highcharts-figure,
.highcharts-data-table table {
    min-width: 310px;
    max-width: 800px;
    margin: 1em auto;
}

.highcharts-data-table table {
    font-family: Verdana, sans-serif;
    border-collapse: collapse;
    border: 1px solid #ebebeb;
    margin: 10px auto;
    text-align: center;
    width: 100%;
    max-width: 500px;
}

.highcharts-data-table caption {
    padding: 1em 0;
    font-size: 1.2em;
    color: #555;
}

.highcharts-data-table th {
    font-weight: 600;
    padding: 0.5em;
}

.highcharts-data-table td,
.highcharts-data-table th,
.highcharts-data-table caption {
    padding: 0.5em;
}

.highcharts-data-table thead tr,
.highcharts-data-table tr:nth-child(even) {
    background: #f8f8f8;
}

.highcharts-data-table tr:hover {
    background: #f1f7ff;
}

.highcharts-description {
    margin: 0.3rem 10px;
}




</style>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header"></section>



			<div class="wrapper" style="margin: 0 30px 0 30px;"
				id="CollectionManagerDash">
				<div class="main">



					<div class="container-fluid p-0">
						<center>
							<h1 class="h3 mt-2">Velox 3.0</h1>
							<br>
						</center>

						<div class="row" style="display: none;">
							<div class="col-md-3 col-sm-6 col-xs-12">
								<div class="info-box">
									<span class="info-box-icon bg-info"><i
										class="ion ion-ios-gear-outline"></i></span>

									<div class="info-box-content">
										<span class="info-box-text">CPU Traffic</span> <span
											class="info-box-number">90<small>%</small></span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->
							</div>
							<!-- /.col -->
							<div class="col-md-3 col-sm-6 col-xs-12">
								<div class="info-box">
									<span class="info-box-icon bg-red"><i
										class="fa fa-google-plus"></i></span>

									<div class="info-box-content">
										<span class="info-box-text">Likes</span> <span
											class="info-box-number">41,410</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->
							</div>
							<!-- /.col -->

							<!-- fix for small devices only -->
							<div class="clearfix visible-sm-block"></div>

							<div class="col-md-3 col-sm-6 col-xs-12">
								<div class="info-box">
									<span class="info-box-icon bg-green"><i
										class="ion ion-ios-cart-outline"></i></span>

									<div class="info-box-content">
										<span class="info-box-text">Sales</span> <span
											class="info-box-number">760</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->
							</div>
							<!-- /.col -->
							<div class="col-md-3 col-sm-6 col-xs-12">
								<div class="info-box">
									<span class="info-box-icon bg-yellow"><i
										class="ion ion-ios-people-outline"></i></span>

									<div class="info-box-content">
										<span class="info-box-text">New Members</span> <span
											class="info-box-number">2,000</span>
									</div>
									<!-- /.info-box-content -->
								</div>
								<!-- /.info-box -->
							</div>
							<!-- /.col -->
						</div>


						<!-- //05/12 -->
						<div class="row">


							<div class="col-md-1"></div>




							<div class="col-md-10">
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0"
											style="font-weight: bold; font-size: 20px;">Products by Phase(FH)</h5>
									</div>
									<div class="row">

										<!-- 									<div class="col-md-5" style="margin: 10px 0 10px 40px; display :none;" id="solSelectDiv" > -->
										<!-- 													<label for="">Solution Name:</label>  -->

										<!-- 												<select id="solutionName"  class="form-control" -->
										<!-- 													 data-toogle="tooltip" -->
										<!-- 													name="solutionName" onchange="getChartDetailsBySolution()" multiple="multiple" > -->
										<!-- 												</select> -->

										<!-- 										</div> -->

										<span
											style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
											id="spin2"><i class="fa fa-spinner fa-spin"
											style="font-size: 33px"></i></span>
										<!-- 										<div id="piechartDiv" style="width:90%; margin-left: 5%; height: 500px;"></div> -->

<!-- 										<figure class="highcharts-figure"> -->
											<div id="containerDiv" style="width: 80%; margin-left: 10%;"></div>
<!-- 										</figure> -->

									</div>
								</div>
							</div>
							<div class="col-md-1"></div>

						</div>



						<div class="row">
						
						
						<div id="" class="col-md-4">
							<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0"
											style="font-weight: bold; font-size: 18px;">Products by Phase(FH)</h5>
									</div>
									<div class="row">

										<span
											style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
											id="spin2"><i class="fa fa-spinner fa-spin"
											style="font-size: 33px"></i></span>

										<div id="containerDiv1" style="width: 80%; margin-left: 10%;"></div>

									</div>
								</div>
						</div>
						
						
						<div id="" class="col-md-4">
							<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0"
											style="font-weight: bold; font-size: 18px;">Products by Phase(AM/DM)</h5>
									</div>
									<div class="row">

										<span
											style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
											id="spin2"><i class="fa fa-spinner fa-spin"
											style="font-size: 33px"></i></span>

										<div id="containerDiv2" style="width: 80%; margin-left: 10%;"></div>

									</div>
								</div>
						</div>
						
						
						<div id="" class="col-md-4">
							<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0"
											style="font-weight: bold; font-size: 18px;">Products by Phase(Team Leader)</h5>
									</div>
									<div class="row">

										<span
											style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
											id="spin2"><i class="fa fa-spinner fa-spin"
											style="font-size: 33px"></i></span>

										<div id="containerDiv3" style="width: 80%; margin-left: 10%;"></div>

									</div>
								</div>
						</div>
						
						
						
						<div id="" class="col-md-6">
							<div class="card flex-fill d-flex">
								<div class="card-header">
									<h5 class="card-title mb-0"
										style="font-weight: bold; font-size: 20px;">Task Summary of FH</h5>
								</div>
								<div class="row">
									<div class="table-responsive" style="margin: 15px;">
										<div class="" style=" width: 100%;">

											<div id="">
												<table class="table table1 table-striped"
													id="funTask" style="width: 100%;">

													<thead>
														<tr>
															<th>Functional Head</th>
															<th>Total <br> Task</th>
															<th>Completed <br> Task</th>
															<th>Pending <br> Task</th>
														</tr>
													</thead>
												</table>
												<span
													style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
													id="spin1"><i class="fa fa-spinner fa-spin"
													style="font-size: 33px"></i></span>
											</div>

										</div>

									</div>
								</div>
							</div>
						</div>
						
						
							<div id="" class="col-md-6">
							<div class="card flex-fill d-flex">
								<div class="card-header">
									<h5 class="card-title mb-0"
										style="font-weight: bold; font-size: 20px;">Task Summary by Product</h5>
								</div>
								<div class="row">
									<div class="table-responsive" style="margin: 15px;">
										<div class="" style=" width: 100%;">

											<div id="">
												<table class="table table1 table-striped"
													id="solnTask" style="width: 100%;">

													<thead>
														<tr>
															<th>Solution Name</th>
															<th>Total <br> Task</th>
															<th>Completed <br> Task</th>
															<th>Pending <br> Task</th>
														</tr>
													</thead>
												</table>
												<span
													style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
													id="spin1"><i class="fa fa-spinner fa-spin"
													style="font-size: 33px"></i></span>
											</div>

										</div>

									</div>
								</div>
							</div>
						</div>
						
						


						<div id="CMTotalProjectStatusN" class="col-md-10" style="display : none;">


							<div class="card flex-fill d-flex">
								<div class="card-header">
									<h5 class="card-title mb-0"
										style="font-weight: bold; font-size: 20px;">Solution Wise Team</h5>
								</div>
								<div class="row">
									<div class="table-responsive" style="margin: 15px;">
										<div class="" style="margin: 15px; width: 100%;">

											<div id="AllDetailsOfProjectsN">
												<table class="table table1 table-striped"
													id="ProjectDetailsCMN" style="width: 100%;">

													<thead>
														<tr>
															<!-- 																<th>Sr No</th> -->
															<th>Solution Name</th>
															<th>F Head</th>
															<th>AM / DM</th>
															<th>Team Leader</th>
														</tr>
													</thead>
												</table>
												<span
													style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
													id="spin1"><i class="fa fa-spinner fa-spin"
													style="font-size: 33px"></i></span>
											</div>

										</div>

									</div>
								</div>
							</div>
						</div>
						
						
						
					
						
						</div>
						
						
						
						
						
						
						


							<div class="modal fade" id="TaskModalss" tabindex="-1"
								role="dialog" aria-labelledby="MDMODALLabel" aria-hidden="true"
								style="overflow: auto;">
								<div class="modal-dialog modal-lg" role="document"
									style="margin-left: 25%;">
									<div class="modal-content" style="width: 110%;">
										<div class="modal-header">
											<h5 class="modal-title" id="TotalActivitiesDelayedModalLabel">Task
												Details</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body" id="taskAssignModal">

											<h6>
												Functional Head : <span id="nameSpan"></span>
											</h6>

											<table class="table" id="TaskDetailsByName">
												<thead>
													<tr>
														<th>Sr No</th>
														<th>Product tool</th>
														<th>RFP Points</th>
														<th>Manager Name</th>
														<th>Status</th>
														<th>Target_Date</th>
														<th>Pending_With</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>


							<div class="modal fade" id="TaskModalSolution" tabindex="-1"
								role="dialog" aria-labelledby="MDMODALLabel2" aria-hidden="true"
								style="overflow: auto;">
								<div class="modal-dialog modal-lg" role="document"
									style="margin-left: 25%;">
									<div class="modal-content" style="width: 110%;">
										<div class="modal-header">
											<h5 class="modal-title"
												id="TotalActivitiesDelayedModalLabel2">Task Details</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body" id="taskAssignModal">

											<h6>
												Solution Name : <span id="solutionNameSpan"></span>
											</h6>

											<table class="table" id="TaskDetailsBysoln">
												<thead>
													<tr>
														<th>Sr No</th>
														<th>Functional Head</th>
														<th>RFP Points</th>
														<th>Manager Name</th>
														<th>Status</th>
														<th>Target_Date</th>
														<th>Pending_With</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>



							<div class="modal fade" id="TaskModalDate" tabindex="-1"
								role="dialog" aria-labelledby="MDMODALLabel3" aria-hidden="true"
								style="overflow: auto;">
								<div class="modal-dialog modal-lg" role="document"
									style="margin-left: 20%;">
									<div class="modal-content" style="width: 125%;">
										<div class="modal-header">
											<h5 class="modal-title"
												id="TotalActivitiesDelayedModalLabel3">Task Details</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body" id="taskAssignModalDate">

											<h6>
												Date : <span id="dateSpan"></span>
											</h6>

											<table class="table" id="TaskDetailsByDate">
												<thead>
													<tr>
														<th>Sr No</th>
														<th>Customer_Name</th>
														<th>Solution_Name</th>
														<th>Customization/Bug/Issue</th>
														<th>Planned_Date</th>
														<th>Manager Name</th>
														<th>Status</th>
														<th>Pending_With</th>
														<th>Delay Days</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>





							<div class="modal fade" id="TaskModalCounts" tabindex="-1"
								role="dialog" aria-labelledby="MDMODALLabel3" aria-hidden="true"
								style="overflow: auto;">
								<div class="modal-dialog modal-lg" role="document"
									style="margin-left: 20%;">
									<div class="modal-content" style="width: 125%;">
										<div class="modal-header">
											<h5 class="modal-title" id="TotalCountModal">Task
												Details</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body" id="taskAssignModalCounts">

											<h6>
												<span id="headerSpan"></span>
											</h6>

											<table class="table" id="TaskDetailsByCounts">
												<thead>
													<tr>
														<th>Sr No</th>
														<th>Customer_Name</th>
														<th>Solution_Name</th>
														<th>Customization/Bug/Issue</th>
														<th>Planned_Date</th>
														<th>Manager Name</th>
														<th>Status</th>
														<th>Pending_With</th>
														<th>Delay Days</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>



							<!-- 						<div id="CMTotalProjectStatusN3" class="col-md-5"> -->


							<!-- 								<div class="card flex-fill"> -->
							<!-- 									<div class="card-header"> -->
							<!-- 										<h5 class="card-title mb-0">Status</h5> -->
							<!-- 									</div> -->
							<!-- 									<div class="row"> -->
							<!-- 										<div class="table-responsive" style="margin: 15px;"> -->


							<!-- 											<div id="AllDetailsOfProjectsN3"> -->
							<!-- 												<table class="table table1 table-striped" -->
							<!-- 													id="ProjectDetailsCMN3" style="width: 100%;"> -->

							<!-- 													<thead> -->
							<!-- 														<tr> -->
							<!-- 															<th>Yet to<br> assign&nbsp;<i -->
							<!-- 																class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
							<!-- 															</th> -->
							<!-- 															<th>Assigned&nbsp;<i -->
							<!-- 																class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
							<!-- 															</th> -->
							<!-- 															<th>Developed&nbsp;<i -->
							<!-- 																class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
							<!-- 															</th> -->
							<!-- 															<th>Tested&nbsp;<i -->
							<!-- 																class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
							<!-- 															</th> -->

							<!-- 														</tr> -->
							<!-- 													</thead> -->
							<!-- 												</table> -->

							<!-- 											</div> -->

							<!-- 										</div> -->

							<!-- 									</div> -->
							<!-- 								</div> -->


							<!-- 						</div> -->
						
						<!--  -->


						<div class="row" id="CMTotalProjectStatus" style="display: none;">

							<div class="col-12 col-lg-12 col-xxl-9 d-flex">
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0"
											style="font-weight: bold; font-size: 20px;">All Task</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">


											<div id="AllDetailsOfProjects">
												<table class="table table1 table-striped"
													id="ProjectDetailsCM" style="width: 100%;">

													<thead>
														<tr>
															<th>Sr<br> No
															</th>
															<th>Status</th>
															<th>Customer<br> Name
															</th>
															<th>Product Suite<br> -Tool
															</th>
															<th>Module<br> Name
															</th>
															<th>Expected<br> Date
															</th>
															<th>Challenges/<br>Issue/Bug
															</th>
															<th>Expected&nbsp;<br>Output
															</th>
															<th>Assign By</th>
															<th>Reported Date<br></th>
															<th>Manager<br>Name
															</th>
															<th>Team Leader<br></th>
															<th>Developer<br></th>
															<th>Tester<br></th>
															<th>Test Fail Counts<br></th>
														</tr>
													</thead>
												</table>
												<span
													style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
													id="spin11"><i class="fa fa-spinner fa-spin"
													style="font-size: 33px"></i></span>
											</div>

										</div>

									</div>
								</div>
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

	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/jszip.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.html5.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.print.min.js"></script>


	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>


	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script>

	<script
		src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
		type="text/javascript"></script>
		
<%-- 	<script src="<%=request.getContextPath()%>/static/resources1/js/highcharts.js"></script> --%>
<%-- 	<script src="<%=request.getContextPath()%>/static/resources1/js/highcharts-3d.js"></script> --%>

				<script src="https://code.highcharts.com/highcharts.js"></script>	
			<script src="https://code.highcharts.com/highcharts-3d.js"></script>


	<script
		src="<%=request.getContextPath()%>/static/custom/newDashboard.js"></script>


	<script>
		
	</script>
</body>
</html>