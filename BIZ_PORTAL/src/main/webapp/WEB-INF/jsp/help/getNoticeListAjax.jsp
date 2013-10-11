<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- 공지사항 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="basicInfo" value="${result.basicInfo}"/> 
<c:set var="noticeList" value="${result.noticeList}"/> 
<c:set var="getPage" value="${result.pcPage}"/> 
<c:set var="getTotalCount" value="${result.getTotalCount}"/>


<input type="hidden" name="getPage" id="getPage" value="${result.pcPage}"/> 

<table width="600" cellspacing="0">
   
   <tr align="center" bgColor="#cccccc">
	   <td width="10%" class="tt">No.</td>
	   <td width="25%" class="tt" align="left">제   목</td>
	   <td width="25%" class="tt">날   짜</td>
   </tr>
   
 <c:forEach var="list" items="${noticeList}" varStatus="index">   
   <tr align="center" bgColor="#cccccc">
	   <td width="10%" class="td"><c:out value="${result.getTotalCount-(((result.basicInfo.num-1)*result.basicInfo.rowSize)+index.index)}"/></td>
	   <td width="25%" class="td" align="left"><a href="#" onclick="getNotice(${list.NTC_ID})"><c:out value="${list.TL_NM}"/></a></td>
	   <td width="25%" class="td">	
	   							<fmt:formatDate value="${list.REG_DT}"  pattern="yyyy/MM/dd"/>
	   </td>
   </tr>
 </c:forEach>    
	
</table>