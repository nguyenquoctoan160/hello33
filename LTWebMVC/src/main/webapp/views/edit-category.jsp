<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<c:url value="/admin/category/edit" var="edit"></c:url>
	<form role="form" action="${edit}" method="post" enctype="multipart/form-data">
	<input name="categoryId" value="${category.cateId }" hidden="">
	<div class="form-group">
		<label>Tên danh muc:</label> 
		<input type="text" class="form-control"	value="${category.cateName }" name="categoryName" />
		</div>
	<div class="form-group">
		<label>Trang thai</label>
		<input type="number" name="status" value="${category.status }" />
	</div>
	<div class="form-group">
		<label>Ảnh đại diện:</label>
		<input type="file" name="images" value="${category.images}"/>
		<c:url value="/image?fname=${category.images}" var="imgUrl"></c:url>
		<img class="img-responsive" width="100px" src="${imgUrl}" alt="">
	</div>
	<button type="submit" class="btn btn-default">Edit</button>
	<button type="reset" class="btn btn-primary">Reset</button>
	</form>
</body>
</html>