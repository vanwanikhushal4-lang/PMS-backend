
var a=1;

var data_product_tool="";
var proposalId = null;

function abc11(value2)
{
	selectedValueATC=value2;
}

var subtotalforalldd =  '';
window.onload = function() {
	
	abc()
// sectools();
	  $("#veloxproposaldetails").show();
	    
	  
	    var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getCustomerName";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	  }).done(function(data) {
		
	

	      var html =" <select class='form-control' tabindex='8' id='clientname' name='clientname' onchange='POcustomData()'>";
	      html=html+'<option value="">--Please Select Customer--</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }

	      document.getElementById("clientname").innerHTML=html;
	  });
	  
	  // maker list
	  // Maker Details
	  	  
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/UserActivity/getAllUserDetails";
		
		  $.ajax({

		      url :serviceUrl,
		      type : 'POST',
		      dataType: 'json',
		  }).done(function(data) {

			  
			  $('#poinitiator').val(data[0]["FULLNAME"]);
			  $('#poinitiatorno').val(data[0]["PHONE"]);

		  });
		  
		// Po ID list
		   
//		    var l = window.location;
//			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			var serviceUrl = base_url + "/Master/getPOidList";
//
//		  $.ajax({
//
//		      url :serviceUrl,
//		      type : 'POST',
//		      dataType: 'json',
//		  }).done(function(data) {
//
//		      var html =" <select class='form-control' tabindex='8' id='POidList' name='POidList'>";
//		      html=html+'<option value="">--Please Select PO ID--</option>';
//		      for (var i = 0; i < data.length; i++) {
//		          html += '<option value="' +data[i]+ '">' + data[i]
//		          + '</option>';
//		      }
//
//		      document.getElementById("POidList").innerHTML=html;
//		  });
		  
		  

		  var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getCustomerName";

		  $.ajax({

		      url :serviceUrl,
		      type : 'POST',
		      dataType: 'json',
		  }).done(function(data) {

		      var html =" <select class='form-control'  id='clientname' name='clientname' >";
		      html=html+'<option value="">--Please Select Customer--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("clientname").innerHTML=html;
		  });
		  
		  // / getcheckerName SM
		  
		  var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getcheckerName";

		  $.ajax({

		      url :serviceUrl,
		      type : 'POST',
		      dataType: 'json',
		  }).done(function(data) {

		      var html =" <select class='form-control' tabindex='8' id='FirstApprovername' name='FirstApprovername'>";
		      html=html+'<option value="">--Please Select Checker Name--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("FirstApprovername").innerHTML=html;
		  });
		
		  
		// Get authorizer Name start BH
		  var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		//	var serviceUrl = base_url + "/Master/getAuthorizerNameAM";  // BH
			var serviceUrl = base_url + "/Master/getAccManagerList";
		  $.ajax({

		      url :serviceUrl,
		      type : 'POST',
		      dataType: 'json',
		  }).done(function(data) {

// alert(data);
		      var html =" <select class='form-control' tabindex='8' id='SecondApprovername' name='SecondApprovername'>";
		      html=html+'<option value="">--Please Select Authorizer Name--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("SecondApprovername").innerHTML=html;
		  });
		// Get authorizer Name end
	


function abc()
{
	// Add an event listener to the productsuitaddrow dropdown
	document.getElementById("productsuitaddrow").addEventListener("change", function() {
	  var selectedSuit = this.value; // Get the selected Product Suite
	  
	  var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   var serviceUrl = base_url + "/Master/getproductnamelist";

	  $.ajax({
	    url: serviceUrl,
	    type: 'POST',
	    dataType: 'json',
	    data :'selectedSuit='+selectedSuit ,
	  }).done(function(data) {
		  
	    var html = " <select class='form-control' tabindex='8' id='productnameaddrow' name='productnameaddrow'>";
	    html = html + '<option value="">-- Select Product Tool --</option>';
	    for (var i = 0; i < data.length; i++) {
	      html += '<option value="' + data[i] + '">' + data[i] + '</option>';
	    }
	    document.getElementById("productnameaddrow").innerHTML = html;
	  });
	});

		  
		
		
		// / new added for Product Suite
		  
		    var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getproductsuitlist";

		  $.ajax({

		      url :serviceUrl,
		      type : 'POST',
		      dataType: 'json',
		      
		  }).done(function(data) {
			
	       
		      var html =" <select class='form-control' tabindex='8' id='productsuitaddrow' name='productsuitaddrow'>";
		      html=html+'<option value="">-- Select Product Suite--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("productsuitaddrow").innerHTML=html;
		      	     
		  });
	};	
	

}








var data3;
function addRow() {
	


    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getproductsuitlist";

$.ajax({

    url :serviceUrl,
    type : 'POST',
    dataType: 'json',
}).done(function(data) {
	
data3=data;





const selectedProductSuit=""; 
const productString = ""+data3+"";
const productArray = productString.split(',');

const tableBody = document.querySelector("#data-table tbody");
const placeholders = ['--Select Product Suite--','Enter Your Product Name', 'Enter Your Quantity', 'Enter Your Period', ];

// Create a new row
const newRow = tableBody.insertRow();

for (let i = 0; i < 4; i++) {const cell = newRow.insertCell();
let selectedProductSuit = ''; // Initialize a variable to store the selected
								// value

if (i === 0) {
	
	
	
    const select = document.createElement('select');
    select.classList.add('form-control');
    
    
    const placeholderOption = document.createElement('option');
    placeholderOption.value = ''; // Empty value
    placeholderOption.text = '-- Select Product Suite --'; // Placeholder text
    select.appendChild(placeholderOption);
    
    const options = productArray;  // Add your Product Suite names here

    options.forEach(optionName => {
        const option = document.createElement('option');
        select.id = 'productsuitaddrow';
        option.value = optionName;
        option.text = optionName;
        select.appendChild(option);
    });



    cell.appendChild(select);
 
} else if (i === 1) {
	
	var dataTool;

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	// var serviceUrl = base_url + "/Master/getsecuritysolutionList"; 
	var serviceUrl = base_url + "/Master/getAllsecuritysolutionList";

	// Perform AJAX request to fetch data
	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType: 'JSON',
	    // data: 'productsuit=' + ProdSuite
	}).done(function(data) {
	    console.log("all tool " + data);
	    
	    dataTool = data;
	    
	    createSelectElement(dataTool);
	});

	function createSelectElement(toolsArrays) {
	    const toolString = toolsArrays.join(',');  
	    const toolsArray = toolString.split(',');

	    const select1 = document.createElement('select');
	    select1.classList.add('form-control');  

	    const placeholderOption1 = document.createElement('option');
	    placeholderOption1.value = '';  // Empty value
	    placeholderOption1.text = '-- Select Product Tool --';  
	    select1.appendChild(placeholderOption1);

	    toolsArray.forEach(optionName1 => {
	        const option1 = document.createElement('option');
	        option1.value = optionName1;  
	        option1.text = optionName1;   
	        select1.appendChild(option1);
	    });

	    select1.id = 'productnameaddrow';

	    cell.appendChild(select1);
	}


 
} else {
	
	const input = document.createElement('input');
	input.classList.add('form-control');
	input.placeholder = placeholders[i];

	if (i === 2 ) {
	    input.type = 'text';
	    input.oninput = function () {
		 this.value = this.value.replace(/[^0-9]/g, '');
	       
	    };
	} else if (i === 3 ) {
	    input.type = 'number';
	}

	

	cell.appendChild(input);

    
}

}

// Add the delete button to the last cell
const deleteCell = newRow.insertCell();
const deleteButton = document.createElement('button');
deleteButton.textContent = 'Delete';
deleteButton.onclick = function() {
  deleteRow(deleteButton);
};
deleteButton.classList.add('btn', 'btn-danger');
deleteButton.style.marginLeft = '12%';
deleteCell.appendChild(deleteButton);


});

}



// last one end

  function deleteRow(button) {
     const row = button.closest('tr');
      row.remove();
  }

        // Function to calculate and update the total price
        function updateTotalPrice(row) {

            $('#totalpricedata', row).val(total);
        }




function deleteRow(btn)
{
	    const row = btn.parentNode.parentNode;
	    row.parentNode.removeChild(row);
}


function POidListData() {
	

	
	
	if($("#POidList").val() === '')
		{
		$("#clientAddress").val('');
		$("#ponumber").val('');
		$("#EnvironmentKeyNo").val('');
		$("#podate").val('');
		}else{
			$("#EnvironmentKeyNo").val('');
		}
	
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getPOidListData";
		
		
		  $.ajax({
			    type: 'POST',
			    url: serviceUrl,
			    dataType:'JSON',
			    data: 'POidList=' + $("#POidList").val(),
	  }).done(function(data) {
		  

		  var aaa = data[0];

		  console.log(data);
		  
		  $('#ponumber').val(decodeURIComponent(aaa[2]));
			$('#podate').val(decodeURIComponent(aaa[1]));
//			$('#productSuitName').val(decodeURIComponent(aaa[0]));
			
			$('#clientAddress').val(decodeURIComponent(aaa[3]) +" "+ aaa[5]);
			$('#endcostomername').val(decodeURIComponent(aaa[6]));
			
			proposalId = aaa[4];
			

			
//			$('#EnvironmentKeyNo').val(decodeURIComponent(data[1]));
	   

			var productData = data[1];
			
			  var html =" <select class='form-control' tabindex='8' id='productSuitNameList' name='productSuitNameList'>";
		      html=html+'<option value="">--Please Select Product--</option>';
		      for (var i = 0; i < productData.length; i++) {
		          html += '<option value="' +productData[i]+ '">' + productData[i]
		          + '</option>';
		      }

		      document.getElementById("productSuitNameList").innerHTML=html;
	  
	  });	
}

function getEnvironmentKey(){
	
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/generateEnvkey";

	  $.ajax({
		    type: 'POST',
		    url: serviceUrl,
		    dataType:'JSON',
		    data: 'productSuitNameList=' + $("#productSuitNameList").val()
		    +'&proposalId=' + proposalId,
}).done(function(data) {
	  
	  console.log(data);
//	  alert(data[0]);
	
	  $('#EnvironmentKeyNo').val(decodeURIComponent(data[0]));

  });
}

function POcustomData() {
	
//	alert("clientname::::"+ $("#clientname").val())
	
	$("#clientAddress").val('');
	$("#ponumber").val('');
	$("#EnvironmentKeyNo").val('');
	$("#podate").val('');

	
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getPoID";

	  $.ajax({
		    type: 'POST',
		    url: serviceUrl,
		    dataType:'JSON',
		    data: 'clientname=' + $("#clientname").val(),
}).done(function(data) {
	  
	  console.log("POcustomData::::"+data);
	

	  
	  ////////////
	  
      var html =" <select class='form-control' tabindex='8' id='POidList' name='POidList'>";
      html=html+'<option value="">--Please Select Customer--</option>';
      for (var i = 0; i < data.length; i++) {
          html += '<option value="' +data[i]+ '">' + data[i]
          + '</option>';
      }

      document.getElementById("POidList").innerHTML=html;
  });
}

function submitData() {
	
	if (!validateLicense()) {
		   // alert("fail")
		        event.preventDefault();
		    } else {
	

    const tableBody = document.querySelector("#data-table tbody");
    const rows = tableBody.querySelectorAll('tr');
     
    var adn ='';
     var asd =',';
     
     var array1=[];
     
    for (const row of rows) {
        const inputs = row.querySelectorAll('input');
            const select = row.querySelector('#productsuitaddrow'); 
            const select1 = row.querySelector('#productnameaddrow');
           // const select1 = row.querySelector('#productnameaddrow');
 
        for (const input of inputs) {
            if (input.value.trim() === '') {
              
                return; 
            }
        }

        var tenure = "";
        
        if(inputs[1].value === "1"){
        	tenure = inputs[1].value+" Year";
        } else {
        	tenure = inputs[1].value+" Years";
        }
        
        const   dataObj = {
	    prodsuit :select.value, 
	    prodname: select1.value,
//        prodname :inputs[0].value,
        Quantity: inputs[0].value,
        Period: tenure,
    // urate: inputs[2].value,
    // toprice: inputs[3].value,
        };

        const csvString = Object.values(dataObj).join(',');
        adn=adn+asd+csvString;
        array1.push(dataObj);   
       
    }

   SaveVeloxLicense(JSON.stringify(array1));
}
}





function SaveVeloxLicense(veloxdata) { 
	var filePath = $("#licenseUploadfile").val();
	var fileName = filePath.split("\\").pop();
	
	
	$('#spin2').show();
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/veloxLicensedetails";
 										 

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'veloxdata=' +encodeURIComponent(veloxdata)	
             +'&sppliernamelicense=' + encodeURIComponent($("#sppliernamelicense").val())
             
             
             //06/06
             +'&licenseforname=' + encodeURIComponent($("#licenseforname").val())
             //
             
             +'&OEMAddress=' + encodeURIComponent($("#OEMAddress").val())
             +'&clientname=' + encodeURIComponent($("#clientname").val())
             +'&clientAddress=' + encodeURIComponent($("#clientAddress").val())
             +'&EnvironmentKeyNo=' + encodeURIComponent($("#EnvironmentKeyNo").val())
             +'&ponumber=' + encodeURIComponent($("#ponumber").val())
             +'&podate=' + encodeURIComponent($("#podate").val())
             +'&endcostomername=' + encodeURIComponent($("#endcostomername").val()) 
              +'&endCustomerEmail=' + encodeURIComponent($("#endCustomerEmail").val()) 
             +'&FirstApprovername=' + encodeURIComponent($("#FirstApprovername").val())
              +'&SecondApprovername=' + encodeURIComponent($("#SecondApprovername").val())
              +'&poID=' + encodeURIComponent($("#POidList").val())
              +'&payment_recieved=' + encodeURIComponent($("#payment_recieved").val())
              
              +'&distributor=' + encodeURIComponent($("#Distributor").val())
              +'&partner1=' + encodeURIComponent($("#partner1").val())
              +'&partner2=' + encodeURIComponent($("#partner2").val())
              +'&submissionType=' + encodeURIComponent($("#submissionType").val())
              +'&licenseUploadfile=' + encodeURIComponent(fileName),
                                     
        }).done(function(data) {
//   alert("data "+data)       
        	$('#spin2').hide();
        	
   var status = data.split("~")[1];
   var LId = data.split("~")[0];
//   alert("status "+status+ " :: LId "+LId)
 if (status == "success") {
 
	 if($("#submissionType").val() === "Upload License") {
	 		saveLicenseFile();
	 	}
	 
                swal({
                    title: "Successful!",
//                    text: "Record Added Successfully",
                    html: "Velox License ID = " + LId + "<br><br>Added Successfully",
                   // html: "Proposal ID = " + data + "<br><br> Proposal Sent
					// Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/User/VeloxLicense";
                    }

                });
        } else {
        	
        	 swal({
                 title: "Unsuccessful!",
                 text: "Fail to add file",
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
                     window.location.href = base_url + "/User/VeloxLicense";
                 }

             });
        		 
        	   
        }
        });   
}




		

function validatequantity(input){
	// alert("HIH")
	  var inputValue = input.value;
	    // Remove non-numeric characters from the input
	    var numericValue = inputValue.replace(/\D/g, '');

	    // Update the input field with the numeric value
	    input.value = numericValue;
    // Get the value from the input field
    var unitratedata = document.getElementById("Desciption").value;
    
    // Regular expression pattern for a valid email address
    var unitratedataPattern =/^\d+(\.\d+)?$/;

}

function validateLicense(){
	
    var indexError = 0;
    
    if ($('#clientname').val().trim() === '') {
        callToolTip231('clientname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#licenseforname').val().trim() === '') {
        callToolTip231('licenseforname', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#Distributor').val().trim() === '' && $('#licenseforname').val().trim() === 'Distributor') {
        callToolTip231('Distributor', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#partner1').val().trim() === '' && ($('#licenseforname').val().trim() === 'Partner1' || $('#licenseforname').val().trim() === 'Partner2' || $('#licenseforname').val().trim() === 'Distributor' ) ) {
        callToolTip231('partner1', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    if ($('#partner2').val().trim() === '' && $('#licenseforname').val().trim() === 'Partner2') {
        callToolTip231('partner2', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    
    
    
    if ($('#POidList').val().trim() === '') {
        callToolTip231('POidList', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#clientAddress').val().trim() === '') {
        callToolTip231('clientAddress', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#EnvironmentKeyNo').val().trim() === '') {
        callToolTip231('EnvironmentKeyNo', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#podate').val().trim() === '') {
        callToolTip231('podate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#endcostomername').val().trim() === '') {
        callToolTip231('endcostomername', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } 
    
    if ($('#endCustomerEmail').val().trim() === '') {
        callToolTip231('endCustomerEmail', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#payment_recieved').val().trim() === '') {
        callToolTip231('payment_recieved', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#FirstApprovername').val().trim() === '') {
        callToolTip231('FirstApprovername', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#SecondApprovername').val().trim() === '') {
        callToolTip231('SecondApprovername', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#submissionType').val().trim() === '') {
        callToolTip231('submissionType', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    
    if ($('#licenseUploadfile').val().trim() === '' && $('#submissionType').val().trim() === 'Upload License') {
        callToolTip231('licenseUploadfile', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
    
    if ($('#productsuitaddrow').val().trim() === '') {
        callToolTip231('productsuitaddrow', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#productnameaddrow').val().trim() === '') {
        callToolTip231('productnameaddrow', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#Desciption').val().trim() === '') {
        callToolTip231('Desciption', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#quantitydata').val().trim() === '') {
        callToolTip231('quantitydata', 'show');
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

	  
    if (fieldName == "clientname") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Customer <span>";
    }
    
    if (fieldName == "licenseforname") {
        var errorMessage = "<span>Select License For <span>";
    }
    if (fieldName == "Distributor") {
        var errorMessage = "<span>Enter Distributor <span>";
    }
    if (fieldName == "partner1") {
        var errorMessage = "<span>Enter Partner <span>";
    }
    if (fieldName == "partner2") {
        var errorMessage = "<span>Enter 2nd Partner <span>";
    }
    
    if (fieldName == "POidList") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select PO Id <span>";
    }
    if (fieldName == "clientAddress") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Address<span>";
    }
    if (fieldName == "EnvironmentKeyNo") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Environment Key No <span>";
    }
    if (fieldName == "podate") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Po Date <span>";
    }
    if (fieldName == "endcostomername") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter End Customer Name <span>";
    } 
    if (fieldName == "endCustomerEmail") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter End Customer Email <span>";
    }
    
    if (fieldName == "payment_recieved") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Option <span>";
    }
    if (fieldName == "FirstApprovername") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Checker Name <span>";
    }
    if (fieldName == "SecondApprovername") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Authorizer Name <span>";
    }
    if (fieldName == "submissionType") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Submisstion Type <span>";
    }
    if (fieldName == "licenseUploadfile") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select License File <span>";
    }
    
    if (fieldName == "productsuitaddrow") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Product Suit Name <span>";
    }
    if (fieldName == "productnameaddrow") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Product Name <span>";
    }
    if (fieldName == "Desciption") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Quantity <span>";
    }
    
    if (fieldName == "quantitydata") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Period <span>";
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

$('#clientname').on('focus', function() {
    callToolTip231('clientname', 'destroy');

    
});

$('#POidList').on('focus', function() {
    callToolTip231('POidList', 'destroy');
    
});

$('#licenseforname').on('focus', function() {
    callToolTip231('licenseforname', 'destroy');  
});
$('#Distributor').on('focus', function() {
    callToolTip231('Distributor', 'destroy');  
});
$('#partner1').on('focus', function() {
    callToolTip231('partner1', 'destroy');  
});
$('#partner2').on('focus', function() {
    callToolTip231('partner2', 'destroy');  
});

$('#clientAddress').on('focus', function() {
    callToolTip231('clientAddress', 'destroy');
    
});

$('#POidList').on('change', function () {
    
    callToolTip231('clientAddress', 'destroy');
});

$('#EnvironmentKeyNo').on('focus', function() {
    callToolTip231('EnvironmentKeyNo', 'destroy');
    
});

$('#POidList').on('change', function () {
    
    callToolTip231('EnvironmentKeyNo', 'destroy');
});

$('#podate').on('focus', function() {
    callToolTip231('podate', 'destroy');
    
});

$('#POidList').on('change', function () {
    
    callToolTip231('podate', 'destroy');
});

$('#endcostomername').on('focus', function() {
    callToolTip231('endcostomername', 'destroy');
    
});  

$('#endCustomerEmail').on('focus', function() {
    callToolTip231('endCustomerEmail', 'destroy');
    
});

$('#payment_recieved').on('focus', function() {
    callToolTip231('payment_recieved', 'destroy');
    
});

$('#FirstApprovername').on('focus', function() {
    callToolTip231('FirstApprovername', 'destroy');
    
});

$('#SecondApprovername').on('focus', function() {
    callToolTip231('SecondApprovername', 'destroy');
    
});
$('#submissionType').on('focus', function() {
    callToolTip231('submissionType', 'destroy');
});
$('#licenseUploadfile').on('focus', function() {
    callToolTip231('licenseUploadfile', 'destroy');  
});

$('#productsuitaddrow').on('focus', function() {
    callToolTip231('productsuitaddrow', 'destroy');
    
});

$('#productnameaddrow').on('focus', function() {
    callToolTip231('productnameaddrow', 'destroy');
    
});

$('#Desciption').on('focus', function() {
    callToolTip231('Desciption', 'destroy');
    
});

$('#quantitydata').on('focus', function() {
    callToolTip231('quantitydata', 'destroy');
    
});

function resetDetails() {
	
	$('#clientname').val("");
    $('#POidList').val("");
    
    $('#licenseforname').val("");
    $('#Distributor').val("");
    $('#partner1').val("");
    $('#partner2').val("");
    
    $('#clientAddress').val("");
    $('#EnvironmentKeyNo').val("");
    $('#podate').val("");
    $('#endcostomername').val(""); 
    $('#endCustomerEmail').val("");
    $('#payment_recieved').val("");
    $('#FirstApprovername').val("");
    $('#SecondApprovername').val("");
    $('#submissionType').val("");
    $('#licenseUploadfile').val("");
    $('#productsuitaddrow').val("");
    $('#productnameaddrow').val("");
    $('#Desciption').val("");
    $('#quantitydata').val("");
    $('#ponumber').val("");
    $('#productSuitName').val("");
    
    
    
    callToolTip231('clientname', 'destroy');
    callToolTip231('POidList', 'destroy');
    callToolTip231('clientAddress', 'destroy');
    callToolTip231('podate', 'destroy');
    callToolTip231('EnvironmentKeyNo', 'destroy');
    callToolTip231('endcostomername', 'destroy');
    callToolTip231('endCustomerEmail', 'destroy');
    callToolTip231('payment_recieved', 'destroy');
    callToolTip231('FirstApprovername', 'destroy');

    callToolTip231('SecondApprovername', 'destroy');
    callToolTip231('submissionType', 'destroy');
    callToolTip231('licenseUploadfile', 'destroy');
    callToolTip231('productsuitaddrow', 'destroy');
    callToolTip231('productnameaddrow', 'destroy');
    callToolTip231('Desciption', 'destroy');
    callToolTip231('quantitydata', 'destroy');
        callToolTip231('Distributor', 'destroy');  
        callToolTip231('partner1', 'destroy');  
        callToolTip231('partner2', 'destroy');  
	
}


function validateEmailContact(){
	
//     Get the value from the input field
 var email = document.getElementById("endCustomerEmail").value;
    
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


function licenseFor(value) {
	
	 	$('#Distributor').val("");
	    $('#partner1').val("");
	    $('#partner2').val("");
	    callToolTip231('Distributor', 'destroy');  
        callToolTip231('partner1', 'destroy');  
        callToolTip231('partner2', 'destroy');
	
	if(value ==="Partner1") {
		$("#Partner1Div").show();
		$("#DistributorDiv").hide();
		$("#Partner2Div").hide();
	} else if(value ==="Partner2") {
		$("#DistributorDiv").hide();
		$("#Partner1Div").show();
		$("#Partner2Div").show();
	} else if(value ==="Distributor") {
		$("#DistributorDiv").show();
		$("#Partner1Div").show();
		$("#Partner2Div").hide();
	} else {
		$("#DistributorDiv").hide();
		$("#Partner1Div").hide();
		$("#Partner2Div").hide();
	}
}

function submissionType(type) {
	
	if(type==="Upload License") {
		$("#UploadLicDiv").show()
	} else {
		$("#UploadLicDiv").hide()
	}
	
	 callToolTip231('licenseUploadfile', 'destroy');
	 $('#licenseUploadfile').val("");
	 
	 
}

function saveLicenseFile() {
	alert("in save File");
	 var formData= new FormData(form);
	 
	   var l2 = window.location;
	 	var base_url2 = l2.protocol + "//" + l2.host + "/" + l2.pathname.split('/')[1];
//	 	var serviceUrl2 = base_url2 + "/UserActivity/insertPurchaseOrder";
	 	var serviceUrl2 = base_url2 + "/Master/uploadLicenseFile";
	
	$.ajax({
        type: 'POST',
        url: serviceUrl2,
        data: formData,
        mimeType: "multipart/form-data",
        contentType: false,
        processData: false,
        cache: false,

        		
    }).done(function(data) {
    
    alert("file Saved "+data)
    return;
    });
}