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

if(role === "Support_Manager" || role === "Head_Projects"  || role === "MD" || role === "Support") {
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
//  	var serviceUrl = base_url + "/PMS/getOperationalTaskListFirst"; 
  	var serviceUrl = base_url + "/PMS/getRFPTaskListFirst";
  	$("#spin1").show();

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
        		$("#spin1").hide();
             var table = $('#ProjectDetailsCMN').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 7,
                  scrollX:true,
                  scrollY:true,
                  dom: 'Bfrtip', 
      		    buttons: [
          	         {
          	             extend: 'excelHtml5', 
          	             text: 'Excel', 
          	             title: 'Task by Functional Head',  
//          	            exportOptions: {
//                             columns: function (idx, data, node) {
//                                 return idx !== 1;
//                             }
//                         },
          	         }
          	     ],
          	   columnDefs: [
                   {
                 	  targets: '_all', // Apply to all columns
                       createdCell: function (td, cellData, rowData, row, col) {
                           if (col !== 0) { // Exclude the 1st column (index 0)
                               $(td).css('text-align', 'center');
                           }
                       }
                   }
               ]
             });
       
             table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });
	
	
	

     
     var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//   	var serviceUrl = base_url + "/PMS/getOperationalTaskListThird"; 
   	var serviceUrl = base_url + "/PMS/getRFPTaskListThird";
   	
   	$("#spin4").show();

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          success: function(data4) {
        	  $("#spin4").hide();
              var table = $('#ProjectDetailsCMN2').DataTable({
                  lengthChange: false,
                  data: data4,
                   "pageLength": 5,
                   scrollX:true,
                   scrollY:true,
                   dom: 'Bfrtip', 
       		    buttons: [
           	         {
           	             extend: 'excelHtml5', 
           	             text: 'Excel', 
           	             title: 'Task by Solution & Status',  
//           	            exportOptions: {
//                              columns: function (idx, data, node) {
//                                  return idx !== 1;
//                              }
//                          },
           	         }
           	     ],
           	  columnDefs: [
                  {
                	  targets: '_all', // Apply to all columns
                      createdCell: function (td, cellData, rowData, row, col) {
                          if (col !== 0) { // Exclude the 1st column (index 0)
                              $(td).css('text-align', 'center');
                          }
                      }
                  }
              ]
              });
        
              table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

          }

      });
	
	
	    
	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/PMS/getAllRFPTaskList";
	$("#spin3").show();
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
        		$("#spin3").hide();
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
          	             title: 'All RFP Task',  
          	            exportOptions: {
                             columns: function (idx, data, node) {
                                 return idx !== 1;
                             }
                         },
          	         }
          	     ] 
             });
             table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');
         }
     });
      
		    
}


function customizationTaskDetails(crno)
{
//	alert("hih")
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    window.location.href = base_url + "/PMS/ViewAllCustomizationTask?crno="+crno;
	    window.location.href = base_url + "/PMS/ViewRFPTaskDetails?crno="+crno;
}



function getDetailsModalbyCount(mainData , countType) {
//	alert("data : "+mainData+" | countName : "+countType)
	
	if(countType.includes("fHead")) {
		$("#headerSpan").text("Functional Head : "+mainData);
	} else if(countType.includes("date")) {
		$("#headerSpan").text("Date : " +mainData);
	} else if(countType.includes("solution")) {
		$("#headerSpan").text("Solution Name : "+mainData);
	}
	
 	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getDetailsByCount";
    var serviceUrl = base_url + "/PMS/getRFPDetailsByCount";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
    	data: 
        { 	mainData: encodeURIComponent(mainData),
        	countType: countType
        }

    }).done(function(data2) {
//    	alert("niininiii "+data2)
      $('#TaskDetailsByCounts tbody').empty();
      $('#TaskDetailsByCounts').DataTable().clear().destroy();
    	
    	var Sr_no=0;
    	
      if (data2 && data2.length > 0) {
    	 
          data2.forEach(function(project) {
        	  Sr_no = Sr_no+1;
        	  var Srno = Sr_no;
              var fHead = project[0];
              var Desc = project[1];
              var endDate = project[2];
              var manager = project[3];
              var Status = project[4];
              var PendingWith = project[5];
//              var Delay = project[7];

              
              var row = '<tr>' +
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +
              '<td>' + (fHead ? fHead : 'NA') + '</td>' +
              '<td>' + (Desc ? Desc : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (Status ? Status : 'NA') + '</td>' +
              '<td>' + (PendingWith ? PendingWith : 'NA') + '</td>';

//          if (Delay === '0') {
//              row += '<td style="color:green;">' + (Delay ? Delay : '0') + '</td>';
//          } else {
//              row += '<td style="color:red;">' + (Delay ? Delay : '0') + '</td>';
//          }

          row += '</tr>';

          $('#TaskDetailsByCounts tbody').append(row);
      });
      } else {
          $('#TaskDetailsByCounts tbody').append('<tr><td colspan="8">No Activities found</td></tr>');
      }
  });
	$("#TaskModalCounts").modal('show');
}



function getDetailsModal(fHead) {
//	alert(customerName);
	
	$("#fHeadSpan").text(fHead);
	
 	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getOpTaskByCustomer";
    var serviceUrl = base_url + "/PMS/getRFPTaskByHead";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: "customer=" +ecodeURIComponent(customerName),
        data: { fHead: encodeURIComponent(fHead) } // Corrected here

    }).done(function(data2) {
//    	alert("niininiii "+data2)
      $('#TaskDetailsByName tbody').empty();
    	
    	var Sr_no=0;
    	
      if (data2 && data2.length > 0) {
    	 
          data2.forEach(function(project) {
        	  Sr_no = Sr_no+1;
        	  var Srno = Sr_no;
              var Producttool = project[0];
              var Desc = project[1];
              var endDate = project[2];
              var manager = project[3];
              var Status = project[4];
              var PendingWith = project[5];
       
              var row = '<tr>' +
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Desc ? Desc : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (Status ? Status : 'NA') + '</td>' +
              '<td>' + (PendingWith ? PendingWith : 'NA') + '</td>' ;

              row += '</tr>';
          $('#TaskDetailsByName tbody').append(row);
      });
      } else {
//          console.log("No data received");
          $('#TaskDetailsByName tbody').append('<tr><td colspan="7">No Activities found</td></tr>');
      }
  });
	$("#TaskModal").modal('show');
}



function getDetailsBySolution(solution) {
//	alert(solution);
	
	$("#solutionNameSpan").text(solution);
	
 	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getOpTaskBySolution";
    var serviceUrl = base_url + "/PMS/getRFPTaskBySolution";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: { solution: encodeURIComponent(solution) } 

    }).done(function(data2) {
//    	alert("niininiii "+data2)
      $('#TaskDetailsBysoln tbody').empty();
    	
    	var Sr_no=0;
    	
      if (data2 && data2.length > 0) {
    	 
          data2.forEach(function(project) {
        	  Sr_no = Sr_no+1;
        	  var Srno = Sr_no;
              var fHead = project[0];
              var Desc = project[1];
              var endDate = project[2];
              var manager = project[3];
              var Status = project[4];
              var PendingWith = project[5];

              
              var row = '<tr>' +
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +
              '<td>' + (fHead ? fHead : 'NA') + '</td>' +
              '<td>' + (Desc ? Desc : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (Status ? Status : 'NA') + '</td>' +
              '<td>' + (PendingWith ? PendingWith : 'NA') + '</td>' ;

              row += '</tr>';
          $('#TaskDetailsBysoln tbody').append(row);
      });
      } else {
          $('#TaskDetailsBysoln tbody').append('<tr><td colspan="7">No Activities found</td></tr>');
      }
  });
	$("#TaskModalSolution").modal('show');
}



