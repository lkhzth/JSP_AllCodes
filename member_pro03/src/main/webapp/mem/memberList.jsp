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
	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<c:forEach items="${memberList }" var="vo">
			<tr>
				<td>${vo.mno }</td>
				<td>${vo.id }</td>
				<td>${vo.pwd }</td>
				<td>${vo.name }</td>
				<td>${vo.email }</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>