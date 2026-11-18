var dataPoId = $('#crnoo').val();


var jsonImplFormC = null;
var implName ='';
$('#spin1').hide();
$("#spin2").hide();

var role = $('#roletype').val();
var designation = $('#designation').val();

//alert("R "+role+"  D "+designation);
//if (role === "Developer" && !(designation === "Jr. Team Leader" || designation === "Sr Team Leader" || designation === "Team Leader")) {
//	$('#DeveloperOption').hide();
//	$('#bulkuploaduserform').hide();
//}

if(role === "Support_Manager" || role === "Head_Projects"  || role === "MD" || role === "Support" || role === "Collection_Manager") {
	$('#ViewTask').show();
} else  {
	$('#ViewTask').hide();
}


if(role === "Support_Manager" || role === "Support") {
	$('#customTaskDiv').show();
} else {
	$('#customTaskDiv').hide();
}
 
window.onload = function() {
	
	    
	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/PMS/getClosedCustomTaskList";

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
                  scrollY:true,
                  dom: 'Bfrtip', 
      		    buttons: [
          	         {
          	             extend: 'excelHtml5', 
          	             text: 'Excel', 
          	             title: 'Closed Operational Task',  
//          	            exportOptions: {
//                             columns: function (idx, data, node) {
//                                 return idx !== 1;
//                             }
//                         },
          	         }
          	     ] 
             });
        	 
//        	 var table = $('#productdata').DataTable({
//        		    lengthChange: false,
//        		    data: data4,
//        		    "pageLength": 10 // You can keep this to limit the number of rows per page
//        		});

             table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });
		    
}


function customizationTaskDetails(crno)
{
//	alert("hih")
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    window.location.href = base_url + "/PMS/ViewMyCutomizationTask?crno="+crno;
	    window.location.href = base_url + "/PMS/ViewAllCustomizationTask?crno="+crno;
}









