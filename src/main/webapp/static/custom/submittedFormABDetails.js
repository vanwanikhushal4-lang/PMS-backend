

 window.onload = function() {
   
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/submittedFormABseniorMangDetails";
    
 	$('#spin12').show();
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {

        	 $('#spin12').hide();
             var table = $('#CAApproveddatatype').DataTable({
                 lengthChange: false,
                 pageLength: 5,
                 data: data4,
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
             	      "targets": 2, // Target the second column (index 1, "Status")
             	      "render": function(data, type, row) {
             	        if (data === "Sent For Purchase Order Approval") {
             	        	var data1 = "PO Send By SI";
             	          return '<span style="color: green;">' + data1 + '</span>';
             	        } else if(data === "PO Re-Send By SALES Approval") {
             	        	var data2 = "PO Re-Send By SI";
             	          return '<span style="color: black;">' + data2 + '</span>';
             	        }
             	      }
             	    }
             	  ]
             });

          

         }

     });

 }
 
// function ApprovedCRF(crno,subcategory,status,tid)
// {
//	 var l = window.location;
//	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    window.location.href = base_url + "/CAInitiator/ViewApprovedCrfCADetails?crno="+crno+"&tid="+tid+"&status="+status+"&subcategory="+subcategory;
// }
 
 
 function ApprovedCRF(crno,tid)
 {
 	 var l = window.location;
 	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	    window.location.href = base_url + "/User/ViewSubmittedFormABDetails?crno="+crno+"&tid="+tid;
 }
 