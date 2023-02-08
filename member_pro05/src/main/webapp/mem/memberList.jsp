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
<c:if test="${not empty loginId}">
	<h2>${loginId}님이 로그인중</h2>
	<button><a href="${ctxPath}/member/logout">로그아웃</a></button>
</c:if>

<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>삭제</td>
	</tr>
<c:forEach items="${memberList}" var="vo">
	<tr>
		<td>${vo.mno}</td>
		<td>${vo.id}</td>
		<td>${vo.pwd}</td>
		<td>${vo.name}</td>
		<td>${vo.email}<a href="#">수정</a></td>
		<td><a href="${ctxPath}/member/delMember?mno=${vo.mno}">삭제</a></td>
	</tr>
</c:forEach>
</table>
<c:if test="${empty loginId}">
	<a href="${ctxPath}/mem/joinMember.jsp">회원가입하기</a>
	<a href="${ctxPath}/mem/login.jsp">로그인</a>
</c:if>
</body>
</html>