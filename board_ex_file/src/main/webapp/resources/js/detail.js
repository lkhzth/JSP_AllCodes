$(function () {
$('.viewMode').hide(); // 파일폼 숨김 / 수정,취소 버튼 숨김
	
let viewForm = $('#viewForm');
let titleObj = $('input[name="title"]');
let contentObj = $('textarea[name="content"]');
let imageFile = "${board.imageFileName}";
let pTag = $('.preview p').html();

let originImg = $('.originImg').clone();
let titleVal = titleObj.val();
let contentVal = contentObj.val();

// 수정모드
$('.toModForm').on('click', function () {
	$('input[name="title"], textarea[name="content"]').attr("readonly",false);
	$('.viewMode').show(); // 파일폼 나타내기
	$(this).closest('tr').hide();
});

//뷰모드
$('.backViewMode').on('click', function () {
	$('input[name="title"], textarea[name="content"]').attr("readonly",true);
	$('.viewMode').hide();
	$(this).closest('tr').prev().show();
	$('.preview').html(originImg); // 원본이미지 복원
	$('input[type="file"]').val(''); // 파일폼 초기화
	titleObj.val(titleVal); // 수정전 제목 복원
	contentObj.val(contentVal); // 수정전 내용 복원
	if(imageFile==''||imageFile==null){
		$('.preview').html(pTag);
	}
});

// 목록으로
$('.toList').on('click', function () {
	viewForm.attr({
		"action" : `${contextPath}/board`,
		"method" : "get"
		}).empty() // 파라미터 정보삭제
		.submit();
});

// 수정처리
$('.modify').on('click', function(){
	viewForm.attr({
		"action" : `${contextPath}/board/modBoard`,
		"method" : "post"
	}).submit();
});

// 삭제처리
$('.remove').on('click', function () {
	viewForm.attr({
		"action" : `${contextPath}/board/removeBoard`,
		"method" : "post"
	}).submit();
});


});