<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="ctxPath" value=""${pageContexe.request.contextPath }" scope="application"/>
<a href=${contextPath}/test03/memberForm.jsp">회원가입하기</a>

</body>
</html>