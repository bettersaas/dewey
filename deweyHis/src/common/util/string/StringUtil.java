package common.util.string;

import java.io.InputStream;
import java.lang.StringBuffer;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * 字符串工具
 */

public class StringUtil {

	/**
	 * 转换数据流到字符串
	 * 
	 * @param is
	 *            InputStream
	 * @throws IOException
	 * @return String
	 */
	public static String convertInputStreamToString(InputStream is) throws java.io.IOException {
		StringBuffer sb = new StringBuffer();
		String s = null;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
		}
		isr.close();
		br.close();
		return sb.toString();
	}

	/**
	 * JAVA区分中文和英文
	 * 
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
				|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A) {
			return true;
		}
		return false;
	}

	/**
	 * 补齐需要的字符位数
	 * @param num        要求的字符个数
	 * @param result      需要补齐的字符串
	 * @param addStr    需要补白的字符串
	 * @param leftFlag   左补标志，为true左边补齐，否则右边补齐
	 * @return
	 */
	public static String leftAddNChar(int num, String result, String addStr, boolean leftFlag) {
		while (num > result.length()) {
			if (leftFlag) {
				result = addStr + result;
			} else {
				result = result + addStr;
			}
		}
		return result;
	}

}
