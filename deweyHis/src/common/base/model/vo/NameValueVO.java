package common.base.model.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameValueVO {
	
	private String value;
	
	private String name;
	
	public NameValueVO(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * list转化为Map对象
	 * @param vos
	 * @return
	 */
	public static Map<String, String> listToMap(List<NameValueVO>  vos) {
		Map<String, String> map = new HashMap<String, String>();
		for (NameValueVO   vo:vos) {
			map.put(vo.value, vo.name);
		}
		return map;
	}
}
