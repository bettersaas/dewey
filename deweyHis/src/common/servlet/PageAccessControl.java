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
	 * serialVersionUID系统添加
	 */
	private static final long serialVersionUID = 1L;
	
	static Logger log = Logger.getLogger(PageAccessControl.class);
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // 导向error.jsp页面
		request.setAttribute("message", "非法网页请求!(温馨提示：没有登陆或半小时没有使用本系统已与系统失去连接)");
        getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
}