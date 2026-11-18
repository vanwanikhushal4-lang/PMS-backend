
//function implementioncost()
//{
//	let inputValue = document.getElementById('ImplementorCosttotal').value;
//	 let value = parseFloat(inputValue);
//      
//     
//     if (!isNaN(value)) {
//    // Calculate 15% of the value
//    let fifteenPercent = value * 0.15;
//    
//    // Display the result in the "Implemetationcost" input field
//    document.getElementById('Implemetationcost').value = fifteenPercent.toFixed(2);
//  } else {
//    alert("Invalid input. Please enter a valid number.");
//  } 
//        
//       
//}


/////////////////////

window.onload = function() {
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/otherocstmasterlisting";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
             var table = $('#othercostdata').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 5,
                  scrollX:true,
                  scrollY:true
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });

 }




function implementioncost() {
  let inputValue = document.getElementById('ImplementorCosttotal').value;
  let value = parseFloat(inputValue);

  if (!isNaN(value))
   {
    let fifteenPercent = value * 0.15;

    document.getElementById('Implemetationcost').value = fifteenPercent.toFixed(2);
  } else {
//    alert("Invalid input. Please enter a valid number.");
  }
}

document.getElementById('ImplementorCosttotal').oninput = implementioncost;






function totalothercfhfhSSSost()
{
	
  let selectedPercentage = document.getElementById('typepercentage').value;
 // alert("first :"+selectedPercentage);
  let cost = parseFloat(document.getElementById('costdata').value);
//  alert("second :"+cost);
  if (!isNaN(cost)) {
    let percentageValue = parseFloat(selectedPercentage);

    let totalCost = (cost * percentageValue) / 100;

  var total=  document.getElementById('totalothercost').value = totalCost.toFixed(2);
  } else {
 //   alert("Invalid cost input. Please enter a valid number." + total);
  }
}


$(document).ready(function() {
  $("#typepercentage, #costdata").on("input", function() {
    calculateTotalOtherCost();
  });

  function calculateTotalOtherCost() {
    let selectedPercentage = $("#typepercentage").val();
    let cost = parseFloat($("#costdata").val());

    if (!isNaN(cost)) {
      let percentageValue = parseFloat(selectedPercentage);

      let totalCost = (cost * percentageValue) / 100;

      // Update the "totalothercost" input field
      $("#totalothercost").val(totalCost.toFixed(2));
    }
  }
});


function validateOtherCostMaster() {
    var indexError = 0;
    if ($('#engtype').val().trim() === '') {
        callToolTip231('engtype', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#engineercost').val().trim() === '') {
        callToolTip231('engineercost', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#ImplementorCosttotal').val().trim() === '') {
        callToolTip231('ImplementorCosttotal', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
     if ($('#costpercentage').val().trim() === '') {
        callToolTip231('costpercentage', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    
     if ($('#totalImplementorCosttotal').val().trim() === '') {
        callToolTip231('totalImplementorCosttotal', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }

     if ($('#otherCostt').val().trim() === '') {
        callToolTip231('otherCostt', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     if ($('#othercostpercentage').val().trim() === '') {
         callToolTip231('othercostpercentage', 'show');
         if (indexError == 0) {

         }
         indexError = indexError + 1;
     }
    
     if ($('#totalothercost').val().trim() === '') {
         callToolTip231('totalothercost', 'show');
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

	  if (fieldName == "engtype") {
	        var errorMessage = "<span>Please Select Engineer Type <span>";
	    }
	     else if (fieldName == 'engineercost') {
	    	var errorMessage = "<span>Please Enter Engineer Cost<span>";
	    } else if (fieldName == 'ImplementorCosttotal') {
	    	var errorMessage = "<span>Please Enter Total<span>";
	   } else if (fieldName == 'costpercentage') {
	    	var errorMessage = "<span>Please Select  Implementation Cost Percentage <span>";
	   } else if (fieldName == 'totalImplementorCosttotal') {
	    	var errorMessage = "<span>Please Select Total Implementation Cost<span>"; 		
	  } 
	   else if (fieldName == 'otherCostt') {
	   	var errorMessage = "<span>Please Select Other Cost<span>"; 		
	 } 
	   else if (fieldName == 'othercostpercentage') {
	   	var errorMessage = "<span>Please Select other cost percentage <span>"; 		
	 } 
	   else if (fieldName == 'totalothercost') {
	   	var errorMessage = "<span>Please Select total other cost<span>"; 		
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




$('#engtype').on('focusout', function() {
	var usertype = $('#engtype').val();
	if(usertype.trim() == "") {
		callToolTip231('engtype', 'show');
	} else {
		callToolTip231('engtype', 'hide');
	}
});

$('#engineercost').on('focusout', function() {
	var usertype = $('#engineercost').val();
	if(usertype.trim() == "") {
		callToolTip231('engineercost', 'show');
	} else {
		callToolTip231('engineercost', 'hide');
	}
});

$('#ImplementorCosttotal').on('focusout', function() {
	var usertype = $('#ImplementorCosttotal').val();
	if(usertype.trim() == "") {
		callToolTip231('ImplementorCosttotal', 'show');
	} else {
		callToolTip231('ImplementorCosttotal', 'hide');
	}
});

$('#costpercentage').on('focusout', function() {
	var usertype = $('#costpercentage').val();
	if(usertype.trim() == "") {
		callToolTip231('costpercentage', 'show');
	} else {
		callToolTip231('costpercentage', 'hide');
	}
});


$('#totalImplementorCosttotal').on('focusout', function() {
	var usertype = $('#totalImplementorCosttotal').val();
	if(usertype.trim() == "") {
		callToolTip231('totalImplementorCosttotal', 'show');
	} else {
		callToolTip231('totalImplementorCosttotal', 'hide');
	}
});

$('#otherCostt').on('focusout', function() {
	var usertype = $('#otherCostt').val();
	if(usertype.trim() == "") {
		callToolTip231('otherCostt', 'show');
	} else {
		callToolTip231('otherCostt', 'hide');
	}
});


$('#othercostpercentage').on('focusout', function() {
	var usertype = $('#othercostpercentage').val();
	if(usertype.trim() == "") {
		callToolTip231('othercostpercentage', 'show');
	} else {
		callToolTip231('othercostpercentage', 'hide');
	}
});


$('#totalothercost').on('focusout', function() {
	var usertype = $('#totalothercost').val();
	if(usertype.trim() == "") {
		callToolTip231('totalothercost', 'show');
	} else {
		callToolTip231('totalothercost', 'hide');
	}
});

$('#engtype').on('focus', function() {
	callToolTip231('engtype', 'destroy');
});
$('#engineercost').on('focus', function() {
	callToolTip231('engineercost', 'destroy');
});

$('#ImplementorCosttotal').on('focus', function() {
	callToolTip231('ImplementorCosttotal', 'destroy');
});

$('#costpercentage').on('focus', function() {
	callToolTip231('costpercentage', 'destroy');
});


$('#totalImplementorCosttotal').on('focus', function() {
	callToolTip231('totalImplementorCosttotal', 'destroy');
});

$('#otherCostt').on('focus', function() {
	callToolTip231('otherCostt', 'destroy');
});

$('#othercostpercentage').on('focus', function() {
	callToolTip231('othercostpercentage', 'destroy');
});

$('#totalothercost').on('focus', function() {
	callToolTip231('totalothercost', 'destroy');
});


$("#resetbtn").click(function() {
    $("#engtype").val("");
     callToolTip231('engtype', 'hide');

    $("#engineercost").val("");
     callToolTip231('engineercost', 'hide');
     
     $("#ImplementorCosttotal").val("");
     callToolTip231('ImplementorCosttotal', 'hide');  
     
     $("#costpercentage").val("");
     callToolTip231('costpercentage', 'hide');
     $("#totalImplementorCosttotal").val("");
     callToolTip231('totalImplementorCosttotal', 'hide');   
     
     $("#otherCostt").val("");
     callToolTip231('otherCostt', 'hide');   
     $("#othercostpercentage").val("");
     callToolTip231('othercostpercentage', 'hide');   
     $("#totalothercost").val("");
     callToolTip231('totalothercost', 'hide');  
});




$("#submit-btn").click(function() 
{

	
	if (!validateOtherCostMaster()) 
   { 
        event.preventDefault();
   }
     else 
   {
     saveDataOtherCost();
   }
});


function saveDataOtherCost()
{	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/OtherCostMaster";	
    var serviceUrl = serviceUrl;
  
        
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'engtype=' + encodeURIComponent($("#engtype").val())
            		+ '&engineercost=' + encodeURIComponent($("#engineercost").val())
            		+ '&ImplementorCosttotal=' + encodeURIComponent($("#ImplementorCosttotal").val())
            		+ '&Implemetationcost=' + encodeURIComponent($("#Implemetationcost").val())
            		+ '&typepercentage=' + encodeURIComponent($("#typepercentage").val())
            		+ '&costdata=' + encodeURIComponent($("#costdata").val())
            		+  '&totalothercost=' + encodeURIComponent($("#totalothercost").val())
        }).done(function(data) {
          
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Added Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/OtherCostMaster";
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
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/OtherCostMaster";
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
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/OtherCostMaster";
                    }

                });

              }
        });
	
}



function DeleteOtherCost(srno)
{
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
     	var serviceUrl = base_url + "/Master/deleteOthercosrmaster";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'srno=' + srno

        }).done(function(data) {        
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Deleted Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/OtherCostMaster";
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
                        window.location.href = base_url + "/Admin/OtherCostMaster";
                    }

                });

              }
        });
    });
	
}


 var callToolTipUpdate = function (fieldName, status) {
   if (fieldName == "engtypeupdate") {
     var errorMessage = "<span>Please Select Engineer Type</span>"
   } else if (fieldName == "engineercostupdate") {
     var errorMessage = "<span>Please Enter Engineer Cost</span>"
   }else if (fieldName == "ImplementorCosttotalupdate") {
     var errorMessage = "<span>Please Enter Implementation Total</span>"
   } else if (fieldName == "Implemetationcostupdate") {
     var errorMessage = "<span>Please Enter Implementation </span>"
   } else if (fieldName == "typepercentageupdate") {
     var errorMessage = "<span>Please Select Type percentage</span>"
   } else if (fieldName == "costdataupdate") {
     var errorMessage = "<span>Please Enter Cost</span>"
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
 
 
  $('#engtypeupdate').on('focusout', function () {
   var usertype = $('#engtypeupdate').val();

   if (usertype.trim() == "") {
     callToolTipUpdate('engtypeupdate', 'show');
   } else {
     callToolTipUpdate('engtypeupdate', 'hide');
   }
});
 
 $('#engineercostupdate').on('focusout', function () {
   var usertype = $('#engineercostupdate').val();

   if (usertype.trim() == "") {
     callToolTipUpdate('engineercostupdate', 'show');
   } else {
     callToolTipUpdate('engineercostupdate', 'hide');
   }
});
  

 $('#ImplementorCosttotalupdate').on('focusout', function () {
   var usertype = $('#ImplementorCosttotalupdate').val();

   if (usertype.trim() == "") {
     callToolTipUpdate('ImplementorCosttotalupdate', 'show');
   } else {
     callToolTipUpdate('ImplementorCosttotalupdate', 'hide');
   }
}); 


 $('#Implemetationcostupdate').on('focusout', function () {
   var usertype = $('#Implemetationcostupdate').val();

   if (usertype.trim() == "") {
     callToolTipUpdate('Implemetationcostupdate', 'show');
   } else {
     callToolTipUpdate('Implemetationcostupdate', 'hide');
   }
}); 


 $('#typepercentageupdate').on('focusout', function () {
   var usertype = $('#typepercentageupdate').val();

   if (usertype.trim() == "") {
     callToolTipUpdate('typepercentageupdate', 'show');
   } else {
     callToolTipUpdate('typepercentageupdate', 'hide');
   }
}); 


 $('#costdataupdate').on('focusout', function () {
   var usertype = $('#costdataupdate').val();

   if (usertype.trim() == "") {
     callToolTipUpdate('costdataupdate', 'show');
   } else {
     callToolTipUpdate('costdataupdate', 'hide');
   }
});

 $('#totalothercostupdate').on('focusout', function () {
   var usertype = $('#totalothercostupdate').val();

   if (usertype.trim() == "") {
     callToolTipUpdate('totalothercostupdate', 'show');
   } else {
     callToolTipUpdate('totalothercostupdate', 'hide');
   }
});  



$('#engtypeupdate').on('focus', function () {
   callToolTipUpdate('engtypeupdate', 'destroy');
});
 
 $('#engineercostupdate').on('focus', function () {
   callToolTipUpdate('engineercostupdate', 'destroy');
});

$('#ImplementorCosttotalupdate').on('focus', function () {
   callToolTipUpdate('ImplementorCosttotalupdate', 'destroy');
});
 
 $('#typepercentageupdate').on('focus', function () {
   callToolTipUpdate('typepercentageupdate', 'destroy');
});

 $('#costdataupdate').on('focus', function () {
   callToolTipUpdate('costdataupdate', 'destroy');
});


function validateOtherCostUpdate() {
   var indexError = 0;

   if ($('#engtypeupdate').val().trim() === '') {
     callToolTipUpdate('engtypeupdate', 'show');
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   if ($('#engineercostupdate').val().trim() === '') {
     callToolTipUpdate('engineercostupdate', 'show');
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   
   if ($('#ImplementorCosttotalupdate').val().trim() === '') {
     callToolTipUpdate('ImplementorCosttotalupdate', 'show');
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   
   if ($('#Implemetationcostupdate').val().trim() === '') {
     callToolTipUpdate('Implemetationcostupdate', 'show');
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   
   
    if ($('#typepercentageupdate').val().trim() === '') {
     callToolTipUpdate('typepercentageupdate', 'show');
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   
    if ($('#costdataupdate').val().trim() === '') {
     callToolTipUpdate('costdataupdate', 'show');
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   
    if ($('#totalothercostupdate').val().trim() === '') {
     callToolTipUpdate('totalothercostupdate', 'show');
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



function EditOtherCostMaster(srno,engtype , engcost , implementorcost ,implementcostfifteen,percentagetype,costdata,totalcostdatabypercentage)
{
	 $("#engtypeupdate").val(engtype);
	 $("#engineercostupdate").val(engcost);
	 $("#ImplementorCosttotalupdate").val(implementorcost);
	 $("#Implemetationcostupdate").val(implementcostfifteen);
	 $("#typepercentageupdate").val(percentagetype);
	 $("#costdataupdate").val(costdata);
	 $("#totalothercostupdate").val(totalcostdatabypercentage);
	 $("#sr_no1").val(srno);
	 $("#othercostmodal").modal("show");
	
}

 $("#update_othercost_btn").click(function () {
   if (!validateOtherCostUpdate())
   {
       event.preventDefault();
   }
    else if (validateOtherCostUpdate())
   {
     updateothercost();
   }
}).show();


function updateothercost()
{
	 var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/Updateothercost";
   
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data:
                 "sr_no=" + $("#sr_no1").val()
                 + "&engtypeupdate=" + $('#engtypeupdate').val()
                 + "&engineercostupdate=" + $("#engineercostupdate").val()
                 + "&ImplementorCosttotalupdate=" + $("#ImplementorCosttotalupdate").val()
                 + "&Implemetationcostupdate=" + $("#Implemetationcostupdate").val()
                 + "&typepercentageupdate=" + $("#typepercentageupdate").val()
                 + "&costdataupdate=" + $("#costdataupdate").val()
                 + "&totalothercostupdate=" + $("#totalothercostupdate").val(),
                
         success: function (data) {
             if (data == "success") {
                 swal({
                     title: "Successful!",
                     text: "Record Updated Successfully",
                     type: "success",
                     width: 300,
                     height: 200,
                     buttons: false,
                     allowOutsideClick: false,
                     preConfirm: function () {
                         var l = window.location;
                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                         window.location.href = base_url + "/Admin/OtherCostMaster";
                     }
                 });
         }    else {

                 swal({
                     title: "Unsuccessful!",
                     text: "Record not updated",
                     type: "error",
                     width: 300,
                     height: 200,
                     buttons: false,
                     allowOutsideClick: false,
                     preConfirm: function () {
                         var l = window.location;
                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                         window.location.href = base_url + "/Admin/OtherCostMaster";
                     }
                 });
             }

      //       $('#companynameupdate').val("");

         }
     });
	
}
	