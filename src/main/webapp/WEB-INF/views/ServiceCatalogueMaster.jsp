<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Service Catalogue Master</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
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
  <!-- Select2 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">
<!-- summernote -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
<style type="text/css">
.card {
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
			<br><br>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						
						<div class="card card-secondary">
							<div class="card-header">Service Catalogue Master</div>
							<div class="card-body">
							<div class="row">
									<div class="col-md-1"></div>
									<div class="col-md-5">
			                  <label>Company</label>
<!-- 			                  <div class="form-group" id="categoryProblemDiv"> -->
			                 <select id="cname" class="form-control" tabindex="6" data-toogle="tooltip"  onchange="getcompanyforgroup(this.value)"  name="cname">
										<option value="">--Please Select--</option>
											
											</select>
<!-- 								</div> -->
								</div>
								
										<div class="col-md-5">
			                  <label>Category</label>
			                  <div class="form-group" id="categoryProblemDiv">
			                  <select class="form-control select2" id="category">
								</select>
								</div>
								</div>
							<div class="col-md-1"></div> 
								</div>
							
								
								<div class="row">
									<div class="col-md-1"></div>
									<div class="col-md-5">
			                  <label>Sub-Category 1</label>
			                  <div class="form-group" id="subcategory1Div">
			                  <select class="form-control select2" id="subcategory1">
								</select>
								</div>
								</div>
											<div class="col-md-5">
			                  <label>Sub-Category 2</label>
			                  <div class="form-group" id="subcategory2Div">
			                  <select class="form-control select2" id="subcategory2">
								</select>
								</div>
								</div>
								<div class="col-md-1"></div>
								</div>
								
								
								<div class="row">
									<div class="col-md-1"></div>
									<div class="col-md-5">
			                  <label>Priority</label>
			                  <div class="form-group" id="priorityDiv">
			                  <select class="form-control select2" id="priority">
								</select>
								</div>
								</div>
										<div class="col-md-5">
			                  <label>Severity</label>
			                  <div class="form-group" id="severityDiv">
			                  <select class="form-control select2" id="severity">
								</select>
								</div>
								</div>
								<div class="col-md-1"></div>
								</div>
							
								<div class="row">
									<div class="col-md-1"></div>
									<div class="col-md-5">
			                  <label>Subject</label>
			                  <div class="form-group" id="subjectDiv">
			                  <select class="form-control select2" id="subject">
								</select>
								</div>
								</div>
										<div class="col-md-5">
			                  <label>Group</label>
			                  <div class="form-group" id="groupDiv">
			                  <select class="form-control" id="groupselect">
			                  	<option value="">-- Please Select --</option>
								</select>
								</div>
								
								</div>
								<div class="col-md-1"></div>
								</div>
										
								<div class="row">
									<div class="col-md-1"></div>
									
											<div class="col-md-5">
											
											<label for="requestcost"> Cost(Optional)</label>
			                  <div class="form-group"id="requestcostdiv">
			                  <input type="text"  placeholder="Please Enter Cost"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');" class="form-control" id="requestcost" />
			                  
											</div>
					</div>
												<div class="col-md-5">
			                  <label>Service Request</label>
			                  <div class="form-group" id="servicestandarddiv">
			                  <select class="form-control" id="servicestandard" onchange="getstandard(this.value)">
			                     <option value="">-- Please Select --</option>
			                      <option value="Non Standard">Non Standard</option>
			                  <option value="Standard">Standard</option>
			                   
								</select>
								</div>
								</div>
								<div class="col-md-1"></div>
								</div>
									
								<div class="row">
											<div class="col-md-1"></div>
										<div class="col-md-5">
										
										   <label for="SUBJECT_TYPEf">SUBJECT_TYPE</label>
			                 
			                  <select class="form-control"  id="SUBJECT_TYPE" name="SUBJECT_TYPE">
			                  <option value="NA">--Please Select--</option>
			                  	<option value="Admin">Admin Request</option>
			                  	<option value="Hr">HR Request</option>
			                  	<option value= "IT">IT Request</option>
								</select>
										
										
										<div class="col-md-6"></div>
								</div>
								</div>
								   <hr id="hrid" style="display: none;">
								   
								   			 <label style="display: none;" id="matrixlable">Approve Matrix</label>
									<div class="row">
								
										<div class="col-md-1"></div>
										
									<div class="col-md-2" id="levelonedive" style="display: none;">
										         <label for="levelone">Level 1</label>
										         <input type="checkbox" value="levelone" class="levelone" id="levelone">
			                  
								</div>
								<div class="col-md-5"style="display: none;" id="desig1">
			                  <label for="Designarionlevel1">Designation Level 1</label>
			                   <div class="form-group" id="Designarion1div">
			                  <select class="form-control" id="Designarionlevel1">
			                  	<option value="">--Please Select--</option>
								</select>
							</div>
								
								</div>
								
									<div class="col-md-4"></div>
									</div>
									
								<div class="row ">
								<div class="col-md-1 "></div>
											<div class="col-md-2" id="leveltwodiv" style="display: none;">
										         <label for="leveltwo">Level 2</label>
										         <input type="checkbox" value="leveltwo" class="leveltwo" id="leveltwo">
										         </div>
									<div class="col-md-5" id="desig2" style="display: none;" >
			                  <label>Designarion Level 2</label>
			                  <div class="form-group" id="Designarion2div">
			                  <select class="form-control" id="Designarionlevel2">
			                  	<option value="">--Please Select--</option>
								</select>
								</div>
								
								
							
										         		
										         
			                  
								</div>
								<div class="col-md-4"></div>
								</div>
									
								
								<br>

								<div class="row">
									<div class="col-md-12 text-center">
									<div style="margin-top: 15px;" class="col-md-12">
										<button type="submit" tabindex="2" class="btn btn-primary m-t-10" id="submit-btn" name="submit-btn">Submit</button>
											<span class="spinner" style="display: none">
											<i class="fa fa-refresh fa-spin fa-10x"></i>subcategory1Div
											</span>
											
											<button type="button" tabindex="3" class="btn btn-primary m-t-10" id="resetbtn" name="resetbtn" value="Reset">Reset</button>
										
									</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>



				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="card card-secondary"
							style="margin-left: 15px; margin-right: 15px">
							<div class="card-header">Service Catalogue Details</div>
							<div class="card-body">
								<!--<input type="submit" class="btn btn-primary m-t-10" id="Run_Rule-btn" name="submit" value="Run Rule">-->
								<div id="eeeew">

									<table class="table table1 table-striped" id="datatype">
										<thead>
											<tr>
												<th>Sr No</th>
												<th>Edit</th>
												<th>Delete</th>
												<th>Company</th>
												<th>Category</th>
												<th>Sub Category 1</th>
												<th>Sub Category 2</th>
												<th>Priority</th>
												<th>Severity</th>
												<th>Subject</th>
												<th>Request Type</th>
												<th>Approval Level</th>
												<th>Group Name</th>
												<th>Level One Designarion</th>
												<th>Level Two Designarion</th>
												<th>Request Cost</th>
												<th>Subject Type</th>
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

<div class="row">

			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modelcategory1" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Update
							Service Catalogue Master</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px">
								<span aria-hidden="true">&times;</span>
							</button>



						</div>
						<div class="modal-body">
							<!--<form action="">-->

							<div class="row">
								
								<div class="col-md-6">
									<label for="cno">Company</label> <input type="text"
										id="cupdate" class="form-control" onchange="getcompanyforgroup(this.value)"
										data-toogle="tooltip" style="margin-left: 0%;" readonly
										placeholder="Please Enter Company Name">
								</div>
								<div class="col-md-6">
									<label for="cno">Category</label> 
									<div   class="form-group" id="categorydiv1upda"> <select
										id="categorynameupdate" class="form-control select2"
									
										></select></div>
								</div>

							</div>
							<div class="row">
									
									<div class="col-md-6">
			                  <label>Sub-Category 1</label>
			                  <div class="form-group" id="subcategory1Divupda">
			                  <select class="form-control select2" id="subcategory1up">
								</select>
								</div>
								</div>
											<div class="col-md-6">
			                  <label>Sub-Category 2</label>
			                  <div class="form-group" id="subcategory2Divupda">
			                  <select class="form-control select2" id="subcategory2up">
								</select>
								</div>
								</div>
								
								</div>
								
								
								<div class="row">
								
									<div class="col-md-6">
			                  <label>Priority</label>
			                  <div class="form-group" id="priorityDivupda">
			                  <select class="form-control select2" id="priorityup">
								</select>
								</div>
								</div>
										<div class="col-md-6">
			                  <label>Severity</label>
			                  <div class="form-group" id="severityDivupda">
			                  <select class="form-control select2" id="severityup">
								</select>
								</div>
								</div>
							
								</div>
							
								<div class="row">
									
									<div class="col-md-6">
			                  <label>Subject</label>
			                  <div class="form-group" id="subjectDivup">
			                  <select class="form-control select2" id="subjectup">
								</select>
								</div>
								</div>
										<div class="col-md-6">
			                  <label>Group</label>
			                  <div class="form-group" id="groupDiv">
			                  <select class="form-control" id="groupselectup">
			                  	<option value="">--Please Select--</option>
								</select>
								</div>
								
								</div>
								
								</div>
										
								<div class="row">
									<div class="col-md-6">
											
											<label for="requestcost"> Cost(Optional)</label>
			                  <div class="form-group"id="requestcostdiv">
			                  <input type="text"  placeholder="Enter Cost"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*?)\..*/g, '$1');" class="form-control" id="requestcostup" />
			                  
											</div>
					</div>
												<div class="col-md-6">
			                  <label>Service Request</label>
			                  <div class="form-group" id="servicestandarddiv">
			                  <select class="form-control" id="servicestandard1" onchange="serviceType(this.value)">
			                     <option value="">-- Please Select --</option>
			                     <option value="Non Standard">Non Standard</option>
			                  <option value="Standard">Standard</option>
			                    
								</select>
								</div>
								</div>
							
								</div>
								   <hr id="hrid" style="display: none;">
								   
								   			 <label style="display: none;" id="matrixlable1">Approve Matrix</label>
									<div class="row">
								
										<div class="col-md-1"></div>
										
									<div class="col-md-2" id="level1Div" style="display: none;">
										         <label for="level1">Level 1</label>
										         <input type="checkbox" value="level1" class="level1" id="level1">
			                  
								</div>
								<div class="col-md-5"style="display: none;" id="desig11">
			                  <label for="Designarionlevel1">Designation Level 1</label>
			                   <div class="form-group" id="Designarion1div">
			                  <select class="form-control" id="Designationl1">
			                  	<option value="">--Please Select--</option>
								</select>
							</div>
								
								</div>
								
									<div class="col-md-4"></div>
									</div>
									
								<div class="row ">
								<div class="col-md-1 "></div>
											<div class="col-md-2" id="level2Div" style="display: none;">
										         <label for="level2">Level 2</label>
										         <input type="checkbox" value="level2" class="level2" id="level2">
										         </div>
									<div class="col-md-5" id="desig22" style="display: none;" >
			                  <label>Designarion Level 2</label>
			                  <div class="form-group" id="Designarion2div">
			                  <select class="form-control" id="Designationl2">
			                  	<option value="">--Please Select--</option>
								</select>
								</div>
								
								
							
										         		
										         
			                  
								</div>
								<div class="col-md-4"></div>
								</div>
									
								
								<br>

							<div class="row">

								<div class="col-md-6">
									<label>Subject Type</label>
									<div class="form-group" id="subjecttype">
										<select class="form-control select2" id="subjecttypeup">
											<option value="NA">Please Select</option>
											<option value= "Hr">Hr</option>
											<option value= "Admin">Admin</option>
											<option value= "IT">IT</option>
										</select>
									</div>
								</div>
							</div>
							<br>


							<input type="hidden" id="sr_no1" name="sr_no1" value="" /> <br>

							<div class="row">
								<div class="col-md-12">
									<center>
										<input type="submit" class="btn btn-primary m-t-10"
											id="update_service_request-btn"
											name="update_service_request-btn" value="Update">

									</center>
								</div>
							</div>

						</div>

						<div class="col-md-2"></div>
					</div>

					<!--</form>-->



				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
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
		
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>
		
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
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.print.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.colVis.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/ServiceCatalogueMaster.js"></script>

</body>

</html>


