<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script> 

<TITLE> 공지사항 </TITLE>

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
	 getList('',1);
	 $("#notice").hide();
	 
	
	//검색 버튼 : 검색관련 공지사항 List 검색  
	 $('#btn_search').click(function(){
	    var searchText = $("#searchText").val();
	    var num =1;
	    getList(searchText,num);
	  });
		  
     //공통함수 (Ajax) - 조회 List
	 function getList(searchText,num){
		 
    	 $.ajax({
				url: "${HOME}/help/getNoticeListAjaxView.do",
				type: "post",
				dataType: "html",
				data:{searchText:searchText,
					  num:num},
				async: true,
				error: function(result){
					alert(result);
				},
				success: function(result){
					
					$("#notice").hide();
					$("#noticeList").show();
					
					$("#noticePortal").html(result);
					var getPage = $("#getPage").val();
					$("#getPageView").html(getPage);
				}
			}
		); 
     }
     
     
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

function getNotice(ntcId){
	 //alert(ntcId);
	  $.ajax({
			url: "${HOME}/help/getNoticeAjax.do",
			type: "post",
			dataType: "html",
			data:{ntcId:ntcId},
			async: true,
			error: function(result){
				alert(result);
			},
			success: function(result){
				$("#notice").show();
				$("#noticeList").hide();
				$("#notice").html(result);
				/**
				상세 정보를 봐야 하기 때문에  NoticeList를 닫아준다.  
				목록을 누르면  자바스크릡트 쿼리를 눌러서 해당 화면 페이지로 간다. 
				**/
			}
		}
	); 
	 
	  
	//location.href = '${HOME}/help/getNoticeAjax.do?ntcId='+ntcId;
}

</script>
</head>

<body>
	<b>공지사항</b><br>
	<a>서비스 이용에 관련된 다양한 소식들을 확인하실수 있습니다.</a>
	
	<hr width="600" size="2" color="#999999" align="left">
	<font size="6" face="Monotype Corsiva" color="#777777" ></font>
	<hr width="600" size="2" color="#999999" align="left">
	
	<div id="noticeList">
		<div id="noticePortal"></div>
		
		<select name="search">
			<option value="titleWithBody">제  목+내용</option>
			<!-- <option value="onlyTitle">제목</option> -->
			<!-- <option value="onlyTitle">내용</option> -->
		</select> 
		
		<input type="text" name="searchText" id="searchText"  size="20"/> 
		<a id="btn_search" href="#" > 검색 </a>
		
		<div id="getPageView"></div>
	</div>
	
	<div id="notice">
		상세화면 입니다.
	</div>
</body>
</html>









