 window.onload = function() {
//     alert("ggggg");
	
  $('#companyName').focus();
  $("#TType").multiselect({
      includeSelectAllOption: true,
      buttonWidth: '100%',
      enableCaseInsensitiveFiltering: true,
      maxHeight: 200
     
  });
    
 };
  
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
            }
    });
 
 
$("#submit-btn").click(function() {
    // alert("dgfsgf");
    if (!validateClosedTicket()) {
        //alert("in invalid");
        event.preventDefault();
    } else {
       // alert("in valid");
        saveDataUser();
    }
});



var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/ViewcloseTicket";
$.ajax({
	type : 'POST',
	url : serviceUrl,
	dataType : 'json',
	success : function(data4) {
		 //alert(data4)

		var table = $('#datatype').DataTable({
			lengthChange : false,
			pageLength : 5,
			data : data4,
			scrollY:300,
		    scrollX: true,
		    scrollCollapse: true,
		});

		table.buttons().container().appendTo(
				'#datatype_wrapper .col-sm-6:eq(0)');

	}

});


function saveDataUser() {
//    alert("in save")
	
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/AutoCloseTicket/AutoClosedInsert";
 	
    $.ajax({
        url: serviceUrl,
        type: 'post',
        data: 'TicketType=' + encodeURIComponent($("#TType").val())
                + '&companyName=' + encodeURIComponent($("#companyName").val())
                + '&TimeFormat=' + $("#Tformat").val()
                + '&rsn=' + $("#rsn").val()
                + '&Time=' + $("#closedtime").val(),
                
        success: function(data) {
//            alert(data)
           var data1=data.split(",");
                swal({
                    title: "Success!",
                    text: "Total="+data1[0]+" Inserted="+data1[1]+" Updated="+data1[2],
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
                        location.reload();
                    }

                })

           
        }
    })
}



function validateClosedTicket() {
   
   var indexError=0;
   
     var selectedValues = [];
    $("#TType :selected").each(function() {
        selectedValues.push($(this).val());
    });

    if (selectedValues.toString() === '')
    {
        callToolTip231('TType1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;

    }
    if ($('#Tformat').val().trim() === '') {
        callToolTip231('Tformat', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In Cpass: "+indexError);
    }

    
    if ($('#closedtime').val() === '') {
        callToolTip231('closedtime', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In type: "+indexError);
    }
    
    if ($('#rsn').val() === '') {
        callToolTip231('rsn', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In type: "+indexError);
    }
    
    if ($('#companyName').val() === '') {
      callToolTip231('companyName', 'show');
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

var callToolTip231 = function(fieldName, status) {

    if (fieldName == "TType1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Ticket Status<span>";
    } else if (fieldName == "Tformat") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Time Format<span>";
    }
    else if (fieldName == "closedtime") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Closed Time<span>";
    }
    else if (fieldName == "rsn") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Closed Reason<span>";
    } else if (fieldName == 'companyName') {
      var errorMessage = "<span>Please Select Company<span>";
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

$('#companyName').on('focusout', function() {
  var usertype = $('#companyName').val();
  if(usertype.trim() == "") {
    callToolTip231('companyName', 'show');
  } else {
    callToolTip231('companyName', 'hide');
  }
});

$('#TType1').on('focusout', function() {
    var usertype = $('#TType').val();

    if ($('#TType').find(":selected").text() == "") {
        callToolTip231('TType1', 'hide');
    }
    else if ($('#TType').val() === "")
    {
        callToolTip231('TType1', 'show');
    }
});

$('#rsn').on('focusout', function() {
    var usertype = $('#rsn ').val();

    if (usertype.trim() == "") {
        callToolTip231('rsn', 'show');
    }
    else {
        callToolTip231('rsn', 'hide');
    }
});


$('#Tformat').on('focusout', function() {
    var usertype = $('#Tformat ').val();

    if (usertype.trim() == "") {
        callToolTip231('Tformat', 'show');
    }
    else {
        callToolTip231('Tformat', 'hide');
    }
});

$('#closedtime').on('focusout', function() {
    var usertype = $('#closedtime').val();

    if (usertype.trim() == "") {
        callToolTip231('closedtime', 'show');
    }
    else {
        callToolTip231('closedtime', 'hide');
    }
});

$('#companyName').on('focus', function() {
  callToolTip231('companyName', 'destroy');
});

$('#TType').on('focus', function() {
    callToolTip231('TType1', 'destroy');
});

$('#rsn').on('focus', function() {
    callToolTip231('rsn', 'destroy');
});


$('#Tformat').on('focus', function() {
    callToolTip231('Tformat', 'destroy');
});
$('#closedtime').on('focus', function() {
    callToolTip231('closedtime', 'destroy');
});


$("#resetbtn").click(function() {
//    alert("in reset")
  
    $("#closedtime").val("");
    $("#Tformat").val("");   
    $("#companyName").val('').trigger('change');
    $("#rsn").val('').trigger('change');
    callToolTip231('companyName', 'hide');
    callToolTip231('TType1', 'hide');
    callToolTip231('Tformat', 'hide');
    callToolTip231('closedtime', 'hide');
    callToolTip231('rsn', 'hide');
    $("#TType option:selected").prop("selected", false);
        $("#TType").multiselect('refresh');
        $("#TType").val("")
})

function DeleteAutoCloseTicket(srno) {
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
    	var serviceUrl = base_url + "/Master/deleteAutoCloseTicket";
    
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'srno=' + srno

        }).done(function (data) {
            //  alert("dfgsfd"+data)

            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Deleted Successfully",
                    type: "success",
                    width: 300,
                    height: 200,

                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function () {
                    	
                             location.reload();
                         
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

