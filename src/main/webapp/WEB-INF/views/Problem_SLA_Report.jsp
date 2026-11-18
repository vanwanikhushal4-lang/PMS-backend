<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
   
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Problem SLA Report</title>
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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.css" type="text/css"/>
   <script src="<%=request.getContextPath()%>/static/js/multi2.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/multi3.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/multijquery.js"></script>
<%--     <link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css" type="text/css"/> --%>
  <!-- Google Font: Source Sans Pro -->
  <!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
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
margin-left: 0px;
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
.datetimepicker{
    z-index: 1071 !important;
}
   </style>
</head>
  <body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
 <jsp:include page="/WEB-INF/views/dashboardheaderUser.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>  
                <div class="content-wrapper">

            <section class="content-header">
                <div class="row" id="form1">
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <br><br>
                        <div class="card card-secondary">
                            <div class="card-header">Problem SLA Report</div>
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
                                        </div>
                                <br>
                               		
                               		<div class="row">
                                        
                                            <div class="col-md-6">
                                                 <label for="SLAStatus1">SLA Type:</label>
                                                <div class="form-group">
                                                    <select class="form-control" tabindex="1" id="SLAType" name="SLAType" style="height: 34px; width: 100%" onchange="JavaScript:toggleSLASelection(this.value)">
                                                        <option value="">Please Select SLA Type</option>
                                                        <option value="All">All</option>
                                                           <option value="Advanced">Advanced</option>
                                                          <option value="Not Set">Not Set</option>
                                                        <option value="Standard">Standard</option>
                                                     
                                                      
                                                         
                                                    </select>
                                                </div>
                                              </div>
                                              <div class="col-md-6">
                                              <div id="divAll" style="display:none">
                                                 <label for="SLAStatusAll">SLA Status:</label>
                                                <div class="form-group">
                                                    <select class="form-control" tabindex="1" id="SLAStatusAll" name="SLAStatusAll" style="height: 34px; width: 100%">
                                                        <option value="">Please Select Status</option>
                                                         <option value="All">All</option>
                                                        <option value="SLA Met">SLA Met</option>
                                                        <option value="SLA Breach">SLA Breach</option>
                                                         
                                                    </select>
                                                	</div>
                                     			</div>
                                     			<div id="divStandard" style="display:none">
                                                 <label for="SLAStatusStandard">SLA Status:</label>
                                                <div class="form-group">
                                                    <select class="form-control" tabindex="1" id="SLAStatusStandard" name="SLAStatusStandard" style="height: 34px; width: 100%">
                                                        <option value="">Please Select Status</option>
                                                         <option value="All">All</option>
                                                        <option value="SLA Met">SLA Met</option>
                                                        <option value="SLA Breach">SLA Breach</option>
                                                         
                                                    </select>
                                                </div>
                                     			</div>
                                              </div>
                                        
                                    </div>
                               
                                     <div id="divAdvanced" style="display:none">
                                     <div class="row">
                                        <div class="col-md-4">
                                                 <label for="RCAStatus">RCA SLA Status:</label>
                                                <div class="form-group">
                                                    <select class="form-control" tabindex="1" id="RCAStatus" name="RCAStatus" style="height: 34px; width: 100%">
                                                        <option value="">Please Select Status</option>
                                                         <option value="All">All</option>
                                                        <option value="SLA Met">SLA Met</option>
                                                        <option value="SLA Breach">SLA Breach</option>
                                                         
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="col-md-4">
                                                 <label for="FIXStatus">Fix SLA Status:</label>
                                                <div class="form-group">
                                                    <select class="form-control" tabindex="1" id="FIXStatus" name="FIXStatus" style="height: 34px; width: 100%">
                                                        <option value="">Please Select Status</option>
                                                         <option value="All">All</option>
                                                        <option value="SLA Met">SLA Met</option>
                                                        <option value="SLA Breach">SLA Breach</option>
                                                         
                                                    </select>
                                                </div>
                                            </div>
                                             <div class="col-md-4">
                                                 <label for="TotalStatus">Total SLA Status:</label>
                                                <div class="form-group">
                                                    <select class="form-control" tabindex="1" id="TotalStatus" name="TotalStatus" style="height: 34px; width: 100%">
                                                        <option value="">Please Select Status</option>
                                                         <option value="All">All</option>
                                                        <option value="SLA Met">SLA Met</option>
                                                        <option value="SLA Breach">SLA Breach</option>
                                                         
                                                    </select>
                                                </div>
                                            </div>
                                     </div>
                                     </div>
                                     <br>
                                <div class="row">
									<div class="col-md-12 text-center">
				<input type="submit" class="btn btn-primary m-t-10"  id="submit-btn" name="submit" value="Submit">
                <input type="reset" class="btn btn-primary m-t-10" onclick="Javascript:resetData();" id="resetbtn" name="reset" value="Reset">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2"></div>
                </div>
           
			   <div style="padding-left:15px; padding-right: 15px">
                 <div class="card card-secondary" id="dataSet1" style="display: none;">
                     <div class="card-header">Problem SLA Report
                         
                         <button class="btn-xs btn-secondary float-right" id="backbtn" name="backbtn" onclick="window.location.href = '<%=request.getContextPath()%>/ITHead/Problem_SLA_Report'"><i class="fas fa-backward"></i><span> Back</span></button>
                    
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
                            <table class="table table1 table-striped d-done"  id="Listing_SLAwise" >
                                <thead>
                                    <tr>
                                        		 <th>Sr No</th>
                                                <th>Ticket&nbsp;ID</th>
                                                <th>Raised By</th>
                                              
                                               <th>Priority</th>
                                               
                                               <th>Severity</th>
                                               
                                                <th>Category</th>
                                                 <th>Sub_Category1</th>
                                                  <th>Sub_Category2</th>
                                                   <th>Company</th>
                                                       <th>Department</th>
                                                    <th>Branch</th>
                                         
                                                 <th>Subject</th>
                                               <th>Problem Status</th>
                                                <th>SLA&nbsp;Type</th>
                                                
                                                <th>Total&nbsp;Target</th>
                                                <th>Total Start&nbsp;Date</th>
                                                <th>Total End&nbsp;Date</th>
                                                <th>Total Duration</th>
                                                <th>Total SLA Status</th>
                                                
                                                <th>RCA&nbsp;Target</th>
                                                <th>RCA Start&nbsp;Date</th>
                                                <th>RCA End&nbsp;Date</th>
                                                <th>RCA Duration</th>
                                                <th>RCA SLA Status</th>
                                                
                                                <th>Fix&nbsp;Target</th>
                                                <th>Fix Start&nbsp;Date</th>
                                                <th>Fix End&nbsp;Date</th>
                                                <th>Fix Duration</th>
                                                <th>Fix SLA Status</th>
                                                
                                                
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
        

          <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</div>

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
		
				   <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.js"></script>
   <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.min.js"></script>
  <script src="<%=request.getContextPath()%>/static/custom/Problem_SLA_Report.js"></script>

</body>
     
</html>


