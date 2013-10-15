<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "GET,POST");
response.setHeader("Access-Control-Max-Age", "360");
response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
%>

<c:set var="result" value="${result.userInfo}"/> 

<script type="text/javascript">
$(document).ready(function(){
	jQuery.support.cors = true; 
	
	
	//Registor Button Action
	 $('#btn_register').click(function(){
		  if(!validate()) {
			return false;
		  }
		  if(confirm('입력하신 정보를 등록하시겠습니까?')){
		  //alert("success");
			$.ajax({
				url: "${portalDomain}/help/addInquiry.do",
				type: "POST",
				crossDomain: true,
				data:$("#frm").serialize(),
				dataType: "json",
				async: false,
				success: function(result){
					//alert(result);
					var qaId = result.model.qaId;
					//location.href = '${HOME}/help/getInquiry.do?qaId='+qaId;
					getInquiry(qaId);
					}
				}); 
		  }else{
			//location.href = '${HOME}/help/addInquiryForm.do';
		  }
		 });
	 
	 //Cancel Button Action
	 $('#btn_cancel').click(function(){
		 if(confirm('문의 등록을 취소하시면\n'+ '지금 입력하신 문의 등록이\n'+'삭제됩니다 \n'+'취소하시겠습니까?')){
			 //location.href = '${HOME}/help/addInquiryForm.do';
			getInquiryForm();
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

<body>

	<form method="post" name="frm" id='frm'>
		<input type="hidden" name="ctnId" id="ctnId" value="2"/> 
		<input type="hidden" name="qstType" id="qstType" value="I"/> <!-- I : 개인회원 --> 
		<input type="hidden" name="qstId" id="qstId" value="${result.LOGIN_ID}"/> <!-- 현재 LOG_IN : 질문식별자 --> 
		
				
		<fieldset class="inquiryFrm">
			<legend>1:1 문의사항 입력</legend>
			<table summary="문의사항 입력 테이블로 이름, 이메일, 연락처, 제목, 내용으로 구성되어있습니다.">
			<caption>1:1 문의사항 입력</caption>
				<colgroup>
					<col class="colm01" />
					<col class="colm02" />
				</colgroup>
				<tr>
					<th scope="row"><label for="qclId">문의항목</label> <em>*</em></th>
					<td class="ctype">
						<select id="qclId" name="qclId">
							<option value="0">항목을 선택하세요</option>
							<option value="1">회원정보</option>
							<option value="2">채권관리</option>
							<option value="3">신용정보</option>
							<option value="4">채권진단</option>
							<option value="5">요금</option>
							<option value="6">기타</option>
						</select>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="userNm">이름</label> <em>*</em></th>
					<td class="cname">
						<input type="text" id="userNm" name="userNm" class="txtInput" readonly="readonly"  />
						<span class="cmt"><i>*</i> 성과 이름을 붙여서 입력해 주세요.</span>
					</td>
				</tr>
				<tr>
					<th scope="row">이메일 <em>*</em></th>
					<td class="cemail">
						<input type="hidden" id="emailType01" class="txtInput" /> 
						<div id="emailType02">
							<input type="text" class="txtInput" name="eMail1" id="eMail1"  value="${emails[0]}" title="이메일 주소" />
							@ <input type="text" class="txtInput" name="eMail2" id="eMail2" value="${emails[1]}" title="이메일 도메인" /> 
							<select title="이메일 도메인 선택" name="email3" id="email3">
								<option value="0">직접입력</option>
								<option value="gmail.com">gmail.com</option>
								<option value="hanmail.com">hanmail.com</option>
								<option value="naver.com">naver.com</option>
								<option value="nate.com">nate.com</option>
							</select>
						</div>
						<span class="cmt"><i>*</i> 입력하신 e-mail로 답변이 전송됩니다.</span>
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="telNo1">연락처</label> <em>*</em></th>
					<td class="cphone">
						<select id="telNo1" name="telNo1" title="연락처 앞자리" >
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="018">018</option>
							<option value="019">019</option>
							<option value="02">02</option>
						</select> - 
						<input type="text" class="txtInput" name="telNo2" id="telNo2" title="연락처 중간자리" /> -
						<input type="text" class="txtInput" name="telNo3" id="telNo3" title="연락처 뒷자리" /> 
						<input type="hidden" name="sms_yn" id="sms_yn" >
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="tlNm">제목</label> <em>*</em></th>
					<td>
						<input type="text" id="tlNm" name="tlNm" class="txtInput" /> 
					</td>
				</tr>
				<tr>
					<th scope="row"><label for="qst">내용</label> <em>*</em></th>
					<td>
						<textarea id="qst" name="qst" ></textarea>
						<span class="cmt">내용은 500자까지 입력하실 수 있습니다.</span>
					</td>
				</tr>
			</table>
		</fieldset>
	
		<div class="btnWrap btnCustomer">
			<p><em>*</em> 표시는 필수 입력 사항 입니다.</p>
			<div class="btnMiddle">
				<a href="#" class="on" id="btn_register" name="btn_register">저장</a>
				<a href="#" id="btn_cancel" name="btn_cancel">취소</a>
			</div>
		</div>
	</form>		
 
	
	
