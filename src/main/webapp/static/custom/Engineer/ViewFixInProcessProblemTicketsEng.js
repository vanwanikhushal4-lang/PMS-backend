window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/getEngFixInProcessProblemTickets";
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
								targets: [4,5,6,11,12,13,14,15],
								orderable: false
								}],

							initComplete: function () {
								this.api().columns([4,5,6,11,12,13,14,15]).every(function () {
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
			var ENGINEER_NAME = data[0]["ENGINEER_NAME"];
			var PROBLEM_STATUS = data[0]["PROBLEM_STATUS"];
			var PT_ID = data[0]["PT_ID"];
			var PRIORITY = data[0]["PRIORITY"];
			var SEVERITY = data[0]["SEVERITY"];
			var REQUEST_MODE = data[0]["REQUEST_MODE"];
			var ENGINEER_RCA_DATE = data[0]["ENGINEER_RCA_DATE"];
			var CAUSE_NOTES = data[0]["CAUSE_NOTES"];
			var FIX_NOTES = data[0]["FIX_NOTES"];
			var WORKAROUND_NOTES = data[0]["WORKAROUND"];
			var PROBLEM_STATUS = data[0]["PROBLEM_STATUS"];
		
			$("#tidRCA").val(PT_ID);
			$("#raisedateRCA").val(PT_DATE);
			$("#assigndateRCA").val(ENGINEER_ASSIGN_DATE);
			$("#categoryRCA").val(T_PROBLEM_CATEGORY);
			$("#subcat1RCA").val(T_PROBLEM_SUBCAT1);
			$("#subcat2RCA").val(T_PROBLEM_SUBCAT2);
			$("#subRCA").val(PT_SUBJECT);
			$("#assignedToRCA").val(ENGINEER_NAME);
			$("#descriptionRCA").val(PT_DESC);
			$("#priorityRCA").val(PRIORITY);
			$("#SeverityRCA").val(SEVERITY);
			$("#RequestModeupdateTDAssignRCA").val(REQUEST_MODE);
			$("#rcadateRCA").val(ENGINEER_RCA_DATE);
			$("#causenotesRCA").val(CAUSE_NOTES);
			$("#fixnotesRCA").val(FIX_NOTES);
			$("#workaroundnotesRCA").val(WORKAROUND_NOTES);
			$("#statusRCA").val(PROBLEM_STATUS);
	
			$("#resolvenotesRCA").val("");
		$('#modelupdate').modal("show");
		}
	});
}

$("#resolve").click(function(){

					if (!validateForm()) {
						event.preventDefault();
					} else {
						$("#resolve").attr("disabled", true);
						/////////////// CHECK FOR TICKET UPDATION CONFLICT ////////////
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"+ l.pathname.split('/')[1];
						var serviceUrl = base_url + "/EnggActivity/CheckProblemUpdateConflict";
						 $.ajax({
						        type: 'POST',
						        url: serviceUrl,
						        dataType: 'json',
						        data: 'ticketid=' + encodeURIComponent($('#tidRCA').val())
						         + '&statusChange=' + "Resolved",

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
						        	else if(data[0]["STATUS"]==="Warning")
						        	{
						        		swal({
											title : 'Previous Record Found!',
											html : '<label><table class="table table-bordered"><tr><td>Engineer Name</td><td>'+data[0]["PREVIOUS_ENG_NAME"]+'</td></tr><tr><td>Ticket Status</td><td>'+data[0]["RESOLVED_TICKET_STATUS"]+'</td></tr><tr><td>Timestamp</td><td>'+finalDateToShow+'</td></tr></table></label><label>Do you want to continue & update the problem ticket status?</label>',
											type : 'warning',
											width : 450,
											showCancelButton: true,
											confirmButtonText: "Continue",
									        buttons: false,
									        allowOutsideClick: false,
										}).then((isConfirm) => {
									        if (isConfirm) {
									        	UpdateResolveProblemTicket();
				
									        }
									    });
						        		
						        	}
						        	else if(data[0]["STATUS"]==="Pass")
						        	{
						        		UpdateResolveProblemTicket();				        		
						        	}

						        }
						 });
					}

				});

function UpdateResolveProblemTicket(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/"+ l.pathname.split('/')[1];
	var serviceUrl = base_url+ "/EnggActivity/UpdateResolveProblemTicket";
	
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

function validateForm() {

	var indexError = 0;
	
	if ($('#causenotesRCA').val() === '') {
		//console.log('inside solution');
		callToolTip231('causenotesRCA', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#fixnotesRCA').val() === '') {
		//console.log('inside solution');
		callToolTip231('fixnotesRCA', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#resolvenotesRCA').val() === '') {
		//console.log('inside solution');
		callToolTip231('resolvenotesRCA', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	//console.log("validation error count::::" + indexError);
	if (indexError > 0) {

		return false;

	} else {

		// $('#spinner2').show();

		return true;
	}

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

$('#fixnotesRCA').on('focusout', function() {

	var usertype = $('#fixnotesRCA').val();
	if (usertype.trim() == "") {
		callToolTip231('fixnotesRCA', 'show');
	} else {
		callToolTip231('fixnotesRCA', 'hide');
	}
});

$('#resolvenotesRCA').on('focusout', function() {

	var usertype = $('#resolvenotesRCA').val();
	if (usertype.trim() == "") {
		callToolTip231('resolvenotesRCA', 'show');
	} else {
		callToolTip231('resolvenotesRCA', 'hide');
	}
});


$('#causenotesRCA').on('focus', function() {
	callToolTip231('causenotesRCA', 'destroy');
});
$('#fixnotesRCA').on('focus', function() {
	callToolTip231('fixnotesRCA', 'destroy');
});
$('#resolvenotesRCA').on('focus', function() {
	callToolTip231('resolvenotesRCA', 'destroy');
});

var callToolTip231 = function(fieldName, status) {
	if (fieldName == "causenotesRCA") {
		var errorMessage = "<span>Please Enter Cause Notes<span>";
	}
	else if(fieldName == "fixnotesRCA"){
		var errorMessage = "<span>Please Enter Fix Notes<span>";
	}
	else if(fieldName == "resolvenotesRCA"){
		var errorMessage = "<span>Please Enter Resolution Notes<span>";
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
	var filename = $('#filename_secondary').val();
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
//			alert(data[0]["ENGINEER_ASSIGN_DATE"]);

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
			var PT_DATE = data[0]["PT_DATE"];
			var PROBLEM_STATUS = data[0]["PROBLEM_STATUS"];
			var PT_ID = data[0]["PT_ID"];
			var PRIORITY = data[0]["PRIORITY"];
			var SEVERITY = data[0]["SEVERITY"];
			var REQUEST_MODE = data[0]["REQUEST_MODE"];
			var PT_ATTACH_NAME = data[0]["PT_ATTACH_NAME"];
			var PT_DATE = data[0]["PT_DATE"];
			var ENGINEER_ASSIGN_DATE = data[0]["ENGINEER_ASSIGN_DATE"];
			var ENGINEER_RCA_DATE = data[0]["ENGINEER_RCA_DATE"];
			var ENGINEER_FIXINPROCESS_DATE = data[0]["ENGINEER_FIXINPROCESS_DATE"];
			var Sub_Dept=data[0]["Sub_Dept"];
			var Location=data[0]["Location"];
			$("#Sub-Department").val(Sub_Dept);
			$("#location").val(Location);
			
				

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
			$("#statusupdateTD").val(PROBLEM_STATUS);
			$("#problemticketidupdateTD").val(PT_ID);
			$("#priorityupdateTD").val(PRIORITY);
			//alert("SEVERITY" +SEVERITY);
			$("#SeverityupdateTD1").val(SEVERITY);
			$("#RequestModeupdateTD").val(REQUEST_MODE);
			$("#assigndateupdateTD").val(ENGINEER_ASSIGN_DATE);
			$("#rcadateupdateTD").val(ENGINEER_RCA_DATE);
			$("#fixinprocessdateupdateTD").val(ENGINEER_FIXINPROCESS_DATE);

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
            var T_REQUESTER_S = data[0]["T_REQUESTER"];
            var T_COMPANY_S = data[0]["T_COMPANY"];
            var T_BRANCH_S = data[0]["T_BRANCH"];
            var T_PHONE_S = data[0]["T_PHONE"];
            var T_MAIL_S = data[0]["T_MAIL"];
            var T_CATEGORY_S = data[0]["T_CATEGORY"];
           // var T_SUBCAT_S = data[0]["T_SUBCAT"];
            var T_SUBJECT_S = data[0]["T_SUBJECT"];
            var T_DATE_S = data[0]["T_DATE"];
            var STATUS_S = data[0]["STATUS"];
            var T_ID_S = data[0]["T_ID"];
            var T_DESC_S = data[0]["T_DESC"];
            var PRIORITY_S = data[0]["PRIORITY"];
            var SEVERITY_s = data[0]["SEVERITY"];
            var REQUEST_MODE_S = data[0]["REQUEST_MODE"];
             var T_ATTACH1_NAME_S = data[0]["T_ATTACH1_NAME"];
//          alert("T_ATTACH1_NAME: "+T_ATTACH1_NAME);
             
             var T_SUBCAT_S = data[0]["T_SUBCAT1"];
             var REQUESTMODE=data[0]["REQUESTMODE"];
             var T_SUBCAT2=data[0]["T_SUBCAT2"];
             
             

             $("#nameupdateUD_secondary").val(T_REQUESTER_S);
            $("#companyupdateUD_secondary").val(T_COMPANY_S);
            $("#siteupdateUD_secondary").val(T_BRANCH_S);
            $("#phoneupdateUD_secondary").val(T_PHONE_S);
            $("#emailupdateUD_secondary").val(T_MAIL_S);
            $("#categoryupdateTD_secondary").val(T_CATEGORY_S);
            $("#groupupdateTD_secondary").val(T_SUBCAT_S);
            $("#subjectupdateTD_secondary").val(T_SUBJECT_S);
            $("#raisedateupdateTD_secondary").val(T_DATE_S);
            $("#statusupdateTD_secondary").val(STATUS_S);
            $("#ticketidupdateTD_secondary").val(T_ID_S);
            $("#descriptionupdateTD_secondary").val(T_DESC_S);
            $("#priorityupdateTD_secondary").val(PRIORITY_S);
            $("#SeverityupdateTD_secondary").val(SEVERITY_s);
            $("#RequestModeupdateTD_secondary").val(REQUEST_MODE_S);
            
            
            $("#subcat2").val(T_SUBCAT2);
            $("#requestmode").val(REQUESTMODE);
            
            
if((T_ATTACH1_NAME_S=== ("No File Available"))||(T_ATTACH1_NAME_S===("NA"))||(T_ATTACH1_NAME_S===("null"))||(T_ATTACH1_NAME_S===("undefined"))||(T_ATTACH1_NAME_S===("")))
       {
          $('#hidedownload_secondary').hide();
          $('#nofileattach_secondary').show();
       }else
       {
           $('#hidedownload_secondary').show();
             $('#nofileattach_secondary').hide();
         document.getElementById('empPic_secondary').innerHTML=T_ATTACH1_NAME_S;
    document.getElementById('filename_secondary').value=T_ATTACH1_NAME_S;  
       }
      
        }
    });
//           alert("before modal")
             $("#modelviewSecondary").modal("show");
}
$('#close-btn-secondary').click(function() {

	$('#modelviewSecondary').modal("hide");
})

$('#modelviewPrimary').on('shown.bs.modal ', function (e) {
    $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
});

function  characterCounter()
{
//	alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("resolvenotesRCA").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}

