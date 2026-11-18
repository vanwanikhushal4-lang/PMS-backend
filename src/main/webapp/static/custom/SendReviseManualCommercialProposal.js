

window.onload = function() {
    //   alert("ggggg")
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/ReviseManualProposalSendBymeDetailsSI";
 	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data5) {
//alert("hxgdfg"+data5)


            var table = $('#CMApprByMeTable').DataTable({
                lengthChange: false,
                pageLength: 5,
                data: data5,
                scrollX: '300px',
                dom: 'Bfrtip', // Add this line to enable export buttons
                buttons:[
                    {
                        extend: 'pdfHtml5',
                        exportOptions: {
                            columns: ':visible' // Only export visible columns
                        },
                        customize: function (doc) {
                        	 doc.pageOrientation = 'landscape'; // or 'portrait'
                             doc.pageSize = 'A4'; // Customization code here
                        }
                    },
                     'excel', 'print'
                ],
                "columnDefs": [
            	    {
            	      "targets": 2, // Target the second column (index 1, "Status")
            	      "render": function(data, type, row) {
            	        if (data === "Approved By MD"|| data==="Manual Proposal MD Approved") {
            	          return '<span style="color: green;">' + data + '</span>';
            	        } else {
            	          return '<span style="color: black;">' + data + '</span>';
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
	    window.location.href = base_url + "/User/ViewReviseManualProposalSendBySI?crno="+crno+"&tid="+tid;
}