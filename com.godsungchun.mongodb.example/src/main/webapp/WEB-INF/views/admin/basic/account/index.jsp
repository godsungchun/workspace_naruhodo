<!DOCTYPE html>
<html lang="en">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<c:set var="resourcesPath" value="${contextPath}/resources"/>
<c:set var="now" value="<%=new java.util.Date().getTime()%>" />

<security:authentication var="principal" property="principal"/>
<security:authorize var="isAuthenticated" access="isAuthenticated()"/>

<head>
	<%@ include file="../../commons/includes.jsp" %>
	
	<title>SB Admin 2 - Bootstrap Admin Theme</title>
	
	<script src="${contextPath}/resources/js/views/account/index.js?rd=${now}"></script>
</head>

<body>
<div id="wrapper">
	<!-- Navigation -->
	<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
		<%@ include file="../../layout/header.jsp"%>
		<%@ include file="../../layout/topDropDown.jsp"%>
		<%@ include file="../../layout/leftMenu.jsp"%>
	</nav>
	
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Dashboard</h1>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						Account
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<table id="accountGrid">
							
						</table>
						<div id="accountGridPager">
						
						</div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-6 -->
			<%--<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						DataTables Advanced Tables
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
					
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-6 -->--%>
		</div>
	</div>
	<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
</body>
</html>

<script type="text/javascript">
	accountIndex.setEvent();
	accountRestApi.contextPath = '${contextPath}';
	accountRestApi.findAll();
</script>
