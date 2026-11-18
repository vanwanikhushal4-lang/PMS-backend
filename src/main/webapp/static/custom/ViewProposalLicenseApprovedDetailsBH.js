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
	var serviceUrl = base_url + "/UserActivity/getProposalLicenseApprovedDataBH";

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
		
		
		$('#paymentReceived').val(decodeURIComponent(data[0][11]));
		
		
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
				$('#SMnote').val(decodeURIComponent(aaa[9]));
				$('#SMnoteDiv').show();
			}
			
			if (decodeURIComponent(aaa[10]) === 'NA') {
				$('#BHnoteDiv').hide();
			} else {
				$('#BHnote').val(decodeURIComponent(aaa[10]));
				$('#BHnoteDiv').show();
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

$("#ApproveCM").click(function () {

//	alert("dkukh"+$('#endCustomerEmail').val())

    $('#spin11').show();
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/SendMailwithattachment";
    
    $.ajax({
        url: serviceUrl, 
        type: 'POST',
        data: "crno=" + $('#crnoo').val()
            + "&tid=" + $('#tid').val()
            + "&clientname=" + $('#clientname').val()
            + "&EnvironmentKeyNo=" + $('#EnvironmentKeyNo').val()
            + "&ponumber=" + $('#ponumber').val()
            + "&filenameStandard=" + $('#filenameStandard').val()
            + "&endCustomerEmail=" + $('#endCustomerEmail').val()
            + "&podate=" + $('#podate').val()
            + "&distributorEmail=" + $('#distributorEmail').val()
            + "&partnerEmail=" + $('#partnerEmail').val()
            + "&linkForEmail=" + $('#linkForEmail').val(),
            
              
    }).done(function (data) {
//    	alert("datata"+data)
        $('#spin11').hide();
        if (data === "Success")
        {
            swal({
                title: "Successful!",
                text: "Mail Send Successfully",
                type: "success",
                width: 300,
                height: 200,
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger m-l-10",
                confirmButtonText: "OK",
                preConfirm: function () {
                    var l = window.location;
                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                    window.location.href = base_url + "/User/ApprovedProposalLicenseDetailsBH";
                }
            })
        } else
        {
            swal({
                title: "Fail!",
//                html ="File Not Attached <br> Mail Send UnSuccessful",
//                text: "File Not Attached\nMail Send UnSuccessful",
                html: "File Not Attached<br>Mail Send UnSuccessful",
                type: "error",
                width: 300,
                height: 200,
                // showCancelButton: !0,
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger m-l-10",
                confirmButtonText: "OK",
                preConfirm: function () {
                    var l = window.location;
                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                    window.location.href = base_url + "/User/ApprovedProposalLicenseDetailsBH";
                    
                    
                }

            })
        }


    });
});


function validateUploadFile() {
	
	indexError = 0;

	if ($('#manualProposalFile').val().trim() === '') {
	        callToolTip231('manualProposalFile', 'show');
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

var callToolTip231 = function(fieldName, status) {

	  
    if (fieldName == "manualProposalFile") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select License File<span>";
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

$('#manualProposalFile').on('focus', function() {
    callToolTip231('manualProposalFile', 'destroy');
    
});


$("#uploadfile").click(function () {

//	alert("dkukh"+ $('#crnoo').val())
//	alert("dkukh"+ $('#tid').val())
			if (!validateUploadFile()) {
				 
			event.preventDefault();
				
			} else {
	
	
	

    $('#spin1').show();
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/saveupload";
    
 	
 	var formData = new FormData(form);

 	formData.append('crno', $('#crnoo').val());
 	formData.append('tid', $('#tid').val());
    $.ajax({
        url: serviceUrl, 
        type: 'POST',
        data:formData,
        mimeType: "multipart/form-data",
        contentType: false,
        processData: false,
        cache: false,
          
              
    }).done(function (data) {
//    	alert("data"+data)
        $('#spin1').hide();
        if (data === "success")
        {
            swal({
                title: "Successful!",
                text: "File Upload Successfully",
                type: "success",
                width: 300,
                height: 200,
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger m-l-10",
                confirmButtonText: "OK",
//                preConfirm: function () {
//                    var l = window.location;
//                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                    window.location.href = base_url + "/User/ViewProposalLicenseApprovedDetailsBH";
//                }
            })
        } else
        {
            swal({
                title: "Fail!",
                text: "File Upload UnSuccessful",
                type: "error",
                width: 300,
                height: 200,
                // showCancelButton: !0,
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger m-l-10",
                confirmButtonText: "OK",
                preConfirm: function () {
                    var l = window.location;
                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                    window.location.href = base_url + "/User/ViewProposalLicenseApprovedDetailsBH";
                    
                    
                }

            })
        }


    });

			}	
});