
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Reset Password</title>
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
<body class="hold-transition login-page">
<div class="login-box">
<!--   <div class="login-logo"> -->
<!--     <a href="../../index2.html"><b>Admin</b>LTE</a> -->
<!--   </div> -->
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">
      <img src="<%=request.getContextPath()%>/static/resources/img/newimg/Velox_Logo_Product_ITHelpdesk.png" style="width:100%" alt="logo">
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
       
        <div class="input-group mb-3">
          <select id="usertype" class="form-control" tabindex="2" name="usertype" onchange="submitfocus()">
                                <option value=''>Please Select User Type</option>
                                <option value='User'>User</option>
                                 <option value='Engineer'>Engineer</option>
                                 <option value='Ticket Co-ordinator'>Ticket Co-ordinator</option>
                                <option value='Admin'>Admin</option>
                                <option value='IT-Head'>IT-Head</option>
                               
                                <!--<option value='SuperAdmin'>SuperAdmin</option>-->
                            </select>
        </div>
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
             
            </div>
          </div>
          <!-- /.col -->
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
                            <strong>&nbsp;&nbsp;Please Enter the OTP Send to your Registered Mobile Number ending with&nbsp;&nbsp;<span id="phoneno"></span></strong>
                        </div>
                       
                        <div class="form-group">
                           
                            <div id="otpno"></div>
                            <input class="form-control" tabindex="1" type="text" name="otp" id="otp" placeholder="Please Enter OTP">

                        </div>
                        
                       <div class="row">
          <div class="col-7">
           
          </div>
          <!-- /.col -->
          <div class="col-5">
                            <button id="checkOTP" type="submit" tabindex="2" class="btn btn-primary btn-block">Validate OTP</button>
                        </div>
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
                            <input class="form-control" tabindex="2" onfocusout="checkPassupdate();" type="password" name="cnfpass" id="cnfpass" placeholder="Please Enter Confirm Password" onkeyup="checkPassupdate123()">
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

<script src="<%=request.getContextPath()%>/static/Login/setnewpass.js"></script>
</body>
</html>
