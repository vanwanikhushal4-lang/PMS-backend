
window.onload = function() {

	// Proposal Master list

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getProposalName";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {

						var html = " <select class='form-control' tabindex='8' id='Proposaltype' name='Proposaltype'>";
						html = html
								+ '<option value="">--Please Select Proposal Name--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}

						document.getElementById("Proposaltype").innerHTML = html;

					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCustomerName";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {

						var html = " <select class='form-control' tabindex='8' id='clientname' name='clientname'>";
						html = html
								+ '<option value="">--Please Select Customer--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}

						document.getElementById("clientname").innerHTML = html;
					});

	// maker list
	// Maker Details

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getAllUserDetails";

	$.ajax({

		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
	}).done(function(data) {

		$('#poinitiator').val(data[0]["FULLNAME"]);
		$('#poinitiatorno').val(data[0]["PHONE"]);

	});

	// checker list

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getcheckerName";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {

						var html = " <select class='form-control' tabindex='8' id='FirstApprovername' name='FirstApprovername'>";
						html = html
								+ '<option value="">--Please Select Checker Name--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}

						document.getElementById("FirstApprovername").innerHTML = html;
					});

}

function validatepo() {
	// var spinner = document.getElementById("spin1");
	//
	// // Set the display property to "none" to hide the spinner
	// spinner.style.display = "none";

	var indexError = 0;
	if ($('#Proposaltype').val().trim() === '') {
		callToolTip122('Proposaltype', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}
	
	if($('#Proposaltype').val() === "Perpetual"){
	 if ($('#Perpetualyear').val().trim() === '') {
	 callToolTip122('Perpetualyear', 'show');
	 if (indexError == 0) {
	
	 }
	 indexError = indexError + 1;
	 } else {
	
	 indexError = 0;
	 }
	}
	
	
	if($('#Proposaltype').val() === "Subscription"){
	 if ($('#Subscriptionyear').val().trim() === '') {
	 callToolTip122('Subscriptionyear', 'show');
	 if (indexError == 0) {
	
	 }
	 indexError = indexError + 1;
	 } else {
	
	 indexError = 0;
	 }
	}
	
	
	if($('#Proposaltype').val() === "Fixed"){
		 if ($('#fixedyear').val().trim() === '') {
		 callToolTip122('fixedyear', 'show');
		 if (indexError == 0) {
		
		 }
		 indexError = indexError + 1;
		 } else {
		
		 indexError = 0;
		 }
		}
	
	
	if($('#Proposaltype').val() === "Subscription & Perpetual"){
		 if ($('#subscriptionANDperpetualYear').val().trim() === '') {
		 callToolTip122('subscriptionANDperpetualYear', 'show');
		 if (indexError == 0) {
		
		 }
		 indexError = indexError + 1;
		 } else {
		
		 indexError = 0;
		 }
		}
	
	 if ($('#manualAmount').val().trim() === '') {
		 callToolTip122('manualAmount', 'show');
		 if (indexError == 0) {
		
		 }
		 indexError = indexError + 1;
		 } else {
		
		 indexError = 0;
		 }
	
	 
	
	 if ($('#manualProposalFile').val().trim() === '') {
		 callToolTip122('manualProposalFile', 'show');
		 if (indexError == 0) {
		
		 }
		 indexError = indexError + 1;
		 } else {
		
		 indexError = 0;
		 }
	 
	// if ($('#poinitiator').val().trim() === '') {
	// callToolTip122('poinitiator', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }

	// if ($('#poinitiatorno').val().trim() === '') {
	// callToolTip122('poinitiatorno', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }
	if ($('#FirstApprovername').val().trim() === '') {
		callToolTip122('FirstApprovername', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}

	// if ($('#firstapprovercontact').val().trim() === '') {
	// callToolTip122('firstapprovercontact', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }
	//
	//
	// if ($('#secondApprovername').val().trim() === '') {
	// callToolTip122('secondApprovername', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }
	//	 
	// if ($('#secondapprovercontact').val().trim() === '') {
	// callToolTip122('secondapprovercontact', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }

	if ($('#customerType').val().trim() === '') {
		callToolTip122('customerType', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}
	
	 if ($('#clientname').val().trim() === '') {
	 callToolTip122('clientname', 'show');
	 if (indexError == 0) {
	
	 }
	 indexError = indexError + 1;
	 } else {
	
	 indexError = 0;
	 }
	// 
	// if ($('#newcustomername').val().trim() === '') {
	// callToolTip122('newcustomername', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }
	// if ($('#newAddress').val().trim() === '') {
	// callToolTip122('newAddress', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }
	// if ($('#newdistrict').val().trim() === '') {
	// callToolTip122('newdistrict', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }
	// 
	// if ($('#newcity').val().trim() === '') {
	// callToolTip122('newcity', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }
	// if ($('#newpin').val().trim() === '') {
	// callToolTip122('newpin', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }
	// if ($('#office_mailid').val().trim() === '') {
	// callToolTip122('office_mailid', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }
	 
	if ($('#productsuitselect').val().trim() === '') {
		callToolTip122('productsuitselect', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}
//	if ($('#productnameaddrow').val().trim() === '') {
//		callToolTip122('productnameaddrow', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	} else {
//
//		indexError = 0;
//	}
//	if ($('#Desciption').val().trim() === '') {
//		callToolTip122('Desciption', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	} else {
//
//		indexError = 0;
//	}

//	if ($('#quantitydata').val().trim() === '') {
//		callToolTip122('quantitydata', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	} else {
//
//		indexError = 0;
//	}
//
//	if ($('#Desciption').val().trim() === '') {
//		callToolTip122('Desciption', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	} else {
//
//		indexError = 0;
//	}

//	if ($('#unitratedata').val().trim() === '') {
//		callToolTip122('unitratedata', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	} else {
//
//		indexError = 0;
//	}

	// if ($('#totalpricedata').val().trim() === '') {
	// callToolTip122('totalpricedata', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }

//	if ($('#deploysupport').val().trim() === '') {
//		callToolTip122('deploysupport', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	} else {
//
//		indexError = 0;
//	}

	// if ($('#clouddeploycharges').val().trim() === '') {
	// callToolTip122('clouddeploycharges', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }

//	if ($('#IntegrationCharges').val().trim() === '') {
//		callToolTip122('IntegrationCharges', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	} else {
//
//		indexError = 0;
//	}
//
//	if ($('#resoucesamount').val().trim() === '') {
//		callToolTip122('resoucesamount', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	} else {
//
//		indexError = 0;
//	}

	if ($('#ATC').val().trim() === '' && $('#Proposaltype')==='Fixed' ||  $('#Proposaltype')==='Perpetual' || $('#Proposaltype')==='Subscription & Perpetual') {
		alert("nadknaf")
		callToolTip122('ATC', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}
	
	
	// if ($('#totalpriceforallproduct').val().trim() === '') {
	// callToolTip122('totalpriceforallproduct', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// } else {
	//
	// indexError = 0;
	// }
	
	
	if ($('#clientname').val().trim() === '') {
	
		callToolTip122('clientname', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}

	if (indexError > 0) {
		return false;
	} else {
		return true;
	}

}

var callToolTip122 = function(fieldName, status) {

	if (fieldName == "Proposaltype") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Select Proposal Type  <span>";
	}
	 if (fieldName == "Perpetualyear") {
	 // $("#email").tooltip('destroy');
	 var errorMessage = "<span>Select Perpetual Year <span>";
	 }
	 if (fieldName == "Subscriptionyear") {
	 // $("#email").tooltip('destroy');
	 var errorMessage = "<span>Select Subscription Year <span>";
	 }
	 
	 if (fieldName == "fixedyear") {
		 // $("#email").tooltip('destroy');
		 var errorMessage = "<span>Select Fixed Year <span>";
		 }
	 
	 if (fieldName == "subscriptionANDperpetualYear") {
		 // $("#email").tooltip('destroy');
		 var errorMessage = "<span>Select Subscription & Perpetual Year<span>";
		 }
	 
	 if (fieldName == "manualAmount") {
		 // $("#email").tooltip('destroy');
		 var errorMessage = "<span>Enter Amount <span>";
		 }
	 
	 
	 if (fieldName == "manualProposalFile") {
		 // $("#email").tooltip('destroy');
		 var errorMessage = "<span>Upload File<span>";
		 }
	 
	 
	 
	 
	 
	// if (fieldName == "poinitiator") {
	// // $("#email").tooltip('destroy');
	// var errorMessage = "<span>Enter Maker Name <span>";
	// }
	// if (fieldName == "poinitiatorno") {
	// // $("#email").tooltip('destroy');
	// var errorMessage = "<span>Enter Maker Contact Number <span>";
	// }
	if (fieldName == "FirstApprovername") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Select Checker Name <span>";
	}
	// if (fieldName == "firstapprovercontact") {
	// // $("#email").tooltip('destroy');
	// var errorMessage = "<span>Enter Checker Approver Contact No <span>";
	// }
	// if (fieldName == "secondApprovername") {
	// // $("#email").tooltip('destroy');
	// var errorMessage = "<span>Enter Authorizer Name <span>";
	// }
	//  
	// if (fieldName == "secondapprovercontact") {
	// // $("#email").tooltip('destroy');
	// var errorMessage = "<span>Enter Authorizer Contact Number <span>";
	// }

	if (fieldName == "customerType") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Select Type Of Customer  <span>";
	}

	if (fieldName == "productsuitselect") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Select Product Suite <span>";
	}

	if (fieldName == "productnameaddrow") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Select Product Tool <span>";
	}

	if (fieldName == "Desciption") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter Desciption  <span>";
	}
	if (fieldName == "quantitydata") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter Quantity  <span>";
	}

	if (fieldName == "unitratedata") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter Unit Rate <span>";
	}

	// if (fieldName == "totalpricedata") {
	// // $("#email").tooltip('destroy');
	// var errorMessage = "<span>Enter Total Price <span>";
	// }

	if (fieldName == "deploysupport") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter Deployement support <span>";
	}
	// if (fieldName == "clouddeploycharges") {
	// // $("#email").tooltip('destroy');
	// var errorMessage = "<span>Enter Deployement Charges <span>";
	// }
	if (fieldName == "IntegrationCharges") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Select Integration Charges <span>";
	}
	if (fieldName == "resoucesamount") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter Resources Amount  <span>";
	}
	if (fieldName == "ATC") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Select ATC <span>";
	}

	// if (fieldName == "totalpriceforallproduct") {
	// // $("#email").tooltip('destroy');
	// var errorMessage = "<span>Enter Sub Total <span>";
	// }

	if (fieldName == "newcustomername") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter Customer Name  <span>";
	}
	if (fieldName == "newAddress") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter Address  <span>";
	}
	if (fieldName == "newdistrict") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter District  <span>";
	}
	if (fieldName == "newcity") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter City  <span>";
	}
	if (fieldName == "newpin") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter Pin  <span>";
	}
	if (fieldName == "office_mailid") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Enter Office Mailid  <span>";
	}

	if (fieldName == "clientname") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Select Customer Name  <span>";
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

$('#Proposaltype').on('focus', function() {
	callToolTip122('Proposaltype', 'destroy');

});

 $('#Perpetualyear').on('focus', function() {
 callToolTip122('Perpetualyear', 'destroy');
	
 });
 
 $('#Subscriptionyear').on('focus', function() {
 callToolTip122('Subscriptionyear', 'destroy');
	
 });
 
 
 $('#fixedyear').on('focus', function() {
	 callToolTip122('fixedyear', 'destroy');
		
	 });
 
 $('#subscriptionANDperpetualYear').on('focus', function() {
	 callToolTip122('subscriptionANDperpetualYear', 'destroy');
		
	 });
 
 $('#manualAmount').on('focus', function() {
	 callToolTip122('manualAmount', 'destroy');
		
	 });
 
 
 $('#manualProposalFile').on('focus', function() {
	 callToolTip122('manualProposalFile', 'destroy');
		
	 });

 
// $('#poinitiator').on('focus', function() {
// callToolTip122('poinitiator', 'destroy');
//	
// });
// $('#poinitiatorno').on('focus', function() {
// callToolTip122('poinitiatorno', 'destroy');
//	
// });
 
$('#FirstApprovername').on('focus', function() {
	callToolTip122('FirstApprovername', 'destroy');

});
// $('#firstapprovercontact').on('focus', function() {
// callToolTip122('firstapprovercontact', 'destroy');
//	
// });
// $('#secondApprovername').on('focus', function() {
// callToolTip122('secondApprovername', 'destroy');
//	
// });
//
//
// $('#secondapprovercontact').on('focus', function () {
// callToolTip122('secondapprovercontact', 'destroy');
// });
$('#customerType').on('focus', function() {
	callToolTip122('customerType', 'destroy');
});

$('#productsuitselect').on('focus', function() {
	callToolTip122('productsuitselect', 'destroy');
});

$('#productnameaddrow').on('focus', function() {
	callToolTip122('productnameaddrow', 'destroy');
});
$('#Desciption').on('focus', function() {
	callToolTip122('Desciption', 'destroy');
});
$('#quantitydata').on('focus', function() {
	callToolTip122('quantitydata', 'destroy');
});

$('#unitratedata').on('focus', function() {
	callToolTip122('unitratedata', 'destroy');
});

// $('#totalpricedata').on('focus', function () {
// callToolTip122('totalpricedata', 'destroy');
// });

$('#deploysupport').on('focus', function() {
	callToolTip122('deploysupport', 'destroy');
});

// $('#clouddeploycharges').on('focus', function () {
// callToolTip122('clouddeploycharges', 'destroy');
// });
$('#IntegrationCharges').on('focus', function() {
	callToolTip122('IntegrationCharges', 'destroy');
});
$('#resoucesamount').on('focus', function() {
	callToolTip122('resoucesamount', 'destroy');
});
$('#ATC').on('focus', function() {
	callToolTip122('ATC', 'destroy');
});

// $('#totalpriceforallproduct').on('focus', function () {
// callToolTip122('totalpriceforallproduct', 'destroy');
// });

$('#newcustomername').on('focus', function() {
	callToolTip122('newcustomername', 'destroy');
});
$('#newAddress').on('focus', function() {
	callToolTip122('newAddress', 'destroy');
});
$('#newdistrict').on('focus', function() {
	callToolTip122('newdistrict', 'destroy');
});
$('#newcity').on('focus', function() {
	callToolTip122('newcity', 'destroy');
});

$('#newpin').on('focus', function() {
	callToolTip122('newpin', 'destroy');
});

$('#office_mailid').on('focus', function() {
	callToolTip122('office_mailid', 'destroy');
});
$('#clientname').on('focus', function() {
	callToolTip122('clientname', 'destroy');
});

$("#reset-btn").click(function() {

	$('#Proposaltype').val("");
	 $('#Perpetualyear').val("");
	 $('#Subscriptionyear').val("");
	 $('#manualAmount').val("");
	 $('#fixedyear').val("");
	 $('#subscriptionANDperpetualYear').val("");
	 $('#manualProposalFile').val("");
	 $('#contactperson').val("");
	 
	 
	$('#FirstApprovername').val("");
	$('#customerType').val("");
	$('#productsuitselect').val("");
	$('#productnameaddrow').val("");
	$('#Desciption').val("");
	$('#quantitydata').val("");
	$('#unitratedata').val("");
	// $('#totalpricedata').val("");
	$('#deploysupport').val("");
	// $('#clouddeploycharges').val("");
	$('#IntegrationCharges').val("");
	$('#resoucesamount').val("");
	$('#ATC').val("");
	// $('#totalpriceforallproduct').val("");

	$('#Perpetualyear').val("");
	$('#productsuitselect').val("");
	$('#Description').val("");
	$('#clientname').val("");
	$('#enccustomername').val("");
	$('#clouddeploycharges').val("");

	callToolTip122('Proposaltype', 'destroy');
	 callToolTip122('Perpetualyear', 'destroy');
	 callToolTip122('Subscriptionyear', 'destroy');
	 
	 callToolTip122('manualAmount', 'destroy');
	 callToolTip122('subscriptionANDperpetualYear', 'destroy');
	 callToolTip122('fixedyear', 'destroy');
	 callToolTip122('manualProposalFile', 'destroy');
	 
	callToolTip122('FirstApprovername', 'destroy');
	callToolTip122('customerType', 'destroy');
	// callToolTip122('Description', 'destroy');
	callToolTip122('productsuitselect', 'destroy');
	callToolTip122('productnameaddrow', 'destroy');
	callToolTip122('Desciption', 'destroy');
	callToolTip122('quantitydata', 'destroy');
	callToolTip122('unitratedata', 'destroy');
	// callToolTip122('totalpricedata', 'destroy');
	callToolTip122('deploysupport', 'destroy');
	// callToolTip122('clouddeploycharges', 'destroy');
	callToolTip122('IntegrationCharges', 'destroy');
	callToolTip122('resoucesamount', 'destroy');
	callToolTip122('ATC', 'destroy');
	// callToolTip122('totalpriceforallproduct', 'destroy');
	callToolTip122('clientname', 'destroy');

	callToolTip122('Perpetualyear', 'destroy');
	callToolTip122('productsuitselect', 'destroy');
	callToolTip122('Description', 'destroy');
	callToolTip122('clientname', 'destroy');
	callToolTip122('enccustomername', 'destroy');
	callToolTip122('clouddeploycharges', 'destroy');

});
// -----reset btn

$("#resetbtn").click(function() {
	$("#company").val("");

	$("#mail").val("");
	$("#subject").val("");

	$("#folder").val("");
	$("#port").val("");
	$("#uname").val("");
	$("#pass").val("");

	callToolTip122('poinitiator', 'hide');

	callToolTip122('folder', 'hide');
	callToolTip122('mail', 'hide');
	callToolTip122('subject', 'hide');

	callToolTip122('port', 'hide');
	callToolTip122('uname', 'hide');
	callToolTip122('pass', 'hide');

})

var callToolTip124 = function(fieldName, status) {

	if (fieldName == "companyup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Company Name<span>";

	}

	else if (fieldName == "mailup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Mail-Server<span>";

	}

	else if (fieldName == "subjectup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Subject<span>";

	}

	else if (fieldName == "folderup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Folder To Poll<span>";

	}

	else if (fieldName == "portup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select port <span>";

	} else if (fieldName == "unameup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter User Name <span>";

	} else if (fieldName == "passup") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Password <span>";

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

function submitData() {

	 if (!validatepo()) {
			 
	 event.preventDefault();
	    	
	 } else {

	// alert("zsjhcb");

	SaveVeloxProposal();

}
}

function SaveVeloxProposal() {

	$('#spin2').show();

	// alert("inside save veloxdata :");

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/manualProposalDetailsSubmit";

	
	  var formData= new FormData(form);
		
//		formData.append('addrowdata', addrowdata);


	  $.ajax({
		         type: 'POST',
		         url: serviceUrl,
		         data: formData,
		         mimeType: "multipart/form-data",
		         contentType: false,
		         processData: false,
		         cache: false,
	         		
	         		
	     }).done(function(data) {  

	    	 $('#spin2').hide();
	    	 swal({
					title : "Successfull!",
					// text: "Record Added Successfully",
					html : "VP ID = " + data + "<br><br>Manual Commercial Proposal Sent Successfully",
					type : "success",
					width : 300,
					height : 200,
					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"
								+ l.pathname.split('/')[1];
						window.location.href = base_url
								+ "/User/manualCommercialProposal";
					}
				});
	        
	      
	     });
	  
//	$.ajax(
//			{
//				type : 'POST',
//				url : serviceUrl,
//				data : 'veloxdata=' + encodeURIComponent(veloxdata)
//						+ '&poinitiator='
//						+ encodeURIComponent($("#poinitiator").val())
//						+ '&poinitiatorno='
//						+ encodeURIComponent($("#poinitiatorno").val())
//						+ '&FirstApprovername='
//						+ encodeURIComponent($("#FirstApprovername").val())
//						+ '&firstapprovercontact='
//						+ encodeURIComponent($("#firstapprovercontact").val())
//						+ '&secondApprovername='
//						+ encodeURIComponent($("#secondApprovername").val())
//						+ '&secondapprovercontact='
//						+ encodeURIComponent($("#secondapprovercontact").val())
//						+ '&clientname='
//						+ encodeURIComponent($("#clientname").val())
//						+ '&Description='
//						+ encodeURIComponent($("#Description").val())
//                        + '&ATC=' + encodeURIComponent($("#ATC").val())
//						+ '&Proposaltype='
//						+ encodeURIComponent($("#Proposaltype").val())
//						+ '&Perpetualyear='
//						+ encodeURIComponent($("#Perpetualyear").val())
//						+ '&Subscriptionyear='
//						+ encodeURIComponent($("#Subscriptionyear").val())
//                        + '&productsuitselect='
//						+ encodeURIComponent($("#productsuitselect").val())
//						+ '&Scanplusprodversion='
//						+ encodeURIComponent($("#Scanplusprodversion").val())
//						+ '&fixedyear='
//						+ encodeURIComponent($("#fixedyear").val())
//						+ '&enccustomername='
//						+ encodeURIComponent($("#enccustomername").val())
//						+ '&contactperson='
//						+ encodeURIComponent($("#contactperson").val())
//						+ '&manualAmount='
//						+ encodeURIComponent($("#manualAmount").val())
//						+ '&subscriptionANDperpetualYear='
//						+ encodeURIComponent($("#subscriptionANDperpetualYear").val()),
//			})
//			.done(
//					function(data) {
//						$('#spin2').hide();
//						// if (data == "success") {
//						swal({
//							title : "Successfull!",
//							// text: "Record Added Successfully",
//							html : "Proposal ID = " + data
//									+ "<br><br>  Proposal Sent Successfully",
//							type : "success",
//							width : 300,
//							height : 200,
//							buttons : false,
//							allowOutsideClick : false,
//							preConfirm : function() {
//								var l = window.location;
//								var base_url = l.protocol + "//" + l.host + "/"
//										+ l.pathname.split('/')[1];
//								window.location.href = base_url
//										+ "/User/VeloxProposal";
//							}
//						});
//					});
	
}

function proposalbaseddatashowedperp() {
	var selectedValue = $("#Perpetualyear").val();

	if (selectedValue === "1 year Warranty") {
		$("#subtotalahideid").show();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearsubs").hide();

		$("#atchideidupper").show();
		$("#atchideid").hide();
	} else if (selectedValue === "3 year Warranty") {
		$("#subtotalahideid3yearperp").show();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearsubs").hide();

		$("#atchideidupper").show();
		$("#atchideid").hide();
	} else if (selectedValue === "5 year Warranty") {
		$("#subtotalahideid5yearperp").show();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearsubs").hide();

		$("#atchideidupper").show();
		$("#atchideid").hide();
	}
}

function proposalbaseddatashowedsubs() {
	var selectedValue = $("#Subscriptionyear").val();
	if (selectedValue === "Annual Price") {
		$("#subtotalahideid").show();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();

		$("#atchideidupper").hide();
		$("#atchideid").show();
	} else if (selectedValue === "3 year Subscription") {
		$("#subtotalahideid3yearsubs").show();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();

		$("#atchideidupper").hide();
		$("#atchideid").show();
	}
}

function proposalbaseddatashowedfixedyear() {

	var selectedValue = $("#fixedyear").val();
	if (selectedValue === "3 year Warranty") {
		$("#subtotalahideid3yearfixedd").show();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();

		$("#atchideidupper").show();
		$("#atchideid").hide();
	} else if (selectedValue === "5 year Warranty") {
		$("#subtotalahideid5yearfixed1").show();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();

		$("#atchideidupper").show();
		$("#atchideid").hide();
	} else {
		$("#subtotalahideid5yearfixed1").hide();
		$("#subtotalahideid3yearfixedd").hide();

		$("#atchideidupper").show();
		$("#atchideid").hide();

	}
}
function proposalbaseddatashowedsubsANDperp() {

	var selectedValue = $("#subscriptionANDperpetualYear").val();

	$("#subsANDPerpTbaleHeader").show();

	$("#perpetualSubsAnnualPerpHideDiv").hide();
	$("#perpetualSubs3yearPerpHideDiv").hide();

	if (selectedValue === "Annual Price") {
		$("#subtotalahideid3yearfixedd").hide();
		$("#subtotalahideid").show();
		$("#perpetualSubsAnnualPerpHideDiv").show();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();

		$("#atchideidupper").show();
		$("#atchideid").hide();
	} else if (selectedValue === "3 Year Price") {
		$("#subtotalahideid5yearfixed1").hide();
		$("#subtotalahideid3yearsubs").show();
		$("#perpetualSubs3yearPerpHideDiv").show();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();

		$("#atchideidupper").show();
		$("#atchideid").hide();
	} else {
		$("#subtotalahideid5yearfixed1").hide();
		$("#subtotalahideid3yearfixedd").hide();
		$("#perpetualSubsAnnualperpType").hide();
		$("#perpetualSubs3yearperpType").hide();
		$("#atchideidupper").hide();
		$("#atchideid").hide();

	}
}

function proposaltypedata() {
	var selectedValue = $("#Proposaltype").val();

	var selectedperpetual = $("#Perpetualyear").val();
	var selectedSubscription = $("#Subscriptionyear").val();

	$("#subsANDPerpTbaleHeader").hide();
	$("#addRowProductPerpSubsHideDiv").hide();
	$("#perpetualSubsAnnualPerpHideDiv").hide();
	$("#perpetualSubs3yearPerpHideDiv").hide();
	$("#chargesForPerpetualType").hide();
	$("#subscriptionANDperpetualhideid").hide();

	if (selectedValue === "Perpetual") {
		$("#perpetualhideid").show();
		$("#subscriptionhideid").hide();
		$("#fixedhideid").hide();

		$("#AMCSTARTENDHIDEID").hide();
		$("#productsuitandtoolhideid").hide();

		$("#addrowhideidforamc").show();
		$("#chargesforAllPropType").show();

		$("#subtotalahideidforResource").hide();

		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearfixedd").hide();
		$("#subtotalahideid5yearfixed1").hide();

	} else if (selectedValue === "Subscription") {
		$("#subscriptionhideid").show();
		$("#perpetualhideid").hide();
		$("#fixedhideid").hide();

		$("#AMCSTARTENDHIDEID").hide();
		$("#productsuitandtoolhideid").hide();

		$("#addrowhideidforamc").show();
		$("#chargesforAllPropType").show();
		$("#subtotalahideidforResource").hide();

		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearfixedd").hide();
		$("#subtotalahideid5yearfixed1").hide();
	} else if (selectedValue === "Fixed") {
		$("#subscriptionhideid").hide();
		$("#perpetualhideid").hide();
		$("#fixedhideid").show();

		$("#AMCSTARTENDHIDEID").hide();
		$("#productsuitandtoolhideid").hide();

		$("#addrowhideidforamc").show();
		$("#chargesforAllPropType").show();

		$("#subtotalahideidforResource").hide();

		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearfixedd").hide();
		$("#subtotalahideid5yearfixed1").hide();
	} else if (selectedValue === "AMC") {

		$("#productsuitandtoolhideid").show();

		$("#AMCSTARTENDHIDEID").show();
		$("#subscriptionhideid").hide();
		$("#perpetualhideid").hide();
		$("#fixedhideid").hide();

		$("#addrowhideidforamc").hide();
		$("#chargesforAllPropType").hide();

		$("#subtotalahideidforResource").hide();

		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearfixedd").hide();
		$("#subtotalahideid5yearfixed1").hide();
	} else if (selectedValue === "Resource") {
		$("#addrowhideidforamc").show();

		$("#subtotalahideidforResource").show();

		// $("#addRowButton").hide();
		$("#productsuitandtoolhideid").hide();
		$("#AMCSTARTENDHIDEID").hide();
		$("#subscriptionhideid").hide();
		$("#perpetualhideid").hide();
		$("#fixedhideid").hide();
		$("#chargesforAllPropType").hide();

		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearfixedd").hide();
		$("#subtotalahideid5yearfixed1").hide();

		$("#subtotalahideid").hide();

		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearfixedd").hide();
		$("#subtotalahideid5yearfixed1").hide();
	} else if (selectedValue === "Subscription & Perpetual") {

		// alert("dgjb");
		$("#subscriptionANDperpetualhideid").show();
		$("#addrowhideidforamc").show();
		$("#chargesforAllPropType").show();
		$("#chargesForPerpetualType").show();
		$("#addRowProductPerpSubsHideDiv").show();

		$("#subscriptionhideid").hide();
		$("#perpetualhideid").hide();
		$("#fixedhideid").hide();
		$("#AMCSTARTENDHIDEID").hide();
		$("#productsuitandtoolhideid").hide();
		$("#addrowhideidforamc").show();
		$("#chargesforAllPropType").show();
		$("#subtotalahideidforResource").hide();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearfixedd").hide();
		$("#subtotalahideid5yearfixed1").hide();
	}

	else {

		$("#subscriptionhideid").hide();
		$("#perpetualhideid").hide();
		$("#fixedhideid").hide();
		$("#AMCSTARTENDHIDEID").hide();

	}

}

function integrationcharge() {

	var selectedValue = $("#IntegrationCharges").val();

	var selectedValue21 = $("#IntegrationCharges21").val();

	if (selectedValue === 'Yes') {
		$("#integrationhideid").show();
	} else if (selectedValue === 'No') {
		$("#integrationhideid").hide();
	} else {
		$("#integrationhideid").hide();

	}

	if (selectedValue21 === 'Yes') {
		$("#integrationhideid21").show();
	} else if (selectedValue21 === 'No') {
		$("#integrationhideid21").hide();
	} else {

		$("#integrationhideid21").hide();
	}
}
function getCustomerType() {
	var customerType = $('#customerType').val();

	if (customerType === 'Registered') {
		$("#registeredCustomerdiv").show();
		$("#notregisteredCustomerdiv1").hide();
		// $("#notregisteredCustomerdiv2").hide();
		// $("#notregisteredCustomerdiv3").hide();
		$("#addCustomerDataDiv").hide();
	} else if (customerType === 'Not Registered') {
		$("#registeredCustomerdiv").hide();
		$("#notregisteredCustomerdiv1").show();
		// $("#notregisteredCustomerdiv2").show();
		// $("#notregisteredCustomerdiv3").show();
		$("#addCustomerDataDiv").show();

	} else {
		$("#notregisteredCustomerdiv1").hide();
		// $("#notregisteredCustomerdiv2").hide();
		// $("#notregisteredCustomerdiv3").hide();
		$("#registeredCustomerdiv").hide();
		$("#addCustomerDataDiv").hide();
	}

}

function customerData() {

	if (!validatecustomerData()) {
		event.preventDefault();
	} else {

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/"
				+ l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/newCustomerDetails";

		var serviceUrl = serviceUrl;
		$.ajax(
				{
					type : 'POST',
					url : serviceUrl,
					data : 'compname='
							+ encodeURIComponent($("#newcustomername").val())
							+ '&address='
							+ encodeURIComponent($("#newAddress").val())
							+ '&city='
							+ encodeURIComponent($("#newcity").val())
							+ '&district='
							+ encodeURIComponent($("#newdistrict").val())
							+ '&pincode='
							+ encodeURIComponent($("#newpin").val())
							+ '&office_mailid='
							+ encodeURIComponent($("#office_mailid").val()),

				}).done(
				function(data) {

					if (data == "success") {
						swal({
							title : "Successfull!",
							text : "Customer Added Successfully",
							type : "success",
							width : 300,
							height : 200,
							buttons : false,
							allowOutsideClick : false,
							preConfirm : function() {
								var l = window.location;
								var base_url = l.protocol + "//" + l.host + "/"
										+ l.pathname.split('/')[1];
								window.location.href = base_url
										+ "/User/manualCommercialProposal";
							}

						});

					} else if (data == "duplicate") {
						swal({
							title : "Duplicate Data!",
							text : "Customer Already Exists",
							type : "warning",
							width : 300,
							height : 200,
							buttons : false,
							allowOutsideClick : false,
							preConfirm : function() {
								var l = window.location;
								var base_url = l.protocol + "//" + l.host + "/"
										+ l.pathname.split('/')[1];
								window.location.href = base_url
										+ "/User/manualCommercialProposal";
							}

						})

					} else if (data == "error") {
						swal({
							title : "Unsuccessful!",
							text : "Fail to add Customer",
							type : "success",
							width : 300,
							height : 200,

							buttons : false,
							allowOutsideClick : false,
							preConfirm : function() {
								var l = window.location;
								var base_url = l.protocol + "//" + l.host + "/"
										+ l.pathname.split('/')[1];
								window.location.href = base_url
										+ "/User/manualCommercialProposal";
							}

						});

					}

					$("#notregisteredCustomerdiv1").hide();
					// $("#notregisteredCustomerdiv2").hide();
					// $("#notregisteredCustomerdiv3").hide();
					$("#registeredCustomerdiv").hide();
					$("#addCustomerDataDiv").hide();
					$("#customerType").val("");
					$("#newcustomername").val("");
					$("#newAddress").val("");
					$("#newdistrict").val("");
					$("#newcity").val("");
					$("#newpin").val("");
					$("#office_mailid").val("");

				});

	}

}

$("#reset-Customer-btn").click(function() {

	$('#newcustomername').val("");
	$('#newAddress').val("");
	$('#newdistrict').val("");
	$('#newcity').val("");
	$("#newpin").val("");
	$("#office_mailid").val("");

	callToolTip122('newcustomername', 'destroy');
	callToolTip122('newAddress', 'destroy');
	callToolTip122('newdistrict', 'destroy');
	callToolTip122('newcity', 'destroy');
	callToolTip122('newpin', 'destroy');
	callToolTip122('office_mailid', 'destroy');

});

function validatecustomerData() {

	var indexError = 0;

	if ($('#newcustomername').val().trim() === '') {
		callToolTip122('newcustomername', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}

	if ($('#newAddress').val().trim() === '') {
		callToolTip122('newAddress', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}

	if ($('#newdistrict').val().trim() === '') {
		callToolTip122('newdistrict', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}

	if ($('#newcity').val().trim() === '') {
		callToolTip122('newcity', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}

	if ($('#newpin').val().trim() === '') {
		callToolTip122('newpin', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}

	if ($('#office_mailid').val().trim() === '') {
		callToolTip122('office_mailid', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	} else {

		indexError = 0;
	}

	if (indexError > 0) {
		return false;
	} else {
		return true;
	}

}

function getCheckerNo() {

	var checkerApprovername = $('#FirstApprovername').val();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getCheckerContactNo";

	$.ajax({

		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : 'checkerApprovername=' + checkerApprovername,
	}).done(function(data) {

		// alert(data);
		// alert( data[0]["PHONE"] );

		$('#firstapprovercontact').val(data[0]["PHONE"]);

	});

}

function validateEmailOffice() {
	// alert("HIH")
	// Get the value from the input field
	var email = document.getElementById("office_mailid").value;

	// Regular expression pattern for a valid email address
	var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,}$/;

	// Check if the email matches the pattern
	// if (emailPattern.test(email)) {
	// document.getElementById("emailErrorOfficegreen").textContent = "Valid
	// Format"; // Clear any previous error message
	// $('#emailErrorOfficered').hide();
	// $('#emailErrorOfficegreen').show();
	// } else {
	// document.getElementById("emailErrorOfficered").textContent = "Invalid
	// Format";
	// $('#emailErrorOfficegreen').hide();
	// $('#emailErrorOfficered').show();
	// }
}

function validatetepin() {
	// alert("HIH")
	// Get the value from the input field
	var pincode = document.getElementById("newpin").value;

	// Regular expression pattern for a valid email address
	var pincodePattern = /^\d{6}$/;

	// Check if the email matches the pattern
	// if (pincodePattern.test(pincode)) {
	// document.getElementById("pincodegreen").textContent = "Valid Format"; //
	// Clear any previous error message
	// $('#pincodered').hide();
	// $('#pincodegreen').show();
	// } else {
	// document.getElementById("pincodered").textContent = "Invalid Format";
	// $('#pincodegreen').hide();
	// $('#pincodered').show();
	// }
}
//function productsuit() {
//	var selectedValue = $("#productsuitselect").val();
//	if (selectedValue === 'ScanPlus') {
//		$("#hideScanplus").show();
//		$("#hideSecureIT").hide();
//		$("#hideAsetGrid").hide();
//		$("#hidePlsanetGuard").hide();
//	} else if (selectedValue === 'SecureIT') {
//		$("#hideSecureIT").show();
//		$("#hideScanplus").hide();
//		$("#hideAssetGrid").hide();
//		$("#hidePlanetGuard").hide();
//	} if (selectedValue === 'AssetGrid') {
//		$("#hideAssetGrid").show();
//		$("#hideScanplus").hide();
//		$("#hideSecureIT").hide();
//		$("#hidePlanetGuard").hide();
//	} else if (selectedValue === 'PlanetGuard') {
//		$("#hidePlanetGuard").show();
//		$("#hideScanplus").hide();
//		$("#hideSecureIT").hide();
//		$("#hideAssetGrid").hide();
//	}else {
//		$("#hideScanplus").hide();
//		$("#hideSecureIT").hide();
//		$("#hideAsetGrid").hide();
//		$("#hidePlsanetGuard").hide();
//	}
//}


function productsuit() {
    var selectedValue = $("#productsuitselect").val();
    // Hide all first
    $("#hideScanplus").hide();
    $("#hideSecureIT").hide();
    $("#hideAssetGrid").hide();
    $("#hidePlanetGuard").hide();

    // Show the selected one
    if (selectedValue === 'ScanPlus') {
        $("#hideScanplus").show();
    } else if (selectedValue === 'SecureIT') {
        $("#hideSecureIT").show();
    } else if (selectedValue === 'AssetGrid') {
        $("#hideAssetGrid").show();
    } else if (selectedValue === 'PlanetGuard') {
        $("#hidePlanetGuard").show();
    }
}

function sectools() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getprodsuit";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			// ASYNC : FALSE,
			})
			.done(
					function(data) {
						console.log(data)

						var html = " <select class='form-control' tabindex='9' id='productsuitdetails' name='productsuitdetails'   >";

						html = html
								+ '<option value="">--Please Select Product Suit--</option>';

						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("productsuitdetails").innerHTML = html;

					});
}



//function validMNumber() {
//    var mobileNumber = document.getElementById("contactperson").value;
//
//    var mobileNumberPattern = /^\d{10}$/;
//
//    if (mobileNumberPattern.test(mobileNumber)) {
//        document.getElementById("mobileNumberError").textContent = "Valid Format";
//        document.getElementById("mobileNumberError").style.color = "green"; // Change text color for valid input
//    } else {
//        document.getElementById("mobileNumberError").textContent = "Invalid Format";
//        document.getElementById("mobileNumberError").style.color = "red"; // Change text color for invalid input
//    }
//}



function validMNumber(event) {
    var charCode = event.which ? event.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        event.preventDefault();
    }
}


function securitydetailforamc() {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";

	$
			.ajax(
					{
						type : 'POST',
						url : serviceUrl,
						dataType : 'JSON',
						data : 'productsuit='
								+ encodeURIComponent($("#productsuitdetails")
										.val())
					})
			.done(
					function(data2Array) {
						var html = "<option value=''> -- Please Select --</option>";
						for (var i = 0; i < data2Array.length; i++) {
							html += '<option value="' + data2Array[i] + '">'
									+ data2Array[i] + '</option>';
						}
						document.getElementById("securitysolutiondetails").innerHTML = html;
					});

}



function proposalFor() {
	
//	alert("proposal")
	
	if($('#proposal_For').val() == "Distributor")
	{
		$('#hidePartnerName').show();
	}
	else
	{
		$('#hidePartnerName').hide();
	}
	
}
