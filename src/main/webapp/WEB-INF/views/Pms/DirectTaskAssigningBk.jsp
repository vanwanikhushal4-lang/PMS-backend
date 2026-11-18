<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Direct Task Assign</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->

<!-- <link rel="stylesheet" -->
<!-- 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" -->
<!-- 	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" -->
<!-- 	crossorigin="anonymous" referrerpolicy="no-referrer" /> -->

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/fas-all.min.css">
	
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">




<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}

.datetimepicker {
	z-index: 1071 !important;
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
            
            String role = request.getParameter("role");
            System.out.println("role" + role);

            String roletype = (String) session.getAttribute("role");
            System.out.println("roleee" + roletype);
            
            String designation = (String) session.getAttribute("designation");
          
            String tid = request.getParameter("tid");
            System.out.println("tid" + tid);

            String projectId = request.getParameter("projectId");
            System.out.println("projectId" + projectId);

          

        %>
    </script>




</head>
<body class="hold-transition sidebar-mini layout-fixed">

	<input type="hidden" id="crnoo" name="crnoo" value="<%=crno%>">

	<input type="hidden" id="tid" name="tid" value="<%=tid%>">

	<input type="hidden" id="role" name="tid" value="<%=role%>">
	
	<input type="hidden" id="roletype" name="roletype" value="<%=roletype%>">

	<input type="hidden" id="designation" name="designation" value="<%=designation%>">

	<input type="hidden" id="projectId" name="projectId"
		value="<%=projectId%>">

	<input type="hidden" id="formABstatus" name="formABstatus" value="">




	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>

		<div class="content-wrapper">

			<div class="row">
				<div class="col-md-1"></div>
				<div class="col-md-10">
					<br>
					
					<div class="card">
							<div class="card-body">
					<ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
						<li class="nav-item"><a class="nav-link active"
							id="custom-tabs-one-home-tab" 
							href="<%=request.getContextPath()%>/Admin/TaskAssigntoDev" 
							aria-controls="custom-tabs-one-home" aria-selected="true">New Task</a></li>
						<li class="nav-item"><a class="nav-link"
							id="custom-tabs-one-issue-tab" 
							href="<%=request.getContextPath()%>/Admin/addCustomizationTask" 
							aria-controls="custom-tabs-one-home" aria-selected="true" style="display:none;">Issue/ Customization Task</a></li>
						<div class="col-md-7"></div>
						<div class="col-md-1">
							<a href="<%=request.getContextPath()%>/Admin/PMS"> <i
								class="fa fa-backward pull-right" style="color: Black"> </i>
							</a>
						</div>

					</ul>


					<div class="container mt-4">
						


								<div class="row">

									<div class="col-md-6">
										<label for="rtype">Function Name :</label> <select
											id="functionName" class="form-control form-control-sm"
											data-toggle="tooltip" name="functionName"></select>
									</div>

									<div class="col-md-6">
										<label>Responsibility :</label> <select id="Responsibility"
											class="form-control form-control-sm" data-toggle="tooltip"
											name="Responsibility">
											<option value=''>-- Please Select --</option>
											<option value="Velox Solution">Velox Solution</option>
											<option value="End Customer">End Customer</option>

										</select>
									</div>

								</div>


								<div class="row">

									<div class="col-md-6" style="margin-top: 15px;">
										<label>Product Suite :</label> <select id="productsuit21"
											class="form-control" data-toogle="tooltip"
											name="productsuit21" onchange="getSecTools()">

										</select>
									</div>

									<div class="col-md-6" style="margin-top: 15px;">
										<label for="">Product Tool :</label> <select
											id="productname21" class="form-control" data-toogle="tooltip"
											name="productname21">
											<option value="">-- Please Select Product Tool --</option>
										</select>
									</div>

								</div>


								<div class="row">

									<div class="col-md-6" style="margin-top: 15px;">
										<label>Customer Name :</label>
										<div class="form-group col-md-12" id="companyDiv"
											style="padding: 0;">
											<select class="form-control select2" id="customerName"
												style="width: 100%;">
												<!-- Add options here if needed -->
											</select>
											
										</div>
									</div>


									<div class="col-md-6" style="margin-top: 15px;">
										<label>Module Name :</label> <input
											class="form-control form-control-sm" type="text"
											placeholder="Enter Your Module Name" id="ModuleName"
											name="ModuleName">
									</div>
								</div>


								<div class="row" id="selectManager">
									<div class="col-md-6">
										<label for="">Assign Task To :</label> <select id="selectMe"
											class="form-control form-control-sm" data-toggle="tooltip"
											name="selectMe" onchange="SelectAssignee()">
											<option value="">-- Please Select --</option>
											<option value="Self">Self</option>
											<option id="DeveloperOption" value="Developer">Developer</option>
											<option value="Tester">Tester</option>
											<option value="Support">Support</option>
										</select>
									</div>
									
									<div class="col-md-6" style=" display: none;" id="teamLeaderSelfDiv">
										<label for="rtype">Team Leader :</label> <select
											id="teamLeaderS" class="form-control form-control-sm"
											data-toggle="tooltip" name="teamLeaderS"></select>
									</div>

									<div class="col-md-6" id="testerDiv" style="display: none;">
										<label for="rtype">Tester :</label> <select id="testerName"
											class="form-control form-control-sm" data-toggle="tooltip"
											name="testerName"></select>
									</div>
								</div>


								<div class="row" id="selectDeveloper" style="display: none;">
									<div class="col-md-6" style="margin-top: 15px;">
										<label for="rtype">Team Leader :</label> <select
											id="teamLeader" class="form-control form-control-sm"
											data-toggle="tooltip" name="teamLeader"></select>
									</div>

									<div class="col-md-6" style="margin-top: 15px;">
										<label>Developer : </label> <select id="developer"
											class="form-control form-control-sm" data-toggle="tooltip"
											name="developer">
										</select>
									</div>
								</div>
								
								
								
								
								<!-- //15/10 -->
								<div class="col-md-6" id="teamLeaderNX" style="margin-top: 15px;display: none;">
										<label for="rtype">Team Leader :</label> <select
											id="teamLeaderN" class="form-control form-control-sm"
											data-toggle="tooltip" name="teamLeaderN"></select>
									</div>
								<!--  -->
								
								
								<!-- //24/07 -->
								<div class="row" id="selectSupport" style="display: none;">
									<div class="col-md-6" style="margin-top: 15px;">
										<label for="rtype">Team Leader :</label> <select
											id="supportteamLeader" class="form-control form-control-sm"
											data-toggle="tooltip" name="supportteamLeader"></select>
									</div>

									<div class="col-md-6" style="margin-top: 15px;">
										<label>Assign To : </label> <select id="support"
											class="form-control form-control-sm" data-toggle="tooltip"
											name="support">
										</select>
									</div>
								</div>
								<!--  -->
								

								<div class="col-md-6" style="margin-top: 15px;">
									<label for="weightage">Weightage :</label> <input type="number"
										id="weightage" class="form-control form-control-sm"
										name="weightage">
								</div>











								<div class="row">

									<div class="col-md-6" style="margin-top: 15px;">
										<label>Start Date :</label>
										<!-- 													<div class="input-group"> -->

										<!-- 														<input type="date" class="form-control pull-right" -->
										<!-- 															autocomplete="off" name="startdate" id="startdate" -->
										<!-- 															placeholder="Please Select Date" dateformat="dd-MM-yyyy"> -->
										<!-- 													</div> -->

										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i
													class="far fa-calendar-alt"></i>
												</span>
											</div>
											<input type="text" readonly class="form-control pull-right"
												autocomplete="off" name="startdate" id="startdate1"
												placeholder="Please Select Date" dateformat="dd-MMM-yyyy">
										</div>


									</div>

									<div class="col-md-6" style="margin-top: 15px;"
										id="engcosthideid">

										<label for="rtype">End Date :</label>
										<!-- 													<div class="input-group"> -->

										<!-- 														<input type="date" class="form-control pull-right" -->
										<!-- 															autocomplete="off" name="enddate" id="enddate" -->
										<!-- 															placeholder="Please Select Date" dateformat="dd-MM-yyyy"> -->
										<!-- 													</div> -->

										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"> <i
													class="far fa-calendar-alt"></i>
												</span>
											</div>
											<input type="text" readonly class="form-control pull-right"
												autocomplete="off" name="enddate" id="enddate1"
												placeholder="Please Select Date" dateformat="dd-MMM-yyyy">
										</div>

									</div>
								</div>



								<div class="row">

									<div class="col-md-6" style="margin-top: 15px;">
										<label>Priority Type :</label> <select id="inputRemark"
											class="form-control form-control-sm" data-toggle="tooltip"
											name="inputRemark">
											<option value=''>-- Please Select --</option>
											<option value="Low">Low</option>
											<option value="Normal">Normal</option>
											<option value="High">High</option>
											<option value="Immediate">Immediate</option>

										</select>
									</div>

									<div class="col-md-6" style="margin-top: 15px;">

										<label>Description : </label>

										<textarea id="description" tabindex="1" class="form-control"
											name="description" data-toogle="tooltip"
											placeholder="Enter Description"></textarea>

									</div>
								</div>

								<br>


								<div style="margin-top: 25px;" class="col-md-12">
									<center>
										<!-- 										<button type="submit" tabindex="8" -->
										<!-- 											class="btn btn-primary m-t-10" id="submitDayTask" -->
										<!-- 											name="submit" data-style="expand-left" -->
										<!-- 											onclick="saveDaywiseTask()"> -->
										<!-- 											Submit &nbsp;<span class="spinner-border" -->
										<!-- 												style="width: 1rem; height: 1rem; display: none;" id="spin2"></span> -->
										<!-- 										</button> -->
										<button type="submit" tabindex="8"
											class="btn btn-primary m-t-10" id="sub" name="submit"
											data-style="expand-left" onclick="saveTaskWithoutPO()">
											Submit &nbsp;<span class="spinner-border"
												style="width: 1rem; height: 1rem; display: none;" id="spin2"></span>
										</button>
										<button type="reset" tabindex="8"
											class="btn btn-secondary m-t-10" id="Reset" name="Reset"
											onclick="ResetData();">Reset</button>
										<!--                                             <button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="Reject" name="Reject" onclick="rejectFunction();">Reject &nbsp; &nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem;display: none;" id="spin2"><i class="fa fa-refresh fa-spin fa-10x"></i></span></button>   -->
									</center>
								</div>





								<!-- 											<div style="margin-bottom: 10px;"> -->
								<!-- 												<div class="text-left"> -->
								<!-- 													<button type="button" tabindex="8" class="btn btn-primary" -->
								<!-- 														id="addRow" name="submit" onclick="addNewRow()"> -->
								<!-- 														Add Row<span class="spinner-border" -->
								<!-- 															style="width: 1rem; height: 1rem; display: none;" -->
								<!-- 															id="spin1"><i class="fa fa-refresh fa-spin fa"></i></span> -->
								<!-- 													</button> -->

								<!-- 												</div> -->
								<!-- 											</div> -->


								<!-- 											<table id="data-table1" class="col-md-12"> -->
								<!-- 												<thead> -->
								<!-- 													<tr class="text-center"> -->
								<!-- 														<th>Function Name:</th> -->
								<!-- 														<th>Module Name:</th> -->
								<!-- 														<th>Responsibility:</th> -->
								<!-- 														<th>Manager Name:</th> -->
								<!-- 														<th>Team Leader:</th> -->
								<!-- 														<th>Developer :</th> -->
								<!-- 														<th style="width: 100px;">Start Date :</th> -->
								<!-- 														<th style="width: 100px;">End Date :</th> -->
								<!-- 																												<th>Status :</th> -->
								<!-- 														<th>Remark :</th> -->
								<!-- 														<th>Delete:</th> -->

								<!-- 													</tr> -->
								<!-- 												</thead> -->
								<!-- 												<tbody> -->
								<!-- 													<tr> -->
								<!-- 														<td><select id="functionName" -->
								<!-- 															class="form-control form-control-sm" -->
								<!-- 															data-toggle="tooltip" name="functionName"> -->

								<!-- 														</select></td> -->

								<!-- 														<td><input class="form-control form-control-sm" -->
								<!-- 															type="text" placeholder="Enter Your Module Name" -->
								<!-- 															id="ModuleName" name="ModuleName"></td> -->

								<!-- 														<td><select id="Responsibility" -->
								<!-- 															class="form-control form-control-sm" -->
								<!-- 															data-toggle="tooltip" name="Responsibility"> -->
								<!-- 																<option value=''>-- Please Select --</option> -->
								<!-- 																<option value="End Customer">End Customer</option> -->
								<!-- 																<option value="Velox Solution">Velox Solution</option> -->
								<!-- 																<option value="Both">Both</option> -->
								<!-- 														</select></td> -->

								<!-- 														<td><select id="managerName" -->
								<!-- 															class="form-control form-control-sm" -->
								<!-- 															data-toggle="tooltip" name="managerName"> -->

								<!-- 														</select></td> -->

								<!-- 														<td><select id="teamLeader" -->
								<!-- 															class="form-control form-control-sm" -->
								<!-- 															data-toggle="tooltip" name="teamLeader"> -->

								<!-- 														</select></td> -->

								<!-- 														<td><select id="developer" -->
								<!-- 															class="form-control form-control-sm" -->
								<!-- 															data-toggle="tooltip" name="developer"> -->

								<!-- 														</select></td> -->
								<!-- 														<td> -->
								<!-- 															<div class="input-group"> -->

								<!-- 																<input type="date" class="form-control pull-right" -->
								<!-- 																	autocomplete="off" name="startdate" id="startdate" -->
								<!-- 																	placeholder="Please Select Date" -->
								<!-- 																	dateformat="dd-MM-yyyy"> -->
								<!-- 															</div> -->
								<!-- 														</td> -->
								<!-- 														<td> -->
								<!-- 															<div class="input-group"> -->

								<!-- 																<input type="date" class="form-control pull-right" -->
								<!-- 																	autocomplete="off" name="enddate" id="enddate" -->
								<!-- 																	placeholder="Please Select Date" -->
								<!-- 																	dateformat="dd-MM-yyyy"> -->
								<!-- 															</div> -->
								<!-- 														</td> -->
								<!-- 														<td><select id="status" -->
								<!-- 															class="form-control form-control-sm" -->
								<!-- 															data-toggle="tooltip" name="status"> -->
								<!-- 																<option value="">--Please Select--</option> -->
								<!-- 																<option value="Complete">Completed</option> -->
								<!-- 																<option value="Pending">Pending</option> -->
								<!-- 																																	<option value="In Progress">In Progress</option> -->
								<!-- 														</select></td> -->
								<!-- 														<td><input class="form-control form-control-sm" -->
								<!-- 															type="text" placeholder="Enter Remark" id="inputRemark" -->
								<!-- 															name="inputRemark"></td> -->

								<!-- 														<td> -->
								<!-- 															<button onclick="deleteRow(this)" -->
								<!-- 																style="background: none; border: none; cursor: pointer;"> -->
								<!-- 																<i class="fa-solid fa-trash-can fa-lg" -->
								<!-- 																	style="color: #fd4444; margin-left: 12px;"></i> -->
								<!-- 															</button> -->
								<!-- 														</td> -->

								<!-- 													</tr> -->
								<!-- 												</tbody> -->
								<!-- 											</table> -->
							</div>
						</div>
						</div>


						<form id="bulkuploaduserform" name="bulkuploaduserform"
							method="post" enctype="multipart/form-data">


							<!--     <div class="card col-md-12"> -->
							<div class="card card-secondary">
								<div class="card-header">
									Bulk Upload (Insert Records) <a
										href="<%=request.getContextPath()%>/Master/DownloadBluckUploadfile"
										style="color: white" title='Download'> <i
										class="fas fa-download float-right"></i>
									</a>
								</div>
								<div class="card-body">
									<div class="row">
										<div class="col-md-4"></div>
										<div style="margin-top: 10px;" class="col-md-4">
											<input type="file" id="bulkUserData" name="bulkUserData"
												class="form-control" style="height: 36px">
										</div>
										<div class="col-md-4"></div>
									</div>
									<div class="row">
										<div class="col-md-2"></div>
										<div class="col-md-8">
											<span style="color: red">** Fields marked in Red are
												mandatory and should not be duplicate.</span> <br> * Fields
											marked in Black are optional. <br> * Kindly do not put
											null or blank value in any column; instead, put NA as the
											value. <br> * Date Format Should be <b>DD.MM.YYYY</b>
											(e.g.<b>20.03.2024</b>)
										</div>
										<div class="col-md-2"></div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-12 text-center">
											<input type="button" tabindex="0"
												class="btn btn-primary m-t-10" id="upload-btn"
												name="upload-btn" value="Upload"
												onclick="submitUploadbutton()"> <span
												class="spinner-border"
												style="width: 1rem; height: 1rem; display: none;"
												id="spin12"></span>
										</div>
									</div>
								</div>
							</div>
							<!--     </div> -->
						</form>










					</div>



					<br>
					<!-- /.card -->



				</div>
				<div class="col-md-1"></div>

			</div>
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
		src="<%=request.getContextPath()%>/static/custom/PmsimplformCdetails.js"></script>

	<script>
		$('#startdate1').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});

		$('#enddate1').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {
		});

		$('#enddatesignoff').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdatesignoff').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdatepaymentterms').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddatepaymentterms').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdatedemo').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddatedemo').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdaterollout').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddaterollout').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdategolive').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddategolive').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdateuattesting').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddateuattesting').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#startdatevlxlicense').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});

		$('#enddatevlxlicense').datepicker({
			autoclose : true,
			format : 'dd-mm-yyyy',
			todayHighlight : !0,
			orientation : "bottom",
		}).on('change', function() {

		});
	</script>

</body>
</html>