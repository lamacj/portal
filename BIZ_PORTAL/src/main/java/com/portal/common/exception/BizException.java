package com.portal.common.exception;

/**
 * <pre>
 * Batch Business Exception 관리 Class
 * </pre>
 * 
 * @author SungRangKong
 * @version v1.0
 * @since 2013.08.15
 * 
 */
public class BizException extends Exception {

	// serial ID
	private static final long serialVersionUID = 1L;

	// 최종 에러 메시지
	private String errMsg = "";

	// 최종 에러 코드
	private String errCode = "";

	/**
	 * <pre>
	 * Biz Exception 생성자 호출
	 * </pre>
	 * 
	 * @author SungRangKong
	 * @since 2013.08.15
	 * 
	 * @param errCode
	 *            에러코드
	 * @param errMsg
	 *            에러메시지
	 */
	public BizException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	/**
	 * <pre>
	 * Biz Exception 생성자 호출
	 * </pre>
	 * 
	 * @author SungRangKong
	 * @since 2013.08.15
	 * 
	 * @param errCode
	 *            에러코드
	 */
	public BizException(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * 
	 * <pre>
	 * 최종 에러 메시지 반환
	 * </pre>
	 * 
	 * @author SungRangKong
	 * @return 최종 에러메시지
	 */
	public String getErrMsg() {
		return this.errMsg;
	}

	/**
	 * <pre>
	 * 최종 에러 코드 반환 메소드
	 * </pre>
	 * 
	 * @author SungRangKong
	 * @since 2013.08.15
	 * 
	 * @return 에러 코드
	 */
	public String getErrCode() {
		return this.errCode;
	}

}
