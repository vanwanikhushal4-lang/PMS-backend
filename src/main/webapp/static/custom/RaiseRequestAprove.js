
window.onload = function () {
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/TPActivity/getApprovedRequestList";
	
//    var serviceUrl = "getAllRaisedTicketList";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',

        success: function (data5) {
        	//data5.reverse();
        	//let sortedInput=	data5.slice().sort((a, b) => b.id - a.id);
                   //   alert(data5)
        	$("#preLoader").hide();
        	$("#Listing_Copy").removeClass("d-none");
            var table = $('#Listing_Copy').DataTable({
//                lengthChange: false,
				"lengthMenu":[
                    [5,10,25,50,-1],
                    [5,10,25,50,'Show all']
                ],
                pageLength: 5,
                data: data5,
                destroy: true,
                scrollX: true,
                fixedColumns: false,
                columnDefs: [{
					targets: [4,15,16,17,18,19,20],
					orderable: false
					}],

				initComplete: function () {
					this.api().columns([4,15,16,17,18,19,20]).every(function () {
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
            table.buttons().container()
                    .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
            $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
        }
    });
    
    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getPriorityName";
    
//     var getPriorityName='getPriorityName';  
    $.ajax({

        url :serviceUrl,
        type : 'POST',
        dataType: 'json',
        
    }).done(function(data) {
//        alert(data)

//        var pollingHost=data;
//        var d = pollingHost.split(",");
//        var length=d.length-1;
        var html =" <select class='form-control' tabindex='13' id='priorityupdateTDassign' name='priorityupdateTDassign' '>";
//        html=html+'<option value="">--Please Select Priority--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' +data[i]+ '">' + data[i]
            + '</option>';
        }

        document.getElementById("priorityupdateTDassign").innerHTML=html;
    });
    
  
}






///////////////////////////// ON LOAD ENDS //////////////////////
function viewTicket(id)
{
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
//          alert("T_ATTACH1_NAME: "+T_ATTACH1_NAME);

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
	              
//	              alert( ASSETCHECK)
	          if(T_COMPANY=="3i Infotech")  
	         	 {
	         	 
	         	
	              if(ASSETCHECK == "true")
	         	 {
	             	
	         	 document.getElementById("HideAssetdata").style.display = "block";

	         	 }
	          else
	         	 {
//	         	 alert( "hhh")
	         	 document.getElementById("HideAssetdata").style.display = "none";
	         	 }
	         	 }
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
            $("#RequestModeupdateTD").val(REQUEST_MODE);
            $("#severityupdateTD1").val(SEVERITY);
            
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
//	alert(filename)
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	window.location = base_url + "/Master/DownloadFile?filename=" + encodeURIComponent(filename);
       }

function downFileActivityLog(att) {
//	alert(att)
//		var filename = $('#filename').val();
		var filename =att;
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		window.location = base_url + "/Master/DownloadFile?filename=" + filename;
	}
//////////////////// GET ACTIVITY LOG ////////////////
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
//        	alert(data[0]["CHANGE_NOTES2"]);
            var T_ID = data[0]["T_ID"];
            var TIMESTAMP = data[0]["TIMESTAMP"];
            var CHANGEBY = data[0]["CHANGEBY"];
            var ATTACHMENT_NAME = data[0]["ATTACHMENT_NAME"];
            var STATUS = data[0]["STATUS"];
            var PRIORITY = data[0]["PRIORITY"];
            var CHANGE_NOTES1 = data[0]["CHANGE_NOTES1"];
            var CHANGE_NOTES2 = data[0]["CHANGE_NOTES2"];
            var ROLE_TYPE = data[0]["ROLE_TYPE"];
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
//        	   alert(statusColor);
        	   var callOutColor="";
        	   if(statusColor=="New"){callOutColor="callout-info"}
        	   else if(statusColor=="Assigned" || statusColor=="Level_1_Approved" || statusColor=="Level_2_Approved"|| statusColor=="Level 1 Approved"||statusColor=="Level 2 Approved"||statusColor=="Re-Assigned"||statusColor=="Re-Opened"||statusColor=="Work in Progress"){callOutColor="callout-warning"}
        	 	  
         	   else if(statusColor=="Resolved"||statusColor=="Closed"||statusColor=="Completed" ){callOutColor="callout-success"}
         	   else if(statusColor="Rejected"||statusColor=="reopened"||statusColor=="Hold" || statusColor=="Waiting for Spare" ||  statusColor=="Pending With Vendor"  ||  statusColor=="Awaiting User Information"||statusColor=="Level 1 Rejected"|| statusColor=="Level 2 Rejected"){callOutColor="callout-danger"}   
          	   
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

function assignTicket(id)
{
	//alert("hii");
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/TPActivity/gatherServiceDetails";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'ticketid=' + encodeURIComponent(id),
        async:false,
        success: function (data) {
        	
        	/////////////////// GET PRIORITY DATA /////////////
        	var l = window.location;
         	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
         	var serviceUrl = base_url + "/Master/getPriorityName";
            $.ajax({
            	url :serviceUrl,
                type : 'POST',
                dataType: 'json',
                data: 'companyname=' + encodeURIComponent(data[0]["T_COMPANY"]),
            }).done(function(prioritydata) {
                var html =" <select class='form-control' tabindex='13' id='priorityupdateTDassign' name='priorityupdateTDassign' '>";
                for (var i = 0; i < prioritydata.length; i++) {
                    html += '<option value="' +prioritydata[i]+ '">' + prioritydata[i]
                    + '</option>';
                }
                document.getElementById("priorityupdateTDassign").innerHTML=html;
                $("#priorityupdateTDassign").val(data[0]["PRIORITY"]);
            });
            
            /////////////////// GET SEVERITY DATA /////////////
        	var l = window.location;
         	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
         	var serviceUrl = base_url + "/Master/getSeverityName";
            $.ajax({
            	url :serviceUrl,
                type : 'POST',
                dataType: 'json',
                data: 'companyname=' + encodeURIComponent(data[0]["T_COMPANY"]),
            }).done(function(severitydata) {
                var html =" <select class='form-control' tabindex='13' id='severityupdateTDassign' name='severityupdateTDassign' '>";
                for (var i = 0; i < severitydata.length; i++) {
                    html += '<option value="' +severitydata[i]+ '">' + severitydata[i]
                    + '</option>';
                }
                document.getElementById("severityupdateTDassign").innerHTML=html;
                $("#severityupdateTDassign").val(data[0]["SEVERITY"]);
            });
        	
			var T_SUBDEPARTMENT = data[0]["T_SUBDEPARTMENT"];
			var T_LOCATION = data[0]["T_LOCATION"];
			
			var TP_SUBDEPARTMENT = data[0]["TP_SUBDEPARTMENT"];
			var TP_LOCATION = data[0]["TP_LOCATION"];
			
			$("#subdepartmentrequester").val(T_SUBDEPARTMENT);
			$("#locationrequester").val(T_LOCATION);
			$("#locationtp").val(TP_LOCATION);
			$("#subdepartmenttp").val(TP_SUBDEPARTMENT);
			
            var T_REQUESTER = data[0]["T_REQUESTER"];
            var T_COMPANY = data[0]["T_COMPANY"];
            var T_BRANCH = data[0]["T_BRANCH"];
            var T_DEPARTMENT = data[0]["T_DEPARTMENT"];
            var T_PHONE = data[0]["T_PHONE"];
            var T_MAIL = data[0]["T_MAIL"];
            var VIP_LOGIN = data[0]["VIP_LOGIN"];
            
            var T_CATEGORY = data[0]["T_CATEGORY"];
            var T_SUBCAT1 = data[0]["T_SUBCAT1"];
            var T_SUBCAT2 = data[0]["T_SUBCAT2"];
            var T_SUBJECT = data[0]["T_SUBJECT"];
            var T_DATE = data[0]["T_DATE"];
            var STATUS = data[0]["STATUS"];
            var T_ID = data[0]["T_ID"];
            var T_DESC = data[0]["T_DESC"];
            var PRIORITY = data[0]["PRIORITY"];
            var REQUEST_MODE = data[0]["REQUEST_MODE"];
            
            var SUPERVISOR_BRANCH = data[0]["SUPERVISOR_BRANCH"];
            var SUPERVISOR_COMPANY = data[0]["SUPERVISOR_COMPANY"];
            var SUPERVISOR_NAME = data[0]["SUPERVISOR_NAME"];
            var SUPERVISOR_DEPARTMENT = data[0]["SUPERVISOR_DEPARTMENT"];
            var SUPERVISOR_DATE = data[0]["SUPERVISOR_DATE"];
            var SUPERVISOR_NOTES = data[0]["SUPERVISOR_NOTES"];

            var TP_NAME = data[0]["TP_NAME"];
            var TP_COMPANY = data[0]["TP_COMPANY"];
            var TP_BRANCH = data[0]["TP_BRANCH"];
            var TP_DEPARTMENT = data[0]["TP_DEPARTMENT"];
            var TP_PHONE = data[0]["TP_PHONE"];
            var TP_MAIL = data[0]["TP_MAIL"];
            var SEVERITY=data[0]["SEVERITY"];
            var COST=data[0]["REQUEST_COST"];
            
  		  
		     var REQUESTTYPE = data[0]["REQUESTTYPE"];
        var APPROVALLEVEL = data[0]["APPROVALLEVEL"];
         var PROCESSINGGROUP = data[0]["PROCESSINGGROUP"];
			
		  $("#actionrequesttype").val(REQUESTTYPE);
$("#actionapprovallevel").val(APPROVALLEVEL);
$("#actionprocessinggroup").val(PROCESSINGGROUP);

            $("#nameupdateTP").val(TP_NAME);
            $("#companyupdateTP").val(TP_COMPANY);
            $("#siteupdateTP").val(TP_BRANCH);
            $("#deptupdateTP").val(TP_DEPARTMENT);
            $("#phoneupdateTP").val(TP_PHONE);
            $("#emailupdateTP").val(TP_MAIL);

            $("#nameupdateUDassign").val(T_REQUESTER);
            $("#companyupdateUDassign").val(T_COMPANY);
            
            
            $("#siteupdateUDassign").val(T_BRANCH);
            $("#deptupdateUDassign").val(T_DEPARTMENT);
            $("#phoneupdateUDassign").val(T_PHONE);
            $("#emailupdateUDassign").val(T_MAIL);
            $("#vipuser").val(VIP_LOGIN);
            
            $("#categoryupdateTDassign").val(T_CATEGORY);
            $("#subcat1updateTDassign").val(T_SUBCAT1);
            $("#subcat2updateTDassign").val(T_SUBCAT2);
            $("#subjectupdateTDassign").val(T_SUBJECT);
            $("#raisedateupdateTDassign").val(T_DATE);
            $("#statusupdateTDassign").val(STATUS);
            $("#ticketidupdateTDassign").val(T_ID);
            $("#descriptionupdateTDassign").val(T_DESC);
            $("#priorityupdateTDassign").val(PRIORITY);
            $("#severityupdateTDassign").val(SEVERITY);
            $("#costid").val(COST);

            $("#RequestModeupdateTDassign").val(REQUEST_MODE);
            
            
           
            
            $("#siteAupdateTP").val(SUPERVISOR_BRANCH);
            $("#companyAupdateTP").val(SUPERVISOR_COMPANY);
            $("#nameAupdateTP").val(SUPERVISOR_NAME);
            $("#depAtupdateTP").val(SUPERVISOR_DEPARTMENT);
            $("#RequestModeupdateTDassign").val(SUPERVISOR_DATE);
            
            $("#RequestModeupdateTDassign").val(SUPERVISOR_NOTES);

           // alert(STATUS+"  ft")
            if(!(STATUS == "New" ||STATUS == "Level 1 Approved"||STATUS == "Level 2 Approved")){
            //	alert("sdfg")
            	  $("#toggleAssign").hide();
            	  $("#toggleReassign").show();
            	  
            }
            else{

            	$("#toggleAssign").show();
            	  $("#toggleReassign").hide();
            }
            

        }
    });

    var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getCategoryDetailsforuScop2";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        
        data:'Categoryup='+encodeURIComponent($('#companyupdateUDassign').val()),
    }).done(function (data) {
//    	alert(data)
        var html = " <select class='form-control' tabindex='7' id='enggcat' name='enggcat' onchange='change_enggsubtype(this.value)'>";
        html = html + '<option value="">--Please Select Category--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i]
                    + '</option>';
        }

        document.getElementById("enggcat").innerHTML = html;
    });
    
    
    
 
   
    
    $("#modelassign").modal("show");
}

function change_enggsubtype(category)
{
	//alert(category)
	$('#engdiv2').show();
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/getSubCategoryEnggName";

    $.ajax({

        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        async:false,
        data: 'categ=' + encodeURIComponent(category)
        + '&Company=' + encodeURIComponent($("#companyupdateUDassign").val())
        + '&Branch=' + encodeURIComponent($("#siteupdateUDassign").val())
        + '&Department=' + encodeURIComponent($("#deptupdateUDassign").val()),
        
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

$('#submit-btn').on("click", function () {
	//alert("the staus iss " + $("#statusupdateENG").val());
    //alert("submit")
    if(!validateForm200())
    {
//        alert("fail")
        event.preventDefault();
    }
    else if (validateForm200())
    {
    	$("#submit-btn").attr("disabled", true);
    	// alert("submit2")
//        alert("pass")
//        alert($("#holdnotes").val())
    	
    	var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     var serviceUrl = base_url + "/TPActivity/InsertAssignRequest";
    	
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

    }).done(function (data) {
        if (data === "success") {
          
            	  swal({
                      title: "Successful!",
                      text: 'Request Status Change to ('+$("#statusupdateENG").val()+') Successfully', 
                      type: "success",
                      width: 300,
                      height: 200,
                    
                      showCancelButton: false,

                      buttons: false,
                      allowOutsideClick: false,
                      preConfirm: function () {
                          location.reload();
                      }

                  })
           
               }
               else
                 {
                   swal({
                	title: 'Unsuccessful!', 
                   	text: 'Failed to Change Request Status', 
                   	type: 'error',
                    width: 300,
                    height: 200,
                    showCancelButton: !0,
                    confirmButtonClass: "btn btn-danger",
                    cancelButtonClass: "btn btn-danger m-l-10",
                    showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function () {
                        location.reload();
                    }

                })
                 }
        


    });
    }
});

var callToolTip231 = function (fieldName, status) {
    if (fieldName === "statusupdateENG") {
        var errorMessage = "<span>Please Select Status<span>";
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
    else if (fieldName === "assinotes") {
        var errorMessage = "<span>Please Your Enter Note <span>";
    }
    else if (fieldName === "priorityupdateTDassign") {
        var errorMessage = "<span>Please Select Priority <span>";
    }
    else if (fieldName === "severityupdateTDassign") {
        var errorMessage = "<span>Please Select Severity <span>";
    }
    
     
    $("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });
    if (status == "show") {
        $("#" + fieldName).tooltip('show');
    } else {
        $("#" + fieldName).tooltip('hide');
    }
}

function validateForm200()
{
	
      var indexError = 0;
   
   if ($('#statusupdateENG').val() === '') {
        console.log('fill statusupdateENG');
        callToolTip231('statusupdateENG', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   
   if ($('#assinotes').val() === '') {
        console.log('fill assinotes');
        callToolTip231('assinotes', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
   
   if ($('#statusupdateENG').val() === '') {
       console.log('fill statusupdateENG');
       callToolTip231('statusupdateENG', 'show');

       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   if ($('#assignTo').val().trim() === '' && ($('#statusupdateENG').val() =='Assigned' || $('#statusupdateENG').val() =='Re-Assigned')) {
//       console.log('fill enggcat');
       callToolTip231('assignTo', 'show');

       if (indexError == 0) {

       }
       indexError = indexError + 1;
   }
   if ($('#assignTo').val().trim() === 'Engineer') {
	   
	   if ($('#enggcat').val().trim() === '') {
	        console.log('fill enggcat');
	        callToolTip231('enggcat', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
	    if ($('#enggassign').val().trim() === '') {
	        console.log('fill enggassign');
	        callToolTip231('enggassign', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    } 
   } else if ( ($('#assignTo').val().trim() === 'Group') && (($('#statusupdateENG').val() =='Assigned') || $('#statusupdateENG').val() =='Re-Assigned'))
   {
	   //alert($('#assignTo').val());
	 // alert("hii");
	   if ($('#engGroup').val().trim() === '') {
//	        console.log('fill enggassign');
	        callToolTip231('engGroup', 'show');

	        if (indexError == 0) {

	        }
	        indexError = indexError + 1;
	    }
   }
  
    if ($('#priorityupdateTDassign').val().trim() === '') {
//        alert("in Hold reason")
        console.log('fill priorityupdateTDassign');
        callToolTip231('priorityupdateTDassign', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#severityupdateTDassign').val().trim() === '') {
//      alert("in Hold reason")
      console.log('fill severityupdateTDassign');
      callToolTip231('severityupdateTDassign', 'show');

      if (indexError == 0) {

      }
      indexError = indexError + 1;
  }
    
 
  // console.log("validation error count::::"+indexError);
 if (indexError != 0) {

//    alert("false");
        return false;

    } else {

//        $('#spinner2').show();
//    alert("true");
        return true;
    }

}
//
//focus out
$('#statusupdateENG').on('focusout', function () {

    var usertype = $('#statusupdateENG').val();
    if (usertype.trim() === "") {
        callToolTip231('statusupdateENG', 'show');
    }
    else {
        callToolTip231('statusupdateENG', 'hide');
    }
});
//focus out
$('#priorityupdateTDassign').on('focusout', function () {

    var usertype = $('#priorityupdateTDassign').val();
    if (usertype.trim() === "") {
        callToolTip231('priorityupdateTDassign', 'show');
    }
    else {
        callToolTip231('priorityupdateTDassign', 'hide');
    }
});
//focus out
$('#severityupdateTDassign').on('focusout', function () {

    var usertype = $('#severityupdateTDassign').val();
    if (usertype.trim() === "") {
        callToolTip231('severityupdateTDassign', 'show');
    }
    else {
        callToolTip231('severityupdateTDassign', 'hide');
    }
});

//focus out
$('#assignTo').on('focusout', function () {

    var usertype = $('#assignTo').val();
    if (usertype.trim() == "") {
        callToolTip231('assignTo', 'show');
    }
    else {
        callToolTip231('assignTo', 'hide');
    }
});
//focus out
$('#enggcat').on('focusout', function () {

    var usertype = $('#enggcat').val();
    if (usertype.trim() == "") {
        callToolTip231('enggcat', 'show');
    }
    else {
        callToolTip231('enggcat', 'hide');
    }
});
//focus out
$('#enggassign').on('focusout', function () {

    var usertype = $('#enggassign').val();
    if (usertype.trim() == "") {
        callToolTip231('enggassign', 'show');
    }
    else {
        callToolTip231('enggassign', 'hide');
    }
});

$('#assinotes').on('focusout', function () {

    var usertype = $('#assinotes').val();
    if (usertype.trim() == "") {
        callToolTip231('assinotes', 'show');
    }
    else {
        callToolTip231('assinotes', 'hide');
    }
});

//focus out
$('#engGroup').on('focusout', function () {

    var usertype = $('#engGroup').val();
    if (usertype.trim() == "") {
        callToolTip231('engGroup', 'show');
    }
    else {
        callToolTip231('engGroup', 'hide');
    }
});
//focus out
$('#holdnotes').on('focusout', function () {

    var usertype = $('#holdnotes').val();
    if (usertype.trim() == "") {
        callToolTip231('holdnotes', 'show');
    }
    else {
        callToolTip231('holdnotes', 'hide');
    }
});
//focus out

$('#statusupdateENG').on('focus', function () {
    callToolTip231('statusupdateENG', 'destroy');
});
$('#assinotes').on('focus', function () {
    callToolTip231('assinotes', 'destroy');
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
$('#holdnotes').on('focus', function () {
    callToolTip231('holdnotes', 'destroy');
});
$('#priorityupdateTDassign').on('focus', function () {
    callToolTip231('priorityupdateTDassign', 'destroy');
});
$('#severityupdateTDassign').on('focus', function () {
    callToolTip231('severityupdateTDassign', 'destroy');
});


function validateFormClose()
{
 
      var indexError = 0;
   
   if ($('#closereason').val() === '') {
        console.log('fill closereason');
        callToolTipCloseTicket('closereason', 'show');

        if (indexError == 0) {

        }
        indexError = indexError + 1;
 
    }
   
   console.log("validation error count::::"+indexError);
 if (indexError != 0) {

//    alert("false");
        return false;

    } else {

//        $('#spinner2').show();
//    alert("true");
        return true;
    }

}
var callToolTipCloseTicket = function (fieldName, status) {
    if (fieldName === "closereason") {
        var errorMessage = "<span>Please Enter Your Reason<span>";
    }
   
    $("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });
    if (status == "show") {
        $("#" + fieldName).tooltip('show');
    } else {
        $("#" + fieldName).tooltip('hide');
    }
}

$('#closereason').on('focusout', function () {

    var usertype = $('#closereason').val();
    if (usertype.trim() == "") {
        callToolTipCloseTicket('closereason', 'show');
    }
    else {
        callToolTipCloseTicket('closereason', 'hide');
    }
});
//focus out

$('#closereason').on('focus', function () {
    callToolTipCloseTicket('closereason', 'destroy');
});

function ToggleHoldReason(value){
//  alert(value)
	change_Assigntype("");
	$("#assignTo").val("");
	// $('#AssignID').hide();
	 //$('#engdiv2').hide();
	// $('#enggDiv').hide();
	 callToolTip231('assignTo', 'hide');
     callToolTip231('enggcat', 'hide');
     callToolTip231('enggassign', 'hide');

	 if(value==="Assigned"||value==="Re-Assigned"){
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
	callToolTip231('enggcat', 'destroy');
	callToolTip231('enggassign', 'destroy');
	callToolTip231('engGroup', 'destroy');
	
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
		    data:'company='+encodeURIComponent($("#companyupdateTP").val()),
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
$('#modelassign').on('hidden.bs.modal', function () {
	 document.getElementById("Hideotherdata").style.display = "none";
	//location.reload();
//	 $('#reopendata1').remove();
//	  var shipList=document.getElementById('reopendata1');
//	  shipList.remove(shipList.options[shipList.selectedIndex].value);
	$("#statusupdateENG").val("");
//	$("#designationlevel2").val("");
//	$("#username2").val("");
	$("#assinotes").val("");
	$("#assignTo").val("");
	
})



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
function closeTicket(id)
{
    swal({
        title: "Confirm!",
        text: "Are you sure you want to close the request",
        type: "warning",
        width: 300,
        height: 200,
        showCancelButton: true,
        confirmButtonClass: "btn btn-danger",
        cancelButtonClass: "btn btn-danger m-l-10",
        confirmButtonText: "OK",
        cancelButtonText: "Cancel"
    }).then((isConfirm) => {
        if (isConfirm) {
        	$('#tid').val(id);
        	$("#closereason").val("");
            
          $("#modelclose").modal("show");
        }
    });

}
$('#ticketclose-btn').on("click", function () {
    if(!validateFormClose())
    {
        event.preventDefault();
    }
    else if(validateFormClose())
    {
    var idd= $("#tid").val();
    
    $("#ticketclose-btn").attr("disabled", true);
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/UserActivity/closeUserResolvedRequest";
    
    $.ajax({
                url: serviceUrl,
                type: 'post',
                data: 'ticketid=' + encodeURIComponent(idd)
                + '&closereason=' + encodeURIComponent($("#closereason").val()),
                // + '&athorrrr=' + $("#athorrrr").val(),
                success: function (data) {
// alert(data);
                    if (data === "success") {
                        swal({
                            title: "Successful!",
                            text: "Request Closed Successfully",
                            type: "success",
                            width: 300,
                            height: 200,
// showCancelButton: false,
// confirmButtonClass: "btn btn-danger",
// cancelButtonClass: "btn btn-danger m-l-10",
// confirmButtonText: "OK",
                            buttons: false,
                            allowOutsideClick: false,
                            preConfirm: function () {
                                location.reload();
                            }
                        });
                    }else if (data === "duplicate") {
                swal({
                    title: "Not Allowed",
                    text: "Cant close if ticket is not Resolved",
                    type: "error",
                    width: 300,
                    height: 200,
// showCancelButton: !0,
// showCancelButton: false,
// confirmButtonClass: "btn btn-danger",
// cancelButtonClass: "btn btn-danger m-l-10",
// confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        location.reload();
                    }

                })

            }
                }
            });
  }
});

$('#cancel-btn').on("click", function () {
// alert("reopen close");
    $("#modelreopen").modal("hide");
});


function  characterCounter()
{
//	alert("sdffsffd")
		
	$("#counterSpan").show();
	
	  var i = document.getElementById("assinotes").value.length;
	  document.getElementById("calulateId").innerHTML = 2000 - i; 
	  if(i<=0)
	  {
    	  $("#calulateId").val("");
	  };
}