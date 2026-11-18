 window.onload = function() {
     $('#host').focus();
     var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/getCompositecompanyDetails";
//	      var serviceUrl = "getDepartmentDetails";
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
//	         data: 'companyname=' + $("#cname").val(),
	         success: function(data4) {
//	             alert(data4)
//	            var pollingHost = data4;
//	                    var d = pollingHost.split(",");
//	                    var length = d.length - 1;
	        	 var html = "<option value=''>-- Please Select --</option>";
	                    for (var i = 0; i < data4.length; i++) {
//	                        alert(data4[i]);
	                        html += '<option value="' + data4[i] + '">' + data4[i]
	                                + '</option>';
	                    }

	                    document.getElementById("cname1").innerHTML = html;
	             }

	             
	     });
     var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/MailConfig/smsConfigListing";
  	  
      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          success: function(data4) {
 //alert(data4)


              var table = $('#datatype').DataTable({
                  lengthChange: false,
                  data: data4,
                  scrollX: true,
                  pageLength: 5,
                  
              });
//              $('#datatype td').css('white-space','initial');
              table.buttons().container().appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

          }

      });
     
 }
    
    var count=0;
    function AddFunc() {
       //alert("gffgbfd")
        count = count + 1;
        var x = document.getElementById("other1");
        var y = document.getElementById("other2");
         var z = document.getElementById("other3");
          var a = document.getElementById("other4");
           var b = document.getElementById("other5");
           
           
        if (x.style.display === "none") {
            x.style.display = "block";
        } else if (y.style.display === "none") {
            y.style.display = "block";
        }
        else if (z.style.display === "none") {
            z.style.display = "block";
        }
        else if (a.style.display === "none") {
            a.style.display = "block";
        }
        else if (b.style.display === "none") {
            b.style.display = "block";
        }
        else {
            x.style.display = "none";
            y.style.display = "none";
            z.style.display = "none";
            a.style.display = "none";
            b.style.display = "none";
        }
    }


    function RemoveFunc() {
      // alert("gffgbfd")
        count = count + 1;
        var x = document.getElementById("other1");
        var y = document.getElementById("other2");
         var z = document.getElementById("other3");
          var a = document.getElementById("other4");
           var b = document.getElementById("other5");
           
           
        if (x.style.display === "block") {
            x.style.display = "none";
        } else if (y.style.display === "block") {
            y.style.display = "none";
        }
        else if (z.style.display === "block" ) {
            z.style.display = "none";
        }
        else if (a.style.display === "block" ) {
            a.style.display = "none";
        }
        else if (b.style.display === "block" ) {
            b.style.display = "none";
        }
        else {
            x.style.display = "block";
            y.style.display = "block";
            z.style.display = "block";
            a.style.display = "block";
            b.style.display = "block";
        }
    }

    $("#test_button1").click(function () {

//       if(!smsCheck()){
//           event.preventDefault();
//       }
//       else if(smsCheck()){
            smsConfigOpen();
       //}
    }).show();

    function smsConfigOpen() {
        
        
    callToolTip231('message', 'hide');
    
    callToolTip231('contact', 'hide');
       if( $('#otherinput1').val()!="" && $('#otherinput2').val()!="" && $('#otherinput3').val()!="" && $('#otherinput4').val()!="" && $('#otherinput2').val()!="" && $('#otherinput3').val()!="" && $('#otherinput4').val()!="" && $('#otherinput5').val()!="" && $('#otherinput6').val()!="" && $('#otherinput7').val()!="" && $('#otherinput8').val()!="")
       {
          $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+$('#textvalue').val()+"&"+$('#cname').val()+"="+$('#cnamevalue').val()+"&"+$('#otherinput1').val()+"="+$('#otherinput2').val()+"&"+$('#otherinput3').val()+"="+$('#otherinput4').val()+"&"+$('#otherinput5').val()+"="+$('#otherinput6').val()+"&"+$('#otherinput7').val()+"="+$('#otherinput8').val());
       } 
       
       else if($('#otherinput1').val()!="" && $('#otherinput2').val()!=""&& $('#otherinput3').val()!="" && $('#otherinput4').val()!=""  )
       {
          $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+$('#textvalue').val()+"&"+$('#cname').val()+"="+$('#cnamevalue').val()+"&"+$('#otherinput1').val()+"="+$('#otherinput2').val()+"&"+$('#otherinput3').val()+"="+$('#otherinput4').val());
       } 
       
       else if($('#otherinput1').val()!="" && $('#otherinput2').val()!="" && $('#otherinput3').val()!="" && $('#otherinput4').val()!="" && $('#otherinput5').val()!="" && $('#otherinput6').val()!="")
       {
          $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+$('#textvalue').val()+"&"+$('#cname').val()+"="+$('#cnamevalue').val()+"&"+$('#otherinput1').val()+"="+$('#otherinput2').val()+"&"+$('#otherinput3').val()+"="+$('#otherinput4').val()+"&"+$('#otherinput5').val()+"="+$('#otherinput6').val());
       }  
       else{
            $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+$('#textvalue').val()+"&"+$('#cname').val()+"="+$('#cnamevalue').val());
          
                
                }
       $('#contact').val("");
       $('#message').val("");
        $("#smstest").modal("show");
               
    }


    $("#send_btn").click(function() {

    if(smsTestCheck()){
      

        var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/MailConfig/sendmailsms";
     
        $.ajax(
        {
            type : 'POST',
            url : serviceUrl,
            data: {tomailsms:$('#tomailsms').val() },
       

            success: function (data) {
               
                console.log(data);
                //alert(data)

                if (data == "message_send") {
                    swal({
                        title: "SMS Sent Successfully!",
                        text: "SMS",
                        type: "success",
                        width: 300,
                        height: 200,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-success",
                        cancelButtonClass: "btn btn-danger m-l-10",
                        confirmButtonText: "OK",
//                        preConfirm: function () {
//                            var l = window.location;
//                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                            window.location.href = base_url + "/SMS-Config";
//                        }
                    })
                }

                else if (data == "invalid_senderid") {

                    swal({
                        title: "Invalid Sender ID",
                        text: "SMS Sending Failed !",
                        type: "error",
                        width: 300,
                        height: 200,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-danger",
                        cancelButtonClass: "btn btn-danger m-l-10",
                        confirmButtonText: "OK",
//                        preConfirm: function () {
//                            var l = window.location;
//                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                            window.location.href = base_url + "/SMS-Config";
//                        }
                    })
                }
                 else if (data == "invalid_number") {

                    swal({
                        title: "Invalid Mobile Number",
                        text: "SMS Sending Failed !",
                        type: "error",
                        width: 300,
                        height: 200,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-danger",
                        cancelButtonClass: "btn btn-danger m-l-10",
                        confirmButtonText: "OK",
//                        preConfirm: function () {
//                            var l = window.location;
//                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                            window.location.href = base_url + "/SMS-Config";
//                        }
                    })
                }
                else if (data == "invalid_userid") {

                    swal({
                        title: "Invalid User Id",
                        text: "SMS Sending Failed !",
                        type: "error",
                        width: 300,
                        height: 200,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-danger",
                        cancelButtonClass: "btn btn-danger m-l-10",
                        confirmButtonText: "OK",
//                        preConfirm: function () {
//                            var l = window.location;
//                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                            window.location.href = base_url + "/SMS-Config";
//                        }
                    })
                }
                else if (data == "invalid_password") {

                    swal({
                        title: "Invalid Password",
                        text: "SMS Sending Failed !",
                        type: "error",
                        width: 300,
                        height: 200,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-danger",
                        cancelButtonClass: "btn btn-danger m-l-10",
                        confirmButtonText: "OK",
//                        preConfirm: function () {
//                            var l = window.location;
//                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                            window.location.href = base_url + "/SMS-Config";
//                        }
                    })
                }
                else if (data == "fail") {

                    swal({
                        title: "Fail",
                        text: "SMS Sending Failed !",
                        type: "error",
                        width: 300,
                        height: 200,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-danger",
                        cancelButtonClass: "btn btn-danger m-l-10",
                        confirmButtonText: "OK",
//                        preConfirm: function () {
//                            var l = window.location;
//                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                            window.location.href = base_url + "/SMS-Config";
//                        }
                    })
                }
                else if (data == "fail_catch_exception") {

                    swal({
                        title: "Failed",
                        text: "SMS Sending Failed !",
                        type: "error",
                        width: 300,
                        height: 200,
                        showCancelButton: !0,
                        confirmButtonClass: "btn btn-danger",
                        cancelButtonClass: "btn btn-danger m-l-10",
                        confirmButtonText: "OK",
//                        preConfirm: function () {
//                            var l = window.location;
//                            var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                            window.location.href = base_url + "/SMS-Config";
//                        }
                    })
                }
      
            }
      
        });
        }
        });
        
    $("#submit-btnSMS").click(function () {
//alert("hii");
     //  if(!smsCheck()){
       //    event.preventDefault();
      // }
      // else if(smsCheck()){
            smsConfigsave();
      // }
    }).show();


    var smsCheck = function () {

        indexError = 0;
         if ($('#cname').val() === '') {
            callToolTip231('cname', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }

        if ($('#cname1').val() === '') {
            callToolTip231('cname1', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }
        if ($('#apiname').val() === '') {
            callToolTip231('apiname', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }v

        if ($('#apiurl').val().trim() === '') {
            callToolTip231('apiurl', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }


     if ($('#uname').val().trim() === '') {
            callToolTip231('uname', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }
         if ($('#uservalue1').val() === '') {
            callToolTip231('uservalue1', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }
         if ($('#userpswd').val() === '') {
            callToolTip231('userpswd', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }
    if ($('#pwdvalue1').val() === '') {
            //console.log('inside time')
            callToolTip231('pwdvalue1', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }
        if ($('#userID').val() === '') {
            callToolTip231('userID', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }
        if ($('#uidvalue').val() === '') {
            callToolTip231('uidvalue', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }
        if ($('#text1').val() === '') {
            callToolTip231('text1', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }

         if ($('#active4').val() === '-1') {
            callToolTip231('active4', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }



        if (indexError > 0) {
            return false;

        } 
        else
        {
           return true; 
        }
    }

    var smsTestCheck = function () {

        indexError = 0;
         if ($('#message').val() === '') {
            callToolTip231('message', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }

        if ($('#contact').val() === '') {
            callToolTip231('contact', 'show');
            if (indexError == 0) {

            }
            indexError = indexError + 1;
        }
          

        if (indexError > 0) {
            return false;

        } 
        else
        {
           return true; 
        }
    }

    var callToolTip231 = function(fieldName, status) {
        if (fieldName == "apiname")
        {
            var errorMessage = "<span>Please Enter API Name<span>";
        }
        if (fieldName == "cname1")
        {
            var errorMessage = "<span>Please Enter Company Name<span>";
        }
        else if (fieldName == "apiurl")
        {
            var errorMessage = "<span>Please Enter API URL<span>";
        }
        else if (fieldName == "uname")
        {
            var errorMessage = "<span>Please Enter Username Variable<span>";
        }
        else if (fieldName == "uservalue1")
        {
            var errorMessage = "<span>Please Enter Username<span>";
        }
        else if (fieldName == "cname")
        {
            var errorMessage = "<span>Please Enter Contact Variable<span>";
        }  
        if (fieldName == "userpswd")
        {
            var errorMessage = "<span>Please Enter Password Variable<span>";
        }
        else if (fieldName == "pwdvalue1")
        {
            var errorMessage = "<span>Please Enter Password<span>";
        }
        else if (fieldName == "userID") 
        {
            var errorMessage = "<span>Please Enter APIUser ID Variable<span>";
        }
        else if (fieldName == "uidvalue") 
        {
            var errorMessage = "<span>Please Enter APIUser ID<span>";
        }
        else if (fieldName == "text1") 
        {
            var errorMessage = "<span>Please Enter Message Variable<span>";
        }
        else if (fieldName == "active4") 
        {
            var errorMessage = "<span>Please Select Activation<span>";
        }
        else if (fieldName == "contact") 
        {
            var errorMessage = "<span>Please Enter Contact Number<span>";
        }
        else if (fieldName == "message") 
        {
            var errorMessage = "<span>Please Enter Message<span>";
        }

        $("#" + fieldName).tooltip({
            trigger: 'manual',
            placement: 'top',
            title: errorMessage,
            animation:true,
            delay: 1000,
            html: true
        });

        if (status == "show")
        {
            $("#" + fieldName).tooltip('show');
        }
        else
        {
            $("#" + fieldName).tooltip('hide');
        }
    }


    var smsConfigsave = function () {
           //alert($('#cname1').val())
       var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/MailConfig/smsConfg";
     	

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: c
               + "&cnamevalue=" +"spalert_contact"
                    + "&apiname=" + $('#apiname').val()
                     + "&cname1=" + encodeURIComponent($('#cname1').val())
                    + "&apiurl=" + $('#apiurl').val()
                    + "&uname=" + $('#uname').val()
                    + "&uservalue1=" + $('#uservalue1').val()
                    
                   + "&userpswd=" + $('#userpswd').val()
                 + "&pwdvalue1=" + $('#pwdvalue1').val()
         + "&userID=" + $('#userID').val()
         + "&uidvalue=" + $('#uidvalue').val()
         + "&text1=" + $('#text1').val()
         + "&textvalue=" +"spalert_msg"
         + "&active4=" + $('#active4').val()
         + "&otherinput1=" + $('#otherinput1').val()
            + "&otherinput2=" + $('#otherinput2').val()
    + "&otherinput3=" + $('#otherinput3').val()
            + "&otherinput4=" + $('#otherinput4').val()
    + "&otherinput5=" + $('#otherinput5').val()
            + "&otherinput6=" + $('#otherinput6').val()
    + "&otherinput7=" + $('#otherinput7').val()
            + "&otherinput8=" + $('#otherinput8').val()
            ,




        }).done(function (data) {
            
            if(data=="success")
            {
              swal({
                    title: "Successfull!",
                    text: "Record Added Successfully ",
                    type: "success",
                    width: 300,
                    height: 200,
                  
                    confirmButtonClass: "btn btn-success",
                   
                    confirmButtonText: "OK",
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/SMSMaster";
                    }

                })  
            }
           else if (data == "update") {
                swal({
                    title: "Updated!",
                    text: "Record Updated Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    showCancelButton: !0,
                    confirmButtonClass: "btn btn-danger",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    confirmButtonText: "OK",
                    preConfirm: function () {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/SMSMaster";
                    }

                })

            }

        });
    }


    function Numbermob(){
        var message=$('#message').val().split(' ').join('%20');
                
                
                //$('#message').val().replace(" ","%20");
        if( $('#otherinput1').val()!="" && $('#otherinput2').val()!="" && $('#otherinput3').val()!="" && $('#otherinput4').val()!="" && $('#otherinput2').val()!="" && $('#otherinput3').val()!="" && $('#otherinput4').val()!="" && $('#otherinput5').val()!="" && $('#otherinput6').val()!="" && $('#otherinput7').val()!="" && $('#otherinput8').val()!="")
       {
          $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+message+"&"+$('#cname').val()+"="+$('#contact').val()+"&"+$('#otherinput1').val()+"="+$('#otherinput2').val()+"&"+$('#otherinput3').val()+"="+$('#otherinput4').val()+"&"+$('#otherinput5').val()+"="+$('#otherinput6').val()+"&"+$('#otherinput7').val()+"="+$('#otherinput8').val());
       } 
       
       else if($('#otherinput1').val()!="" && $('#otherinput2').val()!=""&& $('#otherinput3').val()!="" && $('#otherinput4').val()!=""  )
       {
          $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+message+"&"+$('#cname').val()+"="+$('#contact').val()+"&"+$('#otherinput1').val()+"="+$('#otherinput2').val()+"&"+$('#otherinput3').val()+"="+$('#otherinput4').val());
       } 
       
       else if($('#otherinput1').val()!="" && $('#otherinput2').val()!="" && $('#otherinput3').val()!="" && $('#otherinput4').val()!="" && $('#otherinput5').val()!="" && $('#otherinput6').val()!="")
       {
          $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+message+"&"+$('#cname').val()+"="+$('#contact').val()+"&"+$('#otherinput1').val()+"="+$('#otherinput2').val()+"&"+$('#otherinput3').val()+"="+$('#otherinput4').val()+"&"+$('#otherinput5').val()+"="+$('#otherinput6').val());
       }  
       else{
            $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+message+"&"+$('#cname').val()+"="+$('#contact').val());
          
                
                }
        
    }
    function NewText(){
        
      var message=$('#message').val().split(' ').join('%20');
        
         if( $('#otherinput1').val()!="" && $('#otherinput2').val()!="" && $('#otherinput3').val()!="" && $('#otherinput4').val()!="" && $('#otherinput2').val()!="" && $('#otherinput3').val()!="" && $('#otherinput4').val()!="" && $('#otherinput5').val()!="" && $('#otherinput6').val()!="" && $('#otherinput7').val()!="" && $('#otherinput8').val()!="")
       {
          $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+message+"&"+$('#cname').val()+"="+$('#contact').val()+"&"+$('#otherinput1').val()+"="+$('#otherinput2').val()+"&"+$('#otherinput3').val()+"="+$('#otherinput4').val()+"&"+$('#otherinput5').val()+"="+$('#otherinput6').val()+"&"+$('#otherinput7').val()+"="+$('#otherinput8').val());
       } 
       
       else if($('#otherinput1').val()!="" && $('#otherinput2').val()!=""&& $('#otherinput3').val()!="" && $('#otherinput4').val()!=""  )
       {
          $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+message+"&"+$('#cname').val()+"="+$('#contact').val()+"&"+$('#otherinput1').val()+"="+$('#otherinput2').val()+"&"+$('#otherinput3').val()+"="+$('#otherinput4').val());
       } 
       
       else if($('#otherinput1').val()!="" && $('#otherinput2').val()!="" && $('#otherinput3').val()!="" && $('#otherinput4').val()!="" && $('#otherinput5').val()!="" && $('#otherinput6').val()!="")
       {
          $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+message+"&"+$('#cname').val()+"="+$('#contact').val()+"&"+$('#otherinput1').val()+"="+$('#otherinput2').val()+"&"+$('#otherinput3').val()+"="+$('#otherinput4').val()+"&"+$('#otherinput5').val()+"="+$('#otherinput6').val());
       }  
       else{
            $('#tomailsms').val($('#apiurl').val()+"?"+$('#uname').val()+"="+$('#uservalue1').val()+"&"+$('#userpswd').val()+"="+$('#pwdvalue1').val()+"&"+$('#userID').val()+"="+$('#uidvalue').val()+"&"+$('#text1').val()+"="+message+"&"+$('#cname').val()+"="+$('#contact').val());
          
                
                }
    }


    $('#apiname').on('focusout', function() {
        var usertype = $('#apiname').val();

        if (usertype.trim() == "") {
            callToolTip231('apiname', 'show');
        }
        else {
            callToolTip231('apiname', 'hide');
        }
    });
    $('#apiname').on('focus', function() {
        callToolTip231('apiname', 'destroy');
    });
    $('#cname1').on('focusout', function() {
        var usertype = $('#cname1').val();

        if (usertype.trim() == "") {
            callToolTip231('cname1', 'show');
        }
        else {
            callToolTip231('cname1', 'hide');
        }
    });
    $('#cname1').on('focus', function() {
        callToolTip231('cname1', 'destroy');
    });
    $('#apiurl').on('focusout', function() {
        var usertype = $('#apiurl').val();

        if (usertype.trim() == "") {
            callToolTip231('apiurl', 'show');
        }
        else {
            callToolTip231('apiurl', 'hide');
        }
    });

    $('#apiurl').on('focus', function() {
        callToolTip231('apiurl', 'destroy');
    });

    $('#uname').on('focusout', function() {
        var usertype = $('#uname').val();

        if (usertype.trim() == "") {
            callToolTip231('uname', 'show');
        }
        else {
            callToolTip231('uname', 'hide');
        }
    });

    $('#uname').on('focus', function() {
        callToolTip231('uname', 'destroy');
    });

    $('#uservalue1').on('focusout', function() {
        var usertype = $('#uservalue1').val();

        if (usertype.trim() == "") {
            callToolTip231('uservalue1', 'show');
        }
        else {
            callToolTip231('uservalue1', 'hide');
        }
    });

    $('#uservalue1').on('focus', function() {
        callToolTip231('uservalue1', 'destroy');
    });

    $('#userpswd').on('focusout', function() {
        var usertype = $('#userpswd').val();

        if (usertype.trim() == "") {
            callToolTip231('userpswd', 'show');
        }
        else {
            callToolTip231('userpswd', 'hide');
        }
    });

    $('#userpswd').on('focus', function() {
        callToolTip231('userpswd', 'destroy');
    });

    $('#pwdvalue1').on('focusout', function() {
        var usertype = $('#firstName').val();

        if (usertype.trim() == "") {
            callToolTip231('pwdvalue1', 'show');
        }
        else {
            callToolTip231('pwdvalue1', 'hide');
        }
    });

    $('#pwdvalue1').on('focus', function() {
        callToolTip231('pwdvalue1', 'destroy');
    });

    $('#userID').on('focusout', function() {
        var usertype = $('#userID').val();

        if (usertype.trim() == "") {
            callToolTip231('userID', 'show');
        }
        else {
            callToolTip231('userID', 'hide');
        }
    });

    $('#userID').on('focus', function() {
        callToolTip231('userID', 'destroy');
    });

    $('#uidvalue').on('focusout', function() {
        var usertype = $('#uidvalue').val();

        if (usertype.trim() == "") {
            callToolTip231('uidvalue', 'show');
        }
        else {
            callToolTip231('uidvalue', 'hide');
        }
    });

    $('#uidvalue').on('focus', function() {
        callToolTip231('uidvalue', 'destroy');
    });

    $('#active4').on('focusout', function() {
        var usertype = $('#active4').val();

        if (usertype.trim() == "-1") {
            callToolTip231('active4', 'show');
        }
        else {
            callToolTip231('active4', 'hide');
        }
    });

    $('#active4').on('focus', function() {
        callToolTip231('active4', 'destroy');
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

    $('#cname').on('focus', function() {
        callToolTip231('cname', 'destroy');
    });

    $('#text1').on('focusout', function() {
        var usertype = $('#text1').val();

        if (usertype.trim() == "") {
            callToolTip231('text1', 'show');
        }
        else {
            callToolTip231('text1', 'hide');
        }
    });
    $('#text1').on('focus', function() {
        callToolTip231('text1', 'destroy');
    });

    $('#message').on('focusout', function() {
        var usertype = $('#message').val();

        if (usertype.trim() == "") {
            callToolTip231('message', 'show');
        }
        else {
            callToolTip231('message', 'hide');
        }
    });
    $('#message').on('focus', function() {
        callToolTip231('message', 'destroy');
    });

    $('#contact').on('focusout', function() {
        var usertype = $('#contact').val();

        if (usertype.trim() == "") {
            callToolTip231('contact', 'show');
        }
        else {
            callToolTip231('contact', 'hide');
        }
    });
    $('#contact').on('focus', function() {
        callToolTip231('contact', 'destroy');
    });


    $("#resetbtnSMS").click(function () {

        callToolTip231('apiname', 'hide');
        $('#apiname').val("");
        callToolTip231('cname1', 'hide');
        $('#cname1').val("");
        callToolTip231('apiurl', 'hide');
        $('#apiurl').val("");
        
        callToolTip231('uname', 'hide');
        $('#uname').val("");
        
        callToolTip231('uservalue1', 'hide');
        $('#uservalue1').val("");
        
        callToolTip231('userpswd', 'hide');
        $('#userpswd').val("");
        
        callToolTip231('pwdvalue1', 'hide');
        $('#pwdvalue1').val("");
        
        callToolTip231('userID', 'hide');
        $('#userID').val("");
        
        callToolTip231('uidvalue', 'hide');
        $('#uidvalue').val("");
        
        callToolTip231('active4', 'hide');
        $('#active4').val("");
        
        callToolTip231('cname', 'hide');
        $('#cname').val("");
        
        callToolTip231('text1', 'hide');
        $('#text1').val("");
        
        callToolTip231('message', 'hide');
        $('#message').val("");
        
        callToolTip231('contact', 'hide');
        $('#contact').val("");
        
        var x = document.getElementById("other1");
        var y = document.getElementById("other2");
        var z = document.getElementById("other3");
        var a = document.getElementById("other4");
        var b = document.getElementById("other5");
           
        x.style.display = "none";
        y.style.display = "none";
        z.style.display = "none";
        a.style.display = "none";
        b.style.display = "none";  
          
    });





                   