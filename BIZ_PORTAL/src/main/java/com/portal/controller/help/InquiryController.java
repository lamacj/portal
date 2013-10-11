package com.portal.controller.help;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.portal.common.collection.SBox;
import com.portal.common.parent.SuperController;
import com.portal.service.help.InquiryService;

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
		mav.addObject("result", inquiryService.getBaseInfo(sBox));
		
		//System.out.println(sBox);
		
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
	@ResponseBody
	public ModelAndView addInquiry(@ModelAttribute("initBoxs") SBox sBox) {
		
		ModelAndView mav = new ModelAndView("jsonview");
		SBox resultBox = inquiryService.addInquiry(sBox);
		String qaId = resultBox.getString("QAID");
		/*System.out.println("qaIdqaIdqaIdqaIdqaId"+qaId);*/
		//mav.setViewName("redirect:/help/getInquiryList.do"); 
		mav.addObject("qaId", qaId);
		return mav;
	}
	
	@RequestMapping(value = "/help/getInquiryList.do")
	public ModelAndView getInquiryList(@ModelAttribute("initBoxs") SBox sBox) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("help/getInquiryList");
		return mav;
	}
	
	@RequestMapping(value = "/help/getInquiryListAjaxView.do")
	public ModelAndView getInquiryListAjax(@RequestParam(value = "num", required = true) int num) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/help/getInquiryListAjax");
		mav.addObject("result", inquiryService.getInquiryList(num));
		return mav;
	}
	
	@RequestMapping(value = "/help/getInquiry.do")
	public ModelAndView getNoticeDetail(@RequestParam(value = "qaId", required = true) String qaId) {
		
		ModelAndView mav = new ModelAndView(); //.jsp로 열어질 파일
		
		mav.setViewName("/help/getInquiry");  
		mav.addObject("result", inquiryService.getInquiryDetail(qaId));
		
		return mav;
	}
	
	@RequestMapping(value = "/help/getInquiryPreViewListAjaxView.do")
	public ModelAndView getInquiryPreListAjax(@ModelAttribute("initBoxs") SBox sBox) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/help/getInquiryPreViewListAjax");
		mav.addObject("result", inquiryService.getInquiryPreViewList(sBox));
		return mav;
	}

}
