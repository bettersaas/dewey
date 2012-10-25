package common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Java���������3��ʵ�ַ�ʽ
 * 
 * @author
 */
public class ObjectSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * ����1 ʹ��Collections.sort(List,
		 * Comparator)ʵ�֣�����ʵ��Comparator��һ���Ƚ�������дcompare()����
		 */
		Person1[] ps = new Person1[] { new Person1("p0", 0),
				new Person1("p1", 3), new Person1("p2", 5),
				new Person1("p3", 4), new Person1("p4", 8),
				new Person1("p5", 6), new Person1("p6", 7),
				new Person1("p7", 1), new Person1("p8", 2),
				new Person1("p9", 9) };
		List<Person1> pl = new ArrayList<Person1>();
		for (int i = 0; i < 10; i++) {
			System.out.print(ps[i].getAge());
			pl.add(ps[i]);
		}
		System.out.println("\nʹ��Collections.sort(List, Comparator)�����Ƚϣ�");
		long l1 = System.currentTimeMillis();
		Collections.sort(pl, new MyComparator());
		System.out.println("time: " + (System.currentTimeMillis() - l1));
		for (Iterator<Person1> it = pl.iterator(); it.hasNext();) {
			Person1 p = (Person1) it.next();
			System.out.print(p.getAge());
		}
		/**
		 * ����2 ʹ��Arrays.sort(Object[])ʵ��,�������ʵ��Comparable�ӿڲ���дcompareTo()����
		 */
		Person2[] ps2 = new Person2[] { new Person2("p0", 0),
				new Person2("p1", 3), new Person2("p2", 5),
				new Person2("p3", 4), new Person2("p4", 8),
				new Person2("p5", 6), new Person2("p6", 7),
				new Person2("p7", 1), new Person2("p8", 2),
				new Person2("p9", 9) };
		System.out.println("\nʹ��Arrays.sort(Object[])�����Ƚϣ�");
		long l2 = System.currentTimeMillis();
		Arrays.sort(ps2);
		System.out.println("time: " + (System.currentTimeMillis() - l2));

		for (int i = 0; i < 10; i++) {
			System.out.print(ps2[i].getAge());
		}
		/**
		 * ����3 ʹ��Collections.sort(List)ʵ�֣��������ʵ��Comparable�ӿڲ���дcompareTo()����
		 */
		Person2[] ps3 = new Person2[] { new Person2("p0", 0),
				new Person2("p1", 3), new Person2("p2", 5),
				new Person2("p3", 4), new Person2("p4", 8),
				new Person2("p5", 6), new Person2("p6", 7),
				new Person2("p7", 1), new Person2("p8", 2),
				new Person2("p9", 9) };
		List<Person2> pl3 = new ArrayList<Person2>();
		for (int i = 0; i < 10; i++) {
			pl3.add(ps3[i]);
		}
		System.out.println("\nʹ��Collections.sort(List)�����Ƚϣ�");
		Collections.sort(pl3);
		for (Iterator<Person2> it = pl3.iterator(); it.hasNext();) {
			Person2 p = (Person2) it.next();
			System.out.print(p.getAge());
		}
	}
}

/**
 * ����1��Ҫ
 */
class MyComparator implements Comparator<Object> {
	public int compare(Object o1, Object o2) {
		Person1 p1 = (Person1) o1;
		Person1 p2 = (Person1) o2;
		if (p1.getAge() < p2.getAge()) {
			return -1;
		} else if (p1.getAge() == p2.getAge()) {
			return 0;
		} else {
			return 1;
		}
	}
}

/**
 * ����1��Ҫ
 * @author zhangwenzhang
 */
class Person1 {
	private String name;
	private int age;

	public Person1() {
	}

	public Person1(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

/**
 * ����2,3��Ҫ
 */
class Person2 implements Comparable<Object> {
	private String name;
	private int age;

	public Person2() {
	}

	public Person2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int compareTo(Object o) {
		Person2 p = (Person2) o;
		if (this.age < p.age) {
			return -1;
		} else if (this.age == p.age) {
			return 0;
		} else {
			return 1;
		}
	}

}
