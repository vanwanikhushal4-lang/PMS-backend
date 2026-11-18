


window.onload = function(){

	 $('.nav-tabs a').click(function () {
	        $(this).tab('show');
	    });
		
	
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getRevisedProposalApprovalDataMD";
	    
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: "crno=" + $('#crnoo').val()
	        + '&tid=' + $("#tid").val()
	    }).done(function(data) {
//	    	alert("ApprovalDataMD:"+data)
	    	var aaa = data[0];
	    	console.log(data)
    	

$('#Proposaltype').val(decodeURIComponent(aaa[16]));
   $('#poinitiator').val(decodeURIComponent(data[0][0]));
   $('#poinitiatorno').val(decodeURIComponent(data[0][1]));
   $('#FirstApprovername').val(decodeURIComponent(data[0][2]));
   $('#firstapprovercontact').val(decodeURIComponent(aaa[3]));
   $('#clientname').val(decodeURIComponent(aaa[6]));
   $('#Description').val(decodeURIComponent(aaa[7]));
   
 
   
   if(aaa[15] == "AMC"){
	   $('#Proposaltype').val(decodeURIComponent(aaa[15]));
   }
   else{
	   $('#Proposaltype').val(decodeURIComponent(aaa[16]));
   }
  
   
   
   $('#grandtotal').val(decodeURIComponent(aaa[21]));
   $('#total18percentage').val(decodeURIComponent(aaa[22]));
   $('#totalc').val(decodeURIComponent(aaa[23]));
//   alert(aaa[24])
   $('#clouddeploychargess').val(decodeURIComponent(aaa[26]));
   $('#enccustomername').val(decodeURIComponent(aaa[25]));
   $('#integrationcharge').val(decodeURIComponent(aaa[35]));
   
   
   
   
   if((aaa[15] == "AMC")){
	   //29/06
	   if ((aaa[38] === "Distributor")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[38]));
	   	
	   	$('#hidePartnerName').show();
	   	$('#PartnerName').val(decodeURIComponent(aaa[39]));
	   
	   }else {
			$('#proposalFor').val(decodeURIComponent(aaa[38]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   
	   
	   if ((aaa[38] === "Partner")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[38]));
	   	
	   	$('#hidePartnerName').hide();
	   
	   }else if((aaa[38] === "End customer")){
	   	$('#proposalFor').val(decodeURIComponent(aaa[38]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   //
  
   }else if((aaa[16] == "Perpetual")){
	   //29/06
	   if ((aaa[39] === "Distributor")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	
	   	$('#hidePartnerName').show();
	   	$('#PartnerName').val(decodeURIComponent(aaa[40]));
	   
	   }else {
			$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   
	   
	   if ((aaa[39] === "Partner")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	
	   	$('#hidePartnerName').hide();
	   
	   }else if((aaa[39] === "End customer")){
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   //
   }else if((aaa[16] == "Subscription")){
	   
	 //29/06
	   if ((aaa[39] === "Distributor")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	
	   	$('#hidePartnerName').show();
	   	$('#PartnerName').val(decodeURIComponent(aaa[40]));
	   
	   }else {
			$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   
	   
	   if ((aaa[39] === "Partner")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	
	   	$('#hidePartnerName').hide();
	   
	   }else if((aaa[39] === "End customer")){
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   //
   }
   else if((aaa[16] == "Subscription & Perpectual")){
	 
	 //29/06
	   if ((aaa[39] === "Distributor")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	
	   	$('#hidePartnerName').show();
	   	$('#PartnerName').val(decodeURIComponent(aaa[40]));
	   
	   }else {
			$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   
	   
	   if ((aaa[39] === "Partner")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	
	   	$('#hidePartnerName').hide();
	   
	   }else if((aaa[39] === "End customer")){
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   //
   }else if((aaa[16] == "Resource")){
	 
	   //29/06
	   if ((aaa[39] === "Distributor")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	
	   	$('#hidePartnerName').show();
	   	$('#PartnerName').val(decodeURIComponent(aaa[40]));
	   
	   }else {
			$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   
	   
	   if ((aaa[39] === "Partner")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	
	   	$('#hidePartnerName').hide();
	   
	   }else if((aaa[39] === "End customer")){
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   //
   }else if((aaa[16] == "Fixed")){
	 
	 //29/06
	   if ((aaa[39] === "Distributor")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	
	   	$('#hidePartnerName').show();
	   	$('#PartnerName').val(decodeURIComponent(aaa[40]));
	   
	   }else {
			$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   
	   
	   if ((aaa[39] === "Partner")) {
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	
	   	$('#hidePartnerName').hide();
	   
	   }else if((aaa[39] === "End customer")){
	   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
	   	$('#hidePartnerName').hide();
	   	 
		}
	   //
   }
   
   
   //29/06
//   if ((aaa[39] === "Distributor")) {
//   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
//   	
//   	$('#hidePartnerName').show();
//   	$('#PartnerName').val(decodeURIComponent(aaa[40]));
//   
//   }else {
//		$('#proposalFor').val(decodeURIComponent(aaa[39]));
//   	$('#hidePartnerName').hide();
//   	 
//	}
//   
//   
//   if ((aaa[39] === "Partner")) {
//   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
//   	
//   	$('#hidePartnerName').hide();
//   
//   }else if((aaa[39] === "End customer")){
//   	$('#proposalFor').val(decodeURIComponent(aaa[39]));
//   	$('#hidePartnerName').hide();
//   	 
//	}
   //
   
   
   
   if ((aaa[16] == "Perpetual") )
   {
	   $('#Proposaltype').val(decodeURIComponent(aaa[16]));
       $('#perpetualhideid').show();
       
       $('#subscriptionhideid').hide();
       $('#Perpetualyear').val(decodeURIComponent(aaa[17]));
   } else if ((aaa[16] == "Subscription")){
   	 $('#subscriptionhideid').show();
   	 $('#perpetualhideid').hide();
   	 $('#Subscriptionyear').val(decodeURIComponent(aaa[20]));
   	    }
   
  // alert("Proposal Type"+aaa[15])
   
   
   if((aaa[15] === "AMC"))
   {
 	  // alert("pdf"+aaa[17])
 	   $('#DivHidesubtotal').hide();
 	   $('#Proposaltype').val(decodeURIComponent(aaa[15]));
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
 		$('#GSTDiv').hide();
 		
 		
 		
 		
 		


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
 		$('#amcenddate').val(decodeURIComponent(aaa[27]));
 		$('#productsuitdetails').val(decodeURIComponent(aaa[29]));
 		$('#securitysolutiondetails').val(decodeURIComponent(aaa[30]));
 		$('#descforamc').val(decodeURIComponent(aaa[28]));
 		$('#totalcostAMC').val(decodeURIComponent(aaa[31]));

 		$('#gstforamc').val(decodeURIComponent(aaa[33]));
 		$('#GRANDTOTALFORAMC').val(decodeURIComponent(aaa[32]));
 		
 		
 		
 		
 	}
 if((aaa[15])=== "AMC")
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
 
 
 
 if((aaa[15])=== "AMC"){
	  if ((aaa[38] === "Distributor")) {
		   	$('#proposalFor').val(decodeURIComponent(aaa[38]));
		   	
		   	$('#hidePartnerName').show();
		   	$('#PartnerName').val(decodeURIComponent(aaa[39]));
		   
		   }else {
				$('#proposalFor').val(decodeURIComponent(aaa[38]));
		   	$('#hidePartnerName').hide();
		   	 
			}
		   
		   
		   if ((aaa[38] === "Partner")) {
		   	$('#proposalFor').val(decodeURIComponent(aaa[38]));
		   	
		   	$('#hidePartnerName').hide();
		   
		   }else if((aaa[38] === "End customer")){
		   	$('#proposalFor').val(decodeURIComponent(aaa[38]));
		   	$('#hidePartnerName').hide();
		   	 
			}
 }
 
 
 
 if((aaa[17])=== "Fixed"){
	
}

 
 
 
 
 
 
 
 		
	 if ((aaa[37] == "NA") || (aaa[37] == "null"))
	 {
	     $('#SMnoteDiv').hide();
	 } else {
	     document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[37]);
	     $('#SMnoteDiv').show();
	 }
 
 			
   var data6 = aaa[8];
   
   if ((aaa[16] === "AMC")) {
	   $('#CMApprByMeTable').hide();
 	  
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
//} 


  var selectedValue = $("#Subscriptionyear").val();
	 if (selectedValue === "Annual Price") 
	 {
		$("#subtotalahideid").show();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		$('#subtotalA').val(decodeURIComponent(aaa[9]));	
	 }
	 else if(selectedValue === "3 year Subscription")
	{
		$("#subtotalahideid3yearsubs").show();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		$('#totalpriceforallproduct3yearsubs').val(decodeURIComponent(aaa[9]));
	}	     
      
   
   
  // alert(aaa[9])
   $('#totalpriceforallproduct').val(decodeURIComponent(aaa[9]));
   $('#deploysupport').val(decodeURIComponent(aaa[10]));
   $('#clouddeploycharges').val(decodeURIComponent(aaa[11]));
   $('#subtotalB').val(decodeURIComponent(aaa[12])); 
   let grandtotal = aaa[9] + aaa[12];
 
   $('#subtotalAB').val(grandtotal);
   
   
   if(aaa[15]=== "AMC"){
	   
	   if ((aaa[13] == "NA") || (aaa[13] == "null"))
	   {
	       $('#SInoteDiv').hide();
	   } else {
	       document.getElementById('SInote').innerHTML = decodeURIComponent(aaa[13]);
	       $('#SInoteDiv').show();
	   }    
	   
	   if ((aaa[37] == "NA") || (aaa[37] == "null"))
	   {
	       $('#SMnoteDiv').hide();
	   } else {
	       document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[37]);
	       $('#SMnoteDiv').show();
	   }
	   
   }else{
	   if ((aaa[14] == "NA") || (aaa[14] == "null"))
	   {
	       $('#SInoteDiv').hide();
	   } else {
	       document.getElementById('SInote').innerHTML = decodeURIComponent(aaa[14]);
	       $('#SInoteDiv').show();
	   }    
	   
	   if ((aaa[38] == "NA") || (aaa[38] == "null"))
	   {
	       $('#SMnoteDiv').hide();
	   } else {
	       document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[38]);
	       $('#SMnoteDiv').show();
	   }
   }
   
   if((aaa[16] === "Fixed")){
   	
   	$('#fixedhideid').show();
   	$('#fixedyear').val(decodeURIComponent(aaa[37]));
   	
   }
  
   
       
   $('#resoucesamount').val(decodeURIComponent(aaa[18]));
   $('#ATC').val(aaa[19]);

});
	    
	    	
}


$("#ApproveMD").click(function () {


	            $('#spin1').show();
	            
	            var l = window.location;
	    	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    	 	var serviceUrl = base_url + "/UserActivity/UpdateRevisedProposalApproveMD";
	            
	            $.ajax({
	                url: serviceUrl, 
	                type: 'POST',
	                data: "crno=" + $('#crnoo').val()
	                    + "&tid=" + $('#tid').val(),
	                      
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
	                            window.location.href = base_url + "/User/pendingRevisedProposalMD";
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
	                            window.location.href = base_url + "/User/pendingRevisedProposalMD";
	                        }

	                    })
	                }


	            });
	        });





function downFileStandard()
{
var filename = $('#filenameStandard').val();
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}



function myFunctionReject() {

	
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
	                 	var serviceUrl = base_url + "/UserActivity/MDrejectVP";
	                    
	                    $.ajax({
	                        type: "POST",
	                        url: serviceUrl,
	                        data: "val=" + encodeURIComponent(result)
	                                + "&crno=" + $('#crnoo').val()
	                                + "&tid=" + $('#tid').val()
	                                + "&MDnote=" + encodeURIComponent($('#MDnote').val()),
	                
	                    }).done(function(data) {
	                        $('#spin2').hide();
	                       
	                        if (data == "success") {
	                            swal({
	                                title: "Successful!",
	                                text: "Approved Proposal Successfully",
	                                type: "success",
	                                width: 300,
	                                height: 200,
	                                confirmButtonClass: "btn btn-success",
	                                confirmButtonText: "OK",
	                                preConfirm: function() {
	                                    var l = window.location;
	                                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                                    window.location.href = base_url + "/User/pendingVlxProposal";
	                                }
	                            })
	                        }
	                        else {
	                            swal({
	                                title: "Fail!",
	                                text: "Rejected Proposal Successfully",
	                                type: "error",
	                                width: 300,
	                                height: 200,
	                                confirmButtonClass: "btn btn-success",
	                                confirmButtonText: "OK",
	                                preConfirm: function() {
	                                    var l = window.location;
	                                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                                    window.location.href = base_url + "/User/pendingVlxProposal";
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



//29/06

//