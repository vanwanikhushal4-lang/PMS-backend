

const togglePassword = document.getElementById('togglePassword');
const passwordField = document.getElementById('password');

togglePassword.addEventListener('click', function () {
  const type = passwordField.getAttribute('type') === 'password' ? 'text' : 'password';
  passwordField.setAttribute('type', type);
  this.classList.toggle('fa-eye');
  this.classList.toggle('fa-eye-slash');
});


var callToolTip = function(fieldName, status) {
   
    if (fieldName == "name") {
        var errorMessage = "<span>Please Enter Username<span>";
    } else if (fieldName == "password") {
        var errorMessage = "<span>Please Enter Password<span>";
    }
    
//    else if (fieldName == "companycode") {
//        var errorMessage = "<span>Please Enter Company Code<span>";
//    }
    

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

//$('#companycode').on('focusout', function() {
//    if ($('#password').val().trim() == "") {
//        callToolTip('companycode', 'show');
//    } else {
//        callToolTip('companycode', 'hide');
//    }
//});

$('#password').on('focusout', function() {
    if ($('#password').val().trim() == "") {
        callToolTip('password', 'show');
    } else {
        callToolTip('password', 'hide');
    }
});

$('#name').on('focus', function() {
    callToolTip('name', 'destroy');
});

$('#password').on('focus', function() {
    callToolTip('password', 'destroy');
});

//$('#companycode').on('focus', function() {
//    callToolTip('companycode', 'destroy');
//});


var loginCheck = function() {

    //console.log(emailExistCheck());
   var indexError = 0;
                
    if ($('#name').val() === '') {
        callToolTip('name', 'show');
        if (indexError == 0) {
			
        }
        indexError = indexError + 1;
    }
    

    if ($('#password').val()=== '') {
        callToolTip('password', 'show');
        if (indexError == 0) {
			
        }
        indexError = indexError + 1;
    } 
    
//    if ($('#companycode').val() === '') {
//    	//alert("in if block");
//        callToolTip('companycode', 'show');
//        if (indexError == 0) {
//			
//        }
//        indexError = indexError + 1;
//    }
 

    if (indexError > 0) {
        return false;

    } else {
        return true;
    }

}

$('#name').keypress(function(event){
    var keycode = (event.keyCode ? event.keyCode : event.which);
    if(keycode == '13'){
    	LoginSign()
    }
});

$('#password').keypress(function(event){
    var keycode = (event.keyCode ? event.keyCode : event.which);
    if(keycode == '13'){
    	LoginSign()
    }
});

//$('#companycode').keypress(function(event){
//    var keycode = (event.keyCode ? event.keyCode : event.which);
//    if(keycode == '13'){
//    	LoginSign()
//    }
//});

function verifyOTP(loginObject) {
	
//	alert("verifyOTP Started");
	console.log(loginObject.length);
	console.log(loginObject[4]);

	var USERNAME=loginObject[0];
	var FULLNAME=loginObject[1];
	var ROLE=loginObject[2];
	var LOGIN_TYPE=loginObject[3];
	var LOGIN_SCOPE=loginObject[4];
//	alert("ROLE:-"+ROLE);
//	alert("LOGIN_TYPE:-"+LOGIN_TYPE);

var otp=$('#txtotp').val();

/*var username=$('#name').val();
usertype1=$('#usertype').val()*/
//alert("name:"+username+" type:-"+usertype1+" otp"+otp);

        var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/login/verifyOTP";
    	$.ajax({
    		url : serviceUrl,
    		type : 'post',   		
    		data:'username='+USERNAME
    		+ "&usertype=" + ROLE
    		+ "&FULLNAME=" + FULLNAME
    		+ "&LOGIN_TYPE=" + LOGIN_TYPE
    		+ "&LOGIN_SCOPE=" + LOGIN_SCOPE
    		+ "&otp=" + otp,
    		 
    		
    	}).done(function (data) {
    	
//    	alert(data);
    	
    	
    	 if(data.includes("Admin") || data.includes("admin")){
    			//	alert("in admin if block")
    				
    				var l = window.location;
														var base_url = l.protocol
																+ "//"
																+ l.host
																+ "/"
																+ l.pathname
																		.split('/')[1];
														window.location.href = base_url
																+ "/Admin/AdminHome";
																
																
																
    			}
    			
else if(data.includes("User") ||data.includes("user")){
	//alert("in  user")
	
	
    		
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

// new add
else if(data.includes("MD") ||data.includes("MD")){
	//alert("in  in client")
	
	
    		
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}
else if(data.includes("Sales") ||data.includes("Sales")){
//	alert("in  in client")
	
	
    		
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

else if(data.includes("Accounts") ||data.includes("Accounts")){
//	alert("in  in client")
	
	
    		
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}
    	 
else if(ROLE.includes("Buisness_Head") ||ROLE.includes("Buisness_Head")){
	//alert("in  user")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}
    	 
else if(ROLE.includes("Manager_Operations") ||ROLE.includes("Manager_Operations")){
	//alert("in  user")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}
    	 
else if(ROLE.includes("HR_EXECUTIVE") ||ROLE.includes("HR_EXECUTIVE")){
	//alert("in  user")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

else if(ROLE.includes("Manager_Pre_Sales") ||ROLE.includes("Manager_Pre_Sales")){
	//alert("in  user")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
} 
    	 

else if(data.includes("Manager") ||data.includes("Manager")){
//	alert("in  in client")
	
	
    		
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}


else if(data.includes("Implementor") ||data.includes("Implementor")){
//	alert("in  in client")
	
	
    		
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

else if(ROLE.includes("Developer") ||ROLE.includes("Developer")){
//	alert("in  Developer")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}


else if(ROLE.includes("Support") ||ROLE.includes("Support")){
//	alert("in  Support")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}
    	 
else if(ROLE.includes("Head_Projects") ||ROLE.includes("Head_Projects")){
//	alert("in  Support")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

else if(ROLE.includes("Account") ||ROLE.includes("Account")){
//	alert("in  Account")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}


else if(ROLE.includes("HR_EXECUTIVE") ||ROLE.includes("HR_EXECUTIVE")){
//	alert("in  HR_EXECUTIVE")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}
else if(data.includes("engineer") ||data.includes("Engineer")){
	//alert("in  user")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Engg/EnggHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
}
    			
else if(data.includes("IT-Head") ){
	//alert("in  user")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/ITHead/IT-HeadHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
}
    
else if(data.includes("Ticket Co-ordinator") ){
	//alert("in  user")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/TP/TPHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
}   
    	 else if(data.includes("fail") ){
    	
//    	alert("You Have Entered Wrong OTP. Try Once Again.")
    	swal({
                            title: "Unsuccessful!",
                            text: "You Have Entered Wrong OTP. Try Once Again!",
                            type: "error",
                            width: 300,
                            confirmButtonClass: "btn btn-success",
                            confirmButtonText: "OK",
                            
                        })
    	}
    	});


}


var USERNAME="";
var FULLNAME="";
var ROLE="";
var LOGIN_TYPE="";
var LOGIN_SCOPE="";

function LoginSign(){
//alert("HIHIH")
    if(!loginCheck())
    {
    	//alert("fail");
        event.preventDefault();
    }
    else{
    	var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/login/loginNew";
    	$.ajax({
    		url : serviceUrl,
    		type : 'post', 
    		 dataType: 'json',  		
    			data:'username='+encodeURIComponent($('#name').val())
    		 +'&password='+encodeURIComponent($('#password').val())
    		  +'&companycode='+encodeURIComponent($('#companycode').val()),
    		  async: false,
    		
    	}).done(function (data) {
//   		console.log("data::::"+data);
//    		alert(data);
    		var DB_VERIFICATION= data[0]["DB_VERIFICATION"];
//    		alert("DB_VERIFICATION:-"+DB_VERIFICATION);
    			
    		FULLNAME= data[0]["FULLNAME"];
//    		alert("FULLNAME:-"+FULLNAME);
    		ROLE= data[0]["ROLE"];
//    		alert("ROLE:-"+ROLE);
    		LOGIN_TYPE= data[0]["LOGIN_TYPE"];
//    		alert("LOGIN_TYPE:-"+LOGIN_TYPE);
    		LOGIN_SCOPE= data[0]["LOGIN_SCOPE"];
//    		alert("LOGIN_SCOPE:-"+LOGIN_SCOPE);
    		var MFA_TYPE= data[0]["MFA_TYPE"];
//    		alert("MFA_TYPE:-"+MFA_TYPE);
    		var FIRST_LOGIN= data[0]["FIRST_LOGIN"];
//    		alert("FIRST_LOGIN:-"+FIRST_LOGIN);
    		USERNAME= data[0]["USERNAME"];
//    		alert("USERNAME:-"+USERNAME);
    		
//    		var LASTLOGIN= data[0]["LASTLOGIN"];
//    		alert("LASTLOGIN:-  "+LASTLOGIN);
    
//    		if (LASTLOGIN ==="false" && (ROLE ==="Tester" || ROLE ==="Developer" ) ) {
//  		
//    			swal({
//    			    title: "Unsuccessful!",
//    			    html: "Your account is deactivated due to 3 days of inactivity! <br><br> Request your Team Leader/Manager to activate your account",
//    			    type: "warning",
//    			    width: 350,
//    			    showCancelButton: true,
//    			    confirmButtonClass: "btn btn-primary mr-4",
//    			    confirmButtonText: "OK",
//    			    cancelButtonClass: "btn btn-warning",
//    	//		    cancelButtonText: "Request Activation",
//   		    	cancelButtonText: "Send Mail",
//    			    buttonsStyling: false
//    			}).then((result) => {
//    			    if (result.isConfirmed) {
//    			        // Action for OK button
//    			    	console.log("OK button clicked");
//    			    } else if (result.dismiss === swal.DismissReason.cancel) {
//    			        // Action for Request Activation button
//    			        console.log("Request Activation button clicked");
//    			    }
//    			}).catch(error => {
//    				if (error === "cancel") {
//    					// Handle the cancellation or dismissal action here if needed
//    					sendMail();
//    					}
//    					});
//    		} else 
    			
    			
    			if(DB_VERIFICATION.includes("fail")){
	
	 swal({
                            title: "Unsuccessful!",
                            text: "Username or Password is Invalid!",
                            type: "error",
                            width: 300,
                            confirmButtonClass: "btn btn-success",
                            confirmButtonText: "OK",
                            
                        })
                        
                        $('#name').val('');
    				$('#password').val('');
//    				$('#companycode').val('');
    				$('input[type=checkbox]').prop("checked", false);
	
} 
    		
    		if(DB_VERIFICATION.includes("nocompanycode")){
    			
    			 swal({
    		                            title: "Unsuccessful!",
    		                            text: "Company Code is Invalid",
    		                            type: "error",
    		                            width: 300,
    		                            confirmButtonClass: "btn btn-success",
    		                            confirmButtonText: "OK",
    		                            
    		                        })
    		}  else if(DB_VERIFICATION.includes("success") ) {
	
//	alert("in success")
	var MFA_TYPE= data[0]["MFA_TYPE"];
	var FIRST_LOGIN=data[0]["FIRST_LOGIN"];
	
	if(MFA_TYPE.includes("SMS")){
		
		var html2="";
//				alert("SMS");
				
//						html2 += '<button class="btn btn-success" id="verifybtn" onclick="verifyOTP(\'' + USERNAME + '\',\''+FULLNAME+  '\',\''+ ROLE + '\',\'' + LOGIN_TYPE +'\',\'' + LOGIN_SCOPE +'\')">Verify</button>';
//				html2 += "<button class='btn btn-success' id='verifybtn' onclick='verifyOTP(\"" + loginObj + "\")'>Verify</button>";
				html2 += '<button class="btn btn-success" id="verifybtn" onclick="ClickAction();">Verify</button>';
				//html2 += '<button type="button" class="btn btn-success" id="verifybtn" onclick="verifyOTP('+USERNAME+')">Verify</button>';		
						
						$("#verifyDiv").html(html2);
				
    		$("#getCodeModal").modal('show');
    		 
    		
    	 document.getElementById("getCode").style.display = "none";
    		 
		
		
	} else if(MFA_TYPE.includes("GoogleAppAuthentication")){
		
		if(FIRST_LOGIN.includes("yes")){
			
		
			
			var html = "";
			var html2="";
    		
    	var l = window.location;
				var base_url = l.protocol + "//" + l.host + "/"
						+ l.pathname.split('/')[1];
				var serviceUrl2 = base_url + "/login/getParticularImage";

				
				html += '<img id="qrcodeImage" src="' + serviceUrl2+ '"  alt="No Photograph"  width="100%" height="100%">';
				
			console.log("html value " + html);
			
			$("#getCode").html(html);		
//			alert("JSON: "+loginObj.LOGIN_SCOPE)
//				alert(JSON.stringify(loginObj))
//						html2 += '<button class="btn btn-success" id="verifybtn" onclick="verifyOTP(\'' + USERNAME + '\',\''+FULLNAME+  '\',\''+ ROLE + '\',\'' + LOGIN_TYPE +'\',\'' + LOGIN_SCOPE +'\');">Verify</button>';
			html2 += '<button class="btn btn-success" id="verifybtn" onclick="ClickAction();">Verify</button>';
				//html2 += '<button type="button" class="btn btn-success" id="verifybtn" onclick="verifyOTP('+USERNAME+')">Verify</button>';		
 						$("#verifyDiv").html(html2); 
    		$("#getCodeModal").modal('show');
    		 
    } if(FIRST_LOGIN.includes("no")){ 
			var html2="";
				//alert("isNotFirstLogin");
				
//						html2 += '<button class="btn btn-success" id="verifybtn" onclick="verifyOTP(\'' + USERNAME + '\',\''+FULLNAME+  '\',\''+ ROLE + '\',\'' + LOGIN_TYPE +'\',\'' + LOGIN_SCOPE +'\')">Verify</button>';
//			html2 += "<button class='btn btn-success' id='verifybtn' onclick='verifyOTP("+loginObj+")'>Verify</button>";
			html2 += '<button class="btn btn-success" id="verifybtn" onclick="ClickAction();">Verify</button>';
				//html2 += '<button type="button" class="btn btn-success" id="verifybtn" onclick="verifyOTP('+USERNAME+')">Verify</button>';		
 						$("#verifyDiv").html(html2); 
    		$("#getCodeModal").modal('show');  
    	 document.getElementById("getCode").style.display = "none";
    	 document.getElementById("headerID").style.display = "none";
    	 document.getElementById("enterOTPHeader").style.display = "block";
    		
		}if(FIRST_LOGIN.includes("NA")){
		
		}
	
	} else if(MFA_TYPE.includes("OFF")){
		
//		alert("in off")
		
		
    	 if(ROLE.includes("Admin") || ROLE.includes("admin")){
    			//	alert("in admin if block")
    				
    				var l = window.location;
														var base_url = l.protocol
																+ "//"
																+ l.host
																+ "/"
																+ l.pathname
																		.split('/')[1];
														window.location.href = base_url
																+ "/Admin/AdminHome";
																
																
																
    			}
    			
else if(ROLE.includes("User") ||ROLE.includes("user")){
	//alert("in  user")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

// new add
else if(ROLE.includes("MD") ||ROLE.includes("MD")){
	//alert("in  user")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

else if(ROLE.includes("Accounts") ||ROLE.includes("Accounts")){
	//alert("in  user")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Admin/AdminHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

else if(ROLE.includes("Sales") ||ROLE.includes("Sales")){
	//alert("in  user")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Admin/AdminHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

else if(ROLE.includes("Manager") ||ROLE.includes("Manager")){
	//alert("in  user")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Admin/AdminHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

else if(ROLE.includes("Implementor") ||ROLE.includes("Implementor")){
	//alert("in  user")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Admin/AdminHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

//else if((ROLE.includes("Developer") || ROLE.includes("Developer")) && LASTLOGIN ==="true"){
else if(ROLE.includes("Developer") ){
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Admin/AdminHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}
    	 
//else if((ROLE.includes("Tester") ||ROLE.includes("Tester")) && LASTLOGIN ==="true"){
else if(ROLE.includes("Tester") ){			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Admin/AdminHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}    	 


else if(ROLE.includes("Support") ||ROLE.includes("Support")){
//	alert("in  Support")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Admin/AdminHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}
    	 
else if(ROLE.includes("Business_Head") ||ROLE.includes("Business_Head")){
//	alert("in  Support")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/User/UserHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}
    	 

else if(ROLE.includes("Head_Projects") ||ROLE.includes("Head_Projects")){
//	alert("in  Support")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Admin/AdminHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}

else if(ROLE.includes("Account") ||ROLE.includes("Account")){
//	alert("in  Account")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Admin/AdminHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}


//else if(ROLE.includes("HR") ||ROLE.includes("HR")){
////	alert("in  HR_EXECUTIVE")
//			
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl23 = base_url + "/Admin/AdminHome";
//	//alert(serviceUrl23)
//	window.location.href = serviceUrl23;
//	
//}
    	 
    	 
else if(ROLE.includes("HR") ||ROLE.includes("HR")){
//	alert("in  HR_EXECUTIVE")
			
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Admin/HRHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
	
}



else if(ROLE.includes("engineer") ||ROLE.includes("Engineer")){
	//alert("in  user")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/Engg/EnggHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
}
    			
else if(ROLE.includes("IT-Head") ){
//	alert("in  user")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/ITHead/IT-HeadHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
}
    
else if(ROLE.includes("Ticket Co-ordinator") ){
	//alert("in  user")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl23 = base_url + "/TP/TPHome";
	//alert(serviceUrl23)
	window.location.href = serviceUrl23;
}    
		} 
	} 
    		
    		
    		
   })
    	
    	}
    }	

function ClickAction(){
//	alert("Clicked Verify")
//	alert(LOGIN_SCOPE)
	var login_data = new Array();
	login_data.push(USERNAME);
	login_data.push(FULLNAME);
	login_data.push(ROLE);
	login_data.push(LOGIN_TYPE);
	login_data.push(LOGIN_SCOPE);
	verifyOTP(login_data);
}

$('.forgot-password').click(function() {
    var serviceUrl = getBaseURL() + "forgot/forgotPassword";
    window.location.href = serviceUrl;
});

//$('.register-member').click(function() {
//    var serviceUrl = getBaseURL() + "register/show";
//    window.location.href = serviceUrl;
//});


function setPassw()
{
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href =base_url+"/login/setnewPassword"; 
}

// Get the input field
var input1 = document.getElementById("enterbtn");
// Execute a function when the user releases a key on the keyboard
input1.addEventListener("keyup", function(event) {

  // Number 13 is the "Enter" key on the keyboard
  if (event.keyCode === 13) {
    // Cancel the default action, if needed
    event.preventDefault();
    // Trigger the button element with a click
    document.getElementById("login-button").click();
  }
});
function submitfocus(){
//    alert("changed");
    $('#login-button').focus();
}



//
function sendMail(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/login/sendMail";
	$.ajax({
		url : serviceUrl,
		type : 'POST',   		
		data: 'name=' + $('#name').val()  
		
	}).done(function (data) {
		if(data=="Success"){
			swal({
			    title: "Successful!",
			    html: "Request has been sent for Re-Activation",
			    type: "warning",
			    width: 350,
			    confirmButtonClass: "btn btn-primary mr-4",
			    confirmButtonText: "OK",
			    buttonsStyling: false
			})
		}else{
			swal({
			    title: "Unsuccessful!",
			    html: "Request is already sent for Re-Activation",
			    type: "warning",
			    width: 350,
			    confirmButtonClass: "btn btn-primary mr-4",
			    confirmButtonText: "OK",
			    buttonsStyling: false
		})
	}
	})
}
//




//29/08
function setPassword()
{
//	alert("inside setPassword()");
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  window.location.href =base_url+"/login/forgetPassword"; 
}
//
//



