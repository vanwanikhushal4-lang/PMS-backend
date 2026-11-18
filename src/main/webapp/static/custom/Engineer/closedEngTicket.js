window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/getClosedTickets";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',

		success : function(data5) {

			var table = $('#Listing_Copy').DataTable({
				lengthChange : false,
				pageLength : 5,
				data : data5,
				destroy : true,
				"scrollX" : "true",

			});
			table.buttons().container().appendTo(
					'#Listing_Copy_wrapper .col-sm-6:eq(0)');
		}
	});
}

function ViewTicket(id) {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/gatherUserTicketDetails";

	$
			.ajax({
				type : 'POST',
				url : serviceUrl,
				dataType : 'json',
				data : 'ticketid=' + id,
				// + '&cno=' + $("#cno").val(),

				success : function(data) {

					var T_REQUESTER = data[0]["T_REQUESTER"];
					var T_COMPANY = data[0]["T_COMPANY"];
					var T_BRANCH = data[0]["T_BRANCH"];
					var T_PHONE = data[0]["T_PHONE"];
					var T_MAIL = data[0]["T_MAIL"];
					var T_CATEGORY = data[0]["T_CATEGORY"];
					var T_SUBCAT = data[0]["T_SUBCAT"];
					var T_SUBJECT = data[0]["T_SUBJECT"];
					var T_DATE = data[0]["T_DATE"];
					var STATUS = data[0]["STATUS"];
					var T_ID = data[0]["T_ID"];
					var T_DESC = data[0]["T_DESC"];
					var PRIORITY = data[0]["PRIORITY"];
					var REQUEST_MODE = data[0]["REQUEST_MODE"];
					var T_ATTACH1_NAME = data[0]["T_ATTACH1_NAME"];
					var T_RAISE_TIME = data[0]["T_RAISE_TIME"];
					// alert("T_ATTACH1_NAME: "+T_ATTACH1_NAME);
					var ENGINEER_NAME = data[0]["ENGINEER_NAME"];
					var T_STATUS = data[0]["T_STATUS"];
					var SOLUTION = data[0]["SOLUTION"];
					var ENGINEER_ASSIGN_DATE = data[0]["ENGINEER_ASSIGN_DATE"];
					var RESOLVED_DATE = data[0]["RESOLVED_DATE"];
					// close info
					var T_ATTACH2_NAME = data[0]["T_ATTACH2_NAME"];
					var T_CLOSEBY = data[0]["T_CLOSEBY"];
					var T_CLOSEDATE = data[0]["T_CLOSEDATE"];
					// close info
					// Data from Resolved table//
					var A_ENGINEER_NAME_RESOLVED = data[0]["A_ENGINEER_NAME"];
					var T_STATUS_RESOLVED = data[0]["T_STATUS"];
					var SOLUTION_RESOLVED = data[0]["SOLUTION"];
					var RESOLVED_DATE_RESOLVED = data[0]["RESOLVED_DATE"];
					var CLOSEDBY_RESOLVED = data[0]["CLOSEDBY"];
					var CLOSED_DATE_RESOLVED = data[0]["CLOSED_DATE"];
					// Data from Resolved table//

					// Data from Assigned table//
					var ENGINEER_NAME_ASSIGNED = data[0]["ENGINEER_NAME"];
					var ENGINEER_ASSIGN_DATE_ASSIGNED = data[0]["ENGINEER_ASSIGN_DATE"];
					var ENGINEER_ASSIGN_STATUS_ASSIGNED = data[0]["ENGINEER_ASSIGN_STATUS"];
					// Data from Assigned table//

					if (A_ENGINEER_NAME_RESOLVED === ENGINEER_NAME_ASSIGNED) {
						// alert("in match")
						$("#resolvedlabel").show();
						$("#assignedlabel").hide();
						$("#statusdateENG").val(RESOLVED_DATE_RESOLVED);
						$("#engnameED").val(A_ENGINEER_NAME_RESOLVED);
						$("#engticketstatusED").val(T_STATUS_RESOLVED);
						$("#engnotesED").val(SOLUTION_RESOLVED);

					} else if (A_ENGINEER_NAME_RESOLVED !== ENGINEER_NAME_ASSIGNED) {
						// alert("Not match")
						$("#resolvedlabel").hide();
						$("#assignedlabel").show();
						$("#statusdateENG").val(ENGINEER_ASSIGN_DATE_ASSIGNED);
						$("#engnameED").val(ENGINEER_NAME_ASSIGNED);
						$("#engticketstatusED").val(
								ENGINEER_ASSIGN_STATUS_ASSIGNED);
						$("#engnotesED").val("NA");
					}

					$("#nameupdateUD").val(T_REQUESTER);
					$("#companyupdateUD").val(T_COMPANY);
					$("#siteupdateUD").val(T_BRANCH);
					$("#phoneupdateUD").val(T_PHONE);
					$("#emailupdateUD").val(T_MAIL);
					$("#categoryupdateTD").val(T_CATEGORY);
					$("#groupupdateTD").val(T_SUBCAT);
					$("#subjectupdateTD").val(T_SUBJECT);
					$("#raisedateupdateTD").val(T_DATE);
					$("#statusupdateTD").val(STATUS);
					$("#ticketidupdateTD").val(T_ID);
					$("#descriptionupdateTD").val(T_DESC);
					$("#priorityupdateTD").val(PRIORITY);
					$("#RequestModeupdateTD").val(REQUEST_MODE);

					// close info
					$("#closenotes").val(T_ATTACH2_NAME);
					$("#closename").val(T_CLOSEBY);
					$("#closedate").val(T_CLOSEDATE);

					// close info

					if ((T_ATTACH1_NAME === ("No File Available"))
							|| (T_ATTACH1_NAME === ("NA"))
							|| (T_ATTACH1_NAME === ("null"))
							|| (T_ATTACH1_NAME === ("undefined"))
							|| (T_ATTACH1_NAME === (""))) {
						$('#hidedownload').hide();
						$('#nofileattach').show();
					} else {
						$('#hidedownload').show();
						$('#nofileattach').hide();
						document.getElementById('empPic').innerHTML = T_ATTACH1_NAME;
						document.getElementById('filename').value = T_ATTACH1_NAME;
					}

				}
			});
	$("#modelview").modal("show");
}
function downFile() {
	var filename = $('#filename').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}

$('#close-btn').click(function() {

	$('#modelview').modal("hide");
})