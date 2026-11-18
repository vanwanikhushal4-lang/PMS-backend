<!DOCTYPE html>
<html lang="en">
<head>
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
.callout-high {
    border-left-color: #e6672b !important;
}

</style>
</head>
<body>
        <a class="nav-link" data-toggle="dropdown" href="#">
            <i class="fas fa-comments"  title="View Outages">
          <sup style="left:-6px"><span class="badge badge-danger navbar-badge" id="outageCounter" style="right:0px; top:4px;"></span></sup>
          </i>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right bg-dark">
            <span class="dropdown-item dropdown-header bg-dark">You have <span id="outageCounter1"></span> Outage Messages</span>
         <div class="dropdown-divider"></div>
          <div class="dropdown-item1" style="height: 330px; overflow: auto;" >
            <!-- Message Start -->
           <span id="outageContainer"></span>
            <!-- Message End -->
          </div>
          
        </div>
 
        <!-- TEMPLATE NOTIFICATION -->
  <script id="outageTemplate" type="text/html">
       <div class="callout callout-custom {{callout}}">
		<div class="row rowflex">
        <div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 col-xl-6">
            <p class="text-xs" style="color:black;">Severity: <b>{{SEVERITY}}</b></p>
        </div> 
		<div class="col-lg-6 col-sm-6 col-md-6 col-xs-6 col-xl-6">
			
			<p class="text-muted" style="font-size: 10px;margin-top: 2px;">
                <i class="fa fa-clock" aria-hidden="true"></i> {{TIMESTAMP}}
            </p> 
			
         </div>
		</div>
		<div class="row rowflex">
        <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12 col-xl-12">
            <p class="text-xs" style="color:black; ">From: <b>{{USERNAME}}</b></p>
            </div>
			</div>	  
		<div class="row rowflex">
        <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12 col-xl-12">
	
            <pre class="text-xs" style="white-space: pre-wrap; margin: -12px; font-family: inherit;">Message: <b class="expandMessage" style="font-style: italic;">{{MESSAGE}}</b></pre>

        </div> 
		</div>		
		</div>
</script> 
    <!-- jQuery -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
    
       <script src="<%=request.getContextPath()%>/static/custom/outage_forEngg.js"></script>   
       
</body>

</html>