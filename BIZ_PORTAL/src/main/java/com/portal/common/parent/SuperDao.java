package com.portal.common.parent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.common.collection.SLog;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 *  <pre>
 *   Dao 전체 부모 Class
 *  </pre> 
 *  @author JUNG MI KIM
 *	@since 2013. 9. 17.
 *  @version 1.0
 *  @package com.portal.common.parent.SuperDao.java
 */
@Repository
public class SuperDao extends EgovAbstractDAO {

	@Autowired
	protected SLog log;

}
