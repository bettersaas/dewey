package common.util.json.test;

import java.util.ArrayList;
import java.util.List;

public class JsonArrDemoTest {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Jack", 20));
		personList.add(new Person("Chris", 25));
		String jsonArr = toJsonArray(personList);
		System.out.println(jsonArr);
		/**
		 * 页面处理
		    window.onload = function(){  
			    var str = "{personArr:[{\"name\":\"jack\",\"age\":20},{\"name\":\"tom\",\"age\":25}]}";//此处就是传递过来的json对象  
			    var jsonobj = eval("("+str+")");  
			    alert(jsonobj.personArr.length);  
			    for(i = 0 ;  i<jsonobj.personArr.length; i++){  
			        alert(jsonobj.personArr[i].age);  
			    }  
			}  
		 */
	}

	public static String toJsonArray(List<Person> list) {
		if (null == list || list.size() == 0)
			throw new RuntimeException("数组列表为空!");
		StringBuilder sb = new StringBuilder();
		int size = list.size();
		sb.append("{");
		sb.append("personArr:[");
		for (int i = 0; i < size; i++) {
			sb.append(list.get(i).toString());
			if (size > 1 && i < (size - 1)) {
				sb.append(",");
			}
		}
		sb.append("]}");
		return sb.toString();
	}
}

class Person {

	String name;
	int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\",\"age\":" + age + "}";
	}
}
