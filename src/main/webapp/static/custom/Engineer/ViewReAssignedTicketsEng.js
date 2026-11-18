window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/getReAssignedEngTickets";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',

		success : function(data5) {
			$("#preLoader").hide();
        	$("#Listing_Copy").removeClass("d-none");
			var table = $('#Listing_Copy').DataTable({
//				lengthChange : false,
				"lengthMenu":[
                    [5,10,25,50,-1],
                    [5,10,25,50,'Show all']
                ],
				pageLength : 5,
				data : data5,
				destroy : true,
				"scrollX" : "true",

			});
			table.buttons().container().appendTo(
					'#Listing_Copy_wrapper .col-sm-6:eq(0)');
		}
	});
}
//////////////////// ONLOAD ENDS ////////////////
function ViewTicket(id) {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/gatherEngTicketDetails";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(id),
//                + '&cno=' + $("#cno").val(),

        success: function (data) {
	
	
	     var T_REQUESTER = data[0]["T_REQUESTER"];
            var T_COMPANY = data[0]["T_COMPANY"];
            var T_BRANCH = data[0]["T_BRANCH"];
            var DEPARTMENT = data[0]["DEPARTMENT"];
            var SUB_DEPARTMENT = data[0]["SUB_DEPARTMENT"];
            var LOCATION = data[0]["LOCATION"];
            var T_PHONE = data[0]["T_PHONE"];
            var T_MAIL = data[0]["T_MAIL"];
            var T_CATEGORY = data[0]["T_CATEGORY"];
            var T_SUBCAT1 = data[0]["T_SUBCAT1"];
            var T_SUBCAT2 = data[0]["T_SUBCAT2"];
            var T_SUBJECT = data[0]["T_SUBJECT"];
            var T_DATE = data[0]["T_DATE"];
            var STATUS = data[0]["STATUS"];
            var T_ID = data[0]["T_ID"];
            var T_DESC = data[0]["T_DESC"];
            var PRIORITY = data[0]["PRIORITY"];
            var SEVERITY = data[0]["SEVERITY"];
            var REQUEST_MODE = data[0]["REQUEST_MODE"];
             var T_ATTACH_NAME = data[0]["T_ATTACH_NAME"];
          //alert("DEPARTMENT: "+DEPARTMENT);



            $("#nameupdateUD").val(T_REQUESTER);
            $("#companyupdateUD").val(T_COMPANY);
            $("#siteupdateUD").val(T_BRANCH);
            $("#deptupdateUD").val(DEPARTMENT);
            $("#subdeptupdateUD").val(SUB_DEPARTMENT);
            $("#locationupdateUD").val(LOCATION);
            $("#phoneupdateUD").val(T_PHONE);
            $("#emailupdateUD").val(T_MAIL);
            $("#categoryupdateTD").val(T_CATEGORY);
            $("#subcat1updateTD").val(T_SUBCAT1);
            $("#subcat2updateTD").val(T_SUBCAT2);
            $("#subjectupdateTD").val(T_SUBJECT);
            $("#raisedateupdateTD").val(T_DATE);
            $("#statusupdateTD").val(STATUS);
            $("#ticketidupdateTD").val(T_ID);
            $("#descriptionupdateTD").val(T_DESC);
            $("#priorityupdateTD").val(PRIORITY);
            $("#severityupdateTD").val(SEVERITY);
            $("#RequestModeupdateTD").val(REQUEST_MODE);
            var ASSETCHECK = data[0]["ASSETCHECK"];
            var ASSETNAME = data[0]["ASSETNAME"];
            var ASSETSTATUS = data[0]["ASSETSTATUS"];
            var ASSETCATEGORY = data[0]["ASSETCATEGORY"];
            var ASSETTAG = data[0]["ASSETTAG"];
            var ASSETSUBCATEGORY = data[0]["ASSETSUBCATEGORY"];
            var ASSET_IPADDRESS = data[0]["ASSET_IPADDRESS"];
            
            
            $("#asset_sub_categoryview").val(ASSETSUBCATEGORY);
            $("#asset_Ipaddressview").val(ASSET_IPADDRESS);
            $("#assetcheck").val(ASSETCHECK);
            $("#aname").val(ASSETNAME);
            $("#atag").val(ASSETTAG);
            $("#astatus").val(ASSETSTATUS);
            $("#acategory").val(ASSETCATEGORY);
            
//            alert( ASSETCHECK)
         
if((T_ATTACH_NAME=== ("No File Available"))||(T_ATTACH_NAME===("NA"))||(T_ATTACH_NAME===("null"))||(T_ATTACH_NAME===("undefined"))||(T_ATTACH_NAME===("")))
       {
          $('#hidedownload').hide();
          $('#nofileattach').show();
       }else
       {
           $('#hidedownload').show();
             $('#nofileattach').hide();
         document.getElementById('empPic').innerHTML=T_ATTACH_NAME;
         document.getElementById('filename').value=T_ATTACH_NAME;  
       }

      }
    });
    $("#modelview").modal("show");
}

$('#modelview').on('hidden.bs.modal', function () {
    $('a[role="tab"]').removeClass('active'); 
    $('a[role="tabpanel"]').removeClass('active show');
    $('#custom-tabs-four-home-tab').addClass('active');
    
    $('#custom-tabs-four-home').removeClass('active show');
    $('#custom-tabs-four-profile').removeClass('active show');
    $('#custom-tabs-four-home').addClass('active show');
	 document.getElementById("HideAssetdata").style.display = "none";
});
$('#close-btn').on("click", function () {
	$("#modelview").modal("hide");
    $('a[role="tab"]').removeClass('active'); 
    $('a[role="tabpanel"]').removeClass('active show');
    $('#custom-tabs-four-home-tab').addClass('active');
    
    $('#custom-tabs-four-home').removeClass('active show');
    $('#custom-tabs-four-profile').removeClass('active show');
    $('#custom-tabs-four-home').addClass('active show');
	 document.getElementById("HideAssetdata").style.display = "none";
});
 
 //////////////////// GET ACTIVITY LOG ////////////////
$('a[role="tab"]').on('shown.bs.tab', function (e) {
	  var target = $(e.target).attr("id") // activated tab
	  if(target==="custom-tabs-four-profile-tab"){
		  ticketid= $("#ticketidupdateTD").val();
		  
		  var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/UserActivity/getTicketActivityLog";
    
    $.ajax({
        url: serviceUrl,
        type: 'post',
       dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(ticketid),

        success: function(data) {
//        	alert(data[0]["CHANGE_NOTES2"]);
            var T_ID = data[0]["T_ID"];
            var TIMESTAMP = data[0]["TIMESTAMP"];
            var CHANGEBY = data[0]["CHANGEBY"];
            var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
            var STATUS = data[0]["STATUS"];
            var PRIORITY = data[0]["PRIORITY"];
            var CHANGE_NOTES1 = data[0]["CHANGE_NOTES1"];
            var CHANGE_NOTES2 = data[0]["CHANGE_NOTES2"];
            var SEVERITY = data[0]["SEVERITY"];
            var CATEGORY=data[0]["CATEGORY"];
            var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
            var SUBCATEGORY2=data[0]["SUBCATEGORY2"];
            var EMAIL=data[0]["EMAIL"];
            var FULLNAME=data[0]["FULLNAME"];

           document.getElementById('T_ID').innerHTML=T_ID;
          
           
           var attachment="";
           var att;
           var statusColor;
           var notes1;
           var notes2;
           var html ="";
           for(var i=0;i<data.length;i++)
        	   {
        	   //////////////// CODE FOR ATTACHMENT////////////
        	   if(data[i]["ATTACHMENT_NAME"]==undefined || data[i]["ATTACHMENT_NAME"]=="No File Available" || data[i]["ATTACHMENT_NAME"]=="" || data[i]["ATTACHMENT_NAME"]==" " || data[i]["ATTACHMENT_NAME"]==null)
      		 {
      		 attachment="No File Attached";
      		 }
      	 else{
      		 att=data[i]["ATTACHMENT_NAME"];
      		 attachment="<i class='nav-icon fas fa-download' onclick=downFileActivityLog('"+encodeURIComponent(att)+"')></i>";
      	 }
        	   ////////////////CODE FOR COLOUR////////////
        	   statusColor=data[i]["STATUS"];
//        	   alert(statusColor);
        	   var callOutColor="";
        	   if(statusColor=="New"){callOutColor="callout-info"}
        	   else if(statusColor=="Assigned" ||statusColor=="Re-Assigned"||statusColor=="Pending"){callOutColor="callout-warning"}
        	   else if( statusColor=="Reopened"){callOutColor="callout-danger"}
         	  
        	   else if(statusColor=="Hold" || statusColor=="Waiting for Spare" ||  statusColor=="Pending With Vendor"  ||  statusColor=="Awaiting User Information"){callOutColor="callout-danger"}
        	   else if(statusColor=="Resolved"){callOutColor="callout-success"}
        	   else if(statusColor=="Closed"||statusColor=="Update Approved"){callOutColor="callout-success"}
        	   else if(statusColor=="Rejected"){callOutColor="callout-danger"}
        	   else if(statusColor=="Update Rejected"){callOutColor="callout-danger"}
        	   else if(statusColor=="Work in Progress"){callOutColor="callout-warning"}
        	   /////////////// CODE FOR NOTES ///////////////
        	   if(data[i]["CHANGE_NOTES1"]==undefined || data[i]["CHANGE_NOTES1"]=="" || data[i]["CHANGE_NOTES1"]==" " || data[i]["CHANGE_NOTES1"]==null)
        		 {
        		   notes1="";
        		 }
        	 else{
        		 notes1="<textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["CHANGE_NOTES1"]+"</textarea>";
        	 }
        	   
        	   ////////////////CODE TO APPEND////////////
        	   html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type : <span>"+data[i]["ROLE_TYPE"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Priority : <span>"+data[i]["PRIORITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Severity : <span>"+data[i]["SEVERITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Category : <span>"+data[i]["CATEGORY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category1 : <span>"+data[i]["SUB_CATEGORY1"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category2 : <span>"+data[i]["SUBCATEGORY2"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Full Name: <span>"+data[i]["FULLNAME"]+"</span></span></div></div><div class='row'><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Email : <span>"+data[i]["EMAIL"]+"</span></span></div></div><br><div class='row'><div class='col-md-12'>"+notes1+"</div></div></div>";
        	   
              document.getElementById("MSG1234").innerHTML=html;
        	   }
           html=+ '<br>';
            }
     });
	  }
	});      

function downFile() {
	var filename = $('#filename').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}

function downFileActivityLog(att) {
		var filename =att;
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location = base_url + "/Master/DownloadFile?filename=" + filename;
	}

//////////////// UPDATE TICKET //////////////////////
function updateTicket(id) {
//alert(id)
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/EnggActivity/EditReAssinedTicketsDetails";
	var serviceUrl = base_url + "/EnggActivity/EditAssignTickets";
	$.ajax({

		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : "id=" + encodeURIComponent(id)

	}).done(function(data) {

		

		
		var engglocation = data[0]["engglocation"];
		var enggsubdepartment = data[0]["enggsubdepartment"];
		var tpsubdepartment = data[0]["tpsubdepartment"];
		var tplocation = data[0]["tplocation"];
		var userlocation = data[0]["userlocation"];
		var usersubdepartment = data[0]["usersubdepartment"];
		

		
		$("#subdepartmentrequester").val(usersubdepartment);
		$("#locationrequester").val(userlocation);
		$("#locationtp").val(tplocation);
		$("#subdepartmenttp").val(tpsubdepartment);
		$("#locationtpengg").val(engglocation);
		$("#subdepartmentengg").val(enggsubdepartment);
		
		
		/////////////// ENGG DATA ///////////
		var engname = data[0]["engname"];
		var engcompany = data[0]["engcompany"];
		var engbranch = data[0]["engbranch"];
		var engdepartment = data[0]["engdepartment"];
		var engemail = data[0]["engemail"];
		var engphone = data[0]["engphone"];
		
		 	$("#engname").val(engname);
	        $("#engcompany").val(engcompany);
	        $("#engsite").val(engbranch);
	        $("#engdepartment").val(engdepartment);
	        $("#engemailid").val(engemail);
	        $("#engphone").val(engphone);
		
		/////////////// REQUESTER DATA ///////////
		var username = data[0]["username"];
		var usercompany = data[0]["usercompany"];
		var userbranch = data[0]["userbranch"];
		var userdepartment = data[0]["userdepartment"];
		var usermail = data[0]["usermail"];
		var userphone = data[0]["userphone"];
		
		$("#username").val(username);
        $("#usercompany").val(usercompany);
        $("#usersite").val(userbranch);
        $("#userdepartment").val(userdepartment);
        $("#useremail").val(usermail);
        $("#userphone").val(userphone);
		
		/////////////// TC DATA ///////////
		var tpname = data[0]["tpname"];
		var tpcompany = data[0]["tpcompany"];
		var tpbranch = data[0]["tpbranch"];
		var tpdepartment = data[0]["tpdepartment"];
		var tpemail = data[0]["tpemail"];
		var tpphone = data[0]["tpphone"];
		var tprole = data[0]["tproletype"];
		$("#roletype").val(tprole);
		$("#tcname").val(tpname);
        $("#tccompany").val(tpcompany);
        $("#tcsite").val(tpbranch);
        $("#tcdepartment").val(tpdepartment);
        $("#tcemail").val(tpemail);
        $("#tcphone").val(tpphone);
		$().val();
		/////////////// TICKET DATA ///////////
		var tid = data[0]["tid"];
		var raisedate = data[0]["raisedate"];
		var assigndate = data[0]["assigndate"];
		var priority = data[0]["priority"];
		var severity = data[0]["severity"];
		var requestmode = data[0]["requestmode"];
		var company = data[0]["company"];
		var category = data[0]["category"];
		var subcat1 = data[0]["subcat1"];
		var subcat2 = data[0]["subcat2"];
		var sub = data[0]["sub"];
		var desc = data[0]["desc"];
		var status = data[0]["status"];
		var sol = data[0]["sol"];
     
        $("#tid").val(tid);
        $("#raisedate").val(raisedate);
        $("#assigndate").val(assigndate);
        $("#category").val(category);
        $("#subcat1").val(subcat1);
        $("#subcat2").val(subcat2);
        $("#ticketstatus").val(status);
        $("#priority").val(priority);
        $("#severity").val(severity);
        $("#requestmode").val(requestmode);
        $("#subject").val(sub);
        $("#description").val(desc);
        
        
      //CODE OF RAISE CRF
        $("#tid2").val(tid);
        $("#company2").val($('#usercompany').val());
        $("#branch2").val(userbranch);
        $("#department2").val(userdepartment);
        $("#sub2").val(sub);
        $("#des2").val(desc);
         


		$('#modelupdate').modal("show");

	});
}

$("#update_ticket").click(function() {
//	 alert("submit");
	if (!validateForm()) {
		event.preventDefault();
	} else {
		///////
		//////// CHECK FOR TICKET UPDATION CONFLICT ////////////
		//$("#update_ticket").attr("disabled", true);
	//	alert($('#status').val())
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/"+ l.pathname.split('/')[1];
		var serviceUrl = base_url + "/EnggActivity/CheckENGTicketUpdateConflictforReassign";
		 $.ajax({
		        type: 'POST',
		        url: serviceUrl,
		        dataType: 'json',       
		        data: 'ticketid=' + encodeURIComponent($('#tid').val())
		        +'&CurrentStatus='+encodeURIComponent($('#status').val())
		        +'&currentatassignto='+encodeURIComponent($('#assignTo').val())
		        +'&Crrentselecengg='+encodeURIComponent($('#enggassign').val())
		        +'&currentselectgrp='+encodeURIComponent($('#engGroup').val())
		            +'&priviousetpnaame='+encodeURIComponent($('#tcname').val())
		        +'&priviouseemail='+encodeURIComponent($('#tcemail').val()),
		        
		        success: function (data) {
//		        	alert("STATUS: "+data[0]["STATUS"]);
//		        	alert("PREVIOUS_ENG_NAME: "+data[0]["PREVIOUS_ENG_NAME"]);
//		        	alert("RESOLVED_TICKET_STATUS: "+data[0]["RESOLVED_TICKET_STATUS"]);
//		        	alert("PREVIOUS_ENG_SOLUTION: "+data[0]["PREVIOUS_ENG_SOLUTION"]);
//		        	alert("PREVIOUS_ENG_SOLUTION_DATE: "+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]);
		        	if(data[0]["STATUS"]==="Fail")
		        	{
		        		
		        		
		        		//alert(data[0]["ENGGGROUPTRUE"]);
		        		
		        		if(data[0]["RESOLVED_TICKET_STATUS"]==="Work in Progress" &&  $("#status").val()==="Work in Progress" ){
		        			///no action required //// comp
		        			//alert("Work in Progress 1")
		        			swal({
								title : 'Previous Record Found!',
								html : '<label><table class="table table-bordered" style="font-size:70%"><tr><td> Previously Assign To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer Or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td> Previous Activity Done By </td><td>'+data[0]["PREVIOUS_ACTIVITY_DONE_BY"]+'</td></tr><tr><td> Previous Activity  By </td><td>'+data[0]["PREVIOUS_ACTIVITY_BY"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["RESOLVED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr><tr><th colspan="2" style="color:#a70202;">Current Status</th></tr><tr><td style="color:#a70202;">Current Status</td><td style="color:#a70202;">'+$("#status").val()+'</td></tr></table></label><label>No Action Needed</label>',
								////type : 'warning',
								width : 500,
								showCancelButton: false,
								confirmButtonText: "OK",
						        buttons: false,
						        allowOutsideClick: false,
						        preConfirm : function() {
									location.reload();
								}
							})
		        		} 
		        		
		        		if(data[0]["RESOLVED_TICKET_STATUS"]==="Work in Progress" &&  $("#status").val()==="Re-Assigned"  && !data[0]["ENGGGROUPTRUE"] ){
		        			///no action required ////  comp
		        			//alert("in Re-Assigned in 2")
		        			swal({
								title : 'Previous Record Found!',
								html : '<label><table class="table table-bordered" style="font-size:70%"><tr><td> Previously Assign To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer Or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td> Previous Activity Done By </td><td>'+data[0]["PREVIOUS_ACTIVITY_DONE_BY"]+'</td></tr><tr><td> Previous Activity  By </td><td>'+data[0]["PREVIOUS_ACTIVITY_BY"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["RESOLVED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr><tr><th colspan="2" style="color:#a70202;">Current Status</th></tr><tr><td style="color:#a70202;">Current Status</td><td style="color:#a70202;">'+$("#status").val()+'</td></tr><tr><td style="color:#a70202;"> Currently Assign To </td><td style="color:#a70202;">'+data[0]["currentassignto"]+'</td></tr><tr><td style="color:#a70202;"> Current Selected Engineer Or Group </td><td style="color:#a70202;">'+data[0]["currentengorgrpswal"]+'</td></tr></table></label><label>Do you want to continue & update the ticket status?</label>',
								width : 500,
								showCancelButton: false,
								confirmButtonText: "OK",
						        buttons: false,
						        allowOutsideClick: false,
						        preConfirm : function() {
									location.reload();
								}
							})
		        		} 
		        		
		        		if(data[0]["RESOLVED_TICKET_STATUS"]==="Work in Progress" &&  $("#status").val()==="Re-Assigned"  && data[0]["ENGGGROUPTRUE"] ){
		        			///action required //// comp
		        		//	alert("Work in Progress 3")
		        			swal({
								title : 'Previous Record Found!',
								html : '<label><table class="table table-bordered" style="font-size:70%"><tr><td> Previously Assign To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer Or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td> Previous Activity Done By </td><td>'+data[0]["PREVIOUS_ACTIVITY_DONE_BY"]+'</td></tr><tr><td> Previous Activity  By </td><td>'+data[0]["PREVIOUS_ACTIVITY_BY"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["RESOLVED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr><tr><th colspan="2" style="color:#a70202;">Current Status</th></tr><tr><td style="color:#a70202;">Current Status</td><td style="color:#a70202;">'+$("#status").val()+'</td></tr><tr><td style="color:#a70202;"> Currently Assign To </td><td style="color:#a70202;">'+data[0]["currentassignto"]+'</td></tr><tr><td style="color:#a70202;"> Current Selected Engineer Or Group </td><td style="color:#a70202;">'+data[0]["currentengorgrpswal"]+'</td></tr></table></label><label>Do you want to continue & update the ticket status?</label>',
							//	type : 'warning',
								width : 500,
								showCancelButton: true,
								confirmButtonText: "Continue",
						        buttons: false,
						        allowOutsideClick: false,
							}).then((isConfirm) => {
						        if (isConfirm) {
						        	UpdateAssignedHoldandReassignticket();	
						        }
						    });
		        		
		        		} 
		        		if(data[0]["RESOLVED_TICKET_STATUS"]==="Re-Assigned" &&  $("#status").val()==="Re-Assigned"  && !data[0]["ENGGGROUPTRUE"] ){
		        			///no action required //// comp
		        		//alert("in Re-Assigned in 4")
		        			swal({
								title : 'Previous Record Found!',
								html : '<label><table class="table table-bordered" style="font-size:70%"><tr><td> Previously Assign To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer Or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td> Previous Activity Done By </td><td>'+data[0]["PREVIOUS_ACTIVITY_DONE_BY"]+'</td></tr><tr><td> Previous Activity  By </td><td>'+data[0]["PREVIOUS_ACTIVITY_BY"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["RESOLVED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr><tr><th colspan="2" style="color:#a70202;">Current Status</th></tr><tr><td style="color:#a70202;">Current Status</td><td style="color:#a70202;">'+$("#status").val()+'</td></tr></table></label><label>No Action Needed</label>',
								type : 'warning',
								width : 450,
								showCancelButton: false,
								confirmButtonText: "OK",
						        buttons: false,
						        allowOutsideClick: false,
						        preConfirm : function() {
									location.reload();
								}
							})
		        		} 
		        		if(data[0]["RESOLVED_TICKET_STATUS"]==="Re-Assigned" &&  $("#status").val()==="Re-Assigned"  && data[0]["ENGGGROUPTRUE"] ){
		        			///action required //// comp
		        			//alert("Re-Assigned 5")
		        			swal({
								title : 'Previous Record Found!',
								html : '<label><table class="table table-bordered" style="font-size:70%"><tr><td> Previously Assign To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer Or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td> Previous Activity Done By </td><td>'+data[0]["PREVIOUS_ACTIVITY_DONE_BY"]+'</td></tr><tr><td> Previous Activity  By </td><td>'+data[0]["PREVIOUS_ACTIVITY_BY"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["RESOLVED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr><tr><th colspan="2" style="color:#a70202;">Current Status</th></tr><tr><td style="color:#a70202;">Current Status</td><td style="color:#a70202;">'+$("#status").val()+'</td></tr><tr><td style="color:#a70202;"> Currently Assign To </td><td style="color:#a70202;">'+data[0]["currentassignto"]+'</td></tr><tr><td style="color:#a70202;"> Current Selected Engineer Or Group </td><td style="color:#a70202;">'+data[0]["currentengorgrpswal"]+'</td></tr></table></label><label>Do you want to continue & update the ticket status?</label>',
								//type : 'warning',
								width : 500,
								showCancelButton: true,
								confirmButtonText: "Continue",
						        buttons: false,
						        allowOutsideClick: false,
							}).then((isConfirm) => {
						        if (isConfirm) {
						        	UpdateAssignedHoldandReassignticket();	
						        }
						    });
		        		
		        		} 
		        		
		        		if(data[0]["RESOLVED_TICKET_STATUS"]==="Re-Assigned" &&  $("#status").val()==="Work in Progress"  && !data[0]["ENGGGROUPTRUE"] ){
		        			///no action required //// comp
		        		//alert("in Re-Assigned in 6")
		        			swal({
								title : 'Previous Record Found!',
								html : '<label><table class="table table-bordered" style="font-size:70%"><tr><td> Previously Assign To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer Or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td> Previous Activity Done By </td><td>'+data[0]["PREVIOUS_ACTIVITY_DONE_BY"]+'</td></tr><tr><td> Previous Activity  By </td><td>'+data[0]["PREVIOUS_ACTIVITY_BY"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["RESOLVED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr><tr><th colspan="2" style="color:#a70202;">Current Status</th></tr><tr><td style="color:#a70202;">Current Status</td><td style="color:#a70202;">'+$("#status").val()+'</td></tr></table></label><label>No Action Needed</label>',
								//type : 'warning',
								width : 500,
								showCancelButton: false,
								confirmButtonText: "OK",
						        buttons: false,
						        allowOutsideClick: false,
						        preConfirm : function() {
									location.reload();
								}
							})
		        		} 	if(data[0]["RESOLVED_TICKET_STATUS"]==="Re-Assigned" &&  $("#status").val()==="Work in Progress"  && data[0]["ENGGGROUPTRUE"] ){
		        			///action required //// comp
		        			///alert("in Re-Assigned in 7")
		        			swal({
								title : 'Previous Record Found!',
								html : '<label><table class="table table-bordered" style="font-size:70%"><tr><td> Previously Assign To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer Or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td> Previous Activity Done By </td><td>'+data[0]["PREVIOUS_ACTIVITY_DONE_BY"]+'</td></tr><tr><td> Previous Activity  By </td><td>'+data[0]["PREVIOUS_ACTIVITY_BY"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["RESOLVED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr><tr><th colspan="2" style="color:#a70202;">Current Status</th></tr><tr><td style="color:#a70202;">Current Status</td><td style="color:#a70202;">'+$("#status").val()+'</td></tr></table></label><label>Do you want to continue & update the ticket status?</label>',							
								width : 500,
								showCancelButton: true,
								confirmButtonText: "Continue",
						        buttons: false,
						        allowOutsideClick: false,
							}).then((isConfirm) => {
						        if (isConfirm) {
						        	UpdateAssignedHoldandReassignticket();	
						        }
						    });
		        		
		        		} 
//		        		
		        	}
		       // 	alert(data[0]["STATUS"]);
		        	 if(data[0]["STATUS"]==="Pass")
		        	{
		        		 
		        		 UpdateAssignedHoldandReassignticket();
		        	}
		        }
		
		 });
		
	}
});
function UpdateAssignedHoldandReassignticket(){
	////////////// UpdateReAssignEngTickets //////////////////
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/"
			+ l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/UpdateAssignedHoldandReassignticket";
	
	 var form=$('form')[0];
	 var formData= new FormData(form);
	 
	$.ajax({
				url: serviceUrl,
		        type: 'post',
		        data: formData,
		        mimeType: "multipart/form-data",
		        contentType: false,
		        processData: false,
		        cache: false,

			}).done(function(data) {

		if (data == "success") {

			if (($('#status').val()) == "Re-Assigned") {
				//alert("Hold");
				swal({
					title : 'Successful!',
					html : 'Ticket Re-Assigned Successfully',
					type : 'success',
					width : 300,
//					 showCancelButton: false,
//			       confirmButtonClass: "btn btn-danger",
//			       cancelButtonClass: "btn btn-danger m-l-10",
//			       confirmButtonText: "OK",
			         buttons: false,
			         allowOutsideClick: false,
					preConfirm : function() {
						location.reload();
					}
				});
			} else if (($('#status').val()) == "Resolved"){
				//alert("Resolved");
				swal({
					title : 'Successful!',
					html : 'Ticket Resolved Successfully',
					type : 'success',
					width : 300,
//					 showCancelButton: false,
//			       confirmButtonClass: "btn btn-danger",
//			       cancelButtonClass: "btn btn-danger m-l-10",
//			       confirmButtonText: "OK",
			         buttons: false,
			         allowOutsideClick: false,
					preConfirm : function() {
						location.reload();
					}
				});
			}
			 else if (($('#status').val()) == "Work in Progress"){
				//alert(" Resolved");
					swal({
						title : 'Successful!',
						html : 'Ticket Work in Progress Successfully',
						type : 'success',
						width : 300,
//						 showCancelButton: false,
//				       confirmButtonClass: "btn btn-danger",
//				       cancelButtonClass: "btn btn-danger m-l-10",
//				       confirmButtonText: "OK",
				         buttons: false,
				         allowOutsideClick: false,
						preConfirm : function() {
							location.reload();
						}
					});
				}

		} else {
			swal({
				title : 'Unsuccessful!',
				html : 'Ticket Update Failed',
				type : 'error',
				width : 300,
//				 showCancelButton: false,
//		       confirmButtonClass: "btn btn-danger",
//		       cancelButtonClass: "btn btn-danger m-l-10",
//		       confirmButtonText: "OK",
		         buttons: false,
		         allowOutsideClick: false,
				preConfirm : function() {
					location.reload();
				}
			});
		}
	});
}

function validateForm() {

	var indexError = 0;

	if ($('#status').val() === '') {
		//('inside status');
		callToolTip231('status', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#solution').val() === '') {
		//('inside solution');
		callToolTip231('solution', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	

	 if ($('#assignTo').val().trim() =='' && $('#status').val() == 'Re-Assigned') {
//      //('fill enggcat');
      callToolTip231('assignTo', 'show');

      if (indexError == 0) {

      }
      indexError = indexError + 1;
  }
  if ($('#assignTo').val().trim() == 'Engineer' && $('#status').val() == 'Re-Assigned') {
	   
	   if ($('#enggcat').val().trim() === '') {
	        //('fill enggcat');
	        callToolTip231('enggcat', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	    if ($('#enggassign').val().trim() === ''   && $('#status').val() == 'Re-Assigned') {
	        //('fill enggassign');
	        callToolTip231('enggassign', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    } 
  } else if ($('#assignTo').val().trim() === 'Group' && $('#status').val() == 'Re-Assigned' ) {
	   
	   if ($('#engGroup').val().trim() === '') {
//	        //('fill enggassign');
	        callToolTip231('engGroup', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
  }
 
	//("validation error count::::" + indexError);
	if (indexError > 0) {

		return false;

	} else {

		// $('#spinner2').show();

		return true;
	}

}

// focus out
$('#status').on('focusout', function() {

	var usertype = $('#status').val();
	if (usertype.trim() == "") {
		callToolTip231('status', 'show');
	} else {
		callToolTip231('status', 'hide');
	}
});

$('#solution').on('focusout', function() {

	var usertype = $('#solution').val();
	if (usertype.trim() == "") {
		callToolTip231('solution', 'show');
	} else {
		callToolTip231('solution', 'hide');
	}
});

$('#status').on('focus', function() {
	callToolTip231('status', 'destroy');
});

$('#solution').on('focus', function() {
	callToolTip231('solution', 'destroy');
});


$('#assignTo').on('focus', function () {
    callToolTip231('assignTo', 'destroy');
});
$('#enggcat').on('focus', function () {
    callToolTip231('enggcat', 'destroy');
});
$('#enggassign').on('focus', function () {
    callToolTip231('enggassign', 'destroy');
});
$('#engGroup').on('focus', function () {
    callToolTip231('engGroup', 'destroy');
});



var callToolTip231 = function(fieldName, status) {
	if (fieldName == "status") {
		var errorMessage = "<span>Please Select Status of Ticket<span>";
	} else if (fieldName == "solution") {
		var errorMessage = "<span>Please Enter Reason for Hold/Solution for Resolved<span>";
	}
	else if (fieldName == "changeseverity") {
		var errorMessage = "<span>Please Select new Severity<span>";
	}
	 else if (fieldName == "changepriority") {
			var errorMessage = "<span>Please Select new Severity<span>";
		}
	 else if (fieldName == "changereason") {
			var errorMessage = "<span>Please Enter Reason for Change Severity/Priority<span>";
		}
	 else if (fieldName == "engnote21") {
			var errorMessage = "<span>Please Enter Reason for Raise Crf<span>";
		}
	 else if (fieldName === "assignTo") {      
	        var errorMessage = "<span>Please Select Assign To<span>";
	    }
	    else if (fieldName === "enggcat") {      
	        var errorMessage = "<span>Please Select Category<span>";
	    }
	    else if (fieldName === "enggassign") {
	        var errorMessage = "<span>Please Select Engineer<span>";
	    }
	    else if (fieldName === "engGroup") {
	        var errorMessage = "<span>Please Select Engineer Group<span>";
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


//START CODE OF 



function changeps1(){
	
	
	//if ($('#changeps:checked').val() !== undefined)
	//{
	   
		
		 var l = window.location;
	     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	     	var serviceUrl = base_url + "/Master/getPriorityNameforcatalogue";

	        $.ajax({
	            type: 'POST',
	            url: serviceUrl,
	            dataType: 'json',
	            data:'company='+encodeURIComponent($("#usercompany").val()),
	            success: function(data2) {
	                //alert(data2)
	            	var html = "  <option value=''> -- Please Select --</option>";
	                for (var i = 0; i < data2.length; i++) {
	                    html += '<option value="' + data2[i] + '">' + data2[i]
	                            + '</option>';
	                }
	                document.getElementById("changepriority").innerHTML = html;
	                var se=$("#priority").val();
	               // alert($("#priority").val());
	                
	                $("#changepriority").val(se);
	         }
	   });     
	   
	        
	        var l = window.location;
	      	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	      	var serviceUrl = base_url + "/Master/getSeverityNameforcatalogue";

	         $.ajax({
	             type: 'POST',
	             url: serviceUrl,
	             dataType: 'json',
	             data:'company='+encodeURIComponent($("#usercompany").val()),
	             success: function(data2) {
//	                 alert(data2)
	             	var html = "  <option value=''> -- Please Select --</option>";
	                 for (var i = 0; i < data2.length; i++) {
	                     html += '<option value="' + data2[i] + '">' + data2[i]
	                             + '</option>';
	                 }
	                 document.getElementById("changeseverity").innerHTML = html;
	                 
	                 var pe=$("#severity").val();
		             //   alert($("#severity").val());
		                
		                $("#changeseverity").val(pe);
	          }
	    });     
	         $("#changereason").val("");
	          $('#modelchangesp').modal('show');
	          
	      
}
       // CHANGE SEVERITY PRIORITY SAVE
		
			
			$( "#submit-click1" ).click(function() {
				
				if (!validateChangesp()) {
					event.preventDefault();
				} else {
					 var l = window.location;
			         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			         var serviceUrl = base_url + "/EnggActivity/insertchangeps";
			         

			    $.ajax({
			        url: serviceUrl,
			        type: 'POST',
			        data: "newpriority=" + encodeURIComponent($('#changepriority').val())
			                + "&newseverity=" + encodeURIComponent($('#changeseverity').val())
			                + "&changenote=" + encodeURIComponent($('#changereason').val())
			                + "&oldpriority=" + encodeURIComponent($('#priority').val())
			                + "&oldseverity=" +encodeURIComponent( $('#severity').val())
			                + "&subject=" + encodeURIComponent($('#subject').val())
			                + "&ticketId=" + encodeURIComponent($('#tid').val())
			                + "&ticketstatus=" + encodeURIComponent($('#ticketstatus').val())
			                + "&engname=" + encodeURIComponent($('#engname').val())
			                + "&engcompany=" + encodeURIComponent($('#engcompany').val())
			                + "&usersite=" + encodeURIComponent($('#usersite').val())
			                + "&userdepartment=" + encodeURIComponent($('#userdepartment').val())
			                 + "&category=" +encodeURIComponent( $('#category').val())
			                 + "&subcat1=" + encodeURIComponent($('#subcat1').val())
			                 + "&subcat2=" + encodeURIComponent($('#subcat2').val())
			                      + "&tccompany=" + encodeURIComponent($('#tccompany').val())
			                     + "&usercompany=" + encodeURIComponent($('#usercompany').val())
			                  + "&username=" + encodeURIComponent($('#username').val())
			                      + "&description=" +encodeURIComponent( $('#description').val())
			                  
			                  ,
			                
			    }).done(function (data) {
			        if (data === "success") {

			            swal({
			                title: "Successful!",
			                text: "Request Updated Successfully",
			                type: "success",
			                width: 300,
			                height: 200,
			                confirmButtonClass: "btn btn-success",
			                confirmButtonText: "OK",
			            	preConfirm : function() {
								location.reload();
							}
			            })

			            
			        } else if (data === "error") {

			            swal({
			                title: "Fail!",
			                text: "Request Updated UnSuccessful",
			                type: "error",
			                width: 300,
			                height: 200,
			                confirmButtonClass: "btn btn-success",
			                confirmButtonText: "OK"

			            })

			        }
			    

			    })

			
			
					
				}
				
			
});

			function validateChangesp(){
				
				
				var indexError2 = 0;

				if ($('#changereason').val() === '') {
					//('inside changereason');
					callToolTip231('changereason', 'show');

					if (indexError2 == 0) {

					}
					indexError2 = indexError2 + 1;
				}

				if ($('#changeseverity').val() === '') {
					//('inside changeseverity');
					callToolTip231('changeseverity', 'show');

					if (indexError2 == 0) {

					}
					indexError2 = indexError2 + 1;
				}

				if ($('#changepriority').val() === '') {
					//('inside changepriority');
					callToolTip231('changepriority', 'show');

					if (indexError2 == 0) {

					}
					indexError2 = indexError2 + 1;
				}
				if (indexError2 > 0) {

					return false;

				} else {
					return true;
				}

			}

			// focus out
	

			$('#changereason').on('focus', function() {
				callToolTip231('changereason', 'destroy');
			});

			$('#changepriority').on('focus', function() {
				callToolTip231('changepriority', 'destroy');
			});
			

			$('#changeseverity').on('focus', function() {
				callToolTip231('changeseverity', 'destroy');
			});
			
			
			
			
			
			
			function raisecrf()
			{
				
				$("#engnote21").val("");
				  $('#modelraisecrf').modal('show');
			}
			
			
			
		$( "#submit-click2" ).click(function() {
				
				if (!validateraisecrf()) {
					event.preventDefault();
				} else {
					 var l = window.location;
			         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			         var serviceUrl = base_url + "/EnggActivity/insertraisecrf";
			         

			    $.ajax({
			        url: serviceUrl,
			        type: 'POST',
			        data: "tid2=" + encodeURIComponent($('#tid2').val())
			                + "&company2=" + encodeURIComponent($('#company2').val())
			                + "&branch2=" + encodeURIComponent($('#branch2').val())
			                + "&department2=" + encodeURIComponent($('#department2').val())
			                + "&sub2=" + encodeURIComponent($('#sub2').val())
			                + "&des2=" + encodeURIComponent($('#des2').val())
			                 + "&engnote21=" + encodeURIComponent($('#engnote21').val())
			                     + "&priority=" + encodeURIComponent($('#priority').val())
			                                + "&severity=" + encodeURIComponent($('#severity').val())
			                     
			                 
			                  ,
			                
			                  
			                
			    }).done(function (data) {
			        if (data === "success") {

			            swal({
			                title: "Successful!",
			                text: "Request Updated Successfully",
			                type: "success",
			                width: 300,
			                height: 200,
			                confirmButtonClass: "btn btn-success",
			                confirmButtonText: "OK",
			            	preConfirm : function() {
								location.reload();
							}
			            })

			            
			        } else if (data === "error") {

			            swal({
			                title: "Fail!",
			                text: "Request Updated UnSuccessful",
			                type: "error",
			                width: 300,
			                height: 200,
			                confirmButtonClass: "btn btn-success",
			                confirmButtonText: "OK"

			            })

			        }
			    

			    })

			
			
					
				}
				
			
});
				function validateraisecrf(){
			
			
			var indexError3 = 0;

			if ($('#engnote21').val() === '') {
				//('inside engnote21');
				callToolTip231('engnote21', 'show');

				if (indexError3 == 0) {

				}
				indexError3 = indexError3 + 1;
			}

		
			
			if (indexError3 > 0) {

				return false;

			} else {
				return true;
			}

		}
				

				$('#engnote21').on('focusout', function() {

					var usertype = $('#engnote21').val();
					if (usertype.trim() == "") {
						callToolTip231('engnote21', 'show');
					} else {
						callToolTip231('engnote21', 'hide');
					}
				});
				
				
				

				$('#engnote21').on('focus', function() {
					callToolTip231('engnote21', 'destroy');
				});
				
				$('#modelupdate').css('overflow-y', 'auto');
				$('#modelupdate').on('hidden.bs.modal', function () {
					$("#status").val("");
					$("#solution").val("");
					document.getElementById("Hideotherdata").style.display = "none";

					$('#enggcat').val("");
					$('#enggassign').val("");
					$('#engGroup').val("");
					$('#assignTo').val("");
					callToolTip231('enggcat', 'destroy');
					callToolTip231('enggassign', 'destroy');
					callToolTip231('engGroup', 'destroy');
					//document.getElementById("Hideotherdata").style.display = "none";
//					alert(assignType)

					$('#assigntodiv').hide();
					$('#enggDiv').hide();
					$('#groupDiv').hide();
					$('#assigntodiv').hide();
					
})



function onchangeofstatus(statusis){
//	alert(statusis);
	if(statusis == 'Re-Assigned'){
		
		
		
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/getCategoryDetailsforuScop2";

	    $.ajax({

	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data:'Categoryup='+encodeURIComponent($('#usercompany').val()),
	    }).done(function (data) {
//	    	alert(data)
	        var html = " <select class='form-control' tabindex='7' id='enggcat' name='enggcat' onchange='change_enggsubtype(this.value)'>";
	        html = html + '<option value="">--Please Select Category--</option>';
	        for (var i = 0; i < data.length; i++) {
	            html += '<option value="' + data[i] + '">' + data[i]
	                    + '</option>';
	        }

	        document.getElementById("enggcat").innerHTML = html;
	    });
	    
		
	$('#assigntodiv').show();
	
	}else{
		
		document.getElementById("Hideotherdata").style.display = "none";
//		alert(assignType)
		$('#enggcat').val("");
		$('#enggassign').val("");
		$('#engGroup').val("");
		$('#assignTo').val("");
		callToolTip231('enggcat', 'destroy');
		callToolTip231('enggassign', 'destroy');
		callToolTip231('engGroup', 'destroy');
		$('#assigntodiv').hide();
		$('#enggDiv').hide();
		$('#groupDiv').hide();
		
		
	}
	
}







function change_enggsubtype(category)
{
	$('#enggassign').val("");
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getSubCategoryEnggName";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: 'categ=' + encodeURIComponent(category)
        + '&Company=' + encodeURIComponent($("#usercompany").val())
        + '&Branch=' + encodeURIComponent($("#usersite").val())
        + '&Department=' + encodeURIComponent($("#userdepartment").val()),
        
    }).done(function (data) {
//    	alert(data)
        var html = " <select class='form-control' tabindex='7' id='enggassign' name='enggassign'>";
        html = html + '<option value="">--Please Select Engineer--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("enggassign").innerHTML = html;
    });
}        






function change_Assigntype(assignType){
	document.getElementById("Hideotherdata").style.display = "none";
//	alert(assignType)
	$('#enggcat').val("");
	$('#enggassign').val("");
	$('#engGroup').val("");
	callToolTip231('enggcat', 'destroy');
	callToolTip231('enggassign', 'destroy');
	callToolTip231('engGroup', 'destroy');
	
	if(assignType==="Engineer"){
		$('#enggDiv').show();
		$('#groupDiv').hide();
	}
	else if(assignType==="Group"){
		$('#groupDiv').show();
		$('#enggDiv').hide();
		
		
		   var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/getGroupDetails";

         $.ajax({

             url: serviceUrl,
             type: 'POST',
             dataType: 'json',
             data:'compname='+encodeURIComponent($("#usercompany").val())	
         }).done(function (data) {

             var html = " <select class='form-control' tabindex='7' id='engGroup' name='engGroup'>";
             html = html + '<option value="">--Please Select Group--</option>';
             for (var i = 0; i < data.length; i++) {
                 html += '<option value="' + data[i] + '">' + data[i]
                         + '</option>';
             }

             document.getElementById("engGroup").innerHTML = html;
         });
	}
	else{
		$('#enggDiv').hide();
		$('#groupDiv').hide();
	}
}




//CODE FOR GET OTHER DATA
function getothersdata(othername){
	 document.getElementById("Hideotherdata").style.display = "none";
	
	if(othername.length>0){
	//	alert("inside");
	 
	
	//alert(othername);
	//getting split for company and username
	
	const words = othername.split('~');
	////(words[0]);
	var otherusername=words[0];
	var othercompany=words[2];
//	alert(othercompany + "company");
	//alert(otherusername + "otherusername ias");
	 var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/UserActivity/Getotherinformaion";
	
	  $.ajax({
	      type: 'POST',	
	      url: serviceUrl,
	      dataType: 'json',
	     data: 'othername=' + encodeURIComponent(otherusername)
	     + '&othercompany=' + encodeURIComponent(othercompany),
	     
	      success: function(data) {  	
	      
	    	 // alert(data[0]["OTHEREMAIL"])
	    	var OTHEREMAIL=data[0]["OTHEREMAIL"];
	    	var OTHERFULLNAME=data[0]["OTHERFULLNAME"];
	    	var OTHERCOMPANY=data[0]["OTHERCOMPANY"];
	    	var OTHERBRANCH=data[0]["OTHERBRANCH"];
	    	var OTHERDEPARTMENT=data[0]["OTHERDEPARTMENT"];
	    	
	    	
	    	$("#otheremail").val(OTHEREMAIL);
	    	$("#otherfullname").val(OTHERFULLNAME);
	    	$("#othersite").val(OTHERBRANCH);
	    	$("#othercompname").val(OTHERCOMPANY);
	    	$("#otherdepart").val(OTHERDEPARTMENT);
	     
	    	
	      }
	}); 
	    document.getElementById("Hideotherdata").style.display = "block";

	
	}
}

function  characterCounter()
{
//	alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("solution").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}

