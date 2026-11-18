<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Revise Commercial Proposal</title>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
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

   #custom-tabs-one-messages-tab {
            display: none;
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
							<div class="col-md-4">Revise Commercial Proposal</div>

							<div class="col-md-7"></div>

							<div class="col-md-1">
								<a
									href="<%=request.getContextPath()%>/User/SendReviseCommercialProposal">
									<i class="fa fa-backward pull-right" style="color: white">
								</i>
								</a>
							</div>


						</div>

					</div>

					<div class="card-body">
















						<div class="row">

							<div class="col-md-6">
								<label for="">Proposal Type :</label> <select id="Proposaltype"
									class="form-control" data-toogle="tooltip" name="Proposaltype"
									onchange="proposaltypedata()">
									<option value="">---Please Select---</option>
								</select>


							</div>
							<div class="col-md-6" style="display: none;" id="perpetualhideid">
								<label for="">Perpetual Year :</label> <select
									id="Perpetualyear" class="form-control" data-toogle="tooltip"
									name="Perpetualyear" onchange="proposalbaseddatashowedperp()">
									<option value="">---Please Select---</option>
									<option value="1 year Warranty">1 year Warranty</option>
									<option value="3 year Warranty">3 year Warranty</option>
									<option value="5 year Warranty">5 year Warranty</option>
								</select>

							</div>

							<div class="col-md-6" style="display: none;"
								id="subscriptionhideid">
								<label for="">Subscription Year:</label> <select
									id="Subscriptionyear" class="form-control"
									data-toogle="tooltip" name="Subscriptionyear"
									onchange="proposalbaseddatashowedsubs()">
									<option value="">---Please Select---</option>
									<option value="Annual Price">Annual Price</option>
									<option value="3 year Subscription">3 year
										Subscription</option>
									<option value="5 year Subscription">5 year
										Subscription</option>

								</select>
							</div>

							<div class="col-md-6" style="display: none;" id="fixedhideid">
								<label for="">Fixed Year :</label> <select id="fixedyear"
									class="form-control" data-toogle="tooltip" name="fixedyear"
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
						
						
						<!-- //29/06 -->
						<div class=row>
									
									<div class="col-md-6">
										<label for="">Proposal For:</label> <select
											id="proposalFor" class="form-control"
											data-toogle="tooltip" name="proposalFor"
											onchange="proposalFor()">
											<option value="Please Select">---Please Select---</option>
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

						<div class="row">

							<div class="col-md-6">
								<label for="">Product Suit:</label> <select
									id="productsuitselect" class="form-control"
									data-toogle="tooltip" name="productsuitselect"
									onchange="productsuit()">
									<option value="">---Please Select---</option>
									<option value="ScanPlus">ScanPlus</option>
									<option value="SecureIT">SecureIT</option>
								</select>


							</div>

							<div class="col-md-6" id="hideScanplus">
								<label for="">Version </label> <input type="text"
									data-toogle="tooltip" class="form-control"
									id="Scanplusprodversion" value="Ver. 18.0.11.12"
									name="Scanplusprodversion" readonly>
							</div>

							<div class="col-md-6" style="display: none;" id="hideSecureIT">
								<label for="">Version </label> <input type="text"
									data-toogle="tooltip" class="form-control"
									id="SecureITprodversion" value="Ver. 19.11.01"
									name="SecureITprodversion" readonly>
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
									id="poinitiator" class="form-control" data-toogle="tooltip"
									name="poinitiator" placeholder="Enter Maker Name" readonly>
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
									id="FirstApprovername" class="form-control"
									data-toogle="tooltip" name="FirstApprovername"
									onchange="getCheckerNo()">
									<option value="">--Please Select Checker Name--</option>
								</select>


							</div>

							<div class="col-md-6">
								<label for="approvercontact">Checker Approver Contact No
									:</label> <input type="text" id="firstapprovercontact"
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
									="5" class="form-control form-control-sm"
									name="secondApprovername" data-toogle="tooltip"
									placeholder="Enter  Authorizer  Name" value="Dr. Mangesh Amale"
									readonly="readonly">
							</div>

							<div class="col-md-6">
								<label for="authorizercontact"> Authorizer Contact No</label> <input
									type="number" id="secondapprovercontact"
									class="form-control form-control-sm"
									name="secondapprovercontact" data-toogle="tooltip"
									oninput="this.value = this.value.slice(0, 10);"
									value="9867140100" readonly="readonly">
							</div>
							<div class="col-md-1"></div>
						</div>
						<br>
						<div class="row">

							<div class="col-md-6">
								<label for="clientname">Customer Name:</label>
								
<!-- 								<input type="text" id="clientname" class="form-control" -->
<!-- 									data-toogle="tooltip" name="clientname" -->
<!-- 									placeholder="Enter Customer Name" readonly> -->
									
										<select id="clientname"  class="form-control"
											data-toogle="tooltip" name="clientname">
											<option value="">--Please Select Customer Name--</option>
										</select>


							</div>

							<div class="col-md-6">
								<label for="authorizercontact"> End Customer
									Name(Optional)</label> <input type="text" id="enccustomername"
									class="form-control form-control-sm" name="enccustomername"
									data-toogle="tooltip" placeholder="Enter End Customer Name">
							</div>
							
						</div>

						<br>
						<div class="row">

							<div class="col-md-6">
								<label for="priority1">Remark (Optional) :</label>


								<textarea class="form-control form-control-sm"
									name="Description" rows="1" cols="50" id="Description"
									placeholder="Add Description Here" data-original-title=""
									title=""></textarea>


							</div>


							<div class="col-md-6">
								<label for="authorizercontact">Contact Person (Optional)</label>
								<input type="text" id="contactperson" class="form-control form-control-sm"
									name="contactperson" data-toogle="tooltip"
									placeholder="Enter End Contact Person Name">
							</div>

							<div class="col-md-6" style="display: none;margin-top: 15px; " id="atchideidupper">

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

						<div style="margin-top: 15px; display: none;" class="col-md-6"
							id="poUploadDiv">
							<label style="margin-left: 2px">Velox Proposal
								Attachment:<br> <span class="col-md-6"
								style="color: green; width: 450px" id="pouploadfile"></span>
							</label>
							<button class="button1 button4" id="downHidepofile"
								onclick="downFileStandard()">Download</button>
						</div>
						<input type="hidden" id="filenameStandard" name="filenameStandard">






						<br>
						<div class="row">
							<div class="col-md-12">


								<ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
									<li class="nav-item"><a class="nav-link active"
										id="custom-tabs-one-home-tab" data-toggle="pill"
										href="#custom-tabs-one-home" role="tab"
										aria-controls="custom-tabs-one-home" aria-selected="true">Product
											Details</a></li>

									                  <li class="nav-item">
									                    <a class="nav-link" id="custom-tabs-one-messages-tab" data-toggle="pill" href="#custom-tabs-one-messages" role="tab" aria-controls="custom-tabs-one-messages" aria-selected="false">Product Details Perpetual Table</a>
									                  </li>

								</ul>


								<div class="tab-content">
									<div class="tab-pane fade show active"
										id="custom-tabs-one-home" role="tabpanel"
										aria-labelledby="custom-tabs-one-home-tab">
										<br>
										<div class="row">
											<div class="col-md-1"></div>
											<div class="col-md-10">





												<!-- 	START		new jsp for AMC PROPOSAL -->


												<div class="row" style="display: none;"
													id="AMCSTARTENDHIDEID21">
													<div class="col-md-6" style="margin-top: 15px;">
														<label for="amcstartdate21">AMC Start Date:</label> <input
															type="text" readonly class="form-control pull-right"
															name="amcstartdate21" id="amcstartdate21"
															placeholder="Please Select  Date">

													</div>

													<div class="col-md-6" style="margin-top: 15px;">
														<label for="amcenddate21">AMC End Date:</label> <input
															type="text" readonly class="form-control pull-right"
															name="amcenddate21" id="amcenddate21"
															placeholder="Please Select  Date">


													</div>


													<div class="col-md-6" style="margin-top: 15px;">
														<label for="">Product Suit :</label> <input type="text"
															id="productsuitdetails21" class="form-control"
															tabindex="8" data-toogle="tooltip"
															name="productsuitdetails21" readonly>


													</div>

													<div class="col-md-6" style="margin-top: 15px;">
														<label for="securitysolutiondetails21">Security
															Tools :</label> <input type="text" id="securitysolutiondetails21"
															class="form-control" data-toogle="tooltip"
															name="securitysolutiondetails21" readonly>


													</div>


													<div class="col-md-6" style="margin-top: 15px;">
														<label for="descforamc21">Description :</label> <input
															type="text" id="descforamc21"
															class="form-control form-control-sm" name="descforamc21"
															data-toogle="tooltip"
															placeholder="Enter Description Here" readonly>
													</div>

													<div class="col-md-6" style="margin-top: 15px;">
														<label for="">Total Cost :</label> <input type="text"
															id="totalcostAMC21" class="form-control form-control-sm"
															name="totalcostAMC21" data-toogle="tooltip"
															placeholder="Enter Total Cost Here" readonly>
													</div>

													<div class="col-md-6" style="margin-top: 15px;">
														<label for="">18% GST of Total Cost :</label> <input
															type="text" id="gstforamc21"
															class="form-control form-control-sm" name="gstforamc21"
															data-toogle="tooltip"
															placeholder="Enter GST Percentage Here"
															readonly="readonly">
													</div>


													<div class="col-md-6" style="margin-top: 15px;">
														<label for="">Grand Total :</label> <input type="text"
															id="GRANDTOTALFORAMC21"
															class="form-control form-control-sm"
															name="GRANDTOTALFORAMC21" data-toogle="tooltip"
															placeholder="Enter Grand Total Here" readonly="readonly">
													</div>


												</div>



												<!-- 	end		new jsp for AMC PROPOSAL -->





												<table class="table table-striped table-bordered row-border"
													style="width: 100%" id="CMApprByMeTable">
													<thead>

														<tr class="table table-striped table-bordered">
															<th>Product Suite</th>
															<th>Product Tool</th>
															<th>Product Description</th>
															<th>Quantity</th>
															<th>Unit Rate</th>
															<th>Total Price</th>

														</tr>


													</thead>
													<tbody>
													</tbody>
												</table>



												<div class="row" id="hidealldetailforamc">

													<div style="margin-top: 15px;" class="col-md-6">




														<label for="approver33333">Sub Total (A) :</label> <input
															type="text" id="subtotalA"
															class="form-control form-control-sm" name="subtotalA"
															data-toogle="tooltip" readonly="readonly">


													</div>


													<div style="margin-top: 15px;" class="col-md-6">

														<label for="approver">Implementation & Deployment
															support :</label> <input type="text" id="deploysupport1"
															class="form-control form-control-sm"
															name="deploysupport1" data-toogle="tooltip"
															placeholder="Enter Implementation & Deployement support"
															oninput="this.value = this.value.replace(/[^0-9]/g, '');"
															readonly>

													</div>

													<div style="margin-top: 15px;" class="col-md-6">



														<label for="approvercontact">Cloud Deployment
															Charges(Optional) :</label> <input type="text"
															id="clouddeploycharges1"
															class="form-control form-control-sm"
															name="clouddeploycharges1" data-toogle="tooltip"
															placeholder="Enter Cloud Deployement Charges "
															oninput="this.value = this.value.replace(/[^0-9]/g, '');"
															readonly>



													</div>




													<div style="margin-top: 15px;" class="col-md-6">

														<label for="">Integration Charges:</label> <input
															type="text" id="integrationcharge21"
															class="form-control form-control-sm"
															name="integrationcharge21" data-toogle="tooltip"
															placeholder="Enter Integration Charges Here"
															oninput="this.value = this.value.replace(/[^0-9]/g, '');"
															readonly>



													</div>

													<div style="margin-top: 15px;" class="col-md-6">
														<label for="">Sub Total (B) :</label> <input type="text"
															id="subtotalB1" class="form-control form-control-sm"
															name="subtotalB1" data-toogle="tooltip"
															readonly="readonly">
													</div>

													<div style="margin-top: 15px;" class="col-md-6">
														<label for="">Sub Total C (A+B) :</label> <input
															type="text" id="totalc21"
															="5" class="form-control form-control-sm" name="totalc21"
															data-toogle="tooltip" readonly="readonly">
													</div>
													<div style="margin-top: 15px;" class="col-md-6">
														<label for="">GST @18% Of C :</label> <input type="text"
															id="total18percentage21"
															="5" class="form-control form-control-sm"
															name="total18percentage21" data-toogle="tooltip"
															readonly="readonly">
													</div>
													<div style="margin-top: 15px;" class="col-md-6">
														<label for="">Grand Total :</label> <input type="text"
															id="grandtotal21" class="form-control form-control-sm"
															name="grandtotal21" data-toogle="tooltip"
															readonly="readonly">
													</div>
													<div style="margin-top: 15px;" class="col-md-6">
														<label for="">Resources Amount :</label> <input
															type="text" id="resoucesamount12"
															class="form-control form-control-sm"
															name="resoucesamount12" data-toogle="tooltip"
															placeholder="Enter Resouces Amount"
															oninput="this.value = this.value.replace(/[^0-9]/g, '');"
															readonly>

													</div>



													<div style="margin-top: 15px;" class="col-md-6">
														<label for="ATCID21">ATC :</label> <input type="text"
															id="ATC21" class="form-control" data-toogle="tooltip"
															name="ATC21" readonly>

													</div>

												</div>



												<!--  START  add two field for RESOURCE        -->


												<div class="row" style="display: none;"
													id="subtotalahideidforResource21">
													<br>
													<div class="col-md-4">
														<label for="">Sub Total (A) Resource :</label> <input
															type="text" id="subtotalAResource21"
															class="form-control form-control-sm"
															name="subtotalAResource21" data-toogle="tooltip"
															readonly="readonly">
													</div>


													<div class="col-md-4">
														<label for="">18% GST of Sub Total (A) Resource :</label>
														<input type="text" id="gstdataforresource21"
															class="form-control form-control-sm"
															name="gstdataforresource21" data-toogle="tooltip"
															readonly="readonly">
													</div>

													<div class="col-md-4">
														<label for="">Grand Total Resource :</label> <input
															type="text" id="grandtotalforresource21"
															class="form-control form-control-sm"
															name="grandtotalforresource21" data-toogle="tooltip"
															readonly="readonly">
													</div>
												</div>

												<!--                                   END  add two field for RESOURCE           -->


												<br> <br>

<div class="card card-secondary">
							<div class="card-header">Update Product Details</div>
							<div class="card-body">

								<div id="eeeew">

									<!-- 				<div class="row"> -->
									<!-- 					 <div class="col-md-12" >	 -->
									<!-- 						<button type="button" onclick="addRow()"  -->
									<!-- 							class="btn btn-sm btn-primary " id="addRowButton" -->
									<!-- 							 style="margin-left: 16px;">Add Row</button> -->


									<!-- 					</div>									 -->
									<!--                  </div>			 -->
									<!--                  <br> -->


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
													class="form-control pull-right" autocomplete="off"
													name="amcstartdate" id="amcstartdate"
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

									<div class="row" style="display: none;"
										id="productsuitandtoolhideid">

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
														<!-- 												<th>Action</th> -->
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

														<td><select id="productnameaddrow"
															class="form-control" data-toogle="tooltip"
															name="productnameaddrow">
																<option value="">--Please Select Product Tool--</option>
														</select></td>
														<td><input type="text" id="Desciption"
															placeholder="Enter your Desciption" class="form-control"></td>
														<td><input type="text"
															placeholder="Enter Your Quantity" id="quantitydata"
															name="quantitydata" class="form-control"
															oninput="this.value = this.value.replace(/[^0-9]/g, '');">
														<td><input type="text"
															placeholder="Enter Your Unit Rate" id="unitratedata"
															name="unitratedata" class="form-control"
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
									<br> <br>

									<div class="row">
										<br>
										<div class="col-md-5" style="display: none;"
											id="subtotalahideid">
											<label for="approver33333">Sub Total (A) :</label> <input
												type="text" id="totalpriceforallproduct"
												class="form-control form-control-sm"
												name="totalpriceforallproduct" data-toogle="tooltip"
												readonly="readonly">
										</div>
									</div>



									<!--  START  add two field for RESOURCE        -->


									<div class="row" style="display: none;"
										id="subtotalahideidforResource">
										<br>
										<div class="col-md-4">
											<label for="">Sub Total (A) Resource :</label> <input
												type="text" id="subtotalAResource"
												class="form-control form-control-sm"
												name="subtotalAResource" data-toogle="tooltip"
												readonly="readonly">
										</div>


										<div class="col-md-4">
											<label for="">18% GST of Sub Total (A) Resource :</label> <input
												type="text" id="gstdataforresource"
												class="form-control form-control-sm"
												name="gstdataforresource" data-toogle="tooltip"
												readonly="readonly">
										</div>

										<div class="col-md-4">
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
												="5" class="form-control form-control-sm"
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
												="5" class="form-control form-control-sm"
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
												="5" class="form-control form-control-sm"
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
												="5" class="form-control form-control-sm" name="3yearfixed"
												data-toogle="tooltip" readonly="readonly">
										</div>
									</div>


									<div class="row" style="display: none;"
										id="subtotalahideid5yearfixed1">
										<br>
										<div class="col-md-5">
											<label for="">Sub Total 5 fixed Year (A) :</label> <input
												type="text" id="fiveyearfixed"
												="5" class="form-control form-control-sm" name="5yearfixed"
												data-toogle="tooltip" readonly="readonly">
										</div>
									</div>

									<br>
									<!-- 									<hr> -->
									<br>


									<div class="row" id="chargesforAllPropType">

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="approver">Implementation & Deployment
												support :</label> <input type="text" id="deploysupport"
												class="form-control form-control-sm" name="deploysupport"
												data-toogle="tooltip" onchange="validateapprover()"
												placeholder="Enter Implementation & Deployement support"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="approvercontact">Cloud Deployment
												Charges(Optional) :</label> <input type="text"
												id="clouddeploycharges" class="form-control form-control-sm"
												name="clouddeploycharges" data-toogle="tooltip"
												onchange="validatecloud()"
												placeholder="Enter Cloud Deployement Charges "
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">


										</div>






										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Integration Charges :</label> <select
												id="IntegrationCharges" class="form-control"
												data-toogle="tooltip" name="IntegrationCharges"
												onchange="integrationcharge()">
												<option value="">---Please Select Integration
													Charges---</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>

											</select>
										</div>

										<div class="col-md-6" style="display: none; margin-top: 15px;"
											id="integrationhideid">
											<label for="">Integration Charges:</label> <input type="text"
												id="integrationcharge" class="form-control form-control-sm"
												name="integrationcharge" data-toogle="tooltip"
												placeholder="Enter Integration Charges Here"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>



										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Sub Total (B) :</label> <input type="text"
												id="subtotalB" ="5" class="form-control form-control-sm"
												name="subtotalB" data-toogle="tooltip" readonly="readonly">
										</div>


										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Sub Total C (A+B) :</label> <input type="text"
												id="totalc" class="form-control form-control-sm"
												name="totalc" data-toogle="tooltip" readonly="readonly">
										</div>

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">GST @18% Of C :</label> <input type="text"
												id="total18percentage" class="form-control form-control-sm"
												name="total18percentage" data-toogle="tooltip"
												readonly="readonly">
										</div>

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Grand Total :</label> <input type="text"
												id="grandtotal" class="form-control form-control-sm"
												name="grandtotal" data-toogle="tooltip" readonly="readonly">
										</div>

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Resources Amount :</label> <input type="text"
												id="resoucesamount" class="form-control form-control-sm"
												name="resoucesamount" data-toogle="tooltip"
												placeholder="Enter Resouces Amount"
												onchange="resoucesamount()"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>

									</div>
									<br>



								</div>

							</div>
						</div>


											</div>
											<div class="col-md-1"></div>

										</div>
										<br>


									</div>


     <div class="tab-pane fade" id="custom-tabs-one-messages" role="tabpanel" aria-labelledby="custom-tabs-one-messages-tab">
           
           
           <div class="row">
                                                    
                                                    <div class="col-md-1" ></div>
                                     <div class="col-md-10">
                                     
                                     
                                     							                                              
	<!--  START  Combination OF Subscription and Perpetual         -->
	
	
	
	
	 <div class="row" style="display: none;" id="combinationSubsANDPerpHideDIv">
	 
	 
	 
	 
	 <br>
	 <br>
	 <div class="col-md-12 text-center" style="margin-left: 16px; font-size: 15px; color: red;">
								<strong>Perpetual Table</strong>
							
									
									</div>
	 
	 <div class="col-md-12">
	 	<table class="table table-striped table-bordered row-border" style="width:100%;" id="SubsANDPerpTable31">
										<thead>

											<tr class="table table-striped table-bordered"  >
												<th>Product Suites</th>
												<th>Product Names</th>
												<th>Product Description</th>
												<th>Quantity</th>
												<th>Unit Rate</th>
												<th>Total Price</th>
												
											</tr>
											
											
										</thead>
										<tbody>
    
                                      </tbody>
                                 </table>
                                 </div>
                                 <br><br>
	 
	    <div style="margin-top:15px;" class="col-md-6" id="perpetualSubsAnnualPerpHideDiv31">
                                       	<label for="perpetualSubsAnnualperpType31">Sub Total Annual Year (A) :</label> <input type="text"
											id="perpetualSubsAnnualperpType31"  class="form-control form-control-sm"
											name="perpetualSubsAnnualperpType31" data-toogle="tooltip" 
											placeholder="Enter Sub Total Annual Year" readonly>

                                    </div>
                                	<div style="margin-top: 15px;" class="col-md-6" id="perpetualSubs3yearPerpHideDiv31">
										<label for="perpetualSubs3yearperpType31">Sub Total 3 Pepetual Year (A) :</label> <input type="text"
											id="perpetualSubs3yearperpType31" class="form-control form-control-sm"
											name="perpetualSubs3yearperpType31" data-toogle="tooltip"
											placeholder="Enter Sub Total 3 Pepetual Year"  readonly="readonly">
									</div>
									
									
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="deploysupport31">Implementation & Deployment support :</label> <input type="text"
											id="deploysupport31" class="form-control form-control-sm"
											name="deploysupport31" data-toogle="tooltip"
											placeholder="Enter Implementation & Deployment support"  readonly="readonly">
									</div>
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="clouddeploycharges31">Cloud Deployment Charges :</label> <input type="text"
											id="clouddeploycharges31" class="form-control form-control-sm"
											name="clouddeploycharges31" data-toogle="tooltip"
											placeholder="Enter Cloud Deployment Charges"  readonly="readonly">
									</div>
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="IntegrationCharges31">Integration Charges :</label> <input type="text"
											id="IntegrationCharges31" class="form-control form-control-sm"
											name="IntegrationCharges31" data-toogle="tooltip"
											placeholder="Enter Integration Charges"  readonly="readonly">
									</div>
									
									
											<div style="margin-top: 15px;" class="col-md-6" >
										<label for="subtotalB31">Sub Total (B) :</label> <input type="text"
											id="subtotalB31" class="form-control form-control-sm"
											name="subtotalB31" data-toogle="tooltip"
											placeholder="Enter Sub Total (B)"  readonly="readonly">
									</div>
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="totalc31">Sub Total C (A+B) :</label> <input type="text"
											id="totalc31" class="form-control form-control-sm"
											name="totalc31" data-toogle="tooltip"
											placeholder="Enter Sub Total C (A+B)"  readonly="readonly">
									</div>
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="total18percentage31">GST @18% Of C :</label> <input type="text"
											id="total18percentage31" class="form-control form-control-sm"
											name="total18percentage31" data-toogle="tooltip"
											placeholder="Enter GST @18% Of C"  readonly="readonly">
									</div>
									
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="grandtotal31">Grand Total :</label> <input type="text"
											id="grandtotal31" class="form-control form-control-sm"
											name="grandtotal31" data-toogle="tooltip"
											placeholder="Enter Grand Total"  readonly="readonly">
									</div>
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="resoucesamount31">Resources Amount :</label> <input type="text"
											id="resoucesamount31" class="form-control form-control-sm"
											name="resoucesamount31" data-toogle="tooltip"
											placeholder="Enter Resources Amount"  readonly="readonly">
									</div>
	 
	 </div>
	
              <!--  END  Combination OF Subscription and Perpetual         -->           
                                  
									
								<br>	<br>	
									<div class="card card-secondary">
							<div class="card-header">Update Product Details</div>
							<div class="card-body">

								<div id="eeeew41">
								
								
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
											<label for="deploysupport41">Implementation & Deployment
												support :</label> <input type="text" id="deploysupport41"
												class="form-control form-control-sm"
												name="deploysupport41" data-toogle="tooltip"
												onchange="validateapprover()"
												placeholder="Enter Implementation & Deployement support"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>

										<div class="col-md-6" style="margin-top: 15px;" >
											<label for="clouddeploycharges41">Cloud Deployment
												Charges(Optional) :</label> <input type="text"
												id="clouddeploycharges41"
										 class="form-control form-control-sm"
												name="clouddeploycharges41" data-toogle="tooltip"
												onchange="validatecloud()"
												placeholder="Enter Cloud Deployement Charges "
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">


										</div>
								
									

                                    	<div class="col-md-6" style="margin-top: 15px;" >
											<label for="">Integration Charges :</label> 
											
											<select id="IntegrationCharges41"  class="form-control"
												data-toogle="tooltip" name="IntegrationCharges41"
												onchange="integrationcharge()">
										         <option value="">---Please Select Integration Charges---</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
                                          </select>
										</div>

										<div class="col-md-6" style="display: none; margin-top: 15px;" id="integrationhideid21"
											>
											<label for="">Integration Charges:</label> <input type="text"
												id="integrationcharge41"
												 class="form-control form-control-sm"
												name="integrationcharge41" data-toogle="tooltip"
												placeholder="Enter Integration Charges Here"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>
								
								


							

										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="subtotalB41">Sub Total (B) :</label> <input type="text"
												id="subtotalB41"  class="form-control form-control-sm"
												name="subtotalB41" data-toogle="tooltip" readonly="readonly">
										</div>


										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="totalc41">Sub Total C (A+B) :</label> <input type="text"
												id="totalc41"  class="form-control form-control-sm"
												name="totalc41" data-toogle="tooltip" readonly="readonly">
										</div>
									
									

										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="total18percentage41">GST @18% Of C :</label> <input type="text"
												id="total18percentage41"
												 class="form-control form-control-sm"
												name="total18percentage41" data-toogle="tooltip"
												readonly="readonly">
										</div>

										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="grandtotal41">Grand Total :</label> <input type="text"
												id="grandtotal41" class="form-control form-control-sm"
												name="grandtotal41" data-toogle="tooltip" readonly="readonly">
										</div>
								
									
										<div class="col-md-6"  style="margin-top: 15px;">
											<label for="resoucesamount41">Resources Amount :</label> <input type="text"
												id="resoucesamount41"
											 class="form-control form-control-sm"
												name="resoucesamount41" data-toogle="tooltip"
												placeholder="Enter Resouces Amount"
												onchange="resoucesamount()"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>


									</div>

								


<br>
								
								</div>
								</div>
							</div>
									
                                     
                                     
                                     
                                     
                                     
                                     </div>
                                      <div class="col-md-1" ></div>
                                      </div>
 </div>
 
 
								</div>
							</div>
							
			
							
							
							<br>


						</div>


						

						<br>
						<div class="row" id="rejreasonDiv" style="display: none;">

							<div class="col-md-10">
								<label for="techniq">Rejected/FeedBack Reason</label>
								<textarea id="rejreason" tabindex="1" class="form-control"
									name="rejreason" data-toogle="tooltip"
									placeholder="Enter Reason" readonly></textarea>

							</div>

						</div>

						<br>
						<div class="row" id="SMnoteDiv" style="display: none;">

							<div class="col-md-10">
								<label for="techniq">Note (SM)</label>
								<textarea id="SMnote" tabindex="1" class="form-control"
									name="SMnote" data-toogle="tooltip" placeholder="Enter Note"
									readonly></textarea>

							</div>

						</div>
						<br>

						<div class="row">

							<div class="col-md-10">
								<label for="techniq">Note (Optional)</label>
								<textarea id="SInote" tabindex="1" class="form-control"
									name="SInote" data-toogle="tooltip" placeholder="Enter Note"></textarea>

							</div>

						</div>

						<br>

						<div style="margin-top: 15px;" class="col-md-12">
							<center>
								<!--                                                                                            <input type="submit" tabindex="8" class="btn btn-primary m-t-10" id="submit-btnnn"  name="submit" value="Submit"  onclick="submitData()"> <span class="spinner" style=" display: none"><i class="fa fa-refresh fa-spin fa-10x"></i></span> -->
								<button type="submit" tabindex="8"
									class="btn btn-primary m-t-10" id="submit-btnnn" name="submit"
									data-style="expand-left" onclick="submitData()">
									Submit &nbsp; <span class="spinner-border"
										style="width: 1rem; height: 1rem; display: none;" id="spin1"><i
										class="fa fa-refresh fa-spin fa-10x"></i></span>
								</button>
								<button type="button"
									
													class="btn btn-primary m-t-10"
									id="reset-btn" name="reset-btn" value="Reset">Reset</button>
								<!--                                             <button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="Reject" name="Reject" onclick="rejectFunction();">Reject &nbsp; &nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem;display: none;" id="spin2"><i class="fa fa-refresh fa-spin fa-10x"></i></span></button>   -->
							</center>
						</div>


					</div>




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
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>

<script src="<%=request.getContextPath()%>/static/custom/ReviseCommercialProposal.js"></script>



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