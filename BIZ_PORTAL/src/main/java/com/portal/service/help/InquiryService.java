package com.portal.service.help;

import com.portal.common.collection.SBox;
import com.portal.common.collection.SBoxList;

/**
 * <pre>
 *    거래처 Service Interface Class
 * </pre>
 * 
 * </pre>
 * @author JUNG MI KIM
 * @since 2013. 9. 17.
 * @package com.portal.service.help.InquiryService.java
 */
public interface InquiryService {

	public SBox addInquiryForm(SBox sBox);
	public SBox addInquiry(SBox sBox);
	public SBox getInquiryList(int num);
	public SBox getInquiryDetail(String qaId);
	public SBox getInquiryPreViewList(SBox sBox);
	public SBox getInquiryPreAndNextViewList(SBox sBox);
	public SBoxList<SBox> getCommonCode(String codeNm,SBoxList<SBox> sBox);
	public SBox getBaseInfo(SBox sBox);
}
