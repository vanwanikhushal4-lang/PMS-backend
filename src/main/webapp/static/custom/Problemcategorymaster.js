window.onload = function() {

    $('#category').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Category or Enter New",
//        allowClear: true
    })
    $('#subcategory1').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub Category or Enter New",
//        allowClear: true
    })
    $('#subcategory2').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub Category or Enter New",
//        allowClear: true
    })
    $('#category').focus();
    
    ////////// GET PROBLEM CATEGORY ////////////////
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getProblemCategoryDetailsList";

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
   	var serviceUrl = base_url + "/Master/getProblemSubCategory1";

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
    	var serviceUrl = base_url + "/Master/getProblemSubCategory2";

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
    
    ////////// GET PROBLEM CATEGORY LISTING /////////
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/ProblemCategoryListing";
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
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });

 }

var callToolTip231 = function(fieldName, status) {

    if (fieldName == "categoryProblemDiv") {
        var errorMessage = "<span>Please Enter or Select Category<span>";
    }
    else if (fieldName == "subcategory1Div"){
    	var errorMessage = "<span>Please Enter or Select Sub Category<span>";
    }
    else if (fieldName == "subcategory2Div"){
    	var errorMessage = "<span>Please Enter or Select Sub Category<span>";
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

$('#category').on('focusout', function() {
    var usertype = $('#category').val();

    if (usertype.trim() == "") {
        callToolTip231('categoryProblemDiv', 'show');
    }
    else {
        callToolTip231('categoryProblemDiv', 'hide');
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


$('#categoryProblemDiv').on('click', function() {
callToolTip231('categoryProblemDiv', 'destroy');
});
$('#subcategory1Div').on('click', function() {
	callToolTip231('subcategory1Div', 'destroy');
	});
$('#subcategory2Div').on('click', function() {
	callToolTip231('subcategory2Div', 'destroy');
	});

function validateCategory() {
    var indexError = 0;
   
    if ($('#category').val().trim() === '') {
        callToolTip231('categoryProblemDiv', 'show');
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
	$("#category").val('').trigger('change')
	$("#subcategory1").val('').trigger('change')
	$("#subcategory2").val('').trigger('change')
     callToolTip231('categoryProblemDiv', 'destroy');
     callToolTip231('subcategory1Div', 'destroy');
     callToolTip231('subcategory2Div', 'destroy');
});

function saveDataCompany()  {
	
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/addProblemCategory";
	
//        var serviceUrl = "addcategory";
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'category=' + $("#category").val()
            		+ '&subcategory1=' + $("#subcategory1").val()
            		+ '&subcategory2=' + $("#subcategory2").val()
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
                        window.location.href = base_url + "/Admin/ProblemCategoryMaster";
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
                        window.location.href = base_url + "/Admin/ProblemCategoryMaster";
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
                        window.location.href = base_url + "/Admin/ProblemCategoryMaster";
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
     	var serviceUrl = base_url + "/Master/deleteProblemCategory";

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
                        window.location.href = base_url + "/Admin/ProblemCategoryMaster";
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
                        window.location.href = base_url + "/Admin/ProblemCategoryMaster";
                    }

                });

              }
        });
    });
            }   
                
                   