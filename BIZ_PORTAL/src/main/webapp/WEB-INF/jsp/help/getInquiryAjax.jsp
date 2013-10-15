<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "GET,POST");
response.setHeader("Access-Control-Max-Age", "360");
response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
%>

<!-- 거래처 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="PreNext" value="${result.PreNext}"/>
<c:set var="inquiryList" value="${result.inquiryList}"/> 


		<article class="inquiryView">
			<div class="subject">
				<h3><c:out value="${inquiryList.TL_NM}"/></h3>
				<span class="state"><c:out value="${inquiryList.ANS_YN}"/></span>
			</div>
			<ul>
				<li>접수 일자 : <fmt:formatDate value="${inquiryList.REG_DT}"  pattern="yyyy-MM-dd"/></li>
				<li>답변 일자 : <fmt:formatDate value="${inquiryList.UPD_DT}"  pattern="yyyy-MM-dd"/></li>
			</ul>
			<p>
				<c:out value="${inquiryList.QST}"/>
			</p>
			<dl class="reply">
				<dt>답변 내용 :</dt>
				<dd>
					<c:out value="${inquiryList.ANS}"/>
				</dd>
			</dl>
		</article>

 		<div class="inquiryList2">
			<dl>
				<dt>이전 글</dt>
				<dd>
					<p><a href="#"  onclick="javascript:getInquiry(${PreNext.PRE_QA_ID})"><c:out value="${PreNext.PRE_TL_NM}"/></a></p>
					<span class="state wait"><c:out value="${PreNext.PRE_ANS_YN}"/></span>
				</dd>
			</dl>
			<dl>
				<dt>다음 글</dt>
				<dd>
					<p><a href="#"  onclick="javascript:getInquiry(${PreNext.AFTER_QA_ID})"><c:out value="${PreNext.AFTER_TL_NM}"/></a></p>
					<span class="state"><c:out value="${PreNext.AFTER_ANS_YN}"/></span>
				</dd>
			</dl>
		</div>
		
		<div class="btnWrap btnCustomer02" >
			<a href="#" onclick="javascript:getList()" id="btn_search" class="btnType">목록</a>
			<a href="#" onclick="javascript:getInquiryForm()" id="btn_addForm" class="btn_inqpost">1:1 문의 등록</a>
		</div>
	
	<!-- 이전 문의 사항  -->
	<!-- <div id="preAndNextView"> </div> -->
	
	
	
	




