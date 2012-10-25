package common.util.net;

import java.net.InetAddress;

public class IP {

	public static void main(String[] args) throws Exception {
		/**
		 * ���н����  
		-45 100 26 122  
		211 100 26 122  
		����������н�����Կ�������һ�������δת����IP��ַ������www.keai.cn��IP��ַ�ĵ�һ���ֽڴ���127����ˣ������һ�����������ڶ������ڽ�IP��ַ��ÿһ���ֽ�ת������int���ͣ���ˣ������������IP��ַ��
		 */
		InetAddress address = InetAddress.getByName("www.csdn.net");
		// getAddress�������ص���byte������ʽ��IP��ַ,���ص�byte�������з��ŵ�
		byte ip[] = address.getAddress();
		for (byte ipSegment : ip)
			System.out.print(ipSegment + " ");
		System.out.println("");
		for (byte ipSegment : ip) {
			int newIPSegment = (ipSegment < 0) ? 256 + ipSegment : ipSegment;
			System.out.print(newIPSegment + " ");
		}
		// getHostAddress�������ص����ַ�����ʽ��IP��ַ
		String ipStr = address.getHostAddress();
		System.out.print(ipStr + " ");
	}
}
