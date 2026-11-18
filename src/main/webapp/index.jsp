
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

</style>

<body class="hold-transition login-page">


<div class="modal fade" id="getCodeModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<strong id="headerID"> Scan and Get OTP</strong>
					<strong id="enterOTPHeader" style="display: none;"> Enter OTP</strong>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>


				</div>
				<div class="modal-body" id="getCode" style="overflow-x: hidden;">
					
						<%-- <img alt="image missing" width="100%" height="100%" src="<%=request.getContextPath()%>/static/images/Barcode.png"> --%> 
						
						
						
		
						
						
						
						
						
			
				
					<div></div>
				</div>
				<div class="modal-footer">
					<div class="row">
						<div class="col-md-8">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Please Enter OTP" id="txtotp" name="txtotp" />

							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group" id="verifyDiv">

								<!-- <button type="button" class="btn btn-success" id="verifybtn"
									onclick="verifyOTP()">Verify</button> -->
							</div>
						</div>
					</div>



				</div>
			</div>
		</div>
	</div>

<div class="login-box">
<!--   <div class="login-logo"> -->
<!--     <a href="../../index2.html"><b>Admin</b>LTE</a> -->
<!--   </div> -->
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">
      
      <div class="text-center" id="Show3iLogo">
      <div class="row">
      <div class="col-md-12">
      <img src="<%=request.getContextPath()%>/static/resources/img/veloxlogo.png" style="width:50%" alt="logo">
      </div>
      </div>
      <div class="row">
     <div class="col-md-12">
<%--       <img src="<%=request.getContextPath()%>/static/resources/img/newimg/Velox_Logo_Product_ITHelpdesk.png" style="width:100%; margin-top: 15px" alt="logo"> --%>
      </div>
      </div>
      </div>
      
      <div class="row"  id="Hide3iLogo">
     <div class="col-md-12">
<%--       <img src="<%=request.getContextPath()%>/static/resources/img/newimg/Velox_Logo_Product_ITHelpdesk.png" style="width:100%; margin-top: 15px" alt="logo"> --%>
      <img src="<%=request.getContextPath()%>/static/resources/img/veloxlogo.png" style="width:100%; margin-top: 15px" alt="logo"> 
      </div>
      </div>
      </p>
      
<p style="text-align:center"><b>Login</b></p>


<!--     <div class="input-group mb-3"> -->
<!--             <div> -->
<!--            	    <input type="checkbox" id="activitydash" name="activitydash" value="false" style="margin-left: 5px;margin-top: 13px" />&nbsp;&nbsp;&nbsp; Sign In with AD User -->
<!-- 				<input  type="hidden" id="activitydash" name="activitydash" value="false" /> -->
<!--        			<input type="hidden" name="activitydash22" style="width:100px;" id="activitydash22" value=""/> -->
<!--             </div> -->
<!--         </div> -->
        
        <div class="input-group mb-3">
        <input type="text" class="form-control" name="name" id="name" placeholder="Username" tabindex="1">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        
<!--         <div class="input-group mb-3"> -->
<!--           <input type="password" class="form-control" id="password" name="password" placeholder="Password" tabindex="2"> -->
<!--           <div class="input-group-append"> -->
<!--             <div class="input-group-text"> -->
<!--               <span class="fas fa-lock"></span> -->
<!--             </div> -->
<!--           </div> -->
<!--         </div> -->

<div class="input-group mb-3">
  <input type="password" class="form-control" id="password" name="password" placeholder="Password" tabindex="2">
  
  <div class="input-group-append">
    <div class="input-group-text">
      <span class="fas fa-eye" id="togglePassword" style="cursor: pointer;"></span>
    </div>
  </div>
</div>
        
        <div class="input-group mb-3">
          <input type="text" class="form-control" id="companycode" name="companycode" placeholder="Company Code" tabindex="3" value="vspl" readonly>
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-building"></span>
            </div>
          </div>
        </div>	
<!--         <div class="input-group mb-3"> -->
<!--           <select id="usertype" class="form-control" tabindex="3" name="usertype" onchange="submitfocus()" style="border: 1px solid; border-color: #0000002b;"> -->
<!--                                 <option value='vlx'>Please Select User Type</option> -->
<!--                                 <option value='User'>User</option> -->
<!--                                  <option value='Engineer'>Engineer</option> -->
<!--                                  <option value='Ticket Co-ordinator'>Ticket Co-ordinator</option> -->
<!--                                 <option value='Admin'>Admin</option> -->
<!--                                 <option value='IT-Head'>IT-Head</option> -->
                               
<!--                                 <option value='SuperAdmin'>SuperAdmin</option> -->
<!--                             </select> -->
<!--         </div> -->
<!--         <div class="row"> -->
<!-- <!--           <div class="col-3"> -->
<!-- <!--            <div> -->
<!-- <!--            	    <input type="checkbox" id="activitydash" name="activitydash" value="false" style="margin-left: 5px;margin-top: 13px" /> AD --> 
<!-- <!-- 				<input  type="hidden" id="activitydash" name="activitydash" value="false" /> -->
<!-- <!--        			<input type="hidden" name="activitydash22" style="width:100px;" id="activitydash22" value=""/> -->
<!-- <!--             </div> --> 
<!-- <!--           </div> -->
          
<!--        <div class="col-5"> -->
<!--             <div class="icheck-primary">
<!--               <a href="#" onclick="setPassw()">Forgot Password</a> -->
<!--             </div> --> 
<!--           </div>  -->
          
<!--           /.col -->
<!--           <div class="col-7"> -->
<!--             <button type="submit" class="btn btn-primary btn-block" id="login-button" tabindex="4" onclick="LoginSign()">Sign In</button> -->
<!--           </div> -->
<!--           /.col -->
<!--         </div> -->
	<div class="row"><br>
	
	

<!--           <div class="col-md-6 text-center" style="display:flex;justify-content:space-evenly;"> -->
<!--         <a href="#" onclick="setPassword()" class="text-primary">Forgot Password?</a><br> -->
<!--           	 </div> -->


			 <div class="col-md-6 text-center" style="display:flex;justify-content:space-evenly;">
        <a href="#" onclick="setPassword()" class="text-primary">Forgot Password?</a><br>
          	 </div>
           
           <div class="col-md-6 text-center" style="display:flex;justify-content:space-evenly;">
           
            <button type="submit" class="btn btn-primary m-t-10" id="login-button" tabindex="4" onclick="LoginSign()">Sign In</button></div>
            
            
            </div>
            
            
            
            
<!--             <div class="col-md-12 text-center"> -->
<!-- 				<a href="#" onclick="setPassword()" class="text-primary">Forgot&nbsp;Password?</a>             -->
<!-- 			</div> -->
<!--           </div> -->
          <!-- /.col -->
      


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

<script src="<%=request.getContextPath()%>/static/Login/login.js"></script> 
</body>
</html>
