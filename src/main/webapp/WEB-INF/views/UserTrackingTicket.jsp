<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Tracking</title>
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

/* Styles for the modal */
.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 200%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.7);
}

/* Styles for the modal content */
.modal-content {
	background-color: #f4f4f4;
	margin: 1% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 200%; /* Increase width to 70% */
	height: 100%;
	margin-left: -44%; /* Increase height to 70% */
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<%-- 		<jsp:include page="/WEB-INF/views/dashboardheaderUser.jsp"></jsp:include> --%>

		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">

			<section class="content-header">
				<div id="searchID">
					<div class="row">
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<br> <br>
							<div class="card card-secondary" id="trackinghideid">
								<div class="card-header">Tracking</div>
								<div class="card-body">
								
								
									<div class="row">
										<div class="col-md-6" id ="SelectActiveDiv">

										<label for="">Tracking Type :</label> <select
											id="selectType2" tabindex="9" class="form-control"
											data-toogle="tooltip" name="selectType2" onchange="TrackType()">
											<option value="">---Please Select---</option>
											<option value="With Date">With Date</option>
											<option value="Active">Active</option>
											<option value="In-Active">In-Active</option>
										</select>
									</div>
									
									
										<div class="col-md-6">

										<label for="">Select PO/VP Type :</label> <select
											id="selecttype" tabindex="9" class="form-control"
											data-toogle="tooltip" name="selecttype"	
											onchange="selectionType()">
											<option value="">---Please Select---</option>
											<option value="Purchase Order">Purchase Order</option>
											<option value="Velox Proposal" id="CommercialType">Commercial Proposal</option>
											<option value="AMC Order">AMC Order</option>
										</select>
									</div>
										
										</div>
								
								
									<div class="row" id="DatesDiv" style="display:none; margin-top:15px;">

										<!--                                           <div class="col-md-3"></div> -->

										<div class="col-md-6">
											<label for="fromDate">From Date:</label>

											<!-- 											 <input class="form-control form-control-sm" type="date" -->
											<!-- 												id="fromDate" name="fromDate" required> -->

											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="far fa-calendar-alt"></i>
													</span>
												</div>
												<input type="text" readonly class="form-control pull-right"
													autocomplete="off" name="fromDate" id="fromDate"
													placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
											</div>

											<!-- 											<label> Time Period :</label> <select class="form-control" -->
											<!-- 												onchange="javascript:getlastData(this.value)" -->
											<!-- 												name="selectmonthOfGroupTicket" -->
											<!-- 												id="selectmonthOfGroupTicket"> -->
											<!-- 												<option value="lastday">Last 24 Hour</option> -->
											<!-- 												<option value="lastweek">Last Week</option>												 -->
											<!-- 												<option value="lastmonthFinal">Last Month</option> -->
											<!-- 												<option value="lastthreemonth">Last Three Months</option> -->
											<!-- 												<option value="lastsixmonth">Last Six Months</option> -->
											<!-- <!-- 												<option value="all">All Tickets</option> -->

											<!-- 											</select> -->  
										</div>
										
										
									
										
										

										<div class="col-md-6">

											<label for="toDate">To Date:</label>

											<!-- 											<input class="form-control form-control-sm" type="date" -->
											<!-- 												id="toDate" name="toDate" required> -->

											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="far fa-calendar-alt"></i>
													</span>
												</div>
												<input type="text" readonly class="form-control pull-right"
													autocomplete="off" name="toDate" id="toDate"
													placeholder="Please Select  Date" dateformat="dd-MMM-yyyy">
											</div>

										</div>
									</div>
									<br>

									
									
									
									
									<br>
									<div class="row">   

										<div class="col-md-12 text-center">
										
										 <button type="button" tabindex="8" class="btn btn-primary m-t-10" id="submit-btn" name="submit-btn" data-style="expand-left">
                            Submit&nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem; display: none;" id="spin11">
                                <i class="fa fa-refresh fa-spin fa-10x"></i>
                            </span>
                        </button>
											
											 <input type="reset" tabindex="3"
												class="btn btn-primary m-t-10" id="resetbtn" name="reset"
												value="Reset">
										</div>

									</div>

								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>

				</div>

				<br> <br> <br>


				<!--     <div class="content-wrapper"> -->
				<section class="content-header" style="margin-top: -10%;">


				</section>
				<div
					style="padding-left: 15px; padding-right: 15px; margin-top: 25px; display: none;"
					id="potable">
					<div class="card card-secondary border-secondary">
						<div class="card-header">
							Tracking Details <a
								href="<%=request.getContextPath()%>/User/UserTrackingTicket">
								<i class="fa fa-backward pull-right"
								style="color: white; margin-left: 86%;"></i>
							</a>

						</div>
						<div class="card-body">

							<div id="eeeew">

								<table class="table table1 table-striped" id="CMApprByMeTable">
									<thead>
										<tr>
											<th>View</th>
											<th>PO ID</th>
											<th>PO Type</th>
											<th>PO Number</th>
											<th>PO Date</th>
											<!-- 											<th>Customer Name</th> -->
											<!-- 											<th>Product Suite</th> -->
											<th>Raise Date</th>
											<th>Amount Without GST</th>
											<th>Checked By SM Name</th>
											<!--                                         <th>Security Tools</th> -->
											<!--                                         <th>Warranty Start Date</th> -->
											<!--                                         <th>Warranty End Date</th> -->
											<!--                                         <th>Warranty Remaining Days</th> -->
											<!--                                         <th>AMC Start Date</th> -->
											                                        <th>AMC End Date</th>
											                                        <th>Tenure End Date</th>
											<!--                                         <th>AMC Remaining Days</th> -->


											<!--                                         <th>Ticket ID</th> -->


										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
							</div>

						</div>
					</div>
				</div>


				<div
					style="padding-left: 15px; padding-right: 15px; margin-top: 25px; display: none;"
					id="vlxprop">
					<div class="card card-secondary border-secondary">
						<div class="card-header">
							Tracking Details <a
								href="<%=request.getContextPath()%>/User/UserTrackingTicket">
								<i class="fa fa-backward pull-right"
								style="color: white; margin-left: 86%;"></i>
							</a>

						</div>
						<div class="card-body">

							<div id="eeeew1">

								<table class="table table1 table-striped"
									id="CMApprByMeTableproposal">
									<thead>
										<tr>
											<th>View</th>
											<th>VP ID</th>
											<th>Status</th>
											<th>Proposal Type</th>
											<th>Customer Name</th>
											<th>End Customer Name</th>
											<!-- 											<th>Security Tools</th> -->
											<th>Maker Name</th>
											<th>Raise Date</th>
											<th>Amount Without GST</th>
											<th>Checked By SM Name</th>
											<!--                                         <th>Security Tools</th> -->
											<!--                                         <th>Warranty Start Date</th> -->
											<!--                                         <th>Warranty End Date</th> -->
											<!--                                         <th>Warranty Remaining Days</th> -->
											<!--                                         <th>AMC Start Date</th> -->
											                                        <th>AMC End Date</th>
											                                         <th>Tenure End Date</th>
											<!--                                         <th>AMC Remaining Days</th> -->


											<!--                                         <th>Ticket ID</th> -->


										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
							</div>

						</div>
					</div>
				</div>


				<div
					style="padding-left: 15px; padding-right: 15px; margin-top: 25px; display: none;"
					id="amcOrderDiv">
					<div class="card card-secondary border-secondary">
						<div class="card-header">
							Tracking Details <a
								href="<%=request.getContextPath()%>/User/UserTrackingTicket">
								<i class="fa fa-backward pull-right"
								style="color: white; margin-left: 86%;"></i>
							</a>

						</div>
						<div class="card-body">

							<div id="eeeew">

								<table class="table table1 table-striped" id="AmcTable">
									<thead>
										<tr>
											<th>View</th>
											<th>PO ID</th>
											<th>PO Type</th>
											<th>Proposal Type</th>
											<th>PO Number</th>
											<th>Product Suite</th>
											<th>Security Tools</th>
											<th>PO Date</th>
																						<th>Customer Name</th>
											
											<th>Raise Date</th>
											<th>Amount Without GST</th>
											<th>Checked By SM Name</th>

<!-- 											<th>Warranty Start Date</th> -->
<!-- 											<th>Warranty End Date</th> -->
											<!--                                         <th>Warranty Remaining Days</th> -->
											<th>AMC Start Date</th>
											<th>AMC End Date</th>
<!-- 											<th>Fixed Year</th> -->
											<!--                                         <th>AMC Remaining Days</th> -->


											<!--                                         <th>Ticket ID</th> -->


										</tr>
									</thead>
									<tbody>

									</tbody>

								</table>
							</div>

						</div>
					</div>
				</div>

				<br>


				<div class="row">

					<div class="modal fade bs-example-modal-lg modal-default1111"
						id="searchResult" tabindex="-1" role="dialog"
						aria-labelledby="myLargeModalLabel" aria-hidden="true">

						<div class="modal-dialog">
							<div class="modal-content" style="width: 180%;">
								<div class="modal-header bg-secondary">
									<h4 class="modal-title" id="myLargeModalLabel">Tracking
										Details</h4>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close" style="margin-right: 10px">
										<span aria-hidden="true">&times;</span>
									</button>



								</div>
								<div class="modal-body">
									<!--<form action="">-->
									<div id="searchResult_po" style="display: none">
										<div class="row">

											<!-- 						<div class="col-md-1"></div> -->
											<div class="col-md-12">

												<!-- 							<div class="card card-secondary"> -->
												<!-- 								<div class="card-header"> -->

												<!-- 									<div class="row"> -->
												<!-- 										<div class="col-md-4">Tracking Details</div> -->

												<!-- 										<div class="col-md-7"></div> -->

												<!-- 										<div class="col-md-1"> -->
												<!-- 											<a -->
												<%-- 												href="<%=request.getContextPath()%>/User/UserTrackingTicket"> --%>
												<!-- 												<i class="fa fa-backward pull-right" style="color: white"> -->
												<!-- 											</i> -->
												<!-- 											</a> -->
												<!-- 										</div> -->


												<!-- 									</div> -->
												<!-- 								</div> -->
												<div class="card-body">

													<!-- 										<div class="card-body"> -->

													<div class="row">
														<div class="col-md-12 text-center">
															<h2>
																Tracking Details Of <span id="T_ID"></span>
															</h2>
														</div>
													</div>



													<br>
													<div class="row">
														<div class="col-12">
															<div class="col-md-1"></div>
															<div class="col-md-6">
																<span id="Label1"
																	style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">
																	Details :</span>
															</div>
														</div>
													</div>

													<div class="row">


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="vpproptype">Proposal Type :</label> <input
																type="text" class="form-control" tabindex="1"
																id="vptype" name="vptype" data-toogle="tooltip"
																placeholder="Enter Proposal Type" readonly>
														</div>

														<div style="margin-top: 15px; display: none;"
															class="col-md-4" id="vpperepetualdiv">
															<label for="vpperpet">Perpetual Year :</label> <input
																type="text" class="form-control" tabindex="1"
																id="vpperepetual" name="vpperepetual"
																data-toogle="tooltip" placeholder="Enter Perpetual Year"
																readonly>
														</div>


														<div style="margin-top: 15px; display: none;"
															class="col-md-4" id="vpsubscriptiondiv">
															<label for="vpsubscrip">Subscription Year :</label> <input
																type="text" class="form-control" tabindex="1"
																id="vpsubscription" name="vpsubscription"
																data-toogle="tooltip"
																placeholder="Enter Subscription Year" readonly>
														</div>


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="potype"> Customer Name :</label> <input
																type="text" class="form-control" tabindex="1"
																id="vpcustomername" name="vpcustomername"
																data-toogle="tooltip"
																placeholder="Enter VP Customer Name" readonly>
														</div>



													</div>




													<div class="row">


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="vprescamt">Resources Amount:</label> <input
																type="text" class="form-control" tabindex="1"
																id="vpresourceamount" name="vpresourceamount"
																data-toogle="tooltip"
																placeholder="Enter Resource Amount " readonly>
														</div>

														<div style="margin-top: 15px;" class="col-md-4">
															<label for="vpatctype">ATC :</label> <input type="text"
																class="form-control" tabindex="1" id="vpatc"
																name="vpatc" data-toogle="tooltip"
																placeholder="Enter VP ATC" readonly>
														</div>


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="potype"> Description :</label> <input
																type="text" class="form-control" tabindex="1"
																id="vpdescription" name="vpdescription"
																data-toogle="tooltip"
																placeholder="Enter VP Description " readonly>
														</div>


													</div>

													<br>



													<hr>
													<div class="row">
														<div class="col-12">
															<div class="col-md-1"></div>
															<div class="col-md-6">
																<span id="Label1"
																	style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">
																	Tracking Details</span>
															</div>
														</div>
													</div>


													<div class="row">
														<div class="col-12">
															<div class="col-md-1"></div>
															<div class="col-md-11">
																<div class="card-body" id="MSG1234"></div>
															</div>
														</div>
													</div>
													<br>
													<div class="row">
														<div class="col-md-12 text-center">
															<input type="reset" tabindex="4"
																class="btn btn-primary m-t-10" id="reload-btn"
																name="reload-btn" value="Back">
														</div>
													</div>
													<br>

												</div>






												<br>



												<!-- 									</div> -->

												<br>



												<hr>

												<br> <br>


												<!-- 								</div> -->
											</div>
										</div>

									</div>
								</div>

							</div>


							<div class="col-md-2"></div>
						</div>

						<!--</form>-->



					</div>

				</div>
				<!-- /.modal-content -->



				<div class="row">

					<div class="modal fade bs-example-modal-lg modal-default1111"
						id="Modelcategory" tabindex="-1" role="dialog"
						aria-labelledby="myLargeModalLabel" aria-hidden="true">

						<div class="modal-dialog">
							<div class="modal-content" style="width: 180%;">
								<div class="modal-header bg-secondary">
									<h4 class="modal-title" id="myLargeModalLabel">Tracking
										Details</h4>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close" style="margin-right: 10px">
										<span aria-hidden="true">&times;</span>
									</button>



								</div>
								<div class="modal-body">
									<!--<form action="">-->
									<div id="searchResult_po1" style="display: none">
										<div class="row">

											<!-- 						<div class="col-md-1"></div> -->
											<div class="col-md-12">

												<!-- 							<div class="card card-secondary"> -->
												<!--  								<div class="card-header"> -->

												<!-- 									<div class="row"> -->
												<!-- 										<div class="col-md-4">Tracking Details</div> -->

												<!-- 										<div class="col-md-7"></div> -->

												<!-- 										<div class="col-md-1"> -->
												<!-- 											<a -->
												<%-- 												href="<%=request.getContextPath()%>/User/UserTrackingTicket"> --%>
												<!-- 												<i class="fa fa-backward pull-right" style="color: white"> -->
												<!-- 											</i> -->
												<!-- 											</a> -->
												<!-- 										</div> -->


												<!-- 									</div> -->
												<!-- 								</div> -->
												<div class="card-body">

													<div class="row">
														<div class="col-md-12 text-center">
															<h2>
																Tracking Details Of <span id="T_ID1"></span>
															</h2>
														</div>
													</div>


													<br>
													<div class="row">
														<div class="col-12">
															<div class="col-md-1"></div>
															<div class="col-md-6">
																<span id="Label1"
																	style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">
																	Details :</span>
															</div>
														</div>
													</div>

													<div class="row">
														<div style="margin-top: 15px;" class="col-md-4">
															<label for="pootype">PO Type :</label> <input type="text"
																class="form-control" tabindex="1" id="potype"
																name="potype" data-toogle="tooltip"
																placeholder="Enter PO Type" readonly>
														</div>

														<div style="margin-top: 15px;" class="col-md-4">
															<label for="pooNo">PO Number :</label> <input type="text"
																class="form-control" tabindex="1" id="poNo" name="poNo"
																data-toogle="tooltip" placeholder="Enter PO Number"
																readonly>
														</div>


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="poodate">PO Date :</label> <input type="text"
																class="form-control" tabindex="1" id="podate"
																name="podate" data-toogle="tooltip"
																placeholder="Enter PO Date" readonly>
														</div>

													</div>




													<div class="row">


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="pocustomername">Customer Name:</label> <input
																type="text" class="form-control" tabindex="1"
																id="pocustomername" name="pocustomername"
																data-toogle="tooltip" placeholder="Enter Customer Name "
																readonly>
														</div>

														<div style="margin-top: 15px;" class="col-md-4">
															<label for="poproductsuite">Product Suite :</label>
															<!-- 										<input type="text" class="form-control" tabindex="1" id="productsuite" name="productsuite" data-toogle="tooltip" placeholder="Enter Product Suite" readonly> -->
															<textarea class="form-control" tabindex="1"
																id="productsuite" name="productsuite"
																data-toogle="tooltip"
																placeholder="Enter Security Tools " readonly></textarea>
														</div>




														<div style="margin-top: 15px;" class="col-md-4">
															<label for="posecuritytools">Security Tools :</label>
															<textarea class="form-control" tabindex="1"
																id="posecuritytools" name="posecuritytools"
																data-toogle="tooltip"
																placeholder="Enter Security Tools " readonly></textarea>

														</div>


													</div>

													<br>
													<div class="row" style="display: none;"
														id="poWarrantyHeaderDiv">
														<div class="col-12">
															<div class="col-md-1"></div>
															<div class="col-md-6">
																<span id="Label1"
																	style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">
																	Warranty Details :</span>
															</div>
														</div>
													</div>


													<div class="row" style="display: none;"
														id="poWarrantyDetailsDiv">


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="powarrantystart">Warranty Start Date
																:</label> <input type="text" class="form-control" tabindex="1"
																id="powarrantystart" name="powarrantystart"
																data-toogle="tooltip"
																placeholder="Enter Warranty Start Date " readonly>
														</div>

														<div style="margin-top: 15px;" class="col-md-4">
															<label for="powarrantyend">Warranty End Date :</label> <input
																type="text" class="form-control" tabindex="1"
																id="powarrantyend" name="powarrantyend"
																data-toogle="tooltip"
																placeholder="Enter Warranty End Date" readonly>
														</div>


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="powarrantyremaining">Warranty
																Remaining Days :</label> <input type="text" class="form-control"
																tabindex="1" id="powarrantyremaining"
																name="powarrantyremaining" data-toogle="tooltip"
																placeholder="Enter Warranty Remaining Days " readonly>
														</div>
													</div>
													
													
													<div class="row" id="poWarrantyDetailsDiv2" style="display: none;">

														<div class="col-md-4" style="margin-top: 15px;">
															<label for="powarrantystart2" class="text-success">Update Warranty Start Date
																:</label>
															<div class="input-group">
																<div class="input-group-prepend">
																	<span class="input-group-text"> <i
																		class="far fa-calendar-alt"></i>
																	</span>
																</div>
																<input type="text" readonly
																	class="form-control pull-right" autocomplete="off"
																	name="powarrantystart2" id="powarrantystart2"
																	placeholder="Please Update Date" onchange="WarrentyremainedDays()">
															</div>
														</div>

														<div class="col-md-4" style="margin-top: 15px;">
															<label for="powarrantyend2" class="text-success">Update Warranty End Date
																:</label>
															<div class="input-group">
																<div class="input-group-prepend">
																	<span class="input-group-text"> <i
																		class="far fa-calendar-alt"></i>
																	</span>
																</div>
																<input type="text" readonly
																	class="form-control pull-right" autocomplete="off"
																	name="powarrantyend2" id="powarrantyend2"
																	placeholder="Please Update Date" onchange="WarrentyremainedDays()">
															</div>
														</div>


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="powarrantyremaining2">Warranty
																Remaining Days :</label> <input type="text" class="form-control"
																tabindex="1" id="powarrantyremaining2"
																name="powarrantyremaining2" data-toogle="tooltip"
																placeholder="Warranty Remaining Days " readonly>
														</div>


													</div>
													
													

													<br>
													<div class="row" style="display: none;" id="poAMCHeaderDiv">
														<div class="col-12">
															<div class="col-md-1"></div>
															<div class="col-md-6">
																<span id="Label1"
																	style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">
																	AMC Details :</span>
															</div>
														</div>
													</div>


													<div class="row" style="display: none;"
														id="poAMCDetailsDiv">


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="poamcstart">AMC Start Date :</label> <input
																type="text" class="form-control" tabindex="1"
																id="poamcstart" name="poamcstart" data-toogle="tooltip"
																placeholder="Enter AMC Start Date " readonly>
														</div>

														<div style="margin-top: 15px;" class="col-md-4">
															<label for="poamcend">AMC End Date :</label> <input
																type="text" class="form-control" tabindex="1"
																id="poamcend" name="poamcend" data-toogle="tooltip"
																placeholder="Enter AMC End Date" readonly>
														</div>


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="poamcremaining">AMC Remaining Days :</label>
															<input type="text" class="form-control" tabindex="1"
																id="poamcremaining" name="poamcremaining"
																data-toogle="tooltip"
																placeholder="Enter AMC Remaining Days " readonly>
														</div>

													</div>
													
													
													<div class="row" style="display: none;"
														id="poAMCDetailsDiv2">

														<div class="col-md-4" style="margin-top: 15px;">
															<label for="poamcstart2" class="text-success">Update AMC Start Date :</label>
															<div class="input-group">
																<div class="input-group-prepend">
																	<span class="input-group-text"> <i
																		class="far fa-calendar-alt"></i>
																	</span>
																</div>
																<input type="text" readonly
																	class="form-control pull-right" autocomplete="off"
																	name="poamcstart2" id="poamcstart2"
																	placeholder="Please Update Date"
																	onchange="AMCremainedDays()">
															</div>
														</div>

														<div class="col-md-4" style="margin-top: 15px;">
															<label for="poamcend2" class="text-success">Update AMC End Date :</label>
															<div class="input-group">
																<div class="input-group-prepend">
																	<span class="input-group-text"> <i
																		class="far fa-calendar-alt"></i>
																	</span>
																</div>
																<input type="text" readonly
																	class="form-control pull-right" autocomplete="off"
																	name="poamcend2" id="poamcend2"
																	placeholder="Please Update Date"
																	onchange="AMCremainedDays()">
															</div>
														</div>

														<div style="margin-top: 15px;" class="col-md-4">
															<label for="poamcremaining2">AMC Remaining Days :</label>
															<input type="text" class="form-control" tabindex="1"
																id="poamcremaining2" name="poamcremaining2"
																data-toogle="tooltip"
																placeholder="AMC Remaining Days " readonly>
														</div>


														<div class="row" style="margin: 20px;">

															<div class="col-md-12">
<!-- 																<center> -->

																	<button type="button" tabindex="8"
																		class="btn btn-primary m-t-10" id="update-btn"
																		name="updatePO-btn" style="margin-left:340px;">
																		Update&nbsp;<span class="spinner-border"
																			style="width: 1rem; height: 1rem; display: none;"
																			id="spin11"> <i
																			class="fa fa-refresh fa-spin fa-10x"></i>
																		</span>
																	</button>
<!-- 																</center> -->
															</div>


														</div>

													</div>



														<br>
													<div class="row" style="display: none;"
														id="poTennureHeaderDiv">
														<div class="col-12">
															<div class="col-md-1"></div>
															<div class="col-md-6">
																<span id="Label1"
																	style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">
																	Tenure Details :</span>
															</div>
														</div>
													</div>


													<div class="row" style="display: none;"
														id="poTennureDetailsDiv">


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="potennurestart">Tenure Start Date :</label>
															<input type="text" class="form-control" tabindex="1"
																id="potennurestart" name="potennurestart"
																data-toogle="tooltip"
																placeholder="Enter Tennure Start Date " readonly>
														</div>

														<div style="margin-top: 15px;" class="col-md-4">
															<label for="potennureend">Tenure End Date :</label> <input
																type="text" class="form-control" tabindex="1"
																id="potennureend" name="potennureend"
																data-toogle="tooltip"
																placeholder="Enter Tennure End Date" readonly>
														</div>


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="potennureremaining">Tenure Remaining
																Days :</label> <input type="text" class="form-control"
																tabindex="1" id="potennureremaining"
																name="potennureremaining" data-toogle="tooltip"
																placeholder="Enter Tennure Remaining Days " readonly>
														</div>
													</div>
													
													
													
													<div class="row" style="display: none;"
														id="poTennureDetailsDiv2">


<!-- 														<div style="margin-top: 15px;" class="col-md-4"> -->
<!-- 															<label for="potennurestart2" class="text-success">Update Tenure Start Date :</label> -->
<!-- 															<input type="text" class="form-control" tabindex="1" -->
<!-- 																id="potennurestart2" name="potennurestart2" -->
<!-- 																data-toogle="tooltip" -->
<!-- 																placeholder="Update Tennure Start Date " readonly> -->
<!-- 														</div> -->
														
														
														<div class="col-md-4" style="margin-top: 15px;">
															<label for="potennurestart2" class="text-success">Update Tenure Start Date :</label>
															<div class="input-group">
																<div class="input-group-prepend">
																	<span class="input-group-text"> <i
																		class="far fa-calendar-alt"></i>
																	</span>
																</div>
																<input type="text" readonly
																	class="form-control pull-right" autocomplete="off"
																	name="potennurestart2" id="potennurestart2"
																	placeholder="Please Update Date"
																	onchange="TenureRemainedDays()">
															</div>
														</div>
														
														

<!-- 														<div style="margin-top: 15px;" class="col-md-4"> -->
<!-- 															<label for="potennureend2" class="text-success">Update Tenure End Date :</label> <input -->
<!-- 																type="text" class="form-control" tabindex="1" -->
<!-- 																id="potennureend2" name="potennureend2" -->
<!-- 																data-toogle="tooltip" -->
<!-- 																placeholder="Update Tennure End Date" readonly> -->
<!-- 														</div> -->
														
														
														<div class="col-md-4" style="margin-top: 15px;">
															<label for="potennureend2" class="text-success">Update Tenure End Date :</label>
															<div class="input-group">
																<div class="input-group-prepend">
																	<span class="input-group-text"> <i
																		class="far fa-calendar-alt"></i>
																	</span>
																</div>
																<input type="text" readonly
																	class="form-control pull-right" autocomplete="off"
																	name="potennureend2" id="potennureend2"
																	placeholder="Please Update Date"
																	onchange="TenureRemainedDays()">
															</div>
														</div>


														<div style="margin-top: 15px;" class="col-md-4">
															<label for="potennureremaining2">Tenure Remaining
																Days :</label> <input type="text" class="form-control"
																tabindex="1" id="potennureremaining2"
																name="potennureremaining2" data-toogle="tooltip"
																placeholder="Enter Tennure Remaining Days " readonly>
														</div>
														
														
														
														<div class="row" style="margin: 20px;">

															<div class="col-md-12">
<!-- 																<center> -->

																	<button type="button" tabindex="8"
																		class="btn btn-primary m-t-10" id="updateTenure-btn"
																		name="updatePO-btn" style="margin-left:340px;">
																		Update&nbsp;<span class="spinner-border"
																			style="width: 1rem; height: 1rem; display: none;"
																			id="spin11"> <i
																			class="fa fa-refresh fa-spin fa-10x"></i>
																		</span>
																	</button>
<!-- 																</center> -->
															</div>


														</div>				
														
													</div>


														<div class="row"  id="poAMCHeaderDiv">
														<div class="col-12">
															<div class="col-md-1"></div>
															<div class="col-md-6">
																<span id="Label1"
																	style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">
																	AMC History :</span>
															</div>
														</div>
													</div>
													
													<div class="col-md-12" id="inputContainer"></div>


													<br>


													<hr>
													<div class="row">
														<div class="col-12">
															<div class="col-md-1"></div>
															<div class="col-md-6">
																<span id="Label1"
																	style="color: crimson; font-family: Calibri; font-size: large; font-weight: bold">
																	Tracking Details</span>
															</div>
														</div>
													</div>


													<div class="row">
														<div class="col-12">
															<div class="col-md-1"></div>
															<div class="col-md-11">
																<div class="card-body" id="POMSG1234"></div>
															</div>
														</div>
													</div>
													<br>
													<div class="row">
														<div class="col-md-12 text-center">
															<input type="reset" tabindex="4"
																class="btn btn-primary m-t-10" id="reload-btn1" data-dismiss="modal"
																name="reload-btn" value="Back">
														</div>
													</div>
													<br>

												</div>
												<!-- 							</div> -->
											</div>
											<!-- 						<div class="col-md-1"></div> -->
										</div>
									</div>

								</div>


								<div class="col-md-2"></div>
							</div>

							<!--</form>-->



						</div>

					</div>
					<!-- /.modal-content -->
				</div>

				<!--                         Div ends for Velox PROPOSAL -->


				<!-- 		// Div ends for Purchase Order -->


				<!--                         Div ends for Purchase Order -->
			</section>
		</div>


		<!-- /.modal-dialog -->
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

	<!-- Select 2 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>

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
		src="<%=request.getContextPath()%>/static/adminlte/bower_components/moment/moment.js"></script>


	<script
		src="<%=request.getContextPath()%>/static/custom/usertickettracking.js"></script>

	<script type="text/javascript">
		$('#fromDate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});

		$('#toDate').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});
		
		$('#powarrantystart2').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});
		
		$('#powarrantyend2').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});  
		
		$('#poamcstart2').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});
		
		$('#poamcend2').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});  potennurestart2
		
		$('#potennurestart2').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});
		
		$('#potennureend2').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});
		
	</script>

</body>

</html>


