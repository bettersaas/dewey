package common.util.string;

import java.io.InputStream;
import java.lang.StringBuffer;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * �ַ�������
 */

public class StringUtil {

	/**
	 * ת�����������ַ���
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
	 * JAVA�������ĺ�Ӣ��
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
	 * ������Ҫ���ַ�λ��
	 * @param num        Ҫ����ַ�����
	 * @param result      ��Ҫ������ַ���
	 * @param addStr    ��Ҫ���׵��ַ���
	 * @param leftFlag   �󲹱�־��Ϊtrue��߲��룬�����ұ߲���
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
