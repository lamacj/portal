package com.portal.service.help;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

//import com.portal.common.enumtype.EErrorCodeType;
import com.portal.common.exception.BizException;
import com.portal.common.collection.SBox;
import com.portal.common.collection.SBoxList;
//import com.portal.common.parent.SuperController;
import com.portal.common.parent.SuperService;
import com.portal.common.util.CommonPage;
import com.portal.dao.help.InquiryDao;

/**
 * <pre>
 *    Notice Service Implements Class
 * </pre>
 * 
 * @author JUNG MI KIM
 * @since 2013. 9. 17.
 * @version 1.0
 * @package com.portal.serviceImpl.help.NoticeServiceImpl.java
 */
@Service
public class InquiryServiceImpl extends SuperService implements InquiryService {

	@Autowired
	private InquiryDao inquiryDao;
	
	@Autowired 
	private CommonPage commonPage;

	/**
	 * OVERRIDING METHOD
	 * 
	 * <pre>
	 *    1:1문의 Service Method
	 * </pre>
	 * 
	 * @author JUNG MI KIM
	 * @since 2013. 9. 11.
	 * @version 1.0
	 * @param sBox
	 *           
	 * 
	 * @return result customerList : 거래처 검색 결과 LIST,
	 */
	@Override
	@Transactional
	public SBox addInquiryForm(SBox sBox) {
		
		SBox result = new SBox();
		//SBox commonCodeBox = new SBox();
		
		try {
			
			//1. 담아있는 Sbox가져다가 DB에 넘기기
			//2. 성공코드 여부에 따라 저장하고 저장이 안되었을시 트랜젝션 취소
			//3. 성공시 reDirect해서 화면에 다시 뿌려줌
			
			// PARAMETER 초기화
			

			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");

			// Common Code 초기화
			// 공통코드 초기화[전화번호, 이메일, 핸드폰번호, 결제조건유형]
			/*commonCodeBox.set("phoneCodeList", CommonCode.phoneCodeList);
			commonCodeBox.set("emailCodeList", CommonCode.emailCodeList);
			commonCodeBox.set("cellPhoneCodeList", CommonCode.cellPhoneCodeList);
			*/// Paging 모듈 호출

			// 거래처 검색 리스트 조회
			//noticeList = inquiryDao.getNoticeList(sBox);

			// 조회 결과 저장
			//result.set("noticeList", noticeList);

		} /*catch (BizException biz) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = biz.getErrCode();
			String resultMsg = biz.getErrMsg();
			log.e("BizException EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		}*/ catch (Exception ex) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = "CU99";
			String resultMsg = ex.getMessage();
			log.e("Unknown EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} finally {

		}
		return result;
	}
	
	
	@Override
	@Transactional
	public SBox addInquiry(SBox sBox) {
		SBox resultBox = new SBox();
		try {
			//[1] INPUT PARAMETER 정제
			if (!sBox.isEmpty("ctnId")) { 
				sBox.set("ctnId", sBox.getString("ctnId")); // 컨텐츠 순번
			} else {
				sBox.set("ctnId", null);
			}
			
			// 질문자 유형
			if (!sBox.isEmpty("qstType")) { 
				sBox.set("qstType", sBox.getString("qstType")); 
			} else {
				sBox.set("qstType", null);
			}
		
			// 질문자 식별자
			if (!sBox.isEmpty("qstId")) {
				sBox.set("qstId", sBox.getString("qstId")); 
			} else {
				sBox.set("qstId", null);
			}
			
			//질문분류 식별자
			if (!sBox.isEmpty("qclId")) {
				sBox.set("qclId", sBox.getString("qclId")); 
			} else {
				sBox.set("qclId", null);
			}
			
			//이름
			if (!sBox.isEmpty("userNm")) {
				sBox.set("userNm", sBox.getString("userNm")); 
			} else {
				sBox.set("userNm", null);
			}
			
			//이메일
			if (!sBox.isEmpty("eMail1") && !sBox.isEmpty("eMail2")) {
				sBox.set("eMail", sBox.getString("eMail1") + "@" + sBox.getString("eMail2")); 
			} else {
				sBox.set("eMail", null);
			}
			//연락처
			if (!sBox.isEmpty("telNo1") && !sBox.isEmpty("telNo2") && !sBox.isEmpty("telNo3")) {
				sBox.set("telNo", sBox.getString("telNo1") + "-" + sBox.getString("telNo2") + "-" + sBox.getString("telNo3")); 
			} else {
				sBox.set("telNo", null);
			}
			
			//제목
			if (!sBox.isEmpty("smsYn")) {
				sBox.set("smsYn", "Y"); // 문의 항목
			} else {
				sBox.set("smsYn", "N");
			}
			
			//제목
			if (!sBox.isEmpty("tlNm")) {
				sBox.set("tlNm", sBox.getString("tlNm")); // 문의 항목
			} else {
				sBox.set("tlNm", null);
			}
			
			//내용
			if (!sBox.isEmpty("qst")) {
				sBox.set("qst", sBox.getString("qst")); // 문의 항목
			} else {
				sBox.set("qst", null);
			}
			
			if (!sBox.isEmpty("ansYn")) {
				sBox.set("ansYn", sBox.getString("ansYn")); // 답변완료여부
			} else {
				sBox.set("ansYn", "N");
			}
			
			if (!sBox.isEmpty("chkYn")) {
				sBox.set("chkYn", sBox.getString("chkYn")); // 답변확인여부
			} else {
				sBox.set("chkYn", "N");
			}
			
			
			if (!sBox.isEmpty("reQst")) {
				sBox.set("reQst", sBox.getString("reQst")); // 재질문여부
			} else {
				sBox.set("reQst", "N");
			}
			
			//System.out.println("!!!!!!!!!!!!inquiryService AFTER!!!!!!!!!"+sBox);
			//smsYn[N],ansYn[N],qst[회원정보 문의 내용입니다.],smsyn[on],email3[0],remoteHost[0:0:0:0:0:0:0:1],userNm[김정미],tlNm[회원정보 문의],eMail1[maytensi],eMail2[naver.com],telNo1[010],telNo2[1234],reQst[N],telNo3[5678],eMail[maytensi@naver.com],qclId[1],telNo[010-1234-5678],chkYn[N],remoteURI[/BIZ_PORTAL/help/addInquiry.do],remoteAddr[0:0:0:0:0:0:0:1]
			
			// [2] 거래처 등록
			resultBox= (inquiryDao.insertInquiry(sBox));

		} catch (Exception ex) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		} finally {

		}
			return resultBox;

		
	}
	
	
	@Override
	public SBox getInquiryList(int num){
		
		SBox sBox = new SBox();
		SBox result = new SBox();
		SBoxList<SBox>	inquiryList = null;
		try { 
			
			// PARAMETER 초기화
			sBox.setIfEmpty("num", 1); // 현재 페이지
			sBox.setIfEmpty("rowSize", 10); // 목록 갯수
			sBox.setIfEmpty("ctnId", 2); // 컨테츠 순번  portal 서비스는 = 2
			
			//user정보 코드 셋팅
			String userId = "717171717";
			sBox.set("qstId", userId);
			
			// PARAMETER값 Setting
			if(num!=0)
				sBox.set("num",num);
			
			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");
			
			// 공지사항 정보 리스트 TOTAL COUNT 조회
			int getTotalCount =inquiryDao.getTotalCount(sBox);
			
			// PC버젼 페이징 모듈 조회
			String pcPage = commonPage.getPCPagingPrint(getTotalCount, sBox.getInt("num"), sBox.getInt("rowSize"),"getAjaxPage");
			
			// 공지사항 검색 리스트 조회
			inquiryList = inquiryDao.getInquiryList(sBox);
			
			// 코드 변경
			inquiryList=getCommonCode("ANS_YN",inquiryList);
			
			
			// 조회 결과 저장
			result.set("getTotalCount",getTotalCount);
			result.set("inquiryList", inquiryList);
			result.set("pcPage", pcPage);
			result.set("basicInfo",sBox);
			
		}catch (BizException biz) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = biz.getErrCode();
			String resultMsg  = biz.getErrMsg();
			log.e("BizException EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} catch (Exception ex) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = "CU99";
			String resultMsg = ex.getMessage();
			log.e("Unknown EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} finally {

		}
		return result;
	}


	/**
	 * <pre>
	 * 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 2.
	 * @version 1.0
	 * @param qaId
	 * @return
	 */
	@Override
	public SBox getInquiryDetail(String qaId) {
		SBox result = new SBox();
		SBoxList<SBox>	inquiryList = null;
		SBox PreNext = new SBox();
		SBox sBox = new SBox();

		try {
			// PARAMETER 초기화
			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");

			
			// 거래처 검색 리스트 조회
			//result = inquiryDao.getInquiryDetail(qaId);
			String userId = "717171717";
			
			sBox.set("qaId", qaId);
			sBox.set("qstId", userId);
			inquiryList = inquiryDao.getInquiryDetail(sBox);
			
			//공통 항목 출력
			inquiryList=getCommonCode("ANS_YN",inquiryList);	
			
			//System.out.println("inquiryList ANS_YN이후"+inquiryList);
			
			//CHK_YN[N],ORDER_NUM[2],CTN_ID[2],QST_ID[123456789],SMS_YN[N],TEL_NO[010-5653-2222],QA_ID[38],USR_NM[김채권],ANS_YN[N],UPD_DT[2013-10-07 09:35:20.53],QST[채권진단 문의 내용입니다],REG_DT[2013-10-07 09:35:20.53],QST_TYPE[I],QA_RESULT_ROWNUM[31],EMAIL[cheae@naver.com],RE_QST[N],QCL_ID[4]
			if(inquiryList.size()>2){
				if(!inquiryList.get(0).isEmpty()){
					PreNext.set("PRE_TL_NM", inquiryList.get(0).get("TL_NM"));
					PreNext.set("PRE_ANS_YN", inquiryList.get(0).get("ANS_YN"));
					PreNext.set("PRE_QA_ID", inquiryList.get(0).get("QA_ID"));
				}
				if(!inquiryList.get(2).isEmpty()){
					PreNext.set("AFTER_TL_NM", inquiryList.get(2).get("TL_NM"));
					PreNext.set("AFTER_ANS_YN", inquiryList.get(2).get("ANS_YN"));
					PreNext.set("AFTER_QA_ID", inquiryList.get(2).get("QA_ID"));
				}
			}else{
				if(!inquiryList.get(0).isEmpty()){
					PreNext.set("PRE_TL_NM", inquiryList.get(0).get("TL_NM"));
					PreNext.set("PRE_ANS_YN", inquiryList.get(0).get("ANS_YN"));
					PreNext.set("PRE_QA_ID", inquiryList.get(0).get("QA_ID"));
					//PreNext.setIfEmpty("AFTER_TL_NM", "정보가 존재하지 않습니다"); // 현재 페이지
				}
			}
			
			//System.out.println("PreList"+PreNext);
			//System.out.println("NORMAL"+inquiryList.get(1));
			
			// 조회 결과 저장
			result.set("inquiryList", inquiryList.get(1));
			result.set("PreNext",PreNext);
			
		}catch (BizException biz) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = biz.getErrCode();
			String resultMsg  = biz.getErrMsg();
			log.e("BizException EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} catch (Exception ex) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = "CU99";
			String resultMsg = ex.getMessage();
			log.e("Unknown EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} finally {

		}
		return result;
	}
	
	@Override
	public SBox getInquiryPreViewList(SBox sBox){
		
		SBox result = new SBox();
		SBoxList<SBox>	inquiryPreViewList = null;
		try {
			
			// PARAMETER 초기화
			sBox.setIfEmpty("rowSize", 5); // 목록 갯수
			sBox.setIfEmpty("ctnId", 2); // 컨테츠 순번  portal 서비스는 = 2
			
			//User 정보
			String userId = "717171717";
			sBox.set("qstId", userId);
			
			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");
			
			
			
			// 공지사항 검색 리스트 조회
			inquiryPreViewList = inquiryDao.getInquiryPreViewList(sBox);
			
			// 코드 변경
			inquiryPreViewList=getCommonCode("ANS_YN",inquiryPreViewList);
			
			// 조회 결과 저장
			result.set("inquiryPreViewList", inquiryPreViewList);
			
		}catch (BizException biz) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = biz.getErrCode();
			String resultMsg  = biz.getErrMsg();
			log.e("BizException EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} catch (Exception ex) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = "CU99";
			String resultMsg = ex.getMessage();
			log.e("Unknown EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} finally {

		}
		return result;
	}
	
	@Override
	public SBox getInquiryPreAndNextViewList(SBox sBox){
		
		SBox result = new SBox();
		SBoxList<SBox>	inquiryPreViewList = null;
		try {
			
			// PARAMETER 초기화
			sBox.setIfEmpty("rowSize", 1); // 목록 갯수
			
			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");
			
			// 공지사항 검색 리스트 조회
			inquiryPreViewList = inquiryDao.getInquiryPreViewList(sBox);
			
			// 코드 변경
			inquiryPreViewList=getCommonCode("ANS_YN",inquiryPreViewList);
			
			// 조회 결과 저장
			result.set("inquiryPreViewList", inquiryPreViewList);
			
		}catch (BizException biz) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = biz.getErrCode();
			String resultMsg  = biz.getErrMsg();
			log.e("BizException EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} catch (Exception ex) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = "CU99";
			String resultMsg = ex.getMessage();
			log.e("Unknown EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} finally {

		}
		return result;
	}
	
	/**
	 * <pre>
	 * 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 9.
	 * @version 1.0
	 * @param sBox
	 * @return
	 */
	@Override
	public SBox getBaseInfo(SBox sBox) {
		
		SBox result = new SBox();
		try {
			
			// PARAMETER 초기화
			
			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");
			
			String id = "717171717"; //LOG_IN USER 정보 하드코딩
			
			sBox.set("loginId",id);
			
			// 조회 결과 저장
			result.set("userInfo", inquiryDao.getUserInfo(sBox));
			
			
			
			
		}catch (BizException biz) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = biz.getErrCode();
			String resultMsg  = biz.getErrMsg();
			log.e("BizException EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} catch (Exception ex) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			String resultCode = "CU99";
			String resultMsg = ex.getMessage();
			log.e("Unknown EXCEPTION[" + resultCode + " / " + resultMsg + "]");
		} finally {

		}
		return result;
	}
	
	
	public  SBoxList<SBox> getCommonCode(String codeNm, SBoxList<SBox> resultList){
		if(codeNm=="ANS_YN"){
			for (int i=0; i < resultList.size(); i++){
				if((resultList.get(i).get("ANS_YN")).equals("N")){
					resultList.get(i).set("ANS_YN","답변대기");
				}else{
					resultList.get(i).set("ANS_YN","답변완료");
				}
			}
		}
		
		return resultList;
		
	}


	
	
}
