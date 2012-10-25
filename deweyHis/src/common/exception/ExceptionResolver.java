package common.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * ���ƹ��ܲο�SimpleMappingExceptionResolver
 * 
 * @author Administrator
 * 
 */
public class ExceptionResolver implements HandlerExceptionResolver {

	protected Logger fileLogger = Logger.getLogger("fileLog");

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handle, Exception exception) {
		fileLogger.error("�����쳣�� ", exception);
		ModelAndView mav = new ModelAndView();
		
		if(!(request.getHeader("accept").indexOf("application/json")>-1 || request.getHeader("X-Requested-With").indexOf("XMLHttpRequest")>-1)){//��������첽����  
			if (exception instanceof IOException  || exception instanceof SQLException) {
				mav.setViewName("forward:/commons/error.jsp");
				mav.addObject("message", "ϵͳ�������쳣 -- System Error");
			} else {
				mav.setViewName("forward:/commons/exception.jsp");
				mav.addObject("message", "ϵͳ�������쳣 -- System Runtime Error");
			}
			return mav;
        }else{//JSON��ʽ����  
            try {  
                response.getWriter().write("���쳣��!");  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            return new ModelAndView();  
        } 
	}
}