package common.util.string;

import java.util.regex.*;

public class Regx {
	public static void main(String[] args) {

		String patternStr = "(0?[1-9]|1[0-2]):([0-5]\\d)([a|p]m)";
		String matcherStr = "���ڵ�ʱ��Ϊ 10:51pm,�����Ӫҵʱ��Ϊ��ÿ��8:00am��5:30pm!!!";
		Pattern p = Pattern.compile(patternStr);
		Matcher m = p.matcher(matcherStr);
		StringBuffer sb = new StringBuffer();
		int count = 0;
		System.out.println("��ʼ�ַ���Ϊ��");
		System.out.println(matcherStr);
		while (m.find()) {
			StringBuffer temp = new StringBuffer();
			if (m.group(3).equals("am")) {
				temp.append(m.group(1));
				temp.append(":");
				temp.append(m.group(2));
			} else {
				int time = Integer.parseInt(m.group(1));
				time = time + 12;
				temp.append(time + ":" + m.group(2));
			}
			m.appendReplacement(sb, temp.toString());
			System.out.println("[" + (++count) + "]��" + m.group(0) + "�滻Ϊ"
					+ temp.toString());
		}
		m.appendTail(sb);

		System.out.print("�����Ϊ��");
		System.out.println(sb.toString());
	}
}