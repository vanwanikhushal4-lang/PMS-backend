
window.onload = function() {
//	alert("js");
	
	var toolData1=[];
	var rawData=[];
	
	getChartData();
	getChartByTeam("F_HEAD");
	getChartByTeam("AM_DM");
	getChartByTeam("TEAM_LEADER");
	getTaskTable1("F_HEAD")
	getTaskTable2("PRODUCTTOOL")

	
	//1 
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////	var serviceUrl = base_url + "/PMS/getOperationalTaskListFirst"; 
//	var serviceUrl = base_url + "/PMS/getSolutionwiseTeam"; 
//	$('#spin1').show();
//
//	$.ajax({
//	    type: 'POST',
//	    url: serviceUrl,
//	    dataType: 'json', 
//	    success: function(data5) {
//	    	
//	        $('#spin1').hide();
//	        console.log("data5 :: " + JSON.stringify(data5));
//
//	        if ($.fn.DataTable.isDataTable('#ProjectDetailsCMN')) {
//	            $('#ProjectDetailsCMN').DataTable().clear().destroy();
//	        }
//
//	        var table = $("#ProjectDetailsCMN").DataTable({ 
//	            lengthChange: false,
//	            pageLength: 5,
//	            data: data5, // Pass the data (JSON array of objects)
//	            scrollX: '300px',
//	            dom: 'Bfrtip',
//	            buttons: [
//	                {
//	                    extend: 'excelHtml5',
//	                    title: 'Customer Wise Task',
//	                },
//	                {
//	                    extend: 'print',
//	                    title: 'Customer Wise Task',
//	                }
//	            ],
//	            columns: [
////	                { data: 'srno' },  
//	                { data: 'solution' },     
//	                { data: 'fhead' } ,
//	                { data: 'AM_DM' } ,
//	                { data: 'teamLeader' } 
//	            ]
//	        });
//	    },
//	    error: function(xhr, status, error) {
//	        $('#spin1').hide();
//	        console.error("Error fetching data: ", error);
//	    }
//	});
	

	
}


function getTaskTable2(tableName) {
	var getFrom = "web";
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/PMS/getSolutionwiseTeam"; 
	var serviceUrl = base_url + "/PMS/getTaskCount"; 
	$('#spin1').show();

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType: 'json', 
	    data: "tableName=" +tableName + '&getFrom=' + getFrom,
	    success: function(data) {
//	    	alert(data5);
	    	
	        $('#spin1').hide();
	        console.log("data5 :: " + JSON.stringify(data));

	        if ($.fn.DataTable.isDataTable("#solnTask")) {
	            $("#solnTask").DataTable().clear().destroy();
	        }

	        var table = $("#solnTask").DataTable({ 
	            lengthChange: false,
	            pageLength: 5,
	            data:data, 
	            scrollX: '300px',
//	            dom: 'Bfrtip',
//	            buttons: [
//	                {
//	                    extend: 'excelHtml5',
//	                    title: 'Customer Wise Task',
//	                },
//	                {
//	                    extend: 'print',
//	                    title: 'Customer Wise Task',
//	                }
//	            ],
              columnDefs: [
              {
              targets: '_all', 
              width: 'auto', 
              orderable: false,
//              	 orderable: true
              }
           ],
	            columns: [
	                { data: 'name' },     
	                { data: 'total' } ,
	                { data: 'completed' } ,
	                { data: 'pending' } 
	            ]
	        });
	    },
	    error: function(xhr, status, error) {
	        $('#spin1').hide();
	        console.error("Error fetching data: ", error);
	    }
	});
}



function getTaskTable1(tableName) {
	var getFrom = "web";
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/PMS/getSolutionwiseTeam"; 
	var serviceUrl = base_url + "/PMS/getTaskCount"; 
	$('#spin1').show();

	$.ajax({
	    type: 'POST',
	    url: serviceUrl,
	    dataType: 'json', 
		data: "tableName=" +tableName + '&getFrom=' + getFrom,
	    success: function(data) {
//	    	alert(data5);
	    	
	        $('#spin1').hide();
	        console.log("data5 :: " + JSON.stringify(data));

	        if ($.fn.DataTable.isDataTable("#funTask")) {
	            $("#funTask").DataTable().clear().destroy();
	        }

	        var table = $("#funTask").DataTable({ 
	            lengthChange: false,
	            pageLength: 5,
	            data:data, 
	            scrollX: '300px',
//	            dom: 'Bfrtip',
//	            buttons: [
//	                {
//	                    extend: 'excelHtml5',
//	                    title: 'Customer Wise Task',
//	                },
//	                {
//	                    extend: 'print',
//	                    title: 'Customer Wise Task',
//	                }
//	            ],
              columnDefs: [
              {
              targets: '_all', 
              width: 'auto', 
              orderable: false,
//              	 orderable: true
              }
           ],
	            columns: [
	                { data: 'name' },     
	                { data: 'total' } ,
	                { data: 'completed' } ,
	                { data: 'pending' } 
	            ]
	        });
	    },
	    error: function(xhr, status, error) {
	        $('#spin1').hide();
	        console.error("Error fetching data: ", error);
	    }
	});
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
	
	var Ptool = "NA";
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/PMS/getTaskChart";
	var serviceUrl = base_url + "/PMS/getSolutionChart";

	
	$('#spin2').show();

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data: "solution=" +Ptool,
		success : function(data4) {
			
			$('#spin2').hide();

			
	var response = data4;
//	alert("pieee chart "+ (response[1].replace('"','')));
			
   if(response != "") {
	   
	   $("#solSelectDiv").show();
	   
	   
	   
	   const colors = Highcharts.getOptions().colors,
	    categories = response[0],

	    data = response[1],
//	    data = response[1].replace('"',''),
	    
	    browserData = [],
	    versionsData = [],
	    dataLen = data.length;

	let i,
	    j,
	    drillDataLen,
	    brightness;


	for (i = 0; i < dataLen; i += 1) {

	    browserData.push({
	        name: categories[i],
	        y: data[i].y,
	        color: data[i].color
	    });

	    drillDataLen = data[i].drilldown.data.length;
	    
	    const uniqueVersions = new Set();

	    for (let j = 0; j < drillDataLen; j += 1) {
	        const name = data[i].drilldown.categories[j];

	        let categoryColor = Highcharts.color(data[i].color).brighten(brightness).get();

	        if (name === 'Development') {
	            categoryColor = '#DC8940';
	        } else if (name === 'Enhancement') {
	            categoryColor = '#F3EE49';
	        } else if (name === 'Planning') {
	            categoryColor = '#DB4040';
	        } else if (name === 'Stability') {
	            categoryColor = '#45DC40';
	        }

	        // Create a unique key based on name and color
	        const uniqueKey = `${name}-${categoryColor}`;

	        // Check if the combination of name and color already exists in the Set
	        if (!uniqueVersions.has(uniqueKey)) {
	            // Add the key to the Set to prevent duplicates
	            uniqueVersions.add(uniqueKey);

	            // Push to versionsData
	            versionsData.push({
	                name,
	                y: data[i].drilldown.data[j],
	                color: categoryColor,
	                custom: {
	                    version: name.split(' ')[1] || name.split(' ')[0]
	                }
	            });
	        }
	    }
	    
	}    
	    
//	    for (j = 0; j < drillDataLen; j += 1) {
//	        const name = data[i].drilldown.categories[j];
////	        brightness = 0.2 - (j / drillDataLen) / 5;
//	        
//	        let categoryColor = Highcharts.color(data[i].color).brighten(brightness).get();
//	        
//	        if (name === 'Development') {
//	            categoryColor = '#DC8940';  
//	        } else if (name === 'Enhancement') {
//	            categoryColor = '#F3EE49';  
//	        } else if (name === 'Planning') {
//	            categoryColor = '#DB4040';  
//	        } else if (name === 'Stability') {
//	            categoryColor = '#45DC40';
//	        }
//	        
//	        versionsData.push({
//	            name,
//	            y: data[i].drilldown.data[j],
//	            color: categoryColor,
//	            custom: {
//	                version: name.split(' ')[1] || name.split(' ')[0]
//	            }
//	        });
//	        
////	        versionsData.push({
////	            name,
////	            y: data[i].drilldown.data[j],
////	            color: Highcharts.color(data[i].color).brighten(brightness).get(),
////	            custom: {
////	                version: name.split(' ')[1] || name.split(' ')[0]
////	            }
////	        });
//	    }
//	}

//	alert("browserData "+JSON.stringify(browserData));
//	alert("versionsData "+JSON.stringify(versionsData));
	
	// Create the chart
	
	
	Highcharts.chart('containerDiv', {
	    chart: {
	        type: 'pie',
	    },
	    title: {
	        text: ''
	    },
	    
	    plotOptions: {
	        pie: {
	            shadow: true,
	            center: ['50%', '50%'],
//	            point: {
//	                events: {
//	                    click: function () {
//	                        var l = window.location;
//	                        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	                        var redirectUrl = base_url + "/Admin/RequirementDoc?name=" + this.name + "&value=" + this.y;
//
//	                        console.log('Redirect URL:', redirectUrl);
//	                        window.location.href = redirectUrl;
//	                    }
//	                }
//	            }
	        }
	    },
	    
	    series: [{
	        name: 'Total Projects',
	        data: browserData,
	        size: '65%',
	        dataLabels: {
	            color: '#ffffff',
	            distance: '-15%',
	            float : true,
	            style: {
	                fontSize: '10px',  // Increase the font size of the data labels
	                fontWeight: 'bold'
	            }
	        },
	        showInLegend: true,
	    }, {
	    	
	        name: 'Projects',
	        data: versionsData,
	        size: '100%',
	        innerSize: '66%',
	        dataLabels: {
//	        	 distance: '-20%',
	            format: '<b>{point.name}:</b> <span style="opacity: 0.9">{y}</span>',
	            filter: {
	                property: 'y',
	                operator: '>',
	                value: 0
	            },
	            style: {
	                fontSize: '10px',  // Increase the font size of the data labels
	                fontWeight: 'normal'
	            }
	        },
//	        showInLegend: true,
	        
	        id: 'versions',
	        data: versionsData.map(function(point) {
	            return point;
	        })
	    }],
	    
	    legends: {
	        itemStyle: {
	            fontSize: '15px', // Increase the font size of the legend
	            fontWeight: 'bold'
	        }
	    },

	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 400
	            },
	            chartOptions: {
	                series: [{
	                }, {
	                    id: 'versions',
	                    dataLabels: {
	                        distance: 10,
	                        format: '{point.custom.version}',
	                        filter: {
	                            property: 'percentage',
	                            operator: '>',
	                            value: 2
	                        },
	                        style: {
	                            fontSize: '14px',  // Adjust font size for smaller screens
	                            fontWeight: 'normal'
	                        }
	                    }
	                }]
	            }
	        }]
	    }
	});








	   
//	   Highcharts.chart('containerDiv', {
//		    chart: {
//		        type: 'pie',
//		        options3d: {
//		            enabled: true,
//		            alpha: 45,
//		            beta: 0
//		        }
//		    },
//		    title: {
//		        text: ''
//		    },
//		    accessibility: {
//		        point: {
//		            valueSuffix: '%'
//		        }
//		    },
//		    tooltip: {
//		        pointFormat: '{series.name}: <b>{point.y}</b>'
//		    },
//		    plotOptions: {
//		        pie: {
//		            allowPointSelect: true,
//		            cursor: 'pointer',
//		            depth: 35,
//		            dataLabels: {
//		                enabled: true,
//		                format: '{point.name}'
//		            },
//		            showInLegend: true,
////		            colorByPoint: true,
////		            // Use a color callback function to avoid black
////		            colors: (function() {
////		                var baseColors = Highcharts.getOptions().colors; // Get default color scheme
////		                return baseColors.map(function(color) {
////		                    return color === '#434348' ? '#7cb5ec' : color; // Replace black with another color
////		                });
////		            })()
////		            colors: ['#7cb5ec',  '#90ed7d', '#f7a35c', '#8085e9', '#f15c80', '#e4d354', '#2b908f', '#f45b5b', '#91e8e1']  // Custom color palette excluding black
//		        }
//		    },
//		    series: [{
//		        type: 'pie',
//		        name: 'Projects',
//		        data: response
//		    }]
//		});


	
//	Highcharts.chart('containerDiv', {
//	    chart: {
//	        type: 'column'
//	    },
//	    title: {
//	        text: ''
//	    },
//
//	    xAxis: {
//	        categories: response[0],
//	        title: {
//	            text: 'Phase',
//	            align: 'middle'
//	        },
//	        gridLineWidth: 1,
//	        lineWidth: 0
//	    },
//	    yAxis: {
//	        min: 0,
//	        title: {
//	            text: 'Solution Counts',
//	            align: 'middle'
//	        },
//	        labels: {
//	            overflow: 'justify'
//	        },
//	        gridLineWidth: 0
//	    },
//	    tooltip: {
//	        valueSuffix: ' Project'
//	    },
//	    plotOptions: {
//	        column: {
//// borderRadius: '50%',
//	            dataLabels: {
//	                enabled: true,
////	                format: '{point.y}'
//	                formatter: function() {
//	                    // Only show data label if the value is greater than 0
//	                    return this.y !== 0 ? this.y : '';
//	                }
//	            },
//	            groupPadding: 0.1
//	        }
//	    },
//	    legend: {
//	        layout: 'horizontal',
//	        align: 'right',
//	        verticalAlign: 'top',
//	        x: 2,
//	        y: -10,
//	        floating: false,
//	        borderWidth: 1,
//	        backgroundColor: 
//	        	Highcharts.defaultOptions.legend.backgroundColor || '#FFFFFF',
//	        shadow: true
//	    },
//	   
//	    credits: {
//	        enabled: false
//	    },
//	    series: 
//	    	response[1]
//	});
	containerDiv.style.height = '420px';
		} else {
			containerDiv.style.height = '320px';

			var noDataMessage = document.createElement('h6');
			noDataMessage.textContent = 'No data available';

			containerDiv.innerHTML = '';  
			containerDiv.style.display = 'flex';  
			containerDiv.style.flexDirection = 'column'; 
			containerDiv.style.alignItems = 'center';  
			containerDiv.style.justifyContent = 'flex-start'; 
			containerDiv.style.textAlign = 'center';  
			noDataMessage.style.marginTop = '20px';
			containerDiv.appendChild(noDataMessage);
		}	
		},
        error: function(xhr, status, error) {
            console.error("AJAX error:", status, error);
        }
			
	});
	
	
}





function getChartByTeam(chart) {
	var chartName = "";
	
	if(chart === "F_HEAD"){
		chartName= "containerDiv1";
	} else if( chart === "AM_DM") {
		chartName ="containerDiv2" ;
	} else if(chart === "TEAM_LEADER") {
		chartName ="containerDiv3";
	}
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getTeamChart";

	
	$('#spin2').show();

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data: "chartName=" +chart,
		success : function(data4) {
			$('#spin2').hide();
//			alert("data4 :: "+data4);
//			console.log("datttaa :: "+data4)
			
			var response = data4;
			
   if(response != "") {
	   
//	   $("#solSelectDiv").show();
	
	Highcharts.chart(chartName, {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: ''
	    },

	    xAxis: {
	        categories: response[0],
	        title: {
	            text: 'Phase',
	            align: 'middle'
	        },
	        gridLineWidth: 1,
	        lineWidth: 0
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: 'Solution Counts',
	            align: 'middle'
	        },
	        labels: {
	            overflow: 'justify'
	        },
	        gridLineWidth: 0
	    },
	    tooltip: {
	        valueSuffix: ' Project'
	    },
	    plotOptions: {
	        column: {
// borderRadius: '50%',
	            dataLabels: {
	                enabled: true,
//	                format: '{point.y}'
	                formatter: function() {
	                    return this.y !== 0 ? this.y : '';
	                }
	            },
	            groupPadding: 0.1
	        }
	    },
	    legend: {
	        layout: 'horizontal',
	        align: 'right',
	        verticalAlign: 'top',
//	        horizontalAlign: 'top',
	        x: 2,
	        y: -10,
	        floating: false,
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
	containerDiv.style.height = '420px';
		} else {
//			containerDiv.style.height = '320px';
//
//			var noDataMessage = document.createElement('h6');
//			noDataMessage.textContent = 'No data available';
//
//			containerDiv.innerHTML = '';  
//			containerDiv.style.display = 'flex';  
//			containerDiv.style.flexDirection = 'column'; 
//			containerDiv.style.alignItems = 'center';  
//			containerDiv.style.justifyContent = 'flex-start'; 
//			containerDiv.style.textAlign = 'center';  
//			noDataMessage.style.marginTop = '20px';
//			containerDiv.appendChild(noDataMessage);
		}	
		},
        error: function(xhr, status, error) {
            console.error("AJAX error:", status, error);
        }
			
	});
	
	
}

















function getChartDetailsBySolution() {
	
	
	 var selectedValues = [];
		$("#solutionName :selected").each(function() {
			selectedValues.push($(this).val());
		});

		var selectedSoln = selectedValues.toString();
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/PMS/getTaskChart";
	var serviceUrl = base_url + "/PMS/getSolutionChart";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data: "solution=" +selectedSoln,
		success : function(data4) {
// alert("data4 :: "+data4);
			console.log("datttaa :: "+data4)
			
			var response = data4;
			
   if(response != "") {
	   	
	Highcharts.chart('containerDiv', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: ''
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
	        x: -20,
	        y: -10,
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
	containerDiv.style.height = '420px';
		} 
		},
        error: function(xhr, status, error) {
            console.error("AJAX error:", status, error);
        }
			
	});

}



function getDetailsModal1(fHName) {
//	alert(fHName);
	$("#TaskModalss").modal('show');
	var type = "fh";
	$("#nameSpan").text(fHName);
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	// var serviceUrl = base_url + "/PMS/getOpTaskByCustomer"; 
	var serviceUrl = base_url + "/PMS/getTaskByName"; 

	$.ajax({
	    url: serviceUrl,
	    type: 'POST',
	    dataType: 'json',
	    data: { selectedName: encodeURIComponent(fHName), type: type }
	}).done(function(data2) {

	    $('#TaskDetailsByName tbody').empty(); // Clear existing data

	    var Sr_no = 0;
	    
	    if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	            Sr_no = Sr_no + 1;
	            var Srno = Sr_no;
	            var Producttool = project.name;
	            var Desc = project.description;
	            var Manager = project.manager;
	            var Status = project.status;
	            var targetDate = project.targetDate;
	            var Dev = project.pending;

	            var row = '<tr>' +
	                '<td>' + (Srno ? Srno : 'NA') + '</td>' +
	                '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
	                '<td>' + (Desc ? Desc : 'NA') + '</td>' +
	                '<td>' + (Manager ? Manager : 'NA') + '</td>' +
	                '<td>' + (Status ? Status : 'NA') + '</td>' +
	                '<td>' + (targetDate ? targetDate : 'NA') + '</td>' +
	                '<td>' + (Dev ? Dev : 'NA') + '</td>' +
	                '</tr>';
	                
	            $('#TaskDetailsByName tbody').append(row);
	        });
	    } else {
	        // Display message if no data is found, ensure colspan matches the number of columns
	        $('#TaskDetailsByName tbody').append('<tr><td colspan="6">No Activities found</td></tr>');
	    }
	});
    
	
	$("#TaskModal").modal('show');
}




function getDetailsBySolution1(solution) {
//	alert(solution);
	var type = "solution";
	
	$("#solutionNameSpan").text(solution);
	
 	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getOpTaskByCustomer";
    var serviceUrl = base_url + "/PMS/getTaskByName";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: { selectedName: encodeURIComponent(solution), type: type } 

    }).done(function(data2) {
//    	alert("niininiii "+data2)
      $('#TaskDetailsBysoln tbody').empty();
    	
      var Sr_no = 0;

	    if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	            Sr_no = Sr_no + 1;
	            var Srno = Sr_no;
	            var Producttool = project.name;
	            var Desc = project.description;
	            var Manager = project.manager;
	            var Status = project.status;
	            var targetDate = project.targetDate;
	            var Dev = project.pending;

	            var row = '<tr>' +
	                '<td>' + (Srno ? Srno : 'NA') + '</td>' +
	                '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
	                '<td>' + (Desc ? Desc : 'NA') + '</td>' +
	                '<td>' + (Manager ? Manager : 'NA') + '</td>' +
	                '<td>' + (Status ? Status : 'NA') + '</td>' +
	                '<td>' + (targetDate ? targetDate : 'NA') + '</td>' +
	                '<td>' + (Dev ? Dev : 'NA') + '</td>' +
	                '</tr>';

          $('#TaskDetailsBysoln tbody').append(row);
      });
      } else {
          $('#TaskDetailsBysoln tbody').append('<tr><td colspan="7">No Activities found</td></tr>');
      }
  });
    
	
	$("#TaskModalSolution").modal('show');
}





function getDetailsByDate(clickDate) {
//	alert(solution);
	
	$("#dateSpan").text(clickDate);
	
 	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getOpTaskBySolution";
    var serviceUrl = base_url + "/PMS/getDetailsBySelectedDate";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: { clickDate: encodeURIComponent(clickDate) } 
    	data: 'clickDate=' + clickDate,

    }).done(function(data2) {
//    	alert("niininiii "+data2)
      $('#TaskDetailsByDate tbody').empty();
    	
    	var Sr_no=0;
    	
      if (data2 && data2.length > 0) {
    	 
          data2.forEach(function(project) {
        	  Sr_no = Sr_no+1;
        	  var Srno = Sr_no;
              var Customer = project[0];
              var solution = project[1];
              var Desc = project[2];
              var endDate = project[3];
              var manager = project[4];
              var Status = project[5];
              var PendingWith = project[6];
              var Delay = project[7];

              
              var row = '<tr>' +
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +
              '<td>' + (Customer ? Customer : 'NA') + '</td>' +
              '<td>' + (solution ? solution : 'NA') + '</td>' +
              '<td>' + (Desc ? Desc : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (Status ? Status : 'NA') + '</td>' +
              '<td>' + (PendingWith ? PendingWith : 'NA') + '</td>' ;
              if (Delay === '0') {
                  row += '<td style="color:green;">' + (Delay ? Delay : '0') + '</td>';
              } else {
                  row += '<td style="color:red;">' + (Delay ? Delay : '0') + '</td>';
              }

              row += '</tr>';
          $('#TaskDetailsByDate tbody').append(row);
      });
      } else {
          $('#TaskDetailsByDate tbody').append('<tr><td colspan="8">No Activities found</td></tr>');
      }
  });
    
	
	$("#TaskModalDate").modal('show');
}


function getDetailsModalbyCount(mainData , countType) {
//	alert("data : "+mainData+" | countName : "+countType)
	
//	alert(solution);
	if(countType.includes("customer")) {
		$("#headerSpan").text("Customer Name : "+mainData);
	} else if(countType.includes("date")) {
		$("#headerSpan").text("Date : " +mainData);
	} else if(countType.includes("solution")) {
		$("#headerSpan").text("Solution Name : "+mainData);
	}
	
 	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getDetailsByCount";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
    	data: 
        { 	mainData: encodeURIComponent(mainData),
        	countType: countType
        }

    }).done(function(data2) {
//    	alert("niininiii "+data2)
      $('#TaskDetailsByCounts tbody').empty();
      $('#TaskDetailsByCounts').DataTable().clear().destroy();
    	
    	var Sr_no=0;
    	
      if (data2 && data2.length > 0) {
    	 
          data2.forEach(function(project) {
        	  Sr_no = Sr_no+1;
        	  var Srno = Sr_no;
              var Customer = project[0];
              var solution = project[1];
              var Desc = project[2];
              var endDate = project[3];
              var manager = project[4];
              var Status = project[5];
              var PendingWith = project[6];
              var Delay = project[7];

              
              var row = '<tr>' +
              '<td>' + (Srno ? Srno : 'NA') + '</td>' +
              '<td>' + (Customer ? Customer : 'NA') + '</td>' +
              '<td>' + (solution ? solution : 'NA') + '</td>' +
              '<td>' + (Desc ? Desc : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (Status ? Status : 'NA') + '</td>' +
              '<td>' + (PendingWith ? PendingWith : 'NA') + '</td>';

          if (Delay === '0') {
              row += '<td style="color:green;">' + (Delay ? Delay : '0') + '</td>';
          } else {
              row += '<td style="color:red;">' + (Delay ? Delay : '0') + '</td>';
          }

          row += '</tr>';

          $('#TaskDetailsByCounts tbody').append(row);
      });
      } else {
          $('#TaskDetailsByCounts tbody').append('<tr><td colspan="8">No Activities found</td></tr>');
      }
  });
    
	
	$("#TaskModalCounts").modal('show');

	
}


