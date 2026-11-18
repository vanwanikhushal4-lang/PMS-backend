
window.onload = function() {
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/securitytoollisting";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
             var table = $('#productdata').DataTable({
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




function validateProductMaster() {
    var indexError = 0;
   
    if ($('#securitysolution').val().trim() === '') {
        callToolTip231('securitysolution', 'show');
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

    if (fieldName == "productsuit") {
        var errorMessage = "<span>Please Enter Product Suit <span>";
    }
     else if (fieldName == "securitysolution") {
        var errorMessage = "<span>Please Enter Security Tool Name<span>";
    } else if (fieldName == 'unitdata') {
    	var errorMessage = "<span>Please Enter Unit Data<span>";
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
	if(usertype.trim() == "") {
		callToolTip231('productsuit', 'show');
	} else {
		callToolTip231('productsuit', 'hide');
	}
});

$('#securitysolution').on('focusout', function() {
	var usertype = $('#securitysolution').val();
	if(usertype.trim() == "") {
		callToolTip231('securitysolution', 'show');
	} else {
		callToolTip231('productname', 'hide');
	}
});

$('#unitdata').on('focusout', function() {
	var usertype = $('#unitdata').val();
	if(usertype.trim() == "") {
		callToolTip231('unitdata', 'show');
	} else {
		callToolTip231('unitdata', 'hide');
	}
});


$('#productsuit').on('focus', function() {
	callToolTip231('productsuit', 'destroy');
});
$('#securitysolution').on('focus', function() {
	callToolTip231('securitysolution', 'destroy');
});

$('#unitdata').on('focus', function() {
	callToolTip231('unitdata', 'destroy');
});

$("#resetbtn").click(function() {
    $("#productsuit").val("");
     callToolTip231('productsuit', 'hide');

    $("#securitysolution").val("");
     callToolTip231('securitysolution', 'hide');
     
      $("#unitdata").val("");
     callToolTip231('unitdata', 'hide');   
});


$("#submit-btn").click(function() {
   if (!validateProductMaster()) 
   { 
        event.preventDefault();
   }
     else 
   {
     saveDataProduct();
   }
   
});



function saveDataProduct()  {

	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/Addsecuritytool";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'securitysolution=' + encodeURIComponent($("#securitysolution").val())
//            		+ '&securitysolution=' + encodeURIComponent($("#securitysolution").val())
//            		+ '&unitdata=' + encodeURIComponent($("#unitdata").val())
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
                        window.location.href = base_url + "/Admin/securitysolutionCostMaster";
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
                        window.location.href = base_url + "/Admin/securitysolutionCostMaster";
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
                        window.location.href = base_url + "/Admin/securitysolutionCostMaster";
                    }

                });

              }
        });
   
            }  
            
  
function DeleteProductMaster(srno)  {

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
     	var serviceUrl = base_url + "/Master/deletesectool";

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
                        window.location.href = base_url + "/Admin/securitysolutionCostMaster";
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
                        window.location.href = base_url + "/Admin/securitysolutionCostMaster";
                    }

                });

              }
        });
    });
  } 
          


function EditProductMaster(srno,productsuit)
{	
	 $("#productsuitupdate").val(productsuit);
//	 $("#securitysolutionupdate").val(securitysolution); 
//	 $("#unitdataupdate").val(unit);
	  $("#sr_no1").val(srno);
	  $("#modelproductmaster").modal("show");	     	
}

$("#update_productMasterType_btn").click(function () {

     updatesectoolsmaster();
}).show();

function updatesectoolsmaster()
{
	 var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/updatesectool";
   
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data: 
                 "sr_no=" + $("#sr_no1").val()
                 +"&productsuitupdate=" +$('#productsuitupdate').val(),
//                 + "&securitysolutionupdate="+$("#securitysolutionupdate").val()
//                 + "&unitdataupdate=" +$("#unitdataupdate").val(),
                                              
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
                         window.location.href = base_url + "/Admin/securitysolutionCostMaster";
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
                         window.location.href = base_url + "/Admin/securitysolutionCostMaster";
                     }
                 });
             }

      //       $('#companynameupdate').val("");

         }
     });
}

