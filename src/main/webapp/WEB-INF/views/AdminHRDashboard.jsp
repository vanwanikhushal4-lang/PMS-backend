


<!doctype html>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Admin Dashboard</title>
<%--  <link rel="icon" href="<%=request.getContextPath()%>/resources/dist/img/favicon.ico"> --%>
<link rel="icon"
	href="<%=request.getContextPath()%>/static/resources/icon/favicon.ico">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/AdminLTE_3/plugins/fontawesome-free/css/all.min.css">
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

#TotalcompletedProjectsTableMDNNew tbody {
    background-color: #F5F5DC; 
}





 #getActiveEmpsOnPmsModalTable {
            width: 100%;
            border-collapse: collapse;
}
#getActiveEmpsOnPmsModalTable th, 
 #getActiveEmpsOnPmsModalTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#getActiveEmpsOnPmsModalTable th {
            background-color: #f2f2f2;
}

#getActiveEmpsOnPmsModalTable tbody {
    background-color: #F5F5DC; 
}






 #maleEmpsTable {
            width: 100%;
            border-collapse: collapse;
}
#maleEmpsTable th, 
 #maleEmpsTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#maleEmpsTable th {
            background-color: #f2f2f2;
}

#maleEmpsTable tbody {
    background-color: #F5F5DC; 
}





#femaleEmpsTable {
            width: 100%;
            border-collapse: collapse;
}
#femaleEmpsTable th, 
 #femaleEmpsTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#femaleEmpsTable th {
            background-color: #f2f2f2;
}

#femaleEmpsTable tbody {
    background-color: #F5F5DC; 
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

#completedProjectsTable tbody {
    background-color: #F5F5DC; 
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




 #grievanceandcomplaintsTable {
            width: 100%;
            border-collapse: collapse;
}
#grievanceandcomplaintsTable th, 
 #grievanceandcomplaintsTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#grievanceandcomplaintsTable th {
            background-color: #f2f2f2;
}





#employeeHiredTable {
            width: 100%;
            border-collapse: collapse;
}
#employeeHiredTable th, 
 #employeeHiredTable td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
}
#employeeHiredTable th {
            background-color: #f2f2f2;
}



.modal-dialog {
     max-width: 100%;
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



#totEmpHover:hover,
#actPmsHover:hover,
#maleEmpHover:hover,
#femaleEmpHover:hover,
#totActEmps:hover {
    background-color: #e0f7fa;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    transform: scale(1.05);
}






.dashboard-row {
  display: flex;
  justify-content: space-between;
}

.card22 {
  background: #fff;
  border: 1px solid #ddd;
  border-radius: 8px;
  padding: 20px;
  width: 24%;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  cursor: pointer;
}

.card22 h3 {
  font-size: 1.2em;
  margin-bottom: 10px;
}

.metric {
  font-size: 2em;
  font-weight: bold;
  color: cornflowerblue;
}

.headColor{
	color: #001F3F;
}

.trend {
  font-size: 0.9em;
  color: #666;
}

.icon {
  font-size: 2em;
  margin-top: 10px;
}



.card22:hover
{
    background-color: cornerblue;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    transform: scale(1.03);
}




.employee-photo {
    width: 30px; 
    height: auto; 
    border-radius: 50%; 
    margin-bottom: 10px; 
}




.performer-avatar 
{
   width: 40px; 
   height: 40px; 
   background-color: cornflowerblue; 
   color: white; 
   border-radius: 50%; 
   display: flex; 
   align-items: center; 
   justify-content: center; 
   font-size: 20px; 
   font-weight: bold; 
}

#top3_performers {
    display: flex;              
    justify-content: center;    
    align-items: center;       
    gap: 15px;                 
    flex-wrap: wrap;            
    text-align: center;         
    padding: 20px;
}





/* //06/11 */
/* Basic Modal Styles */
.modal-content {
  padding: 20px;
  border-radius: 10px;
}

.modal-header {
  background-color: cornflowerblue;
  color: white;
}

.modal-body {
  padding: 20px;
}

/* Container for performers */
.performer-container {
  display: flex;
  flex-direction: column; /* Stack performers vertically */
  gap: 20px;
  justify-items: center;
}

/* Individual Performer Layout */
.performer {
  display: flex; /* Flexbox to align photo and achievements side by side */
  align-items: center;
  justify-content: space-between;
  background-color: #f8f9fa;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  width: 100%;
}

/* Performer Photo */
.performer-photo-container {
  flex: 0 0 100px; /* Fix width of photo container */
  margin-right: 20px; /* Space between photo and achievements */
}

/* .performer-photo { */
/*   width: 70px; */
/*   height: 70px; */
/*   border-radius: 50%; */
/*   object-fit: cover; */
/*   background-color: cornflowerblue; */
/* } */


.performer-photo {
  width: 70px;              
  height: 70px;              
  border-radius: 50%;       
  object-fit: cover;         
  background-color: grey; 
  display: flex;             
  justify-content: center;   
  align-items: center;       
  font-size: 8px;           
  color: white;              
  text-align: center;        
  overflow: hidden;          
  line-height: 1.2;          
  padding: 5px;              
  text-overflow: ellipsis;   
  white-space: nowrap;       
}


/* Achievements Section */
.performer-achievements {
  flex: 1; /* Take up remaining space for achievements */
}

.performer-achievements h5 {
  margin-bottom: 10px;
  color: #333;
}

.performer-achievements p {
  color: #555;
  font-size: 14px;
}

/* Mobile responsiveness: Adjust layout for smaller screens */
@media (max-width: 768px) {
  .performer {
    flex-direction: column; /* Stack photo and achievements vertically on small screens */
    align-items: center;
    text-align: center;
  }

  .performer-photo-container {
    margin-right: 0;
    margin-bottom: 10px; /* Add space below the photo on small screens */
  }
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
						
						<br>


						



						<!-- Modal -->
						
						
						
						
						<!-- Modal onhold -->
						
						
						
						

						<!-- Modal -->
						


						

						<!-- Modal -->
						
						
						
						
						<!-- //18/06 -->
						<!-- Modal -->
						
						<!--  -->
						
						
						
						<!-- //16/08 -->
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						<!-- 					Male Employees Data Modal For HR	 -->
						
						
						<div class="modal fade" id="getAllMaleEmpsModal" tabindex="-1"
							role="dialog" aria-labelledby="getAllMaleEmpsModal"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content" style="width: 150%">
									<div class="modal-header">
										<h5 class="modal-title" id="getAllMaleEmpsLabel">Male Employees</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
										<!-- Table to display completed projects -->
										<table class="table" id="getAllMaleEmpsModalTable">
											<thead>
												<tr>
													<th>Employee Name</th>
													<th>Employee ID</th>
													<th>Department</th>
													<th>Role Type</th>
													<th>Designation</th>
													<th>Last Login Time</th>
													<th>Activity</th>
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
                    <div class="cardn" id="totEmpHover" onclick="getTotalEmployees()">
                        <div class="card-title">TOTAL EMPLOYEES&nbsp;</div><br>
                        <div class="card-value" id="totEmp"></div>
                    </div>
                    <div class="cardn" id="actPmsHover" onclick="getActiveEmpsOnPms()">
                        <div class="card-title">ACTIVE ON PMS&nbsp;&nbsp;&nbsp;&nbsp;</div><br>
                        <div class="card-value" id="acEmp"></div>
                    </div>
                    <div class="cardn" id="maleEmpHover" onclick="getMaleEmps()">
                        <div class="card-title">MALE EMPLOYEES&nbsp;&nbsp;</div><br>
                        <div class="card-value" id="mlEmp"></div>
                    </div>
                    <div class="cardn" id="femaleEmpHover" onclick="getFemaleEmps()">
                        <div class="card-title">FEMALE EMPLOYEES</div><br>
                        <div class="card-value" id="fmlEmp"></div>
                    </div>
                    <div class="cardn" id="totActEmps" onclick="TotalActivitiesCount()">
                        <div class="card-title">&nbsp;&nbsp;&nbsp;Total Activities</div><br>
                        <div class="card-value" id="totAct"></div>
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
                
                
                <!-- //10/09 -->
                <br>
                <div class="dashboard-row">
					  <div class="card22" id="employee_hired_this_month">
					    <h3 class="headColor">Employees Hired This Month</h3>
					    <p class="metric" id="hired_this_month"></p>
					    <p class="trend"> <b><span id="hired_compare_counts" style="color:orange"></span></b> from last month</p>
					    <i class="fas fa-user-plus icon"></i>
					  </div>
					  
					  <div class="card22" id="top3_performers">
					    <h3 class="headColor">Top 3 Performers of the Month</h3>
<!-- 					    <img src="https://www.w3schools.com/howto/img_avatar.png" class="employee-photo"> -->
<!-- 					    <img src="https://www.w3schools.com/howto/img_avatar.png" class="employee-photo"> -->
<!-- 					    <img src="https://www.w3schools.com/howto/img_avatar.png" class="employee-photo"> -->


							<div class="performer-avatar" id="performer1"></div>
						    <div class="performer-avatar" id="performer2"></div>
						    <div class="performer-avatar" id="performer3"></div>

							
<!-- 					    <p class="metric">34%</p> -->
					    <p class="trend">Top performer employees of this month</p>
					    <i class="fas fa-trophy"></i>
					  </div>
					  
					  <div class="card22" id="manager_satisfaction">
					    <h3 class="headColor">Manager's satisfaction score</h3>
					    <p class="metric" id="man_satisfaction"></p>
<!-- 						<p class="metric">5.0</p> -->
					    <p class="trend">Overall Manager's satisfaction ratings based on recent surveys.</p>
					    <i class="fas fa-smile"></i>
					  </div>
					  
					  <div class="card22" id="grievance_complaints">
					    <h3 class="headColor">Grievance and Complaints</h3>
					    <p class="metric" id="grievanceCount"></p>
<!-- 					    <p class="trend">Tracking unresolved grievances and complaints related to client feedback on projects</p> -->
						<p class="trend">Tracking unresolved grievances and complaints</p>
					    <i class="fas fa-comments"></i>
					  </div>
					  
<!-- 					  <div class="card22"> -->
<!-- 					    <h3 class="headColor">Attendance Rate</h3> -->
<!-- 					    <p class="metric">84%</p> -->
<!-- 					    <p class="trend">-3% compared to last month</p> -->
<!-- 					    <i class="fas fa-calendar icon"></i> -->
<!-- 					  </div> -->
					  
<!-- 					  <div class="card22"> -->
<!-- 					    <h3 class="headColor">Open Positions</h3> -->
<!-- 					    <p class="metric">2</p> -->
<!-- 					    <p class="trend">-1 from last week</p> -->
<!-- 					    <i class="fas fa-building icon"></i> -->
<!-- 					  </div> -->
					  
<!-- 					  <div class="card22"> -->
<!-- 					    <h3 class="headColor">Average Working Hours</h3> -->
<!-- 					    <p class="metric">35 hours/week</p> -->
<!-- 					    <p class="trend">+1 hour compared to last month</p> -->
<!-- 					    <i class="fas fa-clock icon"></i> -->
<!-- 					  </div> -->
				</div>
                
                
                
                
            </div>
                                
                                
            <div class="row" id="empTable">
<!--            <div class="container"> -->
                <div class="col-md-1"></div>
                    <div class="col-md-10" >
                        <div class="card" id="latestEmp">
                            <div class="card-title"><h4 id="yesStatus">Yesterday's Task Status</h4></div><br><br>

                                <input type="text" id="searchBox" placeholder="Search" class="form-control" style="width: 40%">
                                
                                   <div class="modal-actions" style="margin-left: 66%">
        									<button type="button" class="btn" id="exportExcelYtask" style="background-color: #7CB5EC; color:white;">Export to Excel</button>
        									<button type="button" class="btn" id="exportPDFYtask" style="background-color: #7CB5EC; color:white;">Export to PDF</button>
    								</div>
                                    <table class="table table1 table-striped"
                                    id="getemployeedataforhr" style="width: 96%;">

                                        <thead>
                                            <tr>
                                                <th>Employee<br> Name
                                                </th>
                                                <th>Designation
                                                </th>
                                                <th>Assigned Date
                                                </th>
                                                <th>Task End Date
                                                </th>
                                                
                                                <th>Assigned Task
                                                </th>
                                                <th>Status
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



			<!-- 						MD MODAL WHEN CLICK ON TOTAL PROJECT              -->



			<!-- 						MD MODAL WHEN CLICK ON TOTAL PROJECT              -->









			<!-- Modal -->
			
			
			
			
			<!-- 28/06 -->
		<!-- TotalProjectMGRModal -->
		
		<!--  -->
		
		
		
		
		<!-- //28/06 -->
		
		
		<!--  -->
			
			
			
			
		
		<!-- Modal -->
		

		<!-- TotalProjectMGRModal -->
		

		<!-- TotalProjectMGRModal -->
		


		<!-- TotalProjectMGRModal -->
		


		<!-- TotalProjectMGRModal -->


		<!-- 											Team Leader Total Project Count			 -->



		




		


		


		


		

			
<!-- 	////////////		Developer Card Modal    /////////////     -->



	<!-- 			Total Project -->

			
			
			
<!-- 			On Track  -->



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

		
			<!-- 					Total Employees Data Modal For HR 				-->

				<div class="modal fade" id="completedProjectsModal" tabindex="-1"
							role="dialog" aria-labelledby="completedProjectsModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
							style="margin-top: 3%; margin-left: 4%;">
								<div class="modal-content" style="width:250%">
									<div class="modal-header">
										<h5 class="modal-title" id="completedProjectsModalLabel" style="color: white">Total Employees</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
									<input type="text" id="searchBoxTotalEmps" placeholder="Search" class="form-control" style="width: 20%">
									<br>
									
										<!-- Table to display completed projects -->
										<table class="table" id="completedProjectsTable">
											<thead>
												<tr>
													<th>Employee Name</th>
													<th>Employee ID</th>
													<th>Department</th>
													<th>Role Type</th>
													<th>Designation</th>
													<th>Branch</th>
													<th>Email ID</th>
													<th>Mobile No</th>
													<th>Location</th>
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
						
						
						<!--  -->
						
						
						
						<!-- 				 Active Employees Data Modal For HR				 -->
						
						
						<div class="modal fade" id="getActiveEmpsOnPmsModal" tabindex="-1"
							role="dialog" aria-labelledby="getActiveEmpsOnPmsModal"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
							style="margin-top: 3%; margin-left: 4%;">
								<div class="modal-content" style="width:250%">
									<div class="modal-header">
										<h5 class="modal-title" id="getActiveEmpsOnPmsModalLabel" style="color: white">Active Employees on PMS</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
									<input type="text" id="searchBoxActiveEmps" placeholder="Search" class="form-control" style="width: 20%">
									<br>
									
										<!-- Table to display completed projects -->
										<table class="table" id="getActiveEmpsOnPmsModalTable">
											<thead>
												<tr>
													<th>Employee Name</th>
													<th>Employee ID</th>
													<th>Department</th>
													<th>Role Type</th>
													<th>Designation</th>
													<th>Last Login Time</th>
<!-- 													<th>Activity</th> -->
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
						
						
						
						
						<!-- //06/11 -->
						
		<!-- Modal onhold -->
						<div class="modal fade" id="managerSatisfactionScoreModal" tabindex="-1"
							role="dialog" aria-labelledby="completedProjectsonholdModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content" style="width: 160%">
									<div class="modal-header">
										<h5 class="modal-title" id="completedProjectsonholdModalLabel" style="color:white">Manager's Satisfaction Score</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
									
										<!-- Table to display completed projects -->
<!-- 										<div style="margin:auto"><b>Revise Date has been changed<span id="taskCount" style="color:grey"></span> times</b></div> -->
<!-- 										<br> -->
										<input type="text" id="searchBoxManSatisfaction" placeholder="Search" class="form-control" style="width: 20%">
										<br>
										<table class="table" id="completedProjectsonholdTable">
											<thead>
												<tr>
													<th>SR<br>NO</th>
													<th>Employee<br>Name</th>
													<th>Feedback</th>
													<th>Project<br>Name</th>
													<th>Ratings</th>
													<th>Suggestions</th>
													<th>Submitted<br>By</th>
													<th>Submitted<br>Date</th>
<!-- 													<th>View</th> -->
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
		<!--  -->
						
						
						
						
						<!-- Modal onhold -->
						<div class="modal fade" id="grievanceandcomplaintsModal" tabindex="-1"
							role="dialog" aria-labelledby="grievanceandcomplaintsModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content" style="width: 250%;margin-left:-25rem;">
									<div class="modal-header">
										<h5 class="modal-title" id="grievanceandcomplaintsModalLabel" style="color:white">Grievance and Complaints</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
									
										<!-- Table to display completed projects -->
<!-- 										<div style="margin:auto"><b>Revise Date has been changed<span id="taskCount" style="color:grey"></span> times</b></div> -->
<!-- 										<br> -->
										<input type="text" id="searchGrievanceAndComplaints" placeholder="Search" class="form-control" style="width: 20%">
										<br>
										<table class="table" id="grievanceandcomplaintsTable">
											<thead>
												<tr>
													<th>SR<br>NO</th>
													<th>Client<br>Name</th>
													<th>Project<br>Name/ID</th>
													<th>Date Of<br>Feedback</th>
													<th>Type Of<br>Feedback</th>
													<th>Feedback<br>Description</th>
													<th>Impact<br>Assessment</th>
													<th>Status Of<br>Grievance</th>
													<th>Assigned<br>To</th>
													<th>Resolution<br>Description</th>
													<th>Follow-Up<br>Date</th>
													
													<th>Client<br>Response</th>
<!-- 													<th>Submitted<br>By</th> -->
													<th>Submitted<br>Date</th>
													
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
		<!--  -->
		
		
		
		
		<!-- Modal for Top Performers -->
<div class="modal fade" id="topPerformersModal" tabindex="-1" role="dialog" aria-labelledby="topPerformersModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="topPerformersModalLabel">Top 3 Performers of the Month</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- Content for top performers -->
        <div class="performer-container">
          <!-- Top Performer 1 -->
          <div class="performer" id="performer1">
            <div class="photo-container">
<!--               <img src="https://via.placeholder.com/100" alt="Photo of Performer 1" class="performer-photo"> -->
				<div class="performer-photo" id="performer1modal"></div>
				
            </div>
            <div class="achievements">
              <h5 id="achiever1"></h5>
              <p>Uploaded <span id="act_count1" style="color:orange"></span> Activities in this month.</p>
              <p>Completed <span id="act_count2" style="color:orange"></span> major tasks with excellent feedback.</p>
            </div>
          </div>
          <!-- Top Performer 2 -->
          <div class="performer" id="performer2">
            
            <div class="achievements">
              <h5 id="achiever2"></h5>
              <p>Uploaded <span id="act_count3" style="color:orange"></span> Activities in this month.</p>
              <p>Completed <span id="act_count4" style="color:orange"></span> major tasks with excellent feedback.</p>
            </div>
            <div class="photo-container">
<!--               <img src="https://via.placeholder.com/100" alt="Photo of Performer 2" class="performer-photo"> -->
				<div class="performer-photo" id="performer2modal"></div>
				
            </div>
          </div>
          <!-- Top Performer 3 -->
          <div class="performer" id="performer3">
            <div class="photo-container">
<!--               <img src="https://via.placeholder.com/100" alt="Photo of Performer 3" class="performer-photo"> -->
				<div class="performer-photo" id="performer3modal"></div>
            </div>
            <div class="achievements">
              <h5 id="achiever3"></h5>
              <p>Uploaded <span id="act_count5" style="color:orange"></span> Activities in this month.</p>
              <p>Completed <span id="act_count6" style="color:orange"></span> major tasks with excellent feedback.</p>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>





<div class="modal fade" id="employeeHiredModal" tabindex="-1"
							role="dialog" aria-labelledby="employeeHiredModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content" style="width: 160%">
									<div class="modal-header">
										<h5 class="modal-title" id="employeeHiredModalLabel" style="color:white">Employee Hired This Month</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
									
										<!-- Table to display completed projects -->
<!-- 										<div style="margin:auto"><b>Revise Date has been changed<span id="taskCount" style="color:grey"></span> times</b></div> -->
<!-- 										<br> -->
										<input type="text" id="searchBoxEmpHired" placeholder="Search" class="form-control" style="width: 20%">
										<br>
										<table class="table" id="employeeHiredTable">
											<thead>
												<tr>
													<th>Emp Name</th>
						                            <th>Emp ID</th>
						                            <th>Department</th>
						                            <th>Designation</th>
						                            <th>Date of Joining</th>
						                            <th>Experience</th>
						                            
<!-- 													<th>View</th> -->
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





		
						
						
						<!--  -->
						
						
						
						<!-- 					Modal Structure					 -->
					    <div id="employeeModal" class="modal" style="display: none;">
    						<div id="modalOverlay" class="modal-overlay"></div>
    						<div class="modal-content">
        						<img id="modalImage" src="" alt="Employee Image" style="width: 50%;">
        						<p id="modalMessage"></p>
        						<button onclick="closeModal()">Close</button>
    						</div>
						</div>
						
						
						
						
						<!-- 					View Total Employees Data Modal For HR 					-->
						
						<div class="modal fade" id="TotalActivitiesCompletedModalNewHR"
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
    									<h5 class="modal-title" id="TotalActivitiesCompletedModalLabelNew" style="color: white;">Total Activities</h5>
    									
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
									
									
									 <input type="text" id="searchBoxProjectsTotalAct" placeholder="Search" class="form-control" style="width: 20%">

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
						
						
						
						
						<!-- //09/09 -->
						<div class="modal fade" id="maleEmpsModal" tabindex="-1"
							role="dialog" aria-labelledby="maleEmpsModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
							style="margin-top: 3%; margin-left: 4%;">
								<div class="modal-content" style="width:250%">
									<div class="modal-header">
										<h5 class="modal-title" id="maleEmpsModalLabel" style="color: white">Male Employees</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
									<input type="text" id="searchBoxMaleEmps" placeholder="Search" class="form-control" style="width: 20%">
									<br>
									
										<!-- Table to display completed projects -->
										<table class="table" id="maleEmpsTable">
											<thead>
												<tr>
													<th>Employee Name</th>
													<th>Employee ID</th>
													
													<th>Email ID</th>
													<th>Mobile No</th>
													<th>Gender</th>
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
						<!--  -->
						
						
						
						<!-- //09/09 -->
						<div class="modal fade" id="femaleEmpsModal" tabindex="-1"
							role="dialog" aria-labelledby="femaleEmpsModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document"
							style="margin-top: 3%; margin-left: 4%;">
								<div class="modal-content" style="width:250%">
									<div class="modal-header">
										<h5 class="modal-title" id="femaleEmpsModalLabel" style="color: white">Female Employees</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
									
									<input type="text" id="searchBoxFemaleEmps" placeholder="Search" class="form-control" style="width: 20%">
									<br>
									
										<!-- Table to display completed projects -->
										<table class="table" id="femaleEmpsTable">
											<thead>
												<tr>
													<th>Employee Name</th>
													<th>Employee ID</th>
													
													<th>Email ID</th>
													<th>Mobile No</th>
													<th>Gender</th>
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
						<!--  -->
						
						
						
						
						
						
			
			
			
			
			
			
			
			
			
			
			


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
		src="<%=request.getContextPath()%>/static/custom/HRHomeDashboard.js"></script>

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

		 // Yesterday's Task
		document.getElementById('exportExcelYtask').addEventListener('click', () => {
		    const wb = XLSX.utils.table_to_book(document.getElementById('getemployeedataforhr'));
		    XLSX.writeFile(wb, "Yesterday's_Activities.xlsx");
		});
	
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
            headStyles: { fillColor: [128, 128, 128] }, // Custom header color
        });

        doc.save('TotalActivities.pdf');
    });


    // Yesterday's Task
    document.getElementById('exportPDFYtask').addEventListener('click', () => {
        const { jsPDF } = window.jspdf;
        const doc = new jsPDF('l', 'pt', 'a4');

        // Extract table data manually
        const table = document.querySelector('#getemployeedataforhr');
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

        doc.save("Yesterday's_Activities.pdf");
    });
    
    </script>


</body>

</html>