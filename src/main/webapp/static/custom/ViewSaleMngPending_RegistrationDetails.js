

window.onload = function(){

	 $('.nav-tabs a').click(function () {
	        $(this).tab('show');
	    });
		
		


//
//	  
//	    var l = window.location;
//	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	 	var serviceUrl = base_url + "/Uservity/getlSaleMngData";
//	    
//	    $.ajax({
//	        url: serviceUrl,
//	        type: 'POST',
//	        dataType: 'json',
//	        data: "crno=" + $('#crnoo').val()
//	        + '&tid=' + $("#tid").val()
//	    }).done(function(data) {
//	    	
//	    	var aaa = data[0];
//	    	
//	  
//	  	
//	    	
//	    	
//	     
//
//
//
//	    });
	
	 
	 var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/Master/getlist";


	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
		        data: "crno=" + $('#crnoo').val()
		        + '&tid=' + $("#tid").val()
	         
	      }).done(function(data) {
	          
	    	  console.log(data);
	    	  
	    	//  alert("hhhh"+data[0]["INCORPORATION_CERTIFICATE"])
	    	  
	    	  
	    	   	if ((data[0]["INCORPORATION_CERTIFICATE"]=== ""))
	            {
	                $('#downHidepofile').hide();
	            } else {
	                document.getElementById('pouploadfile').innerHTML = data[0]["INCORPORATION_CERTIFICATE"];
	                document.getElementById('filenameStandard').value = data[0]["INCORPORATION_CERTIFICATE"];
	                $('#poUploadDiv').show();
	            }
	    	  
	    	 	if ((data[0]["PAN_CARD_FILE"]=== ""))
	            {
	                $('#downHidepancardfile').hide();
	            } else {
	                document.getElementById('pancardfile').innerHTML = data[0]["PAN_CARD_FILE"];
	                document.getElementById('pancardfilenameStandard').value = data[0]["PAN_CARD_FILE"];
	                $('#pancrdDiv').show();
	            }

	    	 	
	    	  	if ((data[0]["GST_CERTIFICATE"]=== ""))
	            {
	                $('#downHidegstfile').hide();
	            } else {
	                document.getElementById('gstuploadfile').innerHTML = data[0]["GST_CERTIFICATE"];
	                document.getElementById('gstfilenameStandard').value = data[0]["GST_CERTIFICATE"];
	                $('#gstUploadDiv').show();
	            }
	    	  
	    	 	if ((data[0]["MSMED_FILE"]=== ""))
	            {
	                $('#downHidemsmedfile').hide();
	            } else {
	                document.getElementById('msmedfile').innerHTML = data[0]["MSMED_FILE"];
	                document.getElementById('msmedfilenameStandard').value = data[0]["MSMED_FILE"];
	                $('#mesmedDiv').show();
	            }
	    	 	
	    	 	
	    	 	if ((data[0]["CANCLE_CHECKED_FILE"]=== ""))
	            {
	                $('#downHidecancCheqfile').hide();
	            } else {
	                document.getElementById('cancChequploadfile').innerHTML = data[0]["CANCLE_CHECKED_FILE"];
	                document.getElementById('cancCheqfilenameStandard').value = data[0]["CANCLE_CHECKED_FILE"];
	                $('#cancCheqUploadDiv').show();
	            }
	    	 	
	    	 	
	    	  
	    	 	if ((data[0]["LAST_YEAR_BS_PANDL"]=== ""))
	            {
	                $('#downHidelstBSPLfile').hide();
	            } else {
	                document.getElementById('lstBSPLfile').innerHTML = data[0]["LAST_YEAR_BS_PANDL"];
	                document.getElementById('lstBSPLfilenameStandard').value = data[0]["LAST_YEAR_BS_PANDL"];
	                $('#lstBSPLDiv').show();
	            }
	    	 	
	    	 	
	    	 	if ((data[0]["MSMED_DOCUMENT_FILE"]=== ""))
	            {
	                $('#downHidemsmedPartnfile').hide();
	            } else {
	                document.getElementById('msmedPartnuploadfile').innerHTML = data[0]["MSMED_DOCUMENT_FILE"];
	                document.getElementById('msmedPartnfilenameStandard').value = data[0]["MSMED_DOCUMENT_FILE"];
	                $('#msmedPartnUploadDiv').show();
	            }


	              $('#compname').val(data[0]['C_NAME']);
	               $('#registerno').val(data[0]["REGISTRATION_NO"]);
	               $('#address').val(data[0]["ADDRESS"]);
	               $('#personname').val(data[0]["CONTACT_PERSON_NAME"]);
	               $('#mobno').val(data[0]["MOBILE_NO"]);
	               $('#telpno').val(data[0]["TELEPHONE_N"]);
	               $('#emailid').val(data[0]["MD_CEO_EMAIL_ID"]);
	               $('#offemailid').val(data[0]["SALES_EMAIL_ID"]);
	               $('#supportmail').val(data[0]["SUPPORT_EMAIL_ID"]);
	               $('#copersonemailid').val(data[0]["CONTACT_PERSON_NAME"]);
	               $('#offemailids').val(data[0]["EMAIL_ID_OFFICE"]);
	               $('#city').val(data[0]["CITY"]);
	               $('#district').val(data[0]["DISTRICT"]);
	               $('#state').val(data[0]["STATE"]);
	               $('#pincode').val(data[0]["PIN"]);
	               $('#country').val(data[0]["COUNTRY"]);
	               $('#website').val(data[0]["WEBSITE"]);
	               $('#panacno').val(data[0]["PAN_NO"]);
	               $('#ownership').val(data[0]["OWNERSHIP_TYPE"]);
	               $('#scaleofcmpy').val(data[0]["SCALE_OF_COMPANY"]);
	               $('#gstin').val(data[0]["GSTIN"]);
	               $('#cuntrytaxno').val(data[0]["COUNTRY"]);
	               $('#dateofbussns').val(data[0]["DATE_COMMENCEMENT_BUSSINESS"]);
	               $('#currency').val(data[0]["CURRENCY"]);
	               $('#year1').val(data[0]["YEAR1"]);
	               $('#year2').val(data[0]["YEAR2"]);
	               $('#year3').val(data[0]["YEAR3"]);
	               $('#rupees1').val(data[0]["AMOUNT1"]);
	               $('#rupees2').val(data[0]["AMOUNT2"]);
	               $('#rupees3').val(data[0]["AMOUNT3"]);
	               $('#gemportal1').val(data[0]["REGISTERED_GEMPORTAL"]);
	               $('#msmedreg1').val(data[0]["REGISTERED_MSMED"]);
	               $('#entrepreno').val(data[0]["ENTREPRENEUR_MEMORANDUM"]);
	               $('#incocertificate').val(data[0]["INCORPORATION_CERTIFICATE"]);
	               $('#pancardfile').val(data[0]["PAN_CARD_FILE"]);
	               $('#gstcertificate').val(data[0]["GST_CERTIFICATE"]);
	               $('#msmed').val(data[0]["MSMED_DOCUMENT_FILE"]);
	               $('#cancelledcheque').val(data[0]["CANCLE_CHECKED_FILE"]);
	               $('#Checker').val(data[0]["CHECKER"]);
	               $('#Authorizer').val(data[0]["AUTHORIZER"]);
	               
	               
	             
//	                $('#sr_no1').val(crno);
	           
	      });
	 
	 
	 
	 
	 
	 
	 
}

function myFunctionReject(){
	


	
	    swal({
	        title: 'Enter Your Reason',
	        input: 'textarea',
	        inputPlaceholder: "Enter Your Reason",
	        showCancelButton: true,
	        confirmButtonText: 'Submit',
	        preConfirm: function(result) {
	            // alert("value: "+result)
	            return new Promise(function(resolve, reject) {

	                if (result === "") {
	                    swal.showValidationError(
	                            'You Need To Write Your Reason!'
	                            )

	                    $('.swal2-confirm').prop('disabled', false);
	                    $('.swal2-cancel').prop('disabled', false);
	                    return false;
	                }
	                else {
	                    swal.resetValidationError()
	                    
	                    $('#spin2').show();
	                    
	                    var l = window.location;
	                 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                 	var serviceUrl = base_url + "/UserActivity/rejectRFtoACmgr";
	                    
	                    $.ajax({
	                        type: "POST",
	                        url: serviceUrl,
	                        data: "val=" + encodeURIComponent(result)
	                                + "&crno=" + $('#crnoo').val()
	                                + "&tid=" + $('#tid').val()
	                                + "&MDnote=" + encodeURIComponent($('#MDnote').val()),
	                
	                    }).done(function(data) {
	                        $('#spin2').hide();
//	                        alert("my data :"+data);
	                        if (data == "success") {
	                            swal({
	                                title: "Successful!",
	                                text: "Reject RF Successfully",
	                                type: "success",
	                                width: 300,
	                                height: 200,
	                                confirmButtonClass: "btn btn-success",
	                                confirmButtonText: "OK",
	                                preConfirm: function() {
	                                    var l = window.location;
	                                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                                    window.location.href = base_url + "/User/pendingCustomer";
	                                }
	                            })
	                        }
	                        else {
	                            swal({
	                                title: "Fail!",
	                                text: "RF Not Rejected",
	                                type: "error",
	                                width: 300,
	                                height: 200,
	                                confirmButtonClass: "btn btn-success",
	                                confirmButtonText: "OK",
	                                preConfirm: function() {
	                                    var l = window.location;
	                                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                                    window.location.href = base_url + "/User/pendingCustomer";
	                                }
	                            })
	                        }
	                    });
	                }

	                resolve(result)

	            })
	        }
	    })

	
	
}
function downFileStandard()
{
    var filename = $('#filenameStandard').val();
 //   alert(filename);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
function downpancradFileStandard()
{
    var filename = $('#pancardfilenameStandard').val();

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}





function downgstFileStandard()
{
    var filename = $('#gstfilenameStandard').val();
 //   alert(filename);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
function downmsmedFileStandard()
{
    var filename = $('#msmedfilenameStandard').val();

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}


function downcancCheqFileStandard()
{
    var filename = $('#cancCheqfilenameStandard').val();
 //   alert(filename);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
function downlstBSPLFileStandard()
{
    var filename = $('#lstBSPLfilenameStandard').val();

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
function downmsmedPartnFileStandard()
{
    var filename = $('#msmedPartnfilenameStandard').val();
 //   alert(filename);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}

$("#ApproveCM").click(function () {

//	alert("dkukh")

    $('#spin1').show();
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/registFormCollnMangApprove";
    
    $.ajax({
        url: serviceUrl, 
        type: 'POST',
        data: "crno=" + $('#crnoo').val()
            + "&tid=" + $('#tid').val(),
              
    }).done(function (data) {
        $('#spin1').hide();
        if (data === "success")
        {
            swal({
                title: "Successful!",
                text: "Document Approved Successfully",
                type: "success",
                width: 300,
                height: 200,
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger m-l-10",
                confirmButtonText: "OK",
                preConfirm: function () {
                    var l = window.location;
                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                    window.location.href = base_url + "/User/pendingCustomer";
                }
            })
        } else
        {
            swal({
                title: "Fail!",
                text: "Document Approved UnSuccessful",
                type: "error",
                width: 300,
                height: 200,
                // showCancelButton: !0,
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger m-l-10",
                confirmButtonText: "OK",
                preConfirm: function () {
                    var l = window.location;
                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                    window.location.href = base_url + "/User/pendingCustomer";
                    
                    
                }

            })
        }


    });
});



