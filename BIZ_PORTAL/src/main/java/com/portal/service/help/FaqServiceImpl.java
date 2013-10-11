package com.portal.service.help;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.portal.common.util.CommonPage;
import com.portal.common.collection.SBox;
import com.portal.common.collection.SBoxList;

import com.portal.common.parent.SuperController;
import com.portal.common.parent.SuperService;
import com.portal.dao.help.FaqDao;
import com.portal.common.exception.BizException;

/**
 * <pre>
 *    faq Service Implements Class
 * </pre>
 * 
 * @author JUNG MI KIM
 * @since 2013. 9. 17.
 * @version 1.0
 * @package com.portal.serviceImpl.help.faqServiceImpl.java
 */
@Service
public class FaqServiceImpl extends SuperService implements FaqService {

	@Autowired
	private FaqDao faqDao;
	
	@Autowired 
	private CommonPage commonPage;
	
	
	/**
	 * <pre>
	 * FAQ - 공통 조회화면
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param searchText : 검색어
	 * @param num : 현재화면
	 * @return
	 */
	@Override
	public SBox getFaqSearchList(String searchText, int num, int qclId){
		
		SBox sBox = new SBox();
		SBox result = new SBox();
		SBoxList<SBox>	faqList = null;
		try {
			
			// PARAMETER 초기화
			sBox.setIfEmpty("num", 1); // 현재 페이지
			sBox.setIfEmpty("rowSize", 10); // 목록 갯수
			sBox.setIfEmpty("searchText", searchText); // 목록 갯수
			sBox.setIfEmpty("ctnId", 2); // 컨테츠 순번  portal 서비스는 = 2
			sBox.setIfEmpty("qclId", 0); // 현재 페이지
			
			// PARAMETER값 Setting
			if(!searchText.isEmpty())
				sBox.set("searchText",searchText);
			
			if(num!=0)
				sBox.set("num",num);
			
			if(qclId!=0)
				sBox.set("qclId",qclId);
			
			System.out.println("qclIdqclIdqclIdqclId"+sBox);
			
			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");
			
			// 공지사항 정보 리스트 TOTAL COUNT 조회
			int getTotalCount =faqDao.getTotalCount(sBox);
			
			// PC버젼 페이징 모듈 조회
			String pcPage = commonPage.getPCPagingPrint(getTotalCount, sBox.getInt("num"), sBox.getInt("rowSize"),"getAjaxPage");
			
			// 공지사항 검색 리스트 조회
			faqList = faqDao.getFaqSearchList(sBox);
			
			// 조회 결과 저장
			result.set("faqList", faqList);
			result.set("pcPage", pcPage);
			
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
	 * FAQ- 상세조회화면 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param ntcId : 공지사항 순번
	 * @return
	 */
	@Override
	public SBox getFaqDetail(String faqId){
		
		SBox result = new SBox();
		try {
			// PARAMETER 초기화
			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");

			// Common Code 초기화
			// Paging 모듈 호출
			// 거래처 검색 리스트 조회
			result = faqDao.getFaqDetail(faqId);

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
	
	
}
