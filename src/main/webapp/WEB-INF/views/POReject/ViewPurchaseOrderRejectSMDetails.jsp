<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Rejected Purchase Order</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/fontawesome.min.css">



<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">
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

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">

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

					<div class="card-header">
						<div class="row">
							<div class="col-md-4">View Rejected Purchase Order</div>

							<div class="col-md-7"></div>

							<div class="col-md-1">
								<a
									href="<%=request.getContextPath()%>/User/PurchaseOrderRejectedSI">
									<i class="fa fa-backward pull-right" style="color: white">
								</i>
								</a>
							</div>


						</div>

					</div>

					<div class="card-body">
						<!--  <hr> -->

						<div class="row">

							<div class="col-md-6" style="margin-top: 15px;">
								<label for="">Proposal Type :</label> <select id="Proposaltype"
									class="form-control" data-toogle="tooltip" name="Proposaltype"
									onchange="proposaltypedata()">
									<option value="">---Please Select---</option>

								</select>

							</div>

							<div class="col-md-6" style="margin-top: 15px; display: none;"
								id="perpetualhideid">
								<label for="">Perpetual Year :</label> <select
									id="Perpetualyear" class="form-control" data-toogle="tooltip"
									name="Perpetualyear" onchange="getProposaldata()">
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
								id="proposalidDIv">
								<label>Proposal ID's :</label> <select id="proposalids"
									class="form-control" data-toggle="tooltip" name="proposalids">
									<!-- Add your <option> elements here if needed -->
								</select>

								<!-- 													<option value="">--Please Select Proposal ID--</option> -->


							</div>

							<div style="margin-top: 25px; display: none;" class="col-md-6"
								id="poUploadDiv">
								<label style="margin-left: 2px">Velox Proposal
									Attachment:<br> <span class="col-md-6"
									style="color: green; width: 450px" id="vpuploadfileProposal"></span>
								</label>
								<button class="button1 button4" id="downHidepofile"
									onclick="downFileStandard()">Download</button>
							</div>
							<input type="hidden" id="filenameStandard"
								name="filenameStandard">




						</div>
						<br>

						<!--                                  <div class="row"> -->


						<!--                                  </div> -->
						<hr>

						<form id="form" name="form" method="post"
							enctype="multipart/form-data">
							<br>
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-4">
									<label for="ponumber">PO Number</label> <input type="text"
										id="ponumber" class="form-control" data-toogle="tooltip"
										name="ponumber" onchange="poNumberFun()"
										placeholder="Enter PO Number">


								</div>
								<div class="col-md-1"></div>
								<!-- 										<div class="col-md-6"> -->
								<!-- 										<label>From Date:</label> -->
								<!-- 										<div class="input-group"> -->
								<!-- 											<div class="input-group-prepend"> -->
								<!-- 												<span class="input-group-text"> <i -->
								<!-- 													class="far fa-calendar-alt"></i> -->
								<!-- 												</span> -->
								<!-- 											</div> -->
								<!-- 											<input type="text" id="FromDate" ="1" -->
								<!-- 												class="form-control" name="fromdate" -->
								<!-- 												placeholder="Please Select From Date" readonly> -->
								<!-- 										</div> -->
								<!-- 									</div> -->
								<div class="col-md-4">
									<!-- 											<label for="podate">PO Date</label> <input type="date" -->
									<!-- 												id="podate" ="5" -->
									<!-- 												class="form-control form-control-sm" name="podate" onchange="poDateFun()" -->
									<!-- 												data-toogle="tooltip" placeholder="Enter Payment Terms"> -->

									<label>PO Date</label>
									<div class="input-group">
										<div class="input-group-prepend">
											<span class="input-group-text"> <i
												class="far fa-calendar-alt"></i>
											</span>
										</div>
										<input type="text" class="form-control pull-right"
											autocomplete="off" name="podate" id="podate"
											onchange="poDateFun()" placeholder="Please Select PO Date"
											dateformat="dd-MMM-yyyy" readonly>
									</div>
								</div>
								<div class="col-md-1"></div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-4">
									<label for="customername">Customer Name</label> <select
										id="customername" class="form-control" data-toogle="tooltip"
										name="customername" onchange='poCustomerName()'>
										<option value="">--Please Select Customer Name--</option>

									</select>
								</div>
								<div class="col-md-1"></div>

								<!-- 										<div class="col-md-4"> -->
								<!-- 											<label for="productsuit">Product Suit:</label> <select -->
								<!-- 												id="productsuit" ="9" class="form-control" -->
								<!-- 												data-toogle="tooltip" name="productsuit"onchange="sectools()"> -->
								<!-- 												<option value="">--Please Select Product Suit -->
								<!-- 													Name--</option> -->

								<!-- 											</select> -->
								<!-- 										</div> -->

								<div class="col-md-4">
									<label for="productsuit1">Product Suit:</label>
									<!-- 											<div class="form-group" id="groupCatDiv2ser"> -->
									<select id="productsuit" class="form-control"
										data-toogle="tooltip" name="productsuit" multiple="multiple">


									</select>

								</div>

								<div class="col-md-1"></div>
							</div>
							<br>

							<div class="row">
								<div class="col-md-1"></div>

								<!-- 										<div class="col-md-4"> -->
								<!-- 											<label for="securitytool">Security Tools :</label> <select -->
								<!-- 												id="securitytool" ="9" class="form-control" -->
								<!-- 												data-toogle="tooltip" name="securitytool"> -->
								<!-- 												<option value="">--Please Select Security Tools -->
								<!-- 													Name--</option> -->

								<!-- 											</select> -->
								<!-- 										</div> -->

								<div class="col-md-4">
									<label for="securitytool1">Security Tools :</label> <select
										id="securitytool" class="form-control" data-toogle="tooltip"
										name="securitytool" multiple="multiple">
									</select>

								</div>



								<div class="col-md-1"></div>
								<div class="col-md-4">
									<label for="prodamount">Product Amount:</label> <input
										type="text" id="prodamount" class="form-control"
										data-toogle="tooltip" name="prodamount"
										placeholder="Enter Product Amount"
										oninput="this.value = this.value.replace(/[^0-9]/g, '');">

								</div>
								<div class="col-md-1"></div>
							</div>

							<br>
							<div class="row">
								<div class="col-md-1"></div>


								<div class="col-md-4">
									<label for="paymentterms">Payment Terms</label>
									<!-- 											<input -->
									<!-- 												type="text" id="paymentterms" ="5" -->
									<!-- 												class="form-control form-control-sm" name="paymentterms" -->
									<!-- 												data-toogle="tooltip" placeholder="Enter Payment Terms"> -->

									<textarea id="paymentterms" name="paymentterms"
										data-toogle="tooltip" placeholder="Enter Payment Terms"
										class="form-control form-control-sm"></textarea>

								</div>
								<div class="col-md-1"></div>
								<div class="col-md-4">
									<label for="prodliscense">Product License:</label> <input
										type="text" id="prodliscense" class="form-control"
										data-toogle="tooltip" name="prodliscense"
										placeholder=" Enter Product License">


								</div>
								<div class="col-md-1"></div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-4">
									<label for="pouploadfile">Upload PO File </label> <span
										class="col-md-6" style="color: green; width: 450px"
										id="pouploadfile"></span> <input type="file" id="pouploadfile"
										name="pouploadfile" class="form-control" style="height: 36px">



									<!-- 									<input type="hidden" id="filenameStandard" -->
									<!-- 										name="filenameStandard"> -->
								</div>
								<div class="col-md-1"></div>
								<div class="col-md-4">
									<label for="proddescrip">Product Description</label> <input
										type="text" id="proddescrip"
										class="form-control form-control-sm" name="proddescrip"
										data-toogle="tooltip" placeholder="Enter Product Description">
								</div>
								<div class="col-md-1"></div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-4">
									<label for="massPOfile">Masked Upload PO File</label> <input
										type="file" id="massPOfile" name="massPOfile"
										class="form-control" style="height: 36px">
								</div>


								<div class="col-md-1"></div>
								<div class="col-md-4">
									<label for="productFeaturedFileList">Upload Product
										Featured File List</label> <input type="file"
										id="productFeaturedFileList" name="productFeaturedFileList"
										class="form-control" style="height: 36px">


								</div>
								<div class="col-md-1"></div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-1"></div>




								<div style="margin-top: 15px; display: none;" class="col-md-4"
									id="podownloadfileDiv">
									<label style="margin-left: 2px">Download PO File :<br>
										<span class="col-md-6" style="color: green; width: 450px"
										id="poDownloadfile"></span></label>
									<button class="button1 button4" id="downHidePOdownloadfile"
										onclick="downPOdownloadFileStandard()">Download</button>
								</div>
								<input type="hidden" id="poDownloadfilenameStandard"
									name="poDownloadfilenameStandard">


								<div class="col-md-1"></div>
								<div style="margin-top: 15px; display: none;" class="col-md-6"
									id="maskedPOUploadDiv">
									<label style="margin-left: 2px"> Masked PO File :<br>
										<span class="col-md-6" style="color: green; width: 450px"
										id="maskedPOfile"></span></label>
									<button class="button1 button4" id="downHidemaskedPOfile"
										onclick="maskedPOStandard()">Download</button>

								</div>
								<input type="hidden" id="filnameMaskedPO" name="filnameMaskedPO">
								<div class="col-md-1"></div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-1"></div>



								<div style="margin-top: 15px; display: none;" class="col-md-6"
									id="productFeaturedUploadDiv">
									<label style="margin-left: 2px">Product Featured File
										List:<br> <span class="col-md-6"
										style="color: green; width: 450px" id="productFeaturedFile"></span>
									</label>
									<button class="button1 button4"
										id="downHideproductFeaturedfile"
										onclick="productFeaturedStandard()">Download</button>

								</div>
								<input type="hidden" id="filnameProductFeatured"
									name="filnameProductFeatured">


								<div class="col-md-1"></div>
								<div class="col-md-4"></div>
								<div class="col-md-1"></div>
							</div>
							<br>
							<hr>

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
											<input type="text" class="form-control pull-right"
												name="warrantystart" id="warrantystart"
												placeholder="Please Select  Date" dateformat="dd-MMM-yyyy"
												readonly>
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
										<!-- 															<div class="input-group"> -->
										<!-- 																<div class="input-group-prepend"> -->
										<!-- 																	<span class="input-group-text"> <i -->
										<!-- 																		class="far fa-calendar-alt"></i> -->
										<!-- 																	</span> -->
										<!-- 																</div> -->
										<!-- 																<input type="text"  -->
										<!-- 																	class="form-control pull-right"  -->
										<!-- 																	name="warrantyend" id="warrantyend"  -->
										<!-- 																	placeholder="Please Select  Date" -->
										<!-- 																	dateformat="dd-MMM-yyyy"> -->
										<!-- 															</div> -->
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i
													class="far fa-calendar-alt"></i>
												</span>
											</div>
											<input type="text" class="form-control pull-right"
												name="warrantyend" id="warrantyend"
												placeholder="Please Select  Date" dateformat="dd-MMM-yyyy"
												readonly>
										</div>

									</div>

								</div>
								<br> <br>


								<div class="row">


									<div class="col-md-3">
										<label for="amcstartdate">AMC Start Date:</label>

										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i
													class="far fa-calendar-alt"></i>
												</span>
											</div>
											<input type="text" class="form-control pull-right"
												autocomplete="off" name="amcstartdate" id="amcstartdate"
												placeholder="Please Select  Date" dateformat="dd-MMM-yyyy"
												readonly>
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
											class="form-control" data-toogle="tooltip" name="AMCMonth"
											placeholder="Add AMC Month" onchange="AMCendmonth()"
											oninput="this.value = this.value.replace(/[^0-9]/g, '');">

									</div>

									<div class="col-md-3" style="display: none;" id="AMCYearDiv">
										<label>Year :</label> <input id="AMCYear" class="form-control"
											data-toogle="tooltip" name="AMCYear"
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
											<input type="text" class="form-control pull-right"
												autocomplete="off" name="amcenddate" id="amcenddate"
												placeholder="Please Select  Date" dateformat="dd-MMM-yyyy"
												readonly>
										</div>

									</div>
								</div>

								<br>

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
											<input type="text" readonly class="form-control pull-right"
												autocomplete="off" name="tennurestartdate"
												id="tennurestartdate" placeholder="Please Select  Date"
												dateformat="dd-MMM-yyyy">
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
											class="form-control" data-toogle="tooltip" name="tennureYear"
											placeholder="Add Tennure Year" onchange="tennureendYear()"
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



							<!-- 									<hr> -->
							<!-- 									<br> -->
							<!-- 									<div class="row"> -->
							<!-- 										<div class="col-md-1"></div> -->
							<!-- 										<div class="col-md-4"> -->
							<!--                                                      <label>Advance Invoice for Payment, if Yes/NO </label><br> -->
							<!--                                         <select -->
							<!-- 												id="advaninvoice" class="form-control" ="6" -->
							<!-- 												data-toogle="tooltip" name="advaninvoice" onchange="advaninvoiceyes()"> -->
							<!-- 												<option value="">--Please Select--</option> -->
							<!-- 												<option value="Yes">Yes</option> -->
							<!-- 												<option value="No">No</option> -->
							<!-- 											</select> -->
							<!-- 										</div> -->
							<!-- 										<div class="col-md-1"></div> -->
							<!-- 										<div class="col-md-4"> -->
							<!-- 										<br><br> -->
							<!-- 											<input type="file" id="advinvoicefile" name="advinvoicefile" -->
							<!-- 												class="form-control" style="height: 36px; display: none;"> -->
							<!-- 										</div> -->
							<!-- 										<div class="col-md-1"></div> -->
							<!-- 									</div> -->


							<br>
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

							</div>
							<br>

							<div class="row">

								<div class="col-md-10">
									<label for="techniq">Note (SI)</label>
									<textarea id="SInote" tabindex="1" class="form-control"
										name="SInote" data-toogle="tooltip" placeholder="Enter Note"></textarea>

								</div>

							</div>
							<br> <br>
							<div class="row">
								<div style="margin-top: 15px;" class="col-md-12">
									<center>
										<button class="btn btn-primary" type="button" id="update-btn"
											name="update-btn" onclick="updateData()">
											Update <span class="spinner-border"
												style="width: 1rem; height: 1rem; display: none;" id="spin"></span>
										</button>

										<button class="btn btn-primary" type="button" id="reset-btn"
											name="reset-btn" value="Reset" onclick="resetAll()">Reset</button>
									</center>

								</div>

							</div>

						</form>
					</div>




				</div>


			</div>
		</div>

		<!-- 	</div> -->





		<br>



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


	<script
		src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js"
		type="text/javascript"></script>


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

	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

	<%-- <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.js"></script>
    
   <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.min.js"></script>

<script src="<%=request.getContextPath()%>/static/Datepicker/js/bootstrap-datepicker.min.js"></script> --%>


	<script
		src="<%=request.getContextPath()%>/static/custom/ViewPurchaseOrderRejectSMDetails.js"></script>

	<script>
		$('#podate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#warrantystart').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#warrantyend').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#amcstartdate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#amcenddate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

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

		$('#tennurestartdate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#tennureenddate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});
	</script>

</body>
</html>