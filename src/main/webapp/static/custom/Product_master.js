
window.onload = function() {
	
	sectools22()
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
	 			document.getElementById("productsuitdetails").innerHTML = html;	
	 			document.getElementById("productsuitupdate").innerHTML = html;	
	 			
	 		}
	 	});
	
	      	
//	      var l = window.location;
//	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	  	var serviceUrl = base_url + "/Master/getsecuritysolutionList";
//
//	  	$.ajax({
//	  	    type: 'POST',
//	  	    url: serviceUrl,
//	  	    dataType:'JSON',
//	  	    data: 'productsuit=' + encodeURIComponent($("#productsuitupdate").val())
//	  	}).done(function(data2Array) {
//	  		alert("hhhh"+data2Array)
//	  	    // Split the received data into an array (e.g., comma-separated values)
////	  	    var data2Array = data2.split(','); // Change ',' to the appropriate delimiter
//
//	  	    var html = "<option value=''> -- Please Select --</option>";
//	  	    for (var i = 0; i < data2Array.length; i++) {
//	  	        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
//	  	    }
////	  	    document.getElementById("securitysolutiondetails").innerHTML = html;
//	  	    document.getElementById("securitysolutionupdate").innerHTML = html;
//	  	});
//	      
	      var l = window.location;
		   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		   	var serviceUrl = base_url + "/Master/getunitdataList";

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
		 			document.getElementById("unitdata").innerHTML = html;	
		 			document.getElementById("unitdataupdate").innerHTML = html;	
		 		}
		 	});
	
	
		      
		      var l = window.location;
			   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			   	var serviceUrl = base_url + "/Master/getimplementerList";

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
			 			document.getElementById("ImplementerName").innerHTML = html;	
			 			document.getElementById("updImplementerName").innerHTML = html;	
			 		}
			 	});
		
		
		      
		      
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
//			 			document.getElementById("securitysolutiondetails").innerHTML = html;		
//			 			
//			 		}
//			 	});
//	
	
	
	
	
	
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/productmasterlisting1";

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



function sectools22() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList2";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuitdetails").val())
	}).done(function(data2Array) {
	
	    // Split the received data into an array (e.g., comma-separated values)
//	    var data2Array = data2.split(','); // Change ',' to the appropriate delimiter

	    var html = "<option value=''> -- Please Select --</option>";
	    for (var i = 0; i < data2Array.length; i++) {
	        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
	    }
	    document.getElementById("securitysolutiondetails").innerHTML = html;
	    document.getElementById("securitysolutionupdate").innerHTML = html;
	});
	}

function sectools1() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";
										 
	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuitupdate").val())
	}).done(function(data2Array) {
//		alert("hhhh"+data2Array)
	    // Split the received data into an array (e.g., comma-separated values)
//	    var data2Array = data2.split(','); // Change ',' to the appropriate delimiter

	    var html = "<option value=''> -- Please Select --</option>";
	    for (var i = 0; i < data2Array.length; i++) {
	        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
	    }
//	    document.getElementById("securitysolutiondetails").innerHTML = html;
	    document.getElementById("securitysolutionupdate").innerHTML = html;
	});
	}
function validateProductMaster() {
    var indexError = 0;
    if ($('#productsuitdetails').val().trim() === '') {
        callToolTip231('productsuitdetails', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#securitysolutiondetails').val().trim() === '') {
        callToolTip231('securitysolutiondetails', 'show');
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

    if (fieldName == "productsuitdetails") {
        var errorMessage = "<span>Please Select Product Suit <span>";
    }
     else if (fieldName == "securitysolutiondetails") {
        var errorMessage = "<span>Please Select Security Solution<span>";
    } else if (fieldName == 'unitdata') {
    	var errorMessage = "<span>Please Select Unit Data<span>";
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


$('#securitysolutiondetails').on('focusout', function() {
	var usertype = $('#securitysolutiondetails').val();
	if(usertype.trim() == "") {
		callToolTip231('securitysolutiondetails', 'show');
	} else {
		callToolTip231('securitysolutiondetails', 'hide');
	}
});

$('#productsuitdetails').on('focusout', function() {
	var usertype = $('#productsuitdetails').val();
	if(usertype.trim() == "") {
		callToolTip231('productsuitdetails', 'show');
	} else {
		callToolTip231('productsuitdetails', 'hide');
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


$('#productsuitdetails').on('focus', function() {
	callToolTip231('productsuitdetails', 'destroy');
});
$('#securitysolutiondetails').on('focus', function() {
	callToolTip231('securitysolutiondetails', 'destroy');
});

$('#unitdata').on('focus', function() {
	callToolTip231('unitdata', 'destroy');
});

$("#resetbtn").click(function() {
    $("#productsuitdetails").val("");
     callToolTip231('productsuitdetails', 'hide');

    $("#securitysolutiondetails").val("");
     callToolTip231('securitysolutiondetails', 'hide');
     
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
 	var serviceUrl = base_url + "/Master/ProductMaster";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'productsuit=' + encodeURIComponent($("#productsuitdetails").val())
            		+ '&securitysolution=' + encodeURIComponent($("#securitysolutiondetails").val())
            		+ '&unitdata=' + encodeURIComponent($("#unitdata").val())
            		+ '&ImplementerName=' + encodeURIComponent($("#ImplementerName").val())
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
                        window.location.href = base_url + "/Admin/ProductMaster";
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
                        window.location.href = base_url + "/Admin/ProductMaster";
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
                        window.location.href = base_url + "/Admin/ProductMaster";
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
     	var serviceUrl = base_url + "/Master/deleteProductMaster";

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
                        window.location.href = base_url + "/Admin/ProductMaster";
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
                        window.location.href = base_url + "/Admin/ProductMaster";
                    }

                });

              }
        });
    });
  } 
          


function EditProductMaster(srno,productsuit , securitysolution ,unit,Impleme)
{
//	alert(ImplementerName)
	 $("#productsuitupdate").val(productsuit);
	 $("#securitysolutionupdate").val(securitysolution); 
	 $("#unitdataupdate").val(unit);
	 $("#updImplementerName").val(Impleme);
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
   var serviceUrl = base_url + "/Master/updateproductmaster";
   
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data: 
                 "sr_no=" + $("#sr_no1").val()
                 +"&productsuitupdate=" +$('#productsuitupdate').val()
                 + "&securitysolutionupdate="+$("#securitysolutionupdate").val()
                 + "&unitdataupdate=" +$("#unitdataupdate").val()
                   + "&updImplementerName=" +$("#updImplementerName").val(),
                                              
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
                         window.location.href = base_url + "/Admin/ProductMaster";
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
                         window.location.href = base_url + "/Admin/ProductMaster";
                     }
                 });
             }

      //       $('#companynameupdate').val("");

         }
     });
}

