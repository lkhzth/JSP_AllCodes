$(function () {
		$('input[type="file"]').on('change', function() {
			if(this.files[0]){
				let reader = new FileReader(); 
				reader.onload = function(e) {  
					let value = e.target.result;
					if(value.startsWith("data:image/")){
						let imgTag = `<img src="${value}">`;
						$('.preview').html(imgTag);
					} else{
						alert('이미지만 등록하세요');
						$('input[name="imageFileName"]').val('');
						$('.preview').html('');
					}
				}
				reader.readAsDataURL(this.files[0]);
			}
		});
	});