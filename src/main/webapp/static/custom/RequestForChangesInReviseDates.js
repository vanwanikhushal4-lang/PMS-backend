
//alert("JS")


window.onload = function() {
	
		
		var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getDeveloperExtendedStartEndDateTasks";

	    $('#spin12').show(); 

	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',


	    }).done(function(data2) {
	    	 $('#spin12').hide(); 
//	    	alert("niininiii "+data2)

	      $('#DevDelaysTableDetails tbody').empty();
	    	
	      if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	        	  var CheckBox = project[0];
	              var Customername = project[1];
	              var Functionname = project[2];
	              var Activities = project[3];
	              var team_lead = project[4];
	              var AssignTo = project[5];
	              var TaskStartdate = project[6];
	              var UpdateTaskStartdate = project[7];
	              var TaskEnddate = project[8];
	              var UpdateTaskEnddate = project[9];
	              var UpdateCount = project[10];
	              
	              var row = '<tr>' +
//	              '<td>' + (CheckBox ? CheckBox : 'NA') + '</td>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
	              '<td>' + (AssignTo ? AssignTo : 'NA') + '</td>' +
	              '<td>' + (TaskStartdate ? TaskStartdate : 'NA') + '</td>' +
	              '<td style="color: orange; font-weight: bold;">' + (UpdateTaskStartdate ? UpdateTaskStartdate : 'NA') + '</td>' +
	              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
	              '<td style="color: orange; font-weight: bold;">' + (UpdateTaskEnddate ? UpdateTaskEnddate : 'NA') + '</td>' +
	              '<td>' + (UpdateCount ? UpdateCount : '0') + '</td>'
	              '</tr>';
	          $('#DevDelaysTableDetails tbody').append(row);
	      });
	          $('#sub').show();
	      } else {
//	          console.log("No data received");
	          $('#DevDelaysTableDetails tbody').append('<tr><td colspan="11" style="text-align:center; background-color:#f0f5f5;">No Activities Found</td></tr>');
	         
	      }
	  });
	    	
        }





		 //////////     Checkbox      /////////////////

//var checkedCheckboxes = [];
//var checkAllCheckbox = document.getElementById('checkAll');
//var checkboxes = document.getElementsByName('taskCheckBoxes');
//
//function updateCheckedCheckboxes() {
//    checkedCheckboxes = [];
//    checkboxes.forEach(function(checkbox) {
//        if (checkbox.checked) {
////            alert(" id :" + checkbox.id);
////            alert(" date :" + $('#date'+checkbox.id).val());
//            checkedCheckboxes.push(checkbox.id);
//        }
//    });
//    console.log(checkedCheckboxes);
//}
//
//checkAllCheckbox.addEventListener('change', function() {
//    checkboxes.forEach(function(checkbox) {
//        checkbox.checked = checkAllCheckbox.checked;
//    });
//    updateCheckedCheckboxes(); 
//});
//
//checkboxes.forEach(function(checkbox) {
//    checkbox.addEventListener('change', function() {
//        updateCheckedCheckboxes();
//    });
//});
//
//
//
//function checkIndividual() {
//	 updateCheckedCheckboxes();
//}




//var selectedEndDates = [];
//
//function getDateId(srno) {
//    var updatedDate = $("#date" + srno).val(); 
//
//    if (updatedDate && updatedDate.trim() !== "") {
//    	var idDateGroup = [];
//
//    	idDateGroup.push(srno); 
//    	idDateGroup.push(updatedDate);
//    }
//    selectedEndDates.push(idDateGroup);
//}


var selectedStartDates = [];

//function getDateId1(srno) {
//    var updatedStartDate = $("#date" + srno).val();  // 
//    var updatedEndDate = $("#date1" + srno).val();
//    var updatedReason = $("#reason" + srno).val();
//
//    if (updatedStartDate && updatedStartDate.trim() !== "" && updatedEndDate && updatedEndDate.trim() !== "" && updatedReason && updatedReason.trim() !== "") {
////    	var idDateGroup = [];
////
////    	idDateGroup.push(srno);
////    	idDateGroup.push(updatedEndDate); 
////    	idDateGroup.push(updatedStartDate); 
////    	idDateGroup.push(updatedReason); 
//    	var idDateGroup = []; 
//
//        idDateGroup.push(srno);
//        idDateGroup.push(updatedEndDate); 
//        idDateGroup.push(updatedStartDate); 
//        idDateGroup.push(updatedReason); 
//
//        selectedStartDates.push(idDateGroup); 
//    	
//    }
//}


function getDateId1(srno) {
    var updatedStartDate = $("#date" + srno).val();
    var updatedEndDate = $("#date1" + srno).val();
    var updatedReason = $("#reason" + srno).val();

    if (updatedStartDate && updatedStartDate.trim() !== "" && 
        updatedEndDate && updatedEndDate.trim() !== "" && 
        updatedReason && updatedReason.trim() !== "") {
        
        var idDateGroup = []; 

        idDateGroup.push(srno);
        idDateGroup.push(updatedEndDate); 
        idDateGroup.push(updatedStartDate); 
        idDateGroup.push(updatedReason); 

        selectedStartDates.push(idDateGroup); 
    }
}
//alert(selectedStartDates);


//var selectedDatesReason = [];
//
//function gerReason(srno) {
//    var updatedReason = $("#reason" + srno).val(); 
//
//    if (updatedReason && updatedReason.trim() !== "") {
//    	var idDateGroup = [];
//
//    	idDateGroup.push(srno); 
//    	idDateGroup.push(updatedReason);
//    }
//    selectedDatesReason.push(idDateGroup);
//}





function approveTaskEndDate() {
//    console.log("Selected dates:", checkedCheckboxes);
//    alert("Selected dates: " + JSON.stringify(checkedCheckboxes));

	

//	alert("gdfsf")
	    swal({
	        title: "Are you sure?",
	        text: "You want to Approve Dates?",
	        type: "warning",
	        width: 350,
	        height: 200,
	        showCancelButton: !0,
	        confirmButtonClass: "btn btn-success",
	        cancelButtonClass: "btn btn-danger m-l-10",
	        confirmButtonText: "Yes!"
	    }).then(function() {
//	          alert("deleteUserdddddddd")
	          
//	          alert("Selected dates: " + JSON.stringify(checkedCheckboxes));
	        var l = window.location;
	    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    	var serviceUrl = base_url + "/PMS/approveMultipleEndDate";
	    	$('#spin2').show();
	    	$.ajax({
	    		type : 'POST',
	    		url : serviceUrl,
	    		data: "checkedIds=" + checkedCheckboxes,

	        }).done(function(data) {
	            //  alert("dfgsfd"+data)

	            if (data == "success") {
	                swal({
	                    title: "Successful!",
	                    text: "Revise Dates Approved Successfully",
	                    type: "success",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/MultipleDateUpdateMgr";
	                    }

	                })

	            }

	            else if (data == "error") {
	                swal({
	                    title: "Failed!",
	                    text: "Fail to Approve Revise Dates",
	                    type: "error",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/MultipleDateUpdateMgr";
	                    }

	                })

	            }
	        });
	    })
	

	
}



function requestForReviseDates(){
    console.log("Selected Start dates:", selectedStartDates);
//    alert("Selected Start dates:", selectedStartDates);
//    console.log("Selected End dates:", selectedEndDates);
//  alert("Selected dates: " + JSON.stringify(selectedDates));



	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/updateMultipleStartEndDate";
	$('#spin2').show();
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		data: "updatedStartDates=" + selectedStartDates ,
//		"&updatedStartDates=" + selectedEndDates +
//		"&updateDatesReason=" + selectedDatesReason ,

		
//		 contentType: 'application/json', // Set content type to JSON
//		 data: JSON.stringify(selectedDates),
//		 data: JSON.stringify({ updatedDates: selectedDates }),

		success : function(data) {
			
			$('#spin2').hide();
			if (data == "success") {
				swal({
					title : "Successful!",
					text : "Requested For Extending End Date Successfully",
					type : "success",
					width : 300,
					height : 200,
					// showCancelButton: false,
					// confirmButtonClass: "btn btn-danger",
					// cancelButtonClass: "btn btn-danger m-l-10",
					// confirmButtonText: "OK",
					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"
								+ l.pathname.split('/')[1];
						window.location.href = base_url
								+ "/Admin/RequestForChangesInReviseDates";
					}
				});
			} else if (data == "duplicate") {
				swal({
					title : "Duplicate Data!",
					text : "Record Already Exists",
					type : "warning",
					width : 300,
					height : 200,
					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"
								+ l.pathname.split('/')[1];
						window.location.href = base_url
								+ "/Admin/RequestForChangesInReviseDates";
					}

				});

			} else if (data == "error") {
				swal({
					title : "Unsuccessful!",
					text : "Fail to Update Date",
					type : "error",
					width : 300,
					height : 200,
					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"
								+ l.pathname.split('/')[1];
						window.location.href = base_url
								+ "/Admin/RequestForChangesInReviseDates";
					}

				});

			}
		}
	});
	
}