var dataPoId = $('#crnoo').val();
$("#formCdata").hide();

//16/09
$("#assignedTaskdetailsCard").hide();
//

var jsonImplFormC = null;
var implName ='';
$('#spin1').hide();
$("#spin2").hide();

var role = $('#roletype').val();
var designation = $('#designation').val();

//alert("R "+role+"  D "+designation);
if (role === "Developer" && !(designation === "Jr. Team Leader" || designation === "Sr Team Leader" || designation === "Team Leader")) {
//	alert("Inn dev");
	$('#DeveloperOption').hide();
	$('#bulkuploaduserform').hide();
} else if(role === "Support" && !(designation === "Jr. Team Leader" || designation === "Sr Team Leader" || designation === "Team Leader" || designation === "Sr. Support Executive")) {
	$('#bulkuploaduserform').hide();
} else if(role === "Tester"){
	$('#bulkuploaduserform').hide();
}



if(role === "Support" || role ==="Support_Manager" ) {
	$("#custom-tabs-one-issue-tab").show();
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

	
	var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live', 'Other'];
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
//	var selectedValue = $("#teamLeader").val(); // Get the currently
	// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
//		data : 'teamLeader=' + encodeURIComponent(selectedValue),
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
//		data : 'supportteamLeader=' + encodeURIComponent(selectedValue),
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
		    	placeholder: "Select a Customer or Enter New",
//		        allowClear: true
		    })
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
		 
		 if(role=='Implementor' || role=='Support_Manager')
			{
				$('#teamLeaderNX').hide();
			}
			else if(role=='Developer' || role=='Tester' || role=='Support' && ((designation === "Jr. Team Leader" || designation === "Sr Team Leader" || designation === "Team Leader")))
			{
				$('#teamLeaderNX').hide();
			}
			else if(role=='Developer' || role=='Tester' || role=='Support' && (!(designation === "Jr. Team Leader" || designation === "Sr Team Leader" || designation === "Team Leader")))
			{
				$('#teamLeaderNX').hide();
			}
			else
			{
				$('#teamLeaderNX').show();
			}
		 
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

function addNewRow() {
//	alert("hih")
    const tableBody = document.querySelector("#data-table1 tbody");
    const newRow = tableBody.insertRow();

    // Dropdown cell 1
    const dropdownCell1 = newRow.insertCell();
    const dropdown1 = document.createElement('select');
    dropdown1.id = 'functionName';
    dropdown1.classList.add('form-control', 'form-control-sm');
    // Call the function to fetch and populate dropdown values
    populateDropdownFunc(dropdown1);
    dropdownCell1.appendChild(dropdown1);

    
    // Text inputs    

    const cell1 = newRow.insertCell();
    const input1 = document.createElement('input');
    input1.type = 'text';
    input1.classList.add('form-control', 'form-control-sm');
    input1.id = 'ModuleName'; 
    input1.placeholder = 'Enter Your Module';
    cell1.appendChild(input1);


 
//     Dropdown cell 2
    const dropdownCell2 = newRow.insertCell();
    const dropdown2 = document.createElement('select');
    dropdown2.id = 'Responsibility';
    dropdown2.classList.add('form-control', 'form-control-sm');

    // Create options and append them to the dropdown
    const options = ['-- Please Select --','End Customer', 'Velox Solution', 'Both'];
    options.forEach(optionText => {
        const option = document.createElement('option');
        option.value = optionText;
        option.text = optionText;
        dropdown2.appendChild(option);
    });
    dropdownCell2.appendChild(dropdown2);
    
 // Dropdown cell 5
//    const dropdownCell5 = newRow.insertCell();
//    const dropdown5 = document.createElement('select');
//    dropdown5.id = 'managerName';
//    dropdown5.classList.add('form-control', 'form-control-sm');
//    // Call the function to fetch and populate dropdown values
//    populateDropdownManager(dropdown5);
//    dropdownCell5.appendChild(dropdown5);
    
    
 // Dropdown cell 3
    const dropdownCell3 = newRow.insertCell();
    const dropdown3 = document.createElement('select');
    dropdown3.id = 'teamLeader';
    dropdown3.classList.add('form-control', 'form-control-sm');
    // Call the function to fetch and populate dropdown values
    populateDropdownTL(dropdown3);
    dropdownCell3.appendChild(dropdown3);
    
    
 
 // Dropdown cell 4
    const dropdownCell4 = newRow.insertCell();
    const dropdown4 = document.createElement('select');
    dropdown4.id = 'developer';
    dropdown4.classList.add('form-control', 'form-control-sm');
    // Call the function to fetch and populate dropdown values
    populateDropdownDev(dropdown4);
    dropdownCell4.appendChild(dropdown4);
    
    // Input 2 start Date
    const cell2 = newRow.insertCell();
    const input2 = document.createElement('input');
    input2.type = 'date';
    input2.classList.add('form-control','pull-right', 'form-control-sm');
    input2.id ='startdate'; 
    cell2.appendChild(input2);
    
    // Input 2 start Date
    const cell3 = newRow.insertCell();
    const input3 = document.createElement('input');
    input3.type = 'date';
    input3.classList.add('form-control','pull-right', 'form-control-sm');
    input3.id = 'enddate'; 
    cell3.appendChild(input3);
  
    // Text inputs    

    const cell4 = newRow.insertCell();
    const input4 = document.createElement('input');
    input4.type = 'text';
    input4.classList.add('form-control', 'form-control-sm');
    input4.id = 'inputRemark'; 
    input4.placeholder = 'Enter Remark';
    cell4.appendChild(input4);
    
    
 
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
    // Append the icon to the button
    deleteButton.appendChild(trashIcon);

    deleteButton.onclick = function () {
        deleteRow(this); // Pass the button itself as an argument
    };
    deleteCell.appendChild(deleteButton);

}


function deleteRow(button) {
    var rowToDelete = $(button).closest('tr');

    if ($('#data-table1 tbody tr').length > 1) {
        rowToDelete.remove();
    } 
}

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
	    + "&description=" + $("#description1").val(),
	
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


function getSecTools() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuit21").val())
	}).done(function(data) {
	
		 var html = "<option value=''>-- Please Select Product Tool --</option>";
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
	      document.getElementById("productname21").innerHTML=html;
	});	
}




function saveTaskWithoutPO() { 
	
	 if (!validateTaskData()) 
	   { 
	        event.preventDefault();
	   }
	     else 
	   {
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/saveTaskWithoutPO";
	$('#spin2').show();
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		data: "functionName=" + $("#functionName").val() 
		+ "&Responsibility=" + $("#Responsibility").val()
		+ "&customerName=" + $("#customerName").val()
		+ "&productsuit=" +$("#productsuit21").val()
		+ "&productname=" +$("#productname21").val()
	    + "&ModuleName=" + $("#ModuleName").val()
	    + "&teamLeader=" +$("#teamLeader").val()
	    + "&developer=" + $("#developer").val()
	    + "&inputRemark=" + $("#inputRemark").val()
	    + "&startdate=" + $("#startdate1").val()
	    + "&enddate=" + $("#enddate1").val()
	
	    
	    + "&description=" + encodeURIComponent($("#description").val())
	    + "&selectMe=" + $("#selectMe").val()
	    + "&testerName=" + $("#testerName").val()
	    + "&weightage=" + $("#weightage").val()
	    
	     + "&supportteamLeader=" + $("#supportteamLeader").val()
	      + "&support=" + $("#support").val(),
	    

		success : function(result) {
			
			if(!(result=="success" || result=="fail"  || result=="teamError") ) {
				var resultArr = result.split(",")
				var data = resultArr[0];
				var weightage = resultArr[1];
//				alert(data+" Error "+weightage);
			} else {
				var data = result;
			}
			
			$('#spin2').hide();
			if (data == "success") {
				swal({
					title : "Successful!",
					text : "Task Assigned Successfully",
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
								+ "/Admin/TaskAssigntoDev";
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
								+ "/Admin/TaskAssigntoDev";
					}

				});

			} else if (data == "error") {
				swal({
					title : "Unsuccessful!",
					html : "You exceeded weightage above 100%,<br> Previous total weightage is :"+weightage+"<br> If weightage is 100, Then Put 0" ,
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
								+ "/Admin/TaskAssigntoDev";
					}

				});

			} else if (data == "fail") {
				swal({
					title : "Error!",
					text : "Failed to Assign Task",
					type : "error",
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
								+ "/Admin/TaskAssigntoDev";
					}
				});
			} else if (data == "teamError") {
				swal({
					title : "Unsuccessful!",
					text : "Task Not Assigned because Team Master don't have your team entry. Enter record of your team first.",
					type : "warning",
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
								+ "/Admin/TaskAssigntoDev";
					}
				});
			}
		}
	});
	}
}

function submitUploadbutton() {
	 $('#spin12').show();
//		alert("inside submitBulkUploadUser")
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/saveBulkUploadTaskFile";

		var formData = new FormData($('#bulkuploaduserform')[0]);
//		var formData = new FormData();
//		formData.append('file', $('#bulkUserData')[0].files[0]);

		// Now, formData contains the file selected by the user in the input field with the name 'bulkUserData'

	//alert("formmmm"+formData);

		$
				.ajax({
					url: serviceUrl,
				    type: 'POST',
				    data: formData,
				    mimeType: "multipart/form-data",
				    contentType: false,
				    processData: false,
				    cache: false,
				    success: function(data){
		
//				    	alert("dataaa " + data);
				    	
//				    	if(data.includes("WeightageError"))
//				    	{
//				    		 swal({
//					                title: "Error!",
//					                text: "Total weightage exceeds 100%. Please check your file and try again.",
//					                type: "error",
//					                width: 300,
//					                height: 200,
//					                buttons: false,
//					                allowOutsideClick: false,
//					            });
//				    		 $('#spin12').hide();
//				    	}
				    	
				    	
				    		if (data.includes("WeightageError")) { 
				            
				            var match = data.match(/Previous_Weightage:_([\d.]+)/);
				            var weightageValue = match ? match[1] : "unknown"; 

				            swal({
				                title: "Error!",
				                text: "Total weightage exceeds 100% (Previous Weightage: " + weightageValue + "). Please check your file and try again.",
				                type: "error",
				                width: 300,
				                height: 200,
				                buttons: false,
				                allowOutsideClick: false,
				            });
				            $('#spin12').hide();
				            return; 
				        }
				    	
				    	var result = data.split(" ");
				    	var firstWord = result[0]; 
				    	
				    	var message = "";
				    	for (var i = 1; i < result.length; i++) {
				    		message += result[i];
				    	    if (i < result.length - 1) {
				    	    	message += " "; // Add space between words
				    	    }
				    	}
				    	
				    	
				    	

				    	if(!(firstWord=="Success" || firstWord=="Error" || firstWord =="" || firstWord=="notMandatory" ) || data==null) {
				    	var jsonArray = JSON.parse(data);
				    	var Status = jsonArray[0];
				    	var rowValues = jsonArray.slice(1);
//				    	alert("rowValues "+rowValues);
				    	
				    	
				    	}
				    	
				    	
				    	 
				    	
				    $('#spin12').hide();
				    if (firstWord == "Success" || firstWord =="Unique") {
				        swal({
				            title: "Successful!",
				            text: "Record Added Successfully",
				            type: "success",
				            width: 300,
				            height: 200,
				            buttons: false,
				            allowOutsideClick: false,
				            preConfirm: function () {
				                var l = window.location;
				                var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
				                window.location.href = base_url + "/Admin/TaskAssigntoDev";
				            }
				        });
				    } else if (firstWord == "Error") {
				        swal({
				            title: "Unsuccessful!",
				            text: "Fail to add file",
				            type: "error",
				            width: 300,
				            height: 200,
				            buttons: false,
				            allowOutsideClick: false,
//				            preConfirm: function () {
//				                var l = window.location;
//				                var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//				                window.location.href = base_url + "/Admin/CustomerMaster";
//				            }
				        });
				    } else if (firstWord == "notMandatory") {
				        swal({
				            title: "Unsuccessful!",
				            html: "Fields highlighted in Excel are mandatory. Please fill in these fields." ,
				            type: "warning",
				            width: 300,
				            height: 200,
				            buttons: false,
				            allowOutsideClick: false,
				        }); 
				    } else if (Status == "Duplicate") {
				        swal({
				            title: "Duplicate!",
				            html: "Records were inserted successfully, but duplicate rows were skipped.<br><br><strong>Duplicate Row : </strong>"+rowValues ,
				            type: "warning",
				            width: 300,
				            height: 200,
				            buttons: false,
				            allowOutsideClick: false,
//				            preConfirm: function () {
//				                var l = window.location;
//				                var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//				                window.location.href = base_url + "/Admin/CustomerMaster";
//				            }
				        });
				    }
	}
				})
}




function validateTaskData() {
    var indexError = 0;
    if ($('#functionName').val().trim() === '') {
        callToolTip231('functionName', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#Responsibility').val().trim() === '') {
        callToolTip231('Responsibility', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }   
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
    if ($('#selectMe').val().trim() === '') {
        callToolTip231('selectMe', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#testerName').val().trim() === '' && $('#selectMe').val()==="Tester" ) {
        callToolTip231('testerName', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#teamLeader').val().trim() === '' &&  $('#selectMe').val()==="Developer") {
        callToolTip231('teamLeader', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }                          
    if ($('#developer').val().trim() === '' &&  $('#selectMe').val()==="Developer") {
        callToolTip231('developer', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#weightage').val().trim() === '') {
        callToolTip231('weightage', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#startdate1').val().trim() === '') {
        callToolTip231('startdate1', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
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
    
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}




var callToolTip231 = function(fieldName, status) {

    if (fieldName == "functionName") {
        var errorMessage = "<span>Please Select Function Name <span>";
    }
     else if (fieldName == "Responsibility") {
        var errorMessage = "<span>Please Select Responsibility <span>";
    }
     else if (fieldName == 'productsuit21') {
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
     else if (fieldName == 'selectMe') {
     	var errorMessage = "<span>Please Select Assign to <span>";
     }
     else if (fieldName == 'testerName') {
     	var errorMessage = "<span>Please Select Tester Name <span>";
     }
     else if (fieldName == 'teamLeader') {
     	var errorMessage = "<span>Please Select Team Leader <span>";
     }
     else if (fieldName == 'developer') {
      	var errorMessage = "<span>Please Select Developer <span>";
      }
     else if (fieldName == 'weightage') {
     	var errorMessage = "<span>Please Select Weightage <span>";
     }
     else if (fieldName == 'startdate1') {
      	var errorMessage = "<span>Please Select Start Date <span>";
      }
     else if (fieldName == 'enddate1') {
      	var errorMessage = "<span>Please Select End Date <span>";
      }
     else if (fieldName == 'inputRemark') {
       	var errorMessage = "<span>Enter Remark <span>";  
      }  
     else if (fieldName == 'description') {
         	var errorMessage = "<span>Enter Description <span>";  
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




//$('#functionName').on('focusout', function() {
//	var value = $('#functionName').val();
//	if(value.trim() == "") {
//		callToolTip231('functionName', 'show');
//	} else {
//		callToolTip231('functionName', 'hide');
//	}
//});
//$('#Responsibility').on('focusout', function() {
//	var value = $('#Responsibility').val();
//	if(value.trim() == "") {
//		callToolTip231('Responsibility', 'show');
//	} else {
//		callToolTip231('productsuitdetails', 'hide');
//	}
//});
//$('#productsuit21').on('focusout', function() {
//	var value = $('#productsuit21').val();
//	if(value.trim() == "") {
//		callToolTip231('productsuit21', 'show');
//	} else {
//		callToolTip231('productsuit21', 'hide');
//	}
//});
//
//$('#productname21').on('focusout', function() {
//    var value = $('#productname21').val();
//    if(value.trim() == "") {
//        callToolTip231('productname21', 'show');
//    } else {
//        callToolTip231('productname21', 'hide');
//    }
//});
//
//$('#customerName').on('focusout', function() {
//    var value = $('#customerName').val();
//    if(value.trim() == "") {
//        callToolTip231('customerName', 'show');
//    } else {
//        callToolTip231('customerName', 'hide');
//    }
//});
//
//$('#ModuleName').on('focusout', function() {
//    var value = $('#ModuleName').val();
//    if(value.trim() == "") {
//        callToolTip231('ModuleName', 'show');
//    } else {
//        callToolTip231('ModuleName', 'hide');
//    }
//});
//
//$('#selectMe').on('focusout', function() {
//    var value = $('#selectMe').val();
//    if(value.trim() == "") {
//        callToolTip231('selectMe', 'show');
//    } else {
//        callToolTip231('selectMe', 'hide');
//    }
//});
//
//$('#testerName').on('focusout', function() {
//    var value = $('#testerName').val();
//    if(value.trim() == "") {
//        callToolTip231('testerName', 'show');
//    } else {
//        callToolTip231('testerName', 'hide');
//    }
//});
//
//$('#teamLeader').on('focusout', function() {
//    var value = $('#teamLeader').val();
//    if(value.trim() == "") {
//        callToolTip231('teamLeader', 'show');
//    } else {
//        callToolTip231('teamLeader', 'hide');
//    }
//});
//
//$('#developer').on('focusout', function() {
//    var value = $('#developer').val();
//    if(value.trim() == "") {
//        callToolTip231('developer', 'show');
//    } else {
//        callToolTip231('developer', 'hide');
//    }
//});
//
//$('#weightage').on('focusout', function() {
//    var value = $('#weightage').val();
//    if(value.trim() == "") {
//        callToolTip231('weightage', 'show');
//    } else {
//        callToolTip231('weightage', 'hide');
//    }
//});
//
//$('#startdate1').on('focusout', function() {
//    var value = $('#startdate1').val();
//    if(value.trim() == "") {
//        callToolTip231('startdate1', 'show');
//    } else {
//        callToolTip231('startdate1', 'hide');
//    }
//});
//
//$('#enddate1').on('focusout', function() {
//    var value = $('#enddate1').val();
//    if(value.trim() == "") {
//        callToolTip231('enddate1', 'show');
//    } else {
//        callToolTip231('enddate1', 'hide');
//    }
//});
//
//$('#inputRemark').on('focusout', function() {
//    var value = $('#inputRemark').val();
//    if(value.trim() == "") {
//        callToolTip231('inputRemark', 'show');
//    } else {
//        callToolTip231('inputRemark', 'hide');
//    }
//});
//
//$('#description').on('focusout', function() {
//    var value = $('#description').val();
//    if(value.trim() == "") {
//        callToolTip231('description', 'show');
//    } else {
//        callToolTip231('description', 'hide');
//    }
//});



$('#functionName').on('focus', function() {
    callToolTip231('functionName', 'destroy');
});

$('#Responsibility').on('focus', function() {
    callToolTip231('Responsibility', 'destroy');
});

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

$('#selectMe').on('focus', function() {
    callToolTip231('selectMe', 'destroy');
});

$('#testerName').on('focus', function() {
    callToolTip231('testerName', 'destroy');
});

$('#teamLeader').on('focus', function() {
    callToolTip231('teamLeader', 'destroy');
});

$('#developer').on('focus', function() {
    callToolTip231('developer', 'destroy');
});

$('#weightage').on('focus', function() {
    callToolTip231('weightage', 'destroy');
});

$('#startdate1').on('focus', function() {
    callToolTip231('startdate1', 'destroy');
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


function ResetData() {
    $("#functionName").val("");
    $("#Responsibility").val("");
    $("#productsuit21").val("");
    $("#productname21").val("");
    $('#customerName').val(null).trigger('change');
    $("#ModuleName").val("");
    $("#selectMe").val("");
    $("#testerName").val("");
    $("#teamLeader").val("");
    $("#developer").val("");
    $("#weightage").val("");
    $("#startdate1").val("");
    $("#enddate1").val("");
    $("#inputRemark").val("");
    $("#description").val("");

    callToolTip231('functionName', 'hide');
    callToolTip231('Responsibility', 'hide');
    callToolTip231('productsuit21', 'hide');
    callToolTip231('productname21', 'hide');
    callToolTip231('customerName', 'hide');
    callToolTip231('ModuleName', 'hide');
    callToolTip231('selectMe', 'hide');
    callToolTip231('testerName', 'hide');
    callToolTip231('teamLeader', 'hide');
    callToolTip231('developer', 'hide');
    callToolTip231('weightage', 'hide');
    callToolTip231('startdate1', 'hide');
    callToolTip231('enddate1', 'hide');
    callToolTip231('inputRemark', 'hide');
    callToolTip231('description', 'hide');
}

