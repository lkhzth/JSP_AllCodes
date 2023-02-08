<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="list" class="java.util.ArrayList"/>
<%
MemberBean vo1 = new MemberBean("son", "1234" , "손흥민", "son@exam");
MemberBean vo2 = new MemberBean("lee", "4567" , "이순신", "lee@exam");
MemberBean vo3 = new MemberBean("kim", "7894" , "김유신", "kim@exam");
list.add(vo1);
list.add(vo2);
list.add(vo3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	var : 반복할 변수 이름
	begin : 반복 시작값 , end : 반복 종료값
	step : 증가값, 기본값 : 1
 	varStatus : 반복상태의 여러가지 속성을 참조
 		-> count : 반복횟수
 		-> index : 인덱스값
 		-> first : 첫 번째 요소인지 여부
 		-> last : 마지막 요소인지 여부
 -->

<c:forEach var="i" begin="1" end="10" step="2" varStatus="loop">
	${i } : 반복횟수 : ${loop.count } <br>
</c:forEach>

<!-- 향상된 for문과 비슷함 
	item속성  : 반복대상 컬렉션 또는 배열
	var : 반복대상을 참조할 변수
-->
<br>
<c:forEach items="${list }" var="m" varStatus="loop">
	${m.id }  : 인덱스값 : ${loop.index }<br>
	<c:if test="${loop.first }">
		= 첫번째 요소입니다.
	</c:if>
	
	<c:if test="${loop.last }">
		= 마지막 요소입니다.
	</c:if>
<br>
</c:forEach>


</body>
</html>