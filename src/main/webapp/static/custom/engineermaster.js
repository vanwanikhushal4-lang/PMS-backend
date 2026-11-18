 window.onload = function() {
     //alert("ggggg")
//     $('#user').val("");
      $('#fname').focus();
      var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompanyDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//             alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("cname").innerHTML = html;
                      document.getElementById("cnameupdate").innerHTML = html;
             }

             
     });
     var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getCategoryDetails";
    
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//             alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("category").innerHTML = html;
                    document.getElementById("categoryupdate").innerHTML = html;
             }

             
     });
     
     var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getDepartmentDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
//         data: 'companyname=' + $("#cname").val(),
         success: function(data4) {
//             alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html;
                    var html = "<option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("dnameupdate").innerHTML = html;
             }

             
     });
     var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/addEnggDetails";
//     var serviceUrl = "addEnggDetails";
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

 }

function getSiteDetails() {
//    alert($("#cname").val());
    
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/getSiteDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + $("#cname").val(),
         success: function(data4) {
//             alert(data4)
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("sname").innerHTML = html;
             }

             
     });
    
}

function getDeptDetails() {
//    alert($("#cname").val());
    
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getDepartmentDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
//         data: 'companyname=' + $("#cname").val(),
         success: function(data4) {
//             alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("dname").innerHTML = html;
             }

             
     });
    
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

function validateEngMaster() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;

    if ($('#mail').val().trim() === '') {
        
        callToolTip231('mail', 'show');
        if (indexError == 0) {

        }
        console.log("In Mail"+indexError);
        indexError = indexError + 1;
    }

    else if (!validateEmail())
    {
//        console.log('inside invalid email')
        callToolTipUpdate('email', 'show');
        indexError = indexError + 1;
         console.log("In validateEmail: "+indexError);
    }
    if ($('#cno').val().trim() === '') {
        callToolTip231('cno', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In cno: "+indexError);
    }
    else if (!phonenumber())
    {
//        console.log('inside invalid contact number')
        //callToolTipWrong('phnno', 'show');
        indexError = indexError + 1;
         console.log("In invalid contact number: "+indexError);

    }
    if ($('#fname').val().trim() === '') {
        callToolTip231('fname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In fname: "+indexError);
    }
    else if (!$('#fname').val().trim().match(alphaExp))
    {
        callToolTip231('fname1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In fnamematch: "+indexError);
    }
    if ($('#lname').val().trim() === '') {
        callToolTip231('lname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In lname: "+indexError);
    }
    else if (!$('#lname').val().trim().match(alphaExp))
    {
        callToolTip231('lname1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In lnamematch: "+indexError);
    }
    if ($('#user').val().trim() === '') {
        callToolTip231('user', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In user: "+indexError);
    }
//    else if (!$('#user').val().trim().match(alphaExp))
//    {
//        callToolTip231('user1', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//         console.log("In usermatch: "+indexError);
//    }

    if ($('#pass').val().trim() === '') {
        callToolTip231('pass', 'show');
        callToolTipUpdate1('label', 'hide');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         console.log("In pass: "+indexError);

    }

    if ($('#Cpass').val().trim() === '') {
        callToolTip231('Cpass', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In Cpass: "+indexError);
    }

    if (!($('#Cpass').val().trim() === '' && $('#pass').val().trim() === '')) {
        if (!checkPass())
        {
            indexError = indexError + 1;
            console.log("In pass compare: "+indexError);
        }

    }

    if (!checkPassstrength() && $('#pass').val().trim() !== '')
    {

        callToolTipUpdate1('label', 'show');
        indexError = indexError + 1;
        console.log("In checkPassstrength: "+indexError);
    }

    if ($('#type').val() === '') {
        callToolTip231('type', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In type: "+indexError);
    }
     if ($('#cname').val().trim() === '') {
        callToolTip231('cname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In cname: "+indexError);
    }
     if ($('#sname').val().trim() === '') {
        callToolTip231('sname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In sname: "+indexError);
    }
     if ($('#dname').val().trim() === '') {
        callToolTip231('dname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In dname: "+indexError);
    }
    if ($('#category').val().trim() === '') {
        callToolTip231('category', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In category: "+indexError);
    }
    if ($('#englevel').val().trim() === '') {
        callToolTip231('englevel', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In englevel: "+indexError);
    }
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}

var callToolTip231 = function(fieldName, status) {

    if (fieldName == "user") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter User Name<span>";
    } else if (fieldName == "pass") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password<span>";
    }
    else if (fieldName == "Cpass") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Confirm Password<span>";
    }
    else if (fieldName == "pass") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password<span>";
    }
    else if (fieldName == "fname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter First Name<span>";
    }
    else if (fieldName == "fname1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Character only for First Name<span>";
    }
    else if (fieldName == "lname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Last Name<span>";
    }
    else if (fieldName == "lname1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Character only for Last Name<span>";
    }
    else if (fieldName == "user1") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>lease Enter Character only for Last Name<span>";
    }
    else if (fieldName == "mail") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Email-ID<span>";
    }
    else if (fieldName == "cno") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Contact Number<span>";
    }
    else if (fieldName == "englevel") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Engineer Level<span>";
    }

    else if (fieldName == "type") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Type<span>";
    } else if (fieldName == "passnotmatch") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Password Not Matched!<span>";
    }
    else if (fieldName == "passwreset") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password<span>";
    }
    else if (fieldName == "usernamereset") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Username<span>";
    }
    else if (fieldName == "cpassreset") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Confirm Password<span>";
    }
    else if (fieldName == "cpassreset") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Confirm Password<span>";
    }
    else if (fieldName == "cname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Company Name<span>";
    }
    else if (fieldName == "sname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Site Name<span>";
    }
    else if (fieldName == "dname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Department Name<span>";
    }
    else if (fieldName == "category") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Category<span>";
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

$('#fname').on('focusout', function() {
	var alphaExp = /^[a-zA-Z '.-]+$/;
    var usertype = $('#fname ').val();

    if (usertype.trim() == "") {
        callToolTip231('fname', 'show');
    }
    else if (!usertype.trim().match(alphaExp)){
   	 callToolTip231('fname1', 'show');
   }
    else {
        callToolTip231('fname', 'hide');
    }
});
$('#lname').on('focusout', function() {
	var alphaExp = /^[a-zA-Z '.-]+$/;
    var usertype = $('#lname ').val();

    if (usertype.trim() == "") {
        callToolTip231('lname', 'show');
    }
    else if (!usertype.trim().match(alphaExp)){
      	 callToolTip231('lname1', 'show');
      }
    else {
        callToolTip231('lname', 'hide');
    }
});
$('#user').on('focusout', function() {
    var usertype = $('#user').val();

    if (usertype.trim() == "") {
        callToolTip231('user', 'show');
    }
    else {
        callToolTip231('user', 'hide');
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
$('#Cpass').on('focusout', function() {
    var usertype = $('#Cpass ').val();

    if (usertype.trim() == "") {
        callToolTip231('Cpass', 'show');
    }
    else {
        callToolTip231('Cpass', 'hide');
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
$('#sname').on('focusout', function() {
    var usertype = $('#sname').val();

    if (usertype.trim() == "") {
        callToolTip231('sname', 'show');
    }
    else {
    }
});
$('#dname').on('focusout', function() {
    var usertype = $('#dname').val();

    if (usertype.trim() == "") {
        callToolTip231('dname', 'show');
    }
    else {
    }
});
$('#mail').on('focusout', function() {
    var usertype = $('#mail ').val();

    if (usertype.trim() == "") {
        callToolTip231('mail', 'show');
    }
    else if (!validateEmail())
    {
        console.log('invali email')
        callToolTipWrong('email', 'hide');
    }
    else {
        callToolTip231('mail', 'hide');
    }
});
$('#cno').on('focusout', function() {
    var usertype = $('#cno ').val();

    if (usertype.trim() == "") {
        callToolTip231('cno', 'show');
    }
    else {
        callToolTip231('cno', 'hide');
    }
});
$('#englevel').on('focusout', function() {
    var usertype = $('#englevel').val();

    if (usertype.trim() == "") {
        callToolTip231('englevel', 'show');
    }
    else {
        callToolTip231('englevel', 'hide');
}
});
$('#category').on('focusout', function() {
    var usertype = $('#category ').val();

    if (usertype.trim() == "") {
        callToolTip231('category', 'show');
    }
    else {
        callToolTip231('category', 'hide');
    }
});


$('#user').on('focus', function() {
    callToolTip231('user', 'destroy');
});
$('#fname').on('focus', function() {
    callToolTip231('fname', 'destroy');
    callToolTip231('fname1', 'destroy');
});
$('#lname').on('focus', function() {
    callToolTip231('lname', 'destroy');
    callToolTip231('lname1', 'destroy');
});
$('#mail').on('focus', function() {
    callToolTipWrong('email', 'destroy');
    callToolTip231('mail', 'destroy');
});
$('#cno').on('focus', function() {
    callToolTip231('cno', 'destroy');
    callToolTipWrong('phnnno', 'hide');
});
$('#englevel').on('focus', function() {
    callToolTip231('englevel', 'destroy');
});
$('#type').on('focus', function() {
    callToolTip231('type', 'destroy');
});
$('#pass').on('focus', function() {
    callToolTip231('pass', 'destroy');
});
$('#Cpass').on('focus', function() {
    callToolTip231('Cpass', 'destroy');
});
$('#cname').on('focus', function() {
    callToolTip231('cname', 'destroy');
});
$('#sname').on('focus', function() {
    callToolTip231('sname', 'destroy');
});
$('#dname').on('focus', function() {
    callToolTip231('dname', 'destroy');
});
$('#category').on('focus', function() {
    callToolTip231('category', 'destroy');
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
    } else if (fieldName == "cno") {
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
        var errorMessage = "<span>Please Enter Contact Number<span>";
    }
    else if (fieldName == "emailupdate") {
        var errorMessage = "<span>Please Enter Correct Contact Number<span>";
    }
    else if (fieldName == "phnupdate") {
        fieldName = "phnupdate"
        $("#cnoupdate").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Contact Number<span>";
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
    if (fieldName == "email") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Email ID<span>";
    } else if (fieldName == "phnnno") {
        var errorMessage = "<span>Please Enter Correct Contact No<span>";
    } else if (fieldName == "emailupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Email ID<span>";
    } else if (fieldName == "cnoupdate") {
        var errorMessage = "<span>Please Enter Correct Contact No<span>";
    }

    else if (fieldName == "pass") {
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

var callToolTipUpdate = function(fieldName, status) {
    if (fieldName == "mail") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Email ID<span>";
    } else if (fieldName == "cno") {
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
        var errorMessage = "<span>Please Enter Contact Number<span>";
    }
    else if (fieldName == "emailupdate") {
        var errorMessage = "<span>Please Enter Correct Contact Number<span>";
    }
    else if (fieldName == "phnupdate") {
        fieldName = "phnupdate"
        $("#cnoupdate").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Contact Number<span>";
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


$("#submit-btn").click(function() {
//     alert("dgfsgf");
    if (!validateEngMaster()) {
//        alert("in invalid");
        event.preventDefault();
    } else {
//        alert("valid");
        saveDataUser();
    }
});

function saveDataUser() {
//    alert("in save: "+$("#category").val());
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/addEngg";
    $.ajax({
        url: serviceUrl,
        type: 'post',
        data: 'mail=' + $("#mail").val()
                + '&cno=' + $("#cno").val()
                + '&user=' + $("#user").val()
                + '&pass=' + $("#pass").val()
                + '&fname=' + $("#fname").val()
                + '&lname=' + $("#lname").val()
                + '&cpass=' + $("#Cpass").val()
                + '&cname=' + $("#cname").val()
                + '&sname=' + $("#sname").val()
                + '&dname=' + $("#dname").val()
                + '&category=' + $("#category").val()
                + '&englevel=' + $("#englevel").val(),
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
                        location.reload();
                    }

                })

            }
        }
    })
}

$("#resetbtn").click(function() {
	//alert("reset")
    $("#fname").val("");
    $("#lname").val("");
    $("#user").val("");
    $("#cno").val("");
    $("#englevel").val("");
   
    $("#pass").val("");
    $("#Cpass").val("");
    $("#cname").val("");
    $("#sname").val("");
    $("#dname").val("");
     $("#mail").val("");
    $("#category").val("");
    
     callToolTip231('cname', 'hide');
    callToolTip231('sname', 'hide');
    callToolTip231('dname', 'hide');
    callToolTip231('fname', 'hide');
    callToolTip231('lname', 'hide');
    callToolTip231('mail', 'hide');
    callToolTipWrong('email', 'hide');
    callToolTip231('cno', 'hide');
    callToolTip231('englevel', 'hide');
    callToolTip231('user', 'hide');
    callToolTip231('pass', 'hide');
    callToolTip231('Cpass', 'hide');
    callToolTip231('category', 'hide');
    callToolTipUpdate1('label', 'hide');
    callToolTipWrong('phnnno', 'hide');
    callToolTip231('fname1', 'hide');
    callToolTip231('lname1', 'hide');
    callToolTip231('user1', 'hide');
    $("#note").hide();
    $("#note1").hide();
    $("#label").html("");
   
    var pass2 = document.getElementById('Cpass');
    pass2.style.backgroundColor = "white";
//    document.getElementById('note1').style.color =white;
})

function Deleteengineer(srno) {
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
 	 	var serviceUrl = base_url + "/Master/DeleteEngineer";
     
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
                        window.location.href = base_url + "/Admin/EnggMaster";
                    }

                })

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
                        window.location.href = base_url + "/ATM/Engineermaster.jsp";
                    }

                })

            }
        });
    })
}
