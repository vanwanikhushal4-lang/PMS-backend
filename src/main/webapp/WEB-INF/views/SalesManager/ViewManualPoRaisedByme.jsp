<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manual PO View</title>
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
	
	
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

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
				<form id="form" name="form" method="post" enctype="multipart/form-data">

				<div class="card card-secondary border-secondary">

					<div class="card-header">
						<div class="row">
							<div class="col-md-4">Manual PO Raised By SI</div>

							<div class="col-md-7"></div>

							<div class="col-md-1">
								<a href="<%=request.getContextPath()%>/User/ManualpoRaisedByme">
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
								<label for="poRefNo">PO Reference No</label> <input
									type="text" class="form-control" tabindex="1" id="poRefNo"
									name="poRefNo" data-toogle="tooltip"
									placeholder="Enter PO Reference No" >
							</div>
							
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
									
									<div class="col-md-12" style="display: none;"
										id="warrantyAmcDateDIv"> <br>

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
										id="tennureDateeDiv"> <br>

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
									
									
									
									
									
									
									<div class="col-md-13" style="display: none;"
										id="warrantyAmcDateDIvView"> <br>

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
														autocomplete="off" name="warrantystartView" id="warrantystartView"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>

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
														name="warrantyendView" id="warrantyendView"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>

											</div>

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
														autocomplete="off" name="amcstartdateView" id="amcstartdateView"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>
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
														autocomplete="off" name="amcenddateView" id="amcenddateView"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>

											</div>
											
											
											
										</div>
										
										
										
										
										

									</div>
									
									
									
									<div class="col-md-12" style="display: none;"
										id="tennureDateeDivView"> <br>

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
														name="tennurestartdateView" id="tennurestartdateView"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>
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
														name="tennureenddateView" id="tennureenddateView"
														placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
												</div>

											</div>	
											
											
											<div class="col-md-3" style="margin-top: 26px;">
											
<!-- 											<button type="button" tabindex="8" class="btn btn-primary" -->
<!-- 														id="addRow" name="submit" onclick="addNewRow1()" style="width: 35%"> -->
<!-- 														Add -->
<!-- 											</button> -->

										<button id="addRowButton" class="btn btn-primary mb-3">Add
											Row</button>



									</div>
											
										</div>
								
									</div>
									
								
									<div class="rows">
									 
<!-- 											<div id="datePickerContainer" class="mt-4"> -->
         
<!--         									</div> -->

								<div class="container mt-5">
									
									<table id="dataTable" style="display: none;" class="table" >
										<thead>
											<tr>
												<th>AMC Start Date</th>
												<th>AMC End Date</th>
												<th>File Upload</th>
												<th>Payment Option</th>
												<th></th>
												<!-- Delete Button Column -->
											</tr>
										</thead>
										<tbody id="tableBody">
											<!-- Rows will be dynamically added here -->
										</tbody>
									</table>
								</div>



							</div>
									
									
									
							
							<div class="row">

							<div style="margin-top: 15px;" class="col-md-6">
								<label for="ponumber">Purchase Order No</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="email"></label> <input type="text" id="ponumber"
									tabindex="1" class="form-control" name="ponumber"
									data-toogle="tooltip" placeholder="Enter PO No" readonly>
							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="customername">Customer Name</label> <input
									type="text" class="form-control" tabindex="1" id="customername"
									name="customername" data-toogle="tooltip"
									placeholder="Enter Customer Name" readonly>
							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="podate">Purchase Order Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="email"></label> <input type="text" id="podate" tabindex="1"
									class="form-control" name="podate" data-toogle="tooltip"
									readonly>
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


<!-- 							<div style="margin-top: 15px;" class="col-md-6"> -->
<!-- 								<label for="proddescrip">Product Description</label><label -->
<!-- 									id="bname1"></label> -->
<!-- 								<div class="form-group" id="proddescrip11"> -->
<!-- 									<input type="text" id="proddescrip" tabindex="1" -->
<!-- 										class="form-control" name="proddescrip" data-toogle="tooltip" -->
<!-- 										placeholder="Enter Product Description" readonly> -->
<!-- 								</div> -->

<!-- 							</div> -->
							<!-- 							<div style="margin-top: 15px;" class="col-md-6"> -->
							<!-- 								<label for="customername">Customer Name</label> <input -->
							<!-- 									type="text" class="form-control" tabindex="1" id="customername" -->
							<!-- 									name="customername" data-toogle="tooltip" -->
							<!-- 									placeholder="Enter Customer Name" readonly> -->
							<!-- 							</div> -->






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
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="paymentterms">Payment Terms</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="email"></label> <input type="text" id="paymentterms"
									tabindex="1" class="form-control" name="paymentterms"
									data-toogle="tooltip" placeholder="Enter Payment Terms"
									readonly="true">
							</div>

							<!-- 							<div style="margin-top: 15px;display: none;" id="warrantystartDiv" class="col-md-6"> -->
							<!-- 								<label for="warrantystart">Warranty Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label -->
							<!-- 									id="phnnno"></label> <input type="text" id="warrantystart" -->
							<!-- 									tabindex="1" class="form-control" name="warrantystart" -->
							<!-- 									data-toogle="tooltip" readonly> -->
							<!-- 							</div> -->

							<!-- 							<div style="margin-top: 15px;display: none;" id="warrantyendDiv" class="col-md-6"> -->

							<!-- 								<label for="warrantyend">Warranty End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label -->
							<!-- 									id="phnnno"></label> <input type="text" id="warrantyend" -->
							<!-- 									tabindex="1" class="form-control" name="warrantyend" -->
							<!-- 									data-toogle="tooltip" readonly> -->

							<!-- 							</div> -->

							<!-- 							<div style="margin-top: 15px;display: none;" id="amcstartdateDiv" class="col-md-6"> -->
							<!-- 								<label for="amcstartdate">AMC Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label -->
							<!-- 									id="phnnno"></label> <input type="text" id="amcstartdate" -->
							<!-- 									tabindex="1" class="form-control" name="amcstartdate" -->
							<!-- 									data-toogle="tooltip" readonly> -->
							<!-- 							</div> -->

							<!-- 							<div style="margin-top: 15px;display: none;" class="col-md-6" id="amcenddateDiv"> -->

							<!-- 								<label for="amcenddate">AMC End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label -->
							<!-- 									id="phnnno"></label> <input type="text" id="amcenddate" -->
							<!-- 									tabindex="1" class="form-control" name="amcenddate" -->
							<!-- 									data-toogle="tooltip" readonly> -->

							<!-- 							</div> -->

							<!-- 								<div style="margin-top: 15px;display: none;" class="col-md-6" id="tennurestartdateDiv"> -->
							<!-- 								<label for="tennurestartdate">Tennure Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label -->
							<!-- 									id="phnnno"></label> <input type="text" id="tennurestartdate" -->
							<!-- 									tabindex="1" class="form-control" name="tennurestartdate" -->
							<!-- 									data-toogle="tooltip" readonly> -->
							<!-- 							</div> -->

							<!-- 							<div style="margin-top: 15px;display: none;" class="col-md-6" id="tennureenddateDiv"> -->

							<!-- 								<label for="tennureenddate">Tennure End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label -->
							<!-- 									id="phnnno"></label> <input type="text" id="tennureenddate" -->
							<!-- 									tabindex="1" class="form-control" name="tennureenddate" -->
							<!-- 									data-toogle="tooltip" readonly> -->

							<!-- 							</div> -->




							<!-- 							<div style="margin-top: 15px; display: none;" class="col-md-6"> -->
							<!-- 								<label for="change">Advance Invoice, if Yes/NO </label><label -->
							<!-- 									id="phnnno"></label> <input type="text" id="advaninvoice" -->
							<!-- 									tabindex="1" class="form-control" name="advaninvoice" -->
							<!-- 									data-toogle="tooltip" placeholder="Add Invoice Yes/No" readonly> -->

							<!-- 							</div> -->

							<!--                                       <div style="margin-top:15px;" class="col-md-6"> -->
							<!--                                        <label style="margin-left: 2px">File Attachment:<br> -->
							<!--                                                 <span class="vlx" style="color: green;width: 450px" id="pouploadfile"></span></label><button class="button1 button4" id="pouploadfile" onclick="downFileDefect()">Download</button> -->


							<!--                                         <input type="hidden" id="pouploadfile" name="pouploadfile"> -->

							<!--                                     </div> -->

							<!-- 							<div style="margin-top: 15px;" class="col-md-6"></div> -->

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="poUploadDiv">
								<label style="margin-left: 2px"> PO File :<br> <span
									class="col-md-6" style="color: green; width: 450px"
									id="pouploadfile"></span></label>
								<button class="button1 button4" id="downHidepofile"
									onclick="downFileStandard()">Download</button>
							</div>
							<input type="hidden" id="filenameStandard"
								name="filenameStandard">


<!-- 							<div style="margin-top: 15px; display: none;" class="col-md-6" -->
<!-- 								id="proposalUploadDiv"> -->
<!-- 								<label style="margin-left: 2px"> Commercial Proposal -->
<!-- 									File :<br> <span class="col-md-6" -->
<!-- 									style="color: green; width: 450px" id="proposalfile"></span> -->
<!-- 								</label> -->
<!-- 								<button class="button1 button4" id="downHideproposalfile" -->
<!-- 									onclick="proposalStandard()">Download</button> -->

<!-- 							</div> -->
<!-- 							<input type="hidden" id="filnameProposal" name="filnameProposal"> -->



<!-- 							<div style="margin-top: 15px; display: none;" class="col-md-6" -->
<!-- 								id="maskedPOUploadDiv"> -->
<!-- 								<label style="margin-left: 2px"> Masked PO File :<br> -->
<!-- 									<span class="col-md-6" style="color: green; width: 450px" -->
<!-- 									id="maskedPOfile"></span></label> -->
<!-- 								<button class="button1 button4" id="downHidemaskedPOfile" -->
<!-- 									onclick="maskedPOStandard()">Download</button> -->

<!-- 							</div> -->
<!-- 							<input type="hidden" id="filnameMaskedPO" name="filnameMaskedPO"> -->



<!-- 							<div style="margin-top: 15px; display: none;" class="col-md-6" -->
<!-- 								id="productFeaturedUploadDiv"> -->
<!-- 								<label style="margin-left: 2px">Product Featured File -->
<!-- 									List:<br> <span class="col-md-6" -->
<!-- 									style="color: green; width: 450px" id="productFeaturedFile"></span> -->
<!-- 								</label> -->
<!-- 								<button class="button1 button4" id="downHideproductFeaturedfile" -->
<!-- 									onclick="productFeaturedStandard()">Download</button> -->

<!-- 							</div> -->
<!-- 							<input type="hidden" id="filnameProductFeatured" -->
<!-- 								name="filnameProductFeatured"> -->



							<!--                                     <div style="margin-top:15px;" class="col-md-6"> -->
							<!--                                          <input -->
							<!-- 											type="file" id="advinvoicefile" name="advinvoicefile" -->
							<!-- 											class="form-control" style="height: 36px;display: none;"> -->
							<!--                                     </div> -->
<!-- 							<div style="margin-top: 15px; display: none;" class="col-md-6" -->
<!-- 								id="advInvoiceUploadDiv"> -->
<!-- 								<label style="margin-left: 2px"> Advance Invoice :<br> -->
<!-- 									<span class="vlx" style="color: green; width: 450px" -->
<!-- 									id="advinvoicefile"></span></label> -->
<!-- 								<button class="button1 button4" id="downHideadvInvfile" -->
<!-- 									onclick="advInvFileStandard()">Download</button> -->

<!-- 							</div> -->
<!-- 							<input type="hidden" id="filnameAdvinvoice" -->
<!-- 								name="filnameAdvinvoice"> -->



</div>
						
	
									<div class="row">
										<div style="margin-top: 15px;" class="col-md-12">
											<center>
												<button type="button" class="btn btn-primary m-t-10"
													id="update-btn" name="update-btn">
													Update &nbsp;<span class="spinner-border"
														style="width: 1rem; height: 1rem; display: none;"
														id="spin">
												</button>

<!-- 												 <button type="button" id="uploadButton">Upload</button> -->
											</center>
										</div>

									</div>
									
						<br>
						</div>
<!-- 						<div class="row" style="display: none;" id="SInoteDiv"> -->

<!-- 							<div class="col-md-10"> -->
<!-- 								<label for="techniq">Note (SI)</label> -->
<!-- 								<textarea id="SInote" tabindex="1" class="form-control" -->
<!-- 									name="SInote" data-toogle="tooltip" placeholder="Enter Note" -->
<!-- 									readonly></textarea> -->

<!-- 							</div> -->

<!-- 						</div> -->


						



					</div>




</form>
				</div>


			</div>
			<!-- 				</div> -->
							
			<!-- 			</div> -->





			<br>
		</div>


		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	<!-- ./wrapper -->
	<!-- jQuery -->
	
  $.widget.bridge('uibutton', $.ui.button)
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
		src="<%=request.getContextPath()%>/static/custom/ViewManualPoRaisedByme.js"></script>



<script>
$('#tennurestartdate').datepicker({
    autoclose: true,
    format: 'dd-mm-yyyy',
    todayHighlight: !0,
    orientation: "bottom",
}).on('change', function () {

});   

// $('#tennureenddate').datepicker({
//     autoclose: true,
//     format: 'dd-mm-yyyy',
//     todayHighlight: !0,
//     orientation: "bottom",
// }).on('change', function () {

// });   
  
$('#warrantystart').datepicker({
    autoclose: true,
    format: 'dd-mm-yyyy',
    todayHighlight: !0,
    orientation: "bottom",
}).on('change', function () {

});   

  


</script>

</body>
</html>