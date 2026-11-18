window.onload = function () {
//     alert("ggggg");

	

 
    $('#days').val("00");
    $('#hours').val("00");
    $('#minutes').val("00");
    $('#seconds').val("00");

    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getCompositecompanyDetails";
//      var serviceUrl = "getDepartmentDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',

         success: function(data4) {

        	 var html = "<option value=''>-- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("cname").innerHTML = html;
             }

             
     });
     
     $("#cname").on('change', function() {
    	 
    	// alert($("#cname").val());
       getPriority($("#cname").val());
       getSeverity($("#cname").val());
     });
    
       
       
     
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/SLA/getResponseSLAMasterListing";
    
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
};

function getPriority(companyName) {
	
	//alert("COMPANY NAME ISt  "+companyName);

  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/SLA/getPriorityName";
   
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
        document.getElementById("priorityupdate").innerHTML = html;
        $('#priorityupdate').val(priority);
    });
}

function getSeverity(companyName) {
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/SLA/getSeverityName";
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
         document.getElementById("severityupdate").innerHTML = html;
         $('#severityupdate').val(severity);
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
    } else
    {
        ret = true;
    }
    return ret;
}


var callToolTip231 = function (fieldName, status) {

    if (fieldName == "priority") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Priority<span>";
    } 
    else if (fieldName == "severity") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Severity<span>";
    }
    else if (fieldName == "cname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Company Name<span>";
    }
    
    
    
    else if (fieldName == "days") {
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

$('#cname').on('focusout', function () {
    var usertype = $('#cname').val();

    if (usertype.trim() == "") {
        callToolTip231('cname', 'show');
    } else {
        callToolTip231('cname', 'hide');
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
$('#cname').on('focus', function () {
    callToolTip231('cname', 'destroy');
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
function validateSLA() {
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
                text: "Time not set for SLA",
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
    //alert("dgfsgf");
    if (!validateSLA()) {
//        alert("fail")
        event.preventDefault();
    } else {
//         alert("pass")
    saveresponseSLAMaster();
    }
}).show();

$("#resetbtn").click(function () {
    $("#priority").val("");
    callToolTip231('priority', 'hide');
    $("#cname").val("");
    callToolTip231('cname', 'hide');
    $("#severity").val("");
    callToolTip231('severity', 'hide');
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
function saveresponseSLAMaster() {


	var checkweekorcalenderstatus=null;
	 if ($('#weekcalender').is(":checked"))
	 {
		// alert("checked");
		 checkweekorcalenderstatus="Yes";
	}
	 else{
		// alert("NOT checked");
		 checkweekorcalenderstatus="No";
	}
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/SLA/SubmitResponseSLADetails";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: 'priority=' + encodeURIComponent($("#priority").val())
                + '&days=' + $("#days").val()
                + '&hours=' + $("#hours").val()
                + '&minutes=' + $("#minutes").val()
                + '&seconds=' + $("#seconds").val()
                + '&severity=' + encodeURIComponent($("#severity").val())
                + '&cname=' + encodeURIComponent($("#cname").val())
                 + '&calenderCheck=' +checkweekorcalenderstatus
                
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
                    window.location.href = base_url + "/Admin/ResponseSLAMaster";
                }

            });

        } else if (data == "duplicate") {
            swal({
                title: "Duplicate Data!",
                text: "Record Already Exists",
                type: "warning",
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
                    window.location.href = base_url + "/Admin/ResponseSLAMaster";
                }

            });

        } else if (data == "error") {
            swal({
                title: "Unsuccessful!",
                text: "Fail to add file",
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
                    window.location.href = base_url + "/Admin/ResponseSLAMaster";
                }

            });

        }
    });
    //});
}


function DeleteSLA(sr_no) {
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
    	var serviceUrl = base_url + "/SLA/deleteResponseSLA";
    
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'sr_no=' + sr_no

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
                        window.location.href = base_url + "/Admin/ResponseSLAMaster";
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
                        window.location.href = base_url + "/Admin/ResponseSLAMaster";
                    }

                });

            }
        });
    });
}



function EditSLA (PRIORITY_NAME,DAYS,HOURS,MINUTES,SECONDS,cname,SEVERITY_NAME, sr_no,holdstatus) {
  
 //  alert("STATUS "+holdstatus);
    

    
    
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/SLA/getPriorityName";
     

      $.ajax({

          url: serviceUrl,
          type: 'POST',
          dataType: 'json',
          data: 'companyName=' + encodeURIComponent(cname)
      }).done(function (data) {
    	  
      	//alert("DATA VALUE IS ::",prioritydata);
          var html =" <select class='form-control' tabindex='13' id='priorityupdate' name='priorityupdate' '>";
          for (var i = 0; i < data.length; i++) {
              html += '<option value="' +data[i]+ '">' + data[i]
              + '</option>';
          }
          document.getElementById("priorityupdate").innerHTML=html;
          $("#priorityupdate").val(PRIORITY_NAME);
      
    	
      });
    
      
      var l = window.location;
      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
      var serviceUrl = base_url + "/SLA/getSeverityName";

        $.ajax({

            url: serviceUrl,
            type: 'POST',
            dataType: 'json',
            data: 'companyName=' + encodeURIComponent(cname)
        }).done(function (data) {
      	  
        	//alert("DATA VALUE IS ::",prioritydata);
            var html =" <select class='form-control' tabindex='13' id='severityupdate' name='severityupdate' '>";
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' +data[i]+ '">' + data[i]
                + '</option>';
            }
            document.getElementById("severityupdate").innerHTML=html;
            $("#severityupdate").val(SEVERITY_NAME);
        });
    
    
    $("#cnameupdate").val(cname);
 
    $("#daysupdate").val(DAYS);
    $("#hoursupdate").val(HOURS);
    $("#minutesupdate").val(MINUTES);
    $("#secondsupdate").val(SECONDS);
    $("#sr_no1").val(sr_no);
    if(holdstatus == "Yes"){
    	 $("#cweek").prop("checked", true);
    	  }
    	  else if(holdstatus == "No"){

    	 $("#cweek").prop("checked", false);
    	  }
    
    if(holdstatus == "Yes"){
 $("#holdstatusupdate").prop("checked", true);
  }
  else if(holdstatus == "No"){

 $("#holdstatusupdate").prop("checked", false);
  }
    
    
    $("#modeleditsla1").modal("show");
    
    $("#modeleditsla1").on('shown.bs.modal', function(){
        $(this).find('#daysupdate').focus();
    });
}

$("#update_SLA_btn").click(function () {
    if (!validateSLAUpdate())
    {
//        alert("fail")
        event.preventDefault();
    } else if (validateSLAUpdate())
    {
//         alert("pass")
        updateResponseSLAsave();
    }
}).show();

function updateResponseSLAsave() {
  //alert($("#severityupdate").val())
	
	
	
		
	 var checkcalenderupdate=null; 
	 if ($('#cweek').is(":checked"))
	 {
		// alert("checked");
		 checkcalenderupdate="Yes";
	}
	 else{
		// alert("NOT checked");
		 checkcalenderupdate="No";
	}
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/SLA/UpdateResponseSLADetails";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "priorityupdate=" + encodeURIComponent($('#priorityupdate').val())
                + "&daysupdate=" + $("#daysupdate").val()
                + "&hoursupdate=" + $("#hoursupdate").val()
                + "&minutesupdate=" + $("#minutesupdate").val()
                + "&secondsupdate=" + $("#secondsupdate").val()
                + "&cnameupdate=" + encodeURIComponent($("#cnameupdate").val())
                + "&severityupdate=" + encodeURIComponent($("#severityupdate").val())
              
                + "&sr_no=" + $("#sr_no1").val() 
                + "&cweek=" + checkcalenderupdate
                
                ,
        success: function (data) {
                     // alert(data)
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
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/ResponseSLAMaster";
                    }
                });
            } else if (data == "duplicate") {
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
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/ResponseSLAMaster";
                    }
                });
            } else {

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
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/ResponseSLAMaster";
                    }
                });
            }

            $('#updatecompanyname').val("");

        }
    });
}

var callToolTipUpdate = function (fieldName, status) {


    if (fieldName == "daysupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter No Of Days<span>";
    } else if (fieldName == "priorityupdate") {
      var errorMessage = "<span>Please Select Priority<span>";
    } else if (fieldName == "severityupdate") {
      var errorMessage = "<span>Please Select Severity<span>";
    } else if (fieldName == "hoursupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter No Of Hours<span>";
    } else if (fieldName == "minutesupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter No Of Minutes<span>";
    } else if (fieldName == "secondsupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter No Of Seconds<span>";
    } else if (fieldName == "wrongDaysupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Days<span>";
    } else if (fieldName == "wrongHoursupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Hours<span>";
    } else if (fieldName == "wrongMinutesupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Minutes<span>";
    } else if (fieldName == "wrongSecondsupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Seconds<span>";
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

$('#daysupdate').on('focusout', function () {
    var usertype = $('#daysupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('daysupdate', 'show');
    } else {
        callToolTipUpdate('daysupdate', 'hide');
    }
});
$('#hoursupdate').on('focusout', function () {
    var usertype = $('#hoursupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('hoursupdate', 'show');
    } else {
        callToolTipUpdate('hoursupdate', 'hide');
    }
});
$('#minutesupdate').on('focusout', function () {
    var usertype = $('#minutesupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('minutesupdate', 'show');
    } else {
        callToolTipUpdate('minutesupdate', 'hide');
    }
});
$('#secondsupdate').on('focusout', function () {
    var usertype = $('#secondsupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('secondsupdate', 'show');
    } else {
        callToolTipUpdate('secondsupdate', 'hide');
    }
});

$('#priorityupdate').on('focusout', function () {
  var usertype = $('#priorityupdate').val();

  if (usertype.trim() == "") {
      callToolTipUpdate('priorityupdate', 'show');
  } else {
      callToolTipUpdate('priorityupdate', 'hide');
  }
});

$('#severityupdate').on('focusout', function () {
  var usertype = $('#severityupdate').val();

  if (usertype.trim() == "") {
      callToolTipUpdate('severityupdate', 'show');
  } else {
      callToolTipUpdate('severityupdate', 'hide');
  }
});

$('#daysupdate').on('focus', function () {
    callToolTipUpdate('daysupdate', 'destroy');
    callToolTipUpdate('wrongDaysupdate', 'destroy');
});
$('#hoursupdate').on('focus', function () {
    callToolTipUpdate('hoursupdate', 'destroy');
    callToolTipUpdate('wrongHoursupdate', 'destroy');
});
$('#minutesupdate').on('focus', function () {
    callToolTipUpdate('minutesupdate', 'destroy');
    callToolTipUpdate('wrongMinutesupdate', 'destroy');
});
$('#secondsupdate').on('focus', function () {
    callToolTipUpdate('secondsupdate', 'destroy');
    callToolTipUpdate('wrongSecondsupdate', 'destroy');
});
$('#priorityupdate').on('focus', function () {
  callToolTipUpdate('priorityupdate', 'destroy');
});
$('#severityupdate').on('focus', function () {
  callToolTipUpdate('severityupdate', 'destroy');
});
function validateSLAUpdate() {
    var indexError = 0;


     if ($('#daysupdate').val().trim() === '') {
        callToolTipUpdate('daysupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else if (!DaysUpdateInput())
    {
       indexError = indexError + 1;
         console.log("In invalid contact number: "+indexError);

    }
    if ($('#hoursupdate').val().trim() === '') {
        callToolTipUpdate('hoursupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else if (!HoursUpdateInput())
    {
       indexError = indexError + 1;
         console.log("In invalid contact number: "+indexError);

    }
    if ($('#minutesupdate').val().trim() === '') {
        callToolTipUpdate('minutesupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else if (!MinutesUpdateInput())
    {
       indexError = indexError + 1;
         console.log("In invalid contact number: "+indexError);

    }
    if ($('#secondsupdate').val().trim() === '') {
        callToolTipUpdate('secondsupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else if (!SecondsUpdateInput())
    {
       indexError = indexError + 1;
         console.log("In invalid contact number: "+indexError);

    }
    
    if ($('#priorityupdate').val().trim() === '') {
      callToolTipUpdate('priorityupdate', 'show');
      if (indexError == 0) {

      }
      indexError = indexError + 1;
    }
    
    if ($('#severityupdate').val().trim() === '') {
      callToolTipUpdate('severityupdate', 'show');
      if (indexError == 0) {

      }
      indexError = indexError + 1;
    }
    
    if (($('#daysupdate').val().trim() === '00' || $('#daysupdate').val().trim() === '0') && ($('#hoursupdate').val().trim() === '00' || $('#hoursupdate').val().trim() === '0') && ($('#minutesupdate').val().trim() === '00' || $('#minutesupdate').val().trim() === '0') && ($('#secondsupdate').val().trim() === '00' || $('#secondsupdate').val().trim() === '0')) {

    	swal({
                title: "Alert!",
                text: "Time not set for SLA",
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


                   