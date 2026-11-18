var SR_NO = "";
var Cname = "";
var Module = "";
var Desc = "";
var Output= "";


var roleType = $("#role").val();

window.onload = function() {
	
	
	if(roleType === "Implementor") {
		$("#managerTH").hide(); 
		$("#ManagerTable").show();
		getCustomTaskListMgr();
		getAssignByMGR();
	} else {
		$("#TLTable").show();
		$("#managerDateTH").hide();
		getCustomTaskListTL();
		getAssignByTL();
	}
	    	
}


function getAssignByMGR() {
	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//  	var serviceUrl = base_url + "/PMS/getCustomTaskData";
  	var serviceUrl = base_url + "/PMS/getCustomTaskDataByMGR";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//             var table = $('#productdata').DataTable({
//                 lengthChange: false,
//                 data: data4,
//                  "pageLength": 10,
//                  scrollX:true,
//                  scrollY:true
//             });
        	 

//        	 var table = $('#productdata').DataTable({
//        	     lengthChange: false,
//        	     data: data4,
//        	     pageLength: 10,
//        	     scrollX: true,
//        	     scrollY: true,
//        	     autoWidth: false,
//        	     dom: 'Bfrtip', // This defines where the buttons should appear (B = buttons)
//        	     buttons: [
//        	         {
//        	             extend: 'excelHtml5', // This is the Excel export button
//        	             text: 'Export to Excel', // The text on the button
//        	             title: 'Operational Task Assigned By Me',  // The title for the Excel file
//                           exportOptions: {
//                           columns: function (idx, data, node) {
//                               // Exclude the first column ("View" column) dynamically
//                               return idx !== 1;
//                           }
//                       },
//        	         }
//        	     ], 
//        	     columnDefs: [
//                   {
//                   targets: '_all', 
//                   width: 'auto', 
//                   orderable: false
//                   }
//                ],
//        	     
//        	 });
        	 
        	 
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
           	             title: 'Operational Task',  
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

function getAssignByTL() {
	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//  	var serviceUrl = base_url + "/PMS/getCustomTaskData";
  	var serviceUrl = base_url + "/PMS/getCustomTaskData";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//             var table = $('#productdataTL').DataTable({
//                 lengthChange: false,
//                 data: data4,
//                  "pageLength": 10,
//                  scrollX:true,
//                  scrollY:true
//             });
        	 
        	  var table = $('#productdataTL').DataTable({
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
           	             title: 'Operational Task',  
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

function getCustomTaskListMgr() {
//	alert("dgf");
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getReassignTaskSideDetails";  
    var serviceUrl = base_url + "/PMS/getCustomTaskList";  


    $('#spin12').show(); 

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',

    }).done(function(data2) {
    	 $('#spin12').hide(); 
//    	alert("niininiii "+data2)

      $('#DevDelaysTableDetails tbody').empty();
    	
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
        	  var Srno = project[0]; 
        	  var Customername = project[1];
        	  var productSuite_Tool = project[2]; 
        	  var ModuleName = project[3]; 
        	  var ExpectedDate = project[4]; 
        	  var Customization = project[5]; 
        	  var ExpectedOutput = project[6]; 
        	  var ReportedBy = project[7]; 
        	  var AssignTo = project[8]; 
        	  var plannedDate = project[9]; 
        	  var addButton = project[10]; 
        	  var id = project[11]; 
            
              
        	  var row = '<tr>' +
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +  // Serial Number
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +  // Customer Name
              '<td>' + (productSuite_Tool ? productSuite_Tool : 'NA') + '</td>' +  // Product Suite Tool
              '<td>' + (ReportedBy ? ReportedBy : 'NA') + '</td>' +  // Reported By
              '<td>' + (ExpectedDate ? ExpectedDate : 'NA') + '</td>' +  // Expected Date
              '<td>' + (ModuleName ? ModuleName : 'NA') + '</td>' +  // Module Name
              '<td>' + (Customization ? Customization : 'NA') + '</td>' +  // Customization
              '<td>' + (ExpectedOutput ? ExpectedOutput : 'NA') + '</td>' +  // Expected Output
              '<td>' + (AssignTo ? AssignTo : 'NA') + '</td>' +  // Assign To
              '<td>' + (plannedDate ? plannedDate : 'NA') + '</td>' +  // Assign To
              '<td>' + (addButton ? addButton : 'NA') + '</td>' +  // Assign To
          '</tr>';
          $('#DevDelaysTableDetails tbody').append(row);
          
//          var rowExpand = "<tr id='hidden_row"+id+"' class='hidden_row' style='display:none;'><td colspan='11'>inner table</td></tr>"
//        	  $('#DevDelaysTableDetails tbody').append(rowExpand);
      
      });
          $('#sub').show();
      } else {
          $('#DevDelaysTableDetails tbody').append('<tr><td colspan="11" style="text-align:center; background-color:#f0f5f5;">No Activities Found</td></tr>');
      }
  });
}



function addRow(srno, customer,module, desc, output){
	
	
	 $("#modelcategory1").modal("show");
	 
	 if(roleType === "Implementor") {
		 $("#pDateTH").show();
		 $("#addRowDate").show();
		 
	 } else {
		 $("#pDateTH").hide();
		 $("#addRowDate").hide();
	 }
	 
	 $("#sr_no1").val(srno);
	 $("#customerName").val(customer);
//	 $("#moduleName").val(decodeURIComponent(module.replace(/\+/g, ' ')));
//	 $("#descriptions").val(decodeURIComponent(desc.replace(/\+/g, ' ')));
//	 $("#expectedOut").val(decodeURIComponent(output.replace(/\+/g, ' '))); 
	 $("#moduleName").val(module);
	 $("#descriptions").val(desc);
	 $("#expectedOut").val(output);

	 $("#CustomerName").val(customer);
//	 $("#ModuleName").val(decodeURIComponent(module.replace(/\+/g, ' ')));
//	 $("#Description").val(decodeURIComponent(desc.replace(/\+/g, ' ')));
//	 $("#ExOutput").val(decodeURIComponent(output.replace(/\+/g, ' ')));
	 $("#ModuleName").val(module);
	 $("#Description").val(desc);
	 $("#ExOutput").val(output);

	 
	 	
	 	var l = window.location;
	   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   var serviceUrl = base_url + "/PMS/getAllDeveloperList";

	   $.ajax({
	       type: 'POST',
	       url: serviceUrl,
	       dataType: 'json',
	       success: function(data4) {
//	       	 alert(data4);
	           var html = "<option value=''>-- Please Select --</option><option value='Self'>Self</option>";
	           for (var i = 0; i < data4.length; i++) {
	               var value = data4[i];
	               html += '<option value="' + value + '">' + value + '</option>';
	           }
	           $("#Developers").html(html);
	          }
	   });	

//	   $('#rowTable tbody tr').remove();
	   $('#rowTable tbody tr').not(':first').remove();


}

function getCustomTaskListTL() {
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getReassignTaskSideDetails";  
    var serviceUrl = base_url + "/PMS/getCustomTaskList";  


    $('#spin12').show(); 

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',

    }).done(function(data2) {
    	 $('#spin12').hide(); 
//    	alert("niininiii "+data2)

      $('#DevDelaysTableDetails tbody').empty();
    	
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
            
         	  var Srno = project[0]; 
        	  var Customername = project[1];
        	  var productSuite_Tool = project[2]; 
        	  var ModuleName = project[3]; 
        	  var ExpectedDate = project[4]; 
        	  var Customization = project[5]; 
        	  var ExpectedOutput = project[6]; 
        	  var ReportedBy = project[7]; 
        	  var AssignTo = project[8]; 
        	  var plannedDate = project[9]; 
        	  var addButton = project[10]; 
        	  var id = project[11]; 
              
              var row = '<tr>' +
              
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +  // Serial Number
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +  // Customer Name
              '<td>' + (productSuite_Tool ? productSuite_Tool : 'NA') + '</td>' +  // Product Suite Tool
              '<td>' + (ReportedBy ? ReportedBy : 'NA') + '</td>' +  // Reported By
              '<td>' + (ExpectedDate ? ExpectedDate : 'NA') + '</td>' +  // Expected Date
              '<td>' + (ModuleName ? ModuleName : 'NA') + '</td>' +  // Module Name
              '<td>' + (Customization ? Customization : 'NA') + '</td>' +  // Customization
              '<td>' + (ExpectedOutput ? ExpectedOutput : 'NA') + '</td>' +  // Expected Output
              '<td>' + (AssignTo ? AssignTo : 'NA') + '</td>' +  // Assign To
              '<td>' + (plannedDate ? plannedDate : 'NA') + '</td>' +  // Assign To
              '<td>' + (addButton ? addButton : 'NA') + '</td>' +  // Assign To
          '</tr>';
          $('#DevDelaysTableDetails tbody').append(row);

      });
          $('#sub').show();
      } else {
//          console.log("No data received");
          $('#DevDelaysTableDetails tbody').append('<tr><td colspan="11" style="text-align:center; background-color:#f0f5f5;">No Activities Found</td></tr>');  
      }
  });
}


		 //////////     Checkbox      /////////////////

//var checkedCheckboxes = [];
//var checkAllCheckbox = document.getElementById('checkAll');
//var checkboxes = document.getElementsByName('taskCheckBoxes');
//
//function updateCheckedCheckboxes() {
//    checkedCheckboxes = [];
//    checkboxes.forEach(function(checkbox) {
//        if (checkbox.checked) {
////            alert(" id :" + checkbox.id);
////            alert(" date :" + $('#date'+checkbox.id).val());
//            checkedCheckboxes.push(checkbox.id);
//        }
//    });
//    console.log(checkedCheckboxes);
//}
//
//checkAllCheckbox.addEventListener('change', function() {
//    checkboxes.forEach(function(checkbox) {
//        checkbox.checked = checkAllCheckbox.checked;
//    });
//    updateCheckedCheckboxes(); 
//});
//
//checkboxes.forEach(function(checkbox) {
//    checkbox.addEventListener('change', function() {
//        updateCheckedCheckboxes();
//    });
//});
//
//
//
//function checkIndividual() {
//	 updateCheckedCheckboxes();
//}




var selectedNames = [];

function getClickDevelopers(srno) {
    var updatedName = $("#Developer" + srno).val(); 
//    alert(updatedName)
    if (updatedName && updatedName.trim() !== "") {
    	var idNameGroup = [];

    	idNameGroup.push(srno); 
    	idNameGroup.push(updatedName);
    }
    selectedNames.push(idNameGroup);
    console.log("selectedNames"+selectedNames)
}



function reassignTask() {
//    console.log("Selected dates:", checkedCheckboxes);
//    alert("Selected dates: " + JSON.stringify(checkedCheckboxes));

	

//	alert("gdfsf")
	    swal({
	        title: "Are you sure?",
	        text: "You want to Assign Task?",
	        type: "warning",
	        width: 350,
	        height: 200,
	        showCancelButton: !0,
	        confirmButtonClass: "btn btn-success",
	        cancelButtonClass: "btn btn-danger m-l-10",
	        confirmButtonText: "Yes!"
	    }).then(function() {
//	          alert("deleteUserdddddddd")
	          
//	          alert("Selected dates: " + JSON.stringify(checkedCheckboxes));
	        var l = window.location;
	    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    	var serviceUrl = base_url + "/PMS/reassinTaskToDeveloper";
	    	var serviceUrl = base_url + "/PMS/assignCustomTaskToDeveloper";
	    	$('#spin2').show();
	    	$.ajax({
	    		type : 'POST',
	    		url : serviceUrl,
	    		data: "selectedNames=" + selectedNames + '&updatedDates=' + selectedDates 

	        }).done(function(data) {
	            //  alert("dfgsfd"+data)

	            if (data == "success") {
	                swal({
	                    title: "Successful!",
	                    text: "Task Assign Successfully",
	                    type: "success",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/AssignCustomizationTask";
	                    }

	                })

	            }

	            else if (data == "error") {
	                swal({
	                    title: "Failed!",
	                    text: "Fail to Assign Task",
	                    type: "error",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/AssignCustomizationTask";
	                    }

	                })

	            }   else if (data == "incompleteData") {
	                swal({
	                    title: "Failed!",
	                    text: "Fail to Assign Task, Please update both Assigned To and Planned Date",
	                    type: "error",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/AssignCustomizationTask";
	                    }

	                })

	            }
	        });
	    })
	

	
}



function getDevelopers(getdevid){
//	alert("getdevid"+getdevid);
	
	var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getAllDeveloperList";
  var selectedValue = $("#Developer"+getdevid).val(); // Get the currently

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data4) {
//      	 alert(data4);
          var html = "<option value=''>-- Please Select --</option><option value='Self'>Self</option>";
          for (var i = 0; i < data4.length; i++) {
              var value = data4[i];
              html += '<option value="' + value + '">' + value + '</option>';
          }
          $("#Developer"+getdevid).html(html); // Update the select element
          $("#Developer"+getdevid).val(selectedValue); // Set the selected value 
         }
  });	

}




var selectedDates = [];

function getDateId(srno) {
    var updatedDate = $("#date" + srno).val(); 

    if (updatedDate && updatedDate.trim() !== "") {
    	var idDateGroup = [];
//        var dateObject = {
//            srno: srno,
//            date: updatedDate
//        };
//        selectedDates.push(dateObject);
    	idDateGroup.push(srno); 
    	idDateGroup.push(updatedDate);
    }
    selectedDates.push(idDateGroup);
}







////////////////////////////          Add Row       ////////////////////////////////////////






function addRowData() {

    const tableBody = document.querySelector("#rowTable tbody");
    const newRow = tableBody.insertRow();
    
    // Text inputs   
    //  Customer name
    const cellCname = newRow.insertCell();
    const inputCname = document.createElement('input');
    inputCname.type = 'text';
    inputCname.classList.add('form-control', 'form-control-sm');
    inputCname.id = 'CustomerName'; 
    inputCname.placeholder = 'Customer Name';
    inputCname.value =  $("#customerName").val();
    inputCname.readOnly = true;
    cellCname.appendChild(inputCname);
    
    //    	input 1
    const cell1 = newRow.insertCell();
    const input1 = document.createElement('input');
    input1.type = 'text';
    input1.classList.add('form-control', 'form-control-sm');
    input1.id = 'ModuleName'; 
    input1.placeholder = 'Enter Your Module';
    input1.value = $("#moduleName").val();
    cell1.appendChild(input1);
    
    //    	input 2
    const cell2 = newRow.insertCell();
    const input2 = document.createElement('input');
    input2.type = 'text';
    input2.classList.add('form-control', 'form-control-sm');
    input2.id = 'Description'; 
    input2.placeholder = 'Enter Description';
    input2.value = $("#descriptions").val();
    cell2.appendChild(input2);
    
    
    //    	input 3
    const cell3 = newRow.insertCell();
    const input3 = document.createElement('input');
    input3.type = 'text';
    input3.classList.add('form-control', 'form-control-sm');
    input3.id = 'ExOutput'; 
    input3.placeholder = 'Enter Expected Output';
    input3.value = $("#expectedOut").val();
    cell3.appendChild(input3);

    
    // Dropdown cell 1
    const dropdownCell1 = newRow.insertCell();
    const dropdown1 = document.createElement('select');
    dropdown1.id = 'Developers';
    dropdown1.classList.add('form-control', 'form-control-sm');
    populateDropdownDevelopers(dropdown1);
    dropdownCell1.appendChild(dropdown1);

 if(roleType === "Implementor") {
    // Input 2 Planned Date
    const cell4 = newRow.insertCell();
    const input4 = document.createElement('input');
    input4.type = 'date';
    input4.classList.add('form-control','pull-right', 'form-control-sm');
    input4.id = 'PlannedDate'; 
    cell4.appendChild(input4);
 }
 
 // Delete cell
    const deleteCell = newRow.insertCell();
    const deleteButton = document.createElement('button');
    deleteButton.type = 'button';
    deleteButton.classList.add('btn');

    // Create the icon element
    const trashIcon = document.createElement('i');
    trashIcon.classList.add('fa-solid', 'fa-trash-can', 'fa-lg');
    trashIcon.style.color = '#fd4444';
    trashIcon.style.marginLeft = '5px';
//    trashIcon.placeholder = 'Delete';
    deleteButton.appendChild(trashIcon);

    deleteButton.onclick = function () {
        deleteRow(this); // Pass the button itself as an argument
    };
    deleteCell.appendChild(deleteButton);

}


function deleteRow(button) {
    var rowToDelete = $(button).closest('tr');

    if ($('#rowTable tbody tr').length > 1) {
        rowToDelete.remove();
    } 
}

// Populate dropdowns
function populateDropdownDevelopers(dropdown) {
	
	var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/PMS/getAllDeveloperList";

	  $.ajax({
	      type: 'POST',
	      url: serviceUrl,
	      dataType: 'json',
	      success: function(data4) {
//	      	 alert(data4);
	          var html = "<option value=''>-- Please Select --</option><option value='Self'>Self</option>";
	          for (var i = 0; i < data4.length; i++) {
	              var value = data4[i];
	              html += '<option value="' + value + '">' + value + '</option>';
	          }
	          dropdown.innerHTML = html;
	         }
	  });	
}



//Add Day wise Task Details
function saveCustomTask() { 
const tableBody = document.querySelector("#rowTable tbody");
const rows = tableBody.querySelectorAll('tr');
const dataArray = [];

for (const row of rows) {
  const inputs = row.querySelectorAll('input');
  const selects = row.querySelectorAll('select'); 
  
//alert(selects[0].value);
  var dataObj = null;
  
  if(roleType === "Implementor") {
	  for (const input of inputs) {
	      if (input.value.trim() === '' ) {
	          alert('Input fields are empty. Please fill them out.');
	          return; // Exit the function if any input is empty
	      }
	  }
	  
	  dataObj = {
		      id:  $("#sr_no1").val(),
		      customer: inputs[0].value,
		      moduleName: inputs[1].value.replace(/[&'"\[\]]/g, '').trim(),
		      description: inputs[2].value.replace(/[&'"\[\]]/g, '').trim(),
		      exOutput: inputs[3].value.replace(/[&'"\[\]]/g, '').trim(),
		      developer: selects[0].value,
		      planneddate: inputs[4].value,
		  };
	  
  } else {
//	  alert("in else")
	  
	  for (let i = 0; i < inputs.length-1; i++) {
//		  alert("ab "+JSON.stringify(inputs[i].value))
		    const input = inputs[i];
		    if ( input.value.trim() === '') {  // i !== 3 &&
		        alert('Input fields are empty. Please fill them out.');
		        return; 
		    }
		}
	  
	  dataObj = {
		      id:  $("#sr_no1").val(),
		      customer: inputs[0].value,
		      moduleName: inputs[1].value.replace(/[&'"\[\]]/g, '').trim(),
		      description: inputs[2].value.replace(/[&'"\[\]]/g, '').trim(),
		      exOutput: inputs[3].value.replace(/[&'"\[\]]/g, '').trim(),
		      developer: selects[0].value,
//		      planneddate: inputs[4].value,
		  };
  }

  for (const select of selects) {
	    if (select.value.trim() === '') {
	        alert('Please select Assign to value.');
	        return; 
	    }
	}


 
  dataArray.push(dataObj);
 
}


var taskData = JSON.stringify(dataArray);
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//var serviceUrl = base_url + "/PMS/saveDayWiseTask";
var serviceUrl = base_url + "/PMS/saveCustomTaskAddRow";

$('#spin22').show();
$.ajax({
	type : 'POST',
	url : serviceUrl,
	data: "taskData=" + taskData,

	success : function(data) {
		$('#spin22').hide();
		if (data == "success") {
			swal({
				title : "Successful!",
				text : "Record Inserted Successfully",
				type : "success",
				width : 300,
				height : 200,
				// showCancelButton: false,
				// confirmButtonClass: "btn btn-danger",
				// cancelButtonClass: "btn btn-danger m-l-10",
				// confirmButtonText: "OK",
				buttons : false,
				allowOutsideClick : false,
				preConfirm : function() {
					var l = window.location;
					var base_url = l.protocol + "//" + l.host + "/"
							+ l.pathname.split('/')[1];
					window.location.href = base_url
							+ "/Admin/AssignCustomizationTask";
				}
			});
		} else if (data == "duplicate") {
			swal({
				title : "Duplicate Data!",
				text : "Record Already Exists",
				type : "warning",
				width : 300,
				height : 200,
				buttons : false,
				allowOutsideClick : false,
				preConfirm : function() {
					var l = window.location;
					var base_url = l.protocol + "//" + l.host + "/"
							+ l.pathname.split('/')[1];
					window.location.href = base_url
							+ "/Admin/AssignCustomizationTask";
				}

			});

		} else if (data == "error") {
			swal({
				title : "Unsuccessful!",
				text : "Fail to add file",
				type : "success",
				width : 300,
				height : 200,
				buttons : false,
				allowOutsideClick : false,
				preConfirm : function() {
					var l = window.location;
					var base_url = l.protocol + "//" + l.host + "/"
							+ l.pathname.split('/')[1];
					window.location.href = base_url
							+ "/Admin/AssignCustomizationTask";
				}

			});

		}
	}
});
}


function EditOpTask(srno,customerName,ProdTool,Description,Status, TL,Developer,Tester,Date, fullname) {
//	alert(TL+"::Developer "+Developer);
	
	  var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getDevelopers";
	//   	alert($('#updImplementerName').val())
	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          success: function(data2) {
	          //    //("burger"+data2)
	         	 var html = "<option value=''> -- Please Select --</option><option value='"+fullname+"'>Self</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("developerUpdate2").innerHTML = html;
	 			
	 			if(Developer==="" || Developer==="null") {
	 				$("#developerUpdate2").val(TL);
	 			} else {
	 				$("#developerUpdate2").val(Developer);
	 			}
	 			 
	 		}
	 	});
	
	
	
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////	var serviceUrl = base_url + "/Master/getTesterList"; 
//	var serviceUrl = base_url + "/PMS/getAllDeveloperList"; 
//
//	$.ajax({
//		type : 'POST',
//		url : serviceUrl,
//		dataType : 'json',
//		success : function(data4) {
//
//			var html = "<option value=''>-- Please Select --</option>";
//			for (var i = 0; i < data4.length; i++) {
//				var value = data4[i];
//				html += '<option value="' + value + '">' + value + '</option>';
//			}
////			html += "<option value='Other'>Other</option>";
//			$("#testerName2").html(html);
//			$("#testerName2").val(Tester);
//		}
//	});
	      
	      
	  	var html = "<option value=''>-- Please Select --</option><option value='"+fullname+"'>Self</option>"; // Initialize dropdown with default options

		// Get base URL
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];

		// Fetch Tester Name List
		var testerUrl = base_url + "/Master/getTesterList";
		$.ajax({
		    type: 'POST',
		    url: testerUrl,
		    dataType: 'json',
		    success: function(data4) {
		        // Append Tester options to dropdown
		        for (var i = 0; i < data4.length; i++) {
		            var value = data4[i];
		            html += '<option value="' + value + '">' + value + '</option>';
		        }
		        // Now fetch Developer list
		        var developerUrl = base_url + "/PMS/getAllDeveloperList";
		        $.ajax({
		            type: 'POST',
		            url: developerUrl,
		            dataType: 'json',
		            success: function(data4) {
		                // Append Developer options to dropdown
		                for (var i = 0; i < data4.length; i++) {
		                    var value = data4[i];
		                    html += '<option value="' + value + '">' + value + '</option>';
		                }
		                // Finally, update the dropdown
		                $("#testerName2").html(html);
		                $("#testerName2").val(Tester);
		            },
		            error: function() {
		                console.error("Error fetching developer list");
		            }
		        });
		    },
		    error: function() {
		        console.error("Error fetching tester list");
		    }
		});

	

	   $("#sr_no2").val(srno);
 $("#customerNameUpdate2").val(customerName);
 $("#securityToolUpdate2").val(ProdTool);
 Description = Description.replace(/%93/g, '%22').replace(/%94/g, '%22');
 document.getElementById('descripIssue').value = decodeURIComponent(Description.replace(/\+/g, ' '));
// $("#TLUpdate2").val(TL);
 
 if(Status === "Assigned" || Status === "Re-Open" || Status === "Tested") {
	 
	 $("#developerUpdate2Div").show();
	 $("#testerName2RO").val(Tester);
	 $("#testerName2Div").hide();
 
 } else { 
	 $("#testerName2Div").show();
//	 $("#developerUpdate2ROdiv").show();
	 $("#developerUpdate2Div").hide();

	 $("#developerUpdate2RO").val(Developer);
 }
 
 
 $("#plannedDate2").val(Date);
 $("#StatusRO").val(Status);
 
// if(Status != "Closed" ) {
//	   $("#modelcategory2").modal("show");	   	   
// }   
 
 if (!(Status === "Close" || Status === "Ready to Deliver" )) {
	    $("#modelcategory2").modal("show");
	} else {
		swal({
			title : "Unable to Update!",
			text : "Records with a status of 'Closed' or 'Ready to Deliver' cannot be updated.",
			type : "warning",
			width : 300,
			height : 200,
			buttons : false,
			allowOutsideClick : false,

		});
	}
 
}


function updateTask() {

	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/Master/updateClientMaster";
	var serviceUrl = base_url + "/PMS/updateOpTask";
 	
 	 $.ajax({
         type: 'POST',
         url: serviceUrl, 
         data: 'srno=' + $("#sr_no2").val()
         		+ '&developer=' + $("#developerUpdate2").val()
         		+ '&testerName=' + $("#testerName2").val()
         		+ '&plannedDate=' + $("#plannedDate2").val()
         		+ '&statusUpdate=' + $("#StatusRO").val(),
     }).done(function(data) {
//          alert("response: "+data)

         if (data == "success") {
             swal({
                 title: "Successful!",
                 text: "Record Updated Successfully",
                 type: "success",
                 width: 300,
                 height: 200,
        		
               confirmButtonClass: "btn btn-danger",
             
               confirmButtonText: "OK",
                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/AssignCustomizationTask";
                 }

             });

         }
         else if (data == "duplicate") {
             swal({
                 title: "Duplicate Data!",
                 text: "Record Already Exists",
                 type: "warning",
                 width: 300,
                 height: 200,
        		 showCancelButton: false,
               confirmButtonClass: "btn btn-danger",
               cancelButtonClass: "btn btn-danger m-l-10",
               confirmButtonText: "OK",
                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/AssignCustomizationTask";
                 }

             });

           }
         else if (data == "fail") {
             swal({
                 title: "Unsuccessful!",
                 text: "Failed to update",
                 type: "error",
                 width: 300,
                 height: 200,
//        		 showCancelButton: false,
//               confirmButtonClass: "btn btn-danger",
//               cancelButtonClass: "btn btn-danger m-l-10",
//               confirmButtonText: "OK",
                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/AssignCustomizationTask";
                 }

             });

           }
     });
   
}
