<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operational Dashboard</title>
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
 

<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

body {
	font-size: 85% !important;
}



.highcharts-figure,
.highcharts-data-table table {
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

<script>
  
  
        <%
            String role = (String) session.getAttribute("role");
            System.out.println("roleee" + role);
            
            String designation = (String) session.getAttribute("designation");
        %>
    </script>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		
	<input type="hidden" id="role" name="role" value="<%=role%>">
	<input type="hidden" id="designation" name="designation" value="<%=designation%>">
		<div class="content-wrapper">
			<section class="content-header"></section>



			<div class="wrapper" style="margin: 0 30px 0 30px; "
				id="CollectionManagerDash">
				<div class="main">
				
				
				
					<div class="container-fluid p-0">
						<center>
							<h1 class="h3 mt-2">Operational Task Dashboard</h1><br>
						</center>
						
	<div class="row" style="display: none;">
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box">
            <span class="info-box-icon bg-info"><i class="ion ion-ios-gear-outline"></i></span>

            <div class="info-box-content">
              <span class="info-box-text">CPU Traffic</span>
              <span class="info-box-number">90<small>%</small></span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        <!-- /.col -->
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box">
            <span class="info-box-icon bg-red"><i class="fa fa-google-plus"></i></span>

            <div class="info-box-content">
              <span class="info-box-text">Likes</span>
              <span class="info-box-number">41,410</span>
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
            <span class="info-box-icon bg-green"><i class="ion ion-ios-cart-outline"></i></span>

            <div class="info-box-content">
              <span class="info-box-text">Sales</span>
              <span class="info-box-number">760</span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        <!-- /.col -->
        <div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box">
            <span class="info-box-icon bg-yellow"><i class="ion ion-ios-people-outline"></i></span>

            <div class="info-box-content">
              <span class="info-box-text">New Members</span>
              <span class="info-box-number">2,000</span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
        <!-- /.col -->
      </div>
						
						
						<!-- //05/12 -->
						<div class="row">
						
						
						<div id="CMTotalProjectStatusN" class="col-md-7">

							
								<div class="card flex-fill d-flex" >
									<div class="card-header"> 
										<h5 class="card-title mb-0" style="font-weight: bold; font-size: 20px;">Customer Wise Task</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">
<!-- 										<div class="" style="margin: 15px; width: 100%;"> -->

											<div id="AllDetailsOfProjectsN">
												<table class="table table1 table-striped"
													id="ProjectDetailsCMN" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name&nbsp;</th>
															<th>Solution<br> Name&nbsp;</th>
															<th>Open<br> Task&nbsp;</th>
															<th>Delayed<br> Task&nbsp;</th>	
															<th>On Track<br>&nbsp;</th>
														</tr>
													</thead>
												</table>
											</div>

										</div>

									</div>
								</div>
						</div>
						
<!-- 						<div class="col-md-6" style="display :none;"> -->
<!-- 							<div class="card flex-fill"> -->
<!-- 									<div class="row"> -->
<!-- 										    <div id="containerDiv" style="width:80%; margin-left: 10%; "></div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 						</div> -->


						<div class="col-md-5" id="pendingForAssignDiv" style="display :none;">

							
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0" style="font-weight: bold; font-size: 20px;">Pending For Assign</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">


											<div >
												<table class="table table1 table-striped"
													id="assignForTable" style="width: 100%;">

													<thead>
														<tr>
															
															<th>Customer&nbsp;
															</th>
															<th>Solution&nbsp;
															</th>
															<th>Open Task
															</th>													
														</tr>
													</thead>
												</table>
												
											</div>

										</div>

									</div>
								</div>
						</div>
					
						
						
						<div id="CMTotalProjectStatusN1" class="col-md-7" style="display: none;">

							
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0" style="font-weight: bold; font-size: 20px;">Team Wise</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">


											<div id="AllDetailsOfProjectsN1">
												<table class="table table1 table-striped"
													id="TeamWiseTable" style="width: 100%;">

													<thead>
														<tr>
															<th>Name&nbsp;
															</th>
															<th>Solution&nbsp;
															</th>
															<th>Assigned&nbsp;
															</th>
															<th>Delayed&nbsp;
															</th>
															<th>On Track&nbsp;
															</th>
															
														</tr>
													</thead>
												</table>
												
											</div>

										</div>

									</div>
								</div>
						</div>
						
						
						<div class="col-md-5">

							
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0" style="font-weight: bold; font-size: 20px;">Due For Today</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">


											<div >
												<table class="table table1 table-striped"
													id="DueForToday" style="width: 100%;">

													<thead>
														<tr>
															<th>Task&nbsp;
															</th>
															<th>Status&nbsp;
															</th>
															<th>Pending With&nbsp;
															</th>
															
														</tr>
													</thead>
												</table>
												
											</div>

										</div>

									</div>
								</div>
						</div>
						
						
						<div class="modal fade" id="TaskModal" tabindex="-1" role="dialog"
							aria-labelledby="MDMODALLabel" aria-hidden="true" style="overflow: auto;">
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

										<h6> Customer Name : <span id="customerNameSpan"></span></h6>

										<table class="table" id="TaskDetailsByName">
											<thead>
												<tr>
													<th>Sr No</th>
													<th>Product tool</th>
													<th>Customization/Bug</th>
													<th>Expected_Date</th>
													<th>Manager Name</th>
													<th>Status</th>
													<th>Pending_With</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal" >Close</button>
									</div>
								</div>
							</div>
						</div>
						
						
						
						<div id="CMTotalProjectStatusN2" class="col-md-12" style="display: none;">

							
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0" style="font-weight: bold; font-size: 20px;">Solution Wise</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">


											<div id="AllDetailsOfProjectsN2">
												<table class="table table1 table-striped"
													id="ProjectDetailsCMN2" style="width: 100%;">

													<thead>
														<tr>
															<th>Solution<br> Name&nbsp;
<!-- 															<i class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															</th>
															<th>Open<br> Task&nbsp;
<!-- 															<i class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															</th>
															<th>Yet to<br> assign&nbsp;
<!-- 															<i class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															</th>
															<th>Delayed<br> Task&nbsp;
<!-- 															<i class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															</th>
															
															<th>Assigned&nbsp;
<!-- 															<i class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															</th>
															<th>Developed&nbsp;
<!-- 															<i class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															</th>
															<th>Tested&nbsp;
<!-- 															<i class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															</th>
															<th>Ready to Deliver&nbsp;
<!-- 															<i class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															</th>
															
														</tr>
													</thead>
												</table>
												
											</div>

										</div>

									</div>
								</div>
							

						</div>
						
						
	
						</div>
						<!--  -->


						
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

	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script>
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
		
		<script src="https://code.highcharts.com/highcharts.js"></script>

<!-- 		<script src="https://code.highcharts.com/highcharts.js"></script>	 -->
<!-- 		<script src="https://code.highcharts.com/highcharts-3d.js"></script> -->
		
		<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script>	
		

	<script
		src="<%=request.getContextPath()%>/static/custom/operationalDashboardUser.js"></script>


	<script>



</script>
</body>
</html>