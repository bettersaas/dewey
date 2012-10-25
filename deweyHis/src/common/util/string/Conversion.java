package common.util.string;

/**
 * This class contains the conversions among String, Hex, Bytes and Bits.
 */
public class Conversion {

	/**
	 * Return the hexadecimal format of a plain text string.
	 * 
	 * @param strValue
	 * @return
	 */
	public static String stringToHex(String strValue) {
		byte byteData[] = null;
		int intHex = 0;
		String strHex = "";
		String strReturn = "";
		try {
			byteData = strValue.getBytes("ISO8859-1");
			for (int i = 0; i < byteData.length; i++) {
				intHex = (int) byteData[i];
				if (intHex < 0)
					intHex += 256;
				if (intHex < 16)
					strHex += "0" + Integer.toHexString(intHex).toUpperCase();
				else
					strHex += Integer.toHexString(intHex).toUpperCase();
			}
			strReturn = strHex;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strReturn;
	}

	/**
	 * Convert a hexadecimal string to the plain text string.
	 * 
	 * @param strValue
	 * @return
	 */
	public static String hexToString(String strValue) {
		int len = strValue.length() / 2;
		String strReturn = "";
		String strHex = "";
		int intHex = 0;
		byte byteData[] = new byte[len];
		try {
			for (int i = 0; i < len; i++) {
				strHex = strValue.substring(0, 2);
				strValue = strValue.substring(2);
				intHex = Integer.parseInt(strHex, 16);
				if (intHex > 128)
					intHex = intHex - 256;
				byteData[i] = (byte) intHex;
			}
			strReturn = new String(byteData, "ISO8859-1");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return strReturn;
	}

	/**
	 * Convert a byte to bits.
	 * 
	 * @param b
	 * @return
	 */
	public static String byteToBits(byte b) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 8; i++)
			buf.append((int) (b >> (8 - (i + 1)) & 0x0001));
		return buf.toString();
	}

	/**
	 * Convert a hex string to bytes array.
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] hexToBytes(String str) {
		if (str == null) {
			return null;
		} else if (str.length() < 2) {
			return null;
		} else {
			int len = str.length() / 2;
			byte[] buffer = new byte[len];
			for (int i = 0; i < len; i++) {
				buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
			}
			return buffer;
		}
	}

	/**
	 * Convert a bytes array to hex string.
	 * 
	 * @param data
	 * @return
	 */
	public static String bytesToHex(byte[] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			int num = Integer.valueOf(byteToBits(data[i]), 2);
			if (num < 16) {
				sb.append("0" + Integer.toHexString(num));
			} else {
				sb.append(Integer.toHexString(num));
			}
		}
		return sb.toString().toUpperCase();
	}
}