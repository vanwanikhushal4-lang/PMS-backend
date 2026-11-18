

window.onload = function(){

	
	
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getAuthorizername";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          success: function(data2) {	
        	// alert("datadatt"+data2)
         	 var html = "  <option value=''> -- Please Select Authorizer Name --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("Authorizer").innerHTML = html;		
 			
 		}
 	});
      
      ///////////////////////

      var l = window.location;
     	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	   	var serviceUrl = base_url + "/Master/getdistributorname";

     	      $.ajax({
     	          type: 'POST',
     	          url: serviceUrl,
     	          dataType: 'json',
     	          success: function(data2) {	      
     	         	 var html = "  <option value=''> -- Please Select --</option>";
     	 			                    for (var i = 0; i < data2.length; i++) {
     	 				html += '<option value="' + data2[i] + '">' + data2[i]
     	 						+ '</option>';
     	 			}
     	 			document.getElementById("distributorname").innerHTML = html;		
     	 			
     	 		}
     	 	});
     	 	
     	 	
     	 var l = window.location;
     	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	   	var serviceUrl = base_url + "/Master/getpartnername";

     	      $.ajax({
     	          type: 'POST',
     	          url: serviceUrl,
     	          dataType: 'json',
     	          success: function(data2) {	      
     	         	 var html = "  <option value=''> -- Please Select --</option>";
     	 			                    for (var i = 0; i < data2.length; i++) {
     	 				html += '<option value="' + data2[i] + '">' + data2[i]
     	 						+ '</option>';
     	 			}
     	 			document.getElementById("partnername").innerHTML = html;		
     	 			
     	 		}
     	 	}); 	
     	

/////////// get sales manager name 

    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getcheckerName";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data2) {	
    	// alert("datadatt"+data2)
     	 var html = "  <option value=''> -- Please Select Sales Manager --</option>";
			                    for (var i = 0; i < data2.length; i++) {
				html += '<option value="' + data2[i] + '">' + data2[i]
						+ '</option>';
			}
			document.getElementById("salesManager").innerHTML = html;		
			
		}
	});
  
  ///////////////////////
	
	 var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/UserActivity/getUpdateRegistrationFormData";


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
	                $('#downHidepofile21').hide();
	            } else {
	                document.getElementById('pouploadfile21').innerHTML = data[0]["INCORPORATION_CERTIFICATE"];
	                document.getElementById('filenameStandard21').value = data[0]["INCORPORATION_CERTIFICATE"];
	                $('#poUploadDiv21').show();
	            }
	    	  
	    	 	if ((data[0]["PAN_CARD_FILE"]=== ""))
	            {
	                $('#downHidepancardfile21').hide();
	            } else {
	                document.getElementById('pancardfile21').innerHTML = data[0]["PAN_CARD_FILE"];
	                document.getElementById('pancardfilenameStandard21').value = data[0]["PAN_CARD_FILE"];
	                $('#pancrdDiv21').show();
	            }

	    	 	
	    	  	if ((data[0]["GST_CERTIFICATE"]=== ""))
	            {
	                $('#downHidegstfile21').hide();
	            } else {
	                document.getElementById('gstuploadfile21').innerHTML = data[0]["GST_CERTIFICATE"];
	                document.getElementById('gstfilenameStandard21').value = data[0]["GST_CERTIFICATE"];
	                $('#gstUploadDiv21').show();
	            }
	    	  
	    	 	if ((data[0]["MSMED_FILE"]=== ""))
	            {
	                $('#downHidemsmedfile21').hide();
	            } else {
	                document.getElementById('msmedfile21').innerHTML = data[0]["MSMED_FILE"];
	                document.getElementById('msmedfilenameStandard21').value = data[0]["MSMED_FILE"];
	                $('#mesmedDiv21').show();
	            }
	    	 	
	    	 	
	    	 	if ((data[0]["CANCLE_CHECKED_FILE"]=== ""))
	            {
	                $('#downHidecancCheqfile21').hide();
	            } else {
	                document.getElementById('cancChequploadfile21').innerHTML = data[0]["CANCLE_CHECKED_FILE"];
	                document.getElementById('cancCheqfilenameStandard21').value = data[0]["CANCLE_CHECKED_FILE"];
	                $('#cancCheqUploadDiv21').show();
	            }
	    	 	
	    	 	
	    	  
	    	 	if ((data[0]["LAST_YEAR_BS_PANDL"]=== ""))
	            {
	                $('#downHidelstBSPLfile21').hide();
	            } else {
	                document.getElementById('lstBSPLfile21').innerHTML = data[0]["LAST_YEAR_BS_PANDL"];
	                document.getElementById('lstBSPLfilenameStandard21').value = data[0]["LAST_YEAR_BS_PANDL"];
	                $('#lstBSPLDiv21').show();
	            }
	    	 	
	    	 	
	    	 	if ((data[0]["MSMED_DOCUMENT_FILE"]=== ""))
	            {
	                $('#downHidemsmedPartnfile21').hide();
	            } else {
	                document.getElementById('msmedPartnuploadfile21').innerHTML = data[0]["MSMED_DOCUMENT_FILE"];
	                document.getElementById('msmedPartnfilenameStandard21').value = data[0]["MSMED_DOCUMENT_FILE"];
	                $('#msmedPartnUploadDiv21').show();
	            }
	    	 	
	    		if ((data[0]["COMM_PROP_FILE"]=== ""))
	            {
	                $('#downHideCommPropfile21').hide();
	            } else {
	                document.getElementById('commPropfile21').innerHTML = data[0]["COMM_PROP_FILE"];
	                document.getElementById('commPropfilenameStandard21').value = data[0]["COMM_PROP_FILE"];
	                $('#commercialPropDIV21').show();
	            }

	    		
	    		
	    	 	if ((data[0]["PURC_ORDER_FILE"]=== ""))
	            {
	                $('#downHidePOfile27').hide();
	            } else {
	                document.getElementById('pouploadfile27').innerHTML = data[0]["PURC_ORDER_FILE"];
	                document.getElementById('pofilenameStandard27').value = data[0]["PURC_ORDER_FILE"];
	                $('#purchaseOrderUploadDiv27').show();
	            }
	    	 	

	    	 	$('#categorytype').val(data[0]["CATEGORIES_TYPE"]);
	              $('#compname').val(data[0]['C_NAME']);
	               $('#registerno').val(data[0]["REGISTRATION_NO"]);
	               $('#address').val(data[0]["ADDRESS"]);
	               $('#personname').val(data[0]["CONTACT_PERSON_NAME"]);
	               $('#mobno').val(data[0]["MOBILE_NO"]);
	               $('#telpno').val(data[0]["TELEPHONE_N"]);
	               $('#Md_Ceo_emailid').val(data[0]["MD_CEO_EMAIL_ID"]);
	               $('#Sales_emailid').val(data[0]["SALES_EMAIL_ID"]);
	               $('#support_email_id').val(data[0]["SUPPORT_EMAIL_ID"]);
	               $('#emailid_contact_person').val(data[0]["CONTACT_PERSON_NAME"]);
	               $('#office_mailid').val(data[0]["EMAIL_ID_OFFICE"]);
	               $('#city').val(data[0]["CITY"]);
	               $('#district').val(data[0]["DISTRICT"]);
	               $('#state').val(data[0]["STATE"]);
	               $('#pincode').val(data[0]["PIN"]);
	               $('#country').val(data[0]["COUNTRY"]);
	               $('#website').val(data[0]["WEBSITE"]);
	               $('#panacno').val(data[0]["PAN_NO"]);
	               $('#ownership').val(data[0]["OWNERSHIP_TYPE"]);
	               $('#SCALE_OF_COMPANY').val(data[0]["SCALE_OF_COMPANY"]);
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
	               $('#salesManager').val(data[0]["SALES_MANAGER"]);
	               
	               
	               
//	               if(data[0]["REGISTERED_MSMED"] === 'Yes'){
//	            	   
//	            	  $('#msmedtypeDIV').show();
//	            	   $('#msmedtype').val(data[0]["MSMED_REG_TYPE"]);
//	               }
	          
	            
	               
	               
//	                $('#sr_no1').val(crno);
	           
	      });
	 
	 
	 
	 
	 
	 
	 
}


function msmedreg(){
	
	var msmedyes = $('#msmedreg1').val();
	
	if(msmedyes === "Yes"){
		$('#msmedtypeDIV').show();
		
	}else{
		
		$('#msmedtypeDIV').hide();
	
	}
}

$("#updatedeleteRow").click(function() {

	if (counterupdate > 1) {
		var table = document.getElementById("updateperifheralTable");

		table.deleteRow(counterupdate);
		counterupdate -= 1

	}
});



function updateData() {
	

		
	   const tableBody = document.querySelector("#data-table tbody");
	   const rows = tableBody.querySelectorAll('tr');

	   dataArray = [];  // Clear the array before adding new data

	   for (const row of rows) {
	       const inputs = row.querySelectorAll('input');
	       
	       // Check if any input value is empty
	       for (const input of inputs) {
	           if (input.value.trim() === '') {
	               alert('One or more fields are empty. Please fill Details of Directors/Partners/Proprietor/Senior Manager.');
	               return; // Exit out of the function early
	           }
	       }

	       const dataObj = {
	           data1: inputs[0].value,
	           data2: inputs[1].value,
	           data3: inputs[2].value
	       };
	       dataArray.push(dataObj);
	   }

	// alert(JSON.stringify(dataArray));
	   Saveregistor(JSON.stringify(dataArray));  

}



function Saveregistor(addrowdata)
{
	

//	alert("addrowdata "+addrowdata);
//	if(!validateEditForm()) {
//		event.preventDefault();
//	} else {
		saveregistrationform(addrowdata);
//	}
	
	
}


function saveregistrationform(addrowdata){
	

	$('#spin').show();
// alert("inside saveregistrationform :: "+addrowdata);
    
//    alert("company name :"+$("#country").val());
		
  
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/updateRegistrationMaster";	
    var serviceUrl = serviceUrl;
	
	
	
	
	  var formData= new FormData(form);
	
	formData.append('addrowdata', addrowdata);
	  formData.append('tid', $("#tid").val());
	  formData.append('ideclaration', $("#ideclaration").val());

  $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         data: formData,
	         mimeType: "multipart/form-data",
	         contentType: false,
	         processData: false,
	         cache: false,
         		
         		
     }).done(function(data) {  
// alert(data)
    	 
    	 var dataArray = data.split(',');
    	 var firstPart = dataArray[0]; // "RF-20"
    	 var secondPart = dataArray[1]; // "Success"
    	 
    	 $('#spin').hide();
         if (secondPart == "success") {
             swal({
                 title: "Successful!",
//                 text: "Record Added Successfully",
                 html: "RF ID = " + firstPart + "<br><br> Record Update Successfully",
                 type: "success",
                 width: 300,
                 height: 200,

                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/User/updateRegistrationFormBySI";
                 }
             });

         }
        
         else if (secondPart == "fail") {
             swal({
                 title: "Unsuccessful!",
                 text: "Fail to add file",
                 html: "RF ID = " + firstPart + "<br><br> Fail to Update Record",
                 type: "success",
                 width: 300,
                 height: 200,

                 buttons: false,
                 allowOutsideClick: false,
                 preConfirm: function() {
                     var l = window.location;
                     var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                     window.location.href = base_url + "/User/updateRegistrationFormBySI";
                 }

             });

           }
     });
	

}
//// for add row

let dataArray = [];

function addRow() {
const tableBody = document.querySelector("#data-table tbody");
const newRow = tableBody.insertRow();
const placeholders = ['Enter Company Name', 'Enter Designation', 'Enter Experience'];
for (let i = 0; i < 3; i++) {
    const cell = newRow.insertCell();
    const input = document.createElement('input');
    input.type = 'text';
    input.classList.add('form-control', 'form-control-sm');
    input.placeholder = placeholders[i];
    cell.appendChild(input);
}


const deleteCell = newRow.insertCell();
const deleteButton = document.createElement('button');
deleteButton.textContent = 'Delete';
deleteButton.type ='button';
deleteButton.classList.add('btn', 'btn-danger');
deleteButton.onclick = function() {
    deleteRow(deleteButton);
};
deleteCell.appendChild(deleteButton);
}

/// for delete row
function deleteRow(btn) {
   const row = btn.parentNode.parentNode;
   row.parentNode.removeChild(row);
}


function myCategory() {
	
	$('#registrationform').hide();
	$('#registrationform2').hide();
	$('#registrationform3').hide();
	
	var categorytype = $('#categorytype').val();

	if (categorytype != "" && categorytype === "Partner") {
		$('#distributor').show();
		$('#customer').hide();
	} 
	else if (categorytype != "" && categorytype === "Customer") {
		$('#distributor').show();
		$('#customer').show();
	}else{
		$('#distributor').hide();
		$('#customer').hide();
		
	}

}

function downFileStandard21()
{
    var filename = $('#filenameStandard21').val();
 //   alert(filename);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
function downpancradFileStandard21()
{
    var filename = $('#pancardfilenameStandard21').val();

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
function downgstFileStandard21()
{
    var filename = $('#gstfilenameStandard21').val();
 //   alert(filename);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
function downmsmedFileStandard21()
{
    var filename = $('#msmedfilenameStandard21').val();

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
function downcancCheqFileStandard21()
{
    var filename = $('#cancCheqfilenameStandard21').val();
 //   alert(filename);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
function downlstBSPLFileStandard21()
{
    var filename = $('#lstBSPLfilenameStandard21').val();

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}
function downmsmedPartnFileStandard21()
{
    var filename = $('#msmedPartnfilenameStandard21').val();
 //   alert(filename);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}



function downCommPropFileStandard21()
{
    var filename = $('#commPropfilenameStandard21').val();
 //   alert(filename);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}


function downPOFileStandard27()
{
    var filename = $('#pofilenameStandard27').val();
 //   alert(filename);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    window.location.href = base_url + "/Inventive/DownloadFile?filename="+filename;

}