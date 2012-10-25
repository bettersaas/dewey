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
	
	// 24Сʱ��ʱ���ʽ
	public  static final String Timestamp24_Format_STR = "yyyy-MM-dd HH:mm:ss";
	
	// 12Сʱ��ʱ���ʽ
	public  static final String Timestamp12_Format_STR = "yyyy-MM-dd hh:mm:ss";
	
	// ����ʱ���ʽ
	public static final String Date_Format_STR   = "yyyy-MM-dd";

	static Logger log = Logger.getLogger("logfile");

	public static Date parse(String dateString, String dateFormat) {
		return parse(dateString, dateFormat, java.util.Date.class);
	}

	// ��ʽ��������ʾ,ת��Ϊ�ַ���
	public String DateToChar(java.util.Date dateIn, String format) {
		if (dateIn == null || format == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = "";
		dateStr = sdf.format(dateIn);
		return dateStr;
	}

	// ���ַ���������ת��Ϊ������
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

	// ��ȡ�ϴ��ļ���
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

	// ��ȡ�ϴ��ļ���
	public String numToChar(Integer num) {
		String info = "";
		String[] numAry = { "��", "һ", "��", "��", "��", "��", "��", "��", "��", "��" };
		String[] numPos = { "", "ʮ", "��", "ǧ", "��", "ʮ��", "����", "ǧ��", "��", "ʮ��", "����", "ǧ��", "����" };

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
			info = info.replace("ʮ��", "ʮ");
			info = info.replace("����", "��");
			info = info.replace("ǧ��", "ǧ");
			info = info.replace("ʮ��", "ʮ");
			info = info.replace("����", "��");
			info = info.replace("ǧ��", "ǧ");
			info = info.replace("����", "��");
		}
		return info;
	}

	/**
	 * ʹ�ã� parse("2010-08-22 13:46:00", "yyyy-MM-dd HH:mm:ss", java.util.Date.class)
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
	 * ʱ����
	 * @param dateSmallBegin  ��ʼʱ��
	 * @param dateBigEnd         ����ʱ��
	 * @return
	 * @throws ParseException
	 */
	public static DateInterval dateInterval(Date dateSmallBegin, Date dateBigEnd) throws ParseException {
		DateInterval dateInterval = new DateInterval();
		// ����ʱ���ĺ�����
		long between = dateBigEnd.getTime() - dateSmallBegin.getTime();
		long dayInterval= between/(24*60*60*1000);
		long hourInterval=(between/(60*60*1000)-dayInterval*24);
		long minuteInterval=((between/(60*1000))-dayInterval*24*60-hourInterval*60);
		long secondInterval=(between/1000-dayInterval*24*60*60-hourInterval*60*60-minuteInterval*60);
		dateInterval.setBetweenInterval(between/1000);//����1000��Ϊ��ת������
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
		System.out.println(">>"+dateInterval.getDayInterval()+"��"+dateInterval.getHourInterval()+"Сʱ"+dateInterval.getMinuteInterval()+"��"+dateInterval.getSecondInterval()+"��");
	}
	
	public static void main1(String[] args) {

		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));

		// Calendar��ʹ��
		Calendar cal = Calendar.getInstance();
		System.out.println("ʱ��(������)��" + cal.getTime().getTime());

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd EEE");

		String thetime = formatter.format(cal.getTime());
		System.out.println(thetime);

		// ��
		int year = cal.get(Calendar.YEAR);
		System.out.println("�꣺" + year);

		// ��(java���´�0��ʼ)
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println("�£�" + month);

		// ��
		int day_of_year = cal.get(Calendar.DAY_OF_YEAR);
		int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
		// java��������1,��һ��2,... ������5
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println("��(��)��" + day_of_year);
		System.out.println("��(��)��" + day_of_month);
		System.out.println("��(����)��" + day_of_week);

		// ʱ
		int hour12 = cal.get(Calendar.HOUR);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("ʱ(12)��" + hour12);
		System.out.println("ʱ(24)��" + hour24);

		// ��
		int minute = cal.get(Calendar.MINUTE);
		System.out.println("�֣�" + minute);

		// ��
		int second = cal.get(Calendar.SECOND);
		System.out.println("�룺" + second);

		// ����
		int milliSecond = cal.get(Calendar.MILLISECOND);
		System.out.println("���룺" + milliSecond);

		log.info("����OK");

		// ��ʽ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��/MM��/dd�� HHʱmm��ss��");
		// ȡ��ǰϵͳʱ��,��ʾ��ǰʱ��
		Date now = new Date();
		// ��ʾ��ʽ�����ʱ��
		String s = sdf.format(now);
		log.info(s);

		cal.setTime(now);
		cal.add(Calendar.MINUTE, 30); // 30����֮���ʱ��
		Date last30Minute = cal.getTime();

		s = sdf.format(last30Minute);
		log.info(s);
	}
}
