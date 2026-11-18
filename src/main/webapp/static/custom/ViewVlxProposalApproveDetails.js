
window.onload = function() {

	$('.nav-tabs a').click(function() {
		$(this).tab('show');
	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getVlxProposalApprovedData";

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

						if ((aaa[15] == "Perpetual" || aaa[15] == "NA")) {
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
							
						} else if ((aaa[15] == "Subscription" )) {
							$('#subscriptionhideid').show();
							$('#perpetualhideid').hide();
							$('#Subscriptionyear').val(
									decodeURIComponent(aaa[26]));
							
							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
							

						} else if ((aaa[15] == "Fixed" )) {

							$('#fixedhideid').show();
							$('#subscriptionhideid').hide();
							$('#perpetualhideid').hide();
							$('#fixedyear').val(decodeURIComponent(aaa[17]));
							
							$('#CMApprByMeTable').show();
							var table = $('#CMApprByMeTable').DataTable({
								lengthChange: false,
								pageLength: 5,
								data: aaa[8],
								dataType: 'json',
								scrollX: '300px',
							});
							
						}else if ((aaa[15] == "AMC")) {
							
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
						
						}else if ((aaa[15] == "Resource")) {
							
						
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
						}else if ((aaa[15] === "Subscription & Perpetual")) {
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
				          
				     
						}

						  $('#deploysupport21').val(decodeURIComponent(aaa[43]));
				          $('#clouddeploycharges21').val(decodeURIComponent(aaa[44]));
				          $('#IntegrationCharges21').val(decodeURIComponent(aaa[46]));
				          $('#subtotalB21').val(decodeURIComponent(aaa[47]));
				          $('#totalc21').val(decodeURIComponent(aaa[48]));
				          $('#total18percentage21').val(decodeURIComponent(aaa[49]));
				          
				          $('#grandtotal21').val(decodeURIComponent(aaa[50]));
				          $('#resoucesamount21').val(decodeURIComponent(aaa[51]));

						// /
						$('#resoucesamount').val((aaa[19]));
						$('#ATC').val(aaa[20]);

						$('#enccustomername').val(aaa[21]);
						$('#integrationcharge').val(aaa[22]);
						$('#totalc').val(aaa[23]);
						$('#total18percentage').val(aaa[24]);
						$('#grandtotal').val(aaa[25]);
						var data6 = aaa[8];

//						var table = $('#CMApprByMeTable').DataTable({
//							lengthChange : false,
//							pageLength : 5,
//							data : aaa[8],
//							dataType : 'json',
//							scrollX : '300px',
//						});

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

						if ((aaa[14] == "File Not Attached")
								|| (aaa[14] == "NA") || (aaa[14] == "null")) {
							$('#downHidepofile').hide();
						} else {
							document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[14]);
							document.getElementById('filenameStandard').value = decodeURIComponent(aaa[14]);
							$('#poUploadDiv').show();
						}

						if ((aaa[27] == "NA") || (aaa[27] == "null")) {
							$('#SMnoteDiv').hide();
						} else {
							document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[27]);
							$('#SMnoteDiv').show();
						}
						
						if (aaa[15] === "AMC")
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

function downFileStandard() {
	var filename = $('#filenameStandard').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}
