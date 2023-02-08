<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>숫자 형식화</h2>
<c:set var="price" value="1000000"/>
바로 출력 : <f:formatNumber value="${price}" type="number"/><br>
변수로 저장 : <f:formatNumber var="priceNumber" value="${price}" type="number"/><br>
${priceNumber}<br>

<h2>퍼센트</h2>
<f:formatNumber value="${price}" type="percent"/>

<h2>통화표현</h2>
원화 : <f:formatNumber value="${price}" type="currency" currencySymbol="￦" groupingUsed="false"/><br>
달러 : <f:formatNumber value="${price}" type="currency" currencySymbol="＄" groupingUsed="true"/><br>
원화 : <f:formatNumber value="${price}" type="currency" currencyCode="KRW"/><br>
달러 : <f:formatNumber value="${price}" type="currency" currencyCode="USD"/><br>
유로 : <f:formatNumber value="${price}" type="currency" currencyCode="EUR"/><br>

<!-- 
	type : number | precent | currency
	groupingUsed : 세자리마다 콤마 추가, 기본값 : true
	currencyCode : 통화 코드 지정 KRW | USD | EUR | JPY | CNY
 -->
 
 <h2>날짜 형식화</h2>
 <c:set var="now" value="<%=new Date() %>"/>
형식화 전 : ${now}<br>
형식화 후 : <f:formatDate value="${now}"/><br>
date : <f:formatDate value="${now}" type="date"/><br> <!-- 기본값 -->
time : <f:formatDate value="${now}" type="time"/><br> 
both : <f:formatDate value="${now}" type="both"/><br>

<br>
<h3>dateStyle</h3><br>
<!-- 
	full | long | medium | short 
 -->
지정하지 않음 : <f:formatDate value="${now}" type="both"/><br>
full : <f:formatDate value="${now}" type="both" dateStyle="full"/><br>
long : <f:formatDate value="${now}" type="both" dateStyle="long"/><br>
medium : <f:formatDate value="${now}" type="both" dateStyle="medium"/><br>
short : <f:formatDate value="${now}" type="both" dateStyle="short"/><br>

<h3>timeStyle</h3> 
지정하지 않음 : <f:formatDate value="${now}" type="both" /><br>
full : <f:formatDate value="${now}" type="both" timeStyle="full"/><br>
short : <f:formatDate value="${now}" type="both" timeStyle="short"/><br>
 
 <h3>직접 지정</h3>
 <f:formatDate value="${now}" pattern="yyyy년MM월dd일 a hh시mm분ss초 SS z"/>
 
 <h4>타임존 지정</h4>
<f:timeZone value="America/New York">
 	뉴욕 : <f:formatDate value="${now}" type="both" timeStyle="full"/>
</f:timeZone>

<%
	String[] local = TimeZone.getAvailableIDs();
	for(String s : local){
		out.print(s+"<br>");
	}

%>


</body>
</html>