 window.onload = function() {
     //alert("ggggg")
     $('#priority').focus();
     
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/PriorityDetails";
    
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

    if (fieldName == "priority") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Priority Name<span>";
    }
     else if (fieldName == "priority1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Character only for Priority Name<span>";
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

$('#priority').on('focusout', function() {
    var usertype = $('#priority').val();

    if (usertype.trim() == "") {
        callToolTip231('priority', 'show');
    }
    else {
        callToolTip231('priority', 'hide');
    }
});

$('#priority').on('focus', function() {
callToolTip231('priority', 'destroy');
callToolTip231('priority1', 'destroy');
});
function validatePriority() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;
    if ($('#priority').val().trim() === '') {
        callToolTip231('priority', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     else if (!$('#priority').val().trim().match(alphaExp))
    {
        callToolTip231('priority1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In priority: "+indexError);
    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}


$("#submit-btn").click(function() {
 
        saveAuthenticatorType();
    
}).show();

$("#resetbtn").click(function() {
    $("#priority").val("");
     callToolTip231('priority', 'hide');
     callToolTip231('priority1', 'hide');
});

//insert data
function saveAuthenticatorType()  {
	 //  alert("Hii")
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
 	var serviceUrl = base_url + "/Master/saveAuthenticatorType";
	
        var serviceUrl = serviceUrl;
        
      var value1 = $("input[type=radio][name=mfa]:checked").val();
      //  alert(value1)
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'mfaType=' + value1
        }).done(function(data) {
           // alert("hgdjghd"+data)

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
                        window.location.href = base_url + "/Admin/AuthenticationMaster";
                    }

                });

            }
             else if (data == "insert") {
                swal({
                    title: "Insert Data!",
                    text: "Record Inserted Successfully",
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
                        window.location.href = base_url + "/Admin/AuthenticationMaster";
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
                        window.location.href = base_url + "/Admin/AuthenticationMaster";
                    }

                });

              }
        });
    //});
            }  


function Deletepriority(srno)  {
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
     	var serviceUrl = base_url + "/Master/Deletepriority";
    	
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
                        window.location.href = base_url + "/Admin/PriorityMaster";
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
                        window.location.href = base_url + "/Admin/PriorityMaster";
                    }

                });

              }
        });
    });
            }   
                


function EditPriority(crno,pname) {
    
callToolTip231('priority', 'destroy');
    $('#prioritynameupdate').val(pname);
     $('#sr_no1').val(crno);

    $("#modelpriority1").modal("show");

}

$("#update_PriorityType_btn").click(function() {
    if (!validatePriorityUpdate())
    {
//        alert("fail")
        event.preventDefault();
    } else if (validatePriorityUpdate())
    {
//        alert("pass")
    updatecompanySave111();
      }
}).show();

function updatecompanySave111() {
$('#prioritynameupdate').val();
     $('#sr_no1').val();
     
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updatePriorityMasterSave";
     
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "prioritynameupdate=" + $('#prioritynameupdate').val()
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
                        window.location.href = base_url + "/Admin/PriorityMaster";
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
                        window.location.href = base_url + "/Admin/PriorityMaster";
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
                        window.location.href = base_url + "/Admin/PriorityMaster";
                    }
                });
            }
            
             $('#updatecompanyname').val("");
            
                  }
                   });
                   }
                   
var callToolTipUpdate = function(fieldName, status) {

    if (fieldName == "prioritynameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Priority name<span>";
    }
     else if (fieldName == "prioritynameupdate1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Character only for Priority Name<span>";
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

$('#prioritynameupdate').on('focusout', function() {
    var usertype = $('#prioritynameupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('prioritynameupdate', 'show');
    }
    else {
        callToolTipUpdate('prioritynameupdate', 'hide');
    }
});

$('#prioritynameupdate').on('focus', function() {
callToolTipUpdate('prioritynameupdate', 'destroy');
 callToolTipUpdate('prioritynameupdate1', 'destroy');
});
function validatePriorityUpdate() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;
    if ($('#prioritynameupdate').val().trim() === '') {
        callToolTipUpdate('prioritynameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    else if (!$('#prioritynameupdate').val().trim().match(alphaExp))
    {
        callToolTipUpdate('prioritynameupdate1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In priority: "+indexError);
    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}
                   