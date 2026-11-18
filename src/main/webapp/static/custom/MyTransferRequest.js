window.onload = function() {
//alert("dffdffffffffff")
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/EFormActivity/getUserTransferList";
	
            $.ajax({
                type: 'POST',
                url: serviceUrl,               
                dataType: 'json',
               
                success: function(data5) {
// alert(data5)
                	$("#preLoader").hide();
                	$("#Listing_Copy").removeClass("d-none");
                    var table = $('#Listing_Copy').DataTable({
                    	
                        lengthChange: false,
                        pageLength: 5,
                        data: data5,
                        destroy: true,
                        scrollX: true,
                        fnInitComplete : function() {
                        	loadDatatablesScroll();
                        }
                    });
                    table.buttons().container()
                            .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
                }
            });
        }
function viewTicket(id)
{
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/gatherTransferViewDetails";
	          $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        async:false,
	        data: 'ticketid=' + encodeURIComponent(id),
	        success: function (data) {
// alert(JSON.stringify(data))
	           // alert("hh")
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
	            var SOFTWARE_NAME = data[0]["SOFTWARE_NAME"];
	            var P_ID = data[0]["P_ID"];
	            var COST = data[0]["COST"];
	             var T_ATTACH_NAME = data[0]["T_ATTACH_NAME"];
	             var ASSET_IPADDRESS = data[0]["ASSET_IPADDRESS"];
	             var RCAT=data[0]["RCAT"];

		            var NEW_ASSSET = data[0]["NEW_ASSSET"];

		            var NEW_DATE = data[0]["NEW_DATE"];
	             var TO_EMP=data[0]["TO_EMP"];
		            var CATEGORY_REQUEST=data[0]["CATEGORY_REQUEST"];

		        
				
		            
				     var CURRENT_UASSET = data[0]["CURRENT_UASSET"];
		             var CREQ=data[0]["CREQ"];
			         var LD_ASSETNAME=data[0]["LD_ASSETNAME"];
			         var LD_STATUS = data[0]["LD_STATUS"];
			         var LD_IP=data[0]["LD_IP"];
				     var LD_COPMUTER_NAME=data[0]["LD_COPMUTER_NAME"];
				     var SERVER_HOSTCODE = data[0]["SERVER_HOSTCODE"];
				     var SERVER_IP=data[0]["SERVER_IP"];
					 var SERVER_OWNER=data[0]["SERVER_OWNER"];
					 var CURRENT_USER_ASSET=data[0]["CURRENT_USER_ASSET"];
					   $("#reqcatview").val(CREQ);

					   $("#toasssetv").val(NEW_ASSSET);
					   
		             $("#actiontypev").val(CATEGORY_REQUEST);
		             $("#assetcodes").val(NEW_ASSSET);
			        	  $("#actiontype").val(RCAT);
			              $("#fromassetview").val(CURRENT_USER_ASSET);
			              
			              $("#temployeev").val(TO_EMP);
			              $("#rperiodv").val(NEW_DATE);
			        	
	             
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
	            $("#viewprocessinggroup1").val(COST);
	            $("#asset_Ipaddressview1").val(ASSET_IPADDRESS);
	          	
	            $("#raisedateupdateTD1").val(RAISE_DATE);
	            $("#statusupdateTD1").val(STATUS);
	            $("#ticketidupdateTD1").val(T_ID);
	            $("#descriptionupdateTD1").val(T_DESC);
	           
// $("#rim1").val(R_PERIOD);
	            $("#viewapprovallevel1").val(SOFTWARE_NAME);
	            $("#projectid1").val(P_ID);
	            
	            var ASSETNAME = data[0]["ASSETNAME"];
	             var ASSETSTATUS = data[0]["ASSETSTATUS"];
	             var ASSETCATEGORY = data[0]["ASSETCATEGORY"];
	             var ASSETTAG = data[0]["ASSETTAG"];
	             
	             var ASSETSUBCATEGORY = data[0]["ASSETSUBCATEGORY"];
	             var ASSET_IPADDRESS = data[0]["ASSET_IPADDRESS"];
	             
	             
	             $("#asset_sub_categoryview1").val(ASSETSUBCATEGORY);
	             $("#asset_Ipaddressview").val(ASSET_IPADDRESS);
	             
	             
	          
	             $("#aname1").val(ASSETNAME);
	             $("#atag1").val(ASSETTAG);
	             $("#astatus1").val(ASSETSTATUS);
	             $("#acategory1").val(ASSETCATEGORY); 
	            
	            
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
// alert("fgfg")
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
// alert(encodeURIComponent(filename))
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	window.location = base_url + "/Master/DownloadFile?filename=" + encodeURIComponent(filename);
       }

function downFileActivityLog(att) {
// alert(att)
// var filename = $('#filename').val();
		var filename =att;
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location = base_url + "/Master/DownloadFile?filename=" + filename;
	}
// ////////////////// GET ACTIVITY LOG ////////////////

$('a[role="tab"]').on('shown.bs.tab', function (e) {
	  var target = $(e.target).attr("id") // activated tab
	  if(target==="custom-tabs-four-profile-tab"){
		  ticketid= $("#ticketidupdateTD1").val();
// alert(ticketid)
		  var reqType="Software Transfer";
	
		  var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// var serviceUrl = base_url + "/UserActivity/getTicketActivityLog";
    var serviceUrl = base_url + "/EFormActivity/getRequestActivityLog";
    $.ajax({
        url: serviceUrl,
        type: 'post',
       dataType: 'json',
// async:false,
        data: 'ticketid=' + encodeURIComponent(ticketid)+
        '&type=' + reqType,

        success: function(data) {
     	// alert(JSON.Stringify(data))
// alert(data[0]["T_ID"]);
// alert(data)
        	// alert("hhh")
            var T_ID = data[0]["T_ID"];
            var TIMESTAMP = data[0]["TIMESTAMP"];
            var CHANGEBY = data[0]["CHANGEBY"];
            var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
            var STATUS = data[0]["STATUS"];
           var PRIORITY = data[0]["PRIORITY"];
            var SEVERITY=data[0]["SEVERITY"];
// alert(PRIORITY1)
// alert(SEVERITY1)
// var CATEGORY=data[0]["CATEGORY"];
// var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
// var SUBCATEGORY2=data[0]["SUBCATEGORY2"];
            
            
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
        	   
        	   
        	   // ////////////// CODE FOR ATTACHMENT////////////
        	   if(data[i]["ATTACHMENT_NAME"]==undefined || data[i]["ATTACHMENT_NAME"]=="No File Available" || data[i]["ATTACHMENT_NAME"]=="" || data[i]["ATTACHMENT_NAME"]==" " || data[i]["ATTACHMENT_NAME"]==null)
      		 {
      		 attachment="No File Attached";
      		 }
      	 else{
      		 att=data[i]["ATTACHMENT_NAME"];
      		 attachment="<i class='nav-icon fas fa-download' onclick=downFileActivityLog('"+encodeURIComponent(att)+"')></i>";
      	 }
        	   // //////////////CODE FOR COLOUR////////////
        	   statusColor=data[i]["STATUS"];
// alert(statusColor);
        	   var callOutColor="";
        	   if(statusColor=="Approval For Manager"){callOutColor="callout-info"}
        	   else if(statusColor=="Resolved"||statusColor=="Closed"){callOutColor="callout-success"}
        	   else if(statusColor=="Work in Progress" || statusColor=="Re-Opened"){callOutColor="callout-warning"}
        	   else if(statusColor=="Closed"||statusColor=="Approved By Manager"||  statusColor=="Approved By Second Manager"|| statusColor=="Approved By It Compliance"){callOutColor="callout-success"}
        	   else if(statusColor=="Rejected"|| statusColor=="Rejected By Second Manager"|| statusColor=="Rejected By Manager"||statusColor=="Rejected By It Compliance"||statusColor=="Hold"){callOutColor="callout-danger"}
        	  
        	   // ///////////// CODE FOR NOTES ///////////////
        	   if(data[i]["CHANGE_NOTES1"]==undefined || data[i]["CHANGE_NOTES1"]=="" || data[i]["CHANGE_NOTES1"]==" " || data[i]["CHANGE_NOTES1"]==null)
        		 {
        		   notes1="";
        		 }
        	 else{
        		 notes1="<textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["CHANGE_NOTES1"]+"</textarea>";
        	 }
        	           	   // //////////////CODE TO APPEND////////////
        	   html +=  "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type : <span>"+data[i]["ROLE_TYPE"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Priority : <span>"+data[i]["PRIORITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Severity : <span>"+data[i]["SEVERITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Full Name: <span>"+data[i]["FULLNAME"]+"</span></span></div></div><div class='row'><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Email : <span>"+data[i]["EMAIL"]+"</span></span></div></div><br><div class='row'><div class='col-md-12'>"+notes1+"</div></div></div>";
// "<div class='callout "+callOutColor+"'
// style='font-family:Calibri;font-size:14px;font-weight:bold'><div
// class='row'><div class='col-md-4'><span
// style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp :
// <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span
// style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type :
// <span>"+data[i]["ROLE_TYPE"]+"</span></span></div><div class='col-md-4'><span
// style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment :
// <span>"+attachment+"</span></span></div></div><div class='row'><div
// class='col-md-4'><span
// style='font-family:Calibri;font-size:14px;font-weight:bold'> Changed By :
// <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-8'><span
// style='font-family:Calibri;font-size:14px;font-weight:bold'>Full Name:
// <span>"+data[i]["FULLNAME"]+"</span></span></div></div><div class='row'><div
// class='col-md-4'><span
// style='font-family:Calibri;font-size:14px;font-weight:bold'>Status :
// <span>"+data[i]["STATUS"]+"</span></span></div><div class='col-md-8'><span
// style='font-family:Calibri;font-size:14px;font-weight:bold'>Email :
// <span>"+data[i]["EMAIL"]+"</span></span></div></div><br><div class='row'><div
// class='col-md-12'>"+notes1+"</div></div></div>";
        	   
              document.getElementById("MSG12341").innerHTML=html;
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
// alert("in confirm");
        	$('#tid').val(id);
        	$("#closereason").val("");
          $("#modelclose").modal("show");
        }
    });
// alert(id)

}
function reOpen(id)
{
var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/gatherTransferSoftwareDetails";
$.ajax({
    type: 'POST',
    url: serviceUrl,
    async:false,
    dataType: 'json',
    data: 'ticketid=' + encodeURIComponent(id),
// "&type"+type,
    success: function (data) {
    	
    	var PID=data[0]["PID"];
    	
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
    
        var COST = data[0]["COST"];
        var RPERIOD = data[0]["RPERIOD"];
        var RCAT = data[0]["CATREQUEST"];
       
        var NEWASSETCODE = data[0]["NEWASSETCODE"];
// alert()
      var NEWDATE = data[0]["NEWDATE"];
// alert(NEWDATE)
      var TOEMPLOYEE= data[0]["TOEMPLOYEE"];
      var CURRENT_UASSET = data[0]["CURRENT_UASSET"];
    var CREQ= data[0]["CREQ"];
      
    $("#fromasset").val(CURRENT_UASSET);
    $("#reqcat").val(CREQ);
      	
      	
      $("#actiontype").val(RCAT);
        $("#cost").val(NEWASSETCODE);
        $("#temployee").val(TOEMPLOYEE);
        $("#rperiod").val(NEWDATE);
        
      
        
        $("#sname").val(SNAME);
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
    $("#pid").val(PID);
    $("#rcat").val(RCAT);
// $("#licensekey").val(data[0]["LICENSEKEY"]);
    
    

    $("#nameupdateUDassign").val(T_REQUESTER);
    $("#companyupdateUDassign").val(T_COMPANY);
    $("#siteupdateUDassign").val(T_BRANCH);
    $("#deptupdateUDassign").val(T_DEPARTMENT);
    $("#phoneupdateUDassign").val(T_PHONE);
    $("#emailupdateUDassign").val(T_MAIL);
    
// $("#vipuser").val(VIP_LOGIN);

    $("#subjectupdateTDassign").val(T_SUBJECT);
    $("#raisedateupdateTDassign").val(RAISE_DATE);
    $("#statusupdateTDassign").val(STATUS);
    $("#ticketidupdateTDassign").val(T_ID);
    $("#descriptionupdateTDassign").val(T_DESC);
// $("#priorityupdateTDassign").val(PRIORITY);
    $("#RequestModeupdateTDassign").val(REQUEST_MODE);}
})


$("#modelreopen").modal("show");

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
 	var serviceUrl = base_url + "/EFormActivity/closeSoftwareRequestRequest";
    
    $.ajax({
                url: serviceUrl,
                type: 'post',
                data: 'ticketid=' + encodeURIComponent(idd)
                + '&closereason=' + $("#closereason").val(),
                success: function (data) {
                    if (data === "success") {
                        swal({
                            title: "Successful",
                            text: "Request Closed Successfully",
                            type: "success",
                            width: 300,
                            height: 200,
                            confirmButtonClass: "btn btn-danger",
// cancelButtonClass: "btn btn-danger m-l-10",
// confirmButtonText: "OK",
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

// alert("false");
        return false;

    } else {

// $('#spinner2').show();
// alert("true");
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
// focus out

$('#closereason').on('focus', function () {
    callToolTipCloseTicket('closereason', 'destroy');
});
// ////////////////////////////Re-Opened start//////////
$('#cancel-btn').on("click", function () {
	// alert("reopen close");
		$("#reopenreason").val("");
		callToolTipCloseTicket('closereason', 'destroy');
	    $("#modelreopen").modal("hide");
	});

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
// buttons: false,
	            allowOutsideClick: false
	            
		    }).then(function () {

		    	var l = window.location;
		    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		    	var serviceUrl = base_url + "/EFormActivity/SoftwareTransferReopenResolvedTicket";
		    	
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

	
	function validateFormReopen()
	{
	 var indexError = 0;
	   
	   if ($('#reopenreason').val() === '') {
	        // console.log('fill reopenreason');
	        callToolTipReopen('reopenreason', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	     // console.log("validation error count::::"+indexError);
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
	    if (fieldName === "reopenreason") {
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

	$('#reopenreason').on('focusout', function () {

	    var usertype = $('#reopenreason').val();
	    if (usertype.trim() == "") {
	        callToolTipClose('reopenreason', 'show');
	    }
	    else {
	        callToolTipClose('reopenreason', 'hide');
	    }
	});
	$('#reopenreason').on('focus', function () {
	    callToolTipClose('reopenreason', 'destroy');
	});

	function validateFormClose()
	{
	 var indexError = 0;
	   
	   if ($('#closereason').val() === '') {
	        // console.log('fill closereason');
	        callToolTipClose('closereason', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	     // console.log("validation error count::::"+indexError);
	 if (indexError != 0) {

	// alert("false");
	        return false;

	    } else {

	// $('#spinner2').show();
	// alert("true");
	        return true;
	    }

	}
// //////////////////////////////Re-Opened end/////
	
	function  characterCounter()
	{
//		alert("sdffsffd")
			
		$("#counterSpan").show();
		
		  var i = document.getElementById("reopenreason").value.length;
		  document.getElementById("calulate").innerHTML = 2000 - i; 
		  if(i<=0)
		  {
	    	  $("#calulate").val("");
		  };
	}
