window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/getEngAssignProblemTickets";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',

		success : function(data5) {
//alert(data5)
			$("#preLoader").hide();
        	$("#Listing_Copy").removeClass("d-none");
			var table = $('#Listing_Copy').DataTable({
				lengthChange : false,
				pageLength : 5,
				data : data5,
				destroy : true,
				"scrollX" : true,
				columnDefs: [{
					targets: [4,5,6,13,14,15],
					orderable: false
					}],

				initComplete: function () {
					this.api().columns([4,5,6,13,14,15]).every(function () {
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
			table.buttons().container().appendTo(
					'#Listing_Copy_wrapper .col-sm-6:eq(0)');
		}
	});
}

function updateProblemTicket(id) {
//alert(id)
//	callToolTip231('status', 'hide');
//	callToolTip231('solution', 'hide');

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/gatherProblemTicketDetails";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'ticketid=' + encodeURIComponent(id),
		// + '&cno=' + $("#cno").val(),

		success : function(data) {
//			alert(data[0]["PT_REQUESTER"]);
			
			var T_PROBLEM_CATEGORY = data[0]["T_PROBLEM_CATEGORY"];
			var T_PROBLEM_SUBCAT1 = data[0]["T_PROBLEM_SUBCAT1"];
			var T_PROBLEM_SUBCAT2 = data[0]["T_PROBLEM_SUBCAT2"];
			var PT_SUBJECT = data[0]["PT_SUBJECT"];
			var PT_DESC = data[0]["PT_DESC"];
			var PT_DATE = data[0]["PT_DATE"];
			var ENGINEER_ASSIGN_DATE = data[0]["ENGINEER_ASSIGN_DATE"];
			var TP_NAME = data[0]["TP_NAME"];
			var PT_ASSIGN_TO = data[0]["PT_ASSIGN_TO"];
			var ENGINEER_GROUP = data[0]["ENGINEER_GROUP"];
			var ENGINEER_NAME = data[0]["ENGINEER_NAME"];
			var PROBLEM_STATUS = data[0]["PROBLEM_STATUS"];
			var PT_ID = data[0]["PT_ID"];
			var PRIORITY = data[0]["PRIORITY"];
			var SEVERITY = data[0]["SEVERITY"];
			var REQUEST_MODE = data[0]["REQUEST_MODE"];
			var PROBLEM_STATUS = data[0]["PROBLEM_STATUS"];
		
			$("#tidRCA").val(PT_ID);
			$("#statusRCA").val(PROBLEM_STATUS);
			$("#raisedateRCA").val(PT_DATE);
			$("#assigndateRCA").val(ENGINEER_ASSIGN_DATE);
			$("#categoryRCA").val(T_PROBLEM_CATEGORY);
			$("#subcat1RCA").val(T_PROBLEM_SUBCAT1);
			$("#subcat2RCA").val(T_PROBLEM_SUBCAT2);
			$("#subRCA").val(PT_SUBJECT);
			$("#assignedByRCA").val(TP_NAME);
			$("#assignedToRCA").val(PT_ASSIGN_TO);
			if(PT_ASSIGN_TO==="Group")
			{
			$("#EngOrGroupRCA").val(ENGINEER_GROUP);
			}
			else if(PT_ASSIGN_TO==="Engineer")
			{
			$("#EngOrGroupRCA").val(ENGINEER_NAME);
			}
			
			$("#descriptionRCA").val(PT_DESC);
			$("#priorityRCA").val(PRIORITY);
			$("#SeverityRCA").val(SEVERITY);
			$("#RequestModeupdateTDAssignRCA").val(REQUEST_MODE);
	
			
			$("#causenotesRCA").val("");
		$('#modelupdate').modal("show");
		}
	});
}

$("#start_rca").click(function(){

					if (!validateForm()) {
						event.preventDefault();
					} else {
				    	$("#start_rca").attr("disabled", true);
						/////////////// CHECK FOR TICKET UPDATION CONFLICT ////////////
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"+ l.pathname.split('/')[1];
						var serviceUrl = base_url + "/EnggActivity/CheckProblemUpdateConflict";
						 $.ajax({
						        type: 'POST',
						        url: serviceUrl,
						        dataType: 'json',
						        data: 'ticketid=' + encodeURIComponent($('#tidRCA').val())
						         + '&statusChange=' + "Root Cause Analysis",

						        success: function (data) {
//						        	alert("STATUS: "+data[0]["STATUS"]);
//						        	alert("PREVIOUS_ENG_NAME: "+data[0]["PREVIOUS_ENG_NAME"]);
//						        	alert("RESOLVED_TICKET_STATUS: "+data[0]["RESOLVED_TICKET_STATUS"]);
//						        	alert("PREVIOUS_ENG_SOLUTION_RCA_DATE: "+data[0]["PREVIOUS_ENG_SOLUTION_RCA_DATE"]);
//						        	alert("PREVIOUS_ENG_SOLUTION_FIX_DATE: "+data[0]["PREVIOUS_ENG_SOLUTION_FIX_DATE"]);
//						        	alert("PREVIOUS_ENG_SOLUTION_RESOLVE_DATE: "+data[0]["PREVIOUS_ENG_SOLUTION_RESOLVE_DATE"]);
//						        	alert("TICKET_CLOSE_DATE: "+data[0]["TICKET_CLOSE_DATE"]);
						        	
						        	var finalDateToShow="";
						        	if(data[0]["TICKET_CLOSE_DATE"]===null || data[0]["TICKET_CLOSE_DATE"]===undefined){
						        		finalDateToShow=data[0]["PREVIOUS_ENG_SOLUTION_RESOLVE_DATE"];
						        		
						        	}
						        	if(data[0]["PREVIOUS_ENG_SOLUTION_RESOLVE_DATE"]===null || data[0]["PREVIOUS_ENG_SOLUTION_RESOLVE_DATE"]===undefined){
						        		finalDateToShow=data[0]["PREVIOUS_ENG_SOLUTION_FIX_DATE"];
						        		
						        	}
						        	if(data[0]["PREVIOUS_ENG_SOLUTION_FIX_DATE"]===null || data[0]["PREVIOUS_ENG_SOLUTION_FIX_DATE"]===undefined){
						        		finalDateToShow=data[0]["PREVIOUS_ENG_SOLUTION_RCA_DATE"];
						        	}
//						        	alert("FINAL DATE: "+finalDateToShow)
						        	if(data[0]["STATUS"]==="Fail")
						        	{
						        		swal({
											title : 'Updated Record Found!',
											html : '<label><table class="table table-bordered"><tr><td>Engineer Name</td><td>'+data[0]["PREVIOUS_ENG_NAME"]+'</td></tr><tr><td>Ticket Status</td><td>'+data[0]["RESOLVED_TICKET_STATUS"]+'</td></tr><tr><td>Timestamp</td><td>'+finalDateToShow+'</td></tr></table></label><label>No Action Needed</label>',
											type : 'warning',
											width : 450,
											showCancelButton: false,
											confirmButtonText: "OK",
									        buttons: false,
									        allowOutsideClick: false,
									        preConfirm : function() {
												location.reload();
											}
										})
						        	}
						        	else if(data[0]["STATUS"]==="Pass")
						        	{
						        		UpdateRCAProblemTicket();
						        	}

						        }
						 });
						
					}

				});

function validateForm() {

	var indexError = 0;
	
	if ($('#causenotesRCA').val() === '') {
		//////console.log('inside solution');
		callToolTip231('causenotesRCA', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	//////console.log("validation error count::::" + indexError);
	if (indexError > 0) {

		return false;

	} else {

		// $('#spinner2').show();

		return true;
	}

}

function UpdateRCAProblemTicket(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/"+ l.pathname.split('/')[1];
	var serviceUrl = base_url+ "/EnggActivity/UpdateRCAProblemTicket";
	
	 var form=$('form')[0];
	 var formData= new FormData(form);
	 
	$.ajax(
			{
				 url: serviceUrl,
			        type: 'post',
			        data: formData,
			        mimeType: "multipart/form-data",
			        contentType: false,
			        processData: false,
			        cache: false,

			}).done(function(data) {
//				alert(data)
		if (data == "success") {
			swal({
					title : 'Successful!',
					html : 'Problem Ticket Updated Successfully',
					type : 'success',
					width : 300,
//					 showCancelButton: false,
//			       confirmButtonClass: "btn btn-danger",
//			       cancelButtonClass: "btn btn-danger m-l-10",
//			       confirmButtonText: "OK",
			         buttons: false,
			         allowOutsideClick: false,
					preConfirm : function() {
						location.reload();
					}
				});
		} else {
			swal({
				title : 'Unsuccessful!',
				html : 'Failed to Change Problem Ticket Status',
				type : 'error',
				width : 300,
//				 showCancelButton: false,
//		       confirmButtonClass: "btn btn-danger",
//		       cancelButtonClass: "btn btn-danger m-l-10",
//		       confirmButtonText: "OK",
		         buttons: false,
		         allowOutsideClick: false,
				preConfirm : function() {
					location.reload();
				}
			});
		}
	});
}

// focus out
$('#causenotesRCA').on('focusout', function() {

	var usertype = $('#causenotesRCA').val();
	if (usertype.trim() == "") {
		callToolTip231('causenotesRCA', 'show');
	} else {
		callToolTip231('causenotesRCA', 'hide');
	}
});


$('#causenotesRCA').on('focus', function() {
	callToolTip231('causenotesRCA', 'destroy');
});

var callToolTip231 = function(fieldName, status) {
	if (fieldName == "causenotesRCA") {
		var errorMessage = "<span>Please Enter Cause Notes<span>";
	}

	$("#" + fieldName).tooltip({
		trigger : 'manual',
		placement : 'top',
		title : errorMessage,
		animation : true,
		delay : 1000,
		html : true
	});
	if (status == "show") {
		$("#" + fieldName).tooltip('show');
	} else {
		$("#" + fieldName).tooltip('hide');
	}
}

function downFile() {
	var filename = $('#filename').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}
function downFileSecondary() {
	var filename = $('#filenamesecondary').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}

function downFileActivityLog(att) {
//	alert(att)
//		var filename = $('#filename').val();
		var filename =att;
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location = base_url + "/Master/DownloadFile?filename=" + filename;
	}

function ViewProblemTicket(id) {
//alert(id)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/gatherProblemTicketDetails";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'ticketid=' + encodeURIComponent(id),
		// + '&cno=' + $("#cno").val(),

		success : function(data) {
//			alert(data[0]["PT_REQUESTER"]);

//////////////COMMON PARAMETERS/////////
			var PT_REQUESTER = data[0]["PT_REQUESTER"];
			var PT_COMPANY = data[0]["PT_COMPANY"];
			var PT_BRANCH = data[0]["PT_BRANCH"];
			var PT_PHONE = data[0]["PT_PHONE"];
			var PT_MAIL = data[0]["PT_MAIL"];
			var PT_DEPARTMENT = data[0]["PT_DEPARTMENT"];
			var T_PROBLEM_CATEGORY = data[0]["T_PROBLEM_CATEGORY"];
			var T_PROBLEM_SUBCAT1 = data[0]["T_PROBLEM_SUBCAT1"];
			var T_PROBLEM_SUBCAT2 = data[0]["T_PROBLEM_SUBCAT2"];
			var PT_SUBJECT = data[0]["PT_SUBJECT"];
			var PT_DESC = data[0]["PT_DESC"];
			var ENGINEER_ASSIGN_DATE = data[0]["ENGINEER_ASSIGN_DATE"];
			var PT_DATE = data[0]["PT_DATE"];
			var PROBLEM_STATUS = data[0]["PROBLEM_STATUS"];
			var PT_ID = data[0]["PT_ID"];
			var PRIORITY = data[0]["PRIORITY"];
			var SEVERITY = data[0]["SEVERITY"];
			var REQUEST_MODE = data[0]["REQUEST_MODE"];
			var PT_ATTACH_NAME = data[0]["PT_ATTACH_NAME"];
			   var SUB_DEPARTMENT=data[0]["Sub_Dept"];
	  			var LOCATION=data[0]["Location"];
	  		//	alert(LOCATION+"dfgg"+)
	              	
	  			$("#Sub-Department").val(SUB_DEPARTMENT);
				$("#location").val(LOCATION);
			
  //alert("SEVERITY"+SEVERITY)
			$("#nameupdateUD").val(PT_REQUESTER);
			$("#companyupdateUD").val(PT_COMPANY);
			$("#siteupdateUD").val(PT_BRANCH);
			$("#phoneupdateUD").val(PT_PHONE);
			$("#emailupdateUD").val(PT_MAIL);
			$("#departmentupdateUD").val(PT_DEPARTMENT);
			$("#problemcategoryupdateTD").val(T_PROBLEM_CATEGORY);
			$("#problemsubcat1").val(T_PROBLEM_SUBCAT1);
			$("#problemsubcat2").val(T_PROBLEM_SUBCAT2);
			$("#subjectupdateTD").val(PT_SUBJECT);
			$("#descriptionupdateTD").val(PT_DESC);
			$("#raisedateupdateTD").val(PT_DATE);
			$("#assigndateupdateTD").val(ENGINEER_ASSIGN_DATE);
			$("#statusupdateTD").val(PROBLEM_STATUS);
			$("#problemticketidupdateTD").val(PT_ID);
			$("#priorityupdateTD").val(PRIORITY);
			$("#SeverityupdateTD").val(SEVERITY);
			$("#RequestModeupdateTD").val(REQUEST_MODE);

			if ((PT_ATTACH_NAME === ("No File Available"))
					|| (PT_ATTACH_NAME === ("NA"))
					|| (PT_ATTACH_NAME === ("null"))
					|| (PT_ATTACH_NAME === ("undefined"))
					|| (PT_ATTACH_NAME === (""))) {
				$('#hidedownload').hide();
				$('#nofileattach').show();
			} else {
				$('#hidedownload').show();
				$('#nofileattach').hide();
				document.getElementById('empPic').innerHTML = PT_ATTACH_NAME;
				document.getElementById('filename').value = PT_ATTACH_NAME;
			}
			
///////////// FOR INCIDENTS /////////
			var INCIDENTS_ATTACHED=data[0]["INCIDENTS_ATTACHED"];
			if(INCIDENTS_ATTACHED.length>0)
				{
				$('#IncidentsAttachedDiv').show();
				$('#NoIncidentsAttachedDiv').hide();
				for(var i=0;i<INCIDENTS_ATTACHED.length;i++)
					{
					$('#Listing_Copy_Incidents').DataTable().clear();
					var table = $('#Listing_Copy_Incidents').DataTable({
//				    	dom:"<'row'<'col-sm-3'B><'col-sm-9'f>>rtip", 
				    	lengthChange: false,
				        pageLength: 5,
				        destroy: true,
				        scrollX: true,
					});
					$('#Listing_Copy_Incidents').DataTable().rows.add(INCIDENTS_ATTACHED).draw();
	
					}
				}else{
					$('#IncidentsAttachedDiv').hide();
					$('#NoIncidentsAttachedDiv').show();
				}
/////////////////////////////////////

		}
	});
	$("#modelviewPrimary").modal("show");

}

$('#close-btn-primary').click(function() {

	$('#modelviewPrimary').modal("hide");
})


function viewTicket(id)
{
	event.preventDefault();
//	alert(id)

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl1 = base_url + "/UserActivity/gatherUserTicketDetails";
        
           $.ajax({
        type: 'POST',
        url: serviceUrl1,
        dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(id),
//                + '&cno=' + $("#cno").val(),

        success: function (data) {
//           alert(data[0]["REQUEST_MODE"])
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
//           alert("T_ATTACH1_NAME: "+T_ATTACH_NAME);
           
             $("#nameupdateUDsecondary").val(T_REQUESTER);
             $("#companyupdateUDsecondary").val(T_COMPANY);
             $("#siteupdateUDsecondary").val(T_BRANCH);
             $("#deptupdateUDsecondary").val(DEPARTMENT);
             $("#subdeptupdateUDsecondary").val(SUB_DEPARTMENT);
             $("#locationupdateUDsecondary").val(LOCATION);
             $("#phoneupdateUDsecondary").val(T_PHONE);
             $("#emailupdateUDsecondary").val(T_MAIL);
             $("#categoryupdateTDsecondary").val(T_CATEGORY);
             $("#subcat1updateTDsecondary").val(T_SUBCAT1);
             $("#subcat2updateTDsecondary").val(T_SUBCAT2);
             $("#subjectupdateTDsecondary").val(T_SUBJECT);
             $("#raisedateupdateTDsecondary").val(T_DATE);
             $("#statusupdateTDsecondary").val(STATUS);
             $("#ticketidupdateTDsecondary").val(T_ID);
             $("#descriptionupdateTDsecondary").val(T_DESC);
             $("#priorityupdateTDsecondary").val(PRIORITY);
             $("#SeverityupdateTDsecondary").val(SEVERITY);
             $("#RequestModeupdateTDsecondary").val(REQUEST_MODE);
             
 if((T_ATTACH_NAME=== ("No File Available"))||(T_ATTACH_NAME===("NA"))||(T_ATTACH_NAME===("null"))||(T_ATTACH_NAME===("undefined"))||(T_ATTACH_NAME===("")))
        {
           $('#hidedownloadsecondary').hide();
           $('#nofileattachsecondary').show();
        }else
        {
            $('#hidedownloadsecondary').show();
              $('#nofileattachsecondary').hide();
          document.getElementById('empPicsecondary').innerHTML=T_ATTACH_NAME;  
          document.getElementById('filenamesecondary').value=T_ATTACH_NAME;  
        }
       
         }
     });
             $("#modelviewSecondary").modal("show");
}
$('#modelviewSecondary').on('hidden.bs.modal', function () {
	$('a[role="tab-two"]').removeClass('active'); 
    $('a[role="tabpanel-two"]').removeClass('active show');
    $('#custom-tabs-two-activity-tab').removeClass('active');
    $('#custom-tabs-two-general-tab').addClass('active');
    
    $('#custom-tabs-two-general').removeClass('active show');
    $('#custom-tabs-two-activity').removeClass('active show');
    $('#custom-tabs-two-general').addClass('active show');
});

$('#close-btn-secondary').click(function() {

	$('#modelviewSecondary').modal("hide");
	$('a[role="tab-two"]').removeClass('active'); 
    $('a[role="tabpanel-two"]').removeClass('active show');
    $('#custom-tabs-two-activity-tab').removeClass('active');
    $('#custom-tabs-two-general-tab').addClass('active');
    
    $('#custom-tabs-two-general').removeClass('active show');
    $('#custom-tabs-two-activity').removeClass('active show');
    $('#custom-tabs-two-general').addClass('active show');
})

//////////////////// GET ACTIVITY LOG ////////////////
$('a[role="tab-two"]').on('shown.bs.tab', function (e) {
	  var target = $(e.target).attr("id") // activated tab
	  if(target==="custom-tabs-two-activity-tab"){
		  ticketid= $("#ticketidupdateTDsecondary").val();
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
            var ROLE_TYPE = data[0]["ROLE_TYPE"];
            var SEVERITY = data[0]["SEVERITY"];
            var CATEGORY=data[0]["CATEGORY"];
            var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
            var SUBCATEGORY2=data[0]["SUBCATEGORY2"];
            var EMAIL=data[0]["FULLNAME"];
            var FULLNAME=data[0]["EMAIL"];
            

           document.getElementById('T_IDsecondary').innerHTML=T_ID;
          
           
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
           	  
           	   else if(statusColor=="Hold"){callOutColor="callout-danger"}
           	   else if(statusColor=="Resolved"||statusColor=="Update Approved"){callOutColor="callout-success"}
           	   else if(statusColor=="Closed"){callOutColor="callout-success"}
           	   else if(statusColor=="Rejected"){callOutColor="callout-danger"}
           	   else if(statusColor=="Update Rejected"){callOutColor="callout-danger"}
        	   
        	   
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
        	   
              document.getElementById("MSG1234secondary").innerHTML=html;
        	   }
           html=+ '<br>';
            }
          
            
    });
	  }
	});
$('#modelviewPrimary').on('shown.bs.modal ', function (e) {
    $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
});

function  characterCounter()
{
//	alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("causenotesRCA").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}


