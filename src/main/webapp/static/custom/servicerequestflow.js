window.onload = function() {
  $("#companyName").focus();
  
  // AJAX GET COMPANY DETAILS
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
   $.ajax({
       type: 'POST',
       url: serviceUrl,
       dataType: 'json',
         async: false,
       success: function(data) {
                var html = "  <option value=''> -- Please Select --</option>";
                for (var i = 0; i < data.length; i++) {
                    html += '<option value="' + data[i] + '">' + data[i]
                            + '</option>';
                }

                document.getElementById("companyName").innerHTML = html;
           }
   });
   
   // AJAX GET LIST IN TABLE
   var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/getServiceRequestFlowListing";
     
     $.ajax({
       type: 'POST',
       url: serviceUrl,
       dataType: 'json',
       success: function (data4) {
         var table = $('#datatype').DataTable({
             lengthChange: true,
             data: data4,
             scrollX: true,
             "pageLength": 5,
         });

         table.buttons().container()
                 .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

       }

     });
  
}

$("#companyName").on('change', function() {
  getDesignation($("#companyName").val());
});

$("#designationName").on('change', function() {
  getApproverName($("#companyName").val(), $("#designationName").val());
});

$("#approverName").on('change', function() {
  getDepartment($("#companyName").val(), $("#designationName").val(),$("#approverName").val());
});

function getDesignation(company) {
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/Master/getDesignationForLoginMaster";
   
    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        async: false,
        data: 'company=' + company
    }).done(function (data) {
        var html = '<option value="">--Please Select Designation--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("designationName").innerHTML = html;
        document.getElementById("designationNameupdate").innerHTML = html;
    });
}

function getApproverName(company, designation) {
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/Master/getApproverDetails";
  
  $.ajax({
    
    url: serviceUrl,
    type: 'POST',
    dataType: 'json',
    async: false,
    data: 'company=' + company
          + '&designation=' + designation
  }).done(function (data) {
    var html = '<option value="">--Please Select Approver--</option>';
    for (var i = 0; i < data.length; i++) {
      html += '<option value="' + data[i] + '">' + data[i]
      + '</option>';
    }
    
    document.getElementById("approverName").innerHTML = html;
    document.getElementById("approverNameupdate").innerHTML = html;
  });
}

function getDepartment(company, designation, approver) {
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/Master/getDepartmentDetails";
   
    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        async: false,
        data: 'company=' + company
              + '&designation=' + designation
              + '&approver=' + approver
    }).done(function (data) {
        var html = '<option value="">--Please Select Department--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("departmentName").innerHTML = html;
        document.getElementById("departmentNameupdate").innerHTML = html;
    });
}


$("#submit-btn").click(function () {
  if (!validateServiceRequest()) {
      event.preventDefault();
  } else {
    saveServiceRequest();
  }
}).show();

// FUNCTION RESET
$("#resetbtn").click(function() {
  $("#companyName").val("");
  callToolTip231('companyName', 'hide');
  $("#designationName").val("");
  callToolTip231('designationName', 'hide');
  $("#request").val("");
  callToolTip231('request', 'hide');
  $("#approverName").val("");
  callToolTip231('approverName', 'hide');
  $("#departmentName").val("");
  callToolTip231('departmentName', 'hide');
});

//SHOW ERRORS AND EMPTY FIELDS
var callToolTip231 = function (fieldName, status) {
  if (fieldName == "companyName") {
    var errorMessage = "<span>Please Select Company</span>"
  } else if (fieldName == "designationName") {
    var errorMessage = "<span>Please Select Designation</span>"
  } else if (fieldName == "request") {
    var errorMessage = "<span>Please Enter Request</span>"
  } else if (fieldName == "approverName") {
    var errorMessage = "<span>Please Select Approver</span>"
  } else if (fieldName == "departmentName") {
    var errorMessage = "<span>Please Select Department</span>"
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

$('#companyName').on('focusout', function () {
  var usertype = $('#companyName').val();

  if (usertype.trim() == "") {
      callToolTip231('companyName', 'show');
  } else {
      callToolTip231('companyName', 'hide');
  }
});

$('#designationName').on('focusout', function () {
  var usertype = $('#designationName').val();

  if (usertype.trim() == "") {
      callToolTip231('designationName', 'show');
  } else {
      callToolTip231('designationName', 'hide');
  }
}); 

$('#request').on('focusout', function () {
  var usertype = $('#request').val();

  if (usertype.trim() == "") {
      callToolTip231('request', 'show');
  } else {
      callToolTip231('request', 'hide');
  }
}); 

$('#approverName').on('focusout', function () {
  var usertype = $('#approverName').val();

  if (usertype.trim() == "") {
      callToolTip231('approverName', 'show');
  } else {
      callToolTip231('approverName', 'hide');
  }
}); 

$('#departmentName').on('focusout', function () {
  var usertype = $('#departmentName').val();

  if (usertype.trim() == "") {
      callToolTip231('departmentName', 'show');
  } else {
      callToolTip231('departmentName', 'hide');
  }
}); 

$('#companyName').on('focus', function () {
  callToolTip231('companyName', 'destroy');
});

$('#designationName').on('focus', function () {
  callToolTip231('designationName', 'destroy');
});

$('#request').on('focus', function () {
  callToolTip231('request', 'destroy');
});

$('#approverName').on('focus', function () {
  callToolTip231('approverName', 'destroy');
});

$('#departmentName').on('focus', function () {
  callToolTip231('departmentName', 'destroy');
});

// VALIDATING ON SUBMIT
function validateServiceRequest() {
  var indexError = 0;

  if ($('#companyName').val().trim() === '') {
      callToolTip231('companyName', 'show');
      if (indexError == 0) {

      }
      indexError = indexError + 1;
  }
  if ($('#designationName').val().trim() === '') {
      callToolTip231('designationName', 'show');
      if (indexError == 0) {

      }
      indexError = indexError + 1;
  }
  if ($('#request').val().trim() === '') {
      callToolTip231('request', 'show');
      if (indexError == 0) {
  
      }
      indexError = indexError + 1;
  }
  if ($('#approverName').val().trim() === '') {
      callToolTip231('approverName', 'show');
      if (indexError == 0) {
  
      }
      indexError = indexError + 1;
  }
  if ($('#departmentName').val().trim() === '') {
      callToolTip231('departmentName', 'show');
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

function saveServiceRequest() {
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/Master/addServiceRequestFlow";
  var serviceUrl = serviceUrl;
  $.ajax({
      type: 'POST',
      url: serviceUrl,
      data: 'company=' + $('#companyName').val()
            + '&request=' + $('#request').val()
            + '&approverName=' + $('#approverName').val()
            + '&department=' + $('#departmentName').val()
            + '&designation=' + $('#designationName').val()
  }).done(function(data) {
      if (data == "success") {
        swal({
          title: "Successful!",
          text: "Record Updated Successfully",
          type: "success",
          width: 300,
          height: 200,
          buttons: false,
          allowOutsideClick: false,
          preConfirm: function () {
              var l = window.location;
              var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
              window.location.href = base_url + "/Admin/ServiceRequestFlow";
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
              buttons: false,
              allowOutsideClick: false,
              preConfirm: function() {
                  var l = window.location;
                  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                  window.location.href = base_url + "/Admin/ServiceRequestFlow";
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
              buttons: false,
              allowOutsideClick: false,
              preConfirm: function() {
                  var l = window.location;
                  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                  window.location.href = base_url + "/Admin/ServiceRequestFlow";
              }

          });

        }
  });
}

// FUNCTION EDIT
function EditServiceRequest(srno, company, request,  designation, approver, department) {
  $("#companynameupdate").val(company);
  getDesignation(company);
  getApproverName(company, designation);
  getDepartment(company, designation, approver);
  $("#requestupdate").val(request);
  $("#designationNameupdate").val(designation);
  $("#approverNameupdate").val(approver);
  $("#departmentNameupdate").val(department);
  $("#sr_no1").val(srno);
  $("#modelservicerequestflow").modal("show");
}

$("#designationNameupdate").on('change', function() {
  getApproverName($("#companynameupdate").val(), $("#designationNameupdate").val());
});

$("#approverNameupdate").on('change', function() {
  getDepartment($("#companynameupdate").val(), $("#designationNameupdate").val(),$("#approverNameupdate").val());
});

$("#update_request_btn").click(function () {
  if (!validateServiceRequestUpdate())
  {
//      alert("fail")
      event.preventDefault();
  } else if (validateServiceRequestUpdate())
  {
//       alert("pass")
    updateServiceRequest();
  }
}).show();

//SHOW ERRORS AND EMPTY FIELDS
var callToolTipUpdate = function (fieldName, status) {
  if (fieldName == "companynameupdate") {
    var errorMessage = "<span>Please Select Company</span>"
  } else if (fieldName == "designationNameupdate") {
    var errorMessage = "<span>Please Select Designation</span>"
  } else if (fieldName == "requestupdate") {
    var errorMessage = "<span>Please Enter Request</span>"
  } else if (fieldName == "approverNameupdate") {
    var errorMessage = "<span>Please Select Approver</span>"
  } else if (fieldName == "departmentNameupdate") {
    var errorMessage = "<span>Please Select Department</span>"
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

$('#companynameupdate').on('focusout', function () {
  var usertype = $('#companynameupdate').val();

  if (usertype.trim() == "") {
    callToolTipUpdate('companynameupdate', 'show');
  } else {
    callToolTipUpdate('companynameupdate', 'hide');
  }
});

$('#designationNameupdate').on('focusout', function () {
  var usertype = $('#designationNameupdate').val();

  if (usertype.trim() == "") {
    callToolTipUpdate('designationNameupdate', 'show');
  } else {
    callToolTipUpdate('designationNameupdate', 'hide');
  }
}); 

$('#requestupdate').on('focusout', function () {
  var usertype = $('#requestupdate').val();

  if (usertype.trim() == "") {
    callToolTipUpdate('requestupdate', 'show');
  } else {
    callToolTipUpdate('request', 'hide');
  }
}); 

$('#approverNameupdate').on('focusout', function () {
  var usertype = $('#approverNameupdate').val();

  if (usertype.trim() == "") {
    callToolTipUpdate('approverNameupdate', 'show');
  } else {
    callToolTipUpdate('approverNameupdate', 'hide');
  }
}); 

$('#departmentNameupdate').on('focusout', function () {
  var usertype = $('#departmentNameupdate').val();

  if (usertype.trim() == "") {
    callToolTipUpdate('departmentNameupdate', 'show');
  } else {
    callToolTipUpdate('departmentNameupdate', 'hide');
  }
}); 

$('#companynameupdate').on('focus', function () {
  callToolTipUpdate('companynameupdate', 'destroy');
});

$('#designationNameupdate').on('focus', function () {
  callToolTipUpdate('designationNameupdate', 'destroy');
});

$('#requestupdate').on('focus', function () {
  callToolTip231('request', 'destroy');
});

$('#approverNameupdate').on('focus', function () {
  callToolTip231('approverName', 'destroy');
});

$('#departmentNameupdate').on('focus', function () {
  callToolTip231('departmentName', 'destroy');
});

function validateServiceRequestUpdate() {
  var indexError = 0;

  if ($('#companynameupdate').val().trim() === '') {
    callToolTipUpdate('companynameupdate', 'show');
      if (indexError == 0) {

      }
      indexError = indexError + 1;
  }
  if ($('#designationNameupdate').val().trim() === '') {
    callToolTipUpdate('designationNameupdate', 'show');
      if (indexError == 0) {

      }
      indexError = indexError + 1;
  }
  if ($('#requestupdate').val().trim() === '') {
    callToolTipUpdate('requestupdate', 'show');
      if (indexError == 0) {
  
      }
      indexError = indexError + 1;
  }
  if ($('#approverNameupdate').val().trim() === '') {
    callToolTipUpdate('approverNameupdate', 'show');
      if (indexError == 0) {
  
      }
      indexError = indexError + 1;
  }
  if ($('#departmentNameupdate').val().trim() === '') {
    callToolTipUpdate('departmentNameupdate', 'show');
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

function updateServiceRequest() {
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/Master/deleteServiceRequestFlow";
  
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "sr_no=" + $("#sr_no1").val(),
        success: function (data) {
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Updated Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/ServiceRequestFlow";
                    }
                });
            } else if (data == "duplicate") {
                swal({
                    title: "Duplicate!",
                    text: "Record Already Exist",
                    type: "success",
                    width: '300px',
                    height: '90px !important',
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/ServiceRequestFlow";
                    }
                });
            } else {

                swal({
                    title: "Unsuccessful!",
                    text: "Record not updated",
                    type: "error",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/ServiceRequestFlow";
                    }
                });
            }

            $('#companynameupdate').val("");

        }
    });
}
// FUNCTION DELETE
function DeleteServiceRequest(srno) {
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
    
     var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/deleteServiceRequestFlow";
    
      $.ajax({
          type: 'POST',
          url: serviceUrl,
          data: 'srno=' + srno

      }).done(function(data) {

          if (data == "success") {
              swal({
                  title: "Successful!",
                  text: "Record Deleted Successfully",
                  type: "success",
                  width: 300,
                  height: 200,
                  buttons: false,
                  allowOutsideClick: false,
                  preConfirm: function() {
                      var l = window.location;
                      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                      window.location.href = base_url + "/Admin/ServiceRequestFlow";
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
                  buttons: false,
                  allowOutsideClick: false,
                  preConfirm: function() {
                      var l = window.location;
                      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                      window.location.href = base_url + "/Admin/ServiceRequestFlow";
                  }

              });

            }
      });
  });
}

