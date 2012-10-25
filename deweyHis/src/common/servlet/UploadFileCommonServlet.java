package common.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

public class UploadFileCommonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4438071748957895870L;
	
	private static final String CONTENT_TYPE = "text/html; charset=GBK";

	// Initialize global variables
	public void init() throws ServletException {
	}

	// Process the HTTP Get request
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		// PrintWriter out = response.getWriter();
		// String act = request.getParameter("act");
		String fileExt = null; // �ļ���׺��

		FileItem fileItem = null; // �ļ���

		FileItem fileItem1 = null; // �ļ���
		int nownode = 0; // ���ִ�еĴ���
		int contractModelID = 0;

		FileUpload diskFileUpload = new FileUpload();
		// �����ļ���󳤶�
		diskFileUpload.setSizeMax(100 * 1024 * 1024);
		diskFileUpload.setHeaderEncoding("GBK");

		String strDirPath = new File(request.getSession().getServletContext().getRealPath(request.getRequestURI())).getParent();
		System.out.println("Ŀ¼��·��:" + strDirPath );

		List<?> fileItems = null;
		try {
			fileItems = diskFileUpload.parseRequest((RequestContext)(new ServletRequestContext(request)));
		} catch (FileUploadException ex) {
			System.out.println("fileuploadEX in HtfbWServlet :" + ex);
		}
		Iterator<?> iter = fileItems.iterator();
		while (iter.hasNext()) {
			fileItem = (FileItem) iter.next();
			if (fileItem.isFormField()) {
				// ��ǰ��һ������
				System.out.println(fileItem.getFieldName());
			} else {
				// ��ǰ��һ���ϴ����ļ�
				fileItem1 = fileItem; // ������ļ�,��fileItem������һ��fileItem1.
				String fileName = fileItem.getName();
				fileExt = fileName.substring(fileName.length() - 4);// �ļ���׺��,��Բ��"."
			}
		}

		try {
			// ��ʼ�ϴ�
			String file = strDirPath + "\\tmp\\user" + fileExt;
			fileItem1.write(new File(file));
		} catch (Exception ex1) {
			System.out.println("fileuploadEX in HtfbWServlet :" + ex1);
		}
		response.sendRedirect("yewu/czzhihou.jsp?nownode=" + nownode + "&basicRollID=" + contractModelID);
		
	}

	// Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// Clean up resources
	public void destroy() {
	}
}