<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>FORM 3</title>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->

 <link rel="stylesheet" href="<%=request.getContextPath()%>/static/js/multiselect2/bootstrap-multiselect.css" type="text/css"/>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->

<!--   <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap/dist/css/bootstrap.min.css">-->
<!-- Tempusdominus Bbootstrap 4 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<!--<link rel="stylesheet" href="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jqvmap.min.css">-->
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/dist/css/adminlte.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Datatables -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
<!-- <script src="<%=request.getContextPath()%>/resources/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css"></script>-->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
<!-- bootstrap datepicker -->
<!--  <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">-->
<!-- Sweetalert 2 -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">
<!-- <link rel="stylesheet" type="text/css" -->
<%-- 	href="<%=request.getContextPath()%>/static/multiselect/bootstrap-multiselect.css"> --%>

<!-- summernote -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
<style type="text/css">
.card {
	border: 1px solid rgb(0, 123, 255) !important;
}
.form-control-feedback {
right: 25px !important;
}

.buttonnw {
/*   //background-color: #4CAF50; */
  border: none;
  color: white;
  padding: 5px 21px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

select {
	background-color: white;
}

.form-group.has-success label {
	color: #000000;
}
.dropdown-menu>.active>a, .dropdown-menu>.active>a:focus, .dropdown-menu>.active>a:hover
	{
	background-color: #fff;
	color: #000;
}
.row {
    margin-right: -25px;
    margin-left: -15px;
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
						<br> <br>
						<div class="card card-secondary">
							<div class="card-header">FORM 3 </div>
							<div class="card-body">
							
						

                               <div class="row">
										<div class="col-md-6" >
											<label >Date : </label>
											<div id="date1"></div> 
											<input
												type="date" id="date" tabindex="1" class="form-control"
												data-toogle="tooltip" name="date">
										</div>
										<div class="col-md-6" >
											<label >Project Implementor Name :</label>
											<div id="impl1"></div> 
											 <input
												type="text" id="projeimplementorname" tabindex="2"
												class="form-control" data-toogle="tooltip" name="projeimplementorname" placeholder="Enter Your Project Implementor Name Here ">
										</div>									
						       </div>  
								
						        <div class="row"> 
									
									<div class="col-md-6" >
											<label >Customer Name :</label>
											<div id="Customer1"></div> 
											 <input
												type="text" id="customername" tabindex="3"
												class="form-control" data-toogle="tooltip" name="customername" placeholder="Enter Your Customer Name Here ">
										</div>	
										
										<div class="col-md-6" >
											<label>Project Name :</label>
											<div id="proj"></div> 
											 <input
												type="text" id="projectname" tabindex="4" class="form-control"
												data-toogle="tooltip" name="projectname" placeholder="Enter your Project Name Here" >
										</div>	
								
							    									                                																		
							       </div>
									
							
								
								
								
								
													
							</div>
						</div>
					</div>	
					
					
<!-- 		 add row code here  -->
   <br><br>
   
   
   
   
   
<!--    <div class="row"> -->
   
<!-- <button onclick="addRow()">Add Row</button> -->
<!-- <button onclick="submitData()">Submit</button> -->


<!--               <div class="col-md-12" >	 -->
<!-- 						<button type="button" onclick="addRow()"  -->
<!-- 							class="btn btn-sm btn-primary "  -->
<!-- 							 style="margin-left: 16px;">Add Row</button> -->
							
							
<!-- 						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;													 -->
<!--              </div> -->
<!-- 	</div> -->
	<br><br>





	   <div class="row">
                <br>
									
						<div class="col-md-2"></div>
						<div class="col-md-12">
							<div class="card card-secondary"
								style="margin-left: 175px; margin-right: 15px">
								<div class="card-header">FORM 3 Details</div>
								<div class="card-body">
									<div id="eeeew">

									
										
<!-- 					start new added row 				 -->
                                  <table id="data-table1">
											<thead>
												<tr>
													<th data-row-id="row-1">Server Availability :</th>
													<th>Responsibility :</th>
													<th>Start Date :</th>
													<th>End Date :</th>
													<th>Action </th>

												</tr>
											</thead>
											<tbody>
												<tr data-row-id="row-1">
													
													<td><input type="text" placeholder="Enter your Server Availability " id="serverAvail" name="serverAvail"></td>
													<td><input type="text" placeholder="Enter Your Responsibility" id="Responsibility" name="Responsibility"></td>
													<td><input type="datetime-local" id="startdate" name="startdate"></td>
													<td><input type="datetime-local" id="enddate" name="enddate"></td>
													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td>
													
												</tr>
											</tbody>
										</table>
                     
                       <table id="data-table2">
											<thead>
												<tr>
													<th data-row-id="row-1">Install Of Velox License :</th>
												</tr>
											</thead>
											<tbody>
												<tr data-row-id="row-1">
													
													<td><input type="text" placeholder="Enter your Install Of Velox License" id="installvlxlicense" name="installvlxlicense"></td>
													<td><input type="text" placeholder="Enter Your Responsibility" id="Responsibilityvlxlicense" name="Responsibilityvlxlicense"></td>
													<td><input type="datetime-local" id="startdatevlxlicense" name="startdatevlxlicense"></td>
													<td><input type="datetime-local" id="enddatevlxlicense" name="enddatevlxlicense"></td>
													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td>
													
												</tr>
											</tbody>
										</table>
										
										
										
										  <table id="data-table3">
											<thead>
												<tr>
													<th>UAT Testing :</th>

												</tr>
											</thead>
											<tbody>
												<tr data-row-id="row-1">
													
													<td><input type="text" placeholder="Enter your  UAT Testing" id="UATTesting" name="UATTesting"></td>
													<td><input type="text" placeholder="Enter Your Responsibility" id="Responsibilityuattesting" name="Responsibilityuattesting"></td>
													<td><input type="datetime-local" id="startdateuattesting" name="startdateuattesting"></td>
													<td><input type="datetime-local" id="enddateuattesting" name="enddateuattesting"></td>
													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td>
													
												</tr>
											</tbody>
										</table>
										
										
										
										 <table id="data-table4">
											<thead>
												<tr >
													<th>Production GO Live :</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													
													<td><input type="text" placeholder="Enter your Production GO Live" id="productiongolive" name="productiongolive"></td>
													<td><input type="text" placeholder="Enter Your Responsibility" id="Responsibilitygolive" name="Responsibilitygolive"></td>
													<td><input type="datetime-local" id="startdategolive" name="startdategolive"></td>
													<td><input type="datetime-local" id="enddategolive" name="enddategolive"></td>
													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td>
													
												</tr>
											</tbody>
										</table>
										
										 <table id="data-table5">
											<thead>
												<tr>
													<th>Rollout</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													
													<td><input type="text" placeholder="Enter your Rollout" id="rollout" name="rollout"></td>
													<td><input type="text" placeholder="Enter Your Responsibility" id="Responsibilityrollout" name="Responsibilityrollout"></td>
													<td><input type="datetime-local" id="startdaterollout" name="startdaterollout"></td>
													<td><input type="datetime-local" id="enddaterollout" name="enddaterollout"></td>
													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td>
													
												</tr>
											</tbody>
										</table>
										
										
									
									 <table id="data-table6">
											<thead>
												<tr>
													<th>DEMO Live :</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													
													<td><input type="text" placeholder="Enter your DEMO Live " id="demolive" name="demolive"></td>
													<td><input type="text" placeholder="Enter Your Responsibility" id="Responsibilitydemo" name="Responsibilitydemo"></td>
													<td><input type="datetime-local" id="startdatedemo" name="startdatedemo"></td>
													<td><input type="datetime-local" id="enddatedemo" name="enddatedemo"></td>
													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td>
													
												</tr>
											</tbody>
										</table>
										
										 <table id="data-table7">
											<thead>
												<tr>
													<th data-row-id="row-1">Payment Terms :</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													
													<td><input type="text" placeholder="Enter your Payment Terms" id="paymentterms" name="paymentterms"></td>
													<td><input type="text" placeholder="Enter Your Responsibility" id="Responsibilitypaymentterms" name="Responsibilitypaymentterms"></td>
													<td><input type="datetime-local" id="startdatepaymentterms" name="startdatepaymentterms"></td>
													<td><input type="datetime-local" id="enddatepaymentterms" name="enddatepaymentterms"></td>
													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td>
													
												</tr>
											</tbody>
										</table>	
										
									
									 <table id="data-table8">
											<thead>
												<tr>
													<th data-row-id="row-1">Sign Off :</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													
													<td><input type="text" placeholder="Enter your Sign Off" id="signoff" name="signoff"></td>
													<td><input type="text" placeholder="Enter Your Responsibility" id="Responsibilitysignoff" name="Responsibilitysignoff"></td>
													<td><input type="datetime-local" id="startdatesignoff" name="startdatesignoff"></td>
													<td><input type="datetime-local" id="enddatesignoff" name="enddatesignoff"></td>
													<td><button onclick="deleteRow(this)" class="btn btn-sm btn-danger ">Delete Row</button></td>
													
												</tr>
											</tbody>
								  </table>
								
<!-- 						<br><br>		 -->
<!-- 						<div class="col-md-12" >	 -->
<!-- 						<button type="button" onclick="addRow()"  -->
<!-- 							class="btn btn-sm btn-primary " id="addRowButton" -->
<!-- 							 style="margin-left: -1%;">Add Row</button> -->
															
<!--                          </div>	 -->
 
										
							
<!--                      end new added row                 -->
																	
								<div class="row">

										<div style="margin-top: 15px;" class="col-md-12">
											<center>
												
												<button type="button"  class="btn btn-primary m-t-10"
													tabindex="4" id="submit-btn" name="submit">Submit
												</button>
											</center>
										</div>
							   </div>	
								
									</div>

								</div>
							</div>
						</div>
						<div class="col-md-2"></div>
					</div>

									</div>
								</div>
							</div>
						</div>
					</div></section>
		</div>
			
</body>
		


		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		<!-- Control Sidebar -->
		<aside class="control-sidebar control-sidebar-dark">
			<!-- Control sidebar content goes here -->
		</aside>
		<!-- /.control-sidebar -->
	</div>
	<!-- ./wrapper -->
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script
		src="<%=request.getContextPath()%>/static//AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery/dist/jquery.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/jquery-ui/jquery-ui.min.js"></script>
	<%--  <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.js"></script> --%>

	<%--   <script src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap/dist/js/bootstrap.min.js"></script> --%>
	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/sparklines/sparkline.js"></script>
	<!-- JQVMap -->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jquery.vmap.min.js"></script>-->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>-->
	<!-- jQuery Knob Chart -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/moment/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.js"></script>
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script> -->
	<script
		src="<%=request.getContextPath()%>/static/resources1/bowercomponents/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<!--bootstrap datepicker-->
	<!--<script src="https://adminlte.io/themes/AdminLTE/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>-->
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/adminlte.js"></script>-->
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/pages/dashboard.js"></script>-->
	<!-- AdminLTE for demo purposes -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/dist/js/demo.js"></script>

	<!-- Sweetalert 2 -->
	<script
		src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>

	<!-- DataTables -->
	<!--    <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net/js/jquery.dataTables.js"></script>
     <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net-bs/js/dataTables.bootstrap.js"></script>
     <script src="<%=request.getContextPath()%>/resources/bowercomponents/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>-->

	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>

 <script src="<%=request.getContextPath()%>/static/multiselect/jquery-3.5.1.min.js"></script>
 <script src="<%=request.getContextPath()%>/static/multiselect/popper.min.js"></script>
 <script src="<%=request.getContextPath()%>/static/multiselect/bootstrap.min.js"></script>
 <script src="<%=request.getContextPath()%>/static/multiselect/bootstrap-multiselect.js"></script>

	<!--<script src="../../plugins/datatables/jquery.dataTables.min.js"></script>-->
	<!--<script src="../../plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>-->
	<!--<script src="../../plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>-->
	<!--<script src="../../plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>-->

	<!--<script src="<%=request.getContextPath()%>/resources/Listing/dataTables.bootstrap.min.js"></script>-->
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/dataTables.buttons.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/jszip.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/pdfmake.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/vfs_fonts.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.html5.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.print.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/Listing/buttons.colVis.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/custom/FORM3.js"></script>

</body>

</html>


