window.onload = function()
{
 
       var dataUsersDropped=[
   [ "1","SMB:Generic Buffer Overflow Attempt Detected","Protocol-voliation" ,"Exploit", "Medium", "184"],
   [ "2","HTTP: Ips root exe Excecute Command", "Exploit","privileged-acccess", "High", "112"],
   [ "3","BIO:spam mailbot	Activity Detected", "Malware","botnet", "Medium", "124"],
   [ "4","DCERPC:Suspecious DCERPC call it", "Exploit","Buffer Overflow" ,"Medium", "99"],
   [ "5","DCERPC:Suspecious DCERPC call", "Exploit","Buffer Overflow" ,"Medium", "97"],
];
//        	alert(dataUsersDropped)
            var table = $("#Listing_Copy").dataTable();
                        table.fnDestroy();

                        table = $("#Listing_Copy").DataTable({
                            lengthChange: !1,
                            "processing": true,
                            paging: true,
                            searching: true,
                            color:"grey",
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
                        
                        var data1=[
                        	   [ "1","10.0.0.1","--" ,"**", "Unknown", "182"],
                        	   [ "2","122.165.105.45","abts-kkstatic-airtelbondin" ,"india", "Unknown", "82"],
                        	   [ "3","7.0.7.01","one.one.one.one" ,"United  States", "Unknown", "22"],
                        	   
                        		];
//                        	        	alert(dataUsersDropped)
                        	            var table = $("#Listing_Copy1").dataTable();
                        	                        table.fnDestroy();

                        	                        table = $("#Listing_Copy1").DataTable({
                        	                            lengthChange: !1,
                        	                            "processing": true,
                        	                            paging: true,
                        	                            searching: true,
                        	                            color:"grey",
                        	                            // "dom": 'rt',
                        	                            "pageLength": 5,
                        	                            destroy: true,
                        	                            scrollX: true,
                        	                            data: data1,
                        	                           
                        	                            "oLanguage": {
                        	                                "sSearch": "Search:"
                        	                            },
                        	                            buttons: ["copy", "excel", "pdf", "colvis"]
                        	                        }); 
                        	                        var data2 = [
                        	                			[ "1", "192.168.2.2", "ab", "**", "Unknown", "113" ],
                        	                	];

//                        	                        	        	alert(dataUsersDropped)
                        	                        	            var table = $("#Listing_Copy2").dataTable();
                        	                        	                        table.fnDestroy();

                        	                        	                        table = $("#Listing_Copy2").DataTable({
                        	                        	                            lengthChange: !1,
                        	                        	                            "processing": true,
                        	                        	                            paging: true,
                        	                        	                            searching: true,
                        	                        	                            color:"grey",
                        	                        	                            // "dom": 'rt',
                        	                        	                            "pageLength": 5,
                        	                        	                            destroy: true,
                        	                        	                            scrollX: true,
                        	                        	                            data: data2,
                        	                        	                           
                        	                        	                            "oLanguage": {
                        	                        	                                "sSearch": "Search:"
                        	                        	                            },
                        	                        	                            buttons: ["copy", "excel", "pdf", "colvis"]
                        	                        	                        });
                        	                
                        	                        
                        	                        
        
                        
  
}