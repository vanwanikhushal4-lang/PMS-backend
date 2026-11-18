/**
 * 
 */
 
window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/getSMTPRequestList";

	$.ajax({
		type: 'POST',
		url: serviceUrl,
		dataType: 'json',

		success: function(data5) {
			$("#preLoader").hide();
			$("#Listing_Copy").removeClass("d-none");
			var table = $('#Listing_Copy').DataTable({

				lengthChange: false,
				pageLength: 5,
				data: data5,
				destroy: true,
				scrollX: true,
				fnInitComplete: function() {
					loadDatatablesScroll();
				}
			});
			table.buttons().container()
				.appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
		}
	});
}



// ////////////////// VIEW TICKET /////////////////////////////////////////

$("#close-btn").click(function() {
    location.reload();
});


/////////////////////////////////////////  RE-OPEN  /////////////////////////////////////////////////////


function reOpen(id)
{
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/getSMTPReOpenRequestDetails";
	        
	           $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        async:false,
	        data: 'ticketid=' + encodeURIComponent(id),

	        success: function (data) {
//	        	alert(JSON.stringify(data))
	           
	            var T_REQUESTER = data[0]["T_REQUESTER"];
	            var T_COMPANY = data[0]["T_COMPANY"];
	            var T_BRANCH = data[0]["T_BRANCH"];
	            var DEPARTMENT = data[0]["DEPARTMENT"];
	            var SUB_DEPARTMENT = data[0]["SUB_DEPARTMENT"];
	            var LOCATION = data[0]["LOCATION"];
	            var T_PHONE = data[0]["PHONE"];
	            
	            var T_MAIL = data[0]["EMAIL"];
	            
	            var STATUS = data[0]["STATUS"];
	            var T_ID = data[0]["T_ID"];
	            var T_DESC = data[0]["DESC"];
	            var RAISE_DATE = data[0]["RAISE_DATE"];	        
	            var P_ID = data[0]["P_ID"];
	            
	            var APPROVAL_NAME = data[0]["APPROVAL_NAME"];
	             var APPLICATION_SERVER = data[0]["APPLICATION_SERVER"];
				 var APPLICATION_SERVER_IP = data[0]["APPLICATION_SERVER_IP"];
				 var SERVER_LOCATION_CITY = data[0]["SERVER_LOCATION_CITY"];
	           
	            
	           
	             var T_ATTACH_NAME = data[0]["T_ATTACH_NAME"];
	            
	            $("#nameupdateUD").val(T_REQUESTER);
	            $("#companyupdateUD").val(T_COMPANY);
	            $("#siteupdateUD").val(T_BRANCH);
	            $("#deptupdateUD").val(DEPARTMENT);
	            $("#subdeptupdateUD").val(SUB_DEPARTMENT);
	            $("#locationupdateUD").val(LOCATION);
	            $("#phoneupdateUD").val(T_PHONE);
	            $("#emailupdateUD").val(T_MAIL);
	            $("#ticketidupdateTD").val(STATUS);
	            $("#ticketidupdateTD").val(T_ID);
	            
	          
	            $("#raisedateupdateTD").val(RAISE_DATE);
	            $("#statusupdateTD").val(STATUS);
	            $("#ticketidupdateTD").val(T_ID);
	            $("#descriptionupdateTD").val(T_DESC);
	            $("#projectid2").val(P_ID);
	            
	            $("#viewapprovallevel2").val(APPROVAL_NAME);
	            $("#applicationserverR").val(APPLICATION_SERVER);
				 $("#applicationserverIPR").val(APPLICATION_SERVER_IP);
				 $("#serverlocationcityR").val(SERVER_LOCATION_CITY); 	            
	            
	            
	       
	            
	            
	if((T_ATTACH_NAME=== ("No File Available"))||(T_ATTACH_NAME===("NA"))||(T_ATTACH_NAME===("null"))||(T_ATTACH_NAME===("undefined"))||(T_ATTACH_NAME===("")))
	       {
	          $('#hidedownload1').hide();
	          $('#nofileattach1').show();
	       }else
	       {
	           $('#hidedownload1').show();
	             $('#nofileattach1').hide();
	         document.getElementById('empPic').innerHTML=T_ATTACH_NAME;
	         document.getElementById('filename').value=T_ATTACH_NAME;  
	       }
	      
	        }
	    });
//	alert(id)
	 $("#reopenreason").val("");
    $("#modelreopen").modal("show");
	
	
}

//////////////////////////////Close start//////////
$('#cancel-btn').on("click", function () {
	// alert("reopen close");
		$("#reopenreason").val("");
//		callToolTipClose('closereason', 'destroy');
	    $("#modelreopen").modal("hide");
	});

//////////////////////////////Re-Opened start//////////
	$('#reopen-btn').on("click", function () {

	    
	if(!validateFormReopen()){

	    event.preventDefault();
	    
	}else if(validateFormReopen())
	{
		$("#reopen-btn").attr("disabled", true);
		 swal({
		        title: "Are you sure?",
		        text: "You want to Re-Open Request?",
		        type: "warning",
		        width: 350,
		        height: 200,
		        showCancelButton: !0,
		        confirmButtonClass: "btn btn-success",
		        cancelButtonClass: "btn btn-danger m-l-10",
		        confirmButtonText: "Yes",
//		        buttons: false,
	            allowOutsideClick: false
	            
		    }).then(function () {

		    	var l = window.location;
		    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		    	var serviceUrl = base_url + "/EFormActivity/RequestReopenResolvedSMTPTicket";
		    	
		    	 var form=$('form')[0];
		    	 var formData= new FormData(form);
		        $.ajax({
		        	 url: serviceUrl,
		    	        type: 'post',
		    	        data: formData,
		    	        mimeType: "multipart/form-data",
		    	        contentType: false,
		    	        processData: false,
		    	        cache: false,


		           }).done(function (data) {
	// alert("dfgsfd"+data);

		                if (data == "success") {
		                    swal({
		                        title: "Successful!",
		                        text: "Request Successfully Re-Opened",
		                        type: "success",
		                        width: 300,
		                        height: 200,
	// showCancelButton: false,
	// confirmButtonClass: "btn btn-danger",
	// cancelButtonClass: "btn btn-danger m-l-10",
	// confirmButtonText: "OK",
		                        buttons: false,
		                        allowOutsideClick: false,
		                        preConfirm: function () {
		                            location.reload();
		                        }
		                    });
		                }else if (data === "duplicate") {
		                    swal({
		                        title: "Not Allowed",
		                        text: "You have already Reopened this Request",
		                        type: "error",
		                        width: 300,
		                        height: 200,

	 preConfirm: function() {
	 location.reload();
	 }
		                    });

		                }
		                    }); 

		
		    });
	}
	 
	      
	       });

function validateFormReopen()
	{
	 var indexError = 0;
	   
	   if ($('#reopenreason').val() === '') {
	        //console.log('fill reopenreason');
	        callToolTipReopen('reopenreason', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	     //console.log("validation error count::::"+indexError);
	 if (indexError != 0) {

	// alert("false");
	        return false;

	    } else {

	// $('#spinner2').show();
	// alert("true");
	        return true;
	    }

	}
	
		var callToolTipReopen = function (fieldName, status) {
	    if (fieldName === "reopenreason") {
	        var errorMessage = "<span>Please Enter Re-Open Reason<span>";
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

	$('#reopenreason').on('focus', function () {
	    callToolTipReopen('reopenreason', 'destroy');
	});


/////////////////////////////  END RE-OPEN ///////////////////////////////////////////////////////////

function viewTicket(id)
{
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/gatherSMTPRequestDetails";
	          $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        async:false,
	        data: 'ticketid=' + encodeURIComponent(id),
	        success: function (data) {
//	        	alert(JSON.stringify(data))
	           
	            var T_REQUESTER = data[0]["T_REQUESTER"];
	            var T_COMPANY = data[0]["T_COMPANY"];
	            var T_BRANCH = data[0]["T_BRANCH"];
	            var DEPARTMENT = data[0]["DEPARTMENT"];
	            var SUB_DEPARTMENT = data[0]["SUB_DEPARTMENT"];
	            var LOCATION = data[0]["LOCATION"];
	            var T_PHONE = data[0]["PHONE"];
	            
	            var T_MAIL = data[0]["EMAIL"];
	            
	            var STATUS = data[0]["STATUS"];
	            var T_ID = data[0]["T_ID"];
	            var T_DESC = data[0]["DESC"];
	            var RAISE_DATE = data[0]["RAISE_DATE"];
	            var R_PERIOD = data[0]["R_PERIOD"];
	            
	             var APPLICATION_SERVER = data[0]["APPLICATION_SERVER"];
				 var APPLICATION_SERVER_IP = data[0]["APPLICATION_SERVER_IP"];
				 var SERVER_LOCATION_CITY = data[0]["SERVER_LOCATION_CITY"];
	     
	       
	            var DOMAIN = data[0]["DOMAIN"];
	            var APPROVAR_NAME = data[0]["APPROVAR_NAME"];
	            var P_ID = data[0]["P_ID"];
	            var T_ATTACH_NAME = data[0]["T_ATTACH_NAME"];

	            $("#nameupdateUD1").val(T_REQUESTER);
	            $("#companyupdateUD1").val(T_COMPANY);
	            $("#siteupdateUD1").val(T_BRANCH);
	            $("#deptupdateUD1").val(DEPARTMENT);
	            $("#subdeptupdateUD1").val(SUB_DEPARTMENT);
	            $("#locationupdateUD1").val(LOCATION);
	            $("#phoneupdateUD1").val(T_PHONE);
	            $("#emailupdateUD1").val(T_MAIL);
	            $("#ticketidupdateTD1").val(STATUS);
	            $("#ticketidupdateTD1").val(T_ID);
	            
	         
	          	
	            $("#raisedateupdateTD1").val(RAISE_DATE);
	            $("#statusupdateTD1").val(STATUS);
	            $("#ticketidupdateTD1").val(T_ID);
	            $("#descriptionupdateTD1").val(T_DESC);
	           
	            $("#rim1").val(R_PERIOD);
//	            $("#viewapprovallevel1").val(SOFTWARE_NAME);
	            $("#projectid1").val(P_ID);

	             $("#domainview").val(DOMAIN);	                
	             $("#viewapprovallevel1").val(APPROVAR_NAME);
	             $("#applicationserver").val(APPLICATION_SERVER);
				 $("#applicationserverIP").val(APPLICATION_SERVER_IP);
				 $("#serverlocationcity").val(SERVER_LOCATION_CITY); 

	            
	            
	if((T_ATTACH_NAME=== ("No File Available"))||(T_ATTACH_NAME===("NA"))||(T_ATTACH_NAME===("null"))||(T_ATTACH_NAME===("undefined"))||(T_ATTACH_NAME===("")))
	       {
	          $('#hidedownload1').hide();
	          $('#nofileattach1').show();
	       }else
	       {
	           $('#hidedownload1').show();
	             $('#nofileattach1').hide();
	         document.getElementById('empPic').innerHTML=T_ATTACH_NAME;
	         document.getElementById('filename').value=T_ATTACH_NAME;  
	       }
	      
	        }
	    });
	          
	             $("#modelview").modal("show");
	          
	             
}

$('#modelview').on('hidden.bs.modal', function () {
//	alert("fgfg")
    $('a[role="tab"]').removeClass('active'); 
    $('a[role="tabpanel"]').removeClass('active show');
    $('#custom-tabs-four-home-tab').addClass('active');
    
    $('#custom-tabs-four-home').removeClass('active show');
    $('#custom-tabs-four-profile').removeClass('active show');
    $('#custom-tabs-four-home').addClass('active show');
});




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
		  ticketid= $("#ticketidupdateTD1").val();
//		  alert(ticketid)
		  var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/UserActivity/getTicketActivityLog";
    var serviceUrl = base_url + "/EFormActivity/getSMTPRequestActivityLog";
    $.ajax({
        url: serviceUrl,
        type: 'post',
       dataType: 'json',
//       async:false,
        data: 'ticketid=' + encodeURIComponent(ticketid),

        success: function(data) {

            var T_ID = data[0]["T_ID"];
            var TIMESTAMP = data[0]["TIMESTAMP"];
            var CHANGEBY = data[0]["CHANGEBY"];
            var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
            var STATUS = data[0]["STATUS"];
           var PRIORITY = data[0]["PRIORITY"];
            var SEVERITY=data[0]["SEVERITY"];

            
            
            var CHANGE_NOTES1 = data[0]["CHANGE_NOTES1"];

            var CHANGE_NOTES2 = data[0]["CHANGE_NOTES2"];
            var ROLE_TYPE = data[0]["ROLE_TYPE"];
            var EMAIL=data[0]["FULLNAME"];
            var FULLNAME=data[0]["EMAIL"];

           document.getElementById('T_ID1').innerHTML=T_ID;
          
           
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
        	   else if(statusColor=="Approval For Manager"||statusColor=="Approved By Manager"||statusColor=="Work in Progress"||statusColor=="Resolved"||statusColor=="Closed"){callOutColor="callout-success"}
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
//        		   "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type : <span>"+data[i]["ROLE_TYPE"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Full Name: <span>"+data[i]["FULLNAME"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Email : <span>"+data[i]["EMAIL"]+"</span></span></div></div><br><div class='row'><div class='col-md-12'>"+notes1+"</div></div></div>";
        	   
              document.getElementById("MSG12341").innerHTML=html;
        	   }
           html=+ '<br>';
            }
          
            
    });
	  }
	});
	
function  characterCounter()
{
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("reopenreason").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}