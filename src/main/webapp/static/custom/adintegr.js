 window.onload = function() {
	 	$('#l_button').hide();
	 	$('#spin').hide();
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
//	             alert(data4)
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
	             }

	             
	     });
//     alert("ggggg");
     
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/adddetailsListing";
 	  
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//alert(data4)
        	 $("#preLoader").hide();
         	$("#datatype").removeClass("d-none");

             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
                 scrollX: true,
                 pageLength: 5,
                 
             });
//             $('#datatype td').css('white-space','initial');
             table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });
     var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getsyncloglisting";
  	  
      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          success: function(data4) {
 //alert(data4)
         	 $("#preLoader2").hide();
          	$("#logtable").removeClass("d-none");

              var table = $('#logtable').DataTable({
                  lengthChange: false,
                  data: data4,
                  scrollX: true,
                  pageLength: 5,
                  
              });
//              $('#datatype td').css('white-space','initial');
              table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

          }

      });
     
 };
 function SyncTest(company,srno)
 {
	//alert(srno)
	 	
		 $("#test"+srno).removeClass('fa fa-pencil-alt').addClass('fas fa-spinner fa-spin');
	
	 

//     	 var t1=document.getElementById("#test2");
//		 t1.closest("company");
		 
	
	 
 	//alert(company);
 	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/adintegtestlist";
  

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data: 'company=' + company,
                // + "&cmpnyname=" + $('#cname').val() 
                 
           }).done(function(data) {
        // alert(data)
         if (data == "success") {
         	swal({
 				title : "Successfully!",
 				text : "AD Test Successfully",
 				type : "success",
 				width : 300,
 				height : 200,
 				
 				confirmButtonClass : "btn btn-success",
 				confirmButtonText : "OK",
 				preConfirm : function() {
 					var l = window.location;
 					var base_url = l.protocol + "//" + l.host + "/"
 							+ l.pathname.split('/')[1];
 					window.location.href = base_url
 							+ "/Admin/AdIntegration";
 				}
 			})

         }
         else if (data == "error") {
             swal({
                 

                  title: "Error!",
                 text: "Username or Password invalid...!",
                 type: "warning",
                 width: 300,
                 height : 200,
               
                 confirmButtonClass: "btn btn-danger",
               
                 confirmButtonText: "OK",
                 preConfirm : function() {
 					var l = window.location;
 					var base_url = l.protocol + "//" + l.host + "/"
 							+ l.pathname.split('/')[1];
 					window.location.href = base_url
 							+ "/Admin/AdIntegration";
 				}

             })

         }

     })  

 }
 function SyncList(company,srno)
 {
 
	 
	$("#sync"+srno).removeClass('fas fa-sync').addClass('fas fa-sync fa-spin');
	$("button[class='btn btn-info']").attr("disabled",true);
	$("button[class='btn btn-sm btn-danger']").attr("disabled",true);
	
 	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/FetchADusers";
  

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data:'company='+company,
        

     }).done(function(data) {
    	 
    	 
    	var data2= data.split("~");
//      alert(data)
//      alert(data2[0])
         if (data2[0] == "success") {
        	 
        	 	var l = window.location;
        	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        	 	var serviceUrl = base_url + "/Master/updatelogsync";
        	  

        	     $.ajax({
        	         type: 'POST',
        	         url: serviceUrl,
        	         data:'loginfo='+data,
        	         
        	     }).done(function(data) {
        	    	 
        	    	 if(data == "success"){
        	    	 swal({
        	 				title : "Successfully!",
        	 				text : "AD Users Synched",
        	 				type : "success",
        	 				width : 300,
        	 				height : 200,
        	 				
        	 				confirmButtonClass : "btn btn-success",
        	 			
        	 				confirmButtonText : "OK",
        	 				preConfirm : function() {
        	 					var l = window.location;
        	 					var base_url = l.protocol + "//" + l.host + "/"
        	 							+ l.pathname.split('/')[1];
        	 					window.location.href = base_url
        	 							+ "/Admin/AdIntegration";
        	 				}
        	 			})
        	    	 }
        	    	 
        	    	 
        	         else if (data == "failed") {
        	             swal({
        	                 

        	                  title: "Error!",
        	                 text: "Failed to Synch Ad Users",
        	                 type: "warning",
        	                 width: 300,
        	                 height : 200,
        	                
        	                 confirmButtonClass: "btn btn-danger",
        	                
        	                 confirmButtonText: "OK",
        	                 preConfirm : function() {
        	 					var l = window.location;
        	 					var base_url = l.protocol + "//" + l.host + "/"
        	 							+ l.pathname.split('/')[1];
        	 					window.location.href = base_url
        	 							+ "/Admin/AdIntegration";
        	 				}

        	             })

        	         }
        	     
        	   
        	 
     })  

     }
         else{

             swal({
                 

                  title: "Error!",
                 text: "Failed to Synch Ad Users",
                 type: "warning",
                 width: 300,
                 height : 200,
                
                 confirmButtonClass: "btn btn-danger",
                
                 confirmButtonText: "OK",
                 preConfirm : function() {
 					var l = window.location;
 					var base_url = l.protocol + "//" + l.host + "/"
 							+ l.pathname.split('/')[1];
 					window.location.href = base_url
 							+ "/Admin/AdIntegration";
 				}

             })

          
         }
     })
 }
 
function validateEmail(email){

    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    console.log(re.test(email));

    return re.test(email);
}

var callToolTipx = function(fieldName, status) {

 if (fieldName == "username") {
        var errorMessage = "<span>Please Enter Username</span>";
    }
   if (fieldName == "hostORip") {
        var errorMessage = "<span>Please Enter Host or IP</span>";
    }
    if (fieldName == "port") {
        var errorMessage = "<span>Please Enter Port Number</span>";
    }
    if (fieldName == "passW") {
        var errorMessage = "<span>Please Enter password</span>";
    }
    if (fieldName == "DName") {
        var errorMessage = "<span>Please Enter Host or IP</span>";
    }
    if (fieldName == "cname") {
        var errorMessage = "<span>Please Select Company </span>";
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

//focus out
$('#username').on('focusout', function() {
  var usertype = $('#username').val();

  if (usertype.trim() == "") {
      callToolTipx('username', 'show');
  }
  else{
      callToolTipx('username', 'hide');
  }
});

$('#port').on('focusout', function() {
  var usertype = $('#port').val();

  if (usertype.trim() == "") {
      callToolTipx('port', 'show');
  }
  else{
      callToolTipx('port', 'hide');
  }
});
$('#passW').on('focusout', function() {
  var usertype = $('#passW').val();

  if (usertype.trim() == "") {
      callToolTipx('passW', 'show');
  }
  else{
      callToolTipx('passW', 'hide');
  }
});
$('#DName').on('focusout', function() {
	  var usertype = $('#DName').val();

	  if (usertype.trim() == "") {
	      callToolTipx('DName', 'show');
	  }
	  else{
	      callToolTipx('DName', 'hide');
	  }
	});
$('#cname').on('focusout', function() {
	  var usertype = $('#cname').val();

	  if (usertype.trim() == "") {
	      callToolTipx('cname', 'show');
	  }
	  else{
	      callToolTipx('cname', 'hide');
	  }
	});
$('#hostORip').on('focusout', function() {
	  var usertype = $('#hostORip').val();

	  if (usertype.trim() == "") {
	      callToolTipx('hostORip', 'show');
	  }
	  else{
	      callToolTipx('hostORip', 'hide');
	  }
	});



$('#username').on('focus', function() {
  callToolTipx('username', 'hide');
});
$('#hostORip').on('focus', function() {
  callToolTipx('hostORip', 'hide');
});
$('#port').on('focus', function() {
  callToolTipx('port', 'hide');
});
$('#passW').on('focus', function() {
  callToolTipx('passW', 'hide');
});
$('#DName').on('focus', function() {
	  callToolTipx('DName', 'hide');
	});

$('#cname').on('focus', function() {
	  callToolTipx('cname', 'hide');
	});
var adddeviceCheck = function() {
   
    indexError = 0;
  
   if ($('#username').val().trim() === '') {
        callToolTipx('username', 'show');

        indexError = indexError + 1;
    }
    
  

     if ($('#port').val().trim() === '') {
        callToolTipx('port', 'show');

        indexError = indexError + 1;
    }
    if ($('#passW').val().trim() === '') {
        callToolTipx('passW', 'show');

        indexError = indexError + 1;
    }



     if ($('#hostORip').val().trim() === '') {
            callToolTipx('hostORip', 'show');
            indexError = indexError + 1;        
    }
     
     if ($('#DName').val().trim() === '') {
         callToolTipx('DName', 'show');
         indexError = indexError + 1;        
 }
    
     if ($('#cname').val().trim() === '') {
         callToolTipx('cname', 'show');
         indexError = indexError + 1;        
 }
   
   
   
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }

}


var hardEncypSave = function() {
     
    
   var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Admin/EmailConfg";
 	
 	
     // alert($('#hostname').val())
    //   alert($('#type').val())
   //alert(serviceUrl)
    $.ajax({

        type : 'POST',
        url : serviceUrl,
        data : "hostname=" + $('#hostname').val()
        //        + "&drive=" + $('#drive').val()
    //    + "&authentication=" + $('#authentication').val()
        + "&port=" + $('#port').val()
        + "&mailid=" + $('#mailid').val()
         + "&type=" + $('#type').val()
        + "&senderid=" + $('#senderid').val()
       + "&pass=" + $('#pass').val(),
        success:function(data){
           //  alert(data)
      //  $("#submit_hard").show();   
       // $("#submit_hard_load").hide();
    
   if(data=="success"){
           
            
            swal({
                title: "Successful!",
                text: "Record Added Successfully",
                type: "success",
                width: 300,
                height: 200,
                showCancelButton: !0,
                confirmButtonClass: "btn btn-danger",
                cancelButtonClass: "btn btn-danger m-l-10",
                preConfirm: function() {
                    var l = window.location;
                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                    window.location.href = base_url + "/Admin/emailConfig";
                }

            });
                
        }
        
          else if(data=="update"){
            swal({
            	 title: "Updated!",
                 text: "Record Updated Successfully",
                 type: "success",
                 width: 300,
                 height: 200,
                 showCancelButton: !0,
                 confirmButtonClass: "btn btn-danger",
                 cancelButtonClass: "btn btn-danger m-l-10",
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/emailConfig";
                 }
            })
        }
   
          else{
        	  swal({
             	 title: "Failed!",
                  text: "Record Failed to add",
                  type: "error",
                  width: 300,
                  height: 200,
                  showCancelButton: !0,
                  confirmButtonClass: "btn btn-danger",
                  cancelButtonClass: "btn btn-danger m-l-10",
                  preConfirm: function() {
                      var l = window.location;
                      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                      window.location.href = base_url + "/Admin/emailConfig";
                  }
             })
          }
        }
       
       
       
   
    });
     
  

}


$("#submit_blacklist").click(function() {

   if(!adddeviceCheck())
    {
        event.preventDefault();
       
    }else if(adddeviceCheck())
    {
    	adintegration();
    }
        
    
}).show();



var adintegration = function() {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	serviceUrl = base_url + "/Master/adddetails";

	// alert(atmuser)
	
	$.ajax(
			{
				type : 'POST',
				url : serviceUrl,
				data : "username=" + $('#username').val()
				+ "&password=" + $('#passW').val() 
				+ "&hostname=" + $('#hostORip').val() 
				+ "&portno="+ $('#port').val()  
				+ "&domainname=" + $('#DName').val() 
				+ "&cmpnyname=" + encodeURIComponent($('#cname').val()) 
						
			}).done(
			function(data) {
				// alert("After success="+data)
				//$('#spinner').hide();
				if (data == "success") {
					swal({
						title : "Successfully!",
						text : "Set Successfully",
						type : "success",
						width : 300,
						height : 200,
						showCancelButton : !0,
						confirmButtonClass : "btn btn-success",
						cancelButtonClass : "btn btn-danger m-l-10",
						confirmButtonText : "OK",
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/AdIntegration";
						}
					})

				}
				
				else if (data == "duplicate") {
					swal({
						title : "Duplicate!",
						text : "Record Already Existed",
						type : "success",
						width : 300,
						height : 200,
						showCancelButton : !0,
						confirmButtonClass : "btn btn-success",
						cancelButtonClass : "btn btn-danger m-l-10",
						confirmButtonText : "OK",
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/AdIntegration";
						}
					})

				}
				
			});
}


$("#test_button").click(function() {
  
	 if(!adddeviceCheck())
	    {
	        event.preventDefault();

	    }else if(adddeviceCheck())
	    {
	    	 adtest();
	    }
}).show();


//function EditTest(cname,username,host,domainname,auth,port,pass) {
////alert(cname)
//	//editadtest(cname,username,host,domainname,auth,port,pass);
//
//}

//function editadtest(cname,username,host,domainname,auth,port,pass){
//    
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/adintegtest";
// 
//
//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        data: "username=" + $('#username').val()
//                + "&password=" + $('#pass').val()
//                + "&hostname=" + $('#host').val()
//                + "&port=" + $('#port').val()
//                + "&domainname=" + $('#domainname').val()
//                + "&cmpnyname=" + $('#cname').val() 
//
//    }).done(function(data) {
//       
//          // alert(data)
//        if (data == "success") {
//        	swal({
//				title : "Successfully!",
//				text : "AD Test Successfully",
//				type : "success",
//				width : 300,
//				height : 200,
//				showCancelButton : !0,
//				confirmButtonClass : "btn btn-success",
//				cancelButtonClass : "btn btn-danger m-l-10",
//				confirmButtonText : "OK",
//				preConfirm : function() {
//					var l = window.location;
//					var base_url = l.protocol + "//" + l.host + "/"
//							+ l.pathname.split('/')[1];
//					window.location.href = base_url
//							+ "/Admin/AdIntegration";
//				}
//			})
//
//        }
//        else if (data == "error") {
//            swal({
//                
//
//                 title: "Error!",
//                text: "Username or Password invalid...!",
//                type: "warning",
//                width: 300,
//                height : 200,
//                showCancelButton: !0,
//                confirmButtonClass: "btn btn-danger",
//                cancelButtonClass: "btn btn-danger m-l-10",
//                confirmButtonText: "OK",
//                preConfirm : function() {
//					var l = window.location;
//					var base_url = l.protocol + "//" + l.host + "/"
//							+ l.pathname.split('/')[1];
//					window.location.href = base_url
//							+ "/Admin/AdIntegration";
//				}
//
//            })
//
//        }
//
//      
//    })  
//}  
	function adtest(){
		
		
	$("#test_button").on('click')
	{
		$('#l_button').show();
		$('#spin').show();
	}
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/adintegtest";
 

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "username=" + $('#username').val()
                + "&password=" + $('#passW').val()
                + "&hostname=" + $('#hostORip').val()
                + "&port=" + $('#port').val()
                + "&domainname=" + $('#DName').val()
               // + "&cmpnyname=" + $('#cname').val() 

    }).done(function(data) {
       
          // alert(data)
        if (data == "success") {
        	swal({
				title : "Successfully!",
				text : "AD Test Successfully",
				type : "success",
				width : 300,
				height : 200,
				
				confirmButtonClass : "btn btn-success",
				
				confirmButtonText : "OK",
				preConfirm: function() {
					var l = window.location;
					var base_url = l.protocol + "//" + l.host + "/"
							+ l.pathname.split('/')[1];
					window.location.href = base_url
							+ "/Admin/AdIntegration";
				}
			})

        }
        else if (data == "error") {
            swal({
                

                 title: "Error!",
                text: "Username or Password invalid...!",
                type: "warning",
                width: 300,
                height : 200,
               
                confirmButtonClass: "btn btn-danger",
                
                confirmButtonText: "OK",
                preConfirm : function() {
					var l = window.location;
					var base_url = l.protocol + "//" + l.host + "/"
							+ l.pathname.split('/')[1];
					window.location.href = base_url
							+ "/Admin/AdIntegration";
				}

            })

        }

      
    })  
} 
	 function Edit(company,username,password,hostname,port_no,domain_name)
	 {
		
		 $("#companynameupdate").val(company);
		$("#user").val(username);
		 $('#password').val(password);
		 $('#host').val(hostname);
		 $("#port_no").val(port_no);
		 $("#dName").val(domain_name);
		 
		 $('#modeldesignation').modal("show");
		 
	 }
	 $("#update_AdIntegration_btn").click(function () {
		   if (!validateAdIntegrationUpdate())
		   {
		 //     alert("fail");
		       //event.preventDefault();
		   } else if (validateAdIntegrationUpdate())
		   {
		      //  alert("pass")
		     updateAdIntegration();
		   }
		}).show();
	 
	 function validateAdIntegrationUpdate()
	 {
		 
		
		  var indexError = 0;

		   if ($('#companynameupdate').val() === '') {
		     callToolTipUpdate('companynameupdate', 'show');
		       if (indexError == 0) {

		       }
		       indexError = indexError + 1;
		   }
		   if ($('#user').val().trim() === '') {
		     callToolTipUpdate('user', 'show');
		       if (indexError == 0) {

		       }
		       indexError = indexError + 1;
		   }
		   if ($('#password').val() === '') {
			     callToolTipUpdate('password', 'show');
			       if (indexError == 0) {

			       }
			       indexError = indexError + 1;
			   }
		   if ($('#host').val() === '') {
			     callToolTipUpdate('host', 'show');
			       if (indexError == 0) {

			       }
			       indexError = indexError + 1;
			   }
		   if ($('#port_no').val() === '') {
			     callToolTipUpdate('port_no', 'show');
			       if (indexError == 0) {

			       }
			       indexError = indexError + 1;
			   }
		   if ($('#dName').val() === '') {
			     callToolTipUpdate('dName', 'show');
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
	 var callToolTipUpdate = function (fieldName, status) {
		 
		   if (fieldName == "companynameupdate") {
		     var errorMessage = "<span>Please Select Company</span>"
		   } else if (fieldName == "user") {
		     var errorMessage = "<span>Please Enter Username</span>"
		   }
		   else if (fieldName == "password") {
			     var errorMessage = "<span>Please Enter Password</span>"
			   }
		   else if (fieldName == "host") {
			     var errorMessage = "<span>Please Enter Host</span>"
			   }
		   else if (fieldName == "port_no") {
			     var errorMessage = "<span>Please Enter Port_No</span>"
			   }
		   else if (fieldName == "dName") {
			     var errorMessage = "<span>Please Enter Domain Name</span>"
			   }
		   
		   $("#" + fieldName).tooltip({
		       trigger: 'manual',
		       at:'center',
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
		 
		 $('#companynameupdate').on('focusout', function () {
		   var usertype = $('#companynameupdate').val();

		   if (usertype.trim() == "") {
		     callToolTipUpdate('companynameupdate', 'show');
		   } else {
		     callToolTipUpdate('companynameupdate', 'hide');
		   }
		});
		 
		 $('#user').on('focusout', function () {
		   var usertype = $('#user').val();

		   if (usertype.trim() == "") {
		     callToolTipUpdate('user', 'show');
		   } else {
		     callToolTipUpdate('user', 'hide');
		   }
		}); 
		 $('#password').on('focusout', function () {
			   var usertype = $('#password').val();

			   if (usertype.trim() == "") {
			     callToolTipUpdate('password', 'show');
			   } else {
			     callToolTipUpdate('password', 'hide');
			   }
			}); 
		 $('#host').on('focusout', function () {
			   var usertype = $('#host').val();

			   if (usertype.trim() == "") {
			     callToolTipUpdate('host', 'show');
			   } else {
			     callToolTipUpdate('host', 'hide');
			   }
			}); 
		 $('#port_no').on('focusout', function () {
			   var usertype = $('#port_no').val();

			   if (usertype.trim() == "") {
			     callToolTipUpdate('port_no', 'show');
			   } else {
			     callToolTipUpdate('port_no', 'hide');
			   }
			}); 
		 $('#dName').on('focusout', function () {
			   var usertype = $('#dName').val();

			   if (usertype.trim() == "") {
			     callToolTipUpdate('dName', 'show');
			   } else {
			     callToolTipUpdate('dName', 'hide');
			   }
			}); 

		 $('#companynameupdate').on('focus', function () {
		   callToolTipUpdate('companynameupdate', 'destroy');
		});
		 
		 $('#user').on('focus', function () {
		   callToolTipUpdate('user', 'destroy');
		});
		 $('#password').on('focus', function () {
			   callToolTipUpdate('password', 'destroy');
			});
		 $('#host').on('focus', function () {
			   callToolTipUpdate('host', 'destroy');
			});
		 $('#port_no').on('focus', function () {
			   callToolTipUpdate('port_no', 'destroy');
			});
		 $('#dName').on('focus', function () {
			   callToolTipUpdate('dName', 'destroy');
			});
		 function validateAdIntegrationUpdate()
		 {
			 
	//		 alert("ggggggggggg");
			  var indexError = 0;

			   if ($('#companynameupdate').val() === '') {
			     callToolTipUpdate('companynameupdate', 'show');
			       if (indexError == 0) {

			       }
			       indexError = indexError + 1;
			   }
			   if ($('#user').val().trim() === '') {
			     callToolTipUpdate('user', 'show');
			       if (indexError == 0) {

			       }
			       indexError = indexError + 1;
			   }
			   if ($('#password').val() === '') {
				     callToolTipUpdate('password', 'show');
				       if (indexError == 0) {

				       }
				       indexError = indexError + 1;
				   }
			   if ($('#host').val() === '') {
				     callToolTipUpdate('host', 'show');
				       if (indexError == 0) {

				       }
				       indexError = indexError + 1;
				   }
			   if ($('#port_no').val() === '') {
				     callToolTipUpdate('port_no', 'show');
				       if (indexError == 0) {

				       }
				       indexError = indexError + 1;
				   }
			   if ($('#dName').val() === '') {
				     callToolTipUpdate('dName', 'show');
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
		 
		 
	 function updateAdIntegration() {
		   var l = window.location;
		   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		   var serviceUrl = base_url + "/Master/UpdateAdIntegration";
		   
		     $.ajax({
		         type: 'POST',
		         url: serviceUrl,
		         data: "company=" + encodeURIComponent($('#companynameupdate').val())
		                 + "&username=" + $("#user").val()
		                 + "&password=" + $("#password").val()
		                 + "&host=" + $("#host").val()
		                 + "&port_no=" + $("#port_no").val()
		                 + "&dName=" + $("#dName").val(),
		         success: function(data) {
		        	// alert(data);
		             if (data == "success") {
		                 swal({
		                     title: "Successful!",
		                     text: "Record Updated Successfully",
		                     type: "success",
		                     width: 300,
		                     height: 200,
		                     buttons: false,
		                     allowOutsideClick: false,
		                     preConfirm: function () {
		                         var l = window.location;
		                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		                         window.location.href = base_url + "/Admin/AdIntegration";
		                     }
		                 });
		             } else if (data == "duplicate") {
		                 swal({
		                     title: "Duplicate!",
		                     text: "Record Already Exist",
		                     type: "success",
		                     width: '300px',
		                     height: '90px !important',
		                     buttons: false,
		                     allowOutsideClick: false,
		                     preConfirm: function () {
		                         var l = window.location;
		                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		                         window.location.href = base_url + "/Admin/AdIntegration";
		                     }
		                 });
		             } else {

		                 swal({
		                     title: "Unsuccessful!",
		                     text: "Record not updated",
		                     type: "error",
		                     width: 300,
		                     height: 200,
		                     buttons: false,
		                     allowOutsideClick: false,
		                     preConfirm: function () {
		                         var l = window.location;
		                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		                         window.location.href = base_url + "/Admin/AdIntegration";
		                     }
		                 });
		             }

		             $('#companynameupdate').val("");

		         }
		     });
		 }
		 
	 
	  function Delete(company)
	 {
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
		     
		      var l = window.location;
		     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		     var serviceUrl = base_url + "/Master/DeleteList";
		     
		       $.ajax({
		           type: 'POST',
		           url: serviceUrl,
		           data: 'company='+company,
		       }).done(function(data) {
		    	//   	alert(data);
		           if (data == "success") {
		               swal({
		                   title: "Successful!",
		                   text: "Record Deleted Successfully",
		                   type: "success",
		                   width: 300,
		                   height: 200,
		                   buttons: false,
		                   allowOutsideClick: false,
		                   preConfirm: function() {
		                       var l = window.location;
		                       var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		                       window.location.href = base_url + "/Admin/AdIntegration";
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
		                   buttons: false,
		                   allowOutsideClick: false,
		                   preConfirm: function() {
		                       var l = window.location;
		                       var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		                       window.location.href = base_url + "/Admin/AdIntegration";
		                   }

		               });

		             }
		       });
		   });

	 }
//	function Sync() {
//		//alert(cname)
//		//adUser();
//
//		}
//	
//	
//	$("#getuser").click(function() {
//		  
//		
//		    	 adUser();
//		    
//	}).show();
//
//	function adUser(){
//	    
//		var l = window.location;
//		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/Master/FetchADusers";
//	 
//
//	    $.ajax({
//	        type: 'POST',
//	        url: serviceUrl,
//	       
//
//	    }).done(function(data) {
//	       
//	        //  alert(data)
//	        if (data == "success") {
//	        	swal({
//					title : "Successfully!",
//					text : "AD Users Synched",
//					type : "success",
//					width : 300,
//					height : 200,
//					showCancelButton : !0,
//					confirmButtonClass : "btn btn-success",
//					cancelButtonClass : "btn btn-danger m-l-10",
//					confirmButtonText : "OK",
//					preConfirm : function() {
//						var l = window.location;
//						var base_url = l.protocol + "//" + l.host + "/"
//								+ l.pathname.split('/')[1];
//						window.location.href = base_url
//								+ "/Admin/AdIntegration";
//					}
//				})
//
//	        }
//	        else if (data == "failed") {
//	            swal({
//	                
//
//	                 title: "Error!",
//	                text: "Failed to Synch Ad Users",
//	                type: "warning",
//	                width: 300,
//	                height : 200,
//	                showCancelButton: !0,
//	                confirmButtonClass: "btn btn-danger",
//	                cancelButtonClass: "btn btn-danger m-l-10",
//	                confirmButtonText: "OK",
//	                preConfirm : function() {
//						var l = window.location;
//						var base_url = l.protocol + "//" + l.host + "/"
//								+ l.pathname.split('/')[1];
//						window.location.href = base_url
//								+ "/Admin/AdIntegration";
//					}
//
//	            })
//
//	        }
//
//	      
//	    })  
//	}
//	
//	
    
$("#resetbtn").click(function () {
	
    callToolTipx('username', 'hide');
    $('#username').val("");
   
    callToolTipx('port', 'hide');
    $('#port').val("");
    callToolTipx('passW', 'hide');
    $('#passW').val("");
    callToolTipx('hostORip', 'hide');
    callToolTipx('DName', 'hide');
    $('#hostORip').val("");
   
    $('#DName').val("");
    callToolTipx('cname', 'hide');
    $('#cname').val("");
    
});