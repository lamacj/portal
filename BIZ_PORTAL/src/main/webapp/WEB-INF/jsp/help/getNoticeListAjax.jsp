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
<c:set var="basicInfo" value="${result.basicInfo}"/> 
<c:set var="noticeList" value="${result.noticeList}"/> 
<c:set var="getPage" value="${result.pcPage}"/> 
<c:set var="getTotalCount" value="${result.getTotalCount}"/>


<input type="hidden" name="getPage" id="getPage" value="${result.pcPage}"/> 

<table class="customerTbl" summary="문의사항 목록테이블로 문의내용, 처리현황 등으로 구성되어있습니다.">
<caption>이전 문의 사항 테이블</caption>
	<thead>
	<tr>
		<th scope="col" class="num">번호</th>
		<th scope="col" class="cnt">제 목</th>
		<th scope="col" class="wdate">작성일</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="list" items="${noticeList}" varStatus="index">   
	<tr>
		<td class="num"><c:out value="${result.getTotalCount-(((result.basicInfo.num-1)*result.basicInfo.rowSize)+index.index)}"/></td>
		<td class="cnt">
			<a href="#" onclick="getNotice(${list.NTC_ID})"><c:out value="${list.TL_NM}"/></a>
			<span class="date"></span>
		</td>
		<td class="wdate"><fmt:formatDate value="${list.REG_DT}"  pattern="yyyy/MM/dd"/></td>
	</tr>
	</c:forEach> 
	</tbody>
</table>


