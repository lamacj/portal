<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="result" value="${result.userInfo}"/> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>1:1문의</title>
	<script type="text/javascript" src="${JS}/jquery/jquery-1.9.1.js"></script> 
	
<script type="text/javascript">
$(document).ready(function(){
    
	// Ajax List 생성
	$.ajax({
		url: "${HOME}/help/getInquiryPreViewListAjaxView.do",
		type: "post",
		dataType: "html",
		async: true,
		error: function(result){
			alert(result);
		},
		success: function(result){
			$("#preView").html(result);
			}
		}
	); 
	
	//Registor Button Action
	 $('#btn_register').click(function(){
		  if(!validate()) {
			return false;
		  }
		  if(confirm('입력하신 정보를 등록하시겠습니까?')){
		  //alert("success");
			$.ajax({
				url: "${HOME}/help/addInquiry.do",
				type: "POST",
				data:$("#frm").serialize(),
				dataType: "json",
				async: false,
				success: function(result){
					var qaId = result.model.qaId;
					location.href = '${HOME}/help/getInquiry.do?qaId='+qaId;
					}
				}); 
		  }else{
			//location.href = '${HOME}/help/addInquiryForm.do';
		  }
		 });
	 
	 //Cancel Button Action
	 $('#btn_cancel').click(function(){
		 if(confirm('문의 등록을 취소하시면\n'+ '지금 입력하신 문의 등록이\n'+'삭제됩니다 \n'+'취소하시겠습니까?')){
			 location.href = '${HOME}/help/addInquiryForm.do';
			//데이터 삭제 한다.		
		 }else{
			 //데이터 삭제를 취소한다
		 }
	 });
	 
	// Email Combobox Action
	 $('#email3').change(function(){
		 $('#eMail2').val(this.value);	
		
	 });  
	 
	// 로그인 사용자 정보 표시
	 setInfo();
});

// 로그인 사용자 정보 표시
function setInfo(){
	var email= "${result.EMAIL}";
	var emails = email.split("@");
	$('#eMail1').val(emails[0]);
	$('#eMail2').val(emails[1]);
	
	var telno="${result.TEL_NO}";
	var telnos = telno.split("-");
	$('#telNo1').val(telnos[0]);
	$('#telNo2').val(telnos[1]);
	$('#telNo3').val(telnos[2]);
	
	var name= "${result.USR_NM}";
	$('#userNm').val(name);
}

//Validate
function validate() {
	
  var strQcl = document.frm.qclId.value;
	if(strQcl=="0"){
		alert("문의 항목을 선택해주세요");
		document.frm.qclId.focus();
		return;
	}
		
	
	var rex = "^[a-zA-Z][a-zA-Z0-9_\.\-]+@([a-zA-Z0-9-]{2,}\.)+([a-zA-Z]{2,4}|[a-zA-Z]{2}\.[a-zA-Z]{2})$";
	var email = $('#eMail1').val()+'@'+ $('#eMail2').val();
	if(email.match(rex)==null) {
		alert("이메일 형식을 맞춰주세요. 예)hong@businesson.co.kr");
			$('#eMail1').focus();
		return;
		}
	
	var rexPhone = "^[0-9]{2,4}-[0-9]{2,4}-[0-9]{4,4}$";
	var phone = $('#telNo1').val()+'-'+$('#telNo2').val()+'-'+ $('#telNo3').val();
	if(phone.match(rexPhone)==null) {
		alert("전화번호 형식이 잘못되었습니다.");
			$('#telNo2').focus();
		return;
		}
	if($('#tlNm').val() == "") {
		alert("제목을 입력해주세요!!");
		$('#tlNm').focus();
		return;
	}
	
	if($('#qst').val() == "") {
		alert("내용을 입력해주세요!!");
		$('#qst').focus();
		return;
	} 
	return true;
}


</script>
</head>
<body>

	<b>1:1문의</b><br>
	<a>채권관리 서비스에 대해 궁금하신 사항을 질문해 주세요.</a>
	<form method="post" name="frm" id='frm'>
	<input type="hidden" name="ctnId" id="ctnId" value="2"/> 
	<input type="hidden" name="qstType" id="qstType" value="I"/> <!-- I : 개인회원 --> 
	<input type="hidden" name="qstId" id="qstId" value="${result.LOGIN_ID}"/> <!-- 현재 LOG_IN : 질문식별자 --> 
	
		<div class="table" align="center">
			<table width="700" border="1" cellspacing="0" cellpadding="0">
				<tr>
					<td width="150" bgcolor="#efefef">문의 항목</td>
					<td>
					&nbsp;&nbsp;<select name="qclId" id="qclId">
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
					<td>&nbsp;&nbsp; <input type="text" name="userNm" id="userNm" readonly="readonly" /> </td>
				</tr>
				
				 <tr>
					<td height="80" bgcolor="#efefef">이메일</td>
					<td>&nbsp;&nbsp;<input type="text" name="eMail1" id="eMail1"  value="${emails[0]}"/> @ <input type="text" name="eMail2" id="eMail2" value="${emails[1]}"/>
					<select name="email3" id="email3" >
					<option value="0">직접입력</option>
					<option value="gmail.com">gmail.com</option>
					<option value="hanmail.com">hanmail.com</option>
					<option value="naver.com">naver.com</option>
					<option value="nate.com">nate.com</option>
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
					<option value="02">02</option>
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
			<a href="#" id="btn_register" name="btn_register">문의 등록</a>&nbsp;<a  href="#" id="btn_cancel" name="btn_cancel">취 소</a>
		</div>
	</form>	
	
	<!-- 이전 문의 사항  -->
	<div id="preView"> </div> 
	
	<a href="${HOME}/help/getInquiryList.do"> 목록  </a>
</body>
</html>