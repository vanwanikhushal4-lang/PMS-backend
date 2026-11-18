


<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Dashboard</title>
<%--  <link rel="icon" href="<%=request.getContextPath()%>/resources/dist/img/favicon.ico"> --%>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" -->
<!-- 	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" -->
<!-- 	crossorigin="anonymous" referrerpolicy="no-referrer" /> -->



<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
	
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/fas-all.min.css">
	
<!-- Ionicons -->
<!--<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">-->
<!-- Tempusdominus Bbootstrap 4 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<!--<link rel="stylesheet" href="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jqvmap.min.css">-->
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/dist/css/adminlte.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.css">
<!-- Google Font: Source Sans Pro -->
<!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">-->



<style>
#container {
	height: 400px;
}

.highcharts-figure, .highcharts-data-table table {
	min-width: 310px;
	max-width: 800px;
	margin: 1em auto;
}

.red-text {
	color: red;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #ebebeb;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}

.highcharts-data-table caption {
	padding: 1em 0;
	font-size: 1.2em;
	color: #555;
}

.highcharts-data-table th {
	font-weight: 600;
	padding: 0.5em;
}

.highcharts-data-table td, .highcharts-data-table th,
	.highcharts-data-table caption {
	padding: 0.5em;
}

.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even)
	{
	background: #f8f8f8;
}

.highcharts-data-table tr:hover {
	background: #f1f7ff;
}



/* #mayur { */
/*   width: 80%; */
/*   min-width: 300px; */
/*   margin: 0 auto; */
/*   color: #fafafa; */
/*   background-color: #202731; */
/* } */

/* .Progressbar { */
/*   position: relative; */
/*   height: 32px; */
/*   border-radius: 1000px; */
/*   background-color: #484848; */
/*   clip-path: inset(0 0 0 0 round 1000px); */
/* } */

/* .Progressbar__value { */
/*   height: 32px; */
/*   transition: width 0.4s ease-in-out; */
/*   border-radius: 1000px 0 0 1000px; */
/*   background-color: #ff4c65; */
/*   will-change: width; */
/* } */

/* .Progressbar > progress { */
/*   opacity: 0; */
/*   width: 1px; */
/*   height: 1px; */
/*   position: absolute; */
/*   pointer-events: none; */
/* } */
#containerManager {
	min-width: 310px;
	height: 300px;
	max-width: 310px;
	margin: 0 auto;
}

.red-text {
	color: red;
}

#container {
	height: 400px;
}
/* CSS for hover effect and data movement */
.table-hover tbody tr:hover {
	background-color: #f5f5f5;
}

.heading {
	transition: transform 0.3s ease-in-out;
}

.heading:hover {
	transform: translateY(-3px);
}

.highcharts-figure, .highcharts-data-table table {
	min-width: 310px;
	max-width: 800px;
	margin: 1em auto;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #ebebeb;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}

.highcharts-data-table caption {
	padding: 1em 0;
	font-size: 1.2em;
	color: #555;
}

.highcharts-data-table th {
	font-weight: 600;
	padding: 0.5em;
}

.highcharts-data-table td, .highcharts-data-table th,
	.highcharts-data-table caption {
	padding: 0.5em;
}

.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even)
	{
	background: #f8f8f8;
}

.highcharts-data-table tr:hover {
	background: #f1f7ff;
}

.table-hover tbody tr:hover {
	background-color: #f5f5f5;
}

.table tbody tr {
	transition: all 0.3s;
}




/* .table tbody tr:hover { */
/* 	position: relative; */
/* 	top: -2px; */
/* 	box-shadow: 0 2px 2px rgba(0, 0, 0, 0.1); */
/* } */
.heading-cell {
	font-weight: bold;
	color: #333;
	background-color: #f8f9fa; /* Light gray background */
	border-bottom: 2px solid #dee2e6; /* Bottom border */
	text-align: center; /* Center-align the text */
	padding: 8px 12px; /* Add padding */
}

/* Hover effect on heading cells */
.heading-cell:hover {
	background-color: #e9ecef; /* Lighter gray on hover */
}
/* Custom CSS for table beautification */
.custom-table {
	border-collapse: separate;
	border-spacing: 0 10px; /* Adjust vertical spacing between rows */
}

.custom-table th, .custom-table td {
	vertical-align: middle; /* Align content vertically center */
	border-top: none; /* Remove top border */
}

.custom-table th {
	border-bottom: 2px solid #dee2e6;
	/* Add bottom border for heading row */
}

.custom-table tbody tr {
	background-color: #f8f9fa; /* Alternate row background color */
}

.custom-table tbody tr:hover {
	background-color: #e9ecef; /* Change background color on hover */
}
/* Custom CSS for table beautification */
.custom-table {
	border-collapse: separate;
	border-spacing: 0 10px; /* Adjust vertical spacing between rows */
	background-color: #ffffff; /* Set background color to white */
}

.custom-table th, .custom-table td {
	vertical-align: middle; /* Align content vertically center */
	border-top: none; /* Remove top border */
}

.custom-table th {
	border-bottom: 2px solid #dee2e6;
	/* Add bottom border for heading row */
}

.custom-table tbody tr {
	background-color: #f8f9fa; /* Alternate row background color */
}

.custom-table tbody tr:hover {
	background-color: #e9ecef; /* Change background color on hover */
}

.highchart-container {
	width: 100%; /* Ensure the chart fills its container */
	height: 100%; /* Ensure the chart fills its container */
}

th:hover {
	cursor: pointer;
}

/* Define styles for Completed status */
.completed {
	color: green;
}

/* Define styles for On Hold status */
.on-hold {
	color: black;
}

.delayed {
	color: red;
}

.pending {
	color: blue;
}



 #TotalcompletedProjectsTableMDNNew {
            width: 100%;
            border-collapse: collapse;
}
#TotalcompletedProjectsTableMDNNew th, 
 #TotalcompletedProjectsTableMDNNew td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TotalcompletedProjectsTableMDNNew th {
            background-color: #f2f2f2;
}




.modal-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.modal-header .modal-title {
    margin-right: auto; /* Pushes the title to the left */
}

.modal-actions {
    display: flex;
    gap: 10px; /* Space between the buttons */
}



 #ProjectsOnTrackTable {
            width: 100%;
            border-collapse: collapse;
}
#ProjectsOnTrackTable th, 
 #ProjectsOnTrackTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#ProjectsOnTrackTable th {
            background-color: #f2f2f2;
}



 #TotalcompletedProjectsTableMD {
            width: 100%;
            border-collapse: collapse;
}
#TotalcompletedProjectsTableMD th, 
 #TotalcompletedProjectsTableMD td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TotalcompletedProjectsTableMD th {
            background-color: #f2f2f2;
}




 #completedProjectsModal {
            width: 100%;
            border-collapse: collapse;
}
#completedProjectsModal th, 
 #completedProjectsModal td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#completedProjectsModal th {
            background-color: #f2f2f2;
}



 #completedProjectsonholdTable {
            width: 100%;
            border-collapse: collapse;
}
#completedProjectsonholdTable th, 
 #completedProjectsonholdTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#completedProjectsonholdTable th {
            background-color: #f2f2f2;
}



 #DelayedProjectList {
            width: 100%;
            border-collapse: collapse;
}
#DelayedProjectList th, 
 #DelayedProjectList td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#DelayedProjectList th {
            background-color: #f2f2f2;
}




 #ProjectDetailsByName {
            width: 100%;
            border-collapse: collapse;
}
#ProjectDetailsByName th, 
 #ProjectDetailsByName td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#ProjectDetailsByName th {
            background-color: #f2f2f2;
}






#TotalcompletedProjectsTableMDN {
            width: 100%;
            border-collapse: collapse;
}
#TotalcompletedProjectsTableMDN th, 
 #TotalcompletedProjectsTableMDN td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TotalcompletedProjectsTableMDN th {
            background-color: #f2f2f2;
}





 #TotoprojectMGR {
            width: 100%;
            border-collapse: collapse;
}
#TotoprojectMGR th, 
 #TotoprojectMGR td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TotoprojectMGR th {
            background-color: #f2f2f2;
}




#projectcompltedMGR {
            width: 100%;
            border-collapse: collapse;
}
#projectcompltedMGR th, 
 #projectcompltedMGR td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#projectcompltedMGR th {
            background-color: #f2f2f2;
}




#projectontrackMGR {
            width: 100%;
            border-collapse: collapse;
}
#projectontrackMGR th, 
 #projectontrackMGR td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#projectontrackMGR th {
            background-color: #f2f2f2;
}



 #projectonholdMGR {
            width: 100%;
            border-collapse: collapse;
}
#projectonholdMGR th, 
 #projectonholdMGR td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#projectonholdMGR th {
            background-color: #f2f2f2;
}



 #projectdelayMGR {
            width: 100%;
            border-collapse: collapse;
}
#projectdelayMGR th, 
 #projectdelayMGR td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#projectdelayMGR th {
            background-color: #f2f2f2;
}



#PMProjectDetailsByName {
            width: 100%;
            border-collapse: collapse;
}
#PMProjectDetailsByName th, 
 #PMProjectDetailsByName td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#PMProjectDetailsByName th {
            background-color: #f2f2f2;
}




#TotalcompletedProjectsTablemgrN1 {
            width: 100%;
            border-collapse: collapse;
}
#TotalcompletedProjectsTablemgrN1 th, 
 #TotalcompletedProjectsTablemgrN1 td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TotalcompletedProjectsTablemgrN1 th {
            background-color: #f2f2f2;
}




 #TotalcompletedProjectsTable1 {
            width: 100%;
            border-collapse: collapse;
}
#TotalcompletedProjectsTable1 th, 
 #TotalcompletedProjectsTable1 td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TotalcompletedProjectsTable1 th {
            background-color: #f2f2f2;
}



 #TLProjectsOnTrackTable {
            width: 100%;
            border-collapse: collapse;
}
#TLProjectsOnTrackTable th, 
 #TLProjectsOnTrackTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TLProjectsOnTrackTable th {
            background-color: #f2f2f2;
}



#TeamLeaderTotalcompletedProjectsTable {
            width: 100%;
            border-collapse: collapse;
}
#TeamLeaderTotalcompletedProjectsTable th, 
 #TeamLeaderTotalcompletedProjectsTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TeamLeaderTotalcompletedProjectsTable th {
            background-color: #f2f2f2;
}



 #TeamLeadProjectontrackMGR {
            width: 100%;
            border-collapse: collapse;
}
#TeamLeadProjectontrackMGR th, 
 #TeamLeadProjectontrackMGR td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TeamLeadProjectontrackMGR th {
            background-color: #f2f2f2;
}



 #TeamLeaderDelayedProjectList {
            width: 100%;
            border-collapse: collapse;
}
#TeamLeaderDelayedProjectList th, 
 #TeamLeaderDelayedProjectList td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TeamLeaderDelayedProjectList th {
            background-color: #f2f2f2;
}



 #TeamLeadProjectDetailsByName {
            width: 100%;
            border-collapse: collapse;
}
#TeamLeadProjectDetailsByName th, 
 #TeamLeadProjectDetailsByName td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TeamLeadProjectDetailsByName th {
            background-color: #f2f2f2;
}




 #TeamLeadDelayedProjectTable {
            width: 100%;
            border-collapse: collapse;
}
#TeamLeadDelayedProjectTable th, 
 #TeamLeadDelayedProjectTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TeamLeadDelayedProjectTable th {
            background-color: #f2f2f2;
}




 #ProjectsTotalTableDev {
            width: 100%;
            border-collapse: collapse;
}
#ProjectsTotalTableDev th, 
 #ProjectsTotalTableDev td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#ProjectsTotalTableDev th {
            background-color: #f2f2f2;
}



 #ProjectsCompletedTableDev {
            width: 100%;
            border-collapse: collapse;
}
#ProjectsCompletedTableDev th, 
 #ProjectsCompletedTableDev td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#ProjectsCompletedTableDev th {
            background-color: #f2f2f2;
}



 #ProjectsOnTrackTableDev {
            width: 100%;
            border-collapse: collapse;
}
#ProjectsOnTrackTableDev th, 
 #ProjectsOnTrackTableDev td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#ProjectsOnTrackTableDev th {
            background-color: #f2f2f2;
}



 #ProjectsDelayTableDev {
            width: 100%;
            border-collapse: collapse;
}
#ProjectsDelayTableDev th, 
 #ProjectsDelayTableDev td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#ProjectsDelayTableDev th {
            background-color: #f2f2f2;
}



#TotalcompletedProjectsTableMDNNewMan {
            width: 100%;
            border-collapse: collapse;
}
#TotalcompletedProjectsTableMDNNewMan th, 
 #TotalcompletedProjectsTableMDNNewMan td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TotalcompletedProjectsTableMDNNewMan th {
            background-color: #f2f2f2;
}



 #DevTableDetails {
            width: 100%;
            border-collapse: collapse;
}
#DevTableDetails th, 
 #DevTableDetails td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#DevTableDetails th {
            background-color: #f2f2f2;
}




 #DevDelaysTableDetails {
            width: 100%;
            border-collapse: collapse;
}
#DevDelaysTableDetails th, 
 #DevDelaysTableDetails td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#DevDelaysTableDetails th {
            background-color: #f2f2f2;
}




#TotalOnHoldProjectsTableMDN {
            width: 100%;
            border-collapse: collapse;
}
#TotalOnHoldProjectsTableMDN th, 
 #TotalOnHoldProjectsTableMDN td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TotalOnHoldProjectsTableMDN th {
            background-color: #f2f2f2;
}





#TotalOnHoldProjectsTableMDNMan {
            width: 100%;
            border-collapse: collapse;
}
#TotalOnHoldProjectsTableMDNMan th, 
 #TotalOnHoldProjectsTableMDNMan td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#TotalOnHoldProjectsTableMDNMan th {
            background-color: #f2f2f2;
}



/*//03/09/2024*/

/* HR Dash */

* HR Dash */




/* Container for cards and chart Rohit */
/* 

.container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  padding: 20px;
  gap: 20px; 
}

.card-container {
  display: flex;
  flex-direction: column;
  flex: 1 1 250px;
}

.card {
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  padding: 20px;
  margin-bottom: 20px;
  text-align: center;
  flex: 1;
  transition: box-shadow 0.3s ease, transform 0.3s ease, background-color 0.3s ease;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.card:hover {
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
  transform: translateY(-5px);
  background-color: #f0f0f0; 
}

.card-title {
  font-size: 20px;
  font-weight: 600;
  margin-bottom: 10px;
  color: #333;
}

.card-value {
  font-size: 28px;
  font-weight: bold;
  color: #333; 
}

.chart {
  width: 100%;
  max-width: 500px;
  height: 300px;
  border: 1px solid #ddd;
  margin: 20px auto;
  border-radius: 8px; 
  transition: border-color 0.3s ease;
}

.chart:hover {
  border-color: #333; 
}

.table {
  width: 100%;
  margin-top: 20px;
}

.table th, .table td {
  text-align: left;
  padding: 12px;
  border: 1px solid #ddd;
  transition: background-color 0.3s ease;
}

.table th {
  background-color: #f0f0f0; 
  color: #333; 
  font-weight: 600;
}

.table tr:nth-child(even) {
  background-color: #f9f9f9;
  transition: background-color 0.3s ease;
}

.table tr:hover {
  background-color: #e0e0e0;
}

.bar-chart {
  display: flex;
  flex-direction: column;
  margin-top: 20px;
  margin-left: auto;
  margin-right: auto;
  width: 100%;
  max-width: 500px;
  height: 300px;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 10px;
  box-sizing: border-box;
  background-color: #f9f9f9; 
  transition: background-color 0.3s ease; 
}

.bar {
  background-color: #f08080; 
  height: 30px;
  margin-bottom: 8px;
  border-radius: 5px;
  transition: background-color 0.3s ease, height 0.3s ease;
}

.bar:hover {
  background-color: #f06292;
  height: 35px;
}

.bar-label {
  font-size: 14px;
  color: #333;
  margin-left: 10px;
  line-height: 30px;
}

}

#svgData {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 300px;
  margin-top: 20px;
}
*/


/* Shubham */
/*  .dashboard-inner-container {  */
/*   	display: flex;  */
/*    flex-wrap: wrap;  */
/*    justify-content: space-around;  */
/*    padding: 20px;  */
/*  }  */

/* .dashboard-card { */
/*   background-color: #fff; */
/*   border-radius: 5px; */
/*   box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); */
/*   padding: 20px; */
/*   margin-bottom: 20px; */
/*   width: 250px; */
/*   text-align: center; */

/* } */

/* .dashboard-card-title { */
/*   font-size: 18px; */
/*   font-weight: bold; */
/*   margin-bottom: 10px; */
/* } */

/* .dashboard-card-value { */
/*   font-size: 24px; */
/*   font-weight: bold; */
/*   color: #333; */
/* } */

/* .dashboard-chart { */
/*   width: 500px; */
/*   height: 300px; */
/*   border: 1px solid #ddd; */
/*   margin: 0 auto; */
  
/* } */

/* .table { */
/*   width: 100%; */
/*   border-collapse: collapse; */
/*   margin-top: 20px; */
/* } */

/* .table th, .table td { */
/*   text-align: left; */
/*   padding: 8px; */
/*   border: 1px solid #ddd; */
/* } */

/* .table th { */
/*   background-color: #f0f0f0; */
/* } */

/* .bar-chart { */
/*   display: flex; */
/*   flex-direction: column; */
/*   margin-top: 10px; */
/*   margin-left: 7rem; */
  
/*   width: 500px; */
/*   height: 300px; */
  
/*   justify-content: center; */
/*   align-item: center; */
/* } */

/* .bar { */
/*   background-color: #f08080; */
/*   height: 25px; */
/*   margin-bottom: 5px; */
/*   border-radius: 5px; */
/* } */

/* .bar-label { */
/*   font-size: 12px; */
/*   color: #333; */
/*   margin-left: 5px; */

/* } */


/* #task-status-card{ */

/*         width: 100%; */
/*         display: flex; */
/*     justify-content: flex-end; */
/* } */



/* #chart-svg{ */
/*         display: flex; */
/*         justify-content: center; */
/*         align-items: center; */
/* } */



/* /* EmpRoleTable */ */

/* .highcharts-figure, */
/* .highcharts-data-table table { */
/*     min-width: 310px; */
/*     max-width: 800px; */
/*     margin: 1em auto; */
/* } */

/* #dashboard-inner-container { */
/*     height: 400px; */
/* } */

/* .highcharts-data-table table { */
/*     font-family: Verdana, sans-serif; */
/*     border-collapse: collapse; */
/*     border: 1px solid #ebebeb; */
/*     margin: 10px auto; */
/*     text-align: center; */
/*     width: 100%; */
/*     max-width: 500px; */
/* } */

/* .highcharts-data-table caption { */
/*     padding: 1em 0; */
/*     font-size: 1.2em; */
/*     color: #555; */
/* } */

/* .highcharts-data-table th { */
/*     font-weight: 600; */
/*     padding: 0.5em; */
/* } */

/* .highcharts-data-table td, */
/* .highcharts-data-table th, */
/* .highcharts-data-table caption { */
/*     padding: 0.5em; */
/* } */

/* .highcharts-data-table thead tr, */
/* .highcharts-data-table tr:nth-child(even) { */
/*     background: #f8f8f8; */
/* } */

/* .highcharts-data-table tr:hover { */
/*     background: #f1f7ff; */
/* } */






/* Shubham */

 .containern { 
  display: flex; 
  flex-wrap: wrap;
  justify-content: space-around;
   padding: 20px;
   margin: auto;
} 


 .cardn { 
   background-color: #fff;
  border-radius: 5px;
   box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
   padding: 10px;
   margin-bottom: 20px; 
  margin: 15px; 
  width: 170px; 
   text-align: center;

 }
 
 
 #cardsRow{
 	margin: auto;
 }



 #empTable{ 
 	margin-top: 2rem; 
 } 

 #yesStatus{ 
 	text-align: center; 
 	margin-top: 1rem;
 	margin-bottom: -1rem;
	
 } 

 #searchBox{ 
 	margin-left: 1rem; 
 } 


 #getemployeedataforhr{ 
 	margin-left: 1rem; 
 	margin-right: 1rem; 
 	
 	width: 100%; 
   border-collapse: collapse; 
 margin-top: 20px; 
 } 

 #newEmp{ 
 	margin-left: 13rem; 
 }


.card-title {
   font-size: 18px; 
  font-weight: bold;
   margin-bottom: 10px;
}

 .card-value { 
  font-size: 24px; 
  font-weight: bold; 
/*    color: #333; */
	color: cornflowerblue;
 } 

 .chart {
   width: 500px; 
  height: 300px; 
   border: 1px solid #ddd; 
  margin: 0 auto; 
  
 } 

 /*.table { 
  width: 100%; 
   border-collapse: collapse; 
 margin-top: 20px; 
 } */

 /*.table th, .table td { 
   text-align: left; 
   padding: 8px; 
   border: 1px solid #ddd; 
 }*/
 
 
 #getemployeedataforhr th, #getemployeedataforhr td{
 	text-align: left; 
   padding: 8px; 
   border: 1px solid #ddd; 
 }

/* .table th { 
   background-color: #f0f0f0; 
 } */
 
 
 #getemployeedataforhr th{
 	background-color: #f0f0f0; 
 }

 .bar-chart { 
   display: flex;
   flex-direction: column; 
  margin-top: 10px;
   margin-left: 7rem;
  
   width: 500px; 
   height: 300px; 
  
   justify-content: center; 
   align-item: center;
 }

 .bar { 
   background-color: #f08080; 
   height: 25px; 
   margin-bottom: 5px; 
  border-radius: 5px; 
 }

 .bar-label { 
   font-size: 12px;
  color: #333; 
   margin-left: 5px; 

} 


 #latestEmp{

         width: 100%; 
       display: flex; 
    justify-content: flex-end; 
 }



 #svgData{
        display: flex;
        justify-content: center; 
         align-items: center; 
 } 



/* /* EmpRoleTable */ */

 .highcharts-figure, 
 .highcharts-data-table table { 
     min-width: 310px;
     max-width: 800px; 
     margin: 1em auto;
 } 

 #container {
     height: 400px;
 } 

 .highcharts-data-table table { 
    font-family: Verdana, sans-serif;
     border-collapse: collapse; 
     border: 1px solid #ebebeb; 
     margin: 10px auto; 
     text-align: center; 
     width: 100%; 
     max-width: 500px; 
 }

 .highcharts-data-table caption { 
     padding: 1em 0;
     font-size: 1.2em;
    color: #555; 
} 

 .highcharts-data-table th { 
     font-weight: 600; 
     padding: 0.5em; 
 }

 .highcharts-data-table td, 
 .highcharts-data-table th, 
 .highcharts-data-table caption {
     padding: 0.5em; 
 } 

 .highcharts-data-table thead tr, 
 .highcharts-data-table tr:nth-child(even) { 
    background: #f8f8f8; 
} 

 .highcharts-data-table tr:hover { 
     background: #f1f7ff; 
 } 


#rolesCard{
	margin-left: -25px;
}



/*END*/






</style>

<script>
  
  
        <%
            String role = (String) session.getAttribute("role");
            System.out.println("roleee" + role);
            
            String designation = (String) session.getAttribute("designation");
        %>
    </script>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<input type="hidden" id="role" name="role" value="<%=role%>">
	<input type="hidden" id="designation" name="designation"
		value="<%=designation%>">
	<div class="wrapper">

		<jsp:include page="/WEB-INF/views/dashboardheaderAdmin.jsp"></jsp:include>

		<jsp:include page="/WEB-INF/views/dashboardsidebar.jsp"></jsp:include>



		<div class="content-wrapper">


			<div class="wrapper" style="margin: 0 30px 0 30px; display: none;"
				id="MDdashboard">
				<div class="main">
					<div class="container-fluid p-0">

						<h1 class="h3 mt-4"></h1>
						<div class="row" >

							<div class="col-xl-7 col-xxl-5 d-flex" >
								<div class="w-100">
									<div class="row">
										<div class="col-sm-6">

											<div class="small-box bg-info">
												<div class="inner">
													<h3>
														<span id="MDTotalProjects"></span>
													</h3>

													<p>Total Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer" onclick="TotalProjectCount()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>

										</div>
										
										<!-- //16/08 -->
										<div class="col-sm-6">

											<div class="small-box bg-info">
												<div class="inner">
													<h3>
														<span id="MDTotalActivities"></span>
													</h3>

													<p>Total Activities</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer" onclick="TotalActivitiesCount()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>

										</div>

										<div class="col-sm-3">
											<div class="small-box bg-success">
												<div class="inner">
													<h3>
														<span id="MDCompletedProj"></span><sup
															style="font-size: 20px"></sup>
													</h3>

													<p style="font-size: 13px;">Completed Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-stats-bars"></i>
												</div>
												<a class="small-box-footer"
													onclick="Totalcompletedproject()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>
										</div>


										<div class="col-sm-3">
											<div class="small-box bg-secondary">
												<div class="inner">
													<h3>
														<span id="MDOnHoldProjects"></span>
													</h3>

													<p style="font-size: 14px;">Projects On Hold</p>
												</div>
												<div class="icon">
													<i class="ion ion-person-add"></i>
												</div>
												<a class="small-box-footer" onclick="Projectonhold()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
										</div>
										
										

										<!--  -->


										
										
										<div class="col-sm-3">
											<div class="small-box bg-success">
												<div class="inner">
													<h3>
														<span id="MDactivityCompleted"></span>
													</h3>

													<p style="font-size: 13px;">Activities Completed</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer"
													onclick="ActivitiesCompletedcount()">More info <i
													class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
										</div>
										
										
										
										<div class="col-sm-3">
											<div class="small-box bg-secondary">
												<div class="inner">
													<h3>
														<span id="MDactivityonhold"></span>
													</h3>

													<p style="font-size: 14px;">Activities On Hold</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer"
													onclick="ActivitiesOnHoldCount()">More info <i
													class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
										</div>
										
										
										
										<!-- //10/10 -->
<!-- 										<div class="col-sm-3"> -->
<!-- 											<div class="small-box" -->
<!-- 												style="background-color: #ffbb33; color: white;"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="MDactivity"></span> -->
<!-- 													</h3> -->

<!-- 													<p>Activities on Track</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-bag"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="ActivitiesOnTrack()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->
<!-- 										</div> -->
										
										<!--  -->
										
										<div class="col-sm-3">
											<div class="small-box"
												style="background-color: #ffbb33; color: white;">
												<div class="inner">
													<h3>
														<span id="MDTrackProjects"></span>
													</h3>

													<p style="font-size: 14px;">Projects On Track</p>
												</div>
												<div class="icon">
													<i class="ion ion-person-add"></i>
												</div>
												<a class="small-box-footer" onclick="Projectontrack()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
										</div>


										

										<div class="col-sm-3">
											<div class="small-box bg-danger">
												<div class="inner">
													<h3>
														<span id="MDDelayProj"></span>
													</h3>

													<p style="font-size: 14px;">Delayed Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-pie-graph"></i>
												</div>
												<a class="small-box-footer" onclick="TotalDelayedProject()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
										</div>




										<!-- //10/10 -->
										<div class="col-sm-3">
											<div class="small-box"
												style="background-color: #ffbb33; color: white;">
												<div class="inner">
													<h3>
														<span id="MDactivity"></span>
													</h3>

													<p style="font-size: 15px;">Activities on Track</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer" onclick="ActivitiesOnTrack()" >More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
										</div>
										
										<!--  -->


										


										


										<div class="col-sm-3">

											<div class="small-box bg-danger">
												<div class="inner">
													<h3>
														<span id="MDActivityDelay"></span>
													</h3>

													<p style="font-size: 15px;">Activities Delayed</p>
												</div>
												<div class="icon">
													<i class="ion ion-pie-graph"></i>
												</div>
												<a href="" class="small-box-footer"
													onclick="Activitiesdalayscount()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>
										</div>




									</div>
								</div>



							</div>

							<div class="col-12 col-md-5 col-xxl-3 d-flex order-2 order-xxl-3" >
								<div class="card flex-fill w-100">
									<div class="card-header" id="MDbarChartHeader" style="display: none;" >

										<h5 class="card-title mb-0">SCM</h5>
									</div>
									<div class="card-body d-flex" >

											<figure class="highcharts-figure" id="MDbarChart" style="display: none;">
												<div id="bar_containerMD">
													<span
														style="width: 5rem; height: 5rem; margin-left: 45%; display: none;"
														id="spin2"><i class="fa fa-spinner fa-spin"
														style="font-size: 33px"></i></span>
												</div>
											</figure>
											
											
										<div id="dashboardTableForHeadProjectDiv" style="width: 100%; overflow-x: auto;  display: none;" >
											<table class="table" id="dashboardTableForHeadProject" style="width: 100%; overflow-x: auto;">
											<thead>
												<tr>
													<th>PO No-<br>Customer Name</th>
													<th>PO Initiator</th>
													<th>PO Approver</th>
													<th>Plan Of<br>Action</th>
													<th>Approved By</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
										<span
														style="width: 5rem; height: 5rem; margin-left: 45%; display: none;"
														id="spin2ph"><i class="fa fa-spinner fa-spin"
														style="font-size: 33px"></i></span>
										</div>

										</div>
									</div>
								</div>
								
								
								

								
								
								
								
							</div>

						<br>


						<div class="modal fade" id="MDMODAL" tabindex="-1" role="dialog"
							aria-labelledby="MDMODALLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg" role="document"
								style="margin-left: 14%;">
								<div class="modal-content" style="width: 135%;">
									<div class="modal-header">
										<h5 class="modal-title" id="TotalActivitiesDelayedModalLabel">Activities
											On Track</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body" id="taskAssignModal">

										<div class="col-md-12">
											<div class="row">
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="ActprojectName">Project Name:</label> <select
														id="ActprojectName" class="form-control" tabindex="1"
														data-toggle="tooltip" name="ActprojectName"
														onchange="ActproductsuiteDetails(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="Actprodmgr">Product Manager:</label> <select
														id="Actprodmgr" class="form-control" tabindex="1"
														data-toggle="tooltip" name="Actprodmgr"
														onchange="ActproductmangerDetails(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-3" style="margin-top: 10px;">
													<label for="ActteamLeaderName">Team Leader Name:</label> <select
														id="ActteamLeaderName" class="form-control" tabindex="1"
														data-toggle="tooltip" name="ActteamLeaderName"
														onchange="ActteamLeaderDetails(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="ActFname">Function Name:</label> <select
														id="ActFname" class="form-control" tabindex="1"
														data-toggle="tooltip" name="ActFname"
														onchange="Acttoalldatafeatch(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												
												
												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDD" name="resetDD"
													data-style="expand-left" onclick="resetAllDD()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>
										<br>

										<table class="table" id="ProjectDetailsByName">
											<thead>
												<tr>
													<th>Customer Name</th>
													<th>Product Manager</th>
													<th>Product Suite</th>
													<th>Product tool</th>
													<th>Function name</th>
													<th>Activities</th>
													<th>Team Leader Name</th>
													<th>Assign To</th>
													<th>Task End Date</th>
												</tr>
											</thead>
											<tbody>
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal" onclick="reload()">Close</button>
									</div>
								</div>
							</div>
						</div>



						<!-- Modal -->
						<div class="modal fade" id="completedProjectsModal" tabindex="-1"
							role="dialog" aria-labelledby="completedProjectsModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content" style="width: 150%">
									<div class="modal-header">
										<h5 class="modal-title" id="completedProjectsModalLabel">Projects
											On Track</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
									
									<!-- //22/08 -->
									
									<div class="col-md-12">
											<div class="row">
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="projectNamesNTrack">Project Name:</label> <select
														id="projectNamesNTrack" class="form-control" tabindex="1"
														data-toggle="tooltip" name="projectNamesNTrack"
														onchange="CompletedManagerListDetTrack(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="prodmgrNTrack">Product Suite:</label> <select
														id="prodmgrNTrack" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodmgrNTrack"
														onchange="CompletedTLListDetTrack(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-3" style="margin-top: 10px;">
													<label for="teamLeaderNameNTrack">Product Tool:</label> <select
														id="teamLeaderNameNTrack" class="form-control" tabindex="1"
														data-toggle="tooltip" name="teamLeaderNameNTrack"
														onchange="CompletedFunctionListDetTrack(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="FnameNTrack">Manager Name:</label> <select
														id="FnameNTrack" class="form-control" tabindex="1"
														data-toggle="tooltip" name="FnameNTrack"
														onchange="CompletedDetailsBasedOnAllTrack(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDDN" name="resetDDNTrack"
													data-style="expand-left" onclick="resetAllDDNTrack()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>
										<br>
									
									

									
									<!--  -->
									
									
									
										<!-- Table to display completed projects -->
										<table class="table" id="completedProjectsTable">
											<thead>
												<tr>
													<th>Project Name</th>
													<th>Product Suite</th>
													<th>Product Tool</th>
													<th>Completion Date</th>
													<th>Manager Name</th>
													<th>Project Status</th>
													<!-- Add more columns as needed -->
												</tr>
											</thead>
											<tbody>
												<!-- Completed projects will be dynamically added here -->
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
						
						
						
						<!-- Modal onhold -->
						<div class="modal fade" id="completedProjectsonholdModal" tabindex="-1"
							role="dialog" aria-labelledby="completedProjectsonholdModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content" style="width: 150%">
									<div class="modal-header">
										<h5 class="modal-title" id="completedProjectsonholdModalLabel">Projects
											On Hold</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
									<div class="col-md-12">
											<div class="row">
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="onHoldprojectNames">Project Name:</label> <select
														id="onHoldprojectNames" class="form-control" tabindex="1"
														data-toggle="tooltip" name="onHoldprojectNames"
														onchange="getproductSuiteonHold();">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="prodSuiteonhldproject">Product Suite:</label> <select
														id="prodSuiteonhldproject" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodSuiteonhldproject" onchange="getproductSuiteOnHoldproj();">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-2" style="margin-top: 10px;">
													<label for="productToolonHoldProj">Product Tool:</label> <select
														id="productToolonHoldProj" class="form-control" tabindex="1"
														data-toggle="tooltip" name="productToolonHoldProj" onchange="getmanageronHoldProj();">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="managerNameonHold">Manager Name:</label> <select
														id="managerNameonHold" class="form-control" tabindex="1"
														data-toggle="tooltip" name="managerNameonHold" onchange="getManagerOnHoldProj();"
														>
														<option value="">--Please Select --</option>
													</select>
												</div>
												

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDD" name="resetDD"
													data-style="expand-left" onclick="resetAllOnHoldProject()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>
									
									
									
									<br>
										<!-- Table to display completed projects -->
										<table class="table" id="completedProjectsonholdTable">
											<thead>
												<tr>
													<th>Project Name</th>
													<th>Product Suite</th>
													<th>Product Tool</th>
													<th>Completion Date</th>
													<th>Manager Name</th>
													<th>Project Status</th>
													<!-- Add more columns as needed -->
												</tr>
											</thead>
											<tbody>
												<!-- Completed projects will be dynamically added here -->
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
						
						
						

						<!-- Modal -->
						<div class="modal fade" id="TotalcompletedProjectsModal"
							tabindex="-1" role="dialog"
							aria-labelledby="TotalcompletedProjectsModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content" style="width: 150%">
									<div class="modal-header">
										<h5 class="modal-title" id="TotalcompletedProjectsModalLabel">Completed
											Projects</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close" onclick="reload()">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									<div class="col-md-12">
											<div class="row">
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="CompleteprojectNames">Project Name:</label> <select
														id="CompleteprojectNames" class="form-control" tabindex="1"
														data-toggle="tooltip" name="CompleteprojectNames"
														onchange="getproductSuiteCmple();">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="prodSuitecmplteproject">Product Suite:</label> <select
														id="prodSuitecmplteproject" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodSuitecmplteproject" onchange="getproductSuitecmpltproj();">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-2" style="margin-top: 10px;">
													<label for="productToolCmpltProj">Product Tool:</label> <select
														id="productToolCmpltProj" class="form-control" tabindex="1"
														data-toggle="tooltip" name="productToolCmpltProj" onchange="getmanagerCmplProj();">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="managerNameCmplt">Manager Name:</label> <select
														id="managerNameCmplt" class="form-control" tabindex="1"
														data-toggle="tooltip" name="managerNameCmplt" onchange="getManagerCmplteProj();"
														>
														<option value="">--Please Select --</option>
													</select>
												</div>
												

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDD" name="resetDD"
													data-style="expand-left" onclick="resetAllCmplteProject()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>
									
									<br>
										<!-- Table to display completed projects -->
										<table class="table" id="TotalcompletedProjectsTableMD">
											<thead>
												<tr>
													<th>Project Name</th>
													<th>Product Suite</th>
													<th>Product Tool</th>
													<th>Completion Date</th>
													<th>Manager Name</th>
													<th>Project Status</th>

													<!-- Add more columns as needed -->
												</tr>
											</thead>
											<tbody>
												<!-- Completed projects will be dynamically added here -->
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>


						<div class="modal fade" id="ProjectsOnTrackMDModal" tabindex="-1"
							role="dialog" aria-labelledby="ProjectsOnTrackMDModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content" style="width: 150%">
									<div class="modal-header">
										<h5 class="modal-title" id="TotalcompletedProjectsModalLabel">Total
											Projects Details</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>


									<div class="modal-body">
									
									<div class="col-md-12">
											<div class="row">
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="totalprojectNames">Project Name:</label> <select
														id="totalprojectNames" class="form-control" tabindex="1"
														data-toggle="tooltip" name="totalprojectNames"
														onchange="totalprojectDetails();">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="prodSuiteTotalProj">Product Suite:</label> <select
														id="prodSuiteTotalProj" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodSuiteTotalProj" onchange="getProductSuitebyTool();">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-2" style="margin-top: 10px;">
													<label for="productToolTotProj">Product Tool:</label> <select
														id="productToolTotProj" class="form-control" tabindex="1"
														data-toggle="tooltip" name="productToolTotProj" onchange="getManagerByPTool();">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="managerNametotalproj">Manager Name:</label> <select
														id="managerNametotalproj" class="form-control" tabindex="1"
														data-toggle="tooltip" name="managerName" onchange="getProjectStatus();"
														>
														<option value="">--Please Select --</option>
													</select>
												</div>
												
												
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="statusTotProj">Status:</label> <select
														id="statusTotProj" class="form-control" tabindex="1"
														data-toggle="tooltip" name="statusTotProj" onchange="getprojectStatusTotal();"
														>
														<option value="">--Please Select --</option>
													</select>
												</div>

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDD" name="resetDD"
													data-style="expand-left" onclick="resetAllTotalProject()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>
								
									<br>
									
										<!-- Table to display completed projects -->
										<table class="table" id="ProjectsOnTrackTable">
											<thead>
												<tr>
													<th>Project Name</th>
													<th>Product Suite</th>
													<th>Product Tool</th>
													<th>Completion Date</th>
													<th>Manager Name</th>
													<th>Project Status</th>

													<!-- Add more columns as needed -->
												</tr>
											</thead>
											<tbody>
												<!-- Completed projects will be dynamically added here -->
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>

						<!-- Modal -->
						<div class="modal fade" id="TotalActivitiesDelayedModal"
							tabindex="-1" role="dialog" aria-labelledby="MDMODALLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
								style="margin-top: 3%; margin-left: 15%;">
								<div class="modal-content" style="width: 220%;">
									<div class="modal-header">
										<h5 class="modal-title" id="TotalActivitiesDelayedModalLabel"
											style="color: red;">Delayed Activities</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">

										<div class="col-md-12">
											<div class="row">
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="projectNames">Project Name:</label> <select
														id="projectNames" class="form-control" tabindex="1"
														data-toggle="tooltip" name="projectNames"
														onchange="productsuiteDetails(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="prodmgr">Product Manager:</label> <select
														id="prodmgr" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodmgr"
														onchange="productmangerDetails(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-3" style="margin-top: 10px;">
													<label for="teamLeaderName">Team Leader Name:</label> <select
														id="teamLeaderName" class="form-control" tabindex="1"
														data-toggle="tooltip" name="teamLeaderName"
														onchange="teamLeaderDetails(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="Fname">Function Name:</label> <select
														id="Fname" class="form-control" tabindex="1"
														data-toggle="tooltip" name="Fname"
														onchange="toalldatafeatch(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDD" name="resetDD"
													data-style="expand-left" onclick="resetAllDD()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>


										<div class="modal-body">
											<!-- Table to display completed projects -->
											<table class="table" id="TotalcompletedProjectsTableMD">
												<thead>
													<tr>
														<th>Customer Name</th>
														<th>Product Manager</th>
														<th>Product Suite</th>
														<th>Product tool</th>
														<th>Function name</th>
														<th>Activities</th>
														<th>Team Leader Name</th>
														<th>Assigned To</th>
														<th>Task End Date</th>
														<th>Delayed Days</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						
						
						
						<!-- //18/06 -->
						<!-- Modal -->
						<div class="modal fade" id="TotalActivitiesCompletedModal"
							tabindex="-1" role="dialog" aria-labelledby="MDMODALLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
								style="margin-top: 3%; margin-left: 9%;">
								<div class="modal-content" style="width: 230%;">
									<div class="modal-header">
										<h5 class="modal-title" id="TotalActivitiesCompletedModalLabel"
											style="color: red;">Completed Activities</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">

										<div class="col-md-12">
											<div class="row">
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="projectNamesN">Project Name:</label> <select
														id="projectNamesN" class="form-control" tabindex="1"
														data-toggle="tooltip" name="projectNamesN"
														onchange="CompletedManagerListDet(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="prodmgrN">Product Manager:</label> <select
														id="prodmgrN" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodmgrN"
														onchange="CompletedTLListDet(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-3" style="margin-top: 10px;">
													<label for="teamLeaderNameN">Team Leader Name:</label> <select
														id="teamLeaderNameN" class="form-control" tabindex="1"
														data-toggle="tooltip" name="teamLeaderNameN"
														onchange="CompletedFunctionListDet(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="FnameN">Function Name:</label> <select
														id="FnameN" class="form-control" tabindex="1"
														data-toggle="tooltip" name="FnameN"
														onchange="CompletedDetailsBasedOnAll(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDDN" name="resetDDN"
													data-style="expand-left" onclick="resetAllDDN()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>


										<div class="modal-body">
											<!-- Table to display completed projects -->
											<table class="table" id="TotalcompletedProjectsTableMDN">
												<thead>
													<tr>
														<th>Customer Name</th>
														<th>Product Manager</th>
														<th>Product Suite</th>
														<th>Product tool</th>
														<th>Function name</th>
														<th>Activities</th>
														<th>Team Leader Name</th>
														<th>Assigned To</th>
														<th>Task End Date</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--  -->
						
						
						
						
						
						
						
						<!-- //10/10 -->
						<!-- Modal -->
						<div class="modal fade" id="TotalActivitiesOnHoldModal"
							tabindex="-1" role="dialog" aria-labelledby="MDMODALLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
								style="margin-top: 3%; margin-left: 9%;">
								<div class="modal-content" style="width: 230%;">
									<div class="modal-header">
										<h5 class="modal-title" id="TotalActivitiesOnHoldModalLabel"
											style="color: red;">Activities On Hold</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">

										<div class="col-md-12">
											<div class="row">
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="projectNamesNOH">Project Name:</label> <select
														id="projectNamesNOH" class="form-control" tabindex="1"
														data-toggle="tooltip" name="projectNamesNOH"
														onchange="OnHoldManagerListDet(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="prodmgrNOH">Product Manager:</label> <select
														id="prodmgrNOH" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodmgrNOH"
														onchange="OnHoldTLListDet(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-3" style="margin-top: 10px;">
													<label for="teamLeaderNameNOH">Team Leader Name:</label> <select
														id="teamLeaderNameNOH" class="form-control" tabindex="1"
														data-toggle="tooltip" name="teamLeaderNameNOH"
														onchange="OnHoldFunctionListDet(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="FnameNOH">Function Name:</label> <select
														id="FnameNOH" class="form-control" tabindex="1"
														data-toggle="tooltip" name="FnameNOH"
														onchange="OnHoldDetailsBasedOnAll(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDDNOH" name="resetDDNOH"
													data-style="expand-left" onclick="resetAllDDNOH()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>


										<div class="modal-body">
											<!-- Table to display completed projects -->
											<table class="table" id="TotalOnHoldProjectsTableMDN">
												<thead>
													<tr>
														<th>Customer Name</th>
														<th>Product Manager</th>
														<th>Product Suite</th>
														<th>Product tool</th>
														<th>Function name</th>
														<th>Activities</th>
														<th>Team Leader Name</th>
														<th>Assigned To</th>
														<th>Task End Date</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--  -->
						
						
						
						
						
						
						
						
						<!-- //16/08 -->
						<!-- Modal -->
						<div class="modal fade" id="TotalActivitiesCompletedModalNew"
							tabindex="-1" role="dialog" aria-labelledby="MDMODALLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
								style="margin-top: 3%; margin-left: 4%;">
								<div class="modal-content" style="width: 250%;">
				
<!-- 									<div class="modal-header"> -->
<!-- 										<h5 class="modal-title" id="TotalActivitiesCompletedModalLabelNew" -->
<!-- 											style="color: red;">Total Activities</h5> -->
<!-- 										<button type="button" class="close" data-dismiss="modal" -->
<!-- 											aria-label="Close"> -->
<!-- 											<span aria-hidden="true">&times;</span> -->
<!-- 										</button> -->
<!-- 									</div> -->

									<!-- //20/08 -->
									<div class="modal-header">
    									<h5 class="modal-title" id="TotalActivitiesCompletedModalLabelNew" style="color: red;">Total Activities</h5>
    									
    									<div class="modal-actions" style="margin-left: 66%">
        									<button type="button" class="btn btn-primary" id="exportExcel">Export to Excel</button>
        									<button type="button" class="btn btn-primary" id="exportPDF">Export to PDF</button>
    									</div>
    									
    									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
        									<span aria-hidden="true">&times;</span>
    									</button>
									</div>
									<!--  -->
									
									
								

									
									<div class="modal-body">
									
									
<!-- 									 <input type="text" id="searchBoxProjects" placeholder="Search" class="form-control" style="width: 10%"> -->

										<div class="col-md-12">
											<div class="row">
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="projectNamesNNew">Project Name:</label> <select
														id="projectNamesNNew" class="form-control" tabindex="1"
														data-toggle="tooltip" name="projectNamesNNew"
														onchange="CompletedManagerListDetNew(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="prodmgrNNew">Product Manager:</label> <select
														id="prodmgrNNew" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodmgrNNew"
														onchange="CompletedTLListDetNew(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="pToolTotAct">Product Tool:</label> <select
														id="pToolTotAct" class="form-control" tabindex="1"
														data-toggle="tooltip" name="pToolTotAct"
														onchange="ProductToolTotAct(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												
												

												<div class="col-md-2" style="margin-top: 10px;">
													<label for="teamLeaderNameNNew">Team Leader Name:</label> <select
														id="teamLeaderNameNNew" class="form-control" tabindex="1"
														data-toggle="tooltip" name="teamLeaderNameNNew"
														onchange="CompletedFunctionListDetNew(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>


												<div class="col-md-2" style="margin-top: 10px;">
													<label for="FnameNNew">Function Name:</label> <select
														id="FnameNNew" class="form-control" tabindex="1"
														data-toggle="tooltip" name="FnameNNew"
														onchange="statusChanged(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												
												
												<div class="col-md-1" style="margin-top: 10px;">
													<label for="FnameNNewStatus">Status:</label> <select
														id="FnameNNewStatus" class="form-control" tabindex="1"
														data-toggle="tooltip" name="FnameNNewStatus"
														onchange="CompletedDetailsBasedOnAllNew(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDDNNew" name="resetDDNNew"
													data-style="expand-left" onclick="resetAllDDNNew()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>


										<div class="modal-body">
											<!-- Table to display completed projects -->
											<table class="table" id="TotalcompletedProjectsTableMDNNew">
												<thead>
													<tr>
														<th>Customer Name</th>
														<th>Product Manager</th>
														<th>Product Suite</th>
														<th>Product tool</th>
														<th>Function name</th>
														<th>Activities</th>
														<th>Team Leader Name</th>
														<th>Assigned To</th>
														<th>Completion Date / Task End Date</th>
														<th>Status</th>
														<th>Date Revised Count</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
											<span
													style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
													id="spinProject"><i class="fa fa-spinner fa-spin"
													style="font-size: 33px"></i></span>
											
										</div>
<!-- 										<div class="modal-footer"> -->
<!-- 											<button type="button" class="btn btn-secondary" -->
<!-- 												data-dismiss="modal">Close</button> -->
												
<!-- 											 <button type="button" class="btn btn-primary" id="exportExcel">Export to Excel</button> -->
<!--                 							<button type="button" class="btn btn-primary" id="exportPDF">Export to PDF</button> -->
<!-- 										</div> -->
									</div>
								</div>
							</div>
						</div>
						<!--  -->
						
						
						
						
						
						
						
						
						
						


						<!-- Modal -->
						<div class="modal fade" id="MDDelayProjectMODAL" tabindex="-1"
							role="dialog" aria-labelledby="MDDelayProjectMODALLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document" >
								<div class="modal-content" style="width: 160%;">
									<div class="modal-header">
										<h5 class="modal-title" id="TotalActivitiesDelayedModalLabel">Delayed
											Projects</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
										<div class="col-md-12">
											<div class="row">
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="DelayprojectNames">Project Name:</label> <select
														id="DelayprojectNames" class="form-control" tabindex="1"
														data-toggle="tooltip" name="DelayprojectNames"
														onchange="getListByProjects()">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="prodSuiteDelayproject">Product Suite:</label> <select
														id="prodSuiteDelayproject" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodSuiteDelayproject" onchange="getDelayProjectsBySuite()">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-3" style="margin-top: 10px;">
													<label for="productToolDelayProj">Product Tool:</label> <select
														id="productToolDelayProj" class="form-control" tabindex="1"
														data-toggle="tooltip" name="productToolDelayProj" onchange="getDelayProjByTool()">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="managerNameDelay">Manager Name:</label> <select
														id="managerNameDelay" class="form-control" tabindex="1"
														data-toggle="tooltip" name="managerNameDelay" onchange="getDelayProjByManager()"
														>
														<option value="">--Please Select --</option>
													</select>
												</div>
												

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDDofDelay" name="resetDDofDelay"
													data-style="expand-left" onclick="resetAllDelayProjects()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>
									
									<br>
									
										<!-- Table to display completed projects -->
										<table class="table" id="DelayedProjectList">
											<thead>
												<tr>
													<th>Project Name</th>
													<th>Product Suite</th>
													<th>Product Tool</th>
													<th>Project Target Date</th>
													<th>Manager Name</th>
													<th>Status</th>
													<!-- Add more columns as needed -->
												</tr>
											</thead>
											<tbody>
												<!-- Completed projects will be dynamically added here -->
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
						
						
						
						
						
						
						


						<!-- 						MD MODAL WHEN CLICK ON TOTAL PROJECT              -->




						<div class="row" id="mdTotalProject">

							<div class="col-12 col-lg-12 col-xxl-9 d-flex">
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0">Latest Projects</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">

											<div class="row">
												<div class="col-md-4"></div>
												<div class="col-md-4">
													<label for="">Select Manager Name :</label> <select
														id="managerName" class="form-control"
														data-toogle="tooltip" name="managerName"
														onchange="getDetailsByManagerName(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-4" style="margin-top: 30px;">
													&nbsp;&nbsp;&nbsp;&nbsp;<label> <input type="radio"
														name="Mtable" value="progress" checked
														onclick="checkRadioButton()"> Progress Table
														&nbsp;&nbsp;&nbsp;&nbsp;
													</label> <label> <input type="radio" name="Mtable"
														value="tasks" onclick="checkRadioButton()"> Task
														Table
													</label>
												</div>

											</div>

											<div id="AllDetailsOfProjects">
												<table class="table table1 table-striped"
													id="ProjectDetails" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Completion<br> in %&nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target Date<br> Of Completion&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Manager<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Development&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>&nbsp;&nbsp;Testing&nbsp;&nbsp;&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>&nbsp;&nbsp;&nbsp;&nbsp;POC&nbsp;&nbsp;&nbsp;&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>&nbsp;&nbsp;&nbsp;&nbsp;UAT&nbsp;&nbsp;&nbsp;&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>Implementation&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>&nbsp;&nbsp;Go Live&nbsp;&nbsp;&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>
												</table>
												<span
													style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
													id="spin11"><i class="fa fa-spinner fa-spin"
													style="font-size: 33px"></i></span>
											</div>


											<div id="AllDetailsOfProjectsProgress" style="display: none;">
												<table class="table table1 table-striped"
													id="ProjectDetailsAll" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Completion<br> in %&nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target Date<br> Of Completion&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Manager<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Development&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Testing&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>POC&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>UAT&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>Implementation&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Go Live&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>
												</table>
												<!-- 												<span -->
												<!-- 													style="width: 5rem; height: 5rem; margin-left: 50% display: none;" -->
												<!-- 													id="spin14"><i class="fa fa-spinner fa-spin" -->
												<!-- 													style="font-size: 33px"></i></span> -->
											</div>


											<div id="AllDetailsOfProjectsByManager"
												style="display: none;">
												<table class="table table1 table-striped"
													id="ProjectDetailsManager2" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Target<br> Date<br> Of Completion
																&nbsp;<i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i>
															</th>

															<th>Total<br> Tasks &nbsp;&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Completed<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Delay<br>Tasks &nbsp;&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>

												</table>
												<!-- 												<span -->
												<!-- 													style="width: 5rem; height: 5rem; margin-left: 50%; display: none;" -->
												<!-- 													id="spin12"><i class="fa fa-spinner fa-spin" -->
												<!-- 													style="font-size: 33px"></i></span> -->
											</div>


										</div>

									</div>
								</div>
							</div>






						</div>
					</div>
				</div>
			</div>



<!-- 		Collection Manager  -->

<div class="wrapper" style="margin: 0 30px 0 30px; display: none;"
				id="CollectionManagerDash">
				<div class="main">
					<div class="container-fluid p-0">

						<h1 class="h3 mt-4"></h1>
					
						<br>


						<div class="row" id="CMTotalProjectStatus">

							<div class="col-12 col-lg-12 col-xxl-9 d-flex">
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0">Latest Projects</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">

<!-- 											<div class="row"> -->
<!-- 												<div class="col-md-4"></div> -->
<!-- 												<div class="col-md-4"> -->
<!-- 													<label for="">Select Manager Name :</label> <select -->
<!-- 														id="managerName" class="form-control" -->
<!-- 														data-toogle="tooltip" name="managerName" -->
<!-- 														onchange="getDetailsByManagerName(this.value)"> -->
<!-- 														<option value="">--Please Select --</option> -->
<!-- 													</select> -->
<!-- 												</div> -->

<!-- 												<div class="col-md-4" style="margin-top: 30px;"> -->
<!-- 													&nbsp;&nbsp;&nbsp;&nbsp;<label> <input type="radio" -->
<!-- 														name="Mtable" value="progress" checked -->
<!-- 														onclick="checkRadioButton()"> Progress Table -->
<!-- 														&nbsp;&nbsp;&nbsp;&nbsp; -->
<!-- 													</label> <label> <input type="radio" name="Mtable" -->
<!-- 														value="tasks" onclick="checkRadioButton()"> Task -->
<!-- 														Table -->
<!-- 													</label> -->
<!-- 												</div> -->

<!-- 											</div> -->

											<div id="AllDetailsOfProjects">
												<table class="table table1 table-striped"
													id="ProjectDetailsCM" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Completion<br> in %&nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target Date<br> Of Completion&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Manager<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Development&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>&nbsp;&nbsp;Testing&nbsp;&nbsp;&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>&nbsp;&nbsp;&nbsp;&nbsp;POC&nbsp;&nbsp;&nbsp;&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>&nbsp;&nbsp;&nbsp;&nbsp;UAT&nbsp;&nbsp;&nbsp;&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>Implementation&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>&nbsp;&nbsp;Go Live&nbsp;&nbsp;&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>
												</table>
												<span
													style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
													id="spin11"><i class="fa fa-spinner fa-spin"
													style="font-size: 33px"></i></span>
											</div>


											


										


										</div>

									</div>
								</div>
							</div>






					
						</div>
					</div>
				</div>
			</div>



			<!-- /////?//			DEVELOPER DASHBOARD     /////// -->


			<div class="wrapper" style="margin: 0 30px 0 30px; display: none;"
				id="DeveloperDashboard">
				<div class="main">
					<div class="container-fluid p-0">

						<h1 class="h3 mt-4"></h1>
						<div class="row">
							<div class="col-xl-6 col-xxl-5 d-flex">
								<div class="w-100">
									<div class="row">
										<div class="col-sm-6">

											<div class="small-box bg-info">
												<div class="inner">
													<h3>
														<span id="DevTotalProjects"></span>
													</h3>

													<p>Total Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer" onclick="getDevTotalProject()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>

											<div class="small-box bg-warning">
												<div class="inner">
													<h3>
														<span id="DevTrackProjects">
													</h3>
													<p>Projects On Track</p>
												</div>
												<div class="icon">
													<i class="ion ion-person-add"></i>
												</div>
												<a  class="small-box-footer" onclick="getDevOnTrackProject()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>

											<div class="small-box bg-primary">
												<div class="inner">
													<h3>
														<span id="Devactivity"></span>
													</h3>
													<p>Activities on Track</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer" onclick="getDeveloperOnTrack()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>
										</div>


										<div class="col-sm-6">
											<div class="small-box bg-success">
												<div class="inner">
													<h3>
														<span id="DevCompletedProj"></span><sup
															style="font-size: 20px"></sup>
													</h3>

													<p>Completed Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-stats-bars"></i>
												</div>
												<a class="small-box-footer" onclick="getDevCompletedProject()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>

											<div class="small-box bg-danger">
												<div class="inner">
													<h3>
														<span id="DevDelayProj"></span>
													</h3>

													<p>Delayed Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-pie-graph"></i>
												</div>
												<a class="small-box-footer" onclick="getDevDelayProject()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>

											<div class="small-box bg-secondary">
												<div class="inner">
													<h3>
														<span id="DevActivityDelay"></span>
													</h3>

													<p>Activities Delayed</p>
												</div>
												<div class="icon">
													<i class="ion ion-pie-graph"></i>
												</div>
												<a  class="small-box-footer" onclick="DevActivitiesdalaysDetails()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col-12 col-md-6 col-xxl-3 d-flex order-2 order-xxl-3">
								<div class="card flex-fill w-100" style="height: 460px;">
									<div class="card-header">

										<h5 class="card-title mb-0">Task</h5>
									</div>
									<div class="card-body d-flex">
										<div class="align-self-center w-100">
											<figure class="highcharts-figure">
												<div id="DevContainer">
													<span
														style="width: 5rem; height: 5rem; margin-left: 230px; display: none;"
														id="spin1"><i class="fa fa-spinner fa-spin"
														style="font-size: 33px"></i></span>
												</div>

											</figure>
											<!-- 												</div> -->
											<!-- 											</div> -->
										</div>
									</div>
								</div>
							</div>

						</div>
						<br>



						<div class="row" id="developerteambothtables">

							<div class="col-12 col-lg-12 col-xxl-9 d-flex">
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0">Latest Projects</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">
											<div class="row">
												<div class="col-md-4"></div>
												<div class="col-md-4" style="margin-top: 30px;">
													&nbsp;&nbsp;&nbsp;&nbsp;<label> <input type="radio"
														name="DevTaskTable" value="progress" checked
														onclick="checkRadioButtonDev()"> Progress Table
														&nbsp;&nbsp;&nbsp;&nbsp;
													</label> <label> <input type="radio" name="DevTaskTable"
														value="tasks" onclick="checkRadioButtonDev()">
														Task Table
													</label>
												</div>
											</div>

											<div id="ProjectDetailsDevDiv">
												<table class="table table1 table-striped"
													id="ProjectDetailsDev" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Completion<br> in %&nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target Date<br> Of Completion&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Manager<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Development&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Testing&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>POC&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>UAT&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>Implementation&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Go Live&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>
												</table>
												<!-- 												<span -->
												<!-- 													style="width: 5rem; height: 5rem; margin-left: 50% display: none;" -->
												<!-- 													id="spin14"><i class="fa fa-spinner fa-spin" -->
												<!-- 													style="font-size: 33px"></i></span> -->
											</div>



											<div id="ProjectDetailsDevTaskDiv" style="display: none;">
												<table class="table table1 table-striped"
													id="ProjectDetailsDevTask" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Activity&nbsp;<i class="fa-solid fa-sort" -->
															<!-- 															style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->

															<th>Target<br> Date &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Total<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Completed<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Delayed<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
														</tr>
													</thead>
												</table>

											</div>



										</div>
									</div>
								</div>
							</div>


							<!-- 							<div class="col-12 col-lg-3 col-xxl-3 d-flex"> -->
							<!-- 								<div class="card flex-fill w-100"> -->
							<!-- 									<div class="card-header"> -->
							<!-- 										<h5 class="card-title mb-0">Projects Assigned to Me</h5> -->
							<!-- 									</div> -->
							<!-- 									<div class="card-body d-flex justify-content-center"> -->
							<!-- 										Added justify-content-center -->
							<!-- 										<div class="align-self-center" style="width: 100%;"> -->
							<!-- 											<div class="py-3"> -->
							<!-- 												<div class="chart chart-xs" -->
							<!-- 													style="width: 100%; overflow: hidden;"> -->
							<!-- 													<div id="containerDeveloper" class="highchart-container" -->
							<!-- 														style="width: 100%;"></div> -->
							<!-- 												</div> -->
							<!-- 												<table class="table mb-0" -->
							<!-- 													style="height: 100px; overflow-y: auto;"> -->
							<!-- 												</table> -->
							<!-- 											</div> -->
							<!-- 										</div> -->
							<!-- 									</div> -->
							<!-- 								</div> -->
							<!-- 							</div> -->


						</div>
						
						
						
						
						
						<!-- //13/08 -->
						<div class="row" id="supportteambothtables">

							<div class="col-12 col-lg-12 col-xxl-9 d-flex">
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0">Latest Projects</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">
											<div class="row">
												<div class="col-md-4"></div>
												<div class="col-md-4" style="margin-top: 30px;">
													&nbsp;&nbsp;&nbsp;&nbsp;<label> <input type="radio"
														name="supportTaskTable" value="progress" checked
														onclick="checkRadioButtonSupportTeam()"> Progress Table
														&nbsp;&nbsp;&nbsp;&nbsp;
													</label> <label> <input type="radio" name="supportTaskTable"
														value="tasks" onclick="checkRadioButtonSupportTeam()">
														Task Table
													</label>
												</div>
											</div>

											<div id="ProjectDetailsDevDivsupportteam">
												<table class="table table1 table-striped"
													id="ProjectDetailssupportteam" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Completion<br> in %&nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target Date<br> Of Completion&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Manager<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															
												
															<th>POC&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>UAT&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>Implementation&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Go Live&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>
												</table>
												<!-- 												<span -->
												<!-- 													style="width: 5rem; height: 5rem; margin-left: 50% display: none;" -->
												<!-- 													id="spin14"><i class="fa fa-spinner fa-spin" -->
												<!-- 													style="font-size: 33px"></i></span> -->
											</div>



											<div id="ProjectDetailsDevTaskDivsupportteam" style="display: none;">
												<table class="table table1 table-striped"
													id="ProjectDetailsDevTasksupportteam" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Activity&nbsp;<i class="fa-solid fa-sort" -->
															<!-- 															style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->

															<th>Target<br> Date &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Total<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Completed<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Delayed<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
														</tr>
													</thead>
												</table>

											</div>



										</div>
									</div>
								</div>
							</div>


							<!-- 							<div class="col-12 col-lg-3 col-xxl-3 d-flex"> -->
							<!-- 								<div class="card flex-fill w-100"> -->
							<!-- 									<div class="card-header"> -->
							<!-- 										<h5 class="card-title mb-0">Projects Assigned to Me</h5> -->
							<!-- 									</div> -->
							<!-- 									<div class="card-body d-flex justify-content-center"> -->
							<!-- 										Added justify-content-center -->
							<!-- 										<div class="align-self-center" style="width: 100%;"> -->
							<!-- 											<div class="py-3"> -->
							<!-- 												<div class="chart chart-xs" -->
							<!-- 													style="width: 100%; overflow: hidden;"> -->
							<!-- 													<div id="containerDeveloper" class="highchart-container" -->
							<!-- 														style="width: 100%;"></div> -->
							<!-- 												</div> -->
							<!-- 												<table class="table mb-0" -->
							<!-- 													style="height: 100px; overflow-y: auto;"> -->
							<!-- 												</table> -->
							<!-- 											</div> -->
							<!-- 										</div> -->
							<!-- 									</div> -->
							<!-- 								</div> -->
							<!-- 							</div> -->


						</div>
						
						<!--  -->
						
						
						
						
						
						<!-- //16/08 -->
						<div class="row" id="testerteambothtables">

							<div class="col-12 col-lg-12 col-xxl-9 d-flex">
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0">Latest Projects</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">
											<div class="row">
												<div class="col-md-4"></div>
												<div class="col-md-4" style="margin-top: 30px;">
													&nbsp;&nbsp;&nbsp;&nbsp;<label> <input type="radio"
														name="testerTaskTable" value="progress" checked
														onclick="checkRadioButtonTesterTeam()"> Progress Table
														&nbsp;&nbsp;&nbsp;&nbsp;
													</label> <label> <input type="radio" name="testerTaskTable"
														value="tasks" onclick="checkRadioButtonTesterTeam()">
														Task Table
													</label>
												</div>
											</div>

											<div id="ProjectDetailsDevDivtesterteam">
												<table class="table table1 table-striped"
													id="ProjectDetailstesterteam" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Completion<br> in %&nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target Date<br> Of Completion&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Manager<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Testing&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
												
														</tr>
													</thead>
												</table>
												<!-- 												<span -->
												<!-- 													style="width: 5rem; height: 5rem; margin-left: 50% display: none;" -->
												<!-- 													id="spin14"><i class="fa fa-spinner fa-spin" -->
												<!-- 													style="font-size: 33px"></i></span> -->
											</div>



											<div id="ProjectDetailsDevTaskDivtesterteam" style="display: none;">
												<table class="table table1 table-striped"
													id="ProjectDetailsDevTasktesterteam" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Activity&nbsp;<i class="fa-solid fa-sort" -->
															<!-- 															style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->

															<th>Target<br> Date &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Total<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Completed<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Delayed<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
														</tr>
													</thead>
												</table>

											</div>



										</div>
									</div>
								</div>
							</div>


							<!-- 							<div class="col-12 col-lg-3 col-xxl-3 d-flex"> -->
							<!-- 								<div class="card flex-fill w-100"> -->
							<!-- 									<div class="card-header"> -->
							<!-- 										<h5 class="card-title mb-0">Projects Assigned to Me</h5> -->
							<!-- 									</div> -->
							<!-- 									<div class="card-body d-flex justify-content-center"> -->
							<!-- 										Added justify-content-center -->
							<!-- 										<div class="align-self-center" style="width: 100%;"> -->
							<!-- 											<div class="py-3"> -->
							<!-- 												<div class="chart chart-xs" -->
							<!-- 													style="width: 100%; overflow: hidden;"> -->
							<!-- 													<div id="containerDeveloper" class="highchart-container" -->
							<!-- 														style="width: 100%;"></div> -->
							<!-- 												</div> -->
							<!-- 												<table class="table mb-0" -->
							<!-- 													style="height: 100px; overflow-y: auto;"> -->
							<!-- 												</table> -->
							<!-- 											</div> -->
							<!-- 										</div> -->
							<!-- 									</div> -->
							<!-- 								</div> -->
							<!-- 							</div> -->


						</div>
						
						
						
					</div>
				</div>
			</div>


			<div class="row">




				<div class="modal fade bs-example-modal-lg modal-default1111"
					id="modelcategory1" tabindex="-1" role="dialog"
					aria-labelledby="myLargeModalLabel" aria-hidden="true">

					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header bg-secondary">
								<h4 class="modal-title" id="myLargeModalLabel">Task Details</h4>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>



							</div>
							<div class="modal-body" id="taskAssignModal">
								<!--<form action="">-->

								<div class="row">
									<div class="col-md-1"></div>
									<div class="col-md-5">
										<label for="customer_name">Customer Name</label> <input
											type="text" id="customer_name" class="form-control"
											data-toogle="tooltip">
									</div>

									<div class="col-md-5">
										<label for="module_name">Module Name</label> <select
											id="module_name" class="form-control" data-toogle="tooltip"
											onchange="getTaskDetails()"></select>
									</div>


								</div>


								<div class="row mt-3">

									<div class="col-md-1"></div>
									<div class="col-md-5">
										<label for="product_name">Product Suite Name</label> <input
											id="product_name" class="form-control " data-toogle="tooltip">
									</div>

									<div class="col-md-5">
										<label for="product_suit">Product Tool Name</label> <input
											id="product_suit" class="form-control " data-toogle="tooltip">
									</div>



								</div>


								<div class="row mt-3">
									<div class="col-md-1"></div>
									<div class="col-md-5">
										<label for="assign_name">Assign By</label> <input
											id="assign_name" class="form-control " data-toogle="tooltip">
									</div>

									<div class="col-md-5">
										<label for="task_priority">Task Priority</label> <input
											id="task_priority" class="form-control "
											data-toogle="tooltip">
									</div>


								</div>


								<div class="row mt-3">
									<div class="col-md-1"></div>
									<div class="col-md-5">
										<label for="start_Date">Start Date</label> <input
											id="start_Date" class="form-control" data-toogle="tooltip"
											readonly>
									</div>




									<div class="col-md-5">
										<label for="end_Date">End Date</label> <input id="end_Date"
											class="form-control" data-toogle="tooltip" readonly>
									</div>



								</div>

								<div class="row mt-3">
									<div class="col-md-1"></div>

									<div class="col-md-10">
										<label for="product_desc">Description</label>
										<textarea id="product_desc" class="form-control select2"
											data-toogle="tooltip" width="100%"></textarea>
									</div>


								</div>

								<input type="hidden" id="sr_no1" name="sr_no1" value="" /> <br>

								<!-- 							<div class="row"> -->
								<!-- 								<div class="col-md-12"> -->
								<!-- 									<center> -->
								<!-- 										<input type="submit" class="btn btn-primary m-t-10" -->
								<!-- 											id="update_composite_master" -->
								<!-- 											name="update_composite_master"" value="Update"> -->

								<!-- 									</center> -->
								<!-- 								</div> -->
								<!-- 							</div> -->

							</div>

							<div class="col-md-2"></div>
						</div>

						<!--</form>-->



					</div>

				</div>
				<!-- /.modal-content -->
			</div>



			<!-- ////////////////	TEAM LEADER		//////////// -->

			<div class="wrapper" style="margin: 0 30px 0 30px; display: none;"
				id="TeamLeaderDashboard">
				<div class="main">
					<div class="container-fluid p-0">

						<h1 class="h3 mt-4"></h1>
						<div class="row">
							<div class="col-xl-6 col-xxl-5 d-flex">
								<div class="w-100">
									<div class="row">
										<div class="col-sm-6">

											<div class="small-box bg-info">
												<div class="inner">
													<h3>
														<span id="TLTotalProjects"></span>
													</h3>

													<p>Total Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer"
													onclick="TeamLeadTotalProjectCount()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>

											<div class="small-box bg-warning">
												<div class="inner">
													<h3>
														<span id="TLTrackProjects"></span>
													</h3>

													<p>Projects On Track</p>
												</div>
												<div class="icon">
													<i class="ion ion-person-add"></i>
												</div>
												<a class="small-box-footer"
													onclick="TeamLeadProjectOnTrack()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>

											<div class="small-box bg-primary">
												<div class="inner">
													<h3>
														<span id="TLactivity"></span>
													</h3>

													<p>Activities on Track</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer"
													onclick="TeamLeaderActivitiesOnTrack()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>
										</div>


										<div class="col-sm-6">
											<div class="small-box bg-success">
												<div class="inner">
													<h3>
														<span id="TLCompletedProj"></span><sup
															style="font-size: 20px"></sup>
													</h3>

													<p>Completed Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-stats-bars"></i>
												</div>
												<a class="small-box-footer"
													onclick="TeamLeadTotalCompleteProjects()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>

											<div class="small-box bg-danger">
												<div class="inner">
													<h3>
														<span id="TLDelayProj"></span>
													</h3>

													<p>Delayed Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-pie-graph"></i>
												</div>
												<a class="small-box-footer"
													onclick="TeamLeaderDelayproject()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>

											<div class="small-box bg-secondary">
												<div class="inner">
													<h3>
														<span id="TLActivityDelay"></span>
													</h3>

													<p>Activities Delayed</p>
												</div>
												<div class="icon">
													<i class="ion ion-pie-graph"></i>
												</div>
												<a class="small-box-footer"
													onclick="TeamLeadActivitiesDelayed()">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="col-12 col-md-6 col-xxl-3 d-flex order-2 order-xxl-3">
								<div class="card flex-fill w-100" style="height: 460px;">
									<div class="card-header">

										<h5 class="card-title mb-0">Task</h5>
									</div>
									<div class="card-body d-flex">
										<div class="align-self-center w-100">
											<figure class="highcharts-figure">
												<div id="TLContainer">
													<span
														style="width: 5rem; height: 5rem; margin-left: 230px; display: none;"
														id="spin1"><i class="fa fa-spinner fa-spin"
														style="font-size: 33px"></i></span>
												</div>

											</figure>
											<!-- 												</div> -->
											<!-- 											</div> -->
										</div>
									</div>
								</div>
							</div>

						</div>
						<br>



						<div class="row">

							<div class="col-12 col-lg-12 col-xxl-9 d-flex">
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0">Latest Projects</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">

											<div class="row">
												<div class="col-md-4"></div>

												<div class="col-md-3" style="margin-top: 30px;">
													<label> <input type="radio" name="TLTable"
														value="progress" checked onclick="checkRadioButtonTL()">
														Progress Table &nbsp; &nbsp; &nbsp;
													</label> <label> <input type="radio" name="TLTable"
														value="tasks" onclick="checkRadioButtonTL()"> Task
														Table
													</label>
												</div>

												<div class="col-md-3" id="developersDropdownDiv"
													style="display: none;">
													<label for="">Select Developer :</label> <select
														id="developersOfTL" class="form-control"
														data-toogle="tooltip" name="developersOfTL"
														onchange="getProjectByDevNameOfTL(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
											</div>




											<div id="AllDetailsOfProjectsProgressTL">
												<table class="table table1 table-striped"
													id="ProjectDetailTL" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Target Date<br> Of Completion&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Manager<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Development&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Testing&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>POC&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>UAT&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>Implementation&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Go Live&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>
												</table>
												<!-- 												<span -->
												<!-- 													style="width: 5rem; height: 5rem; margin-left: 50% display: none;" -->
												<!-- 													id="spin14"><i class="fa fa-spinner fa-spin" -->
												<!-- 													style="font-size: 33px"></i></span> -->
											</div>




											<div id="ProjectDetailTLTasksDiv" style="display: none;">
												<table class="table table1 table-striped"
													id="ProjectDetailTLTasks" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Module<br> Name &nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target<br> Date &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Total<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Completed<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Delay<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
														</tr>
													</thead>
												</table>
											</div>




										</div>
									</div>
								</div>
							</div>


							<!-- 							<div class="col-12 col-lg-4 col-xxl-3 d-flex"> -->
							<!-- 								<div class="card flex-fill w-100"> -->
							<!-- 									<div class="card-header"> -->
							<!-- 										<h5 class="card-title mb-0">Team Members</h5> -->
							<!-- 									</div> -->

							<!-- 									<div class="card-body d-flex justify-content-center"> -->
							<!-- 										<div class="align-self-center" style="width: 100%;"> -->
							<!-- 											<div class="py-3"> -->
							<!-- 												<div class="chart chart-xs" -->
							<!-- 													style="width: 100%; overflow: hidden;"> -->
							<!-- 													<div id="containerTeamMember" class="highchart-container" -->
							<!-- 														style="width: 100%;"></div> -->
							<!-- 												</div> -->
							<!-- 												<table class="table mb-0" -->
							<!-- 													style="height: 100px; overflow-y: auto;"> -->

							<!-- 												</table> -->
							<!-- 											</div> -->
							<!-- 										</div> -->
							<!-- 									</div> -->
							<!-- 								</div> -->
							<!-- 							</div> -->
						</div>
					</div>
				</div>
			</div>


<!-- //////?///     HR Dashboard    ///// -->





<div class="wrapper" style="margin: 0 30px 0 30px; display: none;"
    id="HRDashboard">
    <div class="main">
        <div class="container-fluid p-0">

            <div class="row">
                <div class="row" id="cardsRow">
                    <div class="cardn">
                        <div class="card-title">TOTAL EMPLOYEES&nbsp;</div><br>
                        <div class="card-value" id="totEmp"></div>
                    </div>
                    <div class="cardn">
                        <div class="card-title">ACTIVE ON PMS&nbsp;&nbsp;&nbsp;&nbsp;</div><br>
                        <div class="card-value" id="acEmp">60</div>
                    </div>
                    <div class="cardn">
                        <div class="card-title">MALE EMPLOYEES&nbsp;&nbsp;</div><br>
                        <div class="card-value" id="mlEmp">50</div>
                    </div>
                    <div class="cardn">
                        <div class="card-title">FEMALE EMPLOYEES</div><br>
                        <div class="card-value" id="fmlEmp">50</div>
                    </div>
                    <div class="cardn">
                        <div class="card-title">View Total Activities</div><br>
                        <div class="card-value" id="totAct">2015</div>
                    </div>
                                                        
                </div>
            </div>
                                                
                                                
            <div class="row" id="newAndRole">
<!--            <div class="container"> -->
                <div class="col-sm-6" style="width: 100%">
                    <div class="cardn" style="width: 95%;height: 96%;" id="newCard1">
<!--                         <div class="card-title" id="newEmp"></div> -->
<!--                             <div class="chart"> -->
<!--                                 <svg width="100%" height="110%" id="svgData"> -->
<!--                                     <path -->
<!--                                       d="M10,200 L20,180 L30,160 L40,150 L50,150 L60,170 L70,150 L80,180 L90,170 L100,160 L110,150 L120,160 L130,180 L140,190 L150,200 L160,210 L170,220 L180,230 L190,240 L200,250 L210,260 L220,270 L230,280 L240,290 L250,300 L260,290 L270,280 L280,270 L290,260 L300,250" -->
<!--                                       stroke="#f08080" stroke-width="2" fill="none" /> -->
<!-- 																																															</svg> -->
<!--                             </div> -->


								<!-- //05/09/2024 -->
								<div id="containerEmpGraph"></div>
								<!--  -->



								

								

                        </div>
                    </div>
                                                        
                                                        
                    <div class="col-sm-6" style="width: 100%" id="rolesCard">        
                        <div class="cardn" style="width: 100%;height: 96%;" id="newCard2">

                            <div id="containerEmpRole"></div>
                        </div> 
                    </div>
                </div>
            </div>
                                
                                
            <div class="row" id="empTable">
<!--            <div class="container"> -->
                <div class="col-md-1"></div>
                    <div class="col-md-10" >
                        <div class="card" id="latestEmp">
                            <div class="card-title"><h4 id="yesStatus">Yesterday's Task Status</h4></div><br><br>

                                <input type="text" id="searchBox" placeholder="Search" class="form-control" style="width: 40%">
                                    <table class="table table1 table-striped"
                                    id="getemployeedataforhr" style="width: 96%;">

                                        <thead>
                                            <tr>
                                                <th>Employee<br> Name&nbsp;<i
													class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
                                                </th>
                                                <th>Designation&nbsp;<i
                                                    class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
                                                </th>
                                                <th>Role&nbsp;<i
                                                    class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
                                                </th>
                                                                                                                        <!--                                                                                                                 <th>Completion<br> in %&nbsp;<i -->
                                                                                                                        <!--                                                                                                                         class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
                                                                                                                        <!--                                                                                                                 </th> -->
                                                <th>Assigned Date&nbsp;<i
                                                    class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
                                                </th>
                                                <th>Assigned Task&nbsp;<i
                                                    class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
                                                </th>
                                                <th>Status&nbsp;<i
                                                    class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody></tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="col-md-1"></div>
                        </div>


                    </div>
                </div>



<!-- END -->


			<!-- /////?//			MANAGER DASHBOARD     /////// -->



			<div class="wrapper" style="margin: 0 30px 0 30px; display: none;"
				id="ManagerDashboard">
				<div class="main">
					<div class="container-fluid p-0">

						<h1 class="h3 mt-4"></h1>
						<div class="row">
<!-- 							<div class="col-xl-6 col-xxl-5 d-flex"> -->
<!-- 								<div class="w-100"> -->
<!-- 									<div class="row"> -->
<!-- 										<div class="col-sm-6"> -->

<!-- 											<div class="small-box bg-info"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="ImplTotalProjects"></span> -->
<!-- 													</h3> -->

<!-- 													<p>Total Projects</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-bag"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="ToatlprojectPM()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->

<!-- 											<div class="small-box bg-warning"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="ImplTrackProjects"></span> -->
<!-- 													</h3> -->

<!-- 													<p>Projects On Track</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-person-add"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="projectontrackMGR()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->

<!-- 											<div class="small-box bg-primary"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="Implactivity"></span> -->
<!-- 													</h3> -->

<!-- 													<p>Activities on Track</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-bag"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="ActivitiesOnTrackPM()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->
<!-- 										</div> -->


<!-- 										<div class="col-sm-6"> -->
<!-- 											<div class="small-box bg-success"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="ImplCompletedProj"></span><sup -->
<!-- 															style="font-size: 20px"></sup> -->
<!-- 													</h3> -->

<!-- 													<p>Completed Projects</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-stats-bars"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="CompletedprojectMGR()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->

<!-- 											<div class="small-box bg-danger"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="ImplDelayProj"></span> -->
<!-- 													</h3> -->

<!-- 													<p>Delayed Projects</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-pie-graph"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="DelayprojectMGR()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->

<!-- 											<div class="small-box bg-secondary"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="ImplActivityDelay"></span> -->
<!-- 													</h3> -->

<!-- 													<p>Activities Delayed</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-pie-graph"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="MgrActivitiesDelayed()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->




							
							<div class="col-xl-7 col-xxl-5 d-flex">
								<div class="w-100">
									<div class="row">
<!-- 										<div class="col-sm-6"> -->

<!-- 											<div class="small-box bg-info"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="ImplTotalProjects"></span> -->
<!-- 													</h3> -->

<!-- 													<p>Total Projects</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-bag"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="ToatlprojectPM()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->

<!-- 											<div class="small-box bg-warning"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="ImplTrackProjects"></span> -->
<!-- 													</h3> -->

<!-- 													<p>Projects On Track</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-person-add"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="projectontrackMGR()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->
											
											
<!-- 											//28/06 -->
<!-- 											<div class="col-sm-4"> -->
<!-- 											<div class="small-box bg-secondary">  -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="ManOnHoldProjects"></span> -->
<!-- 													</h3> -->

<!-- 													<p>Projects On Hold</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-person-add"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="Projectonhold()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->
<!-- 											</div> -->
<!-- 											 -->

<!-- 											<div class="small-box bg-primary"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="Implactivity"></span> -->
<!-- 													</h3> -->

<!-- 													<p>Activities on Track</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-bag"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="ActivitiesOnTrackPM()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->
<!-- 										</div> -->


									
									<!-- 28/06 -->
									<div class="col-sm-6">
											<div class="small-box bg-info">
												<div class="inner">
													<h3>
														<span id="ImplTotalProjects"></span>
													</h3>

													<p>Total Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer" onclick="ToatlprojectPM()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
											</div>
											
											
											
											<!-- //12/11 -->
											<div class="col-sm-6">

											<div class="small-box bg-info">
												<div class="inner">
													<h3>
														<span id="ManNTotalActivities"></span>
													</h3>

													<p>Total Activities</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer" onclick="TotalActivitiesCountN()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>

										</div>
											<!--  -->
											
											
											<div class="col-sm-3">
											<div class="small-box bg-success">
												<div class="inner">
													<h3>
														<span id="ImplCompletedProj"></span><sup
															style="font-size: 20px"></sup>
													</h3>

													<p style="font-size: 13px;">Completed Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-stats-bars"></i>
												</div>
												<a class="small-box-footer" onclick="CompletedprojectMGR()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
											</div>
											
											
											<!-- //12/11 -->
											<div class="col-sm-3">
											<div class="small-box bg-secondary"> 
												<div class="inner">
													<h3>
														<span id="ManOnHoldProjects"></span>
													</h3>

													<p style="font-size: 14px;">Projects On Hold</p>
												</div>
												<div class="icon">
													<i class="ion ion-person-add"></i>
												</div>
												<a class="small-box-footer" onclick="ProjectonholdMan()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
											</div>
											
											<!--  -->
											
											
											
											<!-- //12/11 -->
										<div class="col-sm-3">
											<div class="small-box bg-success">
												<div class="inner">
													<h3>
														<span id="ManactivityCompleted"></span>
													</h3>

													<p style="font-size: 13px;">Activities Completed</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer" onclick="ActivitiesCompletedcountmgr()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
										</div>
										
										
										<!-- //12/11 -->
										<div class="col-sm-3">
											<div class="small-box bg-secondary">
												<div class="inner">
													<h3>
														<span id="MDactivityonholdN"></span>
													</h3>

													<p style="font-size: 13px;">Activities On Hold</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer"
													onclick="ActivitiesOnHoldCountMan()">More info <i
													class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
										</div>
									
										<!--  -->

											<div class="col-sm-3">
											<div class="small-box bg-warning">
												<div class="inner">
													<h3>
														<span id="ImplTrackProjects"></span>
													</h3>

													<p style="font-size: 15px;">Projects On Track</p>
												</div>
												<div class="icon">
													<i class="ion ion-person-add"></i>
												</div>
												<a class="small-box-footer" onclick="projectontrackMGR()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
											</div>
											
											
											
											
											
											<div class="col-sm-3">
											<div class="small-box bg-danger">
												<div class="inner">
													<h3>
														<span id="ImplDelayProj"></span>
													</h3>

													<p style="font-size: 15px;">Delayed Projects</p>
												</div>
												<div class="icon">
													<i class="ion ion-pie-graph"></i>
												</div>
												<a class="small-box-footer" onclick="DelayprojectMGR()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
											</div>
											

											<div class="col-sm-3">
											<div class="small-box bg-warning">
												<div class="inner">
													<h3>
														<span id="Implactivity"></span>
													</h3>

													<p style="font-size: 15px;">Activities on Track</p>
												</div>
												<div class="icon">
													<i class="ion ion-bag"></i>
												</div>
												<a class="small-box-footer" onclick="ActivitiesOnTrackPM()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
											</div>
											
											
									<!--  -->
										
										
										<!-- //28/06 -->
<!-- 										<div class="col-sm-4"> -->
<!-- 											<div class="small-box bg-success"> -->
<!-- 												<div class="inner"> -->
<!-- 													<h3> -->
<!-- 														<span id="ManactivityCompleted"></span> -->
<!-- 													</h3> -->

<!-- 													<p style="font-size:0.96rem;">Activities Completed</p> -->
<!-- 												</div> -->
<!-- 												<div class="icon"> -->
<!-- 													<i class="ion ion-bag"></i> -->
<!-- 												</div> -->
<!-- 												<a class="small-box-footer" onclick="ActivitiesCompletedcount()">More -->
<!-- 													info <i class="fas fa-arrow-circle-right"></i> -->
<!-- 												</a> -->
<!-- 											</div> -->
<!-- 										</div> -->

											
										<!--  -->


										

											

											
											<div class="col-sm-3">
											<div class="small-box bg-danger">
												<div class="inner">
													<h3>
														<span id="ImplActivityDelay"></span>
													</h3>

													<p style="font-size: 15px;">Activities Delayed</p>
												</div>
												<div class="icon">
													<i class="ion ion-pie-graph"></i>
												</div>
												<a class="small-box-footer" onclick="MgrActivitiesDelayed()">More
													info <i class="fas fa-arrow-circle-right"></i>
												</a>
											</div>
										</div>
										
									</div>
								</div>
							</div>
							
							
							

							<div class="col-12 col-md-5 col-xxl-3 d-flex order-2 order-xxl-3">
								<div class="card flex-fill w-100">
									<div class="card-header">

										<h5 class="card-title mb-0">SCM</h5>
									</div>
									<div class="card-body d-flex">
										<div class="align-self-center w-100">
											<!-- 											<div class="card card-secondary"> -->
											<!-- 												<div class="card-header">Bar Chart for SCM</div> -->
											<!-- 												<div class="card-body "> -->
											<figure class="highcharts-figure">
												<div id="bar_containerManager">
													<span
														style="width: 5rem; height: 5rem; margin-left: 50%; display: none;"
														id="spin2"><i class="fa fa-spinner fa-spin"
														style="font-size: 33px"></i></span>
												</div>
											</figure>
											<!-- 												</div> -->
											<!-- 											</div> -->
										</div>
									</div>
								</div>
							</div>

						</div>
						<br>



						<div class="row" id="managerbothTables">

							<div class="col-12 col-lg-12 col-xxl-9 d-flex">
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0">Latest Projects</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">




											<div class="row">
												<div class="col-md-2"></div>

												<div class="col-md-3" style="margin-top: 30px;">
													<label> <input type="radio" name="ManagerTable"
														value="progress" checked onclick="checkRadioButtonMgr()">
														Progress Table &nbsp;&nbsp;&nbsp;&nbsp;
													</label> <label> <input type="radio" name="ManagerTable"
														value="tasks" onclick="checkRadioButtonMgr()">
														Task Table
													</label>
												</div>

												<div class="col-md-3" id="TLDropdownDiv"
													style="display: none;">
													<label for="">Select Team Leader :</label> <select
														id="teamLeaders" class="form-control"
														data-toogle="tooltip" name="teamLeaders"
														onchange="getDetailsByTLname(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-3" id="devDropdownDiv"
													style="display: none;">
													<label for="">Select Developers :</label> <select
														id="developers" class="form-control" data-toogle="tooltip"
														name="developers"
														onchange="getDetailsByDevName(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

											</div>



											<div id="AllDetailsOfProjectsProgressMgr">
												<table class="table table1 table-striped"
													id="ProjectDetailsManager" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Completion<br> in %&nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target Date<br> Of Completion&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Manager<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Development&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Testing&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>POC&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>UAT&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>Implementation&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Go Live&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>
												</table>
												<!-- 												<span -->
												<!-- 													style="width: 5rem; height: 5rem; margin-left: 50% display: none;" -->
												<!-- 													id="spin18"><i class="fa fa-spinner fa-spin" -->
												<!-- 													style="font-size: 33px"></i></span> -->
											</div>



											<div id="TaskDetailsManager" style="display: none;">
												<table class="table table1 table-striped"
													id="ProjectDetailsManagerTask" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Module<br> Name &nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target<br> Date<br> Of Completion
																&nbsp;<i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i>
															</th>

															<th>Total<br> Tasks &nbsp;&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Completed<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Delay<br>Tasks &nbsp;&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>

												</table>
											</div>







										</div>
									</div>
								</div>
							</div>


							<!-- 							<div class="col-12 col-lg-4 col-xxl-3 d-flex"> -->
							<!-- 								<div class="card flex-fill w-100"> -->
							<!-- 									<div class="card-header"> -->
							<!-- 										<h5 class="card-title mb-0">My Team Leaders</h5> -->
							<!-- 									</div> -->
							<!-- 									<div class="card-body d-flex justify-content-center"> -->
							<!-- 										<div class="align-self-center" style="width: 100%;"> -->
							<!-- 											<div class="py-3"> -->
							<!-- 												<div class="chart chart-xs" -->
							<!-- 													style="width: 100%; overflow: hidden;"> -->
							<!-- 													<div id="containerTL" class="highchart-container" -->
							<!-- 														style="width: 100%;"></div> -->
							<!-- 												</div> -->
							<!-- 											</div> -->
							<!-- 										</div> -->
							<!-- 									</div> -->
							<!-- 								</div> -->
							<!-- 							</div> -->

						</div>
						
						
						
					<!-- //01/08 -->
			
			<div class="row" id="supportbothTables">

							<div class="col-12 col-lg-12 col-xxl-9 d-flex">
								<div class="card flex-fill">
									<div class="card-header">
										<h5 class="card-title mb-0">Latest Projects</h5>
									</div>
									<div class="row">
										<div class="table-responsive" style="margin: 15px;">




											<div class="row">
												<div class="col-md-2"></div>

												<div class="col-md-3" style="margin-top: 30px;">
													<label> <input type="radio" name="SupportTable"
														value="progress" checked onclick="checkRadioButtonSupport()">
														Progress Table &nbsp;&nbsp;&nbsp;&nbsp;
													</label> <label> <input type="radio" name="SupportTable"
														value="tasks" onclick="checkRadioButtonSupport()">
														Task Table
													</label>
												</div>

												<div class="col-md-3" id="TLDropdownDivSupport"
													style="display: none;">
													<label for="">Select Team Leader :</label> <select
														id="teamLeadersSupport" class="form-control"
														data-toogle="tooltip" name="teamLeadersSupport"
														onchange="getDetailsByTLnameSupport(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-3" id="devDropdownDivSupport"
													style="display: none;">
													<label for="">Assigned To :</label> <select
														id="developersSupport" class="form-control" data-toogle="tooltip"
														name="developersSupport"
														onchange="getDetailsByDevNameSupport(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

											</div>



											<div id="AllDetailsOfProjectsProgressSupport">
												<table class="table table1 table-striped"
													id="ProjectDetailsSupport" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Completion<br> in %&nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target Date<br> Of Completion&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Manager<br> Name&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															<th>Development&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Testing&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>POC&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>UAT&nbsp;<br> <i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i></th>
															<th>Implementation&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Go Live&nbsp;<br> <i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>
												</table>
												<!-- 												<span -->
												<!-- 													style="width: 5rem; height: 5rem; margin-left: 50% display: none;" -->
												<!-- 													id="spin18"><i class="fa fa-spinner fa-spin" -->
												<!-- 													style="font-size: 33px"></i></span> -->
											</div>



											<div id="TaskDetailsSupport" style="display: none;">
												<table class="table table1 table-striped"
													id="ProjectDetailsSupportTask" style="width: 100%;">

													<thead>
														<tr>
															<th>Customer<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Suite<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Product Tool<br> Name &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<!-- 														<th>Module<br> Name &nbsp;<i -->
															<!-- 															class="fa-solid fa-sort" style="color: #7f8b9f;"></i> -->
															<!-- 														</th> -->
															<th>Target<br> Date<br> Of Completion
																&nbsp;<i class="fa-solid fa-sort"
																style="color: #7f8b9f;"></i>
															</th>

															<th>Total<br> Tasks &nbsp;&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
															<th>Completed<br> Tasks &nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i>
															</th>
															<th>Delay<br>Tasks &nbsp;&nbsp;<i
																class="fa-solid fa-sort" style="color: #7f8b9f;"></i></th>
														</tr>
													</thead>

												</table>
											</div>







										</div>
									</div>
								</div>
							</div>


							<!-- 							<div class="col-12 col-lg-4 col-xxl-3 d-flex"> -->
							<!-- 								<div class="card flex-fill w-100"> -->
							<!-- 									<div class="card-header"> -->
							<!-- 										<h5 class="card-title mb-0">My Team Leaders</h5> -->
							<!-- 									</div> -->
							<!-- 									<div class="card-body d-flex justify-content-center"> -->
							<!-- 										<div class="align-self-center" style="width: 100%;"> -->
							<!-- 											<div class="py-3"> -->
							<!-- 												<div class="chart chart-xs" -->
							<!-- 													style="width: 100%; overflow: hidden;"> -->
							<!-- 													<div id="containerTL" class="highchart-container" -->
							<!-- 														style="width: 100%;"></div> -->
							<!-- 												</div> -->
							<!-- 											</div> -->
							<!-- 										</div> -->
							<!-- 									</div> -->
							<!-- 								</div> -->
							<!-- 							</div> -->

						</div>	
						
						
						
						
					</div>
				</div>
			</div>

<!-- 						<div class="row" style="margin: 10px;" id="homeCharts" style="display :none;"> -->

<!-- 							<div class="col-md-6"> -->
<!-- 								<div class="card card-secondary "> -->
<!-- 									<div class="card-header">Pie Chart for PMS</div> -->
<!-- 									<div class="card-body "> -->

<!-- 										<figure class="highcharts-figure"> -->
<!-- 											<div id="container"> -->
<!-- 												<span -->
<!-- 													style="width: 5rem; height: 5rem; margin-left: 230px; display: none;" -->
<!-- 													id="spin1"><i class="fa fa-spinner fa-spin" -->
<!-- 													style="font-size: 33px"></i></span> -->
<!-- 											</div> -->

<!-- 										</figure> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->



<!-- 							<div class="col-md-6"> -->
<!-- 								<div class="card card-secondary"> -->
<!-- 									<div class="card-header">Bar Chart for SCM</div> -->
<!-- 									<div class="card-body "> -->
<!-- 										<figure class="highcharts-figure"> -->
<!-- 											<div id="bar_container"> -->
<!-- 												<span -->
<!-- 													style="width: 5rem; height: 5rem; margin-left: 230px; display: none;" -->
<!-- 													id="spin2"><i class="fa fa-spinner fa-spin" -->
<!-- 													style="font-size: 33px"></i></span> -->
<!-- 											</div> -->
<!-- 										</figure> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->

<!-- 						</div> -->

			<!-- 						MD MODAL WHEN CLICK ON TOTAL PROJECT              -->



			<!-- 						MD MODAL WHEN CLICK ON TOTAL PROJECT              -->









			<!-- Modal -->
			<div class="modal fade" id="PMMODAL" tabindex="-1" role="dialog"
				aria-labelledby="PMMODALLabel" aria-hidden="true">
				<div
					class="modal-dialog modal-lg"
					role="document" >
					<div class="modal-content" style="width:130%;">
						<div class="modal-header">
							<h5 class="modal-title" id="PMmpl">Activities On Track</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" onclick="reload()">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body" id="taskAssignModalPM">

							<div class="col-md-12">
								<div class="row">
									<div class="col-md-3" style="margin-top: 10px;">
										<label for="PMActprojectName">Project Name:</label> <select
											id="PMActprojectName" class="form-control" tabindex="1"
											data-toggle="tooltip" name="PMActprojectName"
											onchange="PMActivityDetailsByProj(this.value)"></select>
									</div>
									<div class="col-md-3" style="margin-top: 10px;">
										<label for="PMActteamLeaderName">Team Leader Name:</label> <select
											id="PMActteamLeaderName" class="form-control" tabindex="1"
											data-toggle="tooltip" name="PMActteamLeaderName"
											onchange="PMActTrackteamLeaderDetails(this.value)"></select>
									</div>

									<div class="col-md-3" style="margin-top: 10px;">
										<label for="PMActprodmgr">Assign To:</label> <select
											id="PMActprodmgr" class="form-control" tabindex="1"
											data-toggle="tooltip" name="PMActprodmgr"
											onchange="PMActTrackDevDetails(this.value)"></select>
									</div>


									<div class="col-md-2" style="margin-top: 10px;">
										<label for="PMActFname">Function Name:</label> <select
											id="PMActFname" class="form-control" tabindex="1"
											data-toggle="tooltip" name="PMActFname"
											onchange="PMActtoalldatafeatchn(this.value)"></select>
									</div>
									
									<button type="submit" tabindex="8"
														class="btn btn-primary m-t-10" id="resetDDActMGR" name="resetDDActMGR"
														data-style="expand-left" onclick="resetAllDDMGR()" style="margin-top: 35px;"><i class="fa fa-refresh" aria-hidden="true"></i></button>
									

								</div>
							</div>
							<br>

							<!-- Table to display completed projects -->
							<table class="table" id="PMProjectDetailsByName">
								<thead>
									<tr>
										<th>Customer Name</th>
										<th>Product Suite</th>
										<th>Product tool</th>
										<th>Function name</th>
										<th>Activities</th>
										<th>Team Leader Name</th>
										<th>Assign To</th>
										<th>Task End Date</th>
										<!-- Add more columns as needed -->
									</tr>
								</thead>
								<tbody>
									<!-- Completed projects will be dynamically added here -->
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal" onclick="reload()">Close</button>
						</div>
					</div>
				</div>
			</div>
			
			
			
			
			<!-- 28/06 -->
		<!-- TotalProjectMGRModal -->
		<div class="modal fade" id="projectonholdModal" tabindex="-1"
			role="dialog" aria-labelledby="projectonholdmgrModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width: 150%">
					<div class="modal-header">
						<h5 class="modal-title" id="projectonholdmgrModalLabel">Projects on
							Hold</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" onclick="reload()">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Table to display completed projects -->
						<table class="table" id="projectonholdMGR">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Product Suite</th>
									<th>Product Tool</th>
									<th>Completion Date</th>
									<th>Manager Name</th>
									<th>Project Status</th>
			
									<!-- Add more columns as needed -->
								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="reload()">Close</button>
					</div>
				</div>
			</div>
		</div>
		<!--  -->
		
		
		
		
		<!-- //28/06 -->
		<div class="modal fade" id="TotalActivitiesCompletedmgrModal"
							tabindex="-1" role="dialog" aria-labelledby="TotalActivitiesCompletedmgrModal"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
								style="margin-top: 3%; margin-left: 10%;">
								<div class="modal-content" style="width: 235%;">
									<div class="modal-header">
										<h5 class="modal-title" id="TotalActivitiesCompletedmgrModalLabel"
											style="color: green;">Completed Activities</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">

										<div class="col-md-12">
											<div class="row">
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="projectNamesN1">Project Name:</label> <select
														id="projectNamesN1" class="form-control" tabindex="1"
														data-toggle="tooltip" name="projectNamesN1"
														onchange="CompletedManagerListDet1(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="prodmgrN1">Team Leader:</label> <select
														id="prodmgrN1" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodmgrN1"
														onchange="CompletedTLListDet1(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-3" style="margin-top: 10px;">
													<label for="teamLeaderNameN1">Assigned To:</label> <select
														id="teamLeaderNameN1" class="form-control" tabindex="1"
														data-toggle="tooltip" name="teamLeaderNameN1"
														onchange="CompletedFunctionListDet1(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="FnameN1">Function Name:</label> <select
														id="FnameN1" class="form-control" tabindex="1"
														data-toggle="tooltip" name="FnameN1"
														onchange="CompletedDetailsBasedOnAll1(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDDN1" name="resetDDN1"
													data-style="expand-left" onclick="resetAllDDN1()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>


										<div class="modal-body">
											<!-- Table to display completed projects -->
											<table class="table" id="TotalcompletedProjectsTablemgrN1">
												<thead>
													<tr>
														<th>Customer Name</th>
														<th>Product Manager</th>
														<th>Product Suite</th>
														<th>Product tool</th>
														<th>Function name</th>
														<th>Activities</th>
														<th>Team Leader Name</th>
														<th>Assigned To</th>
														<th>Task End Date</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
						</div>
		
		<!--  -->
		
		
		
		
		<!-- //12/11 -->
						<!-- Modal -->
						<div class="modal fade" id="TotalActivitiesOnHoldManModal"
							tabindex="-1" role="dialog" aria-labelledby="MDMODALLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
								style="margin-top: 3%; margin-left: 9%;">
								<div class="modal-content" style="width: 230%;">
									<div class="modal-header">
										<h5 class="modal-title" id="TotalActivitiesOnHoldManModalLabel"
											style="color: red;">Activities On Hold</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">

										<div class="col-md-12">
											<div class="row">
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="projectNamesNOHMan">Project Name:</label> <select
														id="projectNamesNOHMan" class="form-control" tabindex="1"
														data-toggle="tooltip" name="projectNamesNOHMan"
														onchange="OnHoldManagerListDetMan(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-3" style="margin-top: 10px;">
													<label for="teamleaderNOHMan">Team Leader:</label> <select
														id="teamleaderNOHMan" class="form-control" tabindex="1"
														data-toggle="tooltip" name="teamleaderNOHMan"
														onchange="OnHoldTLListDetMan(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<div class="col-md-3" style="margin-top: 10px;">
													<label for="assigntoNOHMan">Assigned To:</label> <select
														id="assigntoNOHMan" class="form-control" tabindex="1"
														data-toggle="tooltip" name="assigntoNOHMan"
														onchange="OnHoldFunctionListDetMan(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="FnameNOHMan">Function Name:</label> <select
														id="FnameNOHMan" class="form-control" tabindex="1"
														data-toggle="tooltip" name="FnameNOHMan"
														onchange="OnHoldDetailsBasedOnAllMan(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDDNOHMan" name="resetDDNOHMan"
													data-style="expand-left" onclick="resetDDNOHMan()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>


										<div class="modal-body">
											<!-- Table to display completed projects -->
											<table class="table" id="TotalOnHoldProjectsTableMDNMan">
												<thead>
													<tr>
														<th>Customer Name</th>
<!-- 														<th>Product Manager</th> -->
														<th>Product Suite</th>
														<th>Product tool</th>
														<th>Function name</th>
														<th>Activities</th>
														<th>Team Leader Name</th>
														<th>Assigned To</th>
														<th>Task End Date</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--  -->
			
			
			
			
		
		<!-- Modal -->
		<div class="modal fade" id="TotalActivitiesDelayedModal1"
				tabindex="-1" role="dialog"
				aria-labelledby="TotalActivitiesDelayedModalLabel1"
				aria-hidden="true">
				<div class="modal-dialog modal-lg" role="document" style="margin-left:13%;">
					<!-- Add the modal-lg class here for a large modal -->
					<div class="modal-content" style="width: 140%">
						<div class="modal-header">
							<h5 class="modal-title" id="TotalActivitiesDelayedModalLabel1"
								style="color: red;">Activities Delayed</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" onclick="reload()">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<div class="col-md-12">
								<div class="row">
									<div class="col-md-3" style="margin-top: 10px;">
										<label for="PMActDlyprojectName">Project Name:</label> <select
											id="PMActDlyprojectName" class="form-control" tabindex="1"
											data-toggle="tooltip" name="PMActDlyprojectName"
											onchange="PMActproductsuiteDetails(this.value)"></select>
									</div>
									<div class="col-md-3" style="margin-top: 10px;">
										<label for="PMActDlyteamLeaderName">Team Leader Name:</label>
										<select id="PMActDlyteamLeaderName" class="form-control"
											tabindex="1" data-toggle="tooltip"
											name="PMActDlyteamLeaderName"
											onchange="PMActteamLeaderDetails(this.value)"></select>
									</div>

									<div class="col-md-3" style="margin-top: 10px;">
										<label for="PMActDlyprodmgr">Assign To:</label> <select
											id="PMActDlyprodmgr" class="form-control" tabindex="1"
											data-toggle="tooltip" name="PMActDlyprodmgr"
											onchange="PMActproductmangerDetails(this.value)"></select>
									</div>


									<div class="col-md-2" style="margin-top: 10px;">
										<label for="PMActDlyFname">Function Name:</label> <select
											id="PMActDlyFname" class="form-control" tabindex="1"
											data-toggle="tooltip" name="PMActDlyFname"
											onchange="PMActtoalldatafeatchnDly(this.value)"></select>
									</div>
									
									<button type="submit" tabindex="8"
														class="btn btn-primary m-t-10" id="resetDDMGR" name="resetDDMGR"
														data-style="expand-left" onclick="resetAllDDMGR()" style="margin-top: 35px;"><i class="fa fa-refresh" aria-hidden="true"></i></button>

								</div>
							</div>
							<br>
							<!-- Table to display completed projects -->
							<table class="table" id="TotalcompletedProjectsTable1">
								<thead>
									<tr>
										<th>Customer Name</th>
										<th>Product Suite</th>
										<th>Product Tool</th>
										<th>Function name</th>
										<th>Activities</th>
										<th>Team Leader</th>
										<th>Assigned To</th>
										<th>Task End date</th>
										<th>Delayed(Days)</th>
									</tr>
								</thead>
								<tbody>
									<!-- Completed projects will be dynamically added here -->
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal" onclick="reload()">Close</button>
						</div>
					</div>
				</div>
			</div>

		<!-- TotalProjectMGRModal -->
		<div class="modal fade" id="totolProjectsModal" tabindex="-1"
			role="dialog" aria-labelledby="totolProjectsModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width: 150%">
					<div class="modal-header">
						<h5 class="modal-title" id="totolProjectsModalLabel">Total
							Projects</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" onclick="reload()">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Table to display completed projects -->
						<table class="table" id="TotoprojectMGR">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Product Suite</th>
									<th>Product Tool</th>
									<th>Completion Date</th>
									<th>Project Status</th>
									

									<!-- Add more columns as needed -->
								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="reload()">Close</button>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		<!-- //12/11 -->
						
						<!-- Modal -->
						<div class="modal fade" id="TotalActivitiesCompletedModalNewMan"
							tabindex="-1" role="dialog" aria-labelledby="MDMODALLabelMan"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
								style="margin-top: 3%; margin-left: 4%;">
								<div class="modal-content" style="width: 250%;">
				
<!-- 									<div class="modal-header"> -->
<!-- 										<h5 class="modal-title" id="TotalActivitiesCompletedModalLabelNew" -->
<!-- 											style="color: red;">Total Activities</h5> -->
<!-- 										<button type="button" class="close" data-dismiss="modal" -->
<!-- 											aria-label="Close"> -->
<!-- 											<span aria-hidden="true">&times;</span> -->
<!-- 										</button> -->
<!-- 									</div> -->

									<!-- //20/08 -->
									<div class="modal-header">
    									<h5 class="modal-title" id="TotalActivitiesCompletedModalLabelNewMan" style="color: red;">Total Activities</h5>
    									
    									<div class="modal-actions" style="margin-left: 66%">
        									<button type="button" class="btn btn-primary" id="exportExcel1">Export to Excel</button>
        									<button type="button" class="btn btn-primary" id="exportPDF1">Export to PDF</button>
    									</div>
    									
    									<button type="button" class="close" data-dismiss="modal" aria-label="Close">
        									<span aria-hidden="true">&times;</span>
    									</button>
									</div>
									<!--  -->
									
									
								

									
									<div class="modal-body">
									
									
<!-- 									 <input type="text" id="searchBoxProjects" placeholder="Search" class="form-control" style="width: 10%"> -->

										<div class="col-md-12">
											<div class="row">
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="projectNamesNNewMan">Project Name:</label> <select
														id="projectNamesNNewMan" class="form-control" tabindex="1"
														data-toggle="tooltip" name="projectNamesNNewMan"
														onchange="CompletedManagerListDetNewMan(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="prodtoolNNew">Product Tool:</label> <select
														id="prodtoolNNew" class="form-control" tabindex="1"
														data-toggle="tooltip" name="prodtoolNNew"
														onchange="CompletedTLListDetNewMan(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												
												<div class="col-md-2" style="margin-top: 10px;">
													<label for="teamleaderNMan">Team Leader:</label> <select
														id="teamleaderNMan" class="form-control" tabindex="1"
														data-toggle="tooltip" name="teamleaderNMan"
														onchange="ProductToolTotActMan(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												
												

												<div class="col-md-2" style="margin-top: 10px;">
													<label for="funcNameNNewMan">Function Name:</label> <select
														id="funcNameNNewMan" class="form-control" tabindex="1"
														data-toggle="tooltip" name="funcNameNNewMan"
														onchange="CompletedFunctionListDetNewMan(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>


												<div class="col-md-2" style="margin-top: 10px;">
													<label for="statusNMan">Status:</label> <select
														id="statusNMan" class="form-control" tabindex="1"
														data-toggle="tooltip" name="statusNMan"
														onchange="statusChangedMan(this.value)">
														<option value="">--Please Select --</option>
													</select>
												</div>
												
												
<!-- 												<div class="col-md-1" style="margin-top: 10px;"> -->
<!-- 													<label for="FnameNNewStatus">Status:</label> <select -->
<!-- 														id="FnameNNewStatus" class="form-control" tabindex="1" -->
<!-- 														data-toggle="tooltip" name="FnameNNewStatus" -->
<!-- 														onchange="CompletedDetailsBasedOnAllNew(this.value)"> -->
<!-- 														<option value="">--Please Select --</option> -->
<!-- 													</select> -->
<!-- 												</div> -->
												

												<button type="submit" tabindex="8"
													class="btn btn-primary m-t-10" id="resetDDNNewMan" name="resetDDNNewMan"
													data-style="expand-left" onclick="resetDDNNewMan()"
													style="margin-top: 35px;">
													<i class="fa fa-refresh" aria-hidden="true"></i>
												</button>


											</div>
										</div>


										<div class="modal-body">
											<!-- Table to display completed projects -->
											<table class="table" id="TotalcompletedProjectsTableMDNNewMan">
												<thead>
													<tr>
														<th>Customer Name</th>
<!-- 														<th>Product Manager</th> -->
														<th>Product Suite</th>
														<th>Product tool</th>
														<th>Function name</th>
														<th>Activities</th>
														<th>Team Leader Name</th>
														<th>Assigned To</th>
														<th>Completion Date / Task End Date</th>
														<th>Status</th>
														<th>Date Revised Count</th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
<!-- 										<div class="modal-footer"> -->
<!-- 											<button type="button" class="btn btn-secondary" -->
<!-- 												data-dismiss="modal">Close</button> -->
												
<!-- 											 <button type="button" class="btn btn-primary" id="exportExcel">Export to Excel</button> -->
<!--                 							<button type="button" class="btn btn-primary" id="exportPDF">Export to PDF</button> -->
<!-- 										</div> -->
									</div>
								</div>
							</div>
						</div>
						<!--  -->
						<!--  -->
		
		

		<!-- TotalProjectMGRModal -->
		<div class="modal fade" id="projectontrackmgrModal" tabindex="-1"
			role="dialog" aria-labelledby="projectontrackmgrModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width: 150%">
					<div class="modal-header">
						<h5 class="modal-title" id="projectontrackModalLabel">
							Projects On Track</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" onclick="reload()">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Table to display completed projects -->
						<table class="table" id="projectontrackMGR">
							<thead>
								<tr>
										<th>Project Name</th>
										<th>Product Suite</th>
										<th>Product Tool</th>
										<th>Completion Date</th>
										<th>Project Status</th>

										<!-- Add more columns as needed -->
								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="reload()">Close</button>
					</div>
				</div>
			</div>
		</div>


		<!-- TotalProjectMGRModal -->
		<div class="modal fade" id="projectcompletedmgrModal" tabindex="-1"
			role="dialog" aria-labelledby="projectcompletedmgrModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width: 150%">
					<div class="modal-header">
						<h5 class="modal-title" id="projectcompletedmgrModalLabel">
							Completed Projects</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" onclick="reload()">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Table to display completed projects -->
						<table class="table" id="projectcompltedMGR">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Product Suite</th>
									<th>Product Tool</th>
									<th>Completion Date</th>
									<th>Project Status</th>
									

								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="reload()">Close</button>
					</div>
				</div>
			</div>
		</div>


		<!-- TotalProjectMGRModal -->
		<div class="modal fade" id="projectDealymgrModal" tabindex="-1"
			role="dialog" aria-labelledby="projectDealymgrModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width: 150%">
					<div class="modal-header">
						<h5 class="modal-title" id="projectDealymgrModalLabel">Delayed
							Projects</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" onclick="reload()">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Table to display completed projects -->
						<table class="table" id="projectdelayMGR">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Product Suite</th>
									<th>Product Tool</th>
									<th>Completion Date</th>
									<th>Project Status</th>
									

									<!-- Add more columns as needed -->
								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="reload()">Close</button>
					</div>
				</div>
			</div>
		</div>


		<!-- 											Team Leader Total Project Count			 -->

		<div class="modal fade" id="ProjectsOnTrackTLModal" tabindex="-1"
			role="dialog" aria-labelledby="ProjectsOnTrackTLModalLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width: 150%">
					<div class="modal-header">
						<h5 class="modal-title" id="TotalcompletedProjectsModalLabel">Total
							Projects Details</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>


					<div class="modal-body">
						<!-- Table to display completed projects -->
						<table class="table" id="TLProjectsOnTrackTable">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Product Suite</th>
									<th>Product Tool</th>
									<th>Completion Date</th>
									<th>Manager Name</th>
									<th>Project Status</th>

									<!-- Add more columns as needed -->
								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="TeamLeadprojectontrackmgrModal"
			tabindex="-1" role="dialog"
			aria-labelledby="projectontrackmgrModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width: 150%">
					<div class="modal-header">
						<h5 class="modal-title" id="projectontrackModalLabel">
							Projects On Track</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" onclick="reload()">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Table to display completed projects -->
						<table class="table" id="TeamLeadProjectontrackMGR">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Product Suite</th>
									<th>Product Tool</th>
									<th>Completion Date</th>
									<th>Manager Name</th>
									<th>Project Status</th>

									<!-- Add more columns as needed -->
								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="reload()">Close</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="TeamLeaderTotalcompletedProjectsModal"
			tabindex="-1" role="dialog"
			aria-labelledby="TotalcompletedProjectsModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width: 150%">
					<div class="modal-header">
						<h5 class="modal-title" id="TotalcompletedProjectsModalLabel">Completed
							Projects</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Table to display completed projects -->
						<table class="table" id="TeamLeaderTotalcompletedProjectsTable">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Product Suite</th>
									<th>Product Tool</th>
									<th>Completion Date</th>
									<th>Manager Name</th>
									<th>Project Status</th>

									<!-- Add more columns as needed -->
								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="TeamLeadprojectontrackmgrModal"
			tabindex="-1" role="dialog"
			aria-labelledby="projectontrackmgrModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width: 150%">
					<div class="modal-header">
						<h5 class="modal-title" id="projectontrackModalLabel">
							Projects On Track</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" onclick="reload()">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Table to display completed projects -->
						<table class="table" id="TeamLeadProjectontrackMGR">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Product Suite</th>
									<th>Product Tool</th>
									<th>Completion Date</th>
									<th>Manager Name</th>
									<th>Project Status</th>

									<!-- Add more columns as needed -->
								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="reload()">Close</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="TeamLeaderDelayProjectMODAL" tabindex="-1"
			role="dialog" aria-labelledby="TeamLeaderDelayProjectMODALLabel"
			aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content" style="width: 110%">
					<div class="modal-header">
						<h5 class="modal-title" id="TotalActivitiesDelayedModalLabel">Delayed
							Projects</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<!-- Table to display completed projects -->
						<table class="table" id="TeamLeaderDelayedProjectList">
							<thead>
								<tr>
									<th>Project Name</th>
									<th>Product Suite</th>
									<th>Product Tool</th>
									<th>Completion Date</th>
									<th>Manager Name</th>
									<th>Project Status</th>
									<!-- Add more columns as needed -->
								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="TeamLeadMODAL" tabindex="-1" role="dialog"
			aria-labelledby="TLMODALLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content" style="width: 120%;">
					<div class="modal-header">
						<h5 class="modal-title" id="PMmpl">Activities On Track</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" onclick="reload()">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body" id="taskAssignModalPM">

						<div class="col-md-12">
							<div class="row">
								<div class="col-md-4" style="margin-top: 10px;">
									<label for="TLActprojectName">Project Name:</label> <select
										id="TLActprojectName" class="form-control" tabindex="1"
										data-toggle="tooltip" name="TLActprojectName"
										onchange="TeamLeaderActproductsuiteDetails(this.value)"></select>
								</div>

								<div class="col-md-4" style="margin-top: 10px;">
									<label for="TLAssignedto">Assigned To:</label> <select
										id="TLAssignedto" class="form-control" tabindex="1"
										data-toggle="tooltip" name="TLAssignedto"
										onchange="TeamLeaderActAssignedToDetails(this.value)"></select>
								</div>


								<div class="col-md-3" style="margin-top: 10px;">
									<label for="TLActFname">Function Name:</label> <select
										id="TLActFname" class="form-control" tabindex="1"
										data-toggle="tooltip" name="TLActFname"
										onchange="TeamLeadActtoalldatafeatchn(this.value)"></select>
								</div>

								<button type="submit" tabindex="8"
									class="btn btn-primary m-t-10" id="resetDelayAct"
									name="resetDelayAct" data-style="expand-left"
									onclick="resetTeamLeaderActonTrack()" style="margin-top: 35px;">
									<i class="fa fa-refresh" aria-hidden="true"></i>
								</button>

							</div>
						</div>
						<br>

						<!-- Table to display completed projects -->
						<table class="table" id="TeamLeadProjectDetailsByName">
							<thead>
								<tr>
									<th>Customer Name</th>
									<th>Product Manager</th>
									<th>Product Suite</th>
									<th>Product tool</th>
									<th>Function name</th>
									<th>Activities</th>
									<th>Assigned To</th>
									<th>Task End Date</th>
									<!-- Add more columns as needed -->
								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="reload()">Close</button>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="TeamLeadTotalActivitiesDelayedModal"
			tabindex="-1" role="dialog"
			aria-labelledby="TotalActivitiesDelayedModalLabel1"
			aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document"
				style="margin-left: 15%">
				<!-- Add the modal-lg class here for a large modal -->
				<div class="modal-content" style="width: 135%">
					<div class="modal-header">
						<h5 class="modal-title" id="TotalActivitiesDelayedModalLabel1"
							style="color: red;">Activities Delayed</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close" onclick="reload()">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-4" style="margin-top: 10px;">
									<label for="TeamLeaderDelayProject">Project Name:</label> <select
										id="TeamLeaderDelayProject" class="form-control" tabindex="1"
										data-toggle="tooltip" name="TeamLeaderDelayProject"
										onchange="TeamLeaddelayedProjectDeatils(this.value)"></select>
								</div>


								<div class="col-md-4" style="margin-top: 10px;">
									<label for="assignToDelay">Assign To:</label> <select
										id="assignToDelay" class="form-control" tabindex="1"
										data-toggle="tooltip" name="assignToDelay"
										onchange="TeamLeaderDealyedProjectDetailsByProjectName(this.value)"></select>
								</div>


								<div class="col-md-3" style="margin-top: 10px;">
									<label for="TlDelayeFunctionName">Function Name:</label> <select
										id="TlDelayeFunctionName" class="form-control" tabindex="1"
										data-toggle="tooltip" name="TlDelayeFunctionName"
										onchange="TlDelayeFunctionName(this.value)"></select>
								</div>

								<button type="submit" tabindex="8"
									class="btn btn-primary m-t-10" id="resetDelayAct"
									name="resetDelayAct" data-style="expand-left"
									onclick="resetTeamLeaderActDelay()" style="margin-top: 35px;">
									<i class="fa fa-refresh" aria-hidden="true"></i>
								</button>


							</div>
						</div>
						<br>
						<!-- Table to display completed projects -->
						<table class="table" id="TeamLeadDelayedProjectTable">
							<thead>
								<tr>
									<th>Customer Name</th>
									<th>Product Manager</th>
									<th>Product Suite</th>
									<th>Product tool</th>
									<th>Function name</th>
									<th>Activities</th>
									<th>Assigned To</th>
									<th>Task End date</th>
									<th>Delayed<br>(Days)
									</th>

								</tr>
							</thead>
							<tbody>
								<!-- Completed projects will be dynamically added here -->
							</tbody>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="reload()">Close</button>
					</div>
				</div>
			</div>
		</div>

			
<!-- 	////////////		Developer Card Modal    /////////////     -->



	<!-- 			Total Project -->

			<div class="modal fade" id="TotalProjectsModalDev" tabindex="-1"
				role="dialog" aria-labelledby="TotalProjectsModalDevLabel"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width: 150%">
						<div class="modal-header">
							<h5 class="modal-title" >Total
								Projects Details</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<table class="table" id="ProjectsTotalTableDev">
								<thead>
									<tr>
										<th>Project Name</th>
										<th>Product Suite</th>
										<th>Product Tool</th>
										<th>Completion Date</th>
										<th>Manager Name</th>
										<th>Project Status</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
			
			
			
<!-- 			On Track  -->

		<div class="modal fade" id="OnTrackProjectsModalDev" tabindex="-1"
				role="dialog" aria-labelledby="ProjectsOnTrackMDModalLabel"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width: 150%">
						<div class="modal-header">
							<h5 class="modal-title" >On Track
								Projects Details</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<table class="table" id="ProjectsOnTrackTableDev">
								<thead>
									<tr>
										<th>Project Name</th>
										<th>Product Suite</th>
										<th>Product Tool</th>
										<th>Completion Date</th>
										<th>Manager Name</th>
										<th>Project Status</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>


<!-- 			Completed -->

			<div class="modal fade" id="CompletedProjectsModalDev" tabindex="-1"
				role="dialog" aria-labelledby="CompletedProjectsModalDevLabel"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width: 150%">
						<div class="modal-header">
							<h5 class="modal-title" >Completed
								Projects Details</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<table class="table" id="ProjectsCompletedTableDev">
								<thead>
									<tr>
										<th>Project Name</th>
										<th>Product Suite</th>
										<th>Product Tool</th>
										<th>Completion Date</th>
										<th>Manager Name</th>
										<th>Project Status</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>

		
<!-- 			Delayed -->

			<div class="modal fade" id="DelayedProjectsModalDev" tabindex="-1"
				role="dialog" aria-labelledby="DelayedProjectsModalDevLabel"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content" style="width: 150%">
						<div class="modal-header">
							<h5 class="modal-title" >Delayed
								Projects Details</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<table class="table" id="ProjectsDelayTableDev">
								<thead>
									<tr>
										<th>Project Name</th>
										<th>Product Suite</th>
										<th>Product Tool</th>
										<th>Completion Date</th>
										<th>Manager Name</th>
										<th>Project Status</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>


			
			<div class="modal fade" id="DeveloperModal" tabindex="-1" role="dialog"
				aria-labelledby="DevMODALLabel" aria-hidden="true">
				<div
					class="modal-dialog modal-lg"
					role="document" >
					<div class="modal-content" style="width:120%;">
						<div class="modal-header">
							<h5 class="modal-title" id="PMmpl">Activities On Track</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" onclick="reload()">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body" id="taskAssignModalPM">

							<div class="col-md-12">
								<div class="row">
									<div class="col-md-4" style="margin-top: 10px;">
										<label for="DevActprojectName">Project Name:</label> <select
											id="DevActprojectName" class="form-control" tabindex="1"
											data-toggle="tooltip" name="DevActprojectName"
											onchange="DeveloperActproductsuite(this.value)"></select>
									</div>

<!-- 									<div class="col-md-4" style="margin-top: 10px;"> -->
<!-- 										<label for="TLAssignedto">Assigned To:</label> <select -->
<!-- 											id="TLAssignedto" class="form-control" tabindex="1" -->
<!-- 											data-toggle="tooltip" name="TLAssignedto" -->
<!-- 											onchange="TeamLeaderActAssignedToDetails(this.value)"></select> -->
<!-- 									</div> -->


									<div class="col-md-3" style="margin-top: 10px;">
										<label for="DevActFname">Function Name:</label> <select
											id="DevActFname" class="form-control" tabindex="1"
											data-toggle="tooltip" name="DevActFname"
											onchange="DeveloperActtoalldata(this.value)"></select>
									</div>
									
									<button type="submit" tabindex="8"
														class="btn btn-primary m-t-10" id="resetDelayAct" name="resetDelayAct"
														data-style="expand-left" onclick="resetDeveloperActonTrack()" style="margin-top: 35px;"><i class="fa fa-refresh" aria-hidden="true"></i></button>

								</div>
							</div>
							<br>


							<!-- Table to display completed projects -->
							<table class="table" id="DevTableDetails">
								<thead>
									<tr>
													<th>Customer Name</th>
													<th>Product Manager</th>
													<th>Product Suite</th>
													<th>Product tool</th>
													<th>Function name</th>
													<th>Activities</th>
													<th>Team Leader</th>
													<th>Task End Date</th>
										<!-- Add more columns as needed -->
									</tr>
								</thead>
								<tbody>
									
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal" onclick="reload()">Close</button>
						</div>
					</div>
				</div>
			</div>
			
			
			
			
			
			<div class="modal fade" id="DeveloperDelaysActModal" tabindex="-1" role="dialog"
				aria-labelledby="DevMODALLabel" aria-hidden="true">
				<div
					class="modal-dialog modal-lg"
					role="document" >
					<div class="modal-content" style="width:125%;">
						<div class="modal-header">
							<h5 class="modal-title" id="PMmpl" style="color: red;">Activities Delayed</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close" onclick="reload()">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body" id="taskAssignModalPM">

							<div class="col-md-12">
								<div class="row">
									<div class="col-md-4" style="margin-top: 10px;">
										<label for="DevDalayprojectName">Project Name:</label> <select
											id="DevDalayprojectName" class="form-control" tabindex="1"
											data-toggle="tooltip" name="DevDalayprojectName"
											onchange="DeveloperDelayProjectNames(this.value)"></select>
									</div>

<!-- 									<div class="col-md-4" style="margin-top: 10px;"> -->
<!-- 										<label for="TLAssignedto">Assigned To:</label> <select -->
<!-- 											id="TLAssignedto" class="form-control" tabindex="1" -->
<!-- 											data-toggle="tooltip" name="TLAssignedto" -->
<!-- 											onchange="TeamLeaderActAssignedToDetails(this.value)"></select> -->
<!-- 									</div> -->


									<div class="col-md-3" style="margin-top: 10px;">
										<label for="DevDelayActFname">Function Name:</label> <select
											id="DevDelayActFname" class="form-control" tabindex="1"
											data-toggle="tooltip" name="DevDelayActFname"
											onchange="DeveloperDelayActtoalldata(this.value)"></select>
									</div>
									
									<button type="submit" tabindex="8"
														class="btn btn-primary m-t-10" id="resetDelayAct" name="resetDelayAct"
														data-style="expand-left" onclick="resetDeveloperDelaysProject()" style="margin-top: 35px;"><i class="fa fa-refresh" aria-hidden="true"></i></button>

								</div>
							</div>
							<br>


							<!-- Table to display completed projects -->
							<table class="table" id="DevDelaysTableDetails">
								<thead>
									<tr>
													<th>Customer Name</th>
													<th>Product Manager</th>
													<th>Product Suite</th>
													<th>Product tool</th>
													<th>Function name</th>
													<th>Activities</th>
													<th>Team Leader</th>
													<th>Task End<br>Date</th>
													<th>Delay<br>Days</th>
										<!-- Add more columns as needed -->
									</tr>
								</thead>
								<tbody>
									
								</tbody>
							</table>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal" onclick="reload()">Close</button>
						</div>
					</div>
				</div>
			</div>
			
			
			
			
			


	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

	<!-- Control Sidebar -->
	<aside class="control-sidebar control-sidebar-dark"></aside>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/chart.js/Chart.min.js"></script>
	<!-- Sparkline -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/sparklines/sparkline.js"></script>
	<!-- JQVMap -->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/jquery.vmap.min.js"></script>-->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>-->
	<!-- jQuery Knob Chart -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/moment/moment.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/daterangepicker/daterangepicker.js"></script>
	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<!-- AdminLTE App -->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/adminlte.js"></script>-->
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<!--<script src="<%=request.getContextPath()%>/AdminLTE_3/dist/js/pages/dashboard.js"></script>-->
	<!-- AdminLTE for demo purposes -->
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/dist/js/demo.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/resources1/js/highcharts.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/resources1/js/highcharts-3d.js"></script>

	<!-- 		<script src="https://code.highcharts.com/highcharts.js"></script>	 -->
	<!-- 		<script src="https://code.highcharts.com/highcharts-3d.js"></script> -->

	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	<script src="https://code.highcharts.com/modules/accessibility.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
		
	<!-- SheetJS for Excel export -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.0/xlsx.full.min.js"></script>

	<!-- jsPDF for PDF export -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.5.1/jspdf.umd.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf-autotable/3.5.21/jspdf.plugin.autotable.min.js"></script>
	
	<script
		src="<%=request.getContextPath()%>/static/custom/HomeDashboard.js"></script>

	<script>
		// Function to reset input field values
		function resetInputFields() {
			$("#customer_name").val("");
			$("#module_name").val("").trigger("change");
			$("#product_name").val("");
			$("#product_suit").val("");
			//         $("#assign_name").val("");
			document.getElementById("assign_name").value = "";
			$("#task_priority").val("");
			$("#start_Date").val("");
			$("#end_Date").val("");
			$("#product_desc").val("");
			$("#sr_no1").val("");
		}

		// Function to execute when the modal is closed
		$('#modelcategory1').on('hidden.bs.modal', function() {
			// Reset the input field values
			resetInputFields();
		});
	</script>
	
	
	<script>
		document.getElementById('exportExcel').addEventListener('click', () => {
		    const wb = XLSX.utils.table_to_book(document.getElementById('TotalcompletedProjectsTableMDNNew'));
		    XLSX.writeFile(wb, 'TotalActivities.xlsx');
		});



		document.getElementById('exportExcel1').addEventListener('click', () => {
		    const wb = XLSX.utils.table_to_book(document.getElementById('TotalcompletedProjectsTableMDNNewMan'));
		    XLSX.writeFile(wb, 'TotalActivities.xlsx');
		});



		//
// 		document.getElementById('exportExcel').addEventListener('click', () => {
// 		    const table = document.getElementById('TotalcompletedProjectsTableMDNNew');
// 		    const data = [];
		
// 		    const headers = [];
// 		    for (let i = 0; i < table.rows[0].cells.length; i++) {
// 		        headers.push(table.rows[0].cells[i].innerText);
// 		    }
// 		    data.push(headers);
		
// 		    for (let i = 1; i < table.rows.length; i++) {
// 		        const row = [];
// 		        for (let j = 0; j < table.rows[i].cells.length; j++) {
// 		            let cellValue = table.rows[i].cells[j].innerText;
		
// 		            const date = new Date(cellValue);
// 		            if (!isNaN(date)) {
		                
// // 		                cellValue = date.toISOString().split('T')[0];
// 		            	const day = String(date.getDate()).padStart(2, '0');
// 		                const month = String(date.getMonth() + 1).padStart(2, '0'); // Months are 0-indexed
// 		                const year = date.getFullYear();
// 		                cellValue = `${day}.${month}.${year}`;
// 		            }
		
// 		            row.push(cellValue);
// 		        }
// 		        data.push(row);
// 		    }
		

// 		    const ws = XLSX.utils.aoa_to_sheet(data);
// 		    const wb = XLSX.utils.book_new();
// 		    XLSX.utils.book_append_sheet(wb, ws, 'Total Activities');
		
// 		    XLSX.writeFile(wb, 'TotalActivities.xlsx');
// 		});
		
		//



	
// 		document.getElementById('exportPDF').addEventListener('click', () => {
// 		    const { jsPDF } = window.jspdf;
// 		    const doc = new jsPDF('p', 'pt', 'a4');
	
// 		    doc.autoTable({ html: '#TotalcompletedProjectsTableMDNNew' });
// 		    doc.save('TotalActivities.pdf');
// 		});
	</script>
	
	
	<script>
    document.getElementById('exportPDF').addEventListener('click', () => {
        const { jsPDF } = window.jspdf;
        const doc = new jsPDF('l', 'pt', 'a4');

        // Extract table data manually
        const table = document.querySelector('#TotalcompletedProjectsTableMDNNew');
        const headers = Array.from(table.querySelectorAll('thead th')).map(th => th.innerText);
        const rows = Array.from(table.querySelectorAll('tbody tr')).map(tr =>
            Array.from(tr.querySelectorAll('td')).map(td => td.innerText)
        );

        // Add table to PDF
        doc.autoTable({
            head: [headers],
            body: rows,
            margin: { top: 40 },
            styles: { 
                overflow: 'linebreak', 
                fontSize: 10, 
                cellPadding: 5 
            },
            headStyles: { fillColor: [128,128, 128] }, // Custom header color
        });

        doc.save('TotalActivities.pdf');
    });
    </script>
    
    
    <script>
    document.getElementById('exportPDF1').addEventListener('click', () => {
        const { jsPDF } = window.jspdf;
        const doc = new jsPDF('l', 'pt', 'a4');

        // Extract table data manually
        const table = document.querySelector('#TotalcompletedProjectsTableMDNNewMan');
        const headers = Array.from(table.querySelectorAll('thead th')).map(th => th.innerText);
        const rows = Array.from(table.querySelectorAll('tbody tr')).map(tr =>
            Array.from(tr.querySelectorAll('td')).map(td => td.innerText)
        );

        // Add table to PDF
        doc.autoTable({
            head: [headers],
            body: rows,
            margin: { top: 40 },
            styles: { 
                overflow: 'linebreak', 
                fontSize: 10, 
                cellPadding: 5 
            },
            headStyles: { fillColor: [128, 128, 128] }, // Custom header color
        });

        doc.save('TotalActivities.pdf');
    });
    </script>


</body>

</html>