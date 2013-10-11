<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 거래처 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="sBox" value="${sBox}"/>
<c:set var="total" value="${result.total}"/>
<c:set var="mainList" value="${result}"/> 
	
 <table width="600" cellspacing="0">
   <tr align="center" bgColor="#cccccc">
	   <td width="25%" class="tt" align="left">제   목</td>
	   <td width="25%" class="tt" align="left">내   용</td>
	   <td width="25%" class="tt">날   짜</td>
   </tr>
   
   <tr align="center" bgColor="#cccccc">
	   <td width="25%" class="td" align="left"><c:out value="${result.TL_NM}"/></td>
	   <td width="25%" class="td" align="left"><c:out value="${result.RMK_TXT}"/></td>
	   <td width="25%" class="td"><fmt:formatDate value="${result.REG_DT}"  pattern="yyyy/MM/dd"/></td>
   </tr>

	<tr>
		<td>
			<a href="${HOME}/help/getNoticeList.do" id="btn_search"> 목록 </a>
		</td>
	</tr>
</table>




