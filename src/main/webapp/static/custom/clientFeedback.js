function saveClientFeedback1(){


	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/saveClientFeedback1";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            
            data: 'clientName=' + encodeURIComponent($("#clientName").val())
            		+ '&projectName=' + encodeURIComponent($("#projectName").val())
            		+ '&dateOfFeedback=' + encodeURIComponent($("#dateOfFeedback").val())
            		+ '&feedbackType=' + encodeURIComponent($("#feedbackType").val())
            		+ '&feedbackDescription=' + encodeURIComponent($("#feedbackDescription").val())
            		+ '&impactAssessment=' + encodeURIComponent($("#impactAssessment").val())
            		+ '&statusOfGrievance=' + encodeURIComponent($("#statusOfGrievance").val())
            		+ '&assignedTo=' + encodeURIComponent($("#assignedTo").val())
            		+ '&resolutionDescription=' + encodeURIComponent($("#resolutionDescription").val())
            		+ '&followUpDate=' + encodeURIComponent($("#followUpDate").val())
            		+ '&clientResponse=' + encodeURIComponent($("#clientResponse").val())
            		
            		
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
                        window.location.href = base_url + "/PMS/clientFeedback";
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
                        window.location.href = base_url + "/PMS/clientFeedback";
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
                        window.location.href = base_url + "/PMS/clientFeedback";
                    }

                });

              }
        });
 
}