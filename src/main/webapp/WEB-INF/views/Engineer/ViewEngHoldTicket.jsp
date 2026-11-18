<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>View Hold Tickets</title>
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
		<jsp:include page="/WEB-INF/views/dashboardheaderEngg.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">

			<section class="content-header">

				<div class="card card-secondary"
					style="margin-left: 15px; margin-right: 15px">
					<div class="card-header">View Hold Tickets</div>
					<div class="card-body">
					<div class="row" id="preLoader"><div class="col-md-12 text-center font-weight-bold h6">Loading <i class="fas fa-sync fa-spin"></i></div></div>
						
                            <table class="table table1 table-striped d-none"  id="Listing_Copy" >
								<thead>
									<tr>
										<th>View Ticket</th>
										<th>Ticket Action</th>
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
										<th>Assigned By</th>
										<th>Assigned By Full Name</th>
										<th>Assign Engineer/Group</th>
										<th>Assigned Engineer Full Name</th>
										<th>Hold By </th>
										<th>Hold By Full Name</th>
										<th>Raised Date & Time</th>
										<th>Assign Date & Time</th>
										<th>Hold Date & Time</th>
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

		<div class="modal fade bs-example-modal-lg modal-default1111" id="modelview" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
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
                 <div class="card card-modal card-primary card-outline card-outline-tabs">
                 <div class="card-header p-0 border-bottom-0">
                <ul class="nav nav-tabs" id="custom-tabs-four-tab" role="tablist">
                 <li class="nav-item">
                    <a class="nav-link active" id="custom-tabs-four-home-tab" data-toggle="pill" href="#custom-tabs-four-home" role="tab" aria-controls="custom-tabs-four-home" aria-selected="true">General Details</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" id="custom-tabs-four-profile-tab" data-toggle="pill" href="#custom-tabs-four-profile" role="tab" aria-controls="custom-tabs-four-profile" aria-selected="false">Ticket Activity Log</a>
                  </li>
                 </ul>
              </div>    
              <div class="card-body">
                <div class="tab-content" id="custom-tabs-four-tabContent">
                  <div class="tab-pane fade show active" id="custom-tabs-four-home" role="tabpanel" aria-labelledby="custom-tabs-four-home-tab">     
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-11" >
                        <span id="Label1" style="color:crimson;font-family:Calibri;font-size:large; ">Requester/User Details</span>    
                        </div>
                            
                    </div>
                    
                            <div class="row">
                                <div class="col-md-4">
                                        <label for="nameupdateUD1" >Name:</label>
                                        <input type="text" id="nameupdateUD" name="nameupdateUD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="companyupdateUD1" >Company:</label>
                                        <input type="text" id="companyupdateUD" name="companyupdateUD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="siteupdateUD1" >Branch:</label>
                                        <input type="text" id="siteupdateUD" name="siteupdateUD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                        <label for="deptupdateUD1" >Department:</label>
                                        <input type="text" id="deptupdateUD" name="deptupdateUD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="subdeptupdateUD1" >Sub-Department:</label>
                                        <input type="text" id="subdeptupdateUD" name="subdeptupdateUD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="locationupdateUD1" >Location:</label>
                                        <input type="text" id="locationupdateUD" name="locationupdateUD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

                            </div>
                     <div class="row">
                                <div class="col-md-4">
                                        <label for="phoneupdateUD1" >Contact No:</label>
                                        <input type="text" id="phoneupdateUD" name="phoneupdateUD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="emailupdateUD1" >Email-ID:</label>
                                        <input type="text" id="emailupdateUD" name="emailupdateUD" class="form-control" data-toogle="tooltip" readonly="Yes">
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
                                        <label for="categoryupdateTD1" >Category:</label>
                                        <input type="text" id="categoryupdateTD" name="categoryupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="subcat1updateTD1" >Sub-Category1:</label>
                                        <input type="text" id="subcat1updateTD" name="subcat1updateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                       <label for="subcat2updateTD1" >Sub-Category2:</label>
                                        <input type="text" id="subcat2updateTD" name="subcat2updateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

                            </div>
                     <div class="row">
                     			<div class="col-md-4">
                                        <label for="ticketidupdateTD1" >Ticket-ID:</label>
                                        <input type="text" id="ticketidupdateTD" name="ticketidupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                <div class="col-md-4">
                                        <label for="statusupdateTD1" >Status:</label>
                                        <input type="text" id="statusupdateTD" name="statusupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>    
                                <div class="col-md-4">
                                        <label for="raisedateupdateTD1" >Raised Date:</label>
                                        <input type="text" id="raisedateupdateTD" name="raisedateupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                   </div>
                      <div class="row">
                                <div class="col-md-8">
                                <div class="row">
                                <div class="col-md-12">
                                 <label for="subjectupdateTD1" >Subject:</label>
                                        <input type="text" id="subjectupdateTD" name="subjectupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                  </div>
                                </div>
                                	<div class="row">
                                	<div class="col-md-12">
                                        <label for="descriptionupdateTD1" >Description:</label>
                                        <textarea id="descriptionupdateTD" rows="4" cols="50" name="descriptionupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes"></textarea>
                                        </div>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                 <div class="row">
                                 <div class="col-md-12">
                                        <label for="RequestModeupdateTD1" > Request Mode:</label>
                                        <input type="text"  id="RequestModeupdateTD" name="RequestModeupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                        </div>
                                        <div class="col-md-12">
                                        <label for="priorityupdateTD1" > Priority:</label>
                                        <input type="text"  id="priorityupdateTD" name="priorityupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                        </div>
                                        <div class="col-md-12">
                                        <label for="severityupdateTD1" > Severity:</label>
                                        <input type="text"  id="severityupdateTD" name="severityupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                        </div>  

                                        </div>
                                    </div>
                              
                        </div>
                        <hr>
                          <input type="hidden" id="assetcheck" name="assetcheck">
<%--                      <%  String Company= session.getAttribute("companyname").toString();%> --%>
<%-- 									<%if(Company.equals("3i Infotech") ) { %> --%>

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
											   <hr>
<%-- 									<%}else{} %> --%>
                     
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-11" >
                        <span id="Label1" style="color:crimson;font-family:Calibri;font-size:large; ">Enclosures:</span>    
                        </div>
                            
                    </div>
                   <div id="hidedownload">
                            <div class="row">
                               <div class="col-md-10">
<!--                                        <label for="attachmentTD1" >Attachment</label>-->
<!--                                        <input type=text" id="attachmentTD" name="attachmentTD" class="form-control" data-toogle="tooltip" >-->

                                        <label>Attachment (Uploaded by User):&nbsp;&nbsp;<input type="hidden" id="empPic">&nbsp;&nbsp;<input type="button" id="downHide" value="Download" onclick="downFile()"></label>
<!--                                         <label>Attachment:&nbsp;&nbsp;<span style="color: green;" id="empPic"></span>&nbsp;&nbsp;<input type="button" id="downHide" value="Download" onclick="downFile()"></label>-->
                                       <input type="hidden" id="filename" name="filename">   
                                    </div></div></div>
                                    <div id="nofileattach">
                            <div class="row">
                              
                                    <div class="col-md-4">
                                      <span style="color: black;">No File Attached</span> 
                                    </div>
                                
                                </div>
                                        </div>

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
						</div>
						<div class="modal-footer justify-content-center">
              <input type="button" class="btn btn-primary m-t-10" id="close-btn" name="close-btn" value="Close">
              
            </div>
                   </div>
                        </div>

                        <div class="col-md-2"></div>
                    </div>

                    <!--</form>-->



                </div>

            </div>
		
			
		</div>

		<div class="row">
			
			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="modelupdate" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">


						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Update Status of Hold Ticket</h4>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close" style="margin-right: 10px">
								<span aria-hidden="true">&times;</span>
							</button>

						</div>
						<div class="modal-body">
							<form action="UpdateAssignedHoldandReassignticket" id="form" name="form"
								method="post" enctype="multipart/form-data">
								<div class="row">
									<div class="col-md-1"></div>
									<div class="col-md-11">
										<span id="Label1" style="color: crimson; font-family: Calibri; font-size: large;">Engineer Details</span>
									</div>

								</div>

								<div class="row">
									<div class="col-md-4">
										<label for="fnameupdate">Engineer:</label> 
										<input type="text" id="engname" name="engname" tabindex="1" readonly="true" class="form-control">

									</div>
									<div class="col-md-4">
										<label for="lnameupdate">Company:</label> 
										<input type="text" id="engcompany" name="engcompany" tabindex="2" readonly="true" class="form-control">

									</div>
									<div class="col-md-4">
										<label for="lnameupdate">Branch:</label> 
										<input type="text" id="engsite" name="engsite" tabindex="2" readonly="true" class="form-control">

									</div>
									

								</div>
								<div class="row">
									<div class="col-md-4">
										<label for="fnameupdate">Department:</label> 
										<input type="text" id="engdepartment" name="engdepartment" tabindex="3" readonly="true" class="form-control">
									</div>
								 <div class="col-md-4">
                                        <label for="subdepartmentengg" >Sub-Department:</label>
                                        <input type="text" id="subdepartmentengg" name="subdepartmentengg" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="locationtpengg" >Location:</label>
                                        <input type="text" id="locationtpengg" name="locationtpengg" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

								</div>
								
									<div class="row">
								
									<div class="col-md-4">
										<label for="fnameupdate">Email-ID:</label>
										 <input type="text" id="engemailid" name="engemailid" tabindex="3" readonly="true" class="form-control">
									</div>
									<div class="col-md-4">
										<label for="lnameupdate">Contact No:</label> 
										<input type="text" id="engphone" name="engphone" tabindex="4" readonly="true" class="form-control">

									</div>

								</div>

								<hr>
								<div class="row">
									<div class="col-md-1"></div>
									<div class="col-md-11">
										<span id="Label1" style="color: crimson; font-family: Calibri; font-size: large;">Requester/User Details</span>
									</div>

								</div>

								<div class="row">

									<div class="col-md-4">
										<label for="cname">User Name: </label> 
										<input type="text" id="username" readonly="true" tabindex="5" class="form-control" data-toogle="tooltip" name="username">
									</div>
									<div class="col-md-4">
										<label for="cname">Company:</label> 
										<input type="text" id="usercompany" readonly="true" tabindex="6" class="form-control" data-toogle="tooltip" name="usercompany">
									</div>
									<div class="col-md-4">
										<label for="cname">Branch:</label> 
										<input type="text" id="usersite" readonly="true" tabindex="6" class="form-control" data-toogle="tooltip" name="usersite">
									</div>
									

								</div>

								<div class="row">
									<div class="col-md-4">
										<label for="cname">Department:</label>
										<input type="text" id="userdepartment" readonly="true" tabindex="6" class="form-control" data-toogle="tooltip" name="userdepartment">
									</div>
								
										    <div class="col-md-4">
                                        <label for="subdepartmentrequester" >Sub-Department:</label>
                                        <input type="text" id="subdepartmentrequester" name="subdepartmentrequester" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="locationtp" >Location:</label>
                                        <input type="text" id="locationrequester" name="locationrequester" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

								</div>
								
										<div class="row">
									
									<div class="col-md-4">
										<label for="cname">Email-ID:</label> 
										<input type="text" id="useremail" tabindex="7" readonly="true" class="form-control" data-toogle="tooltip" name="useremail">
									</div>
									<div class="col-md-4">
										<label for="cname">Contact No:</label> 
										<input type="text" id="userphone" tabindex="8" readonly="true" class="form-control" data-toogle="tooltip" name="userphone">
									</div>

								</div>
								<hr>
								<div class="row">
									<div class="col-md-1"></div>
									<div class="col-md-11">
										<span id="Label1" style="color: crimson; font-family: Calibri; font-size: large;">Ticket Assigned By Details</span>
									</div>

								</div>

								<div class="row">

									<div class="col-md-4">
										<label for="cname">Name:</label> 
										<input type="text" id="tcname" readonly="true" tabindex="9" class="form-control" data-toogle="tooltip" name="tcname">
									</div>
									<div class="col-md-4">
										<label for="cname">Company:</label> 
										<input type="text" id="tccompany" readonly="true" tabindex="10" class="form-control" data-toogle="tooltip" name="tccompany">
									</div>
									<div class="col-md-4">
										<label for="cname">Branch:</label> 
										<input type="text" id="tcsite" readonly="true" tabindex="11" class="form-control" data-toogle="tooltip" name="tcsite">

									</div>
								</div>
								<div class="row">

									<div class="col-md-4">
										<label for="cname">Department:</label> 
										<input type="text" id="tcdepartment" readonly="true" tabindex="9" class="form-control" data-toogle="tooltip" name="tcdepartment">
									</div>
							<div class="col-md-4">
                                        <label for="subdepartmenttp" >Sub-Department:</label>
                                        <input type="text" id="subdepartmenttp" name="subdepartmenttp" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="locationtp" >Location:</label>
                                        <input type="text" id="locationtp" name="locationtp" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
								</div>
								
										<div class="row">

								
									<div class="col-md-4">
										<label for="cname">Email-ID:</label> 
										<input type="text" id="tcemail" readonly="true" tabindex="10" class="form-control" data-toogle="tooltip" name="tcemail">
									</div>
									<div class="col-md-4">
										<label for="cname">Contact No:</label> 
										<input type="text" id="tcphone" readonly="true" tabindex="11" class="form-control" data-toogle="tooltip" name="tcphone">

									</div>
										<div class="col-md-4">
										<label for="rtype">Role Type:</label> 
										<input type="text" id="roletype" readonly tabindex="11" class="form-control" data-toogle="tooltip" name="roletype">

									</div>
								</div>
								<hr>
								<div class="row">
									<div class="col-md-1"></div>
									<div class="col-md-11">
										<span id="Label1" style="color: crimson; font-family: Calibri; font-size: large;">Ticket Assigned Details</span>
									</div>
								</div>

								<div class="row">
									<div class="col-md-4">
										<label for="cname">Ticket-ID:</label> 
										<input type="text" id="tid" tabindex="12" readonly="true" class="form-control" data-toogle="tooltip" name="tid">
									</div>
									<div class="col-md-4">
										<label for="cname">Raised Date:</label> 
										<input type="text" id="raisedate" tabindex="13" readonly="true" class="form-control" data-toogle="tooltip" name="raisedate" >
									</div>
									<div class="col-md-4">
										<label for="cname">Assign Date:</label> 
										<input type="text" id="assigndate" tabindex="14" readonly="true" class="form-control" data-toogle="tooltip" name="assigndate">
									</div>
								</div>
								
								<div class="row">
									<div class="col-md-4">
										<label for="cname">Category:</label> 
										<input type="text" id="category" tabindex="19" readonly="true" class="form-control" data-toogle="tooltip" name="category">

									</div>
									<div class="col-md-4">
										<label for="cname">Sub-Category1:</label> 
										<input type="text" id="subcat1" tabindex="18" readonly="true" class="form-control" data-toogle="tooltip" name="subcat1">
									</div>
									<div class="col-md-4">
										<label for="cname">Sub-Category2:</label> 
										<input type="text" id="subcat2" tabindex="21" readonly="true" class="form-control" data-toogle="tooltip" name="subcat2">

									</div>
								</div>
								
								<div class="row">
									<div class="col-md-4">
										<label for="cname">Status:</label>
										 <input type="text" id="ticketstatus" tabindex="16" readonly="true" class="form-control" data-toogle="tooltip" name="ticketstatus">
									</div>
									<div class="col-md-4">
										<label for="cname">Priority:</label>
										 <input type="text" id="priority" tabindex="15" readonly="true" class="form-control" data-toogle="tooltip" name="priority">
									</div>
									<div class="col-md-4">
										<label for="cname">Severity:</label>
										 <input type="text" id="severity" tabindex="15" readonly="true" class="form-control" data-toogle="tooltip" name="severity">
									</div>
									
								</div>
								
								<div class="row">
									<div class="col-md-8">
									<label for="cname">Subject:</label>
										 <input type="text" id="subject" tabindex="16" readonly="true" class="form-control" data-toogle="tooltip" name="subject">
									</div>
									<div class="col-md-4">
									<label for="requestmodeTD1"> Request Mode:</label> 
										<input type="text" id="requestmode" name="requestmode" class="form-control" data-toogle="tooltip" readonly="Yes">
									</div>
									</div>
								<div class="row">
									<div class="col-md-8">
										<label for="cname">Description:</label>
										<textarea id="description" tabindex="17" readonly="true" class="form-control" data-toogle="tooltip" name="description" placeholder="Please Enter Subject" rows="4" cols="50"></textarea>

									</div>

								</div>
								
								<hr>
								
								<!-- CODE OF CHANGE PRIORITY SEVERITY -->
							<!--   	<div class="row">
									<div class="col-md-6">
								<label for="changeps">Request Priority/Severity Update (Optional) :&nbsp;</label>
								<button type="button" onclick="changeps1()" class="btn btn-info btn-xs changeps" id="changeps">Request</button>
								</div>
									<div class="col-md-6">
								<label for="changeps">Request Raise CRF(Optional) :&nbsp;</label>
								<button type="button" onclick="raisecrf()" class="btn btn-info btn-xs changeps1" id="changeps1">Request</button>
								</div>
								</div> -->
								
								
								<div class="row">
									<div class="col-md-12">
										<label>Browse File:</label> <input type="file" id="resolvePic" name="resolvePic" tabindex="18">
									</div>
								</div>
								<br>
								<div class="row">
									<div class="col-md-6">
										<label for="cname">Status:</label> <select id="status" tabindex="22" class="form-control" onchange="onchangeofstatus(this.value)" data-toogle="tooltip" name="status">
											<option value="">Select Status</option>
												<option value="Re-Assigned">Re-Assigned</option>
											<option value="Work in Progress">Work in Progress</option>
										
											<!-- <option value="Rejected">Reject</option> -->
										</select>
									</div>
									</div>
									<div class="row">
                  					<!-- <div class="col-md-2">
                                        <label for="statusupdateENG1" >Status</label>
                                        <select id="statusupdateENG" name="statusupdateENG" class="form-control" data-toogle="tooltip">
                                            <option value="">Select Status</option>
                                            <option value="Assigned">Assigned</option> 
                                            <option value="Hold">Hold</option> 
                                        </select>
                                    </div> -->
                                 <div class="col-md-3" id="assigntodiv" style="display: none;">
                                                    <label for="enggcat1">Assign To:</label>
                                                    <select id="assignTo" tabindex="7" class="form-control" data-toogle="tooltip" name="assignTo" onchange="JavaScript:change_Assigntype(this.value)">
                                                                <option value="">--Please Select Assign To--</option>   
                                                                <option value="Engineer">Engineer</option>   
                                                                <option value="Group">Group</option>                                                               
                                                    </select>
                                                </div>
                                   <div class="col-md-9">
                                                <div id="enggDiv" style="display:none">
                                                <div class="row">
                                                <div class="col-md-4">
                                                    <label for="enggcat1">Engineer Category:</label>
                                                    <select id="enggcat" tabindex="7" class="form-control" data-toogle="tooltip" name="enggcat" onchange="change_enggsubtype(this.value)">
                                                                <option value="">--Please Select Engineer Category--</option>                                                               
                                                    </select>
                                                </div>

                                                <div class="col-md-8">
                                                    <label for="enggassign1">Engineer :</label>
                                                    <select id="enggassign" tabindex="8" class="form-control" onchange="getothersdata(this.value)"  data-toogle="tooltip" name="enggassign" >
                                                                <option value="">--Please Select Engineer--</option>                                                                
                                                    </select>
                                                </div>
                                                </div>
                                          </div>
                                           <div id="groupDiv" style="display:none">
                                           <div class="row">
                                           <div class="col-md-6">
                                                    <label for="engggroup1">Select Engineer Group:</label>
                                                    <select id="engGroup" tabindex="7" class="form-control" data-toogle="tooltip" name="engGroup">
                                                                <option value="">--Please Select Engineer Group--</option>                                                               
                                                    </select>
                                                </div>
                                               </div>
                                           </div>
                                           </div>
                              
                        </div>
									
									
									
									     <!--  CODE FOR GET  ASSIGN USER DATA STRAT -->
                                            <div id="Hideotherdata" style="display: none;">
                                            <br>
											 <strong>Selected User Details :</strong>
                                            <div class="card mt-2">
  											<div class="card-body ">
  
                                             <div class="row" >

												<div class="col-md-4">
                                                    <label for="cname">Company:</label>
                                                    <input type="text" id="othercompname" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="othercompname">
                                                </div>
                                              

												<div class="col-md-4">
                                                    <label for="cname">Branch:</label>
                                                    <input type="text" id="othersite" tabindex="6" readonly="true" class="form-control" data-toogle="tooltip" name="othersite">
                                                </div>
                                                   <div class="col-md-4">
                                                    <label for="cname">Department: </label>
                                                    <input type="text" id="otherdepart" tabindex="1" readonly="true" class="form-control" data-toogle="tooltip" name="otherdepart">
                                                </div>
                                               
												</div>
												<div class="row">

												<div class="col-md-4">
                                                    <label for="cname">Full Name:</label>
                                                    <input type="text" id="otherfullname" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="otherfullname">
                                                </div>
                                              

												<div class="col-md-4">
                                                    <label for="cname">Email:</label>
                                                    <input type="text" id="otheremail" tabindex="6" readonly="true" class="form-control" data-toogle="tooltip" name="otheremail">
                                             
                                               
												</div>
													<div class="col-md-4"></div>
                                          
                                            </div>
                                            </div>
                                            </div>
                                            </div>
                                            
                                            <!--  CODE FOR GET  ASSIGN USER DATA END -->
                                            
									
									
									<div class="row">
									<div class="col-md-12">
										<label for="cname">Work in Progress/Re Assign Solution:</label>
										<textarea rows="2" cols="10" id="solution" tabindex="23" class="form-control" name="solution" placeholder="Please Enter Hold Reason/Resolved Solution" maxlength="2000"
												onkeyup="characterCounter()"></textarea>
												<span id="note"
												style="font-size: 12px" class="text-danger">Description 
												length must be Min 1 characters & Max 2000 characters. </span>
												<br><span id="counterSpan" class="text-danger" style="display: none">												
												Remaining Characters are <span id="calulateId"></span>
												</span>
									</div>

								</div>
							


								<br>
								<div class="row">
									<div class="col-md-12">
										<center>
											<input type="button" class="btn btn-primary m-t-10" id="update_ticket" name="update_ticket" value="Submit">

										</center>
									</div>
								</div>
							</form>
						</div>

						<div class="col-md-2"></div>
					</div>

					<!--</form>-->



				</div>

			</div>
			

			</div>
			
			
			<div class="modal fade bs-example-modal-lg modal-default1111" id="modelchangesp" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
      
                     
                                <div class="modal-header bg-secondary">
                                     <h4 class="modal-title" id="myLargeModalLabel">Request Severity / Priority Update</h4>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close" style="margin-right:10px">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                   

                </div>
                <div class="modal-body">
			
		
						<div class="row">
									<div class="col-md-1">
								</div>
								
								
										<div class="col-md-5" id="parentsdivp">
										<label for="changepriority">Change Priority</label>
										<select  class='form-control' id="changepriority"> 
										<option value=""> --Please Select Priority --</option>
										</select>
										</div>
										
										<div class="col-md-5" id="parentsdivs">
										<label for="changeseverity">Change Severity</label>
										<select class='form-control' id="changeseverity"> 
										<option value=""> --Please Select Severity --</option>
										</select>
										</div>
												<div class="col-md-1">
								</div>
								
										
								</div>
								<br>

						<div class="row">
							<div class="col-md-1"></div>
							<div class="col-md-10">
								<label for="changereason">Reason To Request
									Priority/Severity Update</label>
								<textarea class="form-control" placeholder="Enter Reason"
									id='changereason' rows="5" cols="80"></textarea>
							</div>
							<div class="col-md-1"></div>

						</div>
						<br>
								 <div class="row">
								  	<div class="col-md-12 text-center">
								  	 <button  name="submit-click1" id="submit-click1" class="btn btn-primary">submit</button>
								  	</div>
									  </div>
								
			
			</div>
			</div>
			</div>
			</div>
			
			
			<div class="modal fade bs-example-modal-lg modal-default1111" id="modelraisecrf" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-md">
            <div class="modal-content">
      
                     
                                <div class="modal-header bg-secondary">
                                     <h4 class="modal-title" id="myLargeModalLabe2">Request Raise Crf</h4>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close" style="margin-right:10px">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                   

                </div>
                <div class="modal-body">
			
		
						<div class="row">
								
										<div class="col-md-6" id="">
										<label for="tid2">Ticket-Id:</label>
										<input  class='form-control' readonly="tid2" id="tid2"/> 
										</div>
										
									<div class="col-md-6" id="">
										<label for="company2">Company:</label>
										<input  class='form-control' readonly name="company2" id="company2"/> 
										</div>
										
										
								</div>
								<br>

					<div class="row">
										<div class="col-md-6" id="">
										<label for="branch2">Branch:</label>
										<input  class='form-control' readonly name="branch2" id="branch2"/> 
										</div>
										
									<div class="col-md-6" id="">
										<label for="department2">Department:</label>
										<input  class='form-control'  readonly name="department2" id="department2"/> 
										</div>
										
								</div>
						<br>
						
						
						<div class="row">
							<div class="col-md-12" id="">
										<label for="sub2">Subject:</label>
										<input  class='form-control' readonly name="sub2" id="sub2"/> 
										</div>
									</div>	
								<div class="row">
								
									
									<div class="col-md-12" id="">
										<label for="department2">Description</label>
										<textarea cols="50" rows="5" readonly class='form-control' name="des2" id="des2"></textarea> 
										</div>
								</div>
								
								
								<div class="row">
								
										
									<div class="col-md-12" id="">
										<label for="department2">Engineer Note:</label>
										<textarea cols="50" rows="5" placeholder="Enter Reason" class='form-control' name="engnote21" id="engnote21"></textarea> 
										</div>
								</div>
								
								 <div class="row">
								  	<div class="col-md-12 text-center pt-2">
								  	 <button  name="submit-click1" id="submit-click2" class="btn btn-primary">submit</button>
								  	 
								  	   <button type="button" class="btn btn-dark"data-dismiss="modal"
                                            aria-label="Close" >Cancel
                                        <span aria-hidden="true">&times;</span>
                                    </button>
								  	
								  	</div>
								  	
								  	
								  	 	 
									  </div>
								
			
			</div>
			</div>
			</div>
			</div>
			

			


		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		<!-- ./wrapper -->
	</div>
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
	<!-- 		<script -->
	<%-- 			src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script> --%>

	<!-- 		<script -->
	<%-- 			src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script> --%>
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

	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/dist/js/demo.js"></script>

	<!-- Sweetalert 2 -->
	<script
		src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>


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
		src="<%=request.getContextPath()%>/static/custom/Engineer/EngHoldTicket.js"></script>
</body>

</html>


