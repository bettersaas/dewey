package common.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����ѹ����servlet
 * @author Administrator
 *
 */
public class LongServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6976195135072971823L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
//		// �����֧��ѹ�����ƶ�ѹ��
//		if (GzipUtility.isGzipSupported(request) && (GzipUtility.isGzipEnabled(request))) {
//			out = GzipUtility.getGzipWriter(response);
//			response.setHeader("Content-Encoding", "gzip");
//		} else {
//			out = response.getWriter();
//		}
		String strTitle = "ѹ��ҳ��";
		ServletUtility.getHeadWithTitle(strTitle);
		out.println("<BODY bgcolor=#fdf5e6>");
		out.println("<h1 algin=center>" + strTitle + "</h1>");
		String line = "��ã���Щ��Ҫѹ���Ķ�����";
		for (int i = 0; i < 10000; i++) {
			out.println(line);
		}
		out.println("</BODY></HTML>");
		out.close();
	}
}