<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Auto Closed Tickets</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources1/bowercomponents/Ionicons/css/ionicons.min.css">

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

<%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/multiselect/bootstrap-multiselect.css" type="text/css"/> --%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css"
	type="text/css" />

<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}
/*    .multiselect-clear-filter:after { */
/*   content: "\f057"; */
/*   font-family: 'Font Awesome\ 5 Free'; */
/*   } */
.table-condensed .prev:after {
	content: "\f060";
	font-family: 'Font Awesome\ 5 Free';
}

.table-condensed .next:after {
	content: "\f061";
	font-family: 'Font Awesome\ 5 Free';
}

label {
	padding: 3px 0px 0px 14px !important;
}
/*   .fa-circle{ */
/*   display: none !important; */
/*   } */
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
						<br>
						<br>
						<div class="card card-secondary">
							<div class="card-header">Auto Close Tickets</div>
							<div class="card-body">

								<div class="row">
									<div class="col-md-12" style="margin-top: 15px;">
										<label for="companyName">Company</label>
										<select id="companyName" class="form-control" tabindex="6" data-toogle="tooltip" name="companyName">
                            				<option value="">--Please Select--</option>
                            			</select>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12" style="margin-top: 15px;">
										<label for="ticketid1">Ticket Status </label>
										<div class="form-group" id="TType1">
											<select id="TType" tabindex="1" class="form-control"
												data-toogle="tooltip" name="TType" multiple="multiple">

												
                                                         <option value="Assigned">Assigned</option>
                                                           	<option value="Awaiting User Information">Awaiting User Information</option>
                                                        
                                                              <option value="Hold">Hold</option>
                                                          <option value="New">New</option>
                                                          		<option value="Pending With Vendor">Pending With Vendor</option>
													
                                                           <option value="Re-Assigned">Re-Assigned</option>
                                                           	<option value="Rejected">Reject</option>
                                                           <option value="Reopened">Reopened</option>
                                                           <option value="Resolved">Resolved</option>
                                                      
														<option value="Waiting for Spare">Waiting for Spare</option>
														<option value=" Work in Progress">Work in Progress</option>

											</select>
										</div>
									</div>
								</div>


								<div class="row">
									<div class="col-md-12" style="margin-top: -10px;">
										<label for="ticketid1" style="margin-left: 0px;">Close Reason </label>
										<div class="form-group" id="TType1">
											<textarea type="text" rows="3" cols="20" id="rsn"
												tabindex="12" class="form-control" data-toogle="tooltip"
												name="rsn" placeholder="Please Enter Close Reason"></textarea>
										</div>
									</div>
								</div>


								<div class="row">

									<div class="col-md-6" style="margin-top: -10px;">
										<label for="ticketid1">Time Format </label> <select
											id="Tformat" tabindex="2" class="form-control"
											data-toogle="tooltip" name="Tformat">
											<option value="">-- Please Select --</option>
											<option value="Days">Days</option>
											<option value="Hours">Hours</option>
											<option value="Min">Min</option>

										</select>
									</div>

									<div class="col-md-6" style="margin-top: -10px;">
										<label>Closed Time</label> <input maxlength="2" type="text"
											tabindex="3"
											oninput="this.value=this.value.replace(/[^0-9]/g,'');"
											id="closedtime" name="closedtime" class="form-control"
											placeholder="Please Enter Close Time" />
									</div>
								</div>


								<div class="row">

									<div style="margin-top: 15px;" class="col-md-12">
										<center>

											<input type="submit" tabindex="4"
												class="btn btn-primary m-t-10" id="submit-btn" name="submit"
												value="Submit"> <input type="reset" tabindex="5"
												class="btn btn-primary m-t-10" id="resetbtn" name="reset"
												value="Reset">
										</center>
									</div>
									<br>
								</div>

							</div>
						</div>
					</div>
					<div class="col-md-3"></div>
				</div>

				<div class="card card-secondary"
					style="margin-left: 30px; margin-right: 15px">
					<div class="card-header">Auto Close Ticket Details</div>
					<div class="card-body">
						<div id="eeeew">

							<table class="table table1 table-striped" id="datatype"
								style="width: 100%">
								<thead>
									<tr>
										<th>Sr No</th>
										<th>Delete</th>
										<th>Company</th>
										<th>Ticket Status</th>
										<th>Close Reason</th>
										<th>Time Format</th>
										<th>Close Time</th>
									</tr>
								</thead>
								<tbody>

								</tbody>

							</table>
						</div>
					</div>
				</div>





				<!--                     <div class="row"> -->
				<!--                                 <div class="col-md-2"></div> -->
				<!--                                 <div class="col-md-8"> -->
				<!--                 <div class="card card-primary" style="margin-left: 15px; margin-right: 15px"> -->
				<!--                                     <div class="card-header">Mail Configuration Details</div> -->
				<!--                                     <div class="card-body"> -->
				<!--                  <div id="eeeew"> -->

				<!--                             <table class="table table1 table-striped"  id="datatype" > -->
				<!--                                 <thead> -->
				<!--                                     <tr> -->
				<!--                                            <th>Sr No</th> -->
				<!--                                         <th>Edit</th> -->

				<!--                                         <th>Delete</th> -->

				<!--                                          <th>Host</th> -->
				<!--                                          <th>Port</th> -->
				<!--                                           <th>Email</th>  -->
				<!--                                           <th>Authentication</th> -->
				<!--                                     </tr> -->
				<!--                                 </thead> -->
				<!--                                 <tbody> -->

				<!--                                 </tbody> -->

				<!--                             </table> -->
				<!--                         </div> -->
				<!--                                          </div> -->
				<!--                                      </div> -->
				<!--                 </div> -->
				<!--                  <div class="col-md-2"></div> -->
				<!--                  </div> -->
			</section>
		</div>

		<div class="row">


			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modelmailmaster1" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Update Mail
								Configuration</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px">
								<span aria-hidden="true">&times;</span>
							</button>


						</div>
						<div class="modal-body">
							<!--<form action="">-->


							<div class="row">

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="cno">Host</label> <input type="text"
										id="hostnameupdate" class="form-control" data-toogle="tooltip"
										style="margin-left: 0%;" placeholder="Enter Company Name"
										tabindex="8">

								</div>

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="cno">Port </label> <input type="text"
										id="portnumberupdate" class="form-control"
										data-toogle="tooltip" style="margin-left: 0%;"
										placeholder="Enter Port Number" tabindex="9">

								</div>
							</div>
							<div class="row">

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="cno">Email</label><label id="email1"></label> <input
										type="text" id="emailupdate" class="form-control"
										data-toogle="tooltip" style="margin-left: 0%;"
										placeholder="Enter Email-ID" tabindex="10">

								</div>
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="cno">Password</label> <input type="text"
										id="passwordupdate" class="form-control" data-toogle="tooltip"
										style="margin-left: 0%;" placeholder="Enter Password"
										tabindex="11">
								</div>
							</div>
							<div class="row">
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="cno">Authentication</label> <select
										id="authenticationupdate" class="form-control"
										data-toogle="tooltip" style="margin-left: 0%;" tabindex="12">
										<option value=''>-- Please Select --</option>
										<option value='Yes'>Yes</option>
										<option value='No'>No</option>
									</select>
								</div>
							</div>

							<div class="row">
								<input type="hidden" id="sr_no1" name="sr_no1" value="" />
								<div style="margin-top: 15px;" class="col-md-12">
									<center>

										<input type="submit" class="btn btn-primary m-t-10"
											id="update_MailMasterType_btn"
											name="update_drivemonitoring_btn" value="Update"
											tabindex="13">



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
	<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery/dist/jquery.min.js"></script> --%>

	<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery-ui/jquery-ui.min.js"></script> --%>
	<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script> --%>

	<%--   <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script> --%>

	<%--    <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.js"></script> --%>

	<%--    <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.min.js"></script> --%>

	<script
		src="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/js/bootstrap-multiselect.js"></script>

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
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.print.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.colVis.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/autoclosedtickets.js"></script>

</body>

</html>
