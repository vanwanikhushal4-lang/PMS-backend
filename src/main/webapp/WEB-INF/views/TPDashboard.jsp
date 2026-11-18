<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<%@ page contentType="text/html; charset=UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>IT-Helpdesk Dashboard</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->
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
<!-- Daterange picker -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
<!-- Datatables -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
<style>
#containertp, #containertp2, #containertp1, #containertp5, #containertp7,
	#containertp10, #containertp4, #containertp6, #containertp11,
	#containertp12, #containertpforPriortyWisereportinSR,
	#containertpforPriortyWisereport, #bar-chart1, #bar-chart1SR,
	#containerSLA {
	width: 351px;
	height: 400px;
}
</style>


</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<jsp:include page="/WEB-INF/views/dashboardheaderTP.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header">
				<div class="row">

					<div class="col-md-4">
						<label>Last Date:</label> <select name="selectmonthOfTicket1"
							id="selectmonthOfGroupTicket1">
							<!-- 							<option value="" >-Please Select-</option> -->
							
							<option value="1" selected>Last 24 hour</option>
							<option value="7">Last Week</option>
							<option value="30">Last Month</option>
							<option value="90">Last three Month</option>
						</select>
						<figure class="highcharts-figure">
							<div id="containertp"></div>
							<p class="highcharts-description"></p>
						</figure>
					</div>

					<div class="col-md-4">
						<label>Last Date:</label> <select name="selectmonthOfTicket2"
							id="selectmonthOfGroupTicket2">
							<option value="1" selected>Last 24 hour</option>
							<option value="7">Last Week</option>
							<option value="30">Last Month</option>
							<option value="90">Last three Month</option>
						</select>
						<figure class="highcharts-figure">
							<div id="containertp2"></div>
							<p class="highcharts-description"></p>
						</figure>
					</div>

					<div class="col-md-4">
						<label>Last Date:</label> <select name="selectmonthOfTicket3"
							id="selectmonthOfGroupTicket3">
							<option value="1" selected>Last 24 hour</option>
							<option value="7">Last Week</option>
							<option value="30">Last Month</option>
							<option value="90">Last three Month</option>
						</select>
						<figure class="highcharts-figure">
							<div id="containertp1"></div>
							<p class="highcharts-description"></p>
						</figure>
					</div>

				</div>
				<!-- 				hyinmmgiumuiyo,yuhioyioiio -->

				<div id="load">
					<button type="button" class="btn btn-secondary btn-lg btn-block"
						id="btn">Group Wise Dashboard</button>
				</div>
				<br>
				<div id="div" style="display: none;">
					<hr>
					<div class="row">
						<div class="col-md-4">
							<label>Last Date:</label> <select name="selectmonthOfGroupTicket"
								id="selectmonthOfGroupTicket">
								<option value="5 MINUTE" selected>Last 5 Minutes</option>
								<option value="10 MINUTE" >Last 10 Minutes</option>
								<option value="30 MINUTE" >Last 30 Minutes</option>
								<option value="60 MINUTE" >Last 1 hour</option>
								<option value="4 HOUR">Last 4 hours</option>
								<option value="8 HOUR" >Last 8 hours</option>
								<option value="12 HOUR" >Last 12 hours</option>
								<option value="1 DAY" >Last 24 hours</option>
								<option value="7 DAY">Last Week</option>
								<option value="30 DAY">Last Month</option>
								<option value="90 DAY">Last three Month</option>
							</select>

							<figure class="highcharts-figure">
								<div id="containertp5"></div>
							</figure>
							<p class="highcharts-description"></p>
						</div>

						<div class="col-md-4">
							<label>Last Date:</label> <select
								name="selectmonthOfGroupServicveRequest"
								id="selectmonthOfGroupServicveRequest">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>

							<figure class="highcharts-figure">
								<div id="containertp7"></div>
							</figure>
							<p class="highcharts-description"></p>
						</div>
						<div class="col-md-4">
							<label>Last Date:</label> <select
								name="selectmonthOfGroupinPrbticket"
								id="selectmonthOfGroupinPrbticket">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<!-- 							<figure class="highcharts-figure"> -->
							<!-- 							<div id="containertp7"></div> -->
							<!-- 							</figure> -->
							<figure class="highcharts-figure">
								<div id="containertp10"></div>
							</figure>
							<p class="highcharts-description"></p>
						</div>


					</div>
					<hr>
				</div>

				<div id="Category1">
					<button type="button" class="btn btn-secondary btn-lg btn-block"
						id="btn1">Category Wise Dashboard</button>
				</div>
				<br>
				<div id="Category" style="display: none;">
					<div class="row">
						<div class="col-md-4">
							<label>Last Date:</label> <select
								name="selectmonthOfCategoryTicket"
								id="selectmonthOfCategoryTicket">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containertp4"></div>
							</figure>
							<p class="highcharts-description"></p>
						</div>

						<div class="col-md-4">
							<label>Last Date:</label> <select
								name="selectmonthOfCategroyServiceRequest"
								id="selectmonthOfCategroyServiceRequest">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containertp6"></div>
							</figure>
							<p class="highcharts-description"></p>
						</div>

						<div class="col-md-4">
							<label>Last Date:</label> <select
								name="selectmonthOfCategroyProblem"
								id="selectmonthOfCategroyProblem">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containertp11"></div>
							</figure>
							<p class="highcharts-description"></p>
						</div>
					</div>
				</div>

				<div id="Priority1">
					<button type="button" class="btn btn-secondary btn-lg btn-block"
						id="btn2">Priority Severity Wise Dashboard</button>
				</div>
				<br>
				<div id="Priority" style="display: none;">
					<div class="row">
						<div class="col-md-4">
							<label>Last Date:</label> <select name="chart-select"
								id="chart-select">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containertpforPriortyWisereport"></div>

								<p class="highcharts-description"></p>
							</figure>
						</div>

						<div class="col-md-4">
							<label>Last Date:</label> <select name="service_request"
								id="service_request">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containertpforPriortyWisereportinSR"></div>

								<p class="highcharts-description"></p>
							</figure>
						</div>

						<div class="col-md-4">
							<label>Last Date:</label> <select name="datechangeprb"
								id="datechangeprb">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containertp12"></div>
								<p class="highcharts-description"></p>
							</figure>
						</div>
					</div>
				</div>
			</section>
		</div>


		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimary" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="problem"></span> Problem Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button> 

					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12"> 
								<table class="table table1 table-striped" id="Listing_Copy">
									<thead>
										<tr>
											<th>Ticket ID</th>
											<th>Status</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Subject</th>
											<th>Request Mode</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Category</th>
											<th>Sub-Category 1</th>
											<th>Sub-Category 2</th>
											<th>Raised By</th>
											<th>Raised Date</th>
											<th>Assigned By</th>
											<th>Assign To Engineer/Group</th>
											<th>Assigned Engineer Name</th>
											<th>Assign Date & Time</th>
											<th>Hold/WIP/Resolved By</th>
											<th>Hold/WIP/Resolved Date & Time</th>
											<th>Fix in Process Date & Time</th>
											<th>RCA Date & Time</th> 
											<th>Closed By</th> 
											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>
									<tbody> 
									</tbody> 
								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimary1" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="incident"></span> Incident Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped" id="Listing_Copy1">
									<thead>
										<tr>

											<th>Ticket ID</th>
											<th>Status</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Category</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>
											<th>Subject</th>
											<th>Request Mode</th>
											<th>Raised By</th>
											<th>Raised Date&nbsp;Time</th>
											<th>Assigned By</th>
											<th>Assign To Engineer/Group</th>
											<th>Assigned Engineer Name</th>
											<th>Assign Date & Time</th>
											<th>Hold/WIP/Resolved/<br>Rejected By
											</th>
											<th>Hold/WIP/Resolved/<br>Rejected Date & Time
											</th>
											<th>Closed By</th>

											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>




		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryForServiceRequest" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="service"></span> Service Request Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="Listing_ForServiceRequest" style="width: 100%">
									<thead>
										<tr>
											<th>Request ID</th>
											<th>Status</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Subject</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Category</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>

											<th>Assigned By</th>
											<th>Assigned To</th>
											<th>Processing Group</th>
											<th>Resolved Engineer</th>
											<th>Raised&nbsp;Date & Time</th>
											<th>Assigned&nbsp;Date & Time</th>
											<th>Resolved&nbsp;Date & Time</th>
											<th>Complete&nbsp;Date & Time</th>
											<th>Closed By</th>
											<th>Closed&nbsp;Date & Time</th>
											<th>Level-1 Action Date</th>
											<th>Level-1 Action By</th>
											<th>Level-2 Action Date</th>
											<th>Level-2 Action By</th>
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryForIncidentGroup" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="incidentgroup"></span> Incident Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="Listing_ForIncidentGroup">
									<thead>
										<tr>

											<th>Ticket ID</th>

											<th>GROUP</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Category</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>
											<th>Subject</th>
											<th>Request Mode</th>
											<th>Raised By</th>
											<th>Raised Date&nbsp;Time</th>
											<th>Assigned By</th>
											<th>Assign To Engineer/Group</th>
											<th>Assigned Engineer Name</th>
											<th>Assign Date & Time</th>
											<th>Resolved By</th>
											<th>Resolved Date & Time</th>
											<th>Closed By</th>

											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryForGroupServiceRequest" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="groupservice"></span> Service Request Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="Listing_ForGroupServiceRequest" style="width: 100%">
									<thead>
										<tr>
											<th>Request ID</th>
											<th>GROUP</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Subject</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Category</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>

											<th>Assigned By</th>
											<th>Assigned To</th>
											<th>Processing Group</th>
											<th>Resolved Engineer</th>
											<th>Raised&nbsp;Date & Time</th>
											<th>Assigned&nbsp;Date & Time</th>
											<th>Resolved&nbsp;Date & Time</th>
											<th>Complete&nbsp;Date & Time</th>
											<th>Closed By</th>
											<th>Closed&nbsp;Date & Time</th>
											<th>Level-1 Action Date</th>
											<th>Level-1 Action By</th>
											<th>Level-2 Action Date</th>
											<th>Level-2 Action By</th>
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryProblemGroup" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="problemgroup"></span> Problem Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="ProblemGroupListing_Copy">
									<thead>
										<tr>
											<th>Ticket ID</th>
											<th>Status</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Subject</th>
											<th>Request Mode</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Category</th>
											<th>Sub-Category 1</th>
											<th>Sub-Category 2</th>
											<th>Raised By</th>
											<th>Raised Date</th>
											<th>Assigned By</th>
											<th>Assign To Engineer/Group</th>
											<th>Assigned Engineer Name</th>
											<th>Assign Date & Time</th>
											<th>Resolved By</th>
											<th>Resolved Date & Time</th>
											<th>Closed By</th>
											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryCategoryIncident" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="categoryincident"></span> Incident Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped" id="Listing_Category">
									<thead>
										<tr>

											<th>Ticket ID</th>
											<th>Category</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>
											<th>Subject</th>
											<th>Request Mode</th>
											<th>Raised By</th>
											<th>Raised Date&nbsp;Time</th>

											<th>Assigned By</th>
											<th>Assign To Engineer/Group</th>
											<th>Assigned Engineer Name</th>
											<th>Assign Date & Time</th>
											<th>Resolved By</th>
											<th>Resolved Date & Time</th>
											<th>Closed By</th>

											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryForServiceRequestCategory" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="servicecategory"></span> Service Request Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="Listing_ForServiceRequestCategory" style="width: 100%">
									<thead>
										<tr>

											<th>Request ID</th>

											<th>Category</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Subject</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>

											<th>Assigned By</th>
											<th>Assigned To</th>

											<th>Processing Group</th>
											<th>Resolved Engineer</th>

											<th>Raised&nbsp;Date & Time</th>
											<th>Assigned&nbsp;Date & Time</th>
											<th>Resolved&nbsp;Date & Time</th>
											<th>Complete&nbsp;Date & Time</th>
											<th>Closed By</th>
											<th>Closed&nbsp;Date & Time</th>
											<th>Level-1 Action Date</th>
											<th>Level-1 Action By</th>
											<th>Level-2 Action Date</th>
											<th>Level-2 Action By</th>

										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryProblemCategory" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="problemcategory"></span> Problem Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="ProblemCategoryListing_Copy">
									<thead>
										<tr>
											<th>Ticket ID</th>
											<th>Category</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>

											<th>Subject</th>
											<th>Request Mode</th>

											<th>Priority</th>
											<th>Severity</th>

											<th>Sub-Category 1</th>
											<th>Sub-Category 2</th>
											<th>Raised By</th>
											<th>Raised Date</th>

											<th>Assigned By</th>
											<th>Assign To Engineer/Group</th>

											<th>Assigned Engineer Name</th>
											<th>Assign Date & Time</th>

											<th>Resolved By</th>
											<th>Resolved Date & Time</th>



											<th>Closed By</th>
											<th>Closed Date&nbsp;Time</th>

										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryIncidentPrioritySeverity" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="incidentpriority"> </span> <span
								id="incidentseverity"> </span> Incident Tickets
						</h4>

						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>

					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="IncidentPrioritySeverityListing_Copy">
									<thead>
										<tr>

											<th>Ticket ID</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Date</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Category</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>
											<th>Subject</th>
											<th>Request Mode</th>
											<th>Raised By</th>
											<th>Raised Date&nbsp;Time</th>
											<th>Assigned By</th>
											<th>Assign To Engineer/Group</th>
											<th>Assigned Engineer Name</th>
											<th>Assign Date & Time</th>
											<th>Resolved By</th>
											<th>Resolved Date & Time</th>
											<th>Closed By</th>

											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryProblemPrioritySeverity" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="problempriority"></span> <span
								id="problemseverity"></span> Problem Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="ProblemPrioritySeverityListing_Copy">
									<thead>

										<tr>
											<th>Ticket ID</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>

											<th>Subject</th>
											<th>Request Mode</th>
											<th>Category</th>

											<th>Sub-Category 1</th>
											<th>Sub-Category 2</th>
											<th>Raised By</th>
											<th>Raised Date</th>

											<th>Assigned By</th>
											<th>Assign To Engineer/Group</th>

											<th>Assigned Engineer Name</th>
											<th>Assign Date & Time</th>

											<th>Resolved By</th>
											<th>Resolved Date & Time</th>



											<th>Closed By</th>
											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryForServiceRequestPrioritySeverity" tabindex="-1"
			role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="serviceP"></span> <span id="serviceS"></span>
							Service Request Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="Listing_ForServiceRequestPrioritySeverity"
									style="width: 100%">
									<thead>
										<tr>
											<th>Request ID</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Status</th>
											<th>Subject</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Category</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>
											<th>Assigned By</th>
											<th>Assigned To</th>
											<th>Processing Group</th>
											<th>Resolved Engineer</th>
											<th>Raised&nbsp;Date & Time</th>
											<th>Assigned&nbsp;Date & Time</th>
											<th>Resolved&nbsp;Date & Time</th>

											<th>Closed By</th>
											<th>Closed&nbsp;Date & Time</th>
											<th>Level-1 Action Date</th>
											<th>Level-1 Action By</th>
											<th>Level-2 Action Date</th>
											<th>Level-2 Action By</th>
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>

		<div class="content-wrapper">
			<section class="content-header">
				<div class="text-center text-primary">
					<!-- 			<h4>-- SLA Dashboard --</h4> -->
					<!-- 			<p id="dashboardSLA" style="cursor:pointer;">Click Here To Show SLA Report</p> -->
					<button type="button" class="btn btn-secondary btn-lg btn-block"
						id="dashboardSLA">SLA Dashboard</button>
				</div>
				<hr>


				<!-- 			    <div class="row" id="preLoader1"> -->
				<!-- 			    	<div class="col-md-12 text-center font-weight-bold h6">Loading <i class="fas fa-sync fa-spin"></i></div> -->
				<!-- 			    </div> -->
				<div class="row" id="SLAREPO" style="display: none;">
					<div class="col-md-4">
						<p class="d-none" id="loader1">
							<!-- class="col-sm-4" -->
							<label>Last Date:</label> <select name="onchangeofslaticket"
								id="onchangeofslaticket">
								<option value="lastweek" selected>Last Week</option>
								<option value="lastmonth">Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
						</p>
						<p id="option-selected"></p>

						<figure class="highcharts-figure">
							<div id="bar-chart1"></div>
							<p class="highcharts-description"></p>
						</figure>

					</div>

					<!-- <div class="row" id="preLoader2"><div class="col-md-12 text-center font-weight-bold h6">Loading <i class="fas fa-sync fa-spin"></i></div></div> -->

					<div class="col-md-4">
						<p class="d-none" id="loader2">
							<label>Last Date:</label> <select name="onchangeofslaSr"
								id="onchangeofslaSR">
								<option value="lastweek" selected>Last Week</option>
								<option value="lastmonth">Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
						</p>
						<p id="option-selected"></p>

						<figure class="highcharts-figure">
							<div id="bar-chart1SR"></div>
						</figure>
						<p class="highcharts-description"></p>

					</div>

					<!-- 	<div class="row" id="preLoader3"><div class="col-md-12 text-center font-weight-bold h6">Loading <i class="fas fa-sync fa-spin"></i></div></div> -->

					<div class="col-md-4">
						<p class="d-none" id="loader3">
							<label>Last Date:</label> <select name="onchangeslaproblem1"
								id="onchangeslaproblem1">
								<option value="lastweek" selected>Last Week</option>
								<option value="lastmonth">Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
						</p>
						<figure class="highcharts-figure">
							<div id="containerSLA"></div>
							<p class="highcharts-description"></p>
						</figure>
					</div>

				</div>
			</section>
		</div>

		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modalslaincident1" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalgLabselsla">View
							Incident Tickets</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="incidentlistingsla" style="width: 100%">
									<thead>
										<tr>
											<th>Ticket ID</th>
											<th>Status</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Category</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>

											<th>Raised By</th>
											<th>Raised By Full Name</th>
											<th>Raised&nbsp;Date & Time</th>


										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modalservicerequestlisting" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabgelsla">View
							Service Request</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped" id="SRtlistingsla"
									style="width: 100%">
									<thead>
										<tr>
											<th>Service ID</th>
											<th>Status</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Category</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>

											<th>Raised By</th>
											<th>Raised By Full Name</th>
											<th>Raised&nbsp;Date & Time</th>


										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryForProblemTickets" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">
							View <span id="prbl"></span> Problem Tickets
						</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="Listing_ForProblemTickets" style="width: 100%">
									<thead>
										<tr>
											<th>Ticket ID</th>
											<th>Status</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Category</th>
											<th>Sub-Category1</th>
											<th>Sub-Category2</th>

											<th>Raised By</th>
											<th>Raised By Full Name</th>
											<th>Raised&nbsp;Date & Time</th>


										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		<!-- ./wrapper -->
	</div>

	<!-- jQuery -->

	<script
		src="<%=request.getContextPath()%>/static/resources1/js/highcharts.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/js/highcharts-3d.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/js/exporting.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/js/offline-exporting.js"></script>

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
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.js"></script>
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

	<script src="<%=request.getContextPath()%>/static/custom/tp.js"></script>

</body>

</html>


