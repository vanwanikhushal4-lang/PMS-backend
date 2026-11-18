var companyforsubject = "";
window.onload = function() {
//	//alert("gfgggg")
//	
//	swal({
//		title : "Warning!",
//		html : "<b>This feature is under development and yet not completed.You can raise rerquest for testing purpose.</b>",
//		// text: "Ticket Raised Successfully",
//		type : "warning",
//		width : 300,
//		height : 200,
//		buttons : false,
//		allowOutsideClick : false,
//	});
//	
	// Use For IP Address
	$(":input").inputmask();
	
	$('#assetid').select2({
		// theme: 'bootstrap4'
		width : '80%',
		tags : false,
		placeholder : "Select Asset Name",

	// allowClear: true
	})
	$('#sname').select2({
		// theme: 'bootstrap4'
		width : '100%',
		tags : false,
		placeholder : "Select Software Name",

	// allowClear: true
	})

	callToolTip231()
	$('#groupnamediv').css('display', 'block');
	// $('#requestmode').focus();

	$('#approup').select2({
		tags : false,
		placeholder : "Select Approver",
	})

	// $('#itcompgroup').select2({
	// tags: true,
	// placeholder: "Select a User ",
	// })
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getAllUserDetails";
	$.ajax({

		type : 'POST',
		url : serviceUrl,
		async : false,
		dataType : 'json'

	}).done(function(data) {
		// //////////alert(data[0]["FULLNAME"])

		$('#name1').val(data[0]["FULLNAME"]);
		$('#emailid').val(data[0]["EMAIL"]);
		$('#phone').val(data[0]["PHONE"]);
		$('#compname').val(data[0]["COMPANY"]);
		companyforsubject = data[0]["COMPANY"];
		$('#site').val(data[0]["BRANCH"]);
		$('#department').val(data[0]["DEPARTMENT"]);
		$('#sub_department').val(data[0]["SUB_DEPARTMENT"]);
		$('#location').val(data[0]["LOCATION"]);
		$('#username').val(data[0]["USERNAME"]);
		$('#vipuser').val(data[0]["VIP_LOGIN"]);
	});

	// //////////// DATA FOR SUBJECT ///////
	// $('#Hideotherdata').css('display','none');

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/getPID";
	// //////////alert("VALUE "+$('#compname').val);
	// //////////alert("COMAPNY NAME "+ companyforsubject);
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',

		success : function(data2) {
			// ////alert(data2)
			var html = "  <option value=''> -- Please Select --</option>";
			for ( var i = 0; i < data2.length; i++) {
				html += '<option value="' + data2[i] + '">' + data2[i]
						+ '</option>';
			}
			document.getElementById("pid").innerHTML = html;
		}

	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/getSoftwares";

				$
			.ajax({
				type : 'POST',
				url : serviceUrl,
				dataType : 'json',

				success : function(data2) {
					
//					////alert(data2)
					var html = "<select class='form-control' tabindex='7' id='sname' name='sname' >  ";
					html += "<option value=''>-- Please Select --</option>"
					for ( var i = 0; i < data2.length; i++) {
						html += '<option value="' + data2[i] + '">' + data2[i]
								+ '</option>';
					}
					document.getElementById("sname").innerHTML = html;
				}

			});

	var str;
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getAssetFromOfLoginUser";

	$.ajax({

		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : 'loginuser=' + str,
	}).done(function(data) {

		// //////alert(data)
		var html = html + '<option value="">--Please Select Asset--</option>';
		for ( var i = 0; i < data.length; i++) {
			html += '<option value="' + data[i] + '">' + data[i] + '</option>';
		}

		document.getElementById("assetid").innerHTML = html;
	});

};
function getallinformationofAsset(asset) {
	document.getElementById("HideAssetdata").style.display = "none";

	if (asset.length > 0) {
		// ////////alert("inside");

		// ////////alert(asset);

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/"
				+ l.pathname.split('/')[1];
		var serviceUrl = base_url + "/UserActivity/GetAssetinformaion";

		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			data : 'asset=' + encodeURIComponent(asset),

			success : function(data) {
				// ////////alert(JSON.stringify(data))
				// ////////alert(data[0]["OTHEREMAIL"])
				var ASSET_NAME = data[0]["ASSET_NAME"];
				var ASSET_TAG = data[0]["ASSET_TAG"];
				var CATEGORY = data[0]["CATEGORY"];
				var ASSET_STATUS = data[0]["ASSET_STATUS"];

				var SUBCATEGORY = data[0]["ASSET_SUBCATEGORY"];
				var ASSET_IPADDRESS = data[0]["ASSET_IPADDRESS"];

				$("#aname").val(ASSET_NAME);
				$("#atag").val(ASSET_TAG);
				$("#acategory").val(CATEGORY);
				$("#astatus").val(ASSET_STATUS);
				$("#asset_sub_category").val(SUBCATEGORY).trigger('change');
				$("#asset_Ipaddress").val(ASSET_IPADDRESS);

			}
		});
		document.getElementById("HideAssetdata").style.display = "block";

	}
}
var loginuser;
$('#assetCheck').change(
				function() {
					if (this.checked) {
						// ////////alert("AFsd")

						document.getElementById("toggleAssetCheck").style.display = "block";
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"
								+ l.pathname.split('/')[1];
						var serviceUrl = base_url
								+ "/Master/getAssetFromOfLoginUser";
						$
								.ajax({
									url : serviceUrl,
									type : 'POST',
									dataType : 'json',
									data : 'loginuser=' + loginuser,
								})
								.done(
										function(data) {

											// ////////alert(data)
											var html = html
													+ '<option value="">--Please Select Asset--</option>';
											for ( var i = 0; i < data.length; i++) {
												html += '<option value="'
														+ data[i] + '">'
														+ data[i] + '</option>';
											}

											document.getElementById("assetid").innerHTML = html;
										});

					} else {
						document.getElementById("toggleAssetCheck").style.display = "none";
						document.getElementById("HideAssetdata").style.display = "none";
						callToolTip231('AssetDiv', 'hide');
						// $("#assetid").val();
						$("#assetid").select2('val', 'All');
					}
				});
function getCostAndRP() {
//	 ////alert($("#sname").val())
	 
	if (sname.length > 0) {
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/"
				+ l.pathname.split('/')[1];
		var serviceUrl = base_url + "/EFormActivity/GetSoftwareDetails";
		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			async : false,
			data : {sname:$("#sname").val()},
			success : function(data) {
				var COST = data[0].COST;
				var PERIOD = data[0].PERIOD;
			$("#cost").val(COST);
				$("#rperiod").val(PERIOD);s

			}
		});
	} else {
		$("#cost").val("");
		$("#rperiod").val("");
		$("#productcode").val("");
		$("#fromDate").val("");
		$("#activeD").val("");
	}
}
function CategoryType(cattype)
{
	//////alert(cattype)
	$('#ipaddresss').hide();
	$('#softwarename').hide();
	if(cattype==='Server')
		{
		$("#HideAssetdata").hide();
		$('#assetDivCheck').hide();
		$('#ipaddresss').show();
		callToolTip231('assetCheck', 'hide');
		callToolTip231('AssetDiv', 'hide');

		}
	else if(cattype==='Laptop'||cattype==='Desktop')
		{
		$("#HideAssetdata").show();
		callToolTip231('hostname', 'hide');
		callToolTip231('ipaddress','hide')
		callToolTip231('ownername', 'hide');
			$('#softwarename').show();
			$('#assetDivCheck').show();
		
		}
	else if(cattype===''||cattype==='Laptop'||cattype==='Desktop')
	{
		$('#assetDivCheck').show();
	}
}

//$('#phone').on("keyup", function () {
//	//alert("dff")
//    var value = $(this).val();
//    var regex_cell = /[^[0-9 +]]*/gi;
//    if  (regex_cell.test(value.value))
//    {
//    	true
//    }
//    
//});
// /////////// ONLOAD ENDS ////////////
//function getApprovalGroup(pid) {
//	$('#Hideassetdata').hide();
//	 if(pid.length>0)
//		 {	 	
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/EFormActivity/ApprovalGroup";
//	
//	////alert("hii")
//	$.ajax({
//		type : 'POST',
//		url : serviceUrl,
//		dataType : 'json',
//		async : false,
//		data : 'pid=' + pid,
//		success : function(data2) {
//			// ////alert(data2)
//			var html = "  <option value=''> -- Please Select--</option>";
//			for ( var i = 0; i < data2.length; i++) {
//				html += '<option value="' + data2[i] + '">' + data2[i]
//						+ '</option>';
//			}
//			document.getElementById("approup").innerHTML = html;
//		}
//	});
//	 
//}
//	
//	 else
//	 	{  
//		 	$("#pid").val("");
//		 	$("#approup").val("").trigger("change");
//		 	$("#Hideotherdata").hide()
//	 	}
//	 		
//	 
//	 if(pid.length>0 || $("#approup").val()=='')
//		{
//		 $("#Hideotherdata").hide()		
//		}
//				
//				
//	 
//
//}

// }approup
// if(pid>0)
// {
// ////////alert("iniif")
// $('#Hideotherdata').css('display','block');
// }
// else
// {
// $('#Hideotherdata').css('display','none');
// $("#approup").val("");
// }
//
function getApprovalDetails(approvalname) {
	
	//alert(approvalname)
	
	$('#Hideotherdata').css('display', 'block');
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getUserSelectedDetails";
	$.ajax({
		type : 'POST',
		
		url : serviceUrl,
		dataType : 'json',
		async : false,
		data : 'approvalname=' + approvalname,
		success : function(data) {
//			var result =JSON.stringify(data)
//			
//			if(result==='')
//				{
//				////alert("hi  iam dd")
//				}
//			else if(result!=''){
//			 ////alert(data[0]["COMPANY"]);
			var COMPANY = data[0]["COMPANY"];
			var BRANCH = data[0]["BRANCH"];
			var DEPARTMENT = data[0]["DEPARTMENT"];
			var FULLNAME = data[0]["FULLNAME"];
			var EMAIL = data[0]["EMAIL"];
			var ROLL_TYPE = data[0]["ROLL_TYPE"];
			$("#othercompname").val(COMPANY);
			$("#othersite").val(BRANCH);
			$("#otherdepart").val(DEPARTMENT);
			$("#otherfullname").val(FULLNAME);
			$("#otheremail").val(EMAIL);
			$("#roletype").val(ROLL_TYPE);
			}
//		}

	});

}


function submitRaise() {
	// //////////alert($("#priority").val());
//	alert("fgbvfdfvfvdfv")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/insertSoftwareRequest";
	var form = $('form')[0];
	var formData = new FormData(form);
	$.ajax({
		url : serviceUrl,
		type : 'post',
		data : formData,
		mimeType : "multipart/form-data",
		contentType : false,
		processData : false,
		cache : false,
		success : function(data) {
			// //////////alert(data);
			var nameArr = data.split(',');
			// //////////alert(nameArr[0]);
			// //////////alert(nameArr[1]);
			if (nameArr[0] === "success") {
				swal({
					title : "Successful!",
					html : "Request ID = " + nameArr[1]
							+ "<br>  Raised Successfully",
					// text: "Ticket Raised Successfully",
					type : "success",
					width : 300,
					height : 200,

					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						location.reload();
					}

				})
			}
		}
	});
}
var callToolTip231 = function(fieldName, status) {

	if (fieldName === "subjectDiv") {
		var errorMessage = "<span>Please Enter Subject<span>";
	}
	else if (fieldName === "hostname") {
		var errorMessage = "<span>Please Enter HostName<span>";
	}


	else if (fieldName === "description") {
		var errorMessage = "<span>Please Enter Business Justification<span>";
	}

	else if (fieldName === "phone") {
		var errorMessage = "<span>Please Select Contact No <span>";
	}

	else if (fieldName === "pid") {
		var errorMessage = "<span>Please Select Project ID <span>";
	} else if (fieldName === "appdiv") {
		var errorMessage = "<span>Please Select Approver Name <span>";
	} else if (fieldName === "AssetDiv") {
		var errorMessage = "<span>Please Select Asset Name <span>";
		
	} else if (fieldName === "assetCheck") {
		var errorMessage = "<span>Please Select Asset<span>";
		
	} else if (fieldName === "softDiv") {
		var errorMessage = "<span>Please Select  Software <span>";
	}
	else if (fieldName === "empPic") {
		var errorMessage = "<span> file size less thank 1 kb<span>";
	}
	else if(fieldName==="typecategory")
		{
			var errorMessage="<span>Select Request Category</span>";
		} 
		else if(fieldName==="ipaddress")
		{
			var errorMessage="<span>Please Enter IP</span>";
		}
		else if(fieldName==="ownername")
		{
			var errorMessage="<span>Please Enter Server Owner</span>"
		}
		else if(fieldName==="empic")
		{
			var errorMessage="<span>Please Enter Server Owner</span>"
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

var indexError12 = 0;
$('#empPic').on('change', function() {
	indexError12 = 12;
})

function validateForm() {
//	var valueoftype = $("#requesttype").val();
	
	var indexError = 0;

	if ($("#phone").val().trim() === '') {

		callToolTip231('phone', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	
	if (($('#typecategory').val() === 'Server' )&&(($('#hostname').val()==null)|| $('#hostname').val().trim()==='')){

		callToolTip231('hostname', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	
	if($("#typecategory").val().trim()==='')
		{
		callToolTip231('typecategory','show')
			if(indexError == 0)
				{}
				indexError = indexError + 1;
		}
	

	if ($('#pid').val().trim() === '') {

		callToolTip231('pid', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#sname').val() == '' || $('#sname').val() == null) {
		// console.log('fill sub');
		callToolTip231('softDiv', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
//	if()

//	if ((document.querySelector('#assetCheck:checked') == null)) {
////		&& !($('#typecategory').val() ==='Server' )
//		// ////////alert( document.querySelector('#levelone:checked'));
////		|| ($('#typecategory').val() === 'Desktop' || $('#typecategory').val()== '')
//		if($('#typecategory').val() === 'Desktop' || $('#typecategory').val()== ''||$('#typecategory').val() === 'Laptop')
//			{
//		callToolTip231('assetCheck', 'show');
//	
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//			}
//	}
	
//	var testCheckbox = document.getElementById("assetCheck");
//	//alert(document.querySelector('#assetCheck:checked'))
//	if (testCheckbox.checked) {
//aqlertr
		////alert("testCheckbox.checked")
		if ($('#assetid').val() == '' || $('#assetid').val() == null) {
			// console.log('fill sub');
//			//alert("assetid")
			if(($('#typecategory').val() === 'Desktop' || $('#typecategory').val()== ''||$('#typecategory').val() === 'Laptop'))
				{
//				//alert("fgg0")
			callToolTip231('AssetDiv', 'show');

			if (indexError == 0) {

			}
			indexError = indexError + 1;
				}
			else if($('#typecategory').val() === 'Server')
				{
				////alert("server")
				callToolTip231('AssetDiv', 'destroy');
				}
		}
//	}

	if ($('#approup').val() == '' || $('#approup').val() == null) {
		// console.log('fill sub');
		callToolTip231('appdiv', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	if ($('#description').val().trim() === '') {
//		console.log('fill description');
		callToolTip231('description', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	var typecat =$("#typecategory").val();
	if(typecat==='Server' &&($('#ownername').val().trim()==''))
		{
		
	if(($('#typecategory').val() === 'Server' )&&(($('#ipaddress').val()==null)||
			$('#ipaddress').val().trim()==''))
	{
	callToolTip231('ipaddress','show')
		if(indexError == 0)
			{}
			indexError = indexError + 1;
	}
		}
	if (($('#typecategory').val() === 'Server' )&&(($('#ownername').val()==null)||
			$('#ownername').val().trim()==''))
	{
//		//alert("inside server")
		callToolTip231('ownername', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
//	else if($('#typecategory').val() ==='Laptop' || $('#typecategory').val() === 'Desktop')
//	{
//		//alert("inside desktyop");
//		callToolTip231('ownername', 'show');
//		
//	}
	
	

	  if(indexError12 != 0)
	   {
	      const size= ($('#empPic')[0].files[0].size);
	     //(size);
//	      ////alert(size)
	    if(size<1)
	    {
	        callToolTip231('empPic', 'show');
	         indexError = indexError + 1;
	    }
//	    else if (size>(2e+8))
//	    	{
//	    		
//	    	}
	  
	   }
	console.log("validation error count::::" + indexError);
	if (indexError != 0) {

		// //////////alert("false");
		return false;

	} else {

		return true;
	}
}
//
// focus out

//$('#username1').on('focusout', function() {
//
//	var usertype = $('#username1').val();
//	if (usertype.trim() === "") {
//		callToolTip231('username1', 'show');
//	} else {
//		callToolTip231('username1', 'hide');
//	}
//});
// focus out

// focus out
// $('#sub').on('focusout', function () {
//
// var usertype = $('#sub').val();
// if (usertype.trim() == "") {
// callToolTip231('subjectDiv', 'show');
// }
// else {
// callToolTip231('subjectDiv', 'hide');
// }
// });
// focus out
//$('#description').on('focusout', function() {
//
//	var usertype = $('#description').val();
//	if (usertype.trim() == "") {
//		callToolTip231('description', 'show');
//	} else {
//		callToolTip231('description', 'hide');
//	}
//});
// focus out
$('#hostname').on('focus', function() {
	callToolTip231('hostname', 'destroy');
});

$('#empPic').on('focus', function() {
	callToolTip231('empPic', 'destroy');
});

$('#assetCheck').on('focus', function() {
	callToolTip231('assetCheck', 'destroy');
});
$('#pid').on('focus', function() {
	callToolTip231('pid', 'destroy');
});
$('#requestmode').on('focus', function() {
	callToolTip231('requestmode', 'destroy');
});
$('#approup').on('focus', function() {
	callToolTip231('appdiv', 'hide');
});
$('#description').on('focus', function() {
	callToolTip231('description', 'destroy');
});
$('#phone').on('focus', function() {
	callToolTip231('phone', 'destroy');
});
$('#typecategory').on('focus', function() {
	callToolTip231('typecategory', 'destroy');
});
$('#ipaddress').on('focus', function() {
	callToolTip231('ipaddress', 'destroy');
});
$('#ownername').on('focus', function() {
	callToolTip231('ownername', 'destroy');
});

$('#softDiv').on('click', function() {
	callToolTip231('softDiv', 'destroy');
});

$('#AssetDiv').on('click', function() {

	callToolTip231('AssetDiv', 'destroy');
});

$('#appdiv').on('click', function() {
	// ////////alert("dsdsdsd")
	callToolTip231('appdiv', 'destroy');
});
$("#resetbtn").click(function() {

	// document.getElementById("Hideotherdata").style.display = "none";
	$("#sname").val("");
	$("#phone").val("");
	$("#pid").val("");
	$("#requestmode").val("");
	$("#sname").val("").trigger("change");
	$("#approup").val("").trigger("change");
	$("#description").val("");
	
	$("#Hideotherdata").hide();
	
	$("#HideAssetdata").hide();
//	$("#toggleAssetCheck").hide();
	

	
	$("#counterSpan").hide()
	$("#typecategory").val("");
	$("#sname").val("");
	$("#ipaddresss").hide()
	$("#softwarename").hide()
	
	callToolTip231('hostname', 'hide');
	callToolTip231('AssetDiv', 'hide');
	callToolTip231('ipaddress', 'hide');
	callToolTip231('ownername', 'hide');
	callToolTip231('appDiv', 'hide');
	
	callToolTip231('phone', 'hide');
	callToolTip231('description', 'hide');
	callToolTip231('pid', 'hide');
	callToolTip231('appdiv', 'hide');
	callToolTip231('softDiv', 'hide');
	callToolTip231('assetCheck', 'hide');
	$('#assetCheck').prop('checked', false);
	callToolTip231('typecategory', 'hide');
	
	

	$("#empPic").val("");
	$("#othercompname").val("");
	$("#othersite").val("");
	$("#otherdepart").val("");
	$("#otherfullname").val("");
	$("#otheremail").val("");
	$("#cost").val("");
	$("#rperiod").val("");
	
	
	
	//callToolTip231('sname', 'hide');
	callToolTip231('requestmode', 'hide');
	
	callToolTip231('AssetDiv', 'hide');
	
	
	callToolTip231('empPic', 'hide');
	

	
	
});

function submitbutton101() {
//	//alert("in submit button");

	if (!validateForm()) {
		event.preventDefault();
	}
//	 else if(validateForm())
//	 {
//		 let reqType="Software_Request";
////		 //alert("dddddddd")
//		 var l = window.location;
//			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			var serviceUrl = base_url + "/EFormActivity/getSoftwareReleaseTicket";
//			$.ajax({
//				type : 'POST',
//				url : serviceUrl,
//				async : false,
//				dataType : 'text',
//				data:'sname='+encodeURIComponent($("#sname").val())+'&reqType='+reqType,
//		
//				success : function(data) {
//					if(data=='TICKET_FOUND')
//						{	
//						 swal({
//							 title: "Error!",
//							 html: "You have already raised the Request, Kindly change the Software name",
//							 type: "error",
//							 width: 300,
//							 height: 200,
//							 buttons: false,
//							 allowOutsideClick: false,
//							 preConfirm: function()
//							 {
//								location.reload();
//							 }                   
//							 })
//						
//						}
//					
//					else {
//					
//						submitRaise();
//					}
//					
//					
//				}
//			});
//	 }
	else if (validateForm()) {
		
		
		
		if ($('#site').val() === 'NA' || $('#department').val() === 'NA'
				|| $('#sub_department').val() === 'NA'
				|| $('#location').val() === 'NA') {
			// ////alert("in if")
			swal({
				title : "Error!",
				html : "Your Profile is incomplete. Kindly contact the Administrator to complete your profile.",
				type : "error",
				width : 300,
				height : 200,
				buttons : false,
				allowOutsideClick : false,
				preConfirm : function() {
					var l = window.location;
					var base_url = l.protocol + "//" + l.host + "/"
							+ l.pathname.split('/')[1];
					window.location.href = base_url + "/User/UpdateProfile";
				}

			})
			

		} 
		else if($('#otherfullname').val() === 'NA' 
//			|| $('#othersite').val() === 'NA'
//				|| $('#otherdepart').val() === 'NA'
				|| $('#othercompname').val() === 'NA'){
			swal({
				title : "Error!",
				html : "Approver Profile is incomplete, Please change Approver",
				type : "error",
				width : 300,
				height : 200,
				buttons : false,
				allowOutsideClick : false,
			})
		}
		
		else {

			submitRaise();
			$("#raise-btn").attr("disabled", true);
		}

	}
}

function getothersdata(othername) {
	// document.getElementById("Hideotherdata").style.display = "none";

	if (othername.length > 0) {
		// //////////alert("inside");

		// //////////alert(othername);
		// getting split for company and username

		const
		words = othername.split('~');
		// console.log(words[0]);
		var otherusername = words[0];

		// //////////alert(othercompany + "company");
		// //////////alert(otherusername + "otherusername ias");
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/"
				+ l.pathname.split('/')[1];
		var serviceUrl = base_url + "/UserActivity/Getotherinformaion";

		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			data : 'othername=' + encodeURIComponent(otherusername)
					+ '&othercompany='
					+ encodeURIComponent($("#compname").val()),

			success : function(data) {

				// //////////alert(data[0]["OTHEREMAIL"])
				var OTHEREMAIL = data[0]["OTHEREMAIL"];
				var OTHERFULLNAME = data[0]["OTHERFULLNAME"];
				var OTHERCOMPANY = data[0]["OTHERCOMPANY"];
				var OTHERBRANCH = data[0]["OTHERBRANCH"];
				var OTHERDEPARTMENT = data[0]["OTHERDEPARTMENT"];

				$("#otheremail").val(OTHEREMAIL);
				$("#otherfullname").val(OTHERFULLNAME);
				$("#othersite").val(OTHERBRANCH);
				$("#othercompname").val(OTHERCOMPANY);
				$("#otherdepart").val(OTHERDEPARTMENT);

			}
		});
		// document.getElementById("Hideotherdata").style.display = "block";

	}
}
function requestCategory(requestType)
{
//	////alert(requestType)
	if(requestType==='Laptop')
		{
		$("#typecategory").val("Laptop").trigger('change');
		}
	else if(requestType==='Desktop')
	{
	$("#typecategory").val("Desktop").trigger('change');
	}
}

function  characterCounter()
{
//	////alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("description").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  }
}

//use as phone no in 10 degit
function phoneno(){          
           $('#phone').keypress(function(e) {
               var a = [];
               var k = e.which;

               for (i = 48; i < 58; i++)
                   a.push(i);

               if (!(a.indexOf(k)>=0))
                   e.preventDefault();
           });
       }

