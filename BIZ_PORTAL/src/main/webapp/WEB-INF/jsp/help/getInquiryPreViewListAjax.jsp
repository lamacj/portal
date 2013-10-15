<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "GET,POST");
response.setHeader("Access-Control-Max-Age", "360");
response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
%>

<!-- 공지사항 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="inquiryPreViewList" value="${result.inquiryPreViewList}"/> 

	<c:forEach var="result" items="${inquiryPreViewList}" varStatus="status"> 
	<li>
		<p><a href="#" onclick="javascript:getInquiry(${result.QA_ID})" ><c:out value="${result.TL_NM}"/></a></p>
		<span class="state"><c:out value="${result.ANS_YN}"/></span>
	</li>
	</c:forEach>