/**
 * 
 */

var subcategory = "";
var statusCI = "";


window.onload = function(){
	proposaltypedata();	

	 $('.nav-tabs a').click(function () {
	        $(this).tab('show');
	    });
		
		

	    $('#SInoteDiv').hide();
//	    $('#custom-tabs-one-home').hide();

	    //subcategory = $('#subcategory1').val();
	    statusCI = $('#statusCI').val();

	  
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getVlxProposalData";
	    
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: "crno=" + $('#crnoo').val()
	        + '&tid=' + $("#tid").val()
	    }).done(function(data) {
	    	
	    	var aaa = data[0];
	    	console.log(data)    	
	    	   $('#poinitiator').val(decodeURIComponent(data[0][0]));
	    	   $('#poinitiatorno').val(decodeURIComponent(data[0][1]));
	    	   $('#FirstApprovername').val(decodeURIComponent(data[0][2]));
	    	   $('#firstapprovercontact').val(decodeURIComponent(aaa[3]));
	    	   $('#clientname').val(decodeURIComponent(aaa[6]));
	    	   $('#Description').val(decodeURIComponent(aaa[7]));  
	    	   $('#Proposaltype').val(decodeURIComponent(aaa[16]));
	    	   $('#grandtotal').val(decodeURIComponent(aaa[21]));
	    	   $('#total18percentage').val(decodeURIComponent(aaa[22]));
	    	   $('#totalc').val(decodeURIComponent(aaa[23]));
	    	   $('#clouddeploychargess').val(decodeURIComponent(aaa[26]));
	    	   $('#enccustomername').val(decodeURIComponent(aaa[26]));
	    	   $('#integrationcharge').val(decodeURIComponent(aaa[24]));
	    	   
	    	  // alert("xggdgddg :"+$('#integrationcharge').val())
	    	   if ((aaa[16] == "Perpetual") )
	    	   {
	    	       $('#perpetualhideid').show();
	    	       $('#subscriptionhideid').hide();
	    	       $('#Perpetualyear').val(decodeURIComponent(aaa[17]));
	    	       
	    	   	$('#CMApprByMeTable').show();
				var table = $('#CMApprByMeTable').DataTable({
					lengthChange: false,
					pageLength: 5,
					data: aaa[8],
					dataType: 'json',
					scrollX: '300px',
				});
				
				
				 $('#grandtotal').val(decodeURIComponent(aaa[22]));
				 $('#total18percentage').val(decodeURIComponent(aaa[23]));
				 $('#integrationcharge').val(decodeURIComponent(aaa[25]))
				 $('#totalc').val(decodeURIComponent(aaa[24]));
				 
				 $('#SMnote').val(decodeURIComponent(aaa[28])); 
				 $('#MDnote').val(decodeURIComponent(aaa[29]));
	    	   } else if ((aaa[16] == "Subscription")){
	    	   	 $('#subscriptionhideid').show();
	    	   	 $('#perpetualhideid').hide();
	    	   	$('#hidereATCforamc').hide();
	    	   	 $('#Subscriptionyear').val(decodeURIComponent(aaa[20]));
	    	   	  $('#grandtotal').val(decodeURIComponent(aaa[22]));
	    	   	  $('#total18percentage').val(decodeURIComponent(aaa[23]));
	    	   	  $('#totalc').val(decodeURIComponent(aaa[24]))
	    	   	 $('#integrationcharge').val(decodeURIComponent(aaa[25]));
	    	   	 
	    	   	  $('#SMnote').val(decodeURIComponent(aaa[28]));
	    	   	  $('#MDnote').val(decodeURIComponent(aaa[29]));
	    	   	 
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
	    	   else if ((aaa[16] === "Fixed")) {
	    				$('#fixedhideid').show();
	    				
	    				$('#subscriptionhideid').hide();
	    				$('#subscriptionhideid').hide();
	    				$('#fixedyear').val(decodeURIComponent(aaa[21]));

	    				$('#CMApprByMeTable').show();
	    				var table = $('#CMApprByMeTable').DataTable({
	    					lengthChange: false,
	    					pageLength: 5,
	    					data: aaa[8],
	    					dataType: 'json',
	    					scrollX: '300px',
	    				});
	    				
	    				 $('#grandtotal').val(decodeURIComponent(aaa[22]));
	    				 $('#total18percentage').val(decodeURIComponent(aaa[23]));
	    				 $('#totalc').val(decodeURIComponent(aaa[24]))
	    				 $('#integrationcharge').val(decodeURIComponent(aaa[25]));
	    				 $('#enccustomername').val(decodeURIComponent(aaa[26]));
	    				 
	    				  $('#SMnote').val(decodeURIComponent(aaa[28]));
	    	   	         $('#MDnote').val(decodeURIComponent(aaa[29]));
	    				
	    				
	    			} else if ((aaa[15] === "AMC")) {

	    				$('#AMCSTARTENDHIDEID').show();
	    				$('#productsuitandtoolhideid').show();
	    				$('#descandtotalcosthideid').show();

	    				$('#hideresourceforamc').hide();
	    				$('#hidereATCforamc').hide();

	    				$('#CMApprByMeTable').hide();
	    				$('#hidealldetailforamc').hide();
	    				$('#hidegstandgrandtotalforamc').hide();

	    				$('#subscriptionhideid').hide();
	    				$('#perpetualhideid').hide();
	    				$('#fixedhideid').hide();
	    				   $('#Proposaltype').val(decodeURIComponent(aaa[15]));
	    				$('#Subscriptionyear').val(decodeURIComponent(aaa[20]));

	    				$('#amcstartdate').val(decodeURIComponent(aaa[33]));
	    				$('#amcenddate').val(decodeURIComponent(aaa[34]));
	    				$('#productsuitdetails').val(decodeURIComponent(aaa[35]));
	    				$('#securitysolutiondetails').val(decodeURIComponent(aaa[36]));
	    				$('#descforamc').val(decodeURIComponent(aaa[37]));
	    				$('#totalcostAMC').val(decodeURIComponent(aaa[38]));

	    				$('#gstforamc').val(decodeURIComponent(aaa[39]));
	    				$('#GRANDTOTALFORAMC').val(decodeURIComponent(aaa[40]));
	    				
	    				 document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[28]);
	    				 document.getElementById('MDnote').innerHTML = decodeURIComponent(aaa[29]);
	    				


	    			}else if ((aaa[16] == "Resource")) {
													
					    $('#hideresourceforamc').hide();
					    $('#hidereATCforamc').hide();
						
						$('#hidealldetailforamc').hide();
						$('#hidegstandgrandtotalforamc').hide();
						$('#hideresourceforamc').hide();
						$('#hidereATCforamc').hide();

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
								decodeURIComponent(aaa[30]));
						$('#gstdataforresource').val(
								decodeURIComponent(aaa[31]));
						$('#grandtotalforresource').val(
								decodeURIComponent(aaa[32]));
								
						 document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[28]);		
					} else if ((aaa[16] === "Subscription & Perpetual")) {
						$('#combinationSubsANDPerpHideDIv').show();
						
						$('#subscriptionhideid').hide();

						$('#hidereATCforamc').hide();
						$('#perpetualhideid').hide();
						$('#fixedhideid').hide();
//						$('#Subscriptionyear').val(decodeURIComponent(aaa[41]));
						
						$('#CMApprByMeTable').show();
					    var table = $('#CMApprByMeTable').DataTable({
							lengthChange: false,
							pageLength: 5,
							data: aaa[8],
							dataType: 'json',
							scrollX: '300px',
						});
					    
					    $('#subscriptionANDperpetualhideid').show();
					 
					    $('#subscriptionANDperpetualYear').val(decodeURIComponent(aaa[41]));
					    
					    
					    $('#SubsANDPerpTable').show();
					    var table = $('#SubsANDPerpTable').DataTable({
							lengthChange: false,
							pageLength: 5,
							data: aaa[42],
							dataType: 'json',
							scrollX: '300px',
						});
					    
					    if ((aaa[43] === "") || (aaa[43] === "NA") || (aaa[43] === "null")) {
					    	
					    	$('#perpetualSubsAnnualPerpHideDiv').hide();
					    
					    }else {
					    	 $('#perpetualSubsAnnualperpType').val(decodeURIComponent(aaa[43]));
							$('#perpetualSubsAnnualPerpHideDiv').show();
						}
					    
			          if ((aaa[44] === "") || (aaa[44] === "NA") || (aaa[44] === "null")) {
					    	
					    	$('#perpetualSubs3yearPerpHideDiv').hide();
					    
					    }else {
					    	 $('#perpetualSubs3yearperpType').val(decodeURIComponent(aaa[44]));
							$('#perpetualSubs3yearPerpHideDiv').show();
						}
			          
			     
					}

				     $('#deploysupport21').val(decodeURIComponent(aaa[45]));
			         $('#clouddeploycharges21').val(decodeURIComponent(aaa[46]));
			         $('#IntegrationCharges21').val(decodeURIComponent(aaa[48]));
			         $('#subtotalB21').val(decodeURIComponent(aaa[49]));
			         $('#totalc21').val(decodeURIComponent(aaa[50]));
			         $('#total18percentage21').val(decodeURIComponent(aaa[51]));
			         
			         $('#grandtotal21').val(decodeURIComponent(aaa[52]));
			         $('#resoucesamount21').val(decodeURIComponent(aaa[53]));
					
					
			  if ((aaa[15] === "AMC"))
				  {
	    	  if ((aaa[14] == "File Not Attached") || (aaa[14] == "NA") || (aaa[14] == "null"))
	    	           {
	    	               $('#downHidepofile').hide();
	    	           } else {
	    	               document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[14]);
	    	               document.getElementById('filenameStandard').value = decodeURIComponent(aaa[14]);
	    	               $('#poUploadDiv').show();
	    	           }
				  }else{
					  
					  if ((aaa[15] == "File Not Attached") || (aaa[15] == "NA") || (aaa[15] == "null"))
	    	           {
	    	               $('#downHidepofile').hide();
	    	           } else {
	    	               document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[15]);
	    	               document.getElementById('filenameStandard').value = decodeURIComponent(aaa[15]);
	    	               $('#poUploadDiv').show();
	    	           }
					  
				  }
	    	   var data6 = aaa[8];

//	    	   var table = $('#CMApprByMeTable').DataTable({
//	    	   	  lengthChange: false,
//	    	   	  pageLength: 5,
//	    	   	  data: aaa[8],
//	    	   	  dataType: 'json',
//	    	   	  scrollX: '300px',
//	    	        });
	    	        

	  var selectedValue = $("#Perpetualyear").val();
	
	 if (selectedValue === "1 year Warranty") 
	 {
		
		$("#subtotalahideid").show();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearsubs").hide();
		
		 $('#totalpriceforallproduct').val(decodeURIComponent(aaa[9]));
		 
		//  alert("1 year perp :"+$('#totalpriceforallproduct').val())
	 }
	 else if(selectedValue === "3 year Warranty")
	{
		$("#subtotalahideid3yearperp").show();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearsubs").hide();	
		
		$('#totalpriceforallproduct3yearperp').val(decodeURIComponent(aaa[9]));
	}
	else if(selectedValue === "5 year Warranty")
	{
		$("#subtotalahideid5yearperp").show();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid").hide();	
		$("#subtotalahideid3yearsubs").hide();
		
		$('#totalpriceforallproduct5yearperp').val(decodeURIComponent(aaa[9]));
	}
//} 


    var selectedValue = $("#Subscriptionyear").val();
	 if (selectedValue === "Annual Price") 
	 {
		$("#subtotalahideid").show();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		 $('#totalpriceforallproduct').val(decodeURIComponent(aaa[9]));
		
		//alert("sfsfsf :"+$('#totalpriceforallproduct').val(decodeURIComponent(aaa[9])))	
	 }
	 else if(selectedValue === "3 year Subscription")
	{
		$("#subtotalahideid3yearsubs").show();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		$('#totalpriceforallproduct3yearsubs').val(decodeURIComponent(aaa[9]));
	}	
	
	// fixed
	
	
	var selectedValue = $("#fixedyear").val();
	 if (selectedValue === "3 year Warranty") 
	 {
		
		
		$("#subtotalahideid3yearfixed").show();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		$('#subtotal3yearfixed').val(decodeURIComponent(aaa[9]));	
	 }
	 else if(selectedValue === "5 year Warranty")
	{
		$("#subtotalahideid5yearfixed").show();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearfixed").hide();
		
		$('#subtotal5yearfixed').val(decodeURIComponent(aaa[9]));	
	}
	else
	{
		$("#subtotalahideid5yearfixed1").hide();
	    $("#subtotalahideid3yearfixedd").hide();
		
	}	
	    	        
	    	        
//	    	   $('#subtotalA').val(decodeURIComponent(aaa[9]));
	    	   $('#deploysupport').val(decodeURIComponent(aaa[10]));
	    	   $('#clouddeploycharges').val(decodeURIComponent(aaa[11]));
	    	   $('#subtotalB').val(decodeURIComponent(aaa[12])); 
	    	   let grandtotal = aaa[9] + aaa[12];
	    	 
	    	   $('#subtotalAB').val(grandtotal); 
	    	   
	    	   if ((aaa[27] == "NA") || (aaa[27] == "null"))
	    	   {
	    	       $('#SMnoteDiv').show();
	    	   } else {
	    	       document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[27]);
	    	       $('#SMnoteDiv').show();
	    	   }
	    	   
	    	   if ((aaa[28] == "NA") || (aaa[28] == "null"))
	    	   {
	    	       $('#MDnoteDiv').hide();
	    	   } else {
	    	       document.getElementById('MDnote').innerHTML = decodeURIComponent(aaa[29]);
	    	       $('#MDnoteDiv').show();
	    	   } 
	    	   
	    	   $('#resoucesamount').val(decodeURIComponent(aaa[18]));
	    	   $('#ATC').val(aaa[19]);
	    	   
	    	   
	    	   
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
//					$('#partnerName').val(aaa[54]);
					}
				}else{
					if(aaa[54] == "Distributor")
						{
						$('#hidePartnerName').show();
						$('#proposalFor').val(aaa[54]);
						$('#partnerName').val(aaa[55]);
						
						}
					else{
						$('#proposalForDiv').show()
						$('#hidePartnerName').hide()
						
						$('#proposalFor').val(aaa[54]);

						}
					
				}

	    	});

}


function proposaltypedata()
{
	var selectedValue = $("#Proposaltype").val();
	
	var selectedperpetual = $("#Perpetualyear").val();
	var selectedSubscription = $("#Subscriptionyear").val();
		  
            if (selectedValue === "Perpetual") {
                $("#perpetualhideid").show();
                $("#subscriptionhideid").hide();
                
             if(selectedperpetual === "3 year Warranty")  
             {
	          $("#secondandthirdyeatamchideid").show();
             }
             else if(selectedperpetual === "5 year Warranty")
             {
	           $("#secondandthirdyeatamchideid").show();
	            $("#fourAndfiveyearAmchideid").show();
	           	          
             } 
                
            } else if (selectedValue === "Subscription") { 
                $("#subscriptionhideid").show();
                 $("#perpetualhideid").hide();
                 
                if(selectedSubscription === "3 year Subscription") 
                {
	              $("#secondandthirdyearSubshideid").show();
	           
                }
                else if(selectedSubscription === "Annual Price")
                {
	              $("#subscriptionhideid").show();
	               $("#secondandthirdyearSubshideid").hide();
               }
          }
}
function downFileStandard()
{
    var filename = $('#filenameStandard').val();
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}


function advInvFileStandard()
{
    var filename = $('#filnameAdvinvoice').val();

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}


