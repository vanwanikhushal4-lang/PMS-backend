window.onload = function() {
	 $("#chechboxid").hide();
//    $("#priority2").hide()
//      $("#Severity2").hide()
//        $("#SLA").hide()
//          $("#category2").hide()
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
                   var html = "";
                   for (var i = 0; i < data4.length; i++) {
                       html += '<option value="' + data4[i] + '">' + data4[i]
                               + '</option>';
                   }

                   document.getElementById("companyName").innerHTML = html;
            }
    });
    
  $('#companyName[multiple]').multiselect({
    includeSelectAllOption: true,
    nonSelectedText: 'Select Companies',
    buttonWidth: '100%',
    maxHeight:200
  });
  
 // GET TEMPLATE DETAILS

}

var attribute1=0;
//onchange function of attribute
function selectedAttribute(attribute)
{
	
	  $("#forhidemodel").show();
	
	attribute1=1;
	
	if(attribute =="")
		{
		
		//alert("in inner if  ");
		attribute1=0;
		  callToolTip231('templatesContainer', 'destroy');
		  callToolTip231('templatesContainer', 'hide');
		}

	 $("#card2").hide();
	// $("#dynamiccheck").hide();
	 //alert("in iff "+attribute );
	 if(attribute !== "Category_SubCategory"){
		// alert("in iff ");
	 $("#chechboxid").hide();
	 }
	 
	var count=0;

//	 $('#templatesContainer').append("");
	 document.getElementById("templatesContainer").innerHTML = "";
	 document.getElementById("templatesContainercategory").innerHTML = "";
	 
// var 	template=null;
   var templateName=null;
	//alert("iam in onchage");
	//alert(attribute);
	//location.reload();
	
	
	
	  var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/Master/getTemplateDetails";
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        data: 'attribute=' + attribute,
	        dataType: 'json',
	        async: false,
	        
	        success: function(data) {
	        var templates = new Array();
	        var html="";
	        var html2="";
	        var html3="";
	    for (var i = 0; i < data.length; i++) {

	    

	       if(attribute != 'Category_SubCategory' )
	       {

	       html += '<div class="col-md-4"><div class="card"><div class="card-header"><span><input type="radio"  id="addTemplate" name="addTemplate" value='+data[i]["Value"]+'><b> Template Name: </b>'+data[i]["attribute"]+' <div class="card-body"> <p class="text"><b>Template Values: </b>'+data[i]["Value"]+'</p></div></span></div></div></div>';
			//alert(attribute);
	       document.getElementById("templatesContainer").innerHTML=html;
	       }
	       else	
	       {

	    	  
	    	   
	    	   html2 += '<div> <b>Category : </b>'+data[i]["category"]+' <b  class="ml-3">Subcategory1: </b>'+data[i]["subcategory1"]+'<b  class="ml-3">Subcategory2: </b>'+data[i]["subcategory2"]+' <b  class="ml-3">Priority: </b>'+data[i]["Priority"]+' <b  class="ml-3">Severity: </b>'+data[i]["Severity"]+'</div>';
	    	//   html3+='<input type="checkbox" class="btn-check" id="btn-check-2" checked autocomplete="off"><label class="btn btn-primary" for="btn-check-2">Checked</label>';
//	    	   alert(html2);
	    	 
//	    	   document.getElementById("templatesContainercategory").innerHTML=html2;
				
	       }
	    
	       if(attribute === 'Category_SubCategory' ){
	    	  // alert(html2);
	    	//   alert(html3);
	    	   $("#card2").show();
	    	   $("#chechboxid").show();
	    	   document.getElementById("templatesContainercategory").innerHTML=html2;
	    	//   document.getElementById("dynamiccheck").innerHTML=html3;
	    	   
	       }
	       else
	    	   {
	       
	    	   }
	  }

	  }
	    });
	
}

var callToolTip231 = function(fieldName, status) {

  if (fieldName == 'companyvalidation') {
    var errorMessage = "<span>Please Select Company<span>";
  } else if (fieldName == 'templatesContainer') {
    var errorMessage = "<span>Please Select any one  Template<span>";
  }
  else if (fieldName == 'Attributename') {
	    var errorMessage = "<span>Please Select  Attribute<span>";
	  }
  else if (fieldName == 'chackboxlabel') {
	    var errorMessage = "<span>Please chack  chechbox <span>";
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

$("#submit-btn").click(function() {
	
	var templatevalue=$("input[type='radio'][name='addTemplate']:checked").val();

	var attributename=  $("#Attributename :selected").val();
	

  var selectedValuesCompany = [];
  $("#companyName :selected").each(function() {
	  selectedValuesCompany.push($(this).val());
	 // alert(selectedValuesCompany);
  });
  if (!validateTemplate(templatevalue, selectedValuesCompany)) {
//  alert("fail")
      event.preventDefault();
  } else {
//   alert("pass")
    saveDataTemplate(templatevalue, selectedValuesCompany,attributename);
  }
}).show();

$("#resetbtn").click(function() {
  $('input[type=checkbox]').prop('checked',false);
  $('input[type=radio]').prop('checked',false);
  $("#companyName option:selected").prop("selected", false);
  $("#companyName").multiselect('refresh');
  $("#companyName").val("");
  $("#Attributename").val("");
  $("#forhidemodel").hide();
  
  
  
  if (dynamiccheck.isChecked) {
	  dynamiccheck.setChecked(false);
  }
  
  callToolTip231('companyvalidation', 'destroy');
  callToolTip231('templatesContainer', 'destroy');
  callToolTip231('Attributename', 'destroy');
  callToolTip231('chackboxlabel', 'destroy');
  
});


$('#companyName').on('focusout', function () {
	  var usertype = $('#companyName').val();

	  if (usertype.trim() == "") {
		  
	    callToolTip231('companyvalidation', 'show');
	   // alert("aaaaaaaaaaaa");
	  } else {
	      callToolTip231('companyvalidation', 'hide');
	  }
	});
//
//$('#companyName').on('focusout', function() {
//  var usertype = $('#companyName').val();
//
//  if ($('#companyName').find(":selected").text() == "") {
//      callToolTip231('companyvalidation', 'show');
//  }
//  else if ($('#companyName').val() === "")
//  {
//      callToolTip231('companyvalidation', 'show');
//  }
//  else
//	  {
//	  callToolTip231('companyvalidation', 'hide');
//	  }
//});


$('#companyvalidation').on('click', function() {
	//alert("in focus");
  callToolTip231('companyvalidation', 'destroy');
});

$('#templatesContainer').on('click', function() {
	//alert("in focus");
  callToolTip231('templatesContainer', 'destroy');
});



$('#chackboxlabel').on('click', function() {
	  callToolTip231('chackboxlabel', 'destroy');
	});

$('#Attributename').on('focus', function() {
	  callToolTip231('Attributename', 'destroy');
	});

function validateTemplate(templateValues, selectedValues) {
  var indexError = 0;
  if (!selectedValues.length) {
    callToolTip231('companyvalidation', 'show');
    if (indexError == 0) {

    }
    indexError = indexError + 1;
  }

 //alert( "value   " +	$("#Attributename").val());
  if ($("#Attributename").val() == "") {
	//  alert("INN");
	    callToolTip231('Attributename', 'show');
	    if (indexError == 0) {

	    }
	    indexError = indexError + 1;
	  }
  var checkstatus = $("#dynamiccheck").prop('checked');
  //alert(checkstatus);
//  alert( "value   " +	$("#Attributename").val());
   if (checkstatus == true || checkstatus == false && $("#Attributename").val() == 'Category_SubCategory' ){
	// alert(" iam in outer if  "+checkstatus);
	  if(checkstatus == false)
		  {
		//  alert(" iam in inner if  "+checkstatus);
		  callToolTip231('chackboxlabel', 'show');
		    if (indexError == 0) {

		    }
		    indexError = indexError + 1;
		  }
		  }

  else{
//	 var radiocheck= document.getElementById('addTemplate').checked;
//	 alert(radiocheck);
	 var l= $('input[id=addTemplate]:checked').length;
	// alert(l);
	 
	// alert("attribute value " + attribute1);
  if (l<=0 && attribute1 == 1) {
	//  alert("attribute value ", attribute1);
	    callToolTip231('templatesContainer', 'show');
	    if (indexError == 0) {

	    }
	    indexError = indexError + 1;
	  }
}
  if (indexError > 0) {
      return false;

  } else {
      return true;
  }
}

function saveDataTemplate(templateValues, selectedcompanyValues ,attributename) {
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/Master/addTemplate";
  
  $.ajax({
    type: 'POST',
    url: serviceUrl,
    data: 'companies=' + encodeURIComponent(selectedcompanyValues)
            + '&templates=' + templateValues
            + '&attributename=' + attributename
  }).done(function (data) {
    if (data == "success") {
      swal({
          title: "Successful!",
          text: "Records Added Successfully",
          type: "success",
          width: 300,
          height: 200,
//        showCancelButton: false,
//        confirmButtonClass: "btn btn-danger",
//        cancelButtonClass: "btn btn-danger m-l-10",
//        confirmButtonText: "OK",
          buttons: false,
          allowOutsideClick: false,
          preConfirm: function() {
              var l = window.location;
              var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
              window.location.href = base_url + "/Admin/TemplateMaster";
          }

      });

  }
   /* else if (data == "duplicate") {
      swal({
          title: "Duplicate Data!",
          text: "Record Already Exists",
          type: "warning",
          width: 300,
          height: 200,
//        showCancelButton: false,
//        confirmButtonClass: "btn btn-danger",
//        cancelButtonClass: "btn btn-danger m-l-10",
//        confirmButtonText: "OK",
          buttons: false,
          allowOutsideClick: false,
          preConfirm: function() {
              var l = window.location;
              var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
              window.location.href = base_url + "/Admin/TemplateMaster";
          }

      });

    }*/
    else if (data == "error") {
      swal({
   
		  title: "Failed!",
		  text : "Fail To Add File",
          type: "error",
          width:300,
          height : 200,
			showCancelButton : !0,
			confirmButtonClass : "btn btn-success",
			cancelButtonClass : "btn btn-danger m-l-10",
			confirmButtonText : "OK",
          buttons: false,
          allowOutsideClick: false,
          preConfirm: function() {
              var l = window.location;
              var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
              window.location.href = base_url + "/Admin/TemplateMaster";
          }

      });

    }
  });
}

