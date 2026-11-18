
var roleType= $("#role").val();

if(roleType ==="Support_Manager" || roleType ==="Support") {
	$("#SupportStatusDiv").show();
	$("#patchURLDiv").show();
	$("#updateTask").show();
	
} else {
	
	$("#fStatus").show();

}


window.onload = function() {
	
	$('#taskNo').text($('#crnoo').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/PMS/getCustomTaskDetails";
	var serviceUrl = base_url + "/PMS/getCustomTaskTestingDetails";

	$.ajax({
		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : "crno=" + $('#crnoo').val()
	}).done(function(data) {
		console.log(data);
//		alert("t details " + data)
//		console.log(data);
//		alert(data[0][11]);
		
		$('#customer_name').val(data[0] ? decodeURIComponent(data[0]) : 'NA');
		$('#suit_name').val(data[1] ? decodeURIComponent(data[1]) : 'NA');
		$('#product_name').val(data[2] ? decodeURIComponent(data[2]) : 'NA');
		$('#Manager_Name').val(decodeURIComponent(data[3]));
		$('#Team_Leader').val(decodeURIComponent(data[4]));
		$('#ReportedBy').val(decodeURIComponent(data[5]));
	
		$('#Developer').val(decodeURIComponent(data[6]));
		$('#reportedDate').val(decodeURIComponent(data[7]));
		$('#End_Date').val(decodeURIComponent(data[8]));
		$('#Task_Priority').val(data[9] ? decodeURIComponent(data[9]) : 'NA');
		
		$('#Module_Name').val(decodeURIComponent(data[10]));
		$('#Description').val(data[11] ? decodeURIComponent(data[11]) : 'NA');
		$('#ExpectedOutput').val(data[12] ? decodeURIComponent(data[12]) : 'NA');
		$('#Status').val(decodeURIComponent(data[13]));
		$('#fStatus').val(decodeURIComponent(data[13]));
		$('#testerDescription').val(data[15] ? decodeURIComponent(data[15]) : 'NA');
		$('#testerName').val(decodeURIComponent(data[16]));
		$('#assignedForTestingDate').val(decodeURIComponent(data[17]));
		$('#patchURL').val(decodeURIComponent(data[18]));

	});
}


function changeStatus(Status) {
	if(Status === "Re-Open") {
		$('#reopenReasonDiv').show();
	} else {
		$('#reopenReasonDiv').hide();
	}
		callToolTip231('Status', 'hide');
		callToolTip231('SStatus', 'hide');
		
		
		

}


function validateTaskData() {
	var indexError = 0;

	if (roleType === "Tester") {
		if ($('#Status').val().trim() === 'Developed' || $('#Status').val().trim() === '') {
			callToolTip231('Status', 'show');
			if (indexError == 0) {
			}
			indexError = indexError + 1;
		}
	} else {
		if ($('#SStatus').val().trim() === 'Ready to Deliver' || $('#SStatus').val().trim() === '') {
			callToolTip231('SStatus', 'show');
			if (indexError == 0) {
			}
			indexError = indexError + 1;
		}
		
		if ($('#SStatus').val().trim() === 'Re-Open' && $('#reopenReason').val().trim() === '') {
			callToolTip231('reopenReason', 'show');
			if (indexError == 0) {
			}
			indexError = indexError + 1;
		}
	}

	if (indexError > 0) {
		return false;
	} else {
		return true;
	}
}


$('#Status').on('focus', function() {
    callToolTip231('Status', 'destroy');
});

$('#SStatus').on('focus', function() {
    callToolTip231('Status', 'destroy');
});



var callToolTip231 = function(fieldName, status) {

	if (fieldName == 'Status' && roleType === "Tester" ) {
     	var errorMessage = "<span>Please Mark Status as Ready to Deliver <span>";
     }
	
	if (fieldName == 'SStatus' && (roleType === "Support_Manager" || roleType === "Support") ) {
     	var errorMessage = "<span>Please Mark Status as Close/Re-Open/On Hold <span>";
     }
	
	if (fieldName == 'reopenReason' && (roleType === "Support_Manager"|| roleType === "Support") ) {
     	var errorMessage = "<span>Please Add Reason <span>";
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











// 06/06
function updateTaskStatus() {
	
	if(!validateTaskData() ){
		event.preventDefault();
	} else {
		
		$('#spin1').show();

	
    swal({
        title: "Are you sure?",
        text: "You want to Update Status?",
        type: "warning",
        width: 350,
        height: 200,
        showCancelButton: !0,
        confirmButtonClass: "btn btn-success",
        cancelButtonClass: "btn btn-danger m-l-10",
        confirmButtonText: "Yes, Update it!"
    }).then(function() {
        var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//        var serviceUrl = base_url + "/PMS/updateCustomTaskStatus";
        var serviceUrl = base_url + "/PMS/updateCustomTestingTaskStatus";
        
        $('#spin1').show();
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: "crno=" + $('#crnoo').val() + 
                "&Status=" + $('#SStatus').val() + "&reopenReason=" + $('#reopenReason').val(),
        }).done(function(data) {
            $('#spin1').hide();
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Status Updated Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        if(roleType === "Support_Manager" || roleType === "Support") {
                        	 window.location.href = base_url + "/Admin/addCustomizationTask";
                        } else {
                        	window.location.href = base_url + "/Admin/MyCustomizationTask";
                        }
                        
                    }
                });
            }else if (data == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to Update",
                    type: "error",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        
                        if(roleType === "Support_Manager" || roleType === "Support") {
                       	 window.location.href = base_url + "/Admin/ViewAllCustomizationTask";
                       } else {
                       	window.location.href = base_url + "/Admin/ViewMyCutomizationTask";
                       }
                    }
                });
            }else if (data == "pendingerror") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to Update, Mark Status as Completed",
                    type: "error",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        if(roleType === "Support_Manager") {
                          	 window.location.href = base_url + "/Admin/ViewAllCustomizationTask";
                          } else {
                          	window.location.href = base_url + "/Admin/ViewMyCutomizationTask";
                          }
                    }
                });
            }
        });
    });
    
    
	}
}


//


function updateModifyDate() {
	
    swal({
        title: "Are you sure?",
        text: "You want to Extend Date?",
        type: "warning",
        width: 350,
        height: 200,
        showCancelButton: !0,
        confirmButtonClass: "btn btn-success",
        cancelButtonClass: "btn btn-danger m-l-10",
        confirmButtonText: "Yes, Extend it!"
    }).then(function() {
      
    	 var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/PMS/updateModifyDate";
   	 $('#spin2').show();
   	 $.ajax({
   			            type: 'POST',
   			            url: serviceUrl,
   			            data: "crno=" + $('#crnoo').val() + "&tid=" + $('#tid').val()
   						+ "&Status=" + $('#Status').val() + "&Remark="
   						+ $('#Remark').val() + "&End_Date=" +$("#End_Date").val(),
   						
        }).done(function(data) {        
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Added Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/Activitydetails";
                    }

                });

            }

            else if (data == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to delete file",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/Activitydetails";
                    }

                });

              }
        });
    });
  
	
}



//function updateModifyDate1() {
////	alert("KJJJJJJJJJJJJ")
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/PMS/updateModifyDate";
//	 $('#spin2').show();
//	 $.ajax({
//			            type: 'POST',
//			            url: serviceUrl,
//			            data: "crno=" + $('#crnoo').val() + "&tid=" + $('#tid').val()
//						+ "&Status=" + $('#Status').val() + "&Remark="
//						+ $('#Remark').val() + "&End_Date=" +$("#End_Date").val(),
//						
//			        }).done(function(data) {
//			        	$('#spin2').hide();
//			          
//			            if (data == "success") {
//			                swal({
//			                    title: "Successful!",
//			                    text: "Status Updated Successfully",
//			                    type: "success",
//			                    width: 300,
//			                    height: 200,
//			                    buttons: false,
//			                    allowOutsideClick: false,
//			                    preConfirm: function() {
//			                        var l = window.location;
//			                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			                        window.location.href = base_url + "/Admin/Activitydetails";
//			                    }
//
//			                });
//
//			            }
//			             else if (data == "duplicate") {
//			                swal({
//			                    title: "Duplicate Data!",
//			                    text: "Record Already Exists",
//			                    type: "warning",
//			                    width: 300,
//			                    height: 200,
//			                    buttons: false,
//			                    allowOutsideClick: false,
//			                    preConfirm: function() {
//			                        var l = window.location;
//			                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			                        window.location.href = base_url + "/Admin/Activitydetails";
//			                    }
//
//			                });
//
//			              }
//			            else if (data == "error") {
//			                swal({
//			                    title: "Unsuccessful!",
//			                    text: "Fail to add file",
//			                    type: "success",
//			                    width: 300,
//			                    height: 200,
////			           		 showCancelButton: false,
////			                  confirmButtonClass: "btn btn-danger",
////			                  cancelButtonClass: "btn btn-danger m-l-10",
////			                  confirmButtonText: "OK",
//			                    buttons: false,
//			                    allowOutsideClick: false,
//			                    preConfirm: function() {
//			                        var l = window.location;
//			                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			                        window.location.href = base_url + "/Admin/Activitydetails";
//			                    }
//
//			                });
//
//			              }
//			        });
//}

