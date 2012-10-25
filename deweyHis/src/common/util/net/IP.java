package common.util.net;

import java.net.InetAddress;

public class IP {

	public static void main(String[] args) throws Exception {
		/**
		 * 运行结果：  
		-45 100 26 122  
		211 100 26 122  
		从上面的运行结果可以看出，第一行输出了未转换的IP地址，由于www.keai.cn的IP地址的第一个字节大于127，因此，输出了一个负数。而第二行由于将IP地址的每一个字节转换成了int类型，因此，输出了正常的IP地址。
		 */
		InetAddress address = InetAddress.getByName("www.csdn.net");
		// getAddress方法返回的是byte数组形式的IP地址,返回的byte数组是有符号的
		byte ip[] = address.getAddress();
		for (byte ipSegment : ip)
			System.out.print(ipSegment + " ");
		System.out.println("");
		for (byte ipSegment : ip) {
			int newIPSegment = (ipSegment < 0) ? 256 + ipSegment : ipSegment;
			System.out.print(newIPSegment + " ");
		}
		// getHostAddress方法返回的是字符串形式的IP地址
		String ipStr = address.getHostAddress();
		System.out.print(ipStr + " ");
	}
}
