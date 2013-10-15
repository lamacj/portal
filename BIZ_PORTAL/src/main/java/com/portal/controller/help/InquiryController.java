package com.portal.controller.help;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.portal.common.collection.SBox;
import com.portal.common.parent.SuperController;
import com.portal.service.help.InquiryService;

/**
 * <pre>
 * 1:1 문의 Controller
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
	 * 고객지원 1:1 등록 화면 연결  Ajax by BIZ_PORTAL 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 14.
	 * @version 1.0
	 * @param sBox : 없음
	 * @return
	 */
	@RequestMapping(value = "/help/getInquiryForm.do")
	public ModelAndView getInquiryForm(@ModelAttribute("initBoxs") SBox sBox) {
		
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("/help/getInquiryForm");  
		
		return mav;
	}
	
	/**
	 * <pre>
	 *  1:1 등록 문의 등록화면  - Form  Ajax by BIZ_PORTAL 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 14.
	 * @version 1.0
	 * @param sBox
	 * @return
	 */
	@RequestMapping(value = "/help/getInquiryFormAjax.do")
	public ModelAndView getInquiryFormAjax(@ModelAttribute("initBoxs") SBox sBox
			, @RequestParam(value = "portalDomain", required = true) String portalDomain) {
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("help/getInquiryFormAjax");  
		mav.addObject("result", inquiryService.getBaseInfo(sBox));
		mav.addObject("portalDomain", portalDomain);
		

		return mav;
	}
	
	
	/**
	 * <pre>
	 * 1:1 등록 문의 등록화면  - 등록 DB
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 1.
	 * @version 1.0
	 * @param sBox - ctnId:컨텐츠 순번,  qstType:질문자 유형, qstId: 질문자 식별자, eMail:이메일, telNo:전화번호
	 *               qst:답변 질문내용, tlNm:질문 제목, userNm:사용자이름, reQst:재질문여부, qclId:질문분류식별자
	 *               smsYn:SMS수신여부, ansYn:답변완료여부, chkYn:질문확인여부
	 * @param qaId : 회원문의 답변순번
	 * @return
	 */
	@RequestMapping(value = "/help/addInquiry.do")
	@ResponseBody
	public ModelAndView addInquiry(@ModelAttribute("initBoxs") SBox sBox
			, HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST");
		response.setHeader("Access-Control-Max-Age", "360");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		ModelAndView mav = new ModelAndView("jsonview");
		SBox resultBox = inquiryService.addInquiry(sBox);
		String qaId = resultBox.getString("QAID");

		mav.addObject("qaId", qaId);
		return mav;
	}
	
	/**
	 * <pre>
	 * 고객지원  1:1문의 사항 리스트   
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 14.
	 * @version 1.0
	 * @param sBox - null
	 * @return
	 */
	@RequestMapping(value = "/help/getInquiryList.do")
	public ModelAndView getInquiryList(@ModelAttribute("initBoxs") SBox sBox){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("help/getInquiryList");
		return mav;
	}
	
	
	/**
	 * <pre>
	 * 1:1등록  List  Ajax by BIZ_PORTAL   
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 11.
	 * @version 1.0
	 * @param num : 현재 페이지
	 * @return
	 */
	@RequestMapping(value = "/help/getInquiryListAjaxView.do")
	public ModelAndView getInquiryListAjax(@RequestParam(value = "num", required = true) int num) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/help/getInquiryListAjax");
		mav.addObject("result", inquiryService.getInquiryList(num));
		return mav;
	}
	
	
	/**
	 * <pre>
	 * 고객지원 1:1문의 사항 세부항목 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 14.
	 * @version 1.0
	 * @param qaId : 회원문의 답변순번
	 * @return
	 */
	@RequestMapping(value = "/help/getInquiry.do")
	public ModelAndView getInquiry(@RequestParam(value = "qaId", required = true) String qaId) {
		
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("/help/getInquiry");  
		mav.addObject("qaId", qaId);
		
		return mav;
	}
	
	
	/**
	 * <pre>
	 * 1:1등록  세부사항   Ajax by BIZ_PORTAL 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 11.
	 * @version 1.0
	 * @param qaId : 회원문의 답변순번
	 * @return
	 */
	@RequestMapping(value = "/help/getInquiryAjax.do")
	public ModelAndView getInquiryDetail(@RequestParam(value = "qaId", required = true) String qaId) {
		
		ModelAndView mav = new ModelAndView(); 
		
		mav.setViewName("/help/getInquiryAjax");  
		mav.addObject("result", inquiryService.getInquiryDetail(qaId));
		
		return mav;
	}
	
	/**
	 * <pre>
	 * FAQ 등록화면에서 최신 5개 가지고 오는 화면 (추후 user_id값 넘겨줘야함  DB='717171717') 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 10. 11.
	 * @version 1.0
	 * @param sBox - rowSize: 표시될 갯수
	 * @return
	 */
	@RequestMapping(value = "/help/getInquiryPreViewListAjaxView.do")
	public ModelAndView getInquiryPreListAjax(@ModelAttribute("initBoxs") SBox sBox) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/help/getInquiryPreViewListAjax");
		mav.addObject("result", inquiryService.getInquiryPreViewList(sBox));

		return mav;
	}
	

}
