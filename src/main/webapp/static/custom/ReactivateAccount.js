
//alert("JS")


window.onload = function() {
	
		
		var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    var serviceUrl = base_url + "/PMS/getDeveloperExtendedDateTasks";
	    var serviceUrl = base_url + "/PMS/getDeactivatedAccounts";

	    $('#spin12').show(); 

	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',


	    }).done(function(data2) {
	    	 $('#spin12').hide(); 
//	    	alert("niininiii "+data2)

//	      $('#DevDelaysTableDetails tbody').empty();
	    	
//	      if (data2 && data2.length > 0) {
//	          data2.forEach(function(project) {
//	        	  var CheckBox = project[0];
//	              var Username = project[1];
//	              var Fullname = project[2];
//	              var Roletype = project[3];
//	              var LastLogin = project[4];
//	              
//	              var row = '<tr>' +
//	              '<td>' + (CheckBox ? CheckBox : 'NA') + '</td>' +
//	              '<td>' + (Username ? Username : 'NA') + '</td>' +
//	              '<td>' + (Fullname ? Fullname : 'NA') + '</td>' +
//	              '<td>' + (Roletype ? Roletype : 'NA') + '</td>' +
//	              '<td>' + (LastLogin ? LastLogin : 'NA') + '</td>' +
//	              '</tr>';
//	          $('#DevDelaysTableDetails tbody').append(row);
//	      });
//	          $('#sub').show();
//	      } else {
////	          console.log("No data received");
//	          $('#DevDelaysTableDetails tbody').append('<tr style="text-align:center;><td colspan="3">No Deactivated Users found</td></tr>');
//	         
//	      }
	      
	      
	      
//	      if (data2 && data2.length > 0) {
//	    	    data2.forEach(function(project) {
//	    	        var CheckBox = project[0];
//	    	        var Username = project[1];
//	    	        var Fullname = project[2];
//	    	        var Roletype = project[3];
//	    	        var LastLogin = project[4];
//	    	        
//	    	        var row = '<tr>' +
//	    	        '<td>' + (CheckBox ? CheckBox : 'NA') + '</td>' +
//	    	        '<td>' + (Username ? Username : 'NA') + '</td>' +
//	    	        '<td>' + (Fullname ? Fullname : 'NA') + '</td>' +
//	    	        '<td>' + (Roletype ? Roletype : 'NA') + '</td>' +
//	    	        '<td>' + (LastLogin ? LastLogin : 'NA') + '</td>' +
//	    	        '</tr>';
//	    	        $('#DevDelaysTableDetails tbody').append(row);
//	    	    });
//	    	    $('#sub').show();
//	    	} else {
//	    	    $('#DevDelaysTableDetails tbody').append('<tr><td colspan="5" style="text-align:center; background-color:#f0f5f5;">No Deactivated Users Found</td></tr>');
//	    	}
	      
	      var table = $('#DevDelaysTableDetails').DataTable({
              lengthChange: false,
              data: data2,
               "pageLength": 15,
               scrollX:true,
               searching:true,
               dom: 'Bfrtip',
               buttons:[
//
               {
                   extend: 'excelHtml5',
                   title: 'Inactive Users',
                   exportOptions: {
                       columns: function (idx, data, node) {
                           return idx !== 1;
                       }
                   },
               },
               {
                   extend: 'print',
                   title: 'Inactive Users',
                   exportOptions: {
                       columns: function (idx, data, node) {
                           return idx !== 1;
                       }
                   },
               }],
          });
	      
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



function activateUser() {
//    console.log("Selected dates:", checkedCheckboxes);
//    alert("Selected dates: " + JSON.stringify(checkedCheckboxes));

	

//	alert("gdfsf")
	    swal({
	        title: "Are you sure?",
	        text: "You want to Activate Accounts?",
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
//	    	var serviceUrl = base_url + "/PMS/approveMultipleEndDate";
	    	var serviceUrl = base_url + "/PMS/activateAccounts";
	    	
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
	                    text: "Accounts Activated Successfully",
	                    type: "success",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/PMS/ReactivateAccount";
	                    }

	                })

	            }

	            else if (data == "error") {
	                swal({
	                    title: "Failed!",
	                    text: "Fail to Activate Accounts",
	                    type: "error",
	                    width: 300,
	                    height: 200,
	                    buttons: false,
	                    allowOutsideClick: false,
	                    preConfirm: function() {
	                        var l = window.location;
	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	                        window.location.href = base_url + "/PMS/ReactivateAccount";
	                    }

	                })

	            }
	        });
	    })
	

	
}