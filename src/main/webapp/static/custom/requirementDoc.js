	$('#spin').hide();

window.onload = function(){

$('#uploadfileform').hide();
$('#maskedPOUploadDiv').hide();

var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getRdDetailsTable";
$('#spin12').show();
 $.ajax({
     type: 'POST',
     url: serviceUrl,
     dataType: 'json',
     success: function(data4) {
    	 

    		$('#spin12').hide();
             var table = $('#rdDetails').DataTable({
             lengthChange: false,
             data: data4,
              "pageLength": 5,
              scrollX: '300px'
         });   
     }
 });

 getPonumber();
 getProductManager();

// getNameDetails();
 
// get Function Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getFunctionName";
	var selectedValue = $("#functionName").val(); // Get the currently
													// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'abc=' + encodeURIComponent(selectedValue),
		success : function(data4) {

// alert("function "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#functionName").html(html); // Update the select element
			$("#functionName").val(selectedValue); // Set the selected value
		}
	});
 
 
 
 

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/getDesignationNameDetails";
var selectedValue = $("#designation").val();

$.ajax({
    type: 'POST',
    url: serviceUrl,
    dataType: 'json',
    data: 'desigName=' + encodeURIComponent(selectedValue),
    success: function(data4) {
        // Call a function to populate dropdown options
        populateDropdown("#designation", data4, selectedValue);
        populateDropdown("#designationname", data4, selectedValue);
        populateDropdown("#designationnames", data4, selectedValue);
    },
    error: function(xhr, textStatus, errorThrown) {
        // Handle errors here
        console.error("Error fetching data:", textStatus, errorThrown);
    }
});

function populateDropdown(dropdownId, data, selectedValue) {
    var html = "<option value=''>-- Please Select --</option>";

    for (var i = 0; i < data.length; i++) {
        var value = data[i];
        html += '<option value="' + value + '">' + value + '</option>';
    }

    // Update the dropdown element with the generated HTML options
    $(dropdownId).html(html);

    // Set the selected value for the dropdown
    $(dropdownId).val(selectedValue);
}
}

function validatePriority() {
    var indexError = 0;
    if ($('#documentType').val().trim() === '') {
        callToolTip231('documentType', 'show');
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

    if (fieldName == "documentType") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Funcation <span>";
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
$('#documentType').on('focus', function() {
	callToolTip231('documentType', 'destroy');
	
});


$('#submitDoc').click(function(){
	var fname = $('#documentType').val(); 
	$('#fName').text(fname);
// if (!validatePriority()) {
		   // alert("fail")
		        event.preventDefault();
// } ELSE {
		    	
		    	

// $('#registrationform').show();
// $('#uploadfileform').show();
// $('#rowid').hide();
	
	
	
		    }).show();

$('#resetType').click(function () {
	$('#documentType').val('');
	callToolTip231('documentType', 'destroy');
	$('#registrationform').hide();
    $('#uploadfileform').hide();
    $('#rowid').show();
})


// form1 designationNameDetails

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
	    const inputIds = ['userName', 'userId', 'userDescription']; // Assign
																	// unique
																	// IDs
	    for (let i = 0; i < 3; i++) {
	        const cell = newRow.insertCell();
	        const input = document.createElement('input');
	        input.type = 'text';
	        input.id = inputIds[i]; // Assign unique IDs to each input
	        input.classList.add('form-control', 'form-control-sm');
	        input.placeholder = placeholders[i];
	        cell.appendChild(input);
	    }
   
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
	function populateDropdown(dropdownId, data, selectedValue) {
	    var html = "<option value=''>-- Please Select --</option>";

	    for (var i = 0; i < data.length; i++) {
	        var value = data[i];
	        html += '<option value="' + value + '">' + value + '</option>';
	    }

	    // Update the dropdown element with the generated HTML options
	    $(dropdownId).html(html);

	    // Set the selected value for the dropdown
	    $(dropdownId).val(selectedValue);
	}

	function deleteRow(btn) {
	    const row = btn.parentNode.parentNode;
	    row.parentNode.removeChild(row);
	}

function getNameDetails() {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getUserNameDetails";
    var selectedValue = $("#documentType5").val(); // Get the currently

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
// data: 'userName=' + encodeURIComponent(selectedValue),
        success: function(data4) {
// alert(data4);
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data4.length; i++) {
                var value = data4[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            $("#documentType5").html(html); // Update the select element
            $("#documentType5").val(selectedValue); // Set the selected value
           }
    });
}



function getUserId(){
	
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getUserId";
    var selectedValue = $("#username").val(); // Get the currently selected
												// value

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'userID=' + encodeURIComponent(selectedValue),
        success: function(data4) {
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data4.length; i++) {
                var value = data4[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            
            document.getElementById("userid").value = data4;
        }
    });
}

function populateDropdownValues(dropdown) {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getDesignationNameDetails";

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


// shreeeeeeeee
function getPonumber() {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getPonumber";
    var serviceUrl = base_url + "/PMS/getPonumberSMapproved";
    var selectedValue = $("#poNumber").val(); 

//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        dataType: 'json',
//        success: function(data4) {
//            var html = "<option value=''>-- Please Select --</option>";
//            for (var i = 0; i < data4.length; i++) {
//            	var value1 = data4[i].split(' ~ ')[0];
//            	alert("val1 "+value1)
//                var value2 = data4[i];
//                html += '<option value="' + value1 + '">' + value2 + '</option>';
//            }
//            $("#poNumber").html(html); // Update the select element
//            $("#poNumber").val(selectedValue); // Set the selected value
//        }
//    });
    
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data4) {
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data4.length; i=i+1) {
            	var value1 = data4[i][0];
//            	alert("val1 "+value1)
                var value2 = data4[i][1];
//            	alert("val2 "+value2)
                html += '<option value="' + value1 + '">' + value2 + '</option>';
            }
            $("#poNumber").html(html); // Update the select element
            $("#poNumber").val(selectedValue); // Set the selected value
        }
    });
    
  
}

function getProductSuite() {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getproducSuiteNames";
    var selectedValue = $("#poNumber").val(); // Get the currently
													// selected value

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ponum=' +selectedValue,      // $("#documentType2").val(),
        success: function(data4) {
// alert(data4)
// var html = "<option value=''>-- Please Select --</option>";
// for (var i = 0; i < data4.length; i++) {
// var value = data4[i];
// html += '<option value="' + value + '">' + value + '</option>';
// }
            $("#producSuiteNames").val(data4); // Update the select element

        }
    });
    
    
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getSecuritytool";
    var selectedValue1 = $("#poNumber").val(); // Get the currently
													// selected value
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'suitname=' + selectedValue1,      // $("#documentType2").val(),
        success: function(data1) {
      // alert(data1)
// var html = "<option value=''>-- Please Select --</option>";
// for (var i = 0; i < data4.length; i++) {
// var value = data4[i];
// html += '<option value="' + value + '">' + value + '</option>';
// }
            $("#Securitytool").val(data1); // Update the select element
        }
    });
    
  
    
    
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getManagerByTool";
    var selectedValue3 = $("#poNumber").val(); // Get the currently
													// selected value
 // alert("pooo:::::::::: "+selectedValue3)
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'poID=' + selectedValue3,      
        success: function(data1) {
 //       	alert(data1)
            $("#ProdManager").val(data1); // Update the select element

        }
    });

    
    
    // get Masked PO File
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getMaskedPOFile";
    var selectedValue4 = $("#poNumber").val(); 
												
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'poID=' + selectedValue4,      
        success: function(data1) {
        	
//        	alert(data1)
        	
        	if ((decodeURIComponent(data1) === "File Not Attached") || (decodeURIComponent(data1) === "NA")
			|| (decodeURIComponent(data1) === "") ) {
        		$('#maskedPOUploadDiv').hide();
        	} else {
        		document.getElementById('maskedPOfile').innerHTML = decodeURIComponent(data1);
        		document.getElementById('filnameMaskedPO').value = decodeURIComponent(data1);
        		$('#maskedPOUploadDiv').show();
        	}  

        }
    });

    
    
    
}










// function getSecuritytool() {
// var l = window.location;
// var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// var serviceUrl = base_url + "/PMS/getSecuritytool";
// var selectedValue = $("#poNumber").val(); // Get the currently
// // selected value
// // alert("sel c"+selectedValue)
// $.ajax({
// type: 'POST',
// url: serviceUrl,
// dataType: 'json',
// data: 'suitname=' + selectedValue, // $("#documentType2").val(),
// success: function(data4) {
// alert(data4)
// // var html = "<option value=''>-- Please Select --</option>";
// // for (var i = 0; i < data4.length; i++) {
// // var value = data4[i];
// // html += '<option value="' + value + '">' + value + '</option>';
// // }
// $("#Securitytool").val(data4); // Update the select element
// // $("#Securitytool").val(selectedValue); // Set the selected value
// }
// });
// }



function getProductManager() {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getManagerList";
 // var selectedValue = $("#documentType1").val(); // Get the currently
													// selected value
 // alert("documentType1"+selectedValue)
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
   // data: 'product =' + selectedValue, // $("#documentType2").val(),
        success: function(data4) {
// alert(data4)
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data4.length; i++) {
                var value = data4[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            $("#ProdManager").html(html); // Update the select element
// $("#documentType4").val(selectedValue); // Set the selected value
        }
    });
}

// function getNameDetails(){
// var l = window.location;
// var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// var serviceUrl = base_url + "PMS/getUserNameDetails";
// // var selectedValue = $("#documentType1").val(); // Get the currently
// // selected value
// // alert("documentType1"+selectedValue)
// $.ajax({
// type: 'POST',
// url: serviceUrl,
// dataType: 'json',
// // data: 'product =' + selectedValue, // $("#documentType2").val(),
// success: function(data4) {
// // alert(data4)
// var html = "<option value=''>-- Please Select --</option>";
// for (var i = 0; i < data4.length; i++) {
// var value = data4[i];
// html += '<option value="' + value + '">' + value + '</option>';
// }
// $("#documentType5").html(html); // Update the select element
// $("#documentType5").val(selectedValue); // Set the selected value
// }
// });
// }


// Add UD
function submitData() {
// alert("hih");
	$('#spin').show();
const tableBody = document.querySelector("#data-table tbody");
const rows = tableBody.querySelectorAll('tr');
const dataArray = [];

for (const row of rows) {
    const inputs = row.querySelectorAll('input');
    const selects = row.querySelectorAll('select'); // Fix here: change 'select'
													// to 'selects'
// alert("hhhhhhh" + selects[0]);

    for (const input of inputs) {
        if (input.value.trim() === '') {
            alert('One or more fields are empty. Please fill them out.');
            return; // Exit the function if any input is empty
        }
    }

    const dataObj = {
        data1: selects[0].value,
        data2: inputs[0].value,
        data3: inputs[1].value,
        data4: inputs[2].value
    };
    dataArray.push(dataObj);
}

var alldata = JSON.stringify(dataArray);

// Construct the server-side URL
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/saveNewRD";

var formData= new FormData(form);



formData.append('username', $('#username').val());
formData.append('userid', $("#userid").val());
formData.append('poNumber', $('#poNumber').val());
formData.append('producSuiteNames', $('#producSuiteNames').val());
formData.append('Securitytool', $('#Securitytool').val());
formData.append('ProdManager', $("#ProdManager").val());
//formData.append('functionName', $("#functionName").val());
formData.append('noteType', $("#noteType").val());

// formData.append('alldata', alldata);

// var fileInput = document.getElementById('uploadFile');
// formData.append('uploadFile', fileInput.files[0]);
//
// var fileInput = document.getElementById('maskedFile');
// formData.append('maskedFile', fileInput.files[0]);

// formData.append('addrowdata', addrowdata);

// Send data to the server using AJAX
$.ajax({
    
    	 type: 'POST',
         url: serviceUrl,
         data: formData,
         processData: false,  // Important: tell jQuery not to process the
								// data
         contentType: false,
    }).done(function(data) {
    // alert(data)
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
                html: "RD ID = " + poid + "<br><br> RD Raised Successfully",
                type: "success",
                width: 300,
                height: 200,
                buttons: false,
                allowOutsideClick: false,
                preConfirm: function() {
                    window.location.href = base_url + "/Admin/RequirementDoc";
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
                    window.location.href = base_url + "/Admin/RequirementDoc";
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
                    window.location.href = base_url + "/Admin/RequirementDoc";
                }
            });
        }
    });

}


function saveAllData(){
		   
 if (!validateRDData())
 {
 // alert("fail")
 event.preventDefault();
 } else {
	 submitData();
 }
}



function validateRDData() {
    var indexError = 0;
  
    if ($('#poNumber').val().trim() === '') {
        callToolTip2('poNumber', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
//    if ($('#functionName').val().trim() === '') {
//        callToolTip2('functionName', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#username').val().trim() === '') {
//        callToolTip2('username', 'show');
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

    if (fieldName == "poNumber") {
        var errorMessage = "<span>Please Select PO Number <span>";
    }
    else if (fieldName == "functionName"){
    	var errorMessage = "<span>Please Select Function Name<span>";
    }
//    else if (fieldName == "username"){
//    	var errorMessage = "<span>Select username<span>";
//    }
//     else if (fieldName == "description"){
//    	var errorMessage = "<span>Enter description<span>";
//    } 

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

$('#poNumber').on('focusout', function() {
    var usertype = $('#poNumber').val();

    if (usertype.trim() == "") {
        callToolTip2('poNumber', 'show');
    }
    else {
        callToolTip2('poNumber', 'hide');
    }
});
$('#functionName').on('focusout', function() {
    var usertype = $('#functionName').val();

    if (usertype.trim() == "") {
        callToolTip2('functionName', 'show');
    }
    else {
        callToolTip2('functionName', 'hide');
    }
});
//
//$('#username').on('focusout', function() {
//    var usertype = $('#username').val();
//
//    if (usertype.trim() == "") {
//        callToolTip2('username', 'show');
//    }
//    else {
//        callToolTip2('username', 'hide');
//    }
//});
//
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



$('#poNumber').on('click', function() {
	callToolTip2('poNumber', 'destroy');
});
$('#functionName').on('click', function() {
	callToolTip2('functionName', 'destroy');
});

//$('#username').on('click', function() {
//	callToolTip2('username', 'destroy');
//});
//$('#description').on('click', function() {
//	callToolTip2('description', 'destroy');
//});


$("#resetType").click(function() {
	$("#poNumber").val('').trigger('change')
	$("#functionName").val('').trigger('change')
//	$("#description").val('').trigger('change')
	
     callToolTip2('poNumber', 'destroy');
      callToolTip2('functionName', 'destroy');
//       callToolTip2('username', 'destroy');
//     callToolTip2('description', 'destroy');
});




function maskedPOStandard() {
	var filename = encodeURIComponent($('#filnameMaskedPO').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}
