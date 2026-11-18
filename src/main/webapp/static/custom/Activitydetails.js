
var TStatus = "Completed";

//window.onload = function() {
// //      alert("ggggg")
//    
//    var l = window.location;
// 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// //	var serviceUrl = base_url + "/PMS/pendingdevtask"; 	
////	var serviceUrl = base_url + "/PMS/getImplTaskList";
// 	var serviceUrl = base_url + "/PMS/getMyTaskList";
//	
// 	$('#spin12').show();
//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        dataType: 'json',
//        data: "TStatus=" + TStatus,
//        success: function(data5) {
//      	
//       // 	alert("asd "+data5);
//
//        	$('#spin12').hide();
//            var table = $('#CMApprByMeTable').DataTable({
//                lengthChange: false,
//                 pageLength: 10,
//                data: data5,
//                scrollX: '300px',
//                dom: 'Bfrtip', // Add this line to enable export buttons
//                buttons:[{
//                    extend: 'pdfHtml5',
//                    exportOptions: {
//                        columns: function (idx, data, node) {
//                            // Exclude the first column ("View" column) dynamically
//                            return idx !== 0;
//                        }
//                    },
//                    customize: function (doc) {
//                        doc.pageOrientation = 'landscape'; // or 'landscape'
//                        doc.pageSize = 'A4'; // Customization code here
//                    }
//                },
//                {
//                    extend: 'excelHtml5',
//                    exportOptions: {
//                        columns: function (idx, data, node) {
//                            return idx !== 0; // Exclude the first column ("View" column) dynamically
//                        }
//                    }
//                },
//                {
//                    extend: 'print',
//                    exportOptions: {
//                        columns: function (idx, data, node) {
//                            return idx !== 0; // Exclude the first column ("View" column) dynamically
//                        }
//                    }
//                }],
//                "columnDefs": [
//             	    {
//             	      "targets": 1, // Target the second column (index 1, "Status")
//             	      "render": function(data, type, row) {
//             	        if (data === "Pending") {
//             	          return '<span style="color: red;">' + data + '</span>';
//             	        } else if(data === "Completed"){
//             	          return '<span style="color: green;">' + data + '</span>';
//             	        }else {
//             	        	return '<span style="color: black;">' + data + '</span>';
//             	        }
//             	      }
//             	    }
//             	  ]
//            });
//
//        }
//
//    });
//    
//        }



//
window.onload = function() {
	 //      alert("ggggg")
	    
		
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 //	var serviceUrl = base_url + "/PMS/pendingdevtask"; 	
//		var serviceUrl = base_url + "/PMS/getImplTaskList";
	 	var serviceUrl = base_url + "/PMS/getMyTaskList";
		
	 	$('#spin12').show();
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: "TStatus=" + TStatus,
	        success: function(data5) {
	        	console.log(data5)
//	        	alert("asd "+data5);

	        	$('#spin12').hide();
	        	
	        	if (data5 && data5.length > 0) {
	        		var table = $('#CMApprByMeTable').DataTable({
	                    lengthChange: false,
	                     pageLength: 10,
	                        data: data5,
	                        scrollX: '300px',
	                        dom: 'Bfrtip', // Add this line to enable export buttons
	                        buttons:[{
	                            extend: 'pdfHtml5',
	                            exportOptions: {
	                                columns: function (idx, data, node) {
	                                    // Exclude the first column ("View" column) 
	                                	 return idx !== 0 && idx !== 1;
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
//	                        "columnDefs": [
//	                     	    {
//	                     	      "targets": 1, // Target the second column (index 1, "Status")
//	                     	      "render": function(data, type, row) {
//	                     	        if (data === "Pending") {
//	                     	          return '<span style="color: red;">' + data + '</span>';
//	                     	        } else if(data === "Completed"){
//	                     	          return '<span style="color: green;">' + data + '</span>';
//	                     	        }else {
//	                     	        	return '<span style="color: black;">' + data + '</span>';
//	                     	        }
//	                     	      }
//	                     	    }
//	                     	  ]
	                        columnDefs: [
	                            { targets: 0, width: "110px" },     // Check All
	                            { targets: 1, width: "40px" },     // View
	                            { targets: 2, width: "90px" },     // Assign Date

	                            { 
	                              targets: 3,                     // Status
	                              width: "70px",
	                              render: function(data, type, row) {
	                                if (data === "Pending") {
	                                  return '<span style="color:red;">' + data + '</span>';
	                                } else if (data === "Completed") {
	                                  return '<span style="color:green;">' + data + '</span>';
	                                } else {
	                                  return '<span style="color:black;">' + data + '</span>';
	                                }
	                              }
	                            },

	                            { targets: 4, width: "70px" },     // Task ID
	                            { targets: 5, width: "120px" },    // Customer Name
	                            { targets: 6, width: "110px" },    // Product Suite
	                            { targets: 7, width: "110px" },    // Product Tool
	                            { targets: 8, width: "380px" },    // Activity
	                            { targets: 9, width: "120px" },    // Module Name
	                            { targets: 10, width: "110px" },   // Assigned To
	                            { targets: 11, width: "130px" },   // Team Leader Name
	                            { targets: 12, width: "130px" },   // Task Assigned By
	                            { targets: 13, width: "80px" },    // Start Date
	                            { targets: 14, width: "80px" }     // End Date
	                        ]

	                    });
	        		$('#sub').show();
//	                    checkTableRecords();
	        	}
	        	else{
	        		$('#CMApprByMeTable tbody').append('<tr><td colspan="15" style="text-align:center; background-color:#f0f5f5;">No Task Available</td></tr>');
	                $('#CMApprByMeTable').css('overflow-x', 'auto');
	        		$('#sub').hide();
	        	}
	            
	        }
	    	
	    });
}


function ImpllTaskDetails(crno , tid)
{
//	alert("hih")
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    window.location.href = base_url + "/PMS/ViewImplCompleteTaskDetails?crno="+crno+"&tid="+tid;
	    window.location.href = base_url + "/PMS/ViewMyTaskDetails?crno="+crno+"&tid="+tid;
}



var checkedCheckboxes = [];
var checkAllCheckbox = document.getElementById('checkAll');
var checkboxes = document.getElementsByName('taskCheckBoxes');

function checkAllClicked() {
	 const checkAllCheckbox = document.getElementById('checkAll');
     checkedCheckboxes = [];
     checkboxes.forEach(function(checkbox) {
    	 
        if (checkbox.checked) {
//          alert(" id :" + checkbox.id);
//            alert(" date :" + $('#date'+checkbox.id).val());
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

function statusMarkAsCompleted(checkedIds) {
//  console.log("Selected dates:", checkedCheckboxes);
//  alert("Selected dates: " + JSON.stringify(checkedCheckboxes));
//alert("checkedIds    "+checkedIds)
	

	if (checkedCheckboxes.length === 0) {
        return;
    }
	
//	alert("gdfsf")
	    swal({
	        title: "Are you sure?",
	        text: "You want to Update status?",
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
	    	var serviceUrl = base_url + "/PMS/updateMultipleData";
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

	                })

	            }

	            else if (data == "error") {
	                swal({
	                    title: "Failed!",
	                    text: "Fail to Update Status",
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

	                })

	            }
	        });
	    })
	

	
}





//03/01/2026
function isEndDateCrossed(endDateStr) {
    if (!endDateStr || endDateStr === "NA") return false;
    const [day, month, year] = endDateStr.split('.').map(Number);
    const endDate = new Date(year, month - 1, day);
    const today = new Date();
    today.setHours(0, 0, 0, 0);
    return today > endDate;
}

//03/01/2026