$(function() {
	$('.viewMode').hide();

// 수정모드
	$('.toModForm').on('click', function () {
		$('input[name="title"], textarea[name="content"]').attr("readonly", false);
		$('.viewMode').show();
		$(this).closest('tr').hide();
	});
	
// 뷰모드	
	$('.backViewMode').on('click', function (){
		$('input[name="title"], textarea[name="content"]').attr("readonly", true);
		$('.viewMode').hide();
		$(this).closest('tr').prev().show();
		$('.preview').html(originImg);
		$('input[type="file"]').val('');
		$('input[name="title"]').val($('input[name="title"]').val());
		$('textarea[name=content]').val('textarea[name=content]'.val());
		if(imageFile=='' || imageFile==null){
			$('.preview').html($('.preview p').html());
		}
	});
	
// 목록	
	$('.toList').on('click', function () {
		$('#viewForm').attr({
			"action" : `${contextPath}/board`,
			"method" : "get"
		}).empty().submit();
	});	
	
// 수정처리
	$('.modify').on('click', function () {
		$('#viewForm').attr({
			"action" : `${contextPath}/board/modBoard`,
			"method" : "post"
		}).submit();
	});
	
// 삭제처리
	$('.remove').on('click', function () {
		$('#viewForm').attr({
			"action" : `${contextPath}/board/removeBoard`,
			"method" : "post"
		}).submit();
	});
});
	
