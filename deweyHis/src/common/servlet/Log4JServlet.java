package common.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

/**

	<!-- Log4J init Servlet 	-->
	<servlet>
		<servlet-name>log4j</servlet-name>
		<servlet-class>common.servlet.Log4JServlet</servlet-class>
		<init-param>
			<param-name>propfile</param-name>
			<param-value>/WEB-INF/classes/log4j.properties</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	
 */
public class Log4JServlet extends HttpServlet {

	/**
	 * serialVersionUID系统所加
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException{
		//获得Log4J的属性配置文件
		String  path = getServletContext().getRealPath("/");
		String propfile = path + getInitParameter("propfile");
		
//		Properties props = new Properties();
//        try {
//            FileInputStream istream = new FileInputStream(filePath);
//            props.load(istream);
//            istream.close();
//            String logFile = prefix + props.getProperty("log4j.appender.R.File");//设置路径 
//            props.setProperty("log4j.appender.R.File",logFile);
//            // 装入log4j配置信息 
//            PropertyConfigurator.configure(props);
//        } catch (IOException e) {
//            System.out.println("Could not read configuration file [" + filePath + "].");
//            System.out.println("Ignoring configuration file [" + filePath + "].");
//            return;
//        }
		
		//对所有的Servlet初始化属性
		PropertyConfigurator.configure(propfile);
	}
}
