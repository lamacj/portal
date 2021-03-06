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
<title>일대일 문의 </title>
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

<script type="text/javascript">

$(document).ready(function(){
	jQuery.support.cors = true; 		 
	//공통 함수 : 전체 공지사항 List 검색  
	 getList(1);
     
	 /**
	  * <pre>
	  *    Ajax를 활용한 Paging 처리 함수
	  * </pre>
	  * @author JUNG MI KIM
	  * @since 2013. 09. 26
	  */
	 getAjaxPage = function(num){
	 	 $numParam = num;
	 	
	 	 getList(num);
	 };
		 
});

//공통함수 (Ajax) - 조회 List
function getList(num){
	 
	 $.ajax({
			url: "${HOME}/help/getInquiryListAjaxView.do",
			crossDomain: true,
			type: "post",
			dataType: "html",
			data:{num:num},
			async: false,
			error: function(result){
				alert(result);
			},
			success: function(result){
				$("#inquiryList").html(result).trigger("create");
				
				var getPage = $("#getPage").val();
				$("#getPageView").html(getPage);
			}
		}
	); 
}


function getInquiry(qaId){
	
	location.href = '${HOME}/help/getInquiry.do?qaId='+qaId;
}

function getInquiryForm(){
	
	location.href = '${HOME}/help/getInquiryForm.do';
}

</script>
</head>

<body>
	
	<!-- contentArea -->
	<div class="contentArea sub05" ><!-- menu별 이미지 class sub00 -->
		<!-- content -->
		<section id="content">
			<h2 class="tit_sub0502">1:1 문의</h2>
			<p class="under_h2_sub0502">채권관리 서비스에 대해 궁금하신 사항을 질문해 주세요</p>
			<div id="inquiryListDiv">
				<h3 class="first2"><img src="${IMG}/common/h3_customer_inquiry.gif" alt="이전 문의 사항" /></h3>
			
				<div class="inquiryList" id="inquiryList"></div>
		
				<div class="btmBtnWrap pageBtnBox">
					<p class="leftBtn btnWrap">
						<a href="#" onclick="javascript:getInquiryForm()" class="btnType btn_inqpost">1:1 문의 등록</a>
					</p>
					<div class="paging" id="getPageView"></div>
				</div>
			</div>	
		</section>
		<!-- //content -->
	</div>
	<!-- //contentArea -->


</body>
</html>





