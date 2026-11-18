<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FormC Details</title>
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
<%--  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css"> --%>

<%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/Datepicker/css/bootstrap-datepicker.min.css">  --%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
<!-- <script src="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css"></script>-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">

<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
  
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.css" type="text/css"/> --%>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />


<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
	
}

.datetimepicker {
	z-index: 1071 !important;
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

            String projectId = request.getParameter("projectId");
            System.out.println("projectId" + projectId);

          

        %>
    </script>




</head>
<body class="hold-transition sidebar-mini layout-fixed">

	<input type="hidden" id="crnoo" name="crnoo" value="<%=crno%>">

	<input type="hidden" id="tid" name="tid" value="<%=tid%>">

	<input type="hidden" id="projectId" name="projectId"
		value="<%=projectId%>">

	<input type="hidden" id="formABstatus" name="formABstatus" value="">




	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>






			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<div class="card card-secondary border-secondary">

						<div class="card-header">
							<div class="row">
								<div class="col-md-5">Select PO For View Details</div>

								<div class="col-md-6"></div>

								<div class="col-md-1">
									<a href="<%=request.getContextPath()%>/Admin/PMS"> <i
										class="fa fa-backward pull-right" style="color: white"> </i>
									</a>
								</div>
							</div>

						</div>
						<div class="card-body">

							<div class="row">

								<div class="col-md-2"></div>
								<div class="col-md-8">
									<label for="">Select PO:</label><br> <select
										id="functionNames" class="form-control" data-toogle="tooltip"
										name="functionNames" onchange="hideFormC()">
										<option value="">--Please Select--</option>
								</div>
								</select>
								<div style="margin-top: 15px;" class="col-md-12 text-center">
									<button type="button" class="btn btn-primary m-t-10"
										id="Selectrd" name="Selectrd">Submit</button>
									<button type="button" class="btn btn-secondary m-t-10"
										id="resetrd" name="resetrd" value="Reset" onclick="resetPOID()">Reset</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3"></div>
			</div>




			<br>
			<div style="padding-left: 15px; padding-right: 15px">

				<div class="card card-secondary border-secondary" id="formCdata">






					<div class="card-body">

						<div class="row">
							<div style="margin-top: 15px;" class="col-md-6">
								<label>PO Number :</label>
								<div id="ponumb"></div>
								<input type="text" id="PONumb" tabindex="4" class="form-control"
									data-toogle="tooltip" name="PONumb"
									placeholder="Enter your PO Number" readonly>

							</div>


							<div style="margin-top: 15px;" class="col-md-6">
								<label>Date : </label>
								<div id="date1"></div>
								<input type="text" id="date" tabindex="1" class="form-control"
									data-toogle="tooltip" name="date" readonly>
							</div>
							<!--                                     <div style="margin-top:15px;" class="col-md-6"> -->
							<!--                                  <label >Project Implementor Name :</label> -->
							<!-- 											<div id="impl1"></div>  -->
							<!-- 											 <input -->
							<!-- 												type="text" id="projeimplementorname" tabindex="2" -->
							<!-- 												class="form-control" data-toogle="tooltip" name="projeimplementorname" placeholder="Enter Your Project Implementor Name Here " readonly> -->

							<!-- 									 </div> -->
							<div style="margin-top: 15px;" class="col-md-6">
								<label>Customer Name :</label>
								<div id="Customer1"></div>
								<input type="text" id="customername" class="form-control"
									data-toogle="tooltip" name="customername"
									placeholder="Enter Your Customer Name Here " readonly>


							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label>Product License :</label>
								<div id="ProductLic1"></div>
								<input type="text" id="productLicense" class="form-control"
									data-toogle="tooltip" name="productLicense"
									placeholder="Enter Your Product License  " readonly>


							</div>


							<!-- //// new  -->

							<div style="margin-top: 15px;" class="col-md-6">
								<label>Customer Implementor Name:</label>
								<div id=""></div>
								<input type="text" id="ImplementorName" class="form-control"
									data-toogle="tooltip" name="ImplementorName"
									placeholder="Enter Your Customer Implementor Name " readonly>

							</div>

							<div style="margin-top: 15px;" class="col-md-6">
								<label>Customer Implementor Contact :</label>
								<div id=""></div>
								<input type="text" id="ImplementorNumber" class="form-control"
									data-toogle="tooltip" name="ImplementorNumber"
									placeholder="Enter Your Customer Implementor Contact " readonly>

							</div>


							<div style="margin-top: 15px;" class="col-md-6">
								<label>Customer Implementor Email :</label>
								<div id=""></div>
								<input type="text" id="cusImplementorEmail" class="form-control"
									data-toogle="tooltip" name="cusImplementorEmail"
									placeholder="Enter Your Customer Implementor Email " readonly>

							</div>




							<div style="margin-top: 15px;" class="col-md-6">
								<label>Sales Manager Name:</label>
								<div id=""></div>
								<input type="text" id="SalesManagerName" class="form-control"
									data-toogle="tooltip" name="SalesManagerName"
									placeholder="Enter Your Sales Manager Name" readonly>

							</div>

							<div style="margin-top: 15px;" class="col-md-6">
								<label>Customer SPOC Name:</label>
								<div id="endcust"></div>
								<input type="text" id="EndCustomerName" class="form-control"
									data-toogle="tooltip" name="EndCustomerName"
									placeholder="Enter Your End Customer Name  " readonly>

							</div>

							<div style="margin-top: 15px;" class="col-md-6">
								<label>Customer SPOC Contact :</label>
								<div id="endcostNo"></div>
								<input type="text" id="EndCustomerNumber" class="form-control"
									data-toogle="tooltip" name="EndCustomerNumber"
									placeholder="Enter Your End Customer Number " readonly>

							</div>


							<div style="margin-top: 15px;" class="col-md-6">
								<label>Payment Terms :</label>
								<div id="paymentTermsPOdiv"></div>
								<input type="text" id="paymentTermsPO" class="form-control"
									data-toogle="tooltip" name="paymentTermsPO"
									placeholder="Enter Your Payment Terms " readonly>

							</div>


							<!-- //// new  end -->

							<!--                                     <div style="margin-top:15px;" class="col-md-6"> -->
							<!--                                        <label>Project Name :</label> -->
							<!-- 											<div id="proj"></div>  -->
							<!-- 											 <input -->
							<!-- 												type="text" id="projectname" tabindex="4" class="form-control" -->
							<!-- 												data-toogle="tooltip" name="projectname" placeholder="Enter your Project Name Here"  readonly> -->

							<!--                                     </div> -->








						</div>


						<br>
						<hr>

						<div class="col-md-12" id="inputContainer"></div>
						<hr>
						<br>

						<!-- 					<div style="margin-top: 15px;" class="col-md-6"> -->
						<!-- 								<label>No of Product Quantities :</label> -->
						<!-- 								<div id="NoOfProductQty"></div> -->
						<!-- 								<input type="text" id="NoOfProductQty" class="form-control" -->
						<!-- 									data-toogle="tooltip" name="NoOfProductQty" -->
						<!-- 									placeholder="Enter Your No of Quantities " readonly> -->

						<!-- 							  </div> -->

						<div class="row">

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="maskedPOUploadDiv">
								<label style="margin-left: 2px"> Masked PO File :<br>
									<span class="col-md-6" style="color: green; width: 450px"
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

						</div>

						<br> <br>

						<div class="row">
							<div class="col-md-12">


								<ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
									<li class="nav-item"><a class="nav-link active"
										id="custom-tabs-one-home-tab" data-toggle="pill"
										href="#custom-tabs-one-home" role="tab"
										aria-controls="custom-tabs-one-home" aria-selected="true">Plan Of Action</a></li>

									<!--                   <li class="nav-item"> -->
									<!--                     <a class="nav-link" id="custom-tabs-one-messages-tab" data-toggle="pill" href="#custom-tabs-one-messages" role="tab" aria-controls="custom-tabs-one-messages" aria-selected="false">Form 2</a> -->
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

												<table id="data-table11" class="col-md-12">
													<thead>
														<tr>
															<th data-row-id="row-1">Server Availability :</th>
															<th>Responsibility :</th>
															<th>Start Date :</th>
															<th>End Date :</th>
															<!-- 													<th>Action </th> -->

														</tr>
													</thead>
													<tbody>
														<tr data-row-id="row-1">

															<td><input class="form-control form-control-sm"
																type="text"
																placeholder="Enter your Server Availability "
																id="serverAvail" name="serverAvail" readonly></td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="text" placeholder="Enter Your Responsibility" -->
																<!-- 																id="Responsibility" name="Responsibility"></td> -->

																<input id="Responsibility"
																class="form-control form-control-sm"
																data-toogle="tooltip" name="Responsibility" readonly>

																<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="startdate" name="startdate"> -->

																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="startdate" id="startdate"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy" readonly>
																</div>

															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="enddate" name="enddate"> -->

																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="enddate" id="enddate"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>

															</td>
															<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->

														</tr>
													</tbody>
												</table>
												<br>
												<table id="data-table2" class="col-md-12">
													<thead>
														<tr>
															<th data-row-id="row-1">Install Of Velox License :</th>
														</tr>
													</thead>
													<tbody>
														<tr data-row-id="row-1">

															<td><input class="form-control form-control-sm"
																type="text"
																placeholder="Enter your Install Of Velox License"
																id="installvlxlicense" name="installvlxlicense" readonly></td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="text" placeholder="Enter Your Responsibility" -->
																<!-- 																id="Responsibilityvlxlicense" --> <!-- 																name="Responsibilityvlxlicense"> -->
																<input id="Responsibilityvlxlicense"
																class="form-control form-control-sm"
																data-toogle="tooltip" name="Responsibilityvlxlicense"
																readonly>

															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="startdatevlxlicense" -->
																<!-- 																name="startdatevlxlicense"> -->
																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="startdatevlxlicense" id="startdatevlxlicense"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>


															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="enddatevlxlicense" -->
																<!-- 																name="enddatevlxlicense"> -->
																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="enddatevlxlicense" id="enddatevlxlicense"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>


															</td>
															<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->

														</tr>
													</tbody>
												</table>
												<br>


												<table id="data-table3" class="col-md-12">
													<thead>
														<tr>
															<th>UAT Testing :</th>

														</tr>
													</thead>
													<tbody>
														<tr data-row-id="row-1">

															<td><input class="form-control form-control-sm"
																type="text" placeholder="Enter your  UAT Testing"
																id="UATTesting" name="UATTesting" readonly></td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="text" placeholder="Enter Your Responsibility" -->
																<!-- 																id="Responsibilityuattesting" --> <!-- 																name="Responsibilityuattesting"> -->

																<input id="Responsibilityuattesting"
																class="form-control form-control-sm"
																data-toogle="tooltip" name="Responsibilityuattesting"
																readonly> <!-- 											<option value="">---Please Select---</option> -->
																<!-- 											<option value="End Customer">End Customer</option> -->
																<!-- 											<option value="Velox Solution">Velox Solution</option> -->
																<!-- 											<option value="Both">Both</option> -->


															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="startdateuattesting" -->
																<!-- 																name="startdateuattesting"> -->
																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="startdateuattesting" id="startdateuattesting"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>

															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="enddateuattesting" -->
																<!-- 																name="enddateuattesting"> -->

																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="enddateuattesting" id="enddateuattesting"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>
															</td>
															<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->

														</tr>
													</tbody>
												</table>


												<br>
												<table id="data-table4" class="col-md-12">
													<thead>
														<tr>
															<th>Production GO Live :</th>

														</tr>
													</thead>
													<tbody>
														<tr>

															<td><input class="form-control form-control-sm"
																type="text" placeholder="Enter your Production GO Live"
																id="productiongolive" name="productiongolive" readonly></td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="text" placeholder="Enter Your Responsibility" -->
																<!-- 																id="Responsibilitygolive" name="Responsibilitygolive"> -->


																<input id="Responsibilitygolive"
																class="form-control form-control-sm"
																data-toogle="tooltip" name="Responsibilitygolive"
																readonly>




															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="startdategolive" name="startdategolive"> -->
																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="startdategolive" id="startdategolive"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>


															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="enddategolive" name="enddategolive"> -->

																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="enddategolive" id="enddategolive"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>
															</td>
															<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->

														</tr>
													</tbody>
												</table>
												<br>
												<table id="data-table5" class="col-md-12">
													<thead>
														<tr>
															<th>Rollout :</th>

														</tr>
													</thead>
													<tbody>
														<tr>

															<td><input class="form-control form-control-sm"
																type="text" placeholder="Enter your Rollout"
																id="rollout" name="rollout" readonly></td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="text" placeholder="Enter Your Responsibility" -->
																<!-- 																id="Responsibilityrollout" name="Responsibilityrollout"> -->

																<input id="Responsibilityrollout"
																class="form-control form-control-sm"
																data-toogle="tooltip" name="Responsibilityrollout"
																readonly> <!-- 											<option value="">---Please Select---</option> -->
																<!-- 											<option value="End Customer">End Customer</option> -->
																<!-- 											<option value="Velox Solution">Velox Solution</option> -->
																<!-- 											<option value="Both">Both</option> -->


															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="startdaterollout" -->
																<!-- 																name="startdaterollout"> -->
																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="startdaterollout" id="startdaterollout"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>


															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="enddaterollout" name="enddaterollout"> -->

																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="enddaterollout" id="enddaterollout"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>

															</td>
															<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->

														</tr>
													</tbody>
												</table>


												<br>
												<table id="data-table6" class="col-md-12">
													<thead>
														<tr>
															<th>DEMO Live :</th>

														</tr>
													</thead>
													<tbody>
														<tr>

															<td><input class="form-control form-control-sm"
																type="text" placeholder="Enter your DEMO Live "
																id="demolive" name="demolive" readonly></td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="text" placeholder="Enter Your Responsibility" -->
																<!-- 																id="Responsibilitydemo" name="Responsibilitydemo"> -->


																<input id="Responsibilitydemo"
																class="form-control form-control-sm"
																data-toogle="tooltip" name="Responsibilitydemo" readonly>
																<!-- 											<option value="">---Please Select---</option> -->
																<!-- 											<option value="End Customer">End Customer</option> -->
																<!-- 											<option value="Velox Solution">Velox Solution</option> -->
																<!-- 											<option value="Both">Both</option> -->


															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="startdatedemo" name="startdatedemo"> -->
																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="startdatedemo" id="startdatedemo"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>

															</td>
															<td>


																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="enddatedemo" id="enddatedemo"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>
															</td>
															<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->

														</tr>
													</tbody>
												</table>
												<!-- 												<br> -->
												<!-- 												<table id="data-table7" class="col-md-12"> -->
												<!-- 													<thead> -->
												<!-- 														<tr> -->
												<!-- 															<th data-row-id="row-1">Payment Terms :</th> -->

												<!-- 														</tr> -->
												<!-- 													</thead> -->
												<!-- 													<tbody> -->
												<!-- 														<tr> -->

												<!-- 															<td> -->
												<!-- 															<textarea class="form-control form-control-sm" -->
												<!-- 																 placeholder="Enter your Payment Terms" -->
												<!-- 																id="paymentterms" name="paymentterms" readonly> -->
												<!-- 																</textarea> -->

												<!-- 																</td> -->
												<!-- 															<td> -->




												<!-- 										 <select -->
												<!-- 											id="Responsibilitypaymentterms"  class="form-control form-control-sm" -->
												<!-- 											data-toogle="tooltip" name="Responsibilitypaymentterms">											 -->
												<!-- 											<option value="">---Please Select---</option> -->
												<!-- 											<option value="End Customer">End Customer</option> -->
												<!-- 											<option value="Velox Solution">Velox Solution</option> -->
												<!-- 											<option value="Both">Both</option> -->
												<!-- 										  </select> -->

												<!-- 																</td> -->
												<!-- 															<td> -->


												<!-- 																  <div class="input-group"> -->
												<!-- 																<div class="input-group-prepend"> -->
												<!-- 																	<span class="input-group-text"> <i -->
												<!-- 																		class="far fa-calendar-alt"></i> -->
												<!-- 																	</span> -->
												<!-- 																</div> -->
												<!-- 																<input type="text" readonly -->
												<!-- 																	class="form-control pull-right" autocomplete="off" -->
												<!-- 																	name="startdatepaymentterms" id="startdatepaymentterms"  -->
												<!-- 																	placeholder="Please Select  Date" -->
												<!-- 																	dateformat="dd-MMM-yyyy"> -->
												<!-- 															</div> -->
												<!-- 																</td> -->
												<!-- 															<td> -->


												<!-- 																  <div class="input-group"> -->
												<!-- 																<div class="input-group-prepend"> -->
												<!-- 																	<span class="input-group-text"> <i -->
												<!-- 																		class="far fa-calendar-alt"></i> -->
												<!-- 																	</span> -->
												<!-- 																</div> -->
												<!-- 																<input type="text" readonly -->
												<!-- 																	class="form-control pull-right" autocomplete="off" -->
												<!-- 																	name="enddatepaymentterms" id="enddatepaymentterms"  -->
												<!-- 																	placeholder="Please Select  Date" -->
												<!-- 																	dateformat="dd-MMM-yyyy"> -->
												<!-- 															</div> -->
												<!-- 																</td> -->


												<!-- 														</tr> -->
												<!-- 													</tbody> -->
												<!-- 												</table> -->


												<br>
												<table id="data-table8" class="col-md-12">
													<thead>
														<tr>
															<th data-row-id="row-1">Sign Off :</th>

														</tr>
													</thead>
													<tbody>
														<tr>

															<td><input class="form-control form-control-sm"
																type="text" placeholder="Enter your Sign Off"
																id="signoff" name="signoff" readonly></td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="text" placeholder="Enter Your Responsibility" -->
																<!-- 																id="Responsibilitysignoff" name="Responsibilitysignoff"> -->

																<input id="Responsibilitysignoff"
																class="form-control form-control-sm"
																data-toogle="tooltip" name="Responsibilitysignoff"
																readonly> <!-- 											<option value="">---Please Select---</option> -->
																<!-- 											<option value="End Customer">End Customer</option> -->
																<!-- 											<option value="Velox Solution">Velox Solution</option> -->
																<!-- 											<option value="Both">Both</option> -->


															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="startdatesignoff" -->
																<!-- 																name="startdatesignoff"> -->

																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="startdatesignoff" id="startdatesignoff"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>

															</td>
															<td>
																<!-- 															<input class="form-control form-control-sm" -->
																<!-- 																type="date" id="enddatesignoff" name="enddatesignoff"> -->
																<div class="input-group">
																	<div class="input-group-prepend">
																		<span class="input-group-text"> <i
																			class="far fa-calendar-alt"></i>
																		</span>
																	</div>
																	<input type="text" readonly
																		class="form-control pull-right" autocomplete="off"
																		name="enddatesignoff" id="enddatesignoff"
																		placeholder="Please Select  Date"
																		dateformat="dd-MMM-yyyy">
																</div>

															</td>
															<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->

														</tr>
													</tbody>
												</table>

												<br>


											</div>
											<div class="col-md-1"></div>

										</div>
										<br>


									</div>



								</div>

							</div>
							<br>
						</div>





						<br>
						<!--                                  <div class="row"> -->

						<!--                                                     <div class="col-md-10"> -->
						<!--                                                      <label for="techniq">Note (Optional)</label> -->
						<!--                                                         <textarea id="SMnote" tabindex="1" class="form-control" name="SMnote"  data-toogle="tooltip" placeholder="Enter Note"></textarea> -->

						<!--                                                     </div> -->

						<!--                                       </div>   -->



						<!-- 						<div class="row"> -->


						<!-- 							<div style="margin-top: 15px;" class="col-md-4"> -->
						<!-- 								<label>Function Name :</label> <select id="functionName1" -->
						<!-- 									class="form-control form-control-sm" data-toggle="tooltip" -->
						<!-- 									name="functionName1"></select> -->
						<!-- 							</div> -->




						<!-- 							<div style="margin-top: 15px;" class="col-md-4"> -->
						<!-- 								<label>Module Name :</label> <input -->
						<!-- 									class="form-control form-control-sm" type="text" -->
						<!-- 									placeholder="Enter Your Module Name" id="ModuleName1" -->
						<!-- 									name="ModuleName1"> -->
						<!-- 							</div> -->


						<!-- 							<div style="margin-top: 15px;" class="col-md-4"> -->
						<!-- 								<label>Responsibility : </label> <select id="Responsibility1" -->
						<!-- 									class="form-control form-control-sm" data-toggle="tooltip" -->
						<!-- 									name="Responsibility1"> -->
						<!-- 									<option value="">---Please Select---</option> -->
						<!-- 									<option value="End Customer">End Customer</option> -->
						<!-- 									<option value="Velox Solution">Velox Solution</option> -->
						<!-- 									<option value="Both">Both</option> -->
						<!-- 								</select> -->
						<!-- 							</div> -->

						<!-- 						</div> -->


						<!-- 						<div class="row"> -->

						<!-- 							<div style="margin-top: 15px;" class="col-md-4"> -->
						<!-- 								<label>Manager Name :</label> <select id="managerName1" -->
						<!-- 									class="form-control form-control-sm" data-toggle="tooltip" -->
						<!-- 									name="managerName1"> -->
						<!-- 								</select> -->
						<!-- 							</div> -->


						<!-- 							<div style="margin-top: 15px;" class="col-md-4"> -->
						<!-- 								<label>Team Leader Name :</label> <select id="teamLeader1" -->
						<!-- 									class="form-control form-control-sm" data-toggle="tooltip" -->
						<!-- 									name="teamLeader1"> -->
						<!-- 								</select> -->
						<!-- 							</div> -->


						<!-- 							<div style="margin-top: 15px;" class="col-md-4"> -->
						<!-- 								<label>Developer Name : </label> <select id="developer1" -->
						<!-- 									class="form-control form-control-sm" data-toggle="tooltip" -->
						<!-- 									name="developer1"> -->

						<!-- 								</select> -->
						<!-- 							</div> -->

						<!-- 						</div> -->



						<!-- 						<div class="row"> -->

						<!-- 							<div style="margin-top: 15px;" class="col-md-4"> -->
						<!-- 								<label>Start Date :</label> <input type="date" -->
						<!-- 									class="form-control pull-right" autocomplete="off" -->
						<!-- 									name="startdate1" id="startdate1" -->
						<!-- 									placeholder="Please Select Date" dateformat="dd-MM-yyyy"> -->
						<!-- 							</div> -->


						<!-- 							<div style="margin-top: 15px;" class="col-md-4"> -->
						<!-- 								<label>End Date :</label> <input type="date" -->
						<!-- 									class="form-control pull-right" autocomplete="off" -->
						<!-- 									name="enddate1" id="enddate1" placeholder="Please Select Date" -->
						<!-- 									dateformat="dd-MM-yyyy"> -->
						<!-- 							</div> -->


						<!-- 							<div style="margin-top: 15px;" class="col-md-4"> -->
						<!-- 								<label>Remark : </label> <input -->
						<!-- 									class="form-control form-control-sm" type="text" -->
						<!-- 									placeholder="Enter Remark" id="inputRemark1" -->
						<!-- 									name="inputRemark1"> -->
						<!-- 							</div> -->

						<!-- 						</div> -->

						<br>
						<!-- 						<div class="row"> -->

						<!-- 							<div class="col-md-10"> -->
						<!-- 								<label for="">Description (Optional)</label> -->
						<!-- 								<textarea id="description1" tabindex="1" class="form-control" -->
						<!-- 									name="description1" data-toogle="tooltip" -->
						<!-- 									placeholder="Enter Description"></textarea> -->

						<!-- 							</div> -->

						<!-- 						</div> -->





						<!--                                     <div style="margin-top:15px;" class="col-md-6"> -->
						<!--                                  <label >Project Implementor Name :</label> -->
						<!-- 											<div id="impl1"></div>  -->
						<!-- 											 <input -->
						<!-- 												type="text" id="projeimplementorname" tabindex="2" -->
						<!-- 												class="form-control" data-toogle="tooltip" name="projeimplementorname" placeholder="Enter Your Project Implementor Name Here " readonly> -->

						<!-- 									 </div> -->
						<!-- 							<div style="margin-top: 15px;" class="col-md-6"> -->
						<!-- 								<label>Customer Name :</label> -->
						<!-- 								<div id="Customer1"></div> -->
						<!-- 								<input type="text" id="customername" class="form-control" -->
						<!-- 									data-toogle="tooltip" name="customername" -->
						<!-- 									placeholder="Enter Your Customer Name Here " readonly> -->


						<!-- 							</div> -->


						<!-- //// new  -->

						<!-- 							<div style="margin-top: 15px;" class="col-md-6"> -->
						<!-- 								<label>Customer Implementor Name:</label> -->
						<!-- 								<div id=""></div> -->
						<!-- 								<input type="text" id="ImplementorName" class="form-control" -->
						<!-- 									data-toogle="tooltip" name="ImplementorName" -->
						<!-- 									placeholder="Enter Your Customer Implementor Name " readonly> -->

						<!-- 							</div> -->

						<!-- 							<div style="margin-top: 15px;" class="col-md-6"> -->
						<!-- 								<label>Customer Implementor Contact :</label> -->
						<!-- 								<div id=""></div> -->
						<!-- 								<input type="text" id="ImplementorNumber" class="form-control" -->
						<!-- 									data-toogle="tooltip" name="ImplementorNumber" -->
						<!-- 									placeholder="Enter Your Customer Implementor Contact " readonly> -->

						<!-- 							</div> -->


						<!-- 							<div style="margin-top: 15px;" class="col-md-6"> -->
						<!-- 								<label>Sales Manager Name:</label> -->
						<!-- 								<div id=""></div> -->
						<!-- 								<input type="text" id="SalesManagerName" class="form-control" -->
						<!-- 									data-toogle="tooltip" name="SalesManagerName" -->
						<!-- 									placeholder="Enter Your Sales Manager Name" readonly> -->

						<!-- 							</div> -->












						<br>

						<div class="col-md-12" id="inputContainer"></div>
						<br>




						<!-- //16/09 -->
						
						<!--  -->


						<div class="row">
							<div class="col-md-12">

								<ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
									<li class="nav-item"><a class="nav-link active"
										id="custom-tabs-one-home-tab" data-toggle="pill"
										href="#custom-tabs-one-home" role="tab"
										aria-controls="custom-tabs-one-home" aria-selected="true">Assigned Task</a></li>

									<!--                   <li class="nav-item"> -->
									<!--                     <a class="nav-link" id="custom-tabs-one-messages-tab" data-toggle="pill" href="#custom-tabs-one-messages" role="tab" aria-controls="custom-tabs-one-messages" aria-selected="false">Form 2</a> -->
									<!--                   </li> -->

								</ul>
								
								
								
								
								<!-- //16/09 -->
<!-- 								<br> -->
<!-- 											<table class="table" id="assignedTaskdetails"> -->
<!-- 											<thead> -->
<!-- 												<tr> -->
<!-- <!-- 													<th>PO Number</th> -->
<!-- 													<th>Product Suite</th> -->
													
<!-- 													<th>Product Tool</th> -->
<!-- 													<th>Function Name</th> -->
<!-- 													<th>Description</th> -->
<!-- 													<th>Assigned To</th> -->
<!-- 													<th>End Date</th> -->
<!-- 													<th>Status</th> -->
<!-- 													Add more columns as needed -->
<!-- 												</tr> -->
<!-- 											</thead> -->
<!-- 											<tbody> -->
<!-- 												Completed projects will be dynamically added here -->
<!-- 											</tbody> -->
<!-- 										</table> -->
								<!--  -->


								<div class="container mt-4">
	
									<div class="card">
										<div class="card-body">

											<div style="margin-bottom: 10px;">
												<div class="text-left">
													<button type="button" tabindex="8" class="btn btn-primary"
														id="addRow" name="submit" onclick="addNewRow()">
														Add Row<span class="spinner-border"
															style="width: 1rem; height: 1rem; display: none;"
															id="spin1"><i class="fa fa-refresh fa-spin fa"></i></span>
													</button>

												</div>
											</div>


											<table id="data-table1" class="col-md-12">
												<thead>
													<tr class="text-center">
														<th>Function Name:</th>
														<th>Module Name:</th>
														<th>Responsibility:</th>
<!-- 														<th>Manager Name:</th> -->
														<th>Team Leader:</th>
														<th>Developer :</th>
														<th style="width: 100px;">Start Date :</th>
														<th style="width: 100px;">End Date :</th>
														<!-- 														<th>Status :</th> -->
														<th>Remark :</th>
														<th>Delete:</th>

													</tr>
												</thead>
												<tbody>
													<tr>
														<td><select id="functionName"
															class="form-control form-control-sm"
															data-toggle="tooltip" name="functionName">

														</select></td>

														<td><input class="form-control form-control-sm"
															type="text" placeholder="Enter Your Module Name"
															id="ModuleName" name="ModuleName"></td>

														<td><select id="Responsibility"
															class="form-control form-control-sm"
															data-toggle="tooltip" name="Responsibility">
																<option value=''>-- Please Select --</option>
																<option value="End Customer">End Customer</option>
																<option value="Velox Solution">Velox Solution</option>
																<option value="Both">Both</option>
														</select></td>

<!-- 														<td><select id="managerName" -->
<!-- 															class="form-control form-control-sm" -->
<!-- 															data-toggle="tooltip" name="managerName"> -->

<!-- 														</select></td> -->

														<td><select id="teamLeader"
															class="form-control form-control-sm"
															data-toggle="tooltip" name="teamLeader">

														</select></td>

														<td><select id="developer"
															class="form-control form-control-sm"
															data-toggle="tooltip" name="developer">

														</select></td>
														<td>
															<div class="input-group">

																<input type="date" class="form-control pull-right"
																	autocomplete="off" name="startdate" id="startdate"
																	placeholder="Please Select Date"
																	dateformat="dd-MM-yyyy">
															</div>
														</td>
														<td>
															<div class="input-group">

																<input type="date" class="form-control pull-right"
																	autocomplete="off" name="enddate" id="enddate"
																	placeholder="Please Select Date"
																	dateformat="dd-MM-yyyy">
															</div>
														</td>

														<td><input class="form-control form-control-sm"
															type="text" placeholder="Enter Remark" id="inputRemark"
															name="inputRemark"></td>

														<td>
															<button onclick="deleteRow(this)"
																style="background: none; border: none; cursor: pointer;">
																<i class="fa-solid fa-trash-can fa-lg"
																	style="color: #fd4444; margin-left: 12px;"></i>
															</button>
														</td>

													</tr>
												</tbody>
											</table>
											
											
											
											
											<!-- //16/09 -->
											
											<!--  -->
										</div>
									</div>










								</div>

								<div style="margin-top: 25px;" class="col-md-12">
									<center>
										<button type="submit" tabindex="8"
											class="btn btn-primary m-t-10" id="submitDayTask"
											name="submit" data-style="expand-left"
											onclick="saveDaywiseTask()">
											Submit &nbsp;<span class="spinner-border"
												style="width: 1rem; height: 1rem; display: none;" id="spin2"></span>
										</button>
										<button type="reset" tabindex="8"
											class="btn btn-secondary m-t-10" id="Reset" name="Reset"
											onclick="ResetData();">Reset</button>
										<!--                                             <button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="Reject" name="Reject" onclick="rejectFunction();">Reject &nbsp; &nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem;display: none;" id="spin2"><i class="fa fa-refresh fa-spin fa-10x"></i></span></button>   -->
									</center>
								</div>

								<br>
								<!-- /.card -->



							</div>


						</div>
					</div>
					
				</div>
				
				<!-- //16/09 -->
				
					<div class="card" id="assignedTaskdetailsCard">
					<br>
					<ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
									<li class="nav-item"><a class="nav-link active"
										id="custom-tabs-one-home-tab" data-toggle="pill"
										href="#custom-tabs-one-home" role="tab"
										aria-controls="custom-tabs-one-home" aria-selected="true">Assigned Task</a></li>

									<!--                   <li class="nav-item"> -->
									<!--                     <a class="nav-link" id="custom-tabs-one-messages-tab" data-toggle="pill" href="#custom-tabs-one-messages" role="tab" aria-controls="custom-tabs-one-messages" aria-selected="false">Form 2</a> -->
									<!--                   </li> -->

								</ul>
					<div class="card-body">


						<br>
											<table class="table" id="assignedTaskdetails">
											<thead>
												<tr>
<!-- 													<th>PO Number</th> -->
													<th>Sr No</th>
													<th>Product Suite</th>
													
													<th>Product Tool</th>
													<th>Function Name</th>
													<th>Description</th>
													<th>Assigned To</th>
													<th>End Date</th>
													<th>Status</th>
													<!-- Add more columns as needed -->
												</tr>
											</thead>
											<tbody>
												<!-- Completed projects will be dynamically added here -->
											</tbody>
										</table>

						<!-- //16/09 -->
						
						<!--  -->


					</div>
					</div>
					
					<!--  -->
			</div>
		</div>
	</div>




	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark">
		<!-- Control sidebar content goes here -->
	</aside>
	<!-- /.control-sidebar -->

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
																	src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
	<script
																	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/moment/moment.min.js"></script>
	<script
																	src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.js"></script>
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script> -->
	<script
																	src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<script
																	src="<%=request.getContextPath()%>/static/custom/PmsimplformCdetails.js"></script>

	<script>
		$('#enddatesignoff').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdatesignoff').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdatepaymentterms').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddatepaymentterms').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdatedemo').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddatedemo').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdaterollout').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddaterollout').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdategolive').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddategolive').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdateuattesting').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddateuattesting').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdatevlxlicense').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddatevlxlicense').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});
	</script>

															</body>
</html>