<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 거래처 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="sBox" value="${sBox}"/>
<c:set var="inquiryList" value="${result.inquiryList}"/> 
<c:set var="getPage" value="${result.pcPage}"/>

 
<input type="hidden" name="getPage" id="getPage" value="${result.pcPage}"/> 
 
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
   <td width="25" class="td"><a href="${HOME}/help/getInquiry.do?qaId=${result.QA_ID}"><c:out value="${result.QST}"/></a></td>
   <td width="25%" class="td">	
   							<fmt:formatDate value="${result.REG_DT}"  pattern="yyyy-MM-dd"/>
   </td>	   <td width="25%" class="td"><c:out value="${result.ANS_YN}"/></td>
  </tr>
 </c:forEach> 
</table>





