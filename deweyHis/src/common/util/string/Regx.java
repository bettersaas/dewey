package common.util.string;

import java.util.regex.*;

public class Regx {
	public static void main(String[] args) {

		String patternStr = "(0?[1-9]|1[0-2]):([0-5]\\d)([a|p]m)";
		String matcherStr = "现在的时刻为 10:51pm,这里的营业时间为：每天8:00am至5:30pm!!!";
		Pattern p = Pattern.compile(patternStr);
		Matcher m = p.matcher(matcherStr);
		StringBuffer sb = new StringBuffer();
		int count = 0;
		System.out.println("初始字符串为：");
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
			System.out.println("[" + (++count) + "]将" + m.group(0) + "替换为"
					+ temp.toString());
		}
		m.appendTail(sb);

		System.out.print("最后结果为：");
		System.out.println(sb.toString());
	}
}