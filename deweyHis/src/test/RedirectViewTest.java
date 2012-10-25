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

		// 这种用法,map就是ModelAndView中的Model.
		ModelAndView mv = new ModelAndView(new RedirectView("/foo/bar.jsp"), map);

		// 这里用getModel()与DispatcherServlet中用getModelInternal是一样的.
		mv.getView().render(mv.getModel(), request, response);

		assertEquals(response.getRedirectedUrl(), "/foo/bar.jsp?key1=value1&key2=value2");
	}

	public void testWrongRedirect() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");

		// 这种用法,map就是ModelAndView中Model的一个key/value对了...
		ModelAndView mv = new ModelAndView(new RedirectView("/foo/bar.jsp"), "model", map);

		// 这里用getModel()与DispatcherServlet中用getModelInternal是一样的.
		mv.getView().render(mv.getModel(), request, response);

		assertTrue(response.getRedirectedUrl().contains("/foo/bar.jsp?model="));
	}
}