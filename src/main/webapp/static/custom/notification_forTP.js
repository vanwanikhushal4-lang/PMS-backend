$("#onclickbellicon").click(function(){
//	alert("click");
	 $("#counter").hide();
	$("#loaderid").show();
	// $("#notificationsContainer").empty();
	 
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/NotificationConfig/getTPNotification";
//  var serviceUrl = "getTPNotification";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data) {
        	 $("#counter").show();
        		$("#loaderid").hide();
//             alert(data)
//              var T_ID = data[0]["T_ID"];
//              alert(T_ID);

var hreflink="";
var calloutColor="";
       var notifications = new Array();
       for (var i = 0; i < data.length; i++) {
//           alert("VIP_TICKET is: "+data[i]["VIP_TICKET"]);
           if(data[i]["VIP_TICKET"]==="true"){
        	  //////////// LINKS FOR VIP TICKETS /////////////
        	   if(data[i]["STATUS"]==="New")
               {
                hreflink='<a href="'+getContextPath()+'/TP/ViewAllRaiseVIPTickets">'; 
                calloutColor='callout-info';
               }
               else if(data[i]["STATUS"]==="Hold" || data[i]["STATUS"]==="Awaiting User Information" || data[i]["STATUS"] ==="Pending With Vendor" || data[i]["STATUS"] === "Waiting for Spare" )
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewVIPHoldTickets">'; 
                   calloutColor='callout-danger';
               }
               ////////// FOR RESOLVED/////////
               else if(data[i]["STATUS"]==="Resolved" && !data[i]["T_ID"].includes("PRB"))
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewVIPResolvedTickets">'; 
                   calloutColor='callout-success';
               }
               //////////////////////////////
               //////////FOR CLOSED/////////
               else if(data[i]["STATUS"]==="Closed" && !data[i]["T_ID"].includes("PRB"))
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewVIPClosedTickets">'; 
                   calloutColor='callout-success';
               }
               ////////////////////////////
               
               else if(data[i]["STATUS"]==="Reopened")
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewVIPPendingToReAssignTickets">'; 
                   calloutColor='callout-danger';
               }
               
               //////////FOR ASSIGNED/////////
                else if((data[i]["STATUS"]==="Assigned" || data[i]["STATUS"]==="Work in Progress" ) && !data[i]["T_ID"].includes("PRB"))
               {
                	//alert("hiii");
                   hreflink='<a href="'+getContextPath()+'/TP/ViewVIPAssignedTickets">'; 
                   calloutColor='callout-warning';
               }
               /////////////////////////////
               
                else if(data[i]["STATUS"]==="Re-Assigned")
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewVIPReAssignedTickets">'; 
                   calloutColor='callout-warning';
               }
                else if(data[i]["STATUS"]==="Rejected")
                {
                    hreflink='<a href="'+getContextPath()+'/TP/ViewVIPRejectedTickets">'; 
                    calloutColor='callout-danger';
                }
                else if(data[i]["STATUS"]==="Pending")
                {
                    hreflink='<a href="'+getContextPath()+'/TP/ViewAllChangePrioritySeverity">'; 
                    calloutColor='callout-warning';
                }
                else if(data[i]["STATUS"]==="Update Rejected")
                {
                    hreflink='<a href="'+getContextPath()+'/TP/ViewAllChangePrioritySeverity">'; 
                    calloutColor='callout-warning';
                }
                else if(data[i]["STATUS"]==="Update Approved")
                {
                    hreflink='<a href="'+getContextPath()+'/TP/ViewAllChangePrioritySeverity">'; 
                    calloutColor='callout-warning';
                }
  
           }
           ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           else{
        	   //////////// LINKS FOR GENERAL TICKETS /////////////
        	   if(data[i]["STATUS"]==="New")
               {
                hreflink='<a href="'+getContextPath()+'/TP/ViewAllRaiseTickets">'; 
                calloutColor='callout-info';
               }
               else if(data[i]["STATUS"]==="Hold" || data[i]["STATUS"]==="Awaiting User Information" || data[i]["STATUS"] ==="Pending With Vendor" || data[i]["STATUS"] === "Waiting for Spare" )
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewHoldTickets">'; 
                   calloutColor='callout-danger';
               }
               ////////// FOR RESOLVED/////////
               else if(data[i]["STATUS"]==="Resolved" && !data[i]["T_ID"].includes("PRB"))
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewResolvedTickets">'; 
                   calloutColor='callout-success';
               }
               //////////////////////////////
               //////////FOR CLOSED/////////
               else if(data[i]["STATUS"]==="Closed" && !data[i]["T_ID"].includes("PRB"))
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewClosedTickets">'; 
                   calloutColor='callout-success';
               }
               ////////////////////////////
               
               else if(data[i]["STATUS"]==="Reopened")
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewPendingToReAssignTickets">'; 
                   calloutColor='callout-danger';
               }
               
               //////////FOR ASSIGNED/////////
                else if((data[i]["STATUS"]==="Assigned"  || data[i]["STATUS"]==="Work in Progress" )&& !data[i]["T_ID"].includes("PRB"))
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewAssignedTickets">'; 
                   calloutColor='callout-warning';
               }
               /////////////////////////////
               
                else if(data[i]["STATUS"]==="Re-Assigned")
               {
                   hreflink='<a href="'+getContextPath()+'/TP/ViewReAssignedTickets">'; 
                   calloutColor='callout-warning';
               }
                else if(data[i]["STATUS"]==="Rejected")
                {
                    hreflink='<a href="'+getContextPath()+'/TP/ViewRejectedTickets">'; 
                    calloutColor='callout-danger';
                }
                else if(data[i]["STATUS"]==="Pending")
                {
                    hreflink='<a href="'+getContextPath()+'/TP/ViewAllChangePrioritySeverity">'; 
                    calloutColor='callout-warning';
                }
                else if(data[i]["STATUS"]==="Update Rejected")
                {
                    hreflink='<a href="'+getContextPath()+'/TP/ViewAllChangePrioritySeverity">'; 
                    calloutColor='callout-warning';
                }
                else if(data[i]["STATUS"]==="Update Approved")
                {
                    hreflink='<a href="'+getContextPath()+'/TP/ViewAllChangePrioritySeverity">'; 
                    calloutColor='callout-warning';
                }
  
  
  
           }
           /////////////////////// FOR PROBLEM TICKETS //////////////////////////////
           if(data[i]["STATUS"]==="Resolved" && data[i]["T_ID"].includes("PRB"))
           {
               hreflink='<a href="'+getContextPath()+'/TP/ViewAllProblemTickets">'; 
               calloutColor='callout-success';
           }
           else if(data[i]["STATUS"]==="Closed" && data[i]["T_ID"].includes("PRB"))
           {
               hreflink='<a href="'+getContextPath()+'/TP/ViewAllProblemTickets">'; 
               calloutColor='callout-success';
           }
           else if(data[i]["STATUS"]==="Assigned" && data[i]["T_ID"].includes("PRB"))
           {
               hreflink='<a href="'+getContextPath()+'/TP/ViewAllProblemTickets">'; 
               calloutColor='callout-warning';
           }
           else if(data[i]["STATUS"]==="Root Cause Analysis")
           {
               hreflink='<a href="'+getContextPath()+'/TP/ViewAllProblemTickets">'; 
               calloutColor='callout-warning';
           }
           else if(data[i]["STATUS"]==="Fix In Process")      {
               hreflink='<a href="'+getContextPath()+'/TP/ViewAllProblemTickets">'; 
               calloutColor='callout-warning';
           }
          
           var vipDisplay="none";
           if(data[i]["VIP_TICKET"]==="true"){
         	  vipDisplay="block";
           }       
  notifications.push({
   href1: "<a href="+data[i]["T_ID"]+">",
   callout: calloutColor,
     tid1: data[i]["T_ID"],
     status1: data[i]["STATUS"],
    href1: hreflink,
    tid: data[i]["T_ID"],
    image: data[i]["STATUS"],
//    texte: data[i]["MESSAGE"],
    date: data[i]["ACTIVITY_DATE"],
    vipDisplay: vipDisplay,
     href2: "<a>"
  });
  var template = $('#notificationTemplate').html();
  		template = template.replace("{{callout}}", notifications[i].callout);
           template = template.replace("{{tid1}}", notifications[i].tid1);
           template = template.replace("{{status1}}", notifications[i].status1);
          template = template.replace("{{href1}}", notifications[i].href1);
          template = template.replace("{{tid}}", notifications[i].tid);
          template = template.replace("{{image}}", notifications[i].image);
          template = template.replace("{{vipDisplay}}", notifications[i].vipDisplay);
          template = template.replace("{{date}}", notifications[i].date);
          template = template.replace("{{href2}}", notifications[i].href2);

          $('#notificationsContainer').append(template);
           
       }
     
     var count = data[0]["COUNTER"];
  var lastCount = 0;
  $("#counter").html(count);
  $("#counter1").html(count);
             }
      
     });

     OverlayScrollbars(document.querySelectorAll(".dropdown-item1"), 
    		 { 
    	 className : "os-theme-light" ,
    		 
    		 scrollbars : {
    		        visibility       : "auto",
    		        autoHide         : "leave",
    		        autoHideDelay    : 800,
    		        dragScrolling    : true,
    		        clickScrolling   : true,
    		        touchSupport     : true
    		    },
    		 });
});

$(".dropdown-menu-right").click(function(e){
	   e.stopPropagation();
})

function getContextPath() {
var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                        alert(window.location.stringname)
                        var linkstring= window.location.stringname= base_url;
                      
                        return linkstring;
}



