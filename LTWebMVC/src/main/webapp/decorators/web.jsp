<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
	<c:url value="/template/css/style.css" var="myUrl"></c:url>
	    <!-- Site meta -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <title>Free Bootstrap 4 Ecommerce Template</title>
	    <!-- CSS -->
	    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
	    <link href="${myUrl}" rel="stylesheet" type="text/css">
	</head>
	<body>
		<%@ include file="/common/web/header.jsp"%>​ ​
		<!-- body -->
		<dec:body />
		<!-- body -->
		<!--=== Footer v4 ===-->
		<jsp:include page="/common/web/footer.jsp"></jsp:include>​
		<!--=== End Footer v4 ===-->
		
	<!-- JS -->
		<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>