
window.onload = function() {

	$('.nav-tabs a').click(function() {
		$(this).tab('show');
	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getVlxProposalSMRejectedData";

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
						// $('#prodliscense').val(decodeURIComponent(aaa[4]));
						// $('#prodamount').val(decodeURIComponent(aaa[5]));
						$('#clientname').val(decodeURIComponent(aaa[6]));
						$('#Description').val(decodeURIComponent(aaa[7]));

						$('#Proposaltype').val(decodeURIComponent(aaa[15]));

						// alert("aaa[17]"+aaa[15])
						// alert("aaa[18]"+aaa[16])
						// alert("aaa[19]"+aaa[17])
						// alert("aaa[20]"+aaa[18])

						if ((aaa[15] == "Perpetual")) {
							$('#perpetualhideid').show();
							$('#subscriptionhideid').hide();
							$('#Perpetualyear')
									.val(decodeURIComponent(aaa[16]));
							
							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
							
							
							
							//26/06
							if ((aaa[53] === "Distributor")) {
								$('#proposalfor').val(aaa[53]);
								
								$('#partnernamehideid').show();
								$('#partnername').val(aaa[54]);
							}
							else if((aaa[53] === "NA")){
								$('#proposalfor').val("NA");
							}
							else{
								$('#partnernamehideid').hide();
							}

							 if ((aaa[53] === "Partner")) {
						        	$('#proposalFor').val(decodeURIComponent(aaa[53]));
						        	
						        	$('#hidePartnerName').hide();
							    
							    }else if((aaa[53] === "End customer")){
							    	$('#proposalFor').val(decodeURIComponent(aaa[53]));
							    	$('#hidePartnerName').hide();
							    	 
								}
							//
							
						} else if ((aaa[15] == "Subscription")) {
							$('#subscriptionhideid').show();
							$('#perpetualhideid').hide();
							$('#hidereATCforamc').hide();
							$('#Subscriptionyear').val(
									decodeURIComponent(aaa[24]));
							
							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});

						}else if ((aaa[15] == "Fixed")) {
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
							
						} else if ((aaa[15] == "AMC")) {
							
//							alert("dv dv ");
							
							$('#CMApprByMeTable').hide();
							$('#hideresourceforamc').hide();
							$('#hidereATCforamc').hide();
							$('#hidealldetailforamc').hide();
							$('#hidegstandgrandtotalforamc').hide();
							
							$('#AMCSTARTENDHIDEID').show();
							$('#productsuitandtoolhideid').show();
							
							
							$('#amcstartdate').val(decodeURIComponent(aaa[27]));
							$('#amcenddate').val(decodeURIComponent(aaa[28]));
							$('#productsuitdetails').val(decodeURIComponent(aaa[29]));
							$('#securitysolutiondetails').val(decodeURIComponent(aaa[30]));
							$('#descforamc').val(decodeURIComponent(aaa[31]));
							$('#totalcostAMC').val(decodeURIComponent(aaa[32]));

							$('#gstforamc').val(decodeURIComponent(aaa[33]));
							$('#GRANDTOTALFORAMC').val(decodeURIComponent(aaa[34]));
						
							
//							alert("fvu");
						
						}		
						else if ((aaa[15] === "Resource")) 
						{
						$('#hidealldetailforamc').hide();
						$('#hidegstandgrandtotalforamc').hide();
						$('#hidereATCforamc').hide();
						$('#hideresourceforamc').hide();
								
						$('#subtotalahideidforResource').show();
						
					
							$('#subtotalAResource').val(decodeURIComponent(aaa[35]));
							$('#gstdataforresource').val(decodeURIComponent(aaa[36]));
							$('#grandtotalforresource').val(decodeURIComponent(aaa[37]));
							
							$('#CMApprByMeTable').show();
					    var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
//									
						}
						else if ((aaa[15] === "Subscription & Perpetual")) {
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
						 
						    $('#subscriptionANDperpetualYear').val(decodeURIComponent(aaa[38]));
						    
						    
						    $('#SubsANDPerpTable').show();
						    var table = $('#SubsANDPerpTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[39],
								dataType: 'json',
								scrollX: '300px',
							});
						    
						    if ((aaa[40] === "") || (aaa[40] === "NA") || (aaa[40] === "null")) {
						    	
						    	$('#perpetualSubsAnnualPerpHideDiv').hide();
						    
						    }else {
						    	 $('#perpetualSubsAnnualperpType').val(decodeURIComponent(aaa[40]));
								$('#perpetualSubsAnnualPerpHideDiv').show();
							}
						    
				          if ((aaa[41] === "") || (aaa[41] === "NA") || (aaa[41] === "null")) {
						    	
						    	$('#perpetualSubs3yearPerpHideDiv').hide();
						    
						    }else {
						    	 $('#perpetualSubs3yearperpType').val(decodeURIComponent(aaa[41]));
								$('#perpetualSubs3yearPerpHideDiv').show();
							}
				          
				     
						}

					     $('#deploysupport21').val(decodeURIComponent(aaa[42]));
				         $('#clouddeploycharges21').val(decodeURIComponent(aaa[43]));
				         $('#IntegrationCharges21').val(decodeURIComponent(aaa[45]));
				         $('#subtotalB21').val(decodeURIComponent(aaa[46]));
				         $('#totalc21').val(decodeURIComponent(aaa[47]));
				         $('#total18percentage21').val(decodeURIComponent(aaa[48]));
				         
				         $('#grandtotal21').val(decodeURIComponent(aaa[49]));
				         $('#resoucesamount21').val(decodeURIComponent(aaa[50]));
						

						// /
						$('#resoucesamount').val((aaa[17]));
						if ((aaa[18] == "NA") || (aaa[18] == "null")) {
							$('#ATC').val("NA");
						} else {
							$('#ATC').val(aaa[18]);
						}

						$('#ATC').val(aaa[18]);
						$('#enccustomername').val(aaa[19]);
						$('#integrationcharge').val(aaa[20]);
						$('#totalc').val(aaa[21]);
						$('#total18percentage').val(aaa[22]);
						$('#grandtotal').val(aaa[23]);

						var data6 = aaa[8];

//						var table = $('#CMApprByMeTable').DataTable({
//							lengthChange : false,
//							pageLength : 5,
//							data : aaa[8],
//							dataType : 'json',
//							scrollX : '300px',
//						});

						$('#subtotalA').val(decodeURIComponent(aaa[9]));
						$('#deploysupport').val(decodeURIComponent(aaa[10]));
						$('#clouddeploycharges').val(
								decodeURIComponent(aaa[11]));
						$('#subtotalB').val(decodeURIComponent(aaa[12]));

						$('#integrationcharges').val(
								decodeURIComponent(aaa[20]));

						let grandtotal = aaa[9] + aaa[12];
						// alert(grandtotal);
						$('#subtotalAB').val(grandtotal);

						if ((aaa[14] == "NA") || (aaa[14] == "null")) {
							$('#SMnoteDiv').hide();
						} else {
							document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[14]);
							$('#SMnoteDiv').show();
						}

						if ((aaa[14] == "NA") || (aaa[14] == "null")) {
							$('#SMrejDiv').hide();
						} else {
							document.getElementById('SMRejctednote').innerHTML = decodeURIComponent(aaa[25]);
							$('#SMrejDiv').show();
						}

						if ((aaa[26] == "File Not Attached")
								|| (aaa[26] == "NA") || (aaa[15] == "null")) {
							$('#downHidepofile').hide();
						} else {
							document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[26]);
							document.getElementById('filenameStandard').value = decodeURIComponent(aaa[26]);
							$('#poUploadDiv').show();
						}
						
						
						
						
						if((aaa[14] == "AMC"))
						{
							//26/06
							if ((aaa[49] === "Distributor")) {
								$('#proposalfor').val(aaa[49]);
								
								$('#partnernamehideid').show();
								$('#partnername').val(aaa[50]);
							}
							else if((aaa[49] === "NA")){
								$('#proposalfor').val("NA");
							}
							else{
								$('#partnernamehideid').hide();
							}

							 if ((aaa[49] === "Partner")) {
						        	$('#proposalFor').val(decodeURIComponent(aaa[49]));
						        	
						        	$('#hidePartnerName').hide();
							    
							    }else if((aaa[49] === "End customer")){
							    	$('#proposalFor').val(decodeURIComponent(aaa[49]));
							    	$('#hidePartnerName').hide();
							    	 
								}
							//
						}
						else
						{
							//26/06
							if ((aaa[51] === "Distributor")) {
								$('#proposalfor').val(aaa[51]);
								
								$('#partnernamehideid').show();
								$('#partnername').val(aaa[52]);
							}
							else if((aaa[51] === "NA")){
								$('#proposalfor').val("NA");
							}
							else{
								$('#partnernamehideid').hide();
							}

							 if ((aaa[51] === "Partner")) {
						        	$('#proposalFor').val(decodeURIComponent(aaa[51]));
						        	
						        	$('#hidePartnerName').hide();
							    
							    }else if((aaa[51] === "End customer")){
							    	$('#proposalFor').val(decodeURIComponent(aaa[51]));
							    	$('#hidePartnerName').hide();
							    	 
								}
							//
						}
						
						

					});

}

function downFileStandard() {
	var filename = $('#filenameStandard').val();
	// //alert(filename);
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}
