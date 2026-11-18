

var roleType = $("#role").val();


if(roleType === "Account") {
	$("#InvoiceDiv").show();
} else {
	$("#InvoiceDiv").hide();
}


window.onload = function() {
	
	
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

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getManualPoRaisedData";

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "crno=" + $('#crnoo').val() + '&tid=' + $("#tid").val(),
			})
			.done(
					function(data) {

					

						var aaa = data[0];
						console.log(data)
					//	alert("hhhhh "+data[0])
					//	alert("proposal Typee "+aaa[10])

						// $('#pouploadfile').val(data[0][0]);

						$('#potype').val(aaa[0]);
						
						$('#Proposaltype').val(aaa[10]);
					//	 alert("po Proposaltype :: " +aaa[10])
						$('#ponumber').val(aaa[1]);
						// alert("ponumber :: " +aaa[3])
						$('#podate').val(aaa[2]);
						// alert("po date :: " +aaa[3])
						$('#customername').val(aaa[3]);
						// alert("customername :: " +aaa[5])
						$('#productSuit').val(aaa[4]);
						// alert("productSuit :: " +aaa[6])
						$('#securityTools').val(aaa[5]);
						// alert("securityTools :: " +aaa[7])
						$('#paymentterms').val(aaa[7]);

//						$('#paymentterms').val(encodeURIComponent(aaa[7]));
						// alert("po type :: " +aaa[1])
						$('#prodliscense').val(aaa[8]);
						// alert("po type :: " +aaa[1])
						$('#prodamount').val(aaa[6]);
						// alert("po type :: " +aaa[1])
						if (((aaa[0]) == "File Not Attached")
								|| ((aaa[9]) == "NA")
								|| ((aaa[9]) == "null")) {
							$('#downHidepofile').hide();
						} else {
							document.getElementById('pouploadfile').innerHTML = (aaa[9]);
							document.getElementById('filenameStandard').value = (aaa[9]);
							$('#poUploadDiv').show();
						}
						
						if(aaa[10] === "AMC" || aaa[10] === "Resource" || aaa[10] === "Subscription & Perpetual") {
							$('#tennureDateeDivView').show()
							$('#warrantyAmcDateDIvView').hide()
							
							$('#tennurestartdateView').val(aaa[15]);
							$('#tennureenddateView').val(aaa[16]);
						} else if (aaa[10] === "Fixed" || aaa[10] === "Perpetual" || aaa[10] === "Subscription" ){
							$('#warrantyAmcDateDIvView').show()
							$('#tennureDateeDivView').hide()
							
							$('#warrantystartView').val(aaa[17]);
							$('#warrantyendView').val(aaa[18]);
							$('#amcstartdateView').val(aaa[19]);
							$('#amcenddateView').val(aaa[20]);
							
							
						} 
						$('#poRefNo').val(aaa[21]);
						
						
						// Invoice file

						if ((decodeURIComponent(aaa[22]) === "File Not Attached")
								|| (decodeURIComponent(aaa[22]) === "NA")
								|| (decodeURIComponent(aaa[22]) === "")) {
							$('#downHideadvInvfile').hide();
						} else {
							document.getElementById('advinvoicefile').innerHTML = decodeURIComponent(aaa[22]);
							document.getElementById('filnameAdvinvoice').value = decodeURIComponent(aaa[22]);
							$('#advInvoiceUploadDiv').show();
							$('#reupload').show();
						}
						
					});

}

function downFileStandard() {
	event.preventDefault();
//	alert("d");
//	alert("inside download"+$('#filenameStandard').val())
	var filename = encodeURIComponent($('#filenameStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}


function proposaltypedata()
{
	var selectedValue = $("#Proposaltype").val();
	
	var selectedperpetual = $("#Perpetualyear").val();
	var selectedSubscription = $("#Subscriptionyear").val();
		  
	   $("#proposalidDIv").hide();
//	   $("#proposalidDIv").hide();
	   $("#subscriptionANDperpetualhideid").hide();
	   
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
        
 }else if (selectedValue === "Subscription & Perpetual") 
 { 
	   
	// alert("dgjb");
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


function warrantyMonthYearType(){
	
	var warrantymonthyear =  $('#warrantymonthyear').val();
	
	$('#warrantyMonth').val('');
	$('#warrantyend').val('');
	$('#amcstartdate').val('');
	
	$('#AMCMonth').val('');
	$('#amcenddate').val('');
	$('#AMCYear').val('');
	

	callToolTip231('warrantymonthyear', 'destroy');
	callToolTip231('warrantyYear', 'destroy');
	callToolTip231('warrantyMonth', 'destroy');
	callToolTip231('AMCmonthyear', 'destroy');
	callToolTip231('AMCYear', 'destroy');
	callToolTip231('AMCMonth', 'destroy');
	
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






///// Changessss 









function poNumberFun(){
	
	var pono = $('#ponumber').val();
	
	$('#formApoNo').val(pono);
	$('#poform2No').val(pono);
}

function poCustomerName(){
	
	var pocustomername = $('#customername').val();
	$('#form2customername').val(pocustomername);
}

function poDateFun(){
	
	var podate =  $('#podate').val();
	
	$('#dateforma').val(podate);
	$('#form2date').val(podate);
}

function warrantyMonthYearType(){
	
	var warrantymonthyear =  $('#warrantymonthyear').val();
	
	$('#warrantyMonth').val('');
	$('#warrantyend').val('');
	$('#amcstartdate').val('');
	
	$('#AMCMonth').val('');
	$('#amcenddate').val('');
	$('#AMCYear').val('');
	

	callToolTip231('warrantymonthyear', 'destroy');
	callToolTip231('warrantyYear', 'destroy');
	callToolTip231('warrantyMonth', 'destroy');
	callToolTip231('AMCmonthyear', 'destroy');
	callToolTip231('AMCYear', 'destroy');
	callToolTip231('AMCMonth', 'destroy');
	
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


function proposaltypedata()
{
	var selectedValue = $("#Proposaltype").val();
	
	var selectedperpetual = $("#Perpetualyear").val();
	var selectedSubscription = $("#Subscriptionyear").val();
		  
	   $("#proposalidDIv").hide();
//	   $("#proposalidDIv").hide();
	   $("#subscriptionANDperpetualhideid").hide();
	   
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
        
 }else if (selectedValue === "Subscription & Perpetual") 
 { 
	   
	// alert("dgjb");
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


function getReportDate() {
	
	

	   var momentAdb = moment($('#warrantystart').val(),"DD-MM-YYYY");
	    var momentBcd =moment($('#warrantyend').val(),"DD-MM-YYYY");
	    
	    

	    if (momentAdb > momentBcd){
	    	
	    	swal({
	                    title: "Warning",
	                    text: "Warranty End Date should be Greater than Start Date!",
	                    type: "warning",
	                    width: 300,
	                    allowOutsideClick: false,

	                });
	    	
	     
	         return false;
	    }else{
	     return true;
	 }

	}


function getAMCReportDate() {
	
	

	   var momentAMC = moment($('#amcstartdate').val());
	    var momentAMC2 =moment($('#amcenddate').val());
	    
	    

	    if (momentAMC > momentAMC2){
	    	
	    	swal({
	                    title: "Warning",
	                    text: "AMC End Date should be Greater than Start Date!",
	                    type: "warning",
	                    width: 300,
	                    allowOutsideClick: false,

	                });
	    	
	     
	         return false;
	    }else{
	     return true;
	 }

	}

function getProposaldata(){
	
	$('#Subscriptionyear').val('');
	getProposalID();
}

function getProposaldata1(){
	
	$('#Perpetualyear').val('');
	getProposalID();
}
function proposalbaseddatashowedsubsANDperp()
{
	
	getProposalID();

}


function getProposalID(){
	
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getProposalIds";
	

	
	var proposaltype = $('#Proposaltype').val();
	
	var subscriptionyear = $('#Subscriptionyear').val();
	var perpetualyear = $('#Perpetualyear').val();
	
	var fixedyear = $('#fixedyear').val();
	
	var selectedValue = $("#subscriptionANDperpetualYear").val();
	
	if((subscriptionyear != "") && ((subscriptionyear === "Annual Price") || (subscriptionyear === "3 year Subscription"))){
		

		
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
	

     
			$.ajax({
				    type: 'POST',
				    url: serviceUrl,
				    dataType:'JSON',
				    data: 'proposaltype=' + proposaltype
				    +  '&perpetualyear=' + perpetualyear,
		  }).done(function(data) {
			  

		      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
		      html=html+'<option value="">--Please Select Proposal ID--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("proposalids").innerHTML=html;
		  
		  });	
	}else if($('#Proposaltype').val() === "AMC"){
	

		
	

     
			$.ajax({
				    type: 'POST',
				    url: serviceUrl,
				    dataType:'JSON',
				    data: 'proposaltype=' + proposaltype,
		  }).done(function(data) {
			  

		      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
		      html=html+'<option value="">--Please Select Proposal ID--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("proposalids").innerHTML=html;
		  
		  });	
	}else if(fixedyear != ""){
	

	

     
			$.ajax({
				    type: 'POST',
				    url: serviceUrl,
				    dataType:'JSON',
				    data: 'proposaltype=' + proposaltype
				    +  '&fixedyear=' + $('#fixedyear').val(),
		  }).done(function(data) {
			  

		      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
		      html=html+'<option value="">--Please Select Proposal ID--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("proposalids").innerHTML=html;
		  
		  });	
			
			
	}else if($('#Proposaltype').val() === "Resource"){
	

     
			$.ajax({
				    type: 'POST',
				    url: serviceUrl,
				    dataType:'JSON',
				    data: 'proposaltype=' + proposaltype,
		  }).done(function(data) {
			  

		      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
		      html=html+'<option value="">--Please Select Proposal ID--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("proposalids").innerHTML=html;
		  
		  });	
			
	}else if(($('#Proposaltype').val() === "Subscription & Perpetual") && ($("#subscriptionANDperpetualYear").val() != "")){
	

		
	
     
			$.ajax({
			    type: 'POST',
			    url: serviceUrl,
			    dataType:'JSON',
			    data: 'proposaltype=' + encodeURIComponent($('#Proposaltype').val())
			    +  '&subscriptionANDperpetualYear=' + $("#subscriptionANDperpetualYear").val(),
	  }).done(function(data) {
			  

		      var html =" <select class='form-control' tabindex='8' id='proposalids' name='proposalids'>";
		      html=html+'<option value="">--Please Select Proposal ID--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("proposalids").innerHTML=html;
		      
		      
		      $('#proposalidDIv').show();
		  });	
	}
	
	
	

}
function proposalIdAttachment(){
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getProposalIdAttachment";


	$.ajax({
		    type: 'POST',
		    url: serviceUrl,
		    dataType:'JSON',
		    data: 'proposalids=' + $('#proposalids').val()
  }).done(function(data) {
	  

////alert(data);

if ((data == "") || (data == "NA") || (data == "null"))
{
    $('#downHidepofile').hide();
    
} else {
	
    document.getElementById('vpuploadfileProposal').innerHTML = decodeURIComponent(data);
    document.getElementById('filenameStandard').value = decodeURIComponent(data);
    $('#poUploadDiv').show();
    
}
  
  });	
}


//function downFileStandard()
//{
//    var filename = $('#filenameStandard').val();
//    var l = window.location;
//    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;
//
//}

function sectools() {
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuit").val())
	}).done(function(data2Array) {
		
  var html =" <select class='form-control' tabindex='9' id='securitytool' name='securitytool'   multiple='multiple' '>";
	//   var html = "<option value=''> -- Please Select --</option>";
	    for (var i = 0; i < data2Array.length; i++) {
	        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
	    }
	    document.getElementById("securitytool").innerHTML = html;
	             
         $("#securitytool").multiselect('destroy').multiselect({
            includeSelectAllOption: true,
            buttonWidth: '100%',
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            maxHeight: 200
     //   });
         
         });
         
         
	});
		
}

$(document).ready(function() {
    $('#update-btn').click(function() {
    	uploadFile();
    	UpdatePOtypeDate();

    });
});




//$("#update-btn").click(function() {
////	if(!validatepurchaseorder()){
////		event.preventDefault();
////	} else{
////    	UpdatePOtypeDate();
//	
//	UpdatePOtypeDate();
////    	alert("data Saved")
////	}
//	
//});

function validatepurchaseorder() {
//	//alert("HIHIH")
	indexError = 0;
	
	var Proposaltype = $('#Proposaltype').val();
	
if ($('#ponumber').val().trim() === '') {
	callToolTip231('ponumber', 'show');
	if (indexError == 0) {
	
	}
	indexError = indexError + 1;
} 
if ($('#podate').val().trim() === '') {
	callToolTip231('podate', 'show');
	if (indexError == 0) {
		
	}
	indexError = indexError + 1;
} 


if ($('#potype').val().trim() === '') {
	callToolTip231('potype', 'show');
	if (indexError == 0) {
		
	}
	indexError = indexError + 1;
} 

if ($('#customername').val().trim() === '') {
	callToolTip231('customername', 'show');
	if (indexError == 0) {
	
	}
	indexError = indexError + 1;
} 





if ($('#Proposaltype').val().trim() === '') {
	
	callToolTip231('Proposaltype', 'show');
	indexError = indexError + 1;
	
} else if ($('#Proposaltype').val() === 'Fixed') {
	
	if ($('#fixedyear').val().trim() === '') {
		
		callToolTip231('fixedyear', 'show');
		indexError = indexError + 1;
		
	}else if ($('#fixedyear').val().trim() != '') {
		
		
//		if ($('#proposalids').val().trim() === '') {
//			
//			callToolTip231('proposalids', 'show');
//			indexError = indexError + 1;
//			
//		}
		
	}
	
//	if ($('#proposalids').val().trim() === '') {
//		
//		callToolTip231('proposalids', 'show');
//		indexError = indexError + 1;
//		
//	}
//	
	
//	if ($('#warrantystart').val().trim() === '') {
//		
//		callToolTip231('warrantystart', 'show');
//		indexError = indexError + 1;
//		
//	}
	
	if ($('#warrantymonthyear').val().trim() === '') {
		
		callToolTip231('warrantymonthyear', 'show');
		indexError = indexError + 1;
		
	}else if($('#warrantymonthyear').val() === 'Month'){
		
		if ($('#warrantyMonth').val().trim() === '') {
			
			callToolTip231('warrantyMonth', 'show');
			indexError = indexError + 1;
			
		}
	}else if($('#warrantymonthyear').val() === 'Year'){
		
		if ($('#warrantyYear').val().trim() === '') {
			
			callToolTip231('warrantyYear', 'show');
			indexError = indexError + 1;
			
		}
	}
	
	
	if ($('#AMCmonthyear').val().trim() === '') {
		
		callToolTip231('AMCmonthyear', 'show');
		indexError = indexError + 1;
		
	}else if($('#AMCmonthyear').val() === 'Month'){
		
		if ($('#AMCMonth').val().trim() === '') {
			
			callToolTip231('AMCMonth', 'show');
			indexError = indexError + 1;
			
		}
	}else if($('#AMCmonthyear').val() === 'Year'){
		
		if ($('#AMCYear').val().trim() === '') {
			
			callToolTip231('AMCYear', 'show');
			indexError = indexError + 1;
			
		}
	}
	
}else if ($('#Proposaltype').val() === 'Perpetual') {
	

	
	if ($('#Perpetualyear').val().trim() === '') {
		
		callToolTip231('Perpetualyear', 'show');
		indexError = indexError + 1;
		
		
		
	}else if ($('#Perpetualyear').val() != '') {
		
		
//		if ($('#proposalids').val().trim() === '') {
//			
//			callToolTip231('proposalids', 'show');
//			indexError = indexError + 1;
//			
//		}
		
	}
	
	
//if ($('#proposalids').val().trim() === '') {
//		
//		callToolTip231('proposalids', 'show');
//		indexError = indexError + 1;
//		
//	}
	
	
//	if ($('#warrantystart').val().trim() === '') {
//		
//		callToolTip231('warrantystart', 'show');
//		indexError = indexError + 1;
//		
//	}
	
	if ($('#warrantymonthyear').val().trim() === '') {
		
		callToolTip231('warrantymonthyear', 'show');
		indexError = indexError + 1;
		
	}else if($('#warrantymonthyear').val() === 'Month'){
		
		if ($('#warrantyMonth').val().trim() === '') {
			
			callToolTip231('warrantyMonth', 'show');
			indexError = indexError + 1;
			
		}
	}else if($('#warrantymonthyear').val() === 'Year'){
		
		if ($('#warrantyYear').val().trim() === '') {
			
			callToolTip231('warrantyYear', 'show');
			indexError = indexError + 1;
			
		}
	}
	
	
	if ($('#AMCmonthyear').val().trim() === '') {
		
		callToolTip231('AMCmonthyear', 'show');
		indexError = indexError + 1;
		
	}else if($('#AMCmonthyear').val() === 'Month'){
		
		if ($('#AMCMonth').val().trim() === '') {
			
			callToolTip231('AMCMonth', 'show');
			indexError = indexError + 1;
			
		}
	}else if($('#AMCmonthyear').val() === 'Year'){
		
		if ($('#AMCYear').val().trim() === '') {
			
			callToolTip231('AMCYear', 'show');
			indexError = indexError + 1;
			
		}
	}
	
	
	
	
}else if ($('#Proposaltype').val() === 'Subscription') {
	
	if ($('#Subscriptionyear').val().trim() === '') {
		
		callToolTip231('Subscriptionyear', 'show');
		indexError = indexError + 1;
		
	}else if ($('#Subscriptionyear').val() != '') {
		
		
//		if ($('#proposalids').val().trim() === '') {
//			
//			callToolTip231('proposalids', 'show');
//			indexError = indexError + 1;
//			
//		}
		
	}
	
//	if ($('#proposalids').val().trim() === '') {
//		
//		callToolTip231('proposalids', 'show');
//		indexError = indexError + 1;
//		
//	}
	
if ($('#tennurestartdate').val().trim() === '') {
		
		callToolTip231('tennurestartdate', 'show');
		indexError = indexError + 1;
		
	}
	
	if ($('#tennuremonthyear').val().trim() === '') {
		
		callToolTip231('tennuremonthyear', 'show');
		indexError = indexError + 1;
		
	}else if($('#tennuremonthyear').val() === 'Month'){
		
		if ($('#tennureMonth').val().trim() === '') {
			
			callToolTip231('tennureMonth', 'show');
			indexError = indexError + 1;
			
		}
	}else if($('#tennuremonthyear').val() === 'Year'){
		
		if ($('#tennureYear').val().trim() === '') {
			
			callToolTip231('tennureYear', 'show');
			indexError = indexError + 1;
			
		}
	}
	
	
}else if (($('#Proposaltype').val() === 'AMC') || ($('#Proposaltype').val() === 'Resource')) {
	
//		if ($('#proposalids').val().trim() === '') {
//			
//			callToolTip231('proposalids', 'show');
//			indexError = indexError + 1;
//			
//		}
		
		
		if ($('#tennurestartdate').val().trim() === '') {
				
				callToolTip231('tennurestartdate', 'show');
				indexError = indexError + 1;
				
			}
			
			if ($('#tennuremonthyear').val().trim() === '') {
				
				callToolTip231('tennuremonthyear', 'show');
				indexError = indexError + 1;
				
			}else if($('#tennuremonthyear').val() === 'Month'){
				
				if ($('#tennureMonth').val().trim() === '') {
					
					callToolTip231('tennureMonth', 'show');
					indexError = indexError + 1;
					
				}
			}else if($('#tennuremonthyear').val() === 'Year'){
				
				if ($('#tennureYear').val().trim() === '') {
					
					callToolTip231('tennureYear', 'show');
					indexError = indexError + 1;
					
				}
			}
}



if ($('#productsuit').val().length === 0) {
	callToolTip231('productsuit', 'show');
	if (indexError == 0) {
	
	}
	indexError = indexError + 1;
} 
if ($('#securitytool').val().length === 0) {
	callToolTip231('securitytool', 'show');
	if (indexError == 0) {
	
	}
	indexError = indexError + 1;
}
if ($('#prodamount').val().trim() === '') {
	callToolTip231('prodamount', 'show');
	if (indexError == 0) {
	
	}
	indexError = indexError + 1;
} 
if ($('#paymentterms').val().trim() === '') {
	callToolTip231('paymentterms', 'show');
	if (indexError == 0) {
	
	}
	indexError = indexError + 1;
} 

if ($('#prodliscense').val().trim() === '') {
	callToolTip231('prodliscense', 'show');
	if (indexError == 0) {
	
	}
	indexError = indexError + 1;
} 

 
 
if ($('#pouploadfile').val().trim() === '') {
	callToolTip231('pouploadfile', 'show');
	if (indexError == 0) {
	
	}
	indexError = indexError + 1;
} 

//if ($('#proddescrip').val().trim() === '') {
//	callToolTip231('proddescrip', 'show');
//	if (indexError == 0) {
//	
//	}
//	indexError = indexError + 1;
//} 

//if ($('#FirstApprovername').val().trim() === '') {
//	callToolTip231('FirstApprovername', 'show');
//	
//	indexError = indexError + 1;
//} 
//if ($('#SecondApprovername').val().trim() === '') {
//	callToolTip231('SecondApprovername', 'show');
//	
//	indexError = indexError + 1;
//} 







if (indexError > 0) {
	return false;
} else {
	return true;
}

}


	
	
$("#resetbtn").click(function() {
	
	$("#ponumber").value = "";
	    
//	$("#ponumber").val('');
	$("#ponumber").val('').trigger('change')
	$("#podate").val('').trigger('change')
	$("#customername").val('').trigger('change')
	$("#productsuit").val('').trigger('change')
	$("#securitytool").val('').trigger('change')
	$("#prodamount").val('').trigger('change')
	$("#paymentterms").val('').trigger('change')
	$("#prodliscense").val('').trigger('change')
//	$("#warrantystart").val('').trigger('change')
//	$("#warrantyend").val('').trigger('change')
//	$("#amcstartdate").val('').trigger('change')
	$("#Proposaltype").val('').trigger('change')
	$("#advinvoice1").val('').trigger('change')
	$("#pouploadfile").val('').trigger('change')
	$("#proddescrip").val('').trigger('change')
	$("#dateforma").val('').trigger('change')
	
	$("#advinvoicefile").val('').trigger('change')
	
	$("#massPOfile").val('').trigger('change')
	 $("#productsuit option:selected").prop("selected", false);
     $("#productsuit").multiselect('refresh');
     $("#productsuit").val('').trigger('change');
      $("#productsuit").val('');
      
	
     callToolTip231('ponumber', 'destroy');
      callToolTip231('podate', 'destroy');
       callToolTip231('customername', 'destroy');
     callToolTip231('securitytool', 'destroy');
     callToolTip231('prodamount', 'destroy');
     callToolTip231('paymentterms', 'destroy');
     callToolTip231('prodliscense', 'destroy');
//     callToolTip231('warrantystart', 'destroy');
//     callToolTip231('warrantyend', 'destroy');
//     callToolTip231('amcstartdate', 'destroy'); massPOfile
     callToolTip231('Proposaltype', 'destroy');
     callToolTip231('advinvoice1', 'destroy');
     callToolTip231('pouploadfile', 'destroy');
     callToolTip231('massPOfile', 'destroy');
     callToolTip231('proddescrip', 'destroy');
     callToolTip231('dateforma', 'destroy');
   
     
});


function advaninvoiceyes(){
	callToolTip231('advinvoicefile', 'destroy');
var msmedyes = $('#advaninvoice').val();
	
	if(msmedyes === "Yes"){
		$('#advinvoicefile').show();
		
	}else{
		
		$('#advinvoicefile').hide();
		
	}
}

function tennureMonthYearType(){
	
	
	var tennuremonthyear =  $('#tennuremonthyear').val();
	
	$('#tennureMonth').val('');
	$('#tennureYear').val('');
	$('#tennureenddate').val('');
	
	callToolTip231('tennuremonthyear', 'destroy');
	callToolTip231('tennureMonth', 'destroy');
	callToolTip231('tennureYear', 'destroy');
	
	if(tennuremonthyear === 'Month'){
		 $("#tennureMonthDiv").show();
	     $("#tennureYearDiv").hide();
		 
	}else if(tennuremonthyear === 'Year'){
		 $("#tennureYearDiv").show();
		 $("#tennureMonthDiv").hide();
	}else {
		 $("#tennureMonthDiv").hide();
		 $("#tennureYearDiv").hide();
		
	}
		
}
function tennureendmonth() {
	
	var tennurestartdate =  $('#tennurestartdate').val();
	var tennureMonth =  $('#tennureMonth').val();

	const dateFormat = "DD-MM-YYYY";
	const inputDate = moment(tennurestartdate, dateFormat);
	
	   inputDate.add(tennureMonth, 'months');
	  
		 // Subtract one day from the result date
	    inputDate.subtract(1, 'days');

	    // Format the result date back to "DD-MM-YYYY" format
	    const resultDateStr = inputDate.format(dateFormat);
	    
	   // //alert(resultDateStr);
	    $('#tennureenddate').val(resultDateStr);
}
function tennureendYear(){
	
	var tennurestartdate =  $('#tennurestartdate').val();
	var tennureYear =  $('#tennureYear').val();

	const dateFormat = "DD-MM-YYYY";
	const inputDate = moment(tennurestartdate, dateFormat);
	
	   inputDate.add(tennureYear, 'years');
	   
		 // Subtract one day from the result date
	    inputDate.subtract(1, 'days');

	    // Format the result date back to "DD-MM-YYYY" format
	    const resultDateStr = inputDate.format(dateFormat);
	    
	   // //alert(resultDateStr);
	    $('#tennureenddate').val(resultDateStr);
	    
	   
}


function chartpaymntYes(){
	
	callToolTip231('Remarks', 'destroy');
	var radiosss = $('#radiosss').val();
		
		if(radiosss === "Yes"){
			$('#remarksid').show();
			
		}else{
			
			$('#remarksid').hide();
			
		}
}


function myorderType() {
	
	resetAll();
	
	$('#purchaseorderform2').hide();
	$('#purchaseorderformA').hide();
	$('#purchaseorderform').hide();
	
	
	var potype = $('#potype').val();

	if (potype != "" && potype === "Product/Software PO") {
		$('#distributor').show();
		$('#customer').hide();
	} 
	else if (potype != "" && potype === "Resources Order") {
		$('#distributor').show();
		$('#customer').show();
	}else{
		$('#distributor').hide();
		$('#customer').hide();
		
	}

}

$("#submitPOType").click(function() {
	   // //alert("dgfsgf");
    if (!validatePriority()) {

	        event.preventDefault();
	    } else {

	    	
	    	
	    	var potype = $('#potype').val();
	    	if(potype === "Product/Software PO"){
	    		$('#prodsoftheader').show();
	    		$('#resourcesheader').hide();
	        	$('#amcheader').hide();
	        	$('#purchaseorderform').show();
		    	$('#purchaseorderformA').show();
		    	$('#purchaseorderform2').show();
	        
	        }else if (potype === "Resources Order") {
	            
	        	$('#resourcesheader').show();
	        	$('#prodsoftheader').hide();
	        	$('#amcheader').hide();
	        	$('#purchaseorderform').show();
		    	$('#purchaseorderformA').show();
		    	$('#purchaseorderform2').show();
	        
	        }else if (potype === "AMC Order") {
	            
	        	$('#amcheader').show();
	        	$('#resourcesheader').hide();
	        	$('#prodsoftheader').hide();
	        	$('#purchaseorderform').show();
		    	$('#purchaseorderformA').show();
		    	$('#purchaseorderform2').show();
	      
	        } 
	    }
}).show();

$("#resetPOType").click(function() {

	resetAll();
	$('#potype').val("");
	$('#purchaseorderform2').hide();
	$('#purchaseorderformA').hide();
	$('#purchaseorderform').hide();
	callToolTip231('potype', 'destroy');

});


function resetAll() {
	$('#tennureDateeDiv').hide();
//	$('#ponumber').val("");
//	$('#podate').val("");
	$('potype').val("")
//	$('#customername').val("");
//	$('#productsuit').val("");
//	$('#securitytool').val("");
//	$('#prodamount').val("");
//	$('#paymentterms').val("");
//	$('#prodliscense').val("");
//	$('#warrantystart').val("");
//	$('#warrantyend').val("");
//	$('#amcstartdate').val("");
//	$('#amcenddate').val("");
//	$('#pouploadfile').val("");
//	$('#massPOfile').val("");
//	$('#proddescrip').val("");
//	$('#dateforma').val("");
//	$('#salemangname').val("");
//	$('#formApoNo').val("");
//	$('#distributorpartyname').val("");
//	$('#distributorprojectname').val("");
//	$('#distributortechpersonname').val("");
//	$('#distributorprsndesignation').val("");
//	$('#distributorcontactnumber').val("");
//	$('#distributoremailid').val("");
//	$('#partnerpartyname').val("");
//	$('#partnerprojectname').val("");
//	$('#partnertechpersonname').val("");
//	$('#partnerprsndesignation').val("");
//	$('#distributorcontactnumber').val("");
//	$('#partneremailid').val("");
//	$('#customerpartyname').val("");
//	$('#customerprojectname').val("");
//	$('#customertechpersonname').val("");
//	$('#customerprsndesignation').val("");
//	$('#customercontactnumber').val("");
//	$('#customeremailid').val("");
//	$('#implementorpartyname').val("");
//	$('#implementorprojectname').val("");
//	$('#implementortechpersonname').val("");
//	$('#implementorprsndesignation').val("");
//	$('#implementorcontactnumber').val("");
//	$('#implementoremailid').val("");
//	$('#form2date').val("");
//	$('#form2customername').val("");
//	$('#RPFTIMELINES').val("");
//	$('#potimeline').val("");
//	$('#poform2No').val("");
//	$('#firstinvoicegeneratedate').val("");
//	$('#projstartdate').val("");
//	$('#projenddate').val("");
//	$('#pymentterms').val("");
//	$('#projecthead').val("");
//	
//	$('#Remarks').val("");
//	$('#advaninvoice').val("");
//	$('#radiosss').val("");
//	$('#advinvoicefile').val("");
	
	 $("#productsuit option:selected").prop("selected", false);
     $("#productsuit").multiselect('refresh');
     $("#productsuit").val('').trigger('change');
  
	
      $("#securitytool option:selected").prop("selected", false);
      $("#securitytool").multiselect('refresh');
      callToolTip231('potype', 'destroy');
callToolTip231('ponumber', 'destroy');
callToolTip231('podate', 'destroy');
callToolTip231('customername', 'destroy');
callToolTip231('productsuit', 'destroy');
callToolTip231('securitytool', 'destroy');
callToolTip231('prodamount', 'destroy');
callToolTip231('paymentterms', 'destroy');
callToolTip231('prodliscense', 'destroy');
//callToolTip231('warrantystart', 'destroy');
//callToolTip231('warrantyend', 'destroy');
//callToolTip231('amcstartdate', 'destroy');
callToolTip231('Proposaltype', 'destroy');
callToolTip231('pouploadfile', 'destroy');
callToolTip231('massPOfile', 'destroy');

callToolTip231('proddescrip', 'destroy');
callToolTip231('dateforma', 'destroy');
callToolTip231('salemangname', 'destroy');
callToolTip231('formApoNo', 'destroy');
callToolTip231('distributorpartyname', 'destroy');
callToolTip231('distributorprojectname', 'destroy');
callToolTip231('distributortechpersonname', 'destroy');
callToolTip231('distributorprsndesignation', 'destroy');
callToolTip231('distributorcontactnumber', 'destroy');
callToolTip231('distributoremailid', 'destroy');
callToolTip231('partnerpartyname', 'destroy');
callToolTip231('partnerprojectname', 'destroy');
callToolTip231('partnertechpersonname', 'destroy');
callToolTip231('partnerprsndesignation', 'destroy');
callToolTip231('partnercontactnumber', 'destroy');
callToolTip231('partneremailid', 'destroy');
callToolTip231('customerpartyname', 'destroy');
callToolTip231('customerprojectname', 'destroy');
callToolTip231('customertechpersonname', 'destroy');
callToolTip231('customerprsndesignation', 'destroy');
callToolTip231('customercontactnumber', 'destroy');
callToolTip231('customeremailid', 'destroy');
callToolTip231('implementorpartyname', 'destroy');
callToolTip231('implementorprojectname', 'destroy');
callToolTip231('implementortechpersonname', 'destroy');
callToolTip231('implementorprsndesignation', 'destroy');
callToolTip231('implementorcontactnumber', 'destroy');
callToolTip231('implementoremailid', 'destroy');
callToolTip231('form2date', 'destroy');
callToolTip231('form2customername', 'destroy');
callToolTip231('RPFTIMELINES', 'destroy');
callToolTip231('potimeline', 'destroy');
callToolTip231('poform2No', 'destroy');
callToolTip231('firstinvoicegeneratedate', 'destroy');
callToolTip231('projstartdate', 'destroy');
callToolTip231('projenddate', 'destroy');
callToolTip231('pymentterms', 'destroy');
callToolTip231('projecthead', 'destroy');

callToolTip231('advaninvoice', 'destroy');
callToolTip231('advinvoicefile', 'destroy');
callToolTip231('radiosss', 'destroy');
callToolTip231('Remarks', 'destroy');

callToolTip231('FirstApprovername', 'destroy');
callToolTip231('SecondApprovername', 'destroy');

$('#FirstApprovername').val("");
$('#SecondApprovername').val("");
//callToolTip231('warrantyMonth', 'destroy');
//callToolTip231('AMCMonth', 'destroy');
//callToolTip231('warrantyYear', 'destroy');
//callToolTip231('AMCYear', 'destroy');
//callToolTip231('warrantymonthyear', 'destroy');
//callToolTip231('AMCmonthyear', 'destroy');




$('#warrantyMonth').val("");
$('#AMCMonth').val("");
$('#warrantyYear').val("");
$('#AMCYear').val("");

$('#Proposaltype').val("");
proposaltypedata();
	

callToolTip231('fixedyear', 'destroy');
callToolTip231('proposalids', 'destroy');
callToolTip231('Perpetualyear', 'destroy');
callToolTip231('Subscriptionyear', 'destroy');

$('#fixedyear').val("");
$('#Perpetualyear').val("");
$('#Subscriptionyear').val("");
$('#proposalids').val("");


callToolTip231('warrantystart', 'destroy');
callToolTip231('warrantymonthyear', 'destroy');
callToolTip231('warrantyYear', 'destroy');
callToolTip231('warrantyMonth', 'destroy');
callToolTip231('AMCmonthyear', 'destroy');
callToolTip231('AMCYear', 'destroy');
callToolTip231('AMCMonth', 'destroy');


callToolTip231('tennurestartdate', 'destroy');
callToolTip231('tennuremonthyear', 'destroy');
callToolTip231('tennureMonth', 'destroy');
callToolTip231('tennureYear', 'destroy');
}




$('#potype').on('focus', function() {
	callToolTip231('potype', 'destroy');
	
});
$('#ponumber').on('focus', function() {
	callToolTip231('ponumber', 'destroy');
	
});
$('#podate').on('focus', function() {
	callToolTip231('podate', 'destroy');
	
});
$('#customername').on('focus', function() {
	callToolTip231('customername', 'destroy');
	
});
$('#productsuit').on('focus', function() {

	callToolTip231('productsuit', 'destroy');
	
  
});
$('#securitytool').on('focus', function() {

	callToolTip231('securitytool', 'destroy');
	
});
$('#prodamount').on('focus', function() {
	callToolTip231('prodamount', 'destroy');
	
});
$('#paymentterms').on('focus', function() {
	callToolTip231('paymentterms', 'destroy');
	
});
$('#prodliscense').on('focus', function() {
	callToolTip231('prodliscense', 'destroy');
	
});
$('#Proposaltype').on('focus', function() {
	callToolTip231('Proposaltype', 'destroy');
	
});
$('#pouploadfile').on('focus', function() {
	callToolTip231('pouploadfile', 'destroy');
	
});
$('#proddescrip').on('focus', function() {
	callToolTip231('proddescrip', 'destroy');
	
});
$('#dateforma').on('focus', function() {
	callToolTip231('dateforma', 'destroy');
	
});

$('#formApoNo').on('focus', function() {
	callToolTip231('formApoNo', 'destroy');
	
});
$('#distributorpartyname').on('focus', function() {
	callToolTip231('distributorpartyname', 'destroy');
	
});
$('#distributorprojectname').on('focus', function() {
	callToolTip231('distributorprojectname', 'destroy');
	
});
$('#distributortechpersonname').on('focus', function() {
	callToolTip231('distributortechpersonname', 'destroy');
	
});
$('#distributorprsndesignation').on('focus', function() {
	callToolTip231('distributorprsndesignation', 'destroy');
	
});
$('#distributorcontactnumber').on('focus', function() {
	callToolTip231('distributorcontactnumber', 'destroy');
	
});
$('#distributoremailid').on('focus', function() {
	callToolTip231('distributoremailid', 'destroy');
	
});
$('#partnerpartyname').on('focus', function() {
	callToolTip231('partnerpartyname', 'destroy');
	
});
$('#partnerprojectname').on('focus', function() {
	callToolTip231('partnerprojectname', 'destroy');
	
});

$('#potype').on('focus', function() {
	callToolTip231('potype', 'destroy');
	
});

$('#partnertechpersonname').on('focus', function() {
	callToolTip231('partnertechpersonname', 'destroy');
	
});
$('#partnerprsndesignation').on('focus', function() {
	callToolTip231('partnerprsndesignation', 'destroy');
	
});
$('#partnercontactnumber').on('focus', function() {
	callToolTip231('partnercontactnumber', 'destroy');
	
});
$('#partneremailid').on('focus', function() {
	callToolTip231('partneremailid', 'destroy');
	
});
$('#customerpartyname').on('focus', function() {
	callToolTip231('customerpartyname', 'destroy');
	
});
$('#customerprojectname').on('focus', function() {
	callToolTip231('customerprojectname', 'destroy');
	
});
$('#customertechpersonname').on('focus', function() {
	callToolTip231('customertechpersonname', 'destroy');
	
});
$('#customerprsndesignation').on('focus', function() {
	callToolTip231('customerprsndesignation', 'destroy');
	
});
$('#customercontactnumber').on('focus', function() {
	callToolTip231('customercontactnumber', 'destroy');
	
});

$('#customeremailid').on('focus', function() {
	callToolTip231('customeremailid', 'destroy');
	
});

$('#implementorpartyname').on('focus', function() {
	callToolTip231('implementorpartyname', 'destroy');
	
});
$('#implementorprojectname').on('focus', function() {
	callToolTip231('implementorprojectname', 'destroy');
	
});

$('#implementortechpersonname').on('focus', function() {
	callToolTip231('implementortechpersonname', 'destroy');
	
});
$('#implementorprsndesignation').on('focus', function() {
	callToolTip231('implementorprsndesignation', 'destroy');
	
});
$('#implementorcontactnumber').on('focus', function() {
	callToolTip231('implementorcontactnumber', 'destroy');
	
});
$('#implementoremailid').on('focus', function() {
	callToolTip231('implementoremailid', 'destroy');
	
});
$('#form2date').on('focus', function() {
	callToolTip231('form2date', 'destroy');
	
});
$('#form2customername').on('focus', function() {
	callToolTip231('form2customername', 'destroy');
	
});
$('#RPFTIMELINES').on('focus', function() {
	callToolTip231('RPFTIMELINES', 'destroy');
	
});
$('#potimeline').on('focus', function() {
	callToolTip231('potimeline', 'destroy');
	
});
$('#poform2No').on('focus', function() {
	callToolTip231('poform2No', 'destroy');
	
});

$('#firstinvoicegeneratedate').on('focus', function() {
	callToolTip231('firstinvoicegeneratedate', 'destroy');
	
});
$('#projstartdate').on('focus', function() {
	callToolTip231('projstartdate', 'destroy');
	
});
$('#projenddate').on('focus', function() {
	callToolTip231('projenddate', 'destroy');
	
});

$('#pymentterms').on('focus', function() {
	callToolTip231('pymentterms', 'destroy');
	
});

$('#projecthead').on('focus', function() {
	callToolTip231('projecthead', 'destroy');
	
});
$('#advaninvoice').on('focus', function() {
	callToolTip231('advaninvoice', 'destroy');
	
});
$('#advinvoicefile').on('focus', function() {
	callToolTip231('advinvoicefile', 'destroy');
	
});

$('#radiosss').on('focus', function() {
	callToolTip231('radiosss', 'destroy');
	
});
$('#Remarks').on('focus', function() {
	callToolTip231('Remarks', 'destroy');
	
});


$('#FirstApprovername').on('focus', function() {
	callToolTip231('FirstApprovername', 'destroy');
	
});

$('#SecondApprovername').on('focus', function() {
	callToolTip231('SecondApprovername', 'destroy');
	
});





$('#fixedyear').on('focus', function() {
	callToolTip231('fixedyear', 'destroy');
	
});
$('#proposalids').on('focus', function() {
	callToolTip231('proposalids', 'destroy');
	
});

$('#Perpetualyear').on('focus', function() {
	callToolTip231('Perpetualyear', 'destroy');
	
});

$('#Subscriptionyear').on('focus', function() {
	callToolTip231('Subscriptionyear', 'destroy');
	
});



$('#warrantystart').on('focus', function() {
	callToolTip231('warrantystart', 'destroy');
	
});

$('#warrantymonthyear').on('focus', function() {
	callToolTip231('warrantymonthyear', 'destroy');
	
});
$('#warrantyYear').on('focus', function() {
	callToolTip231('warrantyYear', 'destroy');
	
});

$('#warrantyMonth').on('focus', function() {
	callToolTip231('warrantyMonth', 'destroy');
	
});
$('#AMCmonthyear').on('focus', function() {
	callToolTip231('AMCmonthyear', 'destroy');
	
});

$('#AMCYear').on('focus', function() {
	callToolTip231('AMCYear', 'destroy');
	
});
$('#AMCMonth').on('focus', function() {
	callToolTip231('AMCMonth', 'destroy');
	
});



$('#tennurestartdate').on('focus', function() {
	callToolTip231('tennurestartdate', 'destroy');
	
});
$('#tennuremonthyear').on('focus', function() {
	callToolTip231('tennuremonthyear', 'destroy');
	
});

$('#tennureMonth').on('focus', function() {
	callToolTip231('tennureMonth', 'destroy');
	
});
$('#tennureYear').on('focus', function() {
	callToolTip231('tennureYear', 'destroy');
	
});



$('#massPOfile').on('focus', function() {
	callToolTip231('massPOfile', 'destroy');
	
});




var callToolTip231 = function(fieldName, status) {

    if (fieldName == "potype") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select PO Type <span>";
    }
    if (fieldName == "ponumber") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter PO Number <span>";
    }
    if (fieldName == "podate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select PO Date <span>";
    }
    if (fieldName == "customername") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Customer Name <span>";
    }
    if (fieldName == "productsuit") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Product Suit Name <span>";
    }
    if (fieldName == "securitytool") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Security Tool Name <span>";
    }
   
    if (fieldName == "prodamount") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Product Amount <span>";
    }
    
    if (fieldName == "paymentterms") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Payment Terms <span>";
    }
    
    if (fieldName == "prodliscense") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Product License <span>";
    }
    
    if (fieldName == "pouploadfile") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Upload PO File <span>";
    }
    
    if (fieldName == "proddescrip") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Product Description <span>";
    }
    
    if (fieldName == "dateforma") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Date <span>";
    }
 
    if (fieldName == "formApoNo") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter PO Number <span>";
    }
    
    if (fieldName == "distributorpartyname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Name of Party <span>";
    }
 //1   
    if (fieldName == "distributorprojectname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Project Name <span>";
    }
    
    if (fieldName == "distributortechpersonname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Technical Person Name <span>";
    }
    
    if (fieldName == "distributorprsndesignation") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Person Designation <span>";
    }
    
    if (fieldName == "distributorcontactnumber") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Contact NO <span>";
    }
    if (fieldName == "distributoremailid") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Email ID <span>";
    }
    if (fieldName == "partnerpartyname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Name of Party <span>";
    }
    if (fieldName == "partnerprojectname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Project Name <span>";
    }
    if (fieldName == "partnertechpersonname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Technical Person Name <span>";
    }
    if (fieldName == "partnerprsndesignation") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Person Designation <span>";
    }
    if (fieldName == "partnercontactnumber") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Contact Number <span>";
    }
    if (fieldName == "partneremailid") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Enter Email ID <span>";
    }
    
    if (fieldName == "customerpartyname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Name of Party <span>";
    }
    if (fieldName == "customerprojectname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Project Name <span>";
    }
    if (fieldName == "customertechpersonname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Technical Person Name <span>";
    }
    if (fieldName == "customerprsndesignation") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Person Designation<span>";
    }
    if (fieldName == "customercontactnumber") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Contact NO <span>";
    }
    if (fieldName == "customeremailid") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Email ID <span>";
    }
    
    if (fieldName == "implementorpartyname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Name of Party<span>";
    }
    
    
    if (fieldName == "implementorprojectname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Project Name<span>";
    }
    if (fieldName == "implementortechpersonname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Technical Person Name<span>";
    }
    if (fieldName == "implementorprsndesignation") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Person Designation<span>";
    }
    if (fieldName == "implementorcontactnumber") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Contact NO<span>";
    }
    if (fieldName == "implementoremailid") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Email ID<span>";
    }
//f2    
    if (fieldName == "form2date") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Date<span>";
    }
    if (fieldName == "form2customername") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Customer Name<span>";
    }
    if (fieldName == "RPFTIMELINES") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter RPF Timelines <span>";
    }
    if (fieldName == "potimeline") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter PO Timeline Date<span>";
    }
  
    if (fieldName == "poform2No") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter PO number<span>";
    }
    if (fieldName == "firstinvoicegeneratedate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter 1st Invoice Generation Date<span>";
    }
    if (fieldName == "projstartdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Project Start Date<span>";
    }
    if (fieldName == "projenddate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Project End Date <span>";
    }
    if (fieldName == "pymentterms") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Payment Terms <span>";
    }
    if (fieldName == "projecthead") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Project Head  <span>";
    }
    if (fieldName == "advaninvoice") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Advance Invoice  <span>";
    } if (fieldName == "advinvoicefile") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Choose File  <span>";
    }
    if (fieldName == "radiosss") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Payment Option  <span>";
    } if (fieldName == "Remarks") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Your Remark <span>";
    }
   
    if (fieldName == "Proposaltype") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Proposal Type <span>";
    } 

    
   
    if (fieldName == "FirstApprovername") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Approver Name <span>";
    }
    if (fieldName == "SecondApprovername") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Second Name <span>";
    }
    if (fieldName == "fixedyear") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Fixed Year <span>";
    }
    if (fieldName == "proposalids") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Proposal ID <span>";
    }
    if (fieldName == "Perpetualyear") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Perpetual Year <span>";
    }
    if (fieldName == "Subscriptionyear") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Subscription Year <span>";
    }
    
    
  if (fieldName == "warrantystart") {
  //$("#email").tooltip('destroy');
  var errorMessage = "<span>Select Warranty Start Date <span>";
}

if (fieldName == "warrantymonthyear") {
  //$("#email").tooltip('destroy');
  var errorMessage = "<span>Select Month/Year End Date <span>";
}

if (fieldName == "warrantyYear") {
  //$("#email").tooltip('destroy');
  var errorMessage = "<span>Enter Warranty Year <span>";
}

if (fieldName == "warrantyMonth") {
  //$("#email").tooltip('destroy');
  var errorMessage = "<span>Enter Warranty Month <span>";
}

if (fieldName == "AMCmonthyear") {
	  //$("#email").tooltip('destroy');
	  var errorMessage = "<span>Select Month/Year End Date <span>";
	}
if (fieldName == "AMCYear") {
	  //$("#email").tooltip('destroy');
	  var errorMessage = "<span>Enter AMC Year <span>";
	}
if (fieldName == "AMCMonth") {
	  //$("#email").tooltip('destroy');
	  var errorMessage = "<span>Enter AMC Month <span>";
	}
   
if (fieldName == "tennurestartdate") {
	  //$("#email").tooltip('destroy');
	  var errorMessage = "<span>Select Tennure Date<span>";
	}
if (fieldName == "tennuremonthyear") {
	  //$("#email").tooltip('destroy');
	  var errorMessage = "<span>Select Month/Year<span>";
	}if (fieldName == "tennureMonth") {
		  //$("#email").tooltip('destroy');
		  var errorMessage = "<span>Enter Tennure Year <span>";
		}
	if (fieldName == "tennureYear") {
		  //$("#email").tooltip('destroy');
		  var errorMessage = "<span>Enter Tennure Month <span>";
		}
	  if (fieldName == "massPOfile") {
		  //$("#email").tooltip('destroy');
		  var errorMessage = "<span>Upload Masked File <span>";
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

function validatePriority() {
    var indexError = 0;
    if ($('#potype').val().trim() === '') {
        callToolTip231('potype', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
 

    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}


function producttools(){
	
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getprodsuit";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	      async : false,
	  }).done(function(data) {

    var html =" <select class='form-control' tabindex='9' id='productsuit' name='productsuit'   multiple='multiple' onchange='sectools()'>";
	    
	    //  html=html+'<option value="">--Please Select Product Suit--</option>';
	     
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
	      document.getElementById("productsuit").innerHTML=html;
	            	      	      
	     $("#productsuit").multiselect({
      includeSelectAllOption: true,
      buttonWidth: '100%',
      enableFiltering: true,
      enableCaseInsensitiveFiltering: true,
      maxHeight : 200
      
       });
	      	      	    
	  });	
}

//function savepurchaseorder(){
//	 $('#spin').show();
//	
//	////alert("hii")
//	    var l2 = window.location;
//	 	var base_url2 = l2.protocol + "//" + l2.host + "/" + l2.pathname.split('/')[1];
//	 	var serviceUrl2 = base_url2 + "/UserActivity/insertManualPurchaseOrder";
//		
//	    var serviceUrl2 = serviceUrl2;
//	    
////	    var advaninvoice = $("input[name=advaninvoice]:checked").val();
////	    var radiosss = $("input[name=radiosss]:checked").val();
//	    
//	    
//	    var selectedValues = [];
//		$("#productsuit :selected").each(function() {
//			selectedValues.push($(this).val());
//		});
//
//		var selectedSideBarValuesFinalprodSuit = selectedValues.toString();
//		
//		
//		var selectedValues1 = [];
//		$("#securitytool :selected").each(function() {
//			selectedValues1.push($(this).val());
//		});
//	    
//		var selectedSideBarValuesFinalSECTool = selectedValues1.toString()
//		
//		
//		var proposalType = $("#Proposaltype").val();
//		var proposalids = $("#proposalids").val();
//		var filenameStandard = $("#filenameStandard").val();
//		var potype = $("#potype").val();
//		
//	    
//	    var formData= new FormData(form);
//	    formData.append('selectedSideBarValuesFinalprodSuit', selectedSideBarValuesFinalprodSuit);
//	     formData.append('selectedSideBarValuesFinalSECTool', selectedSideBarValuesFinalSECTool);
//	     formData.append('proposalType', proposalType);
//	     formData.append('proposalids', proposalids);
//	     formData.append('vpuploadfileProposal', filenameStandard);
//	     formData.append('potype', potype);
//	     formData.append('potype', potype);
//	     formData.append('ponumber', $("#ponumber").val());
//	     formData.append('podate', $("#podate").val());
//	     formData.append('customername', $("#customername").val());
//	     formData.append('prodamount', $("#prodamount").val());
//	     formData.append('paymentterms', $("#paymentterms").val());
//	    	     
//	 //   //alert("cccc"+formData)
//	    
//	    $.ajax({
//	         type: 'POST',
//	         url: serviceUrl2,
//	         data: formData,
//	         mimeType: "multipart/form-data",
//	         contentType: false,
//	         processData: false,
//	         cache: false,
//
//	         	
//	       
//	         		
//	     }).done(function(data) {
//	    	 alert("dadada"+data)
//	    	  $('#spin').hide();
//		         // //alert("hgdjghd"+data)
//
//		         if (data == "success") {
//		             swal({
//		                 title: "Successful!",
////		                 text: "PO Raised Successfully",
//		                 html: " PO Raised Successfully",
//		                 type: "success",
//		                 width: 300,
//		                 height: 200,
//		                 // showCancelButton: !0,
//		                 confirmButtonClass: "btn btn-success",
//		                 // cancelButtonClass: "btn btn-danger m-l-10",
//		                 confirmButtonText: "OK",
//		                 preConfirm: function () {
//		                     var l = window.location;
//		                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		                     window.location.href = base_url + "/User/ManualPurchaseOrder";
//		                 }
//
//		             });
//
//	     }
//		         else if (data == "duplicate") {
//				        swal({
//				            title: "Duplicate!",
//				            text: "Fail to add file",
//				            type: "error",
//				            width: 300,
//				            height: 200,
//				            buttons: false,
//				            allowOutsideClick: false,
//				            preConfirm: function () {
//				                var l = window.location;
//				                var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//				                window.location.href = base_url + "/User/ManualPurchaseOrder";
//				            }
//				        });
//				    }
//});
//}



// 19/02

function proposaltypedata()
{
	var selectedValue = $("#Proposaltype").val();
	
	var selectedperpetual = $("#Perpetualyear").val();
	var selectedSubscription = $("#Subscriptionyear").val();
		  
	   $("#proposalidDIv").hide();
//	   $("#proposalidDIv").hide();
	   $("#subscriptionANDperpetualhideid").hide();
	   
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
        
 }else if (selectedValue === "Subscription & Perpetual") 
 { 
	   
	// alert("dgjb");
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


function getProposaldata(){
	
	$('#Subscriptionyear').val('');
	getProposalID();
}


function getProposaldata1(){
	
	$('#Perpetualyear').val('');
	getProposalID();
}

function proposalbaseddatashowedsubsANDperp()
{
	
	getProposalID();

}


function proposalIdAttachment(){
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getProposalIdAttachment";


	$.ajax({
		    type: 'POST',
		    url: serviceUrl,
		    dataType:'JSON',
		    data: 'proposalids=' + $('#proposalids').val()
  }).done(function(data) {
	  

////alert(data);

if ((data == "") || (data == "NA") || (data == "null"))
{
    $('#downHidepofile').hide();
    
} else {
	
    document.getElementById('vpuploadfileProposal').innerHTML = decodeURIComponent(data);
    document.getElementById('filenameStandard').value = decodeURIComponent(data);
    $('#poUploadDiv').show();
    
}
  
  });	
}








function submitFile() {

	$("#spinner").show();
	
	var l2 = window.location;
	var base_url2 = l2.protocol + "//" + l2.host + "/" + l2.pathname.split('/')[1];
	var serviceUrl2 = base_url2 + "/UserActivity/uploadInvoice";

	var formData = new FormData(form);
	 formData.append('srno', $('#tid').val());
	 
//	 var files = document.getElementById('invoicefile').files;
//		for (var i = 0; i < files.length; i++) {
//			formData.append('invoicefile', files[i]); 
//		}

	$.ajax({
		type : 'POST',
		url : serviceUrl2,
		data : formData,
		mimeType : "multipart/form-data",
		contentType : false,
		processData : false,
		cache : false,

	}).done(
			function(data) {
				$("#spinner").hide();
//				$('#spin').hide();
				// //alert("hgdjghd"+data)

//				let sts = data.split(',')[0].trim();
//				let poid = data.split(',')[1].trim();

				if (data === "success") {
					swal({
						title : "Successful!",
						 text: "Invoice Uploaded Successfully",
//						html : "PO ID = <br><br>   PO Raised Successfully",
						type : "success",
						width : 300,
						height : 200,
						// showCancelButton: !0,
						confirmButtonClass : "btn btn-success",
						// cancelButtonClass: "btn btn-danger m-l-10",
						confirmButtonText : "OK",
						preConfirm : function() {
							window.location.reload();
//							var l = window.location;
//							var base_url = l.protocol + "//" + l.host + "/"
//									+ l.pathname.split('/')[1];
//							window.location.href = base_url
//									+ "/User/ViewpoRaisedBySI";
						}
					});
				} else {
					swal({
						title : "Failed!",
						text : "Failed To Upload File",
						type : "error",
						width : 300,
						height : 200,
						buttons : false,
						allowOutsideClick : false,
					// preConfirm: function () {
					// var l = window.location;
					// var base_url = l.protocol + "//" + l.host + "/" +
					// l.pathname.split('/')[1];
					// window.location.href = base_url + "/User/PurchaseOrder";
					// }
					});
				}
			});

}



function advInvFile() {
	event.preventDefault();
	var filename1 = $('#filnameAdvinvoice').val();
	var filename = encodeURIComponent($('#filnameAdvinvoice').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	
	if(filename1.includes(",")) {
		window.location.href = base_url + "/Inventive/DownloadInvoiceFiles?filename=" + filename;
	} else {
		window.location.href = base_url + "/Inventive/DownloadInvoiceFile?filename=" + filename;
	}
	
}


