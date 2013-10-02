package com.portal.common.collection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class SLog {

	/**
	 * <pre>
	 * Logger 선언
	 * </pre>
	 */
	private Logger log = null;

	public String randomCharacter = "";

	/**
	 * <pre>
	 * RLog Overloading Constructorz
	 * </pre>
	 * 
	 * @author sungrangkong
	 * @since 2013.08.14
	 */
	public SLog() {
		log = Logger.getLogger(this.getClass());
	}

	/**
	 * <pre>
	 * Debug 모드 Message 출력 메소드
	 * </pre>
	 * 
	 * @param msg
	 *            출력할 메시지
	 * @author sungrangkong
	 * @since 2013.08.14
	 */
	public void d(String msg) {
		log.debug(randomCharacter + msg);
	}

	/**
	 * <pre>
	 * Info 모드 Message 출력 메소드
	 * </pre>
	 * 
	 * @param msg
	 *            출력할 메시지
	 * @author sungrangkong
	 * @since 2013.08.14
	 */
	public void i(String msg) {
		log.info(randomCharacter + msg);
	}

	/**
	 * <pre>
	 * Fatal 모드 Message 출력 메소드
	 * </pre>
	 * 
	 * @param msg
	 *            출력할 메시지
	 * @author sungrangkong
	 * @since 2013.08.14
	 */
	public void f(String msg) {
		log.fatal(randomCharacter + msg);
	}

	/**
	 * <pre>
	 * Warning 모드 Message 출력 메소드
	 * </pre>
	 * 
	 * @param msg
	 *            출력할 메시지
	 * @author sungrangkong
	 * @since 2013.08.14
	 */
	public void w(String msg) {
		log.warn(randomCharacter + msg);
	}

	/**
	 * <pre>
	 * Error 모드 Message 출력 메소드
	 * </pre>
	 * 
	 * @param msg
	 *            출력할 메소드
	 * @author sungrangkong
	 * @since 2013.08.14
	 */
	public void e(String msg) {
		log.error(randomCharacter + msg);
	}
}
