package common.util.date;

import java.text.SimpleDateFormat;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

@RunWith(JUnit4ClassRunner.class)
public class DateUtilTest {
	
	private static DateUtil dateUtil;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("ÿ��������ִֻ��һ��");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("ÿ�����Է�����ִ��һ��");
		dateUtil = new DateUtil();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * ��ʱ100����ִ����ϣ����ұس������쳣
	 * @throws Exception
	 */
	@Test(timeout=100,expected = Exception.class)
	public void testDateInterval() throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date dateSmallBegin = df.parse("2004-01-02 11:30:24");
		java.util.Date dateBigEnd = df.parse("2004-01-02 13:31:40");
		DateInterval dateInterval = DateUtil.dateInterval(dateSmallBegin, dateBigEnd);
		System.out.println(">>"+dateInterval.getDayInterval()+"��"+dateInterval.getHourInterval()+"Сʱ"+dateInterval.getMinuteInterval()+"��"+dateInterval.getSecondInterval()+"��");
		assertEquals(0, dateInterval.getDayInterval());
		assertEquals(2, dateInterval.getHourInterval());
		assertEquals(1, dateInterval.getMinuteInterval());
		assertEquals(16, dateInterval.getSecondInterval());
		throw new Exception();
		//fail("Not yet implemented");
	}
	
	@Ignore("parse()���ò���")
	@Test
	public void testParse() throws Exception {
		
	}
	
	@Test
	public void testFileName() {
		System.out.println(dateUtil.fileName());
	}

}
