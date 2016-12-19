<%--
  Created by IntelliJ IDEA.
  User: Dream
  Date: 2016-11-18
  Time: 오후 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<!-- Bootstrap Core CSS -->
<link href="${contextPath}/resources/libs/bootstrap/css/bootstrap.min.css?rd=${now}" rel="stylesheet" type="text/css">
<link href="${contextPath}/resources/libs/bootstrap/dialog/css/bootstrap-dialog.min.css?rd=${now}" rel="stylesheet" type="text/css">

<!-- MetisMenu CSS -->
<link href="${contextPath}/resources/libs/metisMenu/metisMenu.min.css?rd=${now}" rel="stylesheet" type="text/css">

<!-- Custom CSS -->
<link href="${contextPath}/resources/libs/sb-admin2/css/sb-admin-2.css?rd=${now}" rel="stylesheet" type="text/css">

<!-- Custom Fonts -->
<link href="${contextPath}/resources/libs/font-awesome/css/font-awesome.min.css?rd=${now}" rel="stylesheet" type="text/css">

<link href="${contextPath}/resources/libs/jquery/ui/jquery-ui.min.css?rd=${now}" rel="stylesheet" type="text/css">

<!-- DataTables -->
<%--<link href="${contextPath}/resources/libs/jqgrid/css/ui.jqgrid.css?rd=${now}" rel="stylesheet" type="text/css">--%>
<link href="${contextPath}/resources/libs/jqgrid/css/ui.jqgrid-bootstrap.css?rd=${now}" rel="stylesheet" type="text/css">
<link href="${contextPath}/resources/libs/jqgrid/css/ui.jqgrid-bootstrap-ui.css?rd=${now}" rel="stylesheet" type="text/css">

<!-- jQuery -->
<script src="${contextPath}/resources/libs/jquery/jquery-3.1.1.min.js?rd=${now}"></script>
<script src="${contextPath}/resources/libs/jquery/form/jquery.form.min.js?rd=${now}"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${contextPath}/resources/libs/bootstrap/js/bootstrap.min.js?rd=${now}"></script>
<script src="${contextPath}/resources/libs/bootstrap/dialog/js/bootstrap-dialog.min.js?rd=${now}"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="${contextPath}/resources/libs/metisMenu/metisMenu.min.js?rd=${now}"></script>

<!-- Custom Theme JavaScript -->
<script src="${contextPath}/resources/libs/sb-admin2/js/sb-admin-2.js?rd=${now}"></script>

<!-- JqGrid -->
<script src="${contextPath}/resources/libs/jqgrid/js/jquery.jqGrid.min.js?rd=${now}"></script>
<script src="${contextPath}/resources/libs/jqgrid/js/i18n/grid.locale-kr.js?rd=${now}"></script>

<script src="${contextPath}/resources/js/utils/objectUtils.js?rd=${now}"></script>
<script src="${contextPath}/resources/js/utils/dateUtils.js?rd=${now}"></script>
<script src="${contextPath}/resources/js/utils/dateFormat.js?rd=${now}"></script>
<script src="${contextPath}/resources/js/utils/gridFormatter.js?rd=${now}"></script>

<script src="${contextPath}/resources/js/components/jqGridComponent.js?rd=${now}"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<script type="text/javascript">
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
</script>