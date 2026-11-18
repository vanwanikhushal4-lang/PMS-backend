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
<title>Dynamic Dashboard</title>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/data-table/bootstrap-table.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/data-table/bootstrap-editable.css">
<!-- modernizr JS
		============================================ -->
<script
	src="<%=request.getContextPath()%>/static/AdminPro/js/vendor/modernizr-2.8.3.min.js"></script>

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

.fixed-header-top {
	margin-left: -230px;
}

.content-inner-all {
	margin-left: 0;
}

.middle {
	margin-left: auto;
	margin-right: auto;
}
</style>



<body class="materialdesign">


	<!-- Left Panel -->
	<div class="wrapper-pro">


		<div class="content-inner-all">
			<jsp:include page="/WEB-INF/views/FullDashboardHeader.jsp" />

			<!-- Header-->




			<div id="main_div">




				<div class="sparkline11-list shadow-reset mg-t-30">
					<div class="sparkline11-graph">
						<div class="row">

							<div class="col-lg-8">
								<div class="row">

									<div class="col col-md-4">
										<label>Project Name</label><br> <select id="project"
											class="form-control " style="width: 95%;"
											onchange="Customer(this.value)">
											<option value="">Please Select Project</option>
											<c:forTokens items="${projectdetails}" delims="," var="proj">
												<option value="${proj}">${proj}</option>
											</c:forTokens>
										</select>
									</div>

									<div class="col col-md-4">

										<div>
											<label>Customer Name</label><br> <select id="customer"
												TABINDEX="2" class="form-control">
												<option value="">Please Select Customer</option>

											</select>
										</div>
									</div>
									<div class="col col-md-4">

										<div>
											<label>Status</label><br> <select id="type" TABINDEX="2"
												class="form-control">
												<option value="">Please Select Status</option>
												<option value="All">All</option>
												<option value="Up">Up</option>
												<option value="Down">Down</option>
												<option value="Warning">Warning</option>

											</select>
										</div>
									</div>


								</div>
							</div>

							<div class="col-lg-1"></div>

							<div class="col-lg-3">
								<br>
								<button id="submit-btn"
									class="btn btn-sm btn-primary login-submit-cs" type="submit">Submit</button>
								&nbsp;&nbsp; <span>
									<button id="reset-btn" class="btn btn-white" type="submit">Reset</button>
								</span>


							</div>

						</div>

						<!-- 						Jashan -->
						<div class="row">
							<div class="table-responsive a">

								<table id="table1"
									class="table table1 table-striped  table-hover">
									<div id="test" class="test" style="margin-left: -100px">

										<table align="right"
											style="font-family: arial; font-size: medium;">
											<tr>
												<td>
													<div id="loading_router_status">
														<img src="/treecss/dist/themes/default/throbber.gif"
															alt="" height="15" width="15" align="left" />&nbsp;&nbsp;Loading...
													</div>
													<div id="showStatusData"></div>
												</td>
											</tr>
										</table>
									</div>
									<div style="width: 100%; height: auto;">
										<table style="width: 100%">
											<tr>
												<td style="align-content: center">


													<div id="showData">
														<table style="margin-left: auto; margin-right: auto;">
															<tr>
																<td>
																	<div id="loading_total_summary">
																		<i class="fa fa-spinner fa-spin"
																			style="font-size: 24px"></i>Loading...
																	</div>

																</td>
															</tr>
														</table>
														<br>


													</div>

												</td>
											</tr>
										</table>
									</div>

								</table>


							</div>
							<!--                                         jashan -->

						</div>
					</div>
				</div>

			</div>

<%-- 			<jsp:include page="/WEB-INF/views/Footer.jsp" /> --%>
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
		<!-- 	datatable -->
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
			src="<%=request.getContextPath()%>/static/dashboards/dynamic.js"></script>
</body>

</html>

