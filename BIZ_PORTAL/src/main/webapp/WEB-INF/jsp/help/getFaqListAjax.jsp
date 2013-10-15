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
<c:set var="sBox" value="${sBox}"/>
<c:set var="faqList" value="${result.faqList}"/> 
<c:set var="getPage" value="${result.pcPage}"/> 


<input type="hidden" name="getPage" id="getPage" value="${result.pcPage}"/> 

<table class="customerTbl" summary="자주 찾는 질문 테이블로 분류와 제목으로 구성되어있습니다.">
<caption>자주 찾는 질문 테이블</caption>
	<thead>
	<tr>
		<th scope="col" class="cate">분류</th>
		<th scope="col" class="subj">제목</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="result" items="${faqList}" varStatus="status">   
	<tr>
		<td class="cate"><c:out value="${result.QCL_NM}"/></td>
		<td class="subj">
			<a href="#" onclick="javascript:getFaq(${result.FAQ_ID})"><c:out value="${result.QST}"/></a>
		</td>
	</tr>
	</c:forEach> 
	</tbody>
</table>




	