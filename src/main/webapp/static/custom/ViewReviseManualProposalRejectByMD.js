
var dataVPid=$('#crnoo').val();

function abc11(value2)
{
	selectedValueATC=value2;

}

var data_product_tool="";
var subtotalforalldd =  '';
var subtotalforalldd21 =  '';

window.onload = function(){


	abc();
	abc21();
	sectools();
	
	
	//////
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getCustomerName";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	  }).done(function(data) {

	      var html =" <select class='form-control' tabindex='8' id='clientname' name='clientname'>";
	      html=html+'<option value="">--Please Select Customer--</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }

	      document.getElementById("clientname").innerHTML=html;
	  });
	
	
	 // Proposal Master list
	  
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getProposalName";

  $.ajax({

      url :serviceUrl,
      type : 'POST',
      dataType: 'json',
  }).done(function(data) {

      var html =" <select class='form-control' tabindex='8' id='Proposaltype' name='Proposaltype'>";
      html=html+'<option value="">--Please Select Proposal Name--</option>';
      for (var i = 0; i < data.length; i++) {
          html += '<option value="' +data[i]+ '">' + data[i]+ '</option>';
      }

      document.getElementById("Proposaltype").innerHTML=html;
  });
  
  // Proposal Master list end
  
  
// checker list

	 
var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getcheckerName";

$.ajax({

 url :serviceUrl,
 type : 'POST',
 dataType: 'json',
}).done(function(data) {

 var html =" <select class='form-control' tabindex='8' id='FirstApprovername' name='FirstApprovername'>";
 html=html+'<option value="">--Please Select Checker Name--</option>';
 for (var i = 0; i < data.length; i++) {
     html += '<option value="' +data[i]+ '">' + data[i]
     + '</option>';
 }

 document.getElementById("FirstApprovername").innerHTML=html;
});

// checker list end


	 
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getproductnamelist";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	  }).done(function(data) {
		
 
	      var html =" <select class='form-control' tabindex='8' id='productnameaddrow' name='productnameaddrow'>";
	      html=html+'<option value="">-- Select Security Tool --</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }

	      document.getElementById("productnameaddrow").innerHTML=html;
	      
	     
	  });
	 
		
	 $('#SMnoteDiv').hide();
	 $('#rejreasonDiv').hide();
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getReviseManualProposalListData";
	    
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: "crno=" + $('#crnoo').val()
	        + '&tid=' + $("#tid").val()
	    }).done(function(data) {
//	    	alert(data)
	    	
	    	var aaa = data[0];
	    	console.log(data)
//    	alert(aaa[54])
    $('#poinitiator').val(decodeURIComponent(data[0][0]));
    $('#poinitiatorno').val(decodeURIComponent(data[0][1]));
    $('#FirstApprovername').val(decodeURIComponent(data[0][0]));
    
    $('#firstapprovercontact').val(decodeURIComponent(aaa[3]));
// $('#prodliscense').val(decodeURIComponent(aaa[4]));
// $('#prodamount').val(decodeURIComponent(aaa[5]));
    $('#clientname').val(decodeURIComponent(aaa[6]));
    $('#Description').val(decodeURIComponent(aaa[7]));
    $('#amount').val(decodeURIComponent(aaa[30]));
    $('#contactperson').val(decodeURIComponent(aaa[31]));
    
    
    $('#Proposaltype').val(decodeURIComponent(aaa[15]));
   

        if ((aaa[15] == "Perpetual") )
        {
            $('#perpetualhideid').show();
            $('#subscriptionhideid').hide();
            $('#Perpetualyear').val(decodeURIComponent(aaa[16]));
            
            $('#CMApprByMeTable').show();
			var table = $('#CMApprByMeTable').DataTable({
				lengthChange: false,
				pageLength: 5,
				data: aaa[8],
				dataType: 'json',
				scrollX: '300px',
			});
			
        } else if ((aaa[15] == "Subscription")){
        	 $('#subscriptionhideid').show();
        	 $('#perpetualhideid').hide();
        	 $('#Subscriptionyear').val(decodeURIComponent(aaa[20]));
        	 
        	 $('#CMApprByMeTable').show();
				var table = $('#CMApprByMeTable').DataTable({
					lengthChange: false,
					pageLength: 5,
					data: aaa[8],
					dataType: 'json',
					scrollX: '300px',
				});

        }else if ((aaa[15] == "Fixed")){
       	 $('#subscriptionhideid').hide();
    	 $('#perpetualhideid').hide();
    	 $('#fixedhideid').show();
    	 $('#fixedyear').val(decodeURIComponent(aaa[27]));
    	 
    	 $('#CMApprByMeTable').show();
			var table = $('#CMApprByMeTable').DataTable({
				lengthChange: false,
				pageLength: 5,
				data: aaa[8],
				dataType: 'json',
				scrollX: '300px',
			});

    } else if ((aaa[15] == "AMC")) {
		
// alert("dv dv ");
		
		$('#CMApprByMeTable').hide();
	
		$('#hidealldetailforamc').hide();
		$('#hidegstandgrandtotalforamc').hide();
		
		$('#AMCSTARTENDHIDEID21').show();
		$('#productsuitandtoolhideid').show();
		
		
		$('#amcstartdate21').val(decodeURIComponent(aaa[30]));
		$('#amcenddate21').val(decodeURIComponent(aaa[31]));
		$('#productsuitdetails21').val(decodeURIComponent(aaa[32]));
		$('#securitysolutiondetails21').val(decodeURIComponent(aaa[33]));
		$('#descforamc21').val(decodeURIComponent(aaa[34]));
		$('#totalcostAMC21').val(decodeURIComponent(aaa[35]));

		$('#gstforamc21').val(decodeURIComponent(aaa[36]));
		$('#GRANDTOTALFORAMC21').val(decodeURIComponent(aaa[37]));
	
		
// alert("fvu");
	
	}else if ((aaa[15] === "Resource")) 
	{
		$('#hidealldetailforamc').hide();
		$('#hidegstandgrandtotalforamc').hide();
		$('#hidereATCforamc').hide();
		$('#hideresourceforamc').hide();
				
		$('#subtotalahideidforResource21').show();
		
	
			$('#subtotalAResource21').val(decodeURIComponent(aaa[38]));
			$('#gstdataforresource21').val(decodeURIComponent(aaa[39]));
			$('#grandtotalforresource21').val(decodeURIComponent(aaa[40]));
			
			$('#CMApprByMeTable').show();
	    var table = $('#CMApprByMeTable').DataTable({
				lengthChange: false,
				pageLength: 5,
				data: aaa[8],
				dataType: 'json',
				scrollX: '300px',
			});				
		}else if ((aaa[15] === "Subscription & Perpetual")) 
		{
		
		    var tab = document.getElementById('custom-tabs-one-messages-tab');
		    tab.style.display = 'block';
		    

			$('#combinationSubsANDPerpHideDIv').show();
			
			$('#subscriptionhideid').hide();

			$('#hidereATCforamc').hide();
			$('#perpetualhideid').hide();
			$('#fixedhideid').hide();
//			$('#Subscriptionyear').val(decodeURIComponent(aaa[41]));
			
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
		    
		    
		    $('#SubsANDPerpTable31').show();
		    var table = $('#SubsANDPerpTable31').DataTable({
				lengthChange: false,
				pageLength: 5,
				data: aaa[42],
				dataType: 'json',
				scrollX: '300px',
			});
		    
		    if ((aaa[43] === "") || (aaa[43] === "NA") || (aaa[43] === "null")) {
		    	
		    	$('#perpetualSubsAnnualPerpHideDiv31').hide();
		    
		    }else {
		    	 $('#perpetualSubsAnnualperpType').val(decodeURIComponent(aaa[43]));
				$('#perpetualSubsAnnualPerpHideDiv31').show();
			}
		    
          if ((aaa[44] === "") || (aaa[44] === "NA") || (aaa[44] === "null")) {
		    	
		    	$('#perpetualSubs3yearPerpHideDiv31').hide();
		    
		    }else {
		    	 $('#perpetualSubs3yearperpType31').val(decodeURIComponent(aaa[44]));
				$('#perpetualSubs3yearPerpHideDiv31').show();
			}
          
    
			}
    else {
   	 $('#subscriptionhideid').hide();
	 $('#perpetualhideid').hide();
	 $('#fixedhideid').hide();
    }

        // /
        $('#resoucesamount12').val((aaa[18]));
        $('#ATC').val(aaa[19]);

        
        $('#deploysupport31').val(decodeURIComponent(aaa[45]));
        $('#clouddeploycharges31').val(decodeURIComponent(aaa[46]));
        $('#IntegrationCharges31').val(decodeURIComponent(aaa[48]));
        $('#subtotalB31').val(decodeURIComponent(aaa[49]));
        $('#totalc31').val(decodeURIComponent(aaa[50]));
        $('#total18percentage31').val(decodeURIComponent(aaa[51]));
        
        $('#grandtotal31').val(decodeURIComponent(aaa[52]));
        $('#resoucesamount31').val(decodeURIComponent(aaa[53]));
    
    var data6 = aaa[8];
    
//    if ((aaa[29] == "File Not Attached") || (aaa[29] == "NA") || (aaa[29] == "null"))
//    {
//    	$('#poUploadDiv').show();
//    } else {
//        document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[29]);
//        document.getElementById('filenameStandard').value = decodeURIComponent(aaa[29]);
//        $('#poUploadDiv').show();
//    }
    

    
// var table = $('#CMApprByMeTable').DataTable({
// lengthChange: false,
// pageLength: 5,
// data: aaa[8],
// dataType: 'json',
// scrollX: '300px',
// });
	   
    
  
    $('#subtotalA').val(decodeURIComponent(aaa[9]));
    $('#deploysupport1').val(decodeURIComponent(aaa[10]));
    $('#clouddeploycharges1').val(decodeURIComponent(aaa[11]));
    $('#subtotalB1').val(decodeURIComponent(aaa[12]));
  
    let grandtotal = aaa[9] + aaa[12];
// alert(grandtotal);
    $('#subtotalAB1').val(grandtotal);
    
    
    if ((aaa[14] == "NA") || (aaa[14] == "null"))
    {
        $('#SMnoteDiv').hide();
    } else {
        document.getElementById('SMnote').innerHTML = decodeURIComponent(aaa[14]);
        $('#SMnoteDiv').show();
    }
       
    if ((aaa[32] == "NA") || (aaa[32] == "null"))
    {
        $('#rejreasonDiv').hide();
    } else {
        document.getElementById('rejreason').innerHTML = decodeURIComponent(aaa[32]);
        $('#rejreasonDiv').show();
    }

    
    $('#enccustomername').val(decodeURIComponent(aaa[21]));
    
    $('#ATC21').val(aaa[19]);  // Not to use decodeuricomponent for % values
    
    abc11(aaa[19]);
    
    $('#integrationcharge21').val(decodeURIComponent(aaa[22]));
    
    $('#totalc21').val(decodeURIComponent(aaa[23]));
    $('#total18percentage21').val(decodeURIComponent(aaa[24]));
    $('#grandtotal21').val(decodeURIComponent(aaa[25]));
    $('#productsuitselect').val(decodeURIComponent(aaa[25]));
// $('#grandtotal21').val(decodeURIComponent(aaa[27]));
    
    
 var proposalValue = decodeURIComponent(aaa[16]);
    
    proposaltypedata();
    
    if(proposalValue === 'Perpetual'){
    	
    	proposalbaseddatashowedperp();
    }
    else  if(proposalValue === 'Subscription'){
    	
    	proposalbaseddatashowedsubs();
    }
    else  if(proposalValue === 'Fixed'){
    	
    	proposalbaseddatashowedfixedyear();
    } else  if(proposalValue === 'Subscription & Perpetual'){
    	
    	proposalbaseddatashowedsubsANDperp()
    }
    
    
});
	  
}



$(document).ready(function() {
	 subtotalb();
	subtotalAB();
	
   function calculateTotalCost() {
       const rows = document.querySelectorAll("#data-table tbody tr");
       let totalForAllProducts = 0;

       rows.forEach(row => {
           const quantity = parseFloat(row.cells[2].querySelector('input').value) || 0;
           const unitRate = parseFloat(row.cells[3].querySelector('input').value) || 0;
           const totalCost = quantity * unitRate;
           row.cells[4].querySelector('input').value = totalCost.toFixed(2);
           totalForAllProducts += totalCost;
       });

       // Update the totalpriceforallproduct field
       document.querySelector("#totalpriceforallproduct").value = totalForAllProducts.toFixed(2);
   }

   // Attach the calculateTotalCost function to all relevant input fields
   $("#data-table tbody").on("input", "tr input[type='number']", calculateTotalCost);
   
    
});

function abc()
{
	// Add an event listener to the productsuitaddrow dropdown
	document.getElementById("productsuitaddrow").addEventListener("change", function() {
	  var selectedSuit = this.value; // Get the selected product suit
	  
	  var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 // var serviceUrl = base_url + "/Master/getproductnamelist?suit=" +
		// selectedSuit;
	   var serviceUrl = base_url + "/Master/getproductnamelist";

	  $.ajax({
	    url: serviceUrl,
	    type: 'POST',
	    dataType: 'json',
	    data :'selectedSuit='+selectedSuit ,
	  }).done(function(data) {
	    var html = " <select class='form-control' tabindex='8' id='productnameaddrow' name='productnameaddrow'>";
	    html = html + '<option value="">-- Select Product Tool --</option>';
	    for (var i = 0; i < data.length; i++) {
	      html += '<option value="' + data[i] + '">' + data[i] + '</option>';
	    }
	    document.getElementById("productnameaddrow").innerHTML = html;
	  });
	});

		  
		
		
		// / new added for product suit
		  
		    var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getproductsuitlist";

		  $.ajax({

		      url :serviceUrl,
		      type : 'POST',
		      dataType: 'json',
		  }).done(function(data) {
			
	       
		      var html =" <select class='form-control' tabindex='8' id='productsuitaddrow' name='productsuitaddrow'>";
		      html=html+'<option value="">-- Select Product Suite--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("productsuitaddrow").innerHTML=html;
		      	     
		  });
	};	
	
	function abc21()
	{
		

		// Add an event listener to the productsuitaddrow dropdown
		document.getElementById("productsuitaddrow21").addEventListener("change", function() {
		  var selectedSuit = this.value; // Get the selected Product Suite
		  
		  var l = window.location;
		  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		   var serviceUrl = base_url + "/Master/getproductnamelist";

		  $.ajax({
		    url: serviceUrl,
		    type: 'POST',
		    dataType: 'json',
		    data :'selectedSuit='+selectedSuit ,
		  }).done(function(data) {
			  
			  var html =" <select class='form-control' tabindex='8' id='productnameaddrow21' name='productnameaddrow21'>";
		      html=html+'<option value="">--Please Select Product Tool--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("productnameaddrow21").innerHTML=html;
		    
	   
		  });
		});

			  
			
			
			// / new added for Product Suite
			  
			    var l = window.location;
				var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
				var serviceUrl = base_url + "/Master/getproductsuitlist";

			  $.ajax({

			      url :serviceUrl,
			      type : 'POST',
			      dataType: 'json',
			      
			  }).done(function(data) {
				
				   var html =" <select class='form-control' tabindex='8' id='productsuitaddrow21' name='productsuitaddrow21'>";
				      html=html+'<option value="">-- Select Product Suite--</option>';
				      for (var i = 0; i < data.length; i++) {
				          html += '<option value="' +data[i]+ '">' + data[i]
				          + '</option>';
				      }

				      document.getElementById("productsuitaddrow21").innerHTML=html;
			      
			      	     
			  });
		
	}
	
	function proposaltypedata()
	{

		var selectedValue = $("#Proposaltype").val();
		
		
		var selectedperpetual = $("#Perpetualyear").val();
		var selectedSubscription = $("#Subscriptionyear").val();
		
		$("#subsANDPerpTbaleHeader").hide();
		$("#addRowProductPerpSubsHideDiv").hide();
		$("#perpetualSubsAnnualPerpHideDiv").hide();
		$("#perpetualSubs3yearPerpHideDiv").hide();
		$("#chargesForPerpetualType").hide();
		$("#subscriptionANDperpetualhideid").hide();
		
			  
	            if (selectedValue === "Perpetual") {
	                $("#perpetualhideid").show();
	                $("#subscriptionhideid").hide();
	                $("#fixedhideid").hide();
	                
	                $("#AMCSTARTENDHIDEID").hide();
	                $("#productsuitandtoolhideid").hide();
	               
	                
	                $("#addrowhideidforamc").show();
	                $("#chargesforAllPropType").show();
	                
	                $("#subtotalahideidforResource").hide();
	                
	                $("#subtotalahideid3yearsubs").hide();
	                $("#subtotalahideid3yearperp").hide();
	                $("#subtotalahideid5yearperp").hide();
	                $("#subtotalahideid3yearfixedd").hide();
	                $("#subtotalahideid5yearfixed1").hide();
	                
	            } else if (selectedValue === "Subscription") { 
	                $("#subscriptionhideid").show();
	                 $("#perpetualhideid").hide();
	                 $("#fixedhideid").hide();
	                 
	                 $("#AMCSTARTENDHIDEID").hide();
	                 $("#productsuitandtoolhideid").hide();
	                
	                 
	                 $("#addrowhideidforamc").show();
	                 $("#chargesforAllPropType").show();
	                 $("#subtotalahideidforResource").hide();

	                 $("#subtotalahideid3yearsubs").hide();
		                $("#subtotalahideid3yearperp").hide();
		                $("#subtotalahideid5yearperp").hide();
		                $("#subtotalahideid3yearfixedd").hide();
		                $("#subtotalahideid5yearfixed1").hide();
	          } else if (selectedValue === "Fixed") { 
	              $("#subscriptionhideid").hide();
	              $("#perpetualhideid").hide();
	              $("#fixedhideid").show();
	        
	              $("#AMCSTARTENDHIDEID").hide();
	              $("#productsuitandtoolhideid").hide();
	             
	              
	              $("#addrowhideidforamc").show();
	              $("#chargesforAllPropType").show();
	             
	              $("#subtotalahideidforResource").hide();
	         
	        
	              $("#subtotalahideid3yearsubs").hide();
	              $("#subtotalahideid3yearperp").hide();
	              $("#subtotalahideid5yearperp").hide();
	              $("#subtotalahideid3yearfixedd").hide();
	              $("#subtotalahideid5yearfixed1").hide();
	        } else if (selectedValue === "AMC") 
	        { 
		

		          $("#productsuitandtoolhideid").show();
		               
		          $("#AMCSTARTENDHIDEID").show();
	              $("#subscriptionhideid").hide();
	              $("#perpetualhideid").hide();
	              $("#fixedhideid").hide();
	              
	             
	             $("#addrowhideidforamc").hide();
	             $("#chargesforAllPropType").hide();
	             
	             
	             $("#subtotalahideidforResource").hide();
	             
	             $("#subtotalahideid3yearsubs").hide();
	             $("#subtotalahideid3yearperp").hide();
	             $("#subtotalahideid5yearperp").hide();
	             $("#subtotalahideid3yearfixedd").hide();
	             $("#subtotalahideid5yearfixed1").hide();
	        }else if (selectedValue === "Resource") 
	        {   	   		         	
		          $("#addrowhideidforamc").show(); 
		          	  	           
		           $("#subtotalahideidforResource").show(); 
		           	          
		          
	// $("#addRowButton").hide();
		          $("#productsuitandtoolhideid").hide();      
		          $("#AMCSTARTENDHIDEID").hide();
	            $("#subscriptionhideid").hide();
	            $("#perpetualhideid").hide();
	            $("#fixedhideid").hide();
	           $("#chargesforAllPropType").hide();
	           
	            $("#subtotalahideid3yearsubs").hide();
	            $("#subtotalahideid3yearperp").hide();
	            $("#subtotalahideid5yearperp").hide();
	            $("#subtotalahideid3yearfixedd").hide();
	            $("#subtotalahideid5yearfixed1").hide();   
	            
	            $("#subtotalahideid").hide();
	             
	            $("#subtotalahideid3yearsubs").hide();
	            $("#subtotalahideid3yearperp").hide();
	            $("#subtotalahideid5yearperp").hide();
	            $("#subtotalahideid3yearfixedd").hide();
	            $("#subtotalahideid5yearfixed1").hide();
	       }else if (selectedValue === "Subscription & Perpetual") 
	       { 
	    	   
	// alert("dgjb");
	    	   var tab = document.getElementById('custom-tabs-one-messages-tab');
			    tab.style.display = 'block';
			    
	    	   $("#subscriptionANDperpetualhideid").show();
	    	   $("#addrowhideidforamc").show();
	           $("#chargesforAllPropType").show();
	           $("#chargesForPerpetualType").show();
	           $("#addRowProductPerpSubsHideDiv").show();
	           
	           $("#subscriptionhideid").hide();
	           $("#perpetualhideid").hide();
	           $("#fixedhideid").hide();
	           $("#AMCSTARTENDHIDEID").hide();
	           $("#productsuitandtoolhideid").hide();
	           $("#addrowhideidforamc").show();
	           $("#chargesforAllPropType").show();
	           $("#subtotalahideidforResource").hide();
	           $("#subtotalahideid3yearsubs").hide();
	              $("#subtotalahideid3yearperp").hide();
	              $("#subtotalahideid5yearperp").hide();
	              $("#subtotalahideid3yearfixedd").hide();
	              $("#subtotalahideid5yearfixed1").hide();
	    }
	        
	        else{
	    	   
	    	   $("#subscriptionhideid").hide();
	           $("#perpetualhideid").hide();
	           $("#fixedhideid").hide();
	           $("#AMCSTARTENDHIDEID").hide();
	           
	       }
	       
	       
	      
	       
	        
				
				
				

	}
	
	
	function proposalbaseddatashowedsubsANDperp()
	{
		
		var selectedValue = $("#subscriptionANDperpetualYear").val();
		
		$("#subsANDPerpTbaleHeader").show();
		
		$("#perpetualSubsAnnualPerpHideDiv").hide();
		$("#perpetualSubs3yearPerpHideDiv").hide();
		
		 if (selectedValue === "Annual Price") 
		 {
			$("#subtotalahideid3yearfixedd").hide();
			$("#subtotalahideid").show();
			$("#perpetualSubsAnnualPerpHideDiv").show();
			$("#subtotalahideid3yearsubs").hide();
			$("#subtotalahideid3yearperp").hide();
			$("#subtotalahideid5yearperp").hide();	
		
			 $("#atchideidupper").show(); 
	         $("#atchideid").hide(); 		
		 }
		 else if(selectedValue === "3 Year Price")
		{
			$("#subtotalahideid5yearfixed1").hide();
			$("#subtotalahideid3yearsubs").show();
			$("#perpetualSubs3yearPerpHideDiv").show();
			$("#subtotalahideid").hide();
			$("#subtotalahideid3yearperp").hide();
			$("#subtotalahideid5yearperp").hide();	
			
			 $("#atchideidupper").show(); 
	         $("#atchideid").hide(); 	
		}
		else
		{
			$("#subtotalahideid5yearfixed1").hide();
		    $("#subtotalahideid3yearfixedd").hide();
			$("#perpetualSubsAnnualperpType").hide();	
			$("#perpetualSubs3yearperpType").hide();	
		     $("#atchideidupper").hide(); 
	         $("#atchideid").hide(); 	
			
		}	
	}

	

	function sectools() 
	 {

	        var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getprodsuit";
			
			
			$.ajax({

		      url :serviceUrl,
		      type : 'POST',
		      dataType: 'json',
	// ASYNC : FALSE,
		  }).done(function(data) {
			console.log(data)
			
			    var html =" <select class='form-control' tabindex='9' id='productsuitdetails' name='productsuitdetails'   >";
		    
		      html=html+'<option value="">--Please Select Product Suit--</option>';
		     
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }
		      document.getElementById("productsuitdetails").innerHTML=html;
			
			 });
			 }

	
	
	function securitydetailforamc()
	{	
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getsecuritysolutionList";

		$.ajax({
		    type: 'POST',
		    url: serviceUrl,
		    dataType:'JSON',
		    data: 'productsuit=' + encodeURIComponent($("#productsuitdetails").val())
		}).done(function(data2Array) {
		    var html = "<option value=''> -- Please Select --</option>";
		    for (var i = 0; i < data2Array.length; i++) {
		        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
		    }
		    document.getElementById("securitysolutiondetails").innerHTML = html;
		});
		
	}

	function proposalbaseddatashowedperp()
	{
		var selectedValue = $("#Perpetualyear").val();
		
		 if (selectedValue === "1 year Warranty") 
		 {
			$("#subtotalahideid").show();
			$("#subtotalahideid3yearperp").hide();
			$("#subtotalahideid5yearperp").hide();
			$("#subtotalahideid3yearsubs").hide();
			
			
			 $("#atchideidupper").show(); 
	         $("#atchideid").hide(); 
		 }
		 else if(selectedValue === "3 year Warranty")
		{
			$("#subtotalahideid3yearperp").show();
			$("#subtotalahideid5yearperp").hide();
			$("#subtotalahideid").hide();
			$("#subtotalahideid3yearsubs").hide();
			
			 $("#atchideidupper").show(); 
	         $("#atchideid").hide(); 	
		}
		else if(selectedValue === "5 year Warranty")
		{
			$("#subtotalahideid5yearperp").show();
			$("#subtotalahideid3yearperp").hide();
			$("#subtotalahideid").hide();	
			$("#subtotalahideid3yearsubs").hide();
			
			 $("#atchideidupper").show(); 
	         $("#atchideid").hide(); 
		}
	}

	function proposalbaseddatashowedfixedyear()
	{
		
		var selectedValue = $("#fixedyear").val();
		 if (selectedValue === "3 year Warranty") 
		 {
			$("#subtotalahideid3yearfixedd").show();
			$("#subtotalahideid").hide();
			$("#subtotalahideid3yearsubs").hide();
			$("#subtotalahideid3yearperp").hide();
			$("#subtotalahideid5yearperp").hide();	
			
			 $("#atchideidupper").show(); 
	         $("#atchideid").hide(); 		
		 }
		 else if(selectedValue === "5 year Warranty")
		{
			$("#subtotalahideid5yearfixed1").show();
			$("#subtotalahideid3yearsubs").hide();
			$("#subtotalahideid").hide();
			$("#subtotalahideid3yearperp").hide();
			$("#subtotalahideid5yearperp").hide();	
			
			 $("#atchideidupper").show(); 
	         $("#atchideid").hide(); 	
		}
		else
		{
			$("#subtotalahideid5yearfixed1").hide();
		    $("#subtotalahideid3yearfixedd").hide();
		    
		     $("#atchideidupper").show(); 
	         $("#atchideid").hide(); 	
			
		}	
	}

	function proposalbaseddatashowedsubs()
	{
		var selectedValue = $("#Subscriptionyear").val();
		 if (selectedValue === "Annual Price") 
		 {
			$("#subtotalahideid").show();
			$("#subtotalahideid3yearsubs").hide();
			$("#subtotalahideid3yearperp").hide();
			$("#subtotalahideid5yearperp").hide();	
			
			
			 $("#atchideidupper").hide(); 
	         $("#atchideid").show(); 	
		 }
		 else if(selectedValue === "3 year Subscription")
		{
			$("#subtotalahideid3yearsubs").show();
			$("#subtotalahideid").hide();
			$("#subtotalahideid3yearperp").hide();
			$("#subtotalahideid5yearperp").hide();
			
			 $("#atchideidupper").hide(); 
	         $("#atchideid").show(); 	
		}	
	}

	function productsuit()
	{	
		var selectedValue = $("#productsuitselect").val();		
		if(selectedValue === 'ScanPlus')
		{
		 $("#hideScanplus").show();	
		  $("#hideSecureIT").hide();
		}
		else if(selectedValue === 'SecureIT')
		{
		 $("#hideSecureIT").show();
		  $("#hideScanplus").hide();	 	
		}
		else
		{
		 $("#hideScanplus").hide();
		 $("#hideSecureIT").hide();	
		}
	}
	function getCheckerNo(){
		
		var checkerApprovername  = $('#FirstApprovername').val();
		
		 var l = window.location;
		 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/UserActivity/getCheckerContactNo";
			
			  $.ajax({

			      url :serviceUrl,
			      type : 'POST',
			      dataType: 'json',
			      data:'checkerApprovername='+checkerApprovername,
			  }).done(function(data) {
				
				// alert(data);
	// alert( data[0]["PHONE"] );
				  
	             $('#firstapprovercontact').val(data[0]["PHONE"]);

			  });
			  
	}
function subtotalb() {
    // Function to calculate and update Sub Total (B)
    function calculateSubTotalB() {
        var deploysupport = parseFloat($("#deploysupport").val()) || 0;
        var clouddeploycharges = parseFloat($("#clouddeploycharges").val()) || 0;

        var subtotalB = deploysupport + clouddeploycharges;
        $("#subtotalB").val(subtotalB.toFixed(2));
    }

    // Attach the calculateSubTotalB function to the input fields
    $("#deploysupport, #clouddeploycharges").on("input", calculateSubTotalB);
    
    
}



function subtotalAB() {
    // Function to calculate and update Sub Total (B)
    function calculateSubTotalAB() {
        var totalpriceforallproduct = parseFloat($("#totalpriceforallproduct").val()) || 0;
        var subtotalB = parseFloat($("#subtotalB").val()) || 0;

        var subtotalAB = totalpriceforallproduct + subtotalB;
        $("#subtotalAB").val(subtotalAB.toFixed(2));
    }

    // Attach the calculateSubTotalB function to the input fields
    $("#totalpriceforallproduct, #subtotalB").on("input", calculateSubTotalAB);
}

$(document).ready(function() {
    function calculateSubTotalA() {
        console.log("Calculating Sub Total A");
    }
    
 

    function calculateTotalCost() {
        console.log("Calculating Sub Total 2");
        const rows = document.querySelectorAll("#data-table tbody tr");
        let totalForAllProducts = 0;
        let totttt = 0;
        
        let secondyear = 0;
        let thirdyear = 0;
        let fourthyear = 0;
        let fifthyear = 0;
       
        rows.forEach(row => {
        	
            const quantity = parseFloat(row.cells[3].querySelector('input').value) || 0;
            const unitRate = parseFloat(row.cells[4].querySelector('input').value) || 0;
            const totalCost = quantity * unitRate;
            totttt = quantity * unitRate;
            row.cells[5].querySelector('input').value = totalCost;
            totalForAllProducts += totalCost;
           
      // });
        

       // / new
       var selectedValueperp = $("#Perpetualyear").val();
       var selectedValuesubs = $("#Subscriptionyear").val();
       var selectedValuefixed = $("#fixedyear").val();
       var selectedSubscOfsubsandPerp = $("#subscriptionANDperpetualYear").val();
       
       let totttt222  ;
       var atchalfvalue=2 ;    
 	  if ((selectedValuesubs === "3 year Subscription") || (selectedSubscOfsubsandPerp === "3 Year Price")) 
 	  {
 		

 		totttt222 = totttt * atchalfvalue ;
 				
 		totalForAllProducts += totttt222  ;
 				
 		document.querySelector("#totalpriceforallproduct3yearsubs").value = totalForAllProducts;
 		 totalForAllProducts = totalForAllProducts
 		subtotalforalldd = totalForAllProducts ;		
 		calculateSubTotalC();
 		
 		
    	  }
   	  else
   	  {
	   document.querySelector("#totalpriceforallproduct").value = totalForAllProducts;
	   subtotalforalldd = totalForAllProducts ;
        calculateSubTotalC();
      }
      
      // / perpetual
     
// var secondyear =0;
// var thirdyear =0;
// var fourthyear =0;;
// var fifthyear=0; ;
         var abc = '';  
        var atc_val=''; 
        
         let totttt1111   
      if (selectedValueperp === "3 year Warranty") 
	  {
    	  abc11(selectedValueATC)
    	  
    	  
		 atc_val=selectedValueATC/100;
		 		 
// secondyear = totttt * atc_val ; //20x0.12
// thirdyear = totttt * atc_val; //20x.12

var atchalfvalue='';
 if(atc_val === 0.12)
 {
	atchalfvalue=atc_val*2;
	
}
else if(atc_val === 0.15)
{
	atchalfvalue=atc_val*2;
}
else if(atc_val === 0.18)
{
	atchalfvalue=atc_val*2;
}

	      totttt1111 =totttt *atchalfvalue;	
	    totalForAllProducts +=totttt1111
	     	    	     	    
		document.querySelector("#totalpriceforallproduct3yearperp").value = totalForAllProducts;
		 totalForAllProducts = totalForAllProducts		
		subtotalforalldd = totalForAllProducts ;
		calculateSubTotalC();
   	  }  	  
   	  else if (selectedValueperp === "5 year Warranty")
   	  {	    		 abc11(selectedValueATC)
		atc_val=selectedValueATC/100;	
		
		var atchalfvalue='';
 if(atc_val === 0.12)
 {
	atchalfvalue=atc_val*4;
	
}
else if(atc_val === 0.15)
{
	atchalfvalue=atc_val*4;
}
else if(atc_val === 0.18)
{
	atchalfvalue=atc_val*4;
}
			 	 

		 totttt1111 =totttt *atchalfvalue;
		 
		  totalForAllProducts +=totttt1111

		document.querySelector("#totalpriceforallproduct5yearperp").value = totalForAllProducts;
		subtotalforalldd = totalForAllProducts ;
		calculateSubTotalC();	
      }
   	  else
   	  {
	   document.querySelector("#totalpriceforallproduct").value = totalForAllProducts;
	    subtotalforalldd = totalForAllProducts ;
        calculateSubTotalC();
      }
                 
      // / fixed year
      if (selectedValuefixed === "3 year Warranty") 
	  {
//    	  abc11(selectedValueATC)
//	
//		 atc_val=selectedValueATC/100;
//		 
//		 
//		 var atchalfvalue='';
// if(atc_val === 0.12)
// {
//	atchalfvalue=atc_val*2;
//	
//}
//else if(atc_val === 0.15)
//{
//	atchalfvalue=atc_val*2;
//}
//else if(atc_val === 0.18)
//{
//	atchalfvalue=atc_val*2;
//}
//		 totttt1111 =totttt *atchalfvalue; 
//	    totalForAllProducts +=totttt1111
//		 
// secondyear = totttt * atc_val ;
// thirdyear = totttt * atc_val;
// totalForAllProducts = secondyear +thirdyear + totttt ;
		document.querySelector("#threeyearfixed").value = totalForAllProducts;
		subtotalforalldd = totalForAllProducts ;

		calculateSubTotalC();
   	  }
   	  
   	  else if (selectedValuefixed === "5 year Warranty")
   	  {
//   		  abc11(selectedValueATC)
//	    
//	    		
//		atc_val=selectedValueATC/100;
//		
//		var atchalfvalue='';
// if(atc_val === 0.12)
// {
//	atchalfvalue=atc_val*4;
//	
//}
//else if(atc_val === 0.15)
//{
//	atchalfvalue=atc_val*4;
//}
//else if(atc_val === 0.18)
//{
//	atchalfvalue=atc_val*4;
//}	
//		
//		 totttt1111 =totttt *atchalfvalue; 
//	    totalForAllProducts +=totttt1111	
	    
			
		// totalForAllProducts = secondyear +thirdyear + fourthyear + fifthyear
		// + totttt ;
				
		document.querySelector("#fiveyearfixed").value = totalForAllProducts;
		subtotalforalldd = totalForAllProducts ;
		calculateSubTotalC();	
      }
   	  else
   	  {
	   document.querySelector("#totalpriceforallproduct").value = totalForAllProducts;
	    subtotalforalldd = totalForAllProducts ;
        calculateSubTotalC();
      }
      
      
      /// ADDED FOR RESOURCE  
      //   var tottforresource ='';
      var tottforresource ='';
      var atchalfvalueResource = 18 ;
      var GstForResource = '';
    //  var atc_valforResource ='';
      
      
      var  grandtotal ='';
      var selectvalueforResource = $("#Proposaltype").val();   
      if(selectvalueforResource === 'Resource')
      {	
   	atc_valforResource=atchalfvalueResource/100;	
   			  
   		 document.querySelector("#subtotalAResource").value = totalForAllProducts;
   		  	
   		 tottforresource =totalForAllProducts * 0.18; 				
   		 GstForResource +=tottforresource ;		 			  
   		 grandtotal += totalForAllProducts + tottforresource ;
   		 
   		 
   		 var formattedforGSTResource = parseFloat(GstForResource).toFixed(1); 			 		
   		document.querySelector("#gstdataforresource").value = formattedforGSTResource;
   		document.querySelector("#grandtotalforresource").value = grandtotal;			
   		subtotalforalldd = totalForAllProducts ;		
   		calculateSubTotalC();		
   		
     }   
         
    
   });  
   

      // / fixed end
    }

    $("#data-table tbody").on("input", "tr input[type='text']", calculateTotalCost);

    function calculateSubTotalB() {
//        console.log("Calculating Sub Total B");
        var deploysupport = parseFloat($("#deploysupport").val()) || 0;
        var clouddeploycharges = parseFloat($("#clouddeploycharges").val()) || 0;
        var Integrationcharges1 = parseFloat($("#integrationcharge").val()) || 0;
        var subtotalB = deploysupport + clouddeploycharges + Integrationcharges1;
        $("#subtotalB").val(subtotalB);
        calculateSubTotalC();
    }

    $("#deploysupport, #clouddeploycharges,#integrationcharge").on("input", calculateSubTotalB);

    function calculateSubTotalC() {
//        console.log("Calculating Sub Total C");
        
         var totalA = subtotalforalldd
      // var totalA = parseFloat($("#totalpriceforallproduct").val()) || 0;
        var totalB = parseFloat($("#subtotalB").val()) || 0;

        var totalC = totalA + totalB;
        $("#totalc").val(totalC);

        // Calculate GST at 18% of totalC
        var gst18percentage = totalC * 0.18;
        $("#total18percentage").val(gst18percentage);

        // Calculate Grand Total as the sum of totalC and GST at 18%
        var grandtotal = totalC + gst18percentage;
        $("#grandtotal").val(grandtotal);
    }

    $("#totalpriceforallproduct, #subtotalB").on("input change", calculateSubTotalC);

    // Initial calculation of Sub Total B
    calculateSubTotalB();
    // Initial calculation of Sub Total A
    calculateSubTotalA();
});

$(document).ready(function() {


    function calculateSubTotalA21() {
        console.log("Calculating Sub Total A");
    }
    
 

    function calculateTotalCost21() {
        console.log("Calculating Sub Total 2");
        const rows = document.querySelectorAll("#data-table21 tbody tr");
        let totalForAllProducts = 0;
        let totttt = 0;
        
        let secondyear = 0;
        let thirdyear = 0;
        let fourthyear = 0;
        let fifthyear = 0;
       
        rows.forEach(row => {
        	
            const quantity = parseFloat(row.cells[3].querySelector('input').value) || 0;
            const unitRate = parseFloat(row.cells[4].querySelector('input').value) || 0;
            const totalCost = quantity * unitRate;
            totttt = quantity * unitRate;
            row.cells[5].querySelector('input').value = totalCost;
            totalForAllProducts += totalCost;
           
      // });
        

       // / new
       var selectedValueperp = $("#Perpetualyear").val();
       var selectedValuesubs = $("#Subscriptionyear").val();
       var selectedValuefixed = $("#fixedyear").val();
       var selectedSubscOfsubsandPerp = $("#subscriptionANDperpetualYear").val();
       
       let totttt222  ;
       var atchalfvalue=2 ;    
 	
      
      // / perpetual
     
// var secondyear =0;
// var thirdyear =0;
// var fourthyear =0;;
// var fifthyear=0; ;
         var abc = '';  
        var atc_val=''; 
        
         let totttt1111   
      if ( selectedSubscOfsubsandPerp === "3 Year Price" ) 
	  {
    	  abc11(selectedValueATC)
    	  
    	  
		 atc_val=selectedValueATC/100;
		 		 
// secondyear = totttt * atc_val ; //20x0.12
// thirdyear = totttt * atc_val; //20x.12

var atchalfvalue='';
 if(atc_val === 0.12)
 {
	atchalfvalue=atc_val*2;
	
}
else if(atc_val === 0.15)
{
	atchalfvalue=atc_val*2;
}
else if(atc_val === 0.18)
{
	atchalfvalue=atc_val*2;
}

	      totttt1111 =totttt *atchalfvalue;	
	    totalForAllProducts +=totttt1111
	     	    	     	    
		document.querySelector("#perpetualSubs3yearperpType").value = totalForAllProducts;
		 totalForAllProducts = totalForAllProducts		
		subtotalforalldd = totalForAllProducts ;
		calculateSubTotalC21();
   	  }  	  
   	 
   	  else
   	  {
   		  
// alert(totalForAllProducts+"totalForAllProducts")
	   document.querySelector("#perpetualSubsAnnualperpType").value = totalForAllProducts;
	    subtotalforalldd21 = totalForAllProducts ;
        calculateSubTotalC21();
      }
                 
   
    
   });  
   

     
    }

    $("#data-table21 tbody").on("input", "tr input[type='text']", calculateTotalCost21);

    function calculateSubTotalB21() {
// console.log("Calculating Sub Total B");
        var deploysupport = parseFloat($("#deploysupport41").val()) || 0;
        var clouddeploycharges = parseFloat($("#clouddeploycharges41").val()) || 0;
        var Integrationcharges1 = parseFloat($("#integrationcharge41").val()) || 0;
        var subtotalB = deploysupport + clouddeploycharges + Integrationcharges1;
        $("#subtotalB41").val(subtotalB);
        calculateSubTotalC21();
    }

    $("#deploysupport41, #clouddeploycharges41,#integrationcharge41").on("input", calculateSubTotalB21);

    function calculateSubTotalC21() {
// console.log("Calculating Sub Total C");
        
         var totalA = subtotalforalldd
      // var totalA = parseFloat($("#totalpriceforallproduct").val()) || 0;
        var totalB = parseFloat($("#subtotalB41").val()) || 0;

        var totalC = totalA + totalB;
        $("#totalc41").val(totalC);

        // Calculate GST at 18% of totalC
        var gst18percentage = totalC * 0.18;
        $("#total18percentage41").val(gst18percentage);

        // Calculate Grand Total as the sum of totalC and GST at 18%
        var grandtotal = totalC + gst18percentage;
        $("#grandtotal41").val(grandtotal);
    }

    $("#perpetualSubsAnnualperpType, #subtotalB41").on("input change", calculateSubTotalC21);

    // Initial calculation of Sub Total B
    calculateSubTotalB21();
    // Initial calculation of Sub Total A
    calculateSubTotalA21();
    

});

let dataArray = [];
var data3;
function addRow() {
	


    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getproductsuitlist";

$.ajax({

    url :serviceUrl,
    type : 'POST',
    dataType: 'json',
}).done(function(data) {

data3=data;





const selectedProductSuit=""; 
const productString = ""+data3+"";
const productArray = productString.split(',');

const tableBody = document.querySelector("#data-table tbody");
const placeholders = ['--Select Product Suite--','--Select Security Tool --', 'Enter your Description', 'Enter Your Quantity', 'Enter Your Unit Rate', 'Total Price'];

// Create a new row
const newRow = tableBody.insertRow();

for (let i = 0; i < 6; i++) {const cell = newRow.insertCell();
let selectedProductSuit = ''; // Initialize a variable to store the selected
								// value

if (i === 0) {
	
	
	
    const select = document.createElement('select');
    select.classList.add('form-control');
    
    
    const placeholderOption = document.createElement('option');
    placeholderOption.value = ''; // Empty value
    placeholderOption.text = '-- Select Product Suite --'; // Placeholder text
    select.appendChild(placeholderOption);
    
    const options = productArray;  // Add your product suit names here

    options.forEach(optionName => {
        const option = document.createElement('option');
        select.id = 'productsuitaddrow';
        option.value = optionName;
        option.text = optionName;
        select.appendChild(option);
    });

    select.onchange = function() {
        // Store the selected value
        selectedProductSuit = select.value;
      
        
        var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        var serviceUrl = base_url + "/Master/getproductnamelist";

        $.ajax({
            url: serviceUrl,
            type: 'POST',
            dataType: 'json',
            data: { selectedSuit: selectedProductSuit }, // Pass the selected
															// value as data
        }).done(function(data) {
           
            data_product_tool = data;

            // After getting the data, update the second select element
            updateSecondSelect();
        });
    };

    cell.appendChild(select);
} else if (i === 1) {
	const select = document.createElement('select');
select.classList.add('form-control');

// Function to update the second select element
function updateSecondSelect() {
 select.innerHTML = ''; // Clear existing options

 // Create a placeholder option with empty value and a text like "Select an
	// option"
 const placeholderOption = document.createElement('option');
 placeholderOption.value = ''; // Empty value
 placeholderOption.text = '-- Select Product Tool --'; // Placeholder text
 select.appendChild(placeholderOption);

 if (data_product_tool && data_product_tool.length > 0) {
     data_product_tool.forEach(optionName => {
         const option = document.createElement('option');
         select.id = 'productnameaddrow';
         option.value = optionName;
         option.text = optionName;
         select.appendChild(option);
     });
 } else {
     // Handle the case when there is no data, or the data is not valid
     // You can add a default option or display an error message here
 }
}

updateSecondSelect(); // Call the function to update the second select element

cell.appendChild(select);
} else {
	
	const input = document.createElement('input');
	input.classList.add('form-control');
	input.placeholder = placeholders[i];

	if (i === 2 || i === 5) {
	    input.type = 'text';
	}

	if (i === 3 || i === 4) {
	    input.type = 'text';
	    input.oninput = function () {
	        this.value = this.value.replace(/[^0-9]/g, '');
	    };
	}

	if (i === 5) {
	    input.readOnly = true; // Make input read-only
	}

	cell.appendChild(input);

    
}

}

// Add the delete button to the last cell
const deleteCell = newRow.insertCell();
const deleteButton = document.createElement('button');
deleteButton.textContent = 'Delete';
deleteButton.onclick = function() {
  deleteRow(deleteButton);
};
deleteButton.classList.add('btn', 'btn-danger');
deleteButton.style.marginLeft = '12%';
deleteCell.appendChild(deleteButton);


});

}

/////////// For SUBS ANd Pepretual Table
var data7;
function addRow21() {

	
	// alert("ADHIU ");

	    var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getproductsuitlist";

	$.ajax({

	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	}).done(function(data) {
		
		data7=data;





	const selectedProductSuit=""; 
	const productString = ""+data7+"";
	const productArray = productString.split(',');

	const tableBody = document.querySelector("#data-table21 tbody");
	const placeholders = ['--Select Product Suite--','--Select Security Tool --', 'Enter your Description', 'Enter Your Quantity', 'Enter Your Unit Rate', 'Total Price'];

	// Create a new row
	const newRow = tableBody.insertRow();

	for (let i = 0; i < 6; i++) {const cell = newRow.insertCell();
	let selectedProductSuit = ''; // Initialize a variable to store the selected
									// value

	if (i === 0) {
		
		
		
	    const select = document.createElement('select');
	    select.classList.add('form-control');
	    
	    
	    const placeholderOption = document.createElement('option');
	    placeholderOption.value = ''; // Empty value
	    placeholderOption.text = '-- Select Product Suite --'; // Placeholder text
	    select.appendChild(placeholderOption);
	    
	    const options = productArray;  // Add your Product Suite names here

	    options.forEach(optionName => {
	        const option = document.createElement('option');
	        select.id = 'productsuitaddrow21';
	        option.value = optionName;
	        option.text = optionName;
	        select.appendChild(option);
	    });

	    select.onchange = function() {
	        // Store the selected value
	        selectedProductSuit = select.value;
	      
	        
	        var l = window.location;
	        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	        var serviceUrl = base_url + "/Master/getproductnamelist";

	        $.ajax({
	            url: serviceUrl,
	            type: 'POST',
	            dataType: 'json',
	            data: { selectedSuit: selectedProductSuit }, 
	        }).done(function(data) {
	           
	            data_product_tool = data;

	            // After getting the data, update the second select element
	            updateSecondSelect21();
	        });
	    };

	    cell.appendChild(select);
	} else if (i === 1) {
		const select = document.createElement('select');
	select.classList.add('form-control');

	// Function to update the second select element
	function updateSecondSelect21() {
	 select.innerHTML = ''; // Clear existing options

	 // Create a placeholder option with empty value and a text like "Select an
		// option"
	 const placeholderOption = document.createElement('option');
	 placeholderOption.value = ''; // Empty value
	 placeholderOption.text = '-- Select Product Tool --'; // Placeholder text
	 select.appendChild(placeholderOption);

	 if (data_product_tool && data_product_tool.length > 0) {
	     data_product_tool.forEach(optionName => {
	         const option = document.createElement('option');
	         select.id = 'productnameaddrow21';
	         option.value = optionName;
	         option.text = optionName;
	         select.appendChild(option);
	     });
	 } else {
	    
	 }
	}

	updateSecondSelect21(); // Call the function to update the second select element

	cell.appendChild(select);
	} else {
		
		const input = document.createElement('input');
		input.classList.add('form-control');
		input.placeholder = placeholders[i];

		if (i === 2 || i === 5) {
		    input.type = 'text';
		}

		if (i === 3 || i === 4) {
		    input.type = 'text';
		    input.oninput = function () {
		        this.value = this.value.replace(/[^0-9]/g, '');
		    };
		}

		if (i === 5) {
		    input.readOnly = true; // Make input read-only
		}

		cell.appendChild(input);

	    
	}

	}

	// Add the delete button to the last cell
	const deleteCell = newRow.insertCell();
	const deleteButton = document.createElement('button');
	deleteButton.textContent = 'Delete';
	deleteButton.onclick = function() {
	  deleteRow(deleteButton);
	};
	deleteButton.classList.add('btn', 'btn-danger');
	deleteButton.style.marginLeft = '12%';
	deleteCell.appendChild(deleteButton);


	});


}
/////////////////// END SUBS AND PERPETUAL TABLE


//last one end
function deleteRow(btn)
{
	    const row = btn.parentNode.parentNode;
	    row.parentNode.removeChild(row);
}

function resoucesamount(){
	// alert("HIH")
    // Get the value from the input field
    var resoucesamount = document.getElementById("resoucesamount").value;
    
    // Regular expression pattern for a valid email address
    var resoucesamountPattern =/^\d+(\.\d+)?$/;


}
function validateapprover(){
	
    var deploysupport = document.getElementById("deploysupport").value;
    

    var deploysupportPattern =/^\d+(\.\d+)?$/;


}
function validateQuantity(input) {

    var inputValue = input.value;
    // Remove non-numeric characters from the input
    var numericValue = inputValue.replace(/\D/g, '');

    // Update the input field with the numeric value
    input.value = numericValue;

  var quantitydatacharges = document.getElementById("quantitydata").value;
  
  // Regular expression pattern for a valid email address
  var quantitydataPattern =/^\d+(\.\d+)?$/;


}
function validateunitrate(input){

	  var inputValue = input.value;
	   
	    var numericValue = inputValue.replace(/\D/g, '');

	 
	    input.value = numericValue;
  // Get the value from the input field
  var unitratedata = document.getElementById("unitratedata").value;
  
  // Regular expression pattern for a valid email address
  var unitratedataPattern =/^\d+(\.\d+)?$/;


}
function validatecloud(){

    var clouddeploycharges = document.getElementById("clouddeploycharges").value;
    

    var clouddeploychargesPattern =/^\d+(\.\d+)?$/;


}

function submitData() {
//	alert("hihiSSSSSSSssssssssss")
	SaveVeloxProposal();
	
	var spinner = document.getElementById("spin1");

    // Set the display property to "none" to hide the spinner
    spinner.style.display = "block";
    

	
 // if (!validatepo()) {
// 		 
 // event.preventDefault();
//     	
 // } else {
 	
 // alert("zsjhcb");
 	var selectvalue = $("#Proposaltype").val();	

 	var selectvalue21 = $("#Proposaltype").val();	
 	
 	
 	  var array1=[];
 	  var array2=[];

 	  
 	if(selectvalue === "AMC")
 	{
 		
         array1 = 'NA';
 		
 		
 		
 	}
 	else if (selectvalue === "Fixed" || selectvalue === "Subscription" || selectvalue === "Perpetual" || selectvalue === "Resource"
 		|| selectvalue === "Subscription & Perpetual")
 	{
 	
     const tableBody = document.querySelector("#data-table tbody");
     const rows = tableBody.querySelectorAll('tr');
      
      
     for (const row of rows) {
         const inputs = row.querySelectorAll('input');
             const select = row.querySelector('#productsuitaddrow'); 
             const select1 = row.querySelector('#productnameaddrow');
  
         for (const input of inputs) {
             if (input.value.trim() === '') {
               
                 return; 
             }
         }

         const   dataObj = {
 	    prodsuit :select.value, // i added this
        prodname: select1.value, 
         descp: inputs[0].value,
         qty: inputs[1].value,
         urate: inputs[2].value,
         toprice: inputs[3].value,
         };

         const csvString = Object.values(dataObj).join(',');
        
         array1.push(dataObj);   
       
     }
    
     
     if (selectvalue21 === "Subscription & Perpetual" )
 	{
 	
     const tableBody = document.querySelector("#data-table21 tbody");
     const rows = tableBody.querySelectorAll('tr');
      
    
     
      
     for (const row of rows) {
         const inputs = row.querySelectorAll('input');
             const select = row.querySelector('#productsuitaddrow21'); 
             const select1 = row.querySelector('#productnameaddrow21');
  
         for (const input of inputs) {
             if (input.value.trim() === '') {
               
                 return; 
             }
         }

         const   dataObj = {
 	    prodsuit :select.value, // i added this
        prodname: select1.value, 
         descp: inputs[0].value,
         qty: inputs[1].value,
         urate: inputs[2].value,
         toprice: inputs[3].value,
         };

         const csvString = Object.values(dataObj).join(',');
       
         array2.push(dataObj);   
       
     }
     	
     }else{
     	

 	 array2 = 'NA';
 	 

     }
     
    
     
  
     
 // }
    
 }

}


function saveReviseManualFile() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/updateReviseManualdata";

	var formData= new FormData();



//	formData.append('username', $('#username').val());
//	formData.append('userid', $("#userid").val());
//	formData.append('poNumber', $('#poNumber').val());
//	formData.append('producSuiteNames', $('#producSuiteNames').val());
//	formData.append('Securitytool', $('#Securitytool').val());
//	formData.append('ProdManager', $("#ProdManager").val());
//	//formData.append('functionName', $("#functionName").val());
//	formData.append('noteType', $("#noteType").val());



	// Send data to the server using AJAX
	$.ajax({
	    
	    	 type: 'POST',
	         url: serviceUrl,
	         data: formData,
	         processData: false,  // Important: tell jQuery not to process the
									// data
	         contentType: false,
	    }).done(function(data) {
	    alert(data)
	        // Handle different server responses
	    	$('#spin').hide();
	    	
			
	       
	    });
	
}




function SaveVeloxProposal() {  
	
	event.preventDefault();
	
   	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];

// 	var serviceUrl = base_url + "/Master/veloxproposalUpdateDetails";
 	var serviceUrl = base_url + "/UserActivity/updateReviseManualProposal";

 	
 	
// alert("A :"+$("#totalpriceforallproduct").val());
// alert("DEPLOYE SUPPORT :"+$("#deploysupport").val());
// alert("CLOUD :"+$("#clouddeploycharges").val());
// alert("INTEGRATION VALUE :"+$("#integrationcharge").val());
// alert("SUB B :"+$("#subtotalB").val());
// alert("TOTAL C :"+$("#totalc").val());
// alert("GST 18 :"+$("#total18percentage").val());
// alert("grand total :"+$("#grandtotal").val());
	
//  alert("inside save veloxdata :"+veloxdata);
//	
//  alert("inside save veloxdata :"+veloxdata1);
 
 	var formData= new FormData(form);


 	formData.append('poinitiator', ($("#poinitiator").val()));
 	formData.append('amount', ($("#amount").val()));
 	formData.append('poinitiatorno', ($("#poinitiatorno").val()));
 	formData.append('FirstApprovername', ($("#FirstApprovername").val()));
 	formData.append('firstapprovercontact', ($("#firstapprovercontact").val()));
 	formData.append('secondApprovername', ($("#secondApprovername").val()));
 	formData.append('secondapprovercontact', ($("#secondapprovercontact").val()));
 	formData.append('clientname', ($("#clientname").val()));
 	formData.append('Description', ($("#Description").val()));
 	
 	formData.append('SecureITprodversion',($(SecureITprodversion)).val());
 	formData.append('Proposaltype', ($("#Proposaltype").val()));
 	formData.append('Perpetualyear', ($("#Perpetualyear").val()));
 	formData.append('Subscriptionyear', ($("#Subscriptionyear").val()));

 	formData.append('productsuitselect', ($("#productsuitselect").val()));
 	formData.append('Scanplusprodversion', ($("#Scanplusprodversion").val()));
 	formData.append('fixedyear', ($("#fixedyear").val()));
 	formData.append('enccustomername', ($("#enccustomername").val()));
 	formData.append('crno', $("#crnoo").val());
 	formData.append('tid', $("#tid").val());
 	formData.append('SInote', ($("#SInote").val()));

 
 	formData.append('contactperson', ($("#contactperson").val()));





 	// Send data to the server using AJAX
 	$.ajax({
 	    
 	    	 type: 'POST',
 	         url: serviceUrl,
 	         data: formData,
 	         processData: false,  // Important: tell jQuery not to process the
 									// data
 	         contentType: false,
 	    }).done(function(data) {
 	  //   alert(data)
 	        // Handle different server responses
 	    	$('#spin').hide();
 	    	
 	    	var dataArray = data.split(',');
 	    	 var firstPart = dataArray[0]; // "RF-20"
 	    	 var secondPart = dataArray[1]; // "Success"
 	    	
 	    	
 			if (secondPart === "success") {
 	        	     swal({
 	                     title: "Successfull!",
 	                    // text: "Record Added Successfully",
 	                     html: firstPart+"<br>Revise Manual Commercial Proposal Update Successfully",
 	                     type: "success",
 	                     width: 300,
 	                     height: 200,
 	                     buttons: false,
 	                     allowOutsideClick: false,
 	                     preConfirm: function() {
 	                         var l = window.location;
 	                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	                         window.location.href = base_url + "/User/revisedManualProposalRejectedSI";
 	                     }

 	                 });

 	          }
 	          
 	          else if (secondPart === "error") {
 	              swal({
 	                  title: "Unsuccessful!",
// 	                  text: "Fail to add data",
 	                 html: firstPart+"<br>Revise Manual Commercial Proposal Update Unsuccessful",
 	                  type: "success",
 	                  width: 300,
 	                  height: 200,

 	                  buttons: false,
 	                  allowOutsideClick: false,
 	                  preConfirm: function() {
 	                      var l = window.location;
 	                      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	                      window.location.href = base_url + "/User/revisedManualProposalRejectedSI";
 	                  }

 	              });

 	            }
 	    	
 			
 	       
 	    });
 	
 	
 	
 	
 
//  $.ajax({
//      type: 'POST',
//      url: serviceUrl,
//      datatype: 'json',
//      data:'poinitiator=' + encodeURIComponent($("#poinitiator").val())
//      +'&amount=' +encodeURIComponent($("#amount").val())
//       +'&poinitiatorno=' + encodeURIComponent($("#poinitiatorno").val())
//       +'&FirstApprovername=' + encodeURIComponent($("#FirstApprovername").val())
//       +'&firstapprovercontact=' + encodeURIComponent($("#firstapprovercontact").val())
//       +'&secondApprovername=' + encodeURIComponent($("#secondApprovername").val())
//       +'&secondapprovercontact=' + encodeURIComponent($("#secondapprovercontact").val()) 
//       +'&clientname=' + encodeURIComponent($("#clientname").val())
//       +'&Description=' + encodeURIComponent($("#Description").val())
//       +'&deploysupport=' + encodeURIComponent($("#deploysupport").val())
//       +'&clouddeploycharges=' + encodeURIComponent($("#clouddeploycharges").val())
//       +'&totalpriceforallproduct=' + encodeURIComponent($("#totalpriceforallproduct").val())
//        +'&subtotalB=' + encodeURIComponent($("#subtotalB").val())
//        +'&subtotalAB=' + encodeURIComponent($("#subtotalAB").val())
//        +'&resoucesamount=' + encodeURIComponent($("#resoucesamount").val())
//        +'&ATC=' + encodeURIComponent($("#ATC").val())
//        +'&Proposaltype=' + encodeURIComponent($("#Proposaltype").val())
//       +'&Perpetualyear=' + encodeURIComponent($("#Perpetualyear").val())
//       +'&Subscriptionyear=' + encodeURIComponent($("#Subscriptionyear").val())
//       +'&Amcsecondyear=' + encodeURIComponent($("#Amcsecondyear").val())
//       +'&Amcthirdyear=' + encodeURIComponent($("#Amcthirdyear").val())
//       +'&Amcfourthyear=' + encodeURIComponent($("#Amcfourthyear").val())
//       +'&Amcfiveyear=' + encodeURIComponent($("#Amcfiveyear").val())
//       +'&secondyearsubscription=' + encodeURIComponent($("#secondyearsubscription").val())
//       +'&thirdyearsubscription=' + encodeURIComponent($("#thirdyearsubscription").val())
//                   
//        +'&IntegrationCharges=' + encodeURIComponent($("#IntegrationCharges").val())
//        +'&integrationcharge=' + encodeURIComponent($("#integrationcharge").val())
//        +'&totalc=' + encodeURIComponent($("#totalc").val())
//        +'&total18percentage=' + encodeURIComponent($("#total18percentage").val())
//        +'&grandtotal=' + encodeURIComponent($("#grandtotal").val())
//        +'&productsuitselect=' + encodeURIComponent($("#productsuitselect").val())
//         +'&Scanplusprodversion=' + encodeURIComponent($("#Scanplusprodversion").val())
//          +'&fixedyear=' + encodeURIComponent($("#fixedyear").val())
//          +'&enccustomername=' + encodeURIComponent($("#enccustomername").val())
//              + '&crno=' + $("#crnoo").val()
//             + '&tid=' + $("#tid").val()
//             + '&SInote=' + encodeURIComponent($("#SInote").val())
//             
//             
//             // amc new data added
//
//                +'&amcstartdate=' + encodeURIComponent($("#amcstartdate").val())
//                +'&AMCmonthyear=' + encodeURIComponent($("#AMCmonthyear").val())
//                +'&AMCMonth=' + encodeURIComponent($("#AMCMonth").val())
//                +'&AMCYear=' + encodeURIComponent($("#AMCYear").val())
//                +'&amcenddate=' + encodeURIComponent($("#amcenddate").val()) 
//                +'&productsuitdetails=' + encodeURIComponent($("#productsuitdetails").val())
//                +'&securitysolutiondetails=' + encodeURIComponent($("#securitysolutiondetails").val())
//                +'&descforamc=' + encodeURIComponent($("#descforamc").val())
//                +'&totalcostAMC=' + encodeURIComponent($("#totalcostAMC").val())
//                +'&GRANDTOTALFORAMC=' + encodeURIComponent($("#GRANDTOTALFORAMC").val())
//                +'&gstforamc=' + encodeURIComponent($("#gstforamc").val()) 
//                
//                
//                
//                     // Resource new data added
//                 +'&subtotalAResource=' + encodeURIComponent($("#subtotalAResource").val()) 
//                +'&gstdataforresource=' + encodeURIComponent($("#gstdataforresource").val()) 
//                +'&grandtotalforresource=' + encodeURIComponent($("#grandtotalforresource").val())
//                
//                 +'&contactperson=' + encodeURIComponent($("#contactperson").val())
//                 
//                  // subs&perp Table
//                 
//                 
//                 +'&subscriptionANDperpetualYear=' + encodeURIComponent($("#subscriptionANDperpetualYear").val())
//                 +'&perpetualSubsAnnualperpType=' + encodeURIComponent($("#perpetualSubsAnnualperpType").val()) 
//                 +'&perpetualSubs3yearperpType=' + encodeURIComponent($("#perpetualSubs3yearperpType").val()) 
//                 +'&deploysupport21=' + encodeURIComponent($("#deploysupport41").val())
//                +'&clouddeploycharges21=' + encodeURIComponent($("#clouddeploycharges41").val())
//                    +'&IntegrationCharges21=' + encodeURIComponent($("#IntegrationCharges41").val())
//                 +'&integrationcharge21=' + encodeURIComponent($("#integrationcharge41").val())
//                 
//                  +'&subtotalB21=' + encodeURIComponent($("#subtotalB41").val())
//                   +'&totalc21=' + encodeURIComponent($("#totalc41").val())
//                    +'&total18percentage21=' + encodeURIComponent($("#total18percentage41").val())
//                     +'&grandtotal21=' + encodeURIComponent($("#grandtotal41").val())
//                      +'&resoucesamount21=' + encodeURIComponent($("#resoucesamount41").val()),
//          
//          
//        
//
//      
//  }).done(function(data) {
//  
//  	$('#spin1').hide();
//
//     
//          
//          if (data === "success") {
//        	     swal({
//                     title: "Successfull!",
//                    // text: "Record Added Successfully",
//                     html: "Revise Manual Commercial Proposal Sent Successfully",
//                     type: "success",
//                     width: 300,
//                     height: 200,
//                     buttons: false,
//                     allowOutsideClick: false,
//                     preConfirm: function() {
//                         var l = window.location;
//                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                         window.location.href = base_url + "/User/SendReviseManualCommercialProposal";
//                     }
//
//                 });
//
//          }
//          
//          else if (data === "error") {
//              swal({
//                  title: "Unsuccessful!",
//                  text: "Fail to add data",
//                  type: "success",
//                  width: 300,
//                  height: 200,
//
//                  buttons: false,
//                  allowOutsideClick: false,
//                  preConfirm: function() {
//                      var l = window.location;
//                      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                      window.location.href = base_url + "/User/SendReviseManualCommercialProposal";
//                  }
//
//              });
//
//            }
//
//  });   
}


function validatepo() {

	var spinner = document.getElementById("spin1");

    // Set the display property to "none" to hide the spinner
    spinner.style.display = "none";
	
	var indexError = 0;
	if ($('#Proposaltype').val().trim() === '') {
		callToolTip122('Proposaltype', 'show');

	indexError = indexError + 1;
	}
// if ($('#Perpetualyear').val().trim() === '') {
// callToolTip122('Perpetualyear', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
//
// if ($('#Subscriptionyear').val().trim() === '') {
// callToolTip122('Subscriptionyear', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }





// if ($('#poinitiator').val().trim() === '') {
// callToolTip122('poinitiator', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }


// if ($('#poinitiatorno').val().trim() === '') {
// callToolTip122('poinitiatorno', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
//	if ($('#FirstApprovername').val().trim() === '') {
//		callToolTip122('FirstApprovername', 'show');
//	if (indexError == 0) {
//
//	}
//	indexError = indexError + 1;
//	} else {
//
//	indexError = 0;
//	}

// if ($('#firstapprovercontact').val().trim() === '') {
// callToolTip122('firstapprovercontact', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
//
//
// if ($('#secondApprovername').val().trim() === '') {
// callToolTip122('secondApprovername', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
//	 
// if ($('#secondapprovercontact').val().trim() === '') {
// callToolTip122('secondapprovercontact', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
	
// if ($('#customerType').val().trim() === '') {
// callToolTip122('customerType', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
	// if ($('#clientname').val().trim() === '') {
// callToolTip122('clientname', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// 
	// if ($('#newcustomername').val().trim() === '') {
// callToolTip122('newcustomername', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// if ($('#newAddress').val().trim() === '') {
// callToolTip122('newAddress', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// if ($('#newdistrict').val().trim() === '') {
// callToolTip122('newdistrict', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// 
	// if ($('#newcity').val().trim() === '') {
// callToolTip122('newcity', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// if ($('#newpin').val().trim() === '') {
// callToolTip122('newpin', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// if ($('#office_mailid').val().trim() === '') {
// callToolTip122('office_mailid', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
//	 if ($('#productsuitaddrow').val().trim() === '') {
//		 callToolTip122('productsuitaddrow', 'show');
//		 if (indexError == 0) {
//
//		 }
//		 indexError = indexError + 1;
//		 } else {
//
//		 indexError = 0;
//		 }
//	 if ($('#productnameaddrow').val().trim() === '') {
//		 callToolTip122('productnameaddrow', 'show');
//		 if (indexError == 0) {
//
//		 }
//		 indexError = indexError + 1;
//		 } else {
//
//		 indexError = 0;
//		 }
//	 if ($('#Desciption').val().trim() === '') {
//		 callToolTip122('Desciption', 'show');
//		 if (indexError == 0) {
//
//		 }
//		 indexError = indexError + 1;
//		 } else {
//
//		 indexError = 0;
//		 }
	 
//	 if ($('#quantitydata').val().trim() === '') {
//		 callToolTip122('quantitydata', 'show');
//		 if (indexError == 0) {
//
//		 }
//		 indexError = indexError + 1;
//		 } else {
//
//		 indexError = 0;
//		 }

//	 if ($('#unitratedata').val().trim() === '') {
//		 callToolTip122('unitratedata', 'show');
//		 if (indexError == 0) {
//
//		 }
//		 indexError = indexError + 1;
//		 } else {
//
//		 indexError = 0;
//		 }
	 

	 
	
	 
// if ($('#clouddeploycharges').val().trim() === '') {
// callToolTip122('clouddeploycharges', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
	 
//	 if ($('#IntegrationCharges').val().trim() === '') {
//		 callToolTip122('IntegrationCharges', 'show');
//		 if (indexError == 0) {
//
//		 }
//		 indexError = indexError + 1;
//		 } else {
//
//		 indexError = 0;
//		 }
	 
//	 if ($('#resoucesamount').val().trim() === '') {
//		 callToolTip122('resoucesamount', 'show');
//		 if (indexError == 0) {
//
//		 }
//		 indexError = indexError + 1;
//		 } else {
//
//		 indexError = 0;
//		 }
	 
//	 if ($('#ATC').val().trim() === '') {
//		 callToolTip122('ATC', 'show');
//		 if (indexError == 0) {
//
//		 }
//		 indexError = indexError + 1;
//		 } else {
//
//		 indexError = 0;
//		 }
// if ($('#totalpriceforallproduct').val().trim() === '') {
// callToolTip122('totalpriceforallproduct', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
//	 if ($('#clientname').val().trim() === '') {
//		 callToolTip122('clientname', 'show');
//		 if (indexError == 0) {
//
//		 }
//		 indexError = indexError + 1;
//		 }
	 
	 
	 
	if (indexError > 0) {
	return false;
	} else {
	return true;
	}


}

var callToolTip122 = function(fieldName, status){


    if (fieldName == "Proposaltype") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Proposal Type  <span>";
    }
// if (fieldName == "Perpetualyear") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Select Perpetual Year <span>";
// }
// if (fieldName == "Subscriptionyear") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Select Subscription Year <span>";
// }
// if (fieldName == "poinitiator") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Maker Name <span>";
// }
// if (fieldName == "poinitiatorno") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Maker Contact Number <span>";
// }
    if (fieldName == "FirstApprovername") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Checker Name <span>";
    }
// if (fieldName == "firstapprovercontact") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Checker Approver Contact No <span>";
// }
// if (fieldName == "secondApprovername") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Authorizer Name <span>";
// }
//  
// if (fieldName == "secondapprovercontact") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Authorizer Contact Number <span>";
// }
  
    if (fieldName == "customerType") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Type Of Customer  <span>";
    }
  
    
    
    
    if (fieldName == "productsuitaddrow") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Product Suite <span>";
    }
    
    if (fieldName == "productnameaddrow") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Product Tool <span>";
    }
    
    if (fieldName == "Desciption") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Desciption  <span>";
    }
    if (fieldName == "quantitydata") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Quantity  <span>";
    }  
    
    if (fieldName == "unitratedata") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Unit Rate <span>";
    }  
    
// if (fieldName == "totalpricedata") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Total Price <span>";
// }
    	
    	if (fieldName == "deploysupport") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Deployement support <span>";
    }
// if (fieldName == "clouddeploycharges") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Deployement Charges <span>";
// }
    	if (fieldName == "IntegrationCharges") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select Integration Charges <span>";
        }
    	if (fieldName == "resoucesamount") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Resources Amount  <span>";
        }
    	if (fieldName == "ATC") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select ATC <span>";
        }
    	
// if (fieldName == "totalpriceforallproduct") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Sub Total <span>";
// }
    	
    	
    	if (fieldName == "newcustomername") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Customer Name  <span>";
        }
    	if (fieldName == "newAddress") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Address  <span>";
        }
    	if (fieldName == "newdistrict") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter District  <span>";
        }
    	if (fieldName == "newcity") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter City  <span>";
        }
    	if (fieldName == "newpin") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Pin  <span>";
        }
    	if (fieldName == "office_mailid") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Office Mailid  <span>";
        }
    	
    	if (fieldName == "clientname") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select Customer Name  <span>";
        }
    $("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });

    if (status == "show") {

        $("#" + fieldName).tooltip('show');

    } else {
        $("#" + fieldName).tooltip('hide');
    }

}

$("#reset-btn").click(function(){

	
	$('#Proposaltype').val("");
// $('#Perpetualyear').val("");
// $('#Subscriptionyear').val("");
	$('#FirstApprovername').val("");
	$('#customerType').val("");
	$('#productsuitaddrow').val("");
	$('#productnameaddrow').val("");
	$('#Desciption').val("");
	$('#quantitydata').val("");
	$('#unitratedata').val("");
// $('#totalpricedata').val("");
	$('#deploysupport').val("");
// $('#clouddeploycharges').val("");
	$('#IntegrationCharges').val("");
	$('#resoucesamount').val("");
	$('#ATC').val("");
	
	$('#Perpetualyear').val("");
	$('#productsuitselect').val("")
	$('#Subscriptionyear').val("");
	$('#subscriptionANDperpetualYear').val("");
	$('#fixedyear').val("");
	$('#Perpetualyear').val("");
	$('#Subscriptionyear').val("");
	$('#clientname').val("");
	$('#enccustomername').val("");
	$('#Description').val("");
	$('#contactperson').val("");
	$('#amount').val("");
	$('#SInote').val("");


	
	callToolTip122('Proposaltype', 'destroy');
// callToolTip122('Perpetualyear', 'destroy');
// callToolTip122('Subscriptionyear', 'destroy');
	callToolTip122('FirstApprovername', 'destroy');
	callToolTip122('customerType', 'destroy');

	callToolTip122('Perpetualyear', 'destroy');
	callToolTip122('Subscriptionyear', 'destroy');
	callToolTip122('subscriptionANDperpetualYear', 'destroy');
	callToolTip122('fixedyear', 'destroy');
	callToolTip122('Perpetualyear', 'destroy');
	callToolTip122('Subscriptionyear', 'destroy');
	
// callToolTip122('Description', 'destroy');
	callToolTip122('productsuitaddrow', 'destroy');
	callToolTip122('productnameaddrow', 'destroy');
	callToolTip122('Desciption', 'destroy');
	callToolTip122('quantitydata', 'destroy');
	callToolTip122('unitratedata', 'destroy');
// callToolTip122('totalpricedata', 'destroy');
	callToolTip122('deploysupport', 'destroy');
// callToolTip122('clouddeploycharges', 'destroy');
	callToolTip122('IntegrationCharges', 'destroy');
	callToolTip122('resoucesamount', 'destroy');
	callToolTip122('ATC', 'destroy');
// callToolTip122('totalpriceforallproduct', 'destroy');
	callToolTip122('clientname', 'destroy');
	
	

});

function integrationcharge()
{
	
	var selectedValue = $("#IntegrationCharges").val();
	
	var selectedValue21 = $("#IntegrationCharges41").val();
	
	if(selectedValue === 'Yes')
	{
	$("#integrationhideid").show();	
	}
	else if(selectedValue === 'No')
	{
	$("#integrationhideid").hide();
    }
    else
    {
	$("#integrationhideid").hide();
	
    }
	
	
	 if(selectedValue21 === 'Yes')
		{
		$("#integrationhideid21").show();
	    }
		else if(selectedValue21 === 'No')
		{
		$("#integrationhideid21").hide();
	    } else
	    {
	    	
	    	$("#integrationhideid21").hide();
	        }
	
}

function downFileStandard() {
	var filename = $('#filenameStandard').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename=" + filename;

}


function AMCMonthYearType(){
	
	var AMCmonthyear =  $('#AMCmonthyear').val();
	
	$('#AMCMonth').val('');
	$('#AMCend').val('');
	$('#amcenddate').val('');
	
	if(AMCmonthyear === 'Month'){
		 $("#AMCMonthDiv").show();
	     $("#AMCYearDiv").hide();
		 
	}else if(AMCmonthyear === 'Year'){
		 $("#AMCMonthDiv").hide();
		 $("#AMCYearDiv").show();
	}else {
		 $("#AMCMonthDiv").hide();
		 $("#AMCYearDiv").hide();
		
	}
	
}



function AMCendmonth(){
	
	var amcstartdate =  $('#amcstartdate').val();
	var AMCMonth =  $('#AMCMonth').val();

	const dateFormat = "DD-MM-YYYY";
	const inputDate = moment(amcstartdate, dateFormat);
	
	   inputDate.add(AMCMonth, 'months');
	   
		 // Subtract one day from the result date
	    inputDate.subtract(1, 'days');
	    
	  
	    // Format the result date back to "DD-MM-YYYY" format
	    const resultDateStr = inputDate.format(dateFormat);
	    
	   // //alert(resultDateStr);
	    $('#amcenddate').val(resultDateStr);
	    
}

function AMCendYear(){
	
	var amcstartdate =  $('#amcstartdate').val();
	var AMCYear =  $('#AMCYear').val();

	const dateFormat = "DD-MM-YYYY";
	const inputDate = moment(amcstartdate, dateFormat);
	
	   inputDate.add(AMCYear, 'years');
	   
		 // Subtract one day from the result date
	    inputDate.subtract(1, 'days');

	    // Format the result date back to "DD-MM-YYYY" format
	    const resultDateStr = inputDate.format(dateFormat);
	    
// alert(resultDateStr);
	    $('#amcenddate').val(resultDateStr);
	    
	   
}

