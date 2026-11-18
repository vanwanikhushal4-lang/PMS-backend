window.onload = function() {
	 $("#preLoaderforupload").hide();
    $('#company').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Company or Enter New",
//        allowClear: true
    })
    $('#branch').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Branch or Enter New",
//        allowClear: true
    })
    $('#location').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Location or Enter New",
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
	 
$('#branchup').select2({
	width:'100%',
	tags: true,
	placeholder: "Select a Branch or Enter New",
	dropdownParent: $('#modelcategory1')
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
   
    
    ////////// GET PROBLEM company ////////////////
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getCompositeCompanyList";

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
			document.getElementById("company").innerHTML = html;
		}
	});

	// ////////GET PROBLEM Branch ////////////////
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCompositeBranchList";

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
                     document.getElementById("branch").innerHTML = html;
              }
 }); 
      
//////////GET PROBLEM Location  ////////////////
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getCompositeLocationList";

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
                      document.getElementById("location").innerHTML = html;
               }
  });       
  
  
  //////////GET PROBLEM Department  ////////////////
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getCompositeDepartment";

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
                      document.getElementById("department").innerHTML = html;
               }
  });    
    
    
     //////////GET PROBLEM Sub Department  ////////////////
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getCompositeSubDepartment";

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
                      document.getElementById("subDepartment").innerHTML = html;
               }
  });    
    
    
    ////////// GET PROBLEM CATEGORY LISTING /////////
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/Compositemasterlist";
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
                  scrollX:true
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });

 }

var callToolTip231 = function(fieldName, status) {

    if (fieldName == "companyDiv") {
        var errorMessage = "<span>Please Enter or Select Company<span>";
    }
    else if (fieldName == "branchDive"){
    	var errorMessage = "<span>Please Enter or Select Branch<span>";
    }
    else if (fieldName == "locationDiv"){
    	var errorMessage = "<span>Please Enter or Select Location<span>";
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

$('#company').on('focusout', function() {
    var usertype = $('#company').val();

    if (usertype.trim() == "") {
        callToolTip231('companyDiv', 'show');
    }
    else {
        callToolTip231('companyDiv', 'hide');
    }
});
$('#branch').on('focusout', function() {
    var usertype = $('#branch').val();

    if (usertype.trim() == "") {
        callToolTip231('branchDive', 'show');
    }
    else {
        callToolTip231('branchDive', 'hide');
    }
});
$('#location').on('focusout', function() {
    var usertype = $('#location').val();

    if (usertype.trim() == "") {
        callToolTip231('locationDiv', 'show');
    }
    else {
        callToolTip231('locationDiv', 'hide');
    }
});

$('#department').on('focusout', function() {
    var usertype = $('#department').val();

    if (usertype.trim() == "") {
        callToolTip231('departmentDiv', 'show');
    }
    else {
        callToolTip231('departmentDiv', 'hide');
    }
});

$('#subDepartment').on('focusout', function() {
    var usertype = $('#subDepartment').val();

    if (usertype.trim() == "") {
        callToolTip231('subDepartmentDiv', 'show');
    }
    else {
        callToolTip231('subDepartmentDiv', 'hide');
    }
});



$('#companyDiv').on('click', function() {
callToolTip231('companyDiv', 'destroy');
});
$('#branchDive').on('click', function() {
	callToolTip231('branchDive', 'destroy');
	});
$('#locationDiv').on('click', function() {
	callToolTip231('locationDiv', 'destroy');
	});
	$('#departmentDiv').on('click', function() {
	callToolTip231('departmentDiv', 'destroy');
	});
	$('#subDepartmentDiv').on('click', function() {
	callToolTip231('subDepartmentDiv', 'destroy');
	});

function validateCategory() {
    var indexError = 0;
   
    if ($('#company').val().trim() === '') {
        callToolTip231('companyDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#branch').val().trim() === '') {
        callToolTip231('branchDive', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#location').val().trim() === '') {
        callToolTip231('locationDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     if ($('#department').val().trim() === '') {
        callToolTip231('departmentDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     if ($('#subDepartment').val().trim() === '') {
        callToolTip231('subDepartmentDiv', 'show');
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
	$("#company").val('').trigger('change')
	$("#branch").val('').trigger('change')
	$("#location").val('').trigger('change')
	$("#department").val('').trigger('change')
	$("#subDepartment").val('').trigger('change')
	
     callToolTip231('companyDiv', 'destroy');
      callToolTip231('subDepartmentDiv', 'destroy');
       callToolTip231('departmentDiv', 'destroy');
     callToolTip231('branchDive', 'destroy');
     callToolTip231('locationDiv', 'destroy');
});

function saveDataCompany()  {
	
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/addComposite";
	
//        var serviceUrl = "addcategory";
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'company=' + encodeURIComponent($("#company").val())
            		+ '&branch=' + encodeURIComponent($("#branch").val())
            		+ '&location=' + encodeURIComponent($("#location").val())
            		+ '&department=' + encodeURIComponent($("#department").val())
            		+ '&subDepartment=' + encodeURIComponent($("#subDepartment").val())
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
                        window.location.href = base_url + "/Admin/CompositeMaster";
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
                        window.location.href = base_url + "/Admin/CompositeMaster";
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
                        window.location.href = base_url + "/Admin/CompositeMaster";
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
     	var serviceUrl = base_url + "/Master/deleteComposite";

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
                        window.location.href = base_url + "/Admin/CompositeMaster";
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
                        window.location.href = base_url + "/Admin/CompositeMaster";
                    }

                });

              }
        });
    });
            }   
function EditCategory(srno,company,branch,location1,department1 ,subdepartment1) {
	
	// ////////GET PROBLEM Branch ////////////////
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCompositeBranchList";

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
                     document.getElementById("branchup").innerHTML = html;
                     $("#branchup").val(branch);
              }
 }); 
      
//////////GET PROBLEM Location  ////////////////
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getCompositeLocationList";

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
                      document.getElementById("locationup").innerHTML = html;
                      $("#locationup").val(location1);
               }
  });       
  
  
  //////////GET PROBLEM Department  ////////////////
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getCompositeDepartment";

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
                      document.getElementById("departmentup").innerHTML = html;
                      $("#departmentup").val(department1);
               }
  });    
    
    
     //////////GET PROBLEM Sub Department  ////////////////
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getCompositeSubDepartment";

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
                      document.getElementById("subdepartmentup").innerHTML = html;
                      $("#subdepartmentup").val(subdepartment1);
               }
  });    

	   $("#sr_no1").val(srno);
   $("#companyup").val(company);
//	   $("#branchup").val(branch);
//	   $("#locationup").val(location1);
//	
//	   $("#subdepartmentup").val(subdepartment1);
	   $("#modelcategory1").modal("show");
	   
	   
	 }
$("#update_composite_master").click(function () {
	   if (!validateCompositeUpdate())
	   {

	       event.preventDefault();
	   } else if (validateCompositeUpdate())
	   {
		   	updateCompositeMaster();
	   }
	}).show();
function updateCompositeMaster()
{
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updateCompositeMaster";
 	
 	 $.ajax({
         type: 'POST',
         url: serviceUrl, 
         data: 'srno=' + $("#sr_no1").val()
         		+'&company=' + encodeURIComponent($("#companyup").val())
         		+ '&branch=' + encodeURIComponent($("#branchup").val())
         		+ '&location=' + encodeURIComponent($("#locationup").val())
         		+ '&department=' + encodeURIComponent($("#departmentup").val())
         		+ '&subDepartment=' + encodeURIComponent($("#subdepartmentup").val())
     }).done(function(data) {
//          alert("response: "+data)

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
                     window.location.href = base_url + "/Admin/CompositeMaster";
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
                     window.location.href = base_url + "/Admin/CompositeMaster";
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
                     window.location.href = base_url + "/Admin/CompositeMaster";
                 }

             });

           }
     });
   }  
function validateCompositeUpdate() {
    var indexError = 0;
   
    if ($('#companyup').val().trim() === '') {
        callToolTip233('companyup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#branchup').val().trim() === '') {
        callToolTip233('branchup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#locationup').val().trim() === '') {
        callToolTip233('locationup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     if ($('#departmentup').val().trim() === '') {
        callToolTip233('departmentup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     if ($('#subdepartmentup').val().trim() === '') {
        callToolTip233('subdepartmentup', 'show');
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
                
                   
                   
                   
  // Bulik Upload code 

function submitUploadbutton(){

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/saveBulkUploadcompositeData";
   var formData = new FormData($('#bulkuploadcompositeform')[0]);

  $.ajax({
      url: serviceUrl,
      type: 'post',
      data: formData,
      mimeType: "multipart/form-data",
      contentType: false,
      processData: false,
      cache: false,
         success: function (data) {  
	alert(data)
        	 $("#preLoaderforupload").hide();
	         $("#datatype").removeClass("d-none");
//        	 alert(data)
             var nameArr = data.split(',');
             if(nameArr[0]=="fileopen"){
            	 swal({
//         			position : 'top',
         			title : 'Failed',
         			type: "error",
         			html : nameArr[1],
//         			showConfirmButton : true,
         			 buttons: false,
                     allowOutsideClick: false,
                     preConfirm: function () {
                         location.reload();
                     }
         		})
             } else if(nameArr[0]=="formatIssue"){
            	 swal({
//          			position : 'top',
          			title : 'Failed',
          			type: "error",
          			html : nameArr[1],
//          			showConfirmButton : true,
          			 buttons: false,
                      allowOutsideClick: false,
                      preConfirm: function () {
                          location.reload();
                      }
          		})
              }
             else{
//            	alert("inside else ") 
             var total=parseInt(nameArr[0])+parseInt(nameArr[1]);
             var msgResponse;
             if(parseInt(nameArr[1])!==0){
            	 msgResponse= "Total Records: "+total+"<br>Updated Records: "+nameArr[0]+"<br>Failed Records: "+nameArr[1]+"<br>Download Failed Records: <i class='nav-icon fas fa-download' onclick=downFile('"+encodeURIComponent(nameArr[2])+"')></i>"
             } else if(parseInt(nameArr[1])===0){
            	 msgResponse= "Total Records: "+total+"<br>Updated Records: "+nameArr[0]+"<br>Failed Records: "+nameArr[1]+""
             }
             
              swal({
                  title: "Response!",
                  html: msgResponse,
                 // text: "Ticket Raised Successfully",
//                  type: "success",
                  width: 300,
                  height: 200,
//                showCancelButton: false,
//                confirmButtonClass: "btn btn-danger",
//                cancelButtonClass: "btn btn-danger m-l-10",
//                confirmButtonText: "OK",
                  buttons: false,
                  allowOutsideClick: false,
                  preConfirm: function () {
                      location.reload();
                  }

              })
         }
         }     
     })
}
function downFile(att) {

	var filename =att;
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadBulkUploadFailedComposite?filename=" + filename;
}                