/**
 * 
 */
// alert("SIii")
var subcategory = "";
var statusCI = "";


window.onload = function() {
	
	
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
	          html += '<option value="' +data[i]+ '">' + data[i]+ '</option>';
	      }
	      document.getElementById("FirstApprovername").innerHTML=html;
	  });
	  
	  
	// Get authorizer Name start BH
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getAccManagerList";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	  }).done(function(data) {

//alert(data);
	      var html =" <select class='form-control' tabindex='8' id='SecondApprovername' name='SecondApprovername'>";
	      html=html+'<option value="">--Please Select Authorizer Name--</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
	      document.getElementById("SecondApprovername").innerHTML=html;
	  });
	  
	  
	
	
	
	$('.nav-tabs a').click(function() {
		$(this).tab('show');
	});


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getProposalLicenseDataSM";

	$.ajax({
		url: serviceUrl,
		type: 'POST',
		dataType: 'json',
		data: "crno=" + $('#crnoo').val()
			+ '&tid=' + $("#tid").val()
	}).done(function(data) {
	//	alert("data cus"+data[0][0])
		var aaa = data[0];
		
		console.log(data);

		$('#clientname').val(decodeURIComponent(data[0][0]));
		var custName= decodeURIComponent(data[0][0]);
		$('#clientAddress').val(decodeURIComponent(data[0][1]));
		$('#EnvironmentKeyNo').val(decodeURIComponent(data[0][2]));
		$('#ponumber').val(decodeURIComponent(data[0][3]));
		$('#podate').val(decodeURIComponent(data[0][4]));
		$('#endcostomername').val(decodeURIComponent(data[0][5]));
		$('#endCustomerEmail').val(decodeURIComponent(data[0][6]));
		$('#FirstApprovername').val(decodeURIComponent(aaa[10]));
		$('#SecondApprovername').val(decodeURIComponent(aaa[11]));

		$('#payment_recieved').val(data[0][9]);
		
		
		if ((aaa[7] == "File Not Attached") || (aaa[7] == "NA") || (aaa[7] == "null")) {
			$('#downHidepofile').hide();
		} else {
			document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[7]);
			document.getElementById('filenameStandard').value = decodeURIComponent(aaa[7]);
			$('#poUploadDiv').show();
		}

         $('#viewdataLicenseCreatedTable').show();
			var table = $('#viewdataLicenseCreatedTable').DataTable({
				lengthChange: false,
				pageLength: 5,
				data: aaa[8],
				dataType: 'json',
				scrollX: '300px',
			});
	});
	
	
	
	  
	  
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

	  
}

function downFileStandard() {
	var filename = encodeURIComponent($('#filenameStandard').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename=" + filename;

}





function advInvFileStandard() {
	var filename = $('#filnameAdvinvoice').val();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
		+ filename;
}



// //////////////////////////////////////////////////////// save data



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


function submitData() {
	
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

        const   dataObj = {
	    prodsuit :select.value, 
	    prodname: select1.value,
//        prodname :inputs[0].value,
        Quantity: inputs[0].value,
        Period: inputs[1].value,
    // urate: inputs[2].value,
    // toprice: inputs[3].value,
        };

        const csvString = Object.values(dataObj).join(',');
        adn=adn+asd+csvString;
        array1.push(dataObj);   
       
    }

   SaveVeloxLicense(JSON.stringify(array1));
}

function SaveVeloxLicense(veloxdata) {   
	$('#spin2').show();
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/Master/veloxLicensedetails";
 	var serviceUrl = base_url + "/Master/updateVeloxLicensedetails";
 										 
 //	alert("pay "+$("#payment_recieved").val())
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'veloxdata=' +encodeURIComponent(veloxdata)	
             +'&sppliernamelicense=' + encodeURIComponent($("#sppliernamelicense").val())
             
             +'&crno=' + encodeURIComponent($("#crnoo").val())
             +'&tid=' + encodeURIComponent($("#tid").val())
             
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
              +'&payment_recieved=' + encodeURIComponent($("#payment_recieved").val()),
                                     
        }).done(function(data) {
          
        	$('#spin2').hide();
        	
        	var dataArray = data.split(',');
       	 var firstPart = dataArray[0]; // "VL-20"
       	 var secondPart = dataArray[1]; // "Success"
       	 
 if (secondPart == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Updated Successfully",
                    html: "License ID = " + firstPart + "<br><br> License Sent Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/User/LicenseRejectedFeedbackSI";
                    }

                });
 }
        });   
}


function validateEmailContact(){
	
//  Get the value from the input field
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