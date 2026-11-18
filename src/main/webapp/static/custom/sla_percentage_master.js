 window.onload = function() {
// $('#companyName').focus();
     
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
//	                    document.getElementById("companyNameupdate").innerHTML = html;
	              }
	     });

    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getSlaListing";
    
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {



             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
//                 scrollX: true,
                  "pageLength": 5,
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });

 }


var callToolTip231 = function(fieldName, status) {

    if (fieldName == "companyName") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Company <span>";
    }
//     else if (fieldName == "priority1") {
//        //$("#email").tooltip('destroy');
//        var errorMessage = "<span>Please Enter Character only for Priority Name<span>";
    
    else if (fieldName == 'percentage') {
    	var errorMessage = "<span>Please Enter SLA Value<span>";
    }
    else if (fieldName == 'percentagecorrect') {
    	var errorMessage = "<span>Please Enter Correct SLA Value<span>";
    }
    

    $("#" + fieldName).tooltip({
        trigger: 'manual',
        at:'center',
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
$('#percentagecorrect').on('focusout', function() {
	var usertype = $('#percentage').val();
	if(usertype.trim() == "") {
		
		callToolTip231('percentagecorrect', 'show');
		
	} else {
		callToolTip231('percentagecorrect', 'hide');
	}
});

$('#percentage').on('focusout', function() {
    var usertype = $('#percentage').val();

    if (usertype.trim() == "") {
        callToolTip231('percentage', 'show');
    }
    else {
        callToolTip231('percentage', 'hide');
    }
});


$('#companyName').on('focus', function() {
callToolTip231('companyName', 'destroy');
//callToolTip231('priority1', 'destroy');
});

$('#percentage').on('focus', function() {
	callToolTip231('percentage', 'destroy');
});
$('#percentagecorrect').on('focus', function() {
	callToolTip231('percentagecorrect', 'destroy');

});
function validatePriority() {
    var indexError = 0;
    if ($('#companyName').val().trim() === '') {
        callToolTip231('companyName', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }

    if ($('#percentage').val()=== '') {
        callToolTip231('percentage', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    var TemplateData = $("#percentage").val();
    
    
   if(TemplateData !=""){
    
	//alert("in sla: " + TemplateData)
	var pattPercent = new RegExp(/(^100([.]0{1,2})?)$|(^\d{1,2}([.]\d{1,2})?)$/g);
	var testResultPercent = pattPercent.test(TemplateData);
	//alert(testResultPercent);
	if (testResultPercent === false) {

		callToolTip231('percentagecorrect', 'show');
		if (indexError == 0) {

		}

		indexError = indexError + 1;
		console.log("in Templatedeatil :" + indexError)

	}
    }
    
    
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
    

	  

}


$("#submit-btn").click(function() {

   if (!validatePriority()) {
     //   alert("fail")
    event.preventDefault();
   } else {
 //       alert("pass")
        saveDataCompany();
   }
}).show();

$("#resetbtn").click(function() {
    $("#companyName").val("");
     callToolTip231('companyName', 'hide');
     //callToolTip231('priority1', 'hide');
    $("#percentage").val("");
    callToolTip231('percentage', 'hide');
    $("#percentagecorrect").val("");
    callToolTip231('percentagecorrect', 'hide');
});

//insert data
function saveDataCompany()  {

	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/Saveslapercentage";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'company=' + encodeURIComponent($("#companyName").val())
            		+ '&percentage=' + encodeURIComponent($("#percentage").val())
        }).done(function(data) {
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
                        window.location.href = base_url + "/Admin/Sla_Percentage_Master";
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
                        window.location.href = base_url + "/Admin/Sla_Percentage_Master";
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
                        window.location.href = base_url + "/Admin/Sla_Percentage_Master";
                    }

                });

              }
        });
    //});
            }  


function DeleteSlaTemplate(srno)  {
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
     	var serviceUrl = base_url + "/Master/DeleteSlaTemplate";
    	
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
                        window.location.href = base_url + "/Admin/Sla_Percentage_Master";
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
                        window.location.href = base_url + "/Admin/Sla_Percentage_Master";
                    }

                });

              }
        });
    });
            }   
                


function EditSlaTemplate(srno,cname,slapercentage) {
    
	//callToolTip231('priority', 'destroy');
	$('#sr_no1').val(srno);
    $('#companyNameupdate').val(cname);
    $('#percentage1').val(slapercentage);
    $("#modelpriority1").modal("show");

}

$("#update_PriorityType_btn").click(function() {
    if (!validatePriorityUpdate())
    {
       // alert("fail")
        event.preventDefault();
    } else if (validatePriorityUpdate())
    {
       // alert("pass")
    updatecompanySave111();
      }
}).show();

function updatecompanySave111() {
	$('#sr_no1').val();
	
	$('#companyNameupdate').val();
	$('#percentage1').val();
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updateSlaTemplateMaster";
     
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        
        data: "srno=" + $('#sr_no1').val()
        	+"&company=" + encodeURIComponent($('#companyNameupdate').val())
        		+ "&percentage=" + encodeURIComponent($('#percentage1').val()),
                
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
                        window.location.href = base_url + "/Admin/Sla_Percentage_Master";
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
                        window.location.href = base_url + "/Admin/Sla_Percentage_Master";
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
                        window.location.href = base_url + "/Admin/Sla_Percentage_Master";
                    }
                });
            }
            
       //      $('#updatecompanyname').val("");
            
                  }
                   });
                   }
                   
var callToolTipUpdate = function(fieldName, status) {

    if (fieldName == "companyNameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Company Name<span>";
    }
   
    else if (fieldName == "percentage1") {
    	var errorMessage = "<span>Please Enter SLA Value<span>";
    }
    else if (fieldName == "slacorrect") {
    	var errorMessage = "<span>Please Enter Correct SLA Value<span>";
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

$('#companyNameupdate').on('focusout', function() {
    var usertype = $('#companyNameupdate').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('companyNameupdate', 'show');
    }
    else {
        callToolTipUpdate('companyNameupdate', 'hide');
    }
});

$('#percentage1').on('focusout', function() {
    var usertype = $('#percentage1').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('percentage1', 'show');
    }
    else {
        callToolTipUpdate('percentage1', 'hide');
    }
});
//$('#slacorrect').on('focusout', function() {
//    var usertype = $('#slacorrect').val();
//
//    if (usertype.trim() == "") {
//        callToolTipUpdate('slacorrect', 'show');
//    }
//    else {
//        callToolTipUpdate('slacorrect', 'hide');
//    }
//});

$('#companyNameupdate').on('focus', function() {
	callToolTipUpdate('companyNameupdate', 'destroy');
	//callToolTipUpdate('companyNameupdate', 'destroy');
});
$('#percentage1').on('focus', function() {
	callToolTipUpdate('percentage1', 'destroy');
});
$('#slacorrect').on('click', function() {
	callToolTipUpdate('slacorrect', 'destroy');
});
function validatePriorityUpdate() {
    var indexError = 0;
    if ($('#companyNameupdate').val().trim() === '') {
        callToolTipUpdate('companyNameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#percentage1').val() === '') {
        callToolTipUpdate('percentage1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    	
  
  
	// alert("in sla: "+TemplateData)
    var TemplateData=$('#percentage1').val();
 
	var pattPercent = new RegExp(/(^100([.]0{1,2})?)$|(^\d{1,2}([.]\d{1,2})?)$/g);
		
	var testResultPercent = pattPercent.test(TemplateData);
	 //alert(testResultPercent);
	 
	//alert( $('#percentage1').val().length);
	var lenth=$('#percentage1').val().length;
	if (testResultPercent === false && lenth>0 ) {
  //alert("inside if  ");
		callToolTipUpdate('slacorrect', 'show');
		if (indexError == 0) {

		}

		indexError = indexError + 1;
		//console.log("in Templatedeatil :" + indexError)

	}
    
    
    if (indexError > 0) {
        return false;

    } else {
        return true;
        
        callToolTipUpdate('slacorrect', 'destroy');
    }
    
    
}
