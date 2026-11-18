window.onload = function() {
	
	
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/PMS/getProductSuiteTree";

  	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {

			var html = " <option value=''> -- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {

				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}

			document.getElementById("productsuite").innerHTML = html;

		}

	})
	
	
	
	var serviceUrl = base_url + "/PMS/getTreeMasterListing";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data4) {
            var table = $('#productdatatree').DataTable({
                lengthChange: false,
                data: data4,
                 "pageLength": 5,
                 scrollX:true,
                 scrollY:true
            });

           /* table.buttons().container()
                    .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');*/

        }

    });

 }



function getSecuritySolutionTree(){
	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/PMS/getSecuritySolutionTree";

  	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data: { 
			product_suite: $("#productsuite").val()
			},
		success : function(data4) {

			var html = " <option value=''> -- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {

				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}

			document.getElementById("securitysolution").innerHTML = html;

		}

	})
}



//23/05
function validateUser(){
	if (!validateTreeMaster()) {
		
		event.preventDefault();

	} else{
		
		getTreeMasterDetails();
	}
}


function validateTreeMaster()
{
	event.preventDefault();
	var indexError=0;
	if($('#productsuite').val().trim()===''){
		callTollTip('productsuite','show');
		if(indexError==0){
			
		}
		indexError = indexError + 1;
	}
	if($('#securitysolution').val().trim()===''){
		callTollTip('securitysolution','show');
		if(indexError==0){
			
		}
		indexError = indexError + 1;
	}
	if($('#projectname').val().trim()===''){
		callTollTip('projectname','show');
		if(indexError==0){
			
		}
		indexError = indexError + 1;
	}
	if (indexError > 0) {
		return false;

	} else {
		return true;
	}
}



var callTollTip=function(fieldName,status){
//	alert("inside callToolTip")
	var errorMessage;
//	alert("fieldName" +fieldName)
	if(fieldName=="productsuite"){
		
		errorMessage="<span>Please enter product suite</span>";
	}
	else if(fieldName=="securitysolution"){
		errorMessage="<span>Please enter security solution</span>";
	}
	else if(fieldName=="projectname"){
		errorMessage="<span>Please enter project name</span>";
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



$('#productsuite').on('focusout', function() {

    var usertype = $('#productsuite').val();

    if (usertype.trim() == "") {
    		callTollTip('productsuite', 'show');
    } else {
    		callTollTip('productsuite', 'hide');
    }
});
$('#securitysolution').on('focusout', function() {

    var usertype = $('#securitysolution').val();

    if (usertype.trim() == "") {
    		callTollTip('securitysolution', 'show');
    } else {
    		callTollTip('securitysolution', 'hide');
    }
});
$('#projectname').on('focusout', function() {

    var usertype = $('#projectname').val();

    if (usertype.trim() == "") {
    		callTollTip('projectname', 'show');
    } else {
    		callTollTip('projectname', 'hide');
    }
});



$('#productsuite').on('focus', function() {
	callTollTip('productsuite', 'destroy');
});
$('#securitysolution').on('focus', function() {
	callTollTip('securitysolution', 'destroy');
});

$('#projectname').on('focus', function() {
	callTollTip('projectname', 'destroy');
});

$("#resetbtn").click(function() {
    $("#productsuite").val("");
    callTollTip('productsuite', 'hide');

    $("#securitysolution").val("");
    callTollTip('securitysolution', 'hide');
     
      $("#projectname").val("");
      callTollTip('projectname', 'hide');   
});


//



function getTreeMasterDetails(){
	alert("hiii")
	   // AJAX CALL TO SAVE
	event.preventDefault();
	   var l = window.location;
	   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   var serviceUrl = base_url + "/PMS/getTreeMasterDetails";
	
	   $.ajax({
	       type: 'POST',
	       url: serviceUrl,
	       data: 'product_suite=' + $("#productsuite").val() +
	       		'&security_solution=' + $("#securitysolution").val()+
	       		'&project_name=' + $("#projectname").val() 
	        
	   }).done(function(data) {
	       if (data == "success") {
	         swal({
	           title: "Successful!",
	           text: "Record Inserted Successfully",
	           type: "success",
	           width: 300,
	           height: 200,
//	      showCancelButton: false,
//	         confirmButtonClass: "btn btn-danger",
//	         cancelButtonClass: "btn btn-danger m-l-10",
//	         confirmButtonText: "OK",
	           buttons: false,
	           allowOutsideClick: false,
	           preConfirm: function () {
	               var l = window.location;
	               var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	               window.location.href = base_url + "/Admin/treeMaster";
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
	                   window.location.href = base_url + "/Admin/treeMaster";
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
	               buttons: false,
	               allowOutsideClick: false,
	               preConfirm: function() {
	                   var l = window.location;
	                   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                   window.location.href = base_url + "/Admin/treeMaster";
	               }

	           });

	         }
	   });
	 }



function DeleteTreeMaster(srno)  {

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
     	var serviceUrl = base_url + "/PMS/deleteTreeMaster";

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
                        window.location.href = base_url + "/Admin/treeMaster";
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
                        window.location.href = base_url + "/Admin/treeMaster";
                    }

                });

              }
        });
    });
  } 
          


var sr_no1;
function EditTreeMaster(srno,productsuit,securitysolution,projectname)
{	
	  sr_no1=srno;
	  $("#modelproductmaster").modal("show");	
	  
	  
	  $("#productsuitupdate1").val(productsuit);
	  $("#securitysolutionupdate11").val(securitysolution); 
	  $("#projectnameupdate1").val(projectname);
	  			  
}



$("#update_treeMasterType_btn").click(function () {

     updatetreemaster(sr_no1);
}).show();


function updatetreemaster(srno) {
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/updatetreemaster";
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: {
            sr_no: srno,
            productsuitupdate1: $('#productsuitupdate1').val(),
            securitysolutionupdate11: $('#securitysolutionupdate11').val(),
            projectnameupdate1: $('#projectnameupdate1').val()
        },
        success: function(data) {
            if (data === "success") {
                swal({
                    title: "Successful!",
                    text: "Record Updated Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/treeMaster";
                    }
                });
            } else if (data === "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Record not updated",
                    type: "error",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/treeMaster";
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
 	                   window.location.href = base_url + "/Admin/treeMaster";
 	               }

 	           })
            }
 	           
        }
    });
}







