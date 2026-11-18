

var roleType = $("#role").val(); 
var designation = $("#designation").val();

if(roleType === "Developer" && (designation === "Jr. Team Leader"||designation === "Sr Team Leader"||designation === "Team Leader")) {
	$("#pendingForAssignDiv").show(); 
	$("#CMTotalProjectStatusN1").show();
} 



window.onload = function() {
//	alert("js");
	
	var toolData1=[];
	var rawData=[];
	
	
	
	//1 customerwise
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/PMS/getOperationalTaskUserList"; 
 	$('#spin11').show();
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json', 
        success: function(data5) {
//     alert("sjfi"+JSON.stringify(data5))
        	console.log("data5 :: "+data5);
        	
        	if ($.fn.DataTable.isDataTable('#ProjectDetailsCMN')) {
        		$('#ProjectDetailsCMN').DataTable().clear().destroy();
            }
        	
            var table = $("#ProjectDetailsCMN").DataTable({ 
                lengthChange: false,
                pageLength: 5,
                data: data5,
                scrollX: '300px',
//                scrollY: '300px',
                dom: 'Bfrtip',
                buttons:[

                {
                    extend: 'excelHtml5',
                    title: 'Customer Wise Task',
                },
                {
                    extend: 'print',
                    title: 'Customer Wise Task',
                }],
                columnDefs: [
                    {
                    targets: '_all', 
                    width: 'auto', 
                    orderable: false,
//                    	 orderable: true
                    }
                 ],
            });
        	
        }
    });
    
    
    
    
    //2  Task Team Wise
    
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/PMS/getOperationalTaskTeamWise"; 
 	$('#spin11').show();
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json', 
        success: function(data5) {
        	
//        	alert(data5)
        	
        	$('#spin11').hide();

			
			if ($.fn.DataTable.isDataTable('TeamWiseTable')) {
        		$('#TeamWiseTable').DataTable().clear().destroy();
            }
        	
            var table = $("#TeamWiseTable").DataTable({ 
                lengthChange: false,
                pageLength: 5,
                data: data5,
                scrollX: '300px',
//                scrollY: '300px',
                dom: 'Bfrtip', // Add this line to enable export buttons
                buttons:[

                {
                    extend: 'excelHtml5',
                    title: 'Team Wise Task',
                },
                {
                    extend: 'print',
                    title: 'Team Wise Task',
                }],
                columnDefs: [
                    {
                    targets: '_all', 
                    width: 'auto', 
                    orderable: false,
//                    	 orderable: true,
                    }
                 ],
            });
        }
    });
    
    
    
    //3 assign Table
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/PMS/getPendingAssignTask"; 
 	$('#spin11').show();
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json', 
        success: function(data5) {
        	
//        	alert(data5)
        	
        	$('#spin11').hide();

			
			if ($.fn.DataTable.isDataTable('assignForTable')) {
        		$('#assignForTable').DataTable().clear().destroy();
            }
        	
            var table = $("#assignForTable").DataTable({ 
                lengthChange: false,
                pageLength: 5,
                data: data5,
                scrollX: '300px',
//                scrollY: '300px',
                dom: 'Bfrtip', // Add this line to enable export buttons
                buttons:[

                {
                    extend: 'excelHtml5',
                    title: 'Pending For Assign Task',
                },
                {
                    extend: 'print',
                    title: 'Pending For Assign Task',
                }],
                columnDefs: [
                    {
                    targets: '_all', 
                    width: 'auto', 
                    orderable: false,
//                    	 orderable: true,
                    }
                 ],
            });
        }
    });
    
    
    // getDueForTodayTask table
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/PMS/getDueForTodayTask"; 
 	$('#spin11').show();
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json', 
        success: function(data5) {
        	
//        	alert(data5)
        	
        	$('#spin11').hide();

			
			if ($.fn.DataTable.isDataTable('DueForToday')) {
        		$('#DueForToday').DataTable().clear().destroy();
            }
        	
            var table = $("#DueForToday").DataTable({ 
                lengthChange: false,
                pageLength: 5,
                data: data5,
                scrollX: '300px',
//                scrollY: '300px',
                dom: 'Bfrtip', // Add this line to enable export buttons
                buttons:[

                {
                    extend: 'excelHtml5',
                    title: 'Due For Today Operational Task',
                },
                {
                    extend: 'print',
                    title: 'Due For Today Operational Task',
                }],
                columnDefs: [
                    {
                    targets: '_all', 
                    width: 'auto', 
                    orderable: true,
                    }
                 ],
            });
        }
    });
    
    
    //3
//    var l = window.location;
// 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/PMS/getOperationalTaskListThird"; 
// 	$('#spin11').show();
//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        dataType: 'json', 
//        success: function(data5) {
//        	
////        	alert(data5)
//        	
//        	$('#spin11').hide();
//
//			
//			if ($.fn.DataTable.isDataTable('#ProjectDetailsCMN2')) {
//        		$('#ProjectDetailsCMN2').DataTable().clear().destroy();
//            }
//        	
//            var table = $("#ProjectDetailsCMN2").DataTable({ 
//                lengthChange: false,
//                pageLength: 5,
//                data: data5,
//                scrollX: '300px',
////                scrollY: '300px',
//                dom: 'Bfrtip', // Add this line to enable export buttons
//                buttons:[
//
//                {
//                    extend: 'excelHtml5',
//                    title: 'Solution Wise Task',
//                },
//                {
//                    extend: 'print',
//                    title: 'Solution Wise Task',
//                }],
//
//
//
//            });
//        }
//    });
	

    
}






function renderChart(formattedChartData, toolData1) {
//    alert("Formatted Chart Data: " + JSON.stringify(formattedChartData) + " Tool Data: " + JSON.stringify(toolData1));

    // chart
    const categories = toolData1;
    const data = formattedChartData;

    const browserData = [];
    const versionsData = [];

    let i, j, drillDataLen, brightness;

    // Build the data arrays
    for (i = 0; i < data.length; i++) {
        // add browser data
        browserData.push({
            name: categories[i],
            y: data[i].y,
            color: data[i].color
        });

        // add version data (drilldown)
        drillDataLen = data[i].drilldown.data.length;
        for (j = 0; j < drillDataLen; j++) {
            const name = data[i].drilldown.categories[j];
            brightness = 0.2 - (j / drillDataLen) / 5;
            versionsData.push({
                name,
                y: data[i].drilldown.data[j],
                color: Highcharts.color(data[i].color).brighten(brightness).get(),
                custom: {
                    version: name.split(' ')[1] || name.split(' ')[0]
                }
            });
        }
    }

    // Create the chart
    Highcharts.chart('piechartDiv', {
        chart: { type: 'column' },
        title: { text: 'Task Chart' },
        plotOptions: {
            pie: { shadow: false, center: ['50%', '50%'] }
        },
        series: [{
            name: 'Task',
            data: browserData,
            size: '45%',
            dataLabels: {
                color: '#ffffff',
                distance: '-50%'
            }
        }, {
            name: 'Task',
            data: versionsData,
            size: '80%',
            innerSize: '60%',
            dataLabels: {
                format: '<b>{point.name}:</b> <span style="opacity: 0.5">{y}</span>',
                filter: {
                    property: 'y',
                    operator: '>',
                    value: 1
                },
                style: { fontWeight: 'normal' }
            },
            id: 'versions'
        }],
        drilldown: {
            series: formattedChartData.map(item => item.drilldown)
        }
    });
}






function formatData(rawData) {
    const formattedData = [];
    const colors = ['#FF5733', '#33FF57', '#3357FF', '#FF33A1', '#33FFF6'];

    // Group by Product_Tool
    const groupedData = rawData.reduce((acc, item) => {
        if (!acc[item.Product_Tool]) {
            acc[item.Product_Tool] = [];
        }
        acc[item.Product_Tool].push(item);
        return acc;
    }, {});

    // Iterate over grouped data to create the desired format
    Object.keys(groupedData).forEach((productTool, index) => {
        const toolData = groupedData[productTool];

        // Create unique statuses for the drilldown (e.g., Open, Closed)
        const categories = [...new Set(toolData.map(item => item.Status))];

        // Create an array of counts corresponding to each status
        const data = categories.map(category => {
            return toolData.filter(item => item.Status === category)
                           .reduce((sum, item) => sum + item.Product_Tool_Count, 0); // Summing the counts for each status
        });

        formattedData.push({
            y: toolData.reduce((sum, item) => sum + item.Product_Tool_Count, 0), // Total count for this product tool
            color: colors[index % colors.length], // Assign a color (cycling through colors)
            drilldown: {
                name: productTool,
                categories: categories,
                data: data
            }
        });
    });

    return formattedData;
}





function secondFunction(toolData1){
	//test_purpose
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getAllData";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {
			
			console.log("getAllDatagetAllData::::", JSON.stringify(data4));
				
			
			if (Array.isArray(data4)) {
                rawData = data4;  // Assign the array to rawData
//                alert("rawData is an array: " + JSON.stringify(rawData)); // Show the raw data

                // Now format the data properly
                const formattedChartData = formatData(rawData);
                console.log("Formatted Chart Data:", formattedChartData);

                // Optionally render the chart 
                renderChart(formattedChartData,toolData1);
            } else {
                console.error("API response is not an array:", data4);
//                alert("Error: API response is not an array.");
            }
        },
        error: function(xhr, status, error) {
            console.error("AJAX error:", status, error);
//            alert("AJAX error: " + error);
        }
			
	});
}











//////////////////////     Chart     /////////////////////



function getChartData() {
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getTaskChart";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {
//			alert("data4 :: "+data4);
			console.log("datttaa :: "+data4)
			
			var response = data4;
			
   if(response != "") {
	
	Highcharts.chart('containerDiv', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: 'Task Chart'
	    },

	    xAxis: {
	        categories: response[0],
	        title: {
	            text: null
	        },
	        gridLineWidth: 1,
	        lineWidth: 0
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: 'Task Count',
	            align: 'low'
	        },
	        labels: {
	            overflow: 'justify'
	        },
	        gridLineWidth: 0
	    },
	    tooltip: {
	        valueSuffix: ' task'
	    },
	    plotOptions: {
	        column: {
// borderRadius: '50%',
	            dataLabels: {
	                enabled: true,
	                format: '{point.y}'
	            },
	            groupPadding: 0.1
	        }
	    },
	    legend: {
	        layout: 'vertical',
	        align: 'right',
	        verticalAlign: 'top',
	        x: -40,
	        y: 50,
	        floating: true,
	        borderWidth: 1,
	        backgroundColor:
	            Highcharts.defaultOptions.legend.backgroundColor || '#FFFFFF',
	        shadow: true
	    },
	    credits: {
	        enabled: false
	    },
	    series: 
	    	response[1]
	    
	});
	containerDiv.style.height = '550px';
		} else {
			
			containerDiv.style.height = '360px';

			var HeaderMessage = document.createElement('h4');
			var noDataMessage = document.createElement('h6');
			noDataMessage.textContent = 'No data available';
			HeaderMessage.textContent = 'Task Chart';

			containerDiv.innerHTML = '';  

			containerDiv.style.display = 'flex';  
			containerDiv.style.flexDirection = 'column'; 
			containerDiv.style.alignItems = 'center';  
			containerDiv.style.justifyContent = 'flex-start'; 
			containerDiv.style.textAlign = 'center';  
			HeaderMessage.style.marginTop = '20px';
			noDataMessage.style.marginTop = '20px';

			containerDiv.appendChild(HeaderMessage);
			containerDiv.appendChild(noDataMessage);
		}	
		},
        error: function(xhr, status, error) {
            console.error("AJAX error:", status, error);
        }
			
	});
}



function getDetailsModal(customerName) {
//	alert(customerName);
	
	$("#customerNameSpan").text(customerName);
	
 	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getAllActivities";
    var serviceUrl = base_url + "/PMS/getOpTaskByCustomer";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: "customer=" +ecodeURIComponent(customerName),
        data: { customer: encodeURIComponent(customerName) } // Corrected here

    }).done(function(data2) {
//    	alert("niininiii "+data2)
      $('#TaskDetailsByName tbody').empty();
    	
    	var Sr_no=0;
    	
      if (data2 && data2.length > 0) {
    	 
          data2.forEach(function(project) {
        	  Sr_no = Sr_no+1;
        	  var Srno = Sr_no;
              var Producttool = project[0];
              var Desc = project[1];
              var endDate = project[2];
              var manager = project[3];
              var Status = project[4];
              var PendingWith = project[5];
//              var Activities = project[0][5];
//              var TeamLeader = project[0][6];
//              var Dev = project[0][7];
//              var TaskEnddate = project[0][8];
              
              var row = '<tr>' +
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Desc ? Desc : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (Status ? Status : 'NA') + '</td>' +
              '<td>' + (PendingWith ? PendingWith : 'NA') + '</td>' +
//              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
//              '<td>' + (TeamLeader ? TeamLeader : 'NA') + '</td>' +
//              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '</tr>';
          $('#TaskDetailsByName tbody').append(row);
      });
      } else {
//          console.log("No data received");
          $('#TaskDetailsByName tbody').append('<tr><td colspan="5">No Activities found</td></tr>');
      }
  });
    
	
	$("#TaskModal").modal('show');
}