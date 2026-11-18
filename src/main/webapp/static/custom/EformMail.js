window.onload = function() {
	$("#stForRequest").show();
	$("#stForRelease").hide();
	$("#stForTransfer").hide();
	// alert("dsd")
	var footerSyntax = "<br><br> <span style='color:#1f497d; font-weight:100'>3i Global Command Center &#8212 IT Service Desk</span><br><span style='color:#1f497d; font-weight:100'>Hotline: 080-69130755 / 044-61022080 ll E-mail: <a href='service.desk@3i-infotech.com'>service.desk@3i-infotech.com</a></span><br><br><span style='color:#1f497d; font-weight:100'>Do you know that you can reset your own email/NT ID password?</span><br><span style='color:#1f497d; font-weight:100'>Follow the instructions <a href='https://proxyweb.3i-infotech.com/MailRegistration.html'>here!</a></span><br><br><span style='color:#1f497d; font-weight:100'>Have you tried our Self-Service Portal for raising IT ticket?</span><br><span style='color:#1f497d; font-weight:100'>Check it out <a href='https://ithelpdesk.3i-infotech.com/Helpdesk/'>here!</a></span>";
	// alert("ggggg");

	$("#footersyntax").val(footerSyntax);

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		async : false,
		success : function(data4) {
			// alert(data4)
			// var html = " <option value=''> -- Please Select --</option>"; for
			// (var i = 0; i < data4.length; i++) {
			// alert(data4[i]);
			// html += '<option value="' + data4[i] + '">' + data4[i]
			// + '</option>';
			// }
			//
			// document.getElementById("company").innerHTML = html;

		}
	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/AddEformMailListing";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {
			//alert(data4)
			var table = $('#Addeform').DataTable({
				lengthChange : false,
				data : data4,
				scrollX : true,
				pageLength : 5,

			});
			// $('#datatype td').css('white-space','initial');
			table.buttons().container().appendTo(
					'#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

		}

	});
}

function getstatusForTicket(ticketType) {
	//alert(ticketType)
	if (ticketType == 'Software Request') {
		$("#stForRequest").show();
		$("#stForRelease").hide();
		$("#stForTransfer").hide();
	}

	else if (ticketType == 'Software Release') {
		$("#stForRequest").hide();
		$("#stForTransfer").hide();
		$("#stForRelease").show();
	} else if (ticketType == 'Service Transfer') {
		// alert("sdfgsfdf")
		$("#stForRequest").hide();
		$("#stForRelease").hide();
		$("#stForTransfer").show();
	}
}
$("#submit-btn").click(function() {
	// alert("submit");
	if (!validation2222()) {
		// alert("in invalid");
		// event.preventDefault();
	} else {
		// alert("in valid");
		saveDataAdmin();
	}
});

function saveDataAdmin() {
	// alert("in save")

	var EmailTrigger;
	if ($('#emailtrigger').is(":checked")) {
		EmailTrigger = "Yes";
	} else {
		EmailTrigger = "No";
	}
	
	
	
	//sublbl
	var st;
	var ticketType = $("#ticket_Type").val();
	if (ticketType == 'Software Request') {
		st = $("#stForRequest").val();
 //alert("stForRequest"+st)
	} else if (ticketType == 'Software Release') {
		st = $("#stForRelease").val();
		// alert("problem");

	} else if (ticketType == 'Software Transfer') {
		st = $("#stForTransfer").val();
		// alert("service");
	}

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/AddEFormMailTemp";

	$.ajax({
		url : serviceUrl,
		type : 'post',
		data : 'st=' + encodeURIComponent(st) + '&subject='
				+ $("#subject").val() + '&mailbody=' + $("#mailbody").val()
				+ '&company=' + encodeURIComponent($("#company").val())
				+ '&EmailTrigger=' + EmailTrigger + '&ticketType='
				+ encodeURIComponent($("#ticket_Type").val()) + '&mailfooter='
				+ encodeURIComponent($("#mailfooter").val()),

		success : function(data) {
			 //Salert(data)
			if (data == "success") {
				swal({
					title : "Successful!",
					text : "Record Inserted Successfully!",
					type : "success",
					width : 300,
					height : 200,

					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						location.reload();
					}

				})

			}
			if (data == "duplicate") {
				swal({
					title : "Duplicate Data!",
					text : "Record Already Exist!",
					type : "warning",
					width : 300,
					height : 200,
					showCancelButton : false,
					confirmButtonClass : "btn btn-danger",
					cancelButtonClass : "btn btn-danger m-l-10",
					confirmButtonText : "OK",
					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						location.reload();
					}

				})

			}

			if (data == "update") {
				swal({
					title : "Successful!",
					text : "Record Updated Successfully!",
					type : "success",
					width : 300,
					height : 200,
					// showCancelButton: false,
					// confirmButtonClass: "btn btn-danger",
					// cancelButtonClass: "btn btn-danger m-l-10",
					// confirmButtonText: "OK",
					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						location.reload();
					}

				})

			}

		}
	})
}

// ---------------------------
var callToolTip122 = function(fieldName, status) {

	 if (fieldName == "mailfooter") {
	 //$("#email").tooltip('destroy');
	 var errorMessage = "<span>Please Enter Mail Footer<span>";
	
	 }
else if (fieldName == "subject") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Subject<span>";

	} else if (fieldName == "mailbody") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Mail Body<span>";

	} else if (fieldName == "company") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Company<span>";

	} else if (fieldName == "ticket_Type") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Ticket Type<span>";

	} else if (fieldName == "stForRequest") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Status<span>";

	} else if (fieldName == "stForRelease") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Status<span>";

	} else if (fieldName == "stForTransfer") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Status<span>";

	}

	$("#" + fieldName).tooltip({

		trigger : 'manual',
		at : 'center',
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

// ------------------------------

var callToolTip123 = function(fieldName, status, msg1) {

	if (fieldName == "demo") {

		var errorMessage = msg1;

	}

	if (fieldName == "demostatus") {

		var errorMessage = msg1;

	}

	if (fieldName == "demopriority") {

		var errorMessage = msg1;

	}

	$("#" + fieldName).tooltip({

		trigger : 'manual',
		at : 'center',
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

// --------------------------------

var callToolTip124 = function(fieldName, status, msg1) {

	if (fieldName == "tidbody") {

		var errorMessage = msg1;

	}

	if (fieldName == "tstbody") {

		var errorMessage = msg1;

	}

	if (fieldName == "tpribody") {

		var errorMessage = msg1;

	}
	if (fieldName == "tenggbody") {

		var errorMessage = msg1;

	}

	$("#" + fieldName).tooltip({

		trigger : 'manual',
		at : 'center',
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

// --------------------------------

// $('#st').on('focusout', function () {
// var usertype = $('#st').val();
//
// if (usertype.trim() == "") {
// callToolTip122('st', 'show');
// }
//    
// else {
// callToolTip122('st', 'hide');
// }
// });
$('#ticket_Type').on('focusout', function() {
	var usertype = $('#ticket_Type').val();

	if (usertype.trim() == "") {
		callToolTip122('ticket_Type', 'show');
	}

	else {
		callToolTip122('ticket_Type', 'hide');
	}
});

$('#subject').on(
		'focusout',
		function() {
			var usertype = $('#subject').val();

			if (usertype.trim() == "") {
				callToolTip122('subject', 'show');
			} else if ((usertype.includes('ID') || usertype.includes('id'))
					&& !usertype.includes('!')) {

				callToolTip123('demo', 'show',
						'Please Use ! Symbol For Ticket Number');
			}

			else if ((usertype.includes('STATUS')
					|| usertype.includes('status') || usertype
					.includes('Status'))
					&& !usertype.includes('#')) {

				callToolTip123('demostatus', 'show',
						'Please Use # Symbol For Ticket Status');
			}

			else if ((usertype.includes('PRIORITY')
					|| usertype.includes('priority') || usertype
					.includes('Priority'))
					&& !usertype.includes('@')) {

				callToolTip123('demopriority', 'show',
						'Please Use @ Symbol For Ticket Priority');
			}

			else {
				callToolTip122('subject', 'hide');
				callToolTip123('demo', 'hide', '');
				callToolTip123('demostatus', 'hide', '');
				callToolTip123('demopriority', 'hide', '');

			}
		});

$('#mailbody').on(
		'focusout',
		function() {
			var usertype = $('#mailbody').val();

			if (usertype.trim() == "") {
				callToolTip122('mailbody', 'show');
			} else if ((usertype.includes('ID') || usertype.includes('id'))
					&& !usertype.includes('!')) {
				// alert("id");

				callToolTip124('tidbody', 'show',
						'Please Use ! Symbol For Ticket Number');
			}

			else if ((usertype.includes('STATUS')
					|| usertype.includes('status') || usertype
					.includes('Status'))
					&& !usertype.includes('#')) {
				// alert("status");

				callToolTip124('tstbody', 'show',
						'Please Use # Symbol For Ticket Status');
			}

			else if ((usertype.includes('PRIORITY')
					|| usertype.includes('priority') || usertype
					.includes('Priority'))
					&& !usertype.includes('@')) {
				// alert("prio");

				callToolTip124('tpribody', 'show',
						'Please Use @ Symbol For Ticket Priority');
			}
			// else if ((usertype.includes('ENGINEER') ||
			// usertype.includes('Engineer')|| usertype.includes('engineer'))&&
			// !usertype.includes('~')) {
			//        
			// alert("engg");
			//    	
			// callToolTip124('tenggbody', 'show','Please Use ~ Symbol For
			// Engineer Name');
			// }
			//    

			else {
				callToolTip122('mailbody', 'hide');
				callToolTip124('tidbody', 'hide', '');
				callToolTip124('tstbody', 'hide', '');
				callToolTip124('tpribody', 'hide', '');
				// callToolTip124('tenggbody', 'hide','');

			}

		});

// ----------------------------

// $('#st').on('focus', function () {
// callToolTip122('st', 'destroy');
// });
$('#mailfooter').on('focus', function() {
	callToolTip122('mailfooter', 'destroy');
});

$('#subject').on('focus', function() {
	callToolTip122('subject', 'destroy');
});
$('#mailbody').on('focus', function() {
	callToolTip122('mailbody', 'destroy');
});
$('#company').on('focus', function() {
	callToolTip122('company', 'destroy');
});
$('#ticket_Type').on('focus', function() {
	callToolTip122('ticket_Type', 'destroy');
});
$('#stForRequest').on('focus', function() {
	callToolTip122('stForRequest', 'destroy');
});
$('#stForRelease').on('focus', function() {
	callToolTip122('stForRelease', 'destroy');
});
$('#stForTransfer').on('focus', function() {
	callToolTip122('stForTransfer', 'destroy');
});

// ------------------------------

var validation2222 = function() {

	var subb = $('#subject').val();
	var bodyy = $('#mailbody').val();
	indexError = 0;

	if ($('#mailfooter').val().trim() === '') {
		callToolTip122('mailfooter', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	
	if ($('#ticket_Type').val().trim() === '') {
		callToolTip122('ticket_Type', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	
	if ($('#ticket_Type').val().trim() === '') {
		callToolTip122('stForRequest', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#ticket_Type').val() == 'Software Request'
			&& $('#stForRequest').val().trim() === '') {
		callToolTip122('stForRequest', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;

	}

	if ($('#ticket_Type').val() == 'Software Release'
			&& $('#stForRelease').val().trim() === '') {
		callToolTip122('stForRelease', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;

	}
	if ($('#ticket_Type').val() == 'Software Transfer'
			&& $('#stForTransfer').val().trim() === '') {
		callToolTip122('stForTransfer', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;

	}


	if ($('#subject').val().trim() === '') {
		callToolTip122('subject', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	if ((subb.includes('ID') || subb.includes('id')) && !subb.includes('!')) {
		// alert("id")
		callToolTip123('demo', 'show', 'Please Use ! Symbol For Ticket Number');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	else if ((subb.includes('STATUS') || subb.includes('Status') || subb
			.includes('status'))
			&& !subb.includes('#')) {
		// alert("status")
		callToolTip123('demostatus', 'show',
				'Please Use # Symbol For Ticket Status');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	else if ((subb.includes('PRIORITY') || subb.includes('Priority') || subb
			.includes('priority'))
			&& !subb.includes('@')) {
		// alert("pri")
		callToolTip123('demopriority', 'show',
				'Please Use @ Symbol For Ticket Priority');

		indexError = indexError + 1;
		// alert("val of i="+indexError);
	}

	if ($('#mailbody').val().trim() === '') {
		callToolTip122('mailbody', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	if ((bodyy.includes('ID') || bodyy.includes('id')) && !bodyy.includes('!')) {
		// alert("id")
		callToolTip123('tidbody', 'show',
				'Please Use ! Symbol For Ticket Number');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	else if ((bodyy.includes('STATUS') || bodyy.includes('Status') || bodyy
			.includes('status'))
			&& !bodyy.includes('#')) {
		// alert("status")
		callToolTip123('tstbody', 'show',
				'Please Use # Symbol For Ticket Status');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	else if ((bodyy.includes('PRIORITY') || bodyy.includes('Priority') || bodyy
			.includes('priority'))
			&& !bodyy.includes('@')) {
		// alert("pri")
		callToolTip123('tpribody', 'show',
				'Please Use @ Symbol For Ticket Priority');

		indexError = indexError + 1;
		// alert("val of i="+indexError);
	}

	// else if ((bodyy.includes('Raised bt') || bodyy.includes('raised')||
	// bodyy.includes('ENGINEER') )&& !bodyy.includes('~')) {
	// // alert("pri")
	// callToolTip123('tenggbody', 'show', 'Please Use @ Symbol For Ticket
	// Priority');
	//        
	// indexError = indexError + 1;
	// //alert("val of i="+indexError);
	// }
	//       

	if (indexError > 0) {
		// alert("false")
		return false;

	} else {
		// alert("true")
		return true;
	}

}
// ---------------------

$("#resetbtn").click(function() {
	$("#st").val("");
	$("#subject").val("");
	$("#mailbody").val("");
	$("#stForRequest").val("");
	$("#mailfooter").val("");
	$("#stForRelease").val("");
	$("#stForTransfer").val("");
	$("#ticket_Type").val("");

	// CALLTOOLTIP122('ST', 'HIDE');
	callToolTip122('subject', 'hide');
	callToolTip122('mailbody', 'hide');
	callToolTip122('stForRequest', 'destroy');
	callToolTip122('stForRelease', 'destroy');
	callToolTip122('stForTransfer', 'destroy');
	callToolTip122('ticket_Type', 'destroy');
	callToolTip122('mailfooter', 'destroy');
	

})

function DeleteMailConfig(id) {
	// alert(id)
	swal({
		title : "Are you sure?",
		text : "You want to delete?",
		type : "warning",
		width : 350,
		height : 200,
		showCancelButton : !0,
		confirmButtonClass : "btn btn-success",
		cancelButtonClass : "btn btn-danger m-l-10",
		confirmButtonText : "Yes, Delete it!"
	}).then(
			function() {
				// alert("deleteUserdddddddd")

				var l = window.location;
				var base_url = l.protocol + "//" + l.host + "/"
						+ l.pathname.split('/')[1];
				var serviceUrl = base_url + "/Master/DeleteEformmaiconfig";

				$.ajax({
					type : 'POST',
					url : serviceUrl,
					data : 'crno=' + id

				}).done(function(data) {
					// alert("dfgsfd"+data)

					if (data == "success") {
						swal({
							title : "Successful!",
							text : "Record Deleted Successfully",
							type : "success",
							width : 300,
							height : 200,
							// showCancelButton: false,
							// confirmButtonClass: "btn btn-danger",
							// cancelButtonClass: "btn btn-danger m-l-10",
							// confirmButtonText: "OK",
							buttons : false,
							allowOutsideClick : false,

							preConfirm : function() {
								location.reload();
							}

						});

					}

					else if (data == "error") {
						swal({
							title : "Unsuccessful!",
							text : "Fail to delete file",
							type : "success",
							width : 300,
							height : 200,

							buttons : false,
							allowOutsideClick : false,
							preConfirm : function() {
								location.reload();
							}

						});

					}
				});
			});
}
function EditMailConfig(srno, companyn, status, ticketType, subject, mailbody,
		emailtriggerup) {

	//alert(mailfooterup);

	$("#sr_no1").val(srno);
	$("#Companyupdate").val(companyn);

	$("#ticketTypeup").val(ticketType);
	$("#mail_templateshow").modal("show");

	$("#subjectup").val(subject);
	$("#mailbodyup").val(mailbody);

	if (ticketType == 'Software Request') {
		$("#stForRequestup").show();
		$("#stForReleaseup").hide();
		$("#stForTransferup").hide();

		$("#stForRequestup").val(status);

	} else if (ticketType == 'Software Release') {
		$("#stForRequestup").hide();
		$("#stForReleaseup").show();
		$("#stForTransferup").hide();
		$("#stForReleaseup").val(status);
	} else if (ticketType == 'Service Transfer') {
		$("#stForRequestup").hide();
		$("#stForReleaseup").hide();
		$("#stForTransferup").show();

		$("#stForTransferup").val(status);
	}

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getEmailFooterForUpdate";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'srno=' + srno,
		async : false,
		success : function(data4) {
			// alert(data4)
			var html = "";
			for (var i = 0; i < data4.length; i++) {
				html += data4[i];
			}

			document.getElementById('mailfooterup').innerHTML = html;
		}
	});

	var EmailTriggerUp;
	if (emailtriggerup === 'Yes') {
		document.getElementById("emailtriggerup").checked = true;

	} else if (emailtriggerup === 'No') {
		document.getElementById("emailtriggerup").checked = false;

	}
}
function getStatusForTicket(ticketType) {

	// alert(ticketType)
	if (ticketType == 'Software Request') {
		$("#stForRequestup").show();
		$("#stForReleaseup").hide();
		$("#stForTransferup").hide();
	}

	else if (ticketType == 'PSoftware Release') {
		$("#stForRequestup").hide();
		$("#stForTransferup").hide();
		$("#stForReleaseup").show();
	} else if (ticketType == 'Service Transfer') {
		$("#stForRequestup").hide();
		$("#stForReleaseup").hide();
		$("#stForTransferup").show();
	}
}

var callToolTip123 = function(fieldName, status) {

//	 if (fieldName == "mailfooter") {
//	 //$("#email").tooltip('destroy');
//	 var errorMessage = "<span>Please Enter Mail Footer<span>";
//	
//	 }
	if(fieldName == "subjectup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Subject<span>";

	} else if (fieldName == "ticketTypeup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Ticket Type<span>";

	} else if (fieldName == "mailbodyup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Mail Body<span>";

	}

	else if (fieldName == "stForRequestup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Status<span>";

	} else if (fieldName == "stForReleaseup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Status<span>";

	} else if (fieldName == "stForTransferup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Status<span>";

	}

	$("#" + fieldName).tooltip({

		trigger : 'manual',
		at : 'center',
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

var validateMailTemplate = function() {

	indexError = 0;

	if ($('#ticketTypeup').val() == 'Incident Ticket'
			&& $('#stForRequestup').val().trim() === '') {
		callToolTip123('stForRequestup', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;

	}
	
//	if ($('#mailfooter').val().trim() === '') {
//		callToolTip123('mailfooter', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	}

	if ($('#ticketTypeup').val() == 'Problem Ticket'
			&& $('#stForReleaseup').val().trim() === '') {
		callToolTip123('stForReleaseup', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;

	}
	if ($('#ticketTypeup').val() == 'Service Request'
			&& $('#stForTransferup').val().trim() === '') {
		callToolTip123('stForTransferup', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;

	}
	if ($('#ticketTypeup').val().trim() === '') {
		callToolTip123('ticketTypeup', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	if ($('#subjectup').val().trim() === '') {
		callToolTip123('subjectup', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	if ($('#mailbodyup').val().trim() === '') {
		callToolTip123('mailbodyup', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	if (indexError > 0) {
		// alert("false")
		return false;

	} else {
		// alert("true")
		return true;
	}

}


$('#statusup').on('focus', function() {
	callToolTip123('statusup', 'destroy');
});
$('#subjectup').on('focus', function() {
	callToolTip123('subjectup', 'destroy');
});
$('#mailbodyup').on('focus', function() {
	callToolTip123('mailbodyup', 'destroy');
});
$('#ticketTypeup').on('focus', function() {
	callToolTip123('ticketTypeup', 'destroy');
});

$('#stForRequestup').on('focus', function() {
	callToolTip123('stForRequestup', 'destroy');
});
$('#stForReleaseup').on('focus', function() {
	callToolTip123('stForReleaseup', 'destroy');
});
$('#stForTransferup').on('focus', function() {
	callToolTip123('stForTransferup', 'destroy');
});

$("#update_category_btn").click(function() {
	if (!validateMailTemplate()) {

		event.preventDefault();
	} else if (validateMailTemplate())

	{
		updateMailTemplate();
	}
}).show();
function updateMailTemplate() {
	var emailtrigger;
	// alert($("#emailtriggerup").val());
	if ($('#emailtriggerup').is(":checked")) {
		emailtrigger = "Yes";
	} else {
		emailtrigger = "No";
	}

	var statusType;
	var ticketTypeUpdate = $("#ticketTypeup").val();
	// alert(ticketTypeUpdate)
	if (ticketTypeUpdate == 'Software Request') {
		statusType = $("#stForRequestup").val();
		// alert("fgfg"+statusType);
	} else if (ticketTypeUpdate = 'Software Release') {
		statusType = $("#stForReleaseup").val();
		// alert("problem"+statusType)
	} else if (ticketTypeUpdate = 'Service Request') {
		statusType = $("#stForTransferup").val();
		// alert("Service request"+statusType)
	}
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/updatEformemailtemplate";

	$.ajax(
			{
				type : 'POST',
				url : serviceUrl,

				data : 'srno=' + $("#sr_no1").val() + '&company='
						+ encodeURIComponent($("#Companyupdate").val())
						+ '&status=' + encodeURIComponent(statusType)
						+ '&ticketType=' + encodeURIComponent(ticketTypeUpdate)
						+ '&subject='
						+ encodeURIComponent($("#subjectup").val())
						+ '&mailbody='
						+ encodeURIComponent($("#mailbodyup").val())
						+ '&emailtriggerup=' + emailtrigger + '&mailfooter='
						+ encodeURIComponent($("#mailfooterup").val()),

			}).done(
			function(data) {
				// alert("response: "+data)

				if (data == "success") {
					swal({
						title : "Successful!",
						text : "Record Updated Successfully",
						type : "success",
						width : 300,
						height : 200,

						confirmButtonClass : "btn btn-danger",

						confirmButtonText : "OK",
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url + "/Admin/EformMail";
						}

					});

				} else if (data == "duplicate") {
					swal({
						title : "Duplicate Data!",
						text : "Record Already Exists",
						type : "warning",
						width : 300,
						height : 200,
						showCancelButton : false,
						confirmButtonClass : "btn btn-danger",
						cancelButtonClass : "btn btn-danger m-l-10",
						confirmButtonText : "OK",
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url + "/Admin/EformMail";
						}

					});

				} else if (data == "error") {
					swal({
						title : "Unsuccessful!",
						text : "Fail to add file",
						type : "error",
						width : 300,
						height : 200,
						// showCancelButton: false,
						// confirmButtonClass: "btn btn-danger",
						// cancelButtonClass: "btn btn-danger m-l-10",
						// confirmButtonText: "OK",
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url + "/Admin/EformMail";
						}

					});

				}
			});
}
