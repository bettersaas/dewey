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
 * Ȩ�޷��ʹ�����
 * @author Administrator
 *
 */
public class LoginPrivilegeAccess implements Filter {

	private Logger logger = Logger.getLogger(LoginPrivilegeAccess.class);

	// ����Ҫ���˵��Զ��ŷָ��url�б�
	private String nofilter;
	private String nofilterUrls[];
	// û��ͨ��Ȩ�޵���ʾҳ��
	private String sendRedirect;
	// ����ʱ�俪ʼ�ͽ���ʱ��h
	private int startTime,endTime;
	
	private ApplicationContext ctx;

	public void init(FilterConfig config) throws ServletException {
		ctx = ContextRef.getContext();
		/**
		 * ʱ�����
		 */
		try {
			this.startTime = Integer.parseInt(config.getInitParameter("startTime"));
			this.endTime = Integer.parseInt(config.getInitParameter("endTime"));
		} catch (NumberFormatException ex) {
			this.startTime =  -1;
			this.endTime  =  -1;
		}
		/**
		 * url����
		 */
		this.nofilter = config.getInitParameter("nofilter");  // ��������URL�б��Էֺŷֿ������� URL �в����� ContextPath 
		this.nofilterUrls = nofilter.split(",");
		this.sendRedirect = config.getInitParameter("sendRedirect");
		logger.info("Filter���������·����" + Arrays.asList(nofilterUrls));
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String path = request.getServletPath();
		String uri    = request.getRequestURI();	// ��ͬ��request.getContextPath()+path
		String ip = request.getRemoteAddr();	// Ip��ַ�Ļ�ȡ
		logger.info("Filter�û�ServletPath��" + path + " RequestURI��" + uri +" RemoteAddr��" + ip);
		
		/**
		 * ʱ�����
		 */
		if (startTime != -1 && endTime != -1) {
			GregorianCalendar calendar = new GregorianCalendar();
			int currentTime = calendar.get(GregorianCalendar.HOUR_OF_DAY);
			if (isUnusualTime(currentTime, startTime, endTime)) {
				logger.info("1������ʱ������⵽�ܾ�!");
				ServletUtility.showWarning(response, "1������ʱ������⵽�ܾ�!");
				response.sendRedirect(request.getContextPath()+sendRedirect);
				return;
			}
		}
		/**
		 * url����
		 */
		if (isInArray(path, nofilterUrls)) {
			logger.info("�������");
		} else if (checkUser(request, response)) {
			logger.info("����Ȩ��ͨ��");
		} else {
			logger.info("1���Ƿ�����!");
			response.sendRedirect(request.getContextPath()+sendRedirect); // ��ͬ��request.getRequestDispatcher(request.getContextPath()+"/index.jsp").forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {
		logger.info(ctx.toString() + "ж��...");
		ctx = null;
	}
	
	/**
	 * ͨ����׺����Ƿ���ҪȨ�޹��˵��ļ�
	 * @param path
	 * @param nofilterFiles
	 * @return
	 */
	private boolean isInArray(String path, String nofilterFiles[]) {
		// ����Ƿ�����ҳ��Դ
		String resource = path.toLowerCase();
		if (resource.endsWith(".css") || resource.endsWith(".js") || resource.endsWith(".gif") || resource.endsWith(".jpg") || resource.endsWith(".htm") || resource.endsWith(".html")) {
			return true;
		}
		// ����Ƿ��ǲ����޵�jsp����ͼҳ��
		for (int i = 0; i < nofilterFiles.length; i++) {
			String nofilterFile = nofilterFiles[i];
			if (nofilterFile.equals(path)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * ͨ��session����û��Ƿ��ѵ�¼
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private boolean checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);//��������ڷ��ؿ�
		// sessionû�н���
		if (session == null) {
			logger.info("session��û����");
			return false;
		}
		
		MerUser sessionUser = (MerUser)session.getAttribute("MER_USER");
		if (sessionUser == null || sessionUser.getLoginName() == null) {
			logger.info("session���û���ϢΪ��");
			return false;
		}
		
		Mer mer = (Mer)session.getAttribute("MER");
		if (mer == null || mer.getId() == null) {
			logger.info("session���̻���ϢΪ��");
			return false;
		}
		return true;
	}
	
	/**
	 * ����ʱ����
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