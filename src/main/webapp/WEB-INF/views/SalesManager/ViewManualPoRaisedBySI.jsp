<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manual PO View</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.css"
	type="text/css" />
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
<!-- <link rel="stylesheet" type="text/css" -->
<%-- 	href="<%=request.getContextPath()%>/static/multiselect/bootstrap-multiselect.css"> --%>

<!-- summernote -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

.form-control-feedback {
	right: 25px !important;
}

.buttonnw {
	/*   //background-color: #4CAF50; */
	border: none;
	color: white;
	padding: 5px 21px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

select {
	background-color: white;
}

.form-group.has-success label {
	color: #000000;
}

.dropdown-menu>.active>a, .dropdown-menu>.active>a:focus, .dropdown-menu>.active>a:hover
	{
	background-color: #fff;
	color: #000;
}

.row {
	margin-right: -25px;
	margin-left: -15px;
}

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

            String tid = request.getParameter("tid");
            System.out.println("tid" + tid);
            
            String role = (String) session.getAttribute("role");
        %>
    </script>




</head>
<body class="hold-transition sidebar-mini layout-fixed">

	<input type="hidden" id="crnoo" name="crnoo" value="<%=crno%>">
	<input type="hidden" id="role" name="role" value="<%=role%>">
	<input type="hidden" id="tid" name="tid" value="<%=tid%>">


	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>

			<div style="padding-left: 15px; padding-right: 15px">
				<form id="form" name="form" method="post"
					enctype="multipart/form-data">

					<div class="card card-secondary border-secondary">

						<div class="card-header">
							<div class="row">
								<div class="col-md-4">Manual PO Raised By SI</div>

								<div class="col-md-7"></div>

								<div class="col-md-1">
									<a href="<%=request.getContextPath()%>/User/ManualpoRaisedByme">
										<i class="fa fa-backward pull-right" style="color: white">
									</i>
									</a>
								</div>


							</div>

						</div>

						<div class="card-body">

							<div class="row">
								<!--                                        <div style="margin-top:15px;" class="col-md-6"> -->
								<!--                                        <label style="margin-left: 2px">File Attachment:<br> -->
								<!--                                                 <span class="vlx" style="color: green;width: 450px" id="pouploadfile"></span></label><button class="button1 button4" id="pouploadfile" onclick="downFileDefect()">Download</button> -->
								<!--                                         <div class="form-group" id="pouploadfile11"> -->
								<!-- <!--                                             <input type="file" id="pouploadfile" tabindex="1" class="form-control" name="pouploadfile"  data-toogle="tooltip" placeholder="Upload File" readonly="true"> -->
								<!--                                         <input type="hidden" id="pouploadfile" name="pouploadfile"> -->
								<!--                                         </div> -->
								<!--                                     </div> -->

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="potype">Purchase Order Type</label> <input
										type="text" class="form-control" tabindex="1" id="potype"
										name="potype" data-toogle="tooltip"
										placeholder="Enter purchase Order Type" readonly>
								</div>

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="poRefNo">PO Reference No</label> <input type="text"
										class="form-control" tabindex="1" id="poRefNo" name="poRefNo"
										data-toogle="tooltip" placeholder="Enter PO Reference No"
										readonly>
								</div>

							</div>



							<div class="row">

								<div class="col-md-6" style="margin-top: 15px;">
									<label for="">Proposal Type :</label> <input id="Proposaltype"
										class="form-control" data-toogle="tooltip" name="Proposaltype"
										readonly>
								</div>

							</div>

							



							<div class="row">

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="ponumber">Purchase Order No</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
										id="email"></label> <input type="text" id="ponumber"
										tabindex="1" class="form-control" name="ponumber"
										data-toogle="tooltip" placeholder="Enter PO No" readonly>
								</div>
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="customername">Customer Name</label> <input
										type="text" class="form-control" tabindex="1"
										id="customername" name="customername" data-toogle="tooltip"
										placeholder="Enter Customer Name" readonly>
								</div>
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="podate">Purchase Order Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
										id="email"></label> <input type="text" id="podate"
										tabindex="1" class="form-control" name="podate"
										data-toogle="tooltip" readonly>
								</div>


								<div style="margin-top: 15px;" class="col-md-6">
									<label for="productSuit">Product Suit</label> <input
										type="text" class="form-control" tabindex="1" id="productSuit"
										name="productSuit" data-toogle="tooltip"
										placeholder="Enter Product Name" readonly>
								</div>
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="securityTools">Security Tools</label>
									<textarea class="form-control form-control-sm" tabindex="1"
										id="securityTools" name="securityTools" data-toogle="tooltip"
										placeholder="Enter Security Name" readonly></textarea>
								</div>






								<div style="margin-top: 15px;" class="col-md-6">
									<label for="prodliscense">Product License</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
										id="phnnno"></label> <input type="text" id="prodliscense"
										tabindex="1" class="form-control" name="prodliscense"
										data-toogle="tooltip" placeholder="Enter Product License"
										readonly="true">
								</div>


								<div style="margin-top: 15px;" class="col-md-6">
									<label for="prodamount">Product Amount</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
										id="email"></label> <input type="text" id="prodamount"
										tabindex="1" class="form-control" name="prodamount"
										data-toogle="tooltip" placeholder="Enter Product Amount"
										readonly="true">
								</div>
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="paymentterms">Payment Terms</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
										id="email"></label> <input type="text" id="paymentterms"
										tabindex="1" class="form-control" name="paymentterms"
										data-toogle="tooltip" placeholder="Enter Payment Terms"
										readonly="true">
								</div>


								<div style="margin-top: 20px; display: none;" class="col-md-6"
									id="poUploadDiv">
									<label style="margin-left: 2px"> PO File :<br> <span
										class="col-md-6" style="color: green; width: 450px"
										id="pouploadfile"></span></label>
									<button class="button1 button4" id="downHidepofile"
										onclick="downFileStandard()">Download</button>
								</div>
								<input type="hidden" id="filenameStandard"
									name="filenameStandard">

					
					
								



							</div>
							
							
							
							<div id="InvoiceDiv" class="card card-secondary border-secondary"
							style="margin-top: 30px; display: none;">
							<div class="card-body">

								<form id="form" name="form" method="post"
									enctype="multipart/form-data">
									<div class="row">
										<div class="col-md-6">
											<div id="invoattDiv">
											<span id="reupload" style="color:red; display:none; ">Do you want to upload more files ?</span>
												<br> <label for="invoicefile">Invoice File
													Upload</label> <input type="file" id="invoicefile"
													name="invoicefile" class="form-control"
													style="height: 36px" multiple>


												<button type="button" class="btn btn-primary mt-3"
													id="submit-btn" name="submit-btn" style="margin-left: 87%;" onclick="submitFile();">
													Submit<span class="spinner-border"
														style="width: 1rem; height: 1rem; display: none;"
														id="spinner">
												</button>
											</div>

										</div>

							<div style="margin-top: 20px; display: none;" class="col-md-6"
								id="advInvoiceUploadDiv">
								<label style="margin-left: 2px">Uploaded Invoice File :<br>
									<span class="col-md-6" style="color: green; width: 450px"
									id="advinvoicefile"></span></label>
								<button class="button1 button4" id="downHideadvInvfile"
									onclick="advInvFile()">Download</button>

							</div>
							<input type="hidden" id="filnameAdvinvoice"
								name="filnameAdvinvoice">

									</div>


								</form>

							</div>
						</div>




							<br>
						</div>







					</div>




				</form>
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
	<!-- ./wrapper -->
	<!-- jQuery -->

	$.widget.bridge('uibutton', $.ui.button)
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
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

	<script
		src="<%=request.getContextPath()%>/static/multiselect/jquery-3.5.1.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/multiselect/popper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/multiselect/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/multiselect/bootstrap-multiselect.js"></script>

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
		src="<%=request.getContextPath()%>/static/custom/viewManualPoRaisedBySI.js"></script>



	<script>
		$('#tennurestartdate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		// $('#tennureenddate').datepicker({
		//     autoclose: true,
		//     format: 'dd-mm-yyyy',
		//     todayHighlight: !0,
		//     orientation: "bottom",
		// }).on('change', function () {

		// });   

		$('#warrantystart').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});
	</script>

</body>
</html>