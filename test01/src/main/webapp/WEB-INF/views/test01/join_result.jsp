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
이름 : ${member.name}<br>
성별 : ${member.gen}<br>
아이디 : ${member.id}<br>
주소 : ${member.addr}<br>
폰번호 : ${member.phone}<br>
이메일 : ${member.email}<br>
취미 : <c:forEach items="${hobby}" var="h">
		${h}
	</c:forEach>  
</body>
</html>