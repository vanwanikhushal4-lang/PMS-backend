window.onload = function() {

	
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
           async: false,
         success: function(data4) {
        	 	var html = "  <option value=''> -- Please Select --</option>";
             
                   for (var i = 0; i < data4.length; i++) {

                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("company").innerHTML = html;
                        
             }
     });


	
	
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/addEmailIntDetails";

//  var serviceUrl = "addUserDetails";
  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data4) {
//     	 alert(data4)


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
	 
$('#submit-btn').click(function()
		{
		   // alert("in btn")
		      if (!validation2222())
		    {
		        event.preventDefault();
		    } else if (validation2222())
		    {
		   // alert("adduser")
		    	saveDataEmail();
		   }
		}).show();


function saveDataEmail() {
	
  // alert("in fun")
	 alert($("#pass").val().trim())
	//alert(starttls)
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/adduserEmail";
    $.ajax({
        url: serviceUrl,
        type: 'post',
        data:'company=' + encodeURIComponent($("#company").val().trim()) 
                   + '&mail=' + $("#mail").val().trim()
                + '&subject=' + $("#subject").val().trim()
                + '&folder=' + $("#folder").val().trim()
                + '&port=' + $("#port").val().trim()
                + '&uname=' + $("#uname").val().trim()
                + '&pass=' + $("#pass").val()
                ,
              
        success: function(data) {
//        	alert(data)
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Inserted Successfully!",
                    type: "success",
                    width: 300,
                    height: 200,

                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        location.reload();
                    }

                })

            } else if (data == "duplicate") {
                swal({
                    title: "Duplicate Data!",
                    text: "Record Already Exists",
                    type: "warning",
                    width: 300,
                    height: 200,
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




//validation-------------

var callToolTip122 = function (fieldName, status) {

	 if (fieldName == "company") {
	        //$("#email").tooltip('destroy');
	        var errorMessage = "<span>Please Enter Company Name<span>";

	    }
	
   
    else if (fieldName == "mail") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Mail-Server<span>";

    }
    
    else if (fieldName == "subject") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Subject<span>";

        
    }
    
   
    else if (fieldName == "folder") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Folder To Poll<span>";

    }
    
    else if (fieldName == "port") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select port <span>";

    }
    else if (fieldName == "uname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter User Name <span>";

    }
    else if (fieldName == "pass") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password <span>";

    }
    
 $("#" + fieldName).tooltip({
        
        trigger: 'manual',
        at: 'center',
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

//------------

$('#company').on('focusout', function () {
    var usertype = $('#company').val();

    if (usertype.trim() == "") {
        callToolTip122('company', 'show');
    }
    else {
        callToolTip122('company', 'hide');
    }
});




$('#mail').on('focusout', function () {
    var usertype = $('#mail').val();

    if (usertype.trim() == "") {
        callToolTip122('mail', 'show');
    }
    else {
        callToolTip122('mail', 'hide');
    }
});

$('#subject').on('focusout', function () {
    var usertype = $('#subject').val();

    if (usertype.trim() == "") {
        callToolTip122('subject', 'show');
    }
    else {
        callToolTip122('subject', 'hide');
    }
});


$('#folder').on('focusout', function () {
    var usertype = $('#folder').val();

    if (usertype.trim() == "") {
        callToolTip122('folder', 'show');
    }
    else {
        callToolTip122('folder', 'hide');
    }
});

$('#port').on('focusout', function () {
    var usertype = $('#port').val();

    if (usertype.trim() == "") {
        callToolTip122('port', 'show');
    }
    else {
        callToolTip122('port', 'hide');
    }
});


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


//------------------

$('#company').on('focus', function () {
    callToolTip122('company', 'destroy');
});
$('#mail').on('focus', function () {
    callToolTip122('mail', 'destroy');
});
$('#subject').on('focus', function () {
    callToolTip122('subject', 'destroy');
});

$('#folder').on('focus', function () {
    callToolTip122('folder', 'destroy');
});

$('#port').on('focus', function () {
    callToolTip122('port', 'destroy');
});


$('#uname').on('focus', function () {
    callToolTip122('uname', 'destroy');
});


$('#pass').on('focus', function () {
    callToolTip122('pass', 'destroy');
});



//---------------------------

var validation2222 = function () {
    
    indexError = 0;
    if ($('#company').val().trim() === '') {
        callToolTip122('company', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
  
    if ($('#mail').val().trim() === '') {
        callToolTip122('mail', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#subject').val().trim() === '') {
        callToolTip122('subject', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
  
    
    if ($('#folder').val().trim() === '') {
        callToolTip122('folder', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#port').val().trim() === '') {
        callToolTip122('port', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
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
    
      if (indexError > 0) {
//        alert("false")
        return false;

    } else {
//        alert("true")
        return true;
    }

    
}

//-----reset btn

$("#resetbtn").click(function() {
	$("#company").val("");
    
   
    $("#mail").val("");
    $("#subject").val("");
   
    $("#folder").val("");
    $("#port").val("");
    $("#uname").val("");
    $("#pass").val("");

    
    callToolTip122('company', 'hide');
  
    callToolTip122('folder', 'hide');
    callToolTip122('mail', 'hide');
    callToolTip122('subject', 'hide');
  
    callToolTip122('port', 'hide');
    callToolTip122('uname', 'hide');
    callToolTip122('pass', 'hide');
    
})
//////////////////Edit Mail Server integration//////////////
function EditDesignation(srno, company, designation) {
	
   $("#companynameupdate").val(company);
   $("#designationNameupdate").val(designation);
   $("#sr_no1").val(srno);
   $("#modeldesignation").modal("show");
   
 }
function DeleteEmailIntegration(srno)
{

//alert(srno)
	  swal({
	        title: "Are you sure?",
	        text: "You want to delete?",
	        type: "warning",
	        width: 350,
	        height: 200,
	        showCancelButton: !0,
	        confirmButtonClass: "btn btn-success",
	        cancelButtonClass: "btn btn-danger m-l-10",
	        confirmButtonText: "Yes, Delete it!"
	    }).then(function() {
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/DeleteEmailServerIntegration";
$.ajax({
  url: serviceUrl,
  type: 'post',
  data:'srno=' + srno,     
  success: function(data) {
//  	alert(data)
      if (data == "success") {
          swal({
              title: "Successful!",
              text: "Record Deleted Successfully!",
              type: "success",
              width: 300,
              height: 200,
              buttons: false,
              allowOutsideClick: false,
              preConfirm: function() {
                  location.reload();
              }

          })

      } else if (data == "error") {
          swal({
              title: "Duplicate Data!",
              text: "Record Not Updated",
              type: "warning",
              width: 300,
              height: 200,
              buttons: false,
              allowOutsideClick: false,
              preConfirm: function() {
                  location.reload();
              }

          })

      }
  }
})
	    });
}

function EditmailIntegration(srno,company,mailserver,subject,folder,port,username)
{

		
	 $("#sr_no1").val(srno);
	 $("#companyup").val(company);
	 
	 $("#mailup").val(mailserver);
	 $("#subjectup").val(subject);
	 $("#folderup").val(folder);
	 $("#portup").val(port);
	 $("#unameup").val(username);
	
	 
	 
	  $("#updatemodel").modal("show");
	  
}
var callToolTip124 = function (fieldName, status) {

	 if (fieldName == "companyup") {
	        //$("#email").tooltip('destroy');
	        var errorMessage = "<span>Please Enter Company Name<span>";

	    }
	
  
   else if (fieldName == "mailup") {
       //$("#email").tooltip('destroy');
       var errorMessage = "<span>Please Enter Mail-Server<span>";

   }
   
   else if (fieldName == "subjectup") {
       //$("#email").tooltip('destroy');
       var errorMessage = "<span>Please Enter Subject<span>";

       
   }
   
  
   else if (fieldName == "folderup") {
       //$("#email").tooltip('destroy');
       var errorMessage = "<span>Please Select Folder To Poll<span>";

   }
   
   else if (fieldName == "portup") {
       //$("#email").tooltip('destroy');
       var errorMessage = "<span>Please Select port <span>";

   }
   else if (fieldName == "unameup") {
       //$("#email").tooltip('destroy');
       var errorMessage = "<span>Please Enter User Name <span>";

   }
   else if (fieldName == "passup") {
       //$("#email").tooltip('destroy');
       var errorMessage = "<span>Please Enter Password <span>";

   }
   
$("#" + fieldName).tooltip({
       trigger: 'manual',
       at: 'center',
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


var validatemailIntegration = function ()
{
	  
    indexError = 0;
    if ($('#companyup').val().trim() === '') {
        callToolTip124('companyup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
  
    if ($('#mailup').val().trim() === '') {
        callToolTip124('mailup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#subjectup').val().trim() === '') {
        callToolTip124('subjectup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
  
    
    if ($('#folderup').val().trim() === '') {
        callToolTip124('folderup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#portup').val().trim() === '') {
        callToolTip124('portup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#unameup').val().trim() === '') {
        callToolTip124('unameup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#passup').val().trim() === '') {
        callToolTip124('passup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
      if (indexError > 0) {
//        alert("false")
        return false;

    } else {
//        alert("true")
        return true;
    }

    
}

$('#companyup').on('focus', function () {
    callToolTip124('companyup', 'destroy');
});
$('#mailup').on('focus', function () {
    callToolTip124('mailup', 'destroy');
});
$('#subjectup').on('focus', function () {
    callToolTip124('subjectup', 'destroy');
});

$('#folderup').on('focus', function () {
    callToolTip124('folderup', 'destroy');
});

$('#portup').on('focus', function () {
    callToolTip124('portup', 'destroy');
});


$('#unameup').on('focus', function () {
    callToolTip124('unameup', 'destroy');
});


$('#passup').on('focus', function () {
    callToolTip124('passup', 'destroy');
});
$("#update_category_btn").click(function() {

    if (!validatemailIntegration()) {
    	event.preventDefault();
    } else {
    	updateMailIntegration();
    }
}).show();
function updateMailIntegration()
{
	
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/updateEmailServerIntegration";
 $.ajax({
     url: serviceUrl,
     type: 'post',
     data:'company=' + encodeURIComponent($("#companyup").val()) 
                + '&mail=' + $("#mailup").val().trim()
             + '&subject=' + $("#subjectup").val().trim()
             + '&folder=' + $("#folderup").val()
             + '&port=' + $("#portup").val()
             + '&uname=' + $("#unameup").val().trim()
             + '&pass=' + $("#passup").val()
              + '&srno=' + $("#sr_no1").val()
          ,
            
     success: function(data) {
//     	alert(data)
         if (data == "success") {
             swal({
                 title: "Successful!",
                 text: "Record Updated Successfully!",
                 type: "success",
                 width: 300,
                 height: 200,

                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     location.reload();
                 }

             })

         } else if (data == "duplicate") {
             swal({
                 title: "Duplicate Data!",
                 text: "Record Already Exists",
                 type: "warning",
                 width: 300,
                 height: 200,
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
