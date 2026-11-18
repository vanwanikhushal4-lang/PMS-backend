
var roleType= $("#role").val();

//if(roleType ==="Tester") {
//	$("#StatusOnHold").show();
//}
var prevEdate = null;

$('#spin1').hide();
window.onload = function() {
//	alert("ID "+$('#crnoo').val());
	
	$('#taskNo').text($('#crnoo').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	// var serviceUrl = base_url + "/PMS/getDevTaskDetails"
	var serviceUrl = base_url + "/PMS/getDevAssignedTaskDetails";

	$.ajax({
		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : "crno=" + $('#crnoo').val() + "&tid=" + $('#tid').val()
	}).done(function(data) {
		console.log(data);
//		alert("t details " + data)
//		console.log(data);
//		alert(data[0][11]);
		
		$('#functionName').val(decodeURIComponent(data[0][0]));
		$('#Module_Name').val(decodeURIComponent(data[0][1]));
		$('#Responsibility').val(decodeURIComponent(data[0][2]));
		$('#Manager_Name').val(decodeURIComponent(data[0][3]));
		$('#Team_Leader').val(decodeURIComponent(data[0][4]));
		$('#Developer').val(decodeURIComponent(data[0][5]));

		$('#Start_Date').val(decodeURIComponent(data[0][6]));
		$('#End_Date').val(decodeURIComponent(data[0][7]));
		prevEdate = decodeURIComponent(data[0][7]);
		$('#Status').val(decodeURIComponent(data[0][8]));
		
//		$('#Remark').val(data[0][9] ? decodeURIComponent(data[0][9]) : 'NA');
		
		$('#Remark').val(decodeURIComponent(data[0][9]));
		
		$('#customer_name').val(data[0][11] ? decodeURIComponent(data[0][11]) : 'NA');
		
		
		$('#suit_name').val(data[0][12] ? decodeURIComponent(data[0][12]) : 'NA');
		$('#product_name').val(data[0][13] ? decodeURIComponent(data[0][13]) : 'NA');
		
		$('#Task_Priority').val(data[0][14] ? decodeURIComponent(data[0][14]) : 'NA');
		
		
//		$('#Remark').val(data[0][18] ? decodeURIComponent(data[0][18]) : 'NA');
		
		$('#Description').val(data[0][10] ? decodeURIComponent(data[0][10]) : 'NA');

		

//		if (data[0][10] === "undefined" || data[0][10]==null) {
//			$('#Description').val("NA");
//		} else {
//			$('#Description').val(decodeURIComponent(data[0][10]));
//		}
		
//		if(data[0][11]==null){
//			
//			$('#DivCustomer').hide();
//			$('#customer_name').val("NA");
//		}else
//		{
//			
//			$('#DivCustomer').show();
//			$('#customer_name').val(decodeURIComponent(data[0][11]));
//		}
		
//		if (data[0][11] === "undefined" || data[0][11]==null) {
//			alert("inside ")
//			$('#customer_name').val("NA");
//		} else {
//			$('#customer_name').val((data[0][11]));
//		}
//		
		
		
		
//		if(data[0][12]==null){
//			$('#DivProductName').hide();
//		}else
//			{
//			$('#DivProductName').show();
//			$('#product_name').val(decodeURIComponent(data[0][12]));
//			
//			}
//		
//		if(data[0][13]==null){
//			$('#DivSuitName').hide();
//		}else
//			{
//			$('#DivSuitName').show();
//			$('#suit_name').val(decodeURIComponent(data[0][13]));
//			
//			}
//		
//		
//		$('#Task_Priority').val(decodeURIComponent(data[0][14]));

	});
}

/*function updateTaskStatus() {
//	alert("KJJJJJJJJJJJJ")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/updateTaskStatus";
	 $('#spin1').show();
	 $.ajax({
			            type: 'POST',
			            url: serviceUrl,
			            data: "crno=" + $('#crnoo').val() + "&tid=" + $('#tid').val()
						+ "&Status=" + $('#Status').val() + "&Remark="
						+ $('#Remark').val(),
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
			                        window.location.href = base_url + "/Admin/Activitydetails";
			                    }

			                });

			            }
			             else if (data == "duplicate") {
			                swal({
			                    title: "Duplicate Data!",
			                    text: "Record Already Exists",
			                    type: "warning",
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
			                    text: "Fail to add file",
			                    type: "success",
			                    width: 300,
			                    height: 200,
//			           		 showCancelButton: false,
//			                  confirmButtonClass: "btn btn-danger",
//			                  cancelButtonClass: "btn btn-danger m-l-10",
//			                  confirmButtonText: "OK",
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
	 
	 
}*/


//06/06
function updateTaskStatus() {
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
        var serviceUrl = base_url + "/PMS/updateTaskStatus";
        $('#spin1').show();
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: "crno=" + $('#crnoo').val() + "&tid=" + $('#tid').val() +
                "&Status=" + $('#Status').val() + "&Remark=" + $('#Remark').val(),
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
                        window.location.href = base_url + "/Admin/Activitydetails";
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
                        window.location.href = base_url + "/Admin/Activitydetails";
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
                        window.location.href = base_url + "/Admin/Activitydetails";
                    }
                });
            }
        });
    });
}


//
function updateModifyDate() {
	
//	alert("s")
	
	$("#prevDate").val(prevEdate);
	
	$("#modalReviseDate").modal("show");	
	
	
}


function updateDate() {
	
    swal({
        title: "Are you sure?",
        text: "You Want to Send Request for Revise Date?",
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
   						+ $('#Remark').val() + "&End_Date=" +$("#End_DateUpdate").val(),
   						
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





function updateTodaysProgress(){
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	// var serviceUrl = base_url + "/PMS/getDevTaskDetails"
	var serviceUrl = base_url + "/PMS/getTodaysProgressModalData";

	$.ajax({
		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : "crno=" + $('#crnoo').val() + "&tid=" + $('#tid').val()
	}).done(function(data) {
		console.log(data);

		
		$('#functionNameModal').val(decodeURIComponent(data[0][0]));
		$('#moduleNameModal').val(decodeURIComponent(data[0][1]));
		$('#customerNameModal').val(decodeURIComponent(data[0][2]));
		$('#productNameModal').val(decodeURIComponent(data[0][3]));
		$('#productSuiteNameModal').val(decodeURIComponent(data[0][4]));
		$('#taskDescModal').val(decodeURIComponent(data[0][5]));

		$('#dateModal').val(decodeURIComponent(data[0][6]));
		
		$("#modelUpdateTodaysProgress").modal("show");	
	});
}





function saveTodaysProgress(){
//	alert("clicked");
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/saveTodaysProgress";

	$.ajax({
		url : serviceUrl,
		type : 'POST',
//		dataType : 'json',
		data : "crno=" + $('#crnoo').val() +
		"&functionNameModal=" + $('#functionNameModal').val() + 
		"&moduleNameModal=" + $('#moduleNameModal').val() +
		"&customerNameModal=" + $('#customerNameModal').val() +
		"&productNameModal=" + $('#productNameModal').val() +
		"&productSuiteNameModal=" + $('#productSuiteNameModal').val() +
		"&taskDescModal=" + $('#taskDescModal').val() +
		"&dateModal=" + $('#dateModal').val() +
		"&progressModal=" + $('#progressModal').val() 
	}).done(function(data) {
		
		var crno=$('#crnoo').val();
		var tid=$('#tid').val();
		
//		alert("data::"+data);
        
        if (data == "success") {
            swal({
                title: "Successful!",
                text: "Progress Updated Successfully",
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
         else if (data == "duplicate") {
            swal({
                title: "Duplicate Data!",
                text: "Progress is already updated for this task today",
                type: "warning",
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
                text: "Failed to Update Progress",
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
}



$("#saveTodaysProgress").click(function() {
	   if (!validateTodaysProgress()) 
	   { 
	        event.preventDefault();
	   }
	     else 
	   {
	    	saveTodaysProgress();
	   }
//	   
	});



function validateTodaysProgress() {
    var indexError = 0;
   
    if ($('#progressModal').val().trim() === '') {
        callToolTip231('progressModal', 'show');
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

    if (fieldName == "functionNameModal") {
        var errorMessage = "<span>Please enter Function Name <span>";
    }
     else if (fieldName == "moduleNameModal") {
        var errorMessage = "<span>Please enter Module Name<span>";
    }
     else if (fieldName == 'customerNameModal') {
    	var errorMessage = "<span>Please enter Customer Name<span>";
    }
     else if (fieldName == "productNameModal") {
         var errorMessage = "<span>Please enter Product Name<span>";
     }
     else if (fieldName == "productSuiteNameModal") {
         var errorMessage = "<span>Please enter Product Suite<span>";
     }
     else if (fieldName == "developerName") {
         var errorMessage = "<span>Please enter Task Description<span>";
     }
     else if (fieldName == "Tlname") {
         var errorMessage = "<span>Please enter Date<span>";
     }
     else if (fieldName == "progressModal") {
         var errorMessage = "<span>Please enter Today's Progress<span>";
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


$('#functionNameModal').on('focusout', function() {
	var usertype = $('#functionNameModal').val();
	if(usertype.trim() == "") {
		callToolTip231('functionNameModal', 'show');
	} else {
		callToolTip231('functionNameModal', 'hide');
	}
});

$('#moduleNameModal').on('focusout', function() {
	var usertype = $('#moduleNameModal').val();
	if(usertype.trim() == "") {
		callToolTip231('moduleNameModal', 'show');
	} else {
		callToolTip231('moduleNameModal', 'hide');
	}
});
$('#customerNameModal').on('focusout', function() {
	var usertype = $('#customerNameModal').val();
	if(usertype.trim() == "") {
		callToolTip231('customerNameModal', 'show');
	} else {
		callToolTip231('customerNameModal', 'hide');
	}
});

$('#productNameModal').on('focusout', function() {
	var usertype = $('#productNameModal').val();
	if(usertype.trim() == "") {
		callToolTip231('productNameModal', 'show');
	} else {
		callToolTip231('productNameModal', 'hide');
	}
});
$('#productSuiteNameModal').on('focusout', function() {
	var usertype = $('#productSuiteNameModal').val();
	if(usertype.trim() == "") {
		callToolTip231('productSuiteNameModal', 'show');
	} else {
		callToolTip231('productSuiteNameModal', 'hide');
	}
});

$('#taskDescModal').on('focusout', function() {
	var usertype = $('#taskDescModal').val();
	if(usertype.trim() == "") {
		callToolTip231('taskDescModal', 'show');
	} else {
		callToolTip231('taskDescModal', 'hide');
	}
});
$('#dateModal').on('focusout', function() {
	var usertype = $('#dateModal').val();
	if(usertype.trim() == "") {
		callToolTip231('dateModal', 'show');
	} else {
		callToolTip231('dateModal', 'hide');
	}
});

$('#progressModal').on('focusout', function() {
	var usertype = $('#progressModal').val();
	if(usertype.trim() == "") {
		callToolTip231('progressModal', 'show');
	} else {
		callToolTip231('progressModal', 'hide');
	}
});




$('#functionNameModal').on('focus', function() {
	callToolTip231('functionNameModal', 'destroy');
});
$('#moduleNameModal').on('focus', function() {
	callToolTip231('moduleNameModal', 'destroy');
});

$('#customerNameModal').on('focus', function() {
	callToolTip231('customerNameModal', 'destroy');
});
$('#productNameModal').on('focus', function() {
	callToolTip231('productNameModal', 'destroy');
});

$('#productSuiteNameModal').on('focus', function() {
	callToolTip231('productSuiteNameModal', 'destroy');
});
$('#taskDescModal').on('focus', function() {
	callToolTip231('taskDescModal', 'destroy');
});
$('#dateModal').on('focus', function() {
	callToolTip231('dateModal', 'destroy');
});
$('#progressModal').on('focus', function() {
	callToolTip231('progressModal', 'destroy');
});
