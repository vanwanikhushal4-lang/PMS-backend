window.onload = function () {
	multiBranchName();
	multiDepartmentName();
    $('#days').val("00");
    $('#hours').val("00");
    $('#minutes').val("00");
    $('#seconds').val("00");
    
    var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//   	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
   	var serviceUrl = base_url + "/Master/getOutageCompanyName";

   $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json'
    }).done(function(data) {

        var html = " <select class='form-control' tabindex='2' id='companyname' name='companyname'>";
		html += "<option value=''>Please Select Company</option>";
		var ip;
        for (var i = 0; i < data.length; i++) {
        	ip = data[i];
        	html += '<option value="' + ip + '">' + ip
                    + '</option>';
        }
        html += "</select>";

        document.getElementById("companyname").innerHTML = html;
      
    });
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/TPActivity/OutageMasterListing";
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function (data4) {
//alert(data4)
	var table = $('#datatype').DataTable({
		columnDefs: [
            {
                render: function (data, type, full, meta) {
                    return "<div class='text-wrap width-400'>" + data + "</div>";
                },
                targets: 3
            },
            {
                render: function (data, type, full, meta) {
                    return "<div class='text-wrap width-200'>" + data + "</div>";
                },
                targets: 4
            }
         ],
                lengthChange: false,
                data: data4,
                scrollX: true,
                "pageLength": 5,
            });
	

            table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');
        }

    });
};
////////////// ONLOAD ENDS //////////

function getBranchNameList(companyname) {
//alert(companyname)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getBranchForLoginMaster";
	var serviceUrl = base_url + "/Master/getOutageBranchName";

   $.ajax({
       url: serviceUrl,
       type: 'POST',
        dataType: 'json',
       data: "companyname=" + encodeURIComponent(companyname)
   }).done(function(data) {

       var html = " <select class='form-control' tabindex='2' id='branchname' name='branchname' onchange='getDepartmentNameList(this.value)' multiple='multiple'>";
       var branch;
       for (var i = 0; i < data.length; i++) {

    	   branch = data[i];

           html += '<option value="' + branch + '">' +branch+ '</option>';
       }

       html += "</select>";

       document.getElementById("branchname1").innerHTML = html;
       multiBranchName();

   });

}
function multiBranchName() {
    $("#branchname").multiselect({
        includeSelectAllOption: true,
        buttonWidth: '100%',
        enableCaseInsensitiveFiltering: true,
        maxHeight: 200
    });
}

function getDepartmentNameList(branchname) {
	
	var selectedBranch = [];
	$("#branchname :selected").each(function() {
		selectedBranch.push($(this).val());
	});
	
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/Master/getDepartmentForUserScope";
		var serviceUrl = base_url + "/Master/getOutageDepartmentName";

	   $.ajax({
	       url: serviceUrl,
	       type: 'POST',
	        dataType: 'json',
	        data: 'companyname=' + encodeURIComponent($("#companyname").val())
	         + '&branchName=' + encodeURIComponent(selectedBranch),
	   }).done(function(data) {
		  
		   jsonObject = data.map(JSON.stringify);
		   uniqueSet = new Set(jsonObject);
           uniqueData = Array.from(uniqueSet).map(JSON.parse);

	       var html = " <select class='form-control' tabindex='2' id='departmentname' name='departmentname' multiple='multiple'>";
	       var branch;
	       for (var i = 0; i < uniqueData.length; i++) {

	    	  var department = uniqueData[i];

	           html += '<option value="' + department + '">' +department+ '</option>';
	       }

	       html += "</select>";

	       document.getElementById("departmentname1").innerHTML = html;
	       multiDepartmentName();

	   });

	}
	function multiDepartmentName() {
	    $("#departmentname").multiselect({
	        includeSelectAllOption: true,
	        buttonWidth: '100%',
	        enableCaseInsensitiveFiltering: true,
	        maxHeight: 200
	       
	        
	    });
	}



var callToolTip231 = function (fieldName, status) {

    if (fieldName == "companyname") {
        var errorMessage = "<span>Please Select Company<span>";
    } 
    else if (fieldName == "branchname1") {
        var errorMessage = "<span>Please Select Branch<span>";
    } 
    else if (fieldName == "departmentname1") {
        var errorMessage = "<span>Please Select Department<span>";
    } 
    else if (fieldName == "severity") {
        var errorMessage = "<span>Please Select Severity<span>";
    } 
    else if (fieldName == "message") {
        var errorMessage = "<span>Please Enter Message<span>";
    } 
    else if (fieldName == "days") {
        var errorMessage = "<span>Please Enter No Of Days<span>";
    } 
    else if (fieldName == "hours") {
        var errorMessage = "<span>Please Enter No Of Hours<span>";
    } 
    else if (fieldName == "minutes") {
        var errorMessage = "<span>Please Enter No Of Minutes<span>";
    } 
    else if (fieldName == "seconds") {
        var errorMessage = "<span>Please Enter No Of Seconds<span>";
    } 
    else if (fieldName == "wrongDays") {
        var errorMessage = "<span>Please Enter Correct Days<span>";
    } 
    else if (fieldName == "wrongHours") {
        var errorMessage = "<span>Please Enter Correct Hours<span>";
    } 
    else if (fieldName == "wrongMinutes") {
        var errorMessage = "<span>Please Enter Correct Minutes<span>";
    } 
    else if (fieldName == "wrongSeconds") {
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

$('#companyname').on('focusout', function () {
    var usertype = $('#companyname').val();

    if (usertype.trim() == "") {
        callToolTip231('companyname', 'show');
    } else {
        callToolTip231('companyname', 'hide');
    }
});

$('#branchname1').on('focusout', function () {
if ($('#branchname').find(":selected").text() === "") {
	callToolTip231('branchname1', 'hide');
  } else if ($('#branchname').val() === "") {
	callToolTip231('branchname1', 'show');
  }
});
$('#departmentname1').on('focusout', function () {
	if ($('#departmentname').find(":selected").text() === "") {
		callToolTip231('departmentname1', 'hide');
	  } else if ($('#departmentname').val() === "") {
		callToolTip231('departmentname1', 'show');
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
$('#message').on('focusout', function () {
    var usertype = $('#message').val();

    if (usertype.trim() == "") {
        callToolTip231('message', 'show');
    } else {
        callToolTip231('message', 'hide');
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

$('#companyname').on('focus', function () {
	callToolTip231('companyname', 'destroy');
});
$('#branchname1').on('focus', function () {
	callToolTip231('branchname1', 'destroy');
});
$('#departmentname1').on('focus', function () {
	callToolTip231('departmentname1', 'destroy');
});
$('#severity').on('focus', function () {
	callToolTip231('severity', 'destroy');
});
$('#message').on('focus', function () {
	callToolTip231('message', 'destroy');
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

function validateOutageForm() {
    var indexError = 0;

    if ($('#companyname').val().trim() === '') {
        callToolTip231('companyname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    var selectedBranch = [];
    $("#branchname1 :selected").each(function() {
    	selectedBranch.push($(this).val());
    });

    if (selectedBranch.toString() === '') {
    	callToolTip231('branchname1', 'show');
        indexError = indexError + 1;
    }
    
    var selectedDepartment = [];
    $("#departmentname1 :selected").each(function() {
    	selectedDepartment.push($(this).val());
    });

    if (selectedDepartment.toString() === '') {
    	callToolTip231('departmentname1', 'show');
        indexError = indexError + 1;
    }
    
    if ($('#severity').val().trim() === '') {
        callToolTip231('severity', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#message').val().trim() === '') {
        callToolTip231('message', 'show');
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

    if (!validateOutageForm()) {
        event.preventDefault();
    } else {
    saveOutageForm();
    }
}).show();

$("#resetbtn").click(function () {
    $("#companyname").val("");
    callToolTip231('companyname', 'hide');
    callToolTip231('branchname1', 'hide');
    $("#branchname option:selected").prop("selected", false);
    $("#branchname").multiselect('refresh');
    callToolTip231('departmentname1', 'hide');
    $("#departmentname option:selected").prop("selected", false);
    $("#departmentname").multiselect('refresh');
    $("#severity").val("");
    callToolTip231('severity', 'hide');
    $("#message").val("");
    callToolTip231('message', 'hide');
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
function saveOutageForm() {

	var selectedBranch = [];
	$("#branchname :selected").each(function() {
		selectedBranch.push($(this).val());
	});
	var selectedDepartment = [];
	$("#departmentname :selected").each(function() {
		selectedDepartment.push($(this).val());
	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/TPActivity/SubmitOutageData";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: 'companyname=' + encodeURIComponent($("#companyname").val())
        		+ '&branchname=' + encodeURIComponent(selectedBranch)
        		+ '&departmentname=' + encodeURIComponent(selectedDepartment)
        		+ '&severity=' + encodeURIComponent($("#severity").val())
        		+ '&message=' + encodeURIComponent($("#message").val())
                + '&days=' + encodeURIComponent($("#days").val())
                + '&hours=' + encodeURIComponent($("#hours").val())
                + '&minutes=' + encodeURIComponent($("#minutes").val())
                + '&seconds=' + encodeURIComponent($("#seconds").val())
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
                    window.location.href = base_url + "/TP/OutageMaster";
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
                    window.location.href = base_url + "/TP/OutageMaster";
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
                    window.location.href = base_url + "/TP/OutageMaster";
                }

            });

        }
    });
    //});
}


function DeleteOutage(srno) {
//alert("srno"+srno)
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
    	var serviceUrl = base_url + "/TPActivity/deleteOutage";
    
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
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/TP/OutageMaster";
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
                        window.location.href = base_url + "/TP/OutageMaster";
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
          