package common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 检测会话创建和销毁
 * 检测会话属性变化
 * @author Administrator
 *
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	// 
	private int totalSessionCount = 0;
	// 在线人数统计
	private int currentSessionCount = 0;
	// 
	private int maxSessionCount = 0;
	// 
	private ServletContext context = null;
	
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		
		// 在线人数加1
		this.currentSessionCount++;
		this.totalSessionCount++;
		if (currentSessionCount > maxSessionCount) {
			maxSessionCount = currentSessionCount;
		}
		
		if (context == null) {
			context = session.getServletContext();
			context.setAttribute("sessionCounter", this);
		}
		
		System.out.println("【监听到】新用户" + session.getId() + "上线！");
		System.out.println("【在线用户数】" + this.currentSessionCount + "人");
	}
	
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		// 在线人数减1
		this.currentSessionCount--;
		System.out.println("【监听到】新用户" + session.getId() + "下线！");
		System.out.println("【在线用户数】" + this.currentSessionCount + "人");
	}
	
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("【监听到】HttpSession对象中新增一名为" + arg0.getName() + "的属性,其属性值为" + arg0.getValue());
	}
	
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("【监听到】HttpSession对象中一名为" + arg0.getName() + "的属性被删除!");
	}
	
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("【监听到】HttpSession对象中一名为" + arg0.getName() + "的属性被修改！");
	}
	
	public void checkAttribute(HttpSessionBindingEvent event, String attributeName) {
		String currAttributeName = event.getName();
		Object currAttributeValue = event.getValue();
		if (currAttributeValue != null) {
			if (currAttributeValue instanceof Number) {
				System.out.println("【监听到】HttpSession key:" + currAttributeName + " value:" + currAttributeValue);
			} else if (currAttributeValue instanceof String) {
				System.out.println("【监听到】HttpSession key:" + currAttributeName + " value:" + currAttributeValue);
			} else if (currAttributeValue instanceof List) {
				System.out.println("【监听到】HttpSession key:" + currAttributeName + " value:" + currAttributeValue);
			}
		}
	}
	
	
	public int getTotalSessionCount() {
		return totalSessionCount;
	}

	public void setTotalSessionCount(int totalSessionCount) {
		this.totalSessionCount = totalSessionCount;
	}

	public int getCurrentSessionCount() {
		return currentSessionCount;
	}

	public void setCurrentSessionCount(int currentSessionCount) {
		this.currentSessionCount = currentSessionCount;
	}

	public int getMaxSessionCount() {
		return maxSessionCount;
	}

	public void setMaxSessionCount(int maxSessionCount) {
		this.maxSessionCount = maxSessionCount;
	}

}