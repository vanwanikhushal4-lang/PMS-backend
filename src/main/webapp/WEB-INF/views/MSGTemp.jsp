<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
   
   <meta http-equiv='cache-control' content='no-cache'> 
  <meta charset="utf-8">
<!--  <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
  <title>Add Mail Template</title>
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
   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-fixedcolumns/css/fixedColumns.bootstrap4.min.css">
   
  <style type="text/css">
  .card{
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
                        <div class="row">
                            <div class="col-md-2"></div>
                            <div class="col-md-8">
                                <br><br>
                                <div class="card card-secondary">
                                    <div class="card-header">Add Mail Template</div>
                                    <div class="card-body">
                                       <div class="row">
                                          <div class="col-md-1"></div>
                                            <div style="margin-top:15px;" class="col-md-10">
                                                   <label  for="statuslabel">Company</label>
                                                <select id="company" class="form-control" tabindex="6" data-toogle="tooltip" name="company">
                                                    <option value="">-- Please Select --</option>
                                               		
                                                </select>                                    
                                            </div>
                                        </div>
                                   	
                                   	 <div class="row">
                                          <div class="col-md-1"></div>
                                            <div style="margin-top:15px;" class="col-md-10">
                                                   <label  for="statuslabel">Ticket Type</label>
                                                <select id="ticket_Type" class="form-control" tabindex="6" data-toogle="tooltip" name="ticket_Type" onchange="getstatusForTicket(this.value)">
                                                    <option value="">-- Please Select --</option>
                                                 
                                                    <option value="Incident Ticket">Incident Ticket</option>
                                                    <option value="Problem Ticket">Problem Ticket</option>
                                                    <option value="Service Request">Service Request</option>
                                                </select>                    
                                                           
                                            </div>
                                        </div>
                                        <div class="row" id="ForITicket">
                                          <div class="col-md-1"></div>
                                            <div style="margin-top:15px;" class="col-md-10" >
                                                   <label  for="statuslabel">Status</label>
                                                <select id="stForIncident" class="form-control" tabindex="6" data-toogle="tooltip" name="stForIncident">
                                                    <option value="">-- Please Select --</option>
                                                  <option value="Assigned">Assigned</option>
                                                    <option value="Awaiting User Information">Awaiting User Information</option>
                                                     <option value="Closed">Closed</option>
                                                     <option value="Hold">Hold</option>
                                                     <option value="New">New</option>
                                                     <option value="Pending With Vendor">Pending With Vendor</option>
                                                     <option value="Re-Assigned">Re-Assigned</option>
                                                     <option value="Rejected">Rejected</option>
                                                     <option value="Reopened">Reopened</option>
                                                     <option value="Waiting for Spare">Waiting for Spare</option>
                                                     <option value="Work in Progress">Work in Progress</option>
                                                  </select>  
                                                  
                                                   <select id="stForProblem" class="form-control" tabindex="6" data-toogle="tooltip" name="stForProblem"> 
                                                    <option value="">-- Please Select --</option>
                                                  <option value="Assigned">Assigned</option>
                                                    <option value="Closed">Closed</option>   
                                                     <option value="Fix In Process">Fix In Process</option>
                                                     <option value="Resolved">Resolved</option>
                                                    </select>    
                                                    
                                                      <select id="stForService" class="form-control" tabindex="6" data-toogle="tooltip" name="stForService"> 
                                                     
                                                      <option value="">-- Please Select --</option>
                                                     <option value="Assigned">Assigned</option>
                                                    <option value="Awaiting User Information">Awaiting User Information</option>
                                                     <option value="Closed">Closed</option>
                                                     <option value="Hold">Hold</option>
                                                  	<option value="Level 1 Approved">Level 1 Approved</option>
                                                    <option value="Level 2 Approved">Level 2 Approved</option>  
                                                    <option value="Level 1 Rejected">Level 1 Rejected</option>
                                                    <option value="Level 2 Rejected">Level 2 Rejected</option>
                                                    <option value="New">New</option>
                                                     <option value="Pending With Vendor">Pending With Vendor</option>
                                                    <option value="Re-Assigned">Re-Assigned</option>
                                                    <option value="Reopened">Reopened</option>
                                                     <option value="Rejected">Rejected</option>
                                                    <option value="Resolved">Resolved</option>   
                                                     <option value="Waiting for Spare">Waiting for Spare</option>  
                                                    <option value="Work in Progress">Work In Progress</option>         
                                                     </select>  
                                                     
                                                                              
                                            </div>
                                        </div>
   
                                         <div class="row">
                                             <div class="col-md-1"></div>
                                            <div style="margin-top:15px;" class="col-md-10">
                                               <label id="sublbl">Subject</label>;
                                               <label id="demo" ></label><label id="demostatus" ></label><label id="demopriority" ></label>
                                               <div id="phnnno"></div>
                                                <span id="subject1"></span><input type="text" id="subject" tabindex="4" class="form-control" name="subject"  data-toogle="tooltip" placeholder="Enter Subject " >

                                            </div>
                                         </div>
                                         
                                         
                                         <div class="row">
                                             <div class="col-md-1"></div>
                                            <div style="margin-top:15px;" class="col-md-10">
                                          
                                               <label for="cno">Mail Body</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<!--                                                 <div class="col-sm-12" style="margin-left: '0px'">  Use [:!]in end</div> -->
                                               <textarea id="mailbody" tabindex="2"  class="form-control form-control-sm" name="mailbody"  data-toogle="tooltip" placeholder="Enter Mail Body"></textarea>

                                            </div>
                                         </div>
                                         <div class="row">
                                             <div class="col-md-1"></div>
                                            <div style="margin-top:15px;" class="col-md-10">
                                          
                                               <label for="mailfooter">Mail Footer Syntax</label>;
                                               <textarea class="form-control form-control-sm"  rows="11" cols="90" readonly="readonly" name="footersyntax" id="footersyntax">
                                               
                                               </textarea>

                                            </div>
                                         </div>
                                          <div class="row">
                                             <div class="col-md-1"></div>
                                            <div style="margin-top:15px;" class="col-md-10">
                                          
                                               <label for="mailfooter">Mail Footer</label>;
<!--                                                 <div class="col-sm-12" style="margin-left: '0px'">  Use [:!]in end</div> -->
                                               <textarea id="mailfooter" tabindex="2" rows="10" cols="80"  class="form-control form-control-sm" name="mailfooter"  data-toogle="tooltip" placeholder="Enter Mail Footer" ></textarea>

                                            </div>
                                         </div>
                                         
                                          <div class="row">
                                             <div class="col-md-1"></div>
                                            <div style="margin-top:15px;" class="col-md-10">
                                            <label>Email Trigger(Optional)</label>
                                            <input type="checkbox" id="emailtrigger" name="emailtrigger"> 
                                           </div>
                                          </div>
                                         
                                         
                                       <div class="row">

                                            <div style="margin-top:15px;" class="col-md-12">
                                                <center>

									<button type="submit" class="btn btn-primary m-t-10" tabindex="5" id="submit-btn" name="submit">Submit </button>

<button type="button" class="btn btn-primary m-t-10" tabindex="6" class="btn btn-primary m-t-10" id="resetbtn" name="reset">Reset</button>

                                                </center>
                                            </div>
                                            <br>
                                        </div>
                                         
                                    </div>
                                </div>
                            </div>
                        <div class="col-md-2"></div>
                        </div>
                    
             
                    <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-10">
                <div class="card card-secondary" style="margin-left: 15px; margin-right: 15px">
                                    <div class="card-header">Message Template Details</div>
                                    <div class="card-body">
<!--                  <div id="eeeew"> -->

                            <table class="table table1 table-striped"  id="datatype" style="width:100%">
                                <thead>
                                    <tr>
                                           <th>Sr No</th>
                                           <th>Edit</th>
                                           <th>Delete</th>
                                           <th>Company</th>
                                           <th>Email Trigger</th>
                                     	   <th>Status</th>
                                      	   <th>Ticket Type</th>
                                       		<th>Subject</th>
                                       		
                                         <th>Mail Body</th>
                                         <th>Mail Footer</th>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>

                            </table>
<!--                         </div> -->
                                         </div>
                                     </div>
                </div>
                 <div class="col-md-1"></div>
                 </div>
                  
                    
                 </section>
                 </div>
                
           
			

   <div class="row">

			<div class="modal fade bs-example-modal-lg modal-default1111"
				id="mail_templateshow" tabindex="-1" role="dialog"
				aria-labelledby="myLargeModalLabel" aria-hidden="true">

				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header bg-secondary">
							<h4 class="modal-title" id="myLargeModalLabel">Update
								Mail  Template</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" style="margin-right: 10px">
								<span aria-hidden="true">&times;</span>
							</button>



						</div>
						<div class="modal-body">
							<!--<form action="">-->
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-10">
									<label for="Companyupdate">Company</label> <input type="text"
										id="Companyupdate" class="form-control"
										data-toogle="tooltip" style="margin-left: 0%;"
										disabled="disabled" >
								</div>


							</div>
							
							<div class="row mt-2">
								<div class="col-md-1"></div>
								<div class="col-md-10">
									<label for="ticketType">Ticket Type</label>
									<select id="ticketTypeup" name="ticketTypeup" class="form-control"
										data-toogle="tooltip" style="margin-left: 0%;" onchange="getStatusForTicket(this.value)">
										  <option value="">-- Please Select --</option>
                                              <option value="Incident Ticket">Incident Ticket</option>
                                               <option value="Problem Ticket">Problem Ticket</option>
                                                    <option value="Service Request">Service Request</option>
										</select>
								</div>

							</div>
							<div class="row mt-2">
								<div class="col-md-1"></div>
								<div class="col-md-10">
									<label for="Categoryupdate">Status</label> 
											<select id="stForIncidentup" class="form-control" tabindex="6" data-toogle="tooltip" >
                                                    <option value="">-- Please Select --</option>
                                                  <option value="Assigned">Assigned</option>
                                                    <option value="Awaiting User Information">Awaiting User Information</option>
                                                     <option value="Closed">Closed</option>
                                                     <option value="Hold">Hold</option>
                                                     <option value="New">New</option>
                                                     <option value="Pending With Vendor">Pending With Vendor</option>
                                                     <option value="Re-Assigned">Re-Assigned</option>
                                                     <option value="Rejected">Rejected</option>
                                                     <option value="Reopened">Reopened</option>
                                                     <option value="Waiting for Spare">Waiting for Spare</option>
                                                     <option value="Work in Progress">Work in Progress</option>
                                                  </select>  
                                                  
                                                   <select id="stForProblemup" class="form-control" tabindex="6" data-toogle="tooltip" name="stForProblemup"> 
                                                    <option value="">-- Please Select --</option>
                                                  <option value="Assigned">Assigned</option>
                                                    <option value="Closed">Closed</option>   
                                                     <option value="Fix In Process">Fix In Process</option>
                                                     <option value="Resolved">Resolved</option>
                                                    </select>    
                                                    
                                                      <select id="stForServiceup" class="form-control" tabindex="6" data-toogle="tooltip" name="stForServiceup"> 
                                                    <option value="">-- Please Select --</option>
                                                     <option value="Assigned">Assigned</option>
                                                    <option value="Awaiting User Information">Awaiting User Information</option>
                                                     <option value="Closed">Closed</option>
                                                     <option value="Hold">Hold</option>
                                                  	<option value="Level 1 Approved">Level 1 Approved</option>
                                                    <option value="Level 2 Approved">Level 2 Approved</option>  
                                                    <option value="Level 1 Rejected">Level 1 Rejected</option>
                                                    <option value="Level 2 Rejected">Level 2 Rejected</option>
                                                    <option value="New">New</option>
                                                    <option value="Re-Assigned">Re-Assigned</option>
                                                    <option value="Re-Opened">Re-Opened</option>
                                                    <option value="Rejected">Rejected</option>
                                                    <option value="Resolved">Resolved</option>   
                                                    <option value="Work In Progress">Work In Progress</option>                                                  
                                                    </select>      
								</div>
							</div>
							
							
							<div class="row mt-2">
								<div class="col-md-1"></div>
								<div class="col-md-10">
									<label for="Subject">Subject:</label>
									<input id="subjectup"  name="subjectup"class="form-control"
										data-toogle="tooltip" style="margin-left: 0%;"
										>
								</div>

							</div>
							<div class="row mt-2">
								<div class="col-md-1"></div>
								<div class="col-md-10">
								 	   <label for="cno">Mail Body</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                      
                                               <textarea id="mailbodyup" tabindex="2"  class="form-control form-control-sm" name="mailbodyup"  data-toogle="tooltip" placeholder="Enter Mail Body"></textarea>

                                           
								</div>

							</div>
								<div class="row mt-2">
								<div class="col-md-1"></div>
								<div class="col-md-10">
								   <label for="mailfooter">Mail Footer</label>;

                                               <textarea id="mailfooterup" tabindex="2" rows="10" cols="80"  class="form-control form-control-sm" name="mailfooterup"  data-toogle="tooltip" placeholder="Enter Mail Footer" ></textarea>
								</div>

							</div>

							
							<div class="row mt-2">
								<div class="col-md-1"></div>						
								<div class="col-md-10">
								<label>Email Trigger(Optional)</label>
                                            <input type="checkbox" id="emailtriggerup" name="emailtriggerup"> 
                                            
									</div>
							</div>

							<input type="hidden" id="sr_no1" name="sr_no1" value="" /> <br>

							<div class="row">
								<div class="col-md-12">
									<center>
										<input type="submit" class="btn btn-primary m-t-10"
											id="update_category_btn" name="update_category_btn"
											value="Update">

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
 <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
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
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-fixedcolumns/js/dataTables.fixedColumns.min.js"></script>
     
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

  <script src="<%=request.getContextPath()%>/static/custom/MSGTemp.js"></script>

</body>
     
</html>


