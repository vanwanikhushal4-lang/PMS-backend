<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FORMC Submitted Details</title>
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
					<div class="col-md-4">FORMC Submitted Details
					</div>
					
					<div class="col-md-7">
					</div>
					
					<div class="col-md-1">
					<a href="<%=request.getContextPath()%>/User/getFORM3SubmitteddBySupportManager" >
                     <i class="fa fa-backward pull-right" style="color: white">
                     </i>
                     </a>
					</div>
					
					
					</div>
                     
                     </div>
					
					<div class="card-body">

					<div class="row">
						  <div style="margin-top:15px;" class="col-md-6">
                                       <label>PO Number :</label>
											<div id="ponumb"></div> 
											 <input
												type="text" id="PONumb" tabindex="4" class="form-control"
												data-toogle="tooltip" name="PONumb" placeholder="Enter your PO Number"  readonly>

                                    </div>


                                    <div style="margin-top: 15px;" class="col-md-6">
										<label >Date : </label>
											<div id="date1"></div> 
											<input
												type="text" id="date" tabindex="1" class="form-control"
												data-toogle="tooltip" name="date" readonly>
									</div>
<!--                                     <div style="margin-top:15px;" class="col-md-6"> -->
<!--                                  <label >Project Implementor Name :</label> -->
<!-- 											<div id="impl1"></div>  -->
<!-- 											 <input -->
<!-- 												type="text" id="projeimplementorname" tabindex="2" -->
<!-- 												class="form-control" data-toogle="tooltip" name="projeimplementorname" placeholder="Enter Your Project Implementor Name Here " readonly> -->
										
<!-- 									 </div> -->
                                    <div style="margin-top:15px;" class="col-md-6">
                                  	<label >Customer Name :</label>
											<div id="Customer1"></div> 
											 <input
												type="text" id="customername" 
												class="form-control" data-toogle="tooltip" name="customername" placeholder="Enter Your Customer Name Here " readonly>
										
											
											 </div>
											   <div style="margin-top:15px;" class="col-md-6">
                                  	<label >Product License :</label>
											<div id="ProductLic1"></div> 
											 <input
												type="text" id="productLicense" 
												class="form-control" data-toogle="tooltip" name="productLicense" placeholder="Enter Your Product License  " readonly>
										
											
											 </div>
											 
																		                      <!-- //// new  -->
                                 
							    <div style="margin-top: 15px;" class="col-md-6">
								<label>Customer Implementor Name:</label>
								<div id=""></div>
								<input type="text" id="ImplementorName" class="form-control"
									data-toogle="tooltip" name="ImplementorName"
									placeholder="Enter Your Customer Implementor Name " readonly>

							  </div>
							  
							  <div style="margin-top: 15px;" class="col-md-6">
								<label>Customer Implementor Contact :</label>
								<div id=""></div>
								<input type="text" id="ImplementorNumber" class="form-control"
									data-toogle="tooltip" name="ImplementorNumber"
									placeholder="Enter Your Customer Implementor Contact " readonly>

							  </div>
							  
							  
							   <div style="margin-top: 15px;" class="col-md-6">
								<label>Customer Implementor Email :</label>
								<div id=""></div>
								<input type="text" id="cusImplementorEmail" class="form-control"
									data-toogle="tooltip" name="cusImplementorEmail"
									placeholder="Enter Your Customer Implementor Email " readonly>

							  </div>
							  
							  
							   <div style="margin-top: 15px;" class="col-md-6">
								<label>Sales Manager Name:</label>
								<div id=""></div>
								<input type="text" id="SalesManagerName" class="form-control"
									data-toogle="tooltip" name="SalesManagerName"
									placeholder="Enter Your Sales Manager Name" readonly>

							  </div>
							  
							  <div style="margin-top: 15px;" class="col-md-6">
								<label>Customer SPOC Name:</label>
								<div id="endcust"></div>
								<input type="text" id="EndCustomerName" class="form-control"
									data-toogle="tooltip" name="EndCustomerName"
									placeholder="Enter Your End Customer Name  " readonly>

							  </div>
							  
							  <div style="margin-top: 15px;" class="col-md-6">
								<label>Customer SPOC Contact :</label>
								<div id="endcostNo"></div>
								<input type="text" id="EndCustomerNumber" class="form-control"
									data-toogle="tooltip" name="EndCustomerNumber"
									placeholder="Enter Your End Customer Number " readonly>

							  </div>
							  
							  
							     <div style="margin-top: 15px;" class="col-md-6">
								<label>Payment Terms :</label>
								<div id="paymentTermsPOdiv"></div>
								<input type="text" id="paymentTermsPO" class="form-control"
									data-toogle="tooltip" name="paymentTermsPO"
									placeholder="Enter Your Payment Terms " readonly>

							  </div>
							  
							  <div style="margin-top: 15px;" class="col-md-6">
								<label>End Customer :</label>
								<div id="endCustomerdiv"></div>
								<input type="text" id="endCustomer" class="form-control"
									data-toogle="tooltip" name="endCustomer"
									placeholder="Enter End Customer" readonly>
							  </div>
							  
							  
							  <!-- //// new  end -->			 
											 
											 
<!--                                     <div style="margin-top:15px;" class="col-md-6"> -->
<!--                                        <label>Project Name :</label> -->
<!-- 											<div id="proj"></div>  -->
<!-- 											 <input -->
<!-- 												type="text" id="projectname" tabindex="4" class="form-control" -->
<!-- 												data-toogle="tooltip" name="projectname" placeholder="Enter your Project Name Here"  readonly> -->

<!--                                     </div> -->
                                	

                                  
                                    
                        

                                  
                                   
                                    </div>
                                         <br><hr>
                                         <div class="col-md-12" id="inputContainer">
                                            </div> 
                                              	<hr>
                                              	
                                              			<div class="row">  
						
						<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="maskedPOUploadDiv">
								<label style="margin-left: 2px"> Masked PO File :<br>
									<span class="col-md-6" style="color: green; width: 450px"
									id="maskedPOfile"></span></label>
								<button class="button1 button4" id="downHidemaskedPOfile"
									onclick="maskedPOStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameMaskedPO"
								name="filnameMaskedPO">
								
								
								<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="productFeaturedUploadDiv">
								<label style="margin-left: 2px">Product Featured File List:<br>
									<span class="col-md-6" style="color: green; width: 450px"
									id="productFeaturedFile"></span></label>
								<button class="button1 button4" id="downHideproductFeaturedfile"
									onclick="productFeaturedStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameProductFeatured"
								name="filnameProductFeatured">
								
								</div>
								
                                        <br>
                                        
                                        

                                    <br>
                                        <div class="row">
          <div class="col-md-12">
           
              
                <ul class="nav nav-tabs" id="custom-tabs-one-tab" role="tablist">
                  <li class="nav-item">
                    <a class="nav-link active" id="custom-tabs-one-home-tab" data-toggle="pill" href="#custom-tabs-one-home" role="tab" aria-controls="custom-tabs-one-home" aria-selected="true">Product Details</a>
                  </li>
                  
<!--                   <li class="nav-item"> -->
<!--                     <a class="nav-link" id="custom-tabs-one-messages-tab" data-toggle="pill" href="#custom-tabs-one-messages" role="tab" aria-controls="custom-tabs-one-messages" aria-selected="false">Form 2</a> -->
<!--                   </li> -->
                 
                 
                </ul>
             
             
                <div class="tab-content">
                  <div class="tab-pane fade show active" id="custom-tabs-one-home" role="tabpanel" aria-labelledby="custom-tabs-one-home-tab">
                     <br>
                     <div class="row">
                                                <div class="col-md-1" ></div>
                                                <div class="col-md-10" >
                                                
                                         <table id="data-table1" class="col-md-12">
											<thead>
												<tr>
													<th data-row-id="row-1">Server Availability :</th>
													<th>Responsibility :</th>
													<th>Start Date :</th>
													<th>End Date :</th>
<!-- 													<th>Action </th> -->

												</tr>
											</thead>
											<tbody>
												<tr data-row-id="row-1">
													
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter your Server Availability " id="serverAvail" name="serverAvail" readonly></td>
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter Your Responsibility" id="Responsibility" name="Responsibility" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="startdate" name="startdate" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="enddate" name="enddate" readonly></td>
<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->
													
												</tr>
											</tbody>
										</table>
                     <br>
                       <table id="data-table2" class="col-md-12">
											<thead>
												<tr>
													<th data-row-id="row-1">Install Of Velox License :</th>
												</tr>
											</thead>
											<tbody>
												<tr data-row-id="row-1">
													
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter your Install Of Velox License" id="installvlxlicense" name="installvlxlicense" readonly></td>
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter Your Responsibility" id="Responsibilityvlxlicense" name="Responsibilityvlxlicense" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="startdatevlxlicense" name="startdatevlxlicense" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="enddatevlxlicense" name="enddatevlxlicense" readonly></td>
<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->
													
												</tr>
											</tbody>
										</table>
										<br>
										
										
										  <table id="data-table3" class="col-md-12">
											<thead>
												<tr>
													<th>UAT Testing :</th>

												</tr>
											</thead>
											<tbody>
												<tr data-row-id="row-1">
													
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter your  UAT Testing" id="UATTesting" name="UATTesting" readonly></td>
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter Your Responsibility" id="Responsibilityuattesting" name="Responsibilityuattesting" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="startdateuattesting" name="startdateuattesting" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="enddateuattesting" name="enddateuattesting" readonly></td>
<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->
													
												</tr>
											</tbody>
										</table>
										
										
										<br>
										 <table id="data-table4" class="col-md-12">
											<thead>
												<tr >
													<th>Production GO Live :</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter your Production GO Live" id="productiongolive" name="productiongolive" readonly></td>
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter Your Responsibility" id="Responsibilitygolive" name="Responsibilitygolive" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="startdategolive" name="startdategolive" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="enddategolive" name="enddategolive" readonly></td>
<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->
													
												</tr>
											</tbody>
										</table>
										<br>
										 <table id="data-table5" class="col-md-12">
											<thead>
												<tr>
													<th>Rollout :</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter your Rollout" id="rollout" name="rollout" readonly></td>
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter Your Responsibility" id="Responsibilityrollout" name="Responsibilityrollout" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="startdaterollout" name="startdaterollout" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="enddaterollout" name="enddaterollout" readonly></td>
<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->
													
												</tr>
											</tbody>
										</table>
										
										
									<br>
									 <table id="data-table6" class="col-md-12">
											<thead>
												<tr>
													<th>DEMO Live :</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter your DEMO Live " id="demolive" name="demolive" readonly></td>
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter Your Responsibility" id="Responsibilitydemo" name="Responsibilitydemo" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="startdatedemo" name="startdatedemo" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="enddatedemo" name="enddatedemo" readonly></td>
<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->
													
												</tr>
											</tbody>
										</table>
<!-- 										<br> -->
<!-- 										 <table id="data-table7" class="col-md-12"> -->
<!-- 											<thead> -->
<!-- 												<tr> -->
<!-- 													<th data-row-id="row-1">Payment Terms :</th> -->

<!-- 												</tr> -->
<!-- 											</thead> -->
<!-- 											<tbody> -->
<!-- 												<tr> -->
													
<!-- 													<td><input class="form-control form-control-sm" type="text" placeholder="Enter your Payment Terms" id="paymentterms" name="paymentterms" readonly></td> -->
<!-- 													<td><input class="form-control form-control-sm" type="text" placeholder="Enter Your Responsibility" id="Responsibilitypaymentterms" name="Responsibilitypaymentterms" readonly></td> -->
<!-- 													<td><input class="form-control form-control-sm" type="text" id="startdatepaymentterms" name="startdatepaymentterms" readonly></td> -->
<!-- 													<td><input class="form-control form-control-sm" type="text" id="enddatepaymentterms" name="enddatepaymentterms" readonly></td> -->
<!-- <!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> --> 
													
<!-- 												</tr> -->
<!-- 											</tbody> -->
<!-- 										</table>	 -->
										
									<br>
									 <table id="data-table8" class="col-md-12">
											<thead>
												<tr>
													<th data-row-id="row-1">Sign Off :</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter your Sign Off" id="signoff" name="signoff" readonly></td>
													<td><input class="form-control form-control-sm" type="text" placeholder="Enter Your Responsibility" id="Responsibilitysignoff" name="Responsibilitysignoff" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="startdatesignoff" name="startdatesignoff" readonly></td>
													<td><input class="form-control form-control-sm" type="text" id="enddatesignoff" name="enddatesignoff" readonly></td>
<!-- 													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td> -->
													
												</tr>
											</tbody>
								  </table>
								
								<br>
                                    
          
                                                </div>
                                                <div class="col-md-1" ></div>   
                                           
                                 </div>
                                 <br>
                                           
                                      
                  </div>
              
   
                 
                </div>
             </div>
              <br>
      
                                    
                                    </div>
                               
                                    <br>
<!--                                  <div class="row"> -->
                                                  
<!--                                                     <div class="col-md-10"> -->
<!--                                                      <label for="techniq">Note (Optional)</label> -->
<!--                                                         <textarea id="SMnote" tabindex="1" class="form-control" name="SMnote"  data-toogle="tooltip" placeholder="Enter Note"></textarea> -->

<!--                                                     </div> -->
                                                 
<!--                                       </div>   -->
                                    

                                        </div>
                                  
                                    <br>
              <!-- /.card -->
            
       

</div>
                                        

					</div>
				</div>
				
<!-- 			</div> -->
	



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
   
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
   
	<script src="<%=request.getContextPath()%>/static/custom/ViewFORM3SubmitteddBySupportManager.js"></script>

</body>
</html>