

window.onload = function() {
	 //      alert("ggggg")
	    
		
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	 	var serviceUrl = base_url + "/PMS/getCustomizationReadyTaskList";
	 	var serviceUrl = base_url + "/PMS/getRFPReadyTaskList";

		
	 	$('#spin12').show();
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
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
//	                    checkTableRecords();
	        	}
	        	else{
	        		$('#CMApprByMeTable tbody').append('<tr><td colspan="15" style="text-align:center; background-color:#f0f5f5;">No Task Available</td></tr>');
	                $('#CMApprByMeTable').css('overflow-x', 'auto');
	        		$('#sub').hide();
	        	}
	            
	        }
	    	
	    });
	    
  
	    
    // assigned by me 
	    
	    var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	  	var serviceUrl = base_url + "/PMS/getCustomTaskReadytoDeliverList";
	  	var serviceUrl = base_url + "/PMS/getRFPTaskReadytoDeliverList";

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
}


function RFPTaskDetails(crno)
{
//	alert("hih")
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    window.location.href = base_url + "/PMS/ViewReadyToDeliverRFPTask?crno="+crno;
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
	                        window.location.href = base_url + "/Admin/MyCustomizationTestingTask";
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
	                        window.location.href = base_url + "/Admin/MyCustomizationTestingTask";
	                    }

	                })

	            }
	        });
	    })
	

	
}