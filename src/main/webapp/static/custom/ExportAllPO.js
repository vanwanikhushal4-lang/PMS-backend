

	$('#submit-btn').click(function(){
		
		var l = window.location;
					var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
					var serviceUrl = base_url + "/PMS/ExportAllData";
					$('#spinner1').show();
	$.ajax(
			{
				type : 'POST',
				url : serviceUrl,
				 data : "exportdata=" + $('#exportdata').val()
				 		+"&fromDate=" + $('#fromDate').val()
				 		+"&toDate=" + $('#toDate').val(),
				
			}).done(function(data) {
	//			alert("ni33"+data)
				$('#spinner1').hide();
				var path="C:\\SCM\\ExportAllData\\"+data;
				 DownloadExcel(data);
				 
//				  var datas = "C:SCM\ExportAllPO";
//				  Swal({
//				    title: "Excel File successfully generated!",
//				    text: "File Path:" +data, // Combine both text parts into a single text property
//				    icon: "success",
//				    confirmButtonClass: "btn btn-success",
//				    confirmButtonText: "OK",
//				});
				 swal({
		                title: "Successful!",
		                html: "Excel File Successfully Generated!<br>" +path ,
		                type: "success",
		                width: 300,
		                height: 200,
		                buttons: false,
		                allowOutsideClick: false,
		                preConfirm: function() {
		                    window.location.href = base_url + "/User/ExportAllPO";
		                }
		            });

			})
})

function DownloadExcel(filePath) {
    event.preventDefault(); 

    console.log("filePath_download=" + filePath); 

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var download_url = base_url + "/Inventive/Exportdata?filename=" + encodeURIComponent(filePath);

    window.location = download_url;
}