window.onload = function() {
  
	 var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/EFormActivity/getSoftwaredetailsList";
	
            $.ajax({
                type: 'POST',
                url: serviceUrl,               
                dataType: 'json',
               
                success: function(data5) {
                	$("#preLoader").hide();
                	$("#Listing_Copy").removeClass("d-none");
                    var table = $('#Listing_Copy').DataTable({
                    	
                        lengthChange: false,
                        pageLength: 5,
                        data: data5,
                        destroy: true,
                        scrollX: true,
                        fnInitComplete : function() {
                        	loadDatatablesScroll();
                        }
                    });
                    table.buttons().container()
                            .appendTo('#Listing_Copy_wrapper .col-sm-6:eq(0)');
                }
            });
        }



