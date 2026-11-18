<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send For Feedback/Rejected (SM)</title>
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
							<div class="col-md-4">Send For Feedback/Rejected (SM)</div>

							<div class="col-md-7"></div>

							<div class="col-md-1">
								<a href="<%=request.getContextPath()%>/User/FeedbackRejectedSM">
									<i class="fa fa-backward pull-right" style="color: white">
								</i>
								</a>
							</div>


						</div>

					</div>

					<div class="card-body">
						<div class="row">

							<div class="col-md-6">
								<label for="">Proposal Type :</label> <input type="text"
									id="Proposaltype" tabindex="678" class="form-control"
									data-toogle="tooltip" name="Proposaltype"
									placeholder="Enter Proposal Type" readonly>

							</div>
							<div class="col-md-6" style="display: none;" id="perpetualhideid">
								<label for="">Perpetual Year :</label> <input type="text"
									id="Perpetualyear" tabindex="9" class="form-control"
									data-toogle="tooltip" name="Perpetualyear"
									placeholder="Enter Perpetual Year" readonly="true">


							</div>

							<div class="col-md-6" style="display: none;"
								id="subscriptionhideid">
								<label for="">Subscription Year:</label> <input type="text"
									id="Subscriptionyear" tabindex="10" class="form-control"
									data-toogle="tooltip" name="Subscriptionyear"
									placeholder="Enter Subscription Year" readonly>

							</div>

							<div class="col-md-6" style="display: none;" id="fixedhideid">
								<label for="">Fixed Year:</label> <input type="text"
									id="fixedyear" tabindex="10" class="form-control"
									data-toogle="tooltip" name="fixedyear"
									placeholder="Enter Fixed Year" readonly>

							</div>

							<div class="col-md-6" style="display: none;"
								id="subscriptionANDperpetualhideid">
								<label for="subscriptionANDperpetualYear">Subscription &
									Perpetual Year:</label> <input type="text"
									id="subscriptionANDperpetualYear" tabindex="10"
									class="form-control" data-toogle="tooltip"
									name="subscriptionANDperpetualYear"
									placeholder="Enter Subscription & Perpetual Year" readonly>

							</div>
						</div>
						<br>
						
						
						
						<!-- //26/06 -->
						 <div class="row">
								  
									<div class="col-md-6"  id="proposalforhideid">
											<label for="">Proposal For :</label>											
											<input type="text" id="proposalfor" tabindex="9" class="form-control" 
												data-toogle="tooltip" name="proposalfor" placeholder="Proposal For" readonly="true">
											

									</div>
									
									<div class="col-md-6"  id="partnernamehideid" style="display: none;" >
											<label for="">Partner Name (Optional) :</label>											
											<input type="text" id="partnername" tabindex="9" class="form-control" 
												data-toogle="tooltip" name="partnername" placeholder="Partner Name (Optional)" readonly="true">
											

									</div>
								  </div>
								  <br>
						<!--  -->

						<div class="row">


							<div style="margin-top: 15px;" class="col-md-6">
								<label for="poinitiator">Maker Name : </label> <input
									type="text" class="form-control" id="poinitiator"
									data-toogle="tooltip" name="poinitiator" tabindex="1"
									placeholder="Enter PO Initiator Name" readonly>

							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="pocontactno">Maker Contact No : </label> <input
									type="text" data-toogle="tooltip" class="form-control"
									id="poinitiatorno" name="poinitiatorno" tabindex="1"
									placeholder="Enter PO Contact No" readonly>
							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="approver">Checker Name :</label> <input type="text"
									id="FirstApprovername" tabindex="5"
									class="form-control form-control-sm" name="FirstApprovername"
									data-toogle="tooltip" placeholder="Enter Approver Name"
									readonly>
							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="approvercontact">Checker Contact No :</label> <input
									type="text" id="firstapprovercontact" tabindex="5"
									class="form-control form-control-sm"
									name="firstapprovercontact" data-toogle="tooltip"
									placeholder="Enter Approver Contact No" readonly>

							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="authorizer">Authorized Name :</label> <input
									type="text" id="secondApprovername" tabindex="5"
									class="form-control form-control-sm" name="secondApprovername"
									data-toogle="tooltip" placeholder="Enter Second Approver Name"
									value="Dr. Mangesh Amale" readonly="readonly">
							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="authorizercontact">Authorized Contact No :</label> <input
									type="text" id="secondapprovercontact" tabindex="5"
									class="form-control form-control-sm"
									name="secondapprovercontact" data-toogle="tooltip"
									value="9867140100" readonly="readonly">
							</div>

							<div style="margin-top: 15px;" class="col-md-6">
								<label for="clientname">Customer Name :</label> <input
									type="text" id="clientname" tabindex="5"
									class="form-control form-control-sm" name="clientname"
									data-toogle="tooltip" placeholder="Enter Client  Name"
									readonly="readonly">
							</div>

							<div style="margin-top: 15px;" class="col-md-6">
								<label for="priority1">Remark (Optional) :</label>
								<textarea class="form-control" name="Description" rows="1"
									cols="50" id="Description" name="comments"
									placeholder="Add Description Here" readonly></textarea>

							</div>

							<div style="margin-top: 15px;" class="col-md-6"
								id="hideresourceforamc">
								<label for="">Resources Amount :</label> <input type="text"
									id="resoucesamount" tabindex="5"
									class="form-control form-control-sm" name="resoucesamount"
									data-toogle="tooltip" placeholder="Enter Resouces Amount"
									readonly>
							</div>



							<div style="margin-top: 15px;" class="col-md-6"
								id="hidereATCforamc">
								<label for="ATCID">ATC :</label> <input type="text" id="ATC"
									tabindex="9" class="form-control" data-toogle="tooltip"
									name="ATC" placeholder="Enter ATC" readonly>


							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="authorizercontact"> End Customer
									Name(Optional)</label> <input type="text" id="enccustomername"
									="5" class="form-control form-control-sm"
									name="enccustomername" data-toogle="tooltip"
									placeholder="Enter End Customer Name" readonly>
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
							<input type="hidden" id="filenameStandard"
								name="filenameStandard">



						</div>




						<br> <br>
					
						<br>
						<div class="row" style="display: none;" id="SMnoteDiv">

							<div class="col-md-10">
								<label for="techniq">Note (Optional)</label>
								<textarea id="SMnote" tabindex="1" class="form-control"
									name="SMnote" data-toogle="tooltip" placeholder="Enter Note"
									readonly></textarea>

							</div>

						</div>
						<br>
						<div class="row" style="display: none;" id="SMrejDiv">

							<div class="col-md-10">
								<label for="techniq">SM Rejected Reason</label>
								<textarea id="SMRejctednote" tabindex="1" class="form-control"
									name="SMRejctednote" data-toogle="tooltip"
									placeholder="Enter Note" readonly></textarea>

							</div>

						</div>



					</div>

					<!--                                         <div style="margin-top:15px;" class="col-md-12"> -->
					<!--                                         <center> -->
					<!--                                                                                            <input type="submit" tabindex="8" class="btn btn-primary m-t-10" id="submit-btnnn"  name="submit" value="Submit"> <span class="spinner" style=" display: none"><i class="fa fa-refresh fa-spin fa-10x"></i></span> -->
					<!--                                             <button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="ApproveCM" name="ApproveCM" data-style="expand-left" >Approve &nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem;display: none;" id="spin1"><i class="fa fa-refresh fa-spin fa-10x"></i></span></button>   -->
					<!--                                             <button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="Reject" name="Reject" onclick="myFunctionReject();">Feedback &nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem;display: none;" id="spin2"><i class="fa fa-refresh fa-spin fa-10x"></i></span></button>   -->
					<!--                                         </center> -->
					<!--                                     </div> -->

					<!--                                     <br> -->
					<!-- /.card -->



				</div>


			</div>
		</div>

	</div>





	<br>


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
		src="<%=request.getContextPath()%>/static/custom/ViewVPManualRejectedSMDetails.js"></script>

</body>
</html>