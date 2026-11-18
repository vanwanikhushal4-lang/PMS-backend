
window.onload = function() {
	
//	sectools22()
	getSecTools()
	sectools1()
	  var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getproducutsuitList";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          
	          success: function(data2) {
	          //    //("burger"+data2)
	         	 var html = "  <option value=''> -- Please Select --</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("productsuitdetails").innerHTML = html;	
//	 			document.getElementById("productsuitupdate").innerHTML = html;	
	 			
	 		}
	 	});
	      
//	    
	 
	
	
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/Tlmasterlisting";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
             var table = $('#productdata').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 10,
                  scrollX:true,
                  scrollY:true
             });

             table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });
     
     
     
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getCustomerName";

	$.ajax({
	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	}).done(function(data) {

	    var html= '<option value="">--Please Select Customer--</option>';
	    for (var i = 0; i < data.length; i++) {
	        html += '<option value="' +data[i]+ '">' + data[i]
	        + '</option>';
	    }

	    document.getElementById("customerName").innerHTML=html;
	});
	
//	$('#customerName').select2({
//		tags: true,
//		placeholder: "Select a Customer or Enter New",
//		// allowClear: true
//	})
	
	
	
	
	
	//16/11
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getStatusForDeletedActivities";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON'
	    
	}).done(function(data) {
	
		 var html = "<option value=''>-- Please Select Product Tool --</option>";
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
	      document.getElementById("projectStatus").innerHTML=html;

	});
	//
	
	
 }






function validateProductMaster() {
    var indexError = 0;
    if ($('#productsuitdetails').val().trim() === '') {
        callToolTip231('productsuitdetails', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#securitysolutiondetails').val().trim() === '') {
        callToolTip231('securitysolutiondetails', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
//    
//    if ($('#customerName').val().trim() === '') {
//        callToolTip231('customerName', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#ImplementerName').val().trim() === '') {
//        callToolTip231('ImplementerName', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#Tlname').val().trim() === '') {
//        callToolTip231('Tlname', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#developerName').val().trim() === '') {
//        callToolTip231('developerName', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
    
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}


var callToolTip231 = function(fieldName, status) {

    if (fieldName == "productsuitdetails") {
        var errorMessage = "<span>Please Select Product Suit <span>";
    }
     else if (fieldName == "securitysolutiondetails") {
        var errorMessage = "<span>Please Select Security Solution<span>";
    }
     else if (fieldName == 'customerName') {
    	var errorMessage = "<span>Please or Enter Customer Name<span>";
    }
     else if (fieldName == "ImplementerName") {
         var errorMessage = "<span>Please Select Manager Name<span>";
     }
     else if (fieldName == "Tlname") {
         var errorMessage = "<span>Please Select Team Leader<span>";
     }
     else if (fieldName == "developerName") {
         var errorMessage = "<span>Please Select Developer Name<span>";
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


$('#securitysolutiondetails').on('focusout', function() {
	var usertype = $('#securitysolutiondetails').val();
	if(usertype.trim() == "") {
		callToolTip231('securitysolutiondetails', 'show');
	} else {
		callToolTip231('securitysolutiondetails', 'hide');
	}
});

$('#productsuitdetails').on('focusout', function() {
	var usertype = $('#productsuitdetails').val();
	if(usertype.trim() == "") {
		callToolTip231('productsuitdetails', 'show');
	} else {
		callToolTip231('productsuitdetails', 'hide');
	}
});

//$('#unitdata').on('focusout', function() {
//	var usertype = $('#unitdata').val();
//	if(usertype.trim() == "") {
//		callToolTip231('unitdata', 'show');
//	} else {
//		callToolTip231('unitdata', 'hide');
//	}
//});


$('#productsuitdetails').on('focus', function() {
	callToolTip231('productsuitdetails', 'destroy');
});
$('#securitysolutiondetails').on('focus', function() {
	callToolTip231('securitysolutiondetails', 'destroy');
});

$('#customerName').on('focus', function() {
	callToolTip231('customerName', 'destroy');
});
$('#ImplementerName').on('focus', function() {
	callToolTip231('ImplementerName', 'destroy');
});

$('#Tlname').on('focus', function() {
	callToolTip231('productsuitdetails', 'destroy');
});
$('#developerName').on('focus', function() {
	callToolTip231('developerName', 'destroy');
});

//$('#unitdata').on('focus', function() {
//	callToolTip231('unitdata', 'destroy');
//});

//$("#resetbtn").click(function() {
//	
//	$("#deleteActivitiesCard").hide();
//	
//    $("#productsuitdetails").val("");
//     callToolTip231('productsuitdetails', 'hide');
//
//    $("#securitysolutiondetails").val("");
//     callToolTip231('securitysolutiondetails', 'hide');
//     
//     $("#customerName").val("");
//     callToolTip231('customerName', 'hide');
//     
//     $("#ImplementerName").val("");
//     callToolTip231('ImplementerName', 'hide');
//     
//     $("#Tlname").val("");
//     callToolTip231('Tlname', 'hide');
//     
//     $("#developerName").val("");
//     callToolTip231('developerName', 'hide');
//     
//     $("#projectStatus").val("");
//     callToolTip231('projectStatus', 'hide');
//     
//   
//     
//       
//});


$("#resetbtn").click(function() {
	$("#deleteActivitiesCard").hide();
	
	$("#productsuitdetails").val("");
	$("#securitysolutiondetails").val("");
	$("#customerName").val("");
	$("#projectStatus").val("");
	
	 $("#customerName").val(null).trigger('change'); 
	 
	 callToolTip231('productsuitdetails', 'hide');
	 callToolTip231('securitysolutiondetails', 'hide');
});






$("#submit-btn").click(function() {
   if (!validateProductMaster()) 
   { 
        event.preventDefault();
   }
     else 
   {
    	 getActivityList();
   }
   
});


function sectools1() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";
										 
	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuitupdate").val())
	}).done(function(data2Array) {
//		alert("hhhh"+data2Array)
	    // Split the received data into an array (e.g., comma-separated values)
//	    var data2Array = data2.split(','); // Change ',' to the appropriate delimiter

	    var html = "<option value=''> -- Please Select --</option>";
	    for (var i = 0; i < data2Array.length; i++) {
	        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
	    }
	    document.getElementById("securitysolutiondetails").innerHTML = html;
//	    document.getElementById("securitysolutionupdate").innerHTML = html;
	    
	});
	}




function getSecTools() {
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuitdetails").val())
	}).done(function(data) {
	
		 var html = "<option value=''>-- Please Select Product Tool --</option>";
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
	      document.getElementById("securitysolutiondetails").innerHTML=html;
//	      document.getElementById("securitysolutionupdate").innerHTML=html;
	      
	      
        
	});
		
}



function getActivityList(){
	//16/11
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/PMS/getListForDeletedActivities";
	
 	$('#spin12').show();
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "prodSuit=" + $('#productsuitdetails').val() +
        "&secTool=" + $('#securitysolutiondetails').val() +
        "&custName=" + $('#customerName').val() +
        "&projectStatus=" + $('#projectStatus').val(),
        success: function(data5) {
        	console.log(data5)
//        	alert("asd "+data5);
        	
        	$('#spin12').hide();
        	$("#deleteActivitiesCard").show();

        	if ($.fn.dataTable.isDataTable('#CMApprByMeTable')) {
	            $('#CMApprByMeTable').DataTable().clear().destroy();
	        }
        	
        	
        	
        	
        	if (data5 && data5.length > 0) {
        		var table = $('#CMApprByMeTable').DataTable({
                    lengthChange: false,
                     pageLength: 10,
                        data: data5,
                    
                        scrollY: true,
                       
                        dom: 'Bfrtip', // Add this line to enable export buttons
                        buttons:[{
                            extend: 'pdfHtml5',
                            exportOptions: {
                                columns: function (idx, data, node) {
                                    // Exclude the first column ("View" column) dynamically
                                    return idx !== 0;
                                }
                            },
                            customize: function (doc) {
                                doc.pageOrientation = 'landscape'; // or 'landscape'
                                doc.pageSize = 'A4'; // Customization code here
                            }
                        },
                        {
                            extend: 'excelHtml5',
                            exportOptions: {
                                columns: function (idx, data, node) {
                                    return idx !== 0; // Exclude the first column ("View" column) dynamically
                                }
                            }
                        },
                        {
                            extend: 'print',
                            exportOptions: {
                                columns: function (idx, data, node) {
                                    return idx !== 0; // Exclude the first column ("View" column) dynamically
                                }
                            }
                        }],
                        "columnDefs": [
                     	    {
                     	      "targets": 1, // Target the second column (index 1, "Status")
                     	      "render": function(data, type, row) {
                     	        if (data === "Pending") {
                     	          return '<span style="color: red;">' + data + '</span>';
                     	        } else if(data === "Completed"){
                     	          return '<span style="color: green;">' + data + '</span>';
                     	        }else {
                     	        	return '<span style="color: black;">' + data + '</span>';
                     	        }
                     	      }
                     	    }
                     	  ]
                    });
        		$('#sub').show();
//                    checkTableRecords();
        	}
        	else{
        		$('#CMApprByMeTable tbody').html('');
        		$('#CMApprByMeTable tbody').append('<tr><td colspan="14" style="text-align:center; background-color:#f0f5f5;">No Task Available</td></tr>');
        	 	$('#CMApprByMeTable').css('overflow-x', 'auto'); 
        		$('#sub').hide();
        	}
            
        }
    	
    });
    
    
	//
}





function deleteActivities(checkedIds) {
//  console.log("Selected dates:", checkedCheckboxes);
//  alert("Selected dates: " + JSON.stringify(checkedCheckboxes));
//alert("checkedIds    "+checkedIds)
	

	if (checkedCheckboxes.length === 0) {
        return;
    }
	
//	alert("gdfsf")
	    swal({
	        title: "Are you sure?",
	        text: "You want to Delete Activity?",
	        type: "warning",
	        width: 350,
	        height: 200,
	        showCancelButton: !0,
	        confirmButtonClass: "btn btn-success",
	        cancelButtonClass: "btn btn-danger m-l-10",
	        confirmButtonText: "Yes!"
	    }).then(function() {
//	          alert("deleteUserdddddddd")
	          
//	          alert("Selected dates: " + JSON.stringify(checkedCheckboxes));
	        var l = window.location;
	    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    	var serviceUrl = base_url + "/PMS/deleteActivitiesData";
	    	$('#spin2').show();
	    	$.ajax({
	    		type : 'POST',
	    		url : serviceUrl,
	    		data: "checkedIds=" + checkedCheckboxes
	
	        }).done(function(data) {
	            //  alert("dfgsfd"+data)

	            if (data == "success") {
	                swal({
	                    title: "Successful!",
	                    text: "Activity Deleted Successfully",
	                    type: "success",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/deleteActivities";
	                    }

	                })

	            }

	            else if (data == "error") {
	                swal({
	                    title: "Failed!",
	                    text: "Failed to Delete",
	                    type: "error",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/deleteActivities";
	                    }

	                })

	            }
	        });
	    })
	

	
}




var checkedCheckboxes = [];
var checkAllCheckbox = document.getElementById('checkAll');
var checkboxes = document.getElementsByName('taskCheckBoxes');

function checkAllClicked() {
	 const checkAllCheckbox = document.getElementById('checkAll');
     checkedCheckboxes = [];
     checkboxes.forEach(function(checkbox) {
    	 
        if (checkbox.checked) {
            checkedCheckboxes.push(checkbox.id);
        }
    });
    console.log(checkedCheckboxes);
}


checkAllCheckbox.addEventListener('change', function() {
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = checkAllCheckbox.checked;
    });
    checkAllClicked(); 
});


checkboxes.forEach(function(checkbox) {
    checkbox.addEventListener('change', function() {
    	checkAllClicked();
    });
});


function checkIndividual() {
	checkAllClicked();
}

