
window.onload=function(){

//	$("#requesttype").val(requesttypes);
//	alert($("#requesttype").val())
  $('#ticketid').focus();
  $("#searchResult").hide();
  $('#ticketid').select2({
	  placeholder: '--Please Select ID--',
	  allowClear: true,
  });
  
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/EFormActivity/getRequestID";
  
//     var getID='getUserTicketID';  
    $.ajax({
        url :serviceUrl,
        type : 'POST',
        dataType: 'json',
        data:'requestType='+$("#requesttype").val()
    }).done(function(data) {
//        alert(data)
//        var d = data.split(",");
//        var length = d.length-1;
        var html = "<select class='form-control' tabindex='1' id='ticketid' name='ticketid'>";
//        html = html + '<option value="-1">--Please Select ID--</option>';
        html=html+'<option value=""></option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' +data[i]+ '">' + data[i] + '</option>';
        }
        document.getElementById("ticketid").innerHTML=html;
    });
     
            }
        
$("#submit-btn").click(function() {

    if(!validatePageTracking())
    {
       event.preventDefault(); 
    }else if(validatePageTracking()){
        $("#searchID").hide();
      $("#searchResult").show();
    var ticketid= $("#ticketid").val(); 

        viewDataUser1(ticketid);

    }
      
});

$("#resetbtn").click(function(){

    callToolTip231('ticketid1', 'destroy');
    $("#ticketid").val('').trigger('change')
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
    var reqType= $("#requesttype").val();
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/EFormActivity/getUserRequestTracking";
    
    $.ajax({
        url: serviceUrl,
        type: 'post',
       dataType: 'json',
        data: 'ticketid=' + ticketid+'&reqType='+reqType,
        success: function(data) {

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
//            var T_CATEGORY = data[0]["T_CATEGORY"];
//            var T_SUBCAT1 = data[0]["T_SUBCAT1"];
//            var T_SUBCAT2 = data[0]["T_SUBCAT2"];
//            var T_SUBJECT = data[0]["T_SUBJECT"];
//            var T_DESC = data[0]["T_DESC"];
            var T_ATTACH1_NAME = data[0]["T_ATTACH1_NAME"];
//         C   var T_ATTACH2_NAME = data[0]["T_ATTACH2_NAME"];
            var STATUS = data[0]["STATUS"];
            var PRIORITY = data[0]["PRIORITY"];
            var SEVERITY = data[0]["SEVERITY"];
            var T_DESC = data[0]["T_DESC"];
            var STATUS_LOG = data[0]["STATUS_LOG"];
//            alert(data[0].MESSAGE)
           
           document.getElementById('T_ID').innerHTML=T_ID;
           document.getElementById('T_ID1').innerHTML=T_ID;
           document.getElementById('T_DATE').innerHTML=T_DATE;
           document.getElementById('T_REQUESTER').innerHTML=T_REQUESTER;
           document.getElementById('STATUS').innerHTML=STATUS;
           document.getElementById('PRIORITY').innerHTML=PRIORITY;
           document.getElementById('SEVERITY').innerHTML=SEVERITY;
           document.getElementById('T_BRANCH').innerHTML=T_BRANCH;
           document.getElementById('DEPARTMENT').innerHTML=DEPARTMENT;
           document.getElementById('SUB_DEPARTMENT').innerHTML=SUB_DEPARTMENT;
           document.getElementById('LOCATION').innerHTML=LOCATION;
//           document.getElementById('T_CATEGORY').innerHTML=T_CATEGORY;
//           document.getElementById('T_SUBCAT1').innerHTML=T_SUBCAT1;
//           document.getElementById('T_SUBCAT2').innerHTML=T_SUBCAT2;
//           document.getElementById('T_SUBJECT').innerHTML=T_SUBJECT;
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
//        	   alert(statusColor);	
        	   var callOutColor="";
        	   if(statusColor=="Approval For Manager"){callOutColor="callout-info"}
        	   else if(statusColor=="Resolved"||statusColor=="Closed"){callOutColor="callout-success"}
        	   else if(statusColor=="Work in Progress" || statusColor=="Re-Opened"){callOutColor="callout-warning"}
        	   else if(statusColor=="Closed"||statusColor=="Approved By Manager" || statusColor=="Approved By It Compliance" || statusColor=="Approved By Second Manager" || statusColor=="Approved By Mail Admin"|| statusColor=="Approved By IT Compliance"){callOutColor="callout-success"}
        	   else if(statusColor=="Rejected"|| statusColor=="Rejected By Mail Admin"|| statusColor=="Rejected By Second Manager"|| statusColor=="Rejected By Manager"||statusColor=="Rejected By It Compliance"||statusColor=="Hold"){callOutColor="callout-danger"}
         	  
        	   ////////////////CODE TO APPEND////////////
        	    html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><table>"+STATUS_LOG[i]["MESSAGE"]+attachment+"</table></div>";
        	   
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


$('#ticketid1').on('click', function () {
//	alert("on focus")
    callToolTip231('ticketid1', 'destroy');
});

function downFile(att) {
//alert(att)
//	var filename = $('#filename').val();
	var filename =att;
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}

