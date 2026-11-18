//$(document).ready(function(){
//        $("#modeledituser").on('show.bs.modal',function(){
////        setTimeout(function (){
////            $('#fnameupdate').focus();
////        },3000 );
//        $(this).find('input[type="text"]').focus();
//    });
//});

function getSiteDetailsupdate(event) {
//    alert(event);
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getSiteDetails";

//     var serviceUrl = "getSiteDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + event,
         success: function(data4) {
//             alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = "<option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("snameupdate").innerHTML = html;
             }

             
     });
     
     
    
}

function getDeptDetailsupdate(event) {
//  alert(event);
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getDepartmentDetails";

//   var serviceUrl = "getSiteDetails";
   $.ajax({
       type: 'POST',
       url: serviceUrl,
       dataType: 'json',
       data: 'sitename=' + event,
       success: function(data4) {
//           alert(data4)
//          var pollingHost = data4;
//                  var d = pollingHost.split(",");
//                  var length = d.length - 1;
                  var html = "<option value=''>-- Please Select --</option>";
                  for (var i = 0; i < data4.length; i++) {
//                      alert(data4[i]);
                      html += '<option value="' + data4[i] + '">' + data4[i]
                              + '</option>';
                  }
                  document.getElementById("dnameupdate").innerHTML = html;
           }
   });
}

function validateEmailupdate() {
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
    var emailField = $('#mailupdate').val();
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

function phonenumberupdate() {
    var inputtxt = $('#cnoupdate').val();
    console.log(inputtxt)
    var phoneno = /^\d{10}$/;
//  var phoneno = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
        callToolTipWrongupdate('phnnnoupdate', 'show');
        return false;
    }
}

function checkPassstrengthupdate() {
    var pass = $('#passupdate').val();
    var ret = true;
    ;
    // alert(pass)
    var specailcharatcers = "!#$%&'()*+,-./:;<=>?@[\]^_`{|}~";
    var passwordscore = 0;
    $('#noteupdate').show();
//    for (var i = 0; i < pass.length; i++)
//    {
//        if (specailcharatcers.indexOf(pass.charAt(i)) > -1)
//        {
//            passwordscore += 20;
//        }
//    }
var charcount=0;
 for (var i = 0; i < pass.length; i++)
    {
        
        if (specailcharatcers.indexOf(pass.charAt(i)) > -1)
        {
//            passwordscore += 20;
        charcount=charcount+1;
//        alert(charcount);
        }
    }
    if(charcount>=3 ||charcount<=0)
    {
//        alert("in false")
    }
    else{
        passwordscore += 20;
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
    document.getElementById('labelupdate').innerHTML = strength;
    $('#labelupdate').show();
    if (strength === "Strong")
    {
        document.getElementById('labelupdate').style.color = "green";
        $('#noteupdate').hide()
    }
    else if (strength === "Medium")
    {
        document.getElementById('labelupdate').style.color = "yellow";
         $('#noteupdate').show()
    }
    else if (strength === "Weak")
    {
        document.getElementById('labelupdate').style.color = "red";
         $('#noteupdate').show()
    }

    if (strength === "Strong")
    {
        callToolTipUpdate1update('labelupdate', 'destroy');
        ret = true;
        $('#noteupdate').hide()
    }
    else
    {
        //callToolTipUpdate1('label', 'show');
        ret = false;

    }
    return ret;
}

function validateAddUserupdate() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;

    if ($('#mailupdate').val().trim() === '') {
        
        callToolTip231update('mailupdate', 'show');
        if (indexError == 0) {

        }
        console.log("In mailupdate"+indexError);
        indexError = indexError + 1;
    }

    else if (!validateEmailupdate())
    {
//        console.log('inside invalid email')
        callToolTipUpdate('emailupdate', 'show');
        indexError = indexError + 1;
         console.log("In validateEmail: "+indexError);
    }
    if ($('#cnoupdate').val().trim() === '') {
        callToolTip231update('cnoupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In cnoupdate: "+indexError);
    }
    else if (!phonenumberupdate())
    {
//        console.log('inside invalid contact number')
        //callToolTipWrong('phnno', 'show');
        indexError = indexError + 1;
         console.log("In invalid contact number: "+indexError);

    }
    if ($('#fnameupdate').val().trim() === '') {
        callToolTip231update('fnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In update: "+indexError);
    }
    else if (!$('#fnameupdate').val().trim().match(alphaExp))
    {
        callToolTip231update('fnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In fnamematchupdate: "+indexError);
    }
    if ($('#lnameupdate').val().trim() === '') {
        callToolTip231update('lnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In lnameupdate: "+indexError);
    }
    else if (!$('#lnameupdate').val().trim().match(alphaExp))
    {
        callToolTip231update('lnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In lnamematch update: "+indexError);
    }

    if ($('#passupdate').val().trim() === '') {
        callToolTip231update('passupdate', 'show');
        callToolTipUpdate1update('labelupdate', 'hide');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In passupdate: "+indexError);

    }

    if ($('#Cpassupdate').val().trim() === '') {
        callToolTip231update('Cpassupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In Cpassupdate: "+indexError);
    }

    if (!($('#Cpassupdate').val().trim() === '' && $('#passupdate').val().trim() === '')) {
        if (!checkPassupdate())
        {
            indexError = indexError + 1;
            console.log("In passupdate compare: "+indexError);
        }

    }

    if (!checkPassstrengthupdate() && $('#passupdate').val().trim() !== '')
    {

        callToolTipUpdate1update('labelupdate', 'show');
        indexError = indexError + 1;
        console.log("In checkPassstrengthupdate: "+indexError);
    }

//    if ($('#type').val() === '') {
//        callToolTip231update('type', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//        console.log("In type: "+indexError);
//    }
     if ($('#cnameupdate').val().trim() === '') {
        callToolTip231update('cnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In cnameupdate: "+indexError);
    }
     if ($('#snameupdate').val().trim() === '') {
        callToolTip231update('snameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In snameupdate: "+indexError);
    }
     if ($('#dnameupdate').val().trim() === '') {
        callToolTip231update('dnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In dnameupdate: "+indexError);
    }
    if (indexError > 0) {
//        alert("false")
        return false;

    } else {
//        alert("true")
        return true;
    }
}

var callToolTip231update = function(fieldName, status) {

     if (fieldName == "passupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password<span>";
    }
    else if (fieldName == "Cpassupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Confirm Password<span>";
    }
    else if (fieldName == "passupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password<span>";
    }
    else if (fieldName == "fnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct First Name<span>";
    }
    
    else if (fieldName == "lnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Last Name<span>";
    }
    
    
    else if (fieldName == "mailupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Email-ID<span>";
    }
    else if (fieldName == "cnoupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Contact Number<span>";
    }

    else if (fieldName == "typeupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Type<span>";
    } else if (fieldName == "passnotmatchupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Password Not Matched!<span>";
    }
    else if (fieldName == "passwresetupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password<span>";
    }

    else if (fieldName == "cpassresetupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Confirm Password<span>";
    }
    else if (fieldName == "cpassresetupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Confirm Password<span>";
    }
    else if (fieldName == "cnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Company Name<span>";
    }
    else if (fieldName == "snameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Site Name<span>";
    }
    else if (fieldName == "dnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Department Name<span>";
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

$('#fnameupdate').on('focusout', function() {
    var usertype = $('#fnameupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('fnameupdate', 'show');
    }
    else {
        callToolTip231update('fnameupdate', 'hide');
    }
});
$('#lnameupdate').on('focusout', function() {
    var usertype = $('#lnameupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('lnameupdate', 'show');
    }
    else {
        callToolTip231update('lnameupdate', 'hide');
    }
});

$('#passupdate').on('focusout', function() {
    var usertype = $('#passupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('passupdate', 'show');
    }
    else {
        callToolTip231update('passupdate', 'hide');
    }
});
$('#Cpassupdate').on('focusout', function() {
    var usertype = $('#Cpassupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('Cpassupdate', 'show');
    }
    else {
        callToolTip231update('Cpassupdate', 'hide');
    }
});
$('#cnameupdate').on('focusout', function() {
    var usertype = $('#cnameupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('cnameupdate', 'show');
    }
    else {
    }
});
$('#snameupdate').on('focusout', function() {
    var usertype = $('#snameupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('snameupdate', 'show');
    }
    else {
    }
});
$('#dnameupdate').on('focusout', function() {
    var usertype = $('#dnameupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('dnameupdate', 'show');
    }
    else {
    }
});
$('#mailupdate').on('focusout', function() {
    var usertype = $('#mailupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('mailupdate', 'show');
    }
    else if (!validateEmail())
    {
        console.log('invali email')
        callToolTipWrongupdate('emailupdate', 'hide');
    }
    else {
        callToolTip231update('mailupdate', 'hide');
    }
});
$('#cnoupdate').on('focusout', function() {
    var usertype = $('#cnoupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('cnoupdate', 'show');
    }
    else {
        callToolTip231update('cnoupdate', 'hide');
    }
});

$('#fnameupdate').on('focus', function() {
    callToolTip231update('fnameupdate', 'destroy');
});
$('#lnameupdate').on('focus', function() {
    callToolTip231update('lnameupdate', 'destroy');
});
$('#mailupdate').on('focus', function() {
    callToolTipWrongupdate('emailupdate', 'destroy');
    callToolTip231update('mailupdate', 'destroy');
});
$('#cnoupdate').on('focus', function() {
    callToolTip231update('cnoupdate', 'destroy');
    callToolTipWrongupdate('phnnnoupdate', 'hide');
});
$('#typeupdate').on('focus', function() {
    callToolTip231update('typeupdate', 'destroy');
});
$('#passupdate').on('focus', function() {
    callToolTip231update('passupdate', 'destroy');
});
$('#Cpassupdate').on('focus', function() {
    callToolTip231update('Cpassupdate', 'destroy');
});
$('#cnameupdate').on('focus', function() {
    callToolTip231update('cnameupdate', 'destroy');
});
$('#snameupdate').on('focus', function() {
    callToolTip231update('snameupdate', 'destroy');
});
$('#dnameupdate').on('focus', function() {
    callToolTip231update('dnameupdate', 'destroy');
});

var callToolTipUpdate1update = function(fieldName, status) {
    if (fieldName == "labelupdate") {
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

var callToolTipWrongupdate = function(fieldName, status) {
    if (fieldName == "emailupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Email ID<span>";
    } else if (fieldName == "phnnnoupdate") {
        var errorMessage = "<span>Please Enter Correct Contact No<span>";
    } else if (fieldName == "emailupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Email ID<span>";
    } else if (fieldName == "cnoupdate") {
        var errorMessage = "<span>Please Enter Correct Contact No<span>";
    }

    else if (fieldName == "passupdate") {
        var errorMessage = "<span>Please Enter Password More then 6 Characters<span>";
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

function checkPassupdate() {
    var ret = true;
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('passupdate');

    var pass2 = document.getElementById('Cpassupdate');

    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessageupdate');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    $('#note1update').hide();
    if (pass1.value === "" && pass2.value === "")
    {
        ret = false;
    }
    else if (pass1.value == pass2.value) {

        pass2.style.backgroundColor = goodColor;


        document.getElementById('note1update').innerHTML = "Passwords matched!";
        document.getElementById('note1update').style.color = "green";
        $('#note1update').show();
        ret = true;
    } else {

        pass2.style.backgroundColor = badColor;
        document.getElementById('note1update').innerHTML = "Passwords do not match!";
        document.getElementById('note1update').style.color = "red";
        $('#note1update').show();

        ret = false;
    }
    return ret;
}

function EditUser(USERID,USERNAME,NAME,COMPANY,BRANCH_NAME,DEPARTMENT_NAME,PHONE,MAIL) {
  
	$("#note").tooltip('hide');
    $("#lname").tooltip('hide');
    $("#mail").tooltip('hide');
    $("#email").tooltip('hide');
    $("#cno").tooltip('hide');
    $("#user").tooltip('hide');
    $("#pass").tooltip('hide');
    $("#Cpass").tooltip('hide');
    $("#fname").tooltip('hide');
    $("#cname").tooltip('hide');
    $("#fname").tooltip('hide');
    $("#sname").tooltip('hide');
    $("#dname").tooltip('hide');
    $("#label").tooltip('hide');
    $("#phnnno").tooltip('hide');
    $("#fname1").tooltip('hide');
    $("#lname1").tooltip('hide');
    $("#user1").tooltip('hide');
	
//    alert("USERID" + USERID);
//    alert("USERNAME" + USERNAME);
//    alert("NAME" + NAME);
//    alert("COMPANY" + COMPANY);
//    alert("BRANCH_NAME" + BRANCH_NAME);
//    alert("DEPARTMENT_NAME" + DEPARTMENT_NAME);
//    alert("PHONE" + PHONE);
//    alert("MAIL" + MAIL);
var NameArray= NAME.split(' ');
var Firstname=NameArray[0];
var Lastname=NameArray[1];

$("#fnameupdate").val(Firstname);
$("#lnameupdate").val(Lastname);
$("#userupdate").val(USERNAME);
//$("#cnameupdate").val(COMPANY);
//$("#snameupdate").val(BRANCH_NAME);
//alert(DEPARTMENT_NAME)
if(($("#dnameupdate option[value='"+DEPARTMENT_NAME+"']").length > 0)===true){
	$("#dnameupdate").val(DEPARTMENT_NAME);
}else{
	$("#dnameupdate").val("");
}
//$("#dnameupdate").val(DEPARTMENT_NAME);
$("#mailupdate").val(MAIL);
$("#cnoupdate").val(PHONE);
$("#sr_no").val(USERID);


    $("#modeledituser").modal("show");
//    $("#modeledituser").on('show.bs.modal',function(){
////        setTimeout(function (){
////            $('#fnameupdate').focus();
////        },3000 );
//        $(this).find('input[type="text"]').focus();
//    });
//     $('#fnameupdate').focus();
}
$('#modeledituser').on('hidden.bs.modal', function () {
	$("#passupdate").val("");
	$('#noteupdate').hide();
	$('#labelupdate').hide();
	$("#Cpassupdate").val("");
	$('#note1update').hide();
	document.getElementById('Cpassupdate').style.backgroundColor = "#fff";
	$("#cnameupdate").val("");
	$("#snameupdate").val("");
	
});

$("#updateuser-btn").click(function() {
//    alert("in update")
    if (!validateAddUserupdate())
    {
//        alert("fail")
        event.preventDefault();
    } else if (validateAddUserupdate())
    {
//        alert("pass")
    updateAddUserSave007();
      }
}).show();

function updateAddUserSave007() {
//alert("in save")
//   alert($('#fnameupdate').val());
//    alert($('#lnameupdate').val());
//    alert($('#userupdate').val());
//    alert($('#cnameupdate').val());
//     alert($('#snameupdate').val());
//     alert( $('#dnameupdate').val());
//       alert($('#mailupdate').val());
//       alert( $('#cnoupdate').val());
//       alert( $('#passupdate').val());
//        alert( $('#sr_no').val());
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updateAddUserSave";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "fnameupdate=" + $('#fnameupdate').val()
                + "&lnameupdate=" + $('#lnameupdate').val()
                + "&userupdate=" + $('#userupdate').val()
                + "&cnameupdate=" + $('#cnameupdate').val()
                + "&snameupdate=" + $('#snameupdate').val()
                + "&dnameupdate=" + $('#dnameupdate').val()
                + "&mailupdate=" + $('#mailupdate').val()
                + "&cnoupdate=" + $('#cnoupdate').val()
                + "&passupdate=" + $('#passupdate').val()
                + "&cr_no=" + $('#sr_no').val(),
        success: function(data) {
//alert("fhgkdsf"+data)
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Updated Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    showCancelButton: !0,
                    confirmButtonClass: "btn btn-success",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    confirmButtonText: "OK",
                    preConfirm: function() {
                        location.reload();
                    }
                })
            }


            else if (data == "duplicate") {
                swal({
                    title: "Duplicate!",
                    text: "Record Already Exist",
                    type: "success",
                    width: '300px',
                    height: '90px !important',
                    showCancelButton: !0,
                    confirmButtonClass: "btn btn-success",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    confirmButtonText: "OK",
                    preConfirm: function() {
                        location.reload();
                    }
                })
            }


            else {

                swal({
                    title: "Unsuccessful!",
                    text: "Record not updated",
                    type: "error",
                    width: 300,
                    height: 200,
                    showCancelButton: !0,
                    confirmButtonClass: "btn btn-danger",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    confirmButtonText: "OK",
                    preConfirm: function() {
                        location.reload();
                    }
                })
            }
            


        }
    })
}

$("#modeleditengg").on("hidden.bs.modal", function () {
    // put your default event here
	$("#note").tooltip('hide');
    $("#lname").tooltip('hide');
    $("#mail").tooltip('hide');
    $("#email").tooltip('hide');
    $("#cno").tooltip('hide');
    $("#user").tooltip('hide');
    $("#pass").tooltip('hide');
    $("#Cpass").tooltip('hide');
    $("#fname").tooltip('hide');
    $("#cname").tooltip('hide');
    $("#fname").tooltip('hide');
    $("#sname").tooltip('hide');
    $("#dname").tooltip('hide');
    $("#label").tooltip('hide');
    $("#phnnno").tooltip('hide');
    $("#fname1").tooltip('hide');
    $("#lname1").tooltip('hide');
    $("#user1").tooltip('hide');
    
//    callToolTip231('note', 'hide');
//    callToolTip231('lname', 'hide');
//    callToolTip231('mail', 'hide');
//    callToolTip231('cno', 'hide');
//    callToolTip231('user', 'hide');
//    callToolTip231('pass', 'hide');
//    callToolTip231('Cpass', 'hide');
//    callToolTip231('fname', 'hide');
//    callToolTip231('cname', 'hide');
//    callToolTip231('sname', 'hide');
//    callToolTip231('dname', 'hide');
//    callToolTipUpdate1('label', 'hide');
    $("#note").hide();
    $("#note1").hide();
    $("#label").html("");
	
});