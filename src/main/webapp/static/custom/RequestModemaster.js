 window.onload = function() {
	 
	 
	 
	 
	 
	    var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/getCompositeCompanyList";

	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
	         success: function(data2) {
	           //  alert(data2)
	        	 var html = "  <option value=''> -- Please Select --</option>";
	                    for (var i = 0; i < data2.length; i++) {
	                        html += '<option value="' + data2[i] + '">' + data2[i]
	                                + '</option>';
	                        
	              //          alert("COMAPNY LIST   " ,data2[i]);
	                    }
	                    document.getElementById("company").innerHTML = html;
	             }
	});
	 
	 
     //alert("ggggg")
//     $('#requestmode').focus();
     
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/RequestModeDetails";
     
   $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {



             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
                 scrollY: true,
                  "pageLength": 5,
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });

 }



var callToolTip231 = function(fieldName, status) {

    if (fieldName == "requestmode") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Request Mode<span>";
    }
    else if (fieldName == "companyDiv") {
        var errorMessage = "<span>Please  Select Company<span>";
    }
     else if (fieldName == "requestmode1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Character only for Request Mode <span>";
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


$('#requestmode').on('focusout', function() {
    var usertype = $('#requestmode').val();

    if (usertype.trim() == "") {
        callToolTip231('requestmode', 'show');
    }
    else {
        callToolTip231('requestmode', 'hide');
    }
});

$('#companyDiv').on('click', function() {
	callToolTip231('companyDiv', 'destroy');
	});


$('#requestmode').on('focus', function() {
callToolTip231('requestmode', 'destroy');
callToolTip231('requestmode1', 'destroy');
});
function validateRequestMode() {
    var indexError = 0;
    
    
    if ($('#company').val().trim() === '') {
        callToolTip231('companyDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    
    }
    var alphaExp = /^[a-zA-Z '.-]+$/;
    if ($('#requestmode').val().trim() === '') {
        callToolTip231('requestmode', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     else if (!$('#requestmode').val().trim().match(alphaExp))
    {
        callToolTip231('requestmode1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In requestmode: "+indexError);
    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}


$("#submit-btn").click(function() {
    //alert("dgfsgf");
    if (!validateRequestMode()) {
//        alert("fail")
        event.preventDefault();
    } else {
//        alert("pass")
        saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {
	
	//alert("ggg");
    $("#requestmode").val("");
	$("#company").val("");
     callToolTip231('requestmode', 'hide');
     callToolTip231('requestmode1', 'hide');
     callToolTip231('companyDiv', 'hide');
});

//insert data
function saveDataCompany()  {

	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/addRequestMode";
	      
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'requestmode=' + $("#requestmode").val() +
            '&company=' + encodeURIComponent($("#company").val())
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
                        window.location.href = base_url + "/Admin/RequestModeMaster";
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
                        window.location.href = base_url + "/Admin/RequestModeMaster";
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
                        window.location.href = base_url + "/Admin/RequestModeMaster";
                    }

                });

              }
        });
    //});
            }  


function DeleteRequestMode(srno)  {
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
     	var serviceUrl = base_url + "/Master/DeleteRequestMode";
    
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
                        window.location.href = base_url + "/Admin/RequestModeMaster";
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
                        window.location.href = base_url + "/Admin/RequestModeMaster";
                    }

                });

              }
        });
    });
            }   
                


function EditRequestMode(crno,Rname,company) {
  //  alert(""hiiii)
callToolTip231('requestmode', 'destroy');
    $('#requestmodeupdate').val(Rname);
    $('#companyupdate').val(company);
     $('#sr_no1').val(crno);

    $("#modelrequestmode1").modal("show");

}

$("#update_RequestMode_btn").click(function() {
    if (!validateRequestModeUpdate())
    {
//        alert("fail")
        event.preventDefault();
    } else if (validateRequestModeUpdate())
    {
//        alert("pass")
    updatecompanySave111();
      }
}).show();

function updatecompanySave111() {
$('#requestmodeupdate').val();

     $('#sr_no1').val();
     
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updateRequestModeSave";
     
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "requestmodeupdate=" + $('#requestmodeupdate').val()
                + "&companyupdate=" + encodeURIComponent($('#companyupdate').val())
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
                        window.location.href = base_url + "/Admin/RequestModeMaster";
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
                        window.location.href = base_url + "/Admin/RequestModeMaster";
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
                        window.location.href = base_url + "/Admin/RequestModeMaster";
                    }
                });
            }
            
             $('#updatecompanyname').val("");
            
                  }
                   });
                   }
                   
var callToolTipUpdate = function(fieldName, status) {

    if (fieldName == "requestmodeupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Request Mode name<span>";
    }
     else if (fieldName == "requestmodeupdate1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Character only for Request Mode Name<span>";
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

$('#requestmodeupdate').on('focusout', function() {
    var usertype = $('#requestmodeupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('requestmodeupdate', 'show');
    }
    else {
        callToolTipUpdate('requestmodeupdate', 'hide');
    }
});

$('#requestmodeupdate').on('focus', function() {
callToolTipUpdate('requestmodeupdate', 'destroy');
 callToolTipUpdate('requestmodeupdate1', 'destroy');
});
function validateRequestModeUpdate() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;
    if ($('#requestmodeupdate').val().trim() === '') {
        callToolTipUpdate('requestmodeupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    else if (!$('#requestmodeupdate').val().trim().match(alphaExp))
    {
        callToolTipUpdate('requestmodeupdate1', 'show');
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

                   