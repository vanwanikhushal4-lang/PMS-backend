window.onload = function() {
	
//	getLocation() 
//	getSiteDetails()

	$(".setscope").multiselect({
		includeSelectAllOption : true,
		buttonWidth : '100%',
		enableFiltering : true,
		enableCaseInsensitiveFiltering : true,
		maxHeight : 200

	});
	// //alert("ggggg")
	// $('#user').val("");
//	$('#cname').select2({
//		// theme: 'bootstrap4'
//		tags : true,
//		placeholder : "Select a Company or Enter New",
//	// allowClear: true
//	})
	$('#location').select2({
		// theme: 'bootstrap4'
		tags : true,
		placeholder : "Select a Location or Enter New",
	// allowClear: true
	})
	$('#dname').select2({
		// theme: 'bootstrap4'
		tags : true,
		placeholder : "Select a Department or Enter New",
	// allowClear: true
	})
	$('#designation').select2({
		// theme: 'bootstrap4'
		tags : true,
		placeholder : "Select a Designation or Enter New",
	// allowClear: true
	})
	$(".customMulti").multiselect({
		includeSelectAllOption : true,
		buttonWidth : '100%',
		enableFiltering : true,
		enableCaseInsensitiveFiltering : true

	});
	$("#categoryMulti").multiselect({
		includeSelectAllOption : true,
		buttonWidth : '100%',
		enableCaseInsensitiveFiltering : true,
		enableFiltering : true,

	});
	$("#groupMulti").multiselect({
		includeSelectAllOption : true,
		buttonWidth : '100%',
		enableCaseInsensitiveFiltering : true,
		enableFiltering : true,

	});
	$("#groupMultiser").multiselect({
		includeSelectAllOption : true,
		buttonWidth : '100%',
		enableCaseInsensitiveFiltering : true,
		enableFiltering : true,

	});

//	// document.getElementById("englevel").disabled = true;
//
//	// $('#fname').focus();
	 var l = window.location;
	 var base_url = l.protocol + "//" + l.host + "/" +
	 l.pathname.split('/')[1];
	 var serviceUrl = base_url + "/Master/getCompanyDetailsForLoginMaster";
	 $.ajax({
	 type: 'POST',
	 url: serviceUrl,
	 dataType: 'json',
	 async: false,
	 success: function(data4) {
	 //alert(data4)
	 // var pollingHost = data4;
	 // var d = pollingHost.split(",");
	 // var length = d.length - 1;
	 var html = " <option value=''> -- Please Select --</option>";
	 for (var i = 0; i < data4.length; i++) {
	 // //alert(data4[i]);
	 html += '<option value="' + data4[i] + '">' + data4[i]
	 + '</option>';
	 }
	
	 document.getElementById("cname").innerHTML = html;
//	 document.getElementById("perifheraltype0").innerHTML = html;
//	                     
//	 document.getElementById("cnameupdate").innerHTML = html;
	 }
	
	             
	 });

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getDepartmentDetails";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		async : false,
		// data: 'companyname=' + $("#cname").val(),
		success : function(data4) {

			var html;
			var html = "<option value=''> -- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				// //alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}

			// document.getElementById("dnameupdate").innerHTML = html;
		}

	});
	// //alert("hii")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getLoginMasterDetails";
	// var serviceUrl = "addEnggDetails";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {
			$("#preLoader").hide();
			$("#datatype").removeClass("d-none");
			var table = $('#datatype').DataTable(
					{
						lengthChange : false,
						data : data4,
						scrollX : true,
						"pageLength" : 5,
						"ordering" : false,
						initComplete : function() {
							$(this.api().table().container()).find(
									'input[type="search"]').parent().wrap(
									'<form>').parent().attr('autocomplete',
									'off').css('overflow', 'hidden').css(
									'margin', 'auto');
						}
					});

			table.buttons().container().appendTo(
					'#datatype_wrapper .col-sm-6:eq(0)');

		}

	});

}

function getsubdepartment() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSubDepartmentForLoginMaster";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'companyname=' + encodeURIComponent($("#cname").val())
				+ '&branchName=' + encodeURIComponent($("#sname").val())
				+ '&departmentName=' + encodeURIComponent($("#dname").val())
				+ '&location=' + encodeURIComponent($("#location").val()),
		success : function(data4) {
			// //alert(data4)
			// var pollingHost = data4;
			// var d = pollingHost.split(",");
			// var length = d.length - 1;
			var html = "  <option value=''> -- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				// //alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}

			document.getElementById("subDepartment").innerHTML = html;
			// document.getElementById("categoryupdate").innerHTML = html;
		}

	});

}
function getSiteDetails() {

	// ///alert()
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getBranchForLoginMastersInsert";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'companyname=' + encodeURIComponent($("#cname").val())
				+ '&location=' + encodeURIComponent($("#location").val()),
		success : function(data4) {
			// //alert(data4)

			var html = "  <option value=''> -- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				// //alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}
			document.getElementById("sname").innerHTML = html;
			// document.getElementById("categoryupdate").innerHTML = html;
		}

	});

}

function getLocation() {
	


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getLocationForLoginMaster";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'companyname=' + encodeURIComponent($("#cname").val()),
		success : function(data4) {
			
	

			var html = "  <option value=''> -- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				// //alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}
			document.getElementById("location").innerHTML = html;
		}

	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getDesignationForLoginMaster";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'company=' + encodeURIComponent($("#cname").val()),
		success : function(data4) {
			var html = "  <option value=''> -- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				// //alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}

			document.getElementById("designation").innerHTML = html;
		}

	});

	// Get Grop Details

	// var l = window.location;
	// var base_url = l.protocol + "//" + l.host + "/" +
	// l.pathname.split('/')[1];
	// var serviceUrl = base_url + "/Master/getGroupForLoginMaster";
	// $.ajax({
	// type: 'POST',
	// url: serviceUrl,
	// dataType: 'json',
	// data: 'companyname=' + encodeURIComponent($("#cname").val()),
	//     
	// async: false,
	// success: function(data4) {
	// // //alert(data4)
	// // var pollingHost = data4;
	// // var d = pollingHost.split(",");
	// // var length = d.length - 1;
	// var html = " <select class='form-control ' tabindex='8'
	// data-toogle='tooltip' multiple='multiple' name='groupMulti'
	// id='groupMulti'> ";
	// for (var i = 0; i < data4.length; i++) {
	// // //alert(data4[i]);
	// html += '<option value="' + data4[i] + '">' + data4[i]
	// + '</option>';
	// }
	// html += "</select>";
	// // //alert("ID:-"+id);
	// document.getElementById("groupDiv").innerHTML = html;
	//                    
	// }
	//
	//            
	// });
	//    

	$("#groupMulti").multiselect({
		includeSelectAllOption : true,
		buttonWidth : '100%',
		enableFiltering : true,
		enableCaseInsensitiveFiltering : true,
		maxHeight : 200

	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getGroupForLoginMaster";
	$
			.ajax({
				type : 'POST',
				url : serviceUrl,
				dataType : 'json',
				data : 'companyname=' + encodeURIComponent($("#cname").val()),

				async : false,
				success : function(data4) {
					// //alert(data4)
					// var pollingHost = data4;
					// var d = pollingHost.split(",");
					// var length = d.length - 1;
					var html = " <select class='form-control ' tabindex='8' data-toogle='tooltip' multiple='multiple'  name='groupMultiser' id='groupMultiser'> ";
					for (var i = 0; i < data4.length; i++) {
						// //alert(data4[i]);
						html += '<option value="' + data4[i] + '">' + data4[i]
								+ '</option>';
					}
					html += "</select>";
					// //alert("ID:-"+id);
					document.getElementById("groupCatDiv2ser").innerHTML = html;

				}
			});

	$("#groupMultiser").multiselect({
		includeSelectAllOption : true,
		buttonWidth : '100%',
		enableFiltering : true,
		enableCaseInsensitiveFiltering : true,
		maxHeight : 200

	});

}
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/getCategoryForLoginMaster";
$
		.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			data : 'companyname=' + encodeURIComponent($("#cname").val()),
			async : false,
			success : function(data4) {
				var html = " <select class='form-control ' tabindex='8' data-toogle='tooltip' multiple='multiple'  name='categoryMulti' id='categoryMulti'> ";
				for (var i = 0; i < data4.length; i++) {
					// //alert(data4[i]);
					html += '<option value="' + data4[i] + '">' + data4[i]
							+ '</option>';
				}
				html += "</select>";
				// //alert("ID:-"+id);
				document.getElementById("categoryDiv").innerHTML = html;

			}

		});

$("#categoryMulti").multiselect({
	includeSelectAllOption : true,
	buttonWidth : '100%',
	enableFiltering : true,
	enableCaseInsensitiveFiltering : true,
	maxHeight : 200

});
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/getGroupForLoginMasterAll";
$
		.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			data : 'json',

			async : false,
			success : function(data4) {

				var html = " <select class='form-control ' tabindex='8' data-toogle='tooltip' multiple='multiple'  name='groupMulti' id='groupMulti'> ";
				for (var i = 0; i < data4.length; i++) {

					html += '<option value="' + data4[i] + '">' + data4[i]
							+ '</option>';
				}
				html += "</select>";
				document.getElementById("groupDiv").innerHTML = html;

			}

		});
$("#groupMultiser").multiselect({
	includeSelectAllOption : true,
	buttonWidth : '100%',
	enableFiltering : true,
	enableCaseInsensitiveFiltering : true,
	maxHeight : 200

});

function setLevelScope() {
	callToolTip231('groupCatDiv2ser', 'hide');
	callToolTip231('visibility', 'hide');
	callToolTip231('groupDiv', 'hide');
	callToolTip231('categoryDiv', 'hide');

	/* document.getElementById("groupcheck").style.display = "none"; */
	document.getElementById("groupCatDiv1").style.display = "none";
	document.getElementById("groupCatDiv2").style.display = "none";
	/*
	 * document.getElementById("visibilitycheck").style.display = "none";
	 * document.getElementById("visibilitycheck").style.display = "none";
	 * document.getElementById("servicerequestcheck").style.display = "none";
	 */

	document.getElementById("servicerequestcheckbox").style.display = "none";
	document.getElementById("idofservicerequestcard").style.display = "none";

	// $('#servicerequestcheckbox').prop('checked', false);
	// //alert("setLevelScope");
	callToolTip231('englevel', 'hide');

	var role = $("#rtype").val();

	// //alert("role"+role)
	if (role.includes("Engineer")) {
		document.getElementById("groupCatDiv1").style.display = "block";
		document.getElementById("groupCatDiv2").style.display = "block";

	} else if (role.includes("Ticket Co-ordinator")) {
		// //alert("servicerequestcheck");
		document.getElementById("idofservicerequestcard").style.display = "block";
		document.getElementById("servicerequestcheckbox").style.display = "block";
		// document.getElementById("visibilitycheck").style.display = "block";
		// document.getElementById("groupcheck").style.display = "block";
	}

	else {
		document.getElementById("groupCatDiv1").style.display = "none";
		document.getElementById("groupCatDiv2").style.display = "none";
	}

	if (role.includes("Admin") || role.includes("User")) {

		document.getElementById("englevel").disabled = true;
		$("#englevel").val("");

		document.getElementById("loginScopeDive").style.display = "none";

	} else {

		document.getElementById("englevel").disabled = false;
		document.getElementById("loginScopeDive").style.display = "block";

	}

}

// CODE OF SERVICE REQUEST

/*
 * jQuery(".servicerequestcheckbox").click(function() {
 * if(jQuery(this).is(":checked")) {
 * document.getElementById("visibilitycheck").style.display = "block";
 * document.getElementById("groupcheck").style.display = "block";
 *  }
 * 
 * else{ document.getElementById("visibilitycheck").style.display = "none";
 * document.getElementById("groupcheck").style.display = "none";
 *  }
 * 
 * 
 * });
 */

function getDeptDetails() {
	// //alert($("#cname").val());
	// //alert($("#sname").val());

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getDepartmentForLoginMaster";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'companyname=' + encodeURIComponent($("#cname").val())
				+ '&branchName=' + encodeURIComponent($("#sname").val())
				+ '&location=' + encodeURIComponent($("#location").val()),
		success : function(data4) {
			// //alert(data4)
			// var pollingHost = data4;
			// var d = pollingHost.split(",");
			// var length = d.length - 1;
			var html = "  <option value=''> -- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				// //alert(data4[i]);
				html += '<option value="' + data4[i] + '">' + data4[i]
						+ '</option>';
			}

			document.getElementById("dname").innerHTML = html;
		}

	});

}

function validateEmail() {
	var ret = true;
	var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
	// console.log("email:"+.value)
	var emailField = $('#mail').val();
	// console.log('check email:' + reg.test($('#mail').val()))
	if (reg.test(emailField) == false) {
		// callToolTipWrong('email', 'show');
		ret = false;
	} else {
		ret = true;
	}
	return ret;
}

function phonenumber() {
	var inputtxt = $('#cno').val();
	console.log(inputtxt)
	var phoneno = /^\d{16}$/;
	// var phoneno = /^(\([0-9]{3}\)|[0-9]{3}-)[0-9]{3}-[0-9]{4}$/;
	if (inputtxt.match(phoneno)) {
		return true;
	} else {
		callToolTipWrong('phnnno', 'show');
		return false;
	}
}

function checkPassstrength() {
	var pass = $('#pass').val();
	var ret = true;
	;
	// //alert(pass)
	var specailcharatcers = "!#$%&'()*+,-./:;<=>?@[\]^_`{|}~";
	var passwordscore = 0;
	$('#note').show();
	// for (var i = 0; i < pass.length; i++)
	// {
	// if (specailcharatcers.indexOf(pass.charAt(i)) > -1)
	// {
	// passwordscore += 20;
	// }
	// }
	var charcount = 0;
	for (var i = 0; i < pass.length; i++) {

		if (specailcharatcers.indexOf(pass.charAt(i)) > -1) {
			// passwordscore += 20;
			charcount = charcount + 1;
			// //alert(charcount);
		}
	}
	if (charcount >= 3 || charcount <= 0) {
		// //alert("in false")
	} else {
		passwordscore += 20;
	}

	if (/[a-z]/.test(pass)) {
		console.log('inside lowercase')
		passwordscore += 20;
	}
	if (/[A-Z]/.test(pass)) {
		console.log('inside uppercase')
		passwordscore += 20;
	}
	if (/[\d]/.test(pass)) {
		console.log('inside numbers')
		passwordscore += 20;
	}
	if (pass.length >= 7) {
		console.log('inside length')
		passwordscore += 20;
	}
	// //alert(passwordscore)
	var strength = "Weak";
	if (passwordscore >= 100) {
		strength = "Strong";
	} else if (passwordscore >= 80) {
		strength = "Medium";
	} else if (passwordscore >= 60) {
		strength = "Weak";
	}

	// //alert('strength now:'+strength)
	document.getElementById('label').innerHTML = strength;
	$('#label').show();
	if (strength === "Strong") {
		document.getElementById('label').style.color = "green";
		$('#note').hide()
	} else if (strength === "Medium") {
		document.getElementById('label').style.color = "yellow";
		$('#note').show()
	} else if (strength === "Weak") {
		document.getElementById('label').style.color = "red";
		$('#note').show()
	}

	if (strength === "Strong") {
		callToolTipUpdate1('label', 'destroy');
		ret = true;
		$('#note').hide()
	} else {
		// callToolTipUpdate1('label', 'show');
		ret = false;

	}
	return ret;
}

/*
 * $("select").change(function() { //alert("Select"+$(this).val())
 * if($(this).val() == "") $(this).after(' <small> please select the correct
 * value</Small>'); else if($(this).next().prop("tagName").toLowerCase() ==
 * "small") $(this).next().remove(); });
 */

function validateEngMaster() {

	// //alert($('select[name="perifheraltype[]"] option:selected').val());

	var indexError = 0;
	var alphaExp = /^[a-zA-Z '.-]+$/;

	var role = $("#rtype").val();

	if (role.includes("Engineer")) {

		var categoryMultiselectedValues = [];
		$("#categoryMulti :selected").each(function() {
			categoryMultiselectedValues.push($(this).val());
		});

		if (categoryMultiselectedValues.toString() === '') {
			// callToolTippatch('oemdiv', 'show');
			callToolTip231('categoryDiv', 'show');
			if (indexError == 0) {
			}
			indexError = indexError + 1;
			console.log("In categoryMulti: " + indexError);
		} else {

			callToolTip231('categoryDiv', 'hide');
		}

		var groupMultiselectedValues1 = [];
		$("#groupMulti :selected").each(function() {
			groupMultiselectedValues1.push($(this).val());
		});
		if (groupMultiselectedValues1.toString() === '') {
			// callToolTippatch('oemdiv', 'show');
			callToolTip231('groupDiv', 'show');
			if (indexError == 0) {
			}
			indexError = indexError + 1;
			console.log("In groupMulti: " + indexError);
		} else {

			callToolTip231('groupDiv', 'hide');
		}

	} else {

		callToolTip231('groupDiv', 'hide');
		callToolTip231('categoryDiv', 'hide');
	}

	if (role.includes("Admin") || role.includes("User")) {

	} else if (role.includes("Engineer") || role.includes("IT-Head")
			|| role.includes("Ticket Co-ordinator")) {

		// //alert("counter:-"+counter)

		for (s = 0; s < counter; s++) {

			// var id='perifheraltype'+s;
			// //alert("id"+id)
			var id = 'perifheraltype' + s;
			if ($('#perifheraltype' + s).val() === '') {

				customTooltip(id, 'company', 'show');
				if (indexError == 0) {

				}
				indexError = indexError + 1;
				console.log("In Table Company: " + indexError);
			} else {
				customTooltip(id, 'company', 'hide');

			}

			var branchID = 'perifheralmanufacturer' + s;
			var branchDiv = 'perifheralmanufacturerDiv' + s;
			var selectedValues = [];
			$("#" + branchID + " :selected").each(function() {
				selectedValues.push($(this).val());
			});
			if (selectedValues.toString() === '') {
				// callToolTippatch('oemdiv', 'show');
				customTooltip(branchDiv, 'branch', 'show');
				if (indexError == 0) {
				}
				indexError = indexError + 1;
				console.log("In Table Branch: " + indexError);
			} else {

				customTooltip(branchDiv, 'branch', 'hide');
			}

			var deptID = 'perifheralserialno' + s;
			var deptDiv = 'perifheralserialnoDiv' + s;
			var selectedValues1 = [];
			$("#" + deptID + " :selected").each(function() {
				selectedValues1.push($(this).val());
			});

			if (selectedValues1.toString() === '') {
				// callToolTippatch('oemdiv', 'show');
				customTooltip(deptDiv, 'dept', 'show');
				if (indexError == 0) {
				}

				indexError = indexError + 1;
				console.log("In Table dept: " + indexError);
			} else {
				customTooltip(deptDiv, 'dept', 'hide');
			}

		}

	}

	if ($('#mail').val().trim() === '') {

		callToolTip231('mail', 'show');
		if (indexError == 0) {

		}
		console.log("In Mail" + indexError);
		indexError = indexError + 1;
	}

	else if (!validateEmail()) {
		// console.log('inside invalid email')
		callToolTipUpdate('email', 'show');
		indexError = indexError + 1;
		console.log("In validateEmail: " + indexError);
	}
	if ($('#cno').val().trim() === '') {
		callToolTip231('cno', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In cno: " + indexError);
	}
	// else if (!phonenumber())
	// {
	// // console.log('inside invalid contact number')
	// //callToolTipWrong('phnno', 'show');
	// indexError = indexError + 1;
	// console.log("In invalid contact number: "+indexError);
	//
	// }
	if ($('#fname').val().trim() === '') {
		callToolTip231('fname', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In fname: " + indexError);
	} else if (!$('#fname').val().trim().match(alphaExp)) {
		callToolTip231('fname1', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In fnamematch: " + indexError);
	}
	if ($('#lname').val().trim() === '') {
		callToolTip231('lname', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In lname: " + indexError);
	} else if (!$('#lname').val().trim().match(alphaExp)) {
		callToolTip231('lname1', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In lnamematch: " + indexError);
	}
	if ($('#user').val().trim() === '') {
		callToolTip231('user', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In user: " + indexError);
	}
	// else if (!$('#user').val().trim().match(alphaExp))
	// {
	// callToolTip231('user1', 'show');
	// if (indexError == 0) {
	//
	// }
	// indexError = indexError + 1;
	// console.log("In usermatch: "+indexError);
	// }

	if ($('#pass').val().trim() === '') {
		callToolTip231('pass', 'show');
		callToolTipUpdate1('label', 'hide');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In pass: " + indexError);

	}

	if ($('#Cpass').val().trim() === '') {
		callToolTip231('Cpass', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In Cpass: " + indexError);
	}

	if (!($('#Cpass').val().trim() === '' && $('#pass').val().trim() === '')) {
		if (!checkPass()) {
			indexError = indexError + 1;
			console.log("In pass compare: " + indexError);
		}

	}

	if (!checkPassstrength() && $('#pass').val().trim() !== '') {

		callToolTipUpdate1('label', 'show');
		indexError = indexError + 1;
		console.log("In checkPassstrength: " + indexError);
	}

	if ($('#type').val() === '') {
		callToolTip231('type', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In type: " + indexError);
	}
	if ($('#cname').val().trim() === '') {
		callToolTip231('cname', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In cname: " + indexError);
	}
//	if ($('#location').val().trim() === '') {
//		callToolTip231('location', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//		console.log("In location: " + indexError);
//	}
	
	
	if ($('#subDepartment').val().trim() === '') {
		callToolTip231('subDepartment', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In subDepartment: " + indexError);
	}

	if ($('#rtype').val().trim() === '') {
		callToolTip231('rtype', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In rtype: " + indexError);
	}

	if ($('#sname').val().trim() === '') {
		callToolTip231('sname', 'show');
		if (indexError == 0) {

		}
		indexError = indexError + 1;
		console.log("In sname: " + indexError);
	}
//	if ($('#dname').val().trim() === '') {
//		callToolTip231('dname', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//		console.log("In dname: " + indexError);
//	}
//	if ($('#designation').val().trim() === '') {
//		callToolTip231('designation', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//		console.log("In designation: " + indexError);
//	}

	if ($("#rtype").val() == 'Engineer' || $("#rtype").val() == 'IT-Head'
			|| $("#rtype").val() == 'Ticket Co-ordinator') {

		if ($('#englevel').val() == '') {
			// //alert("hiiii");
			// //alert($("#rtype").val() + " VALUE ")
			callToolTip231('englevel', 'show');

			if (indexError == 0) {

			}
			console.log("In englevel" + indexError);
			indexError = indexError + 1;
		}
	}
	if ($('#visibility').val() == ''
			&& $("#rtype").val() == 'Ticket Co-ordinator') {
		callToolTip231('visibility', 'show');

		if (indexError == 0) {

		}
		console.log("In visibility" + indexError);
		indexError = indexError + 1;
	}

	var selectedValues1 = [];
	$("#groupMultiser :selected").each(function() {
		selectedValues1.push($(this).val());
	});

	if (selectedValues1.toString() === ''
			&& $("#rtype").val() == 'Ticket Co-ordinator') {
		callToolTip231('groupCatDiv2ser', 'show');
		indexError = indexError + 1;
	}

	if (indexError > 0) {
		return false;

	} else {
		return true;
	}
}

var customTooltip = function(id, fieldName, status) {
	// //alert("inside customTooltip:-"+id+fieldName+status)
	if (fieldName == "company") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select company <span>";
	} else if (fieldName == "branch") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Branch<span>";
	} else if (fieldName == "dept") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Department<span>";
	}

	$("#" + id).tooltip({
		trigger : 'manual',
		placement : 'top',
		title : errorMessage,
		animation : true,
		delay : 1000,
		html : true
	});

	if (status == "show") {
		// //alert("show:-"+id)
		$("#" + id).tooltip('show');

	} else {
		$("#" + id).tooltip('hide');
	}

}

var callToolTip231 = function(fieldName, status) {

	if (fieldName == "user") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter User Name<span>";
	} else if (fieldName == "pass") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Password<span>";
	} else if (fieldName == "Cpass") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Confirm Password<span>";
	} else if (fieldName == "pass") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Password<span>";
	} else if (fieldName == "fname") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter First Name<span>";
	} else if (fieldName == "fname1") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Character only for First Name<span>";
	} else if (fieldName == "lname") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Last Name<span>";
	} else if (fieldName == "lname1") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Character only for Last Name<span>";
	} else if (fieldName == "user1") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>lease Enter Character only for Last Name<span>";
	} else if (fieldName == "mail") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Email-ID<span>";
	} else if (fieldName == "cno") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Contact Number<span>";
	} else if (fieldName == "type") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Type<span>";
	} else if (fieldName == "passnotmatch") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Password Not Matched!<span>";
	} else if (fieldName == "passwreset") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Password<span>";
	} else if (fieldName == "usernamereset") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Username<span>";
	} else if (fieldName == "cpassreset") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Confirm Password<span>";
	} else if (fieldName == "cpassreset") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Confirm Password<span>";
	} 
	else if (fieldName == "cname") {
		
		var errorMessage = "<span>Please Select Company Name<span>";
	}
	
	else if (fieldName == "location") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select  Location<span>";
	} else if (fieldName == "subDepartment") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Sub-Department<span>";
	} else if (fieldName == "rtype") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Role Type<span>";
	} else if (fieldName == "sname") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Branch Name<span>";
	} else if (fieldName == "dname") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Department Name<span>";
	} else if (fieldName == "groupDiv") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Group<span>";
	} else if (fieldName == "categoryDiv") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Select Category<span>";
	} else if (fieldName == "designation") {
		var errorMessage = "<span>Please Select Designation</span>"
	} else if (fieldName == "englevel") {
		var errorMessage = "<span>Please Select Level</span>"
	} else if (fieldName == "visibility") {
		var errorMessage = "<span>Please Select Visibility</span>"
	} else if (fieldName == "groupCatDiv2ser") {
		var errorMessage = "<span>Please Select Group</span>"
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

$('#fname').on('focusout', function() {
	var alphaExp = /^[a-zA-Z '.-]+$/;
	var usertype = $('#fname ').val();

	if (usertype.trim() == "") {
		callToolTip231('fname', 'show');
	} else if (!usertype.trim().match(alphaExp)) {
		callToolTip231('fname1', 'show');
	} else {
		callToolTip231('fname', 'hide');
	}
});
$('#lname').on('focusout', function() {
	var alphaExp = /^[a-zA-Z '.-]+$/;
	var usertype = $('#lname ').val();

	if (usertype.trim() == "") {
		callToolTip231('lname', 'show');
	} else if (!usertype.trim().match(alphaExp)) {
		callToolTip231('lname1', 'show');
	} else {
		callToolTip231('lname', 'hide');
	}
});
$('#user').on('focusout', function() {
	var usertype = $('#user').val();

	if (usertype.trim() == "") {
		callToolTip231('user', 'show');
	} else {
		callToolTip231('user', 'hide');
	}
});
$('#pass').on('focusout', function() {
	var usertype = $('#pass').val();

	if (usertype.trim() == "") {
		callToolTip231('pass', 'show');
	} else {
		callToolTip231('pass', 'hide');
	}
});
$('#Cpass').on('focusout', function() {
	var usertype = $('#Cpass ').val();

	if (usertype.trim() == "") {
		callToolTip231('Cpass', 'show');
	} else {
		callToolTip231('Cpass', 'hide');
	}
});
$('#cname').on('focusout', function() {
	var usertype = $('#cname').val();

	if (usertype.trim() == "") {
		callToolTip231('cname', 'show');
	} else {
//		callToolTip231('cname', 'hide');
	}
});
//

$('#location').on('focusout', function() {
	var usertype = $('#location').val();

	if (usertype.trim() == "") {
		callToolTip231('location', 'show');
	} else {
	}
});
$('#subDepartment').on('focusout', function() {
	var usertype = $('#subDepartment').val();

	if (usertype.trim() == "") {
		callToolTip231('subDepartment', 'show');
	} else {
	}
});

$('#rtype').on('focusout', function() {
	var usertype = $('#rtype').val();

	if (usertype.trim() == "") {
		callToolTip231('rtype', 'show');
	} else {
	}
});

$('#sname').on('focusout', function() {
	var usertype = $('#sname').val();

	if (usertype.trim() == "") {
		callToolTip231('sname', 'show');
	} else {
	}
});
$('#dname').on('focusout', function() {
	var usertype = $('#dname').val();

	if (usertype.trim() == "") {
		callToolTip231('dname', 'show');
	} else {
	}
});
$('#mail').on('focusout', function() {
	var usertype = $('#mail ').val();

	if (usertype.trim() == "") {
		callToolTip231('mail', 'show');
	} else if (!validateEmail()) {
		console.log('invali email')
		callToolTipWrong('email', 'hide');
	} else {
		callToolTip231('mail', 'hide');
	}
});
$('#cno').on('focusout', function() {
	var usertype = $('#cno ').val();

	if (usertype.trim() == "") {
		callToolTip231('cno', 'show');
	} else {
		callToolTip231('cno', 'hide');
	}
});
$('#designation').on('focusout', function() {
	var usertype = $('#designation ').val();

	if (usertype.trim() == "") {
		callToolTip231('designation', 'show');
	} else {
		callToolTip231('designation', 'hide');
	}
});

$('#englevel').on('focusout', function() {
	var usertype = $('#englevel ').val();

	if (usertype.trim() == "") {
		callToolTip231('englevel', 'show');
	} else {
		callToolTip231('englevel', 'hide');
	}
});

$('#englevel').on('focus', function() {
	callToolTip231('englevel', 'destroy');
});

$('#user').on('focus', function() {
	callToolTip231('user', 'destroy');
});
$('#fname').on('focus', function() {
	callToolTip231('fname', 'destroy');
	callToolTip231('fname1', 'destroy');
});
$('#lname').on('focus', function() {
	callToolTip231('lname', 'destroy');
	callToolTip231('lname1', 'destroy');
});
$('#mail').on('focus', function() {
	callToolTipWrong('email', 'destroy');
	callToolTip231('mail', 'destroy');
});
$('#cno').on('focus', function() {
	callToolTip231('cno', 'destroy');
	callToolTipWrong('phnnno', 'hide');
});

$('#type').on('focus', function() {
	callToolTip231('type', 'destroy');
});
$('#pass').on('focus', function() {
	callToolTip231('pass', 'destroy');
});
$('#Cpass').on('focus', function() {
	callToolTip231('Cpass', 'destroy');
});
$('#cname').on('focus', function() {
	callToolTip231('cname', 'destroy');
});
$('#subDepartment').on('focus', function() {
	callToolTip231('subDepartment', 'destroy');
});
$('#location').on('focus', function() {
	callToolTip231('location', 'destroy');
});
$('#rtype').on('focus', function() {
	callToolTip231('rtype', 'destroy');
});
$('#sname').on('focus', function() {
	callToolTip231('sname', 'destroy');
});
$('#dname').on('focus', function() {
	callToolTip231('dname', 'destroy');
});
$('#designation').on('focus', function() {
	callToolTip231('designation', 'destroy');
});

$('#categoryDiv').on('click', function() {
	callToolTip231('categoryDiv', 'destroy');
});

$('#groupDiv').on('click', function() {
	callToolTip231('groupDiv', 'destroy');
});
$('#perifheraltype0').on('click', function() {
	callToolTip231('categoryDiv', 'destroy');
});

$('#categoryDiv').on('click', function() {
	callToolTip231('categoryDiv', 'destroy');
});
$('#visibility').on('focus', function() {
	callToolTip231('visibility', 'destroy');
});
$('#groupCatDiv2ser').on('click', function() {
	callToolTip231('groupCatDiv2ser', 'destroy');
});

var callToolTipUpdate1 = function(fieldName, status) {
	if (fieldName == "label") {
		var errorMessage = "<span>Password Must contain atleast one number,one lowercase,one uppercase and one special character<span>";
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

var callToolTipUpdate = function(fieldName, status) {
	if (fieldName == "mail") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Correct Email ID<span>";
	} else if (fieldName == "cno") {
		var errorMessage = "<span>Please Enter Correct Contact No<span>";
	} else if (fieldName == "pass") {
		var errorMessage = "<span>Please Enter Password More then 6 Characters<span>";
	} else if (fieldName == "usernameupdate") {
		var errorMessage = "<span>Please Enter Username<span>";
	} else if (fieldName == "fnameupdate") {
		var errorMessage = "<span>Please Enter First Name<span>";
	} else if (fieldName == "fnameupdate1") {
		var errorMessage = "<span>Please Enter Character only for First Name<span>";
	} else if (fieldName == "lnameupdate") {
		var errorMessage = "<span>Please Enter Last Name<span>";
	} else if (fieldName == "lnameupdate1") {
		var errorMessage = "<span>Please Enter Character only for Last Name<span>";
	} else if (fieldName == "mailupdate") {
		var errorMessage = "<span>Please Enter Email ID<span>";
	}

	else if (fieldName == "cnoupdate") {
		fieldName = "cnoupdate"
		$("#phnupdate").tooltip('destroy');
		var errorMessage = "<span>Please Enter Contact Number<span>";
	} else if (fieldName == "emailupdate") {
		var errorMessage = "<span>Please Enter Correct Contact Number<span>";
	} else if (fieldName == "phnupdate") {
		fieldName = "phnupdate"
		$("#cnoupdate").tooltip('destroy');
		var errorMessage = "<span>Please Enter Correct Contact Number<span>";
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

var callToolTipWrong = function(fieldName, status) {
	if (fieldName == "email") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Correct Email ID<span>";
	} else if (fieldName == "phnnno") {
		var errorMessage = "<span>Please Enter Correct Contact No<span>";
	} else if (fieldName == "emailupdate") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Correct Email ID<span>";
	} else if (fieldName == "cnoupdate") {
		var errorMessage = "<span>Please Enter Correct Contact No<span>";
	}

	else if (fieldName == "pass") {
		var errorMessage = "<span>Please Enter Password More then 6 Characters<span>";
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

var callToolTipUpdate = function(fieldName, status) {
	if (fieldName == "mail") {
		// $("#email").tooltip('destroy');
		var errorMessage = "<span>Please Enter Correct Email ID<span>";
	} else if (fieldName == "cno") {
		var errorMessage = "<span>Please Enter Correct Contact No<span>";
	} else if (fieldName == "pass") {
		var errorMessage = "<span>Please Enter Password More then 6 Characters<span>";
	} else if (fieldName == "usernameupdate") {
		var errorMessage = "<span>Please Enter Username<span>";
	} else if (fieldName == "fnameupdate") {
		var errorMessage = "<span>Please Enter First Name<span>";
	} else if (fieldName == "fnameupdate1") {
		var errorMessage = "<span>Please Enter Character only for First Name<span>";
	} else if (fieldName == "lnameupdate") {
		var errorMessage = "<span>Please Enter Last Name<span>";
	} else if (fieldName == "lnameupdate1") {
		var errorMessage = "<span>Please Enter Character only for Last Name<span>";
	} else if (fieldName == "mailupdate") {
		var errorMessage = "<span>Please Enter Email ID<span>";
	}

	else if (fieldName == "cnoupdate") {
		fieldName = "cnoupdate"
		$("#phnupdate").tooltip('destroy');
		var errorMessage = "<span>Please Enter Contact Number<span>";
	} else if (fieldName == "emailupdate") {
		var errorMessage = "<span>Please Enter Correct Contact Number<span>";
	} else if (fieldName == "phnupdate") {
		fieldName = "phnupdate"
		$("#cnoupdate").tooltip('destroy');
		var errorMessage = "<span>Please Enter Correct Contact Number<span>";
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

function checkPass() {
	var ret = true;
	// Store the password field objects into variables ...
	var pass1 = document.getElementById('pass');

	var pass2 = document.getElementById('Cpass');

	// Store the Confimation Message Object ...
	var message = document.getElementById('confirmMessage');
	// Set the colors we will be using ...
	var goodColor = "#66cc66";
	var badColor = "#ff6666";
	$('#note1').hide();
	if (pass1.value === "" && pass2.value === "") {
		ret = false;
	} else if (pass1.value == pass2.value) {

		pass2.style.backgroundColor = goodColor;

		document.getElementById('note1').innerHTML = "Password match!";
		document.getElementById('note1').style.color = "green";
		$('#note1').show();
		ret = true;
	} else {

		pass2.style.backgroundColor = badColor;
		document.getElementById('note1').innerHTML = "Password does not match!";
		document.getElementById('note1').style.color = "red";
		$('#note1').show();

		ret = false;
	}
	return ret;
}

$("#resetbtn").click(function() {
	// //alert("reset"+counter)

	document.getElementById("servicerequestcheckbox").style.display = "none";
	document.getElementById("idofservicerequestcard").style.display = "none";

	$("#visibility").val("");

	$("#groupMultiser option:selected").prop("selected", false);
	$("#groupMultiser").multiselect('refresh');
	$("#groupMultiser").val('');

	callToolTip231('groupCatDiv2ser', 'hide');
	callToolTip231('visibility', 'hide');

	for (s = 0; s < counter; s++) {

		// var id='perifheraltype'+s;
		// //alert("id"+id)

		var id = 'perifheraltype' + s;
		customTooltip(id, 'company', 'hide');
		$("#" + id).val("");

		var branchID = 'perifheralmanufacturer' + s;
		var branchDiv = 'perifheralmanufacturerDiv' + s;

		customTooltip(branchDiv, 'branch', 'hide');
		$("#" + branchID + " option:selected").prop("selected", false);
		$("#" + branchID).multiselect('refresh');
		$("#" + branchID).val('');

		var deptID = 'perifheralserialno' + s;
		var deptDiv = 'perifheralserialnoDiv' + s;

		customTooltip(deptDiv, 'dept', 'hide');
		$("#" + deptID + " option:selected").prop("selected", false);
		$("#" + deptID).multiselect('refresh');
		$("#" + deptID).val('');
	}

	document.getElementById("loginScopeDive").style.display = "none";
	document.getElementById("groupCatDiv1").style.display = "none";
	document.getElementById("groupCatDiv2").style.display = "none";
	$("#categoryMulti option:selected").prop("selected", false);
	$("#categoryMulti").multiselect('refresh');
	$("#categoryMulti").val('');

	$("#groupMulti option:selected").prop("selected", false);
	$("#groupMulti").multiselect('refresh');
	$("#groupMulti").val('');

	$("#fname").val("");
	$("#lname").val("");
	$("#user").val("");
	$("#cno").val("");
	$("#englevel").val("");

	$("#pass").val("");
	$("#Cpass").val("");
	$("#cname").val("");
	$("#location").val("");
	$("#subDepartment").val("");
	$("#sname").val("");
	$("#dname").val("");
	$("#mail").val("");

	$("#subDepartment").val("");
	$("#rtype").val("");
	$("#user").val("");
	$("#designation").val("");
	$('#vipLogin').prop('checked', false);

	callToolTip231('categoryDiv', 'hide');
	callToolTip231('groupDiv', 'hide');
	callToolTip231('user', 'hide');
	callToolTip231('pass', 'hide');
	callToolTip231('Cpass', 'hide');
	// callToolTip231('label', 'hide');
	callToolTip231('cname', 'hide');
	callToolTip231('subDepartment', 'hide');
	callToolTip231('location', 'hide');
	callToolTip231('rtype', 'hide');
	callToolTip231('sname', 'hide');
	callToolTip231('dname', 'hide');
	callToolTip231('fname', 'hide');
	callToolTip231('lname', 'hide');
	callToolTip231('mail', 'hide');
	callToolTipWrong('email', 'hide');
	callToolTip231('cno', 'hide');
	callToolTip231('englevel', 'hide');
	callToolTip231('user', 'hide');
	callToolTip231('pass', 'hide');
	callToolTip231('Cpass', 'hide');

	callToolTipUpdate1('label', 'hide');
	callToolTipWrong('phnnno', 'hide');
	callToolTip231('fname1', 'hide');
	callToolTip231('lname1', 'hide');
	callToolTip231('user1', 'hide');
	callToolTip231('designation', 'hide');
	$("#note").hide();
	$("#note1").hide();
	$("#label").html("");

	var pass2 = document.getElementById('Cpass');
	pass2.style.backgroundColor = "white";
	// document.getElementById('note1').style.color =white;

})

function Deleteengineer(srno) {
	// //alert("gdfsf"+srno)
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
				// //alert("deleteUserdddddddd")
				var l = window.location;
				var base_url = l.protocol + "//" + l.host + "/"
						+ l.pathname.split('/')[1];
				var serviceUrl = base_url + "/Master/DeleteLoginMasterData";

				$.ajax({
					type : 'POST',
					url : serviceUrl,
					data : 'crno=' + srno

				}).done(
						function(data) {
							// //alert("dfgsfd"+data)

							if (data == "success") {
								swal({
									title : "Successful!",
									text : "Record Deleted Successfully",
									type : "success",
									width : 300,
									height : 200,
									// showCancelButton: false,
									// confirmButtonClass: "btn btn-danger",
									// cancelButtonClass: "btn btn-danger
									// m-l-10",
									// confirmButtonText: "OK",
									buttons : false,
									allowOutsideClick : false,
									preConfirm : function() {
										var l = window.location;
										var base_url = l.protocol + "//"
												+ l.host + "/"
												+ l.pathname.split('/')[1];
										window.location.href = base_url
												+ "/Admin/LoginMaster";
									}

								})

							}

							else if (data == "error") {
								swal({
									title : "Unsuccessful!",
									text : "Fail to delete file",
									type : "success",
									width : 300,
									height : 200,
									// showCancelButton: false,
									// confirmButtonClass: "btn btn-danger",
									// cancelButtonClass: "btn btn-danger
									// m-l-10",
									// confirmButtonText: "OK",
									buttons : false,
									allowOutsideClick : false,
									preConfirm : function() {
										var l = window.location;
										var base_url = l.protocol + "//"
												+ l.host + "/"
												+ l.pathname.split('/')[1];
										window.location.href = base_url
												+ "/Admin/LoginMaster";
									}

								})

							}
						});
			})
}

var counter = 1;
$("#addrow")
		.on(
				"click",
				function() {

					// //alert("addrow:"+counter)

					// var FirstRow = $("<tr><td>Peripheral
					// type</td><td>Manufacturer</td><td>Serial
					// Number</td><td>Name </td></tr>");
					/*
					 * if(counter>0){ customBtnID=counter-1; var myobj =
					 * document.getElementById("btnID"+ customBtnID );
					 * myobj.remove(); }
					 */
					var newRow = $("<tr>");
					var cols = "";

					cols += '<td ><select class="form-control" tabindex="6" style=" width: 100%;" data-toogle="tooltip"  onchange="getBranchDetails(\''
							+ counter
							+ '\')" onclick="clearTooltipFunction(this.id)" name="perifheraltype[]" id="perifheraltype'
							+ counter + '"></select></td>';
					cols += '<td><div class="form-group" id="perifheralmanufacturerDiv'
							+ counter
							+ '" onclick="branchtooltipremove(this.id)"><select class="form-control customMulti" tabindex="6" data-toogle="tooltip" multiple="multiple" onchange="getDepart(\''
							+ counter
							+ '\')" name="perifheralmanufacturer[]" id="perifheralmanufacturer'
							+ counter + '"></select></div></td>';
					cols += '<td><div class="form-group" id="perifheralserialnoDiv'
							+ counter
							+ '" onclick="departmenttooltipremove(this.id)"><select class="form-control customMulti" tabindex="6" data-toogle="tooltip"  multiple="multiple" name="perifheralserialno[]" id="perifheralserialno'
							+ counter + '"></select></div></td>';

					/*
					 * cols += '<td><button class="ibtnDel btn btn-sm
					 * btn-danger" id="btnID'+ counter + '"><i class="fa
					 * fa-window-close"></i></button></td>';
					 */

					newRow.append(cols);
					$("table.order-list").append(newRow);
					counter++;

					// //alert("counter:-"+counter)

					var l = window.location;
					var base_url = l.protocol + "//" + l.host + "/"
							+ l.pathname.split('/')[1];
					var serviceUrl = base_url
							+ "/Master/getCompanyDetailsForLoginMaster";
					$
							.ajax({
								type : 'POST',
								url : serviceUrl,
								dataType : 'json',
								success : function(data4) {
									// //alert(data4)
									// var pollingHost = data4;
									// var d = pollingHost.split(",");
									// var length = d.length - 1;
									var html = "  <option value=''> -- Please Select --</option>";
									for (var i = 0; i < data4.length; i++) {
										// //alert(data4[i]);
										html += '<option value="' + data4[i]
												+ '">' + data4[i] + '</option>';
									}
									// //alert(html);

									var count = counter - 1;
									// //alert("addCompany "+count)

									// //alert("perifheraltype"+count);
									document.getElementById("perifheraltype"
											+ count).innerHTML = html;

								}

							})
					$(".customMulti").multiselect({
						includeSelectAllOption : true,
						buttonWidth : '100%',
						enableFiltering : true,
						enableCaseInsensitiveFiltering : true,
						maxHeight : 200

					});

				});

/*
 * $("table.order-list").on("click", ".ibtnDel", function(event) {
 * $(this).closest("tr").remove();
 *  // counter -= 1
 * 
 * });
 */

$("#deleteRow").click(function() {
	// //alert("deleteRow:-"+counter)
	if (counter > 1) {
		var table = document.getElementById("perifheralTable");
		// var rowCount = table.rows.length;
		// //alert("rowCount"+counter);

		table.deleteRow(counter);
		counter -= 1

	}
});

$("#submit-btn").click(function() {
	// //alert("submit-btn click");
	if (!validateEngMaster()) {
//
		event.preventDefault();
	} else {

		// //alert("valid");
		saveDataUser();
	}
});

function saveDataUser() {
	// //alert("in save: "+counter);

	var formData = new FormData($('#addhardwareform')[0]);
	var vipLoginVal;

	if ($('#vipLogin').is(":checked")) {
		vipLoginVal = "true";

	} else {
		vipLoginVal = "false";

	}

	// //alert("vipLoginVal:-"+vipLoginVal)

	var role = $("#rtype").val();
	var row = "";
	if (role.includes("Admin") || role.includes("User")) {
		row = "NA";
	} else {

		for (s = 0; s < counter; s++) {

			var company = $('#perifheraltype' + s).val();
			var branch = $('#perifheralmanufacturer' + s).val();
			var department = $('#perifheralserialno' + s).val();

			// var newRow = "(T_COMPANY IN ('"+company+"') AND T_BRANCH IN
			// ('"+branch+"') AND T_DEPARTMENT IN ('"+department+"'))";
			row += "(T_COMPANY IN ('" + company + "') AND T_BRANCH IN ('"
					+ branch + "') AND T_DEPARTMENT IN ('" + department + "'))";
			if (s != counter - 1) {
				row += " OR ";
			}
			// //alert(row)
		}

	}
	// //alert("Row:"+row)

	var selectedValues = [];

	$(".setscope :selected").each(function() {
		selectedValues.push($(this).val());
	});

	var selectedSideBarValuesFinal = selectedValues.toString();

	

	var categoryMulti = "NA";
	var groupMulti = "NA";
	if (role.includes("Engineer")) {

		categoryMulti = $("#categoryMulti").val();
		groupMulti = $("#groupMulti").val();
	}
	// / //alert("groupMulti"+groupMulti)
	// //alert("categoryMulti"+categoryMulti)
	var groupmultiser = $("#groupMultiser").val()
	// //alert("check "+$("#groupMultiser").val());

	formData.append('groupMulti1', groupMulti);
	formData.append('categoryMulti1', categoryMulti);

	formData.append('row', row);
	// const myArray = row.split("OR");
	// var company1="";
	// var branch1="";
	// var dept1="";
	//	
	//	
	// for(var count=0;count<=myArray.length;count++)
	// {
	// var InnerArray = row.split("','");
	// for(var col=0;col<=InnerArray.length;col++)
	// {
	// company1=InnerArray[0];
	// branch1=InnerArray[1];
	// dept1=InnerArray[2];
	//						
	// if(myArray)
	// }
	//			
	// }

	formData.append('vipLoginVal', vipLoginVal);
	formData.append('designation', $("#designation").val());
	formData.append('visibility', $("#visibility").val());
	// //alert( "visibility checki"+$("#visibility").val());
	formData.append('groupMultiservice', groupmultiser);
	formData.append('selectedSideBarValuesFinal', selectedSideBarValuesFinal);
	

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/addLoginMasterData";
	
	$.ajax({
		url : serviceUrl,
		type : 'post',
		data : formData,

		contentType : false,
		processData : false,
		cache : false,
		success : function(data) {
			// //alert(data)
			if (data === "success") {
				// //alert("Inside if")

				/*
				 * Swal.fire({ position : 'top', icon : 'success', title :
				 * 'Record Inserted Successfully', showConfirmButton : false,
				 * timer : 3000 }).then(() => { location.reload();
				 *  })
				 */

				swal({
					title : "Successful!",
					text : "Record Inserted Successfully!",
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
						window.location.href = base_url + "/Admin/LoginMaster";
					}

				})

			} else if (data == "duplicate") {
				swal({
					title : "Duplicate!",
					text : "Record Exists",
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
						window.location.href = base_url + "/Admin/LoginMaster";
					}

				})

			}
		}
	})
}

function getBranchDetails(id) {
	// //alert($("#cname").val());

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getBranchForLoginMaster";
	$
			.ajax({
				type : 'POST',
				url : serviceUrl,
				dataType : 'json',
				data : 'companyname='
		+ encodeURIComponent($("#perifheraltype" + id).val()),
				success : function(data4) {
					// //alert(data4);
					// var d = pollingHost.split(",");
					// var length = d.length - 1;
					var html = " <select class='form-control customMulti' tabindex='8' data-toogle='tooltip' multiple='multiple' onchange='getDepart(\""
							+ id
							+ "\")' name='perifheralmanufacturer[]' id='perifheralmanufacturer"
							+ id + "'> ";
					for (var i = 0; i < data4.length; i++) {
						// //alert(data4[i]);
						html += '<option value="' + data4[i] + '">' + data4[i]
								+ '</option>';
					}
					html += "</select>";

					// //alert("ID:-"+id);
					document.getElementById("perifheralmanufacturerDiv" + id).innerHTML = html;
					multi(id);
				}

			});

}

function multi(id) {
	// //alert("perifheralmanufacturer multi")
	$(".customMulti").multiselect({
		includeSelectAllOption : true,
		buttonWidth : '100%',
		enableFiltering : true,
		enableCaseInsensitiveFiltering : true,
		maxHeight : 200

	});

}

function getDepart(id) {
	// //alert($("#cname").val());
	// //alert($("#sname").val());

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getDepartmentForUserScope";
	$
			.ajax({
				type : 'POST',
				url : serviceUrl,
				dataType : 'json',
				data : 'companyname='
						+ encodeURIComponent($("#perifheraltype" + id).val())
						+ '&branchName='
						+ encodeURIComponent($("#perifheralmanufacturer" + id)
								.val()),
				success : function(data4) {
					// //alert(data4)
					// var pollingHost = data4;
					// var d = pollingHost.split(",");
					// var length = d.length - 1;
					var html = " <select class='form-control customMulti' tabindex='8' data-toogle='tooltip' multiple='multiple'  name='perifheralserialno[]' id='perifheralserialno"
							+ id + "'> ";
					for (var i = 0; i < data4.length; i++) {
						// //alert(data4[i]);
						html += '<option value="' + data4[i] + '">' + data4[i]
								+ '</option>';
					}
					html += "</select>";
					// //alert("ID:-"+id);
					document.getElementById("perifheralserialnoDiv" + id).innerHTML = html;
					multi2(id);
				}

			});

}

function multi2(id) {
	// //alert("perifheralserialno multi:"+id)
	$("#perifheralserialno" + id).multiselect({
		includeSelectAllOption : true,
		buttonWidth : '100%',
		enableFiltering : true,
		enableCaseInsensitiveFiltering : true,
		maxHeight : 200

	});

}

function disableModal() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Admin/LoginMaster";

}

$('#modeleditengg').on('hidden.bs.modal', function(e) {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Admin/LoginMaster";
})

// //////////// MUBASHIR CODE FOR ON CLICK HIDE TOOLTIP ///////////////

// $("input[name=perifheraltype[]]").click(function() {
// //alert("hi")
// // var id = $(this).attr('id');
// // $container.cycle(id);
// // return false;
// });
// $('select[class="perifheraltype[]"]').click(function(){
// //alert("hi");
// });
// $("#perifheraltype1").click(function(){
// //alert("hi");
// });

function clearTooltipFunction(value) {
	// //alert(value)
	customTooltip(value, 'company', 'hide');
}
// //alert(value)

function branchtooltipremove(value) {
	// //alert(value);
	// //alert($("#"+value+" span select:first-child").attr('id'))

	var newid = $("#" + value + " span select:first-child").attr('id');

	// //alert(newid);
	customTooltip(value, 'branch', 'hide');
}
function departmenttooltipremove(value) {

	console.log("departmenttooltipremove");

	// //alert($("#"+value+" span select:first-child").attr('id'))
	var newid2 = $("#" + value + " span select:first-child").attr('id')

	customTooltip(value, 'dept', 'hide');
}

// ////////////////// CODE FOR BULK UPLOAD ////////////////
var callToolTipUpload = function(fieldName, status) {
	if (fieldName === "bulkUserData") {
		var errorMessage = "<span>Please Select a File<span>";
	}

	$("#" + fieldName).tooltip({
		trigger : 'manual',
		placement : 'top',
		title : errorMessage,
		animation : true,
		delay : 1000,
		html : true,
		at : 'center'
	});
	if (status == "show") {
		$("#" + fieldName).tooltip('show');
	} else {
		$("#" + fieldName).tooltip('hide');
	}
}

function validateBulkUploadUser() {
	
	var indexError = 0;

//Assuming #errorMessage is the element displaying the error message
function hideErrorMessage() {
callToolTipUpload('bulkUserData', 'destroy');
}

$('#bulkUserData').on('change', function () {
 hideErrorMessage();
});

if ($('#bulkUserData').val() === '') {
 // console.log('fill category');
 callToolTipUpload('bulkUserData', 'show');
 if (indexError == 0) {
     indexError = indexError + 1;
 }
} else {
 callToolTipUpload('bulkUserData', 'destroy');
}

if (indexError != 0) {
 return false;
} else {
 return true;
}
}

function submitUploadbutton() {
//	alert("submitUploadbutton")
	if (!validateBulkUploadUser()) {
		// //alert("failed");
		event.preventDefault();
	} else if (validateBulkUploadUser()) {
		// //alert("passed");
		submitBulkUploadUser();
	}
}

function submitBulkUploadUser() {
	 $('#spin12').show();
//		alert("inside submitBulkUploadUser")
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/saveBulkUploadUserData";

		var formData = new FormData($('#bulkuploaduserform')[0]);

		$
				.ajax({
					url : serviceUrl,
					type : 'post',
					data : formData,
					mimeType : "multipart/form-data",
					contentType : false,
					processData : false,
					cache : false,
					success : function(data) {
						 $('#spin12').hide();
//						alert("data"+data)

						var nameArr = data.split(',');
						if (nameArr[0] == "fileopen") {
							swal({
								// position : 'top',
								title : 'Failed',
								type : "error",
								html : nameArr[1],
								// showConfirmButton : true,
								buttons : false,
								allowOutsideClick : false,
								preConfirm : function() {
									location.reload();
								}
							})
						} else if (nameArr[0] == "formatIssue") {
							swal({
								// position : 'top',
								title : 'Failed',
								type : "error",
								html : nameArr[1],
								// showConfirmButton : true,
								buttons : false,
								allowOutsideClick : false,
								preConfirm : function() {
									location.reload();
								}
							})
						} else {
							var total = parseInt(nameArr[0]) + parseInt(nameArr[1]);
							var msgResponse;
							if (parseInt(nameArr[1]) !== 0) {
								msgResponse = "Total Records: "
										+ total+""
//										+ "<br>Inserted Records: "
//										+ nameArr[0]
//										+ "<br>Failed Records: "
//										+ nameArr[1]
//										+ "<br>Duplicate Records: "
//										+ nameArr[2]
//										+ "<br>Download Failed Records: <i class='nav-icon fas fa-download' onclick=downFile('"
//										+ encodeURIComponent(nameArr[2])
//										+ "')></i>"
							} else if (parseInt(nameArr[1]) === 0) {
								msgResponse = "Total Records: " + total+""
//										+ "<br>Inserted Records: " + nameArr[0]
//										+ "<br>Failed Records: " + nameArr[1] + "" +
//												+ "<br>Duplicate Records: " + nameArr[2] + ""
							}

							swal({
								title : "Data Inserted Successfully !",
								html : msgResponse,
								// text: "Ticket Raised Successfully",
								// type: "success",
								width : 300,
								height : 200,
								// showCancelButton: false,
								// confirmButtonClass: "btn btn-danger",
								// cancelButtonClass: "btn btn-danger m-l-10",
								// confirmButtonText: "OK",
								buttons : false,
								allowOutsideClick : false,
								preConfirm : function() {
									location.reload();
								}

							})
						}
					}
				})
}

$('#bulkUserData').change(function() {

	var fileName = $('#bulkUserData').val();
	var idxDot = fileName.lastIndexOf(".") + 1;
	var extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
	if (extFile == "xlsx") {

	} else {
		swal({
			position : 'top',
			title : 'warning',
			text : 'Accept Only .xlsx',
			showConfirmButton : false,
			timer : 3000
		})
		$('#bulkUserData').val("");
	}

})

function downFile(att) {

	// var filename = $('#filename').val();
	var filename = att;
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url
			+ "/Master/DownloadBulkUploadFailedFile?filename=" + filename;
}
function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : evt.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        return false;
    }
    return true;
}
