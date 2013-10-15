<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<!--[if IE 7 ]><html class="no-js ie ie7 lte7 lte8 lte9" lang="ko"> <![endif]-->
<!--[if IE 8 ]><html class="no-js ie ie8 lte8 lte9" lang="ko"> <![endif]-->
<!--[if IE 9 ]><html class="no-js ie ie9 lte9" lang="ko"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--><html class="no-js" lang="ko"> <!--<![endif]-->
<head>
<title>Portal - 고객 지원</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="web/css/common.css" />
<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script> 
<script type="text/javascript">
$(document).ready(function(){
	
	 $.ajax({
			url: "${HOME}/help/getNoticeNewListAjaxView.do",
			type: "post",
			dataType: "html",
			async: true,
			error: function(result){
				alert(result);
			},
			success: function(result){
				$("#noticeAjax").html(result);
			}
		}
	); 
	 
});
</script>

<script type="text/javascript">
</script>
</head>

<body>

<div class="wrap">
	<!--  Top Area Start -->
	<!-- Top Area End -->

	<!-- mainArea -->
	<div class="mainArea">
		<section id="listWrap">
			<div class="notice">
				<h2>공지사항</h2>
				<ul>
					<li><a href="${HOME}/help/getNoticeList.do">공지사항</a>
				</ul>
						<!-- <div id="noticeAjax"></div> 채권 Ajax TEST-->
			</div>
			
			<div class="inquiry">
				<h2>1:1문의</h2>
				<ul>
					<li><a href="${HOME}/help/getInquiryForm.do">1:1문의</a></li>
				</ul>
			</div> 
			<div class="faq">
				<h2>FAQ</h2>
				<ul>
					<li><a href="${HOME}/help/getFaqList.do">FAQ</a></li>
				</ul>
			</div>
		</section>
	</div>
	<!-- //mainArea -->
</div>
</body>
</html>