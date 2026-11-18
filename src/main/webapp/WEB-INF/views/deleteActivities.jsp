<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Delete Activities</title>
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

label {
	margin-top: .5rem !important;
	margin-bottom: 0rem !important;
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
						<form action="insertUserRaiseTicket" id="form" name="form"
							method="post" enctype="multipart/form-data">

							<div class="card card-secondary">

								<div class="card-header">Delete Activities</div>
								<div class="card-body">

									


									<div class="row">

                                         <div class="col-md-6" style="margin-top: 15px;">
											<label for="rtype">Product Suit :</label> <select id="productsuitdetails"
												class="form-control" tabindex="8" data-toogle="tooltip"
												name="productsuitdetails" onchange="getSecTools()">
     
											</select>

										</div>

									
									 
									 
									  <div class="col-md-6" style="margin-top: 15px;">
											<label for="rtype">Security Tools :</label> <select id=securitysolutiondetails
												class="form-control" tabindex="8" data-toogle="tooltip"
												name="securitysolutiondetails" >
                                               <option value=""> -- Please Select --</option>
											</select>

										</div>
									 

									</div>

									<div class="row">


											<div class="col-md-6" style="margin-top: 15px;">
												<label>Customer Name :</label>
												<div class="form-group col-md-12" id="companyDiv"
													style="padding: 0;">
													<select class="form-control select2" id="customerName"
														style="width: 100%;">
														<!-- Add options here if needed -->
													</select>
												</div>
											</div>
									
											<div class="col-md-6" style="margin-top: 15px;">
											<label>Status :</label>
												<select id="projectStatus"
												class="form-control" tabindex="8" data-toogle="tooltip"
												name="projectStatus" > 	
												</select>		
										</div> 
										
										
										
										
									 
									</div>
									
							
						
									
																
								<div class="row">

										<div style="margin-top: 15px;" class="col-md-12">
											<center>
												
												<button type="button" class="btn btn-primary m-t-10"
													tabindex="4" id="submit-btn" name="submit" >Submit
												</button>

												<button type="button" tabindex="5"
													class="btn btn-primary m-t-10" id="resetbtn" name="reset">Reset</button>

											</center>
										</div>
									</div>	
								

						</form>
					</div>
					<div class="col-md-1"></div>

				</div>
				<br><br>
				
				
			<!-- //16/11 -->
			<div style="padding-left:15px; padding-right: 15px; display:none" id="deleteActivitiesCard" >
	            <div class="card card-secondary border-secondary">
	               <div class="card-header">Delete Activities </div>
	                                    <div class="card-body">
	
	                <div id="eeeew">
	
	                    <table class="table table1 table-striped"  id="CMApprByMeTable" >
	                        <thead>
	                            <tr>
	                            			<th><input type="checkbox" id="checkAll" onclick="checkAllClicked()">&nbsp;Check
												All</th>
<!-- 	                                        <th>View</th> -->
	                                        <th>Assign Date</th>
	                                        <th>Status</th>      
	                                         <th>Task ID</th>                                        
	                                        <th>Customer Name</th>
	                                        <th>Product Suite</th>
	                                        <th>Product Tool</th>
	                                        <th>Activity</th>
	                                        <th>Module Name</th>
	                                        <th>Assigned To</th>
	                                        <th>Team Leader Name</th>                                   
	                                        <th>Task Assigned By</th>
											<th>Start Date</th>
											<th>End Date</th>
											
	                                        
	
	                            </tr>
	                        </thead>
	                        <tbody>
	
	                        </tbody>
	
	                    </table>
	                    <span
									style="width: 5rem; height: 5rem; margin-left: 480px; display: none;"
									id="spin12"><i class="fa fa-spinner fa-spin"
									style="font-size: 33px"></i></span>
	                </div>
	                
	                
	                <div style="margin-top: 25px;" class="col-md-12">
	    					<center>
	        					<button type="submit" tabindex="8"
	            					class="btn btn-primary m-t-10" id="sub" name="submit"
	            					data-style="expand-left" onclick="deleteActivities()">
	            					Delete &nbsp; <span class="spinner-border"
	                				style="width: 1rem; height: 1rem; display: none;" id="spin2"></span>
	        					</button>
	    					</center>
							</div>
	
	            </div>
	        </div>
	        </div>
			<!--  -->
				
			</section>
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
		src="<%=request.getContextPath()%>/static/custom/deleteActivities.js"></script>
</body>

</html>


