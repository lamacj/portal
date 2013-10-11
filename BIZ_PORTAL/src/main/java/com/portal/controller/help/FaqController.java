package com.portal.controller.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.portal.common.collection.SBox;
import com.portal.common.parent.SuperController;
import com.portal.service.help.FaqService;

/**
 * <pre>
 * FAQ MAIN CONTROLLER
 * </pre>
 * @author JUNG MI KIM
 * @since 2013. 10. 11.
 * @version 1.0
 * @package com.portal.controller.help.FaqController.java
 */
@Controller
public class FaqController extends SuperController{

	@Autowired
	private FaqService faqService;
	
	
	/**
	 * <pre>
	 * FAQ 세부사항  
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 11.
	 * @version 1.0
	 * @param faqId : 자주하는 질문 순번(PT_FAQ TABLE)
	 * @return
	 */
	@RequestMapping(value = "/help/getFaq.do")
	public ModelAndView getNoticeDetail(@RequestParam(value = "faqId", required = true) String faqId) {
		
		ModelAndView mav = new ModelAndView(); 
		
		mav.setViewName("/help/getFaq");  
		mav.addObject("result", faqService.getFaqDetail(faqId));
		
		return mav;
	}
	
	
	/**
	 * <pre>
	 * FAQ 공통 List 조회 ( 검색, 페이징처리) with Ajax 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param sBox : null
	 * @return
	 */
	@RequestMapping(value = "/help/getFaqList.do")
	public ModelAndView getNotice(@ModelAttribute("initBoxs") SBox sBox) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/help/getFaqList");
		return mav;
	}
	
	/**
	 * <pre>
	 * FAQ Ajax List 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 11.
	 * @version 1.0
	 * @param searchText : 조건검색
	 * @param num : 현재 페이지
	 * @param qclId : 질문분류식별자
	 * @return
	 */
	@RequestMapping(value = "/help/getFaqListAjaxView.do")
	public ModelAndView getNoticeListAjax(@RequestParam(value = "searchText", required = true) String searchText,
										  @RequestParam(value = "num", required = true) int num,
										  @RequestParam(value = "qclId", required = true) int qclId) {
		ModelAndView mav = new ModelAndView();
		System.out.println(qclId);
		mav.setViewName("/help/getFaqListAjax");
		mav.addObject("result", faqService.getFaqSearchList(searchText,num,qclId));
		return mav;
	}
	
	
}
