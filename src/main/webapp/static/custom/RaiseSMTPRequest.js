var companyforsubject = "";
window.onload = function() {
	$('#applicationServerloc').select2({
		
		width : '100%',
		tags : false,
		placeholder : "Select Location",
		

	// allowClear: true
	})
//	alert(" alert window "+ applicationServerloc)
	


	$('#groupnamediv').css('display', 'block');
	// $('#requestmode').focus();

	$('#approup').select2({
		tags : false,
		placeholder : "Select Approver Name ",
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
		// //////alert(data[0]["FULLNAME"])

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

//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/EFormActivity/getPID";
//	// //////alert("VALUE "+$('#compname').val);
//	// //////alert("COMAPNY NAME "+ companyforsubject);
//	$.ajax({
//		type : 'POST',
//		url : serviceUrl,
//		dataType : 'json',
//
//		success : function(data2) {
//			// alert(data2)
//			var html = "  <option value=''> -- Please Select --</option>";
//			for ( var i = 0; i < data2.length; i++) {
//				html += '<option value="' + data2[i] + '">' + data2[i]
//						+ '</option>';
//			}
//			document.getElementById("pid").innerHTML = html;
//		}
//
//	});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/GetLocationOfServer";
	// //////alert("VALUE "+$('#compname').val);
	// //////alert("COMAPNY NAME "+ companyforsubject);

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data2) {
//			alert("dsafcr"+code)
//	        alert("dxwx"+data2)
			var html = "  <option value=''> -- Please Select --</option>";
			for ( var i = 0; i < data2.length; i++) {
				html += '<option value="' + data2[i] + '">' + data2[i]
						+ '</option>';
			}
			document.getElementById("applicationServerloc").innerHTML = html;
		}

	});


};

$('#ExpDate').datetimepicker({
	
    autoclose: true,
    format: 'dd-mm-yyyy hh:ii',
    todayHighlight: !0,
    orientation:"bottom",
    fontAwesome: true,
    StartDate: new Date(),
    EndDate:'+180d',
    startDate: '-0m',
//    icons:{
//    	 up: "fa fa-arrow-up",
//         down: "fa fa-arrow-down",
//    }

//    endDate: new Date()
    
})
//.on('change', function() {
//   $(this).focus();
//       });


// function getitgroupName(approvalname)
// {
//
// // $('#HideITCompialncedata').css('display','block');
// var l=window.location;
// var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// var serviceUrl = base_url + "/Master/getUserSelectedDetails";
// $.ajax({
// type: 'POST',
// url: serviceUrl,
// dataType: 'json',
// async:false,
// data: 'approvalname=' + approvalname,
// success: function(data) {
// // //////alert(data[0].COMPANY);
// var COMPANY=data[0]["COMPANY"];
// var BRANCH=data[0]["BRANCH"];
// var DEPARTMENT=data[0]["DEPARTMENT"];
// var FULLNAME=data[0]["FULLNAME"];
// var EMAIL=data[0]["EMAIL"];
// var ROLL_TYPE=data[0]["ROLL_TYPE"];
// $("#itcomp").val(COMPANY);
// $("#itsite").val(BRANCH);
// $("#itdept").val(DEPARTMENT);
// $("#itfullname").val(FULLNAME);
// $("#itemail").val(EMAIL);
// $("#itroletype").val(ROLL_TYPE);
// }
//  
// });
// 
// };



// /////////// ONLOAD ENDS ////////////
//function getApprovalGroup(pid) {
//	// $('#Hideassetdata').css('display','none');
//	// if(pid.length>0)
//	// {
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/EFormActivity/ApprovalGroup";
//
//	$.ajax({
//		type : 'POST',
//		url : serviceUrl,
//		dataType : 'json',
//		async : false,
//		data : 'pid=' + pid,
//		success : function(data2) {
//			// alert(data2)
//			var html = "  <option value=''> -- Please Select --</option>";
//			for ( var i = 0; i < data2.length; i++) {
//				html += '<option value="' + data2[i] + '">' + data2[i]
//						+ '</option>';
//			}
//			document.getElementById("approup").innerHTML = html;
//		}
//	});
//	$('#Hideassetdata').css('display', 'block');
//	// }
//	// else
//	// {
//	// $('#Hideassetdata').css('display','none');
//	// }
//
//}

function getApprovalDetails(approvalname) {
	
//	alert("dsfaf"+approvalname)
	
	$('#Hideotherdata').css('display', 'block');
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/getSMTPUserSelectedDetails";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		async : false,
		data : 'approvalname=' + approvalname,
		success : function(data) {

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
//alert($("#priority").val());

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/insertSMTPSoftwareRequest";
	// emailid
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
//	alert("dvdfvd"+data);
			var nameArr = data.split(',');
			// //////alert(nameArr[0]);
			// //////alert(nameArr[1]);
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

//	if (fieldName === "subjectDiv") {
//		var errorMessage = "<span>Please Enter Subject<span>";
//	}

	if (fieldName === "description") {
		var errorMessage = "<span>Please Enter Note<span>";
	}

	else if (fieldName === "phone") {
		var errorMessage = "<span>Please Enter Contact No <span>";
	}

	else if (fieldName === "pid") {
		var errorMessage = "<span>Please Select Project ID <span>";
	} else if (fieldName === "appdiv") {
		var errorMessage = "<span>Please Select Approver Name <span>";
	}
	
	 else if (fieldName === "appserver") {
		var errorMessage = "<span>Please Enter Application Server <span>";
	}
	 else if (fieldName === "appserverIp") {
		var errorMessage = "<span>Please Enter Application Server IP <span>";
	}
	 else if (fieldName === "lcationDiv") {
		var errorMessage = "<span>Please Select Server Location Code <span>";
//	}
//	 else if (fieldName === "cityname") {
//		var errorMessage = "<span>Please Select Server Location City <span>";
	}
	 else if (fieldName === "noOfMail") {
		var errorMessage = "<span>Please Enter No Of Mails/Days <span>";
	}
	 else if (fieldName === "mailsize") {
		var errorMessage = "<span>Please Enter Average Mail Size <span>";
	}
	 else if (fieldName === "ExpDate") {
		var errorMessage = "<span>Please Select Expiry Date <span>";
	}

	else if (fieldName === "empPic") {
		var errorMessage = "<span> file size less than 1 kb<span>";
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
	

	

	if ($('#pid').val().trim() === '') {

		callToolTip231('pid', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	

	
	
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
	
	
	
		if ($('#appserver').val().trim() === '') {
//		console.log('fill description');
		callToolTip231('appserver', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
		if ($('#appserverIp').val().trim() === '') {
//		console.log('fill description');
		callToolTip231('appserverIp', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
		if ($('#applicationServerloc').val().trim() === '') {
//		console.log('fill description');
		callToolTip231('lcationDiv', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
//		if ($('#cityname').val().trim() === '') {
////		console.log('fill description');
//		callToolTip231('cityname', 'show');
//
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	}
		if ($('#noOfMail').val().trim() === '') {
//		console.log('fill description');
		callToolTip231('noOfMail', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
		if ($('#mailsize').val().trim() === '') {
//		console.log('fill description');
		callToolTip231('mailsize', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
		if ($('#ExpDate').val().trim() === '') {
//		console.log('fill description');
		callToolTip231('ExpDate', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	
	  if(indexError12 != 0)
	   {
	      const size= ($('#empPic')[0].files[0].size);
	     //(size);
	    if(size<1)
	    {
	        callToolTip231('empPic', 'show');
	         indexError = indexError + 1;
	    } 
	    else
	    {
	        callToolTip231('empPic', 'hide');
	    }
	   }
	console.log("validation error count::::" + indexError);
	if (indexError != 0) {

		// //////alert("false");
		return false;

	} else {

		return true;
	}

}


$('#empPic').on('focus', function() {
	callToolTip231('empPic', 'destroy');
});

$('#pid').on('focus', function() {
	callToolTip231('pid', 'destroy');
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

$('#appdiv').on('click', function() {
	// ////alert("dsdsdsd")
	callToolTip231('appdiv', 'destroy');
});

$('#appserver').on('focus', function() {
	// ////alert("dsdsdsd")
	callToolTip231('appserver', 'destroy');
});

$('#appserverIp').on('focus', function() {
	// ////alert("dsdsdsd")
	callToolTip231('appserverIp', 'destroy');
});
$('#lcationDiv').on('click', function() {
	// ////alert("dsdsdsd")
	callToolTip231('lcationDiv', 'destroy');
});
//$('#cityname').on('focus', function() {
//	// ////alert("dsdsdsd")
//	callToolTip231('cityname', 'hide');
//});
$('#noOfMail').on('focus', function() {
	// ////alert("dsdsdsd")
	callToolTip231('noOfMail', 'destroy');
});
$('#mailsize').on('click', function() {
	// ////alert("dsdsdsd")
	callToolTip231('mailsize', 'destroy');
});
$('#ExpDate').on('focus', function() {
	// ////alert("dsdsdsd")
	callToolTip231('ExpDate', 'destroy');
});

$("#resetbtn").click(function() {

	// document.getElementById("Hideotherdata").style.display = "none";
//	$("#sname").val("");
	$("#phone").val("");
//	$("#pid").val("");
	$("#approup").val("").trigger("change");
	$("#description").val("");
	$("#roletype").val("");
	$("#Hideotherdata").hide();
	
	$("#appserver").val("");
	$("#appserverIp").val("");
	$("#applicationServerloc").val("").trigger("change"); //lcationDiv , applicationServerloc , cityname
	$("#cityname").val("");
	$("#noOfMail").val("");
	$("#mailsize").val("");
	$("#ExpDate").val("");

	$("#empPic").val("");
	$("#othercompname").val("");
	$("#othersite").val("");
	$("#otherdepart").val("");
	$("#otherfullname").val("");
	$("#otheremail").val("");
	
	callToolTip231('appserver', 'hide');
	callToolTip231('appserverIp', 'hide');
	callToolTip231('lcationDiv', 'hide');
	callToolTip231('noOfMail', 'hide');
	callToolTip231('mailsize', 'hide');
	callToolTip231('ExpDate', 'hide');
	
//	callToolTip231('sname', 'hide');
	callToolTip231('phone', 'hide');
	callToolTip231('pid', 'hide');
	callToolTip231('appdiv', 'hide');
	callToolTip231('description', 'hide');
	callToolTip231('Hideotherdata', 'hide');
	callToolTip231('empPic', 'hide');
});

function submitbutton101() {
//	alert("in submit button");

	if (!validateForm()) {
//		 alerCt("failed");
		event.preventDefault();
	} else if (validateForm()) {
//alert("dssd")
		if ($('#site').val() === 'NA' || $('#department').val() === 'NA'
				|| $('#sub_department').val() === 'NA'
				|| $('#location').val() === 'NA') {
			// alert("in if")
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
				html : "Approvar Profile is incomplete, Please change Approvar",
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
		// //////alert("inside");

		// //////alert(othername);
		// getting split for company and username

		const
		words = othername.split('~');
		// console.log(words[0]);
		var otherusername = words[0];

		// //////alert(othercompany + "company");
		// //////alert(otherusername + "otherusername ias");
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

				// //////alert(data[0]["OTHEREMAIL"])
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
//	alert(requestType)
	if(requestType==='Laptop')
		{
		$("#typecategory").val("Laptop").trigger('change');
		}
	else if(requestType==='Desktop')
		{
		$("#typecategory").val("Desktop").trigger('change');
		
		}
}

function getallcity(Code)
{
	//alert("DF"+Code)
	//var sub = $("#subject").val().length;
		
			
			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/UserActivity/getCityData";
		    $.ajax({

		        url: serviceUrl,
		        type: 'POST',
		        data: 'Code=' + encodeURIComponent(Code),
		        dataType: 'json',
		    }).done(function (data) {
		    	var DESCRIPTION = data[0]["DESCRIPTION"];
		    	$("#cityname").val(DESCRIPTION);
		    
		    });
		
	
}

function  characterCounter()
{
//	alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("description").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}
