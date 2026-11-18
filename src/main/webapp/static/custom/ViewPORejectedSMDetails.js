


window.onload = function() {


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getPoRejectedDataSM";

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
							$('#downHidepofile').hide();
						} else {
							document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[0]);
							document.getElementById('filenameStandard').value = decodeURIComponent(aaa[0]);
							$('#poUploadDiv').show();
						}

						if ((decodeURIComponent(aaa[17]) === "File Not Attached")
								|| (decodeURIComponent(aaa[17]) === "NA")) {
							$('#downHideproposalfile').hide();
						} else {
							document.getElementById('proposalfile').innerHTML = decodeURIComponent(aaa[17]);
							document.getElementById('filnameProposal').value = decodeURIComponent(aaa[17]);
							$('#proposalUploadDiv').show();
						}
						
						
						
						if ((decodeURIComponent(aaa[19]) === "File Not Attached") || (decodeURIComponent(aaa[19]) === "NA")
								|| (decodeURIComponent(aaa[19]) === "") ) {
							$('#downHidemaskedPOfile').hide();
						} else {
							document.getElementById('maskedPOfile').innerHTML = decodeURIComponent(aaa[19]);
							document.getElementById('filnameMaskedPO').value = decodeURIComponent(aaa[19]);
							$('#maskedPOUploadDiv').show();
						}
						
						if ((decodeURIComponent(aaa[20]) === "File Not Attached") || (decodeURIComponent(aaa[20]) === "NA")
								|| (decodeURIComponent(aaa[20]) === "") ) {
							$('#downHideproductFeaturedfile').hide();
						} else {
							document.getElementById('productFeaturedFile').innerHTML = decodeURIComponent(aaa[20]);
							document.getElementById('filnameProductFeatured').value = decodeURIComponent(aaa[20]);
							$('#productFeaturedUploadDiv').show();
						}

						$('#potype').val(decodeURIComponent(aaa[1]));
						
						$('#ponumber').val(decodeURIComponent(aaa[2]));
						$('#podate').val(decodeURIComponent(aaa[3]));

						$('#proddescrip').val(decodeURIComponent(aaa[4]));
						$('#customername').val(decodeURIComponent(aaa[5]));
						$('#productSuit').val(decodeURIComponent(aaa[6]));
						$('#securityTools').val(decodeURIComponent(aaa[7]));
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
					
			
				
				


					});

}

function downFileStandard() {
	var filename = encodeURIComponent($('#filenameStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

function proposalStandard() {
	var filename = encodeURIComponent($('#filnameProposal').val());
	// //alert(filename);
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

function productFeaturedStandard() {
	var filename = $('#filnameProductFeatured').val();
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
