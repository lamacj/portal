<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 거래처 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="sBox" value="${sBox}"/>
<c:set var="inquiryList" value="${result.inquiryList}"/> 
<c:set var="pcPage" value="${result.pcPage}"/> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script> 

<TITLE> 1:1 문의 </TITLE>

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
	 
	 
	 /**
	  * <pre>
	  *    Ajax를 활용한 Paging 처리 함수
	  * </pre>
	  * @author JUNG MI KIM
	  * @since 2013. 09. 26
	  */
	 getPage = function(num){
	 	 $numParam = num;
	 	
	 };
	
});
</script>
</head>

<body>
	<b>1:1문의</b><br>
	<a>채권관리 서비스에 대해 궁금하신 사항을 질문해 주세요.</a>
	
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
					<li>Portal 1:1 문의</li>
				<%
					}
				%>
 
 </ul>
 
 </font>
 <hr width="600" size="2" color="#999999" align="left">
 
 <a>****이전 문의 사항 내역</a>
 <table width="600" cellspacing="0">
   
   <tr align="center" bgColor="#cccccc">
	   <td width="10%" class="tt">번      호</td>
	   <td width="15%" class="tt">구      분</td>
	   <td width="35%" class="tt">문의내용</td>
	   <td width="15%" class="tt">등 록 일</td>
	   <td width="25%" class="tt">처리현황</td>
   </tr>
   
 <c:forEach var="result" items="${inquiryList}" varStatus="status">   
   <tr align="center" bgColor="#cccccc">
	   <td width="10%" class="td"><c:out value="${result.QA_ID}"/></td>
	   <td width="15%" class="td"><c:out value="${result.QA_TYPE}"/></td>
	   <td width="25" class="td"><a href="${HOME}/help/getNoticeDetail.do?ctnId=${result.QST}"><c:out value="${result.QST}"/></a></td>
	   <td width="25%" class="td">	
	   							<fmt:formatDate value="${result.REG_DT}"  pattern="yyyy-MM-dd"/>
	   </td>
	   <td width="25%" class="td"><c:out value="${result.ANS_YN}"/></td>
   </tr>
 </c:forEach>    
	<tr>
		<td>
			<a href="#" id="btn_addInquiry" > 1:1 문의 등록  </a>
		</td>
	</tr>
</table>


<div class="paging" id="getPageView">
	<c:out value="${pcPage}" escapeXml="false" />
</div>

</body>
</html>





