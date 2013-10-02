function showMessage(msg){
	alert(msg);
}

function refreshNotice(){
	var strHtml = '<li><a href="#">가가가가</a></li>' +
					'<li><a href="#">나나나나</a></li>' +
					'<li><a href="#">시시시시</a></li>';
	$("#noticeId").html(strHtml);
}

function refreshNoticeAjax(){
	$.ajax({
			url: "http://localhost:8089/SampleAjax/notice.jsp",
			type: "post",
			dataType: "html",
			async: true,
			error: function(result){
				alert(result);
			},
			success: function(str){
				$("#noticeId").html(str);
			}
		}
	);
}

