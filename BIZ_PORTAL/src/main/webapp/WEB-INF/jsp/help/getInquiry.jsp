<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 거래처 검색 결과 및 요청 파라미터 변수 세팅 -->
<c:set var="PreNext" value="${result.PreNext}"/>
<c:set var="inquiryList" value="${result.inquiryList}"/> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script> 

<TITLE> 게시판 List </TITLE>

<style type="text/css">
 a:link {text-decoration:none; color:#87aaec};
 a:visited {text-decoration:none; color:#87aaec};
 a:hover {text-decoration:none; color:orange};
 input, select,textarea {font-size:9pt; background-color:#efefef; border:1 dashed #999999; color:#d2691e};
 td {font-size:8pt; color:#996600};
 .tt {font-size:10pt; font-weight:bold; color:white};
</style>

<script type="text/javascript">
//var rowSize = inquiryList.QA_ID;
//alert(rowSize);
 $(document).ready(function(){
	/* $.ajax({
		url: "${HOME}/help/getInquiryPreAndNextViewListAjaxView.do",
		type: "post",
		dataType: "html",
		date:{rowSize:rowSize},
		async: true,
		error: function(result){
			alert(result);
		},
		success: function(result){
			$("#preAndNextView").html(result);
			}
		}
	);  */

}); 
</script>


</head>
<body>
	
 <font size="6" face="Monotype Corsiva" color="#777777" ></font>
	<b>일대일문의</b><br>
	<a>채권관리 서비스에 대해 궁금하신 사항을 질문해 주세요</a>
 <hr width="600" size="2" color="#999999" align="left">
 	<table width="600" cellspacing="0">
	   <tr align="center" bgColor="white">
		   <!-- <td width="10%" class="tt">No.</td> -->
		   <!-- <td width="15%" class="tt">문의사항</td> -->
		   <td width="30%" class="tt">문의 내용</td>
		   <td width="15%" class="tt">문의일자</td>
		   <td width="20%" class="tt">처리현황</td>
		   <td width="35%" class="tt">내     용</td>
		   
	   </tr>
	   <tr align="center" bgColor="#cccccc">
	    
	   		<td width="30" class="td"><c:out value="${inquiryList.TL_NM}"/></td>
	   		<td width="15%" class="td">	
	   							<fmt:formatDate value="${inquiryList.REG_DT}"  pattern="yyyy-MM-dd"/> </td>
	   		<td width="20%" class="td"><c:out value="${inquiryList.ANS_YN}"/></td>					
		   
	   		<td width="35%" class="td"><c:out value="${inquiryList.QST}"/></td>
	   		<%-- <td width="10%" class="td"><c:out value="${result.QA_ID}"/></td> --%>
	   </tr>
	</table>
	
	<hr width="600" size="2" color="#999999" align="left">
	
	<table width="600" cellspacing="0">
	   <tr align="center" bgColor="white">
		   <td width="50%" class="tt">답변내용</td>
		   <td width="50%" class="tt">답변 일자</td>
	   </tr>
	   <tr align="center" bgColor="#cccccc">
	   		<td width="50" class="td"><c:out value="${inquiryList.ANS}"/></td>
	   		<td width="50%" class="td">	
	   							<fmt:formatDate value="${inquiryList.UPD_DT}"  pattern="yyyy-MM-dd"/> </td>
	   </tr>
	</table>
	


	<table>
		<tr>
			<td> 이전글 : <a href="${HOME}/help/getInquiry.do?qaId=${PreNext.PRE_QA_ID}"><c:out value="${PreNext.PRE_TL_NM}"/></a>  <c:out value="${PreNext.PRE_ANS_YN}"/></td> 
			
		</tr>
		<tr> 
			<td> 다음글 : <a href="${HOME}/help/getInquiry.do?qaId=${PreNext.AFTER_QA_ID}"><c:out value="${PreNext.AFTER_TL_NM}"/></a>  <c:out value="${PreNext.AFTER_ANS_YN}"/></td>
		</tr>
	</table>

	<hr width="600" size="2" color="#999999" align="left">
	
	<!-- 이전 문의 사항  -->
	<div id="preAndNextView"> </div>
	<table>
		<tr>
			<td>
				<a href="${HOME}/help/getInquiryList.do" id="btn_search"> 목록 </a>
			</td>
			<td>
				<a href="${HOME}/help/addInquiryForm.do" id="btn_addForm"> 일대일 문의 등록 </a>
			</td>
		</tr>
	</table>
</body>
</html>





