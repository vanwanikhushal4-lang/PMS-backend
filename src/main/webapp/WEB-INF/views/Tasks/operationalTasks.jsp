<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee's Tasks</title>
 <link rel="icon" href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/adminlte/bower_components/bootstrap/dist/css/bootstrap.min.css"> --%>
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
 <%--  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css"> --%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">

<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">

 <link rel="stylesheet" href="<%=request.getContextPath()%>/static/adminlte/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css">

 <link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
 --%>
 
  <style type="text/css">
  .card{
  border: 1px solid rgb(0, 123, 255) !important;
  }
  
   body
     {
     font-size:85% !important;
     } 
     
     
/*      table style */

/* Force fixed layout and truncation */
#CMApprByMeTable,
#CMApprByMeTable.dataTable,
.dataTables_scrollHead table,
.dataTables_scrollBody table {
  table-layout: fixed !important;
  width: 100% !important;
  box-sizing: border-box !important;
}

#CMApprByMeTable th,
#CMApprByMeTable td,
.dataTables_scrollHead th {
  white-space: nowrap !important;
  overflow: hidden !important;
  text-overflow: ellipsis !important;
  box-sizing: border-box !important;
}

/* small padding so first column won't expand because of padding */
#CMApprByMeTable th:nth-child(1),
#CMApprByMeTable td:nth-child(1),
.dataTables_scrollHead th:nth-child(1) {
  padding-left: 4px !important;
  padding-right: 4px !important;
  text-align: center;
}

     
     
     
  </style>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
           <jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
                <div class="content-wrapper">
            <section class="content-header">
               
                  
            </section>
<div style="padding-left:15px; padding-right: 15px">
            <div class="card card-secondary border-secondary">
               <div class="card-header">Operational Tasks </div>
                                    <div class="card-body">

                <div id="eeeew">

                    <table class="table table1 table-striped"  id="CMApprByMeTable" >
                        <thead>
                            <tr>    
                                         <th>Task ID</th>                                        
                                        <th>Module Name</th>
                                        <th>Assigned To</th>
                                        <th>Team Leader</th>                                   
                                        <th>Task Assigned By</th>
										<th>Start Date</th>
										<th>End Date</th>
										<th>Description</th>
										<th>Status</th>  
										
                                        

                            </tr>
                        </thead>
                        <tbody>

                        </tbody>

                    </table>
                    <span
								style="width: 5rem; height: 5rem; margin-left: 45%; display: none;"
								id="spin12"><i class="fa fa-spinner fa-spin"
								style="font-size: 33px"></i></span>
                </div>

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


 <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
    
  <script src="<%=request.getContextPath()%>/static/resources/Bootstrap/bootstrap.min.js"></script> 
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


<!-- Sweetalert 2 -->
<script src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
<script src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>

 
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
     
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

<script src="<%=request.getContextPath()%>/static/resources1/Listing/vfs_fonts.js"></script>
  <!-- Bootstrap 4 -->
	 <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	 
	
	  <script src="<%=request.getContextPath()%>/static/custom/operationalTasks.js"></script> 


<script>



</script>
</body>
</html>