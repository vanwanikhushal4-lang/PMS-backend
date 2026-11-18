 window.onload = function() {
//   $("#companyName").focus();
   
   // AJAX GET COMPANY DETAILS
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
            }
    });
    
   // AJAX GET EXISTING DESIGNATIONS LIST IN TABLE
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/DesignationMasterListing";
      
      $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function (data4) {
          //alert(data4)
          var table = $('#datatype').DataTable({
              lengthChange: false,
              data: data4,
              "pageLength": 5,
              scrollX:true,
          });

          table.buttons().container()
                  .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

        }

      });
 }
 
 // FUNCTION SUBMIT
 $("#submit-btn").click(function () {
   // CALL FUNCTION VALIDATION
   if (!validateDesignation()) {
       event.preventDefault();
   } else {
     // CALL FUNCTION SAVE DESIGNATION
     saveDesignation();
   }
}).show();
 
 // FUNCTION RESET
 $("#resetbtn").click(function() {
	
	 $("#designationName").val("");
	 $("#companyName").val("");
   callToolTip231('companyName', 'hide');

//   alert($("companyName").val(""))
   callToolTip231('designationName', 'hide');
  
 });
 
//SHOW ERRORS AND EMPTY FIELDS
 var callToolTip231 = function (fieldName, status) {
  if (fieldName == "designationName") {
     var errorMessage = "<span>Please Enter Module Name</span>"
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

 $('#companyName').on('focus', function () {
   callToolTip231('companyName', 'destroy');
});
 
 $('#designationName').on('focus', function () {
   callToolTip231('designationName', 'destroy');
});
 
 // FUNCTION VALIDATION
 function validateDesignation() {
   var indexError = 0;

 
   if ($('#designationName').val().trim() === '') {
       callToolTip231('designationName', 'show');
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
 
 // FUNCTION SAVE DESIGNATION
 function saveDesignation() {
   // AJAX CALL TO SAVE
   var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/AddModule";
   var serviceUrl = serviceUrl;
   $.ajax({
       type: 'POST',
       url: serviceUrl,
       data: 'designation=' + encodeURIComponent($("#designationName").val())
        
   }).done(function(data) {
       if (data == "success") {
         swal({
           title: "Successful!",
           text: "Record Inserted Successfully",
           type: "success",
           width: 300,
           height: 200,
//      showCancelButton: false,
//         confirmButtonClass: "btn btn-danger",
//         cancelButtonClass: "btn btn-danger m-l-10",
//         confirmButtonText: "OK",
           buttons: false,
           allowOutsideClick: false,
           preConfirm: function () {
               var l = window.location;
               var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
               window.location.href = base_url + "/Admin/ModuleMaster";
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
                   window.location.href = base_url + "/Admin/ModuleMaster";
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
                   window.location.href = base_url + "/Admin/ModuleMaster";
               }

           });

         }
   });
 }
   
 
 // FUNCTION EDIT
 function EditDesignation(srno,designation) {
	
 
   $("#designationNameupdate").val(designation);
   $("#sr_no1").val(srno);
   $("#modeldesignation").modal("show");
   
 }
 
 // FUNCTION UPDATE
 
 $("#update_designation_btn").click(function () {
   if (!validateDesignationUpdate())
   {
//       alert("fail")
       event.preventDefault();
   } else if (validateDesignationUpdate())
   {
//        alert("pass")
     updateDesignation();
   }
}).show();

 function updateDesignation() {
   var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/UpdateModule";
   
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data: "designation=" + $('#designationNameupdate').val()
                 + "&sr_no=" + $("#sr_no1").val(),
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
                         window.location.href = base_url + "/Admin/ModuleMaster";
                     }
                 });
             } else if (data == "duplicate") {
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
                         window.location.href = base_url + "/Admin/ModuleMaster";
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
                         window.location.href = base_url + "/Admin/ModuleMaster";
                     }
                 });
             }

             $('#companynameupdate').val("");

         }
     });
 }
 
//SHOW ERRORS AND EMPTY FIELDS
 var callToolTipUpdate = function (fieldName, status) {
   if (fieldName == "designationNameupdate") {
     var errorMessage = "<span>Please Enter Module Name</span>"
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
 
 
 $('#designationNameupdate').on('focusout', function () {
   var usertype = $('#designationNameupdate').val();

   if (usertype.trim() == "") {
     callToolTipUpdate('designationNameupdate', 'show');
   } else {
     callToolTipUpdate('designationNameupdate', 'hide');
   }
}); 


 
 $('#designationNameupdate').on('focus', function () {
   callToolTipUpdate('designationNameupdate', 'destroy');
});
 
 // FUNCTION VALIDATION
 function validateDesignationUpdate() {
   var indexError = 0;

  
   if ($('#designationNameupdate').val().trim() === '') {
     callToolTipUpdate('designationNameupdate', 'show');
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
 
 // FUNCTION DELETE
 function DeleteDesignation(srno) {
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
     var serviceUrl = base_url + "/Master/Deletemodule";
     
       $.ajax({
           type: 'POST',
           url: serviceUrl,
           data: 'crno=' + srno

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
                       window.location.href = base_url + "/Admin/ModuleMaster";
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
                       window.location.href = base_url + "/Admin/ModuleMaster";
                   }

               });

             }
       });
   });
 }
 
 