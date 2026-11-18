<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>View All Problem Tickets</title>
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
<!-- <link rel="stylesheet" -->
<%-- 	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/icheck-bootstrap/icheck-bootstrap.min.css"> --%>
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
<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}
.card-modal {
	border: 0px !important;
}
.modal label{
margin-bottom: 0rem !important;
margin-top: .5rem !important;
}
.modal {
overflow-y:auto !important;
}

</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
	<jsp:include page="/WEB-INF/views/dashboardheaderTP.jsp"></jsp:include>

 	<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include> 
		<div class="content-wrapper">

			<section class="content-header">

				<div class="card card-secondary"
					style="margin-left: 15px; margin-right: 15px">
					<div class="card-header">View All Problem Tickets</div>
					<div class="card-body">
						<div class="row" id="preLoader"><div class="col-md-12 text-center font-weight-bold h6">Loading <i class="fas fa-sync fa-spin"></i></div></div>
						
                            <table class="table table1 table-striped d-none"  id="Listing_Copy" >
								<thead>
									<tr>
										<th>View Ticket</th>
										<th>Close Ticket</th>
										
										<th>Ticket ID</th>
										<th>Status</th>
										<th>Priority</th>
										<th>Severity</th>
										<th>Subject</th>
										<th>Company</th>
										<th>Branch</th>
										<th>Department</th>
										<th>Category</th>
										<th>Sub-Category 1</th>
										<th>Sub-Category 2</th>
										<th>Assigned By</th>
										<th>Assigned By Full Name</th>
										<th>Assign Engineer/Group</th>
										<th>Assign Engineer Full Name</th>
										<th>Resolved Engineer</th>
										<th>Resolved Engineer Full Name</th>
										<th>Raise Date & Time</th>
										<th>Assign Date & Time</th>
										<th>RCA Date & Time</th>
										<th>Fix In Process Date & Time</th>
										<th>Resolve Date & Time</th>
										<th>Close Date & Time</th>
									</tr>
								</thead>
								<tbody>

								</tbody>

							</table>
						</div>
					</div>
			
			</section>

		</div>

			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modelviewPrimary" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">View Problem Ticket</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
						<div class="card card-modal card-primary card-outline card-outline-tabs">
              <div class="card-header p-0 border-bottom-0">
                <ul class="nav nav-tabs" id="custom-tabs-four-tab" role="tablist">
                 <li class="nav-item">
                    <a class="nav-link active" id="custom-tabs-four-home-tab" data-toggle="pill" href="#custom-tabs-four-home" aria-controls="custom-tabs-four-home" aria-selected="true">General Details</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="custom-tabs-four-notes-tab" data-toggle="pill" href="#custom-tabs-four-notes" aria-controls="custom-tabs-four-notes" aria-selected="false">Ticket Notes</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="custom-tabs-four-profile-tab" data-toggle="pill" href="#custom-tabs-four-profile" role="tab" aria-controls="custom-tabs-four-profile" aria-selected="false">Problem Ticket Activity Log</a>
                  </li>
                 </ul>
              </div>
              <div class="card-body">
                <div class="tab-content" id="custom-tabs-four-tabContent">
                 
				<div class="tab-pane fade show active" id="custom-tabs-four-home" role="tabpanel" aria-labelledby="custom-tabs-four-home-tab">
                    <div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-11">
									<span id="Label1"
										style="color: crimson; font-family: Calibri; font-size: large;">Requester/User
										Details</span>
								</div>

							</div>

							<div class="row">
								<div class="col-md-4">
									<label for="nameupdateUD1">Name:</label> <input type="text"
										id="nameupdateUD" name="nameupdateUD" class="form-control"
										data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-4">
									<label for="companyupdateUD1">Company:</label> <input
										type="text" id="companyupdateUD" name="companyupdateUD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-4">
									<label for="siteupdateUD1">Branch:</label> <input type="text"
										id="siteupdateUD" name="siteupdateUD" class="form-control"
										data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>

							</div>
							<div class="row">
							<div class="col-md-4">
									<label for="departmentupdateUD1">Department:</label> <input type="text"
										id="departmentupdateUD" name="departmentupdateUD" class="form-control"
										data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-4">
									<label for="Sub-Department">Sub-Department</label> <input type="text"
										id="Sub-Department" name="Sub-Department" class="form-control"
										data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-4">
									<label for="location">Location</label> <input type="text"
										id="location" name="location" class="form-control"
										data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								
								
								
							</div>
								<div class="row">
								<div class="col-md-6">
									<label for="phoneupdateUD1">Phone No:</label> <input type="text"
										id="phoneupdateUD" name="phoneupdateUD" class="form-control"
										data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-6">
									<label for="emailupdateUD1">Email ID:</label> <input type="text"
										id="emailupdateUD" name="emailupdateUD" class="form-control"
										data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								
								</div>
							<hr>
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-11">
									<span id="Label1"
										style="color: crimson; font-family: Calibri; font-size: large;">Ticket
										Details</span>
								</div>

							</div>

							<div class="row">
							<div class="col-md-3">
									<label for="problemticketidupdateTD1">Problem Ticket ID:</label> <input
										type="text" id="problemticketidupdateTD" name="problemticketidupdateTD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-3">
									<label for="statusupdateTD1">Status:</label> <input type="text"
										id="statusupdateTD" name="statusupdateTD" class="form-control"
										data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-2">
									<label for="RequestModeupdateTD1">Request Mode:</label> <input
												type="text" id="RequestModeupdateTD"
												name="RequestModeupdateTD" class="form-control"
												data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-2">
									<label for="priorityupdateTD1"> Priority:</label> <input
												type="text" id="priorityupdateTD" name="priorityupdateTD"
												class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-2">
									<label for="priorityupdateTD1"> Severity:</label> <input
												type="text" id="SeverityupdateTD" name="SeverityupdateTD"
												class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								
							</div>
							
							<div class="row">
								<div class="col-md-3">
									<label for="raisedateupdateTD1">Raised Date:</label> <input
										type="text" id="raisedateupdateTD" name="raisedateupdateTD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-3">
									<label for="assigndateupdateTD1">Assigned Date:</label> <input
										type="text" id="assigndateupdateTD" name="assigndateupdateTD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">	
								</div>
								<div class="col-md-3">
									<label for="rcadateupdateTD1">RCA Date:</label> <input
										type="text" id="rcadateupdateTD" name="rcadateupdateTD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">	
								</div>
								<div class="col-md-3">
									<label for="fixinprocessdateupdateTD1">Fix In Process Date:</label> <input
										type="text" id="fixinprocessdateupdateTD" name="fixinprocessdateupdateTD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">	
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<label for="resolvedateupdateTD1">Resolve Date:</label> <input
										type="text" id="resolvedateupdateTD" name="resolvedateupdateTD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-3">
									<label for="closedateupdateTD1">Close Date:</label> <input
										type="text" id="closedateupdateTD" name="closedateupdateTD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">	
								</div>
								<div class="col-md-3">
									<label for="closebyupdateTD1">Close By:</label> <input
										type="text" id="closebyupdateTD" name="closebyupdateTD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">	
								</div>
								<div class="col-md-3">
									<label for="resolutioncodeupdateTD1">Resolution Code:</label> <input
										type="text" id="resolutioncodeupdateTD" name="resolutioncodeupdateTD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">	
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-4">
									<label for="problemcategoryupdateTD1">Category:</label> <input
										type="text" id="problemcategoryupdateTD" name="problemcategoryupdateTD"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-4">
									<label for="problemsubcat11">Sub-Category 1:</label> <input
										type="text" id="problemsubcat1" name="problemsubcat1"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								<div class="col-md-4">
									<label for="problemsubcat11">Sub-Category 2:</label> <input
										type="text" id="problemsubcat2" name="problemsubcat2"
										class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>
								

							</div>
							<div class="row">
								<div class="col-md-12">
									<label for="subjectupdateTD1">Subject:</label>
									<input type="text" id="subjectupdateTD" name="subjectupdateTD" 
									class="form-control" data-toogle="tooltip" readonly="Yes" placeholder="-">
								</div>

							</div>
							<div class="row">
								<div class="col-md-12">
									<label for="descriptionupdateTD1">Description:</label>
									<textarea id="descriptionupdateTD" rows="4" cols="50"
										name="descriptionupdateTD" class="form-control"
										data-toogle="tooltip" readonly="Yes" placeholder="-"></textarea>
								</div>
								
							</div>
							<hr>
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-11">
									<span id="Label1"
										style="color: crimson; font-family: Calibri; font-size: large;">Enclosures</span>
								</div>

							</div>
							<div id="hidedownload">
								<div class="row">
									<div class="col-md-10">
										
										<label>Attachment (Uploaded by User):&nbsp;&nbsp;
										<input type="hidden" id="empPic">&nbsp;&nbsp;
										<input type="button" id="downHide" value="Download" onclick="downFile()">
										</label>

										<input type="hidden" id="filename" name="filename">
									</div>
								</div>
							</div>
							<div id="nofileattach">
								<div class="row">

									<div class="col-md-4">
										<span style="color: black;">No File Attached</span>
									</div>

								</div>
							</div>

							<hr>
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-11">
									<span id="Label1"
										style="color: crimson; font-family: Calibri; font-size: large;">Attached Incidents</span>
								</div>

							</div>
							<div class="card card-primary" id="IncidentsAttachedDiv" style="display:none">
<!--                                     <div class="card-header">Incidents</div> -->
                                    <div class="card-body">
                
                            <table class="table table1 table-striped"  id="Listing_Copy_Incidents" >
                                <thead>
                                    <tr>
										 <th>View Ticket</th>
                                        <th>Ticket ID</th>  
                                        <th>Raise Date</th>
                                         <th>Subject</th> 
                                        <th>Raised By</th>
                                        <th>Priority</th>
                                        <th>Severity</th>
                                        <th>Status</th>
                                        <th>Category</th>
                                     </tr>
                                </thead>
                                <tbody>

                                </tbody>

                            </table>
                              </div>
                                     </div>
                               <span style="color: black;" id="NoIncidentsAttachedDiv" style="display:none;font-weight: bold;">No Incidents Attached.</span>      
							<br>
							
                  </div>
                  
                <div class="tab-pane fade" id="custom-tabs-four-notes" role="tabpanel" aria-labelledby="custom-tabs-four-notes-tab">
                    <div class="row">
									<div class="col-md-12">
										<label for="cname">Cause Notes:</label>
										<textarea id="causenotesRCA" tabindex="17" placeholder="-" 
											class="form-control" data-toogle="tooltip" name="causenotesRCA" 
											rows="4" cols="50" readonly></textarea>
									</div>
									</div>
								<div class="row">
									<div class="col-md-12">
										<label for="cname">Fix Notes:</label>
										<textarea id="fixnotesRCA" tabindex="17" placeholder="-" 
											class="form-control" data-toogle="tooltip" name="fixnotesRCA" 
											rows="4" cols="50" readonly></textarea>
									</div>
									</div>
									<div class="row">
									<div class="col-md-12">
										<label for="cname">Workaround:</label>
										<textarea id="workaroundnotesRCA" tabindex="17" placeholder="-" 
											class="form-control" data-toogle="tooltip" name="workaroundnotesRCA" 
											rows="4" cols="50" readonly></textarea>
									</div>
									</div>
									<div class="row">
									<div class="col-md-12">
										<label for="cname">Resolve Notes:</label>
										<textarea id="resolvenotesRCA" tabindex="17" placeholder="-" 
											class="form-control" data-toogle="tooltip" name="resolvenotesRCA" 
											rows="4" cols="50" readonly></textarea>
									</div>
									</div>
									<div class="row">
									<div class="col-md-12">
										<label for="cname">Close Notes:</label>
										<textarea id="closenotesRCA" tabindex="17" placeholder="-" 
											class="form-control" data-toogle="tooltip" name="closenotesRCA" 
											rows="4" cols="50" readonly></textarea>
									</div>
									</div>
									<br>
                  </div>
				
				<div class="tab-pane fade" id="custom-tabs-four-profile" role="tabpanel" aria-labelledby="custom-tabs-four-profile-tab">
                    <div class="row">
									<div class="col-md-12 text-center">
										<span class="font-weight-bold">Activity Log For Ticket- <span id="T_ID"></span></span>
										
									</div>
									</div>
									<div class="row">
									<div class="col-md-12">
									<div class="card-body" id="MSG1234"></div>
									</div>
									</div>
								
                  </div>
						
				
				</div>
						<div class="row">
								<div class="col-md-12 text-center">
								<input type="button" class="btn btn-primary m-t-10" id="close-btn-primary" name="close-btn-primary" value="Close">
									</div>
							</div>
              </div>
            </div>
						</div>
					</div>
				</div>
			</div>
	
<div class="modal fade bs-example-modal-lg modal-default1111" id="modelviewSecondary" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
      
                     
                                <div class="modal-header bg-secondary" ">
                                     <h4 class="modal-title" id="myLargeModalLabel">View Ticket</h4>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close" style="margin-right:10px">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                   

                </div>
                <div class="modal-body">
                          
                    <div class="card card-modal card-primary card-outline card-outline-tabs">
                 <div class="card-header p-0 border-bottom-0">
                <ul class="nav nav-tabs" id="custom-tabs-two-tab" role="tablist-two">
                 <li class="nav-item">
                    <a class="nav-link active" id="custom-tabs-two-general-tab" data-toggle="pill" href="#custom-tabs-two-general" role="tab-two" aria-controls="custom-tabs-two-general" aria-selected="true">General Details</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="custom-tabs-two-activity-tab" data-toggle="pill" href="#custom-tabs-two-activity" role="tab-two" aria-controls="custom-tabs-two-activity" aria-selected="false">Ticket Activity Log</a>
                  </li>
                 </ul>
              </div>    
              <div class="card-body">
                <div class="tab-content" id="custom-tabs-two-tabContent-Two">
                  <div class="tab-pane fade show active" id="custom-tabs-two-general" role="tabpanel-two" aria-labelledby="custom-tabs-two-general-tab">     
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-11" >
                        <span id="Label1" style="color:crimson;font-family:Calibri;font-size:large; ">Requester/User Details</span>    
                        </div>
                            
                    </div>
                    
                            <div class="row">
                                <div class="col-md-4">
                                        <label for="nameupdateUD1" >Name:</label>
                                        <input type="text" id="nameupdateUDsecondary" name="nameupdateUDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="companyupdateUD1" >Company:</label>
                                        <input type="text" id="companyupdateUDsecondary" name="companyupdateUDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="siteupdateUD1" >Branch:</label>
                                        <input type="text" id="siteupdateUDsecondary" name="siteupdateUDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                        <label for="deptupdateUD1" >Department:</label>
                                        <input type="text" id="deptupdateUDsecondary" name="deptupdateUDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="subdeptupdateUD1" >Sub-Department:</label>
                                        <input type="text" id="subdeptupdateUDsecondary" name="subdeptupdateUDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="locationupdateUD1" >Location:</label>
                                        <input type="text" id="locationupdateUDsecondary" name="locationupdateUDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

                            </div>
                     <div class="row">
                                <div class="col-md-4">
                                        <label for="phoneupdateUD1" >Phone No</label>
                                        <input type="text" id="phoneupdateUDsecondary" name="phoneupdateUDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="emailupdateUD1" >Email ID</label>
                                        <input type="text" id="emailupdateUDsecondary" name="emailupdateUDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                   
                            </div>
                    <hr>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-11" >
                        <span id="Label1" style="color:crimson;font-family:Calibri;font-size:large; ">Ticket Details</span>    
                        </div>
                            
                    </div>
                    		<div class="row">
                     			<div class="col-md-4">
                                        <label for="ticketidupdateTD1" >Ticket ID </label>
                                        <input type="text" id="ticketidupdateTDsecondary" name="ticketidupdateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="statusupdateTD1" >Status</label>
                                        <input type="text" id="statusupdateTDsecondary" name="statusupdateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                <div class="col-md-4">
                                        <label for="raisedateupdateTD1" >Raised Date</label>
                                        <input type="text" id="raisedateupdateTDsecondary" name="raisedateupdateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                 </div>
                                 
                            <div class="row">
                                <div class="col-md-4">
                                        <label for="categoryupdateTD1" >Category:</label>
                                        <input type="text" id="categoryupdateTDsecondary" name="categoryupdateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="subcat1updateTD1" >Sub-Category1:</label>
                                        <input type="text" id="subcat1updateTDsecondary" name="subcat1updateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                       <label for="subcat2updateTD1" >Sub-Category2:</label>
                                        <input type="text" id="subcat2updateTDsecondary" name="subcat2updateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

                            </div>
                     
                      <div class="row">
                                <div class="col-md-8">
                                <div class="row">
                                <div class="col-md-12">
                                 <label for="subjectupdateTD1" >Subject:</label>
                                        <input type="text" id="subjectupdateTDsecondary" name="subjectupdateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                  </div>
                                </div>
                                	<div class="row">
                                	<div class="col-md-12">
                                        <label for="descriptionupdateTD1" >Description</label>
                                        <textarea id="descriptionupdateTDsecondary" rows="4" cols="50" name="descriptionupdateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes"></textarea>
                                        </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                 <div class="row">
                                     <div class="col-md-12">
                                        <label for="RequestModeupdateTD1" > Request Mode</label>
                                        <input type="text"  id="RequestModeupdateTDsecondary" name="RequestModeupdateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                        </div>
                                 
                                        <div class="col-md-12">
                                        <label for="priorityupdateTD1" > Priority</label>
                                        <input type="text"  id="priorityupdateTDsecondary" name="priorityupdateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                        </div>
                                          <div class="col-md-12">
                                        <label for="priorityupdateTD1" > Severity</label>
                                        <input type="text"  id="SeverityupdateTDsecondary" name="SeverityupdateTDsecondary" class="form-control" data-toogle="tooltip" readonly="Yes">
                                        </div>
                                      

                                        </div>
                                    </div>
                              
                        </div>
                        <hr>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-11" >
                        <span id="Label1" style="color:crimson;font-family:Calibri;font-size:large; ">Enclosures</span>    
                        </div>
                            
                    </div>
                   <div id="hidedownloadsecondary">
                            <div class="row">
                               <div class="col-md-10">

                                        <label>Attachment (Uploaded by User):&nbsp;&nbsp;
                                        <input type="hidden" id="empPicsecondary">&nbsp;&nbsp;
                                        <input type="button" id="downHidesecondary" value="Download" onclick="downFileSecondary()">
                                        </label>
                                       <input type="hidden" id="filenamesecondary" name="filenamesecondary">   
                                    </div></div></div>
                                    
                                    <div id="nofileattachsecondary">
                            		<div class="row">
                              	<div class="col-md-4">
                                      <span style="color: black;">No File Attached</span> 
                                    </div>
                                
                                </div>
                                        </div>

						</div>
				  <div class="tab-pane fade" id="custom-tabs-two-activity" role="tabpanel-two" aria-labelledby="custom-tabs-two-activity-tab">
                    <div class="row">
									<div class="col-md-12 text-center">
										<span class="font-weight-bold">Activity Log For Ticket- <span id="T_IDsecondary"></span></span>
										
									</div>
									</div>
									<div class="row">
									<div class="col-md-12">
									<div class="card-body" id="MSG1234secondary"></div>
									</div>
									</div>
								
                  </div>
						</div>
						</div>
						<div class="modal-footer justify-content-center">
              <input type="button" class="btn btn-primary m-t-10" id="close-btn-secondary" name="close-btn-secondary" value="Close">
              
            </div>
                   </div>
                   
                   
                        </div>

                        <div class="col-md-2"></div>
                    </div>

                    <!--</form>-->



                </div>

            </div>
  
  <div class="modal fade bs-example-modal-lg modal-default1111" id="modelclose" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
      				<div class="modal-header bg-secondary">
                                     <h4 class="modal-title" id="myLargeModalLabel">Close Problem Ticket</h4>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close" style="margin-right:10px">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                 </div>
                <div class="modal-body">
                    
                  	<div class="row">
                        	<div class="col-md-1"></div>
                                    <div class="col-md-10">
                                    <label for="nameupdateUD_secondary1" >Problem Ticket ID:</label>
                                        <input type="text" id="closetid" name="closetid" class="form-control" data-toogle="tooltip" readonly>
                                       
                                        <label for="closereason1" >Enter Your Reason</label>
                                        <textarea  id="closereason" name="closereason" class="form-control" placeholder="Please Enter Your Close Reason " data-toogle="tooltip" rows="4" cols="50" required></textarea>
                                         <input type="hidden" id="hiddenID">
                                    </div>
                                    <div class="col-md-1"></div>
                            </div>
                   		<br>
                       <div class="row">
                        <div class="col-md-12 text-center">
                           <input type="button" class="btn btn-primary m-t-10" id="ticketclose-btn" name="ticketclose-btn" value="Close Ticket">
                        </div>
						</div>
                   </div>
				<div class="col-md-2">
				</div>
				 </div>
				</div>
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

	<script src="<%=request.getContextPath()%>/static/custom/adduser.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/custom/ViewAllProblemTickets.js"></script>
</body>

</html>


