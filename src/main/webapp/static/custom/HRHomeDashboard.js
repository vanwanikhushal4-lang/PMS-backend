var activity_count1="";
var activity_count2="";
var activity_count3="";


var top_performer_1="";
var top_performer_2="";
var top_performer_3="";


$('#searchBox').on('keyup', function() {
    var value = $(this).val().toLowerCase();
    $('#getemployeedataforhr tbody tr').filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});


$('#searchBoxActiveEmps').on('keyup', function() {
    var value = $(this).val().toLowerCase();
    $('#getActiveEmpsOnPmsModalTable tbody tr').filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});



$('#searchBoxTotalEmps').on('keyup', function() {
    var value = $(this).val().toLowerCase();
    $('#completedProjectsTable tbody tr').filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});


var roleType = $("#role").val();
var designation = $("#designation").val();
var mainTable = "";
var chartDonut = ""; 
var pieChartName = "";
var barChartName = "";
var nameManager= "";
var productsuite="";
var productmanager="";
var teamleader="";
var Actproductsuite="";
var Actproductmanager="";
var Actteamleader="";
var radioClickedMgr= "";
var radioClickedTL= "";
var radioClickedDev = ";"
var radioClickedSupport = ";"
//	var allowedRoles = ["MD", "Admin", "Sales_Initiator", "Sales_Manager", "Collection_Manager", "Implementor", "Support_Manager","Account_Manager"];
var allowedRoles = ["MD", "Admin", "Sales_Initiator", "Sales_Manager", "Collection_Manager", "Support_Manager","Account_Manager"];

	if (allowedRoles.includes(roleType)) {
	    $("#homeCharts").show();
	    $("#developerChart").hide();
	} else if (roleType === "Developer"){
		$("#developerChart").show();
	    $("#homeCharts").hide();
	    
	} else {
		$("#homeCharts").hide();
		$("#developerChart").hide();
	}
	
	
window.onload = function() {
//	alert(roleType)
//	alert("designation"+designation)
	
	checkRadioButtonSupportTeam();
	checkRadioButtonSupport();
	if(roleType === "MD" || roleType ==="Head_Projects"){
		$('#MDdashboard').show();
		mainTable = "ProjectDetails";
		chartDonut = "containerManager"
			barChartName = "bar_containerMD" 
	} else if(roleType === "Implementor"){//changes made here || roleType ==="Support_Manager"
		$('#ManagerDashboard').show();
		$('#supportbothTables').hide();
		mainTable = "ProjectDetailsManager";
		barChartName = "bar_containerManager"
	} 
	
	//01/08
	else if(roleType === "Support_Manager"){
		$('#ManagerDashboard').show();
		
		$('#managerbothTables').hide();
		$('#supportbothTables').show();
		
		mainTable = "ProjectDetailsManager";
//		mainTable = "ProjectDetailsSupport";
	
		barChartName = "bar_containerManager"
	} else if(roleType === "HR"){
        $('#HRDashboard').show();
        
        
        //New Employees
        var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        var serviceUrl = base_url + "/PMS/getEmployeeDataOfNewEmps";
        

        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            success: function(data2) {
//            	alert("data:"+data2);
            	console.log(data2);
            	
            	
            	var categories = [];
                var seriesData = [];

                data2.forEach(function(item) {
                    categories.push(item.date);
                    seriesData.push(item.activity_count);
                });
            	
//            	var last15Days = getLast15Days();
            	
            	Highcharts.chart('containerEmpGraph', {
            	    chart: {
            	        type: 'area'
            	    },
            	    title: {
            	        text: 'Activities Uploaded'  
            	    },
            	    xAxis: {
//            	        categories: [
//            	       //     '01/09', '02/09', '03/09', '04/09', '05/09', '06/09', '07/09', '08/09', '09/09',
//            	        //    '10/09', '11/09', '12/09','13/09', '14/09',
//
//							'15/09', '16/09', '17/09', '18/09', '19/09', '20/09', '21/09',
//            	            '22/09', '23/09', '24/09','25/09', '26/09', '27/09', '28/09', '29/09', '30/09', '31/09'
//            	        ],
            	    	categories: categories,
            	        title: {
                            text: 'Dates'
                        }
            	    },
            	    yAxis: {
            	        title: {
                            text: 'Counts'
                        },
            	    	min: 0,       
                        max: 150,     
                        tickInterval: 30 ,
            	    },
            	    legend: {
                        enabled: false 
                    },
            	    plotOptions: {
            	        series: {
            	            fillOpacity: 0.1
            	        }
            	    },

            	    series: [{
//            	        data: [
//            	            22, 28, 17, 8, 15, 15, 14, 19, 31, 28,
//            	            16, 21, 22, 26, 12, 24
//            	        ]
            	    	data: seriesData
            	    }]
            	});
            	
            }
        });
        
        //
        
        
        
        
        var l = window.location;
        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
        var serviceUrl = base_url + "/PMS/getEmployeeCountsByRole";

        const currentYear = new Date().getFullYear();
        const formattedYear = `Year ${currentYear}`;
        
        $.ajax({
            type: 'POST',
            url: serviceUrl,
            dataType: 'json',
            success: function(data2) {
//            	alert("data:"+data2);
            	console.log(data2);
            	
            	Highcharts.chart('containerEmpRole', {
                    chart: {
                        type: 'bar'
                    },
                    title: {
                        text: 'Employee Counts by Role',
                        align: 'left'
                    },
//                    subtitle: {
//                        text: 'Source: <a ' +
//                            'href="https://en.wikipedia.org/wiki/List_of_continents_and_continental_subregions_by_population"' +
//                            'target="_blank">Wikipedia.org</a>',
//                        align: 'left'
//                    },
                    xAxis: {
                        categories: ['Head-Projects','Sales','Accounts','HR','Managers','Team-Leaders','Developers','Testers','Support'],
                        title: {
                            text: null
                        },
                        gridLineWidth: 1,
                        lineWidth: 0
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Counts',
                            align: 'high'
                        },
                        labels: {
                            overflow: 'justify'
                        },
                        gridLineWidth: 0
                    },
                    tooltip: {
                        valueSuffix: ' Employees'
                    },
                    plotOptions: {
                        bar: {
                            borderRadius: '2%',
                            dataLabels: {
                                enabled: true
                            },
                            groupPadding: 0.1
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'top',
                        x: -40,
                        y: 80,
                        floating: true,
                        borderWidth: 1,
                        backgroundColor:
                            Highcharts.defaultOptions.legend.backgroundColor || '#FFFFFF',
                        shadow: true
                    },
                    credits: {
                        enabled: false
                    },
                    series: [{
                        name: formattedYear,
                        data: data2[0][0]
                    }]
                });
            	
            }
        });
        
        
        
        
        
        
        
      //06/11
        var serviceUrl = base_url + "/PMS/getAllFeedbackCounts";
                

                $.ajax({
                    type: 'POST',
                    url: serviceUrl,
                    dataType: 'json',
                    success: function(data2) {
//                    	alert(data2);
//                    	
            			$('#grievanceCount').text(data2[0][0]);
//            			$('#man_satisfaction').text(data2[0][1]);
            			
            			var satisfaction = parseFloat(data2[0][1]); 
	           		    var formattedSatisfaction = satisfaction.toFixed(1); 
//	           		    alert(formattedSatisfaction);
	           		    if(formattedSatisfaction=="NaN" || formattedSatisfaction=="undefined" || formattedSatisfaction==null)
	           		    {
		           		    $('#man_satisfaction').text("0");
	           		    }
	           		    else
	           		    {
		           		    $('#man_satisfaction').text(formattedSatisfaction);
	           		    }
                    }
                });
                //
                
                
                //06/11
                var serviceUrl = base_url + "/PMS/getTopThreePerformers";
                        

                        $.ajax({
                            type: 'POST',
                            url: serviceUrl,
                            dataType: 'json',
                            success: function(data2) {
//                            	alert(data2);
                            	var top1=data2[0][0][0];
                            	top_performer_1=top1;
//                            	alert(top1);
                            	var initials1 = getInitials(top1);
                            	activity_count1=data2[0][0][1];
                            	
                            	
                            	var top2 = data2[1][0][0];
                            	top_performer_2=top2;
//                            	alert(top2);
                            	var initials2 = getInitials(top2);
                            	activity_count2=data2[1][0][1];
                            	
                            	var top3=data2[2][0][0];
                            	top_performer_3=top3;
//                            	alert(top3);
                            	var initials3 = getInitials(top3);
                            	activity_count3=data2[2][0][1];
                            	
                            	document.getElementById("performer1").textContent = initials1;
                            	document.getElementById("performer2").textContent = initials2;
                            	document.getElementById("performer3").textContent = initials3;
                            	         
                            }
                        });
                        
                        
                        
                        function getInitials(name) {
                            var names = name.split(' ');
                            var initials = names.map(function(n) {
                                return n.charAt(0).toUpperCase();
                            }).join('');
                            return initials;
                        }
                        //
                        
                        
                        
                      //07/11
                        var serviceUrl = base_url + "/PMS/getHiredComapreCounts";
                                

                                $.ajax({
                                    type: 'POST',
                                    url: serviceUrl,
                                    dataType: 'json',
                                    success: function(data2) {
//                                    	alert(data2);
                                    	
                                    	var currentMonthCount = data2[0].difference;
//                                    	$('#hired_compare_counts').text(currentMonthCount);
                                    	
                                    	var $countElement = $('#hired_compare_counts');
                                    	$countElement.text(currentMonthCount);
                                    	if (currentMonthCount < 0) {
                                    	    $countElement.css('color', 'red');  
                                    	} else {
                                    	    $countElement.css('color', 'green');  
                                    	}
//                                    	
//                            			$('#hired_compare_counts').text(data2[0][0]);
//                            			
                                    }
                                });
        
        

} else if(roleType ==="Collection_Manager"){
	$('#CollectionManagerDash').show();
	mainTable = "ProjectDetailsCM";
}
	//
	
	else if(designation === "Jr. Team Leader"||designation === "Sr Team Leader"||designation === "Team Leader" && roleType!="Tester"){
		$('#TeamLeaderDashboard').show();
		pieChartName="TLContainer";
		mainTable = "ProjectDetailTL";
		chartDonut = "containerTeamMember"
		
	} else if(roleType === "Developer"){
		$('#DeveloperDashboard').show();
		$('#supportteambothtables').hide();
		$('#testerteambothtables').hide();
		pieChartName="DevContainer";
		mainTable = "ProjectDetailsDev";
		chartDonut = "containerDeveloper"
		
	}
	else if(roleType === "Support"){
		$('#DeveloperDashboard').show();
		$('#developerteambothtables').hide();
		$('#testerteambothtables').hide();
		$('#supportteambothtables').show();
		pieChartName="DevContainer";
		mainTable = "ProjectDetailssupportteam";
		chartDonut = "containerDeveloper"
		
	}
	else if(roleType === "Tester"){
		$('#DeveloperDashboard').show();
		$('#supportteambothtables').hide();
		$('#developerteambothtables').hide();
		pieChartName="DevContainer";
		mainTable = "ProjectDetailstesterteam";
		chartDonut = "containerDeveloper"
		
	}
	
	// alert("abc")
//	alert("roleType "+$("#role").val());
	

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/PiechartPMS";
	$("#spin1").show();
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data2) {
			$("#spin1").hide();
	//		 alert("hxgdfg "+data2)
			
			if(roleType === "Developer" || roleType === "Support" || roleType === "Tester"){
			//	alert("DAT "+data2)
				var data = [
				    {
				        name: 'Pending Tasks',
				        y: data2[3],
				        url: window.location.href.replace('/Admin/AdminHome', '/Admin/Activitydetails'),
				        color: "rgb(44,175,254)"

				    },
				    {
				        name: 'Completed Tasks',
				        y: data2[4],
//				        url: 'scheduleMeetings'
				        url: window.location.href.replace('/Admin/AdminHome', '/Admin/ActivityCompletedDetails'),
				        color:"rgb(109,104,222)"
				    }
				]
				
			} 
//			if(roleType === "Support"){
//				//	alert("DAT "+data2)
//					var data = [
//					    {
//					        name: 'Pending Tasks',
//					        y: data2[3],
//					        url: window.location.href.replace('/Admin/AdminHome', '/Admin/Activitydetails'),
//					        color: "rgb(44,175,254)"
//
//					    },
//					    {
//					        name: 'Completed Tasks',
//					        y: data2[4],
////					        url: 'scheduleMeetings'
//					        url: window.location.href.replace('/Admin/AdminHome', '/Admin/ActivityCompletedDetails'),
//					        color:"rgb(109,104,222)"
//					    }
//					]
//					
//				} 
			
			else {
				var data = [
				    {
				        name: 'RD',
				        y: data2[0],
				        url: (roleType === "Sales_Initiator" || roleType === "Implementor" || roleType === "MD") ? ' pendingRdDocumentsBySI' : ''
				    },
				    {
				        name: 'UD',
				        y: data2[1],
				//        sliced: true,
				  //      selected: true,
				        url: (roleType === "Sales_Manager" || roleType === "Implementor" || roleType === "MD" || roleType === "Collection_Manager") 
				        ? window.location.href.replace('/Admin/AdminHome', '/User') + '/ViewApprovedUdbyMD' 
				        : ''

				    },
				    {
				        name: 'Kick off Meeting',
				        y: data2[2],
				        url: (roleType === "Sales_Manager" || roleType === "MD" || roleType === "Collection_Manager") ? 'scheduleMeetings' : ''
				    }
				];
				if (roleType === "Implementor") {
				    data.push({
				        name: 'Assigned Task(Pending)',
				        y: data2[3],		
				        url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ImplPendingTasks'  
				    },{
				        name: 'Assigned Task(Completed)',
				        y: data2[4],
				        url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ImplCompletedTasks'
				    });
				}
			}
						
			Highcharts.chart(pieChartName, {
				 chart: {
				        type: 'pie',
				        options3d: {
				            enabled: true,
				            alpha: 45,
				            beta: 0
				        }
				    },
			    title: {
			        text: ''
			    },
			    plotOptions: {
			        pie: {
			            allowPointSelect: true,
			            cursor: 'pointer',
			            depth: 35,
			            dataLabels: {
			                enabled: true,
			                distance: 20
			            },
			            showInLegend: true,
			            point: {
			                events: {
			                    click: function() {
			                    	 if (this.url) {
			                             window.location.href = this.url;
			                    }	}
			                }
			            }
			        }
			    },
			    legend: {
			        align: 'bottom',
			        layout: 'horizontal',
			        y: 20,
			        itemStyle: {
			            fontSize: '0.8em'
			        }
			    },
			    series: [{
			        name: 'Total',
			        colorByPoint: true,
			        data: data,
			        dataLabels: [{
			            enabled: true,
			            distance: 20
			        }, {
			            enabled: true,
			            distance: -40,
			            format: '{point.y:.0f}',
			            style: {
			                fontSize: '1.2em',
			                textOutline: 'none',
			                opacity: 0.7
			            },
			            filter: {
			                operator: '>',
			                property: 'y',
			                value: 10
			            }
			        }]
			    }]
			});


		}
	});
	
	
	
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/BarchartSCM";

	$("#spin2").show();
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(response) {
			$("#spin2").show();
		//	 alert("Bar chart "+data[0])
				
			// Bar Chart Data 
			if(roleType=== "Sales_Initiator"){
				Highcharts.chart('bar_container', {
				    chart: {
				        type: 'column',
				        options3d: {
				            enabled: true,
				            alpha: 15,
				            beta: 15,
				            viewDistance: 25,
				            depth: 40
				        },
				        height: 300
				    },
				    title: {
				        text: '',
//				        align: 'center'
				    },
				    xAxis: {
				        categories: ['Commercial Proposal', 'Revise Proposal', 'License Agreement', 'Purchase Order'],
				        labels: {
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    yAxis: {
				        allowDecimals: false,
				        min: 0,
				        title: {
				            text: 'Count',
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    tooltip: {
				        headerFormat: '<b>{point.key}</b><br>',
				        pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y}'
				    },
				    plotOptions: {
				        column: {
				            depth: 40,
				            point: {
				                events: {
				                    click: function() {			                       
				                    	 if (this.url) {
				                             window.location.href = this.url;
				                    	 }
				                    }
				                }
				            }
				        }
				    },
				    series: [{
				        name: 'Pending',   	
				        data: [{
				            y: response[0][0],
				           // url: 'vlxProposalSendByme'
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/vlxProposalSendByme'  
				        }, {
				            y: response[0][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ReviseCommercialProposalSendBySI'
				        }, {
				            y: response[0][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ViewCreatedVeloxLicense'
				        }, {
				            y: response[0][3], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/poRaisedByme'
				        }]
				    }, {
				        name: 'Approved',
					    data: [{
				            y: response[1][0],
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/vlxProposalapr'
				        }, {
				            y: response[1][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ReviseCommercialProposalSendBySI'
				        }, {
				            y: response[1][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedProposalLicenseDetailsBH'
				        }, {
				            y: response[1][3], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/purchaseorderapr'
				        }]
				    }, {
				        name: 'Rejected',
				        data: [{
				            y: response[2][0],
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/vlxProposalRejectedMD'
				        }, {
				            y: response[2][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/revisedProposalRejectedSI'
				        }, {
				            y: response[2][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/LicenseRejectedFeedbackSI'
				        }, {
				            y: response[2][3], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/PurchaseOrderRejectedSI'
				        }],
				        color: 'orange'
				    }]
			    
				});
				
		// Sales_Manager
			} else if(roleType=== "Sales_Manager"){
				Highcharts.chart('bar_container', {
				    chart: {
				        type: 'column',
				        options3d: {
				            enabled: true,
				            alpha: 15,
				            beta: 15,
				            viewDistance: 25,
				            depth: 40
				        }
				    },
				    title: {
				        text: 'SCM',
				        align: 'center'
				    },
				    xAxis: {
				        categories: ['Commercial Proposal', 'Revise Proposal', 'License Agreement', 'Purchase Order'],
				        labels: {
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    yAxis: {
				        allowDecimals: false,
				        min: 0,
				        title: {
				            text: 'Count',
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    tooltip: {
				        headerFormat: '<b>{point.key}</b><br>',
				        pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y}'
				    },
				    plotOptions: {
				        column: {
				            depth: 40,
				            point: {
				                events: {
				                    click: function() {			                       
				                    	 if (this.url) {
				                             window.location.href = this.url;
				                    	 }
				                    }
				                }
				            }
				        }
				    },
				    series: [{
				        name: 'Pending',   	
				        data: [{
				            y: response[0][0],
				           // url: 'vlxProposalSendByme'
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingApprSalesMng'  
				        }, {
				            y: response[0][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingRevisedProposalSMApproval'
				        }, {
				            y: response[0][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingProposalLicenseSM'
				        }, {
				            y: response[0][3], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingSMFormApp'
				        }]
				    }, {
				        name: 'Approved',
					    data: [{
				            y: response[1][0],
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/vlxProposalapr'
				        }, {
				            y: response[1][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedRevisedProposalSMDetails'
				        }, {
				            y: response[1][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedLicenseList'
				        }, {
				            y: response[1][3], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedPOByCM'
				        }]
				    }, {
				        name: 'Rejected',
				        data: [{
				            y: response[2][0],
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/FeedbackRejectedSM'
				        }, {
				            y: response[2][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/RejectedRevisedProposalSM'
				        }, {
				            y: response[2][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/LicenseRejectedSM'
				        }, {
				            y: response[2][3], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/PORejectedByCM'
				        }],
				        color: 'orange'
				    }]
			    
				});
				
				
			// Collection Manager
			} else if(roleType=== "Collection_Manager12"){
				Highcharts.chart('bar_container', {
				    chart: {
				        type: 'column',
				        options3d: {
				            enabled: true,
				            alpha: 15,
				            beta: 15,
				            viewDistance: 25,
				            depth: 40
				        }
				    },
				    title: {
				        text: 'SCM',
				        align: 'center'
				    },
				    xAxis: {
				        categories: ['Registration Form', 'License Agreement', 'Purchase Order'],
				        labels: {
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    yAxis: {
				        allowDecimals: false,
				        min: 0,
				        title: {
				            text: 'Count',
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    tooltip: {
				        headerFormat: '<b>{point.key}</b><br>',
				        pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y}'
				    },
				    plotOptions: {
				        column: {
				            depth: 40,
				            point: {
				                events: {
				                    click: function() {			                       
				                    	 if (this.url) {
				                             window.location.href = this.url;
				                    	 }
				                    }
				                }
				            }
				        }
				    },
				    series: [{
				        name: 'Pending',   	
				        data: [{
				            y: response[0][0], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingCustomer'
				        }, {
				            y: response[0][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedProposalLicenseDetailsBH'
				        }, {
				            y: response[0][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingAppr'
				        }]
				    }, {
				        name: 'Approved',
					    data: [{
				            y: response[1][0], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedCMRegistFormDetails'
				        }, {
				            y: response[1][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/SentLicenseMailList'
				        }, {
				            y: response[1][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedCollnMngDetails'
				        }]
				    }, {
				        name: 'Rejected',
				        data: [{
				            y: response[2][0], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/RejectedCMRegistFormDetails'
				        }, {
				            y: response[2][1], 
				            url: ''
				        }, {
				            y: response[2][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/RejectedCMDetails'
				        }],
				        color: 'orange'
				    }]
			    
				});
			
				
			}  else if(roleType=== "MD"){
				Highcharts.chart('bar_containerMD', {
				    chart: {
				        type: 'column',
				        options3d: {
				            enabled: true,
				            alpha: 15,
				            beta: 15,
				            viewDistance: 25,
				            depth: 40
				        },
				        height: 350
				    },
				    title: {
				        text: '',
				        align: 'center'
				    },
				    xAxis: {
				        categories: ['Registration Form','Commercial Proposal', 'Revise Proposal','Purchase Order'],
				        labels: {
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    yAxis: {
				        allowDecimals: false,
				        min: 0,
				        title: {
				            text: 'Count',
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    tooltip: {
				        headerFormat: '<b>{point.key}</b><br>',
				        pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y}'
				    },
				    plotOptions: {
				        column: {
				            depth: 40,
				            point: {
				                events: {
				                    click: function() {			                       
				                    	 if (this.url) {
				                             window.location.href = this.url;
				                    	 }
				                    }
				                }
				            }
				        }
				    },
				    series: [{
				        name: 'Pending',   	
				        data: [{
				            y: response[0][0],
				           // url: 'vlxProposalSendByme'
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/raisedCustomer'  
				        }, {
				            y: response[0][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingVlxProposal'
				        }, {
				            y: response[0][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingRevisedProposalMD'
				        }, {
				            y: response[0][3], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/poRaisedByme'
				        }],
				        color : "rgb(44,175,254)"
				    }, {
				        name: 'Approved',
					    data: [{
				            y: response[1][0],
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedCMRegistFormDetails'
				        }, {
				            y: response[1][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedMDDetails'
				        }, {
				            y: response[1][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/revisedProposalApprovedDetailsMD'
				        }, {
				            y: response[1][3], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedCollnMngDetails'
				        }],
				        color: 'rgb(84,79,197)'
				    }, {
				        name: 'Rejected',
				        data: [{
				            y: response[2][0],
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/RejectedCMRegistFormDetails'
				        }, {
				            y: response[2][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/RejectMDDetails'
				        }, {
				            y: response[2][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/RejectedRevisedProposalSM'
				        }, {
				            y: response[2][3], 
				            url: ''
				        }],
				        color: 'orange'
				    }]
			    
				});
				
				
			} else if(roleType=== "Head_Projects" || roleType ==="Collection_Manager"){
				Highcharts.chart('bar_containerMD', {
				    chart: {
				        type: 'column',
				        options3d: {
				            enabled: true,
				            alpha: 15,
				            beta: 15,
				            viewDistance: 25,
				            depth: 40
				        },
				        height: 350
				    },
				    title: {
				        text: '',
				        align: 'center'
				    },
				    xAxis: {
				        categories: ['Registration Form','Commercial Proposal', 'Revise Proposal','Purchase Order'],
				        labels: {
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    yAxis: {
				        allowDecimals: false,
				        min: 0,
				        title: {
				            text: 'Count',
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    tooltip: {
				        headerFormat: '<b>{point.key}</b><br>',
				        pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y}'
				    },
				    plotOptions: {
				        column: {
				            depth: 40,
				            point: {
				                events: {
				                    click: function() {			                       
				                    	 if (this.url) {
				                             window.location.href = this.url;
				                    	 }
				                    }
				                }
				            }
				        }
				    },
				    series: [{
				        name: 'Pending',   	
				        data: [{
				            y: response[0][0],
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/raisedCustomer'  
				        }, {
				            y: response[0][1], 
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingVlxProposal'
				        }, {
				            y: response[0][2], 
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingRevisedProposalMD'
				        }, {
				            y: response[0][3], 
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/poRaisedByme'
				        }],
				        color : "rgb(44,175,254)"
				    }, {
				        name: 'Approved',
					    data: [{
				            y: response[1][0],
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedCMRegistFormDetails'
				        }, {
				            y: response[1][1], 
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedMDDetails'
				        }, {
				            y: response[1][2], 
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/revisedProposalApprovedDetailsMD'
				        }, {
				            y: response[1][3], 
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedCollnMngDetails'
				        }],
				        color: 'rgb(84,79,197)'
				    }, {
				        name: 'Rejected',
				        data: [{
				            y: response[2][0],
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/RejectedCMRegistFormDetails'
				        }, {
				            y: response[2][1], 
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/RejectMDDetails'
				        }, {
				            y: response[2][2], 
//				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/RejectedRevisedProposalSM'
				        }, {
				            y: response[2][3], 
				            url: ''
				        }],
				        color: 'orange'
				    }]
			    
				});
				
				
			}  else if(roleType=== "Business_Head" || roleType=== "Admin"){
				Highcharts.chart('bar_container', {
				    chart: {
				        type: 'column',
				        options3d: {
				            enabled: true,
				            alpha: 15,
				            beta: 15,
				            viewDistance: 25,
				            depth: 40
				        }
				    },
				    title: {
				        text: 'SCM',
				        align: 'center'
				    },
				    xAxis: {
				        categories: ['Commercial Proposal','Manual Commercial Proposal','License Agreement', 'Revise Proposal'],
				        labels: {
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    yAxis: {
				        allowDecimals: false,
				        min: 0,
				        title: {
				            text: 'Count',
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    tooltip: {
				        headerFormat: '<b>{point.key}</b><br>',
				        pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y}'
				    },
				    plotOptions: {
				        column: {
				            depth: 40,
				            point: {
				                events: {
				                    click: function() {			                       
				                    	 if (this.url) {
				                             window.location.href = this.url;
				                    	 }
				                    }
				                }
				            }
				        }
				    },
				    series: [{
				        name: 'First Approved(SM)',   	
				        data: [{
				            y: response[0][0],
				           // url: 'vlxProposalSendByme'
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedSalesMngDetails'  
				        }, {
				            y: response[0][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedManualProposalDetailsSM'
				        }, {
				            y: response[0][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedProposalLicenseSMDetails'
				        }, {
				            y: response[0][3], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedRevisedProposalSMDetails'
				        }]
				        
				        
				    }, {
				        name: 'Second Approved',
					    data: [{
				            y: response[1][0],
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedMDDetails'
				        }, {
				            y: response[1][1], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedManualProposalDetailsMD'
				        }, {
				            y: response[1][2], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedLicenseList'
				        }, {
				            y: response[1][3], 
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/revisedProposalApprovedDetailsMD'
				        }]
//				        color : '#0066cc'
				    }]
			    
				});
				
				
			} else if(roleType=== "Implementor" || roleType=== "Support_Manager"){
				Highcharts.chart('bar_containerManager', {
				    chart: {
				        type: 'column',
				        options3d: {
				            enabled: true,
				            alpha: 15,
				            beta: 15,
				            viewDistance: 25,
				            depth: 40
				        },
				        height: 350
				    },
				    title: {
				        text: '',
				        align: 'center'
				    },
				    xAxis: {
				        categories: ['Form C of Purchase Order'],
				        labels: {
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    yAxis: {
				        allowDecimals: false,
				        min: 0,
				        title: {
				            text: 'Count',
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    tooltip: {
				        headerFormat: '<b>{point.key}</b><br>',
				        pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y}'
				    },
				    plotOptions: {
				        column: {
				            depth: 40,
				            point: {
				                events: {
				                    click: function() {			                       
				                    	 if (this.url) {
				                             window.location.href = this.url;
				                    	 }
				                    }
				                }
				            }
				        }
				    },
				    series: [{
				        name: 'Pending',   	
				        data: [{
				            y: response[0][0],
				           // url: 'vlxProposalSendByme'
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingFORM3'  
				        }],
				        color : "rgb(44,175,254)"
				    }, {
				        name: 'Submitted',
					    data: [{
				            y: response[1][0],
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/getFORM3Submitteddetails'
				        }],
				        color : "rgb(84,79,197)"
				    }]
			    
				});
				
				
			} else if(roleType=== "Account_Manager"){
			//	 alert("dataaa "+response);
				Highcharts.chart('bar_container', {
				    chart: {
				        type: 'column',
				        options3d: {
				            enabled: true,
				            alpha: 15,
				            beta: 15,
				            viewDistance: 25,
				            depth: 40
				        }
				    },
				    title: {
				        text: 'SCM',
				        align: 'center'
				    },
				    xAxis: {
				        categories: ['License Agreement'],
				        labels: {
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    yAxis: {
				        allowDecimals: false,
				        min: 0,
				        title: {
				            text: 'Count',
				            skew3d: true,
				            style: {
				                fontSize: '16px'
				            }
				        }
				    },
				    tooltip: {
				        headerFormat: '<b>{point.key}</b><br>',
				        pointFormat: '<span style="color:{series.color}">\u25CF</span> {series.name}: {point.y}'
				    },
				    plotOptions: {
				        column: {
				            depth: 40,
				            point: {
				                events: {
				                    click: function() {			                       
				                    	 if (this.url) {
				                             window.location.href = this.url;
				                    	 }
				                    }
				                }
				            }
				        }
				    },
				   
				    series: [{
				        name: 'Pending',   	
				        data: [{
				            y: response[0][0],
				           // url: 'vlxProposalSendByme'
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/pendingProposalLicenseBH'  
				        }],
				     //   color : '#ffff99'
				    }, {
				        name: 'Approved',
					    data: [{
				            y: response[1][0],
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/ApprovedLicenseList'
				        }],
				        color: '#008060'
				    }, {
				        name: 'Rejected',
					    data: [{
				            y: response[2][0],
				            url: window.location.href.replace('/Admin/AdminHome', '/User') + '/RejectedProposalLicenseDetailsBH'
				        }],
				        color: '#ff6666'
				    }]
			    
				});
			}
			
		}
	});
	
	
	
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/UserActivity/manualProposalApprovedDetailsMD";
 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
 	$('#spin11').show();
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json', 
        success: function(data5) {
        	$('#spin11').hide();
//alert("hxgdfg "+data5)
//console.log(data5)
			
			if ($.fn.DataTable.isDataTable('#ProjectDetailssupportteam')) {
        		$('#ProjectDetailssupportteam').DataTable().clear().destroy();
            }
        	
            var table = $("#"+mainTable+" ").DataTable({ 
                lengthChange: false,
                pageLength: 10,
                data: data5,
                scrollX: '300px',
//                scrollY: '300px',
                dom: 'Bfrtip', // Add this line to enable export buttons
                buttons:[{
                    extend: 'pdfHtml5',
                    exportOptions: {
                        columns: function (idx, data, node) {
                            // Exclude the first column ("View" column) dynamically
                            return idx !== 0;
                        }
                    },
                    customize: function (doc) {
                        doc.pageOrientation = 'landscape'; // or 'landscape'
                        doc.pageSize = 'A4'; // Customization code here
                    }
                },
                {
                    extend: 'excelHtml5',
                    exportOptions: {
                        columns: function (idx, data, node) {
                            return idx !== 0; // Exclude the first column ("View" column) dynamically
                        }
                    }
                },
                {
                    extend: 'print',
                    exportOptions: {
                        columns: function (idx, data, node) {
                            return idx !== 0; // Exclude the first column ("View" column) dynamically
                        }
                    }
                }],
            columnDefs: [
                {
                    targets: -1, // Target the last column
                    render: function(data, type, row) {
                    if(mainTable!="MDdashboard") {
                    	if(data == 0){
                    		 return '<span style="color: black;">' + data + '</span>';
                    	} else if(data==="NA") {
                   		 	return '<span style="color: black;">' + data + '</span>';
                    	} else {
                    		 return '<span style="color: red;">' + data + '</span>';
                    	}
                        // Customize the rendering to display data in red
                    } else {
                    	return data;
                    }
                    }
                }
            ],
//                "columnDefs": [
//            	    {
//            	      "targets": 2, // Target the second column (index 1, "Status")
//            	      "render": function(data, type, row) {
//            	        if (data === "Approved By MD"|| data==="Manual Proposal MD Approved") {
//            	          return '<span style="color: green;">' + data + '</span>';
//            	        } else {
//            	          return '<span style="color: black;">' + data + '</span>';
//            	        }
//            	      }
//            	    }
//            	  ]
            });
        }
    });
    
    
    
    
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/containerChartData";
	$("#spin1").show();
	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data2) {
			
			$('#VikasProjects').text(data2[0]);
			$('#VivekProjects').text(data2[1]);
			$('#KuldipProjects').text(data2[2]);

		//	alert("dataa "+data2)
Highcharts.chart('containerManager', {
    colors: ['#01BAF2', '#71BF45', '#FAA74B', '#B37CD2'],
    chart: {
        type: 'pie',
        height: 300 
    },
    accessibility: {
        point: {
            valueSuffix: '%'
        }
    },
    title: {
        text: ''
    },
    subtitle: {
        text: ' '
    },
    tooltip: {
        pointFormat: '{series.name}: <b>{point.y}</b>'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '{y}'
            },
            showInLegend: true
        }
    },
    series: [{
        name: 'Projects',
        colorByPoint: true,
        innerSize: '75%',
        data: [{
            name: 'Vikas',
            y: data2[0]
        }, {
            name: 'Vivek',
            y: data2[1]
        }, {
            name: 'Kuldip',
            y: data2[2]
        }]
    }]
});
}
});
	
	
	
	
	
//	var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/PMS/cardDashboardData";
//	$("#spin1").show();
//	$.ajax({
//		type : 'POST',
//		url : serviceUrl,
//		dataType : 'json',
//		success : function(data2) {
////			alert("dataa "+data2[0][0]);
//			
//			$('#MDTotalProjects').text(data2[0][0]);
//			$('#MDOnHoldProjects').text(data2[0][1]);
//			$('#MDCompletedProj').text(data2[0][2]);
//			$('#MDTrackProjects').text(data2[0][3]);
//			$('#MDDelayProj').text(data2[0][4]);
//			$('#MDactivityCompleted').text(data2[0][5]);
//			$('#MDactivity').text(data2[0][6]);
//			$('#MDActivityDelay').text(data2[0][7]);
//			$('#MDactivityCompleted').text(data2[0][8]);
//			
//			//16/03
//			$('#MDTotalActivities').text(data2[0][9]);
//			//
//						
//			$('#ImplTotalProjects').text(data2[0][0]);
//			$('#ImplCompletedProj').text(data2[0][1]);
//			$('#ImplTrackProjects').text(data2[0][2]);
//			$('#ImplDelayProj').text(data2[0][3]);
//			$('#Implactivity').text(data2[0][4]);
//			$('#ImplActivityDelay').text(data2[0][5]);
//			
//		
//			
//			//28/06
//			$('#ManactivityCompleted').text(data2[0][6]);
//			$('#ManOnHoldProjects').text(data2[0][7]);
//			//
//			
//			
//			
//			$('#TLTotalProjects').text(data2[0][0]);
//			$('#TLCompletedProj').text(data2[0][1]);
//			$('#TLTrackProjects').text(data2[0][2]);
//			$('#TLDelayProj').text(data2[0][3]);
//			$('#TLactivity').text(data2[0][4]);
//			$('#TLActivityDelay').text(data2[0][5]);
//	
//			$('#DevTotalProjects').text(data2[0][0]);
//			$('#DevCompletedProj').text(data2[0][1]);
//			$('#DevTrackProjects').text(data2[0][2]);
//			$('#DevDelayProj').text(data2[0][3]);
//			$('#Devactivity').text(data2[0][4]);
//			$('#DevActivityDelay').text(data2[0][5]);
//		}
//	});

	

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/TeamMembersList";
	
	$.ajax({
		type : 'GET',
		url : serviceUrl,
		dataType : 'json',
		success : function(data2) {			
			const jsonData = JSON.stringify(data2);
			const jsonObject = JSON.parse(jsonData);
			const jsonArray = jsonObject.jsondata;
			
		//	alert("jshd "+jsonArray)
			if(roleType === "Implementor") {
			Highcharts.chart('containerTL', {
			    colors: ['#01BAF2', '#71BF45', '#FAA74B', '#B37CD2'],
			    chart: {
			        type: 'pie',
			        height: 300 
			    },
			    accessibility: {
			        point: {
			            valueSuffix: '%'
			        }
			    },
			    title: {
			        text: ''
			    },
			    subtitle: {
			        text: ' '
			    },
			    tooltip: {
			        pointFormat: '{series.name}: <b>{point.y}</b>'
			    },
			    plotOptions: {
			        pie: {
			            allowPointSelect: true,
			            cursor: 'pointer',
			            dataLabels: {
			                enabled: true,
			                format: '{y}'
			            },
			            showInLegend: true
			        }
			    },
			    series: [{
			        name: 'Projects Assigned',
			        colorByPoint: true,
			        innerSize: '75%',
			        data: jsonArray
//			        	[{
//			            name: 'Nitin',
//			            y: 6
//			        }, {
//			            name: 'Rizwan',
//			            y: 3
//			        }, {
//			            name: 'Affan',
//			            y: 8
//			        }]
			    }]
			});  
			
			}
			
			else if(designation === "Jr. Team Leader" || designation ==="Sr Team Leader" || designation ==="Team Leader")	{
				Highcharts.chart('containerTeamMember', {
				    colors: ['#01BAF2', '#71BF45', '#FAA74B', '#B37CD2'],
				    chart: {
				        type: 'pie',
				        height: 300 
				    },
				    accessibility: {
				        point: {
				            valueSuffix: '%'
				        }
				    },
				    title: {
				        text: ''
				    },
				    subtitle: {
				        text: ' '
				    },
				    tooltip: {
				        pointFormat: '{series.name}: <b>{point.y}</b>'
				    },
				    plotOptions: {
				        pie: {
				            allowPointSelect: true,
				            cursor: 'pointer',
				            dataLabels: {
				                enabled: true,
				                format: '{y}'
				            },
				            showInLegend: true
				        }
				    },
				    series: [{
				        name: 'Projects Assigned',
				        colorByPoint: true,
				        innerSize: '75%',
				        data: jsonArray
//				        	[{
//				            name: 'ABC',
//				            y: 6
//				        }, {
//				            name: 'XYZ',
//				            y: 3
//				        }]
				    }]
				});
			} else if(roleType === "Developer") {
				

				Highcharts.chart('containerDeveloper', {
				    colors: ['#01BAF2', '#71BF45', '#FAA74B', '#B37CD2'],
				    chart: {
				        type: 'pie',
				        height: 300 
				    },
				    accessibility: {
				        point: {
				            valueSuffix: '%'
				        }
				    },
				    title: {
				        text: ''
				    },
				    subtitle: {
				        text: ' '
				    },
				    tooltip: {
				        pointFormat: '{series.name}: <b>{point.y}</b>'
				    },
				    plotOptions: {
				        pie: {
				            allowPointSelect: true,
				            cursor: 'pointer',
				            dataLabels: {
				                enabled: true,
				                format: '{y}'
				            },
				            showInLegend: true
				        }
				    },
				    series: [{
				        name: 'Projects Assigned',
				        colorByPoint: true,
				        innerSize: '75%',
				        data: jsonArray
//				        	[{
//				            name: 'SCM',
//				            y: 6
//				        }, {
//				            name: 'PMS',
//				            y: 3
//				        }]
				    }]
				});
				
			}
			
			
		}
	});
	
	

//	 var l = window.location;
//		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////		var serviceUrl = base_url + "/Master/getTeamLeader";     
//		var serviceUrl = base_url + "/Master/getTeamLeaderByManager";
//		
//	$.ajax({
//
//	    url :serviceUrl,
//	    type : 'POST',
//	    dataType: 'json',
//	}).done(function(data) {
//	//	alert("Data "+data);
//	    var html =" <select class='form-control' tabindex='8' id='teamLeaders' name='teamLeaders'>";
//	    html=html+'<option value="">--Please Select --</option>';
//	    for (var i = 0; i < data.length; i++) {
//	        html += '<option value="' +data[i]+ '">' + data[i]
//	        + '</option>';
//	    }
//	    document.getElementById("teamLeaders").innerHTML=html;
//	});	
	
	
	

//	 var l = window.location;
//		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////		var serviceUrl = base_url + "/Master/getTeamLeader";     
//		var serviceUrl = base_url + "/Master/getDevelopersByManager";
//		
//	$.ajax({
//
//	    url :serviceUrl,
//	    type : 'POST',
//	    dataType: 'json',
//	}).done(function(data) {
//	//	alert("Data "+data);
//	    var html =" <select class='form-control' tabindex='8' id='developers' name='developers'>";
//	    html=html+'<option value="">--Please Select --</option>';
//	    for (var i = 0; i < data.length; i++) {
//	        html += '<option value="' +data[i]+ '">' + data[i]
//	        + '</option>';
//	    }
//	    document.getElementById("developers").innerHTML=html;
//	});	
	
	
	
//	 var l = window.location;
//		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////		var serviceUrl = base_url + "/Master/getTeamLeader";     
//		var serviceUrl = base_url + "/Master/getDevelopersByTL";
//		
//	$.ajax({
//
//	    url :serviceUrl,
//	    type : 'POST',
//	    dataType: 'json',
//	}).done(function(data) {
//	//	alert("Data "+data);
//	    var html =" <select class='form-control' tabindex='8' id='developersOfTL' name='developersOfTL'>";
//	    html=html+'<option value="">--Please Select--</option>';
//	    for (var i = 0; i < data.length; i++) {
//	        html += '<option value="' +data[i]+ '">' + data[i]
//	        + '</option>';
//	    }
//	    document.getElementById("developersOfTL").innerHTML=html;
//	});	
	
	
	
//	 var l = window.location;
//	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////	var serviceUrl = base_url + "/Master/getTeamLeader";     
//	var serviceUrl = base_url + "/Master/getManagerList";
//	
//$.ajax({
//
//    url :serviceUrl,
//    type : 'POST',
//    dataType: 'json',
//}).done(function(data) {
////	alert("Data "+data);
//    var html =" <select class='form-control' tabindex='8' id='managerName' name='managerName'>";
//    html=html+'<option value="">--Please Select--</option><option value="All">All</option>';
//    for (var i = 0; i < data.length; i++) {
//        html += '<option value="' +data[i]+ '">' + data[i]
//        + '</option>';
//    }
//    document.getElementById("managerName").innerHTML=html;
//});	
	


var radios = document.getElementsByName('Mtable');
for (var i = 0; i < radios.length; i++) {
    	if(radios[0].checked) {
    		radioClicked="ProgressTable";
  	} else {
    		radioClicked = "TaskTable";
    	}     
}

var radiosMgr = document.getElementsByName('ManagerTable');
for (var i = 0; i < radiosMgr.length; i++) {
    	if(radiosMgr[0].checked) {
    		radioClickedMgr="ProgressTable";
  	} else {
    		radioClickedMgr = "TaskTable";
    	}     
}


//01/08
var radiosMgr = document.getElementsByName('SupportTable');
for (var i = 0; i < radiosMgr.length; i++) {
    	if(radiosMgr[0].checked) {
    		radioClickedMgr="ProgressTable";
  	} else {
    		radioClickedMgr = "TaskTable";
    	}     
}
//


var radiosTL = document.getElementsByName('TLTable');
for (var i = 0; i < radiosTL.length; i++) {
	if(radiosTL[0].checked) {
		radioClickedMgr="ProgressTable";
	} else {
		radioClickedMgr = "TaskTable";
	}
}


//02/08
//var l = window.location;
//var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////var serviceUrl = base_url + "/Master/getTeamLeader";     
//var serviceUrl = base_url + "/Master/getTeamLeaderBySupportManager";
//
//$.ajax({
//
//url :serviceUrl,
//type : 'POST',
//dataType: 'json',
//}).done(function(data) {
////	alert("Data "+data);
//var html =" <select class='form-control' tabindex='8' id='teamLeadersSupport' name='teamLeadersSupport'>";
//html=html+'<option value="">--Please Select --</option>';
//for (var i = 0; i < data.length; i++) {
//    html += '<option value="' +data[i]+ '">' + data[i]
//    + '</option>';
//}
//document.getElementById("teamLeadersSupport").innerHTML=html;
//});	




//var l = window.location;
//var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
////var serviceUrl = base_url + "/Master/getTeamLeader";     
//var serviceUrl = base_url + "/Master/getDevelopersBySupportManager";
//
//$.ajax({
//
//url :serviceUrl,
//type : 'POST',
//dataType: 'json',
//}).done(function(data) {
////	alert("Data "+data);
//var html =" <select class='form-control' tabindex='8' id='developersSupport' name='developersSupport'>";
//html=html+'<option value="">--Please Select --</option>';
//for (var i = 0; i < data.length; i++) {
//    html += '<option value="' +data[i]+ '">' + data[i]
//    + '</option>';
//}
//document.getElementById("developersSupport").innerHTML=html;
//});	





//08/08
//var l = window.location;
//var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//var serviceUrl = base_url + "/Master/getTeamLeadTL";
//
//$.ajax({
//	type : 'POST',
//	url : serviceUrl,
//	dataType : 'json',
//	success : function(data4) {
//		alert(data4);
//
//		var html = "<option value=''>-- Please Select --</option>";
//		for (var i = 0; i < data4.length; i++) {
//			var value = data4[i];
//			html += '<option value="' + value + '">' + value + '</option>';
//		}
//		$("#teamLeaderNameN").html(html); // Update the select element	
//		
//	}
//
//});
//


totalproject();
// onload end 	




//03/09/2024
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/getEmployeeDataForHR";

$.ajax({
    type: 'POST',
    url: serviceUrl,
    dataType: 'json',
    success: function(data2) {
//    	alert("data2 "+data2);
        
//        $('#getemployeedataforhr tbody').empty();

        // Populate table with project data
        if (data2 && data2.length > 0) {
//        	alert("data:::"+data2);
            data2.forEach(function(project) {
            	 var empName = project[0][0];
                 var designation = project[0][1];
                 var role = project[0][2];
                 var assignDate = project[0][3];
                 var assignTask = project[0][4];
                 var status = project[0][5];
                 
                 var row = '<tr>' +
                 '<td>' + empName + '</td>' +
                 '<td>' + designation + '</td>' +
                 '<td>' + role + '</td>' +
                 '<td>' + assignDate + '</td>' +
                 '<td>' + assignTask + '</td>';

       // Determine status styling and append it to the row string
       if (status === "Pending") {
    	   var Stat = "Delayed";
           row += '<td style="color:red">' + Stat + '</td>';
       } else if (status === "Completed") {
           row += '<td style="color:green">' + status + '</td>';
       } else {
           row += '<td>' + status + '</td>';  // In case status is neither "Pending" nor "Completed"
       }

       row += '</tr>';
                 
                $('#getemployeedataforhr tbody').append(row);
            });
        } else {
            // No data received
//            console.log("No data received");
            $('#getemployeedataforhr tbody').append('<tr><td colspan="6">No Employee Data Found</td></tr>');
        }
    },
    error: function(xhr, status, error) {
        console.error('Error fetching project data:', error);
        // Show error message in table
        $('#getemployeedataforhr tbody').empty().append('<tr><td colspan="2">Error Fetching Data</td></tr>');
    }
});






var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/getEmployeeDataCount";

$.ajax({
    type: 'POST',
    url: serviceUrl,
    dataType: 'json',
    success: function(data2) {
//    	alert("data:"+data2);
    	$('#totEmp').text(data2[0][0][0]);
    	$('#acEmp').text(data2[0][0][1]);
    	$('#mlEmp').text(data2[0][0][2]);
    	$('#fmlEmp').text(data2[0][0][3]);
    	$('#totAct').text(data2[0][0][4]);
    },
    error: function(xhr, status, error) {
    	
    }
});






//



}


function showDetails(projectName) {
//	alert("JHA "+projectName)
	
	$("#modelcategory1").modal("show");
	$("#customer_name").val(projectName);
	
	
	
	   var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/PMS/getTaskDetailList";
	   	var customer_name = $("#customer_name").val();

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          data : 'customer_name=' + encodeURIComponent(customer_name),
	          success: function(data2) {
//	              alert(data2)
	         	 var html = "  <option value=''> -- Please Select --</option>";
	                     for (var i = 0; i < data2.length; i++) {
	                         html += '<option value="' + data2[i] + '">' + data2[i]
	                                 + '</option>';
	                     }
	                     document.getElementById("module_name").innerHTML = html;
	              }
	 }); 
	  
	  
	      var l = window.location;
		   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		   	var serviceUrl = base_url + "/PMS/getProductSuiteName";
		   	var module_name1 = $("#customer_name").val();

		      $.ajax({
		          type: 'POST',
		          url: serviceUrl,
		          dataType: 'json',
		          data : 'module_name=' + encodeURIComponent(module_name1),
		          success: function(data3) {
//		              alert(data3)

		                     $("#product_name").val(data3[0][0]);
		                     $("#product_suit").val(data3[0][1]);
		              }
		 });	      
}

function getTaskDetails() {

//    alert("innnnn")

    var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/PMS/getTaskdetails";
	   	var module_name4 = $("#module_name").val();
	   	var customer_name1 = $("#customer_name").val();

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          data : 'module_name=' + encodeURIComponent(module_name4)
	          +'&customer_name=' + encodeURIComponent(customer_name1),
	          success: function(data6) {
//            alert(data6)

	              $("#assign_name").val(data6[0][0]);
	              $("#task_priority").val(data6[0][1]);
	              $("#start_Date").val(data6[0][2]);
	              $("#end_Date").val(data6[0][3]);
	              $("#product_desc").val(data6[0][4]);
	           }
	 });

}



function Projectontrack() {
//    alert("hh");
	event.preventDefault();
    $("#completedProjectsModal").modal("show");

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getprojectontrack";

    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        success: function(data2) {
            // Check if data is received
//            console.log("Data received:", data2);

            // Clear existing table rows
            $('#completedProjectsTable tbody').empty();

            // Populate table with project data
            if (data2 && data2.length > 0) {
                data2.forEach(function(project) {
                	 var projectName = project[0][0];
                     var prodSuite = project[0][1];
                     var prodTool = project[0][2];
                     var date = project[0][3];
                     var managerName3 = project[0][4];
                     var status = project[0][5];
                     var row = '<tr>' +
                         '<td>' + projectName + '</td>' +
                         '<td>' + prodSuite + '</td>' +
                         '<td>' + prodTool + '</td>' +
                         '<td>' + date + '</td>' +
                         '<td>' + managerName3 + '</td>' +
//                         '<td>' + status + '</td>' +
                         '<td style="color:blue;">' + status + '</td>' +
                         '</tr>';
                    $('#completedProjectsTable tbody').append(row);
                });
            } else {
                // No data received
//                console.log("No data received");
                $('#completedProjectsTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#completedProjectsTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
        }
    });
    
    
    
	//23/08
		    var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		//	var serviceUrl = base_url + "/Master/getTeamLeader";     
			var serviceUrl = base_url + "/Master/getCompletedProjectListTrack";
			
			$.ajax({
		
				url :serviceUrl,
				type : 'POST',
				dataType: 'json',
			}).done(function(data) {
				//	alert("Data "+data);
				var html =" <select class='form-control' tabindex='8' id='projectNamesNTrack' name='projectNamesNTrack'>";
				html=html+'<option value="">--Please Select--</option>';
				for (var i = 0; i < data.length; i++) {
					html += '<option value="' +data[i]+ '">' + data[i]
					+ '</option>';
				}
				document.getElementById("projectNamesNTrack").innerHTML=html;
				
			});	
			
			
			
			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		//	var serviceUrl = base_url + "/Master/getTeamLeader";     
			var serviceUrl = base_url + "/Master/getCompletedManagerListTrack";
			
		$.ajax({
		
		  url :serviceUrl,
		  type : 'POST',
		  dataType: 'json',
		}).done(function(data) {
		//alert("Data "+data);
		  var html =" <select class='form-control' tabindex='8' id='prodmgrNTrack' name='prodmgrNTrack'>";
		  html=html+'<option value="">--Please Select--</option>';
		  for (var i = 0; i < data.length; i++) {
		      html += '<option value="' +data[i]+ '">' + data[i]
		      + '</option>';
		  }
		  document.getElementById("prodmgrNTrack").innerHTML=html;
		});	
		
		
		
		
		
		
		
		//get Teamleader Name
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getCompletedTeamLeaderTrack";
		var selectedValue = $("#teamLeaderNameNTrack").val(); // Get the currently
		
		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			success : function(data4) {
		//		alert(data4);
		
				var html = "<option value=''>-- Please Select --</option>";
				for (var i = 0; i < data4.length; i++) {
					var value = data4[i];
					html += '<option value="' + value + '">' + value + '</option>';
				}
				$("#teamLeaderNameNTrack").html(html); // Update the select element	
				
			}
		
		});
		
		  
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
		var serviceUrl = base_url + "/PMS/getManagerTotalProj";
		
	$.ajax({
	
	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	}).done(function(data) {
//		alert("Data "+data);
	    var html =" <select class='form-control' tabindex='8' id='FnameNTrack' name='FnameNTrack'>";
	    html=html+'<option value="">--Please Select--</option>';
	    for (var i = 0; i < data.length; i++) {
	        html += '<option value="' +data[i]+ '">' + data[i]
	        + '</option>';
	    }
	    document.getElementById("FnameNTrack").innerHTML=html;
	});	
		    
	//
    
    
    
}



//01/06
function Projectonhold() {
//  alert("hh");
  $("#completedProjectsonholdModal").modal("show");
  
  
  
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/onHoldprojectList";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='onHoldprojectNames' name='onHoldprojectNames'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("onHoldprojectNames").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getProductSuiteonHoldProj";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='prodSuiteonhldproject' name='prodSuiteonhldproject'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("prodSuiteonhldproject").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getProductToolsOnHoldProj";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='productToolonHoldProj' name='productToolonHoldProj'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("productToolonHoldProj").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getManagerOnHoldProj";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='managerNameonHold' name='managerNameonHold'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("managerNameonHold").innerHTML = html;
					});

  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getprojectonhold";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data2) {
          // Check if data is received
          console.log("Data received:", data2);

          // Clear existing table rows
          $('#completedProjectsonholdTable tbody').empty();

          // Populate table with project data
          if (data2 && data2.length > 0) {
              data2.forEach(function(project) {
              	 var projectName = project[0][0];
                   var prodSuite = project[0][1];
                   var prodTool = project[0][2];
                   var date = project[0][3];
                   var managerName3 = project[0][4];
                   var status = project[0][5];
                   var row = '<tr>' +
                       '<td>' + projectName + '</td>' +
                       '<td>' + prodSuite + '</td>' +
                       '<td>' + prodTool + '</td>' +
                       '<td>' + date + '</td>' +
                       '<td>' + managerName3 + '</td>' +
                       '<td>' + status + '</td>' +
                       '</tr>';
                  $('#completedProjectsonholdTable tbody').append(row);
              });
          } else {
              // No data received
//              console.log("No data received");
              $('#completedProjectsonholdTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
          }
      },
      error: function(xhr, status, error) {
          console.error('Error fetching project data:', error);
          // Show error message in table
          $('#completedProjectsonholdTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
      }
  });
}


function getproductSuiteonHold() {
	
	
	  var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/PMS/getprojectonholdDataTable";

	  $.ajax({
	      type: 'POST',
	      url: serviceUrl,
	      dataType: 'json',
	      data : 'projectName=' + $("#onHoldprojectNames").val()
	      + '&projectSuite=' + $("#prodSuiteonhldproject").val()
	      + '&projectTool=' + $("#productToolonHoldProj").val()
	      + '&managerName=' + $("#managerNameonHold").val(),
	      success: function(data2) {
	          // Check if data is received
	          console.log("Data received:", data2);

	          // Clear existing table rows
	          $('#completedProjectsonholdTable tbody').empty();

	          // Populate table with project data
	          if (data2 && data2.length > 0) {
	              data2.forEach(function(project) {
	              	 var projectName = project[0][0];
	                   var prodSuite = project[0][1];
	                   var prodTool = project[0][2];
	                   var date = project[0][3];
	                   var managerName3 = project[0][4];
	                   var status = project[0][5];
	                   var row = '<tr>' +
	                       '<td>' + projectName + '</td>' +
	                       '<td>' + prodSuite + '</td>' +
	                       '<td>' + prodTool + '</td>' +
	                       '<td>' + date + '</td>' +
	                       '<td>' + managerName3 + '</td>' +
	                       '<td>' + status + '</td>' +
	                       '</tr>';
	                  $('#completedProjectsonholdTable tbody').append(row);
	              });
	          } else {
	              // No data received
//	              console.log("No data received");
	              $('#completedProjectsonholdTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
	          }
	      },
	      error: function(xhr, status, error) {
	          console.error('Error fetching project data:', error);
	          // Show error message in table
	          $('#completedProjectsonholdTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
	      }
	  });
	
	
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getPSuiteonHold";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
					data : "projectName=" + $("#onHoldprojectNames").val(),
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='prodSuiteonhldproject' name='prodSuiteonhldproject'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("prodSuiteonhldproject").innerHTML = html;
						});
	
}

function getproductSuiteOnHoldproj() {
	
	
	  var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/PMS/getprojectonholdDataTable";

	  $.ajax({
	      type: 'POST',
	      url: serviceUrl,
	      dataType: 'json',
	      data : 'projectName=' + $("#onHoldprojectNames").val()
	      + '&projectSuite=' + $("#prodSuiteonhldproject").val()
	      + '&projectTool=' + $("#productToolonHoldProj").val()
	      + '&managerName=' + $("#managerNameonHold").val(),
	      success: function(data2) {
	          // Check if data is received
	          console.log("Data received:", data2);

	          // Clear existing table rows
	          $('#completedProjectsonholdTable tbody').empty();

	          // Populate table with project data
	          if (data2 && data2.length > 0) {
	              data2.forEach(function(project) {
	              	 var projectName = project[0][0];
	                   var prodSuite = project[0][1];
	                   var prodTool = project[0][2];
	                   var date = project[0][3];
	                   var managerName3 = project[0][4];
	                   var status = project[0][5];
	                   var row = '<tr>' +
	                       '<td>' + projectName + '</td>' +
	                       '<td>' + prodSuite + '</td>' +
	                       '<td>' + prodTool + '</td>' +
	                       '<td>' + date + '</td>' +
	                       '<td>' + managerName3 + '</td>' +
	                       '<td>' + status + '</td>' +
	                       '</tr>';
	                  $('#completedProjectsonholdTable tbody').append(row);
	              });
	          } else {
	              // No data received
//	              console.log("No data received");
	              $('#completedProjectsonholdTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
	          }
	      },
	      error: function(xhr, status, error) {
	          console.error('Error fetching project data:', error);
	          // Show error message in table
	          $('#completedProjectsonholdTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
	      }
	  });
	
	
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getPToolOnHold";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
					data : "productSuite=" + $("#prodSuiteonhldproject").val(),
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='productToolonHoldProj' name='productToolonHoldProj'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("prodSuitecmplteproject").innerHTML = html;
						});
	
}

function getmanageronHoldProj() {
	
	
	  var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/PMS/getprojectonholdDataTable";

	  $.ajax({
	      type: 'POST',
	      url: serviceUrl,
	      dataType: 'json',
	      data : 'projectName=' + $("#onHoldprojectNames").val()
	      + '&projectSuite=' + $("#prodSuiteonhldproject").val()
	      + '&projectTool=' + $("#productToolonHoldProj").val()
	      + '&managerName=' + $("#managerNameonHold").val(),
	      success: function(data2) {
	          // Check if data is received
	          console.log("Data received:", data2);

	          // Clear existing table rows
	          $('#completedProjectsonholdTable tbody').empty();

	          // Populate table with project data
	          if (data2 && data2.length > 0) {
	              data2.forEach(function(project) {
	              	 var projectName = project[0][0];
	                   var prodSuite = project[0][1];
	                   var prodTool = project[0][2];
	                   var date = project[0][3];
	                   var managerName3 = project[0][4];
	                   var status = project[0][5];
	                   var row = '<tr>' +
	                       '<td>' + projectName + '</td>' +
	                       '<td>' + prodSuite + '</td>' +
	                       '<td>' + prodTool + '</td>' +
	                       '<td>' + date + '</td>' +
	                       '<td>' + managerName3 + '</td>' +
	                       '<td>' + status + '</td>' +
	                       '</tr>';
	                  $('#completedProjectsonholdTable tbody').append(row);
	              });
	          } else {
	              // No data received
//	              console.log("No data received");
	              $('#completedProjectsonholdTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
	          }
	      },
	      error: function(xhr, status, error) {
	          console.error('Error fetching project data:', error);
	          // Show error message in table
	          $('#completedProjectsonholdTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
	      }
	  });
	
	
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getPManagerOnHold";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
					data : "productTool=" + $("#productToolonHoldProj").val(),
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='managerNameonHold' name='managerNameonHold'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("managerNameonHold").innerHTML = html;
						});
	
}

function getManagerOnHoldProj() {
	
	  var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/PMS/getprojectonholdDataTable";

	  $.ajax({
	      type: 'POST',
	      url: serviceUrl,
	      dataType: 'json',
	      data : 'projectName=' + $("#onHoldprojectNames").val()
	      + '&projectSuite=' + $("#prodSuiteonhldproject").val()
	      + '&projectTool=' + $("#productToolonHoldProj").val()
	      + '&managerName=' + $("#managerNameonHold").val(),
	      success: function(data2) {
	          // Check if data is received
	          console.log("Data received:", data2);

	          // Clear existing table rows
	          $('#completedProjectsonholdTable tbody').empty();

	          // Populate table with project data
	          if (data2 && data2.length > 0) {
	              data2.forEach(function(project) {
	              	 var projectName = project[0][0];
	                   var prodSuite = project[0][1];
	                   var prodTool = project[0][2];
	                   var date = project[0][3];
	                   var managerName3 = project[0][4];
	                   var status = project[0][5];
	                   var row = '<tr>' +
	                       '<td>' + projectName + '</td>' +
	                       '<td>' + prodSuite + '</td>' +
	                       '<td>' + prodTool + '</td>' +
	                       '<td>' + date + '</td>' +
	                       '<td>' + managerName3 + '</td>' +
	                       '<td>' + status + '</td>' +
	                       '</tr>';
	                  $('#completedProjectsonholdTable tbody').append(row);
	              });
	          } else {
	              // No data received
//	              console.log("No data received");
	              $('#completedProjectsonholdTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
	          }
	      },
	      error: function(xhr, status, error) {
	          console.error('Error fetching project data:', error);
	          // Show error message in table
	          $('#completedProjectsonholdTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
	      }
	  });
	
}


function resetAllOnHoldProject() {

		
	$('#onHoldprojectNames').val("");
	  $('#prodSuiteonhldproject').val("");
	  $('#productToolonHoldProj').val("");
	  $('#managerNameonHold').val("");
	  
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/onHoldprojectList";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='onHoldprojectNames' name='onHoldprojectNames'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("onHoldprojectNames").innerHTML = html;
						});

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getProductSuiteonHoldProj";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='prodSuiteonhldproject' name='prodSuiteonhldproject'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("prodSuiteonhldproject").innerHTML = html;
						});

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getProductToolsOnHoldProj";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='productToolonHoldProj' name='productToolonHoldProj'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("productToolonHoldProj").innerHTML = html;
						});

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getManagerOnHoldProj";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='managerNameonHold' name='managerNameonHold'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("managerNameonHold").innerHTML = html;
						});

	  var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/PMS/getprojectonhold";

	  $.ajax({
	      type: 'POST',
	      url: serviceUrl,
	      dataType: 'json',
	      success: function(data2) {
	          // Check if data is received
	          console.log("Data received:", data2);

	          // Clear existing table rows
	          $('#completedProjectsonholdTable tbody').empty();

	          // Populate table with project data
	          if (data2 && data2.length > 0) {
	              data2.forEach(function(project) {
	              	 var projectName = project[0][0];
	                   var prodSuite = project[0][1];
	                   var prodTool = project[0][2];
	                   var date = project[0][3];
	                   var managerName3 = project[0][4];
	                   var status = project[0][5];
	                   var row = '<tr>' +
	                       '<td>' + projectName + '</td>' +
	                       '<td>' + prodSuite + '</td>' +
	                       '<td>' + prodTool + '</td>' +
	                       '<td>' + date + '</td>' +
	                       '<td>' + managerName3 + '</td>' +
	                       '<td>' + status + '</td>' +
	                       '</tr>';
	                  $('#completedProjectsonholdTable tbody').append(row);
	              });
	          } else {
	              // No data received
//	              console.log("No data received");
	              $('#completedProjectsonholdTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
	          }
	      },
	      error: function(xhr, status, error) {
	          console.error('Error fetching project data:', error);
	          // Show error message in table
	          $('#completedProjectsonholdTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
	      }
	  });
	  
}




function TotalProjectCount() {
	
	
//	$("#MDMODAL").modal("show")
//	
//
//	
//	var l = window.location;
//   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//   	var serviceUrl = base_url + "/PMS/getLatestProjectList";
//
//      $.ajax({
//          type: 'POST',
//          url: serviceUrl,
//          dataType: 'json',
//          
//          success: function(data2) {
//             // alert("abc "+data2)
//         	 var html = "  <option value=''> -- Please Select --</option>";
// 			                    for (var i = 0; i < data2.length; i++) {
// 				html += '<option value="' + data2[i] + '">' + data2[i]
// 						+ '</option>';
// 			}
// 			document.getElementById("projectName").innerHTML = html;	
// 	//		document.getElementById("productsuitupdate").innerHTML = html;		
// 		}
// 	});
      

//  	alert("sjdn")
      $("#ProjectsOnTrackMDModal").modal("show");

      var l = window.location;
      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
      var serviceUrl = base_url + "/PMS/getTotalcompletedproject";
      var TotalProjects = "TotalProjects";
      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          data: "methodName=" + TotalProjects ,
          success: function(data2) {// Check if data is received
        	// console.log("Data received:", data2);

        	// Clear existing table rows
        	$('#ProjectsOnTrackTable tbody').empty();

        	// Populate table with project data
        	if (data2 && data2.length > 0) {
        	    data2.forEach(function(project) {
        	        var projectName = project[0];
        	        var prodSuite = project[1];
        	        var prodTool = project[2];
        	        var date = project[3];
        	        var managerName3 = project[4];
        	        var status = project[5];

        	        // Function to get class based on status
        	        function getStatusClass(status) {
       	        	 if (status === 'Completed') {
        	                return 'completed';
        	            } else if (status === 'On Hold') {
        	                return 'on-hold';
        	            } else if (status === 'Delayed') {
        	                return 'delayed';
        	            } else {
        	                return 'pending'; // Default class if status doesn't match
        	            }
       	        }

        	        var row = '<tr>' +
        	            '<td>' + projectName + '</td>' +
        	            '<td>' + prodSuite + '</td>' +
        	            '<td>' + prodTool + '</td>' +
        	            '<td>' + date + '</td>' +
        	            '<td>' + managerName3 + '</td>' 
        	            if(status=== "Delayed" ){
        	            	var stat = "Pending";
        	            	row += '<td class="' + getStatusClass(status) + '">' + stat + '</td>' 
        	            } else {
        	            	row += '<td class="' + getStatusClass(status) + '">' + status + '</td>' 
        	            }
        	        	row += '</tr>';

        	            
//        	            '<td class="' + getStatusClass(status) + '">' + status + '</td>' + // Set class based on status
//        	            '</tr>';

        	        $('#ProjectsOnTrackTable tbody').append(row);
        	    });
        	} else {
        	    // No data received
        	    // console.log("No data received");
        	    $('#ProjectsOnTrackTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
        	}
},
          error: function(xhr, status, error) {
              console.error('Error fetching project data:', error);
              // Show error message in table
              $('#ProjectsOnTrackTable tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
          }
      });
      
      
      
      var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
		var serviceUrl = base_url + "/PMS/totalprojectNamesList";
		
	$.ajax({

	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	}).done(function(data) {
//		alert("Data "+data);
	    var html =" <select class='form-control' tabindex='8' id='totalprojectNames' name='totalprojectNames'>";
	    html=html+'<option value="">--Please Select--</option>';
	    for (var i = 0; i < data.length; i++) {
	        html += '<option value="' +data[i]+ '">' + data[i]
	        + '</option>';
	    }
	    document.getElementById("totalprojectNames").innerHTML=html;
	});	
	
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
		var serviceUrl = base_url + "/PMS/getProductSuiteTotalProj";
		
	$.ajax({

	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	}).done(function(data) {
//		alert("Data "+data);
	    var html =" <select class='form-control' tabindex='8' id='prodSuiteTotalProj' name='prodSuiteTotalProj'>";
	    html=html+'<option value="">--Please Select--</option>';
	    for (var i = 0; i < data.length; i++) {
	        html += '<option value="' +data[i]+ '">' + data[i]
	        + '</option>';
	    }
	    document.getElementById("prodSuiteTotalProj").innerHTML=html;
	});	
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
	var serviceUrl = base_url + "/PMS/getProductToolsTotalProj";
	
$.ajax({

  url :serviceUrl,
  type : 'POST',
  dataType: 'json',
}).done(function(data) {
//	alert("Data "+data);
  var html =" <select class='form-control' tabindex='8' id='productToolTotProj' name='productToolTotProj'>";
  html=html+'<option value="">--Please Select--</option>';
  for (var i = 0; i < data.length; i++) {
      html += '<option value="' +data[i]+ '">' + data[i]
      + '</option>';
  }
  document.getElementById("productToolTotProj").innerHTML=html;
});	

			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
			var serviceUrl = base_url + "/PMS/getManagerTotalProj";
			
		$.ajax({
		
		    url :serviceUrl,
		    type : 'POST',
		    dataType: 'json',
		}).done(function(data) {
//			alert("Data "+data);
		    var html =" <select class='form-control' tabindex='8' id='managerNametotalproj' name='managerNametotalproj'>";
		    html=html+'<option value="">--Please Select--</option>';
		    for (var i = 0; i < data.length; i++) {
		        html += '<option value="' +data[i]+ '">' + data[i]
		        + '</option>';
		    }
		    document.getElementById("managerNametotalproj").innerHTML=html;
		});	
		
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
		var serviceUrl = base_url + "/PMS/getStatusTotalProj";
		
	$.ajax({
	
	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	}).done(function(data) {
		
	    var html =" <select class='form-control' tabindex='8' id='statusTotProj' name='statusTotProj'>";
	    html=html+'<option value="">--Please Select--</option>';
	    for (var i = 0; i < data.length; i++) {
	        html += '<option value="' +data[i]+ '">' + data[i]
	        + '</option>';
	    }
	    document.getElementById("statusTotProj").innerHTML=html;
	});	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
	var serviceUrl = base_url + "/PMS/getProductToolTotalAct";
	
$.ajax({

  url :serviceUrl,
  type : 'POST',
  dataType: 'json',
}).done(function(data) {
	
  var html =" <select class='form-control' tabindex='8' id='productToolTotProj' name='productToolTotProj'>";
  html=html+'<option value="">--Please Select--</option>';
  for (var i = 0; i < data.length; i++) {
      html += '<option value="' +data[i]+ '">' + data[i]
      + '</option>';
  }
  document.getElementById("productToolTotProj").innerHTML=html;
});


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getMangerNameTotalAct";

$
		.ajax({

			url : serviceUrl,
			type : 'POST',
			dataType : 'json',
		})
		.done(
				function(data) {

					var html = " <select class='form-control' tabindex='8' id='managerName' name='managerName'>";
					html = html
							+ '<option value="">--Please Select--</option>';
					for (var i = 0; i < data.length; i++) {
						html += '<option value="' + data[i] + '">'
								+ data[i] + '</option>';
					}
					document.getElementById("managerName").innerHTML = html;
				});


var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/getStatusTotalProject";

$
	.ajax({

		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
	})
	.done(
			function(data) {

				var html = " <select class='form-control' tabindex='8' id='statusTotProj' name='statusTotProj'>";
				html = html
						+ '<option value="">--Please Select--</option>';
				for (var i = 0; i < data.length; i++) {
					html += '<option value="' + data[i] + '">'
							+ data[i] + '</option>';
				}
				document.getElementById("statusTotProj").innerHTML = html;
			});
}

function totalprojectDetails() {
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/totalprojectbyName";
    

   
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "selected_Project=" + $("#totalprojectNames").val() 
        +"&productSuite=" + $("#prodSuiteTotalProj").val()
        + "&productTool=" + $("#productToolTotProj").val()
        + "&managerName=" + $("#managerNametotalproj").val()
        + "&status=" + $("#statusTotProj").val(),
        success: function(data2) {// Check if data is received
      	// console.log("Data received:", data2);

      	// Clear existing table rows
      	$('#ProjectsOnTrackTable tbody').empty();

     // Populate table with project data
    	if (data2 && data2.length > 0) {
    	    data2.forEach(function(project) {
    	        var projectName = project[0];
    	        var prodSuite = project[1];
    	        var prodTool = project[2];
    	        var date = project[3];
    	        var managerName3 = project[4];
    	        var status = project[5];

    	        // Function to get class based on status
    	        function getStatusClass(status) {
   	        	 if (status === 'Completed') {
    	                return 'completed';
    	            } else if (status === 'On Hold') {
    	                return 'on-hold';
    	            } else if (status === 'Delayed') {
    	                return 'delayed';
    	            } else {
    	                return 'pending'; // Default class if status doesn't match
    	            }
   	        }

    	        var row = '<tr>' +
    	            '<td>' + projectName + '</td>' +
    	            '<td>' + prodSuite + '</td>' +
    	            '<td>' + prodTool + '</td>' +
    	            '<td>' + date + '</td>' +
    	            '<td>' + managerName3 + '</td>' 
    	            if(status=== "Delayed" ){
    	            	var stat = "Pending";
    	            	row += '<td class="' + getStatusClass(status) + '">' + stat + '</td>' 
    	            } else {
    	            	row += '<td class="' + getStatusClass(status) + '">' + status + '</td>' 
    	            }
    	        	row += '</tr>';

      	        $('#ProjectsOnTrackTable tbody').append(row);
      	    });
      	} else {
      	    // No data received
      	    // console.log("No data received");
      	    $('#ProjectsOnTrackTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
      	}
},
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#ProjectsOnTrackTable tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });
    
    
			    var l = window.location;
				var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
				var serviceUrl = base_url + "/PMS/getprodSuiteByProjName";
				
			$.ajax({
			
			    url :serviceUrl,
			    type : 'POST',
			    dataType: 'json',
			    data :  "selected_Project=" + $("#totalprojectNames").val(),
			}).done(function(data) {
				
			    var html =" <select class='form-control' tabindex='8' id='prodSuiteTotalProj' name='prodSuiteTotalProj'>";
			    html=html+'<option value="">--Please Select--</option>';
			    for (var i = 0; i < data.length; i++) {
			        html += '<option value="' +data[i]+ '">' + data[i]
			        + '</option>';
			    }
			    document.getElementById("prodSuiteTotalProj").innerHTML=html;
			});	
    
    
	
}

function getProductSuitebyTool() {
	
	
	 	var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
		var serviceUrl = base_url + "/PMS/getprodToolByProdSuite";
		
	$.ajax({
	
	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	    data : "productSuite=" + $("#prodSuiteTotalProj").val(),
	}).done(function(data) {
//		alert(data)
		
	    var html =" <select class='form-control' tabindex='8' id='productToolTotProj' name='productToolTotProj'>";
	    html=html+'<option value="">--Please Select--</option>';
	    for (var i = 0; i < data.length; i++) {
	        html += '<option value="' +data[i]+ '">' + data[i]
	        + '</option>';
	    }
	    document.getElementById("productToolTotProj").innerHTML=html;
	});	
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/totalprojectbyName";
    

   
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "selected_Project=" + $("#totalprojectNames").val() 
        +"&productSuite=" + $("#prodSuiteTotalProj").val()
        + "&productTool=" + $("#productToolTotProj").val()
        + "&managerName=" + $("#managerNametotalproj").val()
        + "&status=" + $("#statusTotProj").val(),
        success: function(data2) {// Check if data is received
      	// console.log("Data received:", data2);

      	// Clear existing table rows
      	$('#ProjectsOnTrackTable tbody').empty();

     // Populate table with project data
    	if (data2 && data2.length > 0) {
    	    data2.forEach(function(project) {
    	        var projectName = project[0];
    	        var prodSuite = project[1];
    	        var prodTool = project[2];
    	        var date = project[3];
    	        var managerName3 = project[4];
    	        var status = project[5];

    	        // Function to get class based on status
    	        function getStatusClass(status) {
   	        	 if (status === 'Completed') {
    	                return 'completed';
    	            } else if (status === 'On Hold') {
    	                return 'on-hold';
    	            } else if (status === 'Delayed') {
    	                return 'delayed';
    	            } else {
    	                return 'pending'; // Default class if status doesn't match
    	            }
   	        }

    	        var row = '<tr>' +
    	            '<td>' + projectName + '</td>' +
    	            '<td>' + prodSuite + '</td>' +
    	            '<td>' + prodTool + '</td>' +
    	            '<td>' + date + '</td>' +
    	            '<td>' + managerName3 + '</td>' 
    	            if(status=== "Delayed" ){
    	            	var stat = "Pending";
    	            	row += '<td class="' + getStatusClass(status) + '">' + stat + '</td>' 
    	            } else {
    	            	row += '<td class="' + getStatusClass(status) + '">' + status + '</td>' 
    	            }
    	        	row += '</tr>';

      	        $('#ProjectsOnTrackTable tbody').append(row);
      	    });
      	} else {
      	    // No data received
      	    // console.log("No data received");
      	    $('#ProjectsOnTrackTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
      	}
},
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#ProjectsOnTrackTable tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });

}


function getManagerByPTool() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getManagerByProdTool";

	$
			.ajax(
					{

						url : serviceUrl,
						type : 'POST',
						dataType : 'json',
						data : "productTool=" + $("#productToolTotProj").val(),
					})
			.done(
					function(data) {
//						alert(data)

						var html = " <select class='form-control' tabindex='8' id='managerNametotalproj' name='managerNametotalproj'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("managerNametotalproj").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/totalprojectbyName";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : "selected_Project=" + $("#totalprojectNames").val()
				+ "&productSuite=" + $("#prodSuiteTotalProj").val()
				+ "&productTool=" + $("#productToolTotProj").val()
				+ "&managerName=" + $("#managerNametotalproj").val() + "&status="
				+ $("#statusTotProj").val(),
		success : function(data2) {// Check if data is received
			// console.log("Data received:", data2);

			// Clear existing table rows
			$('#ProjectsOnTrackTable tbody').empty();

			// Populate table with project data
        	if (data2 && data2.length > 0) {
        	    data2.forEach(function(project) {
        	        var projectName = project[0];
        	        var prodSuite = project[1];
        	        var prodTool = project[2];
        	        var date = project[3];
        	        var managerName3 = project[4];
        	        var status = project[5];

        	        // Function to get class based on status
        	        function getStatusClass(status) {
       	        	 if (status === 'Completed') {
        	                return 'completed';
        	            } else if (status === 'On Hold') {
        	                return 'on-hold';
        	            } else if (status === 'Delayed') {
        	                return 'delayed';
        	            } else {
        	                return 'pending'; // Default class if status doesn't match
        	            }
       	        }

        	        var row = '<tr>' +
        	            '<td>' + projectName + '</td>' +
        	            '<td>' + prodSuite + '</td>' +
        	            '<td>' + prodTool + '</td>' +
        	            '<td>' + date + '</td>' +
        	            '<td>' + managerName3 + '</td>' 
        	            if(status=== "Delayed" ){
        	            	var stat = "Pending";
        	            	row += '<td class="' + getStatusClass(status) + '">' + stat + '</td>' 
        	            } else {
        	            	row += '<td class="' + getStatusClass(status) + '">' + status + '</td>' 
        	            }
        	        	row += '</tr>';

					$('#ProjectsOnTrackTable tbody').append(row);
				});
			} else {
				// No data received
				// console.log("No data received");
				$('#ProjectsOnTrackTable tbody').append(
						'<tr><td colspan="6">No projects found</td></tr>');
			}
		},
		error : function(xhr, status, error) {
			console.error('Error fetching project data:', error);
			// Show error message in table
			$('#ProjectsOnTrackTable tbody').empty().append(
					'<tr><td colspan="3">Error fetching data</td></tr>');
		}
	});

}

function getProjectStatus() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getStatusByManager";

	$
			.ajax(
					{

						url : serviceUrl,
						type : 'POST',
						dataType : 'json',
						data : 
//							"selected_Project="
//								+ $("#totalprojectNames").val()
//								+ "&productSuite="
//								+ $("#prodSuiteTotalProj").val()
//								+ "&productTool=" + $("#productToolTotProj").val()
								"managerName=" + $("#managerNametotalproj").val(),
					})
			.done(
					function(data) {
//						alert(data)

						var html = " <select class='form-control' tabindex='8' id='statusTotProj' name='statusTotProj'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("statusTotProj").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/totalprojectbyName";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : "selected_Project=" + $("#totalprojectNames").val()
				+ "&productSuite=" + $("#prodSuiteTotalProj").val()
				+ "&productTool=" + $("#productToolTotProj").val()
				+ "&managerName=" + $("#managerNametotalproj").val() + "&status="
				+ $("#statusTotProj").val(),
		success : function(data2) {// Check if data is received
			// console.log("Data received:", data2);

			// Clear existing table rows
			$('#ProjectsOnTrackTable tbody').empty();

			// Populate table with project data
        	if (data2 && data2.length > 0) {
        	    data2.forEach(function(project) {
        	        var projectName = project[0];
        	        var prodSuite = project[1];
        	        var prodTool = project[2];
        	        var date = project[3];
        	        var managerName3 = project[4];
        	        var status = project[5];

        	        // Function to get class based on status
        	        function getStatusClass(status) {
       	        	 if (status === 'Completed') {
        	                return 'completed';
        	            } else if (status === 'On Hold') {
        	                return 'on-hold';
        	            } else if (status === 'Delayed') {
        	                return 'delayed';
        	            } else {
        	                return 'pending'; // Default class if status doesn't match
        	            }
       	        }

        	        var row = '<tr>' +
        	            '<td>' + projectName + '</td>' +
        	            '<td>' + prodSuite + '</td>' +
        	            '<td>' + prodTool + '</td>' +
        	            '<td>' + date + '</td>' +
        	            '<td>' + managerName3 + '</td>' 
        	            if(status=== "Delayed" ){
        	            	var stat = "Pending";
        	            	row += '<td class="' + getStatusClass(status) + '">' + stat + '</td>' 
        	            } else {
        	            	row += '<td class="' + getStatusClass(status) + '">' + status + '</td>' 
        	            }
        	        	row += '</tr>';

					$('#ProjectsOnTrackTable tbody').append(row);
				});
			} else {
				// No data received
				// console.log("No data received");
				$('#ProjectsOnTrackTable tbody').append(
						'<tr><td colspan="6">No projects found</td></tr>');
			}
		},
		error : function(xhr, status, error) {
			console.error('Error fetching project data:', error);
			// Show error message in table
			$('#ProjectsOnTrackTable tbody').empty().append(
					'<tr><td colspan="3">Error fetching data</td></tr>');
		}
	});

}

function getprojectStatusTotal() {
//	alert("onchnge")
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/totalprojectbyName";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : "selected_Project=" + $("#totalprojectNames").val()
				+ "&productSuite=" + $("#prodSuiteTotalProj").val()
				+ "&productTool=" + $("#productToolTotProj").val()
				+ "&managerName=" + $("#managerNametotalproj").val() + "&status="
				+ $("#statusTotProj").val(),
		success : function(data2) {// Check if data is received
			// console.log("Data received:", data2);

			// Clear existing table rows
			$('#ProjectsOnTrackTable tbody').empty();

			// Populate table with project data
        	if (data2 && data2.length > 0) {
        	    data2.forEach(function(project) {
        	        var projectName = project[0];
        	        var prodSuite = project[1];
        	        var prodTool = project[2];
        	        var date = project[3];
        	        var managerName3 = project[4];
        	        var status = project[5];

        	        // Function to get class based on status
        	        function getStatusClass(status) {
       	        	 if (status === 'Completed') {
        	                return 'completed';
        	            } else if (status === 'On Hold') {
        	                return 'on-hold';
        	            } else if (status === 'Delayed') {
        	                return 'delayed';
        	            } else {
        	                return 'pending'; // Default class if status doesn't match
        	            }
       	        }

        	        var row = '<tr>' +
        	            '<td>' + projectName + '</td>' +
        	            '<td>' + prodSuite + '</td>' +
        	            '<td>' + prodTool + '</td>' +
        	            '<td>' + date + '</td>' +
        	            '<td>' + managerName3 + '</td>' 
        	            if(status=== "Delayed" ){
        	            	var stat = "Pending";
        	            	row += '<td class="' + getStatusClass(status) + '">' + stat + '</td>' 
        	            } else {
        	            	row += '<td class="' + getStatusClass(status) + '">' + status + '</td>' 
        	            }
        	        	row += '</tr>';

					$('#ProjectsOnTrackTable tbody').append(row);
				});
			} else {
				// No data received
				// console.log("No data received");
				$('#ProjectsOnTrackTable tbody').append(
						'<tr><td colspan="6">No projects found</td></tr>');
			}
		},
		error : function(xhr, status, error) {
			console.error('Error fetching project data:', error);
			// Show error message in table
			$('#ProjectsOnTrackTable tbody').empty().append(
					'<tr><td colspan="3">Error fetching data</td></tr>');
		}
	});
	
	
}

function resetAllTotalProject() {
	
	 $('#totalprojectNames').val("");
	  $('#prodSuiteTotalProj').val("");
	  $('#productToolTotProj').val("");
	  $('#managerNametotalproj').val("");
	  $('#statusTotProj').val("");
	  
	  
	  
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
		var serviceUrl = base_url + "/PMS/totalprojectNamesList";
		
	$.ajax({

	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	}).done(function(data) {
//		alert("Data "+data);
	    var html =" <select class='form-control' tabindex='8' id='totalprojectNames' name='totalprojectNames'>";
	    html=html+'<option value="">--Please Select--</option>';
	    for (var i = 0; i < data.length; i++) {
	        html += '<option value="' +data[i]+ '">' + data[i]
	        + '</option>';
	    }
	    document.getElementById("totalprojectNames").innerHTML=html;
	});	
	
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
		var serviceUrl = base_url + "/PMS/getProductSuiteTotalProj";
		
	$.ajax({

	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	}).done(function(data) {
//		alert("Data "+data);
	    var html =" <select class='form-control' tabindex='8' id='prodSuiteTotalProj' name='prodSuiteTotalProj'>";
	    html=html+'<option value="">--Please Select--</option>';
	    for (var i = 0; i < data.length; i++) {
	        html += '<option value="' +data[i]+ '">' + data[i]
	        + '</option>';
	    }
	    document.getElementById("prodSuiteTotalProj").innerHTML=html;
	});	
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
	var serviceUrl = base_url + "/PMS/getProductToolsTotalProj";
	
$.ajax({

  url :serviceUrl,
  type : 'POST',
  dataType: 'json',
}).done(function(data) {
//	alert("Data "+data);
  var html =" <select class='form-control' tabindex='8' id='productToolTotProj' name='productToolTotProj'>";
  html=html+'<option value="">--Please Select--</option>';
  for (var i = 0; i < data.length; i++) {
      html += '<option value="' +data[i]+ '">' + data[i]
      + '</option>';
  }
  document.getElementById("productToolTotProj").innerHTML=html;
});	

			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
			var serviceUrl = base_url + "/PMS/getManagerTotalProj";
			
		$.ajax({
		
		    url :serviceUrl,
		    type : 'POST',
		    dataType: 'json',
		}).done(function(data) {
//			alert("Data "+data);
		    var html =" <select class='form-control' tabindex='8' id='managerNametotalproj' name='managerNametotalproj'>";
		    html=html+'<option value="">--Please Select--</option>';
		    for (var i = 0; i < data.length; i++) {
		        html += '<option value="' +data[i]+ '">' + data[i]
		        + '</option>';
		    }
		    document.getElementById("managerNametotalproj").innerHTML=html;
		});	
		
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
		var serviceUrl = base_url + "/PMS/getStatusTotalProj";
		
	$.ajax({
	
	    url :serviceUrl,
	    type : 'POST',
	    dataType: 'json',
	}).done(function(data) {
		
	    var html =" <select class='form-control' tabindex='8' id='statusTotProj' name='statusTotProj'>";
	    html=html+'<option value="">--Please Select--</option>';
	    for (var i = 0; i < data.length; i++) {
	        html += '<option value="' +data[i]+ '">' + data[i]
	        + '</option>';
	    }
	    document.getElementById("statusTotProj").innerHTML=html;
	});	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];   
	var serviceUrl = base_url + "/PMS/getProductToolTotalAct";
	
$.ajax({

  url :serviceUrl,
  type : 'POST',
  dataType: 'json',
}).done(function(data) {
	
  var html =" <select class='form-control' tabindex='8' id='productToolTotProj' name='productToolTotProj'>";
  html=html+'<option value="">--Please Select--</option>';
  for (var i = 0; i < data.length; i++) {
      html += '<option value="' +data[i]+ '">' + data[i]
      + '</option>';
  }
  document.getElementById("productToolTotProj").innerHTML=html;
});


	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getMangerNameTotalAct";

$
		.ajax({

			url : serviceUrl,
			type : 'POST',
			dataType : 'json',
		})
		.done(
				function(data) {

					var html = " <select class='form-control' tabindex='8' id='managerName' name='managerName'>";
					html = html
							+ '<option value="">--Please Select--</option>';
					for (var i = 0; i < data.length; i++) {
						html += '<option value="' + data[i] + '">'
								+ data[i] + '</option>';
					}
					document.getElementById("managerName").innerHTML = html;
				});

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/getStatusTotalProject";

$
	.ajax({

		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
	})
	.done(
			function(data) {

				var html = " <select class='form-control' tabindex='8' id='statusTotProj' name='statusTotProj'>";
				html = html
						+ '<option value="">--Please Select--</option>';
				for (var i = 0; i < data.length; i++) {
					html += '<option value="' + data[i] + '">'
							+ data[i] + '</option>';
				}
				document.getElementById("statusTotProj").innerHTML = html;
			});

////////////Table Start Onload///////////////////////////
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/getTotalcompletedproject";
var TotalProjects = "TotalProjects";
$.ajax({
    type: 'POST',
    url: serviceUrl,
    dataType: 'json',
    data: "methodName=" + TotalProjects ,
    success: function(data2) {// Check if data is received
  	// console.log("Data received:", data2);

  	// Clear existing table rows
  	$('#ProjectsOnTrackTable tbody').empty();

  	// Populate table with project data
  	if (data2 && data2.length > 0) {
  	    data2.forEach(function(project) {
  	        var projectName = project[0];
  	        var prodSuite = project[1];
  	        var prodTool = project[2];
  	        var date = project[3];
  	        var managerName3 = project[4];
  	        var status = project[5];

  	        // Function to get class based on status
  	      function getStatusClass(status) {
	        	 if (status === 'Completed') {
 	                return 'completed';
 	            } else if (status === 'On Hold') {
 	                return 'on-hold';
 	            } else if (status === 'Delayed') {
 	                return 'delayed';
 	            } else {
 	                return 'pending'; // Default class if status doesn't match
 	            }
	        }

  	        var row = '<tr>' +
  	            '<td>' + projectName + '</td>' +
  	            '<td>' + prodSuite + '</td>' +
  	            '<td>' + prodTool + '</td>' +
  	            '<td>' + date + '</td>' +
  	            '<td>' + managerName3 + '</td>' 
  	          if(status=== "Delayed" ){
	            	var stat = "Pending";
	            	row += '<td class="' + getStatusClass(status) + '">' + stat + '</td>' 
	            } else {
	            	row += '<td class="' + getStatusClass(status) + '">' + status + '</td>' 
	            }
	        	row += '</tr>';

  	            
//  	            '<td class="' + getStatusClass(status) + '">' + status + '</td>' + // Set class based on status
//  	            '</tr>';

  	        $('#ProjectsOnTrackTable tbody').append(row);
  	    });
  	} else {
  	    // No data received
  	    // console.log("No data received");
  	    $('#ProjectsOnTrackTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
  	}
},
    error: function(xhr, status, error) {
        console.error('Error fetching project data:', error);
        // Show error message in table
        $('#ProjectsOnTrackTable tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
    }
});
	  
	  
	  
}

function ActivitiesOnTrack() {
	
	$("#MDMODAL").modal("show")
	
		 var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/getManagerList";
	
$.ajax({

    url :serviceUrl,
    type : 'POST',
    dataType: 'json',
}).done(function(data) {
//	alert("Data "+data);
    var html =" <select class='form-control' tabindex='8' id='Actprodmgr' name='ActprojectName'>";
    html=html+'<option value="">--Please Select--</option>';
    for (var i = 0; i < data.length; i++) {
        html += '<option value="' +data[i]+ '">' + data[i]
        + '</option>';
    }
    document.getElementById("Actprodmgr").innerHTML=html;
});	
     


// get Teamleader Name
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/getTeamLeader";
var selectedValue = $("#ActteamLeaderName").val(); // Get the currently
// selected value

$.ajax({
	type : 'POST',
	url : serviceUrl,
	dataType : 'json',
	// data : 'teamLeader=' + encodeURIComponent(selectedValue),
	success : function(data4) {

		// alert("function "+data4)
		var html = "<option value=''>-- Please Select --</option>";
		for (var i = 0; i < data4.length; i++) {
			var value = data4[i];
			html += '<option value="' + value + '">' + value + '</option>';
		}
		$("#ActteamLeaderName").html(html); // Update the select element	
	}
});

var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
var html = "<option value=''>-- Please Select --</option>";
for (var i = 0; i < dataF.length; i++) {
    var value = dataF[i];
    html += '<option value="' + value + '">' + value + '</option>';
}
$("#ActFname").html(html);




      	var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getAllActivities";

	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',

	    }).done(function(data2) {
	  //  	alert("niininiii "+data2)
	      $('#ProjectDetailsByName tbody').empty();
	    	
	      if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	              var Customername = project[0][0];
	              var ProductManager = project[0][1];
	              var ProductSuite = project[0][2];
	              var Producttool = project[0][3];
	              var Functionname = project[0][4];
	              var Activities = project[0][5];
	              var TeamLeader = project[0][6];
	              var Dev = project[0][7];
	              var TaskEnddate = project[0][8];
	              
	              var row = '<tr>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
	              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
	              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
	              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (TeamLeader ? TeamLeader : 'NA') + '</td>' +
	              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
	              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
	              '</tr>';
	          $('#ProjectDetailsByName tbody').append(row);
	      });
	      } else {
//	          console.log("No data received");
	          $('#ProjectDetailsByName tbody').append('<tr><td colspan="9">No Activities found</td></tr>');
	      }
	  });
	    
	    
	    
	    
	    var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/PMS/getLatestProjectList";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          
	          success: function(data2) {
	             // alert("abc "+data2)
	         	 var html = "  <option value=''> -- Please Select --</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("ActprojectName").innerHTML = html;	
	 			
	 	//		document.getElementById("productsuitupdate").innerHTML = html;		
	 		}
	 	});


}

function totalproject() {
	$("#MDMODAL").modal("hide")
	

	
//	var l = window.location;
//   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//   	var serviceUrl = base_url + "/PMS/getListdelayproject";
//
//      $.ajax({
//          type: 'POST',
//          url: serviceUrl,
//          dataType: 'json',
//          
//          success: function(data2) {
//             // alert("abc "+data2)
//         	 var html = "  <option value=''> -- Please Select --</option>";
// 			                    for (var i = 0; i < data2.length; i++) {
// 				html += '<option value="' + data2[i] + '">' + data2[i]
// 						+ '</option>';
// 			}
// 			document.getElementById("projectNames").innerHTML = html;	
// 			
// 	//		document.getElementById("productsuitupdate").innerHTML = html;		
// 		}
// 	});
	


}


function projectListDetails() {
//	alert("sba")
	
	$('#ProjectList').hide(); 
	$('#ActivityList').show();
	
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/UserActivity/manualProposalApprovedDetailsMD";
 	var serviceUrl = base_url + "/UserActivity/getAllProjectList";
 	var projectNameBy = $('#projectName').val(); 
 	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data : 'projectName=' + encodeURIComponent(projectNameBy),
        success: function(data5) {
//        	$('#ProjectDetailsByName').DataTable().destroy();
//            var table1 = $("#ProjectDetailsByName").DataTable({  
//                lengthChange: false,
////                pageLength: 5,
//                data: data5,
////                scrollX: '300px',
//                paging: false,
//                scrollY: '300px',
//                searching: false
//      
//            });
//        }	
        	
        	
        	  $('#ProjectDetailsByName tbody').empty();

              // Populate table with project data
              if (data5 && data5.length > 0) {
//              	alert("IF")
            	  data5.forEach(function(activity) {
                  	//alert("for each"+activity[0][1])
                      try {
//                      	alert("try")
                      	var prodSuite = activity[0][0];
                      	 var prodTool = activity[0][1];
                          var description = activity[0][2];
//                          var TLName1 = activity[0][3];
                          if(activity[0][5]!=null || activity[0][5]!="") {
                          	var developerName1 = activity[0][3];
                          } else {
                          	var developerName1 = activity[0][5];
                          }
                          var endDate = activity[0][4];

                          // Create HTML row and append to table
                          var row = '<tr>' +
                          	'<td>' + prodSuite + '</td>' + 
                          	'<td>' + prodTool + '</td>' + 
                              '<td>' + description + '</td>' + 
//                              '<td>' + TLName1 + '</td>' +  
                              '<td>' + developerName1 + '</td>' + 
                              '<td>' + endDate + '</td>' +
                              '</tr>';
                          $('#ProjectDetailsByName tbody').append(row);
                      } catch (error) {
                          console.error('Error parsing activity data:', error);
                      }
                  });
              } else {
                  // No data received
                  $('#ProjectDetailsByName tbody').append('<tr><td colspan="3">No activities found</td></tr>');
              }
          },
          error: function(xhr, status, error) {
              console.error('Error fetching activity data:', error);
              // Show error message in table
              $('#ProjectDetailsByName tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
          }
        	
        	
        	
        
    });
	
}

function Totalcompletedproject() {
//	alert("sjdn")
    $("#TotalcompletedProjectsModal").modal("show");
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/cmplteprojectList";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='CompleteprojectNames' name='CompleteprojectNames'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("CompleteprojectNames").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getProductSuiteCmplteProj";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='prodSuitecmplteproject' name='prodSuitecmplteproject'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("prodSuitecmplteproject").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getProductToolsCmplProj";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='productToolCmpltProj' name='productToolCmpltProj'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("productToolCmpltProj").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getManagerCmplteProj";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='managerNameCmplt' name='managerNameCmplt'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("managerNameCmplt").innerHTML = html;
					});

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTotalcompletedproject";
    var CompletedProjects = "CompletedProjects";
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "methodName=" + CompletedProjects ,
        success: function(data2) {
            // Check if data is received
//            console.log("Data received:", data2);
//alert("3333"+data2)
            // Clear existing table rows
            $('#TotalcompletedProjectsTableMD tbody').empty();

            // Populate table with project data
            if (data2 && data2.length > 0) {
                data2.forEach(function(project) {
                    var projectName = project[0][0];
                    var prodSuite = project[0][1];
                    var prodTool = project[0][2];
                    var date = project[0][3];
                    var managerName3 = project[0][4];
                    var status = project[0][5];
                    var row = '<tr>' +
                        '<td>' + projectName + '</td>' +
                        '<td>' + prodSuite + '</td>' +
                        '<td>' + prodTool + '</td>' +
                        '<td>' + date + '</td>' +
                        '<td>' + managerName3 + '</td>' +
                        '<td style="color:green;">' + status + '</td>' +
                        '</tr>';
                    $('#TotalcompletedProjectsTableMD tbody').append(row);
                });
            } else {
                // No data received
//                console.log("No data received");
                $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="6">No projects found</td></tr>');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#TotalcompletedProjectsTableMD tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });
}

///Mayur Changes/////
function getproductSuiteCmple() {
	
	

	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTotalcompletedprojectList";
    var CompletedProjects = "CompletedProjects";
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "projectName=" + $("#CompleteprojectNames").val()
		+ "&productSuite=" + $("#prodSuitecmplteproject").val()
		+ "&productTool=" + $("#productToolCmpltProj").val()
		+ "&managerName=" + $("#managerNameCmplt").val(),
        success: function(data2) {
            
//            console.log("Data received:", data2);
            // Clear existing table rows
            $('#TotalcompletedProjectsTableMD tbody').empty();

            // Populate table with project data
            if (data2 && data2.length > 0) {
                data2.forEach(function(project) {
                    var projectName = project[0][0];
                    var prodSuite = project[0][1];
                    var prodTool = project[0][2];
                    var date = project[0][3];
                    var managerName3 = project[0][4];
                    var status = project[0][5];
                    var row = '<tr>' +
                        '<td>' + projectName + '</td>' +
                        '<td>' + prodSuite + '</td>' +
                        '<td>' + prodTool + '</td>' +
                        '<td>' + date + '</td>' +
                        '<td>' + managerName3 + '</td>' +
                        '<td>' + status + '</td>' +
                        '</tr>';
                    $('#TotalcompletedProjectsTableMD tbody').append(row);
                });
            } else {
                // No data received
//                console.log("No data received");
                $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="6">No projects found</td></tr>');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#TotalcompletedProjectsTableMD tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getprojectNameCmplteProject";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "projectName=" + $("#CompleteprojectNames").val(),
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='prodSuitecmplteproject' name='prodSuitecmplteproject'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("prodSuitecmplteproject").innerHTML = html;
					});
	
	
}

function getproductSuitecmpltproj()
{
	
	

	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTotalcompletedprojectList";
    var CompletedProjects = "CompletedProjects";
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "projectName=" + $("#CompleteprojectNames").val()
		+ "&productSuite=" + $("#prodSuitecmplteproject").val()
		+ "&productTool=" + $("#productToolCmpltProj").val()
		+ "&managerName=" + $("#managerNameCmplt").val(),
        success: function(data2) {
            
//            console.log("Data received:", data2);
            // Clear existing table rows
            $('#TotalcompletedProjectsTableMD tbody').empty();

            // Populate table with project data
            if (data2 && data2.length > 0) {
                data2.forEach(function(project) {
                    var projectName = project[0][0];
                    var prodSuite = project[0][1];
                    var prodTool = project[0][2];
                    var date = project[0][3];
                    var managerName3 = project[0][4];
                    var status = project[0][5];
                    var row = '<tr>' +
                        '<td>' + projectName + '</td>' +
                        '<td>' + prodSuite + '</td>' +
                        '<td>' + prodTool + '</td>' +
                        '<td>' + date + '</td>' +
                        '<td>' + managerName3 + '</td>' +
                        '<td>' + status + '</td>' +
                        '</tr>';
                    $('#TotalcompletedProjectsTableMD tbody').append(row);
                });
            } else {
                // No data received
//                console.log("No data received");
                $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="6">No projects found</td></tr>');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#TotalcompletedProjectsTableMD tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getproductSuiteCmplteProject";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "productSuite=" + $("#prodSuitecmplteproject").val(),
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='productToolCmpltProj' name='productToolCmpltProj'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("productToolCmpltProj").innerHTML = html;
					});
	
	
}

function getmanagerCmplProj() {
	
	

	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTotalcompletedprojectList";
    var CompletedProjects = "CompletedProjects";
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "projectName=" + $("#CompleteprojectNames").val()
		+ "&productSuite=" + $("#prodSuitecmplteproject").val()
		+ "&productTool=" + $("#productToolCmpltProj").val()
		+ "&managerName=" + $("#managerNameCmplt").val(),
        success: function(data2) {
            
//            console.log("Data received:", data2);
            // Clear existing table rows
            $('#TotalcompletedProjectsTableMD tbody').empty();

            // Populate table with project data
            if (data2 && data2.length > 0) {
                data2.forEach(function(project) {
                    var projectName = project[0][0];
                    var prodSuite = project[0][1];
                    var prodTool = project[0][2];
                    var date = project[0][3];
                    var managerName3 = project[0][4];
                    var status = project[0][5];
                    var row = '<tr>' +
                        '<td>' + projectName + '</td>' +
                        '<td>' + prodSuite + '</td>' +
                        '<td>' + prodTool + '</td>' +
                        '<td>' + date + '</td>' +
                        '<td>' + managerName3 + '</td>' +
                        '<td>' + status + '</td>' +
                        '</tr>';
                    $('#TotalcompletedProjectsTableMD tbody').append(row);
                });
            } else {
                // No data received
//                console.log("No data received");
                $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="6">No projects found</td></tr>');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#TotalcompletedProjectsTableMD tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getmanagerCmplteProject";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "productTool=" + $("#productToolCmpltProj").val(),
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='managerNameCmplt' name='managerNameCmplt'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("managerNameCmplt").innerHTML = html;
					});
	
	
}


function getManagerCmplteProj() {

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getTotalcompletedprojectList";
	var CompletedProjects = "CompletedProjects";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		data : "projectName=" + $("#CompleteprojectNames").val()
				+ "&productSuite=" + $("#prodSuitecmplteproject").val()
				+ "&productTool=" + $("#productToolCmpltProj").val()
				+ "&managerName=" + $("#managerNameCmplt").val(),
		success : function(data2) {

			// console.log("Data received:", data2);
			// Clear existing table rows
			$('#TotalcompletedProjectsTableMD tbody').empty();

			// Populate table with project data
			if (data2 && data2.length > 0) {
				data2.forEach(function(project) {
					var projectName = project[0][0];
					var prodSuite = project[0][1];
					var prodTool = project[0][2];
					var date = project[0][3];
					var managerName3 = project[0][4];
					var status = project[0][5];
					var row = '<tr>' + '<td>' + projectName + '</td>' + '<td>'
							+ prodSuite + '</td>' + '<td>' + prodTool + '</td>'
							+ '<td>' + date + '</td>' + '<td>' + managerName3
							+ '</td>' + '<td>' + status + '</td>' + '</tr>';
					$('#TotalcompletedProjectsTableMD tbody').append(row);
				});
			} else {
				// No data received
				// console.log("No data received");
				$('#TotalcompletedProjectsTableMD tbody').append(
						'<tr><td colspan="6">No projects found</td></tr>');
			}
		},
		error : function(xhr, status, error) {
			console.error('Error fetching project data:', error);
			// Show error message in table
			$('#TotalcompletedProjectsTableMD tbody').empty().append(
					'<tr><td colspan="3">Error fetching data</td></tr>');
		}
	});

}


function resetAllCmplteProject() {
	
	$('#CompleteprojectNames').val("");
	  $('#prodSuitecmplteproject').val("");
	  $('#productToolCmpltProj').val("");
	  $('#managerNameCmplt').val("");
	  
	  
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/cmplteprojectList";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='CompleteprojectNames' name='CompleteprojectNames'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("CompleteprojectNames").innerHTML = html;
						});

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getProductSuiteCmplteProj";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='prodSuitecmplteproject' name='prodSuitecmplteproject'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("prodSuitecmplteproject").innerHTML = html;
						});

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getProductToolsCmplProj";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='productToolCmpltProj' name='productToolCmpltProj'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("productToolCmpltProj").innerHTML = html;
						});

		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getManagerCmplteProj";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='managerNameCmplt' name='managerNameCmplt'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("managerNameCmplt").innerHTML = html;
						});

	    
	    

	    var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getTotalcompletedproject";
	    var CompletedProjects = "CompletedProjects";
	    
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: "methodName=" + CompletedProjects ,
	        success: function(data2) {
	            // Check if data is received
//	            console.log("Data received:", data2);
	//alert("3333"+data2)
	            // Clear existing table rows
	            $('#TotalcompletedProjectsTableMD tbody').empty();

	            // Populate table with project data
	            if (data2 && data2.length > 0) {
	                data2.forEach(function(project) {
	                    var projectName = project[0][0];
	                    var prodSuite = project[0][1];
	                    var prodTool = project[0][2];
	                    var date = project[0][3];
	                    var managerName3 = project[0][4];
	                    var status = project[0][5];
	                    var row = '<tr>' +
	                        '<td>' + projectName + '</td>' +
	                        '<td>' + prodSuite + '</td>' +
	                        '<td>' + prodTool + '</td>' +
	                        '<td>' + date + '</td>' +
	                        '<td>' + managerName3 + '</td>' +
	                        '<td>' + status + '</td>' +
	                        '</tr>';
	                    $('#TotalcompletedProjectsTableMD tbody').append(row);
	                });
	            } else {
	                // No data received
//	                console.log("No data received");
	                $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="6">No projects found</td></tr>');
	            }
	        },
	        error: function(xhr, status, error) {
	            console.error('Error fetching project data:', error);
	            // Show error message in table
	            $('#TotalcompletedProjectsTableMD tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
	        }
	    });
	  
	
}


//
//function Totalcompletedproject() {
//    $("#TotalcompletedProjectsModal").modal("show");
//
//    var l = window.location;
//    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getTotalcompletedproject";
//
//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        dataType: 'json',
//        success: function(data2) {
//            // Check if data is received
////            console.log("Data received:", data2);
//
//            // Clear existing table rows
//            $('#TotalcompletedProjectsTable tbody').empty();
//
//            // Populate table with project data
//            if (data2 && data2.length > 0) {
//                data2.forEach(function(project) {
//                    var projectName = project[0][0];
//                    var date = project[0][1];
//                    var status = project[0][2];
//                    var row = '<tr>' +
//                        '<td>' + projectName + '</td>' +
//                        '<td>' + date + '</td>' +
//                        '<td>' + status + '</td>' +
//                        '</tr>';
//                    $('#TotalcompletedProjectsTable tbody').append(row);
//                });
//            } else {
//                // No data received
////                console.log("No data received");
//                $('#TotalcompletedProjectsTable tbody').append('<tr><td colspan="3">No projects found</td></tr>');
//            }
//        },
//        error: function(xhr, status, error) {
//            console.error('Error fetching project data:', error);
//            // Show error message in table
//            $('#TotalcompletedProjectsTable tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
//        }
//    });
//}
//
//function Totalcompletedproject() {
//    $("#TotalcompletedProjectsModal").modal("show");
//
//    var l = window.location;
//    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getTotalcompletedproject";
//
//    $.ajax({
//        type: 'POST',
//        url: serviceUrl,
//        dataType: 'json',
//        success: function(data2) {
//            // Check if data is received
////            console.log("Data received:", data2);
//
//            // Clear existing table rows
//            $('#TotalcompletedProjectsTable tbody').empty();
//
//            // Populate table with project data
//            if (data2 && data2.length > 0) {
//                data2.forEach(function(project) {
//                    var projectName = project[0][0];
//                    var date = project[0][1];
//                    var status = project[0][2];
//                    var row = '<tr>' +
//                        '<td>' + projectName + '</td>' +
//                        '<td>' + date + '</td>' +
//                        '<td>' + status + '</td>' +
//                        '</tr>';
//                    $('#TotalcompletedProjectsTable tbody').append(row);
//                });
//            } else {
//                // No data received
////                console.log("No data received");
//                $('#TotalcompletedProjectsTable tbody').append('<tr><td colspan="3">No projects found</td></tr>');
//            }
//        },
//        error: function(xhr, status, error) {
//            console.error('Error fetching project data:', error);
//            // Show error message in table
//            $('#TotalcompletedProjectsTable tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
//        }
//    });
//}
function Activitiesdalayscount() {
//    alert("hi");
	
    event.preventDefault(); // Prevent default form submission behavior
    // Show the modal
    $("#TotalActivitiesDelayedModal").modal("show");


    
    
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getActivitiesdalayscount";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',


    }).done(function(data2) {
  //  	alert("niininiii "+data2)

      $('#TotalcompletedProjectsTableMD tbody').empty();

          if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
        		var customer = project[0][0];
           	 var manager = project[0][1];
                var prodSuite = project[0][2];
                var prodTool = project[0][3];
                var functionName = project[0][4];
               var description = project[0][5];
               var TLName1 = project[0][6];
               var developerName1 = project[0][7];
               var endDate = project[0][8];

              
              var row = '<tr>' +
              '<td>' + (customer ? customer : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
              '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
              '<td>' + (functionName ? functionName : 'NA') + '</td>' +
              '<td>' + (description ? description : 'NA') + '</td>' +
              '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
              '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '</tr>';
          $('#TotalcompletedProjectsTableMD tbody').append(row);
      });
      } else {
//          console.log("No data received");
          $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="9">No Activities found</td></tr>');
      }
  });
    
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/getManagerList";
	
$.ajax({

    url :serviceUrl,
    type : 'POST',
    dataType: 'json',
}).done(function(data) {
//	alert("Data "+data);
    var html =" <select class='form-control' tabindex='8' id='prodmgr' name='prodmgr'>";
    html=html+'<option value="">--Please Select--</option>';
    for (var i = 0; i < data.length; i++) {
        html += '<option value="' +data[i]+ '">' + data[i]
        + '</option>';
    }
    document.getElementById("prodmgr").innerHTML=html;
});	


//get Teamleader Name
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/getTeamLeader";
var selectedValue = $("#teamLeaderName").val(); // Get the currently

$.ajax({
	type : 'POST',
	url : serviceUrl,
	dataType : 'json',
	success : function(data4) {

		var html = "<option value=''>-- Please Select --</option>";
		for (var i = 0; i < data4.length; i++) {
			var value = data4[i];
			html += '<option value="' + value + '">' + value + '</option>';
		}
		$("#teamLeaderName").html(html); // Update the select element	
	}
});
    
	var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
	var html = "<option value=''>-- Please Select --</option>";
	for (var i = 0; i < dataF.length; i++) {
	    var value = dataF[i];
	    html += '<option value="' + value + '">' + value + '</option>';
	}
	$("#Fname").html(html);
}



function TotalDelayedProject() {
    $("#MDDelayProjectMODAL").modal("show");
    
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/delayProjectList";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='DelayprojectNames' name='DelayprojectNames'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("DelayprojectNames").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getProductSuiteDelayProj";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='prodSuiteDelayproject' name='prodSuiteDelayproject'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("prodSuiteDelayproject").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/productToolDelayProj";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='productToolDelayProj' name='productToolDelayProj'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("productToolDelayProj").innerHTML = html;
					});

	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getManagerDelayProj";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='managerNameDelay' name='managerNameDelay'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("managerNameDelay").innerHTML = html;
					});
    
	// Delay project Table
    
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/UserActivity/getDelayedProjectList";
    var projectNameBy = $('#projectName').val(); 
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: { projectName: projectNameBy }, // Use object for data
        success: function(data) {
//            console.log("Data received:", data); // Log received data for debugging

            // Clear existing table rows
            $('#DelayedProjectList tbody').empty();

            // Populate table with project data
            if (data && data.length > 0) {
                data.forEach(function(project) {
                    try {
                        var projectName = project[0];
                        var targetDate = project[1];
                        var status = project[2];
                        var ProductSuite = project[3];
                        var ProductTool = project[4];
                        var Manager = project[5];

                        // Create HTML row and append to table
                        var row = '<tr>' +
                            '<td>' + projectName + '</td>' +
                            '<td>' + ProductSuite + '</td>' +
                            '<td>' + ProductTool + '</td>' +
                            '<td>' + targetDate + '</td>' +
                            '<td>' + Manager + '</td>' +
//                            '<td>' + status + '</td>' +
                            '<td style="color:red;">' + status + '</td>' +
                            '</tr>';
                        $('#DelayedProjectList tbody').append(row);
                    } catch (error) {
                        console.error('Error parsing project data:', error);
                    }
                });
            } else {
                // No data received
                $('#DelayedProjectList tbody').append('<tr><td colspan="5">No projects found</td></tr>');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#DelayedProjectList tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });
}


function getDetailsByTLname(tlName) {

	$('#developers').val('');
	// alert("TL "+tlName);
	$("#AllDetailsOfManager").hide();
	if(tlName==="All"){
//		$('#ProjectDetailsManager tbody').empty();
		
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
//	 	var serviceUrl = base_url + "/UserActivity/getTLProjectDetails";
	 	
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'TLname=' + tlName,
	        success: function(data5) {
//		alert("hxgdfg "+data5)
	        	 $('#ProjectDetailsManagerTask').DataTable().destroy();
	            var table = $("#ProjectDetailsManagerTask").DataTable({  
	                lengthChange: false,
	                pageLength: 10,
//	                paging: false,
	                data: data5,
	   //             scrollX: false,
//	                scrollY: '500px',
	                dom: 'Bfrtip',
	              
	            columnDefs: [
	                {
	                    targets: -1, // Target the last column
	                    render: function(data, type, row) {
	                    if(mainTable!="MDdashboard") {
	                    	if(data == 0){
	                    		 return '<span style="color: black;">' + data + '</span>';
	                    	} else if(data==="NA") {
	                   		 	return '<span style="color: black;">' + data + '</span>';
	                    	} else {
	                    		 return '<span style="color: red;">' + data + '</span>';
	                    	}
	                        // Customize the rendering to display data in red
	                    } else {
	                    	return data;
	                    }
	                    }
	                }
	            ],

	            });
	        }
	    });
		
		
	} else {
	 
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 //	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
 	var serviceUrl = base_url + "/UserActivity/getTLProjectDetails";
 	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'TLname=' + tlName,
        success: function(data5) {
//	alert("hxgdfg "+data5)
        	 $('#ProjectDetailsManagerTask').DataTable().destroy();
            var table = $("#ProjectDetailsManagerTask").DataTable({  
                lengthChange: false,
                pageLength: 10,
//                paging: false,
                data: data5,
   //             scrollX: false,
//                scrollY: '500px',
                dom: 'Bfrtip', // Add this line to enable export buttons
              
            columnDefs: [
                {
                    targets: -1, // Target the last column
                    render: function(data, type, row) {
                    if(mainTable!="MDdashboard") {
                    	if(data == 0){
                    		 return '<span style="color: black;">' + data + '</span>';
                    	} else if(data==="NA") {
                   		 	return '<span style="color: black;">' + data + '</span>';
                    	} else {
                    		 return '<span style="color: red;">' + data + '</span>';
                    	}
                        // Customize the rendering to display data in red
                    } else {
                    	return data;
                    }
                    }
                }
            ],

            });
        }
    });
	}
	
}



function getDetailsByDevName(DeveloperName) {
	
	$('#teamLeaders').val('');
	
	// alert("TL "+tlName);
	$("#AllDetailsOfManager").hide();
	if(DeveloperName==="All" || DeveloperName===""){
//		$('#ProjectDetailsManager tbody').empty();
		
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
//	 	var serviceUrl = base_url + "/UserActivity/getTLProjectDetails";
	 	
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'TLname=' + tlName,
	        success: function(data5) {
//		alert("hxgdfg "+data5)
	        	 $('#ProjectDetailsManager').DataTable().destroy();
	            var table = $("#ProjectDetailsManager").DataTable({  
	                lengthChange: false,
	                pageLength: 10,
//	                paging: false,
	                data: data5,
	   //             scrollX: false,
//	                scrollY: '500px',
	                dom: 'Bfrtip',
	              
	            columnDefs: [
	                {
	                    targets: -1, // Target the last column
	                    render: function(data, type, row) {
	                    if(mainTable!="MDdashboard") {
	                    	if(data == 0){
	                    		 return '<span style="color: black;">' + data + '</span>';
	                    	} else if(data==="NA") {
	                   		 	return '<span style="color: black;">' + data + '</span>';
	                    	} else {
	                    		 return '<span style="color: red;">' + data + '</span>';
	                    	}
	                        // Customize the rendering to display data in red
	                    } else {
	                    	return data;
	                    }
	                    }
	                }
	            ],

	            });
	        }
	    });
		
		
	} else {
	 
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 //	var serviceUrl = base_url + "/UserActivity/getTLProjectDetails";
 	var serviceUrl = base_url + "/UserActivity/getDevProjectDetails";
 	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'DeveloperName=' + DeveloperName,
        success: function(data5) {
//	alert("hxgdfg "+data5)
        	 $('#ProjectDetailsManagerTask').DataTable().destroy();
            var table = $("#ProjectDetailsManagerTask").DataTable({ 
                lengthChange: false,
                pageLength: 10,
//                paging: false,
                data: data5,
   //             scrollX: false,
//                scrollY: '500px',
                dom: 'Bfrtip', // Add this line to enable export buttons
              
            columnDefs: [
                {
                    targets: -1, // Target the last column
                    render: function(data, type, row) {
                    if(mainTable!="MDdashboard") {
                    	if(data == 0){
                    		 return '<span style="color: black;">' + data + '</span>';
                    	} else if(data==="NA") {
                   		 	return '<span style="color: black;">' + data + '</span>';
                    	} else {
                    		 return '<span style="color: red;">' + data + '</span>';
                    	}
                        // Customize the rendering to display data in red
                    } else {
                    	return data;
                    }
                    }
                }
            ],

            });
        }
    });
	}
}









//01/08
function getDetailsByTLnameSupport(tlName) {
//	alert("dropdown clicked");

	$('#developersSupport').val('');
	// alert("TL "+tlName);
	$("#AllDetailsOfManager").hide();
	if(tlName==="All"){
//		$('#ProjectDetailsManager tbody').empty();
		
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getProjectDetailsSupport";
//	 	var serviceUrl = base_url + "/UserActivity/getTLProjectDetails";
	 	
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'TLname=' + tlName,
	        success: function(data5) {
//		alert("hxgdfg "+data5)
	        	 $('#ProjectDetailsSupportTask').DataTable().destroy();
	            var table = $("#ProjectDetailsSupportTask").DataTable({  
	                lengthChange: false,
	                pageLength: 10,
//	                paging: false,
	                data: data5,
	   //             scrollX: false,
//	                scrollY: '500px',
	                dom: 'Bfrtip',
	              
	            columnDefs: [
	                {
	                    targets: -1, // Target the last column
	                    render: function(data, type, row) {
	                    if(mainTable!="MDdashboard") {
	                    	if(data == 0){
	                    		 return '<span style="color: black;">' + data + '</span>';
	                    	} else if(data==="NA") {
	                   		 	return '<span style="color: black;">' + data + '</span>';
	                    	} else {
	                    		 return '<span style="color: red;">' + data + '</span>';
	                    	}
	                        // Customize the rendering to display data in red
	                    } else {
	                    	return data;
	                    }
	                    }
	                }
	            ],

	            });
	        }
	    });
		
		
	} else {
	 
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 //	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
 	var serviceUrl = base_url + "/UserActivity/getTLProjectDetailsSupport";
 	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'TLname=' + tlName,
        success: function(data5) {
//	alert("hxgdfg "+data5)
        	 $('#ProjectDetailsSupportTask').DataTable().destroy();
            var table = $("#ProjectDetailsSupportTask").DataTable({  
                lengthChange: false,
                pageLength: 10,
//                paging: false,
                data: data5,
   //             scrollX: false,
//                scrollY: '500px',
                dom: 'Bfrtip', // Add this line to enable export buttons
              
            columnDefs: [
                {
                    targets: -1, // Target the last column
                    render: function(data, type, row) {
                    if(mainTable!="MDdashboard") {
                    	if(data == 0){
                    		 return '<span style="color: black;">' + data + '</span>';
                    	} else if(data==="NA") {
                   		 	return '<span style="color: black;">' + data + '</span>';
                    	} else {
                    		 return '<span style="color: red;">' + data + '</span>';
                    	}
                        // Customize the rendering to display data in red
                    } else {
                    	return data;
                    }
                    }
                }
            ],

            });
        }
    });
	}
	
}

//-----



function getDetailsByDevName(DeveloperName) {
	
	$('#teamLeaders').val('');
	
	// alert("TL "+tlName);
	$("#AllDetailsOfManager").hide();
	if(DeveloperName==="All" || DeveloperName===""){
//		$('#ProjectDetailsManager tbody').empty();
		
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
//	 	var serviceUrl = base_url + "/UserActivity/getTLProjectDetails";
	 	
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'TLname=' + tlName,
	        success: function(data5) {
//		alert("hxgdfg "+data5)
	        	 $('#ProjectDetailsManager').DataTable().destroy();
	            var table = $("#ProjectDetailsManager").DataTable({  
	                lengthChange: false,
	                pageLength: 10,
//	                paging: false,
	                data: data5,
	   //             scrollX: false,
//	                scrollY: '500px',
	                dom: 'Bfrtip',
	              
	            columnDefs: [
	                {
	                    targets: -1, // Target the last column
	                    render: function(data, type, row) {
	                    if(mainTable!="MDdashboard") {
	                    	if(data == 0){
	                    		 return '<span style="color: black;">' + data + '</span>';
	                    	} else if(data==="NA") {
	                   		 	return '<span style="color: black;">' + data + '</span>';
	                    	} else {
	                    		 return '<span style="color: red;">' + data + '</span>';
	                    	}
	                        // Customize the rendering to display data in red
	                    } else {
	                    	return data;
	                    }
	                    }
	                }
	            ],

	            });
	        }
	    });
		
		
	} else {
	 
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 //	var serviceUrl = base_url + "/UserActivity/getTLProjectDetails";
 	var serviceUrl = base_url + "/UserActivity/getDevProjectDetails";
 	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'DeveloperName=' + DeveloperName,
        success: function(data5) {
//	alert("hxgdfg "+data5)
        	 $('#ProjectDetailsManagerTask').DataTable().destroy();
            var table = $("#ProjectDetailsManagerTask").DataTable({ 
                lengthChange: false,
                pageLength: 10,
//                paging: false,
                data: data5,
   //             scrollX: false,
//                scrollY: '500px',
                dom: 'Bfrtip', // Add this line to enable export buttons
              
            columnDefs: [
                {
                    targets: -1, // Target the last column
                    render: function(data, type, row) {
                    if(mainTable!="MDdashboard") {
                    	if(data == 0){
                    		 return '<span style="color: black;">' + data + '</span>';
                    	} else if(data==="NA") {
                   		 	return '<span style="color: black;">' + data + '</span>';
                    	} else {
                    		 return '<span style="color: red;">' + data + '</span>';
                    	}
                        // Customize the rendering to display data in red
                    } else {
                    	return data;
                    }
                    }
                }
            ],

            });
        }
    });
	}
}
//



function getProjectByDevNameOfTL(devName) {
	

	if(devName==="All" || devName===""){
//		$('#ProjectDetailsManager tbody').empty();
		
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
	 	
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'DeveloperName=' + devName,
	        success: function(data5) {
//		alert("hxgdfg "+data5)
	        	 $('#ProjectDetailTL').DataTable().destroy();
	            var table = $("#ProjectDetailTL").DataTable({  
	                lengthChange: false,
	                pageLength: 10,
//	                paging: false,
	                data: data5,
	   //             scrollX: false,
//	                scrollY: '500px',
	                dom: 'Bfrtip',
	              
	            columnDefs: [
	                {
	                    targets: -1, // Target the last column
	                    render: function(data, type, row) {
	                    if(mainTable!="MDdashboard") {
	                    	if(data == 0){
	                    		 return '<span style="color: black;">' + data + '</span>';
	                    	} else if(data==="NA") {
	                   		 	return '<span style="color: black;">' + data + '</span>';
	                    	} else {
	                    		 return '<span style="color: red;">' + data + '</span>';
	                    	}
	                        // Customize the rendering to display data in red
	                    } else {
	                    	return data;
	                    }
	                    }
	                }
	            ],

	            });
	        }
	    });
		
		
	} else {
	 
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 	var serviceUrl = base_url + "/UserActivity/getDevProjectDetails";
 	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'DeveloperName=' + devName,
        success: function(data5) {
//	alert("hxgdfg "+data5)
        	 $('#ProjectDetailTLTasks').DataTable().destroy();
            var table = $("#ProjectDetailTLTasks").DataTable({  
                lengthChange: false,
                pageLength: 10,
//                paging: false,
                data: data5,
                scrollX: false,
//                scrollY: '500px',
                dom: 'Bfrtip', 
              
            columnDefs: [
                {
                    targets: -1, // Target the last column
                    render: function(data, type, row) {
                    if(mainTable!="MDdashboard") {
                    	if(data == 0){
                    		 return '<span style="color: black;">' + data + '</span>';
                    	} else if(data==="NA") {
                   		 	return '<span style="color: black;">' + data + '</span>';
                    	} else {
                    		 return '<span style="color: red;">' + data + '</span>';
                    	}
                    } else {
                    	return data;
                    }
                    }
                }
            ],

            });
        }
    });
	}
}


	
	
function TotalProjectCountMD() {
	//	alert("sba")
		
		$('#ProjectList').hide(); 
		$('#ActivityList').show();
		
		
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	 	var serviceUrl = base_url + "/UserActivity/manualProposalApprovedDetailsMD";
	 	var serviceUrl = base_url + "/UserActivity/getAllProjectList";
	 	var projectNameBy = $('#projectName').val(); 
	 	
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data : 'projectName=' + encodeURIComponent(projectNameBy),
	        success: function(data5) {
	        	$('#ProjectDetailsByName').DataTable().destroy();
	            var table1 = $("#ProjectDetailsByName").DataTable({ 
	                lengthChange: false,
//	                pageLength: 5,
	                data: data5,
//	                scrollX: '300px',
	                paging: false,
	                scrollY: '300px',
	                searching: false
	      
	            });
	        }
	    });
		
	}



function getDetailsByManagerName(managerName) {
	nameManager = managerName;
//	alert("abb "+nameManager)
//	alert("kik "+radioClicked)
	
	if((managerName==="All" || managerName==="") && radioClicked=== "ProgressTable" ){
//		$('#ProjectDetailsManager tbody').empty();

		$("#AllDetailsOfProjectsProgress").show();
		$("#AllDetailsOfProjects").hide();
		$("#AllDetailsOfProjectsByManager").hide();
		
		
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
	 	
	 	$("#spin14").show();
	 	
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'managerName=' + managerName,
	        success: function(data5) {
	        	$("#spin14").hide();
		
	        	 $('#ProjectDetails').DataTable().destroy();
	        	 $('#ProjectDetailsAll').DataTable().destroy();
	            var table = $("#ProjectDetailsAll").DataTable({  
	                lengthChange: false,
	                pageLength: 10,
//	                paging: false,
	                data: data5,
	   //             scrollX: false,
	                scrollY: '500px',
	                dom: 'Bfrtip',
	              
	            columnDefs: [
	                {
	                    targets: -1, // Target the last column
	                    render: function(data, type, row) {
	                    if(mainTable!="MDdashboard") {
	                    	if(data == 0){
	                    		 return '<span style="color: black;">' + data + '</span>';
	                    	} else if(data==="NA") {
	                   		 	return '<span style="color: black;">' + data + '</span>';
	                    	} else {
	                    		 return '<span style="color: red;">' + data + '</span>';
	                    	}
	                        // Customize the rendering to display data in red
	                    } else {
	                    	return data;
	                    }
	                    }
	                }
	            ],

	            });
	        }
	    });
		
	} else if((managerName==="" || managerName==="All") && radioClicked=== "TaskTable") {
		
			$("#AllDetailsOfProjects").hide();
			$("#AllDetailsOfProjectsByManager").show();
			$("#AllDetailsOfProjectsProgress").hide();
			var tempMname="NA";
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	 	var serviceUrl = base_url + "/UserActivity/getDevProjectDetails";
	 	var serviceUrl = base_url + "/UserActivity/getProjectDetailsManager";
	 	$("#spin12").show();
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'managerName=' + tempMname ,
	        success: function(data5) {
	        	$("#spin12").hide();
//		alert("hxgdfg "+data5)
	        	 $('#ProjectDetailsManager2').DataTable().destroy();
	            var table = $("#ProjectDetailsManager2").DataTable({  
	            	 lengthChange: false,
		                pageLength: 10,
//		                paging: false,
		                data: data5,
		   //             scrollX: false,
//		                scrollY: '500px',
	                dom: 'Bfrtip', // Add this line to enable export buttons
	              
	            columnDefs: [
	                {
	                    targets: -1,
	                    render: function(data, type, row) {
	                    if(mainTable!="MDdashboard") {
	                    	if(data == 0){
	                    		 return '<span style="color: black;">' + data + '</span>';
	                    	} else if(data==="NA") {
	                   		 	return '<span style="color: black;">' + data + '</span>';
	                    	} else {
	                    		 return '<span style="color: red;">' + data + '</span>';
	                    	}
	                    } else {
	                    	return data;
	                    }
	                    }
	                }
	            ],

	            });
	        }
	    });	
	} else if((managerName!="" || managerName!="All") &&  radioClicked!= "ProgressTable" ) {
		
		$("#AllDetailsOfProjects").hide();
		$("#AllDetailsOfProjectsByManager").show();
		$("#AllDetailsOfProjectsProgress").hide();
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
// 	var serviceUrl = base_url + "/UserActivity/getDevProjectDetails";
 	var serviceUrl = base_url + "/UserActivity/getProjectDetailsManager";
 	$("#spin12").show();
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'managerName=' + managerName,
        success: function(data5) {
        	$("#spin12").hide();
//	alert("hxgdfg "+data5)
        	 $('#ProjectDetailsManager2').DataTable().destroy();
            var table = $("#ProjectDetailsManager2").DataTable({  
            	 lengthChange: false,
	                pageLength: 10,
//	                paging: false,
	                data: data5,
	   //             scrollX: false,
//	                scrollY: '500px',
                dom: 'Bfrtip', // Add this line to enable export buttons
              
            columnDefs: [
                {
                    targets: -1,
                    render: function(data, type, row) {
                    if(mainTable!="MDdashboard") {
                    	if(data == 0){
                    		 return '<span style="color: black;">' + data + '</span>';
                    	} else if(data==="NA") {
                   		 	return '<span style="color: black;">' + data + '</span>';
                    	} else {
                    		 return '<span style="color: red;">' + data + '</span>';
                    	}
                    } else {
                    	return data;
                    }
                    }
                }
            ],

            });
        }
    });
    
	
	}  else if((managerName!="All" || managerName!="") && radioClicked=== "ProgressTable") {
//		$('#ProjectDetailsManager tbody').empty();

		$("#AllDetailsOfProjects").show();
		$("#AllDetailsOfProjectsByManager").hide();
		$("#AllDetailsOfProjectsProgress").hide();
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
	 	var serviceUrl = base_url + "/UserActivity/getProjectDetailsProgressMng";
	 	
//	 	$("#spin11").show();
	 	
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'managerName=' + managerName,
	        success: function(data5) {
	        	$("#spin11").hide();
//		alert("hxgdfg "+data5)
	        	 $('#ProjectDetails').DataTable().destroy();
	            var table = $("#ProjectDetails").DataTable({  
	                lengthChange: false,
	                pageLength: 10,
//	                paging: false,
	                data: data5,
	   //             scrollX: false,
//	                scrollY: '500px',
	                dom: 'Bfrtip',
	              
	            columnDefs: [
	                {
	                    targets: -1, // Target the last column
	                    render: function(data, type, row) {
	                    if(mainTable!="MDdashboard") {
	                    	if(data == 0){
	                    		 return '<span style="color: black;">' + data + '</span>';
	                    	} else if(data==="NA") {
	                   		 	return '<span style="color: black;">' + data + '</span>';
	                    	} else {
	                    		 return '<span style="color: red;">' + data + '</span>';
	                    	}
	                        // Customize the rendering to display data in red
	                    } else {
	                    	return data;
	                    }
	                    }
	                }
	            ],

	            });
	        }
	    });
		
		
	}
}







function checkRadioButton() {
	var radios = document.getElementsByName('Mtable');

    for (var i = 0; i < radios.length; i++) {
        	if(radios[0].checked) {
        		radioClicked="ProgressTable";
      	} else {
        		radioClicked = "TaskTable";
        	}         
    }


    getDetailsByManagerName(nameManager)
}

function productsuiteDetails(productsuites) {
	$("#Fname").val('');
	Actproductsuite=productsuites;
	
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getActivitiesdalayscount";   
    var serviceUrl = base_url + "/PMS/getActivitiesdalaysByProj";
    
    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
//        	productmanager: Actproductmanager,
        	projectName:productsuites
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)

      $('#TotalcompletedProjectsTableMD tbody').empty();

          if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
        		var customer = project[0][0];
           	 var manager = project[0][1];
                var prodSuite = project[0][2];
                var prodTool = project[0][3];
                var functionName = project[0][4];
               var description = project[0][5];
               var TLName1 = project[0][6];
               var developerName1 = project[0][7];
               var endDate = project[0][8];

              
              var row = '<tr>' +
              '<td>' + (customer ? customer : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
              '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
              '<td>' + (functionName ? functionName : 'NA') + '</td>' +
              '<td>' + (description ? description : 'NA') + '</td>' +
              '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
              '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '</tr>';
          $('#TotalcompletedProjectsTableMD tbody').append(row);
      });
      } else {
          $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
	
	

	
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getproductsuite";

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: "projectNames=" + productsuites,
    }).done(function(data) {
        // Alert received data for debugging
//        alert("Data: " + JSON.stringify(data));

        // Generate HTML for select dropdown
        var html = "<select class='form-control' tabindex='8' id='prodmgr' name='prodmgr'>";
        html += '<option value="">--Please Select--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i] + '</option>';
        }
        html += "</select>";

        $("#prodmgr").html(html);

    });
    
    
// alert('$("#projectNames").val()'+$("#projectNames").val())
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getproductmgrnameforDelayMD";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data:"projectNames=" + $("#projectNames").val(),
        

    }).done(function(data) {
        // Alert received data for debugging
//alert("data")
        var html = "<select class='form-control' tabindex='8' id='teamLeaderName' name='teamLeaderName'>";
        html += '<option value="">--Please Select--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i] + '</option>';
        }
        html += "</select>";

        $("#teamLeaderName").html(html);
    });

}

function productmangerDetails(productmgrname) {
	Actproductmanager=productmgrname;
 
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getActivitiesdalaysByMGR";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
        	productmanager: productmgrname,
        	projectName:Actproductsuite
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received
//      console.log("Data received:", data2);

      // Clear existing table rows
      $('#TotalcompletedProjectsTableMD tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
        		var customer = project[0][0];
           	 var manager = project[0][1];
                var prodSuite = project[0][2];
                var prodTool = project[0][3];
                var functionName = project[0][4];
               var description = project[0][5];
               var TLName1 = project[0][6];
               var developerName1 = project[0][7];
               var endDate = project[0][8];

              
              var row = '<tr>' +
              '<td>' + (customer ? customer : 'NA') + '</td>' +
              '<td>' + (manager ? manager : 'NA') + '</td>' +
              '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
              '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
              '<td>' + (functionName ? functionName : 'NA') + '</td>' +
              '<td>' + (description ? description : 'NA') + '</td>' +
              '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
              '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
              '</tr>';
          $('#TotalcompletedProjectsTableMD tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
	
	
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getproductmgrname";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
            projectmgrname: productmgrname,
            productsuite:Actproductsuite
        }

    }).done(function(data) {
        // Alert received data for debugging

        var html = "<select class='form-control' tabindex='8' id='teamLeaderName' name='teamLeaderName'>";
        html += '<option value="">--Please Select--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i] + '</option>';
        }
        html += "</select>";

        $("#teamLeaderName").html(html);
    });

}


function teamLeaderDetails(teamleaders) {
	
	teamleader=teamleaders;
	
	   var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    var serviceUrl = base_url + "/PMS/getActivitiesdalayscount";   
	    var serviceUrl = base_url + "/PMS/getActivitiesdalaysByTL";
	    
	    // Make AJAX request to fetch product manager names
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: {
	        	productmanager: Actproductmanager,
	        	projectName:Actproductsuite,
	        	teamleader:teamleaders
//	        	allfunction:Actalldata
	        }

	    }).done(function(data2) {
	  //  	alert("niininiii "+data2)

	      $('#TotalcompletedProjectsTableMD tbody').empty();

	          if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	        		var customer = project[0][0];
	           	 var manager = project[0][1];
	                var prodSuite = project[0][2];
	                var prodTool = project[0][3];
	                var functionName = project[0][4];
	               var description = project[0][5];
	               var TLName1 = project[0][6];
	               var developerName1 = project[0][7];
	               var endDate = project[0][8];

	              
	              var row = '<tr>' +
	              '<td>' + (customer ? customer : 'NA') + '</td>' +
	              '<td>' + (manager ? manager : 'NA') + '</td>' +
	              '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	              '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	              '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	              '<td>' + (description ? description : 'NA') + '</td>' +
	              '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	              '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	              '</tr>';
	          $('#TotalcompletedProjectsTableMD tbody').append(row);
	      });
	      } else {
	          $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	      }
	  });
	
   
    // Get base URL and service URL
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getfunctionname";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
        	productmanager: Actproductmanager,
        	productsuite:Actproductsuite,
        	teamleader:teamleaders
        }

    }).done(function(data) {
        // Alert received data for debugging
//        alert("Data: " + JSON.stringify(data));

        // Generate HTML for select dropdown
        var html = "<select class='form-control' tabindex='8' id='Fname' name='Fname'>";
        html += '<option value="">--Please Select--</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i] + '">' + data[i] + '</option>';
        }
        html += "</select>";

        // Populate select dropdown with generated HTML
        $("#Fname").html(html);
    });

}

function toalldatafeatch(alldata) {
//	alert("Innnn")
    // Make sure 'productmgrname' is defined and contains the necessary data
//    alert("productmgrname: " + Actproductmanager);
//    alert("productsuite33333333: " + Actproductsuite);
//    alert("productsuite55555: " + teamleader);
//    alert("alldata: " + alldata);
//    
    // Construct data to send in AJAX request
   
 
	   var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    var serviceUrl = base_url + "/PMS/getActivitiesdalayscount";   
	    var serviceUrl = base_url + "/PMS/getallfunctionname";
	    
	    // Make AJAX request to fetch product manager names
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: {
	        	productmanager: Actproductmanager,
	        	projectName:Actproductsuite,
	        	teamleader:teamleader,
	        	allfunction:alldata
	        }

	    }).done(function(data2) {
	  //  	alert("niininiii "+data2)

	      $('#TotalcompletedProjectsTableMD tbody').empty();

	          if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	        	   var customer = project[0][0];
	           	   var manager = project[0][1];
	               var prodSuite = project[0][2];
	               var prodTool = project[0][3];
	               var functionName = project[0][4];
	               var description = project[0][5];
	               var TLName1 = project[0][6];
	               var developerName1 = project[0][7];
	               var endDate = project[0][8];

	              
	              var row = '<tr>' +
	              '<td>' + (customer ? customer : 'NA') + '</td>' +
	              '<td>' + (manager ? manager : 'NA') + '</td>' +
	              '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	              '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	              '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	              '<td>' + (description ? description : 'NA') + '</td>' +
	              '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	              '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	              '</tr>';
	          $('#TotalcompletedProjectsTableMD tbody').append(row);
	      });
	      } else {
	          $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	      }
	  });

}


function reload() {
//	alert("hiihhih555555555")
	location.reload();
}


function ActproductsuiteDetails(Actproductsuites) {
    // Make sure 'productsuite' is defined and contains the necessary data
//  alert("productsuite: " + productsuite);
	Actproductsuite=Actproductsuites;
	$('#ActFname').val('');
	
	var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getAllActivitiesByProj";

  // Make AJAX request to fetch product manager names
  $.ajax({
      url: serviceUrl,
      type: 'POST',
      dataType: 'json',
      data: {
//      	productmanager: Actproductmanager,
      	projectName:Actproductsuite
//      	teamleader:Actteamleader,
//      	allfunction:Actalldata
      }

  }).done(function(data2) {
//  	alert("niininiii "+data2)
      // Check if data is received
//    console.log("Data received:", data2);

    // Clear existing table rows
    $('#ProjectDetailsByName tbody').empty();

  	
    // Populate table with project data
    if (data2 && data2.length > 0) {
        data2.forEach(function(project) {
            var Customername = project[0][0];
            var ProductManager = project[0][1];
            var ProductSuite = project[0][2];
            var Producttool = project[0][3];
            var Functionname = project[0][4];
            var Activities = project[0][5];
            var TeamLeader = project[0][6];
            var Dev = project[0][7];
//            var tester = project[0][8];
            var TaskEnddate = project[0][8];
            
            var row = '<tr>' +
            '<td>' + (Customername ? Customername : 'NA') + '</td>' +
            '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
            '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
            '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
            '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
            '<td>' + (Activities ? Activities : 'NA') + '</td>' +
            '<td>' + (TeamLeader ? TeamLeader : 'NA') + '</td>' +
            '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//            '<td>' + (tester ? tester : 'NA') + '</td>' +
            '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
            '</tr>';
        $('#ProjectDetailsByName tbody').append(row);
    });
    } else {
        // No data received
//        console.log("No data received");
        $('#ProjectDetailsByName tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
    }
});
	
	
	
	

	var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getproductsuiteActontrack";


  $.ajax({
      url: serviceUrl,
      type: 'POST',
      dataType: 'json',
      data: "projectNames=" + Actproductsuites,
  }).done(function(data) {

//      alert("Data: " + JSON.stringify(data));

      var html = "<select class='form-control' tabindex='8' id='prodmgr' name='prodmgr'>";
      html += '<option value="">--Please Select--</option>';
      for (var i = 0; i < data.length; i++) {
          html += '<option value="' + data[i] + '">' + data[i] + '</option>';
      }
      html += "</select>";

      // Populate select dropdown with generated HTML
      $("#Actprodmgr").html(html);

      // Call productmangerDetails function with productsuite as parameter
//      productmangerDetails(productsuite);
  });

}  
   function ActproductmangerDetails(Actproductmgrname) {
//	   alert("hihi555555555")
   	Actproductmanager=Actproductmgrname;
  
   	
   	var l = window.location;
       var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
       var serviceUrl = base_url + "/PMS/getAllActivitiesByMGR";

       // Make AJAX request to fetch product manager names
       $.ajax({
           url: serviceUrl,
           type: 'POST',
           dataType: 'json',
           data: {
           	productmanager: Actproductmanager,
           	projectName:Actproductsuite
//           	teamleader:Actteamleader,
//           	allfunction:Actalldata
           }

       }).done(function(data2) {
     //  	alert("niininiii "+data2)
           // Check if data is received
//         console.log("Data received:", data2);

         // Clear existing table rows
         $('#ProjectDetailsByName tbody').empty();

       	
         // Populate table with project data
         if (data2 && data2.length > 0) {
             data2.forEach(function(project) {
                 var Customername = project[0][0];
                 var ProductManager = project[0][1];
                 var ProductSuite = project[0][2];
                 var Producttool = project[0][3];
                 var Functionname = project[0][4];
                 var Activities = project[0][5];
                 var TeamLeader = project[0][6];
                 var Dev = project[0][7];
//                 var tester = project[0][8];
                 var TaskEnddate = project[0][8];
                 
                 var row = '<tr>' +
                 '<td>' + (Customername ? Customername : 'NA') + '</td>' +
                 '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
                 '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
                 '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
                 '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
                 '<td>' + (Activities ? Activities : 'NA') + '</td>' +
                 '<td>' + (TeamLeader ? TeamLeader : 'NA') + '</td>' +
                 '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//                 '<td>' + (tester ? tester : 'NA') + '</td>' +
                 '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
                 '</tr>';
             $('#ProjectDetailsByName tbody').append(row);
         });
         } else {
             // No data received
//             console.log("No data received");
             $('#ProjectDetailsByName tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
         }
     });
   	
   	
   	
       // Get base URL and service URL
       var l = window.location;
       var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
       var serviceUrl = base_url + "/PMS/getproductmgrnameActonTrack";

       $.ajax({
           url: serviceUrl,
           type: 'POST',
           dataType: 'json',
           data: {
               projectmgrname: Actproductmgrname,
               productsuite:Actproductsuite,
           }

       }).done(function(data) {
           // Alert received data for debugging
//           alert("Data333: " + JSON.stringify(data));

           // Generate HTML for select dropdown
           var html = "<select class='form-control' tabindex='8' id='teamLeaderName' name='teamLeaderName'>";
           html += '<option value="">--Please Select--</option>';
           for (var i = 0; i < data.length; i++) {
               html += '<option value="' + data[i] + '">' + data[i] + '</option>';
           }
           html += "</select>";

           $("#ActteamLeaderName").html(html);
       });

   }
   
   
   function ActteamLeaderDetails(Actteamleaders) {
//	   alert("333333")
		Actteamleader=Actteamleaders;
	   
		
		
		var l = window.location;
       var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
       var serviceUrl = base_url + "/PMS/getAllActivitiesByTL";

       // Make AJAX request to fetch product manager names
       $.ajax({
           url: serviceUrl,
           type: 'POST',
           dataType: 'json',
           data: {
           	productmanager: Actproductmanager,
           	projectName:Actproductsuite,
           	teamleader:Actteamleader
//           	allfunction:Actalldata
           }

       }).done(function(data2) {
     //  	alert("niininiii "+data2)
           // Check if data is received

         $('#ProjectDetailsByName tbody').empty();

       	
         if (data2 && data2.length > 0) {
             data2.forEach(function(project) {
                 var Customername = project[0][0];
                 var ProductManager = project[0][1];
                 var ProductSuite = project[0][2];
                 var Producttool = project[0][3];
                 var Functionname = project[0][4];
                 var Activities = project[0][5];
                 var TeamLeader = project[0][6];
                 var Dev = project[0][7];
//                 var tester = project[0][8];
                 var TaskEnddate = project[0][8];
                 
                 var row = '<tr>' +
                 '<td>' + (Customername ? Customername : 'NA') + '</td>' +
                 '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
                 '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
                 '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
                 '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
                 '<td>' + (Activities ? Activities : 'NA') + '</td>' +
                 '<td>' + (TeamLeader ? TeamLeader : 'NA') + '</td>' +
                 '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//                 '<td>' + (tester ? tester : 'NA') + '</td>' +
                 '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
                 '</tr>';
             $('#ProjectDetailsByName tbody').append(row);
         });
         } else {
             // No data received
//             console.log("No data received");
             $('#ProjectDetailsByName tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
         }
     });
		
		
		
		
		
	    // Get base URL and service URL
	    var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getfunctionnameActonTrack";

	    // Make AJAX request to fetch product manager names
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: {
	        	productmanager: Actproductmanager,
	        	productsuite:Actproductsuite,
	        	teamleader:Actteamleader
	        }

	    }).done(function(data) {
	        // Alert received data for debugging
//	        alert("Data33333333: " + JSON.stringify(data));

	        // Generate HTML for select dropdown
	        var html = "<select class='form-control' tabindex='8' id='Fname' name='Fname'>";
	        html += '<option value="">--Please Select--</option>';
	        for (var i = 0; i < data.length; i++) {
	            html += '<option value="' + data[i] + '">' + data[i] + '</option>';
	        }
	        html += "</select>";

	        // Populate select dropdown with generated HTML
	        $("#ActFname").html(html);
	    });
	
}
   
   function Acttoalldatafeatch(Actalldata) {
	    // Make sure 'productmgrname' is defined and contains the necessary data
//	    alert("productmgrname: " + Actproductmanager);
//	    alert("productsuite33333333: " + Actproductsuite);
//	    alert("productsuite55555: " + Actteamleader);
//	    alert("alldata: " + Actalldata);
	//    
	    // Construct data to send in AJAX request
	   
	 
	    // Get base URL and service URL
	    var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getallfunctionnameActonTracks";

	    // Make AJAX request to fetch product manager names
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
	        data: {
	        	productmanager: Actproductmanager,
	        	productsuite:Actproductsuite,
	        	teamleader:Actteamleader,
	        	allfunction:Actalldata
	        }

	    }).done(function(data2) {
//	    	alert("niininiii"+data2)
	        // Check if data is received
//	      console.log("Data received:", data2);

	      // Clear existing table rows
	      $('#ProjectDetailsByName tbody').empty();

	    	
	      // Populate table with project data
	      if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	              var Customername = project[0][0];
	              var ProductManager = project[0][1];
	              var ProductSuite = project[0][2];
	              var Producttool = project[0][3];
	              var Functionname = project[0][4];
	              var Activities = project[0][5];
	              var TeamLeader = project[0][6];
	              var Dev = project[0][7];
	              var tester = project[0][8];
	              var TaskEnddate = project[0][9];
	              
	              var row = '<tr>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
	              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
	              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
	              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (TeamLeader ? TeamLeader : 'NA') + '</td>' +
	              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
	              '<td>' + (tester ? tester : 'NA') + '</td>' +
	              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
	              '</tr>';
	          $('#ProjectDetailsByName tbody').append(row);
	      });
	      } else {
	          // No data received
//	          console.log("No data received");
	          $('#ProjectDetailsByName tbody').append('<tr><td colspan="3">No projects found</td></tr>');
	      }
	  });

	}

   function ActivitiesOnTrackPM() {
		 
		$("#PMMODAL").modal("show")
		

		
		var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/PMS/getPMactonTrack";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          
	          success: function(data2) {
	             // alert("abc "+data2)
	        	  
	        	 if (data2 && data2.length > 0) {
	        		 var html = "  <option value=''> -- Please Select --</option>";
	                    for (var i = 0; i < data2.length; i++) {
	                    	html += '<option value="' + data2[i] + '">' + data2[i]
	                    				+ '</option>';
	                    }
	
	                    document.getElementById("PMActprojectName").innerHTML = html;	
	

	                    //document.getElementById("productsuitupdate").innerHTML = html;	
	        	 }
	        	 else
	        	 {
	        		 $('#PMActprojectName tbody').append('<tr><td colspan="8">No Activities found</td></tr>');
	        	 }
	         		
	 		}
	 	});
	      

		
			
			//get Teamleader Name
			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/PMS/getTeamLeaderByMGR";

			$.ajax({
				type : 'POST',
				url : serviceUrl,
				dataType : 'json',
				success : function(data4) {

					var html = "<option value=''>-- Please Select --</option>";
					for (var i = 0; i < data4.length; i++) {
						var value = data4[i];
						html += '<option value="' + value + '">' + value + '</option>';
					}
					$("#PMActteamLeaderName").html(html); 
				}
			});
			
			
			
			//get Developer Name
			var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/Master/getDevelopersByManager";

			$.ajax({
				type : 'POST',
				url : serviceUrl,
				dataType : 'json',
				success : function(data4) {

					var html = "<option value=''>-- Please Select --</option>";
					for (var i = 0; i < data4.length; i++) {
						var value = data4[i];
						html += '<option value="' + value + '">' + value + '</option>';
					}
					$("#PMActprodmgr").html(html);
				}
			});
			
			
			var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < dataF.length; i++) {
			    var value = dataF[i];
			    html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#PMActFname").html(html);
			
			
			
			/// Table 
			
		  	var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/PMS/getAllActivitiesMGR";

			// Make AJAX request to fetch product manager names
			$.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',


			}).done(
					function(data2) {
//						alert("niininiii" + data2)
						// Check if data is received
						// console.log("Data received:", data2);

						// Clear existing table rows
						$('#PMProjectDetailsByName tbody').empty();

						// Populate table with project data
						if (data2 && data2.length > 0) {
							data2.forEach(function(project) {
								var Customername = project[0][0];
								var ProductSuite = project[0][1];
								var Producttool = project[0][2];
								var Functionname = project[0][3];
								var Activities = project[0][4];
								var TeamLeader = project[0][5];
								var Dev = project[0][6];
								var TaskEnddate = project[0][7];

								var row = '<tr>' + '<td>'
										+ (Customername ? Customername : 'NA')
										+ '</td>' + '<td>'
										+ (ProductSuite ? ProductSuite : 'NA')
										+ '</td>' + '<td>'
										+ (Producttool ? Producttool : 'NA') + '</td>'
										+ '<td>' + (Functionname ? Functionname : 'NA')
										+ '</td>' + '<td>'
										+ (Activities ? Activities : 'NA') + '</td>'
										+ '<td>' + (TeamLeader ? TeamLeader : 'NA')
										+ '</td>' + '<td>' + (Dev ? Dev : 'NA')
										+ '</td>' + '<td>'
										+ (TaskEnddate ? TaskEnddate : 'NA') + '</td>'
										+ '</tr>';
								$('#PMProjectDetailsByName tbody').append(row);
							});
						} else {
							// No data received
							// console.log("No data received");
							$('#PMProjectDetailsByName tbody').append(
									'<tr><td colspan="3">No projects found</td></tr>');
						}
					});
			

	}
   
   
   
   function checkRadioButtonMgr() {
	   $("#teamLeaders").val("");
	   $("#developers").val("");
	   
		var radiosMgr = document.getElementsByName('ManagerTable');

	    for (var i = 0; i < radiosMgr.length; i++) {
	        	if(radiosMgr[0].checked) {
	        		radioClickedMgr="ProgressTable";
	      	} else {
	        		radioClickedMgr = "TaskTable";
	        	}
	        //	alert(radioClickedMgr)
	    }

	    if(radioClickedMgr==="TaskTable"){
	    	$('#devDropdownDiv').show();
	    	$('#TLDropdownDiv').show();
	    	$('#AllDetailsOfProjectsProgressMgr').hide();
	    	$('#TaskDetailsManager').show();
	    	
	    	//   ProjectDetailsManagerTask     table ID
	    	
	    	var l = window.location;
		 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
		 	var serviceUrl = base_url + "/UserActivity/getTaskDetailsManager";
		 	
		    $.ajax({
		        type: 'POST',
		        url: serviceUrl,
		        dataType: 'json',
//		        data: 'TLname=' + tlName,
		        success: function(data5) {
//			alert("hxgdfg "+data5)
		        	 $('#ProjectDetailsManagerTask').DataTable().destroy();
		            var table = $("#ProjectDetailsManagerTask").DataTable({  
		                lengthChange: false,
		                pageLength: 10,
//		                paging: false,
		                data: data5,
		   //             scrollX: false,
//		                scrollY: '500px',
		                dom: 'Bfrtip',
		              
		            columnDefs: [
		                {
		                    targets: -1, // Target the last column
		                    render: function(data, type, row) {
		                    if(mainTable!="MDdashboard") {
		                    	if(data == 0){
		                    		 return '<span style="color: black;">' + data + '</span>';
		                    	} else if(data==="NA") {
		                   		 	return '<span style="color: black;">' + data + '</span>';
		                    	} else {
		                    		 return '<span style="color: red;">' + data + '</span>';
		                    	}
		                        // Customize the rendering to display data in red
		                    } else {
		                    	return data;
		                    }
		                    }
		                }
		            ],

		            });
		        }
		    });
	    	
	    } else if(radioClickedMgr==="ProgressTable"){
	    	$('#AllDetailsOfProjectsProgressMgr').show();
	    	$('#TaskDetailsManager').hide();
	    	$('#devDropdownDiv').hide();
	    	$('#TLDropdownDiv').hide();
	    	
	    	
	     	
	    	var l = window.location;
	     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	     	var serviceUrl = base_url + "/UserActivity/manualProposalApprovedDetailsMD";
	     	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
	     	$('#spin11').show();
	        $.ajax({
	            type: 'POST',
	            url: serviceUrl,
	            dataType: 'json',
	            success: function(data5) {
	            	$('#spin11').hide();
	    //alert("hxgdfg "+data5)
	    //console.log(data5)
	            	$('#ProjectDetailsManager').DataTable().destroy();
	                var table = $("#ProjectDetailsManager").DataTable({ 
	                    lengthChange: false,
	                    pageLength: 10,
	                    data: data5,
	                    scrollX: '300px',
//	                    scrollY: '300px',
	                    dom: 'Bfrtip', // Add this line to enable export buttons
	   
	                columnDefs: [
	                    {
	                        targets: -1, // Target the last column
	                        render: function(data, type, row) {
	                        if(mainTable!="MDdashboard") {
	                        	if(data == 0){
	                        		 return '<span style="color: black;">' + data + '</span>';
	                        	} else if(data==="NA") {
	                        		 return '<span style="color: black;">' + data + '</span>';
	                        	} else {
	                        		 return '<span style="color: red;">' + data + '</span>';
	                        	}
	                            // Customize the rendering to display data in red
	                        } else {
	                        	return data;
	                        }
	                        }
	                    }
	                ],

	                });
	            }
	        });
	    }
	    
	}
   
   
 function checkRadioButtonTL() {
	 
	  $("#developersOfTL").val("");
	 var radiosTL = document.getElementsByName('TLTable');
	  for (var i = 0; i < radiosTL.length; i++) {
      	if(radiosTL[0].checked) {
      		radioClickedTL ="ProgressTable";
    	} else {
      		radioClickedTL = "TaskTable";
      	}
      //	alert(radioClickedMgr)
	  }
	  
	  
	  
	  if(radioClickedTL==="TaskTable"){
	    	$('#developersDropdownDiv').show();
	    	$('#AllDetailsOfProjectsProgressTL').hide();
	    	$('#ProjectDetailTLTasksDiv').show();
	    	
	    	//   ProjectDetailsManagerTask     table ID
	    	
	    	var l = window.location;
		 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
		 	var serviceUrl = base_url + "/UserActivity/getTaskDetailsTL";
		 	
		    $.ajax({
		        type: 'POST',
		        url: serviceUrl,
		        dataType: 'json',
//		        data: 'TLname=' + tlName,
		        success: function(data5) {
//			alert("hxgdfg "+data5)
		        	 $('#ProjectDetailTLTasks').DataTable().destroy();
		            var table = $("#ProjectDetailTLTasks").DataTable({  
		                lengthChange: false,
		                pageLength: 10,
//		                paging: false,
		                data: data5,
		   //             scrollX: false,
//		                scrollY: '500px',
		                dom: 'Bfrtip',
		              
		            columnDefs: [
		                {
		                    targets: -1, // Target the last column
		                    render: function(data, type, row) {
		                    if(mainTable!="MDdashboard") {
		                    	if(data == 0){
		                    		 return '<span style="color: black;">' + data + '</span>';
		                    	} else if(data==="NA") {
		                   		 	return '<span style="color: black;">' + data + '</span>';
		                    	} else {
		                    		 return '<span style="color: red;">' + data + '</span>';
		                    	}
		                        // Customize the rendering to display data in red
		                    } else {
		                    	return data;
		                    }
		                    }
		                }
		            ],

		            });
		        }
		    });
	    	
	    } else if(radioClickedTL==="ProgressTable"){
	    	$('#AllDetailsOfProjectsProgressTL').show();
	    	$('#ProjectDetailTLTasksDiv').hide();
	    	$('#developersDropdownDiv').hide();
	    	
	    	
	     	
	    	var l = window.location;
	     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	     	var serviceUrl = base_url + "/UserActivity/manualProposalApprovedDetailsMD";
	     	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
	     	$('#spin11').show();
	        $.ajax({
	            type: 'POST',
	            url: serviceUrl,
	            dataType: 'json',
	            success: function(data5) {
	            	$('#spin11').hide();
	    //alert("hxgdfg "+data5)
	    //console.log(data5)
	            	$('#ProjectDetailsManager').DataTable().destroy();
	                var table = $("#ProjectDetailsManager").DataTable({ 
	                    lengthChange: false,
	                    pageLength: 10,
	                    data: data5,
	                    scrollX: '300px',
//	                    scrollY: '300px',
	                    dom: 'Bfrtip', // Add this line to enable export buttons
	   
	                columnDefs: [
	                    {
	                        targets: -1, // Target the last column
	                        render: function(data, type, row) {
	                        if(mainTable!="MDdashboard") {
	                        	if(data == 0){
	                        		 return '<span style="color: black;">' + data + '</span>';
	                        	} else if(data==="NA") {
	                        		 return '<span style="color: black;">' + data + '</span>';
	                        	} else {
	                        		 return '<span style="color: red;">' + data + '</span>';
	                        	}
	                            // Customize the rendering to display data in red
	                        } else {
	                        	return data;
	                        }
	                        }
	                    }
	                ],

	                });
	            }
	        });
	    }

 }
 
 
 
 function checkRadioButtonDev() {

	 //	  $("#developersOfTL").val("");
	 var radiosDev = document.getElementsByName('DevTaskTable');
	  for (var i = 0; i < radiosDev.length; i++) {
     	if(radiosDev[0].checked) {
     		radioClickedDev ="ProgressTable";
   	} else {
     		radioClickedDev = "TaskTable";
     	}
//     	alert(radioClickedDev)
	  }
	  
	  
	  if(radioClickedDev==="TaskTable"){
//		  alert("nnnnnn adjn")
	    	$('#ProjectDetailsDevTaskDiv').show();
	    	$('#ProjectDetailsDevDiv').hide();
	    	
	    	//   ProjectDetailsManagerTask     table ID
	    	
	    	var l = window.location;
		 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
		 	var serviceUrl = base_url + "/UserActivity/getTaskDetailsDev";
		 	
		    $.ajax({
		        type: 'POST',
		        url: serviceUrl,
		        dataType: 'json',
//		        data: 'TLname=' + tlName,
		        success: function(data5) {
//			alert("hxgdfg "+data5)
		        	 $('#ProjectDetailsDevTask').DataTable().destroy();
		            var table = $("#ProjectDetailsDevTask").DataTable({  
		                lengthChange: false,
		                pageLength: 10,
//		                paging: false,
		                data: data5,
		   //             scrollX: false,
//		                scrollY: '500px',
		                dom: 'Bfrtip',
		              
		            columnDefs: [
		                {
		                    targets: -1, // Target the last column
		                    render: function(data, type, row) {
		                    if(mainTable!="MDdashboard") {
		                    	if(data == 0){
		                    		 return '<span style="color: black;">' + data + '</span>';
		                    	} else if(data==="NA") {
		                   		 	return '<span style="color: black;">' + data + '</span>';
		                    	} else {
		                    		 return '<span style="color: red;">' + data + '</span>';
		                    	}
		                        // Customize the rendering to display data in red
		                    } else {
		                    	return data;
		                    }
		                    }
		                }
		            ],

		            });
		        }
		    });
	    	
	    } else if(radioClickedDev==="ProgressTable"){
	    	$('#ProjectDetailsDevDiv').show();
	    	$('#ProjectDetailsDevTaskDiv').hide();
	    	
	     	
	    	var l = window.location;
	     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	     	var serviceUrl = base_url + "/UserActivity/manualProposalApprovedDetailsMD";
	     	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
	     	$('#spin11').show();
	        $.ajax({
	            type: 'POST',
	            url: serviceUrl,
	            dataType: 'json',
	            success: function(data5) {
	            	$('#spin11').hide();
	    //alert("hxgdfg "+data5)
	    //console.log(data5)
	            	$('#ProjectDetailsDev').DataTable().destroy();
	                var table = $("#ProjectDetailsDev").DataTable({ 
	                    lengthChange: false,
	                    pageLength: 10,
	                    data: data5,
	                    scrollX: '300px',
//	                    scrollY: '300px',
	                    dom: 'Bfrtip', // Add this line to enable export buttons
	   
	                columnDefs: [
	                    {
	                        targets: -1, // Target the last column
	                        render: function(data, type, row) {
	                        if(mainTable!="MDdashboard") {
	                        	if(data == 0){
	                        		 return '<span style="color: black;">' + data + '</span>';
	                        	} else if(data==="NA") {
	                        		 return '<span style="color: black;">' + data + '</span>';
	                        	} else {
	                        		 return '<span style="color: red;">' + data + '</span>';
	                        	}
	                            // Customize the rendering to display data in red
	                        } else {
	                        	return data;
	                        }
	                        }
	                    }
	                ],

	                });
	            }
	        });
	    }

}
 
 
 
 
// 13/08
 function checkRadioButtonSupportTeam(){

		 //	  $("#developersOfTL").val("");
		 var radiosDev = document.getElementsByName('supportTaskTable');
		  for (var i = 0; i < radiosDev.length; i++) {
	     	if(radiosDev[0].checked) {
	     		radioClickedSupport ="ProgressTable";
	   	} else {
	   		radioClickedSupport = "TaskTable";
	     	}
//	     	alert(radioClickedDev)
		  }
		  
		  
		  if(radioClickedSupport==="TaskTable"){
//			  alert("tasktable clicked");
//			  alert("nnnnnn adjn")
		    	$('#ProjectDetailsDevTaskDivsupportteam').show();
		    	$('#ProjectDetailsDevDivsupportteam').hide();
		    	
		    	//   ProjectDetailsManagerTask     table ID
		    	
		    	var l = window.location;
			 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
			 	var serviceUrl = base_url + "/UserActivity/getTaskDetailsDev";
			 	
			    $.ajax({
			        type: 'POST',
			        url: serviceUrl,
			        dataType: 'json',
//			        data: 'TLname=' + tlName,
			        success: function(data5) {
//				alert("hxgdfg "+data5)
			        	 $('#ProjectDetailsDevTasksupportteam').DataTable().destroy();
//			        	if ($.fn.DataTable.isDataTable('#ProjectDetailsDevTasksupportteam')) {
//			        		$('#ProjectDetailsDevTasksupportteam').DataTable().clear().destroy();
//			        	}

			        	 var table = $("#ProjectDetailsDevTasksupportteam").DataTable({  
			                lengthChange: false,
			                pageLength: 10,
//			                paging: false,
			                data: data5,
			   //             scrollX: false,
//			                scrollY: '500px',
			                dom: 'Bfrtip',
			              
			            columnDefs: [
			                {
			                    targets: -1, // Target the last column
			                    render: function(data, type, row) {
			                    if(mainTable!="MDdashboard") {
			                    	if(data == 0){
			                    		 return '<span style="color: black;">' + data + '</span>';
			                    	} else if(data==="NA") {
			                   		 	return '<span style="color: black;">' + data + '</span>';
			                    	} else {
			                    		 return '<span style="color: red;">' + data + '</span>';
			                    	}
			                        // Customize the rendering to display data in red
			                    } else {
			                    	return data;
			                    }
			                    }
			                }
			            ],

			            });
			        }
			    });
		    	
		    } else if(radioClickedSupport==="ProgressTable"){
//		    	alert("progress table clicked");
		    	$('#ProjectDetailsDevDivsupportteam').show();
		    	$('#ProjectDetailsDevTaskDivsupportteam').hide();
		    	
		     	
		    	var l = window.location;
		     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		     	var serviceUrl = base_url + "/UserActivity/manualProposalApprovedDetailsMD";
		     	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
		     	$('#spin11').show();
		        $.ajax({
		            type: 'POST',
		            url: serviceUrl,
		            dataType: 'json',
		            success: function(data5) {
		            	$('#spin11').hide();
		    //alert("hxgdfg "+data5)
		    //console.log(data5)
		            	$('#ProjectDetailssupportteam').DataTable().destroy();
//		            	if ($.fn.DataTable.isDataTable('#ProjectDetailssupportteam')) {
//		            		$('#ProjectDetailsDevsupportteam').DataTable().clear().destroy();
//		            	}
		            	
		                var table = $("#ProjectDetailssupportteam").DataTable({ 
		                	
		                    lengthChange: false,
		                    pageLength: 10,
		                    data: data5,
		                    scrollX: '300px',
//		                    scrollY: '300px',
		                    dom: 'Bfrtip', // Add this line to enable export buttons
		   
		                columnDefs: [
		                    {
		                        targets: -1, // Target the last column
		                        render: function(data, type, row) {
		                        if(mainTable!="MDdashboard") {
		                        	if(data == 0){
		                        		 return '<span style="color: black;">' + data + '</span>';
		                        	} else if(data==="NA") {
		                        		 return '<span style="color: black;">' + data + '</span>';
		                        	} else {
		                        		 return '<span style="color: red;">' + data + '</span>';
		                        	}
		                            // Customize the rendering to display data in red
		                        } else {
		                        	return data;
		                        }
		                        }
		                    }
		                ],

		                });
		            }
		        });
		    }
 }
 //
 
 
 //16/08
 function checkRadioButtonTesterTeam(){

		 //	  $("#developersOfTL").val("");
		 var radiosDev = document.getElementsByName('testerTaskTable');
		  for (var i = 0; i < radiosDev.length; i++) {
	     	if(radiosDev[0].checked) {
	     		radioClickedSupport ="ProgressTable";
	   	} else {
	   		radioClickedSupport = "TaskTable";
	     	}
//	     	alert(radioClickedDev)
		  }
		  
		  
		  if(radioClickedSupport==="TaskTable"){
//			  alert("tasktable clicked");
//			  alert("nnnnnn adjn")
		    	$('#ProjectDetailsDevTaskDivtesterteam').show();
		    	$('#ProjectDetailsDevDivtesterteam').hide();
		    	
		    	//   ProjectDetailsManagerTask     table ID
		    	
		    	var l = window.location;
			 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//			 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
			 	var serviceUrl = base_url + "/UserActivity/getTaskDetailsDev";
			 	
			    $.ajax({
			        type: 'POST',
			        url: serviceUrl,
			        dataType: 'json',
//			        data: 'TLname=' + tlName,
			        success: function(data5) {
//				alert("hxgdfg "+data5)
			        	 $('#ProjectDetailsDevTasktesterteam').DataTable().destroy();
//			        	if ($.fn.DataTable.isDataTable('#ProjectDetailsDevTasksupportteam')) {
//			        		$('#ProjectDetailsDevTasksupportteam').DataTable().clear().destroy();
//			        	}

			        	 var table = $("#ProjectDetailsDevTasktesterteam").DataTable({  
			                lengthChange: false,
			                pageLength: 10,
//			                paging: false,
			                data: data5,
			   //             scrollX: false,
//			                scrollY: '500px',
			                dom: 'Bfrtip',
			              
			            columnDefs: [
			                {
			                    targets: -1, // Target the last column
			                    render: function(data, type, row) {
			                    if(mainTable!="MDdashboard") {
			                    	if(data == 0){
			                    		 return '<span style="color: black;">' + data + '</span>';
			                    	} else if(data==="NA") {
			                   		 	return '<span style="color: black;">' + data + '</span>';
			                    	} else {
			                    		 return '<span style="color: red;">' + data + '</span>';
			                    	}
			                        // Customize the rendering to display data in red
			                    } else {
			                    	return data;
			                    }
			                    }
			                }
			            ],

			            });
			        }
			    });
		    	
		    } else if(radioClickedSupport==="ProgressTable"){
//		    	alert("progress table clicked");
		    	$('#ProjectDetailsDevDivtesterteam').show();
		    	$('#ProjectDetailsDevTaskDivtesterteam').hide();
		    	
		     	
		    	var l = window.location;
		     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		     	var serviceUrl = base_url + "/UserActivity/manualProposalApprovedDetailsMD";
		     	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
		     	$('#spin11').show();
		        $.ajax({
		            type: 'POST',
		            url: serviceUrl,
		            dataType: 'json',
		            success: function(data5) {
		            	$('#spin11').hide();
		    //alert("hxgdfg "+data5)
		    //console.log(data5)
		            	$('#ProjectDetailstesterteam').DataTable().destroy();
//		            	if ($.fn.DataTable.isDataTable('#ProjectDetailssupportteam')) {
//		            		$('#ProjectDetailsDevsupportteam').DataTable().clear().destroy();
//		            	}
		            	
		                var table = $("#ProjectDetailstesterteam").DataTable({ 
		                	
		                    lengthChange: false,
		                    pageLength: 10,
		                    data: data5,
		                    scrollX: '300px',
//		                    scrollY: '300px',
		                    dom: 'Bfrtip', // Add this line to enable export buttons
		   
		                columnDefs: [
		                    {
		                        targets: -1, // Target the last column
		                        render: function(data, type, row) {
		                        if(mainTable!="MDdashboard") {
		                        	if(data == 0){
		                        		 return '<span style="color: black;">' + data + '</span>';
		                        	} else if(data==="NA") {
		                        		 return '<span style="color: black;">' + data + '</span>';
		                        	} else {
		                        		 return '<span style="color: red;">' + data + '</span>';
		                        	}
		                            // Customize the rendering to display data in red
		                        } else {
		                        	return data;
		                        }
		                        }
		                    }
		                ],

		                });
		            }
		        });
		    }
 }
 //
 
 //
 
 
 
 
 
 
// function checkRadioButtonSupportTeam() {
//
//	    // Get all radio buttons with name 'supportTaskTable'
//	    var radiosDev = document.getElementsByName('supportTaskTable');
//	    var radioClickedSupport = '';
//
//	    // Determine which radio button is checked
//	    for (var i = 0; i < radiosDev.length; i++) {
//	        if (radiosDev[i].checked) {
//	            radioClickedSupport = radiosDev[i].value === "ProgressTable" ? "ProgressTable" : "TaskTable";
//	            break; // Exit loop once the checked radio button is found
//	        }
//	    }
//
//	    if (radioClickedSupport === "TaskTable") {
//	        // Show TaskTable div and hide ProgressTable div
//	        $('#ProjectDetailsDevTaskDivsupportteam').show();
//	        $('#ProjectDetailsDevDivsupportteam').hide();
//
//	        // Prepare the service URL
//	        var l = window.location;
//	        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	        var serviceUrl = base_url + "/UserActivity/getTaskDetailsDev";
//
//	        // Make AJAX request to get task details
//	        $.ajax({
//	            type: 'POST',
//	            url: serviceUrl,
//	            dataType: 'json',
//	            success: function(data5) {
//	                // Destroy the existing DataTable instance if it exists
//	                if ($.fn.DataTable.isDataTable('#ProjectDetailsDevTasksupportteam')) {
//	                    $('#ProjectDetailsDevTasksupportteam').DataTable().destroy();
//	                }
//
//	                // Initialize DataTable with new data
//	                $('#ProjectDetailsDevTasksupportteam').DataTable({
//	                    lengthChange: false,
//	                    pageLength: 10,
//	                    data: data5,
//	                    dom: 'Bfrtip',
//	                    columnDefs: [
//	                        {
//	                            targets: -1,
//	                            render: function(data, type, row) {
//	                                if (mainTable !== "MDdashboard") {
//	                                    if (data == 0) {
//	                                        return '<span style="color: black;">' + data + '</span>';
//	                                    } else if (data === "NA") {
//	                                        return '<span style="color: black;">' + data + '</span>';
//	                                    } else {
//	                                        return '<span style="color: red;">' + data + '</span>';
//	                                    }
//	                                } else {
//	                                    return data;
//	                                }
//	                            }
//	                        }
//	                    ],
//	                });
//	            }
//	        });
//
//	    } else if (radioClickedSupport === "ProgressTable") {
//	        // Show ProgressTable div and hide TaskTable div
//	        $('#ProjectDetailsDevDivsupportteam').show();
//	        $('#ProjectDetailsDevTaskDivsupportteam').hide();
//
//	        // Prepare the service URL
//	        var l = window.location;
//	        var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	        var serviceUrl = base_url + "/UserActivity/getProjectDetails";
//
//	        // Show spinner
//	        $('#spin11').show();
//
//	        // Make AJAX request to get project details
//	        $.ajax({
//	            type: 'POST',
//	            url: serviceUrl,
//	            dataType: 'json',
//	            success: function(data5) {
//	                // Hide spinner
//	                $('#spin11').hide();
//
//	                // Destroy the existing DataTable instance if it exists
//	                if ($.fn.DataTable.isDataTable('#ProjectDetailsDevsupportteam')) {
//	                    $('#ProjectDetailsDevsupportteam').DataTable().destroy();
//	                }
//
//	                // Initialize DataTable with new data
//	                $('#ProjectDetailsDevsupportteam').DataTable({
//	                    lengthChange: false,
//	                    pageLength: 10,
//	                    data: data5,
//	                    scrollX: '300px',
//	                    dom: 'Bfrtip',
//	                    columnDefs: [
//	                        {
//	                            targets: -1,
//	                            render: function(data, type, row) {
//	                                if (mainTable !== "MDdashboard") {
//	                                    if (data == 0) {
//	                                        return '<span style="color: black;">' + data + '</span>';
//	                                    } else if (data === "NA") {
//	                                        return '<span style="color: black;">' + data + '</span>';
//	                                    } else {
//	                                        return '<span style="color: red;">' + data + '</span>';
//	                                    }
//	                                } else {
//	                                    return data;
//	                                }
//	                            }
//	                        }
//	                    ],
//	                });
//	            }
//	        });
//	    }
//	}
 
 

 
 function resetAllDD() {
		//  alert("reset")
	  $('#ActprojectName').val("");
	  $('#Actprodmgr').val("");
	  $('#ActteamLeaderName').val("");
	  $('#ActFname').val("");
	  
	  nameManager= "";
	  productsuite="";
	  productmanager="";
	  teamleader="";
	  Actproductsuite="";
	  Actproductmanager="";
	  Actteamleader="";
	  
	  $('#projectNames').val("");
	  $('#prodmgr').val("");
	  $('#teamLeaderName').val("");
	  $('#Fname').val("");
	  
		var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getAllActivities";

	    // Make AJAX request to fetch product manager names
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
//	        data: {
//	        	productmanager: Actproductmanager,
//	        	productsuite:Actproductsuite,
//	        	teamleader:Actteamleader,
//	        	allfunction:Actalldata
//	        }

	    }).done(function(data2) {

	      $('#ProjectDetailsByName tbody').empty();

	    	
	      // Populate table with project data
	      if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	              var Customername = project[0][0];
	              var ProductManager = project[0][1];
	              var ProductSuite = project[0][2];
	              var Producttool = project[0][3];
	              var Functionname = project[0][4];
	              var Activities = project[0][5];
	              var TeamLeader = project[0][6];
	              var Dev = project[0][7];
//	              var tester = project[0][8];
	              var TaskEnddate = project[0][8];
	              
	              var row = '<tr>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
	              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
	              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
	              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (TeamLeader ? TeamLeader : 'NA') + '</td>' +
	              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//	              '<td>' + (tester ? tester : 'NA') + '</td>' +
	              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
	              '</tr>';
	          $('#ProjectDetailsByName tbody').append(row);
	      });
	      } else {
	          // No data received
//	          console.log("No data received");
	          $('#ProjectDetailsByName tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	      }
	  });
	    
	    
	    var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getActivitiesdalayscount";

	    // Make AJAX request to fetch product manager names
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
//	        data: {
//	        	productmanager: Actproductmanager,
//	        	projectName:Actproductsuite
//	        	teamleader:Actteamleader,
//	        	allfunction:Actalldata
//	        }

	    }).done(function(data2) {
	  //  	alert("niininiii "+data2)
	        // Check if data is received
//	      console.log("Data received:", data2);

	      // Clear existing table rows
	      $('#TotalcompletedProjectsTableMD tbody').empty();

	    	
	      // Populate table with project data
	      if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	        		var customer = project[0][0];
	           	 var manager = project[0][1];
	                var prodSuite = project[0][2];
	                var prodTool = project[0][3];
	                var functionName = project[0][4];
	               var description = project[0][5];
	               var TLName1 = project[0][6];
	               var developerName1 = project[0][7];
	               var endDate = project[0][8];

	              
	              var row = '<tr>' +
	              '<td>' + (customer ? customer : 'NA') + '</td>' +
	              '<td>' + (manager ? manager : 'NA') + '</td>' +
	              '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	              '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	              '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	              '<td>' + (description ? description : 'NA') + '</td>' +
	              '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	              '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	              '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	              '</tr>';
	          $('#TotalcompletedProjectsTableMD tbody').append(row);
	      });
	      } else {
	          // No data received
//	          console.log("No data received");
	          $('#TotalcompletedProjectsTableMD tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	      }
	  });
	    
	    
	    
	    var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/Master/getTeamLeader";     
		var serviceUrl = base_url + "/Master/getManagerList";
		
	$.ajax({

	  url :serviceUrl,
	  type : 'POST',
	  dataType: 'json',
	}).done(function(data) {
//		alert("Data "+data);
	  var html =" <select class='form-control' tabindex='8' id='Actprodmgr' name='Actprodmgr'>";
	  html=html+'<option value="">--Please Select--</option>';
	  for (var i = 0; i < data.length; i++) {
	      html += '<option value="' +data[i]+ '">' + data[i]
	      + '</option>';
	  }
	  document.getElementById("Actprodmgr").innerHTML=html;
	  document.getElementById("prodmgr").innerHTML=html;
	});	
	
	
	// get Teamleader Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getTeamLeader";
	var selectedValue = $("#teamLeader").val(); // Get the currently
	// selected value

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		// data : 'teamLeader=' + encodeURIComponent(selectedValue),
		success : function(data4) {

			// alert("function "+data4)
			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			 $("#teamLeaderName").html(html);
		        $("#ActteamLeaderName").html(html);
			
		}
	});
	        

	
	var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
	var html = "<option value=''>-- Please Select --</option>";
	for (var i = 0; i < dataF.length; i++) {
	    var value = dataF[i];
	    html += '<option value="' + value + '">' + value + '</option>';
	}
	$("#ActFname").html(html);   
	$("#Fname").html(html);
	    
	    
 }
 
 function PMActproductsuiteDetails(PMActproductsuites) {
	 
	 productsuite = PMActproductsuites;
	 
	 $("#PMActDlyteamLeaderName").val("");
	 $("#PMActDlyprodmgr").val("");
	 $("#PMActDlyFname").val("");
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getMGRdelayActivityByProj";

		$.ajax({
			url : serviceUrl, 
			type : 'POST', 
			dataType : 'json', 
			data : {
				projectName : PMActproductsuites 									

			}
		}).done(
				function(data2) { 
					
					$('#TotalcompletedProjectsTable1 tbody').empty();

					if (data2 && data2.length > 0) {
			            data2.forEach(function(activity) {
			                try {
			                    var customerName = activity.CustomerName;
			                    var productSuit = activity.ProductSuit;
			                    var productTool = activity.ProductTool;
			                    var functions = activity.Function;
			                    var description = activity.Description;
			                    var teamLeader = activity.TeamLeader;
			                    var developer = activity.Developer;
			                    var endDate = activity.EndDate;
			                    var delayDays = activity.DelayDays;
			                    
			                    // Create HTML row and append to table
			                    var row = '<tr>' +
			                    '<td>' + customerName + '</td>' +
			                    '<td>' + productSuit + '</td>' +
			                    '<td>' + productTool + '</td>' +
			                    '<td>' + functions + '</td>' +
			                    '<td>' + description + '</td>' +
			                    '<td>' + teamLeader + '</td>' +
			                    '<td>' + developer + '</td>' +
			                    '<td>' + endDate + '</td>' +
			                    '<td style="color: red;">' + delayDays + '</td>' + // Corrected style attribute
			                    '</tr>';

			                    $('#TotalcompletedProjectsTable1 tbody').append(row);
			                } catch (error) {
			                    console.error('Error parsing activity data:', error);
			                }
			            });
			        } else {
			            // No data received
			            $('#TotalcompletedProjectsTable1 tbody').append('<tr><td colspan="6">No activities found</td></tr>');
			        }
				}).fail(function(jqXHR, textStatus, errorThrown) { 
														
			console.error("AJAX request failed:", textStatus, errorThrown);
		});
		

	
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getproductsuiteActontrackPM";

		$
				.ajax({
					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
					data : "projectNames=" + PMActproductsuites,
				})
				.done(
						function(data) {
							// Alert received data for debugging
							// alert("Data: " + JSON.stringify(data));

							var html = "<select class='form-control' tabindex='8' id='PMActteamLeaderName' name='PMActteamLeaderName'>";
							html += '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							html += "</select>";

							$("#PMActteamLeaderName").html(html);
							$("#PMActDlyteamLeaderName").html(html);
	
						});

	}

	function PMActteamLeaderDetails(TLNamesDetails) {
		// alert("hihi555555555")
		teamleader = TLNamesDetails;
		
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getMGRdelayActivityByTL";

		$.ajax({
			url : serviceUrl, 
			type : 'POST', 
			dataType : 'json', 
			data : {
				projectName : productsuite,
				tlname : teamleader
			}
		}).done(
				function(data2) { 
					
					$('#TotalcompletedProjectsTable1 tbody').empty();

					if (data2 && data2.length > 0) {
			            data2.forEach(function(activity) {
			                try {
			                    var customerName = activity.CustomerName;
			                    var productSuit = activity.ProductSuit;
			                    var productTool = activity.ProductTool;
			                    var functions = activity.Function;
			                    var description = activity.Description;
			                    var teamLeader = activity.TeamLeader;
			                    var developer = activity.Developer;
			                    var endDate = activity.EndDate;
			                    var delayDays = activity.DelayDays;
			                    
			                    // Create HTML row and append to table
			                    var row = '<tr>' +
			                    '<td>' + customerName + '</td>' +
			                    '<td>' + productSuit + '</td>' +
			                    '<td>' + productTool + '</td>' +
			                    '<td>' + functions + '</td>' +
			                    '<td>' + description + '</td>' +
			                    '<td>' + teamLeader + '</td>' +
			                    '<td>' + developer + '</td>' +
			                    '<td>' + endDate + '</td>' +
			                    '<td style="color: red;">' + delayDays + '</td>' + 
			                    '</tr>';

			                    $('#TotalcompletedProjectsTable1 tbody').append(row);
			                } catch (error) {
			                    console.error('Error parsing activity data:', error);
			                }
			            });
			        } else {
			            // No data received
			            $('#TotalcompletedProjectsTable1 tbody').append('<tr><td colspan="6">No activities found</td></tr>');
			        }
				}).fail(function(jqXHR, textStatus, errorThrown) { 
														
			console.error("AJAX request failed:", textStatus, errorThrown);
		});
		
		
		

		// Get base URL and service URL
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getDevNameActonTrackPM";

		$
				.ajax({
					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
					data : {
						producttool : productsuite,
						tlnames : teamleader
					}

				})
				.done(
						function(data) {
							// alert("Data333: " + JSON.stringify(data));

							var html = "<select class='form-control' tabindex='8' id='PMActDlyprodmgr' name='PMActDlyprodmgr'>";
							html += '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							html += "</select>";

							$("#PMActDlyprodmgr").html(html);
						});

	}

	function PMActproductmangerDetails(Devnames) {
		// alert("333333")
		PMDevnames = Devnames;
//		alert("Proj Name "+productsuite);
//		alert("TL "+teamleader);
	
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getMGRdelayActivityByDev";

		$.ajax({
			url : serviceUrl, 
			type : 'POST', 
			dataType : 'json', 
			data : {
				projectName : productsuite,
				tlname : teamleader,
				devname : Devnames
			}
		}).done(
				function(data2) { 
					
					$('#TotalcompletedProjectsTable1 tbody').empty();

					if (data2 && data2.length > 0) {
			            data2.forEach(function(activity) {
			                try {
			                    var customerName = activity.CustomerName;
			                    var productSuit = activity.ProductSuit;
			                    var productTool = activity.ProductTool;
			                    var functions = activity.Function;
			                    var description = activity.Description;
			                    var teamLeader = activity.TeamLeader;
			                    var developer = activity.Developer;
			                    var endDate = activity.EndDate;
			                    var delayDays = activity.DelayDays;
			                    
			                    var row = '<tr>' +
			                    '<td>' + customerName + '</td>' +
			                    '<td>' + productSuit + '</td>' +
			                    '<td>' + productTool + '</td>' +
			                    '<td>' + functions + '</td>' +
			                    '<td>' + description + '</td>' +
			                    '<td>' + teamLeader + '</td>' +
			                    '<td>' + developer + '</td>' +
			                    '<td>' + endDate + '</td>' +
			                    '<td style="color: red;">' + delayDays + '</td>' + 
			                    '</tr>';

			                    $('#TotalcompletedProjectsTable1 tbody').append(row);
			                } catch (error) {
			                    console.error('Error parsing activity data:', error);
			                }
			            });
			        } else {
			            // No data received
			            $('#TotalcompletedProjectsTable1 tbody').append('<tr><td colspan="6">No activities found</td></tr>');
			        }
				}).fail(function(jqXHR, textStatus, errorThrown) { 
														
			console.error("AJAX request failed:", textStatus, errorThrown);
		});
		
		
		

		// Get base URL and service URL
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getfunctionnameActonTrackforPM";

		$
				.ajax({
					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
					data : {
						projectname : $('#PMActDlyprojectName').val(),
						Teamleadername : $('#PMActDlyteamLeaderName').val(),
						Devname : Devnames
					}

				})
				.done(
						function(data) {
							// Alert received data for debugging
							// alert("Data33333333: " + JSON.stringify(data));

							// Generate HTML for select dropdown
							var html = "<select class='form-control' tabindex='8' id='PMActFname' name='PMActFname'>";
							html += '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							html += "</select>";

							// Populate select dropdown with generated HTML
							$("#PMActFname").html(html);
							$("#PMActDlyFname").html(html);
						});
	}
	function PMActtoalldatafeatchn(Actalldata) {
//		alert("fn")
		// Get base URL and service URL
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getallfunctionnameActonTracksPM";

		// Make AJAX request to fetch product manager names
		$.ajax({
			url : serviceUrl,
			type : 'POST',
			dataType : 'json',
			data : {
				projectname : $('#PMActprojectName').val(),
				tlname : $('#PMActteamLeaderName').val(),
				devname : $('#PMActprodmgr').val(),
				allfunction : Actalldata
			}

		}).done(
				function(data2) {
//					alert("niininiii" + data2)
					// Check if data is received
					// console.log("Data received:", data2);

					// Clear existing table rows
					$('#PMProjectDetailsByName tbody').empty();

					// Populate table with project data
					if (data2 && data2.length > 0) {
						data2.forEach(function(project) {
							var Customername = project[0][0];
							var ProductSuite = project[0][1];
							var Producttool = project[0][2];
							var Functionname = project[0][3];
							var Activities = project[0][4];
							var TeamLeader = project[0][5];
							var Dev = project[0][6];
							var tester = project[0][7];
							var TaskEnddate = project[0][8];

							var row = '<tr>' + '<td>'
									+ (Customername ? Customername : 'NA')
									+ '</td>' + '<td>'
									+ (ProductSuite ? ProductSuite : 'NA')
									+ '</td>' + '<td>'
									+ (Producttool ? Producttool : 'NA') + '</td>'
									+ '<td>' + (Functionname ? Functionname : 'NA')
									+ '</td>' + '<td>'
									+ (Activities ? Activities : 'NA') + '</td>'
									+ '<td>' + (TeamLeader ? TeamLeader : 'NA')
									+ '</td>' + '<td>' + (Dev ? Dev : 'NA')
									+ '</td>' + '<td>' + (tester ? tester : 'NA')
									+ '</td>' + '<td>'
									+ (TaskEnddate ? TaskEnddate : 'NA') + '</td>'
									+ '</tr>';
							$('#PMProjectDetailsByName tbody').append(row);
						});
					} else {
						// No data received
						// console.log("No data received");
						$('#PMProjectDetailsByName tbody').append(
								'<tr><td colspan="3">No projects found</td></tr>');
					}
				});

	}

	function MgrActivitiesDelayed() {
//		alert("111")
		$("#TotalActivitiesDelayedModal1").modal("show")
		
		var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getallMGRdelayActivity"; 

	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',

	    }).done(function(data2) {
	    	
		$('#TotalcompletedProjectsTable1 tbody').empty();

		if (data2 && data2.length > 0) {
            data2.forEach(function(activity) {
                try {
                    var customerName = activity.CustomerName;
                    var productSuit = activity.ProductSuit;
                    var productTool = activity.ProductTool;
                    var functions = activity.Function;
                    var description = activity.Description;
                    var teamLeader = activity.TeamLeader;
                    var developer = activity.Developer;
                    var endDate = activity.EndDate;
                    var delayDays = activity.DelayDays;
                    
                    // Create HTML row and append to table
                    var row = '<tr>' +
                    '<td>' + customerName + '</td>' +
                    '<td>' + productSuit + '</td>' +
                    '<td>' + productTool + '</td>' +
                    '<td>' + functions + '</td>' +
                    '<td>' + description + '</td>' +
                    '<td>' + teamLeader + '</td>' +
                    '<td>' + developer + '</td>' +
                    '<td>' + endDate + '</td>' +
                    '<td style="color: red;">' + delayDays + '</td>' + // Corrected style attribute
                    '</tr>';

                    $('#TotalcompletedProjectsTable1 tbody').append(row);
                } catch (error) {
                    console.error('Error parsing activity data:', error);
                }
            });
        } else {
            // No data received
            $('#TotalcompletedProjectsTable1 tbody').append('<tr><td colspan="9">No activities found</td></tr>');
        }
	}).fail(function(jqXHR, textStatus, errorThrown) { 
									
console.error("AJAX request failed:", textStatus, errorThrown);
});
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getMgrDelaysActivities";

		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',

			success : function(data2) {
//				 alert("abc "+data2)
				var html = "  <option value=''> -- Please Select --</option>";
				for (var i = 0; i < data2.length; i++) {
					html += '<option value="' + data2[i] + '">' + data2[i]
							+ '</option>';
				}
				document.getElementById("PMActDlyprojectName").innerHTML = html;

			}
		});
		
		
		
		//get Teamleader Name
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getTeamLeaderByMGR";

		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			success : function(data4) {

				var html = "<option value=''>-- Please Select --</option>";
				for (var i = 0; i < data4.length; i++) {
					var value = data4[i];
					html += '<option value="' + value + '">' + value + '</option>';
				}
				$("#PMActDlyteamLeaderName").html(html); // Update the select element	
			}
		});
		
		
		
		//get Teamleader Name
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getDevelopersByManager";

		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			success : function(data4) {

				var html = "<option value=''>-- Please Select --</option>";
				for (var i = 0; i < data4.length; i++) {
					var value = data4[i];
					html += '<option value="' + value + '">' + value + '</option>';
				}
				$("#PMActDlyprodmgr").html(html); // Update the select element	
			}
		});
		
		
		var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
		var html = "<option value=''>-- Please Select --</option>";
		for (var i = 0; i < dataF.length; i++) {
		    var value = dataF[i];
		    html += '<option value="' + value + '">' + value + '</option>';
		}
		$("#PMActFname").html(html);   
		$("#PMActDlyFname").html(html);

	}

	function PMActtoalldatafeatchnDly(Actalldata) {
		// Display alert to indicate function execution
//		alert("fn33");

		// Get base URL and service URL
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getallfunctionnameActonTracksPMDly";

		$.ajax({
			url : serviceUrl, 
			type : 'POST', 
			dataType : 'json', 
			data : {
				projectname : $('#PMActDlyprojectName').val(), 
				tlname : $('#PMActDlyteamLeaderName').val(),
				devname : $('#PMActDlyprodmgr').val(),
				allfunction : Actalldata
			}
		}).done(
				function(data2) { 
					
					$('#TotalcompletedProjectsTable1 tbody').empty();

					if (data2 && data2.length > 0) {
			            data2.forEach(function(activity) {
			                try {
			                    var customerName = activity.CustomerName;
			                    var productSuit = activity.ProductSuit;
			                    var productTool = activity.ProductTool;
			                    var functions = activity.Function;
			                    var description = activity.Description;
			                    var teamLeader = activity.TeamLeader;
			                    var developer = activity.Developer;
			                    var endDate = activity.EndDate;
			                    var delayDays = activity.DelayDays;
			                    
			                    var row = '<tr>' +
			                    '<td>' + customerName + '</td>' +
			                    '<td>' + productSuit + '</td>' +
			                    '<td>' + productTool + '</td>' +
			                    '<td>' + functions + '</td>' +
			                    '<td>' + description + '</td>' +
			                    '<td>' + teamLeader + '</td>' +
			                    '<td>' + developer + '</td>' +
			                    '<td>' + endDate + '</td>' +
			                    '<td style="color: red;">' + delayDays + '</td>' + // Corrected style attribute
			                    '</tr>';

			                    $('#TotalcompletedProjectsTable1 tbody').append(row);
			                } catch (error) {
			                    console.error('Error parsing activity data:', error);
			                }
			            });
			        } else {
			            // No data received
			            $('#TotalcompletedProjectsTable1 tbody').append('<tr><td colspan="6">No activities found</td></tr>');
			        }
				}).fail(function(jqXHR, textStatus, errorThrown) { 
			console.error("AJAX request failed:", textStatus, errorThrown);
		});
	}

	function ToatlprojectPM() {
	    // Display an alert with the message "111"
	    // alert("111");

	    // Show the modal with the id "totolProjectsModal"
	    $("#totolProjectsModal").modal("show");
	    
	    

	    // Get base URL and service URL
	    var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getMgrTotalProject";

	    // Make AJAX request to fetch data
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        success: function(data2) {
	        	console.log(data2);
	            // Clear existing table rows
	            $('#TotoprojectMGR tbody').empty();

	            // Iterate through data and populate the table
	            
	            if (data2 && data2.length > 0) {
	            data2.forEach(function(project) {
	                // Extract project attributes
	                var projectName = project[0][0];
	                var productSuite = project[0][1];
	                var productTool = project[0][2];
//	                var functions = project[0][3];
	                var completionDate = project[0][4];
	                var projectStatus = project[0][5];
	                

	                // Debugging: Alert the project status
//	                alert("projectStatus: " + projectStatus);

	                // Create a new table row
	                var row = $('<tr>');

	                // Create table data elements and append to the row
	                $('<td>').text(projectName).appendTo(row);
	                $('<td>').text(productSuite).appendTo(row);
	                $('<td>').text(productTool).appendTo(row);
	                
	                
	               
//	                $('<td>').text(functions).appendTo(row);

	                $('<td>').text(completionDate).appendTo(row);
	                
	                // Create a cell for project status and apply class based on status
	                var statusCell = $('<td>').text(projectStatus).appendTo(row);
	                statusCell.addClass(getStatusClass(projectStatus)); // Add class based on project status

	                // Append the row to the table body
	                $('#TotoprojectMGR tbody').append(row);
	            });
	            }
	            else {
	                // No data received
//	                console.log("No data received");
	                $('#TotoprojectMGR tbody').append('<tr><td colspan="5">No projects found</td></tr>');
	            }

	            // Function to determine the CSS class based on project status
	            function getStatusClass(status) {
	                if (status === 'Completed') {
	                    return 'completed';
	                } else if (status === 'On Hold') {
	                    return 'on-hold';
	                } else {
	                    return 'pending'; // Default class if status doesn't match
	                }
	            }
	        } // Close success callback function
	    }); // Close AJAX request
	}



	function projectontrackMGR() {
	    // Display an alert with the message "111"
//	    alert("111");

	    // Show the modal with the id "totolProjectsModal"
	    $("#projectontrackmgrModal").modal("show");

	    // Get base URL and service URL
	    var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getprojectontrackMGR";

	    // Make AJAX request to fetch data
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        success: function(data2) {
	            // Clear existing table rows
	            $('#projectontrackMGR tbody').empty();

	            // Iterate through data and populate the table
	            if (data2 && data2.length > 0) {
	            
	            data2.forEach(function(project) {
	                // Extract project attributes
	                var projectName = project[0][0];
	                var productSuite = project[0][1];
	                var productTool = project[0][2];
//	                var functions = project[0][3];
	                var completionDate = project[0][4];
	                var projectStatus = project[0][5];

	                // Create a new table row
	                var row = $('<tr>');

	                // Create table data elements and append to the row
	                $('<td>').text(projectName).appendTo(row);
	                $('<td>').text(productSuite).appendTo(row);
	                $('<td>').text(productTool).appendTo(row);
//	                $('<td>').text(functions).appendTo(row);
	                $('<td>').text(completionDate).appendTo(row);
	                $('<td>').text(projectStatus).appendTo(row);

	                // Append the row to the table body
	                $('#projectontrackMGR tbody').append(row);
	            });
	            }
	            else {
	                // No data received
//	                console.log("No data received");
	                $('#projectontrackMGR tbody').append('<tr><td colspan="5">No projects found</td></tr>');
	            }
	        }


	    });
	}
	function CompletedprojectMGR() {
	    // Display an alert with the message "111"
//	    alert("111");

	    // Show the modal with the id "totolProjectsModal"
	    $("#projectcompletedmgrModal").modal("show");

	    // Get base URL and service URL
	    var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getprojectcompletedMGR";

	    // Make AJAX request to fetch data
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        success: function(data2) {
//	        	alert("data2"+data2);
	            // Clear existing table rows
	            $('#projectcompltedMGR tbody').empty();

	            // Iterate through data and populate the table
	            if (data2 && data2.length > 0) {
	            
	            data2.forEach(function(project) {
	                // Extract project attributes
	                var projectName = project[0][0];
	                var productSuite = project[0][1];
	                var productTool = project[0][2];
//	                var functions = project[0][3];
	                var completionDate = project[0][4];
	                var projectStatus = project[0][5];

	                // Create a new table row
	                var row = $('<tr>');

	                // Create table data elements and append to the row
	                $('<td>').text(projectName).appendTo(row);
	                $('<td>').text(productSuite).appendTo(row);
	                $('<td>').text(productTool).appendTo(row);
//	                $('<td>').text(functions).appendTo(row);
	                $('<td>').text(completionDate).appendTo(row);
	                $('<td>').text(projectStatus).appendTo(row);

	                // Append the row to the table body
	                $('#projectcompltedMGR tbody').append(row);
	            });
	            }
	            else {
	                // No data received
//	                console.log("No data received");
	                $('#projectcompltedMGR tbody').append('<tr><td colspan="6">No projects found</td></tr>');
	            }
	        }


	    });
	}


	function DelayprojectMGR() {
	    // Display an alert with the message "111"
//	    alert("111");

	    // Show the modal with the id "totolProjectsModal"
	    $("#projectDealymgrModal").modal("show");

	    // Get base URL and service URL
	    var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getprojectdealyedMGR";

	    // Make AJAX request to fetch data
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        success: function(data2) {
	            // Clear existing table rows
	            $('#projectdelayMGR tbody').empty();

	            // Iterate through data and populate the table
	            if (data2 && data2.length > 0) {
	            
	            data2.forEach(function(project) {
	                // Extract project attributes
	                var projectName = project[0][0];
	                var productSuite = project[0][1];
	                var productTool = project[0][2];
//	                var functions = project[0][3];
	                var completionDate = project[0][4];
	                var projectStatus = project[0][5];

	                // Create a new table row
	                var row = $('<tr>');

	                // Create table data elements and append to the row
	                $('<td>').text(projectName).appendTo(row);
	                $('<td>').text(productSuite).appendTo(row);
	                $('<td>').text(productTool).appendTo(row);
//	                $('<td>').text(functions).appendTo(row);
	                $('<td>').text(completionDate).appendTo(row);
	                $('<td>').text(projectStatus).appendTo(row);

	                // Append the row to the table body
	                $('#projectdelayMGR tbody').append(row);
	            });
	            }else {
	                // No data received
//	              console.log("No data received");
	              $('#projectdelayMGR tbody').append('<tr><td colspan="6">No projects found</td></tr>');
	          }
	        }


	    });
	}
	
	
////////////////////////////////////////////-----------Team Lead Card Modal  Total Project Count-------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 
	
function TeamLeadTotalProjectCount() {

	      $("#ProjectsOnTrackTLModal").modal("show");

	      var l = window.location;
	      var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	      var serviceUrl = base_url + "/PMS/getTeamLeaderTotalproject";
	      var TotalProjects = "TotalProjects";
	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          data: "methodName=" + TotalProjects ,
	          success: function(data2) {
	        	  
//	        	  alert(data2)
	              // Check if data is received
//	              console.log("Data received:", data2);

	              // Clear existing table rows
	              $('#TLProjectsOnTrackTable tbody').empty();

	              // Populate table with project data
	              if (data2 && data2.length > 0) {
	                  data2.forEach(function(project) {
	                      var projectName = project[0][0];
	                      var prodSuite = project[0][1];
	                      var prodTool = project[0][2];
	                      var date = project[0][3];
	                      var managerName3 = project[0][4];
	                      var status = project[0][5];
	                      
	                      
	                      function getStatusClass(status) {
	          	            if (status === 'Completed') {
	          	                return 'completed';
	          	            } else if (status === 'On Hold') {
	          	                return 'on-hold';
	          	            } else {
	          	                return 'pending'; // Default class if status doesn't match
	          	            }
	          	        }
	                      var row = '<tr>' +
	                          '<td>' + projectName + '</td>' +
	                          '<td>' + prodSuite + '</td>' +
	                          '<td>' + prodTool + '</td>' +
	                          '<td>' + date + '</td>' +
	                          '<td>' + managerName3 + '</td>' +
	                          '<td class="' + getStatusClass(status) + '">' + status + '</td>' + // Set class based on status
	                          '</tr>';
	                      
	                      
	                      $('#TLProjectsOnTrackTable tbody').append(row);
	                  });
	              } else {
	                  // No data received
//	                  console.log("No data received");
	                  $('#TLProjectsOnTrackTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
	              }
	          },
	          error: function(xhr, status, error) {
	              console.error('Error fetching project data:', error);
	              // Show error message in table
	              $('#TLProjectsOnTrackTable tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
	          }
	      });	
	}

	////////////////////////////////////////////-----------End Team Lead Card Modal  Total Project Count-------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 

	
	


////////////////////////////////////////////-----------Team Lead Card Modal  Total Completed Project Count-------------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ 

function TeamLeadTotalCompleteProjects() {
//	alert("sjdn")
    $("#TeamLeaderTotalcompletedProjectsModal").modal("show");

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//    var serviceUrl = base_url + "/PMS/getTeamLeaderTotalcompletedproject";
    var serviceUrl = base_url + "/PMS/getTeamLeaderTotalproject"; 
    var CompletedProjects = "CompletedProjects";
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "methodName=" + CompletedProjects ,
        success: function(data2) {
            // Check if data is received
//            console.log("Data received:", data2);
//alert("3333"+data2)
            // Clear existing table rows
            $('#TeamLeaderTotalcompletedProjectsTable tbody').empty();

            // Populate table with project data
            if (data2 && data2.length > 0) {
                data2.forEach(function(project) {
                    var projectName = project[0][0];
                    var prodSuite = project[0][1];
                    var prodTool = project[0][2];
                    var date = project[0][3];
                    var managerName3 = project[0][4];
                    var status = project[0][5];
                    var row = '<tr>' +
                        '<td>' + projectName + '</td>' +
                        '<td>' + prodSuite + '</td>' +
                        '<td>' + prodTool + '</td>' +
                        '<td>' + date + '</td>' +
                        '<td>' + managerName3 + '</td>' +
                        '<td>' + status + '</td>' +
                        '</tr>';
                    $('#TeamLeaderTotalcompletedProjectsTable tbody').append(row);
                });
            } else {
                // No data received
//                console.log("No data received");
                $('#TeamLeaderTotalcompletedProjectsTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#TeamLeaderTotalcompletedProjectsTable tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });
}

function TeamLeadProjectOnTrack() {
//	alert("sjdn")
    $("#TeamLeadprojectontrackmgrModal").modal("show");

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTeamLeaderTotalcompletedproject";
//    var serviceUrl = base_url + "/PMS/getTeamLeaderTotalproject"; 
    var CompletedProjects = "ontrack";
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "methodName=" + CompletedProjects ,
        success: function(data2) {
            // Check if data is received
//            console.log("Data received:", data2);
//alert("3333"+data2)
            // Clear existing table rows
            $('#TeamLeadProjectontrackMGR tbody').empty();

            // Populate table with project data
            if (data2 && data2.length > 0) {
                data2.forEach(function(project) {
                    var projectName = project[0][0];
                    var prodSuite = project[0][1];
                    var prodTool = project[0][2];
                    var date = project[0][3];
                    var managerName3 = project[0][4];
                    var status = project[0][5];
                    var row = '<tr>' +
                        '<td>' + projectName + '</td>' +
                        '<td>' + prodSuite + '</td>' +
                        '<td>' + prodTool + '</td>' +
                        '<td>' + date + '</td>' +
                        '<td>' + managerName3 + '</td>' +
                        '<td style="color:blue;">' + status + '</td>' +
                        '</tr>';
                    $('#TeamLeadProjectontrackMGR tbody').append(row);
                });
            } else {
                // No data received
//                console.log("No data received");
                $('#TeamLeadProjectontrackMGR tbody').append('<tr><td colspan="6">No projects found</td></tr>');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#TeamLeadProjectontrackMGR tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });
}

function TeamLeaderDelayproject() {
//	alert("sjdn")
    $("#TeamLeaderDelayProjectMODAL").modal("show");

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTeamLeaderTotalcompletedproject";
//    var serviceUrl = base_url + "/PMS/getTeamLeaderTotalproject"; 
    var DelayProjects = "delayProject";
    
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "methodName=" + DelayProjects ,
        success: function(data2) {
            // Check if data is received
//            console.log("Data received:", data2);
//alert("3333"+data2)
            // Clear existing table rows
            $('#TeamLeaderDelayedProjectList tbody').empty();

            // Populate table with project data
            if (data2 && data2.length > 0) {
                data2.forEach(function(project) {
                    var projectName = project[0][0];
                    var prodSuite = project[0][1];
                    var prodTool = project[0][2];
                    var date = project[0][3];
                    var managerName3 = project[0][4];
                    var status = project[0][5];
                    var row = '<tr>' +
                        '<td>' + projectName + '</td>' +
                        '<td>' + prodSuite + '</td>' +
                        '<td>' + prodTool + '</td>' +
                        '<td>' + date + '</td>' +
                        '<td>' + managerName3 + '</td>' +
                        '<td>' + status + '</td>' +
                        '</tr>';
                    $('#TeamLeaderDelayedProjectList tbody').append(row);
                });
            } else {
                // No data received
//                console.log("No data received");
                $('#TeamLeaderDelayedProjectList tbody').append('<tr><td colspan="6">No projects found</td></tr>');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            // Show error message in table
            $('#TeamLeaderDelayedProjectList tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });
}



//-------------------------------------------Start Team Leader Activities On Track Details-----------------------------------------------------------

function TeamLeaderActivitiesOnTrack() {
	
	$("#TeamLeadMODAL").modal("show")
	
	
		    var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/PMS/getTeamLeaderActivityOnTrack";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          
	          success: function(data2) {
	       
	         	 var html = "  <option value=''> -- Please Select --</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("TLActprojectName").innerHTML = html;	
	 				
	 		}
	 	});
	      
	      
		    var l = window.location;
		   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		   	var serviceUrl = base_url + "/PMS/getTeamLeaderFunctionName";

		      $.ajax({
		          type: 'POST',
		          url: serviceUrl,
		          dataType: 'json',
		          
		          success: function(data2) {
		       
		         	 var html = "  <option value=''> -- Please Select --</option>";
		 			                    for (var i = 0; i < data2.length; i++) {
		 				html += '<option value="' + data2[i] + '">' + data2[i]
		 						+ '</option>';
		 			}
		 			document.getElementById("TLActFname").innerHTML = html;	
		 				
		 		}
		 	});
		      
		      
		      var l = window.location;
			   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			   	var serviceUrl = base_url + "/PMS/getTeamLeaderAssignName";

			      $.ajax({
			          type: 'POST',
			          url: serviceUrl,
			          dataType: 'json',
			          
			          success: function(data2) {
			       
			         	 var html = "  <option value=''> -- Please Select --</option>";
			 			                    for (var i = 0; i < data2.length; i++) {
			 				html += '<option value="' + data2[i] + '">' + data2[i]
			 						+ '</option>';
			 			}
			 			document.getElementById("TLAssignedto").innerHTML = html;	
			 				
			 		}
			 	});
	
	
		var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getTeamLeaderActivities";

	    // Make AJAX request to fetch product manager names
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
//	        data: {
//	        	productmanager: Actproductmanager,
//	        	productsuite:Actproductsuite,
//	        	teamleader:Actteamleader,
//	        	allfunction:Actalldata
//	        }

	    }).done(function(data2) {
	  //  	alert("niininiii "+data2)
	        // Check if data is received


	      // Clear existing table rows
	      $('#TeamLeadProjectDetailsByName tbody').empty();

	    	
	      // Populate table with project data
	      if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	              var Customername = project[0][0];
	              var ProductManager = project[0][1];
	              var ProductSuite = project[0][2];
	              var Producttool = project[0][3];
	              var Functionname = project[0][4];
	              var Activities = project[0][5];
	              var Dev = project[0][6];
//	              var tester = project[0][8];
	              var TaskEnddate = project[0][7];
	              
	              var row = '<tr>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
	              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
	              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
	              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//	              '<td>' + (tester ? tester : 'NA') + '</td>' +
	              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
	              '</tr>';
	          $('#TeamLeadProjectDetailsByName tbody').append(row);
	      });
	      } else {
	          // No data received
//	          console.log("No data received");
	          $('#TeamLeadProjectDetailsByName tbody').append('<tr><td colspan="8">No Activities found</td></tr>');
	      }
	  });
	
	
	
	
	
	
	

		      
}

function TeamLeaderActproductsuiteDetails(projectName) {
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTeamLeaderDetailsByProjectName";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
//        	productmanager: Actproductmanager,
        	productsuite:projectName
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#TeamLeadProjectDetailsByName tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var Dev = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '</tr>';
          $('#TeamLeadProjectDetailsByName tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#TeamLeadProjectDetailsByName tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
	
	


	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getTeamLeaderAssignNameByProjectName";

//	alert("projectName "+projectName)
	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "projectNames=" + projectName,
			})
			.done(
					function(data) {
						// Alert received data for debugging
						// alert("Data: " + JSON.stringify(data));

						// Generate HTML for select dropdown
						var html = "<select class='form-control' tabindex='8' id='TLAssignedto' name='TLAssignedto'>";
						html += '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						html += "</select>";

						$("#TLAssignedto").html(html);
//						$("#PMActDlyteamLeaderName").html(html);
						
					});
	
}

function TeamLeaderActAssignedToDetails(AssignTo) {
	
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTeamLeaderDetailsByAssignToName";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
//        	productmanager: Actproductmanager,
        	projectName: $('#TLActprojectName').val(),
        	assignto : $("#TLAssignedto").val()
        	
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#TeamLeadProjectDetailsByName tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var Dev = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '</tr>';
          $('#TeamLeadProjectDetailsByName tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#TeamLeadProjectDetailsByName tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
	
	
	
	
	
	
	// Get base URL and service URL
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getproductsuiteActontrackPM";

	// Make AJAX request to fetch product suite data
	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "assignto=" + assignto + "&TLActprojectName=" + $('#TLActprojectName').val(),
			})
			.done(
					function(data) {
						// Alert received data for debugging
						// alert("Data: " + JSON.stringify(data));

						// Generate HTML for select dropdown
						var html = "<select class='form-control' tabindex='8' id='TLActFname' name='TLActFname'>";
						html += '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						html += "</select>";

						$("#TLActFname").html(html);
//						$("#PMActDlyteamLeaderName").html(html);
						
					});
	
		
	
				
	
}

function TeamLeadActtoalldatafeatchn(dataoffunction) {
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTeamLeaderDetailsByfunctionName";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
        	assignTo: $('#TLAssignedto').val(),
        	projectName: $('#TLActprojectName').val(),
        	functionName: dataoffunction,
      
        	
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#TeamLeadProjectDetailsByName tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var Dev = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '</tr>';
          $('#TeamLeadProjectDetailsByName tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#TeamLeadProjectDetailsByName tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
	
}

function resetTeamLeaderActonTrack() {
	
	
	$("#TLActprojectName").val("");
	$("#TLAssignedto").val("");
	$("#TLActFname").val("");
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTeamLeaderActivities";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: {
//        	productmanager: Actproductmanager,
//        	productsuite:Actproductsuite,
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
//        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#TeamLeadProjectDetailsByName tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var Dev = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '</tr>';
          $('#TeamLeadProjectDetailsByName tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#TeamLeadProjectDetailsByName tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
    
    
    
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getTeamLeaderAssignNameByProjectName";

//	alert("projectName "+projectName)
	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "projectNames=" + $("#TLActprojectName").val(),
			})
			.done(
					function(data) {
						// Alert received data for debugging
						// alert("Data: " + JSON.stringify(data));

						// Generate HTML for select dropdown
						var html = "<select class='form-control' tabindex='8' id='TLAssignedto' name='TLAssignedto'>";
						html += '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						html += "</select>";

						$("#TLAssignedto").html(html);
//						$("#PMActDlyteamLeaderName").html(html);
						
					});
    
    
	
	
	
}


//-------------------------------------------End Of Team Leader Activities On Track-----------------------------------------------------------



//											*****************************************************


//-------------------------------------------Start Team Leader Activities  Delayed Project Details-----------------------------------------------------------



function TeamLeadActivitiesDelayed(delayedProjectName) {
	

//	alert("111")
	$("#TeamLeadTotalActivitiesDelayedModal").modal("show")
	
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTeamLeaderDelayedProjectDetails";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
     

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#TeamLeadDelayedProjectTable tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var Dev = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              var DelayedDays = project[0][8];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '<td style="color:red">' + (DelayedDays ? DelayedDays : 'NA') + '</td>' +
              '</tr>';
          $('#TeamLeadDelayedProjectTable tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#TeamLeadDelayedProjectTable tbody').append('<tr><td colspan="9">No Activities found</td></tr>');
      }
  });
	
	
	
	
	

	var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/PMS/getTeamLeaderActivityDelayed";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          
	          success: function(data2) {
	       
	         	 var html = "  <option value=''> -- Please Select --</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("TeamLeaderDelayProject").innerHTML = html;	
	 				
	 		}
	 	});
	      
	      
		    var l = window.location;
		   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		   	var serviceUrl = base_url + "/PMS/getTeamLeaderFunctionName";

		      $.ajax({
		          type: 'POST',
		          url: serviceUrl,
		          dataType: 'json',
		          
		          success: function(data2) {
		       
		         	 var html = "  <option value=''> -- Please Select --</option>";
		 			                    for (var i = 0; i < data2.length; i++) {
		 				html += '<option value="' + data2[i] + '">' + data2[i]
		 						+ '</option>';
		 			}
		 			document.getElementById("TlDelayeFunctionName").innerHTML = html;	
		 				
		 		}
		 	});
		      
		      
		    var l = window.location;
		  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		  	var serviceUrl = base_url + "/PMS/getTeamLeadActivitiesDelayedByProjectName";

		  	// Make AJAX request to fetch product suite data
		  	$
		  			.ajax({
		  				url : serviceUrl,
		  				type : 'POST',
		  				dataType : 'json',
//		  				data : "ProjectName=" +ProjectName,
		  			})
		  			.done(
		  					function(data) {
		  						// Alert received data for debugging
//		  						 alert("Data: " + JSON.stringify(data));

		  						// Generate HTML for select dropdown
		  						var html = "<select class='form-control' tabindex='8' id='TLActFname' name='TLActFname'>";
		  						html += '<option value="">--Please Select--</option>';
		  						for (var i = 0; i < data.length; i++) {
		  							html += '<option value="' + data[i] + '">'
		  									+ data[i] + '</option>';
		  						}
		  						html += "</select>";

		  						$("#assignToDelay").html(html);
//		  						$("#PMActDlyteamLeaderName").html(html);
		  						
		  					});


	
}

function TeamLeaddelayedProjectDeatils(ProjectName) {
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getTeamLeaderDelayedProjectByProjectName";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
        	ProjectName: ProjectName,
        	functionName : $("#TlDelayeFunctionName").val(),
        	assignToName : $("#assignToDelay").val()
      
        	
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#TeamLeadDelayedProjectTable tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var Dev = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              var DelayedDays = project[0][8];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '<td style="color:red">' + (DelayedDays ? DelayedDays : 'NA') + '</td>' +
              '</tr>';
          $('#TeamLeadDelayedProjectTable tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#TeamLeadDelayedProjectTable tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
	
    
    var l = window.location;
  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  	var serviceUrl = base_url + "/PMS/getTeamLeadAssignToActivitiesDelayedByProjectName";

  	// Make AJAX request to fetch product suite data
  	$
  			.ajax({
  				url : serviceUrl,
  				type : 'POST',
  				dataType : 'json',
  				data : "ProjectName=" + $("#TeamLeaderDelayProject").val(),
  			})
  			.done(
  					function(data) {
  						// Alert received data for debugging
//  						 alert("Data: " + JSON.stringify(data));

  						// Generate HTML for select dropdown
  						var html = "<select class='form-control' tabindex='8' id='TLActFname' name='TLActFname'>";
  						html += '<option value="">--Please Select--</option>';
  						for (var i = 0; i < data.length; i++) {
  							html += '<option value="' + data[i] + '">'
  									+ data[i] + '</option>';
  						}
  						html += "</select>";

  						$("#assignToDelay").html(html);
//  						$("#PMActDlyteamLeaderName").html(html);
  						
  					});
    
   
	
		
	
}

function TeamLeaderDealyedProjectDetailsByProjectName(assignTo) {
	
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getAssignToDelayedProjectByProjectName";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
        	assignTo: assignTo,
        	projectName : $("#TeamLeaderDelayProject").val()
        	
      
        	
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#TeamLeadDelayedProjectTable tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var Dev = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              var DelayedDays = project[0][8];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '<td style="color:red">' + (DelayedDays ? DelayedDays : 'NA') + '</td>' +
              '</tr>';
          $('#TeamLeadDelayedProjectTable tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#TeamLeadDelayedProjectTable tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
    
    
    
    var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/PMS/getTeamLeaderFunctionNameByAssignTo";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          data : 
        	  "assignToName=" + $("#assignToDelay").val()
        	  + "&projectName=" + $("#TeamLeaderDelayProject").val(),
          
          success: function(data2) {
       
         	 var html = "  <option value=''> -- Please Select --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("TlDelayeFunctionName").innerHTML = html;	
 				
 		}
 	});
    
    
	
}


function TlDelayeFunctionName(delayFunctionName) {
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getDelayedProjectByFunctionName";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
        	delayFunctionName: delayFunctionName,
        	projectName : $("#TeamLeaderDelayProject").val(),
        	assignTo : $("#assignToDelay").val()

        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)


      // Clear existing table rows
      $('#TeamLeadDelayedProjectTable tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var Dev = project[0][6];

              var TaskEnddate = project[0][7];
              var DelayedDays = project[0][8];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '<td style="color:red">' + (DelayedDays ? DelayedDays : 'NA') + '</td>' +
              '</tr>';
          $('#TeamLeadDelayedProjectTable tbody').append(row);
      });
      } else {
          // No data received
          $('#TeamLeadDelayedProjectTable tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
    
}





function resetTeamLeaderActDelay() {
	//  alert("reset")
	  $('#TeamLeaderDelayProject').val("");
	  $('#assignToDelay').val("");
	  $('#TlDelayeFunctionName').val("");
	  
	  nameManager= "";
	  productsuite="";
	  productmanager="";
	  teamleader="";
	  Actproductsuite="";
	  Actproductmanager="";
	  Actteamleader="";
	  
	
	  	var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getTeamLeaderDelayedProjectDetails";

	    // Make AJAX request to fetch product manager names
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',

	    }).done(function(data2) {
	  //  	alert("niininiii "+data2)
	        // Check if data is received


	      // Clear existing table rows
	      $('#TeamLeadDelayedProjectTable tbody').empty();

	    	
	      // Populate table with project data
	      if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	              var Customername = project[0][0];
	              var ProductManager = project[0][1];
	              var ProductSuite = project[0][2];
	              var Producttool = project[0][3];
	              var Functionname = project[0][4];
	              var Activities = project[0][5];
	              var Dev = project[0][6];
//	              var tester = project[0][8];
	              var TaskEnddate = project[0][7];
	              var DelayedDays = project[0][8];
	              
	              var row = '<tr>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
	              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
	              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
	              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (Dev ? Dev : 'NA') + '</td>' +
//	              '<td>' + (tester ? tester : 'NA') + '</td>' +
	              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
	              '<td style="color:red">' + (DelayedDays ? DelayedDays : 'NA') + '</td>' +
	              '</tr>';
	          $('#TeamLeadDelayedProjectTable tbody').append(row);
	      });
	      } else {
	          // No data received
//	          console.log("No data received");
	          $('#TeamLeadDelayedProjectTable tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	      }
	  });
	  
	 
	    
	    
	    var l = window.location;
	  	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  	var serviceUrl = base_url + "/PMS/getTeamLeadActivitiesDelayedByProjectName";

	  	// Make AJAX request to fetch product suite data
	  	$
	  			.ajax({
	  				url : serviceUrl,
	  				type : 'POST',
	  				dataType : 'json',
//	  				data : "ProjectName=" +ProjectName,
	  			})
	  			.done(
	  					function(data) {
	  						// Alert received data for debugging
//	  						 alert("Data: " + JSON.stringify(data));

	  						// Generate HTML for select dropdown
	  						var html = "<select class='form-control' tabindex='8' id='TLActFname' name='TLActFname'>";
	  						html += '<option value="">--Please Select--</option>';
	  						for (var i = 0; i < data.length; i++) {
	  							html += '<option value="' + data[i] + '">'
	  									+ data[i] + '</option>';
	  						}
	  						html += "</select>";

	  						$("#assignToDelay").html(html);
//	  						$("#PMActDlyteamLeaderName").html(html);
	  						
	  					});
	  	
	  	
	  	 var l = window.location;
		   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		   	var serviceUrl = base_url + "/PMS/getTeamLeaderFunctionName";

		      $.ajax({
		          type: 'POST',
		          url: serviceUrl,
		          dataType: 'json',
		          
		          success: function(data2) {
		       
		         	 var html = "  <option value=''> -- Please Select --</option>";
		 			                    for (var i = 0; i < data2.length; i++) {
		 				html += '<option value="' + data2[i] + '">' + data2[i]
		 						+ '</option>';
		 			}
		 			document.getElementById("TlDelayeFunctionName").innerHTML = html;	
		 				
		 		}
		 	});
	  	
	  	
	  	
	  	
//	  	 	var l = window.location;
//	    	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	    	var serviceUrl = base_url + "/PMS/getTeamLeaderFunctionNameByAssignTo";
//
//	       $.ajax({
//	           type: 'POST',
//	           url: serviceUrl,
//	           dataType: 'json',
//	           data : 
//	         	  "assignToName=" + $("#assignToDelay").val()
//	         	  + "&projectName=" + $("#TeamLeaderDelayProject").val(),
//	           
//	           success: function(data2) {
//	        
//	          	 var html = "  <option value=''> -- Please Select --</option>";
//	  			                    for (var i = 0; i < data2.length; i++) {
//	  				html += '<option value="' + data2[i] + '">' + data2[i]
//	  						+ '</option>';
//	  			}
//	  			document.getElementById("TlDelayeFunctionName").innerHTML = html;	
//	  				
//	  		}
//	  	});

	    
	    
  }

//-------------------------------------------End Team Leader Activities  Delayed Project Details-----------------------------------------------------------



////////////////////////////////////////////////-----------Developer Cards Detaisl-------------\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\




function getDevTotalProject() {
	
	  $("#TotalProjectsModalDev").modal("show");

    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getProjectListDeveloper";
    var selectedMethod = "TotalProjects";
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: "methodName=" + selectedMethod ,
        success: function(data2) {
      	// console.log("Data received:", data2);

      	$('#ProjectsTotalTableDev tbody').empty();

      	if (data2 && data2.length > 0) {
      	    data2.forEach(function(project) {
      	        var projectName = project[0][0];
      	        var prodSuite = project[0][1];
      	        var prodTool = project[0][2];
      	        var date = project[0][3];
      	        var managerName3 = project[0][4];
      	        var status = project[0][5];

      	        function getStatusClass(status) {
      	            if (status === 'Completed') {
      	                return 'completed';
      	            } else if (status === 'On Hold') {
      	                return 'on-hold';
      	            } else {
      	                return 'pending'; 
      	            }
      	        }
      	        var row = '<tr>' +
      	            '<td>' + projectName + '</td>' +
      	            '<td>' + prodSuite + '</td>' +
      	            '<td>' + prodTool + '</td>' +
      	            '<td>' + date + '</td>' +
      	            '<td>' + managerName3 + '</td>' +
      	            '<td class="' + getStatusClass(status) + '">' + status + '</td>' + 
      	            '</tr>';

      	        $('#ProjectsTotalTableDev tbody').append(row);
      	    });
      	} else {
      	    $('#ProjectsTotalTableDev tbody').append('<tr><td colspan="6">No projects found</td></tr>');
      	}
},
        error: function(xhr, status, error) {
            console.error('Error fetching project data:', error);
            $('#ProjectsTotalTableDev tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
        }
    });
}




function getDevOnTrackProject(){
	
	  $("#OnTrackProjectsModalDev").modal("show");

  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getProjectListDeveloper";
  var selectedMethod = "OnTrackProjects";
  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      data: "methodName=" + selectedMethod ,
      success: function(data2) {
    	// console.log("Data received:", data2);

    	$('#ProjectsOnTrackTableDev tbody').empty();

    	if (data2 && data2.length > 0) {
    	    data2.forEach(function(project) {
    	        var projectName = project[0][0];
    	        var prodSuite = project[0][1];
    	        var prodTool = project[0][2];
    	        var date = project[0][3];
    	        var managerName3 = project[0][4];
    	        var status = project[0][5];

    	        function getStatusClass(status) {
    	            if (status === 'Completed') {
    	                return 'completed';
    	            } else if (status === 'On Hold') {
    	                return 'on-hold';
    	            } else {
    	                return 'pending'; 
    	            }
    	        }
    	        var row = '<tr>' +
    	            '<td>' + projectName + '</td>' +
    	            '<td>' + prodSuite + '</td>' +
    	            '<td>' + prodTool + '</td>' +
    	            '<td>' + date + '</td>' +
    	            '<td>' + managerName3 + '</td>' +
    	            '<td class="' + getStatusClass(status) + '">' + status + '</td>' + 
    	            '</tr>';

    	        $('#ProjectsOnTrackTableDev tbody').append(row);
    	    });
    	} else {
    	    $('#ProjectsOnTrackTableDev tbody').append('<tr><td colspan="6">No projects found</td></tr>');
    	}
},
      error: function(xhr, status, error) {
          console.error('Error fetching project data:', error);
          $('#ProjectsOnTrackTableDev tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
      }
  });
}


function getDevCompletedProject() {
	
	  $("#CompletedProjectsModalDev").modal("show");

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/getProjectListDeveloper";
var selectedMethod = "CompletedProjects";
$.ajax({
    type: 'POST',
    url: serviceUrl,
    dataType: 'json',
    data: "methodName=" + selectedMethod ,
    success: function(data2) {
  	// console.log("Data received:", data2);

  	$('#ProjectsCompletedTableDev tbody').empty();

  	if (data2 && data2.length > 0) {
  	    data2.forEach(function(project) {
  	        var projectName = project[0][0];
  	        var prodSuite = project[0][1];
  	        var prodTool = project[0][2];
  	        var date = project[0][3];
  	        var managerName3 = project[0][4];
  	        var status = project[0][5];

  	        function getStatusClass(status) {
  	            if (status === 'Completed') {
  	                return 'completed';
  	            } else if (status === 'On Hold') {
  	                return 'on-hold';
  	            } else {
  	                return 'pending'; 
  	            }
  	        }
  	        var row = '<tr>' +
  	            '<td>' + projectName + '</td>' +
  	            '<td>' + prodSuite + '</td>' +
  	            '<td>' + prodTool + '</td>' +
  	            '<td>' + date + '</td>' +
  	            '<td>' + managerName3 + '</td>' +
  	            '<td class="' + getStatusClass(status) + '">' + status + '</td>' + 
  	            '</tr>';

  	        $('#ProjectsCompletedTableDev tbody').append(row);
  	    });
  	} else {
  	    $('#ProjectsCompletedTableDev tbody').append('<tr><td colspan="6">No projects found</td></tr>');
  	}
},
    error: function(xhr, status, error) {
        console.error('Error fetching project data:', error);
        $('#ProjectsCompletedTableDev tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
    }
});
}


function getDevDelayProject() {
	
	  $("#DelayedProjectsModalDev").modal("show");

var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/getProjectListDeveloper";
var selectedMethod = "DelayProjects";
$.ajax({
  type: 'POST',
  url: serviceUrl,
  dataType: 'json',
  data: "methodName=" + selectedMethod ,
  success: function(data2) {
	// console.log("Data received:", data2);

	$('#ProjectsDelayTableDev tbody').empty();

	if (data2 && data2.length > 0) {
	    data2.forEach(function(project) {
	        var projectName = project[0][0];
	        var prodSuite = project[0][1];
	        var prodTool = project[0][2];
	        var date = project[0][3];
	        var managerName3 = project[0][4];
	        var status = project[0][5];

	        function getStatusClass(status) {
	            if (status === 'Completed') {
	                return 'completed';
	            } else if (status === 'On Hold') {
	                return 'on-hold';
	            } else {
	                return 'pending'; 
	            }
	        }
	        var row = '<tr>' +
	            '<td>' + projectName + '</td>' +
	            '<td>' + prodSuite + '</td>' +
	            '<td>' + prodTool + '</td>' +
	            '<td>' + date + '</td>' +
	            '<td>' + managerName3 + '</td>' +
	            '<td class="' + getStatusClass(status) + '">' + status + '</td>' + 
	            '</tr>';

	        $('#ProjectsDelayTableDev tbody').append(row);
	    });
	} else {
	    $('#ProjectsDelayTableDev tbody').append('<tr><td colspan="6">No projects found</td></tr>');
	}
},
  error: function(xhr, status, error) {
      console.error('Error fetching project data:', error);
      $('#ProjectsDelayTableDev tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
  }
});
}











function getDeveloperOnTrack() {
	
	$("#DeveloperModal").modal("show")
	
		var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getDeveloperActivities";

	    // Make AJAX request to fetch product manager names
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
//	        data: {
//	        	productmanager: Actproductmanager,
//	        	productsuite:Actproductsuite,
//	        	teamleader:Actteamleader,
//	        	allfunction:Actalldata
//	        }

	    }).done(function(data2) {
	  //  	alert("niininiii "+data2)
	        // Check if data is received


	      // Clear existing table rows
	      $('#DevTableDetails tbody').empty();

	    	
	      // Populate table with project data
	      if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	              var Customername = project[0][0];
	              var ProductManager = project[0][1];
	              var ProductSuite = project[0][2];
	              var Producttool = project[0][3];
	              var Functionname = project[0][4];
	              var Activities = project[0][5];
	              var team_lead = project[0][6];
//	              var tester = project[0][8];
	              var TaskEnddate = project[0][7];
	              
	              var row = '<tr>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
	              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
	              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
	              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
//	              '<td>' + (tester ? tester : 'NA') + '</td>' +
	              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
	              '</tr>';
	          $('#DevTableDetails tbody').append(row);
	      });
	      } else {
	          // No data received
//	          console.log("No data received");
	          $('#DevTableDetails tbody').append('<tr><td colspan="8">No Activities found</td></tr>');
	      }
	  });
	

	
	    var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/PMS/getDeveloperActivityOnTrack";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          
	          success: function(data2) {
	       
	         	 var html = "  <option value=''> -- Please Select --</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("DevActprojectName").innerHTML = html;	
	 				
	 		}
	 	});
	      
	      
		
		       
		        	  var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
		              var html = "<option value=''>-- Please Select --</option>";
		              for (var i = 0; i < dataF.length; i++) {
		                  var value = dataF[i];
		                  html += '<option value="' + value + '">' + value + '</option>';
		              }
		              $("#DevActFname").html(html);

		
		      
		      
}


function DeveloperActproductsuite() {
	
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getDeveloperActivitiesByProjectName";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
//        	productmanager: Actproductmanager,
        	productsuitename : $("#DevActprojectName").val(),
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#DevTableDetails tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var team_lead = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '</tr>';
          $('#DevTableDetails tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#DevTableDetails tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
    
    
    
    var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/PMS/getDeveloperFunctionNameByProjectName";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          data : 'projectName=' + $("#DevActprojectName").val(),
          
          success: function(data2) {
       
         	 var html = "  <option value=''> -- Please Select --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("DevActFname").innerHTML = html;	
 				
 		}
 	});
    
    
}

function DeveloperActtoalldata() {
	
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getDeveloperActivitiesByFunctionName";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
//        	productmanager: Actproductmanager,
        	productsuitename : $("#DevActprojectName").val(),
        	functionName : $("#DevActFname").val()
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#DevTableDetails tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var team_lead = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '</tr>';
          $('#DevTableDetails tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#DevTableDetails tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
    
    
}

function resetDeveloperActonTrack() {
	

	
	
	$("#DevActprojectName").val("");
	$("#DevActFname").val("");
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getDeveloperActivities";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: {
//        	productmanager: Actproductmanager,
//        	productsuite:Actproductsuite,
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
//        }

    }).done(function(data2) {
 
      // Clear existing table rows
      $('#DevTableDetails tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var team_lead = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '</tr>';
          $('#DevTableDetails tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#DevTableDetails tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });

    
    
    var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
    var html = "<option value=''>-- Please Select --</option>";
    for (var i = 0; i < dataF.length; i++) {
        var value = dataF[i];
        html += '<option value="' + value + '">' + value + '</option>';
    }
    $("#DevActFname").html(html);
    
    
    
    var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/PMS/getDeveloperActivityOnTrack";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          
          success: function(data2) {
       
         	 var html = "  <option value=''> -- Please Select --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("DevActprojectName").innerHTML = html;	
 				
 		}
 	});
    

	
}

//---------------------- Developer Delays Card-----------------------

function DevActivitiesdalaysDetails() {
	

	
	$("#DeveloperDelaysActModal").modal("show")
	
		var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getDeveloperDelayActivities";

	    // Make AJAX request to fetch product manager names
	    $.ajax({
	        url: serviceUrl,
	        type: 'POST',
	        dataType: 'json',
//	        data: {
//	        	productmanager: Actproductmanager,
//	        	productsuite:Actproductsuite,
//	        	teamleader:Actteamleader,
//	        	allfunction:Actalldata
//	        }

	    }).done(function(data2) {
	  //  	alert("niininiii "+data2)
	        // Check if data is received


	      // Clear existing table rows
	      $('#DevDelaysTableDetails tbody').empty();

	    	
	      // Populate table with project data
	      if (data2 && data2.length > 0) {
	          data2.forEach(function(project) {
	              var Customername = project[0][0];
	              var ProductManager = project[0][1];
	              var ProductSuite = project[0][2];
	              var Producttool = project[0][3];
	              var Functionname = project[0][4];
	              var Activities = project[0][5];
	              var team_lead = project[0][6];
//	              var tester = project[0][8];
	              var TaskEnddate = project[0][7];
	              var delayDays = project[0][8];
	              
	              var row = '<tr>' +
	              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
	              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
	              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
	              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
	              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
	              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
	              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
//	              '<td>' + (tester ? tester : 'NA') + '</td>' +
	              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
	              '<td style="color:red;">' + (delayDays ? delayDays : 'NA') + '</td>'
	              '</tr>';
	          $('#DevDelaysTableDetails tbody').append(row);
	      });
	      } else {
	          // No data received
//	          console.log("No data received");
	          $('#DevDelaysTableDetails tbody').append('<tr><td colspan="9">No Activities found</td></tr>');
	      }
	  });
	

	
	    var l = window.location;
	   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	   	var serviceUrl = base_url + "/PMS/getDeveloperDelayActivity";

	      $.ajax({
	          type: 'POST',
	          url: serviceUrl,
	          dataType: 'json',
	          
	          success: function(data2) {
	       
	         	 var html = "  <option value=''> -- Please Select --</option>";
	 			                    for (var i = 0; i < data2.length; i++) {
	 				html += '<option value="' + data2[i] + '">' + data2[i]
	 						+ '</option>';
	 			}
	 			document.getElementById("DevDalayprojectName").innerHTML = html;	
	 				
	 		}
	 	});
	      
	      
		
		       
		        	  var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
		              var html = "<option value=''>-- Please Select --</option>";
		              for (var i = 0; i < dataF.length; i++) {
		                  var value = dataF[i];
		                  html += '<option value="' + value + '">' + value + '</option>';
		              }
		              $("#DevDelayActFname").html(html);

		
		      
	
}

function DeveloperDelayProjectNames() {
	
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getDeveloperDelayActByProjectName";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
       
        	productsuite: $("#DevDalayprojectName").val(),
        	functionName: $("#DevDelayActFname").val(),

        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#DevDelaysTableDetails tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var team_lead = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              var delayDays = project[0][8];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '<td style="color:red;">' + (delayDays ? delayDays : 'NA') + '</td>'
              '</tr>';
          $('#DevDelaysTableDetails tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#DevDelaysTableDetails tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
    
    
    var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/PMS/getDeveloperDelayActByProjectNameOnChange";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          data : 'projectName=' +$("#DevDalayprojectName").val(),
          
          success: function(data2) {
//        	  alert(data2+"ASDsadasvhdgsavssdjavjs")
         	 var html = "  <option value=''> -- Please Select --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("DevDelayActFname").innerHTML = html;	
 				
 		}
 	});
    
    
    
	
}

function DeveloperDelayActtoalldata() {
	
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getDeveloperDelayActByFunctiontName";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
        data: {
       
        	productsuite: $("#DevDalayprojectName").val(),
        	functionName : $("#DevDelayActFname").val(),

        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#DevDelaysTableDetails tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var team_lead = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              var delayDays = project[0][8];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '<td style="color:red;">' + (delayDays ? delayDays : 'NA') + '</td>'
              '</tr>';
          $('#DevDelaysTableDetails tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#DevDelaysTableDetails tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
	
	
}


function resetDeveloperDelaysProject() {
	
	
	$("#DevDalayprojectName").val("");
	$("#DevDelayActFname").val("");
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getDeveloperDelayActivities";

    // Make AJAX request to fetch product manager names
    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: {
//        	productmanager: Actproductmanager,
//        	productsuite:Actproductsuite,
//        	teamleader:Actteamleader,
//        	allfunction:Actalldata
//        }

    }).done(function(data2) {
  //  	alert("niininiii "+data2)
        // Check if data is received


      // Clear existing table rows
      $('#DevDelaysTableDetails tbody').empty();

    	
      // Populate table with project data
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
              var Customername = project[0][0];
              var ProductManager = project[0][1];
              var ProductSuite = project[0][2];
              var Producttool = project[0][3];
              var Functionname = project[0][4];
              var Activities = project[0][5];
              var team_lead = project[0][6];
//              var tester = project[0][8];
              var TaskEnddate = project[0][7];
              var delayDays = project[0][8];
              
              var row = '<tr>' +
              '<td>' + (Customername ? Customername : 'NA') + '</td>' +
              '<td>' + (ProductManager ? ProductManager : 'NA') + '</td>' +
              '<td>' + (ProductSuite ? ProductSuite : 'NA') + '</td>' +
              '<td>' + (Producttool ? Producttool : 'NA') + '</td>' +
              '<td>' + (Functionname ? Functionname : 'NA') + '</td>' +
              '<td>' + (Activities ? Activities : 'NA') + '</td>' +
              '<td>' + (team_lead ? team_lead : 'NA') + '</td>' +
//              '<td>' + (tester ? tester : 'NA') + '</td>' +
              '<td>' + (TaskEnddate ? TaskEnddate : 'NA') + '</td>' +
              '<td style="color:red;">' + (delayDays ? delayDays : 'NA') + '</td>'
              '</tr>';
          $('#DevDelaysTableDetails tbody').append(row);
      });
      } else {
          // No data received
//          console.log("No data received");
          $('#DevDelaysTableDetails tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
      }
  });
    
    
    var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
    var html = "<option value=''>-- Please Select --</option>";
    for (var i = 0; i < dataF.length; i++) {
        var value = dataF[i];
        html += '<option value="' + value + '">' + value + '</option>';
    }
    $("#DevDelayActFname").html(html);
    
    
    
    var l = window.location;
   	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
   	var serviceUrl = base_url + "/PMS/getDeveloperDelayActivity";

      $.ajax({
          type: 'POST',
          url: serviceUrl,
          dataType: 'json',
          
          success: function(data2) {
       
         	 var html = "  <option value=''> -- Please Select --</option>";
 			                    for (var i = 0; i < data2.length; i++) {
 				html += '<option value="' + data2[i] + '">' + data2[i]
 						+ '</option>';
 			}
 			document.getElementById("DevDalayprojectName").innerHTML = html;	
 				
 		}
 	});
    
}


//////////////////   MGR Card   /////

function resetAllDDMGR() {
	//  alert("reset")
  $('#PMActprojectName').val("");
  $('#PMActteamLeaderName').val("");
  $('#PMActprodmgr').val("");
  $('#PMActFname').val("");
  
  nameManager= "";
  productsuite="";
  productmanager="";
  teamleader="";
  Actproductsuite="";
  Actproductmanager="";
  Actteamleader="";
  
  $('#PMActDlyprojectName').val("");
  $('#PMActDlyteamLeaderName').val("");
  $('#PMActDlyprodmgr').val("");
  $('#PMActDlyFname').val("");
  
  
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getAllActivitiesMGR";

	// Make AJAX request to fetch product manager names
	$.ajax({
		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
//		data : {
//			projectname : PMActproductsuite,
//			tlname : PMTlname,
//			devname : PMDevnames,
//			allfunction : Actalldata
//		}

	}).done(
			function(data2) {
//				alert("niininiii" + data2)
				// Check if data is received
				// console.log("Data received:", data2);

				// Clear existing table rows
				$('#PMProjectDetailsByName tbody').empty();

				// Populate table with project data
				if (data2 && data2.length > 0) {
					data2.forEach(function(project) {
						var Customername = project[0][0];
						var ProductSuite = project[0][1];
						var Producttool = project[0][2];
						var Functionname = project[0][3];
						var Activities = project[0][4];
						var TeamLeader = project[0][5];
						var Dev = project[0][6];
						var TaskEnddate = project[0][7];

						var row = '<tr>' + '<td>'
								+ (Customername ? Customername : 'NA')
								+ '</td>' + '<td>'
								+ (ProductSuite ? ProductSuite : 'NA')
								+ '</td>' + '<td>'
								+ (Producttool ? Producttool : 'NA') + '</td>'
								+ '<td>' + (Functionname ? Functionname : 'NA')
								+ '</td>' + '<td>'
								+ (Activities ? Activities : 'NA') + '</td>'
								+ '<td>' + (TeamLeader ? TeamLeader : 'NA')
								+ '</td>' + '<td>' + (Dev ? Dev : 'NA')
								+ '</td>' + '<td>'
								+ (TaskEnddate ? TaskEnddate : 'NA') + '</td>'
								+ '</tr>';
						$('#PMProjectDetailsByName tbody').append(row);
					});
				} else {
					// No data received
					// console.log("No data received");
					$('#PMProjectDetailsByName tbody').append(
							'<tr><td colspan="3">No projects found</td></tr>');
				}
			});
    
    
    
    
    
    var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getallMGRdelayActivity"; 

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',

    }).done(function(data2) {
    	
	$('#TotalcompletedProjectsTable1 tbody').empty();

	if (data2 && data2.length > 0) {
        data2.forEach(function(activity) {
            try {
                var customerName = activity.CustomerName;
                var productSuit = activity.ProductSuit;
                var productTool = activity.ProductTool;
                var functions = activity.Function;
                var description = activity.Description;
                var teamLeader = activity.TeamLeader;
                var developer = activity.Developer;
                var endDate = activity.EndDate;
                var delayDays = activity.DelayDays;
                
                // Create HTML row and append to table
                var row = '<tr>' +
                '<td>' + customerName + '</td>' +
                '<td>' + productSuit + '</td>' +
                '<td>' + productTool + '</td>' +
                '<td>' + functions + '</td>' +
                '<td>' + description + '</td>' +
                '<td>' + teamLeader + '</td>' +
                '<td>' + developer + '</td>' +
                '<td>' + endDate + '</td>' +
                '<td style="color: red;">' + delayDays + '</td>' + // Corrected style attribute
                '</tr>';

                $('#TotalcompletedProjectsTable1 tbody').append(row);
            } catch (error) {
                console.error('Error parsing activity data:', error);
            }
        });
    } else {
        // No data received
        $('#TotalcompletedProjectsTable1 tbody').append('<tr><td colspan="6">No activities found</td></tr>');
    }
}).fail(function(jqXHR, textStatus, errorThrown) { 
								
console.error("AJAX request failed:", textStatus, errorThrown);
});
    
   
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getMgrDelaysActivities";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',

		success : function(data2) {
//			 alert("abc "+data2)
			var html = "  <option value=''> -- Please Select --</option>";
			for (var i = 0; i < data2.length; i++) {
				html += '<option value="' + data2[i] + '">' + data2[i]
						+ '</option>';
			}
			document.getElementById("PMActDlyprojectName").innerHTML = html;

		}
	});
	
	
	
	//get Teamleader Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getTeamLeaderByMGR";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {

			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#PMActteamLeaderName").html(html); 
			$("#PMActDlyteamLeaderName").html(html); 
		}
	});
	
	
	
	//get Developer Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getDevelopersByManager";

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {

			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#PMActDlyprodmgr").html(html); 
			$("#PMActprodmgr").html(html);
		}
	});
	
	
	var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
	var html = "<option value=''>-- Please Select --</option>";
	for (var i = 0; i < dataF.length; i++) {
	    var value = dataF[i];
	    html += '<option value="' + value + '">' + value + '</option>';
	}
	$("#PMActDlyFname").html(html);   
	$("#PMActFname").html(html);
    
}


function PMActivityDetailsByProj(projectName) {
	
	 $("#PMActteamLeaderName").val("");
	 $("#PMActprodmgr").val("");
	 $("#PMActFname").val("");
	   
	  	var l = window.location;
			var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
			var serviceUrl = base_url + "/PMS/getActivitiesMGRByProj";

			$.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : {
					projectname : projectName,

				}

			}).done(
					function(data2) {


						// Clear existing table rows
						$('#PMProjectDetailsByName tbody').empty();

						// Populate table with project data
						if (data2 && data2.length > 0) {
							data2.forEach(function(project) {
								var Customername = project[0][0];
								var ProductSuite = project[0][1];
								var Producttool = project[0][2];
								var Functionname = project[0][3];
								var Activities = project[0][4];
								var TeamLeader = project[0][5];
								var Dev = project[0][6];
								var TaskEnddate = project[0][7];

								var row = '<tr>' + '<td>'
										+ (Customername ? Customername : 'NA')
										+ '</td>' + '<td>'
										+ (ProductSuite ? ProductSuite : 'NA')
										+ '</td>' + '<td>'
										+ (Producttool ? Producttool : 'NA') + '</td>'
										+ '<td>' + (Functionname ? Functionname : 'NA')
										+ '</td>' + '<td>'
										+ (Activities ? Activities : 'NA') + '</td>'
										+ '<td>' + (TeamLeader ? TeamLeader : 'NA')
										+ '</td>' + '<td>' + (Dev ? Dev : 'NA')
										+ '</td>' + '<td>'
										+ (TaskEnddate ? TaskEnddate : 'NA') + '</td>'
										+ '</tr>';
								$('#PMProjectDetailsByName tbody').append(row);
							});
						} else {
							// No data received
							// console.log("No data received");
							$('#PMProjectDetailsByName tbody').append(
									'<tr><td colspan="3">No projects found</td></tr>');
						}
					});
			
		

	
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getproductsuiteActontrackPM";

		$
				.ajax({
					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
					data : "projectNames=" + projectName,
				})
				.done(
						function(data) {
							// Alert received data for debugging
							// alert("Data: " + JSON.stringify(data));

							var html = "<select class='form-control' tabindex='8' id='PMActteamLeaderName' name='PMActteamLeaderName'>";
							html += '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							html += "</select>";

							$("#PMActteamLeaderName").html(html);
	
						});

	}


function PMActTrackteamLeaderDetails(TLName) {
	// alert("hihi555555555")
	
 	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getMGRTrackActivityByTL";

	$.ajax({
		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : {
			projectname : $('#PMActprojectName').val(),
			tlname : TLName,
//			devname : PMDevnames,
//			allfunction : Actalldata
		}

	}).done(
			function(data2) {
//				alert("niininiii" + data2)
				// Check if data is received
				// console.log("Data received:", data2);

				// Clear existing table rows
				$('#PMProjectDetailsByName tbody').empty();

				// Populate table with project data
				if (data2 && data2.length > 0) {
					data2.forEach(function(project) {
						var Customername = project[0][0];
						var ProductSuite = project[0][1];
						var Producttool = project[0][2];
						var Functionname = project[0][3];
						var Activities = project[0][4];
						var TeamLeader = project[0][5];
						var Dev = project[0][6];
						var TaskEnddate = project[0][7];

						var row = '<tr>' + '<td>'
								+ (Customername ? Customername : 'NA')
								+ '</td>' + '<td>'
								+ (ProductSuite ? ProductSuite : 'NA')
								+ '</td>' + '<td>'
								+ (Producttool ? Producttool : 'NA') + '</td>'
								+ '<td>' + (Functionname ? Functionname : 'NA')
								+ '</td>' + '<td>'
								+ (Activities ? Activities : 'NA') + '</td>'
								+ '<td>' + (TeamLeader ? TeamLeader : 'NA')
								+ '</td>' + '<td>' + (Dev ? Dev : 'NA')
								+ '</td>' + '<td>'
								+ (TaskEnddate ? TaskEnddate : 'NA') + '</td>'
								+ '</tr>';
						$('#PMProjectDetailsByName tbody').append(row);
					});
				} else {
					// No data received
					// console.log("No data received");
					$('#PMProjectDetailsByName tbody').append(
							'<tr><td colspan="3">No projects found</td></tr>');
				}
			});
	
	
	

	// Get base URL and service URL
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getDevNameActonTrackPM";

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : {
					producttool : $('#PMActprojectName').val(),
					tlnames : TLName
				}

			})
			.done(
					function(data) {
						// alert("Data333: " + JSON.stringify(data));

						var html = "<select class='form-control' tabindex='8' id='PMActprodmgr' name='PMActprodmgr'>";
						html += '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						html += "</select>";

						$("#PMActprodmgr").html(html);
					});

}


function PMActTrackDevDetails(Devnames) {
	// alert("333333")
	PMDevnames = Devnames;
//	alert("Proj Name "+productsuite);

	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getMGRTrackActivityByDev";

	$.ajax({
		url : serviceUrl,
		type : 'POST',
		dataType : 'json',
		data : {
			projectname : $('#PMActprojectName').val(),  
			tlname : $('#PMActteamLeaderName').val(), 
			devname : Devnames,
//			allfunction : Actalldata
		}

	}).done(
			function(data2) {
//				alert("niininiii" + data2)
				// console.log("Data received:", data2);

				$('#PMProjectDetailsByName tbody').empty();

				if (data2 && data2.length > 0) {
					data2.forEach(function(project) {
						var Customername = project[0][0];
						var ProductSuite = project[0][1];
						var Producttool = project[0][2];
						var Functionname = project[0][3];
						var Activities = project[0][4];
						var TeamLeader = project[0][5];
						var Dev = project[0][6];
						var TaskEnddate = project[0][7];

						var row = '<tr>' + '<td>'
								+ (Customername ? Customername : 'NA')
								+ '</td>' + '<td>'
								+ (ProductSuite ? ProductSuite : 'NA')
								+ '</td>' + '<td>'
								+ (Producttool ? Producttool : 'NA') + '</td>'
								+ '<td>' + (Functionname ? Functionname : 'NA')
								+ '</td>' + '<td>'
								+ (Activities ? Activities : 'NA') + '</td>'
								+ '<td>' + (TeamLeader ? TeamLeader : 'NA')
								+ '</td>' + '<td>' + (Dev ? Dev : 'NA')
								+ '</td>' + '<td>'
								+ (TaskEnddate ? TaskEnddate : 'NA') + '</td>'
								+ '</tr>';
						$('#PMProjectDetailsByName tbody').append(row);
					});
				} else {
					// No data received
					$('#PMProjectDetailsByName tbody').append(
							'<tr><td colspan="3">No projects found</td></tr>');
				}
			});
	
	
	

	// Get base URL and service URL
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getfunctionnameActonTrackforPM";

	$
			.ajax({
				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : {
					projectname : $('#PMActDlyprojectName').val(),
					Teamleadername : $('#PMActDlyteamLeaderName').val(),
					Devname : Devnames
				}

			})
			.done(
					function(data) {
					
						var html = "<select class='form-control' tabindex='8' id='PMActFname' name='PMActFname'>";
						html += '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						html += "</select>";

						$("#PMActFname").html(html);
						$("#PMActDlyFname").html(html);
					});
}



function downloadMPO(masskedPO) {
	event.preventDefault();
//	var filename = encodeURIComponent($('#downHideotherfile').val());
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	window.location.href = base_url + "/Inventive/DownloadFile?filename="+ masskedPO;
}





function ActivitiesCompletedcount(){
	event.preventDefault();
//	alert("ActivitiesCompletedcount()");
	$('#TotalActivitiesCompletedModal').modal("show");
	
	
	var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/PMS/ActivitiesCompletedcount";

	  $.ajax({
	      url: serviceUrl,
	      type: 'POST',
	      dataType: 'json',


	  }).done(function(data2) {
//	  	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTableMDN tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0][0];
	         	 var manager = project[0][1];
	              var prodSuite = project[0][2];
	              var prodTool = project[0][3];
	              var functionName = project[0][4];
	             var description = project[0][5];
	             var TLName1 = project[0][6];
	             var developerName1 = project[0][7];
	             var endDate = project[0][8];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTableMDN tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTableMDN tbody').append('<tr><td colspan="9">No Activities found</td></tr>');
	    }
});
	  
	  
	  
	  
	  
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/Master/getTeamLeader";     
		var serviceUrl = base_url + "/Master/getCompletedProjectList";
		
		$.ajax({

			url :serviceUrl,
			type : 'POST',
			dataType: 'json',
		}).done(function(data) {
			//	alert("Data "+data);
			var html =" <select class='form-control' tabindex='8' id='projectNamesN' name='projectNamesN'>";
			html=html+'<option value="">--Please Select--</option>';
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' +data[i]+ '">' + data[i]
				+ '</option>';
			}
			document.getElementById("projectNamesN").innerHTML=html;
			
		});	
		
		
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/Master/getTeamLeader";     
		var serviceUrl = base_url + "/Master/getCompletedManagerList";
		
	$.ajax({

	  url :serviceUrl,
	  type : 'POST',
	  dataType: 'json',
	}).done(function(data) {
//	alert("Data "+data);
	  var html =" <select class='form-control' tabindex='8' id='prodmgrN' name='prodmgrN'>";
	  html=html+'<option value="">--Please Select--</option>';
	  for (var i = 0; i < data.length; i++) {
	      html += '<option value="' +data[i]+ '">' + data[i]
	      + '</option>';
	  }
	  document.getElementById("prodmgrN").innerHTML=html;
	});	
	
	
	
	
	
	
	
	//get Teamleader Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCompletedTeamLeader";
	var selectedValue = $("#teamLeaderNameN").val(); // Get the currently

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {
//			alert(data4);

			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#teamLeaderNameN").html(html); // Update the select element	
			
		}

	});

	  
		var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
		var html = "<option value=''>-- Please Select --</option>";
		for (var i = 0; i < dataF.length; i++) {
		    var value = dataF[i];
		    html += '<option value="' + value + '">' + value + '</option>';
		}
		$("#FnameN").html(html);
}






function CompletedManagerListDet(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedManagerListDet";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN=' + $('#projectNamesN').val()
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='prodmgrN' name='prodmgrN'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("prodmgrN").innerHTML=html;
	});	
	
	
	
	//changes
	var serviceUrl = base_url + "/Master/CompletedDetailsByCus";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN=' + $('#projectNamesN').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTableMDN tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0][0];
	         	 var manager = project[0][1];
	              var prodSuite = project[0][2];
	              var prodTool = project[0][3];
	              var functionName = project[0][4];
	             var description = project[0][5];
	             var TLName1 = project[0][6];
	             var developerName1 = project[0][7];
	             var endDate = project[0][8];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTableMDN tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTableMDN tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	    }
	        

})

}




function CompletedTLListDet(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedTLListDet";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN=' + $('#projectNamesN').val() +
		'&prodmgrN=' + $('#prodmgrN').val()
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='teamLeaderNameN' name='teamLeaderNameN'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("teamLeaderNameN").innerHTML=html;
		
		
		
		var serviceUrl = base_url + "/Master/CompletedBasedOnManager";
		
//		var selectedMan=$('#prodmgrN').val();
		
		$.ajax({

			url :serviceUrl,
			type : 'POST',
			dataType: 'json',
			data: 'prodmgrN=' + $('#prodmgrN').val() +
			'&projectNamesN=' + $('#projectNamesN').val() +
			'&teamLeaderNameN=' + $('#teamLeaderNameN').val() +
			'&FnameN=' + $('#FnameN').val()
			
		}).done(function(data2) {
//	 	alert("niininiii "+data2)

		    $('#TotalcompletedProjectsTableMDN tbody').empty();

		        if (data2 && data2.length > 0) {
		        data2.forEach(function(project) {
		      		var customer = project[0][0];
		         	 var manager = project[0][1];
		              var prodSuite = project[0][2];
		              var prodTool = project[0][3];
		              var functionName = project[0][4];
		             var description = project[0][5];
		             var TLName1 = project[0][6];
		             var developerName1 = project[0][7];
		             var endDate = project[0][8];

		            
		            var row = '<tr>' +
		            '<td>' + (customer ? customer : 'NA') + '</td>' +
		            '<td>' + (manager ? manager : 'NA') + '</td>' +
		            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
		            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
		            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
		            '<td>' + (description ? description : 'NA') + '</td>' +
		            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
		            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
		            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
		            '</tr>';
		        $('#TotalcompletedProjectsTableMDN tbody').append(row);
		    });
		    } else {
//		        console.log("No data received");
		        $('#TotalcompletedProjectsTableMDN tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
		    }
		        

	})
	
	});	
	
	
	//changes
	var serviceUrl = base_url + "/Master/CompletedDetailsByCusAndMan";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN=' + $('#projectNamesN').val() +
		'&prodmgrN=' + $('#prodmgrN').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTableMDN tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0][0];
	         	 var manager = project[0][1];
	              var prodSuite = project[0][2];
	              var prodTool = project[0][3];
	              var functionName = project[0][4];
	             var description = project[0][5];
	             var TLName1 = project[0][6];
	             var developerName1 = project[0][7];
	             var endDate = project[0][8];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTableMDN tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTableMDN tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	    }
	        

})
	

}



function CompletedFunctionListDet(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedFunctionListDet";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN=' + $('#projectNamesN').val() +
		'&prodmgrN=' + $('#prodmgrN').val() +
		'&teamLeaderNameN=' + $('#teamLeaderNameN').val() + 
		'&FnameN=' + $('#FnameN')
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='FnameN' name='FnameN'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("FnameN").innerHTML=html;
	});	
	
	
	
	//changes
	var serviceUrl = base_url + "/Master/CompletedDetailsByCusManAndTL";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN=' + $('#projectNamesN').val() +
		'&prodmgrN=' + $('#prodmgrN').val() +
		'&teamLeaderNameN=' + $('#teamLeaderNameN').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTableMDN tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0][0];
	         	 var manager = project[0][1];
	              var prodSuite = project[0][2];
	              var prodTool = project[0][3];
	              var functionName = project[0][4];
	             var description = project[0][5];
	             var TLName1 = project[0][6];
	             var developerName1 = project[0][7];
	             var endDate = project[0][8];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTableMDN tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTableMDN tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	    }
	        

})

}



function CompletedDetailsBasedOnAll(){
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	
	var serviceUrl = base_url + "/Master/CompletedDetailsBasedOnAll";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN=' + $('#projectNamesN').val() +
		'&prodmgrN=' + $('#prodmgrN').val() +
		'&teamLeaderNameN=' + $('#teamLeaderNameN').val() +
		'&FnameN=' + $('#FnameN').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTableMDN tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0][0];
	         	 var manager = project[0][1];
	              var prodSuite = project[0][2];
	              var prodTool = project[0][3];
	              var functionName = project[0][4];
	             var description = project[0][5];
	             var TLName1 = project[0][6];
	             var developerName1 = project[0][7];
	             var endDate = project[0][8];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTableMDN tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTableMDN tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	    }
	        

})

}



function resetAllDDN() {
//	 alert("reset") 
	 ActivitiesCompletedcount();
   
}	






//28/06
function ProjectonholdMan() {
//  alert("hh");
  $("#projectonholdModal").modal("show");

  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getprojectonholdformgr";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data2) {
          // Check if data is received
          console.log("Data received:", data2);

          // Clear existing table rows
          $('#projectonholdMGR tbody').empty();

          // Populate table with project data
          if (data2 && data2.length > 0) {
              data2.forEach(function(project) {
              	 var projectName = project[0][0];
                   var prodSuite = project[0][1];
                   var prodTool = project[0][2];
                   var date = project[0][3];
                   var managerName3 = project[0][4];
                   var status = project[0][5];
                   var row = '<tr>' +
                       '<td>' + projectName + '</td>' +
                       '<td>' + prodSuite + '</td>' +
                       '<td>' + prodTool + '</td>' +
                       '<td>' + date + '</td>' +
                       '<td>' + managerName3 + '</td>' +
                       '<td>' + status + '</td>' +
                       '</tr>';
                  $('#projectonholdMGR tbody').append(row);
              });
          } else {
              // No data received
//              console.log("No data received");
              $('#projectonholdMGR tbody').append('<tr><td colspan="6">No projects found</td></tr>');
          }
      },
      error: function(xhr, status, error) {
          console.error('Error fetching project data:', error);
          // Show error message in table
          $('#projectonholdMGR tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
      }
  });
}
	




//28/06
function ActivitiesCompletedcountmgr() {
//  alert("hi");
	
  event.preventDefault(); // Prevent default form submission behavior
  // Show the modal
  $("#TotalActivitiesCompletedmgrModal").modal("show");
  
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/ActivitiesCompletedcount";

  $.ajax({
      url: serviceUrl,
      type: 'POST',
      dataType: 'json',
      

  }).done(function(data2) {
// 	alert("niininiii "+data2)

    $('#TotalcompletedProjectsTablemgrN1 tbody').empty();

        if (data2 && data2.length > 0) {
        data2.forEach(function(project) {
      		var customer = project[0][0];
         	 var manager = project[0][1];
              var prodSuite = project[0][2];
              var prodTool = project[0][3];
              var functionName = project[0][4];
             var description = project[0][5];
             var TLName1 = project[0][6];
             var developerName1 = project[0][7];
             var endDate = project[0][8];

            
            var row = '<tr>' +
            '<td>' + (customer ? customer : 'NA') + '</td>' +
            '<td>' + (manager ? manager : 'NA') + '</td>' +
            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
            '<td>' + (description ? description : 'NA') + '</td>' +
            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
            '</tr>';
        $('#TotalcompletedProjectsTablemgrN1 tbody').append(row);
    });
    } else {
//        console.log("No data received");
        $('#TotalcompletedProjectsTablemgrN1 tbody').append('<tr><td colspan="9">No Activities found</td></tr>');
    }
        
        
     
});
  
  
  
  
  
  var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/getCompletedProjectList";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
	}).done(function(data) {
		//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='projectNamesN1' name='projectNamesN1'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("projectNamesN1").innerHTML=html;
	});	
	
  
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/getCompletedManagerList";
	
$.ajax({

  url :serviceUrl,
  type : 'POST',
  dataType: 'json',
}).done(function(data) {
//alert("Data "+data);
  var html =" <select class='form-control' tabindex='8' id='prodmgrN1' name='prodmgrN1'>";
  html=html+'<option value="">--Please Select--</option>';
  for (var i = 0; i < data.length; i++) {
      html += '<option value="' +data[i]+ '">' + data[i]
      + '</option>';
  }
  document.getElementById("prodmgrN1").innerHTML=html;
});	


//get Teamleader Name
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/Master/getCompletedTeamLeader";
var selectedValue = $("#teamLeaderNameN1").val(); // Get the currently

$.ajax({
	type : 'POST',
	url : serviceUrl,
	dataType : 'json',
	success : function(data4) {

		var html = "<option value=''>-- Please Select --</option>";
		for (var i = 0; i < data4.length; i++) {
			var value = data4[i];
			html += '<option value="' + value + '">' + value + '</option>';
		}
		$("#teamLeaderNameN1").html(html); // Update the select element	
		
	}

});

  
	var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
	var html = "<option value=''>-- Please Select --</option>";
	for (var i = 0; i < dataF.length; i++) {
	    var value = dataF[i];
	    html += '<option value="' + value + '">' + value + '</option>';
	}
	$("#FnameN1").html(html);
}




function CompletedManagerListDet1(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedManagerListDet1";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN1=' + $('#projectNamesN1').val()
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='prodmgrN1' name='prodmgrN1'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("prodmgrN1").innerHTML=html;
	});	
	
	
	
	//changes
	var serviceUrl = base_url + "/Master/CompletedDetailsByCus1";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN1=' + $('#projectNamesN1').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTablemgrN1 tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0][0];
	         	 var manager = project[0][1];
	              var prodSuite = project[0][2];
	              var prodTool = project[0][3];
	              var functionName = project[0][4];
	             var description = project[0][5];
	             var TLName1 = project[0][6];
	             var developerName1 = project[0][7];
	             var endDate = project[0][8];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTablemgrN1 tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTablemgrN1 tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	    }
	        

})

}
	



function CompletedTLListDet1(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedTLListDet1";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN1=' + $('#projectNamesN1').val() +
		'&prodmgrN1=' + $('#prodmgrN1').val()
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='teamLeaderNameN1' name='teamLeaderNameN1'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("teamLeaderNameN1").innerHTML=html;
		
		
		
		var serviceUrl = base_url + "/Master/CompletedBasedOnManager1";
		
//		var selectedMan=$('#prodmgrN').val();
		
		$.ajax({

			url :serviceUrl,
			type : 'POST',
			dataType: 'json',
			data: 'prodmgrN1=' + $('#prodmgrN1').val() +
			'&projectNamesN1=' + $('#projectNamesN1').val() +
			'&teamLeaderNameN1=' + $('#teamLeaderNameN1').val() +
			'&FnameN1=' + $('#FnameN1').val()
			
		}).done(function(data2) {
//	 	alert("niininiii "+data2)

		    $('#TotalcompletedProjectsTablemgrN1 tbody').empty();

		        if (data2 && data2.length > 0) {
		        data2.forEach(function(project) {
		      		var customer = project[0][0];
		         	 var manager = project[0][1];
		              var prodSuite = project[0][2];
		              var prodTool = project[0][3];
		              var functionName = project[0][4];
		             var description = project[0][5];
		             var TLName1 = project[0][6];
		             var developerName1 = project[0][7];
		             var endDate = project[0][8];

		            
		            var row = '<tr>' +
		            '<td>' + (customer ? customer : 'NA') + '</td>' +
		            '<td>' + (manager ? manager : 'NA') + '</td>' +
		            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
		            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
		            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
		            '<td>' + (description ? description : 'NA') + '</td>' +
		            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
		            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
		            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
		            '</tr>';
		        $('#TotalcompletedProjectsTablemgrN1 tbody').append(row);
		    });
		    } else {
//		        console.log("No data received");
		        $('#TotalcompletedProjectsTablemgrN1 tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
		    }
		        

	})
	
	});	
	
	
	//changes
	var serviceUrl = base_url + "/Master/CompletedDetailsByCusAndMan1";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN1=' + $('#projectNamesN1').val() +
		'&prodmgrN1=' + $('#prodmgrN1').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTablemgrN1 tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0][0];
	         	 var manager = project[0][1];
	              var prodSuite = project[0][2];
	              var prodTool = project[0][3];
	              var functionName = project[0][4];
	             var description = project[0][5];
	             var TLName1 = project[0][6];
	             var developerName1 = project[0][7];
	             var endDate = project[0][8];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTablemgrN1 tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTablemgrN1 tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	    }
	        

})
	
}




function CompletedFunctionListDet1(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedFunctionListDet1";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN1=' + $('#projectNamesN1').val() +
		'&prodmgrN1=' + $('#prodmgrN1').val() +
		'&teamLeaderNameN1=' + $('#teamLeaderNameN1').val() + 
		'&FnameN1=' + $('#FnameN1')
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='FnameN1' name='FnameN1'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("FnameN1").innerHTML=html;
	});	
	
	
	
	//changes
	var serviceUrl = base_url + "/Master/CompletedDetailsByCusManAndTL1";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN1=' + $('#projectNamesN1').val() +
		'&prodmgrN1=' + $('#prodmgrN1').val() +
		'&teamLeaderNameN1=' + $('#teamLeaderNameN1').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTablemgrN1 tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0][0];
	         	 var manager = project[0][1];
	              var prodSuite = project[0][2];
	              var prodTool = project[0][3];
	              var functionName = project[0][4];
	             var description = project[0][5];
	             var TLName1 = project[0][6];
	             var developerName1 = project[0][7];
	             var endDate = project[0][8];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTablemgrN1 tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTablemgrN1 tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	    }
	        

})

}





function CompletedDetailsBasedOnAll1(){
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	
	var serviceUrl = base_url + "/Master/CompletedDetailsBasedOnAll1";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesN1=' + $('#projectNamesN1').val() +
		'&prodmgrN1=' + $('#prodmgrN1').val() +
		'&teamLeaderNameN1=' + $('#teamLeaderNameN1').val() +
		'&FnameN1=' + $('#FnameN1').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTablemgrN1 tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0][0];
	         	 var manager = project[0][1];
	              var prodSuite = project[0][2];
	              var prodTool = project[0][3];
	              var functionName = project[0][4];
	             var description = project[0][5];
	             var TLName1 = project[0][6];
	             var developerName1 = project[0][7];
	             var endDate = project[0][8];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (endDate ? endDate : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTablemgrN1 tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTablemgrN1 tbody').append('<tr><td colspan="3">No Activities found</td></tr>');
	    }
	        

})

}





function resetAllDDN1() {
//	 alert("reset") 
	 ActivitiesCompletedcountmgr();
   
}	


//01/08
function checkRadioButtonSupport() {
	   $("#teamLeaders").val("");
	   $("#developers").val("");
	   
		var radiosMgr = document.getElementsByName('SupportTable');

	    for (var i = 0; i < radiosMgr.length; i++) {
	        	if(radiosMgr[0].checked) {
	        		radioClickedMgr="ProgressTable";
	      	} else {
	        		radioClickedMgr = "TaskTable";
	        	}
	        //	alert(radioClickedMgr)
	    }

	    if(radioClickedMgr==="TaskTable"){
	    	$('#devDropdownDivSupport').show();
	    	$('#TLDropdownDivSupport').show();
	    	$('#AllDetailsOfProjectsProgressSupport').hide();
	    	$('#TaskDetailsSupport').show();
	    	
	    	//   ProjectDetailsManagerTask     table ID
	    	
	    	var l = window.location;
		 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		 	var serviceUrl = base_url + "/UserActivity/getProjectDetails";
		 	var serviceUrl = base_url + "/UserActivity/getTaskDetailsSupport";
		 	
		    $.ajax({
		        type: 'POST',
		        url: serviceUrl,
		        dataType: 'json',
//		        data: 'TLname=' + tlName,
		        success: function(data5) {
//			alert("Support Data "+data5)
		        	 $('#ProjectDetailsSupportTask').DataTable().destroy();
		            var table = $("#ProjectDetailsSupportTask").DataTable({  
		                lengthChange: false,
		                pageLength: 10,
//		                paging: false,
		                data: data5,
		   //             scrollX: false,
//		                scrollY: '500px',
		                dom: 'Bfrtip',
		              
		            columnDefs: [
		                {
		                    targets: -1, // Target the last column
		                    render: function(data, type, row) {
		                    if(mainTable!="MDdashboard") {
		                    	if(data == 0){
		                    		 return '<span style="color: black;">' + data + '</span>';
		                    	} else if(data==="NA") {
		                   		 	return '<span style="color: black;">' + data + '</span>';
		                    	} else {
		                    		 return '<span style="color: red;">' + data + '</span>';
		                    	}
		                        // Customize the rendering to display data in red
		                    } else {
		                    	return data;
		                    }
		                    }
		                }
		            ],

		            });
		        }
		    });
	    	
	    } else if(radioClickedMgr==="ProgressTable"){
//	    	alert("in prog supp")
	    	$('#AllDetailsOfProjectsProgressSupport').show();
	    	$('#TaskDetailsSupport').hide();
	    	$('#devDropdownDivSupport').hide();
	    	$('#TLDropdownDivSupport').hide();
	    	
	    	
	     	
	    	var l = window.location;
	     	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	     	var serviceUrl = base_url + "/UserActivity/manualProposalApprovedDetailsMD";
	     	var serviceUrl = base_url + "/UserActivity/getProjectDetailsSupport";
	     	$('#spin11').show();
	        $.ajax({
	            type: 'POST',
	            url: serviceUrl,
	            dataType: 'json',
	            success: function(data5) {
	            	
	            	$('#spin11').hide();
//	    alert("data supp "+data5)
	    //console.log(data5)
	            	$('#ProjectDetailsSupport').DataTable().destroy();
	                var table = $("#ProjectDetailsSupport").DataTable({ 
	                    lengthChange: false,
	                    pageLength: 10,
	                    data: data5,
	                    scrollX: '300px',
//	                    scrollY: '300px',
	                    dom: 'Bfrtip', // Add this line to enable export buttons
	   
	                columnDefs: [
	                    {
	                        targets: -1, // Target the last column
	                        render: function(data, type, row) {
	                        if(mainTable!="MDdashboard") {
	                        	if(data == 0){
	                        		 return '<span style="color: black;">' + data + '</span>';
	                        	} else if(data==="NA") {
	                        		 return '<span style="color: black;">' + data + '</span>';
	                        	} else {
	                        		 return '<span style="color: red;">' + data + '</span>';
	                        	}
	                            // Customize the rendering to display data in red
	                        } else {
	                        	return data;
	                        }
	                        }
	                    }
	                ],

	                });
	            }
	        });
	    }
	    
	}







//09/08
function getDetailsByDevNameSupport(DeveloperName) {
	
	$('#teamLeadersSupport').val('');
	
	// alert("TL "+tlName);
	$("#AllDetailsOfManager").hide();
	if(DeveloperName==="All" || DeveloperName===""){
//		$('#ProjectDetailsManager tbody').empty();
		
		var l = window.location;
	 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	 	var serviceUrl = base_url + "/UserActivity/getProjectDetailsSupport1";
//	 	var serviceUrl = base_url + "/UserActivity/getTLProjectDetails";
	 	
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: 'TLname=' + tlName,
	        success: function(data5) {
//		alert("hxgdfg "+data5)
	        	 $('#ProjectDetailsSupportTask').DataTable().destroy();
	            var table = $("#ProjectDetailsSupportTask").DataTable({  
	                lengthChange: false,
	                pageLength: 10,
//	                paging: false,
	                data: data5,
	   //             scrollX: false,
//	                scrollY: '500px',
	                dom: 'Bfrtip',
	              
	            columnDefs: [
	                {
	                    targets: -1, // Target the last column
	                    render: function(data, type, row) {
	                    if(mainTable!="MDdashboard") {
	                    	if(data == 0){
	                    		 return '<span style="color: black;">' + data + '</span>';
	                    	} else if(data==="NA") {
	                   		 	return '<span style="color: black;">' + data + '</span>';
	                    	} else {
	                    		 return '<span style="color: red;">' + data + '</span>';
	                    	}
	                        // Customize the rendering to display data in red
	                    } else {
	                    	return data;
	                    }
	                    }
	                }
	            ],

	            });
	        }
	    });
		
		
	} else {
	 
	
	var l = window.location;
 	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
 //	var serviceUrl = base_url + "/UserActivity/getTLProjectDetails";
 	var serviceUrl = base_url + "/UserActivity/getDevProjectDetailsSupport";
 	
    $.ajax({
        type: 'POST',
        url: serviceUrl,
        dataType: 'json',
        data: 'DeveloperName=' + DeveloperName,
        success: function(data5) {
//	alert("hxgdfg "+data5)
        	 $('#ProjectDetailsSupportTask').DataTable().destroy();
            var table = $("#ProjectDetailsSupportTask").DataTable({ 
                lengthChange: false,
                pageLength: 10,
//                paging: false,
                data: data5,
   //             scrollX: false,
//                scrollY: '500px',
                dom: 'Bfrtip', // Add this line to enable export buttons
              
            columnDefs: [
                {
                    targets: -1, // Target the last column
                    render: function(data, type, row) {
                    if(mainTable!="MDdashboard") {
                    	if(data == 0){
                    		 return '<span style="color: black;">' + data + '</span>';
                    	} else if(data==="NA") {
                   		 	return '<span style="color: black;">' + data + '</span>';
                    	} else {
                    		 return '<span style="color: red;">' + data + '</span>';
                    	}
                        // Customize the rendering to display data in red
                    } else {
                    	return data;
                    }
                    }
                }
            ],

            });
        }
    });
	}
}
//





//14/08/2024
function clearFunctionNameDropdown() {
    document.getElementById('FnameN').selectedIndex = 0; // Clear the function name dropdown
}

//document.addEventListener('DOMContentLoaded', function() {
//    document.getElementById('projectNamesN').addEventListener('change', function() {
//        if (this.value) {
//            clearFunctionNameDropdown();
//        }
//    });
//});



function clearFunctionNameDropdown1() {
    document.getElementById('FnameN1').selectedIndex = 0; // Clear the function name dropdown
}

//document.addEventListener('DOMContentLoaded', function() {
//    document.getElementById('projectNamesN1').addEventListener('change', function() {
//        if (this.value) {
//            clearFunctionNameDropdown1();
//        }
//    });
//});

//




//17/08
function TotalActivitiesCount(){
//	alert("total activities clicked");
//	event.preventDefault();
//	alert("ActivitiesCompletedcount()");
//	$('#TotalActivitiesCompletedModal').modal("show");
	$('#TotalActivitiesCompletedModalNewHR').modal("show");
	
	
	var l = window.location;
	  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	  var serviceUrl = base_url + "/PMS/ActivitiesCompletedcountNew";
	  var TotalProjects = "TotalProjects";
	  
	  $.ajax({
	      url: serviceUrl,
	      type: 'POST',
	      dataType: 'json',
	      data: "methodName=" + TotalProjects ,

	  }).done(function(data2) {
//  	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTableMDNNew tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0];
	         	 var manager = project[1];
	              var prodSuite = project[2];
	              var prodTool = project[3];
	              var functionName = project[4];
	             var description = project[5];
	             var TLName1 = project[6];
	             var developerName1 = project[7];
	             var completionDate = project[8];
	             var endDate = project[9];
	             var status = project[10];
	             var revisedCount = project[11];
	             
	            
	             
	             function formatDate(dateStr) {
	                 if (!dateStr) {
	                     return ""; 
	                 }
	                 
	                 const dateParts = dateStr.split(/[.\s]/);
	                 if (dateParts.length < 3) {
	                     return ""; 
	                 }
	                 
	                 const day = dateParts[0];
	                 const month = dateParts[1];
	                 const year = dateParts[2];
	                 return `${day}.${month}.${year}`;
	             }

	             
	             var formattedCompletionDate = formatDate(completionDate);
	             var formattedEndDate = formatDate(endDate);

	             
	             var mergeDate = formattedCompletionDate || formattedEndDate;
	             mergeDate = formattedCompletionDate ? `${formattedCompletionDate} / ${formattedEndDate}` : formattedEndDate;
	             
	             
	             // Delay status
		          var currentDate = new Date();
		          var parts = endDate.split('.');
		          var formattedEndDate = new Date(parts[2], parts[1] - 1, parts[0]);

		          // Function to get class based on status
	     	        function getStatusClass(status) {
	    	        	 if (status === 'Completed') {
	     	                return 'completed';
	     	            } else if (status === 'Pending') {
	     	            	if(formattedEndDate < currentDate) {
	     	            		
	     	            		return 'delayed';
	     	            	} else {
	     	            		return 'pending';
	     	            	}
	     	                
	     	            } else {
	     	                return 'on-hold'; // Default class if status doesn't match
	     	            }
	    	        }
	             
	             //
	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (mergeDate ? mergeDate : 'NA') + '</td>' 
//	            '<td>' + (status ? status : 'NA') + '</td>' +
	            
	            //27/08
	            //27/08
	            if (status === "Pending") {
	                var stat = "Pending";
	                var stat2 = "Delayed";
	                if(formattedEndDate < currentDate) {
	                	row += '<td class="' + getStatusClass(status) + '">' + stat2 + '</td>';
	                }
	                else {
	                	row += '<td class="' + getStatusClass(status) + '">' + stat + '</td>';
	                }
	                
	            } else {
	                row += '<td class="' + getStatusClass(status) + '">' + status + '</td>';
	            }

	            row += '<td>' + (revisedCount ? revisedCount : 'NA') + '</td>' +
	                '</tr>';
	            
	            
	            
	            
	            
	            
	        $('#TotalcompletedProjectsTableMDNNew tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTableMDNNew tbody').append('<tr><td colspan="11">No Activities found</td></tr>');
	    }
});
	  
	  
	  
	  
	  
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/Master/getTeamLeader";     
		var serviceUrl = base_url + "/Master/getCompletedProjectListNew";
		
		$.ajax({

			url :serviceUrl,
			type : 'POST',
			dataType: 'json',
		}).done(function(data) {
			//	alert("Data "+data);
			var html =" <select class='form-control' tabindex='8' id='projectNamesNNew' name='projectNamesNNew'>";
			html=html+'<option value="">--Please Select--</option>';
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' +data[i]+ '">' + data[i]
				+ '</option>';
			}
			document.getElementById("projectNamesNNew").innerHTML=html;
			
		});	
		
		
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//		var serviceUrl = base_url + "/Master/getTeamLeader";     
		var serviceUrl = base_url + "/Master/getCompletedManagerList";
		
	$.ajax({

	  url :serviceUrl,
	  type : 'POST',
	  dataType: 'json',
	}).done(function(data) {
//	alert("Data "+data);
	  var html =" <select class='form-control' tabindex='8' id='prodmgrNNew' name='prodmgrNNew'>";
	  html=html+'<option value="">--Please Select--</option>';
	  for (var i = 0; i < data.length; i++) {
	      html += '<option value="' +data[i]+ '">' + data[i]
	      + '</option>';
	  }
	  document.getElementById("prodmgrNNew").innerHTML=html;
	});	
	
	
	
	
	
	
	
	//get Teamleader Name
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getCompletedTeamLeaderNew";
	var selectedValue = $("#teamLeaderNameNNew").val(); // Get the currently

	$.ajax({
		type : 'POST',
		url : serviceUrl,
		dataType : 'json',
		success : function(data4) {
//			alert(data4);

			var html = "<option value=''>-- Please Select --</option>";
			for (var i = 0; i < data4.length; i++) {
				var value = data4[i];
				html += '<option value="' + value + '">' + value + '</option>';
			}
			$("#teamLeaderNameNNew").html(html); // Update the select element	
			
		}

	});

	  
		var dataF = ['Development', 'Testing', 'POC', 'UAT', 'Implementation', 'Go Live'];
		var html = "<option value=''>-- Please Select --</option>";
		for (var i = 0; i < dataF.length; i++) {
		    var value = dataF[i];
		    html += '<option value="' + value + '">' + value + '</option>';
		}
		$("#FnameNNew").html(html);
		
		
		
		
		
		var dataS = ['Pending', 'Completed'];
		var html1 = "<option value=''>-- Please Select --</option>";
		for (var i = 0; i < dataS.length; i++) {
		    var value = dataS[i];
		    html1 += '<option value="' + value + '">' + value + '</option>';
		}
		$("#FnameNNewStatus").html(html1);
		
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/Master/getProductToolTotAct";
		

		$.ajax({
			type : 'POST',
			url : serviceUrl,
			dataType : 'json',
			success : function(data4) {
//				alert(data4);

				var html = "<option value=''>-- Please Select --</option>";
				for (var i = 0; i < data4.length; i++) {
					var value = data4[i];
					html += '<option value="' + value + '">' + value + '</option>';
				}
				$("#pToolTotAct").html(html); // Update the select element	
				
			}

		});

}
//

//mayur changes 4sep 2024

function getalltotalactTableList(){
	
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getProductToolListTotAct";
	
	  $.ajax({
	      url: serviceUrl,
	      type: 'POST',
	      dataType: 'json',
	    data: 'projectNamesNNew=' + $('#projectNamesNNew').val()
	    + '&prodmgrNNew=' + $('#prodmgrNNew').val()
	    +'&pToolTotAct=' + $('#pToolTotAct').val()
	    +'&teamLeaderNameNNew=' + $('#teamLeaderNameNNew').val()
	    +'&FnameNNew=' + $('#FnameNNew').val()
	    +'&FnameNNewStatus=' + $('#FnameNNewStatus').val(),


	  }).done(function(data2) {
//  	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTableMDNNew tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0];
	         	 var manager = project[1];
	              var prodSuite = project[2];
	              var prodTool = project[3];
	              var functionName = project[4];
	             var description = project[5];
	             var TLName1 = project[6];
	             var developerName1 = project[7];
	             var completionDate = project[8];
	             var endDate = project[9];
	             var status = project[10];
	             var revisedCount = project[11];
	             
	            
	             
	             function formatDate(dateStr) {
	                 if (!dateStr) {
	                     return ""; 
	                 }
	                 
	                 const dateParts = dateStr.split(/[.\s]/);
	                 if (dateParts.length < 3) {
	                     return ""; 
	                 }
	                 
	                 const day = dateParts[0];
	                 const month = dateParts[1];
	                 const year = dateParts[2];
	                 return `${day}.${month}.${year}`;
	             }

	             
	             var formattedCompletionDate = formatDate(completionDate);
	             var formattedEndDate = formatDate(endDate);

	             
	             var mergeDate = formattedCompletionDate || formattedEndDate;
	             mergeDate = formattedCompletionDate ? `${formattedCompletionDate} / ${formattedEndDate}` : formattedEndDate;
	             
	          // Delay status
		          var currentDate = new Date();
		          var parts = endDate.split('.');
		          var formattedEndDate = new Date(parts[2], parts[1] - 1, parts[0]);

	             // Function to get class based on status
	     	        function getStatusClass(status) {
	    	        	 if (status === 'Completed') {
	     	                return 'completed';
	     	            } else if (status === 'Pending') {
	     	            	if(formattedEndDate < currentDate) {
	     	            		
	     	            		return 'delayed';
	     	            	} else {
	     	            		return 'pending';
	     	            	}
	     	                
	     	            } else {
	     	                return 'on-hold'; // Default class if status doesn't match
	     	            }
	    	        }
	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (mergeDate ? mergeDate : 'NA') + '</td>' 
//	            '<td>' + (status ? status : 'NA') + '</td>' +
	            
	            if (status === "Pending") {
	                var stat = "Pending";
	                var stat2 = "Delayed";
	                if(formattedEndDate < currentDate) {
	                	row += '<td class="' + getStatusClass(status) + '">' + stat2 + '</td>';
	                }
	                else {
	                	row += '<td class="' + getStatusClass(status) + '">' + stat + '</td>';
	                }
	            } else if(status === "Delayed") {
	                row += '<td style="color:red;">' + stat + '</td>';
	            } else {
	                row += '<td class="' + getStatusClass(status) + '">' + status + '</td>';
	            }

	            row += '<td>' + (revisedCount ? revisedCount : 'NA') + '</td>' +
	                '</tr>';
	            
	            
	            '<td>' + (revisedCount ? revisedCount : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTableMDNNew tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTableMDNNew tbody').append('<tr><td colspan="11">No Activities found</td></tr>');
	    }
});
	
	

}

function ProductToolTotAct() {
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/Master/getProductToolListTotAct";

	  $.ajax({
	      url: serviceUrl,
	      type: 'POST',
	      dataType: 'json',
	    data: 'projectNamesNNew=' + $('#projectNamesNNew').val()
	    + '&prodmgrNNew=' + $('#prodmgrNNew').val()
	    +'&pToolTotAct=' + $('#pToolTotAct').val()
	    +'&teamLeaderNameNNew=' + $('#teamLeaderNameNNew').val()
	    +'&FnameNNew=' + $('#FnameNNew').val()
	    +'&FnameNNewStatus=' + $('#FnameNNewStatus').val(),


	  }).done(function(data2) {
//  	alert("niininiii "+data2)

	    $('#TotalcompletedProjectsTableMDNNew tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0];
	         	 var manager = project[1];
	              var prodSuite = project[2];
	              var prodTool = project[3];
	              var functionName = project[4];
	             var description = project[5];
	             var TLName1 = project[6];
	             var developerName1 = project[7];
	             var completionDate = project[8];
	             var endDate = project[9];
	             var status = project[10];
	             var revisedCount = project[11];
	             
	            
	             
	             function formatDate(dateStr) {
	                 if (!dateStr) {
	                     return ""; 
	                 }
	                 
	                 const dateParts = dateStr.split(/[.\s]/);
	                 if (dateParts.length < 3) {
	                     return ""; 
	                 }
	                 
	                 const day = dateParts[0];
	                 const month = dateParts[1];
	                 const year = dateParts[2];
	                 return `${day}.${month}.${year}`;
	             }

	             
	             var formattedCompletionDate = formatDate(completionDate);
	             var formattedEndDate = formatDate(endDate);

	             
	             var mergeDate = formattedCompletionDate || formattedEndDate;
	             mergeDate = formattedCompletionDate ? `${formattedCompletionDate} / ${formattedEndDate}` : formattedEndDate;

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (functionName ? functionName : 'NA') + '</td>' +
	            '<td>' + (description ? description : 'NA') + '</td>' +
	            '<td>' + (TLName1 ? TLName1 : 'NA') + '</td>' +
	            '<td>' + (developerName1 ? developerName1 : 'NA') + '</td>' +
	            '<td>' + (mergeDate ? mergeDate : 'NA') + '</td>' +
	            '<td>' + (status ? status : 'NA') + '</td>' +
	            '<td>' + (revisedCount ? revisedCount : 'NA') + '</td>' +
	            '</tr>';
	        $('#TotalcompletedProjectsTableMDNNew tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#TotalcompletedProjectsTableMDNNew tbody').append('<tr><td colspan="11">No Activities found</td></tr>');
	    }
});
		
		
		
		var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];  
		var serviceUrl = base_url + "/Master/getProductToolByManagerTotAct";
		
		$.ajax({

			url :serviceUrl,
			type : 'POST',
			dataType: 'json',
			data: 'projectNamesNNew=' + $('#projectNamesNNew').val()
		    + '&prodmgrNNew=' + $('#prodmgrNNew').val() 
		    + '&pToolTotAct=' + $('#pToolTotAct').val()
		}).done(function(data) {
//		alert("Data "+data);
			var html =" <select class='form-control' tabindex='8' id='teamLeaderNameNNew' name='teamLeaderNameNNew'>";
			html=html+'<option value="">--Please Select--</option>';
			for (var i = 0; i < data.length; i++) {
				html += '<option value="' +data[i]+ '">' + data[i]
				+ '</option>';
			}
			document.getElementById("teamLeaderNameNNew").innerHTML=html;
		});	

}


//17/08
function CompletedManagerListDetNew(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedManagerListDetNew";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNNew=' + $('#projectNamesNNew').val()
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='prodmgrNNew' name='prodmgrNNew'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("prodmgrNNew").innerHTML=html;
	});	
	

	getalltotalactTableList();
	//changes

}
//


//17/05
function CompletedTLListDetNew(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedTLListDetNew";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNNew=' + $('#projectNamesNNew').val() +
		'&prodmgrNNew=' + $('#prodmgrNNew').val()
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='teamLeaderNameNNew' name='teamLeaderNameNNew'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("pToolTotAct").innerHTML=html;
	
	});	
	
	getalltotalactTableList();	

}

//



//17/08
function CompletedFunctionListDetNew(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedFunctionListDetNew";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNNew=' + $('#projectNamesNNew').val() +
		'&prodmgrNNew=' + $('#prodmgrNNew').val() +
		'&teamLeaderNameNNew=' + $('#teamLeaderNameNNew').val() +
		'&pToolTotAct=' + $('#pToolTotAct').val() +
		'&FnameNNew=' + $('#FnameNNew')
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='FnameNNew' name='FnameNNew'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("FnameNNew").innerHTML=html;
	});	
	
	getalltotalactTableList();
	
	


}

//





//17/08
function CompletedDetailsBasedOnAllNew(){
	
	getalltotalactTableList();
}

//

//17/08
function resetAllDDNNew() {
//	 alert("reset") 
	TotalActivitiesCount();
  
}
//


//17/08
function clearFunctionNameDropdownNew() {
    document.getElementById('FnameNNew').selectedIndex = 0; // Clear the function name dropdown
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('projectNamesNNew').addEventListener('change', function() {
        if (this.value) {
            clearFunctionNameDropdownNew();
        }
    });
});

//


//17/08
$(document).ready(function() {
	$('#TotalcompletedProjectsTableMDNNew').find('*').addClass('text-xs');
});

//


//21/08
//function statusChanged(status) {
//    CompletedDetailsBasedOnAllNew();
//}

//



//20/08
function statusChanged(){
	
	getalltotalactTableList();
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedStatusListDetNew";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNNew=' + $('#projectNamesNNew').val() +
		'&prodmgrNNew=' + $('#prodmgrNNew').val() +
		'&teamLeaderNameNNew=' + $('#teamLeaderNameNNew').val() + 
		'&FnameNNew=' + $('#FnameNNew').val() + 
		'&pToolTotAct=' + $('#pToolTotAct').val() +
		'&FnameNNewStatus=' + $('#FnameNNewStatus')
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='FnameNNewStatus' name='FnameNNewStatus'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("FnameNNewStatus").innerHTML=html;
	});	
	


}



//21/08
function clearStatusDropdownNew() {
    document.getElementById('FnameNNewStatus').selectedIndex = 0; // Clear the function name dropdown
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('projectNamesNNew').addEventListener('change', function() {
        if (this.value) {
        	clearStatusDropdownNew();
        }
    });
});

//




//23/08
function CompletedManagerListDetTrack(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedManagerListDetTrack";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNTrack=' + $('#projectNamesNTrack').val()
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='prodmgrNTrack' name='prodmgrNTrack'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("prodmgrNTrack").innerHTML=html;
	});	
	
	
	
	//changes
	var serviceUrl = base_url + "/Master/CompletedDetailsByCusTrack";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNTrack=' + $('#projectNamesNTrack').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#completedProjectsTable tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	      		var customer = project[0][0];
	         	 var prodSuite = project[0][1];
	              var prodTool = project[0][2];
	              var completionDate = project[0][3];
	              var manager = project[0][4];
	             var status = project[0][5];
	             

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (completionDate ? completionDate : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (status ? status : 'NA') + '</td>' +
	            
	            '</tr>';
	        $('#completedProjectsTable tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#completedProjectsTable tbody').append('<tr><td colspan="6">No Activities found</td></tr>');
	    }
	        

})

}

//



//23/08
function CompletedTLListDetTrack(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedTLListDetTrack";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNTrack=' + $('#projectNamesNTrack').val() +
		'&prodmgrNTrack=' + $('#prodmgrNTrack').val()
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='teamLeaderNameNTrack' name='teamLeaderNameNTrack'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("teamLeaderNameNTrack").innerHTML=html;
		
		
		
		var serviceUrl = base_url + "/Master/CompletedBasedOnManagerTrack";
		
//		var selectedMan=$('#prodmgrN').val();
		
		$.ajax({

			url :serviceUrl,
			type : 'POST',
			dataType: 'json',
			data: 'prodmgrNTrack=' + $('#prodmgrNTrack').val() +
			'&projectNamesNTrack=' + $('#projectNamesNTrack').val() +
			'&teamLeaderNameNTrack=' + $('#teamLeaderNameNTrack').val() +
			'&FnameNTrack=' + $('#FnameNTrack').val()
			
		}).done(function(data2) {
//	 	alert("niininiii "+data2)

		    $('#completedProjectsTable tbody').empty();

		        if (data2 && data2.length > 0) {
		        data2.forEach(function(project) {
		        	var customer = project[0][0];
		         	 var prodSuite = project[0][1];
		              var prodTool = project[0][2];
		              var completionDate = project[0][3];
		              var manager = project[0][4];
		             var status = project[0][5];

		            
		            var row = '<tr>' +
		            '<td>' + (customer ? customer : 'NA') + '</td>' +
		            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
		            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
		            '<td>' + (completionDate ? completionDate : 'NA') + '</td>' +
		            '<td>' + (manager ? manager : 'NA') + '</td>' +
		            '<td>' + (status ? status : 'NA') + '</td>' +
		            '</tr>';
		        $('#completedProjectsTable tbody').append(row);
		    });
		    } else {
//		        console.log("No data received");
		        $('#completedProjectsTable tbody').append('<tr><td colspan="6">No Activities found</td></tr>');
		    }
		        

	})
	
	});	
	
	
	//changes
	var serviceUrl = base_url + "/Master/CompletedDetailsByCusAndManTrack";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNTrack=' + $('#projectNamesNTrack').val() +
		'&prodmgrNTrack=' + $('#prodmgrNTrack').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#completedProjectsTable tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	        	var customer = project[0][0];
	         	 var prodSuite = project[0][1];
	              var prodTool = project[0][2];
	              var completionDate = project[0][3];
	              var manager = project[0][4];
	             var status = project[0][5];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (completionDate ? completionDate : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (status ? status : 'NA') + '</td>' +
	            '</tr>';
	        $('#completedProjectsTable tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#completedProjectsTable tbody').append('<tr><td colspan="6">No Activities found</td></tr>');
	    }
	        

})
	

}


//



//23/08
function CompletedFunctionListDetTrack(){
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
//	var serviceUrl = base_url + "/Master/getTeamLeader";     
	var serviceUrl = base_url + "/Master/CompletedFunctionListDetTrack";
	
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNTrack=' + $('#projectNamesNTrack').val() +
		'&prodmgrNTrack=' + $('#prodmgrNTrack').val() +
		'&teamLeaderNameNTrack=' + $('#teamLeaderNameNTrack').val() + 
		'&FnameNTrack=' + $('#FnameNTrack')
	}).done(function(data) {
//	alert("Data "+data);
		var html =" <select class='form-control' tabindex='8' id='FnameNTrack' name='FnameNTrack'>";
		html=html+'<option value="">--Please Select--</option>';
		for (var i = 0; i < data.length; i++) {
			html += '<option value="' +data[i]+ '">' + data[i]
			+ '</option>';
		}
		document.getElementById("FnameNTrack").innerHTML=html;
	});	
	
	
	
	//changes
	var serviceUrl = base_url + "/Master/CompletedDetailsByCusManAndTLTrack";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNTrack=' + $('#projectNamesNTrack').val() +
		'&prodmgrNTrack=' + $('#prodmgrNTrack').val() +
		'&teamLeaderNameNTrack=' + $('#teamLeaderNameNTrack').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#completedProjectsTable tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	        	var customer = project[0][0];
	         	 var prodSuite = project[0][1];
	              var prodTool = project[0][2];
	              var completionDate = project[0][3];
	              var manager = project[0][4];
	             var status = project[0][5];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (completionDate ? completionDate : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (status ? status : 'NA') + '</td>' +
	            '</tr>';
	        $('#completedProjectsTable tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#completedProjectsTable tbody').append('<tr><td colspan="6">No Activities found</td></tr>');
	    }
	        

})

}

//



//23/08
function CompletedDetailsBasedOnAllTrack(){
	
	var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	
	var serviceUrl = base_url + "/Master/CompletedDetailsBasedOnAllTrack";
	$.ajax({

		url :serviceUrl,
		type : 'POST',
		dataType: 'json',
		data: 'projectNamesNTrack=' + $('#projectNamesNTrack').val() +
		'&prodmgrNTrack=' + $('#prodmgrNTrack').val() +
		'&teamLeaderNameNTrack=' + $('#teamLeaderNameNTrack').val() +
		'&FnameNTrack=' + $('#FnameNTrack').val()
	}).done(function(data2) {
// 	alert("niininiii "+data2)

	    $('#completedProjectsTable tbody').empty();

	        if (data2 && data2.length > 0) {
	        data2.forEach(function(project) {
	        	var customer = project[0][0];
	         	 var prodSuite = project[0][1];
	              var prodTool = project[0][2];
	              var completionDate = project[0][3];
	              var manager = project[0][4];
	             var status = project[0][5];

	            
	            var row = '<tr>' +
	            '<td>' + (customer ? customer : 'NA') + '</td>' +
	            '<td>' + (prodSuite ? prodSuite : 'NA') + '</td>' +
	            '<td>' + (prodTool ? prodTool : 'NA') + '</td>' +
	            '<td>' + (completionDate ? completionDate : 'NA') + '</td>' +
	            '<td>' + (manager ? manager : 'NA') + '</td>' +
	            '<td>' + (status ? status : 'NA') + '</td>' +
	            '</tr>';
	        $('#completedProjectsTable tbody').append(row);
	    });
	    } else {
//	        console.log("No data received");
	        $('#completedProjectsTable tbody').append('<tr><td colspan="6">No Activities found</td></tr>');
	    }
	        

})

}

//


//23/08
function resetAllDDNTrack(){
	
	Projectontrack();
}

// Shubham 


function getListByProjects() {
	
	
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getDelayedProjectListByName";
//	    var projectNameBy = $('#projectName').val(); 
	    
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: "projectName=" + $("#DelayprojectNames").val()
			+ "&productSuite=" + $("#prodSuiteDelayproject").val()
			+ "&productTool=" + $("#productToolDelayProj").val()
			+ "&managerName=" + $("#managerNameDelay").val(),
	        success: function(data) {
//	            console.log("Data received:", data); // Log received data for debugging

	            // Clear existing table rows
	            $('#DelayedProjectList tbody').empty();

	            // Populate table with project data
	            if (data && data.length > 0) {
	                data.forEach(function(project) {
	                    try {
	                        var projectName = project[0][0];  
	                        var ProductSuite = project[0][1];
	                        var ProductTool = project[0][2];
	                        var Manager = project[0][3];
	                        var targetDate = project[0][4];
	                        var status = project[0][5];

	                        // Create HTML row and append to table
	                        var row = '<tr>' +
	                            '<td>' + projectName + '</td>' +
	                            '<td>' + ProductSuite + '</td>' +
	                            '<td>' + ProductTool + '</td>' +
	                            '<td>' + targetDate + '</td>' +
	                            '<td>' + Manager + '</td>' +
//	                            '<td>' + status + '</td>' +
	                            '<td style="color:red;">' + status + '</td>' +
	                            '</tr>';
	                        $('#DelayedProjectList tbody').append(row);
	                    } catch (error) {
	                        console.error('Error parsing project data:', error);
	                    }
	                });
	            } else {
	                // No data received
	                $('#DelayedProjectList tbody').append('<tr><td colspan="5">No projects found</td></tr>');
	            }
	        },
	        error: function(xhr, status, error) {
	            console.error('Error fetching project data:', error);
	            // Show error message in table
	            $('#DelayedProjectList tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
	        }
	    });
	
	
	  var l = window.location;
		var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
		var serviceUrl = base_url + "/PMS/getProdSuiteByProject";

		$
				.ajax({

					url : serviceUrl,
					type : 'POST',
					dataType : 'json',
					data : "projectName=" + $("#DelayprojectNames").val(),
				})
				.done(
						function(data) {
							// alert("Data "+data);
							var html = " <select class='form-control' tabindex='8' id='prodSuiteDelayproject' name='prodSuiteDelayproject'>";
							html = html
									+ '<option value="">--Please Select--</option>';
							for (var i = 0; i < data.length; i++) {
								html += '<option value="' + data[i] + '">'
										+ data[i] + '</option>';
							}
							document.getElementById("prodSuiteDelayproject").innerHTML = html;
						});
			
}






function getDelayProjectsBySuite () {
	
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getDelayedProjectListByName";
//	    var projectNameBy = $('#projectName').val(); 
	    
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: "projectName=" + $("#DelayprojectNames").val()
			+ "&productSuite=" + $("#prodSuiteDelayproject").val()
			+ "&productTool=" + $("#productToolDelayProj").val()
			+ "&managerName=" + $("#managerNameDelay").val(),
	        success: function(data) {
//	            console.log("Data received:", data); // Log received data for debugging

	            // Clear existing table rows
	            $('#DelayedProjectList tbody').empty();

	            // Populate table with project data
	            if (data && data.length > 0) {
	                data.forEach(function(project) {
	                    try {
	                        var projectName = project[0][0];  
	                        var ProductSuite = project[0][1];
	                        var ProductTool = project[0][2];
	                        var Manager = project[0][3];
	                        var targetDate = project[0][4];
	                        var status = project[0][5];

	                        // Create HTML row and append to table
	                        var row = '<tr>' +
	                            '<td>' + projectName + '</td>' +
	                            '<td>' + ProductSuite + '</td>' +
	                            '<td>' + ProductTool + '</td>' +
	                            '<td>' + targetDate + '</td>' +
	                            '<td>' + Manager + '</td>' +
//	                            '<td>' + status + '</td>' +
	                            '<td style="color:red;">' + status + '</td>' +
	                            '</tr>';
	                        $('#DelayedProjectList tbody').append(row);
	                    } catch (error) {
	                        console.error('Error parsing project data:', error);
	                    }
	                });
	            } else {
	                // No data received
	                $('#DelayedProjectList tbody').append('<tr><td colspan="5">No projects found</td></tr>');
	            }
	        },
	        error: function(xhr, status, error) {
	            console.error('Error fetching project data:', error);
	            // Show error message in table
	            $('#DelayedProjectList tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
	        }
	    });
	
	
	
var l = window.location;
var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
var serviceUrl = base_url + "/PMS/getDelayProdToolBySuite";

$
		.ajax({

			url : serviceUrl,
			type : 'POST',
			dataType : 'json',
			data : "productSuite=" + $("#prodSuiteDelayproject").val(),
		})
		.done(
				function(data) {
					// alert("Data "+data);
					var html = " <select class='form-control' tabindex='8' id='productToolDelayProj' name='productToolDelayProj'>";
					html = html
							+ '<option value="">--Please Select--</option>';
					for (var i = 0; i < data.length; i++) {
						html += '<option value="' + data[i] + '">'
								+ data[i] + '</option>';
					}
					document.getElementById("productToolDelayProj").innerHTML = html;
				});

}



function getDelayProjByTool() {
	
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getDelayedProjectListByName";
//	    var projectNameBy = $('#projectName').val(); 
	    
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: "projectName=" + $("#DelayprojectNames").val()
			+ "&productSuite=" + $("#prodSuiteDelayproject").val()
			+ "&productTool=" + $("#productToolDelayProj").val()
			+ "&managerName=" + $("#managerNameDelay").val(),
	        success: function(data) {
//	            console.log("Data received:", data); // Log received data for debugging

	            // Clear existing table rows
	            $('#DelayedProjectList tbody').empty();

	            // Populate table with project data
	            if (data && data.length > 0) {
	                data.forEach(function(project) {
	                    try {
	                        var projectName = project[0][0];  
	                        var ProductSuite = project[0][1];
	                        var ProductTool = project[0][2];
	                        var Manager = project[0][3];
	                        var targetDate = project[0][4];
	                        var status = project[0][5];

	                        // Create HTML row and append to table
	                        var row = '<tr>' +
	                            '<td>' + projectName + '</td>' +
	                            '<td>' + ProductSuite + '</td>' +
	                            '<td>' + ProductTool + '</td>' +
	                            '<td>' + targetDate + '</td>' +
	                            '<td>' + Manager + '</td>' +
//	                            '<td>' + status + '</td>' +
	                            '<td style="color:red;">' + status + '</td>' +
	                            '</tr>';
	                        $('#DelayedProjectList tbody').append(row);
	                    } catch (error) {
	                        console.error('Error parsing project data:', error);
	                    }
	                });
	            } else {
	                // No data received
	                $('#DelayedProjectList tbody').append('<tr><td colspan="5">No projects found</td></tr>');
	            }
	        },
	        error: function(xhr, status, error) {
	            console.error('Error fetching project data:', error);
	            // Show error message in table
	            $('#DelayedProjectList tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
	        }
	    });
	
    
    var l = window.location;
	var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	var serviceUrl = base_url + "/PMS/getDelayManagerByTool";

	$
			.ajax({

				url : serviceUrl,
				type : 'POST',
				dataType : 'json',
				data : "productTool=" + $("#productToolDelayProj").val(),
			})
			.done(
					function(data) {
						// alert("Data "+data);
						var html = " <select class='form-control' tabindex='8' id='managerNameDelay' name='managerNameDelay'>";
						html = html
								+ '<option value="">--Please Select--</option>';
						for (var i = 0; i < data.length; i++) {
							html += '<option value="' + data[i] + '">'
									+ data[i] + '</option>';
						}
						document.getElementById("managerNameDelay").innerHTML = html;
					});
	
	
}


function getDelayProjByManager() {
	
	 var l = window.location;
	    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
	    var serviceUrl = base_url + "/PMS/getDelayedProjectListByName";
//	    var projectNameBy = $('#projectName').val(); 
	    
	    $.ajax({
	        type: 'POST',
	        url: serviceUrl,
	        dataType: 'json',
	        data: "projectName=" + $("#DelayprojectNames").val()
			+ "&productSuite=" + $("#prodSuiteDelayproject").val()
			+ "&productTool=" + $("#productToolDelayProj").val()
			+ "&managerName=" + $("#managerNameDelay").val(),
	        success: function(data) {
//	            console.log("Data received:", data); // Log received data for debugging

	            // Clear existing table rows
	            $('#DelayedProjectList tbody').empty();

	            // Populate table with project data
	            if (data && data.length > 0) {
	                data.forEach(function(project) {
	                    try {
	                        var projectName = project[0][0];  
	                        var ProductSuite = project[0][1];
	                        var ProductTool = project[0][2];
	                        var Manager = project[0][3];
	                        var targetDate = project[0][4];
	                        var status = project[0][5];

	                        // Create HTML row and append to table
	                        var row = '<tr>' +
	                            '<td>' + projectName + '</td>' +
	                            '<td>' + ProductSuite + '</td>' +
	                            '<td>' + ProductTool + '</td>' +
	                            '<td>' + targetDate + '</td>' +
	                            '<td>' + Manager + '</td>' +
//	                            '<td>' + status + '</td>' +
	                            '<td style="color:red;">' + status + '</td>' +
	                            '</tr>';
	                        $('#DelayedProjectList tbody').append(row);
	                    } catch (error) {
	                        console.error('Error parsing project data:', error);
	                    }
	                });
	            } else {
	                // No data received
	                $('#DelayedProjectList tbody').append('<tr><td colspan="5">No projects found</td></tr>');
	            }
	        },
	        error: function(xhr, status, error) {
	            console.error('Error fetching project data:', error);
	            // Show error message in table
	            $('#DelayedProjectList tbody').empty().append('<tr><td colspan="3">Error fetching data</td></tr>');
	        }
	    });
}


function resetAllDelayProjects() {
	$('#DelayprojectNames').val("");
	$('#prodSuiteDelayproject').val("");
	$('#productToolDelayProj').val("");
	$('#managerNameDelay').val("");
	
	TotalDelayedProject();
}




//26/08
function clearStatusDropdownNew() {
    document.getElementById('FnameNTrack').selectedIndex = 0; // Clear the function name dropdown
}

//document.addEventListener('DOMContentLoaded', function() {
//    document.getElementById('projectNamesNTrack').addEventListener('change', function() {
//        if (this.value) {
//        	clearStatusDropdownNew();
//        }
//    });
//});

//



//02/09
function clearStatusDropdownNew1() {
    document.getElementById('teamLeaderNameN').selectedIndex = 0; // Clear the function name dropdown
}

//document.addEventListener('DOMContentLoaded', function() {
//    document.getElementById('projectNamesN').addEventListener('change', function() {
//        if (this.value) {
//        	clearStatusDropdownNew1();
//        }
//    });
//});

//



//02/09
function clearStatusDropdownNew2() {
    document.getElementById('FnameNNewStatus').selectedIndex = 0; // Clear the function name dropdown
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('projectNamesNNew').addEventListener('change', function() {
        if (this.value) {
        	clearStatusDropdownNew2();
        }
    });
});



function clearStatusDropdownNew3() {
    document.getElementById('FnameNNewStatus').selectedIndex = 0; // Clear the function name dropdown
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('prodmgrNNew').addEventListener('change', function() {
        if (this.value) {
        	clearStatusDropdownNew3();
        }
    });
});



function clearStatusDropdownNew4() {
    document.getElementById('FnameNNewStatus').selectedIndex = 0; // Clear the function name dropdown
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('teamLeaderNameNNew').addEventListener('change', function() {
        if (this.value) {
        	clearStatusDropdownNew4();
        }
    });
});




function clearStatusDropdownNew5() {
    document.getElementById('teamLeaderNameNNew').selectedIndex = 0; // Clear the function name dropdown
}

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('projectNamesNNew').addEventListener('change', function() {
        if (this.value) {
        	clearStatusDropdownNew5();
        }
    });
});
//


//02/09
$('#searchBoxProjects').on('keyup', function() {
    var value = $(this).val().toLowerCase();
    $('#getemployeedataforhr tbody tr').filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
});
});
//


//13/09
$('#searchBoxProjectsTotalAct').on('keyup', function() {
    var value = $(this).val().toLowerCase();
    $('#TotalcompletedProjectsTableMDNNew tbody tr').filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});
//


//13/09
$('#searchBoxMaleEmps').on('keyup', function() {
    var value = $(this).val().toLowerCase();
    $('#maleEmpsTable tbody tr').filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

//


//13/09
$('#searchBoxFemaleEmps').on('keyup', function() {
    var value = $(this).val().toLowerCase();
    $('#femaleEmpsTable tbody tr').filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
    });
});

//




//06/09/2024
//getTotalEmployees
function getTotalEmployees() {
//  alert("hh");
//	alert("clicked");
	event.preventDefault();
  $("#completedProjectsModal").modal("show");
//  $("#outerDiv").modal("show");
  
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getTotalEmployees";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data2) {
          // Check if data is received
//          console.log("Data received:", data2);

          // Clear existing table rows
          $('#completedProjectsTable tbody').empty();

          // Populate table with project data
          if (data2 && data2.length > 0) {
              data2.forEach(function(project) {
//              	 var EmpName = project[0][0];
//                   var EmpId = project[0][1];
//                   var Deapartment = project[0][2];
//                   var Role = project[0][3];
//                   var Designation = project[0][4];
//                   var Branch = project[0][5];
//                   var Email = project[0][6];
//                   var Mobile = project[0][7];
//                   var Location = project[0][8];
            	  
            	  	 var EmpName = project[0][0] ? project[0][0] : 'NA';
	            	 var EmpId = project[0][1] ? project[0][1] : 'NA';
	            	 var Department = project[0][2] ? project[0][2] : 'NA';
	            	 var Role = project[0][3] ? project[0][3] : 'NA';
	            	 var Designation = project[0][4] ? project[0][4] : 'NA';
	            	 var Branch = project[0][5] ? project[0][5] : 'NA';
	            	 var Email = project[0][6] ? project[0][6] : 'NA';
	            	 var Mobile = project[0][7] ? project[0][7] : 'NA';
	            	 var Location = project[0][8] ? project[0][8] : 'NA';
                   var row = '<tr>' +
                       '<td>' + EmpName + '</td>' +
                       '<td>' + EmpId + '</td>' +
                       '<td>' + Department + '</td>' +
                       '<td>' + Role + '</td>' +
                       '<td>' + Designation + '</td>' +
                       '<td>' + Branch + '</td>' +
//                     '<td>' + prodSuite + '</td>' +
                       '<td>' + Email + '</td>' +
                       '<td>' + Mobile + '</td>' +
                       '<td>' + Location + '</td>' +

                       '</tr>';
                  $('#completedProjectsTable tbody').append(row);
              });
          } else {
              // No data received
//              console.log("No data received");
              $('#completedProjectsTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
          }
      },
      error: function(xhr, status, error) {
          console.error('Error fetching project data:', error);
          // Show error message in table
          $('#completedProjectsTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
      }
  });
  
 
}


//getActiveEmpsOnPms
function getActiveEmpsOnPms() {
//  alert("hh");
//	alert("active clicked");
	event.preventDefault();
  $("#getActiveEmpsOnPmsModal").modal("show");

  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getActiveEmpsOnPms";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data2) {
          // Check if data is received
//          console.log("Data received:", data2);

          // Clear existing table rows
          $('#getActiveEmpsOnPmsModalTable tbody').empty();

          // Populate table with project data
          if (data2 && data2.length > 0) {
              data2.forEach(function(project) {
//              	 var EmpName = project[0][0];
//                   var EmpId = project[0][1];
//                   var Department = project[0][2];
//                   var Role = project[0][3];
//                   var Designation = project[0][4];
//                   var LastLogin = project[0][5];
//                   var Activity = project[0][6];
//                   var Status = project[0][7];
            	  
            	  
            	     var EmpName = project[0][0] ? project[0][0] : 'NA';
            	     var EmpId = project[0][1] ? project[0][1] : 'NA';
            	     var Department = project[0][2] ? project[0][2] : 'NA'; 
            	     var Role = project[0][3] ? project[0][3] : 'NA';
            	     var Designation = project[0][4] ? project[0][4] : 'NA';
            	     var LastLogin = project[0][5] ? project[0][5] : 'NA';
            	     var Activity = project[0][6] ? project[0][6] : 'NA';
            	     var Status = project[0][7] ? project[0][7] : 'NA';
                 
                   var row = '<tr>' +
                       '<td>' + EmpName + '</td>' +
                       '<td>' + EmpId + '</td>' +
                       '<td>' + Department + '</td>' +
                       '<td>' + Role + '</td>' +
                       '<td>' + Designation + '</td>' +
                       '<td>' + LastLogin + '</td>' +
//                     '<td>' + prodSuite + '</td>' +
//                       '<td>' + Activity + '</td>' +
                       '<td>' + Status + '</td>' +

                       '</tr>';
                  $('#getActiveEmpsOnPmsModalTable tbody').append(row);
              });
          } else {
              // No data received
//              console.log("No data received");
              $('#getActiveEmpsOnPmsModalTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
          }
      },
      error: function(xhr, status, error) {
          console.error('Error fetching project data:', error);
          // Show error message in table
          $('#getActiveEmpsOnPmsModalTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
      }
  });
  
 }




function getMaleEmps() {
//  alert("hh");
//	alert("clicked");
	event.preventDefault();
  $("#maleEmpsModal").modal("show");
//  $("#outerDiv").modal("show");
  
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getMaleEmps";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data2) {
          // Check if data is received
//          console.log("Data received:", data2);

          // Clear existing table rows
          $('#maleEmpsTable tbody').empty();

          // Populate table with project data
          if (data2 && data2.length > 0) {
              data2.forEach(function(project) {
//              	 var EmpName = project[0][0];
//                   var EmpId = project[0][1];
//                   var Deapartment = project[0][2];
//                   var Role = project[0][3];
//                   var Designation = project[0][4];
//                   var Branch = project[0][5];
//                   var Email = project[0][6];
//                   var Mobile = project[0][7];
//                   var Location = project[0][8];
            	  
            	  	 var EmpName = project[0][0] ? project[0][0] : 'NA';
	            	 var EmpId = project[0][1] ? project[0][1] : 'NA';
//	            	 var Department = project[0][2] ? project[0][2] : 'NA';
//	            	 var Role = project[0][3] ? project[0][3] : 'NA';
//	            	 var Designation = project[0][4] ? project[0][4] : 'NA';
//	            	 var Branch = project[0][5] ? project[0][5] : 'NA';
	            	 var Email = project[0][6] ? project[0][6] : 'NA';
	            	 var Mobile = project[0][7] ? project[0][7] : 'NA';
//	            	 var Location = project[0][8] ? project[0][8] : 'NA';
	            	 var Gender = project[0][8] ? project[0][8] : 'NA';
                   var row = '<tr>' +
                       '<td>' + EmpName + '</td>' +
                       '<td>' + EmpId + '</td>' +
//                       '<td>' + Department + '</td>' +
//                       '<td>' + Role + '</td>' +
//                       '<td>' + Designation + '</td>' +
//                       '<td>' + Branch + '</td>' +
//                     '<td>' + prodSuite + '</td>' +
                       '<td>' + Email + '</td>' +
                       '<td>' + Mobile + '</td>' +
//                       '<td>' + Location + '</td>' +
                       '<td>' + Gender + '</td>' +

                       '</tr>';
                  $('#maleEmpsTable tbody').append(row);
              });
          } else {
              // No data received
//              console.log("No data received");
              $('#maleEmpsTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
          }
      },
      error: function(xhr, status, error) {
          console.error('Error fetching project data:', error);
          // Show error message in table
          $('#maleEmpsTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
      }
  });
  
 
}




function getFemaleEmps() {
//  alert("hh");
//	alert("clicked");
	event.preventDefault();
  $("#femaleEmpsModal").modal("show");
//  $("#outerDiv").modal("show");
  
  var l = window.location;
  var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
  var serviceUrl = base_url + "/PMS/getFemaleEmps";

  $.ajax({
      type: 'POST',
      url: serviceUrl,
      dataType: 'json',
      success: function(data2) {
          // Check if data is received
//          console.log("Data received:", data2);

          // Clear existing table rows
          $('#femaleEmpsTable tbody').empty();

          // Populate table with project data
          if (data2 && data2.length > 0) {
              data2.forEach(function(project) {
//              	 var EmpName = project[0][0];
//                   var EmpId = project[0][1];
//                   var Deapartment = project[0][2];
//                   var Role = project[0][3];
//                   var Designation = project[0][4];
//                   var Branch = project[0][5];
//                   var Email = project[0][6];
//                   var Mobile = project[0][7];
//                   var Location = project[0][8];
            	  
            	  	 var EmpName = project[0][0] ? project[0][0] : 'NA';
	            	 var EmpId = project[0][1] ? project[0][1] : 'NA';
//	            	 var Department = project[0][2] ? project[0][2] : 'NA';
//	            	 var Role = project[0][3] ? project[0][3] : 'NA';
//	            	 var Designation = project[0][4] ? project[0][4] : 'NA';
//	            	 var Branch = project[0][5] ? project[0][5] : 'NA';
	            	 var Email = project[0][6] ? project[0][6] : 'NA';
	            	 var Mobile = project[0][7] ? project[0][7] : 'NA';
//	            	 var Location = project[0][8] ? project[0][8] : 'NA';
	            	 var Gender = project[0][8] ? project[0][8] : 'NA';
                   var row = '<tr>' +
                       '<td>' + EmpName + '</td>' +
                       '<td>' + EmpId + '</td>' +
//                       '<td>' + Department + '</td>' +
//                       '<td>' + Role + '</td>' +
//                       '<td>' + Designation + '</td>' +
//                       '<td>' + Branch + '</td>' +
//                     '<td>' + prodSuite + '</td>' +
                       '<td>' + Email + '</td>' +
                       '<td>' + Mobile + '</td>' +
//                       '<td>' + Location + '</td>' +
                       '<td>' + Gender + '</td>' +

                       '</tr>';
                  $('#femaleEmpsTable tbody').append(row);
              });
          } else {
              // No data received
//              console.log("No data received");
              $('#femaleEmpsTable tbody').append('<tr><td colspan="6">No projects found</td></tr>');
          }
      },
      error: function(xhr, status, error) {
          console.error('Error fetching project data:', error);
          // Show error message in table
          $('#femaleEmpsTable tbody').empty().append('<tr><td colspan="2">Error fetching data</td></tr>');
      }
  });
  
 
}

//




function showEmployeeDetails(gender) {
//	alert("clicked");
	$('#employeeModal').modal('show');
    var modalImage = document.getElementById('modalImage');
    var modalMessage = document.getElementById('modalMessage');
    var modalOverlay = document.getElementById('modalOverlay');
    var modal = document.getElementById('employeeModal');
    
    
    if (gender === 'male') {
//        modalImage.src = "";
        modalMessage.textContent = 'We value and respect all our male employees. Thank you for your hard work and dedication.';
    } else if (gender === 'female') {
//        modalImage.src = 'path/to/female-employees-image.jpg'; 
        modalMessage.textContent = 'We value and respect all our female employees. Your contributions and achievements are greatly appreciated.';
    }

    modalOverlay.style.display = 'block';
    modal.style.display = 'block';
}

function closeModal() {
    var modalOverlay = document.getElementById('modalOverlay');
    var modal = document.getElementById('employeeModal');

    modalOverlay.style.display = 'none';
    modal.style.display = 'none';
}





$('#top3_performers').click(function(){
	$('#topPerformersModal').modal('show');
	
	
	document.getElementById("act_count1").textContent = activity_count1;
	document.getElementById("act_count2").textContent = activity_count1;
	
	document.getElementById("act_count3").textContent = activity_count2;
	document.getElementById("act_count4").textContent = activity_count2;
	
	document.getElementById("act_count5").textContent = activity_count3;
	document.getElementById("act_count6").textContent = activity_count3;
	
	
	
	document.getElementById("performer1modal").textContent = top_performer_1;
	document.getElementById("performer2modal").textContent = top_performer_2;
	document.getElementById("performer3modal").textContent = top_performer_3;
})


$('#manager_satisfaction').click(function(){
//	alert("clicked");
	
	$('#managerSatisfactionScoreModal').modal('show');
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getListOfFeedback";

    $('#spin12').show(); 

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: "taskDetails=" + taskDetails,


    }).done(function(data2) {
    	 $('#spin12').hide(); 
//    	alert("niininiii "+data2)

      $('#completedProjectsonholdTable tbody').empty();
    	
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
        	  
        	  var srNo = project[0];
              var emp_name = project[1];
              var feedback = project[2];
              var project_name = project[3];
              var ratings = project[4];
              var suggestions = project[5];
              var submitted_by = project[6];
              var submitted_date = project[7];
              var view = project[8];
              
              
              var row = '<tr>' +
              '<td>' + (srNo ? srNo : 'NA') + '</td>' +
              '<td>' + (emp_name ? emp_name : 'NA') + '</td>' +
              '<td>' + (feedback ? feedback : 'NA') + '</td>' +
              '<td>' + (project_name ? project_name : 'NA') + '</td>' +
              '<td style="color:orange">' + (ratings ? ratings : 'NA') + '</td>' +
              '<td>' + (suggestions ? suggestions : 'NA') + '</td>' +
              '<td>' + (submitted_by ? submitted_by : 'NA') + '</td>' +
              '<td>' + (submitted_date ? submitted_date : 'NA') + '</td>' +
//              '<td>' + (view ? view : 'NA') + '</td>' +
              '</tr>';
          $('#completedProjectsonholdTable tbody').append(row);
      });
          $('#sub').show();
      } else {
//          console.log("No data received");
          $('#completedProjectsonholdTable tbody').append('<tr><td colspan="9" style="text-align:center; background-color:#f0f5f5;">No Activities Found</td></tr>');
         
      }
  });
})



$('#grievance_complaints').click(function(){
//	alert("clicked");
	

//	alert("clicked");
	
	$('#grievanceandcomplaintsModal').modal('show');
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getListOfClientFeedback";

    $('#spin12').show(); 

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: "taskDetails=" + taskDetails,


    }).done(function(data2) {
    	 $('#spin12').hide(); 
//    	alert("niininiii "+data2)

      $('#grievanceandcomplaintsTable tbody').empty();
    	
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
        	  
        	  var srNo = project[0];
              var client_name = project[1];
              var project_name = project[2];
              var feedback_date = project[3];
              var feedback_type = project[4];
              var feedback_description = project[5];
              var impact = project[6];
              var status_grievance = project[7];
              var assigned_to = project[8];
              var resolution = project[9];
              var followup_date = project[10];
              var client_response = project[11];
              var submitted_by = project[12];
              var submitted_date = project[13];
//              var view = project[14];
              
              
              
              var row = '<tr>' +
              '<td>' + (srNo ? srNo : 'NA') + '</td>' +
              '<td>' + (client_name ? client_name : 'NA') + '</td>' +
              '<td>' + (project_name ? project_name : 'NA') + '</td>' +
              '<td>' + (feedback_date ? feedback_date : 'NA') + '</td>' +
              '<td style="color:orange">' + (feedback_type ? feedback_type : 'NA') + '</td>' +
              '<td>' + (feedback_description ? feedback_description : 'NA') + '</td>' +
              '<td>' + (impact ? impact : 'NA') + '</td>' +
              '<td>' + (status_grievance ? status_grievance : 'NA') + '</td>' +
              '<td>' + (assigned_to ? assigned_to : 'NA') + '</td>' +
              '<td>' + (resolution ? resolution : 'NA') + '</td>' +
              '<td>' + (followup_date ? followup_date : 'NA') + '</td>' +
              '<td>' + (client_response ? client_response : 'NA') + '</td>' +
//              '<td style="color:orange">' + (submitted_by ? submitted_by : 'NA') + '</td>' +
              '<td>' + (submitted_date ? submitted_date : 'NA') + '</td>' +
//              '<td>' + (submitted_by ? submitted_by : 'NA') + '</td>' +
//              '<td>' + (view ? view : 'NA') + '</td>' +
         
              '</tr>';
          $('#grievanceandcomplaintsTable tbody').append(row);
      });
          $('#sub').show();
      } else {
//          console.log("No data received");
          $('#grievanceandcomplaintsTable tbody').append('<tr><td colspan="15" style="text-align:center; background-color:#f0f5f5;">No Activities Found</td></tr>');
         
      }
  });

})



$("#employee_hired_this_month").click(function(){
//	alert("clicked");
	
	$('#employeeHiredModal').modal('show');
	
	var l = window.location;
    var base_url = l.protocol + "//" + l.host + "/" + l.pathname.split('/')[1];
    var serviceUrl = base_url + "/PMS/getEmployeesHiredThisMonth";

    $('#spin12').show(); 

    $.ajax({
        url: serviceUrl,
        type: 'POST',
        dataType: 'json',
//        data: "taskDetails=" + taskDetails,


    }).done(function(data2) {
    	 $('#spin12').hide(); 
//    	alert("niininiii "+data2)

      $('#employeeHiredTable tbody').empty();
    	
      if (data2 && data2.length > 0) {
          data2.forEach(function(project) {
        	  
        	  var emp_name = project[0];
              var emp_id = project[1];
              var dept = project[2];
              var designation = project[3];
              var doj = project[4];
              var experience = project[5];
              
              
               var row = '<tr>' +
              '<td>' + (emp_name ? emp_name : 'NA') + '</td>' +
              '<td>' + (emp_id ? emp_id : 'NA') + '</td>' +
              '<td>' + (dept ? dept : 'NA') + '</td>' +
              '<td>' + (designation ? designation : 'NA') + '</td>' +
              '<td style="color:orange">' + (doj ? doj : 'NA') + '</td>' +
              '<td style="color:orange">' + (experience ? experience : 'NA') + '</td>' +

              '</tr>';
          $('#employeeHiredTable tbody').append(row);
      });
          $('#sub').show();
      } else {
//          console.log("No data received");
          $('#employeeHiredTable tbody').append('<tr><td colspan="6" style="text-align:center; background-color:#f0f5f5;">No Activities Found</td></tr>');
         
      }
  });
})



