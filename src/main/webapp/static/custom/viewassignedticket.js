 window.onload = function() {
   
	 var ticketType=false;
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/TPActivity/getAssignedTicketList";
	 
//            var serviceUrl = "getAssignedTicketList";
            $.ajax({
                type: 'POST',
                url: serviceUrl,               
                dataType: 'json',
                data:'ticketType='+ticketType,
                success: function(data5) {
                	$("#preLoader").hide();
                	$("#Listing_Copy").removeClass("d-none");
                    var table = $('#Listing_Copy').DataTable({
//                        lengthChange: false,
					"lengthMenu":[
	                    [5,10,25,50,-1],
	                    [5,10,25,50,'Show all']
                	],
                        pageLength: 5,
                        data: data5,
                        destroy: true,
                        
                        scrollX: true,
                        columnDefs: [{
        					targets: [8,14,15,16,17,18],
        					orderable: false
        					}],    

        					
        initComplete: function () {
			this.api().columns([8,14,15,16,17,18]).every(function () {
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
                    //USE as the set column aliment
                    table.columns.adjust(),
                    table.buttons().container()
                            .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
                }
            
                    
            });
        }
 ////////////////// ONLOAD ENDS //////////////       
        
 function viewTicket(id)
 {
 //alert(id)	
 var l = window.location;
 var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 var serviceUrl = base_url + "/UserActivity/gatherUserTicketDetails";
         
            $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'ticketid=' + id,

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
//              alert( ASSETCHECK)
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
	 document.getElementById("HideAssetdata").style.display = "none";
 });
 $('#close-btn').on("click", function () {
 	$("#modelview").modal("hide");
     $('a[role="tab"]').removeClass('active'); 
     $('a[role="tabpanel"]').removeClass('active show');
     $('#custom-tabs-four-home-tab').addClass('active');
     
     $('#custom-tabs-four-home').removeClass('active show');
     $('#custom-tabs-four-profile').removeClass('active show');
     $('#custom-tabs-four-home').addClass('active show');
	 document.getElementById("HideAssetdata").style.display = "none";
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
     var serviceUrl = base_url + "/UserActivity/getTicketActivityLog";
     
     $.ajax({
         url: serviceUrl,
         type: 'post',
        dataType: 'json',
         data: 'ticketid=' + ticketid,

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
             
             var CATEGORY=data[0]["CATEGORY"];
             var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
             var SUBCATEGORY2=data[0]["SUBCATEGORY2"];
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
//         	   alert(statusColor);
         	   var callOutColor="";
         	  if(statusColor=="New"){callOutColor="callout-info"}
       	   else if(statusColor=="Assigned" ){callOutColor="callout-warning"}
       	   else if(statusColor=="Re-Assigned" || statusColor=="Reopened"){callOutColor="callout-danger"}
        	  
       	  else if(statusColor=="Hold" || statusColor=="Waiting for Spare" ||  statusColor=="Pending With Vendor"  ||  statusColor=="Awaiting User Information"){callOutColor="callout-danger"}
         	  
       	   else if(statusColor=="Resolved"){callOutColor="callout-success"}
       	   else if(statusColor=="Closed"){callOutColor="callout-success"}
       	   else if(statusColor=="Rejected"){callOutColor="callout-danger"}
       	   else if(statusColor=="Update Rejected"){callOutColor="callout-danger"}
       	   else if(statusColor=="Pending"){callOutColor="callout-warning"}
       	   else if(statusColor=="Update Approved"){callOutColor="callout-success"}
       	else if(statusColor=="Work in Progress"){callOutColor="callout-warning"}
       	   
        	   
         	   
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
    $("#ticketclose-btn").attr("disabled", true);
//    alert("submit: "+idd);
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/TPActivity/closeTicketFromEveryPlace";
    
    $.ajax({
                url: serviceUrl,
                type: 'post',
                data: 'ticketid=' + idd
                + '&closereason=' + $("#closereason").val(),
                //+ '&athorrrr=' + $("#athorrrr").val(),
                success: function (data) {
                 // alert(data);
                    if (data === "success") {
                        swal({
                            title: "Successful!",
                            text: "Ticket Closed Successfully",
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
                    text: "Cant close if ticket is not Resolved",
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
function validateFormCloseTicket()
{
 
      var indexError = 0;
   
   if ($('#closereason').val() === '') {
     //   console.log('fill closereason');
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
//////////////////Re-Assign Ticket////////////////
function reassignTicket(id)
{
//	alert(id)
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/TPActivity/gatherTicketDetails";
	
 	$.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        async :false,
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
                var html =" <select class='form-control' tabindex='13' id='priorityupdateTDreassign' name='priorityupdateTDreassign' onchange='getSeverity(this.value)'>";
               html+='<option value="">--Please Select Priority--</option>';
                for (var i = 0; i < prioritydata.length; i++) {
                    html += '<option value="' +prioritydata[i]+ '">' + prioritydata[i]
                    + '</option>';
                }
                document.getElementById("priorityupdateTDreassign").innerHTML=html;
                $("#priorityupdateTDreassign").val(data[0]["PRIORITY"]);
            });
            $("#severityupdateTDreassign").val(data[0]["SEVERITY"]);
            /////////////////// GET SEVERITY DATA /////////////
//        	var l = window.location;
//         	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//         	var serviceUrl = base_url + "/Master/getSeverityName";
//            $.ajax({
//            	url :serviceUrl,
//                type : 'POST',
//                dataType: 'json',
//                data: 'companyname=' + encodeURIComponent(data[0]["T_COMPANY"]),
//            }).done(function(severitydata) {
//                var html =" <select class='form-control' tabindex='13' id='severityupdateTDreassign' name='severityupdateTDreassign' '>";
//                for (var i = 0; i < severitydata.length; i++) {
//                    html += '<option value="' +severitydata[i]+ '">' + severitydata[i]
//                    + '</option>';
//                }
//                document.getElementById("severityupdateTDreassign").innerHTML=html;
//                $("#severityupdateTDreassign").val(data[0]["SEVERITY"]);
//            });
        	var T_REQUESTER = data[0]["T_REQUESTER"];
            var T_COMPANY = data[0]["T_COMPANY"];
            var T_BRANCH = data[0]["T_BRANCH"];
            var T_DEPARTMENT = data[0]["T_DEPARTMENT"];
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
            var REQUEST_MODE = data[0]["REQUEST_MODE"];

            var TP_NAME = data[0]["TP_NAME"];
            var TP_COMPANY = data[0]["TP_COMPANY"];
            var TP_BRANCH = data[0]["TP_BRANCH"];
            var TP_DEPARTMENT = data[0]["TP_DEPARTMENT"];
            var TP_PHONE = data[0]["TP_PHONE"];
            var TP_MAIL = data[0]["TP_MAIL"];

            
			var T_SUBDEPARTMENT = data[0]["T_SUBDEPARTMENT"];
			var T_LOCATION = data[0]["T_LOCATION"];
			
			var TP_SUBDEPARTMENT = data[0]["TP_SUBDEPARTMENT"];
			var TP_LOCATION = data[0]["TP_LOCATION"];
			
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

            $("#nameupdateUDreassign").val(T_REQUESTER);
            $("#companyupdateUDreassign").val(T_COMPANY);
            $("#siteupdateUDreassign").val(T_BRANCH);
            $("#deptupdateUDreassign").val(T_DEPARTMENT);
            $("#phoneupdateUDreassign").val(T_PHONE);
            $("#emailupdateUDreassign").val(T_MAIL);
            $("#categoryupdateTDreassign").val(T_CATEGORY);
            $("#subcat1updateTDreassign").val(T_SUBCAT1);
            $("#subcat2updateTDreassign").val(T_SUBCAT2);
            $("#subjectupdateTDreassign").val(T_SUBJECT);
            $("#raisedateupdateTDreassign").val(T_DATE);
            $("#statusupdateTDreassign").val(STATUS);
            $("#ticketidupdateTDreassign").val(T_ID);
            $("#descriptionupdateTDreassign").val(T_DESC);
//            $("#priorityupdateTDreassign").val(PRIORITY);
            $("#RequestModeupdateTDreassign").val(REQUEST_MODE);


            
            
            
            
            
            

            
            ///////////////////     //GET CATEGOEY  START////////////////////
                 
                 

                 var l = window.location;
               	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
               	var serviceUrl = base_url + "/Master/getCategoryDetailsListForsubjecmaster";

                  $.ajax({
                      type: 'POST',
                      url: serviceUrl,
                      async :true,
                      dataType: 'json',
                    
                      data:'cname='+encodeURIComponent($("#companyupdateUDreassign").val()),
                      success: function(data2) {
//                          alert(data2)
                     	 var html = "  <option value=''> -- Please Select --</option>";
                                 for (var i = 0; i < data2.length; i++) {
                                     html += '<option value="' + data2[i] + '">' + data2[i]
                                             + '</option>';
                                 }
                                 document.getElementById("categoryupdateTDreassign").innerHTML = html;
                                 $("#categoryupdateTDreassign").val(T_CATEGORY);
                          }
                  
             });
                  
                  //sub cate 1
                  
                  var l = window.location;
              	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
              	var serviceUrl = base_url + "/Master/getSubCategory1Forsubjecmaster";

               $.ajax({
                   type: 'POST',
                   url: serviceUrl,
                   dataType: 'json',
                   async :false,
                   data:'company='+encodeURIComponent($("#companyupdateUDreassign").val())+'&category='+encodeURIComponent(T_CATEGORY),
                   success: function(data2) {
//                       alert(data2)
                  	 var html = "  <option value=''> -- Please Select --</option>";
                              for (var i = 0; i < data2.length; i++) {
                                  html += '<option value="' + data2[i] + '">' + data2[i]
                                          + '</option>';
                              }
                              document.getElementById("subcat1updateTDreassign").innerHTML = html;
                              $("#subcat1updateTDreassign").val(T_SUBCAT1);
                              
                              
                       }
              }); 

               //cub cat 2
               
               var l = window.location;
             	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
             	var serviceUrl = base_url + "/Master/getSubCategory2Forsubjecmaster";

             $.ajax({
                 type: 'POST',
                 url: serviceUrl,
                 async :false,
                 dataType: 'json',
                 data:'company='+encodeURIComponent($("#companyupdateUDreassign").val())+'&category='+encodeURIComponent(T_CATEGORY)+'&subcategory1='+encodeURIComponent(T_SUBCAT1),
                 success: function(data2) {
//                     alert(data2)
                	 var html = "  <option value=''> -- Please Select --</option>";
                            for (var i = 0; i < data2.length; i++) {
                                html += '<option value="' + data2[i] + '">' + data2[i]
                                        + '</option>';
                            }
                            document.getElementById("subcat2updateTDreassign").innerHTML = html;
                            $("#subcat2updateTDreassign").val(T_SUBCAT2);
                     }
             });       

            
        }
    });
 	

    
 	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getCategoryDetailsforuScop2";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data:'Categoryup='+encodeURIComponent($('#companyupdateUDreassign').val()),
    }).done(function (data) {
//    	alert(data)
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
function getSeverity(priority)
{
//	alert("gg"+$("#companyupdateUDassign").val())
//	alert(priority)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/TPActivity/getSeverityByPriority";
  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'html',
      data:{'priority':priority,'company':$("#companyupdateUDreassign").val()},
      success: function (data5) {

    	  $("#severityupdateTDreassign").val(data5);
//      	 document.getElementById("severity").innerHTML=data5;
      }
  })
}
//function ToggleHoldReason(value){
////  alert(value)
//if(value==="Hold"){
//  $('#TPHoldNotes').show();
//}else if(value==="Re-Assigned" || value===""){
//	
//  $('#TPHoldNotes').show();
//    // $('#holdnotes').val("");
//}
//}





////////////////ONCHANGE METHOD OF CATEGORIES 





function getUpdateSubCategory(category)
{
//////////GET  SUBCATEGORY 1 ////////////////
//alert(category)
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/getSubCategory1Forsubjecmaster";

$.ajax({
type: 'POST',
url: serviceUrl,
dataType: 'json',

data:'company='+encodeURIComponent($("#companyupdateUDreassign").val())+'&category='+encodeURIComponent(category),
success: function(data2) {
//alert(data2)
var html = "  <option value=''> -- Please Select --</option>";
for (var i = 0; i < data2.length; i++) {
    html += '<option value="' + data2[i] + '">' + data2[i]
            + '</option>';
}
document.getElementById("subcat1updateTDreassign").innerHTML = html;



}
}); 


}

function getUpdateSubCategroy2(subcategory1)
{
//////////GET PROBLEM SUBCATEGORY 2 ////////////////
//alert($("#categoryup").val())

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/getSubCategory2Forsubjecmaster";

$.ajax({
type: 'POST',
url: serviceUrl,
async :false,
dataType: 'json',
data:'company='+encodeURIComponent($("#companyupdateUDreassign").val())+'&category='+encodeURIComponent($("#categoryupdateTDreassign").val())+'&subcategory1='+encodeURIComponent(subcategory1),
success: function(data2) {
//alert(data2)
var html = "  <option value=''> -- Please Select --</option>";
 for (var i = 0; i < data2.length; i++) {
     html += '<option value="' + data2[i] + '">' + data2[i]
             + '</option>';
 }
 //alert(html);
 document.getElementById("subcat2updateTDreassign").innerHTML = html;

}
});       

}

function change_Assigntype(assignType){
	document.getElementById("Hideotherdata").style.display = "none";
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
		
		
		   var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/getGroupDetails";

         $.ajax({

             url: serviceUrl,
             type: 'POST',
             dataType: 'json',
             data:'compname='+encodeURIComponent($("#companyupdateUDreassign").val())	
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
	else{
		$('#enggDiv').hide();
		$('#groupDiv').hide();
	}
}

/////////Validate Re-Assign ticket

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
	        var errorMessage = "<span>Please Enter Aassign or Hold Reason<span>";
	    }
	    else if (fieldName === "categoryupdateTDreassign") {
	        var errorMessage = "<span>Please Select  Category <span>";
	    }
	    else if (fieldName === "subcat1updateTDreassign") {
	        var errorMessage = "<span>Please Select Sub Category 1<span>";
	    }
	    else if (fieldName === "subcat2updateTDreassign") {
	        var errorMessage = "<span>Please Select Sub Category 2<span>";
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

//
//focus out
$('#statusupdateENG').on('focusout', function () {

    var usertype = $('#statusupdateENG').val();
    if (usertype.trim() === "") {
        callToolTip231('statusupdateENG', 'show');
    }
    else {
        callToolTip231('statusupdateENG', 'hide');
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
$('#assignTo').on('focus', function () {
    callToolTip231('assignTo', 'destroy');
});
$('#enggcat').on('focus', function () {
    callToolTip231('enggcat', 'destroy');
});
$('#enggassign').on('focus', function () {
    callToolTip231('enggassign', 'destroy');
});
$('#holdnotes').on('focus', function () {
    callToolTip231('holdnotes', 'destroy');
});


$('#categoryupdateTDreassign').on('focus', function () {
    callToolTip231('categoryupdateTDreassign', 'destroy');
});

$('#subcat1updateTDreassign').on('focus', function () {
    callToolTip231('subcat1updateTDreassign', 'destroy');
});

$('#subcat2updateTDreassign').on('focus', function () {
    callToolTip231('subcat2updateTDreassign', 'destroy');
});

$('#priorityupdateTDreassign').on('focus', function () {
    callToolTip231('priorityupdateTDreassign', 'destroy');
});

$('#severityupdateTDreassign').on('focus', function () {
    callToolTip231('severityupdateTDreassign', 'destroy');
});
function validateForm998()
{
//    alert("in validateForm998");
 
      var indexError = 0;
   
      var indexError = 0;
      
      if ($('#statusupdateENG').val() === '') {
          console.log('fill statusupdateENG');
          callToolTip231('statusupdateENG', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
     if ($('#assignTo').val().trim() === '') {
//         console.log('fill enggcat');
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
     } else if ($('#assignTo').val().trim() === 'Group') {
  	   
  	   if ($('#engGroup').val().trim() === '') {
//  	        console.log('fill enggassign');
  	        callToolTip231('engGroup', 'show');

  	        if (indexError == 0) {

  	        }
  	        indexError = indexError + 1;
  	    }
     }
    
      if ( $('#holdnotes').val().trim() === '') {
//          alert("in Hold reason")
          console.log('fill holdnotes');
          callToolTip231('holdnotes', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
   
      if ( $('#categoryupdateTDreassign').val()=== '' || $('#categoryupdateTDreassign').val()===null) {
//          alert("in Hold reason")
          console.log('fill categoryupdateTDreassign');
          callToolTip231('categoryupdateTDreassign', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
      

      if ( $('#subcat1updateTDreassign').val()=== '' || $('#subcat1updateTDreassign').val()===null) {
//          alert("in Hold reason")
          console.log('fill subcat1updateTDreassign');
          callToolTip231('subcat1updateTDreassign', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
      

      if ( $('#subcat2updateTDreassign').val() === '' || $('#subcat2updateTDreassign').val()===null) {
//          alert("in Hold reason")
          console.log('fill subcat2updateTDreassign');
          callToolTip231('subcat2updateTDreassign', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
      

      if ( $('#priorityupdateTDreassign').val()== '' || $('#priorityupdateTDreassign').val()===null) {
//          alert("in Hold reason")
          console.log('fill priorityupdateTDreassign');
          callToolTip231('priorityupdateTDreassign', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
      
  //alert($('#severityupdateTDassign').val());
      if ( $('#severityupdateTDreassign').val()== '' || $('#severityupdateTDreassign').val()===null ) {
//          alert("in Hold reason")
          console.log('fill severityupdateTDreassign');
          callToolTip231('severityupdateTDreassign', 'show');

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
//    	alert(data)
    	data.sort()
        var html = " <select class='form-control' tabindex='7' id='enggassign' name='enggassign'>";
        html = html + '<option value="">--Please Select Engineer--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("enggassign").innerHTML = html;
    });
}        



$('#submit-btn').on("click", function () {
//   alert("in submit");
    if(!validateForm998())
    {
//        alert("in false")
        event.preventDefault();
    }
    else if ($("#severityupdateTDreassign").val()=='NotSet')
    	{
    		swal({
            title: "Error!",
            html: "Please Change Priority as Severity is Not Set",
            type: "error",
            width: 300,
            height: 200,
            buttons: false,
            allowOutsideClick: false,
           })	
    	}
    else if (validateForm998()){
    	$("#submit-btn").attr("disabled", true);
//    alert("in true")
    	
    	var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/TPActivity/InsertReAssignHoldTicket";	

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
           if(($("#statusupdateENG").val())== "Hold")
            {
                        swal({
                            title: "Successful!",
                            text: 'Ticket Status Changed to Hold Successfully', 
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
                    }
                    else  if(($("#statusupdateENG").val())== "Re-Assigned")
                    {
                       swal({
                            title: "Successful!",
                            text: "Ticket Re-Assigned Successfully",
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
                    }
                    }else if (data === "duplicate") {
                swal({
                    title: "Not Allowed",
                    text: "Cant close if ticket is not Resolved",
                    type: "error",
                    width: 300,
                    height: 200,
//                  showCancelButton: false,
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


    });
}
});


$('#modelreassign').on('hidden.bs.modal', function () {
	change_Assigntype("");
	
	$("#statusupdateENG").val("");
	$("#assignTo").val("");
	$("#status").val("");
	$("#holdnotes").val("");
	
	document.getElementById("Hideotherdata").style.display = "none";
	$("#statusupdateENG").val("");
	
	
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
//	alert(othercompany + "company");
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


function  characterCounter()
{
//	alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("holdnotes").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}


