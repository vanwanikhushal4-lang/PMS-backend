
window.onload=function(){
    
 // $('#requestmode').focus();
  
  $('#sub').select2({
//    theme: 'bootstrap4'
  	tags: true,
  	placeholder: "Select a Subject or Enter New",
//      allowClear: true
  })
   $('#assetid').select2({
//    theme: 'bootstrap4'
	   width:'80%',
  	tags: true,
  	placeholder: "Select Asset Name",
  	
//      allowClear: true
  })
   $('#scopbasedcompany').select2({
    //theme: 'bootstrap4',
  //	tags: true,
  	placeholder: "Please Select Company",
  	maximumSelectionSize: 1,
    allowClear: true
  })
  
   $('#locationbehalfuser').select2({
    //theme: 'bootstrap4',
  //	tags: true,
  	placeholder: "Please Select Location",
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
	var serviceUrl = base_url + "/EnggActivity/getAllEngDetails";
   
    $.ajax({

        type : 'POST',
        url :serviceUrl,
        dataType: 'json',
        async:false,
    }).done(function(data) {
//      //alert(data[0]["VIP_LOGIN"])
    
       
        $('#name1').val(data[0]["FULLNAME"]);
       $('#emailid').val(data[0]["EMAIL"]);
       $('#phone').val(data[0]["PHONE"]);
       $('#compname').val(data[0]["COMPANY"]);
       $('#site').val(data[0]["BRANCH"]);
       $('#department').val(data[0]["DEPARTMENT"]);
       $('#subDepartment').val(data[0]["SUB_DEPARTMENT"]);
       $('#location').val(data[0]["LOCATION"]);
       $('#username').val(data[0]["USERNAME"]);
       $('#vipuser').val(data[0]["VIP_LOGIN"]);
    });   
    
    
    
    //GET SCOP BASED COMPANY  
    
    
    
   
    var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompany";

   $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json'
    }).done(function(data) {
//      //alert(data[0]["FULLNAME"])
    	////alert(data.length);
    	var html = "  <option value=''> -- Please Select --</option>";
    	//localStorage.setItem("company",  data[0]['COMPANY']);
    	
    	for(var i=0; i<data.length; i++){
    		
    		
    		
    		html += '<option value="' +data[i]+ '">' + data[i]
    	          + '</option>';
    	
    	//	//alert(data[0]);
    		
    	}
    	
    	document.getElementById("scopbasedcompany").innerHTML=html;
    	////alert(html);
    
    	
   
    });
    
    
    
    // //alert($('#compname').val());
   
//    
//    var l = window.location;
//  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//  	var serviceUrl = base_url + "/Master/getCategoryDetails";
//
//    $.ajax({
//
//        url :serviceUrl,
//        type : 'POST',
//        dataType: 'json',
//    }).done(function(data) {
//
//        var html =" <select class='form-control' tabindex='7' id='category' name='category' onchange='JavaScript:change_subcat1(this.value)'>";
//        html=html+'<option value="">--Please Select Category--</option>';
//        for (var i = 0; i < data.length; i++) {
//            html += '<option value="' +data[i]+ '">' + data[i]
//            + '</option>';
//        }
//
//        document.getElementById("category").innerHTML=html;
//    });
//    

  
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getPriorityName";
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
};

////////////// ONLOAD ENDS /////////////////////

function getallinformationofAsset(asset){
	 document.getElementById("HideAssetdata").style.display = "none";
//		//alert("ggggg")
		if(asset.length>0){
//			//alert("inside");
//			$('#assetCheck').attr('checked',false); 
		
//		//alert(asset);
	
		 var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/UserActivity/GetAssetinformaion";
		
		  $.ajax({
		      type: 'POST',	
		      url: serviceUrl,
		      dataType: 'json',
		     data: 'asset=' + encodeURIComponent(asset),
		     
		      success: function(data) {  	
//		      //alert(JSON.stringify(data))
		    	 // //alert(data[0]["OTHEREMAIL"])
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

//$('#AssetDiv').select2({
//	
//	tags: true,
//	placeholder: "Select a Branch or Enter New",
//	dropdownParent: $('#modelcategory1')
//})
$('#assetCheck').change(function () {
   if (this.checked)
       {
//   	//alert($("#otherusername").val())
   	
   	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getAssetFromOfLoginUser";

   	$.ajax({

   	  url: serviceUrl,
   	  type: 'POST',
   	  dataType: 'json',
   	  data:'loginuser='+$("#otherusername").val(),
   	}).done(function (data) {

   	// //alert(data)
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
//   	 $("#assetid").val();
   	 $("#assetid").select2('val', 'All');
   	}
});




function change_subcat1(Category)
{
//	//alert(ProblemCategory)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getINCSubCategory1Name";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        data: 'Category=' + encodeURIComponent(Category)
        		+ "&companyname=" + encodeURIComponent($('#scopbasedcompany').val()),
        dataType: 'json',
    }).done(function (data) {

        var html = " <select class='form-control' tabindex='7' id='subcat1' name='subcat1' onchange='JavaScript:change_subcat2(this.value)'>";
        html = html + '<option value="">--Please Select Sub-Category1--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("subcat1").innerHTML = html;
    });
}

function change_subcat2(subcat1)
{
//	//alert("category: "+$('#category').val());
//	//alert("subcat1: "+subcat1)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getINCSubCategory2Name";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        data: 'subcat1name=' + encodeURIComponent(subcat1)
        + '&Category=' + encodeURIComponent($("#category").val())
        + "&companyname=" + encodeURIComponent($('#scopbasedcompany').val()),
        dataType: 'json',
    }).done(function (data) {
//    	//alert(data)
        var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2' onchange='JavaScript:change_PriorityAndSeverity(this.value)'>";
        html = html + '<option value="">--Please Select Sub-Category2--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("subcat2").innerHTML = html;
    });
}

function change_PriorityAndSeverity(subcat2)
{
//	//alert("category: "+$('#category').val());
//	//alert("subcat1: "+$('#subcat1').val());
//	//alert("subcat2: "+subcat2);
	/*var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getINCPriorityAndSeverityName";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        data: 'subcat2name=' + encodeURIComponent(subcat2)
        + '&Category=' + encodeURIComponent($("#category").val())
        + '&subcat1name=' + encodeURIComponent($("#subcat1").val())
        + '&companyname=' + encodeURIComponent($("#scopbasedcompany").val()),
        dataType: 'json',
    }).done(function (data) {
    	
    	var PRIORITY = data[0]["PRIORITY"];
    	var SEVERITY = data[0]["SEVERITY"];
//    	//alert(PRIORITY)
//    	//alert(SEVERITY)
//        var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2'>";
//        html = html + '<option value="">--Please Select Sub-Category2--</option>';
//        for (var i = 0; i < data.length; i++) {
//            html += '<option value="' + data[i] + '">' + data[i]
//                    + '</option>';
//        }

    	$("#priority").val(PRIORITY);
    	$("#severity").val(SEVERITY);
//        document.getElementById("priority").innerHTML = html;
    });*/
    
    ////////////// DATA FOR SUBJECT ///////
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getINCSubject";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'subcat2name=' + encodeURIComponent(subcat2)
        + '&Category=' + encodeURIComponent($("#category").val())
        + '&subcat1name=' + encodeURIComponent($("#subcat1").val())
         + '&company=' + encodeURIComponent($("#scopbasedcompany").val()),
        success: function(data2) {
//            //alert(data2)
        	var html = "  <option value=''> -- Please Select --</option>";
            for (var i = 0; i < data2.length; i++) {
                html += '<option value="' + data2[i] + '">' + data2[i]
                        + '</option>';
            }
            document.getElementById("sub").innerHTML = html;
     }
}); 
}


function submitRaise(){
//    //alert("in submit raise");
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/insertEngRaiseTicketOnBehalf";
	
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
           //    //alert(data);
        	   var nameArr = data.split(',');
        	   
        	  // //alert(nameArr[0] );
        	   
               if (nameArr[0] === "success") {
                swal({
                    title: "Successful!",
                    html: "Ticket ID = " + nameArr[1] + "<br>   Raised Ticket Successfully",
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
     else if (fieldName === "AssetDiv") {
         var errorMessage = "<span>Please Select Asset<span>";
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
//    else if (fieldName === "priority") {
//        var errorMessage = "<span>Please Select Priority<span>";
//    }
     else if (fieldName === "empPic") {
        var errorMessage = "<span>File size should be > 1KB<span>";
    }
    
     else if (fieldName === "behalfdiv") {
         var errorMessage = "<span>Please Select User<span>";
     }
     
     else if (fieldName === "getcompanydiv") {
         var errorMessage = "<span>Please Select Company<span>";
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
	if ($('#empPic').val() == '') {
		indexError12 = 0;
	} else {
		indexError12 = 12;
	}
    })
   
function validateForm()
{
 
      var indexError = 0; 
   
   if ($('#category').val() === '') {
        //('fill category');
        callToolTip231('category', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#subcat1').val().trim() === '') {
        //('fill subcat1');
        callToolTip231('subcat1', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
     if ($('#subcat2').val().trim() === '') {
        //('fill subcat2');
        callToolTip231('subcat2', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    ////alert($('#requestmode').val())
    if ($('#requestmode').val().trim() === '') {
        //('fill requestmode');
        callToolTip231('requestmode', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
 //   //alert($('#sub').val())
    if ($('#sub').val()== ''||$('#sub').val()==null) {
    	
        //('fill sub');
        callToolTip231('subjectDiv', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#description').val().trim() === '') {
        //('fill description');
        callToolTip231('description', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#usernamesofbehalf').val() == null ||  $('#usernamesofbehalf').val() == '') {
        //('fill sub');
        callToolTip231('behalfdiv', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#scopbasedcompany').val() == null ||  $('#scopbasedcompany').val() == '') {
        //('fill sub');
        callToolTip231('getcompanydiv', 'show');

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
    
    
//    if ($('#priority').val().trim() === '') {
//        //('fill prioprity');
//        callToolTip231('priority', 'show');
//
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
    if (($('#assetCheck').is(':checked'))&&($('#assetid').val() === null||$('#assetid').val()=="")) {
	      
        callToolTip231('AssetDiv', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
} 
   
   if(indexError12 != 0)
   {
      const size= ($('#empPic')[0].files[0].size);
     //(size);
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
 
    
   //("validation error count::::"+indexError);
 if (indexError != 0) {

//    //alert("false");
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
        callToolTip231('subjectDiv', 'show');
    }
    else {
        callToolTip231('subjectDiv', 'hide');
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


$('#behalfdiv').on('focusout', function () {

    var usertype = $('#behalfdiv').val();
    if (usertype == null) {
        callToolTip231('behalfdiv', 'show');
    }
    else {
        callToolTip231('behalfdiv', 'hide');
    }
});


$('#getcompanydiv').on('focusout', function () {

    var usertype = $('#scopbasedcompany').val();
    if (usertype == null) {
        callToolTip231('getcompanydiv', 'show');
    }
    else {
        callToolTip231('getcompanydiv', 'hide');
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


$('#category').on('focus', function () {
    callToolTip231('category', 'destroy');
});
$('#AssetDiv').on('click', function () {
//	//alert("hii")
    callToolTip231('AssetDiv', 'destroy');
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

$('#sub').on('click', function () {
	////alert("hiii")
    callToolTip231('subjectDiv', 'hide');
});
$('#description').on('focus', function () {
	////alert("hiii")
    callToolTip231('description', 'destroy');
});
//$('#priority').on('focus', function () {
//    callToolTip231('priority', 'destroy');
//});
$('#behalfdiv').on('click', function () {
    callToolTip231('behalfdiv', 'destroy');
});

$('#getcompanydiv').on('click', function () {
    callToolTip231('getcompanydiv', 'destroy');
});

$('#getlocationDiv').on('click', function () {
    callToolTip231('getlocationDiv', 'destroy');
});

$("#resetbtn").click(function() {
	$("#scopbasedcompany").select2('val', 'All');
	$("#usernamesofbehalf").select2('val', 'All');
	$("#assetid").select2('val', 'All');
	  callToolTip231('AssetDiv', 'hide');
	$("#usernamesofbehalf").empty();
//	//alert("hkkio");
	document.getElementById("HideAssetdata").style.display = "none";
	document.getElementById("Hideotherdata").style.display = "none";
    $("#category").val("");
    $("#subcat1").val("");
    $("#requestmode").val("");
    $("#sub").select2('val', 'All');
    $("#description").val("");
    $("#priority").val("");
    $("#severity").val("");
    $("#empPic").val("");
     $("#subcat2").val("");
     $("#locationbehalfuser").val("");
   
   
     callToolTip231('subcat2', 'hide');
    callToolTip231('category', 'hide');
    callToolTip231('subcat1', 'hide');
    callToolTip231('requestmode', 'hide');
    callToolTip231('subjectDiv', 'hide');
    callToolTip231('description', 'hide');
   // callToolTip231('priority', 'hide');
    callToolTip231('empPic', 'hide');
    callToolTip231('behalfdiv', 'hide');
    callToolTip231('getcompanydiv', 'hide');
    callToolTip231('getlocationDiv', 'hide');
   
});

function submitbutton101()
{
//    //alert("in submit button");

    if(!validateForm())
    {
//        //alert("failed");
        event.preventDefault();
    }
    else if(validateForm())
    {
//        //alert("Passed");
    	if($('#priority').val()==='' || $('#severity').val()==='')
    		{
    		swal({
                title: "Error!",
                html: "Ticket cannot be raised as Priority & Severity are empty.",
                type: "error",
                width: 300,
                height: 200,
                buttons: false,
                allowOutsideClick: false,
                

            })
    		}
    	
    	else if($('#othersite').val()==='NA' || $('#otherdepart').val()==='NA' || $('#othersubdepart').val()==='NA' || $('#otherlocation').val()==='NA'){
    		
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
    		$("#raise-btn").attr("disabled", true);
    	}
       
    }
}



function getallinformationofbehalfuser(othername){
	//alert("//alert(value)");
//	var username =$.session.get('time');
//    //alert(username );

	 document.getElementById("Hideotherdata").style.display = "none";
		
		if(othername.length>0){
			////alert("inside");
		 
			 $("#assetCheck").prop("checked", false);
			 
			   $("#assetid").select2('val', 'All');
		 $('#toggleAssetCheck').hide();
		 $('#HideAssetdata').hide();
//			 document.getElementById("HideAssetdata").style.display = "none";
		////alert(othername);
		//getting split for company and username
		
		const words = othername.split('~');
		////(words[0]);
		var otherusername=words[0];
		
//		//alert(othercompany + "company");
		////alert(otherusername + "otherusername ias");
		////alert($("#scopbasedcompany").val());
		 var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/UserActivity/Getotherinformaion";
		
		  $.ajax({
		      type: 'POST',	
		      url: serviceUrl,
		      dataType: 'json',
		     data: 'othername=' + encodeURIComponent(otherusername)
		     + '&othercompany=' + encodeURIComponent($("#scopbasedcompany").val()),
		     
		      success: function(data) {  	
		      
		    	// //alert(data[0]["OTHEREMAIL"])
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
		    	
		    	$("#otheremail").val(OTHEREMAIL);
		    	$("#otherfullname").val(OTHERFULLNAME);
		    	$("#othersite").val(OTHERBRANCH);
		    	$("#othercompname").val(OTHERCOMPANY);
		    	$("#otherdepart").val(OTHERDEPARTMENT);
		    	
		       	$("#otherphone").val(OTHERPHONE);
		    	$("#otherlocation").val(OTHERLOCATION);
		    	$("#othersubdepart").val(OTHERSUBDEPARTMENT);
		    	$("#otherusername").val(OTHERUSERNAME);
		    	$("#vipuserother").val(VIPUSEROTHER);
		    	
		    	
		      }
		}); 
		    document.getElementById("Hideotherdata").style.display = "block";

		
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
		data : 'company=' + encodeURIComponent($("#scopbasedcompany").val())
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

//GET USERS BELONG TO SELECTED COMPANY
//getusernamebasedoncompany
function getlocationbasedoncompany(company){
//alert(company);
	if(company.length>0){
		if((company !="3i Infotech"))
			{
			//alert("hode");
			
			$('#Hideotherdata').hide();
			$('#HideAssetdata').hide();
				$('#Hideotherdataforbehalf').hide();
				$('#redopt').hide();
				$('#assetchecthide').hide();

			}
		else
			{
		//	alert("gfg")
			$('#redopt').show();
			$('#assetchecthide').show();
			$('#HideAssetdata').hide();
			$('#Hideotherdataforbehalf').hide();
			$('#Hideotherdata').hide();
			
			}
		
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
//	       theme: 'bootstrap4'
	   	   width:'80%',
	     	tags: true,
	     	placeholder: "Select Location",
	     	
//	         allowClear: true
	     })
//var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/UserActivity/getallusernameforraiseonbehalf";
//
// $.ajax({
//
//     type : 'POST',
//     url :serviceUrl,
//     dataType: 'json',
//    
//     data:'company=' + encodeURIComponent(company),
// }).done(function(data) {
////    //alert(data[0]["FULLNAME"])
// 	 html = "  <option value=''> -- Please Select --</option>";
// 	//localStorage.setItem("company",  data[0]['COMPANY']);
// 	for(var i=0; i<data.length; i++){
// 		
// 		
// 		html += '<option value="' +data[i]+ '">' + data[i]
// 	          + '</option>';
// 	
// 		
// 	}
// 	
// 	
// 	document.getElementById("usernamesofbehalf").innerHTML=html;
// 	
// 	
//
// 	
//
// });   
 
 
 var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCategoryDetailsListForsubjecmaster";

$.ajax({
 type: 'POST',
 url: serviceUrl,
 dataType: 'json',
 data:'cname='+encodeURIComponent(company),
 success: function(data2) {
//     //alert(data2)
	 var html = "  <option value=''> -- Please Select --</option>";
            for (var i = 0; i < data2.length; i++) {
                html += '<option value="' + data2[i] + '">' + data2[i]
                        + '</option>';
            }
            document.getElementById("category").innerHTML = html;
     }
});


	}else{
	//	//alert("hii");
		document.getElementById("Hideotherdata").style.display = "none";
		$("#usernamesofbehalf").select2('val', 'All');
		//getusernamebasedoncompany("");
		$("#usernamesofbehalf").empty();
	}
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getRequestModeForRaiseOnBehalf";

	//var getRequestModeName='getRequestModeName';  
	$.ajax({

	  url :serviceUrl,
	  type : 'POST',
	  dataType: 'json',
	  data:'company='+encodeURIComponent(company),
	}).done(function(data) {
		

	  var html =" <select class='form-control' tabindex='8' id='requestmode' name='requestmode'>";
	  html=html+'<option value="">--Please Select Request Mode--</option>';
	  for (var i = 0; i < data.length; i++) {
	      html += '<option value="' +data[i]+ '">' + data[i]
	      + '</option>';
	  }

	  document.getElementById("requestmode").innerHTML=html;
	});

	
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
