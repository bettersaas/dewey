package test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class RedirectViewTest extends TestCase {

	protected MockHttpServletRequest request = new MockHttpServletRequest("GET", "");
	protected MockHttpServletResponse response = new MockHttpServletResponse();

	public void testRedirect() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");

		// �����÷�,map����ModelAndView�е�Model.
		ModelAndView mv = new ModelAndView(new RedirectView("/foo/bar.jsp"), map);

		// ������getModel()��DispatcherServlet����getModelInternal��һ����.
		mv.getView().render(mv.getModel(), request, response);

		assertEquals(response.getRedirectedUrl(), "/foo/bar.jsp?key1=value1&key2=value2");
	}

	public void testWrongRedirect() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");

		// �����÷�,map����ModelAndView��Model��һ��key/value����...
		ModelAndView mv = new ModelAndView(new RedirectView("/foo/bar.jsp"), "model", map);

		// ������getModel()��DispatcherServlet����getModelInternal��һ����.
		mv.getView().render(mv.getModel(), request, response);

		assertTrue(response.getRedirectedUrl().contains("/foo/bar.jsp?model="));
	}
}