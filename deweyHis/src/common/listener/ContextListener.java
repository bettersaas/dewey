package common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ���Servlet�����ĵĽ���������
 * ���Servlet���������Եı仯
 * @author Administrator
 *
 */
public class ContextListener implements ServletContextListener, ServletContextAttributeListener {
	
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("����������Ӧ�ñ�����!");
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
		System.out.println("����������Ӧ�ñ��ر�!");
	}
	
	
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		System.out.println("����������ServletContext����������һ��Ϊ" + arg0.getName() + "������,������ֵΪ:" + arg0.getValue());
	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		System.out.println("����������ServletContext������һ��Ϊ" + arg0.getName() + "�����Ա�ɾ��!");
	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		System.out.println("����������ServletContext������һ��Ϊ" + arg0.getName() + "�����Ա�����!");
	}
	
}