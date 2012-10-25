package common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;

public class NumberUtil {

	private static final int DEF_DIV_SCALE = 10;

	/**
	 * * ����Double����� *
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
	 * * ����Double����� *
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
	 * * ����Double����� *
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
	 * * ����Double����� *
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
	 * * ����Double�������������scaleλС�� *
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
	 * ��ѧ������
	 * 
	 * @param cellValue
	 * @return
	 */
	public BigDecimal toBigDecimal(double cellValue) {
		String resultString = String.valueOf(cellValue);

		// ��Կ�ѧ�������Ĵ���(����С��λ����ȷ��5λ)
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
		// 1) ��ʽ������(�Ѹ�����ת��Ϊ����)
		NumberFormat nf = NumberFormat.getIntegerInstance();
		double v = 12.6;
		System.out.println(nf.format(v)); // ������13����Ϊ�Զ�����ġ�

		// 2����ʽ����������������λС��,�Զ���λ,����Ҳ���ԣ�
		DecimalFormat df = new DecimalFormat("#.##");
		double v1 = 12.126;
		String s = df.format(v1);
		System.out.println(s); // ����Ľ��Ϊ:12.13

		// 3) ��ʽ������������Ϊxx%��ʽ��
		NumberFormat nf1 = NumberFormat.getPercentInstance();
		double s1 = 0.6145;
		System.out.println(nf1.format(s1)); // ���61%
	}
}
