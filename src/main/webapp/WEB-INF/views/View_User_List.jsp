<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>View User List</title>
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
<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">

			<section class="content-header">

				

				<div class="card card-secondary"
					style="margin-left: 15px; margin-right: 15px">
					<div class="card-header">User Details</div>
					<div class="card-body">
						<div id="eeeew">
						<div class="row" id="preLoader"><div class="col-md-12 text-center font-weight-bold h6">Loading <i class="fas fa-sync fa-spin"></i></div></div>
							<table class="table table1 table-striped d-none" id="datatype">
								<thead>
									<tr>
										<th>Sr No</th>
										<th>Password Reset</th>
										<th>Edit</th>
										<th>Delete</th>
										<th>User&nbsp;Name</th>
										<th>Full Name</th>
										<th>Company</th>
										<th>Branch</th>
										<th>Department</th>
										<th>Sub-Department</th>
										<th>Email-ID</th>
										<th>Contact Number</th>
										<th>Designation</th>
										<th>Level</th>
										<th>Role Type</th>
									</tr>
								</thead>
								<tbody>

								</tbody>

							</table>
						</div>
					</div>
				</div>
			</section>
		</div>



		<div class="row">

			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="PasswordResetModal" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Password
								Reset</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px"
								onclick="disableModal()">
								<span aria-hidden="true">&times;</span>
							</button>



						</div>
						<div class="modal-body">


							<div class="row">

								<div class=col-md-6>
									<label for="username" style="margin-left: 11%;"> User
										Name:</label> <input type="text" class="form-control"
										style="width: 75%; margin-left: 11%;" id="username"
										name="username" tabindex="1" readonly />
								</div>

								<div class=col-md-6>


									<label for="passwordss">Password</label> <label id="label123"></label>
									<input type="hidden" id="length"> <input
										type="password" id="password" tabindex="4"
										class="form-control" minlength="8" maxlength="15"
										name="password" onfocusout="checkPassstrengthForPassReset();"
										data-toogle="tooltip" placeholder="Enter Password"> <span
										id="note123" style="display: none; font-size: 12px"
										class="text-danger">Password length must be Min 8
										characters & Max 15 characters. and must contain at least one
										small & one capital alphabet & one special character and
										numeric digit.</span>




								</div>
								<input id="loginid" type="hidden">
							</div>


							<div class="row">


								<div class=col-md-6>

									<label for="confirmPassword" style="margin-left: 11%;">Confirm
										Password</label> <input type="password"
										placeholder="Please Enter Confirm Password"
										class="form-control" style="width: 75%; margin-left: 11%;"
										id="confirmPassword" name="confirmPassword" tabindex="3"
										onfocusout="checkPassword();" /> <span id="note3"
										style="display: none;"></span>

								</div>

								<div class=col-md-6></div>

							</div>
							<br> <br>




							<div class="row">
								<div class="col-md-12">
									<center>
										<input type="submit" class="btn btn-primary m-t-10"
											id="passwordUpdate" name="update_drivemonitoring_btn"
											value="Update">
												<button type="button" tabindex="5"
											class="btn btn-primary m-t-10" id="resetbtn" name="reset">Reset</button>

									</center>
								</div>
							</div>

						</div>

						<div class="col-md-2"></div>
					</div>

					<!--</form>-->



				</div>

			</div>
			<!-- /.modal-content -->
		</div>









		<div class="row">


			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modeleditengg" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Update User</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px"
								onclick="disableModal()">
								<span aria-hidden="true">&times;</span>
							</button>


						</div>
						<div class="modal-body">
							<!--<form action="">-->


							<div class="row">
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="firstnameupdate1">First Name</label> <input
										type="text" id="fnameupdate" tabindex="14"
										class="form-control" name="fnameupdate" data-toogle="tooltip"
										placeholder="Enter First name">

								</div>

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="lastnameupdate1">Last Name</label> <input
										type="text" id="lnameupdate" tabindex="15"
										class="form-control" name="lnameupdate" data-toogle="tooltip"
										placeholder="Enter Last name">

								</div>
							</div>
							<div class="row">

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="userupdate1">User Name</label><label
										id="userupdate1"></label> <input type="text" id="userupdate"
										class="form-control" name="userupdate" data-toogle="tooltip"
										placeholder="Enter User Name" readonly>

								</div>
								<div style="margin-top: 15px;" class="col-md-6">


									<label for="mailupdate1">Email-ID</label>
									<div id="emailupdate"></div>
									<input type="text" id="mailupdate" tabindex="21"
										class="form-control" name="mailupdate" data-toogle="tooltip"
										placeholder="Enter Email-ID">
									<!-- <label for="passupdate1">Password</label>
									<div id="labelupdate"></div>
									<input type="hidden" id="lengthupdate"> <input
										type="password" id="passupdate" tabindex="16"
										class="form-control" minlength="8" maxlength="15"
										name="passupdate" onfocusout="checkPassstrengthupdate();"
										data-toogle="tooltip" placeholder="Enter Password"> <span
										id="noteupdate" style="display: none; font-size: 12px"
										class="text-danger">Password length must be Min 8
										characters & Max 15 characters. and must contain at least one
										small & one capital alphabet & one special character and
										numeric digit.</span> -->
								</div>
							</div>
							<div class="row">
								<div style="margin-top: 15px;" class="col-md-6">

									<label for="cnoupdate1">Contact Number</label>
									<div id="phnnnoupdate"></div>
									<input type="text" id="cnoupdate" tabindex="22"
										class="form-control" name="cnoupdate" data-toogle="tooltip"
										placeholder="Enter Contact Number">


									<!-- <label for="Cpassupdate">Confirm Password</label> <input
										type="hidden" id="passnotmatchupdate"> <input
										type="password" id="Cpassupdate" tabindex="17" maxlength="15"
										class="form-control" name="Cpassupdate" data-toogle="tooltip"
										onfocusout="checkPassupdate();"
										placeholder="Enter Confirm Password"> <span
										id="note1update" style="display: none;"></span> -->
								</div>
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="companynameupdate1">Company</label> <INPUT type="text"
										id="cnameupdate" class="form-control" tabindex="18"
										data-toogle="tooltip" name="cnameupdate"
										onchange="getlocationUpdated(); getDesignationUpdate(this.value);" disabled="disabled">

								</div>
							</div>
							<div class="row">
								<div style="margin-top: 15px;" class="col-md-6">

									<label for="locationupdate">Location</label>

									<!--                                                <input type="text" id="dnameupdate" tabindex="20"  maxlength="15" class="form-control" name="dnameupdate" data-toogle="tooltip" placeholder="Enter Department Name">-->
									<select id="locationupdate" class="form-control" tabindex="20"
										data-toogle="tooltip" name="locationupdate"
										onchange="getSiteDetailsupdateEngg(this.value)">
										<option value="">-- Please Select --</option>

									</select>
								</div>
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="sitenameupdate1">Branch</label> <select
										id="snameupdate" class="form-control" tabindex="19"
										data-toogle="tooltip" name="snameupdate"
										onchange="getDepartmentUpdate()">
										<option value="">-- Please Select --</option>

									</select>
								</div>
								
							</div>

							<div class="row">
								<div style="margin-top: 15px;" class="col-md-6">
									<label for="departmentnameupdate1">Department</label>

									<!--                                                <input type="text" id="dnameupdate" tabindex="20"  maxlength="15" class="form-control" name="dnameupdate" data-toogle="tooltip" placeholder="Enter Department Name">-->
									<select id="dnameupdate" class="form-control" tabindex="20"
										data-toogle="tooltip" name="dnameupdate"
										onchange="getSubDepartmentUpdate()">
										<option value="">-- Please Select --</option>

									</select>
								</div>

								<div style="margin-top: 15px;" class="col-md-6">

									<label for="subdnameupdate">Sub-Department </label>

									<!--                                                <input type="text" id="dnameupdate" tabindex="20"  maxlength="15" class="form-control" name="dnameupdate" data-toogle="tooltip" placeholder="Enter Department Name">-->
									<select id="subdnameupdate" class="form-control" tabindex="20"
										data-toogle="tooltip" name="subdnameupdate">
										<option value="">-- Please Select --</option>

									</select>


								</div>

							</div>

	<div class="row">

								<div style="margin-top: 15px;" class="col-md-6">
									<label for="designationUpdate">Designation</label> <select
										id="designationUpdate" class="form-control" tabindex="12"
										data-toogle="tooltip" name="designationUpdate">
										<option value="">-- Please Select --</option>
									</select>
								</div>

                                  <div style="margin-top: 15px;" class="col-md-6">


									<label for="rtypeupdate">Role Type</label> <select
										id="rtypeupdate" class="form-control" tabindex="8"
										data-toogle="tooltip" name="rtypeupdate"
										onchange="setLevelScopeUpdate()">
										<option value="">-- Please Select --</option>
<!-- 										<option value="Admin">Admin</option> -->
<!-- 										<option value="Engineer">Engineer</option> -->
<!-- 										<option value="IT-Head">IT-Head</option> -->
<!-- 										<option value="Ticket Co-ordinator">Ticket -->
<!-- 											Co-ordinator</option> -->
<!-- 										<option value="User">User</option> -->
												<option value="Sales_Initiator">Sales Initiator</option>
												<option value="MD">MD</option>
												<option value="Sales_Manager">Sales Manager</option>
												<option value="Account_Manager">Account Manager</option>
												<option value="Collection_Manager">Collection Manager</option>
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

<br>
	<hr
											style="margin-top: 5px; margin-bottom: 5px; border-top: 1px solid #c1c1c1;">
										<div class="row">
											<div class="col-md-12" style="text-align: center">
												<label class="control-label" style="font-size: large;">Set Scope</label>
											</div>
										</div>
										<div class="row">
										
										<div class="col-md-4" >
												<div class="form-group">
													<label for="settings">Home</label>
													<div id="settings1">
														<select class="form-control setscopeDashboard" tabindex="9"
															id="home" name="home" multiple="multiple" style="max-height: 200px; overflow-y: auto;">
															
															<option value="Home">Home</option>
															
															<option value="Registration_FORM_SI">Registration Form SI</option>
															<option value="LoginMaster">Login Master</option>
															<option value="Purchase_Order_SI">Purchase Order SI</option>
															<option value="Commercial_Proposal_SI">Proposal SI</option>
															<option value="Manual_Commercial_Proposal_SI">Manual Proposal SI</option>
															<option value="Manual_Commercial_Proposal_SM">Manual Proposal SM</option>
															<option value="Manual_Commercial_Proposal_MD">Manual Proposal MD</option>
															<option value="Revise_Commercial_Proposal_SI">Revise Proposal SI</option>
															
															<option value="Commercial_Proposal_SM">Proposal SM</option>
																<option value="Commercial_Proposal_License">License Agreement</option>
															<option value="Proposal_License_SM">License Agreement SM</option>
																<option value="Proposal_License_AM">License Agreement AM</option>
																<option value="Proposal_License_CM">License Agreement CM</option>
																<option value="Proposal_License_BH">License Agreement BH</option>
																<option value="Proposal_License_MD">License Agreement MD</option>
															<option value="Revise_Commercial_Proposal_SM">Revise Proposal SM</option>
															<option value="Purchase_Order_SM">Purchase Order SM</option>
															
															<option value="Registration_FORM_CM">Registration Form CM</option>
															<option value="Purchase_Order_CM">Purchase Order CM</option>

															<option value="RF_MD">RF MD</option>
															<option value="PurchaseOrder_MD">Purchase Order MD</option>
															<option value="VeloxProposal_MD">Velox Proposal MD</option>
															<option value="Revise_Proposal_MD">Revise Proposal MD</option>
															
															<option value="PMS">PMS</option>
															<option value="Requirement_Documents">Requirement Documents</option>
															<option value="FORM3">FORM3</option>
															<option value="Tracking">Tracker</option>
															<option value="Project_Kick_Meeting_Approval">Project Kick of Meeting Approval</option>
															<option value="Project_Kick_Of_Meeting">Project Kick Off Meeting</option>
															<option value="ScheduleMeetings">Schedule Meetings</option>
															<option value="Understanding_Documents">Understanding Documents</option>
															<option value="Revise_Manual_Commercial_Proposal_SI">Revise Manual Commercial Proposal By SI</option>
															<option value="Revise_Manual_Proposal_MD">Revise Manual Proposal By MD</option>
															<option value="Activitydetails">Activity Details</option>
															<option value="Team_Master">Team Master</option>
															<option value="Assign_RFP_Task">Assign RFP Task</option>
															
														</select>
													</div>
												</div>
											</div>
											
											<div class="col-md-4">
												<div class="form-group">
													<label for="settings">View User List</label>
													<div id="settings1">
														<select class="form-control setscopeDashboard" tabindex="9"
															id="ViewUserList" name="ViewUserList" multiple="multiple">
															<option value="View_User_lIST">View User List</option>
														</select>
													</div>
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label for="masters">Master</label>
													<div id="master1">
														<select class="form-control setscopeDashboard" tabindex="9"
															id="masters" name="masters" multiple="multiple">
															<option value="LoginMaster">LoginMaster</option>
															<option value="CustomerMaster">Customer Master</option>
															<option value="DepartmentMaster">Department Master</option>
															<option value="ResponsibilityMaster">Responsibility Master</option>
															<option value="ProductSuitMaster">Product Suit Master</option>
															<option value="SecurityToolMaster">Security Tool Master</option>
															<option value="UnitMaster">Unit Master</option>
															<option value="ProductMaster">Product Master</option>
															<option value="PriceMaster">Price Master</option>
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
										
							</div> 
						
							
						

							<div class="row">
								<div style="margin-top: 15px; display: none;" class="col-md-6"
									id="updategroupCatDiv1">
									<label for="updatecategoryMulti">Category </label>
									<div class="form-group" id="updatecategoryDiv">
										<select id="updatecategoryMulti" tabindex="1"
											class="form-control" data-toogle="tooltip"
											name="updatecategoryMulti" multiple="multiple">
										</select>
									</div>


								</div>
								<div style="margin-top: 15px; display: none;" class="col-md-6"
									id="updategroupCatDiv2">
									<label for="updategroupMulti">Group :</label>
									<div class="form-group" id="updategroupDiv">
										<select id="updategroupMulti" tabindex="1"
											class="form-control" data-toogle="tooltip"
											name="updategroupMulti" multiple="multiple">



										</select>
									</div>
								</div>

							</div>



<br>
							<!--  SERVICE REQUEST UPDATE CODE -->
							<label  style="display: none;" id="servicerequestcheckboxupdate">Service
											Request scope</label>
							<div id="parentsservicerequest" class='card' style="display: none">
							<div class="card-body">
								<div class="row">

									<div class="col-md-5" style="margin-top: 15px;"
										id="servicerequestcheckupdate">

										 <!-- <input type="checkbox"
											id="servicerequestcheckboxupdate"
											class="servicerequestcheckboxupdate"> -->

									</div>
								</div>
								<div class="row">
									<div class="col-md-1"></div>
									<div id="visibilitycheckupdate" class="col-md-5">


										<label for="visibilityupdate">Visibility </label> <select
											id="visibilityupdate" class="form-control" tabindex="8"
											data-toogle="tooltip" name="visibilityupdate">
											<option value="">-- Please Select --</option>
											<option value="Show ServiceRequest">Show Service
												Request</option>
											<option value="Show All">Show All</option>
										</select>
									</div>
									<div class="col-md-5" id="groupCatDiv2serupdate">
										<label for="groupMultiupdate">Group </label>
										<div class="form-group" id="groupDivserupdate">
											<select id="groupMultiserupdate" tabindex="1"
												class="form-control" data-toogle="tooltip"
												name="groupMultiserupdate" multiple="multiple">



											</select>
										</div>


									</div>
									<div class="col-md-1"></div>
								</div>







</div>
							</div>

							<br>

							<div class="row">


								<div class="col-md-5"></div>
							</div>


							<div class="row" id="updateloginScopeDive" style="display: none;">

								<!-- <div class="col-md-1"> Login Scope</div> -->
								<div class="card col-md-12">
									<div class="card-header">
										<strong>Login Scope</strong>
									</div>
									<div class="card-body">
										<button type="button" tabindex="15"
											class="btn btn-sm btn-primary " id="updateAddrow"
											name="updateAddrow" style="margin-left: 16px;">Add
											Row</button>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="button" tabindex="15"
											class="btn btn-sm btn-danger " id="updatedeleteRow"
											name="updatedeleteRow">Delete Row</button>
										<table id="updateperifheralTable" class="table order-list1">
											<thead>
												<tr>
													<td><strong>Company</strong></td>
													<td><strong>Branch</strong></td>
													<td><strong>Department</strong></td>
													<!-- <td>Action</td> -->
												</tr>
											</thead>
											<tbody>

												<!-- <td class="form-group adjust"><select class="form-control " tabindex="6" data-toogle="tooltip"  onchange="getUpdateBranchDetails('0')" name="company[]" id="company0"></select></td>
                                                   <td class="form-group adjust"><div class="form-group" id="updatetableBranchDiv0"><select class="form-control customMulti" tabindex="6" data-toogle="tooltip" multiple="multiple" onchange="getUpdateDepart('0')" name="updatetableBranch[]" id="updatetableBranch0"></select></div></td>
													<td class="form-group adjust"><div class="form-group" id="updateTableDepartmentDiv0"><select class="form-control customMulti" tabindex="6" data-toogle="tooltip"  multiple="multiple" name="updateTableDepartment[]" id="updateTableDepartment0"></select></div></td>
													 -->
											</tbody>
											<!-- <tfoot>
														<tr>
															<td colspan="5" style="text-align: left;"><input
																type="button" class="btn btn-block btn-secondary"
																id="updateAddrow" value="Add Row" /></td>
														</tr>
														<tr>
														</tr>
													</tfoot> -->
										</table>

									</div>
								</div>

							</div>




							<div class="row">
								<input type="hidden" id="sr_no">
								<div style="margin-top: 15px;" class="col-md-12">
									<center>

										<button type="submit" class="btn btn-primary m-t-10"
											tabindex="25" id="updateengg-btn" name="update">Update</button>


									</center>
								</div>
							</div>
							
							<br>

						</div>

						<div class="col-md-2"></div>
					</div>

					<!--</form>-->



				</div>

			</div>

			<!-- /.modal-content -->
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
	<%-- <script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery/dist/jquery.min.js"></script>
		

	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery-ui/jquery-ui.min.js"></script> --%>

	<script
		src="<%=request.getContextPath()%>/static/js/bootstrap-multiselect-master/dist/js/bootstrap-multiselect.js"></script>
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
		src="<%=request.getContextPath()%>/static/custom/View_User_List.js"
		></script>

</body>

</html>


