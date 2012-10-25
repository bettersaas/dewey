package common.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 对请求的监听
 * @author Administrator
 *
 */
public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	
	private static ArrayList<Long> requestRecords = null;
	
	// 设置是否计数结束
	private static boolean countingFinished  = true;
	
	// 请求频率  每秒请求次数统计
	private static double ratio  = 0.0;
	
	public void requestInitialized(ServletRequestEvent arg0) {
		if (countingFinished) {
			return;
		}
		if (requestRecords == null) {
			ServletContext context = arg0.getServletContext();
			requestRecords = new ArrayList<Long>();
			context.setAttribute("requestRecords", requestRecords);
		}
		requestRecords.add(System.currentTimeMillis());
	}

	public void requestDestroyed(ServletRequestEvent arg0) {

	}

	
	public void attributeAdded(ServletRequestAttributeEvent arg0) {

	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {

	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {

	}
	
	
	public static boolean isCountingFinished() {
		return countingFinished;
	}

	public static void setCountingFinished(boolean countingFinished) {
		RequestListener.countingFinished = countingFinished;
	}
	
	public static double getRatio() {
		if (countingFinished) {
			return 0.0;
		}
		if (requestRecords == null || requestRecords.isEmpty()) {
			return 0.0;
		}
		long firstMillis = requestRecords.get(0);
		int totalRequests = requestRecords.size();
		long lastMillis = requestRecords.get(totalRequests - 1);
		double rate = totalRequests/(double)((lastMillis-firstMillis)/1000);
		RequestListener.ratio = ((int)(rate*100)/(double)100);
		return RequestListener.ratio ;
	}

	public static void setRatio(double ratio) {
		RequestListener.ratio = ratio;
	}
}