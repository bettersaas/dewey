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
 * 系统调试辅助过滤器
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
		// 是否调试开启
		debug = Boolean.valueOf(arg0.getInitParameter("debug"));
		// 是否开启日志
		log = Boolean.valueOf(arg0.getInitParameter("log"));
	}
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		if (debug) {
			
		}
		if (log) {
			context.log(request.getRemoteHost() + " 试访问 " + request.getRequestURL() + " 在 " + new java.util.Date() + "时。(由过滤器" + filterName + "报告)");
		}
		arg2.doFilter(request, response);
	}

	public void destroy() {
		
	}
}