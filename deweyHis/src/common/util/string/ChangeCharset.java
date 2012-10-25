package common.util.string;

import java.io.UnsupportedEncodingException;

/**
 * 
 * ת���ַ����ı���
 * 
 * java�е�String���ǰ���unicode���б���ģ���ʹ��String(byte[] bytes, String encoding)�����ַ���ʱ��
 * encoding��ָ����bytes�е������ǰ������ַ�ʽ����ģ���������������String��ʲô���뷽ʽ�����仰˵������ϵͳ��bytes�е�������encoding���뷽ʽת����unicode���롣
 * �����ָ����bytes�ı��뷽ʽ����jdk���ݲ���ϵͳ������
 * �����Ǵ��ļ��ж�����ʱ�����ʹ��InputStream��ʽ��Ȼ�����String(byte[] bytes, String
 * encoding)ָ���ļ��ı��뷽ʽ����Ҫʹ��Reader��ʽ����ΪReader��ʽ���Զ�����jdkָ��
 * 
 * �ı��뷽ʽ���ļ�����ת����unicode ���롣
 * �����Ǵ����ݿ��ж��ı�����ʱ������ResultSet.getBytes()����ȡ���ֽ����飬ͬ�����ô����뷽ʽ���ַ������췽�����ɡ� ResultSet
 * rs; bytep[] bytes = rs.getBytes(); String str = new String(bytes, "gb2312");
 * ��Ҫ��ȡ����Ĳ��衣 ResultSet rs; String str = rs.getString(); str = new
 * String(str.getBytes("iso8859-1"), "gb2312");
 * ���ֱ���ת����ʽЧ�ʵס�֮������ô����ԭ���ǣ�ResultSet��getString()����ִ��ʱ��Ĭ�����ݿ�������ݱ��뷽ʽΪiso8859- 1��
 * ϵͳ�����������iso8859-1�ı��뷽ʽת����unicode�� ʹ��str.getBytes("iso8859-1")�����ݻ�ԭ��Ȼ������ new
 * String(bytes, "gb2312")�����ݴ�gb2312ת����unicode���м���˺öಽ�衣
 * ��HttpRequest�ж�����ʱ������reqeust.setCharacterEncoding()�������ñ��뷽ʽ�����������ݾ�����ȷ���ˡ�
 * 
 */
public class ChangeCharset {

	/** 7λASCII�ַ���Ҳ����ISO646-US��Unicode�ַ����Ļ��������� */
	public static final String US_ASCII = "US-ASCII";

	/**
	 * ISO ������ĸ�� No.1��Ҳ���� ISO-LATIN-1
	 */
	public static final String ISO_8859_1 = "ISO-8859-1";

	/**
	 * 8 λ UCS
	 */
	public static final String UTF_8 = "UTF-8";

	/**
	 * 16 λ UCS ת����ʽ��Big Endian����͵�ַ��Ÿ�λ�ֽڣ��ֽ�˳��
	 */
	public static final String UTF_16BE = "UTF-16BE";

	/**
	 * 16 λ UCS ת����ʽ��Little-endian����ߵ�ַ��ŵ�λ�ֽڣ��ֽ�˳��
	 */
	public static final String UTF_16LE = "UTF-16LE";

	/**
	 * 16 λ UCS ת����ʽ���ֽ�˳���ɿ�ѡ���ֽ�˳��������ʶ
	 */
	public static final String UTF_16 = "UTF-16";

	/**
	 * ���ĳ����ַ���
	 */
	public static final String GBK = "GBK";

	/**
	 * * ���ַ�����ת����US- * ASCII��
	 */
	public String toASCII(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, US_ASCII);
	}

	/**
	 * * ���ַ�����ת����ISO-8859-1��
	 */
	public String toISO_8859_1(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, ISO_8859_1);
	}

	/**
	 * * ���ַ�����ת����UTF-8��
	 */
	public String toUTF_8(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_8);
	}

	/**
	 * * ���ַ�����ת����UTF-16BE��
	 */
	public String toUTF_16BE(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16BE);
	}

	/**
	 * * ���ַ�����ת����UTF-16LE��
	 */
	public String toUTF_16LE(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16LE);
	}

	/**
	 * * ���ַ�����ת����UTF-16��
	 */
	public String toUTF_16(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, UTF_16);
	}

	/**
	 * * ���ַ�����ת����GBK��
	 */
	public String toGBK(String str) throws UnsupportedEncodingException {
		return this.changeCharset(str, GBK);
	}

	/**
	 * * �ַ�������ת����ʵ�ַ��� *
	 * 
	 * @param str
	 *            ��ת��������ַ��� *
	 * @param newCharset
	 *            Ŀ����� *
	 * @return *
	 * @throws UnsupportedEncodingException
	 */
	public String changeCharset(String str, String newCharset) throws UnsupportedEncodingException {
		if (str != null) {
			// ��Ĭ���ַ���������ַ�����
			byte[] bs = str.getBytes();
			// ���µ��ַ����������ַ���
			return new String(bs, newCharset);
		}
		return null;
	}

	/**
	 * * �ַ�������ת����ʵ�ַ���
	 * 
	 * @param str
	 *            ��ת��������ַ��� *
	 * @param oldCharset
	 *            ԭ���� *
	 * @param newCharset
	 *            Ŀ����� *
	 * @return *
	 * @throws UnsupportedEncodingException
	 */
	public String changeCharset(String str, String oldCharset, String newCharset) throws UnsupportedEncodingException {
		if (str != null) {
			// �þɵ��ַ���������ַ�����������ܻ�����쳣��
			byte[] bs = str.getBytes(oldCharset); // ���µ��ַ����������ַ���
			return new String(bs, newCharset);
		}
		return null;
	}

	/**
	 * ��ָ��byte������16���Ƶ���ʽ��ӡ������̨
	 * 
	 * @param hint
	 *            String
	 * @param b
	 *            byte[]
	 * @return void
	 */
	public static void printHexString(String hint, byte[] b) {
		System.out.print(hint);
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			System.out.print(hex.toUpperCase() + " ");
		}
		System.out.println("");
	}

	/**
	 * 
	 * @param b
	 *            byte[]
	 * @return String
	 */
	public static String Bytes2HexString(byte[] b) {
		String ret = "";
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase();
		}
		return ret;
	}

	/**
	 * ������ASCII�ַ��ϳ�һ���ֽڣ� �磺"EF"--> 0xEF
	 * 
	 * @param src0
	 *            byte
	 * @param src1
	 *            byte
	 * @return byte
	 */
	public static byte uniteBytes(byte src0, byte src1) {
		byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 })).byteValue();
		_b0 = (byte) (_b0 << 4);
		byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 })).byteValue();
		byte ret = (byte) (_b0 ^ _b1);
		return ret;
	}

	/**
	 * ��ָ���ַ���src����ÿ�����ַ��ָ�ת��Ϊ16������ʽ �磺"2B44EFD9" --> byte[]{0x2B, 0x44, 0xEF,
	 * 0xD9}
	 * 
	 * @param src
	 *            String
	 * @return byte[]
	 */
	public static byte[] HexString2Bytes(String src) {
		byte[] ret = new byte[8];
		byte[] tmp = src.getBytes();
		for (int i = 0; i < 8; i++) {
			ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
		}
		return ret;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		ChangeCharset test = new ChangeCharset();
		// String str = "This is a ���ĵ� String!";
		String str = "�й�";
		System.out.println("str: " + str + "        " + Bytes2HexString(str.getBytes()));
		String gbk = test.toGBK(str);
		System.out.println("ת����GBK��: " + gbk);
		System.out.println();
		String ascii = test.toASCII(str);
		System.out.println("ת����US-ASCII��: " + ascii);
		gbk = test.changeCharset(ascii, ChangeCharset.US_ASCII, ChangeCharset.GBK);
		System.out.println("�ٰ�ASCII����ַ���ת����GBK��: " + gbk);
		System.out.println();
		String iso88591 = test.toISO_8859_1(str);
		System.out.println("ת����ISO-8859-1��: " + iso88591);
		gbk = test.changeCharset(iso88591, ChangeCharset.ISO_8859_1, ChangeCharset.GBK);
		System.out.println("�ٰ�ISO-8859-1����ַ���ת����GBK��: " + gbk);
		System.out.println();
		String utf8 = test.toUTF_8(str);
		System.out.println("ת����UTF-8��: " + utf8);
		gbk = test.changeCharset(utf8, ChangeCharset.UTF_8, ChangeCharset.GBK);
		System.out.println("�ٰ�UTF-8����ַ���ת����GBK��: " + gbk);
		System.out.println();
		String utf16be = test.toUTF_16BE(str);
		System.out.println("ת����UTF-16BE��:" + utf16be);
		gbk = test.changeCharset(utf16be, ChangeCharset.UTF_16BE, ChangeCharset.GBK);
		System.out.println("�ٰ�UTF-16BE����ַ���ת����GBK��: " + gbk);
		System.out.println();
		String utf16le = test.toUTF_16LE(str);
		System.out.println("ת����UTF-16LE��:" + utf16le);
		gbk = test.changeCharset(utf16le, ChangeCharset.UTF_16LE, ChangeCharset.GBK);
		System.out.println("�ٰ�UTF-16LE����ַ���ת����GBK��: " + gbk);
		System.out.println();
		String utf16 = test.toUTF_16(str);
		System.out.println("ת����UTF-16��:" + utf16);
		gbk = test.changeCharset(utf16, ChangeCharset.UTF_16LE, ChangeCharset.GBK);
		System.out.println("�ٰ�UTF-16����ַ���ת����GBK��: " + gbk);
		String s = new String("����".getBytes("UTF-8"), "UTF-8");
		System.out.println(s);
	}
}