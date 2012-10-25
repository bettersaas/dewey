package common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;

public class NumberUtil {

	private static final int DEF_DIV_SCALE = 10;

	/**
	 * * 两个Double数相加 *
	 * 
	 * @param v1 *
	 * @param v2 *
	 * @return Double
	 */
	public static Double add(Double v1, Double v2) {
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.add(b2).doubleValue();
	}

	/**
	 * * 两个Double数相减 *
	 * 
	 * @param v1 *
	 * @param v2 *
	 * @return Double
	 */
	public static Double sub(Double v1, Double v2) {
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * * 两个Double数相乘 *
	 * 
	 * @param v1 *
	 * @param v2 *
	 * @return Double
	 */
	public static Double mul(Double v1, Double v2) {
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * * 两个Double数相除 *
	 * 
	 * @param v1 *
	 * @param v2 *
	 * @return Double
	 */
	public static Double div(Double v1, Double v2) {
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.divide(b2, DEF_DIV_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * * 两个Double数相除，并保留scale位小数 *
	 * 
	 * @param v1 *
	 * @param v2 *
	 * @param scale *
	 * @return Double
	 */
	public static Double div(Double v1, Double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(v1.toString());
		BigDecimal b2 = new BigDecimal(v2.toString());
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	static final Pattern pattern = Pattern.compile("[eE]");

	/**
	 * 科学计数法
	 * 
	 * @param cellValue
	 * @return
	 */
	public BigDecimal toBigDecimal(double cellValue) {
		String resultString = String.valueOf(cellValue);

		// 针对科学计数法的处理(对于小数位数精确到5位)
		if (pattern.matcher(resultString).find()) {
			DecimalFormat format = new DecimalFormat("#####.#####");
			resultString = format.format(cellValue);
		}

		if (resultString.endsWith(".0")) {
			resultString = resultString.substring(0, resultString.length() - 2);
		}

		BigDecimal result = new BigDecimal(resultString);
		return result;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1) 格式化整数(把浮点数转化为整数)
		NumberFormat nf = NumberFormat.getIntegerInstance();
		double v = 12.6;
		System.out.println(nf.format(v)); // 输出结果13，因为自动舍入的。

		// 2）格式化浮点数（保留两位小数,自动进位,负数也可以）
		DecimalFormat df = new DecimalFormat("#.##");
		double v1 = 12.126;
		String s = df.format(v1);
		System.out.println(s); // 输出的结果为:12.13

		// 3) 格式化浮点数（变为xx%形式）
		NumberFormat nf1 = NumberFormat.getPercentInstance();
		double s1 = 0.6145;
		System.out.println(nf1.format(s1)); // 输出61%
	}
}
