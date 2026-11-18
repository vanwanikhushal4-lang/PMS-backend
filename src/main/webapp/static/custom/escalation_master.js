window.onload = function () {
	//alert("ggggg");
	 var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/getCompositecompanyDetails";
//	      var serviceUrl = "getDepartmentDetails";
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
//	         data: 'companyname=' + $("#cname").val(),
	         success: function(data4) {
//	             alert(data4)
//	            var pollingHost = data4;
//	                    var d = pollingHost.split(",");
//	                    var length = d.length - 1;
	        	 var html = "<option value=''>-- Please Select --</option>";
	                    for (var i = 0; i < data4.length; i++) {
	                        //alert(data4[i]);
	                        html += '<option value="' + data4[i] + '">' + data4[i]
	                                + '</option>';
	                    }

	                    document.getElementById("cname").innerHTML = html;
	             }

	             
	     });
     $('#toggleholdtimecalc').hide();
    $('#cname').focus();
    $('#days').val("00");
    $('#hours').val("00");
    $('#minutes').val("00");
    $('#seconds').val("00");

  $("#cname").on('change', function() {
    getPriority($("#cname").val(), '');
    getSeverity($("#cname").val(), '');
    getDesignation($("#cname").val(), '');
  });

  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/EscalationMasterListing";
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function (data4) {
//alert(data4)


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
    
    $('#username').select2({
//      theme: 'bootstrap4'
//    	tags: true,
    	placeholder: "Please Select User Name",
//        allowClear: true
    })
};
////////////////////// ONLOAD COMPLETE ///////////////////////
function getPriority(companyName, priority) {
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/Master/getCompanyPriority";
   
  var html = '<option value="">--Please Select Priority--</option>';
  document.getElementById("priority").innerHTML = html;
    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: 'companyName=' + encodeURIComponent(companyName)
    }).done(function (data) {

        var html = '<option value="">--Please Select Priority--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("priority").innerHTML = html;
    });
}

function getSeverity(companyName, severity) {
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/Master/getCompanySeverity";
  var html = '<option value="">--Please Select Severity--</option>';
  document.getElementById("severity").innerHTML = html;
     $.ajax({

         url: serviceUrl,
         type: 'POST',
         dataType: 'json',
         data: 'companyName=' + encodeURIComponent(companyName)
     }).done(function (data) {

         var html = '<option value="">--Please Select Severity--</option>';
         
         for (var i = 0; i < data.length; i++) {
             html += '<option value="' + data[i] + '">' + data[i]
                     + '</option>';
         }

         document.getElementById("severity").innerHTML = html;
     });
}

function getDesignation(companyName, priority) {
	  var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/Master/getDesignationForLoginMaster";
	   
	  var html = '<option value="">--Please Select Designation--</option>';
	  document.getElementById("designation").innerHTML = html;
	    $.ajax({

	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: 'company=' + encodeURIComponent(companyName)
	    }).done(function (data) {

	        var html = '<option value="">--Please Select Designation--</option>';
	        for (var i = 0; i < data.length; i++) {
	            html += '<option value="' + data[i] + '">' + data[i]
	                    + '</option>';
	        }

	        document.getElementById("designation").innerHTML = html;
	    });
	}

$("#designation").on('change', function() {
    getUserNamesOnDesignation($("#designation").val(), $("#cname").val());
  });

function getUserNamesOnDesignation(designation,companyName){
	 var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/Master/getUserNamesOnDesignation";
	  
	$.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: 'companyName=' + encodeURIComponent(companyName)
        		+ "&designation=" + encodeURIComponent(designation),
    }).done(function (data) {

        var html = '<option value="">--Please Select Username--</option>';
        
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("username").innerHTML = html;
    });
}

var callToolTip231 = function (fieldName, status) {

    if (fieldName == "engLevel") {
        var errorMessage = "<span>Please Select Escalation Level<span>";
    } else if (fieldName == "priority") {
        var errorMessage = "<span>Please Select Priority<span>";
    } else if (fieldName == "severity") {
        var errorMessage = "<span>Please Select Severity<span>";
    } else if (fieldName == "cname") {
        var errorMessage = "<span>Please Select Company <span>";
    } else if (fieldName == "days") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter No Of Days<span>";
    } else if (fieldName == "hours") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter No Of Hours<span>";
    } else if (fieldName == "minutes") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter No Of Minutes<span>";
    } else if (fieldName == "seconds") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter No Of Seconds<span>";
    } else if (fieldName == "wrongDays") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Days<span>";
    } else if (fieldName == "wrongHours") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Hours<span>";
    } else if (fieldName == "wrongMinutes") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Minutes<span>";
    } else if (fieldName == "wrongSeconds") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Seconds<span>";
    } else if (fieldName == "designation") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Designation<span>";
    } else if (fieldName == "usernameDiv") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Username<span>";
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

$('#cname').on('focusout', function () {
  var usertype = $('#cname').val();

  if (usertype.trim() == "") {
      callToolTip231('cname', 'show');
  } else {
      callToolTip231('cname', 'hide');
  }
});

$('#priority').on('focusout', function () {
  var usertype = $('#priority').val();

  if (usertype.trim() == "") {
      callToolTip231('priority', 'show');
  } else {
      callToolTip231('priority', 'hide');
  }
});

$('#severity').on('focusout', function () {
  var usertype = $('#severity').val();

  if (usertype.trim() == "") {
      callToolTip231('severity', 'show');
  } else {
      callToolTip231('severity', 'hide');
  }
});

$('#designation').on('focusout', function () {
	  var usertype = $('#designation').val();

	  if (usertype.trim() == "") {
	      callToolTip231('designation', 'show');
	  } else {
	      callToolTip231('designation', 'hide');
	  }
});

$('#username').on('focusout', function () {
	  var usertype = $('#username').val();

	  if (usertype.trim() == "") {
	      callToolTip231('usernameDiv', 'show');
	  } else {
	      callToolTip231('usernameDiv', 'hide');
	  }
});

$('#engLevel').on('focusout', function () {
    var usertype = $('#engLevel').val();

    if (usertype.trim() == "") {
        callToolTip231('engLevel', 'show');
    } else {
        callToolTip231('engLevel', 'hide');
    }
});
$('#days').on('focusout', function () {
    var usertype = $('#days').val();

    if (usertype.trim() == "") {
        callToolTip231('days', 'show');
    } else {
        callToolTip231('days', 'hide');
    }
});
$('#hours').on('focusout', function () {
    var usertype = $('#hours').val();

    if (usertype.trim() == "") {
        callToolTip231('hours', 'show');
    } else {
        callToolTip231('hours', 'hide');
    }
});
$('#minutes').on('focusout', function () {
    var usertype = $('#minutes').val();

    if (usertype.trim() == "") {
        callToolTip231('minutes', 'show');
    } else {
        callToolTip231('minutes', 'hide');
    }
});
$('#seconds').on('focusout', function () {
    var usertype = $('#seconds').val();

    if (usertype.trim() == "") {
        callToolTip231('seconds', 'show');
    } else {
        callToolTip231('seconds', 'hide');
    }
});

$('#priority').on('focus', function () {
  callToolTip231('priority', 'destroy');
});
$('#severity').on('focus', function () {
  callToolTip231('severity', 'destroy');
});
$('#designation').on('focus', function () {
	  callToolTip231('designation', 'destroy');
});
$('#usernameDiv').on('click', function () {
	  callToolTip231('usernameDiv', 'destroy');
});
$('#cname').on('focus', function () {
  callToolTip231('cname', 'destroy');
});
$('#engLevel').on('focus', function () {
    callToolTip231('engLevel', 'destroy');
});
$('#days').on('focus', function () {
    callToolTip231('days', 'destroy');
    callToolTip231('wrongDays', 'destroy');
});
$('#hours').on('focus', function () {
    callToolTip231('hours', 'destroy');
    callToolTip231('wrongHours', 'destroy');
});
$('#minutes').on('focus', function () {
    callToolTip231('minutes', 'destroy');
    callToolTip231('wrongMinutes', 'destroy');
});
$('#seconds').on('focus', function () {
    callToolTip231('seconds', 'destroy');
    callToolTip231('wrongSeconds', 'destroy');
});
function validateEscalation() {
    var indexError = 0;

    if ($('#priority').val().trim() === '') {
        callToolTip231('priority', 'show');
        if (indexError == 0) {
  
        }
        indexError = indexError + 1;
    }
    if ($('#cname').val().trim() === '') {
        callToolTip231('cname', 'show');
        if (indexError == 0) {
  
        }
        indexError = indexError + 1;
    }
    if ($('#severity').val().trim() === '') {
        callToolTip231('severity', 'show');
        if (indexError == 0) {
  
        }
        indexError = indexError + 1;
    }
    if ($('#designation').val().trim() === '') {
        callToolTip231('designation', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#username').val().trim() === '') {
        callToolTip231('usernameDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#engLevel').val().trim() === '') {
        callToolTip231('engLevel', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#days').val().trim() === '') {
        callToolTip231('days', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else if (!DaysInput())
    {
       indexError = indexError + 1;
         console.log("In invalid contact number: "+indexError);

    }
    if ($('#hours').val().trim() === '') {
        callToolTip231('hours', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else if (!HoursInput())
    {
       indexError = indexError + 1;
         console.log("In invalid contact number: "+indexError);

    }
    if ($('#minutes').val().trim() === '') {
        callToolTip231('minutes', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else if (!MinutesInput())
    {
       indexError = indexError + 1;
         console.log("In invalid contact number: "+indexError);

    }
    if ($('#seconds').val().trim() === '') {
        callToolTip231('seconds', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else if (!SecondsInput())
    {
       indexError = indexError + 1;
         console.log("In invalid contact number: "+indexError);

    }
    
    if (($('#days').val().trim() === '00' || $('#days').val().trim() === '0') && ($('#hours').val().trim() === '00' || $('#hours').val().trim() === '0') && ($('#minutes').val().trim() === '00' || $('#minutes').val().trim() === '0') && ($('#seconds').val().trim() === '00' || $('#seconds').val().trim() === '0')) {

    	swal({
                title: "Alert!",
                text: "Time not set for Escalation",
                type: "error",
                width: 300,
                height: 200,
                buttons: false,
                allowOutsideClick: false,

            });
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


$("#submit-btn").click(function () {
//	
    //alert("dgfsgf");
    if (!validateEscalation()) {
    	
//        alert("fail")
    	callToolTip231('designation','hide');	
        event.preventDefault();
    } else {
//         alert("pass")
    	
    saveEscalationMaster99();
    }
}).show();

$("#resetbtn").click(function () {
    $("#priority").val("");
    callToolTip231('priority', 'hide');
    $("#cname").val("");
    callToolTip231('cname', 'hide');
    $("#severity").val("");
    callToolTip231('severity', 'hide');
    $("#designation").val("");
    callToolTip231('designation', 'hide');
    $("#username").val('').trigger('change')
    callToolTip231('usernameDiv', 'hide');
    $("#engLevel").val("");
    callToolTip231('engLevel', 'hide');
    $("#days").val("00");
    callToolTip231('days', 'hide');
      $("#hours").val("00");
    callToolTip231('hours', 'hide');
      $("#minutes").val("00");
    callToolTip231('minutes', 'hide');
      $("#seconds").val("00");
    callToolTip231('seconds', 'hide');
    
    callToolTip231('wrongDays', 'destroy');
    callToolTip231('wrongHours', 'destroy');
    callToolTip231('wrongMinutes', 'destroy');
    callToolTip231('wrongSeconds', 'destroy');
});

//insert data
function saveEscalationMaster99() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/SubmitEscalationDetails";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: 'engLevel=' + encodeURIComponent($("#engLevel").val())
                + '&days=' + $("#days").val()
                + '&hours=' + $("#hours").val()
                + '&minutes=' + $("#minutes").val()
                + '&seconds=' + ($("#seconds").val())
                + "&cmpnyname=" + encodeURIComponent($('#cname').val())
                + "&priority=" + encodeURIComponent($('#priority').val())
                + "&severity=" + encodeURIComponent($('#severity').val())
                + "&designation=" + encodeURIComponent($('#designation').val())
                + "&username=" + $('#username').val()
    }).done(function (data) {
        // alert("hgdjghd"+data)

        if (data == "success") {
            swal({
                title: "Successful!",
                text: "Record Added Successfully",
                type: "success",
                width: 300,
                height: 200,
//       		 showCancelButton: false,
//              confirmButtonClass: "btn btn-danger",
//              cancelButtonClass: "btn btn-danger m-l-10",
//              confirmButtonText: "OK",
                buttons: false,
                allowOutsideClick: false,
                preConfirm: function () {
                    var l = window.location;
                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                    window.location.href = base_url + "/Admin/EscalationMaster";
                }

            });

        } else if (data == "duplicate") {
            swal({
            	 title: "Successful!",
                 text: "Record Updated Successfully",
                 type: "success",
                 width: 300,
                 height: 200,
//        		 showCancelButton: false,
//               confirmButtonClass: "btn btn-danger",
//               cancelButtonClass: "btn btn-danger m-l-10",
//               confirmButtonText: "OK",
                 buttons: false,
                 allowOutsideClick: false,
                preConfirm: function () {
                    var l = window.location;
                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                    window.location.href = base_url + "/Admin/EscalationMaster";
                }

            });

        } else if (data == "error") {
            swal({
                title: "Unsuccessful!",
                text: "Failed to add record",
                type: "error",
                width: 300,
                height: 200,
//       		 showCancelButton: false,
//              confirmButtonClass: "btn btn-danger",
//              cancelButtonClass: "btn btn-danger m-l-10",
//              confirmButtonText: "OK",
                buttons: false,
                allowOutsideClick: false,
                preConfirm: function () {
                    var l = window.location;
                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                    window.location.href = base_url + "/Admin/EscalationMaster";
                }

            });

        }
    });
    //});
}


function DeleteEscalation(companyname,level) {
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
    }).then(function () {
        //  alert("deleteUserdddddddd")
    	
    	var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/deleteEscalation";
    
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'company=' + companyname
            + '&level=' + level

        }).done(function (data) {
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
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/EscalationMaster";
                    }

                });

            } else if (data == "error") {
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
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/EscalationMaster";
                    }

                });

            }
        });
    });
}



function DaysInput() {

    var inputtxt = $('#days').val();
    var phoneno = /^\d{1,2}$/;

    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
    callToolTip231('wrongDays', 'show');
        return false;
    }
}
function HoursInput() {

    var inputtxt = $('#hours').val();
    var phoneno = /^\d{1,2}$/;

    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
    callToolTip231('wrongHours', 'show');
        return false;
    }
}
function MinutesInput() {

    var inputtxt = $('#minutes').val();
    var phoneno = /^\d{1,2}$/;

    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
    callToolTip231('wrongMinutes', 'show');
        return false;
    }
}
function SecondsInput() {

    var inputtxt = $('#seconds').val();
    var phoneno = /^\d{1,2}$/;

    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
    callToolTip231('wrongSeconds', 'show');
        return false;
    }
}

function DaysUpdateInput() {

    var inputtxt = $('#daysupdate').val();
    var phoneno = /^\d{1,2}$/;

    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
    callToolTipUpdate('wrongDaysupdate', 'show');
        return false;
    }
}
function HoursUpdateInput() {

    var inputtxt = $('#hoursupdate').val();
    var phoneno = /^\d{1,2}$/;

    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
    callToolTipUpdate('wrongHoursupdate', 'show');
        return false;
    }
}
function MinutesUpdateInput() {

    var inputtxt = $('#minutesupdate').val();
    var phoneno = /^\d{1,2}$/;

    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
    callToolTipUpdate('wrongMinutesupdate', 'show');
        return false;
    }
}
function SecondsUpdateInput() {

    var inputtxt = $('#secondsupdate').val();
    var phoneno = /^\d{1,2}$/;

    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
    callToolTipUpdate('wrongSecondsupdate', 'show');
        return false;
    }
}

                   