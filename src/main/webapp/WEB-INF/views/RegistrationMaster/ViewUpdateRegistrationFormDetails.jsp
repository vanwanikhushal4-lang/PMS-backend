<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Registration Form Details</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/fontawesome.min.css">

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
<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
  
   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/Datepicker/css/bootstrap-datepicker.min.css"> --%>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">

<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
  
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.css" type="text/css"/> --%>


<style type="text/css">
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

          

        %>
    </script>




</head>
<body class="hold-transition sidebar-mini layout-fixed">

	<input type="hidden" id="crnoo" name="crnoo" value="<%=crno%>">

	<input type="hidden" id="tid" name="tid" value="<%=tid%>">


	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>
			

				<div style="padding-left: 15px; padding-right: 15px">

					<div class="card card-secondary border-secondary">
<form id="form" name="form" method="post"
				enctype="multipart/form-data">
						<div class="card-header">
							<div class="row">
								<div class="col-md-4">Update Registration Form Details</div>

								<div class="col-md-7"></div>

								<div class="col-md-1">
									<a
										href="<%=request.getContextPath()%>/User/updateRegistrationFormBySI">
										<i class="fa fa-backward pull-right" style="color: black">
									</i>
									</a>
								</div>


							</div>

						</div>

						<div class="card-body">


							<div class="row">
								<div class="col-md-2"></div>
								<div class="card col-md-8">
									<div class="card-header">
										<strong>Categoty Type Master</strong>
									</div>
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
												<label for="">Under which Distributor</label>

												<div id="distributornamediv">


													<select id="distributorname" class="form-control"
														data-toogle="tooltip" name="distributorname">
													</select>


												</div>
											</div>
											<div class="col-md-1"></div>
										</div>


										<div class="row mt-2" id="customer" style="display: none">

											<div class="col-md-1"></div>
											<div class="col-md-10">
												<label for="">Under which Partner</label>
												<div id="partnerrnamediv">



													<select id="partnername" class="form-control"
														data-toogle="tooltip" name="partnername">
													</select>


												</div>
											</div>
											<div class="col-md-1"></div>
										</div>



									</div>
								</div>
								<div class="col-md-2"></div>
							</div>

							<br>

							<div class="row">

								<div class="col-md-4"></div>
								<div class="col-md-4"
									style="margin-left: 65px; font-size: 15px; color: red;">
									<strong>Registration Form</strong>
								</div>
								<div class="col-md-4"></div>
							</div>
							<br>
							<div class="row">


								<div class="col-md-4">
									<label for="compname">Name Of The Company: </label> <input
										type="text" id="compname" tabindex="1" class="form-control"
										data-toogle="tooltip" name="compname" placeholder="Enter Name">
								</div>

								<div class="col-md-4">
									<label for="registerno">Registration No:</label> <input
										type="text" id="registerno" tabindex="5" class="form-control"
										data-toogle="tooltip" name="registerno"
										placeholder="Enter Registration No">
								</div>

								<div class="col-md-4">
									<label for="address">Address:</label> <input type="text"
										id="address" tabindex="6" class="form-control"
										data-toogle="tooltip" name="address"
										placeholder="Enter Address">
								</div>

							</div>
							<br>
							<div class="row">

								<div class="col-md-4">
									<label for="personname">Contact Person Name:</label> <input
										type="text" id="personname" class="form-control"
										data-toogle="tooltip" name="personname"
										placeholder="Enter Person Name">
								</div>

								<div class="col-md-4">
									<label for="mobno">Mobile No:</label> <input type="number"
										id="mobno" class="form-control" data-toogle="tooltip"
										name="mobno" placeholder="Enter Mobile No">
								</div>
								<div class="col-md-4">
									<label for="telpno">Telephone No:</label> <input type="number"
										id="telpno" class="form-control" data-toogle="tooltip"
										name="telpno" placeholder="Enter Telephone No">
								</div>



							</div>
							<br>
							<div class="row">

								<div class="col-md-4">
									<label for="Md_Ceo_emailid">MD/CEO Email-ID:</label> <input
										type="email" id="Md_Ceo_emailid" tabindex="4"
										class="form-control" data-toogle="tooltip"
										name="Md_Ceo_emailid" placeholder="Enter Email-ID">
								</div>
								<div class="col-md-4">
									<label for="Sales_emailid">Sales Email-ID:</label> <input
										type="email" id="Sales_emailid" tabindex="4"
										class="form-control" data-toogle="tooltip"
										name="Sales_emailid" placeholder="Enter Email-ID">
								</div>
								<div class="col-md-4">
									<label for="support_email_id">Support Email-ID:</label> <input
										type="text" id="support_email_id" tabindex="3"
										class="form-control" data-toogle="tooltip"
										name="support_email_id" placeholder="Enter Email-ID ">
								</div>

							</div>
							<br>
							<div class="row">

								<div class="col-md-4">
									<label for="emailid_contact_person">Email-ID Contact
										Person:</label> <input type="text" id="emailid_contact_person"
										tabindex="4" class="form-control" data-toogle="tooltip"
										name="emailid_contact_person" placeholder="Enter Email-ID">
								</div>
								<div class="col-md-4">
									<label for="office_mailid">Email-ID (Office):</label> <input
										type="text" id="office_mailid" tabindex="4"
										class="form-control" data-toogle="tooltip"
										name="office_mailid" placeholder="Enter Email-ID (Office)">
								</div>
								<div class="col-md-4">
									<label for="city">City:</label> <input type="text" id="city"
										tabindex="3" class="form-control" data-toogle="tooltip"
										name="city" placeholder="Enter City">
								</div>

							</div>
							<br>
							<div class="row">

								<div class="col-md-4">
									<label for="district">District:</label> <input type="text"
										id="district" tabindex="4" class="form-control"
										data-toogle="tooltip" name="district"
										placeholder="Enter District">
								</div>
								<div class="col-md-4">
									<label for="state">State:</label> <input type="text" id="state"
										tabindex="4" class="form-control" data-toogle="tooltip"
										name="state" placeholder="Enter State">
								</div>
								<div class="col-md-4">
									<label for="pincode">Pin:</label> <input type="number"
										id="pincode" tabindex="3" class="form-control"
										data-toogle="tooltip" name="pincode"
										placeholder="Enter Pin Code">
								</div>

							</div>
							<br>
							<div class="row">

								<div class="col-md-4">
									<label for="Country">Country:</label>

									<!-- 											<input type="text" -->
									<!-- 												id="country" tabindex="4" class="form-control" -->
									<!-- 												data-toogle="tooltip" name="country" placeholder="Enter Country"> -->

									<input type="text" id="country" class="form-control"
										tabindex="6" data-toogle="tooltip" name="country"
										placeholder="Enter Country">

								</div>
								<div class="col-md-4">
									<label for="website">Website:</label> <input type="text"
										id="website" tabindex="4" class="form-control"
										data-toogle="tooltip" name="website"
										placeholder="Enter Website">
								</div>
								<div class="col-md-4">
									<label for="panacno">PAN No:</label> <input type="text"
										id="panacno" tabindex="4" class="form-control"
										data-toogle="tooltip" name="panacno"
										placeholder="Enter PAN Card No">
								</div>

							</div>

							<br>
							<div class="row">

								<div class="col-md-4">
									<label for="ownership">Ownership Type:</label>
									<!-- 								<input -->
									<!-- 									type="text" id="ownership" class="form-control" tabindex="6" -->
									<!-- 									data-toogle="tooltip" name="ownership" > -->

									<select id="ownership" class="form-control" tabindex="19"
										data-toogle="tooltip" name="ownership">
										<option value="">Please Select Option</option>
										<option value="Proprietorship">Proprietorship</option>
										<option value="Partnership">Partnership</option>
										<option value="Private Limited">Private Limited</option>
										<option value="Public Limited">Public Limited</option>
									</select>

								</div>
								<div class="col-md-4">
									<label for="scaleofcmpy">Scale Of Company:</label>
									<!-- 								<input -->
									<!-- 									type="text" id="scaleofcmpy" class="form-control" tabindex="6" -->
									<!-- 									data-toogle="tooltip" name="scaleofcmpy" > -->
									<select id="SCALE_OF_COMPANY" class="form-control"
										tabindex="20" data-toogle="tooltip" name="SCALE_OF_COMPANY">
										<option value="">Please Select Option</option>
										<option value="Small Scale">Small Scale</option>
										<option value="Large Scale">Large Scale</option>
										<option value="Government">Government</option>
										<option value="System Integrator">System Integrator</option>
										<option value="OEM">OEM</option>
									</select>


								</div>
								<div class="col-md-4" id="indiacountrytax">
									<label for="gstin">GSTIN:</label> <input type="text" id="gstin"
										tabindex="4" class="form-control" data-toogle="tooltip"
										name="gstin" placeholder="Enter GSTIN">
								</div>
								<div class="col-md-4" id="othercountrytax" style="display: none">
									<label for="cuntrytaxno">Other Country Tax No:</label> <input
										type="text" id="cuntrytaxno" tabindex="3" class="form-control"
										data-toogle="tooltip" name="cuntrytaxno"
										placeholder="Enter Other Country Tax">
								</div>

							</div>

						</div>



						<br>
						<div class="row">
							<div class="col-md-12">


								<ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
									<li class="nav-item"><a class="nav-link active"
										id="custom-tabs-one-home-tab" data-toggle="pill"
										href="#custom-tabs-one-home" role="tab"
										aria-controls="custom-tabs-one-home" aria-selected="true">Details</a>
									</li>

									<li class="nav-item"><a class="nav-link"
										id="custom-tabs-one-messages-tab" data-toggle="pill"
										href="#custom-tabs-one-messages" role="tab"
										aria-controls="custom-tabs-one-messages" aria-selected="false">Uploads</a>
									</li>

<!-- 									<li class="nav-item"><a class="nav-link" -->
<!-- 										id="custom-tabs-one-download-tab" data-toggle="pill" -->
<!-- 										href="#custom-tabs-one-download" role="tab" -->
<!-- 										aria-controls="custom-tabs-one-download" aria-selected="false">Download</a> -->
<!-- 									</li> -->
								</ul>


								<div class="tab-content">
									<div class="tab-pane fade show active"
										id="custom-tabs-one-home" role="tabpanel"
										aria-labelledby="custom-tabs-one-home-tab">
										<br>
										<div class="row">
											<div class="col-md-1"></div>
											<div class="col-md-10">


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

																	<!-- 														<button type="button" tabindex="23" -->
																	<!-- 															class="btn btn-sm btn-primary " onclick="addRow()" -->
																	<!-- 															style="margin-left: 16px;">Add Row</button> -->

																</div>
															</div>


															<br>


															<div class="row">
																<!-- 													<div class="col-md-1"></div> -->
																<div class="col-md-12">
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
																				<td><input type="text" class="form-control"
																					id="companyname" tabindex="24"
																					data-toogle="tooltip"
																					placeholder="Enter Person Name"></td>
																				<td><input type="text" class="form-control "
																					id="designationname" tabindex="25"
																					data-toogle="tooltip"
																					placeholder="Enter Designation"></td>
																				<td><input type="text" class="form-control "
																					id="experience" tabindex="26" data-toogle="tooltip"
																					placeholder="Enter Experience"></td>

																				<td>
																					<!-- 																	<button type="button" class="btn btn-danger" -->
																					<!-- 																			onclick="deleteRow(this)">Delete</button> -->

																					<button type="button"
																						class="btn btn-sm btn-primary " onclick="addRow()"
																						style="margin-left: 16px;">Add Row</button>
																				</td>
																			</tr>
																		</tbody>
																	</table>
																</div>
																<!-- 													<div class="col-md-1"></div> -->
															</div>


														</div>
													</div>

												</div>

												<br>
												<div class="row">


													<div class="col-md-3">
														<label for="dateofbussns">Date of Commencement of
															Business:</label>

													</div>
													<div class="col-md-3">
														<input type="date" id="dateofbussns" tabindex="4"
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
														<label for="currency">Currency:</label>

													</div>
													<div class="col-md-3 ">

														<input id="currency" class="form-control" tabindex="6"
															data-toogle="tooltip" name="currency"
															placeholder="Enter Currency">


													</div>
													<div class="col-md-3 "></div>
													<div class="col-md-3 "></div>
													<div class="col-md-2 "></div>

												</div>
												<br>



												<div class="row">
													<div class="col-md-1 ">
														<label for="year">Year:&nbsp;&nbsp;</label>

													</div>
													<div class="col-md-3 ">

														<input type="text" id="year1" name="year1"
															class="form-control" tabindex="10"
															placeholder="Enter Year1"> <label for="year"></label>

													</div>
													<div class="col-md-3 ">

														<input type="text" id="year2" name="year2"
															class="form-control" tabindex="10"
															placeholder="Enter Year2"> <label for="year"></label>
													</div>
													<div class="col-md-3 ">

														<input type="text" id="year3" name="year3"
															class="form-control" tabindex="10"
															placeholder="Enter Year3"> <label for="year"></label>
													</div>
													<div class="col-md-2 "></div>

												</div>
												<br>

												<div class="row">
													<div class="col-md-1 ">
														<label for="rupees">Amount:&nbsp;&nbsp;</label>

													</div>
													<div class="col-md-3 ">

														<input type="text" id="rupees1" name="rupees1"
															class="form-control" tabindex="10"
															placeholder="Enter Year1 Amount"> <label
															for="year"></label>

													</div>
													<div class="col-md-3 ">

														<input type="text" id="rupees2" name="rupees2"
															class="form-control" tabindex="10"
															placeholder="Enter Year2 Amount"> <label
															for="year"></label>
													</div>
													<div class="col-md-3 ">

														<input type="text" id="rupees3" name="rupees3"
															class="form-control" tabindex="10"
															placeholder="Enter Year3 Amount"> <label
															for="year"></label>
													</div>
													<div class="col-md-2 "></div>

												</div>
												<br>

								
												<div class="row">

													<div class="col-md-4">

														<label>Are you registered in GEM Portal?:</label> <select
															id="gemportal1" class="form-control"
															data-toogle="tooltip" name="gemportal1">
															<option value="">Please Select Option</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>

														</select>

													</div>

													<div class="col-md-4">

														<label>Are you MSMED Registered?:</label> <select
															id="msmedreg1" class="form-control" data-toogle="tooltip"
															name="msmedreg1" onchange="msmedreg()">
															<option value="">Please Select Option</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>

														</select>

													</div>


													<div class="col-md-4" style="display: none;"
														id="msmedtypeDIV">
														<label>If Yes, Type:</label> <select id="msmedtype"
															class="form-control" data-toogle="tooltip"
															name="msmedtype">
															<option value="">Please Select Option</option>
															<option value="Micro">Micro</option>
															<option value="Small">Small</option>
															<option value="Medium">Medium</option>
														</select>  
													</div>

												</div>
												<br>

<!-- 												<div class="row" id="msmedeclrn" style="display: none"> -->

<!-- 													<div class="col-md-2"></div> -->

<!-- 													<div class="col-md-8" style="font-size: 14px; color: red;"> -->
<!-- 														<strong>Declaration "MSMED" (Micro,Small and -->
<!-- 															Medium Enterprise Development):</strong> -->
<!-- 													</div> -->
<!-- 													<div class="col-md-2"></div> -->
<!-- 												</div> -->
<!-- 												<br> -->
<!-- 												<div class="row" id="msmedyestype" style="display: none"> -->
<!-- 													<div class="col-md-3"> -->

<!-- 														<label>If YES, Type:</label> -->

<!-- 													</div> -->
<!-- 													<div class="col-md-4"> -->
<!-- 														<input type="radio" id="msmedtype1" name="msmedtype" -->
<!-- 															value="Micro">   <label for="msmedtype1">Micro</label> -->
<!-- 														&nbsp;&nbsp;&nbsp; <input type="radio" id="msmedtype2" -->
<!-- 															name="msmedtype" value="Small">   <label -->
<!-- 															for="msmedtype2">Small</label> &nbsp;&nbsp;&nbsp;<input -->
<!-- 															type="radio" id="msmedtype3" name="msmedtype" -->
<!-- 															value="Medium">   <label for="msmedtype3">Medium</label> -->
<!-- 													</div> -->
<!-- 													<div class="col-md-2"></div> -->
<!-- 													<div class="col-md-3"> </div> -->

<!-- 												</div> -->
												<br>

												<div class="row">
													<div class="col-md-4">
														<label for="entrepreno">Entrepreneur Memorandum
															(EM No. ):</label>

													</div>
													<div class="col-md-4 ">
														<input type="text" id="entrepreno" tabindex="4"
															class="form-control" data-toogle="tooltip"
															name="entrepreno" placeholder="Enter EM No">
													</div>
													<div class="col-md-4 "></div>

												</div>
												<br> <br> <br>
											</div>





											<div class="col-md-1"></div>

										</div>
										<br>


									</div>

									<div class="tab-pane fade" id="custom-tabs-one-messages"
										role="tabpanel" aria-labelledby="custom-tabs-one-messages-tab">


										<br>
										<div class="row">

											<div class="col-md-1"></div>
											<div class="col-md-10">






												<div class="row">

													<div class="col-md-2"></div>

													<div class="col-md-8" style="font-size: 14px; color: red;">
														<strong>Upload Documents :</strong>
													</div>
													<div class="col-md-2"></div>
												</div>
												<br>


												<div class="row">

													<div class="col-md-2">
														<label for="incocertificate111">Incorporation
															Certificate:&nbsp;&nbsp;</label>
													</div>

													<div class="col-md-3">
														<input type="file" id="incocertificate" tabindex="40"
															name="incocertificate" class="form-control"
															style="height: 36px">
													</div>

													<div class="col-md-1"></div>
													<div class="col-md-3">

														<label for="commercialProp1">Commercial Proposal
															:&nbsp;&nbsp;</label>
													</div>
													<div class="col-md-3">

														<input type="file" id="commercialProp1" tabindex="40"
															name="commercialProp1" class="form-control"
															style="height: 36px">
													</div>

												</div>
												<br>
												<div class="row">

													<div class="col-md-2">
														<label for="pancardfile111">PAN card:&nbsp;&nbsp;</label>
													</div>

													<div class="col-md-3">
														<input type="file" id="pancardfile" name="pancardfile"
															tabindex="41" class="form-control" style="height: 36px">
													</div>


													<div class="col-md-1"></div>
													<div class="col-md-3">

														<label for="pucrhaseOrder1">Purchase Order
															:&nbsp;&nbsp;</label>
													</div>
													<div class="col-md-3">

														<input type="file" id="pucrhaseOrder1" tabindex="40"
															name="pucrhaseOrder1" class="form-control"
															style="height: 36px">
													</div>

												</div>
												<br>
												<div class="row">

													<div class="col-md-2">
														<label for="gstcertificate1111">GST
															Certificate:&nbsp;&nbsp;</label>
													</div>

													<div class="col-md-3">
														<input type="file" id="gstcertificate"
															name="gstcertificate" tabindex="42" class="form-control"
															style="height: 36px">
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
														<label for="turnovercertif1111">Last Year BS AND
															P&L:</label>
													</div>

													<div class="col-md-3">
														<input type="file" id="turnovercertif"
															name="turnovercertif" tabindex="45" class="form-control"
															style="height: 36px">
													</div>
													<div class="col-md-3"></div>
													<div class="col-md-4"></div>

												</div>
												<br>
												<div class="row">

													<div class="col-md-2">
														<label for="msmeddocument111">MSMED Documents:
															(Only for MSMED registered Partners)</label>

													</div>

													<div class="col-md-3">
														<input type="file" id="msmeddocument" name="msmeddocument"
															tabindex="46" class="form-control" style="height: 36px">
													</div>
													<div class="col-md-3"></div>
													<div class="col-md-4"></div>

												</div>
												<br> <br>


												<div class="row">
													<div class="col-md-6" style="margin-top: 15px;">

														<label for="Authorizer">Authorizer</label>
														<!-- 													<input -->
														<!-- 														type="text" id="Authorizer" class="form-control" -->
														<!-- 														tabindex="8" data-toogle="tooltip" name="Authorizer" -->
														<!-- 														> -->

														<select id="Authorizer" class="form-control" tabindex="47"
															data-toogle="tooltip" name="Authorizer">
															<option value="">-- Please Select Authorizer
																Name--</option>
														</select>

													</div>

													<div class="col-md-6" style="margin-top: 15px;">

														<label for="salesManager">Sales Manager</label>
														<!-- 													<input -->
														<!-- 														type="text" id="salesManager" class="form-control" -->
														<!-- 														tabindex="8" data-toogle="tooltip" name="salesManager"> -->

														<select id="salesManager" class="form-control"
															tabindex="48" data-toogle="tooltip" name="salesManager">
															<option value="">-- Please Select Sales
																Manager--</option>
														</select>

													</div>
												</div>
												<br> <br>
												<!-- 									<div class="row"> -->

												<!-- 										<div class="col-md-2"></div> -->


												<!-- 										<div class="col-md-8"> -->
												<!-- 											<input type="checkbox" name="ideclaration" id="ideclaration" -->
												<!-- 												value="Yes">&nbsp;&nbsp;, <label for="ideclaration">I -->
												<!-- 												declare that the information furnished above is correct to -->
												<!-- 												the best of my knowledge, I undertake to inform you at the -->
												<!-- 												earliest, any change in details mentioned above.</label> -->
												<!-- 										</div> -->
												<!-- 										<div class="col-md-2"></div> -->

												<!-- 									</div> -->
												<br>















											</div>
											<div class="col-md-1"></div>





										</div>
									</div>




									



								</div>
							</div>


						</div>
						
						
						</form>
						
						<div class="row">
						
											<div class="col-md-1"></div>
											<div class="col-md-10">






												<div class="row">

													<div class="col-md-2"></div>

													<div class="col-md-8" style="font-size: 14px; color: red;">
														<strong>Copies of Documents :</strong>
													</div>
													<div class="col-md-2"></div>
												</div>
												<br>

												<div class="row">

													<div style="margin-top: 15px; display: none;"
														class="col-md-6" id="poUploadDiv21">
														<label style="margin-left: 2px"> Incorporation
															Certificate:<br> <span class="vlx"
															style="color: green; width: 450px" id="pouploadfile21"></span>
														</label>
														<button class="button1 button4" id="downHidepofile21"
															onclick="downFileStandard21()">Download</button>
													</div>
													<input type="hidden" id="filenameStandard21"
														name="filenameStandard21">

													<div style="margin-top: 15px; display: none;"
														class="col-md-6" id="pancrdDiv21">
														<label style="margin-left: 2px"> Pan Card:<br>
															<span class="vlx" style="color: green; width: 450px"
															id="pancardfile21"></span></label>
														<button class="button1 button4" id="downHidepancardfile21"
															onclick="downpancradFileStandard21()">Download</button>
													</div>
													<input type="hidden" id="pancardfilenameStandard21"
														name="pancardfilenameStandard21">

												</div>
												<br>
												<div class="row">



													<div style="margin-top: 15px; display: none;"
														class="col-md-6" id="gstUploadDiv21">
														<label style="margin-left: 2px"> GST Certificate:<br>
															<span class="vlx" style="color: green; width: 450px"
															id="gstuploadfile21"></span></label>
														<button class="button1 button4" id="downHidegstfile21"
															onclick="downgstFileStandard21()">Download</button>
													</div>
													<input type="hidden" id="gstfilenameStandard21"
														name="gstfilenameStandard21">

													<div style="margin-top: 15px; display: none;"
														class="col-md-6" id="mesmedDiv21">
														<label style="margin-left: 2px"> MSMED:<br> <span
															class="vlx" style="color: green; width: 450px"
															id="msmedfile21"></span></label>
														<button class="button1 button4" id="downHidemsmedfile21"
															onclick="downmsmedFileStandard21()">Download</button>
													</div>
													<input type="hidden" id="msmedfilenameStandard21"
														name="msmedfilenameStandard21">


												</div>
												<br>
												<div class="row">

													<div style="margin-top: 15px; display: none;"
														class="col-md-6" id="cancCheqUploadDiv21">
														<label style="margin-left: 2px"> Cancelled Cheque:<br>
															<span class="vlx" style="color: green; width: 450px"
															id="cancChequploadfile21"></span></label>
														<button class="button1 button4"
															id="downHidecancCheqfile21"
															onclick="downcancCheqFileStandard21()">Download</button>
													</div>
													<input type="hidden" id="cancCheqfilenameStandard21"
														name="cancCheqfilenameStandard21">

													<div style="margin-top: 15px; display: none;"
														class="col-md-6" id="lstBSPLDiv21">
														<label style="margin-left: 2px">Last Year BS AND
															P&L:<br> <span class="vlx"
															style="color: green; width: 450px" id="lstBSPLfile21"></span>
														</label>
														<button class="button1 button4" id="downHidelstBSPLfile21"
															onclick="downlstBSPLFileStandard21()">Download</button>
													</div>
													<input type="hidden" id="lstBSPLfilenameStandard21"
														name="lstBSPLfilenameStandard21">



												</div>


												<br>
												<div class="row">




													<div style="margin-top: 15px; display: none;"
														class="col-md-6" id="msmedPartnUploadDiv21">
														<label style="margin-left: 2px"> MSMED Documents:
															(Only for MSMED registered Partners)<br> <span
															class="vlx" style="color: green; width: 450px"
															id="msmedPartnuploadfile21"></span>
														</label>
														<button class="button1 button4"
															id="downHidemsmedPartnfile21"
															onclick="downmsmedPartnFileStandard21()">Download</button>
													</div>
													<input type="hidden" id="msmedPartnfilenameStandard21"
														name="msmedPartnfilenameStandard21">




													<div style="margin-top: 15px; display: none;"
														class="col-md-6" id="commercialPropDIV21">
														<label style="margin-left: 2px">Commercial
															Proposal:<br> <span class="vlx"
															style="color: green; width: 450px" id="commPropfile21"></span>
														</label>
														<button class="button1 button4"
															id="downHideCommPropfile21"
															onclick="downCommPropFileStandard21()">Download</button>
													</div>
													<input type="hidden" id="commPropfilenameStandard21"
														name="commPropfilenameStandard21">



												</div>
												<br>

												<div class="row">




													<div style="margin-top: 15px; display: none;"
														class="col-md-6" id="purchaseOrderUploadDiv27">
														<label style="margin-left: 2px"> Purchase Order<br>
															<span class="vlx" style="color: green; width: 450px"
															id="pouploadfile27"></span></label>
														<button class="button1 button4" id="downHidePOfile27"
															onclick="downPOFileStandard27()">Download</button>
													</div>
													<input type="hidden" id="pofilenameStandard27"
														name="pofilenameStandard27">




													<div style="margin-top: 15px;" class="col-md-6"></div>


												</div>
												<br>


											</div>
											<div class="col-md-1"></div>


						
						
						</div>
						
						<br>
									<div class="row">

										<div class="col-md-2"></div>


										<div class="col-md-8">
											<input type="checkbox" name="ideclaration" id="ideclaration"
												tabindex="49" value="Yes">&nbsp;&nbsp;, <label
												for="ideclaration">I declare that the information
												furnished above is correct to the best of my knowledge, I
												undertake to inform you at the earliest, any change in
												details mentioned above.</label>
										</div>
										<div class="col-md-2"></div>

									</div>
									<br>
									<div class="row">

										<div style="margin-top: 15px;" class="col-md-12">
											<center>
												<button type="button" tabindex="50"
													class="btn btn-primary m-t-10" onclick="updateData()"
													name="submitregsform">
													Update<span class="spinner-border"
														style="width: 1rem; height: 1rem; display: none;"
														id="spin">
												</button>

												<button type="button" tabindex="51"
													class="btn btn-primary m-t-10" id="resetregsform"
													name="resetregsform" value="Reset">Reset</button>
											</center>
										</div>

									</div>

									<br>
					</div>
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				</div>

			

		</div>

<!-- 		<br> -->
		<!-- /.card -->



<!-- 	</div> -->


<!-- 	</div> -->





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

	<!--<script src="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>-->
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

	<%-- <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.js"></script>
    
   <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.min.js"></script>

<script src="<%=request.getContextPath()%>/static/Datepicker/js/bootstrap-datepicker.min.js"></script> --%>


	<script
		src="<%=request.getContextPath()%>/static/custom/ViewUpdateRegistrationFormDetails.js"></script>

</body>
</html>