window.onload = function () {
	
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
function getCompanyWeekScheduleDetails(companyname){
//	alert(companyname)
	if(companyname!==""){
		$("#schedule_Div").load(" #schedule_Div > *");
		$('#schedule_Div').show();
		////////////// GET SLA WEEK SCHEDULE DATA ////////////////
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getSLAWeekScheduleData";
		
		$.ajax({
	        type: 'POST',
	        url: serviceUrl,
	       dataType: 'json',
	        data: 'companyname=' + encodeURIComponent($("#companyname").val()),
	        success: function (weekData) {
	        	
	        	$("#schedule_working_hours").jqs({

	  			  mode: "edit", // read
	  			  hour: 24, // 12
	  			  periodDuration: 30, // 15/30/60
	  			  data: weekData,
	  			  periodOptions: true,
	  			  periodColors: [],
	  			  periodTitle: "Working Hours",
	  			  periodBackgroundColor: "rgba(82, 155, 255, 0.5)",
	  			  periodBorderColor: "#2a3cff",
	  			  periodTextColor: "#000",
	  			  periodRemoveButton: "Remove",
	  			  periodDuplicateButton: 'Duplicate',
	  			  periodTitlePlaceholder: "Title",
	  			  days: [
	  			      "Monday",
	  			      "Tuesday",
	  			      "Wednesday",
	  			      "Thursday",
	  			      "Friday",
	  			      "Saturday",
	  			      "Sunday"
	  			  ],
	  			  onInit: function () {
//	  				  alert("onInit")
	  			  },
	  			  onAddPeriod: function () {
//	  				  alert("onAddPeriod")
	  			  },
	  			  onRemovePeriod: function () {
//	  				  alert("onRemovePeriod")
	  			  },
	  			  onClickPeriod: function () {
//	  				  alert("onClickPeriod")
//	  				  alert($("#schedule-demo").jqs('export'))
	  			  },
	  			  onDuplicatePeriod: function () {
//	  				  alert("duplicate")
	  			  },
	  			  
	  			});
	        }
		});
		
	}
	else{
		$('#schedule_Div').hide();
	}

}

function UpdateSchedule(){
	var json=$.parseJSON($("#schedule_working_hours").jqs('export'));
	console.log(json);

	var finalArray = {
			dataArray: []
		};
	
	for (var key in json) {
		if (json.hasOwnProperty(key)) {
			console.log("DAY FOUND: "+json[key].day);
			console.log("LENGTH: "+json[key].periods.length);
			var periodLength=json[key].periods.length;
//			console.log("PERIODS: "+json[key].periods);
			if(periodLength!==0){
				var once = true;
			for (var keyPeriod in json[key].periods) {
				if (json[key].periods.hasOwnProperty(keyPeriod)) {
					if(once){
						
					console.log("START: "+json[key].periods[keyPeriod].start);
					console.log("END: "+json[key].periods[keyPeriod].end);
					once = false;      
						finalArray.dataArray.push({ 
							day: json[key].day,
					        starttime: json[key].periods[keyPeriod].start,
					        endtime: json[key].periods[keyPeriod].end
						    });
						}
					}
				}
			}
			else{
//				console.log("NO DATA FOUND FOR DAY : "+json[key].day);
				finalArray.dataArray.push({ 
						day: json[key].day,
				        starttime: "NA",
				        endtime: "NA"
					    });
			}
		}
	}
	var finalData = JSON.stringify(finalArray)
	console.log(finalData);
	
	
	/////////////// UPDATE/INSERT SCHEDULE //////////////
	var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/insertUpdateSLAWeekScheduleData";
		
		$.ajax({
	        type: 'POST',
	        url: serviceUrl,
//	       dataType: 'json',
	        data: 'companyname=' + encodeURIComponent($("#companyname").val())+
		     "&finalArray="+finalData,
	        success: function (scheduleData) {
	        	swal({
                    title: "Successful!",
                    text: "Record Updated Successfully",
                    type: "success",
                    width: 300,
                    height: 200,
//           		 showCancelButton: false,
//                  confirmButtonClass: "btn btn-danger",
//                  cancelButtonClass: "btn btn-danger m-l-10",
//                  confirmButtonText: "OK",
                    buttons: false,
                    allowOutsideClick: false,
//                    preConfirm: function() {
//                        var l = window.location;
//                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//                        window.location.href = base_url + "/Admin/LoginMaster";
//                    }

                })
	        }
		});
}
