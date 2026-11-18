 window.onload = function() {
//     $('#companyName').focus();
//     
     //GET COMPANY DETAILS
	 	var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
	           async: false,
	         success: function(data4) {
	                    var html = "  <option value=''> -- Please Select --</option>";
	                    for (var i = 0; i < data4.length; i++) {
	                        html += '<option value="' + data4[i] + '">' + data4[i]
	                                + '</option>';
	                    }

	                    document.getElementById("companyName").innerHTML = html;
	                    document.getElementById("companyNameupdate").innerHTML = html;
	             }
	     });

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
             scrollX: true,
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
    	
        var errorMessage = "<span>Please Enter Priority <span>";
    }
     else if (fieldName == "priority1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Character only for Priority <span>";
    } else if (fieldName == 'companyName') {
    	var errorMessage = "<span>Please Select Company<span>";
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

$('#companyName').on('focusout', function() {
	var usertype = $('#companyName').val();
	if(usertype.trim() == "") {
		callToolTip231('companyName', 'show');
	} else {
		callToolTip231('companyName', 'hide');
	}
});

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

$('#companyName').on('focus', function() {
	callToolTip231('companyName', 'destroy');
});
function validatePriority() {
    var indexError = 0;
    if ($('#priority').val().trim() === '') {
        callToolTip231('priority', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }

    if ($('#companyName').val().trim() === '') {
        callToolTip231('companyName', 'show');
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
    if (!validatePriority()) {
//        alert("fail")
        event.preventDefault();
    } else {
//        alert("pass")
        saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {
    $("#priority").val("");
     callToolTip231('priority', 'hide');
     callToolTip231('priority1', 'hide');
    $("#companyName").val("");
    callToolTip231('companyName', 'hide');
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
 	var serviceUrl = base_url + "/Master/addpriority";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'priority=' +encodeURIComponent( $("#priority").val())
            		+ '&company=' + encodeURIComponent($("#companyName").val())
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
                        window.location.href = base_url + "/Admin/PriorityMaster";
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
                        window.location.href = base_url + "/Admin/PriorityMaster";
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
                        window.location.href = base_url + "/Admin/PriorityMaster";
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
                


function EditPriority(crno,cname,pname) {
    
	callToolTip231('priority', 'destroy');
    $('#prioritynameupdate').val(pname);
    $('#sr_no1').val(crno);
    $('#companyNameupdate').val(cname);
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
	$('#companyNameupdate').val();
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updatePriorityMasterSave";
     
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "prioritynameupdate=" + encodeURIComponent($('#prioritynameupdate').val())
        		+ "&company=" + encodeURIComponent($('#companyNameupdate').val())
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
                    type: "warning",
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
        var errorMessage = "<span>Please Enter Priority <span>";
    }
     else if (fieldName == "prioritynameupdate1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Character only for Priority <span>";
    } else if (fieldName == "companyNameupdate") {
    	var errorMessage = "<span>Please Select Company<span>";
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

$('#companyNameupdate').on('focusout', function() {
    var usertype = $('#companyNameupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('companyNameupdate', 'show');
    }
    else {
        callToolTipUpdate('companyNameupdate', 'hide');
    }
});

$('#prioritynameupdate').on('focus', function() {
	callToolTipUpdate('prioritynameupdate', 'destroy');
	callToolTipUpdate('prioritynameupdate1', 'destroy');
});
$('#companyNameupdate').on('focus', function() {
	callToolTipUpdate('companyNameupdate', 'destroy');
});
function validatePriorityUpdate() {
    var indexError = 0;
    if ($('#prioritynameupdate').val().trim() === '') {
        callToolTipUpdate('prioritynameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#companyNameupdate').val().trim() === '') {
        callToolTipUpdate('companyNameupdate', 'show');
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
                   