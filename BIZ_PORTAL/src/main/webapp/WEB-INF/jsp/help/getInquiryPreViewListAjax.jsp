<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 공지사항 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="inquiryPreViewList" value="${result.inquiryPreViewList}"/> 
		
		<b> ** 이전 문의 사항</b>
		<c:forEach var="result" items="${inquiryPreViewList}" varStatus="status"> 
		<table>
			<tr>
				<td>
				<a href="${HOME}/help/getInquiry.do?qaId=${result.QA_ID}"><c:out value="${result.TL_NM}"/></a>
				</td>
				<td>
				<c:out value="${result.ANS_YN}"/>
				</td>
			</tr>
		</table>
		
		</c:forEach>
