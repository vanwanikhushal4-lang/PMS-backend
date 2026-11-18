/**
 * 
 */

var dataPoId = $('#crnoo').val();

var jsonImplFormC = null;

var data112='';
window.onload = function() {
	

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/UserActivity/getfrom3details";

		$.ajax({
			url : serviceUrl,
			type : 'POST',
			dataType : 'json',
			data : "ponumber=" + dataPoId,

		}).done(function(data) {
			
			if(data.length>0)
				{
				
				
			    $("#tabContent").show()
			     data112=data;
			    
			    	form3data(data112)
				     
				}
	
			
			 
			 
			
			
					})
	
				
	
	
	// form3 data ends

	$('.nav-tabs a').click(function() {
		$(this).tab('show');
	});
		var potype =$('#potype').val();
		// form 3 data start
	

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getApprovaalSaleMngData";

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
						// //alert("hhhhh"+data[0][0])

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

						if ((decodeURIComponent(aaa[17]) === "File Not Attached")
								|| (decodeURIComponent(aaa[17]) === "NA")) {
							$('#downHideproposalfile').hide();
						} else {
							document.getElementById('proposalfile').innerHTML = decodeURIComponent(aaa[17]);
							document.getElementById('filnameProposal').value = decodeURIComponent(aaa[17]);
							$('#proposalUploadDiv').show();
						}

						if ((decodeURIComponent(aaa[70]) === "File Not Attached") || (decodeURIComponent(aaa[70]) === "NA")
								|| (decodeURIComponent(aaa[70]) === "") ) {
							$('#downHidemaskedPOfile').hide();
						} else {
							document.getElementById('maskedPOfile').innerHTML = decodeURIComponent(aaa[70]);
							document.getElementById('filnameMaskedPO').value = decodeURIComponent(aaa[70]);
							$('#maskedPOUploadDiv').show();
						}
						
						if ((decodeURIComponent(aaa[71]) === "File Not Attached") || (decodeURIComponent(aaa[71]) === "NA")
								|| (decodeURIComponent(aaa[71]) === "") ) {
							$('#downHideproductFeaturedfile').hide();
						} else {
							document.getElementById('productFeaturedFile').innerHTML = decodeURIComponent(aaa[71]);
							document.getElementById('filnameProductFeatured').value = decodeURIComponent(aaa[71]);
							$('#productFeaturedUploadDiv').show();
						}
						
						$('#potype').val(decodeURIComponent(aaa[1]));
						
						if (decodeURIComponent(aaa[1]) === "Resources Order"||decodeURIComponent(aaa[1]) === "AMC Order") {
//							 alert("in if")
							 $('#hideformc').hide();
							
							$("#custom-tabs-one-home-tab").css("display", "none");
							$("#custom-tabs-one-messages-tab").css("display", "none");
						} else {
//							 alert("IN ELSE")
							
						}
						
						$('#ponumber').val(decodeURIComponent(aaa[2]));
						$('#podate').val(decodeURIComponent(aaa[3]));

						$('#proddescrip').val(decodeURIComponent(aaa[4]));
						$('#customername').val(decodeURIComponent(aaa[5]));
						$('#productSuit').val(decodeURIComponent(aaa[6]));
						$('#securityTools').val(decodeURIComponent(aaa[7]));
						$('#paymentterms').val(decodeURIComponent(aaa[8]));
						$('#prodliscense').val(decodeURIComponent(aaa[9]));
						$('#prodamount').val(decodeURIComponent(aaa[10]));

						if (decodeURIComponent(aaa[11]) === 'NA') {
							$('#warrantystartDiv').hide();
						} else {

							$('#warrantystart').val(decodeURIComponent(aaa[11]));
							$('#warrantystartDiv').show();
						}
						if (decodeURIComponent(aaa[12]) === 'NA') {

							$('#warrantyendDiv').hide();
						} else {
							$('#warrantyend').val(decodeURIComponent(aaa[12]));
							$('#warrantyendDiv').show();
						}

						if (decodeURIComponent(aaa[13]) === 'NA') {
							$('#amcstartdateDiv').hide();
						} else {
							$('#amcstartdate').val(decodeURIComponent(aaa[13]));
							$('#amcstartdateDiv').show();
						}
						if (decodeURIComponent(aaa[14]) === 'NA') {
							$('#amcenddateDiv').hide();
						} else {
							$('#amcenddate').val(decodeURIComponent(aaa[14]));
							$('#amcenddateDiv').show();
						}

						if ((decodeURIComponent(aaa[15]) === 'NA') || (decodeURIComponent(aaa[15]) === '')) {
							$('#tennurestartdateDiv').hide();
						} else {
							$('#tennurestartdate').val(decodeURIComponent(aaa[15]));
							$('#tennurestartdateDiv').show();
						}
						if ((decodeURIComponent(aaa[16]) === 'NA') || (decodeURIComponent(aaa[16]) === '')) {
							$('#tennureenddateDiv').hide();
						} else {
							$('#tennureenddate').val(decodeURIComponent(aaa[16]));
							$('#tennureenddateDiv').show();
						}
						//$('#advaninvoice').val(decodeURIComponent(aaa[10]));

						// //alert(aaa[54]);
//						if ((decodeURIComponent(aaa[11]) == "File Not Attached")
//								|| (decodeURIComponent(aaa[11]) == "NA")
//								|| (decodeURIComponent(aaa[11]) == "null")) {
//							$('#downHideadvInvfile').hide();
//						} else {
//							document.getElementById('advinvoicefile').innerHTML = decodeURIComponent(aaa[11]);
//							document.getElementById('filnameAdvinvoice').value = decodeURIComponent(aaa[11]);
//							$('#advInvoiceUploadDiv').show();
//						}

						if (decodeURIComponent(aaa[20]) === 'NA') {
							$('#SInoteDiv').hide();
						} else {
							$('#SInote').val(decodeURIComponent(aaa[20]));
							$('#SInoteDiv').show();
						}
						if (decodeURIComponent(aaa[21]) === 'NA') {
							$('#SMnoteDiv').hide();
						} else {
							$('#SMnote').val(decodeURIComponent(aaa[21]));
							$('#SMnoteDiv').show();
						}
						$('#formApoNo').val(decodeURIComponent(aaa[22]));
						$('#dateforma').val(decodeURIComponent(aaa[23]));
						$('#salemangname').val(decodeURIComponent(aaa[24]));
						
						$('#distributorpartyname').val(
								decodeURIComponent(aaa[25]));
						$('#distributorprojectname').val(
								decodeURIComponent(aaa[26]));
						$('#distributortechpersonname').val(
								decodeURIComponent(aaa[27]));
						$('#distributorprsndesignation').val(
								decodeURIComponent(aaa[28]));
						$('#distributorcontactnumber').val(
								decodeURIComponent(aaa[29]));
						$('#distributoremailid').val(
								decodeURIComponent(aaa[30]));

						$('#partnerpartyname').val(decodeURIComponent(aaa[31]));
						$('#partnerprojectname').val(
								decodeURIComponent(aaa[32]));
						$('#partnertechpersonname').val(
								decodeURIComponent(aaa[33]));
						$('#partnerprsndesignation').val(
								decodeURIComponent(aaa[34]));
						$('#partnercontactnumber').val(
								decodeURIComponent(aaa[35]));
						$('#partneremailid').val(decodeURIComponent(aaa[36]));

						$('#customerpartyname')
								.val(decodeURIComponent(aaa[37]));
						$('#customerprojectname').val(
								decodeURIComponent(aaa[38]));
						$('#customertechpersonname').val(
								decodeURIComponent(aaa[39]));
						$('#customerprsndesignation').val(
								decodeURIComponent(aaa[40]));
						$('#customercontactnumber').val(
								decodeURIComponent(aaa[41]));
						$('#customeremailid').val(decodeURIComponent(aaa[42]));

						
						$('#endcustomerpartyname')
						.val(decodeURIComponent(aaa[43]));
				$('#endcustomerprojectname').val(
						decodeURIComponent(aaa[44]));
				$('#endcustomertechpersonname').val(
						decodeURIComponent(aaa[45]));
				$('#endcustomerprsndesignation').val(
						decodeURIComponent(aaa[46]));
				$('#endcustomercontactnumber').val(
						decodeURIComponent(aaa[47]));
				$('#endcustomeremailid').val(decodeURIComponent(aaa[48]));
				
				
						$('#implementorpartyname').val(
								decodeURIComponent(aaa[49]));
						$('#implementorprojectname').val(
								decodeURIComponent(aaa[50]));
						$('#implementortechpersonname').val(
								decodeURIComponent(aaa[51]));
						$('#implementorprsndesignation').val(
								decodeURIComponent(aaa[52]));
						$('#implementorcontactnumber').val(
								decodeURIComponent(aaa[53]));
						$('#implementoremailid').val(
								decodeURIComponent(aaa[54]));
						
						$('#form2date').val(decodeURIComponent(aaa[55]));
						$('#form2customername').val(
								decodeURIComponent(aaa[56]));
						$('#poform2No').val(decodeURIComponent(aaa[57]));
						$('#potimeline').val(decodeURIComponent(aaa[58]));
						$('#RPFTIMELINES').val(decodeURIComponent(aaa[59]));
						$('#firstinvoicegeneratedate').val(decodeURIComponent(aaa[60]));
						$('#projstartdate').val(decodeURIComponent(aaa[61]));
						$('#projenddate').val(decodeURIComponent(aaa[62]));
						$('#pymentterms').val(decodeURIComponent(aaa[63]));
						$('#projecthead').val(decodeURIComponent(aaa[64]));
						$('#chartpaymntno').val(decodeURIComponent(aaa[65]));
						
						if (decodeURIComponent(aaa[65]) === 'Yes') {
							$('#remarksid').show();
							$('#Remarks').val(decodeURIComponent(aaa[66]));
						} else {
							
							$('#remarksid').hide();
						}
						
						
						$('#form3status').val(decodeURIComponent(aaa[67]));
						$('#formABstatus').val(decodeURIComponent(aaa[68]));
						$('#form3SubmitStatus').val(decodeURIComponent(aaa[69]));

					
						
					
					
						
						
						
						
//						var productName = decodeURIComponent(aaa[24]).toString();
//						var ppp = productName.split(',');
//
//						$('#productName').val(ppp[0]);
					//	$('#productToolName').val(ppp[1]);
						
						var dataForm = data[1];
						
						jsonImplFormC = data[1];
						
						////alert("data "+data);
//						//alert(jsonImplFormC);
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
					        implementorLabel.innerHTML = "Implementor Name: ";

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

}

function downFileStandard() {
	var filename = encodeURIComponent($('#filenameStandard').val());
	// //alert(filename);
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;

}
function proposalStandard() {
	var filename = encodeURIComponent($('#filnameProposal').val());
	// //alert(filename);
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
function advInvFileStandard() {
	var filename = encodeURIComponent($('#filnameAdvinvoice').val());

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

$("#ApproveCM").click(
		function() {
			
			

//			var checkstatus = $('#form3status').val();
			var formABstatus = $('#formABstatus').val();
			var form3Implementorstatus = $("#form3SubmitStatus").val();
			
//	alert("form3Implementorstatus:__"+form3Implementorstatus)	
//	alert("formABstatus:---"+formABstatus)	
			
			
			if (formABstatus != 'FORMA/B Submitted') {
				////alert("datsfvv");
				swal({
					title : "Fail!",
					text : "FormA/B Not Submitted",
					type : "error",
					width : 300,
					height : 200,
					confirmButtonClass : "btn btn-success",
					confirmButtonText : "OK",
				})
				
			}
//			else if (form3Implementorstatus === 'Form3 Submitted') {
//				approvePO();
//				////alert("Submitted approvePO");
//			}
			else if (formABstatus === 'FORMA/B Submitted') {
				approvePO();
//				alert("Submitted approvePO");
			}
			
			else if (form3Implementorstatus.includes('Form3 Not Submit By ')) {
				swal({
					title : "Fail!",
					text : form3Implementorstatus,
					type : "error",
					width : 300,
					height : 200,
					confirmButtonClass : "btn btn-success",
					confirmButtonText : "OK",

				})
			}else if (form3Implementorstatus === 'Form3 Submitted By None'){
				swal({
					title : "Fail!",
					text : form3Implementorstatus,
					type : "error",
					width : 300,
					height : 200,
					confirmButtonClass : "btn btn-success",
					confirmButtonText : "OK",
//					preConfirm : function() {
////						var l = window.location;
////						var base_url = l.protocol + "//" + l.host + "/"
////								+ l.pathname.split('/')[1];
////						window.location.href = base_url + "/User/pendingAppr";
//					}
				})
			}else{
				swal({
					title : "Fail!",
					text : form3Implementorstatus,
					type : "error",
					width : 300,
					height : 200,
					confirmButtonClass : "btn btn-success",
					confirmButtonText : "OK",
//					preConfirm : function() {
////						var l = window.location;
////						var base_url = l.protocol + "//" + l.host + "/"
////								+ l.pathname.split('/')[1];
////						window.location.href = base_url + "/User/pendingAppr";
//					}
				})
			}
		});

function approvePO() {

	$('#spin1').show();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getUpdateCollnMangpprove";

	$.ajax({
		url : serviceUrl,
		type : 'POST',
		data : "crno=" + $('#crnoo').val() 
		        + "&tid=" + $('#tid').val()
		        + "&AMnote=" + $('#AMnote').val(),

	}).done(
			function(data) {
				$('#spin1').hide();
				
				if (data === "success") {
					
//					swal({
//						title : "Successful!",
//						text : "Document Approved Successfully",
//						type : "success",
//						width : 300,
//						height : 200,
//						confirmButtonClass : "btn btn-success",
//						cancelButtonClass : "btn btn-danger m-l-10",
//						confirmButtonText : "OK",
//						preConfirm : function() {
//							var l = window.location;
//							var base_url = l.protocol + "//" + l.host + "/"
//									+ l.pathname.split('/')[1];
//							window.location.href = base_url
//									+ "/User/pendingAppr";
//						}
//					})
					  swal({
		                    title: "Successful!",
		                    html: "PO ID = " + dataPoId + "<br><br>   Document Approved Successfully",
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
		                        window.location.href = base_url + "/User/pendingAppr";
		                    }
		                })
				} else {
					swal({
						title : "Fail!",
						text : "Document Approved UnSuccessful",
						type : "error",
						width : 300,
						height : 200,
						// showCancelButton: !0,
						confirmButtonClass : "btn btn-success",
						cancelButtonClass : "btn btn-danger m-l-10",
						confirmButtonText : "OK",
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/User/pendingAppr";
						}

					})
				}

			});

}

function myFunctionReject() {
	// //alert("cmstatus"+cmstatus)
	swal({
		title : 'Enter Your Feedback',
		input : 'textarea',
		inputPlaceholder : "Enter Your Feedback",
		showCancelButton : true,
		confirmButtonText : 'Submit',
		preConfirm : function(result) {
			// //alert("value: "+result)
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
							// //alert("value: "+result)
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
												// //alert("result=="+data);
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




function form3data(data112)
{
	
var tabData = [
    {
        tabName: "Form C",
        contentId: "contentTab1"
    },
   
];


// Create tabs dynamically


var tabContainer = document.getElementById("myTabs");
var tabContentContainer = document.getElementById("tabContent");

for (var i = 0; i < tabData.length; i++) {
    // Create tab link
    var tabLink = document.createElement("li");
    tabLink.className = "nav-item";
    tabLink.innerHTML = `<a class="nav-link" id="tab${i + 1}-tab" data-toggle="pill" href="#tab${i + 1}" role="tab" aria-controls="tab${i + 1}" aria-selected="${i === 0}">${tabData[i].tabName}</a>`;

    // Append tab link to container
    tabContainer.appendChild(tabLink);
    
 // Create tab content
    var tabContent = document.createElement("div");
    tabContent.className = "tab-pane fade";
    tabContent.id = `tab${i + 1}`;
    tabContent.role = "tabpanel";
    tabContent.setAttribute("aria-labelledby", `tab${i + 1}-tab`);

    // Create a container for the table with horizontal scroll
    var tableContainer = document.createElement("div");
    tableContainer.className = "table-container";
    tableContainer.style.overflowX = "auto";
    tableContainer.style.width = "100%"; // Set a specific width for your container

    // Create a table element
    var table = document.createElement("table");
    table.className = "table";
    table.style.width = "800px"; // Set a specific width for your table

    // Create the table header
    var thead = document.createElement("thead");
    var headerRow = document.createElement("tr");

    // Array of headers
    var headers = ["SRN0","Implementor Name","Server Availability", "Server Availability Responsibility","Server Availability Start Date", "Server Availability End Date",
    				"Install Of Velox License", "Install Of Velox License Responsibility","Install Of Velox License Start Date", "Install Of Velox License End Date",
    				"UAT Testing", "UAT Testing Responsibility","UAT Testing Start Date", "UAT Testing End Date",
    				"Production GO Live", "Production GO Live Responsibility","Production GO Live Start Date", "Production GO Live End Date",
    				"Rollout", "Rollout Responsibility","Rollout Start Date", "Rollout End Date",
    				"DEMO Live", "DEMO Live Responsibility","DEMO Live Start Date", "DEMO Live End Date",
    				
    				"Sign Off", "Sign Off Responsibility","Sign Off Start Date", "Sign Off End Date"];

    for (var h = 0; h < headers.length; h++) {
        var headerCell = document.createElement("th");
        headerCell.textContent = headers[h];
        headerRow.appendChild(headerCell);
    }

    thead.appendChild(headerRow);
    table.appendChild(thead);

    // Create the table body and populate it with dynamic data
    var tbody = document.createElement("tbody");

    // Customer data array
    var customerData =data112
						
//    var customerData = [
//        { "Implementor Name": "TCS", "Responsibility": "Mumbai" },
//    ];

    for (var row = 0; row < customerData.length; row++) {
        var dataRow = document.createElement("tr");

        for (var col = 0; col < headers.length; col++) {
            var cell = document.createElement("td");
            cell.textContent = customerData[row][headers[col]];
            dataRow.appendChild(cell);
        }

        tbody.appendChild(dataRow);
    }

    table.appendChild(tbody);

    // Append the table to the container
    tableContainer.appendChild(table);

    // Append the container to the tab content
    tabContent.appendChild(tableContainer);

    // Append tab content to container
    tabContentContainer.appendChild(tabContent);


    }

}



function RejectCM() {

	swal({
		title : 'Enter Your Reason',
		input : 'textarea',
		inputPlaceholder : "Enter Your Reason",
		showCancelButton : true,
		confirmButtonText : 'Submit',
		preConfirm : function(result) {
			// alert("value: "+result)
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
									+ "/UserActivity/rejectedByCM";

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
																	+ "/User/pendingAppr";
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
																	+ "/User/pendingAppr";
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















