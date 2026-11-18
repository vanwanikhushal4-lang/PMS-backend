<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
   
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Request Mode Master</title>
   <link rel="icon" href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->
  
<!--   <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap/dist/css/bootstrap.min.css">-->
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
   <!-- Datatables -->
   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
<!-- <script src="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css"></script>-->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <!-- bootstrap datepicker -->
<!--  <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">-->
<!-- Sweetalert 2 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">

  <!-- summernote -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
  <!-- Google Font: Source Sans Pro -->
  <!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
  <style type="text/css">
  .card{
  border: 1px solid rgb(0, 123, 255) !important;
  }
  </style>
</head>
  <body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>  
                <div class="content-wrapper">

            <section class="content-header">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6">
                        <br><br>
                        <div class="card card-secondary">
                            <div class="card-header">Request Mode Master</div>
                            <div class="card-body">

								<div class=col-md-12>
									<label for="comapny" style="margin-left: 11%;">Comapny
										</label>
									<div id="companyDiv">
										<select type="text" class="form-control"
											style="width: 75%; margin-left: 11%;" id="company"
											name="comapny" tabindex="1"> <
										</select>
									</div>

								</div>
  
                                    <div class=col-md-12 style="margin-top: 5px;">
                                       <label for="requestmode1" style="margin-left: 11%;">Request Mode</label>
                                            <div id="requestmode1">
                                            <input type="text" placeholder="Please Enter Request Mode" class="form-control" style="width: 75%; margin-left: 11%;" id="requestmode" name="requestmode" tabindex="1"/>
                                            </div>
                                    </div>
                                    
								
                                </div>
                               
                               
                                <div class="row">
								
                                    <div style="margin-top:15px;" class="col-md-12">
                                        <center>
                                          <button type="submit" tabindex="2" class="btn btn-primary m-t-10" id="submit-btn" name="submit-btn">Submit</button><span class="spinner" style=" display: none"><i class="fa fa-refresh fa-spin fa-10x"></i></span>
                                                <button type="button" tabindex="3" class="btn btn-primary m-t-10" id="resetbtn" name="resetbtn" value="Reset">Reset</button>
                                        </center>
                                    </div>
                              
                                </div>
                                <br>
                            </div>
                        </div>
                   
                    <div class="col-md-3"></div>
                </div>
           
			<div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
            <div class="card card-secondary" style="margin-left: 15px; margin-right: 15px">
                                    <div class="card-header">Request Mode Details</div>
                                    <div class="card-body">
                <!--<input type="submit" class="btn btn-primary m-t-10" id="Run_Rule-btn" name="submit" value="Run Rule">-->
                <div id="eeeew">

                    <table class="table table1 table-striped"  id="datatype" >
                        <thead>
                            <tr>
                               <th>Sr No</th>
                                        <th>Edit</th>
                                        
                                        <th>Delete</th>
                                       
                                        
                                         <th>Company</th>
                                          <th>Request Mode</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>

                    </table>
                </div>

            </div>
        </div>
        </div>
        <div class="col-md-2"></div>
        </div>
         </section>
        </div>
        

<div class="row">

    <div class="modal fade bs-example-modal-lg modal-default1111" id="modelrequestmode1" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
       
          <div class="modal-dialog">
                            <div class="modal-content">
                 <div class="modal-header bg-secondary">
                  <h4 class="modal-title" id="myLargeModalLabel">Update Request Mode Master</h4>
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close" style="margin-right:10px">
                        <span aria-hidden="true">&times;</span>
                    </button>
                   
                    

                </div>
                <div class="modal-body">
                    <!--<form action="">-->
                    
                          <div class="row">
                        <div class="col-md-1"></div>
                            <div class="col-md-10">
                                   <label for="company" >Comapny </label>
                                        <div id="companyupdate1">
                                        <input type="text" id="companyupdate" class="form-control" data-toogle="tooltip"  disabled="disabled" tabindex="4">
                                        </div>
                            </div>

                       
                    </div>

                    <div class="row mt-2">
                        <div class="col-md-1"></div>
                            <div class="col-md-10">
                                   <label for="cno" >Request Mode</label>
                                        <div id="requestmodeupdate1">
                                        <input type="text" id="requestmodeupdate" class="form-control" data-toogle="tooltip"  placeholder="Please Enter Request Mode" tabindex="4">
                                        </div>
                            </div>

                       
                    </div>
                   </div>
                  

                    <div class="row">
                    <div class="col-md-12">
                    <input type="hidden" id="sr_no1" name="sr_no1" value=""/>
                        <center>
                            <input type="submit" class="btn btn-primary m-t-10" id="update_RequestMode_btn" name="update_RequestMode_btn" value="Update" tabindex="5">

                        </center>
                    </div>
				

                </div>
				<br>

            <!--</form>-->



        </div>

    </div>
    <!-- /.modal-content -->
</div>

<!-- /.modal-dialog -->
</div>
<!-- ./wrapper -->
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</div>
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/static//AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
 <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery/dist/jquery.min.js"></script>
 
 <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery-ui/jquery-ui.min.js"></script>
<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script> --%>
    
<%--   <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script> --%>
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
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script> -->
 <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
 <!--bootstrap datepicker--> 
<!--<script src="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>-->
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

 <!-- Sweetalert 2 -->
<script src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
<script src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>

 <!-- DataTables -->
<!--    <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net/js/jquery.dataTables.js"></script>
     <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net-bs/js/dataTables.bootstrap.js"></script>
     <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>-->
     
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
     
     
     <!--<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>-->
<!--<script src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>-->
<!--<script src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>-->
<!--<script src="../../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>-->
     
      <!--<script src="<%=request.getContextPath()%>/resources/Listing/dataTables.bootstrap.min.js"></script>-->
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/dataTables.buttons.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/jszip.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/vfs_fonts.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.html5.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.print.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.colVis.min.js"></script>   

  <script src="<%=request.getContextPath()%>/static/custom/RequestModemaster.js"></script>

</body>
     
</html>


