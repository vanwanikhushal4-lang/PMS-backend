<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page isELIgnored="false"%>
<html>
<head>
   
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>My Resolved Tickets</title>
   <link rel="icon" href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->
  
<!--   <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap/dist/css/bootstrap.min.css">-->
  <!-- Tempusdominus Bbootstrap 4 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <!--<link rel="stylesheet" href="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jqvmap.min.css">-->
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
   <!-- Datatables -->
   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
<!-- <script src="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css"></script>-->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
  <!-- bootstrap datepicker -->
<!--  <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">-->
<!-- Sweetalert 2 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">

  <!-- summernote -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
  <!-- Google Font: Source Sans Pro -->
  <!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
  <style type="text/css">
  .card{
  border: 1px solid rgb(0, 123, 255) !important;
  }
  </style>
   
</head>
  <body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
<jsp:include page="/WEB-INF/views/dashboardheaderEngg.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>  
                <div class="content-wrapper">

                      <section class="content-header">
                      
                <div class="card card-secondary" style="margin-left: 15px; margin-right: 15px">
                                    <div class="card-header">My Resolved Tickets</div>
                                    <div class="card-body">
                <div class="row" id="preLoader"><div class="col-md-12 text-center font-weight-bold h6">Loading <i class="fas fa-sync fa-spin"></i></div></div>
						
                            <table class="table table1 table-striped d-none"  id="Listing_Copy" >
                                <thead>
                                    <tr>
                                          <th>View Ticket</th>
                                        <th>Close Ticket</th>
                                        <th>Re-Open Ticket</th>
                                        
                                        <th>Ticket ID</th> 
                                        <th>Status</th>
                                        <th>Priority</th>
                                        <th>Severity</th>
                                        <th>Subject</th>
                                        <th>Company</th>
                                        <th>Branch</th>
                                        <th>Department</th>
                                        <th>Category</th>
                                        <th>Sub-Category1</th>
                                        <th>Sub-Category2</th>
                                        <th>Raised By</th>
                                        <th>Raised By FullName</th>
                                        <th>Ticket Assigned By</th>
                                       <th>Assigned By Full Name</th>
                                       
                                            <th>Resolved By</th>
                                             <th>Resolved By Full Name</th>
                                        <th>Raised&nbsp;Date & Time</th>
                                        <th>Assigned&nbsp;Date & Time</th>
                                        <th>Resolved&nbsp;Date & Time</th>
                                       

                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>

                            </table>
                      
                                         </div>
                                     </div>
                 </section>
                 
                 </div>
                
            <div class="row">
			

    <div class="modal fade bs-example-modal-lg modal-default1111"
				id="modelview" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">


						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">View Ticket</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>


						</div>
						<div class="modal-body">
							<div
								class="card card-modal card-primary card-outline card-outline-tabs">
								<div class="card-header p-0 border-bottom-0">
									<ul class="nav nav-tabs" id="custom-tabs-four-tab"
										role="tablist">
										<li class="nav-item"><a class="nav-link active"
											id="custom-tabs-four-home-tab" data-toggle="pill"
											href="#custom-tabs-four-home" role="tab"
											aria-controls="custom-tabs-four-home" aria-selected="true">General
												Details</a></li>
										<li class="nav-item"><a class="nav-link"
											id="custom-tabs-four-profile-tab" data-toggle="pill"
											href="#custom-tabs-four-profile" role="tab"
											aria-controls="custom-tabs-four-profile"
											aria-selected="false">Ticket Activity Log</a></li>
									</ul>
								</div>
								<div class="card-body">
									<div class="tab-content" id="custom-tabs-four-tabContent">
										<div class="tab-pane fade show active"
											id="custom-tabs-four-home" role="tabpanel"
											aria-labelledby="custom-tabs-four-home-tab">
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
													<label for="nameupdateUD1">Name:</label> <input
														type="text" id="nameupdateUD" name="nameupdateUD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>
												<div class="col-md-4">
													<label for="companyupdateUD1">Company:</label> <input
														type="text" id="companyupdateUD" name="companyupdateUD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>
												<div class="col-md-4">
													<label for="siteupdateUD1">Branch:</label> <input
														type="text" id="siteupdateUD" name="siteupdateUD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>

											</div>
											<div class="row">
												<div class="col-md-4">
													<label for="deptupdateUD1">Department:</label> <input
														type="text" id="deptupdateUD" name="deptupdateUD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>
												<div class="col-md-4">
													<label for="subdeptupdateUD1">Sub-Department:</label> <input
														type="text" id="subdeptupdateUD" name="subdeptupdateUD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>
												<div class="col-md-4">
													<label for="locationupdateUD1">Location:</label> <input
														type="text" id="locationupdateUD" name="locationupdateUD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>

											</div>
											<div class="row">
												<div class="col-md-4">
													<label for="phoneupdateUD1">Phone No</label> <input
														type="text" id="phoneupdateUD" name="phoneupdateUD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>
												<div class="col-md-4">
													<label for="emailupdateUD1">Email ID</label> <input
														type="text" id="emailupdateUD" name="emailupdateUD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
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
												<div class="col-md-4">
													<label for="categoryupdateTD1">Category:</label> <input
														type="text" id="categoryupdateTD" name="categoryupdateTD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>
												<div class="col-md-4">
													<label for="subcat1updateTD1">Sub-Category1:</label> <input
														type="text" id="subcat1updateTD" name="subcat1updateTD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>
												<div class="col-md-4">
													<label for="subcat2updateTD1">Sub-Category2:</label> <input
														type="text" id="subcat2updateTD" name="subcat2updateTD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>

											</div>
											<div class="row">
												<div class="col-md-4">
													<label for="ticketidupdateTD1">Ticket ID </label> <input
														type="text" id="ticketidupdateTD" name="ticketidupdateTD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>
												<div class="col-md-4">
													<label for="statusupdateTD1">Status</label> <input
														type="text" id="statusupdateTD" name="statusupdateTD"
														class="form-control" data-toogle="tooltip" readonly="Yes">
												</div>
												<div class="col-md-4">
													<label for="raisedateupdateTD1">Raised Date</label> <input
														type="text" id="raisedateupdateTD"
														name="raisedateupdateTD" class="form-control"
														data-toogle="tooltip" readonly="Yes">
												</div>
											</div>
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="col-md-12">
															<label for="subjectupdateTD1">Subject:</label> <input
																type="text" id="subjectupdateTD" name="subjectupdateTD"
																class="form-control" data-toogle="tooltip"
																readonly="Yes">
														</div>
													</div>
													<div class="row">
														<div class="col-md-12">
															<label for="descriptionupdateTD1">Description</label>
															<textarea id="descriptionupdateTD" rows="4" cols="50"
																name="descriptionupdateTD" class="form-control"
																data-toogle="tooltip" readonly="Yes"></textarea>
														</div>
													</div>
												</div>
												<div class="col-md-4">
													<div class="row">
													<div class="col-md-12">
															<label for="RequestModeupdateTD1"> Request Mode</label>
															<input type="text" id="RequestModeupdateTD"
																name="RequestModeupdateTD" class="form-control"
																data-toogle="tooltip" readonly="Yes">
														</div>
														<div class="col-md-12">
															<label for="priorityupdateTD1"> Priority</label> <input
																type="text" id="priorityupdateTD"
																name="priorityupdateTD" class="form-control"
																data-toogle="tooltip" readonly="Yes">
														</div>
														<div class="col-md-12">
															<label for="severityupdateTD1"> Severity</label> <input
																type="text" id="severityupdateTD"
																name="severityupdateTD" class="form-control"
																data-toogle="tooltip" readonly="Yes">
														</div>
														<!--                                         <div class="col-md-12"> -->
														<!--                                         <label></label> -->
														<!--                                         <input type="button" class="btn btn-block btn-secondary" value="View Ticket Activity"> -->
														<!--                                         </div>    -->
													</div>
												</div>

											</div>
											<hr>
											<hr>
							   <input type="hidden" id="assetcheck" name="assetcheck">
                     <%  String Company= session.getAttribute("companyname").toString();%>
									<%if(Company.equals("3i Infotech") ) { %>

												   <div id="HideAssetdata"  style="display: none;">
<!--                                               style="display: none;" -->
                                            <br>
                                            <strong>Selected Asset Details :</strong>
                                            <div class="card">
  											<div class="card-body ">
  
                                             <div class="row" >
													<div class="col-md-6">
                                                    <label for="cname">Asset Name:</label>
                                                    <input type="text" id="aname" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="aname">
                                                </div>



												<div class="col-md-6">
                                                    <label for="cname">Asset Tag:</label>
                                                    <input type="text" id="atag" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="atag">
                                                </div>
                                              
												</div>
												<div class="row">

                                                   <div class="col-md-6">
                                                    <label for="cname">Asset Status: </label>
                                                    <input type="text" id="astatus" tabindex="1" readonly="true" class="form-control" data-toogle="tooltip" name="astatus">
                                                </div>
                                                <div class="col-md-6">
                                                    <label for="cname">Category:</label>
                                                    <input type="text" id="acategory" tabindex="6" readonly="true" class="form-control" data-toogle="tooltip" name="acategory">
                                       
												</div>
									</div>
                                                                    <div class="row" >
													<div class="col-md-6">
                                                    <label for="cname">Asset Sub-Category:</label>
                                                    <input type="text" id="asset_sub_categoryview" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="asset_sub_categoryview">
                                                </div>



												<div class="col-md-6">
                                                    <label for="cname">Asset Ip Address:</label>
                                                    <input type="text" id="asset_Ipaddressview" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="asset_Ipaddressview">
                                                </div>
                                              
												</div>
                                            </div>
                                            </div>
                                            </div>
									<%}else{} %>
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
														<!--                                        <label for="attachmentTD1" >Attachment</label>-->
														<!--                                        <input type=text" id="attachmentTD" name="attachmentTD" class="form-control" data-toogle="tooltip" >-->

														<label>Attachment (Uploaded by User):&nbsp;&nbsp;<input
															type="hidden" id="empPic">&nbsp;&nbsp;<input
															type="button" id="downHide" value="Download"
															onclick="downFile()"></label>
														<!--                                         <label>Attachment:&nbsp;&nbsp;<span style="color: green;" id="empPic"></span>&nbsp;&nbsp;<input type="button" id="downHide" value="Download" onclick="downFile()"></label>-->
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

										</div>
										<div class="tab-pane fade" id="custom-tabs-four-profile"
											role="tabpanel"
											aria-labelledby="custom-tabs-four-profile-tab">
											<div class="row">
												<div class="col-md-12 text-center">
													<span class="font-weight-bold">Activity Log For
														Ticket- <span id="T_ID"></span>
													</span>

												</div>
											</div>
											<div class="row">
												<div class="col-md-12">
													<div class="card-body" id="MSG1234"></div>
												</div>
											</div>

										</div>
									</div>
								</div>
								<div class="modal-footer justify-content-center">
									<input type="button" class="btn btn-primary m-t-10"
										id="close-btn" name="close-btn" value="Close">

								</div>
							</div>
						</div>

						<div class="col-md-2"></div>
					</div>

					<!--</form>-->



				</div>

			</div>
    
    
			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modelreopen" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">


						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Re-Open Ticket</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px">
								<span aria-hidden="true">&times;</span>
							</button>


						</div>
						<div class="modal-body">
							<form action="UserReopenResolvedTicket" id="form" name="form" method="post" enctype="multipart/form-data">
							<div class="row">

								<div class="col-md-12 text-center">
									<span id="Label1" style="color: crimson; font-family: Calibri; font-size: large;">Re-Open Ticket only if issue is <b>NOT FIXED.</b> Else <b>Close</b> Ticket.</span>
									</div>

							</div>

							<hr>
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
										id="nameupdateUDreopen" name="nameupdateUDreopen"
										class="form-control" data-toogle="tooltip" readonly>
								</div>
								<div class="col-md-4">
									<label for="companyupdateUD1">Company:</label> <input
										type="text" id="companyupdateUDreopen"
										name="companyupdateUDreopen" class="form-control"
										data-toogle="tooltip" readonly>
								</div>
								<div class="col-md-4">
									<label for="siteupdateUD1">Branch:</label> <input type="text"
										id="siteupdateUDreopen" name="siteupdateUDreopen"
										class="form-control" data-toogle="tooltip" readonly>
								</div>

							</div>
							<div class="row">
                                <div class="col-md-4">
                                        <label for="deptupdateUD1" >Department:</label>
                                        <input type="text" id="deptupdateUDreopen" name="deptupdateUDreopen" class="form-control" data-toogle="tooltip" readonly>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="subdeptupdateUD1" >Sub-Department:</label>
                                        <input type="text" id="subdeptupdateUDreopen" name="subdeptupdateUDreopen" class="form-control" data-toogle="tooltip" readonly>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="locationupdateUD1" >Location:</label>
                                        <input type="text" id="locationupdateUDreopen" name="locationupdateUDreopen" class="form-control" data-toogle="tooltip" readonly>
                                    </div>

                            </div>
							<div class="row">
								<div class="col-md-4">
									<label for="phoneupdateUD1">Contact No:</label> <input
										type="text" id="phoneupdateUDreopen"
										name="phoneupdateUDreopen" class="form-control"
										data-toogle="tooltip" readonly="Yes">
								</div>
								<div class="col-md-4">
									<label for="emailupdateUD1">Email-ID:</label> <input
										type="text" id="emailupdateUDreopen"
										name="emailupdateUDreopen" class="form-control"
										data-toogle="tooltip" readonly="Yes">
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
								<div class="col-md-4">
									<label for="ticketidupdateTD1">Ticket-ID: </label> <input
										type="text" id="ticketidupdateTDreopen"
										name="ticketidupdateTDreopen" class="form-control"
										data-toogle="tooltip" readonly="Yes">
								</div>
								<div class="col-md-4">
									<label for="statusupdateTD1">Status:</label> <input type="text"
										id="statusupdateTDreopen" name="statusupdateTDreopen"
										class="form-control" data-toogle="tooltip" readonly="Yes">
								</div>
								<div class="col-md-4">
									<label for="raisedateupdateTD1">Raise Date:</label> <input
										type="text" id="raisedateupdateTDreopen"
										name="raisedateupdateTDreopen" class="form-control"
										data-toogle="tooltip" readonly>
								</div>
								</div>
							<div class="row">
								<div class="col-md-4">
									<label for="categoryupdateTD1">Category:</label> <input
										type="text" id="categoryupdateTDreopen"
										name="categoryupdateTDreopen" class="form-control"
										data-toogle="tooltip" readonly>
								</div>
								<div class="col-md-4">
									<label for="subcat1updateTD1">Sub-Category1:</label> <input
										type="text" id="subcat1updateTDreopen"
										name="subcat1updateTDreopen" class="form-control"
										data-toogle="tooltip" readonly>
								</div>
								<div class="col-md-4">
									<label for="subcat2updateTD1">Sub-Category2:</label> <input
										type="text" id="subcat2updateTDreopen"
										name="subcat2updateTDreopen" class="form-control"
										data-toogle="tooltip" readonly>
								</div>
							</div>
						
							<div class="row">
								<div class="col-md-8">
								<label for="subjectupdateTD1">Subject:</label>
								<input type="text" id="subjectupdateTDreopen" name="subjectupdateTDreopen" class="form-control" data-toogle="tooltip" readonly>
								</div>
								<div class="col-md-4">
								<label for="RequestModeupdateTD1"> Request Mode:</label> <input
												type="text" id="RequestModeupdateTDreopen"
												name="RequestModeupdateTDreopen" class="form-control"
												data-toogle="tooltip" readonly>
								</div>
								</div>
							<div class="row">
								<div class="col-md-8">
									<label for="descriptionupdateTD1">Description:</label>
									<textarea id="descriptionupdateTDreopen" rows="4" cols="50"
										name="descriptionupdateTDreopen" class="form-control"
										data-toogle="tooltip" readonly></textarea>
								</div>
								<div class="col-md-4">
									<div class="row">
										<div class="col-md-12">
										<label for="priorityupdateTD1"> Priority:</label>
								<input type="text" id="priorityupdateTDreopen" name="priorityupdateTDreopen" class="form-control" data-toogle="tooltip" readonly>
									</div>
									</div>
									<div class="row">
										<div class="col-md-12">
										<label for="severityupdateTD1"> Severity:</label>
								<input type="text" id="severityupdateTDreopen" name="severityupdateTDreopen" class="form-control" data-toogle="tooltip" readonly>
									</div>
									</div>
								</div>

							</div>
							
<!-- 							<hr> -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col-md-1"></div> -->
<!-- 								<div class="col-md-11"> -->
<!-- 									<span id="Label1" -->
<!-- 										style="color: crimson; font-family: Calibri; font-size: large;">Engineer -->
<!-- 										Details</span> -->
<!-- 								</div> -->

<!-- 							</div> -->
<!-- 							<div class="row"> -->
<!-- 								<div class="col-md-4"> -->
<!-- 									<label for="engnameENG1">Engineer Name</label> <input -->
<!-- 										type="text" id="engnameENG" name="engnameENG" -->
<!-- 										class="form-control" data-toogle="tooltip" readonly="Yes"> -->
<!-- 								</div> -->
<!-- 								<div class="col-md-4"> -->
<!-- 									<label for="ticketstatusENG1">Ticket Status</label> <input -->
<!-- 										type="text" id="ticketstatusENG" tabindex="7" -->
<!-- 										class="form-control" data-toogle="tooltip" -->
<!-- 										name="ticketstatusENG" readonly="Yes"> -->
<!-- 								</div> -->
<!-- 								<div class="col-md-4"> -->
<!-- 									<label for="ticketidupdateTD1">Ticket ID </label> <label -->
<!-- 										for="statusdateENGreopen1">Status Date</label> <input -->
<!-- 										type="text" id="statusdateENGreopen" tabindex="7" -->
<!-- 										class="form-control" data-toogle="tooltip" -->
<!-- 										name="statusdateENGreopen" readonly="Yes"> -->
<!-- 								</div> -->

<!-- 							</div> -->

<!-- 							<hr> -->

<!-- 							<div class="row"> -->

<!-- 								<div class="col-md-10"> -->
<!-- 									<label for="enggsolutionENG1">Engineer Solution</label> -->
<!-- 									<textarea rows="4" cols="50" id="enggsolution" tabindex="8" -->
<!-- 										class="form-control" data-toogle="tooltip" name="enggsolution" -->
<!-- 										readonly="Yes"> -->
<!--                                         </textarea> -->

<!-- 								</div> -->

<!-- 							</div> -->
							
                        <hr>
							<div class="row">
								<div class="col-md-12">
									<label>Browse File:</label> <input type="file" id="reopenPic"
										name="reopenPic" tabindex="14" type="file">

								</div>

							</div>
							<br>
							<div class="row">
								<div class="col-md-10">
									<label for="reopenreason1">Ticket Re-Open Reason:</label>
									<textarea rows="4" cols="50" id="reopenreason"
										placeholder="Enter Re-Open Reason" tabindex="8"
										class="form-control" data-toogle="tooltip" name="reopenreason"
										required></textarea>


								</div>

							</div>
							<br>

							<div class="row">
								<div class="col-md-12 text-center">
									<input type="button" class="btn btn-primary m-t-10"
											id="reopen-btn" name="reopen-btn" value="Re-Open Ticket">&nbsp;&nbsp;
											
										<input type="button" class="btn btn-primary m-t-10"
											id="cancel-btn" name="cancel-btn" value="Cancel"></center>
								</div>
							</div>
</form>
						</div>

						<div class="col-md-2"></div>
					</div>

					<!--</form>-->



				</div>

			</div>
    
    
			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modelclose" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">


						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Close Ticket</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px">
								<span aria-hidden="true">&times;</span>
							</button>


						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-md-2"></div>
								<div class="col-md-8">
								<label for="tidd1">Ticket-ID:</label>
								<input type="text" class="form-control" id="tid" name="tid" readonly>
								</div>
								</div>
							<div class="row">
								<div class="col-md-2"></div>
								<div class="col-md-8">
									<label for="closereason1">Enter Your Reason:</label>
									<textarea id="closereason" name="closereason" class="form-control" placeholder="Enter Your Reason" data-toogle="tooltip" rows="4" cols="50" required></textarea>
									</div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-12 text-center">
									<input type="button" class="btn btn-primary m-t-10" id="ticketclose-btn" name="ticketclose-btn" value="Close Ticket">
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
            
       
          <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</div>
<!-- ./wrapper -->
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/static//AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
 <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery/dist/jquery.min.js"></script>
 
 <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery-ui/jquery-ui.min.js"></script>
<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script> --%>
    
<%--   <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script> --%>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jquery.vmap.min.js"></script>-->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>-->
<!-- jQuery Knob Chart -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/moment/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.js"></script>
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script> -->
 <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
 <!--bootstrap datepicker--> 
<!--<script src="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>-->
<!-- Tempusdominus Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/adminlte.js"></script>-->
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/pages/dashboard.js"></script>-->
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/dist/js/demo.js"></script>

 <!-- Sweetalert 2 -->
<script src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
<script src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>

 <!-- DataTables -->
<!--    <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net/js/jquery.dataTables.js"></script>
     <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net-bs/js/dataTables.bootstrap.js"></script>
     <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>-->
     
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
     
     
     <!--<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>-->
<!--<script src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>-->
<!--<script src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>-->
<!--<script src="../../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>-->
     
      <!--<script src="<%=request.getContextPath()%>/resources/Listing/dataTables.bootstrap.min.js"></script>-->
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/dataTables.buttons.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.bootstrap.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/jszip.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/vfs_fonts.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.html5.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.print.min.js"></script>
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.colVis.min.js"></script>   

     <script src="<%=request.getContextPath()%>/static/custom/resolveengtickets.js"></script>
</body>
     
</html>


