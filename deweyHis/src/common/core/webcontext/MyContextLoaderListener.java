package common.core.webcontext;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.core.JdkVersion;
import org.springframework.core.SpringVersion;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * �ӹ�Spring��web-context�ĳ�ʼ��

 ����Spring��web.xml�ı�׼����
 <!--Spring ApplicationContext ���� -->
 <!-- Spring Listener Config -->
 <listener>
 <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
 </listener>

 �޸�Ϊ��

 <!-- Spring Listener Config -->
 <listener>
 <listener-class>common.core.webcontext.MyContextLoaderListener</listener-class>
 </listener>

 ԭ��
 ContextLoaderListener��������һ��contextInitialized����������������ڳ�ʼ��context��
 ͨ����չContextLoaderListener�����ǿ��Ժܷ���û�ȡ��ApplicationContext��

 * @author LHG
 */
public class MyContextLoaderListener extends ContextLoaderListener {

	@SuppressWarnings("static-access")
	public void contextInitialized(ServletContextEvent event) {
		/**
		 * ��ȡ��ǰjdk�汾��Ϣ
		 */
		JdkVersion jdkVersion = new JdkVersion() {
		};
		/**
		 * ��ȡ��ǰSpring�汾��Ϣ
		 */
		SpringVersion springVersion = new SpringVersion();
		// ��ȡbundle
		ResourceBundle version = ResourceBundle.getBundle("version");
		System.out.println("**********************************************************************************");
		System.out.println("*");
		System.out.println("*     o(��_��)o   deweyHis  Application Starting.......... ");
		System.out.println("*");
		System.out.println("*                                " + version.getString("major.build.version") + "  " + version.getString("build.timestamp"));
		System.out.println("*                                " + version.getString("build.frame"));
		System.out.println("*       ��ǰSpring�汾�� " + springVersion.getVersion());
		System.out.println("*       ��ǰJDK�汾��    " + jdkVersion.getJavaVersion());
		System.out.println("**********************************************************************************");
		System.out.println("*************************************ϵͳ���Լ���*********************************");
		Properties props = System.getProperties();
		System.out.println("Java�����л����汾��" + props.getProperty("java.version"));
		System.out.println("Java�����л�����Ӧ�̣�" + props.getProperty("java.vendor"));
		System.out.println("Java����·����" + props.getProperty("java.class.path"));
		System.out.println("Ĭ�ϵ���ʱ�ļ�·����" + props.getProperty("java.io.tmpdir"));
		System.out.println("����ϵͳ�����ƣ�" + props.getProperty("os.name"));
		System.out.println("����ϵͳ�Ĺ��ܣ�" + props.getProperty("os.arch"));
		System.out.println("����ϵͳ�İ汾��" + props.getProperty("os.version"));
		System.out.println("�ļ��ָ�����" + props.getProperty("file.separator")); //�� unix ϵͳ���ǣ�����
		System.out.println("·���ָ�����" + props.getProperty("path.separator")); //�� unix ϵͳ���ǣ�:��
		System.out.println("�зָ�����" + props.getProperty("line.separator")); //�� unix ϵͳ���ǣ�/n��
		System.out.println("�û����˻����ƣ�" + props.getProperty("user.name"));
		System.out.println("�û�����Ŀ¼��" + props.getProperty("user.home"));
		System.out.println("�û��ĵ�ǰ����Ŀ¼��" + props.getProperty("user.dir"));
		System.out.println("***********************************ϵͳ���Լ������******************************");
		super.contextInitialized(event);
		ServletContext context = event.getServletContext();
		// ��ȡweb�����µ�ApplicationContext
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		// ��ApplicationContext��set��ContextUtil�ľ�̬����context
		ContextRef.setContext(ctx);
		String jdbcUrl = (String)ctx.getBean("jdbcUrl");
		String username = (String)ctx.getBean("jdbcUsername");
		System.out.println("****���ݿ���ϢURL:" + jdbcUrl + "    UserName: " + username + " ***");
		System.out.println("*********************Spring3.0��Ӧ�ó���ɹ�����...........*********************");
	}
}