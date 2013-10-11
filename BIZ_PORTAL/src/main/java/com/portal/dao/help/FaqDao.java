package com.portal.dao.help;

import org.springframework.stereotype.Repository;

import com.portal.common.exception.BizException;
import com.portal.common.collection.SBox;
import com.portal.common.collection.SBoxList;
import com.portal.common.parent.SuperDao;


@Repository
public class FaqDao extends SuperDao {

	/**
	 * <pre>
	 * FAQ - 세부 검색 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param faqId : FAQ 순번
	 * @return
	 * @throws BizException
	 */
	public SBox getFaqDetail(String faqId)throws BizException {

		SBox result = new SBox();
		try {
			result = (SBox) super.getSqlMapClientTemplate().queryForObject("help.selectFaqDetail_SQL", faqId);
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "getFaqDetail Dao ERROR");
		}
		return result;
	}


	/**
	 * <pre>
	 * FAQ - 공통 조회
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param sBox - num : 현재화면 ,ctnId : 컨텐츠 코드, rowSize: 화면 사이즈, searchText: 검색어
	 * @return
	 * @throws BizException
	 */
	public SBoxList<SBox> getFaqSearchList(SBox sBox)throws BizException {

		SBoxList<SBox> resultList = null;
		try {
			/*만약 초기에 들어와서 검색어가 없을경우 전체를 뿌려주기 위한 해답*/
			if(sBox.getString("searchText").isEmpty()){
				sBox.set("searchText",null);
			}
			
			resultList = new SBoxList<SBox> (super.getSqlMapClientTemplate().queryForList("help.selectSearchFaq_SQL", sBox));
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "getFaqSearchList Dao ERROR");
		}
		return resultList;
	}
	
	
	
	/**
	 * <pre>
	 * FAQ  - List 전체갯수
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
			result = ((SBox) super.getSqlMapClientTemplate().queryForObject("help.SelectFaqTotalCount_SQL", sBox)).getInt("totalCnt");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "getTotalCount Dao ERROR");
		}

		return result;
	}
	
	
}
