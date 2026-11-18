
var TStatus = "Completed";

window.onload = function() {
 //      alert("ggggg")
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/PMS/getMyTaskList";
 	var serviceUrl = base_url + "/PMS/getRfpTasksList";
	
 	$('#spin12').show();
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "TStatus=" + TStatus,
        success: function(data5) {
      	
       // 	alert("asd "+data5);

        	$('#spin12').hide();
            var table = $('#CMApprByMeTable').DataTable({
                lengthChange: false,
                 pageLength: 10,
                data: data5,
//                scrollX: '300px',
                scrollX: '300px',
                dom: 'Bfrtip', // Add this line to enable export buttons
                buttons:[
                    {
                        extend: 'pdfHtml5',
                        title: 'Completed Tasks',
                        exportOptions: {
                            columns: function (idx, data, node) {
                                // Exclude the first column ("View" column) 
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
                                return idx !== 0; // Exclude the "View" column
                            }
                        }
                    },
                    {
                        extend: 'print',
                        exportOptions: {
                            columns: function (idx, data, node) {
                                return idx !== 0; // Exclude the "View" column
                            }
                        }
                    }
                ],
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
                "columnDefs": [
                	{ targets: 0, width: "60px",
                        render: function(data, type, row) {
                            if (data === "Assigned") return '<span style="color:red;">'+data+'</span>';
                            if (data === "Close") return '<span style="color:green;">'+data+'</span>';
                            if (data === "Tested") return '<span style="color:red;">'+data+'</span>';
                            if (data === "Developed") return '<span style="color:green;">'+data+'</span>';
                            if (data === "Ready to Deliver") return '<span style="color:red;">'+data+'</span>';
                            if (data === "Yet to Assign") return '<span style="color:green;">'+data+'</span>';
                            return '<span style="color:black;">'+data+'</span>';
                        }
                      },
                    { targets: 1, width: "120px",},
                    { targets: 2, width: "120px" },
                    { targets: 3, width: "120px" },
                    { targets: 4, width: "120px" },
                    { targets: 5, width: "120px" },
                    { targets: 6, width: "120px" },
                    { targets: 7, width: "250px" },
                    { targets: 8, width: "120px" },
                ]
            
            });

        }

    });
    
        }


function ViewRFPTaskDetails(crno , tid)
{
//	alert("hih")
	 	var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    window.location.href = base_url + "/PMS/ViewMyTaskDetails?crno="+crno+"&tid="+tid;   
	    window.location.href = base_url + "/PMS/ViewRFPTaskDetailsNew?crno="+crno;
	    
}