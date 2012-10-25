package common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * ��Controller������֮ǰ��ִ�У����ص�booleanֵ�����Ƿ���Handler Interceptor����Controller����������
	 * �������false�����������Interceptor��Controller�Ͳ���������
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info(handler.getClass().getName() + " ��ʼִ��...");
		return true;
	}
	
	/**
	 * ����Controller��������֮��ִ�С�
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		if(modelAndView != null) {
			logger.info("��ͼ����" + modelAndView.getViewName());
		}
		logger.info(handler.getClass().getName() + " ִ�����...");
	}

	/**
	 * ����View�������֮��ִ�С�
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
		if (ex != null) {
			logger.info(handler.getClass().getName() + "    " + ex.getMessage());
		}
		logger.info(handler.getClass().getName() + " ���������...");
	}
}
