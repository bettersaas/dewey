package common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 检测Servlet上下文的建立和销毁
 * 检测Servlet上下文属性的变化
 * @author Administrator
 *
 */
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
	
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("【监听到】应用被启动!");
		ServletContext context = arg0.getServletContext();
		String email = context.getInitParameter("email");
		if (email != null) {
			context.setAttribute("email", email);
		}
		String  webAppRootKey = context.getInitParameter("webAppRootKey");
		if (webAppRootKey != null) {
			context.setAttribute("webAppRootKey", webAppRootKey);
		}
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("【监听到】应用被关闭!");
	}
	
	
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("【监听到】ServletContext对象中新增一名为" + arg0.getName() + "的属性,其属性值为:" + arg0.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("【监听到】ServletContext对象中一名为" + arg0.getName() + "的属性被删除!");
	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("【监听到】ServletContext对象中一名为" + arg0.getName() + "的属性被更新!");
	}
	
}