 window.onload = function() {
   
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/TPActivity/getResolvedRequesttList";

            $.ajax({
                type: 'POST',
                url: serviceUrl,               
                dataType: 'json',
                
                success: function(data5) {
//                      alert(data5
                	$("#preLoader").hide();
                	$("#Listing_Copy").removeClass("d-none");
                    var table = $('#Listing_Copy').DataTable({
//                        lengthChange: false,
						"lengthMenu": [
							[5, 10, 25, 50, -1],
							[5, 10, 25, 50, 'Show all']
						],
                        pageLength: 5,
                        data: data5,
                        destroy: true,
                        scrollX: true,
                        columnDefs: [{
        					targets: [0,1,3,4,5,13,14,15,16,17,18,19,20],
        					orderable: false
        					}],

        				initComplete: function () {
        					this.api().columns([3,4,5,13,14,15,16,17,18,19,20]).every(function () {
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
            
            
            var l = window.location;
        	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        	var serviceUrl = base_url + "/Master/getPriorityName";  

    $.ajax({

        url :serviceUrl,
        type : 'POST',
        dataType: 'json',
    }).done(function(data) {

        var html =" <select class='form-control' tabindex='13' id='priorityupdateTDreassign' name='priorityupdateTDreassign' '>";
//        html=html+'<option value="">--Please Select Priority--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' +data[i]+ '">' + data[i]
            + '</option>';
        }

        document.getElementById("priorityupdateTDreassign").innerHTML=html;
    });
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getGroupDetails";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
    }).done(function (data) {

        var html = " <select class='form-control' tabindex='7' id='engGroup' name='engGroup'>";
        html = html + '<option value="">--Please Select Group--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("engGroup").innerHTML = html;
    });
}
 //////////// ONLOAD ENDS //////////////// 
 function change_enggsubtype(category)
 {
 	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getSubCategoryEnggName";

     $.ajax({

         url: serviceUrl,
         type: 'POST',
         dataType: 'json',
         data: 'categ=' + encodeURIComponent(category)
         + '&Company=' + encodeURIComponent($("#companyupdateUDreassign").val())
         + '&Branch=' + encodeURIComponent($("#siteupdateUDreassign").val())
         + '&Department=' + encodeURIComponent($("#deptupdateUDreassign").val()),
         
     }).done(function (data) {
//     	alert(data)
         var html = " <select class='form-control' tabindex='7' id='enggassign' name='enggassign'>";
         html = html + '<option value="">--Please Select Engineer--</option>';
         for (var i = 0; i < data.length; i++) {
             html += '<option value="' + data[i] + '">' + data[i]
                     + '</option>';
         }

         document.getElementById("enggassign").innerHTML = html;
     });
 }
 
 function viewTicket(id)
 {
 //alert(id)	
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
//           alert("T_ATTACH1_NAME: "+T_ATTACH1_NAME);

				
        	  
			  
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
         
//         alert( ASSETCHECK)
     if(T_COMPANY=="3i Infotech")  
    	 {
    	 
    	
         if(ASSETCHECK == "true")
    	 {
        	
    	 document.getElementById("HideAssetdata").style.display = "block";

    	 }
     else
    	 {
//    	 alert( "hhh")
    	 document.getElementById("HideAssetdata").style.display = "none";
    	 }
    	 }
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
// 	alert(encodeURIComponent(filename))
 	var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	window.location = base_url + "/Master/DownloadFile?filename=" + encodeURIComponent(filename);
        }

 function downFileActivityLog(att) {
// 	alert(att)
// 		var filename = $('#filename').val();
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
//         	alert(data[0]["CHANGE_NOTES2"]);
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
             var SUBCATEGORY1=data[0]["SUBCATEGORY1"];
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
//         	   alert(statusColor);
         	   var callOutColor="";
         	  if(statusColor=="New"){callOutColor="callout-info"}
       	   else if(statusColor=="Assigned" || statusColor=="Level_1_Approved" || statusColor=="Level_2_Approved"|| statusColor=="Level 1 Approved"||statusColor=="Level 2 Approved"||statusColor=="Re-Assigned"||statusColor=="Re-Opened"||statusColor=="Work in Progress"){callOutColor="callout-warning"}
       	  
       	   else if(statusColor=="Resolved"||statusColor=="Closed"||statusColor=="Completed" ){callOutColor="callout-success"}
       	   else if(statusColor="Rejected"||statusColor=="Re-Opened"||statusColor=="Hold" || statusColor=="Waiting for Spare" ||  statusColor=="Pending With Vendor"  ||  statusColor=="Awaiting User Information"||statusColor=="Level 1 Rejected"|| statusColor=="Level 2 Rejected"){callOutColor="callout-danger"}   
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

$('#ticketclose-btn').on("click", function () {
    if(!validateFormCloseTicket())
    {
        event.preventDefault();
    }
    else if (validateFormCloseTicket())
    {
    var idd= $("#tid").val();
   // alert(idd);
    
    $("#ticketclose-btn").attr("disabled", true);
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/closeUserResolvedRequest";
    
    $.ajax({
                url: serviceUrl,
                type: 'post',
                data: 'ticketid=' + encodeURIComponent(idd)
                + '&closereason=' + encodeURIComponent($("#closereason").val()),
                //+ '&athorrrr=' + $("#athorrrr").val(),
                success: function (data) {
//                    alert(data);
                    if (data === "success") {
                        swal({
                            title: "Successful!",
                            text: "Request Closed Successfully",
                            type: "success",
                            width: 300,
                            height: 200,
//                   		 showCancelButton: false,
//                          confirmButtonClass: "btn btn-danger",
//                          cancelButtonClass: "btn btn-danger m-l-10",
//                          confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                            preConfirm: function () {
                                location.reload();
                            }
                        });
                    }else if (data === "duplicate") {
                swal({
                    title: "Not Allowed",
                    text: "Cant close if Request is not Resolved",
                    type: "error",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
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

       


var callToolTipCloseTicket = function (fieldName, status) {
    if (fieldName === "closereason") {
        var errorMessage = "<span>Please Enter Close Reason<span>";
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
//focus out

$('#closereason').on('focus', function () {
    callToolTipCloseTicket('closereason', 'destroy');
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
var callToolTip231 = function (fieldName, status) {
    if (fieldName === "statusupdateENG") {
        var errorMessage = "<span>Please Select Status<span>";
    }
    else if (fieldName === "assignTo") {      
        var errorMessage = "<span>Please Select Assign To<span>";
    }
    else if (fieldName === "enggcat") {      
        var errorMessage = "<span>Please Select Category<span>";
    }
    else if (fieldName === "enggassign") {
        var errorMessage = "<span>Please Select Engineer<span>";
    }
    else if (fieldName === "engGroup") {
        var errorMessage = "<span>Please Select Engineer Group<span>";
    }
    else if (fieldName === "holdnotes") {
        var errorMessage = "<span>Please Your Enter Note <span>";
    }
    else if (fieldName === "priorityupdateTDreassign") {
        var errorMessage = "<span>Please Select Priority<span>";
    }
    else if (fieldName === "severityupdateTDreassign") {
        var errorMessage = "<span>Please Select Severity<span>";
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
	
      var indexError = 0;
   
   if ($('#statusupdateENG').val() === '') {
        console.log('fill statusupdateENG');
        callToolTip231('statusupdateENG', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   
   if ($('#holdnotes').val() === '') {
        console.log('fill assinotes');
        callToolTip231('holdnotes', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   
   if ($('#statusupdateENG').val() === '') {
       console.log('fill statusupdateENG');
       callToolTip231('statusupdateENG', 'show');

       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   if ($('#assignTo').val().trim() === '' && ( $('#statusupdateENG').val() =='Re-Assigned' || $('#statusupdateENG').val()=='Hold')) {
      console.log('fill enggcat');
       callToolTip231('assignTo', 'show');

       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   if ($('#assignTo').val().trim() === 'Engineer') {
	   
	   if ($('#enggcat').val().trim() === '') {
	        console.log('fill enggcat');
	        callToolTip231('enggcat', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	    if ($('#enggassign').val().trim() === '') {
	        console.log('fill enggassign');
	        callToolTip231('enggassign', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    } 
   } else if ($('#assignTo').val().trim() === 'Group' && ( $('#statusupdateENG').val() =='Re-Assigned' || $('#statusupdateENG').val()=='Hold')) {
	   
	   if ($('#engGroup').val().trim() === '') {
//	        console.log('fill enggassign');
	        callToolTip231('engGroup', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
   }
 
   if ($('#priorityupdateTDreassign').val().trim() === '') {
       console.log('fill priorityupdateTDreassign');
       callToolTip231('priorityupdateTDreassign', 'show');

       if (indexError == 0) {

       }
       indexError = indexError + 1;
   } 
   if ($('#severityupdateTDreassign').val().trim() === '') {
       console.log('fill enggassign');
       callToolTip231('severityupdateTDreassign', 'show');
     
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   } 

  // console.log("validation error count::::"+indexError);
 if (indexError != 0) {

//    alert("false");
        return false;

    } else {

//        $('#spinner2').show();
//    alert("true");
        return true;
    }

}
$('#statusupdateENG').on('focusout', function () {

    var usertype = $('#statusupdateENG').val();
    if (usertype.trim() === "") {
        callToolTip231('statusupdateENG', 'show');
    }
    else {
        callToolTip231('statusupdateENG', 'hide');
    }
});
$('#severityupdateTDreassign').on('focusout', function () {

    var usertype = $('#severityupdateTDreassign').val();
    if (usertype.trim() === "") {
        callToolTip231('severityupdateTDreassign', 'show');
    }
    else {
        callToolTip231('severityupdateTDreassign', 'hide');
    }
});
$('#priorityupdateTDreassign').on('focusout', function () {

    var usertype = $('#priorityupdateTDreassign').val();
    if (usertype.trim() === "") {
        callToolTip231('priorityupdateTDreassign', 'show');
    }
    else {
        callToolTip231('priorityupdateTDreassign', 'hide');
    }
});

//focus out
$('#assignTo').on('focusout', function () {

    var usertype = $('#assignTo').val();
    if (usertype.trim() == "") {
        callToolTip231('assignTo', 'show');
    }
    else {
        callToolTip231('assignTo', 'hide');
    }
});
//focus out
$('#enggcat').on('focusout', function () {

    var usertype = $('#enggcat').val();
    if (usertype.trim() == "") {
        callToolTip231('enggcat', 'show');
    }
    else {
        callToolTip231('enggcat', 'hide');
    }
});
//focus out
$('#enggassign').on('focusout', function () {

    var usertype = $('#enggassign').val();
    if (usertype.trim() == "") {
        callToolTip231('enggassign', 'show');
    }
    else {
        callToolTip231('enggassign', 'hide');
    }
});

$('#holdnotes').on('focusout', function () {

    var usertype = $('#holdnotes').val();
    if (usertype.trim() == "") {
        callToolTip231('holdnotes', 'show');
    }
    else {
        callToolTip231('holdnotes', 'hide');
    }
});

//focus out
$('#engGroup').on('focusout', function () {

    var usertype = $('#engGroup').val();
    if (usertype.trim() == "") {
        callToolTip231('engGroup', 'show');
    }
    else {
        callToolTip231('engGroup', 'hide');
    }
});
//focus out
$('#holdnotes').on('focusout', function () {

    var usertype = $('#holdnotes').val();
    if (usertype.trim() == "") {
        callToolTip231('holdnotes', 'show');
    }
    else {
        callToolTip231('holdnotes', 'hide');
    }
});
//focus out

$('#statusupdateENG').on('focus', function () {
    callToolTip231('statusupdateENG', 'destroy');
});
$('#assinotes').on('focus', function () {
    callToolTip231('assinotes', 'destroy');
});
$('#assignTo').on('focus', function () {
    callToolTip231('assignTo', 'destroy');
});
$('#enggcat').on('focus', function () {
    callToolTip231('enggcat', 'destroy');
});
$('#enggassign').on('focus', function () {
    callToolTip231('enggassign', 'destroy');
});
$('#engGroup').on('focus', function () {
    callToolTip231('engGroup', 'destroy');
});
$('#holdnotes').on('focus', function () {
    callToolTip231('holdnotes', 'destroy');
});
$('#severityupdateTDreassign').on('focus', function () {
    callToolTip231('severityupdateTDreassign', 'destroy');
});
$('#priorityupdateTDreassign').on('focus', function () {
    callToolTip231('priorityupdateTDreassign', 'destroy');
});



function ToggleHoldReason(value){
//    alert(value)
if(value==="Hold"){
    $('#TPHoldNotes').show();
}else if(value==="Re-Assigned" || value===""){
    $('#TPHoldNotes').hide();
    $('#holdnotes').val("");
}
}

function change_Assigntype(assignType){
//	alert(assignType)
	$('#enggcat').val("");
	$('#enggassign').val("");
	$('#engGroup').val("");
	callToolTip231('enggcat', 'destroy');
	callToolTip231('enggassign', 'destroy');
	callToolTip231('engGroup', 'destroy');
	
	if(assignType==="Engineer"){
		$('#enggDiv').show();
		$('#groupDiv').hide();
	}
	else if(assignType==="Group"){
		$('#groupDiv').show();
		$('#enggDiv').hide();
	}
	else{
		$('#enggDiv').hide();
		$('#groupDiv').hide();
	}
}
$('#modelclose').on('hidden.bs.modal', function () {
	
	$("#closereason").val("");
	
})

/////////////////////////Request for Reassign and Hold/////////
function reassignRequest(id)
{
	//alert(id)
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
        	/////////////////// GET PRIORITY DATA /////////////
        	var l = window.location;
         	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
         	var serviceUrl = base_url + "/Master/getPriorityName";
            $.ajax({
            	url :serviceUrl,
                type : 'POST',
                dataType: 'json',
                data: 'companyname=' + encodeURIComponent(data[0]["T_COMPANY"]),
            }).done(function(prioritydata) {
                var html =" <select class='form-control' tabindex='13' id='priorityupdateTDreassign' name='priorityupdateTDreassign' '>";
                for (var i = 0; i < prioritydata.length; i++) {
                    html += '<option value="' +prioritydata[i]+ '">' + prioritydata[i]
                    + '</option>';
                }
                document.getElementById("priorityupdateTDreassign").innerHTML=html;
                $("#priorityupdateTDreassign").val(data[0]["PRIORITY"]);
            });
            
            /////////////////// GET SEVERITY DATA /////////////
        	var l = window.location;
         	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
         	var serviceUrl = base_url + "/Master/getSeverityName";
            $.ajax({
            	url :serviceUrl,
                type : 'POST',
                dataType: 'json',
                data: 'companyname=' + encodeURIComponent(data[0]["T_COMPANY"]),
            }).done(function(severitydata) {
                var html =" <select class='form-control' tabindex='13' id='severityupdateTDreassign' name='severityupdateTDreassign' '>";
                for (var i = 0; i < severitydata.length; i++) {
                    html += '<option value="' +severitydata[i]+ '">' + severitydata[i]
                    + '</option>';
                }
                document.getElementById("severityupdateTDreassign").innerHTML=html;
                $("#severityupdateTDreassign").val(data[0]["SEVERITY"]);
            });
        	
        	
        	
        	
        	
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

     //      alert(T_REQUESTER)
            $("#nameupdateUDreassign").val(T_REQUESTER);
            $("#companyupdateUDreassign").val(T_COMPANY);
            $("#siteupdateUDreassign").val(T_BRANCH);
            //deptupdateUDreassign
            $("#deptupdateUDreassign").val(T_DEPARTMENT);
            $("#phoneupdateUDreassign").val(T_PHONE);
            $("#emailupdateUDreassign").val(T_MAIL);
          //  $("#vipuser").val(VIP_LOGIN);
            
            $("#categoryupdateTDreassign").val(T_CATEGORY);
            $("#subcat1updateTDreassign").val(T_SUBCAT1);
            $("#subcat2updateTDreassign").val(T_SUBCAT2);
            $("#subjectupdateTDreassign").val(T_SUBJECT);
            $("#raisedateupdateTDreassign").val(T_DATE);
            $("#statusupdateTDreassign").val(STATUS);
            $("#ticketidupdateTDreassign").val(T_ID);
            $("#descriptionupdateTDreassign").val(T_DESC);
            $("#priorityupdateTDreassign").val(PRIORITY);
            $("#severityupdateTDreassign").val(SEVERITY);
            $("#RequestModeupdateTDreassign").val(REQUEST_COST);
            $("#RequestModeupdateTDassign").val(REQUEST_MODE);
            $("#designationlevel2").val(DESIGNATION2);



        }
    });
    
  
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getCategoryDetails";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
    }).done(function (data) {
    	//alert(data)
        var html = " <select class='form-control' tabindex='7' id='enggcat' name='enggcat' onchange='change_enggsubtype(this.value)'>";
        html = html + '<option value="">--Please Select Category--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("enggcat").innerHTML = html;
    });
    
    $("#modelreassign").modal("show");
}

function ToggleHoldReason(value){
 //   alert(value)
    	change_Assigntype("");
    	$("#assignTo").val("");
    	// $('#AssignID').hide();
    	 //$('#engdiv2').hide();
    	// $('#enggDiv').hide();
    	 callToolTip231('assignTo', 'hide');
         callToolTip231('enggcat', 'hide');
         callToolTip231('enggassign', 'hide');
    	
    	
    	 if(value==="Re-Assigned"||value==="Hold"){
    		// alert("value    " +value);
    		 $('#engdetails').show();
    	 
    	}else{
    		
    		$('#engdetails').hide();
    		
    	}
    /*	
     if(value==="Assigned"){
    	 
    	 $('#AssignID').show();
        $('#TPHoldNotes').hide();
           $('#holdnotes').val("");
    }*/
    }

    function change_Assigntype(assignType){
//    	alert(assignType)
    	
    	document.getElementById("Hideotherdata").style.display = "none";
    	$('#enggcat').val("");
    	$('#enggassign').val("");
    	$('#engGroup').val("");
    	callToolTip231('enggcat', 'destroy');
    	callToolTip231('enggassign', 'destroy');
    	callToolTip231('engGroup', 'destroy');
    	
    	if(assignType==="Engineer"){
    		$('#enggDiv').show();
    		$('#groupDiv').hide();
    	}
    	else if(assignType==="Group"){
    		
    		//alert($("#companyupdateTP").val());

    		var l = window.location;
    		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    		var serviceUrl = base_url + "/Master/getGropupfromgroupmaster";

    		$.ajax({

    		    url: serviceUrl,
    		    type: 'POST',
    		    dataType: 'json',
    		    async :false,
    		    data:'company='+encodeURIComponent($("#companyupdateTP").val()),
    		}).done(function (data) {

    		    var html = " <select class='form-control' tabindex='7' id='engGroup' name='engGroup'>";
    		    html = html + '<option value="">--Please Select Group--</option>';
    		    for (var i = 0; i < data.length; i++) {
    		        html += '<option value="' + data[i] + '">' + data[i]
    		                + '</option>';
    		    }

    		    document.getElementById("engGroup").innerHTML = html;
    		});


    		
    		$('#groupDiv').show();
    		$('#enggDiv').hide();
    	}
    	else{
    		$('#enggDiv').hide();
    		$('#groupDiv').hide();
    	}
    }
    $('#modelassign').on('hidden.bs.modal', function () {
    	 document.getElementById("Hideotherdata").style.display = "none";
    	
    	ToggleHoldReason("");
    	
    	$("#statusupdateENG").val("");
//    	$("#designationlevel2").val("");
//    	$("#username2").val("");
    	$("#assinotes").val("");
    	$("#assignTo").val("");
    	
    })



    //CODE FOR GET OTHER DATA
    function getothersdata(othername){
    	 document.getElementById("Hideotherdata").style.display = "none";
    	
    	if(othername.length>0){
    	//	alert("inside");
    	 
    	
    	//alert(othername);
    	//getting split for company and username
    	
    	const words = othername.split('~');
    	//console.log(words[0]);
    	var otherusername=words[0];
    	var othercompany=words[2];
//    	alert(othercompany + "company");
    	//alert(otherusername + "otherusername ias");
    	 var l = window.location;
    		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    		var serviceUrl = base_url + "/UserActivity/Getotherinformaion";
    	
    	  $.ajax({
    	      type: 'POST',	
    	      url: serviceUrl,
    	      dataType: 'json',
    	     data: 'othername=' + encodeURIComponent(otherusername)
    	     + '&othercompany=' + encodeURIComponent(othercompany),
    	     
    	      success: function(data) {  	
    	      
    	    	 // alert(data[0]["OTHEREMAIL"])
    	    	var OTHEREMAIL=data[0]["OTHEREMAIL"];
    	    	var OTHERFULLNAME=data[0]["OTHERFULLNAME"];
    	    	var OTHERCOMPANY=data[0]["OTHERCOMPANY"];
    	    	var OTHERBRANCH=data[0]["OTHERBRANCH"];
    	    	var OTHERDEPARTMENT=data[0]["OTHERDEPARTMENT"];
    	    	
    	    	
    	    	$("#otheremail").val(OTHEREMAIL);
    	    	$("#otherfullname").val(OTHERFULLNAME);
    	    	$("#othersite").val(OTHERBRANCH);
    	    	$("#othercompname").val(OTHERCOMPANY);
    	    	$("#otherdepart").val(OTHERDEPARTMENT);
    	     
    	    	
    	      }
    	}); 
    	    document.getElementById("Hideotherdata").style.display = "block";

    	
    	}
    }
    $('#submit-btnForReassign').on("click", function () {
    
   // alert("btnForReassign")
        if(!validateForm200())
        {
          //  alert("fail")
            event.preventDefault();
        }
        else if (validateForm200())
        {
        	$("#submit-btn").attr("disabled", true);
        	// alert("submit2")
            //alert("pass")
           // alert($("#holdnotes").val())
        	
        	var l = window.location;
         	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
         	var serviceUrl = base_url + "/TPActivity/InsertReAssignOrHoldRequest";
        	
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
            if (data === "success") {
              
            	if(($("#statusupdateENG").val())== "Work in Progress")
                {
                	  swal({
                          title: "Successful!",
                          text: 'Request Status Change to (Work in Progress) Successfully', 
                          type: "success",
                          width: 300,
                          height: 200,
                          showCancelButton: !0,
                          confirmButtonClass: "btn btn-danger",
                          cancelButtonClass: "btn btn-danger m-l-10",
                          showCancelButton: false,

                          buttons: false,
                          allowOutsideClick: false,
                          preConfirm: function () {
                              location.reload();
                          }

                      })
                }  
            	else	if(($("#statusupdateENG").val())== "Re-Assigned")
                {
                	  swal({
                          title: "Successful!",
                          text: 'Request Status Change to (Re-Assigned") Successfully', 
                          type: "success",
                          width: 300,
                          height: 200,
                          showCancelButton: !0,
                          confirmButtonClass: "btn btn-danger",
                          cancelButtonClass: "btn btn-danger m-l-10",
                          showCancelButton: false,

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
                       	text: 'Failed to Update Service Request', 
                       	type: 'error',
                        width: 300,
                        height: 200,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-danger",
                        cancelButtonClass: "btn btn-danger m-l-10",
                        showCancelButton: false,

                        buttons: false,
                        allowOutsideClick: false,
                        preConfirm: function () {
                            location.reload();
                        }

                    })
                     }
            
        

        });}
       
    });
    $('#modelreassign').on('hidden.bs.modal', function () {
    	
    	$("#statusupdateENG").val("");
    	$("#assignTo").val("");
    	$("#enggcat").val("");
    	$("#enggassign").val("");
    	$('#engdetails').hide();
    	$("#holdnotes").val("");
    	
    	change_Assigntype('');
    	document.getElementById("Hideotherdata").style.display = "none";
    	
    	
    });
    
    function  characterCounter()
    {
//    	alert("sdffsffd")
    		
    	$("#counterSpan").show();
    	
    	  var i = document.getElementById("holdnotes").value.length;
    	  document.getElementById("calulateId").innerHTML = 2000 - i; 
    	  if(i<=0)
    	  {
        	  $("#calulateId").val("");
    	  };
    }
