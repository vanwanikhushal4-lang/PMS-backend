window.onload = function() {

	
	
    $('#category').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Category or Enter New",
//        allowClear: true
    })
    $('#subcategory').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub Category or Enter New",
//        allowClear: true
    })
    $('#subcategory1').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub Category1 or Enter New",
//        allowClear: true
    })
     $('#subcategory2').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub Category2 or Enter New",
//        allowClear: true
    })
         $('#Priorityname').select2({
    	tags: true,
    	placeholder: "Select a Priority or Enter New",
//        allowClear: true
    })
         $('#Severityname').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Severity or Enter New",
//        allowClear: true
    })

    $('#Categoryupdate').select2({
    	width:'100%',
    	tags: true,
    	placeholder: "Select a Category or Enter New",
    	dropdownParent: $('#Modelcategory')
//        allowClear: true
    })
    $('#Subcategory1update').select2({
    	width:'100%',
    	tags: true,
    	placeholder: "Select a Sub Category1 or Enter New",
    	dropdownParent: $('#Modelcategory')
    })
    $('#Subcategory2update').select2({
    	width:'100%',
    	tags: true,
    	placeholder: "Select a Sub Category2 or Enter New",
    	dropdownParent: $('#Modelcategory')
    })
     $('#Priorityupdate').select2({
    	 width:'100%',
    	tags: true,
    	placeholder: "Select a Priority or Enter New",
    	dropdownParent: $('#Modelcategory')
    })
         $('#Severityupdate').select2({
        	 width:'100%',
    	tags: true,
    	placeholder: "Select a Seviarity or Enter New",
    	dropdownParent: $('#Modelcategory')
    })
      
    
  
    ////////// GET TEMPLATE CATEGORY ////////////////
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getTemplateCategoryList";
  	///getProblemCategoryDetailsList
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data2) {
           //  alert(data2)
        		var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data2.length; i++) {
                        html += '<option value="' + data2[i] + '">' + data2[i]
                                + '</option>';
                    }
                    document.getElementById("category").innerHTML = html;
             }
});
     
////////////GET TEMPLATE SUBCATEGORY  ////////////////
//     var l = window.location;
//   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//   	var serviceUrl = base_url + "/Master/getTemplateSubCategoryList";
//
//      $.ajax({
//          type: 'POST',
//          url: serviceUrl,
//          dataType: 'json',
//          success: function(data2) {
////              alert(data2)
//         	 var html = "  <option value=''> -- Please Select --</option>";
//                     for (var i = 0; i < data2.length; i++) {
//                         html += '<option value="' + data2[i] + '">' + data2[i]
//                                 + '</option>';
//                     }
//                     document.getElementById("subcategory").innerHTML = html;
//              }
// }); 
      
//////////GET TEMPLATE SUBCATEGORY 1 ////////////////
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getTemplateCategoryList1";

       $.ajax({
           type: 'POST',
           url: serviceUrl,
           dataType: 'json',
           success: function(data2) {
//               alert(data2)
          	 var html = "  <option value=''> -- Please Select --</option>";
                      for (var i = 0; i < data2.length; i++) {
                          html += '<option value="' + data2[i] + '">' + data2[i]
                                  + '</option>';
                      }
                      document.getElementById("subcategory1").innerHTML = html;
               }
  }); 
    
       var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getTemplatePriorityList1";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          success: function(data2) {
//              alert(data2)
         	 var html = "  <option value=''> -- Please Select --</option>";
                     for (var i = 0; i < data2.length; i++) {
                         html += '<option value="' + data2[i] + '">' + data2[i]
                                 + '</option>';
                     }
                     document.getElementById("Priorityname").innerHTML = html;
              }
 }); 
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getTemplateSeverityList1";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data2) {
//             alert(data2)
        	 var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data2.length; i++) {
                        html += '<option value="' + data2[i] + '">' + data2[i]
                                + '</option>';
                    }
                    document.getElementById("Severityname").innerHTML = html;
             }
}); 
//////////GET TEMPLATE SUBCATEGORY 1 ////////////////
       var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/getTemplateSubCategoryList2";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            success: function(data2) {
//                alert(data2)
           	 var html = "  <option value=''> -- Please Select --</option>";
                       for (var i = 0; i < data2.length; i++) {
                           html += '<option value="' + data2[i] + '">' + data2[i]
                                   + '</option>';
                       }
                       document.getElementById("subcategory2").innerHTML = html;
                }
   }); 
    ////////// GET CATEGORY LISTING /////////
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/TemplateCategoryListing";
//     var serviceUrl = "CategoryDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
       //	 alert(data4)
             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 5,
                  "scrollX": true
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });

 };


var callToolTip231 = function(fieldName, status) {

		//alert(fieldName);
    if (fieldName == "categoryDiv") {

        var errorMessage = "<span>Please Select Category <span>";
    }
//    else    if (fieldName == "SubCategoryDiv") {
//
//        var errorMessage = "<span>Please Enter SubCategory Name<span>";
//    }
    else   if (fieldName == "SubCategoryDiv1") {

        var errorMessage = "<span>Please Enter SubCategory1 <span>";
    }
    else  if (fieldName == "SubCategoryDiv2") {

        var errorMessage = "<span>Please Enter SubCategory2 <span>";
    }
    else  if (fieldName == "PrioritynameDiv1") {

        var errorMessage = "<span>Please Enter Priority <span>";
    }

    else  if (fieldName == "SeveritynameDiv1") {

        var errorMessage = "<span>Please Enter Severity <span>";
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
$('#category').on('focusout', function () {
	  var usertype = $('#category').val();

	  if (usertype.trim() == "") {
		  
	    callToolTip231('categoryDiv', 'show');
	   // alert("aaaaaaaaaaaa");
	  } else {
	      callToolTip231('categoryDiv', 'hide');
	  }
	});
//$('#subcategory').on('focusout', function() {
//    var usertype = $('#subcategory').val();
//
//    if (usertype.trim() == "") {
//        callToolTip231('SubCategoryDiv', 'show');
//    }
//    else {
//        callToolTip231('SubCategoryDiv', 'hide');
//    }
//});
$('#subcategory1').on('focusout', function() {
    var usertype = $('#subcategory1').val();

    if (usertype.trim() == "") {
        callToolTip231('SubCategoryDiv1', 'show');
    }
    else {
        callToolTip231('SubCategoryDiv1', 'hide');
    }
});
$('#subcategory2').on('focusout', function() {
    var usertype = $('#subcategory2').val();

    if (usertype.trim() == "") {
        callToolTip231('SubCategoryDiv2', 'show');
    }
    else {
        callToolTip231('SubCategoryDiv2', 'hide');
    }
});

$('#Priorityname').on('focusout', function() {
    var usertype = $('#Priorityname').val();

    if (usertype.trim() == "") {
        callToolTip231('PrioritynameDiv1', 'show');
    }
    else {
        callToolTip231('PrioritynameDiv1', 'hide');
    }
});

$('#Severityname').on('focusout', function() {
    var usertype = $('#Severityname').val();

    if (usertype.trim() == "") {
        callToolTip231('SeveritynameDiv1', 'show');
    }
    else {
        callToolTip231('SeveritynameDiv1', 'hide');
    }
});

$('#categoryDiv').on('click', function () {
	//alert("fffffffff");
	  callToolTip231('categoryDiv', 'destroy');
	});
//$('#SubCategoryDiv').on('click', function () {
//	  callToolTip231('SubCategoryDiv', 'destroy');
//	});
$('#SubCategoryDiv1').on('click', function () {
	  callToolTip231('SubCategoryDiv1', 'destroy');
	 // callToolTip231('subcategory1', 'hide');
	});
$('#SubCategoryDiv2').on('click', function () {
	  callToolTip231('SubCategoryDiv2', 'destroy');
	});

$('#PrioritynameDiv1').on('click', function () {
	  callToolTip231('PrioritynameDiv1', 'destroy');
	});

$('#SeveritynameDiv1').on('click', function () {
	  callToolTip231('SeveritynameDiv1', 'destroy');
	});

function validateCategory() {
    var indexError = 0;
    
 //   alert($('gdfgdfg'));
    if ($('#category').val().trim() === '') {
        callToolTip231('categoryDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
//    if ($('#subcategory').val().trim() === '') {
//        callToolTip231('SubCategoryDiv', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
    if ($('#subcategory1').val().trim() === '') {
        callToolTip231('SubCategoryDiv1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#subcategory2').val().trim() === '') {
        callToolTip231('SubCategoryDiv2', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   // alert($('#Priorityname').val());
    
    if ($('#Priorityname').val() == '') {
    	//alert("in priority block");
    	
        callToolTip231('PrioritynameDiv1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
  console.log("VALUE OF SE" ,$('#Severityname').val());
    if ($('#Severityname').val() == '') {
    	//alert(" iam in severity");
        callToolTip231('SeveritynameDiv1', 'show');
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

$("#submit-btn").click(function() {
    if (!validateCategory()) {
    //	alert("if block");
    	event.preventDefault();
    } else {
    	saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {
	$("#category").val('').trigger('change')
//	$("#subcategory").val('').trigger('change')
	$("#subcategory1").val('').trigger('change')
	$("#subcategory2").val('').trigger('change')
	$("#Severityname").val('').trigger('change')
	$("#Priorityname").val('').trigger('change')
	
     callToolTip231('categoryDiv', 'destroy');
//     callToolTip231('SubCategoryDiv', 'destroy');
     callToolTip231('SubCategoryDiv1', 'destroy');
     callToolTip231('SubCategoryDiv2', 'destroy');
     callToolTip231('PrioritynameDiv1', 'destroy');
     callToolTip231('SeveritynameDiv1', 'destroy');
   
});

function saveDataCompany()  {
	
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/SaveCategory";
	//addProblemCategory
//        var serviceUrl = "addcategory";
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'category=' + encodeURIComponent($("#category").val())
//            		+ '&subcategory=' + $("#subcategory").val()
            		+ '&subcategory1=' + encodeURIComponent($("#subcategory1").val())
            		+ '&subcategory2=' + encodeURIComponent($("#subcategory2").val())
            		+ '&Priorityname=' + encodeURIComponent($("#Priorityname").val())
            		+ '&Severityname=' + encodeURIComponent($("#Severityname").val())
        }).done(function(data) {
//             alert("response: "+data)

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
                        window.location.href = base_url + "/Admin/CatelogueTemplateMaster";
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
                        window.location.href = base_url + "/Admin/CatelogueTemplateMaster";
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
                        window.location.href = base_url + "/Admin/CatelogueTemplateMaster";
                    }

                });

              }
        });
    //});
            }  


function DeleteTemplatecategory(srno)  {

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
     	var serviceUrl = base_url + "/Master/deleteTemplateCategory";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'crno=' + srno

        }).done(function(data) {
   //    	alert(data)
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
                        window.location.href = base_url + "/Admin/CatelogueTemplateMaster";
                    }

                });

            }

            else if (data == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to delete file",
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
                        window.location.href = base_url + "/Admin/CatelogueTemplateMaster";
                    }

                });

              }
        });
    });
            }   
                



function EditTemplatecategory(srno, category, subcategory1,subcategory2,priority,severity) {
	 var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/getTemplateCategoryList";
	  	///getProblemCategoryDetailsList
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
	         success: function(data2) {
	           //  alert(data2)
	        		var html = "  <option value=''> -- Please Select --</option>";
	                    for (var i = 0; i < data2.length; i++) {
	                        html += '<option value="' + data2[i] + '">' + data2[i]
	                                + '</option>';
	                    }
	                    document.getElementById("Categoryupdate").innerHTML = html;
	                    $("#Categoryupdate").val(category);
	             }
	});
//////////GET TEMPLATE SUBCATEGORY 1 ////////////////
	      var l = window.location;
	    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    	var serviceUrl = base_url + "/Master/getTemplateCategoryList1";

	       $.ajax({
	           type: 'POST',
	           url: serviceUrl,
	           dataType: 'json',
	           success: function(data2) {
//	               alert(data2)
	          	 var html = "  <option value=''> -- Please Select --</option>";
	                      for (var i = 0; i < data2.length; i++) {
	                          html += '<option value="' + data2[i] + '">' + data2[i]
	                                  + '</option>';
	                      }
	                      document.getElementById("Subcategory1update").innerHTML = html;
	                      $("#Subcategory1update").val(subcategory1);
	               }
	  }); 
	       var l = window.location;
	     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	     	var serviceUrl = base_url + "/Master/getTemplateSubCategoryList2";

	        $.ajax({
	            type: 'POST',
	            url: serviceUrl,
	            dataType: 'json',
	            success: function(data2) {
//	                alert(data2)
	           	 var html = "  <option value=''> -- Please Select --</option>";
	                       for (var i = 0; i < data2.length; i++) {
	                           html += '<option value="' + data2[i] + '">' + data2[i]
	                                   + '</option>';
	                       }
	                       document.getElementById("Subcategory2update").innerHTML = html;
	                       $("#Subcategory2update").val(subcategory2);
	                }
	   }); 
	        var l = window.location;
	       	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	       	var serviceUrl = base_url + "/Master/getTemplatePriorityList1";

	          $.ajax({
	              type: 'POST',
	              url: serviceUrl,
	              dataType: 'json',
	              success: function(data2) {
//	                  alert(data2)
	             	 var html = "  <option value=''> -- Please Select --</option>";
	                         for (var i = 0; i < data2.length; i++) {
	                             html += '<option value="' + data2[i] + '">' + data2[i]
	                                     + '</option>';
	                         }
	                         document.getElementById("Priorityupdate").innerHTML = html;
	                         $("#Priorityupdate").val(priority);
	                  }
	     }); 
	          var l = window.location;
	      	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	      	var serviceUrl = base_url + "/Master/getTemplateSeverityList1";

	         $.ajax({
	             type: 'POST',
	             url: serviceUrl,
	             dataType: 'json',
	             success: function(data2) {
//	                 alert(data2)
	            	 var html = "  <option value=''> -- Please Select --</option>";
	                        for (var i = 0; i < data2.length; i++) {
	                            html += '<option value="' + data2[i] + '">' + data2[i]
	                                    + '</option>';
	                        }
	                        document.getElementById("Severityupdate").innerHTML = html;
	                        $("#Severityupdate").val(severity);
	                 }
	    });  
	        
//	   $("#Categoryupdate").val(category);
//	   $("#Subcategory1update").val(subcategory1);
//	   $("#Subcategory2update").val(subcategory2);
//	   $("#Priorityupdate").val(priority);
//	   $("#Severityupdate").val(severity);
	   $("#sr_no1").val(srno);
	   $("#Modelcategory").modal("show");
	   
	 }
	 
                   

$("#update_category_btn").click(function () {
	
	//alert("in update category");
	 if (!validatecategoryUpdate())
	  {
//	       alert("fail")
	   event.preventDefault();
	 } else if (validatecategoryUpdate())
	 {
//	        alert("pass")
	     updatecategory();
	   }
	}).show();



function updatecategory() {
	   var l = window.location;
	   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   var serviceUrl = base_url + "/Master/Updatecategory";
	   
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         data: "Categoryupdate=" + encodeURIComponent($('#Categoryupdate').val())
	                 + "&Subcategory1update=" + encodeURIComponent($("#Subcategory1update").val())
	                 + "&Subcategory2update=" + encodeURIComponent($("#Subcategory2update").val())
	                 + "&Priorityupdate=" + encodeURIComponent($("#Priorityupdate").val())
	                 + "&Severityupdate=" + encodeURIComponent($("#Severityupdate").val())
	                 + "&sr_no=" + $("#sr_no1").val(),
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
	                         window.location.href = base_url + "/Admin/CatelogueTemplateMaster";
	                     }
	                 });
	             }   else if (data == "duplicate") {
	                 swal({
	                     title: "Duplicate Data!",
	                     text: "Record Already Exists",
	                     type: "warning",
	                     width: 300,
	                     height: 200,
//	            		 showCancelButton: false,
//	                   confirmButtonClass: "btn btn-danger",
//	                   cancelButtonClass: "btn btn-danger m-l-10",
//	                   confirmButtonText: "OK",
	                     buttons: false,
	                     allowOutsideClick: false,
	                     preConfirm: function () {
	                         var l = window.location;
	                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                         window.location.href = base_url + "/Admin/CatelogueTemplateMaster";
	                     }
	                 });
	             } else {

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
	                         window.location.href = base_url + "/Admin/CatelogueTemplateMaster";
	                     }
	                 });
	             }

	             //$('#companynameupdate').val("");

	         }
	     });
	 }

function validatecategoryUpdate() {
	   var indexError = 0;
	  
	   
	   if ($('#Categoryupdate').val().trim() === '') {
	     callToolTipUpdate('Categoryupdate', 'show');
	       if (indexError == 0) {

	       }
	       indexError = indexError + 1;
	   }
	   if ($('#Subcategory1update').val().trim() === '') {
	     callToolTipUpdate('Subcategory1update', 'show');
	       if (indexError == 0) {

	       }
	       indexError = indexError + 1;
	   }
	   if ($('#Subcategory2update').val().trim() === '') {
		     callToolTipUpdate('Subcategory2update', 'show');
		       if (indexError == 0) {

		       }
		       indexError = indexError + 1;
		   }
	   if ($('#Severityupdate').val().trim() === '') {
		     callToolTipUpdate('Severityupdate', 'show');
		       if (indexError == 0) {

		       }
		       indexError = indexError + 1;
		   }
	   if ($('#Priorityupdate').val().trim() === '') {
		     callToolTipUpdate('Priorityupdate', 'show');
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

var callToolTipUpdate = function (fieldName, status) {
	   if (fieldName == "Categoryupdate") {
	     var errorMessage = "<span>Please Enter Category</span>"
	   } 
	   else if (fieldName == "Subcategory1update") {
	     var errorMessage = "<span>Please Enter Subcategory</span>"
	   }
	   else if (fieldName == "Subcategory2update") {
		     var errorMessage = "<span>Please Enter Subcategory2</span>"
		   }
	   else if (fieldName == "Priorityupdate") {
		     var errorMessage = "<span>Please Enter Priority</span>"
		   }
	   else if (fieldName == "Severityupdate") {
		     var errorMessage = "<span>Please Enter Severity</span>"
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



$('#Categoryupdate').on('focusout', function () {
  var usertype = $('#Categoryupdate').val();

  if (usertype.trim() == "") {
    callToolTipUpdate('Categoryupdate', 'show');
  } else {
    callToolTipUpdate('Categoryupdate', 'hide');
  }
});

$('#Subcategory1update').on('focusout', function () {
  var usertype = $('#Subcategory1update').val();

  if (usertype.trim() == "") {
    callToolTipUpdate('Subcategory1update', 'show');
  } else {
    callToolTipUpdate('Subcategory1update', 'hide');
  }
});

$('#Subcategory2update').on('focusout', function () {
  var usertype = $('#Subcategory2update').val();

  if (usertype.trim() == "") {
    callToolTipUpdate('Subcategory2update', 'show');
  } else {
    callToolTipUpdate('Subcategory2update', 'hide');
  }
});

$('#Priorityupdate').on('focusout', function () {
  var usertype = $('#Priorityupdate').val();

  if (usertype.trim() == "") {
    callToolTipUpdate('Priorityupdate', 'show');
  } else {
    callToolTipUpdate('Priorityupdate', 'hide');
  }
});

$('#Severityupdate').on('focusout', function () {
  var usertype = $('#Severityupdate').val();

  if (usertype.trim() == "") {
    callToolTipUpdate('Severityupdate', 'show');
  } else {
    callToolTipUpdate('Severityupdate', 'hide');
  }
});



$('#Categoryupdate').on('focus', function () {
	   callToolTipUpdate('companynameupdate', 'destroy');
	});

$('#Subcategory1update').on('focus', function () {
	   callToolTipUpdate('Subcategory1update', 'destroy');
	});

$('#Subcategory2update').on('focus', function () {
	   callToolTipUpdate('Subcategory2update', 'destroy');
	});

$('#Priorityupdate').on('focus', function () {
	   callToolTipUpdate('Priorityupdate', 'destroy');
	});

$('#Severityupdate').on('focus', function () {
	   callToolTipUpdate('Severityupdate', 'destroy');
	});