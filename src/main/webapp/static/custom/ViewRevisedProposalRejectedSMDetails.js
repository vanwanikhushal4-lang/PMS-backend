


window.onload = function(){

	 $('.nav-tabs a').click(function () {
	        $(this).tab('show');
	    });
		
	
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getRevisedProposalRejectedDataSM";
	    
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: "crno=" + $('#crnoo').val()
	        + '&tid=' + $("#tid").val()
	    }).done(function(data) {
//	    	alert("ProposalRejectedDataSM:"+data);
	    	var aaa = data[0];
	    	console.log(data)
    	
    $('#poinitiator').val(decodeURIComponent(data[0][0]));
    $('#poinitiatorno').val(decodeURIComponent(data[0][1]));
    $('#FirstApprovername').val(decodeURIComponent(data[0][2]));
    $('#firstapprovercontact').val(decodeURIComponent(aaa[3]));
//    $('#prodliscense').val(decodeURIComponent(aaa[4]));
//    $('#prodamount').val(decodeURIComponent(aaa[5]));
    $('#clientname').val(decodeURIComponent(aaa[6]));
    $('#Description').val(decodeURIComponent(aaa[7]));
    
    $('#Proposaltype').val(decodeURIComponent(aaa[15]));
    
    
  
    
    
    

//  alert("aaa[17]"+aaa[15])
//  alert("aaa[18]"+aaa[16])
//  alert("aaa[19]"+aaa[17])
//  alert("aaa[20]"+aaa[18])
 
    if ((aaa[15] == "Perpetual") )
    {
        $('#perpetualhideid').show();
        $('#subscriptionhideid').hide();
        $('#Perpetualyear').val(decodeURIComponent(aaa[16]));
        
        
        
        
        //01/07
        if ((aaa[24] === "Distributor")) {
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	
     	   	$('#hidePartnerName').show();
     	   	$('#PartnerName').val(decodeURIComponent(aaa[25]));
     	   
     	   }else {
     	   	$('#hidePartnerName').hide();
     	   	 
     		}
     	   
     	   
     	   if ((aaa[24] === "Partner")) {
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	
     	   	$('#hidePartnerName').hide();
     	   
     	   }else if((aaa[24] === "End customer")){
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	$('#hidePartnerName').hide();
     	   	 
     		}else if((aaa[37] === "NA")){
     			$('#proposalFor').val("NA");
     		}
     	   
     	   //recently made changes
        
        
    } else if ((aaa[15] == "Subscription")){
    	 $('#subscriptionhideid').show();
    	 $('#perpetualhideid').hide();
    	 $('#Subscriptionyear').val(decodeURIComponent(aaa[16]));
    	 
    	 
    	 
    	//01/07
         if ((aaa[24] === "Distributor")) {
      	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
      	   	
      	   	$('#hidePartnerName').show();
      	   	$('#PartnerName').val(decodeURIComponent(aaa[25]));
      	   
      	   }else {
      	   	$('#hidePartnerName').hide();
      	   	 
      		}
      	   
      	   
      	   if ((aaa[24] === "Partner")) {
      	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
      	   	
      	   	$('#hidePartnerName').hide();
      	   
      	   }else if((aaa[24] === "End customer")){
      	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
      	   	$('#hidePartnerName').hide();
      	   	 
      		}else if((aaa[37] === "NA")){
      			$('#proposalFor').val("NA");
      		}
      	   
      	   //recently made changes

    }else if((aaa[15] == "Resource")){
    	//01/07
        if ((aaa[24] === "Distributor")) {
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	
     	   	$('#hidePartnerName').show();
     	   	$('#PartnerName').val(decodeURIComponent(aaa[25]));
     	   
     	   }else {
     	   	$('#hidePartnerName').hide();
     	   	 
     		}
     	   
     	   
     	   if ((aaa[24] === "Partner")) {
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	
     	   	$('#hidePartnerName').hide();
     	   
     	   }else if((aaa[24] === "End customer")){
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	$('#hidePartnerName').hide();
     	   	 
     		}else if((aaa[37] === "NA")){
     			$('#proposalFor').val("NA");
     		}
     	   
     	   //recently made changes
    
    }else if((aaa[15] == "Subscription & Perpetual")){
    	
    	//01/07
        if ((aaa[24] === "Distributor")) {
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	
     	   	$('#hidePartnerName').show();
     	   	$('#PartnerName').val(decodeURIComponent(aaa[25]));
     	   
     	   }else {
     	   	$('#hidePartnerName').hide();
     	   	 
     		}
     	   
     	   
     	   if ((aaa[24] === "Partner")) {
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	
     	   	$('#hidePartnerName').hide();
     	   
     	   }else if((aaa[24] === "End customer")){
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	$('#hidePartnerName').hide();
     	   	 
     		}else if((aaa[37] === "NA")){
     			$('#proposalFor').val("NA");
     		}
     	   
     	   //recently made changes
    
    }else if((aaa[15] == "Fixed")){
    	
    	//01/07
        if ((aaa[24] === "Distributor")) {
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	
     	   	$('#hidePartnerName').show();
     	   	$('#PartnerName').val(decodeURIComponent(aaa[25]));
     	   
     	   }else {
     	   	$('#hidePartnerName').hide();
     	   	 
     		}
     	   
     	   
     	   if ((aaa[24] === "Partner")) {
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	
     	   	$('#hidePartnerName').hide();
     	   
     	   }else if((aaa[24] === "End customer")){
     	   	$('#proposalFor').val(decodeURIComponent(aaa[24]));
     	   	$('#hidePartnerName').hide();
     	   	 
     		}else if((aaa[37] === "NA")){
     			$('#proposalFor').val("NA");
     		}
     	   
     	   //recently made changes
   
    }else if((aaa[15] == "AMC")){
    	
    	//01/07
        if ((aaa[23] === "Distributor")) {
     	   	$('#proposalFor').val(decodeURIComponent(aaa[23]));
     	   	
     	   	$('#hidePartnerName').show();
     	   	$('#PartnerName').val(decodeURIComponent(aaa[24]));
     	   
     	   }else {
     	   	$('#hidePartnerName').hide();
     	   	 
     		}
     	   
     	   
     	   if ((aaa[23] === "Partner")) {
     	   	$('#proposalFor').val(decodeURIComponent(aaa[23]));
     	   	
     	   	$('#hidePartnerName').hide();
     	   
     	   }else if((aaa[23] === "End customer")){
     	   	$('#proposalFor').val(decodeURIComponent(aaa[23]));
     	   	$('#hidePartnerName').hide();
     	   	 
     		}else if((aaa[23] === "NA")){
     			$('#proposalFor').val("NA");
     		}
     	   
     	   //recently made changes
    }
    
    
    
    

    ///
    $('#resoucesamount').val((aaa[17]));
    $('#ATC').val(aaa[18]);
    $('#enccustomername').val(aaa[19]);
    $('#integrationcharge').val(aaa[20]);
    $('#totalc').val(aaa[21]);  
    $('#total18percentage').val(aaa[22]);
    $('#grandtotal').val(aaa[23]);
    
    
    
    //29/06
    if ((aaa[24] === "Distributor")) {
    	$('#proposalFor').val(decodeURIComponent(aaa[24]));
    	
    	$('#hidePartnerName').show();
    	$('#PartnerName').val(decodeURIComponent(aaa[25]));
    
    }else {
    	$('#proposalFor').val(decodeURIComponent(aaa[24]));
    	$('#hidePartnerName').hide();
    	 
	}
    
    //
    
    var data6 = aaa[8];
    

    
    var table = $('#CMApprByMeTable').DataTable({
    	  lengthChange: false,
    	  pageLength: 5,
    	  data: aaa[8],
    	  dataType: 'json',
    	  scrollX: '300px',
       });
	   
    
  
    $('#subtotalA').val(decodeURIComponent(aaa[9]));
    $('#deploysupport').val(decodeURIComponent(aaa[10]));
    $('#clouddeploycharges').val(decodeURIComponent(aaa[11]));
    $('#subtotalB').val(decodeURIComponent(aaa[12]));
  
    let grandtotal = aaa[9] + aaa[12];
//    alert(grandtotal);
    $('#subtotalAB').val(grandtotal);
    
    
    if ((aaa[14] == "NA") || (aaa[14] == "null"))
    {
        $('#SMnoteDiv').hide();
    } else {
        document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[14]);
        $('#SMnoteDiv').show();
    }
       
 

});
	
}




