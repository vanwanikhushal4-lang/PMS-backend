
window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getSubmittedFORM3Data";

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
						console.log(data[0]);

						if ((decodeURIComponent(aaa[44]) === "File Not Attached")
								|| (decodeURIComponent(aaa[44]) === "NA")
								|| (decodeURIComponent(aaa[44]) === "")) {
							$('#downHidemaskedPOfile').hide();
						} else {
							document.getElementById('maskedPOfile').innerHTML = decodeURIComponent(aaa[44]);
							document.getElementById('filnameMaskedPO').value = decodeURIComponent(aaa[44]);
							$('#maskedPOUploadDiv').show();
						}
						if ((decodeURIComponent(aaa[45]) === "File Not Attached")
								|| (decodeURIComponent(aaa[45]) === "NA")
								|| (decodeURIComponent(aaa[45]) === "")) {
							$('#downHideproductFeaturedfile').hide();
						} else {
							document.getElementById('productFeaturedFile').innerHTML = decodeURIComponent(aaa[45]);
							document.getElementById('filnameProductFeatured').value = decodeURIComponent(aaa[45]);
							$('#productFeaturedUploadDiv').show();
						}

						$('#date').val(decodeURIComponent(aaa[0]));
						$('#PONumb').val(decodeURIComponent(aaa[1]));
						$('#customername').val(decodeURIComponent(aaa[2]));
						$('#productLicense').val(decodeURIComponent(aaa[3]));

						$('#serverAvail').val(decodeURIComponent(aaa[5]));
						$('#Responsibility').val(decodeURIComponent(aaa[6]));
						$('#startdate').val(decodeURIComponent(aaa[7]));
						$('#enddate').val(decodeURIComponent(aaa[8]));

						$('#installvlxlicense').val(decodeURIComponent(aaa[9]));
						$('#Responsibilityvlxlicense').val(
								decodeURIComponent(aaa[10]));
						$('#startdatevlxlicense').val(
								decodeURIComponent(aaa[11]));
						$('#enddatevlxlicense')
								.val(decodeURIComponent(aaa[12]));

						$('#UATTesting').val(decodeURIComponent(aaa[13]));
						$('#Responsibilityuattesting').val(
								decodeURIComponent(aaa[14]));
						$('#startdateuattesting').val(
								decodeURIComponent(aaa[15]));
						$('#enddateuattesting')
								.val(decodeURIComponent(aaa[16]));

						$('#productiongolive').val(decodeURIComponent(aaa[17]));
						$('#Responsibilitygolive').val(
								decodeURIComponent(aaa[18]));
						$('#startdategolive').val(decodeURIComponent(aaa[19]));
						$('#enddategolive').val(decodeURIComponent(aaa[20]));

						$('#rollout').val(decodeURIComponent(aaa[21]));
						$('#Responsibilityrollout').val(
								decodeURIComponent(aaa[22]));
						$('#startdaterollout').val(decodeURIComponent(aaa[23]));
						$('#enddaterollout').val(decodeURIComponent(aaa[24]));

						$('#demolive').val(decodeURIComponent(aaa[25]));
						$('#Responsibilitydemo').val(
								decodeURIComponent(aaa[26]));
						$('#startdatedemo').val(decodeURIComponent(aaa[27]));
						$('#enddatedemo').val(decodeURIComponent(aaa[28]));

						$('#paymentTermsPO').val(aaa[29]);
						// $('#paymentterms').val(aaa[29]);
						// $('#Responsibilitypaymentterms').val(decodeURIComponent(aaa[30]));
						// $('#startdatepaymentterms').val(decodeURIComponent(aaa[31]));
						// $('#enddatepaymentterms').val(decodeURIComponent(aaa[32]));

						$('#signoff').val(decodeURIComponent(aaa[33]));
						$('#Responsibilitysignoff').val(
								decodeURIComponent(aaa[34]));
						$('#startdatesignoff').val(decodeURIComponent(aaa[35]));
						$('#enddatesignoff').val(decodeURIComponent(aaa[36]));

						$('#ImplementorName').val(decodeURIComponent(aaa[37]));
						$('#ImplementorNumber')
								.val(decodeURIComponent(aaa[38]));
						$('#cusImplementorEmail').val(
								decodeURIComponent(aaa[39]));
						$('#SalesManagerName').val(decodeURIComponent(aaa[40]));
						$('#EndCustomerName').val(decodeURIComponent(aaa[41]));
						$('#EndCustomerNumber')
								.val(decodeURIComponent(aaa[42]));
						$('#endCustomerSubm').val(decodeURIComponent(aaa[46]));

						var dataForm = aaa[43];
						
						// $('#EndCustomerNumber').val(decodeURIComponent(aaa[42]));
						// $('#EndCustomerNumber').val(decodeURIComponent(aaa[42]));
							
//						 alert(dataForm);
						// Create input fields dynamically
						var inputContainer = document
								.getElementById("inputContainer");

						dataForm.forEach(function(entry, index) {
									
									console.log("entry"+entry)
									console.log("index"+index)
									// Create a row for each entry
									var row = document.createElement("div");
									row.className = "row";

									// Create product column
									var productCol = document
											.createElement("div");
									productCol.className = "col-md-4";
									productCol.style = "margin-top: 15px;";

									// Create product label
									var productLabel = document
											.createElement("label");
									productLabel.innerHTML = "Product Name: ";

									// Create product input field
									var productInput = document
											.createElement("input");
									productInput.type = "text";
									productInput.className = "form-control form-control-sm";
									productInput.value = entry[0];
									productInput.setAttribute("readonly",
											"readonly");
									productInput.id = "productName_" + index; // Unique
																				// ID
																				// for
																				// product
																				// input

									// Append product label and input field to
									// the product column
									productCol.appendChild(productLabel);
									productCol.appendChild(productInput);

									// Create a row for qty

									var qtyRow = document.createElement("div");
									qtyRow.className = "row";

									// Create product column
									var productQty = document
											.createElement("div");
									productQty.className = "col-md-4";
									productQty.style = "margin-top: 15px;";

									// Create product label
									var productQtyLabel = document
											.createElement("label");
									productQtyLabel.innerHTML = "Product Qty: ";

									// Create product input field
									var productQtyInput = document
											.createElement("input");
									productQtyInput.type = "text";
									productQtyInput.className = "form-control form-control-sm";
									productQtyInput.value = entry[2];
									productQtyInput.setAttribute("readonly",
											"readonly");
									productQtyInput.id = "productQty_" + index; // Unique
																				// ID
																				// for
																				// product
																				// input

									// Append product label and input field to
									// the product column
									productQty.appendChild(productQtyLabel);
									productQty.appendChild(productQtyInput);

									// Create space column
									// var spaceCol =
									// document.createElement("div");
									// spaceCol.className = "col-md-1"; // Empty
									// column for space

									// Create implementor name column
									var implementorCol = document
											.createElement("div");
									implementorCol.className = "col-md-4";
									implementorCol.style = "margin-top: 15px;";

									// Create implementor name label
									var implementorLabel = document
											.createElement("label");
									implementorLabel.innerHTML = "Product Manager Name: ";

									// Create implementor name input field
									var implementorInput = document
											.createElement("input");
									implementorInput.type = "text";
									implementorInput.className = "form-control form-control-sm";
									implementorInput.value = entry[1];
									implementorInput.setAttribute("readonly",
											"readonly");
									implementorInput.id = "implementorName_"
											+ index; // Unique ID for
														// implementor name
														// input

									// Append implementor name label and input
									// field to the implementor name column
									implementorCol
											.appendChild(implementorLabel);
									implementorCol
											.appendChild(implementorInput);

									// Append product column, space column, and
									// implementor name column to the row
									row.appendChild(productCol);
									row.appendChild(productQty);
									row.appendChild(implementorCol);

									// Append the row to the input container
									inputContainer.appendChild(row);

									// Add some space between input field sets
									// inputContainer.appendChild(document.createElement("br"));
									// inputContainer.appendChild(document.createElement("br"));
								});

					});

}

function maskedPOStandard() {

	var filename = encodeURIComponent($('#filnameMaskedPO').val());

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
