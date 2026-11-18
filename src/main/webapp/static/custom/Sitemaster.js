 window.onload = function() {
//     alert("ggggg");
      $('#company').focus();
      var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompanyDetails";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
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

                    document.getElementById("company").innerHTML = html;
             }

             
     });
     var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/SiteMasterListing";
//     var serviceUrl = "SiteMasterListing";
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
        var errorMessage = "<span>Please Select Company Name<span>";
    }
    else if (fieldName == "branch") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Branch Name<span>";
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
$('#branch').on('focusout', function() {
    var usertype = $('#branch').val();

    if (usertype.trim() == "") {
        callToolTip231('branch', 'show');
    }
    else {
        callToolTip231('branch', 'hide');
    }
});

$('#company').on('focus', function() {
callToolTip231('company', 'destroy');
});
$('#branch').on('focus', function() {
callToolTip231('branch', 'destroy');
});
function validateSite(){
    var indexError = 0;
   
    if ($('#company').val().trim() === '') {
        callToolTip231('company', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#branch').val().trim() === '') {
        callToolTip231('branch', 'show');
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
    if (!validateSite()) {
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
     $("#branch").val("");
     callToolTip231('branch', 'hide');
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
 	var serviceUrl = base_url + "/Master/SubmitSiteDetails";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'company=' + $("#company").val()
            + '&branch=' + $("#branch").val()
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
                        window.location.href = base_url + "/Admin/SiteMaster";
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
                        window.location.href = base_url + "/Admin/SiteMaster";
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
                        window.location.href = base_url + "/Admin/SiteMaster";
                    }

                });

              }
        });
    //});
            }  


function Deletesite(srno)  {
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
     	var serviceUrl = base_url + "/Master/deletesite";
    	
        var serviceUrl = serviceUrl;
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
                        window.location.href = base_url + "/Admin/SiteMaster";
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
                        window.location.href = base_url + "/Admin/SiteMaster";
                    }

                });

              }
        });
    });
            }   
                

var useriddd12;
function EditSite(crno,cname,sname) {
    callToolTip231('company', 'destroy');

callToolTip231('branch', 'destroy');
//    alert("dfdgsf"+crno)
//    alert("dfdgsf"+cname)
    $("#companynameupdate").val(cname);
    $("#sitenameupdate").val(sname);
    $("#sr_no1").val(crno);
   
   $("#modelsite1").modal("show");
}

$("#update_SiteType_btn").click(function() {
    if (!validateSiteUpdate())
    {
        event.preventDefault();
    } else if (validateSiteUpdate())
    {
    updateBranchSave111();
      }
}).show();

function updateBranchSave111() {
$("#companynameupdate").val();
    $("#sitenameupdate").val();
    $("#sr_no1").val();
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/updateSiteMasterSave";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "companynameupdate=" + $('#companynameupdate').val()
                + "&sitenameupdate=" + $("#sitenameupdate").val()
         + "&cr_no=" + $("#sr_no1").val(),
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
                        window.location.href = base_url + "/Admin/SiteMaster";
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
                        window.location.href = base_url + "/Admin/SiteMaster";
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
                        window.location.href = base_url + "/Admin/SiteMaster";
                    }
                });
            }
            
             $('#updatecompanyname').val("");
            
                  }
                   });
                   }
                   
var callToolTipUpdate = function(fieldName, status) {

   
 if (fieldName == "sitenameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Branch Name<span>";
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


$('#sitenameupdate').on('focusout', function() {
    var usertype = $('#sitenameupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('sitenameupdate', 'show');
    }
    else {
        callToolTipUpdate('sitenameupdate', 'hide');
    }
});


$('#sitenameupdate').on('focus', function() {
callToolTipUpdate('sitenameupdate', 'destroy');
});
function validateSiteUpdate(){
    var indexError = 0;
   

    if ($('#sitenameupdate').val().trim() === '') {
        callToolTipUpdate('sitenameupdate', 'show');
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
                   