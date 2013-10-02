package com.portal.serviceImpl.help;


//import java.math.BigDecimal;
//import java.util.Iterator;

//import org.apache.poi.ss.usermodel.CellStyle;
//import java.math.BigDecimal;

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
import com.portal.dao.help.InquiryDao;
import com.portal.service.help.InquiryService;

/*
import com.curd.common.exception.BizException;
import com.curd.common.util.CommonCode;
import com.curd.common.util.CommonExcel;
import com.curd.common.util.CommonPage;
import com.curd.dao.debenture.DebentureDao;
*/

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
		//SBoxList<SBox>	noticeList = null;
		
		try {
			
			//1. 담아있는 Sbox가져다가 DB에 넘기기
			//2. 성공코드 여부에 따라 저장하고 저장이 안되었을시 트랜젝션 취소
			//3. 성공시 reDirect해서 화면에 다시 뿌려줌
			
			// PARAMETER 초기화
			

			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");

			// Common Code 초기화

			// Paging 모듈 호출

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
			
			//문의 항목
			if (!sBox.isEmpty("qaType")) {
				sBox.set("qaType", sBox.getString("qaType")); // 문의 항목
			} else {
				sBox.set("qaType", null);
			}
			
			//이름
			if (!sBox.isEmpty("userNm")) {
				sBox.set("userNm", sBox.getString("userNm")); // 문의 항목
			} else {
				sBox.set("userNm", null);
			}
			
			//이메일
			if (!sBox.isEmpty("eMail1") && !sBox.isEmpty("eMail2")) {
				sBox.set("eMail", sBox.getString("eMail1") + "@" + sBox.getString("eMail2")); // 이메일
			} else {
				sBox.set("eMail", null);
			}
			//연락처
			if (!sBox.isEmpty("telNo1") && !sBox.isEmpty("telNo2") && !sBox.isEmpty("telNo3")) {
				sBox.set("telNo", sBox.getString("telNo1") + "-" + sBox.getString("telNo2") + "-" + sBox.getString("telNo3")); // 거래처 전화번호
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
			
			
			System.out.println("!!!!!!!!!!!!inquiryService AFTER!!!!!!!!!"+sBox);
			
			// [2] 거래처 등록
			resultBox = inquiryDao.insertInquiry(sBox);


		} catch (Exception ex) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		} finally {

		}
			return resultBox;

		
	}
}
