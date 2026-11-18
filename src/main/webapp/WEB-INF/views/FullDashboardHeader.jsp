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
<style>
menu {
	background: #ced6d5;
}
</style>

<body>
	<%
		String Session_username = (String) session.getAttribute("username");
		System.out.println("username=" + Session_username);
		if (Session_username == null) {
			System.out.println("inside null");
	%>
	<script>
     window.location.href="<%=request.getContextPath()%>
		/index.jsp";
	</script>

	<%
		}
	%>
	<div class="header-top-area">
		<div class="fixed-header-top">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-1 col-md-6 col-sm-6 col-xs-12">

						<div class="admin-logo logo-wrap-pro">
							<a href="#"><img
								src="<%=request.getContextPath()%>/static/AdminPro/img/logo/log.png"
								alt="" /> </a>
						</div>
					</div>
					<div class="col-lg-6 col-md-1 col-sm-1 col-xs-12">
						<div class="header-top-menu tabl-d-n" id="header1">
							<ul class="nav navbar-nav mai-top-nav">
								<li><a href="<c:url value='/Home'/>" class="nav-item">
										<font size="3" color="white"><b>Home</b></font>
								</a></li>
								<li class="nav-item dropdown"><a href="#"
									data-toggle="dropdown" role="button" aria-expanded="false"
									class="nav-link dropdown-toggle">Dashboards<span
										class="angle-down-topmenu"><i class="fa fa-angle-down"></i></span></a>
									<div role="menu"
										class="dropdown-menu left-menu-dropdown animated flipInX">
										<a href="<c:url value='/Dashboards/PingTool'/>"
											class="dropdown-item">Ping Tool</a> <a
											href="<c:url value='/Dashboards/DynamicDashboard'/>"
											class="dropdown-item">Dynamic Dashboard</a> <a
											href="<c:url value='/Dashboards/LinkDashboard'/>"
											class="dropdown-item">Link Dashboard</a> <a
											href="<c:url value='/Dashboards/CriticalLinkDashboard'/>"
											class="dropdown-item">Critical Link Dashboard</a>


									</div></li>

								<li><a href="<c:url value='/Master/CompanyMaster'/>">Admin</a>
								</li>


							</ul>
						</div>
					</div>
					<div class="col-lg-5 col-md-5 col-sm-6 col-xs-12">
						<div class="header-right-info">
							<ul class="nav navbar-nav mai-top-nav header-right-menu">
								<li class="nav-item dropdown"><a href="#"
									data-toggle="dropdown" role="button" aria-expanded="false"
									class="nav-link dropdown-toggle"><span class=""></span><span
										class="indicator-ms"></span></a>
									<div role="menu"
										class="author-message-top dropdown-menu animated flipInX">
										<div class="message-single-top">
											<h1>Message</h1>
										</div>

										<div class="message-view">
											<a href="#">View All Messages</a>
										</div>
									</div></li>

								<li class="nav-item"><a href="#" data-toggle="dropdown"
									role="button" aria-expanded="false"
									class="nav-link dropdown-toggle"> <span
										class="adminpro-icon adminpro-user-rounded header-riht-inf"></span>
										<span class="admin-name" value='"<%=Session_username%>"'><%=Session_username%></span>
										<span
										class="author-project-icon adminpro-icon adminpro-down-arrow"></span>
								</a>
									<ul role="menu"
										class="dropdown-header-top author-log dropdown-menu animated flipInX"></li>
								<li><a href="<c:url value='/login/LOGOUT'/>"><span
										class="adminpro-icon adminpro-locked author-log-ic"></span>Log
										Out</a></li>
							</ul>
							</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>