
window.onload=function(){
    
//  $('#requestmode').focus();
  
  $('#sub').select2({
//    theme: 'bootstrap4'
//  	tags: true,
  	placeholder: "Select a Subject or Enter New",
  	 maximumSelectionSize: 1,
      allowClear: true
  })
  
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getAllUserDetails";
   
    $.ajax({

        type : 'POST',
        url :serviceUrl,
        dataType: 'json'
    }).done(function(data) {
//       alert(data[0]["FULLNAME"])

       $('#name1').val(data[0]["FULLNAME"]);
       $('#emailid').val(data[0]["EMAIL"]);
       $('#phone').val(data[0]["PHONE"]);
       $('#compname').val(data[0]["COMPANY"]);
       $('#site').val(data[0]["BRANCH"]);
       $('#department').val(data[0]["DEPARTMENT"]);
       $('#sub_department').val(data[0]["SUB_DEPARTMENT"]);
       $('#location').val(data[0]["LOCATION"]);
       $('#username').val(data[0]["USERNAME"]);
       $('#vipuser').val(data[0]["VIP_LOGIN"]);
    });   
    
  ////////////// DATA FOR SUBJECT ///////
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getServiceCatalogueSubject";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
//      data: 'subcat2name=' + subcat2
//      + '&Category=' + $("#category").val()
//      + '&subcat1name=' + $("#subcat1").val()
//       + '&company=' + $("#compname").val(),
      success: function(data2) {
//          alert(data2)
      	var html = "  <option value=''> -- Please Select --</option>";
          for (var i = 0; i < data2.length; i++) {
              html += '<option value="' + data2[i] + '">' + data2[i]
                      + '</option>';
          }
          document.getElementById("sub").innerHTML = html;
   }
}); 
    
//    var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getRequestModeName";
//
//    $.ajax({
//
//        url :serviceUrl,
//        type : 'POST',
//        dataType: 'json',
//    }).done(function(data) {
//
//        var html =" <select class='form-control' tabindex='8' id='requestmode' name='requestmode'>";
//        html=html+'<option value="">--Please Select Request Mode--</option>';
//        for (var i = 0; i < data.length; i++) {
//            html += '<option value="' +data[i]+ '">' + data[i]
//            + '</option>';
//        }
//
//        document.getElementById("requestmode").innerHTML=html;
//    });
    
//    var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////	var serviceUrl = base_url + "/Master/getPriorityName";
//
//    $.ajax({
//
//        url :serviceUrl,
//        type : 'POST',
//        dataType: 'json', 
//    }).done(function(data) {
//
//        var html =" <select class='form-control' tabindex='13' id='priority' name='priority' '>";
//        html=html+'<option value="">--Please Select Priority--</option>';
//        for (var i = 0; i < data.length; i++) {
//            html += '<option value="' +data[i]+ '">' + data[i]
//            + '</option>';
//        }
//
////        document.getElementById("priority").innerHTML=html;
//    });
    
//    var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////	var serviceUrl = base_url + "/Master/getSeverityName";
//
//    $.ajax({
//
//        url :serviceUrl,
//        type : 'POST',
//        dataType: 'json', 
//    }).done(function(data) {
//
//        var html =" <select class='form-control' tabindex='14' id='severity' name='severity' '>";
//        html=html+'<option value="">--Please Select Severity--</option>';
//        for (var i = 0; i < data.length; i++) {
//            html += '<option value="' +data[i]+ '">' + data[i]
//            + '</option>';
//        }
//
////        document.getElementById("severity").innerHTML=html;
//    });
};

///////////// ONLOAD ENDS ////////////

function getalldata(subject)
{
//	alert(subject)
	var sub = $("#subject").val().length;
		if(sub > 0){
			
			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getSelectedServiceCatalogueData";

		    $.ajax({

		        url: serviceUrl,
		        type: 'POST',
		        data: 'subject=' + encodeURIComponent(subject)
		        + '&company=' + encodeURIComponent($("#compname").val()),
		        dataType: 'json',
		    }).done(function (data) {
		    	var CATEGORY=data[0]["CATEGORY"];
		    	var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
		    	var SUB_CATEGORY2=data[0]["SUB_CATEGORY2"];
		    	var PRIORITY=data[0]["PRIORITY"];
		    	var SEVERITY=data[0]["SEVERITY"];
		    //	var GROUP_NAME=data[0]["GROUP_NAME"];
	
		    });
			}else{
				$("#category").val('');
	    		$("#subcat1").val('');
	    		$("#subcat2").val('');
	    		$("#priority").val('');
	    		$("#severity").val('');
			}
	
}


	/*var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSelectedServiceCatalogueData";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        data: 'subject=' + encodeURIComponent(subject)
        + '&company=' + encodeURIComponent($("#compname").val()),
        dataType: 'json',
    }).done(function (data) {
    	var CATEGORY=data[0]["CATEGORY"];
    	var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
    	var SUB_CATEGORY2=data[0]["SUB_CATEGORY2"];
    	var PRIORITY=data[0]["PRIORITY"];
    	var SEVERITY=data[0]["SEVERITY"];
    //	var GROUP_NAME=data[0]["GROUP_NAME"];

	    	$("#category").val(CATEGORY);
	    	$("#subcat1").val(SUB_CATEGORY1);
	    	$("#subcat2").val(SUB_CATEGORY2);
	    	$("#priority").val(PRIORITY);
	    	$("#severity").val(SEVERITY);
    	
    });
}*/





//function change_subcat2(subcat1)
//{
////	alert("category: "+$('#category').val());
////	alert("subcat1: "+subcat1)
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getINCSubCategory2Name";
//
//    $.ajax({
//
//        url: serviceUrl,
//        type: 'POST',
//        data: 'subcat1name=' + subcat1
//        + '&Category=' + $("#category").val(),
//        dataType: 'json',
//    }).done(function (data) {
////    	alert(data)
//        var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2' onchange='JavaScript:change_PriorityAndSeverity(this.value)'>";
//        html = html + '<option value="">--Please Select Sub-Category2--</option>';
//        for (var i = 0; i < data.length; i++) {
//            html += '<option value="' + data[i] + '">' + data[i]
//                    + '</option>';
//        }
//
//        document.getElementById("subcat2").innerHTML = html;
//    });
//}
//
//function change_PriorityAndSeverity(subcat2)
//{
////	alert("category: "+$('#category').val());
////	alert("subcat1: "+$('#subcat1').val());
////	alert("subcat2: "+subcat2);
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getINCPriorityAndSeverityName";
//
//    $.ajax({
//
//        url: serviceUrl,
//        type: 'POST',
//        data: 'subcat2name=' + subcat2
//        + '&Category=' + $("#category").val()
//        + '&subcat1name=' + $("#subcat1").val(),
//        dataType: 'json',
//    }).done(function (data) {
//    	
//    	var PRIORITY = data[0]["PRIORITY"];
//    	var SEVERITY = data[0]["SEVERITY"];
////    	alert(PRIORITY)
////    	alert(SEVERITY)
////        var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2'>";
////        html = html + '<option value="">--Please Select Sub-Category2--</option>';
////        for (var i = 0; i < data.length; i++) {
////            html += '<option value="' + data[i] + '">' + data[i]
////                    + '</option>';
////        }
//
//    	$("#priority").val(PRIORITY);
//    	$("#severity").val(SEVERITY);
////        document.getElementById("priority").innerHTML = html;
//    });
//    
//    ////////////// DATA FOR SUBJECT ///////
//    var l = window.location;
// 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/Master/getINCSubject";
//
//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        dataType: 'json',
//        data: 'subcat2name=' + subcat2
//        + '&Category=' + $("#category").val()
//        + '&subcat1name=' + $("#subcat1").val()
//         + '&company=' + $("#compname").val(),
//        success: function(data2) {
////            alert(data2)
//        	var html = "  <option value=''> -- Please Select --</option>";
//            for (var i = 0; i < data2.length; i++) {
//                html += '<option value="' + data2[i] + '">' + data2[i]
//                        + '</option>';
//            }
//            document.getElementById("sub").innerHTML = html;
//     }
//}); 
//}

function submitRaise(){
//    alert($("#priority").val());
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/insertServiceCatalogueRequest";
	
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
           success: function (data) {  
            //   alert(data);
               var nameArr = data.split(',');
             //  alert(nameArr[0]);
            //   alert(nameArr[1]);
               if (nameArr[0] === "success") {
                swal({
                    title: "Successful!",
                    html: "Ticket ID = " + nameArr[1] + "<br>   Raised Ticket Successfully",
                   // text: "Ticket Raised Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
//                  showCancelButton: false,
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
       })  ; 
}
var callToolTip231 = function (fieldName, status) {
    if (fieldName === "category") {
        var errorMessage = "<span>Please Select Category<span>";
    }
    else if (fieldName === "subcat1") {      
        var errorMessage = "<span>Please Select Sub-Category1<span>";
    }
    else if (fieldName === "subcat2") {      
        var errorMessage = "<span>Please Select Sub-Category2<span>";
    }
    else if (fieldName === "requestmode") {
        var errorMessage = "<span>Please Select Request Mode<span>";
    }
    else if (fieldName === "sub") {
        var errorMessage = "<span>Please Enter Subject<span>";
    }
    else if (fieldName === "description") {
        var errorMessage = "<span>Please Enter Description<span>";
    }
    else if (fieldName === "priority") {
        var errorMessage = "<span>Please Select Priority<span>";
    }
     else if (fieldName === "empPic") {
        var errorMessage = "<span>File size should be > 1KB<span>";
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

 var indexError12 = 0;
$('#empPic').on('change',function(){
 indexError12 =12;
    })
   
function validateForm()
{
 
      var indexError = 0; 
   
 
    if ($('#sub').val().trim() === '') {
        console.log('fill sub');
        callToolTip231('sub', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#description').val().trim() === '') {
        console.log('fill description');
        callToolTip231('description', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   
   
   if(indexError12 != 0)
   {
      const size= ($('#empPic')[0].files[0].size);
     console.log(size);
    if(size<1)
    {
        callToolTip231('empPic', 'show');
         indexError = indexError + 1;
    } 
    else
    {
        callToolTip231('empPic', 'hide');
    }
   }
 
    
   console.log("validation error count::::"+indexError);
 if (indexError != 0) {

//    alert("false");
        return false;

    } else {


        return true;
    }

}
//
//focus out
$('#category').on('focusout', function () {

    var usertype = $('#category').val();
    if (usertype.trim() === "") {
        callToolTip231('category', 'show');
    }
    else {
        callToolTip231('category', 'hide');
    }
});
//focus out
$('#subcat1').on('focusout', function () {

    var usertype = $('#subcat1').val();
    if (usertype.trim() == "") {
        callToolTip231('subcat1', 'show');
    }
    else {
        callToolTip231('subcat1', 'hide');
    }
});
//focus out
$('#subcat2').on('focusout', function () {

    var usertype = $('#subcat2').val();
    if (usertype.trim() == "") {
        callToolTip231('subcat2', 'show');
    }
    else {
        callToolTip231('subcat2', 'hide');
    }
});
//focus out
$('#requestmode').on('focusout', function () {

    var usertype = $('#requestmode').val();
    if (usertype.trim() == "") {
        callToolTip231('requestmode', 'show');
    }
    else {
        callToolTip231('requestmode', 'hide');
    }
});
//focus out
$('#sub').on('focusout', function () {

    var usertype = $('#sub').val();
    if (usertype.trim() == "") {
        callToolTip231('sub', 'show');
    }
    else {
        callToolTip231('sub', 'hide');
    }
});
//focus out
$('#description').on('focusout', function () {

    var usertype = $('#description').val();
    if (usertype.trim() == "") {
        callToolTip231('description', 'show');
    }
    else {
        callToolTip231('description', 'hide');
    }
});
//focus out
$('#priority').on('focusout', function () {

    var usertype = $('#priority').val();
    if (usertype.trim() == "") {
        callToolTip231('priority', 'show');
    }
    else {
        callToolTip231('priority', 'hide');
    }
});


$('#category').on('focus', function () {
    callToolTip231('category', 'destroy');
});

$('#empPic').on('focus', function () {
    callToolTip231('empPic', 'destroy');
});

$('#subcat1').on('focus', function () {
    callToolTip231('subcat1', 'destroy');
});
$('#subcat2').on('focus', function () {
    callToolTip231('subcat2', 'destroy');
});
$('#requestmode').on('focus', function () {
    callToolTip231('requestmode', 'destroy');
});
$('#sub').on('focus', function () {
    callToolTip231('sub', 'destroy');
});
$('#description').on('focus', function () {
    callToolTip231('description', 'destroy');
});
$('#priority').on('focus', function () {
    callToolTip231('priority', 'destroy');
});

$("#resetbtn").click(function() {
    $("#category").val("");
    $("#subcat1").val("");
    $("#subcat2").val("");
    $("#requestmode").val("");
    $("#sub").val("");
    $("#description").val("");
    $("#priority").val("");
    $("#severity").val("");
    $("#requesttype").val("");
    $("#groupname").val("");
    $("#subtype").val("");
    $("#empPic").val("");
    
    callToolTip231('category', 'hide');
    callToolTip231('subcat1', 'hide');
    callToolTip231('subcat2', 'hide');
    callToolTip231('requestmode', 'hide');
    callToolTip231('sub', 'hide');
    callToolTip231('description', 'hide');
    callToolTip231('priority', 'hide');
    callToolTip231('severity', 'hide');
    callToolTip231('requesttype', 'hide');
    callToolTip231('subtype', 'hide');
    callToolTip231('empPic', 'hide');
   
});

function submitbutton101()
{
//    alert("in submit button");

    if(!validateForm())
    {
//        alert("failed");
        event.preventDefault();
    }
    else if(validateForm())
    {
//        alert("Passed");
       submitRaise(); 
       $("#raise-btn").attr("disabled", true);
    }
}

//function  characterCounter()
//{
////	alert("sdffsffd")
//		
//	$("#counterSpan").show();
//	
//	  var i = document.getElementById("description").value.length;
//	  document.getElementById("calulateId").innerHTML = 2000 - i; 
//	  if(i<=0)
//	  {
//    	  $("#calulateId").val("");
//	  };
//}
function  characterCounter()
{
	alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("description").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}