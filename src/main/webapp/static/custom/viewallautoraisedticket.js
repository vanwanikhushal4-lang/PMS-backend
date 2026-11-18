
window.onload = function () {
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/TPActivity/getAllAutoRaisedTicketList";
 	
//    var serviceUrl = "getAllAutoRaisedTicketList";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',

        success: function (data5) {
//                      alert(data5)
        	$("#preLoader").hide();
        	$("#Listing_Copy").removeClass("d-none");
            var table = $('#Listing_Copy').removeAttr('width').DataTable({
                lengthChange: false,
                pageLength: 5,
//                paging: false,
                data: data5,
                destroy: true,
                scrollX: true,
                columnDefs:[
                    {"width": "350", "targets": 6}                
                ],
                fixedColumns: false
            });
            table.buttons().container()
                    .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
        }
    });
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getPriorityName";
//     var getPriorityName='getPriorityName';  
    $.ajax({

        url :serviceUrl,
        type : 'POST',
        dataType: 'json',
    }).done(function(data) {
       // alert(data)

//        var pollingHost=data;
//        var d = pollingHost.split(",");
//        var length=d.length-1;
        var html =" <select class='form-control' tabindex='13' id='priorityupdateTDassign' name='priorityupdateTDassign' '>";
//        html=html+'<option value="">--Please Select Priority--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' +data[i]+ '">' + data[i]
            + '</option>';
        }

        document.getElementById("priorityupdateTDassign").innerHTML=html;
    });
}

function viewTicket(id)
{
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/gatherUserTicketDetails";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(id),
//                + '&cno=' + $("#cno").val(),

        success: function (data) {

            var T_REQUESTER = data[0]["T_REQUESTER"];
            var T_COMPANY = data[0]["T_COMPANY"];
            var T_BRANCH = data[0]["T_BRANCH"];
            var T_PHONE = data[0]["T_PHONE"];
            var T_MAIL = data[0]["T_MAIL"];
            var T_CATEGORY = data[0]["T_CATEGORY"];
            var T_SUBCAT = data[0]["T_SUBCAT"];
            var T_SUBJECT = data[0]["T_SUBJECT"];
            var T_DATE = data[0]["T_DATE"];
            var STATUS = data[0]["STATUS"];
            var T_ID = data[0]["T_ID"];
            var T_DESC = data[0]["T_DESC"];
            var PRIORITY = data[0]["PRIORITY"];
            var REQUEST_MODE = data[0]["REQUEST_MODE"];
             var T_ATTACH1_NAME = data[0]["T_ATTACH1_NAME"];

            $("#nameupdateUD").val(T_REQUESTER);
            $("#companyupdateUD").val(T_COMPANY);
            $("#siteupdateUD").val(T_BRANCH);
            $("#phoneupdateUD").val(T_PHONE);
            $("#emailupdateUD").val(T_MAIL);
            $("#categoryupdateTD").val(T_CATEGORY);
            $("#groupupdateTD").val(T_SUBCAT);
            $("#subjectupdateTD").val(T_SUBJECT);
            $("#raisedateupdateTD").val(T_DATE);
            $("#statusupdateTD").val(STATUS);
            $("#ticketidupdateTD").val(T_ID);
            $("#descriptionupdateTD").val(T_DESC);
            $("#priorityupdateTD").val(PRIORITY);
            $("#RequestModeupdateTD").val(REQUEST_MODE);
            
if((T_ATTACH1_NAME.toUpperCase()=== ("NO FILE AVAILABLE"))||(T_ATTACH1_NAME===("NA"))||(T_ATTACH1_NAME===("null"))||(T_ATTACH1_NAME===("undefined"))||(T_ATTACH1_NAME===("")))
       {
          $('#hidedownload').hide();
          $('#nofileattach').show();
       }else
       {
           $('#hidedownload').show();
             $('#nofileattach').hide();
         document.getElementById('empPic').innerHTML=T_ATTACH1_NAME;
    document.getElementById('filename').value=T_ATTACH1_NAME;  
       }
        }
    });
    $("#modelview").modal("show");
}

$('#close-btn').on("click", function () {
    $("#modelview").modal("hide");
});

function assignTicket(id)
{
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/TPActivity/gatherTicketDetails";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(id),
//                + '&cno=' + $("#cno").val(),

        success: function (data) {
//                      alert(data5)
            var T_REQUESTER = data[0]["T_REQUESTER"];
            var T_COMPANY = data[0]["T_COMPANY"];
            var T_BRANCH = data[0]["T_BRANCH"];
            var T_PHONE = data[0]["T_PHONE"];
            var T_MAIL = data[0]["T_MAIL"];
            var T_CATEGORY = data[0]["T_CATEGORY"];
            var T_SUBCAT = data[0]["T_SUBCAT"];
            var T_SUBJECT = data[0]["T_SUBJECT"];
            var T_DATE = data[0]["T_DATE"];
            var STATUS = data[0]["STATUS"];
            var T_ID = data[0]["T_ID"];
            var T_DESC = data[0]["T_DESC"];
            var PRIORITY = data[0]["PRIORITY"];
            var REQUEST_MODE = data[0]["REQUEST_MODE"];

            var TP_NAME = data[0]["TP_NAME"];
            var TP_COMPANY = data[0]["TP_COMPANY"];
            var TP_BRANCH = data[0]["TP_BRANCH"];
            var TP_PHONE = data[0]["TP_PHONE"];
            var TP_MAIL = data[0]["TP_MAIL"];

            $("#nameupdateTP").val(TP_NAME);
            $("#companyupdateTP").val(TP_COMPANY);
            $("#siteupdateTP").val(TP_BRANCH);
            $("#phoneupdateTP").val(TP_PHONE);
            $("#emailupdateTP").val(TP_MAIL);

            $("#nameupdateUDassign").val(T_REQUESTER);
            $("#companyupdateUDassign").val(T_COMPANY);
            $("#siteupdateUDassign").val(T_BRANCH);
            $("#phoneupdateUDassign").val(T_PHONE);
            $("#emailupdateUDassign").val(T_MAIL);
            $("#categoryupdateTDassign").val(T_CATEGORY);
            $("#groupupdateTDassign").val(T_SUBCAT);
            $("#subjectupdateTDassign").val(T_SUBJECT);
            $("#raisedateupdateTDassign").val(T_DATE);
            $("#statusupdateTDassign").val(STATUS);
            $("#ticketidupdateTDassign").val(T_ID);
            $("#descriptionupdateTDassign").val(T_DESC);
            $("#priorityupdateTDassign").val(PRIORITY);
            $("#RequestModeupdateTDassign").val(REQUEST_MODE);



        }
    });

    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getCategoryDetails";
//    var getEnggCat = 'getEnggCategoryName';
    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
    }).done(function (data) {
        // alert(data)

//        var pollingHost = data;
//        var d = pollingHost.split(",");
//        var length = d.length - 1;
        var html = " <select class='form-control' tabindex='7' id='enggcat' name='enggcat' onchange='JavaScript:change_enggsubtype(this.value)'>";
        html = html + '<option value="">--Please Select Category--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("enggcat").innerHTML = html;
    });
//    $("#enggassign").val("");
    $("#modelassign").modal("show");
}

function change_enggsubtype(category)
{

	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getSubCategoryEnggName";
//    var getUsername = 'getSubCategoryEnggName';
    $.ajax({

        url: serviceUrl,
        type: 'POST',
        data: 'categ=' + encodeURIComponent(category),
        dataType: 'json',
    }).done(function (data) {
        // alert(data)

//        var pollingHost = data;
//        var d = pollingHost.split(",");
//        var length = d.length - 1;
        var html = " <select class='form-control' tabindex='7' id='enggassign' name='enggassign'>";
        html = html + '<option value="">--Please Select Group--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("enggassign").innerHTML = html;
    });
}

$('#submit-btn').on("click", function () {
//    alert("submit")
    if(!validateForm200())
    {
//        alert("fail")
        event.preventDefault();
    }
    else if (validateForm200())
    {
//        alert("pass")
    	var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/TPActivity/InsertAssignTicket";

    	var form=$('form')[0];
      	 var formData= new FormData(form);
     	
    $.ajax({

    	url: serviceUrl,
        type: 'post',
        data: formData,
        mimeType: "multipart/form-data",
        contentType: false,
        processData: false,
        cache: false,
//        data: 'nameupdateTP=' + $("#nameupdateTP").val()
//                + '&companyupdateTP=' + $("#companyupdateTP").val()
//                + '&siteupdateTP=' + $("#siteupdateTP").val()
//                + '&phoneupdateTP=' + $("#phoneupdateTP").val()
//                + '&emailupdateTP=' + $("#emailupdateTP").val()
//
//                + '&nameupdateUD=' + $("#nameupdateUDassign").val()
//                + '&companyupdateUD=' + $("#companyupdateUDassign").val()
//                + '&siteupdateUD=' + $("#siteupdateUDassign").val()
//                + '&phoneupdateUD=' + $("#phoneupdateUDassign").val()
//                + '&emailupdateUD=' + $("#emailupdateUDassign").val()
//                + '&categoryupdateTD=' + $("#categoryupdateTDassign").val()
//                + '&groupupdateTD=' + $("#groupupdateTDassign").val()
//                + '&subjectupdateTD=' + $("#subjectupdateTDassign").val()
//                + '&raisedateupdateTD=' + $("#raisedateupdateTDassign").val()
//                + '&statusupdateTD=' + $("#statusupdateTDassign").val()
//                + '&ticketidupdateTD=' + $("#ticketidupdateTDassign").val()
//                + '&descriptionupdateTD=' + $("#descriptionupdateTDassign").val()
//                + '&priorityupdateTD=' + $("#priorityupdateTDassign").val()
//                + '&statusupdateENG=' + $("#statusupdateENG").val()
//        
//                + '&enggcat=' + $("#enggcat").val()
//                + '&enggassign=' + $("#enggassign").val()
//        + '&holdnotes=' + $("#holdnotes").val()
    }).done(function (data) {
        if (data === "success") {
            if(($("#statusupdateENG").val())== "Hold")
            {
              swal({
                    title: "Successful!",
                    text: 'Ticket Status Changed to Hold Successfully', 
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
                        location.reload();
                    }

                })  
            }
            else
            {
                swal({
                    title: "Successful!",
                    text: 'Ticket Assigned Successfully', 
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
                        location.reload();
                    }

                })
            }
                
               }
               else
                 {
                   swal({
                   title: 'Unsuccessful!', 
		   text: 'Failed to Change Ticket Status', 
		   type: 'error',
                    width: 300,
                    height: 200,
// 		  		    showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function () {
                        location.reload();
                    }

                })
                 }
        


    });
    }
});

function downFile()
      {
//          alert("in downfile");
          var filename=$('#filename').val();
           window.location = "DownloadFileViewAllRaisedTP.action?filename=" + filename;
       }

var callToolTip231 = function (fieldName, status) {
    if (fieldName === "statusupdateENG") {
        var errorMessage = "<span>Please Select Status<span>";
    }
    else if (fieldName === "enggcat") {      
        var errorMessage = "<span>Please Select Category<span>";
    }
    else if (fieldName === "enggassign") {
        var errorMessage = "<span>Please Select Engineer<span>";
    }
     else if (fieldName === "holdnotes") {
        var errorMessage = "<span>Please Enter Hold Reason<span>";
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

function validateForm200()
{
 
      var indexError = 0;
   
   if ($('#statusupdateENG').val() === '') {
        //('fill statusupdateENG');
        callToolTip231('statusupdateENG', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#enggcat').val().trim() === '') {
        //('fill enggcat');
        callToolTip231('enggcat', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#enggassign').val().trim() === '') {
        //('fill enggassign');
        callToolTip231('enggassign', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#statusupdateENG').val().trim() === 'Hold' && $('#holdnotes').val().trim() === '') {
//        alert("in Hold reason")
        //('fill holdnotes');
        callToolTip231('holdnotes', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   
   //("validation error count::::"+indexError);
 if (indexError != 0) {

//    alert("false");
        return false;

    } else {

//        $('#spinner2').show();
//    alert("true");
        return true;
    }

}
//
//focus out
$('#statusupdateENG').on('focusout', function () {

    var usertype = $('#statusupdateENG').val();
    if (usertype.trim() === "") {
        callToolTip231('statusupdateENG', 'show');
    }
    else {
        callToolTip231('statusupdateENG', 'hide');
    }
});
//focus out
$('#enggcat').on('focusout', function () {

    var usertype = $('#enggcat').val();
    if (usertype.trim() == "") {
        callToolTip231('enggcat', 'show');
    }
    else {
        callToolTip231('enggcat', 'hide');
    }
});
//focus out
$('#enggassign').on('focusout', function () {

    var usertype = $('#enggassign').val();
    if (usertype.trim() == "") {
        callToolTip231('enggassign', 'show');
    }
    else {
        callToolTip231('enggassign', 'hide');
    }
});
//focus out
$('#holdnotes').on('focusout', function () {

    var usertype = $('#holdnotes').val();
    if (usertype.trim() == "") {
        callToolTip231('holdnotes', 'show');
    }
    else {
        callToolTip231('holdnotes', 'hide');
    }
});
//focus out

$('#statusupdateENG').on('focus', function () {
    callToolTip231('statusupdateENG', 'destroy');
});

$('#enggcat').on('focus', function () {
    callToolTip231('enggcat', 'destroy');
});
$('#enggassign').on('focus', function () {
    callToolTip231('enggassign', 'destroy');
});
$('#holdnotes').on('focus', function () {
    callToolTip231('holdnotes', 'destroy');
});

function closeTicket(id)
{
    swal({
        title: "Confirm!",
        text: "Are you sure you want to close the ticket",
        type: "warning",
        width: 300,
        height: 200,
        showCancelButton: true,
        confirmButtonClass: "btn btn-danger",
        cancelButtonClass: "btn btn-danger m-l-10",
        confirmButtonText: "OK",
        cancelButtonText: "Cancel",
        allowOutsideClick: false,
    }).then((isConfirm) => {
        if (isConfirm) {
//            alert("in confirm");
          $("#modelclose").modal("show");
        }
    });
$('#hiddenID').val(id);
}
$('#ticketclose-btn').on("click", function () {
    if(!validateFormCloseTicket())
    {
        event.preventDefault();
    }
    else if (validateFormCloseTicket())
    {
    var idd= $("#hiddenID").val();
//    alert("submit: "+idd);
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/TPActivity/closeTPResolvedTicket";
    $.ajax({
                url: serviceUrl,
                type: 'post',
                data: 'ticketid=' + encodeURIComponent(idd)
                + '&closereason=' + encodeURIComponent($("#closereason").val()),
                //+ '&athorrrr=' + $("#athorrrr").val(),
                success: function (data) {
//                    alert(data);
                    if (data === "success") {
                        swal({
                            title: "Successful",
                            text: "Ticket Closed Successfully",
                            type: "success",
                            width: 300,
                            height: 200,
//                   		 showCancelButton: false,
//                          confirmButtonClass: "btn btn-danger",
//                          cancelButtonClass: "btn btn-danger m-l-10",
//                          confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                            preConfirm: function () {
                                location.reload();
                            }
                        });
                    }else if (data === "duplicate") {
                swal({
                    title: "Not Allowed",
                    text: "Cant close if ticket is not Resolved",
                    type: "error",
                    width: 300,
                    height: 200,
//                    showCancelButton: !0,
                    confirmButtonClass: "btn btn-danger",
//                    cancelButtonClass: "btn btn-danger m-l-10",
                    confirmButtonText: "OK",
                    preConfirm: function() {
                        location.reload();
                    }

                })

            }
                }
            });
    }
});
function validateFormCloseTicket()
{
 
      var indexError = 0;
   
   if ($('#closereason').val() === '') {
        //('fill closereason');
        callToolTipCloseTicket('closereason', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
 
    }
   
   //("validation error count::::"+indexError);
 if (indexError != 0) {

//    alert("false");
        return false;

    } else {

//        $('#spinner2').show();
//    alert("true");
        return true;
    }

}
var callToolTipCloseTicket = function (fieldName, status) {
    if (fieldName === "closereason") {
        var errorMessage = "<span>Please Enter Your Reason<span>";
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

$('#closereason').on('focusout', function () {

    var usertype = $('#closereason').val();
    if (usertype.trim() == "") {
        callToolTipCloseTicket('closereason', 'show');
    }
    else {
        callToolTipCloseTicket('closereason', 'hide');
    }
});
//focus out

$('#closereason').on('focus', function () {
    callToolTipCloseTicket('closereason', 'destroy');
});

function ToggleHoldReason(value){
//    alert(value)
if(value==="Hold"){
    $('#TPHoldNotes').show();
}else if(value==="Assigned" || value===""){
    $('#TPHoldNotes').hide();
    $('#holdnotes').val("");
}
}