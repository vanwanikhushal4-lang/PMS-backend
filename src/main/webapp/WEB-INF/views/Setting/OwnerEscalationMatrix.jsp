<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!doctype html>

<html class="no-js" lang="en">


<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Owner Escalation Matrix</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- favicon
		============================================ -->
<link rel="shortcut icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/static/images/favicon.ico">
<!-- Google Fonts
		============================================ -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i,800"
	rel="stylesheet">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/bootstrap.min.css">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/font-awesome.min.css">
<!-- adminpro icon CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/adminpro-custon-icon.css">
<!-- meanmenu icon CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/meanmenu.min.css">
<!-- mCustomScrollbar CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/jquery.mCustomScrollbar.min.css">
<!-- animate CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/animate.css">
<!-- modals CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/modals.css">
<!-- normalize CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/normalize.css">
<!-- touchspin CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/touchspin/jquery.bootstrap-touchspin.min.css">
<!-- datapicker CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/datapicker/datepicker3.css">
<!-- forms CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/form/themesaller-forms.css">
<!-- colorpicker CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/colorpicker/colorpicker.css">
<!-- select2 CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/select2/select2.min.css">
<!-- chosen CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/chosen/bootstrap-chosen.css">
<!-- ionRangeSlider CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/ionRangeSlider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="css/ionRangeSlider/ion.rangeSlider.skinFlat.css">
<!-- style CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/style.css">
<!-- responsive CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/responsive.css">
<!-- modernizr JS
		============================================ -->
<script
	src="<%=request.getContextPath()%>/static/AdminPro/js/vendor/modernizr-2.8.3.min.js"></script>
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/multiselect/bootstrap-multiselect.css"
	type="text/css" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.css" />
<script
	src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css" />
<script
	src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>
</head>
<style>
.sparkline11-graph {
	padding-bottom: 0
}

.fixed-table-loading{
visibility: hidden;
}

.multiselect-container{
    width:100%;
     max-height:200px;
     overflow:auto;
 }
</style>



<body class="materialdesign">


	<!-- Left Panel -->
	<div class="wrapper-pro">
		<jsp:include page="/WEB-INF/views/adminsidebar.jsp" />

		<div class="content-inner-all">
<%-- 			<jsp:include page="/WEB-INF/views/dashboardheader.jsp" /> --%>
			<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

			<!-- Header-->



		<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">



					<div class="sparkline11-list shadow-reset mg-t-30">
						<div class="sparkline11-hd">
							<div class="main-sparkline11-hd">
								<h1>Owner Escalation Matrix</h1>

							</div>
						</div>


						<div class="sparkline11-graph">
							<div class="row">

								

								<div class="col col-md-4">
									<label>Customer Name</label><br>
									<div id="customer_div" style="width: 100%;">
										<select  id="customer" TABINDEX="2" class="form-control" multiple="multiple"
										onchange="getDevice(this.value)">
										
										<c:forTokens items="${customerdetails}" delims="^" var="cust" >
											<option value="${cust}">${cust}</option>
										</c:forTokens>
											
										</select>
									</div>
								</div>
								
								<div class="col col-md-4">
									<label>Device Type</label><br> <select id="device" onchange="getOwner()"
										class="form-control " style="width: 100%;">
										<option value="">--Select Device--</option>
										
									</select>
								</div>
								<div class="col col-md-4"></div>

							</div>
						</div>
						
						<div class="sparkline11-graph">
							<div class="row">
							<div class="col col-md-4">
							<label for="critical">Criticality :</label>
                                                <select id="critical" tabindex="3"  class="form-control" data-toogle="tooltip" name="critical">
                                                    <option value="">Please Select</option>
                                                    <option value="Critical">Critical</option>
                                                    <option value="Semi Critical">Semi Critical</option>
                                                </select>
							</div>
							<div class="col col-md-4">
							 <label for="sms">Send SMS :</label>
                                                <select id="sms"  tabindex="4" class="form-control" data-toogle="tooltip" name="sms">
                                                    <option value="">Please Select</option>
                                                    <option value="Yes">Yes</option>
                                                    <option value="No">No</option>
                                                </select>
							</div>
							<div class="col col-md-4">
							</div>
							</div>
							</div>

						<div class="sparkline11-graph">
							<div class="row">


								<div class="col col-md-4">
									<label>Device Owner Name</label><br> 
									<select class="form-control"
										style="width:100%" id="o_name" onchange="OwnerData()">
										 <option value="">Please Select</option>
										</select>
								</div>
								<div class="col col-md-4">
									<label>Escalator1 Name:</label><br> 
									<select  class="form-control"
										style="width:100%" id="e1_name" onchange="Es1Data()">
										 <option value="">Please Select</option>
										 </select>
								</div>
								<div class="col col-md-4">
									<label>Escalator2 Name:</label><br> 
									<select class="form-control" onchange="Es2Data()"
										style="width:100%" id="e2_name">
										 <option value="">Please Select</option>
										 </select>
								</div>
							</div>

						</div>
						
						<div class="sparkline11-graph">
							<div class="row">


								<div class="col col-md-4">
								<div id="o_email_div" style="display:none">
									<label>Email ID:</label><br> <input type="text" class="form-control"
									disabled="disabled"	style="width:100%" placeholder="Enter Email ID" id="o_email">
								</div>
								</div>
								<div class="col col-md-4">
									<div id="e1_email_div" style="display:none">
									<label>Email ID:</label><br> 
									<input type="text" class="form-control"
										disabled="disabled" style="width:100%" placeholder="Enter Email ID" id="e1_email">
								</div>
								</div>
								<div class="col col-md-4" >
								<div id="e2_email_div" style="display:none">
									<label>Email ID:</label><br> 
									<input type="text" class="form-control"
										disabled="disabled" style="width:100%" placeholder="Enter Email ID" id="e2_email">
								</div>
								</div>
							</div>

						</div>
						
						<div class="sparkline11-graph">
							<div class="row">


								<div class="col col-md-4" >
								<div id="o_phn_div" style="display:none">
									<label>Mobile No:</label><br> <input type="text" class="form-control"
									disabled="disabled"	style="width:100%" placeholder="Enter Mobile No" id="o_phn">
								</div>
								</div>
								<div class="col col-md-4" >
								<div id="e1_phn_div" style="display:none">
									<label>Mobile No:</label><br> 
									<input type="text" class="form-control"
								disabled="disabled"		style="width:100%" placeholder="Enter Mobile No" id="e1_phn">
								</div>
								</div>
								<div class="col col-md-4" >
								<div id="e2_phn_div" style="display:none">
									<label>Mobile No:</label><br> 
									<input type="text" class="form-control"
								disabled="disabled"		style="width:100%" placeholder="Enter Mobile No" id="e2_phn">
								</div>
								</div>
							</div>

						</div>

						<div class="sparkline11-graph">
							<div class="row">


								<div class="col col-md-4">
								<div id="o_time_div" style="display:none">
									<label>Time:</label><br> <input type="text" class="form-control"
										style="width:100%" placeholder="Enter Time" id="o_time">
								</div>
								</div>
								<div class="col col-md-4">
								<div id="e1_time_div" style="display:none">
									<label>Time:</label><br> 
									<input type="text" class="form-control"
										style="width:100%" placeholder="Enter Time" id="e1_time">
								</div>
								</div>
								<div class="col col-md-4">
								<div id="e2_time_div" style="display:none">
									<label>Time:</label><br> 
									<input type="text" class="form-control"
										style="width:100%" placeholder="Enter Time" id="e2_time">
								</div>
								</div>
							</div><br>
							
							<div class="row">
							<div class="col col-md-4">
							                           <div id="o_format_div" style="display: none">
                                                    <select id="o_format" class="form-control" data-toogle="tooltip" name="select2">
                                                        <option value="">--Select--</option>
                                                        <option value="Sec">Sec</option>
                                                        <option value="Min">Min</option>
                                                        <option value="hr">hr</option>

                                                    </select>
                                                </div>
							</div>
							<div class="col col-md-4">
							                           <div id="e1_format_div" style="display: none">
                                                    <select id="e1_format" class="form-control" data-toogle="tooltip" name="select2">
                                                        <option value="">--Select--</option>
                                                        <option value="Sec">Sec</option>
                                                        <option value="Min">Min</option>
                                                        <option value="hr">hr</option>

                                                    </select>
                                                </div>
							</div>
							
							<div class="col col-md-4">
							                           <div id="e2_format_div" style="display: none">
                                                    <select id="e2_format" class="form-control" data-toogle="tooltip" name="select2">
                                                        <option value="">--Select--</option>
                                                        <option value="Sec">Sec</option>
                                                        <option value="Min">Min</option>
                                                        <option value="hr">hr</option>

                                                    </select>
                                                </div>
							</div>
							</div>

						</div>
						
						<div class="sparkline11-graph">


							<div class="form-group-inner">
								<div class="login-btn-inner">
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-4" style="margin-left: 50px">
											<div class="login-horizental cancel-wp pull-left">

												<button id="submit-btn"
													class="btn btn-sm btn-primary login-submit-cs"
													type="submit">Submit</button>
												<button id="reset-btn" class="btn btn-white" type="submit">Reset</button>
											</div>
											<br> <br> <br> <br>

										</div>
										<div class="col-lg-4"></div>
									</div>
								</div>
							</div>
						</div>
					</div>



				</div>
				<div class="col-lg-2"></div>
			</div>

			
<div>
			<div class="modal fade" id="updateOwnerEscalation">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>

							<h4>Update Owner Escalation</h4>

						</div>

						<div class="modal-body">
							<div class="row">

								<div class="col-lg-12">
<!-- Jashan -->
									<div class="col col-md-4">
									<label>Customer Name</label><br>
									<div style="width: 100%;">
										<input type="text"  id="m_customer" class="form-control"
										style="width:100%" disabled="disabled">
										
									</div>
								</div>
								
								<div class="col col-md-4">
									<label>Device Type</label>
									<br> <input type="text" id="m_device" class="form-control"
										style="width:100%" disabled="disabled">
								</div>
								<div class="col col-md-4"></div>

							</div>
						</div>
						
						<div class="sparkline11-graph">
							<div class="row">
							<div class="col col-md-4">
							<label for="critical">Criticality :</label>
                                                <select id="m_critical" tabindex="3"  class="form-control" data-toogle="tooltip" name="critical">
                                                    <option value="">Please Select</option>
                                                    <option value="Critical">Critical</option>
                                                    <option value="Semi Critical">Semi Critical</option>
                                                </select>
							</div>
							<div class="col col-md-4">
							 <label for="sms">Send SMS :</label>
                                                <select id="m_sms"  tabindex="4" class="form-control" data-toogle="tooltip" name="sms">
                                                    <option value="">Please Select</option>
                                                    <option value="Yes">Yes</option>
                                                    <option value="No">No</option>
                                                </select>
							</div>
							<div class="col col-md-4">
							</div>
							</div>
							</div>

						<div class="sparkline11-graph">
							<div class="row">


								<div class="col col-md-4">
									<label>Owner Name</label><br> 
									<input type="text" id="m_o_name" class="form-control"
										style="width:100%" disabled="disabled">
								</div>
								<div class="col col-md-4">
									<label>Escalator1 Name:</label><br> 
									<input type="text" id="m_e1_name"class="form-control"
										style="width:100%" disabled="disabled">
										
								</div>
								<div class="col col-md-4">
									<label>Escalator2 Name:</label><br> 
									<input type="text" id="m_e2_name" class="form-control"
										style="width:100%" disabled="disabled">
										
										 </div>
								</div>
							</div>

						</div>
						
						<div class="sparkline11-graph">
							<div class="row">


								<div class="col col-md-4">
								<div>
									<label>Email ID:</label><br> <input type="text"  class="form-control"
										style="width:100%" disabled="disabled" id="m_o_email">
								</div>
								</div>
								<div class="col col-md-4">
									<div>
									<label>Email ID:</label><br> 
									<input type="text"  class="form-control"
										style="width:100%" disabled="disabled" id="m_e1_email">
								</div>
								</div>
								<div class="col col-md-4" >
								<div>
									<label>Email ID:</label><br> 
									<input type="text"  class="form-control"
										style="width:100%" disabled="disabled" id="m_e2_email">
								</div>
								</div>
							</div>

						</div>
						
						<div class="sparkline11-graph">
							<div class="row">


								<div class="col col-md-4" >
								<div>
									<label>Mobile No:</label><br> <input type="text"  class="form-control"
										style="width:100%" disabled="disabled" id="m_o_phn">
								</div>
								</div>
								<div class="col col-md-4" >
								<div>
									<label>Mobile No:</label><br> 
									<input type="text"  class="form-control"
										style="width:100%" disabled="disabled" id="m_e1_phn">
								</div>
								</div>
								<div class="col col-md-4" >
								<div>
									<label>Mobile No:</label><br> 
									<input type="text"  class="form-control"
										style="width:100%" disabled="disabled" id="m_e2_phn">
								</div>
								</div>
							</div>

						</div>

						<div class="sparkline11-graph">
							<div class="row">


								<div class="col col-md-4">
								<div>
									<label>Time:</label><br> <input type="text" class="form-control"
										style="width:100%" placeholder="Enter Time" id="m_o_time">
								</div>
								</div>
								<div class="col col-md-4">
								<div>
									<label>Time:</label><br> 
									<input type="text" class="form-control"
										style="width:100%" placeholder="Enter Time" id="m_e1_time">
								</div>
								</div>
								<div class="col col-md-4">
								<div>
									<label>Time:</label><br> 
									<input type="text" class="form-control"
										style="width:100%" placeholder="Enter Time" id="m_e2_time">
								</div>
								</div>
							</div><br>
							
							<div class="row">
							<div class="col col-md-4">
							                           <div >
                                                    <select id="m_o_format" class="form-control" data-toogle="tooltip" name="select2">
                                                        <option value="">--Select--</option>
                                                        <option value="Sec">Sec</option>
                                                        <option value="Min">Min</option>
                                                        <option value="hr">hr</option>

                                                    </select>
                                                </div>
							</div>
							<div class="col col-md-4">
							                           <div >
                                                    <select id="m_e1_format" class="form-control" data-toogle="tooltip" name="select2">
                                                        <option value="">--Select--</option>
                                                        <option value="Sec">Sec</option>
                                                        <option value="Min">Min</option>
                                                        <option value="hr">hr</option>

                                                    </select>
                                                </div>
							</div>
							
							<div class="col col-md-4">
							                           <div >
                                                    <select id="m_e2_format" class="form-control" data-toogle="tooltip" name="select2">
                                                        <option value="">--Select--</option>
                                                        <option value="Sec">Sec</option>
                                                        <option value="Min">Min</option>
                                                        <option value="hr">hr</option>

                                                    </select>
                                                </div>
							</div>
							</div>

						</div>
									
									
									<div class="sparkline11-graph">


										<div class="form-group-inner">
											<div class="login-btn-inner">
												<div class="row">
													<div class="col-lg-4"></div>
													<div class="col-lg-4" style="margin-left: 50px">
														<div class="login-horizental cancel-wp pull-left">

															<button id="m_submit"
																class="btn btn-sm btn-primary login-submit-cs"
																type="submit">Update</button>
															<button id="m_reset" class="btn btn-white" type="submit">Reset</button>
														</div>
														<br> <br> <br> <br>

													</div>
													<div class="col-lg-4"></div>
												</div>
											</div>
										</div>

									</div>


								</div>

							</div>
						</div>

					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>


			<div class="row" style="margin-left:14%">
				<input type="hidden" id=set_sr>


				<div class="col-md-12">
					<div
						class="sparkline13-graph datatable-dashv1-list custom-datatable-overright"
						style="width:95%;margin-left:3%;overflow-y:scroll">
						<div class="sparkline11-hd">
							<div class="main-sparkline11-hd">
								<center>
									<h1>Owner Escalation Details</h1>
								</center>

							</div>
						</div>

						<br>
						<table id="example"
							data-toggle="table" data-pagination="true" data-search="true"  >
							<thead>
								<tr>
									<th data-sortable="true" style="text-align: center;">Sr No</th>
									
									<th data-sortable="true" style="text-align: center;">Customer Name</th>
									<th data-sortable="true" style="text-align: center;">Device Type</th>
									<th data-sortable="true" style="text-align: center;">Criticality</th>
									<th data-sortable="true" style="text-align: center;">SMS</th>
									<th data-sortable="true" style="text-align: center;">Owner Name</th>
									<th data-sortable="true" style="text-align: center;">Email ID</th>
									<th data-sortable="true" style="text-align: center;">Mobile No</th>
									<th data-sortable="true" style="text-align: center;">Owner Time</th>
									<th data-sortable="true" style="text-align: center;">Escalator1 Name</th>
									<th data-sortable="true" style="text-align: center;">Email ID</th>
									<th data-sortable="true" style="text-align: center;">Mobile No</th>
									<th data-sortable="true" style="text-align: center;">Escalation1 Time</th>
									<th data-sortable="true" style="text-align: center;">Escalator2 Name</th>
									<th data-sortable="true" style="text-align: center;">Email ID</th>
									<th data-sortable="true" style="text-align: center;">Mobile No</th>
									<th data-sortable="true" style="text-align: center;">Escalation2 Time</th>
									<th data-sortable="true" style="text-align: center;">Action</th>
								</tr>
							</thead>
							<tbody>
									<c:forTokens items="${ownerescalation}" delims="~"
									var="dev_own" varStatus="counter">
									<tr>
										<td style="text-align: center;">${counter.count}</td>
										<c:forTokens items="${dev_own}" delims="^" var="dev_own_det">

											<td style="text-align: center;">${dev_own_det}</td>

										</c:forTokens>
									</tr>
								</c:forTokens>
							</tbody>
						</table>

					</div>

				</div>
			</div>

		</div>

<%-- 		<jsp:include page="/WEB-INF/views/Footer.jsp" /> --%>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</div>


	<script type="text/javascript">
		
	</script>




	<!-- jquery
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/vendor/jquery-1.11.3.min.js"></script>
	<!-- bootstrap JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/bootstrap.min.js"></script>
	<!-- meanmenu JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/jquery.meanmenu.js"></script>
	<!-- mCustomScrollbar JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- sticky JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/jquery.sticky.js"></script>
	<!-- scrollUp JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/jquery.scrollUp.min.js"></script>
	<!-- counterup JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/counterup/jquery.counterup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/counterup/waypoints.min.js"></script>
	<!-- modal JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/modal-active.js"></script>
	<!-- touchspin JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/touchspin/jquery.bootstrap-touchspin.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/touchspin/touchspin-active.js"></script>
	<!-- colorpicker JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/colorpicker/jquery.spectrum.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/colorpicker/color-picker-active.js"></script>
	<!-- datapicker JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/datapicker/bootstrap-datepicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/datapicker/datepicker-active.js"></script>
	<!-- input-mask JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/input-mask/jasny-bootstrap.min.js"></script>
	<!-- chosen JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/chosen/chosen.jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/chosen/chosen-active.js"></script>
	<!-- select2 JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/select2/select2.full.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/select2/select2-active.js"></script>
	<!-- ionRangeSlider JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/ionRangeSlider/ion.rangeSlider.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/ionRangeSlider/ion.rangeSlider.active.js"></script>
	<!-- rangle-slider JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/rangle-slider/jquery-ui-1.10.4.custom.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/rangle-slider/jquery-ui-touch-punch.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/rangle-slider/rangle-active.js"></script>
	<!-- knob JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/knob/jquery.knob.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/knob/knob-active.js"></script>
	<!-- main JS
		============================================ -->
	<script src="<%=request.getContextPath()%>/static/AdminPro/js/main.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/bootstrap-table.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/tableExport.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/data-table-active.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/bootstrap-table-editable.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/bootstrap-editable.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/bootstrap-table-resizable.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/colResizable-1.5.source.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/bootstrap-table-export.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/js/multiselect/bootstrap-multiselect.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/setting/ownerEscallation.js"></script>

<script type="text/javascript">
            $(document).ready(function() {
                $("#customer").multiselect({
                    includeSelectAllOption: true
                });
            });

        </script>
</body>

</html>
