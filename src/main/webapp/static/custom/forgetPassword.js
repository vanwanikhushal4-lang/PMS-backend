window.onload=function()
{
    $('#forgotpass').show();
    $('#otpdiv').hide();
    
    
    var fiveMinutes = 60 * 5;
    var display = document.querySelector('#countdown');
    startTimer(fiveMinutes, display);
}


function getRegisterMail(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/login/getRegisterMail";
	
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        data: "name=" + $('#name').val()
               
//        + "&usertype=" + $('#usertype').val()

    }).done(function(data) {
//    	alert("data:"+data);
//    	 var email = data.split("#")[1];
//         var maskedEmail = data;

//         $('#emailId').text(maskedEmail);
         document.getElementById('emailId').innerText = data;
     }).fail(function(xhr, status, error) {
         console.error("AJAX Error: ", status, error);
    });
}


function startTimer(duration, display) {
	  var timer = duration, minutes, seconds;
	  setInterval(function () {
	    minutes = parseInt(timer / 60, 10);
	    seconds = parseInt(timer % 60, 10);

	    minutes = minutes < 10 ? '0' + minutes : minutes;
	    seconds = seconds < 10 ? '0' + seconds : seconds;

	    display.textContent = minutes + ':' + seconds;

	    if (--timer < 0) {
	      timer = 0;
	      display.textContent = "EXPIRED";
	    }
	  }, 1000);
	}

var callToolTip = function(fieldName, status) {
   
    if (fieldName == "name") {
        var errorMessage = "<span>Please Enter Username<span>";
    }
    else if (fieldName == "usertype") {
        var errorMessage = "<span>Please Enter User Type<span>";
    }
    else if (fieldName == "otp") {
        var errorMessage = "<span>Please Enter OTP<span>";
    }
    else if (fieldName == "pass") {
        var errorMessage = "<span>Please Enter Password<span>";
    }
    else if (fieldName == "cnfpass") {
        var errorMessage = "<span>Please Enter Confirm Password<span>";
    }

    $("#" + fieldName).tooltip({
        trigger : 'manual',
        placement : 'top',
        title : errorMessage,
        animation : true,
        delay : 1000,
        html : true
    });

    if (status == "show") {

        $("#" + fieldName).tooltip('show');

    } else {
        $("#" + fieldName).tooltip('hide');
    }
}

$('#name').on('focusout', function() {
    var username = $('#name').val();

    if (username.trim() == "") {
        callToolTip('name', 'show');
    }
    else{
        callToolTip('name', 'hide');
    }
});

$('#otp').on('focusout', function() {
    var username = $('#otp').val();

    if (username.trim() == "") {
        callToolTip('otp', 'show');
    }
    else{
        callToolTip('otp', 'hide');
    }
});

$('#usertype').on('focusout', function() {
    if ($('#usertype').val().trim() == "") {
        callToolTip('usertype', 'show');
    } else {
        callToolTip('usertype', 'hide');
    }
});

$('#pass').on('focusout', function() {
    if ($('#pass').val().trim() == "") {
        callToolTip('pass', 'show');
    } else {
        callToolTip('pass', 'hide');
    }
});

$('#cnfpass').on('focusout', function() {
    if ($('#cnfpass').val().trim() == "") {
        callToolTip('cnfpass', 'show');
    } else {
        callToolTip('cnfpass', 'hide');
    }
});

$('#usertype').on('focus', function() {
    callToolTip('usertype', 'destroy');
});

$('#name').on('focus', function() {
    callToolTip('name', 'destroy');
});

$('#otp').on('focus', function() {
    callToolTip('otp', 'destroy');
    callToolTipWrong('otpno', 'destroy');
});
$('#pass').on('focus', function() {
    callToolTip('pass', 'destroy');
});
$('#cnfpass').on('focus', function() {
    callToolTip('cnfpass', 'destroy');
});

var loginCheck = function() {

    //console.log(emailExistCheck());
   var indexError = 0;
                
    if ($('#name').val() === '') {
        callToolTip('name', 'show');
        if (indexError == 0) {
			
        }
        indexError = indexError + 1;
    }
   

    
      if ($('#usertype').val()=== '') {
        callToolTip('usertype', 'show');
        if (indexError == 0) {
			
        }
        indexError = indexError + 1;
    }

    if (indexError > 0) {
        return false;

    } else {
        return true;
    }

}

$("#resetPass").click(function() {
	$('#spin12').show();
    
	
	getRegisterMail()
	
	
    if(!loginCheck())
    {
        event.preventDefault();
    }
    else
    {
    	var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/login/checkUserandTypeVelox";
    	
//        var getDetails = 'checkUserandType';
        $.ajax({
            url: serviceUrl,
            type: 'POST',
            data: "name=" + $('#name').val()
                   
//            + "&usertype=" + $('#usertype').val()

        }).done(function(data) {
        	
        	
//        	alert(data);
           
            var data1=data.split("#");
             if((data1[0] =="wrongcredentials")||(data1[0] =="")||(data1[0] ==" ")) {
                
				swal({
					 title: 'Unsuccessful!', 
					 html: 'Username not matching for the Usertype', 
					 type: 'error',
					 width: 300,
					 confirmButtonText: 'Ok',
			                  preConfirm: function() {
			                        var l = window.location;
			                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			                       window.location.href =base_url+"/login/forgetPassword";
			                    }
						 });
	           }else if((data1[0] =="null")) {
	                
					swal({
						 title: 'Unsuccessful!', 
						 html: 'Email Not Registered, Please Contact to Admin', 
						 type: 'error',
						 width: 300,
						 confirmButtonText: 'Ok',
				                  preConfirm: function() {
				                        var l = window.location;
				                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
				                       window.location.href =base_url+"/login/forgetPassword";
				                    }
							 });
		           } else if(data1[0] =="success") {
	        	   			
//	        	   		alert("mailId:"+data1[0]);
	        	   		var mailId=data1[1];
	                     
//	                      document.getElementById("phoneno").innerHTML=data1[2];
//	                      document.getElementById("phone").value=data1[1];
	                      var l = window.location;
	                      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                      serviceUrl =base_url+"/login/sendOtpToMailID";
                     
        $.ajax({
            url: serviceUrl,
            type: 'POST',
            data: "name=" + $('#name').val() +
            		"&mailId=" + mailId
//                   + "&number="+  data1[1]
            + "&usertype=" + $('#usertype').val()

        }).done(function(data12) {
        	$('#spin12').hide();
            
         $('#forgotpass').hide();
         $('#otpdiv').show();
     });
                 }
     });
    }
}).show();

$("#checkOTP").click(function() {
    
    if(!OTPCheck())
    {
        event.preventDefault();
    }
    else
    {
    	var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        serviceUrl =base_url+"/login/checkOTPMail";
      $.ajax({
            url: serviceUrl,
            type: 'POST',
            data: "name=" + $('#name').val()
                   + "&number="+  $('#phone').val()
            + "&usertype=" + $('#usertype').val()
            + "&otp=" + $('#otp').val()

        }).done(function(data123) {
           
            if((data123 =="failed")||(data123 =="")||(data123 ==" ")){
                
swal({
		 title: 'Unsuccessful!', 
		 html: 'OTP Not Matched', 
		 type: 'error',
		 width: 300,
		 confirmButtonText: 'Ok',
                  preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                       window.location.href =base_url+"/login/forgetPassword";
                    }
			 });
            }
            else if((data123 =="OTP expired")){
                
            	swal({
            			 title: 'Unsuccessful!', 
            			 html: 'Your OTP has expired.<br> Please request a new one.', 
            			 type: 'error',
            			 width: 300,
            			 confirmButtonText: 'Ok',
            	                  preConfirm: function() {
            	                        var l = window.location;
            	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
            	                       window.location.href =base_url+"/login/forgetPassword";
            	                    }
            				 });
            	  }
                 else if(data123 =="success"){
         $('#forgotpass').hide();
         $('#otpdiv').hide();
         $('#resetPassw').show();
     }
     });  
        
    }
   }).show(); 
   
   var OTPCheck = function() {

    //console.log(emailExistCheck());
   var indexError = 0;
                
    if ($('#otp').val() === '') {
        callToolTip('otp', 'show');
        if (indexError == 0) {
			
        }
        indexError = indexError + 1;
    }
    else if (!otpnumbercheck())
    {
//        console.log('inside invalid contact number')
//        callToolTipWrong('phnno', 'show');
        indexError = indexError + 1;
         console.log("In invalid otp number: "+indexError);

    }
   
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }

}


$("#setPass").click(function() {
	
	
    if(!passCheck())
    {
        event.preventDefault();
    }
    else
    {
    	var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        serviceUrl =base_url+"/login/SetpasswordNew";
        //var getDetails = 'Setpassword';
      $.ajax({
            url: serviceUrl,
            type: 'POST',
            data: "name=" + $('#name').val()
                 + "&pass=" + $('#cnfpass').val() 
            + "&usertype=" + $('#usertype').val()
           

        }).done(function(data123) {
           
            if((data123 =="failed")||(data123 =="")||(data123 ==" ")){
                
swal({
		 title: 'Unsuccessful!', 
		 html: 'Reset Password Failed', 
		 type: 'error',
		 width: 300,
		 confirmButtonText: 'Ok',
                  preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                       window.location.href =base_url+"/";
                    }
			 });
                 }
                 else if(data123 =="success"){
         swal({
		 title: 'Successful!', 
		 html: 'Reset Password Successfully', 
		 type: 'success',
		 width: 300,
		 confirmButtonText: 'Ok',
                  preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                       window.location.href = base_url+"/";
                    }
			 });
     }
     });  
        
    }
   }).show(); 


 var passCheck = function() {

   var indexError = 0;
                
    if ($('#pass').val() === '') {
        callToolTip('pass', 'show');
        if (indexError == 0) {			
        }
        indexError = indexError + 1;
    }    
    if ($('#cnfpass').val() === '') {
        callToolTip('cnfpass', 'show');
        if (indexError == 0) {			
        }
        indexError = indexError + 1;
    }
    
     if (!($('#cnfpass').val().trim() === '' && $('#pass').val().trim() === '')) {
        if (!checkPassupdate123())
        {
            indexError = indexError + 1;
            console.log("In passupdate compare: "+indexError);
        }

    }

    if (!checkPassstrengthupdate())
    {

//        callToolTipUpdate1update('labelupdate', 'show');
        indexError = indexError + 1;
        console.log("In checkPassstrengthupdate: "+indexError);
    }
    
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}

function checkPassupdate123() {
    var ret = true;
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('pass');

    var pass2 = document.getElementById('cnfpass');

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


        document.getElementById('note1update').innerHTML = "Password match!";
        document.getElementById('note1update').style.color = "green";
        $('#note1update').show();
        ret = true;
    } else {

        pass2.style.backgroundColor = badColor;
        document.getElementById('note1update').innerHTML = "Password does not match!";
        document.getElementById('note1update').style.color = "red";
        $('#note1update').show();

        ret = false;
    }
    return ret;
}

function checkPassstrengthupdate() {
    var pass = $('#pass').val();
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
// var charcheck=false;
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

function otpnumbercheck() {
    var inputtxt = $('#otp').val();
    console.log(inputtxt)
    var otpno = /^\d{4}$/;
//  var phoneno = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
    if (inputtxt.match(otpno))
    {
        return true;
    }
    else
    {
        callToolTipWrong('otpno', 'show');
        return false;
    }
}

var callToolTipWrong = function(fieldName, status) {
 if (fieldName == "otpno") {
        var errorMessage = "<span>Please Enter 4 Digit OTP<span>";
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



//02/09
function backToLogin(){
//	alert("redirecting");
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/login/backToLogin";
}
//