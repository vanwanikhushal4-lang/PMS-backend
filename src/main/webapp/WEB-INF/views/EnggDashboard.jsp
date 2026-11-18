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
<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
<!--   Datatables -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-select/css/select.bootstrap4.min.css">
<style>
#containertp,#containertp2,#containertp1,#containertp4,#containertp6,#containerenggforGroup,#containertp5,#containertp7,#containerenggforcategory,#containertp8,#containertp9,#containerenggforPriorityAndSeverity {
  width: 351px;
  height: 400px;
}

</style>
</head>

<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper" style="overflow-x: hidden">

		<jsp:include page="/WEB-INF/views/dashboardheaderEngg.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>

		<div class="content-wrapper">
			<section class="content-header">
				<div class="row">

					<div class="col-md-4">
						<figure class="highcharts-figure">
							<div id="containertp"></div>

						</figure>
					</div>

					<div class="col-md-4">
						<figure class="highcharts-figure">
							<div id="containertp2"></div>

						</figure>
					</div>

					<div class="col-md-4">

						<figure class="highcharts-figure">
							<div id="containertp1"></div>

						</figure>
					</div>


				</div>
				<hr>

				<div id="load">
					<button type="button" class="btn btn-secondary btn-lg btn-block"
						id="btn">Group Wise Dashboard</button>
				</div>
				<br>
				<div id="div" style="display: none;">
					<div class="row">

						<div class="col-md-4">

							<label>Last Date:</label> <select name="selectmonthOfGroupTicket"
								id="selectmonthOfGroupTicket">
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
								name="selectmonthOfGroupServicveRequest"
								id="selectmonthOfGroupServicveRequest">
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
								name="selectmonthOfGroupinPrbticket"
								id="selectmonthOfGroupinPrbticket">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containerenggforGroup"></div>

							</figure>
						</div>

					</div>
				</div>

				<hr>
				<div id="load">
					<button type="button" class="btn btn-secondary btn-lg btn-block"
						id="btn1">Category Wise Dashboard</button>
				</div >
				<br>
				<div id="div1" style="display: none;" >
					<div class="row">

						<div class="col-md-4">
							<label>Last Date:</label> <select
								name="selectmonthOfCategoryinticket"
								id="selectmonthOfCategoryinticket">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containertp5"></div>

							</figure>
						</div>

						<div class="col-md-4">
							<label>Last Date:</label> <select
								name="selectmonthOfCategoryinService"
								id="selectmonthOfCategoryinService">

								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containertp7"></div>
							</figure>
							<p class="highcharts-description"></p>
						</div>
						<div class="col-md-4">
							<label>Last Date:</label> <select
								name="selectmonthOfCategoryinPrbticket"
								id="selectmonthOfCategoryinPrbticket">

								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containerenggforcategory"></div>

							</figure>
						</div>
					</div>
				</div>
				<hr>
				<div id="load">
					<button type="button" class="btn btn-secondary btn-lg btn-block"
						id="btn2">Priority Severity Wise Dashboard</button>
				</div>
				<br>
				<div id="div2" style="display: none;">
					<div class="row">
						<div class="col-md-4">
							<label>Last Date:</label> <select name="selectmonthspticket"
								id="selectmonthspticket">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containertp8"></div>

								<p class="highcharts-description"></p>
							</figure>
						</div>

						<div class="col-md-4">
							<label>Last Date:</label> <select name="selectmonthspSr"
								id="selectmonthspSr">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containertp9"></div>

								<p class="highcharts-description"></p>
							</figure>
						</div>
						<div class="col-md-4">
							<label>Last Date:</label> <select
								name="selectmonthOfPrioritySeverityinPrbTicket"
								id="selectmonthOfPrioritySeverityinPrbTicket">
								<option value="lastweek">Last Week</option>
								<option value="lastmonth" selected>Last Month</option>
								<option value="lastthreemonth">Last three Month</option>
							</select>
							<p id="option-selected"></p>
							<figure class="highcharts-figure">
								<div id="containerenggforPriorityAndSeverity"></div>

							</figure>
						</div>
					</div>
				</div>



			</section>
		</div>

		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimary2" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="service"></span> Service Request</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="Listing_CopyForServiceRequest">
									<thead>
										<tr>
								
										<th>Request ID</th>
										<th>Status</th>
										<th>Request Type</th>
										<th>Priority</th>
										<th>Severity</th>
										<th>Subject</th>
										<th>Company</th>
										<th>Branch</th>
										<th>Department</th>
										<th>Category</th>
										<th>Sub-Category1</th>
										<th>Sub-Category2</th>
										<th>Processing Group</th>
										<th>Rasied By</th>
										<th>Assigned/Completed By</th>
										<th>Resolved By</th>
<!-- 										<th>Resolved Note</th> -->
										<th>Raised&nbsp;Date & Time</th>
										<th>Assigned&nbsp;Date & Time</th>
										<th>Resolved&nbsp;Date & Time</th>
										  <th>Complete&nbsp;Date & Time</th>
                                          <th>Closed&nbsp;Date & Time</th>
											<th>Closed By</th>
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
			id="modelviewPrimary" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="incident"></span> Incident Ticket</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="Listing_Copy">
									<thead>
										<tr>
										
								            <th>Ticket ID</th>
											<th>Status</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Subject</th>
											<th>Category</th>
											<th>Sub-Category 1</th>
											<th>Sub-Category 2</th>
											<th>Request Mode</th>
											<th>Raised By</th>
											<th>Raised Date & Time</th>
											<th>Assigned By</th>
											<th>Assign To Engineer/Group</th>
											<th>Assigned Engineer Name</th>
											<th>Assign Date & Time</th>
											<th>Hold/WIP/Resolved By</th>
											<th>Hold/WIP/Resolved Date & Time</th>
											<th>Closed By</th>

											<th>Closed Date & Time</th>
                                                                                
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
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="problem"></span> Problem Ticket</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="Listing_Copy1">
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
											<th>Assign To Engineer</th>
											<th>Group</th>
											<th>Assigned Engineer Name</th>
											<th>Engineer Company</th>
											<th>Assign Date & Time</th>
											<th>Hold/WIP/Resolved By</th>
											<th>Hold/WIP/Resolved Date & Time</th>
											<th>Fix in Process Date & Time</th>
											<th>RCA Date & Time</th>
											
											<th>Closed By</th>

											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>

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
			id="modelviewPrimaryIncidentGroup" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="incidentgroup"></span> Incident Ticket</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="IncidentGroupListing">
									<thead>
										<tr>
										
								            <th>Ticket ID</th>
											<th>Group</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Subject</th>
											<th>Category</th>
											<th>Sub-Category 1</th>
											<th>Sub-Category 2</th>
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
			id="modelviewPrimaryServiceGroup" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content"> 
					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="servicegroup"></span> Service Request</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button> 
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">  
								<table class="table table1 table-striped"
									id="ServiceGroupListing">
									<thead>
										<tr>
								
										<th>Request ID</th>
										
										<th>Group</th>
										<th>Request Type</th>
										<th>Priority</th>
										<th>Severity</th>
										<th>Subject</th>
										<th>Company</th>
										<th>Branch</th>
										<th>Department</th>
										<th>Category</th>
										<th>Sub-Category1</th>
										<th>Sub-Category2</th>
										<th>Processing Group</th>
										<th>Rasied By</th>
										<th>Assigned/Completed By</th>
										<th>Resolved By</th>
<!-- 										<th>Resolved Note</th> -->
										<th>Raised&nbsp;Date & Time</th>
										<th>Assigned&nbsp;Date & Time</th>
										<th>Resolved&nbsp;Date & Time</th>
										  <th>Complete&nbsp;Date & Time</th>
                                          <th>Closed&nbsp;Date & Time</th>
											<th>Closed By</th>
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
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="problemgroup"></span> Problem Ticket</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="ProblemGroupListing">
									<thead>
										<tr>
											<th>Ticket ID</th>
											<th>Group</th>
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
											<th>Assign To Engineer</th>
											
											<th>Assigned Engineer Name</th>
											<th>Engineer Company</th>
											<th>Status</th>
											<th>Assign Date & Time</th>
											<th>Resolved By</th>
											<th>Fix in Process Date & Time</th>
											<th>RCA Date & Time</th>
											<th>Resolved Date & Time</th>
											<th>Closed By</th>

											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>

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
			id="modelviewPrimaryIncidentCategory" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="incidentcategory"></span> Incident Ticket</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="IncidentCategotyListing">
									<thead>
										<tr>
										
								            <th>Ticket ID</th>
											<th>Category</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Subject</th>
											<th>Status</th>
											<th>Sub-Category 1</th>
											<th>Sub-Category 2</th>
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
			id="modelviewPrimaryServiceRequestCategory" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="servicerequestcategory"></span> Service Request</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="ServiceRequestCategotyListing">
									<thead>
										<tr>
								
										<th>Request ID</th>
										<th>Category</th>
										
										<th>Request Type</th>
										<th>Priority</th>
										<th>Severity</th>
										<th>Subject</th>
										<th>Company</th>
										<th>Branch</th>
										<th>Department</th>
										<th>Status</th>
										<th>Sub-Category1</th>
										<th>Sub-Category2</th>
										<th>Processing Group</th>
										<th>Rasied By</th>
										<th>Assigned/Completed By</th>
										<th>Resolved By</th>
<!-- 										<th>Resolved Note</th> -->
										<th>Raised&nbsp;Date & Time</th>
										<th>Assigned&nbsp;Date & Time</th>
										<th>Resolved&nbsp;Date & Time</th>
										  <th>Complete&nbsp;Date & Time</th>
                                          <th>Closed&nbsp;Date & Time</th>
											<th>Closed By</th>
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
			id="modelviewPrimaryPrioritySeverityIncidentCategory" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="priorityincident"></span> <span id="severityincident"></span> Incident Ticket</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="PrioritySeverityIncidentListing">
									<thead>
										<tr>
										
								            <th>Ticket ID</th>
								            <th>Priority</th>
											<th>Severity</th>
											<th>Category</th>
											<th>Company</th>
											<th>Branch</th>
											<th>Department</th>
										
											<th>Subject</th>
											<th>Status</th>
											<th>Sub-Category 1</th>
											<th>Sub-Category 2</th>
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
			id="modelviewPrimaryPrioritySeverityServiceRequest" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="priorityservice"></span> <span id="severityservice"></span>Service Request</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="PrioritySeverityServiceListing">
									<thead>
										<tr>
								
										<th>Request ID</th>
										<th>Priority</th>
										<th>Severity</th>
										<th>Category</th>
										<th>Request Type</th>
										
										<th>Subject</th>
										<th>Company</th>
										<th>Branch</th>
										<th>Department</th>
										<th>Status</th>
										<th>Sub-Category1</th>
										<th>Sub-Category2</th>
										<th>Processing Group</th>
										<th>Rasied By</th>
										<th>Assigned/Completed By</th>
										<th>Resolved By</th>
<!-- 										<th>Resolved Note</th> -->
										<th>Raised&nbsp;Date & Time</th>
										<th>Assigned&nbsp;Date & Time</th>
										<th>Resolved&nbsp;Date & Time</th>
										  <th>Complete&nbsp;Date & Time</th>
                                          <th>Closed&nbsp;Date & Time</th>
											<th>Closed By</th>
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
			id="modelviewPrimaryPrioritySeverityProblem" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="priorityproblem"></span> <span id="severityproblem"></span> Problem Ticket</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="PrioritySeverityProblemListing">
									<thead>
										<tr>
											<th>Ticket ID</th>
											<th>Priority</th>
											<th>Severity</th>
											<th>Group</th>
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
											<th>Assign To Engineer</th>
											
											<th>Assigned Engineer Name</th>
											<th>Engineer Company</th>
											<th>Status</th>
											<th>Assign Date & Time</th>
											<th>Resolved By</th>
											<th>Fix in Process Date & Time</th>
											<th>RCA Date & Time</th>
											<th>Resolved Date & Time</th>
											<th>Closed By</th>

											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>

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
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="problemcategory"></span> Problem Ticket</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped"
									id="ProblemCategoryListing">
									<thead>
										<tr>
											<th>Ticket ID</th>
											<th>Category</th>
											<th>Group</th>
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
											<th>Assign To Engineer</th>
											
											<th>Assigned Engineer Name</th>
											<th>Engineer Company</th>
											<th>Status</th>
											<th>Assign Date & Time</th>
											<th>Resolved By</th>
											<th>Fix in Process Date & Time</th>
											<th>RCA Date & Time</th>
											<th>Resolved Date & Time</th>
											<th>Closed By</th>

											<th>Closed Date&nbsp;Time</th>
										</tr>
									</thead>

									</tbody>

								</table>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
	</div>
	
		
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		<!-- ./wrapper -->

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
     
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
     
     
        <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/resources1/Listing/jszip.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/resources1/Listing/vfs_fonts.js"></script>
        <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/js/buttons.print.min.js"></script>
        <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>  

	<script
		src="<%=request.getContextPath()%>/static/custom/EnggUserDashboard.js"></script>
</body>

</html>


