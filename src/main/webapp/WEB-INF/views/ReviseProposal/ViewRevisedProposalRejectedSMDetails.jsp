<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rejected By Me</title>
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
					<div class="col-md-4">Rejected By Me
					</div>
					
					<div class="col-md-7">
					</div>
					
					<div class="col-md-1">
					<a href="<%=request.getContextPath()%>/User/RejectedRevisedProposalSM" >
                     <i class="fa fa-backward pull-right" style="color: white">
                     </i>
                     </a>
					</div>
					
					
					</div>
                     
                     </div>
					
					<div class="card-body">
						<div class="row">

							<div class="col-md-6">
								<label for="">Proposal Type :</label> <input type="text"
									id="Proposaltype" tabindex="678" class="form-control"
									data-toogle="tooltip" name="Proposaltype"
									placeholder="Enter Proposal Type" readonly>

							</div>
							<div class="col-md-6" style="display: none;" id="perpetualhideid">
								<label for="">Perpetual Year :</label> <input type="text"
									id="Perpetualyear" tabindex="9" class="form-control"
									data-toogle="tooltip" name="Perpetualyear"
									placeholder="Enter Perpetual Year" readonly="true">


							</div>

							<div class="col-md-6" style="display: none;"
								id="subscriptionhideid">
								<label for="">Subscription Year:</label> <input type="text"
									id="Subscriptionyear" tabindex="10" class="form-control"
									data-toogle="tooltip" name="Subscriptionyear"
									placeholder="Enter Subscription Year" readonly>

							</div>

						</div>
						<br>
						
						
						<!-- //29/06 -->
						<div class="row">
								  	<div class="col-md-6"  id="proposalforhideid">
											<label for="">Proposal For :</label>											
											<input type="text" id="proposalFor" tabindex="9" class="form-control" 
												data-toogle="tooltip" name="proposalFor" placeholder="Proposal For" readonly="true">
											

									</div>
									
									<div class="col-md-6" id="hidePartnerName"  style="display: none;">
										<label for="">Partner Name (Optional)</label> <input type="text"
											data-toogle="tooltip" class="form-control"
											id="PartnerName" name="PartnerName" readonly="true">
									</div>
								  </div>
								  <br>
						
						<!--  -->

						<div class="row">


                                    <div style="margin-top: 15px;" class="col-md-6">
											<label for="poinitiator">VP Maker Name : </label> 
										<input type="text"
											class="form-control" id="poinitiator" data-toogle="tooltip" name="poinitiator" tabindex="1" placeholder="Enter PO Initiator Name" readonly>
										
									</div>
                                    <div style="margin-top:15px;" class="col-md-6">
                                  	<label for="pocontactno">VP Maker Contact No : </label> <input type="text" data-toogle="tooltip"
											class="form-control" id="poinitiatorno" name="poinitiatorno" tabindex="1" placeholder="Enter PO Contact No" readonly>
									 </div>
                                    <div style="margin-top:15px;" class="col-md-6">
                                  	<label for="approver">VP Checker Name :</label> <input type="text"
											id="FirstApprovername" tabindex="5" class="form-control form-control-sm"
											name="FirstApprovername" data-toogle="tooltip"
											placeholder="Enter Approver Name" readonly> </div>
                                    <div style="margin-top:15px;" class="col-md-6">
                                       	<label for="approvercontact">VP Checker Contact No :</label> <input type="text"
											id="firstapprovercontact" tabindex="5" class="form-control form-control-sm"
											name="firstapprovercontact" data-toogle="tooltip" 
											placeholder="Enter Approver Contact No" readonly>

                                    </div>
                                	<div style="margin-top: 15px;" class="col-md-6">
										<label for="authorizer">VP Authorized Name :</label> <input type="text"
											id="secondApprovername" tabindex="5" class="form-control form-control-sm"
											name="secondApprovername" data-toogle="tooltip"
											placeholder="Enter Second Approver Name" value="Dr. Mangesh Amale" readonly="readonly">
									</div>
                                    <div style="margin-top:15px;" class="col-md-6">
                                   	<label for="authorizercontact">VP Authorized Contact No :</label> <input type="text"
											id="secondapprovercontact" tabindex="5" class="form-control form-control-sm"
											name="secondapprovercontact" data-toogle="tooltip"
											value="9867140100" readonly="readonly" > </div>

                                    <div style="margin-top:15px;" class="col-md-6">
                                  <label for="clientname">Customer Name :</label> <input type="text"
											id="clientname" tabindex="5" class="form-control form-control-sm"
											name="clientname" data-toogle="tooltip"
											placeholder="Enter Client  Name" readonly="readonly">
									  </div>

                                    <div style="margin-top:15px;" class="col-md-6">
                                 <label for="priority1">Remark (Optional) :</label>
                                 	<textarea class="form-control" name="Description" rows="1" cols="50"id="Description" name="comments" placeholder="Add Description Here" readonly></textarea>
											
                                    </div>

                                  	<div style="margin-top: 15px;" class="col-md-6">
								<label for="">Resources Amount :</label> <input type="text"
									id="resoucesamount" tabindex="5"
									class="form-control form-control-sm" name="resoucesamount"
									data-toogle="tooltip" placeholder="Enter Resouces Amount"
									readonly>
							</div>



							<div style="margin-top: 15px;" class="col-md-6">
								<label for="ATCID">ATC :</label> <input type="text" id="ATC"
									tabindex="9" class="form-control" data-toogle="tooltip"
									name="ATC" placeholder="Enter ATC" readonly>


							</div>
								<div style="margin-top: 15px;" class="col-md-6">
								<label for="authorizercontact"> End Customer
									Name(Optional)</label> <input type="text" id="enccustomername"
									="5" class="form-control form-control-sm"
									name="enccustomername" data-toogle="tooltip"
									placeholder="Enter End Customer Name">
							</div>
							
                                   
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

                                    


							
						
							

							
							<table class="table table-striped table-bordered row-border" style="width:100%" id="CMApprByMeTable">
										<thead>

											<tr class="table table-striped table-bordered"  >

													<th>Product Names</th>
												<th>Product Description</th>
												<th>Quantity</th>
												<th>Unit Rate</th>
												<th>Total Price</th>
											</tr>
											
											
										</thead>
										<tbody>
    
        </tbody>
                                 </table>

                                 <br><br>
                                 
                                 <div class="row">
                                   <div style="margin-top:15px;" class="col-md-6">
                                  <label for="subtotalA">Sub Total A :</label> <input type="text"
											id="subtotalA" tabindex="5" class="form-control form-control-sm"
											name="subtotalA" data-toogle="tooltip"
											placeholder="Enter Sub Total  A" readonly="readonly">
									  </div>
									  
									  
									  	<div style="margin-top:15px;" class="col-md-6">
										<label for="approver">SecureIT-Suit Implementation,Integration & Deployement support:</label> <input type="number"
											id="deploysupport" tabindex="5" class="form-control form-control-sm"
											name="deploysupport" data-toogle="tooltip"
											placeholder="Enter Implementation ,Integration & Deployement support" readonly>
									</div>
									
									  	<div style="margin-top:15px;" class="col-md-6">
											<label for="approvercontact">Cloud Deployement Charges :</label> <input type="number"
											id="clouddeploycharges" tabindex="5" class="form-control form-control-sm"
											name="clouddeploycharges" data-toogle="tooltip"
											placeholder="Enter Cloud Deployement Charges " readonly>
									</div>
									
									
										<div style="margin-top:15px;" class="col-md-6">
										<label for="approver">Sub Total (B)</label> <input type="number"
											id="subtotalB" tabindex="5" class="form-control form-control-sm"
											name="subtotalB" data-toogle="tooltip"
											readonly="readonly">
									</div>	
									
<!-- 										<div style="margin-top:15px;" class="col-md-6"> -->
<!-- 										<label for="approver">Grand Total (A+B)</label> <input type="number" -->
<!-- 											id="subtotalAB" tabindex="5" class="form-control form-control-sm" -->
<!-- 											name="subtotalAB" data-toogle="tooltip" -->
<!-- 											readonly="readonly"> -->
<!-- 									</div> -->
	<div style="margin-top: 15px;" class="col-md-6">
														<label for="">Sub Total C (A+B) :</label> <input
															type="text" id="totalc"
															="5" class="form-control form-control-sm" name="totalc"
															data-toogle="tooltip" readonly="readonly">
													</div>

													<div style="margin-top: 15px;" class="col-md-6">
														<label for="">GST @18% Of C :</label> <input type="text"
															id="total18percentage"
															="5" class="form-control form-control-sm"
															name="total18percentage" data-toogle="tooltip"
															readonly="readonly">
													</div>

													<div style="margin-top: 15px;" class="col-md-6">
														<label for="">Grand Total :</label> <input type="text"
															id="grandtotal" ="5" class="form-control form-control-sm"
															name="grandtotal" data-toogle="tooltip"
															readonly="readonly">
													</div>
									
									
                                          </div> 
                                                    
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
                                       <div class="row" style="display: none;" id="SMnoteDiv">
                                                  
                                                    <div class="col-md-10">
                                                     <label for="techniq">Note (Optional)</label>
                                                        <textarea id="SMnote" tabindex="1" class="form-control" name="SMnote"  data-toogle="tooltip" placeholder="Enter Note" readonly></textarea>

                                                    </div>
                                                 
                                      </div>  
                                    

                                        </div>
                                        
<!--                                         <div style="margin-top:15px;" class="col-md-12"> -->
<!--                                         <center> -->
<!--                                                                                            <input type="submit" tabindex="8" class="btn btn-primary m-t-10" id="submit-btnnn"  name="submit" value="Submit"> <span class="spinner" style=" display: none"><i class="fa fa-refresh fa-spin fa-10x"></i></span> -->
<!--                                             <button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="ApproveCM" name="ApproveCM" data-style="expand-left" >Approve &nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem;display: none;" id="spin1"><i class="fa fa-refresh fa-spin fa-10x"></i></span></button>   -->
<!--                                             <button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="Reject" name="Reject" onclick="myFunctionReject();">Feedback &nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem;display: none;" id="spin2"><i class="fa fa-refresh fa-spin fa-10x"></i></span></button>   -->
<!--                                         </center> -->
<!--                                     </div> -->
                                    
<!--                                     <br> -->
              <!-- /.card -->
            
       

</div>
                                        

					</div>
				</div>
				
			</div>
	

			
 

			<br>
		

		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->

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
   
	<script src="<%=request.getContextPath()%>/static/custom/ViewRevisedProposalRejectedSMDetails.js"></script>

</body>
</html>