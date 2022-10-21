<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/admin/category/insert" method="post" enctype="multipart/form-data">
		<input type="text" name ="categoryName" placeholder="category 's name"><br>
		<!-- <input type="number" name="categoryStatus" placeholder="category 's status"><br> -->
		<input type="file" name="categoryImage" placeholder="Choose images:">
		<br>
		<input type="submit" value="Insert" />
		<input type="reset" value="Reset" />
		
	</form>
</body>
</html>