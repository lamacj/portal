package com.portal.common.parent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.portal.common.collection.SBox;
import com.portal.common.collection.SLog;

/**
 *  <pre>
 *   Controller 전체 부모 Class
 *  </pre> 
 *  @author JUNG MI KIM
 *	@since 2013. 9. 17.
 *  @version 1.0
 *  @package com.portal.common.parent.SuperController.java
 */
@Controller
public class SuperController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	protected SLog log;

	@ModelAttribute("initBoxs")
	public SBox initBoxs() {
		return (SBox) request.getAttribute("sBox");

	}
}
