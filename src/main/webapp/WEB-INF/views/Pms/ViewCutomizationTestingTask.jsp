<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customization Task</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/fontawesome.min.css">

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
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
<!-- <script src="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css"></script>-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
	
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Datatables -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<!-- Daterange picker -->
<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
  
   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/Datepicker/css/bootstrap-datepicker.min.css"> --%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">

<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
  
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.css" type="text/css"/> --%>


<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
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
</style>



<script>
        <%
            String crno = request.getParameter("crno");
            System.out.println("crrrr" + crno);

            String role = (String) session.getAttribute("role");
            System.out.println("role in jsp" + role);

        %>
    </script>




</head>
<body class="hold-transition sidebar-mini layout-fixed">

	<input type="hidden" id="crnoo" name="crnoo" value="<%=crno%>">
	
	<input type="hidden" id="role" name="role" value="<%=role%>">


	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>

			<div style="padding-left: 15px; padding-right: 15px">

				<div class="card card-secondary border-secondary">

					<div class="card-header">
						<div class="row">
							<div class="col-md-4">Assigned Task Details &nbsp;&nbsp;&nbsp;&nbsp; <b>( Task Id : <span id="taskNo"></span>) </b></div>

							<div class="col-md-7"></div>

							<div class="col-md-1">
								<a href="<%=request.getContextPath()%>/Admin/MyCustomizationTestingTask">
									<i class="fa fa-backward pull-right" style="color: white">
								</i>
								</a>
							</div>
						</div>

					</div>


					<div class="card-body">
						<div class="row">

							
							
							
							<div style="margin-top: 15px;" class="col-md-4" id="DivCustomer" >
								<label for="customer_name">Customer Name : </label> <input type="text"
									data-toogle="tooltip" class="form-control" id="customer_name"
									name="customer_name" tabindex="1" placeholder="Enter Customer Name"
									readonly>
							</div>

							
							<div style="margin-top: 15px;" class="col-md-4" id="DivSuitName">
								<label for="suit_name">Product Suit Name : </label> <input type="text"
									data-toogle="tooltip" class="form-control" id="suit_name"
									name="suit_name" tabindex="1" placeholder="Enter Product Suit Name"
									readonly>
							</div>

							
							<div style="margin-top: 15px;" class="col-md-4" id="DivProductName">
								<label for="product_name">Product Tool Name : </label> <input type="text"
									data-toogle="tooltip" class="form-control" id="product_name"
									name="product_name" tabindex="1" placeholder="Enter Product Name"
									readonly>
							</div>
							
							
							<div style="margin-top: 15px;" class="col-md-4">
								<label for="Manager">Manager Name : </label> <input type="text"
									data-toogle="tooltip" class="form-control" id="Manager_Name"
									name="Manager_Name" tabindex="1" placeholder="Enter Module Name"
									readonly>
							</div>
							
							
							<div style="margin-top: 15px;" class="col-md-4">
								<label for="Team_Leader">Team Leader Name :</label> <input
									type="text" id="Team_Leader" tabindex="5"
									class="form-control form-control-sm" name="Team Leader"
									data-toogle="tooltip" placeholder="Enter Team Leader" readonly>

							</div>
							
							<div style="margin-top: 15px;" class="col-md-4">
								<label for="ReportedBy">Reported By :</label> <input
									type="text" id="ReportedBy" tabindex="5"
									class="form-control form-control-sm" name="ReportedBy"
									data-toogle="tooltip" placeholder="Reported By" readonly>

							</div>
							
							<div style="margin-top: 15px;" class="col-md-3">
								<label for="Developer">Developer :</label> <input
									type="text" id="Developer" tabindex="5"
									class="form-control form-control-sm" name="Developer"
									data-toogle="tooltip" placeholder="Developer Name"
									readonly="readonly">
							</div>

							
							<div style="margin-top: 15px;" class="col-md-3">
								<label for="End_Date">Expected Date :</label> <input type="text"
									id="End_Date" tabindex="5" class="form-control form-control-sm"
									name="End_Date" data-toogle="tooltip" readonly>
							</div>
							
							<div style="margin-top: 15px;" class="col-md-3">
								<label for="reportedDate">Planned Date :</label> <input type="text"
									id="reportedDate" tabindex="5"
									class="form-control form-control-sm" name="reportedDate"
									data-toogle="tooltip" readonly="readonly">
							</div>


							<div style="margin-top: 15px;" class="col-md-3">
								<label for="Task_Priority">Task Priority :</label> <input type="text"
									id="Task_Priority" tabindex="5" class="form-control form-control-sm"
									name="Task_Priority" data-toogle="tooltip" readonly="readonly">
							</div>
						</div>
						
						<div class="row">
						
						<div style="margin-top: 15px;" class="col-md-4">
								<label for="Module">Module Name : </label> <textarea 
									data-toogle="tooltip" class="form-control" id="Module_Name"
									name="Module_Name" tabindex="1" placeholder="Module Name" style="height: 90px;"
									readonly> </textarea>
							</div>
							<div class="col-md-4 mt-3">
								<label for="">Customization /Issue/Bug/Challenges :</label>
								<textarea id="Description" tabindex="1" class="form-control"
									name="Description" data-toggle="tooltip"
									placeholder="Customization /Issue/Bug/Challenges" readonly style="height: 90px;"></textarea>
							</div>
							
							<div class="col-md-4 mt-3">
								<label for="">Expected Output :</label>
								<textarea id="ExpectedOutput" tabindex="1" class="form-control"
									name="ExpectedOutput" data-toggle="tooltip"
									placeholder="Expected Output" readonly style="height: 90px;"></textarea>
							</div>
							
							<div class="col-md-3 mt-3" id="testerDescDiv"  margin-top: 15px;">
								<label for="">Description for Tester :</label>
								<textarea id="testerDescription" tabindex="1" class="form-control"
									name="testerDescription" data-toggle="tooltip"
									placeholder="Tester Description" style="height: 90px;" readonly></textarea>
							</div>
							
							<div class="col-md-3" id="testerDiv" style=" margin-top: 15px;" >
										<label for="rtype">Tester :</label> <input id="testerName"
											class="form-control form-control-sm" data-toggle="tooltip"
											name="testerName" readonly>
									</div>
									
									<div style="margin-top: 15px;" class="col-md-3">
								<label for="assignedForTestingDate">Assigned For Testing Date :</label> <input type="text"
									id="assignedForTestingDate" tabindex="5" class="form-control form-control-sm"
									name="assignedForTestingDate" data-toogle="tooltip" readonly>
							</div>
							
							<div style="margin-top: 15px;" class="col-md-3">
								<label for="Status">Status :</label> <select id="Status"
									tabindex="5" class="form-control form-control-sm" name="Status"
									data-toggle="tooltip"  onchange="changeStatus(this.value)">
									<option value="">-- Please Select --</option>
									<option value="Developed">Developed</option>
									<option value="Tested">Pass</option>
									<option value="Assigned">Fail</option>

								</select>
							</div>
							
							
									
									
							
							
<!-- 							<div style="margin-top: 15px;" class="col-md-4"> -->
<!-- 								<label for="Remark">Remark :</label> <input type="text" -->
<!-- 									id="Remark" tabindex="5" class="form-control form-control-sm" -->
<!-- 									name="Remark" data-toogle="tooltip" placeholder="Enter Remark"> -->
<!-- 							</div> -->
							</div>
							

						

						<div class="row"></div><br>

						<div style="margin-top: 15px;" class="col-md-12">
							<center>
<!-- 								                                                                                           <input type="submit" tabindex="8" class="btn btn-primary m-t-10" id="submit-btnnn"  name="submit" value="Submit"> <span class="spinner" style=" display: none"><i class="fa fa-refresh fa-spin fa-10x"></i></span> -->
								<button type="submit" tabindex="8"
									class="btn btn-primary m-t-10" id="updateTask"
									name="updateTask" data-style="expand-left" onclick="updateTaskStatus()">
									Submit &nbsp;<span class="spinner-border"
										style="width: 1rem; height: 1rem; display: none;" id="spin1"></span>
								</button>
								
<!-- 								<button type="submit" tabindex="8" -->
<!-- 									class="btn btn-secondary m-t-10" id="modifyDate" -->
<!-- 									name="modifyDate" data-style="expand-left" onclick="updateModifyDate()"> -->
<!-- 									Modify Date &nbsp;<span class="spinner-border" -->
<!-- 										style="width: 1rem; height: 1rem; display: none;" id="spin2"><i -->
<!-- 										class="fa fa-refresh fa-spin fa-10x"></i></span> -->
<!-- 								</button> -->
								
							</center>
						</div>
					</div>
				</div>
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
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.js"></script>
<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	
	<%-- <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.js"></script>
    
   <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.min.js"></script>

<script src="<%=request.getContextPath()%>/static/Datepicker/js/bootstrap-datepicker.min.js"></script> --%>

	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/viewCutomizationTestingTask.js"></script>
		
			<script>
//  		$('#End_Date').datepicker({
//  			autoclose : true,
//  			format : 'dd.mm.yyyy',
//  			todayHighlight : !0,
//  			orientation : "bottom",
//  		}).on('change', function() {

//  		});

  	</script> 

</body>
</html>