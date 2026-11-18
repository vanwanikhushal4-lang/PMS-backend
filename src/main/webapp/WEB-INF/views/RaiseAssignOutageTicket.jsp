<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
   
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Raise & Assign Outage Ticket</title>
   <link rel="icon" href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
  <!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--         <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"> -->
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->
  
<!--   <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap/dist/css/bootstrap.min.css">-->
 <!-- daterange picker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css"> 
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
   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-select/css/select.bootstrap4.min.css">
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
  
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap-durationpicker/bootstrap-duration-picker.css">
  
  <style type="text/css">

 label{
 margin-bottom: 0.2rem !important;
 margin-top: 0.5rem !important;
 }

table.dataTable td {
  word-break: break-word;
   white-space:normal;
}
.btn-secondary{
    border-radius: 4px !important;
}
.modal {
overflow-y:auto !important;
z-index:1080 !important;
}
  </style>
</head>
  <body class="hold-transition sidebar-mini layout-fixed">
    <div class="wrapper">
<jsp:include page="/WEB-INF/views/dashboardheaderTP.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>  
                <div class="content-wrapper">
						<br>
                      <section class="content-header">
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                      <form action="insertUserRaiseAssignTicket" id="form" name="form" method="post" enctype="multipart/form-data" >
                                <div class="card card-secondary">
                                    
                                    <div class="card-header">Raise & Assign Outage Ticket</div>
                                    <div class="card-body">
                                                                            
                                        <div class="row">
                                            
                                                <div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Ticket Basic Details</strong></div>
                                                <div class="col-md-4"></div>
                                            </div>
                                        
                                        <div class="row">
												<div class="col-md-4">
                                                    <label for="cname">Name: </label>
                                                    <input type="text" id="name1" readonly="true" class="form-control" data-toogle="tooltip" name="name1">
                                                </div>

												<div class="col-md-4">
                                                    <label for="cname">Company Name:</label>
                                                    <input type="text" id="compname"  readonly="true" class="form-control" data-toogle="tooltip" name="compname">
                                                </div>
                                                <div class="col-md-4">
                                                    <label for="cname">Site:</label>
                                                    <input type="text" id="site" readonly="true" class="form-control" data-toogle="tooltip" name="site">
                                                </div>
                                                <input type="hidden" id="username" name="username" >
                                                <input type="hidden" id="vipuser" name="vipuser" >
                                               </div>
                                            
                                            <div class="row" >
                                            	 <div class="col-md-4">
                                                     <label for="cname">Department:</label>
                                                    <input type="text" id="department" readonly="true"  class="form-control" data-toogle="tooltip" name="department">
                                                </div>
                                                <div class="col-md-4">
                                                     <label for="cname">Sub Department:</label>
                                                    <input type="text" id="sub_department" readonly="true"  class="form-control" data-toogle="tooltip" name="sub_department">
                                                </div>
                                                <div class="col-md-4">
                                                     <label for="cname">Location:</label>
                                                    <input type="text" id="location" readonly="true"  class="form-control" data-toogle="tooltip" name="location">
                                                </div>
                                               </div>
                                            
                                            <div class="row" >
                                            	<div class="col-md-4">
                                                    <label for="cname">Email ID:</label>
                                                    <input type="text" id="emailid"  readonly="true" class="form-control" data-toogle="tooltip" name="emailid">
                                                </div>
                                            	<div class="col-md-4">
                                                    <label for="cname">Phone:</label>
                                                    <input type="text" id="phone"  readonly="true" class="form-control" data-toogle="tooltip" name="phone">
                                                </div>
                                            
                                            	<div class="col-md-4">
                                                    <label for="cname">Request Mode:</label>
                                                	<select id="requestmode" tabindex="9" class="form-control" data-toogle="tooltip" name="requestmode">
                                                                <option value="">--Please Select Request Mode--</option>                                                                
                                                    </select>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="row">
                                           	<div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Ticket Category</strong></div>
                                                <div class="col-md-4"></div>
                                            </div>
                                            <div class="row" >
                                                <div class="col-md-4">
                                                    <label for="cname">Category:</label>
                                                    <select id="category" tabindex="7" class="form-control" data-toogle="tooltip" name="category" onchange="JavaScript:change_subcat1(this.value)">
                                                                <option value="">--Please Select Category--</option>                                                               
                                                    </select>
                                                </div>
												<div class="col-md-4">
                                                    <label for="cname">Sub-Category1:</label>
                                                    <select id="subcat1" tabindex="8" class="form-control" data-toogle="tooltip" name="subcat1" onchange="JavaScript:change_subcat2(this.value)">
                                                                <option value="">--Please Select Sub-Category1--</option>                                                                
                                                    </select>
                                                </div>
                                                <div class="col-md-4">
                                                    <label for="cname">Sub-Category2:</label>
                                                    <select id="subcat2" tabindex="8" class="form-control" data-toogle="tooltip" name="subcat2">
                                                                <option value="">--Please Select Sub-Category2--</option>                                                                
                                                    </select>
                                                </div>
                                                </div>
                                           
                                                                                                                      
                                        <br>
                                        <div class="row">
                                           
                                                <div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Ticket Description</strong></div>
                                                <div class="col-md-4"></div>
                                            </div>
                                        
                                        <div class="row">

<!--                                         <div class="col-md-2"></div> -->
                                                <div class="col-md-10">
                                                    <label for="cname">Subject:</label>
                                                    <input type="text" id="sub" tabindex="4" class="form-control" data-toogle="tooltip" name="sub" placeholder="Please Enter Subject" >
                                                </div> 
<!--                                                <div class="col-md-2"></div> -->
                                            </div>
                                                                                                                                                                                                                         
                                            <div class="row" >
                                                <div class="col-md-10">
                                                    <label for="cname">Description:</label>
                                                    <textarea type="text" rows="4" cols="20" id="description"  tabindex="5" class="form-control" data-toogle="tooltip" name="description" placeholder="Please Enter Description" ></textarea>
                                                </div>
                                                <div class="col-md-2"></div>                                                
                                            </div>
                                            
                                            <div class="row" >
                                                <div class="col-md-10">
                                                    <label for="cname">Priority:</label>
                                                    <select id="priority" tabindex="6" class="form-control" data-toogle="tooltip" name="priority" >
                                                            </select>
                                                </div> 
                                               <div class="col-md-2"></div>
                                            </div>

                                        <hr>
                                         <div class="row">
                                           	<div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Assign Engineer/Group</strong></div>
                                                <div class="col-md-4"></div>
                                            </div>
                                         <div class="row">
                                       			<div class="col-md-4">
                                                    <label for="enggcat1">Assign To:</label>
                                                    <select id="assignTo" tabindex="7" class="form-control" data-toogle="tooltip" name="assignTo" onchange="JavaScript:change_Assigntype(this.value)">
                                                                <option value="">--Please Select Assign To--</option>   
                                                                <option value="Engineer">Engineer</option>   
                                                                <option value="Group">Group</option>                                                               
                                                    </select>
                                                </div>
                                                <div class="col-md-8">
                                                <div id="enggDiv" style="display:none">
                                                <div class="row">
                                                <div class="col-md-6">
                                                    <label for="enggcat1">Engineer Category:</label>
                                                    <select id="enggcat" tabindex="7" class="form-control" data-toogle="tooltip" name="enggcat" onchange="JavaScript:change_enggsubtype(this.value)">
                                                                <option value="">--Please Select Engineer Category--</option>                                                               
                                                    </select>
                                                </div>

                                                <div class="col-md-6">
                                                    <label for="enggassign1">Engineer :</label>
                                                    <select id="enggassign" tabindex="8" class="form-control" data-toogle="tooltip" name="enggassign" >
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
                                        <br>
                                        <div class="row">
                                           
                                                <div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Attachments (Optional)</strong></div>
                                                <div class="col-md-4"></div>
                                           </div>
                                        
                                        <div class="row">

                                         
                                                <div class="col-md-4">                                                    
                                                     <label>Browse File:</label>
                                                       <input id="empPic1" name="empPic1" tabindex="9" type="file" aria-describedby="nameHelp" >
                                                </div> 
                                               
                                               <div class="col-md-8"></div>
                                            </div>
                                                                                                                                                                                                                                                                     
									<hr>
                                             <div class="row">
                                           
                                                <div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Add Incidents (Optional)</strong></div>
                                                <div class="col-md-4"></div>
                                           </div>                                                                                                                                                                                                                         
										<div class="card card-primary" style="margin-left: 15px; margin-right: 15px">
<!--                                     <div class="card-header">Incidents</div> -->
                                    <div class="card-body">
                
                            <table class="table table1 table-striped"  id="Listing_Copy" >
                                <thead>
                                    <tr>
								 		<th>Select</th>
										<th>View Ticket</th>
                                        <th>Ticket ID</th>  
                                        <th>Raise Date</th>
                                        <th>Status</th>
                                        <th>Priority</th>
                                        <th>Subject</th> 
                                        <th>Company</th>
                                        <th>Branch</th>
                                        <th>Department</th>
                                        <th>Raised By</th>
                                        <th>Category</th>
                                        <th>Sub-Category1</th>
                                        <th>Sub-Category2</th>
                                   
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>

                            </table>
                              </div>
                                     </div>
                                       
                                    <!--</form>-->
                                        <br>
                                        <div class="row">
                                        <div class="col-md-12 text-center">
                                       <input type="button" tabindex="10" class="btn btn-primary m-t-10" id="raise-btn" name="submit" value="Raise" onclick="submitbutton1001()">
                                                <input type="button" tabindex="11" class="btn btn-primary m-t-10" id="resetbtn" name="reset" value="Reset">
                                            </div>
                                            </div>
                                           
                                       </div>
                                    </div>                              
                                  </form>
                            </div>
                        </div>
              
                 </section>
                 
            <div class="modal fade bs-example-modal-lg modal-default1111" id="modelviewtickets" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
      
                     
                                <div class="modal-header bg-secondary">
                                     <h4 class="modal-title" id="myLargeModalLabel">Add Incidents</h4>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close" style="margin-right:10px">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                   

                </div>
                <div class="modal-body">
                <div class="row">
                <div class="col-md-12">
                
                <div class="row">
<!--                 <div class="col-md-12"> -->
                <div class="col-md-4">
                <label for="cname">Category:</label>
                 <select id="categoryModal" tabindex="1" class="form-control" data-toogle="tooltip" name="categoryModal">
                 <option value="all">All</option>                                                               
                 </select>
                </div>
                <div class="col-md-8">
                <!-- Date and time range -->
                <div class="form-group">
                  <label>Date Range:</label>

                  <div class="input-group">
                    <button type="button" class="btn btn-default float-right" id="daterange-btn">
                      <i class="far fa-calendar-alt"></i> Date range picker
                      <i class="fas fa-caret-down"></i>
                    </button>
                  </div>
                </div>
                </div>
<!--                 </div> -->
                </div>
               	
                
    
                 <table class="table table1 table-striped"  id="Listing_Copy_Tickets" >
                                <thead>
                                    <tr>
                                         <th>Select</th>
										 <th>View Ticket</th>
                                        <th>Ticket ID</th>  
                                        <th>Raise Date</th>
                                        <th>Status</th>
                                        <th>Priority</th>
                                         <th>Subject</th> 
                                        <th>Company</th>
                                        <th>Branch</th>
                                        <th>Department</th>
                                        <th>Raised By</th>
                                        <th>Category</th>
                                        <th>Sub-Category1</th>
                                        <th>Sub-Category2</th>
                                                                             

                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>

                            </table>
                            <br>
                            <div class="row">
                        <div class="col-md-12 text-center">
                            <input type="button" class="btn btn-primary m-t-10" id="selection-btn" value="Select">
						</div>
						</div>
                </div>
                </div>
                </div>
                </div>
                 </div>
                 </div>
                       
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
                                        <label for="siteupdateUD1" >Site:</label>
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
                                        <label for="ticketidupdateTD1" >Ticket ID </label>
                                        <input type="text" id="ticketidupdateTD" name="ticketidupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                    <div class="col-md-4">
                                        <label for="statusupdateTD1" >Status</label>
                                        <input type="text" id="statusupdateTD" name="statusupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                    </div>
                                <div class="col-md-4">
                                        <label for="raisedateupdateTD1" >Raised Date</label>
                                        <input type="text" id="raisedateupdateTD" name="raisedateupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
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
                                <div class="col-md-8">
                                <div class="row">
                                <div class="col-md-12">
                                 <label for="subjectupdateTD1" >Subject:</label>
                                        <input type="text" id="subjectupdateTD" name="subjectupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes">
                                  </div>
                                </div>
                                	<div class="row">
                                	<div class="col-md-12">
                                        <label for="descriptionupdateTD1" >Description</label>
                                        <textarea id="descriptionupdateTD" rows="4" cols="50" name="descriptionupdateTD" class="form-control" data-toogle="tooltip" readonly="Yes"></textarea>
                                        </div>
                                        </div>
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
<!--                                         <div class="col-md-12"> -->
<!--                                         <label></label> -->
<!--                                         <input type="button" class="btn btn-block btn-secondary" value="View Ticket Activity"> -->
<!--                                         </div>    -->
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
<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery/dist/jquery.min.js"></script> --%>
 
<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery-ui/jquery-ui.min.js"></script> --%>
<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script> --%>
    
<%--   <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script> --%>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<%-- <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/chart.js/Chart.min.js"></script> --%>
<!-- Sparkline -->
<%-- <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/sparklines/sparkline.js"></script> --%>
<!-- JQVMap -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jquery.vmap.min.js"></script>-->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>-->
<!-- jQuery Knob Chart -->
<%-- <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-knob/jquery.knob.min.js"></script> --%>
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

<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap-durationpicker/bootstrap-duration-picker.js"></script>

 <!-- DataTables -->
<!--    <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net/js/jquery.dataTables.js"></script>
     <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net-bs/js/dataTables.bootstrap.js"></script>
     <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>-->
     
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-select/js/dataTables.select.min.js"></script>
     
     
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
            <script src="<%=request.getContextPath()%>/static/resources1/Listing/dataTables.buttons.min.js"></script> 
            
  <script src="<%=request.getContextPath()%>/static/custom/raiseassignoutageticket.js"></script>

</body>
     
</html>


