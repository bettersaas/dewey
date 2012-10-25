package common.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类似功能参考SimpleMappingExceptionResolver
 * 
 * @author Administrator
 * 
 */
public class ExceptionResolver implements HandlerExceptionResolver {

	protected Logger fileLogger = Logger.getLogger("fileLog");

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handle, Exception exception) {
		fileLogger.error("捕获异常： ", exception);
		ModelAndView mav = new ModelAndView();
		
		if(!(request.getHeader("accept").indexOf("application/json")>-1 || request.getHeader("X-Requested-With").indexOf("XMLHttpRequest")>-1)){//如果不是异步请求  
			if (exception instanceof IOException  || exception instanceof SQLException) {
				mav.setViewName("forward:/commons/error.jsp");
				mav.addObject("message", "系统运行期异常 -- System Error");
			} else {
				mav.setViewName("forward:/commons/exception.jsp");
				mav.addObject("message", "系统运行期异常 -- System Runtime Error");
			}
			return mav;
        }else{//JSON格式返回  
            try {  
                response.getWriter().write("有异常啦!");  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            return new ModelAndView();  
        } 
	}
}