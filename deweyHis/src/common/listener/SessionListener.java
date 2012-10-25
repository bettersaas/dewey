package common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ���Ự����������
 * ���Ự���Ա仯
 * @author Administrator
 *
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	// 
	private int totalSessionCount = 0;
	// ��������ͳ��
	private int currentSessionCount = 0;
	// 
	private int maxSessionCount = 0;
	// 
	private ServletContext context = null;
	
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		
		// ����������1
		this.currentSessionCount++;
		this.totalSessionCount++;
		if (currentSessionCount > maxSessionCount) {
			maxSessionCount = currentSessionCount;
		}
		
		if (context == null) {
			context = session.getServletContext();
			context.setAttribute("sessionCounter", this);
		}
		
		System.out.println("�������������û�" + session.getId() + "���ߣ�");
		System.out.println("�������û�����" + this.currentSessionCount + "��");
	}
	
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		// ����������1
		this.currentSessionCount--;
		System.out.println("�������������û�" + session.getId() + "���ߣ�");
		System.out.println("�������û�����" + this.currentSessionCount + "��");
	}
	
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		System.out.println("����������HttpSession����������һ��Ϊ" + arg0.getName() + "������,������ֵΪ" + arg0.getValue());
	}
	
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("����������HttpSession������һ��Ϊ" + arg0.getName() + "�����Ա�ɾ��!");
	}
	
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("����������HttpSession������һ��Ϊ" + arg0.getName() + "�����Ա��޸ģ�");
	}
	
	public void checkAttribute(HttpSessionBindingEvent event, String attributeName) {
		String currAttributeName = event.getName();
		Object currAttributeValue = event.getValue();
		if (currAttributeValue != null) {
			if (currAttributeValue instanceof Number) {
				System.out.println("����������HttpSession key:" + currAttributeName + " value:" + currAttributeValue);
			} else if (currAttributeValue instanceof String) {
				System.out.println("����������HttpSession key:" + currAttributeName + " value:" + currAttributeValue);
			} else if (currAttributeValue instanceof List) {
				System.out.println("����������HttpSession key:" + currAttributeName + " value:" + currAttributeValue);
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