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
<h1>prev(),next()</h1>
<p>형요소, 동생요소</p>
<div class="content">
	content Div
	<div>
		<div>바뀌나</div>
	<ul class="test">
		<li>자손선택자1</li>
		<li>자손선택자2</li>
		<li>자손선택자3</li>
	</ul>
	<div>자식선택자1</div>
	<div>자식선택자2</div>
	<p>자식선택자3</p>
	<p>자식선택자4</p>
	</div>
</div>
</body>
<script >
$(function () {
	$('.test').prev().css('border', '1px solid blue')
	$('.test').next().css('backgroundColor', 'yellow')
	$('.test').nextAll().css('border', '1px solid red')
})
</script>
</html>