
var TStatus = "Completed";

window.onload = function() {
 //      alert("ggggg")
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 //	var serviceUrl = base_url + "/PMS/pendingdevtask"; 	
// 	var serviceUrl = base_url + "/PMS/getDevTaskData";
	var serviceUrl = base_url + "/PMS/getImplTaskList";
	
 	$('#spin12').show();
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "TStatus=" + TStatus,
        success: function(data5) {
      	
//        	alert("asd "+data5);

        	$('#spin12').hide();
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

        }

    });
    
        }


function ImpllTaskDetails(crno , tid)
{
//	alert("hih")
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    window.location.href = base_url + "/PMS/ViewDeveloperPendingDetails?crno="+crno+"&tid="+tid;
	    window.location.href = base_url + "/PMS/ViewImplCompleteTaskDetails?crno="+crno+"&tid="+tid;
}