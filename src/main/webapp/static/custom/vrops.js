
$('#submit-btn').click(function()
		{
		   // alert("in btn")
		      if (!validation2222())
		    {
		        event.preventDefault();
		    } else if (validation2222())
		    {
		   // alert("adduser")
		    	saveDataVrops();
		   }
		}).show();


function multi() {
	 $("#alerttype").multiselect({
	        includeSelectAllOption: true,
	       buttonWidth: '100%',
	       
	       enableFiltering: true,
	       maxHeight: 200,
	     
	       
	    });
}

function saveDataVrops() {
   // alert("in save ssl=="+ssl1)
    // alert("in save starttls=="+starttls1)
    //  alert("in save docticket=="+docticket1)
	var certival,hostval;
	 var certi1=$("#certi").val();
	 var host1=$("#host").val();
	 if(certi1=="Yes"||certi1=="yes")
		 {
		 certival="true";
		 }
	 else
		 {
		 certival="false";
		 }
	 
	 
	 if(host1=="Yes"||host1=="yes")
	 {
		 hostval="true";
	 }
 else
	 {
	 hostval="false";
	 }
	 
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/adduserVrops";
    $.ajax({
        url: serviceUrl,
        type: 'post',
        data: 'uname=' + $("#uname").val()
                + '&pass=' + $("#pass").val()
                + '&surl=' + $("#surl").val()
                + '&certi=' + certival
                + '&host=' + hostval     
                + '&alerttype=' +  $("#alerttype").val(),
                
               
               //+ '&athorrrr=' + $("#athorrrr").val(),
        success: function(data) {
//        	alert(data)
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Inserted Successfully!",
                    type: "success",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        location.reload();
                    }

                })

            } else if (data == "duplicate") {
                swal({
                    title: "Duplicate!",
                    text: "Record Exists",
                    type: "success",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        location.reload();
                    }

                })

            }
        }
    })
}



window.onload = function() {
	
	multi();

	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/addVropsIntDetails";

	//  var serviceUrl = "addUserDetails";
	  $.ajax({
	      type: 'POST',
	      url: serviceUrl,
	      dataType: 'json',
	      success: function(data4) {
//	     	 alert(data4)


	          var table = $('#datatype').DataTable({
	              lengthChange: false,
	              data: data4,
	              scrollX: true,
	               "pageLength": 5
	          });

	          table.buttons().container()
	                  .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

	      }

	  });
	  

	  
	  

	};
	
	
//validation-----------
	
	var callToolTip122 = function (fieldName, status) {

	    if (fieldName == "uname") {
	        //$("#email").tooltip('destroy');
	        var errorMessage = "<span>Please Enter User Name<span>";

	    }
	     else if (fieldName == "pass") {
	        //$("#email").tooltip('destroy');
	        var errorMessage = "<span>Please Enter Password <span>";

	    }
	     else if (fieldName == "surl") {
		        //$("#email").tooltip('destroy');
		        var errorMessage = "<span>Please Enter Service URL <span>";

		    }
	    
	     else if (fieldName == "certi") {
		        //$("#email").tooltip('destroy');
		        var errorMessage = "<span>Please Select Verify Certificate<span>";

		    }
	    
	     else if (fieldName == "host") {
		        //$("#email").tooltip('destroy');
		        var errorMessage = "<span>Please Select Ignore Hostname<span>";

		    }
	    
	    else if (fieldName == "alerttype") {
	    	//alert("in alerttype field with status=="+status);
	        //$("#email").tooltip('destroy');
	        var errorMessage = "<span>Please Select Alert Type<span>";
	       // alert("errorMessage=="+errorMessage)

	    }
	    else if (fieldName == "alerttype1") {
	        //$("#email").tooltip('destroy');
	    //	alert("in alerttype1 div field");
	    	var errorMessage = "<span>Please Select  Alert Type<span>";
	    }
	    
	    
	   
	 $("#" + fieldName).tooltip({
	        
		    trigger: 'manual',
	        placement: 'top',
	        title: errorMessage,
	        animation: true,
	        delay: 1000,
	        left:-100,
	        html: true
	    });

	    if (status == "show") {

	        $("#" + fieldName).tooltip('show');

	    } else {
	        $("#" + fieldName).tooltip('hide');
	    }

	}
	
//-------------------------
	
	$('#uname').on('focusout', function () {
	    var usertype = $('#uname').val();

	    if (usertype.trim() == "") {
	        callToolTip122('uname', 'show');
	    }
	    else {
	        callToolTip122('uname', 'hide');
	    }
	});

	$('#pass').on('focusout', function () {
	    var usertype = $('#pass').val();

	    if (usertype.trim() == "") {
	        callToolTip122('pass', 'show');
	    }
	    else {
	        callToolTip122('pass', 'hide');
	    }
	});
	
	$('#surl').on('focusout', function () {
	    var usertype = $('#surl').val();

	    if (usertype.trim() == "") {
	        callToolTip122('surl', 'show');
	    }
	    else {
	        callToolTip122('surl', 'hide');
	    }
	});
	
	
	$('#certi').on('focusout', function () {
	    var usertype = $('#certi').val();

	    if (usertype.trim() == "") {
	        callToolTip122('certi', 'show');
	    }
	    else {
	        callToolTip122('certi', 'hide');
	    }
	});
	
	
	$('#host').on('focusout', function () {
	    var usertype = $('#host').val();

	    if (usertype.trim() == "") {
	        callToolTip122('host', 'show');
	    }
	    else {
	        callToolTip122('host', 'hide');
	    }
	});
	
	
//	$('#alerttype').on('focusout', function () {
//	    var usertype = $('#alerttype').val();
//
//	    if (usertype.trim() == "") {
//	        callToolTip122('alerttype', 'show');
//	    }
//	    else {
//	        callToolTip122('alerttype', 'hide');
//	    }
//	});
//	
	
	$('#alerttype1').on('focusout', function() {
	    var usertype = $('#alerttype').val();

	    if ($('#alerttype').find(":selected").text() == "") {
	        callToolTip122('alerttype', 'hide');
	    }
	    else if ($('#alerttype').val() === "")
	    {
	        callToolTip122('alerttype', 'show');
	    }
	});
	
	
//	$('#alerttype').on('focusout', function() {
//	    var usertype = $('#alerttype').val();
//
//	    if ($('#alerttype').find(":selected").text() == "") {
//	        callToolTip122('alerttype', 'hide');
//	    }
//	    else if ($('#alerttype').val() === "")
//	    {
//	        callToolTip122('alerttype', 'show');
//	    }
//	});

	
	
//------------------------------
	
	$('#uname').on('focus', function () {
	    callToolTip122('uname', 'destroy');
	});
	$('#pass').on('focus', function () {
	    callToolTip122('pass', 'destroy');
	});
	$('#surl').on('focus', function () {
	    callToolTip122('surl', 'destroy');
	});
	$('#certi').on('focus', function () {
	    callToolTip122('certi', 'destroy');
	});
	
	$('#host').on('focus', function () {
	    callToolTip122('host', 'destroy');
	});
	
	
	$('#alerttype').on('focus', function () {
	    callToolTip122('alerttype', 'destroy');
	});
	
	
	
	
	
	
//-------------------------

	var validation2222 = function () {
	   // alert("in validation2222()")
	    indexError = 0;
	    if ($('#uname').val().trim() === '') {
	        callToolTip122('uname', 'show');
	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	    if ($('#pass').val().trim() === '') {
	        callToolTip122('pass', 'show');
	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	    
	    if ($('#surl').val().trim() === '') {
	        callToolTip122('surl', 'show');
	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	    
	    if ($('#certi').val().trim() === '') {
	        callToolTip122('certi', 'show');
	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	    
	    
	    if ($('#host').val().trim() === '') {
	        callToolTip122('host', 'show');
	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	    
	  
	    
	    var selectedValues = [];
	//    alert("selectedValues===="+selectedValues);
	    $("#alerttype :selected").each(function() {
	        selectedValues.push($(this).val());
	    });
	    
	    if (selectedValues.toString() === '' || selectedValues.toString() === 'undefined')
	    {
	    	//alert("in cond entry undefined");
	        callToolTip122('alerttype', 'show');
	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;

	    }
	   
	    
	    
	    
	    
	   
	      if (indexError > 0) {
//	        alert("false")
	        return false;

	    } else {
//	        alert("true")
	        return true;
	    }

	    
	}
	
//====reset btn

	$("#resetbtn").click(function() {
		
	    $("#uname").val("");
	    $("#pass").val("");
	    $("#surl").val("");
	    $('#certi').prop('selectedIndex',0);
	    $('#host').prop('selectedIndex',0);
	   
	    
	    $("#alerttype option:selected").prop("selected", false);
        $("#alerttype").multiselect('refresh');
        $("#alerttype").val("")
	    
	    
	    
	    

	    callToolTip122('uname', 'hide');
	    callToolTip122('pass', 'hide');

	    callToolTip122('surl', 'hide');
	    callToolTip122('certi', 'hide');
	    callToolTip122('host', 'hide');
	    
	    callToolTip122('alerttype1', 'hide');
	    
	    
	})
	
	
	
	
	