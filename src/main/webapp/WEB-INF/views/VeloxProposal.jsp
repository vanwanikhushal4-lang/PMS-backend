<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Commercial Proposal</title>
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
							<div class="card-header">Commercial Proposal</div>
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
											id="Perpetualyear" ="9" class="form-control"
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
											<option value="5 year Subscription">5 year Subscription</option>

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
								<div class=row>
									
									<div class="col-md-6">
										<label for="">Proposal For:</label> <select
											id="proposalFor" class="form-control"
											data-toogle="tooltip" name="proposalFor"
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
											id="PartnerName" name="PartnerName" placeholder="Enter Partner Name">
									</div>
								
								
								</div>
								<br>

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

<!-- 									<div class="col-md-6" id="hideScanplus"  style="display: none;"> -->
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
											id="FirstApprovername" ="10" class="form-control"
											data-toogle="tooltip" name="FirstApprovername"
											onchange="getCheckerNo()">
											<option value="">--Please Select Checker Name--</option>
										</select>
									</div>

									<div class="col-md-6">
										<label for="approvercontact">Checker Approver Contact
											No :</label> <input type="text" id="firstapprovercontact"
											="5" class="form-control form-control-sm"
											name="firstapprovercontact" data-toogle="tooltip"
											placeholder="Approver Contact No" readonly>
									</div>
								</div>
								<br>
								<div class="row">

									<div class="col-md-6">
										<label for="authorizer"> Authorizer Name :</label> <input
											type="text" id="secondApprovername"
											="5" class="form-control form-control-sm"
											name="secondApprovername" data-toogle="tooltip"
											placeholder="Enter  Authorizer  Name"
											value="Dr. Mangesh Amale" readonly="readonly">
									</div>

									<div class="col-md-6">
										<label for="authorizercontact"> Authorizer Contact No</label>
										<input type="number" id="secondapprovercontact"
											="5" class="form-control form-control-sm"
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
											id="office_mailid" ="5" class="form-control form-control-sm"
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
												class="btn btn-primary m-t-10"="4"  >Add Customer</button>
											<button type="button"
												="3"
													class="btn btn-primary m-t-10"
												id="reset-Customer-btn" name="reset-Customer-btn"
												value="Reset">Reset Customer</button>
										</center>
									</div>
									<br>
								</div>


								<div class="row">
									<div class="col-md-6" style="margin-top:15px;" id="endCustomernameDiv">
										<label for="authorizercontact">End Customer
											Name(Optional)</label> <input type="text" id="enccustomername"
											 class="form-control form-control-sm"
											name="enccustomername" data-toogle="tooltip"
											placeholder="Enter End Customer Name">
									</div>
									
									
									<div  class="col-md-6" style="margin-top:15px;">
										<label for="authorizercontact">Contact Person (Optional)</label>
										<input type="text" id="contactperson" 
											 class="form-control form-control-sm"
											name="contactperson" data-toogle="tooltip"
											placeholder="Enter End Contact Person Name" >
									</div>
									
									
									<div  class="col-md-6" style="display: none; margin-top: 15px;" id="poreferenceidhide">
										<label for="">PO Reference No (Optional)</label>
										<input type="text" id="poreferenceno" 
											 class="form-control form-control-sm"
											name="poreferenceno" data-toogle="tooltip"
											placeholder="Enter End PO Reference No" >
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
								</div>
								<br>
							</div>
						</div>
					</div>
					<div class="col-md-2"></div>
				</div>
				<br>
				<!-- 		 add row code here  -->


				<div class="row">

					<div class="col-md-12">
						<div class="card card-secondary"
							style="margin-left: 15px; margin-right: 15px">
							<div class="card-header">Product Details</div>
							<div class="card-body">
								<div id="eeeew">

									<!-- 	START		new jsp for AMC PROPOSAL -->


									<div class="row" style="display: none;" id="AMCSTARTENDHIDEID">
										<div class="col-md-3">
											<label for="amcstartdate">AMC Start Date:</label>

											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="far fa-calendar-alt"></i>
													</span>
												</div>
												<input type="text" readonly="true"
											
																	class="form-control pull-right"
													autocomplete="off" name="amcstartdate" id="amcstartdate"
													placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
											</div>
										</div>

										<div class="col-md-3">

											<label>Select Month/Year :</label> <select id="AMCmonthyear"
											 class="form-control" data-toogle="tooltip"
												name="AMCmonthyear" onchange="AMCMonthYearType()">
												<option value="">---Please Select Month/Year---</option>
												<!-- 												<option value="1 year Warranty">1 year Warranty</option> -->
												<option value="Month" selected>Month</option>
												<option value="Year">Year</option>
											</select>

										</div>

										<div class="col-md-3" id="AMCMonthDiv">
											<label>Month :</label> <input id="AMCMonth"
												="9" class="form-control" data-toogle="tooltip"
												name="AMCMonth" placeholder="Add AMC Month"
												onchange="AMCendmonth()"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>

										<div class="col-md-3" style="display: none;" id="AMCYearDiv">
											<label>Year :</label> <input id="AMCYear"
												="9" class="form-control" data-toogle="tooltip"
												name="AMCYear" placeholder="Add AMC Year"
												onchange="AMCendYear()"
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
												<input type="text" readonly class="form-control pull-right"
													autocomplete="off" name="amcenddate" id="amcenddate"
													placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
											</div>

										</div>
									</div>


									<br>

									<div class="row" style="display: none;" id="productsuitandtoolhideid">
									
										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Product Suit :</label> <select
												id="productsuitdetails" class="form-control" tabindex="8"
												data-toogle="tooltip" name="productsuitdetails"
												onchange="securitydetailforamc()">
											</select>

										</div>

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Security Tools :</label> <select
												id="securitysolutiondetails" class="form-control"
												tabindex="8" data-toogle="tooltip"
												name="securitysolutiondetails">
<option value="">---Please Select---</option>
											</select>

										</div>

								
										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Description :</label> <input type="text"
												id="descforamc" class="form-control form-control-sm"
												name="descforamc" data-toogle="tooltip"
												placeholder="Enter Description Here">
										</div>

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Total Cost :</label> <input type="text"
												id="totalcostAMC" class="form-control form-control-sm"
												name="totalcostAMC" data-toogle="tooltip"
												placeholder="Enter Total Cost Here">
										</div>
										
										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">18% GST of Total Cost :</label> <input
												type="text" id="gstforamc"
												class="form-control form-control-sm" name="gstforamc"
												data-toogle="tooltip"
												placeholder="Enter GST Percentage Here" readonly="readonly">
										</div>


										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Grand Total :</label> <input type="text"
												id="GRANDTOTALFORAMC" class="form-control form-control-sm"
												name="GRANDTOTALFORAMC" data-toogle="tooltip"
												placeholder="Enter Grand Total Here" readonly="readonly">
										</div>


									</div>



									<!-- 	end		new jsp for AMC PROPOSAL -->







									<div class="row" id="addrowhideidforamc">

										<div class="col-md-12">

											<table id="data-table" class="col-md-12">
												<thead>
													<tr>
														<th>Product Suite</th>
														<th>Product Tool</th>
														<th>Description</th>
														<th>Quantity</th>
														<th>Unit Rate</th>
														<th>Total Price</th>
														<!-- 																										<th>Action</th> -->
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

														<td>
														
														<select id="productnameaddrow"
															 class="form-control" data-toogle="tooltip"
															name="productnameaddrow">
																<option value="">--Please Select Product Tool--</option>
														</select>
<!-- 												<select id="productnameaddrow"  class="form-control" -->
<!-- 													 data-toogle="tooltip" -->
<!-- 													name="productnameaddrow"  multiple="multiple" > -->
<!--                                                           </select> -->
														
														
														</td>
														<td><input type="text" id="Desciption"
															placeholder="Enter your Desciption" class="form-control"></td>
														<td><input type="text"
															placeholder="Enter Your Quantity" id="quantitydata"
															name="quantitydata" class="form-control"
															oninput="validateQuantity(this)"
															oninput="this.value = this.value.replace(/[^0-9]/g, '');">
														<td><input type="text"
															placeholder="Enter Your Unit Rate" id="unitratedata"
															name="unitratedata" class="form-control"
															oninput="validateunitrate(this)"
															oninput="this.value = this.value.replace(/[^0-9]/g, '');">
														</td>
														<td><input type="text" placeholder="Total Price"
															id="totalpricedata" name="totalpricedata"
															class="form-control" readonly="readonly"></td>
														<td>
															<button type="button" onclick="addRow()"
																class="btn btn-sm btn-primary" id="addRowButton"
																style="margin-left: 12px;">&nbsp;ADD&nbsp;&nbsp;</button>
														</td>
													</tr>
												</tbody>
											</table>
										</div>

									</div>


								<br>

									<div class="row" style="display: none;" id="subtotalahideid">
										<br>
										<div class="col-md-5">
											<label for="approver33333">Sub Total (A) :</label> <input
												type="text" id="totalpriceforallproduct"
												="5" class="form-control form-control-sm"
												name="totalpriceforallproduct" data-toogle="tooltip"
												readonly="readonly">
										</div>
									</div>
									
									
									
															<!--  START  add two field for RESOURCE        -->
               
               
               			    <div class="row" style="display: none;" id="subtotalahideidforResource">
										<br>
										<div class="col-md-4">
											<label for="">Sub Total (A) Resource :</label> <input
												type="text" id="subtotalAResource"
												 class="form-control form-control-sm"
												name="subtotalAResource" data-toogle="tooltip"
												readonly="readonly">
										</div>
																		
                          
                                          <div class="col-md-4" >
											<label for="">18% GST of Sub Total (A) Resource :</label> <input
												type="text" id="gstdataforresource"
												 class="form-control form-control-sm"
												name="gstdataforresource" data-toogle="tooltip"
												readonly="readonly">
										</div>
										
										 <div class="col-md-4" >
											<label for="">Grand Total Resource :</label> <input
												type="text" id="grandtotalforresource"
												 class="form-control form-control-sm"
												name="grandtotalforresource" data-toogle="tooltip"
												readonly="readonly">
										</div>
	                       </div>

<!--                                   END  add two field for RESOURCE           -->






									<div class="row" style="display: none;"
										id="subtotalahideid3yearsubs">
										<br>
										<div class="col-md-5">
											<label for="">Sub Total 3 Year Subscription (A) :</label> <input
												type="text" id="totalpriceforallproduct3yearsubs"
											class="form-control form-control-sm"
												name="totalpriceforallproduct3yearsubs"
												data-toogle="tooltip" readonly="readonly">
										</div>
									</div>

									<div class="row" style="display: none;"
										id="subtotalahideid3yearperp">
										<br>
										<div class="col-md-5">
											<label for="">Sub Total 3 Year Warranty (A) :</label> <input
												type="text" id="totalpriceforallproduct3yearperp"
												 class="form-control form-control-sm"
												name="totalpriceforallproduct3yearperp"
												data-toogle="tooltip" readonly="readonly">
										</div>
									</div>

									<div class="row" style="display: none;"
										id="subtotalahideid5yearperp">
										<br>
										<div class="col-md-5">
											<label for="">Sub Total 5 Year Warranty (A) :</label> <input
												type="text" id="totalpriceforallproduct5yearperp"
												class="form-control form-control-sm"
												name="totalpriceforallproduct5yearperp"
												data-toogle="tooltip" readonly="readonly">
										</div>
									</div>

									<div class="row" style="display: none;"
										id="subtotalahideid3yearfixedd">
										<br>
										<div class="col-md-5">
											<label for="">Sub Total 3 fixed Year (A) :</label> <input
												type="text" id="threeyearfixed"
												 class="form-control form-control-sm" name="3yearfixed"
												data-toogle="tooltip" readonly="readonly">
										</div>
									</div>


									<div class="row" style="display: none;" id="subtotalahideid5yearfixed1">
										<br>
										<div class="col-md-5">
											<label for="">Sub Total 5 fixed Year (A) :</label> <input
												type="text" id="fiveyearfixed"
											 class="form-control form-control-sm" name="5yearfixed"
												data-toogle="tooltip" readonly="readonly">
										</div>
									</div>



									<br>


									<div class="row" id="chargesforAllPropType">

										<div style="margin-top: 15px;" class="col-md-6" >
											<label for="approver">Implementation & Deployment
												support :</label> <input type="text" id="deploysupport"
												class="form-control form-control-sm"
												name="deploysupport" data-toogle="tooltip"
												onchange="validateapprover()"
												placeholder="Enter Implementation & Deployement support"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>

										<div class="col-md-6" style="margin-top: 15px;" >
											<label for="approvercontact">Cloud Deployment
												Charges(Optional) :</label> <input type="text"
												id="clouddeploycharges"
										 class="form-control form-control-sm"
												name="clouddeploycharges" data-toogle="tooltip"
												onchange="validatecloud()"
												placeholder="Enter Cloud Deployement Charges "
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">


										</div>
								
									

                                    	<div class="col-md-6" style="margin-top: 15px;" >
											<label for="">Integration Charges :</label> 
											
											<select id="IntegrationCharges"  class="form-control"
												data-toogle="tooltip" name="IntegrationCharges"
												onchange="integrationcharge()">
										         <option value="">---Please Select Integration Charges---</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
                                          </select>
										</div>

										<div class="col-md-6" style="display: none; margin-top: 15px;" id="integrationhideid"
											>
											<label for="">Integration Charges:</label> <input type="text"
												id="integrationcharge"
												 class="form-control form-control-sm"
												name="integrationcharge" data-toogle="tooltip"
												placeholder="Enter Integration Charges Here"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>
								
								


							

										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="">Sub Total (B) :</label> <input type="text"
												id="subtotalB" ="5" class="form-control form-control-sm"
												name="subtotalB" data-toogle="tooltip" readonly="readonly">
										</div>


										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="">Sub Total C (A+B) :</label> <input type="text"
												id="totalc" ="5" class="form-control form-control-sm"
												name="totalc" data-toogle="tooltip" readonly="readonly">
										</div>
									
									

										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="">GST @18% Of C :</label> <input type="text"
												id="total18percentage"
												 class="form-control form-control-sm"
												name="total18percentage" data-toogle="tooltip"
												readonly="readonly">
										</div>

										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="">Grand Total :</label> <input type="text"
												id="grandtotal" ="5" class="form-control form-control-sm"
												name="grandtotal" data-toogle="tooltip" readonly="readonly">
										</div>
								
									
										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="">Resources Amount :</label> <input type="text"
												id="resoucesamount"
											 class="form-control form-control-sm"
												name="resoucesamount" data-toogle="tooltip"
												placeholder="Enter Resouces Amount"
												onchange="resoucesamount()"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>


									</div>
									<br><br>

<hr>

<div class="row" style="display:none;" id="subsANDPerpTbaleHeader">

										<div class="col-md-4"></div>
										<div class="col-md-4"
								style="margin-left: 62px; font-size: 15px; color: red;">
								<strong>Perpetual Table</strong>
							</div>
										<div class="col-md-4"></div>
									</div>
									
<br><br>


<div class="row"  style="display: none;" id="addRowProductPerpSubsHideDiv">

										<div class="col-md-12">

											<table id="data-table21" class="col-md-12">
												<thead>
													<tr>
														<th>Product Suite</th>
														<th>Product Tool</th>
														<th>Description</th>
														<th>Quantity</th>
														<th>Unit Rate</th>
														<th>Total Price</th>
														<!-- 																										<th>Action</th> -->
													</tr>
												</thead>
												<tbody>
													<tr>

														<td><select id="productsuitaddrow21"
															 class="form-control" data-toogle="tooltip"
															name="productsuitaddrow21">
																<option value="">--Please Select Product
																	Suite--</option>
														</select></td>

														<td>
														
														<select id="productnameaddrow21"
															 class="form-control" data-toogle="tooltip"
															name="productnameaddrow21">
																<option value="">--Please Select Product Tool--</option>
														</select>
<!-- 												<select id="productnameaddrow"  class="form-control" -->
<!-- 													 data-toogle="tooltip" -->
<!-- 													name="productnameaddrow"  multiple="multiple" > -->
<!--                                                           </select> -->
														
														
														</td>
														<td><input type="text" id="Desciption21"
															placeholder="Enter your Desciption" class="form-control"></td>
														<td><input type="text"
															placeholder="Enter Your Quantity" id="quantitydata21"
															name="quantitydata" class="form-control"
															oninput="validateQuantity(this)"
															oninput="this.value = this.value.replace(/[^0-9]/g, '');">
														<td><input type="text"
															placeholder="Enter Your Unit Rate" id="unitratedata21"
															name="unitratedata21" class="form-control"
															oninput="validateunitrate(this)"
															oninput="this.value = this.value.replace(/[^0-9]/g, '');">
														</td>
														<td><input type="text" placeholder="Total Price"
															id="totalpricedata21" name="totalpricedata21"
															class="form-control" readonly="readonly"></td>
														<td>
															<button type="button" onclick="addRow21()"
																class="btn btn-sm btn-primary" id="addRowButton21"
																style="margin-left: 12px;">&nbsp;ADD&nbsp;&nbsp;</button>
														</td>
													</tr>
												</tbody>
											</table>
										</div>

									</div>
<br>


		<div class="col-md-6" style="display: none;"
										id="perpetualSubsAnnualPerpHideDiv">

											<label for="">Sub Total Annual Year (A) :</label> <input
												type="text" id="perpetualSubsAnnualperpType"
											 class="form-control form-control-sm" name="perpetualSubsAnnualperpType"
												data-toogle="tooltip" readonly="readonly">

									</div>


									<div class="col-md-6" style="display: none;" id="perpetualSubs3yearPerpHideDiv">

											<label for="">Sub Total 3 Pepetual Year (A) :</label> <input
												type="text" id="perpetualSubs3yearperpType"
											 class="form-control form-control-sm" name="perpetualSubs3yearperpType"
												data-toogle="tooltip" readonly="readonly">

									</div>



								


<br>
<div class="row" style="display: none;" id="chargesForPerpetualType">

										<div style="margin-top: 15px;" class="col-md-6" >
											<label for="deploysupport21">Implementation & Deployment
												support :</label> <input type="text" id="deploysupport21"
												class="form-control form-control-sm"
												name="deploysupport21" data-toogle="tooltip"
												onchange="validateapprover()"
												placeholder="Enter Implementation & Deployement support"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>

										<div class="col-md-6" style="margin-top: 15px;" >
											<label for="clouddeploycharges21">Cloud Deployment
												Charges(Optional) :</label> <input type="text"
												id="clouddeploycharges21"
										 class="form-control form-control-sm"
												name="clouddeploycharges21" data-toogle="tooltip"
												onchange="validatecloud()"
												placeholder="Enter Cloud Deployement Charges "
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">


										</div>
								
									

                                    	<div class="col-md-6" style="margin-top: 15px;" >
											<label for="">Integration Charges :</label> 
											
											<select id="IntegrationCharges21"  class="form-control"
												data-toogle="tooltip" name="IntegrationCharges21"
												onchange="integrationcharge()">
										         <option value="">---Please Select Integration Charges---</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
                                          </select>
										</div>

										<div class="col-md-6" style="display: none; margin-top: 15px;" id="integrationhideid21"
											>
											<label for="">Integration Charges:</label> <input type="text"
												id="integrationcharge21"
												 class="form-control form-control-sm"
												name="integrationcharge21" data-toogle="tooltip"
												placeholder="Enter Integration Charges Here"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>
								
								


							

										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="subtotalB21">Sub Total (B) :</label> <input type="text"
												id="subtotalB21"  class="form-control form-control-sm"
												name="subtotalB21" data-toogle="tooltip" readonly="readonly">
										</div>


										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="totalc21">Sub Total C (A+B) :</label> <input type="text"
												id="totalc21"  class="form-control form-control-sm"
												name="totalc21" data-toogle="tooltip" readonly="readonly">
										</div>
									
									

										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="total18percentage21">GST @18% Of C :</label> <input type="text"
												id="total18percentage21"
												 class="form-control form-control-sm"
												name="total18percentage21" data-toogle="tooltip"
												readonly="readonly">
										</div>

										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="grandtotal21">Grand Total :</label> <input type="text"
												id="grandtotal21" class="form-control form-control-sm"
												name="grandtotal21" data-toogle="tooltip" readonly="readonly">
										</div>
								
									
										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="resoucesamount21">Resources Amount :</label> <input type="text"
												id="resoucesamount21"
											 class="form-control form-control-sm"
												name="resoucesamount21" data-toogle="tooltip"
												placeholder="Enter Resouces Amount"
												onchange="resoucesamount()"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>


									</div>
									<br>



									<div class="row">

										<div style="margin-top: 15px;" class="col-md-12">
											<center>

												<button type="button" onclick="submitData()"
													class="btn btn-primary m-t-10" ="4" id="submit-btn"
													name="submit">
													Submit <span class="spinner-border"
														style="width: 1rem; height: 1rem; display: none;"
														id="spin2">
												</button>
												<button type="button"
													="3"
													class="btn btn-primary m-t-10"
													id="reset-btn" name="reset-btn" value="Reset">Reset</button>
											</center>
										</div>
									</div>

								</div>

							</div>
						</div>
					</div>

				</div>

			</section>
		</div>

	</div>
	<!-- 								</div> -->
	<!-- 							</div> -->
	<!-- 						</div> -->
	<!-- 					</div> -->
	<!-- 					</section> -->
	<!-- 		</div> -->

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
	src="<%=request.getContextPath()%>/static/custom/veloxproposal.js"></script>



<script type="text/javascript">
	$('#amcstartdate').datepicker({
		autoclose : true,
		format : 'dd-mm-yyyy',
		todayHighlight : !0,
		orientation : "bottom",
	}).on('change', function() {

	});

	// $('#amcenddate').datepicker({
	//     autoclose: true,
	//     format: 'dd-mm-yyyy',
	//     todayHighlight: !0,
	//     orientation: "bottom",
	// }).on('change', function () {

	// });

	$(document).ready(function() {
		// Attach an event listener to the total cost input
		$("#totalcostAMC").on("input", function() {
			// Get the entered total cost value
			var totalCost = $(this).val();

			// Check if the entered value is a valid number
			if ($.isNumeric(totalCost)) {
				// Calculate the grand total including 18% GST
				var grandTotal = parseFloat(totalCost) * 1.18;

				var gsttotal = parseFloat(totalCost) * 0.18;

				//     var gstAmount = parseFloat(totalCost) * 0.18

				// Update the Grand Total input with the calculated value

				$("#gstforamc").val(gsttotal.toFixed(2));

				$("#GRANDTOTALFORAMC").val(grandTotal.toFixed(2));
			} else {

				$("#GRANDTOTALFORAMC").val("Invalid Input");
				$("#gstforamc").val("Invalid Input");
			}
		});
	});
</script>

</body>

</html>


