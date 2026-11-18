window.onload = function() {
	
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
           async: false,
         success: function(data4) {
//             alert(data4)
        	 $("#preLoader").hide();
         	$("#datatype").removeClass("d-none");
                    var html = "<option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("cname").innerHTML = html;
                   
                    
             }
     });

    $('#category').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Category or Enter New",
//        allowClear: true
    })
    $('#subcategory1').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub-Category 1 or Enter New",
//        allowClear: true
    })
    $('#subcategory2').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub-Category 2 or Enter New",
//        allowClear: true
    })
       $('#priority').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Priority or Enter New",
//        allowClear: true
    })
       $('#severity').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Severity or Enter New",
//        allowClear: true
    })
    
 
    
    //////////////////update Seloect2////////////

    $('#Subcategory1update').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	width:'100%',
    	placeholder: "Select a Sub Category 1 or Enter New",
    	dropdownParent: $('#Modelcategory')
//        allowClear: true
    })
    $('#Subcategory2update').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	width:'100%',
    	placeholder: "Select a Sub Category 2 or Enter New",
    	dropdownParent: $('#Modelcategory')
//        allowClear: true
    })
       $('#Priorityupdate').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	width:'100%',
    	placeholder: "Select a Priority or Enter New",
    	dropdownParent: $('#Modelcategory')
//        allowClear: true
    })
       $('#Severityupdate').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	width:'100%',
    	placeholder: "Select a Severity or Enter New",
    	dropdownParent: $('#Modelcategory')
//        allowClear: true
    })
    
    $('#Categoryupdate').select2({
//      theme: 'bootstrap4'
    	 
    	 width:'100%',
    	tags: true,
    	
    	placeholder: "Select a Severity or Enter New",
    	dropdownParent: $('#Modelcategory')
//        allowClear: true
    })
    
    //////////////update select2 end////////////
     
    ////////// GET PROBLEM CATEGORY ////////////////
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getCategoryDetailsList";

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
                    document.getElementById("category").innerHTML = html;
             }
});
     
//////////GET PROBLEM SUBCATEGORY 1 ////////////////
     var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getSubCategory1";

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
                     document.getElementById("subcategory1").innerHTML = html;
              }
 }); 
      
//////////GET PROBLEM SUBCATEGORY 2 ////////////////
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getSubCategory2";

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
                      document.getElementById("subcategory2").innerHTML = html;
               }
  });       
    
//////////GET PROBLEM Priority ////////////////
     
       
       
       
    ////////// GET PROBLEM CATEGORY LISTING /////////
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/CategoryListing";
//     var serviceUrl = "CategoryDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//        	 alert(data4)
             var table = $('#datatype').DataTable({
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

var callToolTip231 = function(fieldName, status) {

	if (fieldName == "cname") {
        var errorMessage = "<span>Please Select Company<span>";
    }
	else if (fieldName == "categoryProblemDiv") {
        var errorMessage = "<span>Please Enter or Select Category<span>";
    }
    else if (fieldName == "subcategory1Div"){
    	var errorMessage = "<span>Please Enter or Select Sub-Category 1<span>";
    }
    else if (fieldName == "subcategory2Div"){
    	var errorMessage = "<span>Please Enter or Select Sub-Category 2<span>";
    }
    else if (fieldName == "priorityDiv") {
        var errorMessage = "<span>Please Enter or Select Priority<span>";
    }

    if (fieldName == "severityDiv") {
        var errorMessage = "<span>Please Enter or Select Severity<span>";
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

$('#cname').on('focusout', function() {
    var usertype = $('#cname').val();

    if (usertype.trim() == "") {
        callToolTip231('cname', 'show');
    }
    else {
        callToolTip231('cname', 'hide');
    }
});
$('#category').on('focusout', function() {
    var usertype = $('#category').val();

    if (usertype.trim() == "") {
        callToolTip231('categoryProblemDiv', 'show');
    }
    else {
        callToolTip231('categoryProblemDiv', 'hide');
    }
});
$('#priority').on('focusout', function() {
    var usertype = $('#priority').val();

    if (usertype.trim() == "") {
        callToolTip231('priorityDiv', 'show');
    }
    else {
        callToolTip231('priorityDiv', 'hide');
    }
});
$('#severity').on('focusout', function() {
    var usertype = $('#severity').val();

    if (usertype.trim() == "") {
        callToolTip231('severityDiv', 'show');
    }
    else {
        callToolTip231('severityDiv', 'hide');
    }
});
$('#subcategory1').on('focusout', function() {
    var usertype = $('#subcategory1').val();

    if (usertype.trim() == "") {
        callToolTip231('subcategory1Div', 'show');
    }
    else {
        callToolTip231('subcategory1Div', 'hide');
    }
});
$('#subcategory2').on('focusout', function() {
    var usertype = $('#subcategory2').val();

    if (usertype.trim() == "") {
        callToolTip231('subcategory2Div', 'show');
    }
    else {
        callToolTip231('subcategory2Div', 'hide');
    }
});

$('#cname').on('click', function() {
	callToolTip231('cname', 'destroy');
	});
$('#categoryProblemDiv').on('click', function() {
callToolTip231('categoryProblemDiv', 'destroy');
});
$('#priorityDiv').on('click', function() {
	callToolTip231('priorityDiv', 'destroy');
	});
$('#severityDiv').on('click', function() {
	callToolTip231('severityDiv', 'destroy');
	});
$('#subcategory1Div').on('click', function() {
	callToolTip231('subcategory1Div', 'destroy');
	});
$('#subcategory2Div').on('click', function() {
	callToolTip231('subcategory2Div', 'destroy');
	});

function validateCategory() {
    var indexError = 0;
   
    if ($('#cname').val().trim() === '') {
        callToolTip231('cname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#category').val().trim() === '') {
        callToolTip231('categoryProblemDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#priority').val().trim() === '') {
        callToolTip231('priorityDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#severity').val().trim() === '') {
        callToolTip231('severityDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#subcategory1').val().trim() === '') {
        callToolTip231('subcategory1Div', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#subcategory2').val().trim() === '') {
        callToolTip231('subcategory2Div', 'show');
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
    	event.preventDefault();
    } else {
    	saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {

	$("#cname").val('').trigger('change')
	$("#category").val('').trigger('change')
	$("#priority").val('').trigger('change')
	$("#severity").val('').trigger('change')
	$("#subcategory1").val('').trigger('change')
	$("#subcategory2").val('').trigger('change')
	callToolTip231('cname', 'destroy');
     callToolTip231('categoryProblemDiv', 'destroy');
	callToolTip231('priorityDiv', 'destroy');
	callToolTip231('severityDiv', 'destroy');
     callToolTip231('subcategory1Div', 'destroy');
     callToolTip231('subcategory2Div', 'destroy');
});

function saveDataCompany()  {
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/addNewCategory";
	
//        var serviceUrl = "addcategory";
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'category=' + encodeURIComponent($("#category").val())
            		+ '&subcategory1=' + encodeURIComponent($("#subcategory1").val())
            		+ '&subcategory2=' + encodeURIComponent($("#subcategory2").val())
            		+ '&priority=' + encodeURIComponent($("#priority").val())
            		+ '&severity=' + encodeURIComponent($("#severity").val())
            		+ '&company=' + encodeURIComponent($("#cname").val())
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
                        window.location.href = base_url + "/Admin/CategoryMaster";
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
                        window.location.href = base_url + "/Admin/CategoryMaster";
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
                        window.location.href = base_url + "/Admin/CategoryMaster";
                    }

                });

              }
        });
    //});
            }  


function DeleteProblemcategory(srno)  {

//alert("gdfsf"+srno)
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
     	var serviceUrl = base_url + "/Master/deleteCategory";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'crno=' + srno

        }).done(function(data) {
//        	alert(data)
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
                        window.location.href = base_url + "/Admin/CategoryMaster";
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
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/CategoryMaster";
                    }

                });

              }
        });
    });
}   



function EditTemplatecategory(srno, category, subcategory1,subcategory2,priority,severity,company) {

	//alert(company);
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getPriorityName";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'companyname=' + encodeURIComponent(company),
        success: function(data2) {
     //     alert(data2)
       	 var html = "  <option value=''> -- Please Select --</option>";
                   for (var i = 0; i < data2.length; i++) {
                	 //  alert(data2[i]);
                       html += '<option value="' + data2[i] + '">' + data2[i]
                               + '</option>';
                   }
                   document.getElementById("Priorityupdate").innerHTML = html;
                 $("#Priorityupdate").val(priority);
                   
            }
}); 
//////////GET PROBLEM SUBCATEGORY 2 ////////////////
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getSeverityName";
  	
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + encodeURIComponent(company),
         success: function(data2) {
        //   alert(data2)
        	 var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data2.length; i++) {
                    	//alert(data2[i]);
                        html += '<option value="' + data2[i] + '">' + data2[i]
                                + '</option>';
                    }
                    document.getElementById("Severityupdate").innerHTML = html;
                    $("#Severityupdate").val(severity);
                    
             }
}); 

	
	////////// GET PROBLEM CATEGORY ////////////////
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getCategoryDetailsList";

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
                    document.getElementById("Categoryupdate").innerHTML = html;
                    $("#Categoryupdate").val(category);
                    
             }
});
     
//////////GET PROBLEM SUBCATEGORY 1 ////////////////
    var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getSubCategory1";

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
                     document.getElementById("Subcategory1update").innerHTML = html;
                     $("#Subcategory1update").val(subcategory1);
              }
 }); 
      
//////////GET PROBLEM SUBCATEGORY 2 ////////////////
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getSubCategory2";

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
                      document.getElementById("Subcategory2update").innerHTML = html;
                      $("#Subcategory2update").val(subcategory2);      
               }
  });       
    
//////////GET PROBLEM Priority ////////////////

//	   $("#Categoryupdate").val(category);
//	   $("#Subcategory1update").val(subcategory1);
//	   $("#Subcategory2update").val(subcategory2);
//	   $("#Priorityupdate").val(priority);
//	   $("#Severityupdate").val(severity);
	   $("#Companyupdate").val(company);
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





function updatecategory() {
	   var l = window.location;
	   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   var serviceUrl = base_url + "/Master/Updatecategorytemplate";
	   
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         data: "Categoryupdate=" + encodeURIComponent($('#Categoryupdate').val())
	                 + "&Subcategory1update=" + encodeURIComponent($("#Subcategory1update").val())
	                 + "&Subcategory2update=" + encodeURIComponent($("#Subcategory2update").val())
	                 + "&Priorityupdate=" + encodeURIComponent($("#Priorityupdate").val())
	                 + "&Severityupdate=" + encodeURIComponent($("#Severityupdate").val())
	                  + "&Companyupdate=" + encodeURIComponent($("#Companyupdate").val())
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
	                         window.location.href = base_url + "/Admin/CategoryMaster";
	                     }
	                 });
	             } else if (data == "duplicate") {
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
	                         window.location.href = base_url + "/Admin/CategoryMaster";
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
	                         window.location.href = base_url + "/Admin/CategoryMaster";
	                     }
	                 });
	             }

	             //$('#companynameupdate').val("");

	         }
	     });
	 }


function getseveritypriority(company){
	
	//alert(company);
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getPriorityName";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'companyname=' + encodeURIComponent(company),
        success: function(data2) {
     //     alert(data2)
       	 var html = "<option value=''> -- Please Select --</option>";
                   for (var i = 0; i < data2.length; i++) {
                	 //  alert(data2[i]);
                       html += '<option value="' + data2[i] + '">' + data2[i]
                               + '</option>';
                   }
                   document.getElementById("priority").innerHTML = html;
                  // $("#Priorityupdate").val(priority);
                   
            }
}); 
//////////GET PROBLEM SUBCATEGORY 2 ////////////////
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getSeverityName";
  	
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + encodeURIComponent(company),
         success: function(data2) {
        //   alert(data2)
        	 var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data2.length; i++) {
                    	//alert(data2[i]);
                        html += '<option value="' + data2[i] + '">' + data2[i]
                                + '</option>';
                    }
                    document.getElementById("severity").innerHTML = html;
                    //$("#Severityupdate").val(severity);
                    
             }
}); 
	
}

//// Bulik Upload code 
//
//function submitUploadbutton(){
//	 $("#preLoaderforupload").show();
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/saveBulkUploadcompositeData";
//   var formData = new FormData($('#bulkuploadcompositeform')[0]);
//
//  $.ajax({
//      url: serviceUrl,
//      type: 'post',
//      data: formData,
//      mimeType: "multipart/form-data",
//      contentType: false,
//      processData: false,
//      cache: false,
//         success: function (data) {  
//        	 $("#preLoaderforupload").hide();
//	        	$("#datatype").removeClass("d-none");
////        	 alert(data)
//             var nameArr = data.split(',');
//             if(nameArr[0]=="fileopen"){
//            	 swal({
////         			position : 'top',
//         			title : 'Failed',
//         			type: "error",
//         			html : nameArr[1],
////         			showConfirmButton : true,
//         			 buttons: false,
//                     allowOutsideClick: false,
//                     preConfirm: function () {
//                         location.reload();
//                     }
//         		})
//             } else if(nameArr[0]=="formatIssue"){
//            	 swal({
////          			position : 'top',
//          			title : 'Failed',
//          			type: "error",
//          			html : nameArr[1],
////          			showConfirmButton : true,
//          			 buttons: false,
//                      allowOutsideClick: false,
//                      preConfirm: function () {
//                          location.reload();
//                      }
//          		})
//              }
//             else{
////            	alert("inside else ") 
//             var total=parseInt(nameArr[0])+parseInt(nameArr[1]);
//             var msgResponse;
//             if(parseInt(nameArr[1])!==0){
//            	 msgResponse= "Total Records: "+total+"<br>Updated Records: "+nameArr[0]+"<br>Failed Records: "+nameArr[1]+"<br>Download Failed Records: <i class='nav-icon fas fa-download' onclick=downFile('"+encodeURIComponent(nameArr[2])+"')></i>"
//             } else if(parseInt(nameArr[1])===0){
//            	 msgResponse= "Total Records: "+total+"<br>Updated Records: "+nameArr[0]+"<br>Failed Records: "+nameArr[1]+""
//             }
//             
//              swal({
//                  title: "Response!",
//                  html: msgResponse,
//                 // text: "Ticket Raised Successfully",
////                  type: "success",
//                  width: 300,
//                  height: 200,
////                showCancelButton: false,
////                confirmButtonClass: "btn btn-danger",
////                cancelButtonClass: "btn btn-danger m-l-10",
////                confirmButtonText: "OK",
//                  buttons: false,
//                  allowOutsideClick: false,
//                  preConfirm: function () {
//                      location.reload();
//                  }
//
//              })
//         }
//         }     
//     })
//}
//function downFile(att) {
//
//	var filename =att;
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	window.location = base_url + "/Master/DownloadBulkUploadFailedCategoryFile?filename=" + filename;
//}