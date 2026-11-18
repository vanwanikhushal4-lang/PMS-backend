/**
 * 
 */

var subcategory = "";
var statusCI = "";


window.onload = function() {
	proposaltypedata();

	
	$('#SInoteDiv').hide();
	//	    $('#custom-tabs-one-home').hide();

	//subcategory = $('#subcategory1').val();
	statusCI = $('#statusCI').val();


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getManualProposalDataSM";

	$.ajax({
		url: serviceUrl,
		type: 'POST',
		dataType: 'json',
		data: "crno=" + $('#crnoo').val()
			+ '&tid=' + $("#tid").val()
	}).done(function(data) {

		var aaa = data[0];
		
		console.log(data);

		$('#poinitiator').val(decodeURIComponent(data[0][0]));
		$('#poinitiatorno').val(decodeURIComponent(data[0][1]));
		$('#FirstApprovername').val(decodeURIComponent(data[0][2]));
		$('#firstapprovercontact').val(decodeURIComponent(aaa[3]));
		$('#clientname').val(decodeURIComponent(aaa[6]));
		$('#Description').val(decodeURIComponent(aaa[7]));
		$('#Proposaltype').val(decodeURIComponent(aaa[9]));
        $('#enccustomername').val(decodeURIComponent(aaa[15]));
        $('#contactpersonname').val(decodeURIComponent(aaa[16]));
        $('#ATC').val(aaa[14]);
        $('#manualAmount').val(aaa[17]);

	
		if ((aaa[9] === "Perpetual")) {
			$('#perpetualhideid').show();
			$('#subscriptionhideid').hide();
			$('#fixedhideid').hide();
			$('#Perpetualyear').val(decodeURIComponent(aaa[10]));
			
			

			

		} else if ((aaa[9] === "Subscription")) {
			$('#subscriptionhideid').show();

			$('#hidereATCforamc').hide();
			$('#perpetualhideid').hide();
			$('#fixedhideid').hide();
			$('#Subscriptionyear').val(decodeURIComponent(aaa[11]));
		}else if ((aaa[9] === "Fixed")) {
			$('#fixedhideid').show();
			$('#subscriptionhideid').hide();
			$('#subscriptionhideid').hide();
			$('#fixedyear').val(decodeURIComponent(aaa[12]));

		
		} else if ((aaa[9] === "Subscription & Perpetual")) {
			$('#combinationSubsANDPerpHideDIv').show();
			
			$('#subscriptionhideid').hide();

			$('#hidereATCforamc').hide();
			$('#perpetualhideid').hide();
			$('#fixedhideid').hide();
			
			
		    $('#subscriptionANDperpetualhideid').show();
		 
		    $('#subscriptionANDperpetualYear').val(decodeURIComponent(aaa[12]));
		    
     
		}

	 
		if ((aaa[8] == "File Not Attached") || (aaa[8] == "NA") || (aaa[8] == "null")) {
			$('#downHidepofile').hide();
		} else {
			document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[8]);
			document.getElementById('filenameStandard').value = decodeURIComponent(aaa[8]);
			$('#poUploadDiv').show();
		}
		
		
		

		
		//26/06
		if ((aaa[18] === "Distributor")) {
			$('#proposalfor').val(aaa[18]);
			
			$('#partnernamehideid').show();
			$('#partnername').val(aaa[19]);
		}
		else if((aaa[18] === "NA")){
			$('#proposalfor').val("NA");
		}
		else{
			$('#partnernamehideid').hide();
		}
		
		 if ((aaa[18] === "Partner")) {
	        	$('#proposalfor').val(decodeURIComponent(aaa[18]));
	        	
	        	$('#hidePartnerName').hide();
		    
		    }else if((aaa[18] === "End customer")){
		    	$('#proposalfor').val(decodeURIComponent(aaa[18]));
		    	$('#hidePartnerName').hide();
		    	 
			}
		//
		
			    

	});

}




function proposaltypedata() {
	var selectedValue = $("#Proposaltype").val();

	var selectedperpetual = $("#Perpetualyear").val();
	var selectedSubscription = $("#Subscriptionyear").val();

	if (selectedValue === "Perpetual") {
		$("#perpetualhideid").show();
		$("#subscriptionhideid").hide();

		if (selectedperpetual === "3 year Warranty") {
			$("#secondandthirdyeatamchideid").show();
		}
		else if (selectedperpetual === "5 year Warranty") {
			$("#secondandthirdyeatamchideid").show();
			$("#fourAndfiveyearAmchideid").show();

		}

	} else if (selectedValue === "Subscription") {
		$("#subscriptionhideid").show();
		$("#perpetualhideid").hide();

		if (selectedSubscription === "3 year Subscription") {
			$("#secondandthirdyearSubshideid").show();

		}
		else if (selectedSubscription === "Annual Price") {
			$("#subscriptionhideid").show();
			$("#secondandthirdyearSubshideid").hide();
		}
	}
}
function downFileStandard() {
	event.preventDefault();
	var filename = $('#filenameStandard').val();
	alert("filenameStandard: "+filename);
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
					+ "/UserActivity/ApproveManualProposalLicenseSM";

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
						
						var dataArray = data.split(',');
				    	 var firstPart = dataArray[0]; // "VP-20"
				    	 var secondPart = dataArray[1]; // "Success"
				    	 
						if (secondPart === "success") {
							swal({
								title : "Successfull!",
								html : firstPart+"<br>Manual Proposal Approved Successfully",
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
											+ "/User/pendingManualProposalApprovalSM";
								}
							})
						} else {
							swal({
								title : "Fail!",
								html : firstPart+"Manual Proposal Approved UnSuccessfull",
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
											+ "/User/pendingManualProposalApprovalSM";
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
									+ "/UserActivity/SMrejectMannualVP";

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
														text : "Raised Proposal Rejected Successfully",
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
																	+ "/User/pendingManualProposalApprovalSM";
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
																	+ "/User/pendingManualProposalApprovalSM";
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
