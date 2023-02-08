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
		let jsonStr = '{"age":[22,33,44],"name":["홍길동","이순신","임꺽정"]}';
		let jsonInfo = JSON.parse(jsonStr);

		let output = "회원나이<br>"
			output += "====================<br>"
		
		for(let age of jsonInfo.age){
			output += age + "<br>";
		}
		$('.output').html(output);
			
	}); // on end
	
}); // end
</script>
</html>