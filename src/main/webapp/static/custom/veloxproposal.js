
var a=1;



var data_product_tool="";

function abc11(value2)
{
	selectedValueATC=value2;
}

var subtotalforalldd =  '';

var subtotalforalldd21 =  '';


window.onload = function() {
	
	abc();
	abc21();
	sectools();
	  $("#veloxproposaldetails").show();
	  
	  
	  // Proposal Master list
	  
	    var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getProposalName";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	  }).done(function(data) {

	      var html =" <select class='form-control' tabindex='8' id='Proposaltype' name='Proposaltype'>";
	      html=html+'<option value="">--Please Select Proposal Name--</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }

	      document.getElementById("Proposaltype").innerHTML=html;
	      
	      

	      
	  });
	  
	  
	    var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getCustomerName";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	  }).done(function(data) {

	      var html =" <select class='form-control' tabindex='8' id='clientname' name='clientname'>";
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
		  
	  
	  
		// checker list
		  
			 
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
	
	

	function abc21()
	{
		// Add an event listener to the productsuitaddrow dropdown
		document.getElementById("productsuitaddrow21").addEventListener("change", function() {
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
			  
			  var html =" <select class='form-control' tabindex='8' id='productnameaddrow21' name='productnameaddrow21'>";
		      html=html+'<option value="">--Please Select Product Tool--</option>';
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }

		      document.getElementById("productnameaddrow21").innerHTML=html;
		    
	   
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
				
				   var html =" <select class='form-control' tabindex='8' id='productsuitaddrow21' name='productsuitaddrow21'>";
				      html=html+'<option value="">-- Select Product Suite--</option>';
				      for (var i = 0; i < data.length; i++) {
				          html += '<option value="' +data[i]+ '">' + data[i]
				          + '</option>';
				      }

				      document.getElementById("productsuitaddrow21").innerHTML=html;
			      
			      	     
			  });
		};
	
}




function validatecloud(){

    var clouddeploycharges = document.getElementById("clouddeploycharges").value;
    

    var clouddeploychargesPattern =/^\d+(\.\d+)?$/;


}


function resoucesamount(){
	// alert("HIH")
    // Get the value from the input field
    var resoucesamount = document.getElementById("resoucesamount").value;
    
    // Regular expression pattern for a valid email address
    var resoucesamountPattern =/^\d+(\.\d+)?$/;


}
function validateQuantity(input) {

    var inputValue = input.value;
    // Remove non-numeric characters from the input
    var numericValue = inputValue.replace(/\D/g, '');

    // Update the input field with the numeric value
    input.value = numericValue;

  var quantitydatacharges = document.getElementById("quantitydata").value;
  
  // Regular expression pattern for a valid email address
  var quantitydataPattern =/^\d+(\.\d+)?$/;


}


function validateunitrate(input){

	  var inputValue = input.value;
	   
	    var numericValue = inputValue.replace(/\D/g, '');

	 
	    input.value = numericValue;
    // Get the value from the input field
    var unitratedata = document.getElementById("unitratedata").value;
    
    // Regular expression pattern for a valid email address
    var unitratedataPattern =/^\d+(\.\d+)?$/;


}
function validateapprover(){
	
    var deploysupport = document.getElementById("deploysupport").value;
    

    var deploysupportPattern =/^\d+(\.\d+)?$/;


}

function getColumnData() {
	// //alert("hiii");
	
	

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getProductName";
	
	
	$.ajax({
				url : serviceUrl,
				type : 'post',
				data : 'clientname=' + $('#clientname').val()

			})
			.done(
					function(data) {
						    // alert(data)
						var pollingHost = data;
						var d = pollingHost.split(",");

						var length = d.length-1;
						// //alert(length)

						var html ;
						// html += '<option value="">---Please
						// Select---</option>';
						for (var i = 0; i < length; i++) {

							// //alert(d1);

							html += '<option value="&apos;' + d[i] + '&apos;">'
									+ d[i] + '</option>';
						}

					
						document.getElementById("astdt").innerHTML = html;
// $("#astdt").multiselect('destroy');
						
// multi231();
					
						

					});

	function multi231() {

		$("#astdt").multiselect({
			includeSelectAllOption : true,
			enableFiltering : true,
			maxHeight : 200,
			enableCaseInsensitiveFiltering : true,
			buttonWidth : '100%',
		});
	}


}

$(function() {
	$("#astdt").multiselect({
		includeSelectAllOption : true,
		enableFiltering : true,
		maxHeight : 200,
		enableCaseInsensitiveFiltering : true,
		buttonWidth : '100%',
	});
});


// $('#submit-btn').click(function()
// {
//		
// // if (!validation2222())
// // {
// // event.preventDefault();
// // } else if (validation2222())
// // {
// // // //alert("adduser")
// // saveDataEmail();
// // }
// $("#veloxproposaldetails").show();
// }).show();


function saveVeloxProposal() {
	
  // //alert("in fun")
	 // alert($("#pass").val().trim())
	// //alert(starttls)
// var l = window.location;
// var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// var serviceUrl = base_url + "/Master/adduserEmail";
// $.ajax({
// url: serviceUrl,
// type: 'post',
// data:'company=' + encodeURIComponent($("#company").val().trim())
// + '&mail=' + $("#mail").val().trim()
// + '&subject=' + $("#subject").val().trim()
// + '&folder=' + $("#folder").val().trim()
// + '&port=' + $("#port").val().trim()
// + '&uname=' + $("#uname").val().trim()
// + '&pass=' + $("#pass").val()
// ,
//              
// success: function(data) {
// // //alert(data)
// if (data == "success") {
// swal({
// title: "Successful!",
// text: "Record Inserted Successfully!",
// type: "success",
// width: 300,
// height: 200,
//
// buttons: false,
// allowOutsideClick: false,
// preConfirm: function() {
// location.reload();
// }
//
// })
//
// } else if (data == "duplicate") {
// swal({
// title: "Duplicate Data!",
// text: "Record Already Exists",
// type: "warning",
// width: 300,
// height: 200,
// buttons: false,
// allowOutsideClick: false,
// preConfirm: function() {
// location.reload();
// }
//
// })
//
// }
// }
// })
}




function validatepo() {
// var spinner = document.getElementById("spin1");
//
// // Set the display property to "none" to hide the spinner
// spinner.style.display = "none";
	
	var indexError = 0;
	if ($('#Proposaltype').val().trim() === '') {
		callToolTip122('Proposaltype', 'show');
	if (indexError == 0) {

	}
	indexError = indexError + 1;
	} else {

	indexError = 0;
	}

// if ($('#Perpetualyear').val().trim() === '') {
// callToolTip122('Perpetualyear', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
//
// if ($('#Subscriptionyear').val().trim() === '') {
// callToolTip122('Subscriptionyear', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }





// if ($('#poinitiator').val().trim() === '') {
// callToolTip122('poinitiator', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }


// if ($('#poinitiatorno').val().trim() === '') {
// callToolTip122('poinitiatorno', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
	if ($('#FirstApprovername').val().trim() === '') {
		callToolTip122('FirstApprovername', 'show');
	if (indexError == 0) {

	}
	indexError = indexError + 1;
	} else {

	indexError = 0;
	}

// if ($('#firstapprovercontact').val().trim() === '') {
// callToolTip122('firstapprovercontact', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
//
//
// if ($('#secondApprovername').val().trim() === '') {
// callToolTip122('secondApprovername', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
//	 
// if ($('#secondapprovercontact').val().trim() === '') {
// callToolTip122('secondapprovercontact', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
	
	 if ($('#customerType').val().trim() === '') {
		 callToolTip122('customerType', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	// if ($('#clientname').val().trim() === '') {
// callToolTip122('clientname', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// 
	// if ($('#newcustomername').val().trim() === '') {
// callToolTip122('newcustomername', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// if ($('#newAddress').val().trim() === '') {
// callToolTip122('newAddress', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// if ($('#newdistrict').val().trim() === '') {
// callToolTip122('newdistrict', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// 
	// if ($('#newcity').val().trim() === '') {
// callToolTip122('newcity', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// if ($('#newpin').val().trim() === '') {
// callToolTip122('newpin', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	// if ($('#office_mailid').val().trim() === '') {
// callToolTip122('office_mailid', 'show');
// if (indexError == 0) {
	//
// }
// indexError = indexError + 1;
// } else {
	//
// indexError = 0;
// }
	 if ($('#productsuitaddrow').val().trim() === '') {
		 callToolTip122('productsuitaddrow', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	 if ($('#productnameaddrow').val().trim() === '') {
		 callToolTip122('productnameaddrow', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	 if ($('#Desciption').val().trim() === '') {
		 callToolTip122('Desciption', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	 
	 if ($('#quantitydata').val().trim() === '') {
		 callToolTip122('quantitydata', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	 
	 if ($('#Desciption').val().trim() === '') {
		 callToolTip122('Desciption', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	 
	 if ($('#unitratedata').val().trim() === '') {
		 callToolTip122('unitratedata', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	 
// if ($('#totalpricedata').val().trim() === '') {
// callToolTip122('totalpricedata', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
	 
	 if ($('#deploysupport').val().trim() === '') {
		 callToolTip122('deploysupport', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	 
// if ($('#clouddeploycharges').val().trim() === '') {
// callToolTip122('clouddeploycharges', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
	 
	 if ($('#IntegrationCharges').val().trim() === '') {
		 callToolTip122('IntegrationCharges', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	 
	 if ($('#resoucesamount').val().trim() === '') {
		 callToolTip122('resoucesamount', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	 
	 if ($('#ATC').val().trim() === '') {
		 callToolTip122('ATC', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
// if ($('#totalpriceforallproduct').val().trim() === '') {
// callToolTip122('totalpriceforallproduct', 'show');
// if (indexError == 0) {
//
// }
// indexError = indexError + 1;
// } else {
//
// indexError = 0;
// }
	 if ($('#clientname').val().trim() === '') {
		 callToolTip122('clientname', 'show');
		 if (indexError == 0) {

		 }
		 indexError = indexError + 1;
		 } else {

		 indexError = 0;
		 }
	 
	 
	 
	if (indexError > 0) {
	return false;
	} else {
	return true;
	}

}

var callToolTip122 = function(fieldName, status) {
	

    if (fieldName == "Proposaltype") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Proposal Type  <span>";
    }
 if (fieldName == "Perpetualyear") { 
 // $("#email").tooltip('destroy');
 var errorMessage = "<span>Select Perpetual Year <span>";
 }
 if (fieldName == "Subscriptionyear") {
 // $("#email").tooltip('destroy');
 var errorMessage = "<span>Select Subscription Year <span>";
 }
 
 if (fieldName == "fixedyear") {
	 // $("#email").tooltip('destroy');
	 var errorMessage = "<span>Select Fixed Year <span>";
	 }
 if (fieldName == "subscriptionANDperpetualYear") {
	 // $("#email").tooltip('destroy');
	 var errorMessage = "<span>Select Subscription & Perpetual  Year <span>";
	 }
// if (fieldName == "poinitiator") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Maker Name <span>";
// }
// if (fieldName == "poinitiatorno") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Maker Contact Number <span>";
// }
    if (fieldName == "FirstApprovername") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Checker Name <span>";
    }
// if (fieldName == "firstapprovercontact") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Checker Approver Contact No <span>";
// }
// if (fieldName == "secondApprovername") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Authorizer Name <span>";
// }
//  
// if (fieldName == "secondapprovercontact") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Authorizer Contact Number <span>";
// }
    if (fieldName == "productsuitselect") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Product Suit  <span>";
    }
    if (fieldName == "FirstApprovername") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Checker Name <span>";
    }
    if (fieldName == "customerType") { 
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Type Of Customer  <span>";
    }
    if (fieldName == "clientname") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Customer Name<span>";
    }
    
    
    
    
    if (fieldName == "productsuitaddrow") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Product Suite <span>";
    }
    
    if (fieldName == "productnameaddrow") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Select Product Tool <span>";
    }
    
    if (fieldName == "Desciption") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Desciption  <span>";
    }
    if (fieldName == "quantitydata") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Quantity  <span>";
    }  
    
    if (fieldName == "unitratedata") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Unit Rate <span>";
    }  
    
// if (fieldName == "totalpricedata") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Total Price <span>";
// }
    	
    	if (fieldName == "deploysupport") {
        // $("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Deployement support <span>";
    }
 if (fieldName == "clouddeploycharges") {
 // $("#email").tooltip('destroy');
 var errorMessage = "<span>Enter Deployement Charges <span>";
 }
    	if (fieldName == "IntegrationCharges") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select Integration Charges <span>";
        }
    	if (fieldName == "resoucesamount") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Resources Amount  <span>";
        }
//    	if (fieldName == "ATC") {
//            // $("#email").tooltip('destroy');
//            var errorMessage = "<span>Select ATC <span>";
//        }
    	
// if (fieldName == "totalpriceforallproduct") {
// // $("#email").tooltip('destroy');
// var errorMessage = "<span>Enter Sub Total <span>";
// }
    	
    	
    	if (fieldName == "newcustomername") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Customer Name  <span>";
        }
    	if (fieldName == "newAddress") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Address  <span>";
        }
    	if (fieldName == "newdistrict") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter District  <span>";
        }
    	if (fieldName == "newcity") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter City  <span>";
        }
    	if (fieldName == "newpin") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Pin  <span>";
        }
    	if (fieldName == "office_mailid") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Office Mailid  <span>";
        }
    	
    	if (fieldName == "clientname") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select Customer Name  <span>";
        }
    	
    	if (fieldName == "amcstartdate") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select AMC Start Date <span>";
        }
    	if (fieldName == "AMCmonthyear") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select Month/Year  <span>";
        }
    	if (fieldName == "AMCMonth") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select Month <span>";
        }
    	if (fieldName == "AMCYear") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select Year<span>"; 
        } 
        if (fieldName == "productsuitdetails") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select Product Suit<span>"; 
        }
        if (fieldName == "securitysolutiondetails") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Select Security Tool<span>"; 
        }
        if (fieldName == "descforamc") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Description<span>"; 
        }
        if (fieldName == "totalcostAMC") {
            // $("#email").tooltip('destroy');
            var errorMessage = "<span>Enter Total Cost<span>"; 
        }
        
        
        
        if (fieldName == "productsuitaddrow") {
            var errorMessage = "<span>Select Product Suit<span>"; 
        }
        if (fieldName == "productnameaddrow") {
            var errorMessage = "<span>Select Security Tool<span>"; 
        }
        if (fieldName == "Desciption") {
            var errorMessage = "<span>Enter Description<span>"; 
        }
        if (fieldName == "quantitydata") {
            var errorMessage = "<span>Enter Quantity <span>"; 
        }
        if (fieldName == "unitratedata") {
            var errorMessage = "<span>Enter Unite Rate <span>"; 
        }
        if (fieldName == "deploysupport") {
            var errorMessage = "<span>Enter Implementation Charges<span>"; 
        }
        if (fieldName == "clouddeploycharges") {
            var errorMessage = "<span>Enter Deployment Charges<span>"; 
        }
        if (fieldName == "IntegrationCharges") {
            var errorMessage = "<span>Enter Integration Charges<span>"; 
        }
        if (fieldName == "resoucesamount") {
            var errorMessage = "<span>Enter Resource Amount<span>"; 
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



$('#Proposaltype').on('focus', function() {
	callToolTip122('Proposaltype', 'destroy');
	
});
 $('#Perpetualyear').on('focus', function() {
 callToolTip122('Perpetualyear', 'destroy');
	
 });
 $('#Subscriptionyear').on('focus', function() {
 callToolTip122('Subscriptionyear', 'destroy');
	
 });
 $('#poinitiator').on('focus', function() {
 callToolTip122('poinitiator', 'destroy');
	
 });
 $('#poinitiatorno').on('focus', function() {
 callToolTip122('poinitiatorno', 'destroy');
	
 });
$('#FirstApprovername').on('focus', function() {
	callToolTip122('FirstApprovername', 'destroy');
	
});
// $('#firstapprovercontact').on('focus', function() {
// callToolTip122('firstapprovercontact', 'destroy');
//	
// });
// $('#secondApprovername').on('focus', function() {
// callToolTip122('secondApprovername', 'destroy');
//	
// });
//
//
// $('#secondapprovercontact').on('focus', function () {
// callToolTip122('secondapprovercontact', 'destroy');
// });
$('#customerType').on('focus', function () {
	callToolTip122('customerType', 'destroy');
});
$('#clientname').on('focus', function () {
	callToolTip122('clientname', 'destroy');
});

$('#productsuitaddrow').on('focus', function () {
	callToolTip122('productsuitaddrow', 'destroy');
});

$('#productnameaddrow').on('focus', function () {
	callToolTip122('productnameaddrow', 'destroy');
});
$('#Desciption').on('focus', function () {
	callToolTip122('Desciption', 'destroy');
});
$('#quantitydata').on('focus', function () {
	callToolTip122('quantitydata', 'destroy');
});

$('#unitratedata').on('focus', function () {
	callToolTip122('unitratedata', 'destroy');
});

// $('#totalpricedata').on('focus', function () {
// callToolTip122('totalpricedata', 'destroy');
// });

$('#deploysupport').on('focus', function () {
	callToolTip122('deploysupport', 'destroy');
});

// $('#clouddeploycharges').on('focus', function () {
// callToolTip122('clouddeploycharges', 'destroy');
// });
$('#IntegrationCharges').on('focus', function () {
	callToolTip122('IntegrationCharges', 'destroy');
});
$('#clouddeploycharges').on('focus', function () {
	callToolTip122('clouddeploycharges', 'destroy');
});
$('#resoucesamount').on('focus', function () {
	callToolTip122('resoucesamount', 'destroy');
});
$('#ATC').on('focus', function () {
	callToolTip122('ATC', 'destroy');
});

// $('#totalpriceforallproduct').on('focus', function () {
// callToolTip122('totalpriceforallproduct', 'destroy');
// });

$('#newcustomername').on('focus', function () {
	callToolTip122('newcustomername', 'destroy');
});
$('#newAddress').on('focus', function () {
	callToolTip122('newAddress', 'destroy');
});
$('#newdistrict').on('focus', function () {
	callToolTip122('newdistrict', 'destroy');
});
$('#newcity').on('focus', function () {
	callToolTip122('newcity', 'destroy');
});

$('#newpin').on('focus', function () {
	callToolTip122('newpin', 'destroy');
});

$('#office_mailid').on('focus', function () {
	callToolTip122('office_mailid', 'destroy');
});
$('#clientname').on('focus', function () {
	callToolTip122('clientname', 'destroy');
});





$("#reset-btn").click(function() {
	callToolTip122('clientname', 'destroy');
	$('#Proposaltype').val("");
// $('#Perpetualyear').val("");
// $('#Subscriptionyear').val("");
	$('#FirstApprovername').val("");
	$('#customerType').val("");
	$('#productsuitaddrow').val("");
	$('#productnameaddrow').val("");
	$('#Desciption').val("");
	$('#quantitydata').val("");
	$('#unitratedata').val("");
// $('#totalpricedata').val("");
	$('#deploysupport').val("");
// $('#clouddeploycharges').val("");
	$('#IntegrationCharges').val("");
	$('#resoucesamount').val("");
	$('#ATC').val("");
// $('#totalpriceforallproduct').val("");
	
	$('#Perpetualyear').val(""); 
	$('#Subscriptionyear').val("");
	$('#fixedyear').val("");
	$('#subscriptionANDperpetualYear').val("");
	
	$('#perpetualhideid').hide(); 
	$('#subscriptionhideid').hide();
	$('#fixedhideid').hide();
	$('#subscriptionANDperpetualhideid').hide();

	
	$('#Perpetualyear').val("");
	$('#productsuitselect').val("");
	$('#Description').val("");
	$('#clientname').val("");
	$('#enccustomername').val("");
	$('#clouddeploycharges').val("");
	
	idsToDestroy.forEach(function(id) {
		  callToolTip122(id, 'destroy');
			});
	//alert("resettt")
	callToolTip122('Proposaltype', 'destroy');
// callToolTip122('Perpetualyear', 'destroy');
// callToolTip122('Subscriptionyear', 'destroy');
	callToolTip122('FirstApprovername', 'destroy');
	callToolTip122('customerType', 'destroy');
// callToolTip122('Description', 'destroy');
	callToolTip122('productsuitaddrow', 'destroy');
	callToolTip122('productnameaddrow', 'destroy');
	callToolTip122('Desciption', 'destroy');
	callToolTip122('quantitydata', 'destroy');
	callToolTip122('unitratedata', 'destroy');
// callToolTip122('totalpricedata', 'destroy');
	callToolTip122('deploysupport', 'destroy');
// callToolTip122('clouddeploycharges', 'destroy');
	callToolTip122('IntegrationCharges', 'destroy');
	callToolTip122('resoucesamount', 'destroy');
	callToolTip122('ATC', 'destroy');
// callToolTip122('totalpriceforallproduct', 'destroy');
	
	
	callToolTip122('Perpetualyear', 'destroy');
	callToolTip122('productsuitselect', 'destroy');
	callToolTip122('Description', 'destroy');
	callToolTip122('clientname', 'destroy');
	callToolTip122('enccustomername', 'destroy');
	callToolTip122('clouddeploycharges', 'destroy');
	
	

	
	
	
});
// -----reset btn

$("#resetbtn").click(function() {
	$("#company").val("");
    
   
    $("#mail").val("");
    $("#subject").val("");
   
    $("#folder").val("");
    $("#port").val("");
    $("#uname").val("");
    $("#pass").val("");

    
    callToolTip122('poinitiator', 'hide');
  
    callToolTip122('folder', 'hide');
    callToolTip122('mail', 'hide');
    callToolTip122('subject', 'hide');
  
    callToolTip122('port', 'hide');
    callToolTip122('uname', 'hide');
    callToolTip122('pass', 'hide');
    
})



var callToolTip124 = function (fieldName, status) {

	 if (fieldName == "companyup") {
	        // $("#email").tooltip('destroy');
	        var errorMessage = "<span>Please Enter Company Name<span>";

	    }
	
  
   else if (fieldName == "mailup") {
       // $("#email").tooltip('destroy');
       var errorMessage = "<span>Please Enter Mail-Server<span>";

   }
   
   else if (fieldName == "subjectup") {
       // $("#email").tooltip('destroy');
       var errorMessage = "<span>Please Enter Subject<span>";

       
   }
   
  
   else if (fieldName == "folderup") {
       // $("#email").tooltip('destroy');
       var errorMessage = "<span>Please Select Folder To Poll<span>";

   }
   
   else if (fieldName == "portup") {
       // $("#email").tooltip('destroy');
       var errorMessage = "<span>Please Select port <span>";

   }
   else if (fieldName == "unameup") {
       // $("#email").tooltip('destroy');
       var errorMessage = "<span>Please Enter User Name <span>";

   }
   else if (fieldName == "passup") {
       // $("#email").tooltip('destroy');
       var errorMessage = "<span>Please Enter Password <span>";

   }
   
$("#" + fieldName).tooltip({
       trigger: 'manual',
       at: 'center',
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



$(document).ready(function() {
    function calculateSubTotalA() {
        console.log("Calculating Sub Total A");
    }
    
 

    function calculateTotalCost() {
        console.log("Calculating Sub Total 2");
        const rows = document.querySelectorAll("#data-table tbody tr");
        let totalForAllProducts = 0;
        let totttt = 0;
        
        let secondyear = 0;
        let thirdyear = 0;
        let fourthyear = 0;
        let fifthyear = 0;
       
        rows.forEach(row => {
        	
            const quantity = parseFloat(row.cells[3].querySelector('input').value) || 0;
            const unitRate = parseFloat(row.cells[4].querySelector('input').value) || 0;
            const totalCost = quantity * unitRate;
            totttt = quantity * unitRate;
            row.cells[5].querySelector('input').value = totalCost;
            totalForAllProducts += totalCost;
           
      // });
        

       // / new
       var selectedValueperp = $("#Perpetualyear").val();
       var selectedValuesubs = $("#Subscriptionyear").val();
       var selectedValuefixed = $("#fixedyear").val();
       var selectedSubscOfsubsandPerp = $("#subscriptionANDperpetualYear").val();
       
       let totttt222  ;
       var atchalfvalue=2 ;    
 	  if ((selectedValuesubs === "3 year Subscription") || (selectedSubscOfsubsandPerp === "3 Year Price") ) 
 	  {
 		

 		totttt222 = totttt * atchalfvalue ;
 				
 		totalForAllProducts += totttt222  ;
 				
 		document.querySelector("#totalpriceforallproduct3yearsubs").value = totalForAllProducts;
 		 totalForAllProducts = totalForAllProducts
 		subtotalforalldd = totalForAllProducts ;		
 		calculateSubTotalC();
 		
 		
    	  }
   	  else
   	  {  		
   		  
	   document.querySelector("#totalpriceforallproduct").value = totalForAllProducts;
	   subtotalforalldd = totalForAllProducts ;
        calculateSubTotalC();
      }
      
      // / perpetual
     
// var secondyear =0;
// var thirdyear =0;
// var fourthyear =0;;
// var fifthyear=0; ;
         var abc = '';  
        var atc_val=''; 
        
         let totttt1111   
      if (selectedValueperp === "3 year Warranty") 
	  {
    	  abc11(selectedValueATC)
    	  
    	  
		 atc_val=selectedValueATC/100;
		 		 
// secondyear = totttt * atc_val ; //20x0.12
// thirdyear = totttt * atc_val; //20x.12

var atchalfvalue='';
 if(atc_val === 0.12)
 {
	atchalfvalue=atc_val*2;
	
}
else if(atc_val === 0.15)
{
	atchalfvalue=atc_val*2;
}
else if(atc_val === 0.18)
{
	atchalfvalue=atc_val*2;
}

	      totttt1111 =totttt *atchalfvalue;	
	    totalForAllProducts +=totttt1111
	     	    	     	    
		document.querySelector("#totalpriceforallproduct3yearperp").value = totalForAllProducts;
		 totalForAllProducts = totalForAllProducts		
		subtotalforalldd = totalForAllProducts ;
		calculateSubTotalC();
   	  }  	  
   	  else if (selectedValueperp === "5 year Warranty")
   	  {	    		 abc11(selectedValueATC)
		atc_val=selectedValueATC/100;	
		
		var atchalfvalue='';
 if(atc_val === 0.12)
 {
	atchalfvalue=atc_val*4;
	
}
else if(atc_val === 0.15)
{
	atchalfvalue=atc_val*4;
}
else if(atc_val === 0.18)
{
	atchalfvalue=atc_val*4;
}
			 	 

		 totttt1111 =totttt *atchalfvalue;
		 
		  totalForAllProducts +=totttt1111

		document.querySelector("#totalpriceforallproduct5yearperp").value = totalForAllProducts;
		subtotalforalldd = totalForAllProducts ;
		calculateSubTotalC();	
      }
   	  else
   	  {
	   document.querySelector("#totalpriceforallproduct").value = totalForAllProducts;
	    subtotalforalldd = totalForAllProducts ;
        calculateSubTotalC();
      }
                 
      // / fixed year
      if (selectedValuefixed === "3 year Warranty") 
	  {
    	  
//    	  abc11(selectedValueATC)
//	
//		 atc_val=selectedValueATC/100;
//		 
//		 
//		 var atchalfvalue='';
// if(atc_val === 0.12)
// {
//	atchalfvalue=atc_val*2;
//	
//}
//else if(atc_val === 0.15)
//{
//	atchalfvalue=atc_val*2;
//}
//else if(atc_val === 0.18)
//{
//	atchalfvalue=atc_val*2;
//}
//		 totttt1111 =totttt *atchalfvalue; 
//	    totalForAllProducts +=totttt1111
		 
// secondyear = totttt * atc_val ;
// thirdyear = totttt * atc_val;
// totalForAllProducts = secondyear +thirdyear + totttt ;
		document.querySelector("#threeyearfixed").value = totalForAllProducts;
		subtotalforalldd = totalForAllProducts ;

		calculateSubTotalC();
   	  }
   	  
   	  else if (selectedValuefixed === "5 year Warranty")
   	  { 
   		  
//   		  abc11(selectedValueATC)
//	    
//	    		
//		atc_val=selectedValueATC/100;
//		
//		var atchalfvalue='';
// if(atc_val === 0.12)
// {
//	atchalfvalue=atc_val*4;
//	
//}
//else if(atc_val === 0.15)
//{
//	atchalfvalue=atc_val*4;
//}
//else if(atc_val === 0.18)
//{
//	atchalfvalue=atc_val*4;
//}	
//		
//		 totttt1111 =totttt *atchalfvalue; 
//	    totalForAllProducts +=totttt1111	
	    
			
		// totalForAllProducts = secondyear +thirdyear + fourthyear + fifthyear
		// + totttt ;
				
		document.querySelector("#fiveyearfixed").value = totalForAllProducts;
		subtotalforalldd = totalForAllProducts ;
		calculateSubTotalC();	
      }
   	  else
   	  {
	   document.querySelector("#totalpriceforallproduct").value = totalForAllProducts;
	    subtotalforalldd = totalForAllProducts ;
        calculateSubTotalC();
      }
      
      
      // / ADDED FOR RESOURCE
      // var tottforresource ='';
      var tottforresource ='';
      var atchalfvalueResource = 18 ;
      var GstForResource = '';
    // var atc_valforResource ='';
      
      
      var  grandtotal ='';
      var selectvalueforResource = $("#Proposaltype").val();   
      if(selectvalueforResource === 'Resource')
      {	
   	atc_valforResource=atchalfvalueResource/100;	
   			  
   		 document.querySelector("#subtotalAResource").value = totalForAllProducts;
   		  	
   		 tottforresource =totalForAllProducts * 0.18; 				
   		 GstForResource +=tottforresource ;		 			  
   		 grandtotal += totalForAllProducts + tottforresource ;
   		 
   		 
   		 var formattedforGSTResource = parseFloat(GstForResource).toFixed(1); 			 		
   		document.querySelector("#gstdataforresource").value = formattedforGSTResource;
   		document.querySelector("#grandtotalforresource").value = grandtotal;			
   		subtotalforalldd = totalForAllProducts ;		
   		calculateSubTotalC();		
   		
     }   
         
    
   });  
   

      // / fixed end
    }

    $("#data-table tbody").on("input", "tr input[type='text']", calculateTotalCost);

    function calculateSubTotalB() {
// console.log("Calculating Sub Total B");
        var deploysupport = parseFloat($("#deploysupport").val()) || 0;
        var clouddeploycharges = parseFloat($("#clouddeploycharges").val()) || 0;
        var Integrationcharges1 = parseFloat($("#integrationcharge").val()) || 0;
        var subtotalB = deploysupport + clouddeploycharges + Integrationcharges1;
        $("#subtotalB").val(subtotalB);
        calculateSubTotalC();
    }

    $("#deploysupport, #clouddeploycharges,#integrationcharge").on("input", calculateSubTotalB);

    function calculateSubTotalC() {
// console.log("Calculating Sub Total C");
        
         var totalA = subtotalforalldd
      // var totalA = parseFloat($("#totalpriceforallproduct").val()) || 0;
        var totalB = parseFloat($("#subtotalB").val()) || 0;

        var totalC = totalA + totalB;
        $("#totalc").val(totalC);

        // Calculate GST at 18% of totalC
        var gst18percentage = totalC * 0.18;
        $("#total18percentage").val(gst18percentage);

        // Calculate Grand Total as the sum of totalC and GST at 18%
        var grandtotal = totalC + gst18percentage;
        $("#grandtotal").val(grandtotal);
    }

    $("#totalpriceforallproduct, #subtotalB").on("input change", calculateSubTotalC);

    // Initial calculation of Sub Total B
    calculateSubTotalB();
    // Initial calculation of Sub Total A
    calculateSubTotalA();
});



$(document).ready(function() {

    function calculateSubTotalA21() {
        console.log("Calculating Sub Total A");
    }
    
 

    function calculateTotalCost21() {
        console.log("Calculating Sub Total 2");
        const rows = document.querySelectorAll("#data-table21 tbody tr");
        let totalForAllProducts = 0;
        let totttt = 0;
        
        let secondyear = 0;
        let thirdyear = 0;
        let fourthyear = 0;
        let fifthyear = 0;
       
        rows.forEach(row => {
        	
            const quantity = parseFloat(row.cells[3].querySelector('input').value) || 0;
            const unitRate = parseFloat(row.cells[4].querySelector('input').value) || 0;
            const totalCost = quantity * unitRate;
            totttt = quantity * unitRate;
            row.cells[5].querySelector('input').value = totalCost;
            totalForAllProducts += totalCost;
           
      // });
        

       // / new
       var selectedValueperp = $("#Perpetualyear").val();
       var selectedValuesubs = $("#Subscriptionyear").val();
       var selectedValuefixed = $("#fixedyear").val();
       var selectedSubscOfsubsandPerp = $("#subscriptionANDperpetualYear").val();
       
       let totttt222  ;
       var atchalfvalue=2 ;    
 	
      
      // / perpetual
     
// var secondyear =0;
// var thirdyear =0;
// var fourthyear =0;;
// var fifthyear=0; ;
         var abc = '';  
        var atc_val=''; 
        
         let totttt1111   
      if ( selectedSubscOfsubsandPerp === "3 Year Price" ) 
	  {
    	  abc11(selectedValueATC)
    	  
    	  
		 atc_val=selectedValueATC/100;
		 		 
// secondyear = totttt * atc_val ; //20x0.12
// thirdyear = totttt * atc_val; //20x.12

var atchalfvalue='';
 if(atc_val === 0.12)
 {
	atchalfvalue=atc_val*2;
	
}
else if(atc_val === 0.15)
{
	atchalfvalue=atc_val*2;
}
else if(atc_val === 0.18)
{
	atchalfvalue=atc_val*2;
}

	      totttt1111 =totttt *atchalfvalue;	
	    totalForAllProducts +=totttt1111
	     	    	     	    
		document.querySelector("#perpetualSubs3yearperpType").value = totalForAllProducts;
		 totalForAllProducts = totalForAllProducts		
		subtotalforalldd = totalForAllProducts ;
		calculateSubTotalC21();
   	  }  	  
   	 
   	  else
   	  {
   		  
// alert(totalForAllProducts+"totalForAllProducts")
	   document.querySelector("#perpetualSubsAnnualperpType").value = totalForAllProducts;
	    subtotalforalldd21 = totalForAllProducts ;
        calculateSubTotalC21();
      }
                 
   
    
   });  
   

     
    }

    $("#data-table21 tbody").on("input", "tr input[type='text']", calculateTotalCost21);

    function calculateSubTotalB21() {
// console.log("Calculating Sub Total B");
        var deploysupport = parseFloat($("#deploysupport21").val()) || 0;
        var clouddeploycharges = parseFloat($("#clouddeploycharges21").val()) || 0;
        var Integrationcharges1 = parseFloat($("#integrationcharge21").val()) || 0;
        var subtotalB = deploysupport + clouddeploycharges + Integrationcharges1;
        $("#subtotalB21").val(subtotalB);
        calculateSubTotalC21();
    }

    $("#deploysupport21, #clouddeploycharges21,#integrationcharge21").on("input", calculateSubTotalB21);

    function calculateSubTotalC21() {
    	
// console.log("Calculating Sub Total C");
        
         var totalA = subtotalforalldd21
      // var totalA = parseFloat($("#totalpriceforallproduct").val()) || 0;
        var totalB = parseFloat($("#subtotalB21").val()) || 0;

//         alert(totalA+"totalA")
//         alert(totalB+"totalB")
        var totalC = totalA + totalB;
        $("#totalc21").val(totalC);

        // Calculate GST at 18% of totalC
        var gst18percentage = totalC * 0.18;
        $("#total18percentage21").val(gst18percentage);

        // Calculate Grand Total as the sum of totalC and GST at 18%
        var grandtotal = totalC + gst18percentage;
        $("#grandtotal21").val(grandtotal);
    }

    $("#perpetualSubsAnnualperpType, #subtotalB21").on("input change", calculateSubTotalC21);

    // Initial calculation of Sub Total B
    calculateSubTotalB21();
    // Initial calculation of Sub Total A
    calculateSubTotalA21();
    
});
	
	

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
const placeholders = ['--Select Product Suite--','--Select Security Tool --', 'Enter your Description', 'Enter Your Quantity', 'Enter Your Unit Rate', 'Total Price'];

// Create a new row
const newRow = tableBody.insertRow();

for (let i = 0; i < 6; i++) {const cell = newRow.insertCell();
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

    select.onchange = function() {
        // Store the selected value
        selectedProductSuit = select.value;
      
        
        var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        var serviceUrl = base_url + "/Master/getproductnamelist";

        $.ajax({
            url: serviceUrl,
            type: 'POST',
            dataType: 'json',
            data: { selectedSuit: selectedProductSuit }, 
        }).done(function(data) {
           
            data_product_tool = data;

            // After getting the data, update the second select element
            updateSecondSelect();
        });
    };

    cell.appendChild(select);
} else if (i === 1) {
	const select = document.createElement('select');
select.classList.add('form-control');

// Function to update the second select element
function updateSecondSelect() {
 select.innerHTML = ''; // Clear existing options

 // Create a placeholder option with empty value and a text like "Select an
	// option"
 const placeholderOption = document.createElement('option');
 placeholderOption.value = ''; // Empty value
 placeholderOption.text = '-- Select Product Tool --'; // Placeholder text
 select.appendChild(placeholderOption);

 if (data_product_tool && data_product_tool.length > 0) {
     data_product_tool.forEach(optionName => {
         const option = document.createElement('option');
         select.id = 'productnameaddrow';
         option.value = optionName;
         option.text = optionName;
         select.appendChild(option);
     });
 } else {
    
 }
}

updateSecondSelect(); // Call the function to update the second select element

cell.appendChild(select);
} else {
	
	const input = document.createElement('input');
	input.classList.add('form-control');
	input.placeholder = placeholders[i];

	if (i === 2 || i === 5) {
	    input.type = 'text';
	}

	if (i === 3 || i === 4) {
	    input.type = 'text';
	    input.oninput = function () {
	        this.value = this.value.replace(/[^0-9]/g, '');
	    };
	}

	if (i === 5) {
	    input.readOnly = true; // Make input read-only
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


// ///////// For SUBS ANd Pepretual Table
var data7;
function addRow21() {
	
// alert("ADHIU ");

    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getproductsuitlist";

$.ajax({

    url :serviceUrl,
    type : 'POST',
    dataType: 'json',
}).done(function(data) {
	
	data7=data;





const selectedProductSuit=""; 
const productString = ""+data7+"";
const productArray = productString.split(',');

const tableBody = document.querySelector("#data-table21 tbody");
const placeholders = ['--Select Product Suite--','--Select Security Tool --', 'Enter your Description', 'Enter Your Quantity', 'Enter Your Unit Rate', 'Total Price'];

// Create a new row
const newRow = tableBody.insertRow();

for (let i = 0; i < 6; i++) {const cell = newRow.insertCell();
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
        select.id = 'productsuitaddrow21';
        option.value = optionName;
        option.text = optionName;
        select.appendChild(option);
    });

    select.onchange = function() {
        // Store the selected value
        selectedProductSuit = select.value;
      
        
        var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        var serviceUrl = base_url + "/Master/getproductnamelist";

        $.ajax({
            url: serviceUrl,
            type: 'POST',
            dataType: 'json',
            data: { selectedSuit: selectedProductSuit }, 
        }).done(function(data) {
           
            data_product_tool = data;

            // After getting the data, update the second select element
            updateSecondSelect21();
        });
    };

    cell.appendChild(select);
} else if (i === 1) {
	const select = document.createElement('select');
select.classList.add('form-control');

// Function to update the second select element
function updateSecondSelect21() {
 select.innerHTML = ''; // Clear existing options

 // Create a placeholder option with empty value and a text like "Select an
	// option"
 const placeholderOption = document.createElement('option');
 placeholderOption.value = ''; // Empty value
 placeholderOption.text = '-- Select Product Tool --'; // Placeholder text
 select.appendChild(placeholderOption);

 if (data_product_tool && data_product_tool.length > 0) {
     data_product_tool.forEach(optionName => {
         const option = document.createElement('option');
         select.id = 'productnameaddrow21';
         option.value = optionName;
         option.text = optionName;
         select.appendChild(option);
     });
 } else {
    
 }
}

updateSecondSelect21(); // Call the function to update the second select element

cell.appendChild(select);
} else {
	
	const input = document.createElement('input');
	input.classList.add('form-control');
	input.placeholder = placeholders[i];

	if (i === 2 || i === 5) {
	    input.type = 'text';
	}

	if (i === 3 || i === 4) {
	    input.type = 'text';
	    input.oninput = function () {
	        this.value = this.value.replace(/[^0-9]/g, '');
	    };
	}

	if (i === 5) {
	    input.readOnly = true; // Make input read-only
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

// ///////////////// END SUBS AND PERPETUAL TABLE


// last one end

  function deleteRow(button) {
     const row = button.closest('tr');
      row.remove();
  }

        // Function to calculate and update the total price
        function updateTotalPrice(row) {
            const quantity = parseFloat($('#quantitydata', row).val()) || 0;
            const unitRate = parseFloat($('#unitratedata', row).val()) || 0;
            const total = quantity * unitRate;
            $('#totalpricedata', row).val(total);
        }
        // Attach event listeners to the default row when the page loads
       // attachEventListeners($('#data-table tbody tr:first'));



function deleteRow(btn)
{
	    const row = btn.parentNode.parentNode;
	    row.parentNode.removeChild(row);
}





function submitData() {
	
 if (!validateUpdatedetails()) {
		 
 event.preventDefault();
    	
 } else {
	
// alert("zsjhcb");
	var selectvalue = $("#Proposaltype").val();	

	var selectvalue21 = $("#Proposaltype").val();	
	
	
	  var array1=[];
	  var array2=[];

	  
	if(selectvalue === "AMC")
	{
		
        array1 = 'NA';
        array2 = 'NA';
		
		SaveVeloxProposal(JSON.stringify(array1),JSON.stringify(array2))
		
	}
	else if (selectvalue === "Fixed" || selectvalue === "Subscription" || selectvalue === "Perpetual" || selectvalue === "Resource"
		|| selectvalue === "Subscription & Perpetual")
	{
	
    const tableBody = document.querySelector("#data-table tbody");
    const rows = tableBody.querySelectorAll('tr');
     
     
    for (const row of rows) {
        const inputs = row.querySelectorAll('input');
            const select = row.querySelector('#productsuitaddrow'); 
            const select1 = row.querySelector('#productnameaddrow');
 
        for (const input of inputs) {
            if (input.value.trim() === '') {
              
                return; 
            }
        }

        const   dataObj = {
	    prodsuit :select.value, // i added this
       prodname: select1.value, 
        descp: inputs[0].value,
        qty: inputs[1].value,
        urate: inputs[2].value,
        toprice: inputs[3].value,
        };

//        const csvString = Object.values(dataObj).join(',');
        const csvString = Object.values(dataObj).join('~');
       
        array1.push(dataObj);  
        
        
     
      
    }
   
    
    if (selectvalue21 === "Subscription & Perpetual" )
	{
	
    const tableBody = document.querySelector("#data-table21 tbody");
    const rows = tableBody.querySelectorAll('tr');
     
   
    
     
    for (const row of rows) {
        const inputs = row.querySelectorAll('input');
            const select = row.querySelector('#productsuitaddrow21'); 
            const select1 = row.querySelector('#productnameaddrow21');
 
        for (const input of inputs) {
            if (input.value.trim() === '') {
              
                return; 
            }
        }

        const   dataObj = {
	    prodsuit :select.value, // i added this
       prodname: select1.value, 
        descp: inputs[0].value,
        qty: inputs[1].value,
        urate: inputs[2].value,
        toprice: inputs[3].value,
        };

      //  const csvString = Object.values(dataObj).join(',');
        
        const csvString = Object.values(dataObj).join('~');
      
        array2.push(dataObj);   
        
      //  alert("array2  :"+ array2.push(dataObj))
//        alert("dddd :"+JSON.strinigify(dataObj));
      
    }
    	
    }else{
    	

	 array2 = 'NA';
	 

    }
    
   
    
 
    
// }
   SaveVeloxProposal(JSON.stringify(array1),JSON.stringify(array2));
}
} 

}



function SaveVeloxProposal(veloxdata,veloxdata1) {   
	
	
	
	$('#spin2').show();
// var spinner = document.getElementById("spin2");
//  
// spinner.style.display = "none";
	
// alert("inside save veloxdata :"+veloxdata);
	
// alert("inside save veloxdata :"+veloxdata1);
	
	
	var finalCustomer = "";
	if($('#customerType').val() === 'Not Registered'){
		finalCustomer = $('#newcustomername').val();
		
		$("#clientname").val(finalCustomer);
	} else {
		finalCustomer = $("#clientname").val();
	}
	
//	alert("cl "+finalCustomer);
	
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/veloxproposaldetails";
 										 

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'veloxdata=' +encodeURIComponent(veloxdata)	
             +'&poinitiator=' + encodeURIComponent($("#poinitiator").val())
             +'&poinitiatorno=' + encodeURIComponent($("#poinitiatorno").val())
             +'&FirstApprovername=' + encodeURIComponent($("#FirstApprovername").val())
             +'&firstapprovercontact=' + encodeURIComponent($("#firstapprovercontact").val())
             +'&secondApprovername=' + encodeURIComponent($("#secondApprovername").val())
             +'&secondapprovercontact=' + encodeURIComponent($("#secondapprovercontact").val()) 
//             +'&clientname=' + encodeURIComponent($("#clientname").val())
             +'&clientname=' + encodeURIComponent(finalCustomer)
             +'&Description=' + encodeURIComponent($("#Description").val())
             +'&deploysupport=' + encodeURIComponent($("#deploysupport").val())
             +'&clouddeploycharges=' + encodeURIComponent($("#clouddeploycharges").val()) 
                  
             +'&totalpriceforallproduct=' +  subtotalforalldd 
                 
             
             
// +'&totalpriceforallproduct=' +
// encodeURIComponent($("#totalpriceforallproduct").val())
              +'&subtotalB=' + encodeURIComponent($("#subtotalB").val())
              +'&subtotalAB=' + encodeURIComponent($("#totalc").val())
              +'&resoucesamount=' + encodeURIComponent($("#resoucesamount").val())
              +'&ATC=' + encodeURIComponent($("#ATC").val())
              +'&Proposaltype=' + encodeURIComponent($("#Proposaltype").val())
             +'&Perpetualyear=' + encodeURIComponent($("#Perpetualyear").val())
             +'&Subscriptionyear=' + encodeURIComponent($("#Subscriptionyear").val())
             +'&Amcsecondyear=' + encodeURIComponent($("#Amcsecondyear").val())
             +'&Amcthirdyear=' + encodeURIComponent($("#Amcthirdyear").val())
             +'&Amcfourthyear=' + encodeURIComponent($("#Amcfourthyear").val())
             +'&Amcfiveyear=' + encodeURIComponent($("#Amcfiveyear").val())
             +'&secondyearsubscription=' + encodeURIComponent($("#secondyearsubscription").val())
             +'&thirdyearsubscription=' + encodeURIComponent($("#thirdyearsubscription").val())
                         
              +'&IntegrationCharges=' + encodeURIComponent($("#IntegrationCharges").val())
              +'&integrationcharge=' + encodeURIComponent($("#integrationcharge").val())
              +'&totalc=' + encodeURIComponent($("#totalc").val())
              +'&total18percentage=' + encodeURIComponent($("#total18percentage").val())
              +'&grandtotal=' + encodeURIComponent($("#grandtotal").val())
              +'&productsuitselect=' + encodeURIComponent($("#productsuitselect").val())
              +'&Scanplusprodversion=' + encodeURIComponent($("#Scanplusprodversion").val())
              +'&fixedyear=' + encodeURIComponent($("#fixedyear").val())
              +'&enccustomername=' + encodeURIComponent($("#enccustomername").val())
                
// amc new data added

                +'&amcstartdate=' + encodeURIComponent($("#amcstartdate").val())
                +'&AMCmonthyear=' + encodeURIComponent($("#AMCmonthyear").val())
                +'&AMCMonth=' + encodeURIComponent($("#AMCMonth").val())
                +'&AMCYear=' + encodeURIComponent($("#AMCYear").val())
                +'&amcenddate=' + encodeURIComponent($("#amcenddate").val()) 
                +'&productsuitdetails=' + encodeURIComponent($("#productsuitdetails").val())
                +'&securitysolutiondetails=' + encodeURIComponent($("#securitysolutiondetails").val())
                +'&descforamc=' + encodeURIComponent($("#descforamc").val())
                +'&totalcostAMC=' + encodeURIComponent($("#totalcostAMC").val())
                +'&GRANDTOTALFORAMC=' + encodeURIComponent($("#GRANDTOTALFORAMC").val())
                +'&gstforamc=' + encodeURIComponent($("#gstforamc").val()) 
                
                
                
                  // Resource new data added
                 +'&subtotalAResource=' + encodeURIComponent($("#subtotalAResource").val()) 
                +'&gstdataforresource=' + encodeURIComponent($("#gstdataforresource").val()) 
                +'&grandtotalforresource=' + encodeURIComponent($("#grandtotalforresource").val())
                
                 +'&contactperson=' + encodeURIComponent($("#contactperson").val())
                
                // subs&perp Table
                 
                 +'&veloxdata1=' + veloxdata1
                 +'&subscriptionANDperpetualYear=' + encodeURIComponent($("#subscriptionANDperpetualYear").val())
                 +'&perpetualSubsAnnualperpType=' + encodeURIComponent($("#perpetualSubsAnnualperpType").val()) 
                 +'&perpetualSubs3yearperpType=' + encodeURIComponent($("#perpetualSubs3yearperpType").val()) 
                 +'&deploysupport21=' + encodeURIComponent($("#deploysupport21").val())
                +'&clouddeploycharges21=' + encodeURIComponent($("#clouddeploycharges21").val())
                    +'&IntegrationCharges21=' + encodeURIComponent($("#IntegrationCharges21").val())
                 +'&integrationcharge21=' + encodeURIComponent($("#integrationcharge21").val())
                 
                  +'&subtotalB21=' + encodeURIComponent($("#subtotalB21").val())
                   +'&totalc21=' + encodeURIComponent($("#totalc21").val())
                    +'&total18percentage21=' + encodeURIComponent($("#total18percentage21").val())
                     +'&grandtotal21=' + encodeURIComponent($("#grandtotal21").val())
                      +'&resoucesamount21=' + encodeURIComponent($("#resoucesamount21").val())
                      +'&poreferenceno=' + encodeURIComponent($("#poreferenceno").val())
                       +'&proposalFor=' + encodeURIComponent($("#proposalFor").val())
                       +'&partnerName=' + encodeURIComponent($("#PartnerName").val()),
                 
        }).done(function(data) {
          
        	$('#spin2').hide();
// if (data == "success") {
                swal({
                    title: "Successfull!",
                   // text: "Record Added Successfully",
                    html: "Proposal ID = " + data + "<br><br>  Proposal Sent Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/User/VeloxProposal";
                    }

                });
        });   
}


function proposalbaseddatashowedperp()
{
	var selectedValue = $("#Perpetualyear").val();
	
	 if (selectedValue === "1 year Warranty") 
	 {
		$("#subtotalahideid").show();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid3yearsubs").hide();
		
		
		 $("#atchideidupper").show(); 
         $("#atchideid").hide(); 
	 }
	 else if(selectedValue === "3 year Warranty")
	{
		$("#subtotalahideid3yearperp").show();
		$("#subtotalahideid5yearperp").hide();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearsubs").hide();
		
		 $("#atchideidupper").show(); 
         $("#atchideid").hide(); 	
	}
	else if(selectedValue === "5 year Warranty")
	{
		$("#subtotalahideid5yearperp").show();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid").hide();	
		$("#subtotalahideid3yearsubs").hide();
		
		 $("#atchideidupper").show(); 
         $("#atchideid").hide(); 
	}
}


function proposalbaseddatashowedsubs()
{
	var selectedValue = $("#Subscriptionyear").val();
	 if (selectedValue === "Annual Price") 
	 {
		$("#subtotalahideid").show();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		
		 $("#atchideidupper").hide(); 
         $("#atchideid").show(); 	
	 }
	 else if(selectedValue === "3 year Subscription")
	{
		$("#subtotalahideid3yearsubs").show();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();
		
		 $("#atchideidupper").hide(); 
         $("#atchideid").show(); 	
	}	
}


function proposalbaseddatashowedfixedyear()
{
	
	var selectedValue = $("#fixedyear").val();
	 if (selectedValue === "3 year Warranty") 
	 {
		$("#subtotalahideid3yearfixedd").show();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		 $("#atchideidupper").show(); 
         $("#atchideid").hide(); 		
	 }
	 else if(selectedValue === "5 year Warranty")
	{
		$("#subtotalahideid5yearfixed1").show();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		 $("#atchideidupper").show(); 
         $("#atchideid").hide(); 	
	}
	else
	{
		$("#subtotalahideid5yearfixed1").hide();
	    $("#subtotalahideid3yearfixedd").hide();
	    
	     $("#atchideidupper").show(); 
         $("#atchideid").hide(); 	
		
	}	
}
function proposalbaseddatashowedsubsANDperp()
{
	
	var selectedValue = $("#subscriptionANDperpetualYear").val();
	
	$("#subsANDPerpTbaleHeader").show();
	
	$("#perpetualSubsAnnualPerpHideDiv").hide();
	$("#perpetualSubs3yearPerpHideDiv").hide();
	
	 if (selectedValue === "Annual Price") 
	 {
		$("#subtotalahideid3yearfixedd").hide();
		$("#subtotalahideid").show();
		$("#perpetualSubsAnnualPerpHideDiv").show();
		$("#subtotalahideid3yearsubs").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
	
		 $("#atchideidupper").show(); 
         $("#atchideid").hide(); 		
	 }
	 else if(selectedValue === "3 Year Price")
	{
		$("#subtotalahideid5yearfixed1").hide();
		$("#subtotalahideid3yearsubs").show();
		$("#perpetualSubs3yearPerpHideDiv").show();
		$("#subtotalahideid").hide();
		$("#subtotalahideid3yearperp").hide();
		$("#subtotalahideid5yearperp").hide();	
		
		 $("#atchideidupper").show(); 
         $("#atchideid").hide(); 	
	}
	else
	{
		$("#subtotalahideid5yearfixed1").hide();
	    $("#subtotalahideid3yearfixedd").hide();
		$("#perpetualSubsAnnualperpType").hide();	
		$("#perpetualSubs3yearperpType").hide();	
	     $("#atchideidupper").hide(); 
         $("#atchideid").hide(); 	
		
	}	
}


function proposaltypedata()
{
	var selectedValue = $("#Proposaltype").val();
	
	
	var selectedperpetual = $("#Perpetualyear").val();
	var selectedSubscription = $("#Subscriptionyear").val();
	
	$("#subsANDPerpTbaleHeader").hide();
	$("#addRowProductPerpSubsHideDiv").hide();
	$("#perpetualSubsAnnualPerpHideDiv").hide();
	$("#perpetualSubs3yearPerpHideDiv").hide();
	$("#chargesForPerpetualType").hide();
	$("#subscriptionANDperpetualhideid").hide();
	
	$("#endCustomernameDiv").show();
		  
            if (selectedValue === "Perpetual") {
                $("#perpetualhideid").show();
                $("#subscriptionhideid").hide();
                $("#fixedhideid").hide();
                
                $("#AMCSTARTENDHIDEID").hide();
                $("#productsuitandtoolhideid").hide();
               
                
                $("#addrowhideidforamc").show();
                $("#chargesforAllPropType").show();
                
                $("#subtotalahideidforResource").hide();
                
                $("#subtotalahideid3yearsubs").hide();
                $("#subtotalahideid3yearperp").hide();
                $("#subtotalahideid5yearperp").hide();
                $("#subtotalahideid3yearfixedd").hide();
                $("#subtotalahideid5yearfixed1").hide();
                $("#poreferenceidhide").hide();
                
            } else if (selectedValue === "Subscription") { 
                $("#subscriptionhideid").show();
                 $("#perpetualhideid").hide();
                 $("#fixedhideid").hide();
                 
                 $("#AMCSTARTENDHIDEID").hide();
                 $("#productsuitandtoolhideid").hide();
                
                 
                 $("#addrowhideidforamc").show();
                 $("#chargesforAllPropType").show();
                 $("#subtotalahideidforResource").hide();

                 $("#subtotalahideid3yearsubs").hide();
	                $("#subtotalahideid3yearperp").hide();
	                $("#subtotalahideid5yearperp").hide();
	                $("#subtotalahideid3yearfixedd").hide();
	                $("#subtotalahideid5yearfixed1").hide();
	                $("#poreferenceidhide").hide();
          } else if (selectedValue === "Fixed") { 
              $("#subscriptionhideid").hide();
              $("#perpetualhideid").hide();
              $("#fixedhideid").show();
        
              $("#AMCSTARTENDHIDEID").hide();
              $("#productsuitandtoolhideid").hide();
             
              
              $("#addrowhideidforamc").show();
              $("#chargesforAllPropType").show();
             
              $("#subtotalahideidforResource").hide();
         
        
              $("#subtotalahideid3yearsubs").hide();
              $("#subtotalahideid3yearperp").hide();
              $("#subtotalahideid5yearperp").hide();
              $("#subtotalahideid3yearfixedd").hide();
              $("#subtotalahideid5yearfixed1").hide();
              $("#poreferenceidhide").hide();
        } else if (selectedValue === "AMC") 
        { 
	
        	 $("#endCustomernameDiv").hide();

	          $("#productsuitandtoolhideid").show();
	               
	          $("#AMCSTARTENDHIDEID").show();
	          $("#poreferenceidhide").show();
              $("#subscriptionhideid").hide();
              $("#perpetualhideid").hide();
              $("#fixedhideid").hide();
              
             
             $("#addrowhideidforamc").hide();
             $("#chargesforAllPropType").hide();
             
             
             $("#subtotalahideidforResource").hide();
             
             $("#subtotalahideid3yearsubs").hide();
             $("#subtotalahideid3yearperp").hide();
             $("#subtotalahideid5yearperp").hide();
             $("#subtotalahideid3yearfixedd").hide();
             $("#subtotalahideid5yearfixed1").hide();
        }else if (selectedValue === "Resource") 
        {   	   		         	
	          $("#addrowhideidforamc").show(); 
	          	  	           
	           $("#subtotalahideidforResource").show(); 
	           	          
	          
// $("#addRowButton").hide();
	          $("#productsuitandtoolhideid").hide();      
	          $("#AMCSTARTENDHIDEID").hide();
            $("#subscriptionhideid").hide();
            $("#perpetualhideid").hide();
            $("#fixedhideid").hide();
           $("#chargesforAllPropType").hide();
           
            $("#subtotalahideid3yearsubs").hide();
            $("#subtotalahideid3yearperp").hide();
            $("#subtotalahideid5yearperp").hide();
            $("#subtotalahideid3yearfixedd").hide();
            $("#subtotalahideid5yearfixed1").hide();   
            
            $("#subtotalahideid").hide();
             
            $("#subtotalahideid3yearsubs").hide();
            $("#subtotalahideid3yearperp").hide();
            $("#subtotalahideid5yearperp").hide();
            $("#subtotalahideid3yearfixedd").hide();
            $("#subtotalahideid5yearfixed1").hide();
            $("#poreferenceidhide").hide();
       }else if (selectedValue === "Subscription & Perpetual") 
       { 
    	   
// alert("dgjb");
    	   $("#subscriptionANDperpetualhideid").show();
    	   $("#addrowhideidforamc").show();
           $("#chargesforAllPropType").show();
           $("#chargesForPerpetualType").show();
           $("#addRowProductPerpSubsHideDiv").show();
           
           $("#subscriptionhideid").hide();
           $("#perpetualhideid").hide();
           $("#fixedhideid").hide();
           $("#AMCSTARTENDHIDEID").hide();
           $("#productsuitandtoolhideid").hide();
           $("#addrowhideidforamc").show();
           $("#chargesforAllPropType").show();
           $("#subtotalahideidforResource").hide();
           $("#subtotalahideid3yearsubs").hide();
              $("#subtotalahideid3yearperp").hide();
              $("#subtotalahideid5yearperp").hide();
              $("#subtotalahideid3yearfixedd").hide();
              $("#subtotalahideid5yearfixed1").hide();
              $("#poreferenceidhide").hide();
    }
        
        else{
    	   
    	   $("#subscriptionhideid").hide();
           $("#perpetualhideid").hide();
           $("#fixedhideid").hide();
           $("#AMCSTARTENDHIDEID").hide();
           $("#poreferenceidhide").hide();
           
       }
       
       
      
        	callToolTip122('Perpetualyear', 'destroy');
        	callToolTip122('Subscriptionyear', 'destroy');
        	callToolTip122('subscriptionANDperpetualYear', 'destroy');
        	callToolTip122('fixedyear', 'destroy');
        	callToolTip122('Perpetualyear', 'destroy');
        	callToolTip122('Subscriptionyear', 'destroy');
        	
		
}


function integrationcharge()
{
	
	var selectedValue = $("#IntegrationCharges").val();
	
	var selectedValue21 = $("#IntegrationCharges21").val();
	
	
	if(selectedValue === 'Yes')
	{
	$("#integrationhideid").show();	
	}
	else if(selectedValue === 'No')
	{
	$("#integrationhideid").hide();
    }
    else
    {
	$("#integrationhideid").hide();
	
    }
	
	
 if(selectedValue21 === 'Yes')
	{
	$("#integrationhideid21").show();
    }
	else if(selectedValue21 === 'No')
	{
	$("#integrationhideid21").hide();
    } else
    {
    	
    	$("#integrationhideid21").hide();
        }
}
function getCustomerType()
{
	var customerType = $('#customerType').val();
	
	if(customerType === 'Registered'){
		$("#registeredCustomerdiv").show();
		$("#notregisteredCustomerdiv1").hide();
//		$("#notregisteredCustomerdiv2").hide();
//		$("#notregisteredCustomerdiv3").hide();
		$("#addCustomerDataDiv").hide();
	}else if(customerType === 'Not Registered'){
		$("#registeredCustomerdiv").hide();
		$("#notregisteredCustomerdiv1").show();
//		$("#notregisteredCustomerdiv2").show();
//		$("#notregisteredCustomerdiv3").show();
		$("#addCustomerDataDiv").show();
		
	}else {
		$("#notregisteredCustomerdiv1").hide();
//		$("#notregisteredCustomerdiv2").hide();
//		$("#notregisteredCustomerdiv3").hide();
		$("#registeredCustomerdiv").hide();
		$("#addCustomerDataDiv").hide();
	}
	
}

function customerData() {
//	 if (!validatecustomerData() || !validateUpdatedetails()) {
	 if (!validatecustomerData() ) {
	    	event.preventDefault();
	    } else {
	    	
	       	var l = window.location;
	     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	     	var serviceUrl = base_url + "/Master/newCustomerDetails";
	     	
	    	
	    	 var serviceUrl = serviceUrl;
	         $.ajax({
	             type: 'POST',
	             url: serviceUrl,
	             data: 'compname=' +encodeURIComponent($("#newcustomername").val())	
	              +'&address=' + encodeURIComponent($("#newAddress").val())
	              +'&city=' + encodeURIComponent($("#newcity").val())
	              +'&district=' + encodeURIComponent($("#newdistrict").val())
	              +'&pincode=' + encodeURIComponent($("#newpin").val())
	              +'&office_mailid=' + encodeURIComponent($("#office_mailid").val()),
	                    
	             
	         }).done(function(data) {
	        	 getClientNames();
	        	 
	             if (data == "success") {
	                 swal({
	                     title: "Successfull!",
	                     text: "Record Added Successfully",
	                     type: "success",
	                     width: 300,
	                     height: 200,
	                     buttons: false,
	                     allowOutsideClick: false,
//	                     preConfirm: function() {
//	                         var l = window.location;
//	                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	                         window.location.href = base_url + "/User/VeloxProposal";
	                    	 
//	                     }


	                 });

	             }
	             else if (data == "duplicate") {
	                 swal({
	                     title: "Duplicate Data!",
	                     text: "Record Already Exists",
	                     type: "warning",
	                     width: 300,
	                     height: 200,
	                     buttons: false,
	                     allowOutsideClick: false,
//	                     preConfirm: function() {
//	                         var l = window.location;
//	                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	                         window.location.href = base_url + "/User/VeloxProposal";
//	                     }


	                 })

	             }
	             else if (data == "error") {
	                 swal({
	                     title: "Unsuccessful!",
	                     text: "Fail to add data",
	                     type: "success",
	                     width: 300,
	                     height: 200,

	                     buttons: false,
	                     allowOutsideClick: false,
//	                     preConfirm: function() {
//	                         var l = window.location;
//	                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	                         window.location.href = base_url + "/User/VeloxProposal";
//	                     }
	                     

	                 });

	               }
	             
	         	$("#notregisteredCustomerdiv1").hide();
//	        	$("#notregisteredCustomerdiv2").hide();
//	        	$("#notregisteredCustomerdiv3").hide();
	        	$("#registeredCustomerdiv").hide();
	        	$("#addCustomerDataDiv").hide();
	        	$("#customerType").val("");
	        	$("#newcustomername").val("");
	        	$("#newAddress").val("");
	        	$("#newdistrict").val("");
	        	$("#newcity").val("");
	        	$("#newpin").val("");
	        	$("#office_mailid").val("");
	        	
	         });   
	 	    
	    }
	
}

$("#reset-Customer-btn").click(function() {

    $('#newcustomername').val("");
	$('#newAddress').val("");
	$('#newdistrict').val("");
	$('#newcity').val("");
    $("#newpin").val("");
    $("#office_mailid").val("");


callToolTip122('newcustomername', 'destroy'); 
callToolTip122('newAddress', 'destroy');
callToolTip122('newdistrict', 'destroy');
callToolTip122('newcity', 'destroy');
callToolTip122('newpin', 'destroy');
callToolTip122('office_mailid', 'destroy');
	
		
});


function validatecustomerData(){

	var indexError = 0;

	if ($('#newcustomername').val().trim() === '') {
		callToolTip122('newcustomername', 'show');
	if (indexError == 0) {

	}
	indexError = indexError + 1;
	} else {

	indexError = 0;
	}

	if ($('#newAddress').val().trim() === '') {
		callToolTip122('newAddress', 'show');
	if (indexError == 0) {

	}
	indexError = indexError + 1;
	} else {

	indexError = 0;
	}

	if ($('#newdistrict').val().trim() === '') {
		callToolTip122('newdistrict', 'show');
	if (indexError == 0) {

	}
	indexError = indexError + 1;
	} else {

	indexError = 0;
	}

	if ($('#newcity').val().trim() === '') {
		callToolTip122('newcity', 'show');
	if (indexError == 0) {

	}
	indexError = indexError + 1;
	} else {

	indexError = 0;
	}



	if ($('#newpin').val().trim() === '') {
		callToolTip122('newpin', 'show');
	if (indexError == 0) {

	}
	indexError = indexError + 1;
	} else {

	indexError = 0;
	}


	if ($('#office_mailid').val().trim() === '') {
		callToolTip122('office_mailid', 'show');
	if (indexError == 0) {

	}
	indexError = indexError + 1;
	} else {

	indexError = 0;
	}



	if (indexError > 0) {
	return false;
	} else {
	return true;
	}
		
		
}

function getCheckerNo(){
	
	var checkerApprovername  = $('#FirstApprovername').val();
	
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/UserActivity/getCheckerContactNo";
		
		  $.ajax({

		      url :serviceUrl,
		      type : 'POST',
		      dataType: 'json',
		      data:'checkerApprovername='+checkerApprovername,
		  }).done(function(data) {
			
			// alert(data);
// alert( data[0]["PHONE"] );
			  
             $('#firstapprovercontact').val(data[0]["PHONE"]);

		  });
		  
}


function validateEmailOffice(){
	// alert("HIH")
    // Get the value from the input field
    var email = document.getElementById("office_mailid").value;
    
    // Regular expression pattern for a valid email address
    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,}$/;

    // Check if the email matches the pattern
// if (emailPattern.test(email)) {
// document.getElementById("emailErrorOfficegreen").textContent = "Valid
// Format"; // Clear any previous error message
// $('#emailErrorOfficered').hide();
// $('#emailErrorOfficegreen').show();
// } else {
// document.getElementById("emailErrorOfficered").textContent = "Invalid
// Format";
// $('#emailErrorOfficegreen').hide();
// $('#emailErrorOfficered').show();
// }
}



function validatetepin(){
	// alert("HIH")
    // Get the value from the input field
    var pincode = document.getElementById("newpin").value;
    
    // Regular expression pattern for a valid email address
    var pincodePattern = /^\d{6}$/;

    // Check if the email matches the pattern
// if (pincodePattern.test(pincode)) {
// document.getElementById("pincodegreen").textContent = "Valid Format"; //
// Clear any previous error message
// $('#pincodered').hide();
// $('#pincodegreen').show();
// } else {
// document.getElementById("pincodered").textContent = "Invalid Format";
// $('#pincodegreen').hide();
// $('#pincodered').show();
// }
}
//function productsuit()
//{	
//	var selectedValue = $("#productsuitselect").val();		
//	if(selectedValue === 'ScanPlus')
//	{
//	 $("#hideScanplus").show();	
//	  $("#hideSecureIT").hide();
//	}
//	else if(selectedValue === 'SecureIT')
//	{
//	 $("#hideSecureIT").show();
//	  $("#hideScanplus").hide();	 	
//	}
//	else
//	{
//	 $("#hideScanplus").hide();
//	 $("#hideSecureIT").hide();	
//	}
//}



function productsuit() {
    var selectedValue = $("#productsuitselect").val();
    // Hide all first
    $("#hideScanplus").hide();
    $("#hideSecureIT").hide();
    $("#hideAssetGrid").hide();
    $("#hidePlanetGuard").hide();

    // Show the selected one
    if (selectedValue === 'ScanPlus') {
        $("#hideScanplus").show();
    } else if (selectedValue === 'SecureIT') {   
        $("#hideSecureIT").show();
    } else if (selectedValue === 'AssetGrid') {
        $("#hideAssetGrid").show();
    } else if (selectedValue === 'PlanetGuard') {
        $("#hidePlanetGuard").show();
    }
}


function sectools() 
 {

        var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getprodsuit";
		
		
		$.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
// ASYNC : FALSE,
	  }).done(function(data) {
		console.log(data)
		
		    var html =" <select class='form-control' tabindex='9' id='productsuitdetails' name='productsuitdetails'   >";
	    
	      html=html+'<option value="">--Please Select Product Suit--</option>';
	     
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
	      document.getElementById("productsuitdetails").innerHTML=html;
		
		 });
		 }



		
function securitydetailforamc()
{	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuitdetails").val())
	}).done(function(data2Array) {
	    var html = "<option value=''> -- Please Select --</option>";
	    for (var i = 0; i < data2Array.length; i++) {
	        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
	    }
	    document.getElementById("securitysolutiondetails").innerHTML = html;
	});
	
}



function AMCMonthYearType(){
	
	var AMCmonthyear =  $('#AMCmonthyear').val();
	
	$('#AMCMonth').val('');
	$('#AMCend').val('');
	$('#amcenddate').val('');
	
	if(AMCmonthyear === 'Month'){
		 $("#AMCMonthDiv").show();
	     $("#AMCYearDiv").hide();
		 
	}else if(AMCmonthyear === 'Year'){
		 $("#AMCMonthDiv").hide();
		 $("#AMCYearDiv").show();
	}else {
		 $("#AMCMonthDiv").hide();
		 $("#AMCYearDiv").hide();
		
	}
	
}



function AMCendmonth(){
	
	var amcstartdate =  $('#amcstartdate').val();
	var AMCMonth =  $('#AMCMonth').val();

	const dateFormat = "DD-MM-YYYY";
	const inputDate = moment(amcstartdate, dateFormat);
	
	   inputDate.add(AMCMonth, 'months');
	   
		 // Subtract one day from the result date
	    inputDate.subtract(1, 'days');
	    
	  
	    // Format the result date back to "DD-MM-YYYY" format
	    const resultDateStr = inputDate.format(dateFormat);
	    
	   // //alert(resultDateStr);
	    $('#amcenddate').val(resultDateStr);
	    
}

function AMCendYear(){
	
	var amcstartdate =  $('#amcstartdate').val();
	var AMCYear =  $('#AMCYear').val();

	const dateFormat = "DD-MM-YYYY";
	const inputDate = moment(amcstartdate, dateFormat);
	
	   inputDate.add(AMCYear, 'years');
	   
		 // Subtract one day from the result date
	    inputDate.subtract(1, 'days');

	    // Format the result date back to "DD-MM-YYYY" format
	    const resultDateStr = inputDate.format(dateFormat);
	    
// alert(resultDateStr);
	    $('#amcenddate').val(resultDateStr);
	    
	   
}



function validateUpdatedetails() {
//	 alert("hIHI "+$('#Proposaltype').val() )
	
	if($('#Proposaltype').val()==="AMC") {
		var indexError = 0;

		if ($('#FirstApprovername').val() === '') {
			callToolTip122('FirstApprovername', 'show');
			indexError = indexError + 1;
		}
		if ($('#customerType').val() === '') {
			callToolTip122('customerType', 'show');
			indexError = indexError + 1;
		}
		if ($('#productsuitselect').val() === '') {
			callToolTip122('productsuitselect', 'show');
			indexError = indexError + 1;
		}
		if ($('#clientname').val() === ''  && $('#customerType').val() === 'Registered') {
			callToolTip122('clientname', 'show');
			indexError = indexError + 1;
		}
		if ($('#amcstartdate').val() === '') {
			callToolTip122('amcstartdate', 'show');
			indexError = indexError + 1;
		}
		if ($('#AMCmonthyear').val() === '') {
			callToolTip122('AMCmonthyear', 'show');
			indexError = indexError + 1;
		}
		if ($('#AMCMonth').val() === '' && $('#AMCmonthyear').val()=='Month') {
			callToolTip122('AMCMonth', 'show');
			indexError = indexError + 1;
		}
		if ($('#AMCYear').val() === ''&& $('#AMCmonthyear').val()=='Year') {
			callToolTip122('AMCYear', 'show');
			indexError = indexError + 1;
		}
		
		
		if ($('#productsuitdetails').val() === '') {
			callToolTip122('productsuitdetails', 'show');
			indexError = indexError + 1;
		}
		if ($('#securitysolutiondetails').val() === '') {
			callToolTip122('securitysolutiondetails', 'show');
			indexError = indexError + 1;
		}
		if ($('#descforamc').val() === '') {
			callToolTip122('descforamc', 'show');
			indexError = indexError + 1;
		}
		if ($('#totalcostAMC').val() === '') {
			callToolTip122('totalcostAMC', 'show');
			indexError = indexError + 1;
		}

		if (indexError > 0) {
			return false;
		} else {
			// $('#spinner2').show();
			return true;
		}
		
	} else if($('#Proposaltype').val()==="Perpetual" || $('#Proposaltype').val()==="Subscription"
		|| $('#Proposaltype').val()==="Fixed" || $('#Proposaltype').val()==="Subscription & Perpetual" )  {
		var indexError = 0;

		if ($('#FirstApprovername').val() === '') {
			callToolTip122('FirstApprovername', 'show');
			indexError = indexError + 1;
		}
		if ($('#customerType').val() === '') {
			callToolTip122('customerType', 'show');
			indexError = indexError + 1;
		}
		if ($('#productsuitselect').val() === '') {
			callToolTip122('productsuitselect', 'show');
			indexError = indexError + 1;
		}
		if ($('#clientname').val() === '' && $('#customerType').val() === 'Registered') {
			callToolTip122('clientname', 'show');
			indexError = indexError + 1;
		}
		if ($('#productsuitaddrow').val() === '') {
			callToolTip122('productsuitaddrow', 'show');
			indexError = indexError + 1;
		}
		if ($('#productnameaddrow').val() === '') {
			callToolTip122('productnameaddrow', 'show');
			indexError = indexError + 1;
		}
		if ($('#Desciption').val() === '') {
			callToolTip122('Desciption', 'show');
			indexError = indexError + 1;
		}
		if ($('#quantitydata').val() === '') {
			callToolTip122('quantitydata', 'show');
			indexError = indexError + 1;
		}
		if ($('#unitratedata').val() === '') {
			callToolTip122('unitratedata', 'show');
			indexError = indexError + 1;
		}
		
		if ($('#deploysupport').val() === '') {
			callToolTip122('deploysupport', 'show');
			indexError = indexError + 1;
		}
//		if ($('#clouddeploycharges').val() === '') {
//			callToolTip122('clouddeploycharges', 'show');
//			indexError = indexError + 1;
//		}
		if ($('#IntegrationCharges').val() === '') {
			callToolTip122('IntegrationCharges', 'show');
			indexError = indexError + 1;
		} 
		if ($('#resoucesamount').val() === '') {
			callToolTip122('resoucesamount', 'show');
			indexError = indexError + 1;
		}
		
		if ($('#Subscriptionyear').val() === '' &&  $('#Proposaltype').val()==="Subscription") {
			callToolTip122('Subscriptionyear', 'show');
			indexError = indexError + 1;
		}
		if ($('#Perpetualyear').val() === '' &&  $('#Proposaltype').val()==="Perpetual") {
			callToolTip122('Perpetualyear', 'show');
			indexError = indexError + 1;
		}
		if ($('#fixedyear').val() === '' &&  $('#Proposaltype').val()==="Fixed") {
			callToolTip122('fixedyear', 'show');
			indexError = indexError + 1;
		}
		if ($('#subscriptionANDperpetualYear').val() === '' &&  $('#Proposaltype').val()==="Subscription & Perpetual") {
			callToolTip122('subscriptionANDperpetualYear', 'show');
			indexError = indexError + 1;
		}

		if (indexError > 0) {
			return false;
		} else {
			// $('#spinner2').show();
			return true;
		}
	} else if( $('#Proposaltype').val()==="Resource"){
		var indexError = 0;

		if ($('#FirstApprovername').val() === '') {
			callToolTip122('FirstApprovername', 'show');
			indexError = indexError + 1;
		}
		if ($('#customerType').val() === '') {
			callToolTip122('customerType', 'show');
			indexError = indexError + 1;
		}
		if ($('#productsuitselect').val() === '') {
			callToolTip122('productsuitselect', 'show');
			indexError = indexError + 1;
		}
		if ($('#clientname').val() === '' && $('#customerType').val() === 'Registered') {
			callToolTip122('clientname', 'show');
			indexError = indexError + 1;
		}
		if ($('#productsuitaddrow').val() === '') {
			callToolTip122('productsuitaddrow', 'show');
			indexError = indexError + 1;
		}
		if ($('#productnameaddrow').val() === '') {
			callToolTip122('productnameaddrow', 'show');
			indexError = indexError + 1;
		}
		if ($('#Desciption').val() === '') {
			callToolTip122('Desciption', 'show');
			indexError = indexError + 1;
		}
		if ($('#quantitydata').val() === '') {
			callToolTip122('quantitydata', 'show');
			indexError = indexError + 1;
		}
		if ($('#unitratedata').val() === '') {
			callToolTip122('unitratedata', 'show');
			indexError = indexError + 1;
		}
		if (indexError > 0) {
			return false;
		} else {
			// $('#spinner2').show();
			return true;
		}
	} else {
			var indexError = 0;

			if ($('#Proposaltype').val() === '') {
				callToolTip122('Proposaltype', 'show');
				indexError = indexError + 1;
			}
			
			if ($('#FirstApprovername').val() === '') {
				callToolTip122('FirstApprovername', 'show');
				indexError = indexError + 1;
			}
			if ($('#customerType').val() === '') {
				callToolTip122('customerType', 'show');
				indexError = indexError + 1;
			}
			if ($('#productsuitselect').val() === '') {
				callToolTip122('productsuitselect', 'show');
				indexError = indexError + 1;
			}
			if ($('#clientname').val() === '' && $('#customerType').val() === 'Registered') {
				callToolTip122('clientname', 'show');
				indexError = indexError + 1;
			}		
			
			if ($('#productsuitaddrow').val() === '') {
				callToolTip122('productsuitaddrow', 'show');
				indexError = indexError + 1;
			}
			if ($('#productnameaddrow').val() === '') {
				callToolTip122('productnameaddrow', 'show');
				indexError = indexError + 1;
			}
			if ($('#Desciption').val() === '') {
				callToolTip122('Desciption', 'show');
				indexError = indexError + 1;
			}
			if ($('#quantitydata').val() === '') {
				callToolTip122('quantitydata', 'show');
				indexError = indexError + 1;
			}
			if ($('#unitratedata').val() === '') {
				callToolTip122('unitratedata', 'show');
				indexError = indexError + 1;
			}
			
			if ($('#deploysupport').val() === '') {
				callToolTip122('deploysupport', 'show');
				indexError = indexError + 1;
			}
			if ($('#IntegrationCharges').val() === '') {
				callToolTip122('IntegrationCharges', 'show');
				indexError = indexError + 1;
			} 
			if ($('#resoucesamount').val() === '') {
				callToolTip122('resoucesamount', 'show');
				indexError = indexError + 1; 
			}

			if (indexError > 0) {
				return false;
			} else {
				// $('#spinner2').show();
				return true;
			}
	}
	
}

$('#amcstartdate').on('click', function() {
	callToolTip122('amcstartdate', 'destroy');
});
$('#AMCmonthyear').on('click', function() {
	callToolTip122('AMCmonthyear', 'destroy');
});
$('#AMCMonth').on('click', function() {
	callToolTip122('AMCMonth', 'destroy');
});  
$('#AMCYear').on('click', function() {
	callToolTip122('AMCYear', 'destroy');
}); 
$('#productsuitdetails').on('click', function() {
	callToolTip122('productsuitdetails', 'destroy');
});
$('#securitysolutiondetails').on('click', function() {
	callToolTip122('securitysolutiondetails', 'destroy');
});
$('#descforamc').on('click', function() {
	callToolTip122('descforamc', 'destroy');
});
$('#totalcostAMC').on('click', function() {
	callToolTip122('totalcostAMC', 'destroy');
});


var idsToDestroy = [
    'productsuitaddrow',
    'productnameaddrow',
    'Desciption',
    'quantitydata',
    'unitratedata',
    'deploysupport',
    'clouddeploycharges',
    'IntegrationCharges',
    'resoucesamount',
    'clientname',
    'productsuitselect',
    'amcstartdate',
    'AMCmonthyear',
    'AMCMonth',
    'AMCYear',
    'productsuitdetails',
    'securitysolutiondetails',
    'descforamc',
    'totalcostAMC',
    'clouddeploycharges',
    'Subscriptionyear',
    'subscriptionANDperpetualYear',
    'fixedyear',
    'Perpetualyear',
    'Subscriptionyear'
    
    ];

idsToDestroy.forEach(function(id) {
    $("#" + id).on('click', function() {
        callToolTip122(id, 'destroy');
    });
});

function proposalFor() {
	
	if($('#proposalFor').val() === "Distributor")
		{
			$('#hidePartnerName').show();
		}
	else
		{
		$('#hidePartnerName').hide();
		}
	
}


function getClientNames() {
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getCustomerName";

	  $.ajax({

	      url :serviceUrl,
	      type : 'POST',
	      dataType: 'json',
	  }).done(function(data) {

	      var html =" <select class='form-control' tabindex='8' id='clientname' name='clientname'>";
	      html=html+'<option value="">--Please Select Customer--</option>';
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }

	      document.getElementById("clientname").innerHTML=html;
	  });
}



function getMydata(){
	alert("js");
}

