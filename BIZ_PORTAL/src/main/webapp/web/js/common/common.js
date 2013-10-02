/**
 * <pre>
 *   Page move function
 * </pre>
 * @author Jong Pil Kim
 * @since 2013. 08. 20
 * @param movePage : Move Page Number
 */
 getPage = function(movePage) {
	var form = $('form');
	form.attr({'method':'POST','action':form.find('#target').val()});
	form.find('#num').val(movePage);
	form.submit();
 };
 
 /**
  * <pre>
  *   Type 별 Data 검증
  * </pre>
  * @author Jong Pil Kim
  * @since 2013. 08. 27
  * @param type : 검증 유형, data : 검증 값
  */
 typeCheck = function(type, data){
 	
 	var result = false;
 	switch (type) {
 		case 'emailCheck'	:	
 			var emailReg = /(\w+\.)*\w+\@(\w+\.)+\w+/;
 			if(!emailReg.test(data)){
 				result =  false;
 			}else{
 				result =  true;
 			}
 		break;
 		
 		case 'koreanStrCheck' :
 			var hangulReg = /[^a-zA-Z0-9]/;
 			if(hangulReg.test(data)){
 				result = false;	
 			}else {
 				result = true;	
 			}
 		break;
 	
 		case 'regNumCheck' :
 			weight = new Array(2,3,4,5,6,7,8,9,2,3,4,5);
 			totalsum = 0;	
 			parity = 0;
 			genderNumber = parseInt(data.charAt(6));
 			if(data.length != 13){
 				return false;
 			}
 			for(var i=0; i<data.length-1; i++){
 				totalsum = totalsum + (parseInt(data.charAt(i)) * weight[i]);	
 			}
 			if(totalsum > 0){
 				modTotal = (totalsum % 11);
 				
 				if(modTotal == 0) {
 					parity = 1;
 				} else if (modTotal == 1) {
 					parity = 0;
 				} else {
 					parity = 11 - modTotal;	
 				}
 				
 				if(parity == data.charAt(12)){
 					return true;
 				}else{
 					return false;
 				}
 			}else{
 				return false;
 			}
 		break;
 		
 		case 'businessNoCheck' :
 			var sum = 0;
 	        var buninessNo =new Array(10);
 	        var checkValue =new Array(1,3,7,1,3,7,1,3,5);
 	        for(var i=0; i<10; i++) { buninessNo[i] = data.substring(i, i+1); }
 	        for(var i=0; i<9; i++) { sum += buninessNo[i]*checkValue[i]; }
 	        sum = sum + parseInt((buninessNo[8]*5)/10);
 	        sidliy = sum % 10;
 	        sidchk = 0;
 	        if(sidliy != 0) { sidchk = 10 - sidliy; }
 	        else { sidchk = 0; }
 	        if(sidchk != buninessNo[9]) { return false; }
 	        return true;
 		break;
 		
 		case 'corpNoCheck' :
 			data = replaceAll(data,'-','');

 			if (data.length != 13){
 			   return false;
 			}

 			var corpNo  = data.split("");
 			var checkValue   = new Array(1,2,1,2,1,2,1,2,1,2,1,2);
 			var iSumBusinessNo  = 0;
 			var iCheckDigit = 0;

 			for (i = 0; i < 12; i++){
 			  iSumBusinessNo +=  eval(corpNo[i]) * eval(checkValue[i]);
 			}

 			iCheckDigit = 10 - (iSumBusinessNo % 10);

 			iCheckDigit = iCheckDigit % 10;

 			if (iCheckDigit != corpNo[12]){
 			  return false;
 			}
 			return true;
 		break;
 		
 		case 'numCheck' :
 			var numReg = /^[0-9]+$/;
 			if(!numReg.test(data)){
 				return false;
 			}
 			return true;
 		break;
 	}
 	return result;
 };
 
 /**
  * <pre>
  *   숫자 입력 체크 함수 Function
  * </pre>
  * @param obj : Check 할 Object
  *	     maxsize : 입력되는 숫자의 max범위
  */
 checkNumber = function(obj, maxsize) {
 	result = false;
 	if(/[^0-9]/g.test(obj.val())) {
 		alert("숫자만 입력가능합니다.");
 		obj.val('');
 		obj.focus();
 		result = true;
 	}
 	if(maxsize>0){
 		if(obj.val() > maxsize)	{
 				alert(maxsize + " 이내의 숫자만 입력가능합니다.");
 				obj.val('');
 		 		obj.focus();
 				result = true;
 		}
 	}
 	return result;
 };
 
 /**
  * <pre>
  *   문자열 BYTE CHECK 함수
  * </pre>
  * @param str : 검증값
  */
 getByteLength = function(str){
 	
 	var len = 0;
 	
 	if(str == null || str == ''){
 		return 0;
 	}
 	
 	for(var i=0; i<str.length; i++){
 		var ch = escape(str.charAt(i));
 		if(ch.length == 1){
 			len ++;
 		}else if(ch.indexOf("%u") != -1){
 			len += 2;
 		}else if(ch.indexOf("%") != -1){
 			len += ch.length / 3;
 		}		
 	}
 	
 	return len;
 	
 };
 
 /**
  * <pre>
  *   문자열 BYTE CHECK 후 검증 로직 함수
  * </pre>
  * @param str : 검증값, maxbyte : 최대 byte 수
  */
 getMaxByteValidate = function(obj, maxbyte){
 	
 	var len = 0;
 	
 	if(obj.val() == null || obj.val() == ''){
 		return 0;
 	}
 	
 	for(var i=0; i<obj.val().length; i++){
 		var ch = escape(obj.val().charAt(i));
 		if(ch.length == 1){
 			len ++;
 		}else if(ch.indexOf("%u") != -1){
 			len += 2;
 		}else if(ch.indexOf("%") != -1){
 			len += ch.length / 3;
 		}		
 	}
 	
 	if(!(len<=maxbyte)){
 		alert(obj.attr('title') + ' 입력 값이 너무 깁니다.');
 		obj.focus();
 		return false;
 	} else {
 		return true;
 	}
 	
 };
 
 /**
  * 문자열 치환 함수
  * 자바의 replaceAll 치환 함수를 만듬.
  * 
  * @param input : 치환대상 문자열
  * @param search : target 문자열
  * @param replace : replace 문자열
  * @return 치환결과 문자열
  */
 replaceAll = function(input,search,replace){
 	while(input.indexOf(search) != -1){
 		input = input.replace(search,replace);
 	}
 	return input;
 };
 
 
 /**
 * PopUp Windows 함수 정의
 * @param url : 팝업 창 주소
 *        winName : 팝업 창 이름
 *        width : 팝업창 가로크기
 *        height : 팝업창 세로크기
 */
 winOpenPopup = function(url,winName,width,height,scrolling) {
 	
 	winLeft = screen.width/2 - width/2;
 	winTop = screen.height/2 - height/2;

 	attribute = "width=";
 	attribute += width;
 	attribute += ",height=";
 	attribute += height;
 	attribute += ",scrollbars=" + scrolling;
 	attribute += ",menubar=no";
 	attribute += ",resizable=no";
 	attribute += ",status=no";
 	attribute += ",toolbar=no";
 	attribute += ",directories=no";
 	attribute += ",left=";
 	attribute += winLeft;
 	attribute += ",top=";
 	attribute += winTop;
 	
 	window.open(url,winName,attribute);
 };
 
 /**
  * <pre>
  *   숫자 ,를 추가하는 함수
  * </pre>
  * @param obj : Check 할 Object
  *	     maxsize : 입력되는 숫자의 max범위
  */
addComma  = function(number) {
	var reg = /(^[+-]?\d+)(\d{3})/;
    var str = number;
    while (reg.test(str)) {
	   str = str.replace(reg, '$1' + ',' + '$2');
    }
 	return str;
 };