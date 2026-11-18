 window.onload = function() {
     //alert("ggggg")
     $('#department').focus();
     
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/DepartmentDetails";
     
     var serviceUrl = serviceUrl;
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {



             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
//                 scrollX: true,
                  "pageLength": 5,
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });

 }



var callToolTip231 = function(fieldName, status) {

    if (fieldName == "department") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Department Name<span>";
    }
     else if (fieldName == "department1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Character only for Department Name<span>";
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

$('#department').on('focusout', function() {
    var usertype = $('#department').val();

    if (usertype.trim() == "") {
        callToolTip231('department', 'show');
    }
    else {
        callToolTip231('department', 'hide');
    }
});

$('#department').on('focus', function() {
callToolTip231('department', 'destroy');
callToolTip231('department1', 'destroy');
});
function validateDepartment() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;
    if ($('#department').val().trim() === '') {
        callToolTip231('department', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     else if (!$('#department').val().trim().match(alphaExp))
    {
        callToolTip231('department1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In department: "+indexError);
    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}


$("#submit-btn").click(function() {
    //alert("dgfsgf");
    if (!validateDepartment()) {
//        alert("fail")
        event.preventDefault();
    } else {
//        alert("pass")
        saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {
    $("#department").val("");
     callToolTip231('department', 'hide');
     callToolTip231('department1', 'hide');
});

//insert data
function saveDataCompany()  {
//alert("gdfsf"+$("#company").val());
//    swal({
//        title: "Are you sure?",
//        text: "You want to Insert?",
//        type: "warning",
//        width: 350,
//        height: 200,
//        showCancelButton: !0,
//        confirmButtonClass: "btn btn-success",
//        cancelButtonClass: "btn btn-danger m-l-10",
//        confirmButtonText: "Yes, ADD it!"
//    }).then(function() {
	
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/add_Department";
	
     $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'department=' + $("#department").val()
        }).done(function(data) {
            // alert("hgdjghd"+data)

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
                        window.location.href = base_url + "/Admin/DepartmentMaster";
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
                        window.location.href = base_url + "/Admin/DepartmentMaster";
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
                        window.location.href = base_url + "/Admin/DepartmentMaster";
                    }

                });

              }
        });
    //});
            }  


function DeleteDepartment(srno)  {
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
        //  alert("deleteUserdddddddd")
    	
    	 var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/DeleteDepartment";
      
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'crno=' + srno

        }).done(function(data) {
            //  alert("dfgsfd"+data)

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
                        window.location.href = base_url + "/Admin/DepartmentMaster";
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
                        window.location.href = base_url + "/Admin/DepartmentMaster";
                    }

                });

              }
        });
    });
            }   
                


function EditDepartment(crno,dname) {
    
callToolTip231('department', 'destroy');
    $('#departmentnameupdate').val(dname);
     $('#sr_no1').val(crno);

    $("#modeldepartment1").modal("show");

}

$("#update_Department_btn").click(function() {
    if (!validateDepartmentUpdate())
    {
//        alert("fail")
        event.preventDefault();
    } else if (validateDepartmentUpdate())
    {
//        alert("pass")
    updatecompanySave111();
      }
}).show();

function updatecompanySave111() {
$('#departmentnameupdate').val();
     $('#sr_no1').val();
     
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updateDepartmentMasterSave";
     
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "departmentnameupdate=" + $('#departmentnameupdate').val()
                + "&cr_no=" + $('#sr_no1').val(),
                  success: function(data) {
//                      alert(data)
                    if (data == "success") {
                    swal({
                    title: "Successful!",
                    text: "Record Updated Successfully",
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
                        window.location.href = base_url + "/Admin/DepartmentMaster";
                    }
                });
            }


            else if (data == "duplicate") {
                swal({
                    title: "Duplicate!",
                    text: "Record Already Exist",
                    type: "success",
                    width: '300px',
                    height: '90px !important',
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/DepartmentMaster";
                    }
                });
            }


            else {

                swal({
                    title: "Unsuccessful!",
                    text: "Record not updated",
                    type: "error",
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
                        window.location.href = base_url + "/Admin/DepartmentMaster";
                    }
                });
            }
            
             $('#updatecompanyname').val("");
            
                  }
                   });
                   }
                   
var callToolTipUpdate = function(fieldName, status) {

    if (fieldName == "departmentnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Department name<span>";
    }
     else if (fieldName == "departmentnameupdate1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Character only for Department Name<span>";
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

$('#departmentnameupdate').on('focusout', function() {
    var usertype = $('#departmentnameupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('departmentnameupdate', 'show');
    }
    else {
        callToolTipUpdate('departmentnameupdate', 'hide');
    }
});

$('#departmentnameupdate').on('focus', function() {
callToolTipUpdate('departmentnameupdate', 'destroy');
 callToolTipUpdate('departmentnameupdate1', 'destroy');
});
function validateDepartmentUpdate() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;
    if ($('#departmentnameupdate').val().trim() === '') {
        callToolTipUpdate('departmentnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    else if (!$('#departmentnameupdate').val().trim().match(alphaExp))
    {
        callToolTipUpdate('departmentnameupdate1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In departmentnameupdate: "+indexError);
    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}
                   