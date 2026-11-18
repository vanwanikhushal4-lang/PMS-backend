


window.onload = function(){
	
	

	 $('.nav-tabs a').click(function () {
	        $(this).tab('show');
	    });
		
	
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getRevisedProposalApprovedDataMD";
	    
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: "crno=" + $('#crnoo').val()
	        + '&tid=' + $("#tid").val()
	    }).done(function(data) {
//			 alert(".*ProposalApprovedDataMD:"+data)
			var aaa = data[0];
			console.log(data)

			$('#poinitiator').val(decodeURIComponent(data[0][0]));
			$('#poinitiatorno').val(decodeURIComponent(data[0][1]));
			$('#FirstApprovername').val(decodeURIComponent(data[0][2]));
			$('#firstapprovercontact').val(decodeURIComponent(aaa[3]));
			// $('#prodliscense').val(decodeURIComponent(aaa[4]));
			// $('#prodamount').val(decodeURIComponent(aaa[5]));
			$('#clientname').val(decodeURIComponent(aaa[6]));
			$('#Description').val(decodeURIComponent(aaa[7]));
			
			
//			$('#Proposaltype').val(decodeURIComponent(aaa[16]));
		
			if (aaa[17] == "Perpetual") {
//				alert("perpetual")
				$('#perpetualhideid').show();
				$('#subscriptionhideid').hide();
				$('#Perpetualyear').val(decodeURIComponent(aaa[18]));
				$('#Proposaltype').val(decodeURIComponent(aaa[17]));
				
				$('#CMApprByMeTable').show();
				var table = $('#CMApprByMeTable').DataTable({
					lengthChange: false,
					pageLength: 5,
					data: aaa[8],
					dataType: 'json',
					scrollX: '300px',
				});
				
				
				
				 if ((aaa[37] === "Distributor")) {
					   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	
					   	$('#hidePartnerName').show();
					   	$('#PartnerName').val(decodeURIComponent(aaa[38]));
					   
					   }else {
							$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	$('#hidePartnerName').hide();
					   	 
						}
					   
					   
					   if ((aaa[37] === "Partner")) {
					   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	
					   	$('#hidePartnerName').hide();
					   
					   }else if((aaa[37] === "End customer")){
					   	$('#proposalFor').val(decodeURIComponent(aaa[3]));
					   	$('#hidePartnerName').hide();
					   	 
						}
				
			} else if ((aaa[17] == "Subscription")) {
				
				$('#subscriptionhideid').show();
				$('#perpetualhideid').hide();
				$('#hidereATCforamc').hide();
				$('#fixedhideid').hide();
				$('#subscriptionANDperpetualhideid').hide();
				$('#Subscriptionyear').val(decodeURIComponent(aaa[35]));
				$('#Proposaltype').val(decodeURIComponent(aaa[17]));
				//alert("res"+aaa[19])
				$('#resoucesamount').val((aaa[19]));
				
				
				if ((aaa[15] == "File Not Attached")
						|| (aaa[15] == "NA") || (aaa[15] == "null")) {
					$('#poUploadDiv').hide();
				} else {
					document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[15]);
					document.getElementById('filenameStandard').value = decodeURIComponent(aaa[15]);
					$('#poUploadDiv').show();
				}
				
				$('#CMApprByMeTable').show();
				var table = $('#CMApprByMeTable').DataTable({
					lengthChange: false,
					pageLength: 5,
					data: aaa[8],
					dataType: 'json',
					scrollX: '300px',
				});
				
				
				
				//02/07
				  if ((aaa[37] === "Distributor")) {
					   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	
					   	$('#hidePartnerName').show();
					   	$('#PartnerName').val(decodeURIComponent(aaa[38]));
					   
					   }else {
							$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	$('#hidePartnerName').hide();
					   	 
						}
					   
					   
					   if ((aaa[37] === "Partner")) {
					   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	
					   	$('#hidePartnerName').hide();
					   
					   }else if((aaa[37] === "End customer")){
					   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	$('#hidePartnerName').hide();
					   	 
						}
				//

			}else if ((aaa[17] == "Fixed")) {

				$('#fixedhideid').show();
				$('#subscriptionhideid').hide();
				$('#perpetualhideid').hide();
				$('#fixedyear').val(decodeURIComponent(aaa[36]));
				
				$('#Proposaltype').val(decodeURIComponent(aaa[17]));
				
				$('#CMApprByMeTable').show();
				var table = $('#CMApprByMeTable').DataTable({
					lengthChange: false,
					pageLength: 5,
					data: aaa[8],
					dataType: 'json',
					scrollX: '300px',
				});
				
				
				  if ((aaa[37] === "Distributor")) {
					   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	
					   	$('#hidePartnerName').show();
					   	$('#PartnerName').val(decodeURIComponent(aaa[38]));
					   
					   }else {
							$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	$('#hidePartnerName').hide();
					   	 
						}
					   
					   
					   if ((aaa[37] === "Partner")) {
					   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	
					   	$('#hidePartnerName').hide();
					   
					   }else if((aaa[37] === "End customer")){
					   	$('#proposalFor').val(decodeURIComponent(aaa[3]));
					   	$('#hidePartnerName').hide();
					   	 
						}
				
			}else if ((aaa[16] === "AMC")) {

//				alert("dv dv ");
//				alert("In AMC"+aaa[16])
				$('#Perpetualyear').hide();
				$('#Proposaltype').val(decodeURIComponent(aaa[16]));
				$('#CMApprByMeTable').hide();
				$('#divCMTable').hide();
				$('#hideresourceforamc').hide();
				$('#hidereATCforamc').hide();
				$('#hidealldetailforamc').hide();
				$('#hidegstandgrandtotalforamc').hide();
				$('#descandtotalcosthideid').show();
				$('#DivHidesubtotal').hide();
				$('#perpetualhideid').hide();
				$('#subscriptionhideid').hide();
				
				
				$('#AMCSTARTENDHIDEID').show();
				$('#productsuitandtoolhideid').show();
//				$('#enccustomername').val(aaa[20]);
				
				
				$('#amcstartdate').val(decodeURIComponent(aaa[26]));
				$('#amcenddate').val(decodeURIComponent(aaa[25]));
				$('#productsuitdetails').val(decodeURIComponent(aaa[28]));
				$('#securitysolutiondetails').val(decodeURIComponent(aaa[29]));
				$('#descforamc').val(decodeURIComponent(aaa[27]));
				$('#totalcostAMC').val(decodeURIComponent(aaa[30]));
			

				$('#gstforamc').val(decodeURIComponent(aaa[32]));
				$('#GRANDTOTALFORAMC').val(decodeURIComponent(aaa[31]));
				if ((aaa[15] == "File Not Attached")
						|| (aaa[15] == "NA") || (aaa[15] == "null")) {
					$('#downHidepofile').hide();
				} else {
					document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[15]);
					document.getElementById('filenameStandard').value = decodeURIComponent(aaa[15]);
					$('#poUploadDiv').show();
				}
				
				
				
				
				
				//02/07
				  if ((aaa[36] === "Distributor")) {
					   	$('#proposalFor').val(decodeURIComponent(aaa[36]));
					   	
					   	$('#hidePartnerName').show();
					   	$('#PartnerName').val(decodeURIComponent(aaa[37]));
					   
					   }else {
							$('#proposalFor').val(decodeURIComponent(aaa[36]));
					   	$('#hidePartnerName').hide();
					   	 
						}
					   
					   
					   if ((aaa[36] === "Partner")) {
					   	$('#proposalFor').val(decodeURIComponent(aaa[36]));
					   	
					   	$('#hidePartnerName').hide();
					   
					   }else if((aaa[36] === "End customer")){
					   	$('#proposalFor').val(decodeURIComponent(aaa[36]));
					   	$('#hidePartnerName').hide();
					   	 
						}
				//
			
				
//				alert("fvu");
			
			}else if ((aaa[17] == "Resource")) {
				
				$('#Proposaltype').val(decodeURIComponent(aaa[17]));
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
				
				
				
				
				//02/07
				  if ((aaa[37] === "Distributor")) {
					   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	
					   	$('#hidePartnerName').show();
					   	$('#PartnerName').val(decodeURIComponent(aaa[38]));
					   
					   }else {
							$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	$('#hidePartnerName').hide();
					   	 
						}
					   
					   
					   if ((aaa[37] === "Partner")) {
					   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	
					   	$('#hidePartnerName').hide();
					   
					   }else if((aaa[37] === "End customer")){
					   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
					   	$('#hidePartnerName').hide();
					   	 
						}
				//
			} else if ((aaa[15] === "Subscription & Perpetual")) {
				$('#combinationSubsANDPerpHideDIv').show();
				
				$('#subscriptionhideid').hide();

				$('#hidereATCforamc').hide();
				$('#perpetualhideid').hide();
				$('#fixedhideid').hide();
//				$('#Subscriptionyear').val(decodeURIComponent(aaa[41]));
				
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
	          
	          
	          
	          
	          
	        //02/07
			  if ((aaa[37] === "Distributor")) {
				   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
				   	
				   	$('#hidePartnerName').show();
				   	$('#PartnerName').val(decodeURIComponent(aaa[38]));
				   
				   }else {
						$('#proposalFor').val(decodeURIComponent(aaa[37]));
				   	$('#hidePartnerName').hide();
				   	 
					}
				   
				   
				   if ((aaa[37] === "Partner")) {
				   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
				   	
				   	$('#hidePartnerName').hide();
				   
				   }else if((aaa[37] === "End customer")){
				   	$('#proposalFor').val(decodeURIComponent(aaa[37]));
				   	$('#hidePartnerName').hide();
				   	 
					}
			//
	          
	     
			}

		     $('#deploysupport21').val(decodeURIComponent(aaa[44]));
	         $('#clouddeploycharges21').val(decodeURIComponent(aaa[45]));
	         $('#IntegrationCharges21').val(decodeURIComponent(aaa[47]));
	         $('#subtotalB21').val(decodeURIComponent(aaa[48]));
	         $('#totalc21').val(decodeURIComponent(aaa[49]));
	         $('#total18percentage21').val(decodeURIComponent(aaa[50]));
	         
	         $('#grandtotal21').val(decodeURIComponent(aaa[51]));
	         $('#resoucesamount21').val(decodeURIComponent(aaa[52]));
	         
	         
	         
	         //29/06
//	         if ((aaa[36] === "Distributor")) {
//	         	$('#proposalFor').val(decodeURIComponent(aaa[36]));
//	         	
//	         	$('#hidePartnerName').show();
//	         	$('#PartnerName').val(decodeURIComponent(aaa[37]));
//	 	    
//	 	    }else {
//	 			$('#proposalFor').val(decodeURIComponent(aaa[36]));
//	 	    	$('#hidePartnerName').hide();
//	 	    	 
//	 		}
//	         
//	         
//	         
//	         if ((aaa[36] === "Partner")) {
//	         	$('#proposalFor').val(decodeURIComponent(aaa[36]));
//	         	
//	         	$('#hidePartnerName').hide();
//	 	    
//	 	    }else if((aaa[36] === "End customer")){
//	 	    	$('#proposalFor').val(decodeURIComponent(aaa[36]));
//	 	    	$('#hidePartnerName').hide();
//	 	    	 
//	 		}
	         
	         
	         
	         //
			
			
			


			// /
	         
			$('#resoucesamount').val((aaa[19]));
//			alert("res"+aaa[19])
			$('#ATC').val(aaa[10]);
//			alert(aaa[16])
			if(aaa[16]==='AMC')
				{
					$('#enccustomername').val(aaa[20]);
				}else{
					$('#enccustomername').val(aaa[21]);
				}
			
			$('#integrationcharge').val(aaa[25]);
			
			$('#totalc').val(aaa[13]); // gst value
			$('#total18percentage').val(aaa[23]); // total value
													// 23
			$('#grandtotal').val(aaa[24]);
			// integration 24
			$('#SMnote').val(aaa[26]);
			$('#MDnote').val(aaa[27]);

			var data6 = aaa[8];

//			var table = $('#CMApprByMeTable').DataTable({
//				lengthChange : false,
//				pageLength : 5,
//				data : aaa[8],
//				dataType : 'json',
//				scrollX : '300px',
//			});

			var selectedValue = $("#Perpetualyear").val();

			if (selectedValue === "1 year Warranty") {

				$("#subtotalahideid").show();
				$("#subtotalahideid3yearperp").hide();
				$("#subtotalahideid5yearperp").hide();
				$("#subtotalahideid3yearsubs").hide();

				$('#subtotalA').val(decodeURIComponent(aaa[9]));
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

				$('#subtotalA').val(decodeURIComponent(aaa[9]));
			} else if (selectedValue === "3 year Subscription") {
				$("#subtotalahideid3yearsubs").show();
				$("#subtotalahideid").hide();
				$("#subtotalahideid3yearperp").hide();
				$("#subtotalahideid5yearperp").hide();

				$('#totalpriceforallproduct3yearsubs').val(
						decodeURIComponent(aaa[9]));
			}

			$('#totalpriceforallproduct').val(
					decodeURIComponent(aaa[9]));
			$('#deploysupport').val(decodeURIComponent(aaa[10]));
			$('#clouddeploycharges').val(
					decodeURIComponent(aaa[11]));
			$('#subtotalB').val(decodeURIComponent(aaa[12]));

			let grandtotal = aaa[9] + aaa[12];
			// alert(grandtotal);
			$('#subtotalAB').val(grandtotal); // 
			if(aaa[16] === "AMC")
				{
				if ((aaa[15] == "File Not Attached")
						|| (aaa[15] == "NA") || (aaa[15] == "null")) {
					$('#downHidepofile').hide();
				} else {
					document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[15]);
					document.getElementById('filenameStandard').value = decodeURIComponent(aaa[15]);
					$('#poUploadDiv').show();
				}
				}else
					{
					if ((aaa[16] == "File Not Attached")
							|| (aaa[16] == "NA") || (aaa[16] == "null")) {
						$('#downHidepofile').hide();
					} else {
						document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[16]);
						document.getElementById('filenameStandard').value = decodeURIComponent(aaa[16]);
						$('#poUploadDiv').show();
					}
					}
		

			if ((aaa[26] == "NA") || (aaa[26] == "null")) {
				$('#SMnoteDiv').hide();
			} else {
				document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[26]);
				$('#SMnoteDiv').show();
			}

//			if ((aaa[27] == "NA") || (aaa[27] == "null")) {
//				$('#SMREJnoteDiv').hide();
//			} else {
//				document.getElementById('SMREJnote').innerHTML = decodeURIComponent(aaa[27]);
//				$('#SMREJnoteDiv').show();
//			}

//			if ((aaa[28] == "NA") || (aaa[28] == "null")) {
//				$('#SInotediv').hide();
//			} else {
//				document.getElementById('SInote').innerHTML = decodeURIComponent(aaa[28]);
//				$('#SInotediv').show();
//			}

			if ((aaa[27] == "NA") || (aaa[27] == "null")) {
				$('#MDnoteDiv').hide();
			} else {
				document.getElementById('MDnote').innerHTML = decodeURIComponent(aaa[27]);
				$('#MDnoteDiv').show();
			}
//
//			if ((aaa[30] == "NA") || (aaa[30] == "null")) {
//				$('#MDRejnoteDiv').hide();
//			} else {
//				document.getElementById('MDRejnote').innerHTML = decodeURIComponent(aaa[30]);
//				$('#MDRejnoteDiv').show();
//			}

		});
	
}

function downFileStandard()
{
    var filename = $('#filenameStandard').val();
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
