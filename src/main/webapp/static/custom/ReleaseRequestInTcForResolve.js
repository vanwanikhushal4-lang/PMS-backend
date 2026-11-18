window.onload = function () {
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/EFormActivity/getReleaseSoftwareInTcForResolution";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function (data5) {
//             alert(data5)
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
            table.buttons().container()
                    .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
            $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
        }
    });

}
function assignTicket(id)
{
//	alert(id)
var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/gatherSoftwareReleaseDetailsToApp";
$.ajax({
    type: 'POST',
    url: serviceUrl,
    async:false,
    dataType: 'json',
    data: 'ticketid=' + encodeURIComponent(id),

    success: function (data) {	var ASSET_CODE=data[0]["ASSET_CODE"];
    var PID = data[0]["PID"];
    var ASSETCODE = data[0]["ASSETCODE"];
   
    
    	var T_REQUESTER = data[0]["T_REQUESTER"];
    var T_COMPANY = data[0]["COMPANY"];
    var T_BRANCH = data[0]["BRANCH"];
    var T_DEPARTMENT = data[0]["DEPARTMENT"];
    var T_PHONE = data[0]["T_PHONE"];
    var T_MAIL = data[0]["EMAIL"];
  var RAISE_DATE = data[0]["RAISE_DATE"];
    
    var T_SUBJECT = data[0]["T_SUBJECT"];
   
    var STATUS = data[0]["STATUS"];
    var T_ID = data[0]["T_ID"];
    var T_DESC = data[0]["DESC"];
   
    var REQUEST_MODE = data[0]["REQUEST_MODE"];
    
    var TP_NAME = data[0]["TP_USERNAME"];
    var TP_COMPANY = data[0]["TP_COMPANY"];
    var TP_BRANCH = data[0]["TP_BRANCH"];
    var TP_DEPARTMENT = data[0]["TP_DEPARTMENT"];
    var TP_PHONE = data[0]["TP_PHONE"];
    var TP_MAIL = data[0]["TP_MAIL"];

    var T_SUBDEPARTMENT = data[0]["T_SUBDEPARTMENT"];
    var T_LOCATION = data[0]["T_LOCATION"];
    
    var TP_SUBDEPARTMENT = data[0]["TP_SUBDEPARTMENT"];
    var TP_LOCATION = data[0]["TP_LOCATION"];
    


    var SNAME = data[0]["SNAME"];
        var APPLIED_DATE = data[0]["APPLIED_DATE"];
        var REQUEST_CATEGORY = data[0]["REQUEST_CATEGORY"];
        
        $("#projectid1").val(PID);
        $("#pid").val(ASSETCODE);

        $("#requestcatassign").val(REQUEST_CATEGORY);
        $("#sname").val(SNAME);
        $("#cost").val(APPLIED_DATE);
       
    $("#subdepartmentrequester").val(T_SUBDEPARTMENT);
    $("#locationrequester").val(T_LOCATION);
    $("#locationtp").val(TP_LOCATION);
    $("#subdepartmenttp").val(TP_SUBDEPARTMENT);
    
    $("#nameupdateTP").val(TP_NAME);
    $("#companyupdateTP").val(TP_COMPANY);
    $("#siteupdateTP").val(TP_BRANCH);
    $("#deptupdateTP").val(TP_DEPARTMENT);
    $("#phoneupdateTP").val(TP_PHONE);
    $("#emailupdateTP").val(TP_MAIL);
    
    
    

    $("#nameupdateUDassign").val(T_REQUESTER);
    $("#companyupdateUDassign").val(T_COMPANY);
    $("#siteupdateUDassign").val(T_BRANCH);
    $("#deptupdateUDassign").val(T_DEPARTMENT);
    $("#phoneupdateUDassign").val(T_PHONE);
    $("#emailupdateUDassign").val(T_MAIL);
    
//    $("#vipuser").val(VIP_LOGIN);

    $("#subjectupdateTDassign").val(T_SUBJECT);
    $("#raisedateupdateTDassign").val(RAISE_DATE);
    $("#statusupdateTDassign").val(STATUS);
    
//    if(STATUS=="Hold")
//    {
//   	alert("dfdf")
//    	$("#statusupdateENG option[value='Hold']").remove();
//    }
       $("#ticketidupdateTDassign").val(T_ID);
    $("#descriptionupdateTDassign").val(T_DESC);
//    $("#priorityupdateTDassign").val(PRIORITY);
    $("#RequestModeupdateTDassign").val(REQUEST_MODE);}
})
        


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
     	var serviceUrl = base_url + "/EFormActivity/InsertReleseRequestForResolution"; 
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
                    text: ' Request Status Change to ('+$("#statusupdateENG").val()+') Successfully', 
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
var callToolTip231 = function (fieldName, status){
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

function viewTicket(id)
{
	
	var  type="Software Release";
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/gatherSoftwareReleaseDetails";
	          $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        async:false,
	        data: 'ticketid=' + encodeURIComponent(id)+"&type="+type,
	        success: function (data) {
//	        	alert(JSON.stringify(data))C
//	           alert("hh")
	        	var PID = data[0]["PID"];
	            var T_REQUESTER = data[0]["T_REQUESTER"];
	            var T_COMPANY = data[0]["COMPANY"];
	       
	            var T_BRANCH = data[0]["BRANCH"];
	            var DEPARTMENT = data[0]["DEPARTMENT"];
	            var SUB_DEPARTMENT = data[0]["SUB_DEPARTMENT"];
	            var LOCATION = data[0]["LOCATION"];
	            var PHONE = data[0]["PHONE"];
	            var T_MAIL = data[0]["EMAIL"];
	            var STATUS = data[0]["STATUS"];
	            var T_ID = data[0]["T_ID"];
	            var T_DESC = data[0]["DESC"];
	            var RAISE_DATE = data[0]["RAISE_DATE"];
//	            alert(RAISE_DATE)
	            var  T_ATTACH_NAME =data[0]["T_ATTACH_NAME"];
//	            var R_PERIOD = data[0]["R_PERIOD"];
	            var SOFTWARE_NAME = data[0]["SNAME"];
	            var APPLIEDDATE = data[0]["APPLIEDDATE"];
	            var ASSETCODE = data[0]["ASSETCODE"];
	             var T_ATTACH_NAME = data[0]["T_ATTACH_NAME"];
	             var SNAME = data[0]["SNAME"];
	             //alert("hee"+SNAME)
	            // var R_PERIOD = data[0]["R_PERIOD"];
//	             alert(ASSETCODE)
	            // ticketidupdateTD
	            
	            $("#nameupdateUD").val(T_REQUESTER);
	            $("#p_id").val(PID);
	            
	            $("#companyupdateUD").val(T_COMPANY);
//	            alert($("#companyupdateUD1").val());
	            $("#siteupdateUD").val(T_BRANCH);
	            $("#deptupdateUD").val(DEPARTMENT);
	            $("#subdeptupdateUD").val(SUB_DEPARTMENT);
	            $("#locationupdateUD").val(LOCATION);
	          
	            $("#phoneupdateUD").val(PHONE);
	            $("#emailupdateUD").val(T_MAIL);
	            $("#statusupdateTD").val(STATUS);
	          
	            $("#ticketidupdateTD").val(T_ID);
	            $("#raisedateupdateTD").val(RAISE_DATE);

	            $("#statusupdateTD").val(STATUS);
//	            $("#ticketidupdateTD1").val(T_ID);
	            $("#descriptionupdateTD").val(T_DESC);
	           
	            $("#viewprocessinggroup").val(ASSETCODE);
	            $("#viewapprovallevel").val(SOFTWARE_NAME);
	            $("#projectid").val(APPLIEDDATE);

	            var SERVER_HOST = data[0]["SERVER_HOST"];
	            var SERVER_IP = data[0]["SERVER_IP"];
	             var SERVER_OWNER = data[0]["SERVER_OWNER"];
//	             alert(SERVER_IP)
//	             var ASSETTAG = data[0]["ASSETTAG"];
	             
//	             var ASSETSUBCATEGORY = data[0]["ASSETSUBCATEGORY"];
	             var REQUEST_CATEGORY = data[0]["REQUEST_CATEGORY"];
//	            alert(REQUEST_CATEGORY)
	            $("#requestcat").val(REQUEST_CATEGORY);
	            if(REQUEST_CATEGORY==='Server')
	            	{
	            	$("#reqcat").show();
	            	$("#LDcat").hide();
	            	$("#reqcatheaderserver").show();
	            	$("#reqcatheader").hide();
	            
	            	  $("#ipaddresss").val(SERVER_IP);
	            	  $("#ownernamee").val(SERVER_OWNER);
	            	  $("#hostnamee").val(SERVER_HOST);
	            	}
	            else
	            	{
	            
				    var LAP_DES_ASSET_CODE = data[0]["LAP_DES_ASSET_CODE"];
		             var LAP_DESK_COMPUTER_NAME = data[0]["LAP_DESK_COMPUTER_NAME"];
		             var LAP_DESK_IP = data[0]["LAP_DESK_IP"];
		             var LAP_DESK_STATUS = data[0]["LAP_DESK_STATUS"];
		             $("#assetcode").val(LAP_DES_ASSET_CODE);
	            	  $("#Lpip").val(LAP_DESK_IP);
	            	  $("#cname").val(LAP_DESK_COMPUTER_NAME);
	            	  $("#LPst").val(LAP_DESK_STATUS);
		             
	            	$("#LDcat").show();
	            	$("#reqcat").hide();
	            	$("#reqcatheaderserver").hide();
	            	$("#reqcatheader").show();     	
	            	}
	            
	            
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
//	alert("fgfg")
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
function downFile()
{
var filename = $('#filename').val();
//alert(filename)
var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + encodeURIComponent(filename);
 }
//
function downFileActivityLog(att) {
//	var filename = $('#filename').val();
	var filename =att;
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}
$('a[role="tab"]').on('shown.bs.tab', function (e) {
	  var target = $(e.target).attr("id") // activated tab
	  if(target==="custom-tabs-four-profile-tab"){
		  ticketid= $("#ticketidupdateTD").val();
		  var type="Software Release";
		  var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//var serviceUrl = base_url + "/UserActivity/getTicketActivityLog";
var serviceUrl = base_url + "/EFormActivity/getRequestActivityLog";
$.ajax({
    url: serviceUrl,
    type: 'post',
   dataType: 'json',
    data: 'ticketid=' + encodeURIComponent(ticketid)
    +"&type="+type,
//    licensekey
    success: function(data) {
    //	alert(data[0]["SUB_CATEGORY1"])
//    	alert(data[0]["CHANGE_NOTES2"]);
        var T_ID = data[0]["T_ID"];
        var TIMESTAMP = data[0]["TIMESTAMP"];
        var CHANGEBY = data[0]["CHANGEBY"];
        var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
        var STATUS = data[0]["STATUS"];
       var PRIORITY = data[0]["PRIORITY"];
        var SEVERITY=data[0]["SEVERITY"];
//        var CATEGORY=data[0]["CATEGORY"];
//        var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
//        var SUBCATEGORY2=data[0]["SUBCATEGORY2"];
        
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
//    	   alert(statusColor);
    	   var callOutColor="";
    	   if(statusColor=="Approval For Manager"){callOutColor="callout-info"}
    	   else if(statusColor=="Resolved"||statusColor=="Closed"){callOutColor="callout-success"}
    	   else if(statusColor=="Work in Progress"){callOutColor="callout-warning"}
    	   else if(statusColor=="Closed"||statusColor=="Approved By Manager"||statusColor=="Approved By IT Compliance"){callOutColor="callout-success"}
    	   else if(statusColor=="Rejected"||statusColor=="Rejected By Manager"||statusColor=="Rejected By It Compliance"||statusColor=="Hold"){callOutColor="callout-danger"}
	
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
//            alert("in confirm");
        	$('#tid').val(id);
        	$("#closereason").val("");
          $("#modelclose").modal("show");
        }
    });
//	alert(id)

}
$('#ticketclose-btn').on("click", function () {
    if(!validateFormCloseTicket())
    {
        event.preventDefault();
     
    }
    else if (validateFormCloseTicket())
    {
    var idd= $("#tid").val();
   // alert("submit: "+idd);
    
    $("#ticketclose-btn").attr("disabled", true);
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/EFormActivity/closeReleaseRequestRequest";
    
    $.ajax({
                url: serviceUrl,
                type: 'post',
                data: 'ticketid=' + encodeURIComponent(idd)
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

    var usertype = $('#closereason').val();
    if (usertype.trim() == "") {
        callToolTipCloseTicket('closereason', 'show');
    }
    else {
        callToolTipCloseTicket('closereason', 'hide');
    }
});


$('#closereason').on('focus', function () {
    callToolTipCloseTicket('closereason', 'destroy');
});$('#modelassign').on('hidden.bs.modal', function () {

	
	$("#statusupdateENG").val("");
	$("#Approvenote").val("");
	
})

function  characterCounter()
{	
	$("#counterSpan").show();
	
	  var i = document.getElementById("Approvenote").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  }
}
function  characterCount()
{	
//	alert("fff")
	$("#Totalcount").show();
	
	  var i = document.getElementById("closereason").value.length;
	  document.getElementById("calulate").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulate").val("");
	  }
}