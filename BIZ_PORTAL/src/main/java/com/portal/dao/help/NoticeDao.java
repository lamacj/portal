package com.portal.dao.help;

import org.springframework.stereotype.Repository;

import com.portal.common.collection.SBox;
import com.portal.common.collection.SBoxList;
import com.portal.common.exception.BizException;
import com.portal.common.parent.SuperDao;


@Repository
public class NoticeDao extends SuperDao {

	/**
	 * <pre>
	 * 공지사항 - 세부 검색 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param ntcId : 공지사항 순번
	 * @return
	 * @throws BizException
	 */
	public SBox getNoticeDetail(String ntcId)throws BizException {

		SBox result = new SBox();
		try {
			result = (SBox) super.getSqlMapClientTemplate().queryForObject("help.selectNoticeDetail_SQL", ntcId);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "getNoticeDetail Dao ERROR");
		}
		return result;
	}


	/**
	 * <pre>
	 * 공지사항 - 공통 조회
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param sBox - num : 현재화면 ,ctnId : 컨텐츠 코드, rowSize: 화면 사이즈, searchText: 검색어
	 * @return
	 * @throws BizException
	 */
	public SBoxList<SBox> getNoticeSearchList(SBox sBox)throws BizException {

		SBoxList<SBox> resultList = null;
		try {
			/*만약 초기에 들어와서 검색어가 없을경우 전체를 뿌려주기 위한 해답*/
			if(sBox.getString("searchText").isEmpty()){
				sBox.set("searchText",null);
			}
			
			resultList = new SBoxList<SBox> (super.getSqlMapClientTemplate().queryForList("help.selectSearchNotice_SQL", sBox));
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "getNoticeSearchList Dao ERROR");
		}
		return resultList;
	}
	
	
	
	/**
	 * <pre>
	 * 공지사항  - List 전체갯수
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param sBox - num : 현재화면 ,ctnId : 컨텐츠 코드, rowSize: 화면 사이즈, searchText: 검색어
	 * @return 
	 * @throws BizException
	 */
	public int getTotalCount(SBox sBox)throws BizException  { 

		int result = 0;
		try {
			result = ((SBox) super.getSqlMapClientTemplate().queryForObject("help.SelectNoticeTotalCount_SQL", sBox)).getInt("totalCnt");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "selectMainTotalCount Dao ERROR");
		}

		return result;
	}
	
	
	
	/**
	 * <pre>
	 *   게시판  글 등록 Dao Method
	 * </pre>
	 * 
	 * @author JUNG MI KIM
	 * @since 2013. 9. 13.
	 * @version 1.0
	 * @param sBox
	 *            
	 * @return resultList : 거래처 검색 리스트
	 */
	public SBoxList<SBox> addMainList(SBox sBox)throws BizException {

		SBoxList<SBox> resultList = null;
		
		try {
			resultList = new SBoxList<SBox>(super.getSqlMapClientTemplate().queryForList("notice.addtNoticeList_SQL", sBox));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "addMainList Dao ERROR");
		}

		return resultList;
	}

	public SBoxList<SBox> getNoticeNewList(SBox sBox)throws BizException {

		SBoxList<SBox> resultList = null;
		try {
			resultList = new SBoxList<SBox> (super.getSqlMapClientTemplate().queryForList("help.selectNewNotice_SQL", sBox));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "getNoticeNewList Dao ERROR");
		}
		return resultList;
	}
	
	
}
