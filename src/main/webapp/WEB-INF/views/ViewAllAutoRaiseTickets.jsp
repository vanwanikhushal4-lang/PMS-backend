<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
   
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>View All Auto Raised Tickets</title>
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
<jsp:include page="/WEB-INF/views/dashboardheaderTP.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>  
                <div class="content-wrapper">

                      <section class="content-header">
                      
                <div class="card card-secondary" style="margin-left: 15px; margin-right: 15px">
                                    <div class="card-header">View All Auto Raised Tickets</div>
                                    <div class="card-body">
                   <div class="row" id="preLoader"><div class="col-md-12 text-center font-weight-bold h6">Loading <i class="fas fa-sync fa-spin"></i></div></div>
						
                            <table class="table table1 table-striped d-none"  id="Listing_Copy" >
                                <thead>
                                    <tr>
                                         <th>View Ticket</th>
                                        <th>Assign Ticket</th>
                                        <th>Close Ticket</th>
                                        
                                        <th>Ticket ID</th>  
                                        <th>Status</th>
                                        <th>Priority</th>
                                        <th>Subject</th>
                                        <th>Company</th>
                                        <th>Branch</th>
                                        <th>Department</th>
                                        <th>Category</th>
                                        <th>Sub-Category1</th>
                                        <th>Sub-Category2</th>
                                        <th>By&nbsp;User</th>
                                        <th>Raised&nbsp;Date & Time</th>
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
                                            aria-label="Close" style="margin-right:10px">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                   

                </div>
                <div class="modal-body">
                          
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
                                        <label for="phoneupdateUD1" >Phone No</label>
                                        <input type="text" id="phoneupdateUD" name="phoneupdateUD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="emailupdateUD1" >Email ID</label>
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
                                        <label for="groupupdateTD1" >Sub-Category:</label>
                                        <input type="text" id="groupupdateTD" name="groupupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="subjectupdateTD1" >Subject:</label>
                                        <input type="text" id="subjectupdateTD" name="subjectupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

                            </div>
                     <div class="row">
                                <div class="col-md-4">
                                        <label for="raisedateupdateTD1" >Raised Date</label>
                                        <input type="text" id="raisedateupdateTD" name="raisedateupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="statusupdateTD1" >Status</label>
                                        <input type="text" id="statusupdateTD" name="statusupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="ticketidupdateTD1" >Ticket ID </label>
                                        <input type="text" id="ticketidupdateTD" name="ticketidupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                               
                            </div>
                      <div class="row">
                                 <div class="col-md-8">
                                        <label for="descriptionupdateTD1" >Description</label>
                                        <textarea id="descriptionupdateTD" rows="4" cols="50" name="descriptionupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes"></textarea>
                                    </div>
                                   <div class="col-md-4">
                                          <div class="row">
                                        <div class="col-md-12">
                                        <label for="priorityupdateTD1" > Priority</label>
                                        <input type="text"  id="priorityupdateTD" name="priorityupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                        </div>
                                              <div class="col-md-12">
                                        <label for="RequestModeupdateTD1" > Request Mode</label>
                                        <input type="text"  id="RequestModeupdateTD" name="RequestModeupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
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

                         
                    <br>
                       
                       
                        <div class="row">
                        <div class="col-md-12">
                            <center>
                               <input type="button" class="btn btn-primary m-t-10" id="close-btn" name="close-btn" value="Close">

                            </center>
                        </div>
						</div>
                   
                        </div>

                        <div class="col-md-2"></div>
                    </div>

                    <!--</form>-->



                </div>

            </div>
    
    <div class="modal fade bs-example-modal-lg modal-default1111" id="modelassign" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
      
                     
                                <div class="modal-header bg-secondary">
                                     <h4 class="modal-title" id="myLargeModalLabel">Assign Ticket</h4>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close" style="margin-right:10px">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                   

                </div>
                <div class="modal-body">
                          <form action="InsertAssignTicket" id="form" name="form" method="post" enctype="multipart/form-data">     
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-11" >
                        <span id="Label1" style="color:crimson;font-family:Calibri;font-size:large; ">Third Party Details</span>    
                        </div>
                            
                    </div>
                    
                            <div class="row">
                                 <div class="col-md-4">
                                        <label for="nameupdateTP1" >Name:</label>
                                        <input type="text" id="nameupdateTP" name="nameupdateTP" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="companyupdateTP1" >Company:</label>
                                        <input type="text" id="companyupdateTP" name="companyupdateTP" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="siteupdateTP1" >Branch:</label>
                                        <input type="text" id="siteupdateTP" name="siteupdateTP" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

                            </div>
                     <div class="row">
                                <div class="col-md-4">
                                        <label for="phoneupdateTP1" >Phone No</label>
                                        <input type="text" id="phoneupdateTP" name="phoneupdateTP" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="emailupdateTP1" >Email ID</label>
                                        <input type="text" id="emailupdateTP" name="emailupdateTP" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                   
                            </div>
                    <hr>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-11" >
                        <span id="Label1" style="color:crimson;font-family:Calibri;font-size:large; ">Requester/User Details</span>    
                        </div>
                            
                    </div>
                    
                            <div class="row">
                                <div class="col-md-4">
                                        <label for="nameupdateUD1" >Name:</label>
                                        <input type="text" id="nameupdateUDassign" name="nameupdateUDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="companyupdateUD1" >Company:</label>
                                        <input type="text" id="companyupdateUDassign" name="companyupdateUDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="siteupdateUD1" >Branch:</label>
                                        <input type="text" id="siteupdateUDassign" name="siteupdateUDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>

                            </div>
                     <div class="row">
                                <div class="col-md-4">
                                        <label for="phoneupdateUD1" >Phone No</label>
                                        <input type="text" id="phoneupdateUDassign" name="phoneupdateUDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="emailupdateUD1" >Email ID</label>
                                        <input type="text" id="emailupdateUDassign" name="emailupdateUDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
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
                                        <input type="text" id="categoryupdateTDassign" name="categoryupdateTDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="groupupdateTD1" >Sub-Category:</label>
                                        <input type="text" id="groupupdateTDassign" name="groupupdateTDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="subjectupdateTD1" >Subject:</label>
                                        <input type="text" id="subjectupdateTDassign" name="subjectupdateTDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                              
                        </div>
                        <div class="row">
                                 <div class="col-md-4">
                                        <label for="raisedateupdateTD1" >Raised Date</label>
                                        <input type="text" id="raisedateupdateTDassign" name="raisedateupdateTDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="statusupdateTD1" >Status</label>
                                        <input type="text" id="statusupdateTDassign" name="statusupdateTDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="ticketidupdateTD1" >Ticket ID </label>
                                        <input type="text" id="ticketidupdateTDassign" name="ticketidupdateTDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                              
                        </div>
                        <div class="row">
                                 <div class="col-md-8">
                                        <label for="descriptionupdateTD1" >Description</label>
                                        <textarea id="descriptionupdateTDassign" rows="4" cols="50" name="descriptionupdateTDassign" class="form-control" data-toogle="tooltip" readonly="Yes"></textarea>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="row">
                                        <div class="col-md-12">
                                        <label for="priorityupdateTD1" > Priority</label>
                                        <select  id="priorityupdateTDassign" name="priorityupdateTDassign" class="form-control" data-toogle="tooltip">
<!--                                            <option value="-1">Select Priority</option>
                                            <option value="Low">Low</option>
                                            <option value="Medium">Medium</option>
                                            <option value="High">High</option>-->
                                        </select>
                                        </div>
                                           <div class="col-md-12">
                                        <label for="RequestModeupdateTD1" > Request Mode</label>
                                        <input type="text"  id="RequestModeupdateTDassign" name="RequestModeupdateTDassign" class="form-control" data-toogle="tooltip" readonly="Yes">
                                        </div>  
                                        </div>
                                    </div>
                              
                        </div>
                        <hr>
                        <div class="row">
								<div class="col-md-12">
									<label>Browse File:</label> <input type="file" id="assignPic"
										name="assignPic" tabindex="14" type="file">

								</div>

							</div>
							<br>
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-11" >
                        <span id="Label1" style="color:crimson;font-family:Calibri;font-size:large; ">Engineer Details</span>    
                        </div>
                            
                    </div>
                  <div class="row">
                                 <div class="col-md-4">
                                        <label for="statusupdateENG1" >Status</label>
                                        <select id="statusupdateENG" name="statusupdateENG" class="form-control" data-toogle="tooltip" onchange="ToggleHoldReason(this.value)">
                                            <option value="">Select Status</option>
                                            <option value="Assigned">Assigned</option> 
                                            <option value="Hold">Hold</option> 
                                        </select>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="categoryupdateENG1" >Category</label>
                                         <select id="enggcat" tabindex="7" class="form-control" data-toogle="tooltip" name="enggcat" onchange="JavaScript:change_enggsubtype(this.value)">
                                          <option value="">--Please Select Category--</option> 
                                         </select>
                                    </div>
                                    <div class="col-md-4">
                                        <label for="enggupdateENG1" >Engineer Name</label>
                                         <select id="enggassign" tabindex="8" class="form-control" data-toogle="tooltip" name="enggassign" >
                                           <option value="">--Please Select Engineer--</option>                                                                
                                                    </select>
                                    </div>
                              
                        </div>
                         <div class="row" id="TPHoldNotes" style="display: none">
                                    <div class="col-md-6">
                                        <label for="holdnotesupdateENG1" >Hold Reason</label>
                                         <textarea id="holdnotes" tabindex="9" class="form-control" data-toogle="tooltip" name="holdnotes" ></textarea>
                                    </div> 
                                </div>
                        <div class="row">
                            <div class="col-md-6">
                                <input type="hidden" id="cr_no" name="cr_no" value=""/>
                            </div>
                        </div> 
                    <br>
                       
                       
                        <div class="row">
                        <div class="col-md-12">
                            <center>
                              <input type="button" class="btn btn-primary m-t-10" id="submit-btn" name="submit-btn" value="Submit" tabindex="9">

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
    
    <div class="modal fade bs-example-modal-lg modal-default1111" id="modelclose" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
      
                     
                                <div class="modal-header bg-secondary">
                                     <h4 class="modal-title" id="myLargeModalLabel">Close Ticket</h4>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close" style="margin-right:10px">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                   

                </div>
                <div class="modal-body">
                          
                    <div class="row">
                        <div class="col-md-1"></div>
                        <div class="col-md-11" >
<!--                         <span id="Label1" style="color:crimson;font-family:Calibri;font-size:large; ">Requester/User Details</span>     -->
                        </div>
                            
                    </div>
                    
                            <div class="row">
                                 <div class="col-md-2"></div>
                                    <div class="col-md-8">
                                        <label for="closereason1" >Enter Your Reason</label>
                                        <textarea  id="closereason" name="closereason" class="form-control" data-toogle="tooltip" rows="4" cols="50"></textarea>
                                         <input type="hidden" id="hiddenID">
                                    </div>

                            </div>
                            <br>               
                        <div class="row">
                        <div class="col-md-12">
                            <center>
                               <input type="button" class="btn btn-primary m-t-10" id="ticketclose-btn" name="ticketclose-btn" value="Close Ticket">

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


     <script src="<%=request.getContextPath()%>/static/custom/viewallautoraisedticket.js"></script>
</body>
     
</html>


