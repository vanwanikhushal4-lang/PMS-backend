window.onload = function() {
	
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
           async: false,
         success: function(data4) {
//             //alert(data4)
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        //alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("cname").innerHTML = html;
             }
     });
     //CODE FOR GROUP 

    $('#category').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Category or Enter New",
//        allowClear: true
    })
    $('#subcategory1').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub-Category 1 or Enter New",
//        allowClear: true
    })
    $('#subcategory2').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub-Category 2 or Enter New",
//        allowClear: true
    })
    $('#priority').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Priority or Enter New",
//        allowClear: true
    })
    $('#severity').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Severity or Enter New",
//        allowClear: true
    })
       $('#subject').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Subject or Enter New",
//        allowClear: true
    })
      
   
    $('#company').focus();
    
    ////////// GET PROBLEM CATEGORY ////////////////
    
   // //alert(companyforcategory);
    
   
       
       
    ////////// GET SUBJECT LISTING /////////
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/ServiceCatalogueListing";
//     var serviceUrl = "CategoryDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//        	 //alert(data4)
             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 5,
                  scrollX:true,
                  scrollY:true
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });
     

 }

var companyforcategory="";
function    getcompanyforgroup(company){
	companyforcategory=company;
	// //alert(company );
  // //alert(" hello" +$("#cname").val());
    var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getGropupfromgroupmaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data:'company='+encodeURIComponent(company),
           async: false,
         success: function(data4) {
//             //alert(data4)
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        //alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("groupselect").innerHTML = html;
             }
     });
     

   //get desiganation Code

   var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/getDesignationForLoginMaster";
   $.ajax({
       type: 'POST',
       url: serviceUrl,
       dataType: 'json',
       data: 'company=' + encodeURIComponent(company),
       success: function(data4) {
                  var html = "  <option value=''> -- Please Select --</option>";
                  for (var i = 0; i < data4.length; i++) {
//                       //alert(data4[i]);
                      html += '<option value="' + data4[i] + '">' + data4[i]
                              + '</option>';
                  }

                  document.getElementById("Designarionlevel1").innerHTML = html;
                  document.getElementById("Designarionlevel2").innerHTML = html;
           }

           
   });
   
  
   var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getCategoryDetailsListforcatalogue";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data:'company='+encodeURIComponent(company),
        success: function(data2) {
//            //alert(data2)
       	 var html = "  <option value=''> -- Please Select --</option>";
                   for (var i = 0; i < data2.length; i++) {
                       html += '<option value="' + data2[i] + '">' + data2[i]
                               + '</option>';
                   }
                   document.getElementById("category").innerHTML = html;
            }
});
    
//////////GET PROBLEM SUBCATEGORY 1 ////////////////
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getSubCategory1forcatalogue";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data:'company='+encodeURIComponent(company),
         success: function(data2) {
//             //alert(data2)
        	 var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data2.length; i++) {
                        html += '<option value="' + data2[i] + '">' + data2[i]
                                + '</option>';
                    }
                    document.getElementById("subcategory1").innerHTML = html;
             }
}); 
     
//////////GET PROBLEM SUBCATEGORY 2 ////////////////
     var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getSubCategory2forcatalogue";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          data:'company='+encodeURIComponent(company),
          success: function(data2) {
//              //alert(data2)
         	 var html = "  <option value=''> -- Please Select --</option>";
                     for (var i = 0; i < data2.length; i++) {
                         html += '<option value="' + data2[i] + '">' + data2[i]
                                 + '</option>';
                     }
                     document.getElementById("subcategory2").innerHTML = html;
              }
 });       
   
//////////GET SUBJECT ////////////////
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getSubjectforcatforcatalogue";

       $.ajax({
           type: 'POST',
           url: serviceUrl,
           dataType: 'json',
           data:'company='+encodeURIComponent(company),
           success: function(data2) {
//               //alert(data2)
           	var html = "  <option value=''> -- Please Select --</option>";
               for (var i = 0; i < data2.length; i++) {
                   html += '<option value="' + data2[i] + '">' + data2[i]
                           + '</option>';
               }
               document.getElementById("subject").innerHTML = html;
        }
  }); 
       
       //////////GET Priority ////////////////
       var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/getPriorityNameforcatalogue";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            data:'company='+encodeURIComponent(company),
            success: function(data2) {
//                //alert(data2)
            	var html = "  <option value=''> -- Please Select --</option>";
                for (var i = 0; i < data2.length; i++) {
                    html += '<option value="' + data2[i] + '">' + data2[i]
                            + '</option>';
                }
                document.getElementById("priority").innerHTML = html;
         }
   });     
      
        //////////GET Severity ////////////////
        var l = window.location;
      	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
      	var serviceUrl = base_url + "/Master/getSeverityNameforcatalogue";

         $.ajax({
             type: 'POST',
             url: serviceUrl,
             dataType: 'json',
             data:'company='+encodeURIComponent(company),
             success: function(data2) {
//                 //alert(data2)
             	var html = "  <option value=''> -- Please Select --</option>";
                 for (var i = 0; i < data2.length; i++) {
                     html += '<option value="' + data2[i] + '">' + data2[i]
                             + '</option>';
                 }
                 document.getElementById("severity").innerHTML = html;
          }
    });     
   
   
    }

//CHANGE FUNCTION FOR STANDARD
function getstandard(value)
{
	 document.getElementById("matrixlable").style.display = "NONE";
	 $('#levelone').prop('checked', false);
	 document.getElementById("desig2").style.display = "none";
	 document.getElementById("desig1").style.display = "none";
	 $('#leveltwo').prop('checked', false);
	
	
	if(value =="Non Standard"){
		
		 document.getElementById("levelonedive").style.display = "block";
		 document.getElementById("leveltwodiv").style.display = "block";
		 document.getElementById("hrid").style.display = "block";
		 document.getElementById("matrixlable").style.display = "block";
		 
	}else
	{
		document.getElementById("levelonedive").style.display = "none";
		 document.getElementById("leveltwodiv").style.display = "none";
		 document.getElementById("hrid").style.display = "none";
	}

}
var callToolTip231 = function(fieldName, status) {

    if (fieldName == "categoryProblemDiv") {
        var errorMessage = "<span>Please Enter or Select Category<span>";
    }
    else if (fieldName == "subcategory1Div"){
    	var errorMessage = "<span>Please Enter or Select Sub Category 1<span>";
    }
    else if (fieldName == "subcategory2Div"){
    	var errorMessage = "<span>Please Enter or Select Sub Category 2<span>";
    }
    else if (fieldName == "priorityDiv") {
        var errorMessage = "<span>Please Enter or Select Priority<span>";
    }
    else if (fieldName == "severityDiv") {
        var errorMessage = "<span>Please Enter or Select Severity<span>";
    }
    else if (fieldName == "cname") {
        var errorMessage = "<span>Please Select Company<span>";
    }
    else if (fieldName == "subjectDiv") {
        var errorMessage = "<span>Please Enter or Select Subject<span>";
    }
    else if (fieldName == "servicestandard") {
        var errorMessage = "<span>Please  Select Standard<span>";
    }
    else if (fieldName == "groupDiv") {
        var errorMessage = "<span>Please  Select Group<span>";
    }
    else if (fieldName == "levelone") {
        var errorMessage = "<span>Please Check Atlease level one designation <span>";
    }
    else if (fieldName == "Designarionlevel2") {
        var errorMessage = "<span>Please  Select Level two designation <span>";
    }
    else if (fieldName == "Designarionlevel1") {
        var errorMessage = "<span>Please  Select Level one designation<span>";
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

$('#category').on('focusout', function() {
    var usertype = $('#category').val();

    if (usertype.trim() == "") {
        callToolTip231('categoryProblemDiv', 'show');
    }
    else {
        callToolTip231('categoryProblemDiv', 'hide');
    }
});
$('#priority').on('focusout', function() {
    var usertype = $('#priority').val();

    if (usertype.trim() == "") {
        callToolTip231('priorityDiv', 'show');
    }
    else {
        callToolTip231('priorityDiv', 'hide');
    }
});
$('#severity').on('focusout', function() {
    var usertype = $('#severity').val();

    if (usertype.trim() == "") {
        callToolTip231('severityDiv', 'show');
    }
    else {
        callToolTip231('severityDiv', 'hide');
    }
});
$('#subcategory1').on('focusout', function() {
    var usertype = $('#subcategory1').val();

    if (usertype.trim() == "") {
        callToolTip231('subcategory1Div', 'show');
    }
    else {
        callToolTip231('subcategory1Div', 'hide');
    }
});
$('#subcategory2').on('focusout', function() {
    var usertype = $('#subcategory2').val();

    if (usertype.trim() == "") {
        callToolTip231('subcategory2Div', 'show');
    }
    else {
        callToolTip231('subcategory2Div', 'hide');
    }
});
$('#subject').on('focusout', function() {
    var usertype = $('#subject').val();

    if (usertype.trim() == "") {
        callToolTip231('subjectDiv', 'show');
    }
    else {
        callToolTip231('subjectDiv', 'hide');
    }
});
//$('#cname').on('focusout', function() {
//    var usertype = $('#subject').val();
//
//    if (usertype.trim() == "") {
//        callToolTip231('cname', 'show');
//    }
//    else {
//        callToolTip231('cname', 'hide');
//    }
//});


$('#categoryProblemDiv').on('click', function() { //select2-category-container
callToolTip231('categoryProblemDiv', 'destroy');
});

$('#priorityDiv').on('click', function() {
	callToolTip231('priorityDiv', 'destroy');
	});
$('#severityDiv').on('click', function() {
	callToolTip231('severityDiv', 'destroy');
	});
$('#subcategory1Div').on('click', function() {
	callToolTip231('subcategory1Div', 'destroy');
	});
$('#subcategory2Div').on('click', function() {
	callToolTip231('subcategory2Div', 'destroy');
	});
$('#subjectDiv').on('click', function() {
	callToolTip231('subjectDiv', 'destroy');
	});
$('#cname').on('click', function() {
	callToolTip231('cname', 'destroy');
	});


$('#categoryProblemDiv').on('click', function() {
	callToolTip231('categoryProblemDiv', 'destroy');
	});
$('#servicestandard').on('click', function() {
	callToolTip231('servicestandard', 'destroy');
	});
$('#groupDiv').on('click', function() {
	callToolTip231('groupDiv', 'destroy');
	});
$('#levelone').on('click', function() {
	callToolTip231('levelone', 'destroy');
	});

$('#Designarionlevel2').on('click', function() {
	callToolTip231('Designarionlevel2', 'destroy');
	});

$('#Designarionlevel1').on('click', function() {
	callToolTip231('Designarionlevel1', 'destroy');
	});



function validateCategory() {
	
	////alert("hii");
    var indexError = 0;
//    alert($("#SUBJECT_TYPE").val())
   
    if ($('#category').val()==''||$('#category').val()==null) {
        callToolTip231('categoryProblemDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#cname').val().trim() === '' ||$('#category').val()==null) {
        callToolTip231('cname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#subcategory1').val()== '' ||$('#subcategory1').val()==null) {
        callToolTip231('subcategory1Div', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#subcategory2').val()== '' ||$('#subcategory2').val()==null) {
        callToolTip231('subcategory2Div', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#subject').val()=='' ||$('#subject').val()==null) {
        callToolTip231('subjectDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#priority').val() === '' ||$('#priority').val()==null) {
        callToolTip231('priorityDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#severity').val()== '' ||$('#severity').val()==null) {
        callToolTip231('severityDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#servicestandard').val().trim() === '') {
        callToolTip231('servicestandard', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#groupselect').val().trim() === '') {
        callToolTip231('groupDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if($('#servicestandard').val() =='Non Standard'){
   // //alert(   document.querySelector('#levelone:checked'));
 //   document.querySelector('#levelone:checked') !== null
    if (document.querySelector('#levelone:checked') == null) {
    	// //alert(   document.querySelector('#levelone:checked'));
        callToolTip231('levelone', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#Designarionlevel1').val().trim() === '' && document.querySelector('#levelone:checked') ) {
        callToolTip231('Designarionlevel1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#Designarionlevel2').val().trim() === '' && forvalidationcheck==true) {
        callToolTip231('Designarionlevel2', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    
    if($('#Designarionlevel2').val() !="" && $('#Designarionlevel2').val()==$('#Designarionlevel1').val() && $('#servicestandard').val() == 'Non Standard')
    {
    	
		
    	swal({
            title: "Duplicate Data!",
            text: "Please Select Two Different Designation",
            type: "warning",
            width: 300,
            height: 200,
//   		 showCancelButton: false,
//          confirmButtonClass: "btn btn-danger",
//          cancelButtonClass: "btn btn-danger m-l-10",
//          confirmButtonText: "OK",
            buttons: false,
            allowOutsideClick: false,
          
        });

	

		  indexError = indexError + 1;
	

    	
    	
    	////alert("hi");
    	
    }
    
    }
    

    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}


$("#submit-btn").click(function() {

    if (!validateCategory()) {
    	event.preventDefault();
    } else {
    	saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {
	$("#cname").val('').trigger('change')
	$("#category").val('').trigger('change')
	$("#priority").val('').trigger('change')
	$("#severity").val('').trigger('change')
	$("#subcategory1").val('').trigger('change')
	$("#subcategory2").val('').trigger('change')  //subjectDiv
	$('#levelone').prop('checked', false); 
	$('#leveltwo').prop('checked', false); 
	$("#groupselect").val('').trigger('change')
	$("#servicestandard").val('').trigger('change')
	$("#requestcost").val('');
	$("#subject").val('').trigger('change')
	$("#Designarionlevel1").val('').trigger('change')
	$("#Designarionlevel2").val('').trigger('change')
	
	
	
	
	
	callToolTip231('cname', 'destroy');
	 callToolTip231('subjectDiv', 'destroy');
     callToolTip231('categoryProblemDiv', 'destroy');
	callToolTip231('priorityDiv', 'destroy');
	callToolTip231('severityDiv', 'destroy');
     callToolTip231('subcategory1Div', 'destroy');
     callToolTip231('subcategory2Div', 'destroy');
     callToolTip231('servicestandard', 'destroy');
     callToolTip231('groupDiv', 'destroy');
     callToolTip231('levelone', 'destroy');
     
     callToolTip231('cname', 'destroy');
     callToolTip231('Designarionlevel2', 'destroy');
     callToolTip231('Designarionlevel1', 'destroy');
     

});



//SHOW WHEN CLICK ON CHEKC BOX
jQuery(".levelone").click(function()
        {
	$('#Designarionlevel1').val('');
            if(jQuery(this).is(":checked"))
            	{
            	 document.getElementById("desig1").style.display = "block";
            	}
              
            else{
            	 document.getElementById("desig1").style.display = "none";
            	
            }
            	
              
        });

var forvalidationcheck=false;
jQuery(".leveltwo").click(function()
        {
	$('#Designarionlevel2').val('');
            if(jQuery(this).is(":checked"))
            	{
            	forvalidationcheck=true;
            	 document.getElementById("desig2").style.display = "block";
            	}
              
            else{
            	forvalidationcheck=false;
            	 document.getElementById("desig2").style.display = "none";
            	
            }
            	
              
        });



function saveDataCompany()  {
	
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/addNewServiceCatalogue";
	
//        var serviceUrl = "addcategory";
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'category=' + encodeURIComponent($("#category").val().trim())
            		+ '&subcategory1=' + encodeURIComponent($("#subcategory1").val().trim())
            		+ '&subcategory2=' + encodeURIComponent($("#subcategory2").val().trim())
            		+ '&subject=' + encodeURIComponent($("#subject").val().trim())
            		+ '&company=' + encodeURIComponent($("#cname").val().trim())
            		+ '&priority=' + encodeURIComponent($("#priority").val().trim())
            		+ '&severity=' + encodeURIComponent($("#severity").val().trim())
            		+ '&servicestandard=' + encodeURIComponent($("#servicestandard").val().trim())
            		+ '&groupselect=' + encodeURIComponent($("#groupselect").val().trim())
            		+ '&levelone=' + encodeURIComponent($("#levelone").val().trim())
            		+ '&leveltwo=' + encodeURIComponent($("#leveltwo").val().trim())
            		+ '&Designarionlevel2=' + encodeURIComponent($("#Designarionlevel2").val().trim())
            		+ '&Designarionlevel1=' + encodeURIComponent($("#Designarionlevel1").val().trim())
            		+ '&requestcost=' + encodeURIComponent($("#requestcost").val().trim())
            		+ '&SUBJECT_TYPE=' + encodeURIComponent($("#SUBJECT_TYPE").val().trim())
            		
        }).done(function(data) {
//             //alert("response: "+data)

            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Added Successfully",
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
                        window.location.href = base_url + "/Admin/ServiceCatalogueMaster";
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
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/ServiceCatalogueMaster";
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
                        window.location.href = base_url + "/Admin/ServiceCatalogueMaster";
                    }

                });

              }
        });
    //});
            }  


function DeleteServiceCatalogue(srno)  {

////alert("gdfsf"+srno)
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
     	var serviceUrl = base_url + "/Master/deleteServiceCatalogue";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'crno=' + srno

        }).done(function(data) {
//        	//alert(data)
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
                        window.location.href = base_url + "/Admin/ServiceCatalogueMaster";
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
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/ServiceCatalogueMaster";
                    }

                });

              }
        });
    });
            }   
///////////////Edit Service Catelogue Master//////////
function EditCategory(srno,company,category,subCat1,subCat2,priority,seviarity,subject,reqType,Approvel,grpName,level1,level2,reqCost,aprllvel,subtype) {
	
//	alert(grpName)
	  $('#categorynameupdate').select2({
//	      theme: 'bootstrap4'
	    	 width:'100%',
	    	tags: true,
	    	placeholder: "Select a Category or Enter New",
//	        allowClear: true
	    })
	    
	       $('#subjectup').select2({
//	      theme: 'bootstrap4' 	  
	   	multiple: false,
	    	tags: true,
	    	width:'100%',
	    	placeholder: "Select a Subject or Enter New",
//	        allowClear: true
	    	
	    	 dropdownParent: $('#modelcategory1')
	    	  
	    })
	          
	    //////////update
	     $('#subcategory1up').select2({
//	      theme: 'bootstrap4'
	    	tags: true,
	    	width:'100%',
	    	placeholder: "Select a Sub Category or Enter New",
	    	 dropdownParent: $('#modelcategory1')
//	        allowClear: true
	    })
	      $('#subcategory2up').select2({
//	      theme: 'bootstrap4'
	    	tags: true,
	    	width:'100%',
	    	placeholder: "Select a Sub Category or Enter New",
	    	 dropdownParent: $('#modelcategory1')
//	        allowClear: true
	    })
	   
	    $('#priorityup').select2({
//	      theme: 'bootstrap4'
	    	tags: true,
	    	width:'100%',
	    	placeholder: "Select a Priority or Enter New",
	    	 dropdownParent: $('#modelcategory1')
//	        allowClear: true
	    })
	      $('#severityup').select2({
//	      theme: 'bootstrap4'
	    	tags: true,
	    	width:'100%',
	    	placeholder: "Select a Seviarity or Enter New",
	    	 dropdownParent: $('#modelcategory1')
//	        allowClear: true
	    })
	     
//	 //alert("j")
//	 aler(subCat2)
	   var data3;
	  data3=[];
	 var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getGropupfromgroupmaster";
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
	         data:'company='+encodeURIComponent(company),
	           async: false,
	         success: function(data4) {
            //alert(data4)
//	        	 for (var i = 0; i < data4.length; i++) {
////	                  	data4[i].push(dadatrata3)
//	        		   data3.push(data4[i])
////	        		   
//	                    }
//	        		//alert(data3)
	                    var html = "  <option value=''> -- Please Select --</option>";
	                    for (var i = 0; i < data4.length; i++) {
//	                        //alert(data4[i]);
	                        html += '<option value="' + data4[i] + '">' + data4[i]
	                                + '</option>';
	                    }

	                    document.getElementById("groupselectup").innerHTML = html;
	                    $("#groupselectup").val(grpName);
	                  //  $("#groupselectup").val(reqType);
	                    
	             }
	     
	     
	     });
//
//	     if(data3.length <0)
//	    	 {
//	    	 //alert("FGFG")
//	    	 $("#groupselectup").val(grpName);
//	    	 }
//	     

	   //get desiganation Code

	  
//	   var l = window.location;
//	   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	   var serviceUrl = base_url + "/Master/getDesignationForLoginMastel2";
//	   $.ajax({
//	       type: 'POST',
//	       url: serviceUrl,
//	       dataType: 'json',
//	       data: 'company=' + encodeURIComponent(company),
//	       success: function(data4) {
//	                  var html = "  <option value=''> -- Please Select --</option>";
//	                  for (var i = 0; i < data4.length; i++) {
//	                       //alert(data4[i]);
//	                      html += '<option value="' + data4[i] + '">' + data4[i]
//	                              + '</option>';
//	                  }
//
//	                 
//	                  document.getElementById("Designationl2").innerHTML = html;
//	                  $("#Designationl2").val(level2);
//	           }
//
//	           
//	   });
	   
	  
	   var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/getCategoryDetailsListforcatalogue";

	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data:'company='+encodeURIComponent(company),
	        success: function(data2) {
//	            //alert(data2)
	       	 var html = "  <option value=''> -- Please Select --</option>";
	                   for (var i = 0; i < data2.length; i++) {
	                       html += '<option value="' + data2[i] + '">' + data2[i]
	                               + '</option>';
	                   }
	           
	                   document.getElementById("categorynameupdate").innerHTML = html;
	                  $("#categorynameupdate").val(category);
	                   
	            }
	});
	    
	//////////GET PROBLEM SUBCATEGORY 1 ////////////////
	    var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/getSubCategory1forcatalogue";

	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
	         data:'company='+encodeURIComponent(company),
	         success: function(data2) {
//	             //alert(data2)
	        	 var html = "  <option value=''> -- Please Select --</option>";
	                    for (var i = 0; i < data2.length; i++) {
	                        html += '<option value="' + data2[i] + '">' + data2[i]
	                                + '</option>';
	                    }
	                 
	                    document.getElementById("subcategory1up").innerHTML = html;
	                    $("#subcategory1up").val(subCat1);
	             }
	}); 
	     
	//////////GET PROBLEM SUBCATEGORY 2 ////////////////
	     var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getSubCategory2forcatalogue";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          data:'company='+encodeURIComponent(company),
	          success: function(data2) {
//	              //alert(data2)
	         	 var html = "  <option value=''> -- Please Select --</option>";
	                     for (var i = 0; i < data2.length; i++) {
	                         html += '<option value="' + data2[i] + '">' + data2[i]
	                                 + '</option>';
	                     }
	                    
	                     document.getElementById("subcategory2up").innerHTML = html;
	                     $("#subcategory2up").val(subCat2);
	              }
	 });       
	   
	//////////GET SUBJECT ////////////////
	      var l = window.location;
	    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    	var serviceUrl = base_url + "/Master/getSubjectforcatforcatalogue";

	       $.ajax({
	           type: 'POST',
	           url: serviceUrl,
	           dataType: 'json',
	           data:'company='+encodeURIComponent(company),
	           success: function(data2) {
	        	   
//	               //alert(data2)
	        	   console.log(data2);
	           	var html = "  <option value=''> -- Please Select --</option>";
	               for (var i = 0; i < data2.length; i++) {
	                   html += '<option value="' + data2[i] + '">' + data2[i]
	                           + '</option>';
	               }
	            
	              
	               document.getElementById("subjectup").innerHTML = html;
	               $("#subjectup").val(subject);
	        }
	  }); 
	       
	       //////////GET Priority ////////////////
	       var l = window.location;
	     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	     	var serviceUrl = base_url + "/Master/getPriorityNameforcatalogue";

	        $.ajax({
	            type: 'POST',
	            url: serviceUrl,
	            dataType: 'json',
	            data:'company='+encodeURIComponent(company),
	            success: function(data2) {
//	                //alert(data2)
	            	var html = "  <option value=''> -- Please Select --</option>";
	                for (var i = 0; i < data2.length; i++) {
	                    html += '<option value="' + data2[i] + '">' + data2[i]
	                            + '</option>';
	                }
	              
	                document.getElementById("priorityup").innerHTML = html;
	                $("#priorityup").val(priority);
	                
	                
	         }
	   });     
	      
	        //////////GET Severity ////////////////
	        var l = window.location;
	      	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	      	var serviceUrl = base_url + "/Master/getSeverityNameforcatalogue";

	         $.ajax({
	             type: 'POST',
	             url: serviceUrl,
	             dataType: 'json',
	             data:'company='+encodeURIComponent(company),
	             success: function(data2) {
//	                 //alert(data2)
	             	var html = "  <option value=''> -- Please Select --</option>";
	                 for (var i = 0; i < data2.length; i++) {
	                     html += '<option value="' + data2[i] + '">' + data2[i]
	                             + '</option>';
	                 }
	                
	                 document.getElementById("severityup").innerHTML = html;
	                 $("#severityup").val(seviarity);
	          }
	    });     
	         
	         getstandardup(reqType,aprllvel,company,level1,level2);
	
	
		$("#cupdate").val(company);	

		 $("#sr_no1").val(srno);
		$("#servicestandard1").val(reqType);
		$("#requestcostup").val(reqCost);
//		$("#requestcostup").val(reqCost);
		$("#subjecttypeup").val(subtype);
	    $("#modelcategory1").modal("show");
	    
	    
	    
	}
//SHOW WHEN CLICK ON CHEKC BOX
jQuery(".level1").click(function()
        {
				$("#Designationl1").val("");
            if(jQuery(this).is(":checked"))
            	
            	{
            	
            	 document.getElementById("desig11").style.display = "block";
            	}
              
            else{
            	 document.getElementById("desig11").style.display = "none";
            	
            }
            	
              
        });

var forvalidationcheckupdate=false;
jQuery(".level2").click(function()
        {
	
	  callToolTip232('Designationl2', 'destroy');
		$("#Designationl2").val("");
            if(jQuery(this).is(":checked"))
            	{
            	
            	
            	 var l = window.location;
      		   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
      		   var serviceUrl = base_url + "/Master/getDesignationForLoginMaster";
      		   $.ajax({
      		       type: 'POST',
      		       url: serviceUrl,
      		       dataType: 'json',
      		       data: 'company=' + encodeURIComponent($("#cupdate").val()),
      		       success: function(data4) 
      		       {
      		                  var html = "  <option value=''> -- Please Select --</option>";
      		                  for (var i = 0; i < data4.length; i++)
      		                  {

      		                      html += '<option value="' + data4[i] + '">' + data4[i]
      		                              + '</option>';
      		                  }

      		                  document.getElementById("Designationl2").innerHTML = html;
      		                 
      		       		}
       
      		   });
            	
            	
            	
            	
            	
            	forvalidationcheckupdate=true;
            	 document.getElementById("desig22").style.display = "block";
            	}
              
            else{
            	 document.getElementById("desig22").style.display = "none";
            	 forvalidationcheckupdate=false;
            }
            	
              
        });



function getstandardup(value,requestlevel,company,level1,level2)
{
//	
// //alert(value)
	// //alert(requestlevel)
	
	 document.getElementById("matrixlable1").style.display = "NONE";
	 $('#level1').prop('checked', false);
	 document.getElementById("desig22").style.display = "none";
	 document.getElementById("desig11").style.display = "none";
	 $('#level2').prop('checked', false);
	
	
	if((value =="Non Standard")){
		
	
//		if($('#level1').prop('checked', false); )
	//	level1,level2
		
			$('.level1').prop('checked', true);
			
			 document.getElementById("matrixlable1").style.display = "block";
			 document.getElementById("hrid").style.display = "block";
			 document.getElementById("level1Div").style.display = "block";
			 document.getElementById("desig11").style.display = "block";
			 document.getElementById("level2Div").style.display = "block";
			 
			 var l = window.location;
			   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			   var serviceUrl = base_url + "/Master/getDesignationForLoginMaster";
			   $.ajax({
			       type: 'POST',
			       url: serviceUrl,
			       dataType: 'json',
			       data: 'company=' + encodeURIComponent(company),
			       success: function(data4) {
			                  var html = "  <option value=''> -- Please Select --</option>";
			                  for (var i = 0; i < data4.length; i++) {
//			                       //alert(data4[i]);
			                      html += '<option value="' + data4[i] + '">' + data4[i]
			                              + '</option>';
			                  }

			                  document.getElementById("Designationl1").innerHTML = html;
			                  $("#Designationl1").val(level1);

			           }

			           
			   });
			 if(requestlevel=="Level-2")
				 {
					$('.level2').prop('checked', true);

					 document.getElementById("level2Div").style.display = "block";
					 document.getElementById("desig22").style.display = "block";
					 var l = window.location;
					   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
					   var serviceUrl = base_url + "/Master/getDesignationForLoginMaster";
					   $.ajax({
					       type: 'POST',
					       url: serviceUrl,
					       dataType: 'json',
					       data: 'company=' + encodeURIComponent(company),
					       success: function(data4) 
					       {
					                  var html = "  <option value=''> -- Please Select --</option>";
					                  for (var i = 0; i < data4.length; i++)
					                  {

					                      html += '<option value="' + data4[i] + '">' + data4[i]
					                              + '</option>';
					                  }

					                  document.getElementById("Designationl2").innerHTML = html;
					                  $("#Designationl2").val(level2);
					       		}
			   
					   });
			   
	}
		 
	}else
	{
		
		document.getElementById("level1Div").style.display = "none";
		 document.getElementById("level2Div").style.display = "none";
		 document.getElementById("hrid").style.display = "none";
	}

}
function serviceType(value)
{
	$("#Designationl1").val("");
	$("#Designationl2").val("");
	$('.level1').prop('checked', false);
	$('.level2').prop('checked', false);
	////alert(value)
	if(value=="Standard")
	{
		
	 document.getElementById("matrixlable1").style.display = "none";
	 document.getElementById("hrid").style.display = "none";
	 document.getElementById("level1Div").style.display = "none";
	 document.getElementById("desig11").style.display = "none";
	 document.getElementById("level2Div").style.display = "none";
	 document.getElementById("desig22").style.display = "none";
	}
	else if(value=="Non Standard")
 	{
	
		 document.getElementById("matrixlable1").style.display = "block";
		 document.getElementById("hrid").style.display = "block";
		 document.getElementById("level1Div").style.display = "block";

		 document.getElementById("level2Div").style.display = "block";
		
		 
	//	 var company=$("#cupdate").val();
		 
		// //alert(company)
		 var l = window.location;
		   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		   var serviceUrl = base_url + "/Master/getDesignationForLoginMaster";
		   $.ajax({
		       type: 'POST',
		       url: serviceUrl,
		       dataType: 'json',
		       async:false,
		       data: 'company=' + encodeURIComponent($("#cupdate").val()),
		       success: function(data4) {
		                  var html = "  <option value=''> -- Please Select --</option>";
		                  for (var i = 0; i < data4.length; i++) {		                	  
	                	// //alert(data4[i]);
		                      html += '<option value="' + data4[i] + '">' + data4[i]
		                              + '</option>';
		                  }

		                  document.getElementById("Designationl1").innerHTML = html;
		                  $("#Designationl1").val(level1);
		                  document.getElementById("Designationl2").innerHTML = html;
		                  $("#Designationl2").val(level2);

		           }

		           
		   });
		 
	}
	else
	{
		
	 document.getElementById("matrixlable1").style.display = "none";
	 document.getElementById("hrid").style.display = "none";
	 document.getElementById("level1Div").style.display = "none";
	 document.getElementById("desig11").style.display = "none";
	 document.getElementById("level2Div").style.display = "none";
	 document.getElementById("desig22").style.display = "none";
	}
}
$("#update_service_request-btn").click(function() {

    if (!validateCategoryupdate()) {
    	event.preventDefault();
    } else {
    	saveUpdateCompany();
    }
}).show();
    
function saveUpdateCompany()
{
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/updateServiceCatalogue";
		

	        $.ajax({
	            type: 'POST',
	            url: serviceUrl,
	            data: 'category=' + encodeURIComponent($("#categorynameupdate").val())
	            		+ '&subcategory1=' + encodeURIComponent($("#subcategory1up").val())
	            		+ '&subcategory2=' + encodeURIComponent($("#subcategory2up").val())
	            		+ '&subject=' + encodeURIComponent($("#subjectup").val())
	            		+ '&company=' + encodeURIComponent($("#cupdate").val())
	            		+ '&priority=' + encodeURIComponent($("#priorityup").val())
	            		+ '&severity=' + encodeURIComponent($("#severityup").val())
	            		+ '&servicestandard=' + encodeURIComponent($("#servicestandard1").val())
	            		+ '&groupselect=' + encodeURIComponent($("#groupselectup").val())
	            		+ '&levelone=' + encodeURIComponent($("#level1").val())
	            		+ '&leveltwo=' + encodeURIComponent($("#level2").val())
	            		+ '&Designarionlevel2=' + encodeURIComponent($("#Designationl2").val())
	            		+ '&Designarionlevel1=' + encodeURIComponent($("#Designationl1").val())
	            		+ '&requestcost=' + encodeURIComponent($("#requestcostup").val())
	            		+ '&subjecttype=' + encodeURIComponent($("#subjecttypeup").val())
	            		+ '&srno=' + encodeURIComponent($("#sr_no1").val())
	        }).done(function(data) {
//	             //alert("response: "+data)

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
	                        window.location.href = base_url + "/Admin/ServiceCatalogueMaster";
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
	               	 showCancelButton: true,
	                  confirmButtonClass: "btn btn-danger",
	                  cancelButtonClass: "btn btn-danger m-l-10",
	                  confirmButtonText: "OK",
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/ServiceCatalogueMaster";
	                    }

	                });

	              }
	            else if (data == "error") {
	                swal({
	                    title: "Unsuccessful!",
	                    text: "Fail to update Service Catelougue",
	                    type: "warning",
	                    width: 300,
	                    height: 200,

	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/ServiceCatalogueMaster";
	                    }

	                });

	              }
	        });
	  

	            
}



jQuery(".level1").click(function()
        {
				$("#Designationl1").val("");
            if(jQuery(this).is(":checked"))
            	
            	{
            	
            	 document.getElementById("desig11").style.display = "block";
            	}
              
            else{
            	 document.getElementById("desig11").style.display = "none";
            	
            }
            	
              
        });

var forvalidationcheck=false;
jQuery(".level2").click(function()
        {
		$("#Designationl2").val("");
            if(jQuery(this).is(":checked"))
            	{
            	
            	forvalidationcheck=true;
            	 document.getElementById("desig22").style.display = "block";
            	}
              
            else{
            	 document.getElementById("desig22").style.display = "none";
            	
            }
            	
              
        });
function validateCategoryupdate() {
	
	////alert("hii");
    var indexError = 0;
  
    if ($('#servicestandard1').val().trim() === '') {
        callToolTip232('servicestandard1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#groupselectup').val().trim() === '') {
        callToolTip232('groupselectup', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
 
    if ( $('#subjectup').val() == '' || $('#subjectup').val() == null ) {
        console.log('fill sub');
        callToolTip232('subjectDivup', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ( $('#categorynameupdate').val() == '' || $('#categorynameupdate').val() == null ) {
        console.log('fill categorynameupdate');
        callToolTip232('categorydiv1upda', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ( $('#subcategory1up').val() == '' || $('#subcategory1up').val() == null ) {
        console.log('fill subcategory1Divupda');
        callToolTip232('subcategory1Divupda', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ( $('#subcategory2up').val() == '' || $('#subcategory2up').val() == null ) {
        console.log('fill subcategory2up');
        callToolTip232('subcategory2Divupda', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ( $('#priorityup').val() == '' || $('#priorityup').val() == null ) {
        console.log('fill priorityup');
        callToolTip232('priorityDivupda', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ( $('#severityup').val() == '' || $('#severityup').val() == null ) {
        console.log('fill severityup');
        callToolTip232('severityDivupda', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    
    
    if($('#servicestandard1').val() =='Non Standard'){
   // //alert(   document.querySelector('#levelone:checked'));
 //   document.querySelector('#levelone:checked') !== null
    if (document.querySelector('#level1:checked') == null) {
    	// //alert(   document.querySelector('#levelone:checked'));
        callToolTip232('level1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#Designationl1').val().trim() === '' && document.querySelector('#level1:checked') ) {
        callToolTip232('Designationl1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#Designationl2').val() === '' && forvalidationcheckupdate==true) {
        callToolTip232('Designationl2', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    
    if($('#Designationl2').val() !="" && $('#Designationl2').val()==$('#Designationl1').val() && $('#servicestandard1').val() == 'Non Standard')
    {
    	
		
		swal({
			title : "Duplicate Data!",
			text : "Please Select Two Different Designation",
			type : "warning",
			width : 300,
			height : 200,
			confirmButtonClass : "btn btn-danger",

		});
		indexError=indexError+1;
    }
    
    }
    
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}
var callToolTip232 = function(fieldName, status) {

	////alert(status);
	////alert(fieldName);
    if (fieldName == "groupselectup") {groupselectup
        var errorMessage = "<span>Please Select Group<span>";
    }
    else if (fieldName == "servicestandard1"){
    	var errorMessage = "<span>Please Select Request Type<span>";
    }
    else if (fieldName == "level1") {
        var errorMessage = "<span>Please Check Atlease level one designation <span>";
    }
    else if (fieldName == "Designationl2") {
        var errorMessage = "<span>Please Select Level two designation <span>";
     
    }
    else if (fieldName == "Designationl1") {
        var errorMessage = "<span>Please Select Level one designation<span>";
    }
    else if (fieldName == "subjectDivup") {
        var errorMessage = "<span>Please Select Subject<span>";
    }
    else if (fieldName == "categorydiv1upda") {
        var errorMessage = "<span>Please Select Category<span>";
    }
    else if (fieldName == "subcategory1Divupda") {
        var errorMessage = "<span>Please Select SubCategory1<span>";
    }
    else if (fieldName == "subcategory2Divupda") {
        var errorMessage = "<span>Please Select SubCategory2<span>";
    }
    else if (fieldName == "priorityDivupda") {
        var errorMessage = "<span>Please Select Priotity<span>";
    }
    else if (fieldName == "severityDivupda") {
        var errorMessage = "<span>Please Select Severity<span>";
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

$('#groupselectup').on('focusout', function() {
    var usertype = $('#groupselectup').val();

    if (usertype.trim() == "") {
        callToolTip232('groupselectup', 'show');
    }
    else {
        callToolTip232('groupselectup', 'hide');
    }
});
$('#subjectup').on('focusout', function() {
    var usertype = $('#subjectup').val();

    if (usertype.trim() == "") {
        callToolTip232('subjectDivup', 'show');
    }
    else {
        callToolTip232('subjectDivup', 'hide');
    }
});


$('#servicestandard1').on('focusout', function() {
    var usertype = $('#servicestandard1').val();

    if (usertype.trim() == "") {
        callToolTip232('servicestandard1', 'show');
    }
    else {
        callToolTip232('servicestandard1', 'hide');
    }
});
$('#Designationl1').on('focusout', function() {
    var usertype = $('#Designationl1').val();

    if (usertype.trim() == "") {
        callToolTip232('Designationl1', 'show');
    }
    else {
        callToolTip232('Designationl1', 'hide');
    }
});
$('#Designationl2').on('focusout', function() {
    var usertype = $('#Designationl2').val();

    if (usertype.trim() == "") {
        callToolTip232('Designationl2', 'show');
    }
    else {
        callToolTip232('Designationl2', 'hide');
    }
});
$('#level1').on('focusout', function() {
    var usertype = $('#level1').val();

    if (usertype.trim() == "") {
        callToolTip232('level1', 'show');
    }
    else {
        callToolTip232('level1', 'hide');
    }
});

$('#groupselectup').on('click', function() {
	callToolTip232('groupselectup', 'destroy');
});
$('#subjectDivup').on('click', function() {
	callToolTip232('subjectDivup', 'destroy');
});
	
$('#categorydiv1upda').on('click', function() {
	callToolTip232('categorydiv1upda', 'destroy');
});
	
$('#subcategory1Divupda').on('click', function() {
	callToolTip232('subcategory1Divupda', 'destroy');
});
	
$('#subcategory2Divupda').on('click', function() {
	callToolTip232('subcategory2Divupda', 'destroy');
});
	
$('#priorityDivupda').on('click', function() {
	callToolTip232('priorityDivupda', 'destroy');
});	
$('#severityDivupda').on('click', function() {
		callToolTip232('severityDivupda', 'destroy');
});

$('#level1').on('click', function() {
	callToolTip232('level1', 'destroy');
});
$('#Designationl1').on('click', function() {
	callToolTip232('Designationl1', 'destroy');
});
$('#Designationl2').on('click', function() {
	callToolTip232('Designationl2', 'destroy');
});
                