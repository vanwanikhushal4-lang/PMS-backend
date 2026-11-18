window.onload = function () {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/getResolvedEngTicketList";
	
//    var serviceUrl = "getResolvedUserTicketList";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',

        success: function (data5) {
//                      alert(data5)
        	$("#preLoader").hide();
        	$("#Listing_Copy").removeClass("d-none");
            var table = $('#Listing_Copy').DataTable({
//                lengthChange: false,
				"lengthMenu":[
                    [5,10,25,50,-1],
                    [5,10,25,50,'Show all']
                ],
                pageLength: 5,
                data: data5,
                destroy: true,
                   scrollX: true,
            });
            table.buttons().container()
                    .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
        }
    });
}
///////////////// ON LOAD ENDS ///////////

function closeTicket(id)
{
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
        	$('#tid').val(id);
          $("#modelclose").modal("show");
        }
    });

}
$('#ticketclose-btn').on("click", function () {
    if(!validateFormClose())
    {
        event.preventDefault();
    }
    else if(validateFormClose())
    {
    var idd= $("#tid").val();
    
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/TPActivity/closeTicketFromEveryPlace";
    
    $.ajax({
                url: serviceUrl,
                type: 'post',
                data: 'ticketid=' + encodeURIComponent(idd)
                + '&closereason=' + encodeURIComponent($("#closereason").val()),
                // + '&athorrrr=' + $("#athorrrr").val(),
                success: function (data) {
// alert(data);
                    if (data === "success") {
                        swal({
                            title: "Successful!",
                            text: "Ticket Closed Successfully",
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
                    text: "Cant close if ticket is not Resolved",
                    type: "error",
                    width: 300,
                    height: 200,
// showCancelButton: !0,
// showCancelButton: false,
// confirmButtonClass: "btn btn-danger",
// cancelButtonClass: "btn btn-danger m-l-10",
// confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        location.reload();
                    }

                })

            }
                }
            });
    }
});

function reopenTicket(id)
{
// alert("ticket id"+id);
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/gatherUserTicketDetails";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(id),
// + '&cno=' + $("#cno").val(),

        success: function (data) {
        	 var T_REQUESTER = data[0]["T_REQUESTER"];
        	 var T_COMPANY = data[0]["T_COMPANY"];
             var T_BRANCH = data[0]["T_BRANCH"];
             var DEPARTMENT = data[0]["DEPARTMENT"];
             var SUB_DEPARTMENT = data[0]["SUB_DEPARTMENT"];
             var LOCATION = data[0]["LOCATION"];
             var T_PHONE = data[0]["T_PHONE"];
             var T_MAIL = data[0]["T_MAIL"];
             var T_CATEGORY = data[0]["T_CATEGORY"];
             var T_SUBCAT1 = data[0]["T_SUBCAT1"];
             var T_SUBCAT2 = data[0]["T_SUBCAT2"];
             var T_SUBJECT = data[0]["T_SUBJECT"];
             var T_DATE = data[0]["T_DATE"];
             var STATUS = data[0]["STATUS"];
             var T_ID = data[0]["T_ID"];
             var T_DESC = data[0]["T_DESC"];
             var PRIORITY = data[0]["PRIORITY"];
             var SEVERITY = data[0]["SEVERITY"];
             var REQUEST_MODE = data[0]["REQUEST_MODE"];
            
//            var A_ENGINEER_NAME = data[0]["A_ENGINEER_NAME"];
//            var T_STATUS = data[0]["T_STATUS"];
//            var SOLUTION = data[0]["SOLUTION"];
//            var RESOLVED_DATE = data[0]["RESOLVED_DATE"];

            $("#nameupdateUDreopen").val(T_REQUESTER);
            $("#companyupdateUDreopen").val(T_COMPANY);
            $("#siteupdateUDreopen").val(T_BRANCH);
            $("#deptupdateUDreopen").val(DEPARTMENT);
            $("#subdeptupdateUDreopen").val(SUB_DEPARTMENT);
            $("#locationupdateUDreopen").val(LOCATION);
            $("#phoneupdateUDreopen").val(T_PHONE);
            $("#emailupdateUDreopen").val(T_MAIL);
            
            $("#ticketidupdateTDreopen").val(T_ID);
            $("#statusupdateTDreopen").val(STATUS);
            $("#raisedateupdateTDreopen").val(T_DATE);
            $("#categoryupdateTDreopen").val(T_CATEGORY);
            $("#subcat1updateTDreopen").val(T_SUBCAT1);
            $("#subcat2updateTDreopen").val(T_SUBCAT2);
            $("#subjectupdateTDreopen").val(T_SUBJECT);
            $("#priorityupdateTDreopen").val(PRIORITY);
            $("#severityupdateTDreopen").val(SEVERITY);
            $("#descriptionupdateTDreopen").val(T_DESC);
            $("#RequestModeupdateTDreopen").val(REQUEST_MODE);
            var ASSETCHECK = data[0]["ASSETCHECK"];
            var ASSETNAME = data[0]["ASSETNAME"];
            var ASSETSTATUS = data[0]["ASSETSTATUS"];
            var ASSETCATEGORY = data[0]["ASSETCATEGORY"];
            var ASSETTAG = data[0]["ASSETTAG"];
            $("#assetcheck").val(ASSETCHECK);
            $("#aname").val(ASSETNAME);
            $("#atag").val(ASSETTAG);
            $("#astatus").val(ASSETSTATUS);
            $("#acategory").val(ASSETCATEGORY);
            
//            alert( ASSETCHECK)
            if(ASSETCHECK == "true")
       	 {
           	
       	 document.getElementById("HideAssetdata").style.display = "block";

       	 }
        else
       	 {
//       	 alert( "hhh")
       	 document.getElementById("HideAssetdata").style.display = "none";
       	 }
            
//            $("#statusdateENGreopen").val(RESOLVED_DATE);
//             $("#engnameENG").val(A_ENGINEER_NAME);
//            $("#ticketstatusENG").val(T_STATUS);
//            $("#enggsolution").val(SOLUTION);
            
        }
  
    });
    $("#modelreopen").modal("show");
}

$('#cancel-btn').on("click", function () {
// alert("reopen close");
	$("#reopenreason").val("");
	callToolTipClose('closereason', 'destroy');
    $("#modelreopen").modal("hide");
});

$('#reopen-btn').on("click", function () {

    
if(!validateFormReopen()){

    event.preventDefault();
    
}else if(validateFormReopen())
{
	 swal({
	        title: "Are you sure?",
	        text: "You want to Re-Open Ticket?",
	        type: "warning",
	        width: 350,
	        height: 200,
	        showCancelButton: !0,
	        confirmButtonClass: "btn btn-success",
	        cancelButtonClass: "btn btn-danger m-l-10",
	        confirmButtonText: "Yes",
//	        buttons: false,
            allowOutsideClick: false
            
	    }).then(function () {

	    	var l = window.location;
	    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    	var serviceUrl = base_url + "/UserActivity/UserReopenResolvedTicket";
	    	
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
	                        text: "Ticket Successfully Re-Opened",
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
	                            var l = window.location;
	                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                            window.location.href = base_url + "/User/ResolveUserTickets";
	                        }
	                    });
	                }else if (data === "duplicate") {
	                    swal({
	                        title: "Not Allowed",
	                        text: "You have already Reopened this ticket",
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

$('#reopenreason').on('focusout', function () {

    var usertype = $('#reopenreason').val();
    if (usertype.trim() == "") {
        callToolTipReopen('reopenreason', 'show');
    }
    else {
        callToolTipReopen('reopenreason', 'hide');
    }
});
$('#reopenreason').on('focus', function () {
    callToolTipReopen('reopenreason', 'destroy');
});

function validateFormReopen()
{
 var indexError = 0;
   
   if ($('#reopenreason').val() === '') {
        //('fill reopenreason');
        callToolTipReopen('reopenreason', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     //("validation error count::::"+indexError);
 if (indexError != 0) {

// alert("false");
        return false;

    } else {

// $('#spinner2').show();
// alert("true");
        return true;
    }

}


var callToolTipClose = function (fieldName, status) {
    if (fieldName === "closereason") {
        var errorMessage = "<span>Please Enter Your Close Reason<span>";
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

$('#closereason').on('focusout', function () {

    var usertype = $('#closereason').val();
    if (usertype.trim() == "") {
        callToolTipClose('closereason', 'show');
    }
    else {
        callToolTipClose('closereason', 'hide');
    }
});
$('#closereason').on('focus', function () {
    callToolTipClose('closereason', 'destroy');
});

function validateFormClose()
{
 var indexError = 0;
   
   if ($('#closereason').val() === '') {
        //('fill closereason');
        callToolTipClose('closereason', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     //("validation error count::::"+indexError);
 if (indexError != 0) {

// alert("false");
        return false;

    } else {

// $('#spinner2').show();
// alert("true");
        return true;
    }

}

function viewTicket(id)
{
	//alert(viewTicket+"viewTicket");
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/gatherEngTicketDetails";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(id),
//                + '&cno=' + $("#cno").val(),

        success: function (data) {
	
	
	     var T_REQUESTER = data[0]["T_REQUESTER"];
            var T_COMPANY = data[0]["T_COMPANY"];
            var T_BRANCH = data[0]["T_BRANCH"];
            var DEPARTMENT = data[0]["DEPARTMENT"];
            var SUB_DEPARTMENT = data[0]["SUB_DEPARTMENT"];
            var LOCATION = data[0]["LOCATION"];
            var T_PHONE = data[0]["T_PHONE"];
            var T_MAIL = data[0]["T_MAIL"];
            var T_CATEGORY = data[0]["T_CATEGORY"];
            var T_SUBCAT1 = data[0]["T_SUBCAT1"];
            var T_SUBCAT2 = data[0]["T_SUBCAT2"];
            var T_SUBJECT = data[0]["T_SUBJECT"];
            var T_DATE = data[0]["T_DATE"];
            var STATUS = data[0]["STATUS"];
            var T_ID = data[0]["T_ID"];
            var T_DESC = data[0]["T_DESC"];
            var PRIORITY = data[0]["PRIORITY"];
            var SEVERITY = data[0]["SEVERITY"];
            var REQUEST_MODE = data[0]["REQUEST_MODE"];
             var T_ATTACH_NAME = data[0]["T_ATTACH_NAME"];
          //alert("DEPARTMENT: "+DEPARTMENT);



  			var ASSETCHECK = data[0]["ASSETCHECK"];
             var ASSETNAME = data[0]["ASSETNAME"];
             var ASSETSTATUS = data[0]["ASSETSTATUS"];
             var ASSETCATEGORY = data[0]["ASSETCATEGORY"];
             var ASSETTAG = data[0]["ASSETTAG"];
        	 $("#assetcheck").val(ASSETCHECK);
             
             var ASSETSUBCATEGORY = data[0]["ASSETSUBCATEGORY"];
             var ASSET_IPADDRESS = data[0]["ASSET_IPADDRESS"];
             
             
             $("#asset_sub_categoryview").val(ASSETSUBCATEGORY);
             $("#asset_Ipaddressview").val(ASSET_IPADDRESS);
//            alert(T_COMPANY);
 if(T_COMPANY=="3i Infotech")  
       	 {

	 document.getElementById("HideAssetdata").style.display = "block";
       	 
       	
            if(ASSETCHECK == "true")
       	 {
           	
//            	alert(ASSETCHECK)

               
                $("#aname").val(ASSETNAME);
                $("#atag").val(ASSETTAG);
                $("#astatus").val(ASSETSTATUS);
                $("#acategory").val(ASSETCATEGORY);
                
       

       	 }
        else
       	 {
//       	 alert( "hhh")
       	 document.getElementById("HideAssetdata").style.display = "none";
       	 }
       	 }
            $("#nameupdateUD").val(T_REQUESTER);
            $("#companyupdateUD").val(T_COMPANY);
            $("#siteupdateUD").val(T_BRANCH);
            $("#deptupdateUD").val(DEPARTMENT);
            $("#subdeptupdateUD").val(SUB_DEPARTMENT);
            $("#locationupdateUD").val(LOCATION);
            $("#phoneupdateUD").val(T_PHONE);
            $("#emailupdateUD").val(T_MAIL);
            $("#categoryupdateTD").val(T_CATEGORY);
            $("#subcat1updateTD").val(T_SUBCAT1);
            $("#subcat2updateTD").val(T_SUBCAT2);
            $("#subjectupdateTD").val(T_SUBJECT);
            $("#raisedateupdateTD").val(T_DATE);
            $("#statusupdateTD").val(STATUS);
            $("#ticketidupdateTD").val(T_ID);
            $("#descriptionupdateTD").val(T_DESC);
            $("#priorityupdateTD").val(PRIORITY);
            $("#severityupdateTD").val(SEVERITY);
            $("#RequestModeupdateTD").val(REQUEST_MODE);
            
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

function downFile()
{
var filename = $('#filename').val();
var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
 }
       


$('#modelview').on('hidden.bs.modal', function () {
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

 
 //////////////////// GET ACTIVITY LOG ////////////////
$('a[role="tab"]').on('shown.bs.tab', function (e) {
	  var target = $(e.target).attr("id") // activated tab
	  if(target==="custom-tabs-four-profile-tab"){
		  ticketid= $("#ticketidupdateTD").val();
		  
		  var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/UserActivity/getTicketActivityLog";
    
    $.ajax({
        url: serviceUrl,
        type: 'post',
       dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(ticketid),

        success: function(data) {
//        	alert(data[0]["CHANGE_NOTES2"]);
            var T_ID = data[0]["T_ID"];
            var TIMESTAMP = data[0]["TIMESTAMP"];
            var CHANGEBY = data[0]["CHANGEBY"];
            var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
            var STATUS = data[0]["STATUS"];
            var PRIORITY = data[0]["PRIORITY"];
           
            var CHANGE_NOTES1 = data[0]["CHANGE_NOTES1"];
            var CHANGE_NOTES2 = data[0]["CHANGE_NOTES2"];
            var SEVERITY = data[0]["SEVERITY"];
            var CATEGORY=data[0]["CATEGORY"];
            var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
            var SUBCATEGORY2=data[0]["SUBCATEGORY2"];
            var EMAIL=data[0]["EMAIL"];
            var FULLNAME=data[0]["FULLNAME"];
            
            

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
        	   if(statusColor=="New"){callOutColor="callout-info"}
          	   else if(statusColor=="Assigned" ||statusColor=="Re-Assigned"||statusColor=="Pending"){callOutColor="callout-warning"}
          	   else if( statusColor=="Reopened"){callOutColor="callout-danger"}
           	  
          	  else if(statusColor=="Hold" || statusColor=="Waiting for Spare" ||  statusColor=="Pending With Vendor"  ||  statusColor=="Awaiting User Information"){callOutColor="callout-danger"}
          	   else if(statusColor=="Resolved"||statusColor=="Update Approved"||statusColor=="Approved"){callOutColor="callout-success"}
          	   else if(statusColor=="Closed"){callOutColor="callout-success"}
          	   else if(statusColor=="Rejected"){callOutColor="callout-danger"}
          	   else if(statusColor=="Update Rejected"){callOutColor="callout-danger"}
          	 else if(statusColor=="Work in Progress"){callOutColor="callout-warning"}
         	   
        	   //alert(statusColor);
        	   /////////////// CODE FOR NOTES ///////////////
        	   if(data[i]["CHANGE_NOTES1"]==undefined || data[i]["CHANGE_NOTES1"]=="" || data[i]["CHANGE_NOTES1"]==" " || data[i]["CHANGE_NOTES1"]==null)
        		 {
        		   notes1="";
        		 }
        	 else{
        		 notes1="<textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["CHANGE_NOTES1"]+"</textarea>";
        	 }
        	   
        	   ////////////////CODE TO APPEND////////////
        	   html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type : <span>"+data[i]["ROLE_TYPE"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Priority : <span>"+data[i]["PRIORITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Severity : <span>"+data[i]["SEVERITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Category : <span>"+data[i]["CATEGORY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category1 : <span>"+data[i]["SUB_CATEGORY1"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category2 : <span>"+data[i]["SUBCATEGORY2"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Full Name: <span>"+data[i]["FULLNAME"]+"</span></span></div></div><div class='row'><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Email : <span>"+data[i]["EMAIL"]+"</span></span></div></div><br><div class='row'><div class='col-md-12'>"+notes1+"</div></div></div>";
        	   
              document.getElementById("MSG1234").innerHTML=html;
        	   }
           html=+ '<br>';
            }
          
            
    });
	  }
	});      
       
       function downFileActivityLog(att) {
//	alert(att)
//		var filename = $('#filename').val();
		var filename =att;
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location = base_url + "/Master/DownloadFile?filename=" + filename;
	}
   	$('#modelclose').on('hidden.bs.modal', function () {
		
		$("#closereason").val("");
		
})
       
