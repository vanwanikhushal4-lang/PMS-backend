<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Customization Task</title>
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
		<link rel="stylesheet" href="https://cdn.datatables.net/2.1.8/css/dataTables.dataTables.min.css">
	
	
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

body {
	font-size: 85% !important;
}


/*  #productdata th, #productdata td { */
/*         min-width: 80px;  /* Set a minimum width for the columns */ */
/*         text-overflow: ellipsis;  /* Adds ellipsis if content overflows */ */
/*         white-space: nowrap;  /* Prevent content from wrapping */ */
/*         overflow: hidden;  /* Hide overflow content */ */
/*     } */

/*     /* Optional: Make the headers narrower by default */ */
/*     #productdata th { */
/*         max-width: 200px;  /* Set a maximum width to avoid headers from expanding too much */ */
/*     } */
    
    
    
    
  
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
    transition: background-color 0.3s, transform 0.2s; /* Smooth transitions */
}

/* Hover effect for the button */
.dt-button:hover {
    background-color: #0056b3; /* Darker blue on hover */
    transform: scale(1.05); /* Slightly enlarge button on hover */
}

/* Focus effect for the button (when clicked or selected) */
.dt-button:focus {
    outline: none; /* Remove the default focus outline */
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5); /* Add a blue glow when focused */
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
    transition: background-color 0.3s, transform 0.2s; /* Smooth transitions */
}

/* Hover effect for the button */
.dt-button:hover {
    background-color: #0056b3; /* Darker blue on hover */
    transform: scale(1.05); /* Slightly enlarge button on hover */
}

/* Focus effect for the button (when clicked or selected) */
.dt-button:focus {
    outline: none; /* Remove the default focus outline */
    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5); /* Add a blue glow when focused */
}
    

</style>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<%
	HttpSession htt = request.getSession(true);
	 String role = (String) htt.getAttribute("role");
%>

	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<input type="hidden" id="role" name="role" value="<%=role%>">
		<input type="hidden" id="sr_no1" name="sr_no1" /> 
		<input type="hidden" id="customerName" name="customerName" />
		<input type="hidden" id="moduleName" name="moduleName" />
		<input type="hidden" id="descriptions" name="descriptions" />
		<input type="hidden" id="expectedOut" name="expectedOut" />
		
		
		<div class="content-wrapper">
			<section class="content-header"></section>
			<div style="padding-left: 15px; padding-right: 15px">
				<div class="card card-secondary border-secondary">
					<div class="card-header">Self Task</div>
					<div class="card-body">

						<div id="DelayTableDiv" style="width: 100%; overflow-x: auto;">

							<table class="table" id="DevDelaysTableDetails">
								<thead>
    <tr>

        <th>SR_NO</th>

        <th>DEVELOPER_NAME</th>

        <th>FUNCTION_NAME</th>

        <th>END_DATE</th>

        <th>MANAGER_NAME</th>

        <th>MODULE_NAME</th>

        <th>REMARK</th>

        <th>RESPONSIBILITY</th>

        <th>START_DATE</th>

        <th>STATUS</th>

        <th>TEAM_LEADER</th>

        <th>CUSTOMERNAME</th>

        <th>DESCRIPTION</th>

        <th>PRIORITY</th>

        <th>PRODUCTSUIT</th>

        <th>PRODUCTTOOL</th>

        <th>SUB_MODULE_NAME</th>

        <th>WEIGHTAGE</th>

        <th>ASSIGNBY</th>

        <th>TESTER_NAME</th>

        <th>Assign_date</th>

        <th>TaskUpdateDate</th>

        <th>Task_ID</th>

        <th>dateUpdateBy</th>

        <th>updateDateCount</th>

        <th>updateDate_Status</th>

        <th>updateEnd_Date</th>

        <th>updateTimeDate</th>

        <th>updateDates_Reason</th>

        <th>updateStarts_Date</th>

        <th>ONE_TIME</th>

        <th>REQUESTED_DATE_REVISE</th>

        <th>Assign_time</th>


    </tr>
</thead>
								<tbody>

								</tbody>
							</table>
							<span
								style="width: 5rem; height: 5rem; margin-left: 49%; display: none;"
								id="spin12"><i class="fa fa-spinner fa-spin"
								style="font-size: 33px"></i></span>
						</div>





						<div style="margin-top: 25px;" class="col-md-12">
							<center>

								<button type="submit" tabindex="8"
									class="btn btn-primary m-t-10" id="sub" name="submit"
									data-style="expand-left" onclick="reassignTask()" style="display: none;">
									Assign Task &nbsp;<span class="spinner-border"
										style="width: 1rem; height: 1rem; display: none;" id="spin2"></span>
								</button>
<!-- 								<button type="reset" tabindex="8" -->
<!-- 									class="btn btn-secondary m-t-10" id="Reset" name="Reset" -->
<!-- 									onclick="ResetData();">Reset</button> -->
							</center>
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
	
	<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>

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
	<script
		src="<%=request.getContextPath()%>/static/custom/AssignedTasksBySelf.js"></script>


	<script>
$('#enddatedd').datepicker({
	autoclose : true,
	format : 'dd.mm.yyyy',
	todayHighlight : !0,
	orientation : "bottom",
}).on('change', function() {
});   

$('#plannedDate2').datepicker({
	autoclose : true,
	format : 'dd-mm-yyyy',
	todayHighlight : !0,
	orientation : "bottom",
}).on('change', function() {	
}); 

</script>
</body>
</html>