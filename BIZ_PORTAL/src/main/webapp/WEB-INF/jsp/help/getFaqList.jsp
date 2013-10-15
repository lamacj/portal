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
<title>FAQ </title>
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
<!-- jQuery.support.cors = true;  -->

<script type="text/javascript">
$(document).ready(function(){
	jQuery.support.cors = true;
	//공통 함수 : 전체 공지사항 List 검색  
	 getList('',1,0);
	 $("#faq").hide();
	
	//검색 버튼 : 검색관련 공지사항 List 검색  
	  $('#btn_search').click(function(){
	    var searchText = $("#searchText").val();
	    var num =1;
	    getList(searchText,num,0);
	  });
	  
	  function setFaqList(id){
		   $('#searchText').val('');
		    var qclId = $(id).val();
		    var searchText = '';
		    var num =1;
		    getList(searchText,num,qclId);
		  }
	  
	//분류 버튼 : 검색관련 공지사항 List 검색   
	  $('#sortAll').click(function(){
		    
		  	setFaqList("#valSortAll");
		  });  
	//분류 버튼 : 검색관련 공지사항 List 검색   
	  $('#sort1').click(function(){
		  setFaqList("#valSort1");
		  });
	//분류 버튼 : 검색관련 공지사항 List 검색   
	  $('#sort2').click(function(){
		  setFaqList("#valSort2");
		  });

	//분류 버튼 : 검색관련 공지사항 List 검색   
	  $('#sort3').click(function(){
		  setFaqList("#valSort3");
		  });
	//분류 버튼 : 검색관련 공지사항 List 검색   
	  $('#sort4').click(function(){
		  setFaqList("#valSort4");
		  });	  
		//분류 버튼 : 검색관련 공지사항 List 검색   
	  $('#sort5').click(function(){
		  setFaqList("#valSort5");
		  });		  
	  $('#sort6').click(function(){
		  setFaqList("#valSort6");
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
	 	 
	 	 getList(searchText,num,qclId);
	 }; 
	 
});


//공통함수 (Ajax) - 조회 List
function getList(searchText,num,qclId){
	 
	 $.ajax({
				url: "${HOME}/help/getFaqListAjaxView.do",
				crossDomain: true,
				type: "post",
				dataType: "html",
				data:{searchText:searchText,
					  num:num,
					  qclId:qclId},
				async: false,
				error: function(result){
					alert(result);
				},
				success: function(result){
					$("#faqListDiv").show(); 
					$("#faq").hide();
					$("#FaqList").html(result);
					
					var getPage = $("#getPage").val();
					$("#getPageView").html(getPage);
				}
			});}
	
	
function getFaq(faqId){                 
	/* location.href = '${HOME}/help/getFaq.do?faqId='+faqId; */
	  $.ajax({
			url: "${HOME}/help/getFaqAjax.do",
			crossDomain: true,
			type: "post",
			dataType: "html",
			data:{faqId:faqId},
			async: false,
			error: function(result){
				alert(result);
			},
			success: function(result){
				$("#faq").show();
				$("#faqListDiv").hide(); 
				$("#faq").html(result);
			}
		}
	);
}	


// Class Active 설정 
function chgActive(active_name){
	$("sortAll").removeAttr("class");
	$(".faqCate").find("a").removeAttr("class");
	var currentCont = active_name; 
	$("#"+currentCont). attr("class","active"); 
}

function getFaqList(){
	location.href = '${HOME}/help/getFaqList.do'
}

</script>
</head>

<body>
	
	<!-- contentArea -->
	<div class="contentArea sub05"><!-- menu별 이미지 class sub00 -->
		<!-- content -->
		<section id="content">
			<h2 class="tit_sub0503">FAQ</h2>
			<p class="under_h2_sub0503">고객님께서 자주 찾는 질문을 모았습니다</p>
			
			<h3 class="first2"><img src="${IMG}/common/h3_customer_faq.gif" alt="자주 찾는 질문" /></h3>
	
			<ul class="faqCate" >
				<li> <a id ="sortAll" href="#" class="active" onclick="javascript:chgActive('sortAll')">전체</a>
					 <input type="hidden" name="valSortAll" id="valSortAll" value="0"></li>
				
				<li> <a id ="sort1" href="#" onclick="javascript:chgActive('sort1')">회원정보</a> 
					 <input type="hidden" name="valSort1" id="valSort1" value="1"></li>
				
				<li> <a id ="sort2" href="#" onclick="javascript:chgActive('sort2')">채권관리</a>
					 <input type="hidden" name="valSort2" id="valSort2" value="2"></li>
					 
				<li> <a id ="sort3" href="#" onclick="javascript:chgActive('sort3')"> 신용정보</a>
					 <input type="hidden" name="valSort3" id="valSort3" value="3"></li>
					 
				<li> <a id ="sort4" href="#" onclick="javascript:chgActive('sort4')">채권진단</a>
					 <input type="hidden" name="valSort4" id="valSort4" value="4"></li>
					 
				<li> <a id ="sort5" href="#" onclick="javascript:chgActive('sort5')">요금관련</a>
					 <input type="hidden" name="valSort5" id="valSort5" value="5"></li>
					 
				<li> <a id ="sort6" href="#" onclick="javascript:chgActive('sort6')">기타</a> 
					 <input type="hidden" name="valSort6" id="valSort6" value="6"></li>
			</ul>
	
			
			<div id="faqListDiv">
				<fieldset class="faqSearch">
					<legend>채권 관리 검색</legend>
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
		
				<div class="faqList">
					<div id="FaqList"></div>
				</div>
				
				<div class="btmBtnWrap pageBtnBox">
					<div class="paging" id="getPageView"></div>
				</div>
			</div>
			
			<div id="faq"></div>
	
		</section>
	
		<!-- //content -->
	</div>
	<!-- //contentArea -->
	
</body>
</html>





