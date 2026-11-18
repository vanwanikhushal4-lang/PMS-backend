<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Raise Service Request</title>
   <link rel="icon" href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
  <!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--         <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"> -->
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
    <!-- Select2 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/css/select2.min.css">
  
  <style type="text/css">
  .card{
  border: 1px solid rgb(0, 123, 255) !important;
  }
  label{
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
                      <form action="insertUserRaiseTicket" id="form" name="form" method="post" enctype="multipart/form-data" >
                                <div class="card card-secondary">
                                    
                                    <div class="card-header">Raise Service Request</div>
                                    <div class="card-body">
                                                                            
                                        <div class="row">
                                            
                                                <div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Request Basic Details</strong></div>
                                                <div class="col-md-4"></div>
                                            </div>
                                        
                                        <div class="row">

                                         
                                                <div class="col-md-4">
                                                    <label for="cname">Name: </label>
                                                    <input type="text" id="name1" tabindex="1" readonly="true" class="form-control" data-toogle="tooltip" name="name1">
                                                </div>
												<div class="col-md-4">
                                                    <label for="cname">Company:</label>
                                                    <input type="text" id="compname" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="compname">
                                                </div>
<!--                                                 <div class="col-md-4"> -->
<!--                                                     <label for="cname">Date:</label> -->
<%--                                                     <input type="text" tabindex="2" id="datepicker5" value="<%=cdate%>" displayFormat="dd/mm/yy" readonly="true" class="form-control" data-toogle="tooltip" name="datepicker5" > --%>
<!--                                                 </div> -->

													<input type="hidden" id="username" name="username" >
													<input type="hidden" id="vipuser" name="vipuser" >

												<div class="col-md-4">
                                                    <label for="cname">Branch:</label>
                                                    <input type="text" id="site" tabindex="6" readonly="true" class="form-control" data-toogle="tooltip" name="site">
                                                </div>
                                               
												</div>
                                            
                                            <div class="row" >
                                            
                                            <div class="col-md-4">
                                                    <label for="cname">Department:</label>
                                                    <input type="text" id="department"  readonly="true" class="form-control" data-toogle="tooltip" name="department">
                                                </div>
                                            <div class="col-md-4">
                                                    <label for="cname">Sub-Department:</label>
                                                    <input type="text" id="sub_department"  readonly="true" class="form-control" data-toogle="tooltip" name="sub_department">
                                                </div> 
                                             <div class="col-md-4">
                                                    <label for="cname">Location:</label>
                                                    <input type="text" id="location"  readonly="true" class="form-control" data-toogle="tooltip" name="location">
                                                </div>       
                                                

                                            </div>
                                            
                                            <div class="row" >

                                                <div class="col-md-4">
                                                    <label for="cname">Email-ID:</label>
                                                    <input type="text" id="emailid" tabindex="4" readonly="true" class="form-control" data-toogle="tooltip" name="emailid">
                                                </div>
                                                 <div class="col-md-4">
                                                    <label for="cname">Contact No:</label>
                                                    <input type="text" id="phone" tabindex="3" readonly="true" class="form-control" data-toogle="tooltip" name="phone">
                                                </div>
                                                <div class="col-md-4">
<!--                                                     <label for="cname">Request Mode:</label> -->
<!--                                                    <input type="text" id="requestmode" tabindex="9" class="form-control" data-toogle="tooltip" name="requestmode" placeholder="Please Enter Request Mode" >-->
<!--                                                     <select id="requestmode" tabindex="9" class="form-control" data-toogle="tooltip" name="requestmode"> -->
<!--                                                                 <option value="">--Please Select Request Mode--</option>                                                                 -->
<!--                                                     </select> -->
                                                    
                                                </div>
                                            </div>
                                            
<%  String Company= session.getAttribute("companyname").toString();%>
									<%if(Company.equals("3i Infotech")) { %>
										<hr>
										<div class="row">
												<div class="col-md-2 ">                                                    
                                                     <label for="assetCheck">Asset Check:&nbsp;&nbsp;</label>
													<div class="icheck-primary d-inline">
													<input type="checkbox" id="assetCheck" name="assetCheck" tabindex="10">
											      	<label for="assetCheck"></label>
											         </div>
                                                </div> 
                                           
                                                 <div  class="col-md-10" id="toggleAssetCheck"  style="display: none;" >
								
                                 <label for="toggleAssetCheck">Select Assets:</label>  
                             		    <div id="AssetDiv" >
												<select class="form-control select2" id="assetid"
										 onchange="getallinformationofAsset(this.value)" 			
													data-toogle="tooltip" name="assetid">
												</select>
													
													</div>
													<label for="toggleAssetCheck"></label>
													</div>
												
											</div>
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
                                                    <input type="text" id="asset_sub_category" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="asset_sub_category">
                                                </div>



												<div class="col-md-6">
                                                    <label for="cname">Asset Ip Address:</label>
                                                    <input type="text" id="asset_Ipaddress" tabindex="5" readonly="true" class="form-control" data-toogle="tooltip" name="asset_Ipaddress">
                                                </div>
                                              
												</div>
                                            </div>
                                            </div>
                                            </div>
                                                <%}else	{} %>
                                            <hr>
                                           <!--  <div class="row">
                                           	<div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Request Category</strong></div>
                                                <div class="col-md-4"></div>
                                            </div>
                                            <div class="row" >
                                                <div class="col-md-4">
                                                    <label for="cname">Category:</label>
                                                    <select id="category" tabindex="7" class="form-control" data-toogle="tooltip" name="category" onchange="JavaScript:change_subcat1(this.value)">
                                                                <option value="">--Please Select Category--</option>                                                               
                                                    </select>
												<input type="text" class="form-control" data-toogle="tooltip" id="category" name="category" readonly>
                                                </div>

                                                <div class="col-md-4">
                                                    <label for="cname">Sub-Category1:</label>
                                                    <select id="subcat1" tabindex="8" class="form-control" data-toogle="tooltip" name="subcat1" onchange="JavaScript:change_subcat2(this.value)">
                                                                <option value="">--Please Select Sub-Category1--</option>                                                                
                                                    </select>
											<input type="text" class="form-control" data-toogle="tooltip" id="subcat1" name="subcat1" readonly>
                                                </div>
                                                
                                                 <div class="col-md-4">
                                                    <label for="cname">Sub-Category2:</label>
                                                    <select id="subcat2" tabindex="8" class="form-control" data-toogle="tooltip" name="subcat2" onchange="JavaScript:change_PriorityAndSeverity(this.value)">
                                                                <option value="">--Please Select Sub-Category2--</option>                                                                
                                                    </select>
                                                    <input type="text" class="form-control" data-toogle="tooltip" id="subcat2" name="subcat2" readonly>
                                                </div>
                                                

                                            </div>
                                           
                                           <hr> -->
                                           <%
										if (Company.equals("3i Infotech")) {
									%>
									<div class="row">

										<div class="col-md-5"></div>
	
										<div class="col-md-4" style="font-size: 14px; color: red;">
											<strong>Select Subject Type</strong>
										</div>
										<div class="col-md-4"></div>
									</div>

<%-- 								<% String companyName = request.getAttribute("companyname").toString();--%>

									
									<div class="row">
										<div class="col-md-4">
											<label>Subject Type(Optional):</label> <select
												class="form-control" id="subtype">
												<option value="NA">-- Please Select --</option>
												<option value= "IT">IT Request</option>
												<option value="Admin">ADMIN Request</option>
												<option value="Hr">HR Request</option>
												
											</select>
										</div>
										<div class="col-md-8"></div>
									</div>
									<br>

									<%
										} else {
										}
									%>

									<!-- <div class="row">
                                           
                                                <div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Request Description</strong></div>
                                                <div class="col-md-4"></div>
                                            </div> -->
                                        
                                        <div class="row">                                   
                                                <div class="col-md-10">
                                                    <label for="cname">Subject:</label>
<!--                                                     <input type="text" id="sub" tabindex="11" class="form-control" data-toogle="tooltip" name="sub" placeholder="Please Enter Subject" > -->
											<div id="subjectDiv">
											 <select class="form-control select2" id="sub" name="sub" onchange="JavaScript:getalldata(this.value)">
												</select></div>
                                                </div> 
                                               <div class="col-md-2"></div>
                                            </div>
                                            
                                             <div class="row">
                                           	<div class="col-md-5"></div>
                                                <div class="col-md-4 mt-3" style="font-size: 14px;color: red;"><strong>Request Category</strong></div>
                                                <div class="col-md-4"></div>
                                            </div>
                                            <div class="row" >
                                                <div class="col-md-4">
                                                    <label for="cname">Category:</label>
<!--                                                     <select id="category" tabindex="7" class="form-control" data-toogle="tooltip" name="category" onchange="JavaScript:change_subcat1(this.value)"> -->
<!--                                                                 <option value="">--Please Select Category--</option>                                                                -->
<!--                                                     </select> -->
												<input type="text" class="form-control" data-toogle="tooltip" id="category" name="category" readonly>
                                                </div>

                                                <div class="col-md-4">
                                                    <label for="cname">Sub-Category1:</label>
<!--                                                     <select id="subcat1" tabindex="8" class="form-control" data-toogle="tooltip" name="subcat1" onchange="JavaScript:change_subcat2(this.value)"> -->
<!--                                                                 <option value="">--Please Select Sub-Category1--</option>                                                                 -->
<!--                                                     </select> -->
											<input type="text" class="form-control" data-toogle="tooltip" id="subcat1" name="subcat1" readonly>
                                                </div>
                                                
                                                 <div class="col-md-4">
                                                    <label for="cname">Sub-Category2:</label>
<!--                                                     <select id="subcat2" tabindex="8" class="form-control" data-toogle="tooltip" name="subcat2" onchange="JavaScript:change_PriorityAndSeverity(this.value)"> -->
<!--                                                                 <option value="">--Please Select Sub-Category2--</option>                                                                 -->
<!--                                                     </select> -->
                                                    <input type="text" class="form-control" data-toogle="tooltip" id="subcat2" name="subcat2" readonly>
                                                </div>
                                                

                                            </div>
                                           
                                           <hr>
                                       <!--                                                                                                                                                                                   
                                            <div class="row" >
                                                <div class="col-md-10">
                                                    <label for="cname">Description:</label>
                                                    <textarea type="text" rows="5" cols="20" id="description"  tabindex="12" class="form-control" data-toogle="tooltip" name="description" placeholder="Please Enter Description" maxlength="2000"
												onkeyup="characterCounter()"></textarea>
												<span id="note"
												style="font-size: 12px" class="text-danger">Description 
												length must be Min 1 characters & Max 2000 characters. </span>
												<br><span id="counterSpan" class="text-danger" style="display: none">												
												Remaining Characters are <span id="calulateId"></span>
												</span>
                                                </div>
                                                <div class="col-md-2"></div>                                                
                                            </div> -->
                                            
                                            <div class="row" >
                                                <div class="col-md-5">
                                                    <label for="cname">Priority:</label>
                                                    <input type="text" id="priority" tabindex="13" class="form-control" data-toogle="tooltip" name="priority" readonly>
<!--                                                     <select id="priority" tabindex="13" class="form-control" data-toogle="tooltip" name="priority"> -->
<!-- 													</select> -->
                                                </div> 
                                                <div class="col-md-5">
                                                    <label for="cname">Severity:</label>
                                                    <input type="text" id="severity" tabindex="14" class="form-control" data-toogle="tooltip" name="severity" readonly>
<!--                                                     <select id="severity" tabindex="14" class="form-control" data-toogle="tooltip" name="severity"> -->
<!-- 													</select> -->
                                                </div> 
                                               <div class="col-md-2"></div>
                                            </div>
                                            
                                            
                                            <div class="row" >
                                                <div class="col-md-5">
                                                    <label for="requesttype">Service Request Type:</label>
                                                    <input type="text" id="requesttype" tabindex="13" class="form-control" data-toogle="tooltip" name="requesttype" readonly>
<!--                                                     <select id="priority" tabindex="13" class="form-control" data-toogle="tooltip" name="priority"> -->
<!-- 													</select> -->
                                                </div> 
                                                <div class="col-md-5" id="groupnamediv"  style="display: none">
                                                    <label for=groupname>Processing Group</label>
                                                    <input type="text" id="groupname" tabindex="13" class="form-control" data-toogle="tooltip" name="groupname" readonly>
<!--                                                     <select id="priority" tabindex="13" class="form-control" data-toogle="tooltip" name="priority"> -->
<!-- 													</select> -->
                                                </div> 
                                               
                                               <div class="col-md-2"></div>
                                            </div>
                                            
                                            
                                            <div class="row" >
                                                 <div class="col-md-5"  id="designationlevel1div"style="display: none">
                                                    <label for="designationlevel1">Designation Level 1:</label>
                                                    <input type="text" id="designationlevel1" tabindex="14" class="form-control" data-toogle="tooltip" name="designationlevel1" readonly>
<!--                                                     <select id="severity" tabindex="14" class="form-control" data-toogle="tooltip" name="severity"> -->
<!-- 													</select> -->
                                                </div> 
                                                
                                                <div class="col-md-5"  id="username1div" style="display: none">
                                                    <label for="username1">Users:</label>
                                                    <select type="text" id="username1" tabindex="14"  onchange="getothersdata(this.value)"  class="form-control" data-toogle="tooltip" name="username1" >
                                                    <option value="">--Please Select--</option>
                                                    </select>
<!--                                                     <select id="severity" tabindex="14" class="form-control" data-toogle="tooltip" name="severity"> -->
<!-- 													</select> -->
                                                </div> 
                                               <div class="col-md-2"></div>
                                               
                                               </div>
                                              
                                              <!--  CODE FOR GET  ASSIGN USER DATA STRAT -->
                                            <div id="Hideotherdata" style="display:none">
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
                                               
                                            </div>
                                            <br>
                                            
                                            <div class="row">
                                           
                                                <div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Request Description</strong></div>
                                                <div class="col-md-4"></div>
                                            </div>
                                                                                                                                                                                                                              
                                            <div class="row" >
                                            
                                                <div class="col-md-10 ml-4" >
                                                    <label for="cname">Description:</label>
                                                    <textarea  type="text" rows="5" cols="20" id="description"  tabindex="12" class="form-control" data-toogle="tooltip" name="description" placeholder="Please Enter Description" maxlength="2000"
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


										<div class="col-md-4 ml-4">
											<label>Browse File:</label> <input id="empPic" name="empPic"
												tabindex="14" type="file" aria-describedby="nameHelp">
										</div>

										<div class="col-md-8"></div>
									</div>
                                           
                                            <!--  CODE FOR GET  ASSIGN USER DATA END -->
                                            
                                            <input  type="hidden" name="approve_level"  readonly="readonly" id="approve_level"/>
                                               <input  type="hidden" name="requestcost"  readonly="readonly" id="requestcost"/>
											  <input  type="hidden" name="designationlevel2"  readonly="readonly" id="designationlevel2"/>
											
                                        <br>
                                        <div class="row" style="display:none">
                                           
                                                <div class="col-md-5"></div>
                                                <div class="col-md-4" style="font-size: 14px;color: red;"><strong>Attachments (Optional)</strong></div>
                                                <div class="col-md-4"></div>
                                           </div>
                                        
                                        <div class="row" style="display:none">

                                         
                                                <div class="col-md-4">                                                    
                                                    <label>Browse File:</label>
                                                        <input id="empPic" name="empPic" tabindex="14" type="file" aria-describedby="nameHelp" >
                                                </div> 
                                               
                                               <div class="col-md-8"></div>
                                            </div>
                                                                                                                                                                                                                                                                     

                                       
                                    <!--</form>-->
                                        <br>
                                        <div class="row">
                                        <div class="col-md-12">
                                        <center>
                                            <input type="button" tabindex="15" class="btn btn-primary m-t-10" id="raise-btn" name="submit" value="Raise" onclick="submitbutton101()">
                                                <input type="button" tabindex="16" class="btn btn-primary m-t-10" id="resetbtn" name="reset" value="Reset">
                                            </center>
                                            </div>
                                            </div>
                                           <br>
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
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/static//AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
 <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery/dist/jquery.min.js"></script>
 
 <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery-ui/jquery-ui.min.js"></script>
 <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script>
    
  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script>
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
     
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/select2/js/select2.min.js"></script>
     
     
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

  <script src="<%=request.getContextPath()%>/static/custom/raiseservicerequestcatalogue.js"></script>
</body>
     
</html>


