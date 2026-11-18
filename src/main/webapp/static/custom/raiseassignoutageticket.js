
window.onload = function () {

$('#requestmode').focus();


var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/UserActivity/getAllUserDetails";

$.ajax({

    type : 'POST',
    url :serviceUrl,
    dataType: 'json'
}).done(function(data) {
//   alert(data[0]["FULLNAME"])

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
	var serviceUrl = base_url + "/Master/getCategoryDetails";

$.ajax({

    url :serviceUrl,
    type : 'POST',
    dataType: 'json',
}).done(function(data) {

    var html =" <select class='form-control' tabindex='7' id='category' name='category' onchange='JavaScript:change_subcat1(this.value)'>";
    html=html+'<option value="">--Please Select Category--</option>';
    for (var i = 0; i < data.length; i++) {
        html += '<option value="' +data[i]+ '">' + data[i]
        + '</option>';
    }

    document.getElementById("category").innerHTML=html;
});
    
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getRequestModeName";
    
//    var getRequestModeName='getRequestModeName';  
    $.ajax({

        url :serviceUrl,
        type : 'POST',
        dataType: 'json',
    }).done(function(data) {
       // alert(data)

//        var pollingHost=data;
//        var d = pollingHost.split(",");
//        var length=d.length-1;
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
	var serviceUrl = base_url + "/Master/getGroupDetails";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
    }).done(function (data) {

        var html = " <select class='form-control' tabindex='7' id='engGroup' name='engGroup'>";
        html = html + '<option value="">--Please Select Group--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("engGroup").innerHTML = html;
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
///////////////// ONLOAD ENDS ////////////////////
function change_subcat1(Category)
{
//	alert(ProblemCategory)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getINCSubCategory1Name";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        data: 'Category=' + Category,
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
//	alert("category: "+$('#category').val());
//	alert("subcat1: "+subcat1)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getINCSubCategory2Name";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        data: 'subcat1name=' + subcat1
        + '&Category=' + $("#category").val(),
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

function change_Assigntype(assignType){
//	alert(assignType)
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
	
//    var getUsername = 'getSubCategoryEnggName';
    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: 'categ=' + category
        + '&Company=' + $("#compname").val()
        + '&Branch=' + $("#site").val()
        + '&Department=' + $("#department").val(),
        
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
    if ($('#priority').val().trim() === '') {
        console.log('fill prioprity');
        callToolTip231('priority', 'show');

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


$('#category').on('focus', function () {
    callToolTip231('category', 'destroy');
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

$("#resetbtn").click(function() {
    $("#category").val("");
    $("#group").val("");
    $("#requestmode").val("");
    $("#sub").val("");
    $("#description").val("");
    $("#priority").val("");
    $("#enggcat").val("");
    $("#enggassign").val("");
    $("#empPic1").val("");
    
    callToolTip231('category', 'hide');
    callToolTip231('group', 'hide');
    callToolTip231('requestmode', 'hide');
    callToolTip231('sub', 'hide');
    callToolTip231('description', 'hide');
    callToolTip231('priority', 'hide');
    callToolTip231('enggcat', 'hide');
    callToolTip231('enggassign', 'hide');
   
});

function raiseAssignTP()
{
    var form=$('form')[0];
var formData= new FormData(form);

var data = $('#Listing_Copy').DataTable().rows().data().toArray();
var TotalIncidentsAttached = new Array();
for(var i=0;i<data.length;i++)
	{
	TotalIncidentsAttached.push(data[i][2]);
	}
var TotalIncidentsAttachedSet = new Set(TotalIncidentsAttached); 
var IncidentsAttachedSet = [...TotalIncidentsAttachedSet];
console.log("IncidentsAttachedSet: "+IncidentsAttachedSet);
formData.append('TotalIncidentsAttached', JSON.stringify(IncidentsAttachedSet));

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/TPActivity/insertTPRaiseAssignOutageTicket";

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
//    alert("in submit button");
    if(!validateForm())
    {
//        alert("failed");
        event.preventDefault();
    }
    else if(validateForm())
    {
//        alert("Passed");
       raiseAssignTP(); 
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
      	var serviceUrl = base_url + "/TPActivity/GetIncidentTicketListForOutage";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            data: 'FromDate=' + fromDate
                    + "&ToDate=" + toDate
                    + "&category=" + category,
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
        data: 'ticketid=' + id,

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
        data: 'ticketid=' + ticketid,

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
        	   else if(statusColor=="Assigned" || statusColor=="Re-Assigned" || statusColor=="Reopen"){callOutColor="callout-warning"}
        	   else if(statusColor=="Hold"){callOutColor="callout-danger"}
        	   else if(statusColor=="Resolved"){callOutColor="callout-success"}
        	   else if(statusColor=="Closed"){callOutColor="callout-success"}
        	   
        	   /////////////// CODE FOR NOTES ///////////////
        	   if(data[i]["CHANGE_NOTES1"]==undefined || data[i]["CHANGE_NOTES1"]=="" || data[i]["CHANGE_NOTES1"]==" " || data[i]["CHANGE_NOTES1"]==null)
        		 {
        		   notes1="";
        		 }
        	 else{
        		 notes1="<textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["CHANGE_NOTES1"]+"</textarea>";
        	 }
        	   
        	   ////////////////CODE TO APPEND////////////
        	   html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Priority : <span>"+data[i]["PRIORITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type : <span>"+data[i]["ROLE_TYPE"]+"</span></span></div></div><br><div class='row'><div class='col-md-12'>"+notes1+"</div></div></div>";
        	   
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