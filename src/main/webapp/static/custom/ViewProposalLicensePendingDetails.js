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
	var serviceUrl = base_url + "/UserActivity/getProposalLicenseDataSM";

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
		
		
		$('#paymentReceived').val(decodeURIComponent(data[0][9]));
		
		
		if ((aaa[7] == "File Not Attached") || (aaa[7] == "NA") || (aaa[7] == "null")) {
			$('#downHidepofile').hide();
		} else {
			document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[7]);
			document.getElementById('filenameStandard').value = decodeURIComponent(aaa[7]);
			$('#poUploadDiv').show();
		}

         $('#viewdataLicenseCreatedTable').show();
			var table = $('#viewdataLicenseCreatedTable').DataTable({
				lengthChange: false,
				pageLength: 5,
				data: aaa[8],
				dataType: 'json',
				scrollX: '300px',
			});


	});

}


function downFileStandard() {
	var filename = encodeURIComponent($('#filenameStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename=" + filename;

}





function advInvFileStandard() {
	var filename = $('#filnameAdvinvoice').val();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
		+ filename;

}

$("#ApproveSM").click(
		function() {
			


			$('#spin1').show();

			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/"
					+ l.pathname.split('/')[1];
			var serviceUrl = base_url
					+ "/UserActivity/ApproveProposalLicenseSM";

			$.ajax(
					{
						url : serviceUrl,
						type : 'POST',
						data : "crno=" + $('#crnoo').val() + "&tid="
								+ $('#tid').val() + "&SMnote="
								+ encodeURIComponent($('#SMnote').val()),

					}).done(
					function(data) {
						$('#spin1').hide();
						if (data === "success") {
							swal({
								title : "Successful!",
								text : "Proposal License Approved Successfully",
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
											+ "/User/pendingProposalLicenseSM";
								}
							})
						} else {
							swal({
								title : "Fail!",
								text : "Proposal License Approved UnSuccessful",
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
											+ "/User/pendingProposalLicenseSM";
								}

							})
						}

					});
		
		});


function rejectFunction() {
//alert("li rej")
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
									+ "/UserActivity/SMrejectLicense";  
							
//							"/UserActivity/SMrejectMannualVP";

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
														text : "Raised License Rejected Successfully",
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
																	+ "/User/pendingProposalLicenseSM";
														}
													})
												} else {
													swal({
														title : "Fail!",
														text : "Raised Proposal Rejected UnSuccessful",
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
																	+ "/User/pendingProposalLicenseSM";
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

