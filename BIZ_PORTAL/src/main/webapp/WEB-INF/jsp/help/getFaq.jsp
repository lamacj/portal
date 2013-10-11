<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 거래처 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="sBox" value="${sBox}"/>
<c:set var="total" value="${result.total}"/>
<c:set var="mainList" value="${result}"/> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script> 

<TITLE> FAQ  </TITLE>

<style type="text/css">
 a:link {text-decoration:none; color:#87aaec};
 a:visited {text-decoration:none; color:#87aaec};
 a:hover {text-decoration:none; color:orange};
 input, select,textarea {font-size:9pt; background-color:#efefef; border:1 dashed #999999; color:#d2691e};
 td {font-size:8pt; color:#996600};
 .tt {font-size:10pt; font-weight:bold; color:white};
</style>

<script type="text/javascript">
$(document).ready(function(){
	
});
</script>


</head>
<body>
	
 <hr width="600" size="2" color="#999999" align="left">
 <font size="6" face="Monotype Corsiva" color="#777777" ></font>
 <hr width="600" size="2" color="#999999" align="left">
	<b>FAQ</b><br>
	<a>고객님께서 자주 찾는 질문을 모았습니다.</a>
	
 <table width="600" cellspacing="0">
   <tr align="center" bgColor="#cccccc">
	   <td width="25%" class="td"><c:out value="${result.QST}"/></td>
	   
   </tr>
   <tr align="center" bgColor="white">
   		<td width="25%" class="td"><c:out value="${result.ANS}"/></td>
   </tr>
	<tr>
		<td>
			<a href="${HOME}/help/getFaqList.do" id="btn_search"> 목록 </a>
		</td>
	</tr>
</table>
</body>
</html>





