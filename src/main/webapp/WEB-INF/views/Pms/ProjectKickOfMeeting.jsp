<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Project Kick Off Meeting</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->


<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css"
	type="text/css" />



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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/multiselect/bootstrap-multiselect.css">



<!-- Include Bootstrap Multiselect CSS -->
<!-- <link rel="stylesheet" href="path/to/bootstrap-multiselect.css"> -->

<!-- Include Bootstrap Multiselect JS -->
<!-- <script src="path/to/bootstrap-multiselect.js"></script> -->




<!-- summernote -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">

<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

.multiselect-container {
	max-height: 200px;
	max-width: 100%;
	overflow: auto;
}
body {
    overflow-x: hidden;
}
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
</style>


<script>
        <%
            String crno = request.getParameter("crnoo");
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

			<form id="form" name="form" enctype="multipart/form-data">




				<div class="row">

					<div class="col-md-1"></div>
					<div class="col-md-10">
						<br> <br>
						<div class="card card-secondary" id="RD">
							<div class="card-header">
								RD and UD Details <a class="float-right"
									href="<%=request.getContextPath()%>/Admin/ProjectMeeting"
									style="margin-right: 50px"> <i
									class="fa fa-backward pull-right" style="color: white;"> </i>
								</a>
							</div>



							<div class="card-body">
								<!-- 									<div class="card card-secondary"> -->

								<div class="col-md-4 text-center"
									style="margin-left: 290px; font-size: 15px; color: red;">
									<strong>RD Details</strong>
								</div>

								<div class="card-body">
									<div class="row">
										<div class="col-md-4">
											<label for="">PO Number:</label><br> <input
												id="poNumber" class="form-control" data-toggle="tooltip"
												name="poNumber" onchange="getProductSuite()"
												placeholder="PO Number" readonly>

											<!-- Add more options as needed -->

										</div>
										<div class="col-md-4">
											<label for="producSuiteNames">Product Suite:</label><br>
											<input id="producSuiteNames" class="form-control"
												data-toggle="tooltip" name="producSuiteNames" type="text"
												readonly placeholder="Product Suite">
										</div>
										<div class="col-md-4">
											<label for="Securitytool">Security Tool</label><br> <input
												id="Securitytool" class="form-control" data-toggle="tooltip"
												name="Securitytool" type="text" readonly
												placeholder="Security Tool">

										</div>
									</div>

									<!-- Add two more dropdowns on the next line -->
									<div class="row">
										<div class="col-md-4">
											<label for="managerName">Product Manager:</label><br> <input
												id="managerName" class="form-control" data-toggle="tooltip"
												name="managerName" placeholder="Product Manager" readonly>

										</div>
<!-- 										<div class="col-md-4"> -->
<!-- 											<label for="functionName">Function Name:</label><br> <input -->
<!-- 												id="functionName" class="form-control" data-toggle="tooltip" -->
<!-- 												name="functionName" onchange="getNameDetails()" readonly -->
<!-- 												placeholder="Function Name"> -->

<!-- 										</div> -->
										<div class="col-md-4">
											<label for="rdNote">Note:</label><br>
											<textarea id="rdNote" class="form-control"
												style="height: 35px; width: 272px;" data-toggle="tooltip"
												name="rdNote" readonly placeholder="Note"></textarea>
										</div>
										<!-- You can add more dropdowns as needed -->
									</div>

									<!-- Add Note Type dropdown, Choose File input, and Function Name input -->
									<div class="row">


										<!-- 															<div class="col-md-4"> -->
										<!-- 																<label for="fileInput">Download RD File:</label><br> -->

										<!-- 																<button type="button" onclick="downloadFile()">Download</button> -->
										<!-- 															</div> -->

										<div class="col-md-4" id="rdUploadDiv"
											style="margin-top: 12px">
											<label style="margin-left: 2px">Download RD File :
												<div>
													<span class="col-md-6"
														style="color: green; width: 645px; display: inline-block;"
														id="rduploadfile"></span>
												</div>
											</label>
											<button class="button1 button4" id="downHiderdfile"
												onclick="downFileStandard()">Download</button>
										</div>
										<input type="hidden" id="filenameStandard"
											name="filenameStandard">



										<div class="col-md-4" id="maskedUploadDiv"
											style="margin-top: 12px">
											<label style="margin-left: 2px">Download Masked PO
												File :
												<div>
													<span class="col-md-6"
														style="color: green; width: 645px; display: inline-block;"
														id="maskeduploadfile"></span>
												</div>
											</label>
											<button class="button1 button4" id="downHidemaskedfile"
												onclick="maskedStandard()">Download</button>
										</div>
										<input type="hidden" id="masekdfileStandard"
											name="masekdfileStandard">
											
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
									
									<div class= "row">
										
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
									
									
									<br>
									<hr>

									<div class="col-md-4 text-center"
										style="margin-left: 280px; font-size: 15px; color: red;">
										<strong>UD Details</strong>
									</div>
									<br>

									<div class="row">
										<div class="col-md-4">
											<label for="">Project Description</label><br>
											<textarea id="projectDesc" class="form-control" rows="4"
												name="projectDesc" style="height: 31px;" class="col-md-4"
												readonly></textarea>
										</div>


										<div class="col-md-4">
											<label for="">Project Objectives</label><br>
											<textarea id="projectObj" class="form-control" rows="4"
												name="projectObj" style="height: 31px;" class="col-md-4"
												readonly></textarea>
										</div>

										<div class="col-md-4">
											<label for="">Project Scope</label><br>
											<textarea id="projectScope" class="form-control" rows="4"
												name="projectScope" style="height: 31px;" class="col-md-4"
												readonly></textarea>
										</div>

									</div>

									<div class="row">
										<div class="col-md-4">
											<label for="">Functional Requirements</label><br>
											<textarea id="funcReq" class="form-control" rows="4"
												name="funcReq" style="height: 31px;" class="col-md-4"
												readonly></textarea>
										</div>


										<div class="col-md-4">
											<label for="">Non-Functional Requirements</label><br>
											<textarea id="nonFuncReq" class="form-control" rows="4"
												name="nonFuncReq" style="height: 31px;" class="col-md-4"
												readonly></textarea>
										</div>

										<div class="col-md-4">
											<label for="">Technical Requirements</label><br>
											<textarea id="techReq" class="form-control" rows="4"
												name="techReq" style="height: 31px;" class="col-md-4"
												readonly></textarea>
										</div>
									</div>

									<div class="row">
										<div class="col-md-4">
											<label for="fromDate">Project Start Date:</label>

											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="far fa-calendar-alt"></i>
													</span>
												</div>
												<input type="text" readonly class="form-control pull-right"
													autocomplete="off" name="fromDate" id="startDate" readonly
													dateformat="dd-MMM-yyyy">
											</div>
										</div>

										<div class="col-md-4">
											<label for="toDate">Project End Date:</label>
											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"> <i
														class="far fa-calendar-alt"></i>
													</span>
												</div>
												<input type="text" readonly class="form-control pull-right"
													autocomplete="off" name="toDate" id="endDate" readonly
													dateformat="dd-MMM-yyyy">
											</div>
										</div>
									</div>





									<div class="row">
										<!-- 												<div class="col-md-1"></div> -->

										<div class="col-md-4">
											<label for="">Team Leader:</label><br> <input
												id="Teamlead" class="form-control" data-toogle="tooltip"
												name="Teamlead" onchange="getDeveloper()"
												placeholder="Team Leader" readonly>

										</div>
										<!-- 												<div class="col-md-1"></div> -->


										<div class="col-md-4">
											<label for="">Developers :</label><br> <input
												id="Developers" class="form-control" data-toogle="tooltip"
												name="Developers" placeholder="Developer Names" readonly>

										</div>
										<div class="col-md-4">
											<label for="">Note:</label><br>
											<textarea id="note" class="form-control" rows="4" name="note"
												style="height: 31px;" placeholder="Note" readonly></textarea>
										</div>

									</div>

									<div class="row">

										<!-- 										<div class="col-md-4"> -->
										<!-- 											<label for="fileInput">Download UD File:</label><br> -->

										<!-- 											<button type="button" onclick="downloadFile()">Download</button> -->

										<!-- 										</div> -->

										<div class="col-md-4" id="UdUploadDiv"
											style="margin-top: 10px">
											<label style="margin-left: 2px">Download UD File :
												<div>
													<span class="col-md-6"
														style="color: green; width: 430px; display: inline-block;"
														id="udUploadfile"></span>
												</div>
											</label>
											<button class="button1 button4" id="downUDfile"
												onclick="UDStandard()">Download</button>
										</div>
										<input type="hidden" id="udFileStandard" name="udFileStandard">
										
										<div class="col-md-4" id="otherFileDiv" style="margin-top: 10px">
											<label style="margin-left: 2px">Download Other File
												: <div><span class="col-md-6"
												style="color: green; width: 430px; display: inline-block;"
												id="otherFile"></span></div>
											</label>
											<button class="button1 button4" id="otherFileStandard"
												onclick="OtherUDStandard()">Download</button>
										</div>
										


										<!-- 									<div class="col-md-4"> -->
										<!-- 										<label for="fileInput">Upload UD:</label><br> <input -->
										<!-- 											type="file" id="fileInput" name="fileInput" -->
										<!-- 											class="form-control" accept=".pdf, .doc, .docx" -->
										<!-- 											style="height: 36px"> -->
										<!-- 									</div> -->
										<!-- 									<div class="col-md-4"> -->
										<!-- 										<label for="fileInput">Masked PO:</label><br> <input -->
										<!-- 											type="file" id="fileInput" name="fileInput" -->
										<!-- 											class="form-control" accept=".pdf, .doc, .docx" -->
										<!-- 											style="height: 36px"> -->
										<!-- 									</div> -->
									</div>
									
									
									


									<!-- 								<div class="row"> -->
									<!-- 									<div style="margin-top: 15px;" class="col-md-12 text-center"> -->
									<!-- 										<button type="button" class="btn btn-primary m-t-10" -->
									<!-- 											id="submitDoc" name="submitCategType">Submit</button> -->
									<!-- 										<button type="button" class="btn btn-secondary m-t-10" -->
									<!-- 											id="resetbtn1" name="resetCategType" value="Reset">Reset</button> -->
									<!-- 									</div> -->
									<!-- 								</div> -->
								</div>
							</div>
							<br>
						</div>
					</div>
					<div class="col-md-1"></div>
				</div>









				<!-- 			KOM -->

				<div style="padding-left: 15px; padding-right: 15px">
					<div class="card card-secondary border-secondary">
						<div class="card-header">
							<div class="">
								Project Kick Off Meeting <a class="float-right"
									href="<%=request.getContextPath()%>/Admin/ProjectMeeting"
									style="margin-right: 90px"> <i
									class="fa fa-backward pull-right" style="color: white;"> </i>
								</a>
							</div>
						</div>

						<div class="card-body">
							<div class="card">
								<div class="card-header">
									<div class="row">
										<div class="col-md-4">
											<label>Head Persons:</label> <select name="projhead" multiple
												id="projhead" class="form-control " tabindex="1">
											</select>
										</div>





										<div class="col-md-4">
											<label for="salemgr">Sales Team:</label> <select
												name="salemgr" id="salemgr" class="form-control" multiple>
												<!-- Options go here -->
											</select>

										</div>



										<div class="col-md-4">
											<label for="prodmgr">Managers:</label> <select
												name="prodmgr" id="prodmgr" multiple class="form-control"
												tabindex="3">
											</select>
										</div>
									

									
										<div class="col-md-4" style="margin-top: 10px;">

											<label>Schedule Meeting Time:</label> <input type="datetime-local" id="startdate"
												tabindex="5" class="form-control" data-toggle="tooltip"
												name="startdate"> 
											</span>

										</div>

										<div class="col-md-4" style="margin-top: 10px;">
											<label>Types of Meeting:</label> <select name="typeofmeet"
												tabindex="6" id="typeofmeet" class="form-control"
												onchange="dropdownChanged(this.value)">
												<option value="">---Select Meeting Mode---</option>
												<option value="Physical Mode">Physical Mode</option>
												<option value="Virtual Mode">Virtual Mode</option>

											</select>
										</div>
										
										<div class="col-md-4" id="selectTypes" style="margin-top: 10px;">
											<label>Types of Rooms:</label> <select name="typeofrm"
												tabindex="7" id="typeofrm" class="form-control " multiple>
<!-- 												<option value="">---Select Types of Room---</option> -->
												<option value="SecureIT - 901">SecureIT - 901</option>
												<option value="ScanPlus - 906">ScanPlus - 906</option>
												<option value="AssetGrid - 908">AssetGrid - 908</option>
												<option value="Conference - 1st Floor">Conference - 1st Floor</option>

											</select>
										</div>
							
						


	



										<div class="col-md-4" id="virtualmodestype" style="display: none; margin-top: 10px;"">
											<label>Video Conference Meeting:</label> <select
												id="meetingTypesvideo" class="form-control"
												name="meetingTypesvideo" tabindex="13"
												onchange="meetingPlatform(this.value)">
												<option value="">---Select Video Conference Meeting
													---</option>
												<option value="zoom">Zoom</option>
												<option value="teams">Microsoft Teams</option>
												<option value="webex">Cisco Webex</option>
												<option value="GMeet">Google Meet</option>
<!-- 												<option value="Others ">Others</option> -->
											</select>
										</div>


<!-- 										<div class="col-md-4 text-center" id=generateMeetingDiv> -->
<!-- 											<center> -->
<!-- 												<label>Generate Meeting Link:</label> -->
<!-- 												<div> -->
<!-- 													<button type="button" tabindex="14" -->
<!-- 														class="btn btn-success m-t-10" id="meetingLink" -->
<!-- 														name="meetingLink" onclick="generateMeetingLink();">Host -->
<!-- 														Meeting</button> -->
<!-- 												</div> -->
<!-- 											</center> -->
<!-- 										</div> -->




										<div class="col-md-4 text-center" style="margin-top: 10px;" id="generateMeetingDiv">
											<label>Meeting Link/Credentials:</label>
											<div>
												<textarea type="text" id="link" tabindex="5"
													class="form-control" data-toggle="tooltip" name="link"></textarea>
											</div>
										</div>
										
										<div class="col-md-4" style="margin-top: 10px;">
											<label for="uploadMom">Upload Agenda of Meeting  </label> <input
												type="file" id="uploadMom" name="uploadMom"
												class="form-control" style="height: 36px;">
										</div>
											
										<div class="col-md-4" style="margin-top: 10px;">
											<label for="planUploadMom">Other File </label> <input
												type="file" id="planUploadMom" name="planUploadMom"
												class="form-control" style="height: 36px;">
										</div>
										
						


									</div>
								</div>
							</div>
						</div>

						<div style="margin-top: 15px;" class="col-md-12">
							<center>
								<button type="submit" tabindex="14"
									class="btn btn-primary m-t-10" id="submit-btnnn" name="submit"
									onclick="submitData()" data-style="expand-left">
									Submit &nbsp;<span class="spinner-border"
										style="width: 1rem; height: 1rem; display: none;" id="spin1"></span>
								</button>
								<button type="reset" tabindex="15"
									class="btn btn-primary m-t-10" id="Reset" name="Reset"
									onclick="Resetall();">
									Reset &nbsp; &nbsp;<span class="spinner-border"
										style="width: 1rem; height: 1rem; display: none;" id="spin2"></span>
								</button>
							</center>
						</div>



						<br>
					</div>
				</div>
			</form>
<!-- 			<div class="row" id="rowid" style="display: none;"> -->
<!-- 				<div class="col-md-2"></div> -->
<!-- 				<div class="col-md-12"> -->
<!-- 					<div class="card card-secondary" -->
<!-- 						style="margin-left: 15px; margin-right: 15px"> -->
<!-- 						<div class="card-header">Project Kick of Meeting Details</div> -->
<!-- 						<div class="card-body"> -->
<!-- 							<div id="eeeew"> -->

<!-- 								<table class="table table1 table-striped" id="PKMDetails"> -->
<!-- 									<thead> -->
<!-- 										<tr> -->
<!-- 											<th>Sr No</th> -->
<!-- 											<th>Date</th> -->
<!-- 											<th>Meeting Resource</th> -->
<!-- 											<th>Person In Meeting</th> -->
<!-- 											<th>Production Manager</th> -->
<!-- 											<th>Project Head</th> -->
<!-- 											<th>Resource In Meeting</th> -->
<!-- 											<th>Room Capacity</th> -->
<!-- 											<th>Sales Manager</th> -->
<!-- 											<th>Telephonic Meeting</th> -->
<!-- 											<th>Types Meeting</th> -->
<!-- 											<th>Types Of Rooms</th> -->
<!-- 											<th>Video Conference Meeting</th> -->
<!-- 											<th>UploadFile 1</th> -->
<!-- 											<th>UploadFile 2</th> -->

<!-- 										</tr> -->
<!-- 									</thead> -->
<!-- 									<tbody> -->

<!-- 									</tbody> -->

<!-- 								</table> -->
<!-- 							</div> -->

<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="col-md-2"></div> -->
<!-- 			</div> -->
		</div>



	</div>

</body>









<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
	<!-- Control sidebar content goes here -->
</aside>
<!-- /.control-sidebar -->
<!-- 	</div> -->
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
	src="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/js/bootstrap-multiselect.js"></script>

<script
	src="<%=request.getContextPath()%>/static/custom/ProjectKickOfMeeting.js"></script>



<script type="text/javascript">
// 	$('#startdate').datepicker({
// 		autoclose : true,
// 		format : 'dd-mm-yyyy',
// 		todayHighlight : !0,
// 		orientation : "bottom",
// 	}).on('change', function() {

//  	});

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


