<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문</title>
</head>
<body>
<% // 스크립트릿 : 모든 자바코드가능
	out.print("변수값 : " + name + "<br>");
	out.print("getName()호출 : " + getName() + "<br>");
	String test = "스크립트릿 안에 변수선언"; // 로컬변수
%>
</body>
<%!
	// 선언문 : 변수 또는 메소드 선언외 자바코드가 올 수 없음
	public String name = "듀큐"; // 필드 변수
 	public String getName(){
		return name;
	}
 	class Test{
 		
 	}
%>
</html>