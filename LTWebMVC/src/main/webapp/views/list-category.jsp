<%@page import="nguyenducthinh.Utils.Constant"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${categoryList}" var="cate" varStatus="STT" >
		<tr class="">
		<td>${STT.index+1 }</td>
		<c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
		<td><img height="150" width="200" src="${imgUrl}" /></td>
		<td>${cate.cateName }</td> 
		<!--theo model field name  -->
		<td>
			<div><a href="<c:url value='/admin/category/edit?cateId=${cate.cateId }'/>" class="btn btn-primary center">Sửa</a></div>
			
			<form action="<%=request.getContextPath() %>/admin/category/delete?cateId=${cate.cateId}" method="post">
				<input type="submit" value="Xóa" class="btn btn-danger">
			</form>
		</td>
		</tr>
		<br>
	</c:forEach>
	<a href="<%=request.getContextPath() %>/views/insert-category.jsp">Insert Category</a>
</body>
</html>