 window.onload = function() {
//   $("#companyName").focus();
//   
//   // AJAX GET COMPANY DETAILS
//   var l = window.location;
//   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//   var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        dataType: 'json',
//          async: false,
//        success: function(data4) {
//                 var html = "  <option value=''> -- Please Select --</option>";
//                 for (var i = 0; i < data4.length; i++) {
//                     html += '<option value="' + data4[i] + '">' + data4[i]
//                             + '</option>';
//                 }
//
//                 document.getElementById("companyName").innerHTML = html;
//            }
//    });
//    
   // AJAX GET EXISTING DESIGNATIONS LIST IN TABLE
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/tandcMasterListing";
      
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
 

var counterupdate = 0;
$("#updateAddrow").on("click",function() {
								
									var newRow = $("<tr>");
									var cols = "";

									
									cols += '<td class="form-group adjust"><input type="text" class="form-control " id="ddrname1" tabindex="6" data-toogle="tooltip" name="ddrname1" placeholder="Enter the Terms"></td>';
//									cols += '<td class="form-group adjust"><input type="text" class="form-control " id="ddrdesignation1" tabindex="6" data-toogle="tooltip" name="ddrdesignation1"></td>';       
//									cols += '<td class="form-group adjust"><input type="text" class="form-control " id="ddrqualification1" tabindex="6" data-toogle="tooltip" name="ddrqualification1"></td>';
//									cols += '<td class="form-group adjust"><input type="text" class="form-control " id="ddrexperience1" tabindex="6" data-toogle="tooltip" name="ddrname1"></td>';
//									cols += '<td class="form-group adjust"><div class="form-group" id="updatetableBranchDiv'+ counterupdate + '"><select class="form-control customMulti" tabindex="6" data-toogle="tooltip" multiple="multiple" onchange="getUpdateDepart(\''+counterupdate+'\')" name="updatetableBranch[]" id="updatetableBranch'
//											+ counterupdate + '"></select></div></td>';
//									cols += '<td class="form-group adjust"><div class="form-group" id="updateTableDepartmentDiv'+ counterupdate + '"><select class="form-control customMulti" tabindex="6" data-toogle="tooltip"  multiple="multiple" name="updateTableDepartment[]" id="updateTableDepartment'
//											+ counterupdate + '"></select></div></td>';
//									

									/*cols += '<td><button class="ibtnDel1 btn btn-md btn-danger fa fa-close">Remove</button></td>';*/

									newRow.append(cols);
									$("table.order-list1").append(newRow);
									counterupdate++;
									

  $(".customMulti").multiselect({
    includeSelectAllOption: true,
    buttonWidth: '100%',
    enableFiltering: true,
    enableCaseInsensitiveFiltering: true,
    maxHeight: 200
   
});
});



$("#updatedeleteRow").click(function() {
//	alert("hihi")

	if(counterupdate>1){
	var table = document.getElementById("updateperifheralTable");


	table.deleteRow(counterupdate );
	counterupdate -= 1
	
	}
	});
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
	
	 $("#tctype").val("");
	 $("#comments").val("");
   callToolTip231('tctype', 'hide');

//   alert($("companyName").val(""))
   callToolTip231('comments', 'hide');
  
 });
 
//SHOW ERRORS AND EMPTY FIELDS
 var callToolTip231 = function (fieldName, status) {
  if (fieldName == "tctype") {
     var errorMessage = "<span>Please Enter T&C Type</span>"
   }else if  (fieldName == "comments") {
     var errorMessage = "<span>Please Enter Discription</span>"
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
 
 $('#comments').on('focusout', function () {
   var usertype = $('#comments').val();

   if (usertype.trim() == "") {
       callToolTip231('comments', 'show');
   } else {
       callToolTip231('comments', 'hide');
   }
});
 
 $('#tctype').on('focusout', function () {
   var usertype = $('#tctype').val();

   if (usertype.trim() == "") {
       callToolTip231('tctype', 'show');
   } else {
       callToolTip231('tctype', 'hide');
   }
}); 

 $('#comments').on('focus', function () {
   callToolTip231('comments', 'destroy');
});
 
 $('#tctype').on('focus', function () {
   callToolTip231('tctype', 'destroy');
});
 
 // FUNCTION VALIDATION
 function validateDesignation() {
   var indexError = 0;

 
   if ($('#tctype').val().trim() === '') {
       callToolTip231('tctype', 'show');
       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   else if ($('#comments').val().trim() === '') {
       callToolTip231('comments', 'show');
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
   var serviceUrl = base_url + "/Master/Addtandc";
   var serviceUrl = serviceUrl;
   $.ajax({
       type: 'POST',
       url: serviceUrl,
       data: 'tctype=' + encodeURIComponent($("#tctype").val())
            + "&comments=" + $("#comments").val()
            + "&ddrname1=" + $("#ddrname1").val(),
        
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
               window.location.href = base_url + "/Admin/TandCMaster";
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
                   window.location.href = base_url + "/Admin/TandCMaster";
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
                   window.location.href = base_url + "/Admin/TandCMaster";
               }

           });

         }
   });
 }
   
 
 // FUNCTION EDIT
 function EditDesignation(srno,TandC_Type,Description) {
	
	
     $("#sr_no1").val(srno);
   $("#tctype").val(TandC_Type);
   $("#comments").val(Description);
 
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
     var serviceUrl = base_url + "/Master/Deletetandc";
     
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
                       window.location.href = base_url + "/Admin/TandCMaster";
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
                       window.location.href = base_url + "/Admin/TandCMaster";
                   }

               });

             }
       });
   });
 }
 
 