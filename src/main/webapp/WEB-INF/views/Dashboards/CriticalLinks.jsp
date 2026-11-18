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
<title>Critical Link Dashboard</title>
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

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/tree-viewer/tree-viewer.css">
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
</style>

<style type="text/css">
.tooltip {
	position: relative;
	/*                display: inline-block;*/
	display: inline-block;
	border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
	visibility: hidden;
	width: 100%;
	/*    background-color: black;*/
	color: #fff;
	text-align: center;
	border-radius: 6px;
	padding: 5px 0;
	position: absolute;
	z-index: 1;
	top: -50px;
	left: 110%;
}

.tooltip .tooltiptext:after {
	content: "";
	position: inherit;
	top: 50px;
	right: 100%;
	margin-top: -5px;
	border-width: 15px;
	border-style: solid;
	border-color: transparent white transparent transparent;
}

.tooltip:hover .tooltiptext {
	visibility: visible;
}

table.tool {
	border-collapse: collapse;
	width: 400px;
}

th.tool, td.tool {
	text-align: left;
	padding: 8px;
}

th.tool1, td.tool1 {
	text-align: left;
	padding: 8px;
}
/*tr:nth-child(even){background-color: #f2f2f2}*/
th.tool {
	background-color: forestgreen;
	color: white;
	font-family: Calibri;
	font-size: 25px;
}

th.tool1 {
	background-color: firebrick;
	color: white;
	font-family: Calibri;
	font-size: 25px;
}

td.tool {
	background-color: white;
	color: black;
	border-bottom: none;
}

.indicator {
	width: 100px;
	height: 12px;
	background: url(images/indicator-bg.gif) no-repeat top left;
}

.indicator div {
	height: 12px;
	background: url(images/indicator-green-to-red.gif) no-repeat top left;
}

.indicator div.reverse {
	background: url(images/indicator-red-to-green.gif) no-repeat topp left;
}

.tooltip {
	position: relative;
	/*                display: inline-block;*/
	display: inline-block;
	border-bottom: 1px dotted black;
}

.tooltip .tooltiptext {
	visibility: hidden;
	width: 100%;
	/*    background-color: black;*/
	color: #fff;
	text-align: center;
	border-radius: 6px;
	padding: 5px 0;
	position: absolute;
	z-index: 1;
	top: -50px;
	left: 110%;
}

.tooltip .tooltiptext:after {
	content: "";
	position: inherit;
	top: 50px;
	right: 100%;
	margin-top: -5px;
	border-width: 15px;
	border-style: solid;
	border-color: transparent white transparent transparent;
}

.tooltip:hover .tooltiptext {
	visibility: visible;
}

span.msg {
	font-size: 13px;
}

body {
	background-color: whitesmoke;
}

th.tool2, td.tool2 {
	text-align: left;
	padding: 8px;
}

th.tool2 {
	background-color: #FFEE69;
	color: black;
	font-family: Calibri;
	font-size: 25px;
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

							<div class="col-lg-12">
								<div class="row">

									<div class="col col-md-3">
										<div class="sparkline10-list sparkel-pro-mg-t-30 shadow-reset">
											<div class="sparkline10-hd">
												<div class="main-sparkline10-hd">
													<h1>
														Up Links<br> By(Branch,IP Address)
													</h1>


												</div>
											</div>
											<div class="sparkline10-graph">

												<input type="text" class="form-control" id="searchupip"
													placeholder="Search By ID.." name="searchip" /> <br>
												<div class="adminpro-content">
													<div id="loading1">
														<i class="fa fa-spinner fa-spin" style="font-size: 24px"></i>Loading...
													</div>
													<div id="up_tree"
														style="max-height: 285px; overflow-y: scroll;"></div>
												</div>
											</div>
										</div>
									</div>

									<div class="col col-md-3">
										<div class="sparkline10-list sparkel-pro-mg-t-30 shadow-reset">
											<div class="sparkline10-hd">
												<div class="main-sparkline10-hd">
													<h1>
														Down Links<br> By(Branch,IP Address)
													</h1>


												</div>
											</div>
											<div class="sparkline10-graph">

												<input type="text" class="form-control" id="searchdownip"
													placeholder="Search By ID.." name="searchip" /> <br>
												<div class="adminpro-content">
													<div id="loading2">
														<i class="fa fa-spinner fa-spin" style="font-size: 24px"></i>Loading...
													</div>
													<div id="down_tree"
														style="max-height: 285px; overflow-y: scroll;"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="col col-md-3">
										<div class="sparkline10-list sparkel-pro-mg-t-30 shadow-reset">
											<div class="sparkline10-hd">
												<div class="main-sparkline10-hd">
													<h1>
														Warning Links<br> By(Branch,IP Address)
													</h1>


												</div>
											</div>
											<div class="sparkline10-graph">

												<input type="text" class="form-control" id="searchwarningip"
													placeholder="Search By ID.." name="searchip" /> <br>
												<div class="adminpro-content">
													<div id="loading3">
														<i class="fa fa-spinner fa-spin" style="font-size: 24px"></i>Loading...
													</div>
													<div id="warning_tree"
														style="max-height: 285px; overflow-y: scroll;"></div>
												</div>
											</div>
										</div>
									</div>
									<div class="col col-md-3">
										<div class="sparkline10-list sparkel-pro-mg-t-30 shadow-reset">
											<div class="sparkline10-hd">
												<div class="main-sparkline10-hd">
													<h1>
														Total Summary<br>
													</h1>


												</div>
											</div>
											<div class="sparkline10-graph">


												<div class="adminpro-content">
													<div id="loading4">
														<i class="fa fa-spinner fa-spin" style="font-size: 24px"></i>Loading...
													</div>
													<div style="max-height: 285px; overflow-y: scroll;">
														<table class="table table1 table-striped  table-hover">
															<thead>
																<tr>

																	<th>Link Count</th>
																	<th>Status</th>
																</tr>
															</thead>

														</table>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>


							</div>


						</div>
						<div id="popoverExampleTwoHiddenTitle2"
							style="display: none; background-color: green">
							<span><div id="ip_add"></div></span>
						</div>

						<div id="custom_image_content_up" style="display: none;">
							<span class="tooltiptext">
								<table class="tool">
									<th class="tool"><label id="mlblName"></label></th>
									<th class="tool"></th>
									<tr>
										<td class="tool" align="left">Node is Up</td>
										<td class="tool"></td>
									</tr>
									<tr>
										<td class="tool" align="left"><b>Polling IP Address:</b></td>
										<td class="tool" align="center"><label id="mlblName2"></label></td>
									</tr>

									<tr>
										<td class="tool" align="left"><b>AVG Response Time:</b></td>
										<td class="tool"><label id="mavgresponce"></label></td>
									</tr>
									<tr>
										<td class="tool" align="left"><b>Packet Loss:</b></td>
										<td class="tool"><label id="mpktloss"></label>
											<div class="indicator"
												style="margin-left: 50px; margin-top: -15px">
												<div id="mpktloss_width"></div>
											</div></td>
									</tr>


								</table>
							</span>


						</div>

						<div id="custom_image_content_down" style="display: none;">
							<span class="tooltiptext">
								<table class="tool">
									<th class="tool1"><label id="nlblName"></label></th>
									<th class="tool1"></th>
									<tr>
										<td class="tool" align="left">Node is Down</td>
										<td class="tool"></td>
									</tr>
									<tr>
										<td class="tool" align="left"><b>Polling IP Address:</b></td>
										<td class="tool" align="center"><label id="nlblName2"></label></td>
									</tr>

									<tr>
										<td class="tool" align="left"><b>AVG Response Time:</b></td>
										<td class="tool"><label id="navgresponce"></label></td>
									</tr>
									<tr>
										<td class="tool" align="left"><b>Packet Loss:</b></td>
										<td class="tool"><label id="npktloss"></label>
											<div class="indicator"
												style="margin-left: 50px; margin-top: -15px">
												<div id="npktloss_width"></div>
											</div></td>
									</tr>
								</table>
							</span>

						</div>

						<div id="custom_image_content" style="display: none;">
							<span class="tooltiptext">
								<table class="tool">
									<th class="tool2"><label id="lblName"></label></th>
									<th class="tool2"></th>
									<tr>
										<td class="tool" align="left">Node is Warning</td>
										<td class="tool"></td>
									</tr>
									<tr>
										<td class="tool" align="left"><b>Polling IP Address:</b></td>
										<td class="tool" align="center"><label id="lblName2"></label></td>
									</tr>
									<tr>
										<td class="tool" align="left"><b>AVG Response Time:</b></td>
										<td class="tool"><label id="avgresponce"></label></td>
									</tr>
									<tr>
										<td class="tool" align="left"><b>Packet Loss:</b></td>
										<td class="tool"><label id="pktloss"></label>
											<div class="indicator"
												style="margin-left: 50px; margin-top: -15px">
												<div id="pktloss_width"></div>
											</div></td>
									</tr>
								</table>
							</span>

						</div>
					</div>
				</div>
			</div>

<%-- 			<jsp:include page="/WEB-INF/views/Footer.jsp" /> --%>
			
			<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		</div>
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
	<!-- Tree JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/tree-line/jstree.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/dashboards/criticalLinks.js"></script>
	<script type="text/javascript">
		$('#searchupip').on('keyup', function() {

			var searchString = $(this).val();

			$('#up_tree').jstree('search', searchString);

		})

		$('#searchdownip').on('keyup', function() {

			var searchString = $(this).val();

			$('#down_tree').jstree('search', searchString);

		})
		$('#searchwarningip').on('keyup', function() {

			var searchString = $(this).val();

			$('#warning_tree').jstree('search', searchString);

		})
	</script>

</body>

</html>

