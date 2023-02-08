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
		$.ajax({
			type : 'post',
			url : "/pro17_/json2",
			success : function (result) {
				let data = JSON.parse(result);
				console.log(data);
			},
			error : function () {
				alert('에러');	
			}
		}); // ajax end
	}) // on end
}); // end
</script>

</html>