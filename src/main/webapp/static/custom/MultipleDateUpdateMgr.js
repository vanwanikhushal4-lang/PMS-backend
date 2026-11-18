
//alert("JS")


window.onload = function() {
	
		
		var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getDeveloperExtendedDateTasks";

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
	              var TaskEnddate = project[6];
	              var UpdateTaskEnddate = project[7];
	              var UpdateCount = project[8];
	              
	              var row = '<tr>' +
	              '<td>' + (CheckBox ? CheckBox : 'NA') + '</td>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
	              '<td>' + (AssignTo ? AssignTo : 'NA') + '</td>' +
	              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
	              '<td style="color: orange; font-weight: bold;">' + (UpdateTaskEnddate ? UpdateTaskEnddate : 'NA') + '</td>' +
	              '<td>' + (UpdateCount ? UpdateCount : '0') + '</td>'
	              '</tr>';
	          $('#DevDelaysTableDetails tbody').append(row);
	      });
	          $('#sub').show();
	      } else {
//	          console.log("No data received");
	          $('#DevDelaysTableDetails tbody').append('<tr><td colspan="9" style="text-align:center; background-color:#f0f5f5;">No Activities Found</td></tr>');
	         
	      }
	  });
	    	
        }





		 //////////     Checkbox      /////////////////

var checkedCheckboxes = [];
var checkAllCheckbox = document.getElementById('checkAll');
var checkboxes = document.getElementsByName('taskCheckBoxes');

function updateCheckedCheckboxes() {
    checkedCheckboxes = [];
    checkboxes.forEach(function(checkbox) {
        if (checkbox.checked) {
//            alert(" id :" + checkbox.id);
//            alert(" date :" + $('#date'+checkbox.id).val());
            checkedCheckboxes.push(checkbox.id);
        }
    });
    console.log(checkedCheckboxes);
}

checkAllCheckbox.addEventListener('change', function() {
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = checkAllCheckbox.checked;
    });
    updateCheckedCheckboxes(); 
});

checkboxes.forEach(function(checkbox) {
    checkbox.addEventListener('change', function() {
        updateCheckedCheckboxes();
    });
});



function checkIndividual() {
	 updateCheckedCheckboxes();
}




//var selectedDates = [];
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
//    selectedDates.push(idDateGroup);
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