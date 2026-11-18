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

.datetimepicker {
	z-index: 1071 !important;
}

span.vlx {
	display: block;
	word-wrap: break-word;
}

body {
	font-size: 85% !important;
}
</style>


<style>
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
#data-table1 td {
	padding: 2px;
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

/* Cards */
.info-box-text {
	font-size: 16px;
	/* 	font-weight : bold; */
}

.info-box-number {
	font-size: 20px;
	font-weight: bold;
}

#todayCard {
	box-shadow: 0 4px 4px rgba(0, 0, 0, 0.1), 0 10px 16px rgba(0, 0, 0, 0.1)
}

#tillTodayCard {
	box-shadow: 0 4px 4px rgba(0, 0, 0, 0.1), 0 10px 16px rgba(0, 0, 0, 0.1)
}

#info-box1 {
	box-shadow: 0 0 2px rgba(0, 0, 0, .125), 0 1px 5px rgba(0, 0, 0, 0.4);
}

#info-box2 {
	box-shadow: 0 0 2px rgba(0, 0, 0, .125), 0 1px 5px rgba(0, 0, 0, 0.4);
}

#info-box3 {
	box-shadow: 0 0 2px rgba(0, 0, 0, .125), 0 1px 5px rgba(0, 0, 0, 0.4);
}

#info-box4 {
	box-shadow: 0 0 2px rgba(0, 0, 0, .125), 0 1px 5px rgba(0, 0, 0, 0.4);
}

#TotalTask {
	table-layout: fixed; /* Ensures columns have fixed width */
	width: 100%; /* Ensures the table takes full width */
}

#TotalTask th, #TotalTask td {
	word-wrap: break-word; /* Allow word wrapping */
	overflow: hidden; /* Prevent text overflow */
}
</style>



<script>
        <%
            String crno = request.getParameter("crno");
            System.out.println("crrrr" + crno);
            
            String role = request.getParameter("role");
            System.out.println("role" + role);

            String roletype = (String) session.getAttribute("role");
            System.out.println("roleee" + roletype);
            
            String designation = (String) session.getAttribute("designation");
          
            String tid = request.getParameter("tid");
            System.out.println("tid" + tid);

            String projectId = request.getParameter("projectId");
            System.out.println("projectId" + projectId);

          

        %>
    </script>




</head>
<body class="hold-transition sidebar-mini layout-fixed">

<%-- 	<input type="hidden" id="crnoo" name="crnoo" value="<%=crno%>"> --%>

<%-- 	<input type="hidden" id="tid" name="tid" value="<%=tid%>"> --%>

<%-- 	<input type="hidden" id="role" name="tid" value="<%=role%>"> --%>

	<input type="hidden" id="roletype" name="roletype"
		value="<%=roletype%>">

<!-- 	<input type="hidden" id="designation" name="designation" -->
<%-- 		value="<%=designation%>"> --%>

<!-- 	<input type="hidden" id="projectId" name="projectId" -->
<%-- 		value="<%=projectId%>"> --%>

<!-- 	<input type="hidden" id="formABstatus" name="formABstatus" value=""> -->


	<input type="hidden" id="prodSuite" name="prodSuite" />
	<input type="hidden" id="prodTool" name="prodTool" />
	<input type="hidden" id="customerNameh" name="customerNameh" />
	<input type="hidden" id="moduleNameh" name="moduleNameh" />
	<input type="hidden" id="exDate" name="exDate" />
	<input type="hidden" id="priority" name="priority" />
	<input type="hidden" id="descriptions" name="descriptions" />
	<input type="hidden" id="expectedOut" name="expectedOut" />




	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>

		<div class="content-wrapper">

			<div class="" style="margin: 0 20px 0 20px;">
				<br>
				<center>
					<h1 class="h3 ">RFP Dashboard</h1>
				</center>

				<div style="margin-bottom: 15px; margin-top: 0;" class="col-md-3">
					<label for="">Change Date :</label> <select id="selectedValue"
						class="form-control form-control-sm" name="selectedValue"
						data-toggle="tooltip" onchange="changeValue(this.value)">
						<option value="All" selected>All Task</option>
						<option value="Today" >Today's</option>
					</select>
				</div>

				<div class="row">
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="info-box" onclick="getTaskList('total')"
							id="info-box1">
							<span class="info-box-icon bg-info"><i
								class="nav-icon fa fa-list"></i></span>

							<div class="info-box-content" style="cursor: pointer;">
								<span class="info-box-text">Total Task</span> <span
									id="totalCount" class="info-box-number"></span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
					<!-- /.col -->
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="info-box" onclick="getTaskList('delayed')"
							id="info-box2">
							<span class="info-box-icon bg-red"><i
								class="nav-icon fas fa-hourglass-end"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">Delayed Task</span> <span
									id="delayedCount" class="info-box-number"></span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
					<!-- /.col -->

					<!-- fix for small devices only -->
					<div class="clearfix visible-sm-block"></div>

					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="info-box" onclick="getTaskList('closed')"
							id="info-box3">
							<span class="info-box-icon bg-green"><i
								class="fa-solid fa-list-check"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">Closed Task</span> <span
									id="closedCount" class="info-box-number"></span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
					<!-- /.col -->
					<div class="col-md-3 col-sm-6 col-xs-12">
						<div class="info-box" onclick="getTaskList('track')"
							id="info-box4">
							<span class="info-box-icon bg-yellow"><i
								class="nav-icon fas fa-hourglass-half"></i></span>

							<div class="info-box-content">
								<span class="info-box-text">On Track</span> <span
									id="onTrackCount" class="info-box-number"></span>
							</div>
							<!-- /.info-box-content -->
						</div>
						<!-- /.info-box -->
					</div>
					<!-- /.col -->
					<br>
				</div>



				




				<div class="row">


					<div class="col-md-5 ">
						<div class="card flex-fill d-flex" id="tillTodayCard" style="min-height: 360px;">
							<div class="card-header">
								<h5 class="card-title mb-0"
									style="font-weight: bold; font-size: 20px;">Delayed Task</h5>
							</div>
							<div class="col-md-12" style="width: 100%;">

								<table class="table table table-striped" id="TillTodayTask"
									style="width: 100%; " >

									<thead>
										<tr>
											<th>Developer Name</th>
											<th>Delayed Task</th>
											<!-- 															<th>Delayed Days</th> -->
									</thead>
								</table>
								<span
									style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
									id="spin22"><i class="fa fa-spinner fa-spin"
									style="font-size: 33px"></i></span>
							</div>
						</div>


	
						




					</div>


					<div id="CMTotalProjectStatusN" class="col-md-7 ">
						<div class="card flex-fill d-flex" id="todayCard" style="min-height: 360px;">
							<div class="card-header">
								<h5 class="card-title mb-0"
									style="font-weight: bold; font-size: 20px;">Task By
									Developer</h5>
							</div>
							<div class="col-md-12" style="width: 100%;">

								<table class="table table table-striped" id="TodaysTaskTable"
									style="width: 100%;">

									<thead>
										<tr>
											<th>Developer Name</th>
											<th>Pending Task</th>
											<th>Completed</th>
											<th>In Progress</th>
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
				
				
<!-- 				<div class="" style="height: 40px; width: 100%; background-color: #343a40; margin-bottom: 30px; padding: 5px; color:white;"> -->
<!-- 					<center><h3>Details By Products & Team</h3></center> -->
<!-- 				</div> -->

<div style="height: 50px; width: 100%; background-color: #343a40;; margin-bottom: 30px; margin-top: 20px; padding: 10px 20px; color: white; border-radius: 5px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);">
    <center>
        <h3 style=" font-size: 24px; font-weight: bold; text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.3);">
            Details By Products & Team
        </h3>
    </center>
</div>

				
				
				<div class="row">



					<div id="" class="col-md-4">
						<div class="card flex-fill">
							<div class="card-header">
								<h5 class="card-title mb-0"
									style="font-weight: bold; font-size: 18px;">Products by
									Phase(FH)</h5>
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
									style="font-weight: bold; font-size: 18px;">Products by
									Phase(AM/DM)</h5>
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
									style="font-weight: bold; font-size: 18px;">Products by
									Phase(Team Leader)</h5>
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
				</div>
				
				
				
				<div class="row"> 
				
				<div class="col-md-6" >
					<div class="card flex-fill d-flex">
							<div class="card-header">
								<h5 class="card-title mb-0"
									style="font-weight: bold; font-size: 20px;">Task Summary
									by Product</h5>
							</div>
							<div class="row">
								<div class="table-responsive" style="margin: 15px;">
									<div style="width: 100%;">
										<div>
											<table class="table table-striped" id="solnTask"
												style="width: 100%;">
												<thead>
													<tr>
														<th>Solution Name</th>
														<th>Total <br> Task
														</th>
														<th>Completed <br> Task
														</th>
														<th>Pending <br> Task
														</th>
													</tr>
												</thead>
												<tbody>
													<!-- Data will be injected here -->
												</tbody>
											</table>
											<!--                         <span id="spin1" style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"> -->
											<!--                             <i class="fa fa-spinner fa-spin" style="font-size: 33px"></i> -->
											<!--                         </span> -->
										</div>
									</div>
								</div>
							</div>
						</div>
						</div>
						
						
						
						
						
						<div class="col-md-6" >
						<div class="card flex-fill d-flex" id="todayCard">
							<div class="card-header">
								<h5 class="card-title mb-0"
									style="font-weight: bold; font-size: 20px;">Task Summary
									by FH</h5>
							</div>
							<div class="col-md-12" style="width: 100%;">
								<table class="table table-striped" id="funTask"
									style="width: 100%;">
									<thead>
										<tr>
											<th>Functional Head</th>
											<th>Total <br> Task
											</th>
											<th>Completed <br> Task
											</th>
											<th>Pending <br> Task
											</th>
										</tr>
									</thead>
									<tbody>
										<!-- Data will be injected here -->
									</tbody>
								</table>
								<span id="spin11"
									style="width: 5rem; height: 5rem; margin-left: 50%; display: none;">
									<i class="fa fa-spinner fa-spin" style="font-size: 33px"></i>
								</span>
							</div>
						</div>
						</div>
							
				</div>
				
				
				


					
				<div class="row">

					<div class="col-md-5 " style="display: none;">
						<div class="card flex-fill d-flex allCards">
							<div class="card-header">
								<h5 class="card-title mb-0"
									style="font-weight: bold; font-size: 20px;">Projects By
									Team Leader</h5>
							</div>
							<div class="col-md-12" style="width: 100%;">

								<table class="table table table-striped" id="TotalProject"
									style="width: 100%;">

									<thead>
										<tr>
											<th>Team Leader</th>
											<!-- 															<th>Solution</th> -->
											<th>Functional Head</th>
											<!-- 															<th>Closed<br> Task&nbsp; </th>	 -->
											<th>Total Project</th>
											<!-- 															<th>Completed Today </th> -->
											<!-- 															<th>In Progress </th> -->
										</tr>
									</thead>
								</table>
								<span
									style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
									id="spin2"><i class="fa fa-spinner fa-spin"
									style="font-size: 33px"></i></span>
							</div>
						</div>
					</div>





					<div id="CMTotalProjectStatusN2" class="col-md-7"
						style="display: none;">
						<div class="card flex-fill d-flex">
							<div class="card-header">
								<h5 class="card-title mb-0"
									style="font-weight: bold; font-size: 20px;">Task by
									Solution & Status</h5>
							</div>
							<div class="row">
								<div class="col-md-11" style="margin-left: 15px;">

									<!-- 										<div class="table-responsive" > -->

									<table class="table table table-striped"
										id="ProjectDetailsCMN2" style="width: 100%;">

										<thead>
											<tr>
												<th>Solution_Name&nbsp;</th>
												<th>Open<br> Task&nbsp;
												</th>
												<th>Yet to<br> assign&nbsp;
												</th>

												<th>Assigned&nbsp;</th>
												<th>Developed&nbsp;</th>
												<th>Tested&nbsp;</th>
												<th>Ready_to Deliver&nbsp;</th>

											</tr>
										</thead>
									</table>
									<span
										style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
										id="spin4"><i class="fa fa-spinner fa-spin"
										style="font-size: 33px"></i></span>

									<!-- 										</div> -->
								</div>

							</div>
						</div>
					</div>


				</div>


				<div class="modal fade" id="TaskModal" tabindex="-1" role="dialog"
					aria-labelledby="MDMODALLabel" aria-hidden="true"
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
									Developer Name : <span id="fHeadSpan"></span>
								</h6>

								<table class="table" id="TaskDetailsByName">
									<thead>
										<tr>
											<th>Sr No</th>
											<th>Solution_Name</th>
											<th>RFP_Point</th>
											<th>Target_Date</th>
											<th>Team Leader</th>
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


				<div class="modal fade" id="TaskModalSolution" tabindex="-1"
					role="dialog" aria-labelledby="MDMODALLabel2" aria-hidden="true"
					style="overflow: auto;">
					<div class="modal-dialog modal-lg" role="document"
						style="margin-left: 25%;">
						<div class="modal-content" style="width: 110%;">
							<div class="modal-header">
								<h5 class="modal-title" id="TotalActivitiesDelayedModalLabel2">Task
									Details</h5>
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
											<th>RFP_Point</th>
											<th>Target_Date</th>
											<th>Team Leader</th>
											<th>Status</th>
											<th>Pending_With</th>
											<!-- 													<th>Delay Days</th> -->
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
								<h5 class="modal-title" id="TotalCountModal">Task Details</h5>
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
											<th>Functional Head</th>
											<th>RFP_Point</th>
											<th>Target_Date</th>
											<th>Team Leader</th>
											<th>Developer</th>
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



				<div class="modal fade" id="TotalTaskModal" tabindex="-1"
					role="dialog" aria-labelledby="MDMODALLabel3" aria-hidden="true"
					style="overflow: auto;">
					<div class="modal-dialog modal-lg" role="document"
						style="margin-left: 20%;">
						<div class="modal-content" style="width: 125%;">
							<div class="modal-header">
								<h5 class="modal-title">
									<span id="modalName"></span>
								</h5>

								<div class="modal-actions" style="margin-left: 70%">
									<button type="button" class="btn btn-primary" id="exportExcel">Excel</button>
									<button type="button" class="btn btn-primary" id="exportPDF">PDF</button>
								</div>

								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>


							</div>
							<div class="modal-body" id="taskAssignModalCounts">

								<input type="text" id="searchBoxAct" placeholder="Search"
									class="form-control" style="width: 20%"><br>


								<table id="TotalTask" class="table table-bordered table-striped">
									<thead style="width: 100%">
										<tr style="background-color: #c6d9ec;">
											<th>Solution</th>
											<th style="width: 30%;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RFP_Point&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
											<th>Target_Date</th>
											<th>Team_Leader</th>
											<th>Developer</th>
											<th>Status</th>
											<th>Pending With</th>
											<th id="thDelayDays" style="display: none;">Delay Days</th>
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
				
				
				
				<div class="modal fade" id="TaskModalss" tabindex="-1"
								role="dialog" aria-labelledby="MDMODALLabel" aria-hidden="true"
								style="overflow: auto;">
								<div class="modal-dialog modal-lg" role="document"
									style="margin-left: 25%;">
									<div class="modal-content" style="width: 110%;">
										<div class="modal-header">
											<h5 class="modal-title" id="">Task
												Details</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body" id="taskAssignModal">

											<h6>
												Functional Head : <span id="nameSpan1"></span>
											</h6>

											<table class="table" id="TaskDetailsByName1">
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


							<div class="modal fade" id="TaskModalSolution1" tabindex="-1"
								role="dialog" aria-labelledby="MDMODALLabel2" aria-hidden="true"
								style="overflow: auto;">
								<div class="modal-dialog modal-lg" role="document"
									style="margin-left: 25%;">
									<div class="modal-content" style="width: 110%;">
										<div class="modal-header">
											<h5 class="modal-title"
												id="">Task Details</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body" id="">

											<h6>
												Solution Name : <span id="solutionNameSpan1"></span>
											</h6>

											<table class="table" id="TaskDetailsBysoln1">
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
				
				

				<br>

				<div class="row" style="display: none;">
					<div class="col-md-1"></div>
					<div class="col-md-12">
						<div class="card card-secondary">
							<div class="card-header">All RFP Task</div>
							<div class="card-body">
								<div id="eeeew">

									<table class="table table1 table-striped" id="productdata">
										<thead>
											<tr>
												<th>Sr No</th>
												<th>View</th>
												<th>Status</th>
												<!-- 												<th>Customer_Name</th> -->
												<th>Product_Suit - Tool</th>
												<th>Module Name</th>
												<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RFP_Points&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
												<!-- 												<th>Submitted_By</th> -->
												<!-- 												<th>Submitted Date</th> -->
												<th>Target_Date</th>
												<th>Functional Head</th>
												<th>Team_Leader</th>
												<th>Developer</th>
												<th>Tester</th>
												<th>Status Update_Date</th>
												<!-- 												<th>Test Failures_Count</th> -->
											</tr>
										</thead>
										<tbody>

										</tbody>

									</table>
									<span
										style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
										id="spin3"><i class="fa fa-spinner fa-spin"
										style="font-size: 33px"></i></span>
								</div>

							</div>
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>




				<div class="col-md-1"></div>

			</div>
		</div>
	</div>



	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Control sidebar content goes here -->
	</aside>
	<!-- /.control-sidebar -->
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

	<!-- SheetJS for Excel export -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.0/xlsx.full.min.js"></script>

	<!-- jsPDF for PDF export -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.21/jspdf.plugin.autotable.min.js"></script>

	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/highcharts-3d.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/RFPDashboard.js"></script>



</body>
</html>