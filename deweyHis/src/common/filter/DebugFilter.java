package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ϵͳ���Ը���������
 * @author Administrator
 *
 */
public class DebugFilter implements Filter {
	
	private FilterConfig config;
	
	private ServletContext context;
	
	private String filterName;
	
	private boolean debug;
	
	private boolean log;
	
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
		this.context = config.getServletContext();
		this.filterName = config.getFilterName();
		// �Ƿ���Կ���
		debug = Boolean.valueOf(arg0.getInitParameter("debug"));
		// �Ƿ�����־
		log = Boolean.valueOf(arg0.getInitParameter("log"));
	}
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		if (debug) {
			
		}
		if (log) {
			context.log(request.getRemoteHost() + " �Է��� " + request.getRequestURL() + " �� " + new java.util.Date() + "ʱ��(�ɹ�����" + filterName + "����)");
		}
		arg2.doFilter(request, response);
	}

	public void destroy() {
		
	}
}