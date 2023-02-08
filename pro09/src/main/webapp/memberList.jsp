<%@page import="sec04.ex04.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 자바코드올수있다.
	
	List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	<tr>
		<th>회원번호</th>
		<th>아이디</th>
		<th>패스워드</th>
		<th>이름</th>
		<th>이메일</th>
		<th>가입일</th>
		<th>삭제</th>
	</tr>
	<% for(MemberVO vo : memberList) {%>
		<tr>
			<td><%=vo.getMno()%></td>
			<td><%=vo.getId()%></td>
			<td><%=vo.getPassword()%></td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getEmail()%></td>
			<td><%=vo.getJointDate()%></td>
			<td><a href='/pro09/member/ex04?command=delMember&mno=<%=vo.getMno()%>'>삭제</a></td>
		</tr>	
	<% }%>
</table>
</body>
</html>