

window.onload = function() {
    //   alert("ggggg")
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/proposalLicensePendingDetailsBH";
 	
 	$('#spin12').show();
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data5) {
//alert("hxgdfg"+data5)

        	$('#spin12').hide();
            var table = $('#CMApprByMeTable').DataTable({
                lengthChange: false,
                 pageLength: 5,
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
             	    	  var data1 = "License Approved By SM"
                   	        if (data1 === "Not Approved") {
                   	          return '<span style="color: red;">' + data1 + '</span>';
                   	        } else {
                   	          return '<span style="color: black;">' + data1 + '</span>';
                   	        }
                   	      }
             	    }
             	  ]
            });

        }

    });
    
        }


function ApprovedCRF(crno,tid)
{
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    window.location.href = base_url + "/User/ViewProposalLicensePendingDetailsBH?crno="+crno+"&tid="+tid;
}