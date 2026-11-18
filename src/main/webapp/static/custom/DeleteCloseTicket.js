/* global Highcharts */

window.onload = function() {

	$("#form1").show();
	$("#dataSet1").hide();

	//    multiselectstatus();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/TPActivity/CloseTicketListing";
	$.ajax({
		type: 'POST',
		url: serviceUrl,
		dataType: 'json',
		success: function(data4) {
			//			alert("close ticket response alert :  "+data4)
			$("#preLoader").hide();
			var table = $('#closeTicketListingTable').DataTable({
				lengthChange: false,
				pageLength: 5,
				data: data4,
				scrollX: true,
				scrollY: true
			});

			//			table.buttons().container()
			//				.appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

		}
	})

}

function EditCloseTicket(srno) {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/TPActivity/EditCloseTicket";

	$.ajax({
		type: 'POST',
		url: serviceUrl,
		dataType: 'json',
		data: 'srno=' + srno,
		success: function(data4) {

			$("#formdate1").val(data4[0]["fromDate"]);
			$("#todate").val(data4[0]["toDate"]);
			$("#status1").val(data4[0]["status"]);
			$("#sr_no1").val(data4[0]["srno"]);
			$("#ModelCloseTicket").modal("show");

		}
	})
}

$("#update_btn").click(function() {

	//	alert('click update')

	if (!ValidateGetUpodateDetails()) {
		event.preventDefault();

	} else {		

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/TPActivity/UpdateCloseTicket";

		$.ajax({
			type: 'POST',
			url: serviceUrl,
			//		dataType: 'json',
			data: 'srno=' + encodeURIComponent($('#sr_no1').val())
				+ '&formDate=' + encodeURIComponent($('#formdate1').val())
				+ '&todate=' + encodeURIComponent($('#todate').val())
				+ '&status1=' + encodeURIComponent($('#status1').val()),
			success: function(data4) {
				//			alert('data4 : '+ data4)
				if (data4 == "success") {
					swal({
						title: "Successful!",
						text: "Record Update Successfull",
						type: "success",
						width: 300,
						height: 200,
						//           		 showCancelButton: false,
						//                  confirmButtonClass: "btn btn-danger",
						//                  cancelButtonClass: "btn btn-danger m-l-10",
						//                  confirmButtonText: "OK",
						buttons: false,
						allowOutsideClick: false,
						preConfirm: function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
							window.location.href = base_url + "/TP/deletecloseticket";
						}
					});
				}
			}
		})
	}
});

//Validate Update Method
function ValidateGetUpodateDetails() {

//  alert('calling ValidateGetUpodateDetails()')
	var a = $('#formdate1').val().split(" ")[0];
	var b = $('#todate').val().split(" ")[0];
	
//	alert('aaaaaaaaaaaaaaaa : '+ a);	
//	alert('bbbbbbbbbbbbbbbb : '+ b);
	
	indexError = 0;

	var date = a.substring(0, 2);
	var month = a.substring(3, 5);
	var year = a.substring(6, 10);
	
//	alert('date : '+ date + 'month : '+ month +'year : '+ year);
	
	var myDate = new Date(year, month - 1, date);
	var today = new Date();
	var date1 = new Date(a.split('-')[2], a.split('-')[1], a.split('-')[0]);
	var date2 = new Date(b.split('-')[2], b.split('-')[1], b.split('-')[0]);
	
//	alert('date1 : '+ date1 +'date2 : '+ date2)
	
	if (date1 > date2) {
		swal({
			title: "Invalid!",
			text: "To Date should be Greater than From Date",
			type: "warning",
			width: 300,
			height: 200,
			//                    showCancelButton: !0,
			confirmButtonClass: "btn btn-danger",
			//                    cancelButtonClass: "btn btn-danger m-l-10",
			confirmButtonText: "OK",

		})
		indexError = indexError + 1;
	}

	if ($('#formdate1').val().trim() === '') {
		ToolTipUpdate('formdate1', 'show');
		indexError = indexError + 1;
	}

	if ($('#todate').val().trim() === '') {
		ToolTipUpdate('todate', 'show');
		indexError = indexError + 1;
	}

	if ($('#status1').val() === '' || $('#status1').val().length == 0) {
		ToolTipUpdate('status1', 'show');
		indexError = indexError + 1;
	}

	if (indexError > 0) {
		return false;
	} else {
		return true;
	}

}

//ToolTipUpdate Method

var ToolTipUpdate = function(fieldName, status) {

	if (fieldName === "formdate1") {
		var errorMessage = "<span>Please Select From Date<span>";
	}
	
	if (fieldName === "todate") {
		var errorMessage = "<span>Please Select To Date<span>";
	}

	if (fieldName === "status1") {
		var errorMessage = "<span>Please Select status<span>";
	}

	$("#" + fieldName).tooltip({
		trigger: 'manual',
		placement: 'top',
		title: errorMessage,
		animation: true,
		delay: 1000,
		html: true
	});

	if (status === "show") {
		$("#" + fieldName).tooltip('show');

	} else {
		$("#" + fieldName).tooltip('hide');
		
	}
}

$('#formdate1').on('focus', function() {
	ToolTipUpdate('formdate1', 'destroy');
});
$('#todate').on('focus', function() {
	ToolTipUpdate('todate', 'destroy');
});
$('#status1').on('focus', function() {
	ToolTipUpdate('status1', 'destroy');
});

//////// End Update Validation

//from Date picker
$('#FromDate').datetimepicker({

	autoclose: true,
	format: 'dd-mm-yyyy hh:ii',
	todayHighlight: !0,
	orientation: "bottom",
	endDate: new Date()

}).on('change', function() {
	//     ToolTip59('ToDate', 'hide');
	$(this).focus();
});


// to Date picker 
$('#ToDate').datetimepicker({
	autoclose: true,
	format: 'dd-mm-yyyy hh:ii',
	todayHighlight: !0,
	orientation: "bottom",
	endDate: new Date()
}).on('change', function() {
	//      ToolTip59('ToDate', 'hide');
	$(this).focus();
});

$("#submit-btn").click(function() {
	if (!ValidateGetUserReport()) {
		event.preventDefault();
	} else {
		getdeletecloseticket();
	}

});


function getdeletecloseticket() {
	//alert("in getUserReport");
	$("#form1").hide();
	$("#dataSet1").show();

	var FromDate = $("#FromDate").val();
	var ToDate = $("#ToDate").val();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/TPActivity/deletecloseticket";

	$.ajax({
		type: 'POST',
		url: serviceUrl,
		//        dataType: 'json',
		data: 'FromDate=' + FromDate
			+ "&ToDate=" + ToDate
			+ "&status=" + $("#status").val()
	}).done(function(data) {
		//     	alert('dataaaaaaaaaaaaaaaaaaaaaa : '+ data);

		if (data == "success") {
			swal({
				title: "Successful!",
				text: "Record Added Successfull",
				type: "success",
				width: 300,
				height: 200,
				//           		showCancelButton: false,
				//                  confirmButtonClass: "btn btn-danger",
				//                  cancelButtonClass: "btn btn-danger m-l-10",
				//                  confirmButtonText: "OK",
				buttons: false,
				allowOutsideClick: false,
				preConfirm: function() {
					var l = window.location;
					var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
					window.location.href = base_url + "/TP/deletecloseticket";
				}

			});

		}

	})

}


//Validate Method
function ValidateGetUserReport() {

	var a = $('#FromDate').val().split(" ")[0];
	var b = $('#ToDate').val().split(" ")[0];

	//    alert(a)
	//       alert(b)

	indexError = 0;

	var date = a.substring(0, 2);
	var month = a.substring(3, 5);
	var year = a.substring(6, 10);

	var myDate = new Date(year, month - 1, date);
	var today = new Date();
	//  alert(myDate);

	var date1 = new Date(a.split('-')[2], a.split('-')[1], a.split('-')[0]);
	//alert(today);

	var date2 = new Date(b.split('-')[2], b.split('-')[1], b.split('-')[0]);

	//alert(date1)
	//alert(date2)
	if (date1 > date2) {
		//        alert("To Date should be Greater than From Date")
		//        $.swal({
		//            text: "To Date should be Greater than From Date",
		//            width: 200
		//        });
		swal({
			title: "Invalid!",
			text: "To Date should be Greater than From Date",
			type: "warning",
			width: 300,
			height: 200,
			//                    showCancelButton: !0,
			confirmButtonClass: "btn btn-danger",
			//                    cancelButtonClass: "btn btn-danger m-l-10",
			confirmButtonText: "OK",


		})
		indexError = indexError + 1;
	}


	if ($('#FromDate').val().trim() === '') {
		ToolTip('FromDate', 'show');
		indexError = indexError + 1;
	}

	if ($('#ToDate').val().trim() === '') {
		ToolTip('ToDate', 'show');
		indexError = indexError + 1;
	}


	if ($('#status').val() === '' || $('#status').val().length == 0) {
		ToolTip('statusid', 'show');
		indexError = indexError + 1;
	}


	//    if ($('#companyname').val() === '' || $('#companyname').val().length==0) {
	//        ToolTip('companydiv1', 'show');
	//        indexError = indexError + 1;
	//    }
	//    if ($('#locationid').val() === ''  || $('#locationid').val().length==0) {
	//        ToolTip('locationiddiv', 'show');
	//        indexError = indexError + 1;
	//    }
	//    if ($('#username').val()=== '' || $('#username').val().length=== 0 ) {
	//        ToolTip('user_name1', 'show');
	//        indexError = indexError + 1;
	//    }


	if (indexError > 0) {
		return false;
	} else {
		return true;
	}

}

//Tooltip Method

function ToolTip(fieldName, status) {

	if (fieldName === "FromDate") {
		var errorMessage = "<span>Please Select From Date<span>";
	}
	if (fieldName === "ToDate") {
		var errorMessage = "<span>Please Select To Date<span>";
	}


	//    if (fieldName === "user_name1") {
	//        var errorMessage = "<span>Please Select Username<span>";
	//    }
	if (fieldName === "statusid") {
		var errorMessage = "<span>Please Select status<span>";
	}

	//    if (fieldName === "companydiv1") {
	//        var errorMessage = "<span>Please Select Company<span>";
	//    }
	//
	//    if (fieldName === "locationiddiv") {
	//        var errorMessage = "<span>Please Select Location<span>";
	//    }

	$("#" + fieldName).tooltip({
		trigger: 'manual',
		placement: 'top',
		title: errorMessage,
		animation: true,
		delay: 1000,
		html: true
	});

	if (status === "show") {
		$("#" + fieldName).tooltip('show');

	} else {
		$("#" + fieldName).tooltip('hide');
	}
}

$('#FromDate').on('focus', function() {
	ToolTip('FromDate', 'destroy');
});
$('#ToDate').on('focus', function() {
	ToolTip('ToDate', 'destroy');
});

//Reset Button Click

$("#resetbtn").click(function() {
	ToolTip('ToDate', 'destroy');
	ToolTip('FromDate', 'destroy');
	ToolTip('statusid', 'destroy');

	//    ToolTip('companydiv1', 'destroy');     
	//     ToolTip('locationiddiv', 'destroy');
	//     ToolTip('user_name1', 'destroy');
	//     


	$('#FromDate').val("");
	$('#ToDate').val("");


	//    $("#username option:selected").prop("selected", false);
	//    $("#username").multiselect('refresh');

	$("#status option:selected").prop("selected", false);
	$("#status").multiselect('refresh');

	//    $("#companyname option:selected").prop("selected", false);
	//    $("#companyname").multiselect('refresh');
	//    $("#locationid option:selected").prop("selected", false);
	//    $("#locationid").multiselect('refresh');

});


