package common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingInterceptor extends HandlerInterceptorAdapter {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 在Controller请求处理之前被执行，传回的boolean值决定是否让Handler Interceptor或是Controller来处理请求。
	 * 如果传回false，则接下来的Interceptor或Controller就不处理请求。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info(handler.getClass().getName() + " 开始执行...");
		return true;
	}
	
	/**
	 * 会在Controller处理请求之后被执行。
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		if(modelAndView != null) {
			logger.info("视图名：" + modelAndView.getViewName());
		}
		logger.info(handler.getClass().getName() + " 执行完毕...");
	}

	/**
	 * 会在View绘制完成之后被执行。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
		if (ex != null) {
			logger.info(handler.getClass().getName() + "    " + ex.getMessage());
		}
		logger.info(handler.getClass().getName() + " 请求处理完毕...");
	}
}
