window.onload = function() {
	  getModuleDetails();
	  getModuleDetailsup();
	  var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/Master/funclist";
	      
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
		
		 $("#sname").val("");
		 $("#functionName").val("");
	   callToolTip231('functionName', 'hide');

	//   alert($("companyName").val(""))
	   callToolTip231('sname', 'hide');
	  
	 });
	 
	//SHOW ERRORS AND EMPTY FIELDS
	 var callToolTip231 = function (fieldName, status) {
		   if (fieldName == "sname") {
			     var errorMessage = "<span>Please Select Modules Name</span>"
			   } else if (fieldName == "functionName") {
			     var errorMessage = "<span>Please Enter Function</span>"
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
	 
	 $('#sname').on('focusout', function () {
	   var usertype = $('#sname').val();

	   if (usertype.trim() == "") {
	       callToolTip231('sname', 'show');
	   } else {
	       callToolTip231('sname', 'hide');
	   }
	});
	 
	 $('#functionName').on('focusout', function () {
	   var usertype = $('#functionName').val();

	   if (usertype.trim() == "") {
	       callToolTip231('functionName', 'show');
	   } else {
	       callToolTip231('functionName', 'hide');
	   }
	}); 

	 $('#sname').on('focus', function () {
	   callToolTip231('sname', 'destroy');
	});
	 
	 $('#functionName').on('focus', function () {
	   callToolTip231('functionName', 'destroy');
	});
	 
	 // FUNCTION VALIDATION
	 function validateDesignation() {
	   var indexError = 0;

	   if ($('#sname').val().trim() === '') {
	       callToolTip231('sname', 'show');
	       if (indexError == 0) {

	       }
	       indexError = indexError + 1;
	   }
	   if ($('#functionName').val().trim() === '') {
	       callToolTip231('functionName', 'show');
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
	 

function EditDesignation(srno, module, functions) {
	
	   $("#designationNameupdate").val(functions);
	   $("#snameup").val(module);
	   $("#sr_no1").val(srno);
	   $("#modeldesignation").modal("show");
	   
	 }

$("#submitfunction").click(function() {
	  if (!validateDesignation()) {
	       event.preventDefault();
	   } else {
	     // CALL FUNCTION SAVE DESIGNATION
		   saveFunctionMaster();
	   }
	

	
}).show();

function saveFunctionMaster(){


var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/SetFunction";

$.ajax({
    type: 'POST',
    url: serviceUrl,
    data: "moduleName=" + $('#sname').val() + "&functionName=" + $("#functionName").val(),
    success: function(data) {
        if (data == "success") {
            swal({
              title: "Successful!",
              text: "Record Inserted Successfully",
              type: "success",
              width: 300,
              height: 200,
//         showCancelButton: false,
//            confirmButtonClass: "btn btn-danger",
//            cancelButtonClass: "btn btn-danger m-l-10",
//            confirmButtonText: "OK",
              buttons: false,
              allowOutsideClick: false,
              preConfirm: function () {
                  var l = window.location;
                  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                  window.location.href = base_url + "/Admin/FunctionMaster";
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
                      window.location.href = base_url + "/Admin/FunctionMaster";
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
                      window.location.href = base_url + "/Admin/FunctionMaster";
                  }

              });

            }
      }
});


}



function getModuleDetails() {
	
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getModuleName";
    var selectedValue = $("#sname").val(); // Get the currently selected value

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'moduleName=' + encodeURIComponent(selectedValue),
        success: function(data4) {
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data4.length; i++) {
                var value = data4[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            $("#sname").html(html); // Update the select element
            $("#sname").val(selectedValue); // Set the selected value
        }
    });
}


$("#update_designation_btn").click(function () {
	   if (!validateDesignationUpdate())
	   {
//	       alert("fail")
	       event.preventDefault();
	   } else if (validateDesignationUpdate())
	   {
//	        alert("pass")
	     updateDesignation();
	   }
	}).show();

function updateDesignation() {
	   var l = window.location;
	   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   var serviceUrl = base_url + "/Master/UpdateDesignationup";
	   
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         data: "company=" + $('#snameup').val()
	                 + "&designation=" + $("#designationNameupdate").val()
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
	                         window.location.href = base_url + "/Admin/FunctionMaster";
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
	                         window.location.href = base_url + "/Admin/FunctionMaster";
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
	                         window.location.href = base_url + "/Admin/FunctionMaster";
	                     }
	                 });
	             }

	             $('#companynameupdate').val("");

	         }
	     });
	 }
	 

function validateDesignationUpdate() {
	   var indexError = 0;

	   if ($('#snameup').val().trim() === '') {
	     callToolTipUpdate('snameup', 'show');
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


var callToolTipUpdate = function (fieldName, status) {
	   if (fieldName == "snameup") {
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
	 
	 $('#snameup').on('focusout', function () {
	   var usertype = $('#snameup').val();

	   if (usertype.trim() == "") {
	     callToolTipUpdate('snameup', 'show');
	   } else {
	     callToolTipUpdate('snameup', 'hide');
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

	 $('#snameup').on('focus', function () {
	   callToolTipUpdate('snameup', 'destroy');
	});
	 
	 $('#designationNameupdate').on('focus', function () {
	   callToolTipUpdate('designationNameupdate', 'destroy');
	});
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
	     var serviceUrl = base_url + "/Master/DeleteDesignation";
	     
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
function getModuleDetailsup() {
	//alert("jjijji")
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getModuleNameup";
    var selectedValue = $("#snameup").val(); // Get the currently selected value

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'moduleName=' + encodeURIComponent(selectedValue),
        success: function(data4) {
            var html = "<option value=''>-- Please Select --</option>";
            for (var i = 0; i < data4.length; i++) {
                var value = data4[i];
                html += '<option value="' + value + '">' + value + '</option>';
            }
            $("#snameup").html(html); // Update the select element
            $("#snameup").val(selectedValue); // Set the selected value
        }
    });
}







