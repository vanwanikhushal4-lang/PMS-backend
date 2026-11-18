window.onload = function() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/EnggActivity/getResolveRequest2";
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data5) {

			var table = $('#Listing_Copy').DataTable({
				lengthChange : false,
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

 
function ViewTicket(id)
{
	
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/EnggActivity/gatherEngTicketDetails";
        
           $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ticketid=' + id,
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


/*function ViewTicket(id) {
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/UserActivity/gatherUserTicketDetails";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : 'ticketid=' + id,
		// + '&cno=' + $("#cno").val(),

		success : function(data) {
			

			var T_REQUESTER = data[0]["T_REQUESTER"];
			var T_COMPANY = data[0]["T_COMPANY"];
			var T_BRANCH = data[0]["T_BRANCH"];
			var T_PHONE = data[0]["T_PHONE"];
			var T_MAIL = data[0]["T_MAIL"];
			var T_CATEGORY = data[0]["T_CATEGORY"];
			var T_SUBCAT = data[0]["T_SUBCAT"];
			var T_SUBJECT = data[0]["T_SUBJECT"];
			var T_DATE = data[0]["T_DATE"];
			var STATUS = data[0]["STATUS"];
			var T_ID = data[0]["T_ID"];
			var T_DESC = data[0]["T_DESC"];
			var PRIORITY = data[0]["PRIORITY"];
			var REQUEST_MODE = data[0]["REQUEST_MODE"];
			var T_RAISE_TIME = data[0]["T_RAISE_TIME"];
			var T_ATTACH1_NAME = data[0]["T_ATTACH1_NAME"];

			var A_ENGINEER_NAME = data[0]["A_ENGINEER_NAME"];
			var T_STATUS = data[0]["T_STATUS"];
			var SOLUTION = data[0]["SOLUTION"];
			var RESOLVED_DATE = data[0]["RESOLVED_DATE"];

			$("#nameupdateUD").val(T_REQUESTER);
			$("#companyupdateUD").val(T_COMPANY);
			$("#siteupdateUD").val(T_BRANCH);
			$("#phoneupdateUD").val(T_PHONE);
			$("#emailupdateUD").val(T_MAIL);
			$("#categoryupdateTD").val(T_CATEGORY);
			$("#groupupdateTD").val(T_SUBCAT);
			$("#subjectupdateTD").val(T_SUBJECT);
			$("#raisedateupdateTD").val(T_DATE);
			$("#statusupdateTD").val(STATUS);
			$("#ticketidupdateTD").val(T_ID);
			$("#descriptionupdateTD").val(T_DESC);
			$("#priorityupdateTD").val(PRIORITY);
			$("#RequestModeupdateTD").val(REQUEST_MODE);

			$("#engnameED").val(A_ENGINEER_NAME);
			$("#engticketstatusED").val(T_STATUS);
			$("#engnotesED").val(SOLUTION);
			$("#statusdateENG").val(RESOLVED_DATE);

			if ((T_ATTACH1_NAME === ("No File Available"))
					|| (T_ATTACH1_NAME === ("NA"))
					|| (T_ATTACH1_NAME === ("null"))
					|| (T_ATTACH1_NAME === ("undefined"))
					|| (T_ATTACH1_NAME === (""))) {
				$('#hidedownload').hide();
				$('#nofileattach').show();
			} else {
				$('#hidedownload').show();
				$('#nofileattach').hide();
				document.getElementById('empPic').innerHTML = T_ATTACH1_NAME;
				document.getElementById('filename').value = T_ATTACH1_NAME;
			}
		}
	});
	$("#modelview").modal("show");
}*/



function downFile() {
	var filename = $('#filename').val();
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location = base_url + "/Master/DownloadFile?filename=" + filename;
}


$('#modelview').on('hidden.bs.modal', function () {
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
        data: 'ticketid=' + ticketid,

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
        	   else if(statusColor=="Assigned" || statusColor=="Re-Assigned" || statusColor=="Reopen"){callOutColor="callout-warning"}
        	   else if(statusColor=="Hold"){callOutColor="callout-danger"}
        	   else if(statusColor=="Resolved"){callOutColor="callout-success"}
        	   else if(statusColor=="Closed"){callOutColor="callout-success"}
        	   
        	   /////////////// CODE FOR NOTES ///////////////
        	   if(data[i]["CHANGE_NOTES1"]==undefined || data[i]["CHANGE_NOTES1"]=="" || data[i]["CHANGE_NOTES1"]==" " || data[i]["CHANGE_NOTES1"]==null)
        		 {
        		   notes1="";
        		 }
        	 else{
        		 notes1="<textarea rows='4' cols='50' class='form-control' data-toogle='tooltip' readonly='Yes'>"+data[i]["CHANGE_NOTES1"]+"</textarea>";
        	 }
        	   
        	   ////////////////CODE TO APPEND////////////
        	   html += "<div class='callout "+callOutColor+"' style='font-family:Calibri;font-size:14px;font-weight:bold'><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Timestamp : <span>"+data[i]["TIMESTAMP"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Changed By : <span>"+data[i]["CHANGEBY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Attachment : <span>"+attachment+"</span></span></div></div><div class='row'><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'> Priority : <span>"+data[i]["PRIORITY"]+"</span></span></div><div class='col-md-4'><span style='font-family:Calibri;font-size:14px;font-weight:bold'>Status : <span>"+data[i]["STATUS"]+"</span></span></div></div><br><div class='row'><div class='col-md-12'>"+notes1+"</div></div></div>";
        	   
              document.getElementById("MSG1234").innerHTML=html;
        	   }
           html=+ '<br>';
            }
          
            
    });
	  }
	});      
       
       function downFileActivityLog(att) {
//	alert(att)
//		var filename = $('#filename').val();
		var filename =att;
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location = base_url + "/Master/DownloadFile?filename=" + filename;
	}
       
       
       

