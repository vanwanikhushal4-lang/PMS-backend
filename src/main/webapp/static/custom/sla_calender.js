window.onload = function () {

	////////////// GET COMPANY LIST /////////////
	 var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/Master/getCompositecompanyDetails";
	     $.ajax({
	         type: 'POST',
	         url: serviceUrl,
	         dataType: 'json',
	         success: function(data4) {
	        	 var html = "<option value=''>-- Please Select --</option>";
	                    for (var i = 0; i < data4.length; i++) {
//	                        alert(data4[i]);
	                        html += '<option value="' + data4[i] + '">' + data4[i]
	                                + '</option>';
	                    }
	                    document.getElementById("companyname").innerHTML = html;
	               }
	     });

};
//////////////////// ONLOAD ENDS /////////////////////

function getCompanyCalenderDetails(companyname){
	if(companyname!==""){
		
		$('#calendar').show();
		var viewData = { finalCalendarData : [] };
	let calendar = null;
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getSLACalendarData";
	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'companyname=' + encodeURIComponent(companyname),
        success: function (calData) {
        	
        	
        	for (var key in calData) {
        	  if (calData.hasOwnProperty(key)) {
//        	    var val = calData[key];
        	    console.log(calData[key]["id"]);
        	    console.log(calData[key]["name"]);
        	    console.log(calData[key]["description"]);
        	    console.log(calData[key]["startDate"]);
        	    console.log(calData[key]["endDate"]);
        	    
        	    var parts =calData[key]["startDate"].split('-');
        	    var finalDate = new Date(parts[2], parts[1] - 1, parts[0]); 
        	    
        	    var jsonData = {};
        	    	        jsonData["id"] = calData[key]["id"];
        	    	        jsonData["name"] = calData[key]["name"];
        	    	        jsonData["description"] = calData[key]["description"];
        	    	        jsonData["startDate"] = finalDate;
        	    	        jsonData["endDate"] = finalDate;
        	    	        viewData.finalCalendarData.push(jsonData);
        	  }
        	  
        	}
        	       	
        	$(function() {
        	    var currentYear = new Date().getFullYear();
        	    
        	    calendar = new Calendar('#calendar', { 
        	        enableContextMenu: true,
        	        enableRangeSelection: true,
        	        contextMenuItems:[
        	            {
        	                text: 'Update',
        	                click: editEvent
        	            },
        	            {
        	                text: 'Delete',
        	                click: deleteEvent
        	            }
        	        ],
        	        selectRange: function(e) {
        	            editEvent({ startDate: e.startDate, endDate: e.endDate });
        	        },
        	        mouseOnDay: function(e) {
        	            if(e.events.length > 0) {
        	                var content = '';
        	                
        	                for(var i in e.events) {
        	                    content += '<div class="event-tooltip-content">'
        	                                    + '<div class="event-name" style="color:' + e.events[i].color + '">' + e.events[i].name + '</div>'
        	                                    + '<div class="event-description">' + e.events[i].description + '</div>'
        	                                + '</div>';
        	                }
        	            
        	                $(e.element).popover({ 
        	                    trigger: 'manual',
        	                    container: 'body',
        	                    html:true,
        	                    content: content
        	                });
        	                
        	                $(e.element).popover('show');
        	            }
        	        },
        	        mouseOutDay: function(e) {
        	            if(e.events.length > 0) {
        	                $(e.element).popover('hide');
        	            }
        	        },
        	        dayContextMenu: function(e) {
        	            $(e.element).popover('hide');
        	        },
        	        dataSource: viewData.finalCalendarData
        	       	
        	    });
        	    
        	    $('#save-event').click(function() {
        	        saveEvent();
        	    });
        	});
        }
    })
	
	

	//////////// FORMAT START DATE ///////////
	 $('#event-start-date').datepicker({
		
	 autoclose: true,
	 format: 'dd-mm-yyyy',
	 // todayHighlight: !0,
	 orientation:"bottom",
	 // endDate: new Date()
	    
	 })
	$('#event-start-date').prop('disabled', true);
	 
	 ////////////FORMAT END DATE ///////////
	 $('#event-end-date').datepicker({
		
	 autoclose: true,
	 format: 'dd-mm-yyyy',
	 // todayHighlight: !0,
	 orientation:"bottom",
	 // endDate: new Date()
	    
	 })
	 $('#event-end-date').prop('disabled', true);

	 ////////////// EDIT CALENDER /////////////
	function editEvent(event) {
//		alert("EDIT EVENT: "+event.id)
	    $('#event-modal input[name="event-index"]').val(event ? event.id : '');
	    $('#event-modal input[name="event-name"]').val(event ? event.name : '');
	    $('#event-modal input[name="event-description"]').val(event ? event.description : '');
	    $('#event-modal input[name="event-start-date"]').datepicker('update', event ? event.startDate : '');
	    $('#event-modal input[name="event-end-date"]').datepicker('update', event ? event.endDate : '');
	    $('#event-modal').modal();
	}

	 ////////////// DELETE CALENDER /////////////
	function deleteEvent(event) {
	    var dataSource = calendar.getDataSource();
	    calendar.setDataSource(dataSource.filter(item => item.id !== event.id));
	    //////////////////DELETE CALENDAR //////////////
        var c = window.location;
    	var base_url_delete = c.protocol + "//" + c.host + "/" + c.pathname.split('/')[1];
    	var serviceUrlDelete = base_url_delete + "/Master/deleteSLACalendarData";
    	
    	  $.ajax({
    	        type: 'POST',
    	        url: serviceUrlDelete,
    	      //  dataType: 'json',
    	        data:"companyname="+encodeURIComponent($("#companyname").val().trim())
    		     +"&eventname="+encodeURIComponent(event.name.trim())
    		     +"&eventdescription="+encodeURIComponent(event.description.trim())
    		     +"&eventdate="+encodeURIComponent(convertDate(event.startDate)),
    	        success: function (calDeleteData) {
//    	        	alert(calDeleteData)
    	        }
    		 });
	    
	}

//////////////SAVE CALENDER /////////////
	function saveEvent() {
//		alert("SAVE EVENT: "+$('#event-modal input[name="event-index"]').val())
	    var event = {
	        id: $('#event-modal input[name="event-index"]').val(),
	        name: $('#event-modal input[name="event-name"]').val(),
	        description: $('#event-modal input[name="event-description"]').val(),
	        startDate: $('#event-modal input[name="event-start-date"]').datepicker('getDate'),
	        endDate: $('#event-modal input[name="event-end-date"]').datepicker('getDate')
	    }
	    
	    var dataSource = calendar.getDataSource();
		
	    if (event.id) {
	        for (var i in dataSource) {
	            if (dataSource[i].id == event.id) {
	            	dataSource[i].name = event.name;
	                dataSource[i].description = event.description;
	                dataSource[i].startDate = event.startDate;
	                dataSource[i].endDate = event.endDate;
	                
	                ////////////////// UPDATE CALENDAR //////////////
	                var b = window.location;
	            	var base_url_update = b.protocol + "//" + b.host + "/" + b.pathname.split('/')[1];
	            	var serviceUrlUpdate = base_url_update + "/Master/updateSLACalendarData";
	            	
	            	  $.ajax({
	            	        type: 'POST',
	            	        url: serviceUrlUpdate,
	            	     //   dataType: 'json',
	            	        data:"companyname="+encodeURIComponent($("#companyname").val().trim())
	            		     +"&eventname="+encodeURIComponent(event.name.trim())
	            		     +"&eventdescription="+encodeURIComponent(event.description.trim())
	            		     +"&eventdate="+encodeURIComponent(convertDate(event.startDate)),
	            	        success: function (calUpdateData) {
//	            	        	alert(calUpdateData)
	            	        }
	            		 });
	            }
	        }
	        
	    }
	    else
	    {
	        var newId = 0;
	        for(var i in dataSource) {
	            if(dataSource[i].id > newId) {
	                newId = dataSource[i].id;
	                
	            }
	        }
	        
	        newId++;
	        event.id = newId;

	        
	  ////////////////////// INSERT IN CALENDER TABLE ////////////////      
	   var a = window.location;
	var base_url = a.protocol + "//" + a.host + "/" + a.pathname.split('/')[1];
	var serviceUrlInsert = base_url + "/Master/insertSLACalendarData";     
	       
	        $.ajax({
        type: 'POST',
        url: serviceUrlInsert,
       // dataType: 'json',
        data:"companyname="+encodeURIComponent($("#companyname").val().trim())
	     +"&eventname="+encodeURIComponent(event.name.trim())
	     +"&eventdescription="+encodeURIComponent(event.description.trim())
	     +"&eventdate="+encodeURIComponent(convertDate(event.startDate)),
        success: function (calData) {
//        	alert(calData)
        }
	 });
	        
	        dataSource.push(event);
	    }
	    
	    calendar.setDataSource(dataSource);
	    $('#event-modal').modal('hide');
	}
	}
	else{
		$('#calendar').hide();
	}
	
}

function convertDate(str) {
	  var date = new Date(str),
	    mnth = ("0" + (date.getMonth() + 1)).slice(-2),
	    day = ("0" + date.getDate()).slice(-2);
	  return [day, mnth, date.getFullYear()].join("-");
	}
