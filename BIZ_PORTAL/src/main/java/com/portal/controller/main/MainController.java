package com.portal.controller.main;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.portal.common.parent.SuperController;

/**
 * <pre>
 *  메인 컨트롤러 정의
 * </pre>
 * @author JUNG MI KIM
 * @since 2013. 9. 30.
 * @version 1.0
 * @package com.portal.controller.main.MainController.java
 */
@Controller
public class MainController extends SuperController{
	/**
	 * <pre>
	 * 메인 화면 
	 * </pre>
	 * @author JUNG MI KIM
	 * @since 2013. 9. 30.
	 * @version 1.0
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/main.do")
	public ModelAndView goMain(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/main/main");
		return mav;
	}
	
}
