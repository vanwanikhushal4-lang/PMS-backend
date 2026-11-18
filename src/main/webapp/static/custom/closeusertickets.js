 window.onload = function() {
   
	 var l = window.location;
	 var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 var serviceUrl = base_url + "/UserActivity/getClosedUserTicketList";
	 
//            var serviceUrl = "getClosedUserTicketList";
            $.ajax({
                type: 'POST',
                url: serviceUrl,               
                dataType: 'json',
                
                success: function(data5) {
//                      alert(data5)
                	$("#preLoader").hide();
                	$("#Listing_Copy").removeClass("d-none");
                    var table = $('#Listing_Copy').DataTable({
                        lengthChange: false,
                        pageLength: 5,
                        data: data5,
                        destroy: true,
                        scrollX: true,
                        columnDefs: [{
        					targets: [6,12,13,14,15,16,17,18,19,20],
        					orderable: false
        					}],    
        initComplete: function () {
			this.api().columns([6,12,13,14,15,16,17,18,19,20]).every(function () {
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
		           $($.fn.dataTable.tables(true)).DataTable().columns.adjust();

		 
		    } );
		}
                    });
                    table.buttons().container()
                            .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
                    $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
                    
                }
            });
        }
///////////////// ONLOAD ENDS /////////////
 
 function viewTicket(id)
 {
 var l = window.location;
 var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 var serviceUrl = base_url + "/UserActivity/gatherUserTicketDetails";
         
            $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         data: 'ticketid=' + id,

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
//           alert("T_ATTACH1_NAME: "+T_ATTACH1_NAME);

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
              if(ASSETCHECK == "true")
         	 {
             	
         	 document.getElementById("HideAssetdata").style.display = "block";

         	 }
          else
         	 {
//         	 alert( "hhh")
         	 document.getElementById("HideAssetdata").style.display = "none";
         	 }

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
// 	alert(filename)
 	var l = window.location;
    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    	window.location = base_url + "/Master/DownloadFile?filename=" + encodeURIComponent(filename);
        }

 function downFileActivityLog(att) {
// 	alert(att)
// 		var filename = $('#filename').val();
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
     var serviceUrl = base_url + "/UserActivity/getTicketActivityLog";
     
     $.ajax({
         url: serviceUrl,
         type: 'post',
        dataType: 'json',
         data: 'ticketid=' + ticketid,

         success: function(data) {
//         	alert(data[0]["CHANGE_NOTES2"]);
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
//         	   alert(statusColor);
         	   var callOutColor="";
         	  if(statusColor=="New"){callOutColor="callout-info"}
       	   else if(statusColor=="Assigned" ||statusColor=="Re-Assigned"|| statusColor=="Pending"){callOutColor="callout-warning"}
       	   else if( statusColor=="Reopened"){callOutColor="callout-danger"}
        	  
       	  else if(statusColor=="Hold" || statusColor=="Waiting for Spare" ||  statusColor=="Pending With Vendor"  ||  statusColor=="Awaiting User Information"){callOutColor="callout-danger"}
       	   else if(statusColor=="Resolved" ||statusColor=="Update Approved"){callOutColor="callout-success"}
       	   else if(statusColor=="Closed"){callOutColor="callout-success"}
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
