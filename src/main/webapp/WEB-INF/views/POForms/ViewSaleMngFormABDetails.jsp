<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Purchase Order</title>
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

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">
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
<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

.datetimepicker {
	z-index: 1071 !important;
}

<
style type ="text /css">.card {
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
	<input type="hidden" id="form3status" name="form3status" value="">

	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>

			<div style="padding-left: 15px; padding-right: 15px">

				<div class="card card-secondary border-secondary">

					<div class="card-header">
						<div class="row">
							<div class="col-md-4">Document Approval of Purchase Order</div>

							<div class="col-md-7"></div>

							<div class="col-md-1">
								<a href="<%=request.getContextPath()%>/User/pendingSMFormApp">
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
								<label for="ponumber">Purchase Order No</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="email"></label> <input type="text" id="ponumber"
									tabindex="1" class="form-control" name="ponumber"
									data-toogle="tooltip" placeholder="Enter PO No" readonly>
							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="podate">Purchase Order Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="email"></label> <input type="text" id="podate" tabindex="1"
									class="form-control" name="podate" data-toogle="tooltip"
									readonly>
							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="proddescrip">Product Description</label><label
									id="bname1"></label>
								<div class="form-group" id="proddescrip11">
									<input type="text" id="proddescrip" tabindex="1"
										class="form-control" name="proddescrip" data-toogle="tooltip"
										placeholder="Enter Product Description" readonly>
								</div>

							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="customername">Customer Name</label> <input
									type="text" class="form-control" tabindex="1" id="customername"
									name="customername" data-toogle="tooltip"
									placeholder="Enter Customer Name" readonly>
							</div>

							<div style="margin-top: 15px;" class="col-md-6">
								<label for="productSuit">Product Suit</label> <input type="text"
									class="form-control" tabindex="1" id="productSuit"
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
								<label for="paymentterms">Payment Terms</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="email"></label> <input type="text" id="paymentterms"
									tabindex="1" class="form-control" name="paymentterms"
									data-toogle="tooltip" placeholder="Enter Payment Terms"
									readonly="true">
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

							<div style="margin-top: 15px; display: none;"
								id="warrantystartDiv" class="col-md-6">
								<label for="warrantystart">Warranty Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="warrantystart"
									tabindex="1" class="form-control" name="warrantystart"
									data-toogle="tooltip" readonly>
							</div>

							<div style="margin-top: 15px; display: none;" id="warrantyendDiv"
								class="col-md-6">

								<label for="warrantyend">Warranty End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="warrantyend"
									tabindex="1" class="form-control" name="warrantyend"
									data-toogle="tooltip" readonly>

							</div>

							<div style="margin-top: 15px; display: none;"
								id="amcstartdateDiv" class="col-md-6">
								<label for="amcstartdate">AMC Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="amcstartdate"
									tabindex="1" class="form-control" name="amcstartdate"
									data-toogle="tooltip" readonly>
							</div>

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="amcenddateDiv">

								<label for="amcenddate">AMC End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="amcenddate"
									tabindex="1" class="form-control" name="amcenddate"
									data-toogle="tooltip" readonly>

							</div>

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="tennurestartdateDiv">
								<label for="tennurestartdate">Tennure Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="tennurestartdate"
									tabindex="1" class="form-control" name="tennurestartdate"
									data-toogle="tooltip" readonly>
							</div>

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="tennureenddateDiv">

								<label for="tennureenddate">Tennure End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="tennureenddate"
									tabindex="1" class="form-control" name="tennureenddate"
									data-toogle="tooltip" readonly>

							</div>




							<div style="margin-top: 15px; display: none;" class="col-md-6">
								<label for="change">Advance Invoice, if Yes/NO </label><label
									id="phnnno"></label> <input type="text" id="advaninvoice"
									tabindex="1" class="form-control" name="advaninvoice"
									data-toogle="tooltip" placeholder="Add Invoice Yes/No" readonly>

							</div>

							<!--                                       <div style="margin-top:15px;" class="col-md-6"> -->
							<!--                                        <label style="margin-left: 2px">File Attachment:<br> -->
							<!--                                                 <span class="vlx" style="color: green;width: 450px" id="pouploadfile"></span></label><button class="button1 button4" id="pouploadfile" onclick="downFileDefect()">Download</button> -->


							<!--                                         <input type="hidden" id="pouploadfile" name="pouploadfile"> -->

							<!--                                     </div> -->

							<!-- 							<div style="margin-top: 15px;" class="col-md-6"></div> -->

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="poUploadDiv">
								<label style="margin-left: 2px"> PO File :<br> <span
									class="vlx" style="color: green; width: 450px"
									id="pouploadfile"></span></label>
								<button class="button1 button4" id="downHidepofile"
									onclick="downFileStandard()">Download</button>
							</div>
							<input type="hidden" id="filenameStandard"
								name="filenameStandard">


							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="proposalUploadDiv">
								<label style="margin-left: 2px"> Commercial Proposal
									File :<br> <span class="vlx"
									style="color: green; width: 450px" id="proposalfile"></span>
								</label>
								<button class="button1 button4" id="downHideproposalfile"
									onclick="proposalStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameProposal" name="filnameProposal">

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="maskedPOUploadDiv">
								<label style="margin-left: 2px"> Masked PO File :<br>
									<span class="vlx" style="color: green; width: 450px"
									id="maskedPOfile"></span></label>
								<button class="button1 button4" id="downHidemaskedPOfile"
									onclick="maskedPOStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameMaskedPO" name="filnameMaskedPO">


							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="productFeaturedUploadDiv">
								<label style="margin-left: 2px">Product Featured File
									List:<br> <span class="col-md-6"
									style="color: green; width: 450px" id="productFeaturedFile"></span>
								</label>
								<button class="button1 button4" id="downHideproductFeaturedfile"
									onclick="productFeaturedStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameProductFeatured"
								name="filnameProductFeatured">



							<!--                                     <div style="margin-top:15px;" class="col-md-6"> -->
							<!--                                          <input -->
							<!-- 											type="file" id="advinvoicefile" name="advinvoicefile" -->
							<!-- 											class="form-control" style="height: 36px;display: none;"> -->
							<!--                                     </div> -->
							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="advInvoiceUploadDiv">
								<label style="margin-left: 2px"> Advance Invoice :<br>
									<span class="vlx" style="color: green; width: 450px"
									id="advinvoicefile"></span></label>
								<button class="button1 button4" id="downHideadvInvfile"
									onclick="advInvFileStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameAdvinvoice"
								name="filnameAdvinvoice">




						</div>

						<br>
						<div class="row" style="display: none;" id="SInoteDiv">

							<div class="col-md-10">
								<label for="techniq">Note (SI)</label>
								<textarea id="SInote" tabindex="1" class="form-control"
									name="SInote" data-toogle="tooltip" placeholder="Enter Note"
									readonly></textarea>

							</div>

						</div>


						<br>
						<div class="row">
							<div class="col-md-12" id="FormsABdiv">


								<ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
									<li class="nav-item"><a class="nav-link active"
										id="custom-tabs-one-home-tab" data-toggle="pill"
										href="#custom-tabs-one-home" role="tab"
										aria-controls="custom-tabs-one-home" aria-selected="true">Form
											A</a></li>

									<li class="nav-item"><a class="nav-link"
										id="custom-tabs-one-messages-tab" data-toggle="pill"
										href="#custom-tabs-one-messages" role="tab"
										aria-controls="custom-tabs-one-messages" aria-selected="false">Form
											B</a></li>

									<!--                    <li class="nav-item"> -->
									<!--                     <a class="nav-link" id="custom-tabs-one-calls-tab" data-toggle="pill" href="#custom-tabs-one-calls" role="tab" aria-controls="custom-tabs-one-calls" aria-selected="false">Form 3</a> -->
									<!--                   </li> -->

								</ul>


								<div class="tab-content">
									<div class="tab-pane fade show active"
										id="custom-tabs-one-home" role="tabpanel"
										aria-labelledby="custom-tabs-one-home-tab">
										<br>
										<div class="row">
											<div class="col-md-1"></div>
											<div class="col-md-10">


												<div class="row">
													<div class="col-md-3">

														<label for="dateforma">Date</label>  
													</div>
													<div class="col-md-3">
														<input type="text" id="dateforma" name="dateforma"
															readonly class="form-control" data-toogle="tooltip">
													</div>
													<div class="col-md-3"></div>
													<div class="col-md-3"> </div>

												</div>
												<br>

												<div class="row">
													<div class="col-md-3">

														<label for="salemangname">Sales Manager Name</label>  
													</div>
													<div class="col-md-3">



														<input type="text" id="salemangname" name="salemangname"
															class="form-control" data-toogle="tooltip"
															placeholder="Enter Sales Manager Name"
															readonly="readonly">
														<!-- 														<select id="salemangname" name="salemangname" -->
														<!-- 															class="form-control" data-toogle="tooltip"> -->
														<!-- 															<option value="">-- Please Select --</option> -->
														<!-- 														</select> -->
													</div>
													<div class="col-md-3"></div>
													<div class="col-md-3"></div>

												</div>
												<br>

												<div class="row">
													<div class="col-md-3">

														<label for="formApoNo">PO No</label>  
													</div>
													<div class="col-md-3">
														<input type="text" id="formApoNo" name="formApoNo"
															class="form-control" data-toogle="tooltip" readonly
															placeholder="Enter PO Number">
													</div>
													<div class="col-md-3"></div>
													<div class="col-md-3"></div>

												</div>
												<br> <br>


												<!-- 							<div class="col-md-12"> -->

												<table class="table table-striped table-bordered row-border"
													id="formAtable" style="width: 100%">
													<thead>

														<tr class="table table-striped table-bordered">

															<th>Names</th>
															<th>Name of Party</th>
															<th>Project Name</th>
															<th>Technical Person Name</th>
															<th>Person Designation</th>
															<th>Contact Number</th>
															<th>Email Id</th>

														</tr>
													</thead>

													<tbody>
														<tr>
															<td>Distributor</td>
															<td><input type="text" id="distributorpartyname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="distributorpartyname"
																placeholder="Enter Name of Party"></td>
															<td><input type="text" id="distributorprojectname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="distributorprojectname"
																placeholder="Enter Project Name"></td>
															<td><input type="text"
																id="distributortechpersonname" tabindex="4"
																class="form-control" data-toogle="tooltip"
																name="distributortechpersonname"
																placeholder="Enter Technical Person Name"></td>
															<td><input type="text"
																id="distributorprsndesignation" tabindex="4"
																class="form-control" data-toogle="tooltip"
																name="distributorprsndesignation"
																placeholder="Enter Person Designation"></td>
															<td><input type="text" id="distributorcontactnumber"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="distributorcontactnumber"
																placeholder="Enter Contact Number"></td>
															<td><input type="text" id="distributoremailid"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="distributoremailid" placeholder="Enter Email ID" oninput="validateEmailContact()">
																<span id="emailErrorcontactred" style="color: red;"></span> 
																<span id="emailErrorcontactgreen" style="color: green;"></span>
																</td>
														</tr>
														<tr>
															<td>Partner</td>
															<td><input type="text" id="partnerpartyname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partnerpartyname"
																placeholder="Enter Name of Party"></td>
															<td><input type="text" id="partnerprojectname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partnerprojectname"
																placeholder="Enter Project Name"></td>
															<td><input type="text" id="partnertechpersonname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partnertechpersonname"
																placeholder="Enter Technical Person Name"></td>
															<td><input type="text" id="partnerprsndesignation"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partnerprsndesignation"
																placeholder="Enter Person Designation"></td>
															<td><input type="text" id="partnercontactnumber"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partnercontactnumber"
																placeholder="Enter Contact Number"></td>
															<td><input type="text" id="partneremailid"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partneremailid" placeholder="Enter Email ID" oninput="validateEmailContact0()">
																<span id="emailErrorcontactred0" style="color: red;"></span> 
																<span id="emailErrorcontactgreen0" style="color: green;"></span>
															</td>
																
														</tr>
														<tr>
															<td>Customer</td>
															<td><input type="text" id="customerpartyname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customerpartyname"
																placeholder="Enter Name of Party"></td>
															<td><input type="text" id="customerprojectname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customerprojectname"
																placeholder="Enter Project Name"></td>
															<td><input type="text" id="customertechpersonname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customertechpersonname"
																placeholder="Enter Technical Person Name"></td>
															<td><input type="text" id="customerprsndesignation"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customerprsndesignation"
																placeholder="Enter Person Designation"></td>
															<td><input type="text" id="customercontactnumber"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customercontactnumber"
																placeholder="Enter Contact Number"></td>
															<td><input type="text" id="customeremailid"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customeremailid" placeholder="Enter Email ID" oninput="validateEmailContact1()">
																<span id="emailErrorcontactred1" style="color: red;"></span> 
																<span id="emailErrorcontactgreen1" style="color: green;"></span>
															</td>
														</tr>

														<tr>
															<td>End Customer</td>
															<td><input type="text" id="endcustomerpartyname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="endcustomerpartyname"
																placeholder="Enter Name of Party"></td>
															<td><input type="text" id="endcustomerprojectname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="endcustomerprojectname"
																placeholder="Enter Project Name"></td>
															<td><input type="text"
																id="endcustomertechpersonname" tabindex="4"
																class="form-control" data-toogle="tooltip"
																name="endcustomertechpersonname"
																placeholder="Enter Technical Person Name"></td>
															<td><input type="text"
																id="endcustomerprsndesignation" tabindex="4"
																class="form-control" data-toogle="tooltip"
																name="endcustomerprsndesignation"
																placeholder="Enter Person Designation"></td>
															<td><input type="text" id="endcustomercontactnumber"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="endcustomercontactnumber"
																placeholder="Enter Contact Number"></td>
															<td><input type="text" id="endcustomeremailid"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="endcustomeremailid" placeholder="Enter Email ID" oninput="validateEmailContact2()">
																<span id="emailErrorcontactred2" style="color: red;"></span> 
																<span id="emailErrorcontactgreen2" style="color: green;"></span>
															</td>
														</tr>

														<tr>
															<td>Implementor from Customer</td>
															<td><input type="text" id="implementorpartyname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="implementorpartyname"
																placeholder="Enter Name of Party"></td>
															<td><input type="text" id="implementorprojectname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="implementorprojectname"
																placeholder="Enter Project Name"></td>
															<td><input type="text"
																id="implementortechpersonname" tabindex="4"
																class="form-control" data-toogle="tooltip"
																name="implementortechpersonname"
																placeholder="Enter Technical Person Name"></td>
															<td><input type="text"
																id="implementorprsndesignation" tabindex="4"
																class="form-control" data-toogle="tooltip"
																name="implementorprsndesignation"
																placeholder="Enter Person Designation"></td>
															<td><input type="text" id="implementorcontactnumber"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="implementorcontactnumber"
																placeholder="Enter Contact Number"></td>
															<td><input type="text" id="implementoremailid"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="implementoremailid" placeholder="Enter Email ID" oninput="validateEmailContact3()">
																<span id="emailErrorcontactred3" style="color: red;"></span> 
																<span id="emailErrorcontactgreen3" style="color: green;"></span></td>
														</tr>

													</tbody>

												</table>
												<span id="messageSpan"></span> <br>
												<div class="row">

													<div class="col-md-10">
														<label for="techniq">Note SM (Optional)</label>
														<textarea id="SMnote" tabindex="1" class="form-control"
															name="SMnote" data-toogle="tooltip"
															placeholder="Enter Note"></textarea>

													</div>

												</div>



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
													<div class="col-md-6" style="margin-top: 15px;">
														<label>Date : </label>
														<div id="date1"></div>
														<input type="text" id="form2date" tabindex="1"
															class="form-control" data-toogle="tooltip"
															name="form2date" readonly>
													</div>

													<div class="col-md-6" style="margin-top: 15px;">
														<label>Customer Name :</label>
														<div id="Customer1"></div>
														<input type="text" id="form2customername" tabindex="2"
															class="form-control" data-toogle="tooltip"
															name="form2customername"
															placeholder="Enter Your Customer Name Here " readonly>
													</div>

												</div>

												<div class="row">

													<div class="col-md-6" style="margin-top: 15px;">
														<label>PO number :</label>
														<div id="poform2No1"></div>
														<input type="text" id="poform2No" tabindex="3"
															class="form-control" data-toogle="tooltip"
															name="poform2No" readonly placeholder="Enter PO Number">
													</div>


													<div class="col-md-6" style="margin-top: 15px;">
														<label>Purchase Order Timeline :</label>
														<!-- 											<div id="pot"></div> -->
														<!-- 											<input type="date" id="potimeline" tabindex="3" -->
														<!-- 												class="form-control" data-toogle="tooltip" name="potimeline"> -->
														<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="far fa-calendar-alt"></i>
																</span>
															</div>
															<input type="text" readonly="true"
																="1"
																	class="form-control pull-right"
																autocomplete="off" name="potimeline" id="potimeline"
																placeholder="Please Select  Date"
																dateformat="dd-MMM-yyyy">
														</div>
													</div>

												</div>

												<div class="row">


													<div class="col-md-6" style="margin-top: 15px;">
														<label>RFP Timelines :</label>
														<!-- 											<div id="rpf1"></div> -->
														<!-- 											<input type="date" id="RPFTIMELINES" tabindex="3" -->
														<!-- 												class="form-control" data-toogle="tooltip" -->
														<!-- 												name="RPFTIMELINES"> -->
														<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="far fa-calendar-alt"></i>
																</span>
															</div>
															<input type="text" readonly="true"
																="1"
																	class="form-control pull-right"
																autocomplete="off" name="RPFTIMELINES" id="RPFTIMELINES"
																placeholder="Please Select  Date"
																dateformat="dd-MMM-yyyy">
														</div>
													</div>

													<div class="col-md-6" style="margin-top: 15px;">
														<label>1st Invoice Generation Date :</label>
														<!-- 											<div id="firstinvoice"></div> -->
														<!-- 											<input type="date" id="firstinvoicegeneratedate" tabindex="3" -->
														<!-- 												class="form-control" data-toogle="tooltip" -->
														<!-- 												name="firstinvoicegeneratedate"> -->
														<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="far fa-calendar-alt"></i>
																</span>
															</div>
															<input type="text" readonly="true"
																="1"
																	class="form-control pull-right"
																autocomplete="off" name="firstinvoicegeneratedate"
																id="firstinvoicegeneratedate"
																placeholder="Please Select  Date"
																dateformat="dd-MMM-yyyy">
														</div>
													</div>
												</div>





												<div class="row">

													<div class="col-md-6" style="margin-top: 15px;">
														<label>Project Start Date :</label>
														<!-- 														<div id="rpf13"></div> -->
														<!-- 														<input type="date" id="projstartdate" tabindex="3" -->
														<!-- 															class="form-control" data-toogle="tooltip" -->
														<!-- 															name="projstartdate"> -->
														<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="far fa-calendar-alt"></i>
																</span>
															</div>
															<input type="text" readonly="true"
																="1"
																	class="form-control pull-right"
																autocomplete="off" name="projstartdate"
																id="projstartdate" placeholder="Please Select  Date"
																dateformat="dd-MMM-yyyy">
														</div>
													</div>

													<div class="col-md-6" style="margin-top: 15px;">
														<label>Project End Date :</label>
														<!-- 														<div id="pot222"></div> -->
														<!-- 														<input type="date" id="projenddate" tabindex="3" -->
														<!-- 															class="form-control" data-toogle="tooltip" -->
														<!-- 															name="projenddate"> -->
														<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="far fa-calendar-alt"></i>
																</span>
															</div>
															<input type="text" readonly="true"
																="1"
																	class="form-control pull-right"
																autocomplete="off" name="projenddate" id="projenddate"
																placeholder="Please Select  Date"
																dateformat="dd-MMM-yyyy">
														</div>
													</div>
												</div>

												<div class="row">


													<div class="col-md-6" style="margin-top: 15px;">
														<label>Payment Terms</label>
														<div id="paymentermmmm"></div>
														<!-- 											<input type="text" id="pymentterms" tabindex="2" -->
														<!-- 												class="form-control" data-toogle="tooltip" -->
														<!-- 												name="pymentterms" placeholder="Enter Your Payments Here "> -->

														<textarea id="pymentterms" name="pymentterms" tabindex="2"
															class="form-control" data-toogle="tooltip"
															placeholder="Enter Your Payments Here"></textarea>


													</div>


													<div class="col-md-6" style="margin-top: 15px;">
										<label for="SecondApprovername">Project Head:</label> <select
											id="projecthead"  class="form-control"
											data-toogle="tooltip" name="projecthead">
											<option value="">--Please Select Project Head--</option>
										</select>
										</div>
												</div>

												<div class="row">


													<div class="col-md-6" style="margin-top: 15px;">
														<!-- 											<p> -->
														<!-- 												<b>Customer Flow chart for payment process & only -->
														<!-- 													collection if any :</b> -->
														<!-- 											</p> -->
														<!-- 											  <input type="radio" id="chartpaymntyes" name="radiosss" -->
														<!-- 												value="Yes" onchange="chartpaymntYes()">   <label -->
														<!-- 												for="chartpaymntyes">Yes</label>   <input type="radio" -->
														<!-- 												id="chartpaymntno" name="radiosss" value="No" -->
														<!-- 												onchange="chartpaymntNo()">   <label -->
														<!-- 												for="chartpaymntno">No</label> -->
														<label>Customer Flow chart for Payment process &
															Only Collection If any :</label><br> <select
															id="flowchartpaymnetid" class="form-control" tabindex="6"
															data-toogle="tooltip" name="flowchartpaymnetid"
															onchange="chartpaymntYes()">
															<option value="">--Please Select--</option>
															<option value="Yes">Yes</option>
															<option value="No">No</option>
														</select>
													</div>

													<div class="col-md-6"
														style="margin-top: 15px; display: none;" id="remarksid">
														<label for="Remarks">Remarks :</label>
														<textarea type="text" rows="2" cols="20" id="Remarks"
															tabindex="12" class="form-control" data-toogle="tooltip"
															name="Remarks" placeholder="Please Enter Remarks"
															maxlength="2000">
                                                    </textarea>
													</div>






												</div>

												<br>
												<hr>
												<form>
													<div class="col-md-12" id="inputContainer"></div>
												</form>
												<hr>
												<br>
												<div class="col-md-1"></div>
											</div>
										</div>


										<!--                      	 <div class="tab-pane fade" id="custom-tabs-one-calls"  role="tabpanel" aria-labelledby="custom-tabs-one-calls-tab"> -->


										<!-- 					</div> -->

									</div>
								</div>
								<!-- 								<br> -->
								<div class="card-body"></div>

							</div>




						</div>

						<div style="margin-top: 15px;" class="col-md-12">
							<center>
								<!--                                                <input type="submit" tabindex="8" class="btn btn-primary m-t-10" id="submit-btnnn"  name="submit" value="Submit"> <span class="spinner" style=" display: none"><i class="fa fa-refresh fa-spin fa-10x"></i></span>-->
								<button type="submit" tabindex="8"
									class="btn btn-primary m-t-10" id="SubmitABform"
									name="SubmitABform" data-style="expand-left">
									Submit &nbsp;<span class="spinner-border"
										style="width: 1rem; height: 1rem; display: none;" id="spin1"><i
										class="fa fa-refresh fa-spin fa-10x"></i></span>
								</button>
								<!--                                             <button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="Reject" name="Reject" onclick="myFunctionReject();">Feedback &nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem;display: none;" id="spin2"><i class="fa fa-refresh fa-spin fa-10x"></i></span></button>   -->

								<button type="button"
									="3"
													class="btn btn-primary m-t-10"
									id="reset-btn" name="reset-btn" value="Reset"
									onclick="resetAll()">Reset</button>

								<button type="submit" tabindex="8" class="btn btn-danger m-t-10"
									id="Reject" name="Reject" onclick="rejectFunction();">
									Reject &nbsp; &nbsp;<span class="spinner-border"
										style="width: 1rem; height: 1rem; display: none;" id="spin2"><i
										class="fa fa-refresh fa-spin fa-10x"></i></span>
								</button>
							</center>
						</div>

						<br>
						<!-- /.card -->



					</div>


				</div>
			</div>


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
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/adminlte/bower_components/moment/moment.js"></script>

	<script
		src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
		type="text/javascript"></script>


	<script
		src="<%=request.getContextPath()%>/static/custom/ViewSaleMngFormABDetails.js"></script>

	<script>
		$('#RPFTIMELINES').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#potimeline').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#firstinvoicegeneratedate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#projstartdate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#projenddate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});
	</script>
</body>
</html>