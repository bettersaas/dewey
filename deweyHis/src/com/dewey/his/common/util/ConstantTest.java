package com.dewey.his.common.util;


import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Administrator
 *
 */
public class ConstantTest {
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void getFunctionsTreeConstantJsonTest() throws JsonGenerationException, JsonMappingException, IOException {
		// ϵͳ����json�ַ���
		System.out.println((Constant.getFunctionsTreeConstantJson()));
	}
	
	@Test
	public void getPrettyPrintingFunctionsTreeConstantJsonTest() {
		// ϵͳ����json�ַ���
		System.out.println((Constant.getPrettyPrintFunsTreeConstantJson()));
	}
	
	@Test
	public void getPrettyPrintingFunctionsTreeConstantJsonTest1() {
		// ϵͳ����json�ַ���
		System.out.println((Constant.getPrettyPrintFunsTreeConstantJson()));
	}
}
