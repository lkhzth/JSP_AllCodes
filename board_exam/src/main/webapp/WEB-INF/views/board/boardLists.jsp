<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1 style="text-align: center">자유게시판</h1>
	</div>
	
	<a href="${contextPath}/board/writeForm" class="btn btn-primary mb-2">글쓰기</a>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="5">등록된 게시물이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="b">
					<tr>
						<td>${b.bno }</td>
						<td> <a href="${contextPath}/board/findBoard?bno=${b.bno}">${b.title}</a> </td>
						<td>${b.content}</td>
						<td>${b.writer}</td>
						<td>${b.writeDate}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</div>

<%@ include file="../layout/footer.jsp" %>
</body>
</html>