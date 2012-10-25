package common.util.date;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 参数化测试
 * @author Administrator
 *
 */
@RunWith(value = Parameterized.class)
public class DateUtilParameterizedTest {
	
	private static DateUtil dateUtil;
	
	private String extected;  

	private int target;
	
	public DateUtilParameterizedTest(int target,String extected) {  
		super();
		this.target = target;
		this.extected = extected;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dateUtil = new DateUtil();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList( new Object[][]{ {2,"二"}, {0,""}, {3,"三"} } );
	}
	
	@Test
	public void testNumToChar() {
		Assert.assertEquals(extected, dateUtil.numToChar(target));
	}
}
