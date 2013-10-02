<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 거래처 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="sBox" value="${sBox}"/>
<c:set var="mainList" value="${result}"/> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script> 

<TITLE> 게시판 List </TITLE>

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
	
});
</script>


</head>
<body>
	
 <hr width="600" size="2" color="#999999" align="left">
 <font size="6" face="Monotype Corsiva" color="#777777" >
 
 <ul id="noticeId"> 
				 <%
					String pageStr = (String)request.getParameter("page");
					if ("2".equals(pageStr)) {
				%>
					<li>222222</li>
				<%
					} else {
				%>
					<li>포탈 공지 사항</li>
				<%
					}
				%>
 
 </ul>
 
 </font>
 <hr width="600" size="2" color="#999999" align="left">
	<b>일대일문의</b><br>
	<a>채권관리 서비스에 대해 궁금하신 사항을 질문해 주세요</a>
	
 <table width="600" cellspacing="0">
   <tr align="center" bgColor="#cccccc">
	   <td width="10%" class="tt">No.</td>
	   <td width="25%" class="tt">제   목</td>
	   <td width="15%" class="tt">글쓴이</td>
	   <td width="25%" class="tt">내   용</td>
	   <td width="25%" class="tt">날   짜</td>
   </tr>
   
   <tr align="center" bgColor="#cccccc">
	   <td width="10%" class="td"><c:out value="${result.QA_ID}"/></td>
   		<td width="15%" class="td"><c:out value="${result.QA_TYPE}"/></td>
   		<td width="25" class="td"><c:out value="${result.QST}"/></td>
   		<td width="25%" class="td">	
   							<fmt:formatDate value="${result.REG_DT}"  pattern="yyyy-MM-dd"/> </td>
   	   <td width="25%" class="td"><c:out value="${result.ANS_YN}"/></td>
   </tr>

	<tr>
		<td>
			<a href="${HOME}/help/getInquiryList.do" id="btn_search"> 목록 </a>
		</td>
		<td>
			<a href="${HOME}/help/getInquiryForm.do" id="btn_addForm"> 일대일 문의 등록 </a>
		</td>
	</tr>
</body>
</html>





