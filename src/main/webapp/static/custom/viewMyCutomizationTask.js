
var roleType= $("#role").val();


window.onload = function() {
	
	$('#taskNo').text($('#crnoo').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/PMS/getDevAssignedTaskDetails";
	var serviceUrl = base_url + "/PMS/getCustomTaskDetails";

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
	
		if(data[13] === "Assigned") { 
			$('#StatusAssigned').show();
		
		} else if(data[13] === "Re-Open") { 
			$('#StatusReOpen').show();
			$('#reopenReasonDiv').show();
			$('#reopenReasonDiv').show();
			$('#reopenReason').val(decodeURIComponent(data[14]));
		}

	});
}


function changeStatus(Status) {
	
	if(Status === "Developed") {
	
//	var html = "";
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTesterList";
//
//	$.ajax({
//		type : 'POST',
//		url : serviceUrl,
//		dataType : 'json',
//		success : function(data4) {
//
//			html = "<option value=''>-- Please Select --</option><option value='Self'>Self</option>";
//			for (var i = 0; i < data4.length; i++) {
//				var value = data4[i];
//				html += '<option value="' + value + '">' + value + '</option>';
//			}
////			$("#testerName").html(html); // Update the select element
//		}
//	}); 
//	
//	
//	var l = window.location;
//	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	  var serviceUrl = base_url + "/PMS/getAllDeveloperList";
//
//	  $.ajax({
//	      type: 'POST',
//	      url: serviceUrl,
//	      dataType: 'json',
//	      success: function(data4) {
//
////	          var html = "<option value=''>-- Please Select --</option>";
//	          for (var i = 0; i < data4.length; i++) {
//	              var value = data4[i];
//	              html += '<option value="' + value + '">' + value + '</option>';
//	          }
//	          $("#testerName").html(html);
//	         }
//	  });	
	  
		
		
		var html = "<option value=''>-- Please Select --</option><option value='Self'>Self</option>"; // Initialize dropdown with default options

		// Get base URL
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];

		// Fetch Tester Name List
		var testerUrl = base_url + "/Master/getTesterList";
		$.ajax({
		    type: 'POST',
		    url: testerUrl,
		    dataType: 'json',
		    success: function(data4) {
		        // Append Tester options to dropdown
		        for (var i = 0; i < data4.length; i++) {
		            var value = data4[i];
		            html += '<option value="' + value + '">' + value + '</option>';
		        }
		        // Now fetch Developer list
		        var developerUrl = base_url + "/PMS/getAllDeveloperList";
		        $.ajax({
		            type: 'POST',
		            url: developerUrl,
		            dataType: 'json',
		            success: function(data4) {
		                // Append Developer options to dropdown
		                for (var i = 0; i < data4.length; i++) {
		                    var value = data4[i];
		                    html += '<option value="' + value + '">' + value + '</option>';
		                }
		                // Finally, update the dropdown
		                $("#testerName").html(html);
		            },
		            error: function() {
		                console.error("Error fetching developer list");
		            }
		        });
		    },
		    error: function() {
		        console.error("Error fetching tester list");
		    }
		});

	  
	
	$("#testerDiv").show();
	$("#testerDescDiv").show();
//	callToolTip231('testerName', 'hide');
	callToolTip231('Status', 'hide');
	} else {

		$("#testerDiv").hide();
		$("#testerDescDiv").hide();
		$('#testerName').val(""); 
		$('#testerDescription').val(""); 
		
		callToolTip231('testerName', 'hide');
		callToolTip231('Status', 'hide');

	}
}


function validateTaskData() {
	var indexError = 0;

	if($('#Status').val().trim() === 'Developed') {
	if ($('#testerName').val().trim() === '') {
		callToolTip231('testerName', 'show');
		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
} else{
	if ($('#Status').val().trim() === 'Assigned' || $('#Status').val().trim() === 'Re-Open' || $('#Status').val().trim() === '') {
		callToolTip231('Status', 'show');
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

$('#testerName').on('focus', function() {
    callToolTip231('testerName', 'destroy');
});

$('#Status').on('focus', function() {
    callToolTip231('Status', 'destroy');
});


var callToolTip231 = function(fieldName, status) {

    if (fieldName == 'testerName') {
     	var errorMessage = "<span>Please Select Tester Name <span>";
     } else if (fieldName == 'Status') {
     	var errorMessage = "<span>Please Mark Status as Developed <span>";
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
//        var serviceUrl = base_url + "/PMS/updateTaskStatus";
        var serviceUrl = base_url + "/PMS/updateCustomTaskStatus";
        
        $('#spin1').show();
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: "crno=" + $('#crnoo').val() + 
                "&Status=" + $('#Status').val() + "&testerName=" + $('#testerName').val()+ "&testerDescription=" + $('#testerDescription').val(),
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
                        window.location.href = base_url + "/Admin/MyCustomizationTask";
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
                        window.location.href = base_url + "/PMS/ViewMyCutomizationTask";
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
                        window.location.href = base_url + "/PMS/ViewMyCutomizationTask";
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

