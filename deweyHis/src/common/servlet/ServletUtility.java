package common.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ServletUtility {

	public ServletUtility() {
	}

	public static final String DocType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";

	public static String getHeadWithTitle(String title) {
		return (DocType + "<HTML>\n" + "<HEAD>\n<TITLE>" + title + "</TITILE>\n</HEAD>\n");
	}
	
	/**
	 * 显示网页中的警告信息
	 * @param response
	 * @param message
	 * @throws IOException
	 */
	public static void showWarning(HttpServletResponse response,String message) throws IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.print(getHeadWithTitle("警告信息"));
		out.print("<BODY bgcolor=\"WHITE\">");
		out.print("<H1>Access Prohibited</H1>");
		out.print(message);
		out.print("</BODY>");
		out.print("</HTML>");
		out.close();
	}
}
