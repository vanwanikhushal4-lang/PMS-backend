window.onload = function() {
	
//	 $("#apexmodeDiv").hide();
//	   $("#capexmodeDiv").hide();
//	   $("#licensetypeDiv").hide();
//	   $("#subscriptiondiv").hide();
//	   $("#amcpriceDiv").hide();
//	   $("#amctotal1").hide();
//	   
	 $("#preLoaderforupload").hide();
    $('#productsuit').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select Product Suit",
//        allowClear: true
    })
    $('#productname').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select Product Name",
//        allowClear: true
    })
    $('#pricetype').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a price type",
//        allowClear: true
    })
      $('#department').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Department or Enter New",
//        allowClear: true
    })
      $('#subDepartment').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub Department or Enter New",
//        allowClear: true
    })

//       $("#sr_no1").val(srno);
//	   $("#companyup").val(company);
//	   $("#branchup").val(branch);
//	   $("#locationup").val(location1);
//	   $("#departmentup").val(department1);
	 
$('#pricetype1').select2({
	width:'100%',
	tags: true,
	placeholder: "Select a Branch or Enter New",
	dropdownParent: $('#pricetagDive')
})
$('#locationup').select2({
//  theme: 'bootstrap4'
	tags: true,
	width:'100%',
	placeholder: "Select a Location or Enter New",
	dropdownParent: $('#modelcategory1')
})
  $('#departmentup').select2({

	tags: true,
	width:'100%',
	placeholder: "Select a Department or Enter New",
	dropdownParent: $('#modelcategory1')
})
  $('#subdepartmentup').select2({
	tags: true,
	width:'100%',
	placeholder: "Select a Sub Department or Enter New",
	dropdownParent: $('#modelcategory1')
})
   
    
  
     
     var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getprojectsuitList";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          success: function(data2) {
          //    //("burger"+data2)
         	 var html = "  <option value=''> -- Please Select --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("productsuit").innerHTML = html;
 			
 		}
 	});

	// ////////GET PROBLEM Branch ////////////////
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getprojectList";

	$.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          success: function(data2) {
//              //(data2)
         	 var html = "  <option value=''> -- Please Select --</option>";
                     for (var i = 0; i < data2.length; i++) {
                         html += '<option value="' + data2[i] + '">' + data2[i]
                                 + '</option>';
                     }
                     document.getElementById("productname").innerHTML = html;
              }
 }); 
      
//for update	
	 var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getprojectsuitListupd";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          success: function(data2) {
	          //    //("burger"+data2)
	         	 var html = "  <option value=''> -- Please Select --</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("updproductsuit").innerHTML = html;
	 			
	 		}
	 	});

		// ////////GET PROBLEM Branch ////////////////
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getprojectListupd";

		$.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          success: function(data2) {
//	              //(data2)
	         	 var html = "  <option value=''> -- Please Select --</option>";
	                     for (var i = 0; i < data2.length; i++) {
	                         html += '<option value="' + data2[i] + '">' + data2[i]
	                                 + '</option>';
	                     }
	                     document.getElementById("updproductname").innerHTML = html;
	              }
	 }); 
	      

    
 
    
    ////////// GET PROBLEM CATEGORY LISTING /////////
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/CompositeListing";
//     var serviceUrl = "CategoryDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//        	 //(data4)
             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 10,
                  scrollX:true
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });

 }

var callToolTip231 = function(fieldName, status) {

    if (fieldName == "productDiv") {
        var errorMessage = "<span>Please Enter or Select Product<span>";
    }
    else if (fieldName == "productDiv1"){
    	var errorMessage = "<span>Please Enter or Select Project Name<span>";
    }
    else if (fieldName == "pricetagDive"){
    	var errorMessage = "<span>Please Enter price Type<span>";
    }
     else if (fieldName == "departmentDiv"){
    	var errorMessage = "<span>Please Enter or Select Department<span>";
    } 
    else if (fieldName == "subDepartmentDiv"){
    	var errorMessage = "<span>Please Enter or Select Sub-Department<span>";
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

$('#productsuit').on('focusout', function() {
    var usertype = $('#productsuit').val();

    if (usertype.trim() == "") {
        callToolTip231('productsuit', 'show');
    }
    else {
        callToolTip231('productsuit', 'hide');
    }
});
$('#productname').on('focusout', function() {
    var usertype = $('#productname').val();

    if (usertype.trim() == "") {
        callToolTip231('productname', 'show');
    }
    else {
        callToolTip231('productname', 'hide');
    }
});
$('#pricetype').on('focusout', function() {
    var usertype = $('#pricetype').val();

    if (usertype.trim() == "") {
        callToolTip231('pricetagDive', 'show');
    }
    else {
        callToolTip231('pricetagDive', 'hide');
    }
});
//
//$('#department').on('focusout', function() {
//    var usertype = $('#department').val();
//
//    if (usertype.trim() == "") {
//        callToolTip231('departmentDiv', 'show');
//    }
//    else {
//        callToolTip231('departmentDiv', 'hide');
//    }
//});
//
//$('#subDepartment').on('focusout', function() {
//    var usertype = $('#subDepartment').val();
//
//    if (usertype.trim() == "") {
//        callToolTip231('subDepartmentDiv', 'show');
//    }
//    else {
//        callToolTip231('subDepartmentDiv', 'hide');
//    }
//});

$('#productDiv1').on('click', function() {
	callToolTip231('productDiv1', 'destroy');
	});

$('#productDiv').on('click', function() {
callToolTip231('productDiv', 'destroy');
});

//$('#branchDive').on('click', function() {
//	callToolTip231('branchDive', 'destroy');
//	});
//$('#locationDiv').on('click', function() {
//	callToolTip231('locationDiv', 'destroy');
//	});
//	$('#departmentDiv').on('click', function() {
//	callToolTip231('departmentDiv', 'destroy');
//	});
//	$('#subDepartmentDiv').on('click', function() {
//	callToolTip231('subDepartmentDiv', 'destroy');
//	});

function validateCategory() {
    var indexError = 0;
   
    if ($('#productsuit').val().trim() === '') {
        callToolTip231('productDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#productname').val().trim() === '') {
        callToolTip231('productDiv1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#pricetype').val().trim() === '') {
        callToolTip231('pricetagDive', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
//     if ($('#department').val().trim() === '') {
//        callToolTip231('departmentDiv', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//     if ($('#subDepartment').val().trim() === '') {
//        callToolTip231('subDepartmentDiv', 'show');
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


$("#submit-btn").click(function() {

    if (!validateCategory()) {
    	event.preventDefault();
    } else {
    	saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {
	$("#productsuit").val('').trigger('change')
	$("#productname").val('').trigger('change')
	$("#pricetype").val('').trigger('change')
	$("#department").val('').trigger('change')
	$("#subDepartment").val('').trigger('change')
	
     callToolTip231('productDiv', 'destroy');
      callToolTip231('productDiv1', 'destroy');
       callToolTip231('pricetagDive', 'destroy');
     callToolTip231('branchDive', 'destroy');
     callToolTip231('locationDiv', 'destroy');
});

function saveDataCompany()  {
//	//("jjjjjjjjjjj"+$("#cloudtype").val())
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/addpricemaster";
	
//        var serviceUrl = "addcategory";
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'productsuit=' + encodeURIComponent($("#productsuit").val())
            		+ '&productname=' + encodeURIComponent($("#productname").val())
            		+ '&pricetype=' + encodeURIComponent($("#pricetype").val())
            		+ '&cloudtype=' + encodeURIComponent($("#cloudtype").val())
            		+ '&apexmode=' + encodeURIComponent($("#apexmode").val())
            		+ '&capexmode=' + encodeURIComponent($("#capexmode").val())
            		+ '&prepectual=' + encodeURIComponent($("#prepectual").val())
            		+ '&subscriptiontype=' + encodeURIComponent($("#subscriptiontype").val())
            		+ '&licentype=' + encodeURIComponent($("#licentype").val())
            		+ '&amcprice=' + encodeURIComponent($("#amcprice").val())
            		+ '&amctotal=' + encodeURIComponent($("#amctotal").val())
        }).done(function(data) {
//             //("response: "+data)

            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Added Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/PriceMaster";
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
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/PriceMaster";
                    }

                });

              }
            else if (data == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to add file",
                    type: "success",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/PriceMaster";
                    }

                });

              }
        });
    //});
            }  



function toggleDiv(data) {
	////("IHIH"+data)
 
//   if (data === 'perpetualtype'|| data === 'fixed') {
////	   //("if")
//	   $("#licensetypeDiv").show();
//	   $("#subscriptiondiv").hide();
//	   $("#amcpriceDiv").show();
//	   $("#amctotal1").show();
//   } else {
//	   $("#licensetypeDiv").hide();
//	   $("#subscriptiondiv").show();
//	   $("#amcpriceDiv").hide();
//	   $("#amctotal1").hide();
//   }
    
}


function PerpetualDiv(data) {
	////("PerpetualDiv"+data)
//let inputValue = document.getElementById('amcprice').value;
	let inputValues = document.getElementById('prepectual').value;
//	//("inputValues"+inputValues)
	
	let inputValue = data;
  let value = parseFloat(inputValue);

  if (!isNaN(value)) {
    // Calculate 15% of the value
    let fifteenPercent = value * inputValues;

    // Display the result in the "Implemetationcost" input field
    document.getElementById('amctotal').value = fifteenPercent.toFixed(2);
  } else {
    //("Invalid input. Please enter a valid number.");
  }
    
}

function cloudDiv(data) {
//	//("IHIH1"+data)
   
//   if (data === 'cloud') {
//	   //("if")
//	   $("#apexmodeDiv").show();
//	   $("#capexmodeDiv").show();
//	   
//   } else {
//	   $("#apexmodeDiv").show();
//	   $("#capexmodeDiv").show();
//   } 
//    
}

function DeleteProblemcategory(srno)  {

////("gdfsf"+srno)
    swal({
        title: "Are you sure?",
        text: "You want to delete?",
        type: "warning",
        width: 350,
        height: 200,
        showCancelButton: !0,
        confirmButtonClass: "btn btn-success",
        cancelButtonClass: "btn btn-danger m-l-10",
        confirmButtonText: "Yes, Delete it!"
    }).then(function() {
      
    	 var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/deleteComposite";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'crno=' + srno

        }).done(function(data) {
//        	//(data)
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Deleted Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/PriceMaster";
                    }

                });

            }

            else if (data == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to delete file",
                    type: "success",
                    width: 300,
                    height: 200,

                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/PriceMaster";
                    }

                });

              }
        });
    });
            }   



function EditCategory(srno,productsuit,productname,pricetype,cloudtype,apexmode,capexmode,licentype,prepectual,amcprice,amctotal,subscriptiontype) {
	    
////("hiii")
	     $("#sr_no1").val(srno);
		 $("#updproductsuit").val(productsuit);
		 $("#updproductname").val(productname); 
		 $("#updpricetype").val(pricetype);  
		  $("#updcloudtype").val(cloudtype);
		  $("#updapexmode").val(apexmode);
		  $("#updcapexmode").val(capexmode);
		  $("#updlicentype").val(licentype);
		  $("#updprepectual").val(prepectual);
		  $("#updamcprice").val(amcprice);
		  $("#updamctotal").val(amctotal);
		  $("#updsubscriptiontype").val(subscriptiontype);
		 
		
		 
		  
		  $("#modelpricemaster").modal("show");	     	
	
}
$("#update_price_master").click(function () {
	   if (!validateCompositeUpdate())
	   {

	       event.preventDefault();
	   } else if (validateCompositeUpdate())
	   {
		   updatepricemaster();
	   }
	}).show();
function updatepricemaster()

{

	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updatepricemaster";
 	
 	 $.ajax({
         type: 'POST',
         url: serviceUrl, 
         data: 'srno=' + $("#sr_no1").val()
         		    +'&productsuit=' + encodeURIComponent($("#updproductsuit").val())
            		+ '&productname=' + encodeURIComponent($("#updproductname").val())
            		+ '&pricetype=' + encodeURIComponent($("#updpricetype").val())
            		+ '&cloudtype=' + encodeURIComponent($("#updcloudtype").val())
            		+ '&apexmode=' + encodeURIComponent($("#updapexmode").val())
            		+ '&capexmode=' + encodeURIComponent($("#updcapexmode").val())
            		+ '&prepectual=' + encodeURIComponent($("#updprepectual").val())
            		+ '&subscriptiontype=' + encodeURIComponent($("#updsubscriptiontype").val())
            		+ '&licentype=' + encodeURIComponent($("#updlicentype").val())
            		+ '&amcprice=' + encodeURIComponent($("#updamcprice").val())
            		+ '&amctotal=' + encodeURIComponent($("#updamctotal").val())
     }).done(function(data) {
//          //("response: "+data)

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
                     window.location.href = base_url + "/Admin/PriceMaster";
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
                     window.location.href = base_url + "/Admin/PriceMaster";
                 }

             });

           }
         else if (data == "error") {
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
                     window.location.href = base_url + "/Admin/PriceMaster";
                 }

             });

           }
     });
   }  
function validateCompositeUpdate() {
    var indexError = 0;
   
//    if ($('#companyup').val().trim() === '') {
//        callToolTip233('companyup', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#branchup').val().trim() === '') {
//        callToolTip233('branchup', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#locationup').val().trim() === '') {
//        callToolTip233('locationup', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//     if ($('#departmentup').val().trim() === '') {
//        callToolTip233('departmentup', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//     if ($('#subdepartmentup').val().trim() === '') {
//        callToolTip233('subdepartmentup', 'show');
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
var callToolTip233  = function(fieldName, status) {

    if (fieldName == "companyup") {
        var errorMessage = "<span>Please Select Company<span>";
    }
    else if (fieldName == "branchup"){
    	var errorMessage = "<span>Please Select Branch<span>";
    }
    else if (fieldName == "locationup"){
    	var errorMessage = "<span>Please Select Location<span>";
    }
     else if (fieldName == "departmentup"){
    	var errorMessage = "<span>Please Select Department<span>";
    } 
    else if (fieldName == "subdepartmentup"){
    	var errorMessage = "<span>Please Select Sub Department<span>";
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
$('#companyup').on('focusout', function() {
    var usertype = $('#companyup').val();

    if (usertype.trim() == "") {
        callToolTip233('companyup', 'show');
    }
    else {
        callToolTip231('companyup', 'hide');
    }
});
$('#branchup').on('focusout', function() {
    var usertype = $('#branchup').val();

    if (usertype.trim() == "") {
        callToolTip233('branchup', 'show');
    }
    else {
        callToolTip233('branchup', 'hide');
    }
});
$('#locationup').on('focusout', function() {
    var usertype = $('#locationup').val();

    if (usertype.trim() == "") {
        callToolTip233('locationup', 'show');
    }
    else {
        callToolTip233('locationup', 'hide');
    }
});

$('#departmentup').on('focusout', function() {
    var usertype = $('#departmentup').val();

    if (usertype.trim() == "") {
        callToolTip233('departmentup', 'show');
    }
    else {
        callToolTip233('departmentup', 'hide');
    }
});

$('#subdepartmentup').on('focusout', function() {
    var usertype = $('#subdepartmentup').val();

    if (usertype.trim() == "") {
        callToolTip233('subDepartmentDiv', 'show');
    }
    else {
        callToolTip233('subDepartmentDiv', 'hide');
    }
});



$('#companyup').on('click', function() {
callToolTip233('companyup', 'destroy');
});
$('#branchup').on('click', function() {
	callToolTip233('branchup', 'destroy');
	});
$('#locationup').on('click', function() {
	callToolTip233('locationup', 'destroy');
	});
	$('#departmentup').on('click', function() {
	callToolTip233('departmentup', 'destroy');
	});
	$('#subdepartmentup').on('click', function() {
	callToolTip233('subdepartmentup', 'destroy');
	});
	
	
	
	
	
	 $(document).ready(function() {
	      function calculateTotalCost() {
	        var implementorCost = parseFloat($("#amcprice").val()) || 0;
	        var costPercentage = parseFloat($("#prepectual").val()) || 0;

	        // Calculate the total cost
	        var totalCost = implementorCost * (costPercentage / 100);

	        // Update the "totalImplementorCosttotal" field with the calculated total cost
	        $("#amctotal").val(totalCost.toFixed(2));
	      }

	      // Call the calculateTotalCost function when the "ImplementorCosttotal" or "costpercentage" fields change
	      $("#amcprice, #prepectual").on("input", calculateTotalCost);
	 });
                
             