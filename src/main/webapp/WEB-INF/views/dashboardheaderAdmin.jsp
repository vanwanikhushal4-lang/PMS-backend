<%@ page isELIgnored="false"%>

<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 3 | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
  
<!--   <link rel="stylesheet" -->
<%-- 	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/fas-all.min.css"> --%>
	
  <!-- Ionicons -->
  <!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->
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
  <!-- Daterange picker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
  <!-- Google Font: Source Sans Pro -->
  <!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->
  
  
  
</head>
<style type="text/css">
@media screen and (max-width: 768px){
      #headername {
           /*font-size: 70%;*/
           /*font-weight: bold;*/
         
           max-height: 45px;
           margin-top: -2px;
            margin-bottom: -2px;
            margin-left: -5px;
          width: 45vw;
    /* min-width: 20%; */
    max-width: 200px;
      }
}
@media screen and (min-width: 768px){
    #headername {
        /*width: 175px;*/
    /*font-size: 100%;*/
     max-height: 45px;
      /*max-width: 100px;*/
       width: 220px;
   
           /*margin-top: 6px;*/
     /*margin-top: -10px;*/
    /*line-height: 22px;*/
} 
}
.setcard {
	margin-bottom: 0rem !important;
}
#profileImage {
  width: 75px;
  height: 75px;
  border-radius: 50%;
  background: #6c757d;
  font-size: 35px;
  color: #fff;
  text-align: center;
  line-height: 75px;
/*   margin: 20px 0; */
}

 .rowflex{
 display: flex !important;
 flex-wrap: nowrap !important;
 }
</style>
    <body>
    
    
        <%
            String role = (String) session.getAttribute("role");
            System.out.println("roleee" + role);
            
        %>
    
    <input type="hidden" id="role" name="role" value="<%=role%>">

<!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-dark">
     
     
    <!-- Left navbar links -->
    <ul class="navbar-nav" id="navLinksSuppport" style="display :none;">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
    <li class="nav-item d-none d-sm-inline-block">
        <a href="<%=request.getContextPath()%>/Admin/AdminHome" class="nav-link ">Home</a>
     </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="<%=request.getContextPath()%>/Admin/OperationalDashboard" class="nav-link">Operational</a>
      </li>
<!--        <li class="nav-item d-none d-sm-inline-block"> -->
<%--  		<a href="<%=request.getContextPath()%>/Admin/RFPDashboard" class="nav-link">Velox 3.0</a>  --%>
<!--       </li> -->
    </ul>
    
    
     <ul class="navbar-nav" id="navLinksUser" style="display :none;">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
    <li class="nav-item d-none d-sm-inline-block">
        <a href="<%=request.getContextPath()%>/Admin/AdminHome" class="nav-link ">Home</a>
     </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="<%=request.getContextPath()%>/Admin/OperationalDashboardUser" class="nav-link">Operational</a>
      </li>
    </ul>

    <!-- SEARCH FORM -->
    <div class="form-inline" style="flex-basis: 50%;flex-direction: column; align-items: flex-end;">
      <!--<div class="input-group input-group-sm">-->
      <!--<div id="headername">-->
<!--          <span  style= "font-family:sans-serif;color:#fff;" id="headername">Information Technology Service Management</span>-->
<!--<span style= "font-family:Helvetica;color:orange; margin-right: 67px; margin-right: 58px; float: right;">Core</span><br>
<span style= "font-family:Helvetica;color:orange;">Knowledge Base</span>-->
<!--           <span  style= "font-family:Helvetica;color:orange;font-size:24px; max-height: 45px; margin-top: -22px; margin-bottom: -25px; font-weight: bold">Knowledge Base</span>-->
<!--<span style="height:41px">  
-->
<%-- <img src="<%=request.getContextPath()%>/static/resources/img/slider/scm_12.png" id="headername"> --%>
<%-- <img src="<%=request.getContextPath()%>/static/resources/img/veloxlogo.png" id="headername"> --%>
<%-- <img src="<%=request.getContextPath()%>/static/resources/img/veloxlogo.png" alt=""> --%>

<img src="<%=request.getContextPath()%>/static/resources/img/slider/Capture_final.PNG" style="height: 45px; margin-right: 3%; display:none;" id="MainLogo">
<img src="<%=request.getContextPath()%>/static/resources/img/slider/Capture_final.PNG" style="height: 45px; margin-right: 40%; display:none;" id="SupportLogo" >
<!--
</span>-->

<!--</div>-->
      
        <!--<div class="input-group-append">-->
<!--          <button class="btn btn-navbar" type="submit">
            <i class="fas fa-search"></i>
          </button>-->
        <!--</div>-->
      <!--</div>-->
    </div>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
    
      <!-- Messages Dropdown Menu -->
   <%--   <jsp:include page="/Announcement/Announcement.jsp"></jsp:include> --%>
      <!-- Notifications Dropdown Menu -->
      
         <!--//////////////NOTIFCATION BELL STARTS/////////////////-->
<!--      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-bell" style="color:#fff;"></i>
          <span class="badge badge-warning navbar-badge">15</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <span class="dropdown-item dropdown-header">15 Notifications</span>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-envelope mr-2"></i> 4 new messages
            <span class="float-right text-muted text-sm">3 mins</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-users mr-2"></i> 8 friend requests
            <span class="float-right text-muted text-sm">12 hours</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-file mr-2"></i> 3 new reports
            <span class="float-right text-muted text-sm">2 days</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
        </div>
      </li>-->
<!--        <li class="nav-item dropdown ml-n1"> -->
<%-- 		<jsp:include page="/WEB-INF/views/Notifications/Outage_forItHead.jsp"></jsp:include> --%>
<!-- 		</li> -->
<!--        //////////////OUTAGE BELL STARTS///////////////// -->
<!--          //////////////NOTIFCATION BELL STARTS///////////////// -->
<%-- 		<jsp:include page="/WEB-INF/views/Notifications/Notification_ForItHead.jsp"></jsp:include> --%>
<!--       //////////////NOTIFCATION BELL ENDS///////////////// -->

<!-- notification-->
		<!-- notification-->
                        <li class="list-inline-item dropdown notification-list" id="notification_icon" style="display :none;">
                            <a class="nav-link dropdown-toggle arrow-none waves-effect" id="showNotification" onclick="bellNotification()" data-toggle="dropdown" href="javascript:void(0);" role="button"
                               aria-haspopup="false" aria-expanded="false">
                                <i class="fa fa-bell"></i>

                                <span class="badge badge-danger noti-icon-badge"><span id="count"></span></span>

                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-arrow dropdown-menu-lg">
                                <!-- item-->
                                <div class="dropdown-item noti-title" id="assigned_today">
                                    <h6 style="color:grey">Activities Assigned Today(<span id="count1" style="color:red"></span>)</h6>
                                </div>
                                
                                <div class="dropdown-item noti-title" id="customization_act">
                                    <h6 style="color:grey">Customization Task(<span id="count5" style="color:red"></span>)</h6>
                                </div>
                                
                                <div class="dropdown-item noti-title" id="revise_dates">
                                    <h6 style="color:grey">Approval Of Revise Dates(<span id="count2" style="color:red"></span>)</h6>
                                </div>
                                
                                <div class="dropdown-item noti-title" id="reactivate_account">
                                    <h6 style="color:grey">Reactivate Team Account(<span id="count3" style="color:red"></span>)</h6>
                                </div>
                                
                                 <div class="dropdown-item noti-title" id="formC">
                                    <h6 style="color:grey">Form C(<span id="count4" style="color:red"></span>)</h6>
                                </div>
                                
                                
                                <div class="dropdown-item noti-title" id="NoNotification" style="display : none;">
                                    <h6 style="color:grey">No Notifications</h6>
                                </div>
                                
                                

                                <div id="notification" ></div>
  
                                
                                <div id="notificationContainer" class="notification-list" >
								    <ul id="notificationList">
								        
								    </ul>
								</div>
								
								
								<!-- All-->
                                <a href="javascript:void(0);" id="viewAllDown" class="dropdown-item notify-item">
                                    View All
                                </a>

                            </div>
                        </li>
      
      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
          <i class="fas fa-th-large"></i>
        </a>
      </li>
      
       <li class="nav-item dropdown" style="width: 150px;">
<!--         <a class="nav-link" data-toggle="dropdown" href="#" style="width: 180px;"> -->
          
<!--               <span class="ml-n3"> -->
<%-- 				<i class="far fa-user">&nbsp;<%=session.getAttribute("username")%></i> --%>
<!--               </span> -->
          
<!--         </a> -->

<a class="nav-link"  data-toggle="dropdown" href="#" >
    <span class="ml-n3" class="widget-user-username" style="font-family: 'Verdana', 'Geneva', sans-serif;">
        <i class="far fa-user">&nbsp;<%= session.getAttribute("fullname") %></i>
    </span>
</a>

        <ul class="dropdown-menu dropdown-menu-xl userexpand bg-dark">
					<!-- User image -->


					<!--<img src="<%=request.getContextPath()%>/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">-->


					<!--<a href="#" class="btn btn-default btn-flat">Sign out</a>-->
					<%--                  <a href="<%=request.getContextPath()%>/login/LOGOUT"> <li style="text-align: center;">Logout</li></a> --%>
					<li>
						<div class="card card-widget widget-user-2 setcard">
							<!-- Add the bg color to the header using any of the bg-* classes -->
							<div class="widget-user-header bg-dark">
								                <div class="widget-user-image float-right">
<!-- 								                  <img class="img-circle elevation-2" src="../dist/img/user7-128x128.jpg" alt="User Avatar"> -->
										<div id="profileImage"></div>
								                </div>
								<!-- /.widget-user-image -->
								<h3 class="widget-user-username"
									style="margin-left: 0px !important"><%=session.getAttribute("fullname")%></h3>
								<h5 class="widget-user-desc" style="margin-left: 0px !important"><%=session.getAttribute("VIEW_DESIGNATION")%></h5> <!-- designation   -->
							</div>
							<div class="card-footer p-0">
								<ul class="nav flex-column">

									<!--                   <li class="nav-item"> -->
									<!--                     <span class="nav-link" style="color:#000000 !important">Company  -->
									<!--                     <span class="float-right badge bg-secondary" style="font-size:100% !important"> -->
									<%--                       <%=session.getAttribute("companyname")%></span> --%>
									<!--                     </span> -->
									<!--                   </li> -->


									<li class="nav-item">
										<div class="row align-items-center h-100 rowflex">
											<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4 col-xl-4">
												<span class="nav-link" style="color: #000000 !important; font-weight: 700; font-size: small;">Username
												</span>
											</div>
											<div class="col-lg-8 col-sm-8 col-md-8 col-xs-8 col-xl-8">
												<span class="float-right badge bg-secondary"
													style="font-size: 100% !important; white-space: initial !important; margin-top: 5px; margin-bottom: 5px; margin-right: 15px">
													<%=session.getAttribute("username")%></span>
											</div>
										</div>
									</li>


									<li class="nav-item">
										<div class="row align-items-center h-100 rowflex">
											<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4 col-xl-4">
												<span class="nav-link" style="color: #000000 !important; font-weight: 700; font-size: small;">Company
												</span>
											</div>
											<div class="col-lg-8 col-sm-8 col-md-8 col-xs-8 col-xl-8">
												<span class="float-right badge bg-secondary"
													style="font-size: 100% !important; white-space: initial !important; margin-top: 5px; margin-bottom: 5px; margin-right: 15px">
													<%=session.getAttribute("companyname")%></span>
											</div>
										</div>
									</li>

									<li class="nav-item">
										<div class="row align-items-center h-100 rowflex">
											<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4 col-xl-4">
												<span class="nav-link" style="color: #000000 !important; font-weight: 700; font-size: small;">Branch
												</span>
											</div>
											<div class="col-lg-8 col-sm-8 col-md-8 col-xs-8 col-xl-8">
												<span class="float-right badge bg-secondary"
													style="font-size: 100% !important; white-space: initial !important; margin-top: 5px; margin-bottom: 5px; margin-right: 15px">
													<%=session.getAttribute("loginBanch")%></span>
											</div>
										</div>
									</li>

									<li class="nav-item">
										<div class="row align-items-center h-100 rowflex">
											<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4 col-xl-4">
												<span class="nav-link" style="color: #000000 !important; font-weight: 700; font-size: small;">Department
												</span>
											</div>
											<div class="col-lg-8 col-sm-8 col-md-8 col-xs-8 col-xl-8">
												<span class="float-right badge bg-secondary"
													style="font-size: 100% !important; white-space: initial !important; margin-top: 5px; margin-bottom: 5px; margin-right: 15px">
													<%=session.getAttribute("loginDepartment")%></span>
											</div>
										</div>
									</li>

									<li class="nav-item">
										<div class="row align-items-center h-100 rowflex">
											<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4 col-xl-4">
												<span class="nav-link" style="color: #000000 !important; font-weight: 700; font-size: small;">Role
												</span>
											</div>
											<div class="col-lg-8 col-sm-8 col-md-8 col-xs-8 col-xl-8">
												<span class="float-right badge bg-secondary"
													style="font-size: 100% !important; white-space: initial !important; margin-top: 5px; margin-bottom: 5px; margin-right: 15px">
													<%=session.getAttribute("role")%></span>
											</div>
										</div>
									</li>

									<li class="nav-item"><a
										class="nav-link bg-dark text-center"
										href="<%=request.getContextPath()%>/login/LOGOUT"
										style="font-weight: 600; line-height: 1.2; font-size: 15px;">
											Logout</a></li>
								</ul>
							</div>
						</div>
					</li>

				</ul>
      </li>
<!--      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button">
          <i class="fas fa-th-large" style="color:#fff;"></i>
        </a>
      </li>-->
    </ul>
      
  </nav>
  <!-- /.navbar -->

  <!-- jQuery -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>-->
<!-- ChartJS -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<!-- <script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>-->
<!-- jQuery Knob Chart -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jquery-knob/jquery.k //nob.min.js"></script>-->
<!-- daterangepicker -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/moment/moment.min.js"></script>
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/dist/js/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/pages/dashboard.js"></script>-->
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/dist/js/demo.js"></script>
</body>
<script>
$(document).ready(function(){
var fullname = '<%= session.getAttribute("fullname")%>';
var firstLetter=fullname.charAt(0);
var lastName=fullname.substring(fullname.lastIndexOf(' ') + 1);
var lastLetter=lastName.charAt(0);
var profileImage = $('#profileImage').text(firstLetter+lastLetter);
	});
</script>     
</html>


