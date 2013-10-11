<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script> 

<TITLE> 일대일 문의  </TITLE>

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
	 getList(1);
	
     //공통함수 (Ajax) - 조회 List
	 function getList(num){
		 
    	 $.ajax({
				url: "${HOME}/help/getInquiryListAjaxView.do",
				type: "post",
				dataType: "html",
				data:{num:num},
				async: true,
				error: function(result){
					alert(result);
				},
				success: function(result){
					$("#inquiryPortal").html(result);
					
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
	 	
	 	 getList(num);
	 };
		 
});

</script>
</head>

<body>
	<b>1:1문의</b><br>
	<a>채권관리 서비스에 대해 궁금하신 사항을 질문해 주세요.</a>
	
	<font size="6" face="Monotype Corsiva" color="#777777" ></font>
	<hr width="600" size="2" color="#999999" align="left">
	
	<div id="inquiryPortal"></div>
	
	<div id="getPageView"></div>
	
	<a href="${HOME}/help/addInquiryForm.do" id="btn_inquiryAdd"> 일대일 문의 등록 </a>
</body>
</html>





