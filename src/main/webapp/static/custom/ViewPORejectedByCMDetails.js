/**
 * 
 */

var dataPoId = $('#crnoo').val();
//var productName = null;

var jsonImplFormC = null;

window.onload = function() {

	// sm names

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getAllUserDetails";

	$.ajax({

		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
	}).done(function(data) {

		// console.log("nnnnnnnnn" + JSON.stringify(data))

		// alert(data[0]["PHONE"]);
		// alert( data[0]["FULLNAME"] );

		$('#salemangname').val(data[0]["FULLNAME"]);

	});

	$('.nav-tabs a').click(function() {
		$(this).tab('show');
	});

	statusCI = $('#statusCI').val();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getMakerName";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {

						// alert(data);

						var html = " <select class='form-control' tabindex='8' id='salemangname' name='salemangname'>";
						html = html
								+ '<option value="">--   Please Select   --</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}

						document.getElementById("salemangname").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getDataSaleMngFormABDetails";

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "crno=" + $('#crnoo').val() + '&tid=' + $("#tid").val()
			})
			.done(
					function(data) {

						var aaa = data[0];
						console.log(data)
						// alert("hhhhh"+data[0][0])

						// $('#pouploadfile').val(data[0][0]);

						if ((decodeURIComponent(aaa[0]) == "File Not Attached")
								|| (decodeURIComponent(aaa[0]) == "NA")
								|| (decodeURIComponent(aaa[0]) == "null")) {
							$('#downHidepofile').hide();
						} else {
							document.getElementById('pouploadfile').innerHTML = decodeURIComponent(aaa[0]);
							document.getElementById('filenameStandard').value = decodeURIComponent(aaa[0]);
							$('#poUploadDiv').show();
						}

						if ((decodeURIComponent(aaa[23]) === "File Not Attached")
								|| (decodeURIComponent(aaa[23]) === "NA")) {
							$('#downHideproposalfile').hide();
						} else {
							document.getElementById('proposalfile').innerHTML = decodeURIComponent(aaa[23]);
							document.getElementById('filnameProposal').value = decodeURIComponent(aaa[23]);
							$('#proposalUploadDiv').show();
						}

						
						if ((decodeURIComponent(aaa[29]) === "File Not Attached") || (decodeURIComponent(aaa[29]) === "NA")
								|| (decodeURIComponent(aaa[29]) === "") ) {
							$('#downHidemaskedPOfile').hide();
						} else {
							document.getElementById('maskedPOfile').innerHTML = decodeURIComponent(aaa[29]);
							document.getElementById('filnameMaskedPO').value = decodeURIComponent(aaa[29]);
							$('#maskedPOUploadDiv').show();
						}
						
						if ((decodeURIComponent(aaa[30]) === "File Not Attached") || (decodeURIComponent(aaa[30]) === "NA")
								|| (decodeURIComponent(aaa[30]) === "") ) {
							$('#downHideproductFeaturedfile').hide();
						} else {
							document.getElementById('productFeaturedFile').innerHTML = decodeURIComponent(aaa[30]);
							document.getElementById('filnameProductFeatured').value = decodeURIComponent(aaa[30]);
							$('#productFeaturedUploadDiv').show();
						}
						
						
						$('#potype').val(decodeURIComponent(aaa[15]));

						if (decodeURIComponent(aaa[15]) === "Product/Software PO") {
							// alert("in if")
							$("#FormsABdiv").css("display", "block");
						} else {
							// alert("IN ELSE")
							$("#FormsABdiv").css("display", "none");
						}
						
						
						$('#ponumber').val(decodeURIComponent(aaa[16]));
						$('#podate').val(decodeURIComponent(aaa[17]));

						$('#proddescrip').val(decodeURIComponent(data[0][1]));
						$('#customername').val(decodeURIComponent(data[0][2]));
						$('#paymentterms').val(decodeURIComponent(aaa[3]));
						$('#prodliscense').val(decodeURIComponent(aaa[4]));
						$('#prodamount').val(decodeURIComponent(aaa[5]));

						if (decodeURIComponent(aaa[6]) === 'NA') {
							$('#warrantystartDiv').hide();
						} else {

							$('#warrantystart').val(decodeURIComponent(aaa[6]));
							$('#warrantystartDiv').show();
						}
						if (decodeURIComponent(aaa[7]) === 'NA') {

							$('#warrantyendDiv').hide();
						} else {
							$('#warrantyend').val(decodeURIComponent(aaa[7]));
							$('#warrantyendDiv').show();
						}

						if (decodeURIComponent(aaa[8]) === 'NA') {
							$('#amcstartdateDiv').hide();
						} else {
							$('#amcstartdate').val(decodeURIComponent(aaa[8]));
							$('#amcstartdateDiv').show();
						}
						if (decodeURIComponent(aaa[9]) === 'NA') {
							$('#amcenddateDiv').hide();
						} else {
							$('#amcenddate').val(decodeURIComponent(aaa[9]));
							$('#amcenddateDiv').show();
						}

						$('#advaninvoice').val(decodeURIComponent(aaa[10]));

						// alert(aaa[54]);
						if ((decodeURIComponent(aaa[11]) == "File Not Attached")
								|| (decodeURIComponent(aaa[11]) == "NA")
								|| (decodeURIComponent(aaa[11]) == "null")) {
							$('#downHideadvInvfile').hide();
						} else {
							document.getElementById('advinvoicefile').innerHTML = decodeURIComponent(aaa[11]);
							document.getElementById('filnameAdvinvoice').value = decodeURIComponent(aaa[11]);
							$('#advInvoiceUploadDiv').show();
						}

						$('#dateforma').val(decodeURIComponent(aaa[17]));

						$('#form2date').val(decodeURIComponent(aaa[17]));
						$('#form2customername').val(
								decodeURIComponent(data[0][2]));

						$('#formApoNo').val(decodeURIComponent(aaa[16]));
						$('#poform2No').val(decodeURIComponent(aaa[16]));

						$('#form3status').val(decodeURIComponent(aaa[22]));

						$('#productSuit').val(decodeURIComponent(aaa[24]));
						$('#securityTools').val(decodeURIComponent(aaa[25]));
					
						if ((decodeURIComponent(aaa[26]) === 'NA') || (decodeURIComponent(aaa[26]) === '')) {
							$('#tennurestartdateDiv').hide();
						} else {
							$('#tennurestartdate').val(decodeURIComponent(aaa[26]));
							$('#tennurestartdateDiv').show();
						}
						if ((decodeURIComponent(aaa[27]) === 'NA') || (decodeURIComponent(aaa[26]) === '')) {
							$('#tennureenddateDiv').hide();
						} else {
							$('#tennureenddate').val(decodeURIComponent(aaa[27]));
							$('#tennureenddateDiv').show();
						}
						
						if (decodeURIComponent(aaa[28]) === 'NA') {
							$('#SInoteDiv').hide();
						} else {
							$('#SInote').val(decodeURIComponent(aaa[28]));
							$('#SInoteDiv').show();
						}
						
						
						
//						var productName = decodeURIComponent(aaa[24]).toString();
//						var ppp = productName.split(',');
//
//						$('#productName').val(ppp[0]);
					//	$('#productToolName').val(ppp[1]);
						
						var dataForm = data[1];
						
						jsonImplFormC = data[1];
						
						//alert("data "+data);
//						alert(jsonImplFormC);
						   // Create input fields dynamically
					    var inputContainer = document.getElementById("inputContainer");

					    dataForm.forEach(function(entry, index) {
					        // Create a row for each entry
					        var row = document.createElement("div");
					        row.className = "row";

					        // Create product column
					        var productCol = document.createElement("div");
					        productCol.className = "col-md-6";
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
					        productCol.appendChild(productLabel);
					        productCol.appendChild(productInput);

					        // Create space column
//					        var spaceCol = document.createElement("div");
//					        spaceCol.className = "col-md-1"; // Empty column for space

					        // Create implementor name column
					        var implementorCol = document.createElement("div");
					        implementorCol.className = "col-md-6";
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
//					        row.appendChild(spaceCol);
					        row.appendChild(implementorCol);

					        // Append the row to the input container
					        inputContainer.appendChild(row);

					        // Add some space between input field sets
//					        inputContainer.appendChild(document.createElement("br"));
//					        inputContainer.appendChild(document.createElement("br"));
					    });
	
                 });
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getApprovaalCollnMangData";

	
	$.ajax({
		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : "crno=" + $('#crnoo').val() + '&tid=' + $("#tid").val()
	}).done(function(data) {
//    alert("data "+data)
		var aaa = data[0];
		// alert(aaa[25]);
		// console.log(data);

		$('#distributorpartyname').val(decodeURIComponent(aaa[25]));
		$('#distributorprojectname').val(decodeURIComponent(aaa[26]));
		$('#distributortechpersonname').val(decodeURIComponent(aaa[27]));
		$('#distributorprsndesignation').val(decodeURIComponent(aaa[28]));
		$('#distributorcontactnumber').val(decodeURIComponent(aaa[29]));
		$('#distributoremailid').val(decodeURIComponent(aaa[30]));

		$('#partnerpartyname').val(decodeURIComponent(aaa[31]));
		$('#partnerprojectname').val(decodeURIComponent(aaa[32]));
		$('#partnertechpersonname').val(decodeURIComponent(aaa[33]));
		$('#partnerprsndesignation').val(decodeURIComponent(aaa[34]));
		$('#partnercontactnumber').val(decodeURIComponent(aaa[35]));
		$('#partneremailid').val(decodeURIComponent(aaa[36]));

		$('#customerpartyname').val(decodeURIComponent(aaa[37]));
		$('#customerprojectname').val(decodeURIComponent(aaa[38]));
		$('#customertechpersonname').val(decodeURIComponent(aaa[39]));
		$('#customerprsndesignation').val(decodeURIComponent(aaa[40]));
		$('#customercontactnumber').val(decodeURIComponent(aaa[41]));
		$('#customeremailid').val(decodeURIComponent(aaa[42]));

		$('#endcustomerpartyname').val(decodeURIComponent(aaa[43]));
		$('#endcustomerprojectname').val(decodeURIComponent(aaa[44]));
		$('#endcustomertechpersonname').val(decodeURIComponent(aaa[45]));
		$('#endcustomerprsndesignation').val(decodeURIComponent(aaa[46]));
		$('#endcustomercontactnumber').val(decodeURIComponent(aaa[47]));
		$('#endcustomeremailid').val(decodeURIComponent(aaa[48]));

		$('#implementorpartyname').val(decodeURIComponent(aaa[49]));
		$('#implementorprojectname').val(decodeURIComponent(aaa[50]));
		$('#implementortechpersonname').val(decodeURIComponent(aaa[51]));
		$('#implementorprsndesignation').val(decodeURIComponent(aaa[52]));
		$('#implementorcontactnumber').val(decodeURIComponent(aaa[53]));
		$('#implementoremailid').val(decodeURIComponent(aaa[54]));

		$('#form2date').val(decodeURIComponent(aaa[55]));
		$('#form2customername').val(decodeURIComponent(aaa[56]));
		$('#poform2No').val(decodeURIComponent(aaa[57]));
		$('#potimeline').val(decodeURIComponent(aaa[58]));
		$('#RPFTIMELINES').val(decodeURIComponent(aaa[59]));
		$('#firstinvoicegeneratedate').val(decodeURIComponent(aaa[60]));
		$('#projstartdate').val(decodeURIComponent(aaa[61]));
		$('#projenddate').val(decodeURIComponent(aaa[62]));
		$('#pymentterms').val(decodeURIComponent(aaa[63]));
		$('#projecthead').val(decodeURIComponent(aaa[64]));
		$('#flowchartpaymnetid').val(decodeURIComponent(aaa[65]));

		if (decodeURIComponent(aaa[65]) === 'Yes') {
			$('#remarksid').show();
			$('#Remarks').val(decodeURIComponent(aaa[66]));
		} else {

			$('#remarksid').hide();
		}

	});

	
	
	
	
	
	
	

}
function chartpaymntYes() {

	// callToolTip231('Remarks', 'destroy');
//	var radiosss = $('#flowchartpaymnetid').val();

	if ($('#flowchartpaymnetid').val() === "Yes") {
		$('#remarksid').show();

	} else {

		$('#remarksid').hide();

	}

}
function proposalStandard() {
	var filename = encodeURIComponent($('#filnameProposal').val());
	// alert(filename);
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
function downFileStandard() {
	var filename = encodeURIComponent($('#filenameStandard').val());
	// alert(filename);
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}
function advInvFileStandard() {
	var filename = encodeURIComponent($('#filnameAdvinvoice').val());

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}
function maskedPOStandard() {
	var filename = encodeURIComponent($('#filnameMaskedPO').val());
	// //alert(filename);
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}

$("#SubmitABform").click(function() {


	var poTypes = $("#potype").val();
	 if ( poTypes === "Product/Software PO") {
	 // alert("adau not sajxb")
		 validatepurchaseorder();
		 event.preventDefault();
	 } else {
	approvepurchaseorder();
	// alert("data Saved")
	 }
	
	
	
});

function validatepurchaseorder() {
	 
	if (
    ($('#distributorpartyname').val() == '' ||
    $('#distributorprojectname').val() == '' ||
    $('#distributortechpersonname').val() == '' ||
    $('#distributorprsndesignation').val() == '' ||
    $('#distributorcontactnumber').val() == '' ||
    $('#distributoremailid').val() == '') &&
    
    ($('#partnerpartyname').val() == '' ||
    $('#partnerprojectname').val() == '' ||
    $('#partnertechpersonname').val() == '' ||
    $('#partnerprsndesignation').val() == '' ||
    $('#partnercontactnumber').val() == '' ||
    $('#partneremailid').val() == '') &&
    
    ($('#customerpartyname').val() == '' ||
    $('#customerprojectname').val() == '' ||
    $('#customertechpersonname').val() == '' ||
    $('#customerprsndesignation').val() == '' ||
    $('#customercontactnumber').val() == '' ||
    $('#customeremailid').val() == '') &&
    
    ($('#endcustomerpartyname').val() == '' ||
    $('#endcustomerprojectname').val() == '' ||
    $('#endcustomertechpersonname').val() == '' ||
    $('#endcustomerprsndesignation').val() == '' ||
    $('#endcustomercontactnumber').val() == '' ||
    $('#endcustomeremailid').val() == '') &&
    
    ($('#implementorpartyname').val() == '' ||
    $('#implementorprojectname').val() == '' ||
    $('#implementortechpersonname').val() == '' ||
    $('#implementorprsndesignation').val() == '' ||
    $('#implementorcontactnumber').val() == '' ||
    $('#implementoremailid').val() == '')
) {
    $('#messageSpan').text('*At least one field details should be filled.').css('color', 'red');
//    alert("NI3");
} else {
    $('#messageSpan').hide();
}

    var indexError = 0;
    
    if ($('#potimeline').val().trim() === '') {
    	
       callToolTip231('potimeline', 'show');
       indexError = indexError + 1;
    }
 
    if ($('#RPFTIMELINES').val().trim() === '') {
    	
        callToolTip231('RPFTIMELINES', 'show');
        indexError = indexError + 1;
        
     }
    
    if ($('#firstinvoicegeneratedate').val().trim() === '') {
    	
        callToolTip231('firstinvoicegeneratedate', 'show');
        indexError = indexError + 1;
     }
    
    if ($('#projstartdate').val().trim() === '') {
    	
        callToolTip231('projstartdate', 'show');
        indexError = indexError + 1;
     }
    
  if ($('#projenddate').val().trim() === '') {
    	
        callToolTip231('projenddate', 'show');
        indexError = indexError + 1;
     }
  
  if ($('#pymentterms').val().trim() === '') {
  	
      callToolTip231('pymentterms', 'show');
      indexError = indexError + 1;
   }
  
  if ($('#projecthead').val().trim() === '') {
	  	
      callToolTip231('projecthead', 'show');
      indexError = indexError + 1;
   }

  if ($('#flowchartpaymnetid').val().trim() === '') {
	  	
      callToolTip231('flowchartpaymnetid', 'show');
      indexError = indexError + 1;
   }
  else if($('#flowchartpaymnetid').val() === 'Yes'){
	  
	  if ($('#Remarks').val().trim() === '') {
		  	
	      callToolTip231('Remarks', 'show');
	      indexError = indexError + 1;
	   }
	   
   }
  
  
  
  
  
  
  
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}

function approvepurchaseorder() {
					
					
					var momentAdb = moment($('#projstartdate').val(),"DD-MM-YYYY");
				    var momentBcd =moment($('#projenddate').val(),"DD-MM-YYYY");
				    
				    

				    if (momentAdb > momentBcd){
				    	
				    	swal({
				                    title: "Warning",
				                    text: "Warranty End Date should be Greater than Start Date!",
				                    type: "warning",
				                    width: 300,
				                    allowOutsideClick: false,
				                    
				                    
				                    
				                    

				                });
				    	
				     
				         return false;
				    }else{
					$('#spin1').show();

					

					var l = window.location;
					var base_url = l.protocol + "//" + l.host + "/"
							+ l.pathname.split('/')[1];
					var serviceUrl = base_url + "/UserActivity/insertPOFormAB";

					var serviceUrl = serviceUrl;
					$
							.ajax(
									{
										type : 'POST',
										url : serviceUrl,
										data : 'dateforma='
												+ $("#dateforma").val()
												+ '&salemangname='
												+ $("#salemangname").val()
												+ '&formApoNo='
												+ $("#formApoNo").val()

												+ '&distributorpartyname='
												+ $("#distributorpartyname")
														.val()
												+ '&distributorprojectname='
												+ $("#distributorprojectname")
														.val()
												+ '&distributortechpersonname='
												+ $(
														"#distributortechpersonname")
														.val()
												+ '&distributorprsndesignation='
												+ $(
														"#distributorprsndesignation")
														.val()
												+ '&distributorcontactnumber='
												+ $("#distributorcontactnumber")
														.val()
												+ '&distributoremailid='
												+ $("#distributoremailid")
														.val()

												+ '&partnerpartyname='
												+ $("#partnerpartyname").val()
												+ '&partnerprojectname='
												+ $("#partnerprojectname")
														.val()
												+ '&partnertechpersonname='
												+ $("#partnertechpersonname")
														.val()
												+ '&partnerprsndesignation='
												+ $("#partnerprsndesignation")
														.val()
												+ '&partnercontactnumber='
												+ $("#partnercontactnumber")
														.val()
												+ '&partneremailid='
												+ $("#partneremailid").val()

												+ '&customerpartyname='
												+ $("#customerpartyname").val()
												+ '&customerprojectname='
												+ $("#customerprojectname")
														.val()
												+ '&customertechpersonname='
												+ $("#customertechpersonname")
														.val()
												+ '&customerprsndesignation='
												+ $("#customerprsndesignation")
														.val()
												+ '&customercontactnumber='
												+ $("#customercontactnumber")
														.val()
												+ '&customeremailid='
												+ $("#customeremailid").val()

												+ '&implementorpartyname='
												+ $("#implementorpartyname")
														.val()
												+ '&implementorprojectname='
												+ $("#implementorprojectname")
														.val()
												+ '&implementortechpersonname='
												+ $(
														"#implementortechpersonname")
														.val()
												+ '&implementorprsndesignation='
												+ $(
														"#implementorprsndesignation")
														.val()
												+ '&implementorcontactnumber='
												+ $("#implementorcontactnumber")
														.val()
												+ '&implementoremailid='
												+ $("#implementoremailid")
														.val()
														
														
														
														+ '&endcustomerpartyname='
												+ $("#endcustomerpartyname")
														.val()
												+ '&endcustomerprojectname='
												+ $("#endcustomerprojectname")
														.val()
												+ '&endcustomertechpersonname='
												+ $(
														"#endcustomertechpersonname")
														.val()
												+ '&endcustomerprsndesignation='
												+ $(
														"#endcustomerprsndesignation")
														.val()
												+ '&endcustomercontactnumber='
												+ $("#endcustomercontactnumber")
														.val()
												+ '&endcustomeremailid='
												+ $("#endcustomeremailid")
														.val()

												+ '&form2date='
												+ $("#form2date").val()
												+ '&form2customername='
												+ $("#form2customername").val()
												+ '&RPFTIMELINES='
												+ $("#RPFTIMELINES").val()
												+ '&potimeline='
												+ $("#potimeline").val()
												+ '&firstinvoicegeneratedate='
												+ $("#firstinvoicegeneratedate")
														.val()
												+ '&chartpaymntno='+ $("#flowchartpaymnetid").val()
												+ '&projstartdate='
												+ $("#projstartdate").val()
												+ '&projenddate='
												+ $("#projenddate").val()
												+ '&pymentterms='
												+ $("#pymentterms").val()
												+ '&projecthead='
												+ $("#projecthead").val()
												+ '&poform2No='
												+ $("#poform2No").val()
												+ '&Remarks='
												+ $("#Remarks").val()
												+ "&crno=" + $('#crnoo').val()
												+ "&tid=" + $('#tid').val()
												+ "&jsonImplFormC=" + encodeURIComponent(jsonImplFormC)
												+ "&SMnote=" + $("#SMnote").val(),

									})
							.done(
									function(data) {

										$('#spin1').hide();

										if (data == "success") {
											// swal({
											// title: "Successful!",
											// text: "Record Added
											// Successfully",
											// type: "success",
											// width: 300,
											// height: 200,
											// buttons: false,
											// allowOutsideClick: false,
											// preConfirm: function() {
											// var l = window.location;
											// var base_url = l.protocol + "//"
											// + l.host + "/" +
											// l.pathname.split('/')[1];
											// window.location.href = base_url +
											// "/User/pendingSMFormApp";
											// }
											//
											// });

											swal({
												title : "Successful!",
												html : "PO ID = "
														+ dataPoId
														+ "<br><br>   Record Added Successfully",
												type : "success",
												width : 300,
												height : 200,
												// showCancelButton: !0,
												confirmButtonClass : "btn btn-success",
												// cancelButtonClass: "btn
												// btn-danger m-l-10",
												confirmButtonText : "OK",
												preConfirm : function() {
													var l = window.location;
													var base_url = l.protocol
															+ "//"
															+ l.host
															+ "/"
															+ l.pathname
																	.split('/')[1];
													window.location.href = base_url
															+ "/User/pendingSMFormApp";
												}
											})

										} else if (data == "error") {
											swal({
												title : "Unsuccessful!",
												text : "Fail to add file",
												type : "success",
												width : 300,
												height : 200,
												buttons : false,
												allowOutsideClick : false,
												preConfirm : function() {
													var l = window.location;
													var base_url = l.protocol
															+ "//"
															+ l.host
															+ "/"
															+ l.pathname
																	.split('/')[1];
													window.location.href = base_url
															+ "/User/pendingSMFormApp";
												}

											});

										}
									});
				    }
				};

function myFunctionReject() {
	// alert("cmstatus"+cmstatus)
	swal({
		title : 'Enter Your Feedback',
		input : 'textarea',
		inputPlaceholder : "Enter Your Feedback",
		showCancelButton : true,
		confirmButtonText : 'Submit',
		preConfirm : function(result) {
			// alert("value: "+result)
			return new Promise(
					function(resolve, reject) {

						if (result === "") {
							swal
									.showValidationError('You Need To Write Your Feedback!')

							$('.swal2-confirm').prop('disabled', false);
							$('.swal2-cancel').prop('disabled', false);
							return false;
						} else {
							swal.resetValidationError()
							// alert("value: "+result)
							$('#spin2').show();

							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							var serviceUrl = base_url
									+ "/UserActivity/rejectCMcrf";

							$
									.ajax(
											{
												type : "POST",
												url : serviceUrl,
												data : "val="
														+ encodeURIComponent(result)
														+ "&crno="
														+ $('#crnoo').val()
														+ "&tid="
														+ $('#tid').val()
														+ "&assign="
														+ assign
														+ "&cmstatus="
														+ cmstatus
														+ "&nextUser="
														+ $('#auth123').val()
														+ "&branch="
														+ encodeURIComponent($(
																'#branch')
																.val())
														+ "&category="
														+ $('#category').val()
														+ "&subcategory="
														+ subcategory
														+ "&cmnote="
														+ encodeURIComponent($(
																'#cmnote')
																.val())
														+ "&risktype="
														+ $('#risktype').val(),
											})
									.done(
											function(data) {
												// alert("result=="+data);
												$('#spin2').hide();
												if (data == "success") {
													swal({
														title : "Successful!",
														text : "Feedback Request Sent Successfully",
														type : "success",
														width : 300,
														height : 200,
														confirmButtonClass : "btn btn-success",
														confirmButtonText : "OK",
														preConfirm : function() {
															var l = window.location;
															var base_url = l.protocol
																	+ "//"
																	+ l.host
																	+ "/"
																	+ l.pathname
																			.split('/')[1];
															window.location.href = base_url
																	+ "/CMUser/pendingAppr";
														}
													})
												} else {
													swal({
														title : "Fail!",
														text : "Feedback Request Sent UnSuccessful",
														type : "error",
														width : 300,
														height : 200,
														confirmButtonClass : "btn btn-success",
														confirmButtonText : "OK",
														preConfirm : function() {
															var l = window.location;
															var base_url = l.protocol
																	+ "//"
																	+ l.host
																	+ "/"
																	+ l.pathname
																			.split('/')[1];
															window.location.href = base_url
																	+ "/CMUser/pendingAppr";
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

function resetAll() {
	$('#potimeline').val("");
	$('#RPFTIMELINES').val("");
	$('#firstinvoicegeneratedate').val("");
	$('#projstartdate').val("");
	$('#projenddate').val("");
	$('#pymentterms').val("");
	$('#projecthead').val("");
	$('#').val("");
	$('#Remarks').val("");
	
	callToolTip231('potimeline', 'destroy');
	callToolTip231('RPFTIMELINES', 'destroy');
	callToolTip231('firstinvoicegeneratedate', 'destroy');
	callToolTip231('projstartdate', 'destroy');
	callToolTip231('projenddate', 'destroy');
	callToolTip231('pymentterms', 'destroy');
	callToolTip231('projecthead', 'destroy');
	callToolTip231('flowchartpaymnetid', 'destroy');
	callToolTip231('Remarks', 'destroy');
	
	chartpaymntYes();
	
}


$('#potimeline').on('focus', function() {
	callToolTip231('potimeline', 'destroy');
	
});
$('#RPFTIMELINES').on('focus', function() {
	callToolTip231('RPFTIMELINES', 'destroy');
	
});
$('#firstinvoicegeneratedate').on('focus', function() {
	callToolTip231('firstinvoicegeneratedate', 'destroy');
	
});
$('#projstartdate').on('focus', function() {
	callToolTip231('projstartdate', 'destroy');
	
});
$('#projenddate').on('focus', function() {
	callToolTip231('projenddate', 'destroy');
	
});
$('#pymentterms').on('focus', function() {
	callToolTip231('pymentterms', 'destroy');
	
});
$('#projecthead').on('focus', function() {
	callToolTip231('projecthead', 'destroy');
	
});
$('#flowchartpaymnetid').on('focus', function() {
	callToolTip231('flowchartpaymnetid', 'destroy');
	
});
$('#Remarks').on('focus', function() {
	callToolTip231('Remarks', 'destroy');
	
});


var callToolTip231 = function(fieldName, status){
	


  
   
    
    if (fieldName == "potimeline") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select PO Timeline <span>";
    }
 
    if (fieldName == "RPFTIMELINES") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select RFP Timeline <span>";
    }
 
    if (fieldName == "firstinvoicegeneratedate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select First Invoice Date <span>";
    }
 
    if (fieldName == "projstartdate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Project Start Date <span>";
    }
 
    if (fieldName == "projenddate") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Project End Date <span>";
    }
 
    if (fieldName == "pymentterms") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Payment Terms <span>";
    }
 
    if (fieldName == "projecthead") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Project Head <span>";
    }
 
    if (fieldName == "flowchartpaymnetid") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Select Payment Terms <span>";
    }
 
    if (fieldName == "Remarks") {
        //$("#email").tooltip('destroy');
        var errorMessage = "<span>Enter Your Remarks <span>";
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



function rejectFunction() {

	swal({
		title : 'Enter Your Reason',
		input : 'textarea',
		inputPlaceholder : "Enter Your Reason",
		showCancelButton : true,
		confirmButtonText : 'Submit',
		preConfirm : function(result) {
//			 alert("value: "+result)
			return new Promise(
					function(resolve, reject) {

						if (result === "") {
							swal
									.showValidationError('You Need To Write Your Reason!')

							$('.swal2-confirm').prop('disabled', false);
							$('.swal2-cancel').prop('disabled', false);
							return false;
						} else {
							swal.resetValidationError()

							$('#spin2').show();

							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							var serviceUrl = base_url
									+ "/UserActivity/SMrejectPO";

							$
									.ajax(
											{
												type : "POST",
												url : serviceUrl,
												data : "val="
														+ encodeURIComponent(result)
														+ "&crno="
														+ $('#crnoo').val()
														+ "&tid="
														+ $('#tid').val()
														+ "&SMnote="
														+ encodeURIComponent($(
																'#SMnote')
																.val()),

											})
									.done(
											function(data) {
												$('#spin2').hide();
												if (data == "success") {
													swal({
														title : "Successful!",
														text : "Purchase Order Rejected Successfully",
														type : "success",
														width : 300,
														height : 200,
														confirmButtonClass : "btn btn-success",
														confirmButtonText : "OK",
														preConfirm : function() {
															var l = window.location;
															var base_url = l.protocol
																	+ "//"
																	+ l.host
																	+ "/"
																	+ l.pathname
																			.split('/')[1];
															window.location.href = base_url
																	+ "/User/pendingSMFormApp";
														}
													})
												} else {
													swal({
														title : "Fail!",
														text : "Purchase Order Rejected UnSuccessful",
														type : "error",
														width : 300,
														height : 200,
														confirmButtonClass : "btn btn-success",
														confirmButtonText : "OK",
														preConfirm : function() {
															var l = window.location;
															var base_url = l.protocol
																	+ "//"
																	+ l.host
																	+ "/"
																	+ l.pathname
																			.split('/')[1];
															window.location.href = base_url
																	+ "/User/pendingSMFormApp";
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