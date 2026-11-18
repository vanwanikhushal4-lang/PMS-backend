 window.onload = function() {
//     alert("ggggg");
     
     $('#usertype').focus();
     
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/MailConfig/EmailAuthListing";
   
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {

             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
                 scrollX: true,
                  "pageLength": 5
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });
 };
 function getUserDetails(username)
 {
//     alert("in user: "+username);
	
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/MailConfig/getUserDetails";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
          data: 'username=' + username,
           
         success: function(data4) {
//             alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("user").innerHTML = html;
             }

             
     });
 }
 
function validateCompany() {
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
    var companyField = $('#company').val();
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(companyField) == false)
    {
        //callToolTipWrong('email', 'show');
        ret = false;
    }
    else
    {
        ret = true;
    }
    return ret;
}


var callToolTip231 = function(fieldName, status) {

    if (fieldName == "usertype") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please User Type<span>";
    }
    else if (fieldName == "user") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select User Name<span>";
    }
    else if (fieldName == "authentication") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Authentication<span>";
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

$('#usertype').on('focusout', function() {
    var usertype = $('#usertype').val();

    if (usertype.trim() == "") {
        callToolTip231('usertype', 'show');
    }
    else {
        callToolTip231('usertype', 'hide');
    }
});
$('#user').on('focusout', function() {
    var usertype = $('#user').val();

    if (usertype.trim() == "") {
        callToolTip231('user', 'show');
    }
    else {
        callToolTip231('user', 'hide');
    }
});
$('#authentication').on('focusout', function() {
    var usertype = $('#authentication').val();

    if (usertype.trim() == "") {
        callToolTip231('authentication', 'show');
    }
    else {
        callToolTip231('authentication', 'hide');
    }
});

$('#usertype').on('focus', function() {
callToolTip231('usertype', 'destroy');
});
$('#user').on('focus', function() {
callToolTip231('user', 'destroy');
});
$('#authentication').on('focus', function() {
callToolTip231('authentication', 'destroy');
});
function validateEmailAuth() {
    var indexError = 0;
   
    if ($('#usertype').val().trim() === '') {
        callToolTip231('usertype', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#user').val().trim() === '') {
        callToolTip231('user', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#authentication').val().trim() === '') {
        callToolTip231('authentication', 'show');
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
    //alert("dgfsgf");
    if (!validateEmailAuth()) {
//        alert("fail")
        event.preventDefault();
    } else {
//           alert("pass")
        saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {
    $("#usertype").val("");
     callToolTip231('usertype', 'hide');
      $("#user").val("");
     callToolTip231('user', 'hide');
      $("#authentication").val("");
     callToolTip231('authentication', 'hide');
});

//insert data
function saveDataCompany()  {
//alert("gdfsf:"+$("#usertype :selected").val());
//alert("gdfsf:"+$("#user :selected").val());
//alert("gdfsf:"+$("#authentication:selected").val());
var usertype=$("#usertype :selected").val();
var user=$("#user :selected").val();
var authentication=$("#authentication :selected").val();

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/MailConfig/SubmitEmailAuthDetails";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'usertype=' + usertype
            + '&user=' + user
            + '&authentication=' + authentication
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
                        window.location.href = base_url + "/Admin/EmailAuth";
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
                        window.location.href = base_url + "/Admin/EmailAuth";
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
                        window.location.href = base_url + "/Admin/EmailAuth";
                    }

                });

              }
        });
    //});
            }  


function Deletemailauth(srno)  {
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
     	var serviceUrl = base_url + "/MailConfig/deletemailauth";

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
                        window.location.href = base_url + "/Admin/EmailAuth";
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
                        window.location.href = base_url + "/Admin/EmailAuth";
                    }

                });

              }
        });
    });
            }   

function Editemailauth(crno,USER_TYPE,USER_NAME,MAIL_AUTH) {
callToolTip231('usertype', 'destroy');
callToolTip231('user', 'destroy');
callToolTip231('authentication', 'destroy');
//    
$('#usertypeupdate').val(USER_TYPE);
$('#usernameupdate').val(USER_NAME);
$('#authenticationupdate').val(MAIL_AUTH);
$('#sr_no1').val(crno);

    $("#modelcompanyemailauth").modal("show");

}

$("#update_EmailAuthType_btn").click(function() {
//    if (!validateEmailAuthUpdate())
//    {
//        alert("fail")
//        event.preventDefault();
//    } else if (updateUserCheck())
//    {
//        alert("pass")
    UpdateEmailAuthUpdate();
//      }
}).show();

function UpdateEmailAuthUpdate() {
$('#usertypeupdate').val();
$('#usernameupdate').val();
$('#authenticationupdate').val();
$('#sr_no1').val();

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/MailConfig/updateEmailAuthSave";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "usertypeupdate=" + $('#usertypeupdate').val()
            + "&usernameupdate=" + $('#usernameupdate').val()
            + "&authenticationupdate=" + $('#authenticationupdate').val()
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
                        window.location.href = base_url + "/Admin/EmailAuth";
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
                        window.location.href = base_url + "/Admin/EmailAuth";
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
                        window.location.href = base_url + "/Admin/EmailAuth";
                    }
                });
            }
            
             $('#updatecompanyname').val("");
            
                  }
                   });
                   }
 

//function validateEmailAuthUpdate() {
//    var indexError = 0;
//   
//    if ($('#callToolTipUpdate').val().trim() === '') {
//        callToolTipUpdate('callToolTipUpdate', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//    if (indexError > 0) {
//        return false;
//
//    } else {
//        return true;
//    }
//}