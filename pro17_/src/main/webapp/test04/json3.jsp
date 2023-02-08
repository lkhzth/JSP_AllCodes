<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.2/jquery.min.js"></script> 
</head>
<body>
<button id="checkJson">출력</button>
<div class="output"></div>


</body>

<script>
$(function () {
	
	
	$('#checkJson').on('click', function () {
		let jsonStr = '{"name":"박지성","age":25,"gender":"남자","nickname":"두개의심장"}';
		let jsonInfo = JSON.parse(jsonStr);

		let output = "회원정보<br>";
		output += "이름 : " + jsonInfo.name + "<br>"
		output += "나이 : " + jsonInfo.age + "<br>"
		output += "성별 : " + jsonInfo['gender'] + "<br>"
		output += "별명 : " + jsonInfo['nickname']
			
		$('.output').html(output);
	}); // on end
	
}); // end
</script>
</html>