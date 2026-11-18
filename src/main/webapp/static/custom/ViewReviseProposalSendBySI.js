/**
 * 
 */

var subcategory = "";
var statusCI = "";


window.onload = function(){
	proposaltypedata();	


	    $('#SInoteDiv').hide();
//	    $('#custom-tabs-one-home').hide();

	    //subcategory = $('#subcategory1').val();
	    statusCI = $('#statusCI').val();

	  
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getReviseProposalSIsendData";
	    
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: "crno=" + $('#crnoo').val()
	        + '&tid=' + $("#tid").val()
	    }).done(function(data) {
	    	//alert(data)
	    	var aaa = data[0];
	    	console.log(data)
	    	//alert(aaa[15])


	    	
   $('#poinitiator').val(decodeURIComponent(data[0][0]));
   $('#poinitiatorno').val(decodeURIComponent(data[0][1]));
   $('#FirstApprovername').val(decodeURIComponent(data[0][2]));
   $('#firstapprovercontact').val(decodeURIComponent(aaa[3]));
//   $('#prodliscense').val(decodeURIComponent(aaa[4]));
//   $('#prodamount').val(decodeURIComponent(aaa[5]));
   $('#clientname').val(decodeURIComponent(aaa[6]));
   $('#Description').val(decodeURIComponent(aaa[7]));
   
   //
  
   
   $('#Proposaltype').val(decodeURIComponent(aaa[16]));
 //  $('#Perpetualyear').val(decodeURIComponent(aaa[17]));
   $('#grandtotal').val(decodeURIComponent(aaa[21]));
   $('#total18percentage').val(decodeURIComponent(aaa[22]));
   $('#totalc').val(decodeURIComponent(aaa[23]));
//   alert(aaa[24])
   $('#clouddeploychargess').val(decodeURIComponent(aaa[24]));
   $('#enccustomername').val(decodeURIComponent(aaa[25]));

 //  

///
   if ((aaa[16] == "Perpetual") )
   {
       $('#perpetualhideid').show();
       $('#subscriptionhideid').hide();
       $('#Perpetualyear').val(decodeURIComponent(aaa[17]));
       
       
       
       //01/07
       if ((aaa[35] === "Distributor")) {
    	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
    	   	
    	   	$('#hidePartnerName').show();
    	   	$('#PartnerName').val(decodeURIComponent(aaa[36]));
    	   
    	   }else {
    	   	$('#hidePartnerName').hide();
    	   	 
    		}
    	   
    	   
    	   if ((aaa[35] === "Partner")) {
    	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
    	   	
    	   	$('#hidePartnerName').hide();
    	   
    	   }else if((aaa[35] === "End customer")){
    	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
    	   	$('#hidePartnerName').hide();
    	   	 
    		}else if((aaa[35] === "NA")){
    			$('#proposalFor').val("NA");
    		}
    	   
    	   //recently made changes

     //  
   } else if ((aaa[16] == "Subscription")){
   	 $('#subscriptionhideid').show();
   	 $('#perpetualhideid').hide();
   	 $('#Subscriptionyear').val(decodeURIComponent(aaa[20]));
   	 
   	 
     //01/07
     if ((aaa[35] === "Distributor")) {
  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
  	   	
  	   	$('#hidePartnerName').show();
  	   	$('#PartnerName').val(decodeURIComponent(aaa[36]));
  	   
  	   }else {
  	   	$('#hidePartnerName').hide();
  	   	 
  		}
  	   
  	   
  	   if ((aaa[35] === "Partner")) {
  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
  	   	
  	   	$('#hidePartnerName').hide();
  	   
  	   }else if((aaa[35] === "End customer")){
  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
  	   	$('#hidePartnerName').hide();
  	   	 
  		}else if((aaa[35] === "NA")){
  			$('#proposalFor').val("NA");
  		}
  	   
  	   //recently made changes

   //  

   }else if((aaa[16] == "Fixed")){
	 //01/07
	     if ((aaa[35] === "Distributor")) {
	  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
	  	   	
	  	   	$('#hidePartnerName').show();
	  	   	$('#PartnerName').val(decodeURIComponent(aaa[36]));
	  	   
	  	   }else {
	  	   	$('#hidePartnerName').hide();
	  	   	 
	  		}
	  	   
	  	   
	  	   if ((aaa[35] === "Partner")) {
	  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
	  	   	
	  	   	$('#hidePartnerName').hide();
	  	   
	  	   }else if((aaa[35] === "End customer")){
	  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
	  	   	$('#hidePartnerName').hide();
	  	   	 
	  		}else if((aaa[35] === "NA")){
	  			$('#proposalFor').val("NA");
	  		}
	  	   
	  	   //recently made changes
   }else if((aaa[16] == "Resource")){
	   //01/07
	     if ((aaa[35] === "Distributor")) {
	  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
	  	   	
	  	   	$('#hidePartnerName').show();
	  	   	$('#PartnerName').val(decodeURIComponent(aaa[36]));
	  	   
	  	   }else {
	  	   	$('#hidePartnerName').hide();
	  	   	 
	  		}
	  	   
	  	   
	  	   if ((aaa[35] === "Partner")) {
	  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
	  	   	
	  	   	$('#hidePartnerName').hide();
	  	   
	  	   }else if((aaa[35] === "End customer")){
	  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
	  	   	$('#hidePartnerName').hide();
	  	   	 
	  		}else if((aaa[35] === "NA")){
	  			$('#proposalFor').val("NA");
	  		}
	  	   
	  	   //recently made changes
   
   }else if((aaa[16] == "Subscription & Perpectual")){
	   //01/07
	     if ((aaa[35] === "Distributor")) {
	  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
	  	   	
	  	   	$('#hidePartnerName').show();
	  	   	$('#PartnerName').val(decodeURIComponent(aaa[36]));
	  	   
	  	   }else {
	  	   	$('#hidePartnerName').hide();
	  	   	 
	  		}
	  	   
	  	   
	  	   if ((aaa[35] === "Partner")) {
	  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
	  	   	
	  	   	$('#hidePartnerName').hide();
	  	   
	  	   }else if((aaa[35] === "End customer")){
	  	   	$('#proposalFor').val(decodeURIComponent(aaa[35]));
	  	   	$('#hidePartnerName').hide();
	  	   	 
	  		}else if((aaa[35] === "NA")){
	  			$('#proposalFor').val("NA");
	  		}
	  	   
	  	   //recently made changes
 }
   
   
   
   
   if ((aaa[15] === "AMC")) {
	   //alert("pdf"+aaa[14])
	   $('#Proposaltype').val(decodeURIComponent(aaa[15]));
	 //  alert("deploycharge"+aaa[11])
		$('#AMCSTARTENDHIDEID').show();
		$('#productsuitandtoolhideid').show();
		$('#descandtotalcosthideid').show();
		$('#hideDivgst').hide();
		$('#hideDivsubtotal').hide();
		$('#CMApprByMeTable').hide();
		$('#tablehideDiv').hide();
		$('#resourceDiv').hide();
		$('#ATCDiv').hide();
		
		 
		

		$('#hideresourceforamc').hide();
		$('#hidereATCforamc').hide();

		$('#CMApprByMeTable').hide();
		$('#hidealldetailforamc').hide();
		$('#hidegstandgrandtotalforamc').hide();
		 $('#resoucesamount').hide();
		 $('#enccustomername').val(aaa[24]);

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
	//	alert(aaa[33])
		$('#gstforamc').val(decodeURIComponent(aaa[33]));
		$('#GRANDTOTALFORAMC').val(decodeURIComponent(aaa[31]));
		
		
		
		
		//01/07
		   if ((aaa[34] === "Distributor")) {
			   	$('#proposalFor').val(decodeURIComponent(aaa[34]));
			   	
			   	$('#hidePartnerName').show();
			   	$('#PartnerName').val(decodeURIComponent(aaa[35]));
			   
			   }else {
			   	$('#hidePartnerName').hide();
			   	 
				}
			   
			   
			   if ((aaa[34] === "Partner")) {
			   	$('#proposalFor').val(decodeURIComponent(aaa[34]));
			   	
			   	$('#hidePartnerName').hide();
			   
			   }else if((aaa[34] === "End customer")){
			   	$('#proposalFor').val(decodeURIComponent(aaa[34]));
			   	$('#hidePartnerName').hide();
			   	 
				}else if((aaa[34] === "NA")){
					$('#proposalFor').val("NA");
				}
			   
			   //recently made changes
	}

   ///
   if ((aaa[15] === "AMC")){
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
   

   if ((aaa[15] === "AMC")) {
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
  // alert("inter"+aaa[21])
   $('#subtotalA').val(decodeURIComponent(aaa[9]));
   $('#deploysupport').val(decodeURIComponent(aaa[10]));
   $('#clouddeploycharges').val(decodeURIComponent(aaa[11]));
   $('#subtotalB').val(decodeURIComponent(aaa[12]));
   $('#integrationcharges').val(decodeURIComponent(aaa[33]));
 
   let grandtotal = aaa[9] + aaa[12];
//   alert(grandtotal);
   $('#subtotalAB').val(grandtotal);
   
   if ((aaa[14] == "NA") || (aaa[14] == "null"))
   {
       $('#SInoteDiv').hide();
   } else {
       document.getElementById('SInote').innerHTML = decodeURIComponent(aaa[14]);
       $('#SInoteDiv').show();
   }
       
   
   $('#resoucesamount').val(decodeURIComponent(aaa[18]));
   $('#ATC').val(aaa[19]);

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


