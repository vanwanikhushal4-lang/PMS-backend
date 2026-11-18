

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
	 		//	document.getElementById("productsuitupdate").innerHTML = html;	
	 			
	 		}
	 	});
	    

		      
//			  var l = window.location;
//				var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//				var serviceUrl = base_url + "/Master/getCustomerName";
//
//			$.ajax({
//			    url :serviceUrl,
//			    type : 'POST',
//			    dataType: 'json',
//			}).done(function(data) {
//
//			    var html= '<option value="">--Please Select Customer--</option>';
//			    for (var i = 0; i < data.length; i++) {
//			        html += '<option value="' +data[i]+ '">' + data[i]
//			        + '</option>';
//			    }
//
//			    document.getElementById("customerName").innerHTML=html;
//			});
		      
		      
		      
		 
			
			
//$('#customerName').select2({
//	tags: true,
//	placeholder: "Select a Customer or Enter New",
//	// allowClear: true
//})


//   var l = window.location;
//			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			var serviceUrl = base_url + "/Master/getcheckerName";
//
//		  $.ajax({
//
//		      url :serviceUrl,
//		      type : 'POST',
//		      dataType: 'json',
//		  }).done(function(data) {
//
//		      var html ="";
//		      html=html+'<option value="">--Please Select Checker Name--</option>';
//		      for (var i = 0; i < data.length; i++) {
//		          html += '<option value="' +data[i]+ '">' + data[i]
//		          + '</option>';
//		      }
//
//		      document.getElementById("salesManager").innerHTML=html;
//		  });



   var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//  var serviceUrl = base_url + "/Master/getAllClientList";
  	var serviceUrl = base_url + "/PMS/getComplianceList";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//        	 alert(data4)
             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 10,
                  scrollX:true
//                  dom: 'Bfrtip',
//                  buttons:[
//
//                  {
//                      extend: 'excelHtml5',
//                      title: 'Customer Wise Task',
//                  },
//                  {
//                      extend: 'print',
//                      title: 'Customer Wise Task',
//                  }],
             });
        	 
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



    



function saveAllData() {
	   if (!validateClientMaster()) 
	   { 
	        event.preventDefault();
	   }
	     else 
	   {
	    	 saveAllData1();
	   }
}


function validateClientMaster() {
	
	indexError = 0;

	if ($('#productsuitdetails').val().trim() === '') {
	        callToolTip231('productsuitdetails', 'show');
	        if (indexError == 0) {	      
	        }
	        indexError = indexError + 1;
	} 

	if ($('#securitysolutiondetails').val().trim() === '') {
        callToolTip231('securitysolutiondetails', 'show');
        if (indexError == 0) {	      
        }
        indexError = indexError + 1;
	}
//
//	if ($('#customerName').val().length === 0) {
//	        callToolTip231('customerName', 'show');
//	        if (indexError == 0) {   
//	        }
//	        indexError = indexError + 1;
//	} 
//	if ($('#refNO').val().trim() === '') {
//	        callToolTip231('refNO', 'show');
//	        if (indexError == 0) {	      
//	        }
//	        indexError = indexError + 1;
//	}
	if ($('#bulkUserData').val().trim() === '') {
        callToolTip231('bulkUserData', 'show');
        if (indexError == 0) {	      
        }
        indexError = indexError + 1;
	}
//	if ($('#salesManager').val().trim() === '') {
//        callToolTip231('salesManager', 'show');
//        if (indexError == 0) {	      
//        }
//        indexError = indexError + 1;
//	}

	
	if (indexError > 0) {
        return false;
} else {
        return true;
}
	
}

var callToolTip231 = function(fieldName, status) {

	  
    if (fieldName == "productsuitdetails") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Product Suite <span>";
    }
    if (fieldName == "securitysolutiondetails") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Product Tool<span>";
    }
//    if (fieldName == "customerName") {
//        var errorMessage = "<span>Select Customer<span>";
//    }
//    if (fieldName == "refNO") {
//        //$("#email").tooltip('destroy');
//        var errorMessage = "<span>Enter Ref. No.<span>";
//    }
    if (fieldName == "bulkUserData") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Upload compliance sheet<span>";
    }
//    if (fieldName == "salesManager") {
//        //$("#email").tooltip('destroy');
//        var errorMessage = "<span>Select Sales Manager<span>";
//    }
 

    
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

$('#productsuitdetails').on('focus', function() {
    callToolTip231('productsuitdetails', 'destroy');   
});

$('#securitysolutiondetails').on('focus', function() {
    callToolTip231('securitysolutiondetails', 'destroy');    
});

//$('#companyDiv').on('click', function() {
//    callToolTip231('customerName', 'destroy');    
//});

//$('#refNO').on('focus', function() {
//    callToolTip231('refNO', 'destroy');  
//});

$('#bulkUserData').on('focus', function() {
    callToolTip231('bulkUserData', 'destroy');  
});

//$('#salesManager').on('focus', function() {
//    callToolTip231('salesManager', 'destroy');  
//});

function resetAll() {
	 $('#productsuitdetails').val("");
     $('#securitysolutiondetails').val("");
//     $('#customerName').val("");
//     $('#refNO').val("");
     $('#Description').val("");
//     $('#salesManager').val("");
     
     callToolTip231('productsuitdetails', 'destroy');
     callToolTip231('securitysolutiondetails', 'destroy');
//     callToolTip231('customerName', 'destroy');
//     callToolTip231('refNO', 'destroy');
     callToolTip231('bulkUserData', 'destroy');
//     callToolTip231('salesManager', 'destroy');
}



function EditClient(srno,customerName,ProdSuite,ProdTool,Manager,functionName,TargetDate,Status) {
	
	
	
//	  var l = window.location;
//	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	   	var serviceUrl = base_url + "/Master/getimplementerList";
//	      $.ajax({
//	          type: 'POST',
//	          url: serviceUrl,
//	          dataType: 'json',
//	          success: function(data2) {
//	          //    //("burger"+data2)
//	         	 var html = "  <option value=''> -- Please Select --</option>";
//	 			                    for (var i = 0; i < data2.length; i++) {
//	 				html += '<option value="' + data2[i] + '">' + data2[i]
//	 						+ '</option>';
//	 			}
//	 			document.getElementById("ImplementerNameUpdate").innerHTML = html;	
//	 			 $("#ImplementerNameUpdate").val(Manager);
//	 		}
//	 	});
	
	
	
 	
	   $("#sr_no1").val(srno);
   $("#customerNameUpdate").val(customerName);
   $("#productsuitdetailsUpdate").val(ProdSuite);
   $("#securitysolutiondetailsUpdate").val(ProdTool);
   $("#ImplementerNameUpdate").val(Manager);
   $("#functionNameUpdate").val(functionName);
   $("#toDateUpdate").val(TargetDate);
   $("#statusUpdate").val(Status);
   
	   $("#modelcategory1").modal("show");	   	   
	   
}



function updateClientMaster()
{
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/Master/updateCompositeMaster";
 	var serviceUrl = base_url + "/Master/updateClientMaster";
 	
 	 $.ajax({
         type: 'POST',
         url: serviceUrl, 
         data: 'srno=' + $("#sr_no1").val()
         		+'&customer=' + encodeURIComponent($("#customerNameUpdate").val())
         		+ '&prodSuite=' + encodeURIComponent($("#productsuitdetailsUpdate").val())
         		+ '&prodTool=' + encodeURIComponent($("#securitysolutiondetailsUpdate").val())
         		+ '&managerName=' + encodeURIComponent($("#ImplementerNameUpdate").val())
         		+ '&functionName=' + encodeURIComponent($("#functionNameUpdate").val())
         		+ '&toDateUpdate=' + encodeURIComponent($("#toDateUpdate").val())
         		+ '&statusUpdate=' + encodeURIComponent($("#statusUpdate").val()),
     }).done(function(data) {
//          alert("response: "+data)

         if (data == "success") {
             swal({
                 title: "Successful!",
                 text: "Record Updated Successfully",
                 type: "success",
                 width: 300,
                 height: 200,
        		
               confirmButtonClass: "btn btn-danger",
             
               confirmButtonText: "OK",
                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/ClientMaster";
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
        		 showCancelButton: false,
               confirmButtonClass: "btn btn-danger",
               cancelButtonClass: "btn btn-danger m-l-10",
               confirmButtonText: "OK",
                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/ClientMaster";
                 }

             });

           }
         else if (data == "error") {
             swal({
                 title: "Unsuccessful!",
                 text: "Fail to add file",
                 type: "error",
                 width: 300,
                 height: 200,
//        		 showCancelButton: false,
//               confirmButtonClass: "btn btn-danger",
//               cancelButtonClass: "btn btn-danger m-l-10",
//               confirmButtonText: "OK",
                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/Admin/ClientMaster";
                 }

             });

           }
     });
   }  



function DeleteCompDetails(srno)  {

//alert("gdfsf"+srno)
    swal({
        title: "Are you sure?",
        text: "Do you want to delete?",
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
     	var serviceUrl = base_url + "/PMS/deleteCompEntry";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'crno=' + srno

        }).done(function(data) {
//        	alert(data)
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
                        window.location.href = base_url + "/Admin/RFPupload";
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
                        window.location.href = base_url + "/Admin/RFPupload";
                    }

                });

              }
        });
    });
            }   








//////////////////////////          RFP Task       //////////////////////////

var SR_NO="";

function saveAllData1(){
	
	$("#spin1").show();
	
	var fileInput = document.getElementById("bulkUserData");
    var fileName = fileInput.files[0] ? fileInput.files[0].name : "No file selected";
//    alert("Selected file name: " + fileName);

	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/PMS/ClientMaster"; 
 	var serviceUrl = base_url + "/PMS/submitCompliance";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            
            data: 'productSuit=' + encodeURIComponent($("#productsuitdetails").val())
            		+ '&Securitytool=' + encodeURIComponent($("#securitysolutiondetails").val())
//            		+ '&customerName=' + encodeURIComponent($("#customerName").val())
//            		+ '&refNO=' + encodeURIComponent($("#refNO").val())
//            		+ '&targetDate=' + encodeURIComponent($("#toDate").val())
            		+ '&Description=' + encodeURIComponent($("#Description").val()) 
//            		+ '&salesManager=' + encodeURIComponent($("#salesManager").val()) 
            		+ '&complianceFile=' + encodeURIComponent(fileName), 
        }).done(function(data) {
        	
        	$("#spin1").hide();
        	
        	var result = data.split("~")[0];
        	var Srno = data.split("~")[1];
//          alert("result "+result+ " Srno " + Srno)
          
            if (result == "success") {
            	SR_NO = Srno;
            	
            	saveComplianceFile(Srno);

            }
             else if (result == "duplicate") {
                swal({
                    title: "Duplicate Data!",
                    text: "Record Already Exists, Solution and Ref. No. both are same.",
                    type: "warning",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    confirmButtonClass: "btn btn-danger",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    confirmButtonText: "OK",
//                    preConfirm: function() {
//                    	 var l = window.location;
//                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                         window.location.href = base_url + "/Admin/ComplianceSubmit";
//                    }

                });     

              }
            else if (result == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to add file",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    confirmButtonClass: "btn btn-danger",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    confirmButtonText: "OK",
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/ComplianceSubmit";
                    }

                });

              }
        });
 }









function saveComplianceFile(Srno) {
	$("#spin1").show();

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];

    var serviceUrl = base_url + "/PMS/saveComplianceFile";

    var formData = new FormData($('#bulkuploaduserform')[0]);

    formData.append('productSuit', $("#productsuitdetails").val());
    formData.append('Securitytool', $("#securitysolutiondetails").val());
//    formData.append('customerName', $("#customerName").val());
//    formData.append('refNO', $("#refNO").val()); // 
    formData.append('Srno', Srno);

    // Perform the AJAX request
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        data: formData,
        mimeType: "multipart/form-data",
        contentType: false,
        processData: false,
        cache: false,
        success: function(data) {
        	$("#spin1").hide();
//            alert("Upload data: " + data);
            var response = data.split(" ")[0];
            
            if(response === "Success") { 
//            	alert("upload success");
            	var count = data.split(" ")[1];
            	swal({
                    title: "Successful!",
                    text: "Record inserted Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    confirmButtonClass: "btn btn-danger",
                    confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/RFPupload";
                    }

                });
            } else if(response === "notMandatory") {
            	
            	 swal({
         		    title: "Mandatory fields are empty!",
         		    text: "Module Name and Points are mandatory fields in the sheet.",
         		    type: "warning",
         		    width: 300,
         		    height: 200,
         		   showCancelButton: false,
                   confirmButtonClass: "btn btn-danger",
                   cancelButtonClass: "btn btn-danger m-l-10",
                   confirmButtonText: "OK",
                     buttons: false,
                     allowOutsideClick: false,
         		    preConfirm: function() {

         		        var l2 = window.location;
         		        var base_url2 = l2.protocol + "//" + l2.host + "/" + l2.pathname.split('/')[1];
         		        var serviceUrl2 = base_url2 + "/PMS/deleteCompEntry";

         		        $.ajax({
         		            type: 'POST',
         		            url: serviceUrl2,
         		            data: 'crno=' + SR_NO, // Assuming 'srno' is defined somewhere before
         		            success: function(data) {
         		                // You may want to add logic here to handle the response from the server
         		                console.log('Data Deleted:', data);
         		            },
         		            error: function(xhr, status, error) {
         		                console.error('Error:', error);
         		            }
         		        }).done(function() {
         		            // After successful deletion, redirect
         		            var l3 = window.location;
         		            var base_url3 = l3.protocol + "//" + l3.host + "/" + l3.pathname.split('/')[1];
         		            window.location.href = base_url3 + "/Admin/RFPupload";
         		        });
         		    }
         		});
            	
            	
            } else if(response === "Error") {
            	 	 
            	 swal({
          		    title: "Unsuccessful!",
          		    text: "Fail to add file",
          		    type: "error",
          		    width: 300,
          		    height: 200,
          		   showCancelButton: false,
                    confirmButtonClass: "btn btn-danger",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    confirmButtonText: "OK",
                      buttons: false,
                      allowOutsideClick: false,
          		    preConfirm: function() {

          		        var l2 = window.location;
          		        var base_url2 = l2.protocol + "//" + l2.host + "/" + l2.pathname.split('/')[1];
          		        var serviceUrl2 = base_url2 + "/PMS/deleteCompEntry";

          		        $.ajax({
          		            type: 'POST',
          		            url: serviceUrl2,
          		            data: 'crno=' + SR_NO, // Assuming 'srno' is defined somewhere before
          		            success: function(data) {
          		                // You may want to add logic here to handle the response from the server
          		                console.log('Data Deleted:', data);
          		            },
          		            error: function(xhr, status, error) {
          		                console.error('Error:', error);
          		            }
          		        }).done(function() {
          		            // After successful deletion, redirect
          		            var l3 = window.location;
          		            var base_url3 = l3.protocol + "//" + l3.host + "/" + l3.pathname.split('/')[1];
          		            window.location.href = base_url3 + "/Admin/RFPupload";
          		        });
          		    }
          		}); 
            	 
            }
            
           
        }
    });
}

function RFPTaskDetails(srno,customer,suit,tool,manager,submitDate,sManager,refNo,Status,filename,desc) {
//	alert("S")
	
	$("#customerNameUpdate").val(customer);
	$("#productsuitdetailsUpdate").val(suit);
	$("#securitysolutiondetailsUpdate").val(tool);
	$("#ImplementerNameUpdate").val(manager);
	$("#salesManagerU").val(sManager);
	$("#toDateUpdates").val(submitDate);
	$("#descriptionU").val(submitDate);
	$("#refNo").val(refNo);
	$("#statusText").val(Status);
	
//	$("#rfpFile").val(filename);
	document.getElementById('rfpFile').innerHTML = filename;
	$("#rfpFileStandard").val(filename);
	
	
	$('#modelcategory1').modal('show');
}



function downloadRFPfile() {
	
	var filename = encodeURIComponent($('#rfpFileStandard').val());
//	alert(" filename "+filename);
		event.preventDefault();
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location.href = base_url + "/Inventive/DownloadRFPFile?filename=" + filename;
}
