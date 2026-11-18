
window.onload = function () {
//$("#priority").val("<option value=''>-- Please Select Priority --</option>")
//$('#requestmode').focus();
$('#sub').select2({
//  theme: 'bootstrap4'
	tags: true,
	placeholder: "Select a Subject or Enter New",
//    allowClear: true
})
$('#assetid').select2({
//    theme: 'bootstrap4'
	   width:'80%',
  	tags: true,
  	placeholder: "Select Asset Name",
  	
//      allowClear: true
  })
   $('#locationbehalfuser').select2({
//    theme: 'bootstrap4'
	   width:'80%',
  	tags: true,
  	placeholder: "Select Location",
  	
//      allowClear: true
  })

 $('#scopbasedcompany').select2({
    //theme: 'bootstrap4',
  //	tags: true,
  	placeholder: "Please Select Company",
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
    dataType: 'json'
}).done(function(data) {
//   ////alert(data[0]["FULLNAME"])

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






//GET SCOP BASED COMPANY  




var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCompany";

$.ajax({
    url: serviceUrl,
    type: 'POST',
    dataType: 'json'
}).done(function(data) {
 // ////alert(data.sort())
	data.sort()
	//////alert(data.length);
	var html = "  <option value=''> -- Please Select --</option>";
	//localStorage.setItem("company",  data[0]['COMPANY']);
	
	for(var i=0; i<data.length; i++){
		
		
		
		html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	
	//	////alert(data[0]);
		
	}
	
	document.getElementById("scopbasedcompany").innerHTML=html;
	//////alert(html);

	

});
//
//var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getCategoryDetails";
//
//$.ajax({
//
//    url :serviceUrl,
//    type : 'POST',
//    dataType: 'json',
//}).done(function(data) {
//
//    var html =" <select class='form-control' tabindex='7' id='category' name='category' onchange='JavaScript:change_subcat1(this.value)'>";
//    html=html+'<option value="">--Please Select Category--</option>';
//    for (var i = 0; i < data.length; i++) {
//        html += '<option value="' +data[i]+ '">' + data[i]
//        + '</option>';
//    }
//
//    document.getElementById("category").innerHTML=html;
//});
//	//    
//	//    
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getRequestModeName";
//
//	// var getRequestModeName='getRequestModeName';
//	$
//			.ajax({
//
//				url : serviceUrl,
//				type : 'POST',
//				dataType : 'json',
//			})
//			.done(
//					function(data) {
//						// ////alert(data)
//
//						// var pollingHost=data;
//						// var d = pollingHost.split(",");
//						// var length=d.length-1;
//						var html = " <select class='form-control' tabindex='8' id='requestmode' name='requestmode'>";
//						html = html
//								+ '<option value="">--Please Select Request Mode--</option>';
//						for (var i = 0; i < data.length; i++) {
//							html += '<option value="' + data[i] + '">'
//									+ data[i] + '</option>';
//						}
//
//						document.getElementById("requestmode").innerHTML = html;
//					});
//
//  var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getCategoryDetails";
//
//    $.ajax({
//
//        url: serviceUrl,
//        type: 'POST',
//        dataType: 'json',
//    }).done(function (data) {
//
//        var html = " <select class='form-control' tabindex='7' id='enggcat' name='enggcat' onchange='JavaScript:change_enggsubtype(this.value)'>";
//        html = html + '<option value="">--Please Select Category--</option>';
//        for (var i = 0; i < data.length; i++) {
//            html += '<option value="' + data[i] + '">' + data[i]
//                    + '</option>';
//        }
//
//        document.getElementById("enggcat").innerHTML = html;
//    });
//    
//    
    
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getPriorityName";

    $.ajax({
        url :serviceUrl,
        type : 'POST',
        dataType: 'json',
    }).done(function(data) {

        var html =" <select class='form-control' tabindex='13' id='priority' name='priority' '>";
        html=html+'<option value="">--Please Select Priority--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' +data[i]+ '">' + data[i]
            + '</option>';
        }

//        document.getElementById("priority").innerHTML=html;
    });
 
   // change_PriorityAndSeverity(subcat2);
    
};

///////////////// ONLOAD ENDS ////////////////////
function getallinformationofAsset(asset){
	 document.getElementById("HideAssetdata").style.display = "none";
//		////alert("ggggg")
		if(asset.length>0){
//			////alert("inside");
//			$('#assetCheck').attr('checked',false); 
		
//		////alert(asset);
	
		 var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/UserActivity/GetAssetinformaion";
		
		  $.ajax({
		      type: 'POST',	
		      url: serviceUrl,
		      dataType: 'json',
		     data: 'asset=' + encodeURIComponent(asset),
		     
		      success: function(data) {  	
		    	 // ////alert(data);
//		      ////alert(JSON.stringify(data))
		    	 // ////alert(data[0]["OTHEREMAIL"])
		    	var ASSET_NAME=data[0]["ASSET_NAME"];
		    	////alert(ASSET_NAME);
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
//  	////alert($("#otherusername").val())
//	var st= ($("#usernamesofbehalf")).val();
//	  if(!(st==""))
//	  {
//		////alert($("#otherusernameforbehalf").val())
//	  }
//  	////alert($("#otherusernameforbehalf").val())
  	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getAssetFromOfLoginUser";

  	$.ajax({

  	  url: serviceUrl,
  	  type: 'POST',
  	  dataType: 'json',
  	  data:'loginuser='+$("#otherusernameforbehalf").val(),
  	}).done(function (data) {

  	// ////alert(data)
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
//  	 $("#assetid").val();
  	 $("#assetid").select2('val', 'All');
  	}
});
function change_subcat1(Category)
{
//	////alert(ProblemCategory)
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
//	////alert("category: "+$('#category').val());
//	////alert("subcat1: "+subcat1)
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
//    	////alert(data)
//        var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2' onchange='JavaScript:change_PriorityAndSeverity(this.value)'>";
    	 var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2' >";
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
//	////alert("category: "+$('#category').val());
//	////alert("subcat1: "+$('#subcat1').val());
//	////alert("subcat2: "+subcat2);
	var l = window.location;
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
//    	////alert(PRIORITY)
//    	////alert(SEVERITY)
//        var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2'>";
//        html = html + '<option value="">--Please Select Sub-Category2--</option>';
//        for (var i = 0; i < data.length; i++) {
//            html += '<option value="' + data[i] + '">' + data[i]
//                    + '</option>';
//        }

    	$("#priority").val(PRIORITY);
    	$("#severity").val(SEVERITY);
//        document.getElementById("priority").innerHTML = html;
    	
    	   var l = window.location;
    	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	 	var serviceUrl = base_url + "/Master/getPriorityName";

    	    $.ajax({
    	        type: 'POST',
    	        url: serviceUrl,
    	        dataType: 'json',
    	        data: 'companyname=' + encodeURIComponent($("#scopbasedcompany").val()),
    	        success: function(data2) {
    	         //   ////alert(data2)
    	        	var html = "  <option value=''> -- Please Select --</option>";
    	            for (var i = 0; i < data2.length; i++) {
    	                html += '<option value="' + data2[i] + '">' + data2[i]
    	                        + '</option>';
    	            }
    	            document.getElementById("priority").innerHTML = html;
    	            $("#priority").val(PRIORITY);
    	            
    	     }
    	}); 
    	   
    	    /////////////////// GET SEVERITY DATA /////////////
        	var l = window.location;
         	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
         	var serviceUrl = base_url + "/Master/getSeverityName";
            $.ajax({
            	url :serviceUrl,
                type : 'POST',
                dataType: 'json',
                data: 'companyname=' + encodeURIComponent($("#scopbasedcompany").val()),
            }).done(function(severitydata) {
            	var html = "  <option value=''> -- Please Select --</option>";
                for (var i = 0; i < severitydata.length; i++) {
                    html += '<option value="' +severitydata[i]+ '">' + severitydata[i]
                    + '</option>';
                }
                document.getElementById("severity").innerHTML=html;
                $("#severity").val(SEVERITY);
            });
    	    
    	    
    	
    	
    });

    
    
    
    
    
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
//            ////alert(data2)
        	var html = "  <option value=''> -- Please Select --</option>";
            for (var i = 0; i < data2.length; i++) {
                html += '<option value="' + data2[i] + '">' + data2[i]
                        + '</option>';
            }
            document.getElementById("sub").innerHTML = html;
     }
}); 
}

function change_Assigntype(assignType){
//	////alert(assignType)
	
	document.getElementById("Hideotherdata").style.display = "none";
	$('#enggcat').val("");
	$('#enggassign').val("");
	$('#engGroup').val("");
	callToolTip231('enggcat', 'destroy');
	callToolTip231('enggassign', 'destroy');
	callToolTip231('engGroup', 'destroy');
	
	if(assignType==="Engineer"){
		$('#enggDiv').show();
		$('#groupDiv').hide();
	}
	else if(assignType==="Group"){
		$('#groupDiv').show();
		$('#enggDiv').hide();
		

	}
	else{
		$('#enggDiv').hide();
		$('#groupDiv').hide();
	}
}

function change_enggsubtype(category)
{
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getSubCategoryEnggName";
    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: 'categ=' + encodeURIComponent(category)
        + '&Company=' + encodeURIComponent($("#compname").val())
        + '&Branch=' + encodeURIComponent($("#site").val())
        + '&Department=' + encodeURIComponent($("#department").val()),
        
    }).done(function (data) {
    	alert("ddd"+data)
        var html = " <select class='form-control' tabindex='7' id='enggassign' name='enggassign'>";
        html = html + '<option value="">--Please Select Engineer--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("enggassign").innerHTML = html;
    });
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
    else if (fieldName === "priority") {
        var errorMessage = "<span>Please Select Priority<span>";
    }
//    else if (fieldName === "severity") {
//        var errorMessage = "<span>Please Select Severity<span>";
//    }
    else if (fieldName === "assignTo") {
        var errorMessage = "<span>Please Select Assign To<span>";
    }
    else if (fieldName === "enggcat") {
        var errorMessage = "<span>Please Select Engineer Category<span>";
    }
    else if (fieldName === "enggassign") {
        var errorMessage = "<span>Please Select Engineer<span>";
    }
    else if (fieldName === "engGroup") {
        var errorMessage = "<span>Please Select Engineer Group<span>";
    }
    else if (fieldName === "empPic1") {
        var errorMessage = "<span>File size should be > 1KB<span>";
    }
    else if (fieldName === "assignnote") {
        var errorMessage = "<span>Please Enter Assign Note<span>";
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
        html: true
    });
    if (status == "show") {
        $("#" + fieldName).tooltip('show');
    } else {
        $("#" + fieldName).tooltip('hide');
    }
}

 var indexError12 = 0;
$('#empPic1').on('change',function(){
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
        console.log('fill category');
        callToolTip231('category', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#subcat1').val().trim() === '') {
//        console.log('fill group');
        callToolTip231('subcat1', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#subcat2').val().trim() === '') {
//      console.log('fill group');
      callToolTip231('subcat2', 'show');

      if (indexError == 0) {

      }
      indexError = indexError + 1;
  }
    if ($('#requestmode').val().trim() === '') {
        console.log('fill requestmode');
        callToolTip231('requestmode', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#sub').val() === null||$('#sub').val()=="") {
        console.log('fill sub');
         callToolTip231('subjectDiv', 'show');

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
//    if ($('#severity').val()==''|| $('#severity').val()==null) {
//        callToolTip231('severity', 'show');
//
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//    }
    if ($('#priority').val()== ''||$('#priority').val()==null) {
        console.log('fill prioprity');
        callToolTip231('priority', 'show');

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
    

    if ($('#assignTo').val().trim() === '') {
//        console.log('fill enggcat');
        callToolTip231('assignTo', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if($('#assignTo').val().trim() === 'Engineer'){
    	
    	 if ($('#enggcat').val().trim() === '') {
    	        console.log('fill enggcat');
    	        callToolTip231('enggcat', 'show');

    	        if (indexError == 0) {

    	        }
    	        indexError = indexError + 1;
    	    }
    	     if ($('#enggassign').val().trim() === '') {
    	        console.log('fill enggassign');
    	        callToolTip231('enggassign', 'show');

    	        if (indexError == 0) {

    	        }
    	        indexError = indexError + 1;
    	    }
    } else if ($('#assignTo').val().trim() === 'Group'){
    	
    	if ($('#engGroup').val().trim() === '') {
	        callToolTip231('engGroup', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
    }
    
    
    if ($('#usernamesofbehalf').val() == null ||  $('#usernamesofbehalf').val() == '') {
        console.log('fill sub');
        callToolTip231('behalfdiv', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#scopbasedcompany').val() == null ||  $('#scopbasedcompany').val() == '') {
        console.log('fill sub');
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

    if(indexError12 != 0)
   {
      const size= ($('#empPic1')[0].files[0].size);
     console.log(size);
    if(size<1)
    {
        callToolTip231('empPic1', 'show');
         indexError = indexError + 1;
    } 
    else
    {
        callToolTip231('empPic1', 'hide');
    }
   }
    
   console.log("validation error count::::"+indexError);
 if (indexError != 0) {

//    ////alert("false");
        return false;

    } else {

//        $('#spinner2').show();
//    ////alert("true");
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
$('#assignnote').on('focusout', function () {

    var usertype = $('#assignnote').val();
    if (usertype.trim() === "") {
        callToolTip231('assignnote', 'show');
    }
    else {
        callToolTip231('assignnote', 'hide');
    }
});

//focus out
$('#subcat1').on('focusout', function () {

    var usertype = $('#subcat1').val();
    if (usertype.trim() == "") {
        callToolTip231('subcat1', 'show');
    }
    else{
    	callToolTip231('subcat1', 'hide');
    }
});
//focus out
$('#subcat2').on('focusout', function () {

    var usertype = $('#subcat2').val();
    if (usertype.trim() == "") {
        callToolTip231('subcat2', 'show');
    }
    else{
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
$('#subjectDiv').on('focusout', function () {

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
//$('#severity').on('focusout', function () {
//
//    var usertype = $('#severity').val();
//    if (usertype.trim() == "") {
//        callToolTip231('severity', 'show');
//    }
//    else {
//        callToolTip231('severity', 'hide');
//    }
//});
$('#assignTo').on('focusout', function () {

    var usertype = $('#assignTo').val();
    if (usertype.trim() == "") {
        callToolTip231('assignTo', 'show');
    }
    else {
        callToolTip231('assignTo', 'hide');
    }
});
$('#enggcat').on('focusout', function () {

    var usertype = $('#enggcat').val();
    if (usertype.trim() == "") {
        callToolTip231('enggcat', 'show');
    }
    else {
        callToolTip231('enggcat', 'hide');
    }
});
$('#enggassign').on('focusout', function () {

    var usertype = $('#enggassign').val();
    if (usertype.trim() == "") {
        callToolTip231('enggassign', 'show');
    }
    else {
        callToolTip231('enggassign', 'hide');
    }
});
$('#engGroup').on('focusout', function () {

    var usertype = $('#engGroup').val();
    if (usertype.trim() == "") {
        callToolTip231('engGroup', 'show');
    }
    else {
        callToolTip231('engGroup', 'hide');
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


$('#category').on('focus', function () {
    callToolTip231('category', 'destroy');
});

$('#subcat1').on('focus', function () {
    callToolTip231('subcat1', 'destroy');
});
$('#subcat2').on('focus', function () {
    callToolTip231('subcat2', 'destroy');
});
$('#AssetDiv').on('click', function () {
//	////alert("hii")
    callToolTip231('AssetDiv', 'destroy');
});
$('#requestmode').on('focus', function () {
    callToolTip231('requestmode', 'destroy');
});
$('#subjectDiv').on('focus', function () {
    callToolTip231('subjectDiv', 'destroy');
});
$('#description').on('focus', function () {
    callToolTip231('description', 'destroy');
});
$('#priority').on('focus', function () {
    callToolTip231('priority', 'destroy');
});
//$('#severity').on('focus', function () {
//    callToolTip231('severity', 'destroy');
//});
$('#assignTo').on('focus', function () {
    callToolTip231('assignTo', 'destroy');
});
$('#enggcat').on('focus', function () {
    callToolTip231('enggcat', 'destroy');
});
$('#enggassign').on('focus', function () {
    callToolTip231('enggassign', 'destroy');
});
$('#engGroup').on('focus', function () {
    callToolTip231('engGroup', 'destroy');
});

$('#assignnote').on('focus', function () {
    callToolTip231('assignnote', 'destroy');
});
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
	$("#usernamesofbehalf").empty();
	document.getElementById("Hideotherdataforbehalf").style.display = "none";
    $("#category").val("");
    $("#engGroup").val("");
    $("#priority").val("");
    $("#severity").val("");
    $("#group").val("");
    $("#requestmode").val("");
    $("#assetid").select2('val', 'All');
	  callToolTip231('AssetDiv', 'hide');
    $("#subcat1").val("");
    $("#subcat2").val("");
    $("#sub").val('').trigger('change')
        $("#assignTo").val("");
    $("#description").val("");
    $("#priority").val("");
    $("#severity").val("");
    $("#enggcat").val("");
    $("#enggassign").val("");
    $("#empPic1").val("");
   $("#assignnote").val("");
   $("#change_Assigntype").val("").trigger('change');
   $("#locationbehalfuser").val("");
   
   
   callToolTip231('priority', 'hide');
   callToolTip231('severity', 'hide');
   
   callToolTip231('assignTo', 'hide');
   callToolTip231('assignTo', 'hide');
   
   callToolTip231('assignTo', 'hide');
   callToolTip231('subcat1', 'hide');
   callToolTip231('subcat2', 'hide');
  callToolTip231('assignnote', 'hide');
    callToolTip231('category', 'hide');
    callToolTip231('group', 'hide');
    callToolTip231('requestmode', 'hide');
    callToolTip231('subjectDiv', 'hide');
    callToolTip231('description', 'hide');
//    callToolTip231('priority', 'hide');
    callToolTip231('enggcat', 'hide');
    callToolTip231('enggassign', 'hide');
    callToolTip231('behalfdiv', 'hide');
    callToolTip231('getcompanydiv', 'hide');
    callToolTip231('getlocationDiv', 'hide');
   
});

function raiseAssignTP()
{
    var form=$('form')[0];
var formData= new FormData(form);

//  ////alert("in save");

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/TPActivity/insertTPRaiseAssignTicketForBehalf";

    $.ajax({
        url: serviceUrl,
        type: 'post',
        data: formData,
        mimeType: "multipart/form-data",
        contentType: false,
        processData: false,
        cache: false,
           success: function (data) {  
//               ////alert(data);
        	   var nameArr = data.split(',');
               if (nameArr[0] === "success") {
                swal({
                    title: "Successful!",
                    html: "Ticket ID = " + nameArr[1] + "<br>   Raised & Assigned Ticket Successfully",
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

function submitbutton1001()
{
//    ////alert("in submit button");
    if(!validateForm())
    {
//        ////alert("failed");
        event.preventDefault();
    }
    else if(validateForm())
    {
//        ////alert("Passed");
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
    	else if($('#othersiteforbehalf').val()==='NA' || $('#otherdepartforbehalf').val()==='NA' || $('#othersubdepartforbehalf').val()==='NA' || $('#otherlocationforbehalf').val()==='NA'){
    		
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
    	else if ($("#severity").val()=='NotSet') {
    		swal({
                title: "Error!",
                html: "Please Change Priority as Severity is not set",
                type: "error",
                width: 300,
                height: 200,
                buttons: false,
                allowOutsideClick: false,
                
                
            })
		}
	else{
		raiseAssignTP(); 
		$("#raise-btn").attr("disabled", true);
	}       
    }
}


//CODE FOR GET OTHER DATA
function getothersdata(othername){
	 document.getElementById("Hideotherdata").style.display = "none";
	
	if(othername.length>0){
	//	////alert("inside");
	 
	
	//////alert(othername);
	//getting split for company and username
	
	const words = othername.split('~');
	//console.log(words[0]);
	var otherusername=words[0];
	var othercompany=words[2];
//	////alert(othercompany + "company");
	
	//////alert(otherusername + "otherusername ias");
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/UserActivity/Getotherinformaion";
	
	  $.ajax({
	      type: 'POST',	
	      url: serviceUrl,
	      dataType: 'json',
	     data: 'othername=' + encodeURIComponent(otherusername)
	     + '&othercompany=' + encodeURIComponent(othercompany),
	     
	      success: function(data) {  	
	      
	    	 // ////alert(data[0]["OTHEREMAIL"])
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
			//////alert("inside");
		 
			 $("#assetCheck").prop("checked", false);
			 
			   $("#assetid").select2('val', 'All');
		 $('#toggleAssetCheck').hide();
//			 document.getElementById("HideAssetdata").style.display = "none";
			 $("#HideAssetdata").hide();
		//////alert(othername);
		//getting split for company and username
		
		const words = othername.split('~');
		//console.log(words[0]);
		var otherusername=words[0];
		
//		////alert(othercompany + "company");
		//////alert(otherusername + "otherusername ias");
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
		      
		    	 // ////alert(data[0]["OTHEREMAIL"])
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




//GET USERS BELONG TO SELECTED COMPANY
//getusernamebasedoncompany
function getlocationbasedoncompany(company){
////alert(company);
	if(company.length>0){
		
		
			if(company !="3i Infotech")
				{
				////alert(company+ "inside");
//				////alert("sdfgs")
					$('#redopt').hide();
					$('#assetchecthide').hide();
					$('#HideAssetdata').hide();
					$('#Hideotherdataforbehalf').hide();
					
//					 document.getElementById("HideAssetdata").style.display = "none";
					  var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
						var serviceUrl = base_url + "/Master/getPriorityName";

					   $.ajax({

					       url :serviceUrl,
					       type : 'POST',
					       dataType: 'json',
					       data : {'companyname':company},
					   }).done(function(data) {

					       var html =" <select class='form-control' tabindex='13' id='priority' name='priority'  onchange='getSeverity(this.value)'>";
					       html=html+'<option value="">--Please Select Priority--</option>';
					       for (var i = 0; i < data.length; i++) {
					           html += '<option value="' +data[i]+ '">' + data[i]
					           + '</option>';
					       }
					       document.getElementById("priority").innerHTML=html;
					   });
				}
			else
				{		
			//	//alert("gfg")
				$('#assetchecthide').show();
				$('#redopt').show();
				
			    $('#HideAssetdata').hide();
				$('#Hideotherdataforbehalf').hide();
//				 document.getElementById("HideAssetdata").style.display = "block";
				
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
		                     //  //alert(data4[i]);
		                        html += '<option value="' + data4[i] + '">' + data4[i]
		                                + '</option>';
		                    }
		                    document.getElementById("locationbehalfuser").innerHTML = html;
		             }

		     });
		     $('#locationbehalfuser').select2({
//		       theme: 'bootstrap4'
		   	   width:'80%',
		     	tags: true,
		     	placeholder: "Select Location",
		     	
//		         allowClear: true
		     })
		
		       var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
						var serviceUrl = base_url + "/Master/getPriorityName";

					   $.ajax({

					       url :serviceUrl,
					       type : 'POST',
					       dataType: 'json',
					       data : {'companyname':company},
					   }).done(function(data) {

					       var html =" <select class='form-control' tabindex='13' id='priority' name='priority'  onchange='getSeverity(this.value)'>";
					       html=html+'<option value="">--Please Select Priority--</option>';
					       for (var i = 0; i < data.length; i++) {
					           html += '<option value="' +data[i]+ '">' + data[i]
					           + '</option>';
					       }
					       document.getElementById("priority").innerHTML=html;
					   });

		     
//////alert(/*company*/);
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/getCategoryDetailsListForsubjecmaster";

$.ajax({
    type: 'POST',
    url: serviceUrl,
    dataType: 'json',
    data:'cname='+encodeURIComponent(company),
    success: function(data2) {
//        ////alert(data2)
   	 var html = "  <option value=''> -- Please Select --</option>";
               for (var i = 0; i < data2.length; i++) {
                   html += '<option value="' + data2[i] + '">' + data2[i]
                           + '</option>';
               }
               document.getElementById("category").innerHTML = html;
               
             
        }
});


//

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
  
  
  
	
	//	////alert("hii");
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getGroupDetails";

	    $.ajax({

	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data:'compname='+ encodeURIComponent(company)
	    }).done(function (data) {
	    	data.sort()
	        var html = " <select class='form-control' tabindex='7' id='engGroup' name='engGroup'>";
	        html = html + '<option value="">--Please Select Group--</option>';
	        for (var i = 0; i < data.length; i++) {
	            html += '<option value="' + data[i] + '">' + data[i]
	                    + '</option>';
	        }

	        document.getElementById("engGroup").innerHTML = html;
	    });
});

   



	}else{
	//	////alert("hii");
		document.getElementById("Hideotherdataforbehalf").style.display = "none";
		$("#usernamesofbehalf").select2('val', 'All');
		$("#usernamesofbehalf").empty();
	}

}
function getSeverity(priority)
{
//	alert("gg"+$("#companyupdateUDassign").val())
//	alert(priority)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/TPActivity/getSeverityByPriority";
  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'html',
      data:{'priority':priority,'company':$("#scopbasedcompany").val()},
      success: function (data5) {
//    	  if(data5==null)
//    		  {
//    		  
//    		  }
    	  $("#severity").val(data5);
//      	 document.getElementById("severity").innerHTML=data5;
      }
  })
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



var l=window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/getScopeBasedCategory";
$.ajax({
    type: 'POST',
    url: serviceUrl,
    dataType: 'json',
    success: function(data2) {
   	 var html = "  <option value=''> -- Please Select --</option>";
               for (var i = 0; i < data2.length; i++) {
                   html += '<option value="' + data2[i] + '">' + data2[i]
                           + '</option>';
               }
               document.getElementById("enggcat").innerHTML = html;
        }
});
function  characterCounter()
{
//	//alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("description").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}

