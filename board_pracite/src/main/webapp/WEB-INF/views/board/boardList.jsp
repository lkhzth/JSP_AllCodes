<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>
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
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list}" var="b">
			<tr>
				<td>${b.bno}</td>
				<td>${b.title}</td>
				<td>${b.content}</td>
				<td>${b.writer}</td>
				<td>${b.writeDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>