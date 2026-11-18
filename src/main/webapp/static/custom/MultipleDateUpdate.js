
//alert("JS")
var checkedCheckboxes = [];

window.onload = function() {
	
		
		var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getDeveloperDelayedTasks";

	    $('#spin12').show(); 
	    // Make AJAX request to fetch product manager names
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
//	        	  var CheckBox = project[0];
	              var Customername = project[0];
//	              var ProductManager = project[0][1];
	              var ProductSuite = project[1];
	              var Producttool = project[2];
	              var Functionname = project[3];
	              var Activities = project[4];
	              var team_lead = project[5];
//	              var tester = project[0][8];
	              var TaskEnddate = project[6];
	              var UpdateTaskEnddate = project[7];
//	              var delayDays = project[0][8];
	              
	              var row = '<tr>' +
//	              '<td>' + (CheckBox ? CheckBox : 'NA') + '</td>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
//	              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
	              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
	              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
//	              '<td>' + (tester ? tester : 'NA') + '</td>' +
	              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
	              '<td>' + (UpdateTaskEnddate ? UpdateTaskEnddate : 'NA') + '</td>' +
//	              '<td style="color:red;">' + (delayDays ? delayDays : 'NA') + '</td>'
	              '</tr>';
	          $('#DevDelaysTableDetails tbody').append(row);    
	      });
	          $('#sub').show();
	      } else {
	          // No data received
//	          console.log("No data received");
	          $('#DevDelaysTableDetails tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	      }
	  });
	    
	    
	    
	    
	




	
	
	
        }





		 //////////     Checkbox      /////////////////

//var checkAllCheckbox = document.getElementById('checkAll');
//var checkboxes = document.getElementsByName('taskCheckBoxes');
//var checkedCheckboxes = [];
//
//// Function to update the array of checked checkboxes
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
//// Add an event listener to the "Check All" checkbox
//checkAllCheckbox.addEventListener('change', function() {
//    checkboxes.forEach(function(checkbox) {
//        checkbox.checked = checkAllCheckbox.checked;
//    });
//    updateCheckedCheckboxes(); // Call the function to update the array of checked checkboxes
//});
//
//// Add event listeners to individual checkboxes to update the array
//checkboxes.forEach(function(checkbox) {
//    checkbox.addEventListener('change', function() {
//        updateCheckedCheckboxes();
//    });
//});



var selectedDates = [];

function getDateId(srno) {
    var updatedDate = $("#date" + srno).val(); 

    if (updatedDate && updatedDate.trim() !== "") {
    	var idDateGroup = [];
//        var dateObject = {
//            srno: srno,
//            date: updatedDate
//        };
//        selectedDates.push(dateObject);
    	idDateGroup.push(srno); 
    	idDateGroup.push(updatedDate);
    }
    selectedDates.push(idDateGroup);
}



function updateTaskEndDate() {
    console.log("Selected dates:", selectedDates);
//    alert("Selected dates: " + JSON.stringify(selectedDates));



	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/updateMultipleEndDate";
	$('#spin2').show();
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		data: "updatedDates=" + selectedDates,
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
								+ "/Admin/MultipleDateUpdate";
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
								+ "/Admin/MultipleDateUpdate";
					}

				});

			} else if (data == "error") {
				swal({
					title : "Unsuccessful!",
					text : "Fail to Update Date",
					type : "success",
					width : 300,
					height : 200,
					buttons : false,
					allowOutsideClick : false,
					preConfirm : function() {
						var l = window.location;
						var base_url = l.protocol + "//" + l.host + "/"
								+ l.pathname.split('/')[1];
						window.location.href = base_url
								+ "/Admin/MultipleDateUpdate";
					}

				});

			}
		}
	});
	
}