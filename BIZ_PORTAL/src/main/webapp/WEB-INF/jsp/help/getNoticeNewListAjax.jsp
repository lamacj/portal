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
<c:set var="noticeNewList" value="${result.noticeNewList}"/> 

		<c:forEach var="result" items="${noticeNewList}" varStatus="status"> 
		<li><a href="#"><c:out value="${result.TL_NM}"/></a></li>
		</c:forEach>
