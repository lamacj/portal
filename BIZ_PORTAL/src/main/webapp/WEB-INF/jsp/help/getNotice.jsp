<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<!--[if IE 7 ]><html class="no-js ie ie7 lte7 lte8 lte9" lang="ko"> <![endif]-->
<!--[if IE 8 ]><html class="no-js ie ie8 lte8 lte9" lang="ko"> <![endif]-->
<!--[if IE 9 ]><html class="no-js ie ie9 lte9" lang="ko"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html class="no-js" lang="ko">
<!--<![endif]-->
<head>
<title>공지사항 </title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- TODO 운영에서는 삭제  -->
<meta http-equiv="Cache-Control" content="No-Cache"/>

<link rel="stylesheet" href="${CSS}/common.css" />
<link rel="stylesheet" href="${CSS}/customer/getCustomerForm.css" />
<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script>
<script type="text/javascript" src="${JS}/common/js-pack.min.js"></script>
<script type="text/javascript" src="${JS}/common/common.js"></script>
<script type="text/javascript" src="${JS}/front/frontlib.js"></script>
<script type="text/javascript" src="${JS}/front/frontui.js"></script>
<script type="text/javascript" src="${JS}/respond/respond.src.js"></script>

<c:set var="ntcId" value="${ntcId}"/> 

<script type="text/javascript">
$(document).ready(function(){
	jQuery.support.cors = true; 	 

	 getNotice("${ntcId}");
	 
});

function getNotice(ntcId){
	jQuery.support.cors = true; 
	  $.ajax({
			url: "${HOME}/help/getNoticeAjax.do",
			crossDomain: true,
			type: "post",
			dataType: "html",
			data:{ntcId:ntcId},
			async: false,
			error: function(result){
				alert(result);
			},
			success: function(result){
				$("#notice").html(result);
			}
		}
	);}

function getNoticeList(){
	location.href = '${HOME}/help/getNoticeList.do';
}

</script>
</head>

<body>
	
	<!-- contentArea -->
	<div class="contentArea sub05"><!-- menu별 이미지 class sub00 -->
		<!-- content -->
		<section id="content">
			<h2 class="tit_sub0501">공지사항</h2>
			<p class="under_h2_sub0501">서비스 이용에 관련된 다양한 소식들을 확인하실 수 있습니다.</p>
			
			<div id="notice">
			</div>
			
		</section>
		
	
	<!-- //content -->
	</div>
	<!-- //contentArea -->
</body>
</html>





