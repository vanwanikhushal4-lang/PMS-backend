window.onload=function(){
	
	var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/Master/getEmployeesByMan";
//   	var selectedValue = $("#functionName").val();

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',

          success: function(data2) {
          //    alert("burger"+data2)
         	 var html = "  <option value=''> -- Please Select --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("developerName").innerHTML = html;
 			document.getElementById("developerNameupdate").innerHTML = html;
// 			$("#Tlname").html(html);
 			
 		}
 	});
}



function saveAllData1(){


	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/saveFeedback";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            
            data: 'developerName=' + encodeURIComponent($("#developerName").val())
            		+ '&projectName=' + encodeURIComponent($("#projectName").val())
            		+ '&performanceRating=' + encodeURIComponent($("#performanceRating").val())
            		+ '&feedbackComments=' + encodeURIComponent($("#feedbackComments").val())
            		+ '&suggestions=' + encodeURIComponent($("#suggestions").val())
            		
        }).done(function(data) {
          
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Added Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/PMS/provideFeedback";
                    }

                });

            }
             else if (data == "duplicate") {
                swal({
                    title: "Duplicate Data!",
                    text: "Record Already Exists",
                    type: "warning",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/PMS/provideFeedback";
                    }

                });

              }
            else if (data == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to add file",
                    type: "success",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/PMS/provideFeedback";
                    }

                });

              }
        });
 
}