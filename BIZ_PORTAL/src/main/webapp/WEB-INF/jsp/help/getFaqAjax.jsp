<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "GET,POST");
response.setHeader("Access-Control-Max-Age", "360");
response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
%>
 
<script type="text/javascript">
$(document).ready(function(){
	
});
</script>
	
<article class="inquiryView">
	<div class="subject">
		<h3><c:out value="${result.QST}"/></h3>
	</div>
	<%-- <ul>
		<li>접수 일자 : <fmt:formatDate value="${result.REG_DT}"  pattern="yyyy/MM/dd"/></li>
	</ul> --%>
	<p>
		<c:out value="${result.ANS}"/>
	</p>
	
</article>

<div class="btnWrap btnCustomer02">
	<a href="#" onclick="javascript:getFaqList()" class="btnType">목록</a>
</div>
	
 
