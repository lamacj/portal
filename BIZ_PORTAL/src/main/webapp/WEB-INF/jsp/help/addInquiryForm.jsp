<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>1:1문의</title>
	<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script> 
	
<script type="text/javascript">
$(document).ready(function(){
     

	 $('#btn_register').click(function(){
		/*  if(!validate()) {
				return false;
		} */
		 if(confirm('입력하신 거래처 정보를 등록하시겠습니까?')){
			 $("#frm").attr({"action":'${HOME}/help/addInquiry.do', "method":"POST"}).submit();
		 }
	 });
	 

	 $('#btn_cancel').click(function(){
		 if(confirm('문의 등록을 취소하시면\n'+ '지금 입력하신 문의 등록이\n'+'삭제됩니다 \n'+'취소하시겠습니까?')){
			 location.href = '${HOME}/main.do';
		 }else{
			 
		 }
	 });
	 
	 
	<%--1:1문의  파라미터 검증 함수--%>
	function validate() {
		
	}
	
     
});
</script>

</head>

<body>
	<b>1:1문의</b><br>
	<a>채권관리 서비스에 대해 궁금하신 사항을 질문해 주세요.</a>
	<form method="post" name="frm" id='frm'>
		<div class="table" align="center">
			<table width="700" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td width="150" bgcolor="#efefef">문의 항목</td>
					<td>
					&nbsp;&nbsp;<select name="qaType">
					<option value="0">항목을 선택하세요</option>
					<option value="1">회원정보</option>
					<option value="2">채권관리</option>
					<option value="3">신용정보</option>
					<option value="4">채권진단</option>
					<option value="5">요금</option>
					<option value="6">기타</option>
					</select></td>
				</tr>
				
				<tr>
					<td height="30" bgcolor="#efefef">이름</td>
					<td>&nbsp;&nbsp;<input type="text" name="userNm" id="userNm"/> * 성과 이름을 붙여서 입력해 주세요. </td>
				</tr>
				
				<tr>
					<td height="80" bgcolor="#efefef">이메일</td>
					<td>&nbsp;&nbsp;<input type="text" name="eMail1" id="eMail1"/> @ <input type="text" name="eMail2" id="eMail2"/>
					<select name="email3">
					<option value="0">직접입력</option>
					<option value="1">gmail.com</option>
					<option value="2">hanmail.com</option>
					<option value="3">naver.com</option>
					<option value="4">nate.com</option>
					</select>
					<br><br>&nbsp;&nbsp;* 입력하신 e-mail로 답변이 전송되오니 정확히 입력해 주시기 바랍니다.</td>
				</tr>
				
				<tr>
					<td height="30" bgcolor="#efefef">연락처</td>
					<td>&nbsp;&nbsp;<select name="telNo1" id="telNo1" >
					<option value="010">010</option>
					<option value="011">011</option>
					<option value="016">016</option>
					<option value="017">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
					</select> - <input type="text" name="telNo2" id="telNo2" size="10"/> - <input type="text" name="telNo3" id="telNo3" size="10"/> <input type="checkbox" name="sms_yn" id="sms_yn" > SMS수신
					</td>
				</tr>
				
				<tr>
					<td height="30" bgcolor="#efefef">제목</td>
					<td>&nbsp;&nbsp;<input type="text" name="tlNm" id="tlNm" size="70"/></td>
				</tr>
				
				<tr>
					<td height="100" bgcolor="#efefef">내용</td>
					<td>&nbsp;&nbsp;<textarea class="text" name="qst" id="qst" rows="5" cols="65"></textarea>
					<br>&nbsp;&nbsp;* 내용은 300자까지 입력하실 수 있습니다.</td>
				</tr>
			</table>
		</div>
		<br>
		<div class="button" align="center">
			<!-- <input type="button" value="문의 등록" id="register" name="register"/>&nbsp;&nbsp;<input type="button" value="취소" id="cancel" name="cancel"/> -->
			<a href="#" id="btn_register" name="btn_register">문의 등록</a>&nbsp;<a  href="#" id="btn_cancel" name="btn_cancel">취 소</a>
		</div>
	</form>	
</body>
</html>