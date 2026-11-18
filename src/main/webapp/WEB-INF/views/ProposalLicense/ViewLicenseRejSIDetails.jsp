<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending For My Action</title>
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

			<section class="content-header">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<br> <br>
						<div class="card card-secondary">
							<div class="card-header col-md-12">
								Update Rejected Velox License <a
									href="<%=request.getContextPath()%>/User/LicenseRejectedFeedbackSI">
									<i class="fa fa-backward pull-right"
									style="color: white; margin-left: 560px"> </i>
								</a>

							</div>
							<div class="card-body">


								<div class="card-body">


									<div class="row">

										<div class="col-md-6">
											<label for="">OEM & Supplier of License</label> <input
												type="text" id="sppliernamelicense"
												class="form-control form-control-sm"
												name="sppliernamelicense" data-toogle="tooltip"
												value="VELOX SOUTIONS PVT. LTD." readonly="readonly">
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
											<label for="clientname">Buyer of Licenses :</label> <input
												type="text" id="clientname"
												class="form-control form-control-sm" name="clientname"
												data-toogle="tooltip" placeholder="Enter Your Client Name" readonly>

										</div>

<!-- 										<div class="col-md-6" style="margin-top: 15px;"> -->
<!-- 											<label for="POidList">Select PO</label> <select id="POidList" -->
<!-- 												class="form-control" data-toogle="tooltip" name="POidList" -->
<!-- 												onchange="POidListData()"> -->
<!-- 												<option value="">--Please Select PO ID--</option> -->
<!-- 											</select> -->

<!-- 										</div> -->

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="priority1">Customer Address :</label>
											<div id="commentsDiv">

												<textarea class="form-control form-control-sm"
													name="clientAddress" rows="2" cols="50" id="clientAddress"
													placeholder="Enter Your Client Address"
													data-original-title=""></textarea>
											</div>
										</div>

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">PO Number</label> <input type="text"
												id="ponumber" class="form-control form-control-sm"
												name="ponumber" data-toogle="tooltip"
												placeholder="Enter Your PO Number" readonly="readonly">
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
													placeholder="Please Select PO Date"
													dateformat="dd-MMM-yyyy">
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

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="paymentReceived">Payment Received</label> <select
											 id="payment_recieved"
												class="form-control form-control-sm" name="payment_recieved"
												data-toogle="tooltip" >
												<option value="">--Please Select--</option>
											<option value="Yes">Yes</option>
											<option value="No">No</option></select>
										</div>



										<div style="margin-top: 15px; display: none;" class="col-md-6"
											id="poUploadDiv">
											<label style="margin-left: 2px">License Agreement
												Attachment:<br> <span class="vlx"
												style="color: green; width: 450px" id="pouploadfile"></span>
											</label>
											<button class="button1 button4" id="downHidepofile"
												onclick="downFileStandard()">Download</button>
										</div>
										<input type="hidden" id="filenameStandard"
											name="filenameStandard">


									</div>
									<br>
								<hr>
								<div class="row">

									<div class="col-md-6">
										<label for="FirstApprovername">Checker Name:</label> <select
											id="FirstApprovername" class="form-control"
											data-toogle="tooltip" name="FirstApprovername">
										</select>
									</div>
									<div class="col-md-6">
										<label for="SecondApprovername">Authorizer Name:</label> <select
											id="SecondApprovername" class="form-control"
											data-toogle="tooltip" name="SecondApprovername">
											<option value="">--Please Select Authorizer Name--</option>
										</select>
									</div>

								</div>
								<br>







									<br> <br>
									<div class="row">
										<div class="col-md-12">


											<ul class="nav nav-tabs" id="custom-tabs-one-tab"
												role="tablist">
												<li class="nav-item"><a class="nav-link active"
													id="custom-tabs-one-home-tab" data-toggle="pill"
													href="#custom-tabs-one-home" role="tab"
													aria-controls="custom-tabs-one-home" aria-selected="true">Product
														Details</a></li>
											</ul>


											<div class="tab-content">
												<div class="tab-pane fade show active"
													id="custom-tabs-one-home" role="tabpanel"
													aria-labelledby="custom-tabs-one-home-tab">
													<br>
													<div class="row">
														<div class="col-md-1"></div>
														<div class="col-md-10">



															<table
																class="table table-striped table-bordered row-border"
																style="width: 100%;" id="viewdataLicenseCreatedTable">
																<thead>

																	<tr class="table table-striped table-bordered">
																		<th>Product Suites</th>
																		<th>Product Tool</th>
																		<th>Quantity</th>
																		<th>Period</th>

																	</tr>
																</thead>
																<tbody>

																</tbody>
															</table>

														</div>
													</div>
													<br>

												</div>
											</div>
										</div>
										<br>

									</div>


								</div>
							</div>


							<!-- 			</div> -->


						</div>
					</div>
				</div>
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
														<th>Period</th>
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

														<!-- 														<td>												 -->
														<!-- 														<select id="productnameaddrow" -->
														<!-- 															 class="form-control" data-toogle="tooltip" -->
														<!-- 															name="productnameaddrow" > -->
														<!-- 																<option value="">--Please Select Product Tool--</option> -->
														<!-- 														</select>																												 -->
														<!-- 														</td> -->

														<td>
<!-- 														<input type="text" id="productnameaddrow" -->
<!-- 															name="productnameaddrow" -->
<!-- 															placeholder="Enter your Product Name" -->
<!-- 															class="form-control"> -->	

														<select id="productnameaddrow" class="form-control" data-toogle="tooltip"
															name="productnameaddrow">
																<option value="">--Please Select Product Tool--</option>
														</select>
												
														</td>




														<td><input type="text" id="Desciption"
															name="Desciption" placeholder="Enter your Quantity"
															class="form-control" oninput="validatequantity(this)"
															oninput="this.value = this.value.replace(/[^0-9]/g, '');"></td>


														<td><input type="text"
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
													Update <span class="spinner-border"
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


		<!-- 			<br> -->
		<!-- 		</div> -->


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
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/ViewLicenseRejSIDetails.js"></script>
</body>
</html>