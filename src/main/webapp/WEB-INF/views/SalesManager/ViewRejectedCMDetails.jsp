<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Approved Document of PO</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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
 
 .table-container {
    overflow-x: auto;
    width: 100%; /* Set a specific width for your container */
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
    <input type="hidden" id="form3status" name="form3status" value="">
 <input type="hidden" id="formABstatus" name="formABstatus" value="">
 <input type="hidden" id="form3SubmitStatus" name="form3SubmitStatus" value="">
 
 
	<div class="wrapper">
		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>
		<div class="content-wrapper">
			<br>
			
			<div style="padding-left: 15px; padding-right: 15px">
			
				<div class="card card-secondary border-secondary">
				
					<div class="card-header">
					<div class="row">
					<div class="col-md-4">Rejected By Me Documents
					</div>
					
					<div class="col-md-7">
					</div>
					
					<div class="col-md-1">
					<a href="<%=request.getContextPath()%>/User/RejectedCMDetails" >
                     <i class="fa fa-backward pull-right" style="color: white">
                     </i>
                     </a>
					</div>
					
					
					</div>
                     
                     </div>
					
					<div class="card-body">

						<div class="row">
							<!--                                        <div style="margin-top:15px;" class="col-md-6"> -->
							<!--                                        <label style="margin-left: 2px">File Attachment:<br> -->
							<!--                                                 <span class="vlx" style="color: green;width: 450px" id="pouploadfile"></span></label><button class="button1 button4" id="pouploadfile" onclick="downFileDefect()">Download</button> -->
							<!--                                         <div class="form-group" id="pouploadfile11"> -->
							<!-- <!--                                             <input type="file" id="pouploadfile" tabindex="1" class="form-control" name="pouploadfile"  data-toogle="tooltip" placeholder="Upload File" readonly="true"> -->
							<!--                                         <input type="hidden" id="pouploadfile" name="pouploadfile"> -->
							<!--                                         </div> -->
							<!--                                     </div> -->

							<div style="margin-top: 15px;" class="col-md-6">
								<label for="potype">Purchase Order Type</label> <input
									type="text" class="form-control" tabindex="1" id="potype"
									name="potype" data-toogle="tooltip"
									placeholder="Enter purchase Order Type" readonly>
							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="ponumber">Purchase Order No</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="email"></label> <input type="text" id="ponumber"
									tabindex="1" class="form-control" name="ponumber"
									data-toogle="tooltip" placeholder="Enter PO No" readonly>
							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="podate">Purchase Order Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="email"></label> <input type="text" id="podate" tabindex="1"
									class="form-control" name="podate" data-toogle="tooltip"
									readonly>
							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="proddescrip">Product Description</label><label
									id="bname1"></label>
								<div class="form-group" id="proddescrip11">
									<input type="text" id="proddescrip" tabindex="1"
										class="form-control" name="proddescrip" data-toogle="tooltip"
										placeholder="Enter Product Description" readonly>
								</div>

							</div>
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="customername">Customer Name</label> <input
									type="text" class="form-control" tabindex="1" id="customername"
									name="customername" data-toogle="tooltip"
									placeholder="Enter Customer Name" readonly>
							</div>
							
								<div style="margin-top: 15px;" class="col-md-6">
								<label for="productSuit">Product Suit</label> <input
									type="text" class="form-control" tabindex="1" id="productSuit"
									name="productSuit" data-toogle="tooltip"
									placeholder="Enter Product Name" readonly>
							</div>
								<div style="margin-top: 15px;" class="col-md-6">
								<label for="securityTools">Security Tools</label> <textarea
									 class="form-control form-control-sm" tabindex="1" id="securityTools"
									name="securityTools" data-toogle="tooltip"
									placeholder="Enter Security Name" readonly></textarea>
							</div>
							
							<div style="margin-top: 15px;" class="col-md-6">
								<label for="paymentterms">Payment Terms</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="email"></label> <input type="text" id="paymentterms"
									tabindex="1" class="form-control" name="paymentterms"
									data-toogle="tooltip" placeholder="Enter Payment Terms"
									readonly="true">
							</div>

							<div style="margin-top: 15px;" class="col-md-6">
								<label for="prodliscense">Product License</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="prodliscense"
									tabindex="1" class="form-control" name="prodliscense"
									data-toogle="tooltip" placeholder="Enter Product License"
									readonly="true">
							</div>

							<div style="margin-top: 15px;" class="col-md-6">
								<label for="prodamount">Product Amount</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="email"></label> <input type="text" id="prodamount"
									tabindex="1" class="form-control" name="prodamount"
									data-toogle="tooltip" placeholder="Enter Product Amount"
									readonly="true">
							</div>

							<div style="margin-top: 15px;display: none;" id="warrantystartDiv" class="col-md-6">
								<label for="warrantystart">Warranty Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="warrantystart"
									tabindex="1" class="form-control" name="warrantystart"
									data-toogle="tooltip" readonly>
							</div>

							<div style="margin-top: 15px;display: none;" id="warrantyendDiv" class="col-md-6">

								<label for="warrantyend">Warranty End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="warrantyend"
									tabindex="1" class="form-control" name="warrantyend"
									data-toogle="tooltip" readonly>

							</div>

							<div style="margin-top: 15px;display: none;" id="amcstartdateDiv" class="col-md-6">
								<label for="amcstartdate">AMC Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="amcstartdate"
									tabindex="1" class="form-control" name="amcstartdate"
									data-toogle="tooltip" readonly>
							</div>

							<div style="margin-top: 15px;display: none;" class="col-md-6" id="amcenddateDiv">

								<label for="amcenddate">AMC End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="amcenddate"
									tabindex="1" class="form-control" name="amcenddate"
									data-toogle="tooltip" readonly>

							</div>
							
								<div style="margin-top: 15px;display: none;" class="col-md-6" id="tennurestartdateDiv">
								<label for="tennurestartdate">Tennure Start Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="tennurestartdate"
									tabindex="1" class="form-control" name="tennurestartdate"
									data-toogle="tooltip" readonly>
							</div>

							<div style="margin-top: 15px;display: none;" class="col-md-6" id="tennureenddateDiv">

								<label for="tennureenddate">Tennure End Date</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
									id="phnnno"></label> <input type="text" id="tennureenddate"
									tabindex="1" class="form-control" name="tennureenddate"
									data-toogle="tooltip" readonly>

							</div>




							<div style="margin-top: 15px; display: none;" class="col-md-6">
								<label for="change">Advance Invoice, if Yes/NO </label><label
									id="phnnno"></label> <input type="text" id="advaninvoice"
									tabindex="1" class="form-control" name="advaninvoice"
									data-toogle="tooltip" placeholder="Add Invoice Yes/No" readonly>

							</div>

							<!--                                       <div style="margin-top:15px;" class="col-md-6"> -->
							<!--                                        <label style="margin-left: 2px">File Attachment:<br> -->
							<!--                                                 <span class="vlx" style="color: green;width: 450px" id="pouploadfile"></span></label><button class="button1 button4" id="pouploadfile" onclick="downFileDefect()">Download</button> -->


							<!--                                         <input type="hidden" id="pouploadfile" name="pouploadfile"> -->

							<!--                                     </div> -->

<!-- 							<div style="margin-top: 15px;" class="col-md-6"></div> -->

							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="poUploadDiv">
								<label style="margin-left: 2px"> PO File :<br> <span
									class="vlx" style="color: green; width: 450px"
									id="pouploadfile"></span></label>
								<button class="button1 button4" id="downHidepofile"
									onclick="downFileStandard()">Download</button>
							</div>
							<input type="hidden" id="filenameStandard"
								name="filenameStandard">
								
								
								<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="proposalUploadDiv">
								<label style="margin-left: 2px"> Commercial Proposal File :<br>
									<span class="vlx" style="color: green; width: 450px"
									id="proposalfile"></span></label>
								<button class="button1 button4" id="downHideproposalfile"
									onclick="proposalStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameProposal"
								name="filnameProposal">
								
								
									<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="maskedPOUploadDiv">
								<label style="margin-left: 2px"> Masked PO File :<br>
									<span class="vlx" style="color: green; width: 450px"
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



							<!--                                     <div style="margin-top:15px;" class="col-md-6"> -->
							<!--                                          <input -->
							<!-- 											type="file" id="advinvoicefile" name="advinvoicefile" -->
							<!-- 											class="form-control" style="height: 36px;display: none;"> -->
							<!--                                     </div> -->
							<div style="margin-top: 15px; display: none;" class="col-md-6"
								id="advInvoiceUploadDiv">
								<label style="margin-left: 2px"> Advance Invoice :<br>
									<span class="vlx" style="color: green; width: 450px"
									id="advinvoicefile"></span></label>
								<button class="button1 button4" id="downHideadvInvfile"
									onclick="advInvFileStandard()">Download</button>

							</div>
							<input type="hidden" id="filnameAdvinvoice"
								name="filnameAdvinvoice">




						</div>
                                    
<!--                                     // start -->

      <br>
                                 <div class="row" style="display: none;" id="SInoteDiv">
                                                  
                                                    <div class="col-md-10">
                                                     <label for="techniq">Note (SI)</label>
                                                        <textarea id="SInote" tabindex="1" class="form-control" name="SInote"  data-toogle="tooltip" placeholder="Enter Note" readonly></textarea>

                                                    </div>
                                                 
                                      </div>  <br>
		  <div class="row" style="display: none;" id="SMnoteDiv">
                                                  
                                                    <div class="col-md-10">
                                                     <label for="techniq">Note SM (Optional)</label>
                                                        <textarea id="SMnote" tabindex="1" class="form-control" name="SMnote"  data-toogle="tooltip" placeholder="Enter Note" readonly></textarea>

                                                    </div>
                                                 
                                      </div>

						<br>	  <div class="row" style="display: none;" id="CMnoteDiv">
                                                  
                                                    <div class="col-md-10">
                                                     <label for="techniq">Note CM (Optional)</label>
                                                        <textarea id="CMnote" tabindex="1" class="form-control" name="CMnote"  data-toogle="tooltip" placeholder="Enter Note" readonly></textarea>

                                                    </div>
                                                 
                                      </div>

						<br>
                                         
<div class="container mt-5">
    <!-- Nav tabs (including the existing tabs) -->
    <ul class="nav nav-tabs" id="myTabs" role="tablist">
        <!-- Existing tabs -->
        <li class="nav-item">
            <a class="nav-link active" id="custom-tabs-one-home-tab" data-toggle="pill" href="#custom-tabs-one-home" role="tab" aria-controls="custom-tabs-one-home" aria-selected="true">Form A</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" id="custom-tabs-one-messages-tab" data-toggle="pill" href="#custom-tabs-one-messages" role="tab" aria-controls="custom-tabs-one-messages" aria-selected="false">Form B</a>
        </li>
    </ul>

    <!-- Tab panes (including the existing tab content) -->
    <div class="tab-content" id="tabContent">
        <!-- Existing tab content -->
        <div class="tab-pane fade show active" id="custom-tabs-one-home" role="tabpanel" aria-labelledby="custom-tabs-one-home-tab">
           <br>
            <div class="row">
                                                <div class="col-md-1" ></div>
                     <div class="col-md-10">


												<div class="row">
													<div class="col-md-3">

														<label for="dateforma">Date</label>  
													</div>
													<div class="col-md-3">
														<input type="text" id="dateforma" name="dateforma"
															readonly class="form-control" data-toogle="tooltip">
													</div>
													<div class="col-md-3"></div>
													<div class="col-md-3"> </div>

												</div>
												<br>

												<div class="row">
													<div class="col-md-3">

														<label for="salemangname">Sales Manager Name</label>  
													</div>
													<div class="col-md-3">


									
																							<input type="text" id="salemangname" name="salemangname"
																								class="form-control" data-toogle="tooltip" 
																								placeholder="Enter Sales Manager Name" readonly="readonly">
<!-- 														<select id="salemangname" name="salemangname" -->
<!-- 															class="form-control" data-toogle="tooltip"> -->
<!-- 															<option value="">-- Please Select --</option> -->
<!-- 														</select> -->
													</div>
													<div class="col-md-3"></div>
													<div class="col-md-3"></div>

												</div>
												<br>

												<div class="row">
													<div class="col-md-3">

														<label for="formApoNo">PO No</label>  
													</div>
													<div class="col-md-3">
														<input type="text" id="formApoNo" name="formApoNo"
															class="form-control" data-toogle="tooltip" readonly
															placeholder="Enter PO Number">
													</div>
													<div class="col-md-3"></div>
													<div class="col-md-3"></div>

												</div>
												<br> <br>


												<!-- 							<div class="col-md-12"> -->

												<table class="table table-striped table-bordered row-border"
													id="formAtable" style="width: 100%">
													<thead>

														<tr class="table table-striped table-bordered">

															<th>Names</th>
															<th>Name of Party</th>
															<th>Project Name</th>
															<th>Technical Person Name</th>
															<th>Person Designation</th>
															<th>Contact Number</th>
															<th>Email Id</th>

														</tr>
													</thead>

													<tbody>
														<tr>
															<td>Distributor </td>
															<td><input type="text" id="distributorpartyname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="distributorpartyname"
																placeholder="Enter Name of Party" readonly></td>
															<td><input type="text" id="distributorprojectname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="distributorprojectname"
																placeholder="Enter Project Name" readonly></td>
															<td><input type="text"
																id="distributortechpersonname" tabindex="4"
																class="form-control" data-toogle="tooltip"
																name="distributortechpersonname"
																placeholder="Enter Technical Person Name" readonly></td>
															<td><input type="text"
																id="distributorprsndesignation" tabindex="4"
																class="form-control" data-toogle="tooltip"
																name="distributorprsndesignation"
																placeholder="Enter Person Designation" readonly></td>
															<td><input type="text" id="distributorcontactnumber"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="distributorcontactnumber"
																placeholder="Enter Contact Number" readonly></td>
															<td><input type="text" id="distributoremailid"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="distributoremailid" placeholder="Enter Email ID" readonly></td>
														</tr>
														<tr>
															<td>Partner </td>
															<td><input type="text" id="partnerpartyname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partnerpartyname"
																placeholder="Enter Name of Party" readonly></td>
															<td><input type="text" id="partnerprojectname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partnerprojectname"
																placeholder="Enter Project Name" readonly></td>
															<td><input type="text" id="partnertechpersonname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partnertechpersonname"
																placeholder="Enter Technical Person Name" readonly></td>
															<td><input type="text" id="partnerprsndesignation"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partnerprsndesignation"
																placeholder="Enter Person Designation" readonly></td>
															<td><input type="text" id="partnercontactnumber"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partnercontactnumber"
																placeholder="Enter Contact Number" readonly></td>
															<td><input type="text" id="partneremailid"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="partneremailid" placeholder="Enter Email ID" readonly></td>
														</tr>
														<tr>
															<td>Customer </td>
															<td><input type="text" id="customerpartyname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customerpartyname"
																placeholder="Enter Name of Party" readonly></td>
															<td><input type="text" id="customerprojectname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customerprojectname"
																placeholder="Enter Project Name" readonly></td>
															<td><input type="text" id="customertechpersonname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customertechpersonname"
																placeholder="Enter Technical Person Name" readonly></td>
															<td><input type="text" id="customerprsndesignation"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customerprsndesignation"
																placeholder="Enter Person Designation" readonly></td>
															<td><input type="text" id="customercontactnumber"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customercontactnumber"
																placeholder="Enter Contact Number" readonly></td>
															<td><input type="text" id="customeremailid"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="customeremailid" placeholder="Enter Email ID" readonly></td>
														</tr>
														
																<tr>
															<td>End Customer </td>
															<td><input type="text" id="endcustomerpartyname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="endcustomerpartyname"
																placeholder="Enter Name of Party" readonly></td>
															<td><input type="text" id="endcustomerprojectname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="endcustomerprojectname"
																placeholder="Enter Project Name" readonly></td>
															<td><input type="text" id="endcustomertechpersonname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="endcustomertechpersonname"
																placeholder="Enter Technical Person Name" readonly></td>
															<td><input type="text" id="endcustomerprsndesignation"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="endcustomerprsndesignation"
																placeholder="Enter Person Designation" readonly></td>
															<td><input type="text" id="endcustomercontactnumber"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="endcustomercontactnumber"
																placeholder="Enter Contact Number" readonly></td>
															<td><input type="text" id="endcustomeremailid"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="endcustomeremailid" placeholder="Enter Email ID" readonly></td>
														</tr>

														<tr>
															<td>Implementor from Customer</td>
															<td><input type="text" id="implementorpartyname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="implementorpartyname"
																placeholder="Enter Name of Party" readonly></td>
															<td><input type="text" id="implementorprojectname"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="implementorprojectname"
																placeholder="Enter Project Name" readonly></td>
															<td><input type="text"
																id="implementortechpersonname" tabindex="4"
																class="form-control" data-toogle="tooltip"
																name="implementortechpersonname"
																placeholder="Enter Technical Person Name" readonly></td>
															<td><input type="text"
																id="implementorprsndesignation" tabindex="4"
																class="form-control" data-toogle="tooltip"
																name="implementorprsndesignation"
																placeholder="Enter Person Designation" readonly></td>
															<td><input type="text" id="implementorcontactnumber"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="implementorcontactnumber"
																placeholder="Enter Contact Number" readonly></td>
															<td><input type="text" id="implementoremailid"
																tabindex="4" class="form-control" data-toogle="tooltip"
																name="implementoremailid" placeholder="Enter Email ID" readonly></td>
														</tr>

													</tbody>

												</table>
										



											</div>
                                                <div class="col-md-1" ></div>   
                                           
                                 </div>
        </div>
        <div class="tab-pane fade" id="custom-tabs-one-messages" role="tabpanel" aria-labelledby="custom-tabs-one-messages-tab">
           
           
           <div class="row">
                                                    
                                                    <div class="col-md-1" ></div>
                                     <div class="col-md-10">




												<div class="row">
													<div class="col-md-6" style="margin-top: 15px;">
														<label>Date : </label>
														<div id="date1"></div>
														<input type="text" id="form2date" tabindex="1"
															class="form-control" data-toogle="tooltip"
															name="form2date" readonly>
													</div>

													<div class="col-md-6" style="margin-top: 15px;">
														<label>Customer Name :</label>
														<div id="Customer1"></div>
														<input type="text" id="form2customername" tabindex="2"
															class="form-control" data-toogle="tooltip"
															name="form2customername"
															placeholder="Enter Your Customer Name Here " readonly>
													</div>

												</div>

												<div class="row">
												
													<div class="col-md-6" style="margin-top: 15px;">
														<label>PO number :</label>
														<div id="poform2No1"></div>
														<input type="text" id="poform2No" tabindex="3"
															class="form-control" data-toogle="tooltip"
															name="poform2No" readonly placeholder="Enter PO Number">
													</div>


													<div class="col-md-6" style="margin-top: 15px;">
														<label>Purchase Order Timeline :</label>
														<!-- 											<div id="pot"></div> -->
														<!-- 											<input type="date" id="potimeline" tabindex="3" -->
														<!-- 												class="form-control" data-toogle="tooltip" name="potimeline"> -->
														<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="far fa-calendar-alt"></i>
																</span>
															</div>
															<input type="text" readonly="true"
																="1"
																	class="form-control pull-right"
																autocomplete="off" name="potimeline" id="potimeline"
																placeholder="Please Select  Date"
																dateformat="dd-MMM-yyyy">
														</div>
													</div>

												</div>

												<div class="row">

												
													<div class="col-md-6" style="margin-top: 15px;">
														<label>RFP Timelines :</label>
														<!-- 											<div id="rpf1"></div> -->
														<!-- 											<input type="date" id="RPFTIMELINES" tabindex="3" -->
														<!-- 												class="form-control" data-toogle="tooltip" -->
														<!-- 												name="RPFTIMELINES"> -->
														<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="far fa-calendar-alt"></i>
																</span>
															</div>
															<input type="text" readonly="true"
																="1"
																	class="form-control pull-right"
																autocomplete="off" name="RPFTIMELINES" id="RPFTIMELINES"
																placeholder="Please Select  Date"
																dateformat="dd-MMM-yyyy">
														</div>
													</div>

													<div class="col-md-6" style="margin-top: 15px;">
														<label>1st Invoice Generation Date :</label>
														<!-- 											<div id="firstinvoice"></div> -->
														<!-- 											<input type="date" id="firstinvoicegeneratedate" tabindex="3" -->
														<!-- 												class="form-control" data-toogle="tooltip" -->
														<!-- 												name="firstinvoicegeneratedate"> -->
															<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="far fa-calendar-alt"></i>
																</span>
															</div>
															<input type="text" readonly="true"
																="1"
																	class="form-control pull-right"
																autocomplete="off" name="firstinvoicegeneratedate" id="firstinvoicegeneratedate"
																placeholder="Please Select  Date"
																dateformat="dd-MMM-yyyy">
														</div>
													</div>
												</div>





												<div class="row">

													<div class="col-md-6" style="margin-top: 15px;">
														<label>Project Start Date :</label>
<!-- 														<div id="rpf13"></div> -->
<!-- 														<input type="date" id="projstartdate" tabindex="3" -->
<!-- 															class="form-control" data-toogle="tooltip" -->
<!-- 															name="projstartdate"> -->
		<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="far fa-calendar-alt"></i>
																</span>
															</div>
															<input type="text" readonly="true"
																="1"
																	class="form-control pull-right"
																autocomplete="off" name="projstartdate" id="projstartdate"
																placeholder="Please Select  Date"
																dateformat="dd-MMM-yyyy">
														</div>
													</div>

													<div class="col-md-6" style="margin-top: 15px;">
														<label>Project End Date :</label>
<!-- 														<div id="pot222"></div> -->
<!-- 														<input type="date" id="projenddate" tabindex="3" -->
<!-- 															class="form-control" data-toogle="tooltip" -->
<!-- 															name="projenddate"> -->
	<div class="input-group">
															<div class="input-group-prepend">
																<span class="input-group-text"> <i
																	class="far fa-calendar-alt"></i>
																</span>
															</div>
															<input type="text" readonly="true"
																="1"
																	class="form-control pull-right"
																autocomplete="off" name="projenddate" id="projenddate"
																placeholder="Please Select  Date"
																dateformat="dd-MMM-yyyy">
														</div>
													</div>
												</div>

												<div class="row">


													<div class="col-md-6" style="margin-top: 15px;">
														<label>Payment Terms</label>
														<div id="paymentermmmm"></div>
														<!-- 											<input type="text" id="pymentterms" tabindex="2" -->
														<!-- 												class="form-control" data-toogle="tooltip" -->
														<!-- 												name="pymentterms" placeholder="Enter Your Payments Here "> -->

														<textarea id="pymentterms" name="pymentterms" tabindex="2"
															class="form-control" data-toogle="tooltip"
															placeholder="Enter Your Payments Here" readonly></textarea>


													</div>


													<div class="col-md-6" style="margin-top: 15px;">
														<label>Project Head :</label>
														<div id="projhead"></div>
														<input type="text" id="projecthead" tabindex="2"
															class="form-control" data-toogle="tooltip"
															name="projecthead"
															placeholder="Enter Your Project Head Name Here " readonly>
													</div>
												</div>

												<div class="row">


														<div class="col-md-6" style="margin-top: 25px;">

<label>Customer Flow chart for payment process & only collection if any :</label>
											<div id="chartpaymnt"></div> 
											 <input type="text" id="chartpaymntno" tabindex="3" class="form-control"
												data-toogle="tooltip" name="chartpaymntno"  readonly>
												
<!--     <option value="NA">NA</option> -->
<!--     <option value="Yes">Yes</option> -->
<!--     <option value="No">No</option> -->

<!--     </select> -->
												
								   </div>

													<div class="col-md-6"
														style="margin-top: 15px; display: none;" id="remarksid">
														<label for="Remarks">Remarks :</label>
														<textarea  rows="2" cols="20" id="Remarks"
															tabindex="12" class="form-control" data-toogle="tooltip"
															name="Remarks" placeholder="Please Enter Remarks"
															maxlength="2000" readonly>
                                                    </textarea>
													</div>






												</div>
												
												<br>
												<hr>
												<form>
												<div class="col-md-12" id="inputContainer">
												
												
												</div> 
												</form>
												<hr>
												<br>
												
											</div>
                                                    <div class="col-md-1" ></div>
                                                </div>  
           
        </div>
    </div>
</div>

<!-- Your hidden divs with different ids and content -->
<div id="contentTab1" style="display: none">
    <div>
        <label>Content for Tab 1:</label>
        <p>This is the content for Tab 1.</p>
    </div>
</div>


 
                                       
										<!-- // Ends -->
                                    <br>
                                        
                                    
                                    
                                    

                                        </div>
                                        
<!--                                         <div style="margin-top:15px;" class="col-md-12"> -->
<!--                                         <center> -->
<!--                                                                                            <input type="submit" tabindex="8" class="btn btn-primary m-t-10" id="submit-btnnn"  name="submit" value="Submit"> <span class="spinner" style=" display: none"><i class="fa fa-refresh fa-spin fa-10x"></i></span> -->
<!--                                             <button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="ApproveCM" name="ApproveCM" data-style="expand-left" >Approve &nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem;display: none;" id="spin1"><i class="fa fa-refresh fa-spin fa-10x"></i></span></button>   -->
<!-- <!--                                             <button type="submit" tabindex="8" class="btn btn-primary m-t-10" id="Reject" name="Reject" onclick="myFunctionReject();">Feedback &nbsp;<span class="spinner-border" style="width: 1rem; height: 1rem;display: none;" id="spin2"><i class="fa fa-refresh fa-spin fa-10x"></i></span></button>   --> 
<!--                                         </center> -->
<!--                                     </div> -->
                                    
<!--                                     <br> -->
              <!-- /.card -->
               </div>
</div>
       

</div>
                                        

<!-- 					</div> -->
<!-- 				</div> -->
				
		


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
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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



   
	<script src="<%=request.getContextPath()%>/static/custom/ViewRejectedCMDetails.js"></script>

</body>
</html>