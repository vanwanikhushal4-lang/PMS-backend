<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
   
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Service Request Reports</title>

<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
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
<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}
.datetimepicker{
    z-index: 1071 !important;
}

.text-wrap{
    white-space:normal;
}
.width-450{
    width:450px;
}
</style>
</head>
  <body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
<jsp:include page="/WEB-INF/views/dashboardheaderTP.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>  
                <div class="content-wrapper">

            <section class="content-header">
                <div class="row" id="form1">
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <br><br>
                        <div class="card card-secondary">
                            <div class="card-header">Service Request Report</div>
                            <div class="card-body">
                                <div class="row">
									<div class="col-md-6">
                                                <label>From Date:</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                            <i class="far fa-calendar-alt"></i>
                                                        </span>
                                                    </div>
                                                    <input type="text" id="FromDate" tabindex="1" class="form-control" name="fromdate" placeholder="Please Select From Date" readonly>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <label>To Date:</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text">
                                                            <i class="far fa-calendar-alt"></i>
                                                        </span>
                                                    </div>
                                                    <input type="text" id="ToDate" tabindex="2" class="form-control" name="todate" placeholder="Please Select To Date" readonly>
                                                </div>
                                            </div>
                                       
                                <br>
                              			 <div class="col-md-6 ">
									
												

										<label for="vendor_name1" class="mt-3">Company:</label>
										
											<select class="form-control" class="form-control" tabindex="2" id="vendor_name1"
												name="vendor_name1">
												<option value="">-- Please Select Vendor --</option>
											</select>
											
										
									</div>
									</div>
                                    <br>
									<div class="col-md-12 text-center">
				<input type="submit" class="btn btn-primary m-t-10"  id="submit-btn" name="submit" value="Submit">
                <input type="reset" class="btn btn-primary m-t-10" onclick="Javascript:resetData();" id="resetbtn" name="reset" value="Reset">
                                    </div>
                                </div>
                            </div>
                        </div>
                          <div class="col-md-2"></div>
                    </div>
                  
             
             	<div style="padding-left: 15px; padding-right: 15px">
					<div class="card card-secondary" id="dataSet1" style="display: none;">
						<div class="card-header">
							Service Request Report

							<button class="btn-xs btn-secondary float-right" id="backbtn"
								name="backbtn" onclick="window.location.href = '<%=request.getContextPath()%>/TP/ServiceRequestReport'">
								<i class="fas fa-backward"></i><span> Back</span>
							</button>

						</div>

						<div class="card-body">
						<div class="row" id="preLoader"><div class="col-md-12 text-center font-weight-bold h6">Loading <i class="fas fa-sync fa-spin"></i></div></div>
							<div id="eeeew">
								<div class="row">
									<div class="col-md-3">
										<b> From Date:</b> <span id="fromD"></span>
									</div>
									<div class="col-md-3">
										<b> To Date:</b> <span id="toD"></span>
									</div>
								</div>
								<br>
								<table class="table table1 table-striped d-done" id="Listing_Enggwise1">
									<thead>
										<tr>
									 <th>Request ID</th>  
                                        <th>Status</th>
                                        <th>Priority</th>
                                        <th>Severity</th>
                                        <th>Subject</th>
                                        <th>Description</th>
                                        <th>Company</th>
                                        <th>Branch</th>
                                        <th>Department</th>
                                        <th>Category</th>
                                        <th>Sub-Category1</th>
                                      	<th>Sub-Category2</th>
                                      		<th>Raised By</th>
                                      	<th>Raised By Full Name</th>
										<th>Raised By Email</th>
                                      	<th>Raised For</th>
                                      	<th>Raised For Full Name</th>
										<th>Raised For Email</th>
										<th>Raised Date </th>
										<th>Raised Time</th>
                                        <th>Assigned By</th>
                                        <th>Assigned By Full Name</th>
										<th>Assigned By Email</th>
                                        <th>Assigned By Company</th>
                                        <th>Assigned By Branch</th>
                                        <th>Assigned By Department</th>
                                        <th>Assigned&nbsp;Date</th>
                                       	 <th>Assigned Time</th>
                                         <th>Assigned To</th>
                                            <th>Assigned/Engineer Group</th>
                                          <th>Assigned Engineer Name</th>
                                          <th>Assigned Engineer Full Name</th>
										<th>Assigned Engineer Email</th>	
                                          <th>Service Request Type</th>
                                          <th>Approval Level </th>
                                          <th>Level-1 Designation</th>
                                          <th>Level-1 Action By</th>
                                          <th>Level-1 Action By Full Name</th>
										<th>Level-1 Action By Email</th>
                                            <th>Level-1 Status</th>
                                          <th>Level-1 Date </th>      
                                          <th>Level-1 Time</th>                                             
                                           <th>Level-1 Notes</tH>     
                                             <th>Level-2 Designation</th>
                                          <th>Level-2 Action By</th>
                                          <th>Level-2 Action By Full Name</th>
										<th>Level-2 Action By Email</th>
                                            <th>Level-2 Date</th>
                                             <th>Level-2 Time</th>
                                          <th>Level-2 Status</th>
                                           <th>Level-2 Notes</th>
                                           <th>Resolved By</th>
                                       	<th>Resolved By Full Name</th>
										<th>Resolved By Email</th>
                                       	<th>Resolved By Company</th>
                                        <th>Resolved&nbsp;Date </th>
                                          <th>Resolved&nbsp;Time</th>
                                        <th>Resolved By Note</th>
                                          <th>Closed By</th>
                                          <th>Closed By Full Name</th>
										<th>Closed By Email</th>
                                          <th>Closed&nbsp;Date</th>
                                           <th>Closed Time</th>
                                          <th>Closed Note</th>
                                         
										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
							</div>
						</div>
					</div>
				</div>
             
             
            </section>
           
             </div>
       </div>
          <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>


<!-- ./wrapper -->
<!-- jQuery -->
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script> -->
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
	<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script> --%>

	<%--   <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script> --%>
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
		<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/moment/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.print.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.colVis.min.js"></script>
  <script src="<%=request.getContextPath()%>/static/custom/serviceRequestReports.js"></script>

</body>
     
</html>

