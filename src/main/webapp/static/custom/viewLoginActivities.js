
var TStatus = "Completed";

window.onload = function() {}


//15/06
function validateUploadFile() {
    var indexError = 0;

    if ($('#selectType2').val().trim() === '') {
        callToolTip231('selectType2', 'show');
        if (indexError == 0) {
            // Additional logic can be placed here if needed
        }
        indexError = indexError + 1;
    }
    if ($('#selecttype').val().trim() === '') {
        callToolTip231('selecttype', 'show');
        if (indexError == 0) {
            // Additional logic can be placed here if needed
        }
        indexError = indexError + 1;
    }
    if ($('#fromDate').val().trim() === '' && $('#fromDate').is(':visible')) {
        callToolTip231('fromDate', 'show');
        if (indexError == 0) {
            // Additional logic can be placed here if needed
        }
        indexError = indexError + 1;
    }
    if ($('#toDate').val().trim() === '' && $('#toDate').is(':visible')) {
        callToolTip231('toDate', 'show');
        if (indexError == 0) {
            // Additional logic can be placed here if needed
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
    var errorMessage = "";

    if (fieldName == "selectType2") {
        errorMessage = "<span>Select Type</span>";
    }
    if (fieldName == "selecttype") {
        errorMessage = "<span>Select Role</span>";
    }
    if (fieldName == "fromDate") {
        errorMessage = "<span>Select Start Date</span>";
    }
    if (fieldName == "toDate") {
        errorMessage = "<span>Select End Date</span>";
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
};

$('#selectType2').on('focus', function() {
    callToolTip231('selectType2', 'destroy');
});
$('#selecttype').on('focus', function() {
    callToolTip231('selecttype', 'destroy');
});
$('#fromDate').on('focus', function() {
    callToolTip231('fromDate', 'destroy');
});
$('#toDate').on('focus', function() {
    callToolTip231('toDate', 'destroy');
});



$("#submit-btn").click(function () {
	
    if (!validateUploadFile()) {
    	
        event.preventDefault();
      
    } else {
    	getLoginActivities();
        // Additional logic can be placed here if needed
    }
});






$("#resetbtn").click(function() {

	$("#dataCard").hide();
	 $('#ActivityTable').DataTable().destroy();
	
	callToolTip231('fromDate', 'destroy');
	callToolTip231('toDate', 'destroy');
	callToolTip231('selecttype', 'destroy');
	callToolTip231('selectType2', 'destroy');
	$("#fromDate").val('').trigger('change');
	$("#toDate").val('').trigger('change');
	$("#selecttype").val('').trigger('change');
	$("#selectType2").val('').trigger('change');

});
	
//






//13/06
function getLoginActivities() {
//    var momentAdb = moment($('#fromDate').val(), "DD-MM-YYYY");
//    var momentBcd = moment($('#toDate').val(), "DD-MM-YYYY");
//
//    fromDateTrack = $('#fromDate').val();   
//    toDateTrack = $('#toDate').val();
//    
//    if (momentAdb > momentBcd) {
//        swal({
//            title: "Warning",
//            text: "Warranty End Date should be Greater than Start Date!",
//            type: "warning",
//            width: 300,
//            allowOutsideClick: false
//        });
//        return false;
//    } else {
    	
        var requestData = {
//            fromDate: $('#fromDate').val(),
//            toDate: $('#toDate').val(),
            selecttype: $('#selecttype').val(),
            selectType2: $('#selectType2').val()
        };
        
        var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        var serviceUrl = base_url + "/UserActivity/trackLoginActivityDetails";
        $("#spin11").show();
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            data: requestData,
            success: function(data) {
//                alert("data "+data);
                var responseData = data;
                $("#spin11").hide();
                console.log(data);
                if (data.length < 1) {
                    swal({
                        title: "Warning",
                        text: "Data Not Available for this Details!",
                        type: "warning",
                        width: 300,
                        height: 200,
                        buttons: false,
                        allowOutsideClick: false,
                        preConfirm: function() {
                            var l = window.location;
                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                            window.location.href = base_url + "/Admin/viewLoginActivities";
                        }
                    });
                } else {

                	$("#dataCard").show();
                	 $('#ActivityTable').DataTable().destroy();
                	 $('#ActivityTable tbody').empty();
                	  
                    var table = $('#ActivityTable').DataTable({
                        lengthChange: false,
                        pageLength: 5,
                        data: data,
                        scrollX: '300px',
                        dom: 'Bfrtip', // Add this line to enable export buttons
                        buttons: [{
                            extend: 'pdfHtml5',
                            exportOptions: {
                                columns: ':visible' // Only export visible columns
                            },
                            customize: function(doc) {
                                doc.pageOrientation = 'landscape'; // or 'landscape'
                                doc.pageSize = 'A4'; // Customization code here
                            }
                        },
                        'excel',
                        'print'
                        ]
                    });
                }
            }
        });
//    }
}







function TrackType() {
	var selectedType = $("#selectType2").val();

	if(selectedType ==="With Date") {
		$("#DatesDiv").show();
	} else {
		$("#DatesDiv").hide();
	}
	}


function DevCompletedTaskDetails(crno , tid)
{
//	alert("hih")
	 	var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    window.location.href = base_url + "/PMS/ViewMyTaskDetails?crno="+crno+"&tid="+tid;   
	    window.location.href = base_url + "/PMS/ViewCompletedTaskDetails?crno="+crno;
	    
}