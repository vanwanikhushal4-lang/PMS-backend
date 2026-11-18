window.onload=function()
{

	
	$(".setscope").multiselect({
		includeSelectAllOption : true,
		buttonWidth : '100%',
		enableFiltering : true,
		enableCaseInsensitiveFiltering : true,
		maxHeight : 200

	});
	
	
 
//   $('#fname').focus();
   var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
        async: false,
      success: function(data4) {

                 var html = "  <option value=''> -- Please Select --</option>";
                 for (var i = 0; i < data4.length; i++) {
//                     //////alert(data4[i]);
                     html += '<option value="' + data4[i] + '">' + data4[i]
                             + '</option>';
                 }

                  
                   document.getElementById("cnameupdate").innerHTML = html;
          }

          
  });
	////////alert("hii")
	   var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/getUserList";
//	     var serviceUrl = "addEnggDetails";
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
	         success: function(data4) {
	        	// //////alert(data4);
	        $("#preLoader").hide();
	        	$("#datatype").removeClass("d-none");
	             var table = $('#datatype').DataTable({
	                 lengthChange: false,
	                 data: data4,
	                 scrollX: true,
	                  "pageLength": 5,
	                  "ordering": false,
	                  initComplete: function() {
	                      $(this.api().table().container()).find('input[type="search"]').parent().wrap('<form>').parent().attr('autocomplete','off').css('overflow','hidden').css('margin','auto');
	                  }  
	             });

	             table.buttons().container()
	                     .appendTo('#datatype_wrapper .col-sm-6:eq(0)');

	         }

	     });
}
function getlocationUpdated(event){
	 var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getLocationForLoginMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
            data: 'companyname=' + encodeURIComponent(event),
             async: false,
         success: function(data4) {

                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        //////alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("locationupdate").innerHTML = html;
             }  
     });
     
     var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getCategoryForLoginMaster";
      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          data: 'companyname=' + encodeURIComponent(event),
           async: false,
          success: function(data4) {

                     var html = " <select class='form-control ' tabindex='8' data-toogle='tooltip' multiple='multiple'  name='updatecategoryMulti' id='updatecategoryMulti'> ";
                     for (var i = 0; i < data4.length; i++) {

                         html += '<option value="' + data4[i] + '">' + data4[i]
                                 + '</option>';
                     }
             html += "</select>";
             
                     document.getElementById("updatecategoryDiv").innerHTML = html;
                      
              }       
      });  
      
       $("#updatecategoryMulti").multiselect({
         includeSelectAllOption: true,
         buttonWidth: '100%',
         enableFiltering: true,
         maxHeight: 200,
         enableCaseInsensitiveFiltering: true,
         
        
     });
     
     
 	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getGroupForLoginMaster";
      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          data: 'companyname=' + encodeURIComponent(event),
       
           async: false,
          success: function(data4) {


                     var html = " <select class='form-control ' tabindex='8' data-toogle='tooltip' multiple='multiple'  name='updategroupMulti' id='updategroupMulti'> ";
                     for (var i = 0; i < data4.length; i++) {

                         html += '<option value="' + data4[i] + '">' + data4[i]
                                 + '</option>';
                     }
             html += "</select>";
                
                     document.getElementById("groupDivserupdate").innerHTML = html;
                      
              }

              
      });
      
      
      var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getGroupForLoginMaster";
       $.ajax({
           type: 'POST',
           url: serviceUrl,
           dataType: 'json',
           data: 'companyname=' + encodeURIComponent(event),
            async: false,
           success: function(data4) {
                      var html = " <select class='form-control ' tabindex='8' data-toogle='tooltip' multiple='multiple'  name='groupMultiserupdate' id='groupMultiserupdate'> ";
                      for (var i = 0; i < data4.length; i++) {

                          html += '<option value="' + data4[i] + '">' + data4[i]
                                  + '</option>';
                      }
              html += "</select>";
                 
                      document.getElementById("groupDivserupdate").innerHTML = html;
                       
               }

               
       });
      // grouP for   eng

   	var l = window.location;
   		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   		var serviceUrl = base_url + "/Master/getGroupForLoginMasterAll";
   	 $.ajax({
   	     type: 'POST',
   	     url: serviceUrl,
   	     dataType: 'json',
   	      async: false,
   	     success: function(data4) {

   	    	// //////alert(data4)
   	                var html = " <select class='form-control ' tabindex='8' data-toogle='tooltip' multiple='multiple'  name='updategroupMulti' id='updategroupMulti'> ";
   	                for (var i = 0; i < data4.length; i++) {

   	                    html += '<option value="' + data4[i] + '">' + data4[i]
   	                            + '</option>';
   	                }
   	        html += "</select>";
   	           
   	                document.getElementById("updategroupDiv").innerHTML = html;
   	                
   	                
   	                
   	                 
   	         }

   	 
   	         
   	 });
   	 
       
     
       $("#updategroupMulti").multiselect({
         includeSelectAllOption: true,
         buttonWidth: '100%',
         enableFiltering: true,
         maxHeight: 200,
         enableCaseInsensitiveFiltering: true
        
     });
     
       $("#groupMultiserupdate").multiselect({
           includeSelectAllOption: true,
           buttonWidth: '100%',
           enableFiltering: true,
           enableCaseInsensitiveFiltering: true,
           maxHeight: 200
          
       });
  
 }
  $("#updategroupMulti").multiselect({
      includeSelectAllOption: true,
      buttonWidth: '100%',
      enableFiltering: true,
      enableCaseInsensitiveFiltering: true,
      maxHeight: 200
      
     
  });
  

 function getDesignationUpdate(company) {
 //  //////alert(company);
   var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/getDesignationForLoginMaster";
   
   $.ajax({
       type: 'POST',
       url: serviceUrl,
       dataType: 'json',
       data: 'company=' + encodeURIComponent(company),
       async: false,
       success: function(data) {
                  var html;
                  html = "<option value=''> -- Please Select --</option>";
                  for (var i = 0; i < data.length; i++) {
  //                    //////alert(data4[i]);
                      html += '<option value="' + data[i] + '">' + data[i]
                              + '</option>';
                  }
  
                  document.getElementById("designationUpdate").innerHTML = html;
           }
  
           
   });
	
}
 
function getSiteDetailsupdateEngg(event) {
 // //////alert("HII comp"+$("#cnameupdate").val());
   // //////alert(event)
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/getBranchForLoginMastersInsert";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + encodeURIComponent($("#cnameupdate").val())+'&location=' + encodeURIComponent(event),
          async: false,
         success: function(data4) {
        	// //////alert(data4)
                    var html = "<option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        //////alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("snameupdate").innerHTML = html;
             }

             
     });
     
     
     
     
     
 	
}


function getDepartmentUpdate() {
 
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getDepartmentForLoginMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + encodeURIComponent($("#cnameupdate").val())+ '&branchName=' + encodeURIComponent($("#snameupdate").val())+ '&location=' + encodeURIComponent($("#locationupdate").val()),
          async: false,
         success: function(data4) {
//             //////alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        //////alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("dnameupdate").innerHTML = html;
             }

             
     });
    
}


function setLevelScopeUpdate(){
	
	 document.getElementById("servicerequestcheckboxupdate").style.display = "none";
	 document.getElementById("parentsservicerequest").style.display = "none";
	 
	
		  callToolTip231update('visibilityupdate', 'destroy');
		

	
		callToolTip231update('groupDivserupdate', 'destroy');
	

	////////alert("setLevelScope");
	
	var role=$("#rtypeupdate").val();
	
	if(role.includes("Engineer")){
		document.getElementById("updategroupCatDiv1").style.display = "block";
		  document.getElementById("updategroupCatDiv2").style.display = "block";
	
		
	}else if(role.includes("Ticket Co-ordinator"))
		{
		document.getElementById("parentsservicerequest").style.display = "block";
		 document.getElementById("servicerequestcheckboxupdate").style.display = "block";
		 document.getElementById("updategroupCatDiv1").style.display = "none";
		 document.getElementById("updategroupCatDiv2").style.display = "none";
		}
	else {
		 document.getElementById("updategroupCatDiv1").style.display = "none";
		 document.getElementById("updategroupCatDiv2").style.display = "none";
		}
	
	
	if(role.includes("Admin") || role.includes("User")){
		
		
		} else {
			
			
			}
	
	
}



 function getSubDepartmentUpdate(){
	 var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getSubDepartmentForLoginMaster";
    
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
            data: 'companyname=' + encodeURIComponent($("#cnameupdate").val())+ '&branchName=' + encodeURIComponent($("#snameupdate").val())+ '&departmentName=' + encodeURIComponent($("#dnameupdate").val())+ '&location=' + encodeURIComponent($("#locationupdate").val()),
             async: false,
         success: function(data4) {
//             //////alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        //////alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }

                    document.getElementById("subdnameupdate").innerHTML = html;
               
             }

             
     });
     
}


//function validateEmailupdate() {
//    var ret = true;
//    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
//    //("email:"+.value)
//    var emailField = $('#mailupdate').val();
////    ('check email:' + reg.test($('#mail').val()))
//    if (reg.test(emailField) == false)
//    {
//        //callToolTipWrong('email', 'show');
//        ret = false;
//    }
//    else
//    {
//        ret = true;
//    }
//    return ret;
//}
//
//function phonenumberupdate() {
//    var inputtxt = $('#cnoupdate').val();
//    (inputtxt)
//    var phoneno = /^\d{10}$/;
////  var phoneno = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
//    if (inputtxt.match(phoneno))
//    {
//        return true;
//    }
//    else
//    {
//        callToolTipWrongupdate('phnnnoupdate', 'show');
//        return false;
//    }
//}

function checkPassstrengthupdate() {
    var pass = $('#passupdate').val();
    var ret = true;
    ;
    // //////alert(pass)
    var specailcharatcers = "!#$%&'()*+,-./:;<=>?@[\]^_`{|}~";
    var passwordscore = 0;
    $('#noteupdate').show();
//    for (var i = 0; i < pass.length; i++)
//    {
//        if (specailcharatcers.indexOf(pass.charAt(i)) > -1)
//        {
//            passwordscore += 20;
//        }
//    }
var charcount=0;
 for (var i = 0; i < pass.length; i++)
    {
        
        if (specailcharatcers.indexOf(pass.charAt(i)) > -1)
        {
//            passwordscore += 20;
        charcount=charcount+1;
//        //////alert(charcount);
        }
    }
    if(charcount>=3 ||charcount<=0)
    {
//        //////alert("in false")
    }
    else{
        passwordscore += 20;
    }

    if (/[a-z]/.test(pass))
    {
        ('inside lowercase')
        passwordscore += 20;
    }
    if (/[A-Z]/.test(pass))
    {
        ('inside uppercase')
        passwordscore += 20;
    }
    if (/[\d]/.test(pass))
    {
        ('inside numbers')
        passwordscore += 20;
    }
    if (pass.length >= 7)
    {
        ('inside length')
        passwordscore += 20;
    }
    ////////alert(passwordscore)
    var strength = "Weak";
    if (passwordscore >= 100)
    {
        strength = "Strong";
    }
    else if (passwordscore >= 80)
    {
        strength = "Medium";
    }
    else if (passwordscore >= 60)
    {
        strength = "Weak";
    }

    ////////alert('strength now:'+strength)
    document.getElementById('labelupdate').innerHTML = strength;
    $('#labelupdate').show();
    if (strength === "Strong")
    {
        document.getElementById('labelupdate').style.color = "green";
        $('#noteupdate').hide()
    }
    else if (strength === "Medium")
    {
        document.getElementById('labelupdate').style.color = "yellow";
         $('#noteupdate').show()
    }
    else if (strength === "Weak")
    {
        document.getElementById('labelupdate').style.color = "red";
         $('#noteupdate').show()
    }

    if (strength === "Strong")
    {
        callToolTipUpdate1update('labelupdate', 'destroy');
        ret = true;
        $('#noteupdate').hide()
    }
    else
    {
        //callToolTipUpdate1('label', 'show');
        ret = false;

    }
    return ret;
}






var customupdateTooltip = function(id,fieldName, status) {
	////////alert("inside customTooltip:-"+id+fieldName+status)
	if (fieldName == "company") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select company <span>";
    } else if (fieldName == "branch") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Branch<span>";
    }
	else if (fieldName == "dept") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Department<span>";
    }
	
	
	
    $("#" + id).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });

    if (status == "show") {
////////alert("show:-"+id)
        $("#" + id).tooltip('show');

    } else {
        $("#" + id).tooltip('hide');
    }

	
	
	
	
	}



function validateAddEnggupdate() {
    var indexError = 0;
    var alphaExp = /^[a-zA-Z '.-]+$/;
    
    
    
    
    callToolTip231update('englevelupdate', 'hide');
    
    
var role=$("#rtypeupdate").val();





if(role.includes("Engineer") ){
	
	
	
    var updatecategoryMultiselectedValues = [];
	$("#updatecategoryMulti :selected").each(function() {
		updatecategoryMultiselectedValues.push($(this).val());
	});
	
	if (updatecategoryMultiselectedValues.toString() === '') {
		//callToolTippatch('oemdiv', 'show');
		  callToolTip231update('updatecategoryDiv', 'show');
		if (indexError == 0) {
		}
		indexError = indexError + 1;
		("In updatecategoryMulti: "+indexError);
	} else{
		
		  callToolTip231update('updatecategoryDiv', 'hide');
	}
	
	
	
	
	 var updategroupMultiselectedValues1 = [];
	$("#updategroupMulti :selected").each(function() {
		updategroupMultiselectedValues1.push($(this).val());
	});
	if (updategroupMultiselectedValues1.toString() === '') {
		//callToolTippatch('oemdiv', 'show');
		  callToolTip231update('updategroupDiv', 'show');
		if (indexError == 0) {
		}
		indexError = indexError + 1;
		("In updategroupDiv: "+indexError);
	} else{
		
		  callToolTip231update('updategroupDiv', 'hide');
	}
	
	
} else{
	
	 callToolTip231update('updatecategoryDiv', 'hide');
	 callToolTip231update('updategroupDiv', 'hide');
}









if(role.includes("Admin") || role.includes("User")){
	
	} else if(role.includes("Engineer") || role.includes("IT-Head") || role.includes("Ticket Co-ordinator") ) {
   
	
	 if ($('#englevelupdate').val().trim() === '') {
         callToolTip231update('englevelupdate', 'show');
         if (indexError == 0) {

         }
         indexError = indexError + 1;
         ("In englevelupdate: "+indexError);
     }
	
	
    
   // //////alert("counter:-"+counter)
    
   for(s=0;s<counterupdate;s++){
	
	
	//var id='perifheraltype'+s;
	////////alert("id"+id)
	var id='company'+s;
	 if ($('#company'+s).val() === '') {
		
        customupdateTooltip(id,'company', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        ("In updateTable Company: "+indexError);
    }else{
	
	  customupdateTooltip(id,'company', 'hide');
	
    }
    
    var branchID='updatetableBranch'+s;
     var branchDiv='updatetableBranchDiv'+s;
    var selectedValues = [];
	$("#"+branchID+" :selected").each(function() {
		selectedValues.push($(this).val());
	});
	if (selectedValues.toString() === '') {
		//callToolTippatch('oemdiv', 'show');
		 customupdateTooltip(branchDiv,'branch', 'show');
		if (indexError == 0) {
		}
		indexError = indexError + 1;
		("In updateTable Branch: "+indexError);
	} else{
		
		customupdateTooltip(branchDiv,'branch', 'hide');
	}
   
   
   
    var deptID='updateTableDepartment'+s;
     var deptDiv='updateTableDepartmentDiv'+s;
    var selectedValues1 = [];
	$("#"+deptID+" :selected").each(function() {
		selectedValues1.push($(this).val());
	});
	
	if (selectedValues1.toString() === '') {
		//callToolTippatch('oemdiv', 'show');
		 customupdateTooltip(deptDiv,'dept', 'show');
		if (indexError == 0) {
		}
		
		indexError = indexError + 1;
		  ("In updateTable dept: "+indexError);
	} else{
		
		customupdateTooltip(deptDiv,'dept', 'hide');
	}
	
	
	
   }

    if ($('#mailupdate').val().trim() === '') {
        
        callToolTip231update('mailupdate', 'show');
        if (indexError == 0) {

        }
        ("In mailupdate"+indexError);
        indexError = indexError + 1;
    }
    
 if ($('#cnoupdate').val().trim() === '') {
        
        callToolTip231update('cnoupdate', 'show');
        if (indexError == 0) {

        }
        ("In cnoupdate"+indexError);
        indexError = indexError + 1;
    }
	}
//    else if (!validateEmailupdate())
//    {
////        ('inside invalid email')
//        callToolTipUpdate('emailupdate', 'show');
//        indexError = indexError + 1;
//         ("In validateEmail: "+indexError);
//    }
   /* if ($('#cnoupdate').val().trim() === '') {
        callToolTip231update('cnoupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        ("In cnoupdate: "+indexError);
    }
    else if (!phonenumberupdate())
    {
//        ('inside invalid contact number')
        //callToolTipWrong('phnno', 'show');
        indexError = indexError + 1;
         ("In invalid contact number: "+indexError);

    }*/
    
    
    if ($('#fnameupdate').val().trim() === '') {
        callToolTip231update('fnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         ("In update: "+indexError);
    }
    else if (!$('#fnameupdate').val().trim().match(alphaExp))
    {
        callToolTip231update('fnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         ("In fnamematchupdate: "+indexError);
    }
    if ($('#lnameupdate').val().trim() === '') {
        callToolTip231update('lnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         ("In lnameupdate: "+indexError);
    }
    else if (!$('#lnameupdate').val().trim().match(alphaExp))
    {
        callToolTip231update('lnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         ("In lnamematch update: "+indexError);
    }
/*
    if ($('#passupdate').val().trim() === '') {
        callToolTip231update('passupdate', 'show');
        callToolTipUpdate1update('labelupdate', 'hide');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
         ("In passupdate: "+indexError);

    }

    if ($('#Cpassupdate').val().trim() === '') {
        callToolTip231update('Cpassupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        ("In Cpassupdate: "+indexError);
    }

    if (!($('#Cpassupdate').val().trim() === '' && $('#passupdate').val().trim() === '')) {
        if (!checkPassupdate())
        {
            indexError = indexError + 1;
            ("In passupdate compare: "+indexError);
        }

    }

    if (!checkPassstrengthupdate() && $('#passupdate').val().trim() !== '')
    {

        callToolTipUpdate1update('labelupdate', 'show');
        indexError = indexError + 1;
        ("In checkPassstrengthupdate: "+indexError);
    }*/

//    if ($('#type').val() === '') {
//        callToolTip231update('type', 'show');
//        if (indexError == 0) {
//
//        }
//        indexError = indexError + 1;
//        ("In type: "+indexError);
//    }
     if ($('#cnameupdate').val().trim() === '') {
        callToolTip231update('cnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        ("In cnameupdate: "+indexError);
    }
     if ($('#snameupdate').val().trim() === '') {
        callToolTip231update('snameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        ("In snameupdate: "+indexError);
    }
     if ($('#dnameupdate').val().trim() === '') {
        callToolTip231update('dnameupdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
        ("In dnameupdate: "+indexError);
    }
     if ($('#designationUpdate').val().trim() === '') {
         callToolTip231update('designationUpdate', 'show');
         if (indexError == 0) {
  
         }
         indexError = indexError + 1;
         ("In dnameupdate: "+indexError);
     }
     if ($('#subdnameupdate').val().trim() === '') {
         callToolTip231update('subdnameupdate', 'show');
         if (indexError == 0) {
  
         }
         indexError = indexError + 1;
         ("In subdnameupdate: "+indexError);
     }
     
     
   //  //////alert($('#visibilityupdate').val() );
    
     if (($('#visibilityupdate').val() == '' || $('#visibilityupdate').val() == null )  && ( $("#rtypeupdate").val() == 'Ticket Co-ordinator' )) {
         callToolTip231update('visibilityupdate', 'show');
         if (indexError == 0) {
  
         }
         indexError = indexError + 1;
         ("In visibilityupdate: "+indexError);
     }
     var selectedValues1update = [];
     $("#groupDivserupdate :selected").each(function() {
    	 selectedValues1update.push($(this).val());
     });

     if (selectedValues1update.toString() === '' && $("#rtypeupdate").val() == 'Ticket Co-ordinator') {
    	 callToolTip231update('groupDivserupdate', 'show');
         indexError = indexError + 1;
     }
      
     
   
    if (indexError > 0) {
//        //////alert("false")
        return false;

    } else {
//        //////alert("true")
        return true;
    }
}

var callToolTip231update = function(fieldName, status) {

     if (fieldName == "passupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password<span>";
    }
    else if (fieldName == "Cpassupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Confirm Password<span>";
    }
    else if (fieldName == "subdnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Department<span>";
    }
    else if (fieldName == "passupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password<span>";
    }
    else if (fieldName == "fnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct First Name<span>";
    }
    
    else if (fieldName == "lnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Last Name<span>";
    }
    
    
    else if (fieldName == "mailupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Email-ID<span>";
    }
    else if (fieldName == "cnoupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Contact Number<span>";
    }

    else if (fieldName == "typeupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Type<span>";
    } else if (fieldName == "passnotmatchupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Password Not Matched!<span>";
    }
    else if (fieldName == "passwresetupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Password<span>";
    }

    else if (fieldName == "cpassresetupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Confirm Password<span>";
    }
    else if (fieldName == "cpassresetupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Confirm Password<span>";
    }
    else if (fieldName == "cnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Company Name<span>";
    }
    else if (fieldName == "snameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select Site Name<span>";
    }
    else if (fieldName == "dnameupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Department Name<span>";
    }
   
    else if (fieldName == "englevelupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select  Level<span>";
    } else if (fieldName == "updatecategoryDiv") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select  Category<span>";
    } else if (fieldName == "updategroupDiv") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Select  Group<span>";
    } else if (fieldName == "designationUpdate") {
        var errorMessage = "<span>Please Select Designation<span>";;
    }
    else if (fieldName == "visibilityupdate") {
        var errorMessage = "<span>Please Select Visibility<span>";;
    }
    else if (fieldName == "groupDivserupdate") {
        var errorMessage = "<span>Please Select Group<span>";;
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

$('#fnameupdate').on('focusout', function() {
    var usertype = $('#fnameupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('fnameupdate', 'show');
    }
    else {
        callToolTip231update('fnameupdate', 'hide');
    }
});
$('#password').on('focusout', function() {
    var usertype = $('#password').val();

    if (usertype.trim() == "") {
    	callToolTipUpdate1123('password', 'show');
    }
    else {
    	callToolTipUpdate1123('password', 'hide');
    }
});
$('#confirmPassword').on('focusout', function() {
    var usertype = $('#confirmPassword ').val();

    if (usertype.trim() == "") {
    	callToolTipUpdate1123('confirmPassword', 'show');
    }
    else {
    	callToolTipUpdate1123('confirmPassword', 'hide');
    }
});
$('#lnameupdate').on('focusout', function() {
    var usertype = $('#lnameupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('lnameupdate', 'show');
    }
    else {
        callToolTip231update('lnameupdate', 'hide');
    }
});

$('#passupdate').on('focusout', function() {
    var usertype = $('#passupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('passupdate', 'show');
    }
    else {
        callToolTip231update('passupdate', 'hide');
    }
});
$('#Cpassupdate').on('focusout', function() {
    var usertype = $('#Cpassupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('Cpassupdate', 'show');
    }
    else {
        callToolTip231update('Cpassupdate', 'hide');
    }
});
$('#cnameupdate').on('focusout', function() {
    var usertype = $('#cnameupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('cnameupdate', 'show');
    }
    else {
    }
});
$('#snameupdate').on('focusout', function() {
    var usertype = $('#snameupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('snameupdate', 'show');
    }
    else {
    }
});
$('#dnameupdate').on('focusout', function() {
    var usertype = $('#dnameupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('dnameupdate', 'show');
    }
    else {
    }
});
$('#mailupdate').on('focusout', function() {
    var usertype = $('#mailupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('mailupdate', 'show');
    }
    else if (!validateEmail())
    {
        ('invali email')
        callToolTipWrongupdate('emailupdate', 'hide');
    }
    else {
        callToolTip231update('mailupdate', 'hide');
    }
});
$('#cnoupdate').on('focusout', function() {
    var usertype = $('#cnoupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('cnoupdate', 'show');
    }
    else {
        callToolTip231update('cnoupdate', 'hide');
    }
});

$('#englevelupdate').on('focusout', function() {
    var usertype = $('#englevelupdate').val();

    if (usertype.trim() == "") {
        callToolTip231update('englevelupdate', 'show');
    }
    else {
        callToolTip231update('englevelupdate', 'hide');
    }
});
$('#designationUpdate').on('focusout', function() {
  var usertype = $('#designationUpdate').val();

  if (usertype.trim() == "") {
      callToolTip231update('designationUpdate', 'show');
  }
  else {
      callToolTip231update('designationUpdate', 'hide');
  }
});

$('#fnameupdate').on('focus', function() {
    callToolTip231update('fnameupdate', 'destroy');
});
$('#lnameupdate').on('focus', function() {
    callToolTip231update('lnameupdate', 'destroy');
});
//$('#mailupdate').on('focus', function() {
//    callToolTipWrongupdate('emailupdate', 'destroy');
//    callToolTip231update('mailupdate', 'destroy');
//});

/*$('#cnoupdate').on('focus', function() {
    callToolTip231update('cnoupdate', 'destroy');
    callToolTipWrongupdate('phnnnoupdate', 'hide');
});*/
$('#typeupdate').on('focus', function() {
    callToolTip231update('typeupdate', 'destroy');
});
$('#subdnameupdate').on('focus', function() {
    callToolTip231update('subdnameupdate', 'destroy');
});
$('#passupdate').on('focus', function() {
    callToolTip231update('passupdate', 'destroy');
});
$('#Cpassupdate').on('focus', function() {
    callToolTip231update('Cpassupdate', 'destroy');
});
$('#cnameupdate').on('focus', function() {
    callToolTip231update('cnameupdate', 'destroy');
});
$('#snameupdate').on('focus', function() {
    callToolTip231update('snameupdate', 'destroy');
});
$('#dnameupdate').on('focus', function() {
    callToolTip231update('dnameupdate', 'destroy');
});

$('#englevelupdate').on('focus', function() {
    callToolTip231update('englevelupdate', 'destroy');
});
$('#designationUpdate').on('focus', function() {
  callToolTip231update('designationUpdate', 'destroy');
});
$('#visibilityupdate').on('focus', function() {
	  callToolTip231update('visibilityupdate', 'destroy');
	});

$('#groupDivserupdate').on('click', function() {
	callToolTip231update('groupDivserupdate', 'destroy');
	});

$('#mailupdate').on('focus', function() {
	  callToolTip231update('mailupdate', 'destroy');
	});

$('#cnoupdate').on('click', function() {
	callToolTip231update('cnoupdate', 'destroy');
	});


var callToolTipUpdate1update = function(fieldName, status) {
    if (fieldName == "labelupdate") {
        var errorMessage = "<span>Password Must contain atleast one number,one lowercase,one uppercase and one special character<span>";
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

var callToolTipWrongupdate = function(fieldName, status) {
    if (fieldName == "emailupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Email ID<span>";
    } else if (fieldName == "phnnnoupdate") {
        var errorMessage = "<span>Please Enter Correct Contact No<span>";
    } else if (fieldName == "emailupdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Please Enter Correct Email ID<span>";
    } else if (fieldName == "cnoupdate") {
        var errorMessage = "<span>Please Enter Correct Contact No<span>";
    }

    else if (fieldName == "passupdate") {
        var errorMessage = "<span>Please Enter Password More then 6 Characters<span>";
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

function checkPassupdate() {
    var ret = true;
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('passupdate');

    var pass2 = document.getElementById('Cpassupdate');

    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessageupdate');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    $('#note1update').hide();
    if (pass1.value === "" && pass2.value === "")
    {
        ret = false;
    }
    else if (pass1.value == pass2.value) {

        pass2.style.backgroundColor = goodColor;


        document.getElementById('note1update').innerHTML = "Passwords matched!";
        document.getElementById('note1update').style.color = "green";
        $('#note1update').show();
        ret = true;
    } else {

        pass2.style.backgroundColor = badColor;
        document.getElementById('note1update').innerHTML = "Passwords do not match!";
        document.getElementById('note1update').style.color = "red";
        $('#note1update').show();

        ret = false;
    }
    return ret;
}


function userScopeForUpdate(ENG_UNAME,E_ID){
	
	
	/*var forLooppp=counterupdate;
	//////alert(forLooppp)
	   for(var b=0;b<=forLooppp;b++){
		 var table = document.getElementById("updateperifheralTable");
   
         table.deleteRow(b);
	      counterupdate -= 1;
	}
	*/
	
	
	////////alert("Hii:"+ENG_UNAME)
	var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	var serviceUrl = base_url + "/Master/getUserScopeForUpadte";
    	$.ajax({
    		url : serviceUrl,
    		type : 'post', 
    		 dataType: 'json',  		
    		data:'username='+ENG_UNAME+
    		'&E_id='+E_ID,
    		
    		  async: false,
           
    		}).done(function (data) {
	
	var jsonArray=data;
	////////alert("jsonArray:-"+jsonArray.length)
	for(var j=0;j<jsonArray.length;j++){
		
		var company1= data[j]["COMPANY"];
		////////alert("company "+company1)
		var BRANCH= data[j]["BRANCH"];
		////////alert("BRANCH "+BRANCH)
		var DEPARTMENT= data[j]["DEPARTMENT"];
		////////alert("DEPARTMENT "+DEPARTMENT)
										var newRow = $("<tr>");
										var cols = "";

										
										cols += '<td class="form-group adjust"><select class="form-control " tabindex="6" data-toogle="tooltip"  onchange="getUpdateBranchDetails(\''+counterupdate+'\')" name="company[]" id="company'
												+ counterupdate + '"></select></td>';
										cols += '<td class="form-group adjust"><div class="form-group" id="updatetableBranchDiv'+ counterupdate + '"><select class="form-control customMulti" tabindex="6" data-toogle="tooltip" multiple="multiple" onchange="getUpdateDepart(\''+counterupdate+'\')" name="updatetableBranch[]" id="updatetableBranch'
												+ counterupdate + '"></select></div></td>';
										cols += '<td class="form-group adjust"><div class="form-group" id="updateTableDepartmentDiv'+ counterupdate + '"><select class="form-control customMulti" tabindex="6" data-toogle="tooltip"  multiple="multiple" name="updateTableDepartment[]" id="updateTableDepartment'
												+ counterupdate + '"></select></div></td>';
										

										/*cols += '<td><button class="ibtnDel1 btn btn-md btn-danger fa fa-close">Remove</button></td>';*/

										newRow.append(cols);
										$("table.order-list1").append(newRow);
										counterupdate++;
										
									
	
										
										
  var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
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


                    var count=counterupdate-1;

                    document.getElementById("company"+count).innerHTML = html;
                   
             }

             
     })
     var count1=counterupdate-1;
     
     //$("#company"+count1).val(company);
     
  var iddd="company"+count1;
      let element = document.getElementById(iddd);
    element.value = company1;
 
    
    
 //   $("#company"+count1).val(company1);
    
     ("count1 Value: "+count1+" company:"+company1);
     ("count1: "+$("#company"+count1).val());
   //   ("count0: "+$("#company0").val());
     getUpdateBranchDetails(count1);
     
     
     var selectedOptions = BRANCH.split(",");
   for(var k=0;k<selectedOptions.length;k++) {
	
	
	   $("#updatetableBranch"+count1).find("option[value='" + selectedOptions[k] + "']").prop("selected", true)
       $("#updatetableBranch"+count1).multiselect("refresh")
  
     }

     
     getUpdateDepart(count1);
     
      var selectedOptions1 = DEPARTMENT.split(",");
   for(var m=0;m<selectedOptions1.length;m++) {
	 $("#updateTableDepartment"+count1).find("option[value='" + selectedOptions1[m] + "']").prop("selected", true)
     $("#updateTableDepartment"+count1).multiselect("refresh")
  
     }
     
     
     
     
     
     
      $(".customMulti").multiselect({
        includeSelectAllOption: true,
        buttonWidth: '100%',
        enableFiltering: true,
        enableCaseInsensitiveFiltering: true,
        maxHeight: 200
       
    });
     
}
	
	
 });
	
}

var role1=null;

function Editengineer(E_ID,ENG_UNAME,E_NAME,E_COMPANY,E_BRANCH,E_DEPARTMENT,designation,location,role,E_PHONE,E_MAIL,E_CATEGORY,ENGLEVEL,Password,VIPLogin,sidebar,visibility) {

	
	//alert("hhh"+designation)
	var allscopetemp=sidebar.toString();
	var allscope = allscopetemp.split(",");

	var options = allscope;
	
	
	  options.forEach(function(e){
		  if(e != '') {
		       $(".setscopeDashboard option[value="+e+"]").attr("selected", "selected");
		       $(".setscope option[value="+e+"]").attr("selected", "selected");
		  }
	  });
	  
	  $('#nodereports').multiselect({
			enableFiltering : true,
			includeSelectAllOption : true,
			buttonWidth : '100%',
		});
	  
	  $('#ViewUserList').multiselect({
			enableFiltering : true,
			includeSelectAllOption : true,
			buttonWidth : '100%',
	}); 
		$('#Dashboards').multiselect({
			enableFiltering : true,
			includeSelectAllOption : true,
			buttonWidth : '100%',
		});
			
			$('#nodehealth').multiselect({
			enableFiltering : true,
			includeSelectAllOption : true,
			buttonWidth : '100%',
		});
			$('#interfacereports').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});
			$('#graphs').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});
			
			$('#Interface_Inventory').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});
			
			
			
			$('#masters').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});
			$('#home').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});
			$('#ViewUserList').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});
			$('#admin').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});
			$('#node').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});
			$('#reflectchanges').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});
			$('#configmgmt').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});
			$('#IP_ScanModel1').multiselect({
				enableFiltering : true,
				includeSelectAllOption : true,
				buttonWidth : '100%',
		});


	role1=role;
/*  var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/LoginMaster";
*/
	
   
//	//////alert()
var NameArray= E_NAME.split(' ');
var Firstname=NameArray[0];
var Lastname=NameArray[1];
////////alert("location: " + location);
////////alert("E_BRANCH: " + E_BRANCH);

 

$("#fnameupdate").val(Firstname);
$("#lnameupdate").val(Lastname);
$("#userupdate").val(ENG_UNAME);
$("#passupdate").val(Password);
$("#Cpassupdate").val(Password);
//$("#cnameupdate").val(COMPANY);
//$("#snameupdate").val(BRANCH_NAME);


if(($("#cnameupdate option[value='"+E_COMPANY+"']").length > 0)===true){
	$("#cnameupdate").val(E_COMPANY);
	
	
	getDesignationUpdate(E_COMPANY);
	getlocationUpdated(E_COMPANY);
	
}else{
	$("#cnameupdate").val("");
}


if(($("#designationUpdate option[value='"+designation+"']").length > 0)===true){
  $("#designationUpdate").val(designation);
  
}else{
  $("#designationUpdate").val("");
}


if(($("#locationupdate option[value='"+location+"']").length > 0)===true){
	////////alert("location if"+location);
	$("#locationupdate").val(location);
	getSiteDetailsupdateEngg(location);
	
}else{
	
	////////alert("location else")
	$("#locationupdate").val("");
}
if(($("#snameupdate option[value='"+E_BRANCH+"']").length > 0)===true){
	$("#snameupdate").val(E_BRANCH);
	getDepartmentUpdate();
	////////alert("E_BRANCH if");
}else{
//	document.getElementById("snameupdate").value = E_BRANCH;
	$("#snameupdate").val("");
	////////alert("E_BRANCH else");
}



if(($("#dnameupdate option[value='"+E_DEPARTMENT+"']").length > 0)===true){
	$("#dnameupdate").val(E_DEPARTMENT);
	getSubDepartmentUpdate()
}else{
	
	$("#dnameupdate").val("");
}


if(($("#subdnameupdate option[value='"+E_CATEGORY+"']").length > 0)===true){
	$("#subdnameupdate").val(E_CATEGORY);
}else{
	$("#subdnameupdate").val("");
}



if(($("#rtypeupdate option[value='"+role+"']").length > 0)===true){
	$("#rtypeupdate").val(role);
}else{
	$("#rtypeupdate").val("");
}

////////alert("ENGLEVEL:"+ENGLEVEL)
if(role.includes("Admin") || role.includes("User")){
		
	} else if(role.includes("Engineer") || role.includes("IT-Head") || role.includes("Ticket Co-ordinator") ) {
		
			 
			 if( role.includes("Ticket Co-ordinator"))
				{
			//	//////alert("Ticket Co-ordinator");
				 document.getElementById("parentsservicerequest").style.display = "block";
				 document.getElementById("servicerequestcheckboxupdate").style.display = "block";
				/*	$('#servicerequestcheckboxupdate').prop('checked', true); */
					$("#visibilityupdate").val(visibility);
				
				}
		
		
		} 



$("#mailupdate").val(E_MAIL);
$("#cnoupdate").val(E_PHONE);

//$("#englevelupdate").val(ENGLEVEL);
$("#sr_no").val(E_ID);

///////tooltips to hide/////
//callToolTip231('cname', 'hide');
//callToolTip231('sname', 'hide');
//callToolTip231('dname', 'hide');
///callToolTip231('fname', 'hide');
//callToolTip231('lname', 'hide');
//callToolTip231('mail', 'hide');
//callToolTipWrong('email', 'hide');
//callToolTip231('cno', 'hide');
//callToolTip231('user', 'hide');
//callToolTip231('pass', 'hide');
//callToolTip231('Cpass', 'hide');
//callToolTip231('category', 'hide');
//callToolTipUpdate1('label', 'hide');
//callToolTipWrong('phnnno', 'hide');
//callToolTip231('fname1', 'hide');
//callToolTip231('lname1', 'hide');
//callToolTip231('user1', 'hide');



userScopeForUpdate(ENG_UNAME,E_ID);

    

    
    

if(role.includes("Engineer") ){

	
	

	var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getGroupForLoginMasterAll";
	 $.ajax({
	     type: 'POST',
	     url: serviceUrl,
	     dataType: 'json',
	      async: false,
	     success: function(data4) {

	    	// //////alert(data4)
	                var html = " <select class='form-control ' tabindex='8' data-toogle='tooltip' multiple='multiple'  name='updategroupMulti' id='updategroupMulti'> ";
	                for (var i = 0; i < data4.length; i++) {

	                    html += '<option value="' + data4[i] + '">' + data4[i]
	                            + '</option>';
	                }
	        html += "</select>";
	           
	                document.getElementById("updategroupDiv").innerHTML = html;
	                
	                
	                
	                 
	         }

	 
	         
	 });
	 
     $("#updategroupMulti").multiselect({
         includeSelectAllOption: true,
         buttonWidth: '100%',
         enableFiltering: true,
         enableCaseInsensitiveFiltering: true,
         maxHeight: 200
        
     });  	
	
     document.getElementById("updategroupCatDiv1").style.display = "block";
		  document.getElementById("updategroupCatDiv2").style.display = "block";
    
    
    setCategoryScope(ENG_UNAME,E_COMPANY);
    setGroupScope(ENG_UNAME,E_COMPANY);
    
      
     
}
else if(role.includes("Ticket Co-ordinator"))
	{
	 setGroupScope(ENG_UNAME,E_COMPANY);
	}
else {
	
	
	 document.getElementById("updategroupCatDiv1").style.display = "none";
		 document.getElementById("updategroupCatDiv2").style.display = "none";
}

    $("#modeleditengg").modal("show");
}

function setGroupScope(ENG_UNAME,E_COMPANY){
	
 ////////alert("check  " + E_COMPANY);
	
    
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getGroupForPerticularUserforticket";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
      data:'username='+encodeURIComponent(ENG_UNAME)
      
      +'&company2='+encodeURIComponent(E_COMPANY),
          async: false,
         success: function(data4) {
          //   //////alert(data4)
	var GROUPNAME= data4[0]["GROUP_NAME"];
        //  //////alert("MAIN: "+GROUPNAME)    
      var selectedOptions123 = GROUPNAME.split(",");
   for(var m=0;m<selectedOptions123.length;m++) {
	////////alert("LOOP: "+selectedOptions123[m])
	//var replaced = selectedOptions123[m] .replace(' ','-');
	  
	if(role1.includes("Engineer"))
		{
			////////alert("Engineer  " + role1);
			$("#updategroupMulti").find("option[value='" + selectedOptions123[m]+ "']").prop("selected", true)
			$("#updategroupMulti").multiselect("refresh")
		}

  
     }   
             }
 
     });
     
     $("#updategroupMulti").multiselect({
         includeSelectAllOption: true,
         buttonWidth: '100%',
         enableFiltering: true,
         maxHeight: 200
        
     });  
     

 	var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/getGroupForPerticularUser";
      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
       data:'username='+encodeURIComponent(ENG_UNAME)
       
       +'&company2='+encodeURIComponent(E_COMPANY),
           async: false,
          success: function(data4) {
           //   //////alert(data4)
 	var GROUPNAME= data4[0]["GROUP_NAME"];
          // //////alert("MAIN: "+GROUPNAME)    
       var selectedOptions123 = GROUPNAME.split(",");
    for(var m=0;m<selectedOptions123.length;m++) {
 	////////alert("LOOP: "+selectedOptions123[m])
 	//var replaced = selectedOptions123[m] .replace(' ','-');
 	  
    	
     if(role1.includes("Ticket Co-ordinator"))
    	{
    	//	//////alert("ticket codi");
    		$("#groupMultiserupdate").find("option[value='" + selectedOptions123[m]+ "']").prop("selected", true)
    	     $("#groupMultiserupdate").multiselect("refresh")
    			
    		}
      }
      

             
              }

              
      });
     
     
      $("#updategroupMulti").multiselect({
        includeSelectAllOption: true,
        buttonWidth: '100%',
        enableFiltering: true,
        enableCaseInsensitiveFiltering: true,
        maxHeight: 200
       
    });
    
	
	
}

function setCategoryScope(ENG_UNAME,E_COMPANY){
	
	
////////alert(E_COMPANY);	
    
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getCategoryForPerticularUser";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
      data:'username='+encodeURIComponent(ENG_UNAME)
      +'&company2='+encodeURIComponent(E_COMPANY),
          async: false,
         success: function(data4) {
//             ////alert(JSON.stringify(data4))
	var CATEGORYy= data4[0]["CATEGORY"];
                  
      var selectedOptions123 = CATEGORYy.split(",");
   for(var m=0;m<selectedOptions123.length;m++) {
$("#updatecategoryMulti").find("option[value='" + selectedOptions123[m] + "']").prop("selected", true)
     $("#updatecategoryMulti").multiselect("refresh")
  
     }
     

            
             }

             
     });
     
     
      $("#updatecategoryMulti").multiselect({
        includeSelectAllOption: true,
        buttonWidth: '100%',
        enableFiltering: true,
        enableCaseInsensitiveFiltering: true,
        maxHeight: 200
       
    });
    
	
	
}






$('#modeleditengg').on('hidden.bs.modal', function () {
	 location.reload();
	$("#passupdate").val("");
	$('#noteupdate').hide();
	$('#labelupdate').hide();
	$("#Cpassupdate").val("");
	$('#note1update').hide();
//	////alert("hi")
	
	document.getElementById('Cpassupdate').style.backgroundColor = "#fff";
	$("#cnameupdate").val("");
	$("#snameupdate").val("");

	
});
$("#updateengg-btn").click(function() {
//    //////alert("in update")
//    if (!validateAddEnggupdate())
//    {
//        //////alert("fail")
      //  event.preventDefault();
//    }
//else if (validateAddEnggupdate())
//   {
    	
    	
     var role2=	$("#rtypeupdate").val();
     
     
    // //////alert(role2 + " ROLE VALUE ");
    // //////alert($('#company0').val() +"COMPANY VALUE ")
    	if (($('#company0').val() === undefined ||$('#company0').val()==='' || $('#company0').val()===null ) && (role2.includes("Engineer") || role2.includes("IT-Head") ||role2.includes("Ticket Co-ordinator")) ){

        ////////alert("fail")
       
        
         swal({
                    title: "Warning!",
                    text: "Please provide atleast one Scope by clicking on the Add Row button.",
                    type: "warning",
                    width: '300px',
                    height: '90px !important',
                    //                   		 showCancelButton: false,
//                          confirmButtonClass: "btn btn-danger",
//                          cancelButtonClass: "btn btn-danger m-l-10",
//                          confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                })
    	}
    	else{
    		////////alert("pass");
    		updateAddEnggSave007();
    	}
     // }
}).show();

function updateAddEnggSave007() {
	
	
	


////////alert("updatevipLoginVal:-"+vipLoginVal);

var role=$('#rtypeupdate').val();

 var cate="";
 var group ="";
if(role.includes("Engineer")){
	
	cate= $('#updatecategoryMulti').val();
	group= $('#updategroupMulti').val();
	
	
} else {
	
	cate="NA";
	group ="NA";
}



    var row="";
    if(role.includes("Admin") || role.includes("User")){
	row="NA";
	} else {
   
    for(s=0;s<counterupdate;s++){
	
	 var company=$('#company'+s).val();
   var branch=$('#updatetableBranch'+s).val();
   var department=$('#updateTableDepartment'+s).val();
	
	
		row	+="(T_COMPANY IN ('"+company+"') AND T_BRANCH IN ('"+branch+"') AND T_DEPARTMENT IN ('"+department+"'))";
		if(s != counterupdate-1){
	row	+=" OR ";
	}
}


}
   ////////alert("Row:-"+row);
	
    var selectedSideBarValues = [];
    $(".setscopeDashboard :selected").each(function() {
    	selectedSideBarValues.push($(this).val());
    });
    var selectedSideBarValuesFinal=selectedSideBarValues.toString();
    
    ////alert("selectedSideBarValuesFinal"+selectedSideBarValuesFinal)
	
	
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/updateUserLoginMaster";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "fnameupdate=" + encodeURIComponent($('#fnameupdate').val())
                + "&lnameupdate=" + encodeURIComponent($('#lnameupdate').val())
                + "&userupdate=" + encodeURIComponent($('#userupdate').val())
                + "&cnameupdate=" + encodeURIComponent($('#cnameupdate').val())
                + "&snameupdate=" + encodeURIComponent($('#snameupdate').val())
                + "&dnameupdate=" + encodeURIComponent($('#dnameupdate').val())
                + "&mailupdate=" + encodeURIComponent($('#mailupdate').val())
                + "&cnoupdate=" + $('#cnoupdate').val()
                  + "&updategroup=" + encodeURIComponent(group)
                    + "&updatecategory=" + encodeURIComponent(cate)
                    
                + "&passupdate=" + encodeURIComponent($('#passupdate').val())
                 + "&subdnameupdate=" + encodeURIComponent($('#subdnameupdate').val())
                + "&cr_no=" + $('#sr_no').val()
                + "&locationupdate=" + encodeURIComponent($('#locationupdate').val())
                 + "&rtypeupdate=" + $('#rtypeupdate').val()
                  + "&row=" + encodeURIComponent(row)
                + "&englevelupdate=" + $('#englevelupdate').val()
                + "&designation=" + encodeURIComponent($('#designationUpdate').val())
                + "&visibilityupdate=" + $('#visibilityupdate').val()
                
                
                + "&selectedSideBarValuesFinal=" + encodeURIComponent(selectedSideBarValuesFinal)
                
                
                + "&groupMultiserupdate=" + encodeURIComponent($('#groupMultiserupdate').val()),
                 async: false,
        success: function(data) {
////////alert("fhgkdsf"+data)
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Updated Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
//                   		 showCancelButton: false,
//                          confirmButtonClass: "btn btn-danger",
//                          cancelButtonClass: "btn btn-danger m-l-10",
//                          confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/View_User_List";
                    }
                })
            }


            else if (data == "duplicate") {
                swal({
                    title: "Duplicate!",
                    text: "Record Already Exist",
                    type: "success",
                    width: '300px',
                    height: '90px !important',
                    //                   		 showCancelButton: false,
//                          confirmButtonClass: "btn btn-danger",
//                          cancelButtonClass: "btn btn-danger m-l-10",
//                          confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/View_User_List";
                    }
                })
            }


            else {

                swal({
                    title: "Unsuccessful!",
                    text: "Record not updated",
                    type: "error",
                    width: 300,
                    height: 200,
                    //                   		 showCancelButton: false,
//                          confirmButtonClass: "btn btn-danger",
//                          cancelButtonClass: "btn btn-danger m-l-10",
//                          confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/View_User_List";
                    }
                })
            }
            


        }
    })
}



	var counterupdate = 0;
$("#updateAddrow")
							.on(
									"click",
									function() {
									
										
										
										// var FirstRow = $("<tr><td>Peripheral
										// type</td><td>Manufacturer</td><td>Serial
										// Number</td><td>Name </td></tr>");
										var newRow = $("<tr>");
										var cols = "";

										
										cols += '<td class="form-group adjust"><select class="form-control " tabindex="6" data-toogle="tooltip"  onchange="getUpdateBranchDetails(\''+counterupdate+'\')" name="company[]" id="company'
												+ counterupdate + '"></select></td>';
										cols += '<td class="form-group adjust"><div class="form-group" id="updatetableBranchDiv'+ counterupdate + '"><select class="form-control customMulti" tabindex="6" data-toogle="tooltip" multiple="multiple" onchange="getUpdateDepart(\''+counterupdate+'\')" name="updatetableBranch[]" id="updatetableBranch'
												+ counterupdate + '"></select></div></td>';
										cols += '<td class="form-group adjust"><div class="form-group" id="updateTableDepartmentDiv'+ counterupdate + '"><select class="form-control customMulti" tabindex="6" data-toogle="tooltip"  multiple="multiple" name="updateTableDepartment[]" id="updateTableDepartment'
												+ counterupdate + '"></select></div></td>';
										

										/*cols += '<td><button class="ibtnDel1 btn btn-md btn-danger fa fa-close">Remove</button></td>';*/

										newRow.append(cols);
										$("table.order-list1").append(newRow);
										counterupdate++;
										
										////////alert("counterupdate:-"+counterupdate)	
	
										
										
  var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
          async: false,
         success: function(data4) {
          //  //////alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = "  <option value=''> -- Please Select --</option>";
                    for (var i = 0; i < data4.length; i++) {
//                        //////alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }
////////alert(html);

var count=counterupdate-1;
////////alert("perifheraltype"+count);
                    document.getElementById("company"+count).innerHTML = html;
                   
             }

             
     })
      $(".customMulti").multiselect({
        includeSelectAllOption: true,
        buttonWidth: '100%',
        enableFiltering: true,
        enableCaseInsensitiveFiltering: true,
        maxHeight: 200
       
    });
     

										
										

										// Add new field
	/*									$option = newRow
												.find('[name="perifheraltype[]"]');
										$('#addhardwareform')
												.bootstrapValidator('addField',
														$option);

									$option = newRow
												.find('[name="perifheralmanufacturer[]"]');
										$('#addhardwareform')
												.bootstrapValidator('addField',
														$option);

										$option = newRow
												.find('[name="perifheralserialno[]"]');
									$('#addhardwareform')
											.bootstrapValidator('addField',
														$option);

										$option = newRow
												.find('[name="perifheralname[]"]');
										$('#addhardwareform')
												.bootstrapValidator('addField',
														$option);

										$option = newRow
												.find('[name="perifheralid[]"]');
										$('#addhardwareform')
											.bootstrapValidator('addField',
													$option);
*/



									});

									
									/*
									$("table.order-list1").on("click", ".ibtnDel1",
							function(event) {
								$(this).closest("tr").remove();
							//	counterupdate -= 1
							});
							*/
							
			
$("#updatedeleteRow").click(function() {
								////////alert("deleteRow:-"+counter)
								if(counterupdate>1){
								var table = document.getElementById("updateperifheralTable");
   // var rowCount = table.rows.length;
    // //////alert("rowCount"+counter);
     
    							table.deleteRow(counterupdate );
								counterupdate -= 1
								
								}
								});


			
function getUpdateBranchDetails(id) {
    ////////alert("getUpdateBranchDetails Company:"+$("#company"+id).val()+"ID"+id);
    
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/getBranchForLoginMaster";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + encodeURIComponent($("#company"+id).val()),
           async: false,
         success: function(data4) {
            // //////alert(data4);
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                   var html = " <select class='form-control customMulti' tabindex='8' data-toogle='tooltip' multiple='multiple' onchange='getUpdateDepart(\""+id+"\")' name='updatetableBranch[]' id='updatetableBranch"+ id + "'> ";
                    for (var i = 0; i < data4.length; i++) {
//                        //////alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }
                      html += "</select>";
                      
                           //  //////alert("ID:-"+id);
                    document.getElementById("updatetableBranchDiv"+id).innerHTML = html;
                        updatemulti(id);
             }

             
     });
     
   
    
    
   
}				


function updatemulti(id) {
	////////alert("perifheralmanufacturer multi")
   $(".customMulti").multiselect({
        includeSelectAllOption: true,
        buttonWidth: '100%',
        enableFiltering: true,
        enableCaseInsensitiveFiltering: true,
        maxHeight: 200
       
    });
    
    
    
}

function getUpdateDepart(id) {
   // //////alert($("#cname").val());
   //   //////alert($("#sname").val());
    
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getDepartmentForUserScope";
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'companyname=' + encodeURIComponent($("#company"+id).val())+ '&branchName=' + encodeURIComponent($("#updatetableBranch"+id).val()),
          async: false,
         success: function(data4) {
          //   //////alert(data4)
//            var pollingHost = data4;
//                    var d = pollingHost.split(",");
//                    var length = d.length - 1;
                    var html = " <select class='form-control customMulti' tabindex='8' data-toogle='tooltip' multiple='multiple'  name='updateTableDepartment[]' id='updateTableDepartment"+ id + "'> ";
                    for (var i = 0; i < data4.length; i++) {
//                        //////alert(data4[i]);
                        html += '<option value="' + data4[i] + '">' + data4[i]
                                + '</option>';
                    }
            html += "</select>";
                 //  //////alert("ID:-"+id);
                    document.getElementById("updateTableDepartmentDiv"+id).innerHTML = html;
                     updatemulti2(id);
             }

             
     });
     
     
     
    
}


function updatemulti2(id) {
	////////alert("perifheralserialno multi")
   $("#updateTableDepartment"+id).multiselect({
        includeSelectAllOption: true,
        buttonWidth: '100%',
        enableFiltering: true,
        enableCaseInsensitiveFiltering: true,
        maxHeight: 200
       
    });
    
    
    
}



var callToolTipUpdate1123 = function(fieldName, status) {
    if (fieldName == "label") {
        var errorMessage = "<span>Password Must contain atleast one number,one lowercase,one uppercase and one special character<span>";
    } else if (fieldName == "password") {
        var errorMessage = "Please Enter Password";
    } else if (fieldName == "confirmPassword") {
        var errorMessage = "Please Enter Confirm Password";
    } else if (fieldName == "label123") {
        var errorMessage = "Please Enter Strong Password";
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



function checkPassstrengthForPassReset() {
    var pass = $('#password').val();
    var ret = true;
    ;
    // //////alert(pass)
    var specailcharatcers = "!#$%&'()*+,-./:;<=>?@[\]^_`{|}~";
    var passwordscore = 0;
    $('#note123').show();
//    for (var i = 0; i < pass.length; i++)
//    {
//        if (specailcharatcers.indexOf(pass.charAt(i)) > -1)
//        {
//            passwordscore += 20;
//        }
//    }
var charcount=0;
 for (var i = 0; i < pass.length; i++)
    {
        
        if (specailcharatcers.indexOf(pass.charAt(i)) > -1)
        {
//            passwordscore += 20;
        charcount=charcount+1;
//        //////alert(charcount);
        }
    }
    if(charcount>=3 ||charcount<=0)
    {
//        //////alert("in false")
    }
    else{
        passwordscore += 20;
    }

    if (/[a-z]/.test(pass))
    {
        ('inside lowercase')
        passwordscore += 20;
    }
    if (/[A-Z]/.test(pass))
    {
        ('inside uppercase')
        passwordscore += 20;
    }
    if (/[\d]/.test(pass))
    {
        ('inside numbers')
        passwordscore += 20;
    }
    if (pass.length >= 7)
    {
        ('inside length')
        passwordscore += 20;
    }
    ////////alert(passwordscore)
    var strength = "Weak";
    if (passwordscore >= 100)
    {
        strength = "Strong";
    }
    else if (passwordscore >= 80)
    {
        strength = "Medium";
    }
    else if (passwordscore >= 60)
    {
        strength = "Weak";
    }

    ////////alert('strength now:'+strength)
    document.getElementById('label123').innerHTML = strength;
    
    	
    		$('#label123').show();
    
    if (strength === "Strong")
    {
        document.getElementById('label123').style.color = "green";
        $('#note123').hide()
    }
    else if (strength === "Medium")
    {
        document.getElementById('label123').style.color = "yellow";
         $('#note123').show()
    }
    else if (strength === "Weak")
    {
        document.getElementById('label123').style.color = "red";
         $('#note123').show()
    }

    if (strength === "Strong")
    {
        callToolTipUpdate1123('label123', 'destroy');
        ret = true;
        $('#note123').hide()
    }
    else
    {
        //callToolTipUpdate1('label', 'show');
        ret = false;

    }
    return ret;
}

function passwordReset(password,username,loginid)
{
//	////alert(password+"pass"+username+"username"+loginid+"loginid")
	  $("#username").val(username);
	      $("#loginid").val(loginid);
	  $("#PasswordResetModal").modal("show");
	
}

$('#PasswordResetModal').on('hidden.bs.modal', function () {
////alert("hii")
 location.reload();
});



function checkPassword() {
    var ret = true;
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('password');

    var pass2 = document.getElementById('confirmPassword');

    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    $('#note3').hide();
    if (pass1.value === "" && pass2.value === "")
    {
        ret = false;
    }
    else if (pass1.value == pass2.value) {

        pass2.style.backgroundColor = goodColor;


        document.getElementById('note3').innerHTML = "Password match!";
        document.getElementById('note3').style.color = "green";
        $('#note3').show();
        ret = true;
    } else {

        pass2.style.backgroundColor = badColor;
        document.getElementById('note3').innerHTML = "Password does not match!";
        document.getElementById('note3').style.color = "red";
        $('#note3').show();

        ret = false;
    }
    return ret;
}



function updateUserPassword(){
////alert($('#loginid').val())
	
	 var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/updateUserPassword";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        data: "username=" + $('#username').val()
                + "&password=" + $('#password').val()
               + "&confirmPassword=" + $('#confirmPassword').val()
                 + "&loginid=" + $('#loginid').val(),
                 async: false,
        success: function(data) {
////////alert("fhgkdsf"+data)
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Updated Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
//                   		 showCancelButton: false,
//                          confirmButtonClass: "btn btn-danger",
//                          cancelButtonClass: "btn btn-danger m-l-10",
//                          confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/View_User_List";
                    }
                })
            }


            else if (data == "duplicate") {
                swal({
                    title: "Duplicate!",
                    text: "Record Already Exist",
                    type: "success",
                    width: '300px',
                    height: '90px !important',
                    //                   		 showCancelButton: false,
//                          confirmButtonClass: "btn btn-danger",
//                          cancelButtonClass: "btn btn-danger m-l-10",
//                          confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/View_User_List";
                    }
                })
            }


            else {

                swal({
                    title: "Unsuccessful!",
                    text: "Record not updated",
                    type: "error",
                    width: 300,
                    height: 200,
                    //                   		 showCancelButton: false,
//                          confirmButtonClass: "btn btn-danger",
//                          cancelButtonClass: "btn btn-danger m-l-10",
//                          confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/Admin/View_User_List";
                    }
                })
            }
            


        }
    })	
}


$("#passwordUpdate").click(function() {
   // //////alert("submit-btn click");
   if (!validatepasswordReset()) {
  
        event.preventDefault();
    } else {
	
       // //////alert("valid");
        updateUserPassword();
   }
});



//$('#password').on('focus', function() {
//    callToolTip231update('password', 'destroy');
//});
function Deleteengineer(srno) {
	////////alert("gdfsf"+srno)
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
	        //  //////alert("deleteUserdddddddd")
	    	 var l = window.location;
	 	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	 	var serviceUrl = base_url + "/Master/DeleteLoginMasterData";
	     
	        $.ajax({
	            type: 'POST',
	            url: serviceUrl,
	            data: 'crno=' + srno

	        }).done(function(data) {
	            //  //////alert("dfgsfd"+data)

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
	                        window.location.href = base_url + "/Admin/View_User_List";
	                    }

	                })

	            }

	            else if (data == "error") {
	                swal({
	                    title: "Unsuccessful!",
	                    text: "Fail to delete file",
	                    type: "success",
	                    width: 300,
	                    height: 200,
//	           		 showCancelButton: false,
//	                  confirmButtonClass: "btn btn-danger",
//	                  cancelButtonClass: "btn btn-danger m-l-10",
//	                  confirmButtonText: "OK",
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/View_User_List";
	                    }

	                })

	            }
	        });
	    })
	}
function validatepasswordReset() {
	
	 var indexError = 0;
	
	if ($('#password').val().trim() === '') {
    callToolTipUpdate1123('password', 'show');
     //callToolTipUpdate1123('label123', 'hide');
  
     if (indexError == 0) {

     }
     indexError = indexError + 1;
      ("In pass: "+indexError);

 }

 if ($('#confirmPassword').val().trim() === '') {
     callToolTipUpdate1123('confirmPassword', 'show');
     if (indexError == 0) {

     }
     indexError = indexError + 1;
     ("In Cpass: "+indexError);
 }

// if (!($('#Cpass').val().trim() === '' && $('#pass').val().trim() === '')) {
//	   
//	 var passlength= $('#password').val().length;
//	// //////alert(passlength);
//	   if(passlength>0){
//		  ////////alert("innn ifff");
//	   
//     if (!checkPassword())
//     {
//  	 //  //////alert(checkPassword);
//	   callToolTipUpdate1123('label123', 'show');
//         indexError = indexError + 1;
//         ("In pass compare: "+indexError);
//     }
//     
//	   }
//
// }

 if (!checkPassstrengthForPassReset() && passlength>0)
 {

     callToolTipUpdate1123('label123', 'show');
     indexError = indexError + 1;
     ("In checkPassstrength: "+indexError);
 }
 
  
 if (indexError > 0) {
     return false;

 } else {
     return true;
 }
 
	
}

//$('#modeleditengg').on('hidden.bs.modal', function () {
//	////alert("hii")
//	 location.reload();
//	})


$("#resetbtn").click(function() {
    $("#password").val("");
    callToolTipUpdate1123('password', 'hide');

    $("#confirmPassword").val("");
    callToolTipUpdate1123('confirmPassword', 'hide');
     
     
});