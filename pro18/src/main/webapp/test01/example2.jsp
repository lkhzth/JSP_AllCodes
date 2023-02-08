<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

<h1 id="title">아이디 선택자1</h1>
<h1>아이디 선택자2</h1>
<h1 id="title">아이디 선택자3</h1>

<p class="content">클래스 선택자1</p>
<p class="content fs-20">클래스 선택자2</p>
<p class="content">클래스 선택자3</p>
<p>클래스 선택자1</p>

<ul>
	<li>태그선택자1</li>
	<li>태그선택자2</li>
	<li>태그선택자3</li>
	<li>태그선택자4</li>
</ul>

</body>
<script >

$(function () { // 문서를 다 읽으면.. 이 코드 실행
	let title = $("#title");
	console.log(title)
	
	$("#title").css("color","red");
	let titleValue1 = $("#title").html();
	let titleValue2 = $("#title").text();
	console.log(titleValue2);
	
	// $('.content').css('backgroundColor','yellow');
	$('.content').css({
		'backgroundColor' : 'yellow',
		'color' : 'green',
		'fontSize' : '24px'
	})

	$('li').css({
		'backgroundColor' : '#000',
		'color' : '#fff',
	})
});
</script>
</html>