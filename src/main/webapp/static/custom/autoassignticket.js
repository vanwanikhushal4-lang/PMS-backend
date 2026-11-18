function AutoAssignticket(value) {

	if (value === "Engineer") {
		$('#enggDiv').show();
		$('#groupDiv').hide();
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getCategoryDetailsforAutoAssignTickets";
			var companyname=$("#company").val();
		$.ajax({

			url: serviceUrl,
			type: 'POST',
			dataType: 'json',
			//		        data:'Categoryup='+encodeURIComponent($("#companyupdateUDassign").val())
			data: 'company=' + companyname,
		}).done(function(data) {
			// //alert(data)
			data.sort()
			var html = " <select class='form-control' tabindex='7' id='AutoassignTo' name='AutoassignTo'>";
			html = html + '<option value="">--Please Select --</option>';
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i] + '">' + data[i]
					+ '</option>';
			}

			document.getElementById("enggcat").innerHTML = html;
		});
	}
	else if (value === "Group") {
		$('#groupDiv').show();
		$('#enggDiv').hide();

//		alert("hii00"+value);
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getGroupDetailsforAutoAssignTickets";
	var companyname=$("#company").val();
		$.ajax({

			url: serviceUrl,
			type: 'POST',
			dataType: 'json',
			data: 'company=' + companyname,
		}).done(function(data) {
			// //alert(data)
			data.sort()
			var html = " <select class='form-control' tabindex='7' id='engGroup' name='engGroup'>";
			html = html + '<option value="">--Please Select Group--</option>';
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' + data[i] + '">' + data[i]
					+ '</option>';
			}

			document.getElementById("engGroup").innerHTML = html;
		});

	} else {
		$('#enggDiv').hide();
		$('#groupDiv').hide();
	}
}





window.onload = function() {

	$('#days').val("00");
	$('#hours').val("00");
	$('#minutes').val("00");
	$('#seconds').val("00");


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCompanyNames1";

	$.ajax({

		url: serviceUrl,
		type: 'POST',
		dataType: 'json',
	}).done(function(data4) {

		var html = " <select class='form-control' tabindex='3' id='company' name='company' onchange='JavaScript:change_subtype(this.value)'>";
		html += "  <option value=''> -- Please Select Company --</option>";
		for (var i = 0; i < data4.length; i++) {
			//                        alert(data4[i]);
			html += '<option value="' + data4[i] + '">' + data4[i]
				+ '</option>';
		}
		document.getElementById("company").innerHTML = html;
	});



	//	   var l = window.location;
	//		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	//		var serviceUrl = base_url + "/Master/getPriorityName";
	//	    
	////	    var getPriorityName='getPriorityName';  
	//	    $.ajax({
	//
	//	        url :serviceUrl,
	//	        type : 'POST',
	//	        dataType: 'json', 
	//	    }).done(function(data) {
	////	        alert(data)
	//
	////	        var pollingHost=data;
	////	        var d = pollingHost.split(",");
	////	        var length=d.length-1;
	//	        var html =" <select class='form-control' tabindex='13' id='priority' name='priority' '>";
	//	        html=html+'<option value="">--Please Select Priority--</option>';
	//	        for (var i = 0; i < data.length; i++) {
	//	            html += '<option value="' +data[i]+ '">' + data[i]
	//	            + '</option>';
	//	        }
	//
	//	        document.getElementById("priority").innerHTML=html;
	//	    });    


	//     var l = window.location;
	//   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	//   	var serviceUrl = base_url + "/Master/getCategoryDetails";
	//     
	//      $.ajax({
	//          type: 'POST',
	//          url: serviceUrl,
	//          dataType: 'json',
	//          success: function(data4) {
	////              alert(data4)
	////             var pollingHost = data4;
	////                     var d = pollingHost.split(",");
	////                     var length = d.length - 1;
	//                     var html = "  <option value=''> -- Please Select Category --</option>";
	//                     for (var i = 0; i < data4.length; i++) {
	////                         alert(data4[i]);
	//                         html += '<option value="' + data4[i] + '">' + data4[i]
	//                                 + '</option>';
	//                     }
	//
	//                     document.getElementById("category").innerHTML = html;
	//                    // document.getElementById("categoryupdate").innerHTML = html;
	//              }
	//
	//              
	//      });


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/ViewAutoAssignTicket";
	$.ajax({
		type: 'POST',
		url: serviceUrl,
		dataType: 'json',
		success: function(data4) {
			// alert(data4)

			var table = $('#datatype').DataTable({
				//       			"dom": 'blfrtip',
				lengthChange: false,
				pageLength: 5,
				data: data4,

				scrollX: true,
				scrollCollapse: true,
				initComplete: function() {
					$(this.api().table().container()).find('input').parent().wrap('<form>').parent().attr('autocomplete', 'off');
				}
			});

			table.buttons().container().appendTo(
				'#datatype_wrapper .col-sm-6:eq(0)');

		}

	});




};
////////////////// ON LOAD ENDS /////////////////

function change_subtype(company) {
	//alert("fgh");
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getPriorityName";

	$.ajax({

		url: serviceUrl,
		type: 'POST',
		data: 'companyname=' + encodeURIComponent(company),
		dataType: 'json',
	}).done(function(data) {
		// alert(data)

		//        var pollingHost=data;
		//        var d = pollingHost.split(",");
		//        var length=d.length-1;
		var html = " <select class='form-control' tabindex='7' id='priority' name='priority'>";
		html = html + '<option value="">--Please Select Priority--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' + data[i] + '">' + data[i]
				+ '</option>';
		}

		document.getElementById("priority").innerHTML = html;
	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSeverityName";

	$.ajax({

		url: serviceUrl,
		type: 'POST',
		data: 'companyname=' + encodeURIComponent(company),
		dataType: 'json',
	}).done(function(data) {
		//       alert(data)

		//        var pollingHost=data;
		//        var d = pollingHost.split(",");
		//        var length=d.length-1;
		var html = " <select class='form-control' tabindex='7' id='severity' name='severity'>";
		html = html + '<option value="">--Please Select Severity--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' + data[i] + '">' + data[i]
				+ '</option>';
		}

		document.getElementById("severity").innerHTML = html;
	});

	//alert("hhh");
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCategoryDetailsForAutoAssign";

	$.ajax({

		url: serviceUrl,
		type: 'POST',
		data: 'comp=' + encodeURIComponent(company),
		dataType: 'json',
	}).done(function(data) {
		//     alert(data)

		//        var pollingHost=data;
		//        var d = pollingHost.split(",");
		//        var length=d.length-1;
		var html = " <select class='form-control' tabindex='7' id='group' name='group'>";
		html = html + '<option value="">--Please Select --</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' + data[i] + '">' + data[i]
				+ '</option>';
		}

		document.getElementById("category").innerHTML = html;
	});
}




$("#submit-btn").click(function() {
	saveDataUser();

//	if (!validation2222()) {
//		// alert("in invalid");
//		//event.preventDefault();
//	} else {
//		 alert("in valid");
//		
//	}
});



function saveDataUser() {
//	alert("in save")
	//alert("$(t2).val()==="+$("#t2").val());
	//alert("$(t3).val()==="+$("#t3").val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/addAutoAssignTicket";
	$.ajax({
		url: serviceUrl,
		type: 'post',
		data: 'category=' + encodeURIComponent($("#enggcat").val())
			+ '&priority=' + encodeURIComponent($("#priority").val())
			+ '&severity=' + encodeURIComponent($("#severity").val())
			+ '&company=' + encodeURIComponent($("#company").val())
			+ '&days=' + $("#days").val()
			+ '&hours=' + $("#hours").val()
			+ '&minutes=' + $("#minutes").val()
			+ '&seconds=' + $("#seconds").val()
			+'&Assign_TO=' + encodeURIComponent($("#AutoassignTo").val())
			+'&GroupName=' + encodeURIComponent($("#engGroup").val()),
		
		success: function(data) {
//			 alert(data)
			if (data == "success") {
				swal({
					title: "Successful!",
					text: "Record Inserted Successfully",
					type: "success",
					width: 300,
					height: 200,
					//                           showCancelButton: false,
					//                 confirmButtonClass: "btn btn-danger",
					//                 cancelButtonClass: "btn btn-danger m-l-10",
					//                 confirmButtonText: "OK",
					buttons: false,
					allowOutsideClick: false,

					preConfirm: function() {
						location.reload();
					}

				})

			} else if (data == "update") {
				swal({
					title: "Successful!",
					text: "Record Updated Successfully",
					type: "success",
					width: 300,
					height: 200,
					//                           showCancelButton: false,
					//                 confirmButtonClass: "btn btn-danger",
					//                 cancelButtonClass: "btn btn-danger m-l-10",
					//                 confirmButtonText: "OK",
					buttons: false,
					allowOutsideClick: false,

					preConfirm: function() {
						location.reload();
					}

				})

			}
			if (data == "duplicate") {
				swal({
					title: "Successful!",
					text: "Record Inserted Successfully",
					type: "warning",
					width: 300,
					height: 200,
					showCancelButton: false,
					confirmButtonClass: "btn btn-danger",
					cancelButtonClass: "btn btn-danger m-l-10",
					confirmButtonText: "OK",
					buttons: false,
					allowOutsideClick: false,

					preConfirm: function() {
						location.reload();
					}

				})

			}
		}
	})
}



var callToolTip122 = function(fieldName, status) {

	if (fieldName == "company") {

		var errorMessage = "<span>Please Select Company<span>";

	}
	else if (fieldName == "priority") {

		var errorMessage = "<span>Please Select Priority<span>";

	}
	
	else if (fieldName == "AutoassignTo") {

		var errorMessage = "<span>Please Select Data<span>";

	}
	else if (fieldName == "AutoassignTo") {

		var errorMessage = "<span>Please Select data<span>";

	}
	
	else if (fieldName == "severity") {

		var errorMessage = "<span>Please Select Severity<span>";

	}
	else if (fieldName == "category") {

		var errorMessage = "<span>Please Select Category<span>";

	}
	else if (fieldName == "days") {

		var errorMessage = "<span>Please Enter No Of Days<span>";
	} else if (fieldName == "hours") {

		var errorMessage = "<span>Please Enter No Of Hours<span>";
	} else if (fieldName == "minutes") {

		var errorMessage = "<span>Please Enter No Of Minutes<span>";
	} else if (fieldName == "seconds") {

		var errorMessage = "<span>Please Enter No Of Seconds<span>";
	} else if (fieldName == "wrongDays") {

		var errorMessage = "<span>Please Enter Correct Days<span>";
	} else if (fieldName == "wrongHours") {

		var errorMessage = "<span>Please Enter Correct Hours<span>";
	} else if (fieldName == "wrongMinutes") {

		var errorMessage = "<span>Please Enter Correct Minutes<span>";
	} else if (fieldName == "wrongSeconds") {

		var errorMessage = "<span>Please Enter Correct Seconds<span>";
	}



	$("#" + fieldName).tooltip({

		trigger: 'manual',
		at: 'center',
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



//------------------

$('#company').on('focusout', function() {
	var usertype = $('#company').val();

	if (usertype.trim() == "") {
		callToolTip122('company', 'show');
	}
	else {
		callToolTip122('company', 'hide');
	}
});

$('#priority').on('focusout', function() {
	var usertype = $('#priority').val();

	if (usertype.trim() == "") {
		callToolTip122('priority', 'show');
	}
	else {
		callToolTip122('priority', 'hide');
	}
});

$('#severity').on('focusout', function() {
	var usertype = $('#severity').val();

	if (usertype.trim() == "") {
		callToolTip122('severity', 'show');
	}
	else {
		callToolTip122('severity', 'hide');
	}
});

$('#category').on('focusout', function() {
	var usertype = $('#category').val();

	if (usertype.trim() == "") {
		callToolTip122('category', 'show');
	}
	else {
		callToolTip122('category', 'hide');
	}
});

$('#days').on('focusout', function() {
	var usertype = $('#days').val();

	if (usertype.trim() == "") {
		callToolTip122('days', 'show');
	} else {
		callToolTip122('days', 'hide');
	}
});
$('#hours').on('focusout', function() {
	var usertype = $('#hours').val();

	if (usertype.trim() == "") {
		callToolTip122('hours', 'show');
	} else {
		callToolTip122('hours', 'hide');
	}
});
$('#minutes').on('focusout', function() {
	var usertype = $('#minutes').val();

	if (usertype.trim() == "") {
		callToolTip122('minutes', 'show');
	} else {
		callToolTip122('minutes', 'hide');
	}
});
$('#seconds').on('focusout', function() {
	var usertype = $('#seconds').val();

	if (usertype.trim() == "") {
		callToolTip122('seconds', 'show');
	} else {
		callToolTip122('seconds', 'hide');
	}
});

$('#AutoassignTo').on('focusout', function() {
	var usertype = $('#AutoassignTo').val();

	if (usertype.trim() == "") {
		callToolTip122('AutoassignTo', 'show');
	} else {
		callToolTip122('AutoassignTo', 'hide');
	}
});
//-------------------


$('#company').on('focus', function() {
	callToolTip122('company', 'destroy');
});
$('#priority').on('focus', function() {
	callToolTip122('priority', 'destroy');
});
$('#severity').on('focus', function() {
	callToolTip122('severity', 'destroy');
});
$('#category').on('focus', function() {
	callToolTip122('category', 'destroy');
});
$('#days').on('focus', function() {
	callToolTip122('days', 'destroy');
	callToolTip122('wrongDays', 'destroy');
});
$('#hours').on('focus', function() {
	callToolTip122('hours', 'destroy');
	callToolTip122('wrongHours', 'destroy');
});
$('#minutes').on('focus', function() {
	callToolTip122('minutes', 'destroy');
	callToolTip122('wrongMinutes', 'destroy');
});
$('#seconds').on('focus', function() {
	callToolTip122('seconds', 'destroy');
	callToolTip122('wrongSeconds', 'destroy');
});
$('#AutoassignTo').on('focus', function() {
	callToolTip122('AutoassignTo', 'destroy');
});
//------------------------


var validation2222 = function() {

	var indexError = 0;

	if ($('#company').val().trim() === '') {
		callToolTip122('company', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#priority').val().trim() === '') {
		callToolTip122('priority', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#severity').val().trim() === '') {
		callToolTip122('severity', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#category').val().trim() === '') {
		callToolTip122('category', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	if ($('#days').val().trim() === '') {
		callToolTip122('days', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else if (!DaysInput()) {
		indexError = indexError + 1;
		console.log("In invalid contact number: " + indexError);

	}
	if ($('#hours').val().trim() === '') {
		callToolTip122('hours', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else if (!HoursInput()) {
		indexError = indexError + 1;
		console.log("In invalid contact number: " + indexError);

	}
	if ($('#minutes').val().trim() === '') {
		callToolTip122('minutes', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else if (!MinutesInput()) {
		indexError = indexError + 1;
		console.log("In invalid contact number: " + indexError);

	}
	if ($('#seconds').val().trim() === '') {
		callToolTip122('seconds', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else if (!SecondsInput()) {
		indexError = indexError + 1;
		console.log("In invalid contact number: " + indexError);

	}
	if ($('#AutoassignTo').val() === '') {
		callToolTip122('AutoassignTo', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	

	if (($('#days').val().trim() === '00' || $('#days').val().trim() === '0') && ($('#hours').val().trim() === '00' || $('#hours').val().trim() === '0') && ($('#minutes').val().trim() === '00' || $('#minutes').val().trim() === '0') && ($('#seconds').val().trim() === '00' || $('#seconds').val().trim() === '0')) {

		swal({
			title: "Alert!",
			text: "Time not set for Auto Assign Ticket",
			type: "error",
			width: 300,
			height: 200,
			buttons: false,
			allowOutsideClick: false,

		});
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	if (indexError > 0) {
		return false;

	} else {
		return true;
	}


}

$("#resetbtn").click(function() {
	callToolTip122('company', 'destroy');
	callToolTip122('priority', 'destroy');
	callToolTip122('severity', 'destroy');
	callToolTip122('category', 'destroy');
	callToolTip122('AutoassignTo', 'destroy');
	$('#company').val("");
	$('#priority').val("");
	$('#severity').val("");
	$('#category').val("");
	$("#days").val("00");
	callToolTip122('days', 'hide');
	$("#hours").val("00");
	callToolTip122('hours', 'hide');
	$("#minutes").val("00");
	callToolTip122('minutes', 'hide');
	$("#seconds").val("00");
	callToolTip122('seconds', 'hide');

	callToolTip122('wrongDays', 'destroy');
	callToolTip122('wrongHours', 'destroy');
	callToolTip122('wrongMinutes', 'destroy');
	callToolTip122('wrongSeconds', 'destroy');

});

function DaysInput() {

	var inputtxt = $('#days').val();
	var phoneno = /^\d{1,2}$/;

	if (inputtxt.match(phoneno)) {
		return true;
	}
	else {
		callToolTip231('wrongDays', 'show');
		return false;
	}
}
function HoursInput() {

	var inputtxt = $('#hours').val();
	var phoneno = /^\d{1,2}$/;

	if (inputtxt.match(phoneno)) {
		return true;
	}
	else {
		callToolTip231('wrongHours', 'show');
		return false;
	}
}
function MinutesInput() {

	var inputtxt = $('#minutes').val();
	var phoneno = /^\d{1,2}$/;

	if (inputtxt.match(phoneno)) {
		return true;
	}
	else {
		callToolTip231('wrongMinutes', 'show');
		return false;
	}
}
function SecondsInput() {

	var inputtxt = $('#seconds').val();
	var phoneno = /^\d{1,2}$/;

	if (inputtxt.match(phoneno)) {
		return true;
	}
	else {
		callToolTip231('wrongSeconds', 'show');
		return false;
	}
}

function DaysUpdateInput() {

	var inputtxt = $('#daysupdate').val();
	var phoneno = /^\d{1,2}$/;

	if (inputtxt.match(phoneno)) {
		return true;
	}
	else {
		callToolTipUpdate('wrongDaysupdate', 'show');
		return false;
	}
}
function HoursUpdateInput() {

	var inputtxt = $('#hoursupdate').val();
	var phoneno = /^\d{1,2}$/;

	if (inputtxt.match(phoneno)) {
		return true;
	}
	else {
		callToolTipUpdate('wrongHoursupdate', 'show');
		return false;
	}
}
function MinutesUpdateInput() {

	var inputtxt = $('#minutesupdate').val();
	var phoneno = /^\d{1,2}$/;

	if (inputtxt.match(phoneno)) {
		return true;
	}
	else {
		callToolTipUpdate('wrongMinutesupdate', 'show');
		return false;
	}
}
function SecondsUpdateInput() {

	var inputtxt = $('#secondsupdate').val();
	var phoneno = /^\d{1,2}$/;

	if (inputtxt.match(phoneno)) {
		return true;
	}
	else {
		callToolTipUpdate('wrongSecondsupdate', 'show');
		return false;
	}
}

function DeleteAutoAssign(srno) {
	//	alert("gdfsf: "+srno)
	swal({
		title: "Are you sure?",
		text: "You want to delete?",
		type: "warning",
		width: 350,
		height: 200,
		showCancelButton: !0,
		confirmButtonClass: "btn btn-success",
		cancelButtonClass: "btn btn-danger m-l-10",
		confirmButtonText: "Yes, Delete it!"
	}).then(function() {
		//  alert("deleteUserdddddddd")

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/deleteAutoAssignMaster";

		$.ajax({
			type: 'POST',
			url: serviceUrl,
			data: 'srno=' + srno

		}).done(function(data) {
			//  alert("dfgsfd"+data)

			if (data == "success") {
				swal({
					title: "Successful!",
					text: "Record Deleted Successfully",
					type: "success",
					width: 300,
					height: 200,
					//	           		 showCancelButton: false,
					//	                  confirmButtonClass: "btn btn-danger",
					//	                  cancelButtonClass: "btn btn-danger m-l-10",
					//	                  confirmButtonText: "OK",
					buttons: false,
					allowOutsideClick: false,
					preConfirm: function() {
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
						window.location.href = base_url + "/Admin/AutoAssignTicket";
					}

				});

			} else if (data == "error") {
				swal({
					title: "Unsuccessful!",
					text: "Fail to delete file",
					type: "success",
					width: 300,
					height: 200,
					//	           		 showCancelButton: false,
					//	                  confirmButtonClass: "btn btn-danger",
					//	                  cancelButtonClass: "btn btn-danger m-l-10",
					//	                  confirmButtonText: "OK",
					buttons: false,
					allowOutsideClick: false,
					preConfirm: function() {
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
						window.location.href = base_url + "/Admin/AutoAssignTicket";
					}

				});

			}
		});
	});
}
