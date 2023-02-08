<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<c:if test="${not empty param.msg }">
	<c:set var="joinMember" value="${param.msg}"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>
<input type="hidden" id="joinMember" value="${joinMember}">
<table border="1">
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일</th>
		<th>삭제</th> 
		<th>수정</th>
	</tr>
<c:choose>
	<c:when test="${empty memberList}">
		<tr>
			<td colspan="8">등록된 회원이 없습니다.</td>
		</tr>
	</c:when>
	<c:otherwise>
		<c:forEach items="${memberList}" var="m">
	<tr>
		<td>${m.mno}</td>
		<td>${m.id}</td>
		<td>${m.pwd}</td>
		<td>${m.name}</td>
		<td>${m.email}</td>
		<td>${m.joinDate}</td>
		<td><a href="${contextPath}/member/delMember?mno=${m.mno}">삭제</a></td>
		<td><a href="${contextPath}/member/modifyForm?id=${m.id}">수정</a></td>
	</tr>
	</c:forEach>
	</c:otherwise>
</c:choose>
</table>
<a href="${contextPath}">메인으로</a>
</body>
</html>