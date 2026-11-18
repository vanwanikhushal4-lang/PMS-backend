window.onload = function() {
   // alert("ggggg")
//      $('#cname').focus();
     var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompanyDetailsForTicketTagMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
           async: false,
         success: function(data4) {

                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {

                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("cname").innerHTML = html;
                  //  encodeURIComponent()
                      document.getElementById("updatecname").innerHTML = html;
                    
             }

             
     });
     
     
     
      //alert("ggggg")
      $('#category').focus();
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/TicketTagDetails";
//     var serviceUrl = "CategoryDetails";
  	//alert("dasddsd")
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {

             var table = $('#datatype').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 5,
                  scrollX:true
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });


 }
 
 
 function generateTicketTag() {
	
	var companytag=$("#companyTag").val();
	var deptTag=$("#deptTag").val();
	
	var tagName=companytag+"-"+deptTag+"-"+"INC1234"
	
	$("#generatedTag").val(tagName)
	
}



 function generateupdateTicketTag() {
	
	var companytag=$("#updatecompanyTag").val();
	var deptTag=$("#updatedeptTag").val();
	
	var tagName=companytag+"-"+deptTag+"-"+"TicketID123"
	
	$("#updategeneratedTag").val(tagName)
	
}
 
 
function getDeptDetails() {
  // alert($("#cname").val());
   //   alert($("#sname").val());
    
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getDepartmentForTicketTagMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + encodeURIComponent($("#cname").val()),
         success: function(data4) {
       //     alert(data4)

                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {

                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("dname").innerHTML = html;
             }

             
     });
    
}

 
 
 
 
function getUpdateDeptDetails() {
  // alert($("#cname").val());
   //   alert($("#sname").val());
    
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getDepartmentForTicketTagMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + encodeURIComponent($("#updatecname").val()),
      async: false,
         success: function(data4) {
       // alert(data4)

                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {

                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("updatedname").innerHTML = html;
             }

             
     });
    
}

 
 
 
function validateCompany() {
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
    var companyField = $('#company').val();
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(companyField) == false)
    {
        //callToolTipWrong('email', 'show');
        ret = false;
    }
    else
    {
        ret = true;
    }
    return ret;
}


var callToolTip231 = function(fieldName, status) {

    if (fieldName == "deptTag") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Department Tag<span>";
    } else if (fieldName == "dname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Department<span>";
    }else if (fieldName == "companyTag") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Company Tag<span>";
    }else if (fieldName == "cname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Company<span>";
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

$('#deptTag').on('focusout', function() {
    var usertype = $('#deptTag').val();

    if (usertype.trim() == "") {
        callToolTip231('deptTag', 'show');
    }
    else {
        callToolTip231('deptTag', 'hide');
    }
});

$('#dname').on('focusout', function() {
    var usertype = $('#dname').val();

    if (usertype.trim() == "") {
        callToolTip231('dname', 'show');
    }
    else {
        callToolTip231('dname', 'hide');
    }
});

$('#companyTag').on('focusout', function() {
    var usertype = $('#companyTag').val();

    if (usertype.trim() == "") {
        callToolTip231('companyTag', 'show');
    }
    else {
        callToolTip231('companyTag', 'hide');
    }
});

$('#cname').on('focusout', function() {
    var usertype = $('#cname').val();

    if (usertype.trim() == "") {
        callToolTip231('cname', 'show');
    }
    else {
        callToolTip231('cname', 'hide');
    }
});


$('#companyTag').on('focus', function() {
callToolTip231('companyTag', 'destroy');
});

$('#cname').on('focus', function() {
callToolTip231('cname', 'destroy');
});

$('#dname').on('focus', function() {
callToolTip231('dname', 'destroy');
});

$('#deptTag').on('focus', function() {
callToolTip231('deptTag', 'destroy');
});
function validateCategory() {
    var indexError = 0;
   
    if ($('#deptTag').val().trim() === '') {
        callToolTip231('deptTag', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }else {
	callToolTip231('deptTag', 'hide');
	
}
    
    if ($('#companyTag').val().trim() === '') {
        callToolTip231('companyTag', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }else {
	 callToolTip231('companyTag', 'hide');
	
}
    
     if ($('#cname').val().trim() === '') {
        callToolTip231('cname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In cname: "+indexError);
    }else {
	 callToolTip231('cname', 'hide');
	
}
    
     if ($('#dname').val().trim() === '') {
        callToolTip231('dname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        console.log("In dname: "+indexError);
    } else {
	  callToolTip231('dname', 'hide');
}
    
    
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}




$("#submit-btn").click(function() {
//    alert("dgfsgf");
    if (!validateCategory()) {
        event.preventDefault();
    } else {
        saveTicketTagData();
    }
}).show();

$("#resetbtn").click(function() {
    $("#companyTag").val("");
     callToolTip231('companyTag', 'hide');
     
       $("#deptTag").val("");
     callToolTip231('deptTag', 'hide');
     
        $("#dname").val("");
     callToolTip231('dname', 'hide');
     
       $("#cname").val("");
     callToolTip231('cname', 'hide');
      $("#generatedTag").val("");
     
     
});

//insert data
function saveTicketTagData()  {
	
	var gentag=$("#companyTag").val()+"-"+$("#deptTag").val()+"-"

//alert("gentag:"+gentag)
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/addTicketTag";
	
//        var serviceUrl = "addcategory";
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'cname=' + encodeURIComponent($("#cname").val())
            +'&dname=' + encodeURIComponent($("#dname").val())
            +'&ticketTag=' + gentag
           
        }).done(function(data) {
            // alert("hgdjghd"+data)

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
                        window.location.href = base_url + "/Admin/TicketTagMaster";
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
                        window.location.href = base_url + "/Admin/TicketTagMaster";
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
                        window.location.href = base_url + "/Admin/TicketTagMaster";
                    }

                });

              }
        });
    //});
            }  


function DeleteTicketTag(srno)  {
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
        //  alert("deleteUserdddddddd")
    	
    	 var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/deleteTicketTag";
    	
//        var serviceUrl = "deletecategory";
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'crno=' + srno

        }).done(function(data) {
            //  alert("dfgsfd"+data)

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
                        window.location.href = base_url + "/Admin/TicketTagMaster";
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
                        window.location.href = base_url + "/Admin/TicketTagMaster";
                    }

                });

              }
        });
    });
            }   
                


function EditTicketTagy(crno,department,company,tickettag) {
 
  
   $("#sr_no1").val(crno);
   var tkid=tickettag+"INC1234"; 
   
    $("#updategeneratedTag").val(tkid);
     $("#updatecname").val(company);
   
   getUpdateDeptDetails();
    $("#updatedname").val(department);
    
     var tag = tickettag.split("-");
  var ctag=tag[0];
  var dtag=tag[1];
     $("#updatecompanyTag").val(ctag);
       $("#updatedeptTag").val(dtag);
   
   
   $("#modelcategory1").modal("show");
   
   
   
   
}

$("#update_CategoryType_btn").click(function() {
    if (!validateCategoryUpdate())
    {
        event.preventDefault();
    } else if (validateCategoryUpdate())
    {
    updateCategorySave111();
      }
}).show();

function updateCategorySave111() {
//alert("in ajax")

var tagforsave=$('#updatecompanyTag').val()+"-"+$('#updatedeptTag').val()+"-"
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updateTicketTagyMasterSave";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "updatecname=" + encodeURIComponent($('#updatecname').val())
         
            + "&updatedname=" + encodeURIComponent($("#updatedname").val())
              + "&tagforsave=" +tagforsave
                + "&cr_no=" + $("#sr_no1").val(),
                  success: function(data) {
//                      alert(data)
                    if (data == "success") {
                    swal({
                    title: "Successful!",
                    text: "Record Updated Successfully",
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
                        window.location.href = base_url + "/Admin/TicketTagMaster";
                    }
                });
            }


            else if (data == "duplicate") {
                swal({
                    title: "Duplicate!",
                    text: "Record Already Exist",
                    type: "success",
                    width: '300px',
                    height: '90px !important',
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/TicketTagMaster";
                    }
                });
            }


            else {

                swal({
                    title: "Unsuccessful!",
                    text: "Record not updated",
                    type: "error",
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
                        window.location.href = base_url + "/Admin/TicketTagMaster";
                    }
                });
            }
            
             $('#updatecompanyname').val("");
            
                  }
                   });
                   }
                   
var callToolTipUpdate = function(fieldName, status) {

    if (fieldName == "updatecname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Company<span>";
    } else if (fieldName == "updatecompanyTag") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Company Tag<span>";
    } else if (fieldName == "updatedname") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Department<span>";
    } else if (fieldName == "updatedeptTag") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Department tag<span>";
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

$('#updatecname').on('focusout', function() {
    var usertype = $('#updatecname').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('updatecname', 'show');
    }
    else {
        callToolTipUpdate('updatecname', 'hide');
    }
});

$('#updatecname').on('focus', function() {
callToolTipUpdate('updatecname', 'destroy');
});



$('#updatecompanyTag').on('focusout', function() {
    var usertype = $('#updatecompanyTag').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('updatecompanyTag', 'show');
    }
    else {
        callToolTipUpdate('updatecompanyTag', 'hide');
    }
});

$('#updatecompanyTag').on('focus', function() {
callToolTipUpdate('updatecompanyTag', 'destroy');
});




$('#updatedname').on('focusout', function() {
    var usertype = $('#updatedname').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('updatedname', 'show');
    }
    else {
        callToolTipUpdate('updatedname', 'hide');
    }
});

$('#updatedname').on('focus', function() {
callToolTipUpdate('updatedname', 'destroy');
});


$('#updatedeptTag').on('focusout', function() {
    var usertype = $('#updatedeptTag').val();

    if (usertype.trim() == "") {
        callToolTipUpdate('updatedeptTag', 'show');
    }
    else {
        callToolTipUpdate('updatedeptTag', 'hide');
    }
});

$('#updatedeptTag').on('focus', function() {
callToolTipUpdate('updatedeptTag', 'destroy');
});



function validateCategoryUpdate() {
    var indexError = 0;
   
    if ($('#updatedeptTag').val().trim() === '') {
        callToolTipUpdate('updatedeptTag', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else {
	 callToolTipUpdate('updatedeptTag', 'hide');
	
}
    
    if ($('#updatedname').val().trim() === '') {
        callToolTipUpdate('updatedname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else {
	  callToolTipUpdate('updatedname', 'hide');
	
}
    
    if ($('#updatecompanyTag').val().trim() === '') {
        callToolTipUpdate('updatecompanyTag', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else {
	 callToolTipUpdate('updatecompanyTag', 'hide');
	
}
    
    if ($('#updatecname').val().trim() === '') {
        callToolTipUpdate('updatecname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    } else {
	
	  callToolTipUpdate('updatecname', 'hide');
	
}
    
    
    
    
    
    
    
    
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}
                   