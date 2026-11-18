var companyforsubject="";
window.onload=function(){
    
//  $('#requestmode').focus();
	  $('#assetid').select2({
//	    theme: 'bootstrap4'
		   width:'80%',
	  	tags: true,
	  	placeholder: "Select Asset Name",
	  	
//	      allowClear: true
	  })
  $('#sub').select2({
//    theme: 'bootstrap4'
//  	tags: true,
  	placeholder: "Select a Subject or Enter New",
  	 maximumSelectionSize: 1,
      allowClear: true
  })
  
     $('#usernamesofbehalf').select2({
    //theme: 'bootstrap4',
  //	tags: true,
  	placeholder: "Please Select User",
  	maximumSelectionSize: 1,
    allowClear: true
  })
  
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getAllUserDetails";
   
    $.ajax({

        type : 'POST',
        url :serviceUrl,
        async:false,
        dataType: 'json'
      
    }).done(function(data) {
//       alert(data[0]["FULLNAME"])

       $('#name1').val(data[0]["FULLNAME"]);
       $('#emailid').val(data[0]["EMAIL"]);
       $('#phone').val(data[0]["PHONE"]);
       $('#compname').val(data[0]["COMPANY"]);
       companyforsubject=data[0]["COMPANY"];
       $('#site').val(data[0]["BRANCH"]);
       $('#department').val(data[0]["DEPARTMENT"]);
       $('#sub_department').val(data[0]["SUB_DEPARTMENT"]);
       $('#location').val(data[0]["LOCATION"]);
       $('#username').val(data[0]["USERNAME"]);
       $('#vipuser').val(data[0]["VIP_LOGIN"]);
    });   
    
    
    
    

    //GEt USERNAMES OFn FOR RAISE TIVKET ON BEHlAF
    
   // alert($('#compname').val());
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getallusernameforraiseonbehalf";
   
    $.ajax({

        type : 'POST',
        url :serviceUrl,
        dataType: 'json',
       
        data:'company=' + encodeURIComponent($('#compname').val()),
    }).done(function(data) {
//       alert(data[0]["FULLNAME"])
    	 html = "  <option value=''> -- Please Select --</option>";
    	//localStorage.setItem("company",  data[0]['COMPANY']);
    	for(var i=0; i<data.length; i++){
    		
    		
    		html += '<option value="' +data[i]+ '">' + data[i]
    	          + '</option>';
    	
    		//alert(data[0]);
    	}
    	document.getElementById("usernamesofbehalf").innerHTML=html;
    	
   
    }); 
    
//////getLocationonbehafe
    var company = $('#compname').val();
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getLocationForLoginMaster";
     $.ajax({
     type: 'POST',
     url: serviceUrl,
     dataType: 'json',
     data: 'companyname=' + encodeURIComponent(company),
     success: function(data4) {

                var html = " <option value=''> -- Please Select --</option>";
                for (var i = 0; i < data4.length; i++) {
                 //  alert(data4[i]);
                    html += '<option value="' + data4[i] + '">' + data4[i]
                            + '</option>';
                }
                document.getElementById("locationbehalfuser").innerHTML = html;
         }

  });
  $('#locationbehalfuser').select2({
  // theme: 'bootstrap4'
  	   width:'80%',
  	tags: true,
  	placeholder: "Select Location",
  	
  //   allowClear: true
  });
    


    
    
    
  ////////////// DATA FOR SUBJECT ///////
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getServiceCatalogueSubject";
//alert("VALUE "+$('#compname').val);
//alert("COMAPNY NAME "+ companyforsubject);
  $.ajax({
      type: 'POST',	
      url: serviceUrl,
      dataType: 'json',
    
     data: 'subcat2name=' + encodeURIComponent(subcat2)
//      + '&Category=' + $("#category").val()
//      + '&subcat1name=' + $("#subcat1").val()
       + '&company=' +encodeURIComponent(companyforsubject),
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




function getallinformationofAsset(asset){
	 document.getElementById("HideAssetdata").style.display = "none";
//		alert("ggggg")
		if(asset.length>0){
//			alert("inside");
//			$('#assetCheck').attr('checked',false); 
		
//		alert(asset);
	
		 var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/UserActivity/GetAssetinformaion";
		
		  $.ajax({
		      type: 'POST',	
		      url: serviceUrl,
		      dataType: 'json',
		     data: 'asset=' + encodeURIComponent(asset),
		     
		      success: function(data) {  	
//		      alert(JSON.stringify(data))
		    	 // alert(data[0]["OTHEREMAIL"])
		    	var ASSET_NAME=data[0]["ASSET_NAME"];
		    	var ASSET_TAG=data[0]["ASSET_TAG"];
		    	var CATEGORY=data[0]["CATEGORY"];
		    	var ASSET_STATUS=data[0]["ASSET_STATUS"];
				var ASSET_IPADDRESS=data[0]["ASSET_IPADDRESS"];
	               var ASSET_SUBCATEGORY=data[0]["ASSET_SUBCATEGORY"];
			    	
			       	$("#asset_sub_category").val(ASSET_SUBCATEGORY);
			    	$("#asset_Ipaddress").val(ASSET_IPADDRESS);
		    	$("#aname").val(ASSET_NAME);
		    	$("#atag").val(ASSET_TAG);
		    	$("#acategory").val(CATEGORY);
		    	$("#astatus").val(ASSET_STATUS);
		    	
		    
		      }
		}); 
		    document.getElementById("HideAssetdata").style.display = "block";

		
		}
}

function getUsers(location) {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getallUserByLocationBased";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'company=' + encodeURIComponent($("#compname").val())
				 + '&location=' + encodeURIComponent(location),
	}).done(function(data) {
		data.sort()
		html = " <option value=''> -- Please Select --</option>";
		for ( var i = 0; i < data.length; i++) {

			html += '<option value="' + data[i] + '">' + data[i] + '</option>';

		}

		document.getElementById("usernamesofbehalf").innerHTML = html;

	});   
	
}

$('#assetCheck').change(function () {
    if (this.checked)
        {
//    	alert($("#otherusername").val())
    	
    	var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getAssetFromOfLoginUser";

    	$.ajax({

    	  url: serviceUrl,
    	  type: 'POST',
    	  dataType: 'json',
    	  data:'loginuser='+$("#otherusername").val(),
    	}).done(function (data) {

    	// alert(data)
    	  var html = html + '<option value="">--Please Select Sub-Category1--</option>';
    	  for (var i = 0; i < data.length; i++) {
    	      html += '<option value="' + data[i] + '">' + data[i]
    	              + '</option>';
    	  }

    	  document.getElementById("assetid").innerHTML = html;
    	});

    	
    	
    	 document.getElementById("toggleAssetCheck").style.display = "block";
    	 
    	 
    
        }
    else
    	{
    	 document.getElementById("toggleAssetCheck").style.display = "none";
    	 document.getElementById("HideAssetdata").style.display = "none";
    	 callToolTip231('AssetDiv', 'hide');
//    	 $("#assetid").val();
    	 $("#assetid").select2('val', 'All');
    	}
});

///////////// ONLOAD ENDS ////////////

function getalldata(subject)
{
	
	$('#designationlevel1div').css('display','none');
	$('#username1div').css('display','none');
	//$('#groupnamediv').css('display','none');
//	alert(subject)
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
    	var REQUESTTYPE=data[0]["REQUESTTYPE"];
    	var DESIGNATION1=data[0]["DESIGNATION1"];
    	var GROUP_NAME=data[0]["GROUP_NAME"];
    	var APPROVE_LEVEL=data[0]["APPROVE_LEVEL"];
	  var REQUEST_COST=data[0]["REQUEST_COST"];
	var  DESIGNATION2 =data[0]["DESIGNATION2"];
    	
    	$("#category").val(CATEGORY);
    	$("#subcat1").val(SUB_CATEGORY1);
    	$("#subcat2").val(SUB_CATEGORY2);
    	$("#priority").val(PRIORITY);
    	$("#severity").val(SEVERITY);
     	$("#requesttype").val(REQUESTTYPE);
    	$("#designationlevel1").val(DESIGNATION1);
    	$("#groupname").val(GROUP_NAME);
    	$("#approve_level").val(APPROVE_LEVEL);
    	$("#requestcost").val(REQUEST_COST);
    	$("#designationlevel2").val(DESIGNATION2);
    	
    	 var l = window.location;
    		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    		var serviceUrl = base_url + "/Master/getusernamebasisondesignation";
    	//alert("VALUE "+$('#compname').val);
    	//alert("COMAPNY NAME "+ companyforsubject);
    	  $.ajax({
    	      type: 'POST',	
    	      url: serviceUrl,
    	      dataType: 'json',
    	     data: 'designation1=' + encodeURIComponent(DESIGNATION1)
    	     + '&company=' + encodeURIComponent($("#compname").val()),
    	     
    	      success: function(data2) {

    	      	var html = "  <option value=''> -- Please Select --</option>";
    	          for (var i = 0; i < data2.length; i++) {
    	              html += '<option value="' + data2[i] + '">' + data2[i]
    	                      + '</option>';
    	          }
    	          document.getElementById("username1").innerHTML = html;
    	   }
    	}); 
    	
    	
    	if(REQUESTTYPE =="Non Standard"){
    	//	alert("IN IF BLOCK");
    		
    		$('#designationlevel1div').css('display','block');
    		$('#username1div').css('display','block');
    	//	$('#groupnamediv').css('display','block');
    	}
    	else{
    	    callToolTip231('username1', 'destroy');
    	}
    
    });
    
}
//if(REQUESTTYPE=="Standard")
//	{
//	var callToolTip232 = function (fieldName, status) {
//	
//	     if (fieldName === "username1") {
//	         var errorMessage = "<span>Please Select User <span>";
//	     }
//	    
//
//	    $("#" + fieldName).tooltip({
//	        trigger: 'manual',
//	        placement: 'top',
//	        title: errorMessage,
//	        animation: true,
//	        delay: 1000,
//	        html: true
//	    });
//	    if (status == "show") {
//	        $("#" + fieldName).tooltip('show');
//	    } else {
//	        $("#" + fieldName).tooltip('hide');
//	    }
//	}
//	
//	}
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
	var serviceUrl = base_url + "/UserActivity/insertServiceRequestCatalogueRequestOnBehalf";
	
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
    else if (fieldName === "subjectDiv") {
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
     else if (fieldName === "username1") {
         var errorMessage = "<span>Please Select User <span>";
     }
     else if (fieldName === "behalfdiv") {
         var errorMessage = "<span>Please Select User<span>";
     }
     else if (fieldName === "AssetDiv") {
         var errorMessage = "<span>Please Select Asset<span>";
     }
     else if (fieldName === "getlocationDiv") {
         var errorMessage = "<span>Please Select Location<span>";
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
	//getalldata()
var valueoftype=	$("#requesttype").val();
	
//	alert(valueoftype+"   valueoftype");
      var indexError = 0; 
      if(valueoftype=="Non Standard"){
    //	  alert("in if Non Standard")
      if ($('#username1').val().trim() === '') {
       
          callToolTip231('username1', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
      }
      else
    	  {
    	//  alert("Inhide")
    	  callToolTip231('username1', 'hide');
    	  }
 
    if ($('#sub').val()==''||$('#sub').val()==null) {
    //    console.log('fill sub');
        callToolTip231('subjectDiv', 'show');

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
    
    if (($('#assetCheck').is(':checked'))&&($('#assetid').val() === null||$('#assetid').val()=="")) {
  	      
  	        callToolTip231('AssetDiv', 'show');

  	        if (indexError == 0) {

  	        }
  	        indexError = indexError + 1;
  	} 
    if ($('#locationbehalfuser').val() == null ||  $('#locationbehalfuser').val() == '') {
        console.log('fill sub');
        callToolTip231('getlocationDiv', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#usernamesofbehalf').val() == null ||  $('#usernamesofbehalf').val() == '') {
        console.log('fill sub');
        callToolTip231('behalfdiv', 'show');

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
$('#username1').on('focusout', function () {

    var usertype = $('#username1').val();
    if (usertype.trim() === "") {
        callToolTip231('username1', 'show');
    }
    else {
        callToolTip231('username1', 'hide');
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


$('#behalfdiv').on('focusout', function () {

    var usertype = $('#behalfdiv').val();
    if (usertype == null) {
        callToolTip231('behalfdiv', 'show');
    }
    else {
        callToolTip231('behalfdiv', 'hide');
    }
});

//focus out
//$('#sub').on('focusout', function () {
//
//    var usertype = $('#sub').val();
//    if (usertype.trim() == "") {
//        callToolTip231('subjectDiv', 'show');
//    }
//    else {
//        callToolTip231('subjectDiv', 'hide');
//    }
//});
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
$('#AssetDiv').on('click', function () {
//	alert("hii")
    callToolTip231('AssetDiv', 'destroy');
});
$('#sub').on('focus', function () {
    callToolTip231('subjectDiv', 'hide');
});
$('#description').on('focus', function () {
    callToolTip231('description', 'destroy');
});
$('#priority').on('focus', function () {
    callToolTip231('priority', 'destroy');
});
$('#username1').on('focus', function () {
    callToolTip231('username1', 'destroy');
});

$('#behalfdiv').on('click', function () {
    callToolTip231('behalfdiv', 'destroy');
});

$('#getlocationDiv').on('click', function () {
    callToolTip231('getlocationDiv', 'destroy');
});



$("#resetbtn").click(function() {
	
	document.getElementById("Hideotherdataforbehalf").style.display = "none";
	
	 $("#usernamesofbehalf").select2('val', 'All');
  
	
	  document.getElementById("Hideotherdata").style.display = "none";
    $("#category").val("");
    $("#subcat1").val("");
    $("#subcat2").val("");
    $("#requestmode").val("");
    $("#sub").val("").trigger("change");
    $("#description").val("");
    $("#priority").val("");
    $("#empPic").val("");
    $("#othercompname").val("");
    $("#othersite").val("");
    $("#otherdepart").val("");
    $("#otherfullname").val("");
    $("#otheremail").val("");
    $("#severity").val("");
    $("#requesttype").val("");
    $("#groupname").val("");
    $("#locationbehalfuser").val("");
    $("#assetid").select2('val', 'All');
    callToolTip231('AssetDiv', 'hide');
    callToolTip231('category', 'hide');
    callToolTip231('subcat1', 'hide');
    callToolTip231('subcat2', 'hide');
    callToolTip231('requestmode', 'hide');
    callToolTip231('subjectDiv', 'hide');
    callToolTip231('description', 'hide');
    callToolTip231('priority', 'hide');
    callToolTip231('empPic', 'hide');
    callToolTip231('username1', 'hide');
    callToolTip231('getlocationDiv', 'hide');
    callToolTip231('behalfdiv', 'hide');
   
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
//     
    	
    	 if($('#othersiteforbehalf').val()==='NA' || $('#otherdepartforbehalf').val()==='NA' || $('#othersubdepartforbehalf').val()==='NA' || $('#otherlocationforbehalf').val()==='NA')
    	 {
    	//	 alert("in if")
        		swal({
                    title: "Error!",
                    html: "The Profile of the person you are raising the ticket is  incomplete. Kindly contact the Administrator to complete that profile.",
                    type: "error",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    
                    
                })
        		
        	}
    	 else{
    		 
    		 submitRaise(); 
    		 $("#raise-btn").attr('disabled',true);
    	 }	
    
    }
}




function getothersdata(othername){
	 document.getElementById("Hideotherdata").style.display = "none";
	
	if(othername.length>0){
		//alert("inside");
	 
	
	//alert(othername);
	//getting split for company and username
	
	const words = othername.split('~');
	//console.log(words[0]);
	var otherusername=words[0];
	
//	alert(othercompany + "company");
	//alert(otherusername + "otherusername ias");
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/UserActivity/Getotherinformaion";
	
	  $.ajax({
	      type: 'POST',	
	      url: serviceUrl,
	      dataType: 'json',
	     data: 'othername=' + encodeURIComponent(otherusername)
	     + '&othercompany=' + encodeURIComponent($("#compname").val()),
	     
	      success: function(data) {  	
	      
	    	 // alert(data[0]["OTHEREMAIL"])
	    	var OTHEREMAIL=data[0]["OTHEREMAIL"];
	    	var OTHERFULLNAME=data[0]["OTHERFULLNAME"];
	    	var OTHERCOMPANY=data[0]["OTHERCOMPANY"];
	    	var OTHERBRANCH=data[0]["OTHERBRANCH"];
	    	var OTHERDEPARTMENT=data[0]["OTHERDEPARTMENT"];
	    	
	    	
	    	$("#otheremail").val(OTHEREMAIL);
	    	$("#otherfullname").val(OTHERFULLNAME);
	    	$("#othersite").val(OTHERBRANCH);
	    	$("#othercompname").val(OTHERCOMPANY);
	    	$("#otherdepart").val(OTHERDEPARTMENT);
	     
	    	
	      }
	}); 
	    document.getElementById("Hideotherdata").style.display = "block";

	
	}
}








function getallinformationofbehalfuser(othername ){
	 document.getElementById("Hideotherdataforbehalf").style.display = "none";
		
		if(othername.length>0){
			//alert("inside");
		 
		
		//alert(othername);
		//getting split for company and username
		
		const words = othername.split('~');
		//console.log(words[0]);
		var otherusername=words[0];
		
//		alert(othercompany + "company");
		//alert(otherusername + "otherusername ias");
		 var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/UserActivity/Getotherinformaion";
		
		  $.ajax({
		      type: 'POST',	
		      url: serviceUrl,
		      dataType: 'json',
		     data: 'othername=' + encodeURIComponent(otherusername)
		     + '&othercompany=' + encodeURIComponent($("#compname").val()),
		     
		      success: function(data) {  	
		      
		    	 // alert(data[0]["OTHEREMAIL"])
		    	var OTHEREMAIL=data[0]["OTHEREMAIL"];
		    	var OTHERFULLNAME=data[0]["OTHERFULLNAME"];
		    	var OTHERCOMPANY=data[0]["OTHERCOMPANY"];
		    	var OTHERBRANCH=data[0]["OTHERBRANCH"];
		    	var OTHERDEPARTMENT=data[0]["OTHERDEPARTMENT"];
		    	
		    	var OTHERLOCATION=data[0]["OTHERLOCATION"];
		    	var OTHERPHONE=data[0]["OTHERPHONE"];
		    	var OTHERSUBDEPARTMENT=data[0]["OTHERSUBDEPARTMENT"];
		    	var OTHERUSERNAME=data[0]["OTHERUSERNAME"];
		    	var VIPUSEROTHER=data[0]["VIPUSEROTHER"];
		    	
		    	

		    	
		    	$("#otheremailforbehalf").val(OTHEREMAIL);
		    	$("#otherfullnameforbehalf").val(OTHERFULLNAME);
		    	$("#othersiteforbehalf").val(OTHERBRANCH);
		    	$("#othercompnameforbehalf").val(OTHERCOMPANY);
		    	$("#otherdepartforbehalf").val(OTHERDEPARTMENT);
		    	
		       	$("#otherphoneforbehalf").val(OTHERPHONE);
		    	$("#otherlocationforbehalf").val(OTHERLOCATION);
		    	$("#othersubdepartforbehalf").val(OTHERSUBDEPARTMENT);
		    	$("#otherusernameforbehalf").val(OTHERUSERNAME);
		    	$("#vipuserotherforbehalf").val(VIPUSEROTHER);
		    	
		      }
		}); 
		    document.getElementById("Hideotherdataforbehalf").style.display = "block";

		
		}
}


function  characterCounter()
{
//	alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("description").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}
