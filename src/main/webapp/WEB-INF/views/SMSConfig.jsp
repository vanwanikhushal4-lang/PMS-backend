<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
   
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Mail Configuration</title>
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
<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

 <jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>  
                <div class="content-wrapper">

                      <section class="content-header">
               <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-10">
                                <br><br>
                                <div class="card card-secondary">
                                    <div class="card-header">
                                    <h3 class="card-title">SMS Configuration</h3>
                                    </div>
                                    <div class="card-body">
                          <div class="row">                                            
                                    <div class="col-md-6">                                              
                                        <div class="form-group">
                                            <label for="errorname1">Company</label> <select
											id="cname1" class="form-control" tabindex="1"
											data-toogle="tooltip" name="cname1" style="width: 75%; ">
											<option value="">-- Please Select --</option>
											
										</select>
                                        
                                        </div>
                                    </div>

                                   
                                </div>
                            <div class="row">                                            
                                    <div class="col-md-6">                                              
                                        <div class="form-group">
                                            <label class="control-label">API Name</label>
                                            <input type="text" id="apiname" tabindex="1" class="form-control" name="apiname" data-toogle="tooltip" placeholder="Enter API Name">
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label class="control-label">API URL </label>
                                            <input type="text" id="apiurl" tabindex="2" class="form-control" name="apiurl" data-toogle="tooltip" placeholder="Enter API URL">
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-3">

                                        <div class="form-group">
                                            <label class="control-label">Username(Variable) </label>
                                            <input type="text" id="uname" tabindex="3" class="form-control" name="uname" data-toogle="tooltip" placeholder="Enter Username Variable">
                                        </div>

                                    </div>

                                    <div class="col-md-3">

                                        <div class="form-group">
                                            <label class="control-label">Value </label>
                                            <input type="text" id="uservalue1"   tabindex="4" class="form-control" name="uservalue1" data-toogle="tooltip" placeholder="Enter Username">
                                        </div>

                                    </div>
                                    <div class="col-md-3">

                                        <div class="form-group">
                                            <label class="control-label">Password(Variable) </label>
                                            <input type="text" id="userpswd" tabindex="5" class="form-control" name="userpswd" data-toogle="tooltip" placeholder="Enter Password Variable">
                                        </div>

                                    </div>

                                    <div class="col-md-3">

                                        <div class="form-group">
                                            <label class="control-label">Value </label>
                                            <input type="password" id="pwdvalue1"   tabindex="6" class="form-control" name="pwdvalue1" data-toogle="tooltip" placeholder="Enter Password">
                                        </div>

                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-3">

                                        <div class="form-group">
                                            <label class="control-label">APIuser ID(variable) </label>
                                            <input type="text" id="userID" tabindex="7" class="form-control" name="userID" data-toogle="tooltip" placeholder="Enter APIUser ID Variable">
                                        </div>

                                    </div>

                                    <div class="col-md-3">

                                        <div class="form-group">
                                            <label class="control-label">Value </label>
                                            <input type="text" id="uidvalue"   tabindex="8" class="form-control" name="uidvalue" data-toogle="tooltip" placeholder="Enter API ID">
                                        </div>

                                    </div>
                                    <div class="col-md-6">

                                        <div class="form-group">
                                            <label class="control-label">Active </label>
                                            <select class="form-control" tabindex="9" id="active4" name="active4" >
                                                <option value="-1">-- Please Select--</option>
                                                <option value="Yes">Yes</option>
                                                <option value="No">No</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">                                 
                                    <div class="col-md-6">

                                        <div class="form-group">
                                            <label class="control-label">Contact Variable </label>
                                            <input type="text" id="cname"  maxlength="16" tabindex="10"  class="form-control" name="cname" data-toogle="tooltip" placeholder="Enter Contact variable">
                                        </div>

                                    </div>

                                    <div class="col-md-6">

                                        <div class="form-group">
                                            <label class="control-label">Message Variable </label>
                                            <input type="text" id="text1" tabindex="11" class="form-control" name="text1"  data-toogle="tooltip" placeholder="Enter Message Variable">
                                        </div>

                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-6">
                                        <div  class="col-md-6" >
                                            <div  class="form-group">
                                                <input  type="button" tabindex="12" style="margin-left: 111px;" onclick="AddFunc()" class="btn btn-primary m-t-10" id="add" name="add" value="Add">
                                            </div>
                                        </div>

                                    </div>

                                </div>

								 
                                 <div  class="col-md-6" id="other1" style="display:none;">
                                    <div class="form-group"  >

                                        <div  class="col-md-12">
                                            <input type="text"   tabindex="1" id="otherinput1" name="otherinput1" placeholder="Enter text">
                                        
                                            <input type="text"  tabindex="1" id="otherinput2" name="otherinput2" placeholder="Enter text">
                                        </div>     
                                    </div>
                                </div>
                               

                                <div  class="col-md-6" id="other2" style="display:none;">
                                    <div class="form-group"  >

                                        <div  class="col-md-12">
                                            <input type="text" tabindex="1" id="otherinput3" name="otherinput3" placeholder="Enter text">
                                        
                                            <input type="text" tabindex="1" id="otherinput4" name="otherinput4" placeholder="Enter text">
                                        </div>     
                                    </div>
                                </div>
                               
 							
                                <div  class="col-md-6" id="other3" style="display:none;">
                                    <div class="form-group"  >

                                        <div  class="col-md-12">
                                            <input type="text"   tabindex="1" id="otherinput5" name="otherinput5" placeholder="Enter text">
                                        
                                            <input type="text"  tabindex="1" id="otherinput6" name="otherinput6" placeholder="Enter text">
                                        </div>     
                                    </div>
                                </div>
                                <div  class="col-md-6" id="other4" style="display:none;">
                                    <div class="form-group"  >

                                        <div  class="col-md-12">
                                            <input type="text" tabindex="1" id="otherinput7" name="otherinput7" placeholder="Enter text">
                                   
                                            <input type="text" tabindex="1" id="otherinput8" name="otherinput8" placeholder="Enter text">
                                        </div>     
                                    </div>
                                </div>
                                <div  class="col-md-6" id="other5" style="display:none;">
                                    <div class="form-group"  >

                                        <div  class="col-md-12">
                                            <input type="text"  tabindex="1" id="otherinput9" name="otherinput9" placeholder="Enter text">
                                      
                                            <input type="text"  tabindex="1" id="otherinput10" name="otherinput10" placeholder="Enter text">
                                        </div>     
                                    </div>
                                </div>


                                
                                   
                                <div class="col-md-12">
                                    <br>
                                    <center> 
                                        <button type="submit" tabindex="13" class="btn btn-primary m-t-10" id="submit-btnSMS" name="submit" >Submit</button>

                                        <input type="reset" tabindex="14" class="btn btn-primary m-t-10" id="resetbtnSMS" name="reset" value="Reset">
                                        <button type="submit" id="c" tabindex="15" class="btn btn-primary m-t-10" name="test_button1" >Test</button>
                                        <!--                                                    <button id="test_button1" type="Test"  data-style="expand-right" class="btn btn-primary m-t-10 ladda-button float-right"><span tabindex="6" class="ladda-label">Test</span></button>-->
                                    </center> 

                                </div>
                                
                          
                            </div>
                        </div>
                            </div>
                             <div class="col-md-1"></div>
                </div>
                <br>
                 <div class="row">
                                <div class="col-md-1"></div>
                                <div class="col-md-10">
                <div class="card card-secondary">
                                    <div class="card-header">SMS Configuration Details</div>
                                    <div class="card-body">
<!--                  <div id="eeeew"> -->

                            <table class="table table1 table-striped"  id="datatype" style="width:100%">
                                <thead>
                                    <tr>
                                           <th>Sr No</th>
                                           <th>Company </th>
                                        <th>API Name</th>
                                        <th>URL</th>
                                        <th>Parameter</th>
                                        <th>Active</th>
                                        
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
                 
                 


    <div class="modal fade bs-example-modal-lg modal-default1111" id="smstest" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
        
         <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header bg-secondary">
                                     <h4 class="modal-title" id="myLargeModalLabel">Send SMS</h4>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close" style="margin-right:10px">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                   

                </div>
                <div class="modal-body">


                                    <div class="row">
                                        <div class="col-md-2"></div>
                                        <div class="col-md-8" >
                                           <div class="row">
                                                    <div class="col-12">

                                                        <div class="col-md-6">

                                                            <label for="tomail1" >URL</label>
                                                            <div class="form-group" id="tmail">
                                                                <!--                                            <input type="text" tabindex="2" placeholder="Enter to Contact number" class="form-control" style="width: 250%; margin-center: 20%; margin-right: 5%;" id="tomailsms" name="tomailsms"/>-->
                                                                <textarea class="form-control" rows="5" style="width: 250%;" id="tomailsms" name="tomailsms">  </textarea>
                                                            </div>
                                                        </div>
                                                    </div></div>
                                                    <div class="row">
                                                    <div class="col-12">
                                                         <div class="col-md-3">

                                                            <label for="contact3" >Contact Number</label>
                                                            <div class="form-group" id="contact4" >
                                                                <!--                                            <input type="text" tabindex="2" placeholder="Enter to Contact number" class="form-control" style="width: 250%; margin-center: 20%; margin-right: 5%;" id="tomailsms" name="tomailsms"/>-->
                                                                <input type="text" class="form-control" rows="5" style="width: 250%;" onchange="Numbermob()" id="contact" name="contact"/>  
                                                            </div>
                                                        </div>
                                                       
                                                        

                                                    </div>
                                                </div>
                                            
                                                <div class="row">
                                                    <div class="col-12">
                                                         <div class="col-md-3">

                                                            <label for="msg3" >Text Message</label>
                                                            <div class="form-group" id="msg4" >
                                                                <!--                                            <input type="text" tabindex="2" placeholder="Enter to Contact number" class="form-control" style="width: 250%; margin-center: 20%; margin-right: 5%;" id="tomailsms" name="tomailsms"/>-->
                                                                <input type="text" class="form-control" rows="5" style="width: 250%;" onchange="NewText()" id="message" name="message"/>  
                                                            </div>
                                                        </div>
                                                       
                                                        

                                                    </div>
                                                </div>
                                            
                                            
                                        </div>
                                    </div>
                                   <div class="row">
                                            <div class="col-md-6">
                                                <input type="hidden" id="sr_no" name="sr_no" value=""/>
                                            </div>
                                        </div>

                                    <br>
                                    <div class="row">
                                     <div class="col-md-6">
                                            <center>
                                                <button id="send_btn" style="margin-left: 25px" type="submit"  data-style="expand-right" class="btn btn-primary m-t-10 "><span tabindex="6" class="ladda-label">Send</span></button>
<!--                                                <button id="cancelbtn" type="Cancel"  data-style="expand-right" class="btn btn-primary m-t-10 ladda-button float-right"><span tabindex="6" class="ladda-label">Cancel</span></button>-->
                                                <!--                                         <input type="cancel" tabindex="7" class="btn btn-primary m-t-10" id="cancelbtn" name="cancelbtn" value="Cancel">-->


                                            </center>
                                            </div>
                                        </div>


                                </div>

            <!--</form>-->



        </div>

    </div>
    <!-- /.modal-content -->
</div>
<!-- /.modal-dialog -->
   </div> 
   
	

    <div class="modal fade bs-example-modal-lg modal-default1111" id="modelmailmaster1" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
      
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header bg-secondary">
                                     <h4 class="modal-title" id="myLargeModalLabel">Update Mail Configuration</h4>
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-label="Close" style="margin-right:10px">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                   

                </div>
                <div class="modal-body">
                    <!--<form action="">-->
			
			
                     <div class="row">
					 
                                            <div style="margin-top:15px;" class="col-md-6">
                                                <label for="cno" >Host </label>
                                        <input type="text" id="hostnameupdate" class="form-control" data-toogle="tooltip" style="margin-left: 0%;" placeholder="Please Enter Host Name" tabindex="8">

                                            </div>

                                            <div style="margin-top:15px;" class="col-md-6">
                                               <label for="cno" >Port </label>
                                        <input type="text" id="portnumberupdate" class="form-control" data-toogle="tooltip" style="margin-left: 0%;" placeholder="Enter Port Number" tabindex="9">

                                            </div>
                                        </div>
                                        <div class="row">
                                          
                                            <div style="margin-top:15px;" class="col-md-6">
                                                <label for="cno" >Email:</label><label id="email1"></label>
                                        <input type="text" id="emailupdate" class="form-control" data-toogle="tooltip" style="margin-left: 0%;" placeholder="Enter Email-ID" tabindex="10">
                                            
                                            </div>
                                            <div style="margin-top:15px;" class="col-md-6">
                                                 <label for="cno" >Password</label>
                                        <input type="password" id="passwordupdate" class="form-control" data-toogle="tooltip" style="margin-left: 0%;" placeholder="Enter Password" tabindex="11">
                                            </div>
                                        </div>
                                         <div class="row">
                                            <div style="margin-top:15px;" class="col-md-6">
                                                <label for="cno" >Authentication</label>
                                        <select  id="authenticationupdate" class="form-control" data-toogle="tooltip" style="margin-left: 0%;" tabindex="12">
                                            <option value=''> -- Please Select --</option>
                                            <option value='Yes'>Yes</option>
                                            <option value='No'>No</option>
                                        </select>
                                            </div>
                                           </div>
                                        
                                          <div class="row">
                                             <input type="hidden" id="sr_no1" name="sr_no1" value=""/>
                                            <div style="margin-top:15px;" class="col-md-12">
                                                <center>

 <input type="submit" class="btn btn-primary m-t-10" id="update_MailMasterType_btn" name="update_drivemonitoring_btn" value="Update" tabindex="13">



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

  <script src="<%=request.getContextPath()%>/static/custom/SMSConfig.js"></script>

</body>
     
</html>


