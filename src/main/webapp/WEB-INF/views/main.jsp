<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach items="${promotionList}" var="promotionList">
	${promotionList.toString()}</br>
</c:forEach>
<c:forEach items="${categoryList}" var="categoryList">
	${categoryList.toString()}</br>
</c:forEach>
<c:forEach items="${productList}" var="productList">
	${productList.toString()}</br>
</c:forEach>

</body>
</html>