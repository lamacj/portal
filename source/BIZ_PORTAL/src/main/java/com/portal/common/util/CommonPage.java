package com.portal.common.util;

import org.springframework.stereotype.Component;


/**
 *  <pre>
 *   페이징 모듈 Class
 *  </pre> 
 *  @author Jong Pil Kim
 *	@since 2013. 8. 20.
 *  @version 1.0
 *  @package com.portal.common.util.CommonPage.java
 */
@Component
public class CommonPage {

	/*@Value("#{common['PROJECT_NAME'].trim()}") private String projectName;*/
	
	/**
	 *  <pre>
	 *   Paging Method
	 *  </pre> 
	 *  @author Jong Pil Kim
	 *	@since 2013. 8. 20.
	 *  @version 1.0
	 *  @param  
	 *  		total : 페이지 처리 총 DATA 수, num : 보여줄 페이지 번호, rowSize : 보여줄 목록 개수, pageName : 요청 URL
	 *  @return
	 *  		result : 페이징 처리 완료된 문자열(자바스크립트 및 HTML Code)
	 *          페이지 직접 이동 존재(1|2|3...)
	 */
	public String getPCPagingPrint(int total, int num, int rowSize, String pageName) {
		
		StringBuilder result = new StringBuilder();

		try {

			int startPage;
			int endPage;
			int totalPage;
			int beforePage;
			int afterPage;
			
			if (num % 10 == 0) {
				startPage = ((num / 10) - 1) * 10 + 1;
				endPage = (num / 10) * 10;
			} else {
				startPage = (num / 10) * 10 + 1;
				endPage = ((num / 10) + 1) * 10;
			}

			if (total % rowSize == 0) {
				totalPage = (int) (total / rowSize);
			} else {
				totalPage = (int) (total / rowSize + 1);
			}

			if (totalPage == 0) {
				totalPage = 1;
			}

			if (totalPage < endPage) {
				endPage = totalPage;
			}

			if (num <= 1) {
				beforePage = num;
			} else {
				beforePage = num-1;
			}

			if (num == totalPage) {
				afterPage = totalPage;
			} else {
				afterPage = num + 1;
			}
			
			result.append("<a class='prev_page' href='javascript:"+pageName+"(");
			result.append(beforePage);
			result.append(")'>이전");
			result.append("</a>");

			for (int i = startPage; i < endPage + 1; i++) {
				
				if(i==num){
					result.append("<a class='current' href='javascript:"+pageName+"(");
				} else {
					result.append("<a href='javascript:"+pageName+"(");
				}
				result.append(i);
				result.append(")'> ");
				result.append(i);
				result.append(" </a>");
				
				if(i < endPage){
					result.append(" |");
				}
			}

			result.append("<a class='next_page' href='javascript:"+pageName+"(");
			result.append(afterPage);
			result.append(")'>다음");
			result.append("</a>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	/**
	 *  <pre>
	 *   Paging Method
	 *  </pre> 
	 *  @author Jong Pil Kim
	 *	@since 2013. 8. 20.
	 *  @version 1.0
	 *  @param  
	 *  		total : 페이지 처리 총 DATA 수, num : 보여줄 페이지 번호, rowSize : 보여줄 목록 개수, pageName : 요청 URL
	 *  @return
	 *  		result : 페이징 처리 완료된 문자열(자바스크립트 및 HTML Code)
	 *          페이지 직접 이동 삭제
	 */
	public String getMobilePagingPrint(int total, int num, int rowSize, String pageName) {
		
		StringBuilder result = new StringBuilder();

		try {

			int startPage;
			int endPage;
			int totalPage;
			int beforePage;
			int afterPage;
			
			if (num % 10 == 0) {
				startPage = ((num / 10) - 1) * 10 + 1;
				endPage = (num / 10) * 10;
			} else {
				startPage = (num / 10) * 10 + 1;
				endPage = ((num / 10) + 1) * 10;
			}

			if (total % rowSize == 0) {
				totalPage = (int) (total / rowSize);
			} else {
				totalPage = (int) (total / rowSize + 1);
			}

			if (totalPage == 0) {
				totalPage = 1;
			}

			if (totalPage < endPage) {
				endPage = totalPage;
			}

			if (startPage - 10 > 0) {
				beforePage = startPage - 10;
			} else {
				beforePage = startPage;
			}

			if (endPage + 1 < totalPage) {
				afterPage = endPage + 1;
			} else {
				afterPage = totalPage;
			}
			
			result.append("<a class='prev_page' href='javascript:"+pageName+"(");
			result.append(beforePage);
			result.append(")'>이전");
			result.append("</a>");
			
			result.append("<em> | </em>");

			result.append("<a class='next_page' href='javascript:"+pageName+"(");
			result.append(afterPage);
			result.append(")'>다음");
			result.append("</a>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
}
