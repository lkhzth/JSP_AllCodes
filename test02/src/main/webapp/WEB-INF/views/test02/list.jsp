<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<table class="table">
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
				<td><a href="${contextPath}/board/detail?bno=${b.bno}">${b.title}</a></td>
				<td>${b.content}</td>
				<td>${b.writer}</td>
				<td>${b.writeDate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${contextPath}/board/writeForm"><button class="btn btn-primary">글쓰기</button></a>
</div>

<%@ include file="../layout/footer.jsp" %>