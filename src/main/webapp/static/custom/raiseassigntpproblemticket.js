window.onload = function () {

//$('#requestmode').focus();

$('#sub').select2({
//  theme: 'bootstrap4'
	tags: true,
	placeholder: "Select a Subject or Enter New",
//    allowClear: true
})

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//var serviceUrl = base_url + "/TPActivity/getAllTPDetails";
var serviceUrl = base_url + "/UserActivity/getAllUserDetails";
	
$.ajax({
		type: 'POST',
        url: serviceUrl,
        dataType: 'json'
    }).done(function (data) {

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

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/Master/getProblemCategoryDetailsList";
	var serviceUrl = base_url + "/Master/getCategoryDetails";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',	
    }).done(function (data) {
//         alert(data)

    	var html =" <select class='form-control' tabindex='7' id='category' name='category' onchange='JavaScript:change_subcat1(this.value)'>";
        html=html+'<option value="">--Please Select Category--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("category").innerHTML = html;
    });
    
    
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

    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCategoryDetails";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
    }).done(function (data) {

        var html = " <select class='form-control' tabindex='7' id='enggcat' name='enggcat' onchange='JavaScript:change_enggsubtype(this.value)'>";
        html = html + '<option value="">--Please Select Category--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("enggcat").innerHTML = html;
    });
    

    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getPriorityName";
 
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

        document.getElementById("priority").innerHTML=html;
    });

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/Master/getCategoryDetails";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',	
    }).done(function (data) {
//alert(data)
        var html = " <select class='form-control' tabindex='7' id='category' name='category' onchange='JavaScript:change_subtype(this.value)'>";
        html = html + '<option value="all">All</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("categoryModal").innerHTML = html;
    });
    
    var table = $('#Listing_Copy').DataTable({
    	dom:"<'row'<'col-sm-3'B><'col-sm-9'f>>rtip", 
    	lengthChange: false,
        pageLength: 5,
//        data: null,
        destroy: true,
        scrollX: true,
       
                
        columnDefs: [ {
            orderable: false,
            className: 'select-checkbox',
            targets:   0,
           
	        },
	        {
	        	targets:6,
	        	width:'300px',
	        }
	        ],
        select: {
            style:    'multi',
            selector: 'td:first-child'
        },
        buttons: [
        	{
                text: 'Add',
                className:'btn btn-secondary btn-sm',
                action: function ( e, dt, node, config ) {
                    loadIncidents();
                },
                init : function(api,node,config) {
//    				$(node).removeClass('dt-buttons')
    				$(node).removeClass('btn-default')
//    				 $(node).addClass('btn-danger')
    			}
            },
            {
                text: 'Remove',
                className:'btn btn-secondary btn-sm ml-2',
                action: function ( e, dt, node, config ) {
                	var rows = $('#Listing_Copy').DataTable().rows( '.selected' ).remove().draw();
                	table.button( 1 ).disable();
                },
                init : function(api,node,config) {
    				$(node).removeClass('btn-default')
    			},
                enabled: false
            },
         ]
    });
    table.on( 'select deselect', function () {
        var selectedRows = table.rows( { selected: true } ).count();
        table.button( 1 ).enable( selectedRows > 0 );
    });
};
////////////////// ONLOAD ENDS /////////////

function change_subcat1(Category)
{
	
	//alert("comap[ny name is  ");
	//alert($("#compname").val());
//	alert(ProblemCategory)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getINCSubCategory1Name";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        data: 'Category=' + encodeURIComponent(Category)
        + '&companyname=' + encodeURIComponent($("#compname").val()),
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
	
//	alert($("#compname").val());
//	alert("category: "+$('#category').val());
//	alert("subcat1: "+subcat1)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getINCSubCategory2Name";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        data: 'subcat1name=' + encodeURIComponent(subcat1)
        + '&Category=' + encodeURIComponent($("#category").val())
        + "&companyname=" + encodeURIComponent($('#compname').val()),
        dataType: 'json',
    }).done(function (data) {
//    	alert(data)
        var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2'>";
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
//	alert("category: "+$('#category').val());
//	alert("subcat1: "+$('#subcat1').val());
//	alert("subcat2: "+subcat2);
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getINCPriorityAndSeverityName";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        data: 'subcat2name=' + encodeURIComponent(subcat2)
        + '&Category=' + encodeURIComponent($("#category").val())
         + "&companyname=" + encodeURIComponent($('#compname').val())
        + '&subcat1name=' + encodeURIComponent($("#subcat1").val()),
        dataType: 'json',
    }).done(function (data) {
    	
    	var PRIORITY = data[0]["PRIORITY"];
    	var SEVERITY = data[0]["SEVERITY"];
//    	alert(PRIORITY)
//    	alert(SEVERITY)
//        var html = " <select class='form-control' tabindex='7' id='subcat2' name='subcat2'>";
//        html = html + '<option value="">--Please Select Sub-Category2--</option>';
//        for (var i = 0; i < data.length; i++) {
//            html += '<option value="' + data[i] + '">' + data[i]
//                    + '</option>';
//        }

    	$("#priority").val(PRIORITY);
    	$("#severity").val(SEVERITY);
//        document.getElementById("priority").innerHTML = html;
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
         + '&company=' + encodeURIComponent($("#compname").val()),
        success: function(data2) {
      //      alert(data2);
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
//	alert(assignType)
	
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
		
	    var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getGroupDetails";

	    $.ajax({

	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data:'compname='+encodeURIComponent($("#compname").val())	
	    }).done(function (data) {

	        var html = " <select class='form-control' tabindex='7' id='engGroup' name='engGroup'>";
	        html = html + '<option value="">--Please Select Group--</option>';
	        for (var i = 0; i < data.length; i++) {
	            html += '<option value="' + data[i] + '">' + data[i]
	                    + '</option>';
	        }

	        document.getElementById("engGroup").innerHTML = html;
	    });
	    
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
	
//    var getUsername = 'getSubCategoryEnggName';
    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: 'categ=' + encodeURIComponent(category)
        + '&Company=' + encodeURIComponent($("#compname").val())
        + '&Branch=' + encodeURIComponent($("#site").val())
        + '&Department=' + encodeURIComponent($("#department").val()),
        
    }).done(function (data) {

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
	if (fieldName === "requestmode") {
        var errorMessage = "<span>Please Select Request Mode<span>";
    }
//    else if (fieldName === "priority") {      
//        var errorMessage = "<span>Please Select Priority<span>";
//    }
    else if (fieldName === "category") {
        var errorMessage = "<span>Please Select Category<span>";
    }
    else if (fieldName === "subcat1") {
        var errorMessage = "<span>Please Select Sub-Category1<span>";
    }
    else if (fieldName === "subcat2") {
        var errorMessage = "<span>Please Select Sub-Category2<span>";
    }
    else if (fieldName === "SubDiv") {
        var errorMessage = "<span>Please Enter Problem Statement<span>";
    }
    else if (fieldName === "description") {
        var errorMessage = "<span>Please Enter Description<span>";
    }
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
    else if (fieldName === "SLAType") {
        var errorMessage = "<span>Please Select SLA Type<span>";
    }
    else if (fieldName === "TotalStandardDurationDiv") {
        var errorMessage = "<span>Please Enter Total Duration<span>";
    }
    else if (fieldName === "RCADurationDiv") {
        var errorMessage = "<span>Please Enter RCA Duration<span>";
    }
    else if (fieldName === "FixDurationDiv") {
        var errorMessage = "<span>Please Enter Fix Duration<span>";
    }
    else if (fieldName === "TotalAdvancedDurationDiv") {
        var errorMessage = "<span>Please Enter Total Duration<span>";
    }
//	else if (fieldName === "empPic1") {
//        var errorMessage = "<span>File size should be > 1KB<span>";
//    }


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

// var indexError12 = 0;
//$('#empPic1').on('change',function(){
//	alert("empic")
// indexError12 =12;
//    })

function validateForm()
{
      var indexError = 0;
   
      if ($('#requestmode').val().trim() === '') {
          callToolTip231('requestmode', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
//      if ($('#priority').val().trim() === '') {
//          callToolTip231('priority', 'show');
//
//          if (indexError == 0) {
//
//          }
//          indexError = indexError + 1;
//      }
      if ($('#category').val().trim() === '') {
          callToolTip231('category', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
      if ($('#subcat1').val().trim() === '') {
          callToolTip231('subcat1', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }	
  	    if ($('#subcat2').val().trim() === '') {
          callToolTip231('subcat2', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
      if ($('#sub').val()=== ''||$('#sub').val()==null ) {
          callToolTip231('SubDiv', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
      if ($('#description').val().trim() === '') {
          callToolTip231('description', 'show');

          if (indexError == 0) {

          }
          indexError = indexError + 1;
      }
   
       if ($('#assignTo').val().trim() === '') {
//         console.log('fill enggcat');
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
       
       ////////////////// FOR SLA ///////////
       if($('#SLACheck').is(":checked")){

    	   if($('#SLAType').val()===""){
    		   callToolTip231('SLAType', 'show');
    		   if (indexError == 0) {}
    	       indexError = indexError + 1;
    	   }else{
    		   callToolTip231('SLAType', 'hide');
    		   if($('#SLAType').val()==="Standard"){
    			   callToolTip231('RCADurationDiv', 'hide');
				   callToolTip231('FixDurationDiv', 'hide');
				   callToolTip231('TotalAdvancedDurationDiv', 'hide');
				   
    			   if($('#TotalStandardDuration-label').text()==="0"){
    				   callToolTip231('TotalStandardDurationDiv', 'show');
    				   if (indexError == 0) {}
    	    	       indexError = indexError + 1;
    			   }
    		   } 
    		   else if($('#SLAType').val()==="Advanced"){
    			   callToolTip231('TotalStandardDurationDiv', 'hide');
    			   if($('#RCADuration-label').text()==="0"){
    				   callToolTip231('RCADurationDiv', 'show');
    	    		   if (indexError == 0) {}
    	    	       indexError = indexError + 1;
    			   }
    			   if($('#FixDuration-label').text()==="0"){
    				   callToolTip231('FixDurationDiv', 'show');
    	    		   if (indexError == 0) {}
    	    	       indexError = indexError + 1;
    			   }
    			   if($('#TotalAdvancedDuration-label').text()==="0"){
    				   callToolTip231('TotalAdvancedDurationDiv', 'show');
    	    		   if (indexError == 0) {}
    	    	       indexError = indexError + 1;
    			   }
    			   var totalTime=parseInt($('#TotalAdvancedDuration-label').text());
    			   var RCATime=parseInt($('#RCADuration-label').text());
    			   var FixTime=parseInt($('#FixDuration-label').text());
    			  
    			   var RCAFixTime=RCATime+FixTime;
//    			   alert("total time: "+totalTime+" RCATime: "+RCATime+" FixTime: "+FixTime+" RCAFixTime: "+RCAFixTime)
    			   if(totalTime<RCAFixTime){
    	    	       indexError = indexError + 1;
    				   swal({
    	                    title: "Warning!",
    	                    html: "Total Duration is Less than RCA & Fix Duration",
    	                    type: "warning",
    	                    width: 300,
    	                    height: 200,
    	                    buttons: false,
    	                    allowOutsideClick: false,
    	                })
    			   }
    		   }
    	   }
       }
       
   

    
   console.log("validation error count::::"+indexError);
 if (indexError != 0) {

//    alert("false");
        return false;

    } else {

//        $('#spinner2').show();
//    alert("true");
        return true;
    }

}

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
//focus out
$('#ProblemCategory').on('focusout', function () {

    var usertype = $('#ProblemCategory').val();
    if (usertype.trim() == "") {
        callToolTip231('ProblemCategory', 'show');
    }
    else {
        callToolTip231('ProblemCategory', 'hide');
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
$('#SubDiv').on('focusout', function () {

    var usertype = $('#sub').val();
    if (usertype.trim() == "") {
        callToolTip231('SubDiv', 'show');
    }
    else {
        callToolTip231('SubDiv', 'hide');
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
//focus out
$('#SLAType').on('focusout', function () {

    var usertype = $('#SLAType').val();
    if (usertype.trim() == "") {
        callToolTip231('SLAType', 'show');
    }
    else {
        callToolTip231('SLAType', 'hide');
    }
});

//////////// On Focus ////////////
$('#requestmode').on('focus', function () {
    callToolTip231('requestmode', 'destroy');
});
//$('#priority').on('focus', function () {
//    callToolTip231('priority', 'destroy');
//});
$('#category').on('focus', function () {
    callToolTip231('category', 'destroy');
});
$('#subcat1').on('focus', function () {
    callToolTip231('subcat1', 'destroy');
});
$('#subcat2').on('focus', function () {
    callToolTip231('subcat2', 'destroy');
});
$('#SubDiv').on('focus', function () {
    callToolTip231('SubDiv', 'destroy');
});
$('#description').on('focus', function () {
    callToolTip231('description', 'destroy');
});
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
$('#SLAType').on('focus', function () {
    callToolTip231('SLAType', 'destroy');
});
$('#TotalStandardDurationDiv').on('click', function () {
	if($('#TotalStandardDuration-label').text()!=="0"){
		callToolTip231('TotalStandardDurationDiv', 'destroy');
	}else{
		callToolTip231('TotalStandardDurationDiv', 'show');
	}
});
$('#RCADurationDiv').on('click', function () {
	if($('#RCADuration-label').text()!=="0"){
		callToolTip231('RCADurationDiv', 'destroy');
	}else{
		callToolTip231('RCADurationDiv', 'show');
	}
});
$('#FixDurationDiv').on('click', function () {
	if($('#FixDuration-label').text()!=="0"){
		callToolTip231('FixDurationDiv', 'destroy');
	}else{
		callToolTip231('FixDurationDiv', 'show');
	}
});
$('#TotalAdvancedDurationDiv').on('click', function () {
	if($('#TotalAdvancedDuration-label').text()!=="0"){
		callToolTip231('TotalAdvancedDurationDiv', 'destroy');
	}else{
		callToolTip231('TotalAdvancedDurationDiv', 'show');
	}
});


$("#resetbtn").click(function() {
    $("#requestmode").val("");
    $("#priority").val("");
    $("#category").val("");
    $("#subcat1").val("");
    $("#subcat2").val("");
    $("#sub").val("");
    $("#description").val("");
    $("#assignTo").val("");
    $("#enggcat").val("");
    $("#enggassign").val("");
    $("#engGroup").val("");
    $("#raiseAssignFilePic").val("");
    
    $("#SLACheck").prop("checked", false);
    $("#SLAType").val("");
    $("#toggleSLAType").hide();
    $('#TotalStandardDuration').data('durationPicker').setValue(0);
	  $('#RCADuration').data('durationPicker').setValue(0);
	  $('#FixDuration').data('durationPicker').setValue(0);
	  $('#TotalAdvancedDuration').data('durationPicker').setValue(0);
	  $("#toggleStandardSLA").hide(); 
	  $("#toggleAdvancedSLA").hide();
	  
	 callToolTip231('requestmode', 'hide');
    callToolTip231('priority', 'hide');
    callToolTip231('category', 'hide');
    callToolTip231('subcat1', 'hide');
    callToolTip231('subcat2', 'hide');
    callToolTip231('sub', 'hide');
    callToolTip231('description', 'hide');
    callToolTip231('assignTo', 'hide');
    callToolTip231('enggcat', 'hide');
    callToolTip231('enggassign', 'hide');
    callToolTip231('engGroup', 'hide');
    
    callToolTip231('SLAType', 'hide');
    callToolTip231('RCADurationDiv', 'hide');
	  callToolTip231('FixDurationDiv', 'hide');
	  callToolTip231('TotalAdvancedDurationDiv', 'hide');
	  callToolTip231('TotalStandardDurationDiv', 'hide');
   
});

function raiseAssignProblemTP()
{
//	alert("in save");
    var form=$('form')[0];
    var formData= new FormData(form);

	var data = $('#Listing_Copy').DataTable().rows().data().toArray();
	var TotalIncidentsAttached = new Array();
	for(var i=0;i<data.length;i++)
		{
		TotalIncidentsAttached.push(data[i][2]);
		}
//	alert("totalIncidents: "+TotalIncidentsAttached);

	formData.append('TotalIncidentsAttached', JSON.stringify(TotalIncidentsAttached));

	var SLACheckStatus=$('#SLACheck').is(':checked');
//	alert(SLACheckStatus)
	formData.append('TotalStandardDuration', $('#TotalStandardDuration-label').text());
	formData.append('RCADuration', $('#RCADuration-label').text());
	formData.append('FixDuration', $('#FixDuration-label').text());
	formData.append('TotalAdvancedDuration', $('#TotalAdvancedDuration-label').text());
	formData.append('SLACheckStatus', SLACheckStatus);

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/TPActivity/insertTPRaiseAssignProblemTicket";

    $.ajax({
        url: serviceUrl,
        type: 'post',
        data: formData,
        mimeType: "multipart/form-data",
        contentType: false,
        processData: false,
        cache: false,
           success: function (data) {  
//               alert(data);
        	   var nameArr = data.split(',');
               if (nameArr[0] === "success") {
                swal({
                    title: "Successful!",
                    html: "Problem Ticket ID = " + nameArr[1] + "<br>Raised & Assigned Successfully",
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
               }else{
            	   swal({
                       title: "Failed!",
                       html: "Unable to Raised & Assign Ticket",
                       type: "error",
                       width: 300,
                       height: 200,
//                     showCancelButton: false,
//                     confirmButtonClass: "btn btn-danger",
//                     cancelButtonClass: "btn btn-danger m-l-10",
//                     confirmButtonText: "OK",
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
//

function submitbutton1001()
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
    	
    	
    	
    	
if($('#site').val()==='NA' || $('#department').val()==='NA' || $('#sub_department').val()==='NA' || $('#location').val()==='NA'){
    		
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
	else{
		  raiseAssignProblemTP(); 
	    	$("#raise-btn").attr("disabled", true);
	}
    	
     
    }
}

function loadIncidents()
{
$('#Listing_Copy_Tickets').DataTable({
	lengthChange: false,
    pageLength: 5,
    destroy: true,
    scrollX: true,
});
var fromDate;
var toDate;
    $('#daterange-btn').daterangepicker(
      {
        ranges   : {
          'Today'       : [moment(), moment()],
          'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
          'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
          'Last 30 Days': [moment().subtract(29, 'days'), moment()],
          'This Month'  : [moment().startOf('month'), moment().endOf('month')],
          'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
//        startDate: moment().subtract(29, 'days'),
        startDate: moment(),
        endDate  : moment(),
        autoUpdateInput: false,
        locale: {
            cancelLabel: 'Clear'
        }
      },
      function (start, end) {
        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
        fromDate=start.format('DD-MM-YYYY HH:mm:ss');
        toDate=end.format('DD-MM-YYYY HH:mm:ss');
//        alert("From Date: "+fromDate);
//        alert("To Date: "+toDate);
        
        var category = $("#categoryModal").val();

        var l = window.location;
      	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
      	var serviceUrl = base_url + "/TPActivity/GetIncidentTicketList";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            data: 'FromDate=' + fromDate
                    + "&ToDate=" + toDate
                    + "&category=" + encodeURIComponent(category),
            success: function(data) {
//            	alert(data);
//            	$('#Listing_Copy_Tickets').DataTable().clear();
            	
            	var table = $('#Listing_Copy_Tickets').DataTable({
        	    	dom:"<'row'<'col-sm-3 DateToolbar'><'col-sm-9'f>>rtip", 
        	    	lengthChange: false,
        	        pageLength: 5,
        	        data: data,
        	        destroy: true,
        	        scrollX: true,
//        	        responsive: true,
//        	        autoWidth: false,
        
        	        columnDefs: [{
        	        	targets: 0,
        	            orderable: false,
        	            className: 'select-checkbox',
        	            },
        	            {
        	            	targets:6,
        	            	width:'300px',
        	            }
        	            ],
        	            
        	              

        	        select: {
        	            style:    'multi',
        	            selector: 'td:first-child'
        	        },
//        	        order: [[ 1, 'asc' ]]
        	    });
            	 $("div.DateToolbar").html('<b>From Date: </b>'+fromDate+'<br><b>To Date: </b>'+toDate);
//            	 table.columns.adjust().draw();

            	
            }
        });
        
      }
    )
	
	
	
	 
	 $("#modelviewtickets").modal("show");
	
}
$('#modelviewtickets').on('hidden.bs.modal', function () {

	$('#Listing_Copy_Tickets').DataTable().clear().draw();
    $('#Listing_Copy_Tickets').DataTable().destroy();
	
});

function viewTicket(id)
{
	event.preventDefault();
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/UserActivity/gatherUserTicketDetails";
        
           $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(id),

        success: function (data) {
           
            var T_REQUESTER = data[0]["T_REQUESTER"];
            var T_COMPANY = data[0]["T_COMPANY"];
            var T_BRANCH = data[0]["T_BRANCH"];
            var DEPARTMENT = data[0]["DEPARTMENT"];
            var SUB_DEPARTMENT = data[0]["SUB_DEPARTMENT"];
            var LOCATION = data[0]["LOCATION"];
            var T_PHONE = data[0]["T_PHONE"];
            var T_MAIL = data[0]["T_MAIL"];
            var T_CATEGORY = data[0]["T_CATEGORY"];
            var T_SUBCAT1 = data[0]["T_SUBCAT1"];
            var T_SUBCAT2 = data[0]["T_SUBCAT2"];
            var T_SUBJECT = data[0]["T_SUBJECT"];
            var T_DATE = data[0]["T_DATE"];
            var STATUS = data[0]["STATUS"];
            var T_ID = data[0]["T_ID"];
            var T_DESC = data[0]["T_DESC"];
            var PRIORITY = data[0]["PRIORITY"];
            var SEVERITY = data[0]["SEVERITY"];
            var REQUEST_MODE = data[0]["REQUEST_MODE"];
             var T_ATTACH_NAME = data[0]["T_ATTACH_NAME"];
//          alert("T_ATTACH1_NAME: "+T_ATTACH1_NAME);



            $("#nameupdateUD").val(T_REQUESTER);
            $("#companyupdateUD").val(T_COMPANY);
            $("#siteupdateUD").val(T_BRANCH);
            $("#deptupdateUD").val(DEPARTMENT);
            $("#subdeptupdateUD").val(SUB_DEPARTMENT);
            $("#locationupdateUD").val(LOCATION);
            $("#phoneupdateUD").val(T_PHONE);
            $("#emailupdateUD").val(T_MAIL);
            $("#categoryupdateTD").val(T_CATEGORY);
            $("#subcat1updateTD").val(T_SUBCAT1);
            $("#subcat2updateTD").val(T_SUBCAT2);
            $("#subjectupdateTD").val(T_SUBJECT);
            $("#raisedateupdateTD").val(T_DATE);
            $("#statusupdateTD").val(STATUS);
            $("#ticketidupdateTD").val(T_ID);
            $("#descriptionupdateTD").val(T_DESC);
            $("#priorityupdateTD").val(PRIORITY);
          //  alert(SEVERITY + "SEVERITY");
            $("#severityupdateTD").val(SEVERITY);
            $("#RequestModeupdateTD").val(REQUEST_MODE);
            
if((T_ATTACH_NAME=== ("No File Available"))||(T_ATTACH_NAME===("NA"))||(T_ATTACH_NAME===("null"))||(T_ATTACH_NAME===("undefined"))||(T_ATTACH_NAME===("")))
       {
          $('#hidedownload').hide();
          $('#nofileattach').show();
       }else
       {
           $('#hidedownload').show();
             $('#nofileattach').hide();
         document.getElementById('empPic').innerHTML=T_ATTACH_NAME;
         document.getElementById('filename').value=T_ATTACH_NAME;  
       }
      
        }
    });
             $("#modelview").modal("show");
        }
        
$('#modelview').on('hidden.bs.modal', function () {
	$('a[role="tab"]').removeClass('active'); 
    $('a[role="tabpanel"]').removeClass('active show');
    $('#custom-tabs-four-home-tab').addClass('active');
    
    $('#custom-tabs-four-home').removeClass('active show');
    $('#custom-tabs-four-profile').removeClass('active show');
    $('#custom-tabs-four-home').addClass('active show');
});
$('#close-btn').on("click", function () {
	$("#modelview").modal("hide");
	$('a[role="tab"]').removeClass('active'); 
    $('a[role="tabpanel"]').removeClass('active show');
    $('#custom-tabs-four-home-tab').addClass('active');
    
    $('#custom-tabs-four-home').removeClass('active show');
    $('#custom-tabs-four-profile').removeClass('active show');
    $('#custom-tabs-four-home').addClass('active show');
});

function downFile()
      {
	var filename = $('#filename').val();
//	alert(filename)
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	window.location = base_url + "/Master/DownloadFile?filename=" + encodeURIComponent(filename);
       }

function downFileActivityLog(att) {
//	alert(att)
//		var filename = $('#filename').val();
		var filename =att;
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location = base_url + "/Master/DownloadFile?filename=" + filename;
	}

//////////////////// GET ACTIVITY LOG ////////////////
$('a[role="tab"]').on('shown.bs.tab', function (e) {
	  var target = $(e.target).attr("id") // activated tab
	  if(target==="custom-tabs-four-profile-tab"){
		  ticketid= $("#ticketidupdateTD").val();
		  
		  var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/UserActivity/getTicketActivityLog";
    
    $.ajax({
        url: serviceUrl,
        type: 'post',
       dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(ticketid),

        success: function(data) {
//        	alert(data[0]["CHANGE_NOTES2"]);
            var T_ID = data[0]["T_ID"];
            var TIMESTAMP = data[0]["TIMESTAMP"];
            var CHANGEBY = data[0]["CHANGEBY"];
            var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
            var STATUS = data[0]["STATUS"];
            var PRIORITY = data[0]["PRIORITY"];
            var CHANGE_NOTES1 = data[0]["CHANGE_NOTES1"];
            var CHANGE_NOTES2 = data[0]["CHANGE_NOTES2"];
            var ROLE_TYPE = data[0]["ROLE_TYPE"];
            var CATEGORY=data[0]["CATEGORY"];
            var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
            var SUBCATEGORY2=data[0]["SUBCATEGORY2"];
            var EMAIL=data[0]["FULLNAME"];
            var FULLNAME=data[0]["EMAIL"];
            

           document.getElementById('T_ID').innerHTML=T_ID;
          
           
           var attachment="";
           var att;
           var statusColor;
           var notes1;
           var notes2;
           var html ="";
           for(var i=0;i<data.length;i++)
        	   {
        	   
        	   
        	   //////////////// CODE FOR ATTACHMENT////////////
        	   if(data[i]["ATTACHMENT_NAME"]==undefined || data[i]["ATTACHMENT_NAME"]=="No File Available" || data[i]["ATTACHMENT_NAME"]=="" || data[i]["ATTACHMENT_NAME"]==" " || data[i]["ATTACHMENT_NAME"]==null)
      		 {
      		 attachment="No File Attached";
      		 }
      	 else{
      		 att=data[i]["ATTACHMENT_NAME"];
      		 attachment="<i class='nav-icon fas fa-download' onclick=downFileActivityLog('"+encodeURIComponent(att)+"')></i>";
      	 }
        	   ////////////////CODE FOR COLOUR////////////
        	   statusColor=data[i]["STATUS"];
//        	   alert(statusColor);
        	   var callOutColor="";
        	   if(statusColor=="New"){callOutColor="callout-info"}
           	   else if(statusColor=="Assigned" ){callOutColor="callout-warning"}
           	   else if(statusColor=="Re-Assigned" || statusColor=="Reopened"){callOutColor="callout-danger"}
            	  
           	   else if(statusColor=="Hold"){callOutColor="callout-danger"}
           	   else if(statusColor=="Resolved"){callOutColor="callout-success"}
           	   else if(statusColor=="Closed"){callOutColor="callout-success"}
           	   else if(statusColor=="Rejected"){callOutColor="callout-danger"}
           	   else if(statusColor=="Update Rejected"){callOutColor="callout-danger"}
           	   else if(statusColor=="Pending"){callOutColor="callout-warning"}
           	   else if(statusColor=="Update Approved"){callOutColor="callout-success"}
        	   
        	   /////////////// CODE FOR NOTES ///////////////
        	   if(data[i]["CHANGE_NOTES1"]==undefined || data[i]["CHANGE_NOTES1"]=="" || data[i]["CHANGE_NOTES1"]==" " || data[i]["CHANGE_NOTES1"]==null)
        		 {
        		   notes1="";
        		 }
        	 else{
        		 notes1="<textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["CHANGE_NOTES1"]+"</textarea>";
        	 }
        	   
        	   ////////////////CODE TO APPEND////////////
        	   html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type : <span>"+data[i]["ROLE_TYPE"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Priority : <span>"+data[i]["PRIORITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Severity : <span>"+data[i]["SEVERITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Category : <span>"+data[i]["CATEGORY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category1 : <span>"+data[i]["SUB_CATEGORY1"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category2 : <span>"+data[i]["SUBCATEGORY2"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Full Name: <span>"+data[i]["FULLNAME"]+"</span></span></div></div><div class='row'><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Email : <span>"+data[i]["EMAIL"]+"</span></span></div></div><br><div class='row'><div class='col-md-12'>"+notes1+"</div></div></div>";
        	   
              document.getElementById("MSG1234").innerHTML=html;
        	   }
           html=+ '<br>';
            }
          
            
    });
	  }
	});

$("#selection-btn").click(function(){
	var rowData = $('#Listing_Copy_Tickets').DataTable().rows( { selected: true } ).data().toArray();
	console.log(rowData);
//	alert(rowData.length);
	for(var i=0;i<rowData.length;i++)
	{
//		alert(rowData[i][2])
		$('#Listing_Copy').DataTable().row.add(rowData[i]).draw();
	
	}
	$("#modelviewtickets").modal("hide");
  });

//function removeSelectedRowData()
//{
//
//	var rows = $('#Listing_Copy').DataTable().rows( '.selected' ).remove().draw();
//
//}

  ///////////////// FOR SLA /////////////
  $('#TotalStandardDuration').durationPicker({
	    onChanged: function (newVal) {
	      $('#TotalStandardDuration-label').text(newVal);
	    }
	  });
  $('#RCADuration').durationPicker({
	    onChanged: function (newVal) {
	      $('#RCADuration-label').text(newVal);
	    }
	  });
  $('#FixDuration').durationPicker({
	    onChanged: function (newVal) {
	      $('#FixDuration-label').text(newVal);
	    }
	  });
  $('#TotalAdvancedDuration').durationPicker({
	    onChanged: function (newVal) {
	      $('#TotalAdvancedDuration-label').text(newVal);
	    }
	  });
//  $('#reset-picker').click(function () {
//	    $('#duration6').data('durationPicker').setValue(0);
//	  });
	  
  
  $('#SLACheck').click(function() {
	    $("#toggleSLAType").toggle(this.checked);
	    if(this.checked===false){
	    	$("#SLAType").val("");
	    	callToolTip231('SLAType', 'hide');
	    	 $('#TotalStandardDuration').data('durationPicker').setValue(0);
	   	  $('#RCADuration').data('durationPicker').setValue(0);
	   	  $('#FixDuration').data('durationPicker').setValue(0);
	   	  $('#TotalAdvancedDuration').data('durationPicker').setValue(0);
	   	callToolTip231('RCADurationDiv', 'hide');
	   	callToolTip231('FixDurationDiv', 'hide');
	   	callToolTip231('TotalAdvancedDurationDiv', 'hide');
	   	callToolTip231('TotalStandardDurationDiv', 'hide');
	   	$("#toggleStandardSLA").hide(); 
		  $("#toggleAdvancedSLA").hide();
	    }
	   
	});

  function toggleSLASelection(selectedValue){
//	  alert(selectedValue)
	  $('#TotalStandardDuration').data('durationPicker').setValue(0);
	  $('#RCADuration').data('durationPicker').setValue(0);
	  $('#FixDuration').data('durationPicker').setValue(0);
	  $('#TotalAdvancedDuration').data('durationPicker').setValue(0);
	  callToolTip231('RCADurationDiv', 'hide');
	  callToolTip231('FixDurationDiv', 'hide');
	  callToolTip231('TotalAdvancedDurationDiv', 'hide');
	  callToolTip231('TotalStandardDurationDiv', 'hide');
	  
	  if(selectedValue==="Standard"){
		  $("#toggleStandardSLA").show();
		  $("#toggleAdvancedSLA").hide();
		  }
	  else if(selectedValue==="Advanced"){
		  $("#toggleStandardSLA").hide();
		  $("#toggleAdvancedSLA").show();
	  }
	  else{
		  $("#toggleStandardSLA").hide(); 
		  $("#toggleAdvancedSLA").hide();
		 
	  }
  }
  
  
  
//CODE FOR GET OTHER DATA
  function getothersdata(othername){
  	 document.getElementById("Hideotherdata").style.display = "none";
  	
  	if(othername.length>0){
  	//	alert("inside");
  	 
  	
  	//alert(othername);
  	//getting split for company and username
  	
  	const words = othername.split('~');
  	//console.log(words[0]);
  	var otherusername=words[0];
  	var othercompany=words[2];
//  	alert(othercompany + "company");
  	//alert(otherusername + "otherusername ias");
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

  function  characterCounter()
  {
//  	alert("sdffsffd")
  		
  	$("#counterSpan").show();
  	
  	  var i = document.getElementById("description").value.length;
  	  document.getElementById("calulateId").innerHTML = 2000 - i; 
  	  if(i<=0)
  	  {
      	  $("#calulateId").val("");
  	  };
  }

  
  