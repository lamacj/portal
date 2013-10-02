package com.portal.common.interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.portal.common.collection.SBox;

/**
 * <pre>
 * Controller 호출 전 Handler를 통한 Filter Interceptor Class
 * </pre>
 * 
 * @author sungrangkong
 * @since 2013.08.15
 * 
 */
@Controller
public class EventCheckInterceptor extends HandlerInterceptorAdapter {

	/**
	 * <pre>
	 * Controller 호출전 실행 메소드
	 * </pre>
	 * 
	 * @author sungrangkong
	 * @since 2013.08.15
	 * @param request
	 *            : HttpServletRequest Object response : HttpServletResponse Object handler : HandlerInterceptor Object
	 * 
	 */
	@Override
	@SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		SBox sBox = new SBox();
		String uri = request.getRequestURI();

		Map<String, Object> requestMap = request.getParameterMap();
		Iterator<String> it = requestMap.keySet().iterator();

		// [1] Request 객체로 부터 Prameter 정보를 SBox로 셋팅함.
		while (it.hasNext()) {
			try {
				String key = (String) it.next();
				if ((requestMap.get(key) instanceof String[])) {
					String[] values = (String[]) requestMap.get(key);

					if (values != null && values.length == 1) {
						sBox.set(key, values[0]);
					} else {
						sBox.set(key, values);
					}
				} else {
					sBox.set(key, requestMap.get(key));
				}
			} catch (Exception ex) {
			}
		}

		// [2] 추가적인 정보를 SBox 에 셋팅함
		sBox.set("remoteHost", request.getRemoteHost());
		sBox.set("remoteAddr", request.getRemoteAddr());
		sBox.set("remoteURI", uri);

		request.setAttribute("sBox", sBox);
		return true;
	}
	
}
