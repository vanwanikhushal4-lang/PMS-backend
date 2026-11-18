<!DOCTYPE html>
<html lang="en">
<head>
<!--   
  <link rel="stylesheet" href="<%=request.getContextPath()%>/Notification/NotificationCSS.css">-->
 <style>
 .dropdown-item1 { 
     display: block;
     width: 100%;
     padding: .25rem 1rem;
     clear: both;
     font-weight: 400;
     color: #212529;
     text-align: inherit;
     white-space: nowrap;
     background-color: transparent;
     border: 0;
 } 
 .rowflex{
 display: flex !important;
 flex-wrap: nowrap !important;
 }
.callout-custom{
margin-bottom: .4rem !important;
padding: .5rem !important;
}
 .navbar-badge {
right: inherit !important;
top: inherit !important;
}
</style>
</head>
<body>
                 <li  id="onclickbellicon"  class="nav-item dropdown ml-n1">
        <a   class="nav-link" data-toggle="dropdown" href="#">
            <i class="fas fa-bell" title="View Notifications">
          <sup style="left:-6px"><span class="badge badge-danger navbar-badge" id="counter" style=" display: none; right:0px; top:4px;"></span></sup>
          
          <span  id="loaderid"   style="display: none;" class=" spinner-border spinner-border-sm  text-info"></span>
          </i>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right bg-dark">
            <span class="dropdown-item dropdown-header bg-dark">You have <span id="counter1"></span> Notifications</span>
         <div class="dropdown-divider"></div>
          <div class="dropdown-item1" style="height: 330px; overflow: auto;" >
            <!-- Message Start -->
           <span id="notificationsContainer"></span>
           
            <!-- Message End -->
          </div>
          
        </div>
      </li>
        <!-- TEMPLATE NOTIFICATION -->
  <script id="notificationTemplate" type="text/html">
           {{href1}}
 		<div class="callout callout-custom {{callout}}">
		<div class="row rowflex">
        <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12 col-xl-12">
            <p class="text-sm" style="color:black; ">Ticket: <b>{{tid}}</b></p>
            </div>
			</div>
   		 <div class="row rowflex">
        <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12 col-xl-12">
            <p class="text-sm" style="color:black;">Status: <b>{{image}}</b></p>
        </div> 
		</div>		
		<div class="row rowflex">
                <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12 col-xl-12">
                    <small  style="font-size: 11px;">
                        <p class="notification-date text-muted">
                            <i class="fa fa-clock" aria-hidden="true"></i> {{date}}
                        </p> 
                </div>
              </div>
		</div>
		{{href2}}
</script> 
    <!-- jQuery -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jquery-ui/jquery-u //i.min.js"></script>-->

       <script src="<%=request.getContextPath()%>/static/custom/notification_foruser.js"></script>   
       
</body>

</html>