<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Manual Purchase Order</title>
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
						<form id="form" name="form" method="post"
							enctype="multipart/form-data">
							<br> <br>
							<div class="card card-secondary">
								<div class="card-header">Manual Purchase Order</div>
								<div class="card-body">


									<div class="row">
										<div class="col-md-6">
											<label for="potype">Purchase Order Type:</label><br> <select
												id="potype" class="form-control" data-toogle="tooltip"
												name="potype" >
												<option value="">--Please Select--</option>
												<option value="Product/Software PO">Product/Software
													PO</option>
												<option value="Resources Order">Resources Order</option>
												<option value="AMC Order">AMC Order</option>
											</select>
										</div>
										
										
										<div class="col-md-6">
										<label for="potype">PO Reference No :</label>
										<input type="text"	id="poRefNO" class="form-control" data-toogle="tooltip"
												name="poRefNO" placeholder="Enter Reference PO Number">
										
										</div>

										<!-- 									<div class="col-md-6" > -->
										<!-- 										<label for="">Proposal Type :</label> <select -->
										<!-- 											id="Proposaltype"  class="form-control" -->
										<!-- 											data-toogle="tooltip" name="Proposaltype" -->
										<!-- 											> -->
										<!-- 											<option value="">---Please Select---</option> -->

										<!-- 											</select> -->
										<!-- 									</div> -->
									</div>




									<div class="row">

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Proposal Type :</label> <select
												id="Proposaltype" class="form-control" data-toogle="tooltip"
												name="Proposaltype" onchange="proposaltypedata()">
												<option value="">---Please Select---</option>

											</select>

										</div>

										<div class="col-md-6" style="margin-top: 15px; display: none;"
											id="perpetualhideid">
											<label for="">Perpetual Year :</label> <select
												id="Perpetualyear" class="form-control"
												data-toogle="tooltip" name="Perpetualyear"
												onchange="getProposaldata()">
												<option value="">---Please Select---</option>
												<option value="1 year Warranty">1 year Warranty</option>
												<option value="3 year Warranty">3 year Warranty</option>
												<option value="5 year Warranty">5 year Warranty</option>
											</select>

										</div>

										<div class="col-md-6" style="margin-top: 15px; display: none;"
											id="subscriptionhideid">
											<label for="">Subscription Year:</label> <select
												id="Subscriptionyear" class="form-control"
												data-toogle="tooltip" name="Subscriptionyear"
												onchange="getProposaldata1()">
												<option value="">---Please Select---</option>
												<option value="Annual Price">Annual Price</option>
												<option value="3 year Subscription">3 year
													Subscription</option>

											</select>
										</div>

										<div class="col-md-6" style="margin-top: 15px; display: none;"
											id="fixedhideid">
											<label for="">Fixed Year :</label> <select id="fixedyear"
												class="form-control" data-toogle="tooltip" name="fixedyear"
												onchange="getProposalID()">
												<option value="">---Please Select---</option>
												<!-- 												<option value="1 year Warranty">1 year Warranty</option> -->
												<option value="3 year Warranty">3 year Warranty</option>
												<option value="5 year Warranty">5 year Warranty</option>
											</select>

										</div>


										<div class="col-md-6" style="margin-top: 15px; display: none;"
											id="fixedhideid">
											<label for="">Fixed Year :</label> <select id="fixedyear"
												class="form-control" data-toogle="tooltip" name="fixedyear"
												onchange="getProposalID()">
												<option value="">---Please Select---</option>
												<!-- 												<option value="1 year Warranty">1 year Warranty</option> -->
												<option value="3 year Warranty">3 year Warranty</option>
												<option value="5 year Warranty">5 year Warranty</option>
											</select>

										</div>

										<div class="col-md-6" style="margin-top: 15px; display: none;"
											id="subscriptionANDperpetualhideid">
											<label for="">Subscription & Perpetual Year:</label> <select
												id="subscriptionANDperpetualYear" class="form-control"
												data-toogle="tooltip" name="subscriptionANDperpetualYear"
												onchange="proposalbaseddatashowedsubsANDperp()">
												<option value="">---Please Select---</option>
												<option value="Annual Price">Annual Price</option>
												<option value="3 Year Price">3 Year Price</option>

											</select>
										</div>



										<!-- 									   <div class="col-md-6" style="margin-top:15px; display:none;" id="proposalidDIv"> -->
										<!-- 											<label >Proposal ID's :</label> -->

										<!-- 												<select id="proposalids"  class="form-control" -->
										<!-- 													 data-toogle="tooltip" -->
										<!-- 													name="proposalids" onchange="proposalIdAttachment()"> -->
										<!-- 													<option value="">--Please Select Proposal ID--</option> -->
										<!-- 												</select> -->

										<!-- 										</div> -->

										<!-- 											  <div style="margin-top:25px; display:none;" class="col-md-6" id="poUploadDiv"> -->
										<!--                                             <label style="margin-left: 2px">Velox Proposal Attachment:<br> -->
										<!--                                                 <span class="col-md-6" style="color: green;width: 450px" id="vpuploadfileProposal"></span></label><button class="button1 button4" id="downHidepofile" onclick="downFileStandard()">Download</button> -->
										<!--                                         </div> -->
										<!--                                         <input type="hidden" id="filenameStandard" name="filenameStandard"> -->




									</div>








									<br>

									<div class="row">

										<div class="col-md-6">
											<label for="ponumber">PO Number</label> <input type="text"
												id="ponumber" class="form-control" data-toogle="tooltip"
												name="ponumber" onchange="poNumberFun()"
												placeholder="Enter PO Number">


										</div>


										<div class="col-md-6">

											<label>PO Date</label>
											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="far fa-calendar-alt"></i>
													</span>
												</div>
												<input type="text" readonly="true"
													="1"
																	class="form-control pull-right"
													autocomplete="off" name="podate" id="podate"
													onchange="poDateFun()" placeholder="Please Select PO Date"
													dateformat="dd-MMM-yyyy">
											</div>
										</div>
									</div>

									<br>


									<div class="row">


										<div class="col-md-6">
											<label for="customername">Customer Name</label> <select
												id="customername" class="form-control" data-toogle="tooltip"
												name="customername" onchange='poCustomerName()'>
												<option value="">--Please Select Customer Name--</option>

											</select>
										</div>

										<div class="col-md-6">
											<label for="productsuit1">Product Suit:</label>
											<!-- 											<div class="form-group" id="groupCatDiv2ser"> -->
											<select id="productsuit" class="form-control"
												data-toogle="tooltip" name="productsuit"
												onchange="sectools()" multiple="multiple">


											</select>

										</div>
									</div>
									<br>
									<div class="row">


										<div class="col-md-6">
											<label for="securitytool1">Security Tools :</label> <select
												id="securitytool" class="form-control" data-toogle="tooltip"
												name="securitytool" multiple="multiple">
											</select>

										</div>

										<div class="col-md-6">
											<label for="prodamount">Product Amount:</label> <input
												type="text" id="prodamount" class="form-control"
												data-toogle="tooltip" name="prodamount"
												placeholder="Enter Product Amount"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>
									</div>
									<br>
									<div class="row">

										<div class="col-md-6">
											<label for="paymentterms">Payment Terms</label>

											<textarea id="paymentterms" name="paymentterms"
												data-toogle="tooltip" placeholder="Enter Payment Terms"
												class="form-control form-control-sm"></textarea>

										</div>

										<div class="col-md-6">
											<label for="prodliscense">Product License:</label> <input
												type="text" id="prodliscense"
												="9"
												class="form-control" data-toogle="tooltip"
												name="prodliscense" placeholder=" Enter Product License">


										</div>


									</div>




									
						<br>

									<div class="col-md-12" style="display: none;"
										id="warrantyAmcDateDIv">

										<div class="row">


											<div class="col-md-3">

												<label>Warranty Start Date:</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text"> <i
															class="far fa-calendar-alt"></i>
														</span>
													</div>
													<input type="text" readonly="true"
														="1"
																	class="form-control pull-right"
														autocomplete="off" name="warrantystart" id="warrantystart"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>

											</div>

											<div class="col-md-3">
												<label for="">Select Month/Year :</label> <select
													id="warrantymonthyear" class="form-control"
													data-toogle="tooltip" name="warrantymonthyear"
													onchange="warrantyMonthYearType()">
													<option value="">---Please Select Month/Year---</option>
													<!-- 												<option value="1 year Warranty">1 year Warranty</option> -->
													<option value="Month" selected>Month</option>
													<option value="Year">Year</option>
												</select>

											</div>

											<div class="col-md-3" id="warrantyMonthDiv">
												<label>Month :</label> <input id="warrantyMonth"
													class="form-control" data-toogle="tooltip"
													name="warrantyMonth" placeholder="Add Warranty Month"
													onchange="warrantyendmonth()"
													oninput="this.value = this.value.replace(/[^0-9]/g, '');">

											</div>
											<div class="col-md-3" style="display: none;"
												id="warrantyYearDiv">
												<label>Year :</label> <input id="warrantyYear"
													class="form-control" data-toogle="tooltip"
													name="warrantyYear" placeholder="Add Warranty Year"
													onchange="warrantyendYear()"
													oninput="this.value = this.value.replace(/[^0-9]/g, '');">

											</div>

											<div class="col-md-3">



												<label>Warranty End Date:</label>
												<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text"> <i
															class="far fa-calendar-alt"></i>
														</span>
													</div>
													<input type="text" readonly="true"
														class="form-control pull-right" autocomplete="off"
														name="warrantyend" id="warrantyend"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>

											</div>

										</div>
										<br> 


										<div class="row">


											<div class="col-md-3">
												<label for="amcstartdate">AMC Start Date:</label>

												<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text"> <i
															class="far fa-calendar-alt"></i>
														</span>
													</div>
													<input type="text" readonly="true"
														="1"
																	class="form-control pull-right"
														autocomplete="off" name="amcstartdate" id="amcstartdate"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>
											</div>

											<div class="col-md-3">

												<label>Select Month/Year :</label> <select
													id="AMCmonthyear" ="9" class="form-control"
													data-toogle="tooltip" name="AMCmonthyear"
													onchange="AMCMonthYearType()">
													<option value="">---Please Select Month/Year---</option>
													<!-- 												<option value="1 year Warranty">1 year Warranty</option> -->
													<option value="Month" selected>Month</option>
													<option value="Year">Year</option>
												</select>

											</div>

											<div class="col-md-3" id="AMCMonthDiv">
												<label>Month :</label> <input id="AMCMonth"
													class="form-control" data-toogle="tooltip" name="AMCMonth"
													placeholder="Add AMC Month" onchange="AMCendmonth()"
													oninput="this.value = this.value.replace(/[^0-9]/g, '');">

											</div>

											<div class="col-md-3" style="display: none;" id="AMCYearDiv">
												<label>Year :</label> <input id="AMCYear"
													class="form-control" data-toogle="tooltip" name="AMCYear"
													placeholder="Add AMC Year" onchange="AMCendYear()"
													oninput="this.value = this.value.replace(/[^0-9]/g, '');">

											</div>

											<div class="col-md-3">
												<label for="amcenddate">AMC End Date:</label>

												<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text"> <i
															class="far fa-calendar-alt"></i>
														</span>
													</div>
													<input type="text" readonly="true"
														="1"
																	class="form-control pull-right"
														autocomplete="off" name="amcenddate" id="amcenddate"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>

											</div>
										</div>

									

									</div>

									<div class="col-md-12" style="display: none;"
										id="tennureDateeDiv">

										<div class="row">
											<div class="col-md-3">
												<label for="tennurestartdate">Tennure Start Date:</label>

												<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text"> <i
															class="far fa-calendar-alt"></i>
														</span>
													</div>
													<input type="text" readonly="true"
														class="form-control pull-right" autocomplete="off"
														name="tennurestartdate" id="tennurestartdate"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>
											</div>

											<div class="col-md-3">

												<label>Select Month/Year :</label> <select
													id="tennuremonthyear" class="form-control"
													data-toogle="tooltip" name="tennuremonthyear"
													onchange="tennureMonthYearType()">
													<option value="">---Please Select Month/Year---</option>
													<!-- 												<option value="1 year Warranty">1 year Warranty</option> -->
													<option value="Month" selected>Month</option>
													<option value="Year">Year</option>
												</select>

											</div>

											<div class="col-md-3" id="tennureMonthDiv">
												<label>Month :</label> <input id="tennureMonth"
													class="form-control" data-toogle="tooltip"
													name="tennureMonth" placeholder="Add Tennure Month"
													onchange="tennureendmonth()"
													oninput="this.value = this.value.replace(/[^0-9]/g, '');">

											</div>

											<div class="col-md-3" style="display: none;"
												id="tennureYearDiv">
												<label>Year :</label> <input id="tennureYear"
													class="form-control" data-toogle="tooltip"
													name="tennureYear" placeholder="Add Tennure Year"
													onchange="tennureendYear()"
													oninput="this.value = this.value.replace(/[^0-9]/g, '');">

											</div>

											<div class="col-md-3">
												<label for="tennureenddate">Tennure End Date:</label>

												<div class="input-group">
													<div class="input-group-prepend">
														<span class="input-group-text"> <i
															class="far fa-calendar-alt"></i>
														</span>
													</div>
													<input type="text" readonly="true"
														class="form-control pull-right" autocomplete="off"
														name="tennureenddate" id="tennureenddate"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>

											</div>
											
											
										</div>
								
									</div>
									<div class="row">
										<div class="col-md-6" style="margin-top:15px;">
											<label for="pouploadfile">Upload PO File </label> <input
												type="file" id="pouploadfile" name="pouploadfile"
												class="form-control" style="height: 36px" accept=".doc,.pdf,.xlsx,.txt,.jpg">

										</div>

									</div>
									
									<br><br>
									<div class="row">
										<div style="margin-top: 15px;" class="col-md-12">
											<center>
												<button type="button" class="btn btn-primary m-t-10"
													id="submit-btn" name="submit-btn">
													Submit<span class="spinner-border"
														style="width: 1rem; height: 1rem; display: none;"
														id="spin">
												</button>

												<button type="button" class="btn btn-primary m-t-10"
													id="reset-btn" name="reset-btn" value="Reset"
													onclick="resetAll()">Reset</button>
											</center>
										</div>

									</div>
								</div>
							</div>
						</form>
					</div>
					<div class="col-md-2"></div>
				</div>
				<br>
				<!-- 		 add row code here  -->



			</section>
		</div>

	</div>


</body>









<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
	<!-- Control sidebar content goes here -->
</aside>
<!-- /.control-sidebar -->
<!-- 	</div> -->
<!-- ./wrapper -->
<!-- jQuery -->
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
	src="<%=request.getContextPath()%>/static/custom/ManualPurchaseOrder.js"></script>


<script>
$('#podate').datepicker({
    autoclose: true,
    format: 'dd-mm-yyyy',
    todayHighlight: !0,
    orientation: "bottom",
}).on('change', function () {

});   

$('#warrantystart').datepicker({
    autoclose: true,
    format: 'dd-mm-yyyy',
    todayHighlight: !0,
    orientation: "bottom",
}).on('change', function () {

});   
  
$('#RPFTIMELINES').datepicker({
    autoclose: true,
    format: 'dd-mm-yyyy',
    todayHighlight: !0,
    orientation: "bottom",
}).on('change', function () {

});   

$('#potimeline').datepicker({
    autoclose: true,
    format: 'dd-mm-yyyy',
    todayHighlight: !0,
    orientation: "bottom",
}).on('change', function () {

});   

$('#firstinvoicegeneratedate').datepicker({
    autoclose: true,
    format: 'dd-mm-yyyy',
    todayHighlight: !0,
    orientation: "bottom",
}).on('change', function () {

});   

$('#projstartdate').datepicker({
    autoclose: true,
    format: 'dd-mm-yyyy',
    todayHighlight: !0,
    orientation: "bottom",
}).on('change', function () {

});   

$('#projenddate').datepicker({
    autoclose: true,
    format: 'dd-mm-yyyy',
    todayHighlight: !0,
    orientation: "bottom",
}).on('change', function () {

});   

$('#tennurestartdate').datepicker({
    autoclose: true,
    format: 'dd-mm-yyyy',
    todayHighlight: !0,
    orientation: "bottom",
}).on('change', function () {

}); 
</script>

</body>

</html>


