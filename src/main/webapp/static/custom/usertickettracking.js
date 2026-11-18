
var fromDateTrack ="";   
    var toDateTrack ="";

window.onload = function() {
	$('#ticketid').focus();
	$("#searchResult").hide();
	$('#ticketid').select2({
		placeholder : '--Please Select ID--',
		allowClear : true,
	});

	$('#vlxprop').hide();
	$('#potable').hide();

	// var lastmonth = 'lastmonthFinal';
	// var l = window.location;
	// var base_url = l.protocol + "//" + l.host + "/" +
	// l.pathname.split('/')[1];
	// var serviceUrl = base_url + "/UserActivity/getUserTicketID";
	//
	// // var getID='getUserTicketID';
	// $
	// .ajax({
	// url : serviceUrl,
	// type : 'POST',
	// dataType : 'json',
	// data : 'lastmonth=' + lastmonth,
	// })
	// .done(
	// function(data) {
	// // alert(data)
	// // var d = data.split(",");
	// // var length = d.length-1;
	// var html = "<select class='form-control' tabindex='1' id='ticketid'
	// name='ticketid'>";
	// // html = html + '<option value="-1">--Please Select
	// // ID--</option>';
	// html = html + '<option value=""></option>';
	// for (var i = 0; i < data.length; i++) {
	// html += '<option value="' + data[i] + '">'
	// + data[i] + '</option>';
	// }
	// document.getElementById("ticketid").innerHTML = html;
	//
	// });


}

var WremainedDay = null;
function WarrentyremainedDays() {
    var endDateParts = $("#powarrantyend2").val().split("-");
    var endDate = new Date(endDateParts[2], endDateParts[1] - 1, endDateParts[0]);

    var currentDate = new Date(); 
    var differenceInTime = endDate.getTime() - currentDate.getTime();
    var differenceInDays = differenceInTime / (1000 * 3600 * 24);
    $("#powarrantyremaining2").val(Math.round(differenceInDays)+1);
    WremainedDay =  $("#powarrantyremaining2").val();
}

var AMCremainedDay = null;
function AMCremainedDays() {
    var endDateParts = $("#poamcend2").val().split("-");
    var endDate = new Date(endDateParts[2], endDateParts[1] - 1, endDateParts[0]);

    var currentDate = new Date();
    var differenceInTime = endDate.getTime() - currentDate.getTime();
    var differenceInDays = differenceInTime / (1000 * 3600 * 24);
    $("#poamcremaining2").val(Math.round(differenceInDays)+1);
    AMCremainedDay =  $("#poamcremaining2").val();
}

var TenureRemainedDay = null;
function TenureRemainedDays() {
    var endDateParts = $("#potennureend2").val().split("-");
    var endDate = new Date(endDateParts[2], endDateParts[1] - 1, endDateParts[0]);

    var currentDate = new Date();
    var differenceInTime = endDate.getTime() - currentDate.getTime();
    var differenceInDays = differenceInTime / (1000 * 3600 * 24);
    $("#potennureremaining2").val(Math.round(differenceInDays)+1);
    TenureRemainedDay =  $("#potennureremaining2").val();
}



function TrackType() {
var selectedType = $("#selectType2").val();

if(selectedType ==="With Date") {
	$("#DatesDiv").show();
	$("#CommercialType").show();
} else {
	$("#DatesDiv").hide();
	$("#CommercialType").hide();
}
}


// function getlastData(lastmonth) {
// // alert('last data' + lastmonth)
// // var lastmonth='30';
// var l = window.location;
// var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// var serviceUrl = base_url + "/UserActivity/getUserTicketID";
//
// // var getID='getUserTicketID';
// $
// .ajax({
// url : serviceUrl,
// type : 'POST',
// dataType : 'json',
// data : 'lastmonth=' + lastmonth,
// })
// .done(
// function(data) {
// // alert(data)
// var html = "<select class='form-control' tabindex='1' id='ticketid1'
// name='ticketid1'>";
// // html = html + '<option value="-1">--Please Select
// // ID--</option>';
// html = html + '<option value=""></option>';
// for (var i = 0; i < data.length; i++) {
// html += '<option value="' + data[i] + '">'
// + data[i] + '</option>';
// }
// document.getElementById("ticketid").innerHTML = html;
//
// });
// }

// / new added for month wise and select type (po , velox proposal)

function loadTicketOptions(timePeriod, selectType) {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getUserTicketID";

	// AJAX request with timePeriod and selectType parameters
	$
			.ajax(
					{
						url : serviceUrl,
						type : 'POST',
						dataType : 'json',
						// data: {
						// timePeriod: timePeriod,
						// selectType: selectType
						// },
						data : 'timePeriod=' + timePeriod + '&selectType='
								+ selectType,
					})
			.done(
					function(data) {
						var html = "<select class='form-control' tabindex='1' id='ticketid' name='ticketid'>";
						html = html + '<option value=""></option>';
						for (var i = 0; i < data.length; i++) {
							var vlxId = data[i];
							html += '<option value="' + vlxId + '">' + vlxId
									+ '</option>';
						}
						$('#ticketid').html(html);
					});
}

function getlastData() {
	var timePeriod = $("#selectmonthOfGroupTicket").val();
	var selectType = $("#selecttype").val();
	loadTicketOptions(timePeriod, selectType);
}

function selectionType() {
	
	var timePeriod = $("#selectmonthOfGroupTicket").val();
	var selectType = $("#selecttype").val();
	loadTicketOptions(timePeriod, selectType);
	
}



// / end here

$("#submit-btn")
		.click(
				function() {

					var momentAdb = moment($('#fromDate').val(), "DD-MM-YYYY");
					var momentBcd = moment($('#toDate').val(), "DD-MM-YYYY");

					fromDateTrack = $('#fromDate').val();   
					 toDateTrack = $('#toDate').val();
					
					if (momentAdb > momentBcd) {

						swal({
							title : "Warning",
							text : "Warranty End Date should be Greater than Start Date!",
							type : "warning",
							width : 300,
							allowOutsideClick : false,

						});

						return false;
					} else {
						// return true;

						if (!validatePageTracking()) {

							event.preventDefault();
						} else if (validatePageTracking()) {
							// $("#searchID").hide();
							// $("#searchResult").show();
							// var ticketid = $("#ticketid").val();
							//
							// viewDataUser1(ticketid);
							//

							var requestData = {
								fromDate : $('#fromDate').val(),
								toDate : $('#toDate').val(),
								selecttype : $('#selecttype').val(),
								selectType2 : $('#selectType2').val()
							};
							// alert("requestData"+JSON.stringify(requestData))
							var l = window.location;
							var base_url = l.protocol + "//" + l.host + "/"
									+ l.pathname.split('/')[1];
							var serviceUrl = base_url
									+ "/UserActivity/trackDetails";
							$("#spin11").show();

							$
									.ajax({
										type : 'POST',
										url : serviceUrl,
										dataType : 'json',
										data : requestData,

										success : function(data) {
											$("#spin11").hide();
											$("#trackinghideid").hide();
											console.log(data)

//											alert(data.length);
											
										if(data.length < 1){
											
											swal({
												title : "Warning",
												text : "Data Not Available for this Details!",
												type : "warning",
												width : 300,
												height : 200,
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
															+ "/User/UserTrackingTicket";
												}

											});
											
										}	else if (data[0][1].includes("VP-")) {
												// alert("if hih")
												$('#vlxprop').show();
												$('#potable').hide();
												$('#amcOrderDiv').hide();
												
												  $('#cpStartDate').text(fromDateTrack);
												  $('#cpEndDate').text(toDateTrack);
												 

												var table = $(
														'#CMApprByMeTableproposal')
														.DataTable(
																{
																	lengthChange : false,
																	pageLength : 5,
																	data : data,
																	scrollX : '300px',
																	dom : 'Bfrtip', // Add
																					// this
																					// line
																					// to
																					// enable
																					// export
																					// buttons
																	buttons : [
																			{
																				extend : 'pdfHtml5',
																				exportOptions : {
																					columns : ':visible' // Only
																											// export
																											// visible
																											// columns
																				},
																				customize : function(
																						doc) {
																					doc.pageOrientation = 'landscape'; // or
																														// 'landscape'
																					doc.pageSize = 'A4'; // Customization
																											// code
																											// here
																				}
																			},
																			'excel',
																			'print' ]
																});

											} else if (
										//			data[0][2]
										//	.equals("AMC Order") && data[0][1].includes("PO-")
											($("#selecttype").val()==="AMC Order")
											) {
									//			 alert("if hih AMC"+data[0][2])
												// alert("else")
												$('#amcOrderDiv').show();
										//		$('#potable').show();
												$('#potable').hide();
												$('#vlxprop').hide();
												
												 $('#poStartDate').text(fromDateTrack);
												 $('#poEndDate').text(toDateTrack);

												var table = $(
														'#AmcTable')
														.DataTable(
																{
																	lengthChange : false,
																	pageLength : 5,
																	data : data,
																	scrollX : '300px',
																	dom : 'Bfrtip', // Add
																					// this
																					// line
																					// to
																					// enable
																					// export
																					// buttons
																	buttons : [
																			{
																				extend : 'pdfHtml5',
																				exportOptions : {
																					columns : ':visible' // Only
																											// export
																											// visible
																											// columns
																				},
																				customize : function(
																						doc) {
																					doc.pageOrientation = 'landscape'; // or
																														// 'landscape'
																					doc.pageSize = 'A4'; // Customization
																											// code
																											// here
																				}
																			},
																			'excel',
																			'print' ]
																});
											} 
													else 
														if (data[0][1].includes("PO-")) 
														{
												// alert("else")
												$('#potable').show();
												$('#vlxprop').hide();
												$('#amcOrderDiv').hide();
												
												 $('#poStartDate').text(fromDateTrack);
												 $('#poEndDate').text(toDateTrack);

												var table = $(
														'#CMApprByMeTable')
														.DataTable(
																{
																	lengthChange : false,
																	pageLength : 5,
																	data : data,
																	scrollX : '300px',
																	dom : 'Bfrtip', // Add
																					// this
																					// line
																					// to
																					// enable
																					// export
																					// buttons
																	buttons : [
																			{
																				extend : 'pdfHtml5',
																				exportOptions : {
																					columns : ':visible' // Only
																											// export
																											// visible
																											// columns
																				},
																				customize : function(
																						doc) {
																					doc.pageOrientation = 'landscape'; // or
																														// 'landscape'
																					doc.pageSize = 'A4'; // Customization
																											// code
																											// here
																				}
																			},
																			'excel',
																			'print' ]
																});
											}

										}
									});

						}
					}
				});

var ticketid = null;
function ApprovedCRF(crno, tid) {
	ticketid = crno;
	
	viewDataUser1(ticketid);
	
	//
	// var l = window.location;
	// var base_url = l.protocol + "//" + l.host + "/" +
	// l.pathname.split('/')[1];
	// window.location.href = base_url +
	// "/User/ViewpoRaisedByme?crno="+crno+"&tid="+tid;
}
// $("#submit-btn").click(function() {
//
// if (!validatePageTracking()) {
// event.preventDefault();
// } else if (validatePageTracking()) {
// $("#searchID").hide();
// $("#searchResult").show();
// var ticketid = $("#ticketid").val();
//
// viewDataUser1(ticketid);
//
// }
//
// });

$("#resetbtn").click(function() {

	callToolTip231('fromDate', 'destroy');
	callToolTip231('toDate', 'destroy');
	callToolTip231('selecttype', 'destroy');
	callToolTip231('selectType2', 'destroy');
	$("#fromDate").val('').trigger('change');
	$("#toDate").val('').trigger('change');
	$("#selecttype").val('').trigger('change');
	$("#selectType2").val('').trigger('change');

	callToolTip231('selectmonthOfGroupTicket', 'destroy');
	$("#selectmonthOfGroupTicket").val('lastmonthFinal').trigger('change');
});

function validatePageTracking() {
	// alert("hIHI")
	var indexError = 0;

	if ($('#fromDate').val() === '' && $('#selectType2').val() == 'With Date') {

		callToolTip231('fromDate', 'show');
		indexError = indexError + 1;
	}
	if ($('#toDate').val() === '' && $('#selectType2').val() == 'With Date') {

		callToolTip231('toDate', 'show');
		indexError = indexError + 1;
	}
	
	if ($('#selecttype').val() === '') {

		callToolTip231('selecttype', 'show');
		indexError = indexError + 1;
	} 

	if ($('#selectType2').val() === '') {

		callToolTip231('selectType2', 'show');
		indexError = indexError + 1;
	}

	if (indexError > 0) {
		return false;
	} else {
		// $('#spinner2').show();
		return true;
	}
}

var modalOpened = false;

function viewDataUser1(ticketid) {
	// alert("hhii"+ticketid)

	if (modalOpened) {
		clearModalData();
	}

	$("#T_ID").text(ticketid);

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/getUserTicketTracking";

	$
			.ajax({
				url : serviceUrl,
				type : 'post',
				dataType : 'json',
				data : 'ticketid=' + ticketid,

				success : function(data) {

					// alert("alert"+JSON.stringify( data))

					//					
					// console.log("nnnnnnnnn" + JSON.stringify(data))

					if (data[0]["TAG"] === 'VP') {

						// $("#searchResult").show();
						$("#searchResult").modal("show");
						$("#modeldesignation").modal("show");

						// $("#searchResult_po").hide();
						$("#searchResult_po").show();

						var STATUS_LOG = data[0].STATUSLOG;
						var RAISE_DATE = data[0].STATUSLOG[0].RAISEDATE;
						var SUBBY = data[0].STATUSLOG[0].SUBBY;
						var APRBY = data[0].STATUSLOG[0].APRBY;
						var APRDATE = data[0].STATUSLOG[0].APRDATE;

						$('#vptype').val(data[0]["VPPROPOSALTYPE"]);

						if (data[0]["VPPROPOSALTYPE"] === 'Perpetual') {

							$("#vpperepetualdiv").show();
							$("#vpsubscriptiondiv").hide();
							$('#vpperepetual').val(data[0]["VPPERPETUAL"]);

						} else {

							$("#vpsubscriptiondiv").show();
							$("#vpperepetualdiv").hide();
							$('#vpsubscription').val(data[0]["VPSUBSCRIPTION"]);
						}

						$('#vpcustomername').val(data[0]["VPCUSTOMERNAME"]);
						$('#vpresourceamount').val(data[0]["VPRESAMT"]);
						$('#vpatc').val(data[0]["VPATC"]);
						$('#vpdescription').val(data[0]["VPDESCR"]);

						// var REJDATE = data[0]["VPREJECTEDDATE"];
						// var RESNDDATE = data[0]["VPRESENDDATE"];
						// var AUTHODATE = data[0]["VPAUTHORIZEDDATE"];
						//							
						// var REJBY = data[0]["VPREJECTEDDBY"];
						// var RESNDBY = data[0]["VPRESENDBY"];
						// var AUTHOBY = data[0]["VPAUTHORIZEDBY"];

						var CURRENTSTATUS = "";
						var CURRENTIME = "";
						var att;
						var statusColor;
						var html = "";

						for (var i = 0; i < STATUS_LOG.length; i++) {// Get
							// the
							// current
							// status
							// and
							// timestamp

							var currentStatus = STATUS_LOG[i]["CURRENTSTATUS"];
							var RAISE_DATE = STATUS_LOG[i]["RAISEDATE"];
							var APRDATE = STATUS_LOG[i]["APRDATE"];

							var SUBBY = STATUS_LOG[i]["SUBBY"];
							var APRBY = STATUS_LOG[i]["APRBY"];

							var REJDATE = STATUS_LOG[i]["REJDATE"];
							var RESNDDATE = STATUS_LOG[i]["RESENDDATE"];
							var AUTHODATE = STATUS_LOG[i]["AUTHODATE"];

							var REJBY = STATUS_LOG[i]["REJBY"];
							var RESNDBY = STATUS_LOG[i]["RESENDBY"];
							var AUTHOBY = STATUS_LOG[i]["AUTHOBY"];

							var approvedtime = APRDATE ? APRDATE : "NA";
							var SUBBYs = SUBBY ? SUBBY : "NA";
							var APRBYs = APRBY ? APRBY : "NA";
							
							
							
							var REJBYMD = STATUS_LOG[i]["REJBYMD"];
							var REJDATEMD = STATUS_LOG[i]["REJDATEMD"];
							
							var RESNDBYSITOMD = STATUS_LOG[i]["RESENDBYSITOMD"];
							var RESNDDATESITOMD = STATUS_LOG[i]["RESENDDATESITOMD"];

							// var REJDATEvp = REJDATE ? REJDATE : "NA";
							// var RESNDDATEvp = RESNDDATE ? RESNDDATE : "NA";
							// var AUTHODATEvp = AUTHODATE ? AUTHODATE : "NA";
							// var REJBYvp = REJBY ? REJBY : "NA";
							// var RESNDBYvp = RESNDBY ? RESNDBY : "NA";
							// var AUTHOBvpY = AUTHOBY ? AUTHOBY : "NA";

							var currenttime = RAISE_DATE ? RAISE_DATE : "NA"; // Use
							// "NA"
							// when
							// RAISE_DATE
							// is
							// null
							// or
							// empty

							// Create a <div> element with the appropriate color
							var callOutColor = "";
							if (currentStatus === "New") {
								callOutColor = "callout-info";
							} else if (currentStatus === "Sent For SALES Approval"
									|| currentStatus === "Sent For Purchase Order Approval") {
								callOutColor = "callout-warning";
							} else if (currentStatus === "Raised VP Rejected By SM"  || currentStatus === "Proposal Rejected By MD" )  {
								callOutColor = "callout-danger";
							} else if (currentStatus === "Re-Send For SALES Approval" || currentStatus === "Re-Send For MD Approval" ) {
								callOutColor = "callout-info";
							} else if (currentStatus === "Velox Proposal Approved") {
								callOutColor = "callout-success";
							} else if (currentStatus === "Approved By MD") {
								callOutColor = "callout-success";
							} else if (currentStatus === "Rejected") {
								callOutColor = "callout-danger";
							} else if (currentStatus === "Update Rejected") {
								callOutColor = "callout-danger";
							} else if (currentStatus === "Work in Progress") {
								callOutColor = "callout-warning";
							}

							// Create a <div> element with the status and
							// formatted timestamp
							var div = document.createElement("div");
							div.className = "callout " + callOutColor;
							div.style.fontFamily = "Calibri";
							div.style.fontSize = "14px";
							div.style.fontWeight = "bold";

							var table = document.createElement("table");

							if (currentStatus === "Sent For SALES Approval") {
								table.innerHTML = "<tr><td>Submitted By:</td><td>"
										+ SUBBYs

										+ "</td></tr><tr><td>Status:</td><td>"
										+ currentStatus
										+ "</td></tr><tr><td>Submitted Date:</td><td>"
										+ currenttime + "</td></tr>";
							} else if (currentStatus === "Raised VP Rejected By SM") {
								table.innerHTML = "<tr><td>Submitted By:</td><td>"
										+ SUBBYs
										+ "</td></tr><tr><td>Rejected By:</td><td>"
										+ REJBY
										+ "</td></tr><tr><td>Status:</td><td>"
										+ currentStatus
										+ "</td></tr><tr><td>Submitted Date:</td><td>"
										+ currenttime
										+ "</td></tr><tr><td>Rejected Date:</td><td>"
										+ REJDATE + "</td></tr>";
							} else if (currentStatus === "Re-Send For SALES Approval") {
								table.innerHTML = "<tr><td>Submitted By:</td><td>"
										+ SUBBYs
										+ "</td></tr><tr><td>Re-Send By:</td><td>"
										+ RESNDBY
										+ "</td></tr><tr><td>Status:</td><td>"
										+ currentStatus
										+ "</td></tr><tr><td>Submitted Date:</td><td>"
										+ currenttime
										+ "</td></tr><tr><td>Re-Send Date:</td><td>"
										+ RESNDDATE + "</td></tr>";
							} else if (currentStatus === "Velox Proposal Approved") {
								table.innerHTML = "<tr><td>Submitted By:</td><td>"
										+ SUBBYs
										+ "</td></tr><tr><td>Approved By:</td><td>"
										+ APRBYs
										+ "</td></tr><tr><td>Status:</td><td>"
										+ currentStatus
										+ "</td></tr><tr><td>Submitted Date:</td><td>"
										+ currenttime
										+ "</td></tr><tr><td>Approved Date:</td><td>"
										+ approvedtime + "</td></tr>";
							} else if (currentStatus === "Proposal Rejected By MD") {
								table.innerHTML = "<tr><td>Submitted By:</td><td>"
									+ SUBBYs
									+ "</td></tr><tr><td>Rejected By:</td><td>"
									+ REJBYMD
									+ "</td></tr><tr><td>Status:</td><td>"
									+ currentStatus
									+ "</td></tr><tr><td>Submitted Date:</td><td>"
									+ currenttime
									+ "</td></tr><tr><td>Rejected Date:</td><td>"
									+ REJDATEMD + "</td></tr>";
						}else if (currentStatus === "Re-Send For MD Approval") {
							table.innerHTML = "<tr><td>Submitted By:</td><td>"
								+ SUBBYs
								+ "</td></tr><tr><td>Re-Send By:</td><td>"
								+ RESNDBYSITOMD
								+ "</td></tr><tr><td>Status:</td><td>"
								+ currentStatus
								+ "</td></tr><tr><td>Submitted Date:</td><td>"
								+ currenttime
								+ "</td></tr><tr><td>Re-Send Date:</td><td>"
								+ RESNDDATESITOMD + "</td></tr>";
					}else if (currentStatus === "Approved By MD") {
								table.innerHTML = "<tr><td>Submitted By:</td><td>"
										+ SUBBYs
										+ "</td></tr><tr><td>Authorized By:</td><td>"
										+ AUTHOBY
										+ "</td></tr><tr><td>Status:</td><td>"
										+ currentStatus
										+ "</td></tr><tr><td>Submitted Date:</td><td>"
										+ currenttime
										+ "</td></tr><tr><td>Authorized Date:</td><td>"
										+ AUTHODATE + "</td></tr>";
							}

							// Append the <table> element to the <div> element
							div.appendChild(table);

							// Append the <div> element to the "MSG1234" element
							document.getElementById("MSG1234").appendChild(div);
						}

						html = +'</span><br>';
					} else {

						$("#Modelcategory").modal("show");
						$("#T_ID1").text(ticketid);
						$("#searchResult_po1").show();
						// $("#searchResult").show();

						var STATUS_LOG = data[0].STATUSLOG;
						var RAISE_DATE = data[0].STATUSLOG[0].RAISEDATE;
						var SUBBY = data[0].STATUSLOG[0].SUBBY;
						var APRBY = data[0].STATUSLOG[0].APRBY;
						var APRDATE = data[0].STATUSLOG[0].APRDATE;

						var commercialProposalType = data[0]["COMMPROPTYPE"];

						$('#potype').val(data[0]["POTYPE"]);
						$('#poNo').val(data[0]["PONO"]);
						$('#podate').val(data[0]["PODATE"]);
						$('#pocustomername').val(data[0]["POCUSTOMERNAME"]);
						$('#productsuite').val(
								decodeURIComponent(data[0]["POSUITNAME"]));
						$('#posecuritytools').val(
								decodeURIComponent(data[0]["POTOOLNAME"]));

						if ((commercialProposalType === 'Fixed')
								|| (commercialProposalType === 'Perpetual')) {

							$("#poWarrantyHeaderDiv").show();
							$("#poWarrantyDetailsDiv").show();
							$("#poWarrantyDetailsDiv2").show();
							$("#poAMCHeaderDiv").show();
							$("#poAMCDetailsDiv").show();
							$("#poAMCDetailsDiv2").show();

							$("#poTennureHeaderDiv").hide();
							$("#poTennureDetailsDiv").hide();
							$("#poTennureDetailsDiv2").hide();

							$('#powarrantystart').val(data[0]["POWARRANTYSTART"]);
							$('#powarrantystart2').val(data[0]["POWARRANTYSTART"]);
							$('#powarrantyend').val(data[0]["POWARRANTYEND"]);
							$('#powarrantyend2').val(data[0]["POWARRANTYEND"]);
							$('#powarrantyremaining').val(data[0]["POWARRANTYREM"]);
							$('#powarrantyremaining2').val(data[0]["POWARRANTYREM"]);
							$('#poamcstart').val(data[0]["POAMCSTART"]);
							$('#poamcstart2').val(data[0]["POAMCSTART"]);
							$('#poamcend').val(data[0]["POAMCEND"]);
							$('#poamcend2').val(data[0]["POAMCEND"]);
							$('#poamcremaining').val(data[0]["POAMCFREM"]);
							$('#poamcremaining2').val(data[0]["POAMCFREM"]);

						} else if ((commercialProposalType === 'AMC')
								|| (commercialProposalType === 'Resource')
								|| (commercialProposalType === 'Subscription')) {

							$("#poTennureHeaderDiv").show();
							$("#poTennureDetailsDiv").show();
							$("#poTennureDetailsDiv2").show();

							$("#poWarrantyHeaderDiv").hide();
							$("#poWarrantyDetailsDiv").hide();
							$("#poWarrantyDetailsDiv2").hide();
							$("#poAMCHeaderDiv").hide();
							$("#poAMCDetailsDiv").hide();
							$("#poAMCDetailsDiv2").hide();

							$('#potennurestart').val(data[0]["POTENNURESTART"]);
							$('#potennureend').val(data[0]["POTENNUREEND"]);
							
							$('#potennurestart2').val(data[0]["POTENNURESTART"]);
							$('#potennureend2').val(data[0]["POTENNUREEND"]);
							$('#potennureremaining').val(data[0]["POTENNUREREM"]);
							$('#potennureremaining2').val(data[0]["POTENNUREREM"]);

						}

						// var REJDATE = data[0]["VPREJECTEDDATE"];
						// var RESNDDATE = data[0]["VPRESENDDATE"];
						// var AUTHODATE = data[0]["VPAUTHORIZEDDATE"];
						//							
						// var REJBY = data[0]["VPREJECTEDDBY"];
						// var RESNDBY = data[0]["VPRESENDBY"];
						// var AUTHOBY = data[0]["VPAUTHORIZEDBY"];

						var CURRENTSTATUS = "";
						var CURRENTIME = "";
						var att;
						var statusColor;
						var html = "";

						for (var i = 0; i < STATUS_LOG.length; i++) {// Get
							// the
							// current
							// status
							// and
							// timestamp

							var currentStatus = STATUS_LOG[i]["CURRENTSTATUS"];
							var RAISE_DATE = STATUS_LOG[i]["RAISEDATE"];
							var APRDATE = STATUS_LOG[i]["APRDATE"];

							var SUBBY = STATUS_LOG[i]["SUBBY"];
							var APRBY = STATUS_LOG[i]["APRBY"];

							var FORM3DATE = STATUS_LOG[i]["FORM3DATE"];
							var FORM3BY = STATUS_LOG[i]["FORM3BY"];

							var FORMABDATE = STATUS_LOG[i]["FORMABDATE"];
							var FORMABBY = STATUS_LOG[i]["FORMABBY"];
							
							var REJBY = STATUS_LOG[i]["REJBY"];
							var REJDATE = STATUS_LOG[i]["REJDATE"];
							
							var RESNDBY = STATUS_LOG[i]["RESENDBY"];
							var RESNDDATE = STATUS_LOG[i]["RESENDDATE"];

							var approvedtime = APRDATE ? APRDATE : "NA";
							var SUBBYs = SUBBY ? SUBBY : "NA";
							var APRBYs = APRBY ? APRBY : "NA";

							// var REJDATEvp = REJDATE ? REJDATE : "NA";
							// var RESNDDATEvp = RESNDDATE ? RESNDDATE : "NA";

							var currenttime = RAISE_DATE ? RAISE_DATE : "NA"; // Use
							// "NA"
							// when
							// RAISE_DATE
							// is
							// null
							// or
							// empty

							// Create a <div> element with the appropriate color
							var callOutColor = "";
							if (currentStatus === "New") {
								callOutColor = "callout-info";
							} else if (currentStatus === "Sent For Purchase Order Approval") {
								callOutColor = "callout-warning";
							} else if (currentStatus === "Purchase Order Rejected By SM"  )  {
								callOutColor = "callout-danger";
							} else if (currentStatus === "PO Re-Send By SALES Approval"  ) {
								callOutColor = "callout-warning";
							} else if (currentStatus === "FORMA/B Submitted") {
								callOutColor = "callout-info";
							} else if (currentStatus === "FORM3 Submitted") {
								callOutColor = "callout-info";
							} else if (currentStatus === "Purchase Order Approved") {
								callOutColor = "callout-success";
							}

							// Create a <div> element with the status and
							// formatted timestamp
							var div = document.createElement("div");
							div.className = "callout " + callOutColor;
							div.style.fontFamily = "Calibri";
							div.style.fontSize = "14px";
							div.style.fontWeight = "bold";

							var table = document.createElement("table");

							if (currentStatus === "Sent For Purchase Order Approval") {
								table.innerHTML = "<tr><td>Submitted By :</td><td>"
										+ SUBBYs

										+ "</td></tr><tr><td>Status :</td><td>"
										+ currentStatus
										+ "</td></tr><tr><td>Submitted Date :</td><td>"
										+ currenttime + "</td></tr>";
							} else if (currentStatus === "Purchase Order Rejected By SM") {
								table.innerHTML = "<tr><td>Submitted By:</td><td>"
									+ SUBBYs
									+ "</td></tr><tr><td>Rejected By:</td><td>"
									+ REJBY
									+ "</td></tr><tr><td>Status:</td><td>"
									+ currentStatus
									+ "</td></tr><tr><td>Submitted Date:</td><td>"
									+ currenttime
									+ "</td></tr><tr><td>Rejected Date:</td><td>"
									+ REJDATE + "</td></tr>";
						} else if (currentStatus === "PO Re-Send By SALES Approval") {
							table.innerHTML = "<tr><td>Submitted By:</td><td>"
									+ SUBBYs
									+ "</td></tr><tr><td>Re-Send By:</td><td>"
									+ RESNDBY
									+ "</td></tr><tr><td>Status:</td><td>"
									+ currentStatus
									+ "</td></tr><tr><td>Submitted Date:</td><td>"
									+ currenttime
									+ "</td></tr><tr><td>Re-Send Date:</td><td>"
									+ RESNDDATE + "</td></tr>";
						} else if (currentStatus === "FORMA/B Submitted") {
								table.innerHTML = "<tr><td>Submitted By :</td><td>"
										+ SUBBYs
										+ "</td></tr><tr><td>FORMA/B Submit By :</td><td>"
										+ FORMABBY
										+ "</td></tr><tr><td>Status :</td><td>"
										+ currentStatus
										+ "</td></tr><tr><td>Submitted Date :</td><td>"
										+ currenttime
										+ "</td></tr><tr><td>FORMA/B Submit Date :</td><td>"
										+ FORMABDATE + "</td></tr>";
							} else if (currentStatus === "FORM3 Submitted") {
								table.innerHTML = "<tr><td>Submitted By :</td><td>"
										+ SUBBYs
										+ "</td></tr><tr><td>FORMC Submit By :</td><td>"
										+ FORM3BY
										+ "</td></tr><tr><td>Status :</td><td>"
										+ currentStatus
										+ "</td></tr><tr><td>Submitted Date :</td><td>"
										+ currenttime
										+ "</td></tr><tr><td>FORMC Submit Date :</td><td>"
										+ FORM3DATE + "</td></tr>";
							} else if (currentStatus === "Purchase Order Approved") {
								table.innerHTML = "<tr><td>Submitted By :</td><td>"
										+ SUBBYs
										+ "</td></tr><tr><td>Approved By :</td><td>"
										+ APRBYs
										+ "</td></tr><tr><td>Status :</td><td>"
										+ currentStatus
										+ "</td></tr><tr><td>Submitted Date :</td><td>"
										+ currenttime
										+ "</td></tr><tr><td>Approved Date :</td><td>"
										+ approvedtime + "</td></tr>";
							}

							// Append the <table> element to the <div> element
							div.appendChild(table);

							// Append the <div> element to the "MSG1234" element
							document.getElementById("POMSG1234").appendChild(
									div);

						}

						html = +'</span><br>';
						
						
						
						
//						 alert("ress "+JSON.stringify(data[1]))			
						
						var dataForm = data[1];
					    
						   
					    
					    jsonImplFormC = data[1];
					    
					    // Create input fields dynamically
					    var inputContainer = document.getElementById("inputContainer");

					    dataForm.forEach(function(entry, index) {
					    	
					        var row = document.createElement("div");
					        row.className = "row";

					        var startDateValue = entry.startDate;
					        var endDateValue = entry.endDate;
					        var paymentOptionValue = entry.paymentOption;
					        var fileUploadValue = entry.fileUpload;
					        
					        var startDateCol = document.createElement("div");
					        startDateCol.className = "col-md-3";
					        startDateCol.style="margin-top: 15px;";

					        var productLabel = document.createElement("label");
					        productLabel.innerHTML = "Start Date: ";

					        var productInput = document.createElement("input");
					        productInput.type = "text";
					        productInput.className = "form-control form-control-sm";
//					        alert("alert "+JSON.stringify(startDateValue))
					        
					        productInput.value = startDateValue;
					        productInput.setAttribute("readonly", "readonly");
					        productInput.id = "startDateCol_" + index; 

					        startDateCol.appendChild(productLabel);
					        startDateCol.appendChild(productInput);
					    
					        
					        // Create a row for End Date
					      
					        var qtyRow = document.createElement("div");
					        qtyRow.className = "row";

					        var endDateCol = document.createElement("div");
					        endDateCol.className = "col-md-3";
					        endDateCol.style="margin-top: 15px;";

					        var endDateColLabel = document.createElement("label");
					        endDateColLabel.innerHTML = "End Date: ";

					        var endDateColInput = document.createElement("input");
					        endDateColInput.type = "text";
					        endDateColInput.className = "form-control form-control-sm";
					        endDateColInput.value = endDateValue;
					        endDateColInput.setAttribute("readonly", "readonly");
					        endDateColInput.id = "endDateCol_" + index; 

					        endDateCol.appendChild(endDateColLabel);
					        endDateCol.appendChild(endDateColInput);

					        
					        
					        // Create Payment Status column
					        var paymentStatCol = document.createElement("div");
					        paymentStatCol.className = "col-md-3";
					        paymentStatCol.style="margin-top: 15px;";

					        var implementorLabel = document.createElement("label");
					        implementorLabel.innerHTML = "Payment Status: ";

					        var implementorInput = document.createElement("input");
					        implementorInput.type = "text";
					        implementorInput.className = "form-control form-control-sm";
					        implementorInput.value = paymentOptionValue;
					        implementorInput.setAttribute("readonly", "readonly");
					        implementorInput.id = "payment_" + index; 

					        paymentStatCol.appendChild(implementorLabel);
					        paymentStatCol.appendChild(implementorInput);
					        
					        
	        
					        // Create PO File name column
//					        var poFileCol = document.createElement("div");
//					        poFileCol.className = "col-md-3";
//					        poFileCol.style="margin-top: 15px;";
//
//					        var poFileLabel = document.createElement("label");
//					        poFileLabel.innerHTML = "Download PO File: ";
//
//					        var poFileInput = document.createElement("input");
//					        poFileInput.type = "text";
//					        poFileInput.className = "form-control form-control-sm";
//					        poFileInput.value = fileUploadValue;
//					        poFileInput.setAttribute("readonly", "readonly");
//					        poFileInput.id = "POfile_" + index; 
					                
					        var poFileCol = document.createElement("div");
					        poFileCol.className = "col-md-3";
					        poFileCol.style.marginTop = "15px";

					        var poFileLabel = document.createElement("label");
					        poFileLabel.innerHTML = "Download PO File: ";

					        var poFileInput = document.createElement("input");
					        poFileInput.type = "button";
					        poFileInput.className = "form-control form-control-sm";
//					        poFileInput.value = "Download";
					        poFileInput.value = fileUploadValue;
					        poFileInput.id = "POfile_" + index;

					        // Add an onclick event to handle the download action
					        poFileInput.onclick = function() {
					            POFileDownload(fileUploadValue);
					        };

					        poFileCol.appendChild(poFileLabel);
					        poFileCol.appendChild(poFileInput);
					        	      

					        // Append product column, space column, and implementor name column to the row
					        row.appendChild(startDateCol);
					        row.appendChild(endDateCol);
					        row.appendChild(paymentStatCol);
					        row.appendChild(poFileCol);

					        // Append the row to the input container
					        inputContainer.appendChild(row);

					        // Add some space between input field sets
//					        inputContainer.appendChild(document.createElement("br"));
//					        inputContainer.appendChild(document.createElement("br"));
					    });
						
						
						

					}
					modalOpened = true;
				}

			});

}

function clearModalData() {
	$('#vptype').val('');
	$('#vpsubscription').val('');
	$('#vpperepetual').val('');
	$('#vpcustomername').val('');

	$('#MSG1234').empty();
	$('#POMSG1234').empty();

	modalOpened = false;
}

$("#reload-btn").click(function() {
	location.reload();
});

//$("#reload-btn1").click(function() {
//	location.reload();
//});

var callToolTip231 = function(fieldName, status) {
	if (fieldName === "fromDate") {
		var errorMessage = "<span>Please Select  From Date<span>";
	}

	if (fieldName === "toDate") {
		var errorMessage = "<span>Please Select To Date <span>";
	}

	if (fieldName === "selecttype") {
		var errorMessage = "<span>Please Select Type <span>";
	}
	
	if (fieldName === "selectType2") {
		var errorMessage = "<span>Please Select Tracking Type <span>";
	}
	
	if (fieldName === "potennurestart2") {
		var errorMessage = "<span>Select Tenure Start Date<span>";
	}
	
	if (fieldName === "potennureend2") {
		var errorMessage = "<span>Select Tenure End Date<span>";
	}
	
	if (fieldName === "powarrantystart2") {
		var errorMessage = "<span>Select Warranty Start Date<span>";
	}
	if (fieldName === "powarrantyend2") {
		var errorMessage = "<span>Select Warranty End Date<span>";
	}
	if (fieldName === "poamcstart2") {
		var errorMessage = "<span>Select AMC Start Date<span>";
	}
	if (fieldName === "poamcend2") {
		var errorMessage = "<span>Select AMC End Date<span>";
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
};

$('#fromDate').on('click', function() {
	// alert("on focus")
	callToolTip231('fromDate', 'destroy');
});
$('#toDate').on('click', function() {
	// alert("on focus")
	callToolTip231('toDate', 'destroy');
});
$('#selecttype').on('click', function() {
	// alert("on focus")
	callToolTip231('selecttype', 'destroy');
});  
$('#selectType2').on('click', function() {
	// alert("on focus")
	callToolTip231('selectType2', 'destroy');
}); 
$('#potennurestart2').on('click', function() {
	// alert("on focus")
	callToolTip231('potennurestart2', 'destroy');
});
$('#potennureend2').on('click', function() {
	// alert("on focus")
	callToolTip231('potennureend2', 'destroy');
});

$('#powarrantystart2').on('click', function() {
	// alert("on focus")
	callToolTip231('powarrantystart2', 'destroy');
});
$('#powarrantyend2').on('click', function() {
	// alert("on focus")
	callToolTip231('powarrantyend2', 'destroy');
});
$('#poamcstart2').on('click', function() {
	// alert("on focus")
	callToolTip231('poamcstart2', 'destroy');
});
$('#poamcend2').on('click', function() {
	// alert("on focus")
	callToolTip231('poamcend2', 'destroy');   
});

function downFile(att) {
	// alert(att)
	// var filename = $('#filename').val();
	var filename = att;
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}



///////////////////////////////////////////////


$("#update-btn").click(function () {

//	alert("dkukh"+$('#endCustomerEmail').val())

    $('#spin11').show();
     
    var momentWstart = moment($('#powarrantystart2').val(), "DD-MM-YYYY");
	var momentWend = moment($('#powarrantyend2').val(), "DD-MM-YYYY");
	
	var momentAMCstart = moment($('#poamcstart2').val(), "DD-MM-YYYY");
	var momentAMCend = moment($('#poamcend2').val(), "DD-MM-YYYY");

//	fromDateTrack = $('#powarrantystart2').val();   
//	 toDateTrack = $('#powarrantyend2').val();
	
	if (momentWstart > momentWend || momentAMCstart > momentAMCend) {

		swal({
			title : "Warning",
			text : "End Date should be Greater than Start Date!",
			type : "warning",
			width : 300,
			allowOutsideClick : false,

		});

		return false;
		
		
	
	} else if(!validateAllDates()) {
		
		event.preventDefault();
	} else if(validateAllDates()) {
		
		
		var requestDates = {
				crno : ticketid,
				WstartDate : $('#powarrantystart2').val(),
				WendDate : $('#powarrantyend2').val(),
				AMCstartDate : $('#poamcstart2').val(),
				AMCendDate : $('#poamcend2').val()
				
			};
	//		alert("Data Updated");
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/UpdatePOdates";
    
    $.ajax({
        url: serviceUrl, 
        type: 'POST',
        data: requestDates
                     
    }).done(function (data) {
    	//alert("datata "+data)
        $('#spin11').hide();
        if (data === "success")
        {
            swal({
                title: "Successful!",
                text: "Dates Updated Successfully",
                type: "success",
                width: 300,
                height: 200,
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger m-l-10",
                confirmButtonText: "OK",
//                preConfirm: function () {
//                    var l = window.location;
//                    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                    window.location.href = base_url + "/User/UserTrackingTicket";
//                }
            })
        } else
        {
        	swal({
        	    title: "Fail!",
        	    html: "Dates Update Unsuccessful",
        	    type: "error",
        	    width: 300,
        	    height: 200,
        	    confirmButtonClass: "btn btn-success",
        	    cancelButtonClass: "btn btn-danger m-l-10",
        	    confirmButtonText: "OK"
        	});
        }

    });
    }
});




/// Tenure dates 

$("#updateTenure-btn").click(function () {

//	alert("dkukh"+$('#endCustomerEmail').val())

    $('#spin11').show();
    
    
    var momentTstart = moment($('#potennurestart2').val(), "DD-MM-YYYY");
	var momentTend = moment($('#potennureend2').val(), "DD-MM-YYYY");

//	fromDateTrack = $('#powarrantystart2').val();   
//	 toDateTrack = $('#powarrantyend2').val();
	
	if (momentTstart > momentTend) {

		swal({
			title : "Warning",
			text : "End Date should be Greater than Start Date!",
			type : "warning",
			width : 300,
			allowOutsideClick : false,

		});

		return false;
		
	} else if(!validateTenureDate()) {
		
		event.preventDefault();
	} else if(validateTenureDate()) {
	
		
		
		var requestDatesTenure = {
				crno : ticketid,
				TenureStartDate : $('#potennurestart2').val(),
				TenureEndDate : $('#potennureend2').val()
				
			};
	//		alert("Data Updated");
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/UpdatePOTenuredates";
    
    $.ajax({
        url: serviceUrl, 
        type: 'POST',
        data: requestDatesTenure
                     
    }).done(function (data) {
    	//alert("datata "+data)
        $('#spin11').hide();
        if (data === "success")
        {
            swal({
                title: "Successful!",
                text: "Dates Updated Successfully",
                type: "success",
                width: 300,
                height: 200,
                confirmButtonClass: "btn btn-success",
                cancelButtonClass: "btn btn-danger m-l-10",
                confirmButtonText: "OK",
            })
        } else
        {
        	swal({
        	    title: "Fail!",
        	    html: "Dates Update Unsuccessful",
        	    type: "error",
        	    width: 300,
        	    height: 200,
        	    confirmButtonClass: "btn btn-success",
        	    cancelButtonClass: "btn btn-danger m-l-10",
        	    confirmButtonText: "OK"
        	});
        }

    
    });
    }
});


function validateTenureDate() {
	// alert("hIHI")
	var indexError = 0;

	if ($('#potennurestart2').val() === '') {

		callToolTip231('potennurestart2', 'show');
		indexError = indexError + 1;

	}
	if ($('#potennureend2').val() === '') {

		callToolTip231('potennureend2', 'show');
		indexError = indexError + 1;
	}

	if (indexError > 0) {
		return false;
	} else {
		// $('#spinner2').show();
		return true;
	}
}


function validateAllDates() {
	// alert("hIHI")
	var indexError = 0;

	if ($('#powarrantystart2').val() === '') {

		callToolTip231('powarrantystart2', 'show');
		indexError = indexError + 1;
	}
	if ($('#powarrantyend2').val() === '') {

		callToolTip231('powarrantyend2', 'show');
		indexError = indexError + 1;
	}
	
	if ($('#poamcstart2').val() === '') {

		callToolTip231('poamcstart2', 'show');
		indexError = indexError + 1;
	}
	if ($('#poamcend2').val() === '') {

		callToolTip231('poamcend2', 'show');
		indexError = indexError + 1;
	}

	if (indexError > 0) {
		return false;
	} else {
		// $('#spinner2').show();
		return true;
	}
}


function POFileDownload(filename) {
	event.preventDefault();
//	alert("File "+filename);
//	var filename = encodeURIComponent($('#downHideRFPfile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="
			+ filename;
}