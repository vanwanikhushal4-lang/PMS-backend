<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
  <meta charset="utf-8">
  <%@ page contentType="text/html; charset=UTF-8" %>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>SCM Dashboard</title>
   <link rel="icon" href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <!--<link rel="stylesheet" href="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jqvmap.min.css">-->
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
  <!-- Google Font: Source Sans Pro -->
  <!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
  <!-- Datatables -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
	
	<style>
#containertp,#containertp1,#containeruserforcategory,#containeruserforcategoryinSr,#containerforPriorityseverity,#containerforPriorityseverityinSr
 {
  width: 520px;
  height: 400px;
}

</style>
</head>
  <body class="hold-transition sidebar-mini layout-fixed">
      <div class="wrapper">

<jsp:include page="/WEB-INF/views/dashboardheaderUser.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>  
        
<!--                   <div class="content-wrapper"> -->
<!-- 			<section class="content-header"> -->
<!-- 				<div class="row"> -->

<!-- 					<div class="col-md-6"> -->
<!-- 						<figure class="highcharts-figure"> -->
<!-- 							<div id="containertp"></div>	 -->
<!-- 							<p class="highcharts-description"></p> -->
<!-- 						</figure> -->
<!-- 					</div> -->


<!-- 					<div class="col-md-6"> -->


<!-- 						<figure class="highcharts-figure"> -->
<!-- 							<div id="containertp1"></div> -->
<!-- 							<p class="highcharts-description"></p> -->
<!-- 						</figure> -->
<!-- 					</div> -->

<!-- 				</div> -->
<!-- 									<div class="row"> -->

<!-- 					<div class="col-md-6"> -->
<!-- 						<label>Last Date:</label> -->
<!-- 					<select name="getlastmonthofcategory" id="getlastmonthofcategory"> -->
<!-- 	<option value="lastweek" >Last Week</option> -->
<!-- 	<option value="lastmonth" selected >Last Month</option> -->
<!-- 	<option value="lastthreemonth">Last three Month</option> -->
<!-- </select> -->
<!-- <p id="option-selected"></p> -->
<!-- 						<figure class="highcharts-figure"> -->
<!-- 							<div id="containeruserforcategory"></div> -->
<!-- 							<p class="highcharts-description"></p> -->
<!-- 						</figure> -->
<!-- 					</div> -->
					
				
				
					
<!-- <div class="col-md-6"> -->
<!-- 						<label>Last Date:</label> -->
<!-- 						<select name="getlastmonthofcategoryInSr" id="getlastmonthofcategoryInSr"> -->
<!-- 	<option value="lastweek" >Last Week</option> -->
<!-- 	<option value="lastmonth" selected >Last Month</option> -->
<!-- 	<option value="lastthreemonth">Last three Month</option> -->
<!-- </select> -->
<!-- <p id="option-selected"></p> -->
<!-- 						<figure class="highcharts-figure"> -->
<!-- 							<div id="containeruserforcategoryinSr"></div> -->
							
<!-- 							<p class="highcharts-description"></p> -->
<!-- 						</figure> -->
<!-- 					</div> -->



<!-- 				</div> -->
				
<!-- 				<div class="row"> -->

<!-- 		<div class="col-md-6"> -->
<!-- 							<label>Last Date:</label> -->
<!-- 						<select name="getlastmofps" id="getlastmofps"> -->
<!-- 	<option value="lastweek" >Last Week</option> -->
<!-- 	<option value="lastmonth" selected >Last Month</option> -->
<!-- 	<option value="lastthreemonth">Last three Month</option> -->
<!-- </select> -->
<!-- <p id="option-selected"></p> -->

<!-- 						<figure class="highcharts-figure"> -->
<!-- 							<div id="containerforPriorityseverity"></div> -->
<!-- 							<p class="highcharts-description"></p> -->
<!-- 						</figure> -->
<!-- 					</div> -->

					
<!-- 				<div class="col-md-6"> -->
					
<!-- 							<label>Last Date:</label> -->
<!-- 						<select name="getlastmofpsinSr" id="getlastmofpsinSr"> -->
<!-- 	<option value="lastweek" >Last Week</option> -->
<!-- 	<option value="lastmonth" selected >Last Month</option> -->
<!-- 	<option value="lastthreemonth">Last three Month</option> -->
<!-- </select> -->
<!-- <p id="option-selected"></p> -->

<!-- 						<figure class="highcharts-figure"> -->
<!-- 							<div id="containerforPriorityseverityinSr"></div> -->
<!-- 							<p class="highcharts-description"></p> -->
<!-- 						</figure> -->
<!-- 					</div> -->

				

<!-- 				</div>  -->
			
				
<!-- 			</section> -->
<!-- 			<div class="modal fade bs-example-modal-lg modal-default1111" -->
<!-- 			id="modelviewPrimaryForTickets" tabindex="-1" role="dialog" -->
<!-- 			aria-labelledby="myLargeModalLabel" aria-hidden="true"> -->
<!-- 			<div class="modal-dialog modal-lg"> -->
<!-- 				<div class="modal-content"> -->


<!-- 					<div class="modal-header bg-secondary"> -->
<!-- 						<h4 class="modal-title" id="myLargeModalLabel">View <span id="incident"></span> Incident -->
<!-- 							Tickets</h4> -->
<!-- 						<button type="button" class="close" data-dismiss="modal" -->
<!-- 							aria-label="Close" style="margin-right: 10px"> -->
<!-- 							<span aria-hidden="true">&times;</span> -->
<!-- 						</button> -->


<!-- 					</div> -->
<!-- 					<div class="modal-body"> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-12"> -->
	

<!-- 								<table class="table table1 table-striped" id="Listing_ForTickets" style="width: 100%"> -->
<!-- 									<thead> -->
<!-- 										<tr> -->
<!-- 										<th>Ticket ID</th> -->
<!-- 										<th>Status</th> -->
<!-- 										<th>Company</th> -->
<!-- 										<th>Branch</th> -->
<!-- 										<th>Department</th> -->
<!-- 										<th>Priority</th> -->
<!-- 										<th>Severity</th>						 -->
<!-- 								        <th>Category</th> -->
<!-- 										<th>Sub-Category1</th> -->
<!-- 										<th>Sub-Category2</th> -->
										
<!-- 										<th>Raised By</th> -->
<!-- 										<th>Raised&nbsp;Date & Time</th> -->
<!-- 										<th>Assigned By</th> -->
<!-- 										<th>Assigned&nbsp;Date & Time</th> -->
<!-- 										<th>Hold/WIP/Resolved By</th> -->
<!-- 										<th>Hold/WIP/Resolved&nbsp;Date & Time</th> -->
<!-- 										<th>Closed By</th> -->
<!-- 										<th>Closed Date & Time</th> -->
<!-- 										<th>Reopened By</th> -->
<!-- 										<th>Reopened Date & Time</th> -->
										
<!-- 										</tr> -->
<!-- 									</thead> -->
<!-- 									<tbody> -->

<!-- 									</tbody> -->

<!-- 								</table> -->
<!-- 								<br> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
			
			
			
			
				<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryForServiceRequest" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="servicerequest"></span> Service Request
							Tickets</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped" id="Listing_ForServiceRequest" style="width: 100%">
									<thead>
										<tr>
										      <th>Request ID</th>  
										      <th>Request Type</th>
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
                                        <th>Raised By</th>
                                        <th>Assigned By</th>
                                        <th>Resolved Engineer</th>
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
			
<!-- 			//////////////////////////// -->


		<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryForIncidentCategory" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="incidentcategory"></span> Incident
							Tickets</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">
	

								<table class="table table1 table-striped" id="Listing_ForIncidentCategory" style="width: 100%">
									<thead>
										<tr>
										 	<th>Ticket ID</th>
										 <th>Category</th>
										<th>Company</th>
										<th>Branch</th>
										<th>Department</th>
										<th>Priority</th>
										<th>Severity</th>						
								       
								        <th>Status</th>
										<th>Sub-Category1</th>
										<th>Sub-Category2</th>
										
										<th>Raised By</th>
										<th>Raised&nbsp;Date & Time</th>
										<th>Assigned By</th>
										<th>Assign Date & Time</th>
										<th>Resolved By</th>
										<th>Resolved&nbsp;Date & Time</th>
										
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
			
<!-- 			////////////////////////// -->
			
			
				<div class="modal fade bs-example-modal-lg modal-default1111"
			id="modelviewPrimaryForCategoryServiceRequest" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="categoryservicerequest"></span> Service Request
							Tickets</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">


								<table class="table table1 table-striped" id="Listing_ForCategoryServiceRequest" style="width: 100%">
									<thead>
										<tr>
										<th>Category</th>
                                        <th>Status</th>
                                        <th>Priority</th>
                                        <th>Severity</th>
                                        <th>Subject</th>
                                        <th>Company</th>
                                        <th>Branch</th>
                                        <th>Department</th>
                                        <th>Request Type</th>
                                        <th>Sub-Category1</th>
                                      	<th>Sub-Category2</th> 
                                        <th>Raised By</th>
                                        <th>Assigned By</th>
                                        <th>Resolved Engineer</th>
                                        <th>Raised&nbsp;Date & Time</th>
                                        <th>Assigned&nbsp;Date & Time</th>
                                        <th>Resolved&nbsp;Date & Time</th>
                                        <th>Complete&nbsp;Date & Time</th>
                                        <th>Closed&nbsp;Date & Time</th>
                                        <th>Closed By</th>
                                        <th>Level-1 Action Date</th>
                                     ```<th>Level-1 Action By</th>
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
			id="modelviewPrimaryForIncidentPrioritySeverity" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="incidentpriority"></span> <span id="incidentseverity"></span> Incident
							Tickets</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">
	

								<table class="table table1 table-striped" id="Listing_ForIncidentPrioritySeverity" style="width: 100%">
									<thead>
										<tr>
										 <th>Ticket ID</th>
										 <th>Priority</th>
										<th>Severity</th>
										
										<th>Company</th>
										<th>Branch</th>
										<th>Department</th>
										<th>Category</th>						
								       
								        <th>Status</th>
										<th>Sub-Category1</th>
										<th>Sub-Category2</th>
										
										<th>Raised By</th>
										<th>Raised&nbsp;Date & Time</th>
										<th>Resolved By</th>
										<th>Resolved&nbsp;Date & Time</th>
										<th>Assigned By</th>
										<th>Assign Date & Time</th>
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
			id="modelviewPrimaryForServicePrioritySeverity" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">View <span id="servicepriority"></span> <span id="serviceseverity"></span> Incident
							Tickets</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">
	

								<table class="table table1 table-striped" id="Listing_ForServicePrioritySeverity" style="width: 100%">
									<thead>
										<tr>
										 <th>Ticket ID</th>
										 <th>Priority</th>
										<th>Severity</th>
										<th>Status</th>
										<th>Category</th>
										<th>Subject</th>
										<th>Company</th>
										<th>Branch</th>
										<th>Department</th>
																
								       <th>Request Type</th>
								        
										<th>Sub-Category1</th>
										<th>Sub-Category2</th>
										
										<th>Raised By</th>
										<th>Raised&nbsp;Date & Time</th>
										<th>Resolved By</th>
										<th>Resolved&nbsp;Date & Time</th>
										<th>Assigned By</th>
										<th>Assign Date & Time</th>
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
		
		
<!-- ///////////////	 -->

 <div class="modal fade bs-example-modal-lg modal-default1111" style="display: none;"
			id="MODALPASSWORDALERTPOPUP" tabindex="-1" role="dialog"
			aria-labelledby="myLargeModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" style="margin-left: 34%; margin-top: 6%;">
				<div class="modal-content" style="width: 62%;">


					<div class="modal-header bg-secondary">
						<h4 class="modal-title" id="myLargeModalLabel">Alert <span id="servicerequest"></span> For
							Password Change</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" style="margin-right: 10px" onclick="clickclose()">
							<span aria-hidden="true">&times;</span>
						</button>


					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">
							
						<div style="text-align: center;"><p><strong>Please Change your Password for Better Security</strong></p></div>

                          <div class="row">

										<div style="margin-top: 15px;" class="col-md-12">
											<center>
												
												<button type="button" class="btn btn-primary m-t-10" style="margin-top:15px;"
													tabindex="14" id="okaybutton" name="okay-btn">Okay
												</button>

												<button type="button" tabindex="15" style="margin-top:15px;"
													class="btn btn-danger m-t-10" id="nothanksbtn" name="nothanksbtn" >No Thanks</button>

											</center>
										</div>
									</div>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	
		
		
		
		
		
		</div>
		
<%-- 		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>		 --%>
<!-- ./wrapper -->
</div>
<!-- jQuery -->

 <script src="<%=request.getContextPath()%>/static/resources1/js/highcharts.js"></script>
        <script src="<%=request.getContextPath()%>/static/resources1/js/highcharts-3d.js"></script>
        <script src="<%=request.getContextPath()%>/static/resources1/js/exporting.js"></script>
        <script src="<%=request.getContextPath()%>/static/resources1/js/offline-exporting.js"></script>

<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jquery.vmap.min.js"></script>-->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>-->
<!-- jQuery Knob Chart -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/moment/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/adminlte.js"></script>-->
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/pages/dashboard.js"></script>-->
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/dist/js/demo.js"></script>
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

<script src="<%=request.getContextPath()%>/static/custom/UserDashboard.js"></script>
</body>
     
</html>


