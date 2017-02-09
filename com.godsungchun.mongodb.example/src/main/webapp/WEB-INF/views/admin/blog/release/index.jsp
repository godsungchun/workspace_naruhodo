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
<%--<script>
	alert('${isAuthenticated}');
</script>--%>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta title="viewport" content="width=device-width, initial-scale=1">
	<meta title="description" content="">
	<meta title="author" content="">
	
	<title>SB Admin 2 - Bootstrap Admin Theme</title>
	
	<%@ include file="../../commons/includes.jsp" %>
	
	<script src="${contextPath}/resources/js/views/blog/release.js?rd=${now}"></script>
	
	<style type="text/css">
		#leftSectionCodeTree ul {
			overflow: hidden;
		}
		
		/*#leftSectionCodeTree tr td:nth-of-type(1) {
			text-align: right;
			overflow: hidden;
		}
		
		#leftSectionCodeTree tr td:nth-of-type(2) {
			text-align: center;
			overflow: hidden;
		}*/
		
		#leftSectionCodeTree ul li {
			min-width: 100px;
			white-space: nowrap;
			overflow: hidden;
			text-overflow: ellipsis;
		}
	</style>
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
		<!-- /.row -->
		<div class="row">
			<div class="col-lg-3">
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-bell fa-fw"></i> 분류
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div id="leftSectionCodeTree" style="width: 100%; overflow-x: hidden; overflow-y: hidden;"></div>
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-9">
				<!-- /.panel -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<i class="fa fa-bar-chart-o fa-fw"></i> 목록
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-4">
								<table id="accountGrid">
								
								</table>
								<div id="accountGridPager">
								
								</div>
								<!-- /.table-responsive -->
							</div>
							<!-- /.col-lg-4 (nested) -->
							<div class="col-lg-8">
								<div id="morris-bar-chart"></div>
							</div>
							<!-- /.col-lg-8 (nested) -->
						</div>
						<!-- /.row -->
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-8 -->
			
		</div>
		<!-- /.row -->
	</div>
	<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
</body>
</html>
<script type="text/javascript">
	blogReleaseRestApi.contextPath = '${contextPath}';
	blogReleaseRestApi.initTree();
</script>
