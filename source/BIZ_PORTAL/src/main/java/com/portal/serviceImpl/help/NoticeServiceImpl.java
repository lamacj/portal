package com.portal.serviceImpl.help;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.portal.common.util.CommonPage;
import com.portal.common.collection.SBox;
import com.portal.common.collection.SBoxList;

import com.portal.common.parent.SuperController;
import com.portal.common.parent.SuperService;
import com.portal.dao.help.NoticeDao;
import com.portal.service.help.NoticeService;
import com.portal.common.exception.BizException;

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
public class NoticeServiceImpl extends SuperService implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired 
	private CommonPage commonPage;
	
	
	/**
	 * <pre>
	 * 공지사항 - 상세조회화면 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param ntcId : 공지사항 순번
	 * @return
	 */
	@Override
	public SBox getNoticeDetail(String ntcId){
		
		SBox result = new SBox();
		try {
			// PARAMETER 초기화
			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");

			// Common Code 초기화
			// Paging 모듈 호출
			// 거래처 검색 리스트 조회
			result = noticeDao.getNoticeDetail(ntcId);

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
	 * 공지사항 - 공통 조회화면
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param searchText : 검색어
	 * @param num : 현재화면
	 * @return
	 */
	@Override
	public SBox getNoticeSearchList(String searchText, int num){
		
		SBox sBox = new SBox();
		SBox result = new SBox();
		SBoxList<SBox>	noticeList = null;
		try {
			
			// PARAMETER 초기화
			sBox.setIfEmpty("num", 1); // 현재 페이지
			sBox.setIfEmpty("rowSize", 4); // 목록 갯수
			sBox.setIfEmpty("searchText", searchText); // 목록 갯수
			sBox.setIfEmpty("ctnId", 2); // 컨테츠 순번  portal 서비스는 = 2
			
			// PARAMETER값 Setting
			if(!searchText.isEmpty())
				sBox.set("searchText",searchText);
			
			if(num!=0)
				sBox.set("num",num);
			
			// resultCode, resultMsg 초기화
			result.set("resultCode", "00");
			result.set("resultMsg", "SUCCESS");
			
			// 공지사항 정보 리스트 TOTAL COUNT 조회
			int getTotalCount =noticeDao.getTotalCount(sBox);
			
			// PC버젼 페이징 모듈 조회
			String pcPage = commonPage.getPCPagingPrint(getTotalCount, sBox.getInt("num"), sBox.getInt("rowSize"),"getAjaxPage");
			
			// 공지사항 검색 리스트 조회
			noticeList = noticeDao.getNoticeSearchList(sBox);
			
			// 조회 결과 저장
			result.set("noticeList", noticeList);
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
	
}
