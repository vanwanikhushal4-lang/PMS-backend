
window.onload=function(){
 $('#ticketid').focus();
//  $("#searchResult").hide();
  $('#ticketid').select2({
	  placeholder: '--Please Select ID--',
	  allowClear: true,
  });
  
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/TPActivity/getAllProblemTicketID";
//     var getID='getAllTicketID';  
    $.ajax({

        url :serviceUrl,
        type : 'POST',
        dataType: 'json',
        
    }).done(function(data) {
//        alert(data)

//        var pollingHost=data;
//        var d = pollingHost.split(",");
//        var length=d.length-1;
        var html =" <select class='form-control' tabindex='1' id='ticketid' name='ticketid'>";
//        html=html+'<option value="">--Please Select ID--</option>';
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
//       alert("fail")
       event.preventDefault(); 
    }else if(validatePageTracking()){
 //       alert("pass")
        $("#searchID").hide();
      $("#searchResult").show();
    var ticketid= $("#ticketid").val(); 
//     alert("submit");
//    if (!validate()) {
//        event.preventDefault();
//    } else {
        viewDataUser1(ticketid);
        
//    }
    }
      
});

$("#resetbtn").click(function(){
//    alert("reset")
    callToolTip231('ticketid1', 'destroy');
//    $("#ticketid").val("");
    $("#ticketid").val('').trigger('change')
});

var indexError = 0;
   
   
function validatePageTracking()
{
    var indexError = 0;
//   alert("ticketID: "+$('#ticketid').val())
  if ($('#ticketid').val() === '') {
        console.log('fill ticketid');
        callToolTip231('ticketid1', 'show');

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

function viewDataUser1(ticketid) {
    
    $("#searchResult").show();
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/TPActivity/getProblemTicketTrackingDetails";
    
    $.ajax({
        url: serviceUrl,
        type: 'post',
       dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(ticketid),

        success: function(data) {
//            alert(data[0]["PT_ID"])
            
            var PT_ID = data[0]["PT_ID"];
            var PT_DATE = data[0]["PT_DATE"];
            var PT_REQUESTER = data[0]["PT_REQUESTER"];
            var PT_MAIL = data[0]["PT_MAIL"];
            var PT_PHONE = data[0]["PT_PHONE"];
            var PT_COMPANY = data[0]["PT_COMPANY"];
            var PT_BRANCH = data[0]["PT_BRANCH"];
            var PT_DEPARTMENT = data[0]["PT_DEPARTMENT"];
            var T_PROBLEM_CATEGORY = data[0]["T_PROBLEM_CATEGORY"];
            var T_PROBLEM_SUBCAT1 = data[0]["T_PROBLEM_SUBCAT1"];
            var T_PROBLEM_SUBCAT2 = data[0]["T_PROBLEM_SUBCAT2"];
            var PT_SUBJECT = data[0]["PT_SUBJECT"];
            var PT_DESC = data[0]["PT_DESC"];
            var PT_ATTACH_NAME = data[0]["PT_ATTACH_NAME"];
            var PROBLEM_STATUS = data[0]["PROBLEM_STATUS"];
            var PRIORITY = data[0]["PRIORITY"];
            var SEVERITY = data[0]["SEVERITY"];
            var PT_RAISE_TIME = data[0]["PT_RAISE_TIME"];
            var STATUS_LOG = data[0]["STATUS_LOG"];
            
           document.getElementById('PT_ID_Header').innerHTML=PT_ID;
           document.getElementById('PT_ID').innerHTML=PT_ID;
           document.getElementById('PT_DATE').innerHTML=PT_DATE;
           document.getElementById('PT_REQUESTER').innerHTML=PT_REQUESTER;
           document.getElementById('PROBLEM_STATUS').innerHTML=PROBLEM_STATUS;
           document.getElementById('PRIORITY').innerHTML=PRIORITY;
           document.getElementById('SEVERITY').innerHTML=SEVERITY;
           document.getElementById('PT_COMPANY').innerHTML=PT_COMPANY;
           document.getElementById('PT_BRANCH').innerHTML=PT_BRANCH;
           document.getElementById('PT_DEPARTMENT').innerHTML=PT_DEPARTMENT;
           document.getElementById('T_PROBLEM_CATEGORY').innerHTML=T_PROBLEM_CATEGORY;
           document.getElementById('T_PROBLEM_SUBCAT1').innerHTML=T_PROBLEM_SUBCAT1;
           document.getElementById('T_PROBLEM_SUBCAT2').innerHTML=T_PROBLEM_SUBCAT2;
           document.getElementById('PT_SUBJECT').innerHTML=PT_SUBJECT;
           document.getElementById('PT_DESC').innerHTML=PT_DESC;
                     
           var attachment="";
           var att;
           var statusColor;
           var html ="";
           for(var i=0;i<STATUS_LOG.length;i++)
        	   {
        	   //////////////// CODE FOR ATTACHMENT////////////
        	   if(STATUS_LOG[i]["PROBLEM_ATTACHMENT_NAME"]==undefined || STATUS_LOG[i]["PROBLEM_ATTACHMENT_NAME"]=="No File Available" || STATUS_LOG[i]["PROBLEM_ATTACHMENT_NAME"]=="" || STATUS_LOG[i]["PROBLEM_ATTACHMENT_NAME"]==" " || STATUS_LOG[i]["PROBLEM_ATTACHMENT_NAME"]==null)
      		 {
      		 attachment="";
      		 }
      	 else{
      		 att=STATUS_LOG[i]["PROBLEM_ATTACHMENT_NAME"];
      		 attachment="<tr title='"+att+"'><td>Attachment:</td><td><i class='nav-icon fas fa-download' onclick=downFile('"+encodeURIComponent(att)+"')></i></td></tr>";
      	 }
        	   ////////////////CODE FOR COLOUR////////////
        	   statusColor=STATUS_LOG[i]["CURRENT_PROBLEM_STATUS"];
//        	   alert(statusColor);
        	   var callOutColor="";
        	   if(statusColor=="Assigned"){callOutColor="callout-info"}
        	   else if(statusColor=="Root Cause Analysis"){callOutColor="callout-warning"}
        	   else if(statusColor=="Fix In Process"){callOutColor="callout-warning"}
        	   else if(statusColor=="Resolved"){callOutColor="callout-success"}
        	   else if(statusColor=="Closed"){callOutColor="callout-success"}
        	   ////////////////CODE TO APPEND////////////
        	    html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><table>"+STATUS_LOG[i]["P_MESSAGE"]+attachment+"</table></div>";
        	   
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
        var errorMessage = "<span>Please Select Problem Ticket ID<span>";
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

//$('#ticketid1').on('change', function () {
//
//    var usertype = $('#ticketid').val();
//    if (usertype.trim() == "") {
//    	alert("on focusout show")
//        callToolTip231('ticketid1', 'show');
//    }
//    else {
//    	alert("on focusout hide")
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
