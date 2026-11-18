<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Outage Master</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

 <link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.css" type="text/css"/>

<style type="text/css">
  .card{
  border: 1px solid rgb(0, 123, 255) !important;
  }
   .multiselect-clear-filter:after {
  content: "\f057";
  font-family: 'Font Awesome\ 5 Free';
  }
  .table-condensed .prev:after {
  content: "\f060";
  font-family: 'Font Awesome\ 5 Free';
  }
  .table-condensed .next:after {
  content: "\f061";
  font-family: 'Font Awesome\ 5 Free';
  }
  label{
  padding: 3px 0px 0px 14px !important;
  }
  .input-group-addon {
    padding: 6px 12px;
    font-size: 14px;
    font-weight: 900;
    text-align: center;
    border: 1px solid #ccc;
  }
  .input-group-addon:after {
  content: "\f002";
  font-family: 'Font Awesome\ 5 Free';
  }
   .btn-secondary {
    color: #6c757d !important;
    background-color: white !important; 
    border-color: #6c757d !important;
    box-shadow: none !important;
}
.datetimepicker {
z-index: 9999 !important;
}
.tooltip {
z-index: 1033 !important;
}
label{
  margin-top: .5rem !important;
  margin-bottom: 0rem !important;
  }
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
<jsp:include page="/WEB-INF/views/dashboardheaderTP.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>  
		<div class="content-wrapper">
		<br><br>
			<section class="content-header">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						
						<div class="card card-secondary">
							<div class="card-header">Outage Master</div>
							<div class="card-body">
								<div class="row">
									<div class=col-md-6>
										<label for="priority1">Company Name:</label>
                                                <div class="form-group">
                                                    <select class="form-control" tabindex="1" id="companyname" name="companyname" onchange="getBranchNameList(this.value)" style="height: 34px; width: 100%">
                                                        <option value="">Please Select Company</option>
<!--                                                         <option value="">All</option> -->
                                                    </select>
                                                </div>
                                       </div>
                                       <div class="col-md-6">
                                       <label for="user_name">Branch Name</label>
                                                <div class="form-group" id="branchname1" style="height: 34px; width: 100%">
                                                    <select class="form-control" tabindex="2" id="branchname" name="branchname" onchange="getDepartmentNameList(this.value)" multiple="multiple">
<!--                                                         <option value="">Please Select Branch</option> -->
                                                    </select>
                                                </div>
                                       </div>
                                 </div>
								<div class="row">
									<div class="col-md-6">
                                       <label for="user_name">Department Name</label>
                                                <div class="form-group" id="departmentname1" style="height: 34px; width: 100%">
                                                    <select class="form-control" tabindex="2" id="departmentname" name="departmentname" multiple="multiple">
<!--                                                         <option value="">Please Select Department</option> -->
                                                    </select>
                                                </div>
                                       </div>
                                    <div class=col-md-6>
										<label for="priority1">Impact Severity:</label>
                                                <div class="form-group">
                                                    <select class="form-control" tabindex="1" id="severity" name="severity" style="height: 34px; width: 100%">
                                                        <option value="">Please Select Severity</option>
                                                          <option value="Critical">Critical</option>
                                                            <option value="High">High</option>
                                                        <option value="Low">Low</option>
                                                        <option value="Medium">Medium</option>
                                                      
                                                      
                                                    </select>
                                                </div>
                                       </div>

								</div>
								<div class="row">
								<div class="col-md-12">
								 <label for="cname">Message:</label>
                                 <textarea  rows="5" cols="20" id="message"  tabindex="12" class="form-control" data-toogle="tooltip" name="message" placeholder="Please Enter Message" ></textarea>
                                </div>
								</div>
								
								<div class="row">
								<div class="col-md-12 text-center">
								<label for="cname">Set Duration For Message</label>
								</div>
								</div>
								<div class="row">
								<div class="col-md-3"></div>
								<div class="col-md-6">
									<div class="row">
									<div class="col-md-6">
										<label for="days1">Days:</label>
										<div id="wrongDays">
											<input type="text" class="form-control" id="days" name="days"
												tabindex="2" />
										</div>
									</div>
									<div class="col-md-6">
										<label for="hours1">Hours:</label>
										<div id="wrongHours">
											<input type="text" class="form-control" id="hours"
												name="hours" tabindex="3" />
										</div>
									</div>
									</div>
									</div>
									<div class="col-md-3"></div>
								</div>
								
								<div class="row">
								<div class="col-md-3"></div>
								<div class="col-md-6">
									<div class="row">
									<div class="col-md-6">
										<label for="minutes1">Minutes:</label>
										<div id="wrongMinutes">
											<input type="text" class="form-control" id="minutes"
												name="minutes" tabindex="4" />
										</div>
									</div>
									<div class="col-md-6">
										<label for="seconds1">Seconds:</label>
										<div id="wrongSeconds">
											<input type="text" class="form-control" id="seconds"
												name="seconds" tabindex="5" />
										</div>
									</div>
									</div>
								</div>
								<div class="col-md-3"></div>
								</div>
								<br>
								<div class="row">

									<div class="col-md-12 text-center">
									<button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="submit-btn" name="submit-btn">Submit</button>
									<span class="spinner" style="display: none">
									<i class="fa fa-refresh fa-spin fa-10x"></i></span>
									<button type="button" tabindex="9" class="btn btn-primary m-t-10" id="resetbtn" name="resetbtn" value="Reset">Reset</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-2"></div>
				</div>
				<br>
				<div class="row">
				<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="card card-secondary"
							style="margin-left: 15px; margin-right: 15px">
							<div class="card-header">Outage Details</div>
							<div class="card-body">
								<div id="eeeew">

									<table class="table table1 table-striped" id="datatype">
										<thead>
											<tr>
												<th>Sr No</th>
												<th>Delete</th>
												<th>Company Name</th>
												<th>Branch Name</th>
												<th>Department Name</th>
												<th>Severity</th>
												<th>Message</th>
												<th>Created By</th>
												<th>Days</th>
												<th>Hours</th>
												<th>Minutes</th>
												<th>Seconds</th>
												<th>Timestamp</th>
												<th>Visibility</th>
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
			</section>
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
<!-- 	<script -->
<%-- 		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script> --%>

<!-- 	<script -->
<%-- 		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script> --%>
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
		
		   <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.min.js"></script>


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
		src="<%=request.getContextPath()%>/static/custom/outagemaster.js"></script>

</body>

</html>


