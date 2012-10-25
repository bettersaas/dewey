package common.util.json;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
//import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JSON处理类
 * @author Administrator
 *
 */
public class JsonBinder {

	private static Logger logger = LoggerFactory.getLogger(JsonBinder.class);

	private ObjectMapper mapper;

	public JsonBinder() {
		mapper = new ObjectMapper();
	}
	
	public JsonBinder(Inclusion inclusion) {
		mapper = new ObjectMapper();
		//设置输出包含的属性  
		mapper.getSerializationConfig().setSerializationInclusion(inclusion);
		//设置输入时忽略JSON字符串中存在而Java对象实际没有的属性  
		mapper.getDeserializationConfig().set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 默认是转成timestamps形式的，通过下面方式可以取消timestamps
		// mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		// 
		// mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}

	/** 
	 * 创建输出全部属性到Json字符串的Binder. 
	 */
	public static JsonBinder buildNormalBinder() {
		return new JsonBinder(Inclusion.ALWAYS);
	}

	/** 
	 * 创建只输出非空属性到Json字符串的Binder. 
	 */
	public static JsonBinder buildNonNullBinder() {
		return new JsonBinder(Inclusion.NON_NULL);
	}

	/** 
	 * 创建只输出初始值被改变的属性到Json字符串的Binder. 
	 */
	public static JsonBinder buildNonDefaultBinder() {
		return new JsonBinder(Inclusion.NON_DEFAULT);
	}

	/** 
	 * 如果JSON字符串为Null或"null"字符串,返回Null. 
	 * 如果JSON字符串为"[]",返回空集合. 
	 *  
	 * 如需读取集合如List/Map,且不是List<String>这种简单类型时使用如下语句: 
	 * List<MyBean> beanList = binder.getMapper().readValue(listString, new TypeReference<List<MyBean>>() {}); 
	 */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			/** 
			 * 1、JSON转POJO时，若JSON中的某个字段在POJO中未定义，在默认情况下会抛异常转换失败，只要增加这个配置：
			 * Feature.FAIL_ON_UNKNOWN_PROPERTIES, false
			 * 就可以转换正常，即只转换定义的字段，未定义的字段忽略。
			 * 2、
			 *  Map map = new ObjectMapper().readValue("{\"a\":1, \"b\":2}", HashMap.class); 
			 *  的简化版：
			 *  Map map = new ObjectMapper().configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).readValue("{a:1, b:2}", HashMap.class);
			 */
			return mapper.readValue(jsonString, clazz);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
			return null;
		}
	}

	/** 
	 * 如果对象为Null,返回"null". 
	 * 如果集合为空集合,返回"[]". 
	 */
	public String toJson(Object object) {
		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			logger.warn("write to json string error:" + object, e);
			return null;
		}
	}
	
	/**
	 * 如果对象为Null,返回"null". 
	 * 如果集合为空集合,返回"[]". 
	 * @param object
	 * @return
	 */
	public String toPrettyPrintingJson(Object object) {
		try {
			return mapper.defaultPrettyPrintingWriter().writeValueAsString(object);
		} catch (JsonGenerationException e) {
			logger.warn("write to json string error:" + object, e);
			return null;
		} catch (JsonMappingException e) {
			logger.warn("write to json string error:" + object, e);
			return null;
		} catch (IOException e) {
			logger.warn("write to json string error:" + object, e);
			return null;
		}
	}
	
	/**
	 * 输出页面json字符串
	 * @param out
	 * @param value
	 */
	public void writeToPage(OutputStream out, Object object) {
		try {
			mapper.writeValue(out, object);
		} catch (JsonGenerationException e) {
			logger.warn("write to json string error:" + object, e);
		} catch (JsonMappingException e) {
			logger.warn("write to json string error:" + object, e);
		} catch (IOException e) {
			logger.warn("write to json string error:" + object, e);
		}
	}

	/** 
	 * 设置转换日期类型的format pattern,如果不设置默认打印Timestamp毫秒数. 
	 */
	@SuppressWarnings("deprecation")
	public void setDateFormat(String pattern) {
		mapper.getSerializationConfig().set(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		if (StringUtils.isNotBlank(pattern)) {
			DateFormat dateFormat = new SimpleDateFormat(pattern);
			mapper.getSerializationConfig().setDateFormat(dateFormat);
			mapper.getDeserializationConfig().setDateFormat(dateFormat);
		}
	}

	/** 
	 * 取出Mapper做进一步的设置或使用其他序列化API. 
	 */
	public ObjectMapper getMapper() {
		return mapper;
	}
	
//	/** 
//	 * 序列化对象/集合到Json字符串
//	 */
//	@Test
//	public void toJson() throws Exception {  
//	    //Bean  
//	    TestBean bean = new TestBean("A");  
//	    String beanString = binder.toJson(bean);  
//	    System.out.println("Bean:" + beanString);  
//	     assertEquals("{\"name\":\"A\"}", beanString);  
//
//	     //Map  
//	     Map<String, Object> map = Maps.newLinkedHashMap();  
//	     map.put("name", "A");  
//	     map.put("age", 2);  
//	     String mapString = binder.toJson(map);  
//	     System.out.println("Map:" + mapString);  
//	     assertEquals("{\"name\":\"A\",\"age\":2}", mapString);  
//
//	     //List<String>  
//	     List<String> stringList = Lists.newArrayList("A", "B", "C");  
//	     String listString = binder.toJson(stringList);  
//	     System.out.println("String List:" + listString);  
//	     assertEquals("[\"A\",\"B\",\"C\"]", listString);  
//
//	     //List<Bean>  
//	     List<TestBean> beanList = Lists.newArrayList(new TestBean("A"), new TestBean("B"));  
//	     String beanListString = binder.toJson(beanList);  
//	     System.out.println("Bean List:" + beanListString);  
//	     assertEquals("[{\"name\":\"A\"},{\"name\":\"B\"}]", beanListString);  
//
//	     //Bean[]  
//	     TestBean[] beanArray = new TestBean[] { new TestBean("A"), new TestBean("B") };  
//	     String beanArrayString = binder.toJson(beanArray);  
//	     System.out.println("Array List:" + beanArrayString);  
//	     assertEquals("[{\"name\":\"A\"},{\"name\":\"B\"}]", beanArrayString);  
//	 }  
//
//	 /** 
//	  * 从Json字符串反序列化对象/集合. 
//	  */  
//	 @Test  
//	 @SuppressWarnings("unchecked")  
//	 public void fromJson() throws Exception {  
//	     //Bean  
//	     String beanString = "{\"name\":\"A\"}";  
//	     TestBean bean = binder.fromJson(beanString, TestBean.class);  
//	     System.out.println("Bean:" + bean);  
//
//	     //Map  
//	     String mapString = "{\"name\":\"A\",\"age\":2}";  
//	     Map<String, Object> map = binder.fromJson(mapString, HashMap.class);  
//	     System.out.println("Map:");  
//	     for (Entry<String, Object> entry : map.entrySet()) {  
//	         System.out.println(entry.getKey() + " " + entry.getValue());  
//	     }  
//
//	     //List<String>  
//	     String listString = "[\"A\",\"B\",\"C\"]";  
//	     List<String> stringList = binder.getMapper().readValue(listString, List.class);  
//	     System.out.println("String List:");  
//	     for (String element : stringList) {  
//	         System.out.println(element);  
//	     }  
//
//	     //List<Bean>  
//	     String beanListString = "[{\"name\":\"A\"},{\"name\":\"B\"}]";  
//	     List<TestBean> beanList = binder.getMapper().readValue(beanListString, new TypeReference<List<TestBean>>() {  
//	     });  
//	     System.out.println("Bean List:");
//	     for (TestBean element : beanList) {
//	         System.out.println(element);
//	     }
//	 }
}
