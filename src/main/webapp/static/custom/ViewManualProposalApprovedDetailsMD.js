/**
 * 
 */

var subcategory = "";
var statusCI = "";


window.onload = function() {
	proposaltypedata();

	
	$('#SInoteDiv').hide();
	//	    $('#custom-tabs-one-home').hide();

	//subcategory = $('#subcategory1').val();
	statusCI = $('#statusCI').val();


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getManualProposalApprovedDataMD";

	$.ajax({
		url: serviceUrl,
		type: 'POST',
		dataType: 'json',
		data: "crno=" + $('#crnoo').val()
			+ '&tid=' + $("#tid").val()
	}).done(function(data) {

		var aaa = data[0];
		
		console.log(data);

		$('#poinitiator').val(decodeURIComponent(data[0][0]));
		$('#poinitiatorno').val(decodeURIComponent(data[0][1]));
		$('#FirstApprovername').val(decodeURIComponent(data[0][2]));
		$('#firstapprovercontact').val(decodeURIComponent(aaa[3]));
		$('#clientname').val(decodeURIComponent(aaa[6]));
		$('#Description').val(decodeURIComponent(aaa[7]));
		$('#Proposaltype').val(decodeURIComponent(aaa[9]));
        $('#enccustomername').val(decodeURIComponent(aaa[15]));
        $('#contactpersonname').val(decodeURIComponent(aaa[16]));
        $('#ATC').val(aaa[14]);
        $('#manualAmount').val(aaa[17]);

        if (decodeURIComponent(aaa[18]) === 'NA') {
			$('#SMnoteDiv').hide();
		} else {
			$('#SMnote').val(decodeURIComponent(aaa[18]));
			$('#SMnoteDiv').show();
		}
        
        if (decodeURIComponent(aaa[19]) === 'NA') {
			$('#MDnoteDiv').hide();
		} else {
			$('#MDnote').val(decodeURIComponent(aaa[19]));
			$('#MDnoteDiv').show();
		}
	
		if ((aaa[9] === "Perpetual")) {
			$('#perpetualhideid').show();
			$('#subscriptionhideid').hide();
			$('#fixedhideid').hide();
			$('#Perpetualyear').val(decodeURIComponent(aaa[10]));

			

		} else if ((aaa[9] === "Subscription")) {
			$('#subscriptionhideid').show();

			$('#hidereATCforamc').hide();
			$('#perpetualhideid').hide();
			$('#fixedhideid').hide();
			$('#Subscriptionyear').val(decodeURIComponent(aaa[11]));
		}else if ((aaa[9] === "Fixed")) {
			$('#fixedhideid').show();
			$('#subscriptionhideid').hide();
			$('#subscriptionhideid').hide();
			$('#fixedyear').val(decodeURIComponent(aaa[12]));

		
		} else if ((aaa[9] === "Subscription & Perpetual")) {
			$('#combinationSubsANDPerpHideDIv').show();
			
			$('#subscriptionhideid').hide();

			$('#hidereATCforamc').hide();
			$('#perpetualhideid').hide();
			$('#fixedhideid').hide();
			
			
		    $('#subscriptionANDperpetualhideid').show();
		 
		    $('#subscriptionANDperpetualYear').val(decodeURIComponent(aaa[12]));
		    
     
		}

	 
		if ((aaa[8] == "File Not Attached") || (aaa[8] == "NA") || (aaa[8] == "null")) {
			$('#downHidepofile').hide();
		} else {
			document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[8]);
			document.getElementById('filenameStandard').value = decodeURIComponent(aaa[8]);
			$('#poUploadDiv').show();
		}
		
		
		
		
		//26/06
		if ((aaa[20] === "Distributor")) {
			$('#proposalfor').val(aaa[20]);
			
			$('#partnernamehideid').show();
			$('#partnername').val(aaa[21]);
		}
		else if((aaa[20] === "NA")){
			$('#proposalfor').val("NA");
		}
		else{
			$('#partnernamehideid').hide();
		}
		
		 if ((aaa[20] === "Partner")) {
	        	$('#proposalfor').val(decodeURIComponent(aaa[20]));
	        	
	        	$('#hidePartnerName').hide();
		    
		    }else if((aaa[20] === "End customer")){
		    	$('#proposalfor').val(decodeURIComponent(aaa[20]));
		    	$('#hidePartnerName').hide();
		    	 
			}
		//
			    

	});

}




function proposaltypedata() {
	var selectedValue = $("#Proposaltype").val();

	var selectedperpetual = $("#Perpetualyear").val();
	var selectedSubscription = $("#Subscriptionyear").val();

	if (selectedValue === "Perpetual") {
		$("#perpetualhideid").show();
		$("#subscriptionhideid").hide();

		if (selectedperpetual === "3 year Warranty") {
			$("#secondandthirdyeatamchideid").show();
		}
		else if (selectedperpetual === "5 year Warranty") {
			$("#secondandthirdyeatamchideid").show();
			$("#fourAndfiveyearAmchideid").show();

		}

	} else if (selectedValue === "Subscription") {
		$("#subscriptionhideid").show();
		$("#perpetualhideid").hide();

		if (selectedSubscription === "3 year Subscription") {
			$("#secondandthirdyearSubshideid").show();

		}
		else if (selectedSubscription === "Annual Price") {
			$("#subscriptionhideid").show();
			$("#secondandthirdyearSubshideid").hide();
		}
	}
}
function downFileStandard() {
	var filename = encodeURIComponent($('#filenameStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename=" + filename;

}


function advInvFileStandard() {
	var filename = encodeURIComponent($('#filnameAdvinvoice').val());

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
		+ filename;

}


