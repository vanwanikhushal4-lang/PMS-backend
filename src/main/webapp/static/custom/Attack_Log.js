window.onload = function()
{

    updatedata();
   
}


function updatedata(){
    
    //alert("ipaddres "+$("#ipaddress").val());
   
//        	alert("abc")
            var dataUsersDropped=[
   [ "1","Web Based Instant Messanger Services", "May 09 2022 18:33:50", "Inbound", "1", "Inconclusive", "1" ,"CVF_","Export","192.168.0.22","0","Low"],
   [ "2","DHCP:Option suspeciously long", "June 09 2022 18:55:50", "Inbound", "1", "nda", "1" ,"--","Export","192.168.0.33","0","Medium"],
   [ "3","Http:SQL injection", "May 22 2022 17:12:00", "Inbound", "1", "Inconclusive", "1" ,"--","Export","192.168.1.21","12262","Low"],
   [ "4","FTP:CWD -root", "May 09 2022 18:33:50", "Inbound", "9", "Inconclusive", "46" ,"CVF_","Export","10.122.0.22","0","High"],
   [ "5","Web Based Instant Messanger Services", "May 09 2022 18:33:50", "Inbound", "1", "Inconclusive", "1" ,"CVF_","Export","192.168.0.22","0","Low"],
];
//        	alert(dataUsersDropped)
            var table = $("#Listing_Copy").dataTable();
                        table.fnDestroy();

                        table = $("#Listing_Copy").DataTable({
                            lengthChange: !1,
                            "processing": true,
                            paging: true,
                            searching: true,
                            // "dom": 'rt',
                            "pageLength": 5,
                            destroy: true,
                            scrollX: true,
                            data: dataUsersDropped,
                           
                            "oLanguage": {
                                "sSearch": "Search:"
                            },
                            buttons: ["copy", "excel", "pdf", "colvis"]
                        });
            
        
  
}

//window.onload = function() {
//  alert("dftgfdg")
//	 var l = window.location;
// 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/UserActivity/getUserTicketList";
//	 
////            var serviceUrl = "getUserTicketList";
//            $.ajax({
//                type: 'POST',
//                url: serviceUrl,               
//                dataType: 'json',
//                
//                success: function(data5) {
////                      alert(data5)
////                	$("#preLoader").hide();
////                	$("#Listing_Copy").removeClass("d-none");
//                    var table = $('#Listing_Copy').DataTable({
//                        lengthChange: false,
//                        pageLength: 5,
//                        data: data5,
//                        destroy: true,
//                        scrollX: true,
//                        fnInitComplete : function() {
////                        	loadDatatablesScroll();
//                        }
//                    });
//                    table.buttons().container()
//                            .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
//                }
//            });
//            
//           
//        }