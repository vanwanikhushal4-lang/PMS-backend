<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Registration Master</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--         <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"> -->
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

<!-- summernote -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
<!-- Select2 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">

<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}
#data-table tbody tr {
    margin-bottom: 10px;  /* Adjust the value as required */
}

label {
	margin-top: .5rem !important;
	margin-bottom: 0rem !important;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>
			<section class="content-header">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<form id="form" name="form" method="post"
							enctype="multipart/form-data">



							<div class="row">
								<div class="col-md-2"></div>
								<div class="col-md-8">
									<br> <br>
									<div class="card card-secondary">
										<div class="card-header">Category Type Master</div>
										<div class="card-body">
											<div class="row">
												<div class="col-md-1"></div>
												<div class="col-md-10">
													<label for="">Category Type:</label><br> <select
														id="categorytype" class="form-control" 
														data-toogle="tooltip" name="categorytype"
														onchange="myCategory()">
														<option value="">--Please Select--</option>
														<option value="Distributor">Distributor</option>
														<option value="Partner">Partner</option>
														<option value="Customer">Customer</option>
														<option value="OnlyPartner">Direct Partner</option>
														<option value="OnlyCustomer">Direct Customer</option>
													</select>
												</div>
												<div class="col-md-1"></div>
											</div>
											
											<div class="row mt-2" id="distributor" style="display: none">

												<div class="col-md-1"></div>
												<div class="col-md-10">
													<label for="">Under which
														Distributor</label>
														
													<div id="distributornamediv">
													
 
                                            <select id="distributorname"
												class="form-control"  data-toogle="tooltip"
												name="distributorname"> 	</select>
                                             
													
													</div>
												</div>
												<div class="col-md-1"></div>
											</div>
											
											
											<div class="row mt-2" id="customer" style="display: none">

												<div class="col-md-1"></div>
												<div class="col-md-10">
													<label for="">Under which Partner</label>
													<div id="partnerrnamediv">
													

                               
                                              <select id="partnername"
												class="form-control"  data-toogle="tooltip"
												name="partnername"> 	</select>

													
													</div>
												</div>
												<div class="col-md-1"></div>
											</div>
											
											
										</div>


										<div class="row">

											<div style="margin-top: 15px;" class="col-md-12">
												<center>
													<button type="button" 
														class="btn btn-primary m-t-10" id="submitCategType"
														name="submitCategType">Submit</button>

													<button type="button" 
														class="btn btn-primary m-t-10" id="resetCategType"
														name="resetCategType" value="Reset">Reset</button>
												</center>
											</div>

										</div>
										<br>
									</div>
								</div>

								<div class="col-md-2"></div>
							</div>

							<div class="card card-secondary" id="registrationform"
								style="display: none">

								<div class="card-header" id="distributorheader"
									style="display: none">Distributor Registration Form</div>
								<div class="card-header" id="partnerheader"
									style="display: none">Partner Registration Form</div>
								<div class="card-header" id="customerheader"
									style="display: none">Customer Registration Form</div>
								<div class="card-header" id="onlypartnerheader"
									style="display: none">Only Partner Registration Form</div>
								<div class="card-header" id="onlycustomerheader"
									style="display: none">Only Customer Registration Form</div>
								<div class="card-body">

									<div class="row">

										<div class="col-md-4"></div>
										<div class="col-md-4"
								style="margin-left: 62px; font-size: 15px; color: red;">
								<strong>Registration Form</strong>
							</div>
										<div class="col-md-4"></div>
									</div>

									<div class="row">


										<div class="col-md-4">
											<label for="compname11">Name Of The Company: </label> <input
												type="text" id="compname" tabindex="1" class="form-control"
												data-toogle="tooltip" name="compname"
												placeholder="Enter Name">
										</div>

										<div class="col-md-4">
											<label for="registerno">Registration No:</label> <input
												type="text" id="registerno" tabindex="2"
												class="form-control" data-toogle="tooltip" name="registerno"
												placeholder="Enter Registration No">
										</div>

										<div class="col-md-4">
											<label for="address">Address:</label> <input type="text"
												id="address" tabindex="3" class="form-control"
												data-toogle="tooltip" name="address"
												placeholder="Enter Address">
										</div>

									</div>

									<div class="row">

										<div class="col-md-4">
											<label for="personname">Contact Person Name:</label> <input
												type="text" id="personname" class="form-control" tabindex="4"
												data-toogle="tooltip" name="personname"
												placeholder="Enter Person Name">
										</div>

										<div class="col-md-4">
											<label for="mobno">Mobile No:</label> <input type="text"
												id="mobno" class="form-control" data-toogle="tooltip" tabindex="5" onchange="validatemobno()" 
												name="mobno" placeholder="Enter Mobile No" oninput="this.value = this.value.slice(0, 10);" onkeypress="return isNumberKey(event);">
												<span id="mobred"style="color: red;"></span>
												<span id="mobgreen"style="color: green;"></span>
												 
										</div>
										
										
										<div class="col-md-4">
											<label for="telpno">Telephone No:</label> <input
												type="text" id="telpno" class="form-control"
												data-toogle="tooltip" name="telpno" tabindex="6" 
												placeholder="Enter Telephone No" oninput="this.value = this.value.replace(/[^0-9-]/g, '');">
												<span id="telpnored"style="color: red;"></span>
												<span id="telpnogreen"style="color: green;"></span>
												
										</div>



									</div>
									<div class="row">

										<div class="col-md-4">
											<label for="emailid1">MD/CEO Email-ID:</label> <input
												type="email" id="Md_Ceo_emailid" tabindex="7" class="form-control"
												data-toogle="tooltip" name="Md_Ceo_emailid" onchange="validateEmail()" 
												placeholder="Enter Email-ID">
												  <span id="emailError" style="color: red;"></span>
												   <span id="emailError1" style="color: green;"></span>
										</div>
										<div class="col-md-4">
											<label for="offemailid1">Sales Email-ID:</label> <input
												type="email" id="Sales_emailid" tabindex="8"
												class="form-control" data-toogle="tooltip" name="Sales_emailid" onchange="validateEmailsales()" 
												placeholder="Enter Email-ID">
												<span id="emailErrorSalesred" style="color: red;"></span>
												   <span id="emailErrorSalesgreen" style="color: green;"></span>
										</div>
										<div class="col-md-4">
											<label for="city111">Support Email-ID:</label> <input
												type="email" id="support_email_id" tabindex="9" class="form-control"
												data-toogle="tooltip" name="support_email_id" onchange="validateEmailSupport()" 
												placeholder="Enter Email-ID ">
												<span id="emailErrorSupportsred" style="color: red;"></span>
												   <span id="emailErrorsupportgreen" style="color: green;"></span>
										</div>

									</div>

									<div class="row">

										<div class="col-md-4">
											<label for="emailid25">Email-ID Contact Person:</label> <input
												type="email" id="emailid_contact_person" tabindex="10" class="form-control"
												data-toogle="tooltip" name="emailid_contact_person" onchange="validateEmailContact()"
												placeholder="Enter Email-ID">
												<span id="emailErrorcontactred" style="color: red;"></span>
												   <span id="emailErrorcontactgreen" style="color: green;"></span>
										</div>
										<div class="col-md-4">
											<label for="">Email-ID (Office):</label> <input
												type="email" id="office_mailid" tabindex="11"
												class="form-control" data-toogle="tooltip" name="office_mailid" onchange="validateEmailOffice()"
												placeholder="Enter Email-ID (Office)">
												<span id="emailErrorOfficered" style="color: red;"></span>
												   <span id="emailErrorOfficegreen" style="color: green;"></span>
										</div>
										<div class="col-md-4">
											<label for="city2424">City:</label> <input type="text" id="city"
												tabindex="12" class="form-control" data-toogle="tooltip"
												name="city" placeholder="Enter City" onkeydown="return alphaOnly(event);">
										</div>

									</div>

									<div class="row">

										<div class="col-md-4">
											<label for="district33">District:</label> <input type="text"
												id="district" tabindex="13" class="form-control"
												data-toogle="tooltip" name="district"
												placeholder="Enter District" onkeydown="return alphaOnly(event);">
										</div>
										<div class="col-md-4">
											<label for="state11">State:</label> <input type="text"
												id="state" tabindex="14" class="form-control"
												data-toogle="tooltip" name="state" placeholder="Enter State" onkeydown="return alphaOnly(event);">
										</div>
										<div class="col-md-4">
											<label for="pincode11">Pin:</label> <input type="text"
												id="pincode" tabindex="15" class="form-control" onchange="validatetepin()" onkeypress="validPinNumber(event)"
												data-toogle="tooltip" name="pincode"
												placeholder="Enter Pin Code">
												<span id="pincodered" style="color: red;"></span>
												   <span id="pincodegreen" style="color: green;"></span>
										</div>

									</div>

									<div class="row">

										<div class="col-md-4">
											<label for="">Country:</label>

											<!-- 											<input type="text" -->
											<!-- 												id="country" tabindex="4" class="form-control" -->
											<!-- 												data-toogle="tooltip" name="country" placeholder="Enter Country"> -->

											<select id="country" class="form-control" tabindex="16"
												data-toogle="tooltip" name="country"
												onchange="othercountrytax()">
												<option value="">Please Select Option</option>
												<option value="USA">USA</option>
												<option value="Canada">Canada</option>
												<option value="United Kingdom">United Kingdom</option>
												<option value="Japan">Japan</option>
												<option value="Australia">Australia</option>
												<option value="Brazil">Brazil</option>
												<option value="China">China</option>
												<option value="India" selected>India</option>
												<option value="Mexico">Mexico</option>
												<option value="Russia">Russia</option>
												<option value="South Africa">South Africa</option>
												<option value="Switzerland">Switzerland</option>
												<option value="New Zealand">New Zealand</option>
												<option value="South Korea">South Korea</option>
												<option value="Singapore">Singapore</option>
												<option value="Sweden">Sweden</option>
												<option value="Norway">Norway</option>
												<option value="Turkey">Turkey</option>
												<option value="Poland">Poland</option>
												<option value="Argentina">Argentina</option>
											</select>
										</div>
										<div class="col-md-4">
											<label for="website11">Website:</label> <input type="text"
												id="website" tabindex="17" class="form-control" onchange="validatetewebsite()"
												data-toogle="tooltip" name="website"
												placeholder="Enter Website">
												<span id="websitered" style="color: red;"></span>
												   <span id="websitegreen" style="color: green;"></span>
										</div>
										<div class="col-md-4">
											<label for="panacno11">PAN No:</label> <input type="text"
												id="panacno" tabindex="18" class="form-control" onchange="validatetepanno()"
												data-toogle="tooltip" name="panacno"
												placeholder="Enter PAN Card No">
												<span id="panacnored" style="color: red;"></span>
												   <span id="panacnogreen" style="color: green;"></span>
										</div>

									</div>

									<!-- 									<br> -->






									<!-- 									<div class="row"> -->

									<!-- 										<div class="col-md-4"></div> -->

									<!-- 										<div class="col-md-4" style="font-size: 14px; color: red;"> -->
									<!-- 											<strong>Ownership Type</strong> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-4"></div> -->
									<!-- 									</div> -->
									<!-- 									<br> -->



									<!-- 									<div class="row"> -->
									<!-- 										<div class="col-md-2"> -->

									<!-- 											<label for="proprietorship">Proprietorship:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->

									<!-- 												<input type="radio" id="proprietorship" name="ownership" -->
									<!-- 													tabindex="10" value="Proprietorship"> <label -->
									<!-- 													for="proprietorship"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="partnership">Partnership:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="partnership" name="ownership" -->
									<!-- 													value="Partnership" tabindex="10"> <label -->
									<!-- 													for="partnership"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="pvtltd">Private Limited:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="pvtltd" name="ownership" -->
									<!-- 													value="Private Limited" tabindex="10"> <label -->
									<!-- 													for="pvtltd"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="publtd">Public Limited:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="publtd" name="ownership" -->
									<!-- 													value="Public Limited" tabindex="10"> <label -->
									<!-- 													for="publtd"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-4"></div> -->

									<!-- 									</div> -->

									<div class="row">

										<div class="col-md-4">
											<label for="ownership11">Ownership Type:</label> 
											<select
												id="ownership" class="form-control" tabindex="19"
												data-toogle="tooltip" name="ownership">
												<option value="">Please Select Option</option>
												<option value="Proprietorship">Proprietorship</option>
												<option value="Partnership">Partnership</option>
												<option value="Private Limited">Private Limited</option>
												<option value="Public Limited">Public Limited</option>
											</select>
										</div>
										<div class="col-md-4">
											<label for="ownership111">Scale Of Company:</label> 
											<select
												id="scale_of_company" class="form-control" tabindex="20"
												data-toogle="tooltip" name="scale_of_company">
												<option value="">Please Select Option</option>
												<option value="Small Scale">Small Scale</option>
												<option value="Large Scale">Large Scale</option>
												<option value="Government">Government</option>
												<option value="System Integrator">System Integrator</option>
												<option value="OEM">OEM</option>
												<option value="Contractor">Contractor</option>
											</select>
										</div>
										<div class="col-md-4" id="indiacountrytax">
											<label for="gstin111">GSTIN:</label> <input type="text"
												id="gstin" tabindex="21" class="form-control"
												data-toogle="tooltip" name="gstin" placeholder="Enter GSTIN" onchange="validateGSTIN()">
												<span id="GSTINred" style="color: red;"></span>
												   <span id="GSTINgreen" style="color: green;"></span>
												
										</div>

<!-- 										<div class="col-md-4" id="indiacountrytax"> -->
<!-- 											<label for="gstin111">GSTIN:</label> <input type="text" -->
<!-- 												id="gstin" tabindex="21" class="form-control" -->
<!-- 												data-toggle="tooltip" name="gstin" placeholder="Enter GSTIN" -->
<!-- 												oninput="validateGSTIN(this)" -->
<!-- 												title="Enter a valid GSTIN"> -->
<!-- 											<small id="gstin-error" class="text-danger"></small> -->
<!-- 										</div> -->


										<div class="col-md-4" id="othercountrytax"
											style="display: none">
											<label for="">Other Country Tax No:</label> <input
												type="text" id="other_country" tabindex="22" class="form-control"
												data-toogle="tooltip" name="other_country"
												placeholder="Enter Other Country Tax">
										</div>

									</div>
									<!-- 									<br> -->

									<!-- 									<div class="row"> -->

									<!-- 										<div class="col-md-4"></div> -->

									<!-- 										<div class="col-md-4" style="font-size: 14px; color: red;"> -->
									<!-- 											<strong>Scale of Company</strong> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-4"></div> -->
									<!-- 									</div> -->
									<!-- 									<br> -->

									<!-- 									<div class="row"> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="smallscale">Small Scale:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="smallscale" name="typeofindustry" -->
									<!-- 													value="Small Scale" tabindex="10"> <label -->
									<!-- 													for="smallscale"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="largescale">Large Scale:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="largescale" name="typeofindustry" -->
									<!-- 													value="Large Scale" tabindex="10"> <label -->
									<!-- 													for="largescale"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="government">Government:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="government" name="typeofindustry" -->
									<!-- 													value="Government" tabindex="10"> <label -->
									<!-- 													for="government"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="systemintegrity">System Integrator:</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="systemintegrity" -->
									<!-- 													name="typeofindustry" value="System Integrity" -->
									<!-- 													tabindex="10"> <label for="systemintegrity"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="oem">OEM:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="oem" name="typeofindustry" -->
									<!-- 													value="OEM" tabindex="10"> <label for="oem"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-2"></div> -->

									<!-- 									</div> -->
									<!-- 									<br> -->
									<!-- 									<div class="row"> -->

									<!-- 										<div class="col-md-4"> -->
									<!-- 											<label for="panacno">PAN No:</label> <input type="text" -->
									<!-- 												id="panacno" tabindex="4" class="form-control" -->
									<!-- 												data-toogle="tooltip" name="panacno" -->
									<!-- 												placeholder="Enter PAN Card No"> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-4" id="indiacountrytax"> -->
									<!-- 											<label for="gstin">GSTIN:</label> <input type="text" -->
									<!-- 												id="gstin" tabindex="4" class="form-control" -->
									<!-- 												data-toogle="tooltip" name="gstin" placeholder="Enter GSTIN"> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-4" id="othercountrytax" -->
									<!-- 											style="display: none"> -->
									<!-- 											<label for="city">Other Country Tax No:</label> <input -->
									<!-- 												type="text" id="city" tabindex="3" class="form-control" -->
									<!-- 												data-toogle="tooltip" name="city" -->
									<!-- 												placeholder="Enter Other Country Tax"> -->
									<!-- 										</div> -->

									<!-- <!-- 										<div class="col-md-4" id="currencyupdate"> -->
									<!-- <!-- 											<label for="currency">Currency:</label> <select id="currency" -->
									<!-- <!-- 												class="form-control" tabindex="6" data-toogle="tooltip" -->
									<!-- <!-- 												name="currency"> -->
									<!-- <!-- 												Options will be populated here based on the selected country -->
									<!-- <!-- 											</select> -->
									<!-- <!-- 										</div> -->


									<!-- 									</div> -->
								</div>
							</div>



							<br>

							<div class="card card-secondary" id="registrationform2"
								style="display: none">
								<!-- 								<div class="card-header">Details</div> -->
								<div class="card-body">

									<div class="row" id="updateloginScopeDive">

										<!-- <div class="col-md-1"> Login Scope</div> -->
										<div class="card col-md-12">
											<div class="card-header">
												<strong>Details of
													Directors/Partners/Proprietor/Senior Manager</strong>
											</div>
											<div class="card-body">

												<div class="row">
													<div class="col-md-10"></div>
													<div class="col-md-2">
												
														<button type="button" tabindex="23"
															class="btn btn-sm btn-primary " onclick="addRow()"
															style="margin-left: 16px;">Add Row</button>

													</div>
												</div>
										

									
								

												<div class="row">
													<div class="col-md-1"></div>
													<div class="col-md-9">
														<table class="col-md-12" id="data-table">
															<thead>
																<tr>
																	<th>Name Of The Person:</th>
																	<th>Designation No:</th>
																	<th>Experience:</th>
																	<th>Actions</th>
																</tr>
															</thead>
															<tbody>
																<tr>
																	<td><input type="text" class="form-control" id="companyname"
																		tabindex="24" data-toogle="tooltip"
																		placeholder="Enter Person Name" ></td>
																	<td><input type="text" class="form-control " id="designationname"
																		tabindex="25" data-toogle="tooltip"
																		placeholder="Enter Designation" ></td>
																	<td><input type="text" class="form-control " id="experience"
																		tabindex="26" data-toogle="tooltip"
																		placeholder="Enter Experience"></td>

																	<td><button type="button" class="btn btn-danger"
																			onclick="deleteRow(this)">Delete</button></td>
																</tr>
															</tbody>
														</table>
													</div>
													<div class="col-md-1"></div>
												</div>


											</div>
										</div>

									</div>

									<div class="row">


										<div class="col-md-3">
											<label for="dateofbussns111">Date of Commencement of
												Business:</label>

										</div>
										<div class="col-md-3">
											<input type="date" id="dateofbussns" tabindex="27"
												class="form-control" data-toogle="tooltip"
												name="dateofbussns">
										</div>
										<div class="col-md-2">
											<!-- 											<label for="vatgstcategory">VAT-GST Category:</label> -->

										</div>
										<div class="col-md-3">
											<!-- 											<input type="text" id="vatgstcategory" tabindex="4" -->
											<!-- 												class="form-control" data-toogle="tooltip" -->
											<!-- 												name="vatgstcategory" placeholder="Enter Category"> -->
										</div>
										<div class="col-md-1"></div>

									</div>
									<br> <br>

									<!-- 									<div class="row"> -->

									<!-- 										<div class="col-md-5"></div> -->

									<!-- 										<div class="col-md-4" style="font-size: 14px; color: red;"> -->
									<!-- 											<strong>VAT-GST Category:</strong> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-4"></div> -->
									<!-- 									</div> -->
									<!-- 									<br> -->


									<!-- 									<div class="row"> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="registered">Registered:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="registered" name="gstcategory" -->
									<!-- 													value="Registered" tabindex="10"> <label -->
									<!-- 													for="registered"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="nonregistered">Non -->
									<!-- 												Registered:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="nonregistered" -->
									<!-- 													value="Non Registered" name="gstcategory" tabindex="10"> -->
									<!-- 												<label for="nonregistered"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-3"> -->
									<!-- 											<label for="composcheme">Composition -->
									<!-- 												Scheme:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="composcheme" name="gstcategory" -->
									<!-- 													value="Composition Scheme" tabindex="10"> <label -->
									<!-- 													for="composcheme"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-2"> -->
									<!-- 											<label for="government1">Government:&nbsp;&nbsp;</label> -->
									<!-- 											<div class="icheck-primary d-inline"> -->
									<!-- 												<input type="radio" id="government1" name="gstcategory" -->
									<!-- 													value="Government" tabindex="10"> <label -->
									<!-- 													for="government1"></label> -->
									<!-- 											</div> -->
									<!-- 										</div> -->
									<!-- 										<div class="col-md-3"></div> -->

									<!-- 									</div> -->
									<!-- 									<br> <br> -->
									<!-- 											<div class="row"> -->

									<!-- 										<div class="col-md-2"> -->
									<!-- 										<label for="certifivstgst">Certificate:&nbsp;&nbsp;</label> -->
									<!-- 									 </div> -->

									<!-- 										<div class="col-md-3" > -->
									<!-- 											<input type="file" id="certifivstgst" name="certifivstgst" -->
									<!-- 												class="form-control" style="height: 36px"> -->
									<!-- 										</div> -->
									<!-- 											<div class="col-md-3" >	</div> -->
									<!-- 											<div class="col-md-4" >	</div> -->

									<!-- 									</div> -->
									<!-- 									<br> -->

									<div class="row">

										<div class="col-md-4"></div>

										<div class="col-md-4" style="font-size: 14px; color: red;">
											<strong>Annual Turnover for the Last Three Years:</strong>
										</div>
										<div class="col-md-4"></div>
									</div>
									<br>

									<div class="row">
										<div class="col-md-1 ">
											<label for="currency11">Currency:</label>

										</div>
										<div class="col-md-3 ">

											<select id="currency" class="form-control" tabindex="27"
												data-toogle="tooltip" name="currency">
												<!-- Options will be populated here based on the selected country -->
											</select>


										</div>
										<div class="col-md-3 "></div>
										<div class="col-md-3 "></div>
										<div class="col-md-2 "></div>

									</div>
									<br>



									<div class="row">
										<div class="col-md-1 ">
											<label for="year3366363">Year:&nbsp;&nbsp;</label>

										</div>
										<div class="col-md-3 ">

											<input type="text" id="year1" name="year1" 
												class="form-control" tabindex="28" placeholder="Enter Year1"  oninput="this.value = this.value.replace(/[^0-9-]/g, '');">
												
												
											<label for=""></label>

										</div>
										<div class="col-md-3 ">

											<input type="text" id="year2" name="year2" 
												class="form-control" tabindex="29" placeholder="Enter Year2"  oninput="this.value = this.value.replace(/[^0-9-]/g, '');">
												
											<label for=""></label>
										</div>
										<div class="col-md-3 ">

											<input type="text" id="year3" name="year3" 
												class="form-control" tabindex="30" placeholder="Enter Year3"  oninput="this.value = this.value.replace(/[^0-9-]/g, '');">
												
											<label for=""></label>
										</div>
										<div class="col-md-2 "></div>

									</div>
									<br>

									<div class="row">
										<div class="col-md-1 ">
											<label for="rupees141">Amount:&nbsp;&nbsp;</label>

										</div>
										<div class="col-md-3 ">

											<input type="text" id="rupees1" name="rupees1" onchange="validateters1()"
												class="form-control" tabindex="31"
												placeholder="Enter Year1 Amount" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
												

										</div>
										<div class="col-md-3 ">

											<input type="text" id="rupees2" name="rupees2" onchange="validateters2()"
												class="form-control" tabindex="32"
												placeholder="Enter Year2 Amount" oninput="this.value = this.value.replace(/[^0-9]/g, '');"> 
											
										</div>
										<div class="col-md-3 ">

											<input type="text" id="rupees3" name="rupees3" onchange="validateters3()"
												class="form-control" tabindex="33"
												placeholder="Enter Year3 Amount" oninput="this.value = this.value.replace(/[^0-9]/g, '');">
												
										</div>
										<div class="col-md-2 "></div>

									</div>
									<br>
									<!-- 											<div class="row"> -->

									<!-- 										<div class="col-md-2"> -->
									<!-- 										<label for="financialturnover">Financial Turnover:&nbsp;&nbsp;</label> -->
									<!-- 									 </div> -->

									<!-- 										<div class="col-md-3" > -->
									<!-- 											<input type="file" id="financialturnover" name="financialturnover" -->
									<!-- 												class="form-control" style="height: 36px"> -->
									<!-- 										</div> -->
									<!-- 											<div class="col-md-3" >	</div> -->
									<!-- 											<div class="col-md-4" >	</div> -->

									<!-- 									</div> -->
									<!-- 									<br> -->

								</div>
							</div>

							<div class="card card-secondary" id="registrationform3"
								style="display: none">
								<!-- 								<div class="card-header">Details</div> -->
								<div class="card-body">

									<div class="row">
										<div class="col-md-3">

											<label>Is Company registered in GEM Portal?:</label>

										</div>
										<div class="col-md-3">
											<input type="radio" id="gemportal" name="gemportal1" tabindex="34"
												value="Yes">   <label for="">Yes</label>
											&nbsp;&nbsp;&nbsp; <input type="radio" id="gemportal2" tabindex="35"
												name="gemportal1" value="No">   <label
												for="">No</label>
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-3"> </div>

									</div>
									<br>

									<div class="row">
										<div class="col-md-3">

											<label>Is Company Registered in MSMED?:</label>

										</div>
										<div class="col-md-3">
											<input type="radio" id="msmedreg1" name="reg_msmed" value="Yes" tabindex="36"
												onchange="msmedregyes()">   <label for="">Yes</label>
											&nbsp;&nbsp;&nbsp; <input type="radio" id="msmedreg2" tabindex="37"
												name="reg_msmed" value="No" onchange="msmedregno()">   <label
												for="">No</label>
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-3"> </div>

									</div>
									<br>

									<div class="row" id="msmedeclrn" style="display: none">

										<div class="col-md-2"></div>

										<div class="col-md-8" style="font-size: 14px; color: red;">
											<strong>Declaration "MSMED" (Micro,Small and Medium
												Enterprise Development):</strong>
										</div>
										<div class="col-md-2"></div>
									</div>
									<br>
									<div class="row" id="msmedyestype" style="display: none" tabindex="38">
										<div class="col-md-3">

											<label>If YES, Type:</label>

										</div>
										<div class="col-md-4">
											<input type="radio" id="msmedtype1" name="msmedtype"
												value="Micro"> 
												  <label for="msmedtype1">Micro</label>
											&nbsp;&nbsp;&nbsp;
											 <input type="radio" id="msmedtype2"
												name="msmedtype" value="Small">
												 <label
												for="msmedtype2">Small</label>
												 &nbsp;&nbsp;&nbsp;
											<input
												type="radio" id="msmedtype3" name="msmedtype" value="Medium">
											  <label for="msmedtype3">Medium</label>
										</div>
										<div class="col-md-2"></div>
										<div class="col-md-3"> </div>

									</div>
									<br>

									<div class="row">
										<div class="col-md-4">
											<label for="entrepreno11111">Entrepreneur Memorandum (EM
												No. ):</label>

										</div>
										<div class="col-md-4 ">
											<input type="text" id="entrepreno" tabindex="39"
												class="form-control" data-toogle="tooltip" name="entrepreno"
												placeholder="Enter EM No">
										</div>
										<div class="col-md-4 "></div>

									</div>
									<br>

									<div class="row">

										<div class="col-md-2"></div>

										<div class="col-md-8" style="font-size: 14px; color: red;">
											<strong>Please Attach copy of following documents :</strong>
										</div>
										<div class="col-md-2"></div>
									</div>
									<br>

									<div class="row">

										<div class="col-md-2">
											<label for="incocertificate111" >Incorporation
												Certificate:&nbsp;&nbsp;</label>
										</div>

										<div class="col-md-3">
											<input type="file" id="incocertificate" tabindex="40"
												name="incocertificate" class="form-control"
												style="height: 36px">
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-4"></div>

									</div>
									<br>
									<div class="row">

										<div class="col-md-2">
											<label for="pancardfile111">PAN card:&nbsp;&nbsp;</label>
										</div>

										<div class="col-md-3">
											<input type="file" id="pancardfile" name="pancardfile" tabindex="41"
												class="form-control" style="height: 36px">
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-4"></div>

									</div>
									<br>
									<div class="row">

										<div class="col-md-2">
											<label for="gstcertificate1111">GST
												Certificate:&nbsp;&nbsp;</label>
										</div>

										<div class="col-md-3">
											<input type="file" id="gstcertificate" name="gstcertificate" tabindex="42"
												class="form-control" style="height: 36px">
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-4"></div>

									</div>
									<br>
									<div class="row">

										<div class="col-md-2">
											<label for="msmed111">MSMED:&nbsp;&nbsp;</label>
										</div>

										<div class="col-md-3">
											<input type="file" id="msmed" name="msmed" tabindex="43"
												class="form-control" style="height: 36px">
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-4"></div>

									</div>
									<br>
									<div class="row">

										<div class="col-md-2">
											<label for="cancelledcheque111">Cancelled
												Cheque:&nbsp;&nbsp;</label>
										</div>

										<div class="col-md-3">
											<input type="file" id="cancelledcheque" tabindex="44"
												name="cancelledcheque" class="form-control"
												style="height: 36px">
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-4"></div>

									</div>
									<br>

									<div class="row">

										<div class="col-md-2">
											<label for="turnovercertif1111">Last Year BS AND P&L:</label>
										</div>

										<div class="col-md-3">
											<input type="file" id="turnovercertif" name="turnovercertif" tabindex="45"
												class="form-control" style="height: 36px">
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-4"></div>

									</div>
									<br>
									<div class="row">

										<div class="col-md-2">
											<label for="msmeddocument111">MSMED Documents: (Only for
												MSMED registered Partners)</label>

										</div>

										<div class="col-md-3">
											<input type="file" id="msmeddocument" name="msmeddocument"tabindex="46"
												class="form-control" style="height: 36px">
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-4"></div>

									</div>
									<br>


									<div class="row">
<!-- 										<div class="col-md-6" style="margin-top: 15px;"> -->
<!-- 											<label for="rtype11">Checker</label> <select id="checker" -->
<!-- 												class="form-control" tabindex="8" data-toogle="tooltip" -->
<!-- 												name="checker" onchange="setLevelScope()"> -->
<!-- 												<option value="">-- Please Select --</option> -->
<!-- 												<option value="Nishi Maam">Nishi Gandha</option> -->
<!-- <!-- 												<option value="Smita Maam">Smita Shetty</option> --> 

<!-- 											</select> -->

<!-- 										</div> -->

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="rtype111">Authorizer</label> 
											<select  id="Authorizer"
												class="form-control" tabindex="47" data-toogle="tooltip"
												name="Authorizer">
												<option value="">-- Please Select Authorizer Name--</option>

											

											</select>

										</div>
											
										<div class="col-md-6" style="margin-top: 15px;">
										<label for="salesManager">Sales Manager</label> 
										<select  id="salesManager"
												class="form-control" tabindex="48" data-toogle="tooltip"
												name="salesManager">
												<option value="">-- Please Select Sales Manager--</option>
                                      </select>
										</div>
										
									</div>
									<br>
									<br>
									<div class="row">

										<div class="col-md-2"></div>


										<div class="col-md-8">
											<input type="checkbox" name="ideclaration" id="ideclaration" tabindex="49"
												value="Yes">&nbsp;&nbsp;, <label for="ideclaration">I
												declare that the information furnished above is correct to
												the best of my knowledge, I undertake to inform you at the
												earliest, any change in details mentioned above.</label>
										</div>
										<div class="col-md-2"></div>

									</div>
									<br>



									<div class="row">

										<div style="margin-top: 15px;" class="col-md-12">
											<center>
												<button type="button" tabindex="50"
													class="btn btn-primary m-t-10"  onclick="submitData()"
													name="submitregsform">Submit<span class="spinner-border"
												style="width: 1rem; height: 1rem; display: none;" id="spin"></button>

												<button type="button" tabindex="51"
													class="btn btn-primary m-t-10" id="resetregsform"
													name="resetregsform" value="Reset">Reset</button>
											</center>
										</div>

									</div>


</form>

						<br><br>
				<form  id="bulkuploaduserform" name="bulkuploaduserform" method="post" enctype="multipart/form-data">


<!--     <div class="card col-md-12"> -->
        <div class="card card-secondary">
            <div class="card-header">
                Bulk Upload (Insert Records)
                <a href="<%=request.getContextPath()%>/Master/DownloadRFfile" style="color: white" title='Download'>
                    <i class="fas fa-download float-right"></i>
                </a>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-4"></div>
                    <div style="margin-top: 10px;" class="col-md-4">
                        <input type="file" id="bulkUserData" name="bulkUserData" class="form-control" style="height: 36px">
                    </div>
                    <div class="col-md-4"></div>
                </div>
                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-8">
                        <span style="color: red">** Fields marked in Red are mandatory and should not be duplicate.</span>
                        <br> * Fields marked in Black are optional.
                        <br> * Kindly do not put null or blank value in any column; instead, put NA as the value.
                        <br> * Date Format Should be YYYY.MM.DD (e.g.2023.11.20)
                    </div>
                    <div class="col-md-2"></div>
                </div>
                <br>
                <div class="row">
                  	<div class="col-md-12 text-center">
											<input type="button" tabindex="0"
												class="btn btn-primary m-t-10" id="upload-btn" name="upload-btn"
												value="Upload" onclick="submitUploadbutton()"> <span
												class="spinner-border"
												style="width: 1rem; height: 1rem; display: none;" id="spin12"></span>
										</div>
                </div>
            </div>
        </div>
<!--     </div> -->
</form>


								</div>
							</div>



					
						
						

						
						
						
						
						
					</div>
					
				
					<div class="col-md-1"></div>

				</div>
			</section>
		</div>




		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
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
	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script>
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
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>


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
<script>
function alphaOnly(event) {
  var key = event.keyCode;`enter code here`
  return ((key >= 65 && key <= 90) || key == 8);
};

function validateGSTIN(input) {
    // GSTIN format: 2 characters (state code) followed by 13 characters
    const gstinPattern = /^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[0-9]{1}[0-9A-Z]{1}[0-9A-Z]{2}[0-9A-Z]{1}$/;

    const isValidGSTIN = gstinPattern.test(input.value);

    const errorElement = document.getElementById('gstin-error');

    if (!isValidGSTIN) {
        errorElement.textContent = 'Invalid GSTIN format';
        errorElement.style.color = 'red';
        input.style.borderColor = 'red';
    } else {
        errorElement.textContent = 'Valid GSTIN format';
        errorElement.style.color = 'green';
        input.style.borderColor = 'green';
    }
}


</script>
	<script
		src="<%=request.getContextPath()%>/static/custom/customer_master.js"></script>
</body>

</html>


