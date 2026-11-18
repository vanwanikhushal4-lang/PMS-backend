<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Velox License</title>
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
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">

			<section class="content-header">
				<div class="row">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<br> <br>
						<div class="card card-secondary">
							<div class="card-header">Velox License</div>
							<div class="card-body">



								<div class="row">

									<div class="col-md-6">
										<label for="">OEM & Supplier of License</label> <input
											type="text" id="sppliernamelicense"
											class="form-control form-control-sm"
											name="sppliernamelicense" data-toogle="tooltip"
											value="VELOX SOLUTIONS PVT. LTD." readonly="readonly">
									</div>


									<div class="col-md-6">
										<label for="priority1">OEM & Supplier Address :</label>
										<div id="commentsDiv1">

											<textarea class="form-control form-control-sm"
												name="OEMAddress" rows="2" cols="50" id="OEMAddress"
												placeholder="Enter Your Client Address"
												data-original-title="" title="" readonly="readonly">1st Floor, 5th Floor and 9th Floor, Vashi Infotech Park, Plot No. 16, Sector No. 30A, Vashi, Navi Mumbai 400705.</textarea>
										</div>
									</div>




									<div class="col-md-6" style="margin-top: 15px;">
										<label for="clientname">Buyer of Licenses :</label>
										<!-- 										<input type="text" -->
										<!-- 											id="clientname" -->
										<!-- 											 class="form-control form-control-sm" -->
										<!-- 											name="clientname" data-toogle="tooltip"  -->
										<!-- 											placeholder="Enter Your Client Name"> -->

										<select id="clientname" class="form-control"
											data-toogle="tooltip" name="clientname"
											onchange='POcustomData()'>
											<option value="">--Please Select Customer Name--</option>

										</select>

									</div>



									<div class="col-md-6" style="margin-top: 15px;">
										<label for="POidList">Select PO</label> <select id="POidList"
											class="form-control" data-toogle="tooltip" name="POidList"
											onchange="POidListData()">
											<option value="">--Please Select PO ID--</option>
										</select>
										<!-- 										<input type="text" -->
										<!-- 											id="POidList" -->
										<!-- 											 class="form-control form-control-sm" -->
										<!-- 											name="POidList" data-toogle="tooltip"  -->
										<!-- 											placeholder="Enter PO"> -->

									</div>
									
									
									<!-- 11/06 -->
									<!-- //06/06 -->
									
									<div class="col-md-6" style="margin-top: 15px;">
										<label for="licenseforname">License For :</label>
										
										<select id="licenseforname" class="form-control"
											data-toogle="tooltip" name="licenseforname" onchange="licenseFor(this.value)">
											<option value="">--Please Select--</option>
											<option value="End Customer">End Customer</option>
											<option value="Partner1">Partner - End Customer</option>
											<option value="Partner2">Partner 1 -Partner 2 -End Customer</option>
											<option value="Distributor">Distributor -Partner -End Customer</option>
<!-- 											<option value="Customized">Customized</option> -->
										</select>

									</div>
									
									<div id="DistributorDiv" class="col-md-6" style="margin-top: 15px; display: none;">
										<label for="">Distributor :</label> <input type="text"
											id="Distributor" class="form-control form-control-sm"
											name="Distributor" data-toogle="tooltip"
											placeholder="Enter Distributor Name" >
									</div>
									
									<div id="Partner1Div" class="col-md-6" style="margin-top: 15px; display: none;">
										<label for="">Partner :</label> <input type="text"
											id="partner1" class="form-control form-control-sm"
											name="partner1" data-toogle="tooltip"
											placeholder="Enter Partner 1 Name" >
									</div>
									
									<div id="Partner2Div" class="col-md-6" style="margin-top: 15px; display: none;">
										<label for="">2nd Partner :</label> <input type="text"
											id="partner2" class="form-control form-control-sm"
											name="partner2" data-toogle="tooltip"
											placeholder="Enter Partner 2 Name" >
									</div>
									
									
									
									
									
									<!--  -->
									
									<div class="col-md-6" style="margin-top: 15px;">
										<label for="priority1">Customer Address :</label>
										<div id="commentsDiv">

											<textarea class="form-control form-control-sm"
												name="clientAddress" rows="1" cols="50" id="clientAddress"
												placeholder="Enter Your Client Address"
												data-original-title="" title=""></textarea>
										</div>
									</div>


									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">PO Number</label> <input type="text"
											id="ponumber" class="form-control form-control-sm"
											name="ponumber" data-toogle="tooltip"
											placeholder="Enter Your PO Number" readonly>
									</div>

									<!-- 									<div class="col-md-6" style="margin-top: 15px;"> -->
									<!-- 										<label for="">Product Suit Name</label> <input type="text" -->
									<!-- 											id="productSuitName" -->
									<!-- 											 class="form-control form-control-sm" -->
									<!-- 											name="productSuitName" data-toogle="tooltip"  -->
									<!-- 											placeholder="Enter Product Suit Name" readonly> -->
									<!-- 							        </div> -->


									<div class="col-md-6" style="margin-top: 15px;">
										<label for="productSuitNameList">Product Suit Name</label> <select
											id="productSuitNameList" class="form-control"
											data-toogle="tooltip" name="productSuitNameList"
											onchange="getEnvironmentKey();">
											<option value="">--Please Select Product--</option>
										</select>
									</div>

									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">Environment Key No</label> <input type="text"
											id="EnvironmentKeyNo" class="form-control form-control-sm"
											name="EnvironmentKeyNo" data-toogle="tooltip"
											placeholder="Enter Your Environment Key No">
									</div>





									<div class="col-md-6" style="margin-top: 15px;">
										<label>PO Date</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i
													class="far fa-calendar-alt"></i>
												</span>
											</div>
											<input type="text" readonly="true"
												class="form-control pull-right" autocomplete="off"
												name="podate" id="podate"
												placeholder="Please Select PO Date" dateformat="dd-MMM-yyyy">
										</div>
									</div>


									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">End Customer Name</label> <input type="text"
											id="endcostomername" class="form-control form-control-sm"
											name="endcostomername" data-toogle="tooltip"
											placeholder="Enter Your End Customer Name">
									</div>

									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">End Customer Email</label> <input type="email"
											id="endCustomerEmail" class="form-control form-control-sm"
											name="endCustomerEmail" data-toogle="tooltip"
											onchange="validateEmailContact()"
											placeholder="Enter End Customer Email-ID"> <span
											id="emailErrorcontactred" style="color: red;"></span> <span
											id="emailErrorcontactgreen" style="color: green;"></span>
									</div>

									<div class="col-md-6" style="margin-top: 15px; ">
										<label for="">Payment Received</label> <select
											id="payment_recieved" class="form-control"
											data-toogle="tooltip" name="payment_recieved">
											<option value="">--Please Select--</option>
											<option value="Yes">Yes</option>
											<option value="No">No</option>
										</select>
									</div>


								</div>
								
								<hr>
								<div class="row">

									<div class="col-md-6">
										<label for="FirstApprovername">Checker Name:</label> <select
											id="FirstApprovername" class="form-control"
											data-toogle="tooltip" name="FirstApprovername">
											<option value="">--Please Select Checker Name--</option>
										</select>
									</div>
									<div class="col-md-6">
										<label for="SecondApprovername">Authorizer Name:</label> <select
											id="SecondApprovername" class="form-control"
											data-toogle="tooltip" name="SecondApprovername">
											<option value="">--Please Select Authorizer Name--</option>
										</select>
									</div>
									
									
									<div class="col-md-6" style="margin-top: 15px;">
										<label for="submisstionType"> Submission Type:</label> <select
											id="submissionType" class="form-control" onchange="submissionType(this.value)"
											data-toogle="tooltip" name="submissionType">
											<option value="">--Please Select --</option>
											<option value="Generate License">Generate License</option>
											<option value="Upload License">Upload License</option>
										</select>
									</div>
									
									
									<div id="UploadLicDiv" class="col-md-6" style="margin-top: 15px; display:none;">
										<form id="form" name="form" method="post" enctype="multipart/form-data">
											<label for="licenseUploadfile">Upload License </label> <input
												type="file" id="licenseUploadfile" name="licenseUploadfile"
												class="form-control" style="height: 36px">
										</form>
									</div>

								</div>
								<br>
								<div class="row" style="display: none;"
									id="notregisteredCustomerdiv1">


									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">Customer Name :</label> <input type="text"
											id="newcustomername" class="form-control form-control-sm"
											name="newcustomername" data-toogle="tooltip"
											placeholder="Enter Customer Name Here">
									</div>

									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">Address:</label> <input type="text"
											id="newAddress" class="form-control form-control-sm"
											name="newAddress" data-toogle="tooltip"
											placeholder="Enter Address Here">
									</div>



								</div>


								<div class="row" style="display: none;"
									id="notregisteredCustomerdiv2">


									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">District :</label> <input type="text"
											id="newdistrict" class="form-control form-control-sm"
											name="newdistrict" data-toogle="tooltip"
											placeholder="Enter District Here">
									</div>

									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">City:</label> <input type="text" id="newcity"
											class="form-control form-control-sm" name="newcity"
											data-toogle="tooltip" placeholder="Enter City Here">
									</div>



								</div>

								<div class="row" style="display: none;"
									id="notregisteredCustomerdiv3">


									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">PIN:</label> <input type="text" id="newpin"
											class="form-control form-control-sm" name="newpin"
											onchange="validatetepin()" data-toogle="tooltip"
											placeholder="Enter PIN Here"> <span id="pincodered"
											style="color: red;"></span> <span id="pincodegreen"
											style="color: green;"></span>
									</div>

									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">Email-ID (Office):</label> <input type="email"
											id="office_mailid" class="form-control form-control-sm"
											name="office_mailid" data-toogle="tooltip"
											onchange="validateEmailOffice()"
											placeholder="Enter Office Email-ID"> <span
											id="emailErrorOfficered" style="color: red;"></span> <span
											id="emailErrorOfficegreen" style="color: green;"></span>
									</div>



								</div>



								<div class="row" style="display: none;" id="addCustomerDataDiv">

									<div style="margin-top: 15px;" class="col-md-12">
										<center>

											<button type="button" onclick="customerData()"
												class="btn btn-primary m-t-10">Add Customer</button>
											<button type="button" class="btn btn-warning m-t-10"
												id="reset-Customer-btn" name="reset-Customer-btn"
												value="Reset">Reset Customer</button>
										</center>
									</div>
									<br>
								</div>

								<!-- 							</div> -->
							</div>
						</div>

					</div>
					<div class="col-md-2"></div>
				</div>
				<br>
				<!-- 		 add row code here  -->


				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="card card-secondary">
							<div class="card-header">Product Details</div>
							<div class="card-body">
								<div id="eeeew">



									<div class="row" id="addrowhideidforamc">

										<div class="col-md-12">

											<table id="data-table" class="col-md-12"
												style="margin-top: 15px;">
												<thead>
													<tr>
														<th>Product Suite</th>
														<th>Product Tool</th>
														<th>Quantity</th>
														<th>Period (in year)</th>
														<!-- 														<th>Unit Rate</th> -->
														<!-- 														<th>Total Price</th>																					 -->
													</tr>
												</thead>
												<tbody>
													<tr>

														<td><select id="productsuitaddrow"
															class="form-control" data-toogle="tooltip"
															name="productsuitaddrow">
																<option value="">--Please Select Product
																	Suite--</option>
														</select></td>

<!-- 																												<td>												 -->
<!-- 																												<select id="productnameaddrow" -->
<!-- 																													 class="form-control" data-toogle="tooltip" -->
<!-- 																													name="productnameaddrow" > -->
<!-- 																														<option value="">--Please Select Product Tool--</option> -->
<!-- 																												</select>																												 -->
<!-- 																												</td> -->

<!-- 														<td><input type="text" id="productnameaddrow" -->
<!-- 															name="productnameaddrow" -->
<!-- 															placeholder="Enter your Product Name" -->
<!-- 															class="form-control"></td> -->

														<td>
														<select id="productnameaddrow" class="form-control" data-toogle="tooltip"
															name="productnameaddrow">
																<option value="">--Please Select Product Tool--</option>
														</select>
														</td>


														<td><input type="text" id="Desciption"
															name="Desciption" placeholder="Enter your Quantity"
															class="form-control" oninput="validatequantity(this)"
															oninput="this.value = this.value.replace(/[^0-9]/g, '');"></td>


														<td><input type="number"
															placeholder="Enter Your Period" id="quantitydata"
															name="quantitydata" class="form-control"></td>



														<button type="button" onclick="addRow()"
															class="btn btn-sm btn-primary" id="addRowButton"
															style="margin-left: 12px;">&nbsp;ADD&nbsp;&nbsp;</button>
														</td>
													</tr>
												</tbody>
											</table>
										</div>

									</div>

									<div class="row">

										<div style="margin-top: 15px;" class="col-md-12">
											<center>

												<button type="button" onclick="submitData()"
													class="btn btn-primary m-t-10" id="submit-btn"
													name="submit" style="margin-top: 15px;">
													Submit <span class="spinner-border"
														style="width: 1rem; height: 1rem; display: none;"
														id="spin2"><i class="fa fa-refresh fa-spin fa-10x"></i></span>
														
												</button>
												<button type="button" class="btn btn-primary m-t-10"
													id="reset-btn" name="reset-btn" value="Reset"
													style="margin-top: 15px;" onclick="resetDetails()">Reset</button>
											</center>
										</div>
									</div>

								</div>

							</div>
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>

			</section>
		</div>

	</div>

</body>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
	<!-- Control sidebar content goes here -->
</aside>

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
	src="<%=request.getContextPath()%>/static/custom/Veloxlicense.js"></script>


<script type="text/javascript">
	$('#podate').datepicker({
		autoclose : true,
		format : 'dd-mm-yyyy',
		todayHighlight : !0,
		orientation : "bottom",
	}).on('change', function() {

	});
</script>

</body>

</html>


