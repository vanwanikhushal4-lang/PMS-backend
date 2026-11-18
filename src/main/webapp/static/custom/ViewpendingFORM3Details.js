
var dataPoId = $('#crnoo').val();
var jsonImplFormC = null;

window.onload = function(){

	 $('.nav-tabs a').click(function () {
	        $(this).tab('show');
	    });
		
  
	    var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getPendingFORM3Data";
	    
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: "crno=" + $('#crnoo').val()
	        + '&tid=' + $("#tid").val()
	    }).done(function(data) {
	    	
	    	var aaa = data[0];
	    	console.log(data)
	    	
	    	var ccc = data[2];
	    //	alert("hhhhh"+data[0][0])
	    	
//	    	alert(data[3]);
	
	    		if ((decodeURIComponent(aaa[7]) === "File Not Attached") || (decodeURIComponent(aaa[7]) === "NA")
								|| (decodeURIComponent(aaa[7]) === "") ) {
							$('#downHidemaskedPOfile').hide();
						} else {
							document.getElementById('maskedPOfile').innerHTML = decodeURIComponent(aaa[7]);
							document.getElementById('filnameMaskedPO').value = decodeURIComponent(aaa[7]);
							$('#maskedPOUploadDiv').show();
						}
	    		if ((decodeURIComponent(aaa[8]) === "File Not Attached") || (decodeURIComponent(aaa[8]) === "NA")
						|| (decodeURIComponent(aaa[8]) === "") ) {
					$('#downHideproductFeaturedfile').hide();
				} else {
					document.getElementById('productFeaturedFile').innerHTML = decodeURIComponent(aaa[8]);
					document.getElementById('filnameProductFeatured').value = decodeURIComponent(aaa[8]);
					$('#productFeaturedUploadDiv').show();
				}
	    		
    $('#date').val(decodeURIComponent(aaa[0]));
   
    $('#customername').val(decodeURIComponent(aaa[1]));
//    $('#projectname').val(decodeURIComponent(aaa[3]));
    $('#PONumb').val(decodeURIComponent(aaa[2]));
    $('#formABstatus').val(decodeURIComponent(aaa[3]));
    $('#productLicense').val(decodeURIComponent(aaa[4]));
    
//    $('#paymentterms').val(decodeURIComponent(aaa[5]));
    $('#paymentTermsPO').val(decodeURIComponent(aaa[5]));
    
    $('#SalesManagerName').val(decodeURIComponent(aaa[6]));
    
    $('#ImplementorName').val(decodeURIComponent(ccc[1]));
    $('#ImplementorNumber').val(decodeURIComponent(ccc[0]));
    $('#cusImplementorEmail').val(decodeURIComponent(ccc[2]));    
     $('#EndCustomerName').val(decodeURIComponent(ccc[3]));
     $('#EndCustomerNumber').val(decodeURIComponent(ccc[4]));
     
     
     //08/08
     $('#endCustomer').val(decodeURIComponent(data[3]));
     //
     
     
     
     
     
//     alert(data[3][0]);
     
//     $('#NoOfProductQty').val(decodeURIComponent(data[3][0]));
    
    
    var dataForm = data[1];
    
   
//    alert("sjkdfb  " +dataForm);
    
    jsonImplFormC = data[1];
    
    // Create input fields dynamically
    var inputContainer = document.getElementById("inputContainer");

    dataForm.forEach(function(entry, index) {
    	
    	
        // Create a row for each entry
        var row = document.createElement("div");
        row.className = "row";

        // Create product column
        var productCol = document.createElement("div");
        productCol.className = "col-md-4";
        productCol.style="margin-top: 15px;";

        // Create product label
        var productLabel = document.createElement("label");
        productLabel.innerHTML = "Product Name: ";

        // Create product input field
        var productInput = document.createElement("input");
        productInput.type = "text";
        productInput.className = "form-control form-control-sm";
        productInput.value = entry[0];
        productInput.setAttribute("readonly", "readonly");
        productInput.id = "productName_" + index; // Unique ID for product input

        // Append product label and input field to the product column
     // Append product label and input field to the product column
        productCol.appendChild(productLabel);
        productCol.appendChild(productInput);
    
        
        // Create a row for qty
      
        var qtyRow = document.createElement("div");
        qtyRow.className = "row";

        // Create product column
        var productQty = document.createElement("div");
        productQty.className = "col-md-4";
        productQty.style="margin-top: 15px;";

        // Create product label
        var productQtyLabel = document.createElement("label");
        productQtyLabel.innerHTML = "Product Qty: ";

        // Create product input field
        var productQtyInput = document.createElement("input");
        productQtyInput.type = "text";
        productQtyInput.className = "form-control form-control-sm";
        productQtyInput.value = entry[2];
        productQtyInput.setAttribute("readonly", "readonly");
        productQtyInput.id = "productQty_" + index; // Unique ID for product input

        // Append product label and input field to the product column
        productQty.appendChild(productQtyLabel);
        productQty.appendChild(productQtyInput);

        
        
        
        
        
        // Create space column
//        var spaceCol = document.createElement("div");
//        spaceCol.className = "col-md-1"; // Empty column for space

        // Create implementor name column
        var implementorCol = document.createElement("div");
        implementorCol.className = "col-md-4";
        implementorCol.style="margin-top: 15px;";

        // Create implementor name label
        var implementorLabel = document.createElement("label");
        implementorLabel.innerHTML = "Product Manager Name: ";

        // Create implementor name input field
        var implementorInput = document.createElement("input");
        implementorInput.type = "text";
        implementorInput.className = "form-control form-control-sm";
        implementorInput.value = entry[1];
        implementorInput.setAttribute("readonly", "readonly");
        implementorInput.id = "implementorName_" + index; // Unique ID for implementor name input

        // Append implementor name label and input field to the implementor name column
        implementorCol.appendChild(implementorLabel);
        implementorCol.appendChild(implementorInput);
        
        
        
        
      
        

        // Append product column, space column, and implementor name column to the row
        row.appendChild(productCol);
        row.appendChild(productQty);
        row.appendChild(implementorCol);

        // Append the row to the input container
        inputContainer.appendChild(row);

        // Add some space between input field sets
//        inputContainer.appendChild(document.createElement("br"));
//        inputContainer.appendChild(document.createElement("br"));
    });
 
           
//alert(jsonImplFormC);
	    });
	
}

function maskedPOStandard() {
	var filename = encodeURIComponent($('#filnameMaskedPO').val());
	// //alert(filename);
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}
function productFeaturedStandard() {
	var filename = $('#filnameProductFeatured').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}
$("#submit-btnnn").click(function () {
	
	  var momentAdb = moment($('#startdate').val(),"DD-MM-YYYY");
	    var momentBcd =moment($('#enddate').val(),"DD-MM-YYYY");
	    
	    var momentc = moment($('#startdatevlxlicense').val(),"DD-MM-YYYY");
	    var momentd =moment($('#enddatevlxlicense').val(),"DD-MM-YYYY");
	    
	    var momente = moment($('#startdateuattesting').val(),"DD-MM-YYYY");
	    var momentf =moment($('#enddateuattesting').val(),"DD-MM-YYYY");
	    
	    var momentg = moment($('#startdategolive').val(),"DD-MM-YYYY");
	    var momenth =moment($('#enddategolive').val(),"DD-MM-YYYY");
	    
	    var momenti = moment($('#startdaterollout').val(),"DD-MM-YYYY");
	    var momentj =moment($('#enddaterollout').val(),"DD-MM-YYYY");
	    
	    var momentk = moment($('#startdatedemo').val(),"DD-MM-YYYY");
	    
	    var momentl =moment($('#enddatedemo').val(),"DD-MM-YYYY");
	    
	    var momentm = moment($('#startdatepaymentterms').val(),"DD-MM-YYYY");
	    var momentn =moment($('#enddatepaymentterms').val(),"DD-MM-YYYY");
	    
	    var momento = moment($('#startdatesignoff').val(),"DD-MM-YYYY");
	    var momentp =moment($('#enddatesignoff').val(),"DD-MM-YYYY");
	    
	    

	    if (momentAdb > momentBcd ||momentc > momentd ||momente > momentf ||momentg > momenth ||momenti > momentj ||momentk > momentl ||momentm > momentn ||momento > momentp){
	    	
	    	swal({
	                    title: "Warning",
	                    text: "Warranty End Date should be Greater than Start Date!",
	                    type: "warning",
	                    width: 300,
	                    allowOutsideClick: false,

	                });
	    	
	     
	         return false;
	    }else{
//	     return true;
	if (!validateEditForm()) {
  event.preventDefault();
} else {
  var checkstatus = $('#formABstatus').val();

  if (checkstatus === 'FORMA/B Submitted') {
      submitPOFormC();
  } else {
      swal({
          title: "Fail!",
          text: "FormA/B Not Submitted",
          type: "error",
          width: 300,
          height: 200,
          confirmButtonClass: "btn btn-success",
          confirmButtonText: "OK",
          // preConfirm : function() {
          // var l = window.location;
          // var base_url = l.protocol + "//" + l.host + "/"
          // + l.pathname.split('/')[1];
          // window.location.href = base_url + "/User/pendingAppr";
          // }
      });
  }
}
	    }
});


function submitPOFormC(){
	
    $('#spin1').show();
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/InsertForm3";
    
    $.ajax({
        url: serviceUrl, 
        type: 'POST',
        data: "crno=" + $('#crnoo').val()
            + "&tid=" + $('#tid').val()
          +  '&date=' + encodeURIComponent($("#date").val())
		+ '&projeimplementorname=' + encodeURIComponent($("#projeimplementorname").val())
		+ '&customername=' + encodeURIComponent($("#customername").val())
		+ '&projectname=' + encodeURIComponent($("#projectname").val())
		+ '&serverAvail=' + encodeURIComponent($("#serverAvail").val())
		+ '&Responsibility=' + encodeURIComponent($("#Responsibility").val())
		+ '&startdate=' + encodeURIComponent($("#startdate").val())
		+ '&enddate=' + encodeURIComponent($("#enddate").val())
		
		+'&installvlxlicense=' + encodeURIComponent($("#installvlxlicense").val())
		+ '&Responsibilityvlxlicense=' + encodeURIComponent($("#Responsibilityvlxlicense").val())
		+ '&startdatevlxlicense=' + encodeURIComponent($("#startdatevlxlicense").val())
		+ '&enddatevlxlicense=' + encodeURIComponent($("#enddatevlxlicense").val())
		+ '&UATTesting=' + encodeURIComponent($("#UATTesting").val())
		+ '&Responsibilityuattesting=' + encodeURIComponent($("#Responsibilityuattesting").val())
		+ '&startdateuattesting=' + encodeURIComponent($("#startdateuattesting").val())
		+ '&enddateuattesting=' + encodeURIComponent($("#enddateuattesting").val())
		            	
		+ '&productiongolive=' + encodeURIComponent($("#productiongolive").val())
		+ '&Responsibilitygolive=' + encodeURIComponent($("#Responsibilitygolive").val())
		+ '&startdategolive=' + encodeURIComponent($("#startdategolive").val())
		+ '&enddategolive=' + encodeURIComponent($("#enddategolive").val())
		+ '&rollout=' + encodeURIComponent($("#rollout").val())
		+ '&Responsibilityrollout=' + encodeURIComponent($("#Responsibilityrollout").val())
		+ '&startdaterollout=' + encodeURIComponent($("#startdaterollout").val())
		+ '&enddaterollout=' + encodeURIComponent($("#enddaterollout").val())

		+ '&demolive=' + encodeURIComponent($("#demolive").val())
		+ '&Responsibilitydemo=' + encodeURIComponent($("#Responsibilitydemo").val())
		+ '&startdatedemo=' + encodeURIComponent($("#startdatedemo").val())
		+ '&enddatedemo=' + encodeURIComponent($("#enddatedemo").val())
		+ '&paymentterms=' + encodeURIComponent($("#paymentTermsPO").val())
		+ '&Responsibilitypaymentterms=' + encodeURIComponent($("#Responsibilitypaymentterms").val())
		+ '&startdatepaymentterms=' + encodeURIComponent($("#startdatepaymentterms").val())
		+ '&enddatepaymentterms=' + encodeURIComponent($("#enddatepaymentterms").val())
		
		+ '&signoff=' + encodeURIComponent($("#signoff").val())
		+ '&Responsibilitysignoff=' + encodeURIComponent($("#Responsibilitysignoff").val())
		+ '&startdatesignoff=' + encodeURIComponent($("#startdatesignoff").val())
		+ '&enddatesignoff=' + encodeURIComponent($("#enddatesignoff").val())
		+ '&poNumber=' + encodeURIComponent($("#PONumb").val())
		+ '&productLicense=' + encodeURIComponent($("#productLicense").val())
		+ "&jsonImplFormC=" + jsonImplFormC
		
		
		+ '&ImplementorName=' + encodeURIComponent($("#ImplementorName").val())
		+ '&ImplementorNumber=' + encodeURIComponent($("#ImplementorNumber").val())
		+ '&cusImplementorEmail=' + encodeURIComponent($("#cusImplementorEmail").val())
		+ '&SalesManagerName=' + encodeURIComponent($("#SalesManagerName").val())
		+ '&EndCustomerName=' + encodeURIComponent($("#EndCustomerName").val())
		+ '&EndCustomerNumber=' + encodeURIComponent($("#EndCustomerNumber").val()),
		
              
    }).done(function (data) {
        $('#spin1').hide();
        if (data === "success")
        {
//            swal({
//                title: "Successful!",
//                text: "Document Approved Successfully",
//                type: "success",
//                width: 300,
//                height: 200,
//                confirmButtonClass: "btn btn-success",
//                cancelButtonClass: "btn btn-danger m-l-10",
//                confirmButtonText: "OK",
//                preConfirm: function () {
//                    var l = window.location;
//                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                    window.location.href = base_url + "/User/pendingFORM3";
//                }
//            })
        	

		    swal({
	                    title: "Successful!",
	                    html: "PO ID = " + dataPoId + "<br><br>   Record Added Successfully",
	                    type: "success",
	                    width: 300,
	                    height: 200,
	                    // showCancelButton: !0,
	                    confirmButtonClass: "btn btn-success",
	                    // cancelButtonClass: "btn btn-danger m-l-10",
	                    confirmButtonText: "OK",
	                    preConfirm: function () {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/User/pendingFORM3";
	                    }
	                })
        } else
        {
            swal({
                title: "Fail!",
                text: "Record Added UnSuccessful",
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
                    window.location.href = base_url + "/User/pendingFORM3";
                }

            })
        }


    });
}


function validateEditForm() {
	
	var indexError = 0;
	
	if($('#serverAvail').val().trim() == '') {
		callToolTip1('serverAvail', 'show');
		indexError++;
	}
	
	 if($('#Responsibility').val().trim() == '') {
		callToolTip1('Responsibility', 'show');
		indexError++;
	}
	
	if($('#startdate').val().trim() == '') {
		callToolTip1('startdate', 'show');
		indexError++;
	}
	
	 if($('#enddate').val().trim() == '') {
		callToolTip1('enddate', 'show');
		indexError++;
	}
	 //2
	 
	 if($('#installvlxlicense').val().trim() == '') {
			callToolTip1('installvlxlicense', 'show');
			indexError++;
		}

	 if($('#Responsibilityvlxlicense').val().trim() == '') {
			callToolTip1('Responsibilityvlxlicense', 'show');
			indexError++;
		}
	 
	 if($('#startdatevlxlicense').val().trim() == '') {
			callToolTip1('startdatevlxlicense', 'show');
			indexError++;
		}
	 
	 if($('#enddatevlxlicense').val().trim() == '') {
			callToolTip1('enddatevlxlicense', 'show');
			indexError++;
		}
	
	 //3
	 if($('#UATTesting').val().trim() == '') {
			callToolTip1('UATTesting', 'show');
			indexError++;
		}

	 if($('#Responsibilityuattesting').val().trim() == '') {
			callToolTip1('Responsibilityuattesting', 'show');
			indexError++;
		}
	 
	 if($('#startdateuattesting').val().trim() == '') {
			callToolTip1('startdateuattesting', 'show');
			indexError++;
		}
	 
	 if($('#enddateuattesting').val().trim() == '') {
			callToolTip1('enddateuattesting', 'show');
			indexError++;
		}
	//4
	 if($('#productiongolive').val().trim() == '') {
			callToolTip1('productiongolive', 'show');
			indexError++;
		}

	 if($('#Responsibilitygolive').val().trim() == '') {
			callToolTip1('Responsibilitygolive', 'show');
			indexError++;
		}
	 
	 if($('#startdategolive').val().trim() == '') {
			callToolTip1('startdategolive', 'show');
			indexError++;
		}
	 
	 if($('#enddategolive').val().trim() == '') {
			callToolTip1('enddategolive', 'show');
			indexError++;
		}
	//5
	 if($('#rollout').val().trim() == '') {
			callToolTip1('rollout', 'show');
			indexError++;
		}

	 if($('#Responsibilityrollout').val().trim() == '') {
			callToolTip1('Responsibilityrollout', 'show');
			indexError++;
		}
	 
	 if($('#startdaterollout').val().trim() == '') {
			callToolTip1('startdaterollout', 'show');
			indexError++;
		}
	 
	 if($('#enddaterollout').val().trim() == '') {
			callToolTip1('enddaterollout', 'show');
			indexError++;
		}
	//6
	 if($('#demolive').val().trim() == '') {
			callToolTip1('demolive', 'show');
			indexError++;
		}

	 if($('#Responsibilitydemo').val().trim() == '') {
			callToolTip1('Responsibilitydemo', 'show');
			indexError++;
		}
	 
	 if($('#startdatedemo').val().trim() == '') {
			callToolTip1('startdatedemo', 'show');
			indexError++;
		}
	 
	 if($('#enddatedemo').val().trim() == '') {
			callToolTip1('enddatedemo', 'show');
			indexError++;
		}
	//7
//	 if($('#paymentterms').val().trim() == '') {
//			callToolTip1('paymentterms', 'show');
//			indexError++;
//		}

//	 if($('#Responsibilitypaymentterms').val().trim() == '') {
//			callToolTip1('Responsibilitypaymentterms', 'show');
//			indexError++;
//		}
	 
//	 if($('#startdatepaymentterms').val().trim() == '') {
//			callToolTip1('startdatepaymentterms', 'show');
//			indexError++;
//		}
	 
//	 if($('#enddatepaymentterms').val().trim() == '') {
//			callToolTip1('enddatepaymentterms', 'show');
//			indexError++;
//		}
	//8
	 if($('#signoff').val().trim() == '') {
			callToolTip1('signoff', 'show');
			indexError++;
		}

	 if($('#Responsibilitysignoff').val().trim() == '') {
			callToolTip1('Responsibilitysignoff', 'show');
			indexError++;
		}
	 
	 if($('#startdatesignoff').val().trim() == '') {
			callToolTip1('startdatesignoff', 'show');
			indexError++;
		}
	 
	 if($('#enddatesignoff').val().trim() == '') {
			callToolTip1('enddatesignoff', 'show');
			indexError++;
		}
	
	
	
	if(indexError > 0) {
		return false;
	} else {
		return true;
	}
}

$('#serverAvail').on('focus', function() {
	callToolTip1('serverAvail', 'hide');
})

$('#Responsibility').on('focus', function() {
	callToolTip1('Responsibility', 'hide');
})

$('#startdate').on('focus', function() {
	callToolTip1('startdate', 'hide');
})

$('#enddate').on('focus', function() {
	callToolTip1('enddate', 'hide');
})

//2

$('#installvlxlicense').on('focus', function() {
	callToolTip1('installvlxlicense', 'hide');
})

$('#Responsibilityvlxlicense').on('focus', function() {
	callToolTip1('Responsibilityvlxlicense', 'hide');
})

$('#startdatevlxlicense').on('focus', function() {
	callToolTip1('startdatevlxlicense', 'hide');
})

$('#enddatevlxlicense').on('focus', function() {
	callToolTip1('enddatevlxlicense', 'hide');
})
//3
$('#UATTesting').on('focus', function() {
	callToolTip1('UATTesting', 'hide');
})

$('#Responsibilityuattesting').on('focus', function() {
	callToolTip1('Responsibilityuattesting', 'hide');
})

$('#startdateuattesting').on('focus', function() {
	callToolTip1('startdateuattesting', 'hide');
})

$('#enddateuattesting').on('focus', function() {
	callToolTip1('enddateuattesting', 'hide');
})
//4
$('#productiongolive').on('focus', function() {
	callToolTip1('productiongolive', 'hide');
})

$('#Responsibilitygolive').on('focus', function() {
	callToolTip1('Responsibilitygolive', 'hide');
})

$('#startdategolive').on('focus', function() {
	callToolTip1('startdategolive', 'hide');
})

$('#enddategolive').on('focus', function() {
	callToolTip1('enddategolive', 'hide');
})
//5
$('#rollout').on('focus', function() {
	callToolTip1('rollout', 'hide');
})

$('#Responsibilityrollout').on('focus', function() {
	callToolTip1('Responsibilityrollout', 'hide');
})

$('#startdaterollout').on('focus', function() {
	callToolTip1('startdaterollout', 'hide');
})

$('#enddaterollout').on('focus', function() {
	callToolTip1('enddaterollout', 'hide');
})
//6
$('#demolive').on('focus', function() {
	callToolTip1('demolive', 'hide');
})

$('#Responsibilitydemo').on('focus', function() {
	callToolTip1('Responsibilitydemo', 'hide');
})

$('#startdatedemo').on('focus', function() {
	callToolTip1('startdatedemo', 'hide');
})

$('#enddatedemo').on('focus', function() {
	callToolTip1('enddatedemo', 'hide');
})
//7
$('#paymentterms').on('focus', function() {
	callToolTip1('paymentterms', 'hide');
})

$('#Responsibilitypaymentterms').on('focus', function() {
	callToolTip1('Responsibilitypaymentterms', 'hide');
})

$('#startdatepaymentterms').on('focus', function() {
	callToolTip1('startdatepaymentterms', 'hide');
})

$('#enddatepaymentterms').on('focus', function() {
	callToolTip1('enddatepaymentterms', 'hide');
})
//8
$('#signoff').on('focus', function() {
	callToolTip1('signoff', 'hide');
})

$('#Responsibilitysignoff').on('focus', function() {
	callToolTip1('Responsibilitysignoff', 'hide');
})

$('#startdatesignoff').on('focus', function() {
	callToolTip1('startdatesignoff', 'hide');
})

$('#enddatesignoff').on('focus', function() {
	callToolTip1('enddatesignoff', 'hide');
})
var callToolTip1 = function(fieldName, status) {
	if (fieldName == "serverAvail") {
		var errorMessage = "<span>Please Enter Server Availability<span>";
		
	} if (fieldName == "Responsibility") {
		var errorMessage = "<span>Please Enter Responsibility<span>";
	}
	if (fieldName == "startdate") {
		var errorMessage = "<span>Please Enter Start Date<span>";
	}
	if (fieldName == "enddate") {
		var errorMessage = "<span>Please Enter End Date<span>";
	}
	
	//2
	if (fieldName == "installvlxlicense") {
		var errorMessage = "<span>Please Enter Install Of License <span>";
	}
	if (fieldName == "Responsibilityvlxlicense") {
		var errorMessage = "<span>Please Enter Responsibility<span>";
	}
	if (fieldName == "startdatevlxlicense") {
		var errorMessage = "<span>Please Enter Start Date<span>";
	}
	if (fieldName == "enddatevlxlicense") {
		var errorMessage = "<span>Please Enter End Date<span>";
	}
//3
	if (fieldName == "UATTesting") {
		var errorMessage = "<span>Please Enter UAT Testing<span>";
		
	} if (fieldName == "Responsibilityuattesting") {
		var errorMessage = "<span>Please Enter Responsibility<span>";
	}
	if (fieldName == "startdateuattesting") {
		var errorMessage = "<span>Please Enter Start Date<span>";
	}
	if (fieldName == "enddateuattesting") {
		var errorMessage = "<span>Please Enter End Date<span>";
	}
	//4
	if (fieldName == "productiongolive") {
		var errorMessage = "<span>Please Enter Production GO Live<span>";
		
	} if (fieldName == "Responsibilitygolive") {
		var errorMessage = "<span>Please Enter Responsibility<span>";
	}
	if (fieldName == "startdategolive") {
		var errorMessage = "<span>Please Enter Start Date<span>";
	}
	if (fieldName == "enddategolive") {
		var errorMessage = "<span>Please Enter End Date<span>";
	}
	//5
	if (fieldName == "rollout") {
		var errorMessage = "<span>Please Enter rollout<span>";
		
	} if (fieldName == "Responsibilityrollout") {
		var errorMessage = "<span>Please Enter Responsibility<span>";
	}
	if (fieldName == "startdaterollout") {
		var errorMessage = "<span>Please Enter Start Date<span>";
	}
	if (fieldName == "enddaterollout") {
		var errorMessage = "<span>Please Enter End Date<span>";
	}
	//6
	if (fieldName == "demolive") {
		var errorMessage = "<span>Please Enter Server Availability<span>";
		
	} if (fieldName == "Responsibilitydemo") {
		var errorMessage = "<span>Please Enter Responsibility<span>";
	}
	if (fieldName == "startdatedemo") {
		var errorMessage = "<span>Please Enter Start Date<span>";
	}
	if (fieldName == "enddatedemo") {
		var errorMessage = "<span>Please Enter End Date<span>";
	}
	//7
	if (fieldName == "paymentterms") {
		var errorMessage = "<span>Please Enter Payment Terms<span>";
		
	} if (fieldName == "Responsibilitypaymentterms") {
		var errorMessage = "<span>Please Enter Responsibility<span>";
	}
	if (fieldName == "startdatepaymentterms") {
		var errorMessage = "<span>Please Enter Start Date<span>";
	}
	if (fieldName == "enddatepaymentterms") {
		var errorMessage = "<span>Please Enter End Date<span>";
	}
	//8
	if (fieldName == "signoff") {
		var errorMessage = "<span>Please Enter Sign Off<span>";
		
	} if (fieldName == "Responsibilitysignoff") {
		var errorMessage = "<span>Please Enter Responsibility<span>";
	}
	if (fieldName == "startdatesignoff") {
		var errorMessage = "<span>Please Enter Start Date<span>";
	}
	if (fieldName == "enddatesignoff") {
		var errorMessage = "<span>Please Enter End Date<span>";
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



function Resetall(){
	callToolTip1('serverAvail', 'destroy');
	$("#serverAvail").val('').trigger('change');
	
	callToolTip1('Responsibility', 'destroy');
	$("#Responsibility").val('').trigger('change');
	
	callToolTip1('startdate', 'destroy');
	$("#startdate").val('').trigger('change');
	
	callToolTip1('enddate', 'destroy');
	$("#enddate").val('').trigger('change');
	//2
	callToolTip1('installvlxlicense', 'destroy');
	$("#installvlxlicense").val('').trigger('change');
	
	callToolTip1('Responsibilityvlxlicense', 'destroy');
	$("#Responsibilityvlxlicense").val('').trigger('change');
	
	callToolTip1('startdatevlxlicense', 'destroy');
	$("#startdatevlxlicense").val('').trigger('change');
	
	callToolTip1('enddatevlxlicense', 'destroy');
	$("#enddatevlxlicense").val('').trigger('change');
//3	
	callToolTip1('UATTesting', 'destroy');
	$("#UATTesting").val('').trigger('change');
	
	callToolTip1('Responsibilityuattesting', 'destroy');
	$("#Responsibilityuattesting").val('').trigger('change');
	
	callToolTip1('startdateuattesting', 'destroy');
	$("#startdateuattesting").val('').trigger('change');
	
	callToolTip1('enddateuattesting', 'destroy');
	$("#enddateuattesting").val('').trigger('change');
//4	
	callToolTip1('productiongolive', 'destroy');
	$("#productiongolive").val('').trigger('change');
	
	callToolTip1('Responsibilitygolive', 'destroy');
	$("#Responsibilitygolive").val('').trigger('change');
	
	callToolTip1('startdategolive', 'destroy');
	$("#startdategolive").val('').trigger('change');
	
	callToolTip1('enddategolive', 'destroy');
	$("#enddategolive").val('').trigger('change');
//5	
	callToolTip1('rollout', 'destroy');
	$("#rollout").val('').trigger('change');
	
	callToolTip1('Responsibilityrollout', 'destroy');
	$("#Responsibilityrollout").val('').trigger('change');
	
	callToolTip1('startdaterollout', 'destroy');
	$("#startdaterollout").val('').trigger('change');
	
	callToolTip1('enddaterollout', 'destroy');
	$("#enddaterollout").val('').trigger('change');
//6	
	callToolTip1('demolive', 'destroy');
	$("#demolive").val('').trigger('change');
	
	callToolTip1('Responsibilitydemo', 'destroy');
	$("#Responsibilitydemo").val('').trigger('change');
	
	
	callToolTip1('startdatedemo', 'destroy');
	$("#startdatedemo").val('').trigger('change');

	callToolTip1('enddatedemo', 'destroy');
	$("#enddatedemo").val('').trigger('change');
//7
	
	
	callToolTip1('Responsibilitypaymentterms', 'destroy');
	$("#Responsibilitypaymentterms").val('').trigger('change');
	
	callToolTip1('startdatepaymentterms', 'destroy');
	$("#startdatepaymentterms").val('').trigger('change');
	
	callToolTip1('enddatepaymentterms', 'destroy');
	$("#enddatepaymentterms").val('').trigger('change');
//8	
	callToolTip1('signoff', 'destroy');
	$("#signoff").val('').trigger('change');
	
	callToolTip1('Responsibilitysignoff', 'destroy');
	$("#Responsibilitysignoff").val('').trigger('change');
	
	callToolTip1('startdatesignoff', 'destroy');
	$("#startdatesignoff").val('').trigger('change');
	
	callToolTip1('enddatesignoff', 'destroy');
	$("#enddatesignoff").val('').trigger('change');
	
}