

window.onload = function() {
	
	 var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getproducutsuitListSupport";

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
	    
//	    $('#customerName').val();
//	    $('#customerName').val('');
	      
	      
	      var l = window.location;
		   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		   	var serviceUrl = base_url + "/Master/getimplementerListSupport";
		//   	alert($('#updImplementerName').val())
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
		 			document.getElementById("ImplementerName").innerHTML = html;	
		 	//		document.getElementById("updImplementerName").innerHTML = html;	
		 		}
		 	});
		      
		      
		      
		      
		      
			  var l = window.location;
				var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
				var serviceUrl = base_url + "/Master/getCustomerNameSupport";

			$.ajax({
			    url :serviceUrl,
			    type : 'POST',
			    dataType: 'json',
			}).done(function(data) {

			    var html= '<option value="">--Please Select Customer--</option>';
			    for (var i = 0; i < data.length; i++) {
			        html += '<option value="' +data[i]+ '">' + data[i]
			        + '</option>';
			    }

			    document.getElementById("customerName").innerHTML=html;
			});
		      
		      
		      
		  	var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getFunctionNameSupport";
		// var selectedValue = $("#functionName").val(); // Get the currently
			// selected value

			$.ajax({
				type : 'POST',
				url : serviceUrl,
				dataType : 'json',
				// data : 'functionName=' + encodeURIComponent(selectedValue),
				success : function(data4) {

					// alert("function "+data4)
					var html = "<option value=''>-- Please Select --</option>";
					for (var i = 0; i < data4.length; i++) {
						var value = data4[i];
						html += '<option value="' + value + '">' + value + '</option>';
					}
					html += "<option value='Other'>Other</option>";
					$("#functionName").html(html);
			//		$("#functionName1").html(html); // Update the select element
				
				}
			});
			
			
$('#customerName').select2({
	tags: true,
	placeholder: "Select a Customer or Enter New",
	// allowClear: true
})


   var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 // 	var serviceUrl = base_url + "/Master/Compositemasterlist";
  	var serviceUrl = base_url + "/Master/getAllClientListSupport";

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
             });

//             table.buttons().container()
//                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');
         }

     });
	    
}


function getSecTools() {
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getsecuritysolutionListSupport";

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



    
    
function saveAllData1(){

//	alert("saveAllData1 Clicked");
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/ClientMasterSupport";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            
            data: 'productSuit=' + encodeURIComponent($("#productsuitdetails").val())
            		+ '&Securitytool=' + encodeURIComponent($("#securitysolutiondetails").val())
            		+ '&customerName=' + encodeURIComponent($("#customerName").val())
            		+ '&ProdManager=' + encodeURIComponent($("#ImplementerName").val())
            		+ '&functionName=' + encodeURIComponent($("#functionName").val())
            		+ '&targetDate=' + encodeURIComponent($("#toDate").val())
            		+ '&status=' + encodeURIComponent($("#status").val()),
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
                        window.location.href = base_url + "/Admin/ClientMasterSupport";
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
                        window.location.href = base_url + "/Admin/ClientMasterSupport";
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
                        window.location.href = base_url + "/Admin/ClientMasterSupport";
                    }

                });

              }
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

	if ($('#securitysolutiondetails').val().length === 0) {
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
	if ($('#ImplementerName').val().length === 0) {
	        callToolTip231('ImplementerName', 'show');
	        if (indexError == 0) {	      
	        }
	        indexError = indexError + 1;
	}
//	if ($('#functionName').val().length === 0) {
//        callToolTip231('functionName', 'show');
//        if (indexError == 0) {	      
//        }
//        indexError = indexError + 1;
//}
	
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
//        //$("#email").tooltip('destroy');
//        var errorMessage = "<span>Select Customer<span>";
//    }
    if (fieldName == "ImplementerName") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Product Manager<span>";
    }
    if (fieldName == "functionName") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Function Name<span>";
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

$('#productsuitdetails').on('focus', function() {
    callToolTip231('productsuitdetails', 'destroy');   
});

$('#securitysolutiondetails').on('focus', function() {
    callToolTip231('securitysolutiondetails', 'destroy');    
});

$('#customerName').on('focus', function() {
    callToolTip231('customerName', 'destroy');    
});

$('#ImplementerName').on('focus', function() {
    callToolTip231('ImplementerName', 'destroy');  
});

//$('#functionName').on('focus', function() {
//    callToolTip231('functionName', 'destroy');  
//});

function resetAll() {
	 $('#productsuitdetails').val("");
     $('#securitysolutiondetails').val("");
     $('#customerName').val("");
     $('#ImplementerName').val("");
//     $('#functionName').val("");
     
     
     
     callToolTip231('productsuitdetails', 'destroy');
     callToolTip231('securitysolutiondetails', 'destroy');
     callToolTip231('customerName', 'destroy');
     callToolTip231('ImplementerName', 'destroy');
//     callToolTip231('functionName', 'destroy');
}



function EditClientSupport(srno,customerName,ProdSuite,ProdTool,Manager,functionName,TargetDate,Status) {
	
	
	
	  var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getimplementerListSupport";
	//   	alert($('#updImplementerName').val())
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
	 			document.getElementById("ImplementerNameUpdate").innerHTML = html;	
	 			 $("#ImplementerNameUpdate").val(Manager);
	 		}
	 	});
	
	
	
 	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getFunctionNameSupport";
// var selectedValue = $("#functionName").val(); // Get the currently
	// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		// data : 'functionName=' + encodeURIComponent(selectedValue),
		success : function(data4) {

			// alert("function "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			html += "<option value='Other'>Other</option>";
			$("#functionNameUpdate").html(html);
			$("#functionNameUpdate").val(functionName);
			
		}
	});
	
//alert("Man "+Manager);
//alert("functionName "+functionName);
//alert("Status "+Status);
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
 	var serviceUrl = base_url + "/Master/updateClientMasterSupport";
 	
 	 $.ajax({
         type: 'POST',
         url: serviceUrl, 
         data: 'srno=' + $("#sr_no1").val()
         		+'&customer=' + encodeURIComponent($("#customerNameUpdate").val())
         		+ '&prodSuite=' + encodeURIComponent($("#productsuitdetailsUpdate").val())
         		+ '&prodTool=' + encodeURIComponent($("#securitysolutiondetailsUpdate").val())
         		+ '&managerName=' + encodeURIComponent($("#ImplementerNameUpdate").val())
//         		+ '&functionName=' + encodeURIComponent($("#functionNameUpdate").val())
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
                     window.location.href = base_url + "/Admin/ClientMasterSupport";
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
                     window.location.href = base_url + "/Admin/ClientMasterSupport";
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
                     window.location.href = base_url + "/Admin/ClientMasterSupport";
                 }

             });

           }
     });
   }  



function DeleteClientDetailsSupport(srno)  {

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
     	var serviceUrl = base_url + "/Master/deleteClientDetailsSupport";

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
                        window.location.href = base_url + "/Admin/ClientMasterSupport";
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
                        window.location.href = base_url + "/Admin/ClientMasterSupport";
                    }

                });

              }
        });
    });
            }   
