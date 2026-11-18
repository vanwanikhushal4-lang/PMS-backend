window.onload = function() {
//	Get Company Dropdown
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		async : false,
		success : function(data4) {
			// alert(data4)
			var html = "<option value=''> -- Please Select Company Name --</option>";
			for (var i = 0; i < data4.length; i++) {
				// alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}

			document.getElementById("cname").innerHTML = html;
		}
	});
	
//	Get Category Dropdown
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSelfHelpCategory";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		async : false,
		success : function(data4) {
			// alert(data4)
			var html = "<option value=''></option>";
			for (var i = 0; i < data4.length; i++) {
				// alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}

			document.getElementById("category").innerHTML = html;
			document.getElementById("categoryupdate").innerHTML = html;
		}
	});
	
//	Get Platform Dropdown
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSelfHelpPlatform";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		async : false,
		success : function(data4) {
			// alert(data4)
			var html = "<option value=''></option>";
			for (var i = 0; i < data4.length; i++) {
				// alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}

			document.getElementById("platform").innerHTML = html;
			document.getElementById("platformupdate").innerHTML = html;
		}
	});
	
//	$('#cname').focus();
	branchmulti();
	deptmulti();
	select2();

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSelfHelpList";

	// var serviceUrl = "getUserTicketList";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',

		success : function(data5) {
			// alert(data5)
			var table = $('#datatype').DataTable({
				lengthChange : false,
				pageLength : 5,
				data : data5,
				destroy : true,
				scrollX : true,
				fnInitComplete : function() {
					loadDatatablesScroll();
				}
			});
			table.buttons().container().appendTo('#datatype .col-sm-6:eq(0)');
		}
	});
}

function branchmulti() {
	$("#branch").multiselect({
        includeSelectAllOption: true,
        buttonWidth: '100%',
        maxHeight:200
    });
}

function deptmulti() {
	$("#department").multiselect({
        includeSelectAllOption: true,
        buttonWidth: '100%',
        maxHeight:200
    });
}

function select2 () {
	$('#category').select2({
		tags : true,
		placeholder : "Select or Enter New Category ",
	})
	$('#platform').select2({
		tags : true,
		placeholder : "Select or Enter New Platform",
	})
	$('#categoryupdate').select2({
		tags : true,
		width: '100%',
		placeholder : "Select or Enter New Category ",
		dropdownParent: $("#modaledit")
	})
	$('#platformupdate').select2({
		tags : true,
		width: '100%',
		placeholder : "Select or Enter New Platform",
		dropdownParent: $("#modaledit")
//	    allowClear: true
	})
}

function getBranchDetails(company) {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getBranchForLoginMaster";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		data: 'companyname=' + encodeURIComponent(company),
		dataType : 'json',
		async : false,
		success : function(data4) {
			// alert(data4)
			var html = "<select id='branch' class='form-control' data-toogle='tooltip' name='branch' multiple='multiple' onchange='getDeptDetails();'>";
			for (var i = 0; i < data4.length; i++) {
				// alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}
			html += "</select>"
			document.getElementById("branchDiv").innerHTML = html;
			branchmulti();
		}
	});
}

function getDeptDetails() {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getDepartmentForUserScope";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		data: 'companyname=' + encodeURIComponent($('#cname').val()) + '&branchName=' + encodeURIComponent($('#branch').val()),
		dataType : 'json',
		async : false,
		success : function(data4) {
			// alert(data4)
			var html = "<select id='department' class='form-control' data-toogle='tooltip' name='department' multiple='multiple'>";
			for (var i = 0; i < data4.length; i++) {
				// alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}
			html += "</select>"
			document.getElementById("departmentDiv").innerHTML = html;
			deptmulti();
		}
	});
}

// On focusout events

$('#cname').on('focusout', function() {
	var usertype = $('#cname').val();

	if (usertype.trim() == "") {
		callToolTip('cname', 'show');
	} else {
		callToolTip('cname', 'hide');
	}
});
$('#branchDiv').on('focusout', function() {
	var usertype = $('#branch').val();

	if (usertype.trim() == "") {
		callToolTip('branchDiv', 'show');
	} else {
		callToolTip('branchDiv', 'hide');
	}
});
$('#departmentDiv').on('focusout', function() {
	var usertype = $('#department').val();

	if (usertype.trim() == "") {
		callToolTip('departmentDiv', 'show');
	} else {
		callToolTip('departmentDiv', 'hide');
	}
});
$('#name').on('focusout', function() {
	var usertype = $('#name').val();

	if (usertype.trim() == "") {
		callToolTip('name', 'show');
	} else {
		callToolTip('name', 'hide');
	}
});
$('#description').on('focusout', function() {
	var usertype = $('#description').val();

	if (usertype.trim() == "") {
		callToolTip('description', 'show');
	} else {
		callToolTip('description', 'hide');
	}
});
$('#categoryDiv').on('focusout', function() {
	var usertype = $('#category').val();

	if (usertype.trim() == "") {
		callToolTip('categoryDiv', 'show');
	} else {
		callToolTip('categoryDiv', 'hide');
	}
});
$('#platformDiv').on('focusout', function() {
	var usertype = $('#platform').val();

	if (usertype.trim() == "") {
		callToolTip('platformDiv', 'show');
	} else {
		callToolTip('platformDiv', 'hide');
	}
});
$('#empPic').on('focusout', function() {
	var usertype = $('#empPic').val();

	if (usertype.trim() == "") {
		callToolTip('empPic', 'show');
	} else {
		callToolTip('empPic', 'hide');
	}
});
// On focus events
$('#cname').on('click', function() {
	callToolTip('cname', 'destroy');
});
$('#branchDiv').on('click', function() {
	callToolTip('branchDiv', 'destroy');
});
$('#departmentDiv').on('click', function() {
	callToolTip('departmentDiv', 'destroy');
});
$('#name').on('click', function() {
	callToolTip('name', 'destroy');
});
$('#description').on('click', function() {
	callToolTip('description', 'destroy');
});
$('#categoryDiv').on('click', function() {
	callToolTip('categoryDiv', 'destroy');
});
$('#platformDiv').on('click', function() {
	callToolTip('platformDiv', 'destroy');
});
$('#empPic').on('click', function() {
	callToolTip('empPic', 'destroy');
});

var callToolTip = function(fieldName, status) {

	if (fieldName == "cname") {
		var errorMessage = "<span>Please Select Company Name<span>";
	} else if (fieldName == "branchDiv") {
		var errorMessage = "<span>Please Select Branch Name<span>";
	} else if (fieldName == "departmentDiv") {
		var errorMessage = "<span>Please Select Department<span>";
	} else if (fieldName == "name") {
		var errorMessage = "<span>Please Enter Name<span>";
	} else if (fieldName == "description") {
		var errorMessage = "<span>Please Enter Description<span>";
	} else if (fieldName == "categoryDiv") {
		var errorMessage = "<span>Please Select Category Name<span>";
	} else if (fieldName == "platformDiv") {
		var errorMessage = "<span>Please Select Platform<span>";
	} else if (fieldName == "empPic") {
		var errorMessage = "<span>Please Attach File<span>";
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

$('#submit-btn').click(function() {
	event.preventDefault();
	if (!validateSelfHelp()) {
		event.preventDefault();
	} else {
		$(this).prop("disabled", true);
		$('#resetbtn').prop("disabled", true);
		$(this).html(
				'Submit <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>'
		);
		saveSelfHelp();
	}
})

$('#resetbtn').click(function() {
	hideToolTip();
	$('#cname').val('');
	$('#name').val('');
	$("#branch option:selected").prop("selected", false);
	$("#branch").multiselect('refresh');
	$("#department option:selected").prop("selected", false);
	$("#department").multiselect('refresh');
	$('#description').val('');
	$('#category').val('').trigger('change');
	$('#platform').val('').trigger('change');
	$('#empPic').val('');
})

function hideToolTip() {
	callToolTip('cname', 'hide');
	callToolTip('branchDiv', 'hide');
	callToolTip('departmentDiv', 'hide');
	callToolTip('name', 'hide');
	callToolTip('description', 'hide');
	callToolTip('categoryDiv', 'hide');
	callToolTip('platformDiv', 'hide');
	callToolTip('empPic', 'hide');
}

function validateSelfHelp() {
	var indexError = 0;

	if ($('#cname').val().trim() === '') {
		callToolTip('cname', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#branch').find(":selected").text() === '') {
		callToolTip('branchDiv', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#department').find(":selected").text() === '') {
		callToolTip('departmentDiv', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#name').val().trim() === '') {
		callToolTip('name', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#description').val().trim() === '') {
		callToolTip('description', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#category').val().trim() === '') {
		callToolTip('categoryDiv', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#platform').val().trim() === '') {
		callToolTip('platformDiv', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#empPic').val().trim() === '') {
		callToolTip('empPic', 'show');
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

function saveSelfHelp() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/addSelfHelpMaster";
	var form = $('form')[0];
	var formData= new FormData(form);
	formData.append('branches',$('#branch').val().toString());
	formData.append('departments',$('#department').val().toString());
	$.ajax(
			{
				type : 'POST',
				url : serviceUrl,
				data: formData,
    	        mimeType: "multipart/form-data",
    	        contentType: false,
    	        processData: false,
    	        cache: false,
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
									+ "/Admin/SelfHelpMaster";
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
									+ "/Admin/SelfHelpMaster";
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
									+ "/Admin/SelfHelpMaster";
						}

					});

				}
			});
}

function downFile() {
	var filename = $('#filename').val();
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	window.location = base_url + "/Master/DownloadSelfHelpFile?filename=" + encodeURIComponent(filename) + '&selfhelpid=' + $('#sr_no1').val();
}

function viewDetails(id) {
	//alert(id)	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/gatherSelfHelpDetails";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'selfhelpid=' + id,

		success : function(data) {

			var T_DESC = data[0]["DESCRIPTION"];
			var ATTACH_NAME = data[0]["ATTACH_NAME"];

			$("#descriptionupdateTD").val(T_DESC);
			$('#hidedownload').show();
			$('#nofileattach').hide();
			document.getElementById('empPic').innerHTML = ATTACH_NAME;
			document.getElementById('filename').value = ATTACH_NAME;

		}
	});
	$('#sr_no1').val(id);
	$("#modaldescription").modal("show");
}

function editDetails(srno,company,branch,department,name,description,category,
		platform) {
	
	hideToolTip();
//	$.fn.modal.Constructor.prototype.enforceFocus = function() {};
	$('#sr_no2').val(srno);
	$('#cnameupdate').val(company);
	$('#branchupdate').val(branch);
	$('#departmentupdate').val(department);
	$('#nameupdate').val(name);
	$('#descriptionupdate').val(description);
	$('#categoryupdate').val(category).trigger('change');;
	$('#platformupdate').val(platform).trigger('change');;
	$('#modaledit').modal('show');
}

$('#update-btn').click(function() {
	event.preventDefault();
	if (!validateSelfHelpUpdate()) {
		event.preventDefault();
	} else {
		$(this).prop("disabled", true);
		$('#resetupdatebtn').prop("disabled", true);
		$(this).html(
				'Update <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>'
		);
		updateSelfHelp();
	}
})

$('#resetupdatebtn').click(function() {
	callToolTipUpdate('nameupdate', 'hide');
	callToolTipUpdate('descriptionupdate', 'hide');
	callToolTipUpdate('categoryupdateDiv', 'hide');
	callToolTipUpdate('platformupdateDiv', 'hide');
	callToolTipUpdate('empPic1', 'hide');
	$('#nameupdate').val('');
	$('#descriptionupdate').val('');
	$('#categoryupdate').val('').trigger('change');
	$('#platformupdate').val('').trigger('change');
	$('#empPic1').val('');
})

var callToolTipUpdate = function(fieldName, status) {

	if (fieldName == "cnameupdate") {
		var errorMessage = "<span>Please Select Company Name<span>";
	} else if (fieldName == "branchupdateDiv") {
		var errorMessage = "<span>Please Select Branch Name<span>";
	} else if (fieldName == "departmentupdateDiv") {
		var errorMessage = "<span>Please Select Department<span>";
	} else if (fieldName == "nameupdate") {
		var errorMessage = "<span>Please Enter Name<span>";
	} else if (fieldName == "descriptionupdate") {
		var errorMessage = "<span>Please Enter Description<span>";
	} else if (fieldName == "categoryupdateDiv") {
		var errorMessage = "<span>Please Select Category Name<span>";
	} else if (fieldName == "platformupdateDiv") {
		var errorMessage = "<span>Please Select Platform<span>";
	} else if (fieldName == "empPic1") {
		var errorMessage = "<span>Please Attach File<span>";
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

// On focus event
$('#nameupdate').on('click', function() {
	callToolTipUpdate('nameupdate', 'destroy');
});
$('#descriptionupdate').on('click', function() {
	callToolTipUpdate('descriptionupdate', 'destroy');
});
$('#categoryupdateDiv').on('click', function() {
	callToolTipUpdate('categoryupdateDiv', 'destroy');
});
$('#platformupdateDiv').on('click', function() {
	callToolTipUpdate('platformupdateDiv', 'destroy');
});
$('#empPic1').on('click', function() {
	callToolTipUpdate('empPic1', 'destroy');
});

function validateSelfHelpUpdate() {
	var indexError = 0;

	if ($('#nameupdate').val().trim() === '') {
		callToolTipUpdate('nameupdate', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#descriptionupdate').val().trim() === '') {
		callToolTipUpdate('descriptionupdate', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#categoryupdate').val().trim() === '') {
		callToolTipUpdate('categoryupdateDiv', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#platformupdate').val().trim() === '') {
		callToolTipUpdate('platformupdateDiv', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#empPic1').val().trim() === '') {
		callToolTipUpdate('empPic1', 'show');
		/*if (indexError == 0) {

		}
		indexError = indexError + 1;*/
		if ($('#empPic1').val() == '') {
			indexError12 = 0;
		} else {
			indexError12 = 12;
		}
	}
	if (indexError > 0) {
		return false;

	} else {
		return true;
	}
}


function updateSelfHelp() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/updateSelfHelpMaster";
	var form = $('form')[1];
	var formData= new FormData(form);
//	formData.append('branches',$('#branch').val().toString());
//	formData.append('departments',$('#department').val().toString());
	$.ajax(
			{
				type : 'POST',
				url : serviceUrl,
				data: formData,
    	        mimeType: "multipart/form-data",
    	        contentType: false,
    	        processData: false,
    	        cache: false,
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
									+ "/Admin/SelfHelpMaster";
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
									+ "/Admin/SelfHelpMaster";
						}

					});

				} else if (data == "error") {
					swal({
						title : "Unsuccessful!",
						text : "Fail to Update file",
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
									+ "/Admin/SelfHelpMaster";
						}

					});

				}
			});
}
