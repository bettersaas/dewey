package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class vertical_005fline_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=GB18030");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n<html>\r\n<head>\r\n<style>\r\n\tbody{\r\n\t\tmargin:0px;\r\n\t\tpadding:0px;\r\n\t\twidth:100%;\r\n\t\theight:100%;\r\n\t\tbackground: #e1eaf5;\r\n\t}\r\n</style>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html;charset=GBK\" />\r\n");

	String path         = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("basePath", basePath);

      out.write("\r\n<base href=\"");
      out.print(basePath);
      out.write("\">\r\n</head>\r\n<body>\r\n<img border=\"0\" style=\"cursor:hand;\" onclick=\"adjustFrame();\" src=\"images/menu_arrow.gif\" style=\"width:4px;height:7px;left:expression((document.body.clientWidth-this.width)/2);top:expression((document.body.clientHeight-this.height)/2);\" >\r\n<script>\r\nfunction adjustFrame(){\r\n\tif(top.document.getElementById('menu_frame').cols == \"200,5,*\"){\r\n\t\ttop.document.getElementById('menu_frame').cols = \"0,5,*\";\r\n\t}else{\r\n\t\ttop.document.getElementById('menu_frame').cols = \"200,5,*\";\r\n\t}\r\n\tsetmiddle();\r\n}\r\nfunction setmiddle(){\r\n\t\tvar broswer_height=document.body.clientHeight;\t//ÍøÒ³¹¤×÷ÇøµÄ¸ß document.body.scrollHeight\r\n\t\tvar broswer_width=document.body.clientWidth;\t\t//ÍøÒ³¹¤×÷ÇøµÄ¿í\r\n\t\tvar picture=document.getElementsByTagName(\"img\")[0];\r\n\t\tvar img_width=picture.width;\t\t//Í¼Æ¬¸ß\r\n\t\tvar img_height=picture.height;\t//Í¼Æ¬¿í\r\n\t\tposition_height=(broswer_height - img_height)/2;\t//Í¼Ïñ¶¥±ß¾à\r\n\t\tposition_width=(broswer_width - img_width)/2;\t\t//Í¼Ïñ×ó±ß¾à\r\n\t\t//ÈôÍ¼Ïñ³¬¹ýä¯ÀÀÆ÷¹¤×÷ÇøÓò´óÐ¡µÄÅÐ¶Ï\r\n\t\tif(position_height<=0)\r\n\t\t\tposition_height=0;\r\n\t\tif(position_width<=0)\r\n");
      out.write("\t\t\tposition_width=0;\r\n\t\tpicture.style.marginLeft=position_width;\r\n\t\tpicture.style.marginTop=position_height;\r\n}\r\nwindow.onload=function(){\r\n\tsetmiddle();\r\n}\r\nwindow.onresize=function(){\r\n\tsetmiddle();\r\n}\r\n</script>\r\n</body>\r\n</html>");
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
