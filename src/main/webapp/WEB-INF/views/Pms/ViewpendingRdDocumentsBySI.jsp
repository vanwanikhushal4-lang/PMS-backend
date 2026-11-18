<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending Approval By SI</title>
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

           

            String uid = request.getParameter("uid");
            System.out.println("uid" + uid);

          

        %>
    </script>




</head>
<body class="hold-transition sidebar-mini layout-fixed">

	<input type="hidden" id="crnoo" name="crnoo" value="<%=crno%>">

	<input type="hidden" id="uid" name="uid" value="<%=uid%>">


	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>

			<div style="padding-left: 15px; padding-right: 15px">

				<div class="card card-secondary border-secondary">

					<div class="card-header">
						<div class="row">
							<div class="col-md-4">RD Raised By Me</div>

							<div class="col-md-7"></div>

							<div class="col-md-1">
								<a
									href="<%=request.getContextPath()%>/Admin/pendingRdDocumentsBySI">
									<i class="fa fa-backward pull-right" style="color: white">
								</i>
								</a>
							</div>


						</div>

					</div>

					<div class="card-body">
						<div class="row">
							<div class="col-md-4">
								<label for="">PO Number:</label><br> <input
									id="documentType2" class="form-control" data-toggle="tooltip"
									name="documentType" readonly>

							</div>
							<div class="col-md-4">
								<label for="documentType3">Product Suite:</label><br> <input
									id="documentType3" class="form-control" data-toggle="tooltip"
									name="documentType3" readonly>
							</div>
							<div class="col-md-4">
								<label for="documentType1">Security Tool</label><br> <input
									id="documentType1" class="form-control" data-toggle="tooltip"
									name="documentType1" readonly>

							</div>
						</div>

						<!-- Add two more dropdowns on the next line -->
						<div class="row">
							<div class="col-md-4">
								<label for="documentType4">Product Manager:</label><br> <input
									id="documentType4" class="form-control" data-toggle="tooltip"
									name="documentType4" readonly>

							</div>
<!-- 							<div class="col-md-4" Style="Display:none;"> -->
<!-- 								<label for="documentType5">Function Name:</label><br> <input -->
<!-- 									id="documentType5" class="form-control" data-toggle="tooltip" -->
<!-- 									name="documentType" > -->
<!-- 							</div> -->

							<div class="col-md-4">
								<label for="noteType">Note:</label><br>
								<textarea id="noteType" class="form-control col-md-12"
									style="height: 35px;" data-toggle="tooltip"
									name="noteType" readonly></textarea>
							</div>

						</div>

						<!-- Add Note Type dropdown, Choose File input, and Function Name input -->
						<div class="row">


							<!-- 															<div class="col-md-4"> -->
							<!-- 																<label for="fileInput">Download RD File:</label><br> -->

							<!-- 																<button type="button" onclick="downloadFile()">Download</button> -->
							<!-- 															</div> -->

							<div style="margin-top: 15px;" class="col-md-4" id="rdUploadDiv">
								<label style="margin-left: 2px"> RD Download File :<br>
									<span class="col-md-6"
									style="color: green; width: 645px; display: inline-block;"
									id="rduploadfile"></span>
								</label>
								<button class="button1 button4" id="filenameStandard"
									onclick="downFileStandard()">Download</button>
							</div>
							



							<div class="col-md-4" id="downHidemaskedfile" style="margin-top:15px;">
								<label style="margin-left: 2px">Download Masked PO File:</label>
									<div>
										<span class="col-md-6"
											style="color: green; width: 645px; display: inline-block; font-weight:bold;"
											id="maskeduploadfile"></span>
									</div>
								
								<button class="button1 button4" id="masekdfileStandard" 
									onclick="maskedPOStandard()">Download</button>
							</div>
							
							<div style="margin-top: 15px;" class="col-md-4"
																id="scopeUploadDiv">
																<label style="margin-left: 2px">Scope of Work File :<br> <span class="col-md-4"
																	style="color: green; width: 645px; display: inline-block;"
																	id="scopeuploadfile"></span>
																</label>
																<button class="button1 button4" id="downHidescopefile"
																	onclick="scopefileDownload()">Download</button>
							</div>
							
						</div>
						
						<div class="row">
														
														<div style="margin-top: 15px;" class="col-md-4"
																id="RFPUploadDiv">
																<label style="margin-left: 2px">RFP File :<br> <span class="col-md-4"
																	style="color: green; width: 645px; display: inline-block;"
																	id="RFPuploadfile"></span>
																</label>
																<button class="button1 button4" id="downHideRFPfile"
																	onclick="RFPfileDownload()">Download</button>
														</div>
														
														
														<div style="margin-top: 15px;" class="col-md-4"
																id="otherUploadDiv">
																<label style="margin-left: 2px">Other File :<br> <span class="col-md-4"
																	style="color: green; width: 645px; display: inline-block;"
																	id="otheruploadfile"></span>
																</label>
																<button class="button1 button4" id="downHideotherfile"
																	onclick="otherfileDownload()">Download</button>
														</div>
														
														
														</div>
						
						<br> <br> <br>
					</div>
					<!-- 						<div style="margin-top: 15px;" class="col-md-12"> -->
					<!-- 							<center> -->
					<!-- 								                                                                                           <input type="submit" tabindex="8" class="btn btn-primary m-t-10" id="submit-btnnn"  name="submit" value="Submit"> <span class="spinner" style=" display: none"><i class="fa fa-refresh fa-spin fa-10x"></i></span> -->
					<!-- 								<button type="submit" tabindex="8" -->
					<!-- 									class="btn btn-primary m-t-10" id="approveMD" name="ApproveMD" -->
					<!-- 									data-style="expand-left"> -->
					<!-- 									Approve &nbsp;<span class="spinner-border" -->
					<!-- 										style="width: 1rem; height: 1rem; display: none;" id="spin1"><i -->
					<!-- 										class="fa fa-refresh fa-spin fa-10x"></i></span> -->
					<!-- 								</button> -->
					<!-- 							</center> -->
					<!-- 						</div> -->
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
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/ViewpendingRdDocumentsBySI.js"></script>

</body>
</html>