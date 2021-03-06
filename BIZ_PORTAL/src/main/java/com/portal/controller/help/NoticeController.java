package com.portal.controller.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portal.common.collection.SBox;
import com.portal.common.parent.SuperController;
import com.portal.service.help.NoticeService;

/**
 * <pre>
 * 공지사항  공통 Controller
 * </pre>
 * @author JUNG MI KIM
 * @since 2013. 9. 30.
 * @version 1.0
 * @package com.portal.controller.help.NoticeController.java
 */
@Controller
public class NoticeController extends SuperController{

	@Autowired
	private NoticeService noticeService;
	
	/**
	 * <pre>
	 * 공지사항 공통 List 조회 ( 검색, 페이징처리) with Ajax 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param sBox : NULL
	 * @return
	 */
	@RequestMapping(value = "/help/getNoticeList.do")
	public ModelAndView getNotice(@ModelAttribute("initBoxs") SBox sBox) {
		//System.out.println("공지사항 공통 List 조회 ( 검색, 페이징처리)"+sBox);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/help/getNoticeList");
		return mav;
	}
	
	/**
	 * <pre>
	 *  공지사항  - List(Ajax)
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param searchText : 검색어
	 * @param num : 현재페이지  페이징
	 * @return
	 */
	@RequestMapping(value = "/help/getNoticeListAjaxView.do")
	public ModelAndView getNoticeListAjax(@RequestParam(value = "searchText", required = true) String searchText,
										  @RequestParam(value = "num", required = true) int num) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/help/getNoticeListAjax");
		mav.addObject("result", noticeService.getNoticeSearchList(searchText,num));
		return mav;
	}
	
	
	/**
	 * <pre>
	 * 고객지원 공지사항 세부 정보 Ajax by BIZ_PORTAL
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 14.
	 * @version 1.0
	 * @param ntcId : 공지사항 순번
	 * @return
	 */
	@RequestMapping(value = "/help/getNotice.do")
	public ModelAndView getNotice(@RequestParam(value = "ntcId", required = true) String ntcId){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("help/getNotice");
		mav.addObject("ntcId", ntcId);
		return mav;
	}
	
	/**
	 * <pre>
	 *  공지사항 세부항목 가지고 오기
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param ntcId : 공지사항순번
	 * @return
	 */
	@RequestMapping(value = "/help/getNoticeAjax.do")
	public ModelAndView getNoticeDetail(@RequestParam(value = "ntcId", required = true) String ntcId) {
		ModelAndView mav = new ModelAndView(); //.jsp로 열어질 파일
		
		mav.setViewName("/help/getNoticeAjax");  
		mav.addObject("result", noticeService.getNoticeDetail(ntcId));
		
		return mav;
	}
	
	/**
	 * <pre>
	 *  공지사항 Ajax에서 새로운 공지사항 3개 보여주기
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 2.
	 * @version 1.0
	 * @param sBox : 빈 값
	 * @return
	 */
	@RequestMapping(value = "/help/getNoticeNewListAjaxView.do")
	public ModelAndView getNoticeNewListAjax(@ModelAttribute("initBoxs") SBox sBox) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/help/getNoticeNewListAjax");
		mav.addObject("result", noticeService.getNoticeNewList(sBox));
		return mav;
	}
	
}
