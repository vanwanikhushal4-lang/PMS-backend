 window.onload = function() {
     //alert("ggggg")
//     $('#user').val("");
     // $('#fname').focus();
      var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompanyDetails";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
//             alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("company").innerHTML = html;
                      //document.getElementById("cnameupdate").innerHTML = html;
             }

             
     });

};

function getCategory()
{
var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCategoryDetails";
 
  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data4) {
//          alert(data4)
//         var pollingHost = data4;
//                 var d = pollingHost.split(",");
//                 var length = d.length - 1;
                 var html = "  <option value=''> -- Please Select --</option>";
                 for (var i = 0; i < data4.length; i++) {
//                     alert(data4[i]);
                     html += '<option value="' + data4[i] + '">' + data4[i]
                             + '</option>';
                 }

                 document.getElementById("category").innerHTML = html;
                // document.getElementById("categoryupdate").innerHTML = html;
          }

          
  });
} 
    
  function getBranch(compname)
  {
//	  alert(compname)
	  $("#category").val("");
	  
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getEscBranchDetails";
  
   $.ajax({
       type: 'POST',
       url: serviceUrl,
       dataType: 'json',
       data : 'companyname=' + $("#company").val() ,
       success: function(data4) {
//           alert(data4)
//          var pollingHost = data4;
//                  var d = pollingHost.split(",");
//                  var length = d.length - 1;
                  var html = "  <option value=''> -- Please Select --</option>";
                  for (var i = 0; i < data4.length; i++) {
//                      alert(data4[i]);
                      html += '<option value="' + data4[i] + '">' + data4[i]
                              + '</option>';
                  }

                  document.getElementById("branch").innerHTML = html;
                 // document.getElementById("categoryupdate").innerHTML = html;
           }

           
   });  
   }

function own1()
{
	//alert("Hiii")
	 var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getOwn1Details";
  	//alert($("#ticowner").val());
     $.ajax({
         type: 'POST',
         url: serviceUrl,
        // dataType: 'json',
         data : 'ticowner=' + $("#ticowner").val() ,
         success: function(data) {
        	// alert(data)
        		var dataval = JSON.parse(data).toString();
        	// alert("dataval="+dataval)
    	    	var aaa = dataval.split(',');
        	// alert("0=="+aaa[0]);
        	// alert("1=="+aaa[1]);
        	
             $("#towneremail").val(aaa[0])
             $("#townermob").val(aaa[1])
             }
         
     });
}


function esc11()
{
	//alert("Hiii")
	 var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getesc1Details";
  	//alert($("#ticowner").val());
     $.ajax({
         type: 'POST',
         url: serviceUrl,
        // dataType: 'json',
         data : 'esc1=' + $("#esc1").val() ,
         success: function(data4) {
        //	alert(data4)
        		var dataval = JSON.parse(data4).toString();
        	// alert("dataval="+dataval)
    	    	var aaa = dataval.split(',');
        	// alert("0=="+aaa[0]);
        	// alert("1=="+aaa[1]);
        	
             $("#e1email").val(aaa[0])
             $("#e1mob").val(aaa[1])
             }
             
     });

}

function esc22()
{
	//alert("Hiii")
	 var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getesc2Details";
  	//alert($("#ticowner").val());
     $.ajax({
         type: 'POST',
         url: serviceUrl,
        // dataType: 'json',
         data : 'esc2=' + $("#esc2").val() ,
         success: function(data4) {
        	//alert(data4)
        		var dataval = JSON.parse(data4).toString();
        	// alert("dataval="+dataval)
    	    	var aaa = dataval.split(',');
        	// alert("0=="+aaa[0]);
        	// alert("1=="+aaa[1]);
        	
             $("#e2email").val(aaa[0])
             $("#e2mob").val(aaa[1])
             }
            
     });
}


function esc33()
{
	//alert("Hiii")
	 var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getesc3Details";
  	//alert($("#ticowner").val());
     $.ajax({
         type: 'POST',
         url: serviceUrl,
        // dataType: 'json',
         data : 'esc3=' + $("#esc3").val() ,
         success: function(data4) {
        	//alert(data4)
        		var dataval = JSON.parse(data4).toString();
        	// alert("dataval="+dataval)
    	    	var aaa = dataval.split(',');
        	// alert("0=="+aaa[0]);
        	// alert("1=="+aaa[1]);
        	
             $("#e3email").val(aaa[0])
             $("#e3mob").val(aaa[1])
             }
             
     });

}


function catonchange()
{
//	alert($("#company").val())
//	alert($("#category").val())
	
	  var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/getOwnNameDetails";
       
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            data : 'category=' + $("#category").val() 
            + '&company=' + $("#company").val(),
            success: function(data4) {
//            	alert(data4)
                       var html = "  <option value=''> -- Please Select --</option>";
                       for (var i = 0; i < data4.length; i++) {
                           html += '<option value="' + data4[i] + '">' + data4[i]
                                   + '</option>';
                       }

                       document.getElementById("ticowner").innerHTML = html;
                       document.getElementById("esc1").innerHTML = html;
                       document.getElementById("esc2").innerHTML = html;
                       document.getElementById("esc3").innerHTML = html;
                }

                
        });
      
        
//        var l = window.location;
//     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//     	var serviceUrl = base_url + "/Master/getesc1NameDetails";
//       
//        $.ajax({
//            type: 'POST',
//            url: serviceUrl,
//            dataType: 'json',
//            data : 'category=' + $("#category").val() ,
//            success: function(data4) {
//
//                       var html = "  <option value=''> -- Please Select --</option>";
//                       for (var i = 0; i < data4.length; i++) {
//                           html += '<option value="' + data4[i] + '">' + data4[i]
//                                   + '</option>';
//                       }
//
//                       document.getElementById("esc1").innerHTML = html;
//                }
//
//                
//        });
//      
//       
//        var l = window.location;
//     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//     	var serviceUrl = base_url + "/Master/getesc2NameDetails";
//       
//        $.ajax({
//            type: 'POST',
//            url: serviceUrl,
//            dataType: 'json',
//            data : 'category=' + $("#category").val() ,
//            success: function(data4) {
//
//                       var html = "  <option value=''> -- Please Select --</option>";
//                       for (var i = 0; i < data4.length; i++) {
//                           html += '<option value="' + data4[i] + '">' + data4[i]
//                                   + '</option>';
//                       }
//
//                       document.getElementById("esc2").innerHTML = html;
//                }
//
//                
//        });
//        
//        var l = window.location;
//     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//     	var serviceUrl = base_url + "/Master/getesc3NameDetails";
//       
//        $.ajax({
//            type: 'POST',
//            url: serviceUrl,
//            dataType: 'json',
//            data : 'category=' + $("#category").val() ,
//            success: function(data4) {
//
//                       var html = "  <option value=''> -- Please Select --</option>";
//                       for (var i = 0; i < data4.length; i++) {
//                           html += '<option value="' + data4[i] + '">' + data4[i]
//                                   + '</option>';
//                       }
//
//                       document.getElementById("esc3").innerHTML = html;
//                }
//
//                
//        });
	
}


$("#submit-btn").click(function() {
	//alert("dgfsgf");
	if (!validation2222()) {
		// alert("in invalid");
		event.preventDefault();
	} else {
		// alert("in valid");
		saveDataUser();
	}
});

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/ViewEscMatrix";
$.ajax({
	type : 'POST',
	url : serviceUrl,
	dataType : 'json',
	success : function(data4) {
		// alert(data4)

		var table = $('#datatype').DataTable({
			lengthChange : false,
			pageLength : 5,
			data : data4,
			scrollY:300,
		    scrollX: true,
		    scrollCollapse: true,
		});

		table.buttons().container().appendTo(
				'#datatype_wrapper .col-sm-6:eq(0)');

	}

});



function saveDataUser() {
	 //alert("in save")
	//alert("$(t2).val()==="+$("#t2").val());
	//alert("$(t3).val()==="+$("#t3").val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/addEscalatorMatrix";
	$.ajax({
		url : serviceUrl,
		type : 'post',
		data : 'company=' + $("#company").val() 
		+ '&branch=' + $("#branch").val()
		+ '&category=' + $("#category").val() 
		+ '&priority=' + $("#priority").val() 
		+ '&mail=' + $("#mail").val() 
		+ '&sms=' + $("#sms").val() 
		+ '&ticowner=' + $("#ticowner").val()
        + '&esc1=' + $("#esc1").val() 
		+ '&esc2=' + $("#esc2").val()
		+ '&esc3=' + $("#esc3").val()
		+ '&towneremail=' + $("#towneremail").val()
		+ '&e1email=' + $("#e1email").val() 
		+ '&e2email=' + $("#e2email").val()
		+ '&e3email=' + $("#e3email").val()
		+ '&townermob=' + $("#townermob").val()
		+ '&e1mob=' + $("#e1mob").val()
		+ '&e2mob=' + $("#e2mob").val()
		+ '&t0=' + $("#t0").val()
		+ '&t1=' + $("#t1").val()
		+ '&t2=' + $("#t2").val()
		+ '&t3=' + $("#t3").val()
		+ '&tt0=' + $("#tt0").val()
		+ '&tt1=' + $("#tt1").val()
		+ '&tt2=' + $("#tt2").val()
		+ '&tt3=' + $("#tt3").val()
		+ '&e3mob=' + $("#e3mob").val(),
		// + '&athorrrr=' + $("#athorrrr").val(),
		success : function(data) {
			// alert(data)
			if (data == "success") {
				swal({
					title : "Successful!",
					text : "Record Inserted Successfully",
					type: "success",
                    width: 300,
                    height: 200,
//                            showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,

					preConfirm : function() {
						location.reload();
					}

				})

			} else if (data == "update") {
				swal({
					title : "Updated!",
					text : "Record Updated Successfully",
					type: "success",
                    width: 300,
                    height: 200,
//                            showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,

					preConfirm : function() {
						location.reload();
					}

				})

			}
		}
	})
}

//------------------


var callToolTip122 = function (fieldName, status) {

    if (fieldName == "company") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Company Name<span>";

    }else if (fieldName == "branch") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Branch Name<span>";

    }else if (fieldName == "category") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select category Name<span>";

     }else if (fieldName == "ticowner") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select Ticket Owner Name<span>";

     }else if (fieldName == "esc1") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select Escalator-1 Name<span>";

     }else if (fieldName == "esc3") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select Escalator-3 Name<span>";

     }else if (fieldName == "esc2") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select Escalator-2 Name<span>";

     }else if (fieldName == "priority") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select Priority<span>";

     }else if (fieldName == "sms") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select SMS<span>";

     }else if (fieldName == "mail") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please select Mail<span>";

     }else if (fieldName == "t0") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter<br>Time<span>";

     }else if (fieldName == "wrongt0") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter<br>Correct Time<span>";
         
     }else if (fieldName == "t1") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter <br>Time<span>";

     }else if (fieldName == "wrongt1") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter<br>Correct Time<span>";
         
     }else if (fieldName == "t2") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter<br> Time<span>";

     }else if (fieldName == "wrongt2") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter<br>Correct Time<span>";
         
     }else if (fieldName == "t3") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter<br>Time<span>";

     }else if (fieldName == "wrongt3") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter<br>Correct Time<span>";
         
     }else if (fieldName == "tt0") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select<br>Format<span>";

     }else if (fieldName == "tt1") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select<br> Format<span>";

     }else if (fieldName == "tt2") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select<br>Format<span>";

     }else if (fieldName == "tt3") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select <br>Format<span>";

     }
    
   
 $("#" + fieldName).tooltip({
        
        trigger: 'manual',
        at: 'center',
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

//---------------

$('#company').on('focusout', function () {
    var usertype = $('#company').val();

    if (usertype.trim() == "") {
        callToolTip122('company', 'show');
    }
    else {
        callToolTip122('company', 'hide');
    }
    
 });

$('#branch').on('focusout', function () {
    var usertype = $('#branch').val();

    if (usertype.trim() == "") {
        callToolTip122('branch', 'show');
    }
    else {
        callToolTip122('branch', 'hide');
    }
});


$('#category').on('focusout', function () {
    var usertype = $('#category').val();

    if (usertype.trim() == "") {
        callToolTip122('category', 'show');
    }
    else {
        callToolTip122('category', 'hide');
    }
});

$('#ticowner').on('focusout', function () {
    var usertype = $('#ticowner').val();

    if (usertype.trim() == "") {
        callToolTip122('ticowner', 'show');
    }
    else {
        callToolTip122('ticowner', 'hide');
    }
});

$('#esc1').on('focusout', function () {
    var usertype = $('#esc1').val();

    if (usertype.trim() == "") {
        callToolTip122('esc1', 'show');
    }
    else {
        callToolTip122('esc1', 'hide');
    }
});

$('#esc2').on('focusout', function () {
    var usertype = $('#esc2').val();

    if (usertype.trim() == "") {
        callToolTip122('esc2', 'show');
    }
    else {
        callToolTip122('esc2', 'hide');
    }
});

$('#esc3').on('focusout', function () {
    var usertype = $('#esc3').val();

    if (usertype.trim() == "") {
        callToolTip122('esc3', 'show');
    }
    else {
        callToolTip122('esc3', 'hide');
    }
});


$('#priority').on('focusout', function () {
    var usertype = $('#priority').val();

    if (usertype.trim() == "") {
        callToolTip122('priority', 'show');
    }
    else {
        callToolTip122('priority', 'hide');
    }
});


$('#sms').on('focusout', function () {
    var usertype = $('#sms').val();

    if (usertype.trim() == "") {
        callToolTip122('sms', 'show');
    }
    else {
        callToolTip122('sms', 'hide');
    }
});


$('#mail').on('focusout', function () {
    var usertype = $('#mail').val();

    if (usertype.trim() == "") {
        callToolTip122('mail', 'show');
    }
    else {
        callToolTip122('mail', 'hide');
    }
});


$('#t0').on('focusout', function () {
    var usertype = $('#t0').val();

    if (usertype.trim() == "") {
        callToolTip122('t0', 'show');
    }
    else {
        callToolTip122('t0', 'hide');
    }
    
 });


$('#t1').on('focusout', function () {
    var usertype = $('#t1').val();

    if (usertype.trim() == "") {
        callToolTip122('t1', 'show');
    }
    else {
        callToolTip122('t1', 'hide');
    }
    
 });


$('#t2').on('focusout', function () {
    var usertype = $('#t2').val();

    if (usertype.trim() == "") {
        callToolTip122('t2', 'show');
    }
    else {
        callToolTip122('t2', 'hide');
    }
    
 });


$('#t3').on('focusout', function () {
    var usertype = $('#t3').val();

    if (usertype.trim() == "") {
        callToolTip122('t3', 'show');
    }
    else {
        callToolTip122('t3', 'hide');
    }
    
 });


$('#tt0').on('focusout', function () {
    var usertype = $('#tt0').val();

    if (usertype.trim() == "") {
        callToolTip122('tt0', 'show');
    }
    else {
        callToolTip122('tt0', 'hide');
    }
    
 });



$('#tt1').on('focusout', function () {
    var usertype = $('#tt1').val();

    if (usertype.trim() == "") {
        callToolTip122('tt1', 'show');
    }
    else {
        callToolTip122('tt1', 'hide');
    }
    
 });

$('#tt2').on('focusout', function () {
    var usertype = $('#tt2').val();

    if (usertype.trim() == "") {
        callToolTip122('tt2', 'show');
    }
    else {
        callToolTip122('tt2', 'hide');
    }
    
 });

$('#tt3').on('focusout', function () {
    var usertype = $('#tt3').val();

    if (usertype.trim() == "") {
        callToolTip122('tt3', 'show');
    }
    else {
        callToolTip122('tt3', 'hide');
    }
    
 });


//----------------

$('#company').on('focus', function () {
    callToolTip122('company', 'destroy');
});

$('#branch').on('focus', function () {
    callToolTip122('branch', 'destroy');
});

$('#category').on('focus', function () {
    callToolTip122('category', 'destroy');
});


$('#ticowner').on('focus', function () {
    callToolTip122('ticowner', 'destroy');
});


$('#esc1').on('focus', function () {
    callToolTip122('esc1', 'destroy');
});


$('#esc2').on('focus', function () {
    callToolTip122('esc2', 'destroy');
});


$('#esc3').on('focus', function () {
    callToolTip122('esc3', 'destroy');
});

$('#priority').on('focus', function () {
    callToolTip122('priority', 'destroy');
});

$('#sms').on('focus', function () {
    callToolTip122('sms', 'destroy');
});

$('#mail').on('focus', function () {
    callToolTip122('mail', 'destroy');
});

$('#t0').on('focus', function () {
    callToolTip122('t0', 'destroy');
    callToolTip122('wrongt0', 'destroy');
});

$('#t1').on('focus', function () {
    callToolTip122('t1', 'destroy');
    callToolTip122('wrongt1', 'destroy');
});

$('#t2').on('focus', function () {
    callToolTip122('t2', 'destroy');
    callToolTip122('wrongt2', 'destroy');
});


$('#t3').on('focus', function () {
    callToolTip122('t3', 'destroy');
    callToolTip122('wrongt3', 'destroy');
});

$('#tt0').on('focus', function () {
    callToolTip122('tt0', 'destroy');
});

$('#tt1').on('focus', function () {
    callToolTip122('tt1', 'destroy');
});

$('#tt2').on('focus', function () {
    callToolTip122('tt2', 'destroy');
});

$('#tt3').on('focus', function () {
    callToolTip122('tt3', 'destroy');
});


//---------------------

var validation2222 = function () {
    
  var indexError = 0;
    if ($('#company').val().trim() === '') {
        callToolTip122('company', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#branch').val().trim() === '') {
        callToolTip122('branch', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#category').val().trim() === '') {
        callToolTip122('category', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#ticowner').val().trim() === '') {
        callToolTip122('ticowner', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#esc1').val().trim() === '') {
        callToolTip122('esc1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#esc2').val().trim() === '') {
        callToolTip122('esc2', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#esc3').val().trim() === '') {
        callToolTip122('esc3', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }

    if ($('#priority').val().trim() === '') {
        callToolTip122('priority', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#mail').val().trim() === '') {
        callToolTip122('mail', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    
    if ($('#sms').val().trim() === '') {
        callToolTip122('sms', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#t0').val().trim() === '') {
        callToolTip122('t0', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        
    } else if (!T0Input())
    {
    	 indexError = indexError + 1;
          console.log("In invalid Digit number: "+indexError);

     }
    
    if ($('#t1').val().trim() === '') {
        callToolTip122('t1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        
    } else if (!T1Input())
    {
   	 indexError = indexError + 1;
         console.log("In invalid Digit number: "+indexError);

    }
    
    if ($('#t2').val().trim() === '') {
        callToolTip122('t2', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        
    } else if (!T2Input())
    {
   	 indexError = indexError + 1;
         console.log("In invalid Digit number: "+indexError);

    }
   
    if ($('#t3').val().trim() === '') {
        callToolTip122('t3', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        
    } else if (!T3Input())
    {
   	 indexError = indexError + 1;
         console.log("In invalid Digit number: "+indexError);

    }
    
    if ($('#tt0').val().trim() === '') {
        callToolTip122('tt0', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     
    if ($('#tt1').val().trim() === '') {
        callToolTip122('tt1', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    
    if ($('#tt2').val().trim() === '') {
        callToolTip122('tt2', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    
    if ($('#tt3').val().trim() === '') {
        callToolTip122('tt3', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if (($('#t0').val().trim() === '00' || $('#t0').val().trim() === '0') && ($('#t1').val().trim() === '00' || $('#t1').val().trim() === '0') && ($('#t2').val().trim() === '00' || $('#t2').val().trim() === '0') && ($('#t3').val().trim() === '00' || $('#t3').val().trim() === '0')) {

    	swal({
                title: "Alert!",
                text: "Time not set for Escalation Matrix",
                type: "error",
                width: 300,
                height: 200,
                buttons: false,
                allowOutsideClick: false,

            });
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }  
   
      if (indexError > 0) {
//        alert("false")
        return false;

    } else {
//        alert("true")
        return true;
    }

    
}

//-------------------

$("#resetbtn").click(function() {
    $("#company").val("");
    $("#branch").val("");
    $("#category").val("");
    $("#ticowner").val("");
    $("#esc1").val("");
    $("#esc2").val("");
    $("#esc3").val("");
    $("#towneremail").val("");
    $("#e1email").val("");
    $("#e2email").val("");
    $("#e3email").val("");
    $("#townermob").val("");
    $("#e1mob").val("");
    $("#e2mob").val("");
    $("#e3mob").val("");
    $("#priority").val("");
    $("#sms").val("");
    $("#mail").val("");
    
    $("#t0").val("");
    $("#t1").val("");
    $("#t2").val("");
    $("#t3").val("");
    $("#tt0").val("");
    $("#tt1").val("");
    $("#tt2").val("");
    $("#tt3").val("");
    
   
    

    callToolTip122('company', 'hide');
    callToolTip122('branch', 'hide');
    
    callToolTip122('category', 'hide');
    callToolTip122('ticowner', 'hide'); 
    callToolTip122('esc1', 'hide');
    callToolTip122('esc2', 'hide'); 
    callToolTip122('esc3', 'hide');
//    callToolTip122('towneremail', 'hide'); 
//    callToolTip122('e1email', 'hide');
//    callToolTip122('e2email', 'hide'); 
//    callToolTip122('e3email', 'hide');
//    callToolTip122('townermob', 'hide'); 
//    callToolTip122('e1mob', 'hide');
//    callToolTip122('e2mob', 'hide');
//    callToolTip122('e3mob', 'hide');
    callToolTip122('priority', 'hide');
    callToolTip122('sms', 'hide');
    callToolTip122('mail', 'hide');
    
    callToolTip122('t0', 'hide');
    callToolTip122('t1', 'hide');
    callToolTip122('t2', 'hide');
    callToolTip122('t3', 'hide');
    callToolTip122('t4', 'hide');
    callToolTip122('tt0', 'hide');
    callToolTip122('tt1', 'hide');
    callToolTip122('tt2', 'hide');
    callToolTip122('tt3', 'hide');
    callToolTip122('wrongt0', 'hide');
    callToolTip122('wrongt1', 'hide');
    callToolTip122('wrongt2', 'hide');
    callToolTip122('wrongt3', 'hide');
    
    
})

function T0Input() {
    var inputtxt = $('#t0').val();
    var digits = /^\d{1,2}$/;

    if (inputtxt.match(digits))
    {
        return true;
    }
    else
    {
    	callToolTip122('wrongt0', 'show');
        return false;
    }
}
function T1Input() {
    var inputtxt = $('#t1').val();
    var digits = /^\d{1,2}$/;

    if (inputtxt.match(digits))
    {
        return true;
    }
    else
    {
    	callToolTip122('wrongt1', 'show');
        return false;
    }
}

function T2Input() {
    var inputtxt = $('#t2').val();
    var digits = /^\d{1,2}$/;

    if (inputtxt.match(digits))
    {
        return true;
    }
    else
    {
    	callToolTip122('wrongt2', 'show');
        return false;
    }
}

function T3Input() {
    var inputtxt = $('#t3').val();
    var digits = /^\d{1,2}$/;

    if (inputtxt.match(digits))
    {
        return true;
    }
    else
    {
    	callToolTip122('wrongt3', 'show');
        return false;
    }
}