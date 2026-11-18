$("#RD").hide();
$('#maskedUploadDiv').hide();
$('#spin').hide();


$(document).ready(function () {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getRDDropdownValue";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data) {
            var dropdown = $('#rdNumber');
            dropdown.empty(); 
                        
            $.each(data, function(index, value) {
                dropdown.append($('<option>').text(value).attr('value', value));
            });
          
            dropdown.selectpicker('refresh');
        },
        error: function(xhr, status, error) {
            console.error("Error fetching dropdown values:", error);
        }
      
    });    
});


function resetRD(){
	$("#RD").hide();
	callToolTip231('rdNumber', 'hide');
	}


function resetRDNum() {
	var rdSelect = document.getElementById('rdNumber'); // Get the dropdown element
	rdSelect.selectedIndex = -1; // Resetting the selected index to -1 (no option selected)
	rdSelect.title = 'Please Select RD'; // Adding a title to indicate selection
	$('#rdNumber').val(""); // Clearing the selected value using jQuery

  
 
}



window.onload = function() {
	$('#spin1').hide();
	 $('#uploadfileform').hide();
	 getTeamlead();
	 getDeveloper();
	 
	 //UD Details Table
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getUdDetailsTable";
	$('#spin12').show();
	 $.ajax({
	     type: 'POST',
	     url: serviceUrl,
	     dataType: 'json',
	     success: function(data4) {
	    	 

	    		$('#spin12').hide();
	         var table = $('#UDDetails').DataTable({
	             lengthChange: false,
	             data: data4,
	              "pageLength": 5,
	              scrollX: '300px'
	         });	    
	     }
	 });
	 
	 
	 
	// get Function Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getFunctionName";
	var selectedValue = $("#functionName").val(); // Get the currently
													// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'abc=' + encodeURIComponent(selectedValue),
		success : function(data4) {

//			alert("function "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#functionName").html(html); // Update the select element
			$("#functionName").val(selectedValue); // Set the selected value
		}
	});
	
	
	
	// Get Designation Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getDesignation";
	var selectedValue = $("#designation").val(); // Get the currently
													// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'docName=' + encodeURIComponent(selectedValue),
		success : function(data4) {
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#designation").html(html); // Update the select element
			$("#designation").val(selectedValue); // Set the selected value
		}
	});
	
//	 getPonumber();
	
}

$('#submitDoc').click(function() {
	var fName = $("#functionName").val();
	$("#funcName").text(fName);
	if (!validateFunctionName()) 
	   { 
	        event.preventDefault();
	   }
	     else 
	   {
	    	 $('#registrationform').show();
	    	 $('#uploadfileform').show();
	    	 $('#rowid').hide();
	    	 
	   }

});



function getUserName() {
	// Get Designation Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getUserName";
	var selectedValue = $("#designation").val(); // Get the currently
													// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'designation=' + encodeURIComponent(selectedValue),
		success : function(data4) {
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#username").html(html); // Update the select element
			$("#username").val(selectedValue); // Set the selected value
		}
	});
}


function getUserID() {
	// Get Designation Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getUserID";
	var selectedValue = $("#username").val(); // Get the currently
													// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'username=' + encodeURIComponent(selectedValue),
		success : function(data4) {
		//	alert("id "+data4)
			
			document.getElementById("userId").value = data4;
		}
	});
}

function validateRDnumber() {
    var indexError = 0;
    if ($('#rdNumber').val().trim() === '') {
        callToolTip231('rdNumber', 'show');
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

    if (fieldName == "rdNumber") {
        var errorMessage = "<span>Please Select RD <span>";
    }
   
    $("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });

    if (status == "show") {

        $("#" + fieldName).tooltip('show');

    } else {
        $("#" + fieldName).tooltip('hide');
    }
}


$('#rdNumber').on('focusout', function() {
	var usertype = $('#rdNumber').val();
	if(usertype.trim() == "") {
		callToolTip231('rdNumber', 'show');
	} else {
		callToolTip231('rdNumber', 'hide');
	}
});



$('#rdNumber').on('focus', function() {
	callToolTip231('rdNumber', 'destroy');
});


$("#resetrd").click(function() {
     
	 $('#registrationform').hide();
	 $('#uploadfileform').hide();
	 $("#RD").hide();
     $("#rdNumber").val("");
     callToolTip231('rdNumber', 'hide');
     $('#rowid').show();
});


// Addd
function addRow() {

	   const tableBody = document.querySelector("#data-table tbody");
	   const newRow = tableBody.insertRow();
	   
	   const dropdownCell = newRow.insertCell();
	    const dropdown = document.createElement('select');
	    	
	    dropdown.id = 'designation';  
	    dropdown.classList.add('form-control', 'form-control-sm');

	    // Call the function to fetch and populate dropdown values
	    populateDropdownValues(dropdown);

	    dropdownCell.appendChild(dropdown);
	   

	    // Text inputs for other columns
	    const placeholders = ['Enter User Name', 'Enter User ID', 'Enter User Description'];
	    const inputIds = ['userName', 'userId', 'userDescription']; // Assign unique IDs
	    for (let i = 0; i < 3; i++) {
	        const cell = newRow.insertCell();
	        const input = document.createElement('input');
	        input.type = 'text';
	        input.id = inputIds[i]; // Assign unique IDs to each input
	        input.classList.add('form-control', 'form-control-sm');
	        input.placeholder = placeholders[i];
	        cell.appendChild(input);
	    }


//	   const addCell = newRow.insertCell();
//	   const addButton = document.createElement('button');
//	   addButton.textContent = 'Add';
//	   addButton.type ='button';
//	   addButton.classList.add('btn', 'btn-primary');
//	   addButton.onclick = function() {
//		   adEmp(addButton);
//	   };
//	   addCell.appendChild(addButton);
	   
	   const deleteCell = newRow.insertCell();
	   const deleteButton = document.createElement('button');
	   deleteButton.textContent = 'Delete';
	   deleteButton.type ='button';
	   deleteButton.classList.add('btn', 'btn-danger');
	   deleteButton.onclick = function() {
		   deleteRow(deleteButton);
	   };
	   deleteCell.appendChild(deleteButton);
}

function deleteRow(btn) {
	   const row = btn.parentNode.parentNode;
	   row.parentNode.removeChild(row);
	}


function populateDropdownValues(dropdown) {
	    var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/Master/getDesignation";

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

//Add UD
function saveAllData() {
	
//	const tableBody = document.querySelector("#data-table tbody");
//	const rows = tableBody.querySelectorAll('tr');
//	const dataArray = [];
//
//	for (const row of rows) {
//	    const inputs = row.querySelectorAll('input');
//	    const selects = row.querySelectorAll('select'); // Fix here: change 'select' to 'selects'
////	    alert("hhhhhhh" + selects[0]);
//
//	    for (const input of inputs) {
//	        if (input.value.trim() === '') {
//	            alert('One or more fields are empty. Please fill them out.');
//	            return; // Exit the function if any input is empty
//	        }
//	    }
//
//	    const dataObj = {
//	        data1: selects[0].value,
//	        data2: inputs[0].value,
//	        data3: inputs[1].value,
//	        data4: inputs[2].value
//	    };
//	    dataArray.push(dataObj);
//	}

	// Serialize dataArray for sending it in the AJAX request
	//	var alldata = JSON.stringify(dataArray);
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/saveNewUD";
	$('#spin').show();
	
	var formData= new FormData(form);
	
	var startDate = new Date(document.getElementById("startDate").value);
    var endDate = new Date(document.getElementById("endDate").value);

//	formData.append('functionName', $('#documentType5').val());
//	formData.append('designation', $('#designation').val());
//	formData.append('username', $('#username').val());
//	formData.append('userid', $("#userId").val());
//	formData.append('description', $("#description").val());
//	formData.append('endDate', $("#endDate").val());
    if (endDate <= startDate){
    	
    	swal({
                    title: "Warning",
                    text: "Project End Date should be Greater than Start Date!",
                    type: "warning",
                    width: 300,
                    allowOutsideClick: false,
                    
                    
                    
                    

                });
    	$('#spin').hide();
         return false;
    }else{
    
	
	formData.append('poNumber', $("#documentType2").val());
	formData.append('rd_id', $("#rdNumber").val());
	formData.append('producSuiteNames', $("#documentType3").val());
	formData.append('Securitytool', $("#documentType1").val());
	formData.append('ProdManager', $("#documentType4").val());
	formData.append('functionName', $("#documentType5").val());
	formData.append('noteType', $("#noteType").val());
	formData.append('filenameStandard', $("#filenameStandard").val());
	formData.append('maskeduploadfile', $("#maskeduploadfile").val());
	formData.append('Teamlead', $("#Teamlead").val());
	formData.append('Dev', $("#Dev").val());
	formData.append('projectDesc', $("#projectDesc").val());
	formData.append('projectObj', $("#projectObj").val());
	formData.append('projectScope', $("#projectScope").val());
	formData.append('funcReq', $("#funcReq").val());
	formData.append('nonFuncReq', $("#nonFuncReq").val());
	formData.append('techReq', $("#techReq").val());
	
//	if (endDate <= startDate) {
//        // Show a popup (you can replace this with your desired UI logic)
//        alert("End date should be greater than start date.");
//        event.preventDefault();
//        
//    } else {
        
    	formData.append('startDate', $("#startDate").val());
    	formData.append('endDate', $("#endDate").val());
//    }
	
	
//	formData.append('startDate', $("#startDate").val());
//	formData.append('endDate', $("#endDate").val());
	
	var fileInput = document.getElementById('fileInput');
	formData.append('fileInput', fileInput.files[0]);
    
	var OtherfileInput = document.getElementById('otherFile');
	formData.append('otherFileInput', OtherfileInput.files[0]);
	
	$.ajax({
	    
   	 type: 'POST',
        url: serviceUrl,
        data: formData,
        processData: false,  // Important: tell jQuery not to process the data
        contentType: false,
   }).done(function(data) {
//   	alert(data)
       // Handle different server responses
   	$('#spin').hide();
   	
   	const resultArray = data.split(',');
		const poid = resultArray[0];
		const sts = resultArray[1];
		
       if (sts == "success") {
           // Display success message using SweetAlert and redirect
           swal({
               title: "Successful!",
               text: "Record Inserted Successfully",
               html: "UD ID = " + poid + "<br><br> UD Raised Successfully",
               type: "success",
               width: 300,
               height: 200,
               buttons: false,
               allowOutsideClick: false,
               preConfirm: function() {
                   window.location.href = base_url + "/Admin/UnderstandingDoc";
               }
           });
       } else if (data == "duplicate") {
           // Display duplicate data message using SweetAlert and redirect
           swal({
               title: "Duplicate Data!",
               text: "Record Already Exists",
               type: "warning",
               width: 300,
               height: 200,
               buttons: false,
               allowOutsideClick: false,
               preConfirm: function() {
                   window.location.href = base_url + "/Admin/UnderstandingDoc";
               }
           });
       } else if (data == "error") {
           // Display error message using SweetAlert and redirect
           swal({
               title: "Unsuccessful!",
               text: "Fail to add file",
               type: "error",
               width: 300,
               height: 200,
               buttons: false,
               allowOutsideClick: false,
               preConfirm: function() {
                   window.location.href = base_url + "/Admin/UnderstandingDoc";
               }
           });
       }
   
   });
    }
	}




function submitData(){
		   
	 if (!validateUDData()) 
	 {
		   // alert("fail")
		 event.preventDefault();
	} else {
		saveAllData();
	}
}



function validateUDData() {
    var indexError = 0;
  
    if ($('#Teamlead').val().trim() === '') {
        callToolTip2('Teamlead', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#Dev').val().trim() === '') {
        callToolTip2('Dev', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#projectDesc').val().trim() === '') {
        callToolTip2('projectDesc', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#projectObj').val().trim() === '') {
        callToolTip2('projectObj', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#projectScope').val().trim() === '') {
        callToolTip2('projectScope', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#funcReq').val().trim() === '') {
        callToolTip2('funcReq', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#nonFuncReq').val().trim() === '') {
        callToolTip2('nonFuncReq', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#techReq').val().trim() === '') {
        callToolTip2('techReq', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#startDate').val().trim() === '') {
        callToolTip2('startDate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#endDate').val().trim() === '') {
        callToolTip2('endDate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    
    
//    if ($('#not').val().trim() === '') {
//        callToolTip2('not', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//     if ($('#description').val().trim() === '') {
//        callToolTip2('description', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
     
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}



var callToolTip2 = function(fieldName, status) {

    if (fieldName == "Teamlead") {
        var errorMessage = "<span>Please Select Team Leader<span>";
    }
    else if (fieldName == "Dev"){
    	var errorMessage = "<span>Please Select Developer<span>";
    }
    else if (fieldName == "not"){
    	var errorMessage = "<span>Please Enter Note <span>";
    }
     else if (fieldName == "description"){
    	var errorMessage = "<span>Enter Description<span>";
    }
    
     else if (fieldName == "projectDesc"){
     	var errorMessage = "<span>Enter Project Description<span>";
     } 
     else if (fieldName == "projectObj"){
     	var errorMessage = "<span>Enter Project Objective<span>";
     } 
     else if (fieldName == "projectScope"){
     	var errorMessage = "<span>Enter project Scope<span>";
     } 
     else if (fieldName == "funcReq"){
     	var errorMessage = "<span>Enter Function Requirements<span>";
     } 
     else if (fieldName == "nonFuncReq"){
     	var errorMessage = "<span>Enter Non Function Requirements<span>";
     } 
     else if (fieldName == "techReq"){
     	var errorMessage = "<span>Enter Technical Requirements<span>";
     }
     else if (fieldName == "startDate"){
      	var errorMessage = "<span>Enter Project Start Date<span>";
      }
     else if (fieldName == "endDate"){
      	var errorMessage = "<span>Enter Project End Date<span>";
      }

    $("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });

    if (status == "show") {
        $("#" + fieldName).tooltip('show');

    } else {
        $("#" + fieldName).tooltip('hide');
    }
}

$('#Teamlead').on('focusout', function() {
    var usertype = $('#Teamlead').val();

    if (usertype.trim() == "") {
        callToolTip2('Teamlead', 'show');
    }
    else {
        callToolTip2('Teamlead', 'hide');
    }
});
$('#Dev').on('focusout', function() {
    var usertype = $('#Dev').val();

    if (usertype.trim() == "") {
        callToolTip2('Dev', 'show');
    }
    else {
        callToolTip2('Dev', 'hide');
    }
});

$('#projectDesc').on('focusout', function() {
    var usertype = $('#projectDesc').val();

    if (usertype.trim() == "") {
        callToolTip2('projectDesc', 'show');
    }
    else {
        callToolTip2('projectDesc', 'hide');
    }
});
$('#projectObj').on('focusout', function() {
    var usertype = $('#projectObj').val();

    if (usertype.trim() == "") {
        callToolTip2('projectObj', 'show');
    }
    else {
        callToolTip2('projectObj', 'hide');
    }
});
$('#funcReq').on('focusout', function() {
    var usertype = $('#funcReq').val();

    if (usertype.trim() == "") {
        callToolTip2('funcReq', 'show');
    }
    else {
        callToolTip2('funcReq', 'hide');
    }
});
$('#nonFuncReq').on('focusout', function() {
    var usertype = $('#nonFuncReq').val();

    if (usertype.trim() == "") {
        callToolTip2('nonFuncReq', 'show');
    }
    else {
        callToolTip2('nonFuncReq', 'hide');
    }
});
$('#techReq').on('focusout', function() {
    var usertype = $('#techReq').val();

    if (usertype.trim() == "") {
        callToolTip2('techReq', 'show');
    }
    else {
        callToolTip2('techReq', 'hide');
    }
});

$('#startDate').on('focusout', function() {
    var usertype = $('#startDate').val();

    if (usertype.trim() == "") {
        callToolTip2('startDate', 'show');
    }
    else {
        callToolTip2('startDate', 'hide');
    }
});

$('#endDate').on('focusout', function() {
    var usertype = $('#endDate').val();

    if (usertype.trim() == "") {
        callToolTip2('endDate', 'show');
    }
    else {
        callToolTip2('endDate', 'hide');
    }
});

//
//$('#not').on('focusout', function() {
//    var usertype = $('#not').val();
//
//    if (usertype.trim() == "") {
//        callToolTip2('not', 'show');
//    }
//    else {
//        callToolTip2('not', 'hide');
//    }
//});

//$('#description').on('focusout', function() {
//    var usertype = $('#description').val();
//
//    if (usertype.trim() == "") {
//        callToolTip2('description', 'show');
//    }
//    else {
//        callToolTip2('description', 'hide');
//    }
//});



$('#Teamlead').on('click', function() {
	callToolTip2('Teamlead', 'destroy');
});
$('#Dev').on('click', function() {
	callToolTip2('Dev', 'destroy');
});
$('#not').on('click', function() {
	callToolTip2('not', 'destroy');
});
$('#description').on('click', function() {
	callToolTip2('description', 'destroy');
});
$('#projectDesc').on('click', function() {
	callToolTip2('projectDesc', 'destroy');
});
$('#projectObj').on('click', function() {
	callToolTip2('projectObj', 'destroy');
});
$('#projectScope').on('click', function() {
	callToolTip2('projectScope', 'destroy');
});
$('#funcReq').on('click', function() {
	callToolTip2('funcReq', 'destroy');
});
$('#nonFuncReq').on('click', function() {
	callToolTip2('nonFuncReq', 'destroy');
});
$('#techReq').on('click', function() {
	callToolTip2('techReq', 'destroy');
});

$('#startDate').on('focusout', function() {
	callToolTip2('startDate', 'destroy');
});

$('#endDate').on('click', function() {
	callToolTip2('endDate', 'destroy');
});



$("#resetbtn1").click(function() {
	$("#Dev").val('').trigger('change');
	$("#not").val('').trigger('change');
	$("#Teamlead").val('').trigger('change');
	$("#projectDesc").val('');
	$("#projectObj").val('');
	$("#projectScope").val('');
	$("#funcReq").val('');
	$("#nonFuncReq").val('');
	$("#techReq").val('');
	$("#startDate").val('');
	$("#endDate").val('');
	
	
     callToolTip2('Teamlead', 'destroy');
      callToolTip2('Dev', 'destroy');
       callToolTip2('not', 'destroy');
//     callToolTip2('description', 'destroy');
       callToolTip2('projectDesc', 'destroy');
       callToolTip2('projectObj', 'destroy');
       callToolTip2('projectScope', 'destroy');
       callToolTip2('funcReq', 'destroy');
       callToolTip2('nonFuncReq', 'destroy');
       callToolTip2('techReq', 'destroy');
       callToolTip2('startDate', 'destroy');
       callToolTip2('endDate', 'destroy');
      
});



//shreeeeeeeeeeeeeeeeeeee
function getPonumber() {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getPonumber";
    var selectedValue = $("#Ponumber").val(); // Get the currently
													// selected value

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
 //     data: 'docName=' + encodeURIComponent(selectedValue),
        success: function(data4) {
//       	alert(data4)
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data4.length; i++) {
                var value = data4[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            $("#Ponumber").html(html); // Update the select element
            $("#Ponumber").val(selectedValue); // Set the selected value
        }
    });
}
    
function getTeamlead() {
        var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        var serviceUrl = base_url + "/Master/getTeamLeader";
        var selectedValue = $("#Teamlead").val(); // Get the currently
    													// selected value

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
     //     data: 'docName=' + encodeURIComponent(selectedValue),
            success: function(data4) {
//           	alert(data4)
                var html = "<option value=''>-- Please Select --</option>";
                for (var i = 0; i < data4.length; i++) {
                    var value = data4[i];
                    html += '<option value="' + value + '">' + value + '</option>';
                }
                $("#Teamlead").html(html); // Update the select element
                $("#Teamlead").val(selectedValue); // Set the selected value
            }
        });
}


function getDeveloper() {
        var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        var serviceUrl = base_url + "/Master/getDevelopers";
        var TL = $("#Teamlead").val(); // Get the currently
    													// selected value

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            data: 'TeamLead=' + encodeURIComponent(TL),
            success: function(data4) {
//           	alert("nnnnn"+data4)
                var html = "<option value=''>-- Please Select --</option>";
                for (var i = 0; i < data4.length; i++) {
                    var value = data4[i];
                    html += '<option value="' + value + '">' + value + '</option>';
                }
                $("#Dev").html(html); // Update the select element
//                $("#Dev").val(selectedValue); // Set the selected value
            }
        });
}



//function getPonumber() {
//	
//	$('#RD').HIDE();	
//	$('#UD').SHOW();
//	
//////	$('#registrationform2').hide();
//////	$('#registrationform3').hide();
////	
////	var categorytype = $('#functionName').val();
////
////	if (categorytype != "" && categorytype === "Partner") {
////		$('#distributor').show();
////		$('#customer').hide();
////	} 
////	else if (categorytype != "" && categorytype === "Customer") {
////		$('#distributor').show();
////		$('#customer').show();
////	}else{
////		$('#distributor').hide();
////		$('#customer').hide();
////		
//
//}

//function getPonumber() {
//$('#RD').hide();
//
//// Add a click event listener to the 'UD' element
//$('#UD').click(function () {
//  // Show both 'RD' and 'UD'
//  $('#RD').show();
//  $('#UD').show();
//});
//}


//$(document).ready(function() {
//// Initial setup, hide 'RD'
//$('#RD').hide();
//
//// Add a click event listener to the 'UD' element
//$('#UD').click(function() {
//  // Show both 'RD' and 'UD'
//  $('#RD').show();
//  $('#UD').show();
//});
//});

$(document).ready(function() {
    // Initial setup, hide 'UD'
    $('#UD').hide();
    
    // Add a change event listener to the dropdown element
 
});


//$('#submitDoc').click(function() {
//	var fName = $("#functionName").val();
//	$("#funcName").text(fName);
//	if (!validateFunctionName()) 
//	   { 
//	        event.preventDefault();
//	   }
//	     else 
//	   {
//	    	 $('#registrationform').show();
//	    	 $('#uploadfileform').show();
//	    	 $('#rowid').hide();
//	    	 
//	   }
//});


$('#Selectrd').click(function() {
	if (!validateRDnumber()) 
		   { 
		        event.preventDefault();
		   }
		     else 
		   {
//		    	 $('#registrationform').show();
//		    	 $('#uploadfileform').show();
//		    	 $('#rowid').hide();
	
	
	$("#RD").show();
	   var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getselectrddetails";
	    var selectedValue1 = $("#rdNumber").val(); // Get the currently
//		alert("selectedValue1"+selectedValue1)												// selected value

	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'selectrddetails=' + selectedValue1,      // $("#documentType2").val(),
	        success: function(data1) {
//        	alert("ggggggggg"+data1[3])
//	        	alert("dataa1"+data1[0][0])
	        	var aaa = data1[0];
				
//				alert("AAAAA data::::::"+aaa)
//				alert("1212121"+aaa)
	        	$('#documentType2').val(decodeURIComponent(data1[0][0]));
				$('#documentType3').val(decodeURIComponent(aaa[1]));
//				alert("po number"+aaa[0][3])
				$('#documentType1').val(decodeURIComponent(aaa[2]));
				$('#documentType4').val(decodeURIComponent(aaa[3]));
				$('#documentType5').val(decodeURIComponent(aaa[4]));
				$('#noteType').val(decodeURIComponent(aaa[5]));
				
//				alert("Po File::: "+aaa[0][8])
				
				if ((decodeURIComponent(aaa[6]) == "File Not Attached")
						|| (decodeURIComponent(aaa[6]) == "NA")
						|| (decodeURIComponent(aaa[6]) == "null")) {
					$('#downHiderdfile').hide();
				} else {
					document.getElementById('rduploadfile').innerHTML = decodeURIComponent(aaa[6]);
					document.getElementById('filenameStandard').value = decodeURIComponent(aaa[6]);
					$('#rdUploadDiv').show();
				}
				
				if ((decodeURIComponent(aaa[7]) == "File Not Attached")
						|| (decodeURIComponent(aaa[7]) == "NA")
						|| (decodeURIComponent(aaa[7]) == "null")|| (decodeURIComponent(aaa[7]) == "")) {
					$('#maskedUploadDiv').hide();
				} else {
					document.getElementById('maskeduploadfile').innerHTML = decodeURIComponent(aaa[7]);
					document.getElementById('masekdfileStandard').value = decodeURIComponent(aaa[7]);
					$('#maskedUploadDiv').show();
				}
				
				if ((decodeURIComponent(aaa[8]) == "File Not Attached")
						|| (decodeURIComponent(aaa[8]) == "NA")
						|| (decodeURIComponent(aaa[8]) == "null")|| (decodeURIComponent(aaa[8]) == "")) {
					$('#scopeUploadDiv').hide();
				} else {
					document.getElementById('scopeuploadfile').innerHTML = decodeURIComponent(aaa[8]);
					document.getElementById('downHidescopefile').value = decodeURIComponent(aaa[8]);
					$('#scopeUploadDiv').show();
				}
				
				if ((decodeURIComponent(aaa[9]) == "File Not Attached")
						|| (decodeURIComponent(aaa[9]) == "NA")
						|| (decodeURIComponent(aaa[9]) == "null")|| (decodeURIComponent(aaa[9]) == "")) {
					$('#RFPUploadDiv').hide();
				} else {
					document.getElementById('RFPuploadfile').innerHTML = decodeURIComponent(aaa[9]);
					document.getElementById('downHideRFPfile').value = decodeURIComponent(aaa[9]);
					$('#RFPUploadDiv').show();
				}
				
				if ((decodeURIComponent(aaa[10]) == "File Not Attached")
						|| (decodeURIComponent(aaa[10]) == "NA")
						|| (decodeURIComponent(aaa[10]) == "null")|| (decodeURIComponent(aaa[10]) == "")) {
					$('#otherUploadDiv').hide();
				} else {
					document.getElementById('otheruploadfile').innerHTML = decodeURIComponent(aaa[10]);
					document.getElementById('downHideotherfile').value = decodeURIComponent(aaa[10]);
					$('#otherUploadDiv').show();
				}
				

	            $("#Securitytool").val(data1); // Update the select element

	        }
	    });
		   	    

 // If the selected value meets a certain condition, show both 'RD' and 'UD'
 if ($("#rdNumber").val()) {
     $('#RD').show();
     $('#UD').show();
    
 } else {
     // Otherwise, hide them
     $('#RD').show();
     $('#UD').hide();        
 }

}
});


function downFileStandard() {
	event.preventDefault();
//	alert("download")
	var filename = encodeURIComponent($('#filenameStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="+ filename;

}

function maskedStandard() {
	event.preventDefault();
	var filename = encodeURIComponent($('#masekdfileStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

function scopefileDownload() {
	event.preventDefault();
	var filename = encodeURIComponent($('#downHidescopefile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}


function RFPfileDownload() {
	event.preventDefault();
	var filename = encodeURIComponent($('#downHideRFPfile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

function otherfileDownload() {
	event.preventDefault();
	var filename = encodeURIComponent($('#downHideotherfile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}
	    
  



