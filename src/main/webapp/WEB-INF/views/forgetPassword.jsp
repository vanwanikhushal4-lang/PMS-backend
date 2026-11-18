
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>SCM Login</title>
  <link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
<!--   <!-- Ionicons --> 
<!--   <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"> -->
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/static/AdminLTE_3/dist/css/adminlte.min.css">
  <!-- Sweetalert 2 -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.css">
  <!-- Google Font: Source Sans Pro -->
<!--   <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet"> -->
</head>
<style>

@media screen and (max-width: 768px){
    #Hide3iLogo {
    display: none;
    
} 
	#Show3iLogo {
	display: block;
}
}

@media screen and (min-width: 768px){
    #Hide3iLogo {
    display: block;
    
} 
	#Show3iLogo {
	display: none;
}
/* .login-page{ */
<%-- background-image: url('<%=request.getContextPath()%>/static/resources/img/3i-BG.png'); --%>
/* background-repeat: no-repeat; */
/* background-size: cover; */
/* } */
}



#timer {
  font-size: 14px;
  color: #ff0000; 
}

</style>

<body class="hold-transition login-page">

<div class="login-box">
<!--   <div class="login-logo"> -->
<!--     <a href="../../index2.html"><b>Admin</b>LTE</a> -->
<!--   </div> -->
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">
      <img src="<%=request.getContextPath()%>/static/resources/img/veloxlogo.png" style="width:50%" alt="logo">
      </p>
      

                    <div id="forgotpass">
                    <p style="text-align:center"><b>Forgot Password</b></p>
                    
        <div class="input-group mb-3">
          <input type="text" class="form-control" name="name" id="name" placeholder="Username" tabindex="1">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
       
<!--         <div class="input-group mb-3" style="display:none"> -->
<!--           <select id="usertype" class="form-control" tabindex="2" name="usertype" onchange="submitfocus()"> -->
<!--                                 <option value=''>Please Select User Type</option> -->
<!--                                 <option value='User'>User</option> -->
<!--                                  <option value='Engineer'>Engineer</option> -->
<!--                                  <option value='Ticket Co-ordinator'>Ticket Co-ordinator</option> -->
<!--                                 <option value='Admin'>Admin</option> -->
<!--                                 <option value='IT-Head'>IT-Head</option> -->
                               
<!--                                 <option value='SuperAdmin'>SuperAdmin</option> -->
<!--                             </select> -->
<!--         </div> -->
        <div class="row">
<!--           <div class="col-4"> -->
<!--             <div class="icheck-primary"> -->
             
<!--             </div> -->
<!--           </div> -->
          <!-- /.col -->
           <div class="col-4">
          	
            <a href="/SCM/login/backToLogin" class="text-primary">Back to Login</a> 
          </div>
          
          <div class="col-4">
            <div class="icheck-primary">
             
            </div>
          </div>
          
          <div class="col-4">
          	
            <button type="submit" class="btn btn-primary btn-block" id="resetPass" tabindex="3">Send OTP</button>
          </div>
           
          <!-- /.col -->
        </div>
        <input type="hidden" id="phone" name="phone">
        </div>
        
		<div id="otpdiv" style="display: none;">
                        <h5 class="text-center">One Time Password</h5>
                        <div class="form-group" style="font-size: 14px;color: red;">
                            <center><strong>&nbsp;&nbsp;&nbsp;Please Enter the OTP sent to <span id="emailId"></span></strong></center>
                        </div>
                       
                        <div class="form-group">
                           
                            <div id="otpno"></div>
                            <!-- //02/09 -->
                            
                            <!--  -->
                            <input class="form-control" tabindex="1" type="text" name="otp" id="otp" placeholder="Please Enter OTP">

                        </div>
                        
                       <div class="row">
          <div class="col-md-1">
           
          </div>
          <!-- /.col -->
          <div class="col-5" style="display: flex; justify-content: space-between;">
    			<span id="timer">Time remaining: <span id="countdown">05:00</span></span></div>
    		<div class="col-5" style="display: flex; justify-content: space-between;">	
    		<button id="checkOTP" type="submit" tabindex="2" class="btn btn-primary btn-block">Validate OTP</button></div>
 <div class="col-md-1">
           
          </div>
          
          <br>
          <br>
          <!-- //02/09 -->
<!--           <div class="form-group qr-code" id="qrCodeDiv"> -->
          
<!--             <p style="text-align: center;">Or scan the QR code to verify</p> -->
<!--             <div id="scanner" style="width: 300px; height: 300px;"></div> -->
            
<!--             <button id="startScan" class="btn btn-primary btn-block">Scan QR Code</button> -->
            
<!--           </div> -->
          <!--  -->


                       </div> 
                    </div>
                    
                         <div id="resetPassw" style="display: none;">
                        <h5 class="text-center">Reset Password</h5>
                       
                       
                        <div class="form-group">
                            <label for="username" style="font-size:12px;" class="text-uppercase">New Password</label>&nbsp;&nbsp;&nbsp;<label id="labelupdate"></label>
                            <input class="form-control" tabindex="1" minlength="8" maxlength="15" onfocusout="checkPassstrengthupdate();" type="password" name="pass" id="pass" placeholder="Please Enter Password">
                            <span id="noteupdate" style="display:none; font-size: 12px" class="text-danger">Password length must be Min 8 characters & Max 15 characters. and  must contain at least one small & one capital alphabet & one special character and numeric digit.</span>
                        </div>
                        
                        <div class="form-group">
                            <label for="username" style="font-size:12px;" class="text-uppercase">Confirm Password</label>
                            <input type="hidden" id="passnotmatchupdate">
                            <input class="form-control" tabindex="2" minlength="8" maxlength="15" onfocusout="checkPassupdate();" type="password" name="cnfpass" id="cnfpass" placeholder="Please Enter Confirm Password" onkeyup="checkPassupdate123()">
                            <span id="note1update" style="display:none;"></span>
                        </div>
                        
                        <div class="row">
          <div class="col-8">
            
          </div>
          <!-- /.col -->
          <div class="col-4">
                            <button id="setPass" type="submit" tabindex="3" class="btn btn-primary btn-block">Submit</button>
                        </div>
                        </div>
                    </div>

    </div>
    <!-- /.login-card-body -->
  </div>
</div>


<!-- //02/09 -->
<script>
//     function checkCamera() {
//     	navigator.mediaDevices.enumerateDevices().then(devices => {
//     	      const hasCamera = devices.some(device => device.kind === 'videoinput');
//     	      const qrCodeDiv = document.getElementById('qrCodeDiv');
//     	      const startScanButton = document.getElementById('startScan');
    	      
//     	      if (hasCamera) {
//     	        qrCodeDiv.style.display = 'block';
//     	        if (startScanButton) {
//     	          startScanButton.style.display = 'block';
//     	        }
//     	      } else {
//     	        qrCodeDiv.style.display = 'none';
//     	        if (startScanButton) {
//     	          startScanButton.style.display = 'none';
//     	        }
//     	      }
//     	    });
//     }


//     function startScanning() {
//         const html5QrCode = new Html5Qrcode("scanner");
//         html5QrCode.start(
//           { facingMode: "environment" }, // or "user" for front camera
//           { fps: 10, qrbox: 250 },
//           (decodedText, decodedResult) => {

// //             alert(`QR Code scanned: ${decodedText}`);
    
//             document.getElementById('otp').value = decodedText;
//             html5QrCode.stop();
//             document.getElementById('scanner').style.display = 'none';
//           },
//           (errorMessage) => {
      
//             console.log(`QR Code scan error: ${errorMessage}`);
//           }
//         ).catch(err => {
//           console.error(`Error starting QR Code scan: ${err}`);
//         });
//       }

//       document.addEventListener('DOMContentLoaded', () => {
//     	  checkCamera();
//     	    const startScanButton = document.getElementById('startScan');
//     	    if (startScanButton) {
// //         	    alert("inside startScanButton");
//     	      startScanButton.addEventListener('click', startScanning);
//     	    }
//       });
    

//     // Example: Set QR code source when OTP is sent
//     function setQRCodeImage(url) {
//       document.getElementById('qrCodeImg').src = url;
//     }

    // For demonstration purposes only, should be set dynamically
    // Example: setQRCodeImage('data:image/png;base64,...'); // Replace with actual QR code URL
  </script>
<!--  -->



<!-- /.login-box -->

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<!-- <script src="../../dist/js/adminlte.min.js"></script> -->
 <!-- Sweetalert 2 -->
<script src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.js"></script>
<script src="<%=request.getContextPath()%>/static/resources/sweetAlert/sweetalert2.min.js"></script>

<!-- //02/09 -->
<script src="https://unpkg.com/html5-qrcode/minified/html5-qrcode.min.js"></script>
<!--  -->

<script src="<%=request.getContextPath()%>/static/custom/forgetPassword.js"></script> 
</body>
</html>
