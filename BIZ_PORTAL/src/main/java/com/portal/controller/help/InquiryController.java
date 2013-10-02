package com.portal.controller.help;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.portal.common.collection.SBox;
import com.portal.common.parent.SuperController;
import com.portal.service.help.InquiryService;
/*
import com.bizDebn.common.enumtype.EUserErrorCode;
import com.bizDebn.common.session.SessionManager;
*/

/**
 * <pre>
 * 일대일 문의 Controller
 * </pre>
 * @author JUNG MI KIM
 * @since 2013. 10. 1.
 * @version 1.0
 * @package com.portal.controller.help.InquiryController.java
 */
@Controller
public class InquiryController extends SuperController{

	@Autowired
	private InquiryService inquiryService;
	
	/**
	 * <pre>
	 * 1:1 등록 문의 등록화면  - Form
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 1.
	 * @version 1.0
	 * @param sBox
	 * @return
	 */
	@RequestMapping(value = "/help/addInquiryForm.do")
	public ModelAndView addInquiryForm(@ModelAttribute("initBoxs") SBox sBox) {
		ModelAndView mav = new ModelAndView(); //.jsp로 열어질 파일
		mav.setViewName("help/addInquiryForm");  
		
		return mav;
	}
	
	
	/**
	 * <pre>
	 * 1:1 등록 문의 등록화면  - 등록 DB
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 1.
	 * @version 1.0
	 * @param sBox
	 * @return
	 */
	@RequestMapping(value = "/help/addInquiry.do")
	public ModelAndView addInquiry(@ModelAttribute("initBoxs") SBox sBox) {
		
		SBox resultBox = inquiryService.addInquiry(sBox);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/help/getInquiryList.do"); 
		mav.addObject("sBox", resultBox);
		
		return mav;
	}
	
	@RequestMapping(value = "/help/getInquiryList.do")
	public ModelAndView getCustomerList(@ModelAttribute("initBoxs") SBox sBox) {
		System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!!Do you install");
		ModelAndView mav = new ModelAndView("help/getInquiryList");
		mav.addObject("result", inquiryService.getInquiryList(sBox));
		mav.addObject("sBox", sBox);

		return mav;
	}
	
	
		
}
