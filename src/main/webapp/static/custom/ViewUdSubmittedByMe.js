$('#generateMeetingDiv').hide();

$(document)
		.ready(
				function() {
					$(document)
							.ready(
									function() {
										$("#meetingResource")
												.multiselect(
														{
															includeSelectAllOption : true,
															buttonWidth : '100%',
															enableFiltering : true,
															enableCaseInsensitiveFiltering : true,
															maxHeight : 200
														});
										$("#vpresourcemeeting")
												.multiselect(
														{
															includeSelectAllOption : true,
															buttonWidth : '100%',
															enableFiltering : true,
															enableCaseInsensitiveFiltering : true,
															maxHeight : 200
														});

										$("#meetingTypes")
												.multiselect(
														{
															includeSelectAllOption : true,
															buttonWidth : '100%',
															enableFiltering : true,
															enableCaseInsensitiveFiltering : true,
															maxHeight : 200
														});
										var l = window.location;
										var base_url = l.protocol + "//"
												+ l.host + "/"
												+ l.pathname.split('/')[1];
										var serviceUrl = base_url
												+ "/PMS/getSalesManager";

										$
												.ajax({
													type : 'POST',
													url : serviceUrl,
													dataType : 'json',
													success : function(data4) {
														var html = '';
														for (var i = 0; i < data4.length; i++) {
															var value = data4[i];
															html += '<option value="'
																	+ value
																	+ '">'
																	+ value
																	+ '</option>';
														}

														// Set the HTML content
														// of the dropdown
														$("#salemgr")
																.html(html);

														// Initialize the
														// Bootstrap Multiselect
														$("#salemgr")
																.multiselect(
																		{
																			includeSelectAllOption : true,
																			buttonWidth : '100%',
																			enableFiltering : true,
																			enableCaseInsensitiveFiltering : true,
																			maxHeight : 200
																		});

													}
												});

										var l = window.location;
										var base_url = l.protocol + "//"
												+ l.host + "/"
												+ l.pathname.split('/')[1];
										var serviceUrl = base_url
												+ "/PMS/getProjectHead";

										$
												.ajax({
													type : 'POST',
													url : serviceUrl,
													dataType : 'json',
													success : function(data4) {
														var html = '';
														for (var i = 0; i < data4.length; i++) {
															var value = data4[i];
															html += '<option value="'
																	+ value
																	+ '">'
																	+ value
																	+ '</option>';
														}

														// Set the HTML content
														// of the dropdown
														$("#projhead").html(
																html);

														// Initialize the
														// Bootstrap Multiselect
														$("#projhead")
																.multiselect(
																		{
																			includeSelectAllOption : true,
																			buttonWidth : '100%',
																			enableFiltering : true,
																			enableCaseInsensitiveFiltering : true,
																			maxHeight : 200
																		});

													}
												});

										var l = window.location;
										var base_url = l.protocol + "//"
												+ l.host + "/"
												+ l.pathname.split('/')[1];
										var serviceUrl = base_url
												+ "/PMS/getProductionManager";
										var selectedValue = $("#prodmgr").val(); // Get
										// the
										// currently
										// selected value

										$
												.ajax({
													type : 'POST',
													url : serviceUrl,
													dataType : 'json',
													success : function(data4) {

														// alert("Prod Manager
														// "+data4)
														var html = '';
														for (var i = 0; i < data4.length; i++) {
															var value = data4[i];
															html += '<option value="'
																	+ value
																	+ '">'
																	+ value
																	+ '</option>';
														}
														$("#prodmgr")
																.html(html);

														// Initialize the
														// multi-select dropdown
														// after populating
														// options
														// Initialize the
														// Bootstrap Multiselect
														$("#prodmgr")
																.multiselect(
																		{
																			includeSelectAllOption : true,
																			buttonWidth : '100%',
																			enableFiltering : true,
																			enableCaseInsensitiveFiltering : true,
																			maxHeight : 200
																		});

													}
												});

										var l = window.location;
										var base_url = l.protocol + "//"
												+ l.host + "/"
												+ l.pathname.split('/')[1];
										var serviceUrl = base_url
												+ "/PMS/getroomdetails";
										var selectedValue = $("#typeofrm")
												.val(); // Get the currently
										// selected value

										$
												.ajax({
													type : 'POST',
													url : serviceUrl,
													dataType : 'json',
													success : function(data4) {
														var html = '';
														for (var i = 0; i < data4.length; i++) {
															var value = data4[i];
															html += '<option value="'
																	+ value
																	+ '">'
																	+ value
																	+ '</option>';
														}
														$("#typeofrm").html(
																html);

														// Initialize the
														// multi-select dropdown
														// after populating
														// options
														// Initialize the
														// Bootstrap Multiselect
														$("#typeofrm")
																.multiselect(
																		{
																			includeSelectAllOption : true,
																			buttonWidth : '100%',
																			enableFiltering : true,
																			enableCaseInsensitiveFiltering : true,
																			maxHeight : 200
																		});

													}
												});

									});
				});

function dropdownChanged(data) {
	// alert("HIH"+data)

	if (data == "Physical Mode") {
		// alert("hih")
		$('#physicalmodes').show();
		$('#virtualmodes').hide();
		$('#virtualmodestype').hide();
		$('#generateMeetingDiv').hide();
		$('#selectTypes').show();
	}

	else {
		$('#virtualmodes').show();
		$('#virtualmodestype').show();

		$('#physicalmodes').hide();
		$('#selectTypes').hide();

	}
}

function submitData() {
	event.preventDefault();

	$('#spin1').show();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/SavePKMeeting";

	var formData = new FormData(form);

	// Append the value of salemgr to formData
	let selectedValues = [];

	// Get the reference to the multi-select dropdown (e.g., salemgr)
	let dropdown = document.getElementById("salemgr");

	// Iterate through each option and check if it is selected
	for (let i = 0; i < dropdown.options.length; i++) {
		if (dropdown.options[i].selected) {
			// Push the selected value into the array
			selectedValues.push(dropdown.options[i].value);
		}
	}

	// Convert the array to a JSON string
	let selectedValuesString = JSON.stringify(selectedValues);

	// Append the selected values string to formData
	formData.append('selectedValues', selectedValuesString);

	// Display the selected values
	console.log("Selected Values: " + selectedValuesString);
//	alert("selectedValuesString" + selectedValuesString)
//	alert("selectedValuesString" + $('#salemgr').val())

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		data : formData,
		mimeType : "multipart/form-data",
		contentType : false,
		processData : false,
		cache : false,
	}).done(
			function(data) {
				$('#spin1').hide();
//				alert("adsadsad" + data);

				swal({
					title : "Successful!",
					html : "Project ID = " + data
							+ "<br><br>Data Saved Successfully",
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
								+ "/Admin/ProjectMeeting";
					}
				});
			});
}

var meetingLink = ""; // Declare meetingLink in a broader scope

function meetingPlatform() {
	var selectedPlatform = "";
	selectedPlatform = $("#meetingTypesvideo").val();
	$('#generateMeetingDiv').show();

	if (selectedPlatform == "zoom") {
		meetingLink = "https://zoom.com";
	} else if (selectedPlatform == "teams") {
		meetingLink = "https://teams.com";
	} else if (selectedPlatform == "webex") {
		meetingLink = "https://webex.com";
	} else if (selectedPlatform == "GMeet") {
		meetingLink = "https://workspace.google.com/products/meet/";
	} else {
		meetingLink = "https://google.com";
	}

	$("#link").val();
	// alert("ada " + meetingLink);
}

function generateMeetingLink() {

	// window.location.href = String(meetingLink);
	window.open(meetingLink);
}

window.onload = function() {

	// RD details

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getRDdetails";
	var selectedValue1 = $("#uid").val(); // Get the currently
	// alert("uid" + selectedValue1) // selected value
//	alert("uid"+$("#uid").val())
//	alert("crnoo"+$("#crnoo").val())
	$
			.ajax({
				type : 'POST',
				url : serviceUrl,
				dataType : 'json',
				data : 'uid=' + selectedValue1
				+ '&crno=' + $("#crnoo").val(),// $("#documentType2").val(),
				success : function(data1) {
					
//					alert("dataa111"+data1[0][1])
					var aaa = data1[0];
					
				//	alert("maskedfile"+data1[0][7])
				//	alert("rd Up"+data1[0][6])
					var Stool = aaa[0][15];
					// alert("AAAAA data::::::"+aaa)
//					$('#functionName').val(decodeURIComponent(data1[0][4]));
					$('#poNumber').val(decodeURIComponent(data1[0][0]));

					$('#producSuiteNames').val(decodeURIComponent(data1[0][1]));
					$('#Securitytool').val(decodeURIComponent(data1[0][2]));
					$('#managerName').val(decodeURIComponent(data1[0][3]));
					$('#rdNote').val(decodeURIComponent(data1[0][5]));

					if ((decodeURIComponent(data1[0][6]) == "File Not Attached" || decodeURIComponent(data1[0][6]) == "undefined")
							|| (decodeURIComponent(data1[0][6]) == "NA")
							|| (decodeURIComponent(data1[0][6]) == "null")) {
						$('#rdUploadDiv').hide();
					} else {
						document.getElementById('rduploadfile').innerHTML = decodeURIComponent(data1[0][6]);
						document.getElementById('udFileStandard').value = decodeURIComponent(data1[0][6]);
						$('#rdUploadDiv').show();
					}
					
					if ((decodeURIComponent(data1[0][7]) == "File Not Attached" || decodeURIComponent(data1[0][7]) == "undefined")
							|| (decodeURIComponent(data1[0][7]) == "NA")
							|| (decodeURIComponent(data1[0][7]) == "null")) {
						$('#maskedUploadDiv').hide();
					} else {
						document.getElementById('maskeduploadfile').innerHTML = decodeURIComponent(data1[0][7]);
						document.getElementById('masekdfileStandard').value = decodeURIComponent(data1[0][7]);
						$('#maskedUploadDiv').show();
					}
//					New File Impl
					if ((decodeURIComponent(aaa[8]) == "File Not Attached" || decodeURIComponent(aaa[8]) == "undefined")
							|| (decodeURIComponent(aaa[8]) == "NA")
							|| (decodeURIComponent(aaa[8]) == "null")|| (decodeURIComponent(aaa[8]) == "")) {
						$('#scopeUploadDiv').hide();
					} else {
						document.getElementById('scopeuploadfile').innerHTML = decodeURIComponent(aaa[8]);
						document.getElementById('downHidescopefile').value = decodeURIComponent(aaa[8]);
						$('#scopeUploadDiv').show();
					}

					if ((decodeURIComponent(aaa[9]) == "File Not Attached" || decodeURIComponent(aaa[9]) == "undefined")
							|| (decodeURIComponent(aaa[9]) == "NA")
							|| (decodeURIComponent(aaa[9]) == "null")|| (decodeURIComponent(aaa[9]) == "")) {
						$('#RFPUploadDiv').hide();
					} else {
						document.getElementById('RFPuploadfile').innerHTML = decodeURIComponent(aaa[9]);
						document.getElementById('downHideRFPfile').value = decodeURIComponent(aaa[9]);
						$('#RFPUploadDiv').show();
					}
					
					if ((decodeURIComponent(aaa[10]) == "File Not Attached" || decodeURIComponent(aaa[10]) == "undefined")
							|| (decodeURIComponent(aaa[10]) == "NA")
							|| (decodeURIComponent(aaa[10]) == "null")|| (decodeURIComponent(aaa[10]) == "")) {
						$('#otherUploadDiv').hide();
					} else {
						document.getElementById('otheruploadfile').innerHTML = decodeURIComponent(aaa[10]);
						document.getElementById('downHideotherfile').value = decodeURIComponent(aaa[10]);
						$('#otherUploadDiv').show();
					}

				}
			});

	// UD Details

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getProjectKickMeetingTable";
	$('#spin12').show();
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {

			$('#spin12').hide();
			var table = $('#PKMDetails').DataTable({
				lengthChange : false,
				data : data4,
				"pageLength" : 5,
				scrollX : '300px'
			});

		}

	});

	$('#spin1').hide();
	$('#uploadfileform').hide();

	// UD Details Table
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getUdDetailsTable";
	$('#spin12').show();
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {

			$('#spin12').hide();
			var table = $('#UDDetails').DataTable({
				lengthChange : false,
				data : data4,
				"pageLength" : 5,
				scrollX : '300px'
			});
		}
	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getUDDetails";
	// alert("cr "+ $('#crnoo').val());
	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : 'crno=' + $("#crnoo").val() + '&uid=' + $("#uid").val(),
			})
			.done(
					function(data) {

//						 alert("data" + data)

						var aaa = data[0];
						console.log(data)
						// //alert("hhhhh"+data[0][0])

						// $('#pouploadfile').val(data[0][0]);

						$('#Teamlead').val(decodeURIComponent(aaa[0]));
						// alert("po type :: "
						// +aaa[3])
						$('#Developers').val(decodeURIComponent(aaa[1]));
						// alert("ponumber :: "
						// +aaa[3])
						$('#note').val(decodeURIComponent(aaa[2]));
						if ((decodeURIComponent(aaa[3]) == "File Not Attached")
								|| (decodeURIComponent(aaa[3]) == "NA")
								|| (decodeURIComponent(aaa[3]) == "null")) {
							$('#UdUploadDiv').hide();
						} else {
							document.getElementById('udUploadfile').innerHTML = decodeURIComponent(aaa[3]);
							document.getElementById('udFileStandard').value = decodeURIComponent(aaa[3]);
							$('#UdUploadDiv').show();
						}
						$('#projectDesc').val(decodeURIComponent(aaa[4]));
						$('#projectObj').val(decodeURIComponent(aaa[5]));
						$('#projectScope').val(decodeURIComponent(aaa[6]));
						$('#funcReq').val(decodeURIComponent(aaa[7]));
						$('#nonFuncReq').val(decodeURIComponent(aaa[8]));
						$('#techReq').val(decodeURIComponent(aaa[9]));
						$('#startDate').val(decodeURIComponent(aaa[10]));
						$('#endDate').val(decodeURIComponent(aaa[11]));
						if ((decodeURIComponent(aaa[12]) == "File Not Attached")
								|| (decodeURIComponent(aaa[12]) == "NA")
								|| (decodeURIComponent(aaa[12]) == "null")) {
							$('#otherFileDiv').hide();
						} else {
							document.getElementById('otherFile').innerHTML = decodeURIComponent(aaa[12]);
							document.getElementById('otherFileStandard').value = decodeURIComponent(aaa[12]);
							$('#otherFileDiv').show();
						}
						
						

					});

}

// files
function downFileStandard() {
	event.preventDefault();
	// alert("download")
	var filename = encodeURIComponent($('#udFileStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}

function maskedStandard() {
	event.preventDefault();
	var filename = encodeURIComponent($('#masekdfileStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}

function UDStandard() {
	event.preventDefault();
	var filename = encodeURIComponent($('#udFileStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}

function scopefileDownload() {
	event.preventDefault();
	var filename = encodeURIComponent($('#downHidescopefile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}


function RFPfileDownload() {
	event.preventDefault();
	var filename = encodeURIComponent($('#downHideRFPfile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

function otherfileDownload() {
	event.preventDefault();
	var filename = encodeURIComponent($('#downHideotherfile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

function OtherUDStandard() {
	event.preventDefault();
	var filename = encodeURIComponent($('#otherFileStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}




