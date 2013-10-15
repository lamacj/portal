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

<script type="text/javascript">
$(document).ready(function(){
	jQuery.support.cors = true; 	 
	//공통 함수 : 전체 공지사항 List 검색  
	 getList('',1);
	 $("#notice").hide();
	 
	
	//검색 버튼 : 검색관련 공지사항 List 검색  
	 $('#btn_search').click(function(){
	    var searchText = $("#searchText").val();
	    var num =1;
	    getList(searchText,num);
	  });
     
     
	 /**
	  * <pre>
	  *    Ajax를 활용한 Paging 처리 함수
	  * </pre>
	  * @author JUNG MI KIM
	  * @since 2013. 09. 26
	  */
	 getAjaxPage = function(num){
	 	 $numParam = num;
	 	
	 	 var searchText = $("#searchText").val();
	 	 getList(searchText,num);
	 };
	 
});

//공통함수 (Ajax) - 조회 List
function getList(searchText,num){
	 
	 $.ajax({
			url: "${HOME}/help/getNoticeListAjaxView.do",
			crossDomain: true,
			type: "post",
			dataType: "html",
			data:{searchText:searchText,
				  num:num},
			async: false,
			error: function(result){
				alert(result);
			},
			success: function(result){
				
				$("#notice").hide();
				$("#noticeListDiv").show();
				
				$("#noticeList").html(result);
				var getPage = $("#getPage").val();
				$("#getPageView").html(getPage);
			}
		}
	); 
}

function getNotice(ntcId){
	  
	location.href = '${HOME}/help/getNotice.do?ntcId='+ntcId;
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
			
			<div id="noticeListDiv">
				<div id="noticeList">
				</div>
				<div class="btmBtnWrap pageBtnBox">
					<div class="paging" id="getPageView">
					</div>
				</div>
			
				<fieldset class="faqSearch">
					<legend>공지사항 검색</legend>
					<label for="srhSel">SEARCH</label>
					<select id="srhSel" name="search">
						<option value="titleWithBody">전체</option>
						<!-- <option>가입절차</option>
						<option>이용방법</option>
						<option>요금관련</option>
						<option>기타</option> -->
					</select>
					<input type="text" class="txtInput bgSearch" title="검색어 입력" name="searchText" id="searchText" onclick="this.className='txtInput'" /><button type="button" id="btn_search" class="btn_search">검색</button>
				</fieldset>
			
			
			</div>
			
			<div id="notice">
			</div>
			
		</section>
		
	
	<!-- //content -->
	</div>
	<!-- //contentArea -->
	
</body>
</html>





