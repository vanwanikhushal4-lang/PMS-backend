
window.onload=function(){
//	$('#l_button').hide();
// 	$('#spin').hide();
// 	
 	
    
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
  	tags: true,
  	placeholder: "Select a Subject or Enter New",
//      allowClear: true
  })
  
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getAllUserDetails";
   
    $.ajax({

        type : 'POST',
        url :serviceUrl,
        dataType: 'json',
        	async:false,
    }).done(function(data) {
//       //alert(data[0]["FULLNAME"])

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
    
    
//  var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getCategoryDetails";
//
//  $.ajax({
//
//      url :serviceUrl,
//      type : 'POST',
//      dataType: 'json',
//  }).done(function(data) {
//
//      var html =" <select class='form-control' tabindex='7' id='category' name='category' onchange='JavaScript:change_subcat1(this.value)'>";
//      html=html+'<option value="">--Please Select Category--</option>';
//      for (var i = 0; i < data.length; i++) {
//          html += '<option value="' +data[i]+ '">' + data[i]
//          + '</option>';
//      }
//
//      document.getElementById("category").innerHTML=html;
//  });
//  
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getRequestModeName";

  $.ajax({
      url :serviceUrl,
      type : 'POST',
      dataType: 'json',
  }).done(function(data) {
      var html =" <select class='form-control' tabindex='8' id='requestmode' name='requestmode'>";
      html=html+'<option value="">--Please Select Request Mode--</option>';
      for (var i = 0; i < data.length; i++) {
          html += '<option value="' +data[i]+ '">' + data[i]
          + '</option>';
      }
      document.getElementById("requestmode").innerHTML=html;
  });
  
//  var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////	var serviceUrl = base_url + "/Master/getPriorityName";
//
//  $.ajax({
//
//      url :serviceUrl,
//      type : 'POST',
//      dataType: 'json', 
//  }).done(function(data) {
//
//      var html =" <select class='form-control' tabindex='13' id='priority' name='priority' '>";
//      html=html+'<option value="">--Please Select Priority--</option>';
//      for (var i = 0; i < data.length; i++) {
//          html += '<option value="' +data[i]+ '">' + data[i]
//          + '</option>';
//      }
//
////      document.getElementById("priority").innerHTML=html;
//  });
//  
//  var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////	var serviceUrl = base_url + "/Master/getSeverityName";
//
//  $.ajax({
//
//      url :serviceUrl,
//      type : 'POST',
//      dataType: 'json', 
//  }).done(function(data) {
//
//      var html =" <select class='form-control' tabindex='14' id='severity' name='severity' '>";
//      html=html+'<option value="">--Please Select Severity--</option>';
//      for (var i = 0; i < data.length; i++) {
//          html += '<option value="' +data[i]+ '">' + data[i]
//          + '</option>';
//      }
//
////      document.getElementById("severity").innerHTML=html;
//  });
  
  
  
//////////////DATA FOR SUBJECT ///////
  ////alert($('#compname').val()+ "hiiii");
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getINCSubjectFORuser";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      async :true,
      data: /*'subcat2name=' + encodeURIComponent(subcat2)
      + '&Category=' + encodeURIComponent($("#category").val())
      + '&subcat1name=' + encodeURIComponent($("#subcat1").val())*/
       'company=' + encodeURIComponent($('#compname').val()),
      success: function(data2) {
//          //alert(data2)
      	var html = "  <option value=''> -- Please Select --</option>";
          for (var i = 0; i < data2.length; i++) {
              html += '<option value="' + data2[i] + '">' + data2[i]
                      + '</option>';
          }
          document.getElementById("sub").innerHTML = html;
   }
}); 
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/Master/getAssetFromOfLoginUser";

  $.ajax({

    url: serviceUrl,
    type: 'POST',
    dataType: 'json',
  }).done(function (data) {

//   alert(data)
    var html = html + '<option value="">--Please Select Asset--</option>';
    for (var i = 0; i < data.length; i++) {
        html += '<option value="' + data[i] + '">' + data[i]
                + '</option>';
    }

    document.getElementById("assetid").innerHTML = html;
  });

};

function getallinformationofAsset(asset){
	 document.getElementById("HideAssetdata").style.display = "none";
		
		if(asset.length>0){
//			alert("inside");
		 
		
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
		       	$("#acategory").val(CATEGORY);
		    	$("#astatus").val(ASSET_STATUS);
		    	$("#aname").val(ASSET_NAME);
		    	$("#atag").val(ASSET_TAG);
		 
		  
		    	
		    
		      }
		}); 
		    document.getElementById("HideAssetdata").style.display = "block";

		
		}
}
//var asset=$("#assetid").val();
//Calert(asset)

var loginuser;
$('#assetCheck').change(function () {
    if (this.checked)
        {
//    	alert("AFsd")
    	
    	 document.getElementById("toggleAssetCheck").style.display = "block";
    	 var l = window.location;
    	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	  var serviceUrl = base_url + "/Master/getAssetFromOfLoginUser";
    	  $.ajax({
    	    url: serviceUrl,
    	    type: 'POST',
    	    dataType: 'json',
    	    data:'loginuser='+loginuser,
    	  }).done(function (data) {

    	//   alert(data)
    	    var html = html + '<option value="">--Please Select Asset--</option>';
    	    for (var i = 0; i < data.length; i++) {
    	        html += '<option value="' + data[i] + '">' + data[i]
    	                + '</option>';
    	    }

    	    document.getElementById("assetid").innerHTML = html;
    	  });
 
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
//
//function change_subcat1(Category)
//{
////	//alert(ProblemCategory)
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getINCSubCategory1Name";
//
//  $.ajax({
//
//      url: serviceUrl,
//      type: 'POST',
//      data: 'Category=' + encodeURIComponent(Category)
//      		+ "&companyname=" + encodeURIComponent($('#compname').val()),
//      dataType: 'json',
//  }).done(function (data) {
//
//      var html = " <select class='form-control' tabindex='7' id='subcat1' name='subcat1' onchange='JavaScript:change_subcat2(this.value)'>";
//      html = html + '<option value="">--Please Select Sub-Category1--</option>';
//      for (var i = 0; i < data.length; i++) {
//          html += '<option value="' + data[i] + '">' + data[i]
//                  + '</option>';
//      }
//
//      document.getElementById("subcat1").innerHTML = html;
//  });
//}
//
//function change_subcat2(subcat1)
//{
////	//alert("category: "+$('#category').val());
////	//alert("subcat1: "+subcat1)
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getINCSubCategory2Name";
//
//  $.ajax({
//
//      url: serviceUrl,
//      type: 'POST',
//      data: 'subcat1name=' + encodeURIComponent(subcat1)
//      + '&Category=' + encodeURIComponent($("#category").val())
//      + "&companyname=" + encodeURIComponent($('#compname').val()),
//      dataType: 'json',
//  }).done(function (data) {
////  	//alert(data)
//      var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2' onchange='JavaScript:change_PriorityAndSeverity(this.value)'>";
//      html = html + '<option value="">--Please Select Sub-Category2--</option>';
//      for (var i = 0; i < data.length; i++) {
//          html += '<option value="' + data[i] + '">' + data[i]
//                  + '</option>';
//      }
//
//      document.getElementById("subcat2").innerHTML = html;
//  });
//}
//
//function change_PriorityAndSeverity(subcat2)
//{
////	//alert("category: "+$('#category').val());
////	//alert("subcat1: "+$('#subcat1').val());
////	//alert("subcat2: "+subcat2);
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getINCPriorityAndSeverityName";
//
//  $.ajax({
//
//      url: serviceUrl,
//      type: 'POST',
//      data: 'subcat2name=' + encodeURIComponent(subcat2)
//      + '&Category=' + encodeURIComponent($("#category").val())
//      + '&subcat1name=' + encodeURIComponent($("#subcat1").val())
//      + '&companyname=' + encodeURIComponent($("#compname").val()),
//      dataType: 'json',
//  }).done(function (data) {
//  	
//  	var PRIORITY = data[0]["PRIORITY"];
//  	var SEVERITY = data[0]["SEVERITY"];
////  	//alert(PRIORITY)
////  	//alert(SEVERITY)
////      var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2'>";
////      html = html + '<option value="">--Please Select Sub-Category2--</option>';
////      for (var i = 0; i < data.length; i++) {
////          html += '<option value="' + data[i] + '">' + data[i]
////                  + '</option>';
////      }
//
//  	$("#priority").val(PRIORITY);
//  	$("#severity").val(SEVERITY);
////      document.getElementById("priority").innerHTML = html;
//  });
  
  
//}


//Onchange mehtod  getalldataacording 
function getAlldataAccordingsubject(subject){
	
	////alert("inside  getAlldataAccordingsubject");
	
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/UserActivity/getAlldataAccordingsubject";
	   
	    $.ajax({

	        type : 'POST',
	        url :serviceUrl,
	        dataType: 'json',
	        async:false,
	        data:'subject=' + encodeURIComponent(subject)+'&company=' + encodeURIComponent($('#compname').val()),
	    }).done(function(data) {
//	       //alert(data[0]["FULLNAME"])
	    	//localStorage.setItem("company",  data[0]['COMPANY']);
	    	
	    	
	    	
	    	
	       $('#category').val(data[0]["CATEGORY"]);
	       $('#subcat1').val(data[0]["SUBCATEGORY1"]);
	       $('#subcat2').val(data[0]["SUBCATEGORY2"]);
	       $('#priority').val(data[0]["PRIORITY"]);
	       $('#severity').val(data[0]["SEVERITY"]);
	     
	    });   
	    
	
}
function submitRaise(){
   //alert($("#priority").val());
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/insertUserRaiseTicket";
	
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
            //   //alert(data);
//        	 $("#spin").hide();
//        	 $("#l_button").hide();
               var nameArr = data.split(',');
             //  //alert(nameArr[0]);
            //   //alert(nameArr[1]);
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
       }); 
}
var callToolTip231 = function (fieldName, status) {
//    if (fieldName === "category") {
//        var errorMessage = "<span>Please Select Category<span>";
//    }
//    else if (fieldName === "subcat1") {      
//        var errorMessage = "<span>Please Select Sub-Category1<span>";
//    }
//    else if (fieldName === "subcat2") {      
//        var errorMessage = "<span>Please Select Sub-Category2<span>";
//    }
	 
    if (fieldName === "requestmode") {
        var errorMessage = "<span>Please Select Request Mode<span>";
    }
    else if (fieldName === "subdiv") {
        var errorMessage = "<span>Please Enter Subject<span>";
    }
    else if (fieldName === "AssetDiv") {
        var errorMessage = "<span>Please Select Asset<span>";
    }
    else if (fieldName === "description") {
        var errorMessage = "<span>Please Enter Description<span>";
    }
//    else if (fieldName === "priority") {
//        var errorMessage = "<span>Please Select Priority<span>";
//    }
     else if (fieldName === "empPic") {
        var errorMessage = "<span>File size should be > 1KB<span>";
    }
    

    $("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true,
         at:'center'
    });
    if (status == "show") {
        $("#" + fieldName).tooltip('show');
    } else {
        $("#" + fieldName).tooltip('hide');
    }
}

 var indexError12 = 0;
$('#empPic').on('change',function(){
//	if($('#empPic').length>0)
//		{
//		 indexError12 =12;
//		}
	
	if ($('#empPic').val() == '') {
		indexError12 = 0;
	} else {
		indexError12 = 12;
	}

    })
   
function validateForm()
{
 
      var indexError = 0; 
   
//   if ($('#category').val() === '') {
//        console.log('fill category');
//        callToolTip231('category', 'show');
//
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#subcat1').val().trim() === '') {
//        console.log('fill group');
//        callToolTip231('subcat1', 'show');
//
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
//    if ($('#subcat2').val().trim() === '') {
//        console.log('fill group');
//        callToolTip231('subcat2', 'show');
//
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
    if ($('#requestmode').val().trim() === '') {
        console.log('fill requestmode');
        callToolTip231('requestmode', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if (($('#assetCheck').is(':checked'))&&($('#assetid').val() === null||$('#assetid').val()=="")) {
//  	  alert("hii")
  	      
  	        callToolTip231('AssetDiv', 'show');

  	        if (indexError == 0) {

  	        }
  	        indexError = indexError + 1;
  	} 
   ////alert( $('#sub').val());''
    if ($('#sub').val() === null||$('#sub').val()=="") {
        console.log('fill sub');
        callToolTip231('subdiv', 'show');

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
//    if ($('#priority').val().trim() === '') {
//        console.log('fill prioprity');
//        callToolTip231('priority', 'show');
//
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
   
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
 
    
   //console.log("validation error count::::"+indexError);
 if (indexError != 0) {

//    //alert("false");
        return false;

    } else {


        return true;
    }

}
//
//focus out
//$('#category').on('focusout', function () {
//
//    var usertype = $('#category').val();
//    if (usertype.trim() === "") {
//        callToolTip231('category', 'show');
//    }
//    else {
//        callToolTip231('category', 'hide');
//    }
//});
////focus out
//$('#subcat1').on('focusout', function () {
//
//    var usertype = $('#subcat1').val();
//    if (usertype.trim() == "") {
//        callToolTip231('subcat1', 'show');
//    }
//    else {
//        callToolTip231('subcat1', 'hide');
//    }
//});
////focus out
//$('#subcat2').on('focusout', function () {
//
//    var usertype = $('#subcat2').val();
//    if (usertype.trim() == "") {
//        callToolTip231('subcat2', 'show');
//    }
//    else {
//        callToolTip231('subcat2', 'hide');
//    }
//});
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
$('#subdiv').on('focusout', function () {

    var usertype = $('#sub').val();
    if (usertype == null) {
        callToolTip231('subdiv', 'show');
    }
    else {
        callToolTip231('subdiv', 'hide');
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
//$('#priority').on('focusout', function () {
//
//    var usertype = $('#priority').val();
//    if (usertype.trim() == "") {
//        callToolTip231('priority', 'show');
//    }
//    else {
//        callToolTip231('priority', 'hide');
//    }
//});




$('#empPic').on('focus', function () {
    callToolTip231('empPic', 'destroy');
});
$('#AssetDiv').on('click', function () {
//	alert("hii")
    callToolTip231('AssetDiv', 'destroy');
});

$('#requestmode').on('focus', function () {
    callToolTip231('requestmode', 'destroy');
});
$('#subdiv').on('click', function () {
    callToolTip231('subdiv', 'destroy');
});
$('#description').on('focus', function () {
    callToolTip231('description', 'destroy');
});
//$('#priority').on('focus', function () {
//    callToolTip231('priority', 'destroy');
//});

$("#resetbtn").click(function() {
    $("#category").val("");
    $("#subcat1").val("");
    $("#subcat2").val("");
    $("#requestmode").val("");
    $("#sub").val("");
    $("#sub").select2('val', 'All');
    $("#description").val("");
    $("#priority").val("");
    $("#severity").val("");
    $("#empPic").val("");
    $("#assetid").select2('val', 'All');
   
//    callToolTip231('category', 'hide');
//    callToolTip231('subcat1', 'hide');
//    callToolTip231('subcat2', 'hide');
    callToolTip231('requestmode', 'hide');
    callToolTip231('subdiv', 'hide');
    callToolTip231('description', 'hide');
    callToolTip231('priority', 'hide');
    callToolTip231('empPic', 'hide');
    callToolTip231('AssetDiv', 'hide');
   
});

function submitbutton101()
{
//	$('#l_button').show();
//	$('#spin').show();
  // //alert("in submit button");

    if(!validateForm())
    {
     //  //alert("failed");R
        event.preventDefault();
    }
    else if(validateForm())
    {
    	//alert("hi");
//    				checkingForSLA();
    	 if($('#site').val()==='NA'||$('#site').val()==='' || $('#department').val()==='NA'||$('#department').val()===''|| $('#sub_department').val()==='NA' ||$('#sub_department').val()==='' || $('#location').val()==='NA'||$('#location').val()==='')
    	 {
//    		 //alert("site")
    		swal({
                title: "Error!",
                html: "Your Profile is incomplete. Kindly contact the Administrator to complete your profile.",
                type: "error",
                width: 300,
                height: 200,
                buttons: false,
                allowOutsideClick: false,
                preConfirm: function() {
                    var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/User/UpdateProfile";
                 }
                
            })
    		
    	}
    	 else
    	 {
    			//	$("#spin").show();
    				////alert("dsfdsff")
    		
    				submitRaise();
    				$("#raise-btn").attr("disabled", true);
    				
    				
    				
    			}
    }
 
}
//function checkingForSLA()
//{
//	////alert("insdie checkingForSLAs")
//	 var l = window.location;
//		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/UserActivity/chekingSLA";
//	    $.ajax({
//	        type : 'POST',
//	        url :serviceUrl,
//	        dataType: 'json',
//	        data:'company=' + encodeURIComponent($('#compname').val())+'&priority=' + encodeURIComponent($('#priority').val())+'&severity=' + encodeURIComponent($('#severity').val()),
//	    }).done(function(data) {
//	    	//alert(data)
//	    	if(data=="error")
//	    		{
//	    		swal({
//	                title: "Error!",
//	                html: "Priority and serverity not set on this priority "+$('#priority').val()+" and severity "+$('#severity').val()+" .Kindly Contact with admin",
//	                type: "error",
//	                width: 300,
//	                height: 200,
//	                buttons: false,
//	                allowOutsideClick: false,
//	                preConfirm: function() {
//	                	location.reload();
//	                 }
//	                
//	            })
//	    		}
//	    	if(data=="success")
//	    		{
//	    		submitRaise();
//	    		
//	    		}
//	    	
//	    });
//}
//

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
