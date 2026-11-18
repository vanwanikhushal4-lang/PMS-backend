/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$('#View-btn').click(function(){
                  
     if((validateChangePassword()))   {
//         alert("pass")
    	 
    	 var l = window.location;
    	 var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	 var serviceUrl = base_url + "/TPActivity/TpPasswordreset";
    	 
//                  var getDetails='TpPasswordreset';  
    $.ajax({

        url :serviceUrl,
        type : 'POST',
        
        data: "user="+$('#name1').val()
        +"&oldpass="+$('#oldpass').val()
+"&newpass="+$('#pass').val()
+"&cnfnewpass="+$('#Cpass').val()
        
    }).done(function(data) {
//     alert(data)
       if(data =="success"){
                
swal({
		 title: 'Successfull!', 
		 html: 'Password Updated Successfully', 
		 type: 'success',
		 width: 300,
		 confirmButtonText: 'Ok',
                  preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                       window.location.href =base_url+"/TP/ResetTPPassw";
                    }
			 });
                 }
                else if(data =="newpassfailed"){
                
swal({
		 title: 'Unsuccessfull!', 
		 html: 'New Password & Confirm Password Not Matching', 
		 type: 'error',
		 width: 300,
		 confirmButtonText: 'Ok',
                  preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                       window.location.href =base_url+"/TP/ResetTPPassw";
                    }
			 });
                 }
                 else if(data =="oldpasnewpassmatch"){
                
swal({
		 title: 'Unsuccessfull!', 
		 html: 'New Password Should Not Match Old Password', 
		 type: 'error',
		 width: 300,
		 confirmButtonText: 'Ok',
                  preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                       window.location.href =base_url+"/TP/ResetTPPasswt";
                    }
			 });
                 }
                else if(data =="oldpasswrong"){
                
swal({
		 title: 'Unsuccessfull!', 
		 html: 'Old Password Not Matching', 
		 type: 'error',
		 width: 300,
		 confirmButtonText: 'Ok',
                  preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                       window.location.href =base_url+"/TP/ResetTPPassw";
                    }
			 });
                 }
                 else 
                 {
                   swal({
		 title: 'Unsuccessfull!', 
		 html: 'Password Update Failed', 
		 type: 'error',
		 width: 300,
		 confirmButtonText: 'Ok',
                  preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                       window.location.href =base_url+"/TP/ResetTPPassw";
                    }
			 });  
                 }
                         
    }); 
     }
             })
             
             
function validateForm()
{
 
      var indexError = 0;
   
   if ($('#oldpass').val() === '') {
        console.log('fill oldpass');
        callToolTip231('oldpass', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#pass').val().trim() === '') {
        console.log('fill newpass');
        callToolTip231('newpass', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#Cpass').val().trim() === '') {
        console.log('fill cnfpass');
        callToolTip231('cnfpass', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   
   console.log("validation error count::::"+indexError);
 if (indexError != 0) {  
        return false;

    } else {

        return true;
    }
}

$('#oldpass').on('focusout', function () {

    var usertype = $('#oldpass').val();
    if (usertype.trim() == "") {
        callToolTip231('oldpass', 'show');
    }
    else {
       callToolTip231('oldpass', 'hide');
    }
   });
    
    $('#pass').on('focusout', function () {

    var usertype = $('#pass').val();
    if (usertype.trim() == "") {
        callToolTip231('pass', 'show');
     }
//    else if (usertype.trim() !== "") {
//       callToolTipUpdate1('label', 'show');
//    }
    else {
       callToolTip231('pass', 'hide');
    }
});
    $('#Cpass').on('focusout', function () {

    var usertype = $('#Cpass').val();
    if (usertype.trim() == "") {
        callToolTip231('Cpass', 'show');
    }
    else {
       callToolTip231('Cpass', 'hide');
    }
});

$('#oldpass').on('focus', function () {
    callToolTip231('oldpass', 'destroy');
});

$('#pass').on('focus', function () {
    callToolTip231('pass', 'destroy');
      callToolTipUpdate1('label', 'destroy');
});
$('#Cpass').on('focus', function () {
    callToolTip231('Cpass', 'destroy');
});


var callToolTip231 = function (fieldName, status) {
    if (fieldName === "oldpass") {
        var errorMessage = "<span>Please Enter Old Password<span>";
    }
    else if (fieldName === "pass") {      
        var errorMessage = "<span>Please Enter New Password<span>";
    }
    else if (fieldName === "Cpass") {
        var errorMessage = "<span>Please Enter Confirm Password<span>";
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
             
$("#resetbtn").click(function(){               
    $("#oldpass").val("");
    $("#oldpass").tooltip('hide');
    $("#pass").val("");
    $("#Cpass").val("");
 
   $("#pass").tooltip('hide');
 
   $("#Cpass").tooltip('hide');
  
   $("#note").tooltip('hide');
   $("#label").tooltip('hide');
 
    $("#note").hide();
    $("#note1").hide();
    $("#label").html("");
//    callToolTipWrong('phnnno', 'hide');
//    callToolTip231('fname1', 'hide');
//    callToolTip231('lname1', 'hide');
//    callToolTip231('user1', 'hide');
    var pass2 = document.getElementById('Cpass');
    pass2.style.backgroundColor = "white";
   
//    document.getElementById('note1').style.color =white;

    
             })

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

function checkPassstrength() {
    var pass = $('#pass').val();
    var ret = true;
    ;
    // alert(pass)
    var specailcharatcers = "!#$%&'()*+,-./:;<=>?@[\]^_`{|}~";
    var passwordscore = 0;
    $('#note').show();

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
function validateChangePassword() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;

    if ($('#oldpass').val() === '') {
        console.log('fill oldpass');
        callToolTip231('oldpass', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
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
        if (!checkPass999())
        {
            indexError = indexError + 1;
            console.log("In pass compare: "+indexError);
        }

    }

    if (!checkPassstrength() && $('#pass').val().trim() !== '')
    {

//        callToolTipUpdate1('label', 'show');
        indexError = indexError + 1;
        console.log("In checkPassstrength: "+indexError);
    }

    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}
function checkPass999() {
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