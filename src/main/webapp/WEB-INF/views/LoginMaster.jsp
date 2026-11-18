<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Login Master</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css"
	type="text/css" />

<!-- Select2 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">
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
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">

			<section class="content-header">

				<form id="addhardwareform" name="addhardwareform">
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<br> <br>
							<div class="card card-secondary">
								<div class="card-header">Add User</div>
								<div class="card-body">
									<div class="row">
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="firstname">First Name</label>
											<div id="fname1"></div>
											<input type="text" id="fname" tabindex="1"
												class="form-control" name="fname" data-toogle="tooltip"
												placeholder="Enter First Name">

										</div>

										<div style="margin-top: 15px;" class="col-md-6">
											<label for="lastname">Last Name</label>
											<div id="lname1"></div>
											<input type="text" id="lname" tabindex="2"
												class="form-control" name="lname" data-toogle="tooltip"
												placeholder="Enter Last Name">

										</div>
									</div>
									<div class="row">
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="user1">User Name</label> <input type="text"
												id="user" tabindex="3" class="form-control" name="user"
												data-toogle="tooltip" placeholder="Enter User Name"
												autocomplete="false">

										</div>
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="pass">Password</label> <label id="label"></label>
											<input type="hidden" id="length"> <input
												type="password" id="pass" tabindex="4" class="form-control"
												minlength="8" maxlength="15" name="pass"
												onfocusout="checkPassstrength();" data-toogle="tooltip"
												placeholder="Enter Password"> <span id="note"
												style="display: none; font-size: 12px" class="text-danger">Password
												length must be Min 8 characters & Max 15 characters. and
												must contain at least one small & one capital alphabet & one
												special character and numeric digit.</span>
										</div>
									</div>
									<div class="row">
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="Cpass">Confirm Password</label> <input
												type="hidden" id="passnotmatch"> <input
												type="password" id="Cpass" tabindex="5" maxlength="15"
												class="form-control" name="Cpass" data-toogle="tooltip"
												onfocusout="checkPass();"
												placeholder="Enter Confirm Password"> <span
												id="note1" style="display: none;"></span>
										</div>

										<!-- 										<div style="margin-top: 15px;" class="col-md-6"> -->
										<!-- 											<label for="companyname">Company</label> -->
										<!-- 											<div id="company"></div> -->
										<!-- 											<input type="text" id="companyname" tabindex="9" -->
										<!-- 												class="form-control" name="companyname" data-toogle="tooltip" -->
										<!-- 												value="Velox Solutions Pvt Ltd" readonly="readonly"> -->

										<!-- 										</div> -->

										<div style="margin-top: 15px;" class="col-md-6">
											<label for="">Company</label> <select id="cname"
												class="form-control select2" tabindex="7"
												data-toogle="tooltip" name="cname" onchange="getLocation()">
												<!-- 												<option value="">-- Please Select --</option> -->

											</select>

										</div>


									</div>
									<div class="row">
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="location">Location</label> <select id="location"
												class="form-control select2" tabindex="7"
												data-toogle="tooltip" name="location"
												onchange="getSiteDetails()">
												<!-- 												<option value="">-- Please Select --</option> -->

											</select>
										</div>
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="sitename">Branch</label> <select id="sname"
												class="form-control" tabindex="7" data-toogle="tooltip"
												name="sname" onchange="getDeptDetails()">
												<!-- 												getLocation() -->
												<option value="">-- Please Select --</option>

											</select>
										</div>

									</div>


									<div class="row">
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="departmentname">Department</label>

											<!--                                                <input type="text" id="dname" tabindex="8"  maxlength="15" class="form-control" name="dname" data-toogle="tooltip" placeholder="Enter Department Name">-->
											<select id="dname" class="form-control select2" tabindex="8"
												data-toogle="tooltip" name="dname"
												onchange="getsubdepartment()">
												<!-- 												<option value="">-- Please Select --</option> -->

											</select>


										</div>
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="subDepartment">Sub-Department</label> <select
												id="subDepartment" class="form-control" tabindex="11"
												data-toogle="tooltip" name="subDepartment">
												<option value="">-- Please Select --</option>
											</select>

										</div>
									</div>


									<div class="row">
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="mail">Email-ID</label>
											<div id="email"></div>
											<input type="text" id="mail" tabindex="9"
												class="form-control" name="mail" data-toogle="tooltip"
												placeholder="Enter Email-ID">
										</div>


										<div style="margin-top: 15px;" class="col-md-6">
											<label for="cno">Contact Number</label>
											<div id="phnnno"></div>

											<!-- 											<input type="text" id="cno" tabindex="10" -->
											<!-- 												class="form-control" name="cno" data-toogle="tooltip" -->
											<!-- 												placeholder="Enter Contact Number" maxlength="15" oninput="this.value = this.value.slice(0, 10);"  onkeypress="return isNumberKey(event);"> -->
											<input pattern="/^-?\d+\.?\d*$/"
												onKeyPress="if(this.value.length==10) return false;"
												type="text" id="cno" tabindex="10" class="form-control"
												name="cno" data-toogle="tooltip"
												placeholder="Enter Contact Number"
												oninput="this.value = this.value.replace(/[^0-9]/g, '');">

										</div>
									</div>

									<div class="row">
										<div style="margin-top: 15px;" class="col-md-6">
											<label for="gender">Gender</label>
											<div id="gender1"></div>
											<select id="gender" class="form-control" tabindex="8"
												data-toogle="tooltip" name="gender">
												<option value="">-- Please Select --</option>
												<option value="Male">Male</option>
												<option value="Female">Female</option>
											</select>
										</div>


										<div style="margin-top: 15px;" class="col-md-6"></div>
									</div>

									<div class="row">


										<div style="margin-top: 15px;" class="col-md-6">
											<label for="designation">Designation</label> <select
												id="designation" class="form-control select2" tabindex="8"
												data-toogle="tooltip" name="designation">
												<!-- 												<option value="">-- Please Select --</option> -->
											</select>
										</div>
										<br> <br>



										<div class="col-md-6" style="margin-top: 15px;">
											<label for="rtype">Role Type</label> <select id="rtype"
												class="form-control" tabindex="8" data-toogle="tooltip"
												name="rtype" onchange="setLevelScope()">
												<option value="">-- Please Select --</option>
												<!-- 												<option value="Admin">Admin</option> -->
												<!-- 												<option value="Sales">Sales</option> -->
												<!-- 												<option value="Client">Client</option> -->
												<!-- 												<option value="Accounts">Accounts</option> -->
												<!-- 												<option value="User">User</option> -->
												<!--                                                 <option value="Manager">Manager</option> -->
												<!--                                                  <option value="Implementor">Implementor</option> -->
												<option value="Sales_Initiator">Sales Initiator</option>
												<option value="MD">MD</option>
												<option value="Sales_Manager">Sales Manager</option>
												<option value="Account_Manager">Account Manager</option>
												<option value="Collection_Manager">Collection Manager</option>
												 <option value="Head_Projects">Project Manager</option>
												<option value="User">User</option>
												<option value="Implementor">Implementor</option>
												<option value="Admin">Admin</option>
												<option value="Developer">Developer</option>
												<option value="Tester">Tester</option>
												<option value="Sales">Sales</option>
												<option value="Account">Account</option>
												<option value="Support">Support</option>
												 <option value="Support_Manager">Support Manager</option>
												<option value="HR">HR</option>
												 <option value="Business_Head">Business Head</option>
                                                <option value="Manager_Operations">Manager Operations</option>
                                                <option value="Manager_Pre_Sales">Manager Pre Sales</option> 
                                               




											</select>

										</div>


									</div>
									<!-- 									// SCOPE START -->

									<br>
									<hr
										style="margin-top: 5px; margin-bottom: 5px; border-top: 1px solid #c1c1c1;">
									<div class="row">
										<div class="col-md-12" style="text-align: center">
											<label class="control-label" style="font-size: large;">Set
												Scope</label>
										</div>
									</div>
									<div class="row">

										<div class="col-md-4">
											<div class="form-group">
												<label for="settings">Home</label>
												<div id="settings1">
													<select class="form-control setscope" tabindex="9"
														id="settings" name="settings" multiple="multiple">
														<option value="Home">Home</option>

														<option value="Registration_FORM_SI">Registration
															Form SI</option>
														 <option value="LoginMaster">Login Master</option>
														<option value="Purchase_Order_SI">Purchase Order
															SI</option>
														<option value="Commercial_Proposal_SI">Proposal
															SI</option>
																<option value="Manual_Commercial_Proposal_SI">Manual Proposal
															SI</option>
															<option value="Manual_Commercial_Proposal_SM">Manual Proposal
															SM</option>
															<option value="Manual_Commercial_Proposal_MD">Manual Proposal
															MD</option>
														<option value="Revise_Commercial_Proposal_SI">Revise
															Proposal SI</option>

														<option value="Commercial_Proposal_SM">Proposal
															SM</option>
															<option value="Proposal_License_SM">Proposal License
															SM</option>
																<option value="Proposal_License_BH">Proposal License
															MD</option>
															<option value="Proposal_License_CM">Proposal License
															Approved</option>
														<option value="Revise_Commercial_Proposal_SM">Revise
															Proposal SM</option>
														<option value="Purchase_Order_SM">Purchase Order
															SM</option>

														<option value="Registration_FORM_CM">Registration
															Form CM</option>
														<option value="Purchase_Order_CM">Purchase Order
															CM</option>
															
													    <option value="Commercial_Proposal_License">Proposal License</option>

														<option value="RF_MD">RF MD</option>
														<option value="PurchaseOrder_MD">Purchase Order
															MD</option>
														<option value="VeloxProposal_MD">Velox Proposal
															MD</option>
														<option value="Revise_Proposal_MD">Revise
															Proposal MD</option>



														<option value="PMS">PMS</option>
														<option value="Requirement_Documents">Requirement Documents</option>
														<option value="FORM3">FORM3</option>
														<option value="Tracking">Tracker</option>
														<option value="RD">RD</option>
														<option value="UD">UD</option>
														<option value="Project_Kick_Meeting_Approval">Project Kick of Meeting Approval</option>
														<option value="Project_Kick_Of_Meeting">Project Kick Off Meeting</option>
														<option value="ScheduleMeetings">Schedule Meetings</option>
														<option value="Understanding_Documents">Understanding Documents</option>
														<option value="Revise_Manual_Commercial_Proposal_SI">Revise Manual Commercial Proposal By SI</option>
														<option value="Revise_Manual_Proposal_MD">Revise Manual Proposal By MD</option>
														<option value="Assign_RFP_Task">Assign RFP Task</option>
														
														

													</select>
												</div>
											</div>
										</div>

										<div class="col-md-4">
											<div class="form-group">
												<label for="settings">View User List</label>
												<div id="settings1">
													<select class="form-control setscope" tabindex="9"
														id="settings" name="settings" multiple="multiple">
														<option value="View_User_lIST">View User List</option>
													</select>
												</div>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label for="masters">Master</label>
												<div id="master1">
													<select class="form-control setscope" tabindex="9"
														id="masters" name="masters" multiple="multiple">
														<option value="LoginMaster">LoginMaster</option>
														<option value="CustomerMaster">Customer Master</option>
														<option value="DepartmentMaster">Department
															Master</option>
														<option value="ResponsibilityMaster">Responsibility
															Master</option>
														<option value="ProductSuitMaster">Product Suit
															Master</option>
														<option value="SecurityToolMaster">Security Tool
															Master</option>
														<option value="UnitMaster">Unit Master</option>
														<option value="ProductMaster">Product Master</option>
														<option value="PriceMaster">Price Master</option>
														<option value="ProjectNameMaster">Project Name
															Master</option>
														<option value="ModuleMaster">Module Master</option>
														<option value="FunctionMaster">Function Master</option>
														<option value="PMS">PMS</option>
														<option value="OtherCostMaster">Other Cost Master</option>
														<option value="T_CMaster">T&C Master</option>
													</select>
												</div>
											</div>
										</div>

									</div>




									<!-- 									// SCOPE ENDS -->

									<!-- 							<div class="row"> -->
									<!-- 							           <div class="col-md-6" style="margin-top: 15px;"> -->
									<!-- 											<label for="rtype">Checker</label> <select id="rtype" -->
									<!-- 												class="form-control" tabindex="8" data-toogle="tooltip" -->
									<!-- 												name="rtype" onchange="setLevelScope()"> -->
									<!-- 												<option value="">-- Please Select --</option> -->
									<!-- 												<option value="Nishi Maam">Nishi Maam</option> -->
									<!-- <!-- 												<option value="Smita Maam">Smita Maam</option> -->

									<!-- 											</select> -->

									<!-- 										</div> -->

									<!-- 									<div style="margin-top: 15px;" class="col-md-6"> -->


									<!-- 											<label for="rtype">Authorizer</label> <select id="rtype" -->
									<!-- 												class="form-control" tabindex="8" data-toogle="tooltip" -->
									<!-- 												name="rtype" onchange="setLevelScope()"> -->
									<!-- 												<option value="">-- Please Select --</option>												 -->
									<!-- 												<option value="Smita Maam">Smita Maam</option> -->

									<!-- 											</select> -->

									<!-- 									</div>	 -->
									<!-- 							</div>		 -->


									<!-- 									<div class="row mt-3"> -->
									<!-- 										<div class="col-md-6"> -->
									<!-- 											<label for="rtype">Role Type</label> <select id="rtype" -->
									<!-- 												class="form-control" tabindex="8" data-toogle="tooltip" -->
									<!-- 												name="rtype" onchange="setLevelScope()"> -->
									<!-- 												<option value="">-- Please Select --</option> -->
									<!-- 												<option value="Admin">Admin</option> -->
									<!-- 												<option value="Sales">Sales</option> -->
									<!-- 												<option value="Client">Client</option> -->
									<!-- 												<option value="Accounts">Accounts</option> -->
									<!-- 												<option value="User">User</option> -->
									<!--                                                 <option value="Manager">Manager</option> -->
									<!--                                                  <option value="Employee">Employee</option> -->
									<!-- 											</select> -->

									<!-- 										</div>										 -->

									<!-- 									</div> -->
									<div class="row">
										<div style="margin-top: 15px; display: none;" class="col-md-6"
											id="groupCatDiv1">
											<label for="categoryMulti">Category </label>
											<div class="form-group" id="categoryDiv">
												<select id="categoryMulti" tabindex="1" class="form-control"
													data-toogle="tooltip" name="categoryMulti"
													multiple="multiple">



												</select>
											</div>


										</div>
										<div style="margin-top: 15px; display: none;" class="col-md-6"
											id="groupCatDiv2">
											<label for="groupMulti">Group </label>
											<div class="form-group" id="groupDiv">
												<select id="groupMulti" tabindex="1" class="form-control"
													data-toogle="tooltip" name="groupMulti" multiple="multiple">



												</select>
											</div>


										</div>
									</div>


									<br>
									<!-- SERVICE REQUEST CHECK CODE -->
									<label style="display: none;" id="servicerequestcheckbox">Service
										Request Scope</label>
									<div style="display: none;" class='card'
										id="idofservicerequestcard">


										<div class='card-body'>
											<div class="row">

												<div class="col-md-5" id="servicerequestcheck">


													<!-- <input type="checkbox"
												id="servicerequestcheckbox" class="servicerequestcheckbox">
 -->
												</div>
											</div>

											<div class="row">
												<div class="col-md-1"></div>
												<div id="visibilitycheck" class="col-md-5">


													<label for="visibility">Visibility </label> <select
														id="visibility" class="form-control" tabindex="8"
														data-toogle="tooltip" name="visibility">
														<option value="">-- Please Select --</option>
														<option value=" Show ServiceRequest">Show Service
															Request</option>
														<option value="Show All">Show All</option>
													</select>
												</div>

												<div id="groupcheck" class="col-md-5">

													<label for="groupMulti">Group </label>
													<div class="form-group" id="groupCatDiv2ser">
														<select id="groupMultiser" tabindex="1"
															class="form-control" data-toogle="tooltip"
															name="groupMultiser" multiple="multiple">



														</select>
													</div>

												</div>
												<div class="col-md-1"></div>


											</div>
										</div>

									</div>






									<br>

									<div class="row" id="loginScopeDive" style="display: none;">

										<!-- <div class="col-md-1"> Login Scope </div> -->
										<div class="card col-md-12">
											<div class="card-header">
												<strong>Login Scope</strong>
											</div>

											<!-- 												<center> -->
											<!-- 													<strong style="align-items: center;">Login Scope</strong> -->
											<!-- 												</center> -->

											<div class="card-body">


												&nbsp;&nbsp;&nbsp;
												<button type="button" tabindex="15"
													class="btn btn-sm btn-primary" id="addrow" name="addrow"
													style="margin-top: 0px;">Add Row</button>
												&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<button type="button" tabindex="15"
													class="btn btn-sm btn-danger " id="deleteRow"
													name="deleteRow" style="margin-top: 0px;">Delete
													Row</button>

												<table id="perifheralTable" class=" table order-list"
													style="border-spacing: 15px;">

													<thead>
														<tr>
															<td><strong>Company</strong></td>
															<td><strong>Branch</strong></td>
															<td><strong>Department</strong></td>
															<!-- <td><strong>Action</strong></td> -->
														</tr>
													</thead>
													<tbody>
														<tr>

															<td class="form-group adjust"><select
																class="form-control" tabindex="6" data-toogle="tooltip"
																onchange="getBranchDetails('0')"
																onclick="clearTooltipFunction(this.id)"
																name="perifheraltype[]" id="perifheraltype0"></select></td>

															<td class="form-group adjust">
																<div class="form-group" id="perifheralmanufacturerDiv0"
																	onclick="branchtooltipremove(this.id)">
																	<select class="form-control customMulti" tabindex="6"
																		data-toogle="tooltip" multiple="multiple"
																		onchange="getDepart('0')"
																		name="perifheralmanufacturer[]"
																		id="perifheralmanufacturer0"></select>
																</div>
															</td>

															<td class="form-group adjust"><div
																	class="form-group" id="perifheralserialnoDiv0"
																	onclick="departmenttooltipremove(this.id)">
																	<select class="form-control customMulti" tabindex="6"
																		data-toogle="tooltip" multiple="multiple"
																		name="perifheralserialno[]" id="perifheralserialno0"></select>
																</div></td>
														</tr>

													</tbody>
													<!-- <tfoot>
													<tr>
															<td colspan="5" style="text-align: left;"><input
																type="button" class="btn btn-block btn-secondary"
																id="addrow" value="Add Row" /></td>
																<td colspan="5" style="text-align: left;"><input
																type="button" class="btn btn-block btn-secondary"
																id="deleteRow" value="Delete Row" /></td>
														</tr>
														<tr></tr>
														
													</tfoot> -->
												</table>

											</div>
										</div>

									</div>




									<div class="row">

										<div style="margin-top: 15px;" class="col-md-12">
											<center>
												<!--                                                    <input type="submit" tabindex="5" class="btn btn-primary m-t-10" id="submit-btn" name="submit" value="Submit"> <span class="spinner" style=" display: none"><i class="fa fa-refresh fa-spin fa-10x"></i></span>
                                                    <input type="reset" tabindex="6" class="btn btn-primary m-t-10" id="resetbtn" name="reset" value="Reset">-->
												<button type="button" class="btn btn-primary m-t-10"
													tabindex="14" id="submit-btn" name="submit">Submit
												</button>

												<button type="button" tabindex="15"
													class="btn btn-primary m-t-10" id="resetbtn" name="reset">Reset</button>

											</center>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
				</form>


				<form action="saveBulkUploadUserData1" id="bulkuploaduserform"
					name="bulkuploaduserform" method="post"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col-md-1"></div>
						<div class="col-md-10">
							<div class="card card-secondary">
								<div class="card-header">
									Bulk Upload (Insert Records) <a
										href="<%=request.getContextPath()%>/Master/DownloadUserBulkUploadFile"
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
											<span style="color: red">** Fields marked in Red
												colour mandatory and should not be duplicate.</span> <br> *
											Fields marked in Black colour are optional. <br> *
											Kindly do not put null or blank value in any column instead
											put NA as value. <br> * Date Format Should be dd.mm.yyyy
											eg.(10.10.2023)</span>
										</div>
										<div class="col-md-2"></div>
									</div>
									<br>
									<div class="row">
										<div class="col-md-12 text-center">
											<button type="button" tabindex="50"
												class="btn btn-primary m-t-10"
												onclick="submitUploadbutton()" id="upload-btn"
												name="upload-btn">
												Upload <span class="spinner-border"
													style="width: 1rem; height: 1rem; display: none;"
													id="spin12"></span>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
				<!-- 				<form action="saveBulkUploadUserData1" id="bulkuploaduserform" -->
				<!-- 					name="bulkuploaduserform" method="post" -->
				<!-- 					enctype="multipart/form-data"> -->
				<!-- 					<div class="row"> -->
				<!-- 						<div class="col-md-1"></div> -->
				<!-- 						<div class="col-md-10"> -->
				<!-- 							<div class="card card-secondary"> -->
				<!-- 								<div class="card-header"> -->
				<!-- 									Bulk Upload (Update Records) <a -->
				<%-- 										href="<%=request.getContextPath()%>/Master/DownloadUserBulkUploadFile" --%>
				<!-- 										style="color: white" title='Download'> <i -->
				<!-- 										class="fas fa-download float-right"></i> -->
				<!-- 									</a> -->
				<!-- 								</div> -->
				<!-- 								<div class="card-body"> -->
				<!-- 									<div class="row"> -->
				<!-- 										<div class="col-md-4"></div> -->
				<!-- 										<div style="margin-top: 10px;" class="col-md-4"> -->
				<!-- 											<input type="file" id="bulkUserData" name="bulkUserData" -->
				<!-- 												class="form-control" style="height: 36px"> -->
				<!-- 										</div> -->
				<!-- 										<div class="col-md-4"></div> -->
				<!-- 									</div> -->
				<!-- 									<div class="row"> -->
				<!-- 										<div class="col-md-2"></div> -->
				<!-- 										<div class="col-md-8"> -->
				<!-- 											<span style="color: red">** Fields marked in Red -->
				<!-- 												colour mandatory and should not be duplicate.</span> <br> * -->
				<!-- 											Fields marked in Black colour are optional. <br> * -->
				<!-- 											Kindly do not put null or blank value in any column instead -->
				<!-- 											put NA as value.</span> -->
				<!-- 										</div> -->
				<!-- 										<div class="col-md-2"></div> -->
				<!-- 									</div> -->
				<!-- 									<br> -->
				<!-- 									<div class="row"> -->
				<!-- 										<div class="col-md-12 text-center"> -->
				<!-- 																						<button class="btn btn-primary" tabindex="0">Upload</button> -->
				<!-- 											<input type="button" tabindex="15" -->
				<!-- 												class="btn btn-primary m-t-10" id="upload-btn" name="submit" -->
				<!-- 												value="Upload" onclick="submitUploadbutton()"> -->
				<!-- 										</div> -->
				<!-- 									</div> -->
				<!-- 								</div> -->
				<!-- 							</div> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</form> -->

				<!-- 				<div class="card card-secondary" -->
				<!-- 					style="margin-left: 15px; margin-right: 15px"> -->
				<!-- 					<div class="card-header">User Details</div> -->
				<!-- 					<div class="card-body"> -->
				<!-- 						<div id="eeeew"> -->
				<!-- 						<div class="row" id="preLoader"><div class="col-md-12 text-center font-weight-bold h6">Loading <i class="fas fa-sync fa-spin"></i></div></div> -->
				<!-- 							<table class="table table1 table-striped d-none" id="datatype"> -->
				<!-- 								<thead> -->
				<!-- 									<tr> -->
				<!-- 										<th>Sr No</th> -->
				<!-- <!-- 										<th>Password Reset</th> -->
				<!-- <!-- 										<th>Edit</th> -->

				<!-- <!-- 										<th>Delete</th> -->

				<!-- 										<th>User&nbsp;Name</th> -->
				<!-- 										<th>Full Name</th> -->
				<!-- 										<th>Company</th> -->
				<!-- 										<th>Branch</th> -->
				<!-- 										<th>Department</th> -->
				<!-- 										<th>Sub-Department</th> -->
				<!-- 										<th>Email-ID</th> -->
				<!-- 										<th>Contact Number</th> -->
				<!-- 										<th>Designation</th> -->
				<!-- 										<th>Level</th> -->
				<!-- 										<th>Role Type</th> -->


				<!-- 									</tr> -->
				<!-- 								</thead> -->
				<!-- 								<tbody> -->

				<!-- 								</tbody> -->

				<!-- 							</table> -->
				<!-- 						</div> -->
				<!-- 					</div> -->
				<!-- 				</div> -->
			</section>
		</div>
		<!-- 		<div> loginmaster delete and edit</div> -->
		<!-- /.modal-content -->
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>

	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script
		src="<%=request.getContextPath()%>/static//AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
	<%-- <script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery/dist/jquery.min.js"></script>
		

	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery-ui/jquery-ui.min.js"></script> --%>

	<!-- 	<script -->
	<%-- 		src="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/js/bootstrap-multiselect.js"></script> --%>
	<!-- 	<script -->
	<%-- 		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script> --%>

	<!-- 	<script -->
	<%-- 		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script> --%>
	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/chart.js/Chart.min.js"></script>


<!-- 	<script -->
<!-- 		src="http://cdn.rawgit.com/davidstutz/bootstrap-multiselect/master/dist/js/bootstrap-multiselect.js" -->
<!-- 		type="text/javascript"></script> -->

<script src="<%=request.getContextPath()%>/static/multiselect/bootstrap-multiselect.js"
		type="text/javascript"></script>


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
	<!-- Select2 js -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>
	<!-- End -->
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
		src="<%=request.getContextPath()%>/static/custom/loginmaster.js"></script>
	<!-- 	<script -->
	<%-- 		src="<%=request.getContextPath()%>/static/custom/loginmasterupdate.js" --%>
	<!-- 		defer></script> -->

</body>

</html>


