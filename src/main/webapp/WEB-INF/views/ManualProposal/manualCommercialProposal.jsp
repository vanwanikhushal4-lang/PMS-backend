<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Manual Commercial Proposal</title>
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
							<div class="card-header">Manual Commercial Proposal</div>
							<div class="card-body">


								<div class="row">

									<div class="col-md-6">
										<label for="">Proposal Type :</label> <select
											id="Proposaltype"  class="form-control"
											data-toogle="tooltip" name="Proposaltype"
											onchange="proposaltypedata()">
											<option value="">---Please Select---</option>
											<!-- 												<option value="Perpetual">Perpetual</option> -->
											<!-- 												<option value="Subscription">Subscription</option> -->

										</select>

									</div>
									<div class="col-md-6" style="display: none;"
										id="perpetualhideid">
										<label for="">Perpetual Year :</label> <select
											id="Perpetualyear"  class="form-control"
											data-toogle="tooltip" name="Perpetualyear"
											onchange="proposalbaseddatashowedperp()">
											<option value="">---Please Select---</option>
											<option value="1 year Warranty">1 year Warranty</option>
											<option value="3 year Warranty">3 year Warranty</option>
											<option value="5 year Warranty">5 year Warranty</option>
										</select>

									</div>

									<div class="col-md-6" style="display: none;"
										id="subscriptionhideid">
										<label for="">Subscription Year:</label> <select
											id="Subscriptionyear"  class="form-control"
											data-toogle="tooltip" name="Subscriptionyear"
											onchange="proposalbaseddatashowedsubs()">
											<option value="">---Please Select---</option>
											<option value="Annual Price">Annual Price</option>
											<option value="3 year Subscription">3 year
												Subscription</option>

										</select>
									</div>

									<div class="col-md-6" style="display: none;" id="fixedhideid">
										<label for="">Fixed Year :</label> <select id="fixedyear"
											 class="form-control" data-toogle="tooltip"
											name="fixedyear"
											onchange="proposalbaseddatashowedfixedyear()">
											<option value="">---Please Select---</option>
											<!-- 												<option value="1 year Warranty">1 year Warranty</option> -->
											<option value="3 year Warranty">3 year Warranty</option>
											<option value="5 year Warranty">5 year Warranty</option>
										</select>

									</div>
									
	<div class="col-md-6" style="display: none;"
										id="subscriptionANDperpetualhideid">
										<label for="">Subscription & Perpetual Year:</label> <select
											id="subscriptionANDperpetualYear"  class="form-control"
											data-toogle="tooltip" name="subscriptionANDperpetualYear"
											onchange="proposalbaseddatashowedsubsANDperp()">
											<option value="">---Please Select---</option>
											<option value="Annual Price">Annual Price</option>
											<option value="3 Year Price">3 Year Price</option>

										</select>
									</div>


								</div>

								<br>
								
								
								<!-- //25/06 -->
								<div class=row>
									
									<div class="col-md-6">
										<label for="">Proposal For:</label> <select
											id="proposal_For" class="form-control"
											data-toogle="tooltip" name="proposal_For"
											onchange="proposalFor()">
											<option value="">---Please Select---</option>
											<option value="Distributor">Distributor</option>
											<option value="Partner">Partner</option>
											<option value="End customer">End customer</option>
										</select>
									</div>
									
								
								<div class="col-md-6" id="hidePartnerName"  style="display: none;">
										<label for="">Partner Name (Optional)</label> <input type="text"
											data-toogle="tooltip" class="form-control"
											id="PartnerName" name="PartnerName">
									</div>
								
								
								</div>
								<br>
								<!--  -->

<!-- 								<div class="row"> -->

<!-- 									<div class="col-md-6"> -->
<!-- 										<label for="">Product Suite:</label> <select -->
<!-- 											id="productsuitselect" class="form-control" -->
<!-- 											data-toogle="tooltip" name="productsuitselect" -->
<!-- 											onchange="productsuit()"> -->
<!-- 											<option value="">---Please Select---</option> -->
<!-- 											<option value="ScanPlus">ScanPlus</option> -->
<!-- 											<option value="SecureIT">SecureIT</option> -->
<!-- 											<option value="AssetGrid">AssetGrid</option> -->
<!-- 											<option value="PlanetGuard">PlanetGuard</option> -->
<!-- 										</select> -->

<!-- 									</div> -->

<!-- 									<div class="col-md-6" id="hideScanplus" style="display: none;"> -->
<!-- 										<label for="">Version </label> <input type="text" -->
<!-- 											data-toogle="tooltip" class="form-control" -->
<!-- 											id="Scanplusprodversion" value="Ver. 18.0.11.12" -->
<!-- 											name="Scanplusprodversion" readonly> -->
<!-- 									</div> -->

<!-- 									<div class="col-md-6" style="display: none;" id="hideSecureIT"> -->
<!-- 										<label for="">Version </label> <input type="text" -->
<!-- 											data-toogle="tooltip" class="form-control" -->
<!-- 											id="SecureITprodversion" value="Ver. 19.11.01" -->
<!-- 											name="SecureITprodversion" readonly> -->
<!-- 									</div> -->
									
									
<!-- 									<div class="col-md-6" id="hideAssetGrid" style="display: none;"> -->
<!-- 										<label for="">Version </label> <input type="text" -->
<!-- 											data-toogle="tooltip" class="form-control" -->
<!-- 											id="AssetGridprodversion" value="Ver. 18.0.11.12" -->
<!-- 											name="AssetGridprodversion" readonly> -->
<!-- 									</div> -->

<!-- 									<div class="col-md-6" style="display: none;" id="hidePlanetGuard"> -->
<!-- 										<label for="">Version </label> <input type="text" -->
<!-- 											data-toogle="tooltip" class="form-control" -->
<!-- 											id="PlanetGuardprodversion" value="Ver. 19.11.01" -->
<!-- 											name="PlanetGuardprodversion" readonly> -->
<!-- 									</div> -->


<!-- 								</div> -->


<div class="row">
    <div class="col-md-6">
        <label for="">Product Suite:</label>
        <select id="productsuitselect" class="form-control" data-toggle="tooltip" name="productsuitselect" onchange="productsuit()">
            <option value="">---Please Select---</option>
            <option value="ScanPlus">ScanPlus</option>
            <option value="SecureIT">SecureIT</option>
            <option value="AssetGrid">AssetGrid</option>
            <option value="PlanetGuard">PlanetGuard</option>
        </select>
    </div>

    <div class="col-md-6" id="hideScanplus" style="display: none;">
        <label for="">Version</label>
        <input type="text" data-toggle="tooltip" class="form-control" id="Scanplusprodversion" value="Ver. 18.0.11.12" name="Scanplusprodversion" readonly>
    </div>

    <div class="col-md-6" id="hideSecureIT" style="display: none;">
        <label for="">Version</label>
        <input type="text" data-toggle="tooltip" class="form-control" id="SecureITprodversion" value="Ver. 19.11.01" name="SecureITprodversion" readonly>
    </div>

    <div class="col-md-6" id="hideAssetGrid" style="display: none;">
        <label for="">Version</label>
        <input type="text" data-toggle="tooltip" class="form-control" id="AssetGridprodversion" value="Ver. 18.0.11.12" name="AssetGridprodversion" readonly>
    </div>

    <div class="col-md-6" id="hidePlanetGuard" style="display: none;">
        <label for="">Version</label>
        <input type="text" data-toggle="tooltip" class="form-control" id="PlanetGuardprodversion" value="Ver. 19.11.01" name="PlanetGuardprodversion" readonly>
    </div>
</div>

								<br>


								<div class="row">

									<!-- 									<div class="col-md-6"> -->
									<!-- 										<label for="poinitiator">VP Maker Name :</label>  -->
									<!-- 										<input type="text" -->
									<!-- 											class="form-control" id="poinitiator" data-toogle="tooltip" name="poinitiator" ="1" placeholder="Enter VP Maker Name"> -->

									<!-- 									</div> -->


									<div class="col-md-6">
										<label for="poinitiator">Maker Name :</label> <input
											id="poinitiator" class="form-control"
											data-toogle="tooltip" name="poinitiator"
											placeholder="Enter Maker Name" readonly>
										<!-- 												<option value="">--Please Select VP Maker Name--</option> -->
										<!-- 									   </select>  -->
									</div>


									<div class="col-md-6">
										<label for="pocontactno">Maker Contact No : </label> <input
											type="number" data-toogle="tooltip"
											oninput="this.value = this.value.slice(0, 10);"
											class="form-control" id="poinitiatorno" name="poinitiatorno"
											placeholder="Enter VP Maker Contact No" readonly>
									</div>

								</div>
								<br>
								<div class="row">

									<!-- 									<div class="col-md-6"> -->
									<!-- 										<label for="approver">VP Checker Name:</label> <input type="text" -->
									<!-- 											id="FirstApprovername" ="5" class="form-control form-control-sm" -->
									<!-- 											name="FirstApprovername" data-toogle="tooltip" -->
									<!-- 											placeholder="Enter VP Checker Name"> -->
									<!-- 									</div> -->

									<div class="col-md-6">
										<label for="FirstApprovername">Checker Name:</label> <select
											id="FirstApprovername"  class="form-control"
											data-toogle="tooltip" name="FirstApprovername"
											onchange="getCheckerNo()">
											<option value="">--Please Select Checker Name--</option>
										</select>
									</div>

									<div class="col-md-6">
										<label for="approvercontact">Checker Approver Contact
											No :</label> <input type="text" id="firstapprovercontact"
											 class="form-control form-control-sm"
											name="firstapprovercontact" data-toogle="tooltip"
											placeholder="Approver Contact No" readonly>
									</div>
								</div>
								<br>
								<div class="row">

									<div class="col-md-6">
										<label for="authorizer"> Authorizer Name :</label> <input
											type="text" id="secondApprovername"
											 class="form-control form-control-sm"
											name="secondApprovername" data-toogle="tooltip"
											placeholder="Enter  Authorizer  Name"
											value="Dr. Mangesh Amale" readonly="readonly">
									</div>

									<div class="col-md-6">
										<label for="authorizercontact"> Authorizer Contact No</label>
										<input type="number" id="secondapprovercontact"
											 class="form-control form-control-sm"
											name="secondapprovercontact" data-toogle="tooltip"
											oninput="this.value = this.value.slice(0, 10);"
											value="9867140100" readonly="readonly">
									</div>
									<div class="col-md-1"></div>
								</div>
								<br> <label for="priority1">Remark (Optional) :</label>
								<div id="commentsDiv">

									<textarea class="form-control form-control-sm"
										name="Description" rows="1" cols="50" id="Description"
										placeholder="Add Description Here" data-original-title=""
										title=""></textarea>

								</div>
								<br>



								<div class="row">
									<!-- 									<div class="col-md-1"></div> -->

									<div class="col-md-6">
										<label>Type Of Customer:</label>
										<!--                                                   onchange="getColumnData()" <input type="text" id="requestmode" ="9" class="form-control" data-toogle="tooltip" name="requestmode" placeholder="Please Enter Request Mode" >-->
										<select id="customerType"  class="form-control"
											data-toogle="tooltip" name="customerType"
											onchange="getCustomerType()">
											<option value="">--Please Select Customer Type--</option>
											<option value="Registered">Registered</option>
											<option value="Not Registered">Not Registered</option>
										</select>

									</div>

									<div class="col-md-6" id="registeredCustomerdiv">
										<label for="clientname">Customer Name:</label>
									
										<select id="clientname"  class="form-control"
											data-toogle="tooltip" name="clientname">
											<option value="">--Please Select Customer Name--</option>
										</select>

									</div>

								</div>
								<br>


								<div class="row" style="display: none;"
									id="notregisteredCustomerdiv1">


									<div class="col-md-6" style="margin-top:15px;">
										<label for="">Customer Name :</label> <input type="text"
											id="newcustomername"
											 class="form-control form-control-sm"
											name="newcustomername" data-toogle="tooltip"
											placeholder="Enter Customer Name Here">
									</div>

									<div class="col-md-6" style="margin-top:15px;">
										<label for="">Address:</label> <input type="text"
											id="newAddress"class="form-control form-control-sm"
											name="newAddress" data-toogle="tooltip"
											placeholder="Enter Address Here">
									</div>



<!-- 								</div> -->


<!-- 								<div class="row" style="display: none;" -->
<!-- 									id="notregisteredCustomerdiv2"> -->


									<div class="col-md-6" style="margin-top:15px;">
										<label for="">District :</label> <input type="text"
											id="newdistrict"class="form-control form-control-sm"
											name="newdistrict" data-toogle="tooltip"
											placeholder="Enter District Here">
									</div>

									<div class="col-md-6" style="margin-top:15px;">
										<label for="">City:</label> <input type="text" id="newcity"
											 class="form-control form-control-sm" name="newcity"
											data-toogle="tooltip" placeholder="Enter City Here">
									</div>



<!-- 								</div> -->

<!-- 								<div class="row" style="display: none;" -->
<!-- 									id="notregisteredCustomerdiv3"> -->


									<div class="col-md-6" style="margin-top:15px;">
										<label for="">PIN:</label> <input type="text" id="newpin"
											 class="form-control form-control-sm" name="newpin"
											onchange="validatetepin()" data-toogle="tooltip"
											placeholder="Enter PIN Here"> <span id="pincodered"
											style="color: red;"></span> <span id="pincodegreen"
											style="color: green;"></span>
									</div>

									<div class="col-md-6" style="margin-top:15px;">
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
												class="btn btn-primary m-t-10"  >Add Customer</button>
											<button type="button"
												
													class="btn btn-primary m-t-10"
												id="reset-Customer-btn" name="reset-Customer-btn"
												value="Reset">Reset Customer</button>
										</center>
									</div>
									<br>
								</div>


								<div class="row">
									<div class="col-md-6" style="margin-top:15px;">
										<label for="authorizercontact">End Customer
											Name(Optional)</label> <input type="text" id="enccustomername"
											 class="form-control form-control-sm"
											name="enccustomername" data-toogle="tooltip"
											placeholder="Enter End Customer Name">
									</div>
									
									
									<div  class="col-md-6" style="margin-top:15px;">
										<label for="authorizercontact">Contact Person Number(Optional)</label>
										<input type="tel" id="contactperson" 
											 class="form-control form-control-sm"
											name="contactperson" data-toogle="tooltip"
											placeholder="Enter Contact Number" onkeypress="validMNumber(event)" maxlength="10">
											 <span id="mobileNumberError"></span>
									</div>
									
								<div  class="col-md-6" style="margin-top:15px;">
										<label for="manualAmount">Amount</label>
										<input type="number" id="manualAmount" 
											 class="form-control form-control-sm"
											name="manualAmount" data-toogle="tooltip"
											placeholder="Enter Amount" >
									</div>


									<div class="col-md-6" style="display: none; margin-top: 15px;"
										id="atchideidupper">
										<label for="ATCID">ATC :</label> <select id="ATC"
											 class="form-control" data-toogle="tooltip" name="ATC"
											onchange="abc11(this.value)">
											<option value=" ">---Please Select---</option>
											<option value="12">12%</option>
											<option value="15">15%</option>
											<option value="18">18%</option>

										</select>

									</div>
									
									
								<div  class="col-md-6" style="margin-top:15px;">
										<label for="manualProposalFile">Upload Manual Proposal File </label> <input
												type="file" id="manualProposalFile" name="manualProposalFile"
												class="form-control" style="height: 36px">
									</div>
									
								</div>
								<br>
										<div class="row">

										<div style="margin-top: 15px;" class="col-md-12">
											<center>

												<button type="button" onclick="submitData()"
													class="btn btn-primary m-t-10" id="submit-btn"
													name="submit">Submit
													<span class="spinner-border"
														style="width: 1rem; height: 1rem; display: none;"
														id="spin2"><i class="fa fa-refresh fa-spin fa-10x"></i></span>
												</button>
												<button type="button"
													
													class="btn btn-primary m-t-10"
													id="reset-btn" name="reset-btn" value="Reset">Reset</button>
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
	src="<%=request.getContextPath()%>/static/custom/manualCommercialProposal.js"></script>



<script type="text/javascript">





</script>

</body>

</html>


