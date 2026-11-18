
//alert("JS")


window.onload = function() {
	
//	var l = window.location;
//    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getAllDeveloperList";
////    var selectedValue = $("#Developer").val(); // Get the currently
//
//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        dataType: 'json',
//        success: function(data4) {
//        	 alert(data4);
//            var html = "<option value=''>-- Please Select --</option>";
//            for (var i = 0; i < data4.length; i++) {
//                var value = data4[i];
//                html += '<option value="' + value + '">' + value + '</option>';
//            }
//            $("#Developer").html(html); // Update the select element
////            $("#Developer").val(selectedValue); // Set the selected value
//           }
//    });	
//	
		var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getReassignTaskSideDetails";

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
//	        	  var CheckBox = project[0];
	        	  var taskId = project[0];
	        	  var productSuite = project[1];
	        	  var productTool = project[2];
	              var Customername = project[3];
	              var Functionname = project[4];
	              var Activities = project[5];
	              var team_lead = project[6];
	              var AssignTo = project[7];
	            
	              
	              var row = '<tr>' +
//	              '<td>' + (CheckBox ? CheckBox : 'NA') + '</td>' +
	              '<td>' + (taskId ? taskId : 'NA') + '</td>' +
	              '<td>' + (productSuite ? productSuite : 'NA') + '</td>' +
	              '<td>' + (productTool ? productTool : 'NA') + '</td>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
	              '<td>' + (AssignTo ? AssignTo : 'NA') + '</td>' +
	      
	              '</tr>';
	          $('#DevDelaysTableDetails tbody').append(row);
	      });
	          $('#sub').show();
	      } else {
//	          console.log("No data received");
	          $('#DevDelaysTableDetails tbody').append('<tr><td colspan="8" style="text-align:center; background-color:#f0f5f5;">No Activities Found</td></tr>');
	         
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




var selectedNames = [];

function getClickDevelopers(srno) {
    var updatedName = $("#Developer" + srno).val(); 
//    alert(updatedName)
    if (updatedName && updatedName.trim() !== "") {
    	var idNameGroup = [];

    	idNameGroup.push(srno); 
    	idNameGroup.push(updatedName);
    }
    selectedNames.push(idNameGroup);
    console.log("selectedNames"+selectedNames)
}



function reassignTask() {
//    console.log("Selected dates:", checkedCheckboxes);
//    alert("Selected dates: " + JSON.stringify(checkedCheckboxes));

	

//	alert("gdfsf")
	    swal({
	        title: "Are you sure?",
	        text: "You want to Re-Assign?",
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
	    	var serviceUrl = base_url + "/PMS/reassinTaskToDeveloper";
	    	$('#spin2').show();
	    	$.ajax({
	    		type : 'POST',
	    		url : serviceUrl,
	    		data: "selectedNames=" + selectedNames 

	        }).done(function(data) {
	            //  alert("dfgsfd"+data)

	            if (data == "success") {
	                swal({
	                    title: "Successful!",
	                    text: "Task Re-Assign Successfully",
	                    type: "success",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/ReassignTaskSide";
	                    }

	                })

	            }

	            else if (data == "error") {
	                swal({
	                    title: "Failed!",
	                    text: "Fail to Re-Assign Task",
	                    type: "error",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/Admin/ReassignTaskSide";
	                    }

	                })

	            }
	        });
	    })
	

	
}



function getDevelopers(getdevid){
//	alert("getdevid"+getdevid);
	
	var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getAllDeveloperList";
  var selectedValue = $("#Developer"+getdevid).val(); // Get the currently

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data4) {
//      	 alert(data4);
          var html = "<option value=''>-- Please Select --</option>";
          for (var i = 0; i < data4.length; i++) {
              var value = data4[i];
              html += '<option value="' + value + '">' + value + '</option>';
          }
          $("#Developer"+getdevid).html(html); // Update the select element
          $("#Developer"+getdevid).val(selectedValue); // Set the selected value
         }
  });	

}