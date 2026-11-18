
window.onload = function() {
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/unitmasterlisting";

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
    if ($('#Unit').val().trim() === '') {
        callToolTip231('Unit', 'show');
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

    if (fieldName == "Unit") {
        var errorMessage = "<span>Please Enter Unit <span>";
    }
     else if (fieldName == "securitysolution") {
        var errorMessage = "<span>Please Enter Security Solution<span>";
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


$('#Unit').on('focusout', function() {
	var usertype = $('#Unit').val();
	if(usertype.trim() == "") {
		callToolTip231('Unit', 'show');
	} else {
		callToolTip231('Unit', 'hide');
	}
});






$('#Unit').on('focus', function() {
	callToolTip231('Unit', 'destroy');
});

$("#resetbtn").click(function() {
    $("#Unit").val("");
     callToolTip231('Unit', 'hide'); 
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
 	var serviceUrl = base_url + "/Master/Addunit";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'Unit=' + encodeURIComponent($("#Unit").val())
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
                        window.location.href = base_url + "/Admin/unitMaster";
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
                        window.location.href = base_url + "/Admin/unitMaster";
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
                        window.location.href = base_url + "/Admin/unitMaster";
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
     	var serviceUrl = base_url + "/Master/deleteunitMaster";

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
                        window.location.href = base_url + "/Admin/unitMaster";
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
                        window.location.href = base_url + "/Admin/unitMaster";
                    }

                });

              }
        });
    });
  } 
          


function EditProductMaster(srno,productsuit , securitysolution ,unit)
{	
	 $("#productsuitupdate").val(productsuit);
	 $("#securitysolutionupdate").val(securitysolution); 
	 $("#unitdataupdate").val(unit);
	  $("#sr_no1").val(srno);
	  $("#modelproductmaster").modal("show");	     	
}

$("#update_productMasterType_btn").click(function () {

     updateunitmaster();
}).show();

function updateunitmaster()
{
	 var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/updateunitmaster";
   
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
                         window.location.href = base_url + "/Admin/unitMaster";
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
                         window.location.href = base_url + "/Admin/unitMaster";
                     }
                 });
             }

      //       $('#companynameupdate').val("");

         }
     });
}

