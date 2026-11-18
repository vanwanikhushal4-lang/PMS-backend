window.onload = function() {
	
	$('#cname').focus();
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
           async: false,
         success: function(data4) {
//             alert(data4)
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("cname").innerHTML = html;
             }
     });

    $('#category').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Category or Enter New",
//        allowClear: true
    })
    $('#subcategory1').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub Category or Enter New",
//        allowClear: true
    })
    $('#subcategory2').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Sub Category or Enter New",
//        allowClear: true
    })
       $('#subject').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	placeholder: "Select a Subject or Enter New",
//        allowClear: true
    })
    
       $('#categoryup').select2({
//      theme: 'bootstrap4'
    	tags: true,
    	width:'100%',
    	placeholder: "Select a Category or Enter New",
    	dropdownParent: $('#modelcategory1')
//        allowClear: true
    })
    $('#subcategoryup1').select2({
//      theme: 'bootstrap4'
    	tags: true,
      	width:'100%',
    	placeholder: "Select a Sub Category or Enter New",
    	dropdownParent: $('#modelcategory1')
//        allowClear: true
    })
    $('#subcategoryup2').select2({
//      theme: 'bootstrap4'
    	tags: true,
      	width:'100%',
    	placeholder: "Select a Sub Category or Enter New",
    	dropdownParent: $('#modelcategory1')
//        allowClear: true
    })
       $('#subjectup').select2({
//      theme: 'bootstrap4'
    	tags: true,
      	width:'100%',
    	placeholder: "Select a Subject or Enter New",
    	dropdownParent: $('#modelcategory1')
//        allowClear: true
    })
      
   
//    $('#company').focus();
    
   
  

//////////GET SUBJECT ////////////////
       var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/getSubject";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            success: function(data2) {
//                alert(data2)
            	var html = "  <option value=''> -- Please Select --</option>";
                for (var i = 0; i < data2.length; i++) {
                    html += '<option value="' + data2[i] + '">' + data2[i]
                            + '</option>';
                }
                document.getElementById("subject").innerHTML = html;
         }
   }); 
       
       
       
    ////////// GET SUBJECT LISTING /////////
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/SubjectListing";
//     var serviceUrl = "CategoryDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//        	 alert(data4)
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

function getCategory(company){
////////// GET PROBLEM CATEGORY ////////////////
//alert(company)
var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCategoryDetailsListForsubjecmaster";

 $.ajax({
     type: 'POST',
     url: serviceUrl,
     dataType: 'json',
     data:'cname='+encodeURIComponent(company),
     success: function(data2) {
//         alert(data2)
    	 var html = "  <option value=''> -- Please Select --</option>";
                for (var i = 0; i < data2.length; i++) {
                    html += '<option value="' + data2[i] + '">' + data2[i]
                            + '</option>';
                }
                document.getElementById("category").innerHTML = html;
         }
});
}
function getSubCategory(category){
	
//	alert($("#cname").val())
//////////GET PROBLEM SUBCATEGORY 1 ////////////////
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/getSubCategory1Forsubjecmaster";

$.ajax({
type: 'POST',
url: serviceUrl,
dataType: 'json',
data:'company='+ encodeURIComponent($("#cname").val())
+'&category='+encodeURIComponent(category),
success: function(data2) {
//    alert(data2)
	 var html = "  <option value=''> -- Please Select --</option>";
           for (var i = 0; i < data2.length; i++) {
               html += '<option value="' + data2[i] + '">' + data2[i]
                       + '</option>';
           }
           document.getElementById("subcategory1").innerHTML = html;
    }
}); 
}
function GetSubCategory2(subcategory1)
{
	//alert(subcategory1)
	//alert($("#cname").val())
	//alert($("#category").val())
//////////GET PROBLEM SUBCATEGORY 2 ////////////////
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getSubCategory2Forsubjecmaster";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data:'company='+encodeURIComponent($("#cname").val())+'&category='+encodeURIComponent($("#category").val())+'&subcategory1='+encodeURIComponent(subcategory1),
         success: function(data2) {
//             alert(data2)
        	 var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data2.length; i++) {
                        html += '<option value="' + data2[i] + '">' + data2[i]
                                + '</option>';
                    }
                    document.getElementById("subcategory2").innerHTML = html;
             }
});       
  
	
}




var callToolTip231 = function(fieldName, status) {

	 if (fieldName == "cname") {
	        var errorMessage = "<span>Please Select Company<span>";
	    }
    if (fieldName == "categoryProblemDiv") {
        var errorMessage = "<span>Please Enter or Select Category<span>";
    }
    else if (fieldName == "subcategory1Div"){
    	var errorMessage = "<span>Please Enter or Select Sub-Category 1<span>";
    }
    else if (fieldName == "subcategory2Div"){
    	var errorMessage = "<span>Please Enter or Select Sub-Category 2<span>";
    }
    else if (fieldName == "priorityDiv") {
        var errorMessage = "<span>Please Enter or Select Priority<span>";
    }

    if (fieldName == "severityDiv") {
        var errorMessage = "<span>Please Enter or Select Severity<span>";
    }
    if (fieldName == "subjectDiv") {
        var errorMessage = "<span>Please Enter or Select Subject<span>";
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
$('#subject').on('focusout', function() {
    var usertype = $('#subject').val();

    if (usertype.trim() == "") {
        callToolTip231('subjectDiv', 'show');
    }
    else {
        callToolTip231('subjectDiv', 'hide');
    }
});

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
//$('#cname').on('focusout', function() {
//    var usertype = $('#cname').val();
//
//    if (usertype.trim() == "") {
//        callToolTip231('cname', 'show');
//    }
//    else {
//        callToolTip231('cname', 'hide');
//    }
//});
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

$('#cname').on('focus', function() {
	//alert("");
callToolTip231('cname', 'destroy');
});

$('#subjectDiv').on('click', function() {
	callToolTip231('subjectDiv', 'destroy');
	});
$('#categoryProblemDiv').on('click', function() {
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

function validateCategory() {
    var indexError = 0;
   
    if ($('#cname').val().trim()=== '') {
        callToolTip231('cname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#subject').val() == '' || $('#subject').val() == null) {
        callToolTip231('subjectDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#category').val() =='' || $('#category').val() ==null ) {
        callToolTip231('categoryProblemDiv', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   // alert($('#subcategory1').val());
    
    if ($('#subcategory1').val() ==  '' || $('#subcategory1').val() == null) {
        callToolTip231('subcategory1Div', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#subcategory2').val()== '' || $('#subcategory2').val() == null) {
        callToolTip231('subcategory2Div', 'show');
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


$("#submit-btn").click(function() {

    if (!validateCategory()) {
    	event.preventDefault();
    } else {
    	saveDataCompany();
    }
}).show();

$("#resetbtn").click(function() {
	
	$("#cname").val('')
	$("#category").val('').trigger('change')
	$("#priority").val('').trigger('change')
	$("#severity").val('').trigger('change')
	$("#subcategory1").val('').trigger('change')
	$("#subcategory2").val('').trigger('change')
	$("#cname").val('').trigger('change')
	$("#subject").val('').trigger('change')
	
	
	callToolTip231('cname', 'destroy');
	//callToolTip231('subject', 'destroy');
     callToolTip231('categoryProblemDiv', 'destroy');
     
	callToolTip231('priorityDiv', 'destroy');
	callToolTip231('severityDiv', 'destroy');
     callToolTip231('subcategory1Div', 'destroy');
     callToolTip231('subcategory2Div', 'destroy');
     callToolTip231('subjectDiv', 'destroy');
     
     
});


function saveDataCompany()  {
	
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/addNewSubject";
	
//        var serviceUrl = "addcategory";
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'category=' +  encodeURIComponent($("#category").val())
            		+ '&subcategory1=' + encodeURIComponent($("#subcategory1").val())
            		+ '&subcategory2=' + encodeURIComponent($("#subcategory2").val())
            		+ '&subject=' + encodeURIComponent($("#subject").val())
            		+ '&company=' + encodeURIComponent($("#cname").val())
        }).done(function(data) {
//             alert("response: "+data)

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
                        window.location.href = base_url + "/Admin/SubjectMaster";
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
                        window.location.href = base_url + "/Admin/SubjectMaster";
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
                        window.location.href = base_url + "/Admin/SubjectMaster";
                    }

                });

              }
        });
    //});
            }  


function DeleteSubject(srno)  {

//alert("gdfsf"+srno)
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
     	var serviceUrl = base_url + "/Master/deleteSubject";

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
                        window.location.href = base_url + "/Admin/SubjectMaster";
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
                        window.location.href = base_url + "/Admin/SubjectMaster";
                    }

                });

              }
        });
    });
  }   
////////////////////EDIT SUBJECT MASTER/////////////
function EditSubjectMaster(srno, company,category,subcategory1,subcategory2,subject)
{
	  ////////// GET PROBLEM CATEGORY ////////////////
	

//alert(category)
	$("#companyup").val(company);
	
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getCategoryDetailsListForsubjecmaster";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         async :true,
         dataType: 'json',
       
         data:'cname='+encodeURIComponent(company),
         success: function(data2) {
//             alert(data2)
        	 var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data2.length; i++) {
                        html += '<option value="' + data2[i] + '">' + data2[i]
                                + '</option>';
                    }
                    document.getElementById("categoryup").innerHTML = html;
                    $("#categoryup").val(category);
             }
     
});
     
     //sub cate 1
     
     var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getSubCategory1Forsubjecmaster";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      async :false,
      data:'company='+encodeURIComponent(company)+'&category='+encodeURIComponent(category),
      success: function(data2) {
//          alert(data2)
     	 var html = "  <option value=''> -- Please Select --</option>";
                 for (var i = 0; i < data2.length; i++) {
                     html += '<option value="' + data2[i] + '">' + data2[i]
                             + '</option>';
                 }
                 document.getElementById("subcategoryup1").innerHTML = html;
                 $("#subcategoryup1").val(subcategory1);
                 
                 
          }
 }); 

  //cub cat 2
  
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSubCategory2Forsubjecmaster";

$.ajax({
    type: 'POST',
    url: serviceUrl,
    async :false,
    dataType: 'json',
    data:'company='+encodeURIComponent(company)+'&category='+encodeURIComponent(category)+'&subcategory1='+encodeURIComponent(subcategory1),
    success: function(data2) {
//        alert(data2)
   	 var html = "  <option value=''> -- Please Select --</option>";
               for (var i = 0; i < data2.length; i++) {
                   html += '<option value="' + data2[i] + '">' + data2[i]
                           + '</option>';
               }
               document.getElementById("subcategoryup2").innerHTML = html;
               $("#subcategoryup2").val(subcategory2);
        }
});       


    
//////////GET SUBJECT ////////////////
       var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/getSubject";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            success: function(data2) {
//                alert(data2)
            	var html = "  <option value=''> -- Please Select --</option>";
                for (var i = 0; i < data2.length; i++) {
                    html += '<option value="' + data2[i] + '">' + data2[i]
                            + '</option>';
                }
                document.getElementById("subjectup").innerHTML = html;
                $("#subjectup").val(subject);
                
         }
   }); 
//        alert(category)
        $("#sr_no1").val(srno);

//	getUpdateSubCategory(category);
	$("#modelcategory1").modal("show");
	
	
}

$('#modelcategory1').on('hidden.bs.modal', function () {
//	alert('modelcategory model inside')
$("#categoryup").val('').trigger('change')
	$("#priority").val('').trigger('change')
	$("#severity").val('').trigger('change')
	$("#subcategoryup1").val('').trigger('change')
	$("#subcategoryup2").val('').trigger('change')
	$("#cname").val('').trigger('change')
	$("#subject").val('').trigger('change')
	
})

//onchange functions 

function getUpdateSubCategory(category)
{
//////////GET  SUBCATEGORY 1 ////////////////
//alert(category)
var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSubCategory1";

 $.ajax({
     type: 'POST',
     url: serviceUrl,
     dataType: 'json',
     
     data:'company='+encodeURIComponent($("#companyup").val())+'&category='+encodeURIComponent(category),
     success: function(data2) {
//         alert(data2)
    	 var html = "  <option value=''> -- Please Select --</option>";
                for (var i = 0; i < data2.length; i++) {
                    html += '<option value="' + data2[i] + '">' + data2[i]
                            + '</option>';
                }
                document.getElementById("subcategoryup1").innerHTML = html;
              
                
                
         }
}); 
 

}

function getUpdateSubCategroy2(subcategory1)
{
//////////GET PROBLEM SUBCATEGORY 2 ////////////////
	//alert($("#categoryup").val())
	
 var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSubCategory2";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      async :false,
      dataType: 'json',
      data:'company='+encodeURIComponent($("#companyup").val())+'&category='+encodeURIComponent($("#categoryup").val())+'&subcategory1='+encodeURIComponent(subcategory1),
      success: function(data2) {
//          alert(data2)
     	 var html = "  <option value=''> -- Please Select --</option>";
                 for (var i = 0; i < data2.length; i++) {
                     html += '<option value="' + data2[i] + '">' + data2[i]
                             + '</option>';
                 }
                 document.getElementById("subcategoryup2").innerHTML = html;
               
          }
});       

}


$("#update_CategoryType_btn").click(function(){
	SavedUpdate();
}).show();

function SavedUpdate()
{
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updateSubjectMaster";
 	
 	 $.ajax({
         type: 'POST',
         url: serviceUrl,
         
         data: 'srno=' + encodeURIComponent($("#sr_no1").val())
         		+'&company=' + encodeURIComponent($("#companyup").val())
         		+ '&category=' + encodeURIComponent($("#categoryup").val())
         		+ '&subcategory1=' + encodeURIComponent($("#subcategoryup1").val())
         		+ '&subcategory2=' + encodeURIComponent($("#subcategoryup2").val())
         		+ '&subject=' + encodeURIComponent($("#subjectup").val())
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
                     window.location.href = base_url + "/Admin/SubjectMaster";
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
                     window.location.href = base_url + "/Admin/SubjectMaster";
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
                     window.location.href = base_url + "/Admin/SubjectMaster";
                 }

             });

           }
     });
}
                
                   