window.onload = function() {
	////alert("dfvfdx")
	
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
	
	// Use For IP Address
	$(":input").inputmask();
	
////alert(pid)
//console.log("sfgfggfgfg")
	$('#sname').select2({
		// theme: 'bootstrap4'
		width : '100%',
		tags : false,
		placeholder : "Select Software Name",

	
	})

	
	
	$('#groupnamediv').css('display', 'block');


	$('#approup').select2({
		tags : false,
		placeholder : "Select a User ",
	})

	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getAllUserDetails";
	$.ajax({

		type : 'POST',
		url : serviceUrl,
		async : false,
		dataType : 'json'

	}).done(function(data) {
		// ////////alert(data[0]["FULLNAME"])

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

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/getPID";
	// ////////////alert("VALUE "+$('#compname').val);
	// ////////////alert("COMAPNY NAME "+ companyforsubject);
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',

		success : function(data2) {
			// //////alert(data2)
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
	var serviceUrl = base_url + "/EFormActivity/getLoginUserSoftwares";

	
			$.ajax({
				type : 'GET',
				url : serviceUrl,
				dataType : 'json',
				success : function(data2) {
					
					var html = "<select class='form-control' tabindex='7' id='sname' name='sname' >  ";
					html += "<option value=''>-- Please Select --</option>"
					for ( var i = 0; i < data2.length; i++) {
						html += '<option value="' + data2[i] + '">' + data2[i]
								+ '</option>';
					}
					document.getElementById("sname").innerHTML = html;
					
				}
 
			});
			


	// var str;
	// var l = window.location;
	// var base_url = l.protocol + "//" + l.host + "/" +
	// l.pathname.split('/')[1];
	// var serviceUrl = base_url + "/Master/getAssetFromOfLoginUser";
	//
	// $.ajax({
	//
	// url : serviceUrl,
	// type : 'POST',
	// dataType : 'json',
	// data : 'loginuser=' + str,
	// }).done(function(data) {
	//
	// // ////alert(data)
	// var html = html + '<option value="">--Please Select Asset--</option>';
	// for ( var i = 0; i < data.length; i++) {
	// html += '<option value="' + data[i] + '">' + data[i] + '</option>';
	// }
	//
	// //document.getElementById("assetid").innerHTML = html;
	//	});

};
// ///getSoftware Details onchang////
function getCostAndRP(sname) {

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
			data : 'sname=' + sname,
			success : function(data) {
				////alert("if")
				var COST = data[0].COST;
				var PERIOD = data[0].PERIOD;
				$("#cost").val(COST);
				$("#rperiod").val(PERIOD);
			}
		});
	} else {
		////alert("else")
		$("#cost").val("");
		$("#rperiod").val("");
	}
}

function getAppDateAndAssetCode(sname) {
	 //alert("dcsdcscsdcdscd"+sname)
	if (sname.length > 0) {
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/"
				+ l.pathname.split('/')[1];
		var serviceUrl = base_url + "/EFormActivity/GetSoftwareDetailOfLoginUser";

		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			async : false,
			data : 'sname=' + encodeURIComponent(sname),
			success : function(data) {
				////alert("if")
				var COST = data[0].COST;
				var PERIOD = data[0].PERIOD;
				$("#cost").val(COST);
				$("#rperiod").val(PERIOD);
			}
		});
	} else {
		////alert("else")
		$("#cost").val("");
		$("#rperiod").val("");
	}
}

function submitbutton101() {
	
//	//alert("in submit button");
//var ticket_info="";
	
//		//alert(ticket_info+"dfgsdfdfdfdffg")
	 if(!validateForm())
	 {
//	 //alert("failed");
	 event.preventDefault();
	 }
//	 else if(validateForm())
//	 {
//
//		 let reqType="Software_Release";
//		 var l = window.location;
//			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			var serviceUrl = base_url + "/EFormActivity/getSoftwareReleaseTicket";
//			$.ajax({
//				type : 'POST',
//				url : serviceUrl,
//				async : false,
//				dataType : 'text',
//				data:'sname='+encodeURIComponent($("#sname").val())+'&reqType='+reqType,
//				success : function(data) {
//					if(data=='TICKET_FOUND')
//						{	
//						 swal({
//							 title: "Error!",
//							 html: "Your have already raised the Request, Kindly change the Software name",
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
	 else if(validateForm())
	 {
	 // a
	 ////alert("fh")
	 if($('#site').val()==='NA' || $('#department').val()==='NA' ||
	 $('#sub_department').val()==='NA' || $('#location').val()==='NA')
	 {
	// //alert("in if")
	 swal({
	 title: "Error!",
	 html: "Your Profile is incomplete. Kindly contact the Administrator to complete your profile.",
	 type: "error",
	 width: 300,
	 height: 200,
	 buttons: false,
	 allowOutsideClick: false,
	 preConfirm: function() {
	 var l = window.location;
	 var base_url = l.protocol + "//" + l.host + "/" +
	 l.pathname.split('/')[1];
	 window.location.href = base_url + "/User/UpdateProfile";
	 }
	                    
	                    
	 })
	        		
	 }
	 else{

	submitRaise();
	$("#raise-btn").attr("disabled", true);
	 }
	    
	 }
}
function submitRaise() {
	// ////////alert($("#priority").val());

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/insertSoftwareRelease";
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

			var nameArr = data.split(',');

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
	 
	 function  characterCounter()
	 {
	 		
	 	$("#counterSpan").show();
	 	
	 	  var i = document.getElementById("description").value.length;
	 	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	 	  if(i<=0)
	 	  {
	     	  $("#calulateId").val("");
	 	  };
	 }
	 
	
	
	 $("#resetbtn").click(function() {

			// document.getElementById("Hideotherdata").style.display = "none";
		 
			$("#sname").val("");
			$("#phone").val("");
			$("#pid").val("");
			$("#requestmode").val("");
			$("#assetid").val("").trigger("change");
			$("#approup").val("").trigger("change");
			$("#typecategory").val("").trigger("change");
			
			
			$("#Hideotherdata").hide()
			
			$("#description").val("");
			
			$("#counterSpan").hide()
			callToolTip231('description', 'hide');
			callToolTip231('softDiv', 'hide');
			callToolTip231('phone', 'hide');
			callToolTip231('typecategory', 'hide');
			$("#sname").val("").trigger("change");
			
			$('#ipaddresss').hide();
			$('#softwarename').hide();

			$("#empPic").val("");
			$("#othercompname").val("");
			$("#othersite").val("");
			$("#otherdepart").val("");
			$("#otherfullname").val("");
			$("#otheremail").val("");
			$("#cost").val("");
			$("#rperiod").val("");
			callToolTip231('sname', 'hide');
			callToolTip231('phone', 'hide');
			callToolTip231('pid', 'hide');
			callToolTip231('requestmode', 'hide');
			callToolTip231('appdiv', 'hide');
			callToolTip231('AssetDiv', 'hide');
			$('#assetCheck').prop('checked', false);
			//callToolTip231('description', 'hide');
			callToolTip231('empPic', 'hide');

			
			
		});

	 
var callToolTip231 = function(fieldName, status) {
	if (fieldName === "description") {
	var errorMessage = "<span>Please Enter Note<span>";
			}
	else if (fieldName === "softDiv") {
		var errorMessage = "<span>Please Select Software Name<span>";
				}
	else if (fieldName === "typecategory") {
		var errorMessage = "<span>Please Select Request Category<span>";
				}
	else if (fieldName === "appdiv") {
		var errorMessage = "<span>Please Select Approver Name <span>";
		
	} 
	
	else if (fieldName === "phone") {
		var errorMessage = "<span>Please Enter Contact No<span>";
				}
	else if (fieldName === "hostname") {
		var errorMessage = "<span>Please Enter Hostname<span>";
				}
	else if (fieldName === "ownername") {
		var errorMessage = "<span>Please Enter Owner Name<span>";
				}
	else if (fieldName === "ipaddress") {
		var errorMessage = "<span>Please Enter Ipaddress<span>";
				}

	else if (fieldName === "compName") {
		var errorMessage = "<span>Please Enter Computer Name<span>";
				}
	else if (fieldName === "st") {
		var errorMessage = "<span>Please Select Status<span>";
				}
	else if (fieldName === "ip") {
		var errorMessage = "<span>Please Enter IP Address<span>";
				}
	else if (fieldName === "assetname") {
		var errorMessage = "<span>Please Enter Asset Name<span>";
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

function validateForm() {

	
	var indexError = 0;
	if ($('#approup').val() == '' || $('#approup').val() == null) {
		// console.log('fill sub');
		callToolTip231('appdiv', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	
	if ($('#typecategory').val().trim() === '') {

		callToolTip231('typecategory', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}

	if ($('#description').val().trim() === '') {

		callToolTip231('description', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	if ($('#sname').val().trim() === '') {

		callToolTip231('softDiv', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	if ($('#phone').val() === '') {

		callToolTip231('phone', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}


		if (($('#typecategory').val() === 'Desktop'||$('#typecategory').val() === 'Laptop') && $('#assetname').val() === '') {

			callToolTip231('assetname', 'show');

			if (indexError == 0) {
			}
			indexError = indexError + 1;
		}
		
	
	if (($('#typecategory').val() === 'Desktop'||$('#typecategory').val() === 'Laptop') && $('#ip').val() === '') {

		callToolTip231('ip', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	if (($('#typecategory').val() === 'Desktop'||$('#typecategory').val() === 'Laptop') &&$('#st').val() === '') {

		callToolTip231('st', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}

	if (($('#typecategory').val() === 'Desktop'||$('#typecategory').val() === 'Laptop') && $('#compName').val() === '') {

		callToolTip231('compName', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	
	

	if ($('#typecategory').val() === 'Server' && $('#ipaddress').val() === '') {

		callToolTip231('ipaddress', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	if ($('#typecategory').val() === 'Server' && $('#ownername').val() === '') {

		callToolTip231('ownername', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	
	if ($('#typecategory').val() === 'Server' && $('#hostname').val() === '') {

		callToolTip231('hostname', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
//	} 
	if (indexError != 0) {

		return false;

	} else {

		return true;
	}

}

$('#description').on('focus', function() {
	callToolTip231('description', 'destroy');
});
$('#approup').on('focus', function() {
	callToolTip231('appdiv', 'hide');
});

$('#softDiv').on('click', function() {
	callToolTip231('softDiv', 'destroy');
});

$('#phone').on('focus', function() {
	callToolTip231('phone', 'destroy');
});

$('#typecategory').on('focus', function() {
	callToolTip231('typecategory', 'destroy');
});

//ipaddress compName st ip  assetname ownername hostname
$('#ipaddress').on('focus', function() {
	callToolTip231('ipaddress', 'destroy');
});

$('#compName').on('click', function() {
	callToolTip231('compName', 'destroy');
});

$('#st').on('focus', function() {
	callToolTip231('st', 'destroy');
});
$('#ip').on('focus', function() {
	callToolTip231('ip', 'destroy');
});
$('#assetname').on('focus', function() {
	callToolTip231('assetname', 'destroy');
});

$('#ownername').on('focus', function() {
	callToolTip231('ownername', 'destroy');
});
$('#hostname').on('focus', function() {
	callToolTip231('hostname', 'destroy');
});


function CategoryType(cattype)
{
	//////alert(cattype)
	$('#ipaddresss').hide();
	$('#softwarename').hide();

	if(cattype.length>0)
		{
//	callToolTip231('assetname', 'hide');
//	callToolTip231('ip', 'hide');
//	callToolTip231('st', 'hide');
//	callToolTip231('compName', 'hide');
//	callToolTip231('ipaddress', 'hide');
//	callToolTip231('ownername', 'hide');
//	callToolTip231('hostname', 'hide');
	if(cattype==='Server')
		{
		$('#ipaddresss').show();
//		//alert(callToolTip231('assetname', 'hide'))
		callToolTip231('assetname', 'destroy');
		callToolTip231('ip', 'destroy');
		callToolTip231('st', 'destroy');
		callToolTip231('compName', 'destroy');
//		//alert("tgtg")
		
		}
	else if(cattype==='Laptop'||cattype==='Desktop')
		{
			$('#softwarename').show();
			callToolTip231('ipaddress', 'destroy');
			callToolTip231('ownername', 'destroy');
			callToolTip231('hostname', 'destroy');
			  
		}
		}
	

		
}

///////////// ONLOAD ENDS ////////////
//function getApprovalGroup(pid) {
//	$('#Hideassetdata').hide();
//	 if(pid.length>0)
//		 {	 	
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/EFormActivity/ApprovalGroup";
//	
//	//////alert("hii")
//	$.ajax({
//		type : 'POST',
//		url : serviceUrl,
//		dataType : 'json',
//		async : false,
//		data : 'pid=' + pid,
//		success : function(data2) {
//			// //////alert(data2)
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
//	 
//	 
//	 
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
function getApprovalDetails(approvalname) {
	
	////alert("dcsadca"+approvalname)
	
	$('#Hideotherdata').css('display', 'block');
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/getUserSelectedDetails";
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
//				//////alert("hi  iam dd")
//				}
//			else if(result!=''){
////alert(data[0]["COMPANY"]);
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

