<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Software Release</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--         <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"> -->
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

label {
	margin-top: .5rem !important;
	margin-bottom: 0rem !important;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<% 
       HttpSession htt = request.getSession(true);
            String uname = (String) htt.getAttribute("username");
            System.out.println("usernamemeeem" + uname);
            String utype = (String) htt.getAttribute("role");
         
            
            %>

		<%   if(utype.equals("User")||utype.equals("IT-Head")){  %>

		<jsp:include page="/WEB-INF/views/dashboardheaderUser.jsp"></jsp:include>
		<% }  else if(utype.equals("Engineer")) {%>
		<jsp:include page="/WEB-INF/views/dashboardheaderEngg.jsp"></jsp:include>

		<%}  else if(utype.equals("Ticket Co-ordinator")){%>
		<jsp:include page="/WEB-INF/views/dashboardheaderTP.jsp"></jsp:include>
		<% }%>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>
			<section class="content-header">
				<div class="row">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<form action="insertUserRaiseTicket" id="form" name="form"
							method="post" enctype="multipart/form-data">
							<div class="card card-secondary">

								<div class="card-header">Software Release</div>
								<div class="card-body">

									<div class="row">

										<div class="col-md-5"></div>
										<div class="col-md-4" style="font-size: 14px; color: red;">
											<strong>Request Basic Details</strong>
										</div>
										<div class="col-md-4"></div>
									</div>

									<div class="row">


										<div class="col-md-4">
											<label for="cname">Name: </label> <input type="text"
												id="name1" tabindex="1" readonly="true" class="form-control"
												data-toogle="tooltip" name="name1">
										</div>
										<div class="col-md-4">
											<label for="cname">Company:</label> <input type="text"
												id="compname" tabindex="5" readonly="true"
												class="form-control" data-toogle="tooltip" name="compname">
										</div>
										<!--                                                 <div class="col-md-4"> -->
										<!--                                                     <label for="cname">Date:</label> -->
										<%--                                                     <input type="text" tabindex="2" id="datepicker5" value="<%=cdate%>" displayFormat="dd/mm/yy" readonly="true" class="form-control" data-toogle="tooltip" name="datepicker5" > --%>
										<!--                                                 </div> -->

										<input type="hidden" id="username" name="username"> <input
											type="hidden" id="vipuser" name="vipuser">

										<div class="col-md-4">
											<label for="cname">Branch:</label> <input type="text"
												id="site" tabindex="6" readonly="true" class="form-control"
												data-toogle="tooltip" name="site">
										</div>

									</div>

									<div class="row">

										<div class="col-md-4">
											<label for="cname">Department:</label> <input type="text"
												id="department" readonly="true" class="form-control"
												data-toogle="tooltip" name="department">
										</div>
										<div class="col-md-4">
											<label for="cname">Sub-Department:</label> <input type="text"
												id="sub_department" readonly="true" class="form-control"
												data-toogle="tooltip" name="sub_department">
										</div>
										<div class="col-md-4">
											<label for="cname">Location:</label> <input type="text"
												id="location" readonly="true" class="form-control"
												data-toogle="tooltip" name="location">
										</div>


									</div>

									<div class="row">

										<div class="col-md-4">
											<label for="cname">Email-ID:</label> <input type="text"
												id="emailid" tabindex="4" readonly="true"
												class="form-control" data-toogle="tooltip" name="emailid">
										</div>
										<div class="col-md-4">
											<label for="cname">Contact No:</label> <input type="text"
												id="phone" tabindex="3" class="form-control"
												data-toogle="tooltip" name="phone" onkeypress="phoneno()" maxlength="10">
										</div>
										
									</div>
				

								
									
										<hr>
										
																			<div class="row">
										<div class="col-md-4">
											<label for="cname">Project ID:</label> <select id="pid"
												tabindex="7" class="form-control" data-toogle="tooltip"
												name="pid">
<!-- 												onchange="JavaScript:getApprovalGroup(this.value)"> -->
												
												<option value="815608">815608</option>
											</select>
										</div>
										<div class="col-md-4">
											<label for="cname">Approver Name:</label>
											<div id="appdiv">
												<select id="approup" tabindex="7"
													class="form-control select2" data-toogle="tooltip"
													name="approup"
													onchange="JavaScript:getApprovalDetails(this.value)">
													<option value="">PLease select</option>
													<option value="51069~SAMEER NAVARE">51069~SAMEER NAVARE</option>
													<option value="72372~PARAG GHODKE">72372~PARAG GHODKE</option>
													<option value="71257~AVINASH MULIK">71257~AVINASH MULIK</option>
												</select>
											</div>
										</div>
									</div>
									
									<div id="Hideotherdata" style="display: none;">
										<br> <strong>Selected Approver Details :</strong>
										<div class="card mt-2">
											<div class="card-body ">

												<div class="row">

													<div class="col-md-4">
														<label for="cname">Company:</label> <input type="text"
															id="othercompname" tabindex="5" readonly="true"
															class="form-control" data-toogle="tooltip"
															name="othercompname">
													</div>


													<div class="col-md-4">
														<label for="cname">Branch:</label> <input type="text"
															id="othersite" tabindex="6" readonly="true"
															class="form-control" data-toogle="tooltip"
															name="othersite">
													</div>
													<div class="col-md-4">
														<label for="cname">Department: </label> <input type="text"
															id="otherdepart" tabindex="1" readonly="true"
															class="form-control" data-toogle="tooltip"
															name="otherdepart">
													</div>

												</div>
												<div class="row">

													<div class="col-md-4">
														<label for="cname">Full Name:</label> <input type="text"
															id="otherfullname" tabindex="5" readonly="true"
															class="form-control" data-toogle="tooltip"
															name="otherfullname">
													</div>


													<div class="col-md-4">
														<label for="cname">Email:</label> <input type="text"
															id="otheremail" tabindex="6" readonly="true"
															class="form-control" data-toogle="tooltip"
															name="otheremail">


													</div>


													<div class="col-md-4">

														<label for="cname">Role Type:</label> <input type="text"
															id="roletype" tabindex="6" readonly="true"
															class="form-control" data-toogle="tooltip"
															name="roletype">

													</div>

												</div>
											</div>
										</div>
									</div>
									<hr>
									<div class="row">
										<div class="col-md-5"></div>
										<div class="col-md-4" style="font-size: 14px; color: red;">
											<strong>Software Details </strong>
										</div>
										<div class="col-md-4"></div>
									</div>
									<div class="row">
										<div class="col-md-4">
											<label for="cname">Software Name:</label> 

												<div id="softDiv">
												<select id="sname" tabindex="7"
													class="form-control select2" data-toogle="tooltip"
													name="sname"
													onchange="JavaScript:getAppDateAndAssetCode(this.value)">

												</select>
											</div>
										</div>
										<div class="col-md-4">
											<label for="cname">Applied Date:</label> <input type="text" id="cost"
												tabindex="6" readonly="true" class="form-control"
												data-toogle="tooltip" name="cost">
										</div>
										<div class="col-md-4">
									<label for="cname">Asset Code:</label> <input
												type="text" id="rperiod" tabindex="1" readonly="true"
												class="form-control" data-toogle="tooltip" name="rperiod">
										</div>
									</div>
									<br>
									<hr>
									<div class="row">
										<div class="col-md-6">
											<label for="cname">Request Category:</label> 
											<select
												id="typecategory" tabindex="7" class="form-control"
												data-toogle="tooltip" name="typecategory"
												onchange="JavaScript:CategoryType(this.value)">
												<option value="">--Please Select--</option>
												<option value="Desktop">Desktop</option>
												<option value="Laptop">Laptop</option>
												<option value="Server">Server</option>
											</select>

										</div>
										<div class="col-md-4"></div>
									</div>
									
									
									
										<div id="ipaddresss" style="display:none">
										<div class="row">
										<div class="col-md-4">
										<label>IP Address: </label>
										<input type="text" name="ipaddress" id="ipaddress" class="form-control">
											</div>
											
										<div class="col-md-4">
											<label>Owner Name:</label>	
										<input type="text" name="ownername" id="ownername" class="form-control" >
										</div>
										
										<div class="col-md-4">
											<label>Host Name/Asset Code:</label>	
										<input type="text" name="hostname"  id="hostname" class="form-control" >
										</div>
										</div>
									</div>
									<div id="softwarename" style="display: none;">
									<div class="row">
										<div class="col-md-6">
										<label>Asset Code: </label>
										<input type="text" name="assetname"id="assetname" class="form-control">
											</div>
											
										<div class="col-md-6">
											<label>IP:</label>	
<!-- 										<input type="text" name="ip"  id="ip" class="form-control" > -->
												<div class="input-group">
													<input type="text" id="ip" name="ip" class="form-control"
														data-inputmask="'alias': 'ip'" data-mask=""
														inputmode="decimal">
												</div>
										</div>
										</div>
										<div class="row">
										<div class="col-md-6">
										<label>Status: </label>
										<select
												id="st" tabindex="7" class="form-control"
												data-toogle="tooltip" name="st">
												<option value="">--Please Select--</option>
												<option value="In Use">In Use</option>
												<option value="In Stock">In Stock</option>
											</select>
											</div>
										<div class="col-md-6">
										<label>Computer Name: </label>
										<input type="text" name="compName"  id="compName" class="form-control" >
										</div>
										</div>
									</div>
									<hr>
									
									<div class="row">
										<div class="col-md-10">
											<label for="cname">Remarks:</label>
											<textarea type="text" rows="5" cols="20" id="description"
												tabindex="12" class="form-control" data-toogle="tooltip"
												name="description" placeholder="Please Enter Remarks" maxlength="2000"
												onkeyup="characterCounter()"></textarea>
												<span id="note"
												style="font-size: 12px" class="text-danger">Description 
												length must be Min 1 characters & Max 2000 characters. </span>
												<br><span id="counterSpan" class="text-danger" style="display: none">												
												Remaining Characters are <span id="calulateId"></span>
												</span>
										</div>
										<div class="col-md-2"></div>
									</div>

								

									<div class="row">

										<div class="col-md-5"></div>
										<div class="col-md-4" style="font-size: 14px; color: red;">
											<strong>Attachments (Optional)</strong>
										</div>
										<div class="col-md-4"></div>
									</div>

									<div class="row">


										<div class="col-md-4">
											<label>Browse File:</label> <input id="empPic" name="empPic"
												tabindex="14" type="file" aria-describedby="nameHelp">
												<i class="nav-icon fas fa-trash" onclick="$('#empPic').val('').trigger('change');"></i>
										</div>

										<div class="col-md-8"></div>
									</div>
									<!--  CODE FOR GET  ASSIGN USER DATA STRAT -->
									<!--                                             <div id="Hideotherdata" style="display: none;"> -->
									<!--                                             <br> -->
									<!--                                             <strong>Selected User Details :</strong> -->
									<!--                                             <div class="card mt-2"> -->
									<!--   											<div class="card-body "> -->

									<!--                                              <div class="row" > -->

									<!-- 												<div class="col-md-4"> -->
									<!--                                                     <label for="cname">Company:</label> -->
									<!--                                                     <input type="text" id="othercompname" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="othercompname"> -->
									<!--                                                 </div> -->


									<!-- 												<div class="col-md-4"> -->
									<!--                                                     <label for="cname">Branch:</label> -->
									<!--                                                     <input type="text" id="othersite" tabindex="6" readonly="true" class="form-control" data-toogle="tooltip" name="othersite"> -->
									<!--                                                 </div> -->
									<!--                                                    <div class="col-md-4"> -->
									<!--                                                     <label for="cname">Department: </label> -->
									<!--                                                     <input type="text" id="otherdepart" tabindex="1" readonly="true" class="form-control" data-toogle="tooltip" name="otherdepart"> -->
									<!--                                                 </div> -->

									<!-- 												</div> -->
									<!-- 												<div class="row"> -->

									<!-- 												<div class="col-md-4"> -->
									<!--                                                     <label for="cname">Full Name:</label> -->
									<!--                                                     <input type="text" id="otherfullname" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="otherfullname"> -->
									<!--                                                 </div> -->


									<!-- 												<div class="col-md-4"> -->
									<!--                                                     <label for="cname">Email:</label> -->
									<!--                                                     <input type="text" id="otheremail" tabindex="6" readonly="true" class="form-control" data-toogle="tooltip" name="otheremail"> -->


									<!-- 												</div> -->
									<!-- 													<div class="col-md-4"></div> -->

									<!--                                             </div> -->
									<!--                                             </div> -->
									<!--                                             </div> -->
									<!--                                             </div> -->

									<!--  CODE FOR GET  ASSIGN USER DATA END -->

									<input type="hidden" name="approve_level" readonly="readonly"
										id="approve_level" /> <input type="hidden" name="requestcost"
										readonly="readonly" id="requestcost" /> <input type="hidden"
										name="designationlevel2" readonly="readonly"
										id="designationlevel2" /> <br>
									<div class="row" style="display: none">

										<div class="col-md-5"></div>
										<div class="col-md-4" style="font-size: 14px; color: red;">
											<strong>Attachments (Optional)</strong>
										</div>
										<div class="col-md-4"></div>
									</div>

									<div class="row" style="display: none">


										<div class="col-md-4">
											<label>Browse File:</label> <input id="empPic" name="empPic"
												tabindex="14" type="file" aria-describedby="nameHelp">
												<i class="nav-icon fas fa-trash" onclick="$('#empPic').val('').trigger('change');"></i>
										</div>

										<div class="col-md-8"></div>
									</div>



									<!--</form>-->
									<br>
									<div class="row">
										<div class="col-md-12">
											<center>
												<input type="button" tabindex="15"
													class="btn btn-primary m-t-10" id="raise-btn" name="submit"
													value="Raise" onclick="submitbutton101()"> <input
													type="button" tabindex="16" class="btn btn-primary m-t-10"
													id="resetbtn" name="reset" value="Reset">
											</center>
										</div>
									</div>

								</div>
							</div>
						</form>
					</div>
				</div>

			</section>

		</div>

		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

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
		
	<!-- IP Address start -->
	<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/inputmask/jquery.inputmask.min.js"></script>
	<!-- IP Address End -->
	
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
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>


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
		src="<%=request.getContextPath()%>/static/custom/SoftwareRelease.js"></script>
</body>

</html>


