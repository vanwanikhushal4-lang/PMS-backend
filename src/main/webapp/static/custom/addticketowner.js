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
     
     
     
     var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCategoryDetails";
     
      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          success: function(data4) {
//              alert(data4)
//             var pollingHost = data4;
//                     var d = pollingHost.split(",");
//                     var length = d.length - 1;
                     var html = "  <option value=''> -- Please Select --</option>";
                     for (var i = 0; i < data4.length; i++) {
//                         alert(data4[i]);
                         html += '<option value="' + data4[i] + '">' + data4[i]
                                 + '</option>';
                     }

                     document.getElementById("category").innerHTML = html;
                    // document.getElementById("categoryupdate").innerHTML = html;
              }

              
      });
      
      
      
      var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getBranchDetails";
      
       $.ajax({
           type: 'POST',
           url: serviceUrl,
           dataType: 'json',
           success: function(data4) {
               //alert(data4)
//              var pollingHost = data4;
//                      var d = pollingHost.split(",");
//                      var length = d.length - 1;
                      var html = "  <option value=''> -- Please Select --</option>";
                      for (var i = 0; i < data4.length; i++) {
//                          alert(data4[i]);
                          html += '<option value="' + data4[i] + '">' + data4[i]
                                  + '</option>';
                      }

                      document.getElementById("branch").innerHTML = html;
                     // document.getElementById("categoryupdate").innerHTML = html;
               }

               
       });      
      

};




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
var serviceUrl = base_url + "/Master/ViewTicketOwner";
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
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/addTicketOwner";
	$.ajax({
		url : serviceUrl,
		type : 'post',
		data : 'company=' + $("#company").val() 
		+ '&branch=' + $("#branch").val()
		+ '&category=' + $("#category").val() 
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
		+ '&e3mob=' + $("#e3mob").val(),
		// + '&athorrrr=' + $("#athorrrr").val(),
		success : function(data) {
			// alert(data)
			if (data == "success") {
				swal({
					title : "Successfull!",
					text : "Record Inserted Successfully",
					type : "success",
					width : 300,
					height : 200,
					showCancelButton : !0,
					confirmButtonClass : "btn btn-danger",
					cancelButtonClass : "btn btn-danger m-l-10",
					confirmButtonText : "OK",
					preConfirm : function() {
						location.reload();
					}

				})

			} else if (data == "duplicate") {
				swal({
					title : "Duplicate!",
					text : "Record Exists",
					type : "success",
					width : 300,
					height : 200,
					showCancelButton : !0,
					confirmButtonClass : "btn btn-danger",
					cancelButtonClass : "btn btn-danger m-l-10",
					confirmButtonText : "OK",
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

    }
     else if (fieldName == "branch") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Branch Name<span>";

    }
     else if (fieldName == "category") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Select category Name<span>";

     }
     else if (fieldName == "ticowner") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Ticket Owner Name<span>";

     }
     else if (fieldName == "towneremail") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Valid Email-ID <span>";

     }
     else if (fieldName == "townermob") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Ticket Owner Mobile Number <span>";

     }
     else if (fieldName == "esc1") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Escalator-1 Name<span>";

     }
     else if (fieldName == "e1email") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Valid Email-ID<span>";

     }
     else if (fieldName == "e1mob") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Escalator-1 Mobile Number<span>";

     } else if (fieldName == "esc3") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Escalator-3 Name<span>";

     }
     else if (fieldName == "e3email") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Valid Email-ID<span>";

     }
     else if (fieldName == "e3mob") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Escalator-3 Mobile Numebr<span>";

     }
     else if (fieldName == "esc2") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Escalator-2 Name<span>";

     }
     else if (fieldName == "e2email") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Valid Email-ID<span>";

     }
     else if (fieldName == "e2mob") {
         //$("#email").tooltip('destroy');
         var errorMessage = "<span>Please Enter Escalator-2 Mobile Number<span>";

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
    	//alert("email tip show here")
        $("#" + fieldName).tooltip('show');

    } else {
    	//alert("email tip hide here")
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
    else if (!nameUnique()) {
    	//alert("wrong format tooltip")
    	callToolTip122('ticowner', 'show');
    }
   
    else if (nameUnique()) {
    	//alert("right format tooltip")
    	callToolTip122('ticowner', 'hide');
    }
});

$('#esc1').on('focusout', function () {
    var usertype = $('#esc1').val();

    if (usertype.trim() == "") {
        callToolTip122('esc1', 'show');
    }
    else if (!nameUnique1()) {
    	//alert("wrong format tooltip")
    	callToolTip122('esc1', 'show');
    }
   
    else if (nameUnique1()) {
    	//alert("right format tooltip")
    	callToolTip122('esc1', 'hide');
    }
});

$('#esc2').on('focusout', function () {
    var usertype = $('#esc2').val();

    if (usertype.trim() == "") {
        callToolTip122('esc2', 'show');
    }
    else if (!nameUnique2()) {
    	//alert("wrong format tooltip")
    	callToolTip122('esc2', 'show');
    }
   
    else if (nameUnique2()) {
    	//alert("right format tooltip")
    	callToolTip122('esc2', 'hide');
    }
});

$('#esc3').on('focusout', function () {
    var usertype = $('#esc3').val();

    if (usertype.trim() == "") {
        callToolTip122('esc3', 'show');
    }
    else if (!nameUnique3()) {
    	//alert("wrong format tooltip")
    	callToolTip122('esc3', 'show');
    }
   
    else if (nameUnique3()) {
    	//alert("right format tooltip")
    	callToolTip122('esc3', 'hide');
    }
});

$('#towneremail').on('focusout', function () {
    var usertype = $('#towneremail').val();

    if (usertype.trim() == "") {
    	//alert("emprty tip")
        callToolTip122('towneremail', 'show');
    }

    else if (!validateEmailown()) {
    	//alert("wrong format tooltip")
    	callToolTip122('towneremail', 'show');
    }
   
    else if (validateEmailown()) {
    	//alert("right format tooltip")
    	callToolTip122('towneremail', 'hide');
    }
});




$('#e1email').on('focusout', function () {
    var usertype = $('#e1email').val();

    if (usertype.trim() == "") {
        callToolTip122('e1email', 'show');
    }
   
   
    else if (!validateEmail1()) {
    	//alert("wrong format tooltip")
    	callToolTip122('e1email', 'show');
    }
   
    else if (validateEmail1()) {
    	//alert("right format tooltip")
    	callToolTip122('e1email', 'hide');
    }
});

$('#e2email').on('focusout', function () {
    var usertype = $('#e2email').val();

    if (usertype.trim() == "") {
        callToolTip122('e2email', 'show');
    }
    
    
    else if (!validateEmail2()) {
    	//alert("wrong format tooltip")
    	callToolTip122('e2email', 'show');
    }
   
    else if (validateEmail2()) {
    	//alert("right format tooltip")
    	callToolTip122('e2email', 'hide');
    }
});

$('#e3email').on('focusout', function () {
    var usertype = $('#e3email').val();

    if (usertype.trim() == "") {
        callToolTip122('e3email', 'show');
    }
   
    
    else if (!validateEmail3()) {
    	//alert("wrong format tooltip")
    	callToolTip122('e3email', 'show');
    }
   
    else if (validateEmail3()) {
    	//alert("right format tooltip")
    	callToolTip122('e3email', 'hide');
    }
});

$('#townermob').on('focusout', function () {
    var usertype = $('#townermob').val();

    if (usertype.trim() == "") {
        callToolTip122('townermob', 'show');
    }
   
    
    else if (!phoneown()) {
    	//alert("wrong format tooltip")
    	callToolTip122('townermob', 'show');
    }
   
    else if (phoneown()) {
    	//alert("right format tooltip")
    	callToolTip122('townermob', 'hide');
    }
    
});

$('#e1mob').on('focusout', function () {
    var usertype = $('#e1mob').val();

    if (usertype.trim() == "") {
        callToolTip122('e1mob', 'show');
    }
    else if (!phone1()) {
    	//alert("wrong format tooltip")
    	callToolTip122('e1mob', 'show');
    }
   
    else if (phone1()) {
    	//alert("right format tooltip")
    	callToolTip122('e1mob', 'hide');
    }
});

$('#e2mob').on('focusout', function () {
    var usertype = $('#e2mob').val();

    if (usertype.trim() == "") {
        callToolTip122('e2mob', 'show');
    }
    else if (!phone2()) {
    	//alert("wrong format tooltip")
    	callToolTip122('e2mob', 'show');
    }
   
    else if (phone2()) {
    	//alert("right format tooltip")
    	callToolTip122('e2mob', 'hide');
    }
});


$('#e3mob').on('focusout', function () {
    var usertype = $('#e3mob').val();

    if (usertype.trim() == "") {
        callToolTip122('e3mob', 'show');
    }
    else if (!phone3()) {
    	//alert("wrong format tooltip")
    	callToolTip122('e3mob', 'show');
    }
   
    else if (phone3()) {
    	//alert("right format tooltip")
    	callToolTip122('e3mob', 'hide');
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


$('#towneremail').on('focus', function () {
    callToolTip122('towneremail', 'destroy');
});


$('#e1email').on('focus', function () {
    callToolTip122('e1email', 'destroy');
});


$('#e2email').on('focus', function () {
    callToolTip122('e2email', 'destroy');
});


$('#e3email').on('focus', function () {
    callToolTip122('e3email', 'destroy');
});


$('#townermob').on('focus', function () {
    callToolTip122('townermob', 'destroy');
});


$('#e1mob').on('focus', function () {
    callToolTip122('e1mob', 'destroy');
});


$('#e2mob').on('focus', function () {
    callToolTip122('e2mob', 'destroy');
});


$('#e3mob').on('focus', function () {
    callToolTip122('e3mob', 'destroy');
});

//---------------------

var validation2222 = function () {
    
    indexError = 0;
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
    if ($('#towneremail').val().trim() === '') {
        callToolTip122('towneremail', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   
    
    
    if ($('#e1email').val().trim() === '') {
        callToolTip122('e1email', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#e2email').val().trim() === '') {
        callToolTip122('e2email', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#e3email').val().trim() === '') {
        callToolTip122('e3email', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#townermob').val().trim() === '') {
        callToolTip122('townermob', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#e1mob').val().trim() === '') {
        callToolTip122('e1mob', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    
    if ($('#e2mob').val().trim() === '') {
        callToolTip122('e2mob', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#e3mob').val().trim() === '') {
        callToolTip122('e3mob', 'show');
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

//---------------email function----

function validateEmailown() {
	//alert("call to email val")
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
    var emailField = $('#towneremail').val();
    var e1email= $('#e1email').val();
    var e2email= $('#e2email').val();
    var e3email= $('#e3email').val();
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(emailField) == false)
    {
    	//alert("false rule")
        //callToolTipWrong('email', 'show');
        ret = false;
    }
 
    else
    {
    	//alert("true rule")
        ret = true;
    }
  //  alert("email val return value="+ret)
    return ret;
}


function validateEmail1() {
	//alert("call to email val")
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
   
    var e1email= $('#e1email').val();
   
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(e1email) == false)
    {
    	//alert("false rule")
        //callToolTipWrong('email', 'show');
        ret = false;
    }
 
    else
    {
    	//alert("true rule")
        ret = true;
    }
  //  alert("email val return value="+ret)
    return ret;
}

function validateEmail2() {
	//alert("call to email val")
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
   
    var e2email= $('#e2email').val();
   
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(e2email) == false)
    {
    	//alert("false rule")
        //callToolTipWrong('email', 'show');
        ret = false;
    }
 
    else
    {
    	//alert("true rule")
        ret = true;
    }
  //  alert("email val return value="+ret)
    return ret;
}


function validateEmail3() {
	//alert("call to email val")
    var ret = true;
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    //console.log("email:"+.value)
   
    var e3email= $('#e3email').val();
   
//    console.log('check email:' + reg.test($('#mail').val()))
    if (reg.test(e3email) == false)
    {
    	//alert("false rule")
        //callToolTipWrong('email', 'show');
        ret = false;
    }
 
    else
    {
    	//alert("true rule")
        ret = true;
    }
  //  alert("email val return value="+ret)
    return ret;
}


function phoneown() {
    var inputtxt = $('#townermob').val();
    console.log(inputtxt)
    var phoneno = /^\d{10}$/;
//  var phoneno = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
        //callToolTipWrong('townermob', 'show');
        return false;
    }
}

function phone1() {
    var inputtxt = $('#e1mob').val();
    console.log(inputtxt)
    var phoneno = /^\d{10}$/;
//  var phoneno = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
        //callToolTipWrong('e1mob', 'show');
        return false;
    }
}

function phone2() {
    var inputtxt = $('#e2mob').val();
    console.log(inputtxt)
    var phoneno = /^\d{10}$/;
//  var phoneno = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
       // callToolTipWrong('e2mob', 'show');
        return false;
    }
}


function phone3() {
    var inputtxt = $('#e3mob').val();
    console.log(inputtxt)
    var phoneno = /^\d{10}$/;
//  var phoneno = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
    if (inputtxt.match(phoneno))
    {
        return true;
    }
    else
    {
       // callToolTipWrong('e3mob', 'show');
        return false;
    }
}



function nameUnique1() {
	//alert("call to email val")
    var ret = true;
  
    //console.log("email:"+.value)
   
    var ticowner= $('#ticowner').val();
    var esc1= $('#esc1').val();
    var esc2= $('#esc2').val();
    var esc3= $('#esc3').val();
   
//    console.log('check email:' + reg.test($('#mail').val()))
    if (esc1 == ticowner || esc1 == esc2 || esc1 == esc3)
    {
    	//alert("false rule")
        //callToolTipWrong('email', 'show');
        ret = false;
    }
    else
    {
    	//alert("true rule")
        ret = true;
    }
    
  
  //  alert("email val return value="+ret)
    return ret;
}


function nameUnique2() {
	//alert("call to email val")
    var ret = true;
  
    //console.log("email:"+.value)
   
    var ticowner= $('#ticowner').val();
    var esc1= $('#esc1').val();
    var esc2= $('#esc2').val();
    var esc3= $('#esc3').val();
   

    
    
     if (esc2 == ticowner || esc2 == esc1 || esc2 == esc3)
    {
    	//alert("false rule")
        //callToolTipWrong('email', 'show');
        ret = false;
    }

    
    else
    {
    	//alert("true rule")
        ret = true;
    }
  //  alert("email val return value="+ret)
    return ret;
}

function nameUnique3() {
	//alert("call to email val")
    var ret = true;
  
    //console.log("email:"+.value)
   
    var ticowner= $('#ticowner').val();
    var esc1= $('#esc1').val();
    var esc2= $('#esc2').val();
    var esc3= $('#esc3').val();
   

 
     if (esc3 == ticowner || esc3 == esc1 || esc3 == esc2)
    {
    	//alert("false rule")
        //callToolTipWrong('email', 'show');
        ret = false;
    }
  
    
    else
    {
    	//alert("true rule")
        ret = true;
    }
  //  alert("email val return value="+ret)
    return ret;
}


function nameUnique() {
	//alert("call to email val")
    var ret = true;
  
    //console.log("email:"+.value)
   
    var ticowner= $('#ticowner').val();
    var esc1= $('#esc1').val();
    var esc2= $('#esc2').val();
    var esc3= $('#esc3').val();
   

     if (ticowner == esc1 || ticowner == esc2 || ticowner == esc3)
    {
    	//alert("false rule")
        //callToolTipWrong('email', 'show');
        ret = false;
    }
    
    
    else
    {
    	//alert("true rule")
        ret = true;
    }
  //  alert("email val return value="+ret)
    return ret;
}

//----

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
    
   
    

    callToolTip122('company', 'hide');
    callToolTip122('branch', 'hide');
    
    callToolTip122('category', 'hide');
    callToolTip122('ticowner', 'hide'); 
    callToolTip122('esc1', 'hide');
    callToolTip122('esc2', 'hide'); 
    callToolTip122('esc3', 'hide');
    callToolTip122('towneremail', 'hide'); 
    callToolTip122('e1email', 'hide');
    callToolTip122('e2email', 'hide'); 
    callToolTip122('e3email', 'hide');
    callToolTip122('townermob', 'hide'); 
    callToolTip122('e1mob', 'hide');
    callToolTip122('e2mob', 'hide');
    callToolTip122('e3mob', 'hide');
   
    
})
