


window.onload = function(){
	proposaltypedata();	

	 $('.nav-tabs a').click(function () {
	        $(this).tab('show');
	    });
	 $('#SInoteDiv').hide();
	
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getRevisedProposalPendingDataSM";
	    
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: "crno=" + $('#crnoo').val()
	        + '&tid=' + $("#tid").val()
	    }).done(function(data) {
//	    	alert(".*PendingDataSM:"+data)
	    	var aaa = data[0];
	    	console.log(aaa)
    	
    $('#poinitiator').val(decodeURIComponent(data[0][0]));
    $('#poinitiatorno').val(decodeURIComponent(data[0][1]));
    $('#FirstApprovername').val(decodeURIComponent(data[0][2]));
    $('#firstapprovercontact').val(decodeURIComponent(aaa[3]));
//    $('#prodliscense').val(decodeURIComponent(aaa[4]));
//    $('#prodamount').val(decodeURIComponent(aaa[5]));
    $('#clientname').val(decodeURIComponent(aaa[6]));
    $('#Description').val(decodeURIComponent(aaa[7]));
    
    $('#Proposaltype').val(decodeURIComponent(aaa[17]));

    if ((aaa[17] == "Perpetual") )
    {
        $('#perpetualhideid').show();
        $('#subscriptionhideid').hide();
        $('#Perpetualyear').val(decodeURIComponent(aaa[18]));
        
        
        //29/06
	    if ((aaa[37] === "Distributor")) {
	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
	    	
	    	$('#hidePartnerName').show();
	    	$('#PartnerName').val(decodeURIComponent(aaa[38]));
	    
	    }else {
	    	$('#hidePartnerName').hide();
	    	 
		}
	    
	    if ((aaa[37] === "Partner")) {
        	$('#proposalFor').val(decodeURIComponent(aaa[37]));
        	
        	$('#hidePartnerName').hide();
	    
	    }else if((aaa[37] === "End customer")){
	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
	    	$('#hidePartnerName').hide();
	    	 
		}else if((aaa[37] === "NA")){
			$('#proposalFor').val("NA");
		}
	    //
        
    } else if ((aaa[17] == "Subscription")){
    	 $('#subscriptionhideid').show();
    	 $('#perpetualhideid').hide();
    	 $('#Subscriptionyear').val(decodeURIComponent(aaa[35]));
    	 
    	 
    	 
    	//29/06
 	    if ((aaa[37] === "Distributor")) {
 	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
 	    	
 	    	$('#hidePartnerName').show();
 	    	$('#PartnerName').val(decodeURIComponent(aaa[38]));
 	    
 	    }else {
 	    	$('#hidePartnerName').hide();
 	    	 
 		}
 	    
 	    if ((aaa[37] === "Partner")) {
         	$('#proposalFor').val(decodeURIComponent(aaa[37]));
         	
         	$('#hidePartnerName').hide();
 	    
 	    }else if((aaa[37] === "End customer")){
 	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
 	    	$('#hidePartnerName').hide();
 	    	 
 		}else if((aaa[37] === "NA")){
 			$('#proposalFor').val("NA");
 		}
 	    //

    }else if ((aaa[17] == "Fixed")){

	 
	//29/06
	    if ((aaa[37] === "Distributor")) {
	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
	    	
	    	$('#hidePartnerName').show();
	    	$('#PartnerName').val(decodeURIComponent(aaa[38]));
	    
	    }else {
	    	$('#hidePartnerName').hide();
	    	 
		}
	    
	    if ((aaa[37] === "Partner")) {
     	$('#proposalFor').val(decodeURIComponent(aaa[37]));
     	
     	$('#hidePartnerName').hide();
	    
	    }else if((aaa[37] === "End customer")){
	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
	    	$('#hidePartnerName').hide();
	    	 
		}else if((aaa[37] === "NA")){
			$('#proposalFor').val("NA");
		}
	    //

    }else if((aaa[17] == "Subscription & Perpetual")){
    	//29/06
	    if ((aaa[37] === "Distributor")) {
	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
	    	
	    	$('#hidePartnerName').show();
	    	$('#PartnerName').val(decodeURIComponent(aaa[38]));
	    
	    }else {
	    	$('#hidePartnerName').hide();
	    	 
		}
	    
	    if ((aaa[37] === "Partner")) {
     	$('#proposalFor').val(decodeURIComponent(aaa[37]));
     	
     	$('#hidePartnerName').hide();
	    
	    }else if((aaa[37] === "End customer")){
	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
	    	$('#hidePartnerName').hide();
	    	 
		}else if((aaa[37] === "NA")){
			$('#proposalFor').val("NA");
		}
	    //
    }
    else if((aaa[17] == "Resource")){
    	//29/06
	    if ((aaa[37] === "Distributor")) {
	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
	    	
	    	$('#hidePartnerName').show();
	    	$('#PartnerName').val(decodeURIComponent(aaa[38]));
	    
	    }else {
	    	$('#hidePartnerName').hide();
	    	 
		}
	    
	    if ((aaa[37] === "Partner")) {
     	$('#proposalFor').val(decodeURIComponent(aaa[37]));
     	
     	$('#hidePartnerName').hide();
	    
	    }else if((aaa[37] === "End customer")){
	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
	    	$('#hidePartnerName').hide();
	    	 
		}else if((aaa[37] === "NA")){
			$('#proposalFor').val("NA");
		}
	    //
    }
    
    
    
    
    
  //  alert(aaa[15])
    if ((aaa[16] === "AMC")) {
 	   //alert("pdf"+aaa[17])
 	   $('#DivHidesubtotal').hide();
 	   $('#Proposaltype').val(decodeURIComponent(aaa[16]));
// 	   $('#SMnote').val(decodeURIComponent(aaa[16]));
 		$('#AMCSTARTENDHIDEID').show();
 		$('#productsuitandtoolhideid').show();
 		$('#descandtotalcosthideid').show();
 		$('#hideDivgst').hide();
 		$('#hideDivsubtotal').hide();
 		$('#CMApprByMeTable').hide();
 		$('#DivCMApprByMeTable').hide();
 		$('#resourceDiv').hide();
 		$('#ATCDIV').hide();
 		
 		if ((aaa[15] == "File Not Attached") || (aaa[15] == "NA") || (aaa[15] == "null"))
        {
            $('#poUploadDiv').hide();
        } else {
            document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[15]);
            document.getElementById('filenameStandard').value = decodeURIComponent(aaa[15]);
            $('#poUploadDiv').show();
        }


 		$('#hideresourceforamc').hide();
 		$('#hidereATCforamc').hide();

 		$('#CMApprByMeTable').hide();
 		$('#hidealldetailforamc').hide();
 		$('#hidegstandgrandtotalforamc').hide();

 		$('#subscriptionhideid').hide();
 		$('#perpetualhideid').hide();
 		$('#fixedhideid').hide();
 		$('#Subscriptionyear').val(decodeURIComponent(aaa[20]));

 		$('#amcstartdate').val(decodeURIComponent(aaa[26]));
 		$('#amcenddate').val(decodeURIComponent(aaa[25]));
 		$('#productsuitdetails').val(decodeURIComponent(aaa[28]));
 		$('#securitysolutiondetails').val(decodeURIComponent(aaa[29]));
 		$('#descforamc').val(decodeURIComponent(aaa[27]));
 		$('#totalcostAMC').val(decodeURIComponent(aaa[30]));

 		$('#gstforamc').val(decodeURIComponent(aaa[32]));
 		$('#GRANDTOTALFORAMC').val(decodeURIComponent(aaa[31]));
 		
 		
 		
 		
 		//29/06
	    if ((aaa[36] === "Distributor")) {
	    	$('#proposalFor').val(decodeURIComponent(aaa[36]));
	    	
	    	$('#hidePartnerName').show();
	    	$('#PartnerName').val(decodeURIComponent(aaa[37]));
	    
	    }else {
	    	$('#hidePartnerName').hide();
	    	 
		}
	    
	    if ((aaa[36] === "Partner")) {
        	$('#proposalFor').val(decodeURIComponent(aaa[36]));
        	
        	$('#hidePartnerName').hide();
	    
	    }else if((aaa[36] === "End customer")){
	    	$('#proposalFor').val(decodeURIComponent(aaa[36]));
	    	$('#hidePartnerName').hide();
	    	 
		}else if((aaa[36] === "NA")){
			$('#proposalFor').val("NA");
		}
	    //
 		
 	}

    ///
    $('#resoucesamount').val((aaa[19]));
    $('#ATC').val(aaa[20]);
    if ((aaa[16] === "AMC")) {
    	 $('#enccustomername').val(aaa[20]);
    }else{
    	 $('#enccustomername').val(aaa[21]);
    }
  // alert(aaa[39])
    $('#integrationcharge').val(aaa[34]);
    $('#totalc').val(aaa[23]);  
    $('#total18percentage').val(aaa[24]);
    $('#grandtotal').val(aaa[25]);

    
//    	//29/06
//	    if ((aaa[37] === "Distributor")) {
//	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
//	    	
//	    	$('#hidePartnerName').show();
//	    	$('#PartnerName').val(decodeURIComponent(aaa[38]));
//	    
//	    }else {
//	    	$('#hidePartnerName').hide();
//	    	 
//		}
//	    
//	    if ((aaa[37] === "Partner")) {
//        	$('#proposalFor').val(decodeURIComponent(aaa[37]));
//        	
//        	$('#hidePartnerName').hide();
//	    
//	    }else if((aaa[37] === "End customer")){
//	    	$('#proposalFor').val(decodeURIComponent(aaa[37]));
//	    	$('#hidePartnerName').hide();
//	    	 
//		}else if((aaa[37] === "NA")){
//			$('#proposalFor').val("NA");
//		}
//	    //

    var data6 = aaa[8];
   

   
    if ((aaa[16] === "AMC")) {
 	   $('#CMApprByMeTable').DataTable().hide();
    }else{
    var table = $('#CMApprByMeTable').DataTable({
    	  lengthChange: false,
    	  pageLength: 5,
    	  data: aaa[8],
    	  dataType: 'json',
    	  scrollX: '300px',
         });
    }
    
    
    var selectedValue = $("#Perpetualyear").val();
	
	 if (selectedValue === "1 year Warranty") 
	 {
//		alert("inside 1 pep")
		$("#subtotalahideid").show();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearsubs").hide();
		
		 $('#subtotalA').val(decodeURIComponent(aaa[9]));
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

   var selectedValue = $("#Subscriptionyear").val();
	 if (selectedValue === "Annual Price") 
	 {
		$("#subtotalahideid").show();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		$('#totalpriceforallproduct').val(decodeURIComponent(aaa[9]));	
		if($('#ATC').val() == '')
			{
			$('#ATC').val('NA');
			}
	 }
	 else if(selectedValue === "3 year Subscription")
	{
		$("#subtotalahideid3yearsubs").show();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		$('#totalpriceforallproduct3yearsubs').val(decodeURIComponent(aaa[9]));
	}	     

   // $('#subtotalA').val(decodeURIComponent(aaa[9]));
    $('#deploysupport').val(decodeURIComponent(aaa[10]));
    $('#clouddeploycharges').val(decodeURIComponent(aaa[11]));
    $('#subtotalB').val(decodeURIComponent(aaa[12]));
   
  
    let grandtotal = aaa[9] + aaa[12];
//    alert(grandtotal);
    $('#subtotalAB').val(grandtotal);
    
    if ((aaa[14] == "NA") || (aaa[14] == "null"))
    {
        $('#SInoteDiv').hide();
    } else {
        document.getElementById('SInote').innerHTML = decodeURIComponent(aaa[14]);
        $('#SInoteDiv').show();
    }
    
 if((aaa[17] === "Fixed")){
    	
    	$('#fixedhideid').show();
    	$('#fixedyear').val(decodeURIComponent(aaa[36]));
    	
    }
    
    
    
    
//    $('#SMnote').val(decodeURIComponent(aaa[16]));
        
    if ((aaa[16] === "AMC")){
 	   if ((aaa[15] == "File Not Attached") || (aaa[15] == "NA") || (aaa[15] == "null"))
        {
            $('#poUploadDiv').hide();
        } else {
            document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[15]);
            document.getElementById('filenameStandard').value = decodeURIComponent(aaa[15]);
            $('#poUploadDiv').show();
        }
    }else{
   if ((aaa[16] == "File Not Attached") || (aaa[16] == "NA") || (aaa[16] == "null"))
            {
                $('#downHidepofile').hide();
            } else {
                document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[16]);
                document.getElementById('filenameStandard').value = decodeURIComponent(aaa[16]);
                $('#poUploadDiv').show();
            }
    }
    
    
    
    
   

});
	
}


function proposaltypedata()
{
	//alert("HIHI")
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

$("#ApproveCM").click(function () {


	            $('#spin1').show();
	            
	            var l = window.location;
	    	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    	 	var serviceUrl = base_url + "/UserActivity/UpdateRevisedPropSMApprove";
	            
	            $.ajax({
	                url: serviceUrl, 
	                type: 'POST',
	                data: "crno=" + $('#crnoo').val()
	                    + "&tid=" + $('#tid').val()
	                    + "&SMnote=" + encodeURIComponent($('#SMnote').val()),
	                      
	            }).done(function (data) {
	                $('#spin1').hide();
	                if (data === "success")
	                {
	                    swal({
	                        title: "Successful!",
	                        text: "Document Approved Successfully",
	                        type: "success",
	                        width: 300,
	                        height: 200,
	                        confirmButtonClass: "btn btn-success",
	                        cancelButtonClass: "btn btn-danger m-l-10",
	                        confirmButtonText: "OK",
	                        preConfirm: function () {
	                            var l = window.location;
	                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                            window.location.href = base_url + "/User/pendingRevisedProposalSMApproval";
	                        }
	                    })
	                } else
	                {
	                    swal({
	                        title: "Fail!",
	                        text: "Document Approved UnSuccessful",
	                        type: "error",
	                        width: 300,
	                        height: 200,
	                        // showCancelButton: !0,
	                        confirmButtonClass: "btn btn-success",
	                        cancelButtonClass: "btn btn-danger m-l-10",
	                        confirmButtonText: "OK",
	                        preConfirm: function () {
	                            var l = window.location;
	                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                            window.location.href = base_url + "/User/pendingRevisedProposalSMApproval";
	                        }

	                    })
	                }


	            });
	        });



function rejectFunction() {

    swal({
        title: 'Enter Your Reason',
        input: 'textarea',
        inputPlaceholder: "Enter Your Reason",
        showCancelButton: true,
        confirmButtonText: 'Submit',
        preConfirm: function(result) {
            // alert("value: "+result)
            return new Promise(function(resolve, reject) {

                if (result === "") {
                    swal.showValidationError(
                            'You Need To Write Your Reason!'
                            )

                    $('.swal2-confirm').prop('disabled', false);
                    $('.swal2-cancel').prop('disabled', false);
                    return false;
                }
                else {
                    swal.resetValidationError()
                    
                    $('#spin2').show();
                    
                    var l = window.location;
                 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                 	var serviceUrl = base_url + "/UserActivity/RejectRevisedProposalSM";
                    
                    $.ajax({
                        type: "POST",
                        url: serviceUrl,
                        data: "val=" + encodeURIComponent(result)
                                + "&crno=" + $('#crnoo').val()
                                + "&tid=" + $('#tid').val()
                                + "&SMnote=" + encodeURIComponent($('#SMnote').val()),
                
                    }).done(function(data) {
                        $('#spin2').hide();
                        if (data == "success") {
                            swal({
                                title: "Successful!",
                                text: "Raised CRF Rejected Successfully",
                                type: "success",
                                width: 300,
                                height: 200,
                                confirmButtonClass: "btn btn-success",
                                confirmButtonText: "OK",
                                preConfirm: function() {
                                    var l = window.location;
                                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                                    window.location.href = base_url + "/User/pendingRevisedProposalSMApproval";
                                }
                            })
                        }
                        else {
                            swal({
                                title: "Fail!",
                                text: "Raised CRF Rejected UnSuccessful",
                                type: "error",
                                width: 300,
                                height: 200,
                                confirmButtonClass: "btn btn-success",
                                confirmButtonText: "OK",
                                preConfirm: function() {
                                    var l = window.location;
                                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                                    window.location.href = base_url + "/User/pendingRevisedProposalSMApproval";
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

function downFileStandard()
{
    var filename = $('#filenameStandard').val();
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}