<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron my-3">
		<h1>글작성</h1>
	</div>

<form action="${contextPath}/board/write" method="post" enctype="multipart/form-data">
	<div class="form-group">
		제목 : <input type="text" class="form-control" name="title">
	</div>
	<div class="form-group">
		내용 : <textarea rows="10" class="form-control" name="content"></textarea>
	</div>
	<div class="form-group">
		작성자 : <input type="text" class="form-control" name="writer">
	</div>
	<div class="form-group">
		파일명 : <input type="file" class="form-control" name="imageFileName">
	</div>
	<button class="btn btn-primary">글쓰기</button>
</form>
<div class="preview"></div>
</div>

<%@ include file="../layout/footer.jsp" %>

<script>
$(function () {
	$('input[type="file"]').on('change', function () {
		if(this.files[0]){
			let reader = new FileReader();
			reader.onload = function (e) {
				let value = e.target.result;
				if(value.startsWith("data:image/")){
					let imgTag = "<img src = '"+value+"'>";
					$('.preview').html(imgTag);
				} else{
					alert('이미지만 등록하라');
					$('input[name="imageFileName"]').val('');
					$('.preview').html('');
				}
			}
			reader.readAsDataURL(this.files[0]);
		}
	});
});
</script>
