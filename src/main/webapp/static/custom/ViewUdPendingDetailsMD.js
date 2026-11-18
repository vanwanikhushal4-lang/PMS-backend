window.onload = function() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/ViewUdPendingDetailsMD";

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "crno=" + $('#crnoo').val() + '&uid=' + $("#uid").val()
						
			})
			.done(
					function(data) {
						
					//	alert("data "+data)

						$('#udNumber').val(decodeURIComponent(data[0][0]));
						$('#rdNumber').val(decodeURIComponent(data[0][1]));
						$('#POnumber').val(decodeURIComponent(data[0][2]));
						
						$('#functionName').val(decodeURIComponent(data[0][3]));
						$('#prodSuite').val(decodeURIComponent(data[0][4]));
						$('#securityTool').val(decodeURIComponent(data[0][5]));
						
						$('#prodManager').val(decodeURIComponent(data[0][6]));
						$('#teamLeader').val(decodeURIComponent(data[0][7]));
						$('#developer').val(decodeURIComponent(data[0][8]));
						
						$('#submittedBy').val(decodeURIComponent(data[0][9]));
						$('#submitDate').val(decodeURIComponent(data[0][10]));
						$('#udNote').val(decodeURIComponent(data[0][11]));
						
						if ((decodeURIComponent(data[0][12]) == "File Not Attached")
								|| (decodeURIComponent(data[0][12]) == "NA")
								|| (decodeURIComponent(data[0][12]) == "null")) {
							$('#UdUploadDiv').hide();
						} else {
							document.getElementById('udUploadfile').innerHTML = decodeURIComponent(data[0][12]);
							document.getElementById('udFileStandard').value = decodeURIComponent(data[0][12]);
							$('#UdUploadDiv').show();
						}
						
						$('#projectDesc').val(decodeURIComponent(data[0][14]));
						$('#projectObj').val(decodeURIComponent(data[0][15]));
						$('#projectScope').val(decodeURIComponent(data[0][16]));
						
						$('#funcReq').val(decodeURIComponent(data[0][17]));
						$('#nonFuncReq').val(decodeURIComponent(data[0][18]));
						$('#techReq').val(decodeURIComponent(data[0][19]));
						
						$('#startDate').val(decodeURIComponent(data[0][20]));
						$('#endDate').val(decodeURIComponent(data[0][21]));
						if ((decodeURIComponent(data[0][22]) == "File Not Attached")
								|| (decodeURIComponent(data[0][22]) == "NA")
								|| (decodeURIComponent(data[0][22]) == "null")) {
							$('#otherFileDiv').hide();
						} else {
							document.getElementById('otherFile').innerHTML = decodeURIComponent(data[0][22]);
							document.getElementById('otherFileStandard').value = decodeURIComponent(data[0][22]);
							$('#otherFileDiv').show();
						}
						
						
						});
    
    
}


$("#approveMD").click(
		function() {
			$('#spin1').show();

			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/"
					+ l.pathname.split('/')[1];
			var serviceUrl = base_url
					+ "/PMS/ApproveUDDetailsByMD";
				
		
			
			
			$.ajax(
					{
						url : serviceUrl,
						type : 'POST',
						data : "crno=" + $('#crnoo').val()+ '&prodManager=' + $("#prodManager").val(),
						
					}).done(
					function(data) {
						
						$('#spin1').hide();
						if (data === "success") {
							swal({
								title : "Successful!",
								text : "UD Approved Successfully",
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
											+ "/Admin/apprvlUdDocuments";
								}
							})
						} else {
							swal({
								title : "Fail!",
								text : "UD Approved UnSuccessful",
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
											+ "/Admin/apprvlUdDocuments";
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
//									+ "/UserActivity/rejectedManualProposalByMD";
									+ "/PMS/rejectUDbyMD";

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
														+ $('#uid').val(),
//														+ "&SMnote="
//														+ encodeURIComponent($(
//																'#SMnote')
//																.val()),

											})
									.done(
											function(data) {
												var resultArray = data.split(',');
												var firstPart = resultArray[0];
												var secondPart = resultArray[1];
												
												$('#spin2').hide();
												if (secondPart == "success") {
													swal({
														title : "Successful!",
//														text : "UD Rejected Successfully",
														html :firstPart
														+ "  Rejected Successfully",
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
																	+ "/Admin/apprvlUdDocuments";
														}
													})
												} else {
													swal({
														title : "Fail!",
//														text : "UD Rejected UnSuccessful",
														html :firstPart
														+ "  Rejected UnSuccessful",
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
																	+ "/Admin/apprvlUdDocuments";
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






// file

function UDStandard() {
	event.preventDefault();
	var filename = encodeURIComponent($('#udFileStandard').val());
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
	window.location.href = base_url + "/Inventive/DownloadFile?filename="+ filename;
}