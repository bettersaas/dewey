package common.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class DateUtil {
	
	// 24小时制时间格式
	public  static final String Timestamp24_Format_STR = "yyyy-MM-dd HH:mm:ss";
	
	// 12小时制时间格式
	public  static final String Timestamp12_Format_STR = "yyyy-MM-dd hh:mm:ss";
	
	// 日期时间格式
	public static final String Date_Format_STR   = "yyyy-MM-dd";

	static Logger log = Logger.getLogger("logfile");

	public static Date parse(String dateString, String dateFormat) {
		return parse(dateString, dateFormat, java.util.Date.class);
	}

	// 格式化日期显示,转化为字符串
	public String DateToChar(java.util.Date dateIn, String format) {
		if (dateIn == null || format == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = "";
		dateStr = sdf.format(dateIn);
		return dateStr;
	}

	// 将字符串型日期转化为日期型
	public java.util.Date CharToDate(String dateStr, String format) {
		java.util.Date dasql = null;
		if (dateStr == null || "".equals(dateStr)) {
			return dasql;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			dasql = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dasql;
	}

	// 获取上传文件名
	public String fileName() {
		Calendar now = Calendar.getInstance();
		String time = String.valueOf(now.get(Calendar.YEAR));
		if (now.get(Calendar.MONTH) + 1 < 10) {
			time += "0" + String.valueOf(now.get(Calendar.MONTH) + 1);
		} else {
			time += String.valueOf(now.get(Calendar.MONTH) + 1);
		}
		if (now.get(Calendar.DAY_OF_MONTH) < 10) {
			time += "0" + String.valueOf(now.get(Calendar.DAY_OF_MONTH));
		} else {
			time += String.valueOf(now.get(Calendar.DAY_OF_MONTH));
		}
		if (now.get(Calendar.HOUR_OF_DAY) < 10) {
			time += "0" + String.valueOf(now.get(Calendar.HOUR_OF_DAY));
		} else {
			time += String.valueOf(now.get(Calendar.HOUR_OF_DAY));
		}
		if (now.get(Calendar.MINUTE) < 10) {
			time += "0" + String.valueOf(now.get(Calendar.MINUTE));
		} else {
			time += String.valueOf(now.get(Calendar.MINUTE));
		}
		if (now.get(Calendar.SECOND) < 10) {
			time += "0" + String.valueOf(now.get(Calendar.SECOND));
		} else {
			time += String.valueOf(now.get(Calendar.SECOND));
		}
		time = time + Math.round(Math.random() * 100000);
		return time;
	}

	// 获取上传文件名
	public String numToChar(Integer num) {
		String info = "";
		String[] numAry = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		String[] numPos = { "", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿" };

		if (num != null) {
			String numStr = num.toString();
			int j = numStr.length();
			for (int i = numStr.length() - 1; i >= 0; i--) {
				String numChar = numStr.substring(i, i + 1);
				int temp = Integer.valueOf(numChar);
				if (temp != 0) {
					info = numAry[temp] + numPos[j - i - 1] + info;
				}
			}
			info = info.replace("十万", "十");
			info = info.replace("百万", "百");
			info = info.replace("千万", "千");
			info = info.replace("十亿", "十");
			info = info.replace("百亿", "百");
			info = info.replace("千亿", "千");
			info = info.replace("万亿", "万");
		}
		return info;
	}

	/**
	 * 使用： parse("2010-08-22 13:46:00", "yyyy-MM-dd HH:mm:ss", java.util.Date.class)
	 * 
	 * @param dateString
	 * @param dateFormat
	 * @param targetResultType
	 * @return
	 */
	public static Date parse(String dateString, String dateFormat, Class<?> targetResultType) {
		if (StringUtils.isEmpty(dateString))
			return null;
		DateFormat df = new SimpleDateFormat(dateFormat);
		try {
			long time = df.parse(dateString).getTime();
			Date t = (Date) targetResultType.getConstructor(new Class[] {Long.TYPE }).newInstance(new Object[] { Long.valueOf(time) });
			return t;
		} catch (ParseException e) {
			String errorInfo = (new StringBuilder()).append("cannot use dateformat:").append(dateFormat).append(" parse datestring:").append(dateString).toString();
			throw new IllegalArgumentException(errorInfo, e);
		} catch (Exception e) {
			throw new IllegalArgumentException((new StringBuilder()).append("error targetResultType:").append(targetResultType.getName()).toString(), e);
		}
	}

	public static String format(Date date, String dateFormat) {
		if (date == null) {
			return null;
		} else {
			DateFormat df = new SimpleDateFormat(dateFormat);
			return df.format(date);
		}
	}
	
	/**
	 * 时间间隔
	 * @param dateSmallBegin  开始时间
	 * @param dateBigEnd         结束时间
	 * @return
	 * @throws ParseException
	 */
	public static DateInterval dateInterval(Date dateSmallBegin, Date dateBigEnd) throws ParseException {
		DateInterval dateInterval = new DateInterval();
		// 两个时间差的毫秒数
		long between = dateBigEnd.getTime() - dateSmallBegin.getTime();
		long dayInterval= between/(24*60*60*1000);
		long hourInterval=(between/(60*60*1000)-dayInterval*24);
		long minuteInterval=((between/(60*1000))-dayInterval*24*60-hourInterval*60);
		long secondInterval=(between/1000-dayInterval*24*60*60-hourInterval*60*60-minuteInterval*60);
		dateInterval.setBetweenInterval(between/1000);//除以1000是为了转换成秒
		dateInterval.setDayInterval(dayInterval);
		dateInterval.setHourInterval(hourInterval);
		dateInterval.setMinuteInterval(minuteInterval);
		dateInterval.setSecondInterval(secondInterval);
		return dateInterval;
	}

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date dateSmallBegin = df.parse("2004-01-02 11:30:24");
		java.util.Date dateBigEnd = df.parse("2004-01-02 13:31:40");
		DateInterval dateInterval = dateInterval(dateSmallBegin, dateBigEnd);
		System.out.println(">>"+dateInterval.getDayInterval()+"天"+dateInterval.getHourInterval()+"小时"+dateInterval.getMinuteInterval()+"分"+dateInterval.getSecondInterval()+"秒");
	}
	
	public static void main1(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));

		// Calendar的使用
		Calendar cal = Calendar.getInstance();
		System.out.println("时刻(毫秒数)：" + cal.getTime().getTime());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd EEE");

		String thetime = formatter.format(cal.getTime());
		System.out.println(thetime);

		// 年
		int year = cal.get(Calendar.YEAR);
		System.out.println("年：" + year);

		// 月(java中月从0开始)
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println("月：" + month);

		// 日
		int day_of_year = cal.get(Calendar.DAY_OF_YEAR);
		int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
		// java中周日是1,周一是2,... 周六是5
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println("日(年)：" + day_of_year);
		System.out.println("日(月)：" + day_of_month);
		System.out.println("日(星期)：" + day_of_week);

		// 时
		int hour12 = cal.get(Calendar.HOUR);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("时(12)：" + hour12);
		System.out.println("时(24)：" + hour24);

		// 分
		int minute = cal.get(Calendar.MINUTE);
		System.out.println("分：" + minute);

		// 秒
		int second = cal.get(Calendar.SECOND);
		System.out.println("秒：" + second);

		// 毫秒
		int milliSecond = cal.get(Calendar.MILLISECOND);
		System.out.println("毫秒：" + milliSecond);

		log.info("测试OK");

		// 格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年/MM月/dd日 HH时mm分ss秒");
		// 取当前系统时刻,显示当前时刻
		Date now = new Date();
		// 显示格式化后的时间
		String s = sdf.format(now);
		log.info(s);

		cal.setTime(now);
		cal.add(Calendar.MINUTE, 30); // 30分钟之后的时间
		Date last30Minute = cal.getTime();

		s = sdf.format(last30Minute);
		log.info(s);
	}
}
