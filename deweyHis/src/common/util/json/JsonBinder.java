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
 * JSON������
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
		//�����������������  
		mapper.getSerializationConfig().setSerializationInclusion(inclusion);
		//��������ʱ����JSON�ַ����д��ڶ�Java����ʵ��û�е�����  
		mapper.getDeserializationConfig().set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// Ĭ����ת��timestamps��ʽ�ģ�ͨ�����淽ʽ����ȡ��timestamps
		// mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		// 
		// mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
	}

	/** 
	 * �������ȫ�����Ե�Json�ַ�����Binder. 
	 */
	public static JsonBinder buildNormalBinder() {
		return new JsonBinder(Inclusion.ALWAYS);
	}

	/** 
	 * ����ֻ����ǿ����Ե�Json�ַ�����Binder. 
	 */
	public static JsonBinder buildNonNullBinder() {
		return new JsonBinder(Inclusion.NON_NULL);
	}

	/** 
	 * ����ֻ�����ʼֵ���ı�����Ե�Json�ַ�����Binder. 
	 */
	public static JsonBinder buildNonDefaultBinder() {
		return new JsonBinder(Inclusion.NON_DEFAULT);
	}

	/** 
	 * ���JSON�ַ���ΪNull��"null"�ַ���,����Null. 
	 * ���JSON�ַ���Ϊ"[]",���ؿռ���. 
	 *  
	 * �����ȡ������List/Map,�Ҳ���List<String>���ּ�����ʱʹ���������: 
	 * List<MyBean> beanList = binder.getMapper().readValue(listString, new TypeReference<List<MyBean>>() {}); 
	 */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}
		try {
			/** 
			 * 1��JSONתPOJOʱ����JSON�е�ĳ���ֶ���POJO��δ���壬��Ĭ������»����쳣ת��ʧ�ܣ�ֻҪ����������ã�
			 * Feature.FAIL_ON_UNKNOWN_PROPERTIES, false
			 * �Ϳ���ת����������ֻת��������ֶΣ�δ������ֶκ��ԡ�
			 * 2��
			 *  Map map = new ObjectMapper().readValue("{\"a\":1, \"b\":2}", HashMap.class); 
			 *  �ļ򻯰棺
			 *  Map map = new ObjectMapper().configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true).readValue("{a:1, b:2}", HashMap.class);
			 */
			return mapper.readValue(jsonString, clazz);
		} catch (IOException e) {
			logger.warn("parse json string error:" + jsonString, e);
			return null;
		}
	}

	/** 
	 * �������ΪNull,����"null". 
	 * �������Ϊ�ռ���,����"[]". 
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
	 * �������ΪNull,����"null". 
	 * �������Ϊ�ռ���,����"[]". 
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
	 * ���ҳ��json�ַ���
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
	 * ����ת���������͵�format pattern,���������Ĭ�ϴ�ӡTimestamp������. 
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
	 * ȡ��Mapper����һ�������û�ʹ���������л�API. 
	 */
	public ObjectMapper getMapper() {
		return mapper;
	}
	
//	/** 
//	 * ���л�����/���ϵ�Json�ַ���
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
//	  * ��Json�ַ��������л�����/����. 
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
