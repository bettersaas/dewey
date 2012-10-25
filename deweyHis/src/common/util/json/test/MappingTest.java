package common.util.json.test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.junit.Test;

import common.util.json.CustomDateSerializer;

public class MappingTest {

	// 这是作用于类的annotation，主要用于指明该类使用annotation，并且可以自动侦测getter，setter，构造方法，以便生成json对象
	@JsonAutoDetect
	@JsonIgnoreProperties(value = {"password"})  
	public static class User {
		private String name;
		@JsonIgnore
		private String password;
		private Date birthday;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@JsonSerialize(using = CustomDateSerializer.class)
		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}
	
	public static class User1 {
		private String name;
		private Date birthday;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getBirthday() {
			return birthday;
		}

		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
	}
	
	@Test
	public void custDateJson1() throws Exception {
		System.out.println(">>>>>>>>>>annotaion的注释方式>>>Start>>>>>");
		// 构建JSON对象
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user.setBirthday(new Date());
		user.setName("name");
		String str = mapper.writeValueAsString(user);
		System.out.println(str);
		User user1 = new User();
		user1.setBirthday(null);
		user1.setName("name");
		String str1 = mapper.writeValueAsString(user1);
		System.out.println(str1);
		System.out.println(">>>>>>>>annotaion的注释方式>>>>End>>>>");
	}

	@Test
	public void custDateJson() throws JsonGenerationException, JsonMappingException, IOException {
		// 构建JSON对象
		ObjectMapper mapper = new ObjectMapper();
		CustomSerializerFactory sf = new CustomSerializerFactory();
		mapper.setSerializerFactory(sf);
		sf.addGenericMapping(Date.class, new JsonSerializer<Date>() {
			public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
				System.out.println(value);
				// jackson 会对null单独处理，如果Date类型为null就不会运行到这里
				// 我现在想要的是：就算date为null的时候我也想做一些处理，
				// 就像json-lib里的jsonConfig.registerJsonValueProcessor
				// 一样,不会对null单独处理
				// 注：setNullValueSerializer可以处理所有的空属性，但我想按类型分开
				// 最好不要用注解的，因为我想运行时可控
				jgen.writeObject("时间");
			}
		});
		User1 user = new User1();
		user.setBirthday(new Date());
		user.setName("name");
		String str = mapper.writeValueAsString(user);
		System.out.println(str);

		User1 user1 = new User1();
		user1.setBirthday(null);
		user1.setName("name");
		String str1 = mapper.writeValueAsString(user1);
		System.out.println(str1);
	}
	
	@Test
	public void custDateJson2() throws Exception {
		System.out.println(">>>>>>>>>>>>Start>>>>>");
		User1 user1 = new User1();
		user1.setBirthday(null);
		user1.setName("name");
		
		StringWriter sw = new StringWriter();
		JsonGenerator gen = new JsonFactory().createJsonGenerator(sw);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(gen, user1);
		gen.close();   
		String finalInfo = sw.toString();   
		System.out.println("finalinfo is:"+finalInfo ); 
		System.out.println(">>>>>>>>>>>>End>>>>>");
	}
	
	@Test
	public void jsonArray () throws JSONException {
		System.out.println(">>>>>>>>>>>>Json数组字符串>>>>>");
		User1 user = new User1();
		user.setBirthday(new Date());
		user.setName("name");
		User1 user1 = new User1();
		user1.setBirthday(null);
		user1.setName("name");
		
		List<User1> list = new ArrayList<User1>();
		list.add(user);
		list.add(user1);
		
		StringWriter sw = new StringWriter();
		JSONArray jsonarray = new JSONArray();
		jsonarray.put(list);
		jsonarray.write(sw);
		String finalInfo = sw.toString();   
		System.out.println("finalinfo is:"+finalInfo ); 
		
		System.out.println(">>>>>>>>>>>>Json数组字符串>>>>>");
	}
}