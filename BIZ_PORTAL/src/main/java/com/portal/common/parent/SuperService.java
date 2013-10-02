package com.portal.common.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.common.collection.SLog;

/**
 *  <pre>
 *   Service 전체 부모 Class
 *  </pre> 
 *  @author JUNG MI KIM
 *	@since 2013. 9. 17.
 *  @version 1.0
 *  @package com.bizDebn.common.parent.SuperService.java
 */
@Service
public class SuperService {

	@Autowired
	protected SLog log;

}
