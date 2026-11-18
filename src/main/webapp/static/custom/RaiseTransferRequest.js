
var companyforsubject = "";
window.onload = function() {
	swal({
		title : "Warning!",
		html : "<b>This feature is under development and yet not completed.You can raise rerquest for testing purpose.</b>",
		// text: "Ticket Raised Successfully",
		type : "warning",
		width : 300,
		height : 200,
		buttons : false,
		allowOutsideClick : false,
	});

	// Use For IP Address
	$(":input").inputmask();
	
   $('#usernamesofbehalf').select2({
    //theme: 'bootstrap4',
  //	tags: true,
  	placeholder: "Please Select User",
  	maximumSelectionSize: 1,
    allowClear: true
  })
  
   $('#fromAsset').select2({
  	placeholder: "Please Select Asset",
  	maximumSelectionSize: 1,
    allowClear: true
  })
  
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
	$('#newassetCodeSU').select2({
		// theme: 'bootstrap4'
		width : '100%',
		tags : false,
		placeholder : "Select Asset",

	// allowClear: true
	})

	callToolTip231()
	$('#groupnamediv').css('display', 'block');
	// $('#requestmode').focus();

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

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/getPID";
	// //////alert("VALUE "+$('#compname').val);
	// //////alert("COMAPNY NAME "+ companyforsubject);
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',

		success : function(data2) {
			// alert(data2)
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

	$
			.ajax({
				type : 'GET',
				url : serviceUrl,
				dataType : 'json',
				success : function(data2) {
					// alert(data2+"dhdtgh")
					var html = "<select class='form-control' tabindex='7' id='sname' name='sname' >  ";
					html += "<option value=''>-- Please Select --</option>"
					for ( var i = 0; i < data2.length; i++) {
						html += '<option value="' + data2[i] + '">' + data2[i]
								+ '</option>';
					}
					document.getElementById("sname").innerHTML = html;
				}

			});

	let loginuseruser;
//	alert(loginuseruser)
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getAssetFromOfLoginUser";
	
	  $.ajax({
	      type: 'POST',	
	      url: serviceUrl,
	      dataType: 'json',
	     data: 'loginuser=' + encodeURIComponent(loginuseruser),
	     
	      success: function(data) {  	
//	    	  alert(data)
	    	  var html = html + '<option value="">--Please Select Sub-Category1--</option>';
	      	  for (var i = 0; i < data.length; i++) {
	      	      html += '<option value="' + data[i] + '">' + data[i]
	      	              + '</option>';
	      	  }

	      	  document.getElementById("fromAsset").innerHTML = html;
	    	
	  
	      }
	}); 

	var company="3i Infotech";
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getallusernameforraiseonbehalf";

$.ajax({
	
   type : 'POST',
   url :serviceUrl,
   dataType: 'json',
   data:'company=' + encodeURIComponent(company),
}).done(function(data) {
	data.sort()
//	alert(data)
	 html = "  <option value=''> -- Please Select --</option>";
	//localStorage.setItem("company",  data[0]['COMPANY']);
	for(var i=0; i<data.length; i++){
		html += '<option value="' +data[i]+ '">' + data[i]
	          + '</option>';
	}
	document.getElementById("usernamesofbehalf").innerHTML=html;

});   
};
function CategoryType(cattype)
{
	////alert(cattype)
//	$('#ipaddresss').hide();
//	$('#softwarename').hide();
	if(cattype==='Server')
		{
		$('#softwarename').hide();
		$('#ipaddresss').show();
//		var callToolTip231('assetCheck', 'hide');
//		callToolTip231('fromAssetDiv', 'hide');

		}
	else if(cattype==='Laptop'||cattype==='Desktop')
		{
//		callToolTip231('hostname', 'hide');
//		callToolTip231('ipaddress','hide')
//		callToolTip231('ownername', 'hide');
			$('#softwarename').show();
			$('#ipaddresss').hide();
		
		}
	
}

//getallinformationofbehalfuser
$('#newDate').datetimepicker({
	
    autoclose: true,
    format: 'dd-mm-yyyy hh:ii',
    todayHighlight: !0,
    fontAwesome: true,
    orientation:"bottom",
    startDate: new Date(),
    endDate: '+15d'
 
//    "bootcssVer" : 3,
//    icons: {
//    
//        previous: "fa fa-chevron-left",
//        next: "fa fa-chevron-right",
//      
//    },
    
	
    
}).on('change', function() {
// ToolTip59('ToDate', 'hide');
   $(this).focus();
   
       });
/////////////////////gettrsnfered details of user
function getallinformationoftransferEmployee(othername ){
//	alert(othername)
	 document.getElementById("getallinformationoftransferEmployee").style.display = "none";
	 if(othername.length>0){

		 const words = othername.split('~');
			 $("#getallinformationoftransferEmployee").hide();
		
			 $('#newassetCodeSU').select2({
					// theme: 'bootstrap4'
					width : '100%',
					tags : false,
					placeholder : "Select Asset",

				// allowClear: true
				});
		
	
		var otherusername=words[0];
		
//		alert(othercompany + "company");
		//alert(otherusername + "otherusername ias");
		var  company="3i Infotech";
		 var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/UserActivity/Getotherinformaion";
		
		  $.ajax({
		      type: 'POST',	
		      url: serviceUrl,
		      dataType: 'json',
		     data: 'othername=' + encodeURIComponent(otherusername)
		     + '&othercompany=' + encodeURIComponent(company),
		     
		      success: function(data) {  	
//		    	 alert(JSON.stringfy(data))
//		    	  alert(data[0]["OTHEREMAIL"])
		    	var OTHEREMAIL=data[0]["OTHEREMAIL"];
		    	var OTHERFULLNAME=data[0]["OTHERFULLNAME"];
		    	var OTHERCOMPANY=data[0]["OTHERCOMPANY"];
		    	var OTHERBRANCH=data[0]["OTHERBRANCH"];
		    	var OTHERDEPARTMENT=data[0]["OTHERDEPARTMENT"];
		    	
		    	var OTHERLOCATION=data[0]["OTHERLOCATION"];
		    	var OTHERPHONE=data[0]["OTHERPHONE"];
		    	var OTHERSUBDEPARTMENT=data[0]["OTHERSUBDEPARTMENT"];
		    	var OTHERUSERNAME=data[0]["OTHERUSERNAME"];
		    	var VIPUSEROTHER=data[0]["VIPUSEROTHER"];
		    	
		    	$("#otheremailforEmployee").val(OTHEREMAIL);
		    	$("#otherfullnameforEmployee").val(OTHERFULLNAME);
		    	$("#othersiteforEmployee").val(OTHERBRANCH);
		    	$("#othercompnameforEmployee").val(OTHERCOMPANY);
		    	$("#otherdepartforEmployee").val(OTHERDEPARTMENT);
		    	
		       	$("#otherphoneforEmployee").val(OTHERPHONE);
		    	$("#otherlocationforEmployee").val(OTHERLOCATION);
		    	$("#othersubdepartforEmployee").val(OTHERSUBDEPARTMENT);
		    	$("#otherusernameforEmployee").val(OTHERUSERNAME);
//		    	$("#vipuserotherforbehalf").val(VIPUSEROTHER);
		    	
		      }
		}); 
		    document.getElementById("getallinformationoftransferEmployee").style.display = "block";

		    
		
		//dfg
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getAssetFromOfLoginUser";
	
	  $.ajax({
	      type: 'POST',	
	      url: serviceUrl,
	      dataType: 'json',
	     data: 'loginuser=' + encodeURIComponent(otherusername),
	     
	      success: function(data) {  	
//	    	  alert(data)
	    	  var html = html + '<option value="">--Please Select Sub-Category1--</option>';
	      	  for (var i = 0; i < data.length; i++) {
	      	      html += '<option value="' + data[i] + '">' + data[i]
	      	              + '</option>';
	      	  }

	      	  document.getElementById("newassetCodeSU").innerHTML = html;
	    	
	      }
	}); 
	 }
}
//////////////////////////////////////end////////////
//////////////////////////Request action getDetail start/////////////////
//function getDetail(requestType)
//{
////	alert(requestType)
//	if(requestType==='empToemp')
//		{
//		 $('#usernamesofbehalf').select2({
//			    //theme: 'bootstrap4',
//			  //	tags: true,
//			  	placeholder: "Please Select User",
//			  	maximumSelectionSize: 1,
//			    allowClear: true,
//			    width: '100%'
//			    
//			  })
			  
		
			  $("#empDetail").show();
			
//		}
//	
//}

function getallinformationofAsset(asset) {
	document.getElementById("HideAssetdata").style.display = "none";

	if (asset.length > 0) {
		// ////alert("inside");

		// ////alert(asset);

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
				// ////alert(JSON.stringify(data))
				// ////alert(data[0]["OTHEREMAIL"])
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
//var loginuser;
$('#assetCheck')
		.change(
				function() {
					if (this.checked) {
						// ////alert("AFsd")

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

											// ////alert(data)
											var html = html
													+ '<option value="">--Please Select Asset--</option>';
											for ( var i = 0; i < data.length; i++) {
												html += '<option value="'
														+ data[i] + '">'
														+ data[i] + '</option>';
											}

											document.getElementById("assetid").innerHTML = html;
										});

					} 
				});
function GetSoftwareDetailOfLoginUser() {
//	 alert($("#sname").val())
	 
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
			data : {sname:$("#sname").val()},
			success : function(data) {
				var COST = data[0].COST;
				var PERIOD = data[0].PERIOD;
			$("#cost").val(COST);
				$("#rperiod").val(PERIOD);
				// $("#productcode").val(PCODE);
				// $("#fromDate").val(FROMDATE);
				// $("#activeD").val(ACTIVED);

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
//function CategoryType(cattype)
//{
//	$('#ipaddress').hide();
//	$('#softwarename').hide();
//	
//	if(cattype==='Server')
//		{
//		
//		$('#ipaddress').show();
//		}
//	else if(cattype==='Laptop'||cattype==='Desktop')
//		{
//		$('#softwarename').show();
//		
//		}
//	
//}
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
// var l = window.location;
// var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// // var serviceUrl = base_url + "/Master/getPriorityName";
//
// $.ajax({
//
// url :serviceUrl,
// type : 'POST',
// dataType: 'json',
// }).done(function(data) {
//
// var html =" <select class='form-control' tabindex='13' id='priority'
// name='priority' '>";
// html=html+'<option value="">--Please Select Priority--</option>';
// for (var i = 0; i < data.length; i++) {
// html += '<option value="' +data[i]+ '">' + data[i]
// + '</option>';
// }
//
// // document.getElementById("priority").innerHTML=html;
// });

// var l = window.location;
// var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// // var serviceUrl = base_url + "/Master/getSeverityName";
//
// $.ajax({
//
// url :serviceUrl,
// type : 'POST',
// dataType: 'json',
// }).done(function(data) {
//
// var html =" <select class='form-control' tabindex='14' id='severity'
// name='severity' '>";
// html=html+'<option value="">--Please Select Severity--</option>';
// for (var i = 0; i < data.length; i++) {
// html += '<option value="' +data[i]+ '">' + data[i]
// + '</option>';
// }
//
// // document.getElementById("severity").innerHTML=html;
// });

// /////////// ONLOAD ENDS ////////////
//function getApprovalGroup(pid) {
//	 $('#Hideassetdata').hide();
//	 if(pid.length>0)
//	 {
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
//	 } else {  
//	 $("#pid").val("");
//	 $("#approup").val("").trigger("change");
//	 $("#Hideotherdata").hide()
//	 }
//}
////	$('#Hideassetdata').css('display', 'block');
////	 }
////	 else
////	 {
////	 $('#Hideassetdata').css('display','none');
////	 }

//}

//// }approup
// if(pid>0)
// {
// ////alert("iniif")
// $('#Hideotherdata').show();
// }
// else
// {
// $('#Hideotherdata').hide();
//// $("#approup").val("");
// }
function getApprovalDetails(approvalname) {

	
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
			// //////alert(data[0].COMPANY);
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

	});
	

}

// if(REQUESTTYPE=="Standard")
// {
// var callToolTip232 = function (fieldName, status) {
//	
// if (fieldName === "username1") {
// var errorMessage = "<span>Please Select User <span>";
// }
//	    
//
// $("#" + fieldName).tooltip({
// trigger: 'manual',
// placement: 'top',
// title: errorMessage,
// animation: true,
// delay: 1000,
// html: true
// });
// if (status == "show") {
// $("#" + fieldName).tooltip('show');
// } else {
// $("#" + fieldName).tooltip('hide');
// }
// }
//	
// }
// function change_subcat2(subcat1)
// {
// // //////alert("category: "+$('#category').val());
// // //////alert("subcat1: "+subcat1)
// var l = window.location;
// var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// var serviceUrl = base_url + "/Master/getINCSubCategory2Name";
//
// $.ajax({
//
// url: serviceUrl,
// type: 'POST',
// data: 'subcat1name=' + subcat1
// + '&Category=' + $("#category").val(),
// dataType: 'json',
// }).done(function (data) {
// // //////alert(data)
// var html = " <select class='form-control' tabindex='7' id='subcat2'
// name='subcat2'
// onchange='JavaScript:change_PriorityAndSeverity(this.value)'>";
// html = html + '<option value="">--Please Select Sub-Category2--</option>';
// for (var i = 0; i < data.length; i++) {
// html += '<option value="' + data[i] + '">' + data[i]
// + '</option>';
// }
//
// document.getElementById("subcat2").innerHTML = html;
// });
// }
//
// function change_PriorityAndSeverity(subcat2)
// {
// // //////alert("category: "+$('#category').val());
// // //////alert("subcat1: "+$('#subcat1').val());
// // //////alert("subcat2: "+subcat2);
// var l = window.location;
// var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// var serviceUrl = base_url + "/Master/getINCPriorityAndSeverityName";
//
// $.ajax({
//
// url: serviceUrl,
// type: 'POST',
// data: 'subcat2name=' + subcat2
// + '&Category=' + $("#category").val()
// + '&subcat1name=' + $("#subcat1").val(),
// dataType: 'json',
// }).done(function (data) {
//    	
// var PRIORITY = data[0]["PRIORITY"];
// var SEVERITY = data[0]["SEVERITY"];
// // //////alert(PRIORITY)
// // //////alert(SEVERITY)
// // var html = " <select class='form-control' tabindex='7' id='subcat2'
// name='subcat2'>";
// // html = html + '<option value="">--Please Select Sub-Category2--</option>';
// // for (var i = 0; i < data.length; i++) {
// // html += '<option value="' + data[i] + '">' + data[i]
// // + '</option>';
// // }
//
// $("#priority").val(PRIORITY);
// $("#severity").val(SEVERITY);
// // document.getElementById("priority").innerHTML = html;
// });
//    
// ////////////// DATA FOR SUBJECT ///////
// var l = window.location;
// var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// var serviceUrl = base_url + "/Master/getINCSubject";
//
// $.ajax({
// type: 'POST',
// url: serviceUrl,
// dataType: 'json',
// data: 'subcat2name=' + subcat2
// + '&Category=' + $("#category").val()
// + '&subcat1name=' + $("#subcat1").val()
// + '&company=' + $("#compname").val(),
// success: function(data2) {
// // //////alert(data2)
// var html = " <option value=''> -- Please Select --</option>";
// for (var i = 0; i < data2.length; i++) {
// html += '<option value="' + data2[i] + '">' + data2[i]
// + '</option>';
// }
// document.getElementById("sub").innerHTML = html;
// }
// });
// }

function submitRaise() {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EFormActivity/insertSoftwareTransferRequest";
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
			// //////alert(data);
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

	if (fieldName === "newDate") {
		var errorMessage = "<span>Please Select Date<span>";
	}
	else if (fieldName === "assetCodeDiv") {
		var errorMessage = "<span>Please Select Asset<span>";
	}
	else if (fieldName === "behalfdiv") {
		var errorMessage = "<span>Please Select User<span>";
	}
	else if (fieldName === "subjectDiv") {
		var errorMessage = "<span>Please Enter Subject<span>";
	}

	else if (fieldName === "description") {
		var errorMessage = "<span>Please Enter Note<span>";
	}

	else if (fieldName === "phone") {
		var errorMessage = "<span>Please Select Contact No <span>";
	}

	else if (fieldName === "piddiv") {
		var errorMessage = "<span>Please Select Project ID <span>";
		
	} 
	else if (fieldName === "appdiv") {
		var errorMessage = "<span>Please Select Approver Name <span>";
		
	} 
	else if (fieldName === "fromAssetDiv") {
		var errorMessage = "<span>Please Select Asset <span>";
	} else if (fieldName === "assetCheck") {
		var errorMessage = "<span>Please Select  Asset <span>";
	} else if (fieldName === "softDiv") {
		var errorMessage = "<span>Please Select  Software <span>";
	}
	else if (fieldName === "empPic") {
		var errorMessage = "<span> file size less thank 1 kb<span>";
	}
	else if(fieldName==="typecategory")
		{
			var errorMessage="<span>Please Select Request Category</span>";
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
//	newDate  newassetCodeSU ip,st compName  ipaddress ownername hostname assetname usernamesofbehalf
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
	var valueoftype = $("#requesttype").val();
	
	var indexError = 0;
	if ($("#usernamesofbehalf").val() === '' ||$("#usernamesofbehalf").val() == null) {

		callToolTip231('behalfdiv', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	if ($("#newassetCodeSU").val() === ''||$("#newassetCodeSU").val() == null) {

		callToolTip231('assetCodeDiv', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	if ($("#newDate").val().trim() === '') {

		callToolTip231('newDate', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}

	if ($("#phone").val().trim() === '') {

		callToolTip231('phone', 'show');

		if (indexError == 0) {
		}
		indexError = indexError + 1;
	}
	
	if($("#typecategory").val() ==='')
		{
		callToolTip231('typecategory','show')
			if(indexError == 0)
				{}
				indexError = indexError + 1;
		}
	

	if ($('#pid').val() === '') {

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

//	if (document.querySelector('#assetCheck:checked') == null) {
//		// ////alert( document.querySelector('#levelone:checked'));
//		callToolTip231('assetCheck', 'show');
//		if (indexError == 0) {
//
//		}
//		indexError = indexError + 1;
//	}

		if ($('#fromAsset').val() == '' || $('#fromAsset').val() == null) {
			// console.log('fill sub');
			callToolTip231('fromAssetDiv', 'show');

			if (indexError == 0) {

			}
			indexError = indexError + 1;
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
	if(typecat==='Server')
		{
	if($("#ipaddress").val().trim()==='')
	{
	callToolTip231('ipaddress','show')
		if(indexError == 0)
			{}
			indexError = indexError + 1;
	}
	
	if($("#ownername").val().trim()==='')
	{
	callToolTip231('ownername','show')
		if(indexError == 0)
			{}
			indexError = indexError + 1;
	}
		}
	
	

	  if(indexError12 != 0)
	   {
	      const size= ($('#empPic')[0].files[0].size);
	     //(size);
//	      alert(size)
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

		// //////alert("false");
		return false;

	} else {

		return true;
	}

}
//
// focus out

$('#username1').on('focusout', function() {

	var usertype = $('#username1').val();
	if (usertype.trim() === "") {
		callToolTip231('username1', 'show');
	} else {
		callToolTip231('username1', 'hide');
	}
});
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
$('#description').on('focus', function() {

	var usertype = $('#description').val();
	if (usertype.trim() == "") {
		callToolTip231('description', 'show');
	} else {
		callToolTip231('description', 'hide');
	}
});
// focus out

$('#newDate').on('focus', function() {
	callToolTip231('newDate', 'destroy');
});
$('#assetCodeDiv').on('click', function() {
	callToolTip231('assetCodeDiv', 'destroy');
});
$('#behalfdiv').on('click', function() {
	callToolTip231('behalfdiv', 'destroy');
});

$('#empPic').on('focus', function() {
	callToolTip231('empPic', 'destroy');
});

$('#assetCheck').on('focus', function() {
	callToolTip231('assetCheck', 'destroy');
});
$('#pid').on('focus', function() {
	callToolTip231('piddiv', 'destroy');
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

$('#fromAssetDiv').on('click', function() {

	callToolTip231('fromAssetDiv', 'destroy');
});

$('#appdiv').on('click', function() {
	// ////alert("dsdsdsd")
	callToolTip231('appdiv', 'destroy');
});
$("#resetbtn").click(function() {
	
	$("#typecategory").val("").trigger("change");
	// document.getElementById("Hideotherdata").style.display = "none";
	$("#sname").val("");
	$("#phone").val("");
	$("#pid").val("");
	$("#requestmode").val("");
	$("#assetid").val("").trigger("change");
	$("#approup").val("").trigger("change");
	$("#description").val("");
	//$("#actionType").val("").trigger("change");
	$("#getallinformationoftransferEmployee").hide()
	//alert("hh")
	$("#assetCodeDiv").val("").trigger("change");
	$("#behalfdiv").val("").trigger("change");
	$("#fromAssetDiv").val("").trigger("change");
	$("#softDiv").val("").trigger("change");
	
	
	
	
$("#newDate").val("");
	$("#cost").val("");
	$("#rperiod").val("");
	
	
	$("#Hideotherdata").hide()
	$("#counterSpan").hide()
	$("#toggleAssetCheck").hide()
	$("#assetCheck").val("");
	

	
	
//document.getElementById("assetCheck").checked = false;
	callToolTip231('newDate', 'hide');
	callToolTip231('typecategory', 'hide');
	callToolTip231('fromAssetDiv', 'hide');
	callToolTip231('behalfdiv', 'hide');
	callToolTip231('assetCodeDiv', 'hide');
	callToolTip231('phone', 'hide');
	callToolTip231('appdiv', 'hide');
	
	callToolTip231('description', 'hide');
	callToolTip231('softDiv', 'hide');
	callToolTip231('assetCheck', 'hide');
	callToolTip231('pid', 'hide');
	callToolTip231('appdiv', 'hide');
	callToolTip231('phone', 'hide');
	

	
	$("#empPic").val("");
	$("#othercompname").val("");
	$("#othersite").val("");
	$("#otherdepart").val("");
	$("#otherfullname").val("");
	$("#otheremail").val("");
	$("#cost").val("");
	$("#rperiod").val("");
	
	

	$('#ipaddresss').hide();
	

	
		$('#softwarename').hide();
		
	
	

	//callToolTip231('sname', 'hide');
	
	
//	callToolTip231('requestmode', 'hide');
//	
//	callToolTip231('fromAssetDiv', 'hide');
////	$('#assetCheck').prop('checked', false);
//	
//	callToolTip231('empPic', 'hide');
	
	
});

function submitbutton101() {
	 //////alert("in submit button");

	if (!validateForm()) {
		// //////alert("failed");
		event.preventDefault();
	} else if (validateForm()) {
		
		if ($('#site').val() === 'NA' || $('#department').val() === 'NA'
				|| $('#sub_department').val() === 'NA'
				|| $('#location').val() === 'NA'){
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
//alert(requestType)
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
//	alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("description").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}

function CategoryType(cattype)
{
	////alert(cattype)
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
//		alert(callToolTip231('assetname', 'hide'))
		callToolTip231('assetname', 'destroy');
		callToolTip231('ip', 'destroy');
		callToolTip231('st', 'destroy');
		callToolTip231('compName', 'destroy');
//		alert("tgtg")
		
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


