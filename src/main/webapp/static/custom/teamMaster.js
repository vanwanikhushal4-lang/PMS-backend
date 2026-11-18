
window.onload = function() {
	
	
	 var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getproducutsuitList";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          
	          success: function(data2) {
	          //    //("burger"+data2)
	         	 var html = "  <option value=''> -- Please Select --</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("productsuitdetails").innerHTML = html;	
	 			
	 		}
	 	});
	
	
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getDevelopers";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',

          success: function(data2) {
        //      alert("burger"+data2)
         	 var html = "  <option value=''> -- Please Select --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("assignedToupdate").innerHTML = html;
		
 		}
 	});
	

	sectools1()

		      
		      var l = window.location;
			   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			   	var serviceUrl = base_url + "/Master/getDevelopers";
//			   	var serviceUrl = base_url + "/PMS/getAllTLList";
			   	

			      $.ajax({
			          type: 'POST',
			          url: serviceUrl,
			          dataType: 'json',

			          success: function(data2) {
//			        	  alert(data2)
			          //    alert("burger"+data2)
			         	 var html = "  <option value=''> -- Please Select --</option>";
			 			                    for (var i = 0; i < data2.length; i++) {
			 				html += '<option value="' + data2[i] + '">' + data2[i]
			 						+ '</option>';
			 			}
			 			document.getElementById("Tlname").innerHTML = html;
			 			document.getElementById("Tlnamedataupdate").innerHTML = html;
			 			
			 			
//			 			$("#Tlname").html(html);
			 			
			 		}
			 	});
	      
	

	
		      
			    var l = window.location;
			   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			   	var serviceUrl = base_url + "/Master/getimplementerList"; 
			   	var serviceUrl = base_url + "/PMS/getFHList";

			   	$.ajax({
			          type: 'POST',
			          url: serviceUrl,
			          dataType: 'json',
			          success: function(data2) {
			          //    //("burger"+data2)
			         	 var html = "  <option value=''> -- Please Select --</option>";
			 			                    for (var i = 0; i < data2.length; i++) {
			 				html += '<option value="' + data2[i] + '">' + data2[i]
			 						+ '</option>';
			 			}
			 			                   html +="<option value='NA'>NA</option>";              
			 			                    
			 			document.getElementById("functionalHead").innerHTML = html;	
			 			document.getElementById("updImplementerName").innerHTML = html;	
			 		}
			 	});
		
		

	
     var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//  	var serviceUrl = base_url + "/Master/TlmasterlistingForTeamMaster";
  	var serviceUrl = base_url + "/PMS/getTeamMasterList";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
             var table = $('#productdata').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 10,
                  scrollX:true,
                  scrollY:true
             });

             table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });
     
     
 

 }



function sectools22() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList2";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuitdetails").val())
	}).done(function(data2Array) {
		alert(data)
	
//	    // Split the received data into an array (e.g., comma-separated values)
	    var data2Array = data2.split(','); // Change ',' to the appropriate delimiter

	    var html = "<option value=''> -- Please Select --</option>";
	    for (var i = 0; i < data2Array.length; i++) {
	        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
	    }
	    document.getElementById("securitysolutiondetails").innerHTML = html;
	    document.getElementById("securitysolutionupdate").innerHTML = html;
	});
	}


function validateProductMaster() {
    var indexError = 0;
   
   
    if ($('#functionalHead').val().trim() === '') {
        callToolTip231('functionalHead', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#mappedWith').val().trim() === '') {
        callToolTip231('mappedWith', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#mappedWith').val().trim() === 'Team Leader' && $('#Tlname').val().trim() === '') {
        callToolTip231('Tlname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#mappedWith').val().trim() === 'Developer' && $('#AM_DMname').val().trim() === '') {
        callToolTip231('AM_DMname', 'show');
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


var callToolTip231 = function(fieldName, status) {

   
     if (fieldName == "functionalHead") {
         var errorMessage = "<span>Please Select Manager Name<span>";
     }
     else if (fieldName == "mappedWith") {
         var errorMessage = "<span>Please Select Option<span>";
     }
     else if (fieldName == "Tlname") {
         var errorMessage = "<span>Please Select Team Leader<span>";
     }
     else if (fieldName == "AM_DMname") {
         var errorMessage = "<span>Please Select Developer Name<span>";
     }
     
     
     
     if (fieldName == "updImplementerName") {
    	    var errorMessage = "<span>Please Select Manager Name<span>";
    	}
    	else if (fieldName == "mappedWithN") {
    	    var errorMessage = "<span>Please Select Option<span>";
    	}
    	else if (fieldName == "Tlnamedataupdate") {
    	    var errorMessage = "<span>Please Select Team Leader<span>";
    	}
    	else if (fieldName == "assignedToupdate") {
    	    var errorMessage = "<span>Please Select Developer Name<span>";
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




$('#functionalHead').on('focus', function() {
	callToolTip231('functionalHead', 'destroy');
});

$('#mappedWith').on('focus', function() {
	callToolTip231('mappedWith', 'destroy');
});

$('#Tlname').on('focus', function() {
	callToolTip231('Tlname', 'destroy');
});
$('#AM_DMname').on('focus', function() {
	callToolTip231('AM_DMname', 'destroy');
});




$('#updImplementerName').on('focus', function() {
	callToolTip231('updImplementerName', 'destroy');
});

$('#mappedWithN').on('focus', function() {
	callToolTip231('mappedWithN', 'destroy');
});

$('#Tlnamedataupdate').on('focus', function() {
	callToolTip231('Tlnamedataupdate', 'destroy');
});
$('#assignedToupdate').on('focus', function() {
	callToolTip231('assignedToupdate', 'destroy');
});

//$('#unitdata').on('focus', function() {
//	callToolTip231('unitdata', 'destroy');
//});



function validateProductMasterUpdate() {
    var indexError = 0;
   
    if ($('#updImplementerName').val().trim() === '') {
        callToolTip231('updImplementerName', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#mappedWithN').val().trim() === '') {
        callToolTip231('mappedWithN', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#Tlnamedataupdate').val().trim() === '') {
        callToolTip231('Tlnamedataupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#assignedToupdate').val().trim() === '') {
        callToolTip231('assignedToupdate', 'show');
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






$("#resetbtn").click(function() {
    
     
     $("#functionalHead").val("");
     callToolTip231('functionalHead', 'hide');
     
     $("#mappedWith").val("");
     callToolTip231('mappedWith', 'hide');
     
     $("#Tlname").val("");
     callToolTip231('Tlname', 'hide');
     
     $("#AM_DMname").val("");
     callToolTip231('AM_DMname', 'hide');
       
});


$("#submit-btn").click(function() {
   if (!validateProductMaster()) 
   { 
        event.preventDefault();
   }
     else 
   {
     saveDataProduct();
   }
   
});

//$("#submit-btn").click(function(){
////	alert("submit clicked");
//	saveDataProduct();
//});



function saveDataProduct()  {

	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/Master/saveTlMasterForMan";
 	var serviceUrl = base_url + "/PMS/saveTeamMaster";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'productsuit=' + encodeURIComponent($("#productsuitdetails").val())
            		+ '&securitysolution=' + encodeURIComponent($("#securitysolutiondetails").val())
            		+ '&functionalHead=' + encodeURIComponent($("#functionalHead").val())
            		+ '&Tlname=' + encodeURIComponent($("#Tlname").val())
            		+ '&AM_DMname=' + encodeURIComponent($("#AM_DMname").val())
            		+ '&phaseType=' + encodeURIComponent($("#phaseType").val())
            		+ '&mappedWith=' + encodeURIComponent($("#mappedWith").val()), 
            		
        }).done(function(data) {
          
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Added Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/TeamMaster";
                    }

                });

            }
             else if (data == "duplicate") {
                swal({
                    title: "Duplicate Data!",
                    text: "Record Already Exists",
                    type: "warning",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/TeamMaster";
                    }

                });

              }
            else if (data == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to add file",
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
                        window.location.href = base_url + "/Admin/TeamMaster";
                    }

                });

              }
        });
   
            }  
            
  
function DeleteTLMaster(srno)  {

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
     	var serviceUrl = base_url + "/Master/deleteTlMasterSupport";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'srno=' + srno

        }).done(function(data) {        
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
                        window.location.href = base_url + "/Admin/TLMasterSupport";
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
                        window.location.href = base_url + "/Admin/TLMasterSupport";
                    }

                });

              }
        });
    });
  } 

function sectools1() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionListSupport";
										 
	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuitupdate").val())
	}).done(function(data2Array) {
//		alert("hhhh"+data2Array)
	    // Split the received data into an array (e.g., comma-separated values)
//	    var data2Array = data2.split(','); // Change ',' to the appropriate delimiter

	    var html = "<option value=''> -- Please Select --</option>";
	    for (var i = 0; i < data2Array.length; i++) {
	        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
	    }
//	    document.getElementById("securitysolutiondetails").innerHTML = html;
	    document.getElementById("securitysolutionupdate").innerHTML = html;
	    
	});
	}


function EditProductMaster(srno,productsuit , securitysolution ,functionalHead, team_lead, developer)
{
	
//	alert(developer)
//	alert(functionalHead)
//	alert(team_lead)
//	alert(securitysolution);
	
	 $("#productsuitupdate").val(productsuit);
	 $("#securitysolutionupdate").val(securitysolution); 
	 
	 $("#updImplementerName").val(functionalHead);
	 $("#Tlnamedataupdate").val(team_lead);
	  $("#sr_no1").val(srno);
	  
	  if(developer=='NA')
	  {
		  
		  $('#developerNameDivN').hide();
	  }
	  else
	  {
		  $('#developerNameDivN').show();
		  $("#assignedToupdate").val(developer);
	  }
	  
	  
	  $("#modelproductmaster").modal("show");	     	
}

$("#update_productMasterType_btn").click(function () {

//     updateproducrmaster();
	updateproducrmasterNew();
}).show();

function updateproducrmaster()
{
	 var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/updateTLMasterSupport";
   
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data: 
                 "sr_no=" + $("#sr_no1").val()
                 +"&productsuitupdate=" +$('#productsuitupdate').val()
                 + "&securitysolutionupdate="+$("#securitysolutionupdate").val()
                 + "&tlname=" +$("#Tlnamedataupdate").val()
                   + "&updImplementerName=" +$("#updImplementerName").val(),
                                              
         success: function (data) {
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
                         window.location.href = base_url + "/Admin/TLMaster";
                     }
                 });
         }    else {

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
                         window.location.href = base_url + "/Admin/TLMaster";
                     }
                 });
             }

      //       $('#companynameupdate').val("");

         }
     });
}


function updateproducrmasterNew()
{
	 var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/updateTLMasterDeveloperNew";
   
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data: 
                 "sr_no=" + $("#sr_no1").val()
//                 +"&productsuitupdate=" +$('#productsuitupdate').val()
//                 + "&securitysolutionupdate="+$("#securitysolutionupdate").val()
                 + "&tlname=" +$("#Tlnamedataupdate").val()
                   + "&updImplementerName=" +$("#updImplementerName").val()
                   + "&assignedToupdate=" +$("#assignedToupdate").val(),
                                              
         success: function (data) {
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
                         window.location.href = base_url + "/Admin/TLMaster";
                     }
                 });
         }    else {

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
                         window.location.href = base_url + "/Admin/TLMaster";
                     }
                 });
             }

      //       $('#companynameupdate').val("");

         }
     });
}



function getSecTools() {
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionList";

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType:'JSON',
	    data: 'productsuit=' + encodeURIComponent($("#productsuitdetails").val())
	}).done(function(data) {
	
		 var html = "<option value=''>-- Please Select Product Tool --</option>";
	      for (var i = 0; i < data.length; i++) {
	          html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	      }
	      document.getElementById("securitysolutiondetails").innerHTML=html;
//	      document.getElementById("securitysolutionupdate").innerHTML=html;
	      
	      
        
	});
		
}




function SelectAssignee() {
	var mappedValue = $('#mappedWith').val();
//alert(mappedValue);
	   
	        if (mappedValue === "Team Leader") {
//	        	alert("inside")
	        	
	            $('#TlnameDiv').show();
	        	$('#AM_DM_Div').hide();
//	        	 $('#Tlname').css('display', 'block');
	        	
	          
	        } else if (mappedValue === "AM/DM") {
	        	
//	        	alert("inside")
	            
	        	
	        	$('#TlnameDiv').hide();
	        	$('#AM_DM_Div').show();
	        	
	        	var l = window.location;
			   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			   	var serviceUrl = base_url + "/Master/getDevelopers";
			   	var serviceUrl = base_url + "/PMS/getFHList";

			      $.ajax({
			          type: 'POST',
			          url: serviceUrl,
			          dataType: 'json',

			          success: function(data2) {
			         	 var html = "  <option value=''> -- Please Select --</option>";
			 			                    for (var i = 0; i < data2.length; i++) {
			 				html += '<option value="' + data2[i] + '">' + data2[i]
			 						+ '</option>';
			 			}
			 			document.getElementById("AM_DMname").innerHTML = html;

			 		}
			 	});
	        	
	        } else if (mappedValue === "Both") {
	        	
	            
	        	
	        	$('#TlnameDiv').show();
	        	$('#AM_DM_Div').show();
	        	
	        	var l = window.location;
			   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			   	var serviceUrl = base_url + "/Master/getDevelopers";
			   	var serviceUrl = base_url + "/PMS/getFHList";

			      $.ajax({
			          type: 'POST',
			          url: serviceUrl,
			          dataType: 'json',

			          success: function(data2) {
			         	 var html = "  <option value=''> -- Please Select --</option>";
			 			                    for (var i = 0; i < data2.length; i++) {
			 				html += '<option value="' + data2[i] + '">' + data2[i]
			 						+ '</option>';
			 			}
			 			document.getElementById("AM_DMname").innerHTML = html;

			 		}
			 	});
	        	
	        } else {
	        	$('#TlnameDiv').hide();
	        	$('#AM_DM_Div').hide();
	        }
	}


	function SelectAssigneeModal() {
		var mappedWithN = $('#mappedWithN').val();

		   
		        if (mappedWithN === "Team Leader") {
//		        	alert("inside")
		        	
		            $('#TlnameDivN').show();
		            $('#assignedToupdate').val('');
		        	$('#developerNameDivN').hide();
//		        	 $('#Tlname').css('display', 'block');
		        	
		          
		        } else if (mappedWithN === "Developer") {
		        	
//		        	alert("inside")
		            
		        	
		        	$('#TlnameDivN').show();
		        	$('#developerNameDivN').show();
		        	
		        	var l = window.location;
				   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
				   	var serviceUrl = base_url + "/Master/getDevelopers";
//				   	var selectedValue = $("#functionName").val();

				      $.ajax({
				          type: 'POST',
				          url: serviceUrl,
				          dataType: 'json',

				          success: function(data2) {
				        //      alert("burger"+data2)
				         	 var html = "  <option value=''> -- Please Select --</option>";
				 			                    for (var i = 0; i < data2.length; i++) {
				 				html += '<option value="' + data2[i] + '">' + data2[i]
				 						+ '</option>';
				 			}
				 			document.getElementById("assignedToupdate").innerHTML = html;
//				 			document.getElementById("developerNameupdate").innerHTML = html;
//				 			$("#Tlname").html(html);
				 			
				 		}
				 	});
		        	
		        } 
		}
	
	

	function getSecTools() {
		
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getsecuritysolutionList";

		$.ajax({
		    type: 'POST',
		    url: serviceUrl,
		    dataType:'JSON',
		    data: 'productsuit=' + encodeURIComponent($("#productsuitdetails").val())
		}).done(function(data) {
		
			 var html = "<option value=''>-- Please Select Product Tool --</option>";
		      for (var i = 0; i < data.length; i++) {
		          html += '<option value="' +data[i]+ '">' + data[i]
		          + '</option>';
		      }
		      document.getElementById("securitysolutiondetails").innerHTML=html;
//		      document.getElementById("securitysolutionupdate").innerHTML=html;
		       
		});
			
	}

