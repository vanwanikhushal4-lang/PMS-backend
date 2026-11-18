
window.onload = function() {
	proposaltypedata();


	$('#SInoteDiv').hide();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getVlxProposalPendingData";

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "crno=" + $('#crnoo').val() + '&tid=' + $("#tid").val()
			})
			.done(
					function(data) {

						var aaa = data[0];
						console.log(data)

						$('#poinitiator').val(decodeURIComponent(data[0][0]));
						$('#poinitiatorno').val(decodeURIComponent(data[0][1]));
						$('#FirstApprovername').val(
								decodeURIComponent(data[0][2]));
						$('#firstapprovercontact').val(
								decodeURIComponent(aaa[3]));
						$('#clientname').val(decodeURIComponent(aaa[6]));
						$('#Description').val(decodeURIComponent(aaa[7]));

						$('#Proposaltype').val(decodeURIComponent(aaa[17]));

						if ((aaa[17] == "Perpetual")) {
							$('#perpetualhideid').show();
							$('#subscriptionhideid').hide();
							$('#Perpetualyear')
									.val(decodeURIComponent(aaa[18]));
							
							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
							
						} else if ((aaa[17] == "Subscription")) {
							
							$('#hidereATCforamc').hide();
							$('#subscriptionhideid').show();
							$('#subscriptionhideid').show();
                            $('#perpetualhideid').hide();
							$('#Subscriptionyear').val(
									decodeURIComponent(aaa[19]));
							
							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
							
						} else if ((aaa[17] == "Fixed")) {
							$('#fixedhideid').show();
							$('#perpetualhideid').hide();
							$('#perpetualhideid').hide();
							$('#fixedyear').val(decodeURIComponent(aaa[20]));
							
							
							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
							
						} else if ((aaa[17] == "AMC")) {
							
							$('#CMApprByMeTable').hide();
							$('#hideresourceforamc').hide();
							$('#hidereATCforamc').hide();
							$('#hidealldetailforamc').hide();
							$('#hidegstandgrandtotalforamc').hide();
							
							$('#AMCSTARTENDHIDEID').show();
							$('#productsuitandtoolhideid').show();
							
							
							$('#amcstartdate').val(decodeURIComponent(aaa[28]));
							$('#amcenddate').val(decodeURIComponent(aaa[29]));
							$('#productsuitdetails').val(decodeURIComponent(aaa[30]));
							$('#securitysolutiondetails').val(decodeURIComponent(aaa[31]));
							$('#descforamc').val(decodeURIComponent(aaa[32]));
							$('#totalcostAMC').val(decodeURIComponent(aaa[33]));

							$('#gstforamc').val(decodeURIComponent(aaa[34]));
							$('#GRANDTOTALFORAMC').val(decodeURIComponent(aaa[35]));
						
							
							
						
						}else if ((aaa[17] == "Resource")) {
							
						
							$('#hidealldetailforamc').hide();
							$('#hidegstandgrandtotalforamc').hide();
							$('#hidereATCforamc').hide();
							$('#hideresourceforamc').hide();

							$('#subtotalahideidforResource').show();

							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange : false,
								pageLength : 5,
								data : aaa[8],
								dataType : 'json',
								scrollX : '300px',
							});

						
							$('#subtotalAResource').val(
									decodeURIComponent(aaa[36]));
							$('#gstdataforresource').val(
									decodeURIComponent(aaa[37]));
							$('#grandtotalforresource').val(
									decodeURIComponent(aaa[38]));
						}
						else if ((aaa[17] === "Subscription & Perpetual")) {
							$('#combinationSubsANDPerpHideDIv').show();
							
							$('#subscriptionhideid').hide();

							$('#hidereATCforamc').hide();
							$('#perpetualhideid').hide();
							$('#fixedhideid').hide();
//							$('#Subscriptionyear').val(decodeURIComponent(aaa[41]));
							
							$('#CMApprByMeTable').show();
						    var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
						    
						    $('#subscriptionANDperpetualhideid').show();
						 
						    $('#subscriptionANDperpetualYear').val(decodeURIComponent(aaa[39]));
						    
						    
						    $('#SubsANDPerpTable').show();
						    var table = $('#SubsANDPerpTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[40],
								dataType: 'json',
								scrollX: '300px',
							});
						    
						    if ((aaa[41] === "") || (aaa[41] === "NA") || (aaa[41] === "null")) {
						    	
						    	$('#perpetualSubsAnnualPerpHideDiv').hide();
						    
						    }else {
						    	 $('#perpetualSubsAnnualperpType').val(decodeURIComponent(aaa[41]));
								$('#perpetualSubsAnnualPerpHideDiv').show();
							}
						    
				          if ((aaa[42] === "") || (aaa[42] === "NA") || (aaa[42] === "null")) {
						    	
						    	$('#perpetualSubs3yearPerpHideDiv').hide();
						    
						    }else {
						    	 $('#perpetualSubs3yearperpType').val(decodeURIComponent(aaa[42]));
								$('#perpetualSubs3yearPerpHideDiv').show();
							}
				          
				          $('#deploysupport21').val(decodeURIComponent(aaa[43]));
				          $('#clouddeploycharges21').val(decodeURIComponent(aaa[44]));
				          $('#IntegrationCharges21').val(decodeURIComponent(aaa[46]));
				          $('#subtotalB21').val(decodeURIComponent(aaa[47]));
				          $('#totalc21').val(decodeURIComponent(aaa[48]));
				          $('#total18percentage21').val(decodeURIComponent(aaa[49]));
				          
				          $('#grandtotal21').val(decodeURIComponent(aaa[50]));
				          $('#resoucesamount21').val(decodeURIComponent(aaa[51]));
						}
						

						$('#resoucesamount').val((aaa[21]));
						$('#ATC').val(aaa[22]);
						$('#enccustomername').val(aaa[23]);
						$('#integrationcharge').val(aaa[24]);
						$('#totalc').val(aaa[25]);
						$('#total18percentage').val(aaa[26]);
						$('#grandtotal').val(aaa[27]);

						var data6 = aaa[8];

					

						var selectedValue = $("#Perpetualyear").val();

						if (selectedValue === "1 year Warranty") {

							$("#subtotalahideid").show();
							$("#subtotalahideid3yearperp").hide();
							$("#subtotalahideid5yearperp").hide();
							$("#subtotalahideid3yearsubs").hide();

							$('#totalpriceforallproduct').val(
									decodeURIComponent(aaa[9]));

							// alert("1 year perp
							// :"+$('#totalpriceforallproduct').val())
						} else if (selectedValue === "3 year Warranty") {
							$("#subtotalahideid3yearperp").show();
							$("#subtotalahideid5yearperp").hide();
							$("#subtotalahideid").hide();
							$("#subtotalahideid3yearsubs").hide();

							$('#totalpriceforallproduct3yearperp').val(
									decodeURIComponent(aaa[9]));
						} else if (selectedValue === "5 year Warranty") {
							$("#subtotalahideid5yearperp").show();
							$("#subtotalahideid3yearperp").hide();
							$("#subtotalahideid").hide();
							$("#subtotalahideid3yearsubs").hide();

							$('#totalpriceforallproduct5yearperp').val(
									decodeURIComponent(aaa[9]));
						}
						// }

						var selectedValue = $("#Subscriptionyear").val();
						if (selectedValue === "Annual Price") {
							$("#subtotalahideid").show();
							$("#subtotalahideid3yearsubs").hide();
							$("#subtotalahideid3yearperp").hide();
							$("#subtotalahideid5yearperp").hide();

							$('#totalpriceforallproduct').val(
									decodeURIComponent(aaa[9]));

							// alert("sfsfsf
							// :"+$('#totalpriceforallproduct').val(decodeURIComponent(aaa[9])))
						} else if (selectedValue === "3 year Subscription") {
							$("#subtotalahideid3yearsubs").show();
							$("#subtotalahideid").hide();
							$("#subtotalahideid3yearperp").hide();
							$("#subtotalahideid5yearperp").hide();

							$('#totalpriceforallproduct3yearsubs').val(
									decodeURIComponent(aaa[9]));
						}

						var selectedValue = $("#fixedyear").val();

						if (selectedValue === "3 year Warranty") {

							$("#subtotalahideid3yearfixed").show();
							$("#subtotalahideid").hide();
							$("#subtotalahideid3yearsubs").hide();
							$("#subtotalahideid3yearperp").hide();
							$("#subtotalahideid5yearperp").hide();

							$('#subtotal3yearfixed').val(
									decodeURIComponent(aaa[9]));

						} else if (selectedValue === "5 year Warranty") {
							$("#subtotalahideid5yearfixed").show();
							$("#subtotalahideid3yearsubs").hide();
							$("#subtotalahideid").hide();
							$("#subtotalahideid3yearperp").hide();
							$("#subtotalahideid5yearperp").hide();

							$('#subtotal5yearfixed').val(
									decodeURIComponent(aaa[9]));
						} else {

							$("#subtotalahideid").show();
							$('#totalpriceforallproduct').val(
									decodeURIComponent(aaa[9]));

						}

						// $('#subtotalA').val(decodeURIComponent(aaa[9]));
						$('#deploysupport').val(decodeURIComponent(aaa[10]));
						$('#clouddeploycharges').val(
								decodeURIComponent(aaa[11]));
						$('#subtotalB').val(decodeURIComponent(aaa[12]));

						let grandtotal = aaa[9] + aaa[12];
						// alert(grandtotal);
						$('#subtotalAB').val(grandtotal);

						if ((aaa[14] == "NA") || (aaa[14] == "null")) {
							$('#SInoteDiv').hide();
						} else {
							document.getElementById('SInote').innerHTML = decodeURIComponent(aaa[14]);
							$('#SInoteDiv').show();
						}

						$('#SMnote').val(decodeURIComponent(aaa[15]));

						if ((aaa[16] == "File Not Attached")
								|| (aaa[16] == "NA") || (aaa[16] == "null")) {
							$('#downHidepofile').hide();
						} else {
							document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[16]);
							document.getElementById('filenameStandard').value = decodeURIComponent(aaa[16]);
							$('#poUploadDiv').show();
						}
						
						
						
						if (aaa[17] === "AMC")
						{
						if(aaa[52] == "Distributor")
							{
							$('#hidePartnerName').show();
							$('#proposalFor').val(aaa[52]);
							$('#partnerName').val(aaa[53]);
							
							}
						else
							{
							$('#proposalForDiv').show()
							$('#hidePartnerName').hide()
							
							$('#proposalFor').val(aaa[52]);
//							$('#partnerName').val(aaa[54]);
							}
						}else{
							if(aaa[52] == "Distributor")
								{
								$('#hidePartnerName').show();
								$('#proposalFor').val(aaa[52]);
								$('#partnerName').val(aaa[53]);
								
								}
							else{
								$('#proposalForDiv').show()
								$('#hidePartnerName').hide()
								
								$('#proposalFor').val(aaa[53]);

								}
							
						}

					});
	
	

}

function proposaltypedata() {
	// alert("HIHI")
	var selectedValue = $("#Proposaltype").val();

	var selectedperpetual = $("#Perpetualyear").val();
	var selectedSubscription = $("#Subscriptionyear").val();

	if (selectedValue === "Perpetual") {
		$("#perpetualhideid").show();
		$("#subscriptionhideid").hide();

		if (selectedperpetual === "3 year Warranty") {
			$("#secondandthirdyeatamchideid").show();
		} else if (selectedperpetual === "5 year Warranty") {
			$("#secondandthirdyeatamchideid").show();
			$("#fourAndfiveyearAmchideid").show();

		}

	} else if (selectedValue === "Subscription") {
		$("#subscriptionhideid").show();
		$("#perpetualhideid").hide();

		if (selectedSubscription === "3 year Subscription") {
			$("#secondandthirdyearSubshideid").show();

		} else if (selectedSubscription === "Annual Price") {
			$("#subscriptionhideid").show();
			$("#secondandthirdyearSubshideid").hide();
		}
	}
}

$("#ApproveCM").click(
		function() {

			$('#spin1').show();

			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/"
					+ l.pathname.split('/')[1];
			var serviceUrl = base_url
					+ "/UserActivity/UpdateVlxPropSaleMangApprove";

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
//						alert(data)
						
						var dataArray = data.split(',');
				    	 var firstPart = dataArray[0]; // "VP-20"
				    	 var secondPart = dataArray[1]; // "Success"
				    	 
						if (secondPart === "success") {
							swal({
								title : "Successful!",
//								text : "Proposal Approved Successfully",
								html : firstPart+"<br>Commercial Proposal Approved Successfully",
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
									window.location.href = base_url	+ "/User/pendingApprSalesMng";
								}
							})
						} else {
							swal({
								title : "Fail!",
//								text : "Proposal Approved UnSuccessful",
								html : firstPart+"<br>Commercial Proposal Approved UnSuccessful",
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
											+ "/User/pendingApprSalesMng";
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
									+ "/UserActivity/SMrejectVP";

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
																	+ "/User/pendingApprSalesMng";
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
																	+ "/User/pendingApprSalesMng";
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

function downFileStandard() {
	var filename = $('#filenameStandard').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}