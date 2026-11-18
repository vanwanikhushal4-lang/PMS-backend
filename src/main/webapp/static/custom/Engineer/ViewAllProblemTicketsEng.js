window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/getAllProblemTicketListEng";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',

		success : function(data5) {
//alert(data5)
			$("#preLoader").hide();
        	$("#Listing_Copy").removeClass("d-none");
			var table = $('#Listing_Copy').DataTable({
				lengthChange : false,
				pageLength : 5,
				data : data5,
				destroy : true,
				"scrollX" : true,
				columnDefs: [{
					targets: [3,4,5,11,12,13,14,15,16],
					orderable: false
					}],

				initComplete: function () {
					this.api().columns([3,4,5,11,12,13,14,15,16]).every(function () {
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
		}
	});
}



function downFile() {
	var filename = $('#filename').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}
function downFileSecondary() {
	var filename = $('#filenamesecondary').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}

function downFileActivityLog(att) {
//	alert(att)
//		var filename = $('#filename').val();
		var filename =att;
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location = base_url + "/Master/DownloadFile?filename=" + filename;
	}

function ViewProblemTicket(id) {
	//alert(id)
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/EnggActivity/gatherProblemTicketDetails";

		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			data : 'ticketid=' + id,
			// + '&cno=' + $("#cno").val(),

			success : function(data) {
//				alert(data[0]["ENGINEER_ASSIGN_DATE"]);

	//////////////COMMON PARAMETERS/////////
				var PT_REQUESTER = data[0]["PT_REQUESTER"];
				var PT_COMPANY = data[0]["PT_COMPANY"];
				var PT_BRANCH = data[0]["PT_BRANCH"];
				var PT_PHONE = data[0]["PT_PHONE"];
				var PT_MAIL = data[0]["PT_MAIL"];
				var PT_DEPARTMENT = data[0]["PT_DEPARTMENT"];
				var T_PROBLEM_CATEGORY = data[0]["T_PROBLEM_CATEGORY"];
				var T_PROBLEM_SUBCAT1 = data[0]["T_PROBLEM_SUBCAT1"];
				var T_PROBLEM_SUBCAT2 = data[0]["T_PROBLEM_SUBCAT2"];
				var PT_SUBJECT = data[0]["PT_SUBJECT"];
				var PT_DESC = data[0]["PT_DESC"];
				var PT_DATE = data[0]["PT_DATE"];
				var PROBLEM_STATUS = data[0]["PROBLEM_STATUS"];
				var PT_ID = data[0]["PT_ID"];
				var PRIORITY = data[0]["PRIORITY"];
				var SEVERITY = data[0]["SEVERITY"];
				var REQUEST_MODE = data[0]["REQUEST_MODE"];
				var PT_ATTACH_NAME = data[0]["PT_ATTACH_NAME"];
				var PT_DATE = data[0]["PT_DATE"];
				var ENGINEER_ASSIGN_DATE = data[0]["ENGINEER_ASSIGN_DATE"];
				var ENGINEER_RCA_DATE = data[0]["ENGINEER_RCA_DATE"];
				var ENGINEER_FIXINPROCESS_DATE = data[0]["ENGINEER_FIXINPROCESS_DATE"];
				var ENGINEER_RESOLVED_DATE = data[0]["ENGINEER_RESOLVED_DATE"];
				var RESOLUTION_CODE = data[0]["RESOLUTION_CODE"];
				var TICKET_CLOSE_DATE = data[0]["TICKET_CLOSE_DATE"];
				var TICKET_CLOSEBY = data[0]["TICKET_CLOSEBY"];
				
				var Sub_Dept=data[0]["Sub_Dept"];
				var Location=data[0]["Location"];
				$("#Sub-Department").val(Sub_Dept);
				$("#location").val(Location);
				
				/////////////// TICKET NOTES//////////
				var CAUSE_NOTES = data[0]["CAUSE_NOTES"];
				var FIX_NOTES = data[0]["FIX_NOTES"];
				var WORKAROUND_NOTES = data[0]["WORKAROUND"];
				var RESOLVE_NOTES = data[0]["RESOLVE_NOTES"];
				var TICKET_CLOSE_NOTES = data[0]["TICKET_CLOSE_NOTES"];
				/////////////////////////////////////
				
					

				$("#nameupdateUD").val(PT_REQUESTER);
				$("#companyupdateUD").val(PT_COMPANY);
				$("#siteupdateUD").val(PT_BRANCH);
				$("#phoneupdateUD").val(PT_PHONE);
				$("#emailupdateUD").val(PT_MAIL);
				$("#departmentupdateUD").val(PT_DEPARTMENT);
				$("#problemcategoryupdateTD").val(T_PROBLEM_CATEGORY);
				$("#problemsubcat1").val(T_PROBLEM_SUBCAT1);
				$("#problemsubcat2").val(T_PROBLEM_SUBCAT2);
				$("#subjectupdateTD").val(PT_SUBJECT);
				$("#descriptionupdateTD").val(PT_DESC);
				$("#raisedateupdateTD").val(PT_DATE);
				$("#statusupdateTD").val(PROBLEM_STATUS);
				$("#problemticketidupdateTD").val(PT_ID);
				$("#priorityupdateTD").val(PRIORITY);
				$("#SeverityupdateTD").val(SEVERITY);
				$("#RequestModeupdateTD").val(REQUEST_MODE);
				$("#assigndateupdateTD").val(ENGINEER_ASSIGN_DATE);
				$("#rcadateupdateTD").val(ENGINEER_RCA_DATE);
				$("#fixinprocessdateupdateTD").val(ENGINEER_FIXINPROCESS_DATE);
				$("#resolvedateupdateTD").val(ENGINEER_RESOLVED_DATE);
				$("#resolutioncodeupdateTD").val(RESOLUTION_CODE);
				$("#closedateupdateTD").val(TICKET_CLOSE_DATE);
				$("#closebyupdateTD").val(TICKET_CLOSEBY);
				
				/////////////// TICKET NOTES//////////
				$("#causenotesRCA").val(CAUSE_NOTES);
				$("#fixnotesRCA").val(FIX_NOTES);
				$("#workaroundnotesRCA").val(WORKAROUND_NOTES);
				$("#resolvenotesRCA").val(RESOLVE_NOTES);
				$("#closenotesRCA").val(TICKET_CLOSE_NOTES);
				/////////////////////////////////////

				if ((PT_ATTACH_NAME === ("No File Available"))
						|| (PT_ATTACH_NAME === ("NA"))
						|| (PT_ATTACH_NAME === ("null"))
						|| (PT_ATTACH_NAME === ("undefined"))
						|| (PT_ATTACH_NAME === (""))) {
					$('#hidedownload').hide();
					$('#nofileattach').show();
				} else {
					$('#hidedownload').show();
					$('#nofileattach').hide();
					document.getElementById('empPic').innerHTML = PT_ATTACH_NAME;
					document.getElementById('filename').value = PT_ATTACH_NAME;
				}
				
	///////////// FOR INCIDENTS /////////
				var INCIDENTS_ATTACHED=data[0]["INCIDENTS_ATTACHED"];
//				alert(INCIDENTS_ATTACHED)
				if(INCIDENTS_ATTACHED.length>0)
					{
					$('#IncidentsAttachedDiv').show();
					$('#NoIncidentsAttachedDiv').hide();
					for(var i=0;i<INCIDENTS_ATTACHED.length;i++)
						{
						$('#Listing_Copy_Incidents').DataTable().clear();
						var table = $('#Listing_Copy_Incidents').DataTable({
//					    	dom:"<'row'<'col-sm-3'B><'col-sm-9'f>>rtip", 
					    	lengthChange: false,
					        pageLength: 5,
					        destroy: true,
					        scrollX: true,
						});
						$('#Listing_Copy_Incidents').DataTable().rows.add(INCIDENTS_ATTACHED).draw();
		
						}
					}else{
						$('#IncidentsAttachedDiv').hide();
						$('#NoIncidentsAttachedDiv').show();
					}
	/////////////////////////////////////

			}
		});
		$("#modelviewPrimary").modal("show");

	}
	$('#modelviewPrimary').on('hidden.bs.modal', function () {
		$('a[role="tab"]').removeClass('active'); 
	    $('a[role="tabpanel"]').removeClass('active show');
	    $('#custom-tabs-four-notes-tab').removeClass('active');
	    $('#custom-tabs-four-home-tab').addClass('active');
	    
	    $('#custom-tabs-four-home').removeClass('active show');
	    $('#custom-tabs-four-notes').removeClass('active show');
	    $('#custom-tabs-four-profile').removeClass('active show');
	    $('#custom-tabs-four-home').addClass('active show');
	});
	$('#close-btn-primary').click(function() {

		$('#modelviewPrimary').modal("hide");
		$('a[role="tab"]').removeClass('active'); 
	    $('a[role="tabpanel"]').removeClass('active show');
	    $('#custom-tabs-four-notes-tab').removeClass('active');
	    $('#custom-tabs-four-home-tab').addClass('active');
	    
	    $('#custom-tabs-four-home').removeClass('active show');
	    $('#custom-tabs-four-notes').removeClass('active show');
	    $('#custom-tabs-four-profile').removeClass('active show');
	    $('#custom-tabs-four-home').addClass('active show');
	})

	//////////////////// GET ACTIVITY LOG ////////////////
	$('a[role="tab"]').on('shown.bs.tab', function (e) {
		  var target = $(e.target).attr("id") // activated tab
		  if(target==="custom-tabs-four-profile-tab"){
			  ticketid= $("#problemticketidupdateTD").val();
			  
			  var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/TPActivity/getProblemTicketActivityLog";
	    
	    $.ajax({
	        url: serviceUrl,
	        type: 'post',
	       dataType: 'json',
	        data: 'ticketid=' + ticketid,

	        success: function(data) {
//	        	alert(data[0]["TIMESTAMP"]);
	            var T_ID = data[0]["T_ID"];
//	            var TIMESTAMP = data[0]["TIMESTAMP"];
//	            var CHANGEBY = data[0]["CHANGEBY"];
//	            var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
//	            var STATUS = data[0]["STATUS"];
//	            var PRIORITY = data[0]["PRIORITY"];
//	            var CHANGE_NOTES1 = data[0]["CHANGE_NOTES1"];
//	            var CHANGE_NOTES2 = data[0]["CHANGE_NOTES2"];
//	            var ROLE_TYPE = data[0]["ROLE_TYPE"];

	           document.getElementById('T_ID').innerHTML=T_ID;
	          
	           
	           var attachment="";
	           var att;
	           var statusColor;
	           var notes;
	           var RCANotes;
	           var FIXNotes;
	           var WorkaroundNotes;
	           var ResolveNotes;
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
//	        	   alert(statusColor);
	        	   var callOutColor="";
	        	   if(statusColor=="Assigned" ||statusColor=="Fix In Process"||statusColor=="Root Cause Analysis"){callOutColor="callout-warning"}
	         	  
	        	   else if(statusColor=="Closed" ||statusColor=="Resolved"){callOutColor="callout-success"}
	        	  
	        	   /////////////// CODE FOR CHANGE NOTES ///////////////
	        	   if(data[i]["CHANGE_NOTES"]==undefined || data[i]["CHANGE_NOTES"]=="" || data[i]["CHANGE_NOTES"]==" " || data[i]["CHANGE_NOTES"]==null)
	        		 {
	        		   notes="";
	        		 }
	        	 else{
	        		 notes="<label>Notes</label><textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["CHANGE_NOTES"]+"</textarea>";
	        	 }
	        	   /////////////// CODE FOR RCA NOTES ///////////////
	        	   if(data[i]["RCA_NOTES"]==undefined || data[i]["RCA_NOTES"]=="" || data[i]["RCA_NOTES"]==" " || data[i]["RCA_NOTES"]==null)
	      		 {
	        		RCANotes="";
	      		 }
	        	   else{
	      		 RCANotes="<label>RCA Notes</label><textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["RCA_NOTES"]+"</textarea>";
	        	   }
	        	   /////////////// CODE FOR FIX NOTES ///////////////
	        	   if(data[i]["FIX_NOTES"]==undefined || data[i]["FIX_NOTES"]=="" || data[i]["FIX_NOTES"]==" " || data[i]["FIX_NOTES"]==null)
	        		 {
	          		FIXNotes="";
	        		 }
	        	 else{
	        		 FIXNotes="<label>FIX Notes</label><textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["FIX_NOTES"]+"</textarea>";
	        	 }
	        	   /////////////// CODE FOR WORKAROUND NOTES ///////////////
	        	   if(data[i]["WORKAROUND_NOTES"]==undefined || data[i]["WORKAROUND_NOTES"]=="" || data[i]["WORKAROUND_NOTES"]==" " || data[i]["WORKAROUND_NOTES"]==null)
	        		 {
	          		WorkaroundNotes="";
	        		 }
	        	 else{
	        		 WorkaroundNotes="<label>Workaround Notes</label><textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["WORKAROUND_NOTES"]+"</textarea>";
	        	 }
	        	   /////////////// CODE FOR RESOLVE NOTES ///////////////
	        	   if(data[i]["RESOLVE_NOTES"]==undefined || data[i]["RESOLVE_NOTES"]=="" || data[i]["RESOLVE_NOTES"]==" " || data[i]["RESOLVE_NOTES"]==null)
	        		 {
	          		ResolveNotes="";
	        		 }
	        	 else{
	        		 ResolveNotes="<label>Resolve Notes</label><textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["RESOLVE_NOTES"]+"</textarea>";
	        	 }
	        	   
	        	   ////////////////CODE TO APPEND////////////
	        	   html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Role Type : <span>"+data[i]["ROLE_TYPE"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Priority : <span>"+data[i]["PRIORITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Severity : <span>"+data[i]["SEVERITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Category : <span>"+data[i]["CATEGORY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category1 : <span>"+data[i]["SUBCATEGORY1"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Sub-Category2 : <span>"+data[i]["SUBCATEGORY2"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-8'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Full Name : <span>"+data[i]["FULLNAME"]+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Email : <span>"+data[i]["EMAIL"]+"</span></span></div></div><div class='row'><div class='col-md-12'>"+notes+"</div></div><div class='row'><div class='col-md-12'>"+RCANotes+"</div></div><div class='row'><div class='col-md-12'>"+FIXNotes+"</div></div><div class='row'><div class='col-md-12'>"+WorkaroundNotes+"</div></div><div class='row'><div class='col-md-12'>"+ResolveNotes+"</div></div></div>";
	        	   
	              document.getElementById("MSG1234").innerHTML=html;
	        	   }
	           html=+ '<br>';
	            }
	          
	            
	    });
		  }
		});


	function viewTicket(id)
	{
		event.preventDefault();
//		alert(id)

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl1 = base_url + "/UserActivity/gatherUserTicketDetails";
	        
	           $.ajax({
	        type: 'POST',
	        url: serviceUrl1,
	        dataType: 'json',
	        data: 'ticketid=' + id,
//	                + '&cno=' + $("#cno").val(),

	        success: function (data) {
//	           alert(data[0]["REQUEST_MODE"])
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
//	           alert("T_ATTACH1_NAME: "+T_ATTACH_NAME);

	             $("#nameupdateUDsecondary").val(T_REQUESTER);
	             $("#companyupdateUDsecondary").val(T_COMPANY);
	             $("#siteupdateUDsecondary").val(T_BRANCH);
	             $("#deptupdateUDsecondary").val(DEPARTMENT);
	             $("#subdeptupdateUDsecondary").val(SUB_DEPARTMENT);
	             $("#locationupdateUDsecondary").val(LOCATION);
	             $("#phoneupdateUDsecondary").val(T_PHONE);
	             $("#emailupdateUDsecondary").val(T_MAIL);
	             $("#categoryupdateTDsecondary").val(T_CATEGORY);
	             $("#subcat1updateTDsecondary").val(T_SUBCAT1);
	             $("#subcat2updateTDsecondary").val(T_SUBCAT2);
	             $("#subjectupdateTDsecondary").val(T_SUBJECT);
	             $("#raisedateupdateTDsecondary").val(T_DATE);
	             $("#statusupdateTDsecondary").val(STATUS);
	             $("#ticketidupdateTDsecondary").val(T_ID);
	             $("#descriptionupdateTDsecondary").val(T_DESC);
	             $("#priorityupdateTDsecondary").val(PRIORITY);
	             $("#SeverityupdateTDsecondary").val(SEVERITY);
	             $("#RequestModeupdateTDsecondary").val(REQUEST_MODE);
	             
	 if((T_ATTACH_NAME=== ("No File Available"))||(T_ATTACH_NAME===("NA"))||(T_ATTACH_NAME===("null"))||(T_ATTACH_NAME===("undefined"))||(T_ATTACH_NAME===("")))
	        {
	           $('#hidedownloadsecondary').hide();
	           $('#nofileattachsecondary').show();
	        }else
	        {
	            $('#hidedownloadsecondary').show();
	              $('#nofileattachsecondary').hide();
	          document.getElementById('empPicsecondary').innerHTML=T_ATTACH_NAME;  
	          document.getElementById('filenamesecondary').value=T_ATTACH_NAME;  
	        }
	       
	         }
	     });
	             $("#modelviewSecondary").modal("show");
	}
	$('#modelviewSecondary').on('hidden.bs.modal', function () {
		$('a[role="tab-two"]').removeClass('active'); 
	    $('a[role="tabpanel-two"]').removeClass('active show');
	    $('#custom-tabs-two-activity-tab').removeClass('active');
	    $('#custom-tabs-two-general-tab').addClass('active');
	    
	    $('#custom-tabs-two-general').removeClass('active show');
	    $('#custom-tabs-two-activity').removeClass('active show');
	    $('#custom-tabs-two-general').addClass('active show');
	});

	$('#close-btn-secondary').click(function() {

		$('#modelviewSecondary').modal("hide");
		$('a[role="tab-two"]').removeClass('active'); 
	    $('a[role="tabpanel-two"]').removeClass('active show');
	    $('#custom-tabs-two-activity-tab').removeClass('active');
	    $('#custom-tabs-two-general-tab').addClass('active');
	    
	    $('#custom-tabs-two-general').removeClass('active show');
	    $('#custom-tabs-two-activity').removeClass('active show');
	    $('#custom-tabs-two-general').addClass('active show');
	})

	//////////////////// GET ACTIVITY LOG ////////////////
	$('a[role="tab-two"]').on('shown.bs.tab', function (e) {
		  var target = $(e.target).attr("id") // activated tab
		  if(target==="custom-tabs-two-activity-tab"){
			  ticketid= $("#ticketidupdateTDsecondary").val();
			  var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/UserActivity/getTicketActivityLog";
	    
	    $.ajax({
	        url: serviceUrl,
	        type: 'post',
	       dataType: 'json',
	        data: 'ticketid=' + ticketid,

	        success: function(data) {
//	        	alert(data[0]["CHANGE_NOTES2"]);
	            var T_ID = data[0]["T_ID"];
	            var TIMESTAMP = data[0]["TIMESTAMP"];
	            var CHANGEBY = data[0]["CHANGEBY"];
	            var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
	            var STATUS = data[0]["STATUS"];
	            var PRIORITY = data[0]["PRIORITY"];
	            var CHANGE_NOTES1 = data[0]["CHANGE_NOTES1"];
	            var CHANGE_NOTES2 = data[0]["CHANGE_NOTES2"];
	            var ROLE_TYPE = data[0]["ROLE_TYPE"];
	            var SEVERITY = data[0]["SEVERITY"];
	            var CATEGORY=data[0]["CATEGORY"];
	            var SUB_CATEGORY1=data[0]["SUB_CATEGORY1"];
	            var SUBCATEGORY2=data[0]["SUBCATEGORY2"];
	            var EMAIL=data[0]["FULLNAME"];
	             var FULLNAME=data[0]["EMAIL"];

	           document.getElementById('T_IDsecondary').innerHTML=T_ID;
	          
	           
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
//	        	   alert(statusColor);
	        	   var callOutColor="";
	        	   if(statusColor=="New"){callOutColor="callout-info"}
	           	   else if(statusColor=="Assigned" ||statusColor=="Re-Assigned"||statusColor=="Pending"){callOutColor="callout-warning"}
	           	   else if( statusColor=="Reopened"){callOutColor="callout-danger"}
	           	  
	           	   else if(statusColor=="Hold"){callOutColor="callout-danger"}
	           	   else if(statusColor=="Resolved"||statusColor=="Update Approved"){callOutColor="callout-success"}
	           	   else if(statusColor=="Closed"){callOutColor="callout-success"}
	           	   else if(statusColor=="Rejected"){callOutColor="callout-danger"}
	           	   else if(statusColor=="Update Rejected"){callOutColor="callout-danger"}
	            	   
	        	    
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
	        	   
	              document.getElementById("MSG1234secondary").innerHTML=html;
	        	   }
	           html=+ '<br>';
	            }
	          
	            
	    });
		  }
		});

	 $('#modelviewPrimary').on('shown.bs.modal ', function (e) {
         $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
});