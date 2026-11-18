
window.onload=function(){
 
  $("#searchResult").hide();
  $('#ticketid').select2({
	  placeholder: '--Please Select ID--',
	  allowClear: true,
  });
  
     $('#ticketid').focus();
 var lastmonth='lastmonthFinal';
 var l = window.location;
 var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/EnggActivity/getEngTicketID";
  
//     var getID='getUserTicketID';  
    $.ajax({
        url :serviceUrl,
        type : 'POST',
        dataType: 'json',
        data:'lastmonth='+lastmonth,
    }).done(function(data) {
//       alert(data)

//        var pollingHost=data;
//        var d = pollingHost.split(",");
//        var length=d.length-1;
        var html =" <select class='form-control' tabindex='1' id='ticketid' name='ticketid'>";
//        html=html+'<option value="-1">--Please Select ID--</option>';
        html=html+'<option value=""></option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' +data[i]+ '">' + data[i]
            + '</option>';
        }

        document.getElementById("ticketid").innerHTML=html;
    });
    
}

function getlastDataEngg(lastmonth){
	
//	var lastmonth = '30'	
//	alert('last month value ' + lastmonth)
	
	 var l = window.location;
 	 var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	 var serviceUrl = base_url + "/EnggActivity/getEngTicketID";
  
//     var getID='getUserTicketID';  
    $.ajax({
        url :serviceUrl,
        type : 'POST',
        dataType: 'json',
        data:'lastmonth='+lastmonth,
    }).done(function(data) {
//       alert(data)

        var html =" <select class='form-control' tabindex='1' id='ticketid' name='ticketid'>";
//        html=html+'<option value="-1">--Please Select ID--</option>';
        html=html+'<option value=""></option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' +data[i]+ '">' + data[i]
            + '</option>';
        }

        document.getElementById("ticketid").innerHTML=html;
    });
	
}
        
       
$("#submit-btn").click(function() {
//    alert("in submit")
//    alert($('#ticketid').val());
    if(!validatePageTracking())
    {
//        alert("fail")
       event.preventDefault(); 
    }else if(validatePageTracking()){
//        alert("pass")
        $("#searchID").hide();
      $("#searchResult").show();
    var ticketid= $("#ticketid").val(); 
//     alert("submit");
//    if (!validate()) {
//        event.preventDefault();
//    } else {
        viewDataUser(ticketid);
        //viewDataUser2(ticketid);
        
//    }
    }
      
});

$("#resetbtn").click(function(){
//    alert("reset")
    callToolTip231('ticketid1', 'destroy');
    $("#ticketid").val('').trigger('change');
    
    callToolTip231('selectmonthOfGroupTicket', 'destroy');
    $("#selectmonthOfGroupTicket").val('lastmonthFinal').trigger('change');
});

function validatePageTracking()
{
    var indexError = 0;
   
   if ($('#ticketid').val() === '') {
        console.log('fill ticketid');
        callToolTip231('ticketid1', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     console.log("validation error count::::"+indexError);
     
     if ($('#selectmonthOfGroupTicket').val() === '') {
         console.log('fill ticketid');
         callToolTip231('selectmonthOfGroupTicket', 'show');

         if (indexError == 0) {

         }
         indexError = indexError + 1;
     }
     console.log("validation error count::::"+indexError);
 if (indexError != 0) {

//    alert("false");
        return false;

    } else {

//        $('#spinner2').show();
//    alert("true");
        return true;
    }
}

function viewDataUser(ticketid) {
    
    $("#searchResult").show();
    
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/EnggActivity/getEngTicketTracking";
    
    $.ajax({
        url: serviceUrl,
        type: 'post',
       dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(ticketid),
                
               //+ '&athorrrr=' + $("#athorrrr").val(),
        success: function(data) {
//            $("#searchID").hide;
        
            var T_ID = data[0]["T_ID"];
            var T_DATE = data[0]["T_DATE"];
            var T_REQUESTER = data[0]["T_REQUESTER"];
            var T_MAIL = data[0]["T_MAIL"];
            var T_PHONE = data[0]["T_PHONE"];
            var T_COMPANY = data[0]["T_COMPANY"];
            var T_BRANCH = data[0]["T_BRANCH"];
            var DEPARTMENT = data[0]["DEPARTMENT"];
            var SUB_DEPARTMENT = data[0]["SUB_DEPARTMENT"];
            var LOCATION = data[0]["LOCATION"];
            var T_CATEGORY = data[0]["T_CATEGORY"];
            var T_SUBCAT1 = data[0]["T_SUBCAT1"];
            var T_SUBCAT2 = data[0]["T_SUBCAT2"];
            var T_SUBJECT = data[0]["T_SUBJECT"];
            var T_DESC = data[0]["T_DESC"];
            var T_ATTACH1_NAME = data[0]["T_ATTACH1_NAME"];
            var T_ATTACH2_NAME = data[0]["T_ATTACH2_NAME"];
            var STATUS = data[0]["STATUS"];
            var PRIORITY = data[0]["PRIORITY"];
            var T_RAISE_TIME = data[0]["T_RAISE_TIME"];
            var STATUS_LOG = data[0]["STATUS_LOG"];
           
           document.getElementById('T_ID').innerHTML=T_ID;
           document.getElementById('T_ID1').innerHTML=T_ID;
           document.getElementById('T_DATE').innerHTML=T_DATE;
           document.getElementById('T_REQUESTER').innerHTML=T_REQUESTER;
           document.getElementById('STATUS').innerHTML=STATUS;
           document.getElementById('PRIORITY').innerHTML=PRIORITY;
           document.getElementById('T_BRANCH').innerHTML=T_BRANCH;
           document.getElementById('DEPARTMENT').innerHTML=DEPARTMENT;
           document.getElementById('SUB_DEPARTMENT').innerHTML=SUB_DEPARTMENT;
           document.getElementById('LOCATION').innerHTML=LOCATION;
           document.getElementById('T_CATEGORY').innerHTML=T_CATEGORY;
           document.getElementById('T_SUBCAT1').innerHTML=T_SUBCAT1;
           document.getElementById('T_SUBCAT2').innerHTML=T_SUBCAT2;
           document.getElementById('T_SUBJECT').innerHTML=T_SUBJECT;
           document.getElementById('T_DESC').innerHTML=T_DESC;
           
          
          
          
           
           var attachment="";
           var att;
           var statusColor;
           var html ="";
           for(var i=0;i<STATUS_LOG.length;i++)
        	   {
        	   //////////////// CODE FOR ATTACHMENT////////////
        	   if(STATUS_LOG[i]["ATTACHMENT_NAME"]==undefined || STATUS_LOG[i]["ATTACHMENT_NAME"]=="No File Available" || STATUS_LOG[i]["ATTACHMENT_NAME"]=="" || STATUS_LOG[i]["ATTACHMENT_NAME"]==" " || STATUS_LOG[i]["ATTACHMENT_NAME"]==null)
      		 {
      		 attachment="";
      		 }
      	 else{
      		 att=STATUS_LOG[i]["ATTACHMENT_NAME"];
      		 attachment="<tr title='"+att+"'><td>Attachment:</td><td><i class='nav-icon fas fa-download' onclick=downFile('"+encodeURIComponent(att)+"')></i></td></tr>";
      	 }
        	   ////////////////CODE FOR COLOUR////////////
        	   statusColor=STATUS_LOG[i]["CURRENT_STATUS"];
        	 //  alert(statusColor);
			      var callOutColor="";
	        	   if(statusColor=="New"){callOutColor="callout-info"}
	        	   else if(statusColor=="Assigned" ||statusColor=="Re-Assigned" ||statusColor=="Pending"){callOutColor="callout-warning"}
	        	   else if( statusColor=="Reopened"){callOutColor="callout-danger"}
	         	  
	        	   else if(statusColor=="Hold" || statusColor=="Waiting for Spare" ||  statusColor=="Pending With Vendor"  ||  statusColor=="Awaiting User Information"){callOutColor="callout-danger"}
	        	   else if(statusColor=="Resolved" ||statusColor=="Update Approved"){callOutColor="callout-success"}
	        	   else if(statusColor=="Closed"){callOutColor="callout-success"}
	        	   else if(statusColor=="Rejected"){callOutColor="callout-danger"}
	        	   else if(statusColor=="Update Rejected"){callOutColor="callout-danger"}
	        	   else if(statusColor=="Work in Progress"){callOutColor="callout-warning"}
	        	   
				  // alert(callOutColor);
        	   ////////////////CODE TO APPEND////////////
        	    html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><table>"+STATUS_LOG[i]["MESSAGE"]+attachment+"</table></div>";
        	   
              document.getElementById("MSG1234").innerHTML=html;
        	   }
           html=+ '</span><br>';
          
          
          
          
          
          
          
            }
        
    });

     
}

function viewDataUser2(ticketid) {
//      alert(ticketid)
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/getEngTicketTrackingMessage";
	
    $.ajax({
        url: serviceUrl,
        type: 'post',
       dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(ticketid),

        success: function(data) {

           var html =" <span id='Label1' style='font-family:Calibri;font-size:14px;font-weight:bold '>Details :<br> ";
        var attachment="";
        var att;
         for(var i=0;i<=data.length;i++){
        	
        	 if(data[i]["ATTACHMENT"]==undefined || data[i]["ATTACHMENT"]=="No File Available" || data[i]["ATTACHMENT"]=="" || data[i]["ATTACHMENT"]==" " || data[i]["ATTACHMENT"]==null)
        		 {
        		 attachment="";
        		 }
        	 else{
          		
        		 att=data[i]["ATTACHMENT"];
        		 attachment="<i class='nav-icon fas fa-download' title='Download Attachment' onclick=downFile('"+encodeURIComponent(att)+"')></i>";
        	 }
        	 
            html += '<span>'+(i+1)+') '+data[i]["MESSAGE"]+'</span>&nbsp;&nbsp;'+attachment+'<br>';
            document.getElementById("MSG1234").innerHTML=html;
        }
        html=+ '</span><br>';

           }
        
    });  
}

$("#reload-btn").click(function() {
    location.reload();
});

var callToolTip231 = function (fieldName, status) {
    if (fieldName === "ticketid1") {
        var errorMessage = "<span>Please Select Ticket ID<span>";
    } 
    if (fieldName === "selectmonthOfGroupTicket") {
        var errorMessage = "<span>Please Select Time Period<span>";
    }
    $("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });
    if (status == "show") {
        $("#" + fieldName).tooltip('show');
    } else {
        $("#" + fieldName).tooltip('hide');
    }
};

//$('#ticketid').on('focusout', function () {
//
//    var usertype = $('#ticketid').val();
//    if (usertype.trim() == "") {
//        callToolTip231('ticketid1', 'show');
//    }
//    else {
//        callToolTip231('ticketid1', 'hide');
//    }
//});

$('#ticketid1').on('click', function () {
//	alert("on focus")
    callToolTip231('ticketid1', 'destroy');
});

function downFile(att) {

//	var filename = $('#filename').val();
	var filename =att;
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}

