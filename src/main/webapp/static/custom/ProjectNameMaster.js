
window.onload = function() {
	
	
	  var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getproducutsuitList";

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
	
	      	
	      
	      
//	      var l = window.location;
//		   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		   	var serviceUrl = base_url + "/Master/getunitdataList";
//
//		      $.ajax({
//		          type: 'POST',
//		          url: serviceUrl,
//		          dataType: 'json',
//		          success: function(data2) {
//		          //    //("burger"+data2)
//		         	 var html = "  <option value=''> -- Please Select --</option>";
//		 			                    for (var i = 0; i < data2.length; i++) {
//		 				html += '<option value="' + data2[i] + '">' + data2[i]
//		 						+ '</option>';
//		 			}
//		 			document.getElementById("unitdata").innerHTML = html;		
//		 		}
//		 	});
//	
//	
		      
		      
//		      var l = window.location;
//			   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			   	var serviceUrl = base_url + "/Master/getsecuritysolutionList";
//
//			      $.ajax({
//			          type: 'POST',
//			          url: serviceUrl,
//			          dataType: 'json',
//			          success: function(data2) {
//			          //    //("burger"+data2)
//			         	 var html = "  <option value=''> -- Please Select --</option>";
//			 			                    for (var i = 0; i < data2.length; i++) {
//			 				html += '<option value="' + data2[i] + '">' + data2[i]
//			 						+ '</option>';
//			 			}
//			 			document.getElementById("securitysolution").innerHTML = html;		
//			 			
//			 		}
//			 	});
//	
//	
	
	
	
	
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/projectmasterlist";

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



function sectools() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuit").val())
	}).done(function(data2Array) {

	    var html = "<option value=''> -- Please Select --</option>";
	    for (var i = 0; i < data2Array.length; i++) {
	        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
	    }
	    document.getElementById("securitysolution").innerHTML = html;
	});
	}

function validateProductMaster() {
    var indexError = 0;
    if ($('#productsuit').val().trim() === '') {
        callToolTip231('productsuit', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#securitysolution').val().trim() === '') {
        callToolTip231('securitysolution', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#unitdata').val().trim() === '') {
        callToolTip231('unitdata', 'show');
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
        var errorMessage = "<span>Please Select Product Suit <span>";
    }
     else if (fieldName == "securitysolution") {
        var errorMessage = "<span>Please Select Security Solution<span>";
    } else if (fieldName == 'unitdata') {
    	var errorMessage = "<span>Please Select Project Name<span>";
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
		callToolTip231('securitysolution', 'hide');
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
 	var serviceUrl = base_url + "/Master/ProjectnameMaster";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'productsuit=' + encodeURIComponent($("#productsuit").val())
            		+ '&securitysolution=' + encodeURIComponent($("#securitysolution").val())
            		+ '&unitdata=' + encodeURIComponent($("#unitdata").val())
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
                        window.location.href = base_url + "/Admin/ProjectNameMaster";
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
                        window.location.href = base_url + "/Admin/ProjectNameMaster";
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
                        window.location.href = base_url + "/Admin/ProjectNameMaster";
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
     	var serviceUrl = base_url + "/Master/deleteProjectNameMaster";

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
                        window.location.href = base_url + "/Admin/ProjectNameMaster";
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
                        window.location.href = base_url + "/Admin/ProjectNameMaster";
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

     updateproducrmaster();
}).show();

function updateproducrmaster()
{
	 var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/updateprojectmaster";
   
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data: 
                 "sr_no=" + $("#sr_no1").val()
                 +"&productsuitupdate=" +$('#productsuitupdate').val()
                 + "&securitysolutionupdate="+$("#securitysolutionupdate").val()
                 + "&unitdataupdate=" +$("#unitdataupdate").val(),
                                              
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
                         window.location.href = base_url + "/Admin/ProjectNameMaster";
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
                         window.location.href = base_url + "/Admin/ProjectNameMaster";
                     }
                 });
             }

      //       $('#companynameupdate').val("");

         }
     });
}

