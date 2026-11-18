window.onload = function() {
     //alert("ggggg")
      $('#company').focus();
      
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/CompanyDetails";
//     var serviceUrl = "CompanyDetails";
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

 };

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

    if (fieldName == "company") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Company Name<span>";
        
    } else if (fieldName == "companyemail") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Company Email-ID<span>";
        
    } else if (fieldName == "companyemailwrong") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Valid Company Email-ID<span>";
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
        callToolTip231('company', 'show');
    }
    else {
        callToolTip231('company', 'hide');
    }
});
$('#companyemail').on('focusout', function() {
    var usertype = $('#companyemail').val();

    if (usertype.trim() == "") {
        callToolTip231('companyemail', 'show');
    }
    else {
        callToolTip231('companyemail', 'hide');
    }
});

$('#company').on('focus', function() {
callToolTip231('company', 'destroy');
});
$('#companyemail').on('focus', function() {
callToolTip231('companyemail', 'destroy');
callToolTip231('companyemailwrong', 'hide');
});
function validateComp() {
    var indexError = 0;
   
    if ($('#company').val() === '') {
        callToolTip231('company', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("in compname :"+indexError)
        
    } 
    if ($('#companyemail').val() === '') {
        callToolTip231('companyemail', 'show');
        callToolTip231('companyemailwrong', 'hide');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("in companyemail :"+indexError)
    } else if (!validateEmail() && $('#companyemail').val() !== '') {
        callToolTip231('companyemailwrong', 'show');
        callToolTip231('companyemail', 'hide');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("in company validate :"+indexError)
    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}
function validateEmail() {
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
    var emailField = $('#companyemail').val();
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(emailField) == false)
    {
        //callToolTipWrong('email', 'show');
//        alert("false")
        ret = false;
    }
    else
    {
//         alert("true")
        ret = true;
    }
    return ret;
}

$("#submit-btn").click(function() {
    //alert("dgfsgf");
    if (!validateComp()) {
//        alert("fail")
        event.preventDefault();
    } else {
//         alert("pass")
       saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {
    $("#company").val("");
     callToolTip231('company', 'hide');
     $("#companyemail").val("");
     callToolTip231('companyemail', 'hide');
     callToolTip231('companyemailwrong', 'hide');
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
 	var serviceUrl = base_url + "/Master/addcompany";
 	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'company=' + $("#company").val()
                + '&companyemail=' + $("#companyemail").val()
        }).done(function(data) {
//             alert("hgdjghd"+data)

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
                        window.location.href = base_url + "/Admin/CompanyMaster";
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
                        window.location.href = base_url + "/Admin/CompanyMaster";
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
                        window.location.href = base_url + "/Admin/CompanyMaster";
                    }

                });

              }
        });
    //});
            }  


function Deletecompany(srno)  {
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
     	var serviceUrl = base_url + "/Master/deletecompany";
//        var serviceUrl = "deletecompany";
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
                        window.location.href = base_url + "/Admin/CompanyMaster";
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
                        window.location.href = base_url + "/Admin/CompanyMaster";
                    }

                });

              }
        });
    });
            }   
                


function Editcompany(crno) {
//    alert(crno)
callToolTip231('company', 'destroy');
callToolTip231('companyemail', 'destroy');
    
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/updateCompanyMaster";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: "json",
        data: 'crno=' + crno
    }).done(function(data) {
//         alert(data);
//        alert(data[0]['C_NAME']);
//         alert(data[0]["C_MAIL"]);
       
            $('#companynameupdate').val(data[0]['C_NAME']);
             $('#companyemailupdate').val(data[0]["C_MAIL"]);
              $('#sr_no1').val(crno);
         
    });
   $("#modelcompany1").modal("show");
}

$("#update_CompanyType_btn").click(function() {
    if (!validateCompUpdate())
    {
        event.preventDefault();
    } else if (validateCompUpdate())
    {
    updatecompanySave111();
      }
}).show();

function updatecompanySave111() {
//alert("dgsf"+ $('#companynameupdate').val())
//alert("dgsf"+ $('#companyemailupdate').val())
//alert("dgsf"+ $('#sr_no1').val());

	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updatecompanySave";
     
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "companynameupdate=" + $('#companynameupdate').val()
                + "&cr_no=" + $('#sr_no1').val()
         + "&companyemailupdate=" + $('#companyemailupdate').val(),
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
                        window.location.href = base_url + "/Admin/CompanyMaster";
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
                        window.location.href = base_url + "/Admin/CompanyMaster";
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
                        window.location.href = base_url + "/Admin/CompanyMaster";
                    }
                });
            }
            
             $('#updatecompanyname').val("");
            
                  }
                   });
}
                   
var callToolTipUpdate = function(fieldName, status) {

    if (fieldName == "companynameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Company Name<span>";
        
    } else if (fieldName == "companyemailupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Company Email-ID<span>";
        
    } else if (fieldName == "companyemailupdatewrong") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Valid Company Email-ID<span>";
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

$('#companynameupdate').on('focusout', function() {
    var usertype = $('#companynameupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('companynameupdate', 'show');
    }
    else {
        callToolTipUpdate('companynameupdate', 'hide');
    }
});
$('#companyemailupdate').on('focusout', function() {
    var usertype = $('#companyemailupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('companyemailupdate', 'show');
    }
    else {
        callToolTipUpdate('companyemailupdate', 'hide');
    }
});

$('#companynameupdate').on('focus', function() {
callToolTipUpdate('companynameupdate', 'destroy');
});
$('#companyemailupdate').on('focus', function() {
callToolTipUpdate('companyemailupdate', 'destroy');
callToolTipUpdate('companyemailupdatewrong', 'hide');
});
function validateCompUpdate() {
    var indexError = 0;
   
    if ($('#companynameupdate').val() === '') {
        callToolTipUpdate('companynameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("in companynameupdate :"+indexError)
        
    } 
    if ($('#companyemailupdate').val() === '') {
        callToolTipUpdate('companyemailupdate', 'show');
        callToolTipUpdate('companyemailupdatewrong', 'hide');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("in companyemailupdate :"+indexError)
        
    } else if (!validateEmailUpdate() && $('#companyemailupdate').val() !== '') {
        callToolTipUpdate('companyemailupdatewrong', 'show');
        callToolTipUpdate('companyemailupdate', 'hide');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("in company validate update :"+indexError)
    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}
function validateEmailUpdate() {
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
    var emailField = $('#companyemailupdate').val();
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(emailField) == false)
    {
        //callToolTipWrong('email', 'show');
//        alert("false")
        ret = false;
    }
    else
    {
//         alert("true")
        ret = true;
    }
    return ret;
}
                   