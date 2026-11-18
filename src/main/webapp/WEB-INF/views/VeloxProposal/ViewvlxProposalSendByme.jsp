<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submitted Commercial Proposal</title>
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
					<div class="col-md-4">Submitted Commercial Proposal
					</div>
					
					<div class="col-md-7">
					</div>
					
					<div class="col-md-1">
					<a href="<%=request.getContextPath()%>/User/vlxProposalSendByme" >
                     <i class="fa fa-backward pull-right" style="color: white">
                     </i>
                     </a>
					</div>
					
					
					</div>
                     
                     </div>
					
					<div class="card-body">


							<div class="row">
								  
								  	<div class="col-md-6">
											<label for="">Proposal Type :</label>											
											<input type="text" id="Proposaltype" tabindex="678" class="form-control" 
												data-toogle="tooltip" name="Proposaltype" placeholder="Enter Proposal Type" readonly>
												
										</div>																			
									<div class="col-md-6" style="display: none;" id="perpetualhideid">
											<label for="">Perpetual Year :</label>											
											<input type="text" id="Perpetualyear" tabindex="9" class="form-control" 
												data-toogle="tooltip" name="Perpetualyear" placeholder="Enter Perpetual Year" readonly="true">
											

									</div>
																		
									<div class="col-md-6" style="display: none;" id="subscriptionhideid">
											<label for="">Subscription Year:</label>											
											<input type="text" id="Subscriptionyear" tabindex="10" class="form-control" 
												data-toogle="tooltip" name="Subscriptionyear" placeholder="Enter Subscription Year" readonly >
											
									</div>
									
									<div class="col-md-6" style="display: none;" id="fixedhideid">
											<label for="">Fixed Year:</label>											
											<input type="text" id="fixedyear" tabindex="10" class="form-control" 
												data-toogle="tooltip" name="fixedyear" placeholder="Enter Fixed Year" readonly >
											
									</div>		
									
										<div class="col-md-6" style="display: none;" id="subscriptionANDperpetualhideid">
											<label for="subscriptionANDperpetualYear">Subscription & Perpetual Year:</label>											
											<input type="text" id="subscriptionANDperpetualYear" tabindex="10" class="form-control" 
												data-toogle="tooltip" name="subscriptionANDperpetualYear" placeholder="Enter Subscription & Perpetual Year" readonly >
											
									</div>				
								   
								  </div>
								  
								  
								<div class="row" id="proposalForDiv">
								  
								  	 <div style="margin-top: 15px;" class="col-md-6">
											<label for=proposalFor> Proposal For : </label> 
										<input type="text"
											class="form-control" id="proposalFor" data-toogle="tooltip"
											 name="proposalFor" tabindex="1" readonly>
										
									</div>
									
									
									    <div style="margin-top: 15px;" class="col-md-6" style="display:none;" id="hidePartnerName">
											<label for="partnerName"> Partner Name : </label> 
										<input type="text"
											class="form-control" id="partnerName" data-toogle="tooltip"
											 name="partnerName" tabindex="1" readonly>
										
										</div>
								  
								 </div>
								  
						<div class="row">
						


                                    <div style="margin-top: 15px;" class="col-md-6">
											<label for="poinitiator"> Maker Name : </label> 
										<input type="text"
											class="form-control" id="poinitiator" data-toogle="tooltip" name="poinitiator" tabindex="1" placeholder="Enter PO Initiator Name" readonly>
										
									</div>
									
                                    <div style="margin-top:15px;" class="col-md-6">
                                  	<label for="pocontactno"> Maker Contact No : </label> <input type="text" data-toogle="tooltip"
											class="form-control" id="poinitiatorno" name="poinitiatorno" tabindex="1" placeholder="Enter PO Contact No" readonly>
									 </div>
                                    <div style="margin-top:15px;" class="col-md-6">
                                  	<label for="approver"> Checker Name :</label> <input type="text"
											id="FirstApprovername" tabindex="5" class="form-control form-control-sm"
											name="FirstApprovername" data-toogle="tooltip"
											placeholder="Enter Approver Name" readonly> </div>
                                    <div style="margin-top:15px;" class="col-md-6">
                                       	<label for="approvercontact"> Checker Contact No :</label> <input type="text"
											id="firstapprovercontact" tabindex="5" class="form-control form-control-sm"
											name="firstapprovercontact" data-toogle="tooltip" 
											placeholder="Enter Approver Contact No" readonly>

                                    </div>
                                	<div style="margin-top: 15px;" class="col-md-6">
										<label for="authorizer"> Authorizer Name :</label> <input type="text"
											id="secondApprovername" tabindex="5" class="form-control form-control-sm"
											name="secondApprovername" data-toogle="tooltip"
											placeholder="Enter Second Approver Name" value="Dr. Mangesh Amale" readonly="readonly">
									</div>
                                    <div style="margin-top:15px;" class="col-md-6">
                                   	<label for="authorizercontact"> Authorizer Name Contact No :</label> <input type="text"
											id="secondapprovercontact" tabindex="5" class="form-control form-control-sm"
											name="secondapprovercontact" data-toogle="tooltip"
											value="9867140100" readonly="readonly" > </div>

                                    <div style="margin-top:15px;" class="col-md-6">
                                  <label for="clientname">Customer Name :</label> <input type="text"
											id="clientname" tabindex="5" class="form-control form-control-sm"
											name="clientname" data-toogle="tooltip"
											placeholder="Enter Customer  Name" readonly="readonly">
									  </div>

                                    <div style="margin-top:15px;" class="col-md-6">
                                 <label for="priority1">Remark (Optional)  :</label>
                                 	<textarea class="form-control" name="Description" rows="1" cols="50"id="Description" name="comments" placeholder="Add Description Here" readonly></textarea>
											
                                    </div>
                                    
                                     <div style="margin-top:15px;" class="col-md-6" id="hideresourceforamc">
										<label for="">Resources Amount :</label> <input type="text"
											id="resoucesamount" tabindex="5" class="form-control form-control-sm"
											name="resoucesamount" data-toogle="tooltip" 
											placeholder="Enter Resouces Amount" readonly>
									</div>
                                       
                                       
                                             
										<div style="margin-top:15px;" class="col-md-6" id="hidereATCforamc"> 
											<label for="ATCID">ATC :</label>											
											<input type="text" id="ATC" tabindex="9" class="form-control" 
												data-toogle="tooltip" name="ATC" placeholder="Enter ATC" readonly>
												

										</div>
										
										
										   	<div style="margin-top:15px;" class="col-md-6">
										<label for="authorizercontact"> End Customer Name(Optional)</label>
										<input type="text" id="enccustomername"
											 class="form-control form-control-sm"
											name="enccustomername" data-toogle="tooltip"
											placeholder="Enter End Customer Name" readonly>
									</div>
                                    
                                    
                                    
                                    <div style="margin-top:15px; display:none;" class="col-md-6" id="poUploadDiv">
                                            <label style="margin-left: 2px">Commercial Proposal Attachment:<br>
                                                <span class="col-md-6" style="color: green;width: 450px" id="pouploadfile"></span></label><button class="button1 button4" id="downHidepofile" onclick="downFileStandard()">Download</button>
                                        </div>
                                        <input type="hidden" id="filenameStandard" name="filenameStandard">

                                  
                                   
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
                      
                      
<!--  ///// START new added for AMC -->

                            <div class="row" style="display: none;" id="AMCSTARTENDHIDEID">
										<div class="col-md-6">
											<label for="amcstartdate">AMC Start Date:</label>

										
												
												<input type="text" readonly
												class="form-control form-control-sm"
													 name="amcstartdate" id="amcstartdate"
													placeholder="Please Select  Date" >
											
										</div>

									

										<div class="col-md-6">
											<label for="amcenddate">AMC End Date:</label>

												<input type="text" readonly
												class="form-control form-control-sm"
													autocomplete="off" name="amcenddate" id="amcenddate"
													placeholder="Please Select  Date" >
										

										</div>
									</div>
 
 
 
                                 <br>

									<div class="row" style="display: none;"
										id="productsuitandtoolhideid">
										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Product Suit :</label> 
											
											<input type="text"
												id="productsuitdetails" class="form-control form-control-sm" 
												data-toogle="tooltip" name="productsuitdetails" readonly="readonly">
											

										</div>

										<div class="col-md-6" style="margin-top: 15px;">
											<label for="">Security Tools :</label>
											 <input type="text"
												id="securitysolutiondetails" class="form-control form-control-sm"
										        name="securitysolutiondetails" readonly="readonly">


										</div>

									</div>
									
									
									
									<br>
									<div class="row" style="display: none;"
										id="descandtotalcosthideid">
										<div class="col-md-6">
											<label for="">Description :</label> <input type="text"
												id="descforamc" class="form-control form-control-sm"
												name="descforamc" data-toogle="tooltip"
												placeholder="Enter Description Here" readonly="readonly">
										</div>

										<div class="col-md-6">
											<label for="">Total Cost :</label> <input type="text"
												id="totalcostAMC" class="form-control form-control-sm"
												name="totalcostAMC" data-toogle="tooltip"
												placeholder="Enter Total Cost Here" readonly="readonly">
										</div>
										<br>
										<br>
										<br>
										<br>
										<div class="col-md-6">
											<label for="">18% GST of Total Cost :</label> <input
												type="text" id="gstforamc"
												class="form-control form-control-sm" name="gstforamc"
												data-toogle="tooltip"
												placeholder="Enter GST Percentage Here" readonly="readonly">
										</div>


										<div class="col-md-6">
											<label for="">Grand Total :</label> <input type="text"
												id="GRANDTOTALFORAMC" class="form-control form-control-sm"
												name="GRANDTOTALFORAMC" data-toogle="tooltip"
												placeholder="Enter Grand Total Here" readonly="readonly">
										</div>


									</div>
									
 
 
<!--  ///// END   new added for AMC                      -->

                                    


							
						
							

							
							<table class="table table-striped table-bordered row-border" style="width:100%;" id="CMApprByMeTable">
										<thead>

											<tr class="table table-striped table-bordered"  >
												<th>Product Suites</th>
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
                                 
                              <div class="row" id ="hidealldetailforamc">
                                 
                                 <br>
										<div  style="margin-top:15px; display: none;" class="col-md-6" id="subtotalahideid">
											<label for="approver33333">Sub Total (A) :</label> <input
												type="text" id="totalpriceforallproduct"
												="5" class="form-control form-control-sm"
												name="totalpriceforallproduct" data-toogle="tooltip" readonly="readonly">
										</div>

										<div style="margin-top:15px; display: none;" class="col-md-6" id="subtotalahideid3yearsubs">
											<label for="">Sub Total 3 Year Subscription (A) :</label> <input
												type="text" id="totalpriceforallproduct3yearsubs"
												="5" class="form-control form-control-sm"
												name="totalpriceforallproduct3yearsubs" data-toogle="tooltip" readonly="readonly">
										</div>
																											

										<div  style="margin-top:15px; display: none;" class="col-md-6" id="subtotalahideid3yearperp" >
											<label for="">Sub Total 3 Year Warranty (A) :</label> <input
												type="text" id="totalpriceforallproduct3yearperp"
												="5" class="form-control form-control-sm"
												name="totalpriceforallproduct3yearperp" data-toogle="tooltip" readonly="readonly">
										</div>

									

										<div  style="margin-top:15px; display: none;" class="col-md-6" id="subtotalahideid5yearperp">
											<label for="">Sub Total 5 Year Warranty (A) :</label> <input
												type="text" id="totalpriceforallproduct5yearperp"
												="5" class="form-control form-control-sm"
												name="totalpriceforallproduct5yearperp" data-toogle="tooltip" readonly="readonly">
										</div>
										
										<div  style="margin-top:15px; display: none;" class="col-md-6" id="subtotalahideid3yearfixed" >
											<label for="">Sub Total 3 Year Fixed (A) :</label> <input
												type="text" id="subtotal3yearfixed"
												="5" class="form-control form-control-sm"
												name="subtotal3yearfixed" data-toogle="tooltip" readonly="readonly">
										</div>

									

										<div  style="margin-top:15px; display: none;" class="col-md-6" id="subtotalahideid5yearfixed">
											<label for="">Sub Total 5 Year Fixed (A) :</label> <input
												type="text" id="subtotal5yearfixed"
												="5" class="form-control form-control-sm"
												name="subtotal5yearfixed" data-toogle="tooltip" readonly="readonly">
										</div>
									  
									  	<div style="margin-top:15px;" class="col-md-6">
										<label for="approver">Implementation & Deployment support:</label> <input type="number"
											id="deploysupport" tabindex="5" class="form-control form-control-sm"
											name="deploysupport" data-toogle="tooltip"
											placeholder="Enter Implementation ,Integration & Deployement support" readonly>
									</div>
									
									  	<div style="margin-top:15px;" class="col-md-6">
											<label for="approvercontact">Cloud Deployment Charges (Every Year):</label> <input type="number"
											id="clouddeploycharges" tabindex="5" class="form-control form-control-sm"
											name="clouddeploycharges" data-toogle="tooltip"
											placeholder="Enter Cloud Deployement Charges " readonly>
									</div>
									
									<div style="margin-top:15px;" class="col-md-6">
											<label for="">Integration Charges :</label> <input type="number"
											id=integrationcharge tabindex="5" class="form-control form-control-sm"
											name="integrationcharge" data-toogle="tooltip"
											placeholder="Enter Cloud Deployement Charges " readonly>
									</div>
									
									

									
										<div style="margin-top:15px;" class="col-md-6">
										<label for="approver">Sub Total (B)</label> <input type="number"
											id="subtotalB" tabindex="5" class="form-control form-control-sm"
											name="subtotalB" data-toogle="tooltip"
											readonly="readonly">
									</div>	
									
										<div style="margin-top:15px;" class="col-md-6">
											<label for="">Sub Total C (A+B) :</label> <input type="text"
												id="totalc" ="5" class="form-control form-control-sm"
												name="totalc" data-toogle="tooltip" readonly="readonly">
										</div>
																										
                                 </div> 
                                 
                                 
                                 
                                      <br>
                                       <div class="row" id="hidegstandgrandtotalforamc">
										<div class="col-md-6">
											<label for="">GST @18% Of C :</label> <input type="text"
												id="total18percentage"
												="5" class="form-control form-control-sm"
												name="total18percentage" data-toogle="tooltip" readonly="readonly">
										</div>

										<div class="col-md-6">
											<label for="">Grand Total :</label> <input type="text"
												id="grandtotal" ="5" class="form-control form-control-sm"
												name="grandtotal" data-toogle="tooltip" readonly="readonly">
										</div>
									</div>
									
									
									
									
									
									
									                                              
	<!--  START  Combination OF Subscription and Perpetual         -->
	
	
	
	
	 <div class="row" style="display: none;" id="combinationSubsANDPerpHideDIv">
	 
	 
	 
	 
	 <br>
	 <br>
	 <div class="col-md-12 text-center" style="margin-left: 16px; font-size: 15px; color: red;">
								<strong>Perpetual Table</strong>
							
									
									</div>
	 
	 <div class="col-md-12">
	 	<table class="table table-striped table-bordered row-border" style="width:100%;" id="SubsANDPerpTable">
										<thead>

											<tr class="table table-striped table-bordered"  >
												<th>Product Suites</th>
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
                                 </div>
                                 <br><br>
	 
	    <div style="margin-top:15px;" class="col-md-6" id="perpetualSubsAnnualPerpHideDiv">
                                       	<label for="perpetualSubsAnnualperpType">Sub Total Annual Year (A) :</label> <input type="text"
											id="perpetualSubsAnnualperpType"  class="form-control form-control-sm"
											name="perpetualSubsAnnualperpType" data-toogle="tooltip" 
											placeholder="Enter Sub Total Annual Year" readonly>

                                    </div>
                                	<div style="margin-top: 15px;" class="col-md-6" id="perpetualSubs3yearPerpHideDiv">
										<label for="perpetualSubs3yearperpType">Sub Total 3 Pepetual Year (A) :</label> <input type="text"
											id="perpetualSubs3yearperpType" class="form-control form-control-sm"
											name="perpetualSubs3yearperpType" data-toogle="tooltip"
											placeholder="Enter Sub Total 3 Pepetual Year"  readonly="readonly">
									</div>
									
									
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="deploysupport21">Implementation & Deployment support :</label> <input type="text"
											id="deploysupport21" class="form-control form-control-sm"
											name="deploysupport21" data-toogle="tooltip"
											placeholder="Enter Implementation & Deployment support"  readonly="readonly">
									</div>
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="clouddeploycharges21">Cloud Deployment Charges :</label> <input type="text"
											id="clouddeploycharges21" class="form-control form-control-sm"
											name="clouddeploycharges21" data-toogle="tooltip"
											placeholder="Enter Cloud Deployment Charges"  readonly="readonly">
									</div>
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="IntegrationCharges21">Integration Charges :</label> <input type="text"
											id="IntegrationCharges21" class="form-control form-control-sm"
											name="IntegrationCharges21" data-toogle="tooltip"
											placeholder="Enter Integration Charges"  readonly="readonly">
									</div>
									
									
											<div style="margin-top: 15px;" class="col-md-6" >
										<label for="subtotalB21">Sub Total (B) :</label> <input type="text"
											id="subtotalB21" class="form-control form-control-sm"
											name="subtotalB21" data-toogle="tooltip"
											placeholder="Enter Sub Total (B)"  readonly="readonly">
									</div>
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="totalc21">Sub Total C (A+B) :</label> <input type="text"
											id="totalc21" class="form-control form-control-sm"
											name="totalc21" data-toogle="tooltip"
											placeholder="Enter Sub Total C (A+B)"  readonly="readonly">
									</div>
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="total18percentage21">GST @18% Of C :</label> <input type="text"
											id="total18percentage21" class="form-control form-control-sm"
											name="total18percentage21" data-toogle="tooltip"
											placeholder="Enter GST @18% Of C"  readonly="readonly">
									</div>
									
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="grandtotal21">Grand Total :</label> <input type="text"
											id="grandtotal21" class="form-control form-control-sm"
											name="grandtotal21" data-toogle="tooltip"
											placeholder="Enter Grand Total"  readonly="readonly">
									</div>
										<div style="margin-top: 15px;" class="col-md-6" >
										<label for="resoucesamount21">Resources Amount :</label> <input type="text"
											id="resoucesamount21" class="form-control form-control-sm"
											name="resoucesamount21" data-toogle="tooltip"
											placeholder="Enter Resources Amount"  readonly="readonly">
									</div>
	 
	 </div>
	
              <!--  END  Combination OF Subscription and Perpetual         -->           
                                  
									
									
									
									
									
									
                                                </div>
                                                
                                              <div class="col-md-1" ></div>   
                                           
                                 </div>
                                 <br>
                                 
                                 
                                 
                                 
                                 						<!--  START  add two field for RESOURCE        -->
               
               
               			    <div class="row" style="display: none;" id="subtotalahideidforResource">
										<br>
										<div class="col-md-4">
											<label for="">Sub Total (A) Resource :</label> <input
												type="text" id="subtotalAResource"
												 class="form-control form-control-sm"
												name="subtotalAResource" data-toogle="tooltip"
												readonly="readonly">
										</div>
																		
                          
                                          <div class="col-md-4" >
											<label for="">18% GST of Sub Total (A) Resource :</label> <input
												type="text" id="gstdataforresource"
												 class="form-control form-control-sm"
												name="gstdataforresource" data-toogle="tooltip"
												readonly="readonly">
										</div>
										
										 <div class="col-md-4" >
											<label for="">Grand Total Resource :</label> <input
												type="text" id="grandtotalforresource"
												 class="form-control form-control-sm"
												name="grandtotalforresource" data-toogle="tooltip"
												readonly="readonly">
										</div>
	                       </div>

<!--                                   END  add two field for RESOURCE           -->	



                                      
                  </div>
              
   
                 
                </div>
             </div>
              <br>
      
                                    
                                    </div>
                                    
                                        <br>
                                 <div class="row" id="SInoteDiv" style="display: none;">
                                                  
                                                    <div class="col-md-10">
                                                     <label for="techniq">SI Note</label>
                                                        <textarea id="SInote" tabindex="1" class="form-control" name="SInote"  data-toogle="tooltip" placeholder="Enter Note" readonly></textarea>

                                                    </div>
                                                 
                                      </div> 
                                    <br>
                                    
                                    

                                        </div>
                                        

       

</div>
                                        

					</div>
<!-- 				</div> -->
<!-- 				</form> -->
<!-- 			</div> -->
	

			
 

			<br>
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
   
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
     <script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
   
	<script src="<%=request.getContextPath()%>/static/custom/viewvlxProposalSendByme.js"></script>

</body>
</html>