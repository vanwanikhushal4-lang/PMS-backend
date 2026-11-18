
 window.onload = function() {
	   
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/pendingFORM3Details";
    
	$('#spin12').show();
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {

        	$('#spin12').hide();
             var table = $('#pendingFORM3datatype').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 5,
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
                  }]
             });

         }
     });

 }
 

 
 

 function ApprovedCRF(crno,tid)
 {
 	 var l = window.location;
 	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	    window.location.href = base_url + "/User/ViewpendingFORM3Details?crno="+crno+"&tid="+tid;
 }
 