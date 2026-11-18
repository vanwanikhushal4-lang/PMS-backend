<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approved By Me</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/fontawesome.min.css">

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
<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
  
   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/Datepicker/css/bootstrap-datepicker.min.css"> --%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">

<%--   <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
  
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.css" type="text/css"/> --%>
    

<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}
span.vlx { 
    display:block;
   
    word-wrap:break-word;
}
 
 
  body
     {
     font-size:85% !important;
     } 
</style>


 <style>
.button1 {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 10px 10px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  font-weight:bold;
  margin: 4px 2px;
  cursor: pointer;
}

.button4 {background-color: #e7e7e7; color: black;} /* Gray */ 

</style>


 
  <script>
        <%
            String crno = request.getParameter("crno");
            System.out.println("crrrr" + crno);

           

            String tid = request.getParameter("tid");
            System.out.println("tid" + tid);

          

        %>
    </script>
    
  
 

</head>
<body class="hold-transition sidebar-mini layout-fixed">

<input type="hidden" id="crnoo" name="crnoo" value="<%=crno%>">
   
    <input type="hidden" id="tid" name="tid" value="<%=tid%>">
   

	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>
			
			<div style="padding-left: 15px; padding-right: 15px">
			
				<div class="card card-secondary border-secondary">
				
					<div class="card-header">
					<div class="row">
					<div class="col-md-4">Approved By Me
					</div>
					
					<div class="col-md-7">
					</div>
					
					<div class="col-md-1">
					<a href="<%=request.getContextPath()%>/User/ApprovedCMRegistFormDetails" >
                     <i class="fa fa-backward pull-right" style="color: white">
                     </i>
                     </a>
					</div>
					
					
					</div>
                     
                     </div>
					
					<div class="card-body">

					<div class="row">

										<div class="col-md-4"></div>
											<div class="col-md-4"
								style="margin-left: 62px; font-size: 15px; color: red;">
								<strong>Registration Form</strong>
							</div>
										<div class="col-md-4"></div>
									</div>
<br>
									<div class="row">


										<div class="col-md-4">
											<label for="compname">Name Of The Company: </label> <input
												type="text" id="compname" tabindex="1" class="form-control"
												data-toogle="tooltip" name="compname"
												placeholder="Enter Name" readonly>
										</div>

										<div class="col-md-4">
											<label for="registerno">Registration No:</label> <input
												type="text" id="registerno" tabindex="5"
												class="form-control" data-toogle="tooltip" name="registerno"
												placeholder="Enter Registration No" readonly>
										</div>

										<div class="col-md-4">
											<label for="address">Address:</label> <input type="text"
												id="address" tabindex="6" class="form-control"
												data-toogle="tooltip" name="address"
												placeholder="Enter Address" readonly>
										</div>

									</div>
<br>
									<div class="row">

										<div class="col-md-4">
											<label for="personname">Contact Person Name:</label> <input
												type="text" id="personname" class="form-control"
												data-toogle="tooltip" name="personname"
												placeholder="Enter Person Name" readonly>
										</div>

										<div class="col-md-4">
											<label for="mobno">Mobile No:</label> <input type="number"
												id="mobno" class="form-control" data-toogle="tooltip"
												name="mobno" placeholder="Enter Mobile No" readonly>
										</div>
										<div class="col-md-4">
											<label for="telpno">Telephone No:</label> <input
												type="number" id="telpno" class="form-control"
												data-toogle="tooltip" name="telpno"
												placeholder="Enter Telephone No" readonly>
										</div>



									</div><br>
									<div class="row">

										<div class="col-md-4">
											<label for="emailid">MD/CEO Email-ID:</label> <input
												type="email" id="emailid" tabindex="4" class="form-control"
												data-toogle="tooltip" name="emailid"
												placeholder="Enter Email-ID" readonly>
										</div>
										<div class="col-md-4">
											<label for="offemailid">Sales Email-ID:</label> <input
												type="email" id="offemailid" tabindex="4"
												class="form-control" data-toogle="tooltip" name="offemailid"
												placeholder="Enter Email-ID" readonly>
										</div>
										<div class="col-md-4">
											<label for="supportmail">Support Email-ID:</label> <input
												type="text" id="supportmail" tabindex="3" class="form-control"
												data-toogle="tooltip" name="city"
												placeholder="Enter Email-ID " readonly>
										</div>

									</div>
<br>
									<div class="row">

										<div class="col-md-4">
											<label for="copersonemailid">Email-ID Contact Person:</label> <input
												type="text" id="copersonemailid" tabindex="4" class="form-control"
												data-toogle="tooltip" name="emailid"
												placeholder="Enter Email-ID" readonly>
										</div>
										<div class="col-md-4">
											<label for="offemailids">Email-ID (Office):</label> <input
												type="text" id="offemailids" tabindex="4"
												class="form-control" data-toogle="tooltip" name="offemailids"
												placeholder="Enter Email-ID (Office)" readonly>
										</div>
										<div class="col-md-4">
											<label for="city">City:</label> <input type="text" id="city"
												tabindex="3" class="form-control" data-toogle="tooltip"
												name="city" placeholder="Enter City" readonly>
										</div>

									</div>
<br>
									<div class="row">

										<div class="col-md-4">
											<label for="district">District:</label> <input type="text"
												id="district" tabindex="4" class="form-control"
												data-toogle="tooltip" name="district"
												placeholder="Enter District" readonly>
										</div>
										<div class="col-md-4">
											<label for="state">State:</label> <input type="text"
												id="state" tabindex="4" class="form-control"
												data-toogle="tooltip" name="state" placeholder="Enter State" readonly>
										</div>
										<div class="col-md-4">
											<label for="pincode">Pin:</label> <input type="number"
												id="pincode" tabindex="3" class="form-control"
												data-toogle="tooltip" name="pincode"
												placeholder="Enter Pin Code" readonly>
										</div>

									</div>
<br>
									<div class="row">

										<div class="col-md-4">
											<label for="Country">Country:</label>

											<!-- 											<input type="text" -->
											<!-- 												id="country" tabindex="4" class="form-control" -->
											<!-- 												data-toogle="tooltip" name="country" placeholder="Enter Country"> -->

											<input type="text" id="country" class="form-control" tabindex="6"
												data-toogle="tooltip" name="country" readonly>
										
										</div>
										<div class="col-md-4">
											<label for="website">Website:</label> <input type="text"
												id="website" tabindex="4" class="form-control"
												data-toogle="tooltip" name="website"
												placeholder="Enter Website" readonly>
										</div>
										<div class="col-md-4">
											<label for="panacno">PAN No:</label> <input type="text"
												id="panacno" tabindex="4" class="form-control"
												data-toogle="tooltip" name="panacno"
												placeholder="Enter PAN Card No" readonly>
										</div>

									</div>

<br>
									<div class="row">

										<div class="col-md-4">
											<label for="ownership">Ownership Type:</label> <input type="text"
												id="ownership" class="form-control" tabindex="6"
												data-toogle="tooltip" name="ownership" readonly>
												
										</div>
										<div class="col-md-4">
											<label for="scaleofcmpy">Scale Of Company:</label> 
											<input type="text"
												id="scaleofcmpy" class="form-control" tabindex="6"
												data-toogle="tooltip" name="scaleofcmpy" readonly>
												
											
										</div>
										<div class="col-md-4" id="indiacountrytax">
											<label for="gstin">GSTIN:</label> <input type="text"
												id="gstin" tabindex="4" class="form-control"
												data-toogle="tooltip" name="gstin" placeholder="Enter GSTIN" readonly>
										</div>
										<div class="col-md-4" id="othercountrytax"
											style="display: none">
											<label for="cuntrytaxno">Other Country Tax No:</label> <input
												type="text" id="cuntrytaxno" tabindex="3" class="form-control"
												data-toogle="tooltip" name="cuntrytaxno"
												placeholder="Enter Other Country Tax" readonly>
										</div>

									</div>
								
								</div>
                                         
                                          

                                    <br>
                                        <div class="row">
          <div class="col-md-12">
           
              
                <ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
                  <li class="nav-item">
                    <a class="nav-link active" id="custom-tabs-one-home-tab" data-toggle="pill" href="#custom-tabs-one-home" role="tab" aria-controls="custom-tabs-one-home" aria-selected="true">Details</a>
                  </li>
                  
                  <li class="nav-item">
                    <a class="nav-link" id="custom-tabs-one-messages-tab" data-toggle="pill" href="#custom-tabs-one-messages" role="tab" aria-controls="custom-tabs-one-messages" aria-selected="false">Downloads</a>
                  </li>
                  
<!--                    <li class="nav-item"> -->
<!--                     <a class="nav-link" id="custom-tabs-one-calls-tab" data-toggle="pill" href="#custom-tabs-one-calls" role="tab" aria-controls="custom-tabs-one-calls" aria-selected="false">Form 3</a> -->
<!--                   </li> -->
                 
                </ul>
             
             
                <div class="tab-content">
                  <div class="tab-pane fade show active" id="custom-tabs-one-home" role="tabpanel" aria-labelledby="custom-tabs-one-home-tab">
                     <br>
                     <div class="row">
                                                <div class="col-md-1" ></div>
                                                <div class="col-md-10" >

                                               
                                        
                                        			<div class="row">


										<div class="col-md-3">
											<label for="dateofbussns">Date of Commencement of
												Business:</label>

										</div>
										<div class="col-md-3">
											<input type="date" id="dateofbussns" tabindex="4"
												class="form-control" data-toogle="tooltip"
												name="dateofbussns" readonly>
										</div>
										<div class="col-md-2">
											<!-- 											<label for="vatgstcategory">VAT-GST Category:</label> -->

										</div>
										<div class="col-md-3">
											<!-- 											<input type="text" id="vatgstcategory" tabindex="4" -->
											<!-- 												class="form-control" data-toogle="tooltip" -->
											<!-- 												name="vatgstcategory" placeholder="Enter Category"> -->
										</div>
										<div class="col-md-1"></div>

									</div>
									<br> <br>

						

									<div class="row">

										<div class="col-md-4"></div>

										<div class="col-md-4" style="font-size: 14px; color: red;">
											<strong>Annual Turnover for the Last Three Years:</strong>
										</div>
										<div class="col-md-4"></div>
									</div>
									<br>

									<div class="row">
										<div class="col-md-1 ">
											<label for="currency">Currency:</label>

										</div>
										<div class="col-md-3 ">

											<input id="currency" class="form-control" tabindex="6"
												data-toogle="tooltip" name="currency" readonly>
											

										</div>
										<div class="col-md-3 "></div>
										<div class="col-md-3 "></div>
										<div class="col-md-2 "></div>

									</div>
									<br>



									<div class="row">
										<div class="col-md-1 ">
											<label for="year">Year:&nbsp;&nbsp;</label>

										</div>
										<div class="col-md-3 ">

											<input type="text" id="year1" name="nonregistered"
												class="form-control" tabindex="10" placeholder="Enter Year1" readonly>
											<label for="year" ></label>

										</div>
										<div class="col-md-3 ">

											<input type="text" id="year2" name="nonregistered"
												class="form-control" tabindex="10" placeholder="Enter Year2" readonly>
											<label for="year"></label>
										</div>
										<div class="col-md-3 ">

											<input type="text" id="year3" name="nonregistered"
												class="form-control" tabindex="10" placeholder="Enter Year3" readonly>
											<label for="year"></label>
										</div>
										<div class="col-md-2 "></div>

									</div>
									<br>

									<div class="row">
										<div class="col-md-1 ">
											<label for="rupees">Amount:&nbsp;&nbsp;</label>

										</div>
										<div class="col-md-3 ">

											<input type="text" id="rupees1" name="nonregistered"
												class="form-control" tabindex="10"
												placeholder="Enter Year1 Amount" readonly> <label for="year"></label>

										</div>
										<div class="col-md-3 ">

											<input type="text" id="rupees2" name="nonregistered"
												class="form-control" tabindex="10"
												placeholder="Enter Year2 Amount" readonly> <label for="year"></label>
										</div>
										<div class="col-md-3 ">

											<input type="text" id="rupees3" name="nonregistered"
												class="form-control" tabindex="10"
												placeholder="Enter Year3 Amount" readonly> <label for="year"></label>
										</div>
										<div class="col-md-2 "></div>

									</div>
									<br>
								      
                                                <div class="row">
										<div class="col-md-3">

											<label>Are you registered in GEM Portal?:</label>

										</div>
										<div class="col-md-3">
											<input type="text" id="gemportal1" name="gemportal"
												class="form-control" readonly> 
												
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-3"> </div>

									</div>
									<br>

									<div class="row">
										<div class="col-md-3">

											<label>Are you MSMED Registered?:</label>

										</div>
										<div class="col-md-3">
											<input type="text" id="msmedreg1" name="msmed" 
											class="form-control" readonly	>   
										
										</div>
										<div class="col-md-3"></div>
										<div class="col-md-3"> </div>

									</div>
									<br>

									<div class="row" id="msmedeclrn" style="display: none">

										<div class="col-md-2"></div>

										<div class="col-md-8" style="font-size: 14px; color: red;">
											<strong>Declaration "MSMED" (Micro,Small and Medium
												Enterprise Development):</strong>
										</div>
										<div class="col-md-2"></div>
									</div>
									<br>
									<div class="row" id="msmedyestype" style="display: none">
										<div class="col-md-3">

											<label>If YES, Type:</label>

										</div>
										<div class="col-md-4">
											<input type="radio" id="msmedtype1" name="msmedtype"
												value="Micro">   <label for="msmedtype1">Micro</label>
											&nbsp;&nbsp;&nbsp; <input type="radio" id="msmedtype2"
												name="msmedtype" value="Small">   <label
												for="msmedtype2">Small</label> &nbsp;&nbsp;&nbsp;<input
												type="radio" id="msmedtype3" name="msmedtype" value="Medium">
											  <label for="msmedtype3">Medium</label>
										</div>
										<div class="col-md-2"></div>
										<div class="col-md-3"> </div>

									</div>
									<br>

									<div class="row">
										<div class="col-md-4">
											<label for="entrepreno">Entrepreneur Memorandum (EM
												No. ):</label>

										</div>
										<div class="col-md-4 ">
											<input type="text" id="entrepreno" tabindex="4"
												class="form-control" data-toogle="tooltip" name="entrepreno"
												placeholder="Enter EM No" readonly>
										</div>
										<div class="col-md-4 "></div>

									</div>
									<br><br><br>
                                        </div>
                                    
										
                                           
                                                    
                                              
                                                <div class="col-md-1" ></div>   
                                           
                                 </div>
                                 <br>
                                           
                                      
                  </div>
              
                  <div class="tab-pane fade" id="custom-tabs-one-messages"  role="tabpanel" aria-labelledby="custom-tabs-one-messages-tab">
                     
                             
                                                <br>
                                                <div class="row">
                                                    
                                                    <div class="col-md-1" ></div>
                                                <div class="col-md-10" >
                              
                                                
                                                
                                                
                                          

									<div class="row">

										<div class="col-md-2"></div>

										<div class="col-md-8" style="font-size: 14px; color: red;">
											<strong>Copies of Documents :</strong>
										</div>
										<div class="col-md-2"></div>
									</div>
									<br>

									<div class="row">

                              	     <div style="margin-top:15px; display:none;" class="col-md-6" id="poUploadDiv">
                                            <label style="margin-left: 2px"> Incorporation Certificate:<br>
                                                <span class="vlx" style="color: green;width: 450px" id="pouploadfile"></span></label><button class="button1 button4" id="downHidepofile" onclick="downFileStandard()">Download</button>
                                        </div>
                                        <input type="hidden" id="filenameStandard" name="filenameStandard">
										
										  <div style="margin-top:15px; display:none;" class="col-md-6" id="pancrdDiv">
                                            <label style="margin-left: 2px"> Pan Card:<br>
                                                <span class="vlx" style="color: green;width: 450px" id="pancardfile"></span></label><button class="button1 button4" id="downHidepancardfile" onclick="downpancradFileStandard()">Download</button>
                                        </div>
                                        <input type="hidden" id="pancardfilenameStandard" name="pancardfilenameStandard">
									
									</div>
									<br>
									<div class="row">
									
									

									   <div style="margin-top:15px; display:none;" class="col-md-6" id="gstUploadDiv">
                                            <label style="margin-left: 2px"> GST Certificate:<br>
                                                <span class="vlx" style="color: green;width: 450px" id="gstuploadfile"></span></label><button class="button1 button4" id="downHidegstfile" onclick="downgstFileStandard()">Download</button>
                                        </div>
                                        <input type="hidden" id="gstfilenameStandard" name="gstfilenameStandard">
										
										  <div style="margin-top:15px; display:none;" class="col-md-6" id="mesmedDiv">
                                            <label style="margin-left: 2px"> MSMED:<br>
                                                <span class="vlx" style="color: green;width: 450px" id="msmedfile"></span></label><button class="button1 button4" id="downHidemsmedfile" onclick="downmsmedFileStandard()">Download</button>
                                        </div>
                                        <input type="hidden" id="msmedfilenameStandard" name="msmedfilenameStandard">
									

									</div>
									<br>
									<div class="row">

									   <div style="margin-top:15px; display:none;" class="col-md-6" id="cancCheqUploadDiv">
                                            <label style="margin-left: 2px"> Cancelled Cheque:<br>
                                                <span class="vlx" style="color: green;width: 450px" id="cancChequploadfile"></span></label><button class="button1 button4" id="downHidecancCheqfile" onclick="downcancCheqFileStandard()">Download</button>
                                        </div>
                                        <input type="hidden" id="cancCheqfilenameStandard" name="cancCheqfilenameStandard">
										
										  <div style="margin-top:15px; display:none;" class="col-md-6" id="lstBSPLDiv">
                                            <label style="margin-left: 2px">Last Year BS AND P&L:<br>
                                                <span class="vlx" style="color: green;width: 450px" id="lstBSPLfile"></span></label><button class="button1 button4" id="downHidelstBSPLfile" onclick="downlstBSPLFileStandard()">Download</button>
                                        </div>
                                        <input type="hidden" id="lstBSPLfilenameStandard" name="lstBSPLfilenameStandard">
									
										

									</div>
									
									
									<br>
									<div class="row">
									
									
									
									
									   <div style="margin-top:15px; display:none;" class="col-md-6" id="msmedPartnUploadDiv">
                                            <label style="margin-left: 2px"> MSMED Documents: (Only for MSMED registered Partners)<br>
                                                <span class="vlx" style="color: green;width: 450px" id="msmedPartnuploadfile"></span></label><button class="button1 button4" id="downHidemsmedPartnfile" onclick="downmsmedPartnFileStandard()">Download</button>
                                        </div>
                                        <input type="hidden" id="msmedPartnfilenameStandard" name="msmedPartnfilenameStandard">
									
									
										

									
									</div>
									<br>


									<div class="row">
										<div class="col-md-6" style="margin-top: 15px;">
										
                               <label for="Authorizer">Authorizer</label> 
                               
                               <input type="text" id="Authorizer"
												class="form-control" tabindex="8" data-toogle="tooltip"
												name="Authorizer" readonly>
												
										</div>

										<div class="col-md-6" style="margin-top: 15px;">
											

										</div>
									</div>
									<br>
									<br>
<!-- 									<div class="row"> -->

<!-- 										<div class="col-md-2"></div> -->


<!-- 										<div class="col-md-8"> -->
<!-- 											<input type="checkbox" name="ideclaration" id="ideclaration" -->
<!-- 												value="Yes">&nbsp;&nbsp;, <label for="ideclaration">I -->
<!-- 												declare that the information furnished above is correct to -->
<!-- 												the best of my knowledge, I undertake to inform you at the -->
<!-- 												earliest, any change in details mentioned above.</label> -->
<!-- 										</div> -->
<!-- 										<div class="col-md-2"></div> -->

<!-- 									</div> -->
									<br>



							
							
							
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                </div>
                                                    <div class="col-md-1" ></div>
                                                </div>                   
                  </div>
                  
                  
<!--                      	 <div class="tab-pane fade" id="custom-tabs-one-calls"  role="tabpanel" aria-labelledby="custom-tabs-one-calls-tab"> -->
                     
<!--                     <br> -->
<!--                                             <div class="row"> -->
<!--                                                 <div class="col-md-1"></div> -->
<!--                                                 <div class="col-md-10"> -->
                                                
                         
                                                
                                                
                                                
                                                
                                    
<!--                                                 </div> -->
<!--                                                 <div class="col-md-1"></div> -->
<!--                                             </div> -->
<!-- 					</div> -->
					
					
					
                 
                </div>
             </div>
        
                                    
                                    </div>
                                    
                                    
                                    

                                        </div>

                                    <br>
              <!-- /.card -->
            
       

</div>
                                        

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
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<%--  <script src="<%=request.getContextPath()%>/static/resources/js/jquery.min.js"></script>
 
 <script src="<%=request.getContextPath()%>/static/resources/js/jquery-ui.min.js"></script>
 <script src="<%=request.getContextPath()%>/static/resources/Bootstrap/bootstrap.js"></script>
    
  <script src="<%=request.getContextPath()%>/static/resources/Bootstrap/bootstrap.min.js"></script> --%>
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

<!--<script src="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>-->
<!-- Tempusdominus Bootstrap 4 -->
<%-- <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>

<script src="<%=request.getContextPath()%>/static/AdminLTE_3/dist/js/demo.js"></script> --%>

<!-- Sweetalert 2 -->
<script src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
<script src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>

<%-- <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.js"></script>
    
   <script src="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.min.js"></script>

<script src="<%=request.getContextPath()%>/static/Datepicker/js/bootstrap-datepicker.min.js"></script> --%>
   
   
	<script src="<%=request.getContextPath()%>/static/custom/ViewCMapprovedRegistrationDetails.js"></script>

</body>
</html>