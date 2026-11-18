var TStatus = "Pending";
// alert(TStatus)
window.onload = function() {
	// alert("ggggg")

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	// var serviceUrl = base_url + "/PMS/getDevTaskDetails";
//	var serviceUrl = base_url + "/PMS/getImplTaskList";   
	var serviceUrl = base_url + "/PMS/getAssignedTaskMe";
	
	$('#spin12').show();
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : "TStatus=" + TStatus,
		success : function(data5) {

//			alert("asd "+data5);

			$('#spin12').hide();
			var table = $('#CMApprByMeTable').DataTable(
					{
						lengthChange : false,
						pageLength : 10,
						data : data5,
						scrollX : '300px',
						dom : 'Bfrtip', // Add this line to enable export
										// buttons
						buttons : [{
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
//						"columnDefs" : [ {
//							"targets" : 1, // Target the second column (index
//											// 1, "Status")
//							"render" : function(data, type, row) {
//								if (data === "Pending") {
//									return '<span style="color: red;">' + data
//											+ '</span>';
//								} else if (data === "Completed") {
//									return '<span style="color: green;">'
//											+ data + '</span>';
//								} else {
//									return '<span style="color: black;">'
//											+" On Hold" + '</span>';
//								}
//							}
//						} ]
			              columnDefs: [
			            	    { targets: 0, width: "80px" },    // View
			            	    {
			            	        targets: 1,                   // Status
			            	        width: "70px",
			            	        render: function(data, type, row) {
			            	            if (data === "Pending") {
			            	                return '<span style="color:red;">' + data + '</span>';
			            	            } else if (data === "Completed") {
			            	                return '<span style="color:green;">' + data + '</span>';
			            	            } else {
			            	                return '<span style="color:black;">On Hold</span>';
			            	            }
			            	        }
			            	    },
			            	    { targets: 2, width: "70px" },    // Task ID
			            	    { targets: 3, width: "130px" },   // Customer Name
			            	    { targets: 4, width: "110px" },   // Product Suite
			            	    { targets: 5, width: "110px" },   // Product Tool
			            	    { targets: 6, width: "280px" },   // Activity
			            	    { targets: 7, width: "140px" },   // Module Name
			            	    { targets: 8, width: "140px" },   // Team Leader Name
			            	    { targets: 9, width: "120px" },   // Assigned To
			            	    { targets: 10, width: "130px" },  // Task Assigned By
			            	    { targets: 11, width: "80px" },   // Start Date
			            	    { targets: 12, width: "80px" }    // End Date
			            	]

					});

		}

	});

}

function ImpllTaskDetails(crno, tid) {
	// alert("hih")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	// window.location.href = base_url +
	// "/PMS/ViewDeveloperPendingDetails?crno="+crno+"&tid="+tid;
	window.location.href = base_url + "/PMS/ViewTaskDetails?crno=" + crno
			+ "&tid=" + tid;
}