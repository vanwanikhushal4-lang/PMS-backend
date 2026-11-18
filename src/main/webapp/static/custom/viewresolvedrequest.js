window.onload = function () {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getResolvedRequest";
	
// var serviceUrl = "getResolvedUserTicketList";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json', 
        success: function (data5) {
// alert(data5
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
                   columnDefs: [{
   					targets: [0,1,3,4,5,14,15,16,17,18],
   					orderable: false
   					}],
   				initComplete: function () {
   					this.api().columns([3,4,5,14,15,16,17,18]).every(function () {
   				         var column = this;
   				         $(column.header()).prepend("<br>")
   				           var select = $('<select><option value="">All</option></select>').prependTo($(column.header()))
   				                               .on('change', function () {
   				                 var val = $.fn.dataTable.util.escapeRegex(
   				                     $(this).val()
   				                 );
   				                 column.search(val ? '^' + val + '$' : '', true, false).draw();
   				             });
   				           column.data().unique().sort().each(function (d, j) {
   				             select.append('<option value="' + d + '">' + d + '</option>')
   				          } );

   				 
   				    } );
   				}

            });
            table.buttons().container()
                    .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
            $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
        }
    });
}


function viewTicket(id)
{
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/UserActivity/gatherUserServiceRequest";
        
           $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(id),

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
//          alert("T_ATTACH1_NAME: "+T_ATTACH1_NAME);


			
			     var REQUESTTYPE = data[0]["REQUESTTYPE"];
          var APPROVALLEVEL = data[0]["APPROVALLEVEL"];
           var PROCESSINGGROUP = data[0]["PROCESSINGGROUP"];
			  

           
           
           var ASSETCHECK = data[0]["ASSETCHECK"];
           var ASSETNAME = data[0]["ASSETNAME"];
           var ASSETSTATUS = data[0]["ASSETSTATUS"];
           var ASSETCATEGORY = data[0]["ASSETCATEGORY"];
           var ASSETTAG = data[0]["ASSETTAG"];
           
           var ASSETSUBCATEGORY = data[0]["ASSETSUBCATEGORY"];
           var ASSET_IPADDRESS = data[0]["ASSET_IPADDRESS"];
           
           
           $("#asset_sub_categoryview").val(ASSETSUBCATEGORY);
           $("#asset_Ipaddressview").val(ASSET_IPADDRESS);
           
           
           $("#assetcheck").val(ASSETCHECK);
           $("#aname").val(ASSETNAME);
           $("#atag").val(ASSETTAG);
           $("#astatus").val(ASSETSTATUS);
           $("#acategory").val(ASSETCATEGORY);
           
//           alert( ASSETCHECK)
      
       	
			$("#viewrequesttype").val(REQUESTTYPE);
      $("#viewapprovallevel").val(APPROVALLEVEL);
      $("#viewprocessinggroup").val(PROCESSINGGROUP);
		  
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
            $("#severityupdateTD1").val(SEVERITY);
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
      
if(T_COMPANY=="3i Infotech" && ASSETCHECK == "true")  
{

document.getElementById("HideAssetdata").style.display = "block";

}
else {

	document.getElementById("HideAssetdata").style.display = "none";
	 }
        }
    });
             $("#modelview").modal("show");
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

function downFile()
      {
	var filename = $('#filename').val();
//	alert(filename)
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
    var serviceUrl = base_url + "/UserActivity/getServiceActivityLog";
    
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
            var ROLE_TYPE = data[0]["ROLE_TYPE"];
            var SEVERITY=data[0]["SEVERITY"];
            var CATEGORY=data[0]["CATEGORY"];
            var CATEGORY=data[0]["SUBCATEGORY1"];
            var CATEGORY=data[0]["SUBCATEGORY2"];
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
           	   else if(statusColor=="Assigned" || statusColor=="Level_1_Approved" || statusColor=="Level_2_Approved"|| statusColor=="Level 1 Approved"||statusColor=="Level 2 Approved"||statusColor=="Re-Assigned"||statusColor=="Reopened"||statusColor=="Work in Progress"){callOutColor="callout-warning"}
           	  
           	   else if(statusColor=="Resolved"||statusColor=="Closed"||statusColor=="Completed" ){callOutColor="callout-success"}
           	   else if(statusColor="Rejected"||statusColor=="Reopened"||statusColor=="Hold" || statusColor=="Waiting for Spare" ||  statusColor=="Pending With Vendor"  ||  statusColor=="Awaiting User Information"||statusColor=="Level 1 Rejected"|| statusColor=="Level 2 Rejected"){callOutColor="callout-danger"}   
        	 
        	   
        	   /////////////// CODE FOR NOTES ///////////////
        	   if(data[i]["CHANGE_NOTES1"]==undefined || data[i]["CHANGE_NOTES1"]=="" || data[i]["CHANGE_NOTES1"]==" " || data[i]["CHANGE_NOTES1"]==null)
        		 {
        		   notes1="";
        		 }
        	 else{
        		 notes1="<textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["CHANGE_NOTES1"]+"</textarea>";
        	 }
        	   
        	   ////////////////CODE TO APPEND////////////
        	   html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type : <span>"+data[i]["ROLE_TYPE"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Priority : <span>"+data[i]["PRIORITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Severity : <span>"+data[i]["SEVERITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Category : <span>"+data[i]["CATEGORY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category1 : <span>"+data[i]["SUBCATEGORY1"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category2 : <span>"+data[i]["SUBCATEGORY2"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Full Name: <span>"+data[i]["FULLNAME"]+"</span></span></div></div><div class='row'><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Email : <span>"+data[i]["EMAIL"]+"</span></span></div></div><br><div class='row'><div class='col-md-12'>"+notes1+"</div></div></div>";
        	   
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
        text: "Are you sure you want to close the request",
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
        	$("#closereason").val("");
            
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
    
    $("#ticketclose-btn").attr("disabled", true);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/UserActivity/closeUserResolvedRequest";
    
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
                            text: "Request Closed Successfully",
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




$('#cancel-btn').on("click", function () {
// alert("reopen close");
    $("#modelreopen").modal("hide");
});

$('#reopen-btn').on("click", function () {


      
       });
       	

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
        console.log('fill closereason');
        callToolTipClose('closereason', 'show');

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
$('#modelclose').on('hidden.bs.modal', function () {
	
	$("#closereason").val("");
	
})
function ReOpenTicket(id)
{

	
	/////////////////////////////////Thir party Details////////////////////////
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/TPActivity/gatherApprovedByDetails";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(id),

        success: function (data) {
        	
    		var T_SUBDEPARTMENT = data[0]["T_SUBDEPARTMENT"];
			var T_LOCATION = data[0]["T_LOCATION"];
			
			var TP_SUBDEPARTMENT = data[0]["TP_SUBDEPARTMENT"];
			var TP_LOCATION = data[0]["TP_LOCATION"];
			
			

            var T_REQUESTER = data[0]["T_REQUESTER"];
            var T_COMPANY = data[0]["T_COMPANY"];
            var T_BRANCH = data[0]["T_BRANCH"];
            var T_DEPARTMENT = data[0]["T_DEPARTMENT"];
            var T_PHONE = data[0]["T_PHONE"];
            var T_MAIL = data[0]["T_MAIL"];
            var VIP_LOGIN = data[0]["VIP_LOGIN"];
            
            var T_CATEGORY = data[0]["T_CATEGORY"];
            var T_SUBCAT1 = data[0]["T_SUBCAT1"];
            var T_SUBCAT2 = data[0]["T_SUBCAT2"];
            var T_SUBJECT = data[0]["T_SUBJECT"];
            var T_DATE = data[0]["T_DATE"];
            var STATUS = data[0]["STATUS"];
            var T_ID = data[0]["T_ID"];
            var T_DESC = data[0]["T_DESC"];
            var PRIORITY = data[0]["PRIORITY"];
           var  REQUEST_COST = data[0]["REQUEST_COST"];
           var  SEVERITY = data[0]["SEVERITY"];
            var REQUEST_MODE = data[0]["REQUEST_MODE"];
            var DESIGNATION2=data[0]["DESIGNATION2"];
            DESIGNATION2FORCHECK=data[0]["DESIGNATION2"];

            var TP_NAME = data[0]["TP_NAME"];
            var TP_COMPANY = data[0]["TP_COMPANY"];
            var TP_BRANCH = data[0]["TP_BRANCH"];
            var TP_DEPARTMENT = data[0]["TP_DEPARTMENT"];
            var TP_PHONE = data[0]["TP_PHONE"];
            var TP_MAIL = data[0]["TP_MAIL"];
            APPROVE1STATUS=data[0]["APPROVE1STATUS"];


var REQUESTTYPE = data[0]["REQUESTTYPE"];
var APPROVALLEVEL = data[0]["APPROVALLEVEL"];
var PROCESSINGGROUP = data[0]["PROCESSINGGROUP"];


$("#actionrequesttype").val(REQUESTTYPE);
$("#actionapprovallevel").val(APPROVALLEVEL);
$("#actionprocessinggroup").val(PROCESSINGGROUP);


      //    alert(TP_NAME);
//            $("#subdeptupdateUDreopen").val(T_SUBDEPARTMENT);
//			$("#locationupdateUDreopen").val(T_LOCATION);
			$("#locationupdateUDreopen").val(TP_LOCATION);
			$("#subdeptupdateUDreopen").val(TP_SUBDEPARTMENT);
			
            $("#nameupdateTP").val(TP_NAME);
            $("#companyupdateTP").val(TP_COMPANY);
            $("#siteupdateTP").val(TP_BRANCH);
            $("#deptupdateTP").val(TP_DEPARTMENT);
            $("#phoneupdateUDreopen").val(TP_PHONE);
            $("#emailupdateUDreopen").val(TP_MAIL);

     //      alert(T_REQUESTER)
            $("#nameupdateUDreopen").val(T_REQUESTER);
            $("#companyupdateUDreopen").val(T_COMPANY);
            $("#siteupdateUDreopen").val(T_BRANCH);
            //deptupdateUDreassign
            $("#deptupdateUDreopen").val(T_DEPARTMENT);
            $("#phoneupdateUDreassign").val(T_PHONE);
            $("#emailupdateUDreassign").val(T_MAIL);
          //  $("#vipuser").val(VIP_LOGIN);
            
            $("#categoryupdateTDreopen").val(T_CATEGORY);
            $("#subcat1updateTDreopen").val(T_SUBCAT1);
            $("#subcat2updateTDreopen").val(T_SUBCAT2);
            $("#subjectupdateTDreopen").val(T_SUBJECT);
            $("#raisedateupdateTDreopen").val(T_DATE);
            $("#statusupdateTDreopen").val(STATUS);
            $("#ticketidupdateTDreopen").val(T_ID);
            $("#descriptionupdateTDreopen").val(T_DESC);
            $("#priorityupdateTDreopen").val(PRIORITY);
            $("#severityupdateTDreopen").val(SEVERITY);
            $("#RequestModeupdateTDreopen").val(REQUEST_COST);
            $("#RequestModeupdateTDassign").val(REQUEST_MODE);
            $("#designationlevel2").val(DESIGNATION2);



        }
    });

	$("#modelreopen").modal("show");
}


var callToolTipReOpen = function (fieldName, status) {
    if (fieldName === "reopenreason") {
        var errorMessage = "<span>Please Enter Your  Re-Open Reason<span>";
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


function validateFormReopen()
{
	 var indexError = 0;
	   
	   if ($('#reopenreason').val() === '') {
	        console.log('fill closereason');
	        callToolTipReOpen('reopenreason', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	     console.log("validation error count::::"+indexError);
	 if (indexError != 0) {

	
	        return false;

	    } else {

	        return true;
	    }
}
$('#reopenreason').on('focusout', function () {

    var usertype = $('#reopenreason').val();
    if (usertype.trim() == "") {
    	callToolTipReOpen('reopenreason', 'show');
    }
    else {
    	callToolTipReOpen('reopenreason', 'hide');
    }
});
$('#reopenreason').on('focus', function () {
	callToolTipReOpen('reopenreason', 'destroy');
});

$('#reopen-btn').on("click", function () {

  
	if(!validateFormReopen()){

	    event.preventDefault();
	    
	}else if(validateFormReopen())
	{
		$("#reopen-btn").attr("disabled", true);
		 swal({
		        title: "Are you sure?",
		        text: "You want to Re-Open Service Request?",
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
		    	var serviceUrl = base_url + "/UserActivity/ReopenResolvedServiceRequest";
		    	
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
		                        text: "Service Request Successfully Reopened",
		                        type: "success",
		                        width: 300,
		                        height: 200,

		                        buttons: false,
		                        allowOutsideClick: false,
		                        preConfirm: function () {
		                            var l = window.location;
		                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		                            window.location.href = base_url + "/User/ViewResolvedResquest";
		                        }
		                    });
		                }else if (data === "duplicate") {
		                    swal({
		                        title: "Not Allowed",
		                        text: "You have already Reopened this Service Request",
		                        type: "error",
		                        width: 300,
		                        height: 200,

	 preConfirm: function() {
	 location.reload();
	 }                   });

		                }
		                    }); 
		    });}
		 
	      
	       });
	       
$('#modelreopen').on('hidden.bs.modal', function () {
	
	$("#reopenreason").val("");
	
})



