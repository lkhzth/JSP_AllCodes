<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="${contextPath}/fileDownload?fileName=tiger.png">호랑이 다운로드</a><br>
<a href="${contextPath}/fileDownload?fileName=가우르.png">가우르 다운로드</a>

</body>
</html>