 window.onload = function() {
//     alert("ggggg");
      $('#category').focus();
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getCategoryDetails";

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

                    document.getElementById("category").innerHTML = html;
             }

             
     });
     
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/SubCategoryMasterListing";
//     var serviceUrl = "SubCategoryMasterListing";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {



             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 5
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

    if (fieldName == "category") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Category Name<span>";
    }
    else if (fieldName == "group") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Sub-Category Name<span>";
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
        callToolTip231('category', 'show');
    }
    else {
        callToolTip231('category', 'hide');
    }
});
$('#group').on('focusout', function() {
    var usertype = $('#group').val();

    if (usertype.trim() == "") {
        callToolTip231('group', 'show');
    }
    else {
        callToolTip231('group', 'hide');
    }
});

$('#category').on('focus', function() {
callToolTip231('category', 'destroy');
});
$('#group').on('focus', function() {
callToolTip231('group', 'destroy');
});
function validateGroup() {
    var indexError = 0;
   
    if ($('#category').val().trim() === '') {
        callToolTip231('category', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#group').val().trim() === '') {
        callToolTip231('group', 'show');
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
    if (!validateGroup()) {
//        alert("fail")
        event.preventDefault();
    } else {
//         alert("pass")
        saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {
    $("#category").val("");
     callToolTip231('category', 'hide');
     $("#group").val("");
     callToolTip231('group', 'hide');
});

//insert data
function saveDataCompany()  {
//alert("gdfsf:"+$("#category").val());
//alert("gdfsf:"+$("#group").val());
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
 	var serviceUrl = base_url + "/Master/SubmitGroupDetails";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'category=' + $("#category").val()
            + '&group=' + $("#group").val()
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
                        window.location.href = base_url + "/Admin/GroupMaster";
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
                        window.location.href = base_url + "/Admin/GroupMaster";
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
                        window.location.href = base_url + "/Admin/GroupMaster";
                    }

                });

              }
        });
    //});
            }  


function Deletegroup(srno)  {
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
     	var serviceUrl = base_url + "/Master/deletegroup";
    	      
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
                        window.location.href = base_url + "/Admin/GroupMaster";
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
                        window.location.href = base_url + "/Admin/GroupMaster";
                    }

                });

              }
        });
    });
            }   
                


function EditGroup(crno,catname,grpname) {
    
    callToolTip231('category', 'destroy');

callToolTip231('group', 'destroy');
//    alert("dfdgsf"+crno)
//      alert("dfdgsf"+catname)
//        alert("dfdgsf"+grpname)
        $("#sr_no1").val(crno);
        $("#categorynameupdate").val(catname);
        $("#groupnameupdate").val(grpname);
        
   
   $("#modelgroup1").modal("show");
}

$("#update_GroupType_btn").click(function() {
    if (!validateGroupUpdate())
    {
        event.preventDefault();
    } else if (validateGroupUpdate())
    {
    updateCategorySave111();
      }
}).show();

function updateCategorySave111() {

	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updateGroupMasterSave";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "categorynameupdate=" + $('#categorynameupdate').val()
                + "&groupnameupdate=" + $("#groupnameupdate").val()
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
                        window.location.href = base_url + "/Admin/GroupMaster";
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
                        window.location.href = base_url + "/Admin/GroupMaster";
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
                        window.location.href = base_url + "/Admin/GroupMaster";
                    }
                });
            }
            
             $('#updatecompanyname').val("");
            
                  }
                   });
                   }
                   
var callToolTipUpdate = function(fieldName, status) {

    if (fieldName == "categorynameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Category Name<span>";
    }
    else if (fieldName == "groupnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Sub-Category Name<span>";
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

$('#categorynameupdate').on('focusout', function() {
    var usertype = $('#categorynameupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('categorynameupdate', 'show');
    }
    else {
        callToolTipUpdate('categorynameupdate', 'hide');
    }
});
$('#groupnameupdate').on('focusout', function() {
    var usertype = $('#groupnameupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('groupnameupdate', 'show');
    }
    else {
        callToolTipUpdate('groupnameupdate', 'hide');
    }
});

$('#categorynameupdate').on('focus', function() {
callToolTipUpdate('categorynameupdate', 'destroy');
});
$('#groupnameupdate').on('focus', function() {
callToolTipUpdate('groupnameupdate', 'destroy');
});
function validateGroupUpdate() {
    var indexError = 0;
   
    if ($('#categorynameupdate').val().trim() === '') {
        callToolTipUpdate('categorynameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#groupnameupdate').val().trim() === '') {
        callToolTipUpdate('groupnameupdate', 'show');
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
                   