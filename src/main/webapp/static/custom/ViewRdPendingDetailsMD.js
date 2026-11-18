window.onload = function() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/ViewRdPendingDetailsMD";

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "crno=" + $('#crnoo').val() + '&uid=' + $("#uid").val()
			})
			.done(
					function(data) {
						
						console.log(data)

						$('#functionName').val(decodeURIComponent(data[0][0]));
						$('#designation').val(decodeURIComponent(data[0][1]));
						$('#username').val(decodeURIComponent(data[0][2]));
						$('#userid').val(decodeURIComponent(data[0][3]));
						$('#description').val(decodeURIComponent(data[0][4]));
    
						});
    
    
}

$("#approveMD").click(
		function() {
			


			$('#spin1').show();

			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/"
					+ l.pathname.split('/')[1];
			var serviceUrl = base_url
					+ "/PMS/ApproveRdDetailsByMD";
				
			
			
			
			$.ajax(
					{
						url : serviceUrl,
						type : 'POST',
						data : "crno=" + $('#crnoo').val(),
						
					}).done(
					function(data) {
					
						$('#spin1').hide();
						if (data === "success") {
							swal({
								title : "Successful!",
								text : "RD Approved Successfully",
								type : "success",
								width : 300,
								height : 200,
								confirmButtonClass : "btn btn-success",
								cancelButtonClass : "btn btn-danger m-l-10",
								confirmButtonText : "OK",
								preConfirm : function() {
									var l = window.location;
									var base_url = l.protocol + "//" + l.host
											+ "/" + l.pathname.split('/')[1];
									window.location.href = base_url
											+ "/Admin/apprvlRdDocuments";
								}
							})
						} else {
							swal({
								title : "Fail!",
								text : "RD Approved UnSuccessful",
								type : "error",
								width : 300,
								height : 200,
								// showCancelButton: !0,
								confirmButtonClass : "btn btn-success",
								cancelButtonClass : "btn btn-danger m-l-10",
								confirmButtonText : "OK",
								preConfirm : function() {
									var l = window.location;
									var base_url = l.protocol + "//" + l.host
											+ "/" + l.pathname.split('/')[1];
									window.location.href = base_url
											+ "/Admin/apprvlRdDocuments";
								}

							})
						}

					});
		
		});


