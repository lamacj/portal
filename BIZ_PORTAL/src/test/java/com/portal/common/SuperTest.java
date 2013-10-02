package com.portal.common;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <pre>
 * Test 전체 부모 Class
 * </pre>
 * @author JUNG EUN LIM
 * @since 2013. 9. 25.
 * @version 1.0
 * @package com.bizdebn.common.SuperTest.java
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:common/spring/*" })
public class SuperTest{

	@Before
    public void setUp() {

    }
}
