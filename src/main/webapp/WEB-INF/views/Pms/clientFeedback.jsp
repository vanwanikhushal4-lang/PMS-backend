<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Provide Feedback</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
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

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/adminlte/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.css">

<%--  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css"> --%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
<!-- <script src="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css"></script>-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">


<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

body {
	font-size: 85% !important;
}
</style>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<section class="content-header"></section>
			<div style="padding-left: 200px; padding-right: 200px">
				<div class="card card-secondary border-secondary">
					<div class="card-header">Grievance and Complaints</div>
					<div class="card-body">

								<div class="row">
									<div class="form-group col-md-6">
			                <label for="clientName">Client Name</label>
			                <input type="text" class="form-control" id="clientName" placeholder="Enter client name" required>
			            </div>
			
			            <div class="form-group col-md-6">
			                <label for="projectName">Project Name/ID</label>
			                <input type="text" class="form-control" id="projectName" placeholder="Enter project name or ID" required>
			            </div>
			            </div>
			
						<div class="row">
			            <div class="form-group col-md-6">
			                <label for="dateOfFeedback">Date of Feedback</label>
			                <input type="date" class="form-control" id="dateOfFeedback" required>
			            </div>
			
			            <div class="form-group col-md-6">
			                <label for="feedbackType">Type of Feedback</label>
			                <select class="form-control" id="feedbackType" required>
			                    <option value="" disabled selected>Select feedback type</option>
			                    <option value="complaint">Complaint</option>
			                    <option value="suggestion">Suggestion</option>
			                    <option value="praise">Praise</option>
			                </select>
			            </div>
			            </div>
			
						<div class="row">
			            <div class="form-group col-md-6">
			                <label for="feedbackDescription">Feedback Description</label>
			                <textarea class="form-control" id="feedbackDescription" rows="4" placeholder="Enter detailed feedback here..." required></textarea>
			            </div>
			
			            <div class="form-group col-md-6">
			                <label for="impactAssessment">Impact Assessment</label>
			                <select class="form-control" id="impactAssessment" required>
			                    <option value="" disabled selected>Select impact level</option>
			                    <option value="low">Low</option>
			                    <option value="medium">Medium</option>
			                    <option value="high">High</option>
			                </select>
			            </div>
			            </div>
			
						
			
						<div class="row">
<!-- 			            <div class="form-group col-md-6"> -->
<!-- 			                <label for="supportingDocuments">Supporting Documents</label> -->
<!-- 			                <input type="file" class="form-control-file" id="supportingDocuments"> -->
<!-- 			            </div> -->
			
			            <div class="form-group col-md-6">
			                <label for="statusOfGrievance">Status of Grievance</label>
			                <select class="form-control" id="statusOfGrievance" required>
			                    <option value="" disabled selected>Select current status</option>
			                    <option value="pending">Pending</option>
			                    <option value="inReview">In Review</option>
			                    <option value="resolved">Resolved</option>
			                </select>
			            </div>
			            
			            <div class="form-group col-md-6">
			                <label for="assignedTo">Assigned To</label>
			                <input type="text" class="form-control" id="assignedTo" placeholder="Enter the name of the person responsible" required>
			            </div>
			            </div>
			
						<div class="row">
			            
			
			            <div class="form-group col-md-6">
			                <label for="resolutionDescription">Resolution Description</label>
			                <textarea class="form-control" id="resolutionDescription" rows="3" placeholder="Describe how the grievance was resolved (if applicable)"></textarea>
			            </div>
			            
			            <div class="form-group col-md-6">
			                <label for="followUpDate">Follow-Up Date</label>
			                <input type="date" class="form-control" id="followUpDate"  pattern="\d{2}-\d{2}-\d{4}" placeholder="DD-MM-YYYY" >
			                <small>Format: DD-MM-YYYY</small>
			            </div>
			            </div>
			
						<div class="row">
			            
			
			            <div class="form-group col-md-6">
			                <label for="clientResponse">Client Response</label>
			                <textarea class="form-control" id="clientResponse" rows="3" placeholder="Enter any follow-up feedback from the client"></textarea>
			            </div>
			            </div>
			
			            <button type="submit" class="btn btn-primary" onclick="saveClientFeedback1()">Submit Feedback</button>

		            </div>
		            <br>
		
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

	<script
		src="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
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
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.js"></script>
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script> -->
	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/clientFeedback.js"></script>



</body>
</html>