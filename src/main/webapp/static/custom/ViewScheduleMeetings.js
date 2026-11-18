window.onload = function() {
	$("#roomDiv").hide();
	$("#videoconfeDiv").hide();
	$("#meetlinkDiv").hide();
	

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getScheduleMeetingData";       // PMS/ViewUdPendingDetailsMD

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "crno=" + $('#crnoo').val()
			})
			.done(
					function(data) {
//						alert("daddadd"+data[0][0])

						$('#projectHead').val(decodeURIComponent(data[0][0]));
						$('#salesManager').val(decodeURIComponent(data[0][1]));
						$('#productManger').val(decodeURIComponent(data[0][2]));

						$('#subDate').val(decodeURIComponent(data[0][3]));
						$('#typeofMeeting').val(decodeURIComponent(data[0][4]));
						var meetype = decodeURIComponent(data[0][4]);
						if(meetype === "Virtual Mode")
							{
								
								$("#videoconfeDiv").show();
								$("#meetlinkDiv").show();
								$("#roomDiv").hide();
								
							}
						else{
							$("#roomDiv").show();
							$("#videoconfeDiv").hide();
							$("#meetlinkDiv").hide();
							
						}
							
						$('#typesofRoom').val(decodeURIComponent(data[0][5]));

						$('#vdoConf').val(decodeURIComponent(data[0][6]));
						$('#meetingLink').val(decodeURIComponent(data[0][8]));
						

						if ((decodeURIComponent(data[0][9]) == "File Not Attached")
								|| (decodeURIComponent(data[0][9]) == "NA")
								|| (decodeURIComponent(data[0][9]) == "null")) {
							$('#UdUploadDiv').hide();
						} else {
							document.getElementById('udUploadfile').innerHTML = decodeURIComponent(data[0][9]);
							document.getElementById('udFileStandard').value = decodeURIComponent(data[0][9]);
							$('#UdUploadDiv').show();
						}
					
						
						if ((decodeURIComponent(data[0][10]) == "File Not Attached")
								|| (decodeURIComponent(data[0][10]) == "NA")
								|| (decodeURIComponent(data[0][10]) == "null")) {
							$('#planUploadDiv').hide();
						} else {
							document.getElementById('planUploadfile').innerHTML = decodeURIComponent(data[0][10]);
							document.getElementById('planFileStandard1').value = decodeURIComponent(data[0][10]);
							$('#planUploadDiv').show();
						}
						
						
						
						
		
					});

}


function UDStandard() {
	event.preventDefault();
	var filename = encodeURIComponent($('#udFileStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}


function planupload() {
	
	event.preventDefault();
	var filename =encodeURIComponent($('#planFileStandard1').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}