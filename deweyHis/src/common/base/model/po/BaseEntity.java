package common.base.model.po;

import java.io.Serializable;
import java.util.Date;

import common.util.date.DateUtil;

@SuppressWarnings("serial")
public class BaseEntity implements  Serializable {

	/**
	 * 日期格式
	 */
	protected static final String DATE_FORMAT = "yyyy-MM-dd";

	protected static final String TIME_FORMAT = "HH:mm:ss";

	protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

	public static String date2String(java.util.Date date, String dateFormat) {
		return DateUtil.format(date, dateFormat);
	}

	public static Date string2Date(String dateString,String dateFormat,Class<?> targetResultType) {
		return DateUtil.parse(dateString, dateFormat, targetResultType);
	}
}
