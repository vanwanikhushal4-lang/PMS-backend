
window.onload = function() {

	$('.nav-tabs a').click(function() {
		$(this).tab('show');
	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getVlxProposalApprovalMDData";

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "crno=" + $('#crnoo').val() + '&tid=' + $("#tid").val()
			})
			.done(
					function(data) {
						// alert(data)
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
						$('#Proposaltype').val(decodeURIComponent(aaa[16]));

						$('#grandtotal').val(decodeURIComponent(aaa[21]));
						$('#total18percentage')
								.val(decodeURIComponent(aaa[22]));
						$('#totalc').val(decodeURIComponent(aaa[23]));
						// alert(aaa[24])
						$('#SMnote').val(decodeURIComponent(aaa[27]));
						$('#clouddeploychargess').val(
								decodeURIComponent(aaa[26]));
						$('#enccustomername').val(decodeURIComponent(aaa[25]));
						$('#integrationcharge')
								.val(decodeURIComponent(aaa[24]));
						if ((aaa[16] == "Perpetual")) {
							$('#perpetualhideid').show();
							$('#subscriptionhideid').hide();
							$('#Perpetualyear')
									.val(decodeURIComponent(aaa[17]));
							
							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
							
						} else if ((aaa[16] == "Subscription")) {
							$('#subscriptionhideid').show();
							$('#perpetualhideid').hide();
							$('#Subscriptionyear').val(
									decodeURIComponent(aaa[20]));
						
							$('#hidereATCforamc').hide();
							
							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
						} else if ((aaa[16] == "Fixed")) {

							$('#fixedhideid').show();
							$('#subscriptionhideid').hide();
							$('#perpetualhideid').hide();
							$('#fixedyear').val(decodeURIComponent(aaa[36]));
							
							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
							
						}else if ((aaa[16] == "AMC")) {
							
//							alert("dv dv ");
							
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
						
							
//							alert("fvu");
						
						}else if ((aaa[16] == "Resource")) {
							
						
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
									decodeURIComponent(aaa[37]));
							$('#gstdataforresource').val(
									decodeURIComponent(aaa[38]));
							$('#grandtotalforresource').val(
									decodeURIComponent(aaa[39]));
						} else if ((aaa[16] === "Subscription & Perpetual")) {
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
						 
						    $('#subscriptionANDperpetualYear').val(decodeURIComponent(aaa[40]));
						    
						    
						    $('#SubsANDPerpTable').show();
						    var table = $('#SubsANDPerpTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[41],
								dataType: 'json',
								scrollX: '300px',
							});
						    
						    if ((aaa[42] === "") || (aaa[42] === "NA") || (aaa[42] === "null")) {
						    	
						    	$('#perpetualSubsAnnualPerpHideDiv').hide();
						    
						    }else {
						    	 $('#perpetualSubsAnnualperpType').val(decodeURIComponent(aaa[42]));
								$('#perpetualSubsAnnualPerpHideDiv').show();
							}
						    
				          if ((aaa[43] === "") || (aaa[43] === "NA") || (aaa[43] === "null")) {
						    	
						    	$('#perpetualSubs3yearPerpHideDiv').hide();
						    
						    }else {
						    	 $('#perpetualSubs3yearperpType').val(decodeURIComponent(aaa[43]));
								$('#perpetualSubs3yearPerpHideDiv').show();
							}
				          
				     
						}

					     $('#deploysupport21').val(decodeURIComponent(aaa[44]));
				         $('#clouddeploycharges21').val(decodeURIComponent(aaa[45]));
				         $('#IntegrationCharges21').val(decodeURIComponent(aaa[47]));
				         $('#subtotalB21').val(decodeURIComponent(aaa[48]));
				         $('#totalc21').val(decodeURIComponent(aaa[49]));
				         $('#total18percentage21').val(decodeURIComponent(aaa[50]));
				         
				         $('#grandtotal21').val(decodeURIComponent(aaa[51]));
				         $('#resoucesamount21').val(decodeURIComponent(aaa[52]));
						
						


						if ((aaa[15] == "File Not Attached")
								|| (aaa[15] == "NA") || (aaa[15] == "null")) {
							$('#downHidepofile').hide();
						} else {
							document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[15]);
							document.getElementById('filenameStandard').value = decodeURIComponent(aaa[15]);
							$('#poUploadDiv').show();
						}
						var data6 = aaa[8];
					
						var selectedValue = $("#Perpetualyear").val();

						if (selectedValue === "1 year Warranty") {

							$("#subtotalahideid").show();
							$("#subtotalahideid3yearperp").hide();
							$("#subtotalahideid5yearperp").hide();
							$("#subtotalahideid3yearsubs").hide();

							$('#totalpriceforallproduct').val(
									decodeURIComponent(aaa[9]));
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
						} else if (selectedValue === "3 year Subscription") {
							$("#subtotalahideid3yearsubs").show();
							$("#subtotalahideid").hide();
							$("#subtotalahideid3yearperp").hide();
							$("#subtotalahideid5yearperp").hide();

							$('#totalpriceforallproduct3yearsubs').val(
									decodeURIComponent(aaa[9]));
						}

						// $('#subtotalA').val(decodeURIComponent(aaa[9]));
						$('#deploysupport').val(decodeURIComponent(aaa[10]));
						$('#clouddeploycharges').val(
								decodeURIComponent(aaa[11]));
						$('#subtotalB').val(decodeURIComponent(aaa[12]));
						let grandtotal = aaa[9] + aaa[12];

						$('#subtotalAB').val(grandtotal);
						if ((aaa[27] == "NA") || (aaa[27] == "null")) {
							// $('#SMnoteDiv').hide();
						} else {
							document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[27]);
							// $('#SMnoteDiv').show();
						}
						$('#resoucesamount').val(decodeURIComponent(aaa[18]));
						$('#ATC').val(aaa[19]);
						
						if (aaa[16] === "AMC")
						{
						if(aaa[53] == "Distributor")
							{
							$('#hidePartnerName').show();
							$('#proposalFor').val(aaa[53]);
							$('#partnerName').val(aaa[54]);
							
							}
						else
							{
							$('#proposalForDiv').show()
							$('#hidePartnerName').hide()
							
							$('#proposalFor').val(aaa[53]);
//							$('#partnerName').val(aaa[54]);
							}
						}else{
							if(aaa[53] == "Distributor")
								{
								$('#hidePartnerName').show();
								$('#proposalFor').val(aaa[53]);
								$('#partnerName').val(aaa[54]);
								
								}
							else{
								$('#proposalForDiv').show()
								$('#hidePartnerName').hide()
								
								$('#proposalFor').val(aaa[53]);

								}
							
						}
						
						

					});

}

$("#ApproveMD").click(
		function() {

			$('#spin1').show();

			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/"
					+ l.pathname.split('/')[1];
			var serviceUrl = base_url + "/UserActivity/UpdateVlxPropMDApprove";

			$.ajax(
					{
						url : serviceUrl,
						type : 'POST',
						data : "crno=" + $('#crnoo').val() + "&tid="
								+ $('#tid').val() + "&MDnote="
								+ $('#MDnote').val(),

					}).done(
					function(data) {
						$('#spin1').hide();
						if (data === "success") {
							swal({
								title : "Successful!",
								text : "Commercial Proposal Approved Successfully",
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
											+ "/User/pendingVlxProposal";
								}
							})
						} else {
							swal({
								title : "Fail!",
								text : "Commercial Proposal Approved UnSuccessful",
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
											+ "/User/pendingVlxProposal";
								}

							})
						}

					});
		});

function downFileStandard() {
	var filename = encodeURIComponent($('#filenameStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

function myFunctionReject() {

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
									+ "/UserActivity/MDrejectVP";

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
														+ "&MDnote="
														+ encodeURIComponent($(
																'#MDnote')
																.val()),

											})
									.done(
											function(data) {
												$('#spin2').hide();
//												alert("my data :" + data);
												if (data == "success") {
													swal({
														title : "Successful!",
														text : "Proposal Rejected Successfully",
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
																	+ "/User/pendingVlxProposal";
														}
													})
												} else {
													swal({
														title : "Fail!",
														text : "Proposal Rejected UnSuccessfully",
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
																	+ "/User/pendingVlxProposal";
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