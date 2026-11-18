
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
          width: 36vw;
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

.card{
  border: 1px solid rgb(108, 117, 125) !important;
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

<!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-dark" style="margin-left: 1%;">
     
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
<!--      <li class="nav-item d-none d-sm-inline-block">
        <a href="index3.html" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li>-->
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
<%-- <img src="<%=request.getContextPath()%>/static/resources/img/slider/Velox_Products_Logo_ITSM_NEW.png" id="headername" style="margin-left: 80%;"> --%>
<img src="<%=request.getContextPath()%>/static/resources/img/slider/Capture_final.PNG" style="height: 45px; margin-left: 80%;">
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
<!--     <ul class="navbar-nav ml-auto"> -->
      
<!--       	//////////////NOTIFCATION BELL STARTS///////////////// -->
<!--       	<li class="nav-item dropdown ml-n1"> -->
<%-- 		<jsp:include page="/WEB-INF/views/Notifications/Outage_forTP.jsp"></jsp:include> --%>
<!-- 		</li> -->
<!--       //////////////NOTIFCATION BELL ENDS///////////////// -->
<!--          //////////////NOTIFCATION BELL STARTS///////////////// -->
<%-- 		<jsp:include page="/WEB-INF/views/Notifications/Notification_forTP.jsp"></jsp:include> --%>
<!--       //////////////NOTIFCATION BELL ENDS///////////////// -->
      
<!--       <li class="nav-item ml-n1"> -->
<!--         <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#" role="button"> -->
<!--           <i class="fas fa-th-large"></i> -->
<!--         </a> -->
<!--       </li> -->
      
      
<!--        <li class="nav-item dropdown ml-n1"> -->
<!--         <a class="nav-link" data-toggle="dropdown" href="#"> -->
          
<!--               <span class="ml-n3"> -->
<%-- 				<i class="far fa-user">&nbsp;<%=session.getAttribute("username")%></i> --%>
<!--               </span> -->
          
<!--         </a> -->
<!--        <ul class="dropdown-menu dropdown-menu-xl userexpand bg-dark"> -->
<!-- 					User image -->


<%-- 					<!--<img src="<%=request.getContextPath()%>/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">--> --%>


<!-- 					<a href="#" class="btn btn-default btn-flat">Sign out</a> -->
<%-- 					                 <a href="<%=request.getContextPath()%>/login/LOGOUT"> <li style="text-align: center;">Logout</li></a> --%>
<!-- 					<li> -->
<!-- 						<div class="card card-widget widget-user-2 setcard"> -->
<!-- 							Add the bg color to the header using any of the bg-* classes -->
<!-- 							<div class="widget-user-header bg-dark"> -->
<!-- 								                <div class="widget-user-image float-right"> -->
<!-- <!-- 								                  <img class="img-circle elevation-2" src="../dist/img/user7-128x128.jpg" alt="User Avatar"> --> -->
<!-- 										<div id="profileImage"></div> -->
<!-- 								                </div> -->
<!-- 								/.widget-user-image -->
<!-- 								<h3 class="widget-user-username" -->
<%-- 									style="margin-left: 0px !important"><%=session.getAttribute("fullname")%></h3> --%>
<%-- 								<h5 class="widget-user-desc" style="margin-left: 0px !important"><%=session.getAttribute("designation")%></h5> --%>
<!-- 							</div> -->
<!-- 							<div class="card-footer p-0"> -->
<!-- 								<ul class="nav flex-column"> -->

<!-- 									                  <li class="nav-item"> -->
<!-- 									                    <span class="nav-link" style="color:#000000 !important">Company  -->
<!-- 									                    <span class="float-right badge bg-secondary" style="font-size:100% !important"> -->
<%-- 									                      <%=session.getAttribute("companyname")%></span> --%>
<!-- 									                    </span> -->
<!-- 									                  </li> -->

<!-- 									<li class="nav-item"> -->
<!-- 										<div class="row align-items-center h-100 rowflex"> -->
<!-- 											<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4 col-xl-4"> -->
<!-- 												<span class="nav-link" style="color: #000000 !important; font-weight: 700; font-size: small;">Company -->
<!-- 												</span> -->
<!-- 											</div> -->
<!-- 											<div class="col-lg-8 col-sm-8 col-md-8 col-xs-8 col-xl-8"> -->
<!-- 												<span class="float-right badge bg-secondary" -->
<!-- 													style="font-size: 100% !important; white-space: initial !important; margin-top: 5px; margin-bottom: 5px; margin-right: 15px"> -->
<%-- 													<%=session.getAttribute("companyname")%></span> --%>
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</li> -->

<!-- 									<li class="nav-item"> -->
<!-- 										<div class="row align-items-center h-100 rowflex"> -->
<!-- 											<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4 col-xl-4"> -->
<!-- 												<span class="nav-link" style="color: #000000 !important; font-weight: 700; font-size: small;">Branch -->
<!-- 												</span> -->
<!-- 											</div> -->
<!-- 											<div class="col-lg-8 col-sm-8 col-md-8 col-xs-8 col-xl-8"> -->
<!-- 												<span class="float-right badge bg-secondary" -->
<!-- 													style="font-size: 100% !important; white-space: initial !important; margin-top: 5px; margin-bottom: 5px; margin-right: 15px"> -->
<%-- 													<%=session.getAttribute("loginBanch")%></span> --%>
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</li> -->

<!-- 									<li class="nav-item"> -->
<!-- 										<div class="row align-items-center h-100 rowflex"> -->
<!-- 											<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4 col-xl-4"> -->
<!-- 												<span class="nav-link" style="color: #000000 !important; font-weight: 700; font-size: small;">Department -->
<!-- 												</span> -->
<!-- 											</div> -->
<!-- 											<div class="col-lg-8 col-sm-8 col-md-8 col-xs-8 col-xl-8"> -->
<!-- 												<span class="float-right badge bg-secondary" -->
<!-- 													style="font-size: 100% !important; white-space: initial !important; margin-top: 5px; margin-bottom: 5px; margin-right: 15px"> -->
<%-- 													<%=session.getAttribute("loginDepartment")%></span> --%>
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</li> -->

<!-- 									<li class="nav-item"> -->
<!-- 										<div class="row align-items-center h-100 rowflex"> -->
<!-- 											<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4 col-xl-4"> -->
<!-- 												<span class="nav-link" style="color: #000000 !important; font-weight: 700; font-size: small;">Role -->
<!-- 												</span> -->
<!-- 											</div> -->
<!-- 											<div class="col-lg-8 col-sm-8 col-md-8 col-xs-8 col-xl-8"> -->
<!-- 												<span class="float-right badge bg-secondary" -->
<!-- 													style="font-size: 100% !important; white-space: initial !important; margin-top: 5px; margin-bottom: 5px; margin-right: 15px"> -->
<%-- 													<%=session.getAttribute("role")%></span> --%>
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</li> -->

<!-- 									<li class="nav-item"><a -->
<!-- 										class="nav-link bg-dark text-center" -->
<%-- 										href="<%=request.getContextPath()%>/login/LOGOUT" --%>
<!-- 										style="font-weight: 600; line-height: 1.2; font-size: 15px;"> -->
<!-- 											Logout</a></li> -->
<!-- 								</ul> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</li> -->

<!-- 				</ul> -->
<!--       </li> -->
      
<!--     </ul> -->
      
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


