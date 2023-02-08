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
		
		let jsonStr = '{"name" : ["홍길동","이순신","임꺽정"]}'; // 서블릿에서 보내준 데이터라고 가정 : 문자열
		let jsonInfo = JSON.parse(jsonStr); // 문자열을 자바스크립트객체로 변환
		console.log(jsonInfo) // 결과확인
		console.log(jsonInfo.name); // name속성에 해당되는 배열
		console.log(jsonInfo.name[0]);
		console.log(jsonInfo.name[1]);
		console.log(jsonInfo.name[2]);
		
		let output = "회원이름<br>"
			output += "===================<br>"
		for(let n of jsonInfo.name){
			output += n + "<br>";
		}
		//console.log(output);
		$('.output').html(output);
		
	}); // on end
	
}); // end
</script>
</html>