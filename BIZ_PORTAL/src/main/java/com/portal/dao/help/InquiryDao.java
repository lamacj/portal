package com.portal.dao.help;

import org.springframework.stereotype.Repository;

import com.portal.common.exception.BizException;
import com.portal.common.collection.SBox;
import com.portal.common.collection.SBoxList;
import com.portal.common.parent.SuperDao;

/**
 * <pre>
 *   Notice Dao Class
 * </pre>
 * @author JUNG MI KIM
 * @since 2013. 9. 11.
 * @version 1.0
 * @package com.portal.dao.help.NoticeDao.java
 */

@Repository
public class InquiryDao extends SuperDao {
	
	/**
	 * <pre>
	 * 일대일 등록화면 DB등록 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 1.
	 * @version 1.0
	 * @param sBox
	 * @return
	 * @throws BizException
	 */
	public SBox insertInquiry(SBox sBox)  throws BizException{ 

		SBox returnBox = null;
		try {
			returnBox = new SBoxList<SBox>(super.getSqlMapClientTemplate().queryForList("help.insertInquiry_SQL", sBox)).get(0);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "insertInquiry_SQL Dao ERROR");
		}
		return returnBox;
	}
	
	
	public SBoxList<SBox> getInquiryList(SBox sBox)  throws BizException{ 

		SBoxList<SBox> resultList = null;
		
		try {
			resultList = new SBoxList<SBox>(super.getSqlMapClientTemplate().queryForList("help.selectInquiryList_SQL", sBox));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "selectInquiryList_SQL Dao ERROR");
		}

		return resultList;
	}
	
	
	
	public int getTotalCount(SBox sBox)  throws BizException{ 

		int result = 0;
		try {
			result = ((SBox) super.getSqlMapClientTemplate().queryForObject("help.SelectInquiryTotalCount_SQL", sBox)).getInt("totalCnt");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "selectMainTotalCount_SQL Dao ERROR");
		}

		return result;
	}
	
	
	public SBox getInquiryDetail(String qaId)throws BizException {

		SBox result = new SBox();
		try {
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+qaId);
			
			result = (SBox) super.getSqlMapClientTemplate().queryForObject("help.selectInquiryDetail_SQL", qaId);
			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!result"+result);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "getInquiryDetail Dao ERROR");
		}
		return result;
	}
	

}
