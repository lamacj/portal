<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 공지사항 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="sBox" value="${sBox}"/>
<c:set var="faqList" value="${result.faqList}"/> 
<c:set var="getPage" value="${result.pcPage}"/> 


<input type="hidden" name="getPage" id="getPage" value="${result.pcPage}"/> 

<table width="600" cellspacing="0">
   
  
   <tr align="center" bgColor="#cccccc">
	   <td width="10%" class="td">분  류</td>
	  <td width="25%" class="td">제  목</td>
   </tr>
 <c:forEach var="result" items="${faqList}" varStatus="status">   
   <tr align="center" bgColor="#cccccc">
	   <td width="10%" class="td"><c:out value="${result.QCL_NM}"/></td>
	  <td width="25%" class="td"><a href="${HOME}/help/getFaq.do?faqId=${result.FAQ_ID}"><c:out value="${result.QST}"/></a></td>
   </tr>
 </c:forEach>    
	
</table>