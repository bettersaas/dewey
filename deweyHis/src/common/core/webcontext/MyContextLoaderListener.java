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
 * 接管Spring的web-context的初始化

 如下Spring在web.xml的标准配置
 <!--Spring ApplicationContext 载入 -->
 <!-- Spring Listener Config -->
 <listener>
 <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
 </listener>

 修改为：

 <!-- Spring Listener Config -->
 <listener>
 <listener-class>common.core.webcontext.MyContextLoaderListener</listener-class>
 </listener>

 原理：
 ContextLoaderListener类里面有一个contextInitialized方法，这个方法用于初始化context。
 通过扩展ContextLoaderListener，我们可以很方便得获取到ApplicationContext。

 * @author LHG
 */
public class MyContextLoaderListener extends ContextLoaderListener {

	@SuppressWarnings("static-access")
	public void contextInitialized(ServletContextEvent event) {
		/**
		 * 获取当前jdk版本信息
		 */
		JdkVersion jdkVersion = new JdkVersion() {
		};
		/**
		 * 获取当前Spring版本信息
		 */
		SpringVersion springVersion = new SpringVersion();
		// 获取bundle
		ResourceBundle version = ResourceBundle.getBundle("version");
		System.out.println("**********************************************************************************");
		System.out.println("*");
		System.out.println("*     o(∩_∩)o   deweyHis  Application Starting.......... ");
		System.out.println("*");
		System.out.println("*                                " + version.getString("major.build.version") + "  " + version.getString("build.timestamp"));
		System.out.println("*                                " + version.getString("build.frame"));
		System.out.println("*       当前Spring版本： " + springVersion.getVersion());
		System.out.println("*       当前JDK版本：    " + jdkVersion.getJavaVersion());
		System.out.println("**********************************************************************************");
		System.out.println("*************************************系统属性检索*********************************");
		Properties props = System.getProperties();
		System.out.println("Java的运行环境版本：" + props.getProperty("java.version"));
		System.out.println("Java的运行环境供应商：" + props.getProperty("java.vendor"));
		System.out.println("Java的类路径：" + props.getProperty("java.class.path"));
		System.out.println("默认的临时文件路径：" + props.getProperty("java.io.tmpdir"));
		System.out.println("操作系统的名称：" + props.getProperty("os.name"));
		System.out.println("操作系统的构架：" + props.getProperty("os.arch"));
		System.out.println("操作系统的版本：" + props.getProperty("os.version"));
		System.out.println("文件分隔符：" + props.getProperty("file.separator")); //在 unix 系统中是＂／＂
		System.out.println("路径分隔符：" + props.getProperty("path.separator")); //在 unix 系统中是＂:＂
		System.out.println("行分隔符：" + props.getProperty("line.separator")); //在 unix 系统中是＂/n＂
		System.out.println("用户的账户名称：" + props.getProperty("user.name"));
		System.out.println("用户的主目录：" + props.getProperty("user.home"));
		System.out.println("用户的当前工作目录：" + props.getProperty("user.dir"));
		System.out.println("***********************************系统属性检索完毕******************************");
		super.contextInitialized(event);
		ServletContext context = event.getServletContext();
		// 获取web环境下的ApplicationContext
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		// 将ApplicationContext，set到ContextUtil的静态变量context
		ContextRef.setContext(ctx);
		String jdbcUrl = (String)ctx.getBean("jdbcUrl");
		String username = (String)ctx.getBean("jdbcUsername");
		System.out.println("****数据库信息URL:" + jdbcUrl + "    UserName: " + username + " ***");
		System.out.println("*********************Spring3.0的应用程序成功启动...........*********************");
	}
}