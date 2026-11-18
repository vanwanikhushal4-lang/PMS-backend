/**
 * 
 */

var subcategory = "";
var statusCI = "";


window.onload = function() {

	$('.nav-tabs a').click(function() {
		$(this).tab('show');
	});


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getProposalLicenseDataBH";

	$.ajax({
		url: serviceUrl,
		type: 'POST',
		dataType: 'json',
		data: "crno=" + $('#crnoo').val()
			+ '&tid=' + $("#tid").val()
	}).done(function(data) {

		var aaa = data[0];
		
		console.log(data);

		$('#clientname').val(decodeURIComponent(data[0][0]));
		$('#clientAddress').val(decodeURIComponent(data[0][1]));
		$('#EnvironmentKeyNo').val(decodeURIComponent(data[0][2]));
		$('#ponumber').val(decodeURIComponent(data[0][3]));
		$('#podate').val(decodeURIComponent(data[0][4]));
		$('#endcostomername').val(decodeURIComponent(data[0][5]));
$('#endCustomerEmail').val(decodeURIComponent(data[0][6]));
		
		
		if ((aaa[7] == "File Not Attached") || (aaa[7] == "NA") || (aaa[7] == "null")) {
			$('#downHidepofile').hide();
		} else {
			document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[7]);
			document.getElementById('filenameStandard').value = decodeURIComponent(aaa[7]);
			$('#poUploadDiv').show();
		}

		$('#paymentReceived').val(decodeURIComponent(data[0][10]));
		
         $('#viewdataLicenseCreatedTable').show();
			var table = $('#viewdataLicenseCreatedTable').DataTable({
				lengthChange: false,
				pageLength: 5,
				data: aaa[8],
				dataType: 'json',
				scrollX: '300px',
			});
			
			
			if (decodeURIComponent(aaa[9]) === 'NA') {
				$('#SMnoteDiv').hide();
			} else {
				$('#SMnote').val(decodeURIComponent(aaa[9]));
				$('#SMnoteDiv').show();
			}


	});

}


function downFileStandard() {
	var filename = encodeURIComponent($('#filenameStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename=" + filename;

}





function advInvFileStandard() {
	var filename = encodeURIComponent($('#filnameAdvinvoice').val());

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
		+ filename;

}

$("#ApproveBH").click(
		function() {
			


			$('#spin1').show();

			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/"
					+ l.pathname.split('/')[1];
			var serviceUrl = base_url
					+ "/UserActivity/ApproveProposalLicenseBH";

			$.ajax(
					{
						url : serviceUrl,
						type : 'POST',
						data : "crno=" + $('#crnoo').val() + "&tid="
								+ $('#tid').val() + "&BHnote="
								+ encodeURIComponent($('#BHnote').val()),

					}).done(
					function(data) {
						$('#spin1').hide();
						if (data === "success") {
							swal({
								title : "Successful!",
								text : "License Agreement Approved Successfully",
								type : "success",
								width : 300,
								height : 200,
								confirmButtonClass : "btn btn-success",
								cancelButtonClass : "btn btn-danger m-l-10",
								confirmButtonText : "OK",
								preConfirm : function() {
									var l = window.location;
									var base_url = l.protocol + "//" + l.host
											+ "/" + l.pathname.split('/')[1];
									window.location.href = base_url
											+ "/User/pendingProposalLicenseBH";
								}
							})
						} else {
							swal({
								title : "Fail!",
								text : "License Agreement Approved UnSuccessful",
								type : "error",
								width : 300,
								height : 200,
								// showCancelButton: !0,
								confirmButtonClass : "btn btn-success",
								cancelButtonClass : "btn btn-danger m-l-10",
								confirmButtonText : "OK",
								preConfirm : function() {
									var l = window.location;
									var base_url = l.protocol + "//" + l.host
											+ "/" + l.pathname.split('/')[1];
									window.location.href = base_url
											+ "/User/pendingProposalLicenseBH";
								}

							})
						}

					});
		
		});

function rejectFunction() {

	swal({
		title : 'Enter Your Reason',
		input : 'textarea',
		inputPlaceholder : "Enter Your Reason",
		showCancelButton : true,
		confirmButtonText : 'Submit',
		preConfirm : function(result) {
			// alert("value: "+result)
			return new Promise(
					function(resolve, reject) {

						if (result === "") {
							swal
									.showValidationError('You Need To Write Your Reason!')

							$('.swal2-confirm').prop('disabled', false);
							$('.swal2-cancel').prop('disabled', false);
							return false;
						} else {
							swal.resetValidationError()

							$('#spin2').show();

							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							var serviceUrl = base_url
									+ "/UserActivity/rejectedProposalLicenseBH";

							$
									.ajax(
											{
												type : "POST",
												url : serviceUrl,
												data : "val="
														+ encodeURIComponent(result)
														+ "&crno="
														+ $('#crnoo').val()
														+ "&tid="
														+ $('#tid').val()
														+ "&SMnote="
														+ encodeURIComponent($(
																'#SMnote')
																.val()),

											})
									.done(
											function(data) {
												$('#spin2').hide();
												if (data == "success") {
													swal({
														title : "Successful!",
														text : "Proposal License Rejected Successfully",
														type : "success",
														width : 300,
														height : 200,
														confirmButtonClass : "btn btn-success",
														confirmButtonText : "OK",
														preConfirm : function() {
															var l = window.location;
															var base_url = l.protocol
																	+ "//"
																	+ l.host
																	+ "/"
																	+ l.pathname
																			.split('/')[1];
															window.location.href = base_url
																	+ "/User/pendingProposalLicenseBH";
														}
													})
												} else {
													swal({
														title : "Fail!",
														text : "Proposal License Rejected UnSuccessful",
														type : "error",
														width : 300,
														height : 200,
														confirmButtonClass : "btn btn-success",
														confirmButtonText : "OK",
														preConfirm : function() {
															var l = window.location;
															var base_url = l.protocol
																	+ "//"
																	+ l.host
																	+ "/"
																	+ l.pathname
																			.split('/')[1];
															window.location.href = base_url
																	+ "/User/pendingProposalLicenseBH";
														}
													})
												}
											});
						}

						resolve(result)

					})
		}
	})

}

