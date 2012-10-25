package org.apache.jsp.commons;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import org.apache.log4j.Logger;
import java.io.FileInputStream;

public final class downLoadExpFile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n\r\n\r\n");

	
	try{
		String filename = request.getParameter("fileName");
		if(filename==null||filename.length()==0)
			filename =(String)request.getAttribute("fileName");
		System.out.println("filename="+filename);
		if(filename==null||filename.length()==0){
			filename="data.cvs.html.xls";
		} 
		InputStream inStream=(InputStream)request.getAttribute("contentStream");
		System.out.println("InputStream >>>" + inStream.toString());
		String sFileExp = "" ;
		//设置输出的格式
	  	response.reset();
		int iIndex = filename.lastIndexOf(".") ;
		if( iIndex != -1 ){
			sFileExp = filename.substring(iIndex+1) ;
		}
		response.addHeader("Extension",sFileExp);  //设置扩展名
		System.out.println("Extension = " + sFileExp);
	  	//response.addHeader("Content-Disposition","inline; filename=\"" + filename + "\"");   //直接打开
	  	//弹出保存对话框
	  	response.setHeader("Content-Disposition", "attachment; filename=\"" + new String(filename.getBytes(),"ISO-8859-1") + "\""); 
		response.setHeader("Accept-ranges", "bytes");
		response.setContentType("application/x-filler");
	 	//循环取出流中的数据
	  	byte[] b = new byte[1024];
	  	int len;
	  	while((len=inStream.read(b)) !=-1) {
	  		response.getOutputStream().write(b,0,len);
	  	}
	  	inStream.close();
	 }catch(Exception e){
	  	response.setContentType("text/html;charset=GBK");
	  	
      out.write("\r\n\t\t下载文件失败。\t\r\n\t  \t");

	  	out.close();
  	 }

    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
