package common.util.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * ¶ÁÈ¡PropertiesÎÄ¼þ
 * @author Administrator
 *
 */
public class ReadProperties {
	
	public Properties  read1 (String name) throws IOException {
		InputStream in=new BufferedInputStream(new FileInputStream(name)); 
		Properties p=new Properties();
		p.load(in);
		return p;
	}
	
	public ResourceBundle  read2 (String name)  {
		ResourceBundle b=ResourceBundle.getBundle(name,Locale.getDefault());
		return b;
	}
	
	public ResourceBundle  read3 (String name) throws IOException {
		InputStream in=new BufferedInputStream(new FileInputStream(name));
		ResourceBundle b=new PropertyResourceBundle(in);
		return b;
	}
	
	public Properties read4(String name) throws IOException {
		InputStream in=ReadProperties.class.getResourceAsStream(name);
		Properties p=new Properties();
		p.load(in);
		return p;
	}
	
	public Properties read5(String name) throws IOException {
		InputStream in=ReadProperties.class.getClassLoader().getResourceAsStream(name); 
		Properties p=new Properties();
		p.load(in);
		return p;
	}
	
	public Properties read6(String name) throws IOException {
		InputStream in=ClassLoader.getSystemResourceAsStream(name); 
		Properties p=new Properties();
		p.load(in);
		return p;
	}
	
	public Properties read7(String path, HttpSession session) throws IOException {
		ServletContext context = session.getServletContext();
		InputStream in=context.getResourceAsStream(path); 
		Properties p=new Properties();
		p.load(in);
		return p;
	}
	
	public Properties read8(String path, ServletContext context) throws IOException {
		InputStream in=context.getResourceAsStream(path); 
		Properties p=new Properties();
		p.load(in);
		return p;
	}
}
