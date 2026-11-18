<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!doctype html>

<html class="no-js" lang="en">


<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Add Customer</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- favicon
		============================================ -->
<link rel="shortcut icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/static/images/favicon.ico">
<!-- Google Fonts
		============================================ -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i,800"
	rel="stylesheet">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/bootstrap.min.css">
<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/font-awesome.min.css">
<!-- adminpro icon CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/adminpro-custon-icon.css">
<!-- meanmenu icon CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/meanmenu.min.css">
<!-- mCustomScrollbar CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/jquery.mCustomScrollbar.min.css">
<!-- animate CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/animate.css">
<!-- modals CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/modals.css">
<!-- normalize CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/normalize.css">
<!-- touchspin CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/touchspin/jquery.bootstrap-touchspin.min.css">
<!-- datapicker CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/datapicker/datepicker3.css">
<!-- forms CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/form/themesaller-forms.css">
<!-- colorpicker CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/colorpicker/colorpicker.css">
<!-- select2 CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/select2/select2.min.css">
<!-- chosen CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/chosen/bootstrap-chosen.css">
<!-- ionRangeSlider CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/ionRangeSlider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="css/ionRangeSlider/ion.rangeSlider.skinFlat.css">
<!-- style CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/style.css">
<!-- responsive CSS
		============================================ -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminPro/css/responsive.css">
<!-- modernizr JS
		============================================ -->
<script
	src="<%=request.getContextPath()%>/static/AdminPro/js/vendor/modernizr-2.8.3.min.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.css" />
<script
	src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css" />
<script
	src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>
</head>
<style>
.sparkline11-graph {
	padding-bottom: 0
}
.fixed-table-loading{
visibility: hidden;
}
</style>



<body class="materialdesign">


	<!-- Left Panel -->
	<div class="wrapper-pro">
		<jsp:include page="/WEB-INF/views/adminsidebar.jsp" />

		<div class="content-inner-all">
<%-- 			<jsp:include page="/WEB-INF/views/dashboardheader.jsp" /> --%>
<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>
			<!-- Header-->





			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">

				

						<div class="sparkline11-list shadow-reset mg-t-30">
							<div class="sparkline11-hd">
								<div class="main-sparkline11-hd">
									<h1>Add Customer</h1>

								</div>
							</div>


							<div class="sparkline11-graph">
								<div class="row">

									<div class="col col-md-6">
										<label>Project Name</label><br>
										 <select id="project" class="form-control" style="width: 95%;" >
											 <option value="" >Please select Project</option>
											 <c:forEach items="${projectdetails}" var="project" varStatus="counter">
											<option value="${project.PROJECT_NAME}" >${project.PROJECT_NAME}</option>
											</c:forEach>
											 </select>
									</div>

									<div class="col col-md-6">
										<label>Customer Name</label><br> <input type="text"
											id="customer" class="form-control" placeholder="Enter Customer Name"
											style="width: 95%;" />
									</div>

								</div>
							</div>

							<div class="sparkline11-graph">
								<div class="row">


									<div class="col col-md-6">
										<label>Customer Short Name</label><br> <input type="text"
											id="customer_short_name" class="form-control"
											placeholder="Enter Customer Short Name" style="width: 95%;" />
									</div>
									<div class="col col-md-6">
										
									</div>
								</div>

							</div>

							<div class="sparkline11-graph">
								

								<div class="form-group-inner">
									<div class="login-btn-inner">
										<div class="row">
											<div class="col-lg-4"></div>
											<div class="col-lg-4" style="margin-left: 50px">
												<div class="login-horizental cancel-wp pull-left">

													<button id="submit-btn"
														class="btn btn-sm btn-primary login-submit-cs"
														type="submit">Submit</button>
													<button id="reset-btn" class="btn btn-white" type="submit">Reset</button>
												</div>
												<br>
												<br>
												<br>
												<br>

											</div>
											<div class="col-lg-4"></div>
										</div>
									</div>
								</div>
							</div>
						</div>


					
				</div>
				<div class="col-lg-2"></div>
			</div>
			
			<div class="modal fade" id="updateCustomer">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                       
									<h4>Customer Details</h4>

							</div>
                                    
                                    <div class="modal-body">
									<div class="row">
				
				<div class="col-lg-12">

	<div class="sparkline11-graph">
								<div class="row">

									<div class="col col-md-6">
										<label>Project Name</label><br>
										 <input type="text" id="m_project" class="form-control" disabled="disabled" style="width: 95%;" >
											 
									</div>

									<div class="col col-md-6">
										<label>Customer Name</label><br> <input type="text"
											id="m_customer" class="form-control" placeholder="Enter Customer Name"
											style="width: 95%;" />
									</div>

								</div>
							</div>

							<div class="sparkline11-graph">
								<div class="row">


									<div class="col col-md-6">
										<label>Customer Short Name</label><br> <input type="text"
											id="m_customer_short_name" class="form-control"
											placeholder="Enter Customer Short Name" style="width: 95%;" />
									</div>
									<div class="col col-md-6">
										
									</div>
								</div>

							</div>



							<div class="sparkline11-graph">


								<div class="form-group-inner">
									<div class="login-btn-inner">
										<div class="row">
											<div class="col-lg-4"></div>
											<div class="col-lg-4" style="margin-left: 50px">
												<div class="login-horizental cancel-wp pull-left">

													<button id="m_submit"
														class="btn btn-sm btn-primary login-submit-cs"
														type="submit">Update</button>
													<button id="m_reset" class="btn btn-white" type="submit">Reset</button>
												</div>
												<br> <br> <br> <br>

											</div>
											<div class="col-lg-4"></div>
										</div>
									</div>
								</div>
						
	</div>

					
				</div>
				
			</div>
                                    </div>

                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                        
                        
                        <div class="row">
		<input type="hidden" id=set_sr> 

				
				 <div class="col-md-12">
				  <div class="sparkline13-graph datatable-dashv1-list custom-datatable-overright"  style="width:95%;margin-left:3%;overflow-y:scroll">
                                <div class="sparkline11-hd">
                                    <div class="main-sparkline11-hd">
                                        <center> <h1>Customer Details</h1></center>
                                       
                                    </div>
                                    </div>

		  	<br>
			<table id="example"  data-toggle="table" data-pagination="true" data-search="true"  >
	    		<thead>
		      		<tr>
				        <th data-sortable="true" style="text-align: center;">Sr No</th>
				        <th data-sortable="true" style="text-align: center;">Project Name</th>
				        <th data-sortable="true" style="text-align: center;">Customer Name</th>
				       <th data-sortable="true" style="text-align: center;">Customer Short Name</th>	
				        <th data-sortable="true" style="text-align: center;">Action</th>		        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${customerdetails}" var="customer" varStatus="counter">
			
					<tr>
						<td style="text-align: center;"> ${counter.count}</td>
						<td style="text-align: center;">${customer.PROJECT_NAME}</td>
						<td style="text-align: center;">${customer.BANK_NAME}</td>
						<td style="text-align: center;">${customer.BANK_SHORT_NAME}</td>
						<td style="text-align: center;">
						<i style="color:green;" class="fa fa-edit" onclick="Update(${customer.SR_NO})"></i>&nbsp;&nbsp;
 						<i style="color:red;" class="fa fa-trash" onclick="Delete(${customer.SR_NO})"></i>&nbsp;&nbsp; 
						</td>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
	    	
		</div>
			
		</div></div>
			
		</div>

<%-- 		<jsp:include page="/WEB-INF/views/Footer.jsp" /> --%>
				<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		
	</div>


	<script type="text/javascript">
		
	</script>




	<!-- jquery
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/vendor/jquery-1.11.3.min.js"></script>
	<!-- bootstrap JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/bootstrap.min.js"></script>
	<!-- meanmenu JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/jquery.meanmenu.js"></script>
	<!-- mCustomScrollbar JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<!-- sticky JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/jquery.sticky.js"></script>
	<!-- scrollUp JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/jquery.scrollUp.min.js"></script>
	<!-- counterup JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/counterup/jquery.counterup.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/counterup/waypoints.min.js"></script>
	<!-- modal JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/modal-active.js"></script>
	<!-- touchspin JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/touchspin/jquery.bootstrap-touchspin.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/touchspin/touchspin-active.js"></script>
	<!-- colorpicker JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/colorpicker/jquery.spectrum.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/colorpicker/color-picker-active.js"></script>
	<!-- datapicker JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/datapicker/bootstrap-datepicker.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/datapicker/datepicker-active.js"></script>
	<!-- input-mask JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/input-mask/jasny-bootstrap.min.js"></script>
	<!-- chosen JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/chosen/chosen.jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/chosen/chosen-active.js"></script>
	<!-- select2 JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/select2/select2.full.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/select2/select2-active.js"></script>
	<!-- ionRangeSlider JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/ionRangeSlider/ion.rangeSlider.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/ionRangeSlider/ion.rangeSlider.active.js"></script>
	<!-- rangle-slider JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/rangle-slider/jquery-ui-1.10.4.custom.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/rangle-slider/jquery-ui-touch-punch.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/rangle-slider/rangle-active.js"></script>
	<!-- knob JS
		============================================ -->
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/knob/jquery.knob.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/knob/knob-active.js"></script>
	<!-- main JS
		============================================ -->
	<script src="<%=request.getContextPath()%>/static/AdminPro/js/main.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/bootstrap-table.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/tableExport.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/data-table-active.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/bootstrap-table-editable.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/bootstrap-editable.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/bootstrap-table-resizable.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/colResizable-1.5.source.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminPro/js/data-table/bootstrap-table-export.js"></script>
	<script src="<%=request.getContextPath()%>/static/master/customermaster.js"></script>


</body>

</html>
