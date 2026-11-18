window.onload = function() {
	// alert("ggggg")

	$('#Name2').hide();
	$('#selectedattribute').hide();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/prioritytemplatelist";
	// var serviceUrl = "CompanyDetails";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {

			var table = $('#datatype').DataTable({
				lengthChange : false,
				data : data4,
				// scrollX: true,
				"pageLength" : 5,
			});

			table.buttons().container().appendTo(
					'#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

		}

	});

};

var a=0;
function changeattribute() {
	
	a=1;
	// alert("yyy");
	// alert($('#company').val());

	var valueatt = $("#Attribute1").val();
	// alert(valueatt);
	if (valueatt == 'firstoption') {
		// alert("hii");
		$('#Name2').hide();
		a=0;

	} else {
		$("#Name2").show();
	}
	if (valueatt == 'priority') {

		var Example = "Value (Example:p1,p2,p3,p4,p5)"

	}

	else if (valueatt == 'Severity') {
		var Example = "Value  (Example:s1,s2,s3,s4,s5)"

	} else if (valueatt == 'SLA') {
		var Example = "Value (Example:0 to 100)"

	}

	document.getElementById("selectedattribute").innerHTML = Example
	$('#selectedattribute').show();
	

}

var callToolTip231 = function(fieldName, status) {
	// alert(fieldName)
	if (fieldName == "Attribute1") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Attribute<span>";

	} else if (fieldName == "Templatedeatil") {
		// $("#email").tooltip('destroy');

		// alert("in if ");
		var errorMessage = "<span>Please Enter Value<span>";

	} else if (fieldName == "TemplateCorrectValue") {
		// $("#email").tooltip('destroy');

		// alert("in if ");
		var errorMessage = "<span>Please Enter Correct Value<span>";
		//fieldName ="Templatedeatil";
	}
	
	else if (fieldName == "TemplateCopydata") {
		// $("#email").tooltip('destroy');

		// alert("in if ");
		var errorMessage = "<span>Please Enter Unique Value<span>";
		//fieldName ="Templatedeatil";
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

	$('#Attribute1').on('focusout', function() {
		var usertype = $('#Attribute1').val();

		if (usertype.trim() == "") {
			callToolTip231('Attribute1', 'show');
		} else {
			callToolTip231('Attribute1', 'hide');
		}
	});

	$('#Templatedeatil').on('focusout', function() {
		var usertype = $('#Templatedeatil').val();

		if (usertype.trim() == "") {
			callToolTip231('Templatedeatil', 'show');
		} else {
			callToolTip231('Templatedeatil', 'hide');
		}
	});
}

$('#Attribute1').on('focus', function() {
	callToolTip231('Attribute1', 'destroy');
	callToolTip231('Templatedeatil', 'hide');
});

$('#Templatedeatil').on('focus', function() {
	callToolTip231('Templatedeatil', 'destroy');
	callToolTip231('TemplateCorrectValue', 'destroy');
});

$('#Templatedeatil').on('focus', function() {
	callToolTip231('Templatedeatil', 'destroy');
	callToolTip231('TemplateCopydata', 'destroy');
});




function validateTemplateForm() {

	var count=0;
	var value1=null;
	var value2=null;
	var i=0;
	var j=1;
	
	var indexError = 0;

	if ($('#Attribute1').val() === ''
			|| $('#Attribute1').val() === 'firstoption') {

		callToolTip231('Attribute1', 'show');
		if (indexError == 0) {

		}

		indexError = indexError + 1;
		console.log("in Attribute1 :" + indexError)
	}
	
	if ($('#Templatedeatil').val() == '' && a==1) {
		//alert("Template");
		callToolTip231('Templatedeatil', 'show');
		if (indexError == 0) {

		}

		indexError = indexError + 1;
		console.log("in Attribute1 :" + indexError)
	}

	var Attribute = $('#Attribute1').val();
	var TemplateData = $('#Templatedeatil').val();
	var temp=TemplateData.length;
	//alert(temp);
	
	   var myArr = TemplateData.split(",");
	    for ( i = 0; i < myArr.length; i++) {
	    	 value1= myArr[i];
	    	 
	    	 
	    	   for (j = 1; j < myArr.length; j++) {
	    	    	 value2= myArr[j];
	    	    	 console.log(value1)
	    	    	 	 console.log(value1)
	    	    	 if(value1 === value2 && i!=j)
	    	    		 {
	    	    		  count=count+1;
	    	    		 }
	    	    	}
	    	}
	  //  alert(count);

	// alert(Attribute)
	// alert(TemplateData)

	    if(temp>0){
//			 alert("truehua");
	if (Attribute === "priority" || Attribute === "Severity" && temp>0) {
	//	 alert("in check");
		// var r=/^[a-zA-Z0-9_ ]*$/;
		// var r=/[0-9a-zA-Z]+(,[0-9a-zA-Z]+)*/;
		var pattSpace = new RegExp('^\\S*$');
		var pattComma = new RegExp('^[a-zA-Z0-9](.*[a-zA-Z0-9])?$');

		var testResultSpace = pattSpace.test(TemplateData);
		// alert("Space Result: "+testResultSpace);

		var testResultComma = pattComma.test(TemplateData);
//		 alert("Comma Result: "+testResultComma);
//		 alert("Comma Result: "+testResultSpace); 
		if (testResultSpace === false || testResultComma === false) {

			callToolTip231('TemplateCorrectValue', 'show');
			if (indexError == 0) {

			}

			indexError = indexError + 1;
			console.log("in Templatedeatil :" + indexError)

		}
		else if(count !=0)
			{

			callToolTip231('TemplateCopydata', 'show');
			if (indexError == 0) {

			}

			indexError = indexError + 1;
			console.log("in TemplateCopydata :" + indexError)

		}

	}}
	    
	if (Attribute === "SLA" && temp>0) {
		// alert("in sla: "+TemplateData)
		var pattPercent = new RegExp(
				/(^100([.]0{1,2})?)$|(^\d{1,2}([.]\d{1,2})?)$/g);
		var testResultPercent = pattPercent.test(TemplateData);
		// alert(testResultPercent)
		if (testResultPercent === false || count !=0) {

			callToolTip231('TemplateCorrectValue', 'show');
			if (indexError == 0) {

			}

			indexError = indexError + 1;
			console.log("in TemplateCorrectValue :" + indexError)

		}
	}

	if (indexError > 0) {
		// alert(indexError);
		return false;

	} else {
		// alert(indexError);
		return true;
	}

}
$("#submit-btn").click(function() {
	// alert("dgfsgf");
	if (!validateTemplateForm()) {
		// alert("fail")
		event.preventDefault();
	} else {
		// alert("pass")
		saveDataCompany();
	}
});

// insert data
function saveDataCompany() {

	// alert("function");

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/addPrioritytemplate";

	var serviceUrl = serviceUrl;
	$.ajax(
			{
				type : 'POST',
				url : serviceUrl,
				data : 'Attribute1=' + encodeURIComponent($("#Attribute1").val())
						+ '&Templatedeatil=' + $("#Templatedeatil").val()
			}).done(
			function(data) {
				// alert("hgdjghd"+data)

				if (data == "success") {
					swal({
						title : "Successful!",
						text : "Record Added Successfully",
						type : "success",
						width : 300,
						height : 200,
						// showCancelButton: false,
						// confirmButtonClass: "btn btn-danger",
						// cancelButtonClass: "btn btn-danger m-l-10",
						// confirmButtonText: "OK",
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/PriorityTemplateMaster";
						}

					});

				}

				else if (data == "duplicate") {
					swal({
						title : "Duplicate Data!",
						text : "Record Already Exists",
						type : "warning",
						width : 300,
						height : 200,
						// showCancelButton: false,
						// confirmButtonClass: "btn btn-danger",
						// cancelButtonClass: "btn btn-danger m-l-10",
						// confirmButtonText: "OK",
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/PriorityTemplateMaster";
						}

					});

				} else if (data == "error") {
					swal({
						title : "Unsuccessful!",
						text : "Fail to add file",
						type : "success",
						width : 300,
						height : 200,
						// showCancelButton: false,
						// confirmButtonClass: "btn btn-danger",
						// cancelButtonClass: "btn btn-danger m-l-10",
						// confirmButtonText: "OK",
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/PriorityTemplateMaster";
						}

					});

				}
			});
	// });
}

function Deletecompany(srno) {
	// alert("gdfsf"+srno)
	swal({
		title : "Are you sure?",
		text : "You want to delete?",
		type : "warning",
		width : 350,
		height : 200,
		showCancelButton : !0,
		confirmButtonClass : "btn btn-success",
		cancelButtonClass : "btn btn-danger m-l-10",
		confirmButtonText : "Yes, Delete it!"
	})
			.then(
					function() {
						// alert("deleteUserdddddddd")

						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"
								+ l.pathname.split('/')[1];
						var serviceUrl = base_url
								+ "/Master/deleteprioritytemplate";
						// var serviceUrl = "deletecompany";
						$
								.ajax({
									type : 'POST',
									url : serviceUrl,
									data : 'crno=' + srno

								})
								.done(
										function(data) {
											// alert("dfgsfd"+data)

											if (data == "success") {
												swal({
													title : "Successful!",
													text : "Record Deleted Successfully",
													type : "success",
													width : 300,
													height : 200,
													// showCancelButton: false,
													// confirmButtonClass: "btn
													// btn-danger",
													// cancelButtonClass: "btn
													// btn-danger m-l-10",
													// confirmButtonText: "OK",
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
																+ "/Admin/PriorityTemplateMaster";
													}

												});

											}

											else if (data == "error") {
												swal({
													title : "Unsuccessful!",
													text : "Fail to delete file",
													type : "success",
													width : 300,
													height : 200,
													// showCancelButton: false,
													// confirmButtonClass: "btn
													// btn-danger",
													// cancelButtonClass: "btn
													// btn-danger m-l-10",
													// confirmButtonText: "OK",
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
																+ "/Admin/PriorityTemplateMaster";
													}

												});

											}
										});
					});
}

function Editcompany(crno) {
	// alert(crno)
	callToolTip231('company', 'destroy');
	callToolTip231('companyemail', 'destroy');

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/updatePriorityTemplate";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : "json",
		data : 'crno=' + crno
	}).done(function(data) {
		// alert(data);
		// alert(data[0]['NAME']);
		// alert(data[0]["ATTRIBUTE"]);

		$('#companynameupdate').val(data[0]['NAME']);
		$('#companyemailupdate').val(data[0]["ATTRIBUTE"]);
		$('#sr_no1').val(crno);

	});
	$("#modelcompany1").modal("show");
}

$("#update_CompanyType_btn").click(function() {
	if (!validateCompUpdate()) {
		// alert("error");
		event.preventDefault();
	} else if (validateCompUpdate()) {
		// alert("success");
		updatecompanySave111();
	}
}).show();

function updatecompanySave111() {
	// alert("dgsf"+ $('#companynameupdate').val())
	// alert("dgsf"+ $('#companyemailupdate').val())
	// alert("dgsf"+ $('#sr_no1').val());

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/updatepprioritytemplateSave";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		data : "companynameupdate=" + $('#companynameupdate').val() + "&cr_no="
				+ $('#sr_no1').val() + "&companyemailupdate="
				+ $('#companyemailupdate').val(),
		success : function(data) {
			alert(data)
			if (data == "success") {
				swal({
					title : "Successful!",
					text : "Record Updated Successfully",
					type : "success",
					width : 300,
					height : 200,
					// showCancelButton: false,
					// confirmButtonClass: "btn btn-danger",
					// cancelButtonClass: "btn btn-danger m-l-10",
					// confirmButtonText: "OK",
					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"
								+ l.pathname.split('/')[1];
						window.location.href = base_url
								+ "/Admin/PriorityTemplateMaster";
					}
				});
			}

			else if (data == "duplicate") {
				swal({
					title : "Duplicate!",
					text : "Record Already Exist",
					type : "success",
					width : '300px',
					height : '90px !important',
					// showCancelButton: false,
					// confirmButtonClass: "btn btn-danger",
					// cancelButtonClass: "btn btn-danger m-l-10",
					// confirmButtonText: "OK",
					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"
								+ l.pathname.split('/')[1];
						window.location.href = base_url
								+ "/Admin/PriorityTemplateMaster";
					}
				});
			}

			else {

				swal({
					title : "Unsuccessful!",
					text : "Record not updated",
					type : "error",
					width : 300,
					height : 200,
					// showCancelButton: false,
					// confirmButtonClass: "btn btn-danger",
					// cancelButtonClass: "btn btn-danger m-l-10",
					// confirmButtonText: "OK",
					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"
								+ l.pathname.split('/')[1];
						window.location.href = base_url
								+ "/Admin/PriorityTemplateMaster";
					}
				});
			}

			$('#updatecompanyname').val("");

		}
	});
}

var callToolTipUpdate = function(fieldName, status) {

	if (fieldName == "companynameupdate") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Value <span>";

	} else if (fieldName == "companyemailupdate") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Attribute<span>";

	}
	else if (fieldName == "TemplateCorrectValueupdate") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Correct Value<span>";

	}
	
	else if (fieldName == "TemplateCopydataupdate") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Unique Value<span>";

	}
	// else if (fieldName == "companyemailupdatewrong") {
	// //$("#email").tooltip('destroy');
	// var errorMessage = "<span>Please Enter Valid Company Email-ID<span>";
	// }

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

$('#companynameupdate').on('focusout', function() {
	var usertype = $('#companynameupdate').val();

	if (usertype.trim() == "") {
		callToolTipUpdate('companynameupdate', 'show');
	} else {
		callToolTipUpdate('companynameupdate', 'hide');
	}
});
$('#companyemailupdate').on('focusout', function() {
	var usertype = $('#companyemailupdate').val();

	if (usertype.trim() == "") {
		callToolTipUpdate('companyemailupdate', 'show');
	} else {
		callToolTipUpdate('companyemailupdate', 'hide');
	}
});

$('#companynameupdate').on('focus', function() {
	callToolTipUpdate('companynameupdate', 'destroy');
});
$('#companyemailupdate').on('focus', function() {
	callToolTipUpdate('companyemailupdate', 'destroy');
	callToolTipUpdate('companyemailupdatewrong', 'hide');
});

$('#TemplateCorrectValueupdate').on('focus', function() {
	callToolTipUpdate('TemplateCorrectValueupdate', 'destroy');
	callToolTipUpdate('TemplateCorrectValueupdate', 'hide');
});
$('#TemplateCorrectValueupdate').on('focus', function() {
	callToolTipUpdate('TemplateCorrectValueupdate', 'destroy');
	callToolTipUpdate('TemplateCopydataupdate', 'hide');
});


function validateCompUpdate() {

	var count=0;
	var value1=null;
	var value2=null;
	var i=0;
	var j=1;
	
	var Attribute2 = $('#companyemailupdate').val();
	var TemplateData2 = $('#companynameupdate').val();





	var indexError = 0;

	if ($('#companyemailupdate').val() === '') {

		callToolTipUpdate('companyemailupdate', 'show');
		if (indexError == 0) {

		}

		indexError = indexError + 1;
		console.log("in companyemailupdate :" + indexError)
	}
	if (TemplateData2 === '') {

		callToolTipUpdate('companynameupdate', 'show');
		if (indexError == 0) {

		}

		indexError = indexError + 1;
		console.log("in Attribute1 :" + indexError)
	}

	
	
	   var myArr = TemplateData2.split(",");
	    for ( i = 0; i < myArr.length; i++) {
	    	 value1= myArr[i];
	    	 
	    	 
	    	   for (j = 1; j < myArr.length; j++) {
	    	    	 value2= myArr[j];
	    	    	 console.log(value1)
	    	    	 	 console.log(value1)
	    	    	 if(value1 === value2 && i!=j)
	    	    		 {
	    	    		  count=count+1;
	    	    		 }
	    	    	}
	    	}
	// alert(Attribute2)
	// alert(TemplateData2)
	//     
	    var temp2=TemplateData2.length;
	    if(temp2>0){
	if ((Attribute2 === "priority") || (Attribute2 === "Severity")) {
		// alert("in check")
		// var r=/^[a-zA-Z0-9_ ]*$/;
		// var r=/[0-9a-zA-Z]+(,[0-9a-zA-Z]+)*/;

		var Attribute2 = $('#companyemailupdate').val();
		var TemplateData2 = $('#companynameupdate').val();

		// alert(Attribute2)
		// alert(TemplateData2)

		var pattSpace2 = new RegExp('^\\S*$');
		var pattComma2 = new RegExp('^[a-zA-Z0-9](.*[a-zA-Z0-9])?$');

		var testResultSpace2 = pattSpace2.test(TemplateData2);
		// alert("Space Result: "+testResultSpace2);

		var testResultComma2 = pattComma2.test(TemplateData2);
		// alert("Comma Result: "+testResultComma2);

		if (testResultSpace2 === false || testResultComma2 === false) {

			callToolTipUpdate('TemplateCorrectValueupdate', 'show');
			if (indexError == 0) {

			}

			indexError = indexError + 1;

			// alert("count index error "+indexError)
			console.log("in TemplateCorrectValueupdate :" + indexError)

		}
		else if (count !=0) {

			callToolTipUpdate('TemplateCopydataupdate', 'show');
			if (indexError == 0) {

			}

			indexError = indexError + 1;

			// alert("count index error "+indexError)
			console.log("in TemplateCopydataupdate :" + indexError)

		}
		// alert("count index error "+indexError)

	} else if (Attribute2 === "SLA" && temp2>0) {
		var Attribute2 = $('#companyemailupdate').val();
		var TemplateData2 = $('#companynameupdate').val();
		// alert("in sla: "+TemplateData2);
		var pattPercent2 = new RegExp(
				/(^100([.]0{1,2})?)$|(^\d{1,2}([.]\d{1,2})?)$/g);
		var testResultPercent2 = pattPercent2.test(TemplateData2);
		// alert(testResultPercent2)
		if (testResultPercent2 === false) {

			callToolTipUpdate('TemplateCorrectValueupdate', 'show');
			if (indexError == 0) {

			}

			indexError = indexError + 1;
			console.log("in TemplateCorrectValueupdate :" + indexError)

		}
	}}

	if (indexError > 0) {
		// alert(indexError);
		return false;

	} else {
		// alert(indexError);
		return true;
	}

}

$("#resetbtn").click(function() {
	// alert("vdbdf");
	// $("#company").val("");
	
	$('#Name2').hide();
	$("#Attribute1").val("firstoption");
	$("#Templatedeatil").val("");
	
	// $("#firstoption").val("--Please Select Attribut--");

	callToolTip231('Attribute1', 'destroy');
	callToolTip231('Templatedeatil','destroy');
	callToolTip231('TemplateCorrectValue', 'destroy');
	/*
	 * // callToolTip231('companyemailwrong', 'hide');
	 */});
