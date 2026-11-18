
window.onload = function() {
      var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/Master/form3datalisting";

     $.ajax({
         type: 'POST',
         url: serviceUrl,
         dataType: 'json',
         success: function(data4) {
             var table = $('#form3data').DataTable({
                 lengthChange: false,
                 data: data4,
                  "pageLength": 5,
                  scrollX:true,
                  scrollY:true
             });

             table.buttons().container()
                     .appendTo('#Listing_RejectedView_wrapper .col-sm-6:eq(0)');

         }

     });

 }




function validateFORM3() {
    var indexError = 0;
    if ($('#date').val().trim() === '') {
        callToolTip231('date', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    if ($('#projeimplementorname').val().trim() === '') {
        callToolTip231('projeimplementorname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#customername').val().trim() === '') {
        callToolTip231('customername', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
    
    if ($('#projectname').val().trim() === '') {
        callToolTip231('projectname', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     if ($('#description').val().trim() === '') {
        callToolTip231('description', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     if ($('#responsiblity').val().trim() === '') {
        callToolTip231('responsiblity', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     if ($('#targetdate').val().trim() === '') {
        callToolTip231('targetdate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }
     if ($('#deliverydate').val().trim() === '') {
        callToolTip231('deliverydate', 'show');
        if (indexError == 0) {

        }
        indexError = indexError + 1;
    }   
    if (indexError > 0) {
        return false;

    } else {
        return true;
    }
}


var callToolTip231 = function(fieldName, status) {

    if (fieldName == "date") {
        var errorMessage = "<span>Please Enter Date<span>";
    }
     else if (fieldName == "projeimplementorname") {
        var errorMessage = "<span>Please Enter Implementor Name<span>";
    }
    
     else if (fieldName == "customername") {
        var errorMessage = "<span>Please Enter Customer Name<span>";
    } else if (fieldName == 'projectname') {
    	var errorMessage = "<span>Please Enter Project Name<span>";
    }
     else if (fieldName == "description") {
        var errorMessage = "<span>Please Enter Description Here<span>";
    } else if (fieldName == 'responsiblity') {
    	var errorMessage = "<span>Please Enter Responsibility Name<span>";
    }
     else if (fieldName == "targetdate") {
        var errorMessage = "<span>Please Enter Target Date<span>";
    } else if (fieldName == 'deliverydate') {
    	var errorMessage = "<span>Please Enter Delivery DatE<span>";
    }

    $("#" + fieldName).tooltip({
        trigger: 'manual',
        placement: 'top',
        title: errorMessage,
        animation: true,
        delay: 1000,
        html: true
    });

    if (status == "show") {

        $("#" + fieldName).tooltip('show');

    } else {
        $("#" + fieldName).tooltip('hide');
    }
}


$('#date').on('focusout', function() {
	var usertype = $('#date').val();
	if(usertype.trim() == "") {
		callToolTip231('date', 'show');
	} else {
		callToolTip231('date', 'hide');
	}
});

$('#projeimplementorname').on('focusout', function() {
	var usertype = $('#projeimplementorname').val();
	if(usertype.trim() == "") {
		callToolTip231('projeimplementorname', 'show');
	} else {
		callToolTip231('projeimplementorname', 'hide');
	}
});

$('#customername').on('focusout', function() {
	var usertype = $('#customername').val();
	if(usertype.trim() == "") {
		callToolTip231('customername', 'show');
	} else {
		callToolTip231('customername', 'hide');
	}
});

$('#projectname').on('focusout', function() {
	var usertype = $('#projectname').val();
	if(usertype.trim() == "") {
		callToolTip231('projectname', 'show');
	} else {
		callToolTip231('projectname', 'hide');
	}
});

$('#description').on('focusout', function() {
	var usertype = $('#description').val();
	if(usertype.trim() == "") {
		callToolTip231('description', 'show');
	} else {
		callToolTip231('description', 'hide');
	}
});


$('#responsiblity').on('focusout', function() {
	var usertype = $('#responsiblity').val();
	if(usertype.trim() == "") {
		callToolTip231('responsiblity', 'show');
	} else {
		callToolTip231('responsiblity', 'hide');
	}
});

$('#targetdate').on('focusout', function() {
	var usertype = $('#targetdate').val();
	if(usertype.trim() == "") {
		callToolTip231('targetdate', 'show');
	} else {
		callToolTip231('targetdate', 'hide');
	}
});

$('#deliverydate').on('focusout', function() {
	var usertype = $('#deliverydate').val();
	if(usertype.trim() == "") {
		callToolTip231('deliverydate', 'show');
	} else {
		callToolTip231('deliverydate', 'hide');
	}
});


$('#date').on('focus', function() {
	callToolTip231('date', 'destroy');
});
$('#projeimplementorname').on('focus', function() {
	callToolTip231('projeimplementorname', 'destroy');
});

$('#customername').on('focus', function() {
	callToolTip231('customername', 'destroy');
});

$('#projectname').on('focus', function() {
	callToolTip231('projectname', 'destroy');
});
$('#description').on('focus', function() {
	callToolTip231('description', 'destroy');
});

$('#responsiblity').on('focus', function() {
	callToolTip231('responsiblity', 'destroy');
});

$('#targetdate').on('focus', function() {
	callToolTip231('targetdate', 'destroy');
});
$('#deliverydate').on('focus', function() {
	callToolTip231('deliverydate', 'destroy');
});


$("#resetbtn").click(function() {
   
    $("#date").val("");
     callToolTip231('date', 'hide');
     
      $("#projeimplementorname").val("");
     callToolTip231('projeimplementorname', 'hide');
     
      $("#customername").val("");
     callToolTip231('customername', 'hide'); 
     
      $("#projectname").val("");
     callToolTip231('projectname', 'hide'); 
     
      $("#description").val("");
     callToolTip231('description', 'hide'); 
     
      $("#responsiblity").val("");
     callToolTip231('responsiblity', 'hide'); 
     
      $("#targetdate").val("");
     callToolTip231('targetdate', 'hide'); 
     
      $("#deliverydate").val("");
     callToolTip231('deliverydate', 'hide');  
     
       
});


$("#submit-btn").click(function() {
  
     saveDataFORM3();   
});



function saveDataFORM3()  {	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/Master/InsertForm3";
	
        var serviceUrl = serviceUrl;
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 
            
                    'date=' + encodeURIComponent($("#date").val())
            		+ '&projeimplementorname=' + encodeURIComponent($("#projeimplementorname").val())
            		+ '&customername=' + encodeURIComponent($("#customername").val())
            		+ '&projectname=' + encodeURIComponent($("#projectname").val())
            		+ '&serverAvail=' + encodeURIComponent($("#serverAvail").val())
            		+ '&Responsibility=' + encodeURIComponent($("#Responsibility").val())
            		+ '&startdate=' + encodeURIComponent($("#startdate").val())
            		+ '&enddate=' + encodeURIComponent($("#enddate").val())
            		
            		+'&installvlxlicense=' + encodeURIComponent($("#installvlxlicense").val())
            		+ '&Responsibilityvlxlicense=' + encodeURIComponent($("#Responsibilityvlxlicense").val())
            		+ '&startdatevlxlicense=' + encodeURIComponent($("#startdatevlxlicense").val())
            		+ '&enddatevlxlicense=' + encodeURIComponent($("#enddatevlxlicense").val())
            		+ '&UATTesting=' + encodeURIComponent($("#UATTesting").val())
            		+ '&Responsibilityuattesting=' + encodeURIComponent($("#Responsibilityuattesting").val())
            		+ '&startdateuattesting=' + encodeURIComponent($("#startdateuattesting").val())
            		+ '&enddateuattesting=' + encodeURIComponent($("#enddateuattesting").val())
            		            	
            		+ '&productiongolive=' + encodeURIComponent($("#productiongolive").val())
            		+ '&Responsibilitygolive=' + encodeURIComponent($("#Responsibilitygolive").val())
            		+ '&startdategolive=' + encodeURIComponent($("#startdategolive").val())
            		+ '&enddategolive=' + encodeURIComponent($("#enddategolive").val())
            		+ '&rollout=' + encodeURIComponent($("#rollout").val())
            		+ '&Responsibilityrollout=' + encodeURIComponent($("#Responsibilityrollout").val())
            		+ '&startdaterollout=' + encodeURIComponent($("#startdaterollout").val())
            		+ '&enddaterollout=' + encodeURIComponent($("#enddaterollout").val())

            		+ '&demolive=' + encodeURIComponent($("#demolive").val())
            		+ '&Responsibilitydemo=' + encodeURIComponent($("#Responsibilitydemo").val())
            		+ '&startdatedemo=' + encodeURIComponent($("#startdatedemo").val())
            		+ '&enddatedemo=' + encodeURIComponent($("#enddatedemo").val())
            		+ '&paymentterms=' + encodeURIComponent($("#paymentterms").val())
            		+ '&Responsibilitypaymentterms=' + encodeURIComponent($("#Responsibilitypaymentterms").val())
            		+ '&startdatepaymentterms=' + encodeURIComponent($("#startdatepaymentterms").val())
            		+ '&enddatepaymentterms=' + encodeURIComponent($("#enddatepaymentterms").val())
            		
            		+ '&signoff=' + encodeURIComponent($("#signoff").val())
            		+ '&Responsibilitysignoff=' + encodeURIComponent($("#Responsibilitysignoff").val())
            		+ '&startdatesignoff=' + encodeURIComponent($("#startdatesignoff").val())
            		+ '&enddatesignoff=' + encodeURIComponent($("#enddatesignoff").val()),
            		
            		
            		
            		
            		
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
                        window.location.href = base_url + "/User/FORM3";
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
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/User/FORM3";
                    }

                });

              }
        });
  }  
            
  
function DeleteFORM3(srno)  {

    swal({
        title: "Are you sure?",
        text: "You want to delete?",
        type: "warning",
        width: 350,
        height: 200,
        showCancelButton: !0,
        confirmButtonClass: "btn btn-success",
        cancelButtonClass: "btn btn-danger m-l-10",
        confirmButtonText: "Yes, Delete it!"
    }).then(function() {
      
    	 var l = window.location;
     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
     	var serviceUrl = base_url + "/Master/deleteFORM3";

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            data: 'srno=' + srno

        }).done(function(data) {        
            if (data == "success") {
                swal({
                    title: "Successful!",
                    text: "Record Deleted Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/User/FORM3";
                    }

                });

            }

            else if (data == "error") {
                swal({
                    title: "Unsuccessful!",
                    text: "Fail to delete file",
                    type: "success",
                    width: 300,
                    height: 200,
                    buttons: false,
                    allowOutsideClick: false,
                    preConfirm: function() {
                        var l = window.location;
                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                        window.location.href = base_url + "/User/FORM3";
                    }

                });

              }
        });
    });
  } 
          


function EditFORM3(srno,date,projct_impl_name,customername,projectname,description,responsiblity,targetdate,deliverytdate)
{
	 $("#dateupdate").val(date);
	 $("#projeimplementornameupdate").val(projct_impl_name); 
	 $("#customernameupdate").val(customername);
	 $("#projectnameupdate").val(projectname);
	 $("#descriptionupdate").val(description); 
	 $("#responsiblityupdate").val(responsiblity);
	 $("#targetdateupdate").val(targetdate); 
	 $("#deliverydateupdate").val(deliverytdate); 
	 $("#sr_no1").val(srno);
	 $("#modelFORM3").modal("show");	     	
}

$("#update_productMasterType_btn").click(function () {

     updateFORM3();
}).show();

function updateFORM3()
{
	 var l = window.location;
   var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   var serviceUrl = base_url + "/Master/updateform3";
   
     $.ajax({
         type: 'POST',
         url: serviceUrl,
         data: 
                 "sr_no=" + $("#sr_no1").val()
                 +"&dateupdate=" +$('#dateupdate').val()
                 + "&projeimplementornameupdate="+$("#projeimplementornameupdate").val()
                 + "&customernameupdate=" +$("#customernameupdate").val()
                 +"&projectnameupdate=" +$('#projectnameupdate').val()
                 + "&descriptionupdate="+$("#descriptionupdate").val()
                 + "&responsiblityupdate=" +$("#responsiblityupdate").val()
                 + "&targetdateupdate="+$("#targetdateupdate").val()
                 + "&deliverydateupdate=" +$("#deliverydateupdate").val(),
                                              
         success: function (data) {
             if (data == "success") {
                 swal({
                     title: "Successful!",
                     text: "Record Updated Successfully",
                     type: "success",
                     width: 300,
                     height: 200,
                     buttons: false,
                     allowOutsideClick: false,
                     preConfirm: function () {
                         var l = window.location;
                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                         window.location.href = base_url + "/User/FORM3";
                     }
                 });
         }    else {

                 swal({
                     title: "Unsuccessful!",
                     text: "Record not updated",
                     type: "error",
                     width: 300,
                     height: 200,
                     buttons: false,
                     allowOutsideClick: false,
                     preConfirm: function () {
                         var l = window.location;
                         var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
                         window.location.href = base_url + "/User/FORM3";
                     }
                 });
             }


         }
     });
}



let dataArray = [];
function addRow() {
    const tableBody = document.querySelector("#data-table tbody");
    const placeholders = ['Enter Your Product Name', 'Enter your Description'];

    // Create a new row
    const newRow = tableBody.insertRow();

    for (let i = 0; i < 4; i++) {
        const cell = newRow.insertCell();
        const input = document.createElement('input');
        input.type = i === 0 || i === 1  ? 'text' : 'datetime-local';
        input.placeholder = placeholders[i];
        if ( i === 2 || i === 3) {
            input.type = 'datetime-local';
        }
        cell.appendChild(input);
    }

    // Add the delete button to the last cell
    const deleteCell = newRow.insertCell();
    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Delete Row';
    deleteButton.onclick = function() {
        deleteRow(deleteButton);
    };
    deleteButton.classList.add('btn', 'btn-sm', 'btn-danger');
    deleteCell.appendChild(deleteButton);
}


//function deleteRow(btn)
//{
//	    const row = btn.parentNode.parentNode;
//	    row.parentNode.removeChild(row);
//	    
//}


function deleteRow(btn) {
    const row = btn.parentNode.parentNode;
    const rowId = row.getAttribute('data-row-id');

    // Hide the row
    row.style.display = 'none';

    // Hide the corresponding th
    const th = document.querySelector(`th[data-row-id="${rowId}"]`);
    if (th) {
        th.style.display = 'none';
    }
}



