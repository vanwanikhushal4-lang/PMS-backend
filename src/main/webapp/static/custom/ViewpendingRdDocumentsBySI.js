

//  alert("rd id "+$("#uid").val());

function scopefileDownload() {
	event.preventDefault();
	var filename = encodeURIComponent($('#downHidescopefile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}


function RFPfileDownload() {
	event.preventDefault();
	var filename = encodeURIComponent($('#downHideRFPfile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

function otherfileDownload() {
	event.preventDefault();
	var filename = encodeURIComponent($('#downHideotherfile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

window.onload = function() {
	$('#downHidemaskedfile').hide();
	
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getselectrddetails";
	    var selectedValue1 = $("#uid").val(); // Get the currently
//		alert("selectedValue1"+selectedValue1)												// selected value

	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'selectrddetails=' + selectedValue1,      // $("#documentType2").val(),
	        success: function(data1) {
	       // 	alert("ggggggggg"+data1)
	        	
	        	var aaa = data1[0];
		//		alert("sf"+aaa)
//				alert("AAAAA data::::::"+aaa)
//				alert("1212121"+aaa)
	        	$('#documentType5').val(decodeURIComponent(aaa[4]));
				$('#documentType2').val(decodeURIComponent(aaa[0]));
//				alert("po number"+aaa[0][3])
				$('#documentType3').val(decodeURIComponent(aaa[1]));
				$('#documentType1').val(decodeURIComponent(aaa[2]));
				$('#documentType4').val(decodeURIComponent(aaa[3]));
				$('#noteType').val(decodeURIComponent(aaa[5]));
				
//				alert("Po File::: "+aaa[0][8])
				
				if ((decodeURIComponent(aaa[6]) == "File Not Attached")
						|| (decodeURIComponent(aaa[6]) == "NA")
						|| (decodeURIComponent(aaa[6]) == "null")) {
					$('#rdUploadDiv').hide();
				} else {
					document.getElementById('rduploadfile').innerHTML = decodeURIComponent(aaa[6]);
					document.getElementById('filenameStandard').value = decodeURIComponent(aaa[6]);
					$('#rdUploadDiv').show();
				}
				
				if ((decodeURIComponent(aaa[7]) == "File Not Attached")
						|| (decodeURIComponent(aaa[7]) == "NA")
						|| (decodeURIComponent(aaa[7]) == "null")|| (decodeURIComponent(aaa[7]) == "")) {
					$('#downHidemaskedfile').hide();
				} else {
					document.getElementById('maskeduploadfile').innerHTML = decodeURIComponent(aaa[7]);
					document.getElementById('masekdfileStandard').value = decodeURIComponent(aaa[7]);
					$('#downHidemaskedfile').show();
				}
				
				if ((decodeURIComponent(aaa[8]) == "File Not Attached")
						|| (decodeURIComponent(aaa[8]) == "NA")
						|| (decodeURIComponent(aaa[8]) == "null")|| (decodeURIComponent(aaa[8]) == "")) {
					$('#scopeUploadDiv').hide();
				} else {
					document.getElementById('scopeuploadfile').innerHTML = decodeURIComponent(aaa[8]);
					document.getElementById('downHidescopefile').value = decodeURIComponent(aaa[8]);
					$('#scopeUploadDiv').show();
				}
				
				if ((decodeURIComponent(aaa[9]) == "File Not Attached")
						|| (decodeURIComponent(aaa[9]) == "NA")
						|| (decodeURIComponent(aaa[9]) == "null")|| (decodeURIComponent(aaa[9]) == "")) {
					$('#RFPUploadDiv').hide();
				} else {
					document.getElementById('RFPuploadfile').innerHTML = decodeURIComponent(aaa[9]);
					document.getElementById('downHideRFPfile').value = decodeURIComponent(aaa[9]);
					$('#RFPUploadDiv').show();
				}
				
				if ((decodeURIComponent(aaa[10]) == "File Not Attached")
						|| (decodeURIComponent(aaa[10]) == "NA")
						|| (decodeURIComponent(aaa[10]) == "null")|| (decodeURIComponent(aaa[10]) == "")) {
					$('#otherUploadDiv').hide();
				} else {
					document.getElementById('otheruploadfile').innerHTML = decodeURIComponent(aaa[10]);
					document.getElementById('downHideotherfile').value = decodeURIComponent(aaa[10]);
					$('#otherUploadDiv').show();
				}
				
				
				
				

	   //         $("#Securitytool").val(data1); // Update the select element

	        }
	    });
	
	
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/PMS/ViewRdPendingDetailsMD";
//
//	$
//			.ajax({
//				url : serviceUrl,
//				type : 'POST',
//				dataType : 'json',
//				data : "crno=" + $('#crnoo').val() + '&uid=' + $("#uid").val()
//			})
//			.done(
//					function(data) {
//						
//						console.log(data)
//
//						$('#functionName').val(decodeURIComponent(data[0][0]));
//						$('#designation').val(decodeURIComponent(data[0][1]));
//						$('#username').val(decodeURIComponent(data[0][2]));
//						$('#userid').val(decodeURIComponent(data[0][3]));
//						$('#description').val(decodeURIComponent(data[0][4]));
//    
//						});
//    
    
}

$("#approveMD").click(
		function() {
			


			$('#spin1').show();

			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/"
					+ l.pathname.split('/')[1];
			var serviceUrl = base_url
					+ "/PMS/ApproveRdDetailsBySI";
				
			
			
			
			$.ajax(
					{
						url : serviceUrl,
						type : 'POST',
						data : "crno=" + $('#crnoo').val(),
						
					}).done(
					function(data) {
					
						$('#spin1').hide();
						if (data === "success") {
							swal({
								title : "Successful!",
								text : "RD Approved Successfully",
								type : "success",
								width : 300,
								height : 200,
								confirmButtonClass : "btn btn-success",
								cancelButtonClass : "btn btn-danger m-l-10",
								confirmButtonText : "OK",
								preConfirm : function() {
									var l = window.location;
									var base_url = l.protocol + "//" + l.host
											+ "/" + l.pathname.split('/')[1];
									window.location.href = base_url
											+ "/Admin/pendingRdDocumentsBySI";
								}
							})
						} else {
							swal({
								title : "Fail!",
								text : "RD Approved UnSuccessful",
								type : "error",
								width : 300,
								height : 200,
								// showCancelButton: !0,
								confirmButtonClass : "btn btn-success",
								cancelButtonClass : "btn btn-danger m-l-10",
								confirmButtonText : "OK",
								preConfirm : function() {
									var l = window.location;
									var base_url = l.protocol + "//" + l.host
											+ "/" + l.pathname.split('/')[1];
									window.location.href = base_url
											+ "/Admin/pendingRdDocumentsBySI";
								}

							})
						}

					});
		
		});



// get Masked PO File
//var l = window.location;
//var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//var serviceUrl = base_url + "/PMS/getMaskedPOFile";
//var selectedValue4 = $("#poNumber").val(); // Get the currently
//												// selected value
//// alert("pooo:::::::::: "+selectedValue3)
//$.ajax({
//    type: 'POST',
//    url: serviceUrl,
//    dataType: 'json',
//    data: 'poID=' + selectedValue4,      
//    success: function(data1) {
//    	alert(data1)
//    	
//    	if ((decodeURIComponent(data1) === "File Not Attached") || (decodeURIComponent(data1) === "NA")
//		|| (decodeURIComponent(data1) === "") ) {
//    	//	$('#downHidemaskedPOfile').hide();
//    	} else {
//    		document.getElementById('maskedPOfile').innerHTML = decodeURIComponent(data1);
//    		document.getElementById('filnameMaskedPO').value = decodeURIComponent(data1);
//    		$('#maskedPOUploadDiv').show();
//    	}  
//
//    }
//});


function downFileStandard() {
	
//	alert("download")
	var filename = encodeURIComponent($('#filenameStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="+ filename;

}


function maskedPOStandard() {
	var filename = encodeURIComponent($('#masekdfileStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}
