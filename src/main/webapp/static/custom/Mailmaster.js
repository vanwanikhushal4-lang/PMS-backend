 window.onload = function() {
     $('#host').focus();
//     alert("ggggg");
     var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/getCompositecompanyDetails";
//	      var serviceUrl = "getDepartmentDetails";
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
//	         data: 'companyname=' + $("#cname").val(),
	         success: function(data4) {
	           //  alert(data4)
//	            var pollingHost = data4;
//	                    var d = pollingHost.split(",");
//	                    var length = d.length - 1;
	        	 var html = "<option value=''>-- Please Select --</option>";
	                    for (var i = 0; i < data4.length; i++) {
//	                        alert(data4[i]);
	                        html += '<option value="' + data4[i] + '">' + data4[i]
	                                + '</option>';
	                    }

	                    document.getElementById("cname").innerHTML = html;
	                    document.getElementById("cnameupdate").innerHTML = html;
	             }

	             
	     });
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/MailConfig/MailMasterListing";
 	  
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {



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
function validateCompany() {
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
    var companyField = $('#company').val();
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(companyField) == false)
    {
        //callToolTipWrong('email', 'show');
        ret = false;
    }
    else
    {
        ret = true;
    }
    return ret;
}


function validateEmail() {
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
    var emailField = $('#mail').val();
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(emailField) == false)
    {
        //callToolTipWrong('email', 'show');
        ret = false;
    }
    else
    {
        ret = true;
    }
    return ret;
}
function validateEmailupdate() {
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
    var emailField = $('#emailupdate').val();
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(emailField) == false)
    {
        //callToolTipWrong('email', 'show');
        ret = false;
    }
    else
    {
        ret = true;
    }
    return ret;
}

function phonenumber() {
    var inputtxt = $('#cno').val();
    console.log(inputtxt)
    var phoneno = /^\d{10}$/;
//  var phoneno = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
        callToolTipWrong('phnnno', 'show');
        return false;
    }
}

function checkPassstrength() {
    var pass = $('#pass').val();
    var ret = true;
    ;
    // alert(pass)
    var specailcharatcers = "!#$%&'()*+,-./:;<=>?@[\]^_`{|}~";
    var passwordscore = 0;
    $('#note').show();
    for (var i = 0; i < pass.length; i++)
    {
        if (specailcharatcers.indexOf(pass.charAt(i)) > -1)
        {
            passwordscore += 20;
        }
    }

    if (/[a-z]/.test(pass))
    {
        console.log('inside lowercase')
        passwordscore += 20;
    }
    if (/[A-Z]/.test(pass))
    {
        console.log('inside uppercase')
        passwordscore += 20;
    }
    if (/[\d]/.test(pass))
    {
        console.log('inside numbers')
        passwordscore += 20;
    }
    if (pass.length >= 7)
    {
        console.log('inside length')
        passwordscore += 20;
    }
    //alert(passwordscore)
    var strength = "Weak";
    if (passwordscore >= 100)
    {
        strength = "Strong";
    }
    else if (passwordscore >= 80)
    {
        strength = "Medium";
    }
    else if (passwordscore >= 60)
    {
        strength = "Weak";
    }

    //alert('strength now:'+strength)
    document.getElementById('label').innerHTML = strength;
    $('#label').show();
    if (strength === "Strong")
    {
        document.getElementById('label').style.color = "green";
        $('#note').hide()
    }
    else if (strength === "Medium")
    {
        document.getElementById('label').style.color = "yellow";
         $('#note').show()
    }
    else if (strength === "Weak")
    {
        document.getElementById('label').style.color = "red";
         $('#note').show()
    }

    if (strength === "Strong")
    {
        callToolTipUpdate1('label', 'destroy');
        ret = true;
        $('#note').hide()
    }
    else
    {
        //callToolTipUpdate1('label', 'show');
        ret = false;

    }
    return ret;
}

function validateMailMaster() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;

    if ($('#mail').val().trim() === '') {
        
        callToolTip231('mail', 'show');
        if (indexError == 0) {

        }
        console.log("In Mail"+indexError);
        indexError = indexError + 1;
    }

    if ($('#host').val().trim() === '') {
        callToolTip231('host', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In host: "+indexError);
    }
    
    if ($('#port').val().trim() === '') {
        callToolTip231('port', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In port: "+indexError);
    }
   
    if ($('#password').val().trim() === '') {
        callToolTip231('password', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In password: "+indexError);
    }
   

    if ($('#authentication').val().trim() === '') {
        callToolTip231('authentication', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In authentication: "+indexError);

    }
if ($('#cname').val().trim() === '') {
        
        callToolTip231('cname', 'show');
        if (indexError == 0) {

        }
        console.log("In Mail"+indexError);
        indexError = indexError + 1;
    }

    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}

var callToolTip231 = function(fieldName, status) {

    if (fieldName == "host") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Host <span>";
    } 
   
    else if (fieldName == "port") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Port Number<span>";
    }
    else if (fieldName == "mail") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Email-ID<span>";
    }
    else if (fieldName == "password") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password<span>";
    }
    else if (fieldName == "authentication") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Authentication<span>";
    }
  
    else if (fieldName == "mail") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Email Id<span>";
    }
   
    else if (fieldName == "cname") {
        var errorMessage = "<span>Please Select Company Name<span>";
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

$('#host').on('focusout', function() {
    var usertype = $('#host ').val();

    if (usertype.trim() == "") {
        callToolTip231('host', 'show');
    }
    else {
        callToolTip231('host', 'hide');
    }
});
$('#cname').on('focusout', function() {
    var usertype = $('#cname ').val();

    if (usertype.trim() == "") {
        callToolTip231('cname', 'show');
    }
    else {
        callToolTip231('cname', 'hide');
    }
});
$('#port').on('focusout', function() {
    var usertype = $('#port ').val();

    if (usertype.trim() == "") {
        callToolTip231('port', 'show');
    }
    else {
        callToolTip231('port', 'hide');
    }
});

$('#pass').on('focusout', function() {
    var usertype = $('#pass').val();

    if (usertype.trim() == "") {
        callToolTip231('pass', 'show');
    }
    else {
        callToolTip231('pass', 'hide');
    }
});
$('#password').on('focusout', function() {
    var usertype = $('#password ').val();

    if (usertype.trim() == "") {
        callToolTip231('password', 'show');
    }
    else {
        callToolTip231('password', 'hide');
    }
});
$('#authentication').on('focusout', function() {
    var usertype = $('#authentication').val();

    if (usertype.trim() == "") {
        callToolTip231('authentication', 'show');
    }
    else {
         callToolTip231('authentication', 'hide');
    }
});
$('#cname').on('focusout', function() {
    var usertype = $('#cname').val();

    if (usertype.trim() == "") {
        callToolTip231('cname', 'show');
    }
    else {
    }
});


$('#host').on('focus', function() {
    callToolTip231('host', 'destroy');
});
$('#cname').on('focus', function() {
    callToolTip231('cname', 'destroy');
});
$('#password').on('focus', function() {
    callToolTip231('password', 'destroy');
});
$('#port').on('focus', function() {
    callToolTip231('port', 'destroy');
});
$('#mail').on('focus', function() {
    callToolTip231('mail', 'destroy');
});
$('#authentication').on('focus', function() {
    callToolTip231('authentication', 'destroy');   
});
$('#pass').on('focus', function() {
    callToolTip231('pass', 'destroy');
});

$('#cname').on('focus', function() {
    callToolTip231('cname', 'destroy');
});

var callToolTipUpdate1 = function(fieldName, status) {
    if (fieldName == "label") {
        var errorMessage = "<span>Password Must contain atleast one number,one lowercase,one uppercase and one special character<span>";
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

var callToolTipUpdate = function(fieldName, status) {
    if (fieldName == "mail") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Email ID<span>";
    } 
    
    else if (fieldName == "cno") {
        var errorMessage = "<span>Please Enter Correct Contact No<span>";
    }
    else if (fieldName == "pass") {
        var errorMessage = "<span>Please Enter Password More then 6 Characters<span>";
    }
    else if (fieldName == "usernameupdate") {
        var errorMessage = "<span>Please Enter Username<span>";
    }
    else if (fieldName == "fnameupdate") {
        var errorMessage = "<span>Please Enter First Name<span>";
    }
    else if (fieldName == "fnameupdate1") {
        var errorMessage = "<span>Please Enter Character only for First Name<span>";
    }
    else if (fieldName == "lnameupdate") {
        var errorMessage = "<span>Please Enter Last Name<span>";
    }
    else if (fieldName == "lnameupdate1") {
        var errorMessage = "<span>Please Enter Character only for Last Name<span>";
    }
    else if (fieldName == "mailupdate") {
        var errorMessage = "<span>Please Enter Email ID<span>";
    }

    else if (fieldName == "cnoupdate") {
        fieldName = "cnoupdate"
        $("#phnupdate").tooltip('destroy');
        var errorMessage = "<span>Please Enter contact No<span>";
    }
    else if (fieldName == "emailupdate") {
        var errorMessage = "<span>Please Enter Correct contact No<span>";
    }
    else if (fieldName == "phnupdate") {
        fieldName = "phnupdate"
        $("#cnoupdate").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Contact No<span>";
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

var callToolTipWrong = function(fieldName, status) {
    if (fieldName == "email1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Email ID<span>";
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


function checkPass() {
    var ret = true;
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('pass');

    var pass2 = document.getElementById('Cpass');

    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    $('#note1').hide();
    if (pass1.value === "" && pass2.value === "")
    {
        ret = false;
    }
    else if (pass1.value == pass2.value) {

        pass2.style.backgroundColor = goodColor;


        document.getElementById('note1').innerHTML = "Password match!";
        document.getElementById('note1').style.color = "green";
        $('#note1').show();
        ret = true;
    } else {

        pass2.style.backgroundColor = badColor;
        document.getElementById('note1').innerHTML = "Password does not match!";
        document.getElementById('note1').style.color = "red";
        $('#note1').show();

        ret = false;
    }
    return ret;
}

$('#hostnameupdate').on('focusout', function() {
    var web = $('#hostnameupdate').val();
    if (web.trim() == "") {
        callToolTipUpdate('hostnameupdate', 'show');
    }
    else {
        callToolTipUpdate('hostnameupdate', 'hide');
    }
});
$('#cnameupdate').on('focusout', function() {
    var web = $('#cnameupdate').val();
    if (web.trim() == "") {
        callToolTipUpdate('cnameupdate', 'show');
    }
    else {
        callToolTipUpdate('cnameupdate', 'hide');
    }
});
$('#portnumberupdate').on('focusout', function() {
    var web = $('#portnumberupdate').val();
    if (web.trim() == "") {
        callToolTipUpdate('portnumberupdate', 'show');
    }
    else {
        callToolTipUpdate('portnumberupdate', 'hide');
    }
});

$('#emailupdate').on('focusout', function() {
    var web = $('#emailupdate').val();
    if (web.trim() == "") {
        callToolTipUpdate('emailupdate', 'show');
    }
    else {
        callToolTipUpdate('emailupdate', 'hide');
    }
});

$('#passwordupdate').on('focusout', function() {
    var web = $('#passwordupdate').val();
    if (web.trim() == "") {
        callToolTipUpdate('passwordupdate', 'show');
    }
    else {
        callToolTipUpdate('passwordupdate', 'hide');
    }
});
$('#authenticationupdate').on('focusout', function() {
    var web = $('#authenticationupdate').val();
    if (web.trim() == "") {
        callToolTipUpdate('authenticationupdate', 'show');
    }
    else {
        callToolTipUpdate('authenticationupdate', 'hide');
    }
});
$('#cnoupdate').on('focusout', function() {
    var web = $('#cnoupdate').val();
    if (web.trim() == "") {
        callToolTipUpdate('cnoupdate', 'show');
    }
    else {
        callToolTipUpdate('cnoupdate', 'hide');
    }
});

$('#hostnameupdate').on('focus', function() {
    callToolTipUpdate('hostnameupdate', 'destroy');
});
$('#cnameupdate').on('focus', function() {
    callToolTipUpdate('cnameupdate', 'destroy');
});
$('#portnumberupdate').on('focus', function() {
    callToolTipUpdate('portnumberupdate', 'destroy');
});
$('#emailupdate').on('focus', function() {
    callToolTipUpdate('emailupdate', 'destroy');
});
$('#passwordupdate').on('focus', function() {
    callToolTipUpdate('passwordupdate', 'destroy');
//    callToolTipWrong('email1', 'show');
});
$('#authenticationupdate').on('focus', function() {
    callToolTipUpdate('authenticationupdate', 'destroy');
});

$("#submit-btn").click(function() {
//     alert("dgfsgf");
    if (!validateMailMaster()) {
//        alert("in fail");
        event.preventDefault();
    } else {
//        alert("in pass");
        saveDataMailMaster();
    }
});



$("#resetbtn").click(function() {
    $("#host").val("");
     callToolTip231('host', 'hide');
     $("#cname").val("");
     callToolTip231('cname', 'hide');
      $("#port").val("");
     callToolTip231('port', 'hide');
      $("#mail").val("");
     callToolTip231('mail', 'hide');
      $("#password").val("");
     callToolTip231('password', 'hide');
      $("#authentication").val("");
     callToolTip231('authentication', 'hide');
     
});

//insert data
function saveDataMailMaster()  {
//alert("inside saveDataMailMaster")
	var starttls;
	if($("#tlscheck").is(":checked"))
		{
			starttls="true";
		}
	else
		{
		starttls="false";
		}
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/MailConfig/SubmitMailDetails";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'host=' + $("#host").val()
                + '&port=' + $("#port").val()
                + '&email=' + $("#mail").val()
                + '&password=' + $("#password").val()
                + '&authentication=' + $("#authentication").val()
                 + '&cname=' + encodeURIComponent($("#cname").val())
                 + '&starttls=' +starttls
                 
                
        }).done(function(data) {
//             alert("hgdjghd"+data)

            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Added Successfully",
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
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/MailMaster";
                    }

                });

            }

            else if (data == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to add file",
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
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/MailMaster";
                    }

                });

              }
            else if (data == "duplicate") {
                swal({
                    title: "Duplicate!",
                    text: "Duplicate Record Found",
                    type: "warning",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/MailMaster";
                    }

                });

              }
        });
    //});
            }  


function DeleteMailConfig(srno)  {
//alert("gdfsf"+srno)
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
        //  alert("deleteUserdddddddd")
    	
    	 var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/MailConfig/DeleteMail";
    	
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'crno=' + srno

        }).done(function(data) {
            //  alert("dfgsfd"+data)

            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Deleted Successfully",
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
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/MailMaster";
                    }

                });

            }

            else if (data == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to delete file",
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
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/MailMaster";
                    }

                });

              }
        });
    });
            }   
                


function EditMailConfig(crno,HOST,PORT,E_MAIL,AUTHO,COMPANY,starttls) {
	 
      callToolTipUpdate('hostnameupdate', 'destroy');
      callToolTipUpdate('cnameupdate', 'destroy');
callToolTipUpdate('portnumberupdate', 'destroy');
callToolTipUpdate('emailupdate', 'destroy');
callToolTipUpdate('passwordupdate', 'destroy');
callToolTipUpdate('authenticationupdate', 'destroy');

     $('#hostnameupdate').val(HOST);
     $('#cnameupdate').val(COMPANY);
     $('#portnumberupdate').val(PORT);
     $('#emailupdate').val(E_MAIL);
     $('#authenticationupdate').val(AUTHO);
     $('#sr_no1').val(crno);	

    
     callToolTip231('host', 'hide');
     callToolTip231('cname', 'hide');
     callToolTip231('port', 'hide');
     callToolTip231('mail', 'hide');
     callToolTip231('password', 'hide');
     callToolTip231('authentication', 'hide');
          
     if(starttls==='true')
		{	
			document.getElementById("tlscheckup").checked = true;
		}
	else
		{
			document.getElementById("tlscheckup").checked = false;
		}
            $("#modelmailmaster1").modal("show");
            
            $("#modelmailmaster1").on('shown.bs.modal', function(){
                $(this).find('#hostnameupdate').focus();
            });
            $("#modelmailmaster1").on('shown.bs.modal', function(){
                $(this).find('#cnameupdate').focus();
            });
}
$('#modelmailmaster1').on('hidden.bs.modal', function () {
	$("#passwordupdate").val("");
});


$("#update_MailMasterType_btn").click(function() {
    if (!updateMailMasterCheck())
    {
//        alert("fail")
        event.preventDefault();
    } else if (updateMailMasterCheck())
    {
//        alert("pass")
    updateMailMasterSave111();
      }
}).show();

function updateMailMasterSave111() {
	var starttlsup;
	if($('#tlscheckup').is(":checked"))
	{
		starttlsup="true";
	}
	else
		{
		starttlsup="false";
		}
	//alert(starttlsup)
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/MailConfig/updateMailConfigSave";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "hostnameupdate=" + $('#hostnameupdate').val()
                  + "&portnumberupdate=" + $('#portnumberupdate').val()
                 + "&emailupdate=" + $('#emailupdate').val()
                 + "&authenticationupdate=" + $('#authenticationupdate').val()
           + "&passwordupdate=" + $('#passwordupdate').val()
                  + "&cr_no=" + $('#sr_no1').val()
                   + "&cnameupdate=" + $('#cnameupdate').val()
                   + "&starttlsup=" +  starttlsup,
                  success: function(data) {
//                      alert(data)
                    if (data == "success") {
                    swal({
                    title: "Successful!",
                    text: "Record Updated Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    confirmButtonText: "OK",
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/MailMaster";
                    }
                });
            }


            else if (data == "duplicate") {
                swal({
                    title: "Duplicate!",
                    text: "Record Already Exist",
                    type: "success",
                    width: '300px',
                    height: '90px !important',
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/MailMaster";
                    }
                });
            }


            else {

                swal({
                    title: "Unsuccessful!",
                    text: "Record not updated",
                    type: "error",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/MailMaster";
                    }
                });
            }
            
             $('#updatecompanyname').val("");
            
                  }
                   });
                   }
                   
var callToolTipUpdate = function(fieldName, status) {
    if (fieldName == "hostnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Host Name<span>";
    } 
    if (fieldName == "cnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Company Name<span>";
    } 
    else if (fieldName == "portnumberupdate") {
        var errorMessage = "<span>Please Enter Port Nnumber<span>";
    }
    else if (fieldName == "emailupdate") {
        var errorMessage = "<span>Please Enter Email-ID<span>";
    }
     else if (fieldName == "passwordupdate") {
        var errorMessage = "<span>Please Enter Password<span>";
    }
    else if (fieldName == "authenticationupdate") {
        var errorMessage = "<span>Please Select Authentication<span>";
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

function updateMailMasterCheck() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;

    if ($('#emailupdate').val().trim() === '') {
        
        callToolTipUpdate('emailupdate', 'show');
        
        if (indexError == 0) {

        }
        console.log("In emailupdate"+indexError);
        indexError = indexError + 1;
    }

//    else if (!validateEmailupdate())
//    {
////        console.log('inside invalid email')
//        callToolTipWrong('email1', 'show');
//        indexError = indexError + 1;
//         console.log("In validateemailupdate: "+indexError);
//    }
//    if ($('#cno').val().trim() === '') {
//        callToolTip231('cno', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//        console.log("In cno: "+indexError);
//    }
//    else if (!phonenumber())
//    {
////        console.log('inside invalid contact number')
//        //callToolTipWrong('phnno', 'show');
//        indexError = indexError + 1;
//         console.log("In invalid contact number: "+indexError);
//
//    }
    if ($('#hostnameupdate').val().trim() === '') {
        callToolTipUpdate('hostnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In hostnameupdate: "+indexError);
    }
    if ($('#cnameupdate').val().trim() === '') {
        callToolTipUpdate('cnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In cnameupdate: "+indexError);
    }
    
    if ($('#portnumberupdate').val().trim() === '') {
        callToolTipUpdate('portnumberupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In portnumberupdate: "+indexError);
    }
   
    if ($('#passwordupdate').val().trim() === '') {
        callToolTipUpdate('passwordupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In passwordupdate: "+indexError);
    }
   

    if ($('#authenticationupdate').val().trim() === '') {
        callToolTipUpdate('authenticationupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In authenticationupdate: "+indexError);

    }


    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}
                   