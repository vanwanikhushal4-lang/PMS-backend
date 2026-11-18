window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/getenggWorkInProgressRequest";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',

		success : function(data5) {
//alert(data5)
			$("#preLoader").hide();
        	$("#Listing_Copy").removeClass("d-none");
			var table = $('#Listing_Copy').DataTable({
//				lengthChange : false,
				pageLength : 5,
				data : data5,
				destroy : true,
				"scrollX" : true,
				columnDefs: [{
					targets: [7,13,14,15,16,17],
					orderable: false
					}],
				initComplete: function () {
					this.api().columns([7,13,14,15,16,17]).every(function () {
				         var column = this;
				         $(column.header()).prepend("<br>")
				           var select = $('<select><option value="">All</option></select>').prependTo($(column.header()))
				                               .on('change', function () {
				                 var val = $.fn.dataTable.util.escapeRegex(
				                     $(this).val()
				                 );
				                 column.search(val ? '^' + val + '$' : '', true, false).draw();
				             });
				           column.data().unique().sort().each(function (d, j) {
				             select.append('<option value="' + d + '">' + d + '</option>')
				          } );

				 
				    } );
				}

			});
			table.buttons().container().appendTo(
					'#Listing_Copy_wrapper .col-sm-6:eq(0)');
			  $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
		}
	});
}
/////////////////// ONLOAD ENDS /////////////////
function ViewTicket(id) {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/gatherUserServiceRequest";
	        
	        $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'ticketid=' + encodeURIComponent(id),

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

	             

				  
			     var REQUESTTYPE = data[0]["REQUESTTYPE"];
             var APPROVALLEVEL = data[0]["APPROVALLEVEL"];
              var PROCESSINGGROUP = data[0]["PROCESSINGGROUP"];

              
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
              
//              alert( ASSETCHECK)
          

	         	$("#viewrequesttype").val(REQUESTTYPE);
	              $("#viewapprovallevel").val(APPROVALLEVEL);
	              $("#viewprocessinggroup").val(PROCESSINGGROUP);
				  
				  
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
	            $("#severityupdateTD1").val(SEVERITY);
	            $("#RequestModeupdateTD").val(REQUEST_MODE);
	            
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
	      
	if(T_COMPANY=="3i Infotech" && ASSETCHECK == "true")  
	{

	document.getElementById("HideAssetdata").style.display = "block";

	}
	else {

		document.getElementById("HideAssetdata").style.display = "none";
		 }
	        }
	    });
	             $("#modelview").modal("show");
	        }

$('#modelview').on('hidden.bs.modal', function () {
	$('#HideAssetdata').hide();
    $('a[role="tab"]').removeClass('active'); 
    $('a[role="tabpanel"]').removeClass('active show');
    $('#custom-tabs-four-home-tab').addClass('active');
    
    $('#custom-tabs-four-home').removeClass('active show');
    $('#custom-tabs-four-profile').removeClass('active show');
    $('#custom-tabs-four-home').addClass('active show');
});
$('#close-btn').on("click", function () {
	$("#modelview").modal("hide");
    $('a[role="tab"]').removeClass('active'); 
    $('a[role="tabpanel"]').removeClass('active show');
    $('#custom-tabs-four-home-tab').addClass('active');
    
    $('#custom-tabs-four-home').removeClass('active show');
    $('#custom-tabs-four-profile').removeClass('active show');
    $('#custom-tabs-four-home').addClass('active show');
});

function downFile()
{
var filename = $('#filename').val();
//alert(encodeURIComponent(filename))
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + encodeURIComponent(filename);
 }

function downFileActivityLog(att) {
//alert(att)
//	var filename = $('#filename').val();
	var filename =att;
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}
////////////////////GET ACTIVITY LOG ////////////////
$('a[role="tab"]').on('shown.bs.tab', function (e) {
var target = $(e.target).attr("id") // activated tab
if(target==="custom-tabs-four-profile-tab"){
	  ticketid= $("#ticketidupdateTD").val();
	  
	  var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/UserActivity/getServiceActivityLog";

$.ajax({
  url: serviceUrl,
  type: 'post',
 dataType: 'json',
  data: 'ticketid=' + encodeURIComponent(ticketid),

  success: function(data) {
//  	alert(data[0]["CHANGE_NOTES2"]);
      var T_ID = data[0]["T_ID"];
      var TIMESTAMP = data[0]["TIMESTAMP"];
      var CHANGEBY = data[0]["CHANGEBY"];
      var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
      var STATUS = data[0]["STATUS"];
      var PRIORITY = data[0]["PRIORITY"];
      var CHANGE_NOTES1 = data[0]["CHANGE_NOTES1"];
      var CHANGE_NOTES2 = data[0]["CHANGE_NOTES2"];
      var SEVERITY=data[0]["SEVERITY"];
      var CATEGORY=data[0]["CATEGORY"];
      var SUBCATEGORY1=data[0]["SUBCATEGORY1"];
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
//  	   alert(statusColor);
  	   var callOutColor="";
  	 if(statusColor=="New"){callOutColor="callout-info"}
 	   else if(statusColor=="Assigned" || statusColor=="Level_1_Approved" || statusColor=="Level_2_Approved"|| statusColor=="Level 1 Approved"||statusColor=="Level 2 Approved"||statusColor=="Re-Assigned"||statusColor=="Re-Opened"||statusColor=="Work in Progress"){callOutColor="callout-warning"}
 	  
 	   else if(statusColor=="Resolved"||statusColor=="Closed"||statusColor=="Completed" ){callOutColor="callout-success"}
 	   else if(statusColor="Rejected"||statusColor=="Re-Opened"||statusColor=="Hold" || statusColor=="Waiting for Spare" ||  statusColor=="Pending With Vendor"  ||  statusColor=="Awaiting User Information"||statusColor=="Level 1 Rejected"|| statusColor=="Level 2 Rejected"){callOutColor="callout-danger"}   
  	   
  	   /////////////// CODE FOR NOTES ///////////////
  	   if(data[i]["CHANGE_NOTES1"]==undefined || data[i]["CHANGE_NOTES1"]=="" || data[i]["CHANGE_NOTES1"]==" " || data[i]["CHANGE_NOTES1"]==null)
  		 {
  		   notes1="";
  		 }
  	 else{
  		 notes1="<textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["CHANGE_NOTES1"]+"</textarea>";
  	 }
  	   
  	   ////////////////CODE TO APPEND////////////
  	 html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type : <span>"+data[i]["ROLE_TYPE"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Priority : <span>"+data[i]["PRIORITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Severity : <span>"+data[i]["SEVERITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Category : <span>"+data[i]["CATEGORY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category1 : <span>"+data[i]["SUBCATEGORY1"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category2 : <span>"+data[i]["SUBCATEGORY2"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Full Name: <span>"+data[i]["FULLNAME"]+"</span></span></div></div><div class='row'><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Email : <span>"+data[i]["EMAIL"]+"</span></span></div></div><br><div class='row'><div class='col-md-12'>"+notes1+"</div></div></div>";
  	   
        document.getElementById("MSG1234").innerHTML=html;
  	   }
     html=+ '<br>';
      }
});
}
});

///////////////////// UPDATE TICKET /////////////////////
function updateTicket(id) {
// alert("hiii");
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/EditAssignRequest";
	$.ajax({
		url : serviceUrl,
		type : 'POST',
		dataType: 'json',
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
		
//		alert(data);
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
		var role_type=data[0]["role_type"];
        
        $("#role_type").val(role_type);
		
		$("#tcname").val(tpname);
        $("#tccompany").val(tpcompany);
        $("#tcsite").val(tpbranch);
        $("#tcdepartment").val(tpdepartment);
        $("#tcemail").val(tpemail);
        $("#tcphone").val(tpphone);
      

		/////////////// TICKET DATA ///////////
		
		 

        var REQUESTTYPE = data[0]["REQUESTTYPE"];
        var APPROVALLEVEL = data[0]["APPROVALLEVEL"];
        var PROCESSINGGROUP = data[0]["PROCESSINGGROUP"];

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
		  $("#actionrequesttype").val(REQUESTTYPE);
	        $("#actionapprovallevel").val(APPROVALLEVEL);
	        $("#actionprocessinggroup").val(PROCESSINGGROUP);
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

		
        var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/Master/getCategoryDetailsforuScop2";

	    $.ajax({

	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data:'Categoryup='+encodeURIComponent($('#usercompany').val()),
	    }).done(function (data) {
    //	alert(data)
	        var html = " <select class='form-control' tabindex='7' id='enggcat' name='enggcat' onchange='change_enggsubtype(this.value)'>";
	        html = html + '<option value="">--Please Select Category--</option>';
	        for (var i = 0; i < data.length; i++) {
	            html += '<option value="' + data[i] + '">' + data[i]
	                    + '</option>';
	        }

	        document.getElementById("enggcat").innerHTML = html;
	    });
        
        
		$('#modelupdate').modal("show");
	});

}
function change_enggsubtype(category)
{
	//alert(category)

//	alrt(category)
	$('#engdiv2').show();
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
    	//alert(data)
        var html = " <select class='form-control' tabindex='7' id='enggassign' name='enggassign'>";
        html = html + '<option value="">--Please Select Engineer--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }
    //   alert(data[i])
        document.getElementById("enggassign").innerHTML = html;
    });
}


$("#update_ticket").click(function() {
	




//	 //alert("submit");
	if (!validateForm()) {
		event.preventDefault();
	} else {
		//alert($('#assignTo').val())		///////
		//////// CHECK FOR TICKET UPDATION CONFLICT ////////////
		//$("#update_ticket").attr("disabled", true);
		////alert($('#status').val())
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/"+ l.pathname.split('/')[1];
		var serviceUrl = base_url + "/EnggActivity/CheckENGConflictAfterWorInProgressServiceRequest";
		 $.ajax({
		        type: 'POST',
		        url: serviceUrl,
		        dataType: 'json',       
		        data: 'ticketid=' + encodeURIComponent($('#tid').val())
		        +'&CurrentStatus='+encodeURIComponent($('#status').val())
		        +'&priviousetpnaame='+encodeURIComponent($('#tcname').val())
		        +'&priviouseemail='+encodeURIComponent($('#tcemail').val())
		        +'&currentatassignto='+encodeURIComponent($('#assignTo').val())
		        +'&Crrentselecengg='+encodeURIComponent($('#enggassign').val())
		        +'&currentselectgrp='+encodeURIComponent($('#engGroup').val()),

		        success: function (data) {
		        	//alert("main //alert start");
		        //	!$('#status').val()=="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] == "Re-Assigned" &&
		        	////alert( "group is  ---"+!data[0]["ENGGGROUPTRUE"]);
		        	//alert( "current staus is not equal ---"+$('#status').val() !="Re-Assigned");
		        	//alert( " previouse  is  equal ---"+data[0]["ASSIGNED_TICKET_STATUS"] != "Re-Assigned");
		        	//alert($("#status").val())
//		        	//alert("PREVIOUS_ENG_NAME: "+data[0]["PREVIOUS_ENG_NAME"]);
		        	//alert("ASSIGNED_TICKET_STATUS: "+data[0]["ASSIGNED_TICKET_STATUS"]);
//		        	//alert("PREVIOUS_COMPANY: "+data[0]["PREVIOUS_COMPANY"]);
//		     //   	//alert("PREVIOUS_ENG_SOLUTION_DATE: "+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]);
		        	if(data[0]["STATUS"]==="Fail")
		        	{
		        		//alert("1");
		        		
		        		if( $('#status').val()=="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] == "Work in Progress")
		        		{
		        			//alert("2");
		        			swal({
								title : 'Previous Record Found!',
								html : '<label ><table style="font-size:13px" class="table table-bordered"><tr><td> Previously Assigned To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["ASSIGNED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Done By </td><td>'+data[0]["previouslyactivityfullname"]+'</td></tr> <tr><td> Previous Activity By </td><td>'+data[0]["previouslyactivityroletype"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr></table><table style="font-size:13px ; color:#a70202"  class="table table-bordered"><tr><td> Currently Assigning To </td><td>'+data[0]["currentassignto"]+'</td></tr><tr><td> Current Selected Engineer or Group </td><td>'+data[0]["currentengorgrpswal"]+'</td></tr><tr><td>Current Status</td><td>'+$("#status").val()+'</td></tr></table></label><label>Do you want to continue & update the ticket status?</label>',
								//type : 'warning',
								
								//width : 500,
								//height : 150,
								showCancelButton: true,
								 customClass: 'sweet//alert-sm',
								confirmButtonText: "Continue",
						        buttons: false,
						        allowOutsideClick: false,
							}).then((isConfirm) => {
						        if (isConfirm) {
						        	UpdateAssignTickets();	
						        }
						    });
		        			
		        		}
		        		else if( $('#status').val()=="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] != "Re-Assigned" && data[0]["ASSIGNED_TICKET_STATUS"] != "Work in Progress" && data[0]["ASSIGNED_TICKET_STATUS"] != "Rejected" &&  data[0]["ASSIGNED_TICKET_STATUS"] != "Resolved" && data[0]["ENGGGROUPTRUE"])
		        		{
		        			//alert("3");
		        			//action  with data

		        			swal({
								title : 'Previous Record Found!',
								html : '<label ><table style="font-size:13px" class="table table-bordered"><tr><td> Previously Assigned To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["ASSIGNED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Done By </td><td>'+data[0]["previouslyactivityfullname"]+'</td></tr> <tr><td> Previous Activity By </td><td>'+data[0]["previouslyactivityroletype"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr></table><table style="font-size:13px ; color:#a70202"  class="table table-bordered"><tr><td> Currently Assigning To </td><td>'+data[0]["currentassignto"]+'</td></tr><tr><td> Current Selected Engineer or Group </td><td>'+data[0]["currentengorgrpswal"]+'</td></tr><tr><td>Current Status</td><td>'+$("#status").val()+'</td></tr></table></label><label>Do you want to continue & update the ticket status?</label>',
								//type : 'warning',
								
								//width : 500,
								//height : 150,
								showCancelButton: true,
								 customClass: 'sweet//alert-sm',
								confirmButtonText: "Continue",
						        buttons: false,
						        allowOutsideClick: false,
							}).then((isConfirm) => {
						        if (isConfirm) {
						        	UpdateAssignTickets();	
						        }
						    });
		        			
		        		
		        			
		        		}
	               else if($('#status').val()=="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] != "Re-Assigned" && data[0]["ASSIGNED_TICKET_STATUS"] != "Work in Progress" && data[0]["ASSIGNED_TICKET_STATUS"] != "Rejected" &&  data[0]["ASSIGNED_TICKET_STATUS"] != "Resolved" && !data[0]["ENGGGROUPTRUE"]){
		        			//no action  with data
	            		//alert("4");
	        			
	        			swal({	title : 'Previous Record Found!',
							html : '<label ><table style="font-size:13px" class="table table-bordered"><tr><td> Previously Assigned To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["ASSIGNED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Done By </td><td>'+data[0]["previouslyactivityfullname"]+'</td></tr> <tr><td> Previous Activity By </td><td>'+data[0]["previouslyactivityroletype"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr></table><table style="font-size:13px ; color:#a70202"  class="table table-bordered"><tr><td> Currently Assigning To </td><td>'+data[0]["currentassignto"]+'</td></tr><tr><td> Current Selected Engineer or Group </td><td>'+data[0]["currentengorgrpswal"]+'</td></tr><tr><td>Current Status</td><td>'+$("#status").val()+'</td></tr></table></label><label>No Action Needed</label>',		
							//showCancelButton: true,
						 customClass: 'sweet//alert-sm',
						confirmButtonText: "OK",
				        buttons: false,
				        allowOutsideClick: false,
				        preConfirm : function() {
							location.reload();
						}
						
					    });
	        			
	        		
	        			
	        		
		        		}
	               else if($('#status').val()=="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] != "Re-Assigned" && data[0]["ASSIGNED_TICKET_STATUS"] != "Work in Progress" && (data[0]["ASSIGNED_TICKET_STATUS"] == "Rejected" ||  data[0]["ASSIGNED_TICKET_STATUS"] == "Resolved") ){
	        			//no action  with data
	            		//alert("5");
	        			swal({	title : 'Previous Record Found!',
							html : '<label ><table style="font-size:13px" class="table table-bordered"><tr><td> Previously Assigned To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["ASSIGNED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Done By </td><td>'+data[0]["previouslyactivityfullname"]+'</td></tr> <tr><td> Previous Activity By </td><td>'+data[0]["previouslyactivityroletype"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr></table><table style="font-size:13px ; color:#a70202"  class="table table-bordered"><tr><td> Currently Assigning To </td><td>'+data[0]["currentassignto"]+'</td></tr><tr><td> Current Selected Engineer or Group </td><td>'+data[0]["currentengorgrpswal"]+'</td></tr><tr><td>Current Status</td><td>'+$("#status").val()+'</td></tr></table></label><label>No Action Needed</label>',		
							//showCancelButton: true,
						 customClass: 'sweet//alert-sm',
						confirmButtonText: "ok",
				        buttons: false,
				        allowOutsideClick: false,
				        preConfirm : function() {
							location.reload();
						}
						
					    });
	        			
	        		
	        			
	        		}
		        		else if( $('#status').val()=="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] == "Re-Assigned" && data[0]["ENGGGROUPTRUE"] )
		        			{
		        			//alert("6");
		        			//action with data
		        			swal({
								title : 'Previous Record Found!',
								html : '<label ><table style="font-size:13px" class="table table-bordered"><tr><td> Previously Assigned To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["ASSIGNED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Done By </td><td>'+data[0]["previouslyactivityfullname"]+'</td></tr> <tr><td> Previous Activity By </td><td>'+data[0]["previouslyactivityroletype"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr></table><table style="font-size:13px ; color:#a70202"  class="table table-bordered"><tr><td> Currently Assigning To </td><td>'+data[0]["currentassignto"]+'</td></tr><tr><td> Current Selected Engineer or Group </td><td>'+data[0]["currentengorgrpswal"]+'</td></tr><tr><td>Current Status</td><td>'+$("#status").val()+'</td></tr></table></label><label>Do you want to continue & update the ticket status?</label>',
								//type : 'warning',
								
								//width : 500,
								//height : 150,
								showCancelButton: true,
								 customClass: 'sweet//alert-sm',
								confirmButtonText: "Continue",
						        buttons: false,
						        allowOutsideClick: false,
							}).then((isConfirm) => {
						        if (isConfirm) {
						        	UpdateAssignTickets();	
						        }
						    });
		        			
		        			
		        			}
		        		else if ( $('#status').val()=="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] == "Re-Assigned" && !data[0]["ENGGGROUPTRUE"] ){
		        			// no action with data
		        			//alert("7");

		        			swal({	title : 'Previous Record Found!',
								html : '<label ><table style="font-size:13px" class="table table-bordered"><tr><td> Previously Assigned To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["ASSIGNED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Done By </td><td>'+data[0]["previouslyactivityfullname"]+'</td></tr> <tr><td> Previous Activity By </td><td>'+data[0]["previouslyactivityroletype"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr></table><table style="font-size:13px ; color:#a70202"  class="table table-bordered"><tr><td> Currently Assigning To </td><td>'+data[0]["currentassignto"]+'</td></tr><tr><td> Current Selected Engineer or Group </td><td>'+data[0]["currentengorgrpswal"]+'</td></tr><tr><td>Current Status</td><td>'+$("#status").val()+'</td></tr></table></label><label>No Action Needed</label>',		
								//showCancelButton: true,
							 customClass: 'sweet//alert-sm',
							confirmButtonText: "ok",
					        buttons: false,
					        allowOutsideClick: false,
					        preConfirm : function() {
								location.reload();
							}
							
						    });
		        			
		        		}
		        		else if( $('#status').val()!="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] == "Work in Progress"  )
		        			{
		        			//alert("8");
		        		//	 action with no data
		        			swal({
		        				

								title : 'Previous Record Found!',
					html : '<label ><table style="font-size:13px" class="table table-bordered"><tr><td> Previously Assigned To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["ASSIGNED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Done By </td><td>'+data[0]["previouslyactivityfullname"]+'</td></tr> <tr><td> Previous Activity By </td><td>'+data[0]["previouslyactivityroletype"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr></table><table style="font-size:13px ; color:#a70202"  class="table table-bordered"><tr><td>Current Status</td><td>'+$("#status").val()+'</td></tr></table></label><label>Do you want to continue & update the ticket status?</label>',	
					
					showCancelButton: true,
					 customClass: 'sweet//alert-sm',
					confirmButtonText: "Continue",
			        buttons: false,
			        allowOutsideClick: false,
				}).then((isConfirm) => {
			        if (isConfirm) {
			        	UpdateAssignTickets();	
			        }
		        			});
		        			
		        			}
		        		else if( $('#status').val()!="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] != "Re-Assigned" && data[0]["ASSIGNED_TICKET_STATUS"] != "Work in Progress"  )
	        			{
		        			//alert("9");
	        			//no action with no data
		        			

			        						swal({
			        				title : 'Previous Record Found!',
			        								html : '<label ><table style="font-size:13px" class="table table-bordered"><tr><td> Previously Assigned To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["ASSIGNED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Done By </td><td>'+data[0]["previouslyactivityfullname"]+'</td></tr> <tr><td> Previous Activity By </td><td>'+data[0]["previouslyactivityroletype"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr></table><table style="font-size:13px ; color:#a70202"  class="table table-bordered"><tr><td>Current Status</td><td>'+$("#status").val()+'</td></tr></table></label><label>No Action Needed</label>',		
			        								//	showCancelButton: true,
			        								 customClass: 'sweet//alert-sm',
			        								confirmButtonText: "ok",
			        						        buttons: false,
			        						        allowOutsideClick: false,
			        						        preConfirm : function() {
			        									location.reload();
			        								}
			        			});
			        			
			        			
	        			}
		        		
		        		else if($('#status').val()!="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] == "Re-Assigned" && data[0]["ENGGGROUPTRUE"] )
	        			{
		        			//alert("10");
	        			//no action with no data
							swal({
		        				title : 'Previous Record Found!',
		        								html : '<label ><table style="font-size:13px" class="table table-bordered"><tr><td> Previously Assigned To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["ASSIGNED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Done By </td><td>'+data[0]["previouslyactivityfullname"]+'</td></tr> <tr><td> Previous Activity By </td><td>'+data[0]["previouslyactivityroletype"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr></table><table style="font-size:13px ; color:#a70202"  class="table table-bordered"><tr><td>Current Status</td><td>'+$("#status").val()+'</td></tr></table></label><label>No Action Needed</label>',		
		        								//	showCancelButton: true,
		        								 customClass: 'sweet//alert-sm',
		        								confirmButtonText: "ok",
		        						        buttons: false,
		        						        allowOutsideClick: false,
		        						        preConfirm : function() {
		        									location.reload();
		        								}
		        			});
		        			
		        			
	        			}
		        		else if( $('#status').val()!="Re-Assigned"  && data[0]["ASSIGNED_TICKET_STATUS"] == "Re-Assigned" && !data[0]["ENGGGROUPTRUE"] )
	        			{
		        			//alert("11");
	        			
		        			//no action with no data
							swal({
		        				title : 'Previous Record Found!',
		        								html : '<label ><table style="font-size:13px" class="table table-bordered"><tr><td> Previously Assigned To </td><td>'+data[0]["previouseassignto"]+'</td></tr><tr><td> Previous Engineer or Group </td><td>'+data[0]["PRIVIGROUP"]+'</td></tr><tr><td>Previous Status</td><td>'+data[0]["ASSIGNED_TICKET_STATUS"]+'</td></tr><tr><td>Previous Activity Done By </td><td>'+data[0]["previouslyactivityfullname"]+'</td></tr> <tr><td> Previous Activity By </td><td>'+data[0]["previouslyactivityroletype"]+'</td></tr><tr><td>Previous Activity Time</td><td>'+data[0]["PREVIOUS_ENG_SOLUTION_DATE"]+'</td></tr></table><table style="font-size:13px ; color:#a70202"  class="table table-bordered"><tr><td>Current Status</td><td>'+$("#status").val()+'</td></tr></table></label><label>No Action Needed</label>',		
		        								//	showCancelButton: true,
		        								 customClass: 'sweet//alert-sm',
		        								confirmButtonText: "ok",
		        						        buttons: false,
		        						        allowOutsideClick: false,
		        						        preConfirm : function() {
		        									location.reload();
		        								}
		        			});
		        			
	        			}
		        	}
		        
		        	 if(data[0]["STATUS"]==="Pass")
		        	{
		        			//alert("12");
		        	
		        		 UpdateAssignTickets();
		        	}
		        }
		
		 });
		
	}
});

function UpdateAssignTickets(){
//////////////UpdateAssignTickets ///////////////////
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/UpdateAssignRequestsFromWIP";
	
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
				//	alert(data)
				const SplitStatus=data.split("~");
					var statusOutside=SplitStatus[0];
					var status=SplitStatus[1];
					//alert(status)
					//alert(SplitStatus)
					
		if (statusOutside == "success") {

			if (($('#status').val()) == status) {
				swal({
					title : 'Successful!',
					html : 'Request Status  Change To '+status+' Successfully',
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
//			else if(){
//				swal({
//					title : 'Successful!',
//					html : 'Request Resolved Successfully',
//					type : 'success',
//					width : 300,	
//			         buttons: false,
//			         allowOutsideClick: false,
//					preConfirm : function() {
//						location.reload();
//					}
//				});
//			}
//
		} 
		else {
			swal({
				title : 'Unsuccessful!',
				html : 'Failed to Change Request Status',
				type : 'error',
				width : 300,

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
		console.log('inside status');
		callToolTip231('status', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}
	if ($('#solution').val() === '') {
		console.log('inside solution');
		callToolTip231('solution', 'show');

		if (indexError == 0) {

		}
		indexError = indexError + 1;
	}

	console.log("validation error count::::" + indexError);
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

var callToolTip231 = function(fieldName, status) {
	if (fieldName == "status") {
		var errorMessage = "<span>Please Select Status of Ticket<span>";
	} else if (fieldName == "solution") {
		var errorMessage = "<span>Please Enter Solution for Resolved<span>";
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
$('#modelupdate').on('hidden.bs.modal', function () {
	$("#status").val("");
	$("#solution").val("");
	
})
function ToggleHoldReason(value){
//  alert(value)
    	change_Assigntype("");
    	$("#assignTo").val("");
    	// $('#AssignID').hide();
    	 //$('#engdiv2').hide();
    	// $('#enggDiv').hide();
//    	 callToolTip231('assignTo', 'hide');
//         callToolTip231('enggcat', 'hide');
//         callToolTip231('enggassign', 'hide');
    	
    	
    	 if(value==="Re-Assigned"){
    		// alert("value    " +value);
    		 $('#engdetails').show();
    	 
    	}else{
    		
    		$('#engdetails').hide();
    		
    	}
    /*	
     if(value==="Assigned"){
    	 
    	 $('#AssignID').show();
        $('#TPHoldNotes').hide();
           $('#holdnotes').val("");
    }*/
    }

function change_Assigntype(assignType){
   	//alert(assignType)
    	
    	document.getElementById("Hideotherdata").style.display = "none";
    	$('#enggcat').val("");
    	$('#enggassign').val("");
    	$('#engGroup').val("");
//    	callToolTip231('enggcat', 'destroy');
//    	callToolTip231('enggassign', 'destroy');
//    	callToolTip231('engGroup', 'destroy');
    	
    	if(assignType==="Engineer"){
    		$('#enggDiv').show();
    		$('#groupDiv').hide();
    	}
    	else if(assignType==="Group"){
    		
    		//alert($("#companyupdateTP").val());

    		var l = window.location;
    		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    		var serviceUrl = base_url + "/Master/getGropupfromgroupmaster";

    		$.ajax({

    		    url: serviceUrl,
    		    type: 'POST',
    		    dataType: 'json',    		  
    		    async :false,
    		    data:'company='+encodeURIComponent($("#usercompany").val()),
    		}).done(function (data) {

    		    var html = " <select class='form-control' tabindex='7' id='engGroup' name='engGroup'>";
    		    html = html + '<option value="">--Please Select Group--</option>';
    		    for (var i = 0; i < data.length; i++) {
    		        html += '<option value="' + data[i] + '">' + data[i]
    		                + '</option>';
    		    }

    		    document.getElementById("engGroup").innerHTML = html;
    		});


    		
    		$('#groupDiv').show();
    		$('#enggDiv').hide();
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
	//console.log(words[0]);
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


