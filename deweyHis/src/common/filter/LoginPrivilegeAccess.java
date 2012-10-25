package common.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.GregorianCalendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.dewey.his.common.model.Mer;
import com.dewey.his.sys.model.MerUser;
import common.core.webcontext.ContextRef;
import common.servlet.ServletUtility;

/**
 * 权限访问过滤器
 * @author Administrator
 *
 */
public class LoginPrivilegeAccess implements Filter {

	private Logger logger = Logger.getLogger(LoginPrivilegeAccess.class);

	// 不需要过滤的以逗号分割的url列表
	private String nofilter;
	private String nofilterUrls[];
	// 没有通过权限的提示页面
	private String sendRedirect;
	// 反常时间开始和结束时间h
	private int startTime,endTime;
	
	private ApplicationContext ctx;

	public void init(FilterConfig config) throws ServletException {
		ctx = ContextRef.getContext();
		/**
		 * 时间过滤
		 */
		try {
			this.startTime = Integer.parseInt(config.getInitParameter("startTime"));
			this.endTime = Integer.parseInt(config.getInitParameter("endTime"));
		} catch (NumberFormatException ex) {
			this.startTime =  -1;
			this.endTime  =  -1;
		}
		/**
		 * url过滤
		 */
		this.nofilter = config.getInitParameter("nofilter");  // 不做检查的URL列表，以分号分开，并且 URL 中不包括 ContextPath 
		this.nofilterUrls = nofilter.split(",");
		this.sendRedirect = config.getInitParameter("sendRedirect");
		logger.info("Filter中无需过滤路径：" + Arrays.asList(nofilterUrls));
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String path = request.getServletPath();
		String uri    = request.getRequestURI();	// 等同于request.getContextPath()+path
		String ip = request.getRemoteAddr();	// Ip地址的获取
		logger.info("Filter用户ServletPath：" + path + " RequestURI：" + uri +" RemoteAddr：" + ip);
		
		/**
		 * 时间过滤
		 */
		if (startTime != -1 && endTime != -1) {
			GregorianCalendar calendar = new GregorianCalendar();
			int currentTime = calendar.get(GregorianCalendar.HOUR_OF_DAY);
			if (isUnusualTime(currentTime, startTime, endTime)) {
				logger.info("1个反常时间访问遭到拒绝!");
				ServletUtility.showWarning(response, "1个反常时间访问遭到拒绝!");
				response.sendRedirect(request.getContextPath()+sendRedirect);
				return;
			}
		}
		/**
		 * url过滤
		 */
		if (isInArray(path, nofilterUrls)) {
			logger.info("无需过滤");
		} else if (checkUser(request, response)) {
			logger.info("访问权限通过");
		} else {
			logger.info("1个非法请求!");
			response.sendRedirect(request.getContextPath()+sendRedirect); // 等同于request.getRequestDispatcher(request.getContextPath()+"/index.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		logger.info(ctx.toString() + "卸载...");
		ctx = null;
	}
	
	/**
	 * 通过后缀检查是否需要权限过滤的文件
	 * @param path
	 * @param nofilterFiles
	 * @return
	 */
	private boolean isInArray(String path, String nofilterFiles[]) {
		// 检查是否是网页资源
		String resource = path.toLowerCase();
		if (resource.endsWith(".css") || resource.endsWith(".js") || resource.endsWith(".gif") || resource.endsWith(".jpg") || resource.endsWith(".htm") || resource.endsWith(".html")) {
			return true;
		}
		// 检查是否是不受限的jsp和视图页面
		for (int i = 0; i < nofilterFiles.length; i++) {
			String nofilterFile = nofilterFiles[i];
			if (nofilterFile.equals(path)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 通过session检查用户是否已登录
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private boolean checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);//如果不存在返回空
		// session没有建立
		if (session == null) {
			logger.info("session还没建立");
			return false;
		}
		
		MerUser sessionUser = (MerUser)session.getAttribute("MER_USER");
		if (sessionUser == null || sessionUser.getLoginName() == null) {
			logger.info("session中用户信息为空");
			return false;
		}
		
		Mer mer = (Mer)session.getAttribute("MER");
		if (mer == null || mer.getId() == null) {
			logger.info("session中商户信息为空");
			return false;
		}
		return true;
	}
	
	/**
	 * 反常时间检测
	 * @param currentTime
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	private boolean isUnusualTime(int currentTime, int startTime, int endTime) {  
	   if (startTime < endTime) {
	       return ((currentTime >= startTime) && (currentTime < endTime));
	   } else {
	       return (!isUnusualTime(currentTime, endTime, startTime));
	   }
	}
}