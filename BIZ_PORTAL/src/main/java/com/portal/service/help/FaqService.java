package com.portal.service.help;

import com.portal.common.collection.SBox;

/**
 * <pre>
 *  공지사항 Interface 정의
 * </pre>
 * @author JUNG MI KIM
 * @since 2013. 9. 30.
 * @version 1.0
 * @package com.portal.service.help.NoticeService.java
 */
public interface FaqService {

	//public SBox getNoticeList(SBox sBox);
	public SBox getFaqDetail(String faqId);
	public SBox getFaqSearchList(String searchText, int num, int qclId);

}
