package common.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class PageAccessControl extends HttpServlet
{
	/**
	 * serialVersionUIDϵͳ���
	 */
	private static final long serialVersionUID = 1L;
	
	static Logger log = Logger.getLogger(PageAccessControl.class);
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // ����error.jspҳ��
		request.setAttribute("message", "�Ƿ���ҳ����!(��ܰ��ʾ��û�е�½���Сʱû��ʹ�ñ�ϵͳ����ϵͳʧȥ����)");
        getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
}