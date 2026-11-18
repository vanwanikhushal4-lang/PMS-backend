

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
	
	getCardCount();
	
	getChartByTeam("F_HEAD");
	getChartByTeam("AM_DM");
	getChartByTeam("TEAM_LEADER");
	
	getTodaysTask();
	getTilltdTask();
	
	getTaskTable1("F_HEAD");
	getTaskTable2("PRODUCTTOOL");
     

	
      var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//     	var serviceUrl = base_url + "/PMS/getRFPTaskListFirst";
   	var serviceUrl = base_url + "/PMS/getProjectsByTL";
     	$("#spin1").show();

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            success: function(data4) {
           	 
           		$("#spin1").hide();
           	 $('#TotalProject').DataTable().clear().destroy();
                var table = $('#TotalProject').DataTable({
                    lengthChange: false,
                    data: data4,
                     "pageLength": 6,
                     scrollX:true,
                     scrollY:true,
//                     dom: 'Bfrtip', 
//         		    buttons: [
//             	         {
//             	             extend: 'excelHtml5', 
//             	             text: 'Excel', 
//             	             title: "Task Till Today",  
//             	         }
//             	     ],
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


function getTilltdTask() {
	var selectedValue = $("#selectedValue").val();
	var getFrom = "web";
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//   	var serviceUrl = base_url + "/PMS/getRFPTaskListFirst";
 	var serviceUrl = base_url + "/PMS/getTillTodayTask";
   	$("#spin22").show();

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          data: 'selectedValue='+selectedValue+'&getFrom='+getFrom,
          success: function(data4) {
         	 
         		$("#spin22").hide();
         		 $('#TillTodayTask').DataTable().clear().destroy();
              var table = $('#TillTodayTask').DataTable({
                  lengthChange: false,
                  data: data4,
                   "pageLength": 5,
                   scrollX:true,
                   scrollY:true,
//                   dom: 'Bfrtip', 
//       		    buttons: [
//           	         {
//           	             extend: 'excelHtml5', 
//           	             text: 'Excel', 
//           	             title: "Task Till Today",  
//           	         }
//           	     ],
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
      
}

function getTodaysTask() {
	
	var selectedValue = $("#selectedValue").val();
	var getFrom = "web";
	
	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//  	var serviceUrl = base_url + "/PMS/getRFPTaskListFirst";
	var serviceUrl = base_url + "/PMS/getTaskByDeveloper";
  	$("#spin11").show();

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'selectedValue='+selectedValue+'&getFrom='+getFrom,
         success: function(data4) {
        	 
        		$("#spin11").hide();
        		 $('#TodaysTaskTable').DataTable().clear().destroy();
        		 
             var table = $('#TodaysTaskTable').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 5,
                  scrollX:true,
                  scrollY:true,
//                  dom: 'Bfrtip', 
//      		    buttons: [
//          	         {
//          	             extend: 'excelHtml5', 
//          	             text: 'Excel', 
//          	             title: "Today's Task",  
//          	         }
//          	     ],
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
	var selectedValue = $("#selectedValue").val();
	
	if(countType.includes("dev")) {
		$("#headerSpan").text("Developer Name : "+mainData);
	} else if(countType.includes("date")) {
		$("#headerSpan").text("Date : " +mainData);
	} else if(countType.includes("solution")) {
		$("#headerSpan").text("Solution Name : "+mainData);
	}
	
 	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getRFPDetailsByCount";
    var serviceUrl = base_url + "/PMS/getRFPTaskByCountDev";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
    	data: 
        { 	mainData: encodeURIComponent(mainData),
        	countType: countType,
        	selectedValue: selectedValue
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
              var developer = project[4];
              var Status = project[5];
              var PendingWith = project[6];
              var Delay = project[7];

              
              var row = '<tr>' +
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +
              '<td>' + (fHead ? fHead : 'NA') + '</td>' +
              '<td>' + (Desc ? Desc : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (developer ? developer : 'NA') + '</td>' +
              '<td>' + (Status ? Status : 'NA') + '</td>' +
              '<td>' + (PendingWith ? PendingWith : 'NA') + '</td>';

          if (Delay === '0') {
              row += '<td style="color:green;">' + (Delay ? Delay : '0') + '</td>';
          } else {
              row += '<td style="color:red;">' + (Delay ? Delay : '0') + '</td>';
          }

          row += '</tr>';

          $('#TaskDetailsByCounts tbody').append(row);
      });
      } else {
          $('#TaskDetailsByCounts tbody').append('<tr><td colspan="8">No Activities found</td></tr>');
      }
  });
	$("#TaskModalCounts").modal('show');
}



function getDetailsModal(developer) {
//	alert(customerName);
	var selectedValue = $("#selectedValue").val();
	
	$("#fHeadSpan").text(developer);
	
 	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getRFPTaskByHead";
    var serviceUrl = base_url + "/PMS/getRFPTaskByDev";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: "customer=" +ecodeURIComponent(customerName),
        data: { developer: encodeURIComponent(developer), selectedValue: selectedValue } // Corrected here

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
              var Delay = project[6];
       
              var row = '<tr>' +
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Desc ? Desc : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (Status ? Status : 'NA') + '</td>' +
              '<td>' + (PendingWith ? PendingWith : 'NA') + '</td>' ;
              
              if (Delay === '0') {
                  row += '<td style="color:green;">' + (Delay ? Delay : '0') + '</td>';
              } else {
                  row += '<td style="color:red;">' + (Delay ? Delay : '0') + '</td>';
              }

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



function getDetailsModalTillDate(developer) {
//	alert(customerName);
	
	$("#fHeadSpan").text(developer);
	
 	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getRFPTaskByHead";
    var serviceUrl = base_url + "/PMS/getRFPTaskByDevTillDate";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: "customer=" +ecodeURIComponent(customerName),
        data: { developer: encodeURIComponent(developer) } // Corrected here

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
              var Delay = project[6];
       
              var row = '<tr>' +
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Desc ? Desc : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (Status ? Status : 'NA') + '</td>' +
              '<td>' + (PendingWith ? PendingWith : 'NA') + '</td>' ;
              if (Delay === '0') {
                  row += '<td style="color:green;">' + (Delay ? Delay : '0') + '</td>';
              } else {
                  row += '<td style="color:red;">' + (Delay ? Delay : '0') + '</td>';
              }

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


function getTaskList(type) {

	var selectedValue = $("#selectedValue").val();
	
	if(type === "total"){
		$("#modalName").text("Total Task");
		$("#thDelayDays").show();
	} else if(type === "delayed") {
		$("#modalName").text("Delayed Task");
		$("#thDelayDays").show();
	} else if(type === "closed") {
		$("#modalName").text("Closed Task");
		$("#thDelayDays").hide();
	} else if(type === "track") {
		$("#modalName").text("On Track Task");
		$("#thDelayDays").hide();
	}
	
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/PMS/getTaskLists";
   	
   	$("#spin4").show();

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          data: 'type='+type+'&selectedValue='+selectedValue,
          success: function(data2) {
        	  $("#spin4").hide();
        	  
        	  $('#TotalTaskModal tbody').empty();
          	
          	
            if (data2 && data2.length > 0) {
          	 
                data2.forEach(function(project) {

                    var fHead = project[0];
                    var Desc = project[1];
                    var endDate = project[2];
                    var teamLeader = project[3];
                    var developer = project[4];
                    var Status = project[5];
                    var PendingWith = project[6];
                    var delayDays =  project[7];
                    
                    var row = '<tr>' +
                    '<td>' + (fHead ? fHead : 'NA') + '</td>' +
                    '<td>' + (Desc ? Desc : 'NA') + '</td>' +
                    '<td>' + (endDate ? endDate : 'NA') + '</td>' +
                    '<td>' + (teamLeader ? teamLeader : 'NA') + '</td>' +
                    '<td>' + (developer ? developer : 'NA') + '</td>' +
                    '<td>' + (Status ? Status : 'NA') + '</td>' +
                    '<td>' + (PendingWith ? PendingWith : 'NA') + '</td>' ;
                    
                    if(type === "delayed" || type === "total") {
                    	row +='<td>' + (delayDays ? delayDays : '0') + '</td>' ;
                    }
                    
                    row += '</tr>';
                $('#TotalTaskModal tbody').append(row);
            });
            } else {
                $('#TotalTaskModal tbody').append('<tr><td colspan="8">No Activities found</td></tr>');
            }
        }
      });
        	  
//        	  $('#TotalTask').DataTable().clear().destroy();
//        	  
//        	  var table = $('#TotalTask').DataTable({
//        		    lengthChange: false,
//        		    data: data4,
//        		    "pageLength": 10,
//        		    scrollX: true,
//        		    scrollY: true,
//        		    dom: 'Bfrtip',
//        		    buttons: [
//        		        {
//        		            extend: 'excelHtml5',
//        		            text: 'Excel',
//        		            title: 'RFP Task',
//        		        }
//        		    ],
//        		    columnDefs: [
//        		        {
//        		            targets: '_all', // Apply to all columns
//        		            createdCell: function (td, cellData, rowData, row, col) {
//        		                if (col !== 0) { // Exclude the 1st column (index 0)
//        		                    $(td).css('text-align', 'center');
//        		                }
//        		            }
//        		        },
//        		        {
//        		            targets: [0, 1, 2, 3, 4, 5, 6], // Targeting all columns
//        		            width: 'auto', // Adjust column width automatically
//        		        }
//        		    ],
//        		    fixedHeader: true // Fix the header while scrolling
//        		});
//
//              table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');
//          }
//      });
      $("#TotalTaskModal").modal('show');
      
}


function getCardCount() {
	
	var selectedValue = $("#selectedValue").val();
	
	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getRFPCardCounts";
  	$("#spin1").show();

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'selectedValue='+selectedValue,
         success: function(data4) {
//        	 alert("data "+data4)
        	 $("#totalCount").text(data4[0]);
        	 $("#delayedCount").text(data4[1]);
        	 $("#closedCount").text(data4[2]);
        	 $("#onTrackCount").text(data4[3]);
         }
     });
}


function changeValue(value) {
	getCardCount();
	
	getTodaysTask();
	getTilltdTask();
}


document.getElementById('exportPDF').addEventListener('click', () => {
    const { jsPDF } = window.jspdf;
    const doc = new jsPDF('l', 'pt', 'a4');

    // Extract table data manually
    const table = document.querySelector('#TotalTask');
    const headers = Array.from(table.querySelectorAll('thead th')).map(th => th.innerText);
    const rows = Array.from(table.querySelectorAll('tbody tr')).map(tr =>
        Array.from(tr.querySelectorAll('td')).map(td => td.innerText)
    );

    // Add table to PDF
    doc.autoTable({
        head: [headers],
        body: rows,
        margin: { top: 40 },
        styles: { 
            overflow: 'linebreak', 
            fontSize: 10, 
            cellPadding: 5 
        },
        headStyles: { fillColor: [128, 128, 128] }, // Custom header color
    });

    doc.save('RFP_Task.pdf');
});


document.getElementById('exportExcel').addEventListener('click', () => {
	    const wb = XLSX.utils.table_to_book(document.getElementById('TotalTask'));
	    XLSX.writeFile(wb, 'RFP_Task.xlsx');
	});
	
	
	$('#searchBoxAct').on('keyup', function() {
var value = $(this).val().toLowerCase();
$('#TotalTask tbody tr').filter(function() {
    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
});
});
	
	
	
	function getTaskTable1(tableName) {
		var getFrom = "web";
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/PMS/getSolutionwiseTeam"; 
		var serviceUrl = base_url + "/PMS/getTaskCount"; 
		$('#spin1').show();

		$.ajax({
		    type: 'POST',
		    url: serviceUrl,
		    dataType: 'json', 
			data: "tableName=" +tableName + '&getFrom=' + getFrom,
		    success: function(data) {
		    	
		        $('#spin1').hide();
		        console.log("data5 :: " + JSON.stringify(data));

		        // Destroy and reinitialize DataTable if it already exists
                if ($.fn.DataTable.isDataTable("#funTask")) {
                    $("#funTask").DataTable().clear().destroy();
                }

                var table = $("#funTask").DataTable({
                    lengthChange: false,
                    pageLength: 5,
                    data: data,  // Assuming `data` is an array of objects
                    scrollX: true,
                    columns: [
                        { data: 'name' }, 
                        { data: 'total' },
                        { data: 'completed' },
                        { data: 'pending' }
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
            },
            error: function(xhr, status, error) {
                // Hide the spinner if there is an error
                $('#spin11').hide();
                console.error("Error fetching data: ", error);
            }
        });
	}
	
	
	

	function getTaskTable2(tableName) {
		var getFrom = "web";
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/PMS/getSolutionwiseTeam"; 
		var serviceUrl = base_url + "/PMS/getTaskCount"; 
		$('#spin1').show();

		$.ajax({
		    type: 'POST',
		    url: serviceUrl,
		    dataType: 'json', 
		    data: "tableName=" +tableName + '&getFrom=' + getFrom,
		    success: function(data) {
//		    	alert(data5);
		    	
		        $('#spin1').hide();
		        console.log("data5 :: " + JSON.stringify(data));

		        if ($.fn.DataTable.isDataTable("#solnTask")) {
                    $("#solnTask").DataTable().clear().destroy();
                }

                var table = $("#solnTask").DataTable({
                    lengthChange: false,
                    pageLength: 5,
                    data: data,  // Assuming `data` is an array of objects
                    scrollX: true,
                    columns: [
                        { data: 'name' },
                        { data: 'total' },
                        { data: 'completed' },
                        { data: 'pending' }
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
            },
            error: function(xhr, status, error) {
                // Hide the spinner if there is an error
                $('#spin1').hide();
                console.error("Error fetching data: ", error);
            }
        });
	}

	
	
	

	function getChartByTeam(chart) {
		var chartName = "";
		
		if(chart === "F_HEAD"){
			chartName= "containerDiv1";
		} else if( chart === "AM_DM") {
			chartName ="containerDiv2" ;
		} else if(chart === "TEAM_LEADER") {
			chartName ="containerDiv3";
		}
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getTeamChart";

		
		$('#spin2').show();

		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			data: "chartName=" +chart,
			success : function(data4) {
				$('#spin2').hide();
//				alert("data4 :: "+data4);
//				console.log("datttaa :: "+data4)
				
				var response = data4;
				
	   if(response != "") {
		   
//		   $("#solSelectDiv").show();
		
		Highcharts.chart(chartName, {
		    chart: {
		        type: 'column'
		    },
		    title: {
		        text: ''
		    },

		    xAxis: {
		        categories: response[0],
		        title: {
		            text: 'Phase',
		            align: 'middle'
		        },
		        gridLineWidth: 1,
		        lineWidth: 0
		    },
		    yAxis: {
		        min: 0,
		        title: {
		            text: 'Solution Counts',
		            align: 'middle'
		        },
		        labels: {
		            overflow: 'justify'
		        },
		        gridLineWidth: 0
		    },
		    tooltip: {
		        valueSuffix: ' Project'
		    },
		    plotOptions: {
		        column: {
	// borderRadius: '50%',
		            dataLabels: {
		                enabled: true,
//		                format: '{point.y}'
		                formatter: function() {
		                    return this.y !== 0 ? this.y : '';
		                }
		            },
		            groupPadding: 0.1
		        }
		    },
		    legend: {
		        layout: 'horizontal',
		        align: 'right',
		        verticalAlign: 'top',
//		        horizontalAlign: 'top',
		        x: 2,
		        y: -10,
		        floating: false,
		        borderWidth: 1,
		        backgroundColor: 
		        	Highcharts.defaultOptions.legend.backgroundColor || '#FFFFFF',
		        shadow: true
		    },
		   
		    credits: {
		        enabled: false
		    },
		    series: 
		    	response[1]
		});
//		containerDiv.style.height = '420px';
			} else {
//				containerDiv.style.height = '320px';
	//
//				var noDataMessage = document.createElement('h6');
//				noDataMessage.textContent = 'No data available';
	//
//				containerDiv.innerHTML = '';  
//				containerDiv.style.display = 'flex';  
//				containerDiv.style.flexDirection = 'column'; 
//				containerDiv.style.alignItems = 'center';  
//				containerDiv.style.justifyContent = 'flex-start'; 
//				containerDiv.style.textAlign = 'center';  
//				noDataMessage.style.marginTop = '20px';
//				containerDiv.appendChild(noDataMessage);
			}	
			},
	        error: function(xhr, status, error) {
	            console.error("AJAX error:", status, error);
	        }
				
		});
	}

	
	

	function getDetailsModal1(fHName) {
//		alert(fHName);
		$("#TaskModalss").modal('show');
		var type = "fh";
		$("#nameSpan1").text(fHName);
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		// var serviceUrl = base_url + "/PMS/getOpTaskByCustomer"; 
		var serviceUrl = base_url + "/PMS/getTaskByName"; 

		$.ajax({
		    url: serviceUrl,
		    type: 'POST',
		    dataType: 'json',
		    data: { selectedName: encodeURIComponent(fHName), type: type }
		}).done(function(data2) {

		    $('#TaskDetailsByName1 tbody').empty(); // Clear existing data

		    var Sr_no = 0;
		    
		    if (data2 && data2.length > 0) {
		        data2.forEach(function(project) {
		            Sr_no = Sr_no + 1;
		            var Srno = Sr_no;
		            var Producttool = project.name;
		            var Desc = project.description;
		            var Manager = project.manager;
		            var Status = project.status;
		            var targetDate = project.targetDate;
		            var Dev = project.pending;

		            var row = '<tr>' +
		                '<td>' + (Srno ? Srno : 'NA') + '</td>' +
		                '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
		                '<td>' + (Desc ? Desc : 'NA') + '</td>' +
		                '<td>' + (Manager ? Manager : 'NA') + '</td>' +
		                '<td>' + (Status ? Status : 'NA') + '</td>' +
		                '<td>' + (targetDate ? targetDate : 'NA') + '</td>' +
		                '<td>' + (Dev ? Dev : 'NA') + '</td>' +
		                '</tr>';
		                
		            $('#TaskDetailsByName1 tbody').append(row);
		        });
		    } else {
		        // Display message if no data is found, ensure colspan matches the number of columns
		        $('#TaskDetailsByName1 tbody').append('<tr><td colspan="6">No Activities found</td></tr>');
		    }
		});
		$("#TaskModal1").modal('show');
	}




	function getDetailsBySolution1(solution) {
//		alert(solution);
		var type = "solution";
		
		$("#solutionNameSpan1").text(solution);
		
	 	var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    var serviceUrl = base_url + "/PMS/getOpTaskByCustomer";
	    var serviceUrl = base_url + "/PMS/getTaskByName";

	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: { selectedName: encodeURIComponent(solution), type: type } 

	    }).done(function(data2) {
//	    	alert("niininiii "+data2)
	      $('#TaskDetailsBysoln1 tbody').empty();
	    	
	      var Sr_no = 0;

		    if (data2 && data2.length > 0) {
		        data2.forEach(function(project) {
		            Sr_no = Sr_no + 1;
		            var Srno = Sr_no;
		            var Producttool = project.name;
		            var Desc = project.description;
		            var Manager = project.manager;
		            var Status = project.status;
		            var targetDate = project.targetDate;
		            var Dev = project.pending;

		            var row = '<tr>' +
		                '<td>' + (Srno ? Srno : 'NA') + '</td>' +
		                '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
		                '<td>' + (Desc ? Desc : 'NA') + '</td>' +
		                '<td>' + (Manager ? Manager : 'NA') + '</td>' +
		                '<td>' + (Status ? Status : 'NA') + '</td>' +
		                '<td>' + (targetDate ? targetDate : 'NA') + '</td>' +
		                '<td>' + (Dev ? Dev : 'NA') + '</td>' +
		                '</tr>';

	          $('#TaskDetailsBysoln1 tbody').append(row);
	      });
	      } else {
	          $('#TaskDetailsBysoln1 tbody').append('<tr><td colspan=7">No Activities found</td></tr>');
	      }
	  });
		$("#TaskModalSolution1").modal('show');
	}