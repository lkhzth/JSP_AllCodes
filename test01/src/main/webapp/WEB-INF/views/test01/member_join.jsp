<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${contextPath}/member/join" method="post">
	이름 : <input type="text" name="name"><br>
	성별 : <select name="gen">
			<option value="남자">남자</option>
			<option value="여자">여자</option>
		</select><br>
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="text" name="pwd"><br>
	주소 : <input type="text" name="addr"><br>
	전화번호 : <input type="text" name="phone"><br>
	이메일 : <input type="text" name="email"><br>
	
	취미  :  <input type="checkbox" name="hobby" value="축구">축구<br>
			<input type="checkbox" name="hobby" value="농구">농구<br>
			<input type="checkbox" name="hobby" value="게임">게임<br>
			<input type="checkbox" name="hobby" value="TV">TV<br>
			<input type="checkbox" name="hobby" value="영화">영화<br>
			<input type="checkbox" name="hobby" value="뮤지컬">뮤지컬<br>
		
		<button>전송</button>
</form>

</body>
</html>