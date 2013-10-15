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
	 * @param sBox -ctnId:컨텐츠 순번,  qstType:질문자 유형, qstId: 질문자 식별자, eMail:이메일, telNo:전화번호
	 *               qst:답변 질문내용, tlNm:질문 제목, userNm:사용자이름, reQst:재질문여부, qclId:질문분류식별자
	 *               smsYn:SMS수신여부, ansYn:답변완료여부, chkYn:질문확인여부
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
	
	/**
	 * <pre>
	 * 1:1문의 List조회 화면
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 11.
	 * @version 1.0
	 * @param sBox - num: 혅재화면 ,ctnId: 컨텐츠 순번, rowSize: 화면 갯수지정
	 * @return
	 * @throws BizException
	 */
	public SBoxList<SBox> getInquiryList(SBox sBox)  throws BizException{ 

		SBoxList<SBox> resultList = null;
		System.out.println("하드코딩 아닌데"+sBox);
		try {
			resultList = new SBoxList<SBox>(super.getSqlMapClientTemplate().queryForList("help.selectInquiryList_SQL", sBox));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "selectInquiryList_SQL Dao ERROR");
		}

		return resultList;
	}
	
	
	/**
	 * <pre>
	 * 전체 List 갯수 가지고 오기
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 11.
	 * @version 1.0
	 * @param sBox - num: 혅재화면 ,ctnId: 컨텐츠 순번, rowSize: 화면 갯수지정
	 * @return
	 * @throws BizException
	 */
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
	
	/**
	 * <pre>
	 * 1:1문의 상세 화면 조회 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 11.
	 * @version 1.0
	 * @param qaId :회원문의 답변순번
	 * @return
	 * @throws BizException
	 */
	public SBoxList<SBox> getInquiryDetail(SBox sBox)throws BizException {

		SBoxList<SBox>  resultList = null;
		try {
			resultList =new SBoxList<SBox> (super.getSqlMapClientTemplate().queryForList("help.selectInquiryDetail_SQL", sBox));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "getInquiryDetail Dao ERROR");
		}
		return resultList;
	}
	
	/**
	 * <pre>
	 *  1:1문의 등록화면 5개 최신글 가지고오기
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 11.
	 * @version 1.0
	 * @param sBox - rowSize : 보여질 갯수 표기
	 * @return
	 * @throws BizException
	 */
	public SBoxList<SBox> getInquiryPreViewList(SBox sBox)throws BizException {

		SBoxList<SBox> resultList = null;
		try {
			resultList = new SBoxList<SBox> (super.getSqlMapClientTemplate().queryForList("help.selectInquiryPreViewList_SQL", sBox));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "selectInquiryPreViewList_SQL Dao ERROR");
		}
		return resultList;
	}
	
	/**
	 * <pre>
	 * 1:1문의 등록 폼에서 User 값 에 맞게 Setting 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 11.
	 * @version 1.0
	 * @param sBox - userInfo: 사용자 아이디 , TEL_NO: 전화번호, LOGIN_PW : 비밀번호 , USR_NM : 사용자이름
	 * @return
	 * @throws BizException
	 */
	public SBox getUserInfo(SBox sBox)  throws BizException{ 

		SBox returnBox = null;
		try {
			returnBox = (SBox) super.getSqlMapClientTemplate().queryForObject("help.SelectUserByLoginId_SQL", sBox);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new BizException("21", "SelectUserByLoginId_SQL Dao ERROR");
		}
		return returnBox;
	}
	
	
	
}
