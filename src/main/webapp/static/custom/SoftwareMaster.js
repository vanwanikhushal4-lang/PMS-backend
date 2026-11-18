window.onload = function() {
	
	
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getSoftwareDetailsInEform";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
           async: false,
         success: function(data4) {
//            alert(data4)
        	 $("#preLoader").hide();
          	$("#datatype").removeClass("d-none");
            var table = $('#datatype').DataTable({
            	
                lengthChange: false,
                data: data4,
                 "pageLength": 5,
                 scrollX:true,
                 scrollY:true
            });

            table.buttons().container()
                    .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');
             
             }
     });
}
var callToolTip231 = function(fieldName, status) {

	if (fieldName == "sname") {
        var errorMessage = "<span>Please Enter Software Name<span>";
    }
	
    else if (fieldName == "frmdate"){
    	var errorMessage = "<span>Please Enter From Date<span>";
    }
    else if (fieldName == "scost"){
    	var errorMessage = "<span>Please Enter Software Cost<span>";
    }
    else if (fieldName == "rperiod") {
        var errorMessage = "<span>Please Enter Recovery Period<span>";
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


$('#sname').on('click', function() {
	callToolTip231('sname', 'destroy');
	});

$('#frmdate').on('click', function() {
	callToolTip231('frmdate', 'destroy');
	});
$('#scost').on('click', function() {
	callToolTip231('scost', 'destroy');
	});

$('#rperiod').on('click', function() {
	callToolTip231('rperiod', 'destroy');
	});



function validateCategory() {
    var indexError = 0;
   
    if ($('#sname').val().trim() === '') {
        callToolTip231('sname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#frmdate').val().trim() === '') {
        callToolTip231('frmdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#scost').val().trim() === '') {
        callToolTip231('scost', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   
    if ($('#rperiod').val().trim() === '') {
        callToolTip231('rperiod', 'show');
        if (indexError == 0) {
        }
        indexError = indexError + 1;
    }
//    if (document.querySelector('#checkcond:checked') == null) {
//    	// alert(   document.querySelector('#levelone:checked'));
//        callToolTip231('checkcond', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#subcategory2').val().trim() === '') {
//        callToolTip231('subcategory2Div', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}


$("#submit-btn").click(function() {

    if (!validateCategory()) {
    	event.preventDefault();
    } else {
    	saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {

	$("#sname").val("")
	$("#pcode").val("")

	$("#frmdatev").val("")
	$("#scost").val("")
	$("#rperiod").val("")
	
	callToolTip231('sname', 'destroy');
     callToolTip231('pcode', 'destroy');
	callToolTip231('frmdate', 'destroy');
	callToolTip231('scost', 'destroy');
     callToolTip231('rperiod', 'destroy');
//     callToolTip231('subcategory2Div', 'destroy');
});

function saveDataCompany()  {
//	alert($("#pcode").val())

	
	
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/SaveSoftwareDetails";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'sname=' + encodeURIComponent($("#sname").val())
            		+ '&scost=' + encodeURIComponent($("#scost").val())
            		+ '&pcode=' + encodeURIComponent($("#pcode").val())
            		+ '&frmdate=' + encodeURIComponent($("#frmdate").val())
            		+ '&rperiod=' + encodeURIComponent($("#rperiod").val())
            		+ '&checkbox=' + $("#activedc").val()
        }).done(function(data) {
//             alert("response: "+data)

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
                        window.location.href = base_url + "/EForm/SoftwareMaster";
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
                        window.location.href = base_url + "/EForm/SoftwareMaster";
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
                        window.location.href = base_url + "/EForm/SoftwareMaster";
                    }

                });

              }
        });
    //});
            }  


function DeleteSoftware(srno)  {

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
      
    	 var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/DeleteSoftwares";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'crno=' + srno

        }).done(function(data) {
//        	alert(data)
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
                        window.location.href = base_url + "/EForm/SoftwareMaster";
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
                        window.location.href = base_url + "/EForm/SoftwareMaster";
                    }

                });

              }
        });
    });
            }   



function EditSoftware(srno, sname,frmdate,cost,period,condition) {

	   $("#snameu").val(sname);
//	   $("#pcodeu").val(productcode);
	   $("#frmdateu").val(frmdate);
	   $("#scostu").val(cost);
	   $("#rperiodu").val(period);

	   $("#sr_no1").val(srno);
	   $("#checkcondu").val(condition);
	   
	   $("#Modelcategory").modal("show");
	   
	 }
	 
$("#update_category_btn").click(function () {
	
	//alert("in update category");
	 if (!validatecategoryUpdate())
	  {
//	       alert("fail")
	   event.preventDefault();
	 } else if (validatecategoryUpdate())
	 {
//	        alert("pass")
	     updatecategory();
	   }
	}).show();




function validatecategoryUpdate() {
	
	    var indexError = 0;
	   
	    if ($('#snameu').val().trim() === '') {
	    	callToolTipUpdate('snameu', 'show');
	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	    if ($('#frmdateu').val().trim() === '') {
	    	callToolTipUpdate('frmdateu', 'show');
	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	    if ($('#scostu').val().trim() === '') {
	    	callToolTipUpdate('scostu', 'show');
	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	   
	    if ($('#rperiodu').val().trim() === '') {
	    	callToolTipUpdate('rperiodu', 'show');
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
	if (fieldName == "snameu") {
        var errorMessage = "<span>Please Enter Software Name<span>";
    }

    else if (fieldName == "frmdateu"){
    	var errorMessage = "<span>Please Enter From Date<span>";
    }
    else if (fieldName == "scostu"){
    	var errorMessage = "<span>Please Enter Software Cost<span>";
    }
    else if (fieldName == "rperiodu") {
        var errorMessage = "<span>Please Enter Recovery Period<span>";
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




$('#snameu').on('click', function() {
	callToolTipUpdate('snameu', 'destroy');
	});

$('#frmdateu').on('click', function() {
	callToolTipUpdate('frmdateu', 'destroy');
	});
$('#scostu').on('click', function() {
	callToolTipUpdate('scostu', 'destroy');
	});

$('#rperiodu').on('click', function() {
	callToolTipUpdate('rperiodu', 'destroy');
	});

function updatecategory() {
	

 var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/UpdateSoftwareDetails";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: 'sname=' + encodeURIComponent($("#snameu").val())
        		+ '&scost=' + encodeURIComponent($("#scostu").val())
        		+ '&pcode=' + encodeURIComponent($("#pcodeu").val())
        		+ '&frmdate=' + encodeURIComponent($("#frmdateu").val())
        		+ '&rperiod=' + encodeURIComponent($("#rperiodu").val())
        		+ '&srno=' +encodeURIComponent($("#sr_no1").val())
        		+ '&checkbox=' + checkbox,
        		
        		
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
	                         window.location.href = base_url + "/EForm/SoftwareMaster";
	                     }
	                 });
	             } else if (data == "duplicate") {
	                 swal({
	                     title: "Duplicate Data!",
	                     text: "Record Already Exists",
	                     type: "warning",
	                     width: 300,
	                     height: 200,
//	            		 showCancelButton: false,
//	                   confirmButtonClass: "btn btn-danger",
//	                   cancelButtonClass: "btn btn-danger m-l-10",
//	                   confirmButtonText: "OK",
	                     buttons: false,
	                     allowOutsideClick: false,
	                     preConfirm: function () {
	                         var l = window.location;
	                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                         window.location.href = base_url + "/EForm/SoftwareMaster";
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
	                         window.location.href = base_url + "/EForm/SoftwareMaster";
	                     }
	                 });
	             }

	             //$('#companynameupdate').val("");

	         }
	     });
	 }
