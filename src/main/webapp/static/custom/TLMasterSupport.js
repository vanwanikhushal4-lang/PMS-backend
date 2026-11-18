
window.onload = function() {
	
   
	
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getDevelopersSupport";
//   	var selectedValue = $("#functionName").val();

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
// 			document.getElementById("developerNameupdate").innerHTML = html;
// 			$("#Tlname").html(html);
 			
 		}
 	});
	
	
//	sectools22()
//	getSecTools()
	sectools1()
//	  var l = window.location;
//	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	   	var serviceUrl = base_url + "/Master/getproducutsuitListSupport";
//
//	      $.ajax({
//	          type: 'POST',
//	          url: serviceUrl,
//	          dataType: 'json',
//	          
//	          success: function(data2) {
//	          //    //("burger"+data2)
//	         	 var html = "  <option value=''> -- Please Select --</option>";
//	 			                    for (var i = 0; i < data2.length; i++) {
//	 				html += '<option value="' + data2[i] + '">' + data2[i]
//	 						+ '</option>';
//	 			}
//	 			document.getElementById("productsuitdetails").innerHTML = html;	
//	 			document.getElementById("productsuitupdate").innerHTML = html;	
//	 			
//	 		}
//	 	});
	      
//	      alert($('#Tlname').val())
	      
	      
		      
		      var l = window.location;
			   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			   	var serviceUrl = base_url + "/Master/getDevelopersTLSupport";
//			   	var selectedValue = $("#functionName").val();

			      $.ajax({
			          type: 'POST',
			          url: serviceUrl,
			          dataType: 'json',

			          success: function(data2) {
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
	      
	
	      	
//	      var l = window.location;
//	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	  	var serviceUrl = base_url + "/Master/getsecuritysolutionList";
//
//	  	$.ajax({
//	  	    type: 'POST',
//	  	    url: serviceUrl,
//	  	    dataType:'JSON',
//	  	    data: 'productsuit=' + encodeURIComponent($("#productsuitupdate").val())
//	  	}).done(function(data2Array) {
//	  		alert("hhhh"+data2Array)
//	  	    // Split the received data into an array (e.g., comma-separated values)
////	  	    var data2Array = data2.split(','); // Change ',' to the appropriate delimiter
//
//	  	    var html = "<option value=''> -- Please Select --</option>";
//	  	    for (var i = 0; i < data2Array.length; i++) {
//	  	        html += '<option value="' + data2Array[i] + '">' + data2Array[i] + '</option>';
//	  	    }
////	  	    document.getElementById("securitysolutiondetails").innerHTML = html;
//	  	    document.getElementById("securitysolutionupdate").innerHTML = html;
//	  	});
//	      
//	      var l = window.location;
//		   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		   	var serviceUrl = base_url + "/Master/getunitdataList";
//
//		      $.ajax({
//		          type: 'POST',
//		          url: serviceUrl,
//		          dataType: 'json',
//		          success: function(data2) {
//		          //    //("burger"+data2)
//		         	 var html = "  <option value=''> -- Please Select --</option>";
//		 			                    for (var i = 0; i < data2.length; i++) {
//		 				html += '<option value="' + data2[i] + '">' + data2[i]
//		 						+ '</option>';
//		 			}
//		 			document.getElementById("unitdata").innerHTML = html;	
//		 			document.getElementById("unitdataupdate").innerHTML = html;	
//		 		}
//		 	});
	
	
		      
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
			         	 var html = "  <option value=''> -- Please Select --</option><option value='NA'>NA</option>";
			 			                    for (var i = 0; i < data2.length; i++) {
			 				html += '<option value="' + data2[i] + '">' + data2[i]
			 						+ '</option>';
			 			}
			 			document.getElementById("ImplementerName").innerHTML = html;	
			 			document.getElementById("updImplementerName").innerHTML = html;	
			 		}
			 	});
		
		
		      
		      
//		      var l = window.location;
//			   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			   	var serviceUrl = base_url + "/Master/getsecuritysolutionList";
//
//			      $.ajax({
//			          type: 'POST',
//			          url: serviceUrl,
//			          dataType: 'json',
//			          success: function(data2) {
//			          //    //("burger"+data2)
//			         	 var html = "  <option value=''> -- Please Select --</option>";
//			 			                    for (var i = 0; i < data2.length; i++) {
//			 				html += '<option value="' + data2[i] + '">' + data2[i]
//			 						+ '</option>';
//			 			}
//			 			document.getElementById("securitysolutiondetails").innerHTML = html;		
//			 			
//			 		}
//			 	});
//	
	
	
	
	
	
//    var l = window.location;
//  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//  	var serviceUrl = base_url + "/Master/TlmasterlistingSupport";
//
//     $.ajax({
//         type: 'POST',
//         url: serviceUrl,
//         dataType: 'json',
//         success: function(data4) {
//             var table = $('#productdata').DataTable({
//                 lengthChange: false,
//                 data: data4,
//                  "pageLength": 10,
//                  scrollX:true,
//                  scrollY:true
//             });
//
//             table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');
//
//         }
//
//     });
			      
			    
			      var l = window.location;
			      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			      var serviceUrl = base_url + "/Master/TlmasterlistingSupport";

			      $.ajax({
			          type: 'POST',
			          url: serviceUrl,
			          dataType: 'json',
			          success: function(data4) {

			        	  
			              // destroy previous DT if exists to avoid duplicate table issues
			              if ($.fn.DataTable.isDataTable('#productdata')) {
			                  $('#productdata').DataTable().clear().destroy();
			              }

			              var table = $('#productdata').DataTable({
			                  lengthChange: false,
			                  data: data4,
			                  pageLength: 10,
			                  autoWidth: false,        // important: stop DataTables automatic sizing
			                  scrollX: true,         // DO NOT use scrollX if you want minimum widths
			                  responsive: false,      // disable responsive autosizing

			                  columnDefs: [
			                      // Set widths by column index (most reliable)
			                      { targets: 0, width: '20px', searchable: false },  // Sr No
			                      { targets: 1, width: '40px', orderable: false, searchable: false },
			                      { targets: 2, width: '40px', orderable: false, searchable: false },
			                      { targets: 3, width: '80px' },
			                      { targets: 4, width: '80px' },
			                      { targets: 5, width: '80px' }

			                      // Wrap displayed cell content in an inline element so CSS truncation works reliably
			                      
			                  ],
			                  createdRow: function(row, data, dataIndex) {
			                	    $('td:eq(0)', row).text(dataIndex + 1);
			                	},
			                	drawCallback: function() {
			                	    table.columns.adjust();
			                	}
			              });

			              // Optional: move buttons if you use Buttons extension
			              if (table.buttons) {
			                  table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');
			              }
			          },
			          error: function(xhr, status, err) {
			              console.error('AJAX error:', status, err);
			          }
			      });

			      // small helper to escape HTML in titles
			      function htmlspecialchars(str) {
			          return String(str).replace(/&/g, '&amp;').replace(/"/g, '&quot;')
			                            .replace(/'/g, '&#039;').replace(/</g, '&lt;')
			                            .replace(/>/g, '&gt;');
			      }

     
     
     
//	  var l = window.location;
//		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/Master/getCustomerNameSupport";
//
//	$.ajax({
//	    url :serviceUrl,
//	    type : 'POST',
//	    dataType: 'json',
//	}).done(function(data) {
//
//	    var html= '<option value="">--Please Select Customer--</option>';
//	    for (var i = 0; i < data.length; i++) {
//	        html += '<option value="' +data[i]+ '">' + data[i]
//	        + '</option>';
//	    }
//
//	    document.getElementById("customerName").innerHTML=html;
//	});
//	
//	$('#customerName').select2({
//		tags: true,
//		placeholder: "Select a Customer or Enter New",
//		// allowClear: true
//	})

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
//	    document.getElementById("securitysolutionupdate").innerHTML = html;
	});
	}


function validateProductMaster() {
    var indexError = 0;
   
    if ($('#ImplementerName').val().trim() === '') {
        callToolTip231('ImplementerName', 'show');
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
    if ($('#mappedWith').val()=== 'Team Leader' && $('#Tlname').val().trim() === '' ) {
        callToolTip231('Tlname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ( $('#mappedWith').val()=== 'Support' && $('#developerName').val().trim() === '' ) {
        callToolTip231('developerName', 'show');
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

    
     if (fieldName == "ImplementerName") {
         var errorMessage = "<span>Please Select Manager Name<span>";
     }
     else if (fieldName == "mappedWith") {
         var errorMessage = "<span>Please Select Option<span>";
     }
     else if (fieldName == "Tlname") {
         var errorMessage = "<span>Please Select Team Leader<span>";
     }
     else if (fieldName == "developerName") {
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




//$('#unitdata').on('focusout', function() {
//	var usertype = $('#unitdata').val();
//	if(usertype.trim() == "") {
//		callToolTip231('unitdata', 'show');
//	} else {
//		callToolTip231('unitdata', 'hide');
//	}
//});



$('#ImplementerName').on('focus', function() {
	callToolTip231('ImplementerName', 'destroy');
});

$('#mappedWith').on('focus', function() {
	callToolTip231('mappedWith', 'destroy');
});

$('#Tlname').on('focus', function() {
	callToolTip231('productsuitdetails', 'destroy');
});
$('#developerName').on('focus', function() {
	callToolTip231('developerName', 'destroy');
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
    
     
     $("#ImplementerName").val("");
     callToolTip231('ImplementerName', 'hide');
     
     $("#mappedWith").val("");
     callToolTip231('mappedWith', 'hide');
     
     $("#Tlname").val("");
     callToolTip231('Tlname', 'hide');
     
     $("#developerName").val("");
     callToolTip231('developerName', 'hide');
       
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
 	var serviceUrl = base_url + "/Master/saveTlMasterSupport";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'productsuit=' + encodeURIComponent($("#productsuitdetails").val())
            		+ '&securitysolution=' + encodeURIComponent($("#securitysolutiondetails").val())
            		+ '&unitdata=' + encodeURIComponent($("#unitdata").val())
            		+ '&ImplementerName=' + encodeURIComponent($("#ImplementerName").val())
            		+ '&Tlname=' + encodeURIComponent($("#Tlname").val())
            		+ '&developerName=' + encodeURIComponent($("#developerName").val())
            		+ '&customerName=' + encodeURIComponent($("#customerName").val()),
            		
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
                        window.location.href = base_url + "/Admin/TLMasterSupport";
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
                        window.location.href = base_url + "/Admin/TLMasterSupport";
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
                        window.location.href = base_url + "/Admin/TLMasterSupport";
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
//     	var serviceUrl = base_url + "/Master/deleteTlMasterSupport";
     	var serviceUrl = base_url + "/Master/deleteTlMaster";

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
                    type: "error",
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


function EditProductMaster(srno,productsuit , securitysolution ,ImplementerName, team_lead, developer)
{
	
//	alert(developer)
//	alert(ImplementerName)
//	alert(team_lead)
//	alert(securitysolution);
	
	 $("#productsuitupdate").val(productsuit);
	 $("#securitysolutionupdate").val(securitysolution); 
	 
	 $("#updImplementerName").val(ImplementerName);
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
//	updateproducrmasterNew();
	if (!validateProductMasterUpdate()) 
	   { 
	        event.preventDefault();
	   }
	     else 
	   {
	    	 updateproducrmasterNew();
	   }
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
   var serviceUrl = base_url + "/Master/updateTLMasterSupportNew";
   
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
                         window.location.href = base_url + "/Admin/TLMasterSupport";
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
                         window.location.href = base_url + "/Admin/TLMasterSupport";
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

	   
	        if (mappedValue === "Team Leader") {
//	        	alert("inside")
	        	
	            $('#TlnameDiv').show();
	        	$('#developerNameDiv').hide();
//	        	 $('#Tlname').css('display', 'block');
	        	
	          
	        } else if (mappedValue === "Support") {
	        	
//	        	alert("inside")
	            
	        	
	        	$('#TlnameDiv').show();
	        	$('#developerNameDiv').show();
	        	
	        	var l = window.location;
			   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			   	var serviceUrl = base_url + "/Master/getDevelopersSupport";
//			   	var selectedValue = $("#functionName").val();

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
			 			document.getElementById("developerName").innerHTML = html;
//			 			document.getElementById("developerNameupdate").innerHTML = html;
//			 			$("#Tlname").html(html);
			 			
			 		}
			 	});
	        	
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
		        	
		          
		        } else if (mappedWithN === "Support") {
		        	
//		        	alert("inside")
		            
		        	
		        	$('#TlnameDivN').show();
		        	$('#developerNameDivN').show();
		        	
		        	var l = window.location;
				   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
				   	var serviceUrl = base_url + "/Master/getDevelopersSupport";
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

