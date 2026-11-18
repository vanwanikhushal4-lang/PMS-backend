
var poid=$('#crnoo').val();

window.onload = function() {

	//
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getProposalIdsforlist";


		$.ajax({
			    type: 'POST',
			    url: serviceUrl,
			    dataType:'JSON',
//			    data: 'proposaltype=' + proposaltype
//			    +  '&perpetualyear=' + perpetualyear,
	  }).done(function(data) {
		  
////alert(data);
	      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
	      html=html+'<option value="">--Please Select Proposal ID--</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }

	      document.getElementById("proposalids").innerHTML=html;
	  
	  });	
	
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getsecuritysolutionListing";
//alert("kkkkkkkk"+$("#productsuit").val())
		$.ajax({
		    type: 'POST',
		    url: serviceUrl,
		    dataType:'JSON',
		    data: 'productsuit=' + encodeURIComponent($("#productsuit").val())
		}).done(function(data2Array) {
//		alert("niii"+data2Array)	
	  var html =" <select class='form-control' tabindex='9' id='securitytool' name='securitytool'   multiple='multiple' '>";
		//   var html = "<option value=''> -- Please Select --</option>";
		    for (var i = 0; i < data2Array.length; i++) {
		        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
		    }
		    document.getElementById("securitytool").innerHTML = html;
		             
		    $(document).ready(function() {
			      $("#securitytool").multiselect({
			          includeSelectAllOption: true,
			          buttonWidth: '100%',
			          enableFiltering: true,
			          enableCaseInsensitiveFiltering: true,
			          maxHeight: 200
			      });
			  });
	         
	         
		});

	   var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getprodsuit";
		
		
		$.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
//ASYNC : FALSE,
	  }).done(function(data) {
		  

	  var html = "<select class='form-control' tabindex='9' id='productsuit' name='productsuit' multiple='multiple'>";

	  html = html + '<option value="">--Please Select Product Suit--</option>';

	  for (var i = 0; i < data.length; i++) {
	      html += '<option value="' + data[i] + '">' + data[i] + '</option>';
	  }

	  document.getElementById("productsuit").innerHTML = html;

	  $(document).ready(function() {
	      $("#productsuit").multiselect({
	          includeSelectAllOption: true,
	          buttonWidth: '100%',
	          enableFiltering: true,
	          enableCaseInsensitiveFiltering: true,
	          maxHeight: 200
	      });
	  });
});
		
		
	// Get authorizer Name start 
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getAuthorizerNameAM";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	  }).done(function(data) {

//		  alert(data);
	      var html =" <select class='form-control' tabindex='8' id='SecondApprovername' name='SecondApprovername'>";
	      html=html+'<option value="">--Please Select Authorizer Name--</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }

	      document.getElementById("SecondApprovername").innerHTML=html;
	  });
	// Get authorizer Name end
	

		
	//////
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getCustomerName";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	  }).done(function(data) {

	      var html =" <select class='form-control' tabindex='8' id='customername' name='customername'>";
	      html=html+'<option value="">--Please Select Customer--</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }

	      document.getElementById("customername").innerHTML=html;
	  });
	
	//
	  
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
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }

	      document.getElementById("Proposaltype").innerHTML=html;
	  });
	  
	  
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
	var serviceUrl = base_url + "/UserActivity/getPoRejectedSMData";

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "crno=" + $('#crnoo').val() + '&tid=' + $("#tid").val()
			})
			.done(
					function(data) {
						
						//alert("data"+data)

				var aaa = data[0];
						console.log(data)
						// //alert("hhhhh"+data[0][0])

						// $('#pouploadfile').val(data[0][0]);

						if ((decodeURIComponent(aaa[0]) == "File Not Attached")
								|| (decodeURIComponent(aaa[0]) == "NA")
								|| (decodeURIComponent(aaa[0]) == "null")) {
							$('#downHidePOdownloadfile').hide();
						} else {
							document.getElementById('poDownloadfile').innerHTML = decodeURIComponent(aaa[0]);
							document.getElementById('poDownloadfilenameStandard').value = decodeURIComponent(aaa[0]);
							$('#podownloadfileDiv').show();
						}

						if ((decodeURIComponent(aaa[17]) === "File Not Attached")
								|| (decodeURIComponent(aaa[17]) === "NA")) {
							$('#downHideproposalfile').hide();
							$('#downHidepofile').hide();
						} else {
							document.getElementById('vpuploadfileProposal').innerHTML = decodeURIComponent(aaa[17]);
							document.getElementById('filenameStandard').value = decodeURIComponent(aaa[17]);
							$('#proposalUploadDiv').show();
							$('#poUploadDiv').show();
						}

						if ((decodeURIComponent(aaa[32]) === "File Not Attached") || (decodeURIComponent(aaa[32]) === "NA")
								|| (decodeURIComponent(aaa[32]) === "") ) {
							$('#downHidemaskedPOfile').hide();
						} else {
							document.getElementById('maskedPOfile').innerHTML = decodeURIComponent(aaa[32]);
							document.getElementById('filnameMaskedPO').value = decodeURIComponent(aaa[32]);
							$('#maskedPOUploadDiv').show();
						}
						
						if ((decodeURIComponent(aaa[33]) === "File Not Attached") || (decodeURIComponent(aaa[33]) === "NA")
								|| (decodeURIComponent(aaa[33]) === "") ) {
							$('#downHideproductFeaturedfile').hide();
						} else {
							document.getElementById('productFeaturedFile').innerHTML = decodeURIComponent(aaa[33]);
							document.getElementById('filnameProductFeatured').value = decodeURIComponent(aaa[33]);
							$('#productFeaturedUploadDiv').show();
						}
						
//						alert("ninini"+aaa[19])
						
						if (aaa[19] == "Perpetual") {
						    $('#Proposaltype').val(decodeURIComponent(aaa[19]));
						    $('#perpetualhideid').show();
						    $('#proposalidDIv').show();
						    $('#warrantyAmcDateDIv').show();
						    $('#warrantyendDiv').show();
						}
						if (aaa[19] == "AMC") {
						    $('#proposalidDIv').show();
						    $('#Proposaltype').val(decodeURIComponent(aaa[19]));
						    $('#tennureDateeDiv').show();
						    
						}
						
						if (aaa[19] == "Fixed") {
						   
						    $('#Proposaltype').val(decodeURIComponent(aaa[19]));
						    $('#proposalidDIv').show();
						    $('#warrantyAmcDateDIv').show();
						    $('#warrantyendDiv').show();
						    $('#fixedhideid').show();
						     
						}
						
						if (aaa[19] == "Resource") {
						    $('#proposalidDIv').show();
						    $('#Proposaltype').val(decodeURIComponent(aaa[19]));
						    $('#tennureDateeDiv').show();
						    
						}
						if (aaa[19] == "Subscription") {
						    $('#proposalidDIv').show();
						    $('#Proposaltype').val(decodeURIComponent(aaa[19]));
						    $('#tennureDateeDiv').show();
						    $('#subscriptionhideid').show();
						    
						}
//						alert(aaa[19])
						if (aaa[19] == "Subscription & Perpetual") {
//							alert("ni33")
						    // $('#proposalidDIv').show();
						    $('#Proposaltype').val(decodeURIComponent(aaa[19]));
						    $('#tennureDateeDiv').show();
						    // $('#subscriptionhideid').show();
						}

						
						
						$('#ponumber').val(decodeURIComponent(aaa[2]));
						$('#podate').val(decodeURIComponent(aaa[3]));

						$('#proddescrip').val(decodeURIComponent(aaa[4]));
//						alert("securitytool"+aaa[7])
						$('#customername').val(decodeURIComponent(aaa[5]));
						$('#productsuit').val(decodeURIComponent(aaa[6]));
						$('#securitytool').val(decodeURIComponent(aaa[7]));
						$('#paymentterms').val(decodeURIComponent(aaa[8]));
						$('#prodliscense').val(decodeURIComponent(aaa[9]));
						$('#prodamount').val(decodeURIComponent(aaa[10]));

						if (decodeURIComponent(aaa[11]) === 'NA') {
							$('#warrantystartDiv').hide();
						} else {

							$('#warrantystart').val(decodeURIComponent(aaa[11]));
							$('#warrantystartDiv').show();
						}
						if (decodeURIComponent(aaa[12]) === 'NA') {

							$('#warrantyendDiv').hide();
						} else {
							$('#warrantyend').val(decodeURIComponent(aaa[12]));
							$('#warrantyendDiv').show();
						}

						if (decodeURIComponent(aaa[13]) === 'NA') {
							$('#amcstartdateDiv').hide();
						} else {
							$('#amcstartdate').val(decodeURIComponent(aaa[13]));
							$('#amcstartdateDiv').show();
						}
						if (decodeURIComponent(aaa[14]) === 'NA') {
							$('#amcenddateDiv').hide();
						} else {
							$('#amcenddate').val(decodeURIComponent(aaa[14]));
							$('#amcenddateDiv').show();
						}

						if ((decodeURIComponent(aaa[15]) === 'NA') || (decodeURIComponent(aaa[15]) === '')) {
							$('#tennurestartdateDiv').hide();
						} else {
							$('#tennurestartdate').val(decodeURIComponent(aaa[15]));
							$('#tennurestartdateDiv').show();
						}
						if ((decodeURIComponent(aaa[16]) === 'NA') || (decodeURIComponent(aaa[16]) === '')) {
							$('#tennureenddateDiv').hide();
						} else {
							$('#tennureenddate').val(decodeURIComponent(aaa[16]));
							$('#tennureenddateDiv').show();
						}
						//$('#advaninvoice').val(decodeURIComponent(aaa[10]));

						// //alert(aaa[54]);
					

						if (decodeURIComponent(aaa[18]) === 'NA') {
							$('#SInoteDiv').hide();
						} else {
							$('#SInote').val(decodeURIComponent(aaa[18]));
							$('#SInoteDiv').show();
						}
					
			
						$('#Perpetualyear').val(decodeURIComponent(aaa[20]));
//						alert(aaa[21])
						$('#proposalids').val(decodeURIComponent(aaa[21]));
						$('#FirstApprovername').val(decodeURIComponent(aaa[22]));
						$('#SecondApprovername').val(decodeURIComponent(aaa[23]));
						$('#warrantyMonth').val(decodeURIComponent(aaa[24]));
						$('#AMCMonth').val(decodeURIComponent(aaa[25]));
						
//						$('#tennuremonthyear').val(decodeURIComponent(aaa[27]));
						$('#tennureMonth').val(decodeURIComponent(aaa[26]));
						$('#warrantyYear').val(decodeURIComponent(aaa[28]));
						$('#AMCYear').val(decodeURIComponent(aaa[29]));
						$('#fixedyear').val(decodeURIComponent(aaa[30]));
						$('#Subscriptionyear').val(decodeURIComponent(aaa[31]));
						
						

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
                $("#fixedhideid").hide();
                $("#proposalidDIv").show();
                $("#warrantyAmcDateDIv").show();
                $("#Subscriptionyear").val('');
                $("#Perpetualyear").val('');
                $("#tennureDateeDiv").hide();
                $('#poUploadDiv').hide();
                
            } else if (selectedValue === "Subscription") { 
                $("#subscriptionhideid").show();
                 $("#perpetualhideid").hide();
                 $("#fixedhideid").hide();
                 $("#proposalidDIv").show();
                 $("#warrantyAmcDateDIv").hide();
                 $("#tennureDateeDiv").show();
                 $('#poUploadDiv').hide();
          } else if (selectedValue === "Fixed") { 
              $("#subscriptionhideid").hide();
              $("#perpetualhideid").hide();
              $("#fixedhideid").show();
              $("#proposalidDIv").show();
              $("#warrantyAmcDateDIv").show();
              $("#tennureDateeDiv").hide();
              
              $("#fixedyear").val('');
              $("#Perpetualyear").val('');
              $("#proposalids").val('');
              $("#Subscriptionyear").val('');
              
              $("#poUploadDiv").hide();
          
        
       } else if (selectedValue === "AMC") { 
           $("#subscriptionhideid").hide();
           $("#perpetualhideid").hide();
           $("#fixedhideid").hide();
           $("#proposalidDIv").show();
           $("#warrantyAmcDateDIv").hide();
           $("#tennureDateeDiv").show();
           
           $("#fixedyear").val('');
           $("#Perpetualyear").val('');
           $("#proposalids").val('');
           $("#Subscriptionyear").val('');
           $('#poUploadDiv').hide();
           
           getProposalID();
           
    }else if (selectedValue === "Resource") { 
        $("#subscriptionhideid").hide();
        $("#perpetualhideid").hide();
        $("#fixedhideid").hide();
        $("#proposalidDIv").show();
        $("#warrantyAmcDateDIv").hide();
        $("#tennureDateeDiv").show();
        
        $("#fixedyear").val('');
        $("#Perpetualyear").val('');
        $("#proposalids").val('');
        $("#Subscriptionyear").val('');
        $('#poUploadDiv').hide();
        
        getProposalID();
        
 }else {
	 $("#fixedhideid").hide();
    	   $("#proposalids").val('');
    	   $("#Subscriptionyear").val('');
           $("#Perpetualyear").val('');
    	   $("#proposalidDIv").hide();
    	   $("#subscriptionhideid").hide();
    	   $("#perpetualhideid").hide();
    	   $("#warrantyAmcDateDIv").hide();
    	   $('#poUploadDiv').hide();
       }
}
//
//

function productFeaturedStandard() {
	var filename = $('#filnameProductFeatured').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}

function maskedPOStandard() {
	
	var filename = encodeURIComponent($('#filnameMaskedPO').val());
        
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}
function resetAll() {

	$('#ponumber').val("");
	$('#podate').val("");
	$('#customername').val("");
	$('#productsuit').val("");
	$('#securitytool').val("");
	$('#prodamount').val("");
	$('#paymentterms').val("");
	$('#prodliscense').val("");
//	$('#warrantystart').val("");
//	$('#warrantyend').val("");
//	$('#amcstartdate').val("");
//	$('#amcenddate').val("");
	$('#pouploadfile').val("");
	$('#proddescrip').val("");
	$('#dateforma').val("");
	$('#salemangname').val("");
	$('#formApoNo').val("");
	$('#distributorpartyname').val("");
	$('#distributorprojectname').val("");
	$('#distributortechpersonname').val("");
	$('#distributorprsndesignation').val("");
	$('#distributorcontactnumber').val("");
	$('#distributoremailid').val("");
	$('#partnerpartyname').val("");
	$('#partnerprojectname').val("");
	$('#partnertechpersonname').val("");
	$('#partnerprsndesignation').val("");
	$('#distributorcontactnumber').val("");
	$('#partneremailid').val("");
	$('#customerpartyname').val("");
	$('#customerprojectname').val("");
	$('#customertechpersonname').val("");
	$('#customerprsndesignation').val("");
	$('#customercontactnumber').val("");
	$('#customeremailid').val("");
	$('#implementorpartyname').val("");
	$('#implementorprojectname').val("");
	$('#implementortechpersonname').val("");
	$('#implementorprsndesignation').val("");
	$('#implementorcontactnumber').val("");
	$('#implementoremailid').val("");
	$('#form2date').val("");
	$('#form2customername').val("");
	$('#RPFTIMELINES').val("");
	$('#potimeline').val("");
	$('#poform2No').val("");
	$('#firstinvoicegeneratedate').val("");
	$('#projstartdate').val("");
	$('#projenddate').val("");
	$('#pymentterms').val("");
	$('#projecthead').val("");
	
	$('#Remarks').val("");
	$('#advaninvoice').val("");
	$('#radiosss').val("");
	$('#advinvoicefile').val("");
	
	 $("#productsuit option:selected").prop("selected", false);
     $("#productsuit").multiselect('refresh');
     $("#productsuit").val('').trigger('change');
  
	
      $("#securitytool option:selected").prop("selected", false);
      $("#securitytool").multiselect('refresh');
      $('#Perpetualyear').val("");
      $('#proposalids').val("");
      
      $('#warrantystart').val("");
      $('#warrantymonthyear').val("");
      $('#warrantyend').val("");
      $('#amcstartdate').val("");
      $('#AMCmonthyear').val("");
      $('#amcenddate').val("");
      $('#SInote').val("");
      $('#pouploadfile').hide();
      
      


$('#FirstApprovername').val("");
$('#SecondApprovername').val("");




$('#warrantyMonth').val("");
$('#AMCMonth').val("");
$('#warrantyYear').val("");
$('#AMCYear').val("");

$('#Proposaltype').val("");
//proposaltypedata();
	



$('#fixedyear').val("");
$('#Perpetualyear').val("");
$('#Subscriptionyear').val("");
$('#proposalids').val("");


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

function warrantyendmonth(){
	
	var warrantystartdate =  $('#warrantystart').val();
	var warrantyMonth =  $('#warrantyMonth').val();

	const dateFormat = "DD-MM-YYYY";
	const inputDate = moment(warrantystartdate, dateFormat);
	
	   inputDate.add(warrantyMonth, 'months');
	   
		 // Subtract one day from the result date
	    inputDate.subtract(1, 'days');

	    // Format the result date back to "DD-MM-YYYY" format
	    const resultDateStr = inputDate.format(dateFormat);
	    

	    
	   // //alert(resultDateStr);
	    $('#warrantyend').val(resultDateStr);
	    
	    addDaysforAMC(resultDateStr);
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

function addDaysforAMC(resultDate) {
    const daysToAdd = 01;
    const dateFormat = "DD-MM-YYYY";
    const inputDate = moment(resultDate, dateFormat);

    inputDate.add(daysToAdd, 'days');
    // Format the result date back to "DD-MM-YYYY" format
    const resultDateStr = inputDate.format(dateFormat);

    $('#amcstartdate').val(resultDateStr);
}

function warrantyendYear(){
	
	var warrantystartdate =  $('#warrantystart').val();
	var warrantyYear =  $('#warrantyYear').val();

	const dateFormat = "DD-MM-YYYY";
	const inputDate = moment(warrantystartdate, dateFormat);
	
	   inputDate.add(warrantyYear, 'years');
	   
		 // Subtract one day from the result date
	    inputDate.subtract(1, 'days');

	    // Format the result date back to "DD-MM-YYYY" format
	    const resultDateStr = inputDate.format(dateFormat);
	    
	   // //alert(resultDateStr);
	    $('#warrantyend').val(resultDateStr);
	    
	    addDaysforAMC(resultDateStr);
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
	    
	   // //alert(resultDateStr);
	    $('#amcenddate').val(resultDateStr);
	    
	   
}

function downFileStandard() {
	var filename = $('#filenameStandard').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}


function downPOdownloadFileStandard() {
	var filename = $('#poDownloadfilenameStandard').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}


function proposalStandard() {
	var filename = $('#filnameProposal').val();
	// //alert(filename);
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

function advInvFileStandard() {
	var filename = $('#filnameAdvinvoice').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

function AMCMonthYearType(){
	
	var AMCmonthyear =  $('#AMCmonthyear').val();
	
//	$('#AMCMonth').val('');
//	$('#AMCend').val('');
//	$('#amcenddate').val('');
	
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

function warrantyMonthYearType(){
	
	var warrantymonthyear =  $('#warrantymonthyear').val();
	
//	$('#warrantyMonth').val('');
//	$('#warrantyend').val('');
//	$('#amcstartdate').val('');
//	
//	$('#AMCMonth').val('');
//	$('#amcenddate').val('');
//	$('#AMCYear').val('');
	

//	callToolTip231('warrantymonthyear', 'destroy');
//	callToolTip231('warrantyYear', 'destroy');
//	callToolTip231('warrantyMonth', 'destroy');
//	callToolTip231('AMCmonthyear', 'destroy');
//	callToolTip231('AMCYear', 'destroy');
//	callToolTip231('AMCMonth', 'destroy');
	
if(warrantymonthyear === 'Month'){
		 $("#warrantyMonthDiv").show();
	     $("#warrantyYearDiv").hide();
		 
	}else if(warrantymonthyear === 'Year'){
		 $("#warrantyMonthDiv").hide();
		 $("#warrantyYearDiv").show();
	}else {
		 $("#warrantyMonthDiv").hide();
		 $("#warrantyYearDiv").hide();
		 
	}
}


function getProposalID(){
	

	

	
	var proposaltype = $('#Proposaltype').val();
	
	var subscriptionyear = $('#Subscriptionyear').val();
	var perpetualyear = $('#Perpetualyear').val();
	
	var fixedyear = $('#fixedyear').val();
	
	
	if((subscriptionyear != "") && ((subscriptionyear === "Annual Price") || (subscriptionyear === "3 year Subscription"))){
		
//          alert("subscriptionyear "+subscriptionyear);
		
		  var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getProposalIds";

        
			$.ajax({
				    type: 'POST',
				    url: serviceUrl,
				    dataType:'JSON',
				    data: 'proposaltype=' + proposaltype
				    +  '&subscriptionyear=' + subscriptionyear,
		  }).done(function(data) {
			  

		      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
		      html=html+'<option value="">--Please Select Proposal ID--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("proposalids").innerHTML=html;
		  
		  });	

}else if(($('#Perpetualyear').val() != "") && ( ($('#Perpetualyear').val() === "1 year Warranty") || ($('#Perpetualyear').val() === "3 year Warranty") || ($('#Perpetualyear').val() === "5 year Warranty"))){
	
//		alert("perpetualyear "+perpetualyear);
		
		 var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getProposalIds";

     
			$.ajax({
				    type: 'POST',
				    url: serviceUrl,
				    dataType:'JSON',
				    data: 'proposaltype=' + proposaltype
				    +  '&perpetualyear=' + perpetualyear,
		  }).done(function(data) {
			  
////alert(data);
		      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
		      html=html+'<option value="">--Please Select Proposal ID--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("proposalids").innerHTML=html;
		  
		  });	
	}else if($('#Proposaltype').val() === "AMC"){
	
//		alert("AMC "+$('#Proposaltype').val());
		
		 var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getProposalIds";

     
			$.ajax({
				    type: 'POST',
				    url: serviceUrl,
				    dataType:'JSON',
				    data: 'proposaltype=' + proposaltype,
		  }).done(function(data) {
			  
//alert(data);
		      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
		      html=html+'<option value="">--Please Select Proposal ID--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("proposalids").innerHTML=html;
		  
		  });	
	}else if(fixedyear != ""){
	
//		alert("Fixed "+$('#Proposaltype').val());
//		alert("Fixed "+$('#fixedyear').val());
		
		 var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getProposalIds";

     
			$.ajax({
				    type: 'POST',
				    url: serviceUrl,
				    dataType:'JSON',
				    data: 'proposaltype=' + proposaltype
				    +  '&fixedyear=' + $('#fixedyear').val(),
		  }).done(function(data) {
			  
////alert(data);
		      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
		      html=html+'<option value="">--Please Select Proposal ID--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("proposalids").innerHTML=html;
		  
		  });	
			
			
	}else if($('#Proposaltype').val() === "Resource"){
	
//		alert("Resource "+$('#Proposaltype').val());
		
		 var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getProposalIds";

     
			$.ajax({
				    type: 'POST',
				    url: serviceUrl,
				    dataType:'JSON',
				    data: 'proposaltype=' + proposaltype,
		  }).done(function(data) {
			  
////alert(data);
		      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
		      html=html+'<option value="">--Please Select Proposal ID--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("proposalids").innerHTML=html;
		  
		  });	
	}
	
	
	

}


function updateData() {
//	alert("HIHI")
	
	
	 $('#spin').show();
	
	
	    var l2 = window.location;
	 	var base_url2 = l2.protocol + "//" + l2.host + "/" + l2.pathname.split('/')[1];
	 	var serviceUrl2 = base_url2 + "/UserActivity/insertRejectedPurchaseOrder";
		
	    var serviceUrl2 = serviceUrl2;
	    
   
	    var selectedValues = [];
		$("#productsuit :selected").each(function() {
			selectedValues.push($(this).val());
		});

		var selectedSideBarValuesFinalprodSuit = selectedValues.toString();
		
		
		var selectedValues1 = [];
		$("#securitytool :selected").each(function() {
			selectedValues1.push($(this).val());
		});
	    
		var selectedSideBarValuesFinalSECTool = selectedValues1.toString()
		
		
		var proposalType = $("#Proposaltype").val();
		var proposalids = $("#proposalids").val();
		var filenameStandard = $("#filenameStandard").val();
		var potype = $("#potype").val();
		var firstApprover=$("#FirstApprovername").val()
	    
	    var formData= new FormData(form);
	    formData.append('selectedSideBarValuesFinalprodSuit', selectedSideBarValuesFinalprodSuit);
	     formData.append('selectedSideBarValuesFinalSECTool', selectedSideBarValuesFinalSECTool);
	     formData.append('proposalType', proposalType);
	     formData.append('proposalids', proposalids);
	     formData.append('vpuploadfileProposal', filenameStandard);
	     formData.append('potype', potype);
	     formData.append('potype', potype);
	     formData.append('firstApprover', firstApprover);
	     formData.append('SecondApprovername', SecondApprovername);
	     
	     formData.append('Subscriptionyear', $("#Subscriptionyear").val());
	     formData.append('Perpetualyear', $("#Perpetualyear").val());
	     formData.append('fixedyear', $("#fixedyear").val());
	     formData.append('crno', $("#crnoo").val());
	     formData.append('tid', $("#tid").val());
	     
	   
	 //   //alert("cccc"+formData)
	    
	    $.ajax({
	         type: 'POST',
	         url: serviceUrl2,
	         data: formData,
	         mimeType: "multipart/form-data",
	         contentType: false,
	         processData: false,
	         cache: false,
       		
	     }).done(function(data) {
	    	  $('#spin').hide();
//		         if (data == "success") {
		             swal({
		                 title: "Successful!",
//		                 text: "PO Raised Successfully",
		                 html: "PO ID = " + poid + "<br><br>   PO Updated Successfully",
		                 type: "success",
		                 width: 300,
		                 height: 200,
		                 // showCancelButton: !0,
		                 confirmButtonClass: "btn btn-success",
		                 // cancelButtonClass: "btn btn-danger m-l-10",
		                 confirmButtonText: "OK",
		                 preConfirm: function () {
		                     var l = window.location;
		                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		                     window.location.href = base_url + "/User/PurchaseOrderRejectedSI";
		                 }

		             });


		     });
	      

}

