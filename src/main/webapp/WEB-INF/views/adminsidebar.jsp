<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="left-sidebar-pro">
		<nav id="sidebar">
			<div class="sidebar-header">
				<a href="<c:url value='/Home'/>" class="nav-item"> <font
					size="3" color="white"><b>Home</b></font>
				</a>

			</div>
			<div class="left-custom-menu-adp-wrap" id="sidebar12">
				<ul class="nav navbar-nav left-sidebar-menu-pro">
					

					<li class="nav-item"><a href="#" data-toggle="dropdown"
						role="button" aria-expanded="false"
						class="nav-link dropdown-toggle"><span class="mini-dn">Master</span>
							<span class="indicator-right-menu mini-dn"><i
								class="fa indicator-mn fa-angle-left"></i></span></a>
						<div role="menu"
							class="dropdown-menu left-menu-dropdown animated flipInX">
							<a href="<c:url value='/Master/CompanyMaster'/>"
								class="dropdown-item">Company Master</a> <a
								href="<c:url value='/Master/ProjectMaster'/>"
								class="dropdown-item">Project Master</a> <a
								href="<c:url value='/Master/CustomerMaster'/>"
								class="dropdown-item">Customer Master</a> <a
								href="<c:url value='/Master/ServiceMaster'/>"
								class="dropdown-item">Services Master</a> <a
								href="<c:url value='/Master/BranchMaster'/>"
								class="dropdown-item">Branch Master</a> <a
								href="<c:url value='/Master/MakeModelMaster'/>"
								class="dropdown-item">Make and Model</a><a
								href="<c:url value='/Master/GroupMaster'/>"
								class="dropdown-item">Group Master</a><a
								href="<c:url value='/Master/DeviceMaster'/>"
								class="dropdown-item">Device Type</a>

							<!--                                  <a href="javascript:void(0);" class="dropdown-item">Access Report</a> -->
						</div></li>
						
						<li class="nav-item"><a href="#" data-toggle="dropdown"
						role="button" aria-expanded="false"
						class="nav-link dropdown-toggle"><span class="mini-dn">Setting</span>
							<span class="indicator-right-menu mini-dn"><i
								class="fa indicator-mn fa-angle-left"></i></span></a>
						<div role="menu"
							class="dropdown-menu left-menu-dropdown animated flipInX">
							<a href="<c:url value='/Setting/SetPopup'/>"
								class="dropdown-item">Set Popup</a> <a
								href="<c:url value='/Setting/TimePopup'/>"
								class="dropdown-item">Time Popup</a> <a
								href="<c:url value='/Setting/AddDeviceOwner'/>"
								class="dropdown-item">Add Device Owner</a> <a
								href="<c:url value='/Setting/AddMaintenanceOwner'/>"
								class="dropdown-item">Add Maintenance Owner</a> <a
								href="<c:url value='/Setting/OwnerEscalationMatrix'/>"
								class="dropdown-item">Owner Escalation Matrix</a> <a
								href="<c:url value='/Setting/VendorEscalationMatrix'/>"
								class="dropdown-item">Vendor Escalation Matrix</a><a
								href="<c:url value='/Setting/MailConfig'/>"
								class="dropdown-item">Mail Configuration</a>
						</div></li>
						
						<li class="nav-item"><a href="#" data-toggle="dropdown"
						role="button" aria-expanded="false"
						class="nav-link dropdown-toggle"><span class="mini-dn">Interface</span>
							<span class="indicator-right-menu mini-dn"><i
								class="fa indicator-mn fa-angle-left"></i></span></a>
						<div role="menu"
							class="dropdown-menu left-menu-dropdown animated flipInX">
							<a href="<c:url value='/InterfaceMaster/MonitoringLinks'/>"
								class="dropdown-item">Monitoring Links</a> <a
								href="<c:url value='/InterfaceMaster/InterfaceParameter'/>"
								class="dropdown-item">Interface Parameter</a> <a
								href="<c:url value='/InterfaceMaster/BandwidthThreshold'/>"
								class="dropdown-item">Bandwidth Threshold</a> <a
								href="<c:url value='/InterfaceMaster/ProcuredBandwidth'/>"
								class="dropdown-item">Procured Bandwidth</a> <a
								href="<c:url value='/InterfaceMaster/RenameLinks'/>"
								class="dropdown-item">Rename Links</a>
								
						</div></li>
						
						
				</ul>

			</div>
		</nav>
	</div>


</body>
</html>