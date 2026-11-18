/**
 * 
 */

window.onload = function() {
	
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getAuthorizername";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          success: function(data2) {	
        	// alert("datadatt"+data2)
         	 var html = "  <option value=''> -- Please Select Authorizer Name --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("Authorizer").innerHTML = html;		
 			
 		}
 	});
 	

/////////// get sales manager name 

	    var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getcheckerName";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          success: function(data2) {	
        	// alert("datadatt"+data2)
         	 var html = "  <option value=''> -- Please Select Sales Manager --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("salesManager").innerHTML = html;		
 			
 		}
 	});
      
      ///////////////////////

 var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getdistributorname";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          success: function(data2) {	      
	         	 var html = "  <option value=''> -- Please Select --</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("distributorname").innerHTML = html;		
	 			
	 		}
	 	});
	 	
	 	
	 var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getpartnername";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          success: function(data2) {	      
	         	 var html = "  <option value=''> -- Please Select --</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("partnername").innerHTML = html;		
	 			
	 		}
	 	}); 	
	
	
	 othercountrytax();
	
}
function validateEmail() {
	// alert("HIH")
    // Get the value from the input field
 var email = document.getElementById("Md_Ceo_emailid").value;
    
 // Regular expression pattern for a valid email address
 var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,}$/;

 // Check if the email matches the pattern
 if (emailPattern.test(email)) {
 document.getElementById("emailError1").textContent = "Valid Format"; // Clear any previous error message
 $('#emailError').hide();
 $('#emailError1').show();
 } else {
 document.getElementById("emailError").textContent = "Invalid Format";
 $('#emailError1').hide();
 $('#emailError').show();
 }
}


function validateEmailsales() {
	// alert("HIH")
    // Get the value from the input field
 var email = document.getElementById("Sales_emailid").value;
    
 // Regular expression pattern for a valid email address
 var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,}$/;

 // Check if the email matches the pattern
 if (emailPattern.test(email)) {
 document.getElementById("emailErrorSalesgreen").textContent = "Valid Format";
 // Clear any previous error message
 $('#emailErrorSalesred').hide();
 $('#emailErrorSalesgreen').show();
 } else {
 document.getElementById("emailErrorSalesred").textContent = "Invalid Format";
 $('#emailErrorSalesgreen').hide();
 $('#emailErrorSalesred').show();
 }
}

function validateEmailSupport() {
	// alert("HIH")
    // Get the value from the input field
 var email = document.getElementById("support_email_id").value;
    
 // Regular expression pattern for a valid email address
 var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,}$/;

 // Check if the email matches the pattern
 if (emailPattern.test(email)) {
 document.getElementById("emailErrorsupportgreen").textContent = "Valid Format"; // Clear any previous error message
 $('#emailErrorSupportsred').hide();
 $('#emailErrorsupportgreen').show();
 } else {
 document.getElementById("emailErrorSupportsred").textContent = "Invalid Format";
 $('#emailErrorsupportgreen').hide();
 $('#emailErrorSupportsred').show();
 }
}

function validateEmailContact(){
	// alert("HIH")
    // Get the value from the input field
 var email = document.getElementById("emailid_contact_person").value;
    
 // Regular expression pattern for a valid email address
 var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,}$/;

 // Check if the email matches the pattern
 if (emailPattern.test(email)) {
 document.getElementById("emailErrorcontactgreen").textContent = "Valid Format"; // Clear any previous error message
 $('#emailErrorcontactred').hide();
 $('#emailErrorcontactgreen').show();
 } else {
 document.getElementById("emailErrorcontactred").textContent = "Invalid Format";
 $('#emailErrorcontactgreen').hide();
 $('#emailErrorcontactred').show();
 }
}

function validateEmailOffice(){
	// alert("HIH")
    // Get the value from the input field
 var email = document.getElementById("office_mailid").value;
    
 // Regular expression pattern for a valid email address
 var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,}$/;

 // Check if the email matches the pattern
 if (emailPattern.test(email)) {
 document.getElementById("emailErrorOfficegreen").textContent = "Valid Format"; // Clear any previous error message
 $('#emailErrorOfficered').hide();
 $('#emailErrorOfficegreen').show();
 } else {
 document.getElementById("emailErrorOfficered").textContent = "Invalid Format";
 $('#emailErrorOfficegreen').hide();
 $('#emailErrorOfficered').show();
 }
}

function validatemobno(){
// alert("HIH")
    // Get the value from the input field
    var mobino = document.getElementById("mobno").value;
    
    // Regular expression pattern for a valid email address
    var mobnoPattern = /^\d{10}$/;

    // Check if the email matches the pattern
    if (mobnoPattern.test(mobino)) {
        document.getElementById("mobgreen").textContent = "Valid Format"; // Clear
																			// any
																			// previous
																			// error
																			// message
     $('#mobred').hide();
     $('#mobgreen').show();
    } else {
        document.getElementById("mobred").textContent = "Invalid Format";
        $('#mobgreen').hide();
        $('#mobred').show();
    }
}

function validatetelepho(){
	// alert("HIH")
    // Get the value from the input field
    var telpno = document.getElementById("telpno").value;
    
    // Regular expression pattern for a valid email address
    var telpnoPattern = /^\d{10}$/;

    // Check if the email matches the pattern
    if (telpnoPattern.test(telpno)) {
        document.getElementById("telpnogreen").textContent = "Valid Format"; // Clear
																				// any
																				// previous
																				// error
																				// message
     $('#telpnored').hide();
     $('#telpnogreen').show();
    } else {
        document.getElementById("telpnored").textContent = "Invalid Format";
        $('#telpnogreen').hide();
        $('#telpnored').show();
    }
}

function validatetepin(){
//	 alert("HIH")
    var pincode = document.getElementById("pincode").value;
    
    var pincodePattern = /^\d{6}$/;

    if (pincodePattern.test(pincode)) {
        document.getElementById("pincodegreen").textContent = "Valid Format"; 
     $('#pincodered').hide();
     $('#pincodegreen').show();
    } else {
        document.getElementById("pincodered").textContent = "Invalid Format";
        $('#pincodegreen').hide();
        $('#pincodered').show();
    }
}


function validPinNumber(event) {
    var charCode = event.which ? event.which : event.keyCode;
    if ((charCode < 48 || charCode > 57) || document.getElementById("pincode").value.length >= 6) {
        event.preventDefault();
    }
}


$('#pincode').on('focusout', function() {
    var pincodeValue = $('#pincode').val();
    if (pincodeValue.trim() == "") {
    	 $('#pincodegreen').hide();
         $('#pincodered').hide();    } 
});

$('#panacno').on('focusout', function() {
    var PanNoValue = $('#panacno').val();
    if (PanNoValue.trim() == "") {
    	 $('#panacnogreen').hide();
         $('#panacnored').hide();    } 
});

$('#gstin').on('focusout', function() {
    var GstValue = $('#gstin').val();
    if (GstValue.trim() == "") {
    	 $('#GSTINgreen').hide();
         $('#GSTINred').hide();    } 
});


function validatetewebsite(){
	// alert("HIH")
    // Get the value from the input field
    var website = document.getElementById("website").value;
    
    // Regular expression pattern for a valid email address
    var websitePattern =/^(https?:\/\/)?(www\.){1}([a-zA-Z0-9.-]+\.[a-z]{2,})(\/[^\s]*)?$/;

    // Check if the email matches the pattern
    if (websitePattern.test(website)) {
        document.getElementById("websitegreen").textContent = "Valid Format"; 
     $('#websitered').hide();
     $('#websitegreen').show();
    } else {
        document.getElementById("websitered").textContent = "Invalid Format";
        $('#websitegreen').hide();
        $('#websitered').show();
    }
}



function validateGSTIN() {
	// alert("HIH")
    // Get the value from the input field
    var gstin = document.getElementById("gstin").value;
    
    // Regular expression pattern for a valid email address
    var GSTINPattern =/^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$/;

    // Check if the email matches the pattern
    if (GSTINPattern.test(gstin)) {
        document.getElementById("GSTINgreen").textContent = "Valid Format"; // Clear
																				// any
																				// previous
																				// error
																				// message
     $('#GSTINred').hide();
     $('#GSTINgreen').show();
    } else {
        document.getElementById("GSTINred").textContent = "Invalid Format";
        $('#GSTINgreen').hide();
        $('#GSTINred').show();
    }
}


function validatetepanno(){
	// alert("HIH")
    // Get the value from the input field
    var panacno = document.getElementById("panacno").value;
    
    // Regular expression pattern for a valid email address
    var panacnoPattern =/[A-Z]{5}[0-9]{4}[A-Z]{1}$/;

    // Check if the email matches the pattern
    if (panacnoPattern.test(panacno)) {
        document.getElementById("panacnogreen").textContent = "Valid Format"; // Clear
																				// any
																				// previous
																				// error
																				// message
     $('#panacnored').hide();
     $('#panacnogreen').show();
    } else {
        document.getElementById("panacnored").textContent = "Invalid Format";
        $('#panacnogreen').hide();
        $('#panacnored').show();
    }
}

function validateters1(){
// alert("HIH")
    // Get the value from the input field
    var rupees1 = document.getElementById("rupees1").value;
    
    // Regular expression pattern for a valid email address
    var rupees1Pattern =/^\d+(\.\d+)?$/;

    // Check if the email matches the pattern
    if (rupees1Pattern.test(rupees1)) {
        document.getElementById("rs1green").textContent = "Valid Formate"; // Clear
																			// any
																			// previous
																			// error
																			// message
     $('#rs1red').hide();
     $('#rs1green').show();
    } else {
        document.getElementById("rs1red").textContent = "Invalid Formate";
        $('#rs1green').hide();
        $('#rs1red').show();
    }
}

function validateters2(){
	// alert("HIH")
    // Get the value from the input field
    var rupees2 = document.getElementById("rupees2").value;
    
    // Regular expression pattern for a valid email address
    var rupees2Pattern =/^\d+(\.\d+)?$/;

    // Check if the email matches the pattern
    if (rupees2Pattern.test(rupees2)) {
        document.getElementById("rs2green").textContent = "Valid Formate"; // Clear
																			// any
																			// previous
																			// error
																			// message
     $('#rs2red').hide();
     $('#rs2green').show();
    } else {
        document.getElementById("rs2red").textContent = "Invalid Formate";
        $('#rs2green').hide();
        $('#rs2red').show();
    }
}


function validateters3(){
	// alert("HIH")
    // Get the value from the input field
    var rupees3 = document.getElementById("rupees3").value;
    
    // Regular expression pattern for a valid email address
    var rupees3Pattern =/^\d+(\.\d+)?$/;

    // Check if the email matches the pattern
    if (rupees3Pattern.test(rupees3)) {
        document.getElementById("rs3green").textContent = "Valid Formate"; // Clear
																			// any
																			// previous
																			// error
																			// message
     $('#rs3red').hide();
     $('#rs3green').show();
    } else {
        document.getElementById("rs3red").textContent = "Invalid Formate";
        $('#rs3red').hide();
        $('#panacnored').show();
    }
}
const currencyMap = {
        'USA': 'USD',               // United States Dollar
    'Canada': 'CAD',            // Canadian Dollar
    'United Kingdom': 'GBP',    // British Pound Sterling
    'Japan': 'JPY',             // Japanese Yen
    'Australia': 'AUD',         // Australian Dollar
    'Brazil': 'BRL',            // Brazilian Real
    'China': 'CNY',             // Chinese Yuan
    'India': 'INR',             // Indian Rupee
    'Mexico': 'MXN',            // Mexican Peso
    'Russia': 'RUB',            // Russian Ruble
    'South Africa': 'ZAR',      // South African Rand
    'Switzerland': 'CHF',       // Swiss Franc
    'New Zealand': 'NZD',       // New Zealand Dollar
    'South Korea': 'KRW',       // South Korean Won
    'Singapore': 'SGD',         // Singapore Dollar
    'Sweden': 'SEK',            // Swedish Krona
    'Norway': 'NOK',            // Norwegian Krone
    'Turkey': 'TRY',            // Turkish Lira
    'Poland': 'PLN',            // Polish Złoty
    'Argentina': 'ARS'
    };

function othercountrytax(){
	
	var othercountrytax = $('#country').val();
	
	if (othercountrytax === "India") {
		
		$('#othercountrytax').hide();
		$('#indiacountrytax').show();
	} else{
		
		$('#othercountrytax').show();
		$('#indiacountrytax').hide();
	}
	
	
	 const selectedCountry = document.getElementById('country').value;
     const currencyDropdown = document.getElementById('currency');

     // Clear the existing options
     currencyDropdown.innerHTML = "";

     // Add the new currency option based on the selected country
     const option = document.createElement("option");
     option.text = currencyMap[selectedCountry];
     currencyDropdown.add(option);
}




function saveregistrationform(addrowdata){
	$('#spin').show();
// alert("inside saveregistrationform :: "+addrowdata);
    
   // alert("company name :"+$("#country").val());
		
  
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/addregistrationMaster";	
    var serviceUrl = serviceUrl;
	
	
	
	
	  var formData= new FormData(form);
	
	formData.append('addrowdata', addrowdata);


  $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         data: formData,
	         mimeType: "multipart/form-data",
	         contentType: false,
	         processData: false,
	         cache: false,
         		
         		
     }).done(function(data) {  
 //alert(data)
    	 var dataArray = data.split(',');
    	 var firstPart = dataArray[0]; // "RF-20"
    	 var secondPart = dataArray[1]; // "Success"
    	 
    	 
    	 $('#spin').hide();
         if (secondPart == "success") {
             swal({
                 title: "Successful!",
//                 text: "Record Added Successfully",
                 html: "RF ID = " + firstPart + "<br><br> Record Added Successfully",
                 type: "success",
                 width: 300,
                 height: 200,

                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/CustomerMaster";
                 }
             });

         }
        
         else if (secondPart == "error") {
             swal({
                 title: "Unsuccessful!",
                 html: "RF ID = " + firstPart + "<br><br> Fail to add file",
//                 text: "Fail to add file",
                 type: "success",
                 width: 300,
                 height: 200,

                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/CustomerMaster";
                 }

             });

           }
     });
	
}



function myCategory() {
	
	$('#registrationform').hide();
	$('#registrationform2').hide();
	$('#registrationform3').hide();
	
	var categorytype = $('#categorytype').val();

	if (categorytype != "" && categorytype === "Partner") {
		$('#distributor').show();
		$('#customer').hide();
	} 
	else if (categorytype != "" && categorytype === "Customer") {
		$('#distributor').show();
		$('#customer').show();
	}else{
		$('#distributor').hide();
		$('#customer').hide();
		
	}

}

function msmedregyes(){
	
	var msmedyes = $('#msmedreg1').val();
	
	if(msmedyes === "Yes"){
		$('#msmedeclrn').show();
		$('#msmedyestype').show();
	}else{
		
		$('#msmedeclrn').hide();
		$('#msmedyestype').hide();
	}
}

function msmedregno(){
	
	
	var msmedno = $('#msmedreg2').val();
	if(msmedno === "No"){
		$('#msmedeclrn').hide();
		$('#msmedyestype').hide();
	}
}
var callToolTip231 = function(fieldName, status) {

    if (fieldName == "categorytype") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Category <span>";
    }
     else if (fieldName == "distributorname") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Distributor Name <span>";
    } else if (fieldName == 'partnername') {
    	var errorMessage = "<span>Please Enter Partner Name <span>";
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


$('#categorytype').on('focus', function() {
	callToolTip231('categorytype', 'destroy');
	
});
$('#distributorname').on('focus', function() {
	callToolTip231('distributorname', 'destroy');
});	
$('#partnername').on('focus', function() {
	callToolTip231('partnername', 'destroy');
});


function validatePriority() {
    var indexError = 0;
    if ($('#categorytype').val().trim() === '') {
        callToolTip231('categorytype', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#categorytype').val() === 'Partner') {
    if ($('#distributorname').val().trim() === '') {
        callToolTip231('distributorname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    }
    if ($('#categorytype').val() === 'Customer') {
    	  if ($('#distributorname').val().trim() === '') {
    	        callToolTip231('distributorname', 'show');
    	        if (indexError == 0) {

    	        }
    	        indexError = indexError + 1;
    	    }
    if ($('#partnername').val().trim() === '') {
        callToolTip231('partnername', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}


$("#submitCategType").click(function() {
   // alert("dgfsgf");
    if (!validatePriority()) {
   // alert("fail")
        event.preventDefault();
    } else {
// alert("pass")
    	
    	$('#registrationform').show();
    	$('#registrationform2').show();
    	$('#registrationform3').show();
    	var categorytype = $('#categorytype').val();
    	if(categorytype === "Distributor"){
    		$('#distributorheader').show();
    		$('#partnerheader').hide();
        	$('#customerheader').hide();
        	$('#onlycustomerheader').hide();
        	$('#onlypartnerheader').hide();
        }else if (categorytype === "Partner") {
            
        	$('#partnerheader').show();
        	$('#distributorheader').hide();
        	$('#customerheader').hide();
        	$('#onlypartnerheader').hide();
        	$('#onlycustomerheader').hide();
        }else if (categorytype === "OnlyPartner") {
            
        	$('#onlypartnerheader').show();
        	$('#distributorheader').hide();
        	$('#customerheader').hide();
        	$('#partnerheader').hide();
        	$('#onlycustomerheader').hide();
        }else if (categorytype === "OnlyCustomer") {
            
        	$('#onlycustomerheader').show();
        	$('#distributorheader').hide();
        	$('#customerheader').hide();
        	$('#onlypartnerheader').hide();
        	$('#partnerheader').hide();
        } else{
        	$('#customerheader').show();
        	$('#distributorheader').hide();
        	$('#partnerheader').hide();
        	$('#onlycustomerheader').hide();
        	$('#onlypartnerheader').hide();
        }
    }
}).show();




$("#resetCategType").click(function() {
	$('#categorytype').val("");
	$('#distributorname').val("");
	$('#partnername').val("");
	$('#distributor').hide();
	$('#customer').hide();
	$('#registrationform').hide();
	callToolTip231('categorytype', 'destroy');
	callToolTip231('distributorname', 'destroy');
	callToolTip231('partnername', 'destroy');
	$('#registrationform').hide();
	$('#registrationform2').hide();
	$('#registrationform3').hide();
});

$("#updatedeleteRow").click(function() {

	if (counterupdate > 1) {
		var table = document.getElementById("updateperifheralTable");

		table.deleteRow(counterupdate);
		counterupdate -= 1

	}
});




var counterupdate = 0;
$("#updateAddrow")
		.on(
				"click",
				function() {

					var newRow = $("<tr>");
					var cols = "";

					cols += '<td class="form-group adjust"><input type="text" class="form-control " id="ddrname1" tabindex="6" data-toogle="tooltip" name="ddrname1" placeholder="Enter Your Name"></td>';
					cols += '<td class="form-group adjust"><input type="text" class="form-control " id="ddrdesignation1" tabindex="6" data-toogle="tooltip" name="ddrdesignation1" placeholder="Enter Your Designation"></td>';
					
					cols += '<td class="form-group adjust"><input type="text" class="form-control " id="ddrexperience1" tabindex="6" data-toogle="tooltip" name="ddrname1" placeholder="Enter Your Experience"></td>';
		            
					newRow.append(cols);
					$("table.order-list1").append(newRow);
					counterupdate++;

					$(".customMulti").multiselect({
						includeSelectAllOption : true,
						buttonWidth : '100%',
						enableFiltering : true,
						enableCaseInsensitiveFiltering : true,
						maxHeight : 200

					});
				});

$("#companydeleteRow").click(function() {

	if (countercompanyupdate > 1) {
		var table = document.getElementById("companyperifheralTable");

		table.deleteRow(countercompanyupdate);
		countercompanyupdate -= 1

	}
});







var countercompanyupdate = 0;
$("#companyAddrow")
		.on(
				"click",
				function() {

					var newRow1 = $("<tr>");
					var cols = "";

					cols += '<td class="form-group adjust"><input type="text" class="form-control " id="ddrname1" tabindex="6" data-toogle="tooltip" name="ddrname1"></td>';
					cols += '<td class="form-group adjust"><input type="text" class="form-control " id="ddrdesignation1" tabindex="6" data-toogle="tooltip" name="ddrdesignation1"></td>';
					cols += '<td class="form-group adjust"><input type="text" class="form-control " id="ddrqualification1" tabindex="6" data-toogle="tooltip" name="ddrqualification1"></td>';

					newRow1.append(cols);
					$("table.order-list2").append(newRow1);
					countercompanyupdate++;

					$(".customMulti").multiselect({
						includeSelectAllOption : true,
						buttonWidth : '100%',
						enableFiltering : true,
						enableCaseInsensitiveFiltering : true,
						maxHeight : 200

					});
});

// // for add row

let dataArray = [];

function addRow() {
   const tableBody = document.querySelector("#data-table tbody");
   const newRow = tableBody.insertRow();
   const placeholders = ['Enter Company Name', 'Enter Designation', 'Enter Experience'];
   for (let i = 0; i < 3; i++) {
       const cell = newRow.insertCell();
       const input = document.createElement('input');
       input.type = 'text';
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


// / for delete row
function deleteRow(btn) {
   const row = btn.parentNode.parentNode;
   row.parentNode.removeChild(row);
}





function submitData() {
	
//alert("Sgsggsgg");
 if (!validateEditForm()) {
 event.preventDefault();
 } else
 {
    	
  // }
	
   const tableBody = document.querySelector("#data-table tbody");
   const rows = tableBody.querySelectorAll('tr');

   dataArray = [];  // Clear the array before adding new data

   for (const row of rows) {
       const inputs = row.querySelectorAll('input');
       
       // Check if any input value is empty
       for (const input of inputs) {
           if (input.value.trim() === '') {
//               alert('One or more fields are empty. Please fill them out.');
               return; // Exit out of the function early
           }
       }

       const dataObj = {
           data1: inputs[0].value,
           data2: inputs[1].value,
           data3: inputs[2].value
       };
       dataArray.push(dataObj);
   }

// alert(JSON.stringify(dataArray));
   Saveregistor(JSON.stringify(dataArray));  
}
}


function Saveregistor(addrowdata)
{
	

	if(!validateEditForm()) {
		event.preventDefault();
	} else {
		saveregistrationform(addrowdata);
	}
	
	
}


function validateEditForm() {
	var indexError = 0;
	
	if($('#compname').val().trim() == '') {
		callToolTip1('compname', 'show');
		indexError++;
	}
	
	 if($('#registerno').val().trim() == '') {
		callToolTip1('registerno', 'show');
		indexError++;
	}
	
	if($('#address').val().trim() == '') {
		callToolTip1('address', 'show');
		indexError++;
	}
	
	 if($('#personname').val().trim() == '') {
		callToolTip1('personname', 'show');
		indexError++;
	}
	
	 if($('#mobno').val().trim() == '') {
			callToolTip1('mobno', 'show');
			indexError++;
		}
	 
	 if($('#telpno').val().trim() == '') {
			callToolTip1('telpno', 'show');
			indexError++;
		}
	 
	 if($('#Md_Ceo_emailid').val().trim() == '') {
			callToolTip1('Md_Ceo_emailid', 'show');
			indexError++;
		}
	 if($('#Sales_emailid').val().trim() == '') {
			callToolTip1('Sales_emailid', 'show');
			indexError++;
		}
	  
	 
	 if($('#support_email_id').val().trim() == '') {
			callToolTip1('support_email_id', 'show');
			indexError++;
		}
	 
	 if($('#emailid_contact_person').val().trim() == '') {
			callToolTip1('emailid_contact_person', 'show');
			indexError++;
		}
	 if($('#office_mailid').val().trim() == '') {
			callToolTip1('office_mailid', 'show');
			indexError++;
		}
	 
	 if($('#city').val().trim() == '') {
			callToolTip1('city', 'show');
			indexError++;
		}
	 
	 
	 if($('#district').val().trim() == '') {
			callToolTip1('district', 'show');
			indexError++;
		}
	 
	 if($('#state').val().trim() == '') {
			callToolTip1('state', 'show');
			indexError++;
		}
	 
	 if($('#pincode').val().trim() == '') {
			callToolTip1('pincode', 'show');
			indexError++;
		}
	 
	 
	 if($('#country').val().trim() == '') {
			callToolTip1('country', 'show');
			indexError++;
		}
	 
	 if($('#website').val().trim() == '') {
			callToolTip1('website', 'show');
			indexError++;
		}
	 
	 if($('#panacno').val().trim() == '') {
			callToolTip1('panacno', 'show');
			indexError++;
		}
	 if($('#ownership').val().trim() == '') {
			callToolTip1('ownership', 'show');
			indexError++;
		}
	 
	 if($('#scale_of_company').val().trim() == '') {
			callToolTip1('scale_of_company', 'show');
			indexError++;
		}
	 if($('#gstin').val().trim() == '') {
			callToolTip1('gstin', 'show');
			indexError++;
		}
	 //
	 if($('#dateofbussns').val().trim() == '') {
			callToolTip1('dateofbussns', 'show');
			indexError++;
		}
	 
	 if($('#year1').val().trim() == '') {
			callToolTip1('year1', 'show');
			indexError++;
		}
	 
	 
	 if($('#year2').val().trim() == '') {
			callToolTip1('year2', 'show');
			indexError++;
		}
	 
	 
	 if($('#year3').val().trim() == '') {
			callToolTip1('year3', 'show');
			indexError++;
		}
	 
	 if($('#rupees1').val().trim() == '') {
			callToolTip1('rupees1', 'show');
			indexError++;
		}
	 
	 if($('#rupees2').val().trim() == '') {
			callToolTip1('rupees2', 'show');
			indexError++;
		}
	 
	 if($('#rupees3').val().trim() == '') {
			callToolTip1('rupees3', 'show');
			indexError++;
		}
	 
	 if($('#entrepreno').val().trim() == '') {
			callToolTip1('entrepreno', 'show');
			indexError++;
		}
	 
	 if($('#Authorizer').val().trim() == '') {
			callToolTip1('Authorizer', 'show');
			indexError++;
		}
	 
	
	 	 
	if(indexError > 0) {
		return false;
	} else {
		return true;
	}
}


$('#compname').on('focus', function() {
	callToolTip1('compname', 'hide');
})

$('#registerno').on('focus', function() {
	callToolTip1('registerno', 'hide');
})

$('#address').on('focus', function() {
	callToolTip1('address', 'hide');
})

$('#personname').on('focus', function() {
	callToolTip1('personname', 'hide');
})

//
$('#mobno').on('focus', function() {
	callToolTip1('mobno', 'hide');
})

$('#telpno').on('focus', function() {
	callToolTip1('telpno', 'hide');
})

$('#Md_Ceo_emailid').on('focus', function() {
	callToolTip1('Md_Ceo_emailid', 'hide');
})

$('#Sales_emailid').on('focus', function() {
	callToolTip1('Sales_emailid', 'hide');
})

$('#support_email_id').on('focus', function() {
	callToolTip1('support_email_id', 'hide');
})

$('#emailid_contact_person').on('focus', function() {
	callToolTip1('emailid_contact_person', 'hide');
})

$('#office_mailid').on('focus', function() {
	callToolTip1('office_mailid', 'hide');
})

$('#city').on('focus', function() {
	callToolTip1('city', 'hide');
})

$('#district').on('focus', function() {
	callToolTip1('district', 'hide');
})

$('#state').on('focus', function() {
	callToolTip1('state', 'hide');
})

$('#pincode').on('focus', function() {
	callToolTip1('pincode', 'hide');
})

$('#country').on('focus', function() {
	callToolTip1('country', 'hide');
})
$('#website').on('focus', function() {
	callToolTip1('website', 'hide');
})

$('#panacno').on('focus', function() {
	callToolTip1('panacno', 'hide');
})
$('#ownership').on('focus', function() {
	callToolTip1('ownership', 'hide');
})

$('#scale_of_company').on('focus', function() {
	callToolTip1('scale_of_company', 'hide');
})
$('#gstin').on('focus', function() {
	callToolTip1('gstin', 'hide');
})

$('#dateofbussns').on('focus', function() {
	callToolTip1('dateofbussns', 'hide');
})

$('#year1').on('focus', function() {
	callToolTip1('year1', 'hide');
})

$('#year2').on('focus', function() {
	callToolTip1('year2', 'hide');
})

$('#year3').on('focus', function() {
	callToolTip1('year3', 'hide');
})

$('#rupees1').on('focus', function() {
	callToolTip1('rupees1', 'hide');
})

$('#rupees2').on('focus', function() {
	callToolTip1('rupees2', 'hide');
})

$('#rupees3').on('focus', function() {
	callToolTip1('rupees3', 'hide');
})

$('#entrepreno').on('focus', function() {
	callToolTip1('entrepreno', 'hide');
})

$('#Authorizer').on('focus', function() {
	callToolTip1('Authorizer', 'hide');
})





var callToolTip1 = function(fieldName, status) {
	if (fieldName == "compname") {
		var errorMessage = "<span>Please Enter Company Name<span>";
		
	} if (fieldName == "registerno") {
		var errorMessage = "<span>Please Enter Registration No<span>";
	}
	if (fieldName == "address") {
		var errorMessage = "<span>Please Enter Address<span>";
	}
	if (fieldName == "personname") {
		var errorMessage = "<span>Please Enter Person Name <span>";
	}
//
	if (fieldName == "mobno") {
		var errorMessage = "<span>Please Enter Mobile NO <span>";
	}

	if (fieldName == "telpno") {
		var errorMessage = "<span>Please Enter Phone NO <span>";
	}

	if (fieldName == "Md_Ceo_emailid") {
		var errorMessage = "<span>Please Enter Email-ID <span>";
	}
	if (fieldName == "Sales_emailid") {
		var errorMessage = "<span>Please Enter Email-ID <span>";
	}
	
	if (fieldName == "support_email_id") {
		var errorMessage = "<span>Please Enter Email-ID <span>";
	}

	if (fieldName == "emailid_contact_person") {
		var errorMessage = "<span>Please Enter Email-ID <span>";
	}

	if (fieldName == "office_mailid") {
		var errorMessage = "<span>Please Enter Email-ID <span>";
	}
	if (fieldName == "city") {
		var errorMessage = "<span>Please Enter City <span>";
	}

	if (fieldName == "district") {
		var errorMessage = "<span>Please Enter District <span>";
	}

	if (fieldName == "state") {
		var errorMessage = "<span>Please Enter State <span>";
	}

	if (fieldName == "pincode") {
		var errorMessage = "<span>Please Enter Pincode <span>";
	}

	
	if (fieldName == "country") {
		var errorMessage = "<span>Please Select Country <span>";
	}

	if (fieldName == "website") {
		var errorMessage = "<span>Please Enter Website <span>";
	}

	if (fieldName == "panacno") {
		var errorMessage = "<span>Please Enter Pan NO <span>";
	}

	if (fieldName == "ownership") {
		var errorMessage = "<span>Please Enter Ownership <span>";
	}

	if (fieldName == "scale_of_company") {
		var errorMessage = "<span>Please Enter Scale Of Company <span>";
	}

	if (fieldName == "gstin") {
		var errorMessage = "<span>Please Enter GSTIN <span>";
	}

	if (fieldName == "dateofbussns") {
		var errorMessage = "<span>Please Enter Date of Business <span>";
	}
	if (fieldName == "year1") {
		var errorMessage = "<span>Please Enter Year <span>";
	}
	if (fieldName == "year2") {
		var errorMessage = "<span>Please Enter Year <span>";
	}
	if (fieldName == "year3") {
		var errorMessage = "<span>Please Enter Year <span>";
	}
	if (fieldName == "rupees1") {
		var errorMessage = "<span>Please Enter Amount <span>";
	}
	if (fieldName == "rupees2") {
		var errorMessage = "<span>Please Enter Amount <span>";
	}
	if (fieldName == "rupees3") {
		var errorMessage = "<span>Please Enter Amount <span>";
	}
	if (fieldName == "entrepreno") {
		var errorMessage = "<span>Enter Entrepreneur Name <span>";
	}
	if (fieldName == "Authorizer") {
		var errorMessage = "<span>Enter Authorizer Name  <span>";
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
}

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}

$("#resetregsform").click(function() {


	
	$('#compname').val("");
	$('#registerno').val("");
	$('#address').val("");
	$('#personname').val("");
	$('#mobno').val("");
	$('#telpno').val("");
	$('#Md_Ceo_emailid').val("");
	$('#Sales_emailid').val("");
	$('#support_email_id').val("");
	$('#emailid_contact_person').val("");
	$('#office_mailid').val("");
	$('#city').val("");
	$('#district').val("");
	$('#state').val("");
	$('#pincode').val("");
	$('#country').val("");
	$('#website').val("");
	$('#panacno').val("");
	$('#ownership').val("");
	$('#scale_of_company').val("");
	$('#gstin').val("");
	$('#dateofbussns').val("");
	$('#year1').val("");
	$('#year2').val("");
	$('#year3').val("");
	$('#rupees1').val("");
	$('#rupees2').val("");
	$('#rupees3').val("");
	$('#entrepreno').val("");
	$('#Authorizer').val("");
	
	$('#companyname').val("");
	$('#designationname').val("");
	$('#experience').val("");
	$('#gemportal2').val("");
	$('#msmedreg2').val("");
	$('#ideclaration').val("");
	document.querySelector('input[type="checkbox"]').checked = false;
	
	

	callToolTip1('compname', 'destroy');
	callToolTip1('registerno', 'destroy');
	callToolTip1('address', 'destroy');
	callToolTip1('personname', 'destroy');
	callToolTip1('mobno', 'destroy');
	callToolTip1('telpno', 'destroy');
	callToolTip1('Md_Ceo_emailid', 'destroy');
	callToolTip1('Sales_emailid', 'destroy');
	callToolTip1('support_email_id', 'destroy');
	callToolTip1('emailid_contact_person', 'destroy');
	callToolTip1('office_mailid', 'destroy');
	callToolTip1('city', 'destroy');
	callToolTip1('district', 'destroy');
	callToolTip1('state', 'destroy');
	callToolTip1('pincode', 'destroy');
	callToolTip1('country', 'destroy');
	callToolTip1('website', 'destroy');
	callToolTip1('panacno', 'destroy');
	callToolTip1('ownership', 'destroy');
	callToolTip1('scale_of_company', 'destroy');
	callToolTip1('gstin', 'destroy');
	callToolTip1('dateofbussns', 'destroy');
	callToolTip1('year1', 'destroy');
	callToolTip1('year2', 'destroy');
	callToolTip1('year3', 'destroy');
	
	callToolTip1('rupees1', 'destroy');
	callToolTip1('rupees2', 'destroy');
	callToolTip1('rupees3', 'destroy');
	callToolTip1('entrepreno', 'destroy');
	callToolTip1('Authorizer', 'destroy');
	
	$('#mobgreen').hide();
	$('#pincodegreen').hide();
	$('#panacnogreen').hide();
	$('#websitegreen').hide();
	

	

});




function submitUploadbutton() {
//	alert("submitUploadbutton")
	if (!validateBulkUploadUser()) {
		// //alert("failed");
		event.preventDefault();
	} else if (validateBulkUploadUser()) {
		// //alert("passed");
		submitBulkUploadUser();
	}
}

function submitBulkUploadUser() {
	 $('#spin12').show();
//		alert("inside submitBulkUploadUser")
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/RFsaveBulkUpload";

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
				    	
//				    	alert("data" + data);

				    $('#spin12').hide();
				    if (data == "Success") {
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
				                window.location.href = base_url + "/Admin/CustomerMaster";
				            }
				        });
				    } else if (data == "error") {
				        swal({
				            title: "Unsuccessful!",
				            text: "Fail to add file",
				            type: "success",
				            width: 300,
				            height: 200,
				            buttons: false,
				            allowOutsideClick: false,
				            preConfirm: function () {
				                var l = window.location;
				                var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
				                window.location.href = base_url + "/Admin/CustomerMaster";
				            }
				        });
				    } else if (data == "Duplicate") {
				        swal({
				            title: "Duplicate!",
				            text: "Fail to add file",
				            type: "error",
				            width: 300,
				            height: 200,
				            buttons: false,
				            allowOutsideClick: false,
				            preConfirm: function () {
				                var l = window.location;
				                var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
				                window.location.href = base_url + "/Admin/CustomerMaster";
				            }
				        });
				    }
	}
				})
}

var callToolTipUpload = function(fieldName, status) {
	if (fieldName === "bulkUserData") {
		var errorMessage = "<span>Please Select a File<span>";
	}

	$("#" + fieldName).tooltip({
		trigger : 'manual',
		placement : 'top',
		title : errorMessage,
		animation : true,
		delay : 1000,
		html : true,
		at : 'center'
	});
	if (status == "show") {
		$("#" + fieldName).tooltip('show');
	} else {
		$("#" + fieldName).tooltip('hide');
	}
}

function validateBulkUploadUser() {
	
	var indexError = 0;

//Assuming #errorMessage is the element displaying the error message
function hideErrorMessage() {
callToolTipUpload('bulkUserData', 'destroy');
}

$('#bulkUserData').on('change', function () {
 hideErrorMessage();
});

if ($('#bulkUserData').val() === '') {
 // console.log('fill category');
 callToolTipUpload('bulkUserData', 'show');
 if (indexError == 0) {
     indexError = indexError + 1;
 }
} else {
 callToolTipUpload('bulkUserData', 'destroy');
}

if (indexError != 0) {
 return false;
} else {
 return true;
}
}
$('#bulkUserData').change(function() {

	var fileName = $('#bulkUserData').val();
	var idxDot = fileName.lastIndexOf(".") + 1;
	var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
	if (extFile == "xlsx") {

	} else {
		swal({
			position : 'top',
			title : 'warning',
			text : 'Accept Only .xlsx',
			showConfirmButton : false,
			timer : 3000
		})
		$('#bulkUserData').val("");
	}

})

function downFile(att) {

	// var filename = $('#filename').val();
	var filename = att;
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url
			+ "/Master/DownloadBulkUploadFailedFile?filename=" + filename;
}

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}



