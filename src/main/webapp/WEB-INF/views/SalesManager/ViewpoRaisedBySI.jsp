<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PO Raised By SI</title>
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
			<br>

			<div style="padding-left: 15px; padding-right: 15px">

				<div class="card card-secondary border-secondary">

					<div class="card-header">
						<div class="row">
							<div class="col-md-4">PO Raised By SI</div>

							<div class="col-md-7"></div>

							<div class="col-md-1">
								<a href="<%=request.getContextPath()%>/User/poRaisedByme"> <i
									class="fa fa-backward pull-right" style="color: white"> </i>
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


							<div style="margin-top: 15px;" class="col-md-6">
								<label for="proddescrip">Product Description</label><label
									id="bname1"></label>
								<div class="form-group" id="proddescrip11">
									<input type="text" id="proddescrip" tabindex="1"
										class="form-control" name="proddescrip" data-toogle="tooltip"
										placeholder="Enter Product Description" readonly>
								</div>

							</div>
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

							<div style="margin-top: 15px; display: none;"
								id="warrantystartDiv" class="col-md-6">
								<label for="warrantystart">Warranty Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="warrantystart"
									tabindex="1" class="form-control" name="warrantystart"
									data-toogle="tooltip" readonly>
							</div>

							<div style="margin-top: 15px; display: none;" id="warrantyendDiv"
								class="col-md-6">

								<label for="warrantyend">Warranty End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="warrantyend"
									tabindex="1" class="form-control" name="warrantyend"
									data-toogle="tooltip" readonly>

							</div>

							<div style="margin-top: 15px; display: none;"
								id="amcstartdateDiv" class="col-md-6">
								<label for="amcstartdate">AMC Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="amcstartdate"
									tabindex="1" class="form-control" name="amcstartdate"
									data-toogle="tooltip" readonly>
							</div>

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="amcenddateDiv">

								<label for="amcenddate">AMC End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="amcenddate"
									tabindex="1" class="form-control" name="amcenddate"
									data-toogle="tooltip" readonly>

							</div>

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="tennurestartdateDiv">
								<label for="tennurestartdate">Tennure Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="tennurestartdate"
									tabindex="1" class="form-control" name="tennurestartdate"
									data-toogle="tooltip" readonly>
							</div>

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="tennureenddateDiv">

								<label for="tennureenddate">Tennure End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="tennureenddate"
									tabindex="1" class="form-control" name="tennureenddate"
									data-toogle="tooltip" readonly>

							</div>




							<div style="margin-top: 15px; display: none;" class="col-md-6">
								<label for="change">Advance Invoice, if Yes/NO </label><label
									id="phnnno"></label> <input type="text" id="advaninvoice"
									tabindex="1" class="form-control" name="advaninvoice"
									data-toogle="tooltip" placeholder="Add Invoice Yes/No" readonly>

							</div>

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


							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="proposalUploadDiv">
								<label style="margin-left: 2px"> Commercial Proposal
									File :<br> <span class="col-md-6"
									style="color: green; width: 450px" id="proposalfile"></span>
								</label>
								<button class="button1 button4" id="downHideproposalfile"
									onclick="proposalStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameProposal" name="filnameProposal">



							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="maskedPOUploadDiv">
								<label style="margin-left: 2px"> Masked PO File :<br>
									<span class="col-md-6" style="color: green; width: 450px"
									id="maskedPOfile"></span></label>
								<button class="button1 button4" id="downHidemaskedPOfile"
									onclick="maskedPOStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameMaskedPO" name="filnameMaskedPO">



							<!--                                     <div style="margin-top:15px;" class="col-md-6"> -->
							<!--                                          <input -->
							<!-- 											type="file" id="advinvoicefile" name="advinvoicefile" -->
							<!-- 											class="form-control" style="height: 36px;display: none;"> -->
							<!--                                     </div> -->
							





						</div>


						<div class="card card-secondary border-secondary"
							style="margin-top: 30px;">
							<div class="card-body">

								<form id="form" name="form" method="post"
									enctype="multipart/form-data">
									<div class="row">
										<div class="col-md-6">
											<div id="invoattDiv">
											<span id="reupload" style="color:red; display:none; ">Do you want to upload more files ?</span>
												<br> <label for="invoicefile">Invoice File
													Upload</label> <input type="file" id="invoicefile"
													name="invoicefile" class="form-control"
													style="height: 36px" multiple>


												<button type="button" class="btn btn-primary mt-3"
													id="submit-btn" name="submit-btn" style="margin-left: 87%;" onclick="submitFile();">
													Submit<span class="spinner-border"
														style="width: 1rem; height: 1rem; display: none;"
														id="spinner">
												</button>
											</div>

										</div>

										<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="advInvoiceUploadDiv">
								<label style="margin-left: 2px">Uploaded Invoice File :<br>
									<span class="col-md-6" style="color: green; width: 450px"
									id="advinvoicefile"></span></label>
								<button class="button1 button4" id="downHideadvInvfile"
									onclick="advInvFileStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameAdvinvoice"
								name="filnameAdvinvoice">

									</div>


								</form>

							</div>
						</div>

						<br> <br> <br>





					</div>





				</div>


			</div>
			<!-- 				</div> -->
			<!-- 				</form> -->
			<!-- 			</div> -->





			<br>
		</div>


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
		src="<%=request.getContextPath()%>/static/custom/viewPoRaisedBySI.js"></script>

</body>
</html>