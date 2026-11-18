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
    
    
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getresp";
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

                  document.getElementById("designationName").innerHTML = html;
             }
     });
     
     
     var l = window.location;
     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     var serviceUrl = base_url + "/Master/getresp1";
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

                   document.getElementById("module").innerHTML = html;
              }
      });
     
      
      var l = window.location;
      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
      var serviceUrl = base_url + "/Master/getresp2";
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

                    document.getElementById("function").innerHTML = html;
               }
       });
      
       
       //for update
       
       
       var l = window.location;
       var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
       var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMasterup";
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

                     document.getElementById("companyNameup").innerHTML = html;
                }
        });
        
        
        var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        var serviceUrl = base_url + "/Master/getrespup";
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

                      document.getElementById("designationNameup").innerHTML = html;
                 }
         });
         
         
         var l = window.location;
         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
         var serviceUrl = base_url + "/Master/getresp1up";
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

                       document.getElementById("moduleup").innerHTML = html;
                  }
          });
         
          
          var l = window.location;
          var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
          var serviceUrl = base_url + "/Master/getresp2up";
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

                        document.getElementById("functionup").innerHTML = html;
                   }
           });
          
   // AJAX GET EXISTING DESIGNATIONS LIST IN TABLE
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/resplisting";
      
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
	 $("#companyName").val("");
	 $("#designationName").val("");
	
	 $("#roletype").val("");
	 $("#module").val("");
	 $("#function").val("");
	 $("#checker").val("");
   callToolTip231('companyName', 'hide');
   callToolTip231('designationName', 'hide');
   callToolTip231('roletype', 'hide');
   callToolTip231('module', 'hide');
   callToolTip231('function', 'hide');
   callToolTip231('checker', 'hide');

//   alert($("companyName").val(""))
   
  
 });
 
//SHOW ERRORS AND EMPTY FIELDS
 var callToolTip231 = function (fieldName, status) {
   if (fieldName == "companyName") {
     var errorMessage = "<span>Please Select Company</span>"
   } else if (fieldName == "designationName") {
     var errorMessage = "<span>Please Enter Login Name</span>"
   }
   else if (fieldName == "roletype") {
	     var errorMessage = "<span>Please Enter Role Type</span>"
	   }
   else if (fieldName == "module") {
	     var errorMessage = "<span>Please Enter Module Name</span>"
	   }
   else if (fieldName == "function") {
	     var errorMessage = "<span>Please Enter Function</span>"
	   }
   else if (fieldName == "checker") {
	     var errorMessage = "<span>Please Enter Checker</span>"
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
 
 $('#roletype').on('focusout', function () {
	   var usertype = $('#roletype').val();

	   if (usertype.trim() == "") {
	       callToolTip231('roletype', 'show');
	   } else {
	       callToolTip231('roletype', 'hide');
	   }
	}); 
 $('#module').on('focusout', function () {
	   var usertype = $('#module').val();

	   if (usertype.trim() == "") {
	       callToolTip231('module', 'show');
	   } else {
	       callToolTip231('module', 'hide');
	   }
	}); 
 $('#function').on('focusout', function () {
	   var usertype = $('#function').val();

	   if (usertype.trim() == "") {
	       callToolTip231('function', 'show');
	   } else {
	       callToolTip231('function', 'hide');
	   }
	}); 
 $('#checker').on('focusout', function () {
	   var usertype = $('#checker').val();

	   if (usertype.trim() == "") {
	       callToolTip231('checker', 'show');
	   } else {
	       callToolTip231('checker', 'hide');
	   }
	}); 
 

 $('#companyName').on('focus', function () {
   callToolTip231('companyName', 'destroy');
});
 
 $('#designationName').on('focus', function () {
   callToolTip231('designationName', 'destroy');
});
 
 $('#roletype').on('focus', function () {
	   callToolTip231('roletype', 'destroy');
	});
 $('#module').on('focus', function () {
	   callToolTip231('module', 'destroy');
	});
 $('#function').on('focus', function () {
	   callToolTip231('function', 'destroy');
	});
 $('#checker').on('focus', function () {
	   callToolTip231('checker', 'destroy');
	});
 
 // FUNCTION VALIDATION
 function validateDesignation() {
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
   if ($('#roletype').val().trim() === '') {
       callToolTip231('roletype', 'show');
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   if ($('#module').val().trim() === '') {
       callToolTip231('module', 'show');
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   if ($('#function').val().trim() === '') {
       callToolTip231('function', 'show');
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   if ($('#checker').val().trim() === '') {
       callToolTip231('checker', 'show');
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
   var serviceUrl = base_url + "/Master/AddDesignationMaster";
   var serviceUrl = serviceUrl;
   $.ajax({
       type: 'POST',
       url: serviceUrl,
       data: 'designation=' + encodeURIComponent($("#designationName").val())
           + '&company=' + encodeURIComponent($("#companyName").val())
            + '&roletype=' + encodeURIComponent($("#roletype").val())
             + '&module=' + encodeURIComponent($("#module").val())
              + '&function=' + encodeURIComponent($("#function").val())
               + '&checker=' + encodeURIComponent($("#checker").val())
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
               window.location.href = base_url + "/Admin/DesignationMaster";
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
                   window.location.href = base_url + "/Admin/DesignationMaster";
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
                   window.location.href = base_url + "/Admin/DesignationMaster";
               }

           });

         }
   });
 }
   
 
 // FUNCTION EDIT
 function EditDesignation(srno, Company, Login,roletype,Module,functions,Checker) {
	 $("#sr_no1").val(srno);
   $("#companyNameup").val(Company);
   $("#designationNameup").val(Login);
   $("#roletypup").val(roletype);
   $("#moduleup").val(Module);
   $("#functionup").val(functions);
   $("#checkerup").val(Checker);
   
   $("#modeldesignation").modal("show");
   
 }
 
 // FUNCTION UPDATE
 
 $("#update_designation_btn").click(function () {
	 updateDesignation();
//   if (!validateDesignationUpdate())
//   {
////       alert("fail")
//       event.preventDefault();
//   } else if (validateDesignationUpdate())
//   {
////        alert("pass")
//     updateDesignation();
//   }
}).show();

 function updateDesignation() {
	 //alert("hihi")
   var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/Updateresponsibiity";
   
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data:  'designation=' + encodeURIComponent($("#designationNameup").val())
         + '&company=' + encodeURIComponent($("#companyNameup").val())
         + '&roletype=' + encodeURIComponent($("#roletypeup").val())
          + '&module=' + encodeURIComponent($("#moduleup").val())
           + '&function=' + encodeURIComponent($("#functionup").val())
            + '&checker=' + encodeURIComponent($("#checkerup").val())
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
                         window.location.href = base_url + "/Admin/DesignationMaster";
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
                         window.location.href = base_url + "/Admin/DesignationMaster";
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
                         window.location.href = base_url + "/Admin/DesignationMaster";
                     }
                 });
             }

             $('#companynameupdate').val("");

         }
     });
 }
 
//SHOW ERRORS AND EMPTY FIELDS
 var callToolTipUpdate = function (fieldName, status) {
   if (fieldName == "companynameupdate") {
     var errorMessage = "<span>Please Select Company</span>"
   } else if (fieldName == "designationNameupdate") {
     var errorMessage = "<span>Please Enter Designation</span>"
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

 $('#companynameupdate').on('focus', function () {
   callToolTipUpdate('companynameupdate', 'destroy');
});
 
 $('#designationNameupdate').on('focus', function () {
   callToolTipUpdate('designationNameupdate', 'destroy');
});
 
 // FUNCTION VALIDATION
 function validateDesignationUpdate() {
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
     var serviceUrl = base_url + "/Master/Deleteresp";
     
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
                       window.location.href = base_url + "/Admin/DesignationMaster";
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
                       window.location.href = base_url + "/Admin/DesignationMaster";
                   }

               });

             }
       });
   });
 }
 
 