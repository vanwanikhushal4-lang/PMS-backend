/**
 * 
 */

var subcategory = "";
var statusCI = "";


window.onload = function() {

	$('.nav-tabs a').click(function() {
		$(this).tab('show');
	});


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getProposalLicenseApprovedDataSM";

	$.ajax({
		url: serviceUrl,
		type: 'POST',
		dataType: 'json',
		data: "crno=" + $('#crnoo').val()
			+ '&tid=' + $("#tid").val()
	}).done(function(data) {

		var aaa = data[0];
		
		console.log(data);

		$('#clientname').val(decodeURIComponent(data[0][0]));
		$('#clientAddress').val(decodeURIComponent(data[0][1]));
		$('#EnvironmentKeyNo').val(decodeURIComponent(data[0][2]));
		$('#ponumber').val(decodeURIComponent(data[0][3]));
		$('#podate').val(decodeURIComponent(data[0][4]));
		$('#endcostomername').val(decodeURIComponent(data[0][5]));
$('#endCustomerEmail').val(decodeURIComponent(data[0][6]));
		
		
		$('#paymentReceived').val(decodeURIComponent(data[0][10]));
		
		
		if ((aaa[7] == "File Not Attached") || (aaa[7] == "NA") || (aaa[7] == "null")) {
			$('#downHidepofile').hide();
		} else {
			document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[7]);
			document.getElementById('filenameStandard').value = decodeURIComponent(aaa[7]);
			$('#poUploadDiv').show();
		}

         $('#viewdataLicenseCreatedTable').show();
			var table = $('#viewdataLicenseCreatedTable').DataTable({
				lengthChange: false,
				pageLength: 5,
				data: aaa[8],
				dataType: 'json',
				scrollX: '300px',
			});

			
			
			if (decodeURIComponent(aaa[9]) === 'NA') {
				$('#SMnoteDiv').hide();
			} else {
				$('#SMnote').val(decodeURIComponent(aaa[8]));
				$('#SMnoteDiv').show();
			}

	});

}


function downFileStandard() {
	var filename = encodeURIComponent($('#filenameStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename=" + filename;

}





function advInvFileStandard() {
	var filename = $('#filnameAdvinvoice').val();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
		+ filename;

}


