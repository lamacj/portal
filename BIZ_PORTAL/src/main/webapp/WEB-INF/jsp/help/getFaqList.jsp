<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script> 

<TITLE> FAQ </TITLE>

<style type="text/css">
 a:link {text-decoration:none; color:#87aaec};
 a:visited {text-decoration:none; color:#87aaec};
 a:hover {text-decoration:none; color:orange};
 input, select,textarea {font-size:9pt; background-color:#efefef; border:1 dashed #999999; color:#d2691e};
 td {font-size:8pt; color:#996600};
 .tt {font-size:10pt; font-weight:bold; color:white};
</style>


<script type="text/javascript">
$(document).ready(function(){
		 
	//공통 함수 : 전체 공지사항 List 검색  
	 getList('',1,0);
	
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
	 
	//공통함수 (Ajax) - 조회 List
	  function getList(searchText,num,qclId){
		 
   	 $.ajax({
				url: "${HOME}/help/getFaqListAjaxView.do",
				type: "post",
				dataType: "html",
				data:{searchText:searchText,
					  num:num,
					  qclId:qclId},
				async: true,
				error: function(result){
					alert(result);
				},
				success: function(result){
					$("#FaqListAjax").html(result);
					
					var getPage = $("#getPage").val();
					$("#getPageView").html(getPage);
				}
			}
		); 
    }
		 
});

</script>
</head>

<body>
	<b>FAQ</b><br>
	<a>고객님께서 자주 찾는 질문을 모았습니다.</a>
	
	<hr width="600" size="2" color="#999999" align="left">
	<font size="6" face="Monotype Corsiva" color="#777777" ></font>
	<hr width="600" size="2" color="#999999" align="left">
	<!-- IF 문쓰는  법 -->
	<div><b>자주 찾는 질문</b>  <a id ="sortAll" href="#">전체</a> |
						 <input type="hidden" name="valSortAll" id="valSortAll" value="0">
						 
						 <a id ="sort1" href="#">회원정보</a> |
						 <input type="hidden" name="valSort1" id="valSort1" value="1">
						 
						 <a id ="sort2" href="#">채권관리</a> |
						 <input type="hidden" name="valSort2" id="valSort2" value="2">
						 
						 
						 <a id ="sort3" href="#">신용정보</a> |
						 <input type="hidden" name="valSort3" id="valSort3" value="3">
						 
						 <a id ="sort4" href="#">채권진단</a> |
						 <input type="hidden" name="valSort4" id="valSort4" value="4">
						 
						 <a id ="sort5" href="#">요금관련</a> |
						 <input type="hidden" name="valSort5" id="valSort5" value="5">
						 
						 <a id ="sort6" href="#">기타</a> </div>
						 <input type="hidden" name="valSort6" id="valSort6" value="6">
	<p>
	
	<select name="search">
		<option value="titleWithBody">제  목+내용</option>
		<!-- <option value="onlyTitle">제목</option> -->
		<!-- <option value="onlyTitle">내용</option> -->
	</select> 
	
	<input type="text" name="searchText" id="searchText"  size="20"/> 
	<a id="btn_search" href="#" > 검색 </a>
	
	
	<div id="FaqListAjax"></div>
	
	
	<div id="getPageView"></div>

</body>
</html>
