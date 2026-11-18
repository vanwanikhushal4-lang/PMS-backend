window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
	$
			.ajax({
				type : 'POST',
				url : serviceUrl,
				dataType : 'json',
				async : false,
				success : function(data4) {
					// alert(data4)
					var html = "<option value=''> -- Please Select Company  --</option>";
					for (var i = 0; i < data4.length; i++) {
						// alert(data4[i]);
						html += '<option value="' + data4[i] + '">' + data4[i]
								+ '</option>';
					}

					document.getElementById("cname").innerHTML = html;
				}
			});

//	$('#cname').focus();

	// //////// GET COMPANY CODE LISTING /////////
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/CompanyCodeListing";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		
		success : function(data4) {
			var table = $('#datatype').DataTable({
				lengthChange : false,
				data : data4,
				"pageLength" : 5,
//				scrollY: true,
				scrollX: true,
			});

			table.buttons().container().appendTo(
					'#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

		}

	});

}

var callToolTip = function(fieldName, status) {

	if (fieldName == "cname") {
		var errorMessage = "<span>Please Select Company <span>";
	} else if (fieldName == "companycode") {
		var errorMessage = "<span>Please Enter Company Code<span>";
	} else if (fieldName == "companycodemodal") {
		var errorMessage = "<span>Please Enter Company Code<span>";
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

$('#cname').on('focusout', function() {
	var usertype = $('#cname').val();

	if (usertype.trim() == "") {
		callToolTip('cname', 'show');
	} else {
		callToolTip('cname', 'hide');
	}
});
$('#companycode').on('focusout', function() {
	var usertype = $('#companycode').val();

	if (usertype.trim() == "") {
		callToolTip('companycode', 'show');
	} else {
		callToolTip('companycode', 'hide');
	}
});

$('#cname').on('click', function() {
	callToolTip('cname', 'destroy');
});
$('#companycode').on('click', function() {
	callToolTip('companycode', 'destroy');
});

function validateCompanyCode() {
	var indexError = 0;

	if ($('#cname').val().trim() === '') {
		callToolTip('cname', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#companycode').val().trim() === '') {
		callToolTip('companycode', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if (indexError > 0) {
		return false;

	} else {
		return true;
	}
}

$("#submit-btn").click(function() {

	if (!validateCompanyCode()) {
		event.preventDefault();
	} else {
		saveCompanyCode();
	}
}).show();

$("#resetbtn").click(function() {
	$("#cname").val('').trigger('change')
	$("#companycode").val('').trigger('change')
	callToolTip('cname', 'destroy');
	callToolTip('companycode', 'destroy');
});

function saveCompanyCode() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/addCompanyCode";

	$.ajax(
			{
				type : 'POST',
				url : serviceUrl,
				data : 'companyname=' + encodeURIComponent($("#cname").val()) + '&companycode='
						+ $("#companycode").val()
			}).done(
			function(data) {
				// alert("response: "+data)

				if (data == "success") {
					swal({
						title : "Successful!",
						text : "Record Added Successfully",
						type : "success",
						width : 300,
						height : 200,
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/CompanyCodeMaster";
						}

					});

				} else if (data == "duplicate") {
					swal({
						title : "Duplicate Data!",
						text : "Record Already Exists",
						type : "warning",
						width : 300,
						height : 200,
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/CompanyCodeMaster";
						}

					});

				} else if (data == "error") {
					swal({
						title : "Unsuccessful!",
						text : "Fail to add file",
						type : "error",
						width : 300,
						height : 200,
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/CompanyCodeMaster";
						}

					});

				}
			});
}

function EditCode(srno, company, code) {
	callToolTip('companycode', 'destroy');
	callToolTip('cname', 'destroy');
	$('#companymodal').val(company);
	$('#companycodemodal').val(code);

	$("#sr_no1").val(srno);
	$('#modalcompany').modal('show');
}

$('#companycodemodal').on('focusout', function() {
	var usertype = $('#companycodemodal').val();

	if (usertype.trim() == "") {
		callToolTip('companycodemodal', 'show');
	} else {
		callToolTip('companycodemodal', 'hide');
	}
});

$('#companycodemodal').on('click', function() {
	callToolTip('companycodemodal', 'destroy');
});

$('#update-code-btn').click(function() {
	if (!validateCompanyCodeUpdate()) {
		event.preventDefault();
	} else {
		updateCompanyCode();
	}
})

$('#modalresetbtn').click(function() {
	callToolTip('companycodemodal', 'destroy');
	$('#companycodemodal').val('');
})


function validateCompanyCodeUpdate() {
	var indexError = 0;

	if ($('#companycodemodal').val().trim() === '') {
		callToolTip('companycodemodal', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if (indexError > 0) {
		return false;

	} else {
		return true;
	}
}

function updateCompanyCode() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/updateCompanyCode";

	$.ajax(
			{
				type : 'POST',
				url : serviceUrl,
				data : 'companyname=' + encodeURIComponent($("#companymodal").val()) + '&companycode=' + $("#companycodemodal").val() + '&srno=' + $('#sr_no1').val()
			}).done(
			function(data) {
				// alert("response: "+data)

				if (data == "success") {
					swal({
						title : "Successful!",
						text : "Record Updated Successfully",
						type : "success",
						width : 300,
						height : 200,
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/CompanyCodeMaster";
						}

					});

				} else if (data == "duplicate") {
					swal({
						title : "Duplicate Data!",
						text : "Record Already Exists",
						type : "warning",
						width : 300,
						height : 200,
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/CompanyCodeMaster";
						}

					});

				} else if (data == "error") {
					swal({
						title : "Unsuccessful!",
						text : "Fail to Update Record",
						type : "error",
						width : 300,
						height : 200,
						buttons : false,
						allowOutsideClick : false,
						preConfirm : function() {
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							window.location.href = base_url
									+ "/Admin/CompanyCodeMaster";
						}

					});

				}
			});
}

function DeleteCode(srno) {

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
	}).then(
			function() {

				var l = window.location;
				var base_url = l.protocol + "//" + l.host + "/"
						+ l.pathname.split('/')[1];
				var serviceUrl = base_url + "/Master/deleteCompanyCode";

				$.ajax({
					type : 'POST',
					url : serviceUrl,
					data : 'srno=' + srno

				}).done(
						function(data) {
							// alert(data)
							if (data == "success") {
								swal({
									title : "Successful!",
									text : "Record Deleted Successfully",
									type : "success",
									width : 300,
									height : 200,
									buttons : false,
									allowOutsideClick : false,
									preConfirm : function() {
										var l = window.location;
										var base_url = l.protocol + "//"
												+ l.host + "/"
												+ l.pathname.split('/')[1];
										window.location.href = base_url
												+ "/Admin/CompanyCodeMaster";
									}

								});

							}

							else if (data == "error") {
								swal({
									title : "Unsuccessful!",
									text : "Fail to delete file",
									type : "error",
									width : 300,
									height : 200,
									buttons : false,
									allowOutsideClick : false,
									preConfirm : function() {
										var l = window.location;
										var base_url = l.protocol + "//"
												+ l.host + "/"
												+ l.pathname.split('/')[1];
										window.location.href = base_url
												+ "/Admin/CompanyCodeMaster";
									}

								});

							}
						});
			});
}
