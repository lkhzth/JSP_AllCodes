<!-- 페이지 디렉티브 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List"
	session="true"
 	buffer="8kb"
 	autoFlush="true"
 	info="Shoppong Mall"
 	isErrorPage="false"
 	errorPage=""
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두번째 JSP 페이지</title>
</head>
<body>
<% List list; %>
<h1>Hello Jsp!</h1>
<h2>JSP 실습</h2>
<% getServletInfo(); %>
</body>
</html>