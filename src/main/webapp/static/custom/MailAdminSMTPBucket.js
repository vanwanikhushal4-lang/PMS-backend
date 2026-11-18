/**
 * 
 */
 
 window.onload = function () {
//	alert('inside the pending business JS')
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/EFormActivity/MailAdminSMTPBucket";

//    var serviceUrl = "getAllRaisedTicketList";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',

        success: function (data5) {
//		alert(data5)
		
			$("#preLoader").hide();
        	$("#Listing_Copy").removeClass("d-none");
            var table = $('#Listing_Copy').DataTable({
                lengthChange: false,
                pageLength: 5,
                data: data5,
                destroy: true,
                scrollX: true,
                fixedColumns: false,

                
            });
            
//            if(data5 === Hold)){
//	
//			}
//			else{
				
			
            table.buttons().container()
                    .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
            $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
//           }
		}
    });
    }
  
    // ticket action 
	 function assignTicket(id) {

		 var l = window.location;
		 var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		 var serviceUrl = base_url + "/EFormActivity/SMTPPendingActionDetails";
		 $.ajax({
			 type: 'POST',
			 url: serviceUrl,
			 async: false,
			 dataType: 'json',
			 data: 'ticketid=' + encodeURIComponent(id),

			 success: function(data) {

				 var PID = data[0]["PID"];
				 var T_REQUESTER = data[0]["T_REQUESTER"];
				 var T_COMPANY = data[0]["COMPANY"];
				 var T_BRANCH = data[0]["BRANCH"];
				 var T_DEPARTMENT = data[0]["DEPARTMENT"];
				 var T_PHONE = data[0]["T_PHONE"];
				 var T_MAIL = data[0]["EMAIL"];
				 var T_RAISE_DATE = data[0]["RAISE_DATE"];
				 var T_STATUS = data[0]["STATUS"];
				 var T_ID = data[0]["T_ID"];
				 var T_DESC = data[0]["T_DESCRIPTION"];
				 var T_SUBDEPARTMENT = data[0]["T_SUBDEPARTMENT"];
				 var T_LOCATION = data[0]["T_LOCATION"];
				 
				 var REQUEST_MODE = data[0]["REQUEST_MODE"];
				 var TP_NAME = data[0]["TP_USERNAME"];
				 var TP_COMPANY = data[0]["TP_COMPANY"];
				 var TP_BRANCH = data[0]["TP_BRANCH"];
				 var TP_DEPARTMENT = data[0]["TP_DEPARTMENT"];
				 var TP_PHONE = data[0]["TP_PHONE"];
				 var TP_MAIL = data[0]["TP_MAIL"];
				 var TP_SUBDEPARTMENT = data[0]["TP_SUBDEPARTMENT"];
				 var TP_LOCATION = data[0]["TP_LOCATION"];
				 
				 var APPROVAL_NAME = data[0]["APPROVAL_NAME"];
				 var APPLICATION_SERVER = data[0]["APPLICATION_SERVER"];
				 var APPLICATION_SERVER_IP = data[0]["APPLICATION_SERVER_IP"];
				 var SERVER_LOCATION_CITY = data[0]["SERVER_LOCATION_CITY"];


				 var NO_OF_MAIL = data[0]["NO_OF_MAIL"];            
	            var MAIL_SIZE = data[0]["MAIL_SIZE"];
//				 $("#rperiod").val(RPERIOD);
				
				 $("#locationtp").val(TP_LOCATION);
				 $("#subdepartmenttp").val(TP_SUBDEPARTMENT);
				 $("#nameupdateTP").val(TP_NAME);
				 $("#companyupdateTP").val(TP_COMPANY);
				 $("#siteupdateTP").val(TP_BRANCH);
				 $("#deptupdateTP").val(TP_DEPARTMENT);
				 $("#phoneupdateTP").val(TP_PHONE);
				 $("#emailupdateTP").val(TP_MAIL);
				 $("#pid").val(PID);
				 
				 $("#approvalNameUpdate").val(APPROVAL_NAME);
				 $("#applicationserverA").val(APPLICATION_SERVER);
				 $("#applicationserverIPA").val(APPLICATION_SERVER_IP);
				 $("#serverlocationcityA").val(SERVER_LOCATION_CITY);

				 $("#noOfMail").val(NO_OF_MAIL);
				  $("#mailsize").val(MAIL_SIZE);
				
				 $("#subdepartmentrequester").val(T_SUBDEPARTMENT);
				 $("#locationrequester").val(T_LOCATION);
				 $("#nameupdateUDassign").val(T_REQUESTER);
				 $("#companyupdateUDassign").val(T_COMPANY);
				 $("#siteupdateUDassign").val(T_BRANCH);
				 $("#deptupdateUDassign").val(T_DEPARTMENT);
				 $("#phoneupdateUDassign").val(T_PHONE);
				 $("#emailupdateUDassign").val(T_MAIL);
				 $("#raisedateupdateTDassign").val(T_RAISE_DATE);
				 $("#statusupdateTDassign").val(T_STATUS);
				 $("#ticketidupdateTDassign").val(T_ID);
				 $("#descriptionupdateTDassign").val(T_DESC);
				 $("#RequestModeupdateTDassign").val(REQUEST_MODE);
			 }
		 });

		 $("#modelassign").modal("show");
	 }


$('#submit-btn').on("click", function () {
	  
    if(!validateForm200())
    {
      //  alert("fail")
        event.preventDefault();
    }
    else if (validateForm200())
    {
    	$("#submit-btn").attr("disabled", true);
//        alert("pass")
//        alert($("#holdnotes").val())
    	
    	var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/EFormActivity/InsertSMTPRequestApprovedByMailAdmin";
    	
     	var form=$('form')[0];
   	 var formData= new FormData(form);

    $.ajax({

    	 url: serviceUrl,
	        type: 'POST',
	        data: formData,
	        mimeType: "multipart/form-data",
	        contentType: false,
	        processData: false,
	        cache: false,
    }).done(function (data) {	
//    	 alert(data2[0]);
//    	 alert(data2[1]);
    	var data2=data.split("~");
        if (data2[0] == "success") {
          
            {
                swal({
                    title: "Successful!",
                    text: ' Request Status Changed Successfully', 
                    type: "success",
                    width: 300,
                    height: 200,
                    showCancelButton: !0,
                    confirmButtonClass: "btn btn-danger",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function () {
                        location.reload();
                    }

                })
            }
                
               }
               else
                 {
                   swal({
                	title: 'Unsuccessful!', 
                   	text: 'Failed to Change Ticket Status', 
                   	type: 'error',
                    width: 300,
                    height: 200,
                    showCancelButton: !0,
                    confirmButtonClass: "btn btn-danger",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function () {
                        location.reload();
                    }

            })
              }
 });
}
});
var callToolTip231 = function (fieldName, status) {
	 if (fieldName === "statusupdateENG") {
	        var errorMessage = "<span>Please Select Status<span>";
	    }
	    else if (fieldName === "Approvenote") {      
	        var errorMessage = "<span>Please Enter Note<span>";
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
}
function validateForm200()
{
	//focus out
	
	  var indexError = 0; 
	
	  
	  if ($('#statusupdateENG').val().trim() === '') {
	   
	      callToolTip231('statusupdateENG', 'show');
	
	      if (indexError == 0) {
	
	      }
	      indexError = indexError + 1;
	  }
	  if ($('#Approvenote').val().trim() === '') {
	      
	      callToolTip231('Approvenote', 'show');
	
	      if (indexError == 0) {
	
	      }
	      indexError = indexError + 1;
	  }
	
	  if (indexError != 0) {

//	    //alert("false");
	        return false;

	    } else {


	        return true;
	    }
}
$('#statusupdateENG').on('focus', function () {
    callToolTip231('statusupdateENG', 'destroy');
});

$('#Approvenote').on('focus', function () {
    callToolTip231('Approvenote', 'destroy');
});

// close ticket

function closeTicket(id)
{
//alert(id)
    swal({
        title: "Confirm!",
        text: "Are you sure you want to close the ticket",
        type: "warning",
        width: 300,
        height: 200,
        showCancelButton: true,
        confirmButtonClass: "btn btn-danger",
        cancelButtonClass: "btn btn-danger m-l-10",
        confirmButtonText: "OK",
        cancelButtonText: "Cancel"
    }).then((isConfirm) => {
        if (isConfirm) {
//            alert("in confirm");
        	$('#tid').val(id);
        	$("#closereason").val("");
          $("#modelclose").modal("show");
        }
    });

}

// close method

$('#ticketclose-btn').on("click", function () {
    if(!validateFormCloseTicket())
    {
        event.preventDefault();
    }
    else if (validateFormCloseTicket())
    {
    var id= $("#tid").val();
//    alert("submit: "+id);
    
    $("#ticketclose-btn").attr("disabled", true);
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/EFormActivity/closeSMTPResolvedRequest";
    
    $.ajax({
                url: serviceUrl,
                type: 'post',
                data: 'ticketid=' + encodeURIComponent(id)
                + '&closereason=' + $("#closereason").val(),
              
                success: function (data) {
//                    alert(data);
                    if (data === "success") {
                        swal({
                            title: "Successful",
                            text: "Request Closed Successfully",
                            type: "success",
                            width: 300,
                            height: 200,
                            confirmButtonClass: "btn btn-danger",
//                          cancelButtonClass: "btn btn-danger m-l-10",
//                          confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                            preConfirm: function () {
                                location.reload();
                            }
                        });
                    }else if (data === "error") {
                    	  swal({
                              title: "Failed!",
                              html: "Unable to Closed Request",
                              type: "error",
                              width: 300,
                              height: 200,
//                            showCancelButton: false,
//                            confirmButtonClass: "btn btn-danger",
//                            cancelButtonClass: "btn btn-danger m-l-10",
//                            confirmButtonText: "OK",
                              buttons: false,
                              allowOutsideClick: false,
                              preConfirm: function () {
                                  location.reload();
                              }

                          }) 

            }
                }
            });
    }
});
function validateFormCloseTicket()
{
 
      var indexError = 0;
   
   if ($('#closereason').val() === '') {
        console.log('fill closereason');
        callToolTipCloseTicket('closereason', 'show');

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
var callToolTipCloseTicket = function (fieldName, status) {
    if (fieldName === "closereason") {
        var errorMessage = "<span>Please Enter Your Reason<span>";
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
}

$('#closereason').on('focusout', function () {

    var usertype = $('#closereason').val();    if (usertype.trim() == "") {
        callToolTipCloseTicket('closereason', 'show');
    }
    else {
        callToolTipCloseTicket('closereason', 'hide');
    }
});


// view ticket detalis code 

function viewTicket(id)
{

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/getrSMTPRequestDetails";
	        
	           $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'ticketid=' + encodeURIComponent(id),

	        success: function (data) {
//	        	alert(JSON.stringify(data))
	           
	            var T_REQUESTER = data[0]["T_REQUESTER"];
	            var T_COMPANY = data[0]["T_COMPANY"];
	            var T_BRANCH = data[0]["T_BRANCH"];
	            var DEPARTMENT = data[0]["T_DEPARTMENT"];
	            var SUB_DEPARTMENT = data[0]["T_SUBDEPARTMENT"];
	            var LOCATION = data[0]["T_LOCATION"];
	            var T_PHONE = data[0]["T_PHONE"];	            
	            var T_MAIL = data[0]["T_EMAIL"];		                        
	            var STATUS = data[0]["STATUS"];
	            var T_ID = data[0]["T_ID"];
	            var T_DESC = data[0]["DESC"];
	            var RAISE_DATE = data[0]["RAISE_DATE"];
	            var P_ID = data[0]["PID"];
	            var T_ATTACH_NAME = data[0]["T_ATTACH_NAME"];
	            
	            var APPROVAL_NAME = data[0]["APPROVAL_NAME"];
				 var APPLICATION_SERVER = data[0]["APPLICATION_SERVER"];
				 var APPLICATION_SERVER_IP = data[0]["APPLICATION_SERVER_IP"];
				 var SERVER_LOCATION_CITY = data[0]["SERVER_LOCATION_CITY"];
	            
	            $("#nameupdateUD").val(T_REQUESTER);
	            $("#companyupdateUD").val(T_COMPANY);
	            $("#siteupdateUD").val(T_BRANCH);
	            $("#deptupdateUD").val(DEPARTMENT);
	            $("#subdeptupdateUD").val(SUB_DEPARTMENT);
	            $("#locationupdateUD").val(LOCATION);
	            $("#phoneupdateUD").val(T_PHONE);
	            $("#emailupdateUD").val(T_MAIL);           
	            $("#statusupdateTD").val(STATUS);	          
	            $("#ticketidupdateTD").val(T_ID);
	            $("#descriptionupdateTD").val(T_DESC);	           	          
	            $("#raisedateupdateTD").val(RAISE_DATE);	          
	            $("#projectid").val(P_ID);	
	            
	            $("#approvalNameUp").val(APPROVAL_NAME);
				 $("#applicationserver").val(APPLICATION_SERVER);
				 $("#applicationserverIP").val(APPLICATION_SERVER_IP);
				 $("#serverlocationcity").val(SERVER_LOCATION_CITY);           
	            
	            
	if((T_ATTACH_NAME=== ("No File Available"))||(T_ATTACH_NAME===("NA"))||(T_ATTACH_NAME===("null"))||(T_ATTACH_NAME===("undefined"))||(T_ATTACH_NAME===("")))
	       {
	          $('#hidedownload').hide();
	          $('#nofileattach').show();
	       }else
	       {
	           $('#hidedownload').show();
	             $('#nofileattach').hide();
	         document.getElementById('empPic').innerHTML=T_ATTACH_NAME;
	         document.getElementById('filename').value=T_ATTACH_NAME;  
	       }
	      
	        }
	    });
	             $("#modelview").modal("show");
	        
}


$('#modelview').on('hidden.bs.modal', function () {
//	alert("hii")
	$('a[role="tab"]').removeClass('active'); 
    $('a[role="tabpanel"]').removeClass('active show');
    $('#custom-tabs-four-home-tab').addClass('active');
    $('#custom-tabs-four-home').removeClass('active show');
    $('#custom-tabs-four-profile').removeClass('active show');
    $('#custom-tabs-four-home').addClass('active show');
});
$('#close-btn').on("click", function () {
	$("#modelview").modal("hide");
	$('a[role="tab"]').removeClass('active'); 
    $('a[role="tabpanel"]').removeClass('active show');
    $('#custom-tabs-four-home-tab').addClass('active');
    
    $('#custom-tabs-four-home').removeClass('active show');
    $('#custom-tabs-four-profile').removeClass('active show');
    $('#custom-tabs-four-home').addClass('active show');
});


// Activity log code

function downFile()
      {
	
	var filename = $('#filename').val();
//	alert(encodeURIComponent(filename))
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	window.location = base_url + "/Master/DownloadFile?filename=" + encodeURIComponent(filename);
       }

function downFileActivityLog(att) {
//	alert(att)
//		var filename = $('#filename').val();
		var filename =att;
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location = base_url + "/Master/DownloadFile?filename=" + filename;
	}
//////////////////// GET ACTIVITY LOG ////////////////
$('a[role="tab"]').on('shown.bs.tab', function (e) {
	  var target = $(e.target).attr("id") // activated tab
	  if(target==="custom-tabs-four-profile-tab"){
		  ticketid= $("#ticketidupdateTD").val();
		  
		  var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/UserActivity/getTicketActivityLog";
    var serviceUrl = base_url + "/EFormActivity/getSMTPTicketRequestActivityLog";
    $.ajax({
        url: serviceUrl,
        type: 'post',
       dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(ticketid),

        success: function(data) {
        //	alert(data[0]["SUB_CATEGORY1"])
//        	alert(data[0]["CHANGE_NOTES2"]);
            var T_ID = data[0]["T_ID"];
            var TIMESTAMP = data[0]["TIMESTAMP"];
            var CHANGEBY = data[0]["CHANGEBY"];
            var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
            var STATUS = data[0]["STATUS"];
           var PRIORITY = data[0]["PRIORITY"];
            var SEVERITY=data[0]["SEVERITY"];
//            var CATEGORY=data[0]["CATEGORY"];
//            var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
//            var SUBCATEGORY2=data[0]["SUBCATEGORY2"];
            
            var CHANGE_NOTES1 = data[0]["CHANGE_NOTES1"];
            var CHANGE_NOTES2 = data[0]["CHANGE_NOTES2"];
            var ROLE_TYPE = data[0]["ROLE_TYPE"];
            var EMAIL=data[0]["FULLNAME"];
            var FULLNAME=data[0]["EMAIL"];
            
            
           document.getElementById('T_ID').innerHTML=T_ID;
          
           
           var attachment="";
           var att;
           var statusColor;
           var notes1;
           var notes2;
           var html ="";
           for(var i=0;i<data.length;i++)
        	   {
        	   
        	   
        	   //////////////// CODE FOR ATTACHMENT////////////
        	   if(data[i]["ATTACHMENT_NAME"]==undefined || data[i]["ATTACHMENT_NAME"]=="No File Available" || data[i]["ATTACHMENT_NAME"]=="" || data[i]["ATTACHMENT_NAME"]==" " || data[i]["ATTACHMENT_NAME"]==null)
      		 {
      		 attachment="No File Attached";
      		 }
      	 else{
      		 att=data[i]["ATTACHMENT_NAME"];
      		 attachment="<i class='nav-icon fas fa-download' onclick=downFileActivityLog('"+encodeURIComponent(att)+"')></i>";
      	 }
        	   ////////////////CODE FOR COLOUR////////////
        	   statusColor=data[i]["STATUS"];
//        	   alert(statusColor);
        	   var callOutColor="";
        	   if(statusColor=="Re-Opened"){callOutColor="callout-warning"}
        	   else if(statusColor=="Approval For Manager" ||statusColor=="Approved By Manager"||statusColor=="Work in Progress"||statusColor=="Resolved"||statusColor=="Closed"){callOutColor="callout-success"}
        	   else if(statusColor=="Rejected By Manager"||statusColor=="Hold"){callOutColor="callout-danger"}
       	
        	   /////////////// CODE FOR NOTES ///////////////
        	   if(data[i]["CHANGE_NOTES1"]==undefined || data[i]["CHANGE_NOTES1"]=="" || data[i]["CHANGE_NOTES1"]==" " || data[i]["CHANGE_NOTES1"]==null)
        		 {
        		   notes1="";
        		 }
        	 else{
        		 notes1="<textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["CHANGE_NOTES1"]+"</textarea>";
        	 }
        	   
        	   ////////////////CODE TO APPEND////////////
        	   html +=  "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type : <span>"+data[i]["ROLE_TYPE"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Priority : <span>"+data[i]["PRIORITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Severity : <span>"+data[i]["SEVERITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Full Name: <span>"+data[i]["FULLNAME"]+"</span></span></div></div><div class='row'><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Email : <span>"+data[i]["EMAIL"]+"</span></span></div></div><br><div class='row'><div class='col-md-12'>"+notes1+"</div></div></div>";







        	   
              document.getElementById("MSG1234").innerHTML=html;
        	   }
           html=+ '<br>';
            }
          
            
    });
	}
	});
	
function  characterCounter()
{
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("Approvenote").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}


