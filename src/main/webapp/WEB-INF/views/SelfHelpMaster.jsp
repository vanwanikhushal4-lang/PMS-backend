<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Self Help Portal Master</title>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">
<!-- summernote -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css" type="text/css"/>
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
				<br>
				<br>
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">

						<div class="card card-secondary">
							<div class="card-header">Self Help Portal Master</div>
							<div class="card-body">
								<form action="addSelfHelpMaster" id="form" name="form" method="post" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-6">
										<label for="cname">Company</label>
										<select id="cname" class="form-control"
											data-toogle="tooltip" name="cname" onchange="getBranchDetails(this.value);">
											<option value="">-- Please Select Company Name --</option>

										</select>
									</div>
									<div class="col-md-6">
										<label for="branch">Branch</label>
										<div id="branchDiv">
											<select id="branch" class="form-control"
												data-toogle="tooltip" name="branch" multiple="multiple" onchange="getDeptDetails();">
	
											</select>
										</div>
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-md-6">
										<label for="department">Department</label>
										<div id="departmentDiv">
											<select id="department" class="form-control" tabindex="6"
												data-toogle="tooltip" name="department" multiple="multiple">
	
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<label for="name">Product Name</label>
										<input type="text" id="name" name="name" placeholder="Please Enter Attachment Name" class="form-control">
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-md-6">
										<label for="description">Description</label>
										<textarea rows="3" cols="50" class='form-control' data-toogle='tooltip' id="description" name="description" 
										placeholder="Please Enter Description"></textarea>
									</div>
									<div class="col-md-6">
										<label for="category">Category</label>
										<div id="categoryDiv">
											<select id="category" class="form-control select2" tabindex="6"
												data-toogle="tooltip" name="category">
	
											</select>
										</div>
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-md-6">
										<label for="platform">Platform</label>
										<div id="platformDiv">
											<select id="platform" class="form-control select2" tabindex="6"
												data-toogle="tooltip" name="platform">
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<label>Browse File</label>
										<div> <input type="file" id="empPic"
										name="empPic"></div>
									</div>
								</div>

								<div class="row">

									<div style="margin-top: 15px;" class="col-md-12 text-center">
										<button type="submit" tabindex="2"
											class="btn btn-primary m-t-10" id="submit-btn"
											name="submit-btn">Submit
											<span class="spinner" style="display: none"><i
												class="fa fa-refresh fa-spin fa-10x"></i></span>
										</button>
										<button type="button" tabindex="3"
											class="btn btn-primary m-t-10" id="resetbtn" name="resetbtn"
											value="Reset">Reset</button>
									</div>
								</div>
								</form>
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
							<div class="card-header">Self Help Portal Details</div>
							<div class="card-body">
								<div id="eeeew">

									<table class="table table1 table-striped" id="datatype">
										<thead>
											<tr>
												<th>Details</th>
												<th>Edit</th>
												<th>Name</th>  
		                                        <th>Category</th>
		                                        <th>Platform</th>
		                                        <th>Company</th>
		                                        <th>Branch</th>
		                                        <th>Department</th>
		                                        <th>Uploaded By</th>
		                                        <th>Uploaded On</th>
		                                        <th>Total Downloads</th>
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
				id="modaldescription" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Details</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px">
								<span aria-hidden="true">&times;</span>
							</button>



						</div>
						<div class="modal-body">

							<div class="row">
								<div class="col-md-12">
									<label for="descriptionupdateTD1">Description</label>
									<textarea id="descriptionupdateTD" rows="8" cols="50"
										name="descriptionupdateTD" class="form-control"
										data-toogle="tooltip" readonly></textarea>
								</div>
							</div>
							<br>
							<hr>
							<div id="hidedownload">
								<div class="row">
									<div class="col-md-10">

										<label>File Attached&nbsp;&nbsp; <input type="hidden"
											id="empPic">&nbsp;&nbsp; <input type="button"
											id="downHide" value="Download" onclick="downFile()">
										</label>
										<!--                                         <label>Attachment:&nbsp;&nbsp;<span style="color: green;" id="empPic"></span>&nbsp;&nbsp;<input type="button" id="downHide" value="Download" onclick="downFile()"></label>-->
										<input type="hidden" id="filename" name="filename">
									</div>
								</div>
							</div>

							<input type="hidden" id="sr_no1" name="sr_no1" value="" /> <br>

						</div>

						<div class="col-md-2"></div>
					</div>

					<!--</form>-->



				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		
		<!-- Edit Modal -->
		<div class="row">

			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modaledit" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Edit Self Help Portal Details</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px">
								<span aria-hidden="true">&times;</span>
							</button>



						</div>
						<div class="modal-body">
							<form action="updateSelfHelpMaster" id="updateform" name="updateform"
								method="post" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-6">
										<label for="cnameupdate">Company</label>
										<input type="text" id="cnameupdate"
											class="form-control" name="cnameupdate" readonly>
									</div>
									<div class="col-md-6">
										<label for="branchupdate">Branch </label>
										<div id="branchupdateDiv">
											<input type="text" id="branchupdate"
											class="form-control" name="branchupdate" readonly>
										</div>
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-md-6">
										<label for="departmentupdate">Department</label>
										<div id="departmentupdateDiv">
											<input type="text" id="departmentupdate"
											class="form-control" name="departmentupdate" readonly>
										</div>
									</div>
									<div class="col-md-6">
										<label for="nameupdate">Name</label> <input type="text" id="nameupdate"
											name="nameupdate" placeholder="Please Enter Name"
											class="form-control">
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-md-6">
										<label for="descriptionupdate">Description</label>
										<textarea rows="3" cols="50" class='form-control'
											data-toogle='tooltip' id="descriptionupdate" name="descriptionupdate"
											placeholder="Please Enter Description"></textarea>
									</div>
									<div class="col-md-6">
										<label for="categoryupdate">Category</label>
										<div id="categoryupdateDiv">
											<select id="categoryupdate" class="form-control select2"
												tabindex="6" data-toogle="tooltip" name="categoryupdate">

											</select>
										</div>
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-md-6">
										<label for="platformupdate">Platform</label>
										<div id="platformupdateDiv">
											<select id="platformupdate" class="form-control select2"
												tabindex="6" data-toogle="tooltip" name="platformupdate">
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<label>Browse File</label>
										 <div><input type="file" id="empPic1"
											name="empPic1">
											<i class="nav-icon fas fa-trash" onclick="$('#empPic1').val('').trigger('change');"></i>
										</div>
									</div>
								</div>

								<div class="row">

									<div style="margin-top: 15px;" class="col-md-12 text-center">
										<button type="submit" tabindex="2"
											class="btn btn-primary m-t-10" id="update-btn"
											name="update-btn">
											Update <span class="spinner" style="display: none"><i
												class="fa fa-refresh fa-spin fa-10x"></i></span>
										</button>
										<button type="button" tabindex="3"
											class="btn btn-primary m-t-10" id="resetupdatebtn" name="resetupdatebtn"
											value="Reset">Reset</button>
									</div>
								</div>
								<input type="hidden" id="sr_no2" name="sr_no2" value="" /> <br>
							</form>


						</div>

						<div class="col-md-2"></div>
					</div>

					<!--</form>-->



				</div>

			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
		<!-- Edit Modal End -->
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

	<script src="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/js/bootstrap-multiselect.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>

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
		src="<%=request.getContextPath()%>/static/custom/selfhelpmaster.js"></script>

</body>

</html>


