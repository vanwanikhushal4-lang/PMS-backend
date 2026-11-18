$('#spin1').hide();

window.onload = function() {
//	alert("Njnsjn")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	// var serviceUrl = base_url + "/PMS/getDevTaskDetails"
	var serviceUrl = base_url + "/PMS/getDevAssignedTaskDetails";

	$.ajax({
		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : "crno=" + $('#crnoo').val() + "&tid=" + $('#tid').val()
	}).done(function(data) {
//		 alert("t details " + data)

		console.log(data)
		$('#functionName').val(decodeURIComponent(data[0][0]));
		$('#Module_Name').val(decodeURIComponent(data[0][1]));
		$('#Responsibility').val(decodeURIComponent(data[0][2]));
		$('#Manager_Name').val(decodeURIComponent(data[0][3]));
		$('#Team_Leader').val(decodeURIComponent(data[0][4]));
		$('#Developer').val(decodeURIComponent(data[0][5]));

		$('#Start_Date').val(decodeURIComponent(data[0][6]));
		$('#End_Date').val(decodeURIComponent(data[0][7]));
		$('#Status').val(decodeURIComponent(data[0][8]));
		$('#Remark').val(decodeURIComponent(data[0][9]));
		
		

		if (typeof data[0][10] === "undefined") {
			$('#Description').val("NA");
		} else {
			$('#Description').val(decodeURIComponent(data[0][10]));
		}
		
		if(data[0][11]==null){
			$('#DivCustomer').hide();
		}else
			{
			$('#DivCustomer').show();
			$('#customer_name').val(decodeURIComponent(data[0][11]));
			}
		
		
		
		if(data[0][12]==null){
			$('#DivProductName').hide();
		}else
			{
			$('#DivProductName').show();
			$('#product_name').val(decodeURIComponent(data[0][12]));
			
			}
		
		if(data[0][13]==null){
			$('#DivSuitName').hide();
		}else
			{
			$('#DivSuitName').show();
			$('#suit_name').val(decodeURIComponent(data[0][13]));
			
			}
		
		
		$('#Task_Priority').val(decodeURIComponent(data[0][14]));
		
		$('#assignBY').val(decodeURIComponent(data[0][15]));
		$('#testerName').val(decodeURIComponent(data[0][16]));
		$('#testerRemark').val(decodeURIComponent(data[0][17]));
		
		

	});
}

function updateTaskStatus() {
//	alert("KJJJJJJJJJJJJ")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/updateTaskStatus";
	 $('#spin1').show();
	 $.ajax({
			            type: 'POST',
			            url: serviceUrl,
			            data: "crno=" + $('#crnoo').val() + "&tid=" + $('#tid').val()
						+ "&Status=" + $('#Status').val() + "&Remark="
						+ $('#Remark').val() + "&Manager_Name=" + $('#Manager_Name').val()+ "&Team_Leader=" + $('#Team_Leader').val()+ "&Developer=" + $('#Developer').val()+ "&End_Date=" + $('#End_Date').val(),
			        }).done(function(data) {
			        	$('#spin1').hide();
			          
			            if (data == "success") {
			                swal({
			                    title: "Successful!",
			                    text: "Status Updated Successfully",
			                    type: "success",
			                    width: 300,
			                    height: 200,
			                    buttons: false,
			                    allowOutsideClick: false,
			                    preConfirm: function() {
			                        var l = window.location;
			                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			                        window.location.href = base_url + "/PMS/TesterTask";
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
			                        window.location.href = base_url + "/PMS/TesterTask";
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
//			           		 showCancelButton: false,
//			                  confirmButtonClass: "btn btn-danger",
//			                  cancelButtonClass: "btn btn-danger m-l-10",
//			                  confirmButtonText: "OK",
			                    buttons: false,
			                    allowOutsideClick: false,
			                    preConfirm: function() {
			                        var l = window.location;
			                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			                        window.location.href = base_url + "/PMS/TesterTask";
			                    }

			                });

			              }
			        });
}
