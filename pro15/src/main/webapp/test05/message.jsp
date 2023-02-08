<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty param.lang}">
	<fmt:setLocale value="ko_KR"/>
</c:if>
<c:if test="${param.lang=='en'}">	
	<fmt:setLocale value="en_US"/>
</c:if>

<fmt:bundle basename="resources.member">
	이름 : <fmt:message key="mem.name"/><br>
	주소 : <fmt:message key="mem.address"/><br>
	직업 : <fmt:message key="mem.job"/><br>
</fmt:bundle>

<br>

<c:if test="${empty param.lang}">
	<fmt:setLocale value="ko_KR"/>
</c:if>
<c:if test="${param.lang=='en'}">	
	<fmt:setLocale value="en_US"/>
</c:if>
<fmt:bundle basename="resources.shop">
	상품등록 : <fmt:message key="shop.product.add"/><br>
	상품수정 : <fmt:message key="shop.product.upt"/><br>
	상품목록 : <fmt:message key="shop.product.list"/><br>
	상품상세 : <fmt:message key="shop.product.listAll"/><br>
</fmt:bundle>

<a href="?lang=en">영어</a>
<a href="?lang=ko">한국어</a>

</body>
</html>