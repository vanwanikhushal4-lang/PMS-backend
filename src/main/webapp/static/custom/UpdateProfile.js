   var LOCATION="";
                    var BRANCH="";
                    var DEPARTMENT="";
                    var CONTACT="";
                    var SUBDEPARTMENT="";
window.onload = function() {
	
	
//	$("#notification_icon").hide();

          var l = window.location;
                var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                var serviceUrl = base_url + "/UserActivity/getUserDetailsForUpdate";
           
            $.ajax({

                type : 'POST',
                url :serviceUrl,
                dataType: 'json',
                        async:false,
            }).done(function(data) {
				//alert(data)
                            LOCATION=data[0]["LOCATION"];
                            BRANCH=data[0]["BRANCH"];
                     DEPARTMENT=data[0]["DEPARTMENT"];
                     CONTACT=data[0]["CONTACT"];
                     SUBDEPARTMENT=data[0]["SUBDEPARTMENT"];
            
               $('#fname').val(data[0]["FIRSTNAME"]);
          
               $('#cname').val(data[0]["COMPANY"]);
        
               $('#username').val(data[0]["USERNAME"]);
               $('#lname').val(data[0]["LASTNAME"]);
               $('#designation').val(data[0]["DESIGNATION"]);

               $('#mail').val(data[0]["EMAIL"]);
               $('#cno').val(data[0]["CONTACT"]);
       //   alert(LOCATION)
        //  alert(data[0]["COMPANY"])
                   var l = window.location;
                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                         var serviceUrl = base_url + "/Master/getBranchForLoginMastersInsert";
             $.ajax({
                 type: 'POST',
                 url: serviceUrl,
                 dataType: 'json',
                 async:false,
                 data: 'companyname=' + encodeURIComponent(data[0]["COMPANY"])+'&location=' + encodeURIComponent(LOCATION),
                 success: function(data4) {

                            var html = "  <option value=''> -- Please Select --</option>";
                            for (var i = 0; i < data4.length; i++) {
//                                alert(data4[i]);
                                html += '<option value="' + data4[i] + '">' + data4[i]
                                        + '</option>';
                            }

                            document.getElementById("sname").innerHTML = html;
                            $('#sname').val(BRANCH);
                     }

                     
             });
             ////////////////setting location details///////////
             var l = window.location;
                   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                   var serviceUrl = base_url + "/Master/getLocationForLoginMaster";
             
              $.ajax({
                  type: 'POST',
                  url: serviceUrl,
                  dataType: 'json',
                  async:false,
                     data: 'companyname=' + encodeURIComponent(data[0]["COMPANY"]),
                  success: function(data4) {
                             var html = "  <option value=''> -- Please Select --</option>";
                             for (var i = 0; i < data4.length; i++) {
//                                 alert(data4[i]);
                                 html += '<option value="' + data4[i] + '">' + data4[i]
                                         + '</option>';
                             }

                             document.getElementById("location").innerHTML = html;
                             $('#location').val(LOCATION);
                      }

                      
              });
              /////////////////////////Dept/////////////////
              var l = window.location;
                   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                   var serviceUrl = base_url + "/Master/getDepartmentForLoginMaster";
               $.ajax({
                   type: 'POST',
                   url: serviceUrl,
                   dataType: 'json',
                   async:false,
                   data: 'companyname=' + encodeURIComponent(data[0]["COMPANY"])+ '&branchName=' + encodeURIComponent(data[0]["BRANCH"])+ '&location=' + encodeURIComponent(data[0]["LOCATION"]),
                   success: function(data4) {
                              var html = "  <option value=''> -- Please Select --</option>";
                              for (var i = 0; i < data4.length; i++) {
//                                  alert(data4[i]);
                                  html += '<option value="' + data4[i] + '">' + data4[i]
                                          + '</option>';
                              }

                              document.getElementById("dname").innerHTML = html;
                              $('#dname').val(DEPARTMENT);
                       }

                       
               });
               //////////////SubDepartment/////////////////
               var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     var serviceUrl = base_url + "/Master/getSubDepartmentForLoginMaster";
               
                $.ajax({
                    type: 'POST',
                    url: serviceUrl,
                    dataType: 'json',
                       data: 'companyname=' + encodeURIComponent(data[0]["COMPANY"])+ '&branchName=' + encodeURIComponent(data[0]["BRANCH"])+ '&departmentName=' + encodeURIComponent(data[0]["DEPARTMENT"])+ '&location=' + encodeURIComponent(data[0]["LOCATION"]),
                    success: function(data4) {

                               var html = "  <option value=''> -- Please Select --</option>";
                               for (var i = 0; i < data4.length; i++) {
//                                   alert(data4[i]);
                                   html += '<option value="' + data4[i] + '">' + data4[i]
                                           + '</option>';
                               }

                               document.getElementById("subDepartment").innerHTML = html;
                               $('#subDepartment').val(SUBDEPARTMENT);
                        }

                        
                });
              
             
            });   
            
            getSiteDetails();
            getLocation();
           
            
 }
 function getSiteDetails() {
          //  alert("comp in site"+$("#cname").val());
         //   alert($("#location").val());
                 var l = window.location;
                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                         var serviceUrl = base_url + "/Master/getBranchForLoginMastersInsert";
             $.ajax({
                 type: 'POST',
                 url: serviceUrl,
                 dataType: 'json',
                 async:false,
                 data: 'companyname=' + encodeURIComponent($("#cname").val())+'&location='+encodeURIComponent($("#location").val()),
                 success: function(data4) {

                            var html = "  <option value=''> -- Please Select --</option>";
                            for (var i = 0; i < data4.length; i++) {
//                                alert(data4[i]);
                                html += '<option value="' + data4[i] + '">' + data4[i]
                                        + '</option>';
                            }

                            document.getElementById("sname").innerHTML = html;
                            $('#sname').val(BRANCH);
                     }

                     
             });
        }
function getLocation(){    
         var l = window.location;
          var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
          var serviceUrl = base_url + "/Master/getLocationForLoginMaster";
          
    
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
            data: 'companyname=' + encodeURIComponent($("#cname").val()),
         success: function(data4) {
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("location").innerHTML = html;
                    $('#location').val(LOCATION);
             }

             
     });

}//
function getDeptDetails() {
// alert($("#cname").val());
//   alert($("#sname").val());
 // alert($("#location").val());
    
        var l = window.location;
         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
         var serviceUrl = base_url + "/Master/getDepartmentForLoginMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + encodeURIComponent($("#cname").val())+ '&branchName=' + encodeURIComponent($("#sname").val())+ '&location=' + encodeURIComponent($("#location").val()),
         success: function(data4) {
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("dname").innerHTML = html;
                    $('#dname').val(DEPARTMENT);
             }

             
     });
    // getsubdepartment();
}
 
 
 function getsubdepartment(){
        
        
         var l = window.location;
          var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
          var serviceUrl = base_url + "/Master/getSubDepartmentForLoginMaster";
    
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
            data: 'companyname=' + encodeURIComponent($("#cname").val())+ '&branchName=' + encodeURIComponent($("#sname").val())+ '&departmentName=' + encodeURIComponent($("#dname").val())+ '&location=' + encodeURIComponent($("#location").val()),
         success: function(data4) {

                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("subDepartment").innerHTML = html;
                    $('#subDepartment').val(SUBDEPARTMENT);
             }

             
     });
     

 
 
 }
// submit-btn
 var callToolTip231 = function (fieldName, status) {

    if (fieldName === "sname") {
       var errorMessage = "<span>Please Select Branch<span>";
   }
   else if (fieldName === "location") {
       var errorMessage = "<span>Please Select Location<span>";
   }
   else if (fieldName === "dname") {
       var errorMessage = "<span>Please Select Department<span>";
   }
   
    else if (fieldName === "subDepartment") {
        var errorMessage = "<span>Please Select SubDepartment<span>";
    }
    
    else if (fieldName === "cno") {
        var errorMessage = "<span>Please Enter Phone Number<span>";
    }
    
   

   $("#" + fieldName).tooltip({
       trigger: 'manual',
       placement: 'top',
       title: errorMessage,
       animation: true,
       delay: 1000,
       html: true,
        at:'center'
   });
   if (status == "show") {
       $("#" + fieldName).tooltip('show');
   } else {
       $("#" + fieldName).tooltip('hide');
   }
}

 function validateProfileUpdate()
 {

         
     var indexError = 0; 
 
   if ($('#sname').val().trim() === '') {
       console.log('fill requestmode');
       callToolTip231('sname', 'show');

       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
  
 
   if ($('#location').val().trim() === '') {
       console.log('fill description');
       callToolTip231('location', 'show');

       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   if ($('#dname').val().trim() === '') {
       console.log('fill description');
       callToolTip231('dname', 'show');

       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   if ($('#subDepartment').val().trim() === '') {
       console.log('fill description');
       callToolTip231('subDepartment', 'show');

       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }

   if ($('#cno').val().trim() === '') {
       console.log('fill description');
       callToolTip231('cno', 'show');

       if (indexError == 0) {

       }
       indexError = indexError + 1;
       
   } 
   
  console.log("validation error count::::"+indexError);
if (indexError != 0) {

//   alert("false");
       return false;

   } else {


       return true;
   }


 }
 $('#sname').on('focus', function() {
            callToolTip231('sname', 'destroy');
        });

        $('#location').on('focus', function() {
            callToolTip231('location', 'destroy');
        });
        $('#dname').on('focus', function() {
            callToolTip231('dname', 'destroy');
           // callToolTip231('fname1', 'destroy');
        });
        
        $('#subDepartment').on('focus', function() {
                callToolTip231('subDepartment', 'destroy');
          //  callToolTip231('mail', 'destroy');
        });
        $('#cno').on('focus', function() {
            callToolTip231('cno', 'destroy');
           // callToolTipWrong('phnnno', 'hide');
        });
// function phonenumber() {
//            var inputtxt = $('#cno').val();
//            console.log(inputtxt)
//            var phoneno = /^\d{10}$/;
//        //  var phoneno = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
//            if (inputtxt.match(phoneno))
//            {
//                return true;
//            }
//            else
//            {
//                callToolTipWrong('phnnno', 'show');
//                return false;
//            }
//        }

 $("#submit-btn").click(function() {
         //   alert("submit-btn click");
           if (!validateProfileUpdate()) {
          
                event.preventDefault();
            } else {
                
               // alert("valid");
                saveDataUser();
          }
        });

function saveDataUser() {
        // alert($("#username").val()+"gtf"+ $("#cname").val())
        var l = window.location;
         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
         var serviceUrl = base_url + "/UserActivity/updateLoginUserProfile";
    $.ajax({
        url: serviceUrl,
        type: 'post',
        data :'BranchName='+encodeURIComponent($("#sname").val())+'&location='+encodeURIComponent($("#location").val())
       + '&dname='+encodeURIComponent($("#dname").val())+'&subDepartment='+encodeURIComponent($("#subDepartment").val())
       + '&mail='+encodeURIComponent($("#mail").val())+'&cno='+encodeURIComponent($("#cno").val())
       +'&username='+encodeURIComponent($("#username").val())+'&cname='+encodeURIComponent($("#cname").val())
       ,
      
        success: function(data) {
        //        alert(data)
            if (data === "success") {

                                
              swal({
                    title: "Successful!",
                    text: "Profile  Updated Successfully!",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                       var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/User/UpdateProfile";
                    }

                })
                
            } 
        }
    })
}
                                                
                                                        
                        