var dataPoId = $('#crnoo').val();

let globalDataArray = [];

let rowCounter = 1;

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
		var serviceUrl = base_url + "/Master/getproductsuitlist";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	      
	  }).done(function(data) {

	      var html='<option value="">-- Please Select Product Suite --</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
	      document.getElementById("productsuit21").innerHTML=html;
	          
	  });
	  
	  //22/11
//	  var l = window.location;
//		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/Master/getproductsuitlistN";
//
//	  $.ajax({
//
//	      url :serviceUrl,
//	      type : 'POST',
//	      dataType: 'json',
//	      
//	  }).done(function(data) {
//		  
//		  alert(data)
//
//	      var html='<option value="">-- Please Select Product Suite --</option>';
//	      for (var i = 0; i < data.length; i++) {
//	          html += '<option value="' +data[i]+ '">' + data[i]
//	          + '</option>';
//	      }
//	      document.getElementById("productsuit"+rowCounter).innerHTML=html;
//		     
//	  });
	  
	  
	  
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getCustomerName";

	$.ajax({

	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	}).done(function(data) {

//	    var html =" <select class='form-control' tabindex='8' id='clientname' name='clientname'>";
	    var html= '<option value="">--Please Select Customer--</option>';
	    for (var i = 0; i < data.length; i++) {
	        html += '<option value="' +data[i]+ '">' + data[i]
	        + '</option>';
	    }

	    document.getElementById("customerName").innerHTML=html;
	});

	
	
	var projectId = $('#projectId').val();

//	alert("projectId"+projectId)

	// get Manager /Implementor name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getManagerList";
//	var selectedValue = $("#teamLeader").val(); // Get the currently
	// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		// data : 'teamLeader=' + encodeURIComponent(selectedValue),
		success : function(data4) {

			// alert("function "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#managerName1").html(html); // Update the select element
			$("#managerName1").val(selectedValue); // Set the selected value
			$("#managerName").html(html); // Update the select element
			$("#managerName").val(selectedValue); // Set the selected value
		}
	});
	
	
	
	// get Manager /Implementor name
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/PMS/getpmsdetails";
//
//
//	$.ajax({
//		type : 'POST',
//		url : serviceUrl,
//		dataType : 'json',
//		 data : 'Projectdata=' + encodeURIComponent(projectId),
//		success : function(data4) {
//			
//			alert("data33333333: " + JSON.stringify(data4));
//
//		var html = "<option value=''>-- Please Select --</option>";
//		for (var i = 0; i < data4.length; i++) {
//		    var value = data4[i];
//		    // Use console.log for debugging if needed
//		    console.log("Option " + i + ": " + JSON.stringify(value));
//		    html += '<option value="' + value + '">' + value + '</option>';
//		}
//
//		// Update the select element outside the loop
//		$("#functionNames").html(html); // Update the select element
//		$("#functionNames").val(selectedValue);
//}
//	});
	
	
	 // Set the selected value

	// Get data 

//	    var l = window.location;
//	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	 	var serviceUrl = base_url + "/PMS/getImplemetorFORMData";
//	    
//	    $.ajax({
//	        url: serviceUrl,
//	        type: 'POST',
//	        dataType: 'json',
//	        data: "crno=" + $('#crnoo').val()
//	        + '&tid=' + $("#tid").val()
//	    }).done(function(data) {
//	    	
//	    	var aaa = data[0];
//	    	console.log(data)
//	    	
//	    	var ccc = data[2];
//	    //	alert("hhhhh"+data[0][0])
//	
//	    		
//	    		
// $('#date').val(decodeURIComponent(aaa[0]));
//
// $('#customername').val(decodeURIComponent(aaa[1]));
//// $('#projectname').val(decodeURIComponent(aaa[3]));
// $('#PONumb').val(decodeURIComponent(aaa[2]));
// $('#formABstatus').val(decodeURIComponent(aaa[3]));
// $('#productLicense').val(decodeURIComponent(aaa[4]));
// 
//// $('#paymentterms').val(decodeURIComponent(aaa[5]));
// $('#paymentTermsPO').val(decodeURIComponent(aaa[5]));
// 
// $('#SalesManagerName').val(decodeURIComponent(aaa[6]));
// 
// $('#ImplementorName').val(decodeURIComponent(ccc[1]));
// $('#ImplementorNumber').val(decodeURIComponent(ccc[0]));
// $('#cusImplementorEmail').val(decodeURIComponent(ccc[2]));    
//  $('#EndCustomerName').val(decodeURIComponent(ccc[3]));
//  $('#EndCustomerNumber').val(decodeURIComponent(ccc[4]));
//  
//  
// })
	
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getFunctionName";

//	$.ajax({
//		type : 'POST',
//		url : serviceUrl,
//		dataType : 'json',
//		// data : 'functionName=' + encodeURIComponent(selectedValue),
//		success : function(data4) {
//
//			// alert("function "+data4)
//			var html = "<option value=''>-- Please Select --</option>";
//			for (var i = 0; i < data4.length; i++) {
//				var value = data4[i];
//				html += '<option value="' + value + '">' + value + '</option>';
//			}
//			html += "<option value='Go Live'>Go Live</option>";
//			$("#functionName1").html(html); // Update the select element
//			$("#functionName1").val(selectedValue); // Set the selected value
//			$("#functionName").html(html); // Update the select element
//			$("#functionName").val(selectedValue); // Set the selected value
//		}
//	});

	
	var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
	var html = "<option value=''>-- Please Select --</option>";
	for (var i = 0; i < dataF.length; i++) {
	    var value = dataF[i];
	    html += '<option value="' + value + '">' + value + '</option>';
	}
	$("#functionName").html(html);   
	$("#functionName1").html(html);
	
	
	// get Teamleader Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getTeamLeader";
	var selectedValue = $("#teamLeader").val(); // Get the currently
	// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		// data : 'teamLeader=' + encodeURIComponent(selectedValue),
		success : function(data4) {

			// alert("function "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#teamLeader1").html(html); // Update the select element
			$("#teamLeader1").val(selectedValue); // Set the selected value
			$("#teamLeader").html(html); // Update the select element
			$("#teamLeader").val(selectedValue); // Set the selected value
			
		}
	});

	// DeveloperList
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getDevelopers";
	var selectedValue = $("#teamLeader").val(); // Get the currently
	// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'teamLeader=' + encodeURIComponent(selectedValue),
		success : function(data4) {

			// alert("function "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#developer1").html(html); // Update the select element
			$("#developer1").val(selectedValue); // Set the selected value
			$("#developer").html(html); // Update the select element
			$("#developer").val(selectedValue); // Set the selected value
		}
	});
	
	
	
	// get Tester Name list
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getTesterList";
//	var selectedValue = $("#teamLeader").val(); // Get the currently
	// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		// data : 'teamLeader=' + encodeURIComponent(selectedValue),
		success : function(data4) {

			// alert("function "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#testerName").html(html); // Update the select element
		//	$("#testerName").val(selectedValue); // Set the selected value
			
		}
	});
	
	
	
	
	//24/07
	// get SupportTeamleader Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSupportTeamLeader";
	var selectedValue = $("#supportteamLeader").val(); // Get the currently
	// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		// data : 'teamLeader=' + encodeURIComponent(selectedValue),
		success : function(data4) {

//			 alert("function "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#supportteamLeader1").html(html); // Update the select element
			$("#supportteamLeader1").val(selectedValue); // Set the selected value
			$("#supportteamLeader").html(html); // Update the select element
			$("#supportteamLeader").val(selectedValue); // Set the selected value
			
		}
	});
	
	// SupportList
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSupport";
	var selectedValue = $("#support").val(); // Get the currently
	// selected value
//	alert("working"+selectedValue);
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'supportteamLeader=' + encodeURIComponent(selectedValue),
		success : function(data4) {

//			alert("function data:: "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#support1").html(html); // Update the select element
			$("#support1").val(selectedValue); // Set the selected value
			$("#support").html(html); // Update the select element
			$("#support").val(selectedValue); // Set the selected value
		}
	});
	
	
	
	
	
	
	var serviceUrl = base_url + "/Master/getTeamLeader";
	var selectedValue = $("#teamLeaderN").val(); // Get the currently
	// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		// data : 'teamLeader=' + encodeURIComponent(selectedValue),
		success : function(data4) {

			// alert("function "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#teamLeaderN1").html(html); // Update the select element
			$("#teamLeaderN1").val(selectedValue); // Set the selected value
			$("#teamLeaderN").html(html); // Update the select element
			$("#teamLeaderN").val(selectedValue); // Set the selected value
			
		}
	});
	
	//
	
	
	
	
	  var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getPoByCustomerName";
	    var selectedProjectName = $("#projectId").val(); // Get the currently
														// selected value
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'projName=' + encodeURIComponent(selectedProjectName),
	        success: function(data4) {
//	        	alert(data4)
	            var html = "<option value=''>-- Please Select --</option>";
	            for (var i = 0; i < data4.length; i++) {
	                var value = data4[i];
	                html += '<option value="' + value + '">' + value + '</option>';
	            }
	            $("#functionNames").html(html); // Update the select element
//	            $("#functionNames").val(selectedPOValue); // Set the selected value
	        }
	    });
	    
		 $('#customerName').select2({
//		      theme: 'bootstrap4'
		    	tags: true,
		    	placeholder: "Customer Name",
//		        allowClear: true
		    })
		    
		    
		    
		    
	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/PMS/getCustomTaskData";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//        	 alert("s "+data4)
//             var table = $('#productdata').DataTable({
//                 lengthChange: false,
//                 data: data4,
//                  "pageLength": 10,
//                  scrollX:true,
//                  scrollY:true,
//                  dom: 'Bfrtip', 
//         	     buttons: [
//         	         {
//         	             extend: 'excelHtml5', 
//         	             text: 'Excel', 
//         	             title: 'Operational Task',  
//         	            exportOptions: {
//                            columns: function (idx, data, node) {
//                                return idx !== 1;
//                            }
//                        },
//         	         }
//         	     ], 
//         	     columnDefs: [
//                    {
//                    	 orderable: true
//                    }
//                 ],               
//             });
        	 
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
//            	            exportOptions: {
//                               columns: function (idx, data, node) {
//                                   return idx !== 1;
//                               }
//                           },
            	         }
            	     ] 
        		});

             table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });
		    
}


function SelectAssignee() {
	if( $('#selectMe').val()==="Developer") {
		$('#selectDeveloper').show();
		$('#testerDiv').hide();
		
		$('#teamLeader').show();
		$('#developer').show();
		$('#selectSupport').hide();
		
		$('#supportteamLeader').hide();
		$('#support').hide();
		
		$("#teamLeaderNX").hide();
		
		
		$('#testerName').val("");
		 callToolTip231('testerName', 'destroy');
	}
	 else if( $('#selectMe').val()==="Tester") {
		$('#testerDiv').show();
		$('#selectDeveloper').hide();
		
		$('#selectSupport').hide();
		$('#supportteamLeader').hide();
		$('#support').hide();
		
		$("#teamLeaderNX").hide();
		
		$('#teamLeader').val("");  
		$('#developer').val("");
		callToolTip231('developer', 'destroy');
	    callToolTip231('teamLeader', 'destroy');
	} 
	 else if($('#selectMe').val()==="Support"){

		$('#teamLeader').hide();
		$('#developer').hide();
		$('#testerDiv').hide();
		$('#selectDeveloper').hide();
		
		$("#teamLeaderNX").hide();
		
		$('#selectSupport').show();
		$('#supportteamLeader').show();
		$('#support').show();
		
	}
	 else if($('#selectMe').val()==="Self"){
		 
		 $('#teamLeaderNX').show();
		 $('#selectDeveloper').hide();
		    $('#testerDiv').hide();
		    $('#selectSupport').hide();
		    
		    $('#teamLeader').hide();
		    $('#developer').hide();  
		    $('#supportteamLeader').hide(); 
		    $('#support').hide(); 

		    
		    $('#developer').val("");
		    $('#testerName').val(""); 
		    callToolTip231('developer', 'destroy');
		    callToolTip231('testerName', 'destroy');
		    callToolTip231('supportteamLeader', 'destroy');

	}
	else {
		
		$('#selectDeveloper').hide();
		$('#testerDiv').hide();
		
		$('#supportteamLeader').hide();
		$('#support').hide();
		$('#selectSupport').hide();
		
		$("#teamLeaderNX").hide();
		
		$('#teamLeader').val("");
		$('#developer').val("");
		$('#testerName').val(""); 
		callToolTip231('developer', 'destroy');
	    callToolTip231('teamLeader', 'destroy');
	    callToolTip231('testerName', 'destroy');
	}
}


//function addNewRow() {
//	var lastRow = $("#data-table1 tbody tr:last"); // Find the last row
//	var newRow = lastRow.clone(); // Clone the last row
//
//	
//	newRow.find('input').val('');
//
//	$("#data-table1 tbody").append(newRow); // Add the cloned row after the last
//										
//}

//function addNewRow() {
////	alert("hih")
//    const tableBody = document.querySelector("#data-table1 tbody");
//    const newRow = tableBody.insertRow();
//
//    // Dropdown cell 1
//    const dropdownCell1 = newRow.insertCell();
//    const dropdown1 = document.createElement('select');
//    dropdown1.id = 'functionName';
//    dropdown1.classList.add('form-control', 'form-control-sm');
//    // Call the function to fetch and populate dropdown values
//    populateDropdownFunc(dropdown1);
//    dropdownCell1.appendChild(dropdown1);
//
//    
//    // Text inputs    
//
//    const cell1 = newRow.insertCell();
//    const input1 = document.createElement('input');
//    input1.type = 'text';
//    input1.classList.add('form-control', 'form-control-sm');
//    input1.id = 'ModuleName'; 
//    input1.placeholder = 'Enter Your Module';
//    cell1.appendChild(input1);
//
//
// 
////     Dropdown cell 2
//    const dropdownCell2 = newRow.insertCell();
//    const dropdown2 = document.createElement('select');
//    dropdown2.id = 'Responsibility';
//    dropdown2.classList.add('form-control', 'form-control-sm');
//
//    // Create options and append them to the dropdown
//    const options = ['-- Please Select --','End Customer', 'Velox Solution', 'Both'];
//    options.forEach(optionText => {
//        const option = document.createElement('option');
//        option.value = optionText;
//        option.text = optionText;
//        dropdown2.appendChild(option);
//    });
//    dropdownCell2.appendChild(dropdown2);
//    
// // Dropdown cell 5
////    const dropdownCell5 = newRow.insertCell();
////    const dropdown5 = document.createElement('select');
////    dropdown5.id = 'managerName';
////    dropdown5.classList.add('form-control', 'form-control-sm');
////    // Call the function to fetch and populate dropdown values
////    populateDropdownManager(dropdown5);
////    dropdownCell5.appendChild(dropdown5);
//    
//    
// // Dropdown cell 3
//    const dropdownCell3 = newRow.insertCell();
//    const dropdown3 = document.createElement('select');
//    dropdown3.id = 'teamLeader';
//    dropdown3.classList.add('form-control', 'form-control-sm');
//    // Call the function to fetch and populate dropdown values
//    populateDropdownTL(dropdown3);
//    dropdownCell3.appendChild(dropdown3);
//    
//    
// 
// // Dropdown cell 4
//    const dropdownCell4 = newRow.insertCell();
//    const dropdown4 = document.createElement('select');
//    dropdown4.id = 'developer';
//    dropdown4.classList.add('form-control', 'form-control-sm');
//    // Call the function to fetch and populate dropdown values
//    populateDropdownDev(dropdown4);
//    dropdownCell4.appendChild(dropdown4);
//    
//    // Input 2 start Date
//    const cell2 = newRow.insertCell();
//    const input2 = document.createElement('input');
//    input2.type = 'date';
//    input2.classList.add('form-control','pull-right', 'form-control-sm');
//    input2.id ='startdate'; 
//    cell2.appendChild(input2);
//    
//    // Input 2 start Date
//    const cell3 = newRow.insertCell();
//    const input3 = document.createElement('input');
//    input3.type = 'date';
//    input3.classList.add('form-control','pull-right', 'form-control-sm');
//    input3.id = 'enddate'; 
//    cell3.appendChild(input3);
//  
//    // Text inputs    
//
//    const cell4 = newRow.insertCell();
//    const input4 = document.createElement('input');
//    input4.type = 'text';
//    input4.classList.add('form-control', 'form-control-sm');
//    input4.id = 'inputRemark'; 
//    input4.placeholder = 'Enter Remark';
//    cell4.appendChild(input4);
//    
//    
// 
// // Delete cell
//    const deleteCell = newRow.insertCell();
//    const deleteButton = document.createElement('button');
//    deleteButton.type = 'button';
//    deleteButton.classList.add('btn');
//
//    // Create the icon element
//    const trashIcon = document.createElement('i');
//    trashIcon.classList.add('fa-solid', 'fa-trash-can', 'fa-lg');
//    trashIcon.style.color = '#fd4444';
//    trashIcon.style.marginLeft = '5px';
//    // Append the icon to the button
//    deleteButton.appendChild(trashIcon);
//
//    deleteButton.onclick = function () {
//        deleteRow(this); // Pass the button itself as an argument
//    };
//    deleteCell.appendChild(deleteButton);
//
//}


//function deleteRow(button) {
//    var rowToDelete = $(button).closest('tr');
//
//    if ($('#data-table1 tbody tr').length > 1) {
//        rowToDelete.remove();
//    } 
//}

// Populate dropdowns
function populateDropdownFunc(dropdown) {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getFunctionName";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data) {
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data.length; i++) {
                var value = data[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            dropdown.innerHTML = html;  // Update the select element
        }
    });
}


function populateDropdownProdSuite(dropdown) {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getproductsuitlistN";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data) {
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data.length; i++) {
                var value = data[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            dropdown.innerHTML = html;  // Update the select element
            dropdown.value=$('#prodSuite').val();
        }
    });
}


function populateDropdownProdTool(dropdown2, prodSuite){
	
//	alert("inside populateDropdownProdTool" +prodSuite)

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + prodSuite
	}).done(function(data) {
//	alert("data "+data);
		 var html = "<option value=''>-- Please Select Product Tool --</option>";
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
//	      document.getElementById("productname21").innerHTML=html; 
	      dropdown2.innerHTML = html;
//	      dropdown2.value=$('#prodTool').val();
	      
	
	  
          
  });
}




function populateDropdownProdToolLoad(dropdown2){
	
//	alert("inside populateDropdownProdTool" +prodSuite)

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getAllsecuritysolutionList";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
//	    data: 'productsuit=' + prodSuite
	}).done(function(data) {
//	alert("data "+data);
		 var html = "<option value=''>-- Please Select Product Tool --</option>";
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
//	      document.getElementById("productname21").innerHTML=html; 
	      dropdown2.innerHTML = html;
	      dropdown2.value=$('#prodTool').val();
	      
	
	  
          
  });
}



function populateDropdownCustName(dropdown) {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getCustomerName";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data) {
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data.length; i++) {
                var value = data[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            dropdown.innerHTML = html;  // Update the select element
            dropdown.value=$('#customerNameh').val();
        }
    });
}


//
//function populateDropdownManager(dropdown) {
//    var l = window.location;
//    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/Master/getManagerList";
//
//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        dataType: 'json',
//        success: function(data) {
//            var html = "<option value=''>-- Please Select --</option>";
//            for (var i = 0; i < data.length; i++) {
//                var value = data[i];
//                html += '<option value="' + value + '">' + value + '</option>';
//            }
//            dropdown.innerHTML = html;  // Update the select element
//        }
//    });
//}

function populateDropdownTL(dropdown) {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getTeamLeader";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data) {
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data.length; i++) {
                var value = data[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            dropdown.innerHTML = html;  // Update the select element
        }
    });
}

function populateDropdownDev(dropdown) {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getDevelopers";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data) {
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data.length; i++) {
                var value = data[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            dropdown.innerHTML = html;  // Update the select element
        }
    });
}



//Add Day wise Task Details
function saveDaywiseTask() { 
const tableBody = document.querySelector("#data-table1 tbody");
const rows = tableBody.querySelectorAll('tr');
const dataArray = [];

for (const row of rows) {
    const inputs = row.querySelectorAll('input');
    const selects = row.querySelectorAll('select'); // Fix here: change
													// 'select' to 'selects'
    
// alert(selects[0].value);

    for (const input of inputs) {
        if (input.value.trim() === '') {
            alert('One or more fields are empty. Please fill them out.');
            return; // Exit the function if any input is empty
        }
    }

    const dataObj = {
        
        functionName: selects[0].value,
        moduleName: inputs[0].value,
        responsibility: selects[1].value,
        managerName: "abc",
        teamLeader: selects[2].value,
        developer: selects[3].value,
        startdate: inputs[1].value,
        enddate: inputs[2].value,
        inputRemark: inputs[3].value,
    };
    dataArray.push(dataObj);
   
}
// alert("data  ar "+JSON.stringify(dataArray))
// Serialize dataArray for sending it in the AJAX request
var taskData = JSON.stringify(dataArray);
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/saveDayWiseTask";
$('#spin2').show();
$.ajax({
	type : 'POST',
	url : serviceUrl,
	data: "taskData=" + taskData,

	success : function(data) {
		$('#spin2').hide();
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
							+ "/Admin/PMS";
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
							+ "/Admin/PMS";
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
							+ "/User/Admin/PMS";
				}

			});

		}
	}
});
}




//Add Task Details
function saveMainTask() {  

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/saveMainTask";  //  // saveTaskDetails
	$("#spin1").show();
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		data: "functionName=" + $("#functionName1").val() 
		+ "&moduleName=" + $("#ModuleName1").val()
		+ "&responsibility=" +$("#Responsibility1").val()
		 + "&managerName=" +$("#managerName1").val()
	    + "&teamLeader=" + $("#teamLeader1").val()
	    + "&developer=" +$("#developer1").val()
	    + "&startdate=" + $("#startdate1").val()
	    + "&enddate=" + $("#enddate1").val()
	    + "&inputRemark=" + $("#inputRemark1").val()
	    + "&description=" + $("#description1").val()
	    + "&expectedOutput=" + $("#expectedOutput").val(),
	
		success : function(data) {
			$("#spin1").hide();
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
								+ "/User/PMSProjectDetails";
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
								+ "/User/PMSProjectDetails";
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
								+ "/User/PMSProjectDetails";
					}

				});

			}
		}
	});	
}	

function hideFormC(){
	resetAll();
	$("#formCdata").hide();
	
	//16/09
	$("#assignedTaskdetailsCard").hide();
	//

}	

function resetPOID(){
	$("#functionNames").val('');
	$("#formCdata").hide();
	
	//16/09
	$("#assignedTaskdetailsCard").hide();
	//
	
	callToolTip231('functionNames', 'destroy');
}


$('#Selectrd').click(function() {
	
	if (!validatePONumber()) {

		event.preventDefault();
	} else if (validatePONumber()) {
	
	$("#formCdata").show();
	$('#spinner').show();
	
	//16/09
	$("#assignedTaskdetailsCard").show();
	//
	
//	alert("selectedValue1")	
//	   var l = window.location;
//	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    var serviceUrl = base_url + "/PMS/getimplformcdetails";
//	    var selectedValue1 = $("#functionNames").val(); // Get the currently
////		alert("selectedValue1"+selectedValue1)												// selected value
//
//	    $.ajax({
//	        type: 'POST',
//	        url: serviceUrl,
//	        dataType: 'json',
//	        data: 'selectrddetails=' + selectedValue1
//	    })      // $("#documentType2").val(),
//	    .done(
//				function(data) {
//					
//					$('#spinner').hide();
//					$("#formCdata").show();
//					
//					//16/09
//					$("#assignedTaskdetailsCard").show();
//					//
//					
//					var aaa = data[0]
////	alert("aaa"+aaa)			
//
//					$('#PONumb').val(decodeURIComponent(aaa[0][44]));
//					$('#date').val(decodeURIComponent(aaa[0][31]));
//					$('#customername').val(decodeURIComponent(aaa[0][1]));
//					$('#productLicense').val(decodeURIComponent(aaa[0][49]));
//					$('#ImplementorName').val(decodeURIComponent(aaa[0][53]));
//					$('#ImplementorNumber').val(decodeURIComponent(aaa[0][51]));
//					
//					$('#cusImplementorEmail').val(decodeURIComponent(aaa[0][52]));
//					$('#EndCustomerName').val(decodeURIComponent(aaa[0][55]));
//					$('#EndCustomerNumber').val(decodeURIComponent(aaa[0][54]));
//					
//					$('#SalesManagerName').val(decodeURIComponent(aaa[0][56]));
//					
//					
//					$('#paymentTermsPO').val((aaa[0][6]));
//					
//					$('#serverAvail').val(decodeURIComponent(aaa[0][24]));
//					$('#Responsibility').val(decodeURIComponent(aaa[0][26]));
//					$('#startdate').val(decodeURIComponent(aaa[0][27]));
//					$('#enddate').val(decodeURIComponent(aaa[0][25]));
//
//					$('#installvlxlicense').val(decodeURIComponent(aaa[0][5]));
//					$('#Responsibilityvlxlicense').val(decodeURIComponent(aaa[0][17]));
//					$('#startdatevlxlicense').val(decodeURIComponent(aaa[0][36]));
//					$('#enddatevlxlicense').val(decodeURIComponent(aaa[0][35]));
//
//					$('#UATTesting').val(decodeURIComponent(aaa[0][34]));
//					$('#Responsibilityuattesting').val(decodeURIComponent(aaa[0][16]));
//					$('#startdateuattesting').val(decodeURIComponent(aaa[0][33]));
//					$('#enddateuattesting').val(decodeURIComponent(aaa[0][32]));
//
//					$('#productiongolive').val(decodeURIComponent(aaa[0][9]));
//					$('#Responsibilitygolive').val(decodeURIComponent(aaa[0][15]));
//					$('#startdategolive').val(decodeURIComponent(aaa[0][11]));
//					$('#enddategolive').val(decodeURIComponent(aaa[0][10]));
//
//					$('#rollout').val(decodeURIComponent(aaa[0][20]));
//					$('#Responsibilityrollout').val(decodeURIComponent(aaa[0][23]));
//					$('#startdaterollout').val(decodeURIComponent(aaa[0][22]));
//					$('#enddaterollout').val(decodeURIComponent(aaa[0][21]));
//
//					$('#demolive').val(decodeURIComponent(aaa[0][4]));
//					$('#Responsibilitydemo').val(decodeURIComponent(aaa[0][18]));
//					$('#startdatedemo').val(decodeURIComponent(aaa[0][3]));
//					$('#enddatedemo').val(decodeURIComponent(aaa[0][2]));
//
////					$('#paymentTermsPO').val(aaa[]);
//					// $('#paymentterms').val(aaa[29]);
//					// $('#Responsibilitypaymentterms').val(decodeURIComponent(aaa[30]));
//					// $('#startdatepaymentterms').val(decodeURIComponent(aaa[31]));
//					// $('#enddatepaymentterms').val(decodeURIComponent(aaa[32]));
//
//					$('#signoff').val(decodeURIComponent(aaa[0][28]));
//					$('#Responsibilitysignoff').val(decodeURIComponent(aaa[0][19]));
//					$('#startdatesignoff').val(decodeURIComponent(aaa[0][30]));
//					$('#enddatesignoff').val(decodeURIComponent(aaa[0][29]));
//
//
//				});
	
	
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getimplformcdetails";
	var selectedValue1 = $("#functionNames").val(); 

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType: 'json',
	    data: { selectrddetails: selectedValue1 }
	})
	.done(function(data) {
	    $('#spinner').hide(); 

	   
	    if (data && data.length > 0 && data[0].length > 0) {
	        
	        $("#formCdata").show();
//	        $("#assignedTaskdetailsCard").show();

	        var aaa = data[0];

	        
	        $('#PONumb').val(decodeURIComponent(aaa[0][44]));
	        $('#date').val(decodeURIComponent(aaa[0][31]));
	        $('#customername').val(decodeURIComponent(aaa[0][1]));
	        $('#productLicense').val(decodeURIComponent(aaa[0][49]));
	        $('#ImplementorName').val(decodeURIComponent(aaa[0][53]));
	        $('#ImplementorNumber').val(decodeURIComponent(aaa[0][51]));
	        $('#cusImplementorEmail').val(decodeURIComponent(aaa[0][52]));
	        $('#EndCustomerName').val(decodeURIComponent(aaa[0][55]));
	        $('#EndCustomerNumber').val(decodeURIComponent(aaa[0][54]));
	        $('#SalesManagerName').val(decodeURIComponent(aaa[0][56]));
	        $('#paymentTermsPO').val(aaa[0][6]);
	        $('#serverAvail').val(decodeURIComponent(aaa[0][24]));
	        $('#Responsibility').val(decodeURIComponent(aaa[0][26]));
	        $('#startdate').val(decodeURIComponent(aaa[0][27]));
	        $('#enddate').val(decodeURIComponent(aaa[0][25]));
	        $('#installvlxlicense').val(decodeURIComponent(aaa[0][5]));
	        $('#Responsibilityvlxlicense').val(decodeURIComponent(aaa[0][17]));
	        $('#startdatevlxlicense').val(decodeURIComponent(aaa[0][36]));
	        $('#enddatevlxlicense').val(decodeURIComponent(aaa[0][35]));
	        $('#UATTesting').val(decodeURIComponent(aaa[0][34]));
	        $('#Responsibilityuattesting').val(decodeURIComponent(aaa[0][16]));
	        $('#startdateuattesting').val(decodeURIComponent(aaa[0][33]));
	        $('#enddateuattesting').val(decodeURIComponent(aaa[0][32]));
	        $('#productiongolive').val(decodeURIComponent(aaa[0][9]));
	        $('#Responsibilitygolive').val(decodeURIComponent(aaa[0][15]));
	        $('#startdategolive').val(decodeURIComponent(aaa[0][11]));
	        $('#enddategolive').val(decodeURIComponent(aaa[0][10]));
	        $('#rollout').val(decodeURIComponent(aaa[0][20]));
	        $('#Responsibilityrollout').val(decodeURIComponent(aaa[0][23]));
	        $('#startdaterollout').val(decodeURIComponent(aaa[0][22]));
	        $('#enddaterollout').val(decodeURIComponent(aaa[0][21]));
	        $('#demolive').val(decodeURIComponent(aaa[0][4]));
	        $('#Responsibilitydemo').val(decodeURIComponent(aaa[0][18]));
	        $('#startdatedemo').val(decodeURIComponent(aaa[0][3]));
	        $('#enddatedemo').val(decodeURIComponent(aaa[0][2]));
	        $('#signoff').val(decodeURIComponent(aaa[0][28]));
	        $('#Responsibilitysignoff').val(decodeURIComponent(aaa[0][19]));
	        $('#startdatesignoff').val(decodeURIComponent(aaa[0][30]));
	        $('#enddatesignoff').val(decodeURIComponent(aaa[0][29]));
	    } else {
	        
	        $("#formCdata").hide();
	    }
	})
	.fail(function(jqXHR, textStatus, errorThrown) {
	    
	    console.error("Request failed: " + textStatus + ", " + errorThrown);
	});

	    
	    
	    
	    		//16/09
	    var serviceUrl = base_url + "/PMS/getAssignTaskDetails";
//	    var selectedValue1 = $("#functionNames").val(); // Get the currently
//		alert("selectedValue1"+selectedValue1)												// selected value

	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'selectrddetails=' + selectedValue1
	    })      // $("#documentType2").val(),
	    .done(
				function(data) {
					  
		          $('#assignedTaskdetails tbody').empty();

		          if (data && data.length > 0) {
		        	  let serialNumber = 1;
		              data.forEach(function(project) {
//		              	 var PONumber = project[0][0];
//		                   var ProductSuite = project[0][1];
//		                   var ProductTool = project[0][2];
//		                   var FunctionName = project[0][3];
//		                   var ManagerName = project[0][4];
//		                   var AssignedTo = project[0][5];
//		                   var AssignedDate = project[0][6];
//		                   var Status = project[0][7];
//		                   var Location = project[0][8];
		            	  
//		            	  	 var PONumber = project[0][0] ? project[0][0] : 'NA';
			            	 var ProductSuite = project[0][0] ? project[0][0] : 'NA';
			            	 var ProductTool = project[0][1] ? project[0][1] : 'NA';
			            	 var FunctionName = project[0][2] ? project[0][2] : 'NA';
			            	 var Description = project[0][3] ? project[0][3] : 'NA';
			            	 var AssignedTo = project[0][4] ? project[0][4] : 'NA';
			            	 var AssignedDate = project[0][5] ? project[0][5] : 'NA';
			            	 var Status = project[0][6] ? project[0][6] : 'NA';
//			            	 var Location = project[0][8] ? project[0][8] : 'NA';
//			            	 var Gender = project[0][8] ? project[0][8] : 'NA';
		                   var row = '<tr>' +
//		                       '<td>' + selectedValue1 + '</td>' +
		                   	   '<td>' + serialNumber++ + '</td>' +
		                       '<td>' + ProductSuite + '</td>' +
		                       '<td>' + ProductTool + '</td>' +
		                       '<td>' + FunctionName + '</td>' +
		                       '<td>' + Description + '</td>' +
		                       '<td>' + AssignedTo + '</td>' +
		                     '<td>' + AssignedDate + '</td>' +
		                       '<td>' + Status + '</td>' +
		                      

		                       '</tr>';
		                  $('#assignedTaskdetails tbody').append(row);
		              });
		          } else {
		              // No data received
//		              console.log("No data received");
		              $('#assignedTaskdetails tbody').append('<tr><td colspan="6">No Data found</td></tr>');
		          }
		      });
	    		//
	    
	    
	    
	    	
	    
	    
 var selectedValue = $("#functionNames").val();
 
 // If the selected value meets a certain condition, show both 'RD' and 'UD'
 if (selectedValue === 'RD-1' || selectedValue === 'RD-2' || selectedValue === 'RD-3' || selectedValue === 'RD-4') {
     $('#RD').show();
     $('#UD').show();
    
 } else {
     // Otherwise, hide them
     $('#RD').show();
     $('#UD').hide();        
 }

}
});


function resetAll() {
	$('#PONumb').val('');
	$('#date').val('');
	$('#customername').val('');
	$('#productLicense').val('');
	$('#ImplementorName').val('');
	$('#ImplementorNumber').val('');
	
	$('#cusImplementorEmail').val('');
	$('#EndCustomerName').val('');
	$('#EndCustomerNumber').val('');
	
	$('#SalesManagerName').val('');
	$('#paymentTermsPO').val('');
	$('#serverAvail').val('');
	$('#Responsibility').val('');
	$('#startdate').val('');
	$('#enddate').val('');
	$('#installvlxlicense').val('');
	$('#Responsibilityvlxlicense').val('');
	$('#startdatevlxlicense').val('');
	$('#enddatevlxlicense').val('');

	$('#UATTesting').val('');
	$('#Responsibilityuattesting').val('');
	$('#startdateuattesting').val('');
	$('#enddateuattesting').val('');

	$('#productiongolive').val('');
	$('#Responsibilitygolive').val('');
	$('#startdategolive').val('');
	$('#enddategolive').val('');

	$('#rollout').val('');
	$('#Responsibilityrollout').val('');
	$('#startdaterollout').val('');
	$('#enddaterollout').val('');
	$('#demolive').val('');
	$('#Responsibilitydemo').val('');
	$('#startdatedemo').val('');
	$('#enddatedemo').val('');

	$('#signoff').val('');
	$('#Responsibilitysignoff').val('');
	$('#startdatesignoff').val('');
	$('#enddatesignoff').val('');
}


var callToolTip231 = function(fieldName, status) {

	if (fieldName === "functionNames") {
		var errorMessage = "<span>Please Select PO Number <span>";
	}

	$("#" + fieldName).tooltip({
		trigger : 'manual',
		placement : 'top',
		title : errorMessage,
		animation : true,
		delay : 1000,
		html : true
	});
	if (status == "show") {
		$("#" + fieldName).tooltip('show');
	} else {
		$("#" + fieldName).tooltip('hide');
	}
};

$('#functionNames').on('click', function() {
	// alert("on focus")
	callToolTip231('functionNames', 'destroy');
});


function validatePONumber() {
	var indexError = 0;

	if ($('#functionNames').val() === '') {

		callToolTip231('functionNames', 'show');
		indexError = indexError + 1;

	}
	if (indexError > 0) {
		return false;
	} else {
	// $('#spinner2').show();
		return true;
	}
}


function getSecTools(productSuit) {
	
//	alert("in toool "+productSuit)
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
//	    data: 'productsuit=' + encodeURIComponent($("#productsuit21").val())
	    data:  'productsuit=' + productSuit
	}).done(function(data) {
//		alert("data "+data)
	
		 var html = "<option value=''>-- Please Select Product Tool --</option>";
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
	      document.getElementById("productname21").innerHTML=html;
	});	
}




function saveTaskWithoutPO() { 

//	 if (!validateTaskData()) 
//	   { 
//	        event.preventDefault();
//	   }
//	     else 
//	   {
			const tableBody = document.querySelector("#data-table1 tbody");
			const rows = tableBody.querySelectorAll('tr');
			const dataArray = [];
		
			for (const row of rows) {
			    const inputs = row.querySelectorAll('textarea,input');
			    const selects = row.querySelectorAll('select'); 
																
			    
		//	 alert(selects[0].value);
		//	 alert(selects[1].value);
		//	 alert(selects[2].value);
		//	 alert(inputs[0].value);
		//	 alert(selects[3].value);
		//	 alert(inputs[1].value);
		//	 alert(inputs[2].value);
		//	 alert(inputs[3].value);
		
			    for (const input of inputs) {
			        if (input.value.trim() === '') {
			            alert('Input fields are empty. Please fill them out.');
			            return; // Exit the function if any input is empty
			        }
			    }
			    
			    for (const select of selects) {
				    if (select.value.trim() === '') {
				        alert('Input fields are empty. Please fill them out.');
				        return; 
				    }
				}
		
			    const dataObj = {
			        
			        productSuite: selects[0].value,
			        productTool: selects[1].value,
			        custName: selects[2].value.trim(),
			        moduleName: inputs[0].value.replace(/[&'"\[\]]/g, '').trim(),
			        exDate: inputs[1].value,
			        priorityType: selects[3].value,
			        desc: inputs[2].value.replace(/[&'"\[\]]/g, '').trim(),
			        exOutput: inputs[3].value.replace(/[&'"\[\]]/g, '').trim(),
		
			    };
			    dataArray.push(dataObj);
			   
			}
			
			var taskData = JSON.stringify(dataArray);
			
			console.log("taskDatataskDatataskDatataskData::::"+taskData)
			
			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/PMS/saveIssueCustomizationTask";
			$('#spin2').show();
			$.ajax({
				type : 'POST',
				url : serviceUrl,
		//		data: "taskData=" + taskData,
				data: { taskData: taskData },
		
				success : function(data) {
					$('#spin2').hide();
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
										+ "/Admin/addCustomizationTask";
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
										+ "/Admin/addCustomizationTask";
							}
		
						});
		
					} else if (data == "error") {
						swal({
							title : "Unsuccessful!",
							text : "Fail to add Record",
							type : "error",
							width : 300,
							height : 200,
							buttons : false,
							allowOutsideClick : false,
							preConfirm : function() {
								var l = window.location;
								var base_url = l.protocol + "//" + l.host + "/"
										+ l.pathname.split('/')[1];
								window.location.href = base_url
										+ "/Admin/addCustomizationTask";
							}
		
						});
		
					}
				}
			});
//	   }

}



function validateTaskData() {
    var indexError = 0;
//    if ($('#functionName').val().trim() === '') {
//        callToolTip231('functionName', 'show');
//        if (indexError == 0) {
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#Responsibility').val().trim() === '') {
//        callToolTip231('Responsibility', 'show');
//        if (indexError == 0) {
//        }
//        indexError = indexError + 1;
//    }   
    if ($('#productsuit21').val().trim() === '') {
        callToolTip231('productsuit21', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#productname21').val().trim() === '') {
        callToolTip231('productname21', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#customerName').val().trim() === '') {
        callToolTip231('customerName', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#ModuleName').val().trim() === '') {
        callToolTip231('ModuleName', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
//    if ($('#selectMe').val().trim() === '') {
//        callToolTip231('selectMe', 'show');
//        if (indexError == 0) {
//        }
//        indexError = indexError + 1;
//    }
    if ($('#enddate1').val().trim() === '') {
        callToolTip231('enddate1', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#inputRemark').val().trim() === '') {
        callToolTip231('inputRemark', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#description').val().trim() === '') {
        callToolTip231('description', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#expectedOutput').val().trim() === '') {
        callToolTip231('expectedOutput', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
//    if ($('#testerName').val().trim() === '' && $('#selectMe').val()==="Tester" ) {
//        callToolTip231('testerName', 'show');
//        if (indexError == 0) {
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#teamLeader').val().trim() === '' &&  $('#selectMe').val()==="Developer") {
//        callToolTip231('teamLeader', 'show');
//        if (indexError == 0) {
//        }
//        indexError = indexError + 1;
//    }                          
//    if ($('#developer').val().trim() === '' &&  $('#selectMe').val()==="Developer") {
//        callToolTip231('developer', 'show');
//        if (indexError == 0) {
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#weightage').val().trim() === '') {
//        callToolTip231('weightage', 'show');
//        if (indexError == 0) {
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#startdate1').val().trim() === '') {
//        callToolTip231('startdate1', 'show');
//        if (indexError == 0) {
//        }
//        indexError = indexError + 1;
//    }
 
    
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}




var callToolTip231 = function(fieldName, status) {

	if (fieldName == 'productsuit21') {
    	var errorMessage = "<span>Please Select Product Suite <span>";
    }
     else if (fieldName == 'productname21') {
    	var errorMessage = "<span>Please Select Product Tool <span>";
    } 
     else if (fieldName == 'customerName') {
     	var errorMessage = "<span>Please Select Customer Name <span>";
     }
     else if (fieldName == 'ModuleName') {
     	var errorMessage = "<span>Please Select Module Name <span>";
     }
     
     else if (fieldName == 'enddate1') {
      	var errorMessage = "<span>Please Select Expected Date <span>";
      }
     else if (fieldName == 'inputRemark') {
       	var errorMessage = "<span>Select Priority <span>";  
      }  
     else if (fieldName == 'description') {
         	var errorMessage = "<span>Enter Description <span>";  
        }
     else if (fieldName == 'expectedOutput') {
      	var errorMessage = "<span>Enter Expected Output <span>";  
     }
if(fieldName==="customerName") {
	$("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });
} else {
	$("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });
}
    
    if (status == "show") {
        $("#" + fieldName).tooltip('show');
    } else {
        $("#" + fieldName).tooltip('hide');
    }
}







$('#productsuit21').on('focus', function() {
    callToolTip231('productsuit21', 'destroy');
});

$('#productname21').on('focus', function() {
    callToolTip231('productname21', 'destroy');
});

$('#customerName').on('select2:open', function() {
    callToolTip231('customerName', 'destroy');
});

$('#ModuleName').on('focus', function() {
    callToolTip231('ModuleName', 'destroy');
});



$('#enddate1').on('focus', function() {
    callToolTip231('enddate1', 'destroy');
});

$('#inputRemark').on('focus', function() {
    callToolTip231('inputRemark', 'destroy');
});

$('#description').on('focus', function() {
    callToolTip231('description', 'destroy');
});

$('#expectedOutput').on('focus', function() {
    callToolTip231('expectedOutput', 'destroy');
});

function ResetData() {
 
    $("#productsuit21").val("");
    $("#productname21").val("");
    $('#customerName').val(null).trigger('change');
    $("#ModuleName").val("");
    
    $("#enddate1").val("");
    $("#inputRemark").val("");
    $("#description").val("");
    $("#expectedOutput").val("");

    callToolTip231('productsuit21', 'hide');
    callToolTip231('productname21', 'hide');
    callToolTip231('customerName', 'hide');
    callToolTip231('ModuleName', 'hide');
    
    callToolTip231('enddate1', 'hide');
    callToolTip231('inputRemark', 'hide');
    callToolTip231('description', 'hide');
    callToolTip231('expectedOutput', 'hide');
}


function customizationTaskDetails(crno)
{
//	alert("hih")
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    window.location.href = base_url + "/PMS/ViewMyCutomizationTask?crno="+crno;
	    window.location.href = base_url + "/PMS/ViewAllCustomizationTask?crno="+crno;
}




function addNewRow() {
	
	$('#prodSuite').val($('#productsuit21').val());
	$('#prodTool').val($('#productname21').val());
	$('#customerNameh').val($('#customerName').val());
	$('#moduleNameh').val($('#ModuleName').val());
	$('#exDate').val($('#enddate1').val());
	$('#priority').val($('#inputRemark').val());
	$('#descriptions').val($('#description').val());
	$('#expectedOut').val($('#expectedOutput').val());
	
//	alert($('#prodSuite').val());

	
	
	 if (rowCounter === 21) {
	        rowCounter = 22;
	    }
	
    const tableBody = document.querySelector("#data-table1 tbody");
    const newRow = tableBody.insertRow();
   
    // Product Suite dropdown cell
    const dropdownCell1 = newRow.insertCell();
    const dropdown1 = document.createElement('select');
//    dropdown1.id = 'productsuit21';
    dropdown1.id = 'productsuit' + rowCounter;
    dropdown1.classList.add('form-control', 'form-control-sm');
    populateDropdownProdSuite(dropdown1);
//    dropdown1.value=$('#prodSuite').val();
    dropdownCell1.appendChild(dropdown1);
    
    
   
    dropdown1.onchange = function() {
    	
    	var prodSuite = dropdown1.value;
//    	 dropdown1.value=$('#productname21').val();
        populateDropdownProdTool(dropdown2,prodSuite);
//        dropdown2.value=$('#prodSuite').val();
    };

    
    
    

    // Product Tool dropdown cell
    const dropdownCell2 = newRow.insertCell();
    const dropdown2 = document.createElement('select');
//    dropdown2.id = 'prodTool';
    dropdown2.id = 'productname' + rowCounter;
    dropdown2.value=$('#productname21').val();
    dropdown2.classList.add('form-control', 'form-control-sm');
    populateDropdownProdToolLoad(dropdown2);
    dropdownCell2.appendChild(dropdown2);


    
    

    // Customer Name dropdown cell
    const dropdownCell3 = newRow.insertCell();
    const dropdown3 = document.createElement('select');
//    dropdown3.id = 'customerName';
    dropdown3.id = 'customerName' + rowCounter;
    dropdown3.value=$('#customerNameh').val();
    dropdown3.classList.add('form-control', 'form-control-sm');
    populateDropdownCustName(dropdown3);  // Populate with customer names
    dropdown3.style="width:100%";
    dropdownCell3.appendChild(dropdown3);
    $(dropdown3).select2({
        placeholder: "Customer Name", 
        allowClear: true,      
        
    });
    
    

    // Module Name text input
    const cell1 = newRow.insertCell();
    const input1 = document.createElement('input');
    input1.type = 'text';
    input1.value=$('#moduleNameh').val();
    input1.classList.add('form-control', 'form-control-sm');
//    input1.id = 'ModuleName';
    input1.id = 'ModuleName' + rowCounter;
    input1.placeholder = 'Enter Module Name';
    cell1.appendChild(input1);

    // Expected Date input (date picker)
//    const cell2 = newRow.insertCell();
//    const input2 = document.createElement('input');
//    input2.type = 'date';
//    input2.classList.add('form-control', 'form-control-sm');
//    input2.id = 'enddate';
//    cell2.appendChild(input2);
    const cell2 = newRow.insertCell();

    const inputGroup = document.createElement('div');
    inputGroup.classList.add('input-group');

    const inputGroupText = document.createElement('span');
//    inputGroupText.classList.add('input-group-text');
//    inputGroupText.innerHTML = '<i class="far fa-calendar-alt"></i>'; 

    const input2 = document.createElement('input');
    input2.type = 'text'; 
    input2.value=$('#exDate').val();
    input2.classList.add('form-control', 'pull-right', 'form-control-sm');
    input2.id = 'enddate1';  
    input2.id = 'enddate1' + rowCounter;
    input2.placeholder = 'Select Date';  
    input2.readOnly = true; 

    inputGroup.appendChild(inputGroupText);
    inputGroup.appendChild(input2);

    cell2.appendChild(inputGroup);

//    $('#enddate1').datepicker({
//        format: 'dd-MMM-yyyy',
//        autoclose: true,
//        todayHighlight: true 
//    });
    
//    alert("enddate1"+rowCounter);
    
    $('#enddate1' + rowCounter).datepicker({
    	format: 'dd-mm-yyyy', 
        autoclose: true,
        todayHighlight: true
    });
    
    

    // Priority Type dropdown cell
    const dropdownCell4 = newRow.insertCell();
    const dropdown4 = document.createElement('select');
//    dropdown4.id = 'inputRemark';
    dropdown4.id = 'inputRemark' + rowCounter;
    dropdown4.value=$('#priority').val();
    dropdown4.classList.add('form-control', 'form-control-sm');
    const options = ['-- Please Select --', 'Low', 'Normal', 'High', 'Immediate'];
    options.forEach(optionText => {
        const option = document.createElement('option');
        option.value = optionText;
        option.text = optionText;
        dropdown4.appendChild(option);
    });
    dropdown4.value=$('#priority').val();
    dropdownCell4.appendChild(dropdown4);

    // Customization/Issue/Bug/Challenges text area
    const cell3 = newRow.insertCell();
    const textarea1 = document.createElement('textarea');
    textarea1.classList.add('form-control');
//    textarea1.id = 'description';
    textarea1.id = 'description' + rowCounter;
//    textarea1.value=$('#descriptions').val();
    textarea1.placeholder = 'Enter Description';
    cell3.appendChild(textarea1);

    // Expected Output text area
    const cell4 = newRow.insertCell();
    const textarea2 = document.createElement('textarea');
//    textarea2.value=$('#expectedOut').val();
    textarea2.classList.add('form-control');
//    textarea2.id = 'expectedOutput';
    textarea2.id = 'expectedOutput' + rowCounter;
    textarea2.placeholder = 'Enter Expected Output';
    cell4.appendChild(textarea2);

    // Delete row button
    const deleteCell = newRow.insertCell();
    const deleteButton = document.createElement('button');
    deleteButton.type = 'button';
    deleteButton.classList.add('btn');
    const trashIcon = document.createElement('i');
    trashIcon.classList.add('fa-solid', 'fa-trash-can', 'fa-lg');
    trashIcon.style.color = '#fd4444';
    deleteButton.appendChild(trashIcon);

    deleteButton.onclick = function () {
        deleteRow(this);
    };
    deleteCell.appendChild(deleteButton);
    
    rowCounter++;
}

// Delete row function
function deleteRow(button) {
    const row = button.closest('tr');
    row.remove();
}


function prodsuiteval(rowCounter){
	
	var nRow=rowCounter;
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getproductsuitlist";

  $.ajax({

      url :serviceUrl,
      type : 'POST',
      dataType: 'json',
      
  }).done(function(data) {

      var html='<option value="">-- Please Select Product Suite --</option>';
      for (var i = 0; i < data.length; i++) {
          html += '<option value="' +data[i]+ '">' + data[i]
          + '</option>';
      }
      document.getElementById("productsuit"+nRow).innerHTML=html;
	     
  });
}


//function c(rowCounter){
//	
//	var nRow=rowCounter;
//	var productSuit
//	
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getsecuritysolutionList";
//
//	$.ajax({
//	    type: 'POST',
//	    url: serviceUrl,
//	    dataType:'JSON',
////	    data: 'productsuit=' + encodeURIComponent($("#productsuit21").val())
//	    data:  'productsuit=' + productSuit
//	}).done(function(data) {
//	
//		 var html = "<option value=''>-- Please Select Product Tool --</option>";
//	      for (var i = 0; i < data.length; i++) {
//	          html += '<option value="' +data[i]+ '">' + data[i]
//	          + '</option>';
//	      }
//	      document.getElementById("productname").innerHTML=html;
//	});	
//}



function getSecToolsN(productSuit,rowCounter) {
	
	var NproductSuit=productSuit;
	var NrowNumber=rowCounter;
	

	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getproductnametoolN";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	      data: 'productSuite=' + NproductSuit
	      
	  }).done(function(data) {

	      var html='<option value="">-- Please Select Product Suite --</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
	      document.getElementById("productname"+NrowNumber).innerHTML=html;
	          
	  });
	
	
	
	
}


function custnameval(rowCounter){
	
	
	var nRow1=rowCounter;
	
//	alert("nRow1"+nRow1)
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCustomerName";

$.ajax({

    url :serviceUrl,
    type : 'POST',
    dataType: 'json',
}).done(function(data) {

//    var html =" <select class='form-control' tabindex='8' id='clientname' name='clientname'>";
    var html= '<option value="">--Please Select Customer--</option>';
    for (var i = 0; i < data.length; i++) {
        html += '<option value="' +data[i]+ '">' + data[i]
        + '</option>';
    }

    document.getElementById("customerName"+nRow1).innerHTML=html;
});
}
