window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/ViewUdApprovedByMD";       // PMS/ViewUdPendingDetailsMD

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "crno=" + $('#crnoo').val() + '&uid=' + $("#uid").val()
			})
			.done(
					function(data) {

						$('#udNumber').val(decodeURIComponent(data[0][0]));
						$('#rdNumber').val(decodeURIComponent(data[0][1]));
						$('#POnumber').val(decodeURIComponent(data[0][2]));

						$('#functionName').val(decodeURIComponent(data[0][3]));
						$('#prodSuite').val(decodeURIComponent(data[0][4]));
						$('#securityTool').val(decodeURIComponent(data[0][5]));

						$('#prodManager').val(decodeURIComponent(data[0][6]));
						$('#teamLeader').val(decodeURIComponent(data[0][7]));
						$('#developer').val(decodeURIComponent(data[0][8]));

						$('#submittedBy').val(decodeURIComponent(data[0][9]));
						$('#submitDate').val(decodeURIComponent(data[0][10]));
						$('#udNote').val(decodeURIComponent(data[0][11]));

						if ((decodeURIComponent(data[0][12]) == "File Not Attached")
								|| (decodeURIComponent(data[0][12]) == "NA")
								|| (decodeURIComponent(data[0][12]) == "null")) {
							$('#UdUploadDiv').hide();
						} else {
							document.getElementById('udUploadfile').innerHTML = decodeURIComponent(data[0][12]);
							document.getElementById('udFileStandard').value = decodeURIComponent(data[0][12]);
							$('#UdUploadDiv').show();
						}
						
						$('#projectDesc').val(decodeURIComponent(data[0][14]));
						$('#projectObj').val(decodeURIComponent(data[0][15]));
						$('#projectScope').val(decodeURIComponent(data[0][16]));
						
						$('#funcReq').val(decodeURIComponent(data[0][17]));
						$('#nonFuncReq').val(decodeURIComponent(data[0][18]));
						$('#techReq').val(decodeURIComponent(data[0][19]));
						
						$('#startDate').val(decodeURIComponent(data[0][20]));
						$('#endDate').val(decodeURIComponent(data[0][21]));
						if ((decodeURIComponent(data[0][22]) == "File Not Attached")
								|| (decodeURIComponent(data[0][22]) == "NA")
								|| (decodeURIComponent(data[0][22]) == "null")) {
							$('#otherFileDiv').hide();
						} else {
							document.getElementById('otherFile').innerHTML = decodeURIComponent(data[0][22]);
							document.getElementById('otherFileStandard').value = decodeURIComponent(data[0][22]);
							$('#otherFileDiv').show();
						}
						
						
					});

}


function UDStandard() {
	var filename = encodeURIComponent($('#udFileStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}


function OtherUDStandard() {
	event.preventDefault();
	var filename = encodeURIComponent($('#otherFileStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="+ filename;
}